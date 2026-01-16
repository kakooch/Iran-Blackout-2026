package io.appmetrica.analytics.impl;

import android.content.Context;

/* renamed from: io.appmetrica.analytics.impl.n3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2722n3 extends Qh {
    public C2722n3(Context context, String str) {
        super(context, str, "bool");
    }

    @Override // io.appmetrica.analytics.impl.Qh
    public final Object a(int i) {
        return Boolean.valueOf(this.a.getResources().getBoolean(i));
    }

    public final Boolean b(int i) {
        return Boolean.valueOf(this.a.getResources().getBoolean(i));
    }
}
