package ir.nasim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import ir.nasim.animation.view.transition.sharedelement.Corners;
import java.util.Map;

/* renamed from: ir.nasim.rI0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19994rI0 extends Transition {
    private static final a a = new a(null);

    /* renamed from: ir.nasim.rI0$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final void c(TransitionValues transitionValues) {
        if (transitionValues == null || transitionValues.view.getTransitionName() == null) {
            return;
        }
        ViewOutlineProvider outlineProvider = transitionValues.view.getOutlineProvider();
        C21356tW7 c21356tW7 = outlineProvider instanceof C21356tW7 ? (C21356tW7) outlineProvider : null;
        Corners cornersA = c21356tW7 != null ? c21356tW7.a() : null;
        Map map = transitionValues.values;
        AbstractC13042fc3.h(map, "values");
        if (cornersA == null) {
            cornersA = new Corners(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }
        map.put("corner", cornersA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C21356tW7 c21356tW7, Corners corners, Corners corners2, View view, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(c21356tW7, "$cornerOutlineProvider");
        AbstractC13042fc3.i(corners, "$endCorners");
        AbstractC13042fc3.i(corners2, "$startCorners");
        AbstractC13042fc3.i(view, "$view");
        AbstractC13042fc3.i(valueAnimator, "value");
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        Corners cornersA = c21356tW7.a();
        float topLeft = (corners.getTopLeft() - corners2.getTopLeft()) * fFloatValue;
        cornersA.g((corners.getTopRight() - corners2.getTopRight()) * fFloatValue, topLeft, (corners.getBottomRight() - corners2.getBottomRight()) * fFloatValue, (corners.getBottomLeft() - corners2.getBottomLeft()) * fFloatValue);
        view.invalidateOutline();
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        c(transitionValues);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        c(transitionValues);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Map map;
        Map map2;
        AbstractC13042fc3.i(viewGroup, "sceneRoot");
        Object obj = (transitionValues == null || (map2 = transitionValues.values) == null) ? null : map2.get("corner");
        final Corners corners = obj instanceof Corners ? (Corners) obj : null;
        if (corners == null) {
            return null;
        }
        Object obj2 = (transitionValues2 == null || (map = transitionValues2.values) == null) ? null : map.get("corner");
        final Corners corners2 = obj2 instanceof Corners ? (Corners) obj2 : null;
        if (corners2 == null || AbstractC13042fc3.d(corners, corners2)) {
            return null;
        }
        final C21356tW7 c21356tW7 = new C21356tW7(null, 1, null);
        final View view = transitionValues.view;
        view.setOutlineProvider(c21356tW7);
        view.setClipToOutline(true);
        AbstractC13042fc3.h(view, "apply(...)");
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.qI0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C19994rI0.d(c21356tW7, corners2, corners, view, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }
}
