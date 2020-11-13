package com.myanmaritc.uni_zawgi_converter

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.myatminsoe.mdetect.MDetect
import me.myatminsoe.mdetect.Rabbit

class MainActivity : AppCompatActivity() {

    lateinit var typeface: Typeface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (MDetect.isUnicode()) run {
            this.typeface = MainApplication.typeFaceManager.getUnicode()
            txtOne.text = getString(R.string.mm_uni)
            txtOne.typeface = typeface
        } else run {
            this.typeface = MainApplication.typeFaceManager.getZawgyi()
            txtOne.text = Rabbit.uni2zg(getString(R.string.mm_uni))
            txtOne.typeface = typeface
        }
    }
}