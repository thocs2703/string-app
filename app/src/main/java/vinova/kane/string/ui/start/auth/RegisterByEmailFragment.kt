package vinova.kane.string.ui.start.auth

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentRegisterByEmailBinding
import vinova.kane.string.util.EMAIL_ARGS_FROM_SIGN_UP
import vinova.kane.string.viewmodel.AuthViewModel
import java.text.SimpleDateFormat
import java.util.*


class RegisterByEmailFragment : Fragment() {
    private lateinit var binding: FragmentRegisterByEmailBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)
    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        binding = FragmentRegisterByEmailBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        getDateOfBirth()
        termsIsCheck()

        onClickEvent()

        return binding.root

    }

    private fun onClickEvent(){
        binding.registerEmailBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.termsOfServiceClick.setOnClickListener {
            it.startAnimation(buttonClick)
            findNavController().navigate(R.id.register_email_to_terms_action)
        }

        binding.signUpButton.setOnClickListener {
            it.startAnimation(buttonClick)
            registerUser()
        }
    }

    private fun registerUser(){
        val username = binding.usernameEditText.text.toString()
        val name = binding.nameEditText.text.toString()
        val dayOfBirth = binding.dateEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        val confirmPassword = binding.confirmPasswordEditText.text.toString()
        viewModel.registerUser(username, name, dayOfBirth, email, password, confirmPassword)

        handleResponse()
    }

    private fun handleResponse(){
        viewModel.registerResponse.observe(viewLifecycleOwner, Observer {
            if (it.status){
                Log.d("RegisterByEmailFragment", "Register Status: ${it.status}")
                binding.progressBar.visibility = View.VISIBLE
                binding.errorText.visibility = View.GONE
                val bundle = bundleOf(EMAIL_ARGS_FROM_SIGN_UP to binding.emailEditText.text.toString())
                Log.d("RegisterByEmailFragment", "Put Email: ${binding.emailEditText.text}")
                if(findNavController().currentDestination?.id == R.id.registerByEmailFragment){
                    findNavController().navigate(R.id.sign_up_success_action, bundle)
                }
                Log.d("RegisterByEmailFragment", "Terms Fragment Id: ${R.id.termsFragment}") // 2131362064
                Log.d("RegisterByEmailFragment", "Register By Email Fragment Id: ${R.id.registerByEmailFragment}")
                Log.d("RegisterByEmailFragment", "Current Destination: ${findNavController().currentDestination?.id}") //2131361995
            } else{
                binding.progressBar.visibility = View.GONE
                binding.errorText.visibility = View.VISIBLE
            }

            binding.errorText.text = it.message

            Log.d("RegisterByEmailFragment", "Register Data: ${it.data}")
        })
    }

    private fun getDateOfBirth(){
        val calendar = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            binding.dateEditText.setText(SimpleDateFormat("dd/MM/yyyy", Locale.US).format(calendar.time))
        }

        binding.dateEditText.setOnClickListener {
            context?.let { it1 ->
                DatePickerDialog(
                    it1, dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun termsIsCheck(){
        binding.termsRadioButton.setOnClickListener {
            if (binding.termsRadioButton.isChecked) {
                binding.signUpButton.visibility = View.VISIBLE
                binding.notSignUpButton.visibility = View.INVISIBLE
            } else{
                binding.signUpButton.visibility = View.INVISIBLE
                binding.notSignUpButton.visibility = View.VISIBLE
            }
        }
    }
}