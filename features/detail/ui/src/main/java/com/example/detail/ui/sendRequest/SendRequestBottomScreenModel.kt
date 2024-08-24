package com.example.detail.ui.sendRequest

import com.example.core.base.BaseScreenModel

class SendRequestBottomScreenModel :
    BaseScreenModel<SendRequestBottomState, Any>(SendRequestBottomState.Default) {


    fun changeQuestion(value: String) {
        setState { state.value.copy(question = value) }
    }

}