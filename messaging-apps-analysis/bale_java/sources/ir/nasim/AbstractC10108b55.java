package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.b55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10108b55 implements Iterator, InterfaceC17915nm3 {
    private final AbstractC13273fw7[] a;
    private int b;
    private boolean c = true;

    public AbstractC10108b55(C12637ew7 c12637ew7, AbstractC13273fw7[] abstractC13273fw7Arr) {
        this.a = abstractC13273fw7Arr;
        abstractC13273fw7Arr[0].k(c12637ew7.p(), c12637ew7.m() * 2);
        this.b = 0;
        d();
    }

    private final void b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void d() {
        if (this.a[this.b].f()) {
            return;
        }
        for (int i = this.b; -1 < i; i--) {
            int iF = f(i);
            if (iF == -1 && this.a[i].g()) {
                this.a[i].i();
                iF = f(i);
            }
            if (iF != -1) {
                this.b = iF;
                return;
            }
            if (i > 0) {
                this.a[i - 1].i();
            }
            this.a[i].k(C12637ew7.e.a().p(), 0);
        }
        this.c = false;
    }

    private final int f(int i) {
        if (this.a[i].f()) {
            return i;
        }
        if (!this.a[i].g()) {
            return -1;
        }
        C12637ew7 c12637ew7C = this.a[i].c();
        if (i == 6) {
            this.a[i + 1].k(c12637ew7C.p(), c12637ew7C.p().length);
        } else {
            this.a[i + 1].k(c12637ew7C.p(), c12637ew7C.m() * 2);
        }
        return f(i + 1);
    }

    protected final Object c() {
        b();
        return this.a[this.b].b();
    }

    protected final AbstractC13273fw7[] e() {
        return this.a;
    }

    protected final void g(int i) {
        this.b = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // java.util.Iterator
    public Object next() {
        b();
        Object next = this.a[this.b].next();
        d();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
