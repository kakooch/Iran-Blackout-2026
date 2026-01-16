package ir.nasim;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.f1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC12676f1 implements ListIterator, InterfaceC17915nm3 {
    private int a;
    private int b;

    public AbstractC12676f1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    public final void c() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final void f(int i) {
        this.a = i;
    }

    public final void g(int i) {
        this.b = i;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.a > 0;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.a;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
