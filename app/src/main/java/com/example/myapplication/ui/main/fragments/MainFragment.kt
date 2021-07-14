package com.example.myapplication.ui.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.ui.main.activities.MainActivity
import com.example.myapplication.viewmodels.MainViewModel

/**
 * @author Nav Singh
 */
class MainFragment : Fragment(R.layout.main_fragment) {
    lateinit var textView: TextView

    companion object {
        val TAG: String = MainFragment::class.java.simpleName
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onResume() {
        Log.e(TAG, "onResume: RESUMED")
        super.onResume()
    }

    override fun onStop() {
        Log.e(TAG, "onStop: STOPPED")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.e(TAG, "onDestroyView: DESTROYED")
        // clear the viewModel
        // viewModelStore.clear()
        viewModel.finishTheJob()
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy: DESTROYED")
        super.onDestroy()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        Log.e(TAG, "onHiddenChanged: $hidden")
        super.onHiddenChanged(hidden)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated: CREATED")
        textView = view.findViewById<TextView>(R.id.message_fragment_second)
        textView.setOnClickListener {
            (requireActivity() as? MainActivity)?.updateFragment(SecondFragment.newInstance())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.doSomeHeavyWork()
        }
        viewModel.updateNum.observe(
            viewLifecycleOwner,
            {
                Log.e(TAG, "onActivityCreated: UPDATE UI")
                textView.text = it.toString()
            }
        )
    }
}
