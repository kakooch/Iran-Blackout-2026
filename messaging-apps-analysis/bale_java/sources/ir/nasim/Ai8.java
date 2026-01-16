package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class Ai8 implements Iterator {
    private int a = 0;
    final /* synthetic */ Ei8 b;

    Ai8(Ei8 ei8) {
        this.b = ei8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.a.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.a;
        if (i >= this.b.a.length()) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return new Ei8(String.valueOf(i));
    }
}
