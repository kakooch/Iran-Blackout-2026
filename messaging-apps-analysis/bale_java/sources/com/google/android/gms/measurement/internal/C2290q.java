package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2290q {
    final String a;
    final String b;
    final long c;
    final long d;
    final long e;
    final long f;
    final long g;
    final Long h;
    final Long i;
    final Long j;
    final Boolean k;

    C2290q(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        AbstractC3795Cj5.f(str);
        AbstractC3795Cj5.f(str2);
        AbstractC3795Cj5.a(j >= 0);
        AbstractC3795Cj5.a(j2 >= 0);
        AbstractC3795Cj5.a(j3 >= 0);
        AbstractC3795Cj5.a(j5 >= 0);
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = l;
        this.i = l2;
        this.j = l3;
        this.k = bool;
    }

    final C2290q a(Long l, Long l2, Boolean bool) {
        return new C2290q(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    final C2290q b(long j, long j2) {
        return new C2290q(this.a, this.b, this.c, this.d, this.e, this.f, j, Long.valueOf(j2), this.i, this.j, this.k);
    }

    final C2290q c(long j) {
        return new C2290q(this.a, this.b, this.c, this.d, this.e, j, this.g, this.h, this.i, this.j, this.k);
    }
}
