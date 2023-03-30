package uit.app.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uit.app.firstapp.view.MainLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainLayout(this))

    }
}