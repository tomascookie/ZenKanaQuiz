package ru.brainix.ept.ankiphysics.activity

import ru.brainix.ept.ankiphysics.common.StateDataModel

class MainPresenter(private var mainView: IView?):IPresenter {

    private var symbModel: StateDataModel = MainModel().generateDataModel()


    override fun onViewCreate() {

        mainView?.setButtonText(symbModel.buttonsName)
        mainView?.buttonTopChanger(symbModel.mode)
        mainView?.setAssetImg(symbModel.currentImageName)
    }

    override fun onViewDestroy() {
        mainView = null
    }

    override fun buttonClicked(butNum:Int){

        if("$butNum" == symbModel.buttonsName[4]){  mainView?.correctAnswer(butNum) }

        else {  mainView?.incorrectAnswer(butNum) }

        mainView?.setImageAnimation(butNum)

        symbModel = MainModel().generateDataModel()
    }

    override fun buttonTopClicked(butNum:Int){
        mainView?.buttonTopChanger(butNum)
        MainModel().changeMod(butNum)
    }

    override fun animationStarted(){
        mainView?.setAssetImg(symbModel.currentImageAnswerName)
    }

    override fun animationEnded(){
        mainView?.setAssetImg(symbModel.currentImageName)
    }

}