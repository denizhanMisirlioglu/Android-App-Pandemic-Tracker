package com.example.seniorproject
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class country(var location: String ?= null , var last_updated_date: String ? = null ,var continent: String ?= null , var total_deaths: Long ?= null
, var population : Long ?= null , var new_tests : Long ?= null , var total_tests : Long ?= null , var new_deaths: Long ?= null ,
   var new_cases :Long ?= null , var total_cases : Long?= null , var total_vaccinations : Long ?=null

): Parcelable {
   constructor(parcel: Parcel) : this(
      parcel.readString(),
      parcel.readString(),
      parcel.readString(),
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Long::class.java.classLoader) as? Long
   ) {
   }

   override fun writeToParcel(parcel: Parcel, flags: Int) {
      parcel.writeString(location)
      parcel.writeString(last_updated_date)
      parcel.writeString(continent)
      parcel.writeValue(total_deaths)
      parcel.writeValue(population)
      parcel.writeValue(new_tests)
      parcel.writeValue(total_tests)
      parcel.writeValue(new_deaths)
      parcel.writeValue(new_cases)
      parcel.writeValue(total_cases)
      parcel.writeValue(total_vaccinations)
   }

   override fun describeContents(): Int {
      return 0
   }

   companion object CREATOR : Parcelable.Creator<country> {
      override fun createFromParcel(parcel: Parcel): country {
         return country(parcel)
      }

      override fun newArray(size: Int): Array<country?> {
         return arrayOfNulls(size)
      }
   }
}
