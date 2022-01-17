package com.example.daggerhiltapplication

import android.util.Log
import javax.inject.Inject

class Wheel @Inject constructor(){
    fun getWheel(){
        Log.d("TAG", "Wheel is Running: ")
    }
}