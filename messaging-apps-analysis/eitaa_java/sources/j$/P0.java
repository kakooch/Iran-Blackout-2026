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
import java.util.stream.LongStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class P0 implements J1 {
    final /* synthetic */ LongStream a;

    private /* synthetic */ P0(LongStream longStream) {
        this.a = longStream;
    }

    public static /* synthetic */ J1 l0(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof Q0 ? ((Q0) longStream).a : new P0(longStream);
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ long A(long j, j$.util.function.D d) {
        return this.a.reduce(j, C0061e0.a(d));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ Stream N(j$.util.function.F f) {
        return C$r8$wrapper$java$util$stream$Stream$VWRP.convert(this.a.mapToObj(C0069i0.a(f)));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ void X(j$.util.function.E e) {
        this.a.forEachOrdered(C0065g0.a(e));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ boolean a0(j$.util.function.G g) {
        return this.a.anyMatch(C0073k0.a(g));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ InterfaceC0183u1 asDoubleStream() {
        return L0.l0(this.a.asDoubleStream());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ j$.util.o average() {
        return j$.time.a.n(this.a.average());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ Stream boxed() {
        return C$r8$wrapper$java$util$stream$Stream$VWRP.convert(this.a.boxed());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ boolean c(j$.util.function.G g) {
        return this.a.noneMatch(C0073k0.a(g));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ Object c0(j$.util.function.L l, j$.util.function.K k, BiConsumer biConsumer) {
        return this.a.collect(A0.a(l), w0.a(k), r.a(biConsumer));
    }

    @Override // j$.util.stream.InterfaceC0164p1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ J1 distinct() {
        return l0(this.a.distinct());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ boolean e0(j$.util.function.G g) {
        return this.a.allMatch(C0073k0.a(g));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ void f(j$.util.function.E e) {
        this.a.forEach(C0065g0.a(e));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ J1 f0(j$.util.function.G g) {
        return l0(this.a.filter(C0073k0.a(g)));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ j$.util.q findAny() {
        return j$.time.a.p(this.a.findAny());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ j$.util.q findFirst() {
        return j$.time.a.p(this.a.findFirst());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ j$.util.q i(j$.util.function.D d) {
        return j$.time.a.p(this.a.reduce(C0061e0.a(d)));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfLong] */
    @Override // j$.util.stream.J1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ s.c iterator() {
        return C0060e.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ InterfaceC0183u1 j(C0075l0 c0075l0) {
        return L0.l0(this.a.mapToDouble(c0075l0 == null ? null : c0075l0.a));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ J1 limit(long j) {
        return l0(this.a.limit(j));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ j$.util.q max() {
        return j$.time.a.p(this.a.max());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ j$.util.q min() {
        return j$.time.a.p(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 onClose(Runnable runnable) {
        return H0.l0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.J1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ J1 parallel() {
        return l0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 parallel() {
        return H0.l0(this.a.parallel());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ J1 q(j$.util.function.E e) {
        return l0(this.a.peek(C0065g0.a(e)));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ J1 r(j$.util.function.F f) {
        return l0(this.a.flatMap(C0069i0.a(f)));
    }

    @Override // j$.util.stream.J1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ J1 sequential() {
        return l0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 sequential() {
        return H0.l0(this.a.sequential());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ J1 skip(long j) {
        return l0(this.a.skip(j));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ J1 sorted() {
        return l0(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfLong] */
    @Override // j$.util.stream.J1, j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Spliterator.c spliterator() {
        return C0076m.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Spliterator spliterator() {
        return C0064g.a(this.a.spliterator());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ long sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.J1
    public j$.util.n summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ long[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 unordered() {
        return H0.l0(this.a.unordered());
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ E1 w(C0079n0 c0079n0) {
        return N0.l0(this.a.mapToInt(c0079n0 == null ? null : c0079n0.a));
    }

    @Override // j$.util.stream.J1
    public /* synthetic */ J1 x(j$.util.function.H h) {
        return l0(this.a.map(C0085q0.a(h)));
    }
}
