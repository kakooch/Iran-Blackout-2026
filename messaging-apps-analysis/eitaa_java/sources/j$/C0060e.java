package j$;

import j$.util.function.Consumer;
import j$.util.s;
import java.util.PrimitiveIterator;

/* renamed from: j$.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0060e implements s.c {
    final /* synthetic */ PrimitiveIterator.OfLong a;

    private /* synthetic */ C0060e(PrimitiveIterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public static /* synthetic */ s.c a(PrimitiveIterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0062f ? ((C0062f) ofLong).a : new C0060e(ofLong);
    }

    @Override // j$.util.s.c
    /* renamed from: d */
    public /* synthetic */ void forEachRemaining(j$.util.function.E e) {
        this.a.forEachRemaining(C0065g0.a(e));
    }

    @Override // j$.util.s.c, j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C0207x.a(consumer));
    }

    @Override // j$.util.s
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((PrimitiveIterator.OfLong) obj);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // j$.util.s.c, java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Long next() {
        return this.a.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override // j$.util.s.c
    public /* synthetic */ long nextLong() {
        return this.a.nextLong();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}
