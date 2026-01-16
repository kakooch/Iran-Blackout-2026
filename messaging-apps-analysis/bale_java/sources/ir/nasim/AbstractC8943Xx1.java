package ir.nasim;

import android.content.res.Resources;

/* renamed from: ir.nasim.Xx1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC8943Xx1 {
    public static final int a(double d) {
        return (int) ((d * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int b(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int c(int i) {
        return (int) ((i * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
