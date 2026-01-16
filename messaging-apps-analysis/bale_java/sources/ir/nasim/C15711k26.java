package ir.nasim;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* renamed from: ir.nasim.k26, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C15711k26 extends AbstractC11442d1 implements RandomAccess {
    private final Object[] a;
    private final int b;
    private int c;
    private int d;

    /* renamed from: ir.nasim.k26$a */
    public static final class a extends Y0 {
        private int c;
        private int d;

        a() {
            this.c = C15711k26.this.size();
            this.d = C15711k26.this.c;
        }

        @Override // ir.nasim.Y0
        protected void b() {
            if (this.c == 0) {
                c();
                return;
            }
            d(C15711k26.this.a[this.d]);
            this.d = (this.d + 1) % C15711k26.this.b;
            this.c--;
        }
    }

    public C15711k26(Object[] objArr, int i) {
        AbstractC13042fc3.i(objArr, "buffer");
        this.a = objArr;
        if (i < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
        }
        if (i <= objArr.length) {
            this.b = objArr.length;
            this.d = i;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + objArr.length).toString());
    }

    public final void E(Object obj) {
        if (L()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.a[(this.c + size()) % this.b] = obj;
        this.d = size() + 1;
    }

    public final C15711k26 F(int i) {
        Object[] array;
        int i2 = this.b;
        int i3 = AbstractC23053wG5.i(i2 + (i2 >> 1) + 1, i);
        if (this.c == 0) {
            array = Arrays.copyOf(this.a, i3);
            AbstractC13042fc3.h(array, "copyOf(...)");
        } else {
            array = toArray(new Object[i3]);
        }
        return new C15711k26(array, size());
    }

    public final boolean L() {
        return size() == this.b;
    }

    public final void N(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
        if (i > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        if (i > 0) {
            int i2 = this.c;
            int i3 = (i2 + i) % this.b;
            if (i2 > i3) {
                AbstractC9648aK.v(this.a, null, i2, this.b);
                AbstractC9648aK.v(this.a, null, 0, i3);
            } else {
                AbstractC9648aK.v(this.a, null, i2, i3);
            }
            this.c = i3;
            this.d = size() - i;
        }
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public Object get(int i) {
        AbstractC11442d1.Companion.b(i, size());
        return this.a[(this.c + i) % this.b];
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new a();
    }

    @Override // ir.nasim.G0, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "array");
        if (objArr.length < size()) {
            objArr = Arrays.copyOf(objArr, size());
            AbstractC13042fc3.h(objArr, "copyOf(...)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.c; i2 < size && i3 < this.b; i3++) {
            objArr[i2] = this.a[i3];
            i2++;
        }
        while (i2 < size) {
            objArr[i2] = this.a[i];
            i2++;
            i++;
        }
        return AbstractC9766aX0.f(size, objArr);
    }

    public C15711k26(int i) {
        this(new Object[i], 0);
    }

    @Override // ir.nasim.G0, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
