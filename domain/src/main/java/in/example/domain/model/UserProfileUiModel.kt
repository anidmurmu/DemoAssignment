package `in`.example.domain.model

data class UserProfileRequestUiModel(
  var emailId: String
)

data class UserProfileUiModel(
  var emailId: String,

  var imageUrl: String,

  var firstName: String,

  var lastName: String
) {
  var fullName = "$firstName $lastName"
}

class UserProfileResponseUiModel {
  var list = mutableListOf<UserProfileUiModel>()
}