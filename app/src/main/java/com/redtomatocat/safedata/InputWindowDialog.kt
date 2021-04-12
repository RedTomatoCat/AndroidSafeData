package com.redtomatocat.safedata

import androidx.fragment.app.DialogFragment

/**
 * Create on 2021/4/8
 *
 * @author redtomatocat
 * @version 1.0.0
 **/
class InputWindowDialog : DialogFragment(){

        



}
//
//package com.redtomatocat.safedata
//
//import android.annotation.SuppressLint
//import android.graphics.Bitmap
//import android.graphics.Canvas
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import com.redtomatocat.safedata.core.SafeDirManager
//import com.redtomatocat.safedata.core.SafeFile
//import com.redtomatocat.safedata.core.SafeSP
//import com.redtomatocat.safedata.core.store.SPDataStore
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
///**
// * Create on 2020/12/27
// *
// * @author redtomatocat
// * @version 1.0.0
// **/
//class SafeDataActivity : AppCompatActivity(){
//
//    private var picPath = ""
//    private lateinit var contentTv : TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.act_safe_date_main)
//        initThing()
//    }
//
//    @SuppressLint("StaticFieldLeak")
//    private fun initThing() {
//
//        val inputEt = findViewById<EditText>(R.id.safe_input).apply {
//            //Nothing
//        }
//
//        contentTv = findViewById(R.id.safe_data_content)
//
//        findViewById<Button>(R.id.save_bt).setOnClickListener {
//            //DataSore
//            GlobalScope.launch {
//                SPDataStore(this@SafeDataActivity).save("data_store_key", inputEt.text.toString())
//            }
//
//            SafeSP(applicationContext, DEF_FILE_NAME).build()
//                .edit()
//                .putString(SAVE_TEST_DATA_KEY, inputEt.text.toString())
//                .apply()
//            contentTv.text = SafeSP(applicationContext, DEF_FILE_NAME)
//                .build()
//                .getString(SAVE_TEST_DATA_KEY, "")
//
//            GlobalScope.launch {
//                val pic = Bitmap.createBitmap(contentTv.width, contentTv.height, Bitmap.Config.ARGB_8888)
//                contentTv.draw(Canvas(pic))
//                picPath = SafeDirManager(contentTv.context).safeCacheFilePath("${System.currentTimeMillis()}.png").path
//                SafeFile(applicationContext).savePic(picPath, pic)
////                delay(5000)
////                launch(Dispatchers.Main) {
////                    val picView = findViewById<ImageView>(R.id.test_show)
////                    picView.setImageBitmap(SafeFile(applicationContext).readPic(picPath))
////                }
//            }
//        }
//
//    }
//
//
//    companion object{
//        private const val TAG = "SafeDataActivity"
//
//        private const val DEF_FILE_NAME = "def_cache"
//
//        const val SAVE_TEST_DATA_KEY = "save_test_data_key"
//    }
//
//}