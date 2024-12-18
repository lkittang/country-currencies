package org.example.restcountries

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RestCountriesMapperTest {

    private val restCountriesMapper = RestCountriesMapper()

    @Test
    fun tesMapCountriesToCurrencies() {
        // given
        val clientResponse = readSampleResponse()
        // when
        val countriesWithCurrencies = restCountriesMapper.mapCountriesToCurrencies(clientResponse)
        // then
        assertContainsCountryAndCurrency(countriesWithCurrencies, "Norway", "NOK")
        assertContainsCountryAndCurrency(countriesWithCurrencies, "Greece", "EUR")
        assertContainsCountryAndCurrency(countriesWithCurrencies, "Åland Islands", "EUR")
    }

    @Test
    fun `GIVEN country without currency THEN excludes country WHEN mapping`() {
        // given
        val noCurrencyCountry = "NoCurrencyCountry"
        val noCurrencyCountryObject = jacksonObjectMapper().createObjectNode()
            .set("name", jacksonObjectMapper().createObjectNode()
                .set("common", TextNode.valueOf(noCurrencyCountry))) as ObjectNode
        noCurrencyCountryObject.set("currencies", jacksonObjectMapper().createObjectNode()) as ObjectNode
        val countries = jacksonObjectMapper().createArrayNode().add(noCurrencyCountryObject)
        // when
        val result = restCountriesMapper.mapCountriesToCurrencies(countries)
        // then
        Assertions.assertFalse(result.containsKey(noCurrencyCountry))
    }

    private fun assertContainsCountryAndCurrency(
        countriesWithCurrencies: Map<String, String?>,
        country: String,
        currency: String
    ) {
        Assertions.assertTrue(countriesWithCurrencies.filter { it.key == country && it.value == currency }.size == 1)
    }

    companion object {
        fun readSampleResponse(): ArrayNode {
            val resourceAsStream = RestCountriesMapperTest::class.java.classLoader.getResourceAsStream("sample-countries.json")
            return ObjectMapper().readTree(resourceAsStream) as ArrayNode
        }
    }

}