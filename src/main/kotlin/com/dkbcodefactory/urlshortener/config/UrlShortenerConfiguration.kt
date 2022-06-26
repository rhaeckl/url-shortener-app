package com.dkbcodefactory.urlshortener.config

import com.dkbcodefactory.urlshortener.interceptor.RequestInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@Configuration
class UrlShortenerConfiguration @Autowired constructor(private val interceptor: RequestInterceptor) :
    WebMvcConfigurerAdapter() {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(interceptor)
    }
}