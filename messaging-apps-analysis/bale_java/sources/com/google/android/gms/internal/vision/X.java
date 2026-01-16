package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
final class X extends W {
    private final byte[] d;
    private final boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    private X(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.j = Integer.MAX_VALUE;
        this.d = bArr;
        this.f = i2 + i;
        this.h = i;
        this.i = i;
        this.e = z;
    }

    private final void f() {
        int i = this.f + this.g;
        this.f = i;
        int i2 = i - this.i;
        int i3 = this.j;
        if (i2 <= i3) {
            this.g = 0;
            return;
        }
        int i4 = i2 - i3;
        this.g = i4;
        this.f = i - i4;
    }

    @Override // com.google.android.gms.internal.vision.W
    public final int c(int i) throws zzjk {
        if (i < 0) {
            throw zzjk.b();
        }
        int iE = i + e();
        int i2 = this.j;
        if (iE > i2) {
            throw zzjk.a();
        }
        this.j = iE;
        f();
        return i2;
    }

    @Override // com.google.android.gms.internal.vision.W
    public final int e() {
        return this.h - this.i;
    }
}
