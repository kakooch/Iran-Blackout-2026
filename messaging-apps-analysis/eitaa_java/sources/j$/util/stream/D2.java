package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0171r1;
import j$.util.stream.B1;
import j$.util.stream.C2;
import j$.util.stream.F1;
import j$.util.stream.T1;
import j$.util.stream.e3;
import j$.util.stream.f3;

/* loaded from: classes2.dex */
final class D2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> extends A2.l<T, T> {
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        /* renamed from: j$.util.stream.D2$a$a, reason: collision with other inner class name */
        class C0045a extends C2.d<T, T> {
            long b;
            long c;

            C0045a(C2 c2) {
                super(c2);
                this.b = a.this.l;
                long j = a.this.m;
                this.c = j < 0 ? Long.MAX_VALUE : j;
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                long j = this.b;
                if (j != 0) {
                    this.b = j - 1;
                    return;
                }
                long j2 = this.c;
                if (j2 > 0) {
                    this.c = j2 - 1;
                    this.a.accept(obj);
                }
            }

            @Override // j$.util.stream.C2.d, j$.util.stream.C2
            public void m(long j) {
                this.a.m(D2.c(j, a.this.l, this.c));
            }

            @Override // j$.util.stream.C2.d, j$.util.stream.C2
            public boolean o() {
                return this.c == 0 || this.a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC0148l1 abstractC0148l1, W2 w2, int i, long j, long j2) {
            super(abstractC0148l1, w2, i);
            this.l = j;
            this.m = j2;
        }

        @Override // j$.util.stream.AbstractC0148l1
        T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
            long jO0 = v1.o0(spliterator);
            return (jO0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !V2.ORDERED.n(v1.q0()) ? U1.e(this, J0(v1.u0(spliterator), this.l, this.m, jO0), true, zVar) : new e(this, v1, spliterator, zVar, this.l, this.m).invoke() : U1.e(v1, D2.b(v1.p0(), spliterator, this.l, this.m), true, zVar);
        }

        @Override // j$.util.stream.AbstractC0148l1
        Spliterator D0(V1 v1, Spliterator spliterator) {
            long jO0 = v1.o0(spliterator);
            if (jO0 > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator spliteratorU0 = v1.u0(spliterator);
                long j = this.l;
                return new e3.e(spliteratorU0, j, D2.d(j, this.m));
            }
            return !V2.ORDERED.n(v1.q0()) ? J0(v1.u0(spliterator), this.l, this.m, jO0) : new e(this, v1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.v0
                @Override // j$.util.function.z
                public final Object apply(int i) {
                    return new Object[i];
                }
            }, this.l, this.m).invoke().spliterator();
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new C0045a(c2);
        }

