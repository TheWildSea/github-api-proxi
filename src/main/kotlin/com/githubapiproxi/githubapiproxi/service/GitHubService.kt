package com.githubapiproxi.githubapiproxi.service
import com.githubapiproxi.githubapiproxi.data.GitHubBranch
import com.githubapiproxi.githubapiproxi.data.GitHubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface GitHubService {

    @Headers("Authorization: Bearer YOUR_ACCESS_TOKEN_HERE", "Accept: application/vnd.github.v3+json")
    @GET("users/{username}/repos")
    fun listRepos(@Path("username") username: String): Call<List<GitHubRepo>>

    @Headers("Authorization: Bearer YOUR_ACCESS_TOKEN_HERE", "Accept: application/vnd.github.v3+json")
    @GET("repos/{owner}/{repo}/branches")
    fun listBranches(@Path("owner") owner: String, @Path("repo") repo: String): Call<List<GitHubBranch>>
}