package com.freelanxer.archapp.ui.driver.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.freelanxer.archapp.R
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
            binding.lastNameTv.text = driver.lastName
            binding.teamTv.text = driver.teamName
            binding.teamBackgroundView.background = AppCompatResources.getDrawable(binding.root.context, getTeamColor(driver.teamName))
            binding.teamLogoIv.setImageResource(getTeamLogo(driver.teamName))
            binding.avatarIv.load(driver.headshotUrl)
        }

        private fun getTeamColor(teamName: String?): Int  = when (teamName) {
            "Red Bull Racing" -> R.drawable.bg_team_red_bull
            "Ferrari" -> R.drawable.bg_team_ferrari
            "McLaren" -> R.drawable.bg_team_mclaren
            "Mercedes" -> R.drawable.bg_team_mercedes
            "Aston Martin" -> R.drawable.bg_team_aston_martin
            "RB" -> R.drawable.bg_team_rb
            "Alpine" -> R.drawable.bg_team_alpine
            "Williams" -> R.drawable.bg_team_williams
            "Kick Sauber" -> R.drawable.bg_team_kick_sauber
            "Haas F1 Team", null -> R.drawable.bg_team_haas
            else -> R.drawable.bg_team_haas
        }

        private fun getTeamLogo(teamName: String?): Int  = when (teamName) {
            "Red Bull Racing" -> R.drawable.ic_team_logo_red_bull
            "Ferrari" -> R.drawable.ic_team_logo_ferrari
            "McLaren" -> R.drawable.ic_team_logo_mclaren
            "Mercedes" -> R.drawable.ic_team_logo_mercedes
            "Aston Martin" -> R.drawable.ic_team_logo_aston_martin
            "RB" -> R.drawable.ic_team_logo_rb
            "Alpine" -> R.drawable.ic_team_logo_alpine
            "Williams" -> R.drawable.ic_team_logo_williams
            "Kick Sauber" -> R.drawable.ic_team_logo_kick_sauber
            "Haas F1 Team", null -> R.drawable.ic_team_logo_haas
            else -> R.drawable.bg_team_haas
        }

    }

    interface Listener {
        fun onDriverClicked(driver: Driver)
    }

}