package com.example.project2k.adapter

import android.content.Context
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project2k.R
import com.example.project2k.model.Member
import kotlinx.android.synthetic.main.item_custom_layout.view.*
import kotlinx.android.synthetic.main.item_not_available_layout.view.*

// this is multiple item adapter
data class CustomAdapter(private val context: Context, private val members: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // item types
    companion object {
        private const val TYPE_ITEM_AVAILABLE: Int = 0
        private const val TYPE_ITEM_NOT_AVAILABLE: Int = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (members[position].available) TYPE_ITEM_AVAILABLE else TYPE_ITEM_NOT_AVAILABLE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ITEM_AVAILABLE) {
            CustomAvailableViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_custom_layout, parent, false)
            )
        } else {
            CustomNotAvailableViewHolder(
                LayoutInflater.from(context)
                    .inflate(R.layout.item_not_available_layout, parent, false)
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member = members[position]

        if (holder is CustomAvailableViewHolder) {
            // set data to item
            holder.textView.text = member.surname
        } else if (holder is CustomNotAvailableViewHolder) {
            // set data to item
            holder.text_view.text = member.name
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    private data class CustomAvailableViewHolder(
        val itemView: View,
        val textView: TextView = itemView.text_view_title
    ) : RecyclerView.ViewHolder(itemView)


    private data class CustomNotAvailableViewHolder(
        val view: View,
        val text_view: TextView = view.text_view_not_available
    ) : RecyclerView.ViewHolder(view)
}







