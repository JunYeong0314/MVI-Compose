package com.jyproject.mviprepare.ui.feature.second

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SecondScreen(
    number: String
) {
    Column {
        Text(text = "I'm Second $number")
    }

}