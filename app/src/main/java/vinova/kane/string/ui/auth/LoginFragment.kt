package vinova.kane.string.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentLoginBinding
import vinova.kane.string.ui.main.MainActivity
import vinova.kane.string.util.ACCESS_TOKEN
import vinova.kane.string.util.EMAIL_ARGS_FROM_LOGIN
import vinova.kane.string.util.LOGIN_SUCCESSFUL_MSG
import vinova.kane.string.util.VERIFY_EMAIL_MSG
import vinova.kane.string.viewmodel.AuthViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)

    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        binding = FragmentLoginBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        onClickEvent()

        return binding.root

    }

    private fun onClickEvent() {
        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }


        binding.forgotPwTextClick.setOnClickListener {
            it.startAnimation(buttonClick)
            findNavController().navigate(R.id.forgot_password_action)
        }

        binding.loginButton.setOnClickListener {
            it.startAnimation(buttonClick)
            loginUserByEmail()
        }
    }

    private fun loginUserByEmail() {
        viewModel.loginUserByEmail(
            binding.emailEditText.text.toString(),
            binding.passwordEditText.text.toString(),
            "0"
        )

        viewModel.dataLoginResponse.observe(viewLifecycleOwner, Observer {
            when (it.message) {
                LOGIN_SUCCESSFUL_MSG -> {
                    val intent = Intent(activity, MainActivity::class.java)
                    intent.putExtra(ACCESS_TOKEN, it.data.accessToken)
                    startActivity(intent)
                }
                VERIFY_EMAIL_MSG -> {
                    if (findNavController().currentDestination?.id == R.id.loginFragment) {
                        val bundle =
                            bundleOf(EMAIL_ARGS_FROM_LOGIN to binding.emailEditText.text.toString())
                        findNavController().navigate(R.id.login_to_verify_email_action, bundle)
                    }
                }
                else -> {
                    binding.errorText.text = it.message
                    binding.errorText.visibility = View.VISIBLE
                }
            }
        })
    }

}