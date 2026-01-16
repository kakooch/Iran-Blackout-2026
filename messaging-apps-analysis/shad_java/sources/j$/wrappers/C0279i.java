package j$.wrappers;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.wrappers.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0279i implements t.a {
    final /* synthetic */ Spliterator.OfDouble a;

    private /* synthetic */ C0279i(Spliterator.OfDouble ofDouble) {
        this.a = ofDouble;
    }

    public static /* synthetic */ t.a b(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0281j ? ((C0281j) ofDouble).a : new C0279i(ofDouble);
    }

    @Override // j$.util.t.a, j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return this.a.tryAdvance(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.t
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.t.a
    public /* synthetic */ void e(j$.util.function.f fVar) {
        this.a.forEachRemaining(A.a(fVar));
    }

    @Override // j$.util.t
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // j$.util.t.a, j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.u
    /* renamed from: forEachRemaining */
    public /* synthetic */ void e(Object obj) {
        this.a.forEachRemaining((Spliterator.OfDouble) obj);
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

    @Override // j$.util.t.a
    public /* synthetic */ boolean j(j$.util.function.f fVar) {
        return this.a.tryAdvance(A.a(fVar));
    }

    @Override // j$.util.u
    /* renamed from: tryAdvance */
    public /* synthetic */ boolean j(Object obj) {
        return this.a.tryAdvance((Spliterator.OfDouble) obj);
    }

    @Override // j$.util.t.a, j$.util.u, j$.util.t
    public /* synthetic */ t.a trySplit() {
        return b(this.a.trySplit());
    }

    @Override // j$.util.t
    public /* synthetic */ j$.util.t trySplit() {
        return C0275g.b(this.a.trySplit());
    }

    @Override // j$.util.u, j$.util.t
    public /* synthetic */ j$.util.u trySplit() {
        return C0291o.b(this.a.trySplit());
    }
}
