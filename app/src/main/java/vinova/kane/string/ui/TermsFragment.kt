package vinova.kane.string.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.navigation.fragment.findNavController
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentTermsBinding

class TermsFragment : Fragment() {
    private lateinit var binding: FragmentTermsBinding
    private val buttonClick = AlphaAnimation(1F, 0.6F)

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTermsBinding.inflate(inflater)

        binding.cancelButton.setOnClickListener {
            it.startAnimation(buttonClick)
            this.findNavController().navigate(R.id.terms_to_start_action)
        }

        binding.termsWebview.settings.javaScriptEnabled = true
        binding.termsWebview.loadUrl("file:///android_asset/terms.html")

        return binding.root

    }

}