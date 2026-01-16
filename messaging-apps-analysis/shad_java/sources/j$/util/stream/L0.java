package j$.util.stream;

import j$.util.C0111h;
import j$.util.C0113j;
import j$.util.C0114k;
import j$.util.function.BiConsumer;
import j$.util.function.ToIntFunction;
import j$.util.p;
import j$.util.t;
import j$.wrappers.C0264a0;
import java.util.Iterator;

/* loaded from: classes2.dex */
abstract class L0 extends AbstractC0128c implements IntStream {
    L0(AbstractC0128c abstractC0128c, int i) {
        super(abstractC0128c, i);
    }

    L0(j$.util.t tVar, int i, boolean z) {
        super(tVar, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t.b N0(j$.util.t tVar) {
        if (tVar instanceof t.b) {
            return (t.b) tVar;
        }
        if (!R4.a) {
            throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
        }
        R4.a(AbstractC0128c.class, "using IntStream.adapt(Spliterator<Integer> s)");
        throw null;
    }

    @Override // j$.util.stream.AbstractC0128c
    final A1 A0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z, j$.util.function.m mVar) {
        return AbstractC0251x2.g(abstractC0256y2, tVar, z);
    }

    @Override // j$.util.stream.IntStream
    public final U B(j$.wrappers.W w) {
        w.getClass();
        return new K(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.p | EnumC0145e4.n, w);
    }

    @Override // j$.util.stream.AbstractC0128c
    final void B0(j$.util.t tVar, InterfaceC0192m3 interfaceC0192m3) {
        j$.util.function.l b0;
        t.b bVarN0 = N0(tVar);
        if (interfaceC0192m3 instanceof j$.util.function.l) {
            b0 = (j$.util.function.l) interfaceC0192m3;
        } else {
            if (R4.a) {
                R4.a(AbstractC0128c.class, "using IntStream.adapt(Sink<Integer> s)");
                throw null;
            }
            b0 = new B0(interfaceC0192m3);
        }
        while (!interfaceC0192m3.p() && bVarN0.j(b0)) {
        }
    }

    @Override // j$.util.stream.AbstractC0128c
    final EnumC0151f4 C0() {
        return EnumC0151f4.INT_VALUE;
    }

    @Override // j$.util.stream.IntStream
    public final boolean D(j$.wrappers.U u) {
        return ((Boolean) y0(AbstractC0202o1.v(u, EnumC0178k1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final boolean G(j$.wrappers.U u) {
        return ((Boolean) y0(AbstractC0202o1.v(u, EnumC0178k1.ANY))).booleanValue();
    }

    public void J(j$.util.function.l lVar) {
        lVar.getClass();
        y0(new C0183l0(lVar, true));
    }

    @Override // j$.util.stream.IntStream
    public final InterfaceC0127b4 K(j$.util.function.m mVar) {
        mVar.getClass();
        return new L(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.p | EnumC0145e4.n, mVar);
    }

    @Override // j$.util.stream.AbstractC0128c
    final j$.util.t L0(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        return new C0222r4(abstractC0256y2, zVar, z);
    }

    @Override // j$.util.stream.IntStream
    public final int O(int i, j$.util.function.j jVar) {
        jVar.getClass();
        return ((Integer) y0(new L2(EnumC0151f4.INT_VALUE, jVar, i))).intValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream Q(j$.util.function.m mVar) {
        return new M(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.p | EnumC0145e4.n | EnumC0145e4.t, mVar);
    }

    public void V(j$.util.function.l lVar) {
        lVar.getClass();
        y0(new C0183l0(lVar, false));
    }

    @Override // j$.util.stream.IntStream
    public final U asDoubleStream() {
        return new O(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.p | EnumC0145e4.n);
    }

    @Override // j$.util.stream.IntStream
    public final InterfaceC0142e1 asLongStream() {
        return new G0(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.p | EnumC0145e4.n);
    }

    @Override // j$.util.stream.IntStream
    public final C0113j average() {
        long[] jArr = (long[]) l0(new j$.util.function.z() { // from class: j$.util.stream.v0
            @Override // j$.util.function.z
            public final Object get() {
                return new long[2];
            }
        }, new j$.util.function.v() { // from class: j$.util.stream.u0
            @Override // j$.util.function.v
            public final void accept(Object obj, int i) {
                long[] jArr2 = (long[]) obj;
                jArr2[0] = jArr2[0] + 1;
                jArr2[1] = jArr2[1] + i;
            }
        }, new BiConsumer() { // from class: j$.util.stream.x0
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new j$.util.concurrent.a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                long[] jArr2 = (long[]) obj;
                long[] jArr3 = (long[]) obj2;
                jArr2[0] = jArr2[0] + jArr3[0];
                jArr2[1] = jArr2[1] + jArr3[1];
            }
        });
        if (jArr[0] <= 0) {
            return C0113j.a();
        }
        double d = jArr[1];
        double d2 = jArr[0];
        Double.isNaN(d);
        Double.isNaN(d2);
        return C0113j.d(d / d2);
    }

    @Override // j$.util.stream.IntStream
    public final C0114k b0(j$.util.function.j jVar) {
        jVar.getClass();
        return (C0114k) y0(new D2(EnumC0151f4.INT_VALUE, jVar));
    }

    @Override // j$.util.stream.IntStream
    public final InterfaceC0127b4 boxed() {
        return K(C0.a);
    }

    @Override // j$.util.stream.IntStream
    public final long count() {
        return ((AbstractC0136d1) g(new j$.util.function.n() { // from class: j$.util.stream.E0
            @Override // j$.util.function.n
            public final long applyAsLong(int i) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream d0(j$.util.function.l lVar) {
        lVar.getClass();
        return new M(this, this, EnumC0151f4.INT_VALUE, 0, lVar);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream distinct() {
        return ((AbstractC0144e3) K(C0.a)).distinct().n(new ToIntFunction() { // from class: j$.util.stream.w0
            @Override // j$.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((Integer) obj).intValue();
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final C0114k findAny() {
        return (C0114k) y0(new C0135d0(false, EnumC0151f4.INT_VALUE, C0114k.a(), X.a, C0117a0.a));
    }

    @Override // j$.util.stream.IntStream
    public final C0114k findFirst() {
        return (C0114k) y0(new C0135d0(true, EnumC0151f4.INT_VALUE, C0114k.a(), X.a, C0117a0.a));
    }

    @Override // j$.util.stream.IntStream
    public final InterfaceC0142e1 g(j$.util.function.n nVar) {
        nVar.getClass();
        return new N(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.p | EnumC0145e4.n, nVar);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream i(j$.wrappers.U u) {
        u.getClass();
        return new M(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.t, u);
    }

    @Override // j$.util.stream.InterfaceC0152g
    public final p.a iterator() {
        return j$.util.J.g(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public Iterator iterator() {
        return j$.util.J.g(spliterator());
    }

    @Override // j$.util.stream.IntStream
    public final Object l0(j$.util.function.z zVar, j$.util.function.v vVar, BiConsumer biConsumer) {
        C c = new C(biConsumer, 1);
        zVar.getClass();
        vVar.getClass();
        return y0(new C0261z2(EnumC0151f4.INT_VALUE, c, vVar, zVar));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream limit(long j) {
        if (j >= 0) {
            return B3.g(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.IntStream
    public final C0114k max() {
        return b0(new j$.util.function.j() { // from class: j$.util.stream.z0
            @Override // j$.util.function.j
            public final int applyAsInt(int i, int i2) {
                return Math.max(i, i2);
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final C0114k min() {
        return b0(new j$.util.function.j() { // from class: j$.util.stream.A0
            @Override // j$.util.function.j
            public final int applyAsInt(int i, int i2) {
                return Math.min(i, i2);
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final IntStream r(C0264a0 c0264a0) {
        c0264a0.getClass();
        return new M(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.p | EnumC0145e4.n, c0264a0);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : B3.g(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream sorted() {
        return new K3(this);
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g
    public final t.b spliterator() {
        return N0(super.spliterator());
    }

    @Override // j$.util.stream.IntStream
    public final int sum() {
        return ((Integer) y0(new L2(EnumC0151f4.INT_VALUE, new j$.util.function.j() { // from class: j$.util.stream.y0
            @Override // j$.util.function.j
            public final int applyAsInt(int i, int i2) {
                return i + i2;
            }
        }, 0))).intValue();
    }

    @Override // j$.util.stream.IntStream
    public final C0111h summaryStatistics() {
        return (C0111h) l0(new j$.util.function.z() { // from class: j$.util.stream.j
            @Override // j$.util.function.z
            public final Object get() {
                return new C0111h();
            }
        }, new j$.util.function.v() { // from class: j$.util.stream.t0
            @Override // j$.util.function.v
            public final void accept(Object obj, int i) {
                ((C0111h) obj).accept(i);
            }
        }, new BiConsumer() { // from class: j$.util.stream.s0
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new j$.util.concurrent.a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((C0111h) obj).a((C0111h) obj2);
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final int[] toArray() {
        return (int[]) AbstractC0251x2.n((InterfaceC0245w1) z0(new j$.util.function.m() { // from class: j$.util.stream.D0
            @Override // j$.util.function.m
            public final Object apply(int i) {
                return new Integer[i];
            }
        })).g();
    }

    @Override // j$.util.stream.AbstractC0256y2
    final InterfaceC0225s1 u0(long j, j$.util.function.m mVar) {
        return AbstractC0251x2.p(j);
    }

    @Override // j$.util.stream.InterfaceC0152g
    public InterfaceC0152g unordered() {
        return !D0() ? this : new H0(this, this, EnumC0151f4.INT_VALUE, EnumC0145e4.r);
    }

    @Override // j$.util.stream.IntStream
    public final boolean w(j$.wrappers.U u) {
        return ((Boolean) y0(AbstractC0202o1.v(u, EnumC0178k1.NONE))).booleanValue();
    }
}
