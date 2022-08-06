package dev.meysamkeshvari.notemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.meysamkeshvari.notemvvm.R
import dev.meysamkeshvari.notemvvm.adapter.NoteAdapter
import dev.meysamkeshvari.notemvvm.databinding.ActivityMainBinding
import dev.meysamkeshvari.notemvvm.model.Note
import dev.meysamkeshvari.notemvvm.utility.showToastCustomView
import dev.meysamkeshvari.notemvvm.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NoteAdapter
    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getRepository().observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter = NoteAdapter(it, viewModel,this)
            binding.recyclerView.adapter = adapter
        })

        viewModel.lst.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter = NoteAdapter(it, viewModel,this)
            binding.recyclerView.adapter = adapter
        })

        binding.button.setOnClickListener {
            addData()
        }
    }

    private fun addData() {
        val title: String = binding.editTextTitle.text.toString()
        val description: String = binding.editTextDescription.text.toString()
        val note = Note(title, description)
        viewModel.add(note)
        binding.recyclerView.adapter?.notifyDataSetChanged()
        Toast(this).showToastCustomView(android.R.color.holo_green_dark,"Created", R.drawable.ic_check_circle,this)
    }
}