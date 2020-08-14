package `in`.example.data.network.mapper

import `in`.example.data.database.model.UserProfileEntity
import `in`.example.data.network.model.UserProfileRequest
import `in`.example.data.network.model.UserProfileResponse
import `in`.example.domain.base.Mapper
import `in`.example.domain.model.UserProfileRequestUiModel
import `in`.example.domain.model.UserProfileResponseUiModel
import `in`.example.domain.model.UserProfileUiModel

class UserProfileResponseMapper :
  Mapper<UserProfileResponse, UserProfileResponseUiModel> {
  override fun mapFrom(type: UserProfileResponse): UserProfileResponseUiModel {
    val res = UserProfileResponseUiModel()
    type.items.forEach {
      res.list.add(
        UserProfileUiModel(
          it.emailId ?: "",
          it.imageUrl ?: "",
          it.firstName ?: "",
          it.lastName ?: ""
      ))
    }
    return res
  }
}

class UserProfileRequestMapper :
  Mapper<UserProfileRequestUiModel, UserProfileRequest> {
  override fun mapFrom(type: UserProfileRequestUiModel): UserProfileRequest {
    val request = UserProfileRequest()
    request.emailId = type.emailId
    return request
  }
}

class UserProfileUiToEntityMapper : Mapper<UserProfileUiModel, UserProfileEntity> {
  override fun mapFrom(type: UserProfileUiModel): UserProfileEntity {
    return UserProfileEntity(
      type.emailId,
      type.imageUrl,
      type.firstName,
      type.lastName
    )
  }
}

class UserProfileEntityToUiMapper : Mapper<UserProfileEntity, UserProfileUiModel> {
  override fun mapFrom(type: UserProfileEntity): UserProfileUiModel {
    return UserProfileUiModel(
      type.emailId,
      type.imageUrl,
      type.firstName,
      type.lastName
    )
  }
}