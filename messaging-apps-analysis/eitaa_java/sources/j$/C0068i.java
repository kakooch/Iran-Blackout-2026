package j$;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0068i implements Spliterator.a {
    final /* synthetic */ Spliterator.OfDouble a;

    private /* synthetic */ C0068i(Spliterator.OfDouble ofDouble) {
        this.a = ofDouble;
    }

    public static /* synthetic */ Spliterator.a a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0070j ? ((C0070j) ofDouble).a : new C0068i(ofDouble);
    }

    @Override // j$.util.Spliterator.a, j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.a.tryAdvance(C0207x.a(consumer));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.Spliterator.a
    /* renamed from: e */
    public /* synthetic */ void forEachRemaining(j$.util.function.s sVar) {
        this.a.forEachRemaining(B.a(sVar));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // j$.util.Spliterator.a, j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C0207x.a(consumer));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((Spliterator.OfDouble) obj);
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

    @Override // j$.util.Spliterator.a
    /* renamed from: n */
    public /* synthetic */ boolean tryAdvance(j$.util.function.s sVar) {
        return this.a.tryAdvance(B.a(sVar));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.a.tryAdvance((Spliterator.OfDouble) obj);
    }

    @Override // j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
    public /* synthetic */ Spliterator.a trySplit() {
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
