package com.myanmaritc.uni_zawgi_converter.utils

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.res.AssetManager
import android.graphics.Typeface
import androidx.collection.LruCache

class TypeFaceManager {

    companion object {
        val PYIDAUNGSU = "pyidaungsu.ttf"
        val ZAWGYI = "zawgyi.ttf"
    }

    lateinit var assetManager: AssetManager
    lateinit var activityManager: ActivityManager
    lateinit var mCache: LruCache<String, Typeface>

    constructor(manager: AssetManager, context: Context) {
        this.assetManager = manager
        activityManager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val availMemo = 4 * 1024 * 1024
        mCache = LruCache(availMemo)
    }

    fun getTypeface(filename: String): Typeface {
        var typeface: Typeface? = mCache.get(filename)
        if (typeface == null) {
            typeface = Typeface.createFromAsset(assetManager, filename)
        }
        return typeface!!
    }

    fun getUnicode(): Typeface {
        return getTypeface(PYIDAUNGSU)
    }

    fun getZawgyi(): Typeface {
        return getTypeface(ZAWGYI)
    }
}