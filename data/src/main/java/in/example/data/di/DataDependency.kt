package `in`.example.data.di

import `in`.example.data.network.mapper.UserProfileRequestMapper
import `in`.example.data.network.mapper.UserProfileResponseMapper
import `in`.example.data.network.repositoryimpl.UserProfileRepositoryImpl
import `in`.example.data.network.retrofit.createNetworkClient
import `in`.example.data.network.service.UserProfileService
import `in`.example.domain.repository.UserProfileRepository
import org.koin.dsl.module

val dataModule = module {
  single { (createNetworkClient(get())).create(UserProfileService::class.java) }

  single { UserProfileResponseMapper() }
  single { UserProfileRequestMapper() }
  //single { UserProfileUiToEntityMapper() }
  //single { UserProfileEntityToUiMapper() }
  single<UserProfileRepository> { UserProfileRepositoryImpl(get(), get(), get()) }
  /*single { Room.databaseBuilder(get(), UserProfileDatabase::class.java, "user_profile_database").build() }
  single { { get<UserProfileDatabase>().getUserProfileDao() } }*/
  //single { { Room.databaseBuilder(get(), UserProfileDatabase::class.java, "user_profile_database").build().getUserProfileDao() } }
}
