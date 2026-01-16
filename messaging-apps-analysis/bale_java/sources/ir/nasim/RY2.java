package ir.nasim;

import ir.nasim.AbstractC15192j98;
import ir.nasim.C13476gI1;
import ir.nasim.C16651le1;
import ir.nasim.C8243Vd1;

/* loaded from: classes2.dex */
public class RY2 extends AbstractC15192j98 {
    private static int[] k = new int[2];

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC15192j98.b.values().length];
            a = iArr;
            try {
                iArr[AbstractC15192j98.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbstractC15192j98.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbstractC15192j98.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public RY2(C16651le1 c16651le1) {
        super(c16651le1);
        this.h.e = C13476gI1.a.LEFT;
        this.i.e = C13476gI1.a.RIGHT;
        this.f = 0;
    }

    private void q(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02df  */
    @Override // ir.nasim.AbstractC15192j98, ir.nasim.InterfaceC10842cI1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(ir.nasim.InterfaceC10842cI1 r17) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.RY2.a(ir.nasim.cI1):void");
    }

    @Override // ir.nasim.AbstractC15192j98
    void d() {
        C16651le1 c16651le1N;
        C16651le1 c16651le1N2;
        C16651le1 c16651le1 = this.b;
        if (c16651le1.a) {
            this.e.d(c16651le1.X());
        }
        if (this.e.j) {
            C16651le1.b bVar = this.d;
            C16651le1.b bVar2 = C16651le1.b.MATCH_PARENT;
            if (bVar == bVar2 && (c16651le1N = this.b.N()) != null && (c16651le1N.C() == C16651le1.b.FIXED || c16651le1N.C() == bVar2)) {
                b(this.h, c16651le1N.e.h, this.b.Q.f());
                b(this.i, c16651le1N.e.i, -this.b.S.f());
                return;
            }
        } else {
            C16651le1.b bVarC = this.b.C();
            this.d = bVarC;
            if (bVarC != C16651le1.b.MATCH_CONSTRAINT) {
                C16651le1.b bVar3 = C16651le1.b.MATCH_PARENT;
                if (bVarC == bVar3 && (c16651le1N2 = this.b.N()) != null && (c16651le1N2.C() == C16651le1.b.FIXED || c16651le1N2.C() == bVar3)) {
                    int iX = (c16651le1N2.X() - this.b.Q.f()) - this.b.S.f();
                    b(this.h, c16651le1N2.e.h, this.b.Q.f());
                    b(this.i, c16651le1N2.e.i, -this.b.S.f());
                    this.e.d(iX);
                    return;
                }
                if (this.d == C16651le1.b.FIXED) {
                    this.e.d(this.b.X());
                }
            }
        }
        GT1 gt1 = this.e;
        if (gt1.j) {
            C16651le1 c16651le12 = this.b;
            if (c16651le12.a) {
                C8243Vd1[] c8243Vd1Arr = c16651le12.Y;
                C8243Vd1 c8243Vd1 = c8243Vd1Arr[0];
                C8243Vd1 c8243Vd12 = c8243Vd1.f;
                if (c8243Vd12 != null && c8243Vd1Arr[1].f != null) {
                    if (c16651le12.j0()) {
                        this.h.f = this.b.Y[0].f();
                        this.i.f = -this.b.Y[1].f();
                        return;
                    }
                    C13476gI1 c13476gI1H = h(this.b.Y[0]);
                    if (c13476gI1H != null) {
                        b(this.h, c13476gI1H, this.b.Y[0].f());
                    }
                    C13476gI1 c13476gI1H2 = h(this.b.Y[1]);
                    if (c13476gI1H2 != null) {
                        b(this.i, c13476gI1H2, -this.b.Y[1].f());
                    }
                    this.h.b = true;
                    this.i.b = true;
                    return;
                }
                if (c8243Vd12 != null) {
                    C13476gI1 c13476gI1H3 = h(c8243Vd1);
                    if (c13476gI1H3 != null) {
                        b(this.h, c13476gI1H3, this.b.Y[0].f());
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                }
                C8243Vd1 c8243Vd13 = c8243Vd1Arr[1];
                if (c8243Vd13.f != null) {
                    C13476gI1 c13476gI1H4 = h(c8243Vd13);
                    if (c13476gI1H4 != null) {
                        b(this.i, c13476gI1H4, -this.b.Y[1].f());
                        b(this.h, this.i, -this.e.g);
                        return;
                    }
                    return;
                }
                if ((c16651le12 instanceof InterfaceC17158mV2) || c16651le12.N() == null || this.b.q(C8243Vd1.b.CENTER).f != null) {
                    return;
                }
                b(this.h, this.b.N().e.h, this.b.Y());
                b(this.i, this.h, this.e.g);
                return;
            }
        }
        if (this.d == C16651le1.b.MATCH_CONSTRAINT) {
            C16651le1 c16651le13 = this.b;
            int i = c16651le13.w;
            if (i == 2) {
                C16651le1 c16651le1N3 = c16651le13.N();
                if (c16651le1N3 != null) {
                    GT1 gt12 = c16651le1N3.f.e;
                    this.e.l.add(gt12);
                    gt12.k.add(this.e);
                    GT1 gt13 = this.e;
                    gt13.b = true;
                    gt13.k.add(this.h);
                    this.e.k.add(this.i);
                }
            } else if (i == 3) {
                if (c16651le13.x == 3) {
                    this.h.a = this;
                    this.i.a = this;
                    C17727nS7 c17727nS7 = c16651le13.f;
                    c17727nS7.h.a = this;
                    c17727nS7.i.a = this;
                    gt1.a = this;
                    if (c16651le13.l0()) {
                        this.e.l.add(this.b.f.e);
                        this.b.f.e.k.add(this.e);
                        C17727nS7 c17727nS72 = this.b.f;
                        c17727nS72.e.a = this;
                        this.e.l.add(c17727nS72.h);
                        this.e.l.add(this.b.f.i);
                        this.b.f.h.k.add(this.e);
                        this.b.f.i.k.add(this.e);
                    } else if (this.b.j0()) {
                        this.b.f.e.l.add(this.e);
                        this.e.k.add(this.b.f.e);
                    } else {
                        this.b.f.e.l.add(this.e);
                    }
                } else {
                    GT1 gt14 = c16651le13.f.e;
                    gt1.l.add(gt14);
                    gt14.k.add(this.e);
                    this.b.f.h.k.add(this.e);
                    this.b.f.i.k.add(this.e);
                    GT1 gt15 = this.e;
                    gt15.b = true;
                    gt15.k.add(this.h);
                    this.e.k.add(this.i);
                    this.h.l.add(this.e);
                    this.i.l.add(this.e);
                }
            }
        }
        C16651le1 c16651le14 = this.b;
        C8243Vd1[] c8243Vd1Arr2 = c16651le14.Y;
        C8243Vd1 c8243Vd14 = c8243Vd1Arr2[0];
        C8243Vd1 c8243Vd15 = c8243Vd14.f;
        if (c8243Vd15 != null && c8243Vd1Arr2[1].f != null) {
            if (c16651le14.j0()) {
                this.h.f = this.b.Y[0].f();
                this.i.f = -this.b.Y[1].f();
                return;
            }
            C13476gI1 c13476gI1H5 = h(this.b.Y[0]);
            C13476gI1 c13476gI1H6 = h(this.b.Y[1]);
            if (c13476gI1H5 != null) {
                c13476gI1H5.b(this);
            }
            if (c13476gI1H6 != null) {
                c13476gI1H6.b(this);
            }
            this.j = AbstractC15192j98.b.CENTER;
            return;
        }
        if (c8243Vd15 != null) {
            C13476gI1 c13476gI1H7 = h(c8243Vd14);
            if (c13476gI1H7 != null) {
                b(this.h, c13476gI1H7, this.b.Y[0].f());
                c(this.i, this.h, 1, this.e);
                return;
            }
            return;
        }
        C8243Vd1 c8243Vd16 = c8243Vd1Arr2[1];
        if (c8243Vd16.f != null) {
            C13476gI1 c13476gI1H8 = h(c8243Vd16);
            if (c13476gI1H8 != null) {
                b(this.i, c13476gI1H8, -this.b.Y[1].f());
                c(this.h, this.i, -1, this.e);
                return;
            }
            return;
        }
        if ((c16651le14 instanceof InterfaceC17158mV2) || c16651le14.N() == null) {
            return;
        }
        b(this.h, this.b.N().e.h, this.b.Y());
        c(this.i, this.h, 1, this.e);
    }

    @Override // ir.nasim.AbstractC15192j98
    public void e() {
        C13476gI1 c13476gI1 = this.h;
        if (c13476gI1.j) {
            this.b.l1(c13476gI1.g);
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // ir.nasim.AbstractC15192j98
    boolean m() {
        return this.d != C16651le1.b.MATCH_CONSTRAINT || this.b.w == 0;
    }

    void r() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.b.v();
    }
}
