package uit.app.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uit.app.tiptime.view.MainConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(MainConstraintLayout(this))
    }
}