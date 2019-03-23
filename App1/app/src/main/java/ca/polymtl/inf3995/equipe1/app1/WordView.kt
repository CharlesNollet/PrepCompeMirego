package ca.polymtl.inf3995.equipe1.app1

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_word.view.*

class WordView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_word, this, true)
    }

    fun setupView(word :Data) {
        wordTextView.text = word.word
        scoreTextView.text = word.score.toString()
    }
}