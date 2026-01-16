package ir.nasim;

import ai.bale.proto.MessagingOuterClass$RequestCreateReservedFolder;
import ai.bale.proto.MessagingOuterClass$RequestUnpinDialogs;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.UO1;
import ir.nasim.Z06;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19467qP1 {
    public static final a f = new a(null);
    public static final int g = 8;
    private final C6287Mz a;
    private final AbstractC13778go1 b;
    private final V25 c;
    private final InterfaceC14123hO3 d;
    private final YF3 e;

    /* renamed from: ir.nasim.qP1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qP1$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC10088b35.values().length];
            try {
                iArr[EnumC10088b35.ExPeerType_BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_SUPERGROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.qP1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ C19467qP1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, C19467qP1 c19467qP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = c19467qP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MessagingOuterClass$RequestCreateReservedFolder messagingOuterClass$RequestCreateReservedFolder = (MessagingOuterClass$RequestCreateReservedFolder) MessagingOuterClass$RequestCreateReservedFolder.newBuilder().A(this.c).a();
                C19467qP1 c19467qP1 = this.d;
                AbstractC13042fc3.f(messagingOuterClass$RequestCreateReservedFolder);
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = C19467qP1.h(c19467qP1, "/bale.messaging.v2.Messaging/CreateReservedFolder", messagingOuterClass$RequestCreateReservedFolder, defaultInstance, null, this, 8, null);
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
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(C19938rB7.a);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qP1$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C19467qP1.this.g(null, null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.qP1$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objI = C19467qP1.this.i(0L, 0, 0, this);
            return objI == AbstractC14862ic3.e() ? objI : C9475a16.a(objI);
        }
    }

    /* renamed from: ir.nasim.qP1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int d;
        final /* synthetic */ long e;
        final /* synthetic */ int f;
        final /* synthetic */ C19467qP1 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i, long j, int i2, C19467qP1 c19467qP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = j;
            this.f = i2;
            this.g = c19467qP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0106  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qP1$g */
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
            Object objJ = C19467qP1.this.j(null, this);
            return objJ == AbstractC14862ic3.e() ? objJ : C9475a16.a(objJ);
        }
    }

    /* renamed from: ir.nasim.qP1$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ List g;
        final /* synthetic */ C19467qP1 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(List list, C19467qP1 c19467qP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = list;
            this.h = c19467qP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(this.g, this.h, interfaceC20295rm1);
            hVar.f = obj;
            return hVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x008f A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:12:0x003d, B:24:0x00ad, B:18:0x0089, B:20:0x008f, B:25:0x00b6, B:17:0x0073), top: B:68:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b6 A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #0 {all -> 0x0046, blocks: (B:12:0x003d, B:24:0x00ad, B:18:0x0089, B:20:0x008f, B:25:0x00b6, B:17:0x0073), top: B:68:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01a4  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00aa -> B:24:0x00ad). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r16) {
            /*
                Method dump skipped, instructions count: 525
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qP1$i */
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
            Object objK = C19467qP1.this.k(0, this);
            return objK == AbstractC14862ic3.e() ? objK : C9475a16.a(objK);
        }
    }

    /* renamed from: ir.nasim.qP1$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int d;
        final /* synthetic */ C19467qP1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(int i, C19467qP1 c19467qP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = c19467qP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00d7  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 248
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qP1$k */
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
            return C19467qP1.this.l(null, false, this);
        }
    }

    /* renamed from: ir.nasim.qP1$l */
    static final class l extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C19467qP1.this.n(null, this);
        }
    }

    /* renamed from: ir.nasim.qP1$m */
    static final class m extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objO = C19467qP1.this.o(0, null, this);
            return objO == AbstractC14862ic3.e() ? objO : C9475a16.a(objO);
        }
    }

    /* renamed from: ir.nasim.qP1$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int d;
        final /* synthetic */ List e;
        final /* synthetic */ C19467qP1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(int i, List list, C19467qP1 c19467qP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = list;
            this.f = c19467qP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new n(this.d, this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x011c  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 320
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qP1$o */
    static final class o extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objP = C19467qP1.this.p(null, this);
            return objP == AbstractC14862ic3.e() ? objP : C9475a16.a(objP);
        }
    }

    /* renamed from: ir.nasim.qP1$p */
    static final class p extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objQ = C19467qP1.this.q(null, this);
            return objQ == AbstractC14862ic3.e() ? objQ : C9475a16.a(objQ);
        }
    }

    /* renamed from: ir.nasim.qP1$q */
    static final class q extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objR = C19467qP1.this.r(0, null, this);
            return objR == AbstractC14862ic3.e() ? objR : C9475a16.a(objR);
        }
    }

    /* renamed from: ir.nasim.qP1$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ List d;
        final /* synthetic */ C19467qP1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(int i, List list, C19467qP1 c19467qP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = list;
            this.e = c19467qP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new r(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UO1.e.b(UO1.e.a, "Starting unPinDialogs for folderId: " + this.c + ", peers: " + this.d.size(), null, 2, null);
                MessagingOuterClass$RequestUnpinDialogs.a aVarB = MessagingOuterClass$RequestUnpinDialogs.newBuilder().B(this.c);
                List list = this.d;
                C19467qP1 c19467qP1 = this.e;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((PeersStruct$ExPeer) c19467qP1.d.a((ExPeer) it.next()));
                }
                MessagingOuterClass$RequestUnpinDialogs messagingOuterClass$RequestUnpinDialogs = (MessagingOuterClass$RequestUnpinDialogs) aVarB.A(arrayList).a();
                C19467qP1 c19467qP12 = this.e;
                AbstractC13042fc3.f(messagingOuterClass$RequestUnpinDialogs);
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = C19467qP1.h(c19467qP12, "/bale.messaging.v2.Messaging/UnpinDialogs", messagingOuterClass$RequestUnpinDialogs, defaultInstance, null, this, 8, null);
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
            List list2 = this.d;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                UO1.e.b(UO1.e.a, "unPinDialogs successful. Number of dialogs: " + list2.size(), null, 2, null);
                objB = C9475a16.b(C19938rB7.a);
            }
            int i2 = this.c;
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                UO1.e.a.c("unPinDialogs failed for folderId: " + i2, thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C19467qP1(C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1, V25 v25, InterfaceC14123hO3 interfaceC14123hO3, YF3 yf3) {
        AbstractC13042fc3.i(c6287Mz, "apiGateway");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(v25, "peerToOutPeerMapper");
        AbstractC13042fc3.i(interfaceC14123hO3, "exPeerToStructExPeerMapper");
        AbstractC13042fc3.i(yf3, "loadPeersUseCase");
        this.a = c6287Mz;
        this.b = abstractC13778go1;
        this.c = v25;
        this.d = interfaceC14123hO3;
        this.e = yf3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00d1 -> B:13:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r20, com.google.protobuf.P r21, com.google.protobuf.P r22, ir.nasim.C23270we2 r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.g(java.lang.String, com.google.protobuf.P, com.google.protobuf.P, ir.nasim.we2, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object h(C19467qP1 c19467qP1, String str, com.google.protobuf.P p2, com.google.protobuf.P p3, C23270we2 c23270we2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        return c19467qP1.g(str, p2, p3, (i2 & 8) != 0 ? new C23270we2(0L, 0L, 0.0d, 0.0f, 15, null) : c23270we2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.util.List r8, boolean r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof ir.nasim.C19467qP1.k
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.qP1$k r0 = (ir.nasim.C19467qP1.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.qP1$k r0 = new ir.nasim.qP1$k
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
            r10.l()
            goto Lce
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            ir.nasim.AbstractC10685c16.b(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L45:
            boolean r2 = r8.hasNext()
            r4 = 2
            if (r2 == 0) goto La8
            java.lang.Object r2 = r8.next()
            ai.bale.proto.MessagingStruct$Dialog r2 = (ai.bale.proto.MessagingStruct$Dialog) r2
            ai.bale.proto.PeersStruct$ExInfo r5 = r2.getExInfo()
            ir.nasim.b35 r5 = r5.getExPeerType()
            if (r5 != 0) goto L5e
            r5 = -1
            goto L66
        L5e:
            int[] r6 = ir.nasim.C19467qP1.b.a
            int r5 = r5.ordinal()
            r5 = r6[r5]
        L66:
            if (r5 == r3) goto L8f
            if (r5 == r4) goto L8f
            r4 = 3
            if (r5 == r4) goto L76
            r4 = 4
            if (r5 == r4) goto L76
            r4 = 5
            if (r5 == r4) goto L76
            ir.nasim.rB7 r2 = ir.nasim.C19938rB7.a
            goto L45
        L76:
            ai.bale.proto.PeersStruct$Peer r2 = r2.getPeer()
            int r2 = r2.getId()
            ir.nasim.d25 r2 = ir.nasim.C11458d25.y(r2)
            java.lang.String r4 = "group(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r4)
            boolean r2 = r10.add(r2)
            ir.nasim.AbstractC6392Nk0.a(r2)
            goto L45
        L8f:
            ai.bale.proto.PeersStruct$Peer r2 = r2.getPeer()
            int r2 = r2.getId()
            ir.nasim.d25 r2 = ir.nasim.C11458d25.E(r2)
            java.lang.String r4 = "user(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r4)
            boolean r2 = r10.add(r2)
            ir.nasim.AbstractC6392Nk0.a(r2)
            goto L45
        La8:
            ir.nasim.UO1$e r8 = ir.nasim.UO1.e.a
            int r2 = r10.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Load peers: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r5 = 0
            ir.nasim.UO1.e.b(r8, r2, r5, r4, r5)
            ir.nasim.YF3 r8 = r7.e
            r0.c = r3
            java.lang.Object r8 = r8.a(r10, r9, r0)
            if (r8 != r1) goto Lce
            return r1
        Lce:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.l(java.util.List, boolean, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object m(C19467qP1 c19467qP1, List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return c19467qP1.l(list, z, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.util.List r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.C19467qP1.l
            if (r0 == 0) goto L14
            r0 = r9
            ir.nasim.qP1$l r0 = (ir.nasim.C19467qP1.l) r0
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
            ir.nasim.qP1$l r0 = new ir.nasim.qP1$l
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r4.c
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            r9.l()
            goto Lc8
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            ir.nasim.AbstractC10685c16.b(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L47:
            boolean r1 = r8.hasNext()
            r3 = 2
            if (r1 == 0) goto L9e
            java.lang.Object r1 = r8.next()
            ai.bale.proto.PeersStruct$ExPeer r1 = (ai.bale.proto.PeersStruct$ExPeer) r1
            ir.nasim.b35 r5 = r1.getType()
            if (r5 != 0) goto L5c
            r5 = -1
            goto L64
        L5c:
            int[] r6 = ir.nasim.C19467qP1.b.a
            int r5 = r5.ordinal()
            r5 = r6[r5]
        L64:
            if (r5 == r2) goto L89
            if (r5 == r3) goto L89
            r3 = 3
            if (r5 == r3) goto L74
            r3 = 4
            if (r5 == r3) goto L74
            r3 = 5
            if (r5 == r3) goto L74
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            goto L47
        L74:
            int r1 = r1.getId()
            ir.nasim.d25 r1 = ir.nasim.C11458d25.y(r1)
            java.lang.String r3 = "group(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            boolean r1 = r9.add(r1)
            ir.nasim.AbstractC6392Nk0.a(r1)
            goto L47
        L89:
            int r1 = r1.getId()
            ir.nasim.d25 r1 = ir.nasim.C11458d25.E(r1)
            java.lang.String r3 = "user(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            boolean r1 = r9.add(r1)
            ir.nasim.AbstractC6392Nk0.a(r1)
            goto L47
        L9e:
            ir.nasim.UO1$e r8 = ir.nasim.UO1.e.a
            int r1 = r9.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Load peers: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r5 = 0
            ir.nasim.UO1.e.b(r8, r1, r5, r3, r5)
            ir.nasim.YF3 r1 = r7.e
            r4.c = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r9
            java.lang.Object r8 = ir.nasim.YF3.b(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto Lc8
            return r0
        Lc8:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.n(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    public final Object f(int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.b, new c(i2, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(long r14, int r16, int r17, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            r13 = this;
            r7 = r13
            r0 = r18
            boolean r1 = r0 instanceof ir.nasim.C19467qP1.e
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.qP1$e r1 = (ir.nasim.C19467qP1.e) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
        L15:
            r8 = r1
            goto L1d
        L17:
            ir.nasim.qP1$e r1 = new ir.nasim.qP1$e
            r1.<init>(r0)
            goto L15
        L1d:
            java.lang.Object r0 = r8.a
            java.lang.Object r9 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r8.c
            r10 = 1
            if (r1 == 0) goto L36
            if (r1 != r10) goto L2e
            ir.nasim.AbstractC10685c16.b(r0)
            goto L51
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L36:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.go1 r11 = r7.b
            ir.nasim.qP1$f r12 = new ir.nasim.qP1$f
            r6 = 0
            r0 = r12
            r1 = r16
            r2 = r14
            r4 = r17
            r5 = r13
            r0.<init>(r1, r2, r4, r5, r6)
            r8.c = r10
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r11, r12, r8)
            if (r0 != r9) goto L51
            return r9
        L51:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.i(long, int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C19467qP1.g
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.qP1$g r0 = (ir.nasim.C19467qP1.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.qP1$g r0 = new ir.nasim.qP1$g
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
            ir.nasim.go1 r7 = r5.b
            ir.nasim.qP1$h r2 = new ir.nasim.qP1$h
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.j(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C19467qP1.i
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.qP1$i r0 = (ir.nasim.C19467qP1.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.qP1$i r0 = new ir.nasim.qP1$i
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
            ir.nasim.go1 r7 = r5.b
            ir.nasim.qP1$j r2 = new ir.nasim.qP1$j
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.k(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(int r6, java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C19467qP1.m
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.qP1$m r0 = (ir.nasim.C19467qP1.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.qP1$m r0 = new ir.nasim.qP1$m
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.qP1$n r2 = new ir.nasim.qP1$n
            r4 = 0
            r2.<init>(r6, r7, r5, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.o(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.util.List r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C19467qP1.o
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.qP1$o r0 = (ir.nasim.C19467qP1.o) r0
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
            ir.nasim.qP1$o r0 = new ir.nasim.qP1$o
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
            goto L99
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            boolean r11 = r10.isEmpty()
            if (r11 == 0) goto L45
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            return r10
        L45:
            ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsRead$a r11 = ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsRead.newBuilder()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r3 = ir.nasim.ZW0.x(r10, r3)
            r1.<init>(r3)
            java.util.Iterator r10 = r10.iterator()
        L5a:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L72
            java.lang.Object r3 = r10.next()
            ir.nasim.core.modules.profile.entity.ExPeer r3 = (ir.nasim.core.modules.profile.entity.ExPeer) r3
            ir.nasim.hO3 r4 = r9.d
            java.lang.Object r3 = r4.a(r3)
            ai.bale.proto.PeersStruct$ExPeer r3 = (ai.bale.proto.PeersStruct$ExPeer) r3
            r1.add(r3)
            goto L5a
        L72:
            ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsRead$a r10 = r11.A(r1)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            r3 = r10
            ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsRead r3 = (ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsRead) r3
            ir.nasim.AbstractC13042fc3.f(r3)
            ai.bale.proto.Misc$ResponseVoid r4 = ai.bale.proto.Misc$ResponseVoid.getDefaultInstance()
            java.lang.String r10 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r4, r10)
            r6.c = r2
            java.lang.String r2 = "/bale.messaging.v2.Messaging/MarkDialogsAsRead"
            r5 = 0
            r7 = 8
            r8 = 0
            r1 = r9
            java.lang.Object r11 = h(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L99
            return r0
        L99:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto Lb0
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Lc4
        Lb0:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto Lc5
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.Misc$ResponseVoid r10 = (ai.bale.proto.Misc$ResponseVoid) r10
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        Lc4:
            return r10
        Lc5:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.p(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.util.List r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C19467qP1.p
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.qP1$p r0 = (ir.nasim.C19467qP1.p) r0
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
            ir.nasim.qP1$p r0 = new ir.nasim.qP1$p
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
            goto L99
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            boolean r11 = r10.isEmpty()
            if (r11 == 0) goto L45
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            return r10
        L45:
            ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsUnread$a r11 = ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsUnread.newBuilder()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r3 = ir.nasim.ZW0.x(r10, r3)
            r1.<init>(r3)
            java.util.Iterator r10 = r10.iterator()
        L5a:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L72
            java.lang.Object r3 = r10.next()
            ir.nasim.core.modules.profile.entity.ExPeer r3 = (ir.nasim.core.modules.profile.entity.ExPeer) r3
            ir.nasim.hO3 r4 = r9.d
            java.lang.Object r3 = r4.a(r3)
            ai.bale.proto.PeersStruct$ExPeer r3 = (ai.bale.proto.PeersStruct$ExPeer) r3
            r1.add(r3)
            goto L5a
        L72:
            ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsUnread$a r10 = r11.A(r1)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            r3 = r10
            ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsUnread r3 = (ai.bale.proto.MessagingOuterClass$RequestMarkDialogsAsUnread) r3
            ir.nasim.AbstractC13042fc3.f(r3)
            ai.bale.proto.Misc$ResponseVoid r4 = ai.bale.proto.Misc$ResponseVoid.getDefaultInstance()
            java.lang.String r10 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r4, r10)
            r6.c = r2
            java.lang.String r2 = "/bale.messaging.v2.Messaging/MarkDialogsAsUnread"
            r5 = 0
            r7 = 8
            r8 = 0
            r1 = r9
            java.lang.Object r11 = h(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L99
            return r0
        L99:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto Lb0
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Lc4
        Lb0:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto Lc5
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.Misc$ResponseVoid r10 = (ai.bale.proto.Misc$ResponseVoid) r10
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        Lc4:
            return r10
        Lc5:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.q(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(int r6, java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C19467qP1.q
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.qP1$q r0 = (ir.nasim.C19467qP1.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.qP1$q r0 = new ir.nasim.qP1$q
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.qP1$r r2 = new ir.nasim.qP1$r
            r4 = 0
            r2.<init>(r6, r7, r5, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19467qP1.r(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }
}
