package ir.nasim;

import ir.nasim.AbstractC15192j98;
import ir.nasim.C13476gI1;
import ir.nasim.C16651le1;
import ir.nasim.C8243Vd1;

/* renamed from: ir.nasim.nS7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17727nS7 extends AbstractC15192j98 {
    public C13476gI1 k;
    GT1 l;

    /* renamed from: ir.nasim.nS7$a */
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

    public C17727nS7(C16651le1 c16651le1) {
        super(c16651le1);
        C13476gI1 c13476gI1 = new C13476gI1(this);
        this.k = c13476gI1;
        this.l = null;
        this.h.e = C13476gI1.a.TOP;
        this.i.e = C13476gI1.a.BOTTOM;
        c13476gI1.e = C13476gI1.a.BASELINE;
        this.f = 1;
    }

    @Override // ir.nasim.AbstractC15192j98, ir.nasim.InterfaceC10842cI1
    public void a(InterfaceC10842cI1 interfaceC10842cI1) {
        float f;
        float fX;
        float fX2;
        int i;
        int i2 = a.a[this.j.ordinal()];
        if (i2 == 1) {
            p(interfaceC10842cI1);
        } else if (i2 == 2) {
            o(interfaceC10842cI1);
        } else if (i2 == 3) {
            C16651le1 c16651le1 = this.b;
            n(interfaceC10842cI1, c16651le1.R, c16651le1.T, 1);
            return;
        }
        GT1 gt1 = this.e;
        if (gt1.c && !gt1.j && this.d == C16651le1.b.MATCH_CONSTRAINT) {
            C16651le1 c16651le12 = this.b;
            int i3 = c16651le12.x;
            if (i3 == 2) {
                C16651le1 c16651le1N = c16651le12.N();
                if (c16651le1N != null) {
                    if (c16651le1N.f.e.j) {
                        this.e.d((int) ((r7.g * this.b.E) + 0.5f));
                    }
                }
            } else if (i3 == 3 && c16651le12.e.e.j) {
                int iY = c16651le12.y();
                if (iY == -1) {
                    C16651le1 c16651le13 = this.b;
                    f = c16651le13.e.e.g;
                    fX = c16651le13.x();
                } else if (iY == 0) {
                    fX2 = r7.e.e.g * this.b.x();
                    i = (int) (fX2 + 0.5f);
                    this.e.d(i);
                } else if (iY != 1) {
                    i = 0;
                    this.e.d(i);
                } else {
                    C16651le1 c16651le14 = this.b;
                    f = c16651le14.e.e.g;
                    fX = c16651le14.x();
                }
                fX2 = f / fX;
                i = (int) (fX2 + 0.5f);
                this.e.d(i);
            }
        }
        C13476gI1 c13476gI1 = this.h;
        if (c13476gI1.c) {
            C13476gI1 c13476gI12 = this.i;
            if (c13476gI12.c) {
                if (c13476gI1.j && c13476gI12.j && this.e.j) {
                    return;
                }
                if (!this.e.j && this.d == C16651le1.b.MATCH_CONSTRAINT) {
                    C16651le1 c16651le15 = this.b;
                    if (c16651le15.w == 0 && !c16651le15.l0()) {
                        C13476gI1 c13476gI13 = (C13476gI1) this.h.l.get(0);
                        C13476gI1 c13476gI14 = (C13476gI1) this.i.l.get(0);
                        int i4 = c13476gI13.g;
                        C13476gI1 c13476gI15 = this.h;
                        int i5 = i4 + c13476gI15.f;
                        int i6 = c13476gI14.g + this.i.f;
                        c13476gI15.d(i5);
                        this.i.d(i6);
                        this.e.d(i6 - i5);
                        return;
                    }
                }
                if (!this.e.j && this.d == C16651le1.b.MATCH_CONSTRAINT && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    C13476gI1 c13476gI16 = (C13476gI1) this.h.l.get(0);
                    int i7 = (((C13476gI1) this.i.l.get(0)).g + this.i.f) - (c13476gI16.g + this.h.f);
                    GT1 gt12 = this.e;
                    int i8 = gt12.m;
                    if (i7 < i8) {
                        gt12.d(i7);
                    } else {
                        gt12.d(i8);
                    }
                }
                if (this.e.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    C13476gI1 c13476gI17 = (C13476gI1) this.h.l.get(0);
                    C13476gI1 c13476gI18 = (C13476gI1) this.i.l.get(0);
                    int i9 = c13476gI17.g + this.h.f;
                    int i10 = c13476gI18.g + this.i.f;
                    float fS = this.b.S();
                    if (c13476gI17 == c13476gI18) {
                        i9 = c13476gI17.g;
                        i10 = c13476gI18.g;
                        fS = 0.5f;
                    }
                    this.h.d((int) (i9 + 0.5f + (((i10 - i9) - this.e.g) * fS)));
                    this.i.d(this.h.g + this.e.g);
                }
            }
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    void d() {
        C16651le1 c16651le1N;
        C16651le1 c16651le1N2;
        C16651le1 c16651le1 = this.b;
        if (c16651le1.a) {
            this.e.d(c16651le1.z());
        }
        if (!this.e.j) {
            this.d = this.b.U();
            if (this.b.a0()) {
                this.l = new C17822nd0(this);
            }
            C16651le1.b bVar = this.d;
            if (bVar != C16651le1.b.MATCH_CONSTRAINT) {
                if (bVar == C16651le1.b.MATCH_PARENT && (c16651le1N2 = this.b.N()) != null && c16651le1N2.U() == C16651le1.b.FIXED) {
                    int iZ = (c16651le1N2.z() - this.b.R.f()) - this.b.T.f();
                    b(this.h, c16651le1N2.f.h, this.b.R.f());
                    b(this.i, c16651le1N2.f.i, -this.b.T.f());
                    this.e.d(iZ);
                    return;
                }
                if (this.d == C16651le1.b.FIXED) {
                    this.e.d(this.b.z());
                }
            }
        } else if (this.d == C16651le1.b.MATCH_PARENT && (c16651le1N = this.b.N()) != null && c16651le1N.U() == C16651le1.b.FIXED) {
            b(this.h, c16651le1N.f.h, this.b.R.f());
            b(this.i, c16651le1N.f.i, -this.b.T.f());
            return;
        }
        GT1 gt1 = this.e;
        boolean z = gt1.j;
        if (z) {
            C16651le1 c16651le12 = this.b;
            if (c16651le12.a) {
                C8243Vd1[] c8243Vd1Arr = c16651le12.Y;
                C8243Vd1 c8243Vd1 = c8243Vd1Arr[2];
                C8243Vd1 c8243Vd12 = c8243Vd1.f;
                if (c8243Vd12 != null && c8243Vd1Arr[3].f != null) {
                    if (c16651le12.l0()) {
                        this.h.f = this.b.Y[2].f();
                        this.i.f = -this.b.Y[3].f();
                    } else {
                        C13476gI1 c13476gI1H = h(this.b.Y[2]);
                        if (c13476gI1H != null) {
                            b(this.h, c13476gI1H, this.b.Y[2].f());
                        }
                        C13476gI1 c13476gI1H2 = h(this.b.Y[3]);
                        if (c13476gI1H2 != null) {
                            b(this.i, c13476gI1H2, -this.b.Y[3].f());
                        }
                        this.h.b = true;
                        this.i.b = true;
                    }
                    if (this.b.a0()) {
                        b(this.k, this.h, this.b.r());
                        return;
                    }
                    return;
                }
                if (c8243Vd12 != null) {
                    C13476gI1 c13476gI1H3 = h(c8243Vd1);
                    if (c13476gI1H3 != null) {
                        b(this.h, c13476gI1H3, this.b.Y[2].f());
                        b(this.i, this.h, this.e.g);
                        if (this.b.a0()) {
                            b(this.k, this.h, this.b.r());
                            return;
                        }
                        return;
                    }
                    return;
                }
                C8243Vd1 c8243Vd13 = c8243Vd1Arr[3];
                if (c8243Vd13.f != null) {
                    C13476gI1 c13476gI1H4 = h(c8243Vd13);
                    if (c13476gI1H4 != null) {
                        b(this.i, c13476gI1H4, -this.b.Y[3].f());
                        b(this.h, this.i, -this.e.g);
                    }
                    if (this.b.a0()) {
                        b(this.k, this.h, this.b.r());
                        return;
                    }
                    return;
                }
                C8243Vd1 c8243Vd14 = c8243Vd1Arr[4];
                if (c8243Vd14.f != null) {
                    C13476gI1 c13476gI1H5 = h(c8243Vd14);
                    if (c13476gI1H5 != null) {
                        b(this.k, c13476gI1H5, 0);
                        b(this.h, this.k, -this.b.r());
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                }
                if ((c16651le12 instanceof InterfaceC17158mV2) || c16651le12.N() == null || this.b.q(C8243Vd1.b.CENTER).f != null) {
                    return;
                }
                b(this.h, this.b.N().f.h, this.b.Z());
                b(this.i, this.h, this.e.g);
                if (this.b.a0()) {
                    b(this.k, this.h, this.b.r());
                    return;
                }
                return;
            }
        }
        if (z || this.d != C16651le1.b.MATCH_CONSTRAINT) {
            gt1.b(this);
        } else {
            C16651le1 c16651le13 = this.b;
            int i = c16651le13.x;
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
            } else if (i == 3 && !c16651le13.l0()) {
                C16651le1 c16651le14 = this.b;
                if (c16651le14.w != 3) {
                    GT1 gt14 = c16651le14.e.e;
                    this.e.l.add(gt14);
                    gt14.k.add(this.e);
                    GT1 gt15 = this.e;
                    gt15.b = true;
                    gt15.k.add(this.h);
                    this.e.k.add(this.i);
                }
            }
        }
        C16651le1 c16651le15 = this.b;
        C8243Vd1[] c8243Vd1Arr2 = c16651le15.Y;
        C8243Vd1 c8243Vd15 = c8243Vd1Arr2[2];
        C8243Vd1 c8243Vd16 = c8243Vd15.f;
        if (c8243Vd16 != null && c8243Vd1Arr2[3].f != null) {
            if (c16651le15.l0()) {
                this.h.f = this.b.Y[2].f();
                this.i.f = -this.b.Y[3].f();
            } else {
                C13476gI1 c13476gI1H6 = h(this.b.Y[2]);
                C13476gI1 c13476gI1H7 = h(this.b.Y[3]);
                if (c13476gI1H6 != null) {
                    c13476gI1H6.b(this);
                }
                if (c13476gI1H7 != null) {
                    c13476gI1H7.b(this);
                }
                this.j = AbstractC15192j98.b.CENTER;
            }
            if (this.b.a0()) {
                c(this.k, this.h, 1, this.l);
            }
        } else if (c8243Vd16 != null) {
            C13476gI1 c13476gI1H8 = h(c8243Vd15);
            if (c13476gI1H8 != null) {
                b(this.h, c13476gI1H8, this.b.Y[2].f());
                c(this.i, this.h, 1, this.e);
                if (this.b.a0()) {
                    c(this.k, this.h, 1, this.l);
                }
                C16651le1.b bVar2 = this.d;
                C16651le1.b bVar3 = C16651le1.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.b.x() > 0.0f) {
                    RY2 ry2 = this.b.e;
                    if (ry2.d == bVar3) {
                        ry2.e.k.add(this.e);
                        this.e.l.add(this.b.e.e);
                        this.e.a = this;
                    }
                }
            }
        } else {
            C8243Vd1 c8243Vd17 = c8243Vd1Arr2[3];
            if (c8243Vd17.f != null) {
                C13476gI1 c13476gI1H9 = h(c8243Vd17);
                if (c13476gI1H9 != null) {
                    b(this.i, c13476gI1H9, -this.b.Y[3].f());
                    c(this.h, this.i, -1, this.e);
                    if (this.b.a0()) {
                        c(this.k, this.h, 1, this.l);
                    }
                }
            } else {
                C8243Vd1 c8243Vd18 = c8243Vd1Arr2[4];
                if (c8243Vd18.f != null) {
                    C13476gI1 c13476gI1H10 = h(c8243Vd18);
                    if (c13476gI1H10 != null) {
                        b(this.k, c13476gI1H10, 0);
                        c(this.h, this.k, -1, this.l);
                        c(this.i, this.h, 1, this.e);
                    }
                } else if (!(c16651le15 instanceof InterfaceC17158mV2) && c16651le15.N() != null) {
                    b(this.h, this.b.N().f.h, this.b.Z());
                    c(this.i, this.h, 1, this.e);
                    if (this.b.a0()) {
                        c(this.k, this.h, 1, this.l);
                    }
                    C16651le1.b bVar4 = this.d;
                    C16651le1.b bVar5 = C16651le1.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.b.x() > 0.0f) {
                        RY2 ry22 = this.b.e;
                        if (ry22.d == bVar5) {
                            ry22.e.k.add(this.e);
                            this.e.l.add(this.b.e.e);
                            this.e.a = this;
                        }
                    }
                }
            }
        }
        if (this.e.l.size() == 0) {
            this.e.c = true;
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    public void e() {
        C13476gI1 c13476gI1 = this.h;
        if (c13476gI1.j) {
            this.b.m1(c13476gI1.g);
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // ir.nasim.AbstractC15192j98
    boolean m() {
        return this.d != C16651le1.b.MATCH_CONSTRAINT || this.b.x == 0;
    }

    void q() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.k.c();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        return "VerticalRun " + this.b.v();
    }
}
