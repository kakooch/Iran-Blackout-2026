package ir.nasim;

/* renamed from: ir.nasim.qD6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19364qD6 extends AbstractC12085e1 {
    private final Object c;

    public C19364qD6(Object obj, int i) {
        super(i, 1);
        this.c = obj;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        b();
        f(d() + 1);
        return this.c;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        c();
        f(d() - 1);
        return this.c;
    }
}
