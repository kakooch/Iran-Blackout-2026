package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC6693Oo5;

/* renamed from: ir.nasim.sq2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C20927sq2 {
    private float a;
    private float b;
    private float c;
    private float d;
    private final C15607js e;
    private InterfaceC22645vb3 f;
    private InterfaceC22645vb3 g;

    /* renamed from: ir.nasim.sq2$a */
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
            return C20927sq2.this.b(null, this);
        }
    }

    /* renamed from: ir.nasim.sq2$b */
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
            return C20927sq2.this.e(this);
        }
    }

    public /* synthetic */ C20927sq2(float f, float f2, float f3, float f4, ED1 ed1) {
        this(f, f2, f3, f4);
    }

    private final float d(InterfaceC22645vb3 interfaceC22645vb3) {
        return interfaceC22645vb3 instanceof InterfaceC6693Oo5.b ? this.b : interfaceC22645vb3 instanceof C12403eZ2 ? this.c : interfaceC22645vb3 instanceof C23400wr2 ? this.d : this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ir.nasim.InterfaceC20295rm1 r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C20927sq2.b
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.sq2$b r0 = (ir.nasim.C20927sq2.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.sq2$b r0 = new ir.nasim.sq2$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.a
            ir.nasim.sq2 r0 = (ir.nasim.C20927sq2) r0
            ir.nasim.AbstractC10685c16.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L64
        L2d:
            r5 = move-exception
            goto L6b
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.vb3 r5 = r4.g
            float r5 = r4.d(r5)
            ir.nasim.js r2 = r4.e
            java.lang.Object r2 = r2.n()
            ir.nasim.nZ1 r2 = (ir.nasim.C17784nZ1) r2
            float r2 = r2.v()
            boolean r2 = ir.nasim.C17784nZ1.s(r2, r5)
            if (r2 != 0) goto L70
            ir.nasim.js r2 = r4.e     // Catch: java.lang.Throwable -> L69
            ir.nasim.nZ1 r5 = ir.nasim.C17784nZ1.j(r5)     // Catch: java.lang.Throwable -> L69
            r0.a = r4     // Catch: java.lang.Throwable -> L69
            r0.d = r3     // Catch: java.lang.Throwable -> L69
            java.lang.Object r5 = r2.x(r5, r0)     // Catch: java.lang.Throwable -> L69
            if (r5 != r1) goto L63
            return r1
        L63:
            r0 = r4
        L64:
            ir.nasim.vb3 r5 = r0.g
            r0.f = r5
            goto L70
        L69:
            r5 = move-exception
            r0 = r4
        L6b:
            ir.nasim.vb3 r1 = r0.g
            r0.f = r1
            throw r5
        L70:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20927sq2.e(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.InterfaceC22645vb3 r6, ir.nasim.InterfaceC20295rm1 r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C20927sq2.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.sq2$a r0 = (ir.nasim.C20927sq2.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.sq2$a r0 = new ir.nasim.sq2$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.b
            ir.nasim.vb3 r6 = (ir.nasim.InterfaceC22645vb3) r6
            java.lang.Object r0 = r0.a
            ir.nasim.sq2 r0 = (ir.nasim.C20927sq2) r0
            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L6b
        L31:
            r7 = move-exception
            goto L70
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            ir.nasim.AbstractC10685c16.b(r7)
            float r7 = r5.d(r6)
            r5.g = r6
            ir.nasim.js r2 = r5.e     // Catch: java.lang.Throwable -> L67
            java.lang.Object r2 = r2.n()     // Catch: java.lang.Throwable -> L67
            ir.nasim.nZ1 r2 = (ir.nasim.C17784nZ1) r2     // Catch: java.lang.Throwable -> L67
            float r2 = r2.v()     // Catch: java.lang.Throwable -> L67
            boolean r2 = ir.nasim.C17784nZ1.s(r2, r7)     // Catch: java.lang.Throwable -> L67
            if (r2 != 0) goto L6a
            ir.nasim.js r2 = r5.e     // Catch: java.lang.Throwable -> L67
            ir.nasim.vb3 r4 = r5.f     // Catch: java.lang.Throwable -> L67
            r0.a = r5     // Catch: java.lang.Throwable -> L67
            r0.b = r6     // Catch: java.lang.Throwable -> L67
            r0.e = r3     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = ir.nasim.F52.d(r2, r7, r4, r6, r0)     // Catch: java.lang.Throwable -> L67
            if (r7 != r1) goto L6a
            return r1
        L67:
            r7 = move-exception
            r0 = r5
            goto L70
        L6a:
            r0 = r5
        L6b:
            r0.f = r6
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        L70:
            r0.f = r6
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20927sq2.b(ir.nasim.vb3, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC9664aL6 c() {
        return this.e.i();
    }

    public final Object f(float f, float f2, float f3, float f4, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        Object objE = e(interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    private C20927sq2(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = new C15607js(C17784nZ1.j(this.a), PQ7.b(C17784nZ1.b), null, null, 12, null);
    }
}
