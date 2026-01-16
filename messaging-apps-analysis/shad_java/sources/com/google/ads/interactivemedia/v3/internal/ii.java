package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ii implements hl {
    final /* synthetic */ ij a;

    /* synthetic */ ii(ij ijVar) {
        this.a = ijVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hl
    public final void a(long j) {
        this.a.c.d(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hl
    public final void b(int i, long j, long j2) {
        this.a.c.e(i, j, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hl
    public final void c() {
        if (this.a.l != null) {
            this.a.l.b();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hl
    public final void d(Exception exc) {
        this.a.c.i(exc);
    }
}
