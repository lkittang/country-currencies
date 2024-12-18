package org.example.service

import com.example.api.model.OrderBy
import com.example.api.model.SortBy
import org.example.restcountries.RestCountriesMapper
import org.example.restcountries.RestCountries
import org.example.sort.CountriesSorter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EuropeCountriesService(
    @Autowired private val client: RestCountries,
    @Autowired private val restCountriesMapper: RestCountriesMapper,
    @Autowired private val countriesSorter: CountriesSorter
) {

    fun getEuropeanCountriesWithCurrencies(sortBy: SortBy, orderBy: OrderBy): Map<String, String> {
        val countries = client.getCountriesInEurope()
        val countriesWithCurrencies = restCountriesMapper.mapCountriesToCurrencies(countries)
        return countriesSorter.sort(countriesWithCurrencies, sortBy, orderBy)
    }

}