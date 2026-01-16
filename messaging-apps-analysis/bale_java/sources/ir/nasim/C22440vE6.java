package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.vE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C22440vE6 implements InterfaceC7991Ub1, Iterable, InterfaceC17915nm3 {
    private final C21850uE6 a;
    private final int b;
    private final int c;

    public C22440vE6(C21850uE6 c21850uE6, int i, int i2) {
        this.a = c21850uE6;
        this.b = i;
        this.c = i2;
    }

    private final void o() {
        if (this.a.Q() != this.c) {
            AbstractC23036wE6.v();
        }
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public Iterable getData() {
        this.a.a0(this.b);
        return new C9441Zy1(this.a, this.b);
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public Object getKey() {
        if ((this.a.I()[(this.b * 5) + 1] & 536870912) == 0) {
            return Integer.valueOf(this.a.I()[this.b * 5]);
        }
        Object obj = this.a.N()[AbstractC23036wE6.s(this.a.I(), this.b)];
        AbstractC13042fc3.f(obj);
        return obj;
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public Object h() {
        if ((this.a.I()[(this.b * 5) + 1] & 1073741824) != 0) {
            return this.a.N()[this.a.I()[(this.b * 5) + 4]];
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public String i() {
        int[] iArrI = this.a.I();
        int i = this.b;
        if ((iArrI[(i * 5) + 1] & 268435456) == 0) {
            this.a.a0(i);
            return null;
        }
        Object obj = this.a.N()[AbstractC23036wE6.n(this.a.I(), this.b)];
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        o();
        this.a.a0(this.b);
        C21850uE6 c21850uE6 = this.a;
        int i = this.b;
        return new C19441qM2(c21850uE6, i + 1, i + AbstractC23036wE6.p(c21850uE6.I(), this.b));
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public Object j() {
        o();
        C21176tE6 c21176tE6V = this.a.V();
        try {
            return c21176tE6V.a(this.b);
        } finally {
            c21176tE6V.d();
        }
    }

    @Override // ir.nasim.InterfaceC7518Sb1
    public Iterable f() {
        return this;
    }
}
