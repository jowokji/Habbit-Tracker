package com.example.waterreminder

import com.example.waterreminder.presentation.viewmodel.DashboardState
import org.junit.Assert.assertEquals
import org.junit.Test

class DashboardStateTest {
    @Test
    fun `remaining water never negative`() {
        val state = DashboardState(totalDrunk = 2500, goal = 2000)
        assertEquals(0, state.remaining)
    }
    @Test
    fun `progress proportion`() {
        val state = DashboardState(totalDrunk = 1000, goal = 2000)
        assertEquals(0.5f, state.progress, 0.01f)
    }
}
