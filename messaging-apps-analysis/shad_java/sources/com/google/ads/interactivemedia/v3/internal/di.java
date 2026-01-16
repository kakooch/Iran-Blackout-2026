package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class di {
    public final tv a;
    public final Object b;
    public final vb[] c;
    public boolean d;
    public boolean e;
    public dj f;
    public boolean g;
    private final boolean[] h;
    private final ee[] i;
    private final abf j;
    private final ds k;
    private di l;
    private vj m;
    private abg n;
    private long o;

    public di(ee[] eeVarArr, long j, abf abfVar, acc accVar, ds dsVar, dj djVar, abg abgVar) {
        this.i = eeVarArr;
        this.o = j;
        this.j = abfVar;
        this.k = dsVar;
        tw twVar = djVar.a;
        this.b = twVar.a;
        this.f = djVar;
        this.m = vj.a;
        this.n = abgVar;
        int length = eeVarArr.length;
        this.c = new vb[length];
        this.h = new boolean[length];
        long j2 = djVar.b;
        long j3 = djVar.d;
        tv tvVarM = dsVar.m(twVar, accVar, j2);
        if (j3 != -9223372036854775807L && j3 != Long.MIN_VALUE) {
            tvVarM = new sw(tvVarM, j3);
        }
        this.a = tvVarM;
    }

    private final void t() {
        if (!v()) {
            return;
        }
        int i = 0;
        while (true) {
            abg abgVar = this.n;
            if (i >= abgVar.a) {
                return;
            }
            boolean zA = abgVar.a(i);
            aba abaVarA = this.n.c.a(i);
            if (zA && abaVarA != null) {
                abaVarA.f();
            }
            i++;
        }
    }

    private final void u() {
        if (!v()) {
            return;
        }
        int i = 0;
        while (true) {
            abg abgVar = this.n;
            if (i >= abgVar.a) {
                return;
            }
            boolean zA = abgVar.a(i);
            aba abaVarA = this.n.c.a(i);
            if (zA && abaVarA != null) {
                abaVarA.g();
            }
            i++;
        }
    }

    private final boolean v() {
        return this.l == null;
    }

    public final long a(long j) {
        return j + this.o;
    }

    public final long b(long j) {
        return j - this.o;
    }

    public final long c() {
        return this.o;
    }

    public final long d() {
        return this.f.b + this.o;
    }

    public final boolean e() {
        return this.d && (!this.e || this.a.h() == Long.MIN_VALUE);
    }

    public final long f() {
        if (!this.d) {
            return this.f.b;
        }
        long jH = this.e ? this.a.h() : Long.MIN_VALUE;
        return jH == Long.MIN_VALUE ? this.f.e : jH;
    }

    public final long g() {
        if (this.d) {
            return this.a.l();
        }
        return 0L;
    }

    public final void h(float f, es esVar) throws bn {
        this.d = true;
        this.m = this.a.c();
        abg abgVarK = k(f, esVar);
        dj djVar = this.f;
        long jMax = djVar.b;
        long j = djVar.e;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jR = r(abgVarK, jMax);
        long j2 = this.o;
        dj djVar2 = this.f;
        this.o = j2 + (djVar2.b - jR);
        this.f = djVar2.a(jR);
    }

    public final void i(long j) {
        ary.q(v());
        if (this.d) {
            this.a.f(b(j));
        }
    }

    public final void j(long j) {
        ary.q(v());
        this.a.n(b(j));
    }

    public final abg k(float f, es esVar) throws bn {
        abf abfVar = this.j;
        ee[] eeVarArr = this.i;
        vj vjVar = this.m;
        tw twVar = this.f.a;
        abg abgVarI = abfVar.i(eeVarArr, vjVar);
        for (aba abaVar : abgVarI.c.b()) {
            if (abaVar != null) {
                abaVar.h(f);
            }
        }
        return abgVarI;
    }

    public final long l(abg abgVar, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= abgVar.a) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z || !abgVar.b(this.n, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        vb[] vbVarArr = this.c;
        int i2 = 0;
        while (true) {
            ee[] eeVarArr = this.i;
            if (i2 >= eeVarArr.length) {
                break;
            }
            if (eeVarArr[i2].a() == 6) {
                vbVarArr[i2] = null;
            }
            i2++;
        }
        u();
        this.n = abgVar;
        t();
        abb abbVar = abgVar.c;
        long jD = this.a.d(abbVar.b(), this.h, this.c, zArr, j);
        vb[] vbVarArr2 = this.c;
        int i3 = 0;
        while (true) {
            ee[] eeVarArr2 = this.i;
            if (i3 >= eeVarArr2.length) {
                break;
            }
            if (eeVarArr2[i3].a() == 6 && this.n.a(i3)) {
                vbVarArr2[i3] = new tk();
            }
            i3++;
        }
        this.e = false;
        int i4 = 0;
        while (true) {
            vb[] vbVarArr3 = this.c;
            if (i4 >= vbVarArr3.length) {
                return jD;
            }
            if (vbVarArr3[i4] != null) {
                ary.q(abgVar.a(i4));
                if (this.i[i4].a() != 6) {
                    this.e = true;
                }
            } else {
                ary.q(abbVar.a(i4) == null);
            }
            i4++;
        }
    }

    public final void m() {
        u();
        long j = this.f.d;
        ds dsVar = this.k;
        tv tvVar = this.a;
        try {
            if (j == -9223372036854775807L || j == Long.MIN_VALUE) {
                dsVar.d(tvVar);
            } else {
                dsVar.d(((sw) tvVar).a);
            }
        } catch (RuntimeException e) {
            adu.b("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void n(di diVar) {
        if (diVar == this.l) {
            return;
        }
        u();
        this.l = diVar;
        t();
    }

    public final di o() {
        return this.l;
    }

    public final vj p() {
        return this.m;
    }

    public final abg q() {
        return this.n;
    }

    public final long r(abg abgVar, long j) {
        return l(abgVar, j, false, new boolean[this.i.length]);
    }

    public final void s() {
        this.o = 0L;
    }
}
