package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
public abstract class W {
    int a;
    private int b;
    private boolean c;

    private W() {
        this.a = 100;
        this.b = Integer.MAX_VALUE;
        this.c = false;
    }

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static W b(byte[] bArr, int i, int i2, boolean z) {
        X x = new X(bArr, i2);
        try {
            x.c(i2);
            return x;
        } catch (zzjk e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int d(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int c(int i);

    public abstract int e();
}
