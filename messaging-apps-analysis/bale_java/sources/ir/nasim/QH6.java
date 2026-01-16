package ir.nasim;

import java.util.Iterator;

/* loaded from: classes.dex */
final class QH6 implements InterfaceC7991Ub1, Iterable, InterfaceC17915nm3 {
    private final C21850uE6 a;
    private final int b;
    private final VN2 c;
    private final PH6 d;
    private final Object e;
    private final Iterable f = this;

    public QH6(C21850uE6 c21850uE6, int i, VN2 vn2, PH6 ph6) {
        this.a = c21850uE6;
        this.b = i;
        this.d = ph6;
        this.e = Integer.valueOf(vn2.e());
    }

    @Override // ir.nasim.InterfaceC7518Sb1
    public Iterable f() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public Iterable getData() {
        return new NH6(this.a, this.b, this.c);
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public Object getKey() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public Object h() {
        return null;
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public String i() {
        return this.c.f();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new OH6(this.a, this.b, this.c, this.d);
    }

    @Override // ir.nasim.InterfaceC7991Ub1
    public Object j() {
        return this.d.a(this.a);
    }
}
