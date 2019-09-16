package sample.push.firebase.my.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentB: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("FragmentB", "onCreateView")
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentB", "onViewCreated")

        val backStackEntryCount = getMainActivity()?.supportFragmentManager?.backStackEntryCount ?: 0
        for (index in 0 until backStackEntryCount) {
            val backStackEntry = getMainActivity()?.supportFragmentManager?.getBackStackEntryAt(index)
            Log.d("FragmentB", "index=$index name=${backStackEntry?.name}")
        }

        button.setOnClickListener {
            getMainActivity()?.supportFragmentManager?.popBackStack()
        }

        button2.setOnClickListener {
            getMainActivity()?.replaceFragment(FragmentC())
        }
    }
}