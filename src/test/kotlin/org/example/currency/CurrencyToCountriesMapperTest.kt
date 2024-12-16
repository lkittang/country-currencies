package kotlin.org.example.currency

import org.example.*
import org.example.currency.CurrencyToCountriesMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CurrencyToCountriesMapperTest {

    private val currencyToCountriesMapper = CurrencyToCountriesMapper()
    private val countryCurrencyMap = mapOf(Pair(NORWAY, NOK), Pair(FINLAND, EUR), Pair(FRANCE, EUR))

    @Test
    fun testMapCurrenciesToCountries() {
        // when
        val currenciesWithCountries = currencyToCountriesMapper.currenciesWithCountries(countryCurrencyMap)
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