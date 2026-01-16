package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.s;

/* renamed from: j$.util.stream.u1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0183u1 extends InterfaceC0164p1<Double, InterfaceC0183u1> {
    j$.util.o C(j$.util.function.r rVar);

    Object D(j$.util.function.L l, j$.util.function.I i, BiConsumer biConsumer);

    double G(double d, j$.util.function.r rVar);

    InterfaceC0183u1 H(j$.util.function.w wVar);

    Stream I(j$.util.function.t tVar);

    boolean J(j$.util.function.u uVar);

    boolean O(j$.util.function.u uVar);

    boolean V(j$.util.function.u uVar);

    j$.util.o average();

    Stream boxed();

    long count();

    InterfaceC0183u1 d(j$.util.function.s sVar);

    InterfaceC0183u1 distinct();

    j$.util.o findAny();

    j$.util.o findFirst();

    @Override // j$.util.stream.InterfaceC0164p1
    s.a iterator();

    void j0(j$.util.function.s sVar);

    void l(j$.util.function.s sVar);

    InterfaceC0183u1 limit(long j);

    j$.util.o max();

    j$.util.o min();

    E1 o(j$.G g);

    @Override // j$.util.stream.InterfaceC0164p1
    InterfaceC0183u1 parallel();

    @Override // j$.util.stream.InterfaceC0164p1
    InterfaceC0183u1 sequential();

    InterfaceC0183u1 skip(long j);

    InterfaceC0183u1 sorted();

    @Override // j$.util.stream.InterfaceC0164p1
    Spliterator.a spliterator();

    double sum();

    j$.util.l summaryStatistics();

    InterfaceC0183u1 t(j$.util.function.u uVar);

    double[] toArray();

    InterfaceC0183u1 u(j$.util.function.t tVar);

    J1 v(j$.util.function.v vVar);
}
