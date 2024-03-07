package com.example.testsalehere.repository.achievement

import com.example.testsalehere.R
import com.example.testsalehere.model.AchievementModel
import javax.inject.Inject

class AchievementRepository @Inject constructor() {

    fun getAchievementList():List<AchievementModel> {
        val achievementList = mutableListOf<AchievementModel>()
        for (i in 0 until 8) {
            achievementList.add(
                AchievementModel("Achievement", R.drawable.ic_achievement_item)
            )
        }
        return achievementList
    }
}