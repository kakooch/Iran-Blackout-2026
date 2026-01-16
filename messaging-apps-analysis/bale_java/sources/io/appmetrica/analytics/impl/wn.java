package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public final class wn {
    public final Context a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final sn c;
    public final sn d;

    public wn(Context context) {
        this.a = context;
        V9 v9 = new V9(context, "appmetrica_vital.dat");
        this.c = new sn(C2586ha.h().w(), v9);
        this.d = new sn(new C2733ne(W6.a(context).d()), v9);
    }

    public final sn a() {
        return this.c;
    }

    public final sn b() {
        return this.d;
    }
}
