package j$.util.stream;

import j$.util.Optional;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* loaded from: classes2.dex */
public interface Stream<T> extends InterfaceC0164p1<T, Stream<T>> {
    InterfaceC0183u1 B(Function function);

    Stream P(Predicate predicate);

    Stream S(Consumer consumer);

    boolean T(Predicate predicate);

    J1 U(Function function);

    boolean a(Predicate predicate);

    boolean b0(Predicate predicate);

    @Override // j$.util.stream.InterfaceC0164p1, java.lang.AutoCloseable
    /* synthetic */ void close();

    Object collect(Collector collector);

    long count();

    J1 d0(ToLongFunction toLongFunction);

    Stream distinct();

    E1 e(Function function);

    Optional findAny();

    Optional findFirst();

    void forEach(Consumer consumer);

    void g(Consumer consumer);

    InterfaceC0183u1 g0(ToDoubleFunction toDoubleFunction);

    Object k(j$.util.function.L l, BiConsumer biConsumer, BiConsumer biConsumer2);

    Object k0(Object obj, j$.util.function.p pVar);

    Stream limit(long j);

    E1 m(ToIntFunction toIntFunction);

    Optional max(Comparator comparator);

    Optional min(Comparator comparator);

    Stream n(Function function);

    Stream p(Function function);

    Optional s(j$.util.function.p pVar);

    Stream skip(long j);

    Stream sorted();

    Stream sorted(Comparator comparator);

    Object[] toArray();

    Object[] toArray(j$.util.function.z zVar);

    Object z(Object obj, BiFunction biFunction, j$.util.function.p pVar);
}
