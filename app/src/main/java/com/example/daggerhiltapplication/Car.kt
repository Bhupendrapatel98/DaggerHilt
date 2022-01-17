package com.example.daggerhiltapplication

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(private val engine: Engine,private val wheel: Wheel) {

    fun getCar(){
        engine.getEngine()
        wheel.getWheel()
        Log.d("TAG", "Car is Running: ")
    }
}