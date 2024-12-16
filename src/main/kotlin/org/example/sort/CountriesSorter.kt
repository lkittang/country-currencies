package org.example.sort

import com.example.api.model.OrderBy
import com.example.api.model.SortBy
import org.springframework.stereotype.Component

@Component
class CountriesSorter {

    fun sortCountries(countries: Map<String, String?>, sortBy: SortBy, order: OrderBy): Map<String, String?> {
        val sortByMethod = when (sortBy) {
            SortBy.COUNTRY -> Pair<String, String?>::first
            SortBy.CURRENCY -> Pair<String, String?>::second
        }
        val countriesList = countries.toList()
        val sortedCountriesList = when (order) {
            OrderBy.ASCENDING -> countriesList.sortedBy(sortByMethod)
            OrderBy.DESCENDING -> countriesList.sortedByDescending(sortByMethod)
        }
        return sortedCountriesList.toMap()
    }

}