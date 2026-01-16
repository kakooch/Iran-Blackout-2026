package j$.util.stream;

import j$.util.C0110g;
import j$.util.C0113j;
import j$.util.function.BiConsumer;
import j$.util.t;
import java.util.Iterator;

/* loaded from: classes2.dex */
abstract class T extends AbstractC0128c implements U {
    T(AbstractC0128c abstractC0128c, int i) {
        super(abstractC0128c, i);
    }

    T(j$.util.t tVar, int i, boolean z) {
        super(tVar, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t.a N0(j$.util.t tVar) {
        if (tVar instanceof t.a) {
            return (t.a) tVar;
        }
        if (!R4.a) {
            throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
        }
        R4.a(AbstractC0128c.class, "using DoubleStream.adapt(Spliterator<Double> s)");
        throw null;
    }

    @Override // j$.util.stream.AbstractC0128c
    final A1 A0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z, j$.util.function.m mVar) {
        return AbstractC0251x2.f(abstractC0256y2, tVar, z);
    }

    @Override // j$.util.stream.AbstractC0128c
    final void B0(j$.util.t tVar, InterfaceC0192m3 interfaceC0192m3) {
        j$.util.function.f f;
        t.a aVarN0 = N0(tVar);
        if (interfaceC0192m3 instanceof j$.util.function.f) {
            f = (j$.util.function.f) interfaceC0192m3;
        } else {
            if (R4.a) {
                R4.a(AbstractC0128c.class, "using DoubleStream.adapt(Sink<Double> s)");
                throw null;
            }
            f = new F(interfaceC0192m3);
        }
        while (!interfaceC0192m3.p() && aVarN0.j(f)) {
        }
    }

    @Override // j$.util.stream.AbstractC0128c
    final EnumC0151f4 C0() {
        return EnumC0151f4.DOUBLE_VALUE;
    }

    @Override // j$.util.stream.U
    public final C0113j H(j$.util.function.d dVar) {
        dVar.getClass();
        return (C0113j) y0(new D2(EnumC0151f4.DOUBLE_VALUE, dVar));
    }

    @Override // j$.util.stream.U
    public final Object I(j$.util.function.z zVar, j$.util.function.u uVar, BiConsumer biConsumer) {
        C c = new C(biConsumer, 0);
        zVar.getClass();
        uVar.getClass();
        return y0(new C0261z2(EnumC0151f4.DOUBLE_VALUE, c, uVar, zVar));
    }

    @Override // j$.util.stream.U
    public final double L(double d, j$.util.function.d dVar) {
        dVar.getClass();
        return ((Double) y0(new B2(EnumC0151f4.DOUBLE_VALUE, dVar, d))).doubleValue();
    }

    @Override // j$.util.stream.AbstractC0128c
    final j$.util.t L0(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        return new C0211p4(abstractC0256y2, zVar, z);
    }

    @Override // j$.util.stream.U
    public final InterfaceC0127b4 N(j$.util.function.g gVar) {
        gVar.getClass();
        return new L(this, this, EnumC0151f4.DOUBLE_VALUE, EnumC0145e4.p | EnumC0145e4.n, gVar);
    }

    @Override // j$.util.stream.U
    public final IntStream S(j$.wrappers.F f) {
        f.getClass();
        return new M(this, this, EnumC0151f4.DOUBLE_VALUE, EnumC0145e4.p | EnumC0145e4.n, f);
    }

    @Override // j$.util.stream.U
    public final boolean Z(j$.wrappers.D d) {
        return ((Boolean) y0(AbstractC0202o1.u(d, EnumC0178k1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.U
    public final C0113j average() {
        double[] dArr = (double[]) I(new j$.util.function.z() { // from class: j$.util.stream.x
            @Override // j$.util.function.z
            public final Object get() {
                return new double[4];
            }
        }, new j$.util.function.u() { // from class: j$.util.stream.v
            @Override // j$.util.function.u
            public final void accept(Object obj, double d) {
                double[] dArr2 = (double[]) obj;
                dArr2[2] = dArr2[2] + 1.0d;
                AbstractC0182l.b(dArr2, d);
                dArr2[3] = dArr2[3] + d;
            }
        }, new BiConsumer() { // from class: j$.util.stream.A
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new j$.util.concurrent.a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                double[] dArr2 = (double[]) obj;
                double[] dArr3 = (double[]) obj2;
                AbstractC0182l.b(dArr2, dArr3[0]);
                AbstractC0182l.b(dArr2, dArr3[1]);
                dArr2[2] = dArr2[2] + dArr3[2];
                dArr2[3] = dArr2[3] + dArr3[3];
            }
        });
        return dArr[2] > 0.0d ? C0113j.d(AbstractC0182l.a(dArr) / dArr[2]) : C0113j.a();
    }

    @Override // j$.util.stream.U
    public final InterfaceC0127b4 boxed() {
        return N(G.a);
    }

    @Override // j$.util.stream.U
    public final U c(j$.util.function.f fVar) {
        fVar.getClass();
        return new K(this, this, EnumC0151f4.DOUBLE_VALUE, 0, fVar);
    }

    @Override // j$.util.stream.U
    public final long count() {
        return ((AbstractC0136d1) y(new j$.util.function.h() { // from class: j$.util.stream.H
            @Override // j$.util.function.h
            public final long applyAsLong(double d) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.U
    public final U distinct() {
        return ((AbstractC0144e3) N(G.a)).distinct().k0(new j$.util.function.A() { // from class: j$.util.stream.z
            @Override // j$.util.function.A
            public final double applyAsDouble(Object obj) {
                return ((Double) obj).doubleValue();
            }
        });
    }

    @Override // j$.util.stream.U
    public final C0113j findAny() {
        return (C0113j) y0(new C0135d0(false, EnumC0151f4.DOUBLE_VALUE, C0113j.a(), W.a, Z.a));
    }

    @Override // j$.util.stream.U
    public final C0113j findFirst() {
        return (C0113j) y0(new C0135d0(true, EnumC0151f4.DOUBLE_VALUE, C0113j.a(), W.a, Z.a));
    }

    @Override // j$.util.stream.U
    public final boolean i0(j$.wrappers.D d) {
        return ((Boolean) y0(AbstractC0202o1.u(d, EnumC0178k1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public final j$.util.n iterator() {
        return j$.util.J.f(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public Iterator iterator() {
        return j$.util.J.f(spliterator());
    }

    @Override // j$.util.stream.U
    public final boolean j0(j$.wrappers.D d) {
        return ((Boolean) y0(AbstractC0202o1.u(d, EnumC0178k1.NONE))).booleanValue();
    }

    public void k(j$.util.function.f fVar) {
        fVar.getClass();
        y0(new C0177k0(fVar, false));
    }

    @Override // j$.util.stream.U
    public final U limit(long j) {
        if (j >= 0) {
            return B3.f(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    public void m0(j$.util.function.f fVar) {
        fVar.getClass();
        y0(new C0177k0(fVar, true));
    }

    @Override // j$.util.stream.U
    public final C0113j max() {
        return H(new j$.util.function.d() { // from class: j$.util.stream.D
            @Override // j$.util.function.d
            public final double applyAsDouble(double d, double d2) {
                return Math.max(d, d2);
            }
        });
    }

    @Override // j$.util.stream.U
    public final C0113j min() {
        return H(new j$.util.function.d() { // from class: j$.util.stream.E
            @Override // j$.util.function.d
            public final double applyAsDouble(double d, double d2) {
                return Math.min(d, d2);
            }
        });
    }

    @Override // j$.util.stream.U
    public final U s(j$.wrappers.D d) {
        d.getClass();
        return new K(this, this, EnumC0151f4.DOUBLE_VALUE, EnumC0145e4.t, d);
    }

    @Override // j$.util.stream.U
    public final U skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : B3.f(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.U
    public final U sorted() {
        return new J3(this);
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g
    public final t.a spliterator() {
        return N0(super.spliterator());
    }

    @Override // j$.util.stream.U
    public final double sum() {
        return AbstractC0182l.a((double[]) I(new j$.util.function.z() { // from class: j$.util.stream.y
            @Override // j$.util.function.z
            public final Object get() {
                return new double[3];
            }
        }, new j$.util.function.u() { // from class: j$.util.stream.w
            @Override // j$.util.function.u
            public final void accept(Object obj, double d) {
                double[] dArr = (double[]) obj;
                AbstractC0182l.b(dArr, d);
                dArr[2] = dArr[2] + d;
            }
        }, new BiConsumer() { // from class: j$.util.stream.B
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new j$.util.concurrent.a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                AbstractC0182l.b(dArr, dArr2[0]);
                AbstractC0182l.b(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
            }
        }));
    }

    @Override // j$.util.stream.U
    public final C0110g summaryStatistics() {
        return (C0110g) I(new j$.util.function.z() { // from class: j$.util.stream.i
            @Override // j$.util.function.z
            public final Object get() {
                return new C0110g();
            }
        }, new j$.util.function.u() { // from class: j$.util.stream.u
            @Override // j$.util.function.u
            public final void accept(Object obj, double d) {
                ((C0110g) obj).accept(d);
            }
        }, new BiConsumer() { // from class: j$.util.stream.t
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new j$.util.concurrent.a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((C0110g) obj).a((C0110g) obj2);
            }
        });
    }

    @Override // j$.util.stream.U
    public final double[] toArray() {
        return (double[]) AbstractC0251x2.m((InterfaceC0235u1) z0(new j$.util.function.m() { // from class: j$.util.stream.I
            @Override // j$.util.function.m
            public final Object apply(int i) {
                return new Double[i];
            }
        })).g();
    }

    @Override // j$.util.stream.AbstractC0256y2
    final InterfaceC0225s1 u0(long j, j$.util.function.m mVar) {
        return AbstractC0251x2.j(j);
    }

    @Override // j$.util.stream.InterfaceC0152g
    public InterfaceC0152g unordered() {
        return !D0() ? this : new O(this, this, EnumC0151f4.DOUBLE_VALUE, EnumC0145e4.r);
    }

    @Override // j$.util.stream.U
    public final U x(j$.util.function.g gVar) {
        return new K(this, this, EnumC0151f4.DOUBLE_VALUE, EnumC0145e4.p | EnumC0145e4.n | EnumC0145e4.t, gVar);
    }

    @Override // j$.util.stream.U
    public final InterfaceC0142e1 y(j$.util.function.h hVar) {
        hVar.getClass();
        return new N(this, this, EnumC0151f4.DOUBLE_VALUE, EnumC0145e4.p | EnumC0145e4.n, hVar);
    }

    @Override // j$.util.stream.U
    public final U z(j$.wrappers.J j) {
        j.getClass();
        return new K(this, this, EnumC0151f4.DOUBLE_VALUE, EnumC0145e4.p | EnumC0145e4.n, j);
    }
}
