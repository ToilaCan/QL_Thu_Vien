package com.example.quanlythuvien

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtEmployee: EditText
    private lateinit var btnChange: Button
    private lateinit var lvBooks: ListView
    private lateinit var btnAdd: Button
    private lateinit var tvTitle: TextView

    private val books = mutableListOf("Sách 01", "Sách 02")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các thành phần giao diện
        edtEmployee = findViewById(R.id.edtEmployee)
        btnChange = findViewById(R.id.btnChange)
        lvBooks = findViewById(R.id.lvBooks)
        btnAdd = findViewById(R.id.btnAdd)
        tvTitle = findViewById(R.id.tvTitle)

        // Khởi tạo Adapter cho ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, books)
        lvBooks.adapter = adapter

        // Xử lý sự kiện cho nút "Đổi"
        btnChange.setOnClickListener {
            val newName = edtEmployee.text.toString()
            if (newName.isNotEmpty()) {
                tvTitle.text = "Xin chào: $newName"
            }
        }

        // Xử lý sự kiện cho nút "Thêm"
        btnAdd.setOnClickListener {
            books.add("Sách ${books.size + 1}")
            adapter.notifyDataSetChanged()
        }
    }
}
