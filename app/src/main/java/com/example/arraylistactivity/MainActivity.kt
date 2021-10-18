package com.example.arraylistactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    lateinit var ETname : EditText
    lateinit var ETnum : EditText
    lateinit var getbtn : Button
    lateinit var savebtn : Button
    lateinit var result : TextView
    var array = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savebtn=findViewById(R.id.savebtn)
        getbtn=findViewById(R.id.getbtn)
        result=findViewById(R.id.textView)
        ETname=findViewById(R.id.ETname)
        ETnum=findViewById(R.id.ETnum)
        savebtn.setOnClickListener {
            if(ETname.text.toString().isNotEmpty()) {
                array.add(ETname.text.toString())
                Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "enter a name please", Toast.LENGTH_SHORT).show()
            ETname.text.clear()
        }
        getbtn.setOnClickListener {
            if(ETnum.text.toString().isNotEmpty() && ETnum.text.toString().isDigitsOnly())
                if(ETnum.text.toString().toInt()<=array.size && ETnum.text.toString().toInt() > 0 )
                result.text = array.get(ETnum.text.toString().toInt()-1)
                else
                    Toast.makeText(this, "enter a number from 1 to array size", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "enter a number please", Toast.LENGTH_SHORT).show()
            ETnum.text.clear()
        }
    }
}