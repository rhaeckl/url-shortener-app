package com.dkbcodefactory.urlshortener.data

import org.springframework.data.annotation.Id
import java.io.Serializable

data class UrlInfo(@Id var id: String, val shortUrl: String, val originUrl: String) : Serializable