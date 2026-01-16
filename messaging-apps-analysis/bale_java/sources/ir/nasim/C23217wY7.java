package ir.nasim;

import ai.bale.proto.PeersStruct$OutPeer;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import java.util.Set;

/* renamed from: ir.nasim.wY7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23217wY7 implements InterfaceC22621vY7 {
    public static final a f = new a(null);
    private final AbstractC13778go1 a;
    private final C6287Mz b;
    private final InterfaceC20468s37 c;
    private final SB3 d;
    private final SB3 e;

    /* renamed from: ir.nasim.wY7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.wY7$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ Set e;

        /* renamed from: ir.nasim.wY7$b$a */
        public static final class a implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ C23217wY7 b;
            final /* synthetic */ PeersStruct$OutPeer c;

            /* renamed from: ir.nasim.wY7$b$a$a, reason: collision with other inner class name */
            public static final class C1762a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ C23217wY7 b;
                final /* synthetic */ PeersStruct$OutPeer c;

                /* renamed from: ir.nasim.wY7$b$a$a$a, reason: collision with other inner class name */
                public static final class C1763a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;
                    Object c;

                    public C1763a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1762a.this.a(null, this);
                    }
                }

                public C1762a(InterfaceC4806Gq2 interfaceC4806Gq2, C23217wY7 c23217wY7, PeersStruct$OutPeer peersStruct$OutPeer) {
                    this.a = interfaceC4806Gq2;
                    this.b = c23217wY7;
                    this.c = peersStruct$OutPeer;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r17, ir.nasim.InterfaceC20295rm1 r18) {
                    /*
                        Method dump skipped, instructions count: 257
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23217wY7.b.a.C1762a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public a(InterfaceC4557Fq2 interfaceC4557Fq2, C23217wY7 c23217wY7, PeersStruct$OutPeer peersStruct$OutPeer) {
                this.a = interfaceC4557Fq2;
                this.b = c23217wY7;
                this.c = peersStruct$OutPeer;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1762a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C11458d25 c11458d25, Set set, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = set;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23217wY7.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20468s37 interfaceC20468s37 = C23217wY7.this.c;
                C11458d25 c11458d25 = this.d;
                this.b = 1;
                obj = interfaceC20468s37.a(c11458d25, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            PeersStruct$OutPeer peersStruct$OutPeer = (PeersStruct$OutPeer) obj;
            if (peersStruct$OutPeer != null) {
                return new a(AbstractC6459Nq2.a(AbstractC15401jX0.h0(this.e, 60)), C23217wY7.this, peersStruct$OutPeer);
            }
            C9475a16.a aVar = C9475a16.b;
            return AbstractC6459Nq2.T(C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("Invalid peer")))));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wY7$c */
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
            Object objE = C23217wY7.this.e(null, null, null, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    public C23217wY7(AbstractC13778go1 abstractC13778go1, C6287Mz c6287Mz, InterfaceC20468s37 interfaceC20468s37, SB3 sb3, SB3 sb32) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(interfaceC20468s37, "peerToOutPeerMapper");
        AbstractC13042fc3.i(sb3, "messagesViewsToViewsResponseMapper");
        AbstractC13042fc3.i(sb32, "messageIdToStructMessageIdMapper");
        this.a = abstractC13778go1;
        this.b = c6287Mz;
        this.c = interfaceC20468s37;
        this.d = sb3;
        this.e = sb32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ai.bale.proto.PeersStruct$OutPeer r9, java.util.List r10, java.util.List r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof ir.nasim.C23217wY7.c
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.wY7$c r0 = (ir.nasim.C23217wY7.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.d = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            ir.nasim.wY7$c r0 = new ir.nasim.wY7$c
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r5.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.d
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r9 = r5.a
            ir.nasim.wY7 r9 = (ir.nasim.C23217wY7) r9
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
            java.lang.Object r10 = r12.l()
            goto L84
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.vx5 r1 = new ir.nasim.vx5
            ai.bale.proto.AbacusOuterClass$RequestGetMessagesViews$a r12 = ai.bale.proto.AbacusOuterClass$RequestGetMessagesViews.newBuilder()
            ai.bale.proto.AbacusOuterClass$RequestGetMessagesViews$a r9 = r12.D(r9)
            ai.bale.proto.AbacusOuterClass$RequestGetMessagesViews$a r9 = r9.C(r2)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            ai.bale.proto.AbacusOuterClass$RequestGetMessagesViews$a r9 = r9.B(r10)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            ai.bale.proto.AbacusOuterClass$RequestGetMessagesViews$a r9 = r9.A(r11)
            com.google.protobuf.GeneratedMessageLite r9 = r9.a()
            java.lang.String r10 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r9, r10)
            ai.bale.proto.AbacusOuterClass$ResponseGetMessagesViews r10 = ai.bale.proto.AbacusOuterClass$ResponseGetMessagesViews.getDefaultInstance()
            java.lang.String r11 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            java.lang.String r11 = "/bale.abacus.v1.Abacus/GetMessagesViews"
            r1.<init>(r11, r9, r10)
            ir.nasim.Mz r9 = r8.b
            r5.a = r8
            r5.d = r2
            r3 = 0
            r6 = 2
            r7 = 0
            r2 = r9
            java.lang.Object r10 = ir.nasim.AbstractC6547Nz.b(r1, r2, r3, r5, r6, r7)
            if (r10 != r0) goto L83
            return r0
        L83:
            r9 = r8
        L84:
            boolean r11 = ir.nasim.C9475a16.j(r10)
            if (r11 == 0) goto La2
            ai.bale.proto.AbacusOuterClass$ResponseGetMessagesViews r10 = (ai.bale.proto.AbacusOuterClass$ResponseGetMessagesViews) r10
            ir.nasim.SB3 r9 = r9.d
            java.util.List r10 = r10.getContainersList()
            java.lang.String r11 = "getContainersList(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            java.lang.Object r9 = r9.a(r10)
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
            goto La6
        La2:
            java.lang.Object r9 = ir.nasim.C9475a16.b(r10)
        La6:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23217wY7.e(ai.bale.proto.PeersStruct$OutPeer, java.util.List, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC22621vY7
    public Object a(C11458d25 c11458d25, Set set, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new b(c11458d25, set, null), interfaceC20295rm1);
    }
}
