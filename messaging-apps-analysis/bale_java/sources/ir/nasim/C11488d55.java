package ir.nasim;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* renamed from: ir.nasim.d55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C11488d55 extends AbstractC10108b55 implements Iterator, InterfaceC17915nm3 {
    private final AbstractC10724c55 d;
    private Object e;
    private boolean f;
    private int g;

    public C11488d55(AbstractC10724c55 abstractC10724c55, AbstractC13273fw7[] abstractC13273fw7Arr) {
        super(abstractC10724c55.h(), abstractC13273fw7Arr);
        this.d = abstractC10724c55;
        this.g = abstractC10724c55.g();
    }

    private final void h() {
        if (this.d.g() != this.g) {
            throw new ConcurrentModificationException();
        }
    }

    private final void i() {
        if (!this.f) {
            throw new IllegalStateException();
        }
    }

    private final void k(int i, C12637ew7 c12637ew7, Object obj, int i2) {
        int i3 = i2 * 5;
        if (i3 > 30) {
            e()[i2].l(c12637ew7.p(), c12637ew7.p().length, 0);
            while (!AbstractC13042fc3.d(e()[i2].b(), obj)) {
                e()[i2].h();
            }
            g(i2);
            return;
        }
        int iF = 1 << AbstractC15064iw7.f(i, i3);
        if (c12637ew7.q(iF)) {
            e()[i2].l(c12637ew7.p(), c12637ew7.m() * 2, c12637ew7.n(iF));
            g(i2);
        } else {
            int iO = c12637ew7.O(iF);
            C12637ew7 c12637ew7N = c12637ew7.N(iO);
            e()[i2].l(c12637ew7.p(), c12637ew7.m() * 2, iO);
            k(i, c12637ew7N, obj, i2 + 1);
        }
    }

    public final void l(Object obj, Object obj2) {
        if (this.d.containsKey(obj)) {
            if (hasNext()) {
                Object objC = c();
                this.d.put(obj, obj2);
                k(objC != null ? objC.hashCode() : 0, this.d.h(), objC, 0);
            } else {
                this.d.put(obj, obj2);
            }
            this.g = this.d.g();
        }
    }

    @Override // ir.nasim.AbstractC10108b55, java.util.Iterator
    public Object next() {
        h();
        this.e = c();
        this.f = true;
        return super.next();
    }

    @Override // ir.nasim.AbstractC10108b55, java.util.Iterator
    public void remove() {
        i();
        if (hasNext()) {
            Object objC = c();
            AbstractC19810qy7.d(this.d).remove(this.e);
            k(objC != null ? objC.hashCode() : 0, this.d.h(), objC, 0);
        } else {
            AbstractC19810qy7.d(this.d).remove(this.e);
        }
        this.e = null;
        this.f = false;
        this.g = this.d.g();
    }
}
