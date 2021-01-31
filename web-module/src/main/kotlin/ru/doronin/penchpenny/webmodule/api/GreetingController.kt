package ru.doronin.penchpenny.webmodule.api

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping
class GreetingController(val mapper: ObjectMapper) {

    /**
     * Просто приветствуем пользователя
     */
    @GetMapping(path = ["/", "/{name}"])
    fun greetPerson(@PathVariable("name", required = false) name: String?): Mono<JsonNode> =
        Mono.just(mapper.valueToTree(mapOf("response" to "Hello, ${name?:"Anonymous"}!")))
}