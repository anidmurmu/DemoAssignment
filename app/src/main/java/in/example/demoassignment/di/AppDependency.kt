package `in`.example.demoassignment.di

import `in`.example.demoassignment.view.form.FormViewModel
import `in`.example.demoassignment.view.userprofile.UserProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
  viewModel { UserProfileViewModel(get()) }
  viewModel { FormViewModel() }
}