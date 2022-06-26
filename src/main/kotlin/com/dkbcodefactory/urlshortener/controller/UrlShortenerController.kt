package com.dkbcodefactory.urlshortener.controller

import com.dkbcodefactory.urlshortener.service.UrlShortenerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class UrlShortenerController(val service: UrlShortenerService) {

    @GetMapping("/shorten-url")
    fun shortenUrl(): String {
        return service.shortenUrl()
    }

}