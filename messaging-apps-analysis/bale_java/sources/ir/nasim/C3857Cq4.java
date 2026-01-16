package ir.nasim;

import androidx.compose.ui.e;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Cq4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3857Cq4 extends e.c implements InterfaceC8645Wv7, InterfaceC24572yq4 {
    private InterfaceC24572yq4 o;
    private C25166zq4 p;
    private C3857Cq4 q;
    private final Object r;

    /* renamed from: ir.nasim.Cq4$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        long b;
        long c;
        /* synthetic */ Object d;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C3857Cq4.this.i0(0L, 0L, this);
        }
    }

    /* renamed from: ir.nasim.Cq4$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C3857Cq4.this.w0(0L, this);
        }
    }

    /* renamed from: ir.nasim.Cq4$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC20315ro1 invoke() {
            return C3857Cq4.this.w2();
        }
    }

    public C3857Cq4(InterfaceC24572yq4 interfaceC24572yq4, C25166zq4 c25166zq4) {
        this.o = interfaceC24572yq4;
        this.p = c25166zq4 == null ? new C25166zq4() : c25166zq4;
        this.r = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    private final void A2(C25166zq4 c25166zq4) {
        z2();
        if (c25166zq4 == null) {
            this.p = new C25166zq4();
        } else if (!AbstractC13042fc3.d(c25166zq4, this.p)) {
            this.p = c25166zq4;
        }
        if (b2()) {
            B2();
        }
    }

    private final void B2() {
        this.p.k(this);
        if (C15439jb1.c) {
            this.p.j(null);
            this.q = null;
        }
        this.p.i(new c());
        this.p.l(U1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC20315ro1 w2() {
        InterfaceC20315ro1 interfaceC20315ro1H;
        C3857Cq4 c3857Cq4Y2 = y2();
        if ((c3857Cq4Y2 == null || (interfaceC20315ro1H = c3857Cq4Y2.w2()) == null) && (interfaceC20315ro1H = this.p.h()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return interfaceC20315ro1H;
    }

    private final InterfaceC24572yq4 x2() {
        if (b2()) {
            return y2();
        }
        return null;
    }

    private final void z2() {
        if (this.p.f() == this) {
            this.p.k(null);
        }
    }

    public final void C2(InterfaceC24572yq4 interfaceC24572yq4, C25166zq4 c25166zq4) {
        this.o = interfaceC24572yq4;
        A2(c25166zq4);
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public long H0(long j, long j2, int i) {
        long jH0 = this.o.H0(j, j2, i);
        InterfaceC24572yq4 interfaceC24572yq4X2 = x2();
        return ZG4.q(jH0, interfaceC24572yq4X2 != null ? interfaceC24572yq4X2.H0(ZG4.q(j, jH0), ZG4.p(j2, jH0), i) : ZG4.b.c());
    }

    @Override // ir.nasim.InterfaceC8645Wv7
    public Object P() {
        return this.r;
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        B2();
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        if (C15439jb1.c) {
            C3857Cq4 c3857Cq4 = (C3857Cq4) AbstractC4091Dq4.b(this);
            this.q = c3857Cq4;
            this.p.j(c3857Cq4);
        }
        z2();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // ir.nasim.InterfaceC24572yq4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i0(long r16, long r18, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r20
            boolean r2 = r1 instanceof ir.nasim.C3857Cq4.a
            if (r2 == 0) goto L16
            r2 = r1
            ir.nasim.Cq4$a r2 = (ir.nasim.C3857Cq4.a) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.f = r3
            goto L1b
        L16:
            ir.nasim.Cq4$a r2 = new ir.nasim.Cq4$a
            r2.<init>(r1)
        L1b:
            java.lang.Object r1 = r2.d
            java.lang.Object r9 = ir.nasim.AbstractC13660gc3.e()
            int r3 = r2.f
            r10 = 2
            r4 = 1
            if (r3 == 0) goto L48
            if (r3 == r4) goto L3a
            if (r3 != r10) goto L32
            long r2 = r2.b
            ir.nasim.AbstractC10685c16.b(r1)
            goto La1
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            long r3 = r2.c
            long r5 = r2.b
            java.lang.Object r7 = r2.a
            ir.nasim.Cq4 r7 = (ir.nasim.C3857Cq4) r7
            ir.nasim.AbstractC10685c16.b(r1)
            r13 = r3
            r11 = r5
            goto L66
        L48:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.yq4 r3 = r0.o
            r2.a = r0
            r11 = r16
            r2.b = r11
            r13 = r18
            r2.c = r13
            r2.f = r4
            r4 = r16
            r6 = r18
            r8 = r2
            java.lang.Object r1 = r3.i0(r4, r6, r8)
            if (r1 != r9) goto L65
            return r9
        L65:
            r7 = r0
        L66:
            ir.nasim.nR7 r1 = (ir.nasim.C17718nR7) r1
            long r4 = r1.o()
            boolean r1 = ir.nasim.C15439jb1.c
            if (r1 == 0) goto L7f
            boolean r1 = r7.b2()
            if (r1 == 0) goto L7c
            ir.nasim.yq4 r1 = r7.x2()
        L7a:
            r3 = r1
            goto L84
        L7c:
            ir.nasim.Cq4 r1 = r7.q
            goto L7a
        L7f:
            ir.nasim.yq4 r1 = r7.x2()
            goto L7a
        L84:
            if (r3 == 0) goto La9
            long r6 = ir.nasim.C17718nR7.l(r11, r4)
            long r11 = ir.nasim.C17718nR7.k(r13, r4)
            r1 = 0
            r2.a = r1
            r2.b = r4
            r2.f = r10
            r13 = r4
            r4 = r6
            r6 = r11
            r8 = r2
            java.lang.Object r1 = r3.i0(r4, r6, r8)
            if (r1 != r9) goto La0
            return r9
        La0:
            r2 = r13
        La1:
            ir.nasim.nR7 r1 = (ir.nasim.C17718nR7) r1
            long r4 = r1.o()
            r13 = r2
            goto Lb0
        La9:
            r13 = r4
            ir.nasim.nR7$a r1 = ir.nasim.C17718nR7.b
            long r4 = r1.a()
        Lb0:
            long r1 = ir.nasim.C17718nR7.l(r13, r4)
            ir.nasim.nR7 r1 = ir.nasim.C17718nR7.b(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3857Cq4.i0(long, long, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public long s1(long j, int i) {
        InterfaceC24572yq4 interfaceC24572yq4X2 = x2();
        long jS1 = interfaceC24572yq4X2 != null ? interfaceC24572yq4X2.s1(j, i) : ZG4.b.c();
        return ZG4.q(jS1, this.o.s1(ZG4.p(j, jS1), i));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC24572yq4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object w0(long r9, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ir.nasim.C3857Cq4.b
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.Cq4$b r0 = (ir.nasim.C3857Cq4.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Cq4$b r0 = new ir.nasim.Cq4$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            long r9 = r0.b
            ir.nasim.AbstractC10685c16.b(r11)
            goto L7d
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            long r9 = r0.b
            java.lang.Object r2 = r0.a
            ir.nasim.Cq4 r2 = (ir.nasim.C3857Cq4) r2
            ir.nasim.AbstractC10685c16.b(r11)
            goto L57
        L40:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.yq4 r11 = r8.x2()
            if (r11 == 0) goto L61
            r0.a = r8
            r0.b = r9
            r0.e = r4
            java.lang.Object r11 = r11.w0(r9, r0)
            if (r11 != r1) goto L56
            return r1
        L56:
            r2 = r8
        L57:
            ir.nasim.nR7 r11 = (ir.nasim.C17718nR7) r11
            long r4 = r11.o()
        L5d:
            r6 = r9
            r9 = r4
            r4 = r6
            goto L69
        L61:
            ir.nasim.nR7$a r11 = ir.nasim.C17718nR7.b
            long r4 = r11.a()
            r2 = r8
            goto L5d
        L69:
            ir.nasim.yq4 r11 = r2.o
            long r4 = ir.nasim.C17718nR7.k(r4, r9)
            r2 = 0
            r0.a = r2
            r0.b = r9
            r0.e = r3
            java.lang.Object r11 = r11.w0(r4, r0)
            if (r11 != r1) goto L7d
            return r1
        L7d:
            ir.nasim.nR7 r11 = (ir.nasim.C17718nR7) r11
            long r0 = r11.o()
            long r9 = ir.nasim.C17718nR7.l(r9, r0)
            ir.nasim.nR7 r9 = ir.nasim.C17718nR7.b(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3857Cq4.w0(long, ir.nasim.rm1):java.lang.Object");
    }

    public final C3857Cq4 y2() {
        if (b2()) {
            return (C3857Cq4) AbstractC8931Xv7.b(this);
        }
        return null;
    }
}
