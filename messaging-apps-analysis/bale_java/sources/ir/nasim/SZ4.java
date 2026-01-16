package ir.nasim;

import ir.nasim.InterfaceC22627vZ4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class SZ4 extends VW7 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final InterfaceC20760sZ4 b;
    private final C3607Bo6 c;
    private final InterfaceC9336Zm4 d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SZ4.this.new b(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r14.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.a16 r15 = (ir.nasim.C9475a16) r15
                java.lang.Object r15 = r15.l()
                goto L63
            L18:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L20:
                ir.nasim.AbstractC10685c16.b(r15)
                goto L54
            L24:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.SZ4 r15 = ir.nasim.SZ4.this
                ir.nasim.Zm4 r15 = ir.nasim.SZ4.S0(r15)
            L2d:
                java.lang.Object r1 = r15.getValue()
                r4 = r1
                ir.nasim.RZ4 r4 = (ir.nasim.RZ4) r4
                ir.nasim.zZ4 r6 = ir.nasim.EnumC24997zZ4.b
                r12 = 121(0x79, float:1.7E-43)
                r13 = 0
                r5 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                ir.nasim.RZ4 r4 = ir.nasim.RZ4.b(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                boolean r1 = r15.f(r1, r4)
                if (r1 == 0) goto L2d
                r14.b = r3
                r3 = 250(0xfa, double:1.235E-321)
                java.lang.Object r15 = ir.nasim.HG1.b(r3, r14)
                if (r15 != r0) goto L54
                return r0
            L54:
                ir.nasim.SZ4 r15 = ir.nasim.SZ4.this
                ir.nasim.sZ4 r15 = ir.nasim.SZ4.P0(r15)
                r14.b = r2
                java.lang.Object r15 = r15.a(r14)
                if (r15 != r0) goto L63
                return r0
            L63:
                ir.nasim.SZ4 r0 = ir.nasim.SZ4.this
                boolean r1 = ir.nasim.C9475a16.j(r15)
                if (r1 == 0) goto L96
                r1 = r15
                ir.nasim.rB7 r1 = (ir.nasim.C19938rB7) r1
                ir.nasim.Bo6 r1 = ir.nasim.SZ4.R0(r0)
                ir.nasim.wX4 r2 = ir.nasim.EnumC23205wX4.f
                r1.a(r2)
                ir.nasim.Zm4 r0 = ir.nasim.SZ4.S0(r0)
            L7b:
                java.lang.Object r1 = r0.getValue()
                r2 = r1
                ir.nasim.RZ4 r2 = (ir.nasim.RZ4) r2
                r10 = 125(0x7d, float:1.75E-43)
                r11 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                ir.nasim.RZ4 r2 = ir.nasim.RZ4.b(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                boolean r1 = r0.f(r1, r2)
                if (r1 == 0) goto L7b
            L96:
                ir.nasim.SZ4 r0 = ir.nasim.SZ4.this
                java.lang.Throwable r15 = ir.nasim.C9475a16.e(r15)
                if (r15 == 0) goto Ld8
                java.lang.String r15 = r15.getMessage()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Failed to delete all groups. Error: "
                r1.append(r2)
                r1.append(r15)
                java.lang.String r15 = r1.toString()
                java.lang.String r1 = "PASSPORT_GROUP"
                ir.nasim.C19406qI3.b(r1, r15)
                ir.nasim.Zm4 r15 = ir.nasim.SZ4.S0(r0)
            Lbc:
                java.lang.Object r0 = r15.getValue()
                r1 = r0
                ir.nasim.RZ4 r1 = (ir.nasim.RZ4) r1
                ir.nasim.PZ4 r8 = ir.nasim.PZ4.b
                r9 = 61
                r10 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                ir.nasim.RZ4 r1 = ir.nasim.RZ4.b(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                boolean r0 = r15.f(r0, r1)
                if (r0 == 0) goto Lbc
            Ld8:
                ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SZ4.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SZ4.this.new c(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r13.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                ir.nasim.AbstractC10685c16.b(r14)
                ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
                java.lang.Object r14 = r14.l()
                goto L45
            L18:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L20:
                ir.nasim.AbstractC10685c16.b(r14)
                goto L32
            L24:
                ir.nasim.AbstractC10685c16.b(r14)
                r13.b = r3
                r3 = 250(0xfa, double:1.235E-321)
                java.lang.Object r14 = ir.nasim.HG1.b(r3, r13)
                if (r14 != r0) goto L32
                return r0
            L32:
                ir.nasim.SZ4 r14 = ir.nasim.SZ4.this
                ir.nasim.sZ4 r14 = ir.nasim.SZ4.P0(r14)
                java.lang.String r1 = ir.nasim.PH3.d()
                r13.b = r2
                java.lang.Object r14 = r14.d(r1, r13)
                if (r14 != r0) goto L45
                return r0
            L45:
                ir.nasim.SZ4 r0 = ir.nasim.SZ4.this
                boolean r1 = ir.nasim.C9475a16.j(r14)
                if (r1 == 0) goto L78
                r1 = r14
                java.util.List r1 = (java.util.List) r1
                ir.nasim.Bo6 r2 = ir.nasim.SZ4.R0(r0)
                ir.nasim.wX4 r3 = ir.nasim.EnumC23205wX4.b
                r2.a(r3)
                ir.nasim.Zm4 r0 = ir.nasim.SZ4.S0(r0)
            L5d:
                java.lang.Object r12 = r0.getValue()
                r2 = r12
                ir.nasim.RZ4 r2 = (ir.nasim.RZ4) r2
                r10 = 124(0x7c, float:1.74E-43)
                r11 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r3 = r1
                ir.nasim.RZ4 r2 = ir.nasim.RZ4.b(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                boolean r2 = r0.f(r12, r2)
                if (r2 == 0) goto L5d
            L78:
                ir.nasim.SZ4 r0 = ir.nasim.SZ4.this
                java.lang.Throwable r14 = ir.nasim.C9475a16.e(r14)
                if (r14 == 0) goto Lba
                java.lang.String r14 = r14.getMessage()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Failed to load passport groups. Error: "
                r1.append(r2)
                r1.append(r14)
                java.lang.String r14 = r1.toString()
                java.lang.String r1 = "PASSPORT_GROUP"
                ir.nasim.C19406qI3.b(r1, r14)
                ir.nasim.Zm4 r14 = ir.nasim.SZ4.S0(r0)
            L9e:
                java.lang.Object r0 = r14.getValue()
                r1 = r0
                ir.nasim.RZ4 r1 = (ir.nasim.RZ4) r1
                ir.nasim.QZ4 r7 = ir.nasim.QZ4.b
                r9 = 77
                r10 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 1
                r8 = 0
                ir.nasim.RZ4 r1 = ir.nasim.RZ4.b(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                boolean r0 = r14.f(r0, r1)
                if (r0 == 0) goto L9e
            Lba:
                ir.nasim.rB7 r14 = ir.nasim.C19938rB7.a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SZ4.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public SZ4(InterfaceC20760sZ4 interfaceC20760sZ4, C3607Bo6 c3607Bo6) {
        AbstractC13042fc3.i(interfaceC20760sZ4, "passportRepository");
        AbstractC13042fc3.i(c3607Bo6, "sendPassportAnalyticsUseCase");
        this.b = interfaceC20760sZ4;
        this.c = c3607Bo6;
        this.d = AbstractC12281eL6.a(new RZ4(null, null, null, null, false, null, null, 127, null));
        Y0();
    }

    private final void V0(boolean z) {
        Object value;
        if (z) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(null), 3, null);
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, RZ4.b((RZ4) value, null, null, null, null, false, null, null, 123, null)));
    }

    private final void W0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, (RZ4) value));
    }

    private final void Y0() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final InterfaceC10258bL6 T0() {
        return this.d;
    }

    public final void U0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, RZ4.b((RZ4) value, null, null, null, null, false, null, null, 119, null)));
    }

    public final void X0(InterfaceC22627vZ4 interfaceC22627vZ4) {
        Object value;
        Object value2;
        Object value3;
        AbstractC13042fc3.i(interfaceC22627vZ4, "event");
        if (AbstractC13042fc3.d(interfaceC22627vZ4, InterfaceC22627vZ4.b.a)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            do {
                value3 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value3, RZ4.b((RZ4) value3, null, null, EnumC22037uZ4.a, null, false, null, null, 123, null)));
            return;
        }
        if (interfaceC22627vZ4 instanceof InterfaceC22627vZ4.c) {
            V0(((InterfaceC22627vZ4.c) interfaceC22627vZ4).a());
            return;
        }
        if (AbstractC13042fc3.d(interfaceC22627vZ4, InterfaceC22627vZ4.e.a)) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.d;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, RZ4.b((RZ4) value2, null, null, null, null, false, null, null, 123, null)));
        } else if (interfaceC22627vZ4 instanceof InterfaceC22627vZ4.a) {
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.d;
            do {
                value = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value, RZ4.b((RZ4) value, null, null, null, Integer.valueOf(((InterfaceC22627vZ4.a) interfaceC22627vZ4).a()), false, null, null, 119, null)));
        } else {
            if (!AbstractC13042fc3.d(interfaceC22627vZ4, InterfaceC22627vZ4.d.a)) {
                throw new NoWhenBranchMatchedException();
            }
            W0();
        }
    }

    public final void Z0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, RZ4.b((RZ4) value, null, null, null, null, false, null, null, 63, null)));
    }

    public final void a1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, RZ4.b((RZ4) value, null, null, null, null, false, null, null, 95, null)));
    }
}
