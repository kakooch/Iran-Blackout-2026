package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C6236Mt2;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.WF6;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Mt2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6236Mt2 extends VW7 {
    private final InterfaceC24010xt2 b;
    private final SettingsModule c;
    private final InterfaceC9336Zm4 d;
    private final InterfaceC10258bL6 e;
    private final InterfaceC9336Zm4 f;
    private final InterfaceC10258bL6 g;
    private final InterfaceC5058Hs2 h;

    /* renamed from: ir.nasim.Mt2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6236Mt2.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objM;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC24010xt2 interfaceC24010xt2 = C6236Mt2.this.b;
                int i2 = this.d;
                this.b = 1;
                objM = interfaceC24010xt2.m(i2, this);
                if (objM == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objM = ((C9475a16) obj).l();
            }
            C6236Mt2 c6236Mt2 = C6236Mt2.this;
            Throwable thE = C9475a16.e(objM);
            if (thE != null) {
                c6236Mt2.X0(thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mt2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6236Mt2.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C6236Mt2.this.b1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mt2$c */
    public static final class c implements InterfaceC5058Hs2 {
        private final UA2 a;
        private final UA2 b;
        private final SA2 c;
        private final UA2 d;

        c(final C6236Mt2 c6236Mt2) {
            this.a = new UA2() { // from class: ir.nasim.Nt2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C6236Mt2.c.i(c6236Mt2, ((Integer) obj).intValue());
                }
            };
            this.b = new UA2() { // from class: ir.nasim.Ot2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C6236Mt2.c.k(c6236Mt2, ((Integer) obj).intValue());
                }
            };
            this.c = new SA2() { // from class: ir.nasim.Pt2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C6236Mt2.c.j(c6236Mt2);
                }
            };
            this.d = new UA2() { // from class: ir.nasim.Qt2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C6236Mt2.c.l(c6236Mt2, (List) obj);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C6236Mt2 c6236Mt2, int i) {
            AbstractC13042fc3.i(c6236Mt2, "this$0");
            c6236Mt2.c1(i);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 j(C6236Mt2 c6236Mt2) {
            AbstractC13042fc3.i(c6236Mt2, "this$0");
            c6236Mt2.e1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C6236Mt2 c6236Mt2, int i) {
            AbstractC13042fc3.i(c6236Mt2, "this$0");
            c6236Mt2.d1(i);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 l(C6236Mt2 c6236Mt2, List list) {
            AbstractC13042fc3.i(c6236Mt2, "this$0");
            AbstractC13042fc3.i(list, "foldersList");
            c6236Mt2.f1(list);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC5058Hs2
        public SA2 a() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC5058Hs2
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC5058Hs2
        public UA2 c() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC5058Hs2
        public UA2 d() {
            return this.d;
        }
    }

    /* renamed from: ir.nasim.Mt2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Mt2$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C6236Mt2 a;

            a(C6236Mt2 c6236Mt2) {
                this.a = c6236Mt2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.d.setValue(list);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Mt2$d$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Mt2$d$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Mt2$d$b$a$a, reason: collision with other inner class name */
                public static final class C0521a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0521a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r9, ir.nasim.InterfaceC20295rm1 r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof ir.nasim.C6236Mt2.d.b.a.C0521a
                        if (r0 == 0) goto L13
                        r0 = r10
                        ir.nasim.Mt2$d$b$a$a r0 = (ir.nasim.C6236Mt2.d.b.a.C0521a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Mt2$d$b$a$a r0 = new ir.nasim.Mt2$d$b$a$a
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        ir.nasim.AbstractC10685c16.b(r10)
                        goto La9
                    L2a:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L32:
                        ir.nasim.AbstractC10685c16.b(r10)
                        ir.nasim.Gq2 r10 = r8.a
                        java.util.List r9 = (java.util.List) r9
                        java.lang.Iterable r9 = (java.lang.Iterable) r9
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Iterator r9 = r9.iterator()
                    L44:
                        boolean r4 = r9.hasNext()
                        if (r4 == 0) goto L76
                        java.lang.Object r4 = r9.next()
                        r5 = r4
                        ir.nasim.Xr2 r5 = (ir.nasim.C8870Xr2) r5
                        r6 = 0
                        java.lang.Integer r6 = ir.nasim.AbstractC6392Nk0.d(r6)
                        r7 = 11
                        java.lang.Integer r7 = ir.nasim.AbstractC6392Nk0.d(r7)
                        java.lang.Integer[] r6 = new java.lang.Integer[]{r6, r7}
                        java.util.Set r6 = ir.nasim.AbstractC4129Du6.i(r6)
                        int r5 = r5.c()
                        java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
                        boolean r5 = r6.contains(r5)
                        if (r5 != 0) goto L44
                        r2.add(r4)
                        goto L44
                    L76:
                        java.util.ArrayList r9 = new java.util.ArrayList
                        r9.<init>()
                        java.util.Iterator r2 = r2.iterator()
                    L7f:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto La0
                        java.lang.Object r4 = r2.next()
                        r5 = r4
                        ir.nasim.Xr2 r5 = (ir.nasim.C8870Xr2) r5
                        ir.nasim.Vt0 r6 = ir.nasim.C8386Vt0.a
                        boolean r6 = r6.Pb()
                        if (r6 != 0) goto L9c
                        int r5 = r5.c()
                        r6 = 10
                        if (r5 == r6) goto L7f
                    L9c:
                        r9.add(r4)
                        goto L7f
                    La0:
                        r0.b = r3
                        java.lang.Object r9 = r10.a(r9, r0)
                        if (r9 != r1) goto La9
                        return r1
                    La9:
                        ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6236Mt2.d.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6236Mt2.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(C6236Mt2.this.b.o(true));
                a aVar = new a(C6236Mt2.this);
                this.b = 1;
                if (bVar.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mt2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6236Mt2.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objP;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6236Mt2.this.h1(this.d, true);
                InterfaceC24010xt2 interfaceC24010xt2 = C6236Mt2.this.b;
                int i2 = this.d;
                this.b = 1;
                objP = interfaceC24010xt2.p(i2, this);
                if (objP == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objP = ((C9475a16) obj).l();
            }
            C6236Mt2 c6236Mt2 = C6236Mt2.this;
            int i3 = this.d;
            Throwable thE = C9475a16.e(objP);
            if (thE != null) {
                c6236Mt2.X0(thE);
                c6236Mt2.h1(i3, false);
            }
            C6236Mt2 c6236Mt22 = C6236Mt2.this;
            int i4 = this.d;
            if (C9475a16.j(objP)) {
                c6236Mt22.h1(i4, false);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mt2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6236Mt2.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objF;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC24010xt2 interfaceC24010xt2 = C6236Mt2.this.b;
                List list = this.d;
                this.b = 1;
                objF = interfaceC24010xt2.f(list, this);
                if (objF == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objF = ((C9475a16) obj).l();
            }
            C6236Mt2 c6236Mt2 = C6236Mt2.this;
            Throwable thE = C9475a16.e(objF);
            if (thE != null) {
                c6236Mt2.X0(thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6236Mt2(InterfaceC24010xt2 interfaceC24010xt2, SettingsModule settingsModule) {
        AbstractC13042fc3.i(interfaceC24010xt2, "foldersRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = interfaceC24010xt2;
        this.c = settingsModule;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.d = interfaceC9336Zm4A;
        this.e = AbstractC6459Nq2.o0(AbstractC6459Nq2.c0(interfaceC9336Zm4A, new b(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), AbstractC10360bX0.m());
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(null);
        this.f = interfaceC9336Zm4A2;
        this.g = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
        this.h = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(Throwable th) {
        Object value;
        String message;
        Object value2;
        Object value3;
        if (!(th instanceof RpcException)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
            do {
                value = interfaceC9336Zm4.getValue();
                message = th.getMessage();
                if (message == null) {
                    message = "EXCEPTION";
                }
            } while (!interfaceC9336Zm4.f(value, new WF6.b(message)));
            return;
        }
        RpcException rpcException = (RpcException) th;
        if (AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "TIMEOUT")) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.f;
            do {
                value3 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value3, WF6.f.a));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm43 = this.f;
        do {
            value2 = interfaceC9336Zm43.getValue();
        } while (!interfaceC9336Zm43.f(value2, new WF6.b(rpcException.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(int i, boolean z) {
        Object value;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
            List<C8870Xr2> list = (List) value;
            arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (C8870Xr2 c8870Xr2B : list) {
                if (c8870Xr2B.c() == i) {
                    c8870Xr2B = C8870Xr2.b(c8870Xr2B, 0, null, false, false, z, false, 47, null);
                }
                arrayList.add(c8870Xr2B);
            }
        } while (!interfaceC9336Zm4.f(value, arrayList));
    }

    private final void i1(WF6 wf6) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, wf6));
    }

    public final boolean V0(int i) {
        if (i < this.c.Z1()) {
            return true;
        }
        i1(new WF6.d(this.c.Z1()));
        return false;
    }

    public final void W0(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(i, null), 3, null);
    }

    public final InterfaceC10258bL6 Y0() {
        return this.e;
    }

    public final InterfaceC5058Hs2 Z0() {
        return this.h;
    }

    public final InterfaceC10258bL6 a1() {
        return this.g;
    }

    public final void c1(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(i, null), 3, null);
    }

    public final void d1(int i) {
        Object value;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
            List<C8870Xr2> list = (List) value;
            arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (C8870Xr2 c8870Xr2 : list) {
                arrayList.add(C8870Xr2.b(c8870Xr2, 0, null, false, false, false, c8870Xr2.c() == i, 31, null));
            }
        } while (!interfaceC9336Zm4.f(value, arrayList));
    }

    public final void e1() {
        Object value;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
            List list = (List) value;
            arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(C8870Xr2.b((C8870Xr2) it.next(), 0, null, false, false, false, false, 31, null));
            }
        } while (!interfaceC9336Zm4.f(value, arrayList));
    }

    public final void f1(List list) {
        AbstractC13042fc3.i(list, "folderIdsList");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(list, null), 3, null);
    }

    public final void g1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final void j1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, WF6.e.a));
    }

    public final void k1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, WF6.c.a));
    }
}
