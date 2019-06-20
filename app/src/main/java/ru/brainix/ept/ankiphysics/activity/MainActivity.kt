package ru.brainix.ept.ankiphysics.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.brainix.ept.ankiphysics.R
import android.widget.TextView
import android.graphics.Typeface



class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTypeface = Typeface.createFromAsset(assets, "fonts/neonfont.otf")
        val myTextView = findViewById<TextView>(R.id.textView)
        myTextView.typeface = myTypeface





    }



}



