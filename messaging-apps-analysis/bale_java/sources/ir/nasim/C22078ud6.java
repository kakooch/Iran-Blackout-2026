package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.ud6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22078ud6 {
    private static Context b;
    public static float c;
    private static float d;
    public static final C22078ud6 a = new C22078ud6();
    public static final int e = 8;

    private C22078ud6() {
    }

    public static final int a(float f) {
        if (c == 0.0f) {
            Context context = b;
            if (context == null) {
                AbstractC13042fc3.y("applicationContext");
                context = null;
            }
            c = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((f * c) + 0.5f);
    }

    public static final int b() {
        Context context = b;
        if (context == null) {
            AbstractC13042fc3.y("applicationContext");
            context = null;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static final int c() {
        Context context = b;
        if (context == null) {
            AbstractC13042fc3.y("applicationContext");
            context = null;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static final int e(float f) {
        if (d == 0.0f) {
            Context context = b;
            if (context == null) {
                AbstractC13042fc3.y("applicationContext");
                context = null;
            }
            d = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return (int) ((f * d) + 0.5f);
    }

    public final void d(Context context) {
        AbstractC13042fc3.i(context, "applicationContext");
        b = context;
    }
}
