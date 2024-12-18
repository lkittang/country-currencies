package org.example.controller

import com.example.api.DefaultApi
import com.example.api.model.OrderBy
import com.example.api.model.SortBy
import org.example.service.EuropeCountriesService
import org.example.service.WorldCurrenciesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
open class Controller(
    @Autowired private val europeCountriesService: EuropeCountriesService,
    @Autowired private val worldCurrenciesService: WorldCurrenciesService
): DefaultApi {

    override fun countriesEuropeGet(sortBy: SortBy, orderBy: OrderBy): ResponseEntity<Map<String,String>> {
        return ResponseEntity.ok(europeCountriesService.getEuropeanCountriesWithCurrencies(sortBy, orderBy))
    }

    override fun currenciesWorldGet(): ResponseEntity<Map<String, List<String>>> {
        return ResponseEntity.ok(worldCurrenciesService.getWorldCurrenciesWithCountriesUsed())
    }
}