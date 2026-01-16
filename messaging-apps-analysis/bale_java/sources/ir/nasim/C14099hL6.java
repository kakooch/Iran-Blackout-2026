package ir.nasim;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.hL6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C14099hL6 implements ListIterator, InterfaceC17915nm3 {
    private final C14063hH6 a;
    private int b;
    private int c = -1;
    private int d;

    public C14099hL6(C14063hH6 c14063hH6, int i) {
        this.a = c14063hH6;
        this.b = i - 1;
        this.d = c14063hH6.x();
    }

    private final void b() {
        if (this.a.x() != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        b();
        this.a.add(this.b + 1, obj);
        this.c = -1;
        this.b++;
        this.d = this.a.x();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.size() - 1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.b >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        b();
        int i = this.b + 1;
        this.c = i;
        AbstractC14665iH6.g(i, this.a.size());
        Object obj = this.a.get(i);
        this.b = i;
        return obj;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.b + 1;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        b();
        AbstractC14665iH6.g(this.b, this.a.size());
        int i = this.b;
        this.c = i;
        this.b--;
        return this.a.get(i);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        b();
        this.a.remove(this.b);
        this.b--;
        this.c = -1;
        this.d = this.a.x();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        b();
        int i = this.c;
        if (i < 0) {
            AbstractC14665iH6.e();
            throw new KotlinNothingValueException();
        }
        this.a.set(i, obj);
        this.d = this.a.x();
    }
}
