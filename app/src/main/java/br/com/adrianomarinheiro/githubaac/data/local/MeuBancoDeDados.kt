package br.com.adrianomarinheiro.githubaac.data.local

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.arch.persistence.room.Database
import br.com.adrianomarinheiro.githubaac.data.local.converter.DateConverter
import br.com.adrianomarinheiro.githubaac.data.local.dao.UserDao
import br.com.adrianomarinheiro.githubaac.data.local.entity.User


@Database(entities = [User::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class MeuBancoDeDados : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private val INSTANCE: MeuBancoDeDados? = null
    }
}
