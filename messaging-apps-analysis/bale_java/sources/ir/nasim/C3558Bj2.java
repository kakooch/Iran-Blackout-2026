package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Bj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3558Bj2 {
    private final InterfaceC15500jh2 a;
    private final C21544tj2 b;
    private final C6613Og2 c;
    private final UG7 d;
    private final SF3 e;
    private final D44 f;
    private final C10299bQ2 g;
    private final OK7 h;
    private final C14930ij2 i;
    private final ir.nasim.jaryan.feed.model.db.a j;
    private final C22422vC6 k;
    private final C22704vh2 l;
    private final AbstractC13778go1 m;
    private final Context n;
    private final C14970in2 o;
    private Map p;

    /* renamed from: ir.nasim.Bj2$a */
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
            return C3558Bj2.this.f(null, this);
        }
    }

    /* renamed from: ir.nasim.Bj2$b */
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
            return C3558Bj2.this.m(this);
        }
    }

    /* renamed from: ir.nasim.Bj2$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C3558Bj2.this.n(0, 0L, 0L, this);
        }
    }

    /* renamed from: ir.nasim.Bj2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3558Bj2.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5U0 = C3558Bj2.this.d.u0(this.d, AbstractC10360bX0.m(), false, true);
                AbstractC13042fc3.h(c6517Nv5U0, "loadRequiredPeers(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5U0, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            return C9475a16.a(objD);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bj2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3558Bj2.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5G = C3558Bj2.this.h.p0().g(this.d);
                AbstractC13042fc3.h(c6517Nv5G, "getValues(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5G, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            AbstractC10685c16.b(objD);
            return objD;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bj2$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C3558Bj2.this.o(null, 0L, null, this);
        }
    }

    /* renamed from: ir.nasim.Bj2$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C3558Bj2.this.p(null, this);
        }
    }

    public C3558Bj2(InterfaceC15500jh2 interfaceC15500jh2, C21544tj2 c21544tj2, C6613Og2 c6613Og2, UG7 ug7, SF3 sf3, D44 d44, C10299bQ2 c10299bQ2, OK7 ok7, C14930ij2 c14930ij2, ir.nasim.jaryan.feed.model.db.a aVar, C22422vC6 c22422vC6, C22704vh2 c22704vh2, AbstractC13778go1 abstractC13778go1, Context context, C14970in2 c14970in2) {
        AbstractC13042fc3.i(interfaceC15500jh2, "feedDao");
        AbstractC13042fc3.i(c21544tj2, "feedPreference");
        AbstractC13042fc3.i(c6613Og2, "feedApiService");
        AbstractC13042fc3.i(ug7, "updates");
        AbstractC13042fc3.i(sf3, "loadFeedRequiredGroupsUseCase");
        AbstractC13042fc3.i(d44, "mergeFeedReactionsUseCase");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c14930ij2, "feedMapper");
        AbstractC13042fc3.i(aVar, "feedEntityMapper");
        AbstractC13042fc3.i(c22422vC6, "similarPostFeedEntityMapper");
        AbstractC13042fc3.i(c22704vh2, "feedEntityToFeedUiMapper");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.a = interfaceC15500jh2;
        this.b = c21544tj2;
        this.c = c6613Og2;
        this.d = ug7;
        this.e = sf3;
        this.f = d44;
        this.g = c10299bQ2;
        this.h = ok7;
        this.i = c14930ij2;
        this.j = aVar;
        this.k = c22422vC6;
        this.l = c22704vh2;
        this.m = abstractC13778go1;
        this.n = context;
        this.o = c14970in2;
        this.p = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 h(C3558Bj2 c3558Bj2, int i) {
        AbstractC13042fc3.i(c3558Bj2, "this$0");
        return new C20266rj2(c3558Bj2.c, c3558Bj2.e, c3558Bj2.l, c3558Bj2.j, c3558Bj2.a, c3558Bj2.b, c3558Bj2.m, c3558Bj2.n, i, c3558Bj2.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 j(C3558Bj2 c3558Bj2, C8755Xe4 c8755Xe4) {
        AbstractC13042fc3.i(c3558Bj2, "this$0");
        AbstractC13042fc3.i(c8755Xe4, "$mid");
        return new C23018wC6(c8755Xe4, new C22704vh2(c3558Bj2.i, c3558Bj2.g, c3558Bj2.f, c3558Bj2.e), c3558Bj2.b, c3558Bj2.c, c3558Bj2.a, c3558Bj2.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 l(C3558Bj2 c3558Bj2, boolean z, int i, long j, long j2) {
        AbstractC13042fc3.i(c3558Bj2, "this$0");
        return new C21725u17(c3558Bj2.c, c3558Bj2.d, c3558Bj2.h, z, i, j, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.C8755Xe4 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C3558Bj2.a
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.Bj2$a r0 = (ir.nasim.C3558Bj2.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Bj2$a r0 = new ir.nasim.Bj2$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.b
            java.lang.Object r7 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r0.d
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 == r2) goto L34
            if (r1 != r8) goto L2c
            ir.nasim.AbstractC10685c16.b(r11)
            goto L6c
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            java.lang.Object r10 = r0.a
            ir.nasim.Bj2 r10 = (ir.nasim.C3558Bj2) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L58
        L3c:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.jh2 r1 = r9.a
            long r3 = r10.i()
            long r10 = r10.h()
            r0.a = r9
            r0.d = r2
            r2 = r3
            r4 = r10
            r6 = r0
            java.lang.Object r11 = r1.b(r2, r4, r6)
            if (r11 != r7) goto L57
            return r7
        L57:
            r10 = r9
        L58:
            ir.nasim.uh2 r11 = (ir.nasim.C22114uh2) r11
            ir.nasim.vh2 r10 = r10.l
            java.util.List r11 = ir.nasim.ZW0.e(r11)
            r1 = 0
            r0.a = r1
            r0.d = r8
            java.lang.Object r11 = r10.a(r11, r0)
            if (r11 != r7) goto L6c
            return r7
        L6c:
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r10 = ir.nasim.ZW0.q0(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3558Bj2.f(ir.nasim.Xe4, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC4557Fq2 g(final int i) {
        return new C12960fT4(new MT4(20, 0, false, 20, 0, 0, 50, null), 0, new SA2() { // from class: ir.nasim.zj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3558Bj2.h(this.a, i);
            }
        }).a();
    }

    public final InterfaceC4557Fq2 i(final C8755Xe4 c8755Xe4) {
        AbstractC13042fc3.i(c8755Xe4, "mid");
        return new C12960fT4(new MT4(20, 0, false, 20, 0, 0, 50, null), 0, new SA2() { // from class: ir.nasim.yj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3558Bj2.j(this.a, c8755Xe4);
            }
        }).a();
    }

    public final InterfaceC4557Fq2 k(final boolean z, final int i, final long j, final long j2) {
        return new C12960fT4(new MT4(10, 0, false, 10, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Aj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3558Bj2.l(this.a, z, i, j, j2);
            }
        }, 2, null).a();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.C3558Bj2.b
            if (r0 == 0) goto L14
            r0 = r8
            ir.nasim.Bj2$b r0 = (ir.nasim.C3558Bj2.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            ir.nasim.Bj2$b r0 = new ir.nasim.Bj2$b
            r0.<init>(r8)
            goto L12
        L1a:
            java.lang.Object r8 = r4.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r4.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L33:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.Og2 r1 = r7.c
            r4.c = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r8 = ir.nasim.C6613Og2.b(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L45
            return r0
        L45:
            ir.nasim.Z06 r8 = (ir.nasim.Z06) r8
            boolean r0 = r8 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L50
            java.util.List r8 = ir.nasim.ZW0.m()
            goto Lb0
        L50:
            boolean r0 = r8 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto Lb1
            ir.nasim.Z06$b r8 = (ir.nasim.Z06.b) r8
            com.google.protobuf.P r8 = r8.a()
            ai.bale.proto.MagazineOuterClass$ResponseLoadCategories r8 = (ai.bale.proto.MagazineOuterClass$ResponseLoadCategories) r8
            java.util.List r8 = r8.getCategoriesOrBuilderList()
            java.lang.String r0 = "getCategoriesOrBuilderList(...)"
            ir.nasim.AbstractC13042fc3.h(r8, r0)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r8, r1)
            r0.<init>(r1)
            java.util.Iterator r8 = r8.iterator()
        L76:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto Laf
            java.lang.Object r1 = r8.next()
            ir.nasim.vM3 r1 = (ir.nasim.InterfaceC22509vM3) r1
            ir.nasim.Yg2 r2 = new ir.nasim.Yg2
            int r3 = r1.getCategoryId()
            ai.bale.proto.CollectionsStruct$MultiLanguageTag r4 = r1.getName()
            ai.bale.proto.CollectionsStruct$StringValue r4 = r4.getFa()
            java.lang.String r4 = r4.getText()
            java.lang.String r5 = "getText(...)"
            ir.nasim.AbstractC13042fc3.h(r4, r5)
            ai.bale.proto.CollectionsStruct$MultiLanguageTag r1 = r1.getName()
            ai.bale.proto.CollectionsStruct$StringValue r1 = r1.getEn()
            java.lang.String r1 = r1.getText()
            ir.nasim.AbstractC13042fc3.h(r1, r5)
            r2.<init>(r3, r4, r1)
            r0.add(r2)
            goto L76
        Laf:
            r8 = r0
        Lb0:
            return r8
        Lb1:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3558Bj2.m(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0100 A[LOOP:0: B:43:0x00fa->B:45:0x0100, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0128 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(int r16, long r17, long r19, ir.nasim.InterfaceC20295rm1 r21) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3558Bj2.n(int, long, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(ir.nasim.C11458d25 r20, long r21, ir.nasim.C8755Xe4 r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3558Bj2.o(ir.nasim.d25, long, ir.nasim.Xe4, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(ir.nasim.C8755Xe4 r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3558Bj2.p(ir.nasim.Xe4, ir.nasim.rm1):java.lang.Object");
    }
}
