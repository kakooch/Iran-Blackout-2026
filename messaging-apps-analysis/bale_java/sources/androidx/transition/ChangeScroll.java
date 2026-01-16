package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class ChangeScroll extends Transition {
    private static final String[] A0 = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void l0(t tVar) {
        tVar.a.put("android:changeScroll:x", Integer.valueOf(tVar.b.getScrollX()));
        tVar.a.put("android:changeScroll:y", Integer.valueOf(tVar.b.getScrollY()));
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
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (tVar == null || tVar2 == null) {
            return null;
        }
        View view = tVar2.b;
        int iIntValue = ((Integer) tVar.a.get("android:changeScroll:x")).intValue();
        int iIntValue2 = ((Integer) tVar2.a.get("android:changeScroll:x")).intValue();
        int iIntValue3 = ((Integer) tVar.a.get("android:changeScroll:y")).intValue();
        int iIntValue4 = ((Integer) tVar2.a.get("android:changeScroll:y")).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return s.c(objectAnimatorOfInt, objectAnimatorOfInt2);
    }
}
