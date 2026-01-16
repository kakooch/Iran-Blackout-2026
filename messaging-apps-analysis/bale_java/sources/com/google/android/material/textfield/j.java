package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C;
import com.google.android.material.internal.CheckableImageButton;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC23123wO3;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.GE5;
import ir.nasim.WB5;
import ir.nasim.X2;
import ir.nasim.YC5;

/* loaded from: classes3.dex */
class j extends LinearLayout {
    private final TextInputLayout a;
    private final TextView b;
    private CharSequence c;
    private final CheckableImageButton d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private View.OnLongClickListener g;
    private boolean h;

    j(TextInputLayout textInputLayout, C c) {
        super(textInputLayout.getContext());
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(YC5.design_text_input_start_icon, (ViewGroup) this, false);
        this.d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.b = appCompatTextView;
        g(c);
        f(c);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void f(C c) {
        this.b.setVisibility(8);
        this.b.setId(WB5.textinput_prefix_text);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AbstractC12990fW7.r0(this.b, 1);
        l(c.n(GE5.TextInputLayout_prefixTextAppearance, 0));
        if (c.s(GE5.TextInputLayout_prefixTextColor)) {
            m(c.c(GE5.TextInputLayout_prefixTextColor));
        }
        k(c.p(GE5.TextInputLayout_prefixText));
    }

    private void g(C c) {
        if (AbstractC9751aV3.i(getContext())) {
            AbstractC23123wO3.c((ViewGroup.MarginLayoutParams) this.d.getLayoutParams(), 0);
        }
        q(null);
        r(null);
        if (c.s(GE5.TextInputLayout_startIconTint)) {
            this.e = AbstractC9751aV3.b(getContext(), c, GE5.TextInputLayout_startIconTint);
        }
        if (c.s(GE5.TextInputLayout_startIconTintMode)) {
            this.f = AbstractC10402bY7.k(c.k(GE5.TextInputLayout_startIconTintMode, -1), null);
        }
        if (c.s(GE5.TextInputLayout_startIconDrawable)) {
            p(c.g(GE5.TextInputLayout_startIconDrawable));
            if (c.s(GE5.TextInputLayout_startIconContentDescription)) {
                o(c.p(GE5.TextInputLayout_startIconContentDescription));
            }
            n(c.a(GE5.TextInputLayout_startIconCheckable, true));
        }
    }

    private void x() {
        int i = (this.c == null || this.h) ? 8 : 0;
        setVisibility((this.d.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.b.setVisibility(i);
        this.a.p0();
    }

    CharSequence a() {
        return this.c;
    }

    ColorStateList b() {
        return this.b.getTextColors();
    }

    TextView c() {
        return this.b;
    }

    CharSequence d() {
        return this.d.getContentDescription();
    }

    Drawable e() {
        return this.d.getDrawable();
    }

    boolean h() {
        return this.d.getVisibility() == 0;
    }

    void i(boolean z) {
        this.h = z;
        x();
    }

    void j() {
        f.c(this.a, this.d, this.e);
    }

    void k(CharSequence charSequence) {
        this.c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.b.setText(charSequence);
        x();
    }

    void l(int i) {
        AbstractC15575jo7.p(this.b, i);
    }

    void m(ColorStateList colorStateList) {
        this.b.setTextColor(colorStateList);
    }

    void n(boolean z) {
        this.d.setCheckable(z);
    }

    void o(CharSequence charSequence) {
        if (d() != charSequence) {
            this.d.setContentDescription(charSequence);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        w();
    }

    void p(Drawable drawable) {
        this.d.setImageDrawable(drawable);
        if (drawable != null) {
            f.a(this.a, this.d, this.e, this.f);
            u(true);
            j();
        } else {
            u(false);
            q(null);
            r(null);
            o(null);
        }
    }

    void q(View.OnClickListener onClickListener) {
        f.e(this.d, onClickListener, this.g);
    }

    void r(View.OnLongClickListener onLongClickListener) {
        this.g = onLongClickListener;
        f.f(this.d, onLongClickListener);
    }

    void s(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            f.a(this.a, this.d, colorStateList, this.f);
        }
    }

    void t(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            f.a(this.a, this.d, this.e, mode);
        }
    }

    void u(boolean z) {
        if (h() != z) {
            this.d.setVisibility(z ? 0 : 8);
            w();
            x();
        }
    }

    void v(X2 x2) {
        if (this.b.getVisibility() != 0) {
            x2.Z0(this.d);
        } else {
            x2.E0(this.b);
            x2.Z0(this.b);
        }
    }

    void w() {
        EditText editText = this.a.e;
        if (editText == null) {
            return;
        }
        AbstractC12990fW7.F0(this.b, h() ? 0 : AbstractC12990fW7.F(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(AbstractC12799fB5.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }
}
