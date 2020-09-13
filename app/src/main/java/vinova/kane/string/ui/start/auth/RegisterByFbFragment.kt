package vinova.kane.string.ui.start.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import androidx.navigation.fragment.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentRegisterByFbBinding


class RegisterByFbFragment : Fragment() {
    private lateinit var binding: FragmentRegisterByFbBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        binding = FragmentRegisterByFbBinding.inflate(inflater)

        binding.termsOfServiceClick.setOnClickListener {
            it.startAnimation(buttonClick)
            findNavController().navigate(R.id.regis_fb_to_terms_action)
        }


        return binding.root
    }
}