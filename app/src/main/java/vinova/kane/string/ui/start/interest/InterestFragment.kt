package vinova.kane.string.ui.start.interest

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_interest.*
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentInterestBinding
import vinova.kane.string.model.interest.InterestData
import vinova.kane.string.ui.main.MainActivity
import vinova.kane.string.ui.start.interest.adapter.InterestAdapter
import vinova.kane.string.util.SaveSharedPreference
import vinova.kane.string.viewmodel.InterestViewModel

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class InterestFragment : Fragment() {
    private lateinit var binding: FragmentInterestBinding
    private lateinit var viewModel: InterestViewModel
    private var count = 0
    private var countMore = 3
    private var authorization = ""

    private val adapter: InterestAdapter by lazy {
        InterestAdapter {
            itemInterestClick()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInterestBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(InterestViewModel::class.java)
        bindData()

        return binding.root
    }

    private fun bindData() {
        binding.interestRecyclerView.adapter = adapter
        if (arguments?.getString("SELECT_INTEREST") != null) {
            authorization = requireArguments().getString("SELECT_INTEREST").toString()
        }

        viewModel.getListInterest("Bearer $authorization")
        viewModel.interest.observe(viewLifecycleOwner, Observer { interest ->
            if (interest.status) {
                interest.data.let {
                    adapter.addInterestData(it)
                }
            }
        })
    }

    private fun itemInterestClick() {
        count = adapter.getSelectCount()
        with(binding) {
            if (count >= 3) {
                verifySelectButton.isEnabled = true
                verifySelectButton.backgroundTintList =
                    ContextCompat.getColorStateList(requireContext(), android.R.color.holo_purple)
                verifySelectButton.text = getString(R.string.done)
                verifySelectButton.setOnClickListener {
                    SaveSharedPreference().setLoggedIn(activity?.applicationContext!!, true)
                    SaveSharedPreference().setAccessToken(activity?.applicationContext!!, authorization)
                    val intent = Intent(activity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            } else {
                verifySelectButton.isEnabled = false
                verifySelectButton.backgroundTintList =
                    ContextCompat.getColorStateList(requireContext(), android.R.color.darker_gray)
                verifySelectButton.text = getString(R.string._3_more, (countMore - count))
            }
        }
    }

}