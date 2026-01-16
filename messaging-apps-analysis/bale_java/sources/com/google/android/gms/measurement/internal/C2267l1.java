package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.l1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2267l1 {
    private final String a;
    private final boolean b;
    private boolean c;
    private boolean d;
    final /* synthetic */ C2292q1 e;

    public C2267l1(C2292q1 c2292q1, String str, boolean z) {
        this.e = c2292q1;
        AbstractC3795Cj5.f(str);
        this.a = str;
        this.b = z;
    }

    public final void a(boolean z) {
        SharedPreferences.Editor editorEdit = this.e.o().edit();
        editorEdit.putBoolean(this.a, z);
        editorEdit.apply();
        this.d = z;
    }

    public final boolean b() {
        if (!this.c) {
            this.c = true;
            this.d = this.e.o().getBoolean(this.a, this.b);
        }
        return this.d;
    }
}
