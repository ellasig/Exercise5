package com.esigvart.exercise5

import MemberOfParliament
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esigvart.exercise5.databinding.ItemListBinding


class Adapter(val members: List<MemberOfParliament>):
    RecyclerView.Adapter<Adapter.MainViewHolder>() {

   inner class MainViewHolder(val itemBinding: ItemListBinding)
       : RecyclerView.ViewHolder(itemBinding.root)  {
            fun bindItem(members: MemberOfParliament) {
                itemBinding.name.text = members.first + "" + members.last
                itemBinding.party.text = members.party
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = members[position]
        holder.bindItem(item)
    }

    override fun getItemCount(): Int {
        return members.size
    }
}