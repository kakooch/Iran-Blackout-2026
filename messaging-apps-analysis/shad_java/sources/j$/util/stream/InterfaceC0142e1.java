package j$.util.stream;

import j$.util.C0112i;
import j$.util.C0113j;
import j$.util.C0115l;
import j$.util.function.BiConsumer;
import j$.util.t;
import j$.wrappers.C0280i0;
import j$.wrappers.C0284k0;
import j$.wrappers.C0288m0;

/* renamed from: j$.util.stream.e1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0142e1 extends InterfaceC0152g {
    InterfaceC0142e1 A(j$.util.function.t tVar);

    long E(long j, j$.util.function.o oVar);

    boolean M(C0280i0 c0280i0);

    U P(C0284k0 c0284k0);

    InterfaceC0127b4 R(j$.util.function.r rVar);

    boolean T(C0280i0 c0280i0);

    void a0(j$.util.function.q qVar);

    U asDoubleStream();

    C0113j average();

    InterfaceC0127b4 boxed();

    long count();

    InterfaceC0142e1 distinct();

    void e(j$.util.function.q qVar);

    IntStream f0(C0288m0 c0288m0);

    C0115l findAny();

    C0115l findFirst();

    Object g0(j$.util.function.z zVar, j$.util.function.w wVar, BiConsumer biConsumer);

    C0115l h(j$.util.function.o oVar);

    @Override // j$.util.stream.InterfaceC0152g
    j$.util.r iterator();

    boolean l(C0280i0 c0280i0);

    InterfaceC0142e1 limit(long j);

    C0115l max();

    C0115l min();

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    InterfaceC0142e1 parallel();

    InterfaceC0142e1 q(j$.util.function.q qVar);

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    InterfaceC0142e1 sequential();

    InterfaceC0142e1 skip(long j);

    InterfaceC0142e1 sorted();

    @Override // j$.util.stream.InterfaceC0152g
    t.c spliterator();

    long sum();

    C0112i summaryStatistics();

    InterfaceC0142e1 t(j$.util.function.r rVar);

    long[] toArray();

    InterfaceC0142e1 v(C0280i0 c0280i0);
}
