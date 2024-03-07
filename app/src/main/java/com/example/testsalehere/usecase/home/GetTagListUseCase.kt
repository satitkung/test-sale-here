package com.example.testsalehere.usecase.home

import com.example.testsalehere.base.CoroutineUseCase
import com.example.testsalehere.di.DispatcherIO
import com.example.testsalehere.model.TagModel
import com.example.testsalehere.repository.home.HomeRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetTagListUseCase @Inject constructor(
    @DispatcherIO dispatcher: CoroutineDispatcher,
    private val repository: HomeRepository
) : CoroutineUseCase<Unit, List<TagModel>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<TagModel> {
        return repository.getTagList()
    }
}