package com.dkbcodefactory.urlshortener.service

import org.apache.commons.validator.routines.UrlValidator
import org.springframework.stereotype.Service

@Service
class UrlShortenerService {

    fun shortenUrl(): String {
        return "url"
    }

    fun isUrlValid(url: String): Boolean {
        val validator = UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES)
        return validator.isValid(url)
    }
}