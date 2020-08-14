package `in`.example.domain.repository

import `in`.example.domain.base.Resource
import `in`.example.domain.model.UserProfileRequestUiModel
import `in`.example.domain.model.UserProfileResponseUiModel
import `in`.example.domain.model.UserProfileUiModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Observable

interface UserProfileRepository {
  fun getUserProfile(request: UserProfileRequestUiModel): Observable<Resource<UserProfileResponseUiModel>>
  suspend fun insertUserProfile(userProfile: UserProfileUiModel)
  suspend fun getAllUserProfiles(): MutableLiveData<MutableList<UserProfileUiModel>>
}