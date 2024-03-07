package com.example.testsalehere.custom_view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.example.testsalehere.databinding.SelectorCustomViewBinding


@BindingMethods(
    BindingMethod(type = SelectorCustomView::class, attribute = "app:selector_hint", method = "setSelectorHint"),
    BindingMethod(type = SelectorCustomView::class, attribute = "app:icon", method = "setIcon")
)
class SelectorCustomView
@JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val binding: SelectorCustomViewBinding by lazy {
        SelectorCustomViewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        initView()
    }

    private fun initView() {

    }

    fun setSelectorHint(text: String) {
        binding.txtHint.text = text
    }

    fun setIcon(image: Drawable) {
        binding.imvIcon.setImageDrawable(image)
    }

}
