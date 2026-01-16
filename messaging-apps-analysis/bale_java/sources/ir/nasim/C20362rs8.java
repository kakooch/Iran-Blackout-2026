package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.rs8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C20362rs8 implements Iterator {
    final Iterator a;
    final /* synthetic */ C20953ss8 b;

    C20362rs8(C20953ss8 c20953ss8) {
        this.b = c20953ss8;
        this.a = c20953ss8.a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
