# GitHub API Proxy

This is a GitHub API Proxy built with Kotlin and Spring Boot.

## Prerequisites

- Kotlin 1.5 or higher
- Gradle 6.x or higher
- Spring Boot 3.1.2
- JVM 17 or higher

## Installation

1. Clone the repository:
    ```
    git clone https://github.com/TheWildSea/github-api-proxy.git
    ```

2. Navigate to the project directory:
    ```
    cd githubapiproxy
    ```

3. Build the project:
    ```
    ./gradlew build
    ```

## Configuring OAuth Token

To increase the API request limit, you can utilize a personal OAuth token from GitHub. Follow these steps to integrate it into your application:

### Generate OAuth Token on GitHub

- Navigate to your GitHub settings.
- Go to `Developer settings` > `Personal access tokens`.
- Click `Generate new token`.
- Select the required scopes for your application, typically `repo` and `user` are sufficient.
- Click `Generate token` at the bottom of the page.
- Copy the generated token.

### Integrate the Token into the Application

Modify your GitHub service configuration to include the token in the Authorization header for each request.

Replace `YOUR_ACCESS_TOKEN_HERE` with the OAuth token you generated.

### Run the Application with OAuth Token

Run the application:
```
./gradlew bootRun
```

## Testing

You can use tools like Postman, or simple `curl` commands to test the endpoints:
```
curl -H "Accept: application/json" http://localhost:8080/api/github/{username}/repos
```
Replace `{username}` with a valid GitHub username.

## Contributing

If you'd like to contribute, please fork the repository and use a feature branch. Pull requests are warmly welcome.

1. Fork the repo
2. Clone it to your local machine
3. Make changes
4. Push to your fork
5. Create a pull request

## Feedback

If you have any feedback or issues, please open a GitHub issue or reach out directly.
