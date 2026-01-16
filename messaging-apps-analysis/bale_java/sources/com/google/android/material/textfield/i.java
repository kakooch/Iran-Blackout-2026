package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.AbstractC17348mo7;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.HB5;

/* loaded from: classes3.dex */
class i extends e {
    private final TextWatcher e;
    private final TextInputLayout.f f;
    private final TextInputLayout.g g;

    class a extends AbstractC17348mo7 {
        a() {
        }

        @Override // ir.nasim.AbstractC17348mo7, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.c.setChecked(!r1.g());
        }
    }

    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            i.this.c.setChecked(!r0.g());
            editText.removeTextChangedListener(i.this.e);
            editText.addTextChangedListener(i.this.e);
        }
    }

    class c implements TextInputLayout.g {

        class a implements Runnable {
            final /* synthetic */ EditText a;

            a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(i.this.e);
            }
        }

        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = i.this.a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (i.this.g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            i.this.a.U();
        }
    }

    i(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.e = new a();
        this.f = new b();
        this.g = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        TextInputLayout textInputLayout = this.a;
        int i = this.d;
        if (i == 0) {
            i = HB5.design_password_eye;
        }
        textInputLayout.setEndIconDrawable(i);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(AbstractC23026wD5.password_toggle_content_description));
        this.a.setEndIconVisible(true);
        this.a.setEndIconCheckable(true);
        this.a.setEndIconOnClickListener(new d());
        this.a.g(this.f);
        this.a.h(this.g);
        EditText editText = this.a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
