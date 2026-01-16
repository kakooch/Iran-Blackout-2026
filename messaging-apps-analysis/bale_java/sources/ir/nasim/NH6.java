package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
final class NH6 implements Iterable, Iterator, InterfaceC17915nm3 {
    private final C21850uE6 a;
    private final int b;
    private final int c;
    private final int d;
    private final C6108Mf0 e;
    private int f;

    public NH6(C21850uE6 c21850uE6, int i, VN2 vn2) {
        this.a = c21850uE6;
        int i2 = c21850uE6.I()[(i * 5) + 4];
        this.b = i2;
        this.c = vn2.c();
        int iB = vn2.b();
        if (iB <= 0) {
            int i3 = i + 1;
            iB = (i3 < c21850uE6.L() ? c21850uE6.I()[(i3 * 5) + 4] : c21850uE6.O()) - i2;
        }
        this.d = iB;
        C6108Mf0 c6108Mf0 = new C6108Mf0();
        ArrayList arrayListD = vn2.d();
        if (arrayListD != null) {
            int size = arrayListD.size();
            for (int i4 = 0; i4 < size; i4++) {
                Object obj = arrayListD.get(i4);
                if (obj instanceof VN2) {
                    VN2 vn22 = (VN2) obj;
                    c6108Mf0.e(vn22.c(), vn22.b());
                }
            }
        }
        this.e = c6108Mf0;
        this.f = c6108Mf0.c(this.c);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f < this.d;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.d;
        int i2 = this.f;
        Object obj = (i2 < 0 || i2 >= i) ? null : this.a.N()[this.b + this.f];
        this.f = this.e.c(this.f + 1);
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
