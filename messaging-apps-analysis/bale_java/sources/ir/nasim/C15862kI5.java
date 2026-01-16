package ir.nasim;

import ai.bale.proto.AbacusOuterClass$RequestEnableShowReactionFlag;
import ai.bale.proto.AbacusOuterClass$RequestGetShowReactionFlag;
import ai.bale.proto.AbacusOuterClass$ResponseGetShowReactionFlag;
import ai.bale.proto.Misc$ResponseVoid;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.kI5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15862kI5 implements InterfaceC15271jI5 {
    public static final a e = new a(null);
    private final AbstractC13778go1 a;
    private final C6287Mz b;
    private final InterfaceC20468s37 c;
    private final SB3 d;

    /* renamed from: ir.nasim.kI5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.kI5$b */
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
            Object objC = C15862kI5.this.c(null, null, 0L, 0L, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.kI5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ String e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C11458d25 c11458d25, String str, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = str;
            this.f = j;
            this.g = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15862kI5.this.new c(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r8.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L25
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
                java.lang.Object r9 = r9.l()
                goto L99
            L19:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L21:
                ir.nasim.AbstractC10685c16.b(r9)
                goto L39
            L25:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.kI5 r9 = ir.nasim.C15862kI5.this
                ir.nasim.s37 r9 = ir.nasim.C15862kI5.g(r9)
                ir.nasim.d25 r1 = r8.d
                r8.b = r3
                java.lang.Object r9 = r9.a(r1, r8)
                if (r9 != r0) goto L39
                return r0
            L39:
                ai.bale.proto.PeersStruct$OutPeer r9 = (ai.bale.proto.PeersStruct$OutPeer) r9
                if (r9 != 0) goto L51
                ir.nasim.a16$a r9 = ir.nasim.C9475a16.b
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>()
                java.lang.Object r9 = ir.nasim.AbstractC10685c16.a(r9)
                java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
                ir.nasim.a16 r9 = ir.nasim.C9475a16.a(r9)
                return r9
            L51:
                ir.nasim.vx5 r1 = new ir.nasim.vx5
                ai.bale.proto.AbacusOuterClass$RequestMessageSetReaction$a r3 = ai.bale.proto.AbacusOuterClass$RequestMessageSetReaction.newBuilder()
                java.lang.String r4 = r8.e
                ai.bale.proto.AbacusOuterClass$RequestMessageSetReaction$a r3 = r3.A(r4)
                long r4 = r8.f
                ai.bale.proto.AbacusOuterClass$RequestMessageSetReaction$a r3 = r3.D(r4)
                long r4 = r8.g
                ai.bale.proto.AbacusOuterClass$RequestMessageSetReaction$a r3 = r3.B(r4)
                ai.bale.proto.AbacusOuterClass$RequestMessageSetReaction$a r9 = r3.C(r9)
                com.google.protobuf.GeneratedMessageLite r9 = r9.a()
                java.lang.String r3 = "build(...)"
                ir.nasim.AbstractC13042fc3.h(r9, r3)
                ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse r3 = ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse.getDefaultInstance()
                java.lang.String r4 = "getDefaultInstance(...)"
                ir.nasim.AbstractC13042fc3.h(r3, r4)
                java.lang.String r4 = "/bale.abacus.v1.Abacus/MessageSetReaction"
                r1.<init>(r4, r9, r3)
                ir.nasim.kI5 r9 = ir.nasim.C15862kI5.this
                ir.nasim.Mz r9 = ir.nasim.C15862kI5.e(r9)
                r8.b = r2
                r3 = 0
                r6 = 2
                r7 = 0
                r2 = r9
                r5 = r8
                java.lang.Object r9 = ir.nasim.AbstractC6547Nz.b(r1, r2, r3, r5, r6, r7)
                if (r9 != r0) goto L99
                return r0
            L99:
                ir.nasim.kI5 r0 = ir.nasim.C15862kI5.this
                boolean r1 = ir.nasim.C9475a16.j(r9)
                if (r1 == 0) goto Lb6
                ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse r9 = (ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse) r9
                ir.nasim.SB3 r0 = ir.nasim.C15862kI5.f(r0)
                java.util.List r9 = r9.getReactionsList()
                java.lang.String r1 = "getReactionsList(...)"
                ir.nasim.AbstractC13042fc3.h(r9, r1)
                java.lang.Object r9 = r0.a(r9)
                java.util.List r9 = (java.util.List) r9
            Lb6:
                java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
                ir.nasim.a16 r9 = ir.nasim.C9475a16.a(r9)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15862kI5.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kI5$d */
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
            Object objB = C15862kI5.this.b(this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.kI5$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15862kI5.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = AbacusOuterClass$RequestEnableShowReactionFlag.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.abacus.v1.Abacus/EnableShowReactionFlag", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = C15862kI5.this.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(C19938rB7.a);
            } else {
                if (!(z06 instanceof Z06.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(((Z06.a) z06).a()));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kI5$f */
    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C15862kI5.this.a(this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.kI5$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15862kI5.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = AbacusOuterClass$RequestGetShowReactionFlag.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                AbacusOuterClass$ResponseGetShowReactionFlag defaultInstance = AbacusOuterClass$ResponseGetShowReactionFlag.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.abacus.v1.Abacus/GetShowReactionFlag", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = C15862kI5.this.b;
                this.b = 1;
                objB = AbstractC6547Nz.b(c22871vx5, c6287Mz, 0L, this, 2, null);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            if (C9475a16.j(objB)) {
                objB = AbstractC6392Nk0.a(((AbacusOuterClass$ResponseGetShowReactionFlag) objB).getIsEnable());
            }
            return C9475a16.a(C9475a16.b(objB));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kI5$h */
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
            Object objD = C15862kI5.this.d(null, null, 0L, 0L, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.kI5$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ String e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C11458d25 c11458d25, String str, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = str;
            this.f = j;
            this.g = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15862kI5.this.new i(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r8.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L25
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
                java.lang.Object r9 = r9.l()
                goto L99
            L19:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L21:
                ir.nasim.AbstractC10685c16.b(r9)
                goto L39
            L25:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.kI5 r9 = ir.nasim.C15862kI5.this
                ir.nasim.s37 r9 = ir.nasim.C15862kI5.g(r9)
                ir.nasim.d25 r1 = r8.d
                r8.b = r3
                java.lang.Object r9 = r9.a(r1, r8)
                if (r9 != r0) goto L39
                return r0
            L39:
                ai.bale.proto.PeersStruct$OutPeer r9 = (ai.bale.proto.PeersStruct$OutPeer) r9
                if (r9 != 0) goto L51
                ir.nasim.a16$a r9 = ir.nasim.C9475a16.b
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>()
                java.lang.Object r9 = ir.nasim.AbstractC10685c16.a(r9)
                java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
                ir.nasim.a16 r9 = ir.nasim.C9475a16.a(r9)
                return r9
            L51:
                ir.nasim.vx5 r1 = new ir.nasim.vx5
                ai.bale.proto.AbacusOuterClass$RequestMessageRemoveReaction$a r3 = ai.bale.proto.AbacusOuterClass$RequestMessageRemoveReaction.newBuilder()
                java.lang.String r4 = r8.e
                ai.bale.proto.AbacusOuterClass$RequestMessageRemoveReaction$a r3 = r3.A(r4)
                long r4 = r8.f
                ai.bale.proto.AbacusOuterClass$RequestMessageRemoveReaction$a r3 = r3.D(r4)
                long r4 = r8.g
                ai.bale.proto.AbacusOuterClass$RequestMessageRemoveReaction$a r3 = r3.B(r4)
                ai.bale.proto.AbacusOuterClass$RequestMessageRemoveReaction$a r9 = r3.C(r9)
                com.google.protobuf.GeneratedMessageLite r9 = r9.a()
                java.lang.String r3 = "build(...)"
                ir.nasim.AbstractC13042fc3.h(r9, r3)
                ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse r3 = ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse.getDefaultInstance()
                java.lang.String r4 = "getDefaultInstance(...)"
                ir.nasim.AbstractC13042fc3.h(r3, r4)
                java.lang.String r4 = "/bale.abacus.v1.Abacus/MessageRemoveReaction"
                r1.<init>(r4, r9, r3)
                ir.nasim.kI5 r9 = ir.nasim.C15862kI5.this
                ir.nasim.Mz r9 = ir.nasim.C15862kI5.e(r9)
                r8.b = r2
                r3 = 0
                r6 = 2
                r7 = 0
                r2 = r9
                r5 = r8
                java.lang.Object r9 = ir.nasim.AbstractC6547Nz.b(r1, r2, r3, r5, r6, r7)
                if (r9 != r0) goto L99
                return r0
            L99:
                ir.nasim.kI5 r0 = ir.nasim.C15862kI5.this
                boolean r1 = ir.nasim.C9475a16.j(r9)
                if (r1 == 0) goto Lb6
                ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse r9 = (ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse) r9
                ir.nasim.SB3 r0 = ir.nasim.C15862kI5.f(r0)
                java.util.List r9 = r9.getReactionsList()
                java.lang.String r1 = "getReactionsList(...)"
                ir.nasim.AbstractC13042fc3.h(r9, r1)
                java.lang.Object r9 = r0.a(r9)
                java.util.List r9 = (java.util.List) r9
            Lb6:
                java.lang.Object r9 = ir.nasim.C9475a16.b(r9)
                ir.nasim.a16 r9 = ir.nasim.C9475a16.a(r9)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15862kI5.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15862kI5(AbstractC13778go1 abstractC13778go1, C6287Mz c6287Mz, InterfaceC20468s37 interfaceC20468s37, SB3 sb3) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(interfaceC20468s37, "PeerToOutPeerMapper");
        AbstractC13042fc3.i(sb3, "messageReactionToReactionMapper");
        this.a = abstractC13778go1;
        this.b = c6287Mz;
        this.c = interfaceC20468s37;
        this.d = sb3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC15271jI5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C15862kI5.f
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.kI5$f r0 = (ir.nasim.C15862kI5.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.kI5$f r0 = new ir.nasim.kI5$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.a
            ir.nasim.kI5$g r2 = new ir.nasim.kI5$g
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15862kI5.a(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC15271jI5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C15862kI5.d
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.kI5$d r0 = (ir.nasim.C15862kI5.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.kI5$d r0 = new ir.nasim.kI5$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.a
            ir.nasim.kI5$e r2 = new ir.nasim.kI5$e
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15862kI5.b(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    @Override // ir.nasim.InterfaceC15271jI5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r16, ir.nasim.C11458d25 r17, long r18, long r20, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            r15 = this;
            r9 = r15
            r0 = r22
            boolean r1 = r0 instanceof ir.nasim.C15862kI5.b
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.kI5$b r1 = (ir.nasim.C15862kI5.b) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
        L15:
            r10 = r1
            goto L1d
        L17:
            ir.nasim.kI5$b r1 = new ir.nasim.kI5$b
            r1.<init>(r0)
            goto L15
        L1d:
            java.lang.Object r0 = r10.a
            java.lang.Object r11 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r10.c
            r12 = 1
            if (r1 == 0) goto L36
            if (r1 != r12) goto L2e
            ir.nasim.AbstractC10685c16.b(r0)
            goto L54
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L36:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.go1 r13 = r9.a
            ir.nasim.kI5$c r14 = new ir.nasim.kI5$c
            r8 = 0
            r0 = r14
            r1 = r15
            r2 = r17
            r3 = r16
            r4 = r18
            r6 = r20
            r0.<init>(r2, r3, r4, r6, r8)
            r10.c = r12
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r13, r14, r10)
            if (r0 != r11) goto L54
            return r11
        L54:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15862kI5.c(java.lang.String, ir.nasim.d25, long, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    @Override // ir.nasim.InterfaceC15271jI5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.String r16, ir.nasim.C11458d25 r17, long r18, long r20, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            r15 = this;
            r9 = r15
            r0 = r22
            boolean r1 = r0 instanceof ir.nasim.C15862kI5.h
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.kI5$h r1 = (ir.nasim.C15862kI5.h) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
        L15:
            r10 = r1
            goto L1d
        L17:
            ir.nasim.kI5$h r1 = new ir.nasim.kI5$h
            r1.<init>(r0)
            goto L15
        L1d:
            java.lang.Object r0 = r10.a
            java.lang.Object r11 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r10.c
            r12 = 1
            if (r1 == 0) goto L36
            if (r1 != r12) goto L2e
            ir.nasim.AbstractC10685c16.b(r0)
            goto L54
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L36:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.go1 r13 = r9.a
            ir.nasim.kI5$i r14 = new ir.nasim.kI5$i
            r8 = 0
            r0 = r14
            r1 = r15
            r2 = r17
            r3 = r16
            r4 = r18
            r6 = r20
            r0.<init>(r2, r3, r4, r6, r8)
            r10.c = r12
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r13, r14, r10)
            if (r0 != r11) goto L54
            return r11
        L54:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15862kI5.d(java.lang.String, ir.nasim.d25, long, long, ir.nasim.rm1):java.lang.Object");
    }
}
