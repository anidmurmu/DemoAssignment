package `in`.example.data.database.dao

import `in`.example.data.database.model.UserProfileEntity
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserProfileDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertUserProfile(userProfile: UserProfileEntity)

  @Query("SELECT * FROM user_profile")
  suspend fun getAllProfiles(): MutableLiveData<MutableList<UserProfileEntity>>
}