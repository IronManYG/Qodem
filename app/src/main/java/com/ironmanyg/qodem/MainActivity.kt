package com.ironmanyg.qodem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ironmanyg.blood_donation_domain.donationCenter.DonationCenter
import com.ironmanyg.blood_donation_interactors.BloodDonationInteractors
import com.ironmanyg.core.domain.DataState
import com.ironmanyg.core.domain.ProgressBarState
import com.ironmanyg.core.domain.UIComponent
import com.ironmanyg.core.util.Logger
import com.ironmanyg.qodem.ui.theme.QodemTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity() {

    private val donationCenter: MutableState<List<DonationCenter>> = mutableStateOf(listOf())
    private val progressBarState: MutableState<ProgressBarState> =
        mutableStateOf(ProgressBarState.Idle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val logger =
            Logger(tag = "getBloodDonationCentersTest", isDebug = true) // create a logger instance
        val getBloodDonationCenters = BloodDonationInteractors.build(logger).getBloodDonationCenters
        getBloodDonationCenters.execute().onEach { dataState ->
            when (dataState) {
                is DataState.Response -> {
                    when (dataState.uiComponent) {
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }

                        is UIComponent.None -> {
                            (dataState.uiComponent as UIComponent.None).message?.let { logger.log(it) }
                        }

                        else -> {}
                    }
                }

                is DataState.Data -> {
                    donationCenter.value = dataState.data ?: listOf()
                }

                is DataState.Loading -> {
                    progressBarState.value = dataState.progressBarState
                }
            }
        }.launchIn(CoroutineScope(IO))

        setContent {
            QodemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        LazyColumn {
                            item {
                                Greeting("Qodem")
                            }
                            item {
                                if (donationCenter.value.isNotEmpty()) {
                                    Text(
                                        text = "Arabic Names",
                                        style = MaterialTheme.typography.headlineLarge
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                            }
                            itemsIndexed(donationCenter.value) { index, donationCenter ->
                                Text(text = "${index + 1} - ${donationCenter.nameInfo.arabic}")
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                            item {
                                if (donationCenter.value.isNotEmpty()) {
                                    Text(
                                        text = "English Names",
                                        style = MaterialTheme.typography.headlineLarge
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                            }
                            itemsIndexed(
                                items = donationCenter.value,
                                key = { _, donationCenter -> donationCenter.nameInfo.arabic }
                            ) { index, donationCenter ->
                                Text(text = "${index + 1} - ${donationCenter.nameInfo.english}")
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                        if (progressBarState.value == ProgressBarState.Loading) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QodemTheme {
        Greeting("Qodem")
    }
}