package org.example

class CountrySorter {

    enum class SortBy {COUNTRY, CURRENCY}
    enum class Order {ASCENDING, DESCENDING}

    fun sortCountries(countries: Map<String, String>, sortBy: SortBy?, order: Order?): Map<String, String> {
        val sortByMethod = when (sortBy) {
            SortBy.COUNTRY -> Pair<String, String>::first
            SortBy.CURRENCY -> Pair<String, String>::second
            null -> Pair<String, String>::first
        }
        val countriesList = countries.toList()
        val sortedCountriesList = when (order) {
            Order.ASCENDING -> countriesList.sortedBy(sortByMethod)
            Order.DESCENDING -> countriesList.sortedByDescending(sortByMethod)
            null -> countriesList.sortedBy(sortByMethod)
        }
        return sortedCountriesList.toMap()
    }

}