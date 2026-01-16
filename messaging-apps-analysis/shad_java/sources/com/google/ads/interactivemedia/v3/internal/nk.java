package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class nk implements jy {
    public static final /* synthetic */ int a = 0;
    private ka b;
    private nr c;
    private boolean d;

    static {
        int i = nj.b;
    }

    private final boolean a(jv jvVar) throws IOException {
        nm nmVar = new nm();
        if (nmVar.d(jvVar, true) && (nmVar.b & 2) == 2) {
            int iMin = Math.min(nmVar.f, 8);
            aee aeeVar = new aee(iMin);
            jvVar.g(aeeVar.i(), 0, iMin);
            b(aeeVar);
            if (aeeVar.d() >= 5 && aeeVar.n() == 127 && aeeVar.t() == 1179402563) {
                this.c = new ni();
            } else {
                b(aeeVar);
                if (atv.o(1, aeeVar, true)) {
                    this.c = new nt();
                } else {
                    b(aeeVar);
                    if (no.d(aeeVar)) {
                        this.c = new no();
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static void b(aee aeeVar) {
        aeeVar.h(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.b = kaVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        nr nrVar = this.c;
        if (nrVar != null) {
            nrVar.f(j, j2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        try {
            return a(jvVar);
        } catch (dt unused) {
            return false;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        ary.s(this.b);
        if (this.c == null) {
            if (!a(jvVar)) {
                throw new dt("Failed to determine bitstream type");
            }
            jvVar.j();
        }
        if (!this.d) {
            kr krVarAk = this.b.ak(0, 1);
            this.b.al();
            this.c.e(this.b, krVarAk);
            this.d = true;
        }
        return this.c.j(jvVar, klVar);
    }
}
