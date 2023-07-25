package com.example.routes

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*

fun ApplicationTestBuilder.httpClient(): HttpClient {
    val client = createClient {
        install(ContentNegotiation) {
            json()
        }
    }
    return client
}
