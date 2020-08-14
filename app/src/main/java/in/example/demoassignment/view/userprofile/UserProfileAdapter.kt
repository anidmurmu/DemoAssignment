package `in`.example.demoassignment.view.userprofile

import `in`.example.demoassignment.BR
import `in`.example.demoassignment.R
import `in`.example.ui.base.ViewOnClickListener
import `in`.example.ui.base.adapter.BaseBindingRVModel
import `in`.example.ui.base.adapter.BaseBindingViewHolder
import `in`.example.ui.base.adapter.BaseViewHolderBindingFactory
import `in`.example.domain.model.UserProfileUiModel
import androidx.databinding.ViewDataBinding

class UserProfileVHFactory : BaseViewHolderBindingFactory() {
  override fun create(
    binding: ViewDataBinding,
    viewType: Int,
    viewClickCallback: ViewOnClickListener?
  ): BaseBindingViewHolder<out BaseBindingRVModel> {
    return UserProfileViewHolder(
      binding,
      viewClickCallback
    )
  }
}

class UserProfileViewHolder(binding: ViewDataBinding, val viewClickCallback: ViewOnClickListener?) : BaseBindingViewHolder<UserProfileRVModel>(binding) {
  override fun bind(model: UserProfileRVModel) {
    val userProfileUiModel = model.getBindingPairs()[0].second as UserProfileUiModel

    //itemView.tvEmailId
  }
}

class UserProfileRVModel(private val userProfileUiModel: UserProfileUiModel) : BaseBindingRVModel {
  override fun getLayoutId() = R.layout.item_user_profile

  override fun getBindingPairs(): List<Pair<Int, Any>> {
    return listOf(Pair(BR.bindingVariableUserProfile, userProfileUiModel))
  }
}
