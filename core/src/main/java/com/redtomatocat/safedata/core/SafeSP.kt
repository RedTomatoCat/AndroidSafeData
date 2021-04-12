package com.redtomatocat.safedata.core

import android.content.Context
import androidx.annotation.NonNull
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 * Create on 2020/12/27
 *
 * @author redtomatocat
 * @version 1.0.0
 **/
class SafeSP(private val context: Context, var filename: String) {

    private val keyBuild = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
    private var prefKeyEncryptionScheme =
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV
    private var prefValueEncryptionScheme =
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM


    fun setFileName(name: String): SafeSP {
        filename = name
        return this
    }

    fun setPrefKeyEncryptionScheme(@NonNull prefKeyEncryptionScheme: EncryptedSharedPreferences.PrefKeyEncryptionScheme): SafeSP {
        this.prefKeyEncryptionScheme = prefKeyEncryptionScheme
        return this
    }

    fun setPrefValueEncryptionScheme(@NonNull prefValueEncryptionScheme: EncryptedSharedPreferences.PrefValueEncryptionScheme): SafeSP {
        this.prefValueEncryptionScheme = prefValueEncryptionScheme
        return this
    }

    fun setKeyScheme(@NonNull keyScheme: MasterKey.KeyScheme): SafeSP {
        keyBuild.setKeyScheme(keyScheme)
        return this
    }

    fun build() = EncryptedSharedPreferences
        .create(
            context,
            filename,
            keyBuild.build(),
            prefKeyEncryptionScheme,
            prefValueEncryptionScheme
        )


}