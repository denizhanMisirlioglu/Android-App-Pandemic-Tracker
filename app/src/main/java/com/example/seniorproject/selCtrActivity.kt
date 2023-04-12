package com.example.seniorproject

import android.content.ContentValues
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.LargeValueFormatter
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate



class selCtrActivity : AppCompatActivity() {



    // country object ArrayList from selected   country Locations
    private  lateinit var selCountry: ArrayList<country>

    // tableTextView Arrays
    private lateinit var  tblLocationArray: Array<TextView>
    private lateinit var  tblLocationSecondArray: Array<TextView>
    private lateinit var  tblTotalDeathArray: Array<TextView>
    private lateinit var  tblNewDeathArray: Array<TextView>
    private lateinit var  tblTotalCaseArray: Array<TextView>
    private lateinit var  tblNewCaseArray: Array<TextView>
    private lateinit var  tblTotalVaccinArray: Array<TextView>
    private lateinit var  tblTotalTestArray: Array<TextView>
    private lateinit var  tblNewTestArray: Array<TextView>

    //sorted Country ArrayLists

    private  lateinit var sortPopulation: ArrayList<country>
    private  lateinit var sortTotalDeath: ArrayList<country>
    private  lateinit var sortNewDeath: ArrayList<country>
    private  lateinit var sortTotalCase: ArrayList<country>
    private  lateinit var sortNewCase: ArrayList<country>
    private  lateinit var sortTotalVaccin: ArrayList<country>
    private  lateinit var sortTotalTest: ArrayList<country>
    private  lateinit var sortNewTest: ArrayList<country>

    private  lateinit var sortDesPopulation: ArrayList<country>
    private  lateinit var sortDesTotalDeath: ArrayList<country>
    private  lateinit var sortDesNewDeath: ArrayList<country>
    private  lateinit var sortDesTotalCase: ArrayList<country>
    private  lateinit var sortDesNewCase: ArrayList<country>
    private  lateinit var sortDesTotalVaccin: ArrayList<country>
    private  lateinit var sortDesTotalTest: ArrayList<country>
    private  lateinit var sortDesNewTest: ArrayList<country>

    // barChart
    private lateinit var barChart: BarChart
    private lateinit var scoreList : ArrayList<Score>
    private lateinit var  dataEntries: ArrayList<PieEntry>

    // pieChart
    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sel_ctr)

        // barchart ArrayList
        scoreList = arrayListOf()
        dataEntries = arrayListOf()

