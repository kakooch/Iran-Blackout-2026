package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jq {
    public static final jq a = new jq(-3, -9223372036854775807L, -1);
    private final int b;
    private final long c;
    private final long d;

    private jq(int i, long j, long j2) {
        this.b = i;
        this.c = j;
        this.d = j2;
    }

    public static jq a(long j, long j2) {
        return new jq(-1, j, j2);
    }

    public static jq b(long j, long j2) {
        return new jq(-2, j, j2);
    }

    public static jq c(long j) {
        return new jq(0, -9223372036854775807L, j);
    }
}
