package `in`.example.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_profile")
data class UserProfileEntity(
  @PrimaryKey
  @ColumnInfo(name = "email_id")
  val emailId: String,

  @ColumnInfo(name = "image_url")
  val imageUrl: String,

  @ColumnInfo(name = "first_name")
  val firstName: String,

  @ColumnInfo(name = "last_name")
  val lastName: String
)