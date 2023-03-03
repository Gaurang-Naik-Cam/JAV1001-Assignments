package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adding a common adapter to both team1 and team 2 spinner class
        val spinnerMavericks: Spinner = findViewById(R.id.spinnerTeam1)
        val spinnerWarriors: Spinner = findViewById(R.id.spinnerTeam2)
        ArrayAdapter.createFromResource(
            this,
            R.array.scores_array,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerMavericks.adapter = adapter
            spinnerWarriors.adapter = adapter
        }
    }

    fun IncrementScoreTeam1(view: android.view.View) {
        val spinnerMavericks: Spinner = findViewById(R.id.spinnerTeam1);
        var selectedItem = spinnerMavericks.selectedItem
        if (selectedItem.equals("Select Points")) {
            Toast.makeText(
                applicationContext, "Please select the points to be awarded from the dropdown.",
                Toast.LENGTH_SHORT
            ).show();
        } else {
            val textViewScore: TextView = findViewById(R.id.textViewScoreTeam1);
            val incrementBy: Int = selectedItem.toString().toInt();
            val currentScore: Int = textViewScore.text.toString().toInt();
            textViewScore.text = (incrementBy + currentScore).toString();
        }
    }

    fun DecrementScoreTeam1(view: android.view.View) {
        val spinnerMavericks: Spinner = findViewById(R.id.spinnerTeam1);
        var selectedItem = spinnerMavericks.selectedItem
        if (selectedItem.equals("Select Points")) {
            Toast.makeText(
                applicationContext, "Please select the points to be reduced from the dropdown.",
                Toast.LENGTH_SHORT
            ).show();
        } else {
            val textViewScore: TextView = findViewById(R.id.textViewScoreTeam1);
            val decrementBy: Int = selectedItem.toString().toInt();
            val currentScore: Int = textViewScore.text.toString().toInt();
            if (currentScore != 0) {
                textViewScore.text = (currentScore - decrementBy).toString();
            } else {
                Toast.makeText(
                    applicationContext, "Can not reduce beyond zero.",
                    Toast.LENGTH_SHORT
                ).show();
            }
        }
    }


    fun IncrementScoreTeam2(view: android.view.View) {
        val spinnerWarriors: Spinner = findViewById(R.id.spinnerTeam2);
        var selectedItem = spinnerWarriors.selectedItem
        if (selectedItem.equals("Select Points")) {
            Toast.makeText(
                applicationContext, "Please select the points to be awarded from the dropdown.",
                Toast.LENGTH_SHORT
            ).show();
        } else {
            val textViewScore: TextView = findViewById(R.id.textViewScoreTeam2);
            val incrementBy: Int = selectedItem.toString().toInt();
            val currentScore: Int = textViewScore.text.toString().toInt();
            textViewScore.text = (incrementBy + currentScore).toString();
        }
    }

    fun DecrementScoreTeam2(view: android.view.View) {
        val spinnerWarriors: Spinner = findViewById(R.id.spinnerTeam2);
        var selectedItem = spinnerWarriors.selectedItem
        if (selectedItem.equals("Select Points")) {
            Toast.makeText(
                applicationContext, "Please select the points to be reduced from the dropdown.",
                Toast.LENGTH_SHORT
            ).show();
        } else {
            val textViewScore: TextView = findViewById(R.id.textViewScoreTeam2);
            val decrementBy: Int = selectedItem.toString().toInt();
            val currentScore: Int = textViewScore.text.toString().toInt();
            if (currentScore != 0) {
                textViewScore.text = (currentScore - decrementBy).toString();
            } else {
                Toast.makeText(
                    applicationContext, "Can not reduce beyond zero.",
                    Toast.LENGTH_SHORT
                ).show();
            }
        }

    }
}
