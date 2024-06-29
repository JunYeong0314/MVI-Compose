package com.jyproject.mviprepare.ui.feature.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun NetworkError(
    modifier: Modifier = Modifier,
    onRetryButtonClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "이런!",
            textAlign = TextAlign.Center,
        )

        Text(
            text = "네트워크 에러가 발생했습니다. 연결상태를 확인한 후 재시도 해주세요",
            modifier = Modifier.padding(16.dp),
        )

        Button(onClick = { onRetryButtonClick() }) {
            Text(
                text = "try again".uppercase()
            )
        }
    }
}
