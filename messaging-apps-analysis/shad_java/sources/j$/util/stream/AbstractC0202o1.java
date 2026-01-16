package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.t;
import j$.wrappers.C0280i0;

/* renamed from: j$.util.stream.o1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0202o1 {
    public static void a(InterfaceC0174j3 interfaceC0174j3, Double d) {
        if (R4.a) {
            R4.a(interfaceC0174j3.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
        interfaceC0174j3.accept(d.doubleValue());
    }

    public static void b(InterfaceC0180k3 interfaceC0180k3, Integer num) {
        if (R4.a) {
            R4.a(interfaceC0180k3.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
        interfaceC0180k3.accept(num.intValue());
    }

    public static void c(InterfaceC0186l3 interfaceC0186l3, Long l) {
        if (R4.a) {
            R4.a(interfaceC0186l3.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
        interfaceC0186l3.accept(l.longValue());
    }

    public static void d(InterfaceC0192m3 interfaceC0192m3) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void e(InterfaceC0192m3 interfaceC0192m3) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void f(InterfaceC0192m3 interfaceC0192m3) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static Object[] g(InterfaceC0260z1 interfaceC0260z1, j$.util.function.m mVar) {
        if (R4.a) {
            R4.a(interfaceC0260z1.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        }
        if (interfaceC0260z1.count() >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) mVar.apply((int) interfaceC0260z1.count());
        interfaceC0260z1.j(objArr, 0);
        return objArr;
    }

    public static void h(InterfaceC0235u1 interfaceC0235u1, Double[] dArr, int i) {
        if (R4.a) {
            R4.a(interfaceC0235u1.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) interfaceC0235u1.g();
        for (int i2 = 0; i2 < dArr2.length; i2++) {
            dArr[i + i2] = Double.valueOf(dArr2[i2]);
        }
    }

    public static void i(InterfaceC0245w1 interfaceC0245w1, Integer[] numArr, int i) {
        if (R4.a) {
            R4.a(interfaceC0245w1.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) interfaceC0245w1.g();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i + i2] = Integer.valueOf(iArr[i2]);
        }
    }

    public static void j(InterfaceC0255y1 interfaceC0255y1, Long[] lArr, int i) {
        if (R4.a) {
            R4.a(interfaceC0255y1.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) interfaceC0255y1.g();
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i + i2] = Long.valueOf(jArr[i2]);
        }
    }

    public static void k(InterfaceC0235u1 interfaceC0235u1, Consumer consumer) {
        if (consumer instanceof j$.util.function.f) {
            interfaceC0235u1.h((j$.util.function.f) consumer);
        } else {
            if (R4.a) {
                R4.a(interfaceC0235u1.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((t.a) interfaceC0235u1.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void l(InterfaceC0245w1 interfaceC0245w1, Consumer consumer) {
        if (consumer instanceof j$.util.function.l) {
            interfaceC0245w1.h((j$.util.function.l) consumer);
        } else {
            if (R4.a) {
                R4.a(interfaceC0245w1.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                throw null;
            }
            ((t.b) interfaceC0245w1.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void m(InterfaceC0255y1 interfaceC0255y1, Consumer consumer) {
        if (consumer instanceof j$.util.function.q) {
            interfaceC0255y1.h((j$.util.function.q) consumer);
        } else {
            if (R4.a) {
                R4.a(interfaceC0255y1.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((t.c) interfaceC0255y1.spliterator()).forEachRemaining(consumer);
        }
    }

    public static InterfaceC0235u1 n(InterfaceC0235u1 interfaceC0235u1, long j, long j2, j$.util.function.m mVar) {
        if (j == 0 && j2 == interfaceC0235u1.count()) {
            return interfaceC0235u1;
        }
        long j3 = j2 - j;
        t.a aVar = (t.a) interfaceC0235u1.spliterator();
        InterfaceC0208p1 interfaceC0208p1J = AbstractC0251x2.j(j3);
        interfaceC0208p1J.o(j3);
        for (int i = 0; i < j && aVar.j(new j$.util.function.f() { // from class: j$.util.stream.t1
            @Override // j$.util.function.f
            public final void accept(double d) {
            }

            @Override // j$.util.function.f
            public j$.util.function.f k(j$.util.function.f fVar) {
                fVar.getClass();
                return new j$.util.function.e(this, fVar);
            }
        }); i++) {
        }
        for (int i2 = 0; i2 < j3 && aVar.j(interfaceC0208p1J); i2++) {
        }
        interfaceC0208p1J.n();
        return interfaceC0208p1J.b();
    }

    public static InterfaceC0245w1 o(InterfaceC0245w1 interfaceC0245w1, long j, long j2, j$.util.function.m mVar) {
        if (j == 0 && j2 == interfaceC0245w1.count()) {
            return interfaceC0245w1;
        }
        long j3 = j2 - j;
        t.b bVar = (t.b) interfaceC0245w1.spliterator();
        InterfaceC0214q1 interfaceC0214q1P = AbstractC0251x2.p(j3);
        interfaceC0214q1P.o(j3);
        for (int i = 0; i < j && bVar.j(new j$.util.function.l() { // from class: j$.util.stream.v1
            @Override // j$.util.function.l
            public final void accept(int i2) {
            }

            @Override // j$.util.function.l
            public j$.util.function.l m(j$.util.function.l lVar) {
                lVar.getClass();
                return new j$.util.function.k(this, lVar);
            }
        }); i++) {
        }
        for (int i2 = 0; i2 < j3 && bVar.j(interfaceC0214q1P); i2++) {
        }
        interfaceC0214q1P.n();
        return interfaceC0214q1P.b();
    }

    public static InterfaceC0255y1 p(InterfaceC0255y1 interfaceC0255y1, long j, long j2, j$.util.function.m mVar) {
        if (j == 0 && j2 == interfaceC0255y1.count()) {
            return interfaceC0255y1;
        }
        long j3 = j2 - j;
        t.c cVar = (t.c) interfaceC0255y1.spliterator();
        InterfaceC0219r1 interfaceC0219r1Q = AbstractC0251x2.q(j3);
        interfaceC0219r1Q.o(j3);
        for (int i = 0; i < j && cVar.j(new j$.util.function.q() { // from class: j$.util.stream.x1
            @Override // j$.util.function.q
            public final void accept(long j4) {
            }

            @Override // j$.util.function.q
            public j$.util.function.q f(j$.util.function.q qVar) {
                qVar.getClass();
                return new j$.util.function.p(this, qVar);
            }
        }); i++) {
        }
        for (int i2 = 0; i2 < j3 && cVar.j(interfaceC0219r1Q); i2++) {
        }
        interfaceC0219r1Q.n();
        return interfaceC0219r1Q.b();
    }

    public static A1 q(A1 a1, long j, long j2, j$.util.function.m mVar) {
        if (j == 0 && j2 == a1.count()) {
            return a1;
        }
        j$.util.t tVarSpliterator = a1.spliterator();
        long j3 = j2 - j;
        InterfaceC0225s1 interfaceC0225s1D = AbstractC0251x2.d(j3, mVar);
        interfaceC0225s1D.o(j3);
        for (int i = 0; i < j && tVarSpliterator.a(new Consumer() { // from class: j$.util.stream.n1
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        }); i++) {
        }
        for (int i2 = 0; i2 < j3 && tVarSpliterator.a(interfaceC0225s1D); i2++) {
        }
        interfaceC0225s1D.n();
        return interfaceC0225s1D.b();
    }

    public static U r(t.a aVar, boolean z) {
        return new P(aVar, EnumC0145e4.c(aVar), z);
    }

    public static IntStream s(t.b bVar, boolean z) {
        return new I0(bVar, EnumC0145e4.c(bVar), z);
    }

    public static InterfaceC0142e1 t(t.c cVar, boolean z) {
        return new C0118a1(cVar, EnumC0145e4.c(cVar), z);
    }

    public static O4 u(j$.wrappers.D d, EnumC0178k1 enumC0178k1) {
        d.getClass();
        enumC0178k1.getClass();
        return new C0184l1(EnumC0151f4.DOUBLE_VALUE, enumC0178k1, new C0200o(enumC0178k1, d));
    }

    public static O4 v(j$.wrappers.U u, EnumC0178k1 enumC0178k1) {
        u.getClass();
        enumC0178k1.getClass();
        return new C0184l1(EnumC0151f4.INT_VALUE, enumC0178k1, new C0200o(enumC0178k1, u));
    }

    public static O4 w(C0280i0 c0280i0, EnumC0178k1 enumC0178k1) {
        c0280i0.getClass();
        enumC0178k1.getClass();
        return new C0184l1(EnumC0151f4.LONG_VALUE, enumC0178k1, new C0200o(enumC0178k1, c0280i0));
    }

    public static O4 x(j$.util.function.y yVar, EnumC0178k1 enumC0178k1) {
        yVar.getClass();
        enumC0178k1.getClass();
        return new C0184l1(EnumC0151f4.REFERENCE, enumC0178k1, new C0200o(enumC0178k1, yVar));
    }

    public static InterfaceC0127b4 y(j$.util.t tVar, boolean z) {
        tVar.getClass();
        return new C0126b3(tVar, EnumC0145e4.c(tVar), z);
    }
}
