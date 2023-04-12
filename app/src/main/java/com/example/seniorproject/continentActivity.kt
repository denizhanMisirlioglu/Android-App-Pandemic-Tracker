package com.example.seniorproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class continentActivity : AppCompatActivity() {

    private lateinit var dbContinentAct : FirebaseFirestore
    private lateinit var findContinent : ArrayList<country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continent)
          findContinent = arrayListOf()

        val btnGoMainAct : ImageButton = findViewById(R.id.buttonGoMainAct)





        dbContinentAct = FirebaseFirestore.getInstance()
        val bundle : Bundle?= intent.extras

        var case = bundle!!.getInt( "globalActivitySelected")
        btnGoMainAct.setOnClickListener{

            val intentContinentAct = Intent (this@continentActivity,MainActivity::class.java)
            intentContinentAct.putExtra("continentActSelected",case)
            startActivity(intentContinentAct)
        }

        when(case){
             0 ->   continent("World") // World

             1-> continent("Africa")

             2-> continent("Europe")

             3->  continent("Asia")

             4->continent("North America")

             5-> continent("South America")

             6->  continent("Oceania")

        }

    }//onCreate end

    private fun continent(continent:String){

        val locationSecond : TextView = findViewById(R.id.tvSecondLocation)
        val new_testsSecond : TextView =  findViewById(R.id.tvSecondNewTests)
        val populationSecond : TextView = findViewById(R.id.tvSecondPopulation)
        val new_casesSecond : TextView = findViewById(R.id.tvSecondNewCases)
        val total_casesSecond : TextView = findViewById(R.id.tvSecondTotalCases)

        val new_deathsSecond : TextView = findViewById(R.id.tvSecondNewDeaths)
        val total_deathsSecond : TextView = findViewById(R.id.tvSecondTotalDeaths)
        val total_vaccinationsSecond : TextView = findViewById(R.id.tvSecondTotalVaccination)
        val total_testsSecond : TextView = findViewById(R.id.tvSecondTotalTests)


        dbContinentAct.collection("covidData").whereEqualTo("location", continent)

            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    findContinent.add(document.toObject(country::class.java))
                }

                if(findContinent.isNotEmpty()){
                    val location = findContinent[0].location.toString()
                    val total_deaths =findContinent[0].total_deaths.toString()
                    val population =findContinent[0].population.toString()
                    val  continent =findContinent[0].continent.toString()
                    val new_deaths =findContinent[0].new_deaths.toString()
                    val new_tests =findContinent[0].new_tests.toString()
                    val total_tests =findContinent[0].total_tests.toString()
                    val total_vaccinations =findContinent[0].total_vaccinations.toString()
                    val new_cases =findContinent[0].new_cases.toString()
                    val total_cases =findContinent[0].total_cases.toString()


                    if(new_tests == "null"){
                        new_testsSecond.text = "unknown "
                    }
                    else{
                        new_testsSecond.text = new_tests
                    }
                    if (location == "null"){
                        locationSecond.text = "unknown"
                    }
                    else{
                        locationSecond.text = location
                    }

                    if (population == "null"){
                        populationSecond.text = "unknown"
                    }
                    else{
                        populationSecond.text = population
                    }
                    if (new_deaths== "null"){
                        new_deathsSecond.text = "unknown"
                    }
                    else{
                        new_deathsSecond.text = new_deaths
                    }
                    if (total_deaths == "null"){
                        total_deathsSecond.text = "unknown"
                    }
                    else{
                        total_deathsSecond.text = total_deaths
                    }
                    if (total_tests == "null"){
                        total_testsSecond.text = "unknown"
                    }
                    else{
                        total_testsSecond.text = total_tests
                    }
                    if (new_cases == "null"){
                        new_casesSecond.text = "unknown"
                    }
                    else{
                        new_casesSecond.text = new_cases
                    }
                    if (total_cases == "null"){
                        total_casesSecond.text = "unknown"
                    }
                    else{
                        total_casesSecond.text = total_cases

                    }
                    if (total_vaccinations =="null"){
                        total_vaccinationsSecond.text = "unknown"
                    }
                    else{
                        total_vaccinationsSecond.text = total_vaccinations
                    }

                }
            }
            .addOnFailureListener { exception ->
            }

    }
}// class End