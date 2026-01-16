package j$;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0072k implements Spliterator.b {
    final /* synthetic */ Spliterator.OfInt a;

    private /* synthetic */ C0072k(Spliterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public static /* synthetic */ Spliterator.b a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0074l ? ((C0074l) ofInt).a : new C0072k(ofInt);
    }

    @Override // j$.util.Spliterator.b, j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.a.tryAdvance(C0207x.a(consumer));
    }

    @Override // j$.util.Spliterator.b
    /* renamed from: c */
    public /* synthetic */ void forEachRemaining(j$.util.function.y yVar) {
        this.a.forEachRemaining(S.a(yVar));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // j$.util.Spliterator.b, j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C0207x.a(consumer));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((Spliterator.OfInt) obj);
    }

    @Override // j$.util.Spliterator.b
    /* renamed from: g */
    public /* synthetic */ boolean tryAdvance(j$.util.function.y yVar) {
        return this.a.tryAdvance(S.a(yVar));
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

    @Override // j$.util.Spliterator.d
    public /* synthetic */ boolean tryAdvance(Object obj) {
        return this.a.tryAdvance((Spliterator.OfInt) obj);
    }

    @Override // j$.util.Spliterator.b, j$.util.Spliterator.d, j$.util.Spliterator
    public /* synthetic */ Spliterator.b trySplit() {
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
