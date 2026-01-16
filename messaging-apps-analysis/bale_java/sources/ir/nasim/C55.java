package ir.nasim;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class C55 extends AbstractC12676f1 implements ListIterator, InterfaceC17915nm3 {
    private final C24129y55 c;
    private int d;
    private C12046dw7 e;
    private int f;

    public C55(C24129y55 c24129y55, int i) {
        super(i, c24129y55.size());
        this.c = c24129y55;
        this.d = c24129y55.F();
        this.f = -1;
        l();
    }

    private final void h() {
        if (this.d != this.c.F()) {
            throw new ConcurrentModificationException();
        }
    }

    private final void i() {
        if (this.f == -1) {
            throw new IllegalStateException();
        }
    }

    private final void k() {
        g(this.c.size());
        this.d = this.c.F();
        this.f = -1;
        l();
    }

    private final void l() {
        Object[] objArrL = this.c.L();
        if (objArrL == null) {
            this.e = null;
            return;
        }
        int iD = AbstractC24298yN7.d(this.c.size());
        int i = AbstractC23053wG5.i(d(), iD);
        int iN = (this.c.N() / 5) + 1;
        C12046dw7 c12046dw7 = this.e;
        if (c12046dw7 == null) {
            this.e = new C12046dw7(objArrL, i, iD, iN);
        } else {
            AbstractC13042fc3.f(c12046dw7);
            c12046dw7.l(objArrL, i, iD, iN);
        }
    }

    @Override // ir.nasim.AbstractC12676f1, java.util.ListIterator
    public void add(Object obj) {
        h();
        this.c.add(d(), obj);
        f(d() + 1);
        k();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        h();
        b();
        this.f = d();
        C12046dw7 c12046dw7 = this.e;
        if (c12046dw7 == null) {
            Object[] objArrO = this.c.O();
            int iD = d();
            f(iD + 1);
            return objArrO[iD];
        }
        if (c12046dw7.hasNext()) {
            f(d() + 1);
            return c12046dw7.next();
        }
        Object[] objArrO2 = this.c.O();
        int iD2 = d();
        f(iD2 + 1);
        return objArrO2[iD2 - c12046dw7.e()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        h();
        c();
        this.f = d() - 1;
        C12046dw7 c12046dw7 = this.e;
        if (c12046dw7 == null) {
            Object[] objArrO = this.c.O();
            f(d() - 1);
            return objArrO[d()];
        }
        if (d() <= c12046dw7.e()) {
            f(d() - 1);
            return c12046dw7.previous();
        }
        Object[] objArrO2 = this.c.O();
        f(d() - 1);
        return objArrO2[d() - c12046dw7.e()];
    }

    @Override // ir.nasim.AbstractC12676f1, java.util.ListIterator, java.util.Iterator
    public void remove() {
        h();
        i();
        this.c.remove(this.f);
        if (this.f < d()) {
            f(this.f);
        }
        k();
    }

    @Override // ir.nasim.AbstractC12676f1, java.util.ListIterator
    public void set(Object obj) {
        h();
        i();
        this.c.set(this.f, obj);
        this.d = this.c.F();
        l();
    }
}
