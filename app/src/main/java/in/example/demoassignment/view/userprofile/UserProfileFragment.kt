package `in`.example.demoassignment.view.userprofile

import RVModelBindingAdapter
import `in`.example.demoassignment.App
import `in`.example.demoassignment.R
import `in`.example.ui.base.DataBindingBaseFragment
import `in`.example.demoassignment.databinding.FragmentUserProfileBinding
import `in`.example.demoassignment.view.form.EMAIL
import `in`.example.ui.base.BaseViewState
import android.widget.Toast
import androidx.lifecycle.LiveData
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserProfileFragment : DataBindingBaseFragment<FragmentUserProfileBinding>() {

  private val model: UserProfileViewModel by viewModel()
  lateinit var emailId: String

  override val layoutResource: Int
    get() = R.layout.fragment_user_profile

  override fun onViewDataBindingCreated(binding: FragmentUserProfileBinding) {
    binding.viewModel = model
    model.init()
    emailId = arguments?.getString(EMAIL) ?: "no email"

    model.getUserProfile(emailId)
    binding.recyclerUserProfile.adapter = RVModelBindingAdapter(emptyList(), model,
      UserProfileVHFactory()
    )
  }

  override fun setBaseStates() {
    loadingState = model.userProfileLiveData as LiveData<BaseViewState<*>>
  }
}