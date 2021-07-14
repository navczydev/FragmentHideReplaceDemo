package com.example.myapplication.ui.main.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.main.fragments.MainFragment
import com.example.myapplication.ui.main.fragments.SecondFragment

/**
 * @author Nav Singh
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(), MainFragment.TAG)
                .commitNow()
        }
    }

    fun updateFragment(fragment: Fragment) {
        val mainFragment = supportFragmentManager.fragments.first { it.tag == MainFragment.TAG }
        Log.e(TAG, "updateFragment: $mainFragment")
        supportFragmentManager.beginTransaction()
            .hide(mainFragment)
            .add(R.id.container, fragment, SecondFragment.TAG)
            .addToBackStack(SecondFragment.TAG)
            .commit()
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}
