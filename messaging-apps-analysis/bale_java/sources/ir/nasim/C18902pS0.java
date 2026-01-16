package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.banking.BankingModule;
import java.util.ArrayList;

/* renamed from: ir.nasim.pS0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18902pS0 {
    private static final a e = new a(null);
    public static final int f = 8;
    private final AbstractC13778go1 a;
    private final BankingModule b;
    private final ArrayList c;
    private final ArrayList d;

    /* renamed from: ir.nasim.pS0$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.pS0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        boolean b;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18902pS0.this.new b(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0085 A[Catch: Exception -> 0x0022, TryCatch #0 {Exception -> 0x0022, blocks: (B:8:0x0017, B:43:0x00ae, B:45:0x00b4, B:46:0x00b7, B:14:0x002d, B:39:0x0098, B:17:0x0033, B:31:0x007f, B:33:0x0085, B:34:0x0088, B:36:0x008d, B:40:0x009b, B:20:0x003f, B:23:0x0046, B:25:0x005d, B:28:0x006a), top: B:50:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[Catch: Exception -> 0x0022, TryCatch #0 {Exception -> 0x0022, blocks: (B:8:0x0017, B:43:0x00ae, B:45:0x00b4, B:46:0x00b7, B:14:0x002d, B:39:0x0098, B:17:0x0033, B:31:0x007f, B:33:0x0085, B:34:0x0088, B:36:0x008d, B:40:0x009b, B:20:0x003f, B:23:0x0046, B:25:0x005d, B:28:0x006a), top: B:50:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x009b A[Catch: Exception -> 0x0022, TryCatch #0 {Exception -> 0x0022, blocks: (B:8:0x0017, B:43:0x00ae, B:45:0x00b4, B:46:0x00b7, B:14:0x002d, B:39:0x0098, B:17:0x0033, B:31:0x007f, B:33:0x0085, B:34:0x0088, B:36:0x008d, B:40:0x009b, B:20:0x003f, B:23:0x0046, B:25:0x005d, B:28:0x006a), top: B:50:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00b4 A[Catch: Exception -> 0x0022, TryCatch #0 {Exception -> 0x0022, blocks: (B:8:0x0017, B:43:0x00ae, B:45:0x00b4, B:46:0x00b7, B:14:0x002d, B:39:0x0098, B:17:0x0033, B:31:0x007f, B:33:0x0085, B:34:0x0088, B:36:0x008d, B:40:0x009b, B:20:0x003f, B:23:0x0046, B:25:0x005d, B:28:0x006a), top: B:50:0x000d }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.c
                r2 = 4
                r3 = 3
                r4 = 2
                java.lang.String r5 = "CheckMigrateCardsUseCase"
                r6 = 0
                r7 = 1
                if (r1 == 0) goto L43
                if (r1 == r7) goto L3d
                if (r1 == r4) goto L31
                if (r1 == r3) goto L2d
                if (r1 != r2) goto L25
                ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.lang.Exception -> L22
                ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11     // Catch: java.lang.Exception -> L22
                java.lang.Object r11 = r11.l()     // Catch: java.lang.Exception -> L22
                goto Lae
            L22:
                r11 = move-exception
                goto Lbc
            L25:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L2d:
                ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.lang.Exception -> L22
                goto L98
            L31:
                boolean r1 = r10.b
                ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.lang.Exception -> L22
                ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11     // Catch: java.lang.Exception -> L22
                java.lang.Object r11 = r11.l()     // Catch: java.lang.Exception -> L22
                goto L7f
            L3d:
                boolean r1 = r10.b
                ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.lang.Exception -> L22
                goto L8b
            L43:
                ir.nasim.AbstractC10685c16.b(r11)
                ir.nasim.Bk5 r11 = ir.nasim.C7183Qq.p()     // Catch: java.lang.Exception -> L22
                java.lang.String r1 = "newCardManagementMigratedDone"
                r8 = 0
                boolean r11 = r11.h(r1, r8)     // Catch: java.lang.Exception -> L22
                ir.nasim.Bk5 r1 = ir.nasim.C7183Qq.p()     // Catch: java.lang.Exception -> L22
                java.lang.String r9 = "newCardManagementMigratedDone_DESTIONATION"
                boolean r1 = r1.h(r9, r8)     // Catch: java.lang.Exception -> L22
                if (r11 != 0) goto L6a
                ir.nasim.pS0 r11 = ir.nasim.C18902pS0.this     // Catch: java.lang.Exception -> L22
                r10.b = r1     // Catch: java.lang.Exception -> L22
                r10.c = r7     // Catch: java.lang.Exception -> L22
                java.lang.Object r11 = ir.nasim.C18902pS0.c(r11, r10)     // Catch: java.lang.Exception -> L22
                if (r11 != r0) goto L8b
                return r0
            L6a:
                ir.nasim.pS0 r11 = ir.nasim.C18902pS0.this     // Catch: java.lang.Exception -> L22
                ir.nasim.core.modules.banking.BankingModule r11 = ir.nasim.C18902pS0.a(r11)     // Catch: java.lang.Exception -> L22
                ir.nasim.Nv5 r11 = r11.R1()     // Catch: java.lang.Exception -> L22
                r10.b = r1     // Catch: java.lang.Exception -> L22
                r10.c = r4     // Catch: java.lang.Exception -> L22
                java.lang.Object r11 = ir.nasim.AbstractC6756Ov5.d(r11, r6, r10, r7, r6)     // Catch: java.lang.Exception -> L22
                if (r11 != r0) goto L7f
                return r0
            L7f:
                java.lang.Throwable r4 = ir.nasim.C9475a16.e(r11)     // Catch: java.lang.Exception -> L22
                if (r4 == 0) goto L88
                ir.nasim.C19406qI3.d(r5, r4)     // Catch: java.lang.Exception -> L22
            L88:
                ir.nasim.C9475a16.a(r11)     // Catch: java.lang.Exception -> L22
            L8b:
                if (r1 != 0) goto L9b
                ir.nasim.pS0 r11 = ir.nasim.C18902pS0.this     // Catch: java.lang.Exception -> L22
                r10.c = r3     // Catch: java.lang.Exception -> L22
                java.lang.Object r11 = ir.nasim.C18902pS0.b(r11, r10)     // Catch: java.lang.Exception -> L22
                if (r11 != r0) goto L98
                return r0
            L98:
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a     // Catch: java.lang.Exception -> L22
                goto Lc1
            L9b:
                ir.nasim.pS0 r11 = ir.nasim.C18902pS0.this     // Catch: java.lang.Exception -> L22
                ir.nasim.core.modules.banking.BankingModule r11 = ir.nasim.C18902pS0.a(r11)     // Catch: java.lang.Exception -> L22
                ir.nasim.Nv5 r11 = r11.Q1()     // Catch: java.lang.Exception -> L22
                r10.c = r2     // Catch: java.lang.Exception -> L22
                java.lang.Object r11 = ir.nasim.AbstractC6756Ov5.d(r11, r6, r10, r7, r6)     // Catch: java.lang.Exception -> L22
                if (r11 != r0) goto Lae
                return r0
            Lae:
                java.lang.Throwable r0 = ir.nasim.C9475a16.e(r11)     // Catch: java.lang.Exception -> L22
                if (r0 == 0) goto Lb7
                ir.nasim.C19406qI3.d(r5, r0)     // Catch: java.lang.Exception -> L22
            Lb7:
                ir.nasim.a16 r11 = ir.nasim.C9475a16.a(r11)     // Catch: java.lang.Exception -> L22
                goto Lc1
            Lbc:
                ir.nasim.C19406qI3.d(r5, r11)
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
            Lc1:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18902pS0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pS0$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C18902pS0.this.g(this);
        }
    }

    /* renamed from: ir.nasim.pS0$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C18902pS0.this.h(this);
        }
    }

    /* renamed from: ir.nasim.pS0$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C18902pS0.this.i(null, 0, this);
        }
    }

    /* renamed from: ir.nasim.pS0$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C18902pS0.this.j(null, 0, this);
        }
    }

    public C18902pS0(AbstractC13778go1 abstractC13778go1, BankingModule bankingModule) {
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.a = abstractC13778go1;
        this.b = bankingModule;
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.C18902pS0.c
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.pS0$c r0 = (ir.nasim.C18902pS0.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.pS0$c r0 = new ir.nasim.pS0$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.a
            ir.nasim.AbstractC10685c16.b(r8)
            goto L7a
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            java.lang.Object r2 = r0.a
            ir.nasim.pS0 r2 = (ir.nasim.C18902pS0) r2
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            goto L5a
        L44:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.core.modules.banking.BankingModule r8 = r7.b
            ir.nasim.Nv5 r8 = r8.M1()
            r0.a = r7
            r0.d = r4
            r2 = 0
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.d(r8, r2, r0, r4, r2)
            if (r8 != r1) goto L59
            return r1
        L59:
            r2 = r7
        L5a:
            boolean r5 = ir.nasim.C9475a16.j(r8)
            if (r5 == 0) goto L85
            r5 = r8
            java.util.List r5 = (java.util.List) r5
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r4
            if (r6 == 0) goto L7c
            r0.a = r8
            r0.d = r3
            r3 = 0
            java.lang.Object r0 = r2.i(r5, r3, r0)
            if (r0 != r1) goto L79
            return r1
        L79:
            r0 = r8
        L7a:
            r8 = r0
            goto L85
        L7c:
            ir.nasim.Bk5 r0 = ir.nasim.C7183Qq.p()
            java.lang.String r1 = "newCardManagementMigratedDone_DESTIONATION"
            r0.g(r1, r4)
        L85:
            java.lang.Throwable r8 = ir.nasim.C9475a16.e(r8)
            if (r8 == 0) goto L90
            java.lang.String r0 = "CheckMigrateCardsUseCase"
            ir.nasim.C19406qI3.d(r0, r8)
        L90:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18902pS0.g(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.C18902pS0.d
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.pS0$d r0 = (ir.nasim.C18902pS0.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.pS0$d r0 = new ir.nasim.pS0$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.a
            ir.nasim.AbstractC10685c16.b(r8)
            goto L83
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            java.lang.Object r2 = r0.a
            ir.nasim.pS0 r2 = (ir.nasim.C18902pS0) r2
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            goto L5a
        L44:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.core.modules.banking.BankingModule r8 = r7.b
            ir.nasim.Nv5 r8 = r8.V1()
            r0.a = r7
            r0.d = r4
            r2 = 0
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.d(r8, r2, r0, r4, r2)
            if (r8 != r1) goto L59
            return r1
        L59:
            r2 = r7
        L5a:
            boolean r5 = ir.nasim.C9475a16.j(r8)
            if (r5 == 0) goto L8e
            r5 = r8
            java.util.List r5 = (java.util.List) r5
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r4
            if (r6 == 0) goto L85
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.collections.MutableList<ir.nasim.core.modules.banking.DigitOnlyBankCard>"
            ir.nasim.AbstractC13042fc3.g(r5, r4)
            java.util.List r4 = ir.nasim.AbstractC19810qy7.c(r5)
            r0.a = r8
            r0.d = r3
            r3 = 0
            java.lang.Object r0 = r2.j(r4, r3, r0)
            if (r0 != r1) goto L82
            return r1
        L82:
            r0 = r8
        L83:
            r8 = r0
            goto L8e
        L85:
            ir.nasim.Bk5 r0 = ir.nasim.C7183Qq.p()
            java.lang.String r1 = "newCardManagementMigratedDone"
            r0.g(r1, r4)
        L8e:
            java.lang.Throwable r8 = ir.nasim.C9475a16.e(r8)
            if (r8 == 0) goto L99
            java.lang.String r0 = "CheckMigrateCardsUseCase"
            ir.nasim.C19406qI3.d(r0, r8)
        L99:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18902pS0.h(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.util.List r30, int r31, ir.nasim.InterfaceC20295rm1 r32) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18902pS0.i(java.util.List, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.util.List r32, int r33, ir.nasim.InterfaceC20295rm1 r34) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18902pS0.j(java.util.List, int, ir.nasim.rm1):java.lang.Object");
    }

    public final Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.a, new b(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }
}
