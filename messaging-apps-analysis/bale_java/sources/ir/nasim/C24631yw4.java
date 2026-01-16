package ir.nasim;

import ai.bale.proto.Ghasedak$GroupUpdates;
import ai.bale.proto.Ghasedak$RequestGetDiff;
import ai.bale.proto.Ghasedak$RequestGetRoutesStates;
import ai.bale.proto.Ghasedak$ResponseGetDiff;
import ai.bale.proto.Ghasedak$ResponseGetRoutesStates;
import ai.bale.proto.Ghasedak$RouteSeqState;
import ai.bale.proto.MavizStreamOuterClass$Event;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import ir.nasim.AbstractC14258hd0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* renamed from: ir.nasim.yw4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C24631yw4 extends AbstractC6360Ng4 {
    private InterfaceC22912w18 A;
    private C6937Pp6 B;
    private final ArrayList C;
    private final Map D;
    private final Map E;
    private final OK F;
    private final C16175kp6 G;
    InterfaceC23028wD7 H;
    private final C22674ve2 I;
    private C9057Yh4 m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile boolean p;
    private volatile boolean q;
    private volatile boolean r;
    private long s;
    private long t;
    private int u;
    private boolean v;
    private FE0 w;
    private FE0 x;
    private C24235yG7 y;
    private C6204Mp6 z;

    public C24631yw4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = 0L;
        this.t = 0L;
        this.u = 0;
        this.v = false;
        this.C = new ArrayList();
        this.D = new HashMap();
        this.E = new HashMap();
        this.I = new C22674ve2(2000, 180000, 50);
        this.m = c9057Yh4;
        this.F = c9057Yh4.T().C();
        InterfaceC23028wD7 interfaceC23028wD7 = (InterfaceC23028wD7) C92.a(C5721Ko.b, InterfaceC23028wD7.class);
        this.H = interfaceC23028wD7;
        this.G = interfaceC23028wD7.x();
    }

    private void A0(List list) {
        n1();
        L(new C22871vx5("/bale.ghasedak.v1.GhasedakService/GetDiff", (Ghasedak$RequestGetDiff) Ghasedak$RequestGetDiff.newBuilder().B(C14994ip6.f(list)).A(PC.h).a(), Ghasedak$ResponseGetDiff.getDefaultInstance())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ew4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.I0((Ghasedak$ResponseGetDiff) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.pw4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.H0((Exception) obj);
            }
        });
    }

    private void A1() {
        this.q = false;
        FE0 fe0 = this.x;
        if (fe0 != null) {
            fe0.cancel();
            this.x = null;
        }
    }

    private void B0() {
        x1();
        L(new C22871vx5("/bale.ghasedak.v1.GhasedakService/GetRoutesStates", (Ghasedak$RequestGetRoutesStates) Ghasedak$RequestGetRoutesStates.newBuilder().B(PC.d).A(this.B.s()).a(), Ghasedak$ResponseGetRoutesStates.getDefaultInstance())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.rw4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.R0((Ghasedak$ResponseGetRoutesStates) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.sw4
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                this.a.S0((Ghasedak$ResponseGetRoutesStates) obj, (Exception) obj2);
            }
        });
    }

    private void B1() {
        InterfaceC22912w18 interfaceC22912w18 = this.A;
        if (interfaceC22912w18 != null) {
            interfaceC22912w18.a();
            this.A = null;
            C19406qI3.a("NewSequenceActor", "Released Wake Lock", new Object[0]);
        }
    }

    private void C0() {
        for (final Integer num : this.E.keySet()) {
            List listG0 = G0(num.intValue());
            if (!listG0.isEmpty()) {
                AbstractC14258hd0.a aVar = (AbstractC14258hd0.a) listG0.remove(0);
                if (M0()) {
                    C19406qI3.a("NewSequenceActor", "Get diff is in progress, so Stash SeqUpdate seq: #" + aVar.b() + ", routeId: #" + aVar.a(), new Object[0]);
                    y1(aVar);
                } else {
                    final int iB = aVar.b();
                    if (!this.B.w().containsKey(num)) {
                        this.B.q(num.intValue(), 0L, aVar.c());
                        this.B.D(num.intValue(), iB - 1);
                        q1();
                    }
                    int iIntValue = ((Integer) this.B.w().get(num)).intValue();
                    if (iB <= iIntValue) {
                        C19406qI3.a("NewSequenceActor", "Ignored SeqUpdate {seq:" + iB + " groupId: " + num + ", currentSeq: " + this.B.w().get(num) + "}", new Object[0]);
                        C0();
                        return;
                    }
                    Boolean bool = (Boolean) this.D.get(num);
                    if (bool != null && bool.booleanValue()) {
                        C19406qI3.a("NewSequenceActor", "Is processing update for g" + num + ". stash #" + iB, new Object[0]);
                        y1(aVar);
                    } else if (iB == iIntValue + 1) {
                        if (this.y.C(aVar.d())) {
                            C19406qI3.j("NewSequenceActor", "Invalidating: No Users of Groups available for update " + aVar, new Object[0]);
                            F0();
                            return;
                        }
                        C19406qI3.a("NewSequenceActor", "Handling update #" + iB + " groupId #" + num, new Object[0]);
                        this.D.put(num, Boolean.TRUE);
                        x1();
                        this.z.k(aVar.d()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.tw4
                            @Override // ir.nasim.InterfaceC24449ye1
                            public final void apply(Object obj) {
                                this.a.T0(num, iB, (C14505i18) obj);
                            }
                        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.uw4
                            @Override // ir.nasim.InterfaceC24449ye1
                            public final void apply(Object obj) {
                                this.a.U0(iB, num, (Exception) obj);
                            }
                        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.vw4
                            @Override // ir.nasim.InterfaceC3273Ae1
                            public final void apply(Object obj, Object obj2) {
                                this.a.V0((C14505i18) obj, (Exception) obj2);
                            }
                        });
                    } else if (iB - iIntValue <= 10 || !N0(num.intValue())) {
                        C19406qI3.j("NewSequenceActor", "Out of sequence: Small hole. OldSeq is #" + iIntValue + ", but seq is #" + iB + " for group id : " + num, new Object[0]);
                        y1(aVar);
                        if (!this.q) {
                            C19406qI3.a("NewSequenceActor", "Out of sequence: Start Small Hole timer", new Object[0]);
                            w1();
                        }
                    } else {
                        C19406qI3.j("NewSequenceActor", "Out of sequence: Too big hole. OldSeq is #" + iIntValue + ", but seq is #" + iB + " for group id : " + num, new Object[0]);
                        if (!this.p) {
                            C19406qI3.a("NewSequenceActor", "Out of sequence: Start Invalidation timer", new Object[0]);
                            u1();
                        }
                    }
                }
            }
        }
    }

    private ArrayList C1(Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff) {
        ArrayList arrayList = new ArrayList();
        for (Ghasedak$GroupUpdates ghasedak$GroupUpdates : ghasedak$ResponseGetDiff.getUpdatesList()) {
            if (ghasedak$GroupUpdates.getState().getGroupPeer().getGroupId() != 0 && ghasedak$GroupUpdates.hasTooLong() && ghasedak$GroupUpdates.getTooLong().getValue()) {
                arrayList.add(C14994ip6.b(ghasedak$GroupUpdates.getState()));
            }
        }
        return arrayList;
    }

    private void D0(final List list) {
        this.o = true;
        C19406qI3.a("NewSequenceActor", "Start refresh dialogs for " + list.size() + " groups", new Object[0]);
        ArrayList arrayList = new ArrayList();
        if (C8386Vt0.U6()) {
            C19406qI3.a("NewSequenceActor", "sync group calls state", new Object[0]);
            ((InterfaceC12620ev0) C92.a(C5721Ko.b, InterfaceC12620ev0.class)).f0().d();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C14994ip6 c14994ip6 = (C14994ip6) it.next();
            arrayList.add(new C17557nA(CA.GROUP, c14994ip6.c().b(), c14994ip6.c().a()));
        }
        this.m.V().q0(new ArrayList(arrayList)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.iw4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.W0(list, (C14505i18) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.jw4
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                this.a.X0(list, (C14505i18) obj, (Exception) obj2);
            }
        });
    }

    private void E0() {
        if (this.r) {
            this.m.a().f(new C11963dq6());
            BN6.r().c(Boolean.TRUE);
            this.r = false;
            ((HS1) I22.a(C5721Ko.b, HS1.class)).I().b();
        }
    }

    private void F0() {
        FE0 fe0 = this.w;
        if (fe0 != null) {
            fe0.cancel();
            this.w = null;
        }
        y0();
        this.w = q(new C8897Xu2(), 0L);
        this.p = false;
    }

    private List G0(int i) {
        return (List) this.E.computeIfAbsent(Integer.valueOf(i), new Function() { // from class: ir.nasim.ww4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C24631yw4.Y0((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(Exception exc) {
        C19406qI3.a("NewSequenceActor", "get_diff_request_failure, exception: " + exc.getMessage(), new Object[0]);
        this.n = false;
        this.v = false;
        this.u = 0;
        this.m.v().E().g().i(Boolean.FALSE);
        k1();
        E0();
        if (((Boolean) this.m.v().E().f().b()).booleanValue()) {
            return;
        }
        this.I.b();
        v1(this.I.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff) {
        final long jP = AbstractC20507s76.p();
        if (M0()) {
            this.I.c();
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = new ArrayList();
            final ArrayList arrayListJ1 = j1(ghasedak$ResponseGetDiff);
            ArrayList arrayListC1 = C1(ghasedak$ResponseGetDiff);
            if (P0(ghasedak$ResponseGetDiff)) {
                J0(jP, ghasedak$ResponseGetDiff);
                return;
            }
            if (!arrayListC1.isEmpty()) {
                D0(arrayListC1);
            }
            for (Ghasedak$GroupUpdates ghasedak$GroupUpdates : ghasedak$ResponseGetDiff.getUpdatesList()) {
                C14994ip6 c14994ip6B = C14994ip6.b(ghasedak$GroupUpdates.getState());
                arrayList2.add(c14994ip6B);
                if (!ghasedak$GroupUpdates.getUpdatesList().isEmpty()) {
                    for (SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates : ghasedak$GroupUpdates.getUpdatesList()) {
                        try {
                            AbstractC20556sC7 abstractC20556sC7C = this.G.c(setUpdatesStruct$ComposedUpdates);
                            if (abstractC20556sC7C != null) {
                                arrayList.add(abstractC20556sC7C);
                                if (c14994ip6B.c().b() > 1 && ((abstractC20556sC7C instanceof C9593aD7) || (abstractC20556sC7C instanceof C21851uE7) || (abstractC20556sC7C instanceof C23037wE7))) {
                                    arrayList3.add(c14994ip6B);
                                }
                            }
                        } catch (Exception unused) {
                            C19406qI3.b("NewSequenceActor", "Error in parsing update. header: " + setUpdatesStruct$ComposedUpdates);
                        }
                    }
                }
            }
            i1(ghasedak$ResponseGetDiff, jP);
            this.z.j(C18732p92.J(ghasedak$ResponseGetDiff.getUsersRefsList()), C18732p92.A(ghasedak$ResponseGetDiff.getGroupsRefsList()), arrayList).A(new InterfaceC17569nB2() { // from class: ir.nasim.xw4
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.Z0(arrayList2, arrayList3, (C14505i18) obj);
                }
            }).A(new InterfaceC17569nB2() { // from class: ir.nasim.fw4
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.a1(jP, arrayListJ1, (C14505i18) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.gw4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.b1((Exception) obj);
                }
            });
        }
    }

    private void J0(final long j, final Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff) {
        C19406qI3.a("NewSequenceActor", "do handleTooLongGetDiff", new Object[0]);
        W().g("settings_sync_state_loaded_v2", false);
        W().g("contacts_loaded", false);
        W().g("key_sp_stickers_loaded_v2.1", false);
        W().g("should_refresh_saved_gifs", true);
        this.m.T().E();
        final ArrayList arrayList = new ArrayList();
        this.m.G().W0().A(new InterfaceC17569nB2() { // from class: ir.nasim.kw4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24631yw4.f1(ghasedak$ResponseGetDiff, arrayList, (C14505i18) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.lw4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.g1(arrayList, (C14505i18) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.mw4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.c1(j, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.nw4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.d1((Exception) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.ow4
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                this.a.e1((C14505i18) obj, (Exception) obj2);
            }
        });
    }

    private synchronized void K0() {
        try {
            if (M0()) {
                return;
            }
            this.n = true;
            if (L0()) {
                B0();
            } else {
                A0(this.B.u());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean L0() {
        Integer num = (Integer) this.B.w().get(0);
        return num == null || num.intValue() <= 0;
    }

    private boolean M0() {
        return this.n || this.o;
    }

    private boolean N0(int i) {
        List list = (List) this.E.get(Integer.valueOf(i));
        if (list != null) {
            return list.isEmpty();
        }
        return true;
    }

    private boolean O0() {
        Iterator it = this.E.keySet().iterator();
        while (it.hasNext()) {
            if (!N0(((Integer) it.next()).intValue())) {
                return false;
            }
        }
        return true;
    }

    private boolean P0(Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff) {
        for (Ghasedak$GroupUpdates ghasedak$GroupUpdates : ghasedak$ResponseGetDiff.getUpdatesList()) {
            if (ghasedak$GroupUpdates.getState() != null && ghasedak$GroupUpdates.getState().getGroupPeer() != null && ghasedak$GroupUpdates.getState().getGroupPeer().getGroupId() == 0 && ghasedak$GroupUpdates.hasTooLong() && ghasedak$GroupUpdates.getTooLong().getValue()) {
                C19406qI3.a("NewSequenceActor", "is too Long Situation", new Object[0]);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Q0(Ghasedak$RouteSeqState ghasedak$RouteSeqState, Ghasedak$RouteSeqState ghasedak$RouteSeqState2) {
        if (ghasedak$RouteSeqState.getGroupPeer().getGroupId() > ghasedak$RouteSeqState2.getGroupPeer().getGroupId()) {
            return 1;
        }
        return ghasedak$RouteSeqState.getGroupPeer().getGroupId() < ghasedak$RouteSeqState2.getGroupPeer().getGroupId() ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(Ghasedak$ResponseGetRoutesStates ghasedak$ResponseGetRoutesStates) {
        ArrayList arrayList = new ArrayList(ghasedak$ResponseGetRoutesStates.getSeqsList());
        arrayList.sort(new Comparator() { // from class: ir.nasim.hw4
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C24631yw4.Q0((Ghasedak$RouteSeqState) obj, (Ghasedak$RouteSeqState) obj2);
            }
        });
        this.B.C(C14994ip6.e(arrayList));
        q1();
        t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(Ghasedak$ResponseGetRoutesStates ghasedak$ResponseGetRoutesStates, Exception exc) {
        if (exc != null) {
            C19406qI3.j("NewSequenceActor", "getGroupState failed: " + exc, new Object[0]);
        }
        this.n = false;
        E0();
        k1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(Integer num, int i, C14505i18 c14505i18) {
        C19406qI3.a("NewSequenceActor", "Handling update ended route:# " + num + " seq:# " + i, new Object[0]);
        p1(i, num.intValue());
        this.D.put(num, Boolean.FALSE);
        if (this.q && O0()) {
            C19406qI3.a("NewSequenceActor", "StashFullyEmpty: Stop Small hole timer", new Object[0]);
            A1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(int i, Integer num, Exception exc) {
        C19406qI3.a("NewSequenceActor", "Handle Seq Update seq:#" + i + " for group:#" + num + " Failed", new Object[0]);
        this.D.put(num, Boolean.FALSE);
        u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(C14505i18 c14505i18, Exception exc) {
        C0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(List list, C14505i18 c14505i18) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C14994ip6 c14994ip6 = (C14994ip6) it.next();
            this.B.D(c14994ip6.c().b(), c14994ip6.d());
        }
        q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(List list, C14505i18 c14505i18, Exception exc) {
        if (exc == null) {
            C19406qI3.a("NewSequenceActor", "Finished refresh dialogs for " + list.size() + " groups", new Object[0]);
        } else {
            C19406qI3.a("NewSequenceActor", "Error in refreshing dialogs: " + exc.getMessage(), new Object[0]);
        }
        this.o = false;
        k1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List Y0(Integer num) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 Z0(ArrayList arrayList, ArrayList arrayList2, C14505i18 c14505i18) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C14994ip6 c14994ip6 = (C14994ip6) it.next();
            this.B.D(c14994ip6.c().b(), c14994ip6.d());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.B.r(((C14994ip6) it2.next()).c().b());
        }
        q1();
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 a1(long j, ArrayList arrayList, C14505i18 c14505i18) {
        C19406qI3.a("NewSequenceActor", "process Difference updates ended in " + (AbstractC20507s76.p() - j) + " ms", new Object[0]);
        if (arrayList.isEmpty()) {
            this.n = false;
            k1();
            m1();
        } else {
            C19406qI3.a("NewSequenceActor", "Need More. Get difference again.", new Object[0]);
            this.u++;
            r().d(new LF2(arrayList));
        }
        E0();
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(Exception exc) {
        C19406qI3.a("NewSequenceActor", "get_diff_apply_failure, exception:" + exc.getMessage(), new Object[0]);
        this.n = false;
        this.v = false;
        q(new C8897Xu2(), 2000L);
        k1();
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 c1(long j, C14505i18 c14505i18) {
        C19406qI3.a("NewSequenceActor", "handleTooLongGetDiff process Difference updates ended in " + (AbstractC20507s76.p() - j) + " ms", new Object[0]);
        m1();
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(Exception exc) {
        C19406qI3.a("NewSequenceActor", "get_diff_apply_failure, exception:" + exc, new Object[0]);
        q(new C8897Xu2(), 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(C14505i18 c14505i18, Exception exc) {
        this.n = false;
        k1();
        this.v = false;
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 f1(Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff, ArrayList arrayList, C14505i18 c14505i18) {
        Iterator<Ghasedak$GroupUpdates> it = ghasedak$ResponseGetDiff.getUpdatesList().iterator();
        while (it.hasNext()) {
            arrayList.add(C14994ip6.b(it.next().getState()));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 g1(ArrayList arrayList, C14505i18 c14505i18) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C14994ip6 c14994ip6 = (C14994ip6) it.next();
            this.B.D(c14994ip6.c().b(), c14994ip6.d());
        }
        q1();
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h1(AbstractC14258hd0.a aVar, AbstractC14258hd0.a aVar2) {
        if (aVar.b() > aVar2.b()) {
            return 1;
        }
        return aVar.b() == aVar2.b() ? 0 : -1;
    }

    private void i1(Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff, long j) {
        C19406qI3.a("NewSequenceActor", "Difference loaded in " + (AbstractC20507s76.p() - this.s) + " ms, parsed in " + (AbstractC20507s76.p() - j) + " ms, seqStates: " + ghasedak$ResponseGetDiff.getUpdatesList().size() + ", userRefs: " + ghasedak$ResponseGetDiff.getUsersRefsList().size() + ", groupRefs: " + ghasedak$ResponseGetDiff.getGroupsRefsList().size(), new Object[0]);
        byte[] byteArray = ghasedak$ResponseGetDiff.toByteArray();
        StringBuilder sb = new StringBuilder();
        sb.append("Difference loaded size: ");
        sb.append(byteArray.length);
        sb.append(" bytes");
        C19406qI3.a("NewSequenceActor", sb.toString(), new Object[0]);
    }

    private ArrayList j1(Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff) {
        ArrayList arrayList = new ArrayList();
        for (Ghasedak$GroupUpdates ghasedak$GroupUpdates : ghasedak$ResponseGetDiff.getUpdatesList()) {
            if (ghasedak$GroupUpdates.getNeedMore()) {
                arrayList.add(C14994ip6.b(ghasedak$GroupUpdates.getState()));
            }
        }
        return arrayList;
    }

    private void k1() {
        C19406qI3.a("NewSequenceActor", "on become valid", new Object[0]);
        if (this.o || this.n) {
            C19406qI3.a("NewSequenceActor", "on become valid: do not unstash queued updates", new Object[0]);
            return;
        }
        B1();
        y();
        z1();
    }

    private void l1(C9010Yc2 c9010Yc2) {
        if (!this.B.w().containsKey(Integer.valueOf(c9010Yc2.a())) || c9010Yc2.c() > ((Integer) this.B.w().get(Integer.valueOf(c9010Yc2.a()))).intValue()) {
            this.C.add(c9010Yc2);
        } else {
            c9010Yc2.b().run();
        }
    }

    private void m1() {
        this.v = false;
        this.m.v().E().g().i(Boolean.FALSE);
        C19406qI3.a("NewSequenceActor", "get_diff_end, load_more_count:" + this.u + ", get_diff_total_time:" + (System.currentTimeMillis() - this.t) + "ms", new Object[0]);
        this.u = 0;
    }

    private void n1() {
        x1();
        if (!this.v) {
            this.v = true;
            this.m.v().E().g().i(Boolean.TRUE);
            this.t = AbstractC20507s76.p();
        }
        this.s = AbstractC20507s76.p();
    }

    private synchronized void o1(AbstractC14258hd0.a aVar) {
        y1(aVar);
        Boolean bool = (Boolean) this.D.get(Integer.valueOf(aVar.a()));
        if (bool == null || !bool.booleanValue()) {
            C0();
            return;
        }
        C19406qI3.a("NewSequenceActor", "Is processing update for g" + aVar.a() + ". stash #" + aVar.b(), new Object[0]);
    }

    private void p1(int i, int i2) {
        if (this.B.w().containsKey(Integer.valueOf(i2)) && i >= ((Integer) this.B.w().get(Integer.valueOf(i2))).intValue()) {
            s1(i, i2);
            q1();
        }
        B1();
        x0();
    }

    private void q1() {
        this.F.e(new C9863ah0(4L, this.B.toByteArray()));
    }

    private void r1(C21007sy5 c21007sy5) {
        AbstractC14258hd0 abstractC14258hd0B = this.G.a(MavizStreamOuterClass$Event.parseFrom(c21007sy5.b));
        if (!(abstractC14258hd0B instanceof AbstractC14258hd0.a)) {
            if (abstractC14258hd0B instanceof AbstractC14258hd0.b) {
                AbstractC14258hd0.b bVar = (AbstractC14258hd0.b) abstractC14258hd0B;
                C19406qI3.a("NewSequenceActor", "WeakUpdate: " + bVar.b().getClass().getSimpleName(), new Object[0]);
                this.z.l(bVar.b(), bVar.a());
                return;
            }
            return;
        }
        AbstractC14258hd0.a aVar = (AbstractC14258hd0.a) abstractC14258hd0B;
        if (M0()) {
            C19406qI3.a("NewSequenceActor", "Get diff in progress, so Stash SeqUpdate seq: #" + aVar.b() + ", routeId: #" + aVar.a(), new Object[0]);
            y1(aVar);
            return;
        }
        C19406qI3.a("NewSequenceActor", "SeqUpdate seq: #" + aVar.b() + ", routeId: #" + aVar.a(), new Object[0]);
        o1(aVar);
    }

    private void s1(int i, int i2) {
        this.B.D(i2, i);
    }

    private void t1() {
        if (this.E.size() != this.B.w().size()) {
            for (Integer num : this.B.w().keySet()) {
                num.intValue();
                this.E.put(num, new ArrayList());
            }
        }
    }

    private void u1() {
        v1(2000L);
    }

    private void v1(long j) {
        if (this.p) {
            return;
        }
        FE0 fe0 = this.w;
        if (fe0 != null) {
            fe0.cancel();
            this.w = null;
        }
        this.w = q(new C8897Xu2(), j);
        this.p = true;
    }

    private void w1() {
        if (this.q) {
            return;
        }
        FE0 fe0 = this.x;
        if (fe0 != null) {
            fe0.cancel();
            this.x = null;
        }
        this.x = q(new C8897Xu2(), 2000L);
        this.q = true;
    }

    private void x0() {
        if (this.C.size() > 0) {
            ArrayList arrayList = this.C;
            for (C9010Yc2 c9010Yc2 : (C9010Yc2[]) arrayList.toArray(new C9010Yc2[arrayList.size()])) {
                if (c9010Yc2.c() <= ((Integer) this.B.w().get(Integer.valueOf(c9010Yc2.a()))).intValue()) {
                    c9010Yc2.b().run();
                    this.C.remove(c9010Yc2);
                }
            }
        }
    }

    private void x1() {
        if (this.A == null) {
            this.A = AbstractC20507s76.x();
            C19406qI3.a("NewSequenceActor", "Starting Wake Lock", new Object[0]);
        }
    }

    private void y0() {
        for (Integer num : this.E.keySet()) {
            num.intValue();
            ((List) this.E.get(num)).clear();
        }
    }

    private synchronized void y1(AbstractC14258hd0.a aVar) {
        try {
            List listG0 = G0(aVar.a());
            if (!listG0.contains(aVar)) {
                listG0.add(aVar);
                C19406qI3.a("NewSequenceActor", "stashSorted Add: seq: #" + aVar.b() + " routeId: #" + aVar.a(), new Object[0]);
            }
            Collections.sort(listG0, new Comparator() { // from class: ir.nasim.qw4
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C24631yw4.h1((AbstractC14258hd0.a) obj, (AbstractC14258hd0.a) obj2);
                }
            });
        } catch (Throwable th) {
            throw th;
        }
    }

    private void z0(int i) {
        this.B.r(i);
        q1();
    }

    private void z1() {
        this.p = false;
        FE0 fe0 = this.w;
        if (fe0 != null) {
            fe0.cancel();
            this.w = null;
        }
    }

    @Override // ir.nasim.AbstractC6360Ng4, ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        if (!(abstractC18385oa2 instanceof C15459jd1) || M0() || ((C15459jd1) abstractC18385oa2).a) {
            return;
        }
        r().d(new C9011Yc3());
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if ((obj instanceof C9011Yc3) || (obj instanceof C16766lp6) || (obj instanceof C8897Xu2) || (obj instanceof C15692k07)) {
            if (M0()) {
                C19406qI3.a("NewSequenceActor", "No need to get diff, because get diff is in progress", new Object[0]);
                return;
            }
            C19406qI3.a("NewSequenceActor", "Start get diff because " + obj + " received.", new Object[0]);
            K0();
            return;
        }
        if (obj instanceof LF2) {
            A0(((LF2) obj).a());
            return;
        }
        if (obj instanceof C21007sy5) {
            r1((C21007sy5) obj);
            return;
        }
        if (obj instanceof C9010Yc2) {
            if (M0()) {
                t();
                return;
            } else {
                l1((C9010Yc2) obj);
                return;
            }
        }
        if (obj instanceof KA1) {
            z0(((KA1) obj).a());
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        this.B = C6937Pp6.y();
        C9863ah0 c9863ah0 = (C9863ah0) this.F.n(4L);
        if (c9863ah0 != null) {
            try {
                this.B.z(c9863ah0.q());
            } catch (IOException e) {
                C19406qI3.a("SequenceLog", "init sequenceStateStorage.setData error: " + e.getMessage(), new Object[0]);
            }
        }
        this.y = new C24235yG7(this.m);
        this.z = this.m.V().Z();
        this.A = AbstractC20507s76.x();
        t1();
        this.m.a().h(this, "connecting_state_changed");
        r().d(new C9011Yc3());
    }
}
