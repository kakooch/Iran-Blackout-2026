package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class mr {
    public final kr a;
    public ne d;
    public mm e;
    public int f;
    public int g;
    public int h;
    public int i;
    private boolean l;
    public final nd b = new nd();
    public final aee c = new aee();
    private final aee j = new aee(1);
    private final aee k = new aee();

    public mr(kr krVar, ne neVar, mm mmVar) {
        this.a = krVar;
        this.d = neVar;
        this.e = mmVar;
        a(neVar, mmVar);
    }

    public final void a(ne neVar, mm mmVar) {
        this.d = neVar;
        this.e = mmVar;
        this.a.a(neVar.a.f);
        b();
    }

    public final void b() {
        nd ndVar = this.b;
        ndVar.e = 0;
        ndVar.r = 0L;
        ndVar.s = false;
        ndVar.m = false;
        ndVar.q = false;
        ndVar.o = null;
        this.f = 0;
        this.h = 0;
        this.g = 0;
        this.i = 0;
        this.l = false;
    }

    public final long c() {
        return !this.l ? this.d.f[this.f] : this.b.b(this.f);
    }

    public final long d() {
        return !this.l ? this.d.c[this.f] : this.b.g[this.h];
    }

    public final int e() {
        return !this.l ? this.d.d[this.f] : this.b.i[this.f];
    }

    public final int f() {
        int i = !this.l ? this.d.g[this.f] : this.b.l[this.f] ? 1 : 0;
        return i() != null ? i | 1073741824 : i;
    }

    public final boolean g() {
        this.f++;
        if (!this.l) {
            return false;
        }
        int i = this.g + 1;
        this.g = i;
        int[] iArr = this.b.h;
        int i2 = this.h;
        if (i != iArr[i2]) {
            return true;
        }
        this.h = i2 + 1;
        this.g = 0;
        return false;
    }

    public final int h(int i, int i2) {
        aee aeeVar;
        nc ncVarI = i();
        if (ncVarI == null) {
            return 0;
        }
        int i3 = ncVarI.d;
        if (i3 != 0) {
            aeeVar = this.b.p;
        } else {
            byte[] bArr = (byte[]) aeu.f(ncVarI.e);
            aee aeeVar2 = this.k;
            int length = bArr.length;
            aeeVar2.c(bArr, length);
            aeeVar = this.k;
            i3 = length;
        }
        boolean zC = this.b.c(this.f);
        boolean z = zC || i2 != 0;
        this.j.i()[0] = (byte) ((true != z ? 0 : 128) | i3);
        this.j.h(0);
        this.a.f(this.j, 1);
        this.a.f(aeeVar, i3);
        if (!z) {
            return i3 + 1;
        }
        if (!zC) {
            this.c.a(8);
            byte[] bArrI = this.c.i();
            bArrI[0] = 0;
            bArrI[1] = 1;
            bArrI[2] = 0;
            bArrI[3] = (byte) i2;
            bArrI[4] = (byte) ((i >> 24) & 255);
            bArrI[5] = (byte) ((i >> 16) & 255);
            bArrI[6] = (byte) ((i >> 8) & 255);
            bArrI[7] = (byte) (i & 255);
            this.a.f(this.c, 8);
            return i3 + 9;
        }
        aee aeeVar3 = this.b.p;
        int iO = aeeVar3.o();
        aeeVar3.k(-2);
        int i4 = (iO * 6) + 2;
        if (i2 != 0) {
            this.c.a(i4);
            byte[] bArrI2 = this.c.i();
            aeeVar3.m(bArrI2, 0, i4);
            int i5 = (((bArrI2[2] & 255) << 8) | (bArrI2[3] & 255)) + i2;
            bArrI2[2] = (byte) ((i5 >> 8) & 255);
            bArrI2[3] = (byte) (i5 & 255);
            aeeVar3 = this.c;
        }
        this.a.f(aeeVar3, i4);
        return i3 + 1 + i4;
    }

    public final nc i() {
        if (!this.l) {
            return null;
        }
        nd ndVar = this.b;
        mm mmVar = ndVar.a;
        int i = aeu.a;
        int i2 = mmVar.a;
        nc ncVarA = ndVar.o;
        if (ncVarA == null) {
            ncVarA = this.d.a.a(i2);
        }
        if (ncVarA == null || !ncVarA.a) {
            return null;
        }
        return ncVarA;
    }
}
