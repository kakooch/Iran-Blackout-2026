package com.google.android.exoplayer2;

/* loaded from: classes2.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final J0 a;
    public final int b;
    public final long c;

    public IllegalSeekPositionException(J0 j0, int i, long j) {
        this.a = j0;
        this.b = i;
        this.c = j;
    }
}
