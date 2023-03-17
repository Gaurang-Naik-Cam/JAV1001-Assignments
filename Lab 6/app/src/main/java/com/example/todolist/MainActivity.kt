package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.core.util.set
import androidx.core.view.get


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,itemlist)
        val btnAdd :Button = findViewById(R.id.btnAdd)
        val btnDelete :Button = findViewById(R.id.btnDelete)
        val btnClear :Button = findViewById(R.id.btnClear)
        val editTextView: EditText = findViewById(R.id.txtInput)
        val listView :ListView = findViewById(R.id.ListView)

        btnAdd.setOnClickListener {
            val state = listView.onSaveInstanceState()
            if(editTextView.text.isNotEmpty()) {
                itemlist.add(editTextView.text.toString())
                listView.adapter = adapter
                adapter.notifyDataSetChanged()
                editTextView.text.clear()
            }
            listView.onRestoreInstanceState(state)
        }

        btnClear.setOnClickListener {
            itemlist.clear()
            adapter.notifyDataSetChanged()
        }

        btnDelete.setOnClickListener{
            val positions = listView.checkedItemPositions;
            var items = listView.count - 1;
            while(items >= 0){
                if(positions.get(items)) {
                        adapter.remove(itemlist.get(items))
                }
                items--
             }
            positions.clear()
            adapter.notifyDataSetChanged()
        }
    }
}