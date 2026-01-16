package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.e1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2232e1 {
    public final String a;
    public final String b;
    public final long c;
    public final Bundle d;

    public C2232e1(String str, String str2, Bundle bundle, long j) {
        this.a = str;
        this.b = str2;
        this.d = bundle;
        this.c = j;
    }

    public static C2232e1 b(zzaw zzawVar) {
        return new C2232e1(zzawVar.a, zzawVar.c, zzawVar.b.d0(), zzawVar.d);
    }

    public final zzaw a() {
        return new zzaw(this.a, new zzau(new Bundle(this.d)), this.b, this.c);
    }

    public final String toString() {
        return "origin=" + this.b + ",name=" + this.a + ",params=" + this.d.toString();
    }
}
