package br.com.adrianomarinheiro.githubaac.ui.userprofile
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

import javax.inject.Inject
import android.arch.lifecycle.ViewModel
import br.com.adrianomarinheiro.githubaac.data.local.entity.User
import br.com.adrianomarinheiro.githubaac.data.repositories.UserRepository

class UserProfileViewModel @Inject

constructor(private val userRepo: UserRepository) : ViewModel() {

    var user: LiveData<User> = MutableLiveData<User>()

    fun pesquisar(userId: String) {
        user = userRepo.getUser(userId)
    }
}
