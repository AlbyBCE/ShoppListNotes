package com.example.noteappfromcourse.dialog

sealed class DialogEvent{
    data class onTextChange(val text:String):DialogEvent()
    object OnCancel:DialogEvent()
    object OnConfirm:DialogEvent()
}
