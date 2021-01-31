package ru.doronin.penchpenny.webmodule.api

import net.bytebuddy.utility.RandomString
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest
class GreetingControllerTest(@Autowired val testClient: WebTestClient) {

    @Test
    fun `System greets anonymous when call without params`() = testGreetingRequest("/", "Anonymous")

    @Test
    fun `System greets named user`() {
        val randomName = RandomString.make(10)
        testGreetingRequest("/$randomName", randomName)
    }

    private fun testGreetingRequest(uri: String, expectedName: String) {
        testClient.get().uri(uri).exchange()
            .expectStatus().is2xxSuccessful
            .expectBody().jsonPath("response")
            .hasJsonPath()
            .consumeWith { content ->
                assertNotNull(content.responseBody)
                String(content.responseBody!!).contains(expectedName)
            }
    }
}