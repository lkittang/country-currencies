package org.example

import com.fasterxml.jackson.databind.node.ArrayNode
import org.springframework.stereotype.Component

@Component
class CountryCurrency {

    fun getCountriesWithCurrencies(countries: ArrayNode): Map<String, String> {
        return countries
            .associate { Pair(it.get("name").get("common").asText(), it.get("currencies").properties().first().key) }
    }

}