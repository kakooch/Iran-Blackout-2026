package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.k63, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15748k63 implements Iterator, InterfaceC17915nm3 {
    private final Iterator a;
    private int b;

    public C15748k63(Iterator it) {
        AbstractC13042fc3.i(it, "iterator");
        this.a = it;
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C14555i63 next() {
        int i = this.b;
        this.b = i + 1;
        if (i < 0) {
            AbstractC10360bX0.w();
        }
        return new C14555i63(i, this.a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
