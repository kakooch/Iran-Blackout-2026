package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class pe implements pr {
    private final pd a;
    private final aee b = new aee(32);
    private int c;
    private int d;
    private boolean e;
    private boolean f;

    public pe(pd pdVar) {
        this.a = pdVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pr
    public final void a(aes aesVar, ka kaVar, pq pqVar) {
        this.a.a(aesVar, kaVar, pqVar);
        this.f = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pr
    public final void b() {
        this.f = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pr
    public final void c(aee aeeVar, int i) {
        int i2 = i & 1;
        int iG = i2 != 0 ? aeeVar.g() + aeeVar.n() : -1;
        if (this.f) {
            if (i2 == 0) {
                return;
            }
            this.f = false;
            aeeVar.h(iG);
            this.d = 0;
        }
        while (aeeVar.d() > 0) {
            int i3 = this.d;
            if (i3 < 3) {
                if (i3 == 0) {
                    int iN = aeeVar.n();
                    aeeVar.h(aeeVar.g() - 1);
                    if (iN == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(aeeVar.d(), 3 - this.d);
                aeeVar.m(this.b.i(), this.d, iMin);
                int i4 = this.d + iMin;
                this.d = i4;
                if (i4 == 3) {
                    this.b.a(3);
                    this.b.k(1);
                    int iN2 = this.b.n();
                    int iN3 = this.b.n();
                    this.e = (iN2 & 128) != 0;
                    this.c = (((iN2 & 15) << 8) | iN3) + 3;
                    if (this.b.j() < this.c) {
                        byte[] bArrI = this.b.i();
                        aee aeeVar2 = this.b;
                        int i5 = this.c;
                        int length = bArrI.length;
                        aeeVar2.a(Math.min(4098, Math.max(i5, length + length)));
                        System.arraycopy(bArrI, 0, this.b.i(), 0, 3);
                    }
                }
            } else {
                int iMin2 = Math.min(aeeVar.d(), this.c - this.d);
                aeeVar.m(this.b.i(), this.d, iMin2);
                int i6 = this.d + iMin2;
                this.d = i6;
                int i7 = this.c;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.a(i7);
                    } else {
                        if (aeu.ao(this.b.i(), this.c) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.a(this.c - 4);
                    }
                    this.a.b(this.b);
                    this.d = 0;
                }
            }
        }
    }
}
