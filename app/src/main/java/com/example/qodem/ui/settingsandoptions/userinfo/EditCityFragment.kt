package com.example.qodem.ui.settingsandoptions.userinfo

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.qodem.R
import com.example.qodem.databinding.FragmentEditCityBinding
import com.example.qodem.utils.showSnackBar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlin.properties.Delegates

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class EditCityFragment : Fragment() {

    companion object {
        const val TAG = "EditCityFragment"
    }

    private val viewModel: UserInfoViewModel by viewModels()

    private lateinit var binding: FragmentEditCityBinding

    private var valueValidToSignUp by Delegates.notNull<Boolean>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEditCityBinding.inflate(layoutInflater)

        val cityItems = listOf("Khartoum", "Khartoum North", "Omdurman")

        setItemsToExposedDropdownMenu(cityItems.toTypedArray(), binding.menuCity)

        // Clear the error once more than x (textLength) characters are typed.
        binding.menuCityField.setOnDismissListener {
            // Clear the error.
            binding.menuCity.editText?.error = null
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userInfo.collect { userInfo ->

                    binding.buttonSave.setOnClickListener {

                        // Check Error State of city field
                        changeErrorStateInEditTextView(
                            binding.menuCity.editText!!,
                            1,
                            "Enter Your City"
                        )

                        // Check Value of city field
                        valueValidToSignUp = isAllEditTextValueValid()

                        // Update value if all value are valid
                        if (valueValidToSignUp) {
                            CoroutineScope(Dispatchers.Main).launch {
                                withContext(Dispatchers.IO) {
                                    viewModel.updateUserCity(
                                        userInfo.id,
                                        binding.menuCityField.text.toString(),
                                        userInfo.phoneNumber
                                    )
                                }
                            }
                            viewLifecycleOwner.lifecycleScope.launch {
                                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                                    viewModel.userInfoUpdated.collect() {
                                        when (it) {
                                            true -> {
                                                findNavController().popBackStack()
                                                binding.root.showSnackBar(
                                                    binding.root,
                                                    "Successfully updated",
                                                    Snackbar.LENGTH_SHORT,
                                                    null,
                                                    requireContext()
                                                ) {}
                                            }
                                            false -> {
                                                binding.root.showSnackBar(
                                                    binding.root,
                                                    viewModel.errorResultMessage.value.toString(),
                                                    Snackbar.LENGTH_SHORT,
                                                    null,
                                                    requireContext()
                                                ) {}
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            binding.root.showSnackBar(
                                binding.root,
                                "Please enter your city detail",
                                Snackbar.LENGTH_LONG,
                                null,
                                requireContext()
                            ) {}
                        }
                    }
                }
            }
        }
        return binding.root
    }

    private fun setItemsToExposedDropdownMenu(items: Array<String>, layout: TextInputLayout) {
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (layout.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    private fun isEditTextValueValid(text: Editable?, textLength: Int): Boolean {
        return text != null && text.length >= textLength
    }

    private fun changeErrorStateInEditTextView(
        editText: EditText,
        textLength: Int,
        errorMassage: String,
    ) {
        // Set an error if the EditTextValue is less than x (textLength) characters.
        if (!isEditTextValueValid(editText.text, textLength)) {
            editText.error = errorMassage
        } else {
            // Clear the error.
            editText.error = null
        }
    }

    private fun isAllEditTextValueValid(): Boolean {
        return isEditTextValueValid(binding.menuCity.editText!!.text, 1)
    }
}