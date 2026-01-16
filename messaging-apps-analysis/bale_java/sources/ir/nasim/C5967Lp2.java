package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.Lp2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5967Lp2 implements InterfaceC23384wp6 {
    private final InterfaceC23384wp6 a;
    private final UA2 b;
    private final UA2 c;

    /* renamed from: ir.nasim.Lp2$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;
        private Iterator b;
        private int c;

        a() {
            this.a = C5967Lp2.this.a.iterator();
        }

        private final boolean b() {
            Iterator it = this.b;
            if (it != null && it.hasNext()) {
                this.c = 1;
                return true;
            }
            while (this.a.hasNext()) {
                Iterator it2 = (Iterator) C5967Lp2.this.c.invoke(C5967Lp2.this.b.invoke(this.a.next()));
                if (it2.hasNext()) {
                    this.b = it2;
                    this.c = 1;
                    return true;
                }
            }
            this.c = 2;
            this.b = null;
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.c;
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            return b();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i = this.c;
            if (i == 2) {
                throw new NoSuchElementException();
            }
            if (i == 0 && !b()) {
                throw new NoSuchElementException();
            }
            this.c = 0;
            Iterator it = this.b;
            AbstractC13042fc3.f(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C5967Lp2(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(interfaceC23384wp6, "sequence");
        AbstractC13042fc3.i(ua2, "transformer");
        AbstractC13042fc3.i(ua22, "iterator");
        this.a = interfaceC23384wp6;
        this.b = ua2;
        this.c = ua22;
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
