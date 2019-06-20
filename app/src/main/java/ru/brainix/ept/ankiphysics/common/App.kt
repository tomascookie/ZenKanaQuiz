package ru.brainix.ept.ankiphysics.common

import android.app.Application
import android.content.Context

class App : Application() {

    //App class for Model context access

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

}