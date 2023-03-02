package uit.app.firstapp.view

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import uit.app.firstapp.R

class MainLayout: ConstraintLayout{

    // inherit constructor
    constructor(context:Context) : super(context) {

        // auto generate id
        generateViewId()

        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)

        setBackgroundColor(Color.WHITE)

        // create constraint set to constraint

        var constraintSet = ConstraintSet()

        constraintSet.clone(this)

        createGridLayout(context,constraintSet)

        constraintSet.applyTo(this)


    }

    private fun createGridLayout(context: Context, constraintSet: ConstraintSet){

        var textView = TextView(context)
        textView.id = generateViewId()
        textView.text = "Happy Birthday"
        textView.textSize = 30f
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.setTextColor(Color.BLUE)
        addView(textView)


        var endTitle = TextView(context)
        endTitle.id = generateViewId()
        endTitle.text = "Lisa"
        endTitle.textSize = 20f
        endTitle.typeface = Typeface.MONOSPACE
        endTitle.setTextColor(Color.DKGRAY)
        addView(endTitle)

        var img = ImageView(context)
        img.id = generateViewId()
        img.setImageResource(R.drawable.ic_baseline_cake_24)
        addView(img)

        // constraint width and height
        constraintSet.constrainHeight(textView.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainWidth(textView.id,ConstraintSet.WRAP_CONTENT)

        // vertical and horizontal constraint
        constraintSet.connect(textView.id,ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START)
        constraintSet.connect(textView.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP)

        // image
        constraintSet.constrainHeight(img.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainWidth(img.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(img.id,ConstraintSet.START,textView.id,ConstraintSet.END)
        constraintSet.connect(img.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP)

        // constraint width and height
        constraintSet.constrainHeight(endTitle.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainWidth(endTitle.id,ConstraintSet.WRAP_CONTENT)

        // vertical and horizontal constraint
        constraintSet.connect(endTitle.id,ConstraintSet.END, ConstraintSet.PARENT_ID,ConstraintSet.END)
        constraintSet.connect(endTitle.id,ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM)
    }


}