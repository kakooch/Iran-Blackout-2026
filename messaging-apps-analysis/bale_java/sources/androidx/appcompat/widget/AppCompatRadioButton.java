package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC9594aE;

/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton {
    private final C1919f a;
    private final C1917d b;
    private final p c;
    private i d;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    private i getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new i(this);
        }
        return this.d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C1917d c1917d = this.b;
        if (c1917d != null) {
            c1917d.b();
        }
        p pVar = this.c;
        if (pVar != null) {
            pVar.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C1919f c1919f = this.a;
        return c1919f != null ? c1919f.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1917d c1917d = this.b;
        if (c1917d != null) {
            return c1917d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1917d c1917d = this.b;
        if (c1917d != null) {
            return c1917d.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C1919f c1919f = this.a;
        if (c1919f != null) {
            return c1919f.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C1919f c1919f = this.a;
        if (c1919f != null) {
            return c1919f.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1917d c1917d = this.b;
        if (c1917d != null) {
            c1917d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C1917d c1917d = this.b;
        if (c1917d != null) {
            c1917d.g(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C1919f c1919f = this.a;
        if (c1919f != null) {
            c1919f.f();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        p pVar = this.c;
        if (pVar != null) {
            pVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        p pVar = this.c;
        if (pVar != null) {
            pVar.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1917d c1917d = this.b;
        if (c1917d != null) {
            c1917d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1917d c1917d = this.b;
        if (c1917d != null) {
            c1917d.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C1919f c1919f = this.a;
        if (c1919f != null) {
            c1919f.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C1919f c1919f = this.a;
        if (c1919f != null) {
            c1919f.h(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.c.w(colorStateList);
        this.c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.c.x(mode);
        this.c.b();
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC15790kA5.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(z.b(context), attributeSet, i);
        y.a(this, getContext());
        C1919f c1919f = new C1919f(this);
        this.a = c1919f;
        c1919f.e(attributeSet, i);
        C1917d c1917d = new C1917d(this);
        this.b = c1917d;
        c1917d.e(attributeSet, i);
        p pVar = new p(this);
        this.c = pVar;
        pVar.m(attributeSet, i);
        getEmojiTextViewHelper().c(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AbstractC9594aE.b(getContext(), i));
    }
}
