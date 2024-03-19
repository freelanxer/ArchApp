package com.freelanxer.archapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.freelanxer.archapp.databinding.ListItemMenuBinding

class HomeMenuAdapter(
    private val menuList: List<String>?
): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        menuList?.let {
            holder.bind(menuList[position])
        }
    }
}

class ViewHolder(val binding: ListItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(menuName: String) {
        binding.nameTv.setText(menuName)
    }
}