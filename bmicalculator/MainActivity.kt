package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getWeight=findViewById<EditText>(R.id.etWeight)
        val getHeight=findViewById<EditText>(R.id.etHeight)
        val calc=findViewById<Button>(R.id.btnCalc)
        val error=findViewById<TextView>(R.id.tvError)
        calc.setOnClickListener(){
            if(getWeight.text.isEmpty() || getHeight.text.isEmpty()){
                getWeight.text.clear()
                getHeight.text.clear()

                val message="Please enter details!"
                error.text=message
            }else{

                val weight=getWeight.text.toString().toFloat()
                var height=getHeight.text.toString().toFloat()
                height /= 100
                val bmi=weight/(height*height)
                var bmiFinal=String.format("%.2f",bmi).toFloat()
                val display1=findViewById<TextView>(R.id.tvRes1)
                display1.text=bmiFinal.toString()
                val display2=findViewById<TextView>(R.id.tvRes2)
                if(bmiFinal<18.5){
                    val message="Underweight"
                    display2.text=message;
                    display2.setTextColor(Color.parseColor("#8B8000"))

                }else if(bmiFinal>18 && bmiFinal<25){
                    val message="Normal"
                    display2.text=message;
                    display2.setTextColor(Color.parseColor("#158819"))
                }else if(bmiFinal>25 && bmiFinal<35){
                    val message="Overweight"
                    display2.text=message;
                    display2.setTextColor(Color.parseColor("#FFFF00"))
                }else{
                    val message="Obese"
                    display2.text=message
                    display2.setTextColor(Color.parseColor("#FF0000"))
                }
                val display3=findViewById<TextView>(R.id.tvNormal)
                val m="Normal range 18.5-25"
                display3.text=m
                getHeight.text.clear()
                getWeight.text.clear()
            }
        }

    }
}