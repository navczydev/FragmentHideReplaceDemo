package com.example.myapplication.ui.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.myapplication.R

/**
 * @author Nav Singh
 */
class SecondFragment : Fragment(R.layout.main_fragment2) {

    companion object {
        val TAG: String = SecondFragment::class.java.simpleName
        fun newInstance() = SecondFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.message_fragment_second).setOnClickListener {
            // parentFragmentManager.popBackStack()
            requireActivity().supportFragmentManager.beginTransaction().run {
                add(android.R.id.content, BlankFragment.newInstance(), BlankFragment.TAG)
                addToBackStack(BlankFragment.TAG)
            }.commit()
        }
        view.findViewById<TextView>(R.id.pop_stack).setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        view.findViewById<EditText>(R.id.edit_enter_text)
            .doOnTextChanged { text, start, before, count ->
                Log.e(TAG, "onViewCreated: $text")
            }
    }

    override fun onResume() {
        Log.e(TAG, "onResume: RESUMED")
        super.onResume()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        Log.e(TAG, "onHiddenChanged: $hidden")
        super.onHiddenChanged(hidden)
    }
}
