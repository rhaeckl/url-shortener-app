package com.dkbcodefactory.urlshortener

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlShortenerApplicationTests(@Autowired val restTemplate: TestRestTemplate) {

	@Test
	fun `Assert that request returns content, status code OK and url as value`() {
		val entity = restTemplate.getForEntity<String>("/api/v1/shorten-url")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(entity.body).isNotEmpty;
		assertThat(entity.body).isEqualTo("url")
	}

}
