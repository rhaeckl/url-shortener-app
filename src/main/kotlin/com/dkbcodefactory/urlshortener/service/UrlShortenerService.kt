package com.dkbcodefactory.urlshortener.service

import com.dkbcodefactory.urlshortener.data.UrlInfo
import com.dkbcodefactory.urlshortener.exception.InvalidUrlException
import com.dkbcodefactory.urlshortener.repository.UrlRepository
import com.google.common.hash.Hashing
import org.apache.commons.validator.routines.UrlValidator
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.util.logging.Logger

@Service
class UrlShortenerService @Autowired constructor(val repository: UrlRepository) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Value("\${base_url}")
    lateinit var baseUrl: String;

    fun shortenUrl(url: String): UrlInfo {
        val hash = Hashing.murmur3_32_fixed().hashString(url, StandardCharsets.UTF_8).toString()
        val shortUrl = "$baseUrl/$hash"
        return UrlInfo(hash, shortUrl, url)
    }

    fun saveUrls(urlInfo: UrlInfo) {
        repository.save(urlInfo)
        log.info(String.format("Short URL %s with Long URL %s has been saved ...", urlInfo.shortUrl, urlInfo.originUrl))
    }

    fun findOriginUrl(url: String): String? {
        val id = url.replace("$baseUrl/", "")
        return findById(id)?.originUrl
    }

    fun validateUrl(url: String) {
        if(!isUrlValid(url))
        {
            throw InvalidUrlException()
        }
    }

    private fun isUrlValid(url: String): Boolean {
        return UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES).isValid(url)
    }

    private fun findById(id: String): UrlInfo? {
        return repository.findById(id)
    }
}