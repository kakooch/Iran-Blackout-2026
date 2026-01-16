package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class os implements oh {
    private final aee a = new aee(10);
    private kr b;
    private boolean c;
    private long d;
    private int e;
    private int f;

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        this.c = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        kr krVarAk = kaVar.ak(pqVar.b(), 4);
        this.b = krVarAk;
        cx cxVar = new cx();
        cxVar.S(pqVar.c());
        cxVar.ae("application/id3");
        krVarAk.a(cxVar.a());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        this.d = j;
        this.e = 0;
        this.f = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void d(aee aeeVar) {
        ary.s(this.b);
        if (this.c) {
            int iD = aeeVar.d();
            int i = this.f;
            if (i < 10) {
                int iMin = Math.min(iD, 10 - i);
                System.arraycopy(aeeVar.i(), aeeVar.g(), this.a.i(), this.f, iMin);
                if (this.f + iMin == 10) {
                    this.a.h(0);
                    if (this.a.n() != 73 || this.a.n() != 68 || this.a.n() != 51) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.a.k(3);
                        this.e = this.a.A() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iD, this.e - this.f);
            this.b.d(aeeVar, iMin2);
            this.f += iMin2;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
        int i;
        ary.s(this.b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            this.b.b(this.d, 1, i, 0, null);
            this.c = false;
        }
    }
}
