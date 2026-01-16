package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.zq4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25166zq4 {
    private C3857Cq4 a;
    private C3857Cq4 b;
    private SA2 c = new a();
    private InterfaceC20315ro1 d;

    /* renamed from: ir.nasim.zq4$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC20315ro1 invoke() {
            return C25166zq4.this.h();
        }
    }

    /* renamed from: ir.nasim.zq4$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C25166zq4.this.a(0L, 0L, this);
        }
    }

    /* renamed from: ir.nasim.zq4$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C25166zq4.this.c(0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r8, long r10, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof ir.nasim.C25166zq4.b
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.zq4$b r0 = (ir.nasim.C25166zq4.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.zq4$b r0 = new ir.nasim.zq4$b
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            ir.nasim.AbstractC10685c16.b(r12)
            goto L75
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            ir.nasim.AbstractC10685c16.b(r12)
            goto L56
        L3a:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.yq4 r12 = r7.g()
            if (r12 != 0) goto L64
            boolean r12 = ir.nasim.C15439jb1.c
            if (r12 == 0) goto L64
            ir.nasim.Cq4 r1 = r7.b
            if (r1 == 0) goto L5d
            r6.c = r3
            r2 = r8
            r4 = r10
            java.lang.Object r12 = r1.i0(r2, r4, r6)
            if (r12 != r0) goto L56
            return r0
        L56:
            ir.nasim.nR7 r12 = (ir.nasim.C17718nR7) r12
            long r8 = r12.o()
            goto L82
        L5d:
            ir.nasim.nR7$a r8 = ir.nasim.C17718nR7.b
            long r8 = r8.a()
            goto L82
        L64:
            ir.nasim.yq4 r1 = r7.g()
            if (r1 == 0) goto L7c
            r6.c = r2
            r2 = r8
            r4 = r10
            java.lang.Object r12 = r1.i0(r2, r4, r6)
            if (r12 != r0) goto L75
            return r0
        L75:
            ir.nasim.nR7 r12 = (ir.nasim.C17718nR7) r12
            long r8 = r12.o()
            goto L82
        L7c:
            ir.nasim.nR7$a r8 = ir.nasim.C17718nR7.b
            long r8 = r8.a()
        L82:
            ir.nasim.nR7 r8 = ir.nasim.C17718nR7.b(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C25166zq4.a(long, long, ir.nasim.rm1):java.lang.Object");
    }

    public final long b(long j, long j2, int i) {
        InterfaceC24572yq4 interfaceC24572yq4G = g();
        return interfaceC24572yq4G != null ? interfaceC24572yq4G.H0(j, j2, i) : ZG4.b.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(long r5, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C25166zq4.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.zq4$c r0 = (ir.nasim.C25166zq4.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.zq4$c r0 = new ir.nasim.zq4$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.yq4 r7 = r4.g()
            if (r7 == 0) goto L4a
            r0.c = r3
            java.lang.Object r7 = r7.w0(r5, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            ir.nasim.nR7 r7 = (ir.nasim.C17718nR7) r7
            long r5 = r7.o()
            goto L50
        L4a:
            ir.nasim.nR7$a r5 = ir.nasim.C17718nR7.b
            long r5 = r5.a()
        L50:
            ir.nasim.nR7 r5 = ir.nasim.C17718nR7.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C25166zq4.c(long, ir.nasim.rm1):java.lang.Object");
    }

    public final long d(long j, int i) {
        InterfaceC24572yq4 interfaceC24572yq4G = g();
        return interfaceC24572yq4G != null ? interfaceC24572yq4G.s1(j, i) : ZG4.b.c();
    }

    public final InterfaceC20315ro1 e() {
        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c.invoke();
        if (interfaceC20315ro1 != null) {
            return interfaceC20315ro1;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final C3857Cq4 f() {
        return this.a;
    }

    public final InterfaceC24572yq4 g() {
        C3857Cq4 c3857Cq4 = this.a;
        if (c3857Cq4 != null) {
            return c3857Cq4.y2();
        }
        return null;
    }

    public final InterfaceC20315ro1 h() {
        return this.d;
    }

    public final void i(SA2 sa2) {
        this.c = sa2;
    }

    public final void j(C3857Cq4 c3857Cq4) {
        this.b = c3857Cq4;
    }

    public final void k(C3857Cq4 c3857Cq4) {
        this.a = c3857Cq4;
    }

    public final void l(InterfaceC20315ro1 interfaceC20315ro1) {
        this.d = interfaceC20315ro1;
    }
}
