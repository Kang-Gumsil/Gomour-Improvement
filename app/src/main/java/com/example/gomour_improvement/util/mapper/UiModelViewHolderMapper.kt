package com.example.gomour_improvement.util.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gomour_improvement.data.UiModel
import com.example.gomour_improvement.data.ViewType
import com.example.gomour_improvement.util.provider.ResourcesProvider
import com.example.gomour_improvement.widget.base.BaseViewHolder
import java.lang.IllegalArgumentException

object UiModelViewHolderMapper {

    @Suppress("UNCHECKED_CAST")
    fun <M : UiModel> map(
        parent: ViewGroup,
        type: ViewType,
        resourcesProvider: ResourcesProvider
    ): BaseViewHolder<M> {

        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (type) {
            else -> throw IllegalArgumentException("유효하지 않은 타입입니다.")
        }

        return viewHolder as BaseViewHolder<M>
    }
}