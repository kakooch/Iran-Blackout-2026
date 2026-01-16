package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC19699qn4;

/* renamed from: ir.nasim.No5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6433No5 implements InterfaceC6194Mo5, WH1 {
    private final /* synthetic */ WH1 a;
    private boolean b;
    private boolean c;
    private final InterfaceC19699qn4 d = AbstractC20899sn4.a(false);

    /* renamed from: ir.nasim.No5$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C6433No5.this.o(this);
        }
    }

    /* renamed from: ir.nasim.No5$b */
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
            return C6433No5.this.R0(this);
        }
    }

    public C6433No5(WH1 wh1) {
        this.a = wh1;
    }

    @Override // ir.nasim.WH1
    public int A1(long j) {
        return this.a.A1(j);
    }

    @Override // ir.nasim.WH1
    public int B0(float f) {
        return this.a.B0(f);
    }

    @Override // ir.nasim.WH1
    public float D(int i) {
        return this.a.D(i);
    }

    @Override // ir.nasim.WH1
    public float I0(long j) {
        return this.a.I0(j);
    }

    @Override // ir.nasim.WH1
    public long I1(long j) {
        return this.a.I1(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC6194Mo5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object R0(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C6433No5.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.No5$b r0 = (ir.nasim.C6433No5.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.No5$b r0 = new ir.nasim.No5$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r0 = r0.a
            ir.nasim.No5 r0 = (ir.nasim.C6433No5) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            ir.nasim.AbstractC10685c16.b(r6)
            boolean r6 = r5.b
            if (r6 != 0) goto L55
            boolean r6 = r5.c
            if (r6 != 0) goto L55
            ir.nasim.qn4 r6 = r5.d
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = ir.nasim.InterfaceC19699qn4.a.a(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r0 = r5
        L4f:
            ir.nasim.qn4 r6 = r0.d
            ir.nasim.InterfaceC19699qn4.a.c(r6, r3, r4, r3)
            goto L56
        L55:
            r0 = r5
        L56:
            boolean r6 = r0.b
            java.lang.Boolean r6 = ir.nasim.AbstractC6392Nk0.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6433No5.R0(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public long T(float f) {
        return this.a.T(f);
    }

    @Override // ir.nasim.WH1
    public long U(long j) {
        return this.a.U(j);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float Y(long j) {
        return this.a.Y(j);
    }

    public final void b() {
        this.c = true;
        if (this.d.d()) {
            InterfaceC19699qn4.a.c(this.d, null, 1, null);
        }
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.a.getDensity();
    }

    public final void h() {
        this.b = true;
        if (this.d.d()) {
            InterfaceC19699qn4.a.c(this.d, null, 1, null);
        }
    }

    @Override // ir.nasim.WH1
    public long j0(float f) {
        return this.a.j0(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C6433No5.a
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.No5$a r0 = (ir.nasim.C6433No5.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.No5$a r0 = new ir.nasim.No5$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.No5 r0 = (ir.nasim.C6433No5) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.qn4 r5 = r4.d
            r0.a = r4
            r0.d = r3
            r2 = 0
            java.lang.Object r5 = ir.nasim.InterfaceC19699qn4.a.a(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L46
            return r1
        L46:
            r0 = r4
        L47:
            r5 = 0
            r0.b = r5
            r0.c = r5
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6433No5.o(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.WH1
    public float o1(float f) {
        return this.a.o1(f);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.a.t1();
    }

    @Override // ir.nasim.WH1
    public float w1(float f) {
        return this.a.w1(f);
    }
}
