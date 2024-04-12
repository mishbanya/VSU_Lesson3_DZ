package com.example.vsu_lesson3_dz

import Page2Adapter
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.OnClickListener
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var data: MutableList<Launch> = mutableListOf()
        data.add(Launch("Starlink 2", "CCAES SLC 40", "16-12-2014", R.drawable.falcon1))
        data.add(Launch("DemoSat", "AAAES SLC 40", "06-07-2018", R.drawable.demosat))
        data.add(Launch("Falcon 9 Test", "CCAES SEC 40", "18-03-2019", R.drawable.falcon9))
        data.add(Launch("CRS - 2", "CAAES SLC 40", "18-12-2019", R.drawable.crs2))

        val page2Adapter = Page2Adapter(this, R.layout.page2item, data)
        val listView = findViewById<ListView>(R.id.page2)
        listView.adapter = page2Adapter

        val btn1: Button = findViewById(R.id.button1)
        val btn2: Button = findViewById(R.id.button2)
        val btn3: Button = findViewById(R.id.button3)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val btn1: Button = findViewById(R.id.button1)
        val btn2: Button = findViewById(R.id.button2)
        val btn3: Button = findViewById(R.id.button3)
        val page1: ConstraintLayout = findViewById(R.id.page1)
        val page2: ListView = findViewById(R.id.page2)
        val page3: ListView = findViewById(R.id.page3)
        when (v){
            btn1 -> {
                btn1.setTextColor(resources.getColor(R.color.red))
                btn2.setTextColor(resources.getColor(R.color.gray))
                btn3.setTextColor(resources.getColor(R.color.gray))

                page1.visibility = View.VISIBLE
                page2.visibility = View.GONE
                page3.visibility = View.GONE
            }
            btn2 -> {
                btn1.setTextColor(resources.getColor(R.color.gray))
                btn2.setTextColor(resources.getColor(R.color.red))
                btn3.setTextColor(resources.getColor(R.color.gray))

                page1.visibility = View.GONE
                page2.visibility = View.VISIBLE
                page3.visibility = View.GONE
            }
            btn3 -> {
                btn1.setTextColor(resources.getColor(R.color.gray))
                btn2.setTextColor(resources.getColor(R.color.gray))
                btn3.setTextColor(resources.getColor(R.color.red))

                page1.visibility = View.GONE
                page2.visibility = View.GONE
                page3.visibility = View.VISIBLE
            }
        }
    }
}