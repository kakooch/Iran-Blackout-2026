package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public final class Tl extends Qh {
    public Tl(Context context, String str) {
        super(context, str, "array");
    }

    @Override // io.appmetrica.analytics.impl.Qh
    public final Object a(int i) {
        return this.a.getResources().getStringArray(i);
    }

    public final String[] b(int i) {
        return this.a.getResources().getStringArray(i);
    }
}
