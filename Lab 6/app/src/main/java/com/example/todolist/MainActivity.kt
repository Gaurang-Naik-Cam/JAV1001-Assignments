package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,itemlist)
        val btnAdd :Button = findViewById(R.id.btnAdd)
        val editTextView: EditText = findViewById(R.id.txtInput)
        val listView :ListView = findViewById(R.id.ListView)

        btnAdd.setOnClickListener {
            itemlist.add(editTextView.text.toString())
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
            editTextView.text.clear()
        }

    }
}