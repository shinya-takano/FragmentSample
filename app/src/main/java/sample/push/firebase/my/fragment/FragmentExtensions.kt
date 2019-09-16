package sample.push.firebase.my.fragment

import androidx.fragment.app.Fragment

fun Fragment.getBackStackTag(): String {
    return this.javaClass.simpleName
}

fun Fragment.getMainActivity(): MainActivity? {
    if (activity is MainActivity) {
        return activity as MainActivity
    }
    return null
}