package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;
import ir.nasim.K;
import java.util.Arrays;
import java.util.Collections;

/* renamed from: ir.nasim.Gb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4668Gb implements B52 {
    private static final byte[] v = {73, 68, 51};
    private final boolean a;
    private final DW4 b;
    private final EW4 c;
    private final String d;
    private String e;
    private InterfaceC4589Ft7 f;
    private InterfaceC4589Ft7 g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private InterfaceC4589Ft7 t;
    private long u;

    public C4668Gb(boolean z) {
        this(z, null);
    }

    private void f() {
        AbstractC20011rK.e(this.f);
        AbstractC9683aN7.j(this.t);
        AbstractC9683aN7.j(this.g);
    }

    private void g(EW4 ew4) {
        if (ew4.a() == 0) {
            return;
        }
        this.b.a[0] = ew4.e()[ew4.f()];
        this.b.p(2);
        int iH = this.b.h(4);
        int i = this.n;
        if (i != -1 && iH != i) {
            q();
            return;
        }
        if (!this.l) {
            this.l = true;
            this.m = this.o;
            this.n = iH;
        }
        t();
    }

    private boolean h(EW4 ew4, int i) {
        ew4.S(i + 1);
        if (!w(ew4, this.b.a, 1)) {
            return false;
        }
        this.b.p(4);
        int iH = this.b.h(1);
        int i2 = this.m;
        if (i2 != -1 && iH != i2) {
            return false;
        }
        if (this.n != -1) {
            if (!w(ew4, this.b.a, 1)) {
                return true;
            }
            this.b.p(2);
            if (this.b.h(4) != this.n) {
                return false;
            }
            ew4.S(i + 2);
        }
        if (!w(ew4, this.b.a, 4)) {
            return true;
        }
        this.b.p(14);
        int iH2 = this.b.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrE = ew4.e();
        int iG = ew4.g();
        int i3 = i + iH2;
        if (i3 >= iG) {
            return true;
        }
        byte b = bArrE[i3];
        if (b == -1) {
            int i4 = i3 + 1;
            if (i4 == iG) {
                return true;
            }
            return l((byte) -1, bArrE[i4]) && ((bArrE[i4] & 8) >> 3) == iH;
        }
        if (b != 73) {
            return false;
        }
        int i5 = i3 + 1;
        if (i5 == iG) {
            return true;
        }
        if (bArrE[i5] != 68) {
            return false;
        }
        int i6 = i3 + 2;
        return i6 == iG || bArrE[i6] == 51;
    }

    private boolean i(EW4 ew4, byte[] bArr, int i) {
        int iMin = Math.min(ew4.a(), i - this.i);
        ew4.j(bArr, this.i, iMin);
        int i2 = this.i + iMin;
        this.i = i2;
        return i2 == i;
    }

    private void j(EW4 ew4) {
        byte[] bArrE = ew4.e();
        int iF = ew4.f();
        int iG = ew4.g();
        while (iF < iG) {
            int i = iF + 1;
            byte b = bArrE[iF];
            int i2 = b & 255;
            if (this.j == 512 && l((byte) -1, (byte) i2) && (this.l || h(ew4, iF - 1))) {
                this.o = (b & 8) >> 3;
                this.k = (b & 1) == 0;
                if (this.l) {
                    t();
                } else {
                    r();
                }
                ew4.S(i);
                return;
            }
            int i3 = this.j;
            int i4 = i2 | i3;
            if (i4 == 329) {
                this.j = 768;
            } else if (i4 == 511) {
                this.j = 512;
            } else if (i4 == 836) {
                this.j = 1024;
            } else if (i4 == 1075) {
                u();
                ew4.S(i);
                return;
            } else if (i3 != 256) {
                this.j = 256;
            }
            iF = i;
        }
        ew4.S(iF);
    }

    private boolean l(byte b, byte b2) {
        return m(((b & 255) << 8) | (b2 & 255));
    }

    public static boolean m(int i) {
        return (i & 65526) == 65520;
    }

    private void n() {
        this.b.p(0);
        if (this.p) {
            this.b.r(10);
        } else {
            int i = 2;
            int iH = this.b.h(2) + 1;
            if (iH != 2) {
                AbstractC18815pI3.k("AdtsReader", "Detected audio object type: " + iH + ", but assuming AAC LC.");
            } else {
                i = iH;
            }
            this.b.r(5);
            byte[] bArrA = K.a(i, this.n, this.b.h(3));
            K.b bVarE = K.e(bArrA);
            com.google.android.exoplayer2.X xG = new X.b().U(this.e).g0("audio/mp4a-latm").K(bVarE.c).J(bVarE.b).h0(bVarE.a).V(Collections.singletonList(bArrA)).X(this.d).G();
            this.q = 1024000000 / xG.z;
            this.f.c(xG);
            this.p = true;
        }
        this.b.r(4);
        int iH2 = this.b.h(13);
        int i2 = iH2 - 7;
        if (this.k) {
            i2 = iH2 - 9;
        }
        v(this.f, this.q, 0, i2);
    }

    private void o() {
        this.g.d(this.c, 10);
        this.c.S(6);
        v(this.g, 0L, 10, this.c.E() + 10);
    }

    private void p(EW4 ew4) {
        int iMin = Math.min(ew4.a(), this.r - this.i);
        this.t.d(ew4, iMin);
        int i = this.i + iMin;
        this.i = i;
        int i2 = this.r;
        if (i == i2) {
            long j = this.s;
            if (j != -9223372036854775807L) {
                this.t.b(j, 1, i2, 0, null);
                this.s += this.u;
            }
            s();
        }
    }

    private void q() {
        this.l = false;
        s();
    }

    private void r() {
        this.h = 1;
        this.i = 0;
    }

    private void s() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    private void t() {
        this.h = 3;
        this.i = 0;
    }

    private void u() {
        this.h = 2;
        this.i = v.length;
        this.r = 0;
        this.c.S(0);
    }

    private void v(InterfaceC4589Ft7 interfaceC4589Ft7, long j, int i, int i2) {
        this.h = 4;
        this.i = i;
        this.t = interfaceC4589Ft7;
        this.u = j;
        this.r = i2;
    }

    private boolean w(EW4 ew4, byte[] bArr, int i) {
        if (ew4.a() < i) {
            return false;
        }
        ew4.j(bArr, 0, i);
        return true;
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        f();
        while (ew4.a() > 0) {
            int i = this.h;
            if (i == 0) {
                j(ew4);
            } else if (i == 1) {
                g(ew4);
            } else if (i != 2) {
                if (i == 3) {
                    if (i(ew4, this.b.a, this.k ? 7 : 5)) {
                        n();
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    p(ew4);
                }
            } else if (i(ew4, this.c.e(), 10)) {
                o();
            }
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.s = -9223372036854775807L;
        q();
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        this.e = dVar.b();
        InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 1);
        this.f = interfaceC4589Ft7B;
        this.t = interfaceC4589Ft7B;
        if (!this.a) {
            this.g = new P12();
            return;
        }
        dVar.a();
        InterfaceC4589Ft7 interfaceC4589Ft7B2 = interfaceC10465bf2.b(dVar.c(), 5);
        this.g = interfaceC4589Ft7B2;
        interfaceC4589Ft7B2.c(new X.b().U(dVar.b()).g0("application/id3").G());
    }

    @Override // ir.nasim.B52
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.s = j;
        }
    }

    public long k() {
        return this.q;
    }

    public C4668Gb(boolean z, String str) {
        this.b = new DW4(new byte[7]);
        this.c = new EW4(Arrays.copyOf(v, 10));
        s();
        this.m = -1;
        this.n = -1;
        this.q = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.a = z;
        this.d = str;
    }

    @Override // ir.nasim.B52
    public void d() {
    }
}
