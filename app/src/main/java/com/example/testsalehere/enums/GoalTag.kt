package com.example.testsalehere.enums


enum class GoalTag(val code: String) {
    TRAVEL("travel"),
    EDUCATION("education"),
    SPORT("sport"),
    SHOPPING("shopping"),
    INVESTMENT("invest");

    companion object {
        fun getEnumFromString(value: String): GoalTag {
            return entries.find { it.code == value.lowercase() } ?: TRAVEL
        }
    }
}