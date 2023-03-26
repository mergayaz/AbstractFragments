package kz.kuz.abstractfragmentsactivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class SingleFragmentActivity : AppCompatActivity() {
    protected abstract fun createFragment(): Fragment
    private var fm = supportFragmentManager
    var fragment = fm.findFragmentById(R.id.fragment_container)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bundle = intent.extras
        if (fragment == null) {
            fragment = createFragment()
            if (bundle != null) {
                val args = Bundle()
                args.putInt("Number", bundle.getInt("Number"))
                fragment!!.arguments = args
            }
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment!!)
                    .commit()
        }
    }

    fun changeFragment(newFragment: Fragment) {
        fragment = newFragment
        fm.beginTransaction()
                .replace(R.id.fragment_container, fragment!!)
                .commit()
    }
}