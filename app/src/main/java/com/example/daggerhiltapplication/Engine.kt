package com.example.daggerhiltapplication

import android.util.Log
import javax.inject.Inject

class Engine @Inject constructor(){
    fun getEngine(){
        Log.d("TAG", "Engine is Running ")
    }
}