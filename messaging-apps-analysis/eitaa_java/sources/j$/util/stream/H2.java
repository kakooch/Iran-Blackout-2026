package j$.util.stream;

import j$.util.stream.C2;
import java.util.Comparator;

/* loaded from: classes2.dex */
abstract class H2<T> extends C2.d<T, T> {
    protected final Comparator b;
    protected boolean c;

    H2(C2 c2, Comparator comparator) {
        super(c2);
        this.b = comparator;
    }

    @Override // j$.util.stream.C2.d, j$.util.stream.C2
    public final boolean o() {
        this.c = true;
        return false;
    }
}
