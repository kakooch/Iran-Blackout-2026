package j$.util.stream;

import j$.util.Optional;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.InterfaceC0109b;
import j$.util.function.ToIntFunction;
import java.util.Comparator;

/* renamed from: j$.util.stream.b4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0127b4 extends InterfaceC0152g {
    Object C(Object obj, BiFunction biFunction, InterfaceC0109b interfaceC0109b);

    U F(Function function);

    InterfaceC0127b4 U(j$.util.function.y yVar);

    InterfaceC0127b4 W(Consumer consumer);

    boolean X(j$.util.function.y yVar);

    InterfaceC0142e1 Y(Function function);

    void a(Consumer consumer);

    boolean b(j$.util.function.y yVar);

    Object c0(j$.wrappers.I0 i0);

    long count();

    IntStream d(Function function);

    InterfaceC0127b4 distinct();

    boolean e0(j$.util.function.y yVar);

    void f(Consumer consumer);

    Optional findAny();

    Optional findFirst();

    InterfaceC0142e1 h0(j$.util.function.B b);

    Object j(j$.util.function.z zVar, BiConsumer biConsumer, BiConsumer biConsumer2);

    U k0(j$.util.function.A a);

    InterfaceC0127b4 limit(long j);

    Object[] m(j$.util.function.m mVar);

    Optional max(Comparator comparator);

    Optional min(Comparator comparator);

    IntStream n(ToIntFunction toIntFunction);

    Object n0(Object obj, InterfaceC0109b interfaceC0109b);

    InterfaceC0127b4 o(Function function);

    InterfaceC0127b4 p(Function function);

    InterfaceC0127b4 skip(long j);

    InterfaceC0127b4 sorted();

    InterfaceC0127b4 sorted(Comparator comparator);

    Object[] toArray();

    Optional u(InterfaceC0109b interfaceC0109b);
}
