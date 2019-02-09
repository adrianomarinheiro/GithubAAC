package br.com.adrianomarinheiro.githubaac.di.modules


import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import android.arch.lifecycle.ViewModel
import br.com.adrianomarinheiro.githubaac.di.key.ViewModelKey
import br.com.adrianomarinheiro.githubaac.ui.userprofile.UserProfileViewModel
import br.com.adrianomarinheiro.githubaac.util.viewmodel.FactoryViewModel
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    abstract fun bindUserProfileViewModel(repoViewModel: UserProfileViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel): ViewModelProvider.Factory
}
