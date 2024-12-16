package org.example.currency

import org.springframework.stereotype.Component

@Component
class CurrencyToCountriesMapper {

    fun currenciesWithCountries(countries: Map<String, String?>): Map<String, List<String>> {
        val countriesWithCurrency = countries.filterValues { it != null }.mapValues { it.value!! }
        return countriesWithCurrency.entries.groupBy({it.value}, {it.key})
    }

}