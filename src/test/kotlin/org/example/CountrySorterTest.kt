package org.example

import org.example.CountrySorter.Order.ASCENDING
import org.example.CountrySorter.Order.DESCENDING
import org.example.CountrySorter.SortBy.COUNTRY
import org.example.CountrySorter.SortBy.CURRENCY
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CountrySorterTest {
    private val countrySorter = CountrySorter()
    private val countryCurrencyMap = mapOf(Pair(NORWAY, NOK), Pair(UNITED_KINGDOWM, GBP), Pair(FINLAND, EUR))

    @Test
    fun testSortByCountryAscending() {
        // when
        val sorted = countrySorter.sortCountries(countryCurrencyMap, COUNTRY, ASCENDING)
        // then
        Assertions.assertEquals(FINLAND, sorted.toList().get(0).first)
        Assertions.assertEquals(NORWAY, sorted.toList().get(1).first)
        Assertions.assertEquals(UNITED_KINGDOWM, sorted.toList().get(2).first)
    }

    @Test
    fun testSortByCountryDescending() {
        // when
        val sorted = countrySorter.sortCountries(countryCurrencyMap, COUNTRY, DESCENDING)
        // then
        Assertions.assertEquals(UNITED_KINGDOWM, sorted.toList().get(0).first)
        Assertions.assertEquals(NORWAY, sorted.toList().get(1).first)
        Assertions.assertEquals(FINLAND, sorted.toList().get(2).first)
    }

    @Test
    fun testSortByCurrencyAscending() {
        // when
        val sorted = countrySorter.sortCountries(countryCurrencyMap, CURRENCY, ASCENDING)
        // then
        Assertions.assertEquals(FINLAND, sorted.toList().get(0).first)
        Assertions.assertEquals(UNITED_KINGDOWM, sorted.toList().get(1).first)
        Assertions.assertEquals(NORWAY, sorted.toList().get(2).first)
    }

    @Test
    fun testSortByCurrencyDescending() {
        // when
        val sorted = countrySorter.sortCountries(countryCurrencyMap, CURRENCY, DESCENDING)
        // then
        Assertions.assertEquals(NORWAY, sorted.toList().get(0).first)
        Assertions.assertEquals(UNITED_KINGDOWM, sorted.toList().get(1).first)
        Assertions.assertEquals(FINLAND, sorted.toList().get(2).first)
    }

}