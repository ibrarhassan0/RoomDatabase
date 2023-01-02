package com.example.roomdatabase


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.data.*
import com.example.roomdatabase.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), OnItemClicked {
    private val TAG = "MainActivity"
    lateinit var viewmodel: UserViewModel
    lateinit var adapter: UserAdapter
    // private val list=ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("TAG", "OnCreate starts")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding.recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = UserAdapter(this, this)
        binding.recyclerview.adapter = adapter



        viewmodel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UserViewModel::class.java)
        viewmodel.alluser.observe(this, Observer { list ->
            list?.let {
                adapter.updataData(it)
            }
        })

        binding.button.setOnClickListener {list->
            list?.let{
                onadd(it)
            }


        }


        Log.d(TAG, "OnCreate Ends")
    }

    override fun onitemclick(user: User) {
        viewmodel.deleteUser(user)
        Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
    }


   private fun onadd(view: View): String {
        val input = findViewById<EditText>(R.id.input)
        val text = input.text.toString()
        if (text.isNotEmpty()) {
            viewmodel.insertUser(User(text))
        }
        return ""

    }
}

