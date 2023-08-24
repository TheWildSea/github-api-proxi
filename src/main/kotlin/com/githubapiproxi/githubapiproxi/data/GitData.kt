package com.githubapiproxi.githubapiproxi.data

data class GitHubRepo(
    val name: String,
    val owner: Owner,
    val fork: Boolean
)

data class Owner(
    val login: String
)

data class GitHubBranch(
    val name: String,
    val commit: Commit
)

data class Commit(
    val sha: String
)