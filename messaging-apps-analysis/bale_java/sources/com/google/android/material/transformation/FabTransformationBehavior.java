package com.google.android.material.transformation;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC22590vV3;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9394Zt;
import ir.nasim.C15532jk4;
import ir.nasim.C16123kk4;
import ir.nasim.C20433s02;
import ir.nasim.C23074wJ;
import ir.nasim.C9067Yi5;
import ir.nasim.GS0;
import ir.nasim.WB5;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private final Rect c;
    private final RectF d;
    private final RectF e;
    private final int[] f;
    private float g;
    private float h;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        a(boolean z, View view, View view2) {
            this.a = z;
            this.b = view;
            this.c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.b.setVisibility(4);
            this.c.setAlpha(1.0f);
            this.c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.b.setVisibility(0);
                this.c.setAlpha(0.0f);
                this.c.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.c a;
        final /* synthetic */ Drawable b;

        c(com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.a = cVar;
            this.b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(this.b);
        }
    }

    class d extends AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.c a;

        d(com.google.android.material.circularreveal.c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e revealInfo = this.a.getRevealInfo();
            revealInfo.c = Float.MAX_VALUE;
            this.a.setRevealInfo(revealInfo);
        }
    }

    protected static class e {
        public C15532jk4 a;
        public C9067Yi5 b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    private ViewGroup K(View view) {
        View viewFindViewById = view.findViewById(WB5.mtrl_child_content_container);
        return viewFindViewById != null ? f0(viewFindViewById) : ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? f0(((ViewGroup) view).getChildAt(0)) : f0(view);
    }

    private void L(View view, e eVar, C16123kk4 c16123kk4, C16123kk4 c16123kk42, float f, float f2, float f3, float f4, RectF rectF) {
        float fS = S(eVar, c16123kk4, f, f3);
        float fS2 = S(eVar, c16123kk42, f2, f4);
        Rect rect = this.c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.d;
        rectF2.set(rect);
        RectF rectF3 = this.e;
        T(view, rectF3);
        rectF3.offset(fS, fS2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(View view, RectF rectF) {
        T(view, rectF);
        rectF.offset(this.g, this.h);
    }

    private Pair N(float f, float f2, boolean z, e eVar) {
        C16123kk4 c16123kk4H;
        C16123kk4 c16123kk4H2;
        if (f == 0.0f || f2 == 0.0f) {
            c16123kk4H = eVar.a.h("translationXLinear");
            c16123kk4H2 = eVar.a.h("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            c16123kk4H = eVar.a.h("translationXCurveDownwards");
            c16123kk4H2 = eVar.a.h("translationYCurveDownwards");
        } else {
            c16123kk4H = eVar.a.h("translationXCurveUpwards");
            c16123kk4H2 = eVar.a.h("translationYCurveUpwards");
        }
        return new Pair(c16123kk4H, c16123kk4H2);
    }

    private float O(View view, View view2, C9067Yi5 c9067Yi5) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, c9067Yi5), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float P(View view, View view2, C9067Yi5 c9067Yi5) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, c9067Yi5));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(View view, View view2, C9067Yi5 c9067Yi5) {
        float fCenterX;
        float fCenterX2;
        float f;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        M(view, rectF);
        T(view2, rectF2);
        int i = c9067Yi5.a & 7;
        if (i == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i != 5) {
                f = 0.0f;
                return f + c9067Yi5.b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f = fCenterX - fCenterX2;
        return f + c9067Yi5.b;
    }

    private float R(View view, View view2, C9067Yi5 c9067Yi5) {
        float fCenterY;
        float fCenterY2;
        float f;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        M(view, rectF);
        T(view2, rectF2);
        int i = c9067Yi5.a & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        if (i == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i != 80) {
                f = 0.0f;
                return f + c9067Yi5.c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f = fCenterY - fCenterY2;
        return f + c9067Yi5.c;
    }

    private float S(e eVar, C16123kk4 c16123kk4, float f, float f2) {
        long jC = c16123kk4.c();
        long jD = c16123kk4.d();
        C16123kk4 c16123kk4H = eVar.a.h("expansion");
        return AbstractC6732Ot.a(f, f2, c16123kk4.e().getInterpolation((((c16123kk4H.c() + c16123kk4H.d()) + 17) - jC) / jD));
    }

    private void T(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void U(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2) {
        ViewGroup viewGroupK;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.c) && com.google.android.material.circularreveal.b.j == 0) || (viewGroupK = K(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    GS0.a.set(viewGroupK, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, (Property<ViewGroup, Float>) GS0.a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, (Property<ViewGroup, Float>) GS0.a, 0.0f);
            }
            eVar.a.h("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            int iD0 = d0(view);
            int i = 16777215 & iD0;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(iD0);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, (Property<com.google.android.material.circularreveal.c, Integer>) c.d.a, i);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, (Property<com.google.android.material.circularreveal.c, Integer>) c.d.a, iD0);
            }
            objectAnimatorOfInt.setEvaluator(C23074wJ.b());
            eVar.a.h("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private void W(View view, View view2, boolean z, e eVar, List list) {
        float fQ = Q(view, view2, eVar.b);
        float fR = R(view, view2, eVar.b);
        Pair pairN = N(fQ, fR, z, eVar);
        C16123kk4 c16123kk4 = (C16123kk4) pairN.first;
        C16123kk4 c16123kk42 = (C16123kk4) pairN.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            fQ = this.g;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fQ);
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            fR = this.h;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fR);
        c16123kk4.a(objectAnimatorOfFloat);
        c16123kk42.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private void X(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fV = AbstractC12990fW7.v(view2) - AbstractC12990fW7.v(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-fV);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fV);
        }
        eVar.a.h("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y(View view, View view2, boolean z, boolean z2, e eVar, float f, float f2, List list, List list2) {
        Animator animatorA;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            float fO = O(view, view2, eVar.b);
            float fP = P(view, view2, eVar.b);
            ((FloatingActionButton) view).i(this.c);
            float fWidth = this.c.width() / 2.0f;
            C16123kk4 c16123kk4H = eVar.a.h("expansion");
            if (z) {
                if (!z2) {
                    cVar.setRevealInfo(new c.e(fO, fP, fWidth));
                }
                if (z2) {
                    fWidth = cVar.getRevealInfo().c;
                }
                animatorA = com.google.android.material.circularreveal.a.a(cVar, fO, fP, AbstractC22590vV3.b(fO, fP, 0.0f, 0.0f, f, f2));
                animatorA.addListener(new d(cVar));
                b0(view2, c16123kk4H.c(), (int) fO, (int) fP, fWidth, list);
            } else {
                float f3 = cVar.getRevealInfo().c;
                Animator animatorA2 = com.google.android.material.circularreveal.a.a(cVar, fO, fP, fWidth);
                int i = (int) fO;
                int i2 = (int) fP;
                b0(view2, c16123kk4H.c(), i, i2, f3, list);
                a0(view2, c16123kk4H.c(), c16123kk4H.d(), eVar.a.i(), i, i2, fWidth, list);
                animatorA = animatorA2;
            }
            c16123kk4H.a(animatorA);
            list.add(animatorA);
            list2.add(com.google.android.material.circularreveal.a.b(cVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) C20433s02.b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) C20433s02.b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.a.h("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(cVar, drawable));
        }
    }

    private void a0(View view, long j, long j2, long j3, int i, int i2, float f, List list) {
        long j4 = j + j2;
        if (j4 < j3) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            animatorCreateCircularReveal.setStartDelay(j4);
            animatorCreateCircularReveal.setDuration(j3 - j4);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void b0(View view, long j, int i, int i2, float f, List list) {
        if (j > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void c0(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2, RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fQ = Q(view, view2, eVar.b);
        float fR = R(view, view2, eVar.b);
        Pair pairN = N(fQ, fR, z, eVar);
        C16123kk4 c16123kk4 = (C16123kk4) pairN.first;
        C16123kk4 c16123kk42 = (C16123kk4) pairN.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fQ);
                view2.setTranslationY(-fR);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, c16123kk4, c16123kk42, -fQ, -fR, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fQ);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fR);
        }
        c16123kk4.a(objectAnimatorOfFloat);
        c16123kk42.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private int d0(View view) {
        ColorStateList colorStateListR = AbstractC12990fW7.r(view);
        if (colorStateListR != null) {
            return colorStateListR.getColorForState(view.getDrawableState(), colorStateListR.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet J(View view, View view2, boolean z, boolean z2) {
        e eVarE0 = e0(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        X(view, view2, z, z2, eVarE0, arrayList, arrayList2);
        RectF rectF = this.d;
        c0(view, view2, z, z2, eVarE0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        W(view, view2, z, eVarE0, arrayList);
        Z(view, view2, z, z2, eVarE0, arrayList, arrayList2);
        Y(view, view2, z, z2, eVarE0, fWidth, fHeight, arrayList, arrayList2);
        V(view, view2, z, z2, eVarE0, arrayList, arrayList2);
        U(view, view2, z, z2, eVarE0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        AbstractC9394Zt.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    protected abstract e e0(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void g(CoordinatorLayout.e eVar) {
        if (eVar.h == 0) {
            eVar.h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }
}
