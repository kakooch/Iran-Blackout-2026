package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import ir.nasim.AbstractC10961cV3;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC16714lk4;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC24690z26;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9394Zt;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C13508gL6;
import ir.nasim.C15532jk4;
import ir.nasim.C23;
import ir.nasim.CV3;
import ir.nasim.DC5;
import ir.nasim.InterfaceC4873Gx6;
import ir.nasim.InterfaceC6766Ow6;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
abstract class d {
    static final TimeInterpolator D = AbstractC6732Ot.c;
    static final int[] E = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] F = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] G = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] H = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] I = {R.attr.state_enabled};
    static final int[] J = new int[0];
    private ViewTreeObserver.OnPreDrawListener C;
    C11411cx6 a;
    C10345bV3 b;
    Drawable c;
    com.google.android.material.floatingactionbutton.c d;
    Drawable e;
    boolean f;
    float h;
    float i;
    float j;
    int k;
    private final C13508gL6 l;
    private Animator m;
    private C15532jk4 n;
    private C15532jk4 o;
    private float p;
    private int r;
    private ArrayList t;
    private ArrayList u;
    private ArrayList v;
    final FloatingActionButton w;
    final InterfaceC6766Ow6 x;
    boolean g = true;
    private float q = 1.0f;
    private int s = 0;
    private final Rect y = new Rect();
    private final RectF z = new RectF();
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();

    class a extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ k c;

        a(boolean z, k kVar) {
            this.b = z;
            this.c = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.s = 0;
            d.this.m = null;
            if (this.a) {
                return;
            }
            FloatingActionButton floatingActionButton = d.this.w;
            boolean z = this.b;
            floatingActionButton.b(z ? 8 : 4, z);
            k kVar = this.c;
            if (kVar != null) {
                kVar.c();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.w.b(0, this.b);
            d.this.s = 1;
            d.this.m = animator;
            this.a = false;
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ k b;

        b(boolean z, k kVar) {
            this.a = z;
            this.b = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.s = 0;
            d.this.m = null;
            k kVar = this.b;
            if (kVar != null) {
                kVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.w.b(0, this.a);
            d.this.s = 2;
            d.this.m = animator;
        }
    }

    class c extends CV3 {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            d.this.q = f;
            return super.evaluate(f, matrix, matrix2);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    class C0184d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;
        final /* synthetic */ float e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;
        final /* synthetic */ Matrix h;

        C0184d(float f, float f2, float f3, float f4, float f5, float f6, float f7, Matrix matrix) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = f7;
            this.h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.w.setAlpha(AbstractC6732Ot.b(this.a, this.b, 0.0f, 0.2f, fFloatValue));
            d.this.w.setScaleX(AbstractC6732Ot.a(this.c, this.d, fFloatValue));
            d.this.w.setScaleY(AbstractC6732Ot.a(this.e, this.d, fFloatValue));
            d.this.q = AbstractC6732Ot.a(this.f, this.g, fFloatValue);
            d.this.h(AbstractC6732Ot.a(this.f, this.g, fFloatValue), this.h);
            d.this.w.setImageMatrix(this.h);
        }
    }

    class e implements TypeEvaluator {
        FloatEvaluator a = new FloatEvaluator();

        e() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f, Float f2, Float f3) {
            float fFloatValue = this.a.evaluate(f, (Number) f2, (Number) f3).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.G();
            return true;
        }
    }

    private class g extends m {
        g() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return 0.0f;
        }
    }

    private class h extends m {
        h() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d dVar = d.this;
            return dVar.h + dVar.i;
        }
    }

    private class i extends m {
        i() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d dVar = d.this;
            return dVar.h + dVar.j;
        }
    }

    interface j {
        void a();

        void b();
    }

    interface k {
        void b();

        void c();
    }

    private class l extends m {
        l() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return d.this.h;
        }
    }

    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;
        private float b;
        private float c;

        private m() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f0((int) this.c);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                C10345bV3 c10345bV3 = d.this.b;
                this.b = c10345bV3 == null ? 0.0f : c10345bV3.w();
                this.c = a();
                this.a = true;
            }
            d dVar = d.this;
            float f = this.b;
            dVar.f0((int) (f + ((this.c - f) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ m(d dVar, a aVar) {
            this();
        }
    }

    d(FloatingActionButton floatingActionButton, InterfaceC6766Ow6 interfaceC6766Ow6) {
        this.w = floatingActionButton;
        this.x = interfaceC6766Ow6;
        C13508gL6 c13508gL6 = new C13508gL6();
        this.l = c13508gL6;
        c13508gL6.a(E, k(new i()));
        c13508gL6.a(F, k(new h()));
        c13508gL6.a(G, k(new h()));
        c13508gL6.a(H, k(new h()));
        c13508gL6.a(I, k(new l()));
        c13508gL6.a(J, k(new g()));
        this.p = floatingActionButton.getRotation();
    }

    private boolean Z() {
        return AbstractC12990fW7.T(this.w) && !this.w.isInEditMode();
    }

    private void g0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f2, Matrix matrix) {
        matrix.reset();
        if (this.w.getDrawable() == null || this.r == 0) {
            return;
        }
        RectF rectF = this.z;
        RectF rectF2 = this.A;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i2 = this.r;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.r;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    private AnimatorSet i(C15532jk4 c15532jk4, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        c15532jk4.h("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        c15532jk4.h("scale").a(objectAnimatorOfFloat2);
        g0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        c15532jk4.h("scale").a(objectAnimatorOfFloat3);
        g0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f4, this.B);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.w, new C23(), new c(), new Matrix(this.B));
        c15532jk4.h("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AbstractC9394Zt.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f2, float f3, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C0184d(this.w.getAlpha(), f2, this.w.getScaleX(), f3, this.w.getScaleY(), this.q, f4, new Matrix(this.B)));
        arrayList.add(valueAnimatorOfFloat);
        AbstractC9394Zt.a(animatorSet, arrayList);
        animatorSet.setDuration(AbstractC16714lk4.d(this.w.getContext(), AbstractC12181eA5.motionDurationLong1, this.w.getContext().getResources().getInteger(DC5.material_motion_duration_long_1)));
        animatorSet.setInterpolator(AbstractC16714lk4.e(this.w.getContext(), AbstractC12181eA5.motionEasingStandard, AbstractC6732Ot.b));
        return animatorSet;
    }

    private ValueAnimator k(m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    void A() {
        C10345bV3 c10345bV3 = this.b;
        if (c10345bV3 != null) {
            AbstractC10961cV3.f(this.w, c10345bV3);
        }
        if (J()) {
            this.w.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    abstract void B();

    void C() {
        ViewTreeObserver viewTreeObserver = this.w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    abstract void D(int[] iArr);

    abstract void E(float f2, float f3, float f4);

    void F(Rect rect) {
        AbstractC4980Hj5.h(this.e, "Didn't initialize content background");
        if (!Y()) {
            this.x.c(this.e);
        } else {
            this.x.c(new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void G() {
        float rotation = this.w.getRotation();
        if (this.p != rotation) {
            this.p = rotation;
            c0();
        }
    }

    void H() {
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).b();
            }
        }
    }

    void I() {
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a();
            }
        }
    }

    abstract boolean J();

    void K(ColorStateList colorStateList) {
        C10345bV3 c10345bV3 = this.b;
        if (c10345bV3 != null) {
            c10345bV3.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    void L(PorterDuff.Mode mode) {
        C10345bV3 c10345bV3 = this.b;
        if (c10345bV3 != null) {
            c10345bV3.setTintMode(mode);
        }
    }

    final void M(float f2) {
        if (this.h != f2) {
            this.h = f2;
            E(f2, this.i, this.j);
        }
    }

    void N(boolean z) {
        this.f = z;
    }

    final void O(C15532jk4 c15532jk4) {
        this.o = c15532jk4;
    }

    final void P(float f2) {
        if (this.i != f2) {
            this.i = f2;
            E(this.h, f2, this.j);
        }
    }

    final void Q(float f2) {
        this.q = f2;
        Matrix matrix = this.B;
        h(f2, matrix);
        this.w.setImageMatrix(matrix);
    }

    final void R(int i2) {
        if (this.r != i2) {
            this.r = i2;
            d0();
        }
    }

    void S(int i2) {
        this.k = i2;
    }

    final void T(float f2) {
        if (this.j != f2) {
            this.j = f2;
            E(this.h, this.i, f2);
        }
    }

    void U(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable != null) {
            AbstractC21710u02.i(drawable, AbstractC24690z26.d(colorStateList));
        }
    }

    void V(boolean z) {
        this.g = z;
        e0();
    }

    final void W(C11411cx6 c11411cx6) {
        this.a = c11411cx6;
        C10345bV3 c10345bV3 = this.b;
        if (c10345bV3 != null) {
            c10345bV3.setShapeAppearanceModel(c11411cx6);
        }
        Object obj = this.c;
        if (obj instanceof InterfaceC4873Gx6) {
            ((InterfaceC4873Gx6) obj).setShapeAppearanceModel(c11411cx6);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.d;
        if (cVar != null) {
            cVar.f(c11411cx6);
        }
    }

    final void X(C15532jk4 c15532jk4) {
        this.n = c15532jk4;
    }

    abstract boolean Y();

    final boolean a0() {
        return !this.f || this.w.getSizeDimension() >= this.k;
    }

    void b0(k kVar, boolean z) {
        if (y()) {
            return;
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = this.n == null;
        if (!Z()) {
            this.w.b(0, z);
            this.w.setAlpha(1.0f);
            this.w.setScaleY(1.0f);
            this.w.setScaleX(1.0f);
            Q(1.0f);
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        if (this.w.getVisibility() != 0) {
            this.w.setAlpha(0.0f);
            this.w.setScaleY(z2 ? 0.4f : 0.0f);
            this.w.setScaleX(z2 ? 0.4f : 0.0f);
            Q(z2 ? 0.4f : 0.0f);
        }
        C15532jk4 c15532jk4 = this.n;
        AnimatorSet animatorSetI = c15532jk4 != null ? i(c15532jk4, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f);
        animatorSetI.addListener(new b(z, kVar));
        ArrayList arrayList = this.t;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetI.start();
    }

    abstract void c0();

    final void d0() {
        Q(this.q);
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.add(animatorListener);
    }

    final void e0() {
        Rect rect = this.y;
        r(rect);
        F(rect);
        this.x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void f(Animator.AnimatorListener animatorListener) {
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(animatorListener);
    }

    void f0(float f2) {
        C10345bV3 c10345bV3 = this.b;
        if (c10345bV3 != null) {
            c10345bV3.a0(f2);
        }
    }

    void g(j jVar) {
        if (this.v == null) {
            this.v = new ArrayList();
        }
        this.v.add(jVar);
    }

    final Drawable l() {
        return this.e;
    }

    abstract float m();

    boolean n() {
        return this.f;
    }

    final C15532jk4 o() {
        return this.o;
    }

    float p() {
        return this.i;
    }

    void r(Rect rect) {
        int sizeDimension = this.f ? (this.k - this.w.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.g ? m() + this.j : 0.0f));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    float s() {
        return this.j;
    }

    final C11411cx6 t() {
        return this.a;
    }

    final C15532jk4 u() {
        return this.n;
    }

    void v(k kVar, boolean z) {
        if (x()) {
            return;
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        if (!Z()) {
            this.w.b(z ? 8 : 4, z);
            if (kVar != null) {
                kVar.c();
                return;
            }
            return;
        }
        C15532jk4 c15532jk4 = this.o;
        AnimatorSet animatorSetI = c15532jk4 != null ? i(c15532jk4, 0.0f, 0.0f, 0.0f) : j(0.0f, 0.4f, 0.4f);
        animatorSetI.addListener(new a(z, kVar));
        ArrayList arrayList = this.u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetI.start();
    }

    abstract void w(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2);

    boolean x() {
        return this.w.getVisibility() == 0 ? this.s == 1 : this.s != 2;
    }

    boolean y() {
        return this.w.getVisibility() != 0 ? this.s == 2 : this.s != 1;
    }

    abstract void z();
}
