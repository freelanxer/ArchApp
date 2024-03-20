package com.freelanxer.archapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.freelanxer.archapp.data.dto.FeatureMenuItem
import com.freelanxer.archapp.databinding.ListItemMenuBinding
import com.freelanxer.archapp.ui.home.HomeViewModel

class HomeMenuAdapter(
    private val menuList: List<FeatureMenuItem>?,
    private val homeViewModel: HomeViewModel,
): RecyclerView.Adapter<ViewHolder>() {

    private val listener = object : Listener {
        override fun onMenuItemClicked(menuItem: FeatureMenuItem) {
            homeViewModel.launchSessionPage(menuItem)
        }
    }

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
            holder.itemView.setOnClickListener {
                listener.onMenuItemClicked(menuList[position])
            }
        }
    }

    interface Listener {
        fun onMenuItemClicked(menuItem: FeatureMenuItem)
    }
}

class ViewHolder(private val binding: ListItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(menuItem: FeatureMenuItem) {
        binding.nameTv.text = menuItem.name
    }
}