package j$;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0080o implements Spliterator.d {
    final /* synthetic */ Spliterator.OfPrimitive a;

    private /* synthetic */ C0080o(Spliterator.OfPrimitive ofPrimitive) {
        this.a = ofPrimitive;
    }

    public static /* synthetic */ Spliterator.d a(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof C0082p ? ((C0082p) ofPrimitive).a : new C0080o(ofPrimitive);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.a.tryAdvance(C0207x.a(consumer));
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C0207x.a(consumer));
    }

    @Override // j$.util.Spliterator.d
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((Spliterator.OfPrimitive) obj);
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
        return this.a.tryAdvance((Spliterator.OfPrimitive) obj);
    }

    @Override // j$.util.Spliterator.d, j$.util.Spliterator
    public /* synthetic */ Spliterator.d trySplit() {
        return a(this.a.trySplit());
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ j$.util.Spliterator trySplit() {
        return C0064g.a(this.a.trySplit());
    }
}
