package ir.nasim;

import ir.nasim.C16651le1;
import ir.nasim.C8243Vd1;

/* renamed from: ir.nasim.j98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15192j98 implements InterfaceC10842cI1 {
    public int a;
    C16651le1 b;
    C15170j76 c;
    protected C16651le1.b d;
    GT1 e = new GT1(this);
    public int f = 0;
    boolean g = false;
    public C13476gI1 h = new C13476gI1(this);
    public C13476gI1 i = new C13476gI1(this);
    protected b j = b.NONE;

    /* renamed from: ir.nasim.j98$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C8243Vd1.b.values().length];
            a = iArr;
            try {
                iArr[C8243Vd1.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C8243Vd1.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[C8243Vd1.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[C8243Vd1.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[C8243Vd1.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: ir.nasim.j98$b */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public AbstractC15192j98(C16651le1 c16651le1) {
        this.b = c16651le1;
    }

    private void l(int i, int i2) {
        int i3 = this.a;
        if (i3 == 0) {
            this.e.d(g(i2, i));
            return;
        }
        if (i3 == 1) {
            this.e.d(Math.min(g(this.e.m, i), i2));
            return;
        }
        if (i3 == 2) {
            C16651le1 c16651le1N = this.b.N();
            if (c16651le1N != null) {
                if ((i == 0 ? c16651le1N.e : c16651le1N.f).e.j) {
                    C16651le1 c16651le1 = this.b;
                    this.e.d(g((int) ((r9.g * (i == 0 ? c16651le1.B : c16651le1.E)) + 0.5f), i));
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        C16651le1 c16651le12 = this.b;
        AbstractC15192j98 abstractC15192j98 = c16651le12.e;
        C16651le1.b bVar = abstractC15192j98.d;
        C16651le1.b bVar2 = C16651le1.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && abstractC15192j98.a == 3) {
            C17727nS7 c17727nS7 = c16651le12.f;
            if (c17727nS7.d == bVar2 && c17727nS7.a == 3) {
                return;
            }
        }
        if (i == 0) {
            abstractC15192j98 = c16651le12.f;
        }
        if (abstractC15192j98.e.j) {
            float fX = c16651le12.x();
            this.e.d(i == 1 ? (int) ((abstractC15192j98.e.g / fX) + 0.5f) : (int) ((fX * abstractC15192j98.e.g) + 0.5f));
        }
    }

    @Override // ir.nasim.InterfaceC10842cI1
    public abstract void a(InterfaceC10842cI1 interfaceC10842cI1);

    protected final void b(C13476gI1 c13476gI1, C13476gI1 c13476gI12, int i) {
        c13476gI1.l.add(c13476gI12);
        c13476gI1.f = i;
        c13476gI12.k.add(c13476gI1);
    }

    protected final void c(C13476gI1 c13476gI1, C13476gI1 c13476gI12, int i, GT1 gt1) {
        c13476gI1.l.add(c13476gI12);
        c13476gI1.l.add(this.e);
        c13476gI1.h = i;
        c13476gI1.i = gt1;
        c13476gI12.k.add(c13476gI1);
        gt1.k.add(c13476gI1);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i, int i2) {
        int iMax;
        if (i2 == 0) {
            C16651le1 c16651le1 = this.b;
            int i3 = c16651le1.A;
            iMax = Math.max(c16651le1.z, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax == i) {
                return i;
            }
        } else {
            C16651le1 c16651le12 = this.b;
            int i4 = c16651le12.D;
            iMax = Math.max(c16651le12.C, i);
            if (i4 > 0) {
                iMax = Math.min(i4, i);
            }
            if (iMax == i) {
                return i;
            }
        }
        return iMax;
    }

    protected final C13476gI1 h(C8243Vd1 c8243Vd1) {
        C8243Vd1 c8243Vd12 = c8243Vd1.f;
        if (c8243Vd12 == null) {
            return null;
        }
        C16651le1 c16651le1 = c8243Vd12.d;
        int i = a.a[c8243Vd12.e.ordinal()];
        if (i == 1) {
            return c16651le1.e.h;
        }
        if (i == 2) {
            return c16651le1.e.i;
        }
        if (i == 3) {
            return c16651le1.f.h;
        }
        if (i == 4) {
            return c16651le1.f.k;
        }
        if (i != 5) {
            return null;
        }
        return c16651le1.f.i;
    }

    protected final C13476gI1 i(C8243Vd1 c8243Vd1, int i) {
        C8243Vd1 c8243Vd12 = c8243Vd1.f;
        if (c8243Vd12 == null) {
            return null;
        }
        C16651le1 c16651le1 = c8243Vd12.d;
        AbstractC15192j98 abstractC15192j98 = i == 0 ? c16651le1.e : c16651le1.f;
        int i2 = a.a[c8243Vd12.e.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return abstractC15192j98.i;
        }
        return abstractC15192j98.h;
    }

    public long j() {
        if (this.e.j) {
            return r0.g;
        }
        return 0L;
    }

    public boolean k() {
        return this.g;
    }

    abstract boolean m();

    protected void n(InterfaceC10842cI1 interfaceC10842cI1, C8243Vd1 c8243Vd1, C8243Vd1 c8243Vd12, int i) {
        C13476gI1 c13476gI1H = h(c8243Vd1);
        C13476gI1 c13476gI1H2 = h(c8243Vd12);
        if (c13476gI1H.j && c13476gI1H2.j) {
            int iF = c13476gI1H.g + c8243Vd1.f();
            int iF2 = c13476gI1H2.g - c8243Vd12.f();
            int i2 = iF2 - iF;
            if (!this.e.j && this.d == C16651le1.b.MATCH_CONSTRAINT) {
                l(i, i2);
            }
            GT1 gt1 = this.e;
            if (gt1.j) {
                if (gt1.g == i2) {
                    this.h.d(iF);
                    this.i.d(iF2);
                    return;
                }
                C16651le1 c16651le1 = this.b;
                float fA = i == 0 ? c16651le1.A() : c16651le1.S();
                if (c13476gI1H == c13476gI1H2) {
                    iF = c13476gI1H.g;
                    iF2 = c13476gI1H2.g;
                    fA = 0.5f;
                }
                this.h.d((int) (iF + 0.5f + (((iF2 - iF) - this.e.g) * fA)));
                this.i.d(this.h.g + this.e.g);
            }
        }
    }

    protected void o(InterfaceC10842cI1 interfaceC10842cI1) {
    }

    protected void p(InterfaceC10842cI1 interfaceC10842cI1) {
    }
}
