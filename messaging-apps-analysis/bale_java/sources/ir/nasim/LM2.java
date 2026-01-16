package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.LM2;
import java.util.List;

/* loaded from: classes5.dex */
public final class LM2 implements KM2 {
    public static final a d = new a(null);
    private final AbstractC13778go1 a;
    private final C10299bQ2 b;
    private final C6287Mz c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

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
            Object objJ = LM2.this.j(0, null, this);
            return objJ == AbstractC14862ic3.e() ? objJ : C9475a16.a(objJ);
        }
    }

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
            Object objG = LM2.this.g(null, this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
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
            Object objI = LM2.this.i(0, this);
            return objI == AbstractC14862ic3.e() ? objI : C9475a16.a(objI);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(C19482qQ7 c19482qQ7, InterfaceC14756iQ7 interfaceC14756iQ7) {
            c19482qQ7.h(interfaceC14756iQ7);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(InterfaceC16204ks5 interfaceC16204ks5, List list, AbstractC13554gQ7 abstractC13554gQ7) {
            if (list != null) {
                interfaceC16204ks5.h(C9475a16.a(C9475a16.b(list)));
            }
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = LM2.this.new e(this.e, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            final InterfaceC16204ks5 interfaceC16204ks5;
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                C6517Nv5 c6517Nv5K = LM2.this.b.Y1().k(this.e);
                AbstractC13042fc3.h(c6517Nv5K, "get(...)");
                this.c = interfaceC16204ks5;
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5K, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            if (C9475a16.g(objD)) {
                Throwable thE = C9475a16.e(objD);
                if (thE == null) {
                    throw new Exception();
                }
                throw thE;
            }
            if (C9475a16.g(objD)) {
                objD = null;
            }
            C14733iO2 c14733iO2 = (C14733iO2) objD;
            c14733iO2.getClass();
            interfaceC16204ks5.h(C9475a16.a(C9475a16.b(c14733iO2.i().b())));
            final InterfaceC14756iQ7 interfaceC14756iQ7 = new InterfaceC14756iQ7() { // from class: ir.nasim.MM2
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj2, AbstractC13554gQ7 abstractC13554gQ7) {
                    LM2.e.z(interfaceC16204ks5, (List) obj2, abstractC13554gQ7);
                }
            };
            final C19482qQ7 c19482qQ7I = c14733iO2.i();
            c19482qQ7I.f(interfaceC14756iQ7);
            AbstractC13042fc3.h(c19482qQ7I, "also(...)");
            SA2 sa2 = new SA2() { // from class: ir.nasim.NM2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return LM2.e.D(c19482qQ7I, interfaceC14756iQ7);
                }
            };
            this.c = null;
            this.b = 2;
            if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                Throwable th = (Throwable) this.d;
                C9475a16.a aVar = C9475a16.b;
                C9475a16 c9475a16A = C9475a16.a(C9475a16.b(AbstractC10685c16.a(th)));
                this.c = null;
                this.b = 1;
                if (interfaceC4806Gq2.a(c9475a16A, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(interfaceC20295rm1);
            fVar.c = interfaceC4806Gq2;
            fVar.d = th;
            return fVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return LM2.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return LM2.this.b.Y1().n(this.d);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objC = LM2.this.c(0, false, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    static final class i extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objK = LM2.this.k(null, this);
            return objK == AbstractC14862ic3.e() ? objK : C9475a16.a(objK);
        }
    }

    static final class j extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = LM2.this.a(this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    static final class k extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = LM2.this.f(0, 0, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    public LM2(AbstractC13778go1 abstractC13778go1, C10299bQ2 c10299bQ2, C6287Mz c6287Mz) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = abstractC13778go1;
        this.b = c10299bQ2;
        this.c = c6287Mz;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.KM2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ir.nasim.LM2.j
            if (r0 == 0) goto L14
            r0 = r10
            ir.nasim.LM2$j r0 = (ir.nasim.LM2.j) r0
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
            ir.nasim.LM2$j r0 = new ir.nasim.LM2$j
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r10)
            goto L88
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.Mz r1 = r9.c
            ir.nasim.vx5 r10 = new ir.nasim.vx5
            ai.bale.proto.GroupsOuterClass$RequestGetMyGroups$a r3 = ai.bale.proto.GroupsOuterClass$RequestGetMyGroups.newBuilder()
            ai.bale.proto.GroupsStruct$GetMyGroupsFilter$a r4 = ai.bale.proto.GroupsStruct$GetMyGroupsFilter.newBuilder()
            ai.bale.proto.GroupsStruct$FilterOwner$a r5 = ai.bale.proto.GroupsStruct$FilterOwner.newBuilder()
            ai.bale.proto.GroupsStruct$FilterOwner$a r5 = r5.A(r2)
            com.google.protobuf.GeneratedMessageLite r5 = r5.a()
            ai.bale.proto.GroupsStruct$FilterOwner r5 = (ai.bale.proto.GroupsStruct$FilterOwner) r5
            ai.bale.proto.GroupsStruct$GetMyGroupsFilter$a r4 = r4.B(r5)
            com.google.protobuf.GeneratedMessageLite r4 = r4.a()
            java.util.List r4 = ir.nasim.ZW0.e(r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            ai.bale.proto.GroupsOuterClass$RequestGetMyGroups$a r3 = r3.A(r4)
            com.google.protobuf.GeneratedMessageLite r3 = r3.a()
            java.lang.String r4 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups r4 = ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups.getDefaultInstance()
            java.lang.String r5 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r4, r5)
            java.lang.String r5 = "/bale.groups.v1.Groups/GetMyGroups"
            r10.<init>(r5, r3, r4)
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r10
            java.lang.Object r10 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r10 != r0) goto L88
            return r0
        L88:
            ir.nasim.Z06 r10 = (ir.nasim.Z06) r10
            boolean r0 = r10 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L9f
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$a r10 = (ir.nasim.Z06.a) r10
            ir.nasim.core.network.RpcException r10 = r10.a()
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Le3
        L9f:
            boolean r0 = r10 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto Le4
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r10 = (ir.nasim.Z06.b) r10
            com.google.protobuf.P r10 = r10.a()
            ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups r10 = (ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups) r10
            java.util.List r10 = r10.getGroupsList()
            java.lang.String r0 = "getGroupsList(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r0)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r10, r1)
            r0.<init>(r1)
            java.util.Iterator r10 = r10.iterator()
        Lc7:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto Ldf
            java.lang.Object r1 = r10.next()
            ai.bale.proto.PeersStruct$GroupOutPeer r1 = (ai.bale.proto.PeersStruct$GroupOutPeer) r1
            int r1 = r1.getGroupId()
            java.lang.Integer r1 = ir.nasim.AbstractC6392Nk0.d(r1)
            r0.add(r1)
            goto Lc7
        Ldf:
            java.lang.Object r10 = ir.nasim.C9475a16.b(r0)
        Le3:
            return r10
        Le4:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LM2.a(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.KM2
    public C14697iL2 b(long j2) {
        return (C14697iL2) this.b.X1().d(j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.KM2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(int r5, boolean r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.LM2.h
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.LM2$h r0 = (ir.nasim.LM2.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.LM2$h r0 = new ir.nasim.LM2$h
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r5 = r7.l()
            goto L56
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.bQ2 r7 = r4.b
            java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
            java.lang.Integer[] r5 = new java.lang.Integer[]{r5}
            java.util.ArrayList r5 = ir.nasim.ZW0.g(r5)
            ir.nasim.Nv5 r5 = r7.B2(r5, r6)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L56
            return r1
        L56:
            boolean r6 = ir.nasim.C9475a16.j(r5)
            if (r6 == 0) goto L60
            ir.nasim.i18 r5 = (ir.nasim.C14505i18) r5
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
        L60:
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LM2.c(int, boolean, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.KM2
    public void d(C11458d25 c11458d25, List list) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "reactions");
        this.b.E3(c11458d25, list);
    }

    @Override // ir.nasim.KM2
    public InterfaceC4557Fq2 e(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.b.T1(c11458d25);
        return AbstractC6459Nq2.h(AbstractC6459Nq2.f(new e(c11458d25.getPeerId(), null)), new f(null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.KM2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(int r10, int r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof ir.nasim.LM2.k
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.LM2$k r0 = (ir.nasim.LM2.k) r0
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
            ir.nasim.LM2$k r0 = new ir.nasim.LM2$k
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            ir.nasim.AbstractC10685c16.b(r12)
            goto La7
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.Mz r1 = r9.c
            ir.nasim.vx5 r12 = new ir.nasim.vx5
            ai.bale.proto.GroupsOuterClass$RequestUnBanUser$b r3 = ai.bale.proto.GroupsOuterClass$RequestUnBanUser.newBuilder()
            ai.bale.proto.PeersStruct$GroupOutPeer$a r4 = ai.bale.proto.PeersStruct$GroupOutPeer.newBuilder()
            ai.bale.proto.PeersStruct$GroupOutPeer$a r11 = r4.B(r11)
            r4 = 0
            ai.bale.proto.PeersStruct$GroupOutPeer$a r11 = r11.A(r4)
            com.google.protobuf.GeneratedMessageLite r11 = r11.a()
            ai.bale.proto.PeersStruct$GroupOutPeer r11 = (ai.bale.proto.PeersStruct$GroupOutPeer) r11
            ai.bale.proto.GroupsOuterClass$RequestUnBanUser$b r11 = r3.B(r11)
            ai.bale.proto.PeersStruct$UserOutPeer$a r3 = ai.bale.proto.PeersStruct$UserOutPeer.newBuilder()
            ai.bale.proto.PeersStruct$UserOutPeer$a r10 = r3.B(r10)
            ai.bale.proto.PeersStruct$UserOutPeer$a r10 = r10.A(r4)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            ai.bale.proto.PeersStruct$UserOutPeer r10 = (ai.bale.proto.PeersStruct$UserOutPeer) r10
            ai.bale.proto.GroupsOuterClass$RequestUnBanUser$b r10 = r11.C(r10)
            ir.nasim.m35 r11 = ir.nasim.EnumC16902m35.UpdateOptimization_STRIP_ENTITIES
            ir.nasim.m35 r3 = ir.nasim.EnumC16902m35.UpdateOptimization_STRIP_COUNTERS
            ir.nasim.m35 r4 = ir.nasim.EnumC16902m35.UpdateOptimization_COMPACT_USERS
            ir.nasim.m35[] r11 = new ir.nasim.EnumC16902m35[]{r11, r3, r4}
            java.util.List r11 = ir.nasim.ZW0.p(r11)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            ai.bale.proto.GroupsOuterClass$RequestUnBanUser$b r10 = r10.A(r11)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r11 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            ai.bale.proto.GroupsOuterClass$ResponseUnBanUser r11 = ai.bale.proto.GroupsOuterClass$ResponseUnBanUser.getDefaultInstance()
            java.lang.String r3 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r3)
            java.lang.String r3 = "/bale.groups.v1.Groups/UnBanUser"
            r12.<init>(r3, r10, r11)
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r12
            java.lang.Object r12 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r12 != r0) goto La7
            return r0
        La7:
            ir.nasim.Z06 r12 = (ir.nasim.Z06) r12
            boolean r10 = r12 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto Lbe
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$a r12 = (ir.nasim.Z06.a) r12
            ir.nasim.core.network.RpcException r10 = r12.a()
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Lca
        Lbe:
            boolean r10 = r12 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto Lcb
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        Lca:
            return r10
        Lcb:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LM2.f(int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.KM2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(ir.nasim.ZN2 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.LM2.c
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.LM2$c r0 = (ir.nasim.LM2.c) r0
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
            ir.nasim.LM2$c r0 = new ir.nasim.LM2$c
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r11)
            goto L8c
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Mz r1 = r9.c
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            ai.bale.proto.GroupsOuterClass$RequestGetMyGroups$a r3 = ai.bale.proto.GroupsOuterClass$RequestGetMyGroups.newBuilder()
            ai.bale.proto.GroupsStruct$GetMyGroupsFilter$a r4 = ai.bale.proto.GroupsStruct$GetMyGroupsFilter.newBuilder()
            ai.bale.proto.GroupsStruct$FilterGroupType$a r5 = ai.bale.proto.GroupsStruct$FilterGroupType.newBuilder()
            ir.nasim.zS2 r10 = r10.p()
            ai.bale.proto.GroupsStruct$FilterGroupType$a r10 = r5.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            ai.bale.proto.GroupsStruct$FilterGroupType r10 = (ai.bale.proto.GroupsStruct$FilterGroupType) r10
            ai.bale.proto.GroupsStruct$GetMyGroupsFilter$a r10 = r4.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.util.List r10 = ir.nasim.ZW0.e(r10)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            ai.bale.proto.GroupsOuterClass$RequestGetMyGroups$a r10 = r3.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r3 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r3)
            ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups r3 = ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups.getDefaultInstance()
            java.lang.String r4 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            java.lang.String r4 = "/bale.groups.v1.Groups/GetMyGroups"
            r11.<init>(r4, r10, r3)
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r11
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L8c
            return r0
        L8c:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto La3
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Le7
        La3:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto Le8
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups r10 = (ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups) r10
            java.util.List r10 = r10.getGroupsList()
            java.lang.String r11 = "getGroupsList(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r0 = 10
            int r0 = ir.nasim.ZW0.x(r10, r0)
            r11.<init>(r0)
            java.util.Iterator r10 = r10.iterator()
        Lcb:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto Le3
            java.lang.Object r0 = r10.next()
            ai.bale.proto.PeersStruct$GroupOutPeer r0 = (ai.bale.proto.PeersStruct$GroupOutPeer) r0
            int r0 = r0.getGroupId()
            java.lang.Integer r0 = ir.nasim.AbstractC6392Nk0.d(r0)
            r11.add(r0)
            goto Lcb
        Le3:
            java.lang.Object r10 = ir.nasim.C9475a16.b(r11)
        Le7:
            return r10
        Le8:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LM2.g(ir.nasim.ZN2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.KM2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(int r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.LM2.d
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.LM2$d r0 = (ir.nasim.LM2.d) r0
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
            ir.nasim.LM2$d r0 = new ir.nasim.LM2$d
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r11)
            goto L7c
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Mz r1 = r9.c
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            ai.bale.proto.GroupsOuterClass$RequestGetBannedUsers$a r3 = ai.bale.proto.GroupsOuterClass$RequestGetBannedUsers.newBuilder()
            ai.bale.proto.PeersStruct$GroupOutPeer$a r4 = ai.bale.proto.PeersStruct$GroupOutPeer.newBuilder()
            ai.bale.proto.PeersStruct$GroupOutPeer$a r10 = r4.B(r10)
            r4 = 0
            ai.bale.proto.PeersStruct$GroupOutPeer$a r10 = r10.A(r4)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            ai.bale.proto.PeersStruct$GroupOutPeer r10 = (ai.bale.proto.PeersStruct$GroupOutPeer) r10
            ai.bale.proto.GroupsOuterClass$RequestGetBannedUsers$a r10 = r3.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r3 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r3)
            ai.bale.proto.GroupsOuterClass$ResponseGetBannedUsers r3 = ai.bale.proto.GroupsOuterClass$ResponseGetBannedUsers.getDefaultInstance()
            java.lang.String r4 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            java.lang.String r4 = "/bale.groups.v1.Groups/GetBannedUsers"
            r11.<init>(r4, r10, r3)
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r11
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L7c
            return r0
        L7c:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto L93
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Lec
        L93:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto Led
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.GroupsOuterClass$ResponseGetBannedUsers r10 = (ai.bale.proto.GroupsOuterClass$ResponseGetBannedUsers) r10
            java.util.List r10 = r10.getBannedUsersList()
            java.lang.String r11 = "getBannedUsersList(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r0 = 10
            int r0 = ir.nasim.ZW0.x(r10, r0)
            r11.<init>(r0)
            java.util.Iterator r10 = r10.iterator()
        Lbb:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto Le8
            java.lang.Object r0 = r10.next()
            ai.bale.proto.GroupsStruct$BannedUser r0 = (ai.bale.proto.GroupsStruct$BannedUser) r0
            ir.nasim.XV4 r1 = new ir.nasim.XV4
            ai.bale.proto.PeersStruct$UserOutPeer r2 = r0.getBannedUser()
            int r2 = r2.getUid()
            java.lang.Integer r2 = ir.nasim.AbstractC6392Nk0.d(r2)
            ai.bale.proto.PeersStruct$UserOutPeer r0 = r0.getBannerUser()
            int r0 = r0.getUid()
            java.lang.Integer r0 = ir.nasim.AbstractC6392Nk0.d(r0)
            r1.<init>(r2, r0)
            r11.add(r1)
            goto Lbb
        Le8:
            java.lang.Object r10 = ir.nasim.C9475a16.b(r11)
        Lec:
            return r10
        Led:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LM2.i(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.KM2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(int r11, java.util.List r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LM2.j(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.KM2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(java.util.List r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.LM2.i
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.LM2$i r0 = (ir.nasim.LM2.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.LM2$i r0 = new ir.nasim.LM2$i
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L52
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.bQ2 r6 = r4.b
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.Collection r5 = (java.util.Collection) r5
            r2.<init>(r5)
            r5 = 0
            ir.nasim.Nv5 r5 = r6.B2(r2, r5)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L52
            return r1
        L52:
            boolean r6 = ir.nasim.C9475a16.j(r5)
            if (r6 == 0) goto L5c
            ir.nasim.i18 r5 = (ir.nasim.C14505i18) r5
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
        L5c:
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LM2.k(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.KM2
    public Object l(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b.X1().d(j2);
    }

    @Override // ir.nasim.KM2
    public Object m(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new g(j2, null), interfaceC20295rm1);
    }
}
