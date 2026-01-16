package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
public final class QZ6 implements InterfaceC23384wp6, InterfaceC19834r12 {
    private final InterfaceC23384wp6 a;
    private final int b;
    private final int c;

    public static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;
        private int b;

        a() {
            this.a = QZ6.this.a.iterator();
        }

        private final void b() {
            while (this.b < QZ6.this.b && this.a.hasNext()) {
                this.a.next();
                this.b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.b < QZ6.this.c && this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            b();
            if (this.b >= QZ6.this.c) {
                throw new NoSuchElementException();
            }
            this.b++;
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public QZ6(InterfaceC23384wp6 interfaceC23384wp6, int i, int i2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "sequence");
        this.a = interfaceC23384wp6;
        this.b = i;
        this.c = i2;
        if (i < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        if (i2 >= i) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
    }

    private final int f() {
        return this.c - this.b;
    }

    @Override // ir.nasim.InterfaceC19834r12
    public InterfaceC23384wp6 a(int i) {
        return i >= f() ? AbstractC9962aq6.e() : new QZ6(this.a, this.b + i, this.c);
    }

    @Override // ir.nasim.InterfaceC19834r12
    public InterfaceC23384wp6 b(int i) {
        if (i >= f()) {
            return this;
        }
        InterfaceC23384wp6 interfaceC23384wp6 = this.a;
        int i2 = this.b;
        return new QZ6(interfaceC23384wp6, i2, i + i2);
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
