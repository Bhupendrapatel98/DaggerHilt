package com.example.daggerhiltapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.daggerhiltapplication.databinding.ActivityMainBinding
import com.example.daggerhiltapplication.model.Post
import com.example.daggerhiltapplication.viewModel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


//@Inject - for code you own(jo code aapne likha ho)
//@Bindc - for injcting interface
//@Provide - for code you don't own (library)

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    @Inject
    lateinit var main: Main

    private val postViewModel:PostViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        car.getCar()
        main.getName()

        postViewModel.getData()

        postViewModel.postLiveData.observe(this, Observer {
            Log.d(",djfhnkjdf", "onCreate: $it")
            binding.list = it
        })

    }
}