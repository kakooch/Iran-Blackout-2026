package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC18068o2;
import ir.nasim.InterfaceC22268uw7;

/* renamed from: ir.nasim.n2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17477n2 implements B52 {
    private final DW4 a;
    private final EW4 b;
    private final String c;
    private String d;
    private InterfaceC4589Ft7 e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private com.google.android.exoplayer2.X k;
    private int l;
    private long m;

    public C17477n2() {
        this(null);
    }

    private boolean f(EW4 ew4, byte[] bArr, int i) {
        int iMin = Math.min(ew4.a(), i - this.g);
        ew4.j(bArr, this.g, iMin);
        int i2 = this.g + iMin;
        this.g = i2;
        return i2 == i;
    }

    private void g() {
        this.a.p(0);
        AbstractC18068o2.b bVarD = AbstractC18068o2.d(this.a);
        com.google.android.exoplayer2.X x = this.k;
        if (x == null || bVarD.c != x.y || bVarD.b != x.z || !"audio/ac4".equals(x.l)) {
            com.google.android.exoplayer2.X xG = new X.b().U(this.d).g0("audio/ac4").J(bVarD.c).h0(bVarD.b).X(this.c).G();
            this.k = xG;
            this.e.c(xG);
        }
        this.l = bVarD.d;
        this.j = (bVarD.e * 1000000) / this.k.z;
    }

    private boolean h(EW4 ew4) {
        int iF;
        while (true) {
            if (ew4.a() <= 0) {
                return false;
            }
            if (this.h) {
                iF = ew4.F();
                this.h = iF == 172;
                if (iF == 64 || iF == 65) {
                    break;
                }
            } else {
                this.h = ew4.F() == 172;
            }
        }
        this.i = iF == 65;
        return true;
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        AbstractC20011rK.i(this.e);
        while (ew4.a() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(ew4.a(), this.l - this.g);
                        this.e.d(ew4, iMin);
                        int i2 = this.g + iMin;
                        this.g = i2;
                        int i3 = this.l;
                        if (i2 == i3) {
                            long j = this.m;
                            if (j != -9223372036854775807L) {
                                this.e.b(j, 1, i3, 0, null);
                                this.m += this.j;
                            }
                            this.f = 0;
                        }
                    }
                } else if (f(ew4, this.b.e(), 16)) {
                    g();
                    this.b.S(0);
                    this.e.d(this.b, 16);
                    this.f = 2;
                }
            } else if (h(ew4)) {
                this.f = 1;
                this.b.e()[0] = -84;
                this.b.e()[1] = (byte) (this.i ? 65 : 64);
                this.g = 2;
            }
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = interfaceC10465bf2.b(dVar.c(), 1);
    }

    @Override // ir.nasim.B52
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    public C17477n2(String str) {
        DW4 dw4 = new DW4(new byte[16]);
        this.a = dw4;
        this.b = new EW4(dw4.a);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
        this.c = str;
    }

    @Override // ir.nasim.B52
    public void d() {
    }
}
