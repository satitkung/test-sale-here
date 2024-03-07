package com.example.testsalehere.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.example.testsalehere.databinding.InputCustomViewBinding


@BindingMethods(
    BindingMethod(type = InputCustomView::class, attribute = "app:input_hint", method = "setInputHint"),
    BindingMethod(type = InputCustomView::class, attribute = "app:unit", method = "setUnit")
)
class InputCustomView
@JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val binding: InputCustomViewBinding by lazy {
        InputCustomViewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        initView()
    }

    private fun initView() {

    }

    fun setInputHint(text: String) {
        binding.edtInput.hint = text
    }

    fun setUnit(text: String) {
        binding.txtUnit.text = text
    }

}
