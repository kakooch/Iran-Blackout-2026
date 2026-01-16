package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.s;

/* loaded from: classes2.dex */
public interface E1 extends InterfaceC0164p1<Integer, E1> {
    void E(j$.util.function.y yVar);

    Stream F(j$.util.function.z zVar);

    int K(int i, j$.util.function.x xVar);

    boolean L(j$.util.function.A a);

    E1 M(j$.util.function.z zVar);

    void Q(j$.util.function.y yVar);

    boolean R(j$.util.function.A a);

    E1 W(j$.util.function.A a);

    j$.util.p Y(j$.util.function.x xVar);

    E1 Z(j$.util.function.y yVar);

    InterfaceC0183u1 asDoubleStream();

    J1 asLongStream();

    j$.util.o average();

    boolean b(j$.util.function.A a);

    Stream boxed();

    long count();

    E1 distinct();

    j$.util.p findAny();

    j$.util.p findFirst();

    J1 h(j$.util.function.B b);

    InterfaceC0183u1 h0(j$.X x);

    Object i0(j$.util.function.L l, j$.util.function.J j, BiConsumer biConsumer);

    @Override // j$.util.stream.InterfaceC0164p1
    s.b iterator();

    E1 limit(long j);

    j$.util.p max();

    j$.util.p min();

    @Override // j$.util.stream.InterfaceC0164p1
    E1 parallel();

    @Override // j$.util.stream.InterfaceC0164p1
    E1 sequential();

    E1 skip(long j);

    E1 sorted();

    @Override // j$.util.stream.InterfaceC0164p1
    Spliterator.b spliterator();

    int sum();

    j$.util.m summaryStatistics();

    int[] toArray();

    E1 y(j$.util.function.C c);
}
