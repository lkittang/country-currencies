package org.example

import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Component
class RestTemplateClient(@Autowired private val restTemplate: RestTemplate): RestCountries {

    override fun getCountriesInEurope(): ArrayNode {
        return getRequest("/region/europe")
    }

    override fun getCountriesInWorld(): ArrayNode {
        return getRequest("/all")
    }

    private fun getRequest(pathExtension: String): ArrayNode {
        val uri = UriComponentsBuilder.fromUri(URI.create("$BASE_URI$pathExtension"))
            .queryParam("fields", "name,currencies")
            .toUriString()
        val response = restTemplate.exchange(uri, HttpMethod.GET, null, String::class.java)
        return jacksonObjectMapper().readTree(response.body) as ArrayNode
    }

    companion object {
        private const val BASE_URI = "https://restcountries.com/v3.1"
    }

}