package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.qM2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C19441qM2 implements Iterator, InterfaceC17915nm3 {
    private final C21850uE6 a;
    private final int b;
    private int c;
    private final int d;

    public C19441qM2(C21850uE6 c21850uE6, int i, int i2) {
        this.a = c21850uE6;
        this.b = i2;
        this.c = i;
        this.d = c21850uE6.Q();
        if (c21850uE6.R()) {
            AbstractC23036wE6.v();
        }
    }

    private final void c() {
        if (this.a.Q() != this.d) {
            AbstractC23036wE6.v();
        }
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC7991Ub1 next() {
        c();
        int i = this.c;
        this.c = AbstractC23036wE6.p(this.a.I(), i) + i;
        return new C22440vE6(this.a, i, this.d);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c < this.b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
