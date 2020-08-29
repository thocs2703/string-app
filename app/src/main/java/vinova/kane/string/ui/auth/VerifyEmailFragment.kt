package vinova.kane.string.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.navigation.fragment.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentVerifyEmailBinding

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

        binding.emailText.text = arguments?.getString("EMAIL").toString()
        Log.d("VerifyEmailFragment", "Get email from register fragment: ${arguments?.getString("EMAIL")}")

        return binding.root

    }
}