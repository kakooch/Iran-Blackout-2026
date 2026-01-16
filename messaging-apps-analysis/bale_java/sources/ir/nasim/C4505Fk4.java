package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC4754Gk4;
import ir.nasim.InterfaceC22268uw7;

/* renamed from: ir.nasim.Fk4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4505Fk4 implements B52 {
    private final EW4 a;
    private final AbstractC4754Gk4.a b;
    private final String c;
    private InterfaceC4589Ft7 d;
    private String e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;

    public C4505Fk4() {
        this(null);
    }

    private void f(EW4 ew4) {
        byte[] bArrE = ew4.e();
        int iG = ew4.g();
        for (int iF = ew4.f(); iF < iG; iF++) {
            byte b = bArrE[iF];
            boolean z = (b & 255) == 255;
            boolean z2 = this.i && (b & 224) == 224;
            this.i = z;
            if (z2) {
                ew4.S(iF + 1);
                this.i = false;
                this.a.e()[1] = bArrE[iF];
                this.g = 2;
                this.f = 1;
                return;
            }
        }
        ew4.S(iG);
    }

    private void g(EW4 ew4) {
        int iMin = Math.min(ew4.a(), this.k - this.g);
        this.d.d(ew4, iMin);
        int i = this.g + iMin;
        this.g = i;
        int i2 = this.k;
        if (i < i2) {
            return;
        }
        long j = this.l;
        if (j != -9223372036854775807L) {
            this.d.b(j, 1, i2, 0, null);
            this.l += this.j;
        }
        this.g = 0;
        this.f = 0;
    }

    private void h(EW4 ew4) {
        int iMin = Math.min(ew4.a(), 4 - this.g);
        ew4.j(this.a.e(), this.g, iMin);
        int i = this.g + iMin;
        this.g = i;
        if (i < 4) {
            return;
        }
        this.a.S(0);
        if (!this.b.a(this.a.o())) {
            this.g = 0;
            this.f = 1;
            return;
        }
        this.k = this.b.c;
        if (!this.h) {
            this.j = (r8.g * 1000000) / r8.d;
            this.d.c(new X.b().U(this.e).g0(this.b.b).Y(4096).J(this.b.e).h0(this.b.d).X(this.c).G());
            this.h = true;
        }
        this.a.S(0);
        this.d.d(this.a, 4);
        this.f = 2;
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        AbstractC20011rK.i(this.d);
        while (ew4.a() > 0) {
            int i = this.f;
            if (i == 0) {
                f(ew4);
            } else if (i == 1) {
                h(ew4);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                g(ew4);
            }
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        this.e = dVar.b();
        this.d = interfaceC10465bf2.b(dVar.c(), 1);
    }

    @Override // ir.nasim.B52
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    public C4505Fk4(String str) {
        this.f = 0;
        EW4 ew4 = new EW4(4);
        this.a = ew4;
        ew4.e()[0] = -1;
        this.b = new AbstractC4754Gk4.a();
        this.l = -9223372036854775807L;
        this.c = str;
    }

    @Override // ir.nasim.B52
    public void d() {
    }
}
