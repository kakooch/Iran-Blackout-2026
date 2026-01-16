package j$;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* renamed from: j$.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0064g implements Spliterator {
    final /* synthetic */ java.util.Spliterator a;

    private /* synthetic */ C0064g(java.util.Spliterator spliterator) {
        this.a = spliterator;
    }

    public static /* synthetic */ Spliterator a(java.util.Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof C0066h ? ((C0066h) spliterator).a : new C0064g(spliterator);
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

    @Override // j$.util.Spliterator
    public /* synthetic */ Spliterator trySplit() {
        return a(this.a.trySplit());
    }
}
