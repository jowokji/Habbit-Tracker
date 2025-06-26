package com.example.waterreminder.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import dagger.hilt.android.qualifiers.ApplicationContext

private val Context.ds by preferencesDataStore("settings")

class SettingsDataStore @Inject constructor(
    @ApplicationContext private val ctx: Context
) {
    private val UNIT = stringPreferencesKey("unit")    // "ml" or "l"
    private val DARK = stringPreferencesKey("theme")   // "light" / "dark"

    val unitFlow: Flow<String> = ctx.ds.data.map { it[UNIT] ?: "ml" }
    val themeFlow: Flow<String> = ctx.ds.data.map { it[DARK] ?: "light" }

    suspend fun setUnit(unit: String) { ctx.ds.edit { it[UNIT] = unit } }
    suspend fun setTheme(theme: String) { ctx.ds.edit { it[DARK] = theme } }
}
