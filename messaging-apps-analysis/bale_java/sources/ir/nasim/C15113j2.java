package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC15704k2;
import ir.nasim.InterfaceC22268uw7;
import org.xbill.DNS.Flags;

/* renamed from: ir.nasim.j2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15113j2 implements B52 {
    private final DW4 a;
    private final EW4 b;
    private final String c;
    private String d;
    private InterfaceC4589Ft7 e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private com.google.android.exoplayer2.X j;
    private int k;
    private long l;

    public C15113j2() {
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
        AbstractC15704k2.b bVarF = AbstractC15704k2.f(this.a);
        com.google.android.exoplayer2.X x = this.j;
        if (x == null || bVarF.d != x.y || bVarF.c != x.z || !AbstractC9683aN7.c(bVarF.a, x.l)) {
            X.b bVarB0 = new X.b().U(this.d).g0(bVarF.a).J(bVarF.d).h0(bVarF.c).X(this.c).b0(bVarF.g);
            if ("audio/ac3".equals(bVarF.a)) {
                bVarB0.I(bVarF.g);
            }
            com.google.android.exoplayer2.X xG = bVarB0.G();
            this.j = xG;
            this.e.c(xG);
        }
        this.k = bVarF.e;
        this.i = (bVarF.f * 1000000) / this.j.z;
    }

    private boolean h(EW4 ew4) {
        while (true) {
            if (ew4.a() <= 0) {
                return false;
            }
            if (this.h) {
                int iF = ew4.F();
                if (iF == 119) {
                    this.h = false;
                    return true;
                }
                this.h = iF == 11;
            } else {
                this.h = ew4.F() == 11;
            }
        }
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        AbstractC20011rK.i(this.e);
        while (ew4.a() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(ew4.a(), this.k - this.g);
                        this.e.d(ew4, iMin);
                        int i2 = this.g + iMin;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            long j = this.l;
                            if (j != -9223372036854775807L) {
                                this.e.b(j, 1, i3, 0, null);
                                this.l += this.i;
                            }
                            this.f = 0;
                        }
                    }
                } else if (f(ew4, this.b.e(), 128)) {
                    g();
                    this.b.S(0);
                    this.e.d(this.b, 128);
                    this.f = 2;
                }
            } else if (h(ew4)) {
                this.f = 1;
                this.b.e()[0] = Flags.CD;
                this.b.e()[1] = 119;
                this.g = 2;
            }
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.l = -9223372036854775807L;
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
            this.l = j;
        }
    }

    public C15113j2(String str) {
        DW4 dw4 = new DW4(new byte[128]);
        this.a = dw4;
        this.b = new EW4(dw4.a);
        this.f = 0;
        this.l = -9223372036854775807L;
        this.c = str;
    }

    @Override // ir.nasim.B52
    public void d() {
    }
}
