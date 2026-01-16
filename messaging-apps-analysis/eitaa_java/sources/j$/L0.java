package j$;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.s;
import j$.util.stream.E1;
import j$.util.stream.InterfaceC0164p1;
import j$.util.stream.InterfaceC0183u1;
import j$.util.stream.J1;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.stream.DoubleStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class L0 implements InterfaceC0183u1 {
    final /* synthetic */ DoubleStream a;

    private /* synthetic */ L0(DoubleStream doubleStream) {
        this.a = doubleStream;
    }

    public static /* synthetic */ InterfaceC0183u1 l0(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof M0 ? ((M0) doubleStream).a : new L0(doubleStream);
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ j$.util.o C(j$.util.function.r rVar) {
        return j$.time.a.n(this.a.reduce(C0209z.a(rVar)));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ Object D(j$.util.function.L l, j$.util.function.I i, BiConsumer biConsumer) {
        return this.a.collect(A0.a(l), s0.a(i), r.a(biConsumer));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ double G(double d, j$.util.function.r rVar) {
        return this.a.reduce(d, C0209z.a(rVar));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ InterfaceC0183u1 H(j$.util.function.w wVar) {
        return l0(this.a.map(L.a(wVar)));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ Stream I(j$.util.function.t tVar) {
        return C$r8$wrapper$java$util$stream$Stream$VWRP.convert(this.a.mapToObj(D.a(tVar)));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ boolean J(j$.util.function.u uVar) {
        return this.a.noneMatch(F.a(uVar));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ boolean O(j$.util.function.u uVar) {
        return this.a.allMatch(F.a(uVar));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ boolean V(j$.util.function.u uVar) {
        return this.a.anyMatch(F.a(uVar));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ j$.util.o average() {
        return j$.time.a.n(this.a.average());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ Stream boxed() {
        return C$r8$wrapper$java$util$stream$Stream$VWRP.convert(this.a.boxed());
    }

    @Override // j$.util.stream.InterfaceC0164p1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ InterfaceC0183u1 d(j$.util.function.s sVar) {
        return l0(this.a.peek(B.a(sVar)));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ InterfaceC0183u1 distinct() {
        return l0(this.a.distinct());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ j$.util.o findAny() {
        return j$.time.a.n(this.a.findAny());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ j$.util.o findFirst() {
        return j$.time.a.n(this.a.findFirst());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfDouble] */
    @Override // j$.util.stream.InterfaceC0183u1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ s.a iterator() {
        return C0052a.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ void j0(j$.util.function.s sVar) {
        this.a.forEachOrdered(B.a(sVar));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ void l(j$.util.function.s sVar) {
        this.a.forEach(B.a(sVar));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ InterfaceC0183u1 limit(long j) {
        return l0(this.a.limit(j));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ j$.util.o max() {
        return j$.time.a.n(this.a.max());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ j$.util.o min() {
        return j$.time.a.n(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ E1 o(G g) {
        return N0.l0(this.a.mapToInt(g == null ? null : g.a));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 onClose(Runnable runnable) {
        return H0.l0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 parallel() {
        return H0.l0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0183u1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0183u1 parallel() {
        return l0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 sequential() {
        return H0.l0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0183u1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0183u1 sequential() {
        return l0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ InterfaceC0183u1 skip(long j) {
        return l0(this.a.skip(j));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ InterfaceC0183u1 sorted() {
        return l0(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfDouble] */
    @Override // j$.util.stream.InterfaceC0183u1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Spliterator.a spliterator() {
        return C0068i.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Spliterator spliterator() {
        return C0064g.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ double sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public j$.util.l summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ InterfaceC0183u1 t(j$.util.function.u uVar) {
        return l0(this.a.filter(F.a(uVar)));
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ double[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ InterfaceC0183u1 u(j$.util.function.t tVar) {
        return l0(this.a.flatMap(D.a(tVar)));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 unordered() {
        return H0.l0(this.a.unordered());
    }

    @Override // j$.util.stream.InterfaceC0183u1
    public /* synthetic */ J1 v(j$.util.function.v vVar) {
        return P0.l0(this.a.mapToLong(J.a(vVar)));
    }
}
