package com.dkbcodefactory.urlshortener.controller

import com.dkbcodefactory.urlshortener.exception.InvalidUrlException
import com.dkbcodefactory.urlshortener.service.UrlShortenerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/")
class UrlShortenerController(val service: UrlShortenerService) {

    @GetMapping("/shorten-url")
    fun shortenUrl(@RequestParam url: String): String {
        if (!service.isUrlValid(url)) {
            throw InvalidUrlException()
        }
        return service.shortenUrl()
    }

}