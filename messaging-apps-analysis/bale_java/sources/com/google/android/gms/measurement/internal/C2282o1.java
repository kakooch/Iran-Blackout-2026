package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import ir.nasim.AbstractC17930nn8;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.o1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2282o1 {
    final String a;
    private final String b;
    private final String c;
    private final long d;
    final /* synthetic */ C2292q1 e;

    /* synthetic */ C2282o1(C2292q1 c2292q1, String str, long j, AbstractC17930nn8 abstractC17930nn8) {
        this.e = c2292q1;
        AbstractC3795Cj5.f("health_monitor");
        AbstractC3795Cj5.a(j > 0);
        this.a = "health_monitor:start";
        this.b = "health_monitor:count";
        this.c = "health_monitor:value";
        this.d = j;
    }

    private final long c() {
        return this.e.o().getLong(this.a, 0L);
    }

    private final void d() {
        this.e.h();
        long jCurrentTimeMillis = this.e.a.c().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.e.o().edit();
        editorEdit.remove(this.b);
        editorEdit.remove(this.c);
        editorEdit.putLong(this.a, jCurrentTimeMillis);
        editorEdit.apply();
    }

    public final Pair a() {
        long jAbs;
        this.e.h();
        this.e.h();
        long jC = c();
        if (jC == 0) {
            d();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jC - this.e.a.c().currentTimeMillis());
        }
        long j = this.d;
        if (jAbs < j) {
            return null;
        }
        if (jAbs > j + j) {
            d();
            return null;
        }
        String string = this.e.o().getString(this.c, null);
        long j2 = this.e.o().getLong(this.b, 0L);
        d();
        return (string == null || j2 <= 0) ? C2292q1.y : new Pair(string, Long.valueOf(j2));
    }

    public final void b(String str, long j) {
        this.e.h();
        if (c() == 0) {
            d();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.e.o().getLong(this.b, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor editorEdit = this.e.o().edit();
            editorEdit.putString(this.c, str);
            editorEdit.putLong(this.b, 1L);
            editorEdit.apply();
            return;
        }
        long jNextLong = this.e.a.N().u().nextLong();
        long j3 = j2 + 1;
        long j4 = Long.MAX_VALUE / j3;
        SharedPreferences.Editor editorEdit2 = this.e.o().edit();
        if ((Long.MAX_VALUE & jNextLong) < j4) {
            editorEdit2.putString(this.c, str);
        }
        editorEdit2.putLong(this.b, j3);
        editorEdit2.apply();
    }
}
