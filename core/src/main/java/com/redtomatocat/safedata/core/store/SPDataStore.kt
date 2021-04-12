package com.redtomatocat.safedata.core.store

import android.content.Context
import androidx.annotation.NonNull
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * Create on 2021/4/6
 *
 * @author redtomatocat
 * @version 1.0.0
 **/
class SPDataStore(private val context: Context, private val name: String = "def_data_store") {

    private val Context.spDataStore: DataStore<Preferences> by preferencesDataStore(name)

    suspend fun save(@NonNull key: String, @NonNull data: String) {
        val preKey = stringPreferencesKey(key)
        context.spDataStore.edit {
            it[preKey] = data
        }
    }

    suspend fun save(@NonNull key: String, @NonNull data: Boolean) = context.spDataStore.edit {
        it[booleanPreferencesKey(key)] = data
    }

    private suspend fun save(@NonNull key: String, @NonNull data: Int) = context.spDataStore.edit {
        it[intPreferencesKey(key)] = data
    }

    private suspend fun save(@NonNull key: String, @NonNull data: Long) = context.spDataStore.edit {
        it[longPreferencesKey(key)] = data
    }

    private suspend fun get(@NonNull key: String): String {
        val preKey = stringPreferencesKey(key)
        val value = context.spDataStore.data.map {
            it[preKey] ?: ""
        }
        return value.first()
    }

}