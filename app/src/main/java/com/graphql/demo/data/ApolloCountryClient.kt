package com.graphql.demo.data

import com.apollographql.apollo3.ApolloClient
import com.graphql.CountriesQuery
import com.graphql.CountryQuery
import com.graphql.demo.domain.CountryClient
import com.graphql.demo.domain.DetailedCountry
import com.graphql.demo.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient.query(CountriesQuery())
            .execute().data?.countries?.map { it.toSimpleCountry() } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient.query(CountryQuery(code)).execute().data?.country?.toDetailedCountry()
    }
}