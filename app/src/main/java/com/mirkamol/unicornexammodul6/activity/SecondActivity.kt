package com.mirkamol.unicornexammodul6.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.mirkamol.unicornexammodul6.R

class SecondActivity : AppCompatActivity() {
    lateinit var ivCancel:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        ivCancel = findViewById(R.id.ivCancel)

        ivCancel.setOnClickListener {
            finish()
        }

    }
}