package j$;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0076m implements Spliterator.c {
    final /* synthetic */ Spliterator.OfLong a;

    private /* synthetic */ C0076m(Spliterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public static /* synthetic */ Spliterator.c a(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0078n ? ((C0078n) ofLong).a : new C0076m(ofLong);
    }

    @Override // j$.util.Spliterator.c, j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.a.tryAdvance(C0207x.a(consumer));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.Spliterator.c
    /* renamed from: d */
    public /* synthetic */ void forEachRemaining(j$.util.function.E e) {
        this.a.forEachRemaining(C0065g0.a(e));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // j$.util.Spliterator.c, j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C0207x.a(consumer));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((Spliterator.OfLong) obj);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.a.hasCharacteristics(i);
    }

    @Override // j$.util.Spliterator.c
    /* renamed from: i */
    public /* synthetic */ boolean tryAdvance(j$.util.function.E e) {
        return this.a.tryAdvance(C0065g0.a(e));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.a.tryAdvance((Spliterator.OfLong) obj);
    }

    @Override // j$.util.Spliterator.c, j$.util.Spliterator.d, j$.util.Spliterator
    public /* synthetic */ Spliterator.c trySplit() {
        return a(this.a.trySplit());
    }

    @Override // j$.util.Spliterator.d, j$.util.Spliterator
    public /* synthetic */ Spliterator.d trySplit() {
        return C0080o.a(this.a.trySplit());
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ j$.util.Spliterator trySplit() {
        return C0064g.a(this.a.trySplit());
    }
}
