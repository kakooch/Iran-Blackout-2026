package j$.util.stream;

import j$.util.C0110g;
import j$.util.C0113j;
import j$.util.function.BiConsumer;
import j$.util.t;

/* loaded from: classes2.dex */
public interface U extends InterfaceC0152g {
    C0113j H(j$.util.function.d dVar);

    Object I(j$.util.function.z zVar, j$.util.function.u uVar, BiConsumer biConsumer);

    double L(double d, j$.util.function.d dVar);

    InterfaceC0127b4 N(j$.util.function.g gVar);

    IntStream S(j$.wrappers.F f);

    boolean Z(j$.wrappers.D d);

    C0113j average();

    InterfaceC0127b4 boxed();

    U c(j$.util.function.f fVar);

    long count();

    U distinct();

    C0113j findAny();

    C0113j findFirst();

    boolean i0(j$.wrappers.D d);

    @Override // j$.util.stream.InterfaceC0152g
    j$.util.n iterator();

    boolean j0(j$.wrappers.D d);

    void k(j$.util.function.f fVar);

    U limit(long j);

    void m0(j$.util.function.f fVar);

    C0113j max();

    C0113j min();

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    U parallel();

    U s(j$.wrappers.D d);

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    U sequential();

    U skip(long j);

    U sorted();

    @Override // j$.util.stream.InterfaceC0152g
    t.a spliterator();

    double sum();

    C0110g summaryStatistics();

    double[] toArray();

    U x(j$.util.function.g gVar);

    InterfaceC0142e1 y(j$.util.function.h hVar);

    U z(j$.wrappers.J j);
}
