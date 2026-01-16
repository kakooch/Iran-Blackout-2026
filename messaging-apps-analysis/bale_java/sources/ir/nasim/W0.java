package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
abstract class W0 implements Iterator {
    private b a = b.NOT_READY;
    private Object b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected W0() {
    }

    private boolean c() {
        this.a = b.FAILED;
        this.b = a();
        if (this.a == b.DONE) {
            return false;
        }
        this.a = b.READY;
        return true;
    }

    protected abstract Object a();

    protected final Object b() {
        this.a = b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        AbstractC4029Dj5.o(this.a != b.FAILED);
        int i = a.a[this.a.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = b.NOT_READY;
        Object objA = AbstractC23633xF4.a(this.b);
        this.b = null;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
