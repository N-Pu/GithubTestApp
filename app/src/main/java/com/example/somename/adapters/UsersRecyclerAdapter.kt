package com.example.somename.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.somename.R
import com.example.somename.model.ListUser


class UsersRecyclerAdapter(
    private var mData: List<ListUser>,
    private var mOnRvItemClickListener: OnRvItemClickListener
) :
    RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder>() {


//    constructor() : this() {
//        this.mData = mData
//        this.mOnRvItemClickListener = mOnRvItemClickListener
//    }


    interface OnRvItemClickListener {
        fun onItemClicked(pos: Int)
    }


    class UserViewHolder(userView: View) : RecyclerView.ViewHolder(userView) {
        val avatar: ImageView = userView.findViewById(R.id.avatar_view_item)
        val fullName: TextView = userView.findViewById(R.id.full_name_view_item)
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: ListUser = mData[position]

        holder.fullName.text = user.getLogin()
        Glide.with(holder.itemView)
            .load(user.getAvatar_url())
            .into(holder.avatar)

        holder.itemView.setOnClickListener {
            mOnRvItemClickListener.onItemClicked(holder.absoluteAdapterPosition) // change if something happens
        }
    }

    override fun getItemCount(): Int {
        return if (mData == null) 0 else mData.size // have to fix this too
    }


}

