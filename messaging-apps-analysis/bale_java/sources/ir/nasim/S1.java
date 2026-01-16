package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$RawValue;
import ai.bale.proto.MessagingOuterClass$RequestForwardMessages;
import ai.bale.proto.MessagingStruct$MessageOutReference;
import ai.bale.proto.Misc$ResponseSeqDate;
import ai.bale.proto.PeersStruct$OutExPeer;
import ai.bale.proto.PeersStruct$OutPeer;
import android.gov.nist.core.Separators;
import ir.nasim.C6434No6;
import ir.nasim.Q12;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes5.dex */
public abstract class S1 extends AbstractC6360Ng4 {
    private static final a r = new a(null);
    public static final int s = 8;
    private static final long t;
    private final C9057Yh4 m;
    private long n;
    protected C20466s35 o;
    protected HashMap p;
    private final InterfaceC9173Yu3 q;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        private final C11458d25 a;
        private final C11458d25 b;
        private final J44 c;

        public b(C11458d25 c11458d25, C11458d25 c11458d252, J44 j44) {
            AbstractC13042fc3.i(c11458d25, "fromPeer");
            AbstractC13042fc3.i(c11458d252, "targetPeer");
            AbstractC13042fc3.i(j44, "albumMessage");
            this.a = c11458d25;
            this.b = c11458d252;
            this.c = j44;
        }

        public final J44 a() {
            return this.c;
        }

        public final C11458d25 b() {
            return this.a;
        }

