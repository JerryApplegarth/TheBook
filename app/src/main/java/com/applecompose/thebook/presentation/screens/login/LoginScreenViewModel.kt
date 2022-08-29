package com.applecompose.thebook.presentation.screens.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginScreenViewModel: ViewModel() {

	//val loadingState = MutableStateFlow(LoadingState.IDLE)
	private val auth: FirebaseAuth = Firebase.auth

	private val _loading = MutableLiveData(false)
	val loading: LiveData<Boolean> = _loading

	fun signInWithEmailAndPassword(email: String, password: String)
	= viewModelScope.launch{
		try {
			auth.signInWithEmailAndPassword(email, password)
				.addOnCompleteListener { task ->
					Log.d("FB", "signInWithEmailAndPassword: ${task.result.toString()}")
					if (task.isSuccessful) {
						TODO("take them home")
					}else {
						Log.d("FB", "signInWithEmailAndPassword: Log in Works ${task.result.toString()}")
					}
				}
		}catch (ex: Exception) {
			Log.d("FB", "signInWithEmailAndPassword: ${ex.message}")
		}
	}

	fun createUserEmailAndPassword() {


	}




}