package kotlin.org.example.sort

import com.example.api.model.OrderBy
import com.example.api.model.SortBy
import org.example.*
import org.example.sort.CountriesSorter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CountriesSorterTest {
    private val countriesSorter = CountriesSorter()
    private val countryCurrencyMap = mapOf(Pair(NORWAY, NOK), Pair(UNITED_KINGDOWM, GBP), Pair(FINLAND, EUR))

    @Test
    fun testSortByCountryAscending() {
        // when
        val sorted = countriesSorter.sortCountries(countryCurrencyMap, SortBy.COUNTRY, OrderBy.ASCENDING)
        // then
        Assertions.assertEquals(FINLAND, sorted.toList().get(0).first)
        Assertions.assertEquals(NORWAY, sorted.toList().get(1).first)
        Assertions.assertEquals(UNITED_KINGDOWM, sorted.toList().get(2).first)
    }

    @Test
    fun testSortByCountryDescending() {
        // when
        val sorted = countriesSorter.sortCountries(countryCurrencyMap, SortBy.COUNTRY, OrderBy.DESCENDING)
        // then
        Assertions.assertEquals(UNITED_KINGDOWM, sorted.toList().get(0).first)
        Assertions.assertEquals(NORWAY, sorted.toList().get(1).first)
        Assertions.assertEquals(FINLAND, sorted.toList().get(2).first)
    }

    @Test
    fun testSortByCurrencyAscending() {
        // when
        val sorted = countriesSorter.sortCountries(countryCurrencyMap, SortBy.CURRENCY, OrderBy.ASCENDING)
        // then
        Assertions.assertEquals(FINLAND, sorted.toList().get(0).first)
        Assertions.assertEquals(UNITED_KINGDOWM, sorted.toList().get(1).first)
        Assertions.assertEquals(NORWAY, sorted.toList().get(2).first)
    }

    @Test
    fun testSortByCurrencyDescending() {
        // when
        val sorted = countriesSorter.sortCountries(countryCurrencyMap, SortBy.CURRENCY, OrderBy.DESCENDING)
        // then
        Assertions.assertEquals(NORWAY, sorted.toList().get(0).first)
        Assertions.assertEquals(UNITED_KINGDOWM, sorted.toList().get(1).first)
        Assertions.assertEquals(FINLAND, sorted.toList().get(2).first)
    }

}