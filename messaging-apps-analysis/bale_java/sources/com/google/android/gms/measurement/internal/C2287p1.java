package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.p1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2287p1 {
    private final String a;
    private boolean b;
    private String c;
    final /* synthetic */ C2292q1 d;

    public C2287p1(C2292q1 c2292q1, String str, String str2) {
        this.d = c2292q1;
        AbstractC3795Cj5.f(str);
        this.a = str;
    }

    public final String a() {
        if (!this.b) {
            this.b = true;
            this.c = this.d.o().getString(this.a, null);
        }
        return this.c;
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.d.o().edit();
        editorEdit.putString(this.a, str);
        editorEdit.apply();
        this.c = str;
    }
}
