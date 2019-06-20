package ru.brainix.ept.ankiphysics.common

import android.content.Context

interface ISaveShared {

    fun saveData(mode:Int, context:Context)

    fun loadData(context:Context):Int
}