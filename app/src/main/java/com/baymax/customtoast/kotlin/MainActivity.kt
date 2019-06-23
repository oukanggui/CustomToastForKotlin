package com.baymax.customtoast.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showSystemToast.setOnClickListener {
            Toast.makeText(this,"System Toast",Toast.LENGTH_SHORT).show()
        }
        showCustomToast.setOnClickListener {
            var toastHelper = ToastHelper(this)
            toastHelper.setText("I am baymax from Custom Toast")
            toastHelper.show()
        }

    }
}
