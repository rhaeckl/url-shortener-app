package com.dkbcodefactory.urlshortener.repository

import com.dkbcodefactory.urlshortener.data.UrlInfo
import org.springframework.stereotype.Repository

@Repository
class UrlRepository {
    val urls: MutableList<UrlInfo> = ArrayList()

    fun findById(id: String): UrlInfo? {
        return urls.singleOrNull { it.id == id }
    }

    fun save(urlInfo: UrlInfo): UrlInfo {
        urls.add(urlInfo)
        return urlInfo
    }
}