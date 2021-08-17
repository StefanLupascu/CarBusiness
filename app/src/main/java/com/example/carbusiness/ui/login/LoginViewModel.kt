package com.example.carbusiness.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carbusiness.data.model.AuthenticationRequest
import com.example.carbusiness.data.service.AuthenticationService
import com.example.carbusiness.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val authenticationService: AuthenticationService): ViewModel() {

    private val _event = MutableLiveData<EventWrapper<Event>>()
    val event: LiveData<EventWrapper<Event>> get() = _event

    fun authenticate(username: String, password: String) {
        val authenticationRequest = AuthenticationRequest(username, password)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = wrapIntoResult { authenticationService.authenticate(authenticationRequest) }) {
                is Result.Success -> {
                    if (result.value != "") {
                        _event.postValue(Event.LoginSuccessful.wrap())
                    } else {
                        _event.postValue(Event.LoginFailed.wrap())
                    }
                }
                else -> {
                    _event.postValue(Event.LoginFailed.wrap())
                }
            }
        }
    }

    sealed class Event : BaseEvent {
        object LoginSuccessful : Event()
        object LoginFailed : Event()
    }
}