package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.n1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2277n1 {
    private final String a;
    private final long b;
    private boolean c;
    private long d;
    final /* synthetic */ C2292q1 e;

    public C2277n1(C2292q1 c2292q1, String str, long j) {
        this.e = c2292q1;
        AbstractC3795Cj5.f(str);
        this.a = str;
        this.b = j;
    }

    public final long a() {
        if (!this.c) {
            this.c = true;
            this.d = this.e.o().getLong(this.a, this.b);
        }
        return this.d;
    }

    public final void b(long j) {
        SharedPreferences.Editor editorEdit = this.e.o().edit();
        editorEdit.putLong(this.a, j);
        editorEdit.apply();
        this.d = j;
    }
}
