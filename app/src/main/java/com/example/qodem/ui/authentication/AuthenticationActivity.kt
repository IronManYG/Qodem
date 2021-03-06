package com.example.qodem.ui.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.qodem.R
import com.example.qodem.data.Language
import com.example.qodem.databinding.ActivityAuthenticationBinding
import com.example.qodem.ui.MainActivity
import com.example.qodem.ui.settingsandoptions.language.LanguageViewModel
import com.example.qodem.ui.signup.SignUpActivity
import com.example.qodem.utils.exhaustive
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.zeugmasolutions.localehelper.LocaleAwareCompatActivity
import com.zeugmasolutions.localehelper.Locales
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import java.util.*

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class AuthenticationActivity : LocaleAwareCompatActivity() {

    companion object {
        const val TAG = "AuthenticationActivity"
    }

    private lateinit var binding: ActivityAuthenticationBinding

    // Get a reference to the ViewModel scoped to this Activity.
    private val viewModel: AuthenticationViewModel by viewModels()

    private val languageViewModel: LanguageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                languageViewModel.language.collect { language ->
                    when (language) {
                        Language.Arabic -> {
                            if (Locale.getDefault() != Locales.Arabic) {
                                updateLocale(Locales.Arabic)
                            } else {
                            }
                        }
                        Language.English -> {
                            if (Locale.getDefault() != Locales.English) {
                                updateLocale(Locales.English)
                            } else {
                            }
                        }
                    }.exhaustive
                }
            }
        }

        binding.apply {
            // : Implement the create account and sign in using FirebaseUI, use sign in using Phone.
            authButton.setOnClickListener { startSignIn() }

            textViewArLanguage.setOnClickListener {
                viewModel.onLanguageSelected(Language.Arabic)
            }
            textViewEnLanguage.setOnClickListener {
                viewModel.onLanguageSelected(Language.English)
            }
        }

        // : If the user was authenticated, send him to MainActivity

        // Observe the authentication state so we can know if the user has logged in successfully.
        // If the user has logged in successfully, send them to the MainActivity.
        // If the user did not log in successfully, display an error message.
        viewModel.authenticationState.observe(this) { authenticationState ->
            when (authenticationState) {
                AuthenticationViewModel.AuthenticationState.AUTHENTICATED -> {
                    CoroutineScope(Dispatchers.Main).launch {
                        withContext(Dispatchers.Main) {
                            Log.e(TAG, "userPhoneNumber ${viewModel.userPhoneNumber.value.toString()} ")
                            val userPhoneNumber = viewModel.userPhoneNumber.value.toString()
                            viewModel.getUserInfo(userPhoneNumber)
                            lifecycleScope.launch {
                                repeatOnLifecycle(Lifecycle.State.STARTED) {
                                    viewModel.userInfoFoundState.collect() {
                                        when (it) {
                                            true -> {
                                                val intent = Intent(
                                                    this@AuthenticationActivity,
                                                    MainActivity::class.java
                                                )
                                                startActivity(intent)
                                                finish()
                                            }
                                            false -> {
                                                val intent = Intent(
                                                    this@AuthenticationActivity,
                                                    SignUpActivity::class.java
                                                )
                                                intent.putExtra(
                                                    "USER_PHONE_NUMBER",
                                                    userPhoneNumber
                                                )
                                                startActivity(intent)
                                                finish()

                                                Log.e(TAG, "user not founded")
                                                binding.apply {
                                                    authButton.visibility = View.VISIBLE
                                                    textViewArLanguage.visibility = View.VISIBLE
                                                    textViewEnLanguage.visibility = View.VISIBLE
                                                }
                                            }
                                        }
                                        binding.progressBar3.visibility = View.GONE
                                    }
                                }
                            }
                            // getting user donations for fire store if there is user info
                            if (viewModel.userInfoFoundState.value) {
                                Log.d(TAG, "Start geting all donations")
                                withContext(Dispatchers.IO) {
                                    viewModel.getAllDonations()
                                }
                            }
                        }
                    }
                }
                else -> {
                    binding.apply {
                        progressBar3.visibility = View.GONE
                        authButton.visibility = View.VISIBLE
                        authenticationLayout.visibility = View.VISIBLE
                        textViewArLanguage.visibility = View.VISIBLE
                        textViewEnLanguage.visibility = View.VISIBLE
                    }
                    Log.e(
                        TAG,
                        "Authentication state that doesn't require any UI change $authenticationState"
                    )
                }
            }
        }
    }

    // Caller
    private fun startSignIn() {
        // Give users the option to sign in / register with their Phone.
        val providers = arrayListOf(
            AuthUI.IdpConfig.PhoneBuilder().setDefaultCountryIso("sa").build()
        )

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            // ... options ...
            .setAvailableProviders(providers)
            .setTheme(R.style.Theme_Qodem)
            .build()
        signInLauncher.launch(signInIntent)
    }

    // Receiver
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { result: FirebaseAuthUIAuthenticationResult? ->
        // Handle the FirebaseAuthUIAuthenticationResult
        if (result != null) {
            onSignInResult(result)
        }
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            Log.i(
                TAG,
                "Successfully signed in user " +
                        "${FirebaseAuth.getInstance().currentUser?.displayName}!"
            )
        } else {
            // Sign in failed
            if (response == null) {
                // User pressed back button
                showSnackbar(R.string.sign_in_cancelled)
                return
            }
            if (response.error!!.errorCode == ErrorCodes.NO_NETWORK) {
                showSnackbar(R.string.no_internet_connection)
                return
            }
            showSnackbar(R.string.unknown_error)
            Log.e(TAG, "Sign-in error: ", response.error)

        }
    }

    private fun showSnackbar(stringId: Int) {
        Snackbar.make(
            findViewById(R.id.authenticationLayout),
            stringId,
            Snackbar.LENGTH_SHORT
        ).show()
    }

}