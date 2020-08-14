package `in`.example.data.network.service

import `in`.example.data.network.model.UserProfileRequest
import `in`.example.data.network.model.UserProfileResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserProfileService {
    @Headers("Content-Type: application/json")
    @POST("/list")
    fun getUserProfile(@Body requestBody: UserProfileRequest): Observable<UserProfileResponse>
}