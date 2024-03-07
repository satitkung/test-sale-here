package com.example.testsalehere.repository.home

import com.example.testsalehere.model.GoalModel
import com.example.testsalehere.model.OfferModel
import com.example.testsalehere.model.SuggestModel
import com.example.testsalehere.model.TagModel
import javax.inject.Inject

class HomeRepository @Inject constructor() {

    val mockImageList = listOf(
        "https://hs.sbcounty.gov/cn/Photo%20Gallery/_w/Sample%20Picture%20-%20Koala_jpg.jpg",
        "https://cdn.pixabay.com/photo/2022/01/28/18/32/leaves-6975462_1280.png",
        "https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg"
    )

    fun getGoalList(): List<GoalModel> {
        return listOf(
            GoalModel(
                id = 0,
                tag = "Travel",
                currentAmount = 16500,
                targetAmount = 20000,
                title = "ไปเที่ยวญี่ปุ่น",
                remainingDay = 45
            ),
            GoalModel(
                id = 1,
                tag = "Invest",
                currentAmount = 500,
                targetAmount = 6000,
                title = "ซื้อกองทุนรวม",
                remainingDay = 20
            ),
            GoalModel(
                id = 2,
                tag = "Travel",
                currentAmount = 20500,
                targetAmount = 20500,
                title = "ไปทะเลฮาวายที่ประเทศอเมริกา",
                remainingDay = 1
            )
        )
    }

    fun getOfferList(): List<OfferModel> {
        val offerList = mutableListOf<OfferModel>()
        for (i in 0 until 10) {
            offerList.add(
                OfferModel(i, mockImageList.random())
            )
        }
        return offerList
    }

    fun getSuggestList(): List<SuggestModel> {
        val suggestList = mutableListOf<SuggestModel>()
        for (i in 0 until 10) {
            suggestList.add(
                SuggestModel(i, mockImageList.random())
            )
        }
        return suggestList
    }

    fun getTagList(): List<TagModel> {

        return listOf(
            TagModel(
                id = 0,
                title = "Travel",
            ),
            TagModel(
                id = 1,
                title = "Education",
            ),
            TagModel(
                id = 2,
                title = "Sport",
            ),
            TagModel(
                id = 3,
                title = "Shopping",
            ),
            TagModel(
                id = 4,
                title = "Invest"
            )
        )
    }
}