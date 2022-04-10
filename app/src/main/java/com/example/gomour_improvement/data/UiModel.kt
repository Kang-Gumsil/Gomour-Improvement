package com.example.gomour_improvement.data

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil

data class UiModel(
    val id: Int = -1,
    val type: ViewType,
    val data: Any
) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UiModel>() {
            override fun areItemsTheSame(@NonNull oldItem: UiModel, @NonNull newItem: UiModel): Boolean {
                return oldItem.id == newItem.id && oldItem.type == newItem.type
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(@NonNull oldItem: UiModel, @NonNull newItem: UiModel): Boolean {
                return oldItem === newItem
            }
        }
    }
}
