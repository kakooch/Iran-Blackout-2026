package j$;

import j$.util.function.Consumer;
import j$.util.s;
import java.util.PrimitiveIterator;

/* renamed from: j$.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0052a implements s.a {
    final /* synthetic */ PrimitiveIterator.OfDouble a;

    private /* synthetic */ C0052a(PrimitiveIterator.OfDouble ofDouble) {
        this.a = ofDouble;
    }

    public static /* synthetic */ s.a a(PrimitiveIterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0054b ? ((C0054b) ofDouble).a : new C0052a(ofDouble);
    }

    @Override // j$.util.s.a
    /* renamed from: e */
    public /* synthetic */ void forEachRemaining(j$.util.function.s sVar) {
        this.a.forEachRemaining(B.a(sVar));
    }

    @Override // j$.util.s.a, j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C0207x.a(consumer));
    }

    @Override // j$.util.s
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((PrimitiveIterator.OfDouble) obj);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // j$.util.s.a, java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Double next() {
        return this.a.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override // j$.util.s.a
    public /* synthetic */ double nextDouble() {
        return this.a.nextDouble();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}
