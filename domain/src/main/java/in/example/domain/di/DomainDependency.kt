package `in`.example.domain.di

import `in`.example.domain.usecase.GetUserProfileUseCase
import `in`.example.domain.usecase.GetUserProfileUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
  single<GetUserProfileUseCase> { GetUserProfileUseCaseImpl(get()) }
}