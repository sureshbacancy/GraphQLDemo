package com.graphql.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.graphql.demo.presentation.CountriesScreen
import com.graphql.demo.presentation.CountriesViewModel
import com.graphql.demo.ui.theme.GraphQLTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel : CountriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQLTheme {
                val state = viewmodel.state.collectAsState()
                CountriesScreen(
                    state = state.value,
                    onSelectCountry = viewmodel::selectCountry,
                    onDismissCountryDialog = {viewmodel.dismissCountryDialog()}
                )
            }
        }
    }
}