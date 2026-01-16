package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC17348mo7;
import ir.nasim.WB5;
import ir.nasim.YC5;

/* loaded from: classes3.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip a;
    private final TextInputLayout b;
    private final EditText c;
    private TextWatcher d;
    private TextView e;

    private class b extends AbstractC17348mo7 {
        private b() {
        }

        @Override // ir.nasim.AbstractC17348mo7, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.a.setText(ChipTextInputComboView.this.c("00"));
            } else {
                ChipTextInputComboView.this.a.setText(ChipTextInputComboView.this.c(editable));
            }
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void d() {
        this.c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.a.setChecked(z);
        this.c.setVisibility(z ? 0 : 4);
        this.a.setVisibility(z ? 8 : 0);
        if (isChecked()) {
            AbstractC10402bY7.o(this.c);
            if (TextUtils.isEmpty(this.c.getText())) {
                return;
            }
            EditText editText = this.c;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        this.a.setTag(i, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(YC5.material_time_chip, (ViewGroup) this, false);
        this.a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(YC5.material_time_input, (ViewGroup) this, false);
        this.b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.d = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.e = (TextView) findViewById(WB5.material_label);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
