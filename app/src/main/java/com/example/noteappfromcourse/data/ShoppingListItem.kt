package com.example.noteappfromcourse.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_list_item")
data class ShoppingListItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val time: String,
    val allItemsCount: Int,
    val allSelectedItemCount: Int
)
