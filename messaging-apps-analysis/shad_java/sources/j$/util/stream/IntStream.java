package j$.util.stream;

import j$.util.C0111h;
import j$.util.C0113j;
import j$.util.C0114k;
import j$.util.function.BiConsumer;
import j$.util.p;
import j$.util.t;
import j$.wrappers.C0264a0;

/* loaded from: classes2.dex */
public interface IntStream extends InterfaceC0152g {
    U B(j$.wrappers.W w);

    boolean D(j$.wrappers.U u);

    boolean G(j$.wrappers.U u);

    void J(j$.util.function.l lVar);

    InterfaceC0127b4 K(j$.util.function.m mVar);

    int O(int i, j$.util.function.j jVar);

    IntStream Q(j$.util.function.m mVar);

    void V(j$.util.function.l lVar);

    U asDoubleStream();

    InterfaceC0142e1 asLongStream();

    C0113j average();

    C0114k b0(j$.util.function.j jVar);

    InterfaceC0127b4 boxed();

    long count();

    IntStream d0(j$.util.function.l lVar);

    IntStream distinct();

    C0114k findAny();

    C0114k findFirst();

    InterfaceC0142e1 g(j$.util.function.n nVar);

    IntStream i(j$.wrappers.U u);

    @Override // j$.util.stream.InterfaceC0152g
    p.a iterator();

    Object l0(j$.util.function.z zVar, j$.util.function.v vVar, BiConsumer biConsumer);

    IntStream limit(long j);

    C0114k max();

    C0114k min();

    IntStream parallel();

    IntStream r(C0264a0 c0264a0);

    IntStream sequential();

    IntStream skip(long j);

    IntStream sorted();

    @Override // j$.util.stream.InterfaceC0152g
    t.b spliterator();

    int sum();

    C0111h summaryStatistics();

    int[] toArray();

    boolean w(j$.wrappers.U u);
}
