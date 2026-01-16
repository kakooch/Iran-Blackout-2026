package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.rv7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20391rv7 implements InterfaceC23384wp6 {
    private final InterfaceC23384wp6 a;
    private final UA2 b;

    /* renamed from: ir.nasim.rv7$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;

        a() {
            this.a = C20391rv7.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return C20391rv7.this.b.invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C20391rv7(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "sequence");
        AbstractC13042fc3.i(ua2, "transformer");
        this.a = interfaceC23384wp6;
        this.b = ua2;
    }

    public final InterfaceC23384wp6 e(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "iterator");
        return new C5967Lp2(this.a, this.b, ua2);
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
