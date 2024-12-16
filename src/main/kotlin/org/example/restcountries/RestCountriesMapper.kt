package org.example.restcountries

import com.fasterxml.jackson.databind.node.ArrayNode
import org.springframework.stereotype.Component

@Component
class RestCountriesMapper {

    fun getCountriesWithCurrencies(countries: ArrayNode): Map<String, String?> {
        return countries
            .filter { it.get("name")?.get("common") != null }
            .associate { Pair(
                it.get("name").get("common").asText(),
                it.get("currencies")?.properties()?.let { if (it.isEmpty()) null else it.first()?.key }) }
    }

}