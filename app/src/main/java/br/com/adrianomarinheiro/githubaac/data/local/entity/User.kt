package br.com.adrianomarinheiro.githubaac.data.local.entity
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class User(

        @PrimaryKey
        @SerializedName("id")
        @Expose
        var id: Int = 0,

        @SerializedName("login")
        @Expose
        var login: String = "",

        @SerializedName("avatar_url")
        @Expose
        var avatar_url: String = "",

        var lastRefresh: Date? = null
)

