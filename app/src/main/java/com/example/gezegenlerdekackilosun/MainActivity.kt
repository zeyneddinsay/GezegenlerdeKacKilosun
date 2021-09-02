package com.example.gezegenlerdekackilosun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.View.OnClickListener
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener {
    val POUND_TO_KILO=0.45359237
    val KILO_TO_POUND=2.2045
    val MARS=0.38
    val VENUS=0.91
    val JUPITER=2.34


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbJupiter.setOnClickListener(this)
        cbMars.setOnClickListener(this)
        cbVenus.setOnClickListener(this)



     /*   btnHesapla.setOnClickListener {

            var kullaniciAgirlikPound= kiloToPound( kullaniciKilo.toString().toDouble() )
            var marstakiAgirlikPound=kullaniciAgirlikPound*MARS
            var marstakiAgirlikKilo=poundToKilo(marstakiAgirlikPound)

            tvSonuc.text=marstakiAgirlikKilo.toString()


        }*/

    }

    fun kiloToPound(kilo: Double):Double{

        return kilo*KILO_TO_POUND

    }

    fun poundToKilo(pound:Double):Double{
        return pound * POUND_TO_KILO
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean=v.isChecked


        if (! TextUtils.isEmpty(etKilo.text.toString())){
            var kullaniciKilo=etKilo.text.toString().toDouble()
            var kullaniciPound=kiloToPound(kullaniciKilo)

            when(v.id){
                R.id.cbMars->if(isChecked ){
                    cbJupiter.isChecked=false
                    cbVenus.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)

                }
                R.id.cbJupiter->if(isChecked){
                    cbMars.isChecked=false
                    cbVenus.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)

                }
                R.id.cbVenus->if(isChecked ){
                    cbJupiter.isChecked=false
                    cbMars.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)

                }

            }
        }


    }


    fun hesaplaAgirlikPound(pound:Double, checkBox: CheckBox){

        var sonuc:Double=0.0

        when(checkBox.id){

            R.id.cbMars->sonuc=pound*MARS
            R.id.cbVenus->sonuc=pound*VENUS
            R.id.cbJupiter->sonuc=pound*JUPITER

            else ->sonuc=0.0
        }
        var sonucToKilo=poundToKilo(sonuc)
        tvSonuc.text=sonucToKilo.toString()

    }

}