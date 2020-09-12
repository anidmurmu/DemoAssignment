package `in`.example.demoassignment.view.form

import `in`.example.demoassignment.R
import `in`.example.demoassignment.databinding.FragmentFormBinding
import `in`.example.ui.base.DataBindingBaseFragment
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

const val EMAIL = "email"

class FormFragment : DataBindingBaseFragment<FragmentFormBinding>() {

  private val model: FormViewModel by viewModel()

  override val layoutResource: Int
    get() = R.layout.fragment_form

  override fun onViewDataBindingCreated(binding: FragmentFormBinding) {
    binding.viewModel = model
    model.init()

    model.liveDataFormViewState.value?.liveDataNextScreen?.observe(this, Observer {
      if (it) {
        val bundle = bundleOf(EMAIL to model.liveDataFormViewState.value?.emailId?.value)
        findNavController().navigate(R.id.action_formFragment_to_userProfileFragment, bundle)
      }
    })
  }

  override fun setBaseStates() {
    progressErrorState = model.statusState
  }
}