package j$.util.stream;

import j$.util.Optional;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0108a;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.InterfaceC0109b;
import j$.util.function.ToIntFunction;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: j$.util.stream.e3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0144e3 extends AbstractC0128c implements InterfaceC0127b4 {
    AbstractC0144e3(AbstractC0128c abstractC0128c, int i) {
        super(abstractC0128c, i);
    }

    AbstractC0144e3(j$.util.t tVar, int i, boolean z) {
        super(tVar, i, z);
    }

    @Override // j$.util.stream.AbstractC0128c
    final A1 A0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z, j$.util.function.m mVar) {
        return AbstractC0251x2.e(abstractC0256y2, tVar, z, mVar);
    }

    @Override // j$.util.stream.AbstractC0128c
    final void B0(j$.util.t tVar, InterfaceC0192m3 interfaceC0192m3) {
        while (!interfaceC0192m3.p() && tVar.a(interfaceC0192m3)) {
        }
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Object C(Object obj, BiFunction biFunction, InterfaceC0109b interfaceC0109b) {
        biFunction.getClass();
        interfaceC0109b.getClass();
        return y0(new C0261z2(EnumC0151f4.REFERENCE, interfaceC0109b, biFunction, obj));
    }

    @Override // j$.util.stream.AbstractC0128c
    final EnumC0151f4 C0() {
        return EnumC0151f4.REFERENCE;
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final U F(Function function) {
        function.getClass();
        return new K(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.p | EnumC0145e4.n | EnumC0145e4.t, function);
    }

    @Override // j$.util.stream.AbstractC0128c
    final j$.util.t L0(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        return new M4(abstractC0256y2, zVar, z);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 U(j$.util.function.y yVar) {
        yVar.getClass();
        return new L(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.t, yVar);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 W(Consumer consumer) {
        consumer.getClass();
        return new L(this, this, EnumC0151f4.REFERENCE, 0, consumer);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final boolean X(j$.util.function.y yVar) {
        return ((Boolean) y0(AbstractC0202o1.x(yVar, EnumC0178k1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0142e1 Y(Function function) {
        function.getClass();
        return new N(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.p | EnumC0145e4.n | EnumC0145e4.t, function);
    }

    public void a(Consumer consumer) {
        consumer.getClass();
        y0(new C0195n0(consumer, false));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final boolean b(j$.util.function.y yVar) {
        return ((Boolean) y0(AbstractC0202o1.x(yVar, EnumC0178k1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Object c0(j$.wrappers.I0 i0) {
        Object objY0;
        if (isParallel() && i0.b().contains(EnumC0158h.CONCURRENT) && (!D0() || i0.b().contains(EnumC0158h.UNORDERED))) {
            objY0 = i0.f().get();
            a(new C0200o(i0.a(), objY0));
        } else {
            i0.getClass();
            j$.util.function.z zVarF = i0.f();
            objY0 = y0(new I2(EnumC0151f4.REFERENCE, i0.c(), i0.a(), zVarF, i0));
        }
        return i0.b().contains(EnumC0158h.IDENTITY_FINISH) ? objY0 : i0.e().apply(objY0);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final long count() {
        return ((AbstractC0136d1) h0(new j$.util.function.B() { // from class: j$.util.stream.X2
            @Override // j$.util.function.B
            public final long applyAsLong(Object obj) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final IntStream d(Function function) {
        function.getClass();
        return new M(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.p | EnumC0145e4.n | EnumC0145e4.t, function);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 distinct() {
        return new C0223s(this, EnumC0151f4.REFERENCE, EnumC0145e4.m | EnumC0145e4.t);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final boolean e0(j$.util.function.y yVar) {
        return ((Boolean) y0(AbstractC0202o1.x(yVar, EnumC0178k1.NONE))).booleanValue();
    }

    public void f(Consumer consumer) {
        consumer.getClass();
        y0(new C0195n0(consumer, true));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Optional findAny() {
        return (Optional) y0(new C0135d0(false, EnumC0151f4.REFERENCE, Optional.empty(), V.a, C0129c0.a));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Optional findFirst() {
        return (Optional) y0(new C0135d0(true, EnumC0151f4.REFERENCE, Optional.empty(), V.a, C0129c0.a));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0142e1 h0(j$.util.function.B b) {
        b.getClass();
        return new N(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.p | EnumC0145e4.n, b);
    }

    @Override // j$.util.stream.InterfaceC0152g
    public final Iterator iterator() {
        return j$.util.J.i(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Object j(j$.util.function.z zVar, BiConsumer biConsumer, BiConsumer biConsumer2) {
        zVar.getClass();
        biConsumer.getClass();
        biConsumer2.getClass();
        return y0(new C0261z2(EnumC0151f4.REFERENCE, biConsumer2, biConsumer, zVar));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final U k0(j$.util.function.A a) {
        a.getClass();
        return new K(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.p | EnumC0145e4.n, a);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 limit(long j) {
        if (j >= 0) {
            return B3.i(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Object[] m(j$.util.function.m mVar) {
        return AbstractC0251x2.l(z0(mVar), mVar).r(mVar);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Optional max(Comparator comparator) {
        comparator.getClass();
        return u(new C0108a(comparator, 0));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Optional min(Comparator comparator) {
        comparator.getClass();
        return u(new C0108a(comparator, 1));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final IntStream n(ToIntFunction toIntFunction) {
        toIntFunction.getClass();
        return new M(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.p | EnumC0145e4.n, toIntFunction);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Object n0(Object obj, InterfaceC0109b interfaceC0109b) {
        interfaceC0109b.getClass();
        return y0(new C0261z2(EnumC0151f4.REFERENCE, interfaceC0109b, interfaceC0109b, obj));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 o(Function function) {
        function.getClass();
        return new C0120a3(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.p | EnumC0145e4.n, function, 0);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 p(Function function) {
        function.getClass();
        return new C0120a3(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.p | EnumC0145e4.n | EnumC0145e4.t, function, 1);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : B3.i(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 sorted() {
        return new M3(this);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Object[] toArray() {
        W2 w2 = new j$.util.function.m() { // from class: j$.util.stream.W2
            @Override // j$.util.function.m
            public final Object apply(int i) {
                return new Object[i];
            }
        };
        return AbstractC0251x2.l(z0(w2), w2).r(w2);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final Optional u(InterfaceC0109b interfaceC0109b) {
        interfaceC0109b.getClass();
        return (Optional) y0(new D2(EnumC0151f4.REFERENCE, interfaceC0109b));
    }

    @Override // j$.util.stream.AbstractC0256y2
    final InterfaceC0225s1 u0(long j, j$.util.function.m mVar) {
        return AbstractC0251x2.d(j, mVar);
    }

    @Override // j$.util.stream.InterfaceC0152g
    public InterfaceC0152g unordered() {
        return !D0() ? this : new Z2(this, this, EnumC0151f4.REFERENCE, EnumC0145e4.r);
    }

    @Override // j$.util.stream.InterfaceC0127b4
    public final InterfaceC0127b4 sorted(Comparator comparator) {
        return new M3(this, comparator);
    }
}
