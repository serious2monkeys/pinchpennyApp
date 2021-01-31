package ru.doronin.penchpenny.webmodule

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebModuleApplication

fun main(args: Array<String>) {
    runApplication<WebModuleApplication>(*args)
}
