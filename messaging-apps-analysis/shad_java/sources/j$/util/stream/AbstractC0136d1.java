package j$.util.stream;

import j$.util.C0112i;
import j$.util.C0113j;
import j$.util.C0115l;
import j$.util.function.BiConsumer;
import j$.util.t;
import j$.wrappers.C0280i0;
import j$.wrappers.C0284k0;
import j$.wrappers.C0288m0;
import java.util.Iterator;

/* renamed from: j$.util.stream.d1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0136d1 extends AbstractC0128c implements InterfaceC0142e1 {
    AbstractC0136d1(AbstractC0128c abstractC0128c, int i) {
        super(abstractC0128c, i);
    }

    AbstractC0136d1(j$.util.t tVar, int i, boolean z) {
        super(tVar, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t.c N0(j$.util.t tVar) {
        if (tVar instanceof t.c) {
            return (t.c) tVar;
        }
        if (!R4.a) {
            throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
        }
        R4.a(AbstractC0128c.class, "using LongStream.adapt(Spliterator<Long> s)");
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0142e1 A(j$.util.function.t tVar) {
        tVar.getClass();
        return new N(this, this, EnumC0151f4.LONG_VALUE, EnumC0145e4.p | EnumC0145e4.n, tVar);
    }

    @Override // j$.util.stream.AbstractC0128c
    final A1 A0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z, j$.util.function.m mVar) {
        return AbstractC0251x2.h(abstractC0256y2, tVar, z);
    }

    @Override // j$.util.stream.AbstractC0128c
    final void B0(j$.util.t tVar, InterfaceC0192m3 interfaceC0192m3) {
        j$.util.function.q w0;
        t.c cVarN0 = N0(tVar);
        if (interfaceC0192m3 instanceof j$.util.function.q) {
            w0 = (j$.util.function.q) interfaceC0192m3;
        } else {
            if (R4.a) {
                R4.a(AbstractC0128c.class, "using LongStream.adapt(Sink<Long> s)");
                throw null;
            }
            w0 = new W0(interfaceC0192m3);
        }
        while (!interfaceC0192m3.p() && cVarN0.j(w0)) {
        }
    }

    @Override // j$.util.stream.AbstractC0128c
    final EnumC0151f4 C0() {
        return EnumC0151f4.LONG_VALUE;
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final long E(long j, j$.util.function.o oVar) {
        oVar.getClass();
        return ((Long) y0(new P2(EnumC0151f4.LONG_VALUE, oVar, j))).longValue();
    }

    @Override // j$.util.stream.AbstractC0128c
    final j$.util.t L0(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        return new t4(abstractC0256y2, zVar, z);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final boolean M(C0280i0 c0280i0) {
        return ((Boolean) y0(AbstractC0202o1.w(c0280i0, EnumC0178k1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final U P(C0284k0 c0284k0) {
        c0284k0.getClass();
        return new K(this, this, EnumC0151f4.LONG_VALUE, EnumC0145e4.p | EnumC0145e4.n, c0284k0);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0127b4 R(j$.util.function.r rVar) {
        rVar.getClass();
        return new L(this, this, EnumC0151f4.LONG_VALUE, EnumC0145e4.p | EnumC0145e4.n, rVar);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final boolean T(C0280i0 c0280i0) {
        return ((Boolean) y0(AbstractC0202o1.w(c0280i0, EnumC0178k1.NONE))).booleanValue();
    }

    public void a0(j$.util.function.q qVar) {
        qVar.getClass();
        y0(new C0189m0(qVar, true));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final U asDoubleStream() {
        return new O(this, this, EnumC0151f4.LONG_VALUE, EnumC0145e4.p | EnumC0145e4.n);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final C0113j average() {
        long[] jArr = (long[]) g0(new j$.util.function.z() { // from class: j$.util.stream.P0
            @Override // j$.util.function.z
            public final Object get() {
                return new long[2];
            }
        }, new j$.util.function.w() { // from class: j$.util.stream.O0
            @Override // j$.util.function.w
            public final void accept(Object obj, long j) {
                long[] jArr2 = (long[]) obj;
                jArr2[0] = jArr2[0] + 1;
                jArr2[1] = jArr2[1] + j;
            }
        }, new BiConsumer() { // from class: j$.util.stream.R0
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

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0127b4 boxed() {
        return R(X0.a);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final long count() {
        return ((AbstractC0136d1) A(new j$.util.function.t() { // from class: j$.util.stream.Y0
            @Override // j$.util.function.t
            public j$.util.function.t a(j$.util.function.t tVar) {
                tVar.getClass();
                return new j$.util.function.s(this, tVar, 0);
            }

            @Override // j$.util.function.t
            public final long applyAsLong(long j) {
                return 1L;
            }

            @Override // j$.util.function.t
            public j$.util.function.t b(j$.util.function.t tVar) {
                tVar.getClass();
                return new j$.util.function.s(this, tVar, 1);
            }
        })).sum();
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0142e1 distinct() {
        return ((AbstractC0144e3) R(X0.a)).distinct().h0(new j$.util.function.B() { // from class: j$.util.stream.Q0
            @Override // j$.util.function.B
            public final long applyAsLong(Object obj) {
                return ((Long) obj).longValue();
            }
        });
    }

    public void e(j$.util.function.q qVar) {
        qVar.getClass();
        y0(new C0189m0(qVar, false));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final IntStream f0(C0288m0 c0288m0) {
        c0288m0.getClass();
        return new M(this, this, EnumC0151f4.LONG_VALUE, EnumC0145e4.p | EnumC0145e4.n, c0288m0);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final C0115l findAny() {
        return (C0115l) y0(new C0135d0(false, EnumC0151f4.LONG_VALUE, C0115l.a(), Y.a, C0123b0.a));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final C0115l findFirst() {
        return (C0115l) y0(new C0135d0(true, EnumC0151f4.LONG_VALUE, C0115l.a(), Y.a, C0123b0.a));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final Object g0(j$.util.function.z zVar, j$.util.function.w wVar, BiConsumer biConsumer) {
        C c = new C(biConsumer, 2);
        zVar.getClass();
        wVar.getClass();
        return y0(new C0261z2(EnumC0151f4.LONG_VALUE, c, wVar, zVar));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final C0115l h(j$.util.function.o oVar) {
        oVar.getClass();
        return (C0115l) y0(new D2(EnumC0151f4.LONG_VALUE, oVar));
    }

    @Override // j$.util.stream.InterfaceC0152g
    public final j$.util.r iterator() {
        return j$.util.J.h(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public Iterator iterator() {
        return j$.util.J.h(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final boolean l(C0280i0 c0280i0) {
        return ((Boolean) y0(AbstractC0202o1.w(c0280i0, EnumC0178k1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0142e1 limit(long j) {
        if (j >= 0) {
            return B3.h(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final C0115l max() {
        return h(new j$.util.function.o() { // from class: j$.util.stream.U0
            @Override // j$.util.function.o
            public final long applyAsLong(long j, long j2) {
                return Math.max(j, j2);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final C0115l min() {
        return h(new j$.util.function.o() { // from class: j$.util.stream.V0
            @Override // j$.util.function.o
            public final long applyAsLong(long j, long j2) {
                return Math.min(j, j2);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0142e1 q(j$.util.function.q qVar) {
        qVar.getClass();
        return new N(this, this, EnumC0151f4.LONG_VALUE, 0, qVar);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0142e1 skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : B3.h(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0142e1 sorted() {
        return new L3(this);
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g
    public final t.c spliterator() {
        return N0(super.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final long sum() {
        return ((Long) y0(new P2(EnumC0151f4.LONG_VALUE, new j$.util.function.o() { // from class: j$.util.stream.T0
            @Override // j$.util.function.o
            public final long applyAsLong(long j, long j2) {
                return j + j2;
            }
        }, 0L))).longValue();
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final C0112i summaryStatistics() {
        return (C0112i) g0(new j$.util.function.z() { // from class: j$.util.stream.k
            @Override // j$.util.function.z
            public final Object get() {
                return new C0112i();
            }
        }, new j$.util.function.w() { // from class: j$.util.stream.N0
            @Override // j$.util.function.w
            public final void accept(Object obj, long j) {
                ((C0112i) obj).accept(j);
            }
        }, new BiConsumer() { // from class: j$.util.stream.M0
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new j$.util.concurrent.a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((C0112i) obj).a((C0112i) obj2);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0142e1 t(j$.util.function.r rVar) {
        return new N(this, this, EnumC0151f4.LONG_VALUE, EnumC0145e4.p | EnumC0145e4.n | EnumC0145e4.t, rVar);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final long[] toArray() {
        return (long[]) AbstractC0251x2.o((InterfaceC0255y1) z0(new j$.util.function.m() { // from class: j$.util.stream.S0
            @Override // j$.util.function.m
            public final Object apply(int i) {
                return new Long[i];
            }
        })).g();
    }

    @Override // j$.util.stream.AbstractC0256y2
    final InterfaceC0225s1 u0(long j, j$.util.function.m mVar) {
        return AbstractC0251x2.q(j);
    }

    @Override // j$.util.stream.InterfaceC0152g
    public InterfaceC0152g unordered() {
        return !D0() ? this : new G0(this, this, EnumC0151f4.LONG_VALUE, EnumC0145e4.r);
    }

    @Override // j$.util.stream.InterfaceC0142e1
    public final InterfaceC0142e1 v(C0280i0 c0280i0) {
        c0280i0.getClass();
        return new N(this, this, EnumC0151f4.LONG_VALUE, EnumC0145e4.t, c0280i0);
    }
}
