package j$.wrappers;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.wrappers.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0283k implements t.b {
    final /* synthetic */ Spliterator.OfInt a;

    private /* synthetic */ C0283k(Spliterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public static /* synthetic */ t.b b(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0285l ? ((C0285l) ofInt).a : new C0283k(ofInt);
    }

    @Override // j$.util.t.b, j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return this.a.tryAdvance(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.t.b
    /* renamed from: c */
    public /* synthetic */ void e(j$.util.function.l lVar) {
        this.a.forEachRemaining(Q.a(lVar));
    }

    @Override // j$.util.t
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.t
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // j$.util.t.b, j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.u
    /* renamed from: forEachRemaining */
    public /* synthetic */ void e(Object obj) {
        this.a.forEachRemaining((Spliterator.OfInt) obj);
    }

    @Override // j$.util.t.b
    /* renamed from: g */
    public /* synthetic */ boolean j(j$.util.function.l lVar) {
        return this.a.tryAdvance(Q.a(lVar));
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

    @Override // j$.util.u
    /* renamed from: tryAdvance */
    public /* synthetic */ boolean j(Object obj) {
        return this.a.tryAdvance((Spliterator.OfInt) obj);
    }

    @Override // j$.util.t.b, j$.util.u, j$.util.t
    public /* synthetic */ t.b trySplit() {
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
