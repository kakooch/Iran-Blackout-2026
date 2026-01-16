package ir.nasim;

import androidx.compose.foundation.gestures.FlingCancellationException;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.xe6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C23864xe6 {
    private InterfaceC11049ce6 a;
    private InterfaceC14124hO4 b;
    private InterfaceC7645Sp2 c;
    private EnumC24286yM4 d;
    private boolean e;
    private C25166zq4 f;
    private final SA2 g;
    private boolean h;
    private int i = AbstractC4559Fq4.a.c();
    private InterfaceC8748Xd6 j = androidx.compose.foundation.gestures.d.b;
    private final c k = new c();
    private final UA2 l = new e();

    /* renamed from: ir.nasim.xe6$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C23864xe6.this.p(0L, this);
        }
    }

    /* renamed from: ir.nasim.xe6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        long d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ C12280eL5 h;
        final /* synthetic */ long i;

        /* renamed from: ir.nasim.xe6$b$a */
        public static final class a implements InterfaceC8748Xd6 {
            final /* synthetic */ C23864xe6 a;
            final /* synthetic */ InterfaceC4325Eq4 b;

            a(C23864xe6 c23864xe6, InterfaceC4325Eq4 interfaceC4325Eq4) {
                this.a = c23864xe6;
                this.b = interfaceC4325Eq4;
            }

            @Override // ir.nasim.InterfaceC8748Xd6
            public float e(float f) {
                if (C9225Za1.b && Math.abs(f) != 0.0f && this.a.A(f)) {
                    throw new FlingCancellationException();
                }
                C23864xe6 c23864xe6 = this.a;
                return c23864xe6.x(c23864xe6.F(this.b.a(c23864xe6.y(c23864xe6.G(f)), AbstractC4559Fq4.a.b())));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12280eL5 c12280eL5, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = c12280eL5;
            this.i = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C23864xe6.this.new b(this.h, this.i, interfaceC20295rm1);
            bVar.f = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C23864xe6 c23864xe6;
            C12280eL5 c12280eL5;
            C23864xe6 c23864xe62;
            long j;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = new a(C23864xe6.this, (InterfaceC4325Eq4) this.f);
                c23864xe6 = C23864xe6.this;
                C12280eL5 c12280eL52 = this.h;
                long j2 = this.i;
                InterfaceC7645Sp2 interfaceC7645Sp2 = c23864xe6.c;
                long j3 = c12280eL52.a;
                float fX = c23864xe6.x(c23864xe6.E(j2));
                this.f = c23864xe6;
                this.b = c23864xe6;
                this.c = c12280eL52;
                this.d = j3;
                this.e = 1;
                Object objA = interfaceC7645Sp2.a(aVar, fX, this);
                if (objA == objE) {
                    return objE;
                }
                c12280eL5 = c12280eL52;
                obj = objA;
                c23864xe62 = c23864xe6;
                j = j3;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                c12280eL5 = (C12280eL5) this.c;
                c23864xe6 = (C23864xe6) this.b;
                c23864xe62 = (C23864xe6) this.f;
                AbstractC10685c16.b(obj);
            }
            c12280eL5.a = c23864xe6.J(j, c23864xe62.x(((Number) obj).floatValue()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4325Eq4 interfaceC4325Eq4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC4325Eq4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xe6$c */
    public static final class c implements InterfaceC4325Eq4 {
        c() {
        }

        @Override // ir.nasim.InterfaceC4325Eq4
        public long a(long j, int i) {
            C23864xe6.this.i = i;
            InterfaceC14124hO4 interfaceC14124hO4 = C23864xe6.this.b;
            if (interfaceC14124hO4 != null && C23864xe6.this.r()) {
                return interfaceC14124hO4.b(j, C23864xe6.this.i, C23864xe6.this.l);
            }
            return C23864xe6.this.w(C23864xe6.this.j, j, i);
        }

        @Override // ir.nasim.InterfaceC4325Eq4
        public long b(long j, int i) {
            return C23864xe6.this.w(C23864xe6.this.j, j, i);
        }
    }

    /* renamed from: ir.nasim.xe6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        long b;
        int c;
        /* synthetic */ long d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C23864xe6.this.new d(interfaceC20295rm1);
            dVar.d = ((C17718nR7) obj).o();
            return dVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((C17718nR7) obj).o(), (InterfaceC20295rm1) obj2);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0087 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r6 = ir.nasim.AbstractC13660gc3.e()
                int r0 = r13.c
                r1 = 3
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L35
                if (r0 == r3) goto L2e
                if (r0 == r2) goto L24
                if (r0 != r1) goto L1c
                long r0 = r13.b
                long r2 = r13.d
                ir.nasim.AbstractC10685c16.b(r14)
                r9 = r0
                r0 = r14
                goto L89
            L1c:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L24:
                long r2 = r13.b
                long r4 = r13.d
                ir.nasim.AbstractC10685c16.b(r14)
                r0 = r14
                r7 = r4
                goto L68
            L2e:
                long r3 = r13.d
                ir.nasim.AbstractC10685c16.b(r14)
                r0 = r14
                goto L4c
            L35:
                ir.nasim.AbstractC10685c16.b(r14)
                long r4 = r13.d
                ir.nasim.xe6 r0 = ir.nasim.C23864xe6.this
                ir.nasim.zq4 r0 = ir.nasim.C23864xe6.c(r0)
                r13.d = r4
                r13.c = r3
                java.lang.Object r0 = r0.c(r4, r13)
                if (r0 != r6) goto L4b
                return r6
            L4b:
                r3 = r4
            L4c:
                ir.nasim.nR7 r0 = (ir.nasim.C17718nR7) r0
                long r7 = r0.o()
                long r7 = ir.nasim.C17718nR7.k(r3, r7)
                ir.nasim.xe6 r0 = ir.nasim.C23864xe6.this
                r13.d = r3
                r13.b = r7
                r13.c = r2
                java.lang.Object r0 = r0.p(r7, r13)
                if (r0 != r6) goto L65
                return r6
            L65:
                r11 = r3
                r2 = r7
                r7 = r11
            L68:
                ir.nasim.nR7 r0 = (ir.nasim.C17718nR7) r0
                long r9 = r0.o()
                ir.nasim.xe6 r0 = ir.nasim.C23864xe6.this
                ir.nasim.zq4 r0 = ir.nasim.C23864xe6.c(r0)
                long r2 = ir.nasim.C17718nR7.k(r2, r9)
                r13.d = r7
                r13.b = r9
                r13.c = r1
                r1 = r2
                r3 = r9
                r5 = r13
                java.lang.Object r0 = r0.a(r1, r3, r5)
                if (r0 != r6) goto L88
                return r6
            L88:
                r2 = r7
            L89:
                ir.nasim.nR7 r0 = (ir.nasim.C17718nR7) r0
                long r0 = r0.o()
                long r0 = ir.nasim.C17718nR7.k(r9, r0)
                long r0 = ir.nasim.C17718nR7.k(r2, r0)
                ir.nasim.nR7 r0 = ir.nasim.C17718nR7.b(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23864xe6.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object n(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(C17718nR7.b(j), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xe6$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        e() {
            super(1);
        }

        public final long a(long j) {
            InterfaceC8748Xd6 interfaceC8748Xd6 = C23864xe6.this.j;
            C23864xe6 c23864xe6 = C23864xe6.this;
            return c23864xe6.w(interfaceC8748Xd6, j, c23864xe6.i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return ZG4.d(a(((ZG4) obj).t()));
        }
    }

    /* renamed from: ir.nasim.xe6$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C23864xe6.this.new f(this.e, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C23864xe6.this.j = (InterfaceC8748Xd6) this.c;
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                c cVar = C23864xe6.this.k;
                this.b = 1;
                if (interfaceC14603iB2.invoke(cVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C23864xe6(InterfaceC11049ce6 interfaceC11049ce6, InterfaceC14124hO4 interfaceC14124hO4, InterfaceC7645Sp2 interfaceC7645Sp2, EnumC24286yM4 enumC24286yM4, boolean z, C25166zq4 c25166zq4, SA2 sa2) {
        this.a = interfaceC11049ce6;
        this.b = interfaceC14124hO4;
        this.c = interfaceC7645Sp2;
        this.d = enumC24286yM4;
        this.e = z;
        this.f = c25166zq4;
        this.g = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(float f2) {
        return (f2 > 0.0f && !this.a.e()) || (f2 < 0.0f && !this.a.d()) || !((Boolean) this.g.invoke()).booleanValue();
    }

    private final long D(long j) {
        return this.d == EnumC24286yM4.b ? C17718nR7.e(j, 0.0f, 0.0f, 1, null) : C17718nR7.e(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float E(long j) {
        return this.d == EnumC24286yM4.b ? C17718nR7.h(j) : C17718nR7.i(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long J(long j, float f2) {
        return this.d == EnumC24286yM4.b ? C17718nR7.e(j, f2, 0.0f, 2, null) : C17718nR7.e(j, 0.0f, f2, 1, null);
    }

    private final long o(long j) {
        return G(x(this.a.f(x(F(j)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r() {
        return this.a.e() || this.a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long w(InterfaceC8748Xd6 interfaceC8748Xd6, long j, int i) {
        long jD = this.f.d(j, i);
        long jP = ZG4.p(j, jD);
        long jY = y(G(interfaceC8748Xd6.e(F(y(C(jP))))));
        return ZG4.q(ZG4.q(jD, jY), this.f.b(jY, ZG4.p(jP, jY), i));
    }

    public final boolean B() {
        if (!this.a.c()) {
            InterfaceC14124hO4 interfaceC14124hO4 = this.b;
            if (!(interfaceC14124hO4 != null ? interfaceC14124hO4.a() : false)) {
                return false;
            }
        }
        return true;
    }

    public final long C(long j) {
        return this.d == EnumC24286yM4.b ? ZG4.g(j, 0.0f, 0.0f, 1, null) : ZG4.g(j, 0.0f, 0.0f, 2, null);
    }

    public final float F(long j) {
        return Float.intBitsToFloat((int) (this.d == EnumC24286yM4.b ? j >> 32 : j & 4294967295L));
    }

    public final long G(float f2) {
        if (f2 == 0.0f) {
            return ZG4.b.c();
        }
        if (this.d == EnumC24286yM4.b) {
            return ZG4.e((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        }
        return ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    public final long H(float f2) {
        return f2 == 0.0f ? C17718nR7.b.a() : this.d == EnumC24286yM4.b ? AbstractC18309oR7.a(f2, 0.0f) : AbstractC18309oR7.a(0.0f, f2);
    }

    public final boolean I(InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, InterfaceC14124hO4 interfaceC14124hO4, boolean z, InterfaceC7645Sp2 interfaceC7645Sp2, C25166zq4 c25166zq4) {
        boolean z2;
        boolean z3 = true;
        if (AbstractC13042fc3.d(this.a, interfaceC11049ce6)) {
            z2 = false;
        } else {
            this.a = interfaceC11049ce6;
            z2 = true;
        }
        this.b = interfaceC14124hO4;
        if (this.d != enumC24286yM4) {
            this.d = enumC24286yM4;
            z2 = true;
        }
        if (this.e != z) {
            this.e = z;
        } else {
            z3 = z2;
        }
        this.c = interfaceC7645Sp2;
        this.f = c25166zq4;
        return z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(long r12, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof ir.nasim.C23864xe6.a
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.xe6$a r0 = (ir.nasim.C23864xe6.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.xe6$a r0 = new ir.nasim.xe6$a
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r12 = r0.b
            ir.nasim.eL5 r12 = (ir.nasim.C12280eL5) r12
            java.lang.Object r13 = r0.a
            ir.nasim.xe6 r13 = (ir.nasim.C23864xe6) r13
            ir.nasim.AbstractC10685c16.b(r14)
            goto L60
        L31:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L39:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.eL5 r14 = new ir.nasim.eL5
            r14.<init>()
            r14.a = r12
            r11.h = r3
            ir.nasim.jn4 r2 = ir.nasim.EnumC15562jn4.a
            ir.nasim.xe6$b r10 = new ir.nasim.xe6$b
            r9 = 0
            r4 = r10
            r5 = r11
            r6 = r14
            r7 = r12
            r4.<init>(r6, r7, r9)
            r0.a = r11
            r0.b = r14
            r0.e = r3
            java.lang.Object r12 = r11.z(r2, r10, r0)
            if (r12 != r1) goto L5e
            return r1
        L5e:
            r13 = r11
            r12 = r14
        L60:
            r14 = 0
            r13.h = r14
            long r12 = r12.a
            ir.nasim.nR7 r12 = ir.nasim.C17718nR7.b(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23864xe6.p(long, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC11049ce6 q() {
        return this.a;
    }

    public final boolean s() {
        return this.h;
    }

    public final boolean t() {
        return this.d == EnumC24286yM4.a;
    }

    public final Object u(long j, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        if (z && !androidx.compose.foundation.gestures.d.g(this.c)) {
            return C19938rB7.a;
        }
        long jD = D(j);
        d dVar = new d(null);
        InterfaceC14124hO4 interfaceC14124hO4 = this.b;
        if (interfaceC14124hO4 == null || !r()) {
            Object objInvoke = dVar.invoke(C17718nR7.b(jD), interfaceC20295rm1);
            return objInvoke == AbstractC14862ic3.e() ? objInvoke : C19938rB7.a;
        }
        Object objC = interfaceC14124hO4.c(jD, dVar, interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    public final long v(long j) {
        return this.a.c() ? ZG4.b.c() : o(j);
    }

    public final float x(float f2) {
        return this.e ? f2 * (-1) : f2;
    }

    public final long y(long j) {
        return this.e ? ZG4.r(j, -1.0f) : j;
    }

    public final Object z(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.a.b(enumC15562jn4, new f(interfaceC14603iB2, null), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }
}
