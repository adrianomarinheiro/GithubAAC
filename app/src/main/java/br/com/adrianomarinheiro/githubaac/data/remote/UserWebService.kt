package br.com.adrianomarinheiro.githubaac.data.remote

import br.com.adrianomarinheiro.githubaac.data.local.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserWebservice {
    @GET("/users/{user}")
    fun getUser(@Path("user") userId: String): Call<User>
}
