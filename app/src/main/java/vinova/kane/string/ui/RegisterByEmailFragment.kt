package vinova.kane.string.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentRegisterByEmailBinding


class RegisterByEmailFragment : Fragment() {
    private lateinit var binding: FragmentRegisterByEmailBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        binding = FragmentRegisterByEmailBinding.inflate(inflater)

        binding.registerEmailBackButton.setOnClickListener {
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.back_to_start_fragment_action)
        }

        binding.termsOfServiceClick.setOnClickListener {
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.regis_email_to_terms_action)
        }

        binding.signUpButton.setOnClickListener {
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.register_email_to_login_action)
        }

        return binding.root

    }
}