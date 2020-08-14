package `in`.example.demoassignment.view.userprofile

import `in`.example.ui.base.adapter.BaseBindingRVModel
import `in`.example.domain.base.Status
import `in`.example.ui.base.BaseViewState

class UserProfileViewState(status: Status, error: Throwable? = null, data: List<BaseBindingRVModel>? = null) :
BaseViewState<List<BaseBindingRVModel>>(status, error, data){

  fun getUserProfile() = data ?: mutableListOf()
}