package j$.util.stream;

import j$.C0075l0;
import j$.C0079n0;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.s;

/* loaded from: classes2.dex */
public interface J1 extends InterfaceC0164p1<Long, J1> {
    long A(long j, j$.util.function.D d);

    Stream N(j$.util.function.F f);

    void X(j$.util.function.E e);

    boolean a0(j$.util.function.G g);

    InterfaceC0183u1 asDoubleStream();

    j$.util.o average();

    Stream boxed();

    boolean c(j$.util.function.G g);

    Object c0(j$.util.function.L l, j$.util.function.K k, BiConsumer biConsumer);

    long count();

    J1 distinct();

    boolean e0(j$.util.function.G g);

    void f(j$.util.function.E e);

    J1 f0(j$.util.function.G g);

    j$.util.q findAny();

    j$.util.q findFirst();

    j$.util.q i(j$.util.function.D d);

    @Override // j$.util.stream.InterfaceC0164p1
    s.c iterator();

    InterfaceC0183u1 j(C0075l0 c0075l0);

    J1 limit(long j);

    j$.util.q max();

    j$.util.q min();

    @Override // j$.util.stream.InterfaceC0164p1
    J1 parallel();

    J1 q(j$.util.function.E e);

    J1 r(j$.util.function.F f);

    @Override // j$.util.stream.InterfaceC0164p1
    J1 sequential();

    J1 skip(long j);

    J1 sorted();

    @Override // j$.util.stream.InterfaceC0164p1
    Spliterator.c spliterator();

    long sum();

    j$.util.n summaryStatistics();

    long[] toArray();

    E1 w(C0079n0 c0079n0);

    J1 x(j$.util.function.H h);
}
