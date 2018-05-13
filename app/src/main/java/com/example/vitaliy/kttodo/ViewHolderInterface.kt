package com.example.vitaliy.kttodo

import android.view.View

interface ViewHolderInterface {
    fun getForeground(): View
    fun getLeftBackground(): View? // visible when swiping to the right
    fun getRightBackground(): View? // visible when swiping to the left
}