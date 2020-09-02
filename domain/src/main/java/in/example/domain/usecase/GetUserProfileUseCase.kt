package `in`.example.domain.usecase

import `in`.example.domain.base.Resource
import `in`.example.domain.model.UserProfileRequestUiModel
import `in`.example.domain.model.UserProfileResponseUiModel
import `in`.example.domain.repository.UserProfileRepository
import io.reactivex.rxjava3.core.Observable

interface GetUserProfileUseCase {
  fun getUserProfile(request: UserProfileRequestUiModel): Observable<Resource<UserProfileResponseUiModel>>
  /*suspend fun insertUserProfile(userProfile: UserProfileUiModel)
  suspend fun getAllUserProfiles(): MutableLiveData<MutableList<UserProfileUiModel>>*/
}

class GetUserProfileUseCaseImpl(private val repository: UserProfileRepository) : GetUserProfileUseCase {
  override fun getUserProfile(request: UserProfileRequestUiModel): Observable<Resource<UserProfileResponseUiModel>> {
    return repository
      .getUserProfile(request)
      .map { resource ->
        Resource(
          status = resource.status,
          data = resource.data,
          error = resource.error
        )
      }
  }

  /*override suspend fun insertUserProfile(userProfile: UserProfileUiModel) {
    repository.insertUserProfile(userProfile)
  }

  override suspend fun getAllUserProfiles(): MutableLiveData<MutableList<UserProfileUiModel>> {
    return repository.getAllUserProfiles()
  }*/
}