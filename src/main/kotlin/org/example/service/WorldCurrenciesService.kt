package org.example.service

import org.example.currency.CurrencyToCountriesMapper
import org.example.restcountries.RestCountriesMapper
import org.example.restcountries.RestCountries
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WorldCurrenciesService(
    @Autowired private val client: RestCountries,
    @Autowired private val restCountriesMapper: RestCountriesMapper,
    @Autowired private val currencyToCountriesMapper: CurrencyToCountriesMapper
) {

    fun getWorldCurrenciesWithCountriesUsed(): Map<String, List<String>> {
        val countriesInWorld = client.getCountriesInWorld()
        val countriesWithCurrencies = restCountriesMapper.getCountriesWithCurrencies(countriesInWorld)
        return currencyToCountriesMapper.currenciesWithCountries(countriesWithCurrencies)
    }

}