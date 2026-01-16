package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ol {
    private final kr a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private long g;
    private long h;

    public ol(kr krVar) {
        this.a = krVar;
    }

    public final void a() {
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = -1;
    }

    public final void b(int i, long j) {
        boolean z;
        this.e = i;
        this.d = false;
        if (i == 182) {
            z = true;
        } else if (i == 179) {
            i = 179;
            z = true;
        } else {
            z = false;
        }
        this.b = z;
        this.c = i == 182;
        this.f = 0;
        this.h = j;
    }

    public final void c(byte[] bArr, int i, int i2) {
        if (this.c) {
            int i3 = this.f;
            int i4 = (i + 1) - i3;
            if (i4 >= i2) {
                this.f = i3 + (i2 - i);
            } else {
                this.d = ((bArr[i4] & 192) >> 6) == 0;
                this.c = false;
            }
        }
    }

    public final void d(long j, int i, boolean z) {
        if (this.e == 182 && z && this.b) {
            long j2 = this.g;
            this.a.b(this.h, this.d ? 1 : 0, (int) (j - j2), i, null);
        }
        if (this.e != 179) {
            this.g = j;
        }
    }
}
