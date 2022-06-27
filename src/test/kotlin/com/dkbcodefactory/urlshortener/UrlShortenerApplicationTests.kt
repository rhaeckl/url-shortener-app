package com.dkbcodefactory.urlshortener

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlShortenerApplicationTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `when URL is not valid then return status code BAD_REQUEST`() {
        val entity = restTemplate.getForEntity<String>("/api/v1/shorten-url?url=foo")
        val actual = entity.statusCode
        val expected = HttpStatus.BAD_REQUEST
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when URL is valid then return status code OK`() {
        val entity = restTemplate.getForEntity<String>("/api/v1/shorten-url?url=https://www.foobar.com")
        val actual = entity.statusCode
        val expected = HttpStatus.OK
        assertThat(actual).isEqualTo(expected)
    }
}
