package com.example.routes

import com.example.models.Customer
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerRoutingTest {

    @Test
    fun testGetCustomer() = testApplication {
        val client = httpClient()
        client.get("/customer").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testPostCustomer() = testApplication {
        val client = httpClient()
        client.post("/customer") {
            contentType(ContentType.Application.Json)
            setBody(
                Customer(
                    "id", "firstName", "lastNAme", "email"
                )
            )

        }.apply {
            assertEquals("Customer stored correctly", bodyAsText())
            assertEquals(HttpStatusCode.Created, status)
        }
    }

    @Test
    fun testDeleteCustomerId() = testApplication {
        val client = httpClient()
        client.delete("/customer/{id}").apply {
            assertEquals(HttpStatusCode.NotFound, status)
        }
    }

    @Test
    fun testGetCustomerId() = testApplication {
        val client = httpClient()
        client.get("/customer/{id}").apply {
            assertEquals(HttpStatusCode.NotFound, status)
        }
    }
}
