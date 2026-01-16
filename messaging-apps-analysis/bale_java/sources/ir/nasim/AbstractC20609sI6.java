package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.sI6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC20609sI6 {

    /* renamed from: ir.nasim.sI6$a */
    public static final class a extends AbstractC18386oa3 {
        private int a;
        final /* synthetic */ C19409qI6 b;

        a(C19409qI6 c19409qI6) {
            this.b = c19409qI6;
        }

        @Override // ir.nasim.AbstractC18386oa3
        public int b() {
            C19409qI6 c19409qI6 = this.b;
            int i = this.a;
            this.a = i + 1;
            return c19409qI6.k(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.o();
        }
    }

    /* renamed from: ir.nasim.sI6$b */
    public static final class b implements Iterator, InterfaceC17915nm3 {
        private int a;
        final /* synthetic */ C19409qI6 b;

        b(C19409qI6 c19409qI6) {
            this.b = c19409qI6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.o();
        }

        @Override // java.util.Iterator
        public Object next() {
            C19409qI6 c19409qI6 = this.b;
            int i = this.a;
            this.a = i + 1;
            return c19409qI6.p(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final AbstractC18386oa3 a(C19409qI6 c19409qI6) {
        AbstractC13042fc3.i(c19409qI6, "<this>");
        return new a(c19409qI6);
    }

    public static final Iterator b(C19409qI6 c19409qI6) {
        AbstractC13042fc3.i(c19409qI6, "<this>");
        return new b(c19409qI6);
    }
}
