package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class pb {
    private final oh a;
    private final aes b;
    private final aed c = new aed(new byte[64]);
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private long h;

    public pb(oh ohVar, aes aesVar) {
        this.a = ohVar;
        this.b = aesVar;
    }

    public final void a() {
        this.f = false;
        this.a.a();
    }

    public final void b(aee aeeVar) throws dt {
        aeeVar.m(this.c.a, 0, 3);
        this.c.e(0);
        this.c.g(8);
        this.d = this.c.h();
        this.e = this.c.h();
        this.c.g(6);
        int i = this.c.i(8);
        this.g = i;
        aeeVar.m(this.c.a, 0, i);
        this.c.e(0);
        long jF = 0;
        this.h = 0L;
        if (this.d) {
            this.c.g(4);
            int i2 = this.c.i(3);
            this.c.g(1);
            int i3 = this.c.i(15);
            this.c.g(1);
            long jI = (i2 << 30) | (i3 << 15) | this.c.i(15);
            this.c.g(1);
            if (!this.f && this.e) {
                this.c.g(4);
                int i4 = this.c.i(3);
                this.c.g(1);
                int i5 = this.c.i(15);
                this.c.g(1);
                int i6 = this.c.i(15);
                this.c.g(1);
                this.b.f((i4 << 30) | (i5 << 15) | i6);
                this.f = true;
            }
            jF = this.b.f(jI);
            this.h = jF;
        }
        this.a.c(jF, 4);
        this.a.d(aeeVar);
        this.a.e();
    }
}
