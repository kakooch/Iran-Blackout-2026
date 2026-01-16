package ir.nasim;

import ir.nasim.InterfaceC22268uw7;

/* loaded from: classes2.dex */
public final class K65 implements InterfaceC22268uw7 {
    private final B52 a;
    private final DW4 b = new DW4(new byte[10]);
    private int c = 0;
    private int d;
    private C5045Hq7 e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public K65(B52 b52) {
        this.a = b52;
    }

    private boolean d(EW4 ew4, byte[] bArr, int i) {
        int iMin = Math.min(ew4.a(), i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            ew4.T(iMin);
        } else {
            ew4.j(bArr, this.d, iMin);
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }

    private boolean e() {
        this.b.p(0);
        int iH = this.b.h(24);
        if (iH != 1) {
            AbstractC18815pI3.k("PesReader", "Unexpected start code prefix: " + iH);
            this.j = -1;
            return false;
        }
        this.b.r(8);
        int iH2 = this.b.h(16);
        this.b.r(5);
        this.k = this.b.g();
        this.b.r(2);
        this.f = this.b.g();
        this.g = this.b.g();
        this.b.r(6);
        int iH3 = this.b.h(8);
        this.i = iH3;
        if (iH2 == 0) {
            this.j = -1;
        } else {
            int i = (iH2 - 3) - iH3;
            this.j = i;
            if (i < 0) {
                AbstractC18815pI3.k("PesReader", "Found negative packet payload size: " + this.j);
                this.j = -1;
            }
        }
        return true;
    }

    private void f() {
        this.b.p(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.r(4);
            this.b.r(1);
            this.b.r(1);
            long jH = (this.b.h(3) << 30) | (this.b.h(15) << 15) | this.b.h(15);
            this.b.r(1);
            if (!this.h && this.g) {
                this.b.r(4);
                this.b.r(1);
                this.b.r(1);
                this.b.r(1);
                this.e.b((this.b.h(3) << 30) | (this.b.h(15) << 15) | this.b.h(15));
                this.h = true;
            }
            this.l = this.e.b(jH);
        }
    }

    private void g(int i) {
        this.c = i;
        this.d = 0;
    }

    @Override // ir.nasim.InterfaceC22268uw7
    public final void a(EW4 ew4, int i) {
        AbstractC20011rK.i(this.e);
        if ((i & 1) != 0) {
            int i2 = this.c;
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    AbstractC18815pI3.k("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.j != -1) {
                        AbstractC18815pI3.k("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    this.a.d();
                }
            }
            g(1);
        }
        while (ew4.a() > 0) {
            int i3 = this.c;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (d(ew4, this.b.a, Math.min(10, this.i)) && d(ew4, null, this.i)) {
                            f();
                            i |= this.k ? 4 : 0;
                            this.a.e(this.l, i);
                            g(3);
                        }
                    } else {
                        if (i3 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = ew4.a();
                        int i4 = this.j;
                        int i5 = i4 != -1 ? iA - i4 : 0;
                        if (i5 > 0) {
                            iA -= i5;
                            ew4.R(ew4.f() + iA);
                        }
                        this.a.a(ew4);
                        int i6 = this.j;
                        if (i6 != -1) {
                            int i7 = i6 - iA;
                            this.j = i7;
                            if (i7 == 0) {
                                this.a.d();
                                g(1);
                            }
                        }
                    }
                } else if (d(ew4, this.b.a, 9)) {
                    g(e() ? 2 : 0);
                }
            } else {
                ew4.T(ew4.a());
            }
        }
    }

    @Override // ir.nasim.InterfaceC22268uw7
    public final void b() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.b();
    }

    @Override // ir.nasim.InterfaceC22268uw7
    public void c(C5045Hq7 c5045Hq7, InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        this.e = c5045Hq7;
        this.a.c(interfaceC10465bf2, dVar);
    }
}
