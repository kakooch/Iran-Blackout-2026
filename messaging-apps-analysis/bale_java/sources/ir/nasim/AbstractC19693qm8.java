package ir.nasim;

import java.util.NoSuchElementException;

/* renamed from: ir.nasim.qm8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC19693qm8 extends Em8 {
    private final int a;
    private int b;

    protected AbstractC19693qm8(int i, int i2) {
        AbstractC18511om8.b(i2, i, "index");
        this.a = i;
        this.b = i2;
    }

    protected abstract Object a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.b < this.a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }
}
