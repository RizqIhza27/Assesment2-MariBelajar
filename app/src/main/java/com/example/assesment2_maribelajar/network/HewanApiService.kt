package com.example.assesment2_maribelajar.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.example.assesment2_maribelajar.model.Hewan
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dif.indraazimi.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HewanApiService {
    @GET("listhewan.json")

    suspend fun getHewan(): List<Hewan>


}
object HewanApi{
    val service: HewanApiService by lazy {
        retrofit.create(HewanApiService::class.java)
    }
    fun getHewanUrl(nama: String): String {
        return BASE_URL + "hewan/$nama.jpg"
    }
    enum class ApiStatus { LOADING, SUCCESS, FAILED }
}