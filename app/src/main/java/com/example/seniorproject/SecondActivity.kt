package com.example.seniorproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        val locationSecond : TextView = findViewById(R.id.tvSecondLocation)
        val new_testsSecond : TextView =  findViewById(R.id.tvSecondNewTests)
        val populationSecond : TextView = findViewById(R.id.tvSecondPopulation)
        val new_casesSecond : TextView = findViewById(R.id.tvSecondNewCases)
        val total_casesSecond : TextView = findViewById(R.id.tvSecondTotalCases)
        val continentSecond : TextView = findViewById(R.id.tvSecondContinent)
        val new_deathsSecond : TextView = findViewById(R.id.tvSecondNewDeaths)
        val total_deathsSecond : TextView = findViewById(R.id.tvSecondTotalDeaths)
        val total_vaccinationsSecond : TextView = findViewById(R.id.tvSecondTotalVaccination)
        val total_testsSecond : TextView = findViewById(R.id.tvSecondTotalTests)

        val bundle : Bundle?= intent.extras

        val location = bundle!!.getString( "location")
        val total_deaths = bundle!!.getString("total_deaths")
        val population = bundle!!.getString( "population")
        val  continent = bundle!!.getString( "continent")
        val new_deaths = bundle!!.getString( "new_deaths")
        val new_tests = bundle!!.getString( "new_tests")
        val total_tests = bundle!!.getString( "total_tests")
        val total_vaccinations = bundle!!.getString( "total_vaccinations")
        val new_cases = bundle!!.getString( "new_cases")
        val total_cases = bundle!!.getString( "total_cases")

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
        if (continent == "null"){
          continentSecond.text = "unknown"
        }
        else{
            continentSecond.text = continent
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