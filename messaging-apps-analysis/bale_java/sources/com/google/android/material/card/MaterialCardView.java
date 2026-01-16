package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import ir.nasim.AbstractC10961cV3;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9594aE;
import ir.nasim.C11411cx6;
import ir.nasim.GE5;
import ir.nasim.InterfaceC4873Gx6;

/* loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, InterfaceC4873Gx6 {
    private static final int[] n = {R.attr.state_checkable};
    private static final int[] o = {R.attr.state_checked};
    private static final int[] p = {AbstractC12181eA5.state_dragged};
    private static final int q = AbstractC21175tE5.Widget_MaterialComponents_CardView;
    private final com.google.android.material.card.a j;
    private boolean k;
    private boolean l;
    private boolean m;

    public interface a {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private void g() {
        if (Build.VERSION.SDK_INT > 26) {
            this.j.i();
        }
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.j.j().getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.j.k();
    }

    public ColorStateList getCardForegroundColor() {
        return this.j.l();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.j.m();
    }

    public int getCheckedIconGravity() {
        return this.j.n();
    }

    public int getCheckedIconMargin() {
        return this.j.o();
    }

    public int getCheckedIconSize() {
        return this.j.p();
    }

    public ColorStateList getCheckedIconTint() {
        return this.j.q();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.j.A().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.j.A().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.j.A().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.j.A().top;
    }

    public float getProgress() {
        return this.j.u();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.j.s();
    }

    public ColorStateList getRippleColor() {
        return this.j.v();
    }

    public C11411cx6 getShapeAppearanceModel() {
        return this.j.w();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.j.x();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.j.y();
    }

    public int getStrokeWidth() {
        return this.j.z();
    }

    public boolean h() {
        com.google.android.material.card.a aVar = this.j;
        return aVar != null && aVar.D();
    }

    public boolean i() {
        return this.m;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.l;
    }

    void j(int i, int i2, int i3, int i4) {
        super.setContentPadding(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC10961cV3.f(this, this.j.j());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (h()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, n);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, o);
        }
        if (i()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, p);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(h());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.j.H(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.k) {
            if (!this.j.C()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.j.I(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        this.j.J(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        this.j.d0();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.j.K(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.j.L(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.l != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.j.N(drawable);
    }

    public void setCheckedIconGravity(int i) {
        if (this.j.n() != i) {
            this.j.O(i);
        }
    }

    public void setCheckedIconMargin(int i) {
        this.j.P(i);
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.j.P(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCheckedIconResource(int i) {
        this.j.N(AbstractC9594aE.b(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.j.Q(i);
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.j.Q(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.j.R(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        com.google.android.material.card.a aVar = this.j;
        if (aVar != null) {
            aVar.b0();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.j.Y(i, i2, i3, i4);
    }

    public void setDragged(boolean z) {
        if (this.m != z) {
            this.m = z;
            refreshDrawableState();
            g();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.j.f0();
    }

    public void setOnCheckedChangeListener(a aVar) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.j.f0();
        this.j.c0();
    }

    public void setProgress(float f) {
        this.j.T(f);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        this.j.S(f);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.j.U(colorStateList);
    }

    public void setRippleColorResource(int i) {
        this.j.U(AbstractC9594aE.a(getContext(), i));
    }

    @Override // ir.nasim.InterfaceC4873Gx6
    public void setShapeAppearanceModel(C11411cx6 c11411cx6) {
        setClipToOutline(c11411cx6.u(getBoundsAsRectF()));
        this.j.V(c11411cx6);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        this.j.X(i);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.j.f0();
        this.j.c0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (h() && isEnabled()) {
            this.l = !this.l;
            refreshDrawableState();
            g();
            this.j.M(this.l);
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.j.J(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.j.W(colorStateList);
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        int i2 = q;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        this.l = false;
        this.m = false;
        this.k = true;
        TypedArray typedArrayH = AbstractC5729Ko7.h(getContext(), attributeSet, GE5.MaterialCardView, i, i2, new int[0]);
        com.google.android.material.card.a aVar = new com.google.android.material.card.a(this, attributeSet, i, i2);
        this.j = aVar;
        aVar.J(super.getCardBackgroundColor());
        aVar.Y(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.G(typedArrayH);
        typedArrayH.recycle();
    }
}
