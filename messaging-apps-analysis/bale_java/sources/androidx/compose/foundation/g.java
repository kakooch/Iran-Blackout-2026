package androidx.compose.foundation;

import android.view.KeyEvent;
import ir.nasim.AbstractC10434bc1;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14680iJ3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16558lU2;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20271rj7;
import ir.nasim.AbstractC23371wo3;
import ir.nasim.AbstractC7397Rn6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9939ao6;
import ir.nasim.B26;
import ir.nasim.C19938rB7;
import ir.nasim.C22166um4;
import ir.nasim.ED1;
import ir.nasim.HG1;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC15967kU2;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18354oW7;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC6194Mo5;
import ir.nasim.InterfaceC9049Yg5;
import ir.nasim.InterfaceC9814ac1;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.ZG4;

/* loaded from: classes.dex */
final class g extends androidx.compose.foundation.a implements InterfaceC9814ac1 {
    private String A0;
    private SA2 B0;
    private SA2 C0;
    private boolean D0;
    private final C22166um4 E0;
    private final C22166um4 F0;

    public static final class a {
        private final InterfaceC13730gj3 a;
        private boolean b;

        public a(InterfaceC13730gj3 interfaceC13730gj3) {
            this.a = interfaceC13730gj3;
        }

        public final boolean a() {
            return this.b;
        }

        public final InterfaceC13730gj3 b() {
            return this.a;
        }

