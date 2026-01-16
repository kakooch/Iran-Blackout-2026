package j$.wrappers;

import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.wrappers.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0275g implements j$.util.t {
    final /* synthetic */ Spliterator a;

    private /* synthetic */ C0275g(Spliterator spliterator) {
        this.a = spliterator;
    }

    public static /* synthetic */ j$.util.t b(Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof C0277h ? ((C0277h) spliterator).a : new C0275g(spliterator);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return this.a.tryAdvance(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.t
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.t
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.t
    public /* synthetic */ Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override // j$.util.t
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.a.hasCharacteristics(i);
    }

    @Override // j$.util.t
    public /* synthetic */ j$.util.t trySplit() {
        return b(this.a.trySplit());
    }
}
