package ir.nasim;

import ir.nasim.InterfaceC22268uw7;

/* renamed from: ir.nasim.ri6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20260ri6 implements InterfaceC22268uw7 {
    private final InterfaceC19651qi6 a;
    private final EW4 b = new EW4(32);
    private int c;
    private int d;
    private boolean e;
    private boolean f;

    public C20260ri6(InterfaceC19651qi6 interfaceC19651qi6) {
        this.a = interfaceC19651qi6;
    }

    @Override // ir.nasim.InterfaceC22268uw7
    public void a(EW4 ew4, int i) {
        boolean z = (i & 1) != 0;
        int iF = z ? ew4.f() + ew4.F() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            ew4.S(iF);
            this.d = 0;
        }
        while (ew4.a() > 0) {
            int i2 = this.d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int iF2 = ew4.F();
                    ew4.S(ew4.f() - 1);
                    if (iF2 == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(ew4.a(), 3 - this.d);
                ew4.j(this.b.e(), this.d, iMin);
                int i3 = this.d + iMin;
                this.d = i3;
                if (i3 == 3) {
                    this.b.S(0);
                    this.b.R(3);
                    this.b.T(1);
                    int iF3 = this.b.F();
                    int iF4 = this.b.F();
                    this.e = (iF3 & 128) != 0;
                    this.c = (((iF3 & 15) << 8) | iF4) + 3;
                    int iB = this.b.b();
                    int i4 = this.c;
                    if (iB < i4) {
                        this.b.c(Math.min(4098, Math.max(i4, this.b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(ew4.a(), this.c - this.d);
                ew4.j(this.b.e(), this.d, iMin2);
                int i5 = this.d + iMin2;
                this.d = i5;
                int i6 = this.c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.R(i6);
                    } else {
                        if (AbstractC9683aN7.s(this.b.e(), 0, this.c, -1) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.R(this.c - 4);
                    }
                    this.b.S(0);
                    this.a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC22268uw7
    public void b() {
        this.f = true;
    }

    @Override // ir.nasim.InterfaceC22268uw7
    public void c(C5045Hq7 c5045Hq7, InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        this.a.c(c5045Hq7, interfaceC10465bf2, dVar);
        this.f = true;
    }
}
