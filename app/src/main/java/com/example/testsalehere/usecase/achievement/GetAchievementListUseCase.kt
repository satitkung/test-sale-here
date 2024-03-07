package com.example.testsalehere.usecase.achievement

import com.example.testsalehere.base.CoroutineUseCase
import com.example.testsalehere.di.DispatcherIO
import com.example.testsalehere.model.AchievementModel
import com.example.testsalehere.repository.achievement.AchievementRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetAchievementListUseCase @Inject constructor(
    @DispatcherIO dispatcher: CoroutineDispatcher,
    private val repository: AchievementRepository
) : CoroutineUseCase<Unit, List<AchievementModel>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<AchievementModel> {
        return repository.getAchievementList()
    }
}