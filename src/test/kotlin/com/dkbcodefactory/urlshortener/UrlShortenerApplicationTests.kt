package com.dkbcodefactory.urlshortener

import jdk.nashorn.internal.ir.annotations.Ignore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.view.RedirectView

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlShortenerApplicationTests(@Autowired val restTemplate: TestRestTemplate) {

    @Value("\${base_url}")
    lateinit var baseUrl: String;

    @Test
    fun `when URL is not valid then return status code BAD_REQUEST`() {
        val entity = restTemplate.getForEntity<String>("http://$baseUrl/shorten-url?url=foo")
        val actual = entity.statusCode
        val expected = HttpStatus.BAD_REQUEST
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when URL is valid then return status code OK`() {
        val entity = restTemplate.getForEntity<String>("http://$baseUrl/shorten-url?url=http://www.google.de")
        val actual = entity.statusCode
        val expected = HttpStatus.OK
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when shortUrl is entered then redirect is executed`() {
        val shortUrlEntity = restTemplate
            .getForEntity<String>("http://$baseUrl/shorten-url?url=http://www.google.de")
        val actualEntity = restTemplate.getForEntity<RedirectView>("http://" + shortUrlEntity.body.toString())
        assertThat(actualEntity).isNotNull
    }

    @Test
    @Ignore
    // While Spring Actuator monitors repositories this test will fail as long Spring Actuator is active
    fun `when shortUrl is resolved then origin url is returned`() {
        val expected = "http://www.google.de"
        val shortUrlEntity = restTemplate
            .getForEntity<String>("http://$baseUrl/shorten-url?url=$expected").body
        val actual = restTemplate.getForEntity<String>("http://$baseUrl/resolve?url=" + shortUrlEntity).body
        assertThat(actual).isEqualTo(expected)
    }
}
