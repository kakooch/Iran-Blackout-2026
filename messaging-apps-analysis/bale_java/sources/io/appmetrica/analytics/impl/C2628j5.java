package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;

/* renamed from: io.appmetrica.analytics.impl.j5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2628j5 {
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C2628j5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final Aa a(W4 w4, A4 a4, I7 i7, HashMap map) {
        Aa aa = (Aa) map.get(w4.toString());
        if (aa != null) {
            aa.a(a4);
            return aa;
        }
        Aa aaA = i7.a(this.c, w4, a4);
        map.put(w4.toString(), aaA);
        return aaA;
    }
}
