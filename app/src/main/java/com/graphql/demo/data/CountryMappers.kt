package com.graphql.demo.data

import com.graphql.CountriesQuery
import com.graphql.CountryQuery
import com.graphql.demo.domain.DetailedCountry
import com.graphql.demo.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital.orEmpty(),
        currency = currency.orEmpty(),
        language = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital.orEmpty()
    )
}