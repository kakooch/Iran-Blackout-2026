package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zt extends zu {
    public final int a;
    public final long b;
    public final long c;
    public final boolean d;
    public final int e;
    public final long f;
    public final int g;
    public final long h;
    public final long i;
    public final boolean j;
    public final boolean k;
    public final jc l;
    public final List<zs> m;
    public final long n;
    public final ary o;

    public zt(int i, String str, List list, long j, long j2, boolean z, int i2, long j3, int i3, long j4, long j5, boolean z2, boolean z3, boolean z4, jc jcVar, List list2, ary aryVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        long j6;
        super(str, list, z2);
        this.a = i;
        this.c = j2;
        this.d = z;
        this.e = i2;
        this.f = j3;
        this.g = i3;
        this.h = j4;
        this.i = j5;
        this.j = z3;
        this.k = z4;
        this.l = jcVar;
        this.m = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            this.n = 0L;
            j6 = 0;
        } else {
            zs zsVar = (zs) list2.get(list2.size() - 1);
            j6 = zsVar.e + zsVar.c;
            this.n = j6;
        }
        this.b = j != -9223372036854775807L ? j >= 0 ? j : j6 + j : -9223372036854775807L;
        this.o = aryVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.so
    public final /* bridge */ /* synthetic */ zu a(List list) {
        return this;
    }

    public final long b() {
        return this.c + this.n;
    }
}
