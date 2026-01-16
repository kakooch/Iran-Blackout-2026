package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.HB5;

/* loaded from: classes3.dex */
class a extends com.google.android.material.textfield.e {
    private final TextWatcher e;
    private final View.OnFocusChangeListener f;
    private final TextInputLayout.f g;
    private final TextInputLayout.g h;
    private AnimatorSet i;
    private ValueAnimator j;

    /* renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    class C0189a implements TextWatcher {
        C0189a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            aVar.i(aVar.m());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            a aVar = a.this;
            aVar.i(aVar.m());
        }
    }

    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.this.m());
            editText.setOnFocusChangeListener(a.this.f);
            a aVar = a.this;
            aVar.c.setOnFocusChangeListener(aVar.f);
            editText.removeTextChangedListener(a.this.e);
            editText.addTextChangedListener(a.this.e);
        }
    }

    class d implements TextInputLayout.g {

        /* renamed from: com.google.android.material.textfield.a$d$a, reason: collision with other inner class name */
        class RunnableC0190a implements Runnable {
            final /* synthetic */ EditText a;

            RunnableC0190a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(a.this.e);
                a.this.i(true);
            }
        }

        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 2) {
                return;
            }
            editText.post(new RunnableC0190a(editText));
            if (editText.getOnFocusChangeListener() == a.this.f) {
                editText.setOnFocusChangeListener(null);
            }
            if (a.this.c.getOnFocusChangeListener() == a.this.f) {
                a.this.c.setOnFocusChangeListener(null);
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.U();
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.a.setEndIconVisible(true);
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.a.setEndIconVisible(false);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.c.setScaleX(fFloatValue);
            a.this.c.setScaleY(fFloatValue);
        }
    }

    a(TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
        this.e = new C0189a();
        this.f = new b();
        this.g = new c();
        this.h = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        boolean z2 = this.a.K() == z;
        if (z && !this.i.isRunning()) {
            this.j.cancel();
            this.i.start();
            if (z2) {
                this.i.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.i.cancel();
        this.j.start();
        if (z2) {
            this.j.end();
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(AbstractC6732Ot.a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new h());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator k() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AbstractC6732Ot.d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new i());
        return valueAnimatorOfFloat;
    }

    private void l() {
        ValueAnimator valueAnimatorK = k();
        ValueAnimator valueAnimatorJ = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.i = animatorSet;
        animatorSet.playTogether(valueAnimatorK, valueAnimatorJ);
        this.i.addListener(new f());
        ValueAnimator valueAnimatorJ2 = j(1.0f, 0.0f);
        this.j = valueAnimatorJ2;
        valueAnimatorJ2.addListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        EditText editText = this.a.getEditText();
        return editText != null && (editText.hasFocus() || this.c.hasFocus()) && editText.getText().length() > 0;
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        TextInputLayout textInputLayout = this.a;
        int i2 = this.d;
        if (i2 == 0) {
            i2 = HB5.mtrl_ic_cancel;
        }
        textInputLayout.setEndIconDrawable(i2);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(AbstractC23026wD5.clear_text_end_icon_content_description));
        this.a.setEndIconCheckable(false);
        this.a.setEndIconOnClickListener(new e());
        this.a.g(this.g);
        this.a.h(this.h);
        l();
    }

    @Override // com.google.android.material.textfield.e
    void c(boolean z) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        i(z);
    }
}
