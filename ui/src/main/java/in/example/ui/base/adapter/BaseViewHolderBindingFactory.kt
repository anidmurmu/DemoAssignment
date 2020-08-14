package `in`.example.ui.base.adapter

import `in`.example.ui.base.ViewOnClickListener
import androidx.databinding.ViewDataBinding

abstract class BaseViewHolderBindingFactory {
    abstract fun create(binding: ViewDataBinding, viewType: Int, viewClickCallback: ViewOnClickListener?): BaseBindingViewHolder<out BaseBindingRVModel>
}
