package com.example.mustafamotiwala.tindergiphy.Utils

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SimpleItemAnimator
import android.view.animation.Interpolator

class ScaleItemDecorator(private val _interpolator: Interpolator) : SimpleItemAnimator() {

    init {
        addDuration = 2000
        removeDuration = 2000
    }

    override fun runPendingAnimations() {

    }

    override fun endAnimation(item: RecyclerView.ViewHolder) {

    }

    override fun endAnimations() {

    }

    override fun isRunning(): Boolean {
        return false
    }

    override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {
        ViewCompat.animate(holder.itemView)
                .scaleX(0f)
                .scaleY(0f)
                .setDuration(removeDuration)
                .setInterpolator(_interpolator)
                .start()
        return false
    }

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        ViewCompat.animate(holder.itemView)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(addDuration)
                .setInterpolator(_interpolator)
                .start()
        return false
    }

    override fun animateMove(holder: RecyclerView.ViewHolder, fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
        return false
    }

    override fun animateChange(oldHolder: RecyclerView.ViewHolder, newHolder: RecyclerView.ViewHolder, fromLeft: Int, fromTop: Int, toLeft: Int,
                               toTop: Int): Boolean {
        return false
    }

}