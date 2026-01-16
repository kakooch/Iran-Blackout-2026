package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.xh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C23896xh8 implements Iterator {
    private int a = 0;
    final /* synthetic */ Ch8 b;

    C23896xh8(Ch8 ch8) {
        this.b = ch8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.w();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (this.a < this.b.w()) {
            Ch8 ch8 = this.b;
            int i = this.a;
            this.a = i + 1;
            return ch8.x(i);
        }
        throw new NoSuchElementException("Out of bounds index: " + this.a);
    }
}
