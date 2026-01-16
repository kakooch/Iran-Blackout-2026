package j$.wrappers;

import j$.util.AbstractC0102a;
import j$.util.C0111h;
import j$.util.C0113j;
import j$.util.C0114k;
import j$.util.function.BiConsumer;
import j$.util.p;
import j$.util.stream.IntStream;
import j$.util.stream.InterfaceC0127b4;
import j$.util.stream.InterfaceC0142e1;
import j$.util.stream.InterfaceC0152g;
import j$.util.t;
import java.util.Iterator;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$stream$IntStream$-V-WRP, reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class C$r8$wrapper$java$util$stream$IntStream$VWRP implements IntStream {
    final /* synthetic */ java.util.stream.IntStream a;

    private /* synthetic */ C$r8$wrapper$java$util$stream$IntStream$VWRP(java.util.stream.IntStream intStream) {
        this.a = intStream;
    }

    public static /* synthetic */ IntStream convert(java.util.stream.IntStream intStream) {
        if (intStream == null) {
            return null;
        }
        return intStream instanceof C$r8$wrapper$java$util$stream$IntStream$WRP ? ((C$r8$wrapper$java$util$stream$IntStream$WRP) intStream).a : new C$r8$wrapper$java$util$stream$IntStream$VWRP(intStream);
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ j$.util.stream.U B(W w) {
        return K0.o0(this.a.mapToDouble(w == null ? null : w.a));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ boolean D(U u) {
        return this.a.allMatch(V.a(u));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ boolean G(U u) {
        return this.a.anyMatch(V.a(u));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ void J(j$.util.function.l lVar) {
        this.a.forEachOrdered(Q.a(lVar));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0127b4 K(j$.util.function.m mVar) {
        return O0.o0(this.a.mapToObj(T.a(mVar)));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ int O(int i, j$.util.function.j jVar) {
        return this.a.reduce(i, O.a(jVar));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream Q(j$.util.function.m mVar) {
        return convert(this.a.flatMap(T.a(mVar)));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ void V(j$.util.function.l lVar) {
        this.a.forEach(Q.a(lVar));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ j$.util.stream.U asDoubleStream() {
        return K0.o0(this.a.asDoubleStream());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0142e1 asLongStream() {
        return M0.o0(this.a.asLongStream());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ C0113j average() {
        return AbstractC0102a.n(this.a.average());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ C0114k b0(j$.util.function.j jVar) {
        return AbstractC0102a.o(this.a.reduce(O.a(jVar)));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0127b4 boxed() {
        return O0.o0(this.a.boxed());
    }

    @Override // j$.util.stream.InterfaceC0152g, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream d0(j$.util.function.l lVar) {
        return convert(this.a.peek(Q.a(lVar)));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream distinct() {
        return convert(this.a.distinct());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ C0114k findAny() {
        return AbstractC0102a.o(this.a.findAny());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ C0114k findFirst() {
        return AbstractC0102a.o(this.a.findFirst());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0142e1 g(j$.util.function.n nVar) {
        return M0.o0(this.a.mapToLong(Z.a(nVar)));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream i(U u) {
        return convert(this.a.filter(V.a(u)));
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfInt] */
    @Override // j$.util.stream.IntStream, j$.util.stream.InterfaceC0152g
    public /* synthetic */ p.a iterator() {
        return C0267c.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ Object l0(j$.util.function.z zVar, j$.util.function.v vVar, BiConsumer biConsumer) {
        return this.a.collect(z0.a(zVar), t0.a(vVar), r.a(biConsumer));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream limit(long j) {
        return convert(this.a.limit(j));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ C0114k max() {
        return AbstractC0102a.o(this.a.max());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ C0114k min() {
        return AbstractC0102a.o(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g onClose(Runnable runnable) {
        return G0.o0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream parallel() {
        return convert(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g parallel() {
        return G0.o0(this.a.parallel());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream r(C0264a0 c0264a0) {
        return convert(this.a.map(AbstractC0266b0.a(c0264a0)));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream sequential() {
        return convert(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g sequential() {
        return G0.o0(this.a.sequential());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream skip(long j) {
        return convert(this.a.skip(j));
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ IntStream sorted() {
        return convert(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfInt] */
    @Override // j$.util.stream.IntStream, j$.util.stream.InterfaceC0152g
    public /* synthetic */ t.b spliterator() {
        return C0283k.b(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ j$.util.t spliterator() {
        return C0275g.b(this.a.spliterator());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ int sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.IntStream
    public C0111h summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ int[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g unordered() {
        return G0.o0(this.a.unordered());
    }

    @Override // j$.util.stream.IntStream
    public /* synthetic */ boolean w(U u) {
        return this.a.noneMatch(V.a(u));
    }
}
