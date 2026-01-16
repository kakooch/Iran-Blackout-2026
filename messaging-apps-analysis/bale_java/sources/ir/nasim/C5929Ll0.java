package ir.nasim;

import java.util.NoSuchElementException;

/* renamed from: ir.nasim.Ll0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5929Ll0 extends AbstractC12676f1 {
    private final Object[] c;

    public C5929Ll0(Object[] objArr, int i, int i2) {
        super(i, i2);
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