//sorted Country ArrayLists
        sortPopulation = arrayListOf()
        sortTotalDeath = arrayListOf()
        sortNewDeath = arrayListOf()
        sortTotalCase = arrayListOf()
        sortNewCase = arrayListOf()
        sortTotalVaccin = arrayListOf()
        sortTotalTest = arrayListOf()
        sortNewTest = arrayListOf()

        sortDesPopulation = arrayListOf()
        sortDesTotalDeath = arrayListOf()
        sortDesNewDeath = arrayListOf()
        sortDesTotalCase = arrayListOf()
        sortDesNewCase = arrayListOf()
        sortDesTotalVaccin = arrayListOf()
        sortDesTotalTest = arrayListOf()
        sortDesNewTest = arrayListOf()

        // table

        selCountry = arrayListOf()
        val bundle : Bundle?= intent.extras
        val selCountry = bundle!!.getParcelableArrayList<country>( "selCtrObjectArrList")

            if(selCountry !=null){   // intent  for selected  Countries
                // table textView Val creation
                // table  textView Location
                val tblLocation1: TextView = findViewById(R.id.tblLocation1)
                val tblLocation2: TextView = findViewById(R.id.tblLocation2)
                val tblLocation3: TextView = findViewById(R.id.tblLocation3)
                val tblLocation4: TextView = findViewById(R.id.tblLocation4)
                val tblLocation5: TextView = findViewById(R.id.tblLocation5)
                val tblLocation6: TextView = findViewById(R.id.tblLocation6)
                val tblLocation7: TextView = findViewById(R.id.tblLocation7)
                val tblLocation8: TextView = findViewById(R.id.tblLocation8)
                val tblLocation9: TextView = findViewById(R.id.tblLocation9)
                val tblLocation10: TextView = findViewById(R.id.tblLocation10)

                val tblLocationSecond1: TextView = findViewById(R.id.tblLocationSecond1)
                val tblLocationSecond2: TextView = findViewById(R.id.tblLocationSecond2)
                val tblLocationSecond3: TextView = findViewById(R.id.tblLocationSecond3)
                val tblLocationSecond4: TextView = findViewById(R.id.tblLocationSecond4)
                val tblLocationSecond5: TextView = findViewById(R.id.tblLocationSecond5)
                val tblLocationSecond6: TextView = findViewById(R.id.tblLocationSecond6)
                val tblLocationSecond7: TextView = findViewById(R.id.tblLocationSecond7)
                val tblLocationSecond8: TextView = findViewById(R.id.tblLocationSecond8)
                val tblLocationSecond9: TextView = findViewById(R.id.tblLocationSecond9)
                val tblLocationSecond10: TextView = findViewById(R.id.tblLocationSecond10)

// table textView TotalCase
                val tblTotalCase1: TextView = findViewById(R.id.tblTotalCase1)
                val tblTotalCase2: TextView = findViewById(R.id.tblTotalCase2)
                val tblTotalCase3: TextView = findViewById(R.id.tblTotalCase3)
                val tblTotalCase4: TextView = findViewById(R.id.tblTotalCase4)
                val tblTotalCase5: TextView = findViewById(R.id.tblTotalCase5)
                val tblTotalCase6: TextView = findViewById(R.id.tblTotalCase6)
                val tblTotalCase7: TextView = findViewById(R.id.tblTotalCase7)
                val tblTotalCase8: TextView = findViewById(R.id.tblTotalCase8)
                val tblTotalCase9: TextView = findViewById(R.id.tblTotalCase9)
                val tblTotalCase10: TextView = findViewById(R.id.tblTotalCase10)

// table textView NewCase
                val tblNewCase1: TextView = findViewById(R.id.tblNewCase1)
                val tblNewCase2: TextView = findViewById(R.id.tblNewCase2)
                val tblNewCase3: TextView = findViewById(R.id.tblNewCase3)
                val tblNewCase4: TextView = findViewById(R.id.tblNewCase4)
                val tblNewCase5: TextView = findViewById(R.id.tblNewCase5)
                val tblNewCase6: TextView = findViewById(R.id.tblNewCase6)
                val tblNewCase7: TextView = findViewById(R.id.tblNewCase7)
                val tblNewCase8: TextView = findViewById(R.id.tblNewCase8)
                val tblNewCase9: TextView = findViewById(R.id.tblNewCase9)
                val tblNewCase10: TextView = findViewById(R.id.tblNewCase10)

// table textView TotalDeath
                val tblTotalDeath1: TextView = findViewById(R.id.tblTotalDeath1)
                val tblTotalDeath2: TextView = findViewById(R.id.tblTotalDeath2)
                val tblTotalDeath3: TextView = findViewById(R.id.tblTotalDeath3)
                val tblTotalDeath4: TextView = findViewById(R.id.tblTotalDeath4)
                val tblTotalDeath5: TextView = findViewById(R.id.tblTotalDeath5)
                val tblTotalDeath6: TextView = findViewById(R.id.tblTotalDeath6)
                val tblTotalDeath7: TextView = findViewById(R.id.tblTotalDeath7)
                val tblTotalDeath8: TextView = findViewById(R.id.tblTotalDeath8)
                val tblTotalDeath9: TextView = findViewById(R.id.tblTotalDeath9)
                val tblTotalDeath10: TextView = findViewById(R.id.tblTotalDeath10)

// table textView NewDeath
                val tblNewDeath1: TextView = findViewById(R.id.tblNewDeath1)
                val tblNewDeath2: TextView = findViewById(R.id.tblNewDeath2)
                val tblNewDeath3: TextView = findViewById(R.id.tblNewDeath3)
                val tblNewDeath4: TextView = findViewById(R.id.tblNewDeath4)
                val tblNewDeath5: TextView = findViewById(R.id.tblNewDeath5)
                val tblNewDeath6: TextView = findViewById(R.id.tblNewDeath6)
                val tblNewDeath7: TextView = findViewById(R.id.tblNewDeath7)
                val tblNewDeath8: TextView = findViewById(R.id.tblNewDeath8)
                val tblNewDeath9: TextView = findViewById(R.id.tblNewDeath9)
                val tblNewDeath10: TextView = findViewById(R.id.tblNewDeath10)

// table textView TotalVaccin
                val tblTotalVaccin1: TextView = findViewById(R.id.tblTotalVaccin1)
                val tblTotalVaccin2: TextView = findViewById(R.id.tblTotalVaccin2)
                val tblTotalVaccin3: TextView = findViewById(R.id.tblTotalVaccin3)
                val tblTotalVaccin4: TextView = findViewById(R.id.tblTotalVaccin4)
                val tblTotalVaccin5: TextView = findViewById(R.id.tblTotalVaccin5)
                val tblTotalVaccin6: TextView = findViewById(R.id.tblTotalVaccin6)
                val tblTotalVaccin7: TextView = findViewById(R.id.tblTotalVaccin7)
                val tblTotalVaccin8: TextView = findViewById(R.id.tblTotalVaccin8)
                val tblTotalVaccin9: TextView = findViewById(R.id.tblTotalVaccin9)
                val tblTotalVaccin10: TextView = findViewById(R.id.tblTotalVaccin10)

// table textView TotalTest
                val tblTotalTest1: TextView = findViewById(R.id.tblTotalTest1)
                val tblTotalTest2: TextView = findViewById(R.id.tblTotalTest2)
                val tblTotalTest3: TextView = findViewById(R.id.tblTotalTest3)
                val tblTotalTest4: TextView = findViewById(R.id.tblTotalTest4)
                val tblTotalTest5: TextView = findViewById(R.id.tblTotalTest5)
                val tblTotalTest6: TextView = findViewById(R.id.tblTotalTest6)
                val tblTotalTest7: TextView = findViewById(R.id.tblTotalTest7)
                val tblTotalTest8: TextView = findViewById(R.id.tblTotalTest8)
                val tblTotalTest9: TextView = findViewById(R.id.tblTotalTest9)
                val tblTotalTest10: TextView = findViewById(R.id.tblTotalTest10)

// table textView NewTest
                val tblNewTest1: TextView = findViewById(R.id.tblNewTest1)
                val tblNewTest2: TextView = findViewById(R.id.tblNewTest2)
                val tblNewTest3: TextView = findViewById(R.id.tblNewTest3)
                val tblNewTest4: TextView = findViewById(R.id.tblNewTest4)
                val tblNewTest5: TextView = findViewById(R.id.tblNewTest5)
                val tblNewTest6: TextView = findViewById(R.id.tblNewTest6)
                val tblNewTest7: TextView = findViewById(R.id.tblNewTest7)
                val tblNewTest8: TextView = findViewById(R.id.tblNewTest8)
                val tblNewTest9: TextView = findViewById(R.id.tblNewTest9)
                val tblNewTest10: TextView = findViewById(R.id.tblNewTest10)
                // adding table text views to array
                tblLocationArray = arrayOf(
                    tblLocation1,
                    tblLocation2,
                    tblLocation3,
                    tblLocation4,
                    tblLocation5,
                    tblLocation6,
                    tblLocation7,
                    tblLocation8,
                    tblLocation9,
                    tblLocation10
                )
                tblLocationSecondArray = arrayOf(
                    tblLocationSecond1,
                    tblLocationSecond2,
                    tblLocationSecond3,
                    tblLocationSecond4,
                    tblLocationSecond5,
                    tblLocationSecond6,
                    tblLocationSecond7,
                    tblLocationSecond8,
                    tblLocationSecond9,
                    tblLocationSecond10
                )
                tblTotalDeathArray = arrayOf(
                    tblTotalDeath1,
                    tblTotalDeath2,
                    tblTotalDeath3,
                    tblTotalDeath4,
                    tblTotalDeath5,
                    tblTotalDeath6,
                    tblTotalDeath7,
                    tblTotalDeath8,
                    tblTotalDeath9,
                    tblTotalDeath10
                )
                tblNewDeathArray = arrayOf(
                    tblNewDeath1,
                    tblNewDeath2,
                    tblNewDeath3,
                    tblNewDeath4,
                    tblNewDeath5,
                    tblNewDeath6,
                    tblNewDeath7,
                    tblNewDeath8,
                    tblNewDeath9,
                    tblNewDeath10
                )
                tblTotalCaseArray = arrayOf(
                    tblTotalCase1,
                    tblTotalCase2,
                    tblTotalCase3,
                    tblTotalCase4,
                    tblTotalCase5,
                    tblTotalCase6,
                    tblTotalCase7,
                    tblTotalCase8,
                    tblTotalCase9,
                    tblTotalCase10
                )
                tblNewCaseArray = arrayOf(
                    tblNewCase1,
                    tblNewCase2,
                    tblNewCase3,
                    tblNewCase4,
                    tblNewCase5,
                    tblNewCase6,
                    tblNewCase7,
                    tblNewCase8,
                    tblNewCase9,
                    tblNewCase10
                )
                tblTotalVaccinArray = arrayOf(
                    tblTotalVaccin1,
                    tblTotalVaccin2,
                    tblTotalVaccin3,
                    tblTotalVaccin4,
                    tblTotalVaccin5,
                    tblTotalVaccin6,
                    tblTotalVaccin7,
                    tblTotalVaccin8,
                    tblTotalVaccin9,
                    tblTotalVaccin10
                )
                tblTotalTestArray = arrayOf(
                    tblTotalTest1,
                    tblTotalTest2,
                    tblTotalTest3,
                    tblTotalTest4,
                    tblTotalTest5,
                    tblTotalTest6,
                    tblTotalTest7,
                    tblTotalTest8,
                    tblTotalTest9,
                    tblTotalTest10
                )
                tblNewTestArray = arrayOf(
                    tblNewTest1,
                    tblNewTest2,
                    tblNewTest3,
                    tblNewTest4,
                    tblNewTest5,
                    tblNewTest6,
                    tblNewTest7,
                    tblNewTest8,
                    tblNewTest9,
                    tblNewTest10
                )

                if(selCountry.isEmpty()){

                }
                else{

                    for (i in selCountry.indices) {
                        tblLocationArray[i].text = selCountry[i].location.toString()
                    }
                    for (i in selCountry.indices) {
                        tblLocationSecondArray[i].text = selCountry[i].location.toString()
                    }
// put totalCases -> table
                    for (i in selCountry.indices) {
                        tblTotalCaseArray[i].text = selCountry[i].total_cases.toString()
                    }
// put NewCases -> table
                    for (i in selCountry.indices) {
                        tblNewCaseArray[i].text = selCountry[i].new_cases.toString()
                    }
// put Total Death -> table
                    for (i in selCountry.indices) {
                        tblTotalDeathArray[i].text = selCountry[i].total_deaths.toString()
                    }
//put New Death -> table
                    for (i in selCountry.indices) {
                        tblNewDeathArray[i].text = selCountry[i].new_deaths.toString()
                    }
//put total Vaccin -> table
                    for (i in selCountry.indices) {
                        tblTotalVaccinArray[i].text = selCountry[i].total_vaccinations.toString()
                    }
// put total test -> table
                    for (i in selCountry.indices) {
                        tblTotalTestArray[i].text = selCountry[i].total_tests.toString()
                    }
// put new test -> table
                    for (i in selCountry.indices) {
                        tblNewTestArray[i].text = selCountry[i].new_tests.toString()
                    }
                    sortSelCountries(selCountry)  // activate sort click listener after first table implemented with sel countries

                }
            }
         } // onCreate

    private  fun sortSelCountries(selCountry:ArrayList<country>) {

        // sort
        sortPopulation = selCountry.sortedBy { it.population }.toCollection(ArrayList())
        sortTotalCase = selCountry.sortedBy { it.total_cases }.toCollection(ArrayList())
        sortNewCase = selCountry.sortedBy { it.new_cases }.toCollection(ArrayList())
        sortTotalDeath = selCountry.sortedBy { it.total_deaths }.toCollection(ArrayList())
        sortNewDeath = selCountry.sortedBy { it.new_deaths }.toCollection(ArrayList())
        sortTotalVaccin = selCountry.sortedBy { it.total_vaccinations }.toCollection(ArrayList())
        sortTotalTest = selCountry.sortedBy { it.total_tests }.toCollection(ArrayList())
        sortNewTest = selCountry.sortedBy { it.new_tests }.toCollection(ArrayList())

        // descending sort
         sortDesPopulation = selCountry.sortedByDescending { it.population }.toCollection(ArrayList())
         sortDesTotalCase = selCountry.sortedByDescending { it.total_cases }.toCollection(ArrayList())
        sortDesNewCase = selCountry.sortedByDescending { it.new_cases }.toCollection(ArrayList())
        sortDesTotalDeath = selCountry.sortedByDescending { it.total_deaths }.toCollection(ArrayList())
        sortDesNewDeath = selCountry.sortedByDescending { it.new_deaths }.toCollection(ArrayList())
        sortDesTotalVaccin = selCountry.sortedByDescending { it.total_vaccinations }.toCollection(ArrayList())
        sortDesTotalTest = selCountry.sortedByDescending { it.total_tests }.toCollection(ArrayList())
        sortDesNewTest = selCountry.sortedByDescending { it.new_tests }.toCollection(ArrayList())


        val nulls1 = sortPopulation.filter {it.population.toString()=="null"}
        sortPopulation.removeAll(nulls1)
        val nulls2 = sortTotalCase.filter {it.total_cases.toString()=="null"}
        sortTotalCase.removeAll(nulls2)
        val nulls3 = sortNewCase.filter {it.new_cases.toString()=="null"}
        sortNewCase.removeAll(nulls3)
        val nulls4 = sortTotalDeath.filter {it.total_deaths.toString()=="null"}
        sortTotalDeath.removeAll(nulls4)
        val nulls5 = sortNewDeath.filter {it.new_deaths.toString()=="null"}
        sortNewDeath.removeAll(nulls5)
        val nulls6 = sortTotalVaccin.filter {it.total_vaccinations.toString()=="null"}
        sortTotalVaccin.removeAll(nulls6)
        val nulls7 = sortTotalTest.filter {it.total_tests.toString()=="null"}
        sortTotalTest.removeAll(nulls7)

        val nulls8 = sortNewTest.filter {it.new_tests.toString()=="null"}
        sortNewTest.removeAll(nulls8)



        // descending null clean
        val nulls9 = sortDesPopulation.filter {it.population.toString()=="null"}
        sortDesPopulation.removeAll(nulls9)
        val nulls10 = sortDesTotalCase.filter {it.total_cases.toString()=="null"}
        sortDesTotalCase.removeAll(nulls10)
        val nulls11 = sortDesNewCase.filter {it.new_cases.toString()=="null"}
        sortDesNewCase.removeAll(nulls11)
        val nulls12 = sortDesTotalDeath.filter {it.total_deaths.toString()=="null"}
        sortDesTotalDeath.removeAll(nulls12)
        val nulls13 = sortDesNewDeath.filter {it.new_deaths.toString()=="null"}
        sortDesNewDeath.removeAll(nulls13)
        val nulls14 = sortDesTotalVaccin.filter {it.total_vaccinations.toString()=="null"}
        sortDesTotalVaccin.removeAll(nulls14)
        val nulls15 = sortDesTotalTest.filter {it.total_tests.toString()=="null"}
        sortDesTotalTest.removeAll(nulls15)
        val nulls16 = sortDesNewTest.filter {it.new_tests.toString()=="null"}
        sortDesNewTest.removeAll(nulls16)




                // barChart
                barChart = findViewById(R.id.barChart)
                pieChart = findViewById(R.id.pieChart)

                val btnAdvice : ImageButton = findViewById(R.id.advice)

                btnAdvice.setOnClickListener{

                    val toast = Toast.makeText(
                        applicationContext,
                        " Swipe Table Left \n Swipe Chart Left", Toast.LENGTH_LONG
                    )
                    toast.setGravity(Gravity.TOP    , 0, 0)
                    toast.show()
                }

                // drop down menu  listener
                listener()

    } // fun  end
