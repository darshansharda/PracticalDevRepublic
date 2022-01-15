package com.devrepublic.practical.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devrepublic.practical.R
import com.devrepublic.practical.databinding.RowNewsBinding
import com.devrepublic.practical.model.ArticlesModel
import com.devrepublic.practical.utils.RecyclerViewClickListener

class NewsAdapter(
    private val context: Context,
    private val articles: List<ArticlesModel>,
    private val listener: RecyclerViewClickListener
) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    class NewsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: RowNewsBinding = DataBindingUtil.bind(view)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsHolder(LayoutInflater.from(context).inflate(R.layout.row_news, parent, false))

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.binding.article = articles[position]
        holder.itemView.setOnClickListener {
            listener.onItemClick(holder.adapterPosition, articles[holder.adapterPosition])
        }
    }

    override fun getItemCount() = articles.size
}