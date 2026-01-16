package io.appmetrica.analytics.impl;

import android.content.Context;

/* renamed from: io.appmetrica.analytics.impl.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2403a {
    public final Context a;

    public C2403a(Context context) {
        this.a = context;
    }

    public final byte[] a() {
        try {
            return AbstractC2928vi.a(new StringBuilder(this.a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return AbstractC2928vi.a(this.a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
