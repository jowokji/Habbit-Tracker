package com.example.waterreminder.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GoalRemoteDataSource @Inject constructor(
    private val fs: FirebaseFirestore
) {
    suspend fun setGoal(goalMl: Int) {
        fs.collection("goals").document("today").set(mapOf("goalMl" to goalMl)).await()
    }

    suspend fun getGoal(): Int? {
        val doc = fs.collection("goals").document("today").get().await()
        return doc.getLong("goalMl")?.toInt()
    }
}
