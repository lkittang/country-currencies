package org.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WorldCurrencies(
    @Autowired private val client: RestCountries,
    @Autowired private val countryCurrency: CountryCurrency,
    @Autowired private val currencies: Currencies
) {

    fun getWorldCurrenciesWithCountriesUsed(): Map<String, List<String>> {
        val countriesInWorld = client.getCountriesInWorld()
        val countriesWithCurrencies = countryCurrency.getCountriesWithCurrencies(countriesInWorld)
        return currencies.currenciesWithCountries(countriesWithCurrencies)
    }

}