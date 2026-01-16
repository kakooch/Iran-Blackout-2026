package ir.nasim;

/* renamed from: ir.nasim.iH6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14665iH6 {
    private static final Object a = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e() {
        throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void f() {
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index (" + i + ") is out of bound of [0, " + i2 + ')');
        }
    }
}
