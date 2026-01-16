package ir.nasim;

import java.util.NoSuchElementException;

/* renamed from: ir.nasim.dw7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12046dw7 extends AbstractC12676f1 {
    private int c;
    private Object[] d;
    private boolean e;

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public C12046dw7(Object[] objArr, int i, int i2, int i3) {
        super(i, i2);
        this.c = i3;
        Object[] objArr2 = new Object[i3];
        this.d = objArr2;
        ?? r5 = i == i2 ? 1 : 0;
        this.e = r5;
        objArr2[0] = objArr;
        i(i - r5, 1);
    }

    private final Object h() {
        int iD = d() & 31;
        Object obj = this.d[this.c - 1];
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return ((Object[]) obj)[iD];
    }

    private final void i(int i, int i2) {
        int i3 = (this.c - i2) * 5;
        while (i2 < this.c) {
            Object[] objArr = this.d;
            Object obj = objArr[i2 - 1];
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[i2] = ((Object[]) obj)[AbstractC24298yN7.a(i, i3)];
            i3 -= 5;
            i2++;
        }
    }

    private final void k(int i) {
        int i2 = 0;
        while (AbstractC24298yN7.a(d(), i2) == i) {
            i2 += 5;
        }
        if (i2 > 0) {
            i(d(), ((this.c - 1) - (i2 / 5)) + 1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final void l(Object[] objArr, int i, int i2, int i3) {
        f(i);
        g(i2);
        this.c = i3;
        if (this.d.length < i3) {
            this.d = new Object[i3];
        }
        this.d[0] = objArr;
        ?? r0 = i == i2 ? 1 : 0;
        this.e = r0;
        i(i - r0, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objH = h();
        f(d() + 1);
        if (d() == e()) {
            this.e = true;
            return objH;
        }
        k(0);
        return objH;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        f(d() - 1);
        if (this.e) {
            this.e = false;
            return h();
        }
        k(31);
        return h();
    }
}
