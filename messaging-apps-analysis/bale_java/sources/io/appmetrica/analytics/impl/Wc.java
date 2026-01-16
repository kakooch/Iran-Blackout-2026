package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public abstract class Wc {
    public static C2800q9 a;

    public static final synchronized C2800q9 a(Context context) {
        C2800q9 c2800q9;
        c2800q9 = a;
        if (c2800q9 == null) {
            c2800q9 = new C2800q9(context, "uuid.dat");
            a = c2800q9;
        }
        return c2800q9;
    }
}
