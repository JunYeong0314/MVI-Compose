package com.jyproject.mviprepare.ui.feature.first

import com.jyproject.mviprepare.ui.base.ViewEvent
import com.jyproject.mviprepare.ui.base.ViewSideEffect
import com.jyproject.mviprepare.ui.base.ViewState

class FirstContract {

    sealed class Event: ViewEvent {
        data object Retry : Event()
        data class Action(val num: String): Event()
        data object OnIncreaseCount: Event()
        data object OnDecreaseCount: Event()
    }

    data class State(
        val count: Int,
        val isLoading: Boolean,
        val isError: Boolean
    ): ViewState

    sealed class Effect: ViewSideEffect {
        sealed class Navigation: Effect() {
            data class ToSecond(val num: String): Navigation()
        }
    }
}