package com.example.routes

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ArticleRoutingTest {

    @Test
    fun testGetArticles() = testApplication {
        val client = httpClient()
        client.get("/articles").apply {
            assertNotNull(bodyAsText())
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testPostArticles() = testApplication {
        val client = httpClient()
        client.post("/articles").apply {
            assertEquals(HttpStatusCode.UnsupportedMediaType, status)
        }
    }

    @Test
    fun testGetArticlesId() = testApplication {
        val client = httpClient()
        client.get("/articles/{id}").apply {
            assertEquals(HttpStatusCode.BadRequest, status)
        }
    }

    @Test
    fun testPostArticlesId() = testApplication {
        val client = httpClient()
        client.post("/articles/{id}").apply {
            assertEquals(HttpStatusCode.BadRequest, status)
        }
    }

    @Test
    fun testGetArticlesIdEdit() = testApplication {
        val client = httpClient()
        client.get("/articles/{id}/edit").apply {
            assertEquals(HttpStatusCode.BadRequest, status)
        }
    }

    @Test
    fun testGetArticlesNew() = testApplication {
        val client = httpClient()
        client.get("/articles/new").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }
}
