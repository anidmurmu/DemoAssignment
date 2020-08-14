package `in`.example.data.network.model.base

import com.google.gson.annotations.SerializedName

open class CloudBaseResponse {
  @SerializedName("code")
  var code: Int? = null

  @SerializedName("message")
  var msg: String? = null
}

open class ErrorBaseResponse {
  @SerializedName("code")
  var code: String? = null

  @SerializedName("message")
  var msg: String? = null

  @SerializedName("status")
  var status: String? = null
}