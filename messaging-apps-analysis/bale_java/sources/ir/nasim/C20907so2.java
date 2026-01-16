package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.so2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20907so2 implements InterfaceC23384wp6 {
    private final InterfaceC23384wp6 a;
    private final boolean b;
    private final UA2 c;

    /* renamed from: ir.nasim.so2$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;
        private int b = -1;
        private Object c;

        a() {
            this.a = C20907so2.this.a.iterator();
        }

        private final void b() {
            while (this.a.hasNext()) {
                Object next = this.a.next();
                if (((Boolean) C20907so2.this.c.invoke(next)).booleanValue() == C20907so2.this.b) {
                    this.c = next;
                    this.b = 1;
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

    public C20907so2(InterfaceC23384wp6 interfaceC23384wp6, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "sequence");
        AbstractC13042fc3.i(ua2, "predicate");
        this.a = interfaceC23384wp6;
        this.b = z;
        this.c = ua2;
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
