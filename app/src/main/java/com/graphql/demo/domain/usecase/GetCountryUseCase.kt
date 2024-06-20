package com.graphql.demo.domain.usecase

import com.graphql.demo.domain.CountryClient
import com.graphql.demo.domain.DetailedCountry

class GetCountryUseCase(private val countryClient: CountryClient) {

    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}