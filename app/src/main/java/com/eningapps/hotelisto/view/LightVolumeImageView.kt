package com.eningapps.hotelisto.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.eningapps.hotelisto.R

class LightVolumeImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var currentLevel = 2
    val state1: View
    val state2: View
    val state3: View

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_light_view, this, true)
        val up = view.findViewById<ImageView>(R.id.lightUpBtn)
        val down = view.findViewById<ImageView>(R.id.lightDownBtn)
        state1 = view.findViewById<ImageView>(R.id.lightStateImg1)
        state2 = view.findViewById<ImageView>(R.id.lightStateImg2)
        state3 = view.findViewById<ImageView>(R.id.lightStateImg3)
        up.setOnClickListener {
            if (currentLevel < 3) {
                currentLevel++
            }
            setState()
        }
        down.setOnClickListener {
            if (currentLevel > 0) {
                currentLevel--
            }
            setState()
        }
    }

    private fun setState() {
        when (currentLevel) {
            0 -> {
                state1.visibility = View.INVISIBLE
                state2.visibility = View.INVISIBLE
                state3.visibility = View.INVISIBLE
            }
            1 -> {
                state1.visibility = View.VISIBLE
                state2.visibility = View.INVISIBLE
                state3.visibility = View.INVISIBLE
            }
            2 -> {
                state2.visibility = View.VISIBLE
                state3.visibility = View.INVISIBLE
            }
            3 -> {
                state3.visibility = View.VISIBLE
            }
        }
    }
}