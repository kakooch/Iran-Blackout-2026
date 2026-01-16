package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class qc extends iw {
    private final iw f;
    private boolean g;
    private long h;
    private int i;
    private int j;

    public qc() {
        super(2);
        this.f = new iw(2);
        a();
    }

    private final void v(iw iwVar) {
        ByteBuffer byteBuffer = iwVar.b;
        if (byteBuffer != null) {
            iwVar.l();
            i(byteBuffer.remaining());
            this.b.put(byteBuffer);
        }
        if (iwVar.c()) {
            f(4);
        }
        if (iwVar.b()) {
            f(Integer.MIN_VALUE);
        }
        if (iwVar.d()) {
            f(1);
        }
        int i = this.i + 1;
        this.i = i;
        long j = iwVar.d;
        this.d = j;
        if (i == 1) {
            this.h = j;
        }
        iwVar.a();
    }

    private final void w() {
        super.a();
        this.i = 0;
        this.h = -9223372036854775807L;
        this.d = -9223372036854775807L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.iw, com.google.ads.interactivemedia.v3.internal.ir
    public final void a() {
        n();
        this.j = 32;
    }

    public final void m(int i) {
        ary.o(true);
        this.j = i;
    }

    public final void n() {
        w();
        this.f.a();
        this.g = false;
    }

    public final void o() {
        w();
        if (this.g) {
            v(this.f);
            this.g = false;
        }
    }

    public final iw p() {
        return this.f;
    }

    public final long q() {
        return this.h;
    }

    public final int r() {
        return this.i;
    }

    public final boolean s() {
        return this.i == 0;
    }

    public final boolean t() {
        if (this.i >= this.j) {
            return true;
        }
        ByteBuffer byteBuffer = this.b;
        return (byteBuffer != null && byteBuffer.position() >= 3072000) || this.g;
    }

    public final void u() {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        iw iwVar = this.f;
        boolean z = false;
        ary.q((t() || c()) ? false : true);
        if (!iwVar.k() && !iwVar.e()) {
            z = true;
        }
        ary.o(z);
        if (s() || (iwVar.b() == b() && ((byteBuffer = iwVar.b) == null || (byteBuffer2 = this.b) == null || byteBuffer2.position() + byteBuffer.limit() < 3072000))) {
            v(iwVar);
        } else {
            this.g = true;
        }
    }
}
