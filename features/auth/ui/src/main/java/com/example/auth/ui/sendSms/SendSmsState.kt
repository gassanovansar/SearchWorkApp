package com.example.auth.ui.sendSms

data class SendSmsState(val otp: String) {

    val isValid = otp.length == 4

    companion object {
        val Default = SendSmsState(otp = "")
    }
}