        public final C11458d25 c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "ForwardAlbum(fromPeer=" + this.a + ", targetPeer=" + this.b + ", albumMessage=" + this.c + Separators.RPAREN;
        }
    }

    public static final class c {
        private final C11458d25 a;
        private final C11458d25 b;
        private final List c;

        public c(C11458d25 c11458d25, C11458d25 c11458d252, List list) {
            AbstractC13042fc3.i(c11458d25, "fromPeer");
            AbstractC13042fc3.i(c11458d252, "targetPeer");
            AbstractC13042fc3.i(list, "messages");
            this.a = c11458d25;
            this.b = c11458d252;
            this.c = list;
        }

        public final C11458d25 a() {
            return this.a;
        }

        public final List b() {
            return this.c;
        }

        public final C11458d25 c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "ForwardMessages(fromPeer=" + this.a + ", targetPeer=" + this.b + ", messages=" + this.c + Separators.RPAREN;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return S1.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC12532em2 interfaceC12532em2M0 = S1.this.M0();
                long j = this.d;
                long jF = AbstractC5969Lp4.f();
                this.b = 1;
                if (interfaceC12532em2M0.f(j, jF, this) == objE) {
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

    public static final class e implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((J44) obj).h()), Long.valueOf(((J44) obj2).h()));
        }
    }

    public static final class f implements InterfaceC6990Pv5 {
        final /* synthetic */ C6517Nv5 a;
        final /* synthetic */ C6517Nv5 b;

        public static final class a implements InterfaceC3273Ae1 {
            final /* synthetic */ C7234Qv5 a;
            final /* synthetic */ C6517Nv5 b;

            /* renamed from: ir.nasim.S1$f$a$a, reason: collision with other inner class name */
            public static final class C0607a implements InterfaceC24449ye1 {
                final /* synthetic */ C7234Qv5 a;

                public C0607a(C7234Qv5 c7234Qv5) {
                    this.a = c7234Qv5;
                }

                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.b(obj);
                }
            }

            public static final class b implements InterfaceC24449ye1 {
                final /* synthetic */ C7234Qv5 a;

                public b(C7234Qv5 c7234Qv5) {
                    this.a = c7234Qv5;
                }

                @Override // ir.nasim.InterfaceC24449ye1
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void apply(Exception exc) {
                    this.a.a(exc);
                }
            }

            public a(C7234Qv5 c7234Qv5, C6517Nv5 c6517Nv5) {
                this.a = c7234Qv5;
                this.b = c6517Nv5;
            }

            @Override // ir.nasim.InterfaceC3273Ae1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void apply(Object obj, Exception exc) {
                this.b.m0(new C0607a(this.a)).E(new b(this.a)).k0();
            }
        }

        public f(C6517Nv5 c6517Nv5, C6517Nv5 c6517Nv52) {
            this.a = c6517Nv5;
            this.b = c6517Nv52;
        }

        @Override // ir.nasim.InterfaceC6990Pv5
        public final void a(C7234Qv5 c7234Qv5) {
            AbstractC13042fc3.i(c7234Qv5, "resolver");
            this.a.z(new a(c7234Qv5, this.b));
            this.a.k0();
        }
    }

    static {
        Q12.a aVar = Q12.b;
        t = Q12.A(T12.s(24, W12.g));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S1(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.q = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.I1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S1.w0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(S1 s1, C11458d25 c11458d25, long j, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        AbstractC13042fc3.i(s1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$toPeer");
        long date = misc$ResponseSeqDate.getDate();
        Map<String, CollectionsStruct$RawValue> extMap = misc$ResponseSeqDate.getExtMap();
        s1.P0(c11458d25, j, date, extMap != null ? s1.v0(extMap) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(S1 s1, C11458d25 c11458d25, long j, Exception exc) {
        AbstractC13042fc3.i(s1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$toPeer");
        C19406qI3.c("Sender", "forwardAlbumMessage", exc);
        s1.r().d(new C6434No6.C6445k(c11458d25, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int D0(J44 j44, J44 j442) {
        return AbstractC13042fc3.l(j44.h(), j442.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E0(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    private final C6517Nv5 F0(final C11458d25 c11458d25, C11458d25 c11458d252, List list) {
        ArrayList arrayList = new ArrayList();
        final ArrayList<J44> arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            J44 j44 = (J44) it.next();
            C8445Vz5 c8445Vz5U0 = u0(c11458d252, j44);
            if (R0(c8445Vz5U0)) {
                Y0(this, j44.F(), c11458d25, null, 4, null);
            } else {
                arrayList2.add(j44);
                arrayList.add(c8445Vz5U0);
            }
        }
        if (arrayList2.isEmpty()) {
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C19938rB7.a);
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        List arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        for (J44 j442 : arrayList2) {
            arrayList3.add(AbstractC4616Fw7.a(Long.valueOf(j442.i()), Long.valueOf(j442.h())));
        }
        int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList(size);
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            arrayList4.add(Long.valueOf(AbstractC19981rG5.a()));
        }
        int size2 = arrayList2.size();
        ArrayList arrayList5 = new ArrayList(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            arrayList5.add(Long.valueOf(t0()));
        }
        ArrayList arrayList6 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList6.add(((J44) it2.next()).F());
        }
        for (Object obj : arrayList2) {
            int i4 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            n0(((Number) arrayList4.get(i)).longValue(), ((Number) arrayList5.get(i)).longValue(), (AbstractC17457n0) arrayList6.get(i), (J44) obj, (C8445Vz5) arrayList.get(i), c11458d25);
            i = i4;
            arrayList6 = arrayList6;
        }
        W0();
        final MessagingOuterClass$RequestForwardMessages messagingOuterClass$RequestForwardMessagesO0 = o0(c11458d252, c11458d25, null, arrayList3, arrayList4);
        if (messagingOuterClass$RequestForwardMessagesO0 != null) {
            return new C6517Nv5(true, new InterfaceC6990Pv5() { // from class: ir.nasim.J1
                @Override // ir.nasim.InterfaceC6990Pv5
                public final void a(C7234Qv5 c7234Qv5) {
                    S1.G0(this.a, messagingOuterClass$RequestForwardMessagesO0, arrayList4, arrayList2, c11458d25, c7234Qv5);
                }
            });
        }
        C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("Failed to build forward request."));
        AbstractC13042fc3.h(c6517Nv5F, "failure(...)");
        return c6517Nv5F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(final S1 s1, MessagingOuterClass$RequestForwardMessages messagingOuterClass$RequestForwardMessages, final List list, final List list2, final C11458d25 c11458d25, C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(s1, "this$0");
        AbstractC13042fc3.i(messagingOuterClass$RequestForwardMessages, "$request");
        AbstractC13042fc3.i(list, "$newRids");
        AbstractC13042fc3.i(list2, "$messages");
        AbstractC13042fc3.i(c11458d25, "$toPeer");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        s1.M(new C22871vx5("/bale.messaging.v2.Messaging/ForwardMessages", messagingOuterClass$RequestForwardMessages, defaultInstance), 0L).m0(new InterfaceC24449ye1() { // from class: ir.nasim.O1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                S1.H0(list, s1, list2, c11458d25, (Misc$ResponseSeqDate) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.P1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                S1.I0(list, s1, c11458d25, (Exception) obj);
            }
        }).i0(c7234Qv5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(List list, S1 s1, List list2, C11458d25 c11458d25, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        C3460Az c3460Az;
        AbstractC13042fc3.i(list, "$newRids");
        AbstractC13042fc3.i(s1, "this$0");
        AbstractC13042fc3.i(list2, "$messages");
        AbstractC13042fc3.i(c11458d25, "$toPeer");
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            long jLongValue = ((Number) obj).longValue();
            if (i == 0) {
                Map<String, CollectionsStruct$RawValue> extMap = misc$ResponseSeqDate.getExtMap();
                c3460Az = extMap != null ? s1.v0(extMap) : null;
            } else {
                J44 j44 = (J44) list2.get(i - 1);
                c3460Az = new C3460Az(j44.h(), j44.i(), 0L);
            }
            s1.P0(c11458d25, jLongValue, misc$ResponseSeqDate.getDate() - ((list2.size() - 1) - i), c3460Az);
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(List list, S1 s1, C11458d25 c11458d25, Exception exc) {
        AbstractC13042fc3.i(list, "$newRids");
        AbstractC13042fc3.i(s1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$toPeer");
        C19406qI3.c("Sender", "forwardSingleMessages", exc);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s1.r().d(new C6434No6.C6445k(c11458d25, ((Number) it.next()).longValue()));
        }
    }

    private final int O0(C11458d25 c11458d25) {
        C14697iL2 c14697iL2;
        if (c11458d25.s() == W25.b && (c14697iL2 = (C14697iL2) this.m.E().X1().d(c11458d25.getPeerId())) != null && c14697iL2.q0() == ZN2.CHANNEL) {
            return c11458d25.getPeerId();
        }
        return 0;
    }

    private final void P0(C11458d25 c11458d25, long j, long j2, C3460Az c3460Az) {
        r().d(new C6434No6.l(c11458d25, j, j2));
        this.m.G().T0().E(new WE7(c11458d25, j, j2, c3460Az));
        S0(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(S1 s1, List list, List list2) {
        AbstractC13042fc3.i(s1, "this$0");
        AbstractC13042fc3.i(list, "$pendingMessages");
        AbstractC13042fc3.f(list2);
        Set setB1 = s1.b1(list2, 200);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!setB1.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList.add(obj);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList == null) {
            return;
        }
        s1.r().d(new C6434No6.C6443i(arrayList));
        C19406qI3.j("Sender", arrayList.size() + " deleted pending message(s) detected.", new Object[0]);
    }

    public static /* synthetic */ C6517Nv5 Y0(S1 s1, AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, C7880To7 c7880To7, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
        }
        if ((i & 4) != 0) {
            c7880To7 = null;
        }
        return s1.X0(abstractC17457n0, c11458d25, c7880To7);
    }

    private final Set b1(List list, int i) {
        int iMin = Math.min(i, list.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(iMin);
        int size = list.size();
        for (int size2 = list.size() - iMin; size2 < size; size2++) {
            linkedHashSet.add(Long.valueOf(((J44) list.get(size2)).i()));
        }
        return linkedHashSet;
    }

    private final void n0(long j, long j2, AbstractC17457n0 abstractC17457n0, J44 j44, C8445Vz5 c8445Vz5, C11458d25 c11458d25) {
        J44 j442 = new J44(j, j2, j2, this.m.i0(), EnumC23558x74.PENDING, abstractC17457n0, AbstractC10360bX0.m(), j44.G(), c8445Vz5, null, 0L, null, null, false, null, null, false, null, null, 523776, null);
        N0().r().add(new C19857r35(c11458d25, j, AbstractC17457n0.h(new C7246Qx()), new C3933Cz(c8445Vz5.u() != null ? this.m.n(c8445Vz5.u()) : null, c8445Vz5.s(), Long.valueOf(c8445Vz5.h()), null, null), null, j442));
        this.m.G().T0().A(c11458d25, j442);
    }

    private final MessagingOuterClass$RequestForwardMessages o0(C11458d25 c11458d25, C11458d25 c11458d252, Long l, List list, List list2) {
        PeersStruct$OutExPeer peersStruct$OutExPeerP0;
        PeersStruct$OutPeer peersStruct$OutPeerQ0 = q0(c11458d25);
        if (peersStruct$OutPeerQ0 == null || (peersStruct$OutExPeerP0 = p0(c11458d252)) == null) {
            return null;
        }
        MessagingOuterClass$RequestForwardMessages.a aVarD = MessagingOuterClass$RequestForwardMessages.newBuilder().D(peersStruct$OutExPeerP0);
        if (l != null) {
            aVarD.C((CollectionsStruct$Int64Value) CollectionsStruct$Int64Value.newBuilder().A(l.longValue()).a());
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            XV4 xv4 = (XV4) obj;
            long jLongValue = ((Number) xv4.a()).longValue();
            long jLongValue2 = ((Number) xv4.b()).longValue();
            aVarD.B(((Number) list2.get(i)).longValue());
            aVarD.A((MessagingStruct$MessageOutReference) MessagingStruct$MessageOutReference.newBuilder().C(jLongValue).A((CollectionsStruct$Int64Value) CollectionsStruct$Int64Value.newBuilder().A(jLongValue2).a()).B(peersStruct$OutPeerQ0).a());
            i = i2;
        }
        return (MessagingOuterClass$RequestForwardMessages) aVarD.a();
    }

    private final PeersStruct$OutExPeer p0(C11458d25 c11458d25) {
        PeersStruct$OutExPeer.a aVarNewBuilder = PeersStruct$OutExPeer.newBuilder();
        if (c11458d25.s() == W25.a) {
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(c11458d25.getPeerId());
            if (c17637nI7 == null) {
                return null;
            }
            return (PeersStruct$OutExPeer) aVarNewBuilder.B(c17637nI7.n0()).C(c17637nI7.p0() ? EnumC10088b35.ExPeerType_BOT : EnumC10088b35.ExPeerType_PRIVATE).A(c17637nI7.getAccessHash()).a();
        }
        if (c11458d25.s() == W25.b) {
            C14697iL2 c14697iL2 = (C14697iL2) this.m.E().X1().d(c11458d25.getPeerId());
            if (c14697iL2 == null) {
                return null;
            }
            return (PeersStruct$OutExPeer) aVarNewBuilder.B(c14697iL2.p0()).C(c14697iL2.q0() == ZN2.CHANNEL ? EnumC10088b35.ExPeerType_CHANNEL : EnumC10088b35.ExPeerType_GROUP).A(c14697iL2.getAccessHash()).a();
        }
        throw new RuntimeException("Unknown peer: " + c11458d25);
    }

    private final J44 s0(long j, List list) {
        List listA1 = AbstractC15401jX0.a1(list, new e());
        J44 j44 = (J44) AbstractC15401jX0.C0(listA1);
        return new J44(j, j44.W(), j44.h(), j44.U(), j44.L(), new C11907dl(listA1), null, 0, j44.Q(), null, 0L, null, null, false, null, null, false, null, null, 523968, null);
    }

    private final C8445Vz5 u0(C11458d25 c11458d25, J44 j44) {
        C11458d25 c11458d252;
        long j;
        long j2;
        C14697iL2 c14697iL2;
        C8445Vz5 c8445Vz5Q = j44.Q();
        if (c8445Vz5Q == null || !c8445Vz5Q.E()) {
            return new C8445Vz5(j44.i(), O0(c11458d25), j44.U(), j44.h(), j44.F(), c11458d25, true, null);
        }
        long jI = j44.i();
        long jH = j44.h();
        C11458d25 c11458d25U = c8445Vz5Q.u();
        if (c11458d25U != null) {
            if (c11458d25U.s().equals(W25.b) && (c14697iL2 = (C14697iL2) this.m.E().X1().d(c11458d25U.getPeerId())) != null && c14697iL2.q0().equals(ZN2.CHANNEL)) {
                jI = c8445Vz5Q.s();
                jH = c8445Vz5Q.h();
            } else {
                c11458d25U = c11458d25;
            }
            j = jI;
            j2 = jH;
            c11458d252 = c11458d25U;
        } else {
            c11458d252 = c11458d25;
            j = jI;
            j2 = jH;
        }
        return new C8445Vz5(j, O0(c11458d252), c8445Vz5Q.z(), j2, c8445Vz5Q.r(), c11458d252, true, null);
    }

    private final C3460Az v0(Map map) {
        CollectionsStruct$RawValue collectionsStruct$RawValue = (CollectionsStruct$RawValue) map.get("previous_message_rid");
        C3460Az c3460Az = null;
        if (collectionsStruct$RawValue != null) {
            long int64Value = collectionsStruct$RawValue.getInt64Value();
            CollectionsStruct$RawValue collectionsStruct$RawValue2 = (CollectionsStruct$RawValue) map.get("previous_message_date");
            if (collectionsStruct$RawValue2 != null) {
                c3460Az = new C3460Az(collectionsStruct$RawValue2.getInt64Value(), int64Value, 0L);
            }
        }
        if (c3460Az == null) {
            C19406qI3.b("Sender", "extractPreviousMessageId() returned null");
        }
        return c3460Az;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC12532em2 w0() {
        C92 c92 = C92.a;
        return ((InterfaceC19086pl2) C92.a(C5721Ko.a.d(), InterfaceC19086pl2.class)).Q();
    }

    private final C6517Nv5 y0(final C11458d25 c11458d25, C11458d25 c11458d252, J44 j44) {
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        C11907dl c11907dl = (C11907dl) abstractC17457n0F;
        List<J44> listR = c11907dl.r();
        List arrayList = new ArrayList(AbstractC10976cX0.x(listR, 10));
        for (J44 j442 : listR) {
            arrayList.add(AbstractC4616Fw7.a(Long.valueOf(j442.i()), Long.valueOf(j442.h())));
        }
        final long jA = AbstractC19981rG5.a();
        List<J44> listR2 = c11907dl.r();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listR2, 10));
        for (J44 j443 : listR2) {
            C8445Vz5 c8445Vz5U0 = u0(c11458d252, j443);
            arrayList2.add(J44.D(j443, AbstractC19981rG5.a(), 0L, 0L, this.m.i0(), null, null, AbstractC10360bX0.m(), 0, c8445Vz5U0, null, 0L, null, null, false, Long.valueOf(jA), false, null, null, 245430, null));
        }
        C11907dl c11907dl2 = new C11907dl(arrayList2);
        List listR3 = c11907dl2.r();
        List arrayList3 = new ArrayList(AbstractC10976cX0.x(listR3, 10));
        Iterator it = listR3.iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf(((J44) it.next()).i()));
        }
        long jT0 = t0();
        C8445Vz5 c8445Vz5U02 = u0(c11458d252, j44);
        if (R0(c8445Vz5U02)) {
            return V0(c11458d25, c11907dl2, null, a1(c11907dl2, c11458d25, null, null, null, null));
        }
        n0(jA, jT0, c11907dl2, j44, c8445Vz5U02, c11458d25);
        W0();
        final MessagingOuterClass$RequestForwardMessages messagingOuterClass$RequestForwardMessagesO0 = o0(c11458d252, c11458d25, Long.valueOf(jA), arrayList, arrayList3);
        if (messagingOuterClass$RequestForwardMessagesO0 != null) {
            return new C6517Nv5(true, new InterfaceC6990Pv5() { // from class: ir.nasim.L1
                @Override // ir.nasim.InterfaceC6990Pv5
                public final void a(C7234Qv5 c7234Qv5) {
                    S1.z0(this.a, messagingOuterClass$RequestForwardMessagesO0, c11458d25, jA, c7234Qv5);
                }
            });
        }
        C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("Failed to build album forward request."));
        AbstractC13042fc3.h(c6517Nv5F, "failure(...)");
        return c6517Nv5F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(final S1 s1, MessagingOuterClass$RequestForwardMessages messagingOuterClass$RequestForwardMessages, final C11458d25 c11458d25, final long j, C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(s1, "this$0");
        AbstractC13042fc3.i(messagingOuterClass$RequestForwardMessages, "$request");
        AbstractC13042fc3.i(c11458d25, "$toPeer");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        s1.L(new C22871vx5("/bale.messaging.v2.Messaging/ForwardMessages", messagingOuterClass$RequestForwardMessages, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.M1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                S1.A0(this.a, c11458d25, j, (Misc$ResponseSeqDate) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.N1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                S1.B0(this.a, c11458d25, j, (Exception) obj);
            }
        }).i0(c7234Qv5);
    }

    protected final void C0(C11458d25 c11458d25, C11458d25 c11458d252, List list) {
        AbstractC13042fc3.i(c11458d25, "toPeer");
        AbstractC13042fc3.i(c11458d252, "fromPeer");
        AbstractC13042fc3.i(list, "messages");
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.Q1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(S1.D0((J44) obj, (J44) obj2));
            }
        };
        TreeSet treeSet = new TreeSet(new Comparator() { // from class: ir.nasim.R1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return S1.E0(interfaceC14603iB2, obj, obj2);
            }
        });
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            J44 j44 = (J44) it.next();
            if (j44.a0()) {
                Long lJ = j44.J();
                AbstractC13042fc3.f(lJ);
                Object arrayList = map.get(lJ);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(lJ, arrayList);
                }
                ((List) arrayList).add(j44);
            } else {
                treeSet.add(j44);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            treeSet.add(s0(((Number) entry.getKey()).longValue(), (List) entry.getValue()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = treeSet.iterator();
        AbstractC13042fc3.h(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            AbstractC13042fc3.h(next, "next(...)");
            J44 j442 = (J44) next;
            if (j442.F() instanceof C11907dl) {
                if (!arrayList2.isEmpty()) {
                    arrayList3.add(G(new c(c11458d252, c11458d25, arrayList2)));
                    arrayList2 = new ArrayList();
                }
                arrayList3.add(G(new b(c11458d252, c11458d25, j442)));
            } else {
                arrayList2.add(j442);
            }
        }
        arrayList3.add(G(new c(c11458d252, c11458d25, arrayList2)));
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C19938rB7.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            c6517Nv5L0 = new C6517Nv5((InterfaceC6990Pv5) new f(c6517Nv5L0, (C6517Nv5) it3.next()));
        }
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return y0(bVar.c(), bVar.b(), bVar.a());
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return F0(cVar.c(), cVar.a(), cVar.b());
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.h(c6517Nv5G, "onAsk(...)");
        return c6517Nv5G;
    }

    protected final HashMap J0() {
        HashMap map = this.p;
        if (map != null) {
            return map;
        }
        AbstractC13042fc3.y("albumPendingUpload");
        return null;
    }

    protected final List K0(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        ArrayList arrayListR = N0().r();
        AbstractC13042fc3.h(arrayListR, "getPendingMessages(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListR) {
            if (AbstractC13042fc3.d(((C19857r35) obj).C(), c11458d25)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((C19857r35) it.next()).i()));
        }
        return arrayList2;
    }

    protected final AbstractC17457n0 L0(long j) {
        Object next;
        Long l = (Long) J0().get(Long.valueOf(j));
        C19857r35 c19857r35X0 = x0(l != null ? l.longValue() : j);
        if (c19857r35X0 == null) {
            return null;
        }
        AbstractC17457n0 abstractC17457n0Y = c19857r35X0.y();
        if (!(abstractC17457n0Y instanceof C11907dl)) {
            return abstractC17457n0Y;
        }
        Iterator it = ((C11907dl) abstractC17457n0Y).r().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((J44) next).i() == j) {
                break;
            }
        }
        J44 j44 = (J44) next;
        if (j44 != null) {
            return j44.F();
        }
        return null;
    }

    protected final InterfaceC12532em2 M0() {
        return (InterfaceC12532em2) this.q.getValue();
    }

    protected final C20466s35 N0() {
        C20466s35 c20466s35 = this.o;
        if (c20466s35 != null) {
            return c20466s35;
        }
        AbstractC13042fc3.y("pendingMessages");
        return null;
    }

    protected final boolean Q0(int i, C11458d25 c11458d25, int i2) {
        return c11458d25 != null && c11458d25.s() == W25.a && c11458d25.getPeerId() == this.m.i0() && i2 == this.m.i0() && i == 0;
    }

    protected final boolean R0(C8445Vz5 c8445Vz5) {
        AbstractC13042fc3.i(c8445Vz5, "<this>");
        return Q0(c8445Vz5.w(), c8445Vz5.u(), c8445Vz5.z());
    }

    protected final void S0(long j) {
        long j2 = W().getLong("last_sent_message_event_date", 0L);
        if (j2 == 0 || j - j2 > t) {
            W().putLong("last_sent_message_event_date", j);
        }
    }

    protected final void T0() {
        HashMap map = new HashMap();
        Iterator it = N0().r().iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            C19857r35 c19857r35 = (C19857r35) it.next();
            C11458d25 c11458d25C = c19857r35.C();
            Object arrayList = map.get(c11458d25C);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(c11458d25C, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(c19857r35.i()));
        }
        for (Map.Entry entry : map.entrySet()) {
            C11458d25 c11458d25 = (C11458d25) entry.getKey();
            final List list = (List) entry.getValue();
            this.m.G().H0(c11458d25).h().m0(new InterfaceC24449ye1() { // from class: ir.nasim.K1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    S1.U0(this.a, list, (List) obj);
                }
            });
        }
    }

    public abstract C6517Nv5 V0(C11458d25 c11458d25, AbstractC17457n0 abstractC17457n0, C3933Cz c3933Cz, long j);

    protected abstract void W0();

    public abstract C6517Nv5 X0(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, C7880To7 c7880To7);

    protected abstract long Z0(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l, Long l2, C16526lQ6 c16526lQ6, long j, C7880To7 c7880To7);

    protected final long a1(AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, Long l, Long l2, C16526lQ6 c16526lQ6, C7880To7 c7880To7) {
        AbstractC13042fc3.i(abstractC17457n0, "content");
        AbstractC13042fc3.i(c11458d25, "peer");
        return Z0(abstractC17457n0, c11458d25, l, l2, c16526lQ6, AbstractC19981rG5.a(), c7880To7);
    }

    public final PeersStruct$OutPeer q0(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        PeersStruct$OutPeer.a aVarNewBuilder = PeersStruct$OutPeer.newBuilder();
        if (c11458d25.s() == W25.a) {
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(c11458d25.getPeerId());
            if (c17637nI7 == null) {
                return null;
            }
            return (PeersStruct$OutPeer) aVarNewBuilder.B(c17637nI7.n0()).C(EnumC16311l35.PeerType_PRIVATE).A(c17637nI7.getAccessHash()).a();
        }
        if (c11458d25.s() == W25.b) {
            C14697iL2 c14697iL2 = (C14697iL2) this.m.E().X1().d(c11458d25.getPeerId());
            if (c14697iL2 == null) {
                return null;
            }
            return (PeersStruct$OutPeer) aVarNewBuilder.B(c14697iL2.p0()).C(EnumC16311l35.PeerType_GROUP).A(c14697iL2.getAccessHash()).a();
        }
        throw new RuntimeException("Unknown peer: " + c11458d25);
    }

    protected final void r0(long j) {
        AbstractC10533bm0.d(C17050mJ2.a, null, null, new d(j, null), 3, null);
    }

    protected final long t0() {
        long jO = AbstractC20507s76.o();
        long j = this.n;
        if (j >= jO) {
            jO = 1 + j;
        }
        this.n = jO;
        return jO;
    }

    protected final C19857r35 x0(long j) {
        Object next;
        ArrayList arrayListR = N0().r();
        AbstractC13042fc3.h(arrayListR, "getPendingMessages(...)");
        Iterator it = arrayListR.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C19857r35) next).i() == j) {
                break;
            }
        }
        return (C19857r35) next;
    }
}
