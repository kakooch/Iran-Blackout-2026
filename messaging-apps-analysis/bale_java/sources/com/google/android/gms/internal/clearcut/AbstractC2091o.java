package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2091o {
    private int a;
    private int b;
    private boolean c;

    private AbstractC2091o() {
        this.a = 100;
        this.b = Integer.MAX_VALUE;
        this.c = false;
    }

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static AbstractC2091o b(byte[] bArr, int i, int i2, boolean z) {
        C2093q c2093q = new C2093q(bArr, 0, i2, false);
        try {
            c2093q.d(i2);
            return c2093q;
        } catch (zzco e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int e(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int c();

    public abstract int d(int i);
}