        Spliterator J0(Spliterator spliterator, long j, long j2, long j3) {
            long j4;
            long jMin;
            if (j <= j3) {
                long j5 = j3 - j;
                jMin = j2 >= 0 ? Math.min(j2, j5) : j5;
                j4 = 0;
            } else {
                j4 = j;
                jMin = j2;
            }
            return new f3.e(spliterator, j4, jMin);
        }
    }

    class b extends B1.j<Integer> {
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        class a extends C2.b<Integer> {
            long b;
            long c;

            a(C2 c2) {
                super(c2);
                this.b = b.this.l;
                long j = b.this.m;
                this.c = j < 0 ? Long.MAX_VALUE : j;
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public void accept(int i) {
                long j = this.b;
                if (j != 0) {
                    this.b = j - 1;
                    return;
                }
                long j2 = this.c;
                if (j2 > 0) {
                    this.c = j2 - 1;
                    this.a.accept(i);
                }
            }

            @Override // j$.util.stream.C2.b, j$.util.stream.C2
            public void m(long j) {
                this.a.m(D2.c(j, b.this.l, this.c));
            }

            @Override // j$.util.stream.C2.b, j$.util.stream.C2
            public boolean o() {
                return this.c == 0 || this.a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC0148l1 abstractC0148l1, W2 w2, int i, long j, long j2) {
            super(abstractC0148l1, w2, i);
            this.l = j;
            this.m = j2;
        }

        @Override // j$.util.stream.AbstractC0148l1
        T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
            long jO0 = v1.o0(spliterator);
            return (jO0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !V2.ORDERED.n(v1.q0()) ? U1.g(this, L0((Spliterator.b) v1.u0(spliterator), this.l, this.m, jO0), true) : new e(this, v1, spliterator, zVar, this.l, this.m).invoke() : U1.g(v1, D2.b(v1.p0(), spliterator, this.l, this.m), true);
        }

        @Override // j$.util.stream.AbstractC0148l1
        Spliterator D0(V1 v1, Spliterator spliterator) {
            long jO0 = v1.o0(spliterator);
            if (jO0 > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.b bVar = (Spliterator.b) v1.u0(spliterator);
                long j = this.l;
                return new e3.b(bVar, j, D2.d(j, this.m));
            }
            return !V2.ORDERED.n(v1.q0()) ? L0((Spliterator.b) v1.u0(spliterator), this.l, this.m, jO0) : new e(this, v1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.u0
                @Override // j$.util.function.z
                public final Object apply(int i) {
                    return new Integer[i];
                }
            }, this.l, this.m).invoke().spliterator();
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }

        Spliterator.b L0(Spliterator.b bVar, long j, long j2, long j3) {
            long j4;
            long jMin;
            if (j <= j3) {
                long j5 = j3 - j;
                jMin = j2 >= 0 ? Math.min(j2, j5) : j5;
                j4 = 0;
            } else {
                j4 = j;
                jMin = j2;
            }
            return new f3.b(bVar, j4, jMin);
        }
    }

    class c extends F1.h<Long> {
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        class a extends C2.c<Long> {
            long b;
            long c;

            a(C2 c2) {
                super(c2);
                this.b = c.this.l;
                long j = c.this.m;
                this.c = j < 0 ? Long.MAX_VALUE : j;
            }

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public void accept(long j) {
                long j2 = this.b;
                if (j2 != 0) {
                    this.b = j2 - 1;
                    return;
                }
                long j3 = this.c;
                if (j3 > 0) {
                    this.c = j3 - 1;
                    this.a.accept(j);
                }
            }

            @Override // j$.util.stream.C2.c, j$.util.stream.C2
            public void m(long j) {
                this.a.m(D2.c(j, c.this.l, this.c));
            }

            @Override // j$.util.stream.C2.c, j$.util.stream.C2
            public boolean o() {
                return this.c == 0 || this.a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC0148l1 abstractC0148l1, W2 w2, int i, long j, long j2) {
            super(abstractC0148l1, w2, i);
            this.l = j;
            this.m = j2;
        }

        @Override // j$.util.stream.AbstractC0148l1
        T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
            long jO0 = v1.o0(spliterator);
            return (jO0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !V2.ORDERED.n(v1.q0()) ? U1.h(this, L0((Spliterator.c) v1.u0(spliterator), this.l, this.m, jO0), true) : new e(this, v1, spliterator, zVar, this.l, this.m).invoke() : U1.h(v1, D2.b(v1.p0(), spliterator, this.l, this.m), true);
        }

        @Override // j$.util.stream.AbstractC0148l1
        Spliterator D0(V1 v1, Spliterator spliterator) {
            long jO0 = v1.o0(spliterator);
            if (jO0 > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.c cVar = (Spliterator.c) v1.u0(spliterator);
                long j = this.l;
                return new e3.c(cVar, j, D2.d(j, this.m));
            }
            return !V2.ORDERED.n(v1.q0()) ? L0((Spliterator.c) v1.u0(spliterator), this.l, this.m, jO0) : new e(this, v1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.w0
                @Override // j$.util.function.z
                public final Object apply(int i) {
                    return new Long[i];
                }
            }, this.l, this.m).invoke().spliterator();
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }

        Spliterator.c L0(Spliterator.c cVar, long j, long j2, long j3) {
            long j4;
            long jMin;
            if (j <= j3) {
                long j5 = j3 - j;
                jMin = j2 >= 0 ? Math.min(j2, j5) : j5;
                j4 = 0;
            } else {
                j4 = j;
                jMin = j2;
            }
            return new f3.c(cVar, j4, jMin);
        }
    }

    class d extends AbstractC0171r1.h<Double> {
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        class a extends C2.a<Double> {
            long b;
            long c;

            a(C2 c2) {
                super(c2);
                this.b = d.this.l;
                long j = d.this.m;
                this.c = j < 0 ? Long.MAX_VALUE : j;
            }

            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public void accept(double d) {
                long j = this.b;
                if (j != 0) {
                    this.b = j - 1;
                    return;
                }
                long j2 = this.c;
                if (j2 > 0) {
                    this.c = j2 - 1;
                    this.a.accept(d);
                }
            }

            @Override // j$.util.stream.C2.a, j$.util.stream.C2
            public void m(long j) {
                this.a.m(D2.c(j, d.this.l, this.c));
            }

            @Override // j$.util.stream.C2.a, j$.util.stream.C2
            public boolean o() {
                return this.c == 0 || this.a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC0148l1 abstractC0148l1, W2 w2, int i, long j, long j2) {
            super(abstractC0148l1, w2, i);
            this.l = j;
            this.m = j2;
        }

        @Override // j$.util.stream.AbstractC0148l1
        T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
            long jO0 = v1.o0(spliterator);
            return (jO0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !V2.ORDERED.n(v1.q0()) ? U1.f(this, L0((Spliterator.a) v1.u0(spliterator), this.l, this.m, jO0), true) : new e(this, v1, spliterator, zVar, this.l, this.m).invoke() : U1.f(v1, D2.b(v1.p0(), spliterator, this.l, this.m), true);
        }

        @Override // j$.util.stream.AbstractC0148l1
        Spliterator D0(V1 v1, Spliterator spliterator) {
            long jO0 = v1.o0(spliterator);
            if (jO0 > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.a aVar = (Spliterator.a) v1.u0(spliterator);
                long j = this.l;
                return new e3.a(aVar, j, D2.d(j, this.m));
            }
            return !V2.ORDERED.n(v1.q0()) ? L0((Spliterator.a) v1.u0(spliterator), this.l, this.m, jO0) : new e(this, v1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.x0
                @Override // j$.util.function.z
                public final Object apply(int i) {
                    return new Double[i];
                }
            }, this.l, this.m).invoke().spliterator();
        }

        @Override // j$.util.stream.AbstractC0148l1
        C2 F0(int i, C2 c2) {
            return new a(c2);
        }

        Spliterator.a L0(Spliterator.a aVar, long j, long j2, long j3) {
            long j4;
            long jMin;
            if (j <= j3) {
                long j5 = j3 - j;
                jMin = j2 >= 0 ? Math.min(j2, j5) : j5;
                j4 = 0;
            } else {
                j4 = j;
                jMin = j2;
            }
            return new f3.a(aVar, j4, jMin);
        }
    }

    private static final class e<P_IN, P_OUT> extends AbstractC0152m1<P_IN, P_OUT, T1<P_OUT>, e<P_IN, P_OUT>> {
        private final AbstractC0148l1 j;
        private final j$.util.function.z k;
        private final long l;
        private final long m;
        private long n;
        private volatile boolean o;

        e(e eVar, Spliterator spliterator) {
            super(eVar, spliterator);
            this.j = eVar.j;
            this.k = eVar.k;
            this.l = eVar.l;
            this.m = eVar.m;
        }

        e(AbstractC0148l1 abstractC0148l1, V1 v1, Spliterator spliterator, j$.util.function.z zVar, long j, long j2) {
            super(v1, spliterator);
            this.j = abstractC0148l1;
            this.k = zVar;
            this.l = j;
            this.m = j2;
        }

        private long m(long j) {
            if (this.o) {
                return this.n;
            }
            e eVar = (e) this.e;
            e eVar2 = (e) this.f;
            if (eVar == null || eVar2 == null) {
                return this.n;
            }
            long jM = eVar.m(j);
            return jM >= j ? jM : jM + eVar2.m(j);
        }

        @Override // j$.util.stream.AbstractC0160o1
        protected Object a() {
            if (e()) {
                T1.a aVarR0 = this.j.r0(V2.SIZED.t(this.j.c) ? this.j.o0(this.c) : -1L, this.k);
                C2 c2F0 = this.j.F0(this.b.q0(), aVarR0);
                V1 v1 = this.b;
                v1.m0(v1.t0(c2F0), this.c);
                return aVarR0.a();
            }
            V1 v12 = this.b;
            T1.a aVarR02 = v12.r0(-1L, this.k);
            v12.s0(aVarR02, this.c);
            T1 t1A = aVarR02.a();
            this.n = t1A.count();
            this.o = true;
            this.c = null;
            return t1A;
        }

        @Override // j$.util.stream.AbstractC0160o1
        protected AbstractC0160o1 f(Spliterator spliterator) {
            return new e(this, spliterator);
        }

        @Override // j$.util.stream.AbstractC0152m1
        protected void i() {
            this.i = true;
            if (this.o) {
                g(k());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractC0152m1
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final T1 k() {
            return U1.k(this.j.z0());
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
        @Override // j$.util.stream.AbstractC0160o1, java.util.concurrent.CountedCompleter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onCompletion(java.util.concurrent.CountedCompleter r12) {
            /*
                Method dump skipped, instructions count: 228
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.D2.e.onCompletion(java.util.concurrent.CountedCompleter):void");
        }
    }

    static Spliterator b(W2 w2, Spliterator spliterator, long j, long j2) {
        long jD = d(j, j2);
        int iOrdinal = w2.ordinal();
        if (iOrdinal == 0) {
            return new e3.e(spliterator, j, jD);
        }
        if (iOrdinal == 1) {
            return new e3.b((Spliterator.b) spliterator, j, jD);
        }
        if (iOrdinal == 2) {
            return new e3.c((Spliterator.c) spliterator, j, jD);
        }
        if (iOrdinal == 3) {
            return new e3.a((Spliterator.a) spliterator, j, jD);
        }
        throw new IllegalStateException("Unknown shape " + w2);
    }

    static long c(long j, long j2, long j3) {
        if (j >= 0) {
            return Math.max(-1L, Math.min(j - j2, j3));
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long d(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    private static int e(long j) {
        return (j != -1 ? V2.p : 0) | V2.o;
    }

    public static InterfaceC0183u1 f(AbstractC0148l1 abstractC0148l1, long j, long j2) {
        if (j >= 0) {
            return new d(abstractC0148l1, W2.DOUBLE_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static E1 g(AbstractC0148l1 abstractC0148l1, long j, long j2) {
        if (j >= 0) {
            return new b(abstractC0148l1, W2.INT_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static J1 h(AbstractC0148l1 abstractC0148l1, long j, long j2) {
        if (j >= 0) {
            return new c(abstractC0148l1, W2.LONG_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static Stream i(AbstractC0148l1 abstractC0148l1, long j, long j2) {
        if (j >= 0) {
            return new a(abstractC0148l1, W2.REFERENCE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }
}
