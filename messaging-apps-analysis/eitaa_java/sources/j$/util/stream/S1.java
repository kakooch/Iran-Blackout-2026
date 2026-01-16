package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0171r1;
import j$.util.stream.B1;
import j$.util.stream.C2;
import j$.util.stream.F1;
import j$.util.stream.T1;

/* loaded from: classes2.dex */
public final /* synthetic */ class S1 {
    public static void a(C2.e eVar, Double d) {
        if (k3.a) {
            k3.a(eVar.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
        eVar.accept(d.doubleValue());
    }

    public static void b(C2.f fVar, Integer num) {
        if (k3.a) {
            k3.a(fVar.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
        fVar.accept(num.intValue());
    }

    public static void c(C2.g gVar, Long l) {
        if (k3.a) {
            k3.a(gVar.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
        gVar.accept(l.longValue());
    }

    public static Object[] d(T1.e eVar, j$.util.function.z zVar) {
        if (k3.a) {
            k3.a(eVar.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        }
        if (eVar.count() >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) zVar.apply((int) eVar.count());
        eVar.i(objArr, 0);
        return objArr;
    }

    public static void e(T1.b bVar, Double[] dArr, int i) {
        if (k3.a) {
            k3.a(bVar.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) bVar.e();
        for (int i2 = 0; i2 < dArr2.length; i2++) {
            dArr[i + i2] = Double.valueOf(dArr2[i2]);
        }
    }

    public static void f(T1.c cVar, Integer[] numArr, int i) {
        if (k3.a) {
            k3.a(cVar.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) cVar.e();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i + i2] = Integer.valueOf(iArr[i2]);
        }
    }

    public static void g(T1.d dVar, Long[] lArr, int i) {
        if (k3.a) {
            k3.a(dVar.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) dVar.e();
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i + i2] = Long.valueOf(jArr[i2]);
        }
    }

    public static void h(T1.b bVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.s) {
            bVar.g((j$.util.function.s) consumer);
        } else {
            if (k3.a) {
                k3.a(bVar.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((Spliterator.a) bVar.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void i(T1.c cVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.y) {
            cVar.g((j$.util.function.y) consumer);
        } else {
            if (k3.a) {
                k3.a(cVar.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                throw null;
            }
            ((Spliterator.b) cVar.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void j(T1.d dVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.E) {
            dVar.g((j$.util.function.E) consumer);
        } else {
            if (k3.a) {
                k3.a(dVar.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((Spliterator.c) dVar.spliterator()).forEachRemaining(consumer);
        }
    }

    public static T1.b k(T1.b bVar, long j, long j2, j$.util.function.z zVar) {
        if (j == 0 && j2 == bVar.count()) {
            return bVar;
        }
        long j3 = j2 - j;
        Spliterator.a aVar = (Spliterator.a) bVar.spliterator();
        T1.a.InterfaceC0047a interfaceC0047aJ = U1.j(j3);
        interfaceC0047aJ.m(j3);
        for (int i = 0; i < j && aVar.tryAdvance(new j$.util.function.s() { // from class: j$.util.stream.i0
            @Override // j$.util.function.s
            public final void accept(double d) {
            }

            @Override // j$.util.function.s
            public j$.util.function.s j(j$.util.function.s sVar) {
                sVar.getClass();
                return new C0095f(this, sVar);
            }
        }); i++) {
        }
        for (int i2 = 0; i2 < j3 && aVar.tryAdvance(interfaceC0047aJ); i2++) {
        }
        interfaceC0047aJ.l();
        return interfaceC0047aJ.a();
    }

    public static T1.c l(T1.c cVar, long j, long j2, j$.util.function.z zVar) {
        if (j == 0 && j2 == cVar.count()) {
            return cVar;
        }
        long j3 = j2 - j;
        Spliterator.b bVar = (Spliterator.b) cVar.spliterator();
        T1.a.b bVarP = U1.p(j3);
        bVarP.m(j3);
        for (int i = 0; i < j && bVar.tryAdvance(new j$.util.function.y() { // from class: j$.util.stream.j0
            @Override // j$.util.function.y
            public final void accept(int i2) {
            }

            @Override // j$.util.function.y
            public j$.util.function.y k(j$.util.function.y yVar) {
                yVar.getClass();
                return new C0098i(this, yVar);
            }
        }); i++) {
        }
        for (int i2 = 0; i2 < j3 && bVar.tryAdvance(bVarP); i2++) {
        }
        bVarP.l();
        return bVarP.a();
    }

    public static T1.d m(T1.d dVar, long j, long j2, j$.util.function.z zVar) {
        if (j == 0 && j2 == dVar.count()) {
            return dVar;
        }
        long j3 = j2 - j;
        Spliterator.c cVar = (Spliterator.c) dVar.spliterator();
        T1.a.c cVarQ = U1.q(j3);
        cVarQ.m(j3);
        for (int i = 0; i < j && cVar.tryAdvance(new j$.util.function.E() { // from class: j$.util.stream.k0
            @Override // j$.util.function.E
            public final void accept(long j4) {
            }

            @Override // j$.util.function.E
            public j$.util.function.E f(j$.util.function.E e) {
                e.getClass();
                return new C0099j(this, e);
            }
        }); i++) {
        }
        for (int i2 = 0; i2 < j3 && cVar.tryAdvance(cVarQ); i2++) {
        }
        cVarQ.l();
        return cVarQ.a();
    }

    public static T1 n(T1 t1, long j, long j2, j$.util.function.z zVar) {
        if (j == 0 && j2 == t1.count()) {
            return t1;
        }
        Spliterator spliterator = t1.spliterator();
        long j3 = j2 - j;
        T1.a aVarD = U1.d(j3, zVar);
        aVarD.m(j3);
        for (int i = 0; i < j && spliterator.b(new Consumer() { // from class: j$.util.stream.h0
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        }); i++) {
        }
        for (int i2 = 0; i2 < j3 && spliterator.b(aVarD); i2++) {
        }
        aVarD.l();
        return aVarD.a();
    }

    public static InterfaceC0183u1 o(Spliterator.a aVar, boolean z) {
        return new AbstractC0171r1.g(aVar, V2.l(aVar), z);
    }

    public static E1 p(Spliterator.b bVar, boolean z) {
        return new B1.i(bVar, V2.l(bVar), z);
    }

    public static J1 q(Spliterator.c cVar, boolean z) {
        return new F1.g(cVar, V2.l(cVar), z);
    }

    public static i3 r(final j$.util.function.u uVar, final P1 p1) {
        uVar.getClass();
        p1.getClass();
        return new Q1(W2.DOUBLE_VALUE, p1, new j$.util.function.L() { // from class: j$.util.stream.c0
            @Override // j$.util.function.L
            public final Object get() {
                return new N1(p1, uVar);
            }
        });
    }

    public static i3 s(final j$.util.function.A a, final P1 p1) {
        a.getClass();
        p1.getClass();
        return new Q1(W2.INT_VALUE, p1, new j$.util.function.L() { // from class: j$.util.stream.e0
            @Override // j$.util.function.L
            public final Object get() {
                return new L1(p1, a);
            }
        });
    }

    public static i3 t(final j$.util.function.G g, final P1 p1) {
        g.getClass();
        p1.getClass();
        return new Q1(W2.LONG_VALUE, p1, new j$.util.function.L() { // from class: j$.util.stream.f0
            @Override // j$.util.function.L
            public final Object get() {
                return new M1(p1, g);
            }
        });
    }

    public static i3 u(final Predicate predicate, final P1 p1) {
        predicate.getClass();
        p1.getClass();
        return new Q1(W2.REFERENCE, p1, new j$.util.function.L() { // from class: j$.util.stream.d0
            @Override // j$.util.function.L
            public final Object get() {
                return new K1(p1, predicate);
            }
        });
    }

    public static Stream v(Spliterator spliterator, boolean z) {
        spliterator.getClass();
        return new A2.k(spliterator, V2.l(spliterator), z);
    }
}
