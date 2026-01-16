package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.qv7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19782qv7 implements InterfaceC23384wp6 {
    private final InterfaceC23384wp6 a;
    private final InterfaceC14603iB2 b;

    /* renamed from: ir.nasim.qv7$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;
        private int b;

        a() {
            this.a = C19782qv7.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            InterfaceC14603iB2 interfaceC14603iB2 = C19782qv7.this.b;
            int i = this.b;
            this.b = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            return interfaceC14603iB2.invoke(Integer.valueOf(i), this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C19782qv7(InterfaceC23384wp6 interfaceC23384wp6, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "sequence");
        AbstractC13042fc3.i(interfaceC14603iB2, "transformer");
        this.a = interfaceC23384wp6;
        this.b = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
