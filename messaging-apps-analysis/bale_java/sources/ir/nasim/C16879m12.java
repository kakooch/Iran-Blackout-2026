package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.m12, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16879m12 implements InterfaceC23384wp6, InterfaceC19834r12 {
    private final InterfaceC23384wp6 a;
    private final int b;

    /* renamed from: ir.nasim.m12$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;
        private int b;

        a(C16879m12 c16879m12) {
            this.a = c16879m12.a.iterator();
            this.b = c16879m12.b;
        }

        private final void b() {
            while (this.b > 0 && this.a.hasNext()) {
                this.a.next();
                this.b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            b();
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C16879m12(InterfaceC23384wp6 interfaceC23384wp6, int i) {
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
        int i2 = this.b + i;
        return i2 < 0 ? new C16879m12(this, i) : new C16879m12(this.a, i2);
    }

    @Override // ir.nasim.InterfaceC19834r12
    public InterfaceC23384wp6 b(int i) {
        int i2 = this.b;
        int i3 = i2 + i;
        return i3 < 0 ? new C18480oj7(this, i) : new QZ6(this.a, i2, i3);
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a(this);
    }
}
