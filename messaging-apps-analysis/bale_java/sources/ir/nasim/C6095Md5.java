package ir.nasim;

import ai.bale.proto.MessagingOuterClass$RequestLoadPinnedMessages;
import ai.bale.proto.MessagingOuterClass$RequestPinMessages;
import ai.bale.proto.MessagingOuterClass$RequestUnPinMessages;
import ai.bale.proto.MessagingOuterClass$ResponseLoadPinnedMessages;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Md5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6095Md5 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final AbstractC13778go1 a;
    private final C9057Yh4 b;
    private final InterfaceC16847ly c;

    /* renamed from: ir.nasim.Md5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Md5$b */
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
            Object objC = C6095Md5.this.c(null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.Md5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6095Md5.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PeersStruct$ExPeer peersStruct$ExPeerL = C6095Md5.this.b.l(this.d);
                if (peersStruct$ExPeerL == null) {
                    C9475a16.a aVar = C9475a16.b;
                    return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("peer is null!"))));
                }
                MessagingOuterClass$RequestLoadPinnedMessages messagingOuterClass$RequestLoadPinnedMessages = (MessagingOuterClass$RequestLoadPinnedMessages) MessagingOuterClass$RequestLoadPinnedMessages.newBuilder().A(peersStruct$ExPeerL).a();
                MessagingOuterClass$ResponseLoadPinnedMessages defaultInstance = MessagingOuterClass$ResponseLoadPinnedMessages.getDefaultInstance();
                InterfaceC16847ly interfaceC16847ly = C6095Md5.this.c;
                AbstractC13042fc3.f(messagingOuterClass$RequestLoadPinnedMessages);
                AbstractC13042fc3.f(defaultInstance);
                C22871vx5 c22871vx5 = new C22871vx5("/bale.messaging.v2.Messaging/LoadPinnedMessages", messagingOuterClass$RequestLoadPinnedMessages, defaultInstance);
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar3 = C9475a16.b;
                List<MessagingStruct$MessageContainer> pinnedMessagesList = ((MessagingOuterClass$ResponseLoadPinnedMessages) ((Z06.b) z06).a()).getPinnedMessagesList();
                AbstractC13042fc3.h(pinnedMessagesList, "getPinnedMessagesList(...)");
                objB = C9475a16.b(AbstractC15401jX0.n0(pinnedMessagesList));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Md5$d */
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
            Object objD = C6095Md5.this.d(0L, 0L, null, false, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.Md5$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ C6095Md5 e;
        final /* synthetic */ C11458d25 f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, long j2, C6095Md5 c6095Md5, C11458d25 c11458d25, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = j2;
            this.e = c6095Md5;
            this.f = c11458d25;
            this.g = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MessagingStruct$MessageId messagingStruct$MessageId = (MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().B(this.c).A(this.d).a();
                PeersStruct$ExPeer peersStruct$ExPeerL = this.e.b.l(this.f);
                if (peersStruct$ExPeerL == null) {
                    C9475a16.a aVar = C9475a16.b;
                    return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("peer is null!"))));
                }
                MessagingOuterClass$RequestPinMessages messagingOuterClass$RequestPinMessages = (MessagingOuterClass$RequestPinMessages) MessagingOuterClass$RequestPinMessages.newBuilder().C(peersStruct$ExPeerL).B(messagingStruct$MessageId).A(this.g).a();
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                InterfaceC16847ly interfaceC16847ly = this.e.c;
                AbstractC13042fc3.f(messagingOuterClass$RequestPinMessages);
                AbstractC13042fc3.f(defaultInstance);
                C22871vx5 c22871vx5 = new C22871vx5("/bale.messaging.v2.Messaging/PinMessage", messagingOuterClass$RequestPinMessages, defaultInstance);
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar3 = C9475a16.b;
                objB = C9475a16.b(C19938rB7.a);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Md5$f */
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
            Object objE = C6095Md5.this.e(null, null, false, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.Md5$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C6095Md5 d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(List list, C6095Md5 c6095Md5, C11458d25 c11458d25, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c6095Md5;
            this.e = c11458d25;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List<J44> list = this.c;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (J44 j44 : list) {
                    arrayList.add((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().B(j44.i()).A(j44.h()).a());
                }
                PeersStruct$ExPeer peersStruct$ExPeerL = this.d.b.l(this.e);
                if (peersStruct$ExPeerL == null) {
                    C9475a16.a aVar = C9475a16.b;
                    return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("peer is null!"))));
                }
                MessagingOuterClass$RequestUnPinMessages messagingOuterClass$RequestUnPinMessages = (MessagingOuterClass$RequestUnPinMessages) MessagingOuterClass$RequestUnPinMessages.newBuilder().C(peersStruct$ExPeerL).A(arrayList).B(this.f).a();
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                InterfaceC16847ly interfaceC16847ly = this.d.c;
                AbstractC13042fc3.f(messagingOuterClass$RequestUnPinMessages);
                AbstractC13042fc3.f(defaultInstance);
                C22871vx5 c22871vx5 = new C22871vx5("/bale.messaging.v2.Messaging/UnPinMessages", messagingOuterClass$RequestUnPinMessages, defaultInstance);
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar3 = C9475a16.b;
                objB = C9475a16.b(C19938rB7.a);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6095Md5(AbstractC13778go1 abstractC13778go1, C9057Yh4 c9057Yh4, InterfaceC16847ly interfaceC16847ly) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c9057Yh4, "modules");
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateWay");
        this.a = abstractC13778go1;
        this.b = c9057Yh4;
        this.c = interfaceC16847ly;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ir.nasim.C11458d25 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C6095Md5.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Md5$b r0 = (ir.nasim.C6095Md5.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Md5$b r0 = new ir.nasim.Md5$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.a
            ir.nasim.Md5$c r2 = new ir.nasim.Md5$c
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6095Md5.c(ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(long r16, long r18, ir.nasim.C11458d25 r20, boolean r21, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            r15 = this;
            r9 = r15
            r0 = r22
            boolean r1 = r0 instanceof ir.nasim.C6095Md5.d
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.Md5$d r1 = (ir.nasim.C6095Md5.d) r1
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
            ir.nasim.Md5$d r1 = new ir.nasim.Md5$d
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
            ir.nasim.Md5$e r14 = new ir.nasim.Md5$e
            r8 = 0
            r0 = r14
            r1 = r16
            r3 = r18
            r5 = r15
            r6 = r20
            r7 = r21
            r0.<init>(r1, r3, r5, r6, r7, r8)
            r10.c = r12
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r13, r14, r10)
            if (r0 != r11) goto L54
            return r11
        L54:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6095Md5.d(long, long, ir.nasim.d25, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.util.List r11, ir.nasim.C11458d25 r12, boolean r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C6095Md5.f
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.Md5$f r0 = (ir.nasim.C6095Md5.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Md5$f r0 = new ir.nasim.Md5$f
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L4a
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.a
            ir.nasim.Md5$g r2 = new ir.nasim.Md5$g
            r9 = 0
            r4 = r2
            r5 = r11
            r6 = r10
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L4a
            return r1
        L4a:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6095Md5.e(java.util.List, ir.nasim.d25, boolean, ir.nasim.rm1):java.lang.Object");
    }
}
