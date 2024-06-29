package com.jyproject.mviprepare.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.jyproject.mviprepare.ui.feature.first.FirstContract
import com.jyproject.mviprepare.ui.feature.first.FirstScreen
import com.jyproject.mviprepare.ui.feature.first.FirstViewModel
import java.util.concurrent.Flow

@Composable
fun FirstScreenDestination(navController: NavController) {
    val viewModel: FirstViewModel = remember { FirstViewModel() }

    FirstScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = viewModel::setEvent,
        onNavigationRequested = { navigationEffect ->
            if(navigationEffect is FirstContract.Effect.Navigation.ToSecond) {
                navController.navigateToSecond(navigationEffect.num)
            }
        }
    )
}