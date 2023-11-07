package com.triforce.malacprodavac.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class RoomConverters @Inject constructor(private val moshi: Moshi){
    @TypeConverter
    fun fromListOfString(value: List<String>): String{
        val listOfStringType = Types.newParameterizedType(List::class.java, String::class.java)
        return moshi.adapter<List<String>>(listOfStringType).toJson(value)
    }
    @TypeConverter
    fun toListOfString(value: String): List<String>{
        val listOfStringType = Types.newParameterizedType(List::class.java, String::class.java)
        return moshi.adapter<List<String>>(listOfStringType).fromJson(value)!!
    }

//    @TypeConverter
//    fun timeToString(time: String): String {
//        return time.toString()
//    }
//
//    @TypeConverter
//    fun StringToTime(string: String): String {
//        return String.from(Instant.parse(string))
//    }

//    @TypeConverter
//    fun fromCustomer(customer: Customer): String {
//        return moshi.
//    }
//
//    @TypeConverter
//    fun toCustomer(json: String): Customer {
//        return Gson().fromJson(json, Customer::class.java)
//    }
//
//    @TypeConverter
//    fun fromCourier(courier: Courier): String {
//        return Gson().toJson(courier)
//    }
//
//    @TypeConverter
//    fun toCourier(json: String): Courier {
//        return Gson().fromJson(json, Courier::class.java)
//    }
//
//    @TypeConverter
//    fun fromShop(shop: Shop): String {
//        return Gson().toJson(shop)
//    }
//
//    @TypeConverter
//    fun toShop(json: String): Shop {
//        return Gson().fromJson(json, Shop::class.java)
//    }
}
