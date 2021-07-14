package com.example.myapplication.ui.main.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.main.activities.SecondActivity

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 * @author Nav Singh
 */
class BlankFragment : Fragment(R.layout.fragment_blank) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.open_ac).setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
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

    companion object {
        val TAG: String = BlankFragment::class.java.simpleName

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}
