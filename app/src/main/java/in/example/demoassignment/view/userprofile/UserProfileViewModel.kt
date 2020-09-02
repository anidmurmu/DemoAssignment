package `in`.example.demoassignment.view.userprofile

import `in`.example.ui.base.RxAwareViewModel
import `in`.example.ui.base.ViewOnClickListener
import `in`.example.ui.base.adapter.BaseBindingRVModel
import `in`.example.domain.base.Resource
import `in`.example.domain.base.Status
import `in`.example.domain.model.UserProfileRequestUiModel
import `in`.example.domain.model.UserProfileResponseUiModel
import `in`.example.domain.model.UserProfileUiModel
import `in`.example.domain.usecase.GetUserProfileUseCase
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.plusAssign
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserProfileViewModel(private val getUserProfileUseCase: GetUserProfileUseCase) : RxAwareViewModel(),
  ViewOnClickListener {

  private val _userProfileMutableLiveData = MutableLiveData<UserProfileViewState>()
  val userProfileLiveData: LiveData<UserProfileViewState> = _userProfileMutableLiveData

  fun init() {
    _userProfileMutableLiveData.value =
      UserProfileViewState(Status.LOADING)
  }

  fun getUserProfile(emailId: String) {
    val request = UserProfileRequestUiModel(emailId)
    disposable += getUserProfileUseCase
      .getUserProfile(request)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(this::onUserProfileReady)
  }

  private fun onUserProfileReady(resource: Resource<UserProfileResponseUiModel>) {
    if (resource.error != null) {
      return
    }

    if (resource.data == null) {
      return
    }

    // handle success
    val data = emptyList<BaseBindingRVModel>()
    val dataFromNetwork = resource.data?.list
    var allProfiles: MutableLiveData<MutableList<UserProfileUiModel>>? = null
    /*viewModelScope.launch(Dispatchers.IO) {
      dataFromNetwork?.forEach {
        getUserProfileUseCase.insertUserProfile(it)
      }

      allProfiles = getUserProfileUseCase.getAllUserProfiles()
    }*/

    _userProfileMutableLiveData.value =
      UserProfileViewState(
        status = resource.status,
        data = getViewableData(dataFromNetwork),
        error = resource.error
      )
    allProfiles?.value?.toMutableList()?.forEach {
     Log.d("apple email", it.emailId)
    }
  }

  private fun getViewableData(data: List<UserProfileUiModel>?): List<BaseBindingRVModel>? {
    if (data.isNullOrEmpty()) return null

    val userProfileList = mutableListOf<UserProfileRVModel>()

    data?.forEach {
      userProfileList.add(
        UserProfileRVModel(
          it
        )
      )
    }

    return userProfileList
  }



  override fun onViewClick(id: Int, data: Any) {

  }
}