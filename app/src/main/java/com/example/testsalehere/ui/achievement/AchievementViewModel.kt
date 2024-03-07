package com.example.testsalehere.ui.achievement

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testsalehere.base.data
import com.example.testsalehere.model.AchievementModel
import com.example.testsalehere.usecase.achievement.GetAchievementListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AchievementViewModel @Inject constructor(
    private val getAchievementListUseCase: GetAchievementListUseCase
) : ViewModel() {

    val isRefresh: ObservableField<Boolean> = ObservableField(false)
    val level: ObservableField<Int> = ObservableField(0)

    private val _achievementList = MutableLiveData<List<AchievementModel>>()
    val achievementList: LiveData<List<AchievementModel>>
        get() = _achievementList

    fun loadData() {
        viewModelScope.launch {
            isRefresh.set(true)
            delay(1000)
            getAchievementList()
            isRefresh.set(false)
        }
    }

    private suspend fun getAchievementList() {
        viewModelScope.launch {
            getAchievementListUseCase.invoke(Unit).data?.let {
                level.set(it.size)
                _achievementList.postValue(it)
            }
        }
    }

}