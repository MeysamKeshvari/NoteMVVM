package dev.meysamkeshvari.notemvvm.utility

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import dev.meysamkeshvari.notemvvm.R
import dev.meysamkeshvari.notemvvm.databinding.CustomToastBinding

fun Toast.showToastCustomView(color: Int,message: String, image: Int, context: Context) {
    val customView:View = LayoutInflater.from(context).inflate(R.layout.custom_toast,null)
    val viewLine = customView.findViewById<View>(R.id.viewLine)
    val textView = customView.findViewById<TextView>(R.id.textView)
    val imageView = customView.findViewById<AppCompatImageView>(R.id.imageView)
    viewLine.setBackgroundResource(color)
    textView.text = message
    imageView.setBackgroundResource(image)


    this.apply {
        setGravity(Gravity.BOTTOM, 0, 100)
        duration = Toast.LENGTH_LONG
        view = customView
        show()
    }
}