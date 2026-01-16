package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Yv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9186Yv7 implements Iterator, InterfaceC17915nm3 {
    private final UA2 a;
    private final List b = new ArrayList();
    private Iterator c;

    public C9186Yv7(Iterator it, UA2 ua2) {
        this.a = ua2;
        this.c = it;
    }

    private final void b(Object obj) {
        Iterator it = (Iterator) this.a.invoke(obj);
        if (it != null && it.hasNext()) {
            this.b.add(this.c);
            this.c = it;
        } else {
            while (!this.c.hasNext() && (!this.b.isEmpty())) {
                this.c = (Iterator) AbstractC15401jX0.C0(this.b);
                AbstractC13610gX0.N(this.b);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Object next = this.c.next();
        b(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
