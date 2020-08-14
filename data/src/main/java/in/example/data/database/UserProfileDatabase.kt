package `in`.example.data.database

import `in`.example.data.database.dao.UserProfileDao
import `in`.example.data.database.model.UserProfileEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope


const val DATA_BASE_NAME = "user_profile_database"

@Database(entities = [UserProfileEntity::class], version = 1, exportSchema = false)
abstract class UserProfileDatabase : RoomDatabase() {

  abstract fun getUserProfileDao(): UserProfileDao

  companion object {
    @Volatile
    private var INSTANCE: UserProfileDatabase? = null

    fun getDatabase(scope: CoroutineScope, context: Context): UserProfileDatabase? {
      if (INSTANCE == null) {
        synchronized(this) {
          val instance = Room.databaseBuilder(
            context.applicationContext,
            UserProfileDatabase::class.java,
            DATA_BASE_NAME
          )
            .build()
          INSTANCE = instance
        }
      }
      return INSTANCE
    }
  }
}