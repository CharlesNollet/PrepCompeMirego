package ca.polymtl.inf3995.equipe1.app1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(private val words: ArrayList<Data>) : RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    inner class ViewHolder(var singleWordView: View, var context: Context) : RecyclerView.ViewHolder(singleWordView)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val singleSongView = WordView(parent.context)
        singleSongView.layoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(singleSongView, parent.context)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        (holder.singleWordView as WordView).setupView(words[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = words.size

}