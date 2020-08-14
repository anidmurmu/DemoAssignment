package `in`.example.data.network.repositoryimpl

import `in`.example.data.database.UserProfileDatabase
import `in`.example.data.database.dao.UserProfileDao
import `in`.example.data.database.model.UserProfileEntity
import `in`.example.data.network.mapper.UserProfileEntityToUiMapper
import `in`.example.data.network.mapper.UserProfileRequestMapper
import `in`.example.data.network.mapper.UserProfileResponseMapper
import `in`.example.data.network.mapper.UserProfileUiToEntityMapper
import `in`.example.data.network.service.UserProfileService
import `in`.example.domain.base.Resource
import `in`.example.domain.model.UserProfileRequestUiModel
import `in`.example.domain.model.UserProfileResponseUiModel
import `in`.example.domain.model.UserProfileUiModel
import `in`.example.domain.repository.UserProfileRepository
import androidx.lifecycle.MutableLiveData
import applyLoading
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class UserProfileRepositoryImpl(private val userProfileDao: UserProfileDao, private val dataSource: UserProfileService,
                                private val userProfileResponseMapper: UserProfileResponseMapper,
                                private val userProfileRequestMapper: UserProfileRequestMapper,
                                private val userProfileUiToEntityMapper: UserProfileUiToEntityMapper,
                                private val userProfileEntityToUiMapper: UserProfileEntityToUiMapper
) : UserProfileRepository {

  //private val userProfileDao: UserProfileDao? = UserProfileDatabase.getDatabase()?.getUserProfileDao()

  override fun getUserProfile(request: UserProfileRequestUiModel): Observable<Resource<UserProfileResponseUiModel>> {
    return dataSource
      .getUserProfile(userProfileRequestMapper.mapFrom(request))
      .map { Resource.success(it.let { userProfileResponseMapper.mapFrom(it) }) }
      .onErrorReturn { Resource.error(it) }
      .subscribeOn(Schedulers.io())
      .compose(applyLoading())
  }

  override suspend fun insertUserProfile(userProfile: UserProfileUiModel) {
    userProfileDao?.insertUserProfile(userProfileUiToEntityMapper.mapFrom(userProfile))
  }

  override suspend fun getAllUserProfiles(): MutableLiveData<MutableList<UserProfileUiModel>> {

    val entityList: MutableLiveData<MutableList<UserProfileEntity>>? = userProfileDao?.getAllProfiles()
    val uiModelList: MutableLiveData<MutableList<UserProfileUiModel>> = MutableLiveData()

    entityList?.value?.forEach {
      uiModelList.value?.add(userProfileEntityToUiMapper.mapFrom(it))
    }

    return uiModelList
  }
}