package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class lq {
    private final byte[] a = new byte[10];
    private boolean b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;

    public final void a() {
        this.b = false;
        this.c = 0;
    }

    public final void b(lp lpVar, long j, int i, int i2, int i3) {
        if (this.b) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i4 == 0) {
                this.d = j;
                this.e = i;
                this.f = 0;
            }
            this.f += i2;
            this.g = i3;
            if (i5 >= 16) {
                c(lpVar);
            }
        }
    }

    public final void c(lp lpVar) {
        if (this.c > 0) {
            lpVar.V.b(this.d, this.e, this.f, this.g, lpVar.i);
            this.c = 0;
        }
    }

    public final void d(jv jvVar) throws IOException {
        if (this.b) {
            return;
        }
        jvVar.g(this.a, 0, 10);
        jvVar.j();
        byte[] bArr = this.a;
        int i = gp.a;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.b = true;
        }
    }
}
