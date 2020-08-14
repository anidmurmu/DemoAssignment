package `in`.example.data.network.model

import `in`.example.data.network.model.base.CloudBaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserProfile {
    @SerializedName("emailId")
    @Expose
    var emailId: String? = null

    @SerializedName("imageUrl")
    @Expose
    var imageUrl: String? = null

    @SerializedName("firstName")
    @Expose
    var firstName: String? = null

    @SerializedName("lastName")
    @Expose
    var lastName: String? = null
}

class UserProfileResponse : CloudBaseResponse() {
    @SerializedName("items")
    @Expose
    var items: List<UserProfile> = emptyList()
}

class UserProfileRequest {
    @SerializedName("emailId")
    @Expose
    var emailId: String? = null
}