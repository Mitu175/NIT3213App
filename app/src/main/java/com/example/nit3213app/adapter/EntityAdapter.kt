package com.example.nit3213app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213app.R
import com.example.nit3213app.model.Artwork




class EntityAdapter(
    private val entities: List<Artwork>,
    private val onItemClick: (Artwork) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    inner class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artworkTitle: TextView = itemView.findViewById(R.id.textArtworkTitle)
        val artist: TextView = itemView.findViewById(R.id.textArtist)
        val medium: TextView = itemView.findViewById(R.id.textMedium)
        val year: TextView = itemView.findViewById(R.id.textYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entities[position]
        holder.artworkTitle.text = entity.artworkTitle
        holder.artist.text = entity.artist
        holder.medium.text = entity.medium
        holder.year.text = entity.year.toString()

        holder.itemView.setOnClickListener {
            onItemClick(entity)
        }
    }

    override fun getItemCount(): Int = entities.size
}
