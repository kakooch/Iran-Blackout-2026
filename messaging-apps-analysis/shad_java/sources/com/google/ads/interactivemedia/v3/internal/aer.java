package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aer<V> {
    private long[] a = new long[10];
    private V[] b = (V[]) new Object[10];
    private int c;
    private int d;

    private final V f() {
        ary.q(this.d > 0);
        V[] vArr = this.b;
        int i = this.c;
        V v = vArr[i];
        vArr[i] = null;
        this.c = (i + 1) % vArr.length;
        this.d--;
        return v;
    }

    public final synchronized void a(long j, V v) {
        if (this.d > 0) {
            if (j <= this.a[((this.c + r0) - 1) % this.b.length]) {
                b();
            }
        }
        int length = this.b.length;
        if (this.d >= length) {
            int i = length + length;
            long[] jArr = new long[i];
            V[] vArr = (V[]) new Object[i];
            int i2 = this.c;
            int i3 = length - i2;
            System.arraycopy(this.a, i2, jArr, 0, i3);
            System.arraycopy(this.b, this.c, vArr, 0, i3);
            int i4 = this.c;
            if (i4 > 0) {
                System.arraycopy(this.a, 0, jArr, i3, i4);
                System.arraycopy(this.b, 0, vArr, i3, this.c);
            }
            this.a = jArr;
            this.b = vArr;
            this.c = 0;
        }
        int i5 = this.c;
        int i6 = this.d;
        V[] vArr2 = this.b;
        int length2 = (i5 + i6) % vArr2.length;
        this.a[length2] = j;
        vArr2[length2] = v;
        this.d = i6 + 1;
    }

    public final synchronized void b() {
        this.c = 0;
        this.d = 0;
        Arrays.fill(this.b, (Object) null);
    }

    public final synchronized int c() {
        return this.d;
    }

    public final synchronized V d() {
        if (this.d == 0) {
            return null;
        }
        return f();
    }

    public final synchronized V e(long j) {
        V vF;
        vF = null;
        while (this.d > 0 && j - this.a[this.c] >= 0) {
            vF = f();
        }
        return vF;
    }
}
