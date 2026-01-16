package ir.nasim;

import android.animation.TimeInterpolator;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionSet;

/* renamed from: ir.nasim.Bv7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3671Bv7 {
    public static Transition a() {
        TransitionSet transitionSet = new TransitionSet();
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(150L);
        transitionSet.addTransition(new Fade().setDuration(150L)).addTransition(changeBounds);
        transitionSet.setOrdering(0);
        transitionSet.setInterpolator((TimeInterpolator) InterpolatorC12631ew1.f);
        return transitionSet;
    }
}
