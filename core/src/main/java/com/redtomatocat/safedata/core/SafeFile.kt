package com.redtomatocat.safedata.core

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKey
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


/**
 * Create on 2020/12/27
 *
 * @author redtomatocat
 * @version 1.0.0
 **/
class SafeFile(val context: Context) {

    private val masterKeyAlias =
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()

    fun readFile(fileAbsPath: String): FileInputStream {
        val file = File(fileAbsPath)
        val encryptedFile = EncryptedFile.Builder(
            context,
            file,
            masterKeyAlias,
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()
        return encryptedFile.openFileInput()
    }

    fun writeFile(fileAbsPath: String): FileOutputStream {
        val file = File(fileAbsPath)
        val encryptedFile = EncryptedFile.Builder(
            context,
            file,
            masterKeyAlias,
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()
        return encryptedFile.openFileOutput()
    }

    fun savePic(fileAbsPath: String, pic: Bitmap) {
        val stream = ByteArrayOutputStream()
        pic.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val byteArray = stream.toByteArray()
        pic.recycle()
        writeFile(fileAbsPath).apply {
            write(byteArray)
            flush()
            close()
        }
    }

    fun readPic(fileAbsPath: String) = BitmapFactory.decodeStream(readFile(fileAbsPath))

}