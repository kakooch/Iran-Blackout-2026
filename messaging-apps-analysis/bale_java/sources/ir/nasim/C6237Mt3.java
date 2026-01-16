package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;
import ir.nasim.K;
import java.util.Collections;

/* renamed from: ir.nasim.Mt3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6237Mt3 implements B52 {
    private final String a;
    private final EW4 b;
    private final DW4 c;
    private InterfaceC4589Ft7 d;
    private String e;
    private com.google.android.exoplayer2.X f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;
    private String u;

    public C6237Mt3(String str) {
        this.a = str;
        EW4 ew4 = new EW4(1024);
        this.b = ew4;
        this.c = new DW4(ew4.e());
        this.k = -9223372036854775807L;
    }

    private static long f(DW4 dw4) {
        return dw4.h((dw4.h(2) + 1) * 8);
    }

    private void g(DW4 dw4) throws ParserException {
        if (!dw4.g()) {
            this.l = true;
            l(dw4);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw ParserException.a(null, null);
        }
        if (this.n != 0) {
            throw ParserException.a(null, null);
        }
        k(dw4, j(dw4));
        if (this.p) {
            dw4.r((int) this.q);
        }
    }

    private int h(DW4 dw4) throws ParserException {
        int iB = dw4.b();
        K.b bVarD = K.d(dw4, true);
        this.u = bVarD.c;
        this.r = bVarD.a;
        this.t = bVarD.b;
        return iB - dw4.b();
    }

    private void i(DW4 dw4) {
        int iH = dw4.h(3);
        this.o = iH;
        if (iH == 0) {
            dw4.r(8);
            return;
        }
        if (iH == 1) {
            dw4.r(9);
            return;
        }
        if (iH == 3 || iH == 4 || iH == 5) {
            dw4.r(6);
        } else {
            if (iH != 6 && iH != 7) {
                throw new IllegalStateException();
            }
            dw4.r(1);
        }
    }

    private int j(DW4 dw4) throws ParserException {
        int iH;
        if (this.o != 0) {
            throw ParserException.a(null, null);
        }
        int i = 0;
        do {
            iH = dw4.h(8);
            i += iH;
        } while (iH == 255);
        return i;
    }

    private void k(DW4 dw4, int i) {
        int iE = dw4.e();
        if ((iE & 7) == 0) {
            this.b.S(iE >> 3);
        } else {
            dw4.i(this.b.e(), 0, i * 8);
            this.b.S(0);
        }
        this.d.d(this.b, i);
        long j = this.k;
        if (j != -9223372036854775807L) {
            this.d.b(j, 1, i, 0, null);
            this.k += this.s;
        }
    }

    private void l(DW4 dw4) throws ParserException {
        boolean zG;
        int iH = dw4.h(1);
        int iH2 = iH == 1 ? dw4.h(1) : 0;
        this.m = iH2;
        if (iH2 != 0) {
            throw ParserException.a(null, null);
        }
        if (iH == 1) {
            f(dw4);
        }
        if (!dw4.g()) {
            throw ParserException.a(null, null);
        }
        this.n = dw4.h(6);
        int iH3 = dw4.h(4);
        int iH4 = dw4.h(3);
        if (iH3 != 0 || iH4 != 0) {
            throw ParserException.a(null, null);
        }
        if (iH == 0) {
            int iE = dw4.e();
            int iH5 = h(dw4);
            dw4.p(iE);
            byte[] bArr = new byte[(iH5 + 7) / 8];
            dw4.i(bArr, 0, iH5);
            com.google.android.exoplayer2.X xG = new X.b().U(this.e).g0("audio/mp4a-latm").K(this.u).J(this.t).h0(this.r).V(Collections.singletonList(bArr)).X(this.a).G();
            if (!xG.equals(this.f)) {
                this.f = xG;
                this.s = 1024000000 / xG.z;
                this.d.c(xG);
            }
        } else {
            dw4.r(((int) f(dw4)) - h(dw4));
        }
        i(dw4);
        boolean zG2 = dw4.g();
        this.p = zG2;
        this.q = 0L;
        if (zG2) {
            if (iH == 1) {
                this.q = f(dw4);
            } else {
                do {
                    zG = dw4.g();
                    this.q = (this.q << 8) + dw4.h(8);
                } while (zG);
            }
        }
        if (dw4.g()) {
            dw4.r(8);
        }
    }

    private void m(int i) {
        this.b.O(i);
        this.c.n(this.b.e());
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) throws ParserException {
        AbstractC20011rK.i(this.d);
        while (ew4.a() > 0) {
            int i = this.g;
            if (i != 0) {
                if (i == 1) {
                    int iF = ew4.F();
                    if ((iF & 224) == 224) {
                        this.j = iF;
                        this.g = 2;
                    } else if (iF != 86) {
                        this.g = 0;
                    }
                } else if (i == 2) {
                    int iF2 = ((this.j & (-225)) << 8) | ew4.F();
                    this.i = iF2;
                    if (iF2 > this.b.e().length) {
                        m(this.i);
                    }
                    this.h = 0;
                    this.g = 3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(ew4.a(), this.i - this.h);
                    ew4.j(this.c.a, this.h, iMin);
                    int i2 = this.h + iMin;
                    this.h = i2;
                    if (i2 == this.i) {
                        this.c.p(0);
                        g(this.c);
                        this.g = 0;
                    }
                }
            } else if (ew4.F() == 86) {
                this.g = 1;
            }
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        this.d = interfaceC10465bf2.b(dVar.c(), 1);
        this.e = dVar.b();
    }

    @Override // ir.nasim.B52
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // ir.nasim.B52
    public void d() {
    }
}
