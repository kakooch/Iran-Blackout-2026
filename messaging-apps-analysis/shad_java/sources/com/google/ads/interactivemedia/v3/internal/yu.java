package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class yu implements vb {
    private final int a;
    private final zc b;
    private int c = -1;

    public yu(zc zcVar, int i) {
        this.b = zcVar;
        this.a = i;
    }

    private final boolean g() {
        int i = this.c;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    public final void a() {
        ary.o(this.c == -1);
        this.c = this.b.i(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final boolean b() {
        return this.c == -3 || (g() && this.b.u(this.c));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final void c() throws IOException {
        int i = this.c;
        if (i == -2) {
            throw new zh(this.b.g().a(this.a).a(0).l);
        }
        if (i == -1) {
            this.b.z();
        } else if (i != -3) {
            this.b.y(i);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int d(cz czVar, iw iwVar, boolean z) {
        if (this.c == -3) {
            iwVar.g(4);
            return -4;
        }
        if (g()) {
            return this.b.A(this.c, czVar, iwVar, z);
        }
        return -3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int e(long j) {
        if (g()) {
            return this.b.B(this.c, j);
        }
        return 0;
    }

    public final void f() {
        if (this.c != -1) {
            this.b.j(this.a);
            this.c = -1;
        }
    }
}
