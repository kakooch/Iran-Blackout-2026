package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.oj7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18480oj7 implements InterfaceC23384wp6, InterfaceC19834r12 {
    private final InterfaceC23384wp6 a;
    private final int b;

    /* renamed from: ir.nasim.oj7$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private int a;
        private final Iterator b;

        a(C18480oj7 c18480oj7) {
            this.a = c18480oj7.b;
            this.b = c18480oj7.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0 && this.b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i = this.a;
            if (i == 0) {
                throw new NoSuchElementException();
            }
            this.a = i - 1;
            return this.b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C18480oj7(InterfaceC23384wp6 interfaceC23384wp6, int i) {
        AbstractC13042fc3.i(interfaceC23384wp6, "sequence");
        this.a = interfaceC23384wp6;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // ir.nasim.InterfaceC19834r12
    public InterfaceC23384wp6 a(int i) {
        int i2 = this.b;
        return i >= i2 ? AbstractC9962aq6.e() : new QZ6(this.a, i, i2);
    }

    @Override // ir.nasim.InterfaceC19834r12
    public InterfaceC23384wp6 b(int i) {
        return i >= this.b ? this : new C18480oj7(this.a, i);
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a(this);
    }
}
