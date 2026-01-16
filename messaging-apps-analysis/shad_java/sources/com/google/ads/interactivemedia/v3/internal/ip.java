package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ip implements gx {
    private int b;
    private float c = 1.0f;
    private float d = 1.0f;
    private gv e;
    private gv f;
    private gv g;
    private gv h;
    private boolean i;
    private io j;
    private ByteBuffer k;
    private ShortBuffer l;
    private ByteBuffer m;
    private long n;
    private long o;
    private boolean p;

    public ip() {
        gv gvVar = gv.a;
        this.e = gvVar;
        this.f = gvVar;
        this.g = gvVar;
        this.h = gvVar;
        ByteBuffer byteBuffer = gx.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final gv a(gv gvVar) throws gw {
        if (gvVar.d != 2) {
            throw new gw(gvVar);
        }
        int i = this.b;
        if (i == -1) {
            i = gvVar.b;
        }
        this.e = gvVar;
        gv gvVar2 = new gv(i, gvVar.c, 2);
        this.f = gvVar2;
        this.i = true;
        return gvVar2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final boolean b() {
        if (this.f.b != -1) {
            return Math.abs(this.c + (-1.0f)) >= 1.0E-4f || Math.abs(this.d + (-1.0f)) >= 1.0E-4f || this.f.b != this.e.b;
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void c(ByteBuffer byteBuffer) {
        io ioVar = this.j;
        ary.t(ioVar);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.n += iRemaining;
            ioVar.a(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iE = ioVar.e();
        if (iE > 0) {
            if (this.k.capacity() < iE) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iE).order(ByteOrder.nativeOrder());
                this.k = byteBufferOrder;
                this.l = byteBufferOrder.asShortBuffer();
            } else {
                this.k.clear();
                this.l.clear();
            }
            ioVar.b(this.l);
            this.o += iE;
            this.k.limit(iE);
            this.m = this.k;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void d() {
        io ioVar = this.j;
        if (ioVar != null) {
            ioVar.c();
        }
        this.p = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final ByteBuffer e() {
        ByteBuffer byteBuffer = this.m;
        this.m = gx.a;
        return byteBuffer;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final boolean f() {
        io ioVar;
        return this.p && ((ioVar = this.j) == null || ioVar.e() == 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void g() {
        if (b()) {
            gv gvVar = this.e;
            this.g = gvVar;
            gv gvVar2 = this.f;
            this.h = gvVar2;
            if (this.i) {
                this.j = new io(gvVar.b, gvVar.c, this.c, this.d, gvVar2.b);
            } else {
                io ioVar = this.j;
                if (ioVar != null) {
                    ioVar.d();
                }
            }
        }
        this.m = gx.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void h() {
        this.c = 1.0f;
        this.d = 1.0f;
        gv gvVar = gv.a;
        this.e = gvVar;
        this.f = gvVar;
        this.g = gvVar;
        this.h = gvVar;
        ByteBuffer byteBuffer = gx.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    public final long i(long j) {
        long j2 = this.o;
        if (j2 >= 1024) {
            int i = this.h.b;
            int i2 = this.g.b;
            return i == i2 ? aeu.N(j, this.n, j2) : aeu.N(j, this.n * i, j2 * i2);
        }
        double d = this.c;
        double d2 = j;
        Double.isNaN(d);
        Double.isNaN(d2);
        return (long) (d * d2);
    }

    public final void j(float f) {
        if (this.d != f) {
            this.d = f;
            this.i = true;
        }
    }

    public final void k(float f) {
        if (this.c != f) {
            this.c = f;
            this.i = true;
        }
    }
}
