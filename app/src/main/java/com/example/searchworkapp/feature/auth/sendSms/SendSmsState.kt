package com.example.searchworkapp.feature.auth.sendSms

data class SendSmsState(val otp: String) {

    val isValid = otp.length == 4

    companion object {
        val Default = SendSmsState(otp = "")
    }
}