package org.example

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CurrenciesTest {

    private val currencies = Currencies()
    private val countryCurrencyMap = mapOf(Pair(NORWAY, NOK), Pair(FINLAND, EUR), Pair(FRANCE, EUR))

    @Test
    fun testMapCurrenciesToCountries() {
        // when
        val currenciesWithCountries = currencies.currenciesWithCountries(countryCurrencyMap)
        // then
        Assertions.assertTrue(currenciesWithCountries.containsKey(NOK))
        currenciesWithCountries[NOK]?.let {
            Assertions.assertTrue(it.size == 1 && it.contains(NORWAY))
        Assertions.assertTrue(currenciesWithCountries.containsKey(EUR)) }
        currenciesWithCountries[EUR]?.let {
            Assertions.assertTrue(it.size == 2 && it.contains(FINLAND) && it.contains(FRANCE))
        }

    }

}