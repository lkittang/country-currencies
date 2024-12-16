package org.example

import com.example.api.DefaultApi
import com.example.api.model.OrderBy
import com.example.api.model.SortBy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
open class Controller(
    @Autowired private val europeCountries: EuropeCountries,
    @Autowired private val worldCurrencies: WorldCurrencies
): DefaultApi {

    override fun countriesEuropeGet(sortBy: SortBy, orderBy: OrderBy): ResponseEntity<Any> {
        return ResponseEntity.ok(europeCountries.getEuropeanCountriesWithCurrencies(sortBy, orderBy))
    }

    override fun currenciesWorldGet(): ResponseEntity<Any> {
        TODO("To be implemented")
    }
}