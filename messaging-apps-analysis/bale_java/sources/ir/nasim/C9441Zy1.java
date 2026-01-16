package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.Zy1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C9441Zy1 implements Iterable, Iterator, InterfaceC17915nm3 {
    private final C21850uE6 a;
    private final int b;
    private final int c;
    private int d;

    public C9441Zy1(C21850uE6 c21850uE6, int i) {
        this.a = c21850uE6;
        int i2 = c21850uE6.I()[(i * 5) + 4];
        this.b = i2;
        int i3 = i + 1;
        this.c = i3 < c21850uE6.L() ? c21850uE6.I()[(i3 * 5) + 4] : c21850uE6.O();
        this.d = i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.d < this.c;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.d;
        Object obj = (i < 0 || i >= this.a.N().length) ? null : this.a.N()[this.d];
        this.d++;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this;
    }
}
