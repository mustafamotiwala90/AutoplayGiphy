package com.example.mustafamotiwala.tindergiphy.Utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.State;
import android.view.View


class MarginItemDecorator(private val _margin: Int, private val _columns: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
        val position = parent.getChildLayoutPosition(view)
        outRect.right = _margin
        outRect.bottom = _margin

        if (position < _columns) {
            outRect.top = _margin
        }
        // Since its 2 columns we can do a check to only set left margins for 2nd columns
        if (position % _columns == 0) {
            outRect.left = _margin
        }
    }

}