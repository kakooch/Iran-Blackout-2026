package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public abstract class Qh {
    protected final Context a;
    public final String b;
    public final String c;

    public Qh(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public final Object a() {
        int identifier = this.a.getResources().getIdentifier(this.b, this.c, this.a.getPackageName());
        if (identifier == 0) {
            return null;
        }
        try {
            return a(identifier);
        } catch (Throwable unused) {
            return null;
        }
    }

    public abstract Object a(int i);
}
