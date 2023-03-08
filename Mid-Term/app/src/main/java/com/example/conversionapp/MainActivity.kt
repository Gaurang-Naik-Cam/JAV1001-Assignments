package com.example.conversionapp

import android.os.Bundle
import android.text.TextWatcher
import android.text.format.DateFormat
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
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

        // Loading spinner items. Also added custom_spinner.xml to control the spinner items alignments
        val spinnerMeasurements: Spinner = findViewById(R.id.spinner_measurements)

        //populating the adapter and assigning to the spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.measurements_array,
            R.layout.custom_spinner
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.custom_spinner)
            spinnerMeasurements.adapter = adapter
        }
        //setting up starting element of spinner
        spinnerMeasurements.setSelection(0);
        spinnerMeasurements.onItemSelectedListener  = object : AdapterView.OnItemSelectedListener {

            // Conversion logic runs everytime new item is selected
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               //populating the parameters
                var adapter =  spinnerMeasurements.adapter
                val unitOfMeasurement:String =  adapter.getItem(p2).toString()
                val editTextNumber: EditText = findViewById(R.id.editTextNumber)
                val input:Int? = editTextNumber.text.toString().toIntOrNull();
                val spinnerMeasurement: Spinner = findViewById(R.id.spinner_measurements)
                val textviewOutput :TextView = findViewById(R.id.textViewOutput);
                var number :Int;

                if(input == null){
                    //sending toast message for entering a valid number
                    Toast.makeText(
                        applicationContext, "Please enter a number to convert.",
                        Toast.LENGTH_SHORT
                    ).show();
                    return; //stopping the execution of the rest of the method, since validation failed.
                }
                else{
                    number = input.toInt();
                }
                if(unitOfMeasurement.equals("Select Measurement")){
                    Toast.makeText( //sending toast message for selecting a correct option from the spinner
                        applicationContext, "Please select the measurement from the dropdown to convert.",
                        Toast.LENGTH_SHORT
                    ).show();
                    return;//stopping the execution of the rest of the method, since validation failed.
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

                //setting the message to the output textview
                textviewOutput.text = result;
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }
}