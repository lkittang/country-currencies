package org.example.restcountries

import com.fasterxml.jackson.databind.node.ArrayNode

interface RestCountries {

    fun getCountriesInEurope(): ArrayNode
    fun getCountriesInWorld(): ArrayNode

}