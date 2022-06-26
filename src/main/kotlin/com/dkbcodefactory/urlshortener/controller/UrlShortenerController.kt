package com.dkbcodefactory.urlshortener.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlShortenerController {

    @GetMapping("/shorten-url")
    fun shortenUrl(): String {
        return "url"
    }

}