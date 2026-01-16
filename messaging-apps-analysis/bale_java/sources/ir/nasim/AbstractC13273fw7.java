package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.fw7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC13273fw7 implements Iterator, InterfaceC17915nm3 {
    private Object[] a = C12637ew7.e.a().p();
    private int b;
    private int c;

    public final Object b() {
        XZ0.a(f());
        return this.a[this.c];
    }

    public final C12637ew7 c() {
        XZ0.a(g());
        Object obj = this.a[this.c];
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (C12637ew7) obj;
    }

    protected final Object[] d() {
        return this.a;
    }

    protected final int e() {
        return this.c;
    }

    public final boolean f() {
        return this.c < this.b;
    }

    public final boolean g() {
        XZ0.a(this.c >= this.b);
        return this.c < this.a.length;
    }

    public final void h() {
        XZ0.a(f());
        this.c += 2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return f();
    }

    public final void i() {
        XZ0.a(g());
        this.c++;
    }

    public final void k(Object[] objArr, int i) {
        l(objArr, i, 0);
    }

    public final void l(Object[] objArr, int i, int i2) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
    }

    protected final void n(int i) {
        this.c = i;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
