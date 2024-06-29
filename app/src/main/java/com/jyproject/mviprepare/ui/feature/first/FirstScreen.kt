package com.jyproject.mviprepare.ui.feature.first

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.jyproject.mviprepare.ui.feature.common.NetworkError
import com.jyproject.mviprepare.ui.feature.common.Progress
import kotlinx.coroutines.flow.Flow

@Composable
fun FirstScreen(
    state: FirstContract.State,
    effectFlow: Flow<FirstContract.Effect>?,
    onEventSent: (event: FirstContract.Event) -> Unit,
    onNavigationRequested: (navigationEffect: FirstContract.Effect.Navigation) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(effectFlow) {
        effectFlow?.collect { effect ->
            when(effect) {
                is FirstContract.Effect.Navigation.ToSecond -> onNavigationRequested(effect)
            }
        }
    }

    Scaffold { paddingValues ->
        when {
            state.isLoading -> Progress(paddingValues = paddingValues)
            state.isError -> NetworkError { onEventSent(FirstContract.Event.Retry) }
            else -> FirstContent(
                uiState = state,
                paddingValues = paddingValues,
                onSecClick = { onEventSent(FirstContract.Event.Action(it)) },
                onEventSent = onEventSent
            )
        }
    }

}