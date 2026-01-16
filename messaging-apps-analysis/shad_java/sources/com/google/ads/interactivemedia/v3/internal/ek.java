package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.view.View;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final /* synthetic */ class ek {
    public static bj a(float f, float f2, long j, float f3) {
        return new bj(0.97f, 1.03f, 500L, 5.0E-8f);
    }

    public static float b(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static String c(View view) {
        if (Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) {
            return "notAttached";
        }
        int visibility = view.getVisibility();
        if (visibility != 0) {
            return visibility != 4 ? visibility != 8 ? "viewNotVisible" : "viewGone" : "viewInvisible";
        }
        if (view.getAlpha() == 0.0f) {
            return "viewAlphaZero";
        }
        return null;
    }
}
