package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class oq {
    private final kr a;
    private long b;
    private boolean c;
    private int d;
    private long e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private boolean m;

    public oq(kr krVar) {
        this.a = krVar;
    }

    private final void e(int i) {
        boolean z = this.m;
        long j = this.b;
        long j2 = this.k;
        this.a.b(this.l, z ? 1 : 0, (int) (j - j2), i, null);
    }

    public final void a() {
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
    }

    public final void b(long j, int i, int i2, long j2, boolean z) {
        this.g = false;
        this.h = false;
        this.e = j2;
        this.d = 0;
        this.b = j;
        if (i2 >= 32 && i2 != 40) {
            if (this.i && !this.j) {
                if (z) {
                    e(i);
                }
                this.i = false;
            }
            if (i2 <= 35 || i2 == 39) {
                this.h = !this.j;
                this.j = true;
            }
        }
        boolean z2 = i2 >= 16 && i2 <= 21;
        this.c = z2;
        this.f = z2 || i2 <= 9;
    }

    public final void c(byte[] bArr, int i, int i2) {
        if (this.f) {
            int i3 = this.d;
            int i4 = (i + 2) - i3;
            if (i4 >= i2) {
                this.d = i3 + (i2 - i);
            } else {
                this.g = (bArr[i4] & 128) != 0;
                this.f = false;
            }
        }
    }

    public final void d(long j, int i, boolean z) {
        if (this.j && this.g) {
            this.m = this.c;
            this.j = false;
        } else if (this.h || this.g) {
            if (z && this.i) {
                e(i + ((int) (j - this.b)));
            }
            this.k = this.b;
            this.l = this.e;
            this.m = this.c;
            this.i = true;
        }
    }
}
