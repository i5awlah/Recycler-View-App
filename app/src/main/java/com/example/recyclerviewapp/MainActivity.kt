package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var myRV: RecyclerView
    lateinit var submit: Button
    lateinit var item: EditText
    lateinit var myLayout: ConstraintLayout

    var items = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLayout = findViewById(R.id.clMain)

        myRV = findViewById(R.id.recyclerView)
        myRV.adapter = RecyclerViewAdaptor(items)
        myRV.layoutManager = LinearLayoutManager(this)

        item = findViewById(R.id.newItem)
        submit = findViewById(R.id.btnSubmit)
        submit.setOnClickListener { addItem() }

    }
    private fun addItem() {
        val newItem = item.text.toString()

        // Perform a check on the Edit Text to make sure the user does not add empty entries
        if (newItem.isEmpty()) {
            // display a Snackbar alert if the Edit Text field is empty
            Snackbar.make(myLayout,"Empty entry!",Snackbar.LENGTH_LONG).show()
        }
        else {
            Log.d("SS", "new: $newItem")
            items.add(newItem)
            item.text = null
            myRV.adapter = RecyclerViewAdaptor(items)
        }

    }
}