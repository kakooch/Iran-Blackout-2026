package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC15790kA5;

/* loaded from: classes.dex */
public class AppCompatButton extends Button {
    private final C1917d a;
    private final p b;
    private i c;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    private i getEmojiTextViewHelper() {
        if (this.c == null) {
            this.c = new i(this);
        }
        return this.c;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.b();
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (F.b) {
            return super.getAutoSizeMaxTextSize();
        }
        p pVar = this.b;
        if (pVar != null) {
            return pVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (F.b) {
            return super.getAutoSizeMinTextSize();
        }
        p pVar = this.b;
        if (pVar != null) {
            return pVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (F.b) {
            return super.getAutoSizeStepGranularity();
        }
        p pVar = this.b;
        if (pVar != null) {
            return pVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (F.b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        p pVar = this.b;
        return pVar != null ? pVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (F.b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        p pVar = this.b;
        if (pVar != null) {
            return pVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC15575jo7.r(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            return c1917d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            return c1917d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        p pVar = this.b;
        if (pVar != null) {
            pVar.o(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        p pVar = this.b;
        if (pVar == null || F.b || !pVar.l()) {
            return;
        }
        this.b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (F.b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.t(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (F.b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.u(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (F.b) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.v(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.g(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC15575jo7.s(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        p pVar = this.b;
        if (pVar != null) {
            pVar.s(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.b.w(colorStateList);
        this.b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.b.x(mode);
        this.b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        p pVar = this.b;
        if (pVar != null) {
            pVar.q(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (F.b) {
            super.setTextSize(i, f);
            return;
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.A(i, f);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC15790kA5.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(z.b(context), attributeSet, i);
        y.a(this, getContext());
        C1917d c1917d = new C1917d(this);
        this.a = c1917d;
        c1917d.e(attributeSet, i);
        p pVar = new p(this);
        this.b = pVar;
        pVar.m(attributeSet, i);
        pVar.b();
        getEmojiTextViewHelper().c(attributeSet, i);
    }
}