        public final void c(boolean z) {
            this.b = z;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            SA2 sa2 = g.this.B0;
            if (sa2 != null) {
                sa2.invoke();
            }
            return Boolean.TRUE;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final void a(long j) {
            SA2 sa2 = g.this.C0;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((ZG4) obj).t());
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        public final void a(long j) {
            SA2 sa2 = g.this.B0;
            if (sa2 != null) {
                sa2.invoke();
            }
            if (g.this.c3()) {
                ((InterfaceC15967kU2) AbstractC10434bc1.a(g.this, AbstractC13040fc1.l())).a(AbstractC16558lU2.a.e());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((ZG4) obj).t());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ long d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6194Mo5 interfaceC6194Mo5 = (InterfaceC6194Mo5) this.c;
                long j = this.d;
                if (g.this.O2()) {
                    g gVar = g.this;
                    this.b = 1;
                    if (gVar.Q2(interfaceC6194Mo5, j, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        public final Object n(InterfaceC6194Mo5 interfaceC6194Mo5, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = g.this.new e(interfaceC20295rm1);
            eVar.c = interfaceC6194Mo5;
            eVar.d = j;
            return eVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC6194Mo5) obj, ((ZG4) obj2).t(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        f() {
            super(1);
        }

        public final void a(long j) {
            if (g.this.O2()) {
                g.this.P2().invoke();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((ZG4) obj).t());
            return C19938rB7.a;
        }
    }

    /* renamed from: androidx.compose.foundation.g$g, reason: collision with other inner class name */
    static final class C0033g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C0033g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return g.this.new C0033g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long jC = ((InterfaceC18354oW7) AbstractC10434bc1.a(g.this, AbstractC13040fc1.u())).c();
                this.b = 1;
                if (HG1.b(jC, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            SA2 sa2 = g.this.B0;
            if (sa2 != null) {
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C0033g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        long b;
        long c;
        int d;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return g.this.new h(this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            long jB;
            long jA;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18354oW7 interfaceC18354oW7 = (InterfaceC18354oW7) AbstractC10434bc1.a(g.this, AbstractC13040fc1.u());
                jB = interfaceC18354oW7.b();
                jA = interfaceC18354oW7.a();
                this.b = jB;
                this.c = jA;
                this.d = 1;
                if (HG1.b(jB, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    g.this.P2().invoke();
                    return C19938rB7.a;
                }
                jA = this.c;
                jB = this.b;
                AbstractC10685c16.b(obj);
            }
            a aVar = (a) g.this.F0.b(this.f);
            if (aVar != null) {
                aVar.c(true);
            }
            this.d = 2;
            if (HG1.b(jA - jB, this) == objE) {
                return objE;
            }
            g.this.P2().invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ g(SA2 sa2, String str, SA2 sa22, SA2 sa23, boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, String str2, B26 b26, ED1 ed1) {
        this(sa2, str, sa22, sa23, z, interfaceC18507om4, interfaceC17521n63, z2, str2, b26);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void d3() {
        /*
            r24 = this;
            r0 = r24
            ir.nasim.um4 r1 = r0.E0
            java.lang.Object[] r2 = r1.c
            long[] r3 = r1.a
            int r4 = r3.length
            int r4 = r4 + (-2)
            r9 = 7
            r10 = 0
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r13 = 1
            r14 = 8
            if (r4 < 0) goto L58
            r15 = 0
        L18:
            r5 = r3[r15]
            long r7 = ~r5
            long r7 = r7 << r9
            long r7 = r7 & r5
            long r7 = r7 & r11
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 == 0) goto L4e
            int r7 = r15 - r4
            int r7 = ~r7
            int r7 = r7 >>> 31
            int r7 = 8 - r7
            r8 = 0
        L2a:
            if (r8 >= r7) goto L4c
            r18 = 255(0xff, double:1.26E-321)
            long r20 = r5 & r18
            r16 = 128(0x80, double:6.3E-322)
            int r20 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r20 >= 0) goto L43
            int r20 = r15 << 3
            int r20 = r20 + r8
            r20 = r2[r20]
            r11 = r20
            ir.nasim.gj3 r11 = (ir.nasim.InterfaceC13730gj3) r11
            ir.nasim.InterfaceC13730gj3.a.a(r11, r10, r13, r10)
        L43:
            long r5 = r5 >> r14
            int r8 = r8 + 1
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            goto L2a
        L4c:
            if (r7 != r14) goto L58
        L4e:
            if (r15 == r4) goto L58
            int r15 = r15 + 1
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            goto L18
        L58:
            r1.g()
            ir.nasim.um4 r1 = r0.F0
            java.lang.Object[] r2 = r1.c
            long[] r3 = r1.a
            int r4 = r3.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto Lad
            r5 = 0
        L67:
            r6 = r3[r5]
            long r11 = ~r6
            long r11 = r11 << r9
            long r11 = r11 & r6
            r20 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r20
            int r8 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r8 == 0) goto La4
            int r8 = r5 - r4
            int r8 = ~r8
            int r8 = r8 >>> 31
            int r8 = 8 - r8
            r11 = 0
        L7f:
            if (r11 >= r8) goto L9d
            r18 = 255(0xff, double:1.26E-321)
            long r22 = r6 & r18
            r16 = 128(0x80, double:6.3E-322)
            int r12 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r12 >= 0) goto L99
            int r12 = r5 << 3
            int r12 = r12 + r11
            r12 = r2[r12]
            androidx.compose.foundation.g$a r12 = (androidx.compose.foundation.g.a) r12
            ir.nasim.gj3 r12 = r12.b()
            ir.nasim.InterfaceC13730gj3.a.a(r12, r10, r13, r10)
        L99:
            long r6 = r6 >> r14
            int r11 = r11 + 1
            goto L7f
        L9d:
            r16 = 128(0x80, double:6.3E-322)
            r18 = 255(0xff, double:1.26E-321)
            if (r8 != r14) goto Lad
            goto La8
        La4:
            r16 = 128(0x80, double:6.3E-322)
            r18 = 255(0xff, double:1.26E-321)
        La8:
            if (r5 == r4) goto Lad
            int r5 = r5 + 1
            goto L67
        Lad:
            r1.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.g.d3():void");
    }

    @Override // androidx.compose.foundation.a
    public void I2(InterfaceC11943do6 interfaceC11943do6) {
        if (this.B0 != null) {
            AbstractC9939ao6.E(interfaceC11943do6, this.A0, new b());
        }
    }

    @Override // androidx.compose.foundation.a
    public Object J2(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objJ = AbstractC20271rj7.j(interfaceC9049Yg5, (!O2() || this.C0 == null) ? null : new c(), (!O2() || this.B0 == null) ? null : new d(), new e(null), new f(), interfaceC20295rm1);
        return objJ == AbstractC14862ic3.e() ? objJ : C19938rB7.a;
    }

    @Override // androidx.compose.foundation.a
    protected void S2() {
        d3();
    }

    @Override // androidx.compose.foundation.a
    protected boolean T2(KeyEvent keyEvent) {
        boolean z;
        long jA = AbstractC23371wo3.a(keyEvent);
        if (this.B0 == null || this.E0.b(jA) != null) {
            z = false;
        } else {
            this.E0.q(jA, AbstractC10533bm0.d(U1(), null, null, new C0033g(null), 3, null));
            z = true;
        }
        a aVar = (a) this.F0.b(jA);
        if (aVar != null) {
            if (aVar.b().b()) {
                InterfaceC13730gj3.a.a(aVar.b(), null, 1, null);
                if (!aVar.a()) {
                    P2().invoke();
                    this.F0.n(jA);
                }
            } else {
                this.F0.n(jA);
            }
        }
        return z;
    }

    @Override // androidx.compose.foundation.a
    protected boolean U2(KeyEvent keyEvent) {
        SA2 sa2;
        long jA = AbstractC23371wo3.a(keyEvent);
        boolean z = false;
        if (this.E0.b(jA) != null) {
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.E0.b(jA);
            if (interfaceC13730gj3 != null) {
                if (interfaceC13730gj3.b()) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                } else {
                    z = true;
                }
            }
            this.E0.n(jA);
        }
        if (this.C0 != null) {
            if (this.F0.b(jA) != null) {
                if (!z && (sa2 = this.C0) != null) {
                    sa2.invoke();
                }
                this.F0.n(jA);
            } else if (!z) {
                this.F0.q(jA, new a(AbstractC10533bm0.d(U1(), null, null, new h(jA, null), 3, null)));
            }
        } else if (!z) {
            P2().invoke();
        }
        return true;
    }

    public final boolean c3() {
        return this.D0;
    }

    public final void e3(boolean z) {
        this.D0 = z;
    }

    public final void f3(SA2 sa2, String str, SA2 sa22, SA2 sa23, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z, String str2, B26 b26) {
        boolean z2;
        if (!AbstractC13042fc3.d(this.A0, str)) {
            this.A0 = str;
            AbstractC7397Rn6.b(this);
        }
        if ((this.B0 == null) != (sa22 == null)) {
            L2();
            AbstractC7397Rn6.b(this);
            z2 = true;
        } else {
            z2 = false;
        }
        this.B0 = sa22;
        if ((this.C0 == null) != (sa23 == null)) {
            z2 = true;
        }
        this.C0 = sa23;
        boolean z3 = O2() != z ? true : z2;
        Y2(interfaceC18507om4, interfaceC17521n63, z, str2, b26, sa2);
        if (z3) {
            W2();
        }
    }

    @Override // androidx.compose.ui.e.c
    public void g2() {
        super.g2();
        d3();
    }

    private g(SA2 sa2, String str, SA2 sa22, SA2 sa23, boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, String str2, B26 b26) {
        super(interfaceC18507om4, interfaceC17521n63, z2, str2, b26, sa2, null);
        this.A0 = str;
        this.B0 = sa22;
        this.C0 = sa23;
        this.D0 = z;
        this.E0 = AbstractC14680iJ3.a();
        this.F0 = AbstractC14680iJ3.a();
    }
}
