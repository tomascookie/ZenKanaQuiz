package ru.brainix.ept.ankiphysics.fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import ru.brainix.ept.ankiphysics.R
import android.support.v4.graphics.drawable.DrawableCompat
import ru.brainix.ept.ankiphysics.activity.IView
import ru.brainix.ept.ankiphysics.activity.MainPresenter

class ContentFragment:Fragment(), IView {

    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button

    private lateinit var btnTop1 : Button
    private lateinit var btnTop2 : Button
    private lateinit var btnTop3 : Button

    private lateinit var image:ImageView

    private val mPresenter = MainPresenter(this)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1 = view.findViewById(R.id.button1)
        btn2 = view.findViewById(R.id.button2)
        btn3 = view.findViewById(R.id.button3)
        btn4 = view.findViewById(R.id.button4)

        btnTop1 = view.findViewById(R.id.buttonTop1)
        btnTop2 = view.findViewById(R.id.buttonTop2)
        btnTop3 = view.findViewById(R.id.buttonTop3)

        image = view.findViewById(R.id.imageView)


        mPresenter.onViewCreate()

        btnTop1.setOnClickListener {

            mPresenter.buttonTopClicked(1)

        }

        btnTop2.setOnClickListener {

            mPresenter.buttonTopClicked(2)
        }

        btnTop3.setOnClickListener {

            mPresenter.buttonTopClicked(3)

        }


        btn1.setOnClickListener { mPresenter.buttonClicked(1) }

        btn2.setOnClickListener { mPresenter.buttonClicked(2) }

        btn3.setOnClickListener { mPresenter.buttonClicked(3) }

        btn4.setOnClickListener { mPresenter.buttonClicked(4) }


    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onViewDestroy()
    }


    override fun setImageAnimation(butNum:Int) {

        lateinit var button : Button

        when (butNum){
            1 -> button = btn1
            2 -> button = btn2
            3 -> button = btn3
            4 -> button = btn4
        }


        YoYo.with(Techniques.DropOut)
                .onStart {

                    mPresenter.animationStarted()
                }
                .onEnd {

                    buttonTintChanger(button, resources.getColor(R.color.colorAccent))
                    mPresenter.onViewCreate()
                }
                .playOn(image)
    }

    override fun correctAnswer(butNum:Int) {

        lateinit var button : Button

        when (butNum){
            1 -> button = btn1
            2 -> button = btn2
            3 -> button = btn3
            4 -> button = btn4
        }

        buttonTintChanger(button, resources.getColor(R.color.colorGreen_A400))
    }

    override fun incorrectAnswer(butNum:Int) {

        var button:Button? = null

        when (butNum){
            1 -> button = btn1
            2 -> button = btn2
            3 -> button = btn3
            4 -> button = btn4
        }

        buttonTintChanger(button!!, resources.getColor(R.color.colorRed_900))
    }


    override fun setButtonText(butText:Array<String?>){
        btn1.text = butText[0]
        btn2.text = butText[1]
        btn3.text = butText[2]
        btn4.text = butText[3]
    }

    override fun buttonTopChanger(butNum: Int) {
       when(butNum){
            1 -> {
                buttonTintChanger(btnTop1, resources.getColor(R.color.colorPurple_900))
                buttonTintChanger(btnTop2, resources.getColor(R.color.colorPurple_A400))
                buttonTintChanger(btnTop3, resources.getColor(R.color.colorPurple_A400))
            }
            2 -> {
                buttonTintChanger(btnTop2, resources.getColor(R.color.colorPurple_900))
                buttonTintChanger(btnTop1, resources.getColor(R.color.colorPurple_A400))
                buttonTintChanger(btnTop3, resources.getColor(R.color.colorPurple_A400))
            }
            3 -> {
                buttonTintChanger(btnTop3, resources.getColor(R.color.colorPurple_900))
                buttonTintChanger(btnTop1, resources.getColor(R.color.colorPurple_A400))
                buttonTintChanger(btnTop2, resources.getColor(R.color.colorPurple_A400))
            }
        }

    }

    private fun buttonTintChanger(button:Button, color:Int){

        var buttonDrawable = button.background
        buttonDrawable = DrawableCompat.wrap(buttonDrawable)
        //the color is a direct color int and not a color resource
        DrawableCompat.setTint(buttonDrawable, color)
      //  button.background = buttonDrawable
    }

    override fun setAssetImg(fileName:String){
        try {
            // get input stream
            val inputStream = context!!.assets.open(fileName)
            // load image as Drawable
            val d = BitmapFactory.decodeStream(inputStream)
            //			Bitmap  bitmap = BitmapFactory.decodeStream(is);
            // set image to ImageView
            image.setImageBitmap(d)
            //iw.layoutParams.height = 600
            //                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          iw.layoutParams.width = 600
            image.scaleType = ImageView.ScaleType.FIT_CENTER
            inputStream.close()
        } catch (ex: IndexOutOfBoundsException) {
        }

    }


}




