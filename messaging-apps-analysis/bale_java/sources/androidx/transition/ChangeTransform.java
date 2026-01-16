package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC8958Xy7;
import ir.nasim.TB5;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
public class ChangeTransform extends Transition {
    private static final String[] D0 = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property E0 = new a(float[].class, "nonTranslations");
    private static final Property F0 = new b(PointF.class, "translations");
    private static final boolean G0 = true;
    boolean A0;
    private boolean B0;
    private Matrix C0;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, float[] fArr) {
            eVar.d(fArr);
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, PointF pointF) {
            eVar.c(pointF);
        }
    }

    class c extends AnimatorListenerAdapter {
        private boolean a;
        private Matrix b = new Matrix();
        final /* synthetic */ boolean c;
        final /* synthetic */ Matrix d;
        final /* synthetic */ View e;
        final /* synthetic */ f f;
        final /* synthetic */ e g;

        c(boolean z, Matrix matrix, View view, f fVar, e eVar) {
            this.c = z;
            this.d = matrix;
            this.e = view;
            this.f = fVar;
            this.g = eVar;
        }

        private void a(Matrix matrix) {
            this.b.set(matrix);
            this.e.setTag(TB5.transition_transform, this.b);
            this.f.a(this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                if (this.c && ChangeTransform.this.A0) {
                    a(this.d);
                } else {
                    this.e.setTag(TB5.transition_transform, null);
                    this.e.setTag(TB5.parent_matrix, null);
                }
            }
            B.f(this.e, null);
            this.f.a(this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(this.g.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            ChangeTransform.p0(this.e);
        }
    }

    private static class d extends q {
        private View a;
        private InterfaceC1982e b;

        d(View view, InterfaceC1982e interfaceC1982e) {
            this.a = view;
            this.b = interfaceC1982e;
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void a(Transition transition) {
            this.b.setVisibility(0);
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void c(Transition transition) {
            this.b.setVisibility(4);
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            transition.W(this);
            AbstractC1986i.b(this.a);
            this.a.setTag(TB5.transition_transform, null);
            this.a.setTag(TB5.parent_matrix, null);
        }
    }

    private static class e {
        private final Matrix a = new Matrix();
        private final View b;
        private final float[] c;
        private float d;
        private float e;

        e(View view, float[] fArr) {
            this.b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.c = fArr2;
            this.d = fArr2[2];
            this.e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.c;
            fArr[2] = this.d;
            fArr[5] = this.e;
            this.a.setValues(fArr);
            B.f(this.b, this.a);
        }

        Matrix a() {
            return this.a;
        }

        void c(PointF pointF) {
            this.d = pointF.x;
            this.e = pointF.y;
            b();
        }

        void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.c, 0, fArr.length);
            b();
        }
    }

    private static class f {
        final float a;
        final float b;
        final float c;
        final float d;
        final float e;
        final float f;
        final float g;
        final float h;

        f(View view) {
            this.a = view.getTranslationX();
            this.b = view.getTranslationY();
            this.c = AbstractC12990fW7.K(view);
            this.d = view.getScaleX();
            this.e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.r0(view, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return fVar.a == this.a && fVar.b == this.b && fVar.c == this.c && fVar.d == this.d && fVar.e == this.e && fVar.f == this.f && fVar.g == this.g && fVar.h == this.h;
        }

        public int hashCode() {
            float f = this.a;
            int iFloatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.b;
            int iFloatToIntBits2 = (iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.c;
            int iFloatToIntBits3 = (iFloatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.d;
            int iFloatToIntBits4 = (iFloatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.e;
            int iFloatToIntBits5 = (iFloatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f;
            int iFloatToIntBits6 = (iFloatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.g;
            int iFloatToIntBits7 = (iFloatToIntBits6 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.h;
            return iFloatToIntBits7 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
        }
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A0 = true;
        this.B0 = true;
        this.C0 = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.A0 = AbstractC8958Xy7.a(typedArrayObtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.B0 = AbstractC8958Xy7.a(typedArrayObtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void l0(t tVar) {
        View view = tVar.b;
        if (view.getVisibility() == 8) {
            return;
        }
        tVar.a.put("android:changeTransform:parent", view.getParent());
        tVar.a.put("android:changeTransform:transforms", new f(view));
        Matrix matrix = view.getMatrix();
        tVar.a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.B0) {
            Matrix matrix2 = new Matrix();
            B.j((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            tVar.a.put("android:changeTransform:parentMatrix", matrix2);
            tVar.a.put("android:changeTransform:intermediateMatrix", view.getTag(TB5.transition_transform));
            tVar.a.put("android:changeTransform:intermediateParentMatrix", view.getTag(TB5.parent_matrix));
        }
    }

    private void m0(ViewGroup viewGroup, t tVar, t tVar2) {
        View view = tVar2.b;
        Matrix matrix = new Matrix((Matrix) tVar2.a.get("android:changeTransform:parentMatrix"));
        B.k(viewGroup, matrix);
        InterfaceC1982e interfaceC1982eA = AbstractC1986i.a(view, viewGroup, matrix);
        if (interfaceC1982eA == null) {
            return;
        }
        interfaceC1982eA.a((ViewGroup) tVar.a.get("android:changeTransform:parent"), tVar.b);
        Transition transition = this;
        while (true) {
            Transition transition2 = transition.r;
            if (transition2 == null) {
                break;
            } else {
                transition = transition2;
            }
        }
        transition.b(new d(view, interfaceC1982eA));
        if (G0) {
            View view2 = tVar.b;
            if (view2 != tVar2.b) {
                B.h(view2, 0.0f);
            }
            B.h(view, 1.0f);
        }
    }

    private ObjectAnimator n0(t tVar, t tVar2, boolean z) {
        Matrix matrix = (Matrix) tVar.a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) tVar2.a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = k.a;
        }
        if (matrix2 == null) {
            matrix2 = k.a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        f fVar = (f) tVar2.a.get("android:changeTransform:transforms");
        View view = tVar2.b;
        p0(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        e eVar = new e(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, PropertyValuesHolder.ofObject(E0, new C1980c(new float[9]), fArr, fArr2), m.a(F0, y().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        c cVar = new c(z, matrix3, view, fVar, eVar);
        objectAnimatorOfPropertyValuesHolder.addListener(cVar);
        AbstractC1978a.a(objectAnimatorOfPropertyValuesHolder, cVar);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean o0(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.K(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1d
            boolean r0 = r3.K(r5)
            if (r0 != 0) goto Lf
            goto L1d
        Lf:
            androidx.transition.t r4 = r3.x(r4, r1)
            if (r4 == 0) goto L20
            android.view.View r4 = r4.b
            if (r5 != r4) goto L1a
            goto L1b
        L1a:
            r1 = r2
        L1b:
            r2 = r1
            goto L20
        L1d:
            if (r4 != r5) goto L1a
            goto L1b
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.o0(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    static void p0(View view) {
        r0(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void q0(t tVar, t tVar2) {
        Matrix matrix = (Matrix) tVar2.a.get("android:changeTransform:parentMatrix");
        tVar2.b.setTag(TB5.parent_matrix, matrix);
        Matrix matrix2 = this.C0;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) tVar.a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            tVar.a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) tVar.a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    static void r0(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        AbstractC12990fW7.M0(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    @Override // androidx.transition.Transition
    public String[] G() {
        return D0;
    }

    @Override // androidx.transition.Transition
    public void i(t tVar) {
        l0(tVar);
    }

    @Override // androidx.transition.Transition
    public void m(t tVar) {
        l0(tVar);
        if (G0) {
            return;
        }
        ((ViewGroup) tVar.b.getParent()).startViewTransition(tVar.b);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, t tVar, t tVar2) {
        if (tVar == null || tVar2 == null || !tVar.a.containsKey("android:changeTransform:parent") || !tVar2.a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) tVar.a.get("android:changeTransform:parent");
        boolean z = this.B0 && !o0(viewGroup2, (ViewGroup) tVar2.a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) tVar.a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            tVar.a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) tVar.a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            tVar.a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            q0(tVar, tVar2);
        }
        ObjectAnimator objectAnimatorN0 = n0(tVar, tVar2, z);
        if (z && objectAnimatorN0 != null && this.A0) {
            m0(viewGroup, tVar, tVar2);
        } else if (!G0) {
            viewGroup2.endViewTransition(tVar.b);
        }
        return objectAnimatorN0;
    }
}
