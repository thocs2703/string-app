package vinova.kane.string.ui

import android.os.Bundle
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
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.verify_to_forgot_action)
        }

        return binding.root

    }
}