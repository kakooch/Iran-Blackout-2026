package ir.nasim;

import ir.nasim.InterfaceC6693Oo5;

/* loaded from: classes.dex */
public final class MA3 {
    private final InterfaceC23241wb3 a;
    private final int b = 1;
    private final int c = 2;
    private final int d = 4;
    private final InterfaceC17916nm4 e = UG6.a(0);

    static final class a implements InterfaceC4806Gq2 {
        final /* synthetic */ C3587Bm4 a;
        final /* synthetic */ MA3 b;

        a(C3587Bm4 c3587Bm4, MA3 ma3) {
            this.a = c3587Bm4;
            this.b = ma3;
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
            int i;
            if (interfaceC22645vb3 instanceof C12403eZ2 ? true : interfaceC22645vb3 instanceof C23400wr2 ? true : interfaceC22645vb3 instanceof InterfaceC6693Oo5.b) {
                this.a.n(interfaceC22645vb3);
            } else if (interfaceC22645vb3 instanceof C13012fZ2) {
                this.a.y(((C13012fZ2) interfaceC22645vb3).a());
            } else if (interfaceC22645vb3 instanceof C23990xr2) {
                this.a.y(((C23990xr2) interfaceC22645vb3).a());
            } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.c) {
                this.a.y(((InterfaceC6693Oo5.c) interfaceC22645vb3).a());
            } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.a) {
                this.a.y(((InterfaceC6693Oo5.a) interfaceC22645vb3).a());
            }
            C3587Bm4 c3587Bm4 = this.a;
            MA3 ma3 = this.b;
            Object[] objArr = c3587Bm4.a;
            int i2 = c3587Bm4.b;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                InterfaceC22645vb3 interfaceC22645vb32 = (InterfaceC22645vb3) objArr[i4];
                if (interfaceC22645vb32 instanceof C12403eZ2) {
                    i = ma3.c;
                } else if (interfaceC22645vb32 instanceof C23400wr2) {
                    i = ma3.b;
                } else if (interfaceC22645vb32 instanceof InterfaceC6693Oo5.b) {
                    i = ma3.d;
                }
                i3 |= i;
            }
            this.b.e.h(i3);
            return C19938rB7.a;
        }
    }

    public MA3(InterfaceC23241wb3 interfaceC23241wb3) {
        this.a = interfaceC23241wb3;
    }

    public final Object e(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.a.b().b(new a(new C3587Bm4(0, 1, null), this), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public final boolean f() {
        return (this.e.d() & this.b) != 0;
    }

    public final boolean g() {
        return (this.e.d() & this.c) != 0;
    }

    public final boolean h() {
        return (this.e.d() & this.d) != 0;
    }
}
