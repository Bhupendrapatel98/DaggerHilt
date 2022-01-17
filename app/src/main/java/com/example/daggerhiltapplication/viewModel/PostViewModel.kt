package com.example.daggerhiltapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltapplication.Repository.PostRepository
import com.example.daggerhiltapplication.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository):ViewModel() {

    private val _postLiveData = MutableLiveData<List<Post>>()
    val postLiveData:LiveData<List<Post>>
    get()=_postLiveData

    fun getData(){
        viewModelScope.launch {
             postRepository.getPost().collect(){
                 _postLiveData.value = it
            }
        }
    }



}