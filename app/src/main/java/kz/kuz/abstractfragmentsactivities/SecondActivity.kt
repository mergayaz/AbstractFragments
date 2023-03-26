package kz.kuz.abstractfragmentsactivities

import androidx.fragment.app.Fragment

class SecondActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return SecondFragment1()
    }
}