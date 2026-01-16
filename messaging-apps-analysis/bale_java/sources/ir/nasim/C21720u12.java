package ir.nasim;

import ir.nasim.InterfaceC22268uw7;

/* renamed from: ir.nasim.u12, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21720u12 implements B52 {
    private final String b;
    private String c;
    private InterfaceC4589Ft7 d;
    private int f;
    private int g;
    private long h;
    private com.google.android.exoplayer2.X i;
    private int j;
    private final EW4 a = new EW4(new byte[18]);
    private int e = 0;
    private long k = -9223372036854775807L;

    public C21720u12(String str) {
        this.b = str;
    }

    private boolean f(EW4 ew4, byte[] bArr, int i) {
        int iMin = Math.min(ew4.a(), i - this.f);
        ew4.j(bArr, this.f, iMin);
        int i2 = this.f + iMin;
        this.f = i2;
        return i2 == i;
    }

    private void g() {
        byte[] bArrE = this.a.e();
        if (this.i == null) {
            com.google.android.exoplayer2.X xG = AbstractC22310v12.g(bArrE, this.c, this.b, null);
            this.i = xG;
            this.d.c(xG);
        }
        this.j = AbstractC22310v12.a(bArrE);
        this.h = (int) ((AbstractC22310v12.f(bArrE) * 1000000) / this.i.z);
    }

    private boolean h(EW4 ew4) {
        while (ew4.a() > 0) {
            int i = this.g << 8;
            this.g = i;
            int iF = i | ew4.F();
            this.g = iF;
            if (AbstractC22310v12.d(iF)) {
                byte[] bArrE = this.a.e();
                int i2 = this.g;
                bArrE[0] = (byte) ((i2 >> 24) & 255);
                bArrE[1] = (byte) ((i2 >> 16) & 255);
                bArrE[2] = (byte) ((i2 >> 8) & 255);
                bArrE[3] = (byte) (i2 & 255);
                this.f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        AbstractC20011rK.i(this.d);
        while (ew4.a() > 0) {
            int i = this.e;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(ew4.a(), this.j - this.f);
                    this.d.d(ew4, iMin);
                    int i2 = this.f + iMin;
                    this.f = i2;
                    int i3 = this.j;
                    if (i2 == i3) {
                        long j = this.k;
                        if (j != -9223372036854775807L) {
                            this.d.b(j, 1, i3, 0, null);
                            this.k += this.h;
                        }
                        this.e = 0;
                    }
                } else if (f(ew4, this.a.e(), 18)) {
                    g();
                    this.a.S(0);
                    this.d.d(this.a, 18);
                    this.e = 2;
                }
            } else if (h(ew4)) {
                this.e = 1;
            }
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.k = -9223372036854775807L;
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        this.c = dVar.b();
        this.d = interfaceC10465bf2.b(dVar.c(), 1);
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
