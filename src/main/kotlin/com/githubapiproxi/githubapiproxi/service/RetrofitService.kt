package com.githubapiproxi.githubapiproxi.service

import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Service
class RetrofitService {

    val gitHubService: GitHubService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(GitHubService::class.java)
    }
}
