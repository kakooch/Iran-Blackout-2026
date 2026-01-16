package j$.wrappers;

import j$.util.AbstractC0102a;
import j$.util.C0112i;
import j$.util.C0113j;
import j$.util.C0115l;
import j$.util.function.BiConsumer;
import j$.util.stream.IntStream;
import j$.util.stream.InterfaceC0127b4;
import j$.util.stream.InterfaceC0142e1;
import j$.util.stream.InterfaceC0152g;
import j$.util.t;
import java.util.Iterator;
import java.util.stream.LongStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class M0 implements InterfaceC0142e1 {
    final /* synthetic */ LongStream a;

    private /* synthetic */ M0(LongStream longStream) {
        this.a = longStream;
    }

    public static /* synthetic */ InterfaceC0142e1 o0(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof N0 ? ((N0) longStream).a : new M0(longStream);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0142e1 A(j$.util.function.t tVar) {
        return o0(this.a.map(C0294p0.a(tVar)));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ long E(long j, j$.util.function.o oVar) {
        return this.a.reduce(j, C0270d0.a(oVar));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ boolean M(C0280i0 c0280i0) {
        return this.a.allMatch(AbstractC0282j0.a(c0280i0));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ j$.util.stream.U P(C0284k0 c0284k0) {
        return K0.o0(this.a.mapToDouble(c0284k0 == null ? null : c0284k0.a));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0127b4 R(j$.util.function.r rVar) {
        return O0.o0(this.a.mapToObj(C0278h0.a(rVar)));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ boolean T(C0280i0 c0280i0) {
        return this.a.noneMatch(AbstractC0282j0.a(c0280i0));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ void a0(j$.util.function.q qVar) {
        this.a.forEachOrdered(C0274f0.a(qVar));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ j$.util.stream.U asDoubleStream() {
        return K0.o0(this.a.asDoubleStream());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ C0113j average() {
        return AbstractC0102a.n(this.a.average());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0127b4 boxed() {
        return O0.o0(this.a.boxed());
    }

    @Override // j$.util.stream.InterfaceC0152g, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0142e1 distinct() {
        return o0(this.a.distinct());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ void e(j$.util.function.q qVar) {
        this.a.forEach(C0274f0.a(qVar));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ IntStream f0(C0288m0 c0288m0) {
        return C$r8$wrapper$java$util$stream$IntStream$VWRP.convert(this.a.mapToInt(c0288m0 == null ? null : c0288m0.a));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ C0115l findAny() {
        return AbstractC0102a.p(this.a.findAny());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ C0115l findFirst() {
        return AbstractC0102a.p(this.a.findFirst());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ Object g0(j$.util.function.z zVar, j$.util.function.w wVar, BiConsumer biConsumer) {
        return this.a.collect(z0.a(zVar), v0.a(wVar), r.a(biConsumer));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ C0115l h(j$.util.function.o oVar) {
        return AbstractC0102a.p(this.a.reduce(C0270d0.a(oVar)));
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfLong] */
    @Override // j$.util.stream.InterfaceC0142e1, j$.util.stream.InterfaceC0152g
    public /* synthetic */ j$.util.r iterator() {
        return C0271e.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ boolean l(C0280i0 c0280i0) {
        return this.a.anyMatch(AbstractC0282j0.a(c0280i0));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0142e1 limit(long j) {
        return o0(this.a.limit(j));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ C0115l max() {
        return AbstractC0102a.p(this.a.max());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ C0115l min() {
        return AbstractC0102a.p(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g onClose(Runnable runnable) {
        return G0.o0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0142e1, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0142e1 parallel() {
        return o0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g parallel() {
        return G0.o0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0142e1 q(j$.util.function.q qVar) {
        return o0(this.a.peek(C0274f0.a(qVar)));
    }

    @Override // j$.util.stream.InterfaceC0142e1, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0142e1 sequential() {
        return o0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g sequential() {
        return G0.o0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0142e1 skip(long j) {
        return o0(this.a.skip(j));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0142e1 sorted() {
        return o0(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfLong] */
    @Override // j$.util.stream.InterfaceC0142e1, j$.util.stream.InterfaceC0152g
    public /* synthetic */ t.c spliterator() {
        return C0287m.b(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ j$.util.t spliterator() {
        return C0275g.b(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ long sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public C0112i summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0142e1 t(j$.util.function.r rVar) {
        return o0(this.a.flatMap(C0278h0.a(rVar)));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ long[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g unordered() {
        return G0.o0(this.a.unordered());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public /* synthetic */ InterfaceC0142e1 v(C0280i0 c0280i0) {
        return o0(this.a.filter(AbstractC0282j0.a(c0280i0)));
    }
}
