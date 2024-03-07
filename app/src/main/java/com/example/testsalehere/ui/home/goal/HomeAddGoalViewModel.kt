package com.example.testsalehere.ui.home.goal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testsalehere.base.data
import com.example.testsalehere.model.TagModel
import com.example.testsalehere.usecase.home.GetTagListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeAddGoalViewModel @Inject constructor(
    private val getTagListUseCase: GetTagListUseCase
) : ViewModel() {

    private val _tagList = MutableLiveData<List<TagModel>>()
    val tagList: LiveData<List<TagModel>>
        get() = _tagList

    fun loadData() {
        viewModelScope.launch {
            getTagList()
        }
    }

    private suspend fun getTagList() {
        viewModelScope.launch {
            getTagListUseCase.invoke(Unit).data?.let {
                _tagList.postValue(it)
            }
        }
    }

}