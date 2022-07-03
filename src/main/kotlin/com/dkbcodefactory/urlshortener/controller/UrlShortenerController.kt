package com.dkbcodefactory.urlshortener.controller

import com.dkbcodefactory.urlshortener.service.UrlShortenerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class UrlShortenerController(val service: UrlShortenerService) {

    @PostMapping("/shorten-url")
    fun shortenUrl(@RequestParam url: String): String {
        service.validateUrl(url)
        val urlInfo = service.shortenUrl(url)
        service.saveUrls(urlInfo)
        return urlInfo.shortUrl;
    }

    @GetMapping("/resolve")
    fun resolveUrl(@RequestParam url: String): String {
        return service.findOriginUrl(url) ?: ""
    }
}