package br.com.adrianomarinheiro.githubaac.di.modules
import android.app.Application
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import android.arch.persistence.room.Room
import br.com.adrianomarinheiro.githubaac.data.local.MeuBancoDeDados
import br.com.adrianomarinheiro.githubaac.data.local.dao.UserDao
import br.com.adrianomarinheiro.githubaac.data.remote.UserWebservice
import br.com.adrianomarinheiro.githubaac.data.repositories.UserRepository
import dagger.Module
import java.util.concurrent.Executor
import java.util.concurrent.Executors


@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): MeuBancoDeDados {
        return Room.databaseBuilder(
                application,
                MeuBancoDeDados::class.java, "MyDatabase.db"
        )
                .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: MeuBancoDeDados): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    @Singleton
    fun provideUserRepository(
            webservice: UserWebservice,
            userDao: UserDao,
            executor: Executor
    ): UserRepository {
        return UserRepository(webservice, userDao, executor)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): UserWebservice {
        return restAdapter.create(UserWebservice::class.java)
    }

    companion object {
        private val BASE_URL = "https://api.github.com/"
    }
}
