package `in`.example.demoassignment.view.form

import `in`.example.domain.base.Status
import `in`.example.ui.base.BaseViewState
import androidx.lifecycle.MutableLiveData

class FormViewState(status: Status, error: Throwable? = null, data: Any? = null) :
  BaseViewState<Any>(status, error, data){

  val emailIdError: MutableLiveData<String> = MutableLiveData("")
  val emailId: MutableLiveData<String> = MutableLiveData("")
  val liveDataNextScreen: MutableLiveData<Boolean> = MutableLiveData(false)
}