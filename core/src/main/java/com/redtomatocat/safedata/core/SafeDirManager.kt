package com.redtomatocat.safedata.core

import android.content.Context
import android.os.Environment
import java.io.File

/**
 * Create on 2021/2/5
 *
 * @author redtomatocat
 * @version 1.0.0
 */
class SafeDirManager(private val context: Context) {

    fun safeCacheFilePath(fileName: String) = File(safeCacheDir(), fileName)


    //***********No Permission ***********//
    fun safeCacheDir() = context.cacheDir

    fun safeFileDir() = context.filesDir


    //***********File Permission ***********//
    fun noSafeCacheDir() = context.externalCacheDir

    /**
     * @type Environment
     */
    fun noSafeFileDir(type: String) = context.getExternalFilesDir(type)

    fun noSafeSDCardDir() = Environment.getExternalStorageDirectory()




}