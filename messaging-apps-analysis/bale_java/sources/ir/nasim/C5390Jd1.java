package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.Jd1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C5390Jd1 implements Iterable {
    private static final C5390Jd1 d = new C5390Jd1();
    final Object a;
    final C5390Jd1 b;
    private final int c;

    /* renamed from: ir.nasim.Jd1$a */
    private static class a implements Iterator {
        private C5390Jd1 a;

        public a(C5390Jd1 c5390Jd1) {
            this.a = c5390Jd1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.c > 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            C5390Jd1 c5390Jd1 = this.a;
            Object obj = c5390Jd1.a;
            this.a = c5390Jd1.b;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private C5390Jd1() {
        this.c = 0;
        this.a = null;
        this.b = null;
    }

    public static C5390Jd1 h() {
        return d;
    }

    private Iterator i(int i) {
        return new a(t(i));
    }

    private C5390Jd1 o(Object obj) {
        if (this.c == 0) {
            return this;
        }
        if (this.a.equals(obj)) {
            return this.b;
        }
        C5390Jd1 c5390Jd1O = this.b.o(obj);
        return c5390Jd1O == this.b ? this : new C5390Jd1(this.a, c5390Jd1O);
    }

    private C5390Jd1 t(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException();
        }
        return i == 0 ? this : this.b.t(i - 1);
    }

    public Object get(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return i(i).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return i(0);
    }

    public C5390Jd1 j(int i) {
        return o(get(i));
    }

    public C5390Jd1 r(Object obj) {
        return new C5390Jd1(obj, this);
    }

    public int size() {
        return this.c;
    }

    private C5390Jd1(Object obj, C5390Jd1 c5390Jd1) {
        this.a = obj;
        this.b = c5390Jd1;
        this.c = c5390Jd1.c + 1;
    }
}
