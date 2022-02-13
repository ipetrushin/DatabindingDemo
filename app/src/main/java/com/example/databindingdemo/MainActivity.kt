package com.example.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    val random = Random()
    // объявляем переменную в классе, чтобы пользоваться ей в других методах
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // создаём привязку к данным
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.player = Player("Petya", 15)

    }
    public fun onClick(v: View) {
        val r = random.nextInt(100)
        // обновляем данные
        binding.player = Player("Petya", r) // change to random value
        Log.d("mytag", "rating changed to: $r")

    }
}
// класс для данных
data class Player(val name: String, var rating: Int)