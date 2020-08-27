package vinova.kane.string.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.navigation.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentForgotPasswordBinding.inflate(inflater)

        binding.sendResetLinkButton.setOnClickListener {
            it.startAnimation(buttonClick)
            it.findNavController().navigate(R.id.verify_email_action)
        }

        binding.backButton.setOnClickListener {
            it.startAnimation(buttonClick)
            it.findNavController().navigate(R.id.forgot_pw_to_login_action)
        }

        return binding.root

    }

}