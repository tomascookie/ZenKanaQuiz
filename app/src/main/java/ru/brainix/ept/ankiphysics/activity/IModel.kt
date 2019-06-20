package ru.brainix.ept.ankiphysics.activity

import ru.brainix.ept.ankiphysics.common.StateDataModel

interface IModel {

    fun generateDataModel(): StateDataModel

    fun changeMod(mode:Int)
}