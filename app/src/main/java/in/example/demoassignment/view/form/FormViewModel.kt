package `in`.example.demoassignment.view.form

import `in`.example.demoassignment.App
import `in`.example.demoassignment.R
import `in`.example.domain.base.Status
import `in`.example.ui.base.RxAwareViewModel
import `in`.example.ui.base.ViewOnClickListener
import `in`.example.ui.helper.isValidEmail
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FormViewModel : RxAwareViewModel(),
  ViewOnClickListener {

  private val _mutableLiveDataFormViewState = MutableLiveData<FormViewState>()
  val liveDataFormViewState: LiveData<FormViewState> = _mutableLiveDataFormViewState

  fun init() {
    _mutableLiveDataFormViewState.value =
      FormViewState(Status.LOADING)
  }

  private fun validateEmail(email: String?): Boolean {
    if (email.isNullOrEmpty()) {
      _mutableLiveDataFormViewState.value?.emailIdError?.postValue(App.instance.getString(R.string.email_empty))
      return false
    }

    if (!isValidEmail(email)) {
      _mutableLiveDataFormViewState.value?.emailIdError?.postValue(App.instance.getString(R.string.email_error))
      return false
    }

    _mutableLiveDataFormViewState.value?.emailIdError?.postValue("")
    return true
  }

  override fun onViewClick(id: Int, data: Any) {
    when(id) {
      R.id.on_click_btn_continue -> {
        if(validateEmail(liveDataFormViewState.value?.emailId?.value)) {
          _mutableLiveDataFormViewState.value?.liveDataNextScreen?.postValue(true)
        }
      }
    }
  }
}