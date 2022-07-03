package com.dkbcodefactory.urlshortener.controller

import com.dkbcodefactory.urlshortener.repository.UrlRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@RestController
@RequestMapping("/")
class RedirectController @Autowired constructor(val repository: UrlRepository) {

    @GetMapping("/{hash}")
    fun redirect(@PathVariable hash: String): RedirectView {
        val url = repository.findById(hash)
        return if (url == null) {
            RedirectView("redirect:/")
        } else {
            RedirectView(url.originUrl)
        }
    }
}