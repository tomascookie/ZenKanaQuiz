package ru.brainix.ept.ankiphysics.activity

interface IView {

    fun setButtonText(butText:Array<String?>)

    fun correctAnswer(butNum:Int)

    fun incorrectAnswer(butNum:Int)

    fun setImageAnimation(butNum:Int)

    fun buttonTopChanger(butNum:Int)

    fun setAssetImg(fileName:String)
}