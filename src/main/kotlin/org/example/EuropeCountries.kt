package org.example

import com.example.api.model.OrderBy
import com.example.api.model.SortBy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EuropeCountries(
    @Autowired private val client: RestCountries,
    @Autowired private val countryCurrency: CountryCurrency,
    @Autowired private val countrySorter: CountrySorter
) {

    fun getEuropeanCountriesWithCurrencies(sortBy: SortBy, orderBy: OrderBy): Map<String, String> {
        val countries = client.getCountriesInEurope()
        val countriesWithCurrencies = countryCurrency.getCountriesWithCurrencies(countries)
        return countrySorter.sortCountries(countriesWithCurrencies, sortBy, orderBy)
    }

}