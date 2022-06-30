package com.dkbcodefactory.urlshortener.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@RestController
@RequestMapping("/")
class RedirectController {

    @GetMapping("/{hash}")
    fun redirect(@PathVariable hash: String): RedirectView {
        return RedirectView("http://www.google.de")
    }
}