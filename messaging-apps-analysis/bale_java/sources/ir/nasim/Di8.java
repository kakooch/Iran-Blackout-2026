package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class Di8 implements Iterator {
    private int a = 0;
    final /* synthetic */ Ei8 b;

    Di8(Ei8 ei8) {
        this.b = ei8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.a.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.a;
        Ei8 ei8 = this.b;
        if (i >= ei8.a.length()) {
            throw new NoSuchElementException();
        }
        String str = ei8.a;
        this.a = i + 1;
        return new Ei8(String.valueOf(str.charAt(i)));
    }
}