private fun listener() {
    val sortOptions = resources.getStringArray(R.array.sortingOptions)
    val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, sortOptions)

    val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
    autocompleteTV.setAdapter(arrayAdapter)

    autocompleteTV.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
        val selected = parent.getItemAtPosition(position) as String

        Toast.makeText(this@selCtrActivity, selected, Toast.LENGTH_SHORT).show()

        if (selected == "population") {  // sort By Population
            //  put locations -> table
            sortSelect(sortPopulation, "population")

        } else if (selected == "totalDeaths") {
            // sort by Total Death
            sortSelect(sortTotalDeath, "total_deaths")

        } else if (selected == "newDeaths") {  // sort by new Death
            sortSelect(sortNewDeath, "new_deaths")

        } else if (selected == "totalCases") {  // sort by Total Death
            sortSelect(sortTotalCase, "total_cases")

        } else if (selected == "newCases") {  // sort by Total Death
            sortSelect(sortNewCase, "new_cases")

        } else if (selected == "totalVaccin") {  // sort by Total Death
            sortSelect(sortTotalVaccin, "total_vaccinations")

        } else if (selected == "totalTest") {  // sort by Total Death
            sortSelect(sortTotalTest, "total_tests")

        } else if (selected == "newTest") {  // sort by Total Death
            sortSelect(sortNewTest, "new_tests")

        } else if (selected == "descending population") {  // sort by Total Death
            sortSelect(sortDesPopulation, "population")


        } else if (selected == "descending totalDeaths") {  // sort by Total Death
            sortSelect(sortDesTotalDeath, "total_deaths")


        } else if (selected == "descending newDeaths") {  // sort by Total Death
            sortSelect(sortDesNewDeath, "new_deaths")


        } else if (selected == "descending totalCases") {  // sort by Total Death
            sortSelect(sortDesTotalCase, "total_cases")


        } else if (selected == "descending newCases") {  // sort by Total Death
            sortSelect(sortDesNewCase, "new_cases")


        } else if (selected == "descending totalVaccin") {
            sortSelect(sortDesTotalVaccin, "total_vaccinations")


        } else if (selected == "descending totalTest") {
            sortSelect(sortDesTotalTest, "total_tests")


        } else if (selected == "descending newTest") {
            sortSelect(sortDesNewTest, "new_tests")
        }

        // barChart in -> drop down menu Listener

        val entries: ArrayList<BarEntry> = ArrayList()
        for (i in scoreList.indices) {
            val score = scoreList[i]
            entries.add(BarEntry(i.toFloat(), score.score.toFloat()))
        }

        val barDataSet = BarDataSet(entries, "")
        barDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        barDataSet.setValueTextSize(12f)
        barDataSet.valueTextColor = Color.WHITE

        barDataSet.barBorderWidth = 13f
        barDataSet.valueFormatter = LargeValueFormatter()

        val data = BarData(barDataSet)
        barChart.data = data

        barChart.invalidate()
        // clear barChart list after every click on drop down menu  so we can change  data in the barChart List
        scoreList = arrayListOf()
        dataEntries = arrayListOf()


    }) // drop down menu listener  end

}

