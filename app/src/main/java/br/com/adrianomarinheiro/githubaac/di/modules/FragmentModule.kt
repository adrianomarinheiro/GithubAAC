package br.com.adrianomarinheiro.githubaac.di.modules

import br.com.adrianomarinheiro.githubaac.ui.userprofile.UserProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeUserProfileFragment(): UserProfileFragment

}
