package ir.nasim;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;

/* loaded from: classes8.dex */
public final class B55 extends AbstractC12085e1 implements ListIterator, InterfaceC17915nm3 {
    private final C23539x55 c;
    private int d;
    private C11403cw7 e;
    private int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B55(C23539x55 c23539x55, int i) {
        super(i, c23539x55.size());
        AbstractC13042fc3.i(c23539x55, "builder");
        this.c = c23539x55;
        this.d = c23539x55.F();
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
        int iC = AbstractC23708xN7.c(this.c.size());
        int i = AbstractC23053wG5.i(d(), iC);
        int iN = (this.c.N() / 5) + 1;
        C11403cw7 c11403cw7 = this.e;
        if (c11403cw7 == null) {
            this.e = new C11403cw7(objArrL, i, iC, iN);
        } else {
            AbstractC13042fc3.f(c11403cw7);
            c11403cw7.l(objArrL, i, iC, iN);
        }
    }

    @Override // ir.nasim.AbstractC12085e1, java.util.ListIterator
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
        C11403cw7 c11403cw7 = this.e;
        if (c11403cw7 == null) {
            Object[] objArrO = this.c.O();
            int iD = d();
            f(iD + 1);
            return objArrO[iD];
        }
        if (c11403cw7.hasNext()) {
            f(d() + 1);
            return c11403cw7.next();
        }
        Object[] objArrO2 = this.c.O();
        int iD2 = d();
        f(iD2 + 1);
        return objArrO2[iD2 - c11403cw7.e()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        h();
        c();
        this.f = d() - 1;
        C11403cw7 c11403cw7 = this.e;
        if (c11403cw7 == null) {
            Object[] objArrO = this.c.O();
            f(d() - 1);
            return objArrO[d()];
        }
        if (d() <= c11403cw7.e()) {
            f(d() - 1);
            return c11403cw7.previous();
        }
        Object[] objArrO2 = this.c.O();
        f(d() - 1);
        return objArrO2[d() - c11403cw7.e()];
    }

    @Override // ir.nasim.AbstractC12085e1, java.util.ListIterator, java.util.Iterator
    public void remove() {
        h();
        i();
        this.c.remove(this.f);
        if (this.f < d()) {
            f(this.f);
        }
        k();
    }

    @Override // ir.nasim.AbstractC12085e1, java.util.ListIterator
    public void set(Object obj) {
        h();
        i();
        this.c.set(this.f, obj);
        this.d = this.c.F();
        l();
    }
}
