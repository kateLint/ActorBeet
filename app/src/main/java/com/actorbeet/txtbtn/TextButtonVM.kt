package com.actorbeet.txtbtn

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class TextButtonVM: ViewModel() {

    val secondText = mutableStateOf("State")

    fun buttonClick(){
        secondText.value = "State ${Random.nextInt(10)}"
    }
}