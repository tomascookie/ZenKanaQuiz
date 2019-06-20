package ru.brainix.ept.ankiphysics.activity

import android.content.Context
import ru.brainix.ept.ankiphysics.common.App
import ru.brainix.ept.ankiphysics.common.Data
import ru.brainix.ept.ankiphysics.common.SaveInShared
import ru.brainix.ept.ankiphysics.common.StateDataModel

class MainModel: IModel {


    override fun generateDataModel(): StateDataModel {

        val currentSymb = generateNextNumber()
        val context: Context = App.applicationContext()
        val mode =  SaveInShared().loadData(context)


        return StateDataModel(
            mode,
            currentSymb,
            generateNextImageName(mode, currentSymb),
            generateNextImageAnswer(currentSymb),
            getNextKeyPack(currentSymb)
        )

    }

    override fun changeMod(mode:Int){

        SaveInShared().saveData(mode, App.applicationContext())

    }


    private fun generateNextNumber(): Int {
        return (1..47).random()
    }

    private fun generateNextImageName(mode:Int ,currentSymb: Int):String{

        var imageName = "katakana/char_k1.png"

        when(mode){
            //Katakana

            1 -> imageName = "katakana/char_k$currentSymb.png"

            //Random
            2 -> {
                imageName = if((0..1).random()==1){

                    "katakana/char_k$currentSymb.png"
                } else{

                    "hiragana/char_h$currentSymb.png"
                }
            }

            //Hiragana
            3 -> imageName = "hiragana/char_h$currentSymb.png"
        }

        return imageName
    }

    private fun generateNextImageAnswer(currentSymb:Int):String{

        return "key/key$currentSymb.png"
    }

    private fun getNextKeyPack(needSymb: Int): Array<String?> {
        val returnedArray = arrayOfNulls<String>(5)

        //Создаем массив 4х вариантов для кнопок

        val positionCorrect = (0..3).random()

        returnedArray[positionCorrect]= Data.symbArray[needSymb]

        returnedArray[4]=(positionCorrect+1).toString()

        //Выбираем случайную позицию из 4х для верного ответа

        //Оставшиеся позиции заполнить случайфными и уникальными переменными


        for(i in 0..3){
            if(returnedArray[i]==null) {
                while(returnedArray[i]==null){
                    val buttonPretend = (1..47).random()
                    if(!returnedArray.contains(Data.symbArray[buttonPretend])){
                        returnedArray[i]= Data.symbArray[buttonPretend]

                    }
                }
            }
        }


        return returnedArray
    }


}