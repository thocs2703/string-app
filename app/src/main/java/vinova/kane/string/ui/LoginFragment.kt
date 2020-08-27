package vinova.kane.string.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.navigation.fragment.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater)

        binding.cancelButton.setOnClickListener {
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.login_cancel_to_start_action)
        }

        binding.forgotPwTextClick.setOnClickListener {
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.forgot_password_action)
        }

        return binding.root

    }

}