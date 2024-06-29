package com.jyproject.mviprepare.ui.feature.first

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FirstContent(
    uiState: FirstContract.State,
    onSecClick: (num: String) -> Unit,
    onEventSent: (FirstContract.Event) -> Unit,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${uiState.count}")
        Row {
            Button(onClick = { onEventSent(FirstContract.Event.OnIncreaseCount) }) {
                Text(text = "+1")
            }
            Button(onClick = { onEventSent(FirstContract.Event.OnDecreaseCount) }) {
                Text(text = "-1")
            }
        }
        Button(onClick = { onSecClick("2") }) {
            Text(text = "Second로 이동")
        }
    }
}