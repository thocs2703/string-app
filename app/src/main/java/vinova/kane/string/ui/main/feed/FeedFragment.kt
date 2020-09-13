package vinova.kane.string.ui.main.feed

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vinova.kane.string.databinding.FragmentFeedBinding
import vinova.kane.string.ui.start.StartActivity
import vinova.kane.string.ui.main.feed.adapter.FeedAdapter
import vinova.kane.string.util.SaveSharedPreference
import vinova.kane.string.viewmodel.FeedViewModel


class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var adapter: FeedAdapter
    private lateinit var viewModel: FeedViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFeedBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        val authorization = SaveSharedPreference().getAccessToken(activity?.applicationContext!!)
        Log.d("FeedFragment", "Authorization: $authorization")
        if (authorization != "") {
            viewModel.getFeed("Bearer $authorization")
        } else {
            Log.i("FeedFragment", "Access token have died!")
            Toast.makeText(activity, "Access token have died!", Toast.LENGTH_SHORT).show()
            SaveSharedPreference().setLoggedIn(activity?.applicationContext!!, false)
            val intent = Intent(activity, StartActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }

        bindData()

        return binding.root
    }

    private fun bindData(){
        adapter = FeedAdapter()
        binding.feedRecyclerview.adapter = adapter
        viewModel.feedDataPagedList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}