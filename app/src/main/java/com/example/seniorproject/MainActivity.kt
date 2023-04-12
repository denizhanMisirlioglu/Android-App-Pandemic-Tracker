package com.example.seniorproject

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.EventListener
import org.w3c.dom.Text
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    private  lateinit var recyclerView: RecyclerView
    private  lateinit var countryArrayList: ArrayList<country>

    private  lateinit var adapter: MyAdapter
    private  lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val selected: TextView =findViewById(R.id.tvSelCount)
        selected.text = "0/10"

        recyclerView.layoutManager = LinearLayoutManager (this)
        recyclerView.setHasFixedSize(true)

        countryArrayList = arrayListOf()

        val bundle : Bundle?= intent.extras

        var case = bundle!!.getInt( "continentActSelected")

        eventChangeListener(case,selected)

        val btnGoAct3 : ImageButton = findViewById(R.id.buttonGoActivity3)

        btnGoAct3.setOnClickListener{

            val intent2 = Intent (this@MainActivity,Activity3::class.java)
            intent2.putExtra("MainActivitySelected",case)
            startActivity(intent2)

        }

        val adviceBtnRight : ImageButton = findViewById(R.id.adviceLeft)
        adviceBtnRight.setOnClickListener{
            Toast.makeText(this@MainActivity, "  Button at Left : Selected countries data observation ", Toast.LENGTH_LONG).show()
        }
        val adviceBtnLeft : ImageButton = findViewById(R.id.adviceRight)
        adviceBtnLeft.setOnClickListener{
            Toast.makeText(this@MainActivity, " Button at Right : Global data observation  ", Toast.LENGTH_LONG).show()
        }


    }

    private fun query (continent :String){

        db.collection( "covidData").whereEqualTo("continent",continent).orderBy("population", Query.Direction.DESCENDING).whereNotEqualTo("population",null).
        addSnapshotListener (object : EventListener<QuerySnapshot> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(p0: QuerySnapshot?, p1: FirebaseFirestoreException?) {
                if (p1  != null){
                    Log.e("Firestore error ! ", p1.message.toString())
                    return
                }
                for(dc : DocumentChange in p0?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED){

                        countryArrayList.add(dc.document.toObject(country::class.java))

                    }
                }

                adapter.notifyDataSetChanged()

            }

        })
    }

    private fun  eventChangeListener(case:Int,selected:TextView){
        db =  FirebaseFirestore.getInstance()

        when (case) {
            0  -> db.collection( "covidData").orderBy("population", Query.Direction.DESCENDING).whereNotEqualTo("population",null).
            addSnapshotListener (object : EventListener<QuerySnapshot> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onEvent(p0: QuerySnapshot?, p1: FirebaseFirestoreException?) {
                    if (p1  != null){
                        Log.e("Firestore error ! ", p1.message.toString())
                        return
                    }
                    for(dc : DocumentChange in p0?.documentChanges!!){
                        if(dc.type == DocumentChange.Type.ADDED){

                            countryArrayList.add(dc.document.toObject(country::class.java))

                        }
                    }
                    adapter.notifyDataSetChanged()
                }

            })
            1 -> query("Africa")
            2  ->query("Europe")
            3  ->query("Asia")
            4->query("North America")
            5->query("South America")
            6->query("Oceania")
        }

        adapter = MyAdapter(countryArrayList )
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object: MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent( this@MainActivity,SecondActivity::class.java)
                intent.putExtra( "location",countryArrayList[position].location)
                intent.putExtra( "continent",countryArrayList[position].continent)
                intent.putExtra( "total_deaths",countryArrayList[position].total_deaths.toString())
                intent.putExtra( "new_deaths",countryArrayList[position].new_deaths.toString())
                intent.putExtra( "new_tests",countryArrayList[position].new_tests.toString())
                intent.putExtra( "total_tests",countryArrayList[position].total_tests.toString())
                intent.putExtra( "new_cases",countryArrayList[position].new_cases.toString())
                intent.putExtra( "total_cases",countryArrayList[position].total_cases.toString())
                intent.putExtra( "population",countryArrayList[position].population.toString())
                intent.putExtra( "total_vaccinations",countryArrayList[position].total_vaccinations.toString())

                startActivity(intent)

            }

        })
        // for string location to show user
        val selCtrLocationArrList : ArrayList<String>
        val deleteLocationList : ArrayList<String>

        // for  real object which will intent to activity_sel_ctr
        val selCtrObjectArrList : ArrayList<country>
        val deleteObjectList : ArrayList<country>

        selCtrLocationArrList= arrayListOf()
        deleteLocationList = arrayListOf()
        selCtrObjectArrList = arrayListOf()
        deleteObjectList = arrayListOf()

        adapter.setOnItemClickListener3(object :MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int){

                var selectedCtrTv :TextView = findViewById(R.id.selCtrTextView)

                val flag = selCtrLocationArrList.count()
                for (i in selCtrLocationArrList){
                    if(i == countryArrayList[position].location.toString()){
                        deleteLocationList.add(i)
                        deleteObjectList.add(countryArrayList[position])
                    }
                }
                // for string location to show user
                selCtrLocationArrList.removeAll(deleteLocationList) // delete
                deleteLocationList.clear()
                // for  real object which will intent to activity_sel_ctr
                selCtrObjectArrList.removeAll(deleteObjectList)
                deleteObjectList.clear()

                if(flag>selCtrLocationArrList.count()){
                    //Toast.makeText(this@MainActivity, " $selCtrLocationArrList ", Toast.LENGTH_SHORT).show()
                        selectedCtrTv.text = "$selCtrLocationArrList"
                    var count = selCtrLocationArrList.count()
                    selected.text = " $count /10 "
                }
                else{
                    if(selCtrLocationArrList.count()<10){   // add
                        selCtrLocationArrList.add(countryArrayList[position].location.toString())
                        selCtrObjectArrList.add(countryArrayList[position])
                       var count2 = selCtrLocationArrList.count()
                        selected.text = " $count2 /10 "
                      //  Toast.makeText(this@MainActivity, " $selCtrLocationArrList", Toast.LENGTH_SHORT).show()
                        selectedCtrTv.text = "$selCtrLocationArrList"
                    }
                    else{ // size control

                        Toast.makeText(this@MainActivity, " you can only select 10 ", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        })

        val goSelCtrActivity : ImageButton = findViewById(R.id.goSelCtrActivity)

        goSelCtrActivity.setOnClickListener{
           if(selCtrLocationArrList.isNotEmpty()){
               val intentSelCtr = Intent (this@MainActivity,selCtrActivity::class.java)
               intentSelCtr.putExtra("selCtrObjectArrList",selCtrObjectArrList)
               startActivity(intentSelCtr)
           }
            else{
               Toast.makeText(this@MainActivity, " You have to choose atleast 1 country ", Toast.LENGTH_SHORT).show()
           }


        }






    }//onCreateEnd



}//classEnd