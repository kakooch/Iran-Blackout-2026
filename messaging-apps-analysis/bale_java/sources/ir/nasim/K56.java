package ir.nasim;

import ai.bale.proto.AbacusOuterClass$RequestMessageReactionsRead;
import ai.bale.proto.MessagingOuterClass$RequestMentionRead;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C15246jF7;
import ir.nasim.C16342l66;
import ir.nasim.C3593Bn1;
import ir.nasim.C5561Jw1;
import ir.nasim.C6434No6;
import ir.nasim.K56;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.MessageIdentifier;
import ir.nasim.features.root.AbstractC13089g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public final class K56 extends AbstractC6360Ng4 {
    public static final a A = new a(null);
    public static final int B = 8;
    private final C9057Yh4 m;
    private final HashSet n;
    private boolean o;
    private C4275El p;
    private InterfaceC8344Vo3 q;
    private E84 r;
    private OK s;
    private final InterfaceC9173Yu3 t;
    private C6517Nv5 u;
    private final C15246jF7 v;
    private final InterfaceC9173Yu3 w;
    private final InterfaceC9173Yu3 x;
    private final InterfaceC9173Yu3 y;
    private final InterfaceC9173Yu3 z;

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(C11458d25 c11458d25, long j, long j2) {
            AbstractC13042fc3.i(c11458d25, "$peer");
            C23709xO.a.c0(new T74(c11458d25, j, j2));
        }

        public final void b(final C11458d25 c11458d25, final long j, final long j2) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.J56
                @Override // java.lang.Runnable
                public final void run() {
                    K56.a.c(c11458d25, j, j2);
                }
            });
        }

        public final List d(C11458d25 c11458d25, List list, AbstractC17457n0 abstractC17457n0, DB3 db3) {
            List listS;
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(list, "rids");
            AbstractC13042fc3.i(abstractC17457n0, "content");
            AbstractC13042fc3.i(db3, "listEngine");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                J44 j44 = (J44) db3.a(((Number) it.next()).longValue());
                if ((j44 != null ? j44.S() : null) != null && (listS = j44.S()) != null) {
                    Iterator it2 = listS.iterator();
                    while (it2.hasNext()) {
                        J44 j442 = (J44) db3.a(((Number) it2.next()).longValue());
                        if (j442 != null) {
                            C8445Vz5 c8445Vz5Q = j442.Q();
                            arrayList.add(J44.D(j442, 0L, 0L, 0L, 0, null, null, null, 0, c8445Vz5Q == null ? new C8445Vz5(j44.i(), 0, j44.U(), j44.h(), abstractC17457n0, c11458d25, false, null) : c8445Vz5Q.q(abstractC17457n0), null, 0L, null, null, false, null, false, null, null, 261887, null));
                        }
                    }
                }
            }
            return arrayList;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC9196Yx.values().length];
            try {
                iArr2[EnumC9196Yx.BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC9196Yx.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC9196Yx.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC9196Yx.THREAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EnumC9196Yx.CHANNEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[EnumC9196Yx.SUPERGROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            b = iArr2;
        }
    }

    public static final class c implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((C25247zz) obj).h()), Long.valueOf(((C25247zz) obj2).h()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K56(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = new HashSet();
        this.t = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.X46
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return K56.X0();
            }
        });
        this.v = ((InterfaceC14648iF7) C92.a(C5721Ko.a.d(), InterfaceC14648iF7.class)).create();
        this.w = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.i56
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return K56.m3();
            }
        });
        this.x = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.t56
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return K56.Q1();
            }
        });
        this.s = c9057Yh4.T().C();
        b0("sequences_synced");
        this.y = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.C56
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return K56.t1(this.a);
            }
        });
        this.z = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.D56
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return K56.s1(this.a);
            }
        });
    }

    private final void A1(BD7 bd7) {
        j1().x(bd7.c(), bd7.d(), bd7.a(), bd7.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2() {
        C15225jD4.b().c(C15225jD4.k, new Object[0]);
    }

    private final void B1(DD7 dd7) {
        j1().y(dd7.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C6517Nv5 B2(final ir.nasim.C11458d25 r65, long r66, long r68, ir.nasim.C3460Az r70) {
        /*
            Method dump skipped, instructions count: 784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K56.B2(ir.nasim.d25, long, long, ir.nasim.Az):ir.nasim.Nv5");
    }

    private final C6517Nv5 C1(DE7 de7) {
        AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(de7.b());
        final C11458d25 c11458d25C = de7.c();
        E84 e84 = this.r;
        E84 e842 = null;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        AbstractC17902nl0 abstractC17902nl0A = e84.H0(c11458d25C).a(de7.d());
        if (((J44) abstractC17902nl0A) == null) {
            C4275El c4275El = this.p;
            if (c4275El == null) {
                AbstractC13042fc3.y("albumToMessageIdDataSource");
                c4275El = null;
            }
            long jU = c11458d25C.u();
            Long lValueOf = Long.valueOf(de7.d());
            Long lA = de7.a();
            if (lA == null) {
                C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
                AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
                return c6517Nv5L0;
            }
            Long lC = c4275El.c(jU, new XV4(lValueOf, lA));
            if (lC != null) {
                long jLongValue = lC.longValue();
                E84 e843 = this.r;
                if (e843 == null) {
                    AbstractC13042fc3.y("messagesModule");
                } else {
                    e842 = e843;
                }
                abstractC17902nl0A = e842.H0(c11458d25C).a(jLongValue);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }
        J44 j44 = (J44) abstractC17902nl0A;
        if (j44 == null) {
            C6517Nv5 c6517Nv5L02 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L02, "success(...)");
            return c6517Nv5L02;
        }
        AbstractC13042fc3.f(abstractC17457n0H);
        final J44 j44D = J44.D(j44.u(abstractC17457n0H, true), 0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, false, null, null, 245759, null);
        C6517Nv5 c6517Nv5M0 = V0(c11458d25C, j44.i(), j44.h()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.r56
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                K56.D1(this.a, c11458d25C, j44D, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(J44 j44, final C11458d25 c11458d25, C14505i18 c14505i18) {
        AbstractC13042fc3.i(j44, "$updatedMsg");
        AbstractC13042fc3.i(c11458d25, "$peer");
        if (j44.F() instanceof J08) {
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.A56
                @Override // java.lang.Runnable
                public final void run() {
                    K56.D2(c11458d25);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(K56 k56, C11458d25 c11458d25, J44 j44, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(j44, "$updatedMessage");
        k56.t2(c11458d25, AbstractC9766aX0.e(j44));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        C23709xO.a.d0(c11458d25);
    }

    private final void E1(IE7 ie7) {
        MessageIdentifier messageIdentifierB = ie7.b();
        ExPeer exPeerA = ie7.a();
        C11458d25 c11458d25 = new C11458d25(exPeerA.getExPeerType().getPeerType(), exPeerA.getPeerId());
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        List listE0 = c4778Gn1.e0();
        AbstractC13042fc3.h(listE0, "getUnreadReactions(...)");
        List listP1 = AbstractC15401jX0.p1(listE0);
        listP1.add(new Q64(messageIdentifierB.getDate(), messageIdentifierB.getRid(), messageIdentifierB.getSeq(), false));
        C4778Gn1 c4778Gn1M = c4778Gn1.M(AbstractC15401jX0.j0(listP1));
        InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
        if (interfaceC8344Vo33 == null) {
            AbstractC13042fc3.y("conversationStates");
        } else {
            interfaceC8344Vo32 = interfaceC8344Vo33;
        }
        interfaceC8344Vo32.e(c4778Gn1M);
        j1().I(c11458d25, messageIdentifierB.getRid(), messageIdentifierB.getDate());
    }

    private final C6517Nv5 E2(List list, List list2) {
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final C17637nI7 c17637nI7 = (C17637nI7) it.next();
            c6517Nv5L0 = c6517Nv5L0.A(new InterfaceC17569nB2() { // from class: ir.nasim.H56
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return K56.F2(this.a, c17637nI7, (C14505i18) obj);
                }
            });
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            final C14697iL2 c14697iL2 = (C14697iL2) it2.next();
            c6517Nv5L0 = c6517Nv5L0.A(new InterfaceC17569nB2() { // from class: ir.nasim.I56
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return K56.G2(this.a, c14697iL2, (C14505i18) obj);
                }
            });
        }
        AbstractC13042fc3.f(c6517Nv5L0);
        return c6517Nv5L0;
    }

    private final void F1(C15837kF7 c15837kF7) {
        j1().L(c15837kF7.a(), c15837kF7.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 F2(K56 k56, C17637nI7 c17637nI7, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(c17637nI7, "$u");
        return k56.j1().M(c17637nI7);
    }

    private final void G1(AE7 ae7) {
        MessageIdentifier messageIdentifierA = ae7.a();
        ExPeer exPeerB = ae7.b();
        C11458d25 c11458d25 = new C11458d25(exPeerB.getExPeerType().getPeerType(), exPeerB.getPeerId());
        long rid = messageIdentifierA.getRid();
        long date = messageIdentifierA.getDate();
        ExPeerType exPeerType = exPeerB.getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        m2(c11458d25, rid, date, exPeerType, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 G2(K56 k56, C14697iL2 c14697iL2, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        return k56.j1().z(c14697iL2);
    }

    private final void H1(OE7 oe7) {
        MessageIdentifier messageIdentifierB = oe7.b();
        ExPeer exPeerA = oe7.a();
        C11458d25 c11458d25 = new C11458d25(exPeerA.getExPeerType().getPeerType(), exPeerA.getPeerId());
        long rid = messageIdentifierB.getRid();
        long date = messageIdentifierB.getDate();
        ExPeerType exPeerType = exPeerA.getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        n2(c11458d25, rid, date, exPeerType, false);
    }

    private final void H2(C11458d25 c11458d25, Q64 q64, ExPeerType exPeerType) {
        m2(c11458d25, q64.i(), q64.h(), exPeerType, true);
    }

    private final void I1(KE7 ke7) {
        C15246jF7 c15246jF7;
        if (ke7 == null || (c15246jF7 = this.v) == null) {
            return;
        }
        c15246jF7.d(new C15246jF7.c(ke7));
    }

    private final void I2(C11458d25 c11458d25, Q64 q64, ExPeerType exPeerType) {
        n2(c11458d25, q64.i(), q64.h(), exPeerType, true);
    }

    private final void J1(C9611aF7 c9611aF7) {
        C15246jF7 c15246jF7;
        if (c9611aF7 == null || (c15246jF7 = this.v) == null) {
            return;
        }
        c15246jF7.d(new C15246jF7.d(c9611aF7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(K56 k56, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(k56, "this$0");
        X2(k56, false, 1, null);
    }

    private final void K1(EF7 ef7) {
        C6035Lx c6035LxA;
        if (ef7 == null) {
            return;
        }
        if (ef7.b() != null) {
            h3(ef7);
            AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
            if (abstractC13089gK != null) {
                abstractC13089gK.sa(AbstractC12217eE5.error_unknown);
                return;
            }
            return;
        }
        HF7 hf7R1 = r1();
        C11458d25 c11458d25D = ef7.d();
        long jI = ef7.c().i();
        QY1 qy1A = ef7.a();
        if (qy1A == null || (c6035LxA = qy1A.a()) == null) {
            return;
        }
        hf7R1.d(c11458d25D, jI, c6035LxA);
    }

    private final C6517Nv5 K2(List list, boolean z, boolean z2, final boolean z3) {
        C6517Nv5 c6517Nv5A = S2(list, z, z2).A(new InterfaceC17569nB2() { // from class: ir.nasim.p56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.L2(this.a, z3, (C14505i18) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.q56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.M2(this.a, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5A, "chain(...)");
        return c6517Nv5A;
    }

    private final boolean L1(C11458d25 c11458d25) {
        return this.n.contains(c11458d25) && this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 L2(K56 k56, boolean z, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        return k56.P0(z);
    }

    private final boolean M1(C11458d25 c11458d25) {
        return c11458d25.s() == W25.a ? this.m.W().p0().d((long) c11458d25.getPeerId()) != null : c11458d25.s() == W25.b && this.m.E().X1().d((long) c11458d25.getPeerId()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 M2(K56 k56, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        return k56.T2();
    }

    private final void N1(ExPeerType exPeerType) {
        int i = b.a[exPeerType.ordinal()];
        if (i == 1) {
            C17213mb2.j("Bot_open");
        } else if (i == 2) {
            C17213mb2.j("Private_open");
        } else {
            if (i != 4) {
                return;
            }
            C17213mb2.j("Group_open");
        }
    }

    private final void O1(C11458d25 c11458d25, long j, int i) {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        E84 e84 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        if (i != c4778Gn1.c0() || j > c4778Gn1.R()) {
            q2(c11458d25, j, i, 0L);
            E84 e842 = this.r;
            if (e842 == null) {
                AbstractC13042fc3.y("messagesModule");
            } else {
                e84 = e842;
            }
            e84.R0().d(new C5561Jw1.a(c11458d25, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O2(C11458d25 c11458d25, J44 j44, AbstractC20556sC7 abstractC20556sC7, K56 k56, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(k56, "this$0");
        C19406qI3.a("RouterActor", "onNewMessages then with peerId: " + c11458d25.getPeerId() + ", single message", new Object[0]);
        BV0 bv0 = BV0.a;
        CE7 ce7 = (CE7) abstractC20556sC7;
        C9057Yh4 c9057Yh4 = k56.m;
        E84 e84 = k56.r;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        bv0.g(c11458d25, j44, ce7, c9057Yh4, e84);
    }

    private final C6517Nv5 P0(final boolean z) {
        final List listG1 = g1();
        C6517Nv5 c6517Nv5A = S0(listG1).A(new InterfaceC17569nB2() { // from class: ir.nasim.B56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.Q0(z, this, listG1, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5A, "chain(...)");
        return c6517Nv5A;
    }

    private final void P1(C11458d25 c11458d25, boolean z) {
        if (L1(c11458d25) || z) {
            InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
            E84 e84 = null;
            if (interfaceC8344Vo3 == null) {
                AbstractC13042fc3.y("conversationStates");
                interfaceC8344Vo3 = null;
            }
            C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
            E84 e842 = this.r;
            if (e842 == null) {
                AbstractC13042fc3.y("messagesModule");
                e842 = null;
            }
            C17067mL1 c17067mL1 = (C17067mL1) e842.J0().a(c11458d25.u());
            if ((c17067mL1 == null || c17067mL1.Y() <= 0) && c4778Gn1.c0() == 0 && c4778Gn1.R() >= c4778Gn1.Q()) {
                return;
            }
            C4778Gn1 c4778Gn1E = c4778Gn1.u(0).E(c4778Gn1.Q());
            InterfaceC8344Vo3 interfaceC8344Vo32 = this.q;
            if (interfaceC8344Vo32 == null) {
                AbstractC13042fc3.y("conversationStates");
                interfaceC8344Vo32 = null;
            }
            interfaceC8344Vo32.e(c4778Gn1E);
            E84 e843 = this.r;
            if (e843 == null) {
                AbstractC13042fc3.y("messagesModule");
            } else {
                e84 = e843;
            }
            e84.R0().d(new C5561Jw1.a(c11458d25, c4778Gn1E.Q()));
            AbstractC13042fc3.f(c4778Gn1E);
            S1(c11458d25, false, k1(c11458d25, c4778Gn1E), c4778Gn1E.c0());
            j1().q(c11458d25, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(C11458d25 c11458d25, AbstractC20556sC7 abstractC20556sC7, K56 k56, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(k56, "this$0");
        BV0.a.o(c11458d25, ((RE7) abstractC20556sC7).c(), k56.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Q0(boolean z, K56 k56, List list, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(list, "$shortDialogs");
        return z ? C6517Nv5.l0(C14505i18.a) : k56.T0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC24602yt4 Q1() {
        return (InterfaceC24602yt4) C92.a(C5721Ko.a.d(), InterfaceC24602yt4.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q2(C11458d25 c11458d25, AbstractC20556sC7 abstractC20556sC7, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        BV0.a.e(c11458d25, (FE7) abstractC20556sC7);
    }

    private final C11458d25 R0(ExPeer exPeer) {
        C11458d25 c11458d25;
        ExPeerType exPeerType = exPeer.getExPeerType();
        int i = exPeerType == null ? -1 : b.a[exPeerType.ordinal()];
        if (i == 1 || i == 2) {
            c11458d25 = new C11458d25(W25.a, exPeer.getPeerId());
        } else {
            if (i != 3 && i != 4) {
                return null;
            }
            c11458d25 = new C11458d25(W25.b, exPeer.getPeerId());
        }
        return c11458d25;
    }

    private final void R1(boolean z) {
        if (z) {
            f1();
        } else {
            T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R2(C11458d25 c11458d25, AbstractC20556sC7 abstractC20556sC7, K56 k56, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(k56, "this$0");
        BV0.a.f(c11458d25, (DE7) abstractC20556sC7, k56.m);
    }

    private final C6517Nv5 S0(List list) {
        boolean zH = W().h("settings_sync_state_loaded_v2", false);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C25254zz6 c25254zz6 = (C25254zz6) it.next();
            AbstractC13042fc3.f(c25254zz6);
            if (c25254zz6.z() || c25254zz6.u().booleanValue()) {
                SettingsModule settingsModuleS = this.m.S();
                C11458d25 c11458d25W = c25254zz6.w();
                AbstractC13042fc3.h(c11458d25W, "getPeer(...)");
                boolean zH5 = settingsModuleS.H5(c11458d25W);
                if (!zH || zH5) {
                    if (c25254zz6.getExPeerType() != null && c25254zz6.getExPeerType() != ExPeerType.UNKNOWN) {
                        arrayList.add(new ExPeer(c25254zz6.getExPeerType(), c25254zz6.w().getPeerId()));
                    }
                }
            }
        }
        m1().J(arrayList);
        g3();
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void S1(ir.nasim.C11458d25 r8, boolean r9, ir.nasim.core.modules.profile.entity.ExPeerType r10, int r11) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K56.S1(ir.nasim.d25, boolean, ir.nasim.core.modules.profile.entity.ExPeerType, int):void");
    }

    private final C6517Nv5 S2(List list, boolean z, boolean z2) {
        C16504lO2 c16504lO2N1 = n1();
        c16504lO2N1.s(z);
        c16504lO2N1.w(z2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C25229zx c25229zx = (C25229zx) it.next();
            ArrayList arrayList = new ArrayList();
            for (C3681Bx c3681Bx : c25229zx.q()) {
                AbstractC13042fc3.f(c3681Bx);
                arrayList.add(l3(c3681Bx));
            }
            Iterator it2 = c16504lO2N1.q().iterator();
            AbstractC13042fc3.h(it2, "iterator(...)");
            while (true) {
                if (it2.hasNext()) {
                    C15913kO2 c15913kO2 = (C15913kO2) it2.next();
                    if (AbstractC13042fc3.d(c15913kO2.getKey(), c25229zx.getKey())) {
                        c16504lO2N1.q().remove(c15913kO2);
                        break;
                    }
                }
            }
            c16504lO2N1.q().add(new C15913kO2(c25229zx.getKey(), c25229zx.r(), new CopyOnWriteArrayList(arrayList)));
        }
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    private final C6517Nv5 T0(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, q1((C25254zz6) list.get(i)));
        }
        return this.m.Q().L(list);
    }

    private final void T1() {
        C22481vJ2 c22481vJ2E;
        if (m1().z() && (c22481vJ2E = this.m.v().E()) != null) {
            c22481vJ2E.m(Math.max(0, m1().s()));
            c22481vJ2E.o(Math.max(0, m1().w()));
            c22481vJ2E.n(Math.max(0, m1().u()));
            c22481vJ2E.l(Math.max(0, m1().r()));
            c22481vJ2E.k(Math.max(0, m1().q()));
        }
    }

    private final C6517Nv5 T2() {
        n1().u(true);
        this.s.e(new C9863ah0(15L, n1().toByteArray()));
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    private final DB3 U0(C11458d25 c11458d25) {
        E84 e84 = this.r;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        DB3 db3H0 = e84.H0(c11458d25);
        AbstractC13042fc3.h(db3H0, "getConversationEngine(...)");
        return db3H0;
    }

    private final void U1() {
        this.o = false;
    }

    private final C6517Nv5 U2() {
        C19406qI3.a("RouterActor", "removeUnknownConvState before LoadGroupedDialogs", new Object[0]);
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C6517Nv5 c6517Nv5H = interfaceC8344Vo3.h().H(new InterfaceC17569nB2() { // from class: ir.nasim.e56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.V2(this.a, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 V0(C11458d25 c11458d25, long j, long j2) {
        J44 j44;
        Long l;
        C4275El c4275El;
        C4275El c4275El2;
        J44 j44B = (J44) this.m.G().H0(c11458d25).a(j);
        if (j44B == null) {
            C4275El c4275El3 = this.p;
            if (c4275El3 == null) {
                AbstractC13042fc3.y("albumToMessageIdDataSource");
                c4275El3 = null;
            }
            Long lC = c4275El3.c(c11458d25.u(), AbstractC4616Fw7.a(Long.valueOf(j), Long.valueOf(j2)));
            if (lC != null) {
                J44 j442 = (J44) this.m.G().H0(c11458d25).a(lC.longValue());
                j44 = j442;
                l = lC;
                j44B = C18492ol.a.b(j442, j);
            } else {
                l = lC;
                j44 = null;
            }
        } else {
            j44 = null;
            l = null;
        }
        if (j44B == null) {
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        if (j44B.d0() && j44B.F().m()) {
            this.m.D().S(j);
        }
        if (j44B.F().m()) {
            C24967zW1 c24967zW1H = j44B.H();
            if ((c24967zW1H != null ? c24967zW1H.z() : null) instanceof C11920dm2) {
                InterfaceC18505om2 interfaceC18505om2Z = c24967zW1H.z();
                AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
                p1().J0().c(((C11920dm2) interfaceC18505om2Z).b());
            }
        }
        if (l == null) {
            this.m.G().H0(c11458d25).b(j);
        } else {
            C4275El c4275El4 = this.p;
            if (c4275El4 == null) {
                AbstractC13042fc3.y("albumToMessageIdDataSource");
                c4275El = null;
            } else {
                c4275El = c4275El4;
            }
            c4275El.b(c11458d25.u(), l.longValue(), AbstractC4616Fw7.a(Long.valueOf(j), Long.valueOf(j2)));
            C18492ol c18492ol = C18492ol.a;
            long jLongValue = l.longValue();
            AbstractC13042fc3.f(j44);
            J44 j44H = c18492ol.h(jLongValue, j44, j);
            if (j44H == null) {
                this.m.G().H0(c11458d25).b(l.longValue());
            } else if (j44H.F() instanceof C11907dl) {
                this.m.G().H0(c11458d25).d(j44H);
            } else {
                C4275El c4275El5 = this.p;
                if (c4275El5 == null) {
                    AbstractC13042fc3.y("albumToMessageIdDataSource");
                    c4275El2 = null;
                } else {
                    c4275El2 = c4275El5;
                }
                c4275El2.b(c11458d25.u(), l.longValue(), AbstractC4616Fw7.a(Long.valueOf(j44H.i()), Long.valueOf(j44H.h())));
                this.m.G().H0(c11458d25).b(l.longValue());
                this.m.G().H0(c11458d25).d(j44H);
            }
        }
        C6517Nv5 c6517Nv5L02 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L02, "success(...)");
        return c6517Nv5L02;
    }

    private final void V1() {
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 V2(K56 k56, List list) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(list, "convStates");
        if (list.isEmpty()) {
            return C6517Nv5.l0(C14505i18.a);
        }
        try {
            C19406qI3.j("RouterActor", "removeUnknownConvState convState Size: " + list.size(), new Object[0]);
            E84 e84 = k56.r;
            if (e84 == null) {
                AbstractC13042fc3.y("messagesModule");
                e84 = null;
            }
            List listK = e84.J0().k();
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                C4778Gn1 c4778Gn1 = (C4778Gn1) it.next();
                if (c4778Gn1.getExPeerType() == null || c4778Gn1.getExPeerType() == ExPeerType.UNKNOWN) {
                    InterfaceC8344Vo3 interfaceC8344Vo3 = k56.q;
                    if (interfaceC8344Vo3 == null) {
                        AbstractC13042fc3.y("conversationStates");
                        interfaceC8344Vo3 = null;
                    }
                    interfaceC8344Vo3.b(c4778Gn1.a());
                } else {
                    AbstractC13042fc3.f(listK);
                    List list2 = listK;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            if (((C17067mL1) it2.next()).R().u() == c4778Gn1.b0().u()) {
                                break;
                            }
                        }
                    }
                    InterfaceC8344Vo3 interfaceC8344Vo32 = k56.q;
                    if (interfaceC8344Vo32 == null) {
                        AbstractC13042fc3.y("conversationStates");
                        interfaceC8344Vo32 = null;
                    }
                    interfaceC8344Vo32.b(c4778Gn1.a());
                }
                i++;
            }
            C19406qI3.a("RouterActor", "removed convStates before LoadGroupedDialogs. removed count : " + i, new Object[0]);
            return C6517Nv5.l0(C14505i18.a);
        } catch (Exception e) {
            C19406qI3.j("RouterActor", e.getMessage(), new Object[0]);
            return C6517Nv5.l0(C14505i18.a);
        }
    }

    private final void W0(C11458d25 c11458d25, List list, List list2) {
        C15246jF7 c15246jF7;
        if (c11458d25 == null || list == null || list2 == null || (c15246jF7 = this.v) == null) {
            return;
        }
        c15246jF7.d(new C15246jF7.a(c11458d25, list, list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(Object obj, ArrayList arrayList, K56 k56, C14505i18 c14505i18) {
        AbstractC13042fc3.i(obj, "$message");
        AbstractC13042fc3.i(arrayList, "$nMessages");
        AbstractC13042fc3.i(k56, "this$0");
        C19888r66 c19888r66 = (C19888r66) obj;
        C19406qI3.a("RouterActor", "onNewMessages then with peerId: " + c19888r66.b().getPeerId() + ", multiple messages", new Object[0]);
        BV0 bv0 = BV0.a;
        C11458d25 c11458d25B = c19888r66.b();
        AbstractC13042fc3.h(c11458d25B, "getPeer(...)");
        List listA = c19888r66.a();
        AbstractC13042fc3.h(listA, "getMessages(...)");
        C9057Yh4 c9057Yh4 = k56.m;
        E84 e84 = k56.r;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        bv0.n(c11458d25B, listA, arrayList, c9057Yh4, e84);
    }

    private final C6517Nv5 W2(final boolean z) {
        C6517Nv5 c6517Nv5 = this.u;
        if (c6517Nv5 != null) {
            return c6517Nv5;
        }
        C19406qI3.a("RouterActor", "do requestGroupedDialogs", new Object[0]);
        C6517Nv5 c6517Nv5Z = N(new QT5(PC.e, EnumC5550Jv.ALL)).A(new InterfaceC17569nB2() { // from class: ir.nasim.j56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.Y2(z, this, (TZ5) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.k56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.Z2(this.a, (TZ5) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.l56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.a3(this.a, z, (TZ5) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.m56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.b3((TZ5) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.n56
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                K56.c3(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        this.u = c6517Nv5Z;
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC20667sP1 X0() {
        return ((HS1) I22.a(C5721Ko.a.d(), HS1.class)).q();
    }

    private final void X1(C11458d25 c11458d25) {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        InterfaceC8344Vo3 interfaceC8344Vo32 = this.q;
        if (interfaceC8344Vo32 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo32 = null;
        }
        interfaceC8344Vo3.e(((C4778Gn1) interfaceC8344Vo32.d(c11458d25.u())).s(null));
    }

    static /* synthetic */ C6517Nv5 X2(K56 k56, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return k56.W2(z);
    }

    private final void Y0(C11458d25 c11458d25, Long l, Long l2) {
        C15246jF7 c15246jF7;
        if (c11458d25 == null || l == null || l2 == null || (c15246jF7 = this.v) == null) {
            return;
        }
        c15246jF7.d(new C15246jF7.b(c11458d25, l.longValue(), l2.longValue()));
    }

    private final C6517Nv5 Y1(C11458d25 c11458d25) {
        this.m.G().t0(c11458d25);
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1M = ((C4778Gn1) C4778Gn1.w.a(c11458d25.getPeerId())).y(true).w(((C4778Gn1) interfaceC8344Vo3.d(c11458d25.u())).getExPeerType()).L(AbstractC10360bX0.m()).M(AbstractC10360bX0.m());
        InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
        if (interfaceC8344Vo33 == null) {
            AbstractC13042fc3.y("conversationStates");
        } else {
            interfaceC8344Vo32 = interfaceC8344Vo33;
        }
        interfaceC8344Vo32.e(c4778Gn1M);
        C6517Nv5 c6517Nv5O = j1().o(c11458d25);
        AbstractC13042fc3.h(c6517Nv5O, "onChatClear(...)");
        return c6517Nv5O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Y2(boolean z, K56 k56, TZ5 tz5) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(tz5, "r");
        return z ? C6517Nv5.l0(C14505i18.a) : k56.m.V().s0(tz5.z(), tz5.w());
    }

    private final W25 Z0(C8421Vx c8421Vx) {
        EnumC9196Yx enumC9196YxR = c8421Vx.r();
        switch (enumC9196YxR == null ? -1 : b.b[enumC9196YxR.ordinal()]) {
            case 1:
            case 2:
                return W25.a;
            case 3:
            case 4:
            case 5:
            case 6:
                return W25.b;
            default:
                return null;
        }
    }

    private final C6517Nv5 Z1(final C11458d25 c11458d25) {
        this.m.G().t0(c11458d25);
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        if (c4778Gn1 != null) {
            ExPeerType exPeerTypeK1 = k1(c11458d25, c4778Gn1);
            c4778Gn1.u(0);
            S1(c11458d25, false, exPeerTypeK1, c4778Gn1.c0());
            InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
            if (interfaceC8344Vo33 == null) {
                AbstractC13042fc3.y("conversationStates");
            } else {
                interfaceC8344Vo32 = interfaceC8344Vo33;
            }
            interfaceC8344Vo32.b(c11458d25.u());
        }
        this.m.V().Q(c11458d25.getPeerId());
        C6517Nv5 c6517Nv5M0 = j1().p(c11458d25).m0(new InterfaceC24449ye1() { // from class: ir.nasim.o56
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                K56.a2(this.a, c11458d25, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Z2(K56 k56, TZ5 tz5) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(tz5, "r");
        return k56.m.V().R(tz5.C(), tz5.y());
    }

    private final void a1(List list) {
        int size = list.size() - 1;
        int i = 0;
        while (i < size) {
            J44 j44 = (J44) list.get(i);
            i++;
            j44.j0(new C3460Az(((J44) list.get(i)).h(), ((J44) list.get(i)).i(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(K56 k56, C11458d25 c11458d25, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        k56.m.Q().M(c11458d25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 a3(K56 k56, boolean z, TZ5 tz5) {
        boolean zBooleanValue;
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(tz5, "r");
        boolean zBooleanValue2 = false;
        if (tz5.D() != null) {
            Boolean boolD = tz5.D();
            AbstractC13042fc3.f(boolD);
            zBooleanValue = boolD.booleanValue();
        } else {
            zBooleanValue = false;
        }
        if (tz5.E() != null) {
            Boolean boolE = tz5.E();
            AbstractC13042fc3.f(boolE);
            zBooleanValue2 = boolE.booleanValue();
        }
        List listU = tz5.u();
        AbstractC13042fc3.h(listU, "getDialogs(...)");
        return k56.K2(listU, zBooleanValue, zBooleanValue2, z);
    }

    private final void b1(C11458d25 c11458d25, J44 j44) {
        C3460Az c3460AzO;
        if (j44 == null || (c3460AzO = j44.O()) == null) {
            return;
        }
        long jI = c3460AzO.i();
        long jH = c3460AzO.h();
        J44 j442 = (J44) U0(c11458d25).a(jI);
        if (j442 != null) {
            C3460Az c3460Az = new C3460Az(j44.h(), j44.i(), 0L);
            if (C3699Bz.a(j442.N(), c3460Az)) {
                return;
            }
            if (j442.N() != null) {
                C19406qI3.b("RouterActor", "fixLocalLinksUsingFirstMessage, bad state:nextMessageId: " + j442.N() + " != firstMessageId: " + c3460Az);
            }
            j442.j0(c3460Az);
            U0(c11458d25).d(j442);
            return;
        }
        C4275El c4275El = this.p;
        if (c4275El == null) {
            AbstractC13042fc3.y("albumToMessageIdDataSource");
            c4275El = null;
        }
        Long lC = c4275El.c(c11458d25.u(), AbstractC4616Fw7.a(Long.valueOf(jI), Long.valueOf(jH)));
        if (lC != null) {
            J44 j443 = (J44) this.m.G().H0(c11458d25).a(lC.longValue());
            J44 j44B = C18492ol.a.b(j443, jI);
            if (j44B != null) {
                C3460Az c3460Az2 = new C3460Az(j44.h(), j44.i(), 0L);
                if (C3699Bz.a(j44B.N(), c3460Az2)) {
                    return;
                }
                j44B.j0(c3460Az2);
                U0(c11458d25).d(j443);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final C6517Nv5 b2(C11458d25 c11458d25, Y64 y64, Long l, Long l2, boolean z, DB3 db3) {
        boolean z2;
        InterfaceC8344Vo3 interfaceC8344Vo3;
        List listB = y64.b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        InterfaceC8344Vo3 interfaceC8344Vo32 = this.q;
        if (interfaceC8344Vo32 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo32 = null;
        }
        C4778Gn1 c4778Gn1Y = (C4778Gn1) interfaceC8344Vo32.d(c11458d25.u());
        C18492ol c18492ol = C18492ol.a;
        AbstractC13042fc3.f(listB);
        List listC = c18492ol.c(listB);
        C4275El c4275El = this.p;
        if (c4275El == null) {
            AbstractC13042fc3.y("albumToMessageIdDataSource");
            c4275El = null;
        }
        c18492ol.e(c4275El, c11458d25.u(), listC);
        int size = listC.size();
        int i = 0;
        long jMax = 0;
        boolean z3 = false;
        while (i < size) {
            Object obj = listC.get(i);
            J44 j44 = (J44) obj;
            int i2 = i;
            J44 j442 = obj;
            if (j44.F() instanceof C11907dl) {
                J44 j443 = (J44) db3.a(j44.i());
                j442 = obj;
                if (j443 != null) {
                    C18492ol c18492ol2 = C18492ol.a;
                    AbstractC13042fc3.h(obj, "element");
                    J44 j44F = c18492ol2.f(j443, j44);
                    j442 = obj;
                    if (j44F != null) {
                        j442 = j44F;
                    }
                }
            }
            arrayList.add(j442);
            J44 j444 = j442;
            if (j444.F().m()) {
                arrayList2.add(j442);
            }
            if (j444.F() instanceof C22149uk7) {
                AbstractC13042fc3.f(c4778Gn1Y);
                AbstractC13042fc3.h(j442, "element");
                if (i3(c4778Gn1Y, j444) && c11458d25.C()) {
                    c4778Gn1Y = c4778Gn1Y.F(j444);
                    z3 = true;
                }
            }
            jMax = Math.max(jMax, j444.W());
            i = i2 + 1;
        }
        db3.p(arrayList, y64.a());
        if (c4778Gn1Y.Q() < jMax) {
            z2 = false;
            c4778Gn1Y = c4778Gn1Y.C(false).D(jMax);
            z3 = true;
        } else {
            z2 = false;
        }
        if (l != null && l.longValue() != 0 && c4778Gn1Y.Y() < jMax) {
            c4778Gn1Y = c4778Gn1Y.J(l.longValue());
            z3 = true;
        }
        if (l2 != null && l2.longValue() != 0 && c4778Gn1Y.a0() < l2.longValue()) {
            c4778Gn1Y = c4778Gn1Y.K(l2.longValue());
            z3 = true;
        }
        if (c4778Gn1Y.j0() != z) {
            c4778Gn1Y = c4778Gn1Y.z(z);
            z3 = true;
        }
        boolean zIsEmpty = U0(c11458d25).isEmpty();
        if (c4778Gn1Y.h0() != zIsEmpty) {
            c4778Gn1Y = c4778Gn1Y.y(zIsEmpty);
            z3 = true;
        }
        boolean z4 = (c4778Gn1Y.getExPeerType() == null || c4778Gn1Y.getExPeerType() == ExPeerType.UNKNOWN) ? true : z2;
        if (z3 && !z4) {
            InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
            if (interfaceC8344Vo33 == null) {
                AbstractC13042fc3.y("conversationStates");
                interfaceC8344Vo3 = null;
            } else {
                interfaceC8344Vo3 = interfaceC8344Vo33;
            }
            interfaceC8344Vo3.e(c4778Gn1Y);
        }
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(new C4382Ew7(Integer.valueOf(listC.size()), Integer.valueOf(arrayList2.size())));
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 b3(TZ5 tz5) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final void c1(C11458d25 c11458d25, J44 j44) {
        J44 j442;
        J44 j44B;
        J44 j443;
        J44 j44B2;
        if (j44 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        C3460Az c3460AzO = j44.O();
        C4275El c4275El = null;
        if (c3460AzO != null) {
            long jI = c3460AzO.i();
            long jH = c3460AzO.h();
            J44 j444 = (J44) this.m.G().H0(c11458d25).a(jI);
            if (j444 != null) {
                j444.j0(j44.N());
                arrayList.add(j444);
            }
            if (j444 == null) {
                C4275El c4275El2 = this.p;
                if (c4275El2 == null) {
                    AbstractC13042fc3.y("albumToMessageIdDataSource");
                    c4275El2 = null;
                }
                Long lC = c4275El2.c(c11458d25.u(), AbstractC4616Fw7.a(Long.valueOf(jI), Long.valueOf(jH)));
                if (lC != null && (j44B2 = C18492ol.a.b((j443 = (J44) this.m.G().H0(c11458d25).a(lC.longValue())), jI)) != null) {
                    j44B2.j0(j44.N());
                    arrayList.add(j443);
                }
            }
        }
        C3460Az c3460AzN = j44.N();
        if (c3460AzN != null) {
            long jI2 = c3460AzN.i();
            long jH2 = c3460AzN.h();
            J44 j445 = (J44) this.m.G().H0(c11458d25).a(jI2);
            if (j445 != null) {
                j445.l0(j44.O());
                arrayList.add(j445);
            }
            if (j445 == null) {
                C4275El c4275El3 = this.p;
                if (c4275El3 == null) {
                    AbstractC13042fc3.y("albumToMessageIdDataSource");
                } else {
                    c4275El = c4275El3;
                }
                Long lC2 = c4275El.c(c11458d25.u(), AbstractC4616Fw7.a(Long.valueOf(jI2), Long.valueOf(jH2)));
                if (lC2 != null && (j44B = C18492ol.a.b((j442 = (J44) this.m.G().H0(c11458d25).a(lC2.longValue())), jI2)) != null) {
                    j44B.l0(j44.O());
                    arrayList.add(j442);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.m.G().H0(c11458d25).c(arrayList);
        }
    }

    private final C6517Nv5 c2(C11458d25 c11458d25, long j, long j2, AbstractC17457n0 abstractC17457n0, boolean z) {
        boolean z2;
        J44 j44N3;
        J44 j44;
        C14697iL2 c14697iL2;
        E84 e84 = this.r;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        DB3 db3H0 = e84.H0(c11458d25);
        boolean z3 = !c11458d25.z() || ((c14697iL2 = (C14697iL2) this.m.E().X1().d((long) c11458d25.getPeerId())) != null && c14697iL2.H0());
        if (z3) {
            j44N3 = (J44) db3H0.a(j);
            z2 = false;
        } else {
            E84 e842 = this.r;
            if (e842 == null) {
                AbstractC13042fc3.y("messagesModule");
                e842 = null;
            }
            DB3 db3F0 = e842.F0();
            if (db3F0 == null || (j44N3 = (J44) db3F0.a(j)) == null) {
                z2 = false;
                j44N3 = null;
            } else {
                z2 = j44N3.X() != null;
            }
        }
        if (j44N3 != null) {
            j44N3 = j44N3.u(abstractC17457n0, z);
        } else {
            C4275El c4275El = this.p;
            if (c4275El == null) {
                AbstractC13042fc3.y("albumToMessageIdDataSource");
                c4275El = null;
            }
            Long lC = c4275El.c(c11458d25.u(), new XV4(Long.valueOf(j), Long.valueOf(j2)));
            if (lC != null && (j44 = (J44) db3H0.a(lC.longValue())) != null) {
                j44N3 = n3(j44, j, abstractC17457n0, z);
            }
        }
        if (j44N3 != null) {
            DB3 db3F02 = this.m.G().F0();
            List listD = A.d(c11458d25, AbstractC9766aX0.e(Long.valueOf(j)), abstractC17457n0, (z3 || !z2 || db3F02 == null) ? U0(c11458d25) : db3F02);
            listD.add(j44N3);
            if (z3) {
                db3H0.c(listD);
            }
            if (z2 && db3F02 != null) {
                List<J44> list = listD;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (J44 j442 : list) {
                    arrayList.add(j442 != null ? j442.E(h1(j442)) : null);
                }
                db3F02.c(arrayList);
            }
            Y0(c11458d25, Long.valueOf(j), Long.valueOf(j2));
        }
        if (z3) {
            C6517Nv5 c6517Nv5E = j1().E(c11458d25, j, abstractC17457n0);
            AbstractC13042fc3.f(c6517Nv5E);
            return c6517Nv5E;
        }
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.f(c6517Nv5L0);
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(K56 k56, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(k56, "this$0");
        k56.u = null;
        k56.W().putLong("LAST_LOAD_GROUPED_DIALOG_TIME_", AbstractC20507s76.p());
    }

    private final void d1(List list) {
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            J44 j44 = (J44) obj;
            J44 j442 = (J44) AbstractC15401jX0.t0(list, i - 1);
            if (j442 != null) {
                j44.l0(new C3460Az(j442.h(), j442.i(), 0L));
            }
            J44 j443 = (J44) AbstractC15401jX0.t0(list, i2);
            if (j443 != null) {
                j44.j0(new C3460Az(j443.h(), j443.i(), 0L));
            }
            i = i2;
        }
    }

    private final void d2(C11458d25 c11458d25) {
        this.n.remove(c11458d25);
        C3343Am.i("CloseDialogue", l1(c11458d25));
    }

    private final void d3(C11458d25 c11458d25, long j, long j2, ExPeerType exPeerType) {
        GeneratedMessageLite generatedMessageLiteA = MessagingOuterClass$RequestMentionRead.newBuilder().B((PeersStruct$ExPeer) PeersStruct$ExPeer.newBuilder().B(c11458d25.getPeerId()).A(0L).C(exPeerType.toProtoApi()).a()).A((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().A(j2).B(j).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.messaging.v2.Messaging/MentionRead", generatedMessageLiteA, defaultInstance));
    }

    private final void e1(C11458d25 c11458d25, int i) {
        this.m.G().B0(c11458d25).o().j(Integer.valueOf(i));
    }

    private final void e2(C11458d25 c11458d25, ExPeerType exPeerType) {
        this.n.add(c11458d25);
        C3343Am.i("OpenDialogue", l1(c11458d25));
        N1(exPeerType);
    }

    private final void e3(C11458d25 c11458d25, long j, long j2, ExPeerType exPeerType) {
        GeneratedMessageLite generatedMessageLiteA = AbacusOuterClass$RequestMessageReactionsRead.newBuilder().B((PeersStruct$ExPeer) PeersStruct$ExPeer.newBuilder().B(c11458d25.getPeerId()).A(0L).C(exPeerType.toProtoApi()).a()).A((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().A(j2).B(j).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.abacus.v1.Abacus/MessageReactionsRead", generatedMessageLiteA, defaultInstance));
    }

    private final void f1() {
        C19406qI3.a("RouterActor", "forceNotifyGlobalUnreadCounts", new Object[0]);
        long jP = AbstractC20507s76.p();
        g3();
        C19406qI3.a("RouterActor", "forceNotifyGlobalUnreadCounts Totally took: " + (AbstractC20507s76.p() - jP) + " ms", new Object[0]);
    }

    private final C6517Nv5 f2(final List list) {
        final int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(Long.valueOf(((C18267oN1) list.get(i)).d().u()));
        }
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C6517Nv5 c6517Nv5H = interfaceC8344Vo3.g(arrayList).H(new InterfaceC17569nB2() { // from class: ir.nasim.G56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return K56.g2(size, list, this, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final J44 f3(C11458d25 c11458d25, J44 j44) {
        J44 j442;
        C14697iL2 c14697iL2;
        C8445Vz5 c8445Vz5Q = j44.Q();
        DB3 db3F0 = this.m.G().F0();
        if (!c11458d25.z() || (((c14697iL2 = (C14697iL2) this.m.E().X1().d(c11458d25.getPeerId())) != null && c14697iL2.H0()) || j44.X() == null || db3F0 == null)) {
            db3F0 = U0(c11458d25);
        }
        if (c8445Vz5Q == null || c8445Vz5Q.E() || c8445Vz5Q.s() == 0 || (j442 = (J44) db3F0.a(c8445Vz5Q.s())) == null) {
            return null;
        }
        List listS = j442.S();
        List listP1 = listS != null ? AbstractC15401jX0.p1(listS) : null;
        List arrayList = listP1 == null ? new ArrayList() : listP1;
        arrayList.add(Long.valueOf(j44.i()));
        return J44.D(j442, 0L, 0L, 0L, 0, null, null, null, 0, null, arrayList, 0L, null, null, false, null, false, null, null, 261631, null);
    }

    private final List g1() {
        ArrayList arrayList = new ArrayList();
        Iterator it = n1().q().iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            arrayList.addAll(((C15913kO2) it.next()).q());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 g2(int i, List list, K56 k56, List list2) {
        AbstractC13042fc3.i(list, "$dialogs");
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(list2, "states");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            C4778Gn1 c4778Gn1 = (C4778Gn1) list2.get(i2);
            C18267oN1 c18267oN1 = (C18267oN1) list.get(i2);
            C4778Gn1 c4778Gn1E = c4778Gn1.E(c18267oN1.c());
            if (c18267oN1.h()) {
                c4778Gn1E = c4778Gn1E.J(c18267oN1.a()).K(c18267oN1.a());
            } else if (c18267oN1.i()) {
                c4778Gn1E = c4778Gn1E.K(c18267oN1.a());
            }
            C4778Gn1 c4778Gn1W = c4778Gn1E.D(c18267oN1.a()).w(c18267oN1.b());
            if (c18267oN1.e() > 0) {
                c4778Gn1W = c4778Gn1W.u(c18267oN1.e());
                C11458d25 c11458d25B0 = c4778Gn1W.b0();
                AbstractC13042fc3.h(c11458d25B0, "getPeer(...)");
                k56.S1(c18267oN1.d(), true, k56.k1(c11458d25B0, c4778Gn1W), c4778Gn1W.c0());
            }
            arrayList.add(c4778Gn1W.L(c18267oN1.f()).M(c18267oN1.g()));
        }
        InterfaceC8344Vo3 interfaceC8344Vo3 = k56.q;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        interfaceC8344Vo3.c(arrayList);
        return C6517Nv5.l0(C14505i18.a);
    }

    private final void g3() {
        List<ExPeer> listY = m1().y();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (W().h("settings_sync_state_loaded_v2", false)) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (ExPeer exPeer : listY) {
                AbstractC13042fc3.f(exPeer);
                C11458d25 c11458d25R0 = R0(exPeer);
                if (c11458d25R0 == null) {
                    arrayList.add(exPeer);
                } else if (this.m.S().H5(c11458d25R0)) {
                    ExPeerType exPeerType = exPeer.getExPeerType();
                    if (exPeerType != null) {
                        if (exPeerType == ExPeerType.CHANNEL) {
                            i++;
                        } else if (exPeerType == ExPeerType.GROUP) {
                            i2++;
                        } else if (exPeerType == ExPeerType.PRIVATE) {
                            i3++;
                        } else if (exPeerType == ExPeerType.BOT) {
                            i4++;
                        }
                    }
                } else {
                    arrayList.add(exPeer);
                }
            }
            listY.removeAll(arrayList);
            m1().J(listY);
            int i5 = i + i2 + i3 + i4;
            C22481vJ2 c22481vJ2E = this.m.v().E();
            if (c22481vJ2E != null) {
                c22481vJ2E.m(i5);
                c22481vJ2E.l(i);
                c22481vJ2E.n(i2);
                c22481vJ2E.o(i3);
                c22481vJ2E.k(i4);
            }
            C23667xJ2 c23667xJ2M1 = m1();
            c23667xJ2M1.F(i5);
            c23667xJ2M1.H(i3);
            c23667xJ2M1.G(i2);
            c23667xJ2M1.D(i);
            c23667xJ2M1.C(i4);
            c23667xJ2M1.E(true);
            p3();
            this.s.e(new C9863ah0(7L, m1().toByteArray()));
        }
    }

    private final C8445Vz5 h1(J44 j44) {
        C7880To7 c7880To7X = j44.X();
        long jI = c7880To7X != null ? c7880To7X.i() : 0L;
        C8445Vz5 c8445Vz5Q = j44.Q();
        Number numberValueOf = c8445Vz5Q != null ? Long.valueOf(c8445Vz5Q.s()) : 1;
        if ((numberValueOf instanceof Long) && jI == numberValueOf.longValue()) {
            C7880To7 c7880To7X2 = j44.X();
            long jH = c7880To7X2 != null ? c7880To7X2.h() : 0L;
            C8445Vz5 c8445Vz5Q2 = j44.Q();
            Number numberValueOf2 = c8445Vz5Q2 != null ? Long.valueOf(c8445Vz5Q2.h()) : 1;
            if ((numberValueOf2 instanceof Long) && jH == numberValueOf2.longValue()) {
                return null;
            }
        }
        return j44.Q();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C6517Nv5 h2(final ir.nasim.C11458d25 r15, final java.util.List r16, final java.util.List r17) {
        /*
            r14 = this;
            r9 = r14
            r14.W0(r15, r16, r17)
            ir.nasim.Vo3 r0 = r9.q
            r1 = 0
            if (r0 != 0) goto Lf
            java.lang.String r0 = "conversationStates"
            ir.nasim.AbstractC13042fc3.y(r0)
            r0 = r1
        Lf:
            long r2 = r15.u()
            ir.nasim.Xo3 r0 = r0.d(r2)
            r2 = r0
            ir.nasim.Gn1 r2 = (ir.nasim.C4778Gn1) r2
            r0 = r16
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r3 = 1
            r0 = r0 ^ r3
            java.lang.String r4 = "messagesModule"
            r5 = 0
            if (r0 == 0) goto L4d
            ir.nasim.E84 r0 = r9.r
            if (r0 != 0) goto L31
            ir.nasim.AbstractC13042fc3.y(r4)
            r0 = r1
        L31:
            ir.nasim.DB3 r0 = r0.F0()
            if (r0 == 0) goto L48
            java.lang.Object r6 = ir.nasim.ZW0.q0(r16)
            java.lang.Number r6 = (java.lang.Number) r6
            long r6 = r6.longValue()
            ir.nasim.nl0 r0 = r0.a(r6)
            ir.nasim.J44 r0 = (ir.nasim.J44) r0
            goto L49
        L48:
            r0 = r1
        L49:
            if (r0 == 0) goto L4d
            r0 = r3
            goto L4e
        L4d:
            r0 = r5
        L4e:
            ir.nasim.core.modules.profile.entity.ExPeerType r6 = r2.getExPeerType()
            if (r6 == 0) goto L5c
            ir.nasim.core.modules.profile.entity.ExPeerType r6 = r2.getExPeerType()
            ir.nasim.core.modules.profile.entity.ExPeerType r7 = ir.nasim.core.modules.profile.entity.ExPeerType.UNKNOWN
            if (r6 != r7) goto L5f
        L5c:
            if (r0 != 0) goto L5f
            goto L60
        L5f:
            r3 = r5
        L60:
            ir.nasim.i18 r0 = ir.nasim.C14505i18.a
            ir.nasim.Nv5 r0 = ir.nasim.C6517Nv5.l0(r0)
            ir.nasim.Yh4 r6 = r9.m
            ir.nasim.E84 r6 = r6.G()
            r7 = r15
            ir.nasim.DB3 r6 = r6.H0(r15)
            ir.nasim.nl0 r6 = r6.r()
            r8 = r6
            ir.nasim.J44 r8 = (ir.nasim.J44) r8
            java.util.LinkedHashSet r10 = new java.util.LinkedHashSet
            r10.<init>()
            if (r3 == 0) goto La3
            ir.nasim.nA r0 = new ir.nasim.nA
            ir.nasim.W25 r6 = r15.s()
            ir.nasim.CA r6 = r6.p()
            int r11 = r15.getPeerId()
            r12 = 0
            r0.<init>(r6, r11, r12)
            ir.nasim.E84 r6 = r9.r
            if (r6 != 0) goto L9a
            ir.nasim.AbstractC13042fc3.y(r4)
            goto L9b
        L9a:
            r1 = r6
        L9b:
            java.util.List r0 = ir.nasim.ZW0.e(r0)
            ir.nasim.Nv5 r0 = r1.M1(r0, r5)
        La3:
            r11 = r0
            ir.nasim.c56 r12 = new ir.nasim.c56
            r0 = r12
            r1 = r2
            r2 = r3
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r10
            r0.<init>()
            ir.nasim.Nv5 r0 = r11.z(r12)
            ir.nasim.d56 r1 = new ir.nasim.d56
            r1.<init>()
            ir.nasim.Nv5 r0 = r0.G(r1)
            java.lang.String r1 = "fallback(...)"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K56.h2(ir.nasim.d25, java.util.List, java.util.List):ir.nasim.Nv5");
    }

    private final void h3(EF7 ef7) {
        C11458d25 c11458d25D = ef7.d();
        long jI = ef7.c().i();
        E84 e84 = this.r;
        E84 e842 = null;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        J44 j44 = (J44) e84.H0(c11458d25D).a(jI);
        if (j44 == null) {
            return;
        }
        AbstractC17457n0 abstractC17457n0F = j44.F();
        J08 j08 = abstractC17457n0F instanceof J08 ? (J08) abstractC17457n0F : null;
        if (j08 == null) {
            return;
        }
        J44 j44D = J44.D(j44, 0L, 0L, 0L, 0, null, J08.l.a(j08, VoiceTranscript.c(j08.J(), EnumC9477a18.b, null, false, 4, null)), null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null);
        E84 e843 = this.r;
        if (e843 == null) {
            AbstractC13042fc3.y("messagesModule");
        } else {
            e842 = e843;
        }
        e842.H0(c11458d25D).d(j44D);
    }

    private final InterfaceC20667sP1 i1() {
        return (InterfaceC20667sP1) this.t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0320 A[PHI: r0 r20
      0x0320: PHI (r0v8 ir.nasim.Gn1) = (r0v7 ir.nasim.Gn1), (r0v32 ir.nasim.Gn1) binds: [B:99:0x02e6, B:107:0x031a] A[DONT_GENERATE, DONT_INLINE]
      0x0320: PHI (r20v1 boolean) = (r20v0 boolean), (r20v3 boolean) binds: [B:99:0x02e6, B:107:0x031a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i2(ir.nasim.C4778Gn1 r29, boolean r30, final ir.nasim.K56 r31, final ir.nasim.C11458d25 r32, java.util.List r33, java.util.List r34, java.util.Set r35, ir.nasim.J44 r36, ir.nasim.C14505i18 r37, java.lang.Exception r38) {
        /*
            Method dump skipped, instructions count: 1015
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K56.i2(ir.nasim.Gn1, boolean, ir.nasim.K56, ir.nasim.d25, java.util.List, java.util.List, java.util.Set, ir.nasim.J44, ir.nasim.i18, java.lang.Exception):void");
    }

    private final boolean i3(C4778Gn1 c4778Gn1, J44 j44) {
        if (c4778Gn1.T() != null) {
            long jH = j44.h();
            J44 j44T = c4778Gn1.T();
            AbstractC13042fc3.f(j44T);
            if (jH <= j44T.h()) {
                return false;
            }
        }
        return true;
    }

    private final C9731aT1 j1() {
        E84 e84 = this.r;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        C9731aT1 c9731aT1K0 = e84.K0();
        AbstractC13042fc3.h(c9731aT1K0, "getDialogsInt(...)");
        return c9731aT1K0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(K56 k56, C11458d25 c11458d25, ExPeerType exPeerType, C11637dL5 c11637dL5, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(c11637dL5, "$diffUnreadCount");
        InterfaceC8344Vo3 interfaceC8344Vo3 = k56.q;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        k56.j1().q(c11458d25, c4778Gn1.c0());
        k56.S1(c11458d25, false, exPeerType, c4778Gn1.c0());
        k56.e1(c11458d25, c11637dL5.a * (-1));
    }

    private final void j3(final C11458d25 c11458d25, final long j, final long j2) {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.z56
            @Override // java.lang.Runnable
            public final void run() {
                K56.k3(c11458d25, j, j2);
            }
        });
    }

    private final ExPeerType k1(C11458d25 c11458d25, C4778Gn1 c4778Gn1) {
        ExPeerType exPeerTypeM1 = (c4778Gn1.getExPeerType() == null || c4778Gn1.getExPeerType() == ExPeerType.UNKNOWN) ? this.m.E().M1(c11458d25) : c4778Gn1.getExPeerType();
        return exPeerTypeM1 == null ? ExPeerType.UNKNOWN : exPeerTypeM1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(K56 k56, C11458d25 c11458d25, C14505i18 c14505i18) {
        C9528a7 c9528a7Z0;
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        if (!k56.U0(c11458d25).isEmpty() || (c9528a7Z0 = k56.m.G().z0(c11458d25)) == null) {
            return;
        }
        c9528a7Z0.d(new C3593Bn1.d(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k3(C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        C23709xO.a.c0(new T74(c11458d25, j, j2));
    }

    private final Map l1(C11458d25 c11458d25) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("PeerType", c11458d25.s().toString());
        linkedHashMap.put("PeerId", Integer.valueOf(c11458d25.getPeerId()));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 l2(Exception exc) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final C25254zz6 l3(C3681Bx c3681Bx) {
        C7714Sx c7714SxR = c3681Bx.r();
        ExPeerType exPeerTypeV = c3681Bx.u().r() == CA.PRIVATE ? ExPeerType.PRIVATE : ExPeerType.GROUP;
        if (c7714SxR != null && c7714SxR.q() != null) {
            exPeerTypeV = C18732p92.v(c7714SxR.q());
        }
        ExPeerType exPeerType = exPeerTypeV;
        C22993wA c22993wAU = c3681Bx.u();
        AbstractC13042fc3.h(c22993wAU, "getPeer(...)");
        return new C25254zz6(C18732p92.o(c22993wAU), "", c3681Bx.q(), c3681Bx.h(), exPeerType, c3681Bx.s() != null ? c3681Bx.s() : 0L, c3681Bx.w());
    }

    private final C23667xJ2 m1() {
        Object value = this.z.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (C23667xJ2) value;
    }

    private final void m2(C11458d25 c11458d25, long j, long j2, ExPeerType exPeerType, boolean z) {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        if (c4778Gn1.d0().isEmpty()) {
            return;
        }
        List listD0 = c4778Gn1.d0();
        AbstractC13042fc3.h(listD0, "getUnreadMentions(...)");
        List listO0 = AbstractC15401jX0.O0(listD0, new Q64(j2, j));
        InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
        if (interfaceC8344Vo33 == null) {
            AbstractC13042fc3.y("conversationStates");
        } else {
            interfaceC8344Vo32 = interfaceC8344Vo33;
        }
        interfaceC8344Vo32.e(c4778Gn1.L(listO0));
        j1().G(c11458d25, j, j2);
        if (z) {
            d3(c11458d25, j, j2, exPeerType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HF7 m3() {
        return ((FF7) C92.a(C5721Ko.a.d(), FF7.class)).h0();
    }

    private final C16504lO2 n1() {
        Object value = this.y.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (C16504lO2) value;
    }

    private final void n2(C11458d25 c11458d25, long j, long j2, ExPeerType exPeerType, boolean z) {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        if (c4778Gn1.e0().isEmpty()) {
            i1().k(c11458d25.u());
            return;
        }
        List listE0 = c4778Gn1.e0();
        AbstractC13042fc3.h(listE0, "getUnreadReactions(...)");
        List listO0 = AbstractC15401jX0.O0(listE0, new Q64(j2, j));
        InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
        if (interfaceC8344Vo33 == null) {
            AbstractC13042fc3.y("conversationStates");
        } else {
            interfaceC8344Vo32 = interfaceC8344Vo33;
        }
        interfaceC8344Vo32.e(c4778Gn1.M(listO0));
        j1().H(c11458d25, j, j2);
        if (z) {
            e3(c11458d25, j, j2, exPeerType);
        }
    }

    private final J44 n3(J44 j44, long j, AbstractC17457n0 abstractC17457n0, boolean z) {
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        List<J44> listR = ((C11907dl) abstractC17457n0F).r();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listR, 10));
        for (J44 j44U : listR) {
            if (j44U.i() == j) {
                j44U = j44U.u(abstractC17457n0, z);
            }
            arrayList.add(j44U);
        }
        C11907dl c11907dl = new C11907dl(arrayList);
        return j44.u(c11907dl, z).z(AbstractC12519el.a(c11907dl));
    }

    private final List o1(J44 j44, List list) {
        List listP1 = AbstractC15401jX0.p1(list);
        C23345wl7 c23345wl7L = j44.F().l();
        if (c23345wl7L != null && c23345wl7L.t().contains(Integer.valueOf(AbstractC5969Lp4.f())) && j44.U() != AbstractC5969Lp4.f()) {
            listP1.add(new Q64(j44.h(), j44.i()));
        }
        C8445Vz5 c8445Vz5Q = j44.Q();
        if (c8445Vz5Q != null && !c8445Vz5Q.E() && c8445Vz5Q.z() == AbstractC5969Lp4.f() && j44.U() != AbstractC5969Lp4.f()) {
            listP1.add(new Q64(j44.h(), j44.i()));
        }
        return AbstractC15401jX0.j0(listP1);
    }

    private final C6517Nv5 o2(final C11458d25 c11458d25, final long j) {
        C6517Nv5 c6517Nv5L0;
        boolean z;
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1K = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        boolean z2 = true;
        if (j > c4778Gn1K.Y()) {
            c4778Gn1K = c4778Gn1K.J(j);
            c6517Nv5L0 = j1().J(c11458d25, j);
            z = true;
        } else {
            c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            z = false;
        }
        if (j > c4778Gn1K.a0()) {
            c4778Gn1K = c4778Gn1K.K(j);
        } else {
            z2 = z;
        }
        if (!z2) {
            return c6517Nv5L0;
        }
        InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
        if (interfaceC8344Vo33 == null) {
            AbstractC13042fc3.y("conversationStates");
        } else {
            interfaceC8344Vo32 = interfaceC8344Vo33;
        }
        interfaceC8344Vo32.e(c4778Gn1K);
        return c6517Nv5L0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.v56
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                K56.p2(this.a, c11458d25, j, (C14505i18) obj);
            }
        });
    }

    private final boolean o3(C11458d25 c11458d25) {
        boolean zIsEmpty = U0(c11458d25).isEmpty();
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        if (c4778Gn1.h0() == zIsEmpty) {
            return false;
        }
        C4778Gn1 c4778Gn1Y = c4778Gn1.y(zIsEmpty);
        InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
        if (interfaceC8344Vo33 == null) {
            AbstractC13042fc3.y("conversationStates");
        } else {
            interfaceC8344Vo32 = interfaceC8344Vo33;
        }
        interfaceC8344Vo32.e(c4778Gn1Y);
        return true;
    }

    private final InterfaceC24602yt4 p1() {
        return (InterfaceC24602yt4) this.x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(K56 k56, C11458d25 c11458d25, long j, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        k56.m.N().G(c11458d25.getPeerId(), j);
    }

    private final void p3() {
        if (!C8386Vt0.u8() || C8386Vt0.X3()) {
            return;
        }
        InterfaceC20667sP1 interfaceC20667sP1I1 = i1();
        List listY = m1().y();
        AbstractC13042fc3.h(listY, "getUnreadExPeers(...)");
        interfaceC20667sP1I1.E(listY);
    }

    private final C25254zz6 q1(C25254zz6 c25254zz6) {
        C11458d25 c11458d25W;
        String name;
        ExPeerType exPeerType;
        String str;
        ExPeerType exPeerType2;
        if (c25254zz6 == null || (c11458d25W = c25254zz6.w()) == null) {
            return null;
        }
        W25 w25S = c11458d25W.s();
        W25 w25 = W25.b;
        ExPeerType exPeerType3 = w25S == w25 ? ExPeerType.GROUP : ExPeerType.PRIVATE;
        if (c11458d25W.s() == w25) {
            C14697iL2 c14697iL2 = (C14697iL2) this.m.E().X1().d(c11458d25W.getPeerId());
            if (c14697iL2 != null) {
                name = c14697iL2.G0();
                exPeerType = c14697iL2.getExPeerType();
                exPeerType2 = exPeerType;
                str = name;
            }
            str = "";
            exPeerType2 = exPeerType3;
        } else {
            if (c11458d25W.s() != W25.a) {
                return null;
            }
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(c11458d25W.getPeerId());
            if (c17637nI7 != null) {
                name = c17637nI7.getName();
                exPeerType = c17637nI7.getExPeerType();
                exPeerType2 = exPeerType;
                str = name;
            }
            str = "";
            exPeerType2 = exPeerType3;
        }
        return new C25254zz6(c11458d25W, str, c25254zz6.r(), c25254zz6.h(), exPeerType2, c25254zz6.s(), c25254zz6.u());
    }

    private final C6517Nv5 q2(C11458d25 c11458d25, long j, int i, long j2) {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1E = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        boolean z = false;
        boolean z2 = true;
        if (i < c4778Gn1E.c0()) {
            c6517Nv5L0 = j1().q(c11458d25, i);
            c4778Gn1E = c4778Gn1E.u(i);
            AbstractC13042fc3.f(c4778Gn1E);
            S1(c11458d25, false, k1(c11458d25, c4778Gn1E), c4778Gn1E.c0());
            z = true;
        } else if (i == 0) {
            c6517Nv5L0 = j1().q(c11458d25, i);
        }
        if (j2 > c4778Gn1E.R()) {
            c4778Gn1E = c4778Gn1E.E(j2);
        } else if (j > c4778Gn1E.R()) {
            c4778Gn1E = c4778Gn1E.E(j);
        } else {
            z2 = z;
        }
        if (z2) {
            InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
            if (interfaceC8344Vo33 == null) {
                AbstractC13042fc3.y("conversationStates");
            } else {
                interfaceC8344Vo32 = interfaceC8344Vo33;
            }
            interfaceC8344Vo32.e(c4778Gn1E);
        }
        AbstractC13042fc3.f(c6517Nv5L0);
        return c6517Nv5L0;
    }

    private final HF7 r1() {
        return (HF7) this.w.getValue();
    }

    private final C6517Nv5 r2(C11458d25 c11458d25, long j) {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        InterfaceC8344Vo3 interfaceC8344Vo32 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        if (j <= c4778Gn1.a0()) {
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.f(c6517Nv5L0);
            return c6517Nv5L0;
        }
        C4778Gn1 c4778Gn1K = c4778Gn1.K(j);
        InterfaceC8344Vo3 interfaceC8344Vo33 = this.q;
        if (interfaceC8344Vo33 == null) {
            AbstractC13042fc3.y("conversationStates");
        } else {
            interfaceC8344Vo32 = interfaceC8344Vo33;
        }
        interfaceC8344Vo32.e(c4778Gn1K);
        C6517Nv5 c6517Nv5K = j1().K(c11458d25, j);
        AbstractC13042fc3.f(c6517Nv5K);
        return c6517Nv5K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23667xJ2 s1(K56 k56) {
        AbstractC13042fc3.i(k56, "this$0");
        E84 e84 = k56.r;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        return e84.L0();
    }

    private final C6517Nv5 s2(C11458d25 c11458d25, J44 j44) {
        C18492ol c18492ol = C18492ol.a;
        C4275El c4275El = this.p;
        if (c4275El == null) {
            AbstractC13042fc3.y("albumToMessageIdDataSource");
            c4275El = null;
        }
        c18492ol.d(c4275El, c11458d25.u(), j44);
        return t2(c11458d25, AbstractC9766aX0.e(j44));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16504lO2 t1(K56 k56) {
        AbstractC13042fc3.i(k56, "this$0");
        E84 e84 = k56.r;
        if (e84 == null) {
            AbstractC13042fc3.y("messagesModule");
            e84 = null;
        }
        return e84.N0();
    }

    private final C6517Nv5 t2(final C11458d25 c11458d25, List list) {
        final ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((J44) obj).a0()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            C19406qI3.a("RouterActor", "UpdateMessage filteredMessages isEmpty", new Object[0]);
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        E84 e84 = null;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        final C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        C19406qI3.a("RouterActor", "UpdateMessage stateBeforeNewMessages: " + c4778Gn1, new Object[0]);
        boolean z = c4778Gn1.getExPeerType() == null || c4778Gn1.getExPeerType() == ExPeerType.UNKNOWN;
        C19406qI3.a("RouterActor", "UpdateMessage loadPeerDialogNeeded: " + z, new Object[0]);
        C6517Nv5 c6517Nv5L02 = C6517Nv5.l0(C14505i18.a);
        if (z) {
            C17557nA c17557nA = new C17557nA(c11458d25.s().p(), c11458d25.getPeerId(), 0L);
            E84 e842 = this.r;
            if (e842 == null) {
                AbstractC13042fc3.y("messagesModule");
            } else {
                e84 = e842;
            }
            c6517Nv5L02 = e84.M1(AbstractC9766aX0.e(c17557nA), false);
        }
        final boolean z2 = z;
        C6517Nv5 c6517Nv5G = c6517Nv5L02.z(new InterfaceC3273Ae1() { // from class: ir.nasim.f56
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj2, Object obj3) {
                K56.u2(c4778Gn1, z2, this, c11458d25, arrayList, (C14505i18) obj2, (Exception) obj3);
            }
        }).G(new InterfaceC17569nB2() { // from class: ir.nasim.g56
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj2) {
                return K56.x2((Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5G, "fallback(...)");
        return c6517Nv5G;
    }

    private final void u1(C11458d25 c11458d25, boolean z) {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.q;
        if (interfaceC8344Vo3 == null) {
            AbstractC13042fc3.y("conversationStates");
            interfaceC8344Vo3 = null;
        }
        C4778Gn1 c4778Gn1 = (C4778Gn1) interfaceC8344Vo3.d(c11458d25.u());
        AbstractC13042fc3.f(c4778Gn1);
        S1(c11458d25, z, k1(c11458d25, c4778Gn1), c4778Gn1.c0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void u2(ir.nasim.C4778Gn1 r20, boolean r21, final ir.nasim.K56 r22, final ir.nasim.C11458d25 r23, final java.util.List r24, ir.nasim.C14505i18 r25, java.lang.Exception r26) {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K56.u2(ir.nasim.Gn1, boolean, ir.nasim.K56, ir.nasim.d25, java.util.List, ir.nasim.i18, java.lang.Exception):void");
    }

    private final void v1(C15819kD7 c15819kD7) {
        List listN0 = AbstractC15401jX0.n0(c15819kD7.a());
        C9731aT1 c9731aT1J1 = j1();
        List<C8421Vx> list = listN0;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (C8421Vx c8421Vx : list) {
            W25 w25Z0 = Z0(c8421Vx);
            if (w25Z0 == null) {
                return;
            } else {
                arrayList.add(new C11458d25(w25Z0, c8421Vx.q()));
            }
        }
        c9731aT1J1.r(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(final C11458d25 c11458d25, K56 k56, ExPeerType exPeerType, C12889fL5 c12889fL5, List list, C12889fL5 c12889fL52, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(k56, "this$0");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(c12889fL5, "$lastState");
        AbstractC13042fc3.i(list, "$filteredMessages");
        AbstractC13042fc3.i(c12889fL52, "$lastMessage");
        C19406qI3.a("RouterActor", "dialog's onMessage then with peerId: " + c11458d25.getPeerId(), new Object[0]);
        k56.S1(c11458d25, true, exPeerType, ((C4778Gn1) c12889fL5.a).c0());
        List list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((J44) it.next()).F() instanceof J08) {
                    AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.y56
                        @Override // java.lang.Runnable
                        public final void run() {
                            K56.w2(c11458d25);
                        }
                    });
                    break;
                }
            }
        }
        if (exPeerType != ExPeerType.PRIVATE || ((J44) c12889fL52.a).U() == k56.m.i0()) {
            return;
        }
        k56.m.N().G(((J44) c12889fL52.a).U(), ((J44) c12889fL52.a).h());
    }

    private final void w1(C17001mD7 c17001mD7) {
        List listN0 = AbstractC15401jX0.n0(c17001mD7.a());
        C9731aT1 c9731aT1J1 = j1();
        List<C8421Vx> list = listN0;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (C8421Vx c8421Vx : list) {
            W25 w25Z0 = Z0(c8421Vx);
            if (w25Z0 == null) {
                return;
            } else {
                arrayList.add(new C11458d25(w25Z0, c8421Vx.q()));
            }
        }
        c9731aT1J1.s(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        C23709xO.a.d0(c11458d25);
    }

    private final void x1(C18183oD7 c18183oD7) {
        j1().t(c18183oD7.a(), c18183oD7.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 x2(Exception exc) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final void y1(C23618xD7 c23618xD7) {
        C7429Rr2 c7429Rr2A = c23618xD7.a();
        if (c7429Rr2A != null) {
            j1().v(c7429Rr2A.a(), c7429Rr2A.b(), c23618xD7.b(), c7429Rr2A.c());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C6517Nv5 y2(ir.nasim.C11458d25 r35, long r36) {
        /*
            r34 = this;
            r0 = r34
            r1 = r36
            ir.nasim.Yh4 r3 = r0.m
            ir.nasim.E84 r3 = r3.G()
            r4 = r35
            ir.nasim.DB3 r3 = r3.H0(r4)
            ir.nasim.nl0 r5 = r3.a(r1)
            ir.nasim.J44 r5 = (ir.nasim.J44) r5
            java.lang.String r6 = "messagesModule"
            r7 = 0
            if (r5 != 0) goto L4c
            ir.nasim.E84 r8 = r0.r
            if (r8 != 0) goto L23
            ir.nasim.AbstractC13042fc3.y(r6)
            r8 = r7
        L23:
            ir.nasim.DB3 r8 = r8.F0()
            if (r8 == 0) goto L30
            ir.nasim.nl0 r8 = r8.a(r1)
            ir.nasim.J44 r8 = (ir.nasim.J44) r8
            goto L31
        L30:
            r8 = r7
        L31:
            if (r8 == 0) goto L4c
            ir.nasim.E84 r3 = r0.r
            if (r3 != 0) goto L3b
            ir.nasim.AbstractC13042fc3.y(r6)
            r3 = r7
        L3b:
            ir.nasim.DB3 r3 = r3.F0()
            ir.nasim.nl0 r5 = r3.a(r1)
            ir.nasim.J44 r5 = (ir.nasim.J44) r5
            r8 = 1
        L46:
            r33 = r8
            r8 = r5
            r5 = r33
            goto L4e
        L4c:
            r8 = 0
            goto L46
        L4e:
            if (r8 == 0) goto Lbe
            ir.nasim.x74 r9 = r8.L()
            ir.nasim.x74 r10 = ir.nasim.EnumC23558x74.PENDING
            if (r9 != r10) goto Lbe
            ir.nasim.x74 r16 = ir.nasim.EnumC23558x74.ERROR
            r31 = 262127(0x3ffef, float:3.67318E-40)
            r32 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            ir.nasim.J44 r8 = ir.nasim.J44.D(r8, r9, r11, r13, r15, r16, r17, r18, r19, r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            ir.nasim.E84 r9 = r0.r
            if (r9 != 0) goto L8c
            ir.nasim.AbstractC13042fc3.y(r6)
            r9 = r7
        L8c:
            ir.nasim.DB3 r9 = r9.F0()
            if (r9 == 0) goto L99
            ir.nasim.nl0 r1 = r9.a(r1)
            ir.nasim.J44 r1 = (ir.nasim.J44) r1
            goto L9a
        L99:
            r1 = r7
        L9a:
            if (r1 == 0) goto Lb6
            ir.nasim.E84 r1 = r0.r
            if (r1 != 0) goto La4
            ir.nasim.AbstractC13042fc3.y(r6)
            goto La5
        La4:
            r7 = r1
        La5:
            ir.nasim.DB3 r1 = r7.F0()
            if (r1 == 0) goto Lb6
            ir.nasim.Vz5 r2 = r0.h1(r8)
            ir.nasim.J44 r2 = r8.E(r2)
            r1.d(r2)
        Lb6:
            if (r5 != 0) goto Lbb
            r3.d(r8)
        Lbb:
            r34.o3(r35)
        Lbe:
            ir.nasim.i18 r1 = ir.nasim.C14505i18.a
            ir.nasim.Nv5 r1 = ir.nasim.C6517Nv5.l0(r1)
            java.lang.String r2 = "success(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K56.y2(ir.nasim.d25, long):ir.nasim.Nv5");
    }

    private final void z1(C24802zD7 c24802zD7) {
        j1().w(c24802zD7.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C6517Nv5 z2(ir.nasim.C11458d25 r34, ir.nasim.J44 r35) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K56.z2(ir.nasim.d25, ir.nasim.J44):ir.nasim.Nv5");
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(final Object obj) {
        C8445Vz5 c8445Vz5;
        AbstractC17457n0 abstractC17457n0;
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof C18706p66) {
            return N2(((C18706p66) obj).a());
        }
        if (obj instanceof C22960w66) {
            C22960w66 c22960w66 = (C22960w66) obj;
            List listB = c22960w66.b();
            AbstractC13042fc3.h(listB, "getUsers(...)");
            List listA = c22960w66.a();
            AbstractC13042fc3.h(listA, "getGroups(...)");
            return E2(listB, listA);
        }
        if (obj instanceof N56) {
            N56 n56 = (N56) obj;
            C11458d25 c11458d25E = n56.e();
            AbstractC13042fc3.h(c11458d25E, "getPeer(...)");
            Y64 y64D = n56.d();
            AbstractC13042fc3.h(y64D, "getMessageLoadHistoryResult(...)");
            Long lB = n56.b();
            Long lC = n56.c();
            boolean zF = n56.f();
            DB3 db3A = n56.a();
            AbstractC13042fc3.h(db3A, "getListEngine(...)");
            return b2(c11458d25E, y64D, lB, lC, zF, db3A);
        }
        if (obj instanceof O56) {
            List listA2 = ((O56) obj).a();
            AbstractC13042fc3.h(listA2, "getDialogs(...)");
            return f2(listA2);
        }
        E84 e84 = null;
        if (obj instanceof C19888r66) {
            final ArrayList arrayList = new ArrayList();
            C19888r66 c19888r66 = (C19888r66) obj;
            for (CE7 ce7 : c19888r66.a()) {
                AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(ce7.d());
                if (ce7.g() != null) {
                    boolean z = abstractC17457n0H instanceof C18121o72;
                    C8445Vz5 c8445Vz5Y = C8445Vz5.y(this.m, ce7.g(), z);
                    if (z) {
                        abstractC17457n0H = c8445Vz5Y.r();
                    }
                    abstractC17457n0 = abstractC17457n0H;
                    c8445Vz5 = c8445Vz5Y;
                } else {
                    c8445Vz5 = null;
                    abstractC17457n0 = abstractC17457n0H;
                }
                long jH = ce7.h();
                long jA = ce7.a();
                long jA2 = ce7.a();
                int i = ce7.i();
                EnumC23558x74 enumC23558x74 = this.m.i0() == ce7.i() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN;
                AbstractC13042fc3.f(abstractC17457n0);
                arrayList.add(new J44(jH, jA, jA2, i, enumC23558x74, abstractC17457n0, new ArrayList(), 0, c8445Vz5, null, 0L, ce7.f(), null, false, ce7.b(), null, false, ce7.j(), null, 360448, null));
            }
            C11458d25 c11458d25B = c19888r66.b();
            AbstractC13042fc3.h(c11458d25B, "getPeer(...)");
            return t2(c11458d25B, arrayList).m0(new InterfaceC24449ye1() { // from class: ir.nasim.F56
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    K56.W1(obj, arrayList, this, (C14505i18) obj2);
                }
            });
        }
        if (obj instanceof C19297q66) {
            ArrayList arrayList2 = new ArrayList();
            C19297q66 c19297q66 = (C19297q66) obj;
            arrayList2.add(c19297q66.a());
            C11458d25 c11458d25B2 = c19297q66.b();
            AbstractC13042fc3.h(c11458d25B2, "getPeer(...)");
            return t2(c11458d25B2, arrayList2);
        }
        if (obj instanceof C21100t66) {
            C21100t66 c21100t66 = (C21100t66) obj;
            C11458d25 c11458d25B3 = c21100t66.b();
            AbstractC13042fc3.h(c11458d25B3, "getPeer(...)");
            J44 j44A = c21100t66.a();
            AbstractC13042fc3.h(j44A, "getMessage(...)");
            return z2(c11458d25B3, j44A);
        }
        if (obj instanceof V56) {
            V56 v56 = (V56) obj;
            return V0(v56.b(), v56.c(), v56.a());
        }
        if (obj instanceof C20497s66) {
            C20497s66 c20497s66 = (C20497s66) obj;
            C11458d25 c11458d25A = c20497s66.a();
            AbstractC13042fc3.h(c11458d25A, "getPeer(...)");
            return y2(c11458d25A, c20497s66.b());
        }
        if (obj instanceof C18115o66) {
            C18115o66 c18115o66 = (C18115o66) obj;
            C11458d25 c11458d25B4 = c18115o66.b();
            AbstractC13042fc3.h(c11458d25B4, "getPeer(...)");
            long jC = c18115o66.c();
            AbstractC17457n0 abstractC17457n0A = c18115o66.a();
            AbstractC13042fc3.h(abstractC17457n0A, "getContent(...)");
            return c2(c11458d25B4, jC, -1L, abstractC17457n0A, true);
        }
        if (!(obj instanceof W56)) {
            return obj instanceof YF2 ? X2(this, false, 1, null) : super.G(obj);
        }
        E84 e842 = this.r;
        if (e842 == null) {
            AbstractC13042fc3.y("messagesModule");
        } else {
            e84 = e842;
        }
        W56 w56 = (W56) obj;
        e84.U0().d(new C6434No6.C6443i(w56.c()));
        C11458d25 c11458d25B5 = w56.b();
        AbstractC13042fc3.h(c11458d25B5, "getPeer(...)");
        List listC = w56.c();
        AbstractC13042fc3.h(listC, "getRids(...)");
        List listA3 = w56.a();
        AbstractC13042fc3.h(listA3, "getDates(...)");
        return h2(c11458d25B5, listC, listA3);
    }

    public final C6517Nv5 N2(final AbstractC20556sC7 abstractC20556sC7) {
        E84 e84;
        AbstractC17457n0 abstractC17457n0;
        C8445Vz5 c8445Vz5;
        if (abstractC20556sC7 instanceof EF7) {
            K1((EF7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        if (abstractC20556sC7 instanceof KE7) {
            I1((KE7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L02 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L02, "success(...)");
            return c6517Nv5L02;
        }
        if (abstractC20556sC7 instanceof C9611aF7) {
            J1((C9611aF7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L03 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L03, "success(...)");
            return c6517Nv5L03;
        }
        if (abstractC20556sC7 instanceof C23618xD7) {
            y1((C23618xD7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L04 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L04, "success(...)");
            return c6517Nv5L04;
        }
        if (abstractC20556sC7 instanceof C24802zD7) {
            z1((C24802zD7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L05 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L05, "success(...)");
            return c6517Nv5L05;
        }
        if (abstractC20556sC7 instanceof BD7) {
            A1((BD7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L06 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L06, "success(...)");
            return c6517Nv5L06;
        }
        if (abstractC20556sC7 instanceof DD7) {
            B1((DD7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L07 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L07, "success(...)");
            return c6517Nv5L07;
        }
        if (abstractC20556sC7 instanceof C18183oD7) {
            x1((C18183oD7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L08 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L08, "success(...)");
            return c6517Nv5L08;
        }
        if (abstractC20556sC7 instanceof C15837kF7) {
            F1((C15837kF7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L09 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L09, "success(...)");
            return c6517Nv5L09;
        }
        if (abstractC20556sC7 instanceof AE7) {
            G1((AE7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L010 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L010, "success(...)");
            return c6517Nv5L010;
        }
        if (abstractC20556sC7 instanceof IE7) {
            E1((IE7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L011 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L011, "success(...)");
            return c6517Nv5L011;
        }
        if (abstractC20556sC7 instanceof C15819kD7) {
            v1((C15819kD7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L012 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L012, "success(...)");
            return c6517Nv5L012;
        }
        if (abstractC20556sC7 instanceof C17001mD7) {
            w1((C17001mD7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L013 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L013, "success(...)");
            return c6517Nv5L013;
        }
        if (abstractC20556sC7 instanceof OE7) {
            H1((OE7) abstractC20556sC7);
            C6517Nv5 c6517Nv5L014 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L014, "success(...)");
            return c6517Nv5L014;
        }
        if (abstractC20556sC7 instanceof CE7) {
            CE7 ce7 = (CE7) abstractC20556sC7;
            C11458d25 c11458d25E = ce7.e();
            C19406qI3.a("RouterActor", "UpdateMessage received: " + (c11458d25E != null ? Integer.valueOf(c11458d25E.getPeerId()) : null), new Object[0]);
            final C11458d25 c11458d25E2 = ce7.e();
            AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(ce7.d());
            C19406qI3.a("RouterActor", "UpdateMessage msgContent: " + abstractC17457n0H, new Object[0]);
            if (ce7.g() != null) {
                boolean z = abstractC17457n0H instanceof C18121o72;
                C8445Vz5 c8445Vz5Y = C8445Vz5.y(this.m, ce7.g(), z);
                if (z) {
                    abstractC17457n0H = c8445Vz5Y.r();
                }
                C19406qI3.a("RouterActor", "UpdateMessage getQuotedMessage: " + c8445Vz5Y, new Object[0]);
                c8445Vz5 = c8445Vz5Y;
                abstractC17457n0 = abstractC17457n0H;
            } else {
                abstractC17457n0 = abstractC17457n0H;
                c8445Vz5 = null;
            }
            long jH = ce7.h();
            long jA = ce7.a();
            long jA2 = ce7.a();
            int i = ce7.i();
            EnumC23558x74 enumC23558x74 = this.m.i0() == ce7.i() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN;
            AbstractC13042fc3.f(abstractC17457n0);
            final J44 j44 = new J44(jH, jA, jA2, i, enumC23558x74, abstractC17457n0, new ArrayList(), 0, c8445Vz5, null, 0L, ce7.f(), null, false, ce7.b(), null, ce7.c(), null, null, 438784, null);
            C6517Nv5 c6517Nv5M0 = t2(c11458d25E2, AbstractC10360bX0.g(j44)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Y46
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    K56.O2(c11458d25E2, j44, abstractC20556sC7, this, (C14505i18) obj);
                }
            });
            AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
            return c6517Nv5M0;
        }
        if (abstractC20556sC7 instanceof YE7) {
            YE7 ye7 = (YE7) abstractC20556sC7;
            C11458d25 c11458d25B = ye7.b();
            List listA1 = AbstractC15401jX0.a1(ye7.a(), new c());
            List list = listA1;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    AbstractC10360bX0.w();
                }
                C25247zz c25247zz = (C25247zz) obj;
                AbstractC17457n0 abstractC17457n0H2 = AbstractC17457n0.h(c25247zz.s());
                C16975mB c16975mBY = c25247zz.y();
                C8445Vz5 c8445Vz5Y2 = c16975mBY != null ? C8445Vz5.y(this.m, c16975mBY, abstractC17457n0H2 instanceof C18121o72) : null;
                if ((abstractC17457n0H2 instanceof C18121o72) && c8445Vz5Y2 != null) {
                    abstractC17457n0H2 = c8445Vz5Y2.r();
                }
                long jI = c25247zz.i();
                long jH2 = c25247zz.h();
                long jH3 = c25247zz.h();
                int iD = c25247zz.D();
                EnumC23558x74 enumC23558x742 = EnumC23558x74.SENT;
                AbstractC13042fc3.h(abstractC17457n0H2, "element");
                ArrayList arrayList2 = new ArrayList();
                C18732p92 c18732p92 = C18732p92.a;
                C23592xB c23592xBC = c25247zz.C();
                Boolean boolF = c25247zz.F();
                C17532n74 c17532n74D = c18732p92.D(c23592xBC, boolF != null ? boolF.booleanValue() : false);
                Boolean boolF2 = c25247zz.F();
                boolean zBooleanValue = boolF2 != null ? boolF2.booleanValue() : false;
                C3460Az c3460AzW = c25247zz.w();
                C25247zz c25247zz2 = (C25247zz) AbstractC15401jX0.t0(listA1, i3);
                arrayList.add(new J44(jI, jH2, jH3, iD, enumC23558x742, abstractC17457n0H2, arrayList2, 0, c8445Vz5Y2, null, 0L, c3460AzW, c25247zz2 != null ? new C3460Az(c25247zz2.i(), c25247zz2.h(), 0L) : null, false, c25247zz.r(), c17532n74D, zBooleanValue, null, null, 401920, null));
                i2 = i3;
            }
            if (arrayList.isEmpty()) {
                C19406qI3.a("RouterActor", "RouterActor: UpdateMessages, empty album!", new Object[0]);
                C6517Nv5 c6517Nv5L015 = C6517Nv5.l0(C14505i18.a);
                AbstractC13042fc3.h(c6517Nv5L015, "success(...)");
                return c6517Nv5L015;
            }
            J44 j442 = (J44) AbstractC15401jX0.C0(arrayList);
            Long lJ = j442.J();
            if (lJ != null) {
                Long l = lJ.longValue() != 0 ? lJ : null;
                if (l != null) {
                    long jLongValue = l.longValue();
                    C11907dl c11907dl = new C11907dl(arrayList);
                    Iterator it = arrayList.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object next = it.next();
                    if (it.hasNext()) {
                        long jH4 = ((J44) next).h();
                        do {
                            Object next2 = it.next();
                            long jH5 = ((J44) next2).h();
                            if (jH4 < jH5) {
                                next = next2;
                                jH4 = jH5;
                            }
                        } while (it.hasNext());
                    }
                    J44 j443 = (J44) next;
                    return s2(c11458d25B, new J44(jLongValue, j442.h(), j442.h(), j442.U(), EnumC23558x74.SENT, c11907dl, AbstractC12519el.a(c11907dl), 0, j442.Q(), null, 0L, null, null, false, null, j443.T(), j443.K(), null, null, 425600, null));
                }
            }
            C6517Nv5 c6517Nv5L016 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L016, "success(...)");
            return c6517Nv5L016;
        }
        if (abstractC20556sC7 instanceof WE7) {
            WE7 we7 = (WE7) abstractC20556sC7;
            C11458d25 c11458d25B2 = we7.b();
            if (!M1(c11458d25B2)) {
                C6517Nv5 c6517Nv5L017 = C6517Nv5.l0(C14505i18.a);
                AbstractC13042fc3.h(c6517Nv5L017, "success(...)");
                return c6517Nv5L017;
            }
            E84 e842 = this.r;
            if (e842 == null) {
                AbstractC13042fc3.y("messagesModule");
                e84 = null;
            } else {
                e84 = e842;
            }
            e84.U0().d(new C6434No6.l(c11458d25B2, we7.d(), we7.a()));
            return B2(c11458d25B2, we7.d(), we7.a(), we7.c());
        }
        if (abstractC20556sC7 instanceof QE7) {
            QE7 qe7 = (QE7) abstractC20556sC7;
            C11458d25 c11458d25A = qe7.a();
            if (M1(c11458d25A)) {
                return o2(c11458d25A, qe7.b());
            }
            C6517Nv5 c6517Nv5L018 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.f(c6517Nv5L018);
            return c6517Nv5L018;
        }
        if (abstractC20556sC7 instanceof RE7) {
            RE7 re7 = (RE7) abstractC20556sC7;
            final C11458d25 c11458d25B3 = re7.b();
            if (!M1(c11458d25B3)) {
                C6517Nv5 c6517Nv5L019 = C6517Nv5.l0(C14505i18.a);
                AbstractC13042fc3.h(c6517Nv5L019, "success(...)");
                return c6517Nv5L019;
            }
            Integer numD = re7.d();
            int iIntValue = numD != null ? numD.intValue() : 0;
            Long lA = re7.a();
            C6517Nv5 c6517Nv5M02 = q2(c11458d25B3, re7.c(), iIntValue, lA != null ? lA.longValue() : 0L).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Z46
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    K56.P2(c11458d25B3, abstractC20556sC7, this, (C14505i18) obj2);
                }
            });
            AbstractC13042fc3.h(c6517Nv5M02, "then(...)");
            return c6517Nv5M02;
        }
        if (abstractC20556sC7 instanceof UE7) {
            UE7 ue7 = (UE7) abstractC20556sC7;
            C11458d25 c11458d25A2 = ue7.a();
            if (M1(c11458d25A2)) {
                return r2(c11458d25A2, ue7.b());
            }
            C6517Nv5 c6517Nv5L020 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.f(c6517Nv5L020);
            return c6517Nv5L020;
        }
        if (abstractC20556sC7 instanceof C9593aD7) {
            C11458d25 c11458d25A3 = ((C9593aD7) abstractC20556sC7).a();
            if (M1(c11458d25A3)) {
                return Z1(c11458d25A3);
            }
            C6517Nv5 c6517Nv5L021 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.f(c6517Nv5L021);
            return c6517Nv5L021;
        }
        if (abstractC20556sC7 instanceof YC7) {
            C11458d25 c11458d25A4 = ((YC7) abstractC20556sC7).a();
            if (M1(c11458d25A4)) {
                return Y1(c11458d25A4);
            }
            C6517Nv5 c6517Nv5L022 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.f(c6517Nv5L022);
            return c6517Nv5L022;
        }
        if (abstractC20556sC7 instanceof C10803cD7) {
            K2(((C10803cD7) abstractC20556sC7).a(), true, true, false);
            C6517Nv5 c6517Nv5L023 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L023, "success(...)");
            return c6517Nv5L023;
        }
        if (abstractC20556sC7 instanceof FE7) {
            FE7 fe7 = (FE7) abstractC20556sC7;
            final C11458d25 c11458d25B4 = fe7.b();
            if (M1(c11458d25B4)) {
                C6517Nv5 c6517Nv5M03 = h2(c11458d25B4, fe7.c(), fe7.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.a56
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        K56.Q2(c11458d25B4, abstractC20556sC7, (C14505i18) obj2);
                    }
                });
                AbstractC13042fc3.f(c6517Nv5M03);
                return c6517Nv5M03;
            }
            C6517Nv5 c6517Nv5L024 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.f(c6517Nv5L024);
            return c6517Nv5L024;
        }
        if (!(abstractC20556sC7 instanceof DE7)) {
            C6517Nv5 c6517Nv5L025 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L025, "success(...)");
            return c6517Nv5L025;
        }
        DE7 de7 = (DE7) abstractC20556sC7;
        final C11458d25 c11458d25C = de7.c();
        if (!M1(c11458d25C)) {
            C6517Nv5 c6517Nv5L026 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L026, "success(...)");
            return c6517Nv5L026;
        }
        if (de7.b() != null && (de7.b() instanceof C14449hw)) {
            return C1(de7);
        }
        AbstractC17457n0 abstractC17457n0H3 = AbstractC17457n0.h(de7.b());
        long jD = de7.d();
        Long lA2 = de7.a();
        long jLongValue2 = lA2 != null ? lA2.longValue() : -1L;
        AbstractC13042fc3.f(abstractC17457n0H3);
        C6517Nv5 c6517Nv5M04 = c2(c11458d25C, jD, jLongValue2, abstractC17457n0H3, false).m0(new InterfaceC24449ye1() { // from class: ir.nasim.b56
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj2) {
                K56.R2(c11458d25C, abstractC20556sC7, this, (C14505i18) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M04, "then(...)");
        return c6517Nv5M04;
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        if (!n1().r()) {
            U2().z(new InterfaceC3273Ae1() { // from class: ir.nasim.E56
                @Override // ir.nasim.InterfaceC3273Ae1
                public final void apply(Object obj, Object obj2) {
                    K56.J2(this.a, (C14505i18) obj, (Exception) obj2);
                }
            });
            return;
        }
        if (AbstractC20507s76.p() - W().getLong("LAST_LOAD_GROUPED_DIALOG_TIME_", 0L) > this.m.S().L3()) {
            W2(true);
        } else {
            R1(true);
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof U56) {
            U56 u56 = (U56) obj;
            C11458d25 c11458d25B = u56.b();
            AbstractC13042fc3.h(c11458d25B, "getPeer(...)");
            ExPeerType exPeerTypeA = u56.a();
            AbstractC13042fc3.h(exPeerTypeA, "getExPeerType(...)");
            e2(c11458d25B, exPeerTypeA);
            return;
        }
        if (obj instanceof T56) {
            C11458d25 c11458d25A = ((T56) obj).a();
            AbstractC13042fc3.h(c11458d25A, "getPeer(...)");
            d2(c11458d25A);
            return;
        }
        if (obj instanceof M56) {
            V1();
            return;
        }
        if (obj instanceof L56) {
            U1();
            return;
        }
        if (obj instanceof C16690li0) {
            C11458d25 c11458d25A2 = ((C16690li0) obj).a();
            AbstractC13042fc3.h(c11458d25A2, "getPeer(...)");
            X1(c11458d25A2);
            return;
        }
        if (obj instanceof ZE4) {
            R1(((ZE4) obj).a());
            return;
        }
        if (obj instanceof R56) {
            R56 r56 = (R56) obj;
            C11458d25 c11458d25A3 = r56.a();
            AbstractC13042fc3.h(c11458d25A3, "getPeer(...)");
            u1(c11458d25A3, r56.b());
            return;
        }
        if (obj instanceof C16342l66.a) {
            C16342l66.a aVar = (C16342l66.a) obj;
            C11458d25 c11458d25A4 = aVar.a();
            AbstractC13042fc3.h(c11458d25A4, "getPeer(...)");
            P1(c11458d25A4, aVar.b());
            return;
        }
        if (obj instanceof C16342l66.b) {
            C16342l66.b bVar = (C16342l66.b) obj;
            C11458d25 c11458d25C = bVar.c();
            AbstractC13042fc3.h(c11458d25C, "getPeer(...)");
            O1(c11458d25C, bVar.a(), bVar.b());
            return;
        }
        if (!(obj instanceof C23550x66)) {
            if (!(obj instanceof C24140y66)) {
                super.m(obj);
                return;
            } else {
                C24140y66 c24140y66 = (C24140y66) obj;
                I2(c24140y66.b(), c24140y66.c(), c24140y66.a());
                return;
            }
        }
        C23550x66 c23550x66 = (C23550x66) obj;
        C11458d25 c11458d25C2 = c23550x66.c();
        AbstractC13042fc3.h(c11458d25C2, "getPeer(...)");
        Q64 q64B = c23550x66.b();
        AbstractC13042fc3.h(q64B, "getMention(...)");
        ExPeerType exPeerTypeA2 = c23550x66.a();
        AbstractC13042fc3.h(exPeerTypeA2, "getExPeerType(...)");
        H2(c11458d25C2, q64B, exPeerTypeA2);
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        E84 e84G = this.m.G();
        this.r = e84G;
        if (e84G == null) {
            AbstractC13042fc3.y("messagesModule");
            e84G = null;
        }
        this.q = e84G.I0().o();
        this.p = ((InterfaceC6280My1) C92.a(C5721Ko.a.d(), InterfaceC6280My1.class)).s0();
        r().d(new ZE4(false));
    }
}
