package ir.nasim;

import ai.bale.proto.MessagingOuterClass$RequestLoadDialogs;
import ai.bale.proto.MessagingOuterClass$RequestLoadPeerDialogs;
import ai.bale.proto.MessagingOuterClass$ResponseLoadDialogs;
import ai.bale.proto.MessagingOuterClass$ResponseLoadPeerDialogs;
import ai.bale.proto.MessagingStruct$Dialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class YS1 extends AbstractC6360Ng4 {
    private final String m;
    private final Map n;
    private final Map o;
    private final Map p;
    private final C22674ve2 q;
    private C9057Yh4 r;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[W25.values().length];
            a = iArr;
            try {
                iArr[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b extends Z6 {
        public b(C9528a7 c9528a7) {
            super(c9528a7);
        }

        public C6517Nv5 j(List list, boolean z) {
            return c(new e(list, z));
        }

        public C6517Nv5 k() {
            return c(new g());
        }
    }

    public static class c {
        private final OP1 a;

        public c(OP1 op1) {
            this.a = op1;
        }

        public OP1 a() {
            return this.a;
        }
    }

    public static class d implements InterfaceC15283jK {
        private final OP1 a;
        private final int b;

        public d(OP1 op1, int i) {
            this.a = op1;
            this.b = i;
        }

        public OP1 a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    public static class e implements InterfaceC15283jK {
        private final List a;
        private final boolean b;

        public e(List list, boolean z) {
            this.a = list;
            this.b = z;
        }

        public List a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }
    }

    public static class f {
        private final List a;

        public f(List list) {
            this.a = list;
        }

        public List a() {
            return this.a;
        }
    }

    public static class g implements InterfaceC15283jK {
    }

    public YS1(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.m = "DialogsHistoryActor";
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = new HashMap();
        this.q = new C22674ve2(5000, 50000, 50);
        this.r = c9057Yh4;
    }

    private void A0(OP1 op1) {
        if (W().h("dialogs_history_inited_1" + op1, false)) {
            return;
        }
        if (op1 == OP1.ALL) {
            r().d(new d(op1, 100));
        } else {
            r().d(new d(op1, 20));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 B0(ArrayList arrayList, OP1 op1, boolean z, C14505i18 c14505i18) {
        return this.r.G().K0().A(arrayList, S0(arrayList), op1, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(ArrayList arrayList, int i, OP1 op1, long j, C14505i18 c14505i18) {
        if (arrayList.size() < i) {
            C19406qI3.a("DialogsHistoryActor", "[handleDialogsLoaded] End of dialog reached. no more dialog remained in " + op1, new Object[0]);
            U0(op1);
            return;
        }
        C19406qI3.a("DialogsHistoryActor", "[handleDialogsLoaded] Some more dialog is remained. Mark is slice load in " + op1, new Object[0]);
        V0(j, op1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(OP1 op1, C14505i18 c14505i18, Exception exc) {
        C19406qI3.a("DialogsHistoryActor", "[handleDialogsLoaded] Requesting more dialog to load in " + op1, new Object[0]);
        this.p.put(op1, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 E0(MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(Exception exc) {
        C19406qI3.b("DialogsHistoryActor", "Error in loadDialogs: " + exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 G0(MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs) {
        return this.r.V().X(C18732p92.J(messagingOuterClass$ResponseLoadPeerDialogs.getUserPeersList()), C18732p92.A(messagingOuterClass$ResponseLoadPeerDialogs.getGroupPeersList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 H0(MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs, C14505i18 c14505i18) {
        ((HS1) I22.a(C5721Ko.b, HS1.class)).q().L(messagingOuterClass$ResponseLoadPeerDialogs.getDialogsList());
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 I0(List list, Map map, C14505i18 c14505i18) {
        return this.r.G().K0().A(list, map, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 J0(List list, Map map, C14505i18 c14505i18) {
        List listV0 = v0(list, map);
        if (!listV0.isEmpty()) {
            this.r.Q().O(listV0);
        }
        return this.r.G().T0().s(C18267oN1.l.a(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 K0(final MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs) {
        final ArrayList arrayListU0 = u0(messagingOuterClass$ResponseLoadPeerDialogs);
        final Map mapS0 = S0(arrayListU0);
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        if (C8386Vt0.u8()) {
            c6517Nv5L0.H(new InterfaceC17569nB2() { // from class: ir.nasim.MS1
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return YS1.H0(messagingOuterClass$ResponseLoadPeerDialogs, (C14505i18) obj);
                }
            });
        } else {
            c6517Nv5L0.H(new InterfaceC17569nB2() { // from class: ir.nasim.NS1
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.I0(arrayListU0, mapS0, (C14505i18) obj);
                }
            });
        }
        return c6517Nv5L0.H(new InterfaceC17569nB2() { // from class: ir.nasim.OS1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.J0(arrayListU0, mapS0, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 L0(OP1 op1, C14505i18 c14505i18) {
        return R0(Long.MAX_VALUE, op1, 20, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 M0(MessagingOuterClass$ResponseLoadDialogs messagingOuterClass$ResponseLoadDialogs) {
        return this.r.V().R(C18732p92.K(messagingOuterClass$ResponseLoadDialogs.getUsersList()), C18732p92.B(messagingOuterClass$ResponseLoadDialogs.getGroupsList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 N0(MessagingOuterClass$ResponseLoadDialogs messagingOuterClass$ResponseLoadDialogs) {
        return this.r.V().t0(C18732p92.J(messagingOuterClass$ResponseLoadDialogs.getUserPeersList()), C18732p92.A(messagingOuterClass$ResponseLoadDialogs.getGroupPeersList()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(OP1 op1, int i, boolean z, MessagingOuterClass$ResponseLoadDialogs messagingOuterClass$ResponseLoadDialogs) {
        C19406qI3.a("DialogsHistoryActor", "[loadDialogs] Response, size: " + messagingOuterClass$ResponseLoadDialogs.getDialogsList().size(), new Object[0]);
        w0(messagingOuterClass$ResponseLoadDialogs.getDialogsList(), op1, i, z);
        this.q.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(OP1 op1, Exception exc) {
        C19406qI3.a("DialogsHistoryActor", "Error in loadDialogs: " + exc.getMessage(), new Object[0]);
        this.p.put(op1, Boolean.FALSE);
        this.q.b();
        q(new d(op1, 20), this.q.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C14505i18 Q0(MessagingOuterClass$ResponseLoadDialogs messagingOuterClass$ResponseLoadDialogs) {
        return C14505i18.a;
    }

    private C6517Nv5 R0(long j, final OP1 op1, final int i, final boolean z) {
        if (((Boolean) this.p.get(op1)).booleanValue()) {
            C19406qI3.a("DialogsHistoryActor", "[loadDialogs] return because it's already loading for dialogType: " + op1, new Object[0]);
            return C6517Nv5.l0(C14505i18.a);
        }
        C19406qI3.a("DialogsHistoryActor", "[loadDialogs] Request to load more dialogs of " + op1, new Object[0]);
        this.p.put(op1, Boolean.TRUE);
        MessagingOuterClass$RequestLoadDialogs.b bVarA = MessagingOuterClass$RequestLoadDialogs.newBuilder().E(j).D(i).C(false).A(PC.b);
        if (op1 != OP1.ALL) {
            bVarA.B(op1.p());
        }
        return L(new C22871vx5("/bale.messaging.v2.Messaging/LoadDialogs", bVarA.a(), MessagingOuterClass$ResponseLoadDialogs.getDefaultInstance())).A(new InterfaceC17569nB2() { // from class: ir.nasim.SS1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.M0((MessagingOuterClass$ResponseLoadDialogs) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.TS1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.N0((MessagingOuterClass$ResponseLoadDialogs) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.US1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.O0(op1, i, z, (MessagingOuterClass$ResponseLoadDialogs) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.VS1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.P0(op1, (Exception) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.WS1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return YS1.Q0((MessagingOuterClass$ResponseLoadDialogs) obj);
            }
        });
    }

    private Map S0(List list) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int i = a.a[((C17676nN1) it.next()).e().s().ordinal()];
            if (i == 1) {
                arrayList.add(Long.valueOf(r3.getPeerId()));
            } else if (i == 2) {
                arrayList2.add(Long.valueOf(r3.getPeerId()));
            }
        }
        List<C17637nI7> arrayList3 = new ArrayList();
        List<C14697iL2> arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList3 = this.r.W().p0().f(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            arrayList4 = this.r.E().X1().f(arrayList2);
        }
        for (C17637nI7 c17637nI7 : arrayList3) {
            map.put(Long.valueOf(c17637nI7.u0().u()), new D25(c17637nI7.r0() ? C15903kN1.d(C5721Ko.b) : c17637nI7.getName(), c17637nI7.S(), c17637nI7.r0(), c17637nI7.i0()));
        }
        for (C14697iL2 c14697iL2 : arrayList4) {
            map.put(Long.valueOf(c14697iL2.I0().u()), new D25(c14697iL2.G0(), c14697iL2.h0(), false, null));
        }
        return map;
    }

    private void T0(List list) throws Throwable {
        try {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C11458d25 c11458d25R = C11458d25.r(((Long) it.next()).longValue());
                hashSet.add(new C17557nA(c11458d25R.s().p(), c11458d25R.getPeerId(), 0L));
            }
            x0(new ArrayList(hashSet), true);
        } catch (Exception e2) {
            C19406qI3.c("DialogsHistoryActor", "loadPinnedDialogs", e2);
        }
    }

    private void U0(OP1 op1) {
        this.p.put(op1, Boolean.FALSE);
        this.o.put(op1, Boolean.TRUE);
        W().g("dialogs_history_loaded_1" + op1, true);
        W().g("dialogs_history_inited_1" + op1, true);
    }

    private void V0(long j, OP1 op1) {
        Map map = this.p;
        Boolean bool = Boolean.FALSE;
        map.put(op1, bool);
        this.o.put(op1, bool);
        this.n.put(op1, Long.valueOf(j));
        W().g("dialogs_history_loaded_1" + op1, false);
        W().g("dialogs_history_inited_1" + op1, true);
        W().putLong("dialogs_history_date_1" + op1, j);
    }

    private void W0(OP1 op1, int i) {
        if (!((Boolean) this.o.get(op1)).booleanValue()) {
            R0(((Long) this.n.get(op1)).longValue(), op1, i, false);
            return;
        }
        C19406qI3.a("DialogsHistoryActor", "[onLoadMore] return because it's already loaded for dialogType: " + op1, new Object[0]);
    }

    private void t0(List list) throws Throwable {
        int i = 0;
        C19406qI3.a("DialogsHistoryActor", "clearPeersInBatch size: " + list.size(), new Object[0]);
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < list.size(); i2++) {
            C11458d25 c11458d25N = C18732p92.n((C17557nA) list.get(i2));
            if (c11458d25N != null) {
                jArr[i2] = c11458d25N.u();
            }
        }
        while (i < size) {
            int iMin = Math.min(i + 50, size);
            C10431bb8.a.d(Arrays.copyOfRange(jArr, i, iMin));
            i = iMin;
        }
    }

    private static ArrayList u0(MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs) {
        ArrayList arrayList = new ArrayList();
        Iterator<MessagingStruct$Dialog> it = messagingOuterClass$ResponseLoadPeerDialogs.getDialogsList().iterator();
        while (it.hasNext()) {
            arrayList.add(C18732p92.g(it.next()));
        }
        return arrayList;
    }

    private static List v0(List list, Map map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C17676nN1 c17676nN1 = (C17676nN1) it.next();
            long jU = c17676nN1.e().u();
            D25 d25 = (D25) map.get(Long.valueOf(jU));
            arrayList.add(new C25254zz6(C11458d25.r(jU), d25 != null ? d25.c() : "", c17676nN1.j(), c17676nN1.b(), c17676nN1.c(), Long.valueOf(c17676nN1.d()), null));
        }
        return arrayList;
    }

    private C6517Nv5 w0(List list, final OP1 op1, final int i, final boolean z) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        final long jMin = Long.MAX_VALUE;
        while (it.hasNext()) {
            MessagingStruct$Dialog messagingStruct$Dialog = (MessagingStruct$Dialog) it.next();
            arrayList.add(C18732p92.g(messagingStruct$Dialog));
            jMin = Math.min(messagingStruct$Dialog.getSortDate(), jMin);
        }
        if (!arrayList.isEmpty()) {
            return this.r.G().T0().s(C18267oN1.l.a(arrayList)).A(new InterfaceC17569nB2() { // from class: ir.nasim.JS1
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.B0(arrayList, op1, z, (C14505i18) obj);
                }
            }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.KS1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.C0(arrayList, i, op1, jMin, (C14505i18) obj);
                }
            }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.LS1
                @Override // ir.nasim.InterfaceC3273Ae1
                public final void apply(Object obj, Object obj2) {
                    this.a.D0(op1, (C14505i18) obj, (Exception) obj2);
                }
            });
        }
        if (jMin == Long.MAX_VALUE) {
            if (!W().h("dialogs_history_inited_1" + op1, false)) {
                this.r.v().D().o(op1, true);
            }
        }
        U0(op1);
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 x0(List list, boolean z) throws Throwable {
        if (z) {
            t0(list);
        }
        return M(new C22871vx5("/bale.messaging.v2.Messaging/LoadPeerDialogs", MessagingOuterClass$RequestLoadPeerDialogs.newBuilder().A(C18732p92.x(list)).a(), MessagingOuterClass$ResponseLoadPeerDialogs.getDefaultInstance()), 20000L).A(new InterfaceC17569nB2() { // from class: ir.nasim.IS1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.G0((MessagingOuterClass$ResponseLoadPeerDialogs) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.PS1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.K0((MessagingOuterClass$ResponseLoadPeerDialogs) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.QS1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return YS1.E0((MessagingOuterClass$ResponseLoadPeerDialogs) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.RS1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.F0((Exception) obj);
            }
        });
    }

    private C6517Nv5 y0() {
        OP1[] op1Arr = {OP1.PRIVATE, OP1.BOT, OP1.CHANNEL, OP1.GROUP};
        this.p.put(OP1.ALL, Boolean.FALSE);
        for (int i = 0; i < 4; i++) {
            this.p.put(op1Arr[i], Boolean.FALSE);
        }
        C6517Nv5 c6517Nv5R0 = R0(Long.MAX_VALUE, OP1.ALL, 40, true);
        for (int i2 = 0; i2 < 4; i2++) {
            final OP1 op1 = op1Arr[i2];
            c6517Nv5R0 = c6517Nv5R0.H(new InterfaceC17569nB2() { // from class: ir.nasim.XS1
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.L0(op1, (C14505i18) obj);
                }
            });
        }
        return c6517Nv5R0;
    }

    private void z0() {
        long j = W().getLong("dialogs_history_date_1", Long.MAX_VALUE);
        boolean zH = W().h("dialogs_history_loaded_1", false);
        InterfaceC3570Bk5 interfaceC3570Bk5W = W();
        StringBuilder sb = new StringBuilder();
        sb.append("dialogs_history_date_1");
        OP1 op1 = OP1.ALL;
        sb.append(op1);
        long j2 = interfaceC3570Bk5W.getLong(sb.toString(), Long.MAX_VALUE);
        boolean zH2 = W().h("dialogs_history_loaded_1" + op1, false);
        boolean zH3 = W().h("dialogs_history_inited_1", false);
        if (j != Long.MAX_VALUE || zH) {
            W().remove("dialogs_history_date_1");
            W().remove("dialogs_history_loaded_1");
        } else {
            j = j2;
            zH = zH2;
        }
        if (zH3) {
            W().g("dialogs_history_inited_1" + op1, true);
            this.r.v().D().n(op1, EnumC12820fE.LOADED);
            W().remove("dialogs_history_inited_1");
        }
        InterfaceC3570Bk5 interfaceC3570Bk5W2 = W();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dialogs_history_date_1");
        OP1 op12 = OP1.PRIVATE;
        sb2.append(op12);
        long j3 = interfaceC3570Bk5W2.getLong(sb2.toString(), Long.MAX_VALUE);
        InterfaceC3570Bk5 interfaceC3570Bk5W3 = W();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("dialogs_history_date_1");
        OP1 op13 = OP1.GROUP;
        sb3.append(op13);
        long j4 = interfaceC3570Bk5W3.getLong(sb3.toString(), Long.MAX_VALUE);
        InterfaceC3570Bk5 interfaceC3570Bk5W4 = W();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("dialogs_history_date_1");
        OP1 op14 = OP1.CHANNEL;
        sb4.append(op14);
        long j5 = interfaceC3570Bk5W4.getLong(sb4.toString(), Long.MAX_VALUE);
        InterfaceC3570Bk5 interfaceC3570Bk5W5 = W();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("dialogs_history_date_1");
        OP1 op15 = OP1.BOT;
        sb5.append(op15);
        long j6 = interfaceC3570Bk5W5.getLong(sb5.toString(), Long.MAX_VALUE);
        this.n.put(op1, Long.valueOf(j));
        this.n.put(op12, Long.valueOf(j3));
        this.n.put(op13, Long.valueOf(j4));
        this.n.put(op14, Long.valueOf(j5));
        this.n.put(op15, Long.valueOf(j6));
        boolean zH4 = W().h("dialogs_history_loaded_1" + op12, false);
        boolean zH5 = W().h("dialogs_history_loaded_1" + op13, false);
        boolean zH6 = W().h("dialogs_history_loaded_1" + op14, false);
        boolean zH7 = W().h("dialogs_history_loaded_1" + op15, false);
        this.o.put(op1, Boolean.valueOf(zH));
        this.o.put(op12, Boolean.valueOf(zH4));
        this.o.put(op13, Boolean.valueOf(zH5));
        this.o.put(op14, Boolean.valueOf(zH6));
        this.o.put(op15, Boolean.valueOf(zH7));
        Map map = this.p;
        Boolean bool = Boolean.FALSE;
        map.put(op1, bool);
        this.p.put(op12, bool);
        this.p.put(op13, bool);
        this.p.put(op14, bool);
        this.p.put(op15, bool);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (!(obj instanceof e)) {
            return obj instanceof g ? y0() : super.G(obj);
        }
        e eVar = (e) obj;
        return x0(eVar.a(), eVar.b());
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof d) {
            d dVar = (d) obj;
            W0(dVar.a(), dVar.b());
        } else if (obj instanceof c) {
            A0(((c) obj).a());
        } else if (obj instanceof f) {
            T0(((f) obj).a());
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        z0();
    }
}
