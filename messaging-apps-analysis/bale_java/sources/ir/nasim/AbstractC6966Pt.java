package ir.nasim;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: ir.nasim.Pt, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6966Pt {
    public static Interpolator a(Context context, int i) {
        return AnimationUtils.loadInterpolator(context, i);
    }
}
