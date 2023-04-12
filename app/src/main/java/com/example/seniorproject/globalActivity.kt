package com.example.seniorproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class globalActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global)

        val buttonWorld : ImageButton = findViewById(R.id.buttonWorld)
        val buttonAfrica : ImageButton = findViewById(R.id.buttonAfrica)
        val buttonEurope : ImageButton = findViewById(R.id.buttonEurope)
        val buttonAsia : ImageButton = findViewById(R.id.buttonAsia)
        val buttonAustralia : ImageButton = findViewById(R.id.buttonAustralia)
        val buttonNorth : ImageButton = findViewById(R.id.buttonNorth)
        val buttonSouth : ImageButton = findViewById(R.id.buttonSouth)


        val btnAdvice : ImageButton = findViewById(R.id.advice)


        btnAdvice.setOnClickListener{

            val toast = Toast.makeText(
                applicationContext,
                " Click the global area that\n you want to observe  ", Toast.LENGTH_LONG
            )
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
            toast.show()
        }


        buttonWorld.setOnClickListener{

            val case = 0
            val intentWorld = Intent (this@globalActivity,continentActivity::class.java)
            intentWorld.putExtra("globalActivitySelected",case)
            startActivity(intentWorld)
        }
        buttonAfrica.setOnClickListener{
            val case = 1
            val intentAfrica = Intent (this@globalActivity,continentActivity::class.java)
            intentAfrica.putExtra("globalActivitySelected",case)
            startActivity(intentAfrica)
        }
        buttonEurope.setOnClickListener{
            val case = 2
            val intentEurope = Intent (this@globalActivity,continentActivity::class.java)
            intentEurope.putExtra("globalActivitySelected",case)
            startActivity(intentEurope)

        }
        buttonAsia.setOnClickListener{
            val case = 3
            val intentAsia = Intent (this@globalActivity,continentActivity::class.java)
            intentAsia.putExtra("globalActivitySelected",case)
            startActivity(intentAsia)

        }
        buttonNorth.setOnClickListener{
            val case = 4
            val intentNorth = Intent (this@globalActivity,continentActivity::class.java)
            intentNorth.putExtra("globalActivitySelected",case)
            startActivity(intentNorth)

        }
        buttonSouth.setOnClickListener{
            val case = 5
            val intentSouth = Intent (this@globalActivity,continentActivity::class.java)
            intentSouth.putExtra("globalActivitySelected",case)
            startActivity(intentSouth)

        }
        buttonAustralia.setOnClickListener{
            val case = 6
            val intentAustralia = Intent (this@globalActivity,continentActivity::class.java)
            intentAustralia.putExtra("globalActivitySelected",case)
            startActivity(intentAustralia)
        }
























    }// onCreate end
}// class end