package com.example.testsalehere.usecase.home

import com.example.testsalehere.base.CoroutineUseCase
import com.example.testsalehere.di.DispatcherIO
import com.example.testsalehere.model.SuggestModel
import com.example.testsalehere.repository.home.HomeRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetSuggestListUseCase @Inject constructor(
    @DispatcherIO dispatcher: CoroutineDispatcher,
    private val repository: HomeRepository
) : CoroutineUseCase<Unit, List<SuggestModel>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<SuggestModel> {
        return repository.getSuggestList()
    }
}