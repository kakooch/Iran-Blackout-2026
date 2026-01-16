package ir.nasim;

import ai.bale.proto.AbacusOuterClass$ResponseGetMessagesReactions;
import ai.bale.proto.MavizStreamOuterClass$RequestSubscribeToThreadUpdates;
import ai.bale.proto.MessagingOuterClass$RequestLoadReplies;
import ai.bale.proto.MessagingOuterClass$ResponseLoadReplies;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.MessagingStruct$ReactionContainer;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.PfmOuterClass$RequestFilterTaggedTransactions;
import ai.bale.proto.PfmOuterClass$ResponseFilterTaggedTransactions;
import ai.bale.proto.PfmStruct$PfmTransactionId;
import ai.bale.proto.UsersStruct$User;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C3593Bn1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.pfm.entity.PFMTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: ir.nasim.yn1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24539yn1 extends AbstractC6360Ng4 {
    public static final b P = new b(null);
    public static final int Q = 8;
    private static C7880To7 R = new C7880To7(0, 0, null, 7, null);
    private static final J44 S = new J44(0, 0, 0, 0, null, null, null, 0, null, null, 0, null, null, false, null, null, false, null, null, 524287, null);
    private final HashMap A;
    private long B;
    private long C;
    private J44 D;
    private J44 E;
    private boolean F;
    private DB3 G;
    private J44 H;
    private final List I;
    private final int J;
    private boolean K;
    private C4275El L;
    private C21191tG3 M;
    private boolean N;
    private long O;
    private final C9057Yh4 m;
    private final C11458d25 n;
    private final AbstractC13778go1 o;
    private final DB3 p;
    private final InterfaceC20315ro1 q;
    private final boolean r;
    private final int s;
    private final int t;
    private final String u;
    private boolean v;
    private InterfaceC8344Vo3 w;
    private long x;
    private final ReentrantReadWriteLock y;
    private final HashSet z;

    /* renamed from: ir.nasim.yn1$a */
    private static final class a {
        public static final a a = new a();

        private a() {
        }
    }

    /* renamed from: ir.nasim.yn1$b */
    public static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final EnumC24659yz5 c(EnumC15083iz enumC15083iz) {
            return enumC15083iz == EnumC15083iz.BACKWARD ? EnumC24659yz5.a : EnumC24659yz5.b;
        }

        public final C7880To7 b() {
            return C24539yn1.R;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yn1$c */
    public static final class c {
        private final long a;

        public c(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.yn1$d */
    public static final class d {
        private final XV4 a;
        private final XV4 b;

        public d(XV4 xv4, XV4 xv42) {
            AbstractC13042fc3.i(xv4, "peer");
            AbstractC13042fc3.i(xv42, "mIds");
            this.a = xv4;
            this.b = xv42;
        }

        public final XV4 a() {
            return this.b;
        }

        public final XV4 b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "LoadReactionModel(peer=" + this.a + ", mIds=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.yn1$e */
    private static final class e {
        private final List a;

        public e(List list) {
            AbstractC13042fc3.i(list, "list");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.yn1$f */
    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC15083iz.values().length];
            try {
                iArr[EnumC15083iz.BACKWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC15083iz.FORWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC15083iz.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.yn1$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.yn1$g$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C24539yn1 a;

            a(C24539yn1 c24539yn1) {
                this.a = c24539yn1;
            }

            /* JADX WARN: Finally extract failed */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                ReentrantReadWriteLock reentrantReadWriteLock = this.a.y;
                C24539yn1 c24539yn1 = this.a;
                ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
                int i = 0;
                int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    lock.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    ArrayList arrayList = new ArrayList(c24539yn1.z);
                    c24539yn1.z.clear();
                    while (i < readHoldCount) {
                        lock.lock();
                        i++;
                    }
                    writeLock.unlock();
                    if (arrayList.isEmpty()) {
                        return C19938rB7.a;
                    }
                    this.a.r().d(new e(arrayList));
                    return C19938rB7.a;
                } catch (Throwable th) {
                    while (i < readHoldCount) {
                        lock.lock();
                        i++;
                    }
                    writeLock.unlock();
                    throw th;
                }
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24539yn1.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.r(AbstractC3851Cp7.f(C24539yn1.this.x, 1000L, null, null, 12, null));
                a aVar = new a(C24539yn1.this);
                this.b = 1;
                if (interfaceC4557Fq2R.b(aVar, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yn1$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.yn1$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C24539yn1 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24539yn1 c24539yn1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c24539yn1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                MavizStreamOuterClass$RequestSubscribeToThreadUpdates mavizStreamOuterClass$RequestSubscribeToThreadUpdates = (MavizStreamOuterClass$RequestSubscribeToThreadUpdates) MavizStreamOuterClass$RequestSubscribeToThreadUpdates.newBuilder().A(PeersStruct$ExPeer.newBuilder().B(this.c.n.getPeerId()).C(EnumC10088b35.ExPeerType_GROUP)).B((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().A(this.c.C).B(this.c.B).a()).a();
                C24539yn1 c24539yn1 = this.c;
                AbstractC13042fc3.f(mavizStreamOuterClass$RequestSubscribeToThreadUpdates);
                MavizStreamOuterClass$RequestSubscribeToThreadUpdates defaultInstance = MavizStreamOuterClass$RequestSubscribeToThreadUpdates.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                c24539yn1.L(new C22871vx5("/bale.maviz.v1.MavizStream/SubscribeToThreadUpdates", mavizStreamOuterClass$RequestSubscribeToThreadUpdates, defaultInstance));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c19938rB7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24539yn1.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.r(AbstractC3851Cp7.f(25000L, 0L, null, null, 12, null));
                a aVar = new a(C24539yn1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2R, aVar, this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C24539yn1(C9057Yh4 c9057Yh4, C11458d25 c11458d25, AbstractC13778go1 abstractC13778go1, DB3 db3, InterfaceC20315ro1 interfaceC20315ro1, boolean z, int i, ED1 ed1) {
        AbstractC13778go1 abstractC13778go1A = (i & 4) != 0 ? InterfaceC4787Go1.INSTANCE.a(C5721Ko.a.d()).a() : abstractC13778go1;
        if ((i & 16) != 0) {
            interfaceC20315ro1 = AbstractC20906so1.a(new C19115po1("stashHandler_" + c11458d25));
        }
        this(c9057Yh4, c11458d25, abstractC13778go1A, db3, interfaceC20315ro1, (i & 32) != 0 ? false : z);
    }

    private final void A1() {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        interfaceC8344Vo3.a(this.n.u()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.xn1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.B1(this.a, (C4778Gn1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 A2(C4382Ew7 c4382Ew7) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(C24539yn1 c24539yn1, C4778Gn1 c4778Gn1) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c4778Gn1, "state");
        InterfaceC8344Vo3 interfaceC8344Vo3 = c24539yn1.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        interfaceC8344Vo3.e(c4778Gn1.H(new TreeSet()));
    }

    private final C6517Nv5 B2(long j) {
        C6517Nv5 c6517Nv5H = j2(this, j, EnumC15083iz.FORWARD, null, 4, null).H(new InterfaceC17569nB2() { // from class: ir.nasim.Wm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.C2((UF3) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final void C1() {
        this.O = -1L;
        this.v = false;
        z1();
        V2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 C2(UF3 uf3) {
        return C6517Nv5.l0(new C10872cL4(EnumC11636dL4.SPECIFIC_MESSAGE, ((J44) AbstractC15401jX0.C0(uf3.c())).i(), ((J44) AbstractC15401jX0.C0(uf3.c())).h()));
    }

    private final void D2(long j) {
        r().d(new c(j));
    }

    private final void E1(J44 j44) {
        Integer numO0 = ((C14697iL2) this.m.E().X1().d(this.n.getPeerId())).o0();
        boolean z = numO0 == null || numO0.intValue() == 0;
        if (j44 != null) {
            String string = C5721Ko.a.d().getString(z ? DD5.start_replies : DD5.start_comment);
            AbstractC13042fc3.h(string, "getString(...)");
            C25247zz c25247zz = new C25247zz(0, AbstractC19981rG5.a(), j44.h() + 1, new C23011wC(string, null), EnumC4884Gz.RECEIVED, AbstractC10360bX0.m(), null, null, null, new C3460Az(j44.h(), j44.i(), 0L), null, null, null, null, Boolean.FALSE, null, null);
            C3460Az c3460Az = new C3460Az(c25247zz.h(), c25247zz.i(), 0L);
            R = new C7880To7(c25247zz.i(), c25247zz.h(), null, 4, null);
            J44 j44W1 = w1(j44, c3460Az, null);
            this.D = C18732p92.M(c25247zz);
            this.E = j44W1;
        }
    }

    private final C6517Nv5 E2() {
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.in1
            @Override // java.lang.Runnable
            public final void run() {
                C24539yn1.F2();
            }
        });
        if (!this.F) {
            DB3 db3 = this.G;
            if (db3 == null) {
                AbstractC13042fc3.y("messagesEngine");
                db3 = null;
            }
            J44 j44 = (J44) db3.r();
            if (j44 != null && j44.N() == null) {
                C19406qI3.a("OpenHistoryLog", "onLoadLastMessages return because last message exists!", new Object[0]);
                C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
                AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
                return c6517Nv5L0;
            }
        }
        C6517Nv5 c6517Nv5H = b2(this, Long.MAX_VALUE, EnumC15083iz.BACKWARD, null, 4, null).A(new InterfaceC17569nB2() { // from class: ir.nasim.sn1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.G2(this.a, (C4382Ew7) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.tn1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.H2(this.a, (Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.un1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.I2((C4382Ew7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 F1() {
        DB3 db3 = this.G;
        if (db3 == null) {
            AbstractC13042fc3.y("messagesEngine");
            db3 = null;
        }
        J44 j44 = (J44) db3.m();
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(new C4382Ew7((j44 == null || Z2(j44)) ? VF3.d : VF3.e, C6517Nv5.l0(C14505i18.a)));
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2() {
        C19406qI3.a("OpenHistoryLog", " onLoadLastMessages", new Object[0]);
    }

    private final EnumC15083iz G1(J44 j44) {
        J44 j442 = this.H;
        return j442 == null ? EnumC15083iz.UNSUPPORTED_VALUE : j442.h() != j44.h() ? j442.h() > j44.h() ? EnumC15083iz.BACKWARD : EnumC15083iz.FORWARD : EnumC15083iz.UNSUPPORTED_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 G2(C24539yn1 c24539yn1, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c4382Ew7, "r");
        c24539yn1.F = false;
        return C6517Nv5.l0(c4382Ew7);
    }

    private final C6517Nv5 H1(long j, long j2) {
        J44 j44 = (J44) this.p.i(j, j2);
        if (j44 != null) {
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(j44);
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        C19406qI3.d("NON_FATAL_EXCEPTION", new Exception(this.u + " : Sapta message not found in conversations, date: " + j + " rid: " + j2));
        C6517Nv5 c6517Nv5H = O(new ST5(this.m.n(this.n), j, null, 1, PC.c), 30000L).H(new InterfaceC17569nB2() { // from class: ir.nasim.Km1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.I1((VZ5) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(C24539yn1 c24539yn1, Exception exc) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        c24539yn1.r().d(C3593Bn1.h.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 I1(VZ5 vz5) {
        AbstractC13042fc3.i(vz5, "responseLoadHistory");
        List listY = vz5.y();
        AbstractC13042fc3.h(listY, "getHistory(...)");
        if (!(!listY.isEmpty())) {
            return C6517Nv5.F(new Exception("Message not found!"));
        }
        Object obj = listY.get(0);
        AbstractC13042fc3.h(obj, "get(...)");
        return C6517Nv5.l0(C18732p92.M((C25247zz) obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 I2(C4382Ew7 c4382Ew7) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final J44 J1(long j, long j2) {
        C4275El c4275El = this.L;
        if (c4275El == null) {
            AbstractC13042fc3.y("albumToMessageIdDataSource");
            c4275El = null;
        }
        Long lC = c4275El.c(this.n.u(), AbstractC4616Fw7.a(Long.valueOf(j), Long.valueOf(j2)));
        if (lC == null) {
            return null;
        }
        return (J44) this.p.a(lC.longValue());
    }

    private final void J2() {
        this.F = true;
        this.O = -1L;
        z1();
        A1();
    }

    private final J44 K1(J44 j44, int i) {
        C3460Az c3460AzH = AbstractC3827Cn1.h(j44.O());
        if (c3460AzH == null) {
            return S;
        }
        long jI = c3460AzH.i();
        DB3 db3 = this.G;
        J44 j442 = null;
        DB3 db32 = null;
        if (db3 == null) {
            AbstractC13042fc3.y("messagesEngine");
            db3 = null;
        }
        J44 j443 = (J44) db3.a(jI);
        if (j443 == null) {
            C4275El c4275El = this.L;
            if (c4275El == null) {
                AbstractC13042fc3.y("albumToMessageIdDataSource");
                c4275El = null;
            }
            Long lC = c4275El.c(this.n.u(), AbstractC4616Fw7.a(Long.valueOf(c3460AzH.i()), Long.valueOf(c3460AzH.h())));
            if (lC != null) {
                long jLongValue = lC.longValue();
                DB3 db33 = this.G;
                if (db33 == null) {
                    AbstractC13042fc3.y("messagesEngine");
                } else {
                    db32 = db33;
                }
                j442 = (J44) db32.a(jLongValue);
            }
            if (j442 == null) {
                return j44;
            }
            AbstractC17457n0 abstractC17457n0F = j442.F();
            AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
            C11907dl c11907dl = (C11907dl) abstractC17457n0F;
            List listR = c11907dl.r();
            if (!(listR instanceof Collection) || !listR.isEmpty()) {
                Iterator it = listR.iterator();
                while (it.hasNext()) {
                    if (((J44) it.next()).i() == c3460AzH.i()) {
                        j443 = (J44) AbstractC15401jX0.q0(c11907dl.r());
                    }
                }
            }
            return j44;
        }
        if (i >= this.J) {
            return S;
        }
        if (!this.I.contains(Long.valueOf(j44.i()))) {
            this.I.add(Long.valueOf(j44.i()));
        }
        return K1(j443, i + 1);
    }

    private final C6517Nv5 K2(final C11458d25 c11458d25, long j, long j2, int i, final InterfaceC21893uJ4 interfaceC21893uJ4) {
        C6517Nv5 c6517Nv5M0 = l2(EnumC11636dL4.SPECIFIC_MESSAGE, c11458d25, j, j2, i, false).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Em1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.R2(this.a, c11458d25, interfaceC21893uJ4, (C10872cL4) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    private final J44 L1(J44 j44, int i) {
        C3460Az c3460AzH = AbstractC3827Cn1.h(j44.N());
        if (c3460AzH == null) {
            return S;
        }
        long jI = c3460AzH.i();
        DB3 db3 = this.G;
        J44 j442 = null;
        DB3 db32 = null;
        if (db3 == null) {
            AbstractC13042fc3.y("messagesEngine");
            db3 = null;
        }
        J44 j443 = (J44) db3.a(jI);
        if (j443 == null) {
            C4275El c4275El = this.L;
            if (c4275El == null) {
                AbstractC13042fc3.y("albumToMessageIdDataSource");
                c4275El = null;
            }
            Long lC = c4275El.c(this.n.u(), AbstractC4616Fw7.a(Long.valueOf(c3460AzH.i()), Long.valueOf(c3460AzH.h())));
            if (lC != null) {
                long jLongValue = lC.longValue();
                DB3 db33 = this.G;
                if (db33 == null) {
                    AbstractC13042fc3.y("messagesEngine");
                } else {
                    db32 = db33;
                }
                j442 = (J44) db32.a(jLongValue);
            }
            if (j442 == null) {
                return j44;
            }
            AbstractC17457n0 abstractC17457n0F = j442.F();
            AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
            C11907dl c11907dl = (C11907dl) abstractC17457n0F;
            List listR = c11907dl.r();
            if (!(listR instanceof Collection) || !listR.isEmpty()) {
                Iterator it = listR.iterator();
                while (it.hasNext()) {
                    if (((J44) it.next()).i() == c3460AzH.i()) {
                        j443 = (J44) AbstractC15401jX0.C0(c11907dl.r());
                    }
                }
            }
            return j44;
        }
        if (i >= this.J) {
            return S;
        }
        if (!this.I.contains(Long.valueOf(j44.i()))) {
            this.I.add(Long.valueOf(j44.i()));
        }
        return L1(j443, i + 1);
    }

    private final C6517Nv5 L2(final C11458d25 c11458d25, final InterfaceC21893uJ4 interfaceC21893uJ4) {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C6517Nv5 c6517Nv5M0 = interfaceC8344Vo3.a(c11458d25.u()).H(new InterfaceC17569nB2() { // from class: ir.nasim.Sm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.M2(this.a, c11458d25, (C4778Gn1) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Tm1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.P2(this.a, c11458d25, interfaceC21893uJ4, (C10872cL4) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    private final List M1(List list) {
        C8455Wa6 c8455Wa6A;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            DB3 db3 = this.G;
            if (db3 == null) {
                AbstractC13042fc3.y("messagesEngine");
                db3 = null;
            }
            J44 j44 = (J44) db3.a(jLongValue);
            if (j44 != null && (c8455Wa6A = C8455Wa6.h.a(j44)) != null) {
                long jA = c8455Wa6A.a();
                long jB = c8455Wa6A.b();
                long jC = c8455Wa6A.c();
                PFMTransaction pFMTransactionD = c8455Wa6A.d();
                if (pFMTransactionD.getTransactionType() != null) {
                    arrayList.add(PfmStruct$PfmTransactionId.newBuilder().A(jA).C(jB).B(jC).D(AbstractC19488qR4.b(pFMTransactionD.getTransactionType())).a());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 M2(final C24539yn1 c24539yn1, final C11458d25 c11458d25, C4778Gn1 c4778Gn1) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(c4778Gn1, "state");
        final long jW = c4778Gn1.W();
        final int iU = c4778Gn1.U();
        final long jV = c4778Gn1.V();
        final long jR = c4778Gn1.R();
        final boolean zG0 = c4778Gn1.g0();
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.an1
            @Override // java.lang.Runnable
            public final void run() {
                C24539yn1.N2(c11458d25, jW, jV, jR, iU, zG0);
            }
        });
        return jW != -1 ? c24539yn1.l2(EnumC11636dL4.LAST_VISITED_MESSAGE, c11458d25, jV, jW, iU, true) : zG0 ? c24539yn1.l2(EnumC11636dL4.LAST_READ_MESSAGE, c11458d25, -1L, jR, 0, true) : c24539yn1.E2().h0(new InterfaceC17569nB2() { // from class: ir.nasim.bn1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.O2(this.a, (C14505i18) obj);
            }
        });
    }

    private final C6517Nv5 N1(final J44 j44, final EnumC15083iz enumC15083iz) {
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(new ArrayList());
        int i = f.a[enumC15083iz.ordinal()];
        DB3 db3 = null;
        if (i == 1) {
            DB3 db32 = this.G;
            if (db32 == null) {
                AbstractC13042fc3.y("messagesEngine");
            } else {
                db3 = db32;
            }
            c6517Nv5L0 = db3.f(j44.h(), EnumC24659yz5.a).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dn1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C24539yn1.P1(this.a, j44, enumC15083iz, (List) obj);
                }
            });
        } else if (i == 2) {
            DB3 db33 = this.G;
            if (db33 == null) {
                AbstractC13042fc3.y("messagesEngine");
            } else {
                db3 = db33;
            }
            c6517Nv5L0 = db3.f(j44.h(), EnumC24659yz5.b).m0(new InterfaceC24449ye1() { // from class: ir.nasim.cn1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C24539yn1.O1(this.a, j44, enumC15083iz, (List) obj);
                }
            });
        } else if (i == 3) {
            DB3 db34 = this.G;
            if (db34 == null) {
                AbstractC13042fc3.y("messagesEngine");
            } else {
                db3 = db34;
            }
            c6517Nv5L0 = db3.f(j44.h(), EnumC24659yz5.b).m0(new InterfaceC24449ye1() { // from class: ir.nasim.en1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C24539yn1.Q1(this.a, j44, enumC15083iz, (List) obj);
                }
            }).G(new InterfaceC17569nB2() { // from class: ir.nasim.fn1
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C24539yn1.R1(this.a, j44, (Exception) obj);
                }
            }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.gn1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C24539yn1.S1(this.a, j44, enumC15083iz, (List) obj);
                }
            });
        }
        c6517Nv5L0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.hn1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.T1(this.a, (List) obj);
            }
        });
        C6517Nv5 c6517Nv5H = c6517Nv5L0.H(new InterfaceC17569nB2() { // from class: ir.nasim.jn1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.U1((List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N2(C11458d25 c11458d25, long j, long j2, long j3, int i, boolean z) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        C19406qI3.a("OpenHistoryLog", " performOpenHistory : with peer " + c11458d25 + ", and uniqueId : " + c11458d25.u() + "\n lastVisitedMessageSortDate :  " + j + "\n lastVisitedMessageRid :  " + j2 + "\n lastReadMessageDate :  " + j3 + "\n lastVisitedMessageOffset :  " + i + "\n hasUnreadCount :  " + z, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(C24539yn1 c24539yn1, J44 j44, EnumC15083iz enumC15083iz, List list) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        c24539yn1.t2(j44, enumC15083iz, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10872cL4 O2(C24539yn1 c24539yn1, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        J44 j44 = (J44) c24539yn1.p.r();
        return j44 != null ? new C10872cL4(EnumC11636dL4.LAST_MESSAGE, j44.i(), j44.W()) : new C10872cL4(EnumC11636dL4.HISTORY_EMPTY, 0L, Long.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(C24539yn1 c24539yn1, J44 j44, EnumC15083iz enumC15083iz, List list) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        c24539yn1.t2(j44, enumC15083iz, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(final C24539yn1 c24539yn1, C11458d25 c11458d25, final InterfaceC21893uJ4 interfaceC21893uJ4, final C10872cL4 c10872cL4) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        InterfaceC8344Vo3 interfaceC8344Vo3 = c24539yn1.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        interfaceC8344Vo3.a(c11458d25.u()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Ym1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.Q2(this.a, interfaceC21893uJ4, c10872cL4, (C4778Gn1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(C24539yn1 c24539yn1, J44 j44, EnumC15083iz enumC15083iz, List list) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        c24539yn1.z1();
        c24539yn1.t2(j44, enumC15083iz, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q2(C24539yn1 c24539yn1, InterfaceC21893uJ4 interfaceC21893uJ4, C10872cL4 c10872cL4, C4778Gn1 c4778Gn1) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c4778Gn1, "state");
        boolean zIsEmpty = c24539yn1.p.isEmpty();
        if (c4778Gn1.h0() != zIsEmpty) {
            InterfaceC8344Vo3 interfaceC8344Vo3 = c24539yn1.w;
            if (interfaceC8344Vo3 == null) {
                AbstractC13042fc3.y("conversationStates");
                interfaceC8344Vo3 = null;
            }
            interfaceC8344Vo3.e(c4778Gn1.y(zIsEmpty));
        }
        if (interfaceC21893uJ4 != null) {
            AbstractC13042fc3.f(c10872cL4);
            interfaceC21893uJ4.a(c10872cL4, c4778Gn1.Q(), c4778Gn1.R(), c4778Gn1.c0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 R1(C24539yn1 c24539yn1, J44 j44, Exception exc) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        DB3 db3 = c24539yn1.G;
        if (db3 == null) {
            AbstractC13042fc3.y("messagesEngine");
            db3 = null;
        }
        return db3.f(j44.h(), EnumC24659yz5.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R2(final C24539yn1 c24539yn1, C11458d25 c11458d25, final InterfaceC21893uJ4 interfaceC21893uJ4, final C10872cL4 c10872cL4) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        InterfaceC8344Vo3 interfaceC8344Vo3 = c24539yn1.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        interfaceC8344Vo3.a(c11458d25.u()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Zm1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.S2(this.a, interfaceC21893uJ4, c10872cL4, (C4778Gn1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(C24539yn1 c24539yn1, J44 j44, EnumC15083iz enumC15083iz, List list) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        c24539yn1.t2(j44, enumC15083iz, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S2(C24539yn1 c24539yn1, InterfaceC21893uJ4 interfaceC21893uJ4, C10872cL4 c10872cL4, C4778Gn1 c4778Gn1) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c4778Gn1, "state");
        boolean zIsEmpty = c24539yn1.p.isEmpty();
        if (c4778Gn1.h0() != zIsEmpty) {
            InterfaceC8344Vo3 interfaceC8344Vo3 = c24539yn1.w;
            if (interfaceC8344Vo3 == null) {
                AbstractC13042fc3.y("conversationStates");
                interfaceC8344Vo3 = null;
            }
            interfaceC8344Vo3.e(c4778Gn1.y(zIsEmpty));
        }
        if (interfaceC21893uJ4 != null) {
            AbstractC13042fc3.f(c10872cL4);
            interfaceC21893uJ4.a(c10872cL4, c4778Gn1.Q(), c4778Gn1.R(), c4778Gn1.c0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(C24539yn1 c24539yn1, List list) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        c24539yn1.z1();
    }

    private final void T2(C11458d25 c11458d25) {
        if (c11458d25 == null) {
            return;
        }
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        interfaceC8344Vo3.a(c11458d25.u()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.wn1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.U2(this.a, (C4778Gn1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 U1(List list) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(C24539yn1 c24539yn1, C4778Gn1 c4778Gn1) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        C4778Gn1 c4778Gn1G = c4778Gn1.G(-1L, -1L, 0);
        InterfaceC8344Vo3 interfaceC8344Vo3 = c24539yn1.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        interfaceC8344Vo3.e(c4778Gn1G);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v23, types: [ir.nasim.J44, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [ir.nasim.J44, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6 */
    private final void V1(C11458d25 c11458d25, C11458d25 c11458d252, AbacusOuterClass$ResponseGetMessagesReactions abacusOuterClass$ResponseGetMessagesReactions) {
        ?? J1;
        int i;
        XV4 xv4;
        ArrayList arrayList = new ArrayList();
        for (MessagingStruct$ReactionContainer messagingStruct$ReactionContainer : abacusOuterClass$ResponseGetMessagesReactions.getContainersList()) {
            int i2 = 0;
            if (c11458d252 != null && (xv4 = (XV4) this.A.get(AbstractC4616Fw7.a(c11458d252, AbstractC4616Fw7.a(Long.valueOf(messagingStruct$ReactionContainer.getRid()), Long.valueOf(messagingStruct$ReactionContainer.getDate()))))) != null) {
                C11458d25 c11458d253 = (C11458d25) xv4.e();
                XV4 xv42 = (XV4) xv4.f();
                long jLongValue = ((Number) xv42.a()).longValue();
                long jLongValue2 = ((Number) xv42.b()).longValue();
                J44 j44 = (J44) this.m.G().H0(c11458d253).a(jLongValue);
                if (j44 != null) {
                    AbstractC13042fc3.f(messagingStruct$ReactionContainer);
                    arrayList.add(AbstractC4616Fw7.a(c11458d253, AbstractC3827Cn1.k(j44, messagingStruct$ReactionContainer)));
                } else {
                    ?? J12 = J1(jLongValue, jLongValue2);
                    if ((J12 != 0 ? J12.F() : null) instanceof C11907dl) {
                        Iterator it = arrayList.iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i3 = -1;
                                break;
                            }
                            XV4 xv43 = (XV4) it.next();
                            if (AbstractC13042fc3.d(xv43.e(), c11458d253) && AbstractC13042fc3.d(xv43.f(), J12)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (i3 >= 0) {
                            J12 = ((XV4) arrayList.remove(i3)).f();
                        }
                        J44 j442 = (J44) J12;
                        if (j442 != null) {
                            AbstractC13042fc3.f(messagingStruct$ReactionContainer);
                            J44 j44I = AbstractC3827Cn1.i(j442, jLongValue, jLongValue2, messagingStruct$ReactionContainer);
                            if (j44I != null) {
                                arrayList.add(AbstractC4616Fw7.a(c11458d253, j44I));
                            }
                        }
                    }
                }
            }
            J44 j443 = (J44) this.p.a(messagingStruct$ReactionContainer.getRid());
            if (j443 != null) {
                AbstractC13042fc3.f(messagingStruct$ReactionContainer);
                arrayList.add(AbstractC4616Fw7.a(c11458d25, AbstractC3827Cn1.k(j443, messagingStruct$ReactionContainer)));
            } else if (!this.r && (J1 = J1(messagingStruct$ReactionContainer.getRid(), messagingStruct$ReactionContainer.getDate())) != 0 && (J1.F() instanceof C11907dl)) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    }
                    XV4 xv44 = (XV4) it2.next();
                    if (AbstractC13042fc3.d(xv44.e(), c11458d25) && AbstractC13042fc3.d(xv44.f(), J1)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i >= 0) {
                    J1 = ((XV4) arrayList.remove(i)).f();
                }
                long rid = messagingStruct$ReactionContainer.getRid();
                long date = messagingStruct$ReactionContainer.getDate();
                AbstractC13042fc3.f(messagingStruct$ReactionContainer);
                arrayList.add(AbstractC4616Fw7.a(c11458d25, AbstractC3827Cn1.i((J44) J1, rid, date, messagingStruct$ReactionContainer)));
            }
        }
        ArrayList<XV4> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!(((J44) ((XV4) obj).f()).F() instanceof C5331Iw5)) {
                arrayList2.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (XV4 xv45 : arrayList2) {
            C11458d25 c11458d254 = (C11458d25) xv45.e();
            Object arrayList3 = linkedHashMap.get(c11458d254);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(c11458d254, arrayList3);
            }
            ((List) arrayList3).add((J44) xv45.f());
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (!((Collection) entry.getValue()).isEmpty()) {
                if (!this.r || this.m.G().F0() == null) {
                    this.m.G().H0((C11458d25) entry.getKey()).c((List) entry.getValue());
                } else {
                    DB3 db3F0 = this.m.G().F0();
                    if (db3F0 != null) {
                        db3F0.c((List) entry.getValue());
                    }
                }
            }
        }
    }

    private final void V2() {
        this.K = false;
    }

    private final InterfaceC13730gj3 W1() {
        return AbstractC10533bm0.d(this.q, this.o, null, new g(null), 2, null);
    }

    private final boolean W2(List list) {
        List listE;
        ReentrantReadWriteLock.ReadLock lock = this.y.readLock();
        lock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                J44 j44 = (J44) it.next();
                AbstractC17457n0 abstractC17457n0F = j44.F();
                C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
                if (c11907dl == null || (listE = c11907dl.r()) == null) {
                    listE = AbstractC9766aX0.e(j44);
                }
                AbstractC13610gX0.D(arrayList, listE);
            }
            boolean zAddAll = this.z.addAll(arrayList);
            lock.unlock();
            return zAddAll;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    private final C6517Nv5 X1(UK4 uk4) {
        J44 j44;
        C17532n74 c17532n74T;
        this.B = uk4.d();
        this.C = uk4.a();
        final C12280eL5 c12280eL5 = new C12280eL5();
        c12280eL5.a = uk4.a();
        EnumC15083iz enumC15083iz = EnumC15083iz.FORWARD;
        final C12280eL5 c12280eL52 = new C12280eL5();
        c12280eL52.a = uk4.d();
        final C12889fL5 c12889fL5 = new C12889fL5();
        final C12889fL5 c12889fL52 = new C12889fL5();
        final C11637dL5 c11637dL5 = new C11637dL5();
        if (uk4.c().b() != 0 && (j44 = (J44) this.m.G().H0(C11458d25.y(uk4.c().a())).a(uk4.c().c())) != null && (c17532n74T = j44.T()) != null) {
            if (c17532n74T.z().h() != 0) {
                c12889fL5.a = Long.valueOf(c17532n74T.z().h());
                c12280eL5.a = c17532n74T.z().h();
            }
            c11637dL5.a = c17532n74T.C();
            if (c17532n74T.y() != 0) {
                c12889fL52.a = Long.valueOf(c17532n74T.y());
            }
            if (c17532n74T.z().i() != 0) {
                c12280eL52.a = c17532n74T.z().i();
                enumC15083iz = EnumC15083iz.BOTH;
            }
        }
        E1(uk4.b());
        long j = c12280eL5.a;
        C6517Nv5 c6517Nv5Z = a2(j, c12889fL5.a == null ? EnumC15083iz.BACKWARD : enumC15083iz, g1(j, enumC15083iz)).H(new InterfaceC17569nB2() { // from class: ir.nasim.Fm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.Y1(c12889fL5, c12889fL52, c12280eL52, c12280eL5, c11637dL5, (C4382Ew7) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.Gm1
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C24539yn1.Z1(this.a, (C10872cL4) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    private final boolean X2(J44 j44) {
        return Y2(j44) || Z2(j44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Y1(C12889fL5 c12889fL5, C12889fL5 c12889fL52, C12280eL5 c12280eL5, C12280eL5 c12280eL52, C11637dL5 c11637dL5, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c12889fL5, "$scrollDate");
        AbstractC13042fc3.i(c12889fL52, "$lastReadDate");
        AbstractC13042fc3.i(c12280eL5, "$rid");
        AbstractC13042fc3.i(c12280eL52, "$date");
        AbstractC13042fc3.i(c11637dL5, "$scrollOffset");
        Object obj = c12889fL5.a;
        return C6517Nv5.l0(new C10872cL4((obj == null && c12889fL52.a == null) ? EnumC11636dL4.SPECIFIC_MESSAGE : EnumC11636dL4.LAST_VISITED_MESSAGE, obj == null ? R.i() : c12280eL5.a, c12889fL5.a == null ? R.h() : c12280eL52.a, c11637dL5.a));
    }

    private final boolean Y2(J44 j44) {
        DB3 db3 = this.G;
        if (db3 == null) {
            AbstractC13042fc3.y("messagesEngine");
            db3 = null;
        }
        J44 j442 = (J44) db3.m();
        if (j44.h() == this.O || !AbstractC13042fc3.d(j44, j442)) {
            return false;
        }
        this.O = j442.h();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(C24539yn1 c24539yn1, C10872cL4 c10872cL4, Exception exc) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        c24539yn1.v = false;
    }

    private final boolean Z2(J44 j44) {
        C3460Az c3460AzH = AbstractC3827Cn1.h(j44.O());
        if (c3460AzH == null) {
            return false;
        }
        long jI = c3460AzH.i();
        DB3 db3 = this.G;
        J44 j442 = null;
        DB3 db32 = null;
        if (db3 == null) {
            AbstractC13042fc3.y("messagesEngine");
            db3 = null;
        }
        if (((J44) db3.a(jI)) != null) {
            return false;
        }
        C4275El c4275El = this.L;
        if (c4275El == null) {
            AbstractC13042fc3.y("albumToMessageIdDataSource");
            c4275El = null;
        }
        Long lC = c4275El.c(this.n.u(), AbstractC4616Fw7.a(Long.valueOf(c3460AzH.i()), Long.valueOf(c3460AzH.h())));
        if (lC != null) {
            long jLongValue = lC.longValue();
            DB3 db33 = this.G;
            if (db33 == null) {
                AbstractC13042fc3.y("messagesEngine");
            } else {
                db32 = db33;
            }
            j442 = (J44) db32.a(jLongValue);
        }
        return j442 == null;
    }

    private final C6517Nv5 a2(final long j, final EnumC15083iz enumC15083iz, C6517Nv5 c6517Nv5) {
        C6517Nv5 c6517Nv5Z = c6517Nv5.H(new InterfaceC17569nB2() { // from class: ir.nasim.Lm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.c2(this.a, (UF3) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.Nm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.d2(this.a, (UF3) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.Om1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.e2(this.a, (UF3) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.Pm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.f2(this.a, j, enumC15083iz, (UF3) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.Qm1
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C24539yn1.g2(this.a, j, (C4382Ew7) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    private final boolean a3(J44 j44) {
        C3460Az c3460AzH = AbstractC3827Cn1.h(j44.N());
        if (c3460AzH == null) {
            return false;
        }
        long jI = c3460AzH.i();
        DB3 db3 = this.G;
        J44 j442 = null;
        DB3 db32 = null;
        if (db3 == null) {
            AbstractC13042fc3.y("messagesEngine");
            db3 = null;
        }
        if (((J44) db3.a(jI)) != null) {
            return false;
        }
        C4275El c4275El = this.L;
        if (c4275El == null) {
            AbstractC13042fc3.y("albumToMessageIdDataSource");
            c4275El = null;
        }
        Long lC = c4275El.c(this.n.u(), AbstractC4616Fw7.a(Long.valueOf(c3460AzH.i()), Long.valueOf(c3460AzH.h())));
        if (lC != null) {
            long jLongValue = lC.longValue();
            DB3 db33 = this.G;
            if (db33 == null) {
                AbstractC13042fc3.y("messagesEngine");
            } else {
                db32 = db33;
            }
            j442 = (J44) db32.a(jLongValue);
        }
        return j442 == null;
    }

    static /* synthetic */ C6517Nv5 b2(C24539yn1 c24539yn1, long j, EnumC15083iz enumC15083iz, C6517Nv5 c6517Nv5, int i, Object obj) {
        if ((i & 4) != 0) {
            c6517Nv5 = c24539yn1.r ? c24539yn1.g1(j, enumC15083iz) : c24539yn1.i1(j, enumC15083iz);
        }
        return c24539yn1.a2(j, enumC15083iz, c6517Nv5);
    }

    private final void b3() {
        if (this.N || !this.r) {
            return;
        }
        this.N = true;
        AbstractC10533bm0.d(this.q, null, null, new h(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 c2(C24539yn1 c24539yn1, UF3 uf3) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(uf3, "r");
        return C6517Nv5.l0(new UF3(AbstractC3827Cn1.g(uf3.c(), c24539yn1.s, c24539yn1.t), uf3.e(), uf3.d(), uf3.b(), uf3.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 d2(C24539yn1 c24539yn1, UF3 uf3) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(uf3, "r");
        return c24539yn1.m.V().R(uf3.e(), uf3.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 e2(C24539yn1 c24539yn1, UF3 uf3) {
        List listM;
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(uf3, "r");
        ArrayList arrayList = new ArrayList();
        Iterator it = uf3.c().iterator();
        while (it.hasNext()) {
            C17532n74 c17532n74T = ((J44) it.next()).T();
            if (c17532n74T == null || (listM = c17532n74T.D()) == null) {
                listM = AbstractC10360bX0.m();
            }
            arrayList.addAll(listM);
        }
        return c24539yn1.m.V().s0(AbstractC15401jX0.R0(uf3.d(), arrayList), uf3.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 f2(C24539yn1 c24539yn1, long j, EnumC15083iz enumC15083iz, UF3 uf3) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        AbstractC13042fc3.i(uf3, "responseLoadHistory");
        C19406qI3.a(c24539yn1.u, "Loading finished, PeerUniqueId: " + c24539yn1.n.u() + " date: " + j, new Object[0]);
        return c24539yn1.k1(uf3.c(), P.c(enumC15083iz));
    }

    private final C6517Nv5 g1(long j, EnumC15083iz enumC15083iz) {
        MessagingOuterClass$RequestLoadReplies messagingOuterClass$RequestLoadReplies = (MessagingOuterClass$RequestLoadReplies) MessagingOuterClass$RequestLoadReplies.newBuilder().D((PeersStruct$ExPeer) PeersStruct$ExPeer.newBuilder().B(this.n.getPeerId()).C(EnumC10088b35.ExPeerType_GROUP).A(0L).a()).A(j).E((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().B(this.B).A(this.C).a()).B(this.s).C(D1(enumC15083iz)).a();
        AbstractC13042fc3.f(messagingOuterClass$RequestLoadReplies);
        MessagingOuterClass$ResponseLoadReplies defaultInstance = MessagingOuterClass$ResponseLoadReplies.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = L(new C22871vx5("/bale.messaging.v2.Messaging/LoadReplies", messagingOuterClass$RequestLoadReplies, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.Cm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.h1(this.a, (MessagingOuterClass$ResponseLoadReplies) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(final C24539yn1 c24539yn1, final long j, final C4382Ew7 c4382Ew7, final Exception exc) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.mn1
            @Override // java.lang.Runnable
            public final void run() {
                C24539yn1.h2(this.a, j, c4382Ew7, exc);
            }
        });
        if (exc != null) {
            C19406qI3.c(c24539yn1.u, "Load History Failed!!  sortDate: " + j, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 h1(C24539yn1 c24539yn1, MessagingOuterClass$ResponseLoadReplies messagingOuterClass$ResponseLoadReplies) {
        Object next;
        J44 j44W1;
        C3460Az c3460AzO;
        C3460Az c3460AzO2;
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(messagingOuterClass$ResponseLoadReplies, "r");
        List<MessagingStruct$MessageContainer> historyList = messagingOuterClass$ResponseLoadReplies.getHistoryList();
        AbstractC13042fc3.h(historyList, "getHistoryList(...)");
        ArrayList arrayList = new ArrayList();
        for (MessagingStruct$MessageContainer messagingStruct$MessageContainer : historyList) {
            AbstractC13042fc3.f(messagingStruct$MessageContainer);
            J44 j44L = C18732p92.L(messagingStruct$MessageContainer);
            if (j44L != null) {
                arrayList.add(j44L);
            }
        }
        List listG = AbstractC3827Cn1.g(arrayList, c24539yn1.s, c24539yn1.t);
        Iterator it = listG.iterator();
        Object next2 = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long jH = ((J44) next).h();
                do {
                    Object next3 = it.next();
                    long jH2 = ((J44) next3).h();
                    if (jH > jH2) {
                        next = next3;
                        jH = jH2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        J44 j44 = (J44) next;
        if (j44 != null && (j44.O() == null || ((c3460AzO = j44.O()) != null && c3460AzO.i() == 0 && (c3460AzO2 = j44.O()) != null && c3460AzO2.h() == 0))) {
            List list = listG;
            J44 j442 = c24539yn1.E;
            J44 j443 = c24539yn1.D;
            if (j443 == null) {
                j44W1 = null;
            } else {
                AbstractC13042fc3.f(j443);
                C3460Az c3460Az = new C3460Az(j44.h(), j44.i(), 0L);
                J44 j444 = c24539yn1.D;
                j44W1 = c24539yn1.w1(j443, c3460Az, j444 != null ? j444.O() : null);
            }
            listG = AbstractC15401jX0.p1(AbstractC15401jX0.R0(list, AbstractC15401jX0.n0(AbstractC10360bX0.g(j442, j44W1))));
            listG.remove(j44);
            J44 j445 = c24539yn1.D;
            if (j445 != null) {
                listG.add(c24539yn1.w1(j44, j44.N(), new C3460Az(j445.h(), j445.i(), 0L)));
            }
        }
        if (j44 == null) {
            listG = AbstractC15401jX0.R0(listG, AbstractC15401jX0.n0(AbstractC10360bX0.g(c24539yn1.E, c24539yn1.D)));
        }
        List list2 = listG;
        if (!c24539yn1.N) {
            Iterator it2 = list2.iterator();
            if (it2.hasNext()) {
                next2 = it2.next();
                if (it2.hasNext()) {
                    long jH3 = ((J44) next2).h();
                    do {
                        Object next4 = it2.next();
                        long jH4 = ((J44) next4).h();
                        if (jH3 < jH4) {
                            next2 = next4;
                            jH3 = jH4;
                        }
                    } while (it2.hasNext());
                }
            }
            J44 j446 = (J44) next2;
            if (j446 != null && j446.N() == null) {
                c24539yn1.b3();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }
        List<UsersStruct$User> usersList = messagingOuterClass$ResponseLoadReplies.getUsersList();
        AbstractC13042fc3.h(usersList, "getUsersList(...)");
        List<UsersStruct$User> list3 = usersList;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
        for (UsersStruct$User usersStruct$User : list3) {
            AbstractC13042fc3.f(usersStruct$User);
            arrayList2.add(C18732p92.d(usersStruct$User));
        }
        List<PeersStruct$UserOutPeer> userPeersList = messagingOuterClass$ResponseLoadReplies.getUserPeersList();
        AbstractC13042fc3.h(userPeersList, "getUserPeersList(...)");
        List<PeersStruct$UserOutPeer> list4 = userPeersList;
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(list4, 10));
        for (PeersStruct$UserOutPeer peersStruct$UserOutPeer : list4) {
            C18732p92 c18732p92 = C18732p92.a;
            AbstractC13042fc3.f(peersStruct$UserOutPeer);
            arrayList3.add(c18732p92.w1(peersStruct$UserOutPeer));
        }
        return C6517Nv5.l0(new UF3(list2, arrayList2, arrayList3, AbstractC10360bX0.m(), AbstractC10360bX0.m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(C24539yn1 c24539yn1, long j, C4382Ew7 c4382Ew7, Exception exc) {
        String str;
        AbstractC13042fc3.i(c24539yn1, "this$0");
        String str2 = c24539yn1.u;
        long jU = c24539yn1.n.u();
        String str3 = "";
        if (c4382Ew7 != null) {
            str = " T1: " + c4382Ew7.a() + " T2: " + c4382Ew7.b();
        } else {
            str = "";
        }
        if (exc != null) {
            str3 = " ErrorMessage: " + exc.getMessage();
        }
        C19406qI3.a(str2, "Loading finished, PeerUniqueId: " + jU + " date: " + j + str + str3, new Object[0]);
    }

    private final C6517Nv5 i1(final long j, final EnumC15083iz enumC15083iz) {
        C19406qI3.j(this.u, "goes for load history: peer: " + this.n + " date: " + j + " direction: " + enumC15083iz + " pageSize: " + this.s, new Object[0]);
        C6517Nv5 c6517Nv5M0 = O(new ST5(this.m.n(this.n), j, enumC15083iz, this.s, PC.c), 30000L).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Um1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return new UF3((VZ5) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Vm1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.j1(this.a, j, enumC15083iz, (UF3) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    private final C6517Nv5 i2(long j, EnumC15083iz enumC15083iz, C6517Nv5 c6517Nv5) {
        C6517Nv5 c6517Nv5H = c6517Nv5.H(new InterfaceC17569nB2() { // from class: ir.nasim.on1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.k2(this.a, (UF3) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(C24539yn1 c24539yn1, long j, EnumC15083iz enumC15083iz, UF3 uf3) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        String str = c24539yn1.u;
        C11458d25 c11458d25 = c24539yn1.n;
        int size = uf3.c().size();
        J44 j44 = (J44) AbstractC15401jX0.s0(uf3.c());
        Long lValueOf = j44 != null ? Long.valueOf(j44.h()) : null;
        J44 j442 = (J44) AbstractC15401jX0.F0(uf3.c());
        C19406qI3.j(str, "load history ended: peer: " + c11458d25 + ", date: " + j + ", direction: " + enumC15083iz + ", historySize: " + size + ", firstDate: " + lValueOf + ", lastDate: " + (j442 != null ? Long.valueOf(j442.h()) : null), new Object[0]);
    }

    static /* synthetic */ C6517Nv5 j2(C24539yn1 c24539yn1, long j, EnumC15083iz enumC15083iz, C6517Nv5 c6517Nv5, int i, Object obj) {
        if ((i & 4) != 0) {
            c6517Nv5 = c24539yn1.r ? c24539yn1.g1(j, enumC15083iz) : c24539yn1.i1(j, enumC15083iz);
        }
        return c24539yn1.i2(j, enumC15083iz, c6517Nv5);
    }

    private final C6517Nv5 k1(List list, EnumC24659yz5 enumC24659yz5) {
        if (list.isEmpty()) {
            C19406qI3.a("LoadHistoryKey", "applyHistory for peer : " + this.n.u() + " History is empty so return success", new Object[0]);
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(new C4382Ew7(0, 0));
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        long jMax = 0;
        long jMax2 = 0;
        while (it.hasNext()) {
            J44 j44 = (J44) it.next();
            arrayList.add(j44);
            if (j44.M() == EnumC19769qu4.b) {
                jMax = Math.max(j44.h(), jMax);
            } else if (j44.M() == EnumC19769qu4.c) {
                jMax = Math.max(j44.h(), jMax);
                jMax2 = Math.max(j44.h(), jMax2);
            }
        }
        C6517Nv5 c6517Nv5A = this.m.G().T0().o(this.n, new Y64(arrayList, enumC24659yz5), Long.valueOf(jMax), Long.valueOf(jMax2), false, this.p).m0(new InterfaceC24449ye1() { // from class: ir.nasim.pn1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.l1(this.a, arrayList, (C4382Ew7) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.qn1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.m1((C4382Ew7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5A, "chain(...)");
        return c6517Nv5A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 k2(C24539yn1 c24539yn1, UF3 uf3) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(uf3, "r");
        return C6517Nv5.l0(new UF3(AbstractC3827Cn1.g(uf3.c(), c24539yn1.s, c24539yn1.t), uf3.e(), uf3.d(), uf3.b(), uf3.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(C24539yn1 c24539yn1, ArrayList arrayList, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(arrayList, "$messages");
        c24539yn1.s2(arrayList);
    }

    private final C6517Nv5 l2(final EnumC11636dL4 enumC11636dL4, final C11458d25 c11458d25, final long j, final long j2, final int i, final boolean z) {
        J44 j44;
        if (j != -1) {
            j44 = (J44) this.p.i(j2, j);
            if (j44 == null) {
                C4275El c4275El = this.L;
                if (c4275El == null) {
                    AbstractC13042fc3.y("albumToMessageIdDataSource");
                    c4275El = null;
                }
                Long lC = c4275El.c(c11458d25.u(), AbstractC4616Fw7.a(Long.valueOf(j), Long.valueOf(j2)));
                if (lC != null) {
                    j44 = (J44) this.p.a(lC.longValue());
                } else {
                    j44 = null;
                }
            }
        } else {
            j44 = (J44) this.p.t(j2, false);
        }
        if (j44 == null) {
            C6517Nv5 c6517Nv5H0 = w2(j2).h0(new InterfaceC17569nB2() { // from class: ir.nasim.nn1
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C24539yn1.m2(j, this, j2, z, enumC11636dL4, i, c11458d25, (C14505i18) obj);
                }
            });
            AbstractC13042fc3.f(c6517Nv5H0);
            return c6517Nv5H0;
        }
        C19406qI3.a("OpenHistoryLog", " loadMessage returned from onLoadBySortDateMessage sortDate: " + j2, new Object[0]);
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(new C10872cL4(enumC11636dL4, j44.i(), j44.W(), i));
        AbstractC13042fc3.f(c6517Nv5L0);
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 m1(C4382Ew7 c4382Ew7) {
        return C6517Nv5.l0(c4382Ew7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10872cL4 m2(long j, C24539yn1 c24539yn1, long j2, boolean z, EnumC11636dL4 enumC11636dL4, int i, C11458d25 c11458d25, C14505i18 c14505i18) {
        J44 j44;
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(enumC11636dL4, "$openHistoryType");
        AbstractC13042fc3.i(c11458d25, "$peer");
        InterfaceC8344Vo3 interfaceC8344Vo3 = null;
        if (j != -1) {
            j44 = (J44) c24539yn1.p.i(j2, j);
            if (j44 == null) {
                C4275El c4275El = c24539yn1.L;
                if (c4275El == null) {
                    AbstractC13042fc3.y("albumToMessageIdDataSource");
                    c4275El = null;
                }
                Long lC = c4275El.c(c11458d25.u(), AbstractC4616Fw7.a(Long.valueOf(j), Long.valueOf(j2)));
                if (lC != null) {
                    j44 = (J44) c24539yn1.p.a(lC.longValue());
                } else {
                    j44 = null;
                }
            }
        } else {
            j44 = (J44) c24539yn1.p.t(j2, z);
        }
        if (j44 != null) {
            C19406qI3.a("OpenHistoryLog", " loadMessage returned from second onLoadBySortDateMessage sortDate: " + j44.W(), new Object[0]);
            return new C10872cL4(enumC11636dL4, j44.i(), j44.W(), i);
        }
        J44 j442 = (J44) c24539yn1.p.r();
        if (j442 != null) {
            C19406qI3.j("OpenHistoryLog", " loadMessage based on the last message sortDate: " + j442.W(), new Object[0]);
            return new C10872cL4(EnumC11636dL4.LAST_MESSAGE, j442.i(), j442.W());
        }
        InterfaceC8344Vo3 interfaceC8344Vo32 = c24539yn1.w;
        if (interfaceC8344Vo32 == null) {
            AbstractC13042fc3.y("conversationStates");
        } else {
            interfaceC8344Vo3 = interfaceC8344Vo32;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        C19406qI3.j("OpenHistoryLog", " loadMessage based on the state sortDate: " + c4778Gn1.Q(), new Object[0]);
        return new C10872cL4(EnumC11636dL4.LAST_MESSAGE, 0L, c4778Gn1.Q());
    }

    private final PeersStruct$OutPeer n1(C11458d25 c11458d25) {
        PeersStruct$OutPeer.a aVarNewBuilder = PeersStruct$OutPeer.newBuilder();
        if (c11458d25.s() == W25.a) {
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(c11458d25.getPeerId());
            if (c17637nI7 == null) {
                return null;
            }
            return (PeersStruct$OutPeer) aVarNewBuilder.B(c17637nI7.n0()).A(c17637nI7.getAccessHash()).C(EnumC16311l35.PeerType_PRIVATE).a();
        }
        if (c11458d25.s() == W25.b) {
            C14697iL2 c14697iL2 = (C14697iL2) this.m.E().X1().d(c11458d25.getPeerId());
            if (c14697iL2 == null) {
                return null;
            }
            return (PeersStruct$OutPeer) aVarNewBuilder.B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).C(EnumC16311l35.PeerType_GROUP).a();
        }
        C19406qI3.a(this.u, "Unknown peer: " + c11458d25, new Object[0]);
        return null;
    }

    private final C6517Nv5 n2(J44 j44) {
        J44 j44L1;
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(new C4382Ew7(VF3.d, C6517Nv5.l0(C14505i18.a)));
        if (this.v || this.I.contains(Long.valueOf(j44.i()))) {
            this.H = j44;
            AbstractC13042fc3.f(c6517Nv5L0);
            return c6517Nv5L0;
        }
        this.v = true;
        EnumC15083iz enumC15083izG1 = G1(j44);
        this.H = j44;
        boolean zX2 = X2(j44);
        boolean zA3 = a3(j44);
        if (zX2 && zA3) {
            C6517Nv5 c6517Nv5L02 = C6517Nv5.l0(new C4382Ew7(VF3.c, o1(j44, EnumC15083iz.BOTH)));
            AbstractC13042fc3.h(c6517Nv5L02, "success(...)");
            return c6517Nv5L02;
        }
        if (zX2) {
            C6517Nv5 c6517Nv5L03 = C6517Nv5.l0(new C4382Ew7(VF3.b, o1(j44, EnumC15083iz.BACKWARD)));
            AbstractC13042fc3.h(c6517Nv5L03, "success(...)");
            return c6517Nv5L03;
        }
        if (zA3) {
            C6517Nv5 c6517Nv5L04 = C6517Nv5.l0(new C4382Ew7(VF3.a, o1(j44, EnumC15083iz.FORWARD)));
            AbstractC13042fc3.h(c6517Nv5L04, "success(...)");
            return c6517Nv5L04;
        }
        boolean z = this.K;
        if (z && enumC15083izG1 == EnumC15083iz.BACKWARD) {
            J44 j44K1 = K1(j44, 0);
            if (j44K1 != S) {
                o1(j44K1, enumC15083izG1);
            } else {
                this.v = false;
            }
        } else if (z && enumC15083izG1 == EnumC15083iz.FORWARD && (j44L1 = L1(j44, 0)) != S) {
            o1(j44L1, enumC15083izG1);
        } else {
            this.v = false;
        }
        C19406qI3.a(this.u, "No need to loadMore sortDate: " + j44.W() + ", isMiddleMessage: " + AbstractC3827Cn1.d(j44) + " --> list contains enough messages", new Object[0]);
        return F1();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C6517Nv5 o1(final ir.nasim.J44 r9, final ir.nasim.EnumC15083iz r10) {
        /*
            r8 = this;
            int[] r0 = ir.nasim.C24539yn1.f.a
            int r1 = r10.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L2c
            r1 = 2
            if (r0 == r1) goto L10
            goto L47
        L10:
            ir.nasim.n0 r0 = r9.F()
            boolean r1 = r0 instanceof ir.nasim.C11907dl
            if (r1 == 0) goto L1b
            r2 = r0
            ir.nasim.dl r2 = (ir.nasim.C11907dl) r2
        L1b:
            if (r2 == 0) goto L47
            java.util.List r0 = r2.r()
            if (r0 == 0) goto L47
            java.lang.Object r0 = ir.nasim.ZW0.F0(r0)
            ir.nasim.J44 r0 = (ir.nasim.J44) r0
            if (r0 != 0) goto L48
            goto L47
        L2c:
            ir.nasim.n0 r0 = r9.F()
            boolean r1 = r0 instanceof ir.nasim.C11907dl
            if (r1 == 0) goto L37
            r2 = r0
            ir.nasim.dl r2 = (ir.nasim.C11907dl) r2
        L37:
            if (r2 == 0) goto L47
            java.util.List r0 = r2.r()
            if (r0 == 0) goto L47
            java.lang.Object r0 = ir.nasim.ZW0.s0(r0)
            ir.nasim.J44 r0 = (ir.nasim.J44) r0
            if (r0 != 0) goto L48
        L47:
            r0 = r9
        L48:
            long r3 = r0.W()
            ir.nasim.Nv5 r0 = r8.N1(r9, r10)
            ir.nasim.Hm1 r1 = new ir.nasim.Hm1
            r1.<init>()
            ir.nasim.Nv5 r0 = r0.G(r1)
            ir.nasim.Im1 r7 = new ir.nasim.Im1
            r1 = r7
            r2 = r8
            r5 = r10
            r6 = r9
            r1.<init>()
            ir.nasim.Nv5 r9 = r0.H(r7)
            ir.nasim.Jm1 r10 = new ir.nasim.Jm1
            r10.<init>()
            ir.nasim.Nv5 r9 = r9.z(r10)
            java.lang.String r10 = "after(...)"
            ir.nasim.AbstractC13042fc3.h(r9, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24539yn1.o1(ir.nasim.J44, ir.nasim.iz):ir.nasim.Nv5");
    }

    private final void o2(List list) {
        if (this.n.getPeerId() != 270066638) {
            return;
        }
        GeneratedMessageLite generatedMessageLiteA = PfmOuterClass$RequestFilterTaggedTransactions.newBuilder().A(M1(list)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        PfmOuterClass$ResponseFilterTaggedTransactions defaultInstance = PfmOuterClass$ResponseFilterTaggedTransactions.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.pfm.v1.Pfm/FilterTaggedTransactions", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Xm1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.p2(this.a, (PfmOuterClass$ResponseFilterTaggedTransactions) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 p1(C24539yn1 c24539yn1, J44 j44, EnumC15083iz enumC15083iz, Exception exc) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        C19406qI3.c(c24539yn1.u, "removeGap failed sortDate: " + j44.W() + " and direction: " + enumC15083iz.name(), exc);
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(C24539yn1 c24539yn1, PfmOuterClass$ResponseFilterTaggedTransactions pfmOuterClass$ResponseFilterTaggedTransactions) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(pfmOuterClass$ResponseFilterTaggedTransactions, "response");
        ArrayList arrayList = new ArrayList();
        Iterator<PfmStruct$PfmTransactionId> it = pfmOuterClass$ResponseFilterTaggedTransactions.getIdsWithTagList().iterator();
        while (it.hasNext()) {
            arrayList.add(J44.D((J44) c24539yn1.p.a(it.next().getId()), 0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, true, null, false, null, null, 253951, null));
        }
        c24539yn1.p.c(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 q1(final C24539yn1 c24539yn1, final long j, EnumC15083iz enumC15083iz, final J44 j44, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        AbstractC13042fc3.i(j44, "$message");
        return b2(c24539yn1, j, enumC15083iz, null, 4, null).E(new InterfaceC24449ye1() { // from class: ir.nasim.kn1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.r1(this.a, j, j44, (Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.ln1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.s1((C4382Ew7) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0012 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void q2(java.util.List r13) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24539yn1.q2(java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(C24539yn1 c24539yn1, long j, J44 j44, Exception exc) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(exc, ParameterNames.CAUSE);
        C19406qI3.a(c24539yn1.u, "callLoadHistory failed sortDate: " + j + ", messageSortDate: " + j44.W(), exc);
        c24539yn1.r().d(new C3593Bn1.i(j44));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(C24539yn1 c24539yn1, C11458d25 c11458d25, C11458d25 c11458d252, AbacusOuterClass$ResponseGetMessagesReactions abacusOuterClass$ResponseGetMessagesReactions) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.f(abacusOuterClass$ResponseGetMessagesReactions);
        c24539yn1.V1(c11458d25, c11458d252, abacusOuterClass$ResponseGetMessagesReactions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 s1(C4382Ew7 c4382Ew7) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final void s2(List list) {
        if (C18252oL4.e()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            J44 j44 = (J44) it.next();
            C21191tG3 c21191tG3 = this.M;
            if (c21191tG3 == null) {
                AbstractC13042fc3.y("loadViewsUseCase");
                c21191tG3 = null;
            }
            c21191tG3.s(this.n, j44, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(C24539yn1 c24539yn1, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        c24539yn1.v = false;
    }

    private final void t2(final J44 j44, final EnumC15083iz enumC15083iz, final List list) {
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.rn1
            @Override // java.lang.Runnable
            public final void run() {
                C24539yn1.u2(this.a, j44, enumC15083iz, list);
            }
        });
    }

    private final C6517Nv5 u1(C11458d25 c11458d25, final long j, final long j2, final int i) {
        if (c11458d25 == null) {
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C6517Nv5 c6517Nv5H = interfaceC8344Vo3.a(c11458d25.u()).H(new InterfaceC17569nB2() { // from class: ir.nasim.Dm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.v1(this.a, j, j2, i, (C4778Gn1) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(C24539yn1 c24539yn1, J44 j44, EnumC15083iz enumC15083iz, List list) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(enumC15083iz, "$direction");
        AbstractC13042fc3.i(list, "$removedRids");
        C19406qI3.a(c24539yn1.u, "Removed gap for peer: " + c24539yn1.n + ", on message rid: " + j44.i() + ", date: " + j44.h() + " to direction " + enumC15083iz + ", removed messages count: " + list.size(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 v1(C24539yn1 c24539yn1, long j, long j2, int i, C4778Gn1 c4778Gn1) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        AbstractC13042fc3.i(c4778Gn1, "conversationState");
        InterfaceC8344Vo3 interfaceC8344Vo3 = c24539yn1.w;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        interfaceC8344Vo3.e(c4778Gn1.G(j, j2, i));
        return C6517Nv5.l0(C14505i18.a);
    }

    private final J44 w1(J44 j44, C3460Az c3460Az, C3460Az c3460Az2) {
        return J44.D(j44, 0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, c3460Az2, c3460Az, false, null, false, null, null, 255999, null);
    }

    private final C6517Nv5 w2(final long j) {
        C19406qI3.j(this.u, "onLoadBySortDateMessage, sortDate: " + j, new Object[0]);
        C6517Nv5 c6517Nv5H = b2(this, j, j != Long.MAX_VALUE ? EnumC15083iz.BOTH : EnumC15083iz.BACKWARD, null, 4, null).E(new InterfaceC24449ye1() { // from class: ir.nasim.Bm1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24539yn1.x2(this.a, j, (Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.Mm1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24539yn1.y2((C4382Ew7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final void x1(long j, boolean z) {
        this.p.d(J44.D((J44) this.p.a(j), 0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, z, null, false, null, null, 253951, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(C24539yn1 c24539yn1, long j, Exception exc) {
        AbstractC13042fc3.i(c24539yn1, "this$0");
        if ((exc instanceof RpcException) && AbstractC20762sZ6.X(((RpcException) exc).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "GROUP_IS_PRIVATE", false, 2, null)) {
            C19406qI3.j(c24539yn1.u, "Group is private, Avoid request more LoadBySortDateMessage", new Object[0]);
            return;
        }
        C19406qI3.c(c24539yn1.u, "Failed to loadBySortDate(sortDate=" + j + Separators.RPAREN, exc);
        c24539yn1.r().d(new c(j));
    }

    private final void y1(boolean z) {
        this.K = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 y2(C4382Ew7 c4382Ew7) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final void z1() {
        C19406qI3.a(this.u, "clearLoadHistoryCheckList()", new Object[0]);
        if (!this.I.isEmpty()) {
            this.I.clear();
        }
    }

    private final C6517Nv5 z2() {
        J44 j44 = (J44) this.p.m();
        if (j44 == null || j44.O() != null) {
            C6517Nv5 c6517Nv5H = b2(this, 0L, EnumC15083iz.FORWARD, null, 4, null).H(new InterfaceC17569nB2() { // from class: ir.nasim.Rm1
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C24539yn1.A2((C4382Ew7) obj);
                }
            });
            AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
            return c6517Nv5H;
        }
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    public final EnumC6845Pf4 D1(EnumC15083iz enumC15083iz) {
        AbstractC13042fc3.i(enumC15083iz, "direction");
        int i = f.a[enumC15083iz.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? EnumC6845Pf4.UNRECOGNIZED : EnumC6845Pf4.ListLoadMode_BOTH : EnumC6845Pf4.ListLoadMode_FORWARD : EnumC6845Pf4.ListLoadMode_BACKWARD;
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof C3593Bn1.h) {
            return E2();
        }
        if (obj instanceof C3593Bn1.f) {
            return z2();
        }
        if (obj instanceof C3593Bn1.g) {
            return w2(((C3593Bn1.g) obj).a());
        }
        if (obj instanceof C3593Bn1.l) {
            return B2(((C3593Bn1.l) obj).a());
        }
        if (obj instanceof C10256bL4) {
            return L2(this.n, ((C10256bL4) obj).b);
        }
        if (obj instanceof UK4) {
            return X1((UK4) obj);
        }
        if (obj instanceof C12279eL4) {
            C12279eL4 c12279eL4 = (C12279eL4) obj;
            return K2(this.n, c12279eL4.c(), c12279eL4.a(), c12279eL4.b(), c12279eL4.e);
        }
        if (obj instanceof C3593Bn1.i) {
            return n2(((C3593Bn1.i) obj).a());
        }
        if (obj instanceof C3593Bn1.a) {
            C3593Bn1.a aVar = (C3593Bn1.a) obj;
            return u1(aVar.c(), aVar.d(), aVar.a(), aVar.b());
        }
        if (obj instanceof C3593Bn1.e) {
            C3593Bn1.e eVar = (C3593Bn1.e) obj;
            return H1(eVar.a(), eVar.b());
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.h(c6517Nv5G, "onAsk(...)");
        return c6517Nv5G;
    }

    @Override // ir.nasim.AbstractC6360Ng4, ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        AbstractC13042fc3.i(abstractC18385oa2, "event");
        if (abstractC18385oa2 instanceof C17483n25) {
            r().d(a.a);
        } else {
            super.T(abstractC18385oa2);
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof C3593Bn1.i) {
            n2(((C3593Bn1.i) obj).a());
            return;
        }
        if (obj instanceof C3593Bn1.k) {
            W2(((C3593Bn1.k) obj).a());
            return;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            q2(eVar.a());
            List listA = eVar.a();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listA, 10));
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((J44) it.next()).i()));
            }
            o2(arrayList);
            return;
        }
        if (obj instanceof c) {
            w2(((c) obj).a());
            return;
        }
        if (obj instanceof C3593Bn1.h) {
            E2();
            return;
        }
        if (obj instanceof C3593Bn1.g) {
            D2(((C3593Bn1.g) obj).a());
            return;
        }
        if (obj instanceof C3593Bn1.d) {
            v2(((C3593Bn1.d) obj).a());
            return;
        }
        if (obj instanceof C3593Bn1.j) {
            T2(((C3593Bn1.j) obj).a());
            return;
        }
        if (obj instanceof a) {
            C1();
            return;
        }
        if (obj instanceof C3593Bn1.c) {
            y1(((C3593Bn1.c) obj).a());
        } else if (!(obj instanceof C3593Bn1.b)) {
            super.m(obj);
        } else {
            C3593Bn1.b bVar = (C3593Bn1.b) obj;
            x1(bVar.a(), bVar.b());
        }
    }

    @Override // ir.nasim.AbstractC6360Ng4, ir.nasim.K6
    public void n() {
        super.n();
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.q.getCoroutineContext().a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        this.w = this.m.G().I0().o();
        this.m.a().h(this, "peer_chat_closed");
        this.G = this.p;
        this.x = this.m.S().T2();
        C5721Ko c5721Ko = C5721Ko.a;
        this.L = ((InterfaceC6280My1) C92.a(c5721Ko.d(), InterfaceC6280My1.class)).s0();
        this.M = ((InterfaceC15864kI7) C92.a(c5721Ko.d(), InterfaceC15864kI7.class)).p().a(this.q);
        W1();
    }

    public final void v2(boolean z) {
        DB3 db3 = this.G;
        if (db3 == null) {
            AbstractC13042fc3.y("messagesEngine");
            db3 = null;
        }
        db3.l(z);
        J2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24539yn1(C9057Yh4 c9057Yh4, C11458d25 c11458d25, AbstractC13778go1 abstractC13778go1, DB3 db3, InterfaceC20315ro1 interfaceC20315ro1, boolean z) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(db3, "conversationEngine");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.m = c9057Yh4;
        this.n = c11458d25;
        this.o = abstractC13778go1;
        this.p = db3;
        this.q = interfaceC20315ro1;
        this.r = z;
        int iQ3 = c9057Yh4.S().q3();
        this.s = iQ3;
        this.t = c9057Yh4.S().j0();
        this.u = "ConversationHistoryActor_" + c11458d25.u();
        this.y = new ReentrantReadWriteLock(true);
        this.z = new HashSet();
        this.A = new HashMap();
        this.I = new ArrayList();
        this.J = iQ3;
        this.O = -1L;
    }
}
