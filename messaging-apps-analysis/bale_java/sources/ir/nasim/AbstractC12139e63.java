package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.e63, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC12139e63 implements Iterator, InterfaceC17915nm3 {
    private int a;
    private int b;
    private boolean c;

    public AbstractC12139e63(int i) {
        this.a = i;
    }

    protected abstract Object b(int i);

    protected abstract void c(int i);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objB = b(this.b);
        this.b++;
        this.c = true;
        return objB;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.c) {
            AbstractC22970w76.b("Call next() before removing an element.");
        }
        int i = this.b - 1;
        this.b = i;
        c(i);
        this.a--;
        this.c = false;
    }
}
