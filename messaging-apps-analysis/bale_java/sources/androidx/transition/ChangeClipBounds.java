package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC12990fW7;

/* loaded from: classes2.dex */
public class ChangeClipBounds extends Transition {
    private static final String[] A0 = {"android:clipBounds:clip"};

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC12990fW7.w0(this.a, null);
        }
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void l0(t tVar) {
        View view = tVar.b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rectT = AbstractC12990fW7.t(view);
        tVar.a.put("android:clipBounds:clip", rectT);
        if (rectT == null) {
            tVar.a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public String[] G() {
        return A0;
    }

    @Override // androidx.transition.Transition
    public void i(t tVar) {
        l0(tVar);
    }

    @Override // androidx.transition.Transition
    public void m(t tVar) {
        l0(tVar);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, t tVar, t tVar2) {
        ObjectAnimator objectAnimatorOfObject = null;
        if (tVar != null && tVar2 != null && tVar.a.containsKey("android:clipBounds:clip") && tVar2.a.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) tVar.a.get("android:clipBounds:clip");
            Rect rect2 = (Rect) tVar2.a.get("android:clipBounds:clip");
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) tVar.a.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = (Rect) tVar2.a.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            AbstractC12990fW7.w0(tVar2.b, rect);
            objectAnimatorOfObject = ObjectAnimator.ofObject(tVar2.b, (Property<View, V>) B.c, new n(new Rect()), rect, rect2);
            if (z) {
                objectAnimatorOfObject.addListener(new a(tVar2.b));
            }
        }
        return objectAnimatorOfObject;
    }
}
