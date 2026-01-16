package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.pj7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19071pj7 implements InterfaceC23384wp6 {
    private final InterfaceC23384wp6 a;
    private final UA2 b;

    /* renamed from: ir.nasim.pj7$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;
        private int b = -1;
        private Object c;

        a() {
            this.a = C19071pj7.this.a.iterator();
        }

        private final void b() {
            if (this.a.hasNext()) {
                Object next = this.a.next();
                if (((Boolean) C19071pj7.this.b.invoke(next)).booleanValue()) {
                    this.b = 1;
                    this.c = next;
                    return;
                }
            }
            this.b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                b();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b == -1) {
                b();
            }
            if (this.b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.c;
            this.c = null;
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C19071pj7(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "sequence");
        AbstractC13042fc3.i(ua2, "predicate");
        this.a = interfaceC23384wp6;
        this.b = ua2;
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
