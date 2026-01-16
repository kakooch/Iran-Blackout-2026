package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.X;

/* loaded from: classes2.dex */
public final class MediaLoadData {
    public final int a;
    public final int b;
    public final X c;
    public final int d;
    public final Object e;
    public final long f;
    public final long g;

    public MediaLoadData(int i) {
        this(i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public MediaLoadData(int i, int i2, X x, int i3, Object obj, long j, long j2) {
        this.a = i;
        this.b = i2;
        this.c = x;
        this.d = i3;
        this.e = obj;
        this.f = j;
        this.g = j2;
    }
}
