package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zs implements Comparable<Long> {
    public final String a;
    public final zs b;
    public final long c;
    public final int d;
    public final long e;
    public final jc f;
    public final String g;
    public final String h;
    public final long i;
    public final long j;
    public final boolean k;

    public zs(String str, long j, long j2, String str2, String str3) {
        this(str, null, 0L, -1, -9223372036854775807L, null, str2, str3, j, j2, false);
    }

    public zs(String str, zs zsVar, long j, int i, long j2, jc jcVar, String str2, String str3, long j3, long j4, boolean z) {
        this.a = str;
        this.b = zsVar;
        this.c = j;
        this.d = i;
        this.e = j2;
        this.f = jcVar;
        this.g = str2;
        this.h = str3;
        this.i = j3;
        this.j = j4;
        this.k = z;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Long l) {
        Long l2 = l;
        if (this.e > l2.longValue()) {
            return 1;
        }
        return this.e >= l2.longValue() ? 0 : -1;
    }
}
