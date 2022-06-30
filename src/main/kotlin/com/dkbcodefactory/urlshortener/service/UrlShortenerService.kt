package com.dkbcodefactory.urlshortener.service

import org.apache.commons.validator.routines.UrlValidator
import org.springframework.stereotype.Service

@Service
class UrlShortenerService {

    fun shortenUrl(): String {
        return "url"
    }

    fun isUrlValid(url: String): Boolean {
        return UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES).isValid(url)
    }
}