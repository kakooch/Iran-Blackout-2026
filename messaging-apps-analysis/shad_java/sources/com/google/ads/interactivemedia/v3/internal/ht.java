package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ht implements gx {
    protected gv b;
    protected gv c;
    private gv d;
    private gv e;
    private ByteBuffer f;
    private ByteBuffer g;
    private boolean h;

    public ht() {
        ByteBuffer byteBuffer = gx.a;
        this.f = byteBuffer;
        this.g = byteBuffer;
        gv gvVar = gv.a;
        this.d = gvVar;
        this.e = gvVar;
        this.b = gvVar;
        this.c = gvVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final gv a(gv gvVar) throws gw {
        this.d = gvVar;
        this.e = k(gvVar);
        return b() ? this.e : gv.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public boolean b() {
        return this.e != gv.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void d() {
        this.h = true;
        l();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public ByteBuffer e() {
        ByteBuffer byteBuffer = this.g;
        this.g = gx.a;
        return byteBuffer;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public boolean f() {
        return this.h && this.g == gx.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void g() {
        this.g = gx.a;
        this.h = false;
        this.b = this.d;
        this.c = this.e;
        m();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void h() {
        g();
        this.f = gx.a;
        gv gvVar = gv.a;
        this.d = gvVar;
        this.e = gvVar;
        this.b = gvVar;
        this.c = gvVar;
        n();
    }

    protected final ByteBuffer i(int i) {
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        ByteBuffer byteBuffer = this.f;
        this.g = byteBuffer;
        return byteBuffer;
    }

    protected final boolean j() {
        return this.g.hasRemaining();
    }

    protected gv k(gv gvVar) throws gw {
        throw null;
    }

    protected void l() {
    }

    protected void m() {
    }

    protected void n() {
    }
}
