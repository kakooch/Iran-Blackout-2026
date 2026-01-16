package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC8958Xy7;

/* loaded from: classes2.dex */
public class Fade extends Visibility {

    class a extends q {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            B.h(this.a, 1.0f);
            B.a(this.a);
            transition.W(this);
        }
    }

    private static class b extends AnimatorListenerAdapter {
        private final View a;
        private boolean b = false;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            B.h(this.a, 1.0f);
            if (this.b) {
                this.a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (AbstractC12990fW7.P(this.a) && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i) {
        t0(i);
    }

    private Animator u0(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        B.h(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) B.b, f2);
        objectAnimatorOfFloat.addListener(new b(view));
        b(new a(view));
        return objectAnimatorOfFloat;
    }

    private static float v0(t tVar, float f) {
        Float f2;
        return (tVar == null || (f2 = (Float) tVar.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void m(t tVar) {
        super.m(tVar);
        tVar.a.put("android:fade:transitionAlpha", Float.valueOf(B.c(tVar.b)));
    }

    @Override // androidx.transition.Visibility
    public Animator o0(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        float fV0 = v0(tVar, 0.0f);
        return u0(view, fV0 != 1.0f ? fV0 : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator q0(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        B.e(view);
        return u0(view, v0(tVar, 1.0f), 0.0f);
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f);
        t0(AbstractC8958Xy7.g(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, m0()));
        typedArrayObtainStyledAttributes.recycle();
    }
}
