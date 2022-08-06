package dev.meysamkeshvari.notemvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.meysamkeshvari.notemvvm.R
import dev.meysamkeshvari.notemvvm.databinding.RowItemBinding
import dev.meysamkeshvari.notemvvm.model.Note
import dev.meysamkeshvari.notemvvm.utility.showToastCustomView
import dev.meysamkeshvari.notemvvm.viewmodel.NoteViewModel

class NoteAdapter(var itemList: List<Note>, var viewModel: NoteViewModel,var context:Context) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RowItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.textViewTitle.text = note.title
            binding.textViewDescription.text = note.description

            binding.buttonDelete.setOnClickListener {
                viewModel.remove(note)
                notifyItemRemoved(itemList.indexOf(note))
                Toast(context).showToastCustomView(android.R.color.holo_red_light,"Deleted", R.drawable.ic_trash,context)
            }
            binding.root.setOnClickListener {
                Toast(context).showToastCustomView(android.R.color.holo_green_dark,note.title, R.drawable.ic_check_circle,context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}