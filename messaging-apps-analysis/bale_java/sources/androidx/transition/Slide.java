package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC8958Xy7;
import ir.nasim.KB6;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
public class Slide extends Visibility {
    private static final TimeInterpolator E0 = new DecelerateInterpolator();
    private static final TimeInterpolator F0 = new AccelerateInterpolator();
    private static final g G0 = new a();
    private static final g H0 = new b();
    private static final g I0 = new c();
    private static final g J0 = new d();
    private static final g K0 = new e();
    private static final g L0 = new f();
    private g C0;
    private int D0;

    class a extends h {
        a() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    class b extends h {
        b() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return AbstractC12990fW7.A(viewGroup) == 1 ? view.getTranslationX() + viewGroup.getWidth() : view.getTranslationX() - viewGroup.getWidth();
        }
    }

    class c extends i {
        c() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    class d extends h {
        d() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    class e extends h {
        e() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return AbstractC12990fW7.A(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
        }
    }

    class f extends i {
        f() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    private interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class h implements g {
        private h() {
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    private static abstract class i implements g {
        private i() {
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C0 = L0;
        this.D0 = 80;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.h);
        int iG = AbstractC8958Xy7.g(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        u0(iG);
    }

    private void l0(t tVar) {
        int[] iArr = new int[2];
        tVar.b.getLocationOnScreen(iArr);
        tVar.a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void i(t tVar) {
        super.i(tVar);
        l0(tVar);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void m(t tVar) {
        super.m(tVar);
        l0(tVar);
    }

    @Override // androidx.transition.Visibility
    public Animator o0(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        if (tVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) tVar2.a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return v.a(view, tVar2, iArr[0], iArr[1], this.C0.b(viewGroup, view), this.C0.a(viewGroup, view), translationX, translationY, E0, this);
    }

    @Override // androidx.transition.Visibility
    public Animator q0(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        if (tVar == null) {
            return null;
        }
        int[] iArr = (int[]) tVar.a.get("android:slide:screenPosition");
        return v.a(view, tVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.C0.b(viewGroup, view), this.C0.a(viewGroup, view), F0, this);
    }

    public void u0(int i2) {
        if (i2 == 3) {
            this.C0 = G0;
        } else if (i2 == 5) {
            this.C0 = J0;
        } else if (i2 == 48) {
            this.C0 = I0;
        } else if (i2 == 80) {
            this.C0 = L0;
        } else if (i2 == 8388611) {
            this.C0 = H0;
        } else {
            if (i2 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.C0 = K0;
        }
        this.D0 = i2;
        KB6 kb6 = new KB6();
        kb6.j(i2);
        h0(kb6);
    }
}
