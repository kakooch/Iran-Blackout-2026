package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import ir.nasim.AbstractC24690z26;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.InterfaceC6766Ow6;
import ir.nasim.QA5;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class e extends d {

    static class a extends C10345bV3 {
        a(C11411cx6 c11411cx6) {
            super(c11411cx6);
        }

        @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    e(FloatingActionButton floatingActionButton, InterfaceC6766Ow6 interfaceC6766Ow6) {
        super(floatingActionButton, interfaceC6766Ow6);
    }

    private Animator i0(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.w, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(d.D);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void B() {
        e0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void D(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void E(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(d.E, i0(f, f3));
        stateListAnimator.addState(d.F, i0(f, f2));
        stateListAnimator.addState(d.G, i0(f, f2));
        stateListAnimator.addState(d.H, i0(f, f2));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.w, "elevation", f).setDuration(0L));
        if (i <= 24) {
            FloatingActionButton floatingActionButton = this.w;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(d.D);
        stateListAnimator.addState(d.I, animatorSet);
        stateListAnimator.addState(d.J, i0(0.0f, 0.0f));
        this.w.setStateListAnimator(stateListAnimator);
        if (Y()) {
            e0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean J() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void U(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(AbstractC24690z26.d(colorStateList));
        } else {
            super.U(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean Y() {
        return this.x.b() || !a0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void c0() {
    }

    c h0(int i, ColorStateList colorStateList) {
        Context context = this.w.getContext();
        c cVar = new c((C11411cx6) AbstractC4980Hj5.g(this.a));
        cVar.e(AbstractC4043Dl1.c(context, QA5.design_fab_stroke_top_outer_color), AbstractC4043Dl1.c(context, QA5.design_fab_stroke_top_inner_color), AbstractC4043Dl1.c(context, QA5.design_fab_stroke_end_inner_color), AbstractC4043Dl1.c(context, QA5.design_fab_stroke_end_outer_color));
        cVar.d(i);
        cVar.c(colorStateList);
        return cVar;
    }

    C10345bV3 j0() {
        return new a((C11411cx6) AbstractC4980Hj5.g(this.a));
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float m() {
        return this.w.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void r(Rect rect) {
        if (this.x.b()) {
            super.r(rect);
        } else if (a0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.k - this.w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void w(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        C10345bV3 c10345bV3J0 = j0();
        this.b = c10345bV3J0;
        c10345bV3J0.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.Q(this.w.getContext());
        if (i > 0) {
            this.d = h0(i, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) AbstractC4980Hj5.g(this.d), (Drawable) AbstractC4980Hj5.g(this.b)});
        } else {
            this.d = null;
            layerDrawable = this.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(AbstractC24690z26.d(colorStateList2), layerDrawable, null);
        this.c = rippleDrawable;
        this.e = rippleDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void z() {
    }
}
