package com.example.testsalehere.ui.home.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testsalehere.base.data
import com.example.testsalehere.model.GoalModel
import com.example.testsalehere.model.OfferModel
import com.example.testsalehere.model.SuggestModel
import com.example.testsalehere.usecase.home.GetGoalListUseCase
import com.example.testsalehere.usecase.home.GetOfferListUseCase
import com.example.testsalehere.usecase.home.GetSuggestListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeDashboardViewModel @Inject constructor(
    private val getGoalListUseCase: GetGoalListUseCase,
    private val getOfferListUseCase: GetOfferListUseCase,
    private val getSuggestListUseCase: GetSuggestListUseCase
) : ViewModel() {

    private val _goalList = MutableLiveData<List<GoalModel>>()
    val goalList: LiveData<List<GoalModel>>
        get() = _goalList

    private val _offerList = MutableLiveData<List<OfferModel>>()
    val offerList: LiveData<List<OfferModel>>
        get() = _offerList

    private val _suggestList = MutableLiveData<List<SuggestModel>>()
    val suggestList: LiveData<List<SuggestModel>>
        get() = _suggestList

    private val _isRefresh = MutableLiveData<Boolean>()
    val isRefresh: LiveData<Boolean>
        get() = _isRefresh

    fun loadData() {
        viewModelScope.launch {
            _isRefresh.postValue(true)
            delay(1000)
            getGoalList()
            getOfferList()
            getSuggestList()
            _isRefresh.postValue(false)
        }
    }

    private suspend fun getGoalList() {
        viewModelScope.launch {
            getGoalListUseCase.invoke(Unit).data?.let {
                _goalList.postValue(it)
            }
        }
    }

    private suspend fun getOfferList() {
        viewModelScope.launch {
            getOfferListUseCase.invoke(Unit).data?.let {
                _offerList.postValue(it)
            }
        }
    }

    private suspend fun getSuggestList() {
        viewModelScope.launch {
            getSuggestListUseCase.invoke(Unit).data?.let {
                _suggestList.postValue(it)
            }
        }
    }
}