package com.dkbcodefactory.urlshortener.controller

import com.dkbcodefactory.urlshortener.service.RedirectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@RestController
@RequestMapping("/")
class RedirectController @Autowired constructor(val service: RedirectService) {

    @GetMapping("/{hash}")
    fun redirect(@PathVariable hash: String): RedirectView {
        return service.getRedirectView(hash)
    }
}