package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
public abstract class Y0 implements Iterator, InterfaceC17915nm3 {
    private int a;
    private Object b;

    private final boolean e() {
        this.a = 3;
        b();
        return this.a == 1;
    }

    protected abstract void b();

    protected final void c() {
        this.a = 2;
    }

    protected final void d(Object obj) {
        this.b = obj;
        this.a = 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.a;
        if (i == 0) {
            return e();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.a;
        if (i == 1) {
            this.a = 0;
            return this.b;
        }
        if (i == 2 || !e()) {
            throw new NoSuchElementException();
        }
        this.a = 0;
        return this.b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
