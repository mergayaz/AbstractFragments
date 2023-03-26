package kz.kuz.abstractfragmentsactivities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainFragment2 : Fragment() {
    private lateinit var newFragment: Fragment
    private lateinit var editText: EditText

    // методы фрагмента должны быть открытыми
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.setTitle(R.string.main_fragment2_title)
        val view = inflater.inflate(R.layout.fragment2_main, container, false)
        val number: Int
        val args = arguments
        number = if (args != null) {
            arguments!!.getInt("Number")
        } else {
            0
        }
        editText = view.findViewById(R.id.editNumber)
        editText.requestFocus()
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = number.toString()
        val btnMain1 = view.findViewById<Button>(R.id.btn_main1)
        btnMain1.setOnClickListener {
            newFragment = MainFragment1()
            val args = Bundle()
            val numberText = editText.text.toString()
            args.putInt("Number", numberText.toInt())
            newFragment.arguments = args
            (activity as MainActivity).changeFragment(newFragment)
        }
        val btnMain2 = view.findViewById<Button>(R.id.btn_main2)
        btnMain2.setOnClickListener {
            newFragment = MainFragment2()
            val args = Bundle()
            val numberText = editText.getText().toString()
            args.putInt("Number", numberText.toInt())
            newFragment.arguments = args
            (activity as MainActivity).changeFragment(newFragment)
        }
        val btnSecond = view.findViewById<Button>(R.id.btn_second)
        btnSecond.setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            val bundle = Bundle()
            val numberText = editText.text.toString()
            bundle.putInt("Number", numberText.toInt())
            intent.putExtras(bundle)
            startActivity(intent)
        }
        val btnClose = view.findViewById<Button>(R.id.btn_close)
        btnClose.setOnClickListener { (activity as MainActivity).finish() }
        return view
    }
}