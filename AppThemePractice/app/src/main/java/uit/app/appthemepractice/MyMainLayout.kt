package uit.app.appthemepractice

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.core.view.setMargins
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyMainLayout : LinearLayout {

    private val title:TextView
    private val button: Button
    private val secondaryTextView: TextView
    private val emailButton : FloatingActionButton

    constructor(context: Context) : super(context){
        var lp = MarginLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT).apply {
            setMargins(16,16,16,16)
        }
        layoutParams = lp


        orientation = VERTICAL

        // Title
        title = TextView(context)
        title.id = generateViewId()
        addView(title)

        // param + layout gravity
        title.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,48).apply {
            gravity = Gravity.CENTER_HORIZONTAL
        }

        // gravity
        title.gravity = Gravity.CENTER_VERTICAL

        title.textSize = 12f
        title.text = resources.getText(R.string.primary_color)
        title.isAllCaps = true

        //Button
        button = Button(context)
        button.id = generateViewId()
        button.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT).apply {
            gravity = Gravity.CENTER_HORIZONTAL
        }

        button.text = resources.getText(R.string.button)
        addView(button)

        // Secondary text view
        secondaryTextView = TextView(context)
        secondaryTextView.id = generateViewId()

//
//        val secondaryTextViewParams = ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,48).apply {
//            gravity = Gravity.CENTER_HORIZONTAL
//        }

        secondaryTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,48).apply {
            gravity = Gravity.CENTER_HORIZONTAL
        }

        secondaryTextView.gravity = Gravity.CENTER_VERTICAL
        secondaryTextView.text = resources.getText(R.string.secondary_color)
        secondaryTextView.isAllCaps = true
        secondaryTextView.textSize = 12f
        addView(secondaryTextView)

        emailButton = FloatingActionButton(context)
        emailButton.id = generateViewId()
        emailButton.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT).apply {
            gravity = Gravity.CENTER_HORIZONTAL
        }
        emailButton.contentDescription = resources.getText(R.string.content_description)
        emailButton.setImageResource(R.drawable.ic_baseline_email_24)
        addView(emailButton)

    }
}