package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9394Zt;
import ir.nasim.C15532jk4;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
abstract class b implements f {
    private final Context a;
    private final ExtendedFloatingActionButton b;
    private final ArrayList c = new ArrayList();
    private final com.google.android.material.floatingactionbutton.a d;
    private C15532jk4 e;
    private C15532jk4 f;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(AbstractC6732Ot.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.z0.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.z0.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f) {
            int colorForState = extendedFloatingActionButton.z0.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.z0.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (AbstractC6732Ot.a(0.0f, Color.alpha(colorForState) / 255.0f, f.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f.floatValue() == 1.0f) {
                extendedFloatingActionButton.B(extendedFloatingActionButton.z0);
            } else {
                extendedFloatingActionButton.B(colorStateListValueOf);
            }
        }
    }

    b(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar) {
        this.b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void a() {
        this.d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final List b() {
        return this.c;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public C15532jk4 d() {
        return this.f;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void f(C15532jk4 c15532jk4) {
        this.f = c15532jk4;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void g() {
        this.d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet i() {
        return l(m());
    }

    AnimatorSet l(C15532jk4 c15532jk4) {
        ArrayList arrayList = new ArrayList();
        if (c15532jk4.j("opacity")) {
            arrayList.add(c15532jk4.f("opacity", this.b, View.ALPHA));
        }
        if (c15532jk4.j("scale")) {
            arrayList.add(c15532jk4.f("scale", this.b, View.SCALE_Y));
            arrayList.add(c15532jk4.f("scale", this.b, View.SCALE_X));
        }
        if (c15532jk4.j("width")) {
            arrayList.add(c15532jk4.f("width", this.b, ExtendedFloatingActionButton.B0));
        }
        if (c15532jk4.j("height")) {
            arrayList.add(c15532jk4.f("height", this.b, ExtendedFloatingActionButton.C0));
        }
        if (c15532jk4.j("paddingStart")) {
            arrayList.add(c15532jk4.f("paddingStart", this.b, ExtendedFloatingActionButton.D0));
        }
        if (c15532jk4.j("paddingEnd")) {
            arrayList.add(c15532jk4.f("paddingEnd", this.b, ExtendedFloatingActionButton.E0));
        }
        if (c15532jk4.j("labelOpacity")) {
            arrayList.add(c15532jk4.f("labelOpacity", this.b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AbstractC9394Zt.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final C15532jk4 m() {
        C15532jk4 c15532jk4 = this.f;
        if (c15532jk4 != null) {
            return c15532jk4;
        }
        if (this.e == null) {
            this.e = C15532jk4.d(this.a, h());
        }
        return (C15532jk4) AbstractC4980Hj5.g(this.e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void onAnimationStart(Animator animator) {
        this.d.c(animator);
    }
}
