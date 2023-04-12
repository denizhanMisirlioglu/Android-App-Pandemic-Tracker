package com.example.seniorproject

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_home_page.*

class homePageActivity : AppCompatActivity() {
    private  lateinit var dbHomePage: FirebaseFirestore
    private lateinit var lastUpdateCountry : ArrayList<country>




    override fun onCreate(savedInstanceState: Bundle?) {

        lastUpdateCountry= arrayListOf()


        dbHomePage =  FirebaseFirestore.getInstance()

        dbHomePage.collection("covidData").whereEqualTo("location","World").limit(1)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    lastUpdateCountry.add(document.toObject(country::class.java))
                }

                val TVlastUpdate : TextView = findViewById(R.id.TextViewlastUpdate)

                if(lastUpdateCountry.isNotEmpty()){
                    //TVlastUpdate.text = lastUpdateCountry[0].last_updated_date.toString()
                    TVlastUpdate.text = lastUpdateCountry[0].last_updated_date.toString()

                }
                else{
                    TVlastUpdate.text ="27-04-2022"
                }
                //
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val btnGoWorldMap : ImageButton = findViewById(R.id.buttonGoWorldMap)

        buttonGoWorldMap.setOnClickListener{
            val intent2 = Intent (this@homePageActivity,globalActivity::class.java)
            startActivity(intent2)

        }




























    }
}