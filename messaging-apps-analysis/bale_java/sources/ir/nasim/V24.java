package ir.nasim;

import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.SearchOuterClass$ResponseSearchMembers;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import ir.nasim.Z06;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class V24 {
    public static final a p = new a(null);
    public static final int q = 8;
    private final C10299bQ2 a;
    private final InterfaceC23694xM2 b;
    private final C8054Ui1 c;
    private final OK7 d;
    private final C6287Mz e;
    private final AbstractC13778go1 f;
    private final List g;
    private final List h;
    private final List i;
    private final List j;
    private final List k;
    private final HashMap l;
    private InterfaceC8327Vm4 m;
    private InterfaceC10040ay6 n;
    private final InterfaceC9173Yu3 o;

    public static final class a {
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
            return V24.this.l(null, this);
        }
    }

    static final class c implements GB3 {
        final /* synthetic */ HE0 a;

        c(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.GB3
        public final void a(List list, long j, long j2) {
            HE0 he0 = this.a;
            AbstractC13042fc3.f(list);
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(((C3512Be1) it.next()).r()).a());
            }
            AbstractC24549yo1.c(he0, arrayList);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        /* synthetic */ Object h;
        int j;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RecyclerView.UNDEFINED_DURATION;
            return V24.this.m(0, null, 0, this);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ BytesValue e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, BytesValue bytesValue, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = bytesValue;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return V24.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5W1 = V24.this.a.W1(this.d, this.e, 50);
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5W1, null, this, 1, null);
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

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
            return V24.this.n(null, null, 0, this);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ int f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            int d;
            int e;
            private /* synthetic */ Object f;
            final /* synthetic */ V24 g;
            final /* synthetic */ Z06 h;
            final /* synthetic */ int i;

            /* renamed from: ir.nasim.V24$g$a$a, reason: collision with other inner class name */
            static final class C0694a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ V24 c;
                final /* synthetic */ Z06 d;
                final /* synthetic */ HE0 e;
                final /* synthetic */ int f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0694a(V24 v24, Z06 z06, HE0 he0, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = v24;
                    this.d = z06;
                    this.e = he0;
                    this.f = i;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0694a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        V24 v24 = this.c;
                        com.google.protobuf.P pA = ((Z06.b) this.d).a();
                        AbstractC13042fc3.h(pA, "<get-data>(...)");
                        HE0 he0 = this.e;
                        int i2 = this.f;
                        this.b = 1;
                        if (v24.n((SearchOuterClass$ResponseSearchMembers) pA, he0, i2, this) == objE) {
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
                    return ((C0694a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(V24 v24, Z06 z06, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.g = v24;
                this.h = z06;
                this.i = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.g, this.h, this.i, interfaceC20295rm1);
                aVar.f = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.e;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                    V24 v24 = this.g;
                    Z06 z06 = this.h;
                    int i2 = this.i;
                    this.f = interfaceC20315ro1;
                    this.b = v24;
                    this.c = z06;
                    this.d = i2;
                    this.e = 1;
                    IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                    ie0.w();
                    AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C0694a(v24, z06, ie0, i2, null), 3, null);
                    obj = ie0.t();
                    if (obj == AbstractC14862ic3.e()) {
                        WA1.c(this);
                    }
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, C11458d25 c11458d25, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = c11458d25;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return V24.this.new g(this.d, this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d6  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L23
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                ir.nasim.AbstractC10685c16.b(r13)
                goto Ld3
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1e:
                ir.nasim.AbstractC10685c16.b(r13)
                goto Lb6
            L23:
                ir.nasim.AbstractC10685c16.b(r13)
                goto L37
            L27:
                ir.nasim.AbstractC10685c16.b(r13)
                ir.nasim.V24 r13 = ir.nasim.V24.this
                java.lang.String r1 = r12.d
                r12.b = r4
                java.lang.Object r13 = ir.nasim.V24.f(r13, r1, r12)
                if (r13 != r0) goto L37
                return r0
            L37:
                java.util.List r13 = (java.util.List) r13
                ir.nasim.vx5 r5 = new ir.nasim.vx5
                ai.bale.proto.SearchOuterClass$RequestSearchMembers$a r1 = ai.bale.proto.SearchOuterClass$RequestSearchMembers.newBuilder()
                ai.bale.proto.SearchStruct$SearchPieceText$a r4 = ai.bale.proto.SearchStruct$SearchPieceText.newBuilder()
                java.lang.String r6 = r12.d
                ai.bale.proto.SearchStruct$SearchPieceText$a r4 = r4.A(r6)
                com.google.protobuf.GeneratedMessageLite r4 = r4.a()
                ai.bale.proto.SearchStruct$SearchPieceText r4 = (ai.bale.proto.SearchStruct$SearchPieceText) r4
                ai.bale.proto.SearchOuterClass$RequestSearchMembers$a r1 = r1.C(r4)
                ai.bale.proto.PeersStruct$ExPeer$a r4 = ai.bale.proto.PeersStruct$ExPeer.newBuilder()
                ir.nasim.d25 r6 = r12.e
                int r6 = r6.getPeerId()
                ai.bale.proto.PeersStruct$ExPeer$a r4 = r4.B(r6)
                ir.nasim.d25 r6 = r12.e
                ir.nasim.W25 r6 = r6.s()
                ir.nasim.W25 r7 = ir.nasim.W25.b
                if (r6 != r7) goto L6e
                ir.nasim.b35 r6 = ir.nasim.EnumC10088b35.ExPeerType_GROUP
                goto L70
            L6e:
                ir.nasim.b35 r6 = ir.nasim.EnumC10088b35.ExPeerType_CHANNEL
            L70:
                ai.bale.proto.PeersStruct$ExPeer$a r4 = r4.C(r6)
                r6 = 0
                ai.bale.proto.PeersStruct$ExPeer$a r4 = r4.A(r6)
                com.google.protobuf.GeneratedMessageLite r4 = r4.a()
                ai.bale.proto.PeersStruct$ExPeer r4 = (ai.bale.proto.PeersStruct$ExPeer) r4
                ai.bale.proto.SearchOuterClass$RequestSearchMembers$a r1 = r1.B(r4)
                java.lang.Iterable r13 = (java.lang.Iterable) r13
                ai.bale.proto.SearchOuterClass$RequestSearchMembers$a r13 = r1.A(r13)
                com.google.protobuf.GeneratedMessageLite r13 = r13.a()
                java.lang.String r1 = "build(...)"
                ir.nasim.AbstractC13042fc3.h(r13, r1)
                ai.bale.proto.SearchOuterClass$ResponseSearchMembers r1 = ai.bale.proto.SearchOuterClass$ResponseSearchMembers.getDefaultInstance()
                java.lang.String r4 = "getDefaultInstance(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r4)
                java.lang.String r4 = "/bale.search.v1.Search/SearchMembers"
                r5.<init>(r4, r13, r1)
                ir.nasim.V24 r13 = ir.nasim.V24.this
                ir.nasim.Mz r4 = ir.nasim.V24.c(r13)
                r12.b = r3
                r6 = 16500(0x4074, double:8.152E-320)
                r8 = 0
                r10 = 4
                r11 = 0
                r9 = r12
                java.lang.Object r13 = ir.nasim.InterfaceC16847ly.c(r4, r5, r6, r8, r9, r10, r11)
                if (r13 != r0) goto Lb6
                return r0
            Lb6:
                ir.nasim.Z06 r13 = (ir.nasim.Z06) r13
                boolean r1 = r13 instanceof ir.nasim.Z06.b
                if (r1 == 0) goto Ld6
                ir.nasim.WM3 r1 = ir.nasim.C12366eV1.c()
                ir.nasim.V24$g$a r3 = new ir.nasim.V24$g$a
                ir.nasim.V24 r4 = ir.nasim.V24.this
                int r5 = r12.f
                r6 = 0
                r3.<init>(r4, r13, r5, r6)
                r12.b = r2
                java.lang.Object r13 = ir.nasim.AbstractC9323Zl0.g(r1, r3, r12)
                if (r13 != r0) goto Ld3
                return r0
            Ld3:
                java.util.List r13 = (java.util.List) r13
                goto Lda
            Ld6:
                java.util.List r13 = ir.nasim.ZW0.m()
            Lda:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V24.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public V24(C10299bQ2 c10299bQ2, InterfaceC23694xM2 interfaceC23694xM2, C8054Ui1 c8054Ui1, OK7 ok7, C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(interfaceC23694xM2, "groupMemberToMemberMapperFactory");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c10299bQ2;
        this.b = interfaceC23694xM2;
        this.c = c8054Ui1;
        this.d = ok7;
        this.e = c6287Mz;
        this.f = abstractC13778go1;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new HashMap();
        InterfaceC8327Vm4 interfaceC8327Vm4A = AbstractC11420cy6.a(0, 1, EnumC6162Ml0.DROP_OLDEST);
        this.m = interfaceC8327Vm4A;
        this.n = interfaceC8327Vm4A;
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.T24
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return V24.k(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WK i() {
        return (WK) this.o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK k(V24 v24) {
        AbstractC13042fc3.i(v24, "this$0");
        DB3 db3M0 = v24.c.m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.V24.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.V24$b r0 = (ir.nasim.V24.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.V24$b r0 = new ir.nasim.V24$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.a
            ir.nasim.V24 r6 = (ir.nasim.V24) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L6c
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.a = r5
            r0.b = r6
            r0.e = r3
            ir.nasim.IE0 r7 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r7.<init>(r2, r3)
            r7.w()
            ir.nasim.WK r2 = e(r5)
            ir.nasim.V24$c r3 = new ir.nasim.V24$c
            r3.<init>(r7)
            r4 = 40
            r2.q(r6, r4, r3)
            java.lang.Object r7 = r7.t()
            java.lang.Object r6 = ir.nasim.AbstractC13660gc3.e()
            if (r7 != r6) goto L69
            ir.nasim.WA1.c(r0)
        L69:
            if (r7 != r1) goto L6c
            return r1
        L6c:
            java.util.List r7 = (java.util.List) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V24.l(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(final ai.bale.proto.SearchOuterClass$ResponseSearchMembers r25, ir.nasim.HE0 r26, int r27, ir.nasim.InterfaceC20295rm1 r28) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V24.n(ai.bale.proto.SearchOuterClass$ResponseSearchMembers, ir.nasim.HE0, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 o(V24 v24, SearchOuterClass$ResponseSearchMembers searchOuterClass$ResponseSearchMembers, C14505i18 c14505i18) {
        AbstractC13042fc3.i(v24, "this$0");
        AbstractC13042fc3.i(searchOuterClass$ResponseSearchMembers, "$members");
        InterfaceC8344Vo3 interfaceC8344Vo3P0 = v24.d.p0();
        List<PeersStruct$UserOutPeer> usersList = searchOuterClass$ResponseSearchMembers.getUsersList();
        AbstractC13042fc3.h(usersList, "getUsersList(...)");
        List<PeersStruct$UserOutPeer> list = usersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((PeersStruct$UserOutPeer) it.next()).getUid()));
        }
        return interfaceC8344Vo3P0.g(arrayList);
    }

    public final Object h(InterfaceC20295rm1 interfaceC20295rm1) {
        this.i.clear();
        this.j.clear();
        this.k.clear();
        this.h.clear();
        this.g.clear();
        this.l.clear();
        Object objA = this.m.a(AbstractC6392Nk0.a(true), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    public final InterfaceC10040ay6 j() {
        return this.n;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01c9 -> B:50:0x01ca). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(int r19, com.google.protobuf.BytesValue r20, int r21, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V24.m(int, com.google.protobuf.BytesValue, int, ir.nasim.rm1):java.lang.Object");
    }

    public final Object p(C11458d25 c11458d25, String str, int i, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.f, new g(str, c11458d25, i, null), interfaceC20295rm1);
    }
}
