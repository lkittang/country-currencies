package org.example

import com.fasterxml.jackson.databind.node.ArrayNode

interface RestCountries {

    fun getCountriesInEurope(): ArrayNode
    fun getCountriesInWorld(): ArrayNode

}