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
}

