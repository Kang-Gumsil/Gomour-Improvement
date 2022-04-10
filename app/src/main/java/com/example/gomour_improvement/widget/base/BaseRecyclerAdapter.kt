package com.example.gomour_improvement.widget.base

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.gomour_improvement.data.UiModel
import com.example.gomour_improvement.data.ViewType
import com.example.gomour_improvement.util.mapper.UiModelViewHolderMapper
import com.example.gomour_improvement.util.provider.ResourcesProvider
import javax.inject.Inject

class BaseRecyclerAdapter<M : UiModel>(
    private var modelList: List<UiModel>,
    private val adapterListener: AdapterListener,
    private val resourcesProvider: ResourcesProvider
) : ListAdapter<UiModel, BaseViewHolder<M>>(UiModel.DIFF_CALLBACK) {

    override fun getItemCount(): Int = modelList.size

    override fun getItemViewType(position: Int) = modelList[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<M> {
        return UiModelViewHolderMapper.map(parent, ViewType.values()[viewType], resourcesProvider)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<M>, position: Int) = with(holder) {
        bindData(modelList[position] as M)
        bindView(modelList[position] as M, adapterListener)
    }


    override fun submitList(list: List<UiModel>?) {
        list?.let { modelList = it }
        super.submitList(list)
    }
}