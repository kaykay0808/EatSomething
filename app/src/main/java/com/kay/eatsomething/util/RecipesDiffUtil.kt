package com.kay.eatsomething.util

import androidx.recyclerview.widget.DiffUtil
import com.kay.eatsomething.models.FoodTypeResult

// Info: DiffUtil will update the changes in our existing list and keep the not change one.

class RecipesDiffUtil(
    private val oldList: List<FoodTypeResult>,
    private val newList: List<FoodTypeResult>
): DiffUtil.Callback() {

        // It returns the size of the old list.
        override fun getOldListSize(): Int {
                return oldList.size
        }

        // returns the size of the new list
        override fun getNewListSize(): Int {
                return newList.size
        }

        // called by the DiffUtil to decide whether two object represent the same item in the old and new list.
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                // compare and see if those two list are identical.
                return oldList[oldItemPosition] === newList[newItemPosition]
        }

        // Checks whether two items have the same data.
        // You can change it's behaviour depending on your UI. This method is called by DiffUtil only if areItemsTheSame returns true.
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
        }
}