package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class Z22 {
    public static final Z22 a = new Z22();

    private Z22() {
    }

    public final float a(EdgeEffect edgeEffect, float f, float f2, WH1 wh1) {
        if (AbstractC9491a32.b(wh1, f) > c(edgeEffect) * f2) {
            return 0.0f;
        }
        d(edgeEffect, AbstractC20723sV3.d(f));
        return f;
    }

    public final EdgeEffect b(Context context) {
        return Build.VERSION.SDK_INT >= 31 ? C20383rv.a.a(context, null) : new C24257yJ2(context);
    }

    public final float c(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C20383rv.a.b(edgeEffect);
        }
        return 0.0f;
    }

    public final void d(EdgeEffect edgeEffect, int i) {
        if (Build.VERSION.SDK_INT >= 31) {
            edgeEffect.onAbsorb(i);
        } else if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(i);
        }
    }

    public final float e(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C20383rv.a.c(edgeEffect, f, f2);
        }
        edgeEffect.onPull(f, f2);
        return f;
    }

    public final void f(EdgeEffect edgeEffect, float f) {
        if (edgeEffect instanceof C24257yJ2) {
            ((C24257yJ2) edgeEffect).a(f);
        } else {
            edgeEffect.onRelease();
        }
    }
}
