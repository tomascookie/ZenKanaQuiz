package ru.brainix.ept.ankiphysics.common

import android.content.Context

class SaveInShared: ISaveShared {

    // Save and load mode data methods from SharedPreferences

    override fun saveData(mode: Int, context:Context) {
        val mSettings = context.getSharedPreferences(Data.APP_PREFERENCES, Context.MODE_PRIVATE)
        val editor = mSettings.edit()
        editor.putInt(Data.APP_PREFERENCES_NAME, mode)
        editor.apply()
    }

    override fun loadData(context:Context):Int {

        val mSettings = context.getSharedPreferences(Data.APP_PREFERENCES, Context.MODE_PRIVATE)

            if(mSettings.contains(Data.APP_PREFERENCES_NAME)) {

                 return mSettings.getInt(Data.APP_PREFERENCES_NAME, 1)
            }

        return 1

    }

}