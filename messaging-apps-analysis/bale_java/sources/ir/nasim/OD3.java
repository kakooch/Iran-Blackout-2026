package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.QD3;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes5.dex */
public final class OD3 implements LD3 {
    private static final a l = new a(null);
    private final WG3 a;
    private final C19453qN5 b;
    private final E84 c;
    private final KM2 d;
    private final InterfaceC20315ro1 e;
    private final AbstractC13778go1 f;
    private final InterfaceC14123hO3 g;
    private final InterfaceC3570Bk5 h;
    private C21724u16 i;
    private final InterfaceC17639nJ0 j;
    private final InterfaceC10258bL6 k;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return OD3.this.o(this);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objL = OD3.this.l(0L, this);
            return objL == AbstractC14862ic3.e() ? objL : C9475a16.a(objL);
        }
    }

    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return OD3.this.p(this);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return OD3.this.new e(interfaceC20295rm1);
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x00be: INVOKE (r5 I:ir.nasim.VI5), (r10 I:java.lang.Throwable) STATIC call: ir.nasim.QJ0.a(ir.nasim.VI5, java.lang.Throwable):void A[MD:(ir.nasim.VI5, java.lang.Throwable):void (m)] (LINE:191), block:B:44:0x00be */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0067 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:8:0x001d, B:20:0x0059, B:24:0x006b, B:26:0x0073, B:28:0x007d, B:32:0x0094, B:34:0x0098, B:37:0x00ad, B:38:0x00b2, B:39:0x00b3, B:16:0x0046, B:19:0x0055), top: B:46:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00b3 A[Catch: all -> 0x0022, TRY_LEAVE, TryCatch #0 {all -> 0x0022, blocks: (B:8:0x001d, B:20:0x0059, B:24:0x006b, B:26:0x0073, B:28:0x007d, B:32:0x0094, B:34:0x0098, B:37:0x00ad, B:38:0x00b2, B:39:0x00b3, B:16:0x0046, B:19:0x0055), top: B:46:0x0009 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008f -> B:31:0x0092). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00aa -> B:31:0x0092). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L4a
                if (r1 == r4) goto L3a
                if (r1 == r3) goto L2d
                if (r1 != r2) goto L25
                java.lang.Object r1 = r9.d
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r5 = r9.c
                ir.nasim.VI5 r5 = (ir.nasim.VI5) r5
                java.lang.Object r6 = r9.b
                ir.nasim.OD3 r6 = (ir.nasim.OD3) r6
            L1d:
                ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L22
                goto L92
            L22:
                r10 = move-exception
                goto Lbc
            L25:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L2d:
                java.lang.Object r1 = r9.d
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r5 = r9.c
                ir.nasim.VI5 r5 = (ir.nasim.VI5) r5
                java.lang.Object r6 = r9.b
                ir.nasim.OD3 r6 = (ir.nasim.OD3) r6
                goto L1d
            L3a:
                java.lang.Object r1 = r9.d
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r5 = r9.c
                ir.nasim.VI5 r5 = (ir.nasim.VI5) r5
                java.lang.Object r6 = r9.b
                ir.nasim.OD3 r6 = (ir.nasim.OD3) r6
                ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L22
                goto L6b
            L4a:
                ir.nasim.AbstractC10685c16.b(r10)
                ir.nasim.OD3 r10 = ir.nasim.OD3.this
                ir.nasim.nJ0 r5 = ir.nasim.OD3.g(r10)
                ir.nasim.OD3 r10 = ir.nasim.OD3.this
                ir.nasim.CJ0 r1 = r5.iterator()     // Catch: java.lang.Throwable -> L22
            L59:
                r9.b = r10     // Catch: java.lang.Throwable -> L22
                r9.c = r5     // Catch: java.lang.Throwable -> L22
                r9.d = r1     // Catch: java.lang.Throwable -> L22
                r9.e = r4     // Catch: java.lang.Throwable -> L22
                java.lang.Object r6 = r1.a(r9)     // Catch: java.lang.Throwable -> L22
                if (r6 != r0) goto L68
                return r0
            L68:
                r8 = r6
                r6 = r10
                r10 = r8
            L6b:
                java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L22
                boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L22
                if (r10 == 0) goto Lb3
                java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L22
                ir.nasim.QD3 r10 = (ir.nasim.QD3) r10     // Catch: java.lang.Throwable -> L22
                boolean r7 = r10 instanceof ir.nasim.QD3.a     // Catch: java.lang.Throwable -> L22
                if (r7 == 0) goto L94
                ir.nasim.QD3$a r10 = (ir.nasim.QD3.a) r10     // Catch: java.lang.Throwable -> L22
                ir.nasim.FD3 r10 = r10.a()     // Catch: java.lang.Throwable -> L22
                r9.b = r6     // Catch: java.lang.Throwable -> L22
                r9.c = r5     // Catch: java.lang.Throwable -> L22
                r9.d = r1     // Catch: java.lang.Throwable -> L22
                r9.e = r3     // Catch: java.lang.Throwable -> L22
                java.lang.Object r10 = ir.nasim.OD3.j(r6, r10, r9)     // Catch: java.lang.Throwable -> L22
                if (r10 != r0) goto L92
                return r0
            L92:
                r10 = r6
                goto L59
            L94:
                boolean r7 = r10 instanceof ir.nasim.QD3.b     // Catch: java.lang.Throwable -> L22
                if (r7 == 0) goto Lad
                ir.nasim.QD3$b r10 = (ir.nasim.QD3.b) r10     // Catch: java.lang.Throwable -> L22
                ir.nasim.FD3 r10 = r10.a()     // Catch: java.lang.Throwable -> L22
                r9.b = r6     // Catch: java.lang.Throwable -> L22
                r9.c = r5     // Catch: java.lang.Throwable -> L22
                r9.d = r1     // Catch: java.lang.Throwable -> L22
                r9.e = r2     // Catch: java.lang.Throwable -> L22
                java.lang.Object r10 = ir.nasim.OD3.n(r6, r10, r9)     // Catch: java.lang.Throwable -> L22
                if (r10 != r0) goto L92
                return r0
            Lad:
                kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L22
                r10.<init>()     // Catch: java.lang.Throwable -> L22
                throw r10     // Catch: java.lang.Throwable -> L22
            Lb3:
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L22
                r10 = 0
                ir.nasim.QJ0.a(r5, r10)
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            Lbc:
                throw r10     // Catch: java.lang.Throwable -> Lbd
            Lbd:
                r0 = move-exception
                ir.nasim.QJ0.a(r5, r10)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OD3.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((FD3) obj2).d().z()) {
                    arrayList.add(obj2);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(arrayList, 10)), 16));
            for (Object obj3 : arrayList) {
                linkedHashMap.put(AbstractC6392Nk0.e(((FD3) obj3).d().u()), obj3);
            }
            return linkedHashMap;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return OD3.this.new g(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0098 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00cb A[LOOP:1: B:37:0x00c5->B:39:0x00cb, LOOP_END] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 242
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OD3.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public OD3(WG3 wg3, C19453qN5 c19453qN5, E84 e84, KM2 km2, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC3570Bk5 interfaceC3570Bk5, boolean z) {
        AbstractC13042fc3.i(wg3, "localDataSource");
        AbstractC13042fc3.i(c19453qN5, "remoteDataSource");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC14123hO3, "newLiveInfoToLiveStreamDataMapper");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        this.a = wg3;
        this.b = c19453qN5;
        this.c = e84;
        this.d = km2;
        this.e = interfaceC20315ro1;
        this.f = abstractC13778go1;
        this.g = interfaceC14123hO3;
        this.h = interfaceC3570Bk5;
        this.i = new C21724u16(0, 1, null);
        this.j = DJ0.a(Integer.MAX_VALUE, EnumC6162Ml0.DROP_OLDEST, new UA2() { // from class: ir.nasim.MD3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return OD3.t((QD3) obj);
            }
        });
        if (z) {
            q();
        }
        if (!interfaceC3570Bk5.h("FIRST_ONCE_FETCH_ALL", false)) {
            k();
            interfaceC3570Bk5.g("FIRST_ONCE_FETCH_ALL", true);
        }
        this.k = AbstractC6459Nq2.o0(AbstractC6459Nq2.X(wg3.d(), new f(null)), interfaceC20315ro1, InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), AbstractC20051rO3.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OD3.o(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.OD3.d
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.OD3$d r0 = (ir.nasim.OD3.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.OD3$d r0 = new ir.nasim.OD3$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L47
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.KM2 r5 = r4.d
            ir.nasim.ZN2 r2 = ir.nasim.ZN2.CHANNEL
            r0.c = r3
            java.lang.Object r5 = r5.g(r2, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            java.lang.Throwable r0 = ir.nasim.C9475a16.e(r5)
            if (r0 != 0) goto L50
            java.util.List r5 = (java.util.List) r5
            goto L6e
        L50:
            java.lang.String r5 = r0.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getAllGroups, error="
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "LiveStreamRepoImpl"
            ir.nasim.C19406qI3.b(r0, r5)
            java.util.List r5 = ir.nasim.ZW0.m()
        L6e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OD3.p(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(FD3 fd3, InterfaceC20295rm1 interfaceC20295rm1) {
        if (fd3.d().z()) {
            this.c.T1(fd3.d());
        }
        Object objE = this.a.e(fd3.a(), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(FD3 fd3, InterfaceC20295rm1 interfaceC20295rm1) {
        if (fd3.d().z()) {
            this.c.U1(fd3.d(), AbstractC6392Nk0.e(fd3.a()));
        }
        Object objC = this.a.c(fd3, interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(QD3 qd3) {
        AbstractC13042fc3.i(qd3, "it");
        C19406qI3.b("LiveStreamRepoImpl", "Undelivered element: " + qd3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(OD3 od3, Throwable th) {
        AbstractC13042fc3.i(od3, "this$0");
        od3.i.d();
        return C19938rB7.a;
    }

    @Override // ir.nasim.LD3, ir.nasim.InterfaceC25225zw4
    public C6517Nv5 a(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (!C8386Vt0.w7()) {
            return null;
        }
        if (abstractC20556sC7 instanceof C24820zF7) {
            SC3 sc3A = ((C24820zF7) abstractC20556sC7).a();
            if (sc3A != null) {
                GJ0.b(this.j.h(new QD3.b((FD3) this.g.a(sc3A))));
            }
            return C6517Nv5.l0(C14505i18.a);
        }
        if (!(abstractC20556sC7 instanceof C20565sD7)) {
            return null;
        }
        SC3 sc3A2 = ((C20565sD7) abstractC20556sC7).a();
        if (sc3A2 != null) {
            GJ0.b(this.j.h(new QD3.a((FD3) this.g.a(sc3A2))));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    @Override // ir.nasim.LD3
    public void k() {
        C19406qI3.a("LiveStreamRepoImpl", "onTooLong Happening", new Object[0]);
        if (this.i.c()) {
            return;
        }
        AbstractC10533bm0.d(this.e, this.f, null, new g(null), 2, null).s(new UA2() { // from class: ir.nasim.ND3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return OD3.u(this.a, (Throwable) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.LD3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object l(long r7, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ir.nasim.OD3.c
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.OD3$c r0 = (ir.nasim.OD3.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.OD3$c r0 = new ir.nasim.OD3$c
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.a
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            ir.nasim.AbstractC10685c16.b(r9)
            goto L7f
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            long r7 = r0.b
            java.lang.Object r2 = r0.a
            ir.nasim.OD3 r2 = (ir.nasim.OD3) r2
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r9 = r9.l()
            goto L5b
        L48:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.qN5 r9 = r6.b
            r0.a = r6
            r0.b = r7
            r0.e = r4
            java.lang.Object r9 = r9.a(r7, r0)
            if (r9 != r1) goto L5a
            return r1
        L5a:
            r2 = r6
        L5b:
            ir.nasim.a16 r9 = ir.nasim.C9475a16.a(r9)
            java.lang.Object r4 = r9.l()
            java.lang.Throwable r5 = ir.nasim.C9475a16.e(r4)
            if (r5 != 0) goto L81
            ir.nasim.FD3 r4 = (ir.nasim.FD3) r4
            boolean r7 = r4.f()
            if (r7 == 0) goto Lab
            ir.nasim.WG3 r7 = r2.a
            r0.a = r9
            r0.e = r3
            java.lang.Object r7 = r7.c(r4, r0)
            if (r7 != r1) goto L7e
            return r1
        L7e:
            r7 = r9
        L7f:
            r9 = r7
            goto Lab
        L81:
            java.lang.Long r7 = ir.nasim.AbstractC6392Nk0.e(r7)
            int r7 = ir.nasim.AbstractC24249yI3.a(r7)
            java.lang.String r8 = r5.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "fetchByKey: ByKey(masked)="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = ", error="
            r0.append(r7)
            r0.append(r8)
            java.lang.String r7 = r0.toString()
            java.lang.String r8 = "LiveStreamRepoImpl"
            ir.nasim.C19406qI3.b(r8, r7)
        Lab:
            java.lang.Object r7 = r9.l()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OD3.l(long, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.LD3
    public InterfaceC10258bL6 m() {
        return this.k;
    }

    public final InterfaceC13730gj3 q() {
        return AbstractC10533bm0.d(this.e, this.f, null, new e(null), 2, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OD3(WG3 wg3, C19453qN5 c19453qN5, E84 e84, KM2 km2, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(wg3, "localDataSource");
        AbstractC13042fc3.i(c19453qN5, "remoteDataSource");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC14123hO3, "newLiveInfoToLiveStreamDataMapper");
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.i);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        this(wg3, c19453qN5, e84, km2, interfaceC20315ro1, abstractC13778go1, interfaceC14123hO3, interfaceC3570Bk5Q, true);
    }
}
