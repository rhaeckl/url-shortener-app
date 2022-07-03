package com.dkbcodefactory.urlshortener.service

import com.dkbcodefactory.urlshortener.repository.UrlRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.servlet.view.RedirectView

@Service
class RedirectService @Autowired constructor(val repository: UrlRepository){

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun getRedirectView(hash: String): RedirectView {
        val url = repository.findById(hash)
        return if (url == null) {
            log.info(String.format("URL for hash %s does not exist, no redirecting ...", hash))
            RedirectView("redirect:/")
        } else {
            RedirectView(url.originUrl)
        }
    }
}
