package j$.wrappers;

import j$.util.AbstractC0102a;
import j$.util.Optional;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.InterfaceC0109b;
import j$.util.function.ToIntFunction;
import j$.util.stream.IntStream;
import j$.util.stream.InterfaceC0127b4;
import j$.util.stream.InterfaceC0142e1;
import j$.util.stream.InterfaceC0152g;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
public final /* synthetic */ class O0 implements InterfaceC0127b4 {
    final /* synthetic */ Stream a;

    private /* synthetic */ O0(Stream stream) {
        this.a = stream;
    }

    public static /* synthetic */ InterfaceC0127b4 o0(Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof P0 ? ((P0) stream).a : new O0(stream);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Object C(Object obj, BiFunction biFunction, InterfaceC0109b interfaceC0109b) {
        return this.a.reduce(obj, C0297t.a(biFunction), C0299v.a(interfaceC0109b));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ j$.util.stream.U F(Function function) {
        return K0.o0(this.a.flatMapToDouble(M.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 U(j$.util.function.y yVar) {
        return o0(this.a.filter(x0.a(yVar)));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 W(Consumer consumer) {
        return o0(this.a.peek(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer)));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ boolean X(j$.util.function.y yVar) {
        return this.a.allMatch(x0.a(yVar));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0142e1 Y(Function function) {
        return M0.o0(this.a.flatMapToLong(M.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ void a(Consumer consumer) {
        this.a.forEach(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ boolean b(j$.util.function.y yVar) {
        return this.a.anyMatch(x0.a(yVar));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Object c0(I0 i0) {
        return this.a.collect(i0 == null ? null : i0.a);
    }

    @Override // j$.util.stream.InterfaceC0152g, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ IntStream d(Function function) {
        return C$r8$wrapper$java$util$stream$IntStream$VWRP.convert(this.a.flatMapToInt(M.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 distinct() {
        return o0(this.a.distinct());
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ boolean e0(j$.util.function.y yVar) {
        return this.a.noneMatch(x0.a(yVar));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ void f(Consumer consumer) {
        this.a.forEachOrdered(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Optional findAny() {
        return AbstractC0102a.m(this.a.findAny());
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Optional findFirst() {
        return AbstractC0102a.m(this.a.findFirst());
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0142e1 h0(j$.util.function.B b) {
        return M0.o0(this.a.mapToLong(F0.a(b)));
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Object j(j$.util.function.z zVar, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.a.collect(z0.a(zVar), r.a(biConsumer), r.a(biConsumer2));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ j$.util.stream.U k0(j$.util.function.A a) {
        return K0.o0(this.a.mapToDouble(B0.a(a)));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 limit(long j) {
        return o0(this.a.limit(j));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Object[] m(j$.util.function.m mVar) {
        return this.a.toArray(T.a(mVar));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Optional max(Comparator comparator) {
        return AbstractC0102a.m(this.a.max(comparator));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Optional min(Comparator comparator) {
        return AbstractC0102a.m(this.a.min(comparator));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ IntStream n(ToIntFunction toIntFunction) {
        return C$r8$wrapper$java$util$stream$IntStream$VWRP.convert(this.a.mapToInt(D0.a(toIntFunction)));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Object n0(Object obj, InterfaceC0109b interfaceC0109b) {
        return this.a.reduce(obj, C0299v.a(interfaceC0109b));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 o(Function function) {
        return o0(this.a.map(M.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g onClose(Runnable runnable) {
        return G0.o0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 p(Function function) {
        return o0(this.a.flatMap(M.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g parallel() {
        return G0.o0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g sequential() {
        return G0.o0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 skip(long j) {
        return o0(this.a.skip(j));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 sorted() {
        return o0(this.a.sorted());
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ InterfaceC0127b4 sorted(Comparator comparator) {
        return o0(this.a.sorted(comparator));
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ j$.util.t spliterator() {
        return C0275g.b(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Object[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public /* synthetic */ Optional u(InterfaceC0109b interfaceC0109b) {
        return AbstractC0102a.m(this.a.reduce(C0299v.a(interfaceC0109b)));
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g unordered() {
        return G0.o0(this.a.unordered());
    }
}
