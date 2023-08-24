package com.githubapiproxi.githubapiproxi.controller

import com.githubapiproxi.githubapiproxi.service.RetrofitService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/api/github")
class GitHubController(private val retrofitService: RetrofitService) {

    private val logger = LoggerFactory.getLogger(GitHubController::class.java)

    @GetMapping(
        value = ["/{username}/repos"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun listRepos(
        @PathVariable username: String,
        @RequestHeader("Accept") accept: String
    ): ResponseEntity<Any> {
        val gitHubService = retrofitService.gitHubService

        if (accept != "application/json") {
            return ResponseEntity.status(406).body(mapOf(
                "status" to 406,
                "Message" to "Only Accept: application/json is supported"
            ))
        }

        val reposResponse = gitHubService.listRepos(username).execute()

        if (!reposResponse.isSuccessful) {
            logger.error("GitHub API response not successful: ${reposResponse.code()} ${reposResponse.message()}")
            return ResponseEntity.status(404).body(mapOf(
                "status" to 404,
                "Message" to "GitHub user not found"
            ))
        }

        val repos = reposResponse.body()?.filter { !it.fork } ?: emptyList()

        val repoDetails = repos.map { repo ->
            val branches = gitHubService.listBranches(repo.owner.login, repo.name).execute().body() ?: emptyList()
            mapOf(
                "Repository Name" to repo.name,
                "Owner Login" to repo.owner.login,
                "Branches" to branches.map { mapOf(
                    "name" to it.name,
                    "last_commit_sha" to it.commit.sha
                )}
            )
        }

        logger.info("Repo details: $repoDetails")

        return ResponseEntity.ok(repoDetails)
    }
}


