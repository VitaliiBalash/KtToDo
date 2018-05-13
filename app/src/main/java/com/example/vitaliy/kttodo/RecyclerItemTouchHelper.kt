package com.example.vitaliy.kttodo

import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View

interface RecyclerItemTouchHelperListener {
    fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int)
}

class RecyclerItemTouchHelper(
        dragDirs: Int,
        swipeDirs: Int,
        private val listener: RecyclerItemTouchHelperListener
) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        listener.onSwiped(viewHolder, direction)
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (viewHolder is ViewHolderInterface) {
            ItemTouchHelper.Callback.getDefaultUIUtil().onSelected(viewHolder.getForeground())
        }
    }

    override fun clearView(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?) {
        if (viewHolder is InboxViewHolder) {
            ItemTouchHelper.Callback.getDefaultUIUtil().clearView(viewHolder.viewForeground)
        }
    }

    override fun onChildDraw(
            c: Canvas?, recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?,
            dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean
    ) {
        if (viewHolder is ViewHolderInterface) {
            viewHolder.getLeftBackground()?.visibility = if (dX > 0) View.VISIBLE else View.INVISIBLE

            ItemTouchHelper.Callback.getDefaultUIUtil().onDraw(
                    c, recyclerView, viewHolder.getForeground(), dX, dY, actionState, isCurrentlyActive
            )
        }
    }

    override fun onChildDrawOver(c: Canvas?, recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        if (viewHolder is ViewHolderInterface) {
            ItemTouchHelper.Callback.getDefaultUIUtil().onDrawOver(
                    c, recyclerView, viewHolder.getForeground(), dX, dY, actionState, isCurrentlyActive
            )
        }
    }
}
