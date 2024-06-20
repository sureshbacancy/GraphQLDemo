package com.graphql.demo.domain.usecase

import com.graphql.demo.domain.CountryClient
import com.graphql.demo.domain.SimpleCountry

class GetCountriesUseCase(private val countryClient: CountryClient) {

    suspend fun execute(): List<SimpleCountry> {
        return countryClient.getCountries().sortedBy { it.name }
    }
}