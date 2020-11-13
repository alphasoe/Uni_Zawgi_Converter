package com.myanmaritc.uni_zawgi_converter

import android.app.Application
import com.myanmaritc.uni_zawgi_converter.utils.TypeFaceManager
import me.myatminsoe.mdetect.MDetect

class MainApplication : Application() {

    companion object {
        lateinit var typeFaceManager: TypeFaceManager
    }

    override fun onCreate() {
        super.onCreate()
        MDetect.init(this)
        typeFaceManager = TypeFaceManager(assets, applicationContext)
    }
}