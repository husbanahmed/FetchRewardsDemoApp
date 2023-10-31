package com.example.fetchcodingexercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchcodingexercise.R
import com.example.fetchcodingexercise.databinding.ItemViewListBinding
import com.example.fetchcodingexercise.model.Item
import com.example.fetchcodingexercise.utils.ItemDiffCallback

class ItemListAdapter(private var itemList: List<Item>): RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemViewListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = ItemViewListBinding.inflate(layoutInflater, parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        val id = item.id
        val listID = item.listId
        val name = item.name

        holder.binding.apply {
            tvItems.text = holder.itemView.context.getString(R.string.item_info, listID, id, name)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    // Update the adapter's data with a new list
    fun updateData(newItemList: List<Item>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(itemList, newItemList))
        itemList = newItemList
        diffResult.dispatchUpdatesTo(this)
    }
}