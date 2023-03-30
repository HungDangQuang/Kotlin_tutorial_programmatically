package uit.app.tiptime.view

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.InputType
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.textfield.TextInputEditText
import uit.app.tiptime.R

class MainConstraintLayout: ConstraintLayout {

    private val textEdit:TextInputEditText
    private val textView: TextView
    private val radioGroup: android.widget.RadioGroup
    private val radioButton:RadioButton
    private val radioButton1:RadioButton
    private val radioButton2:RadioButton
    private val roundTipTextView:TextView
    private val switchButton: Switch

    constructor(context: Context) : super(context){
        generateViewId();
        setPadding(16,16,16,16)

        textEdit = TextInputEditText(context)
        textEdit.id = generateViewId()
        setUpTextEditProperties()
        addView(textEdit)

        textView = TextView(context)
        textView.id = generateViewId()
        setUpTextViewProperties()
        addView(textView)

        radioGroup = RadioGroup(context)
        radioGroup.id = generateViewId()
        radioGroup.orientation = RadioGroup.VERTICAL
        radioGroup.setPadding(16,16,16,16)
        addView(radioGroup)

        radioButton = RadioButton(context)
        radioButton.text = resources.getText(R.string.amazing_service)
        radioGroup.addView(radioButton)

        radioButton1 = RadioButton(context)
        radioButton1.text = resources.getText(R.string.good_service)
        radioGroup.addView(radioButton1)

        radioButton2 = RadioButton(context)
        radioButton2.text = resources.getText(R.string.ok_service)
        radioGroup.addView(radioButton2)

        roundTipTextView = TextView(context)
        roundTipTextView.id = generateViewId()
        roundTipTextView.text = resources.getText(R.string.round_up_tip)
        roundTipTextView.textSize = 20f
        roundTipTextView.setTextColor(Color.BLACK)
        addView(roundTipTextView)

        switchButton = Switch(context)
        switchButton.id = generateViewId()
        addView(switchButton)

        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        setBackgroundColor(Color.WHITE)
        val constraintSet = ConstraintSet()
        constraintSet.clone(this)
        constraintViewComponents(constraintSet)
        constraintSet.applyTo(this)
    }

    private fun setUpTextEditProperties(){
        textEdit.textSize = 20f;
        textEdit.typeface = Typeface.DEFAULT_BOLD
        textEdit.setTextColor(Color.BLUE)
        textEdit.inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
        textEdit.hint = resources.getText(R.string.cost_of_service)

        // padding
        textEdit.setPadding(16,16,16,16)
    }

    private fun setUpTextViewProperties(){
        textView.textSize = 15f
        textView.typeface = Typeface.DEFAULT
        textView.setTextColor(Color.BLACK)
        textView.text = resources.getText(R.string.how_was_the_service)
//        textView.setPadding(16,16,16,16)
    }

    private fun constraintViewComponents(constraintSet: ConstraintSet){
        // text edit
        constraintSet.constrainWidth(textEdit.id,160)
        constraintSet.constrainHeight(textEdit.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(textEdit.id,ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START)
        constraintSet.connect(textEdit.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP)

        // text view
        constraintSet.constrainWidth(textView.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(textView.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(textView.id,ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START)
        constraintSet.connect(textView.id,ConstraintSet.TOP,textEdit.id,ConstraintSet.BOTTOM)

        // radio group
        constraintSet.constrainWidth(radioGroup.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(radioGroup.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(radioGroup.id,ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START)
        constraintSet.connect(radioGroup.id,ConstraintSet.TOP,textView.id,ConstraintSet.BOTTOM)

        constraintSet.constrainWidth(radioButton.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(radioButton.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(radioButton.id,ConstraintSet.START,radioGroup.id,ConstraintSet.START)
        constraintSet.connect(radioButton.id,ConstraintSet.TOP,radioGroup.id,ConstraintSet.TOP)

        constraintSet.constrainWidth(radioButton1.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(radioButton1.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(radioButton1.id,ConstraintSet.START,radioGroup.id,ConstraintSet.START)
        constraintSet.connect(radioButton1.id,ConstraintSet.TOP,radioButton.id,ConstraintSet.BOTTOM)

        constraintSet.constrainWidth(radioButton2.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(radioButton2.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(radioButton2.id,ConstraintSet.START,radioGroup.id,ConstraintSet.START)
        constraintSet.connect(radioButton2.id,ConstraintSet.TOP,radioButton1.id,ConstraintSet.BOTTOM)

        constraintSet.constrainWidth(roundTipTextView.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(roundTipTextView.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(roundTipTextView.id,ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START)
        constraintSet.connect(roundTipTextView.id,ConstraintSet.TOP,radioGroup.id,ConstraintSet.BOTTOM)

        constraintSet.constrainWidth(switchButton.id,ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(switchButton.id,ConstraintSet.WRAP_CONTENT)

        constraintSet.connect(switchButton.id,ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END)
        constraintSet.connect(switchButton.id,ConstraintSet.TOP,roundTipTextView.id,ConstraintSet.TOP)
    }

}