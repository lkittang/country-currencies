package org.example

import org.springframework.stereotype.Component

@Component
class Currencies {

    fun currenciesWithCountries(countries: Map<String, String?>): Map<String, List<String>> {
        val countriesWithCurrency = countries.filterValues { it != null } as Map<String, String>
        return countriesWithCurrency.entries.groupBy({it.value}, {it.key})
    }

}