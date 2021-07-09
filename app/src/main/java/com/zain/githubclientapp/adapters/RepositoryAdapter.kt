package com.zain.githubclientapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.jetpackhiltdemo.utility.hideIfEmptyText
import com.app.jetpackhiltdemo.utility.loadImageFromUrl
import com.zain.githubclientapp.R
import com.zain.githubclientapp.databinding.ListItemUserRepositoriesBinding
import com.zain.githubclientapp.model.RepositoryModel


class RepositoriesAdapter :
    ListAdapter<RepositoryModel.RepositoryModelItem, RepositoriesAdapter.RepositoriesViewHolder>(
        RepositoryModel.DiffUtilRepositoriesModelItem()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_user_repositories, parent, false)
        return RepositoriesViewHolder(itemView = itemView)
    }


    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RepositoryModel.RepositoryModelItem?) {
            val owner = item?.owner
            itemView.findViewById<ImageView>(R.id.image_view_owner).loadImageFromUrl(owner?.url)
            itemView.findViewById<TextView>(R.id.text_view_owner_name).text =
                item?.full_name?.substringBefore(delimiter = "/")
            itemView.findViewById<TextView>(R.id.text_view_repository_name)
                .hideIfEmptyText(item?.name)
            itemView.findViewById<TextView>(R.id.text_view_repository_description)
                .hideIfEmptyText(item?.description)
        }

    }
}

