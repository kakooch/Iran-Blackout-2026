package j$.wrappers;

import j$.util.AbstractC0102a;
import j$.util.C0110g;
import j$.util.C0113j;
import j$.util.function.BiConsumer;
import j$.util.stream.IntStream;
import j$.util.stream.InterfaceC0127b4;
import j$.util.stream.InterfaceC0142e1;
import j$.util.stream.InterfaceC0152g;
import j$.util.t;
import java.util.Iterator;
import java.util.stream.DoubleStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class K0 implements j$.util.stream.U {
    final /* synthetic */ DoubleStream a;

    private /* synthetic */ K0(DoubleStream doubleStream) {
        this.a = doubleStream;
    }

    public static /* synthetic */ j$.util.stream.U o0(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof L0 ? ((L0) doubleStream).a : new K0(doubleStream);
    }

    @Override // j$.util.stream.U
    public /* synthetic */ C0113j H(j$.util.function.d dVar) {
        return AbstractC0102a.n(this.a.reduce(C0302y.a(dVar)));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ Object I(j$.util.function.z zVar, j$.util.function.u uVar, BiConsumer biConsumer) {
        return this.a.collect(z0.a(zVar), r0.a(uVar), r.a(biConsumer));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ double L(double d, j$.util.function.d dVar) {
        return this.a.reduce(d, C0302y.a(dVar));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ InterfaceC0127b4 N(j$.util.function.g gVar) {
        return O0.o0(this.a.mapToObj(C.a(gVar)));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ IntStream S(F f) {
        return C$r8$wrapper$java$util$stream$IntStream$VWRP.convert(this.a.mapToInt(f == null ? null : f.a));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ boolean Z(D d) {
        return this.a.allMatch(E.a(d));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ C0113j average() {
        return AbstractC0102a.n(this.a.average());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ InterfaceC0127b4 boxed() {
        return O0.o0(this.a.boxed());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ j$.util.stream.U c(j$.util.function.f fVar) {
        return o0(this.a.peek(A.a(fVar)));
    }

    @Override // j$.util.stream.InterfaceC0152g, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.U
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.U
    public /* synthetic */ j$.util.stream.U distinct() {
        return o0(this.a.distinct());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ C0113j findAny() {
        return AbstractC0102a.n(this.a.findAny());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ C0113j findFirst() {
        return AbstractC0102a.n(this.a.findFirst());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ boolean i0(D d) {
        return this.a.anyMatch(E.a(d));
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfDouble] */
    @Override // j$.util.stream.U, j$.util.stream.InterfaceC0152g
    public /* synthetic */ j$.util.n iterator() {
        return C0263a.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.U
    public /* synthetic */ boolean j0(D d) {
        return this.a.noneMatch(E.a(d));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ void k(j$.util.function.f fVar) {
        this.a.forEach(A.a(fVar));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ j$.util.stream.U limit(long j) {
        return o0(this.a.limit(j));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ void m0(j$.util.function.f fVar) {
        this.a.forEachOrdered(A.a(fVar));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ C0113j max() {
        return AbstractC0102a.n(this.a.max());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ C0113j min() {
        return AbstractC0102a.n(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g onClose(Runnable runnable) {
        return G0.o0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.U, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ j$.util.stream.U parallel() {
        return o0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g parallel() {
        return G0.o0(this.a.parallel());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ j$.util.stream.U s(D d) {
        return o0(this.a.filter(E.a(d)));
    }

    @Override // j$.util.stream.U, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ j$.util.stream.U sequential() {
        return o0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g sequential() {
        return G0.o0(this.a.sequential());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ j$.util.stream.U skip(long j) {
        return o0(this.a.skip(j));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ j$.util.stream.U sorted() {
        return o0(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfDouble] */
    @Override // j$.util.stream.U, j$.util.stream.InterfaceC0152g
    public /* synthetic */ t.a spliterator() {
        return C0279i.b(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ j$.util.t spliterator() {
        return C0275g.b(this.a.spliterator());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ double sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.U
    public C0110g summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // j$.util.stream.U
    public /* synthetic */ double[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g unordered() {
        return G0.o0(this.a.unordered());
    }

    @Override // j$.util.stream.U
    public /* synthetic */ j$.util.stream.U x(j$.util.function.g gVar) {
        return o0(this.a.flatMap(C.a(gVar)));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ InterfaceC0142e1 y(j$.util.function.h hVar) {
        return M0.o0(this.a.mapToLong(I.a(hVar)));
    }

    @Override // j$.util.stream.U
    public /* synthetic */ j$.util.stream.U z(J j) {
        return o0(this.a.map(K.a(j)));
    }
}
