package j$;

import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.Collector;
import j$.util.stream.E1;
import j$.util.stream.InterfaceC0164p1;
import j$.util.stream.InterfaceC0183u1;
import j$.util.stream.J1;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: j$.$r8$wrapper$java$util$stream$Stream$-V-WRP, reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class C$r8$wrapper$java$util$stream$Stream$VWRP implements Stream {
    final /* synthetic */ java.util.stream.Stream a;

    private /* synthetic */ C$r8$wrapper$java$util$stream$Stream$VWRP(java.util.stream.Stream stream) {
        this.a = stream;
    }

    public static /* synthetic */ Stream convert(java.util.stream.Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof R0 ? ((R0) stream).a : new C$r8$wrapper$java$util$stream$Stream$VWRP(stream);
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ InterfaceC0183u1 B(Function function) {
        return L0.l0(this.a.flatMapToDouble(N.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream P(Predicate predicate) {
        return convert(this.a.filter(y0.a(predicate)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream S(Consumer consumer) {
        return convert(this.a.peek(C0207x.a(consumer)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean T(Predicate predicate) {
        return this.a.allMatch(y0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ J1 U(Function function) {
        return P0.l0(this.a.flatMapToLong(N.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean a(Predicate predicate) {
        return this.a.anyMatch(y0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean b0(Predicate predicate) {
        return this.a.noneMatch(y0.a(predicate));
    }

    @Override // j$.util.stream.Stream, j$.util.stream.InterfaceC0164p1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object collect(Collector collector) {
        return this.a.collect(K0.a(collector));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ J1 d0(ToLongFunction toLongFunction) {
        return P0.l0(this.a.mapToLong(G0.a(toLongFunction)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream distinct() {
        return convert(this.a.distinct());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ E1 e(Function function) {
        return N0.l0(this.a.flatMapToInt(N.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional findAny() {
        return j$.time.a.m(this.a.findAny());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional findFirst() {
        return j$.time.a.m(this.a.findFirst());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ void forEach(Consumer consumer) {
        this.a.forEach(C0207x.a(consumer));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ void g(Consumer consumer) {
        this.a.forEachOrdered(C0207x.a(consumer));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ InterfaceC0183u1 g0(ToDoubleFunction toDoubleFunction) {
        return L0.l0(this.a.mapToDouble(C0.a(toDoubleFunction)));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object k(j$.util.function.L l, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.a.collect(A0.a(l), r.a(biConsumer), r.a(biConsumer2));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object k0(Object obj, j$.util.function.p pVar) {
        return this.a.reduce(obj, C0205v.a(pVar));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream limit(long j) {
        return convert(this.a.limit(j));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ E1 m(ToIntFunction toIntFunction) {
        return N0.l0(this.a.mapToInt(E0.a(toIntFunction)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional max(Comparator comparator) {
        return j$.time.a.m(this.a.max(comparator));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional min(Comparator comparator) {
        return j$.time.a.m(this.a.min(comparator));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream n(Function function) {
        return convert(this.a.map(N.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 onClose(Runnable runnable) {
        return H0.l0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream p(Function function) {
        return convert(this.a.flatMap(N.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 parallel() {
        return H0.l0(this.a.parallel());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Optional s(j$.util.function.p pVar) {
        return j$.time.a.m(this.a.reduce(C0205v.a(pVar)));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 sequential() {
        return H0.l0(this.a.sequential());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream skip(long j) {
        return convert(this.a.skip(j));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream sorted() {
        return convert(this.a.sorted());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream sorted(Comparator comparator) {
        return convert(this.a.sorted(comparator));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Spliterator spliterator() {
        return C0064g.a(this.a.spliterator());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object[] toArray(j$.util.function.z zVar) {
        return this.a.toArray(U.a(zVar));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 unordered() {
        return H0.l0(this.a.unordered());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object z(Object obj, BiFunction biFunction, j$.util.function.p pVar) {
        return this.a.reduce(obj, C0088t.a(biFunction), C0205v.a(pVar));
    }
}
