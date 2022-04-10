package com.example.gomour_improvement.widget.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.gomour_improvement.data.UiModel
import com.example.gomour_improvement.util.provider.ResourcesProvider
import javax.inject.Inject

abstract class BaseViewHolder<M : UiModel>(
    binding: ViewBinding,
    protected val resourcesProvider: ResourcesProvider
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bindData(model: M) {
        reset()
    }

    abstract fun bindView(model: M, adapterListener: AdapterListener)
}