package ir.nasim;

import java.util.NoSuchElementException;

/* renamed from: ir.nasim.Kl0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5695Kl0 extends AbstractC12085e1 {
    private final Object[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5695Kl0(Object[] objArr, int i, int i2) {
        super(i, i2);
        AbstractC13042fc3.i(objArr, "buffer");
        this.c = objArr;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.c;
        int iD = d();
        f(iD + 1);
        return objArr[iD];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.c;
        f(d() - 1);
        return objArr[d()];
    }
}
