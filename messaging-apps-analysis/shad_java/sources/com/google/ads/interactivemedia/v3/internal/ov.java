package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ov {
    public byte[] a;
    public int b;
    private final int c;
    private boolean d;
    private boolean e;

    public ov(int i) {
        this.c = i;
        byte[] bArr = new byte[131];
        this.a = bArr;
        bArr[2] = 1;
    }

    public final void a() {
        this.d = false;
        this.e = false;
    }

    public final boolean b() {
        return this.e;
    }

    public final void c(int i) {
        ary.q(!this.d);
        boolean z = i == this.c;
        this.d = z;
        if (z) {
            this.b = 3;
            this.e = false;
        }
    }

    public final void d(byte[] bArr, int i, int i2) {
        if (this.d) {
            int i3 = i2 - i;
            byte[] bArr2 = this.a;
            int length = bArr2.length;
            int i4 = this.b + i3;
            if (length < i4) {
                this.a = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.a, this.b, i3);
            this.b += i3;
        }
    }

    public final boolean e(int i) {
        if (!this.d) {
            return false;
        }
        this.b -= i;
        this.d = false;
        this.e = true;
        return true;
    }
}
