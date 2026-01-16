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
import java.util.stream.IntStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class N0 implements E1 {
    final /* synthetic */ IntStream a;

    private /* synthetic */ N0(IntStream intStream) {
        this.a = intStream;
    }

    public static /* synthetic */ E1 l0(IntStream intStream) {
        if (intStream == null) {
            return null;
        }
        return intStream instanceof O0 ? ((O0) intStream).a : new N0(intStream);
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ void E(j$.util.function.y yVar) {
        this.a.forEachOrdered(S.a(yVar));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ Stream F(j$.util.function.z zVar) {
        return C$r8$wrapper$java$util$stream$Stream$VWRP.convert(this.a.mapToObj(U.a(zVar)));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ int K(int i, j$.util.function.x xVar) {
        return this.a.reduce(i, P.a(xVar));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ boolean L(j$.util.function.A a) {
        return this.a.allMatch(W.a(a));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ E1 M(j$.util.function.z zVar) {
        return l0(this.a.flatMap(U.a(zVar)));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ void Q(j$.util.function.y yVar) {
        this.a.forEach(S.a(yVar));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ boolean R(j$.util.function.A a) {
        return this.a.noneMatch(W.a(a));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ E1 W(j$.util.function.A a) {
        return l0(this.a.filter(W.a(a)));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ j$.util.p Y(j$.util.function.x xVar) {
        return j$.time.a.o(this.a.reduce(P.a(xVar)));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ E1 Z(j$.util.function.y yVar) {
        return l0(this.a.peek(S.a(yVar)));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ InterfaceC0183u1 asDoubleStream() {
        return L0.l0(this.a.asDoubleStream());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ J1 asLongStream() {
        return P0.l0(this.a.asLongStream());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ j$.util.o average() {
        return j$.time.a.n(this.a.average());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ boolean b(j$.util.function.A a) {
        return this.a.anyMatch(W.a(a));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ Stream boxed() {
        return C$r8$wrapper$java$util$stream$Stream$VWRP.convert(this.a.boxed());
    }

    @Override // j$.util.stream.InterfaceC0164p1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ E1 distinct() {
        return l0(this.a.distinct());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ j$.util.p findAny() {
        return j$.time.a.o(this.a.findAny());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ j$.util.p findFirst() {
        return j$.time.a.o(this.a.findFirst());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ J1 h(j$.util.function.B b) {
        return P0.l0(this.a.mapToLong(C0053a0.a(b)));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ InterfaceC0183u1 h0(X x) {
        return L0.l0(this.a.mapToDouble(x == null ? null : x.a));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ Object i0(j$.util.function.L l, j$.util.function.J j, BiConsumer biConsumer) {
        return this.a.collect(A0.a(l), u0.a(j), r.a(biConsumer));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfInt] */
    @Override // j$.util.stream.E1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ s.b iterator() {
        return C0056c.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ E1 limit(long j) {
        return l0(this.a.limit(j));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ j$.util.p max() {
        return j$.time.a.o(this.a.max());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ j$.util.p min() {
        return j$.time.a.o(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 onClose(Runnable runnable) {
        return H0.l0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.E1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ E1 parallel() {
        return l0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 parallel() {
        return H0.l0(this.a.parallel());
    }

    @Override // j$.util.stream.E1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ E1 sequential() {
        return l0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 sequential() {
        return H0.l0(this.a.sequential());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ E1 skip(long j) {
        return l0(this.a.skip(j));
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ E1 sorted() {
        return l0(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfInt] */
    @Override // j$.util.stream.E1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Spliterator.b spliterator() {
        return C0072k.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Spliterator spliterator() {
        return C0064g.a(this.a.spliterator());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ int sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.E1
    public j$.util.m summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ int[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 unordered() {
        return H0.l0(this.a.unordered());
    }

    @Override // j$.util.stream.E1
    public /* synthetic */ E1 y(j$.util.function.C c) {
        return l0(this.a.map(C0057c0.a(c)));
    }
}
