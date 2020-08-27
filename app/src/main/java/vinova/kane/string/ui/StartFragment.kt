package vinova.kane.string.ui

import android.app.AppComponentFactory
import android.os.Bundle
import android.view.*
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        (activity as AppCompatActivity).supportActionBar?.hide()

        binding = FragmentStartBinding.inflate(inflater)

        binding.signUpWithEmailButton.setOnClickListener {
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.register_by_email_action)
        }

        binding.signUpWithFbButton.setOnClickListener {
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.register_by_fb_action)
        }

        return binding.root

    }

}