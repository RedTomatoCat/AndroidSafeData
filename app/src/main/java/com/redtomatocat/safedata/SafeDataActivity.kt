package com.redtomatocat.safedata

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Create on 2020/12/27
 *
 * @author redtomatocat
 * @version 1.0.0
 **/
class SafeDataActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadView()
    }

    private fun loadView() {
        setContentView(LinearLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
            addView(makeButton("数据加密", R.id.safe_data_bt))
            addView(makeButton("DataStore", R.id.data_store_bt))
        })
    }

    private fun makeButton(name: String, @IdRes btId: Int) = Button(this).apply {
        layoutParams = makeButtonLP()
        text = name
        setTextColor(Color.parseColor("#000000"))
        textSize = 16f
        elevation = 10f
        id = btId
        setOnClickListener {
            when (it.id) {
                R.id.safe_data_bt -> {
                    //
                }
                R.id.data_store_bt -> {
                    //
                }
            }
        }
    }

    private fun makeButtonLP() = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
        leftMargin = 50
        rightMargin = 50
        topMargin = 50
    }

}