package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
final class PE2 implements InterfaceC23384wp6 {
    private final SA2 a;
    private final UA2 b;

    public static final class a implements Iterator, InterfaceC17915nm3 {
        private Object a;
        private int b = -2;

        a() {
        }

        private final void b() {
            Object objInvoke;
            if (this.b == -2) {
                objInvoke = PE2.this.a.invoke();
            } else {
                UA2 ua2 = PE2.this.b;
                Object obj = this.a;
                AbstractC13042fc3.f(obj);
                objInvoke = ua2.invoke(obj);
            }
            this.a = objInvoke;
            this.b = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b < 0) {
                b();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b < 0) {
                b();
            }
            if (this.b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.a;
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public PE2(SA2 sa2, UA2 ua2) {
        AbstractC13042fc3.i(sa2, "getInitialValue");
        AbstractC13042fc3.i(ua2, "getNextValue");
        this.a = sa2;
        this.b = ua2;
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
