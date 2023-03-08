package com.example.conversionapp

import android.os.Bundle
import android.text.TextWatcher
import android.text.format.DateFormat
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adding measurements
        val spinnerMeasurements: Spinner = findViewById(R.id.spinner_measurements)

        ArrayAdapter.createFromResource(
            this,
            R.array.measurements_array,
           android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerMeasurements.adapter = adapter
        }
        spinnerMeasurements.setSelection(0);
        spinnerMeasurements.setGravity(Gravity.CENTER);

    }

    fun convert_click(view: android.view.View){
        val editTextNumber: EditText = findViewById(R.id.editTextNumber)
        val input:Int? = editTextNumber.text.toString().toIntOrNull();
        val spinnerMeasurement: Spinner = findViewById(R.id.spinner_measurements)
        val unitOfMeasurement:String = spinnerMeasurement.selectedItem.toString()
        val textviewOutput :TextView = findViewById(R.id.textViewOutput);
        var number :Int;

        if(input == null){
            //send toast message
            Toast.makeText(
                applicationContext, "Please enter a number to convert.",
                Toast.LENGTH_SHORT
            ).show();
            return;
        }
        else{
            number = input.toInt();
        }
        if(unitOfMeasurement.equals("Select Measurement")){
            Toast.makeText(
                applicationContext, "Please select the measurement from the dropdown to convert.",
                Toast.LENGTH_SHORT
            ).show();
            return;
        }

        val result:String;

        //using the 'when' statement to differentiate the calculations
        result = when(unitOfMeasurement.lowercase()){

            "km" -> String.format("$number ($unitOfMeasurement) equals to  $number * 0.62  = " + (number * 0.62) + " (mi)");
            "mi" -> String.format("$number ($unitOfMeasurement) equals to  $number * 1.61 = " + (number * 1.61) + " (km)");
            "cm" -> String.format("$number ($unitOfMeasurement) equals to  $number * 0.39 = " + (number * 0.39) + " (in)");
            "in" -> String.format("$number ($unitOfMeasurement) equals to  $number * 2.54 = " + (number * 2.54) + " (cm)");
            "kg" -> String.format("$number ($unitOfMeasurement) equals to  $number * 2.2 = " + (number * 2.2) + " (lb)");
            "lb" -> String.format("$number ($unitOfMeasurement) equals to  $number * 0.45 = " + (number * 0.45) + " (kg)");
            "g" ->  String.format("$number ($unitOfMeasurement) equals to  $number * 0.04 = " + (number * 0.04) + " (oz)");
            "oz" -> String.format("$number ($unitOfMeasurement) equals to  $number * 28.35 = " + (number * 28.35) + " (g)");

            // returning the default result if we do not find a match
            else -> String.format("Unable to process the request. Please try again.");
        }

        textviewOutput.text = result;

    }
}