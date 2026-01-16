package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aeo implements adw {
    private final adk a;
    private boolean b;
    private long c;
    private long d;
    private dv e = dv.a;

    public aeo(adk adkVar) {
        this.a = adkVar;
    }

    public final void a() {
        if (this.b) {
            return;
        }
        this.d = this.a.a();
        this.b = true;
    }

    public final void b() {
        if (this.b) {
            c(g());
            this.b = false;
        }
    }

    public final void c(long j) {
        this.c = j;
        if (this.b) {
            this.d = this.a.a();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final long g() {
        long j = this.c;
        if (!this.b) {
            return j;
        }
        long jA = this.a.a() - this.d;
        dv dvVar = this.e;
        return j + (dvVar.b == 1.0f ? bi.b(jA) : dvVar.a(jA));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final void h(dv dvVar) {
        if (this.b) {
            c(g());
        }
        this.e = dvVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final dv i() {
        return this.e;
    }
}
