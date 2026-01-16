package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class pc implements jy {
    public static final /* synthetic */ int a = 0;
    private boolean f;
    private boolean g;
    private boolean h;
    private long i;
    private ka j;
    private boolean k;
    private ph l;
    private final aes b = new aes(0);
    private final aee d = new aee(4096);
    private final SparseArray<pb> c = new SparseArray<>();
    private final oz e = new oz();

    static {
        int i = pa.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.j = kaVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        if (this.b.d() == -9223372036854775807L || (this.b.b() != 0 && this.b.b() != j2)) {
            this.b.e();
            this.b.a(j2);
        }
        ph phVar = this.l;
        if (phVar != null) {
            phVar.b(j2);
        }
        for (int i = 0; i < this.c.size(); i++) {
            this.c.valueAt(i).a();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        byte[] bArr = new byte[14];
        jvVar.g(bArr, 0, 14);
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        jvVar.i(bArr[13] & 7);
        jvVar.g(bArr, 0, 3);
        return ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        oh ojVar;
        ary.s(this.j);
        long jM = jvVar.m();
        if (jM != -1 && !this.e.a()) {
            return this.e.e(jvVar, klVar);
        }
        if (!this.k) {
            this.k = true;
            if (this.e.c() != -9223372036854775807L) {
                ph phVar = new ph(this.e.b(), this.e.c(), jM);
                this.l = phVar;
                this.j.am(phVar.a());
            } else {
                this.j.am(new kn(this.e.c()));
            }
        }
        ph phVar2 = this.l;
        if (phVar2 != null && phVar2.c()) {
            return this.l.d(jvVar, klVar);
        }
        jvVar.j();
        long jK = jM != -1 ? jM - jvVar.k() : -1L;
        if ((jK != -1 && jK < 4) || !jvVar.f(this.d.i(), 0, 4, true)) {
            return -1;
        }
        this.d.h(0);
        int iV = this.d.v();
        if (iV == 441) {
            return -1;
        }
        if (iV == 442) {
            jvVar.g(this.d.i(), 0, 10);
            this.d.h(9);
            jvVar.d((this.d.n() & 7) + 14);
            return 0;
        }
        if (iV == 443) {
            jvVar.g(this.d.i(), 0, 2);
            this.d.h(0);
            jvVar.d(this.d.o() + 6);
            return 0;
        }
        if ((iV >> 8) != 1) {
            jvVar.d(1);
            return 0;
        }
        int i = iV & 255;
        pb pbVar = this.c.get(i);
        if (!this.f) {
            if (pbVar == null) {
                oh nxVar = null;
                if (i == 189) {
                    nxVar = new nx();
                    this.g = true;
                    this.i = jvVar.l();
                } else {
                    if ((i & 224) == 192) {
                        ojVar = new ou(null);
                        this.g = true;
                        this.i = jvVar.l();
                    } else if ((i & 240) == 224) {
                        ojVar = new oj(null);
                        this.h = true;
                        this.i = jvVar.l();
                    }
                    nxVar = ojVar;
                }
                if (nxVar != null) {
                    nxVar.b(this.j, new pq(i, 256));
                    pbVar = new pb(nxVar, this.b);
                    this.c.put(i, pbVar);
                }
            }
            long j = 1048576;
            if (this.g && this.h) {
                j = this.i + 8192;
            }
            if (jvVar.l() > j) {
                this.f = true;
                this.j.al();
            }
        }
        jvVar.g(this.d.i(), 0, 2);
        this.d.h(0);
        int iO = this.d.o() + 6;
        if (pbVar == null) {
            jvVar.d(iO);
        } else {
            this.d.a(iO);
            jvVar.c(this.d.i(), 0, iO);
            this.d.h(6);
            pbVar.b(this.d);
            aee aeeVar = this.d;
            aeeVar.f(aeeVar.j());
        }
        return 0;
    }
}
