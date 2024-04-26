package com.freelanxer.archapp.ui.driver.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.freelanxer.archapp.data.dto.F1Team
import com.freelanxer.archapp.data.dto.Driver
import com.freelanxer.archapp.databinding.ListItemDriverBinding
import com.freelanxer.archapp.ui.driver.DriverListViewModel

class DriverListAdapter(
    private var driverList: List<Driver>?,
    private val driverListViewModel: DriverListViewModel,
): RecyclerView.Adapter<DriverListAdapter.ViewHolder>() {

    private val listener = object: Listener {
        override fun onDriverClicked(driver: Driver) {
            driverListViewModel.onDriverClicked(driver)
        }
    }

    fun setData(list: List<Driver>?) {
        driverList = list ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemDriverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return driverList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        driverList?.let {
            val driver = it[position]
            holder.bind(driver)
            holder.itemView.setOnClickListener {
                listener.onDriverClicked(driver)
            }
        }
    }

    class ViewHolder(
        private val binding: ListItemDriverBinding,
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(driver: Driver) {
            val team = F1Team.getF1TeamByName(driver.teamName ?: "")
            binding.lastNameTv.text = driver.lastName
            binding.teamTv.text = driver.teamName
            binding.teamBackgroundView.background = AppCompatResources.getDrawable(binding.root.context, team.teamColor)
            binding.teamLogoIv.setImageResource(team.teamLogo)
            binding.avatarIv.load(driver.headshotUrl)
        }

    }

    interface Listener {
        fun onDriverClicked(driver: Driver)
    }

}