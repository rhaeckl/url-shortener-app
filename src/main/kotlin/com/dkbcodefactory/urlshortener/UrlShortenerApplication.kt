package com.dkbcodefactory.urlshortener

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition
class UrlShortenerApplication

fun main(args: Array<String>) {
    runApplication<UrlShortenerApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
