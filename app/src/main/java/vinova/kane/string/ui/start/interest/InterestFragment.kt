package vinova.kane.string.ui.start.interest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vinova.kane.string.databinding.FragmentInterestBinding
import vinova.kane.string.model.interest.InterestData
import vinova.kane.string.ui.start.interest.adapter.InterestAdapter
import vinova.kane.string.viewmodel.InterestViewModel

class InterestFragment : Fragment() {
    private lateinit var binding: FragmentInterestBinding
    private lateinit var adapter: InterestAdapter
    private lateinit var viewModel: InterestViewModel
    private val listInterest: ArrayList<InterestData> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInterestBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(InterestViewModel::class.java)
        bindData()

        return binding.root
    }

    private fun bindData(){
        var authorization = ""
        adapter = InterestAdapter()
        binding.interestRecyclerView.adapter = adapter
        if ( arguments?.getString("SELECT_INTEREST") != null){
            authorization = requireArguments().getString("SELECT_INTEREST").toString()
        }
        viewModel.getListInterests("Bearer $authorization")
        viewModel.interestDataPagedList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}