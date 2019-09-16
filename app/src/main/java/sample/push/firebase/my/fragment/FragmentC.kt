package sample.push.firebase.my.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_c.*

class FragmentC: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("FragmentC", "onCreateView")
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentC", "onViewCreated")

        val backStackEntryCount = getMainActivity()?.supportFragmentManager?.backStackEntryCount ?: 0
        for (index in 0 until backStackEntryCount) {
            val backStackEntry = getMainActivity()?.supportFragmentManager?.getBackStackEntryAt(index)
            Log.d("FragmentC", "index=$index name=${backStackEntry?.name}")
        }

        button.setOnClickListener {

            // fragmentManager から pop したい Fragment の tag を取得(popした後のFragmentが表示される)
            val tag = getMainActivity()?.supportFragmentManager?.getBackStackEntryAt(1)?.name
            Log.d("FragmentC", "tag=$tag")
            getMainActivity()?.supportFragmentManager?.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        button2.setOnClickListener {
            getMainActivity()?.supportFragmentManager?.popBackStack()
        }

        button3.setOnClickListener {
            getMainActivity()?.replaceFragment(FragmentD())
        }
    }
}
