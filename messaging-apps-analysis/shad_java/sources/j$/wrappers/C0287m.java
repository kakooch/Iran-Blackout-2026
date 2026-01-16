package j$.wrappers;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.wrappers.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0287m implements t.c {
    final /* synthetic */ Spliterator.OfLong a;

    private /* synthetic */ C0287m(Spliterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public static /* synthetic */ t.c b(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0289n ? ((C0289n) ofLong).a : new C0287m(ofLong);
    }

    @Override // j$.util.t.c, j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return this.a.tryAdvance(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.t
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.t.c
    /* renamed from: d */
    public /* synthetic */ void e(j$.util.function.q qVar) {
        this.a.forEachRemaining(C0274f0.a(qVar));
    }

    @Override // j$.util.t
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // j$.util.t.c, j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.u
    /* renamed from: forEachRemaining */
    public /* synthetic */ void e(Object obj) {
        this.a.forEachRemaining((Spliterator.OfLong) obj);
    }

    @Override // j$.util.t
    public /* synthetic */ Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override // j$.util.t
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    @Override // j$.util.t.c
    /* renamed from: h */
    public /* synthetic */ boolean j(j$.util.function.q qVar) {
        return this.a.tryAdvance(C0274f0.a(qVar));
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return this.a.hasCharacteristics(i);
    }

    @Override // j$.util.u
    /* renamed from: tryAdvance */
    public /* synthetic */ boolean j(Object obj) {
        return this.a.tryAdvance((Spliterator.OfLong) obj);
    }

    @Override // j$.util.t.c, j$.util.u, j$.util.t
    public /* synthetic */ t.c trySplit() {
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
