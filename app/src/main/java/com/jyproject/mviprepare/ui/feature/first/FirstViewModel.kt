package com.jyproject.mviprepare.ui.feature.first

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.jyproject.mviprepare.ui.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FirstViewModel: BaseViewModel<FirstContract.Event, FirstContract.State, FirstContract.Effect>() {

    init { initScreen() }

    override fun setInitialState() = FirstContract.State(
        count = 0,
        isLoading = true,
        isError = false
    )

    override fun handleEvents(event: FirstContract.Event) {
        when(event) {
            is FirstContract.Event.Action -> setEffect { FirstContract.Effect.Navigation.ToSecond(event.num) }
            is FirstContract.Event.Retry -> {}
            is FirstContract.Event.OnIncreaseCount -> { increaseCount() }
            is FirstContract.Event.OnDecreaseCount -> { decreaseCount() }
        }
    }

    private fun increaseCount() {
        setState { copy(count = count + 1) }
    }

    private fun decreaseCount() {
        setState { copy(count = count - 1) }
    }

    private fun initScreen() {
        viewModelScope.launch {
            try {
                setState { copy(isLoading = true, isError = false) }
                delay(1000)
                setState { copy(isLoading = false, isError = false) }
            }catch (e: Exception){
                setState { copy(isLoading = false, isError = true) }
            }
        }

    }
}