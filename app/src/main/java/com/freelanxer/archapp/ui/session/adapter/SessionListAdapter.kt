package com.freelanxer.archapp.ui.session.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.freelanxer.archapp.R
import com.freelanxer.archapp.data.dto.Session
import com.freelanxer.archapp.databinding.ListItemSessionBinding
import com.freelanxer.archapp.ui.session.SessionViewModel

class SessionListAdapter(
    private var sessionList: List<Session>?,
    private val sessionViewModel: SessionViewModel,
): RecyclerView.Adapter<SessionListAdapter.ViewHolder>() {

    fun setData(list: List<Session>?) {
        sessionList = list ?: listOf()
        notifyDataSetChanged()
    }

    private val listener = object: Listener {
        override fun onSessionClicked(session: Session) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        sessionList?.let {
            val session = it[position]
            holder.bind(session)
            holder.itemView.setOnClickListener {
                listener.onSessionClicked(session)
            }
        }
    }

    override fun getItemCount(): Int {
        return sessionList?.size ?: 0
    }

    class ViewHolder(
        private val binding: ListItemSessionBinding,
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(session: Session) {
            binding.dateTimeTv.text = session.getSessionDate()
            binding.circuitTv.text = session.getCircuitName(itemView.context)
            binding.countryTv.text = session.countryName
            binding.sessionNameTv.text = session.sessionName
            binding.circuitIv.load(getCircuitImage(session.circuitKey))
        }

        private fun getCircuitImage(circuitId: Int): Int = when (circuitId) {
            2 -> R.drawable.ic_circuit_002
            4 -> R.drawable.ic_circuit_004
            7 -> R.drawable.ic_circuit_007
            9 -> R.drawable.ic_circuit_009
            10 -> R.drawable.ic_circuit_010
            14 -> R.drawable.ic_circuit_014
            15 -> R.drawable.ic_circuit_015
            19 -> R.drawable.ic_circuit_019
            22 -> R.drawable.ic_circuit_022
            23 -> R.drawable.ic_circuit_023
            39 -> R.drawable.ic_circuit_039
            46 -> R.drawable.ic_circuit_046
            55 -> R.drawable.ic_circuit_055
            61 -> R.drawable.ic_circuit_061
            63 -> R.drawable.ic_circuit_063
            65 -> R.drawable.ic_circuit_065
            70 -> R.drawable.ic_circuit_070
            144 -> R.drawable.ic_circuit_144
            149 -> R.drawable.ic_circuit_149
            150 -> R.drawable.ic_circuit_150
            151 -> R.drawable.ic_circuit_151
            152 -> R.drawable.ic_circuit_152
            else -> R.drawable.ic_circuit_152
        }
    }

    interface Listener {
        fun onSessionClicked(session: Session)
    }

}