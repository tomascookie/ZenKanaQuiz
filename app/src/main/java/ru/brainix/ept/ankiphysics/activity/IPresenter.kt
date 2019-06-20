package ru.brainix.ept.ankiphysics.activity

interface IPresenter {

    fun onViewCreate()

    fun onViewDestroy()

    fun buttonClicked(butNum:Int)

    fun buttonTopClicked(butNum:Int)

    fun animationStarted()

    fun animationEnded()
}