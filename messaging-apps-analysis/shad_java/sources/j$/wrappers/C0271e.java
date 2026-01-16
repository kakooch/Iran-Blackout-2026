package j$.wrappers;

import j$.util.function.Consumer;
import java.util.PrimitiveIterator;

/* renamed from: j$.wrappers.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0271e implements j$.util.r {
    final /* synthetic */ PrimitiveIterator.OfLong a;

    private /* synthetic */ C0271e(PrimitiveIterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public static /* synthetic */ j$.util.r a(PrimitiveIterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0273f ? ((C0273f) ofLong).a : new C0271e(ofLong);
    }

    @Override // j$.util.r
    /* renamed from: d */
    public /* synthetic */ void forEachRemaining(j$.util.function.q qVar) {
        this.a.forEachRemaining(C0274f0.a(qVar));
    }

    @Override // j$.util.r, j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.p
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((PrimitiveIterator.OfLong) obj);
    }

    @Override // java.util.Iterator
    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // j$.util.r, java.util.Iterator
    public /* synthetic */ Long next() {
        return this.a.next();
    }

    @Override // java.util.Iterator
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override // j$.util.r
    public /* synthetic */ long nextLong() {
        return this.a.nextLong();
    }

    @Override // java.util.Iterator
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}
