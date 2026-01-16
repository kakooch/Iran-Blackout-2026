package ir.nasim;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.t55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C21089t55 implements Iterator, InterfaceC17915nm3 {
    private Object a;
    private final Map b;
    private int c;

    public C21089t55(Object obj, Map map) {
        this.a = obj;
        this.b = map;
    }

    private final void b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c < this.b.size();
    }

    @Override // java.util.Iterator
    public Object next() {
        b();
        Object obj = this.a;
        this.c++;
        Object obj2 = this.b.get(obj);
        if (obj2 != null) {
            this.a = ((C22410vB3) obj2).c();
            return obj;
        }
        throw new ConcurrentModificationException("Hash code of an element (" + obj + ") has changed after it was added to the persistent set.");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