private fun sortSelect(sortArrayList:ArrayList<country>,objectGetSel : String){
    if(sortArrayList.isEmpty()){
        Toast.makeText(this@selCtrActivity, " NOT ENOUGH DATA ", Toast.LENGTH_SHORT).show()
    }
    else{
        ////////// clear table
        for (i in 0..9) {
            tblLocationArray[i].text = " "
        }
        for (i in 0..9) {
            tblLocationSecondArray[i].text = " "
        }
// put totalCases -> table
        for (i in 0..9) {
            tblTotalCaseArray[i].text = " "
        }
// put NewCases -> table
        for (i in 0..9) {
            tblNewCaseArray[i].text = " "
        }
// put Total Death -> table
        for (i in 0..9) {
            tblTotalDeathArray[i].text = " "
        }
//put New Death -> table
        for (i in 0..9) {
            tblNewDeathArray[i].text = " "
        }
//put total Vaccin -> table
        for (i in 0..9) {
            tblTotalVaccinArray[i].text = " "
        }
// put total test -> table
        for (i in 0..9) {
            tblTotalTestArray[i].text = " "
        }
// put new test -> table
        for (i in 0..9) {
            tblNewTestArray[i].text = " "
        }

        //  fill table with data
        for (i in sortArrayList.indices) {
            tblLocationArray[i].text = sortArrayList[i].location.toString()
        }
        for (i in sortArrayList.indices) {
            tblLocationSecondArray[i].text = sortArrayList[i].location.toString()
        }
// put totalCases -> table
        for (i in sortArrayList.indices) {
            tblTotalCaseArray[i].text = sortArrayList[i].total_cases.toString()
        }
// put NewCases -> table
        for (i in sortArrayList.indices) {
            tblNewCaseArray[i].text = sortArrayList[i].new_cases.toString()
        }
// put Total Death -> table
        for (i in sortArrayList.indices) {
            tblTotalDeathArray[i].text = sortArrayList[i].total_deaths.toString()
        }
//put New Death -> table
        for (i in sortArrayList.indices) {
            tblNewDeathArray[i].text = sortArrayList[i].new_deaths.toString()
        }
//put total Vaccin -> table
        for (i in sortArrayList.indices) {
            tblTotalVaccinArray[i].text = sortArrayList[i].total_vaccinations.toString()
        }
// put total test -> table
        for (i in sortArrayList.indices) {
            tblTotalTestArray[i].text = sortArrayList[i].total_tests.toString()
        }
// put new test -> table
        for (i in sortArrayList.indices) {
            tblNewTestArray[i].text = sortArrayList[i].new_tests.toString()
        }
        // put data to BarChart
        if (scoreList.count()<sortArrayList.count()) { // number off  element in the barChart
            if (sortArrayList.isNotEmpty()) {
                for (i in sortArrayList.indices) {
                    when(objectGetSel){
                        "population" -> scoreList.add(  Score(sortArrayList[i].location.toString(), sortArrayList[i].population.toString()))
                        "total_deaths"->scoreList.add(  Score(sortArrayList[i].location.toString(), sortArrayList[i].total_deaths.toString()))
                        "new_deaths"->scoreList.add(  Score(sortArrayList[i].location.toString(), sortArrayList[i].new_deaths.toString()))
                        "total_cases"->scoreList.add(  Score(sortArrayList[i].location.toString(), sortArrayList[i].total_cases.toString()))
                        "new_cases"->scoreList.add(  Score(sortArrayList[i].location.toString(), sortArrayList[i].new_cases.toString()))
                        "total_vaccinations"->scoreList.add(  Score(sortArrayList[i].location.toString(), sortArrayList[i].total_vaccinations.toString()))
                        "total_tests"->scoreList.add(  Score(sortArrayList[i].location.toString(), sortArrayList[i].total_tests.toString()))
                        "new_tests"->scoreList.add(  Score(sortArrayList[i].location.toString(), sortArrayList[i].new_tests.toString()))
                    }
                }
                initBarChart()
            }
            else{
                Toast.makeText(this@selCtrActivity, " NOT ENOUGH DATA ", Toast.LENGTH_SHORT).show()
            }
        } else {
            initBarChart()
        }
        // put data to PieChart
        if (dataEntries.count()<sortArrayList.count()){
            if (sortArrayList.isNotEmpty()) {
                for (i in sortArrayList.indices) {

                    when (objectGetSel) {
                        "population" -> dataEntries.add(
                            PieEntry(
                                sortArrayList[i].population!!.toFloat(),
                                sortArrayList[i].location.toString()
                            )
                        )
                        "total_deaths" -> dataEntries.add(
                            PieEntry(
                                sortArrayList[i].total_deaths!!.toFloat(),
                                sortArrayList[i].location.toString()
                            )
                        )
                        "new_deaths" -> dataEntries.add(
                            PieEntry(
                                sortArrayList[i].new_deaths!!.toFloat(),
                                sortArrayList[i].location.toString()
                            )
                        )
                        "total_cases" -> dataEntries.add(
                            PieEntry(
                                sortArrayList[i].total_cases!!.toFloat(),
                                sortArrayList[i].location.toString()
                            )
                        )
                        "new_cases" -> dataEntries.add(
                            PieEntry(
                                sortArrayList[i].new_cases!!.toFloat(),
                                sortArrayList[i].location.toString()
                            )
                        )
                        "total_vaccinations" -> dataEntries.add(
                            PieEntry(
                                sortArrayList[i].total_vaccinations!!.toFloat(),
                                sortArrayList[i].location.toString()
                            )
                        )
                        "total_tests" -> dataEntries.add(
                            PieEntry(
                                sortArrayList[i].total_tests!!.toFloat(),
                                sortArrayList[i].location.toString()
                            )
                        )
                        "new_tests" -> dataEntries.add(
                            PieEntry(
                                sortArrayList[i].new_tests!!.toFloat(),
                                sortArrayList[i].location.toString()
                            )
                        )
                    }
                }

                initPieChart()
                setDataToPieChart(objectGetSel)
            }
            else{
                Toast.makeText(this@selCtrActivity, " NOT ENOUGH DATA ", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            initPieChart()
            setDataToPieChart(objectGetSel)
        }
    }

}
// barChart
private fun initBarChart() {
    //  hide grid lines
    barChart.axisLeft.setDrawGridLines(false)
    val xAxis: XAxis = barChart.xAxis
    xAxis.setDrawGridLines(false)
    xAxis.setDrawAxisLine(false)
    //remove right y-axis
    barChart.axisRight.isEnabled = false
    barChart.getAxisRight().setDrawAxisLine(false)
    barChart.getAxisLeft().setDrawAxisLine(false)
    barChart.setExtraOffsets(-30f, 0f, 0f, 0f)
    //remove legend
    barChart.legend.isEnabled = false
    xAxis.setTextColor(Color.BLACK);
    barChart.getXAxis().textSize = 0F
    //remove description label
    barChart.description.isEnabled = false
    //add animation
    barChart.animateY(3000)
    // to draw label on xAxis
    xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
    xAxis.valueFormatter = MyAxisFormatter()
    xAxis.setDrawLabels(false)
    xAxis.granularity = 1f
    xAxis.labelRotationAngle = +90f
}
//pieChart
private fun initPieChart() {
    pieChart.setUsePercentValues(true)
    pieChart.description.text = "pieChart"
    //hollow pie chart
    pieChart.isDrawHoleEnabled = false
    pieChart.setTouchEnabled(true)
    pieChart.setDrawEntryLabels(false)
    //adding padding
    pieChart.setExtraOffsets(0f, 0f, 0f, 0f)
    pieChart.setUsePercentValues(true)
    pieChart.isRotationEnabled = true
    pieChart.setDrawEntryLabels(false)

    pieChart.legend.orientation = Legend.LegendOrientation.HORIZONTAL
    pieChart.legend.isWordWrapEnabled = true
    pieChart.legend.textColor = Color.WHITE
    pieChart.legend.textSize = 12f
}

private fun setDataToPieChart(centerText:String) {
    pieChart.setUsePercentValues(true)

    val colors: ArrayList<Int> = ArrayList()
    colors.add(Color.parseColor("#4DD0E1"))
    colors.add(Color.parseColor("#FFF176"))
    colors.add(Color.parseColor("#FF8A65"))
    colors.add(Color.parseColor("#00fa9a"))
    colors.add(Color.parseColor("#eecbad"))
    colors.add(Color.parseColor("#fffacd"))
    colors.add(Color.parseColor("#e6e6fa"))
    colors.add(Color.parseColor("#ffe4e1"))
    colors.add(Color.parseColor("#fff5ee"))
    colors.add(Color.parseColor("#cdcdc1"))

    val dataSet = PieDataSet(dataEntries, "")
    val data = PieData(dataSet)
    // In Percentage
    data.setValueFormatter(PercentFormatter())
    dataSet.sliceSpace = 3f
    dataSet.colors = colors
    pieChart.data = data
    data.setValueTextSize(15f)
    pieChart.setExtraOffsets(0f, 0f, 0f, 0f)
    pieChart.animateY(3500, Easing.EaseInOutQuad)
    //create hole in center
    pieChart.holeRadius = 75f
    pieChart.transparentCircleRadius = 61f
    pieChart.isDrawHoleEnabled = true
    pieChart.setHoleColor(Color.BLACK)
    val legend = pieChart.legend
    legend.form = Legend.LegendForm.CIRCLE
    legend.textSize = 12f
    legend.formSize = 20f
    legend.formToTextSpace = 2f
    //add text in center
    pieChart.setDrawCenterText(true);
    pieChart.centerText = "$centerText % "
    pieChart.setCenterTextSize(20f)
    pieChart.setCenterTextColor(Color.WHITE)
    pieChart.invalidate()
}

// barChart
  inner class MyAxisFormatter : IndexAxisValueFormatter() {

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        val index = value.toInt()
        Log.d(ContentValues.TAG, "getAxisLabel: index $index")
        return if (index < scoreList.size) {
            scoreList[index].location
        } else {
            ""
        }
    }
}








    }// class


