package ir.nasim;

import ai.bale.proto.KetfOuterClass$RequestInvokeCustomAction;
import ai.bale.proto.KetfOuterClass$RequestSendAuthenticatedInlineCallBackData;
import ai.bale.proto.KetfOuterClass$RequestSendInlineCallback;
import ai.bale.proto.KetfOuterClass$ResponseInvokeCustomAction;
import ai.bale.proto.KetfOuterClass$ResponseSendAuthenticatedInlineCallBackData;
import ai.bale.proto.KetfOuterClass$ResponseSendInlineCallback;
import ai.bale.proto.KetfStruct$DoneResult;
import ai.bale.proto.KetfStruct$OpenDialogActionResult;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PeersStruct$OutExPeer;
import ai.bale.proto.PeersStruct$OutPeer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.StringValue;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.network.RpcException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.hj0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14318hj0 implements InterfaceC13727gj0 {
    public static final a c = new a(null);
    private final InterfaceC16847ly a;
    private final AbstractC13778go1 b;

    /* renamed from: ir.nasim.hj0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.hj0$b */
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
            Object objA = C14318hj0.this.a(null, null, 0L, 0L, null, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.hj0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ ExPeerType f;
        final /* synthetic */ C14318hj0 g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, long j2, C11458d25 c11458d25, ExPeerType exPeerType, C14318hj0 c14318hj0, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = j2;
            this.e = c11458d25;
            this.f = exPeerType;
            this.g = c14318hj0;
            this.h = str;
            this.i = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                KetfOuterClass$RequestSendInlineCallback.a aVarC = KetfOuterClass$RequestSendInlineCallback.newBuilder().B((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().A(this.c).B(this.d).a()).C((PeersStruct$ExPeer) PeersStruct$ExPeer.newBuilder().B(this.e.getPeerId()).C(this.f.toProtoApi()).a());
                String str = this.h;
                if (str != null) {
                    aVarC.A(StringValue.of(str));
                }
                KetfOuterClass$RequestSendInlineCallback ketfOuterClass$RequestSendInlineCallback = (KetfOuterClass$RequestSendInlineCallback) aVarC.a();
                AbstractC13042fc3.f(ketfOuterClass$RequestSendInlineCallback);
                KetfOuterClass$ResponseSendInlineCallback defaultInstance = KetfOuterClass$ResponseSendInlineCallback.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ketf.v1.Ketf/SendInlineCallback", ketfOuterClass$RequestSendInlineCallback, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.g.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            String str2 = this.i;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                KetfOuterClass$ResponseSendInlineCallback ketfOuterClass$ResponseSendInlineCallback = (KetfOuterClass$ResponseSendInlineCallback) ((Z06.b) z06).a();
                C15046iv c15046iv = new C15046iv(str2);
                AbstractC13042fc3.f(ketfOuterClass$ResponseSendInlineCallback);
                objB = C9475a16.b(c15046iv.b(ketfOuterClass$ResponseSendInlineCallback));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hj0$d */
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
            Object objD = C14318hj0.this.d(0, null, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.hj0$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ int f;
        final /* synthetic */ C14318hj0 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, long j, long j2, int i, C14318hj0 c14318hj0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = j;
            this.e = j2;
            this.f = i;
            this.g = c14318hj0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C16018ka c16018ka = new C16018ka(this.c);
                KetfOuterClass$RequestSendAuthenticatedInlineCallBackData ketfOuterClass$RequestSendAuthenticatedInlineCallBackData = (KetfOuterClass$RequestSendAuthenticatedInlineCallBackData) KetfOuterClass$RequestSendAuthenticatedInlineCallBackData.newBuilder().A(MessagingStruct$HistoryMessageIdentifier.newBuilder().D(this.d).A(this.e).C((PeersStruct$OutPeer) PeersStruct$OutPeer.newBuilder().B(this.f).a())).a();
                AbstractC13042fc3.f(ketfOuterClass$RequestSendAuthenticatedInlineCallBackData);
                KetfOuterClass$ResponseSendAuthenticatedInlineCallBackData defaultInstance = KetfOuterClass$ResponseSendAuthenticatedInlineCallBackData.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ketf.v1.Ketf/SendAuthenticatedInlineCallBackData", ketfOuterClass$RequestSendAuthenticatedInlineCallBackData, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.g.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, c16018ka, this, 2, null);
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hj0$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ ExPeerType e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ C14318hj0 h;
        final /* synthetic */ Boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, int i, ExPeerType exPeerType, long j, long j2, C14318hj0 c14318hj0, Boolean bool, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = i;
            this.e = exPeerType;
            this.f = j;
            this.g = j2;
            this.h = c14318hj0;
            this.i = bool;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                KetfOuterClass$RequestInvokeCustomAction.a aVarA = KetfOuterClass$RequestInvokeCustomAction.newBuilder().B(this.c).E((PeersStruct$OutExPeer) PeersStruct$OutExPeer.newBuilder().B(this.d).C(this.e.toProtoApi()).a()).C((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().B(this.f).A(this.g).a()).A((KetfStruct$DoneResult) KetfStruct$DoneResult.newBuilder().a());
                Boolean bool = this.i;
                if (bool != null) {
                    aVarA.D((KetfStruct$OpenDialogActionResult) KetfStruct$OpenDialogActionResult.newBuilder().A(bool.booleanValue()).a());
                }
                KetfOuterClass$RequestInvokeCustomAction ketfOuterClass$RequestInvokeCustomAction = (KetfOuterClass$RequestInvokeCustomAction) aVarA.a();
                AbstractC13042fc3.f(ketfOuterClass$RequestInvokeCustomAction);
                KetfOuterClass$ResponseInvokeCustomAction defaultInstance = KetfOuterClass$ResponseInvokeCustomAction.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ketf.v1.Ketf/RequestInvokeCustomAction", ketfOuterClass$RequestInvokeCustomAction, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.h.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hj0$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C14318hj0.this.f(0, null, null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    public C14318hj0(InterfaceC16847ly interfaceC16847ly, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateWay");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC16847ly;
        this.b = abstractC13778go1;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // ir.nasim.InterfaceC13727gj0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.C11458d25 r19, ir.nasim.core.modules.profile.entity.ExPeerType r20, long r21, long r23, java.lang.String r25, java.lang.String r26, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            r18 = this;
            r11 = r18
            r0 = r27
            boolean r1 = r0 instanceof ir.nasim.C14318hj0.b
            if (r1 == 0) goto L18
            r1 = r0
            ir.nasim.hj0$b r1 = (ir.nasim.C14318hj0.b) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L18
            int r2 = r2 - r3
            r1.c = r2
        L16:
            r12 = r1
            goto L1e
        L18:
            ir.nasim.hj0$b r1 = new ir.nasim.hj0$b
            r1.<init>(r0)
            goto L16
        L1e:
            java.lang.Object r0 = r12.a
            java.lang.Object r13 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r12.c
            r14 = 1
            if (r1 == 0) goto L37
            if (r1 != r14) goto L2f
            ir.nasim.AbstractC10685c16.b(r0)
            goto L61
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.go1 r15 = r11.b
            ir.nasim.hj0$c r10 = new ir.nasim.hj0$c
            r16 = 0
            r0 = r10
            r1 = r23
            r3 = r21
            r5 = r19
            r6 = r20
            r7 = r18
            r8 = r26
            r9 = r25
            r17 = r10
            r10 = r16
            r0.<init>(r1, r3, r5, r6, r7, r8, r9, r10)
            r12.c = r14
            r0 = r17
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r15, r0, r12)
            if (r0 != r13) goto L61
            return r13
        L61:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14318hj0.a(ir.nasim.d25, ir.nasim.core.modules.profile.entity.ExPeerType, long, long, java.lang.String, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC13727gj0
    public Object b(String str, int i, ExPeerType exPeerType, long j, long j2, Boolean bool, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.b, new f(str, i, exPeerType, j, j2, this, bool, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC13727gj0
    public Object c(String str, int i, long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.b, new e(str, j, j2, i, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC13727gj0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(int r10, java.lang.String r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof ir.nasim.C14318hj0.d
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.hj0$d r0 = (ir.nasim.C14318hj0.d) r0
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
            ir.nasim.hj0$d r0 = new ir.nasim.hj0$d
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r12)
            goto L78
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r12)
            ai.bale.proto.TimcheOuterClass$RequestAskBotReviewCallback$a r12 = ai.bale.proto.TimcheOuterClass$RequestAskBotReviewCallback.newBuilder()
            ai.bale.proto.TimcheOuterClass$RequestAskBotReviewCallback$a r10 = r12.A(r10)
            if (r11 == 0) goto L4e
            boolean r12 = ir.nasim.AbstractC14836iZ6.n0(r11)
            if (r12 != 0) goto L48
            r12 = r11
            goto L49
        L48:
            r12 = 0
        L49:
            if (r12 == 0) goto L4e
            r10.B(r11)
        L4e:
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r11 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            ai.bale.proto.TimcheOuterClass$ResponseAskBotReviewCallback r11 = ai.bale.proto.TimcheOuterClass$ResponseAskBotReviewCallback.getDefaultInstance()
            java.lang.String r12 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r12)
            ir.nasim.vx5 r12 = new ir.nasim.vx5
            java.lang.String r1 = "/bale.timche.v1.Timche/AskBotReviewCallback"
            r12.<init>(r1, r10, r11)
            ir.nasim.ly r1 = r9.a
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r12
            java.lang.Object r12 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r12 != r0) goto L78
            return r0
        L78:
            ir.nasim.Z06 r12 = (ir.nasim.Z06) r12
            boolean r10 = r12 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto L8f
            ir.nasim.Z06$a r12 = (ir.nasim.Z06.a) r12
            ir.nasim.core.network.RpcException r10 = r12.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto La3
        L8f:
            boolean r10 = r12 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto La4
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r12 = (ir.nasim.Z06.b) r12
            com.google.protobuf.P r10 = r12.a()
            ai.bale.proto.TimcheOuterClass$ResponseAskBotReviewCallback r10 = (ai.bale.proto.TimcheOuterClass$ResponseAskBotReviewCallback) r10
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        La3:
            return r10
        La4:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14318hj0.d(int, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC13727gj0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(int r10, java.lang.Integer r11, java.lang.String r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof ir.nasim.C14318hj0.g
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.hj0$g r0 = (ir.nasim.C14318hj0.g) r0
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
            ir.nasim.hj0$g r0 = new ir.nasim.hj0$g
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r13)
            goto L94
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r13)
            ai.bale.proto.TimcheOuterClass$RequestSubmitReview$a r13 = ai.bale.proto.TimcheOuterClass$RequestSubmitReview.newBuilder()
            ai.bale.proto.TimcheOuterClass$RequestSubmitReview$a r10 = r13.A(r10)
            r13 = 0
            if (r12 == 0) goto L53
            boolean r1 = ir.nasim.AbstractC14836iZ6.n0(r12)
            if (r1 != 0) goto L49
            r1 = r12
            goto L4a
        L49:
            r1 = r13
        L4a:
            if (r1 == 0) goto L53
            com.google.protobuf.StringValue r12 = com.google.protobuf.StringValue.of(r12)
            r10.B(r12)
        L53:
            if (r11 == 0) goto L6a
            int r12 = r11.intValue()
            if (r12 != 0) goto L5c
            goto L5d
        L5c:
            r13 = r11
        L5d:
            if (r13 == 0) goto L6a
            int r11 = r11.intValue()
            com.google.protobuf.Int32Value r11 = com.google.protobuf.Int32Value.of(r11)
            r10.C(r11)
        L6a:
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r11 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            ai.bale.proto.TimcheOuterClass$ResponseSubmitReview r11 = ai.bale.proto.TimcheOuterClass$ResponseSubmitReview.getDefaultInstance()
            java.lang.String r12 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r12)
            ir.nasim.vx5 r12 = new ir.nasim.vx5
            java.lang.String r13 = "/bale.timche.v1.Timche/SubmitReview"
            r12.<init>(r13, r10, r11)
            ir.nasim.ly r1 = r9.a
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r12
            java.lang.Object r13 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r13 != r0) goto L94
            return r0
        L94:
            ir.nasim.Z06 r13 = (ir.nasim.Z06) r13
            boolean r10 = r13 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto Lab
            ir.nasim.Z06$a r13 = (ir.nasim.Z06.a) r13
            ir.nasim.core.network.RpcException r10 = r13.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Lc5
        Lab:
            boolean r10 = r13 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto Lc6
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r13 = (ir.nasim.Z06.b) r13
            com.google.protobuf.P r10 = r13.a()
            ai.bale.proto.TimcheOuterClass$ResponseSubmitReview r10 = (ai.bale.proto.TimcheOuterClass$ResponseSubmitReview) r10
            boolean r10 = r10.getShouldAskBaleReview()
            java.lang.Boolean r10 = ir.nasim.AbstractC6392Nk0.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        Lc5:
            return r10
        Lc6:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14318hj0.f(int, java.lang.Integer, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
