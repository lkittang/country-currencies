package org.example

class Currencies {

    fun currenciesWithCountries(countries: Map<String, String>): Map<String, List<String>> {
        return countries.entries.groupBy({it.value}, {it.key})
    }

}