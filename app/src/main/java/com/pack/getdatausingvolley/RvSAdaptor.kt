package com.pack.getdatausingvolley

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pack.getdatausingvolley.databinding.RvItemBinding

class RvAdaptor(
    private var context: Context,
    private var userList: MutableList<UserInfoItem>
):RecyclerView.Adapter<RvAdaptor.ViewHolder>() {

    class ViewHolder(val binding: RvItemBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RvItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUserInfo = userList[position]
        holder.binding.tvName.text = currentUserInfo.name
        holder.binding.tvAddress.text = currentUserInfo.city
    }
}