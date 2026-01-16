package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public final class Vl extends Qh {
    public Vl(Context context, String str) {
        super(context, str, "string");
    }

    @Override // io.appmetrica.analytics.impl.Qh
    public final Object a(int i) {
        return this.a.getString(i);
    }

    public final String b(int i) {
        return this.a.getString(i);
    }
}
