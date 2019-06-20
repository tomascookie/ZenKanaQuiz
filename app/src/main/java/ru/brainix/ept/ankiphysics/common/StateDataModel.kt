package ru.brainix.ept.ankiphysics.common

data class StateDataModel(

        var mode:Int,
        var currentSymbol:Int,
        var currentImageName:String,
        var currentImageAnswerName:String,
        var buttonsName: Array<String?>
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StateDataModel

        if (mode != other.mode) return false
        if (currentSymbol != other.currentSymbol) return false

        return true
    }

    override fun hashCode(): Int {
        var result = mode
        result = 31 * result + currentSymbol
        return result
    }

}