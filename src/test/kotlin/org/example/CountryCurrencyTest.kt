package org.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CountryCurrencyTest {

    private val countryCurrency = CountryCurrency()

    @Test
    fun tesGetCountriesWithCurrencies() {
        // given
        val clientResponse = readSampleResponse()
        // when
        val countriesWithCurrencies = countryCurrency.getCountriesWithCurrencies(clientResponse)
        // then
        assertContainsCountryAndCurrency(countriesWithCurrencies, "Norway", "NOK")
        assertContainsCountryAndCurrency(countriesWithCurrencies, "Greece", "EUR")
        assertContainsCountryAndCurrency(countriesWithCurrencies, "Åland Islands", "EUR")
    }

    private fun assertContainsCountryAndCurrency(
        countriesWithCurrencies: Map<String, String>,
        country: String,
        currency: String
    ) {
        Assertions.assertTrue(countriesWithCurrencies.filter { it.key == country && it.value == currency }.size == 1)
    }

    companion object {
        fun readSampleResponse(): ArrayNode {
            val resourceAsStream = CountryCurrencyTest::class.java.classLoader.getResourceAsStream("sample-countries.json")
            return ObjectMapper().readTree(resourceAsStream) as ArrayNode
        }
    }

}