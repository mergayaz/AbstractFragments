package kz.kuz.abstractfragmentsactivities

import androidx.fragment.app.Fragment

class MainActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return MainFragment1()
    }
}