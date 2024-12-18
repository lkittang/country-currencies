package org.example.restcountries

import com.fasterxml.jackson.databind.node.ArrayNode
import org.springframework.stereotype.Component

@Component
class RestCountriesMapper {

    fun mapCountriesToCurrencies(restCountriesResponse: ArrayNode): Map<String, String> {
        return restCountriesResponse
            .filter { it.get("name")?.get("common") != null }
            .filter { it.get("currencies")?.properties()?.isEmpty() == false }
            .associate { Pair(
                it.get("name").get("common").asText(),
                it.get("currencies").properties().first().key) }
    }

}