package jp.techacademy.taiyo.sasaki.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("UI_PARTS", "$hour:$minute")

                    //設定した時刻に応じて表示するテキストを変更する
                    if (hour >= 2 && hour <= 9) {
                        textView.text = "おはよう"
                    } else if (hour >= 10 && hour <= 17) {
                        textView.text = "こんにちは"
                    } else if (hour >= 18 || hour <=1) {
                        textView.text = "こんばんは"
                    }

                },
                13, 0, true)
        timePickerDialog.show()

    }
}