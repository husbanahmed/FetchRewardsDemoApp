package com.example.fetchcodingexercise.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.fetchcodingexercise.model.Item

class ItemDiffCallback(private val oldList: List<Item>, private val newList: List<Item>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id &&
                oldList[oldItemPosition].listId == newList[newItemPosition].listId &&
                oldList[oldItemPosition].name == newList[newItemPosition].name

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id &&
                oldList[oldItemPosition].listId == newList[newItemPosition].listId &&
                oldList[oldItemPosition].name == newList[newItemPosition].name
    }
}
