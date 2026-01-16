package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.mo1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17342mo1 extends androidx.lifecycle.s {
    private C16680lh0 m;

    /* renamed from: ir.nasim.mo1$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            C17342mo1.this.m = null;
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.mo1$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C17342mo1.this.t(this);
        }
    }

    public C17342mo1(InterfaceC11938do1 interfaceC11938do1, long j, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        this.m = new C16680lh0(this, interfaceC14603iB2, j, AbstractC20906so1.a(C12366eV1.c().F0().X(interfaceC11938do1).X(P17.a((InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0)))), new a());
    }

    @Override // androidx.lifecycle.s, androidx.lifecycle.r
    protected void l() {
        super.l();
        C16680lh0 c16680lh0 = this.m;
        if (c16680lh0 != null) {
            c16680lh0.h();
        }
    }

    @Override // androidx.lifecycle.s, androidx.lifecycle.r
    protected void m() {
        super.m();
        C16680lh0 c16680lh0 = this.m;
        if (c16680lh0 != null) {
            c16680lh0.g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C17342mo1.b
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.mo1$b r0 = (ir.nasim.C17342mo1.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.mo1$b r0 = new ir.nasim.mo1$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            ir.nasim.AbstractC13660gc3.e()
            int r1 = r0.d
            if (r1 == 0) goto L34
            r2 = 1
            if (r1 != r2) goto L2c
            java.lang.Object r0 = r0.a
            ir.nasim.mo1 r0 = (ir.nasim.C17342mo1) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L38
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L34:
            ir.nasim.AbstractC10685c16.b(r5)
            r0 = r4
        L38:
            r0.getClass()
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17342mo1.t(ir.nasim.rm1):java.lang.Object");
    }
}
