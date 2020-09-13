package vinova.kane.string.ui.start.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import vinova.kane.string.databinding.FragmentVerifyEmailBinding
import vinova.kane.string.util.EMAIL_ARGS_FROM_LOGIN
import vinova.kane.string.util.EMAIL_ARGS_FROM_SIGN_UP

class VerifyEmailFragment : Fragment() {

    private lateinit var binding: FragmentVerifyEmailBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentVerifyEmailBinding.inflate(inflater)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        if ( arguments?.getString(EMAIL_ARGS_FROM_SIGN_UP) != null){
            binding.emailText.text = requireArguments().getString(EMAIL_ARGS_FROM_SIGN_UP).toString()
        } else{
            binding.emailText.text = requireArguments().getString(EMAIL_ARGS_FROM_LOGIN).toString()
        }

        return binding.root

    }
}