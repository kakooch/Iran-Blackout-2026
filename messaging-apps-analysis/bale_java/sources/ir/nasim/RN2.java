package ir.nasim;

import ai.bale.proto.GroupsOuterClass$RequestFetchGroupAdmins;
import ai.bale.proto.GroupsOuterClass$RequestGetFullGroup;
import ai.bale.proto.GroupsOuterClass$RequestLoadMembers;
import ai.bale.proto.GroupsOuterClass$RequestSetAvailableReactions;
import ai.bale.proto.GroupsOuterClass$ResponseFetchGroupAdmins;
import ai.bale.proto.GroupsOuterClass$ResponseGetFullGroup;
import ai.bale.proto.GroupsOuterClass$ResponseLoadMembers;
import ai.bale.proto.GroupsStruct$LoadMembersCondition;
import ai.bale.proto.GroupsStruct$Member;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.BoolValue;
import com.google.protobuf.BytesValue;
import ir.nasim.database.dailogLists.MessageIdentifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class RN2 extends AbstractC6360Ng4 {
    private C9057Yh4 m;
    private final ConcurrentHashMap n;
    private boolean o;

    public RN2(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.n = new ConcurrentHashMap();
        this.o = false;
        this.m = c9057Yh4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A1(int i, GroupsOuterClass$ResponseGetFullGroup groupsOuterClass$ResponseGetFullGroup, Exception exc) {
        this.n.remove(Integer.valueOf(i));
    }

    private C6517Nv5 A2(int i, final int i2) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.NN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.W1(i2, (C14697iL2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 B1(GroupsOuterClass$ResponseGetFullGroup groupsOuterClass$ResponseGetFullGroup) {
        C14697iL2 c14697iL2J0 = C18732p92.j0(groupsOuterClass$ResponseGetFullGroup.getFullGroup());
        this.m.E().X1().e(c14697iL2J0);
        return this.m.G().K0().z(c14697iL2J0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 C1(int i, C14697iL2 c14697iL2) {
        return L(new C22871vx5("/bale.groups.v1.Groups/FetchGroupAdmins", GroupsOuterClass$RequestFetchGroupAdmins.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i).A(c14697iL2.getAccessHash()).a()).a(), GroupsOuterClass$ResponseFetchGroupAdmins.getDefaultInstance()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 D1(GroupsOuterClass$ResponseFetchGroupAdmins groupsOuterClass$ResponseFetchGroupAdmins) {
        ArrayList arrayList = new ArrayList();
        for (GroupsStruct$Member groupsStruct$Member : groupsOuterClass$ResponseFetchGroupAdmins.getAdminsList()) {
            arrayList.add(new C23104wM2(groupsStruct$Member.getUid(), groupsStruct$Member.getInviterUid(), groupsStruct$Member.getDate(), true, Integer.valueOf(groupsStruct$Member.getPromoterUserId().getValue()), groupsStruct$Member.hasTitle() ? groupsStruct$Member.getTitle().getValue() : null));
        }
        return C6517Nv5.l0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 E1(int i, int i2, BytesValue bytesValue, C14697iL2 c14697iL2) {
        return L(new C22871vx5("/bale.groups.v1.Groups/LoadMembers", GroupsOuterClass$RequestLoadMembers.newBuilder().B(PeersStruct$GroupOutPeer.newBuilder().B(i).A(c14697iL2.getAccessHash())).C(i2).D(bytesValue).A((GroupsStruct$LoadMembersCondition) GroupsStruct$LoadMembersCondition.newBuilder().A((BoolValue) BoolValue.newBuilder().A(false).a()).a()).a(), GroupsOuterClass$ResponseLoadMembers.getDefaultInstance()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 F1(C24878zM2 c24878zM2, List list, ArrayList arrayList, GroupsOuterClass$ResponseLoadMembers groupsOuterClass$ResponseLoadMembers) {
        c24878zM2.d(groupsOuterClass$ResponseLoadMembers.getNext());
        for (GroupsStruct$Member groupsStruct$Member : groupsOuterClass$ResponseLoadMembers.getMembersList()) {
            C23104wM2 c23104wM2 = new C23104wM2(groupsStruct$Member.getUid(), groupsStruct$Member.getInviterUid(), groupsStruct$Member.getDate(), groupsStruct$Member.getIsAdmin().getValue(), Integer.valueOf(groupsStruct$Member.getPromoterUserId().getValue()), groupsStruct$Member.hasTitle() ? groupsStruct$Member.getTitle().getValue() : null);
            DA daK0 = C18732p92.K0(groupsStruct$Member.getPermissions());
            if (groupsStruct$Member.getPermissions() != null && daK0 != null) {
                c23104wM2.k(C18732p92.t(daK0));
            }
            list.add(c23104wM2);
            arrayList.add(Integer.valueOf(groupsStruct$Member.getUid()));
        }
        return AbstractC5969Lp4.d().V0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 G1(List list, C21231tK7 c21231tK7) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C23104wM2 c23104wM2 = (C23104wM2) it.next();
            if (c23104wM2.f() == c21231tK7.o()) {
                c23104wM2.l(c21231tK7);
                return C6517Nv5.l0(c23104wM2);
            }
        }
        return C6517Nv5.F(new Exception("Not Found GroupMember"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H1(C24878zM2 c24878zM2, C7234Qv5 c7234Qv5, List list) {
        c24878zM2.c(list);
        c7234Qv5.b(c24878zM2);
    }

    private C6517Nv5 H2(AbstractC20556sC7 abstractC20556sC7) {
        if (abstractC20556sC7 instanceof C19374qE7) {
            C19374qE7 c19374qE7 = (C19374qE7) abstractC20556sC7;
            return G2(c19374qE7.b(), c19374qE7.c(), c19374qE7.e(), c19374qE7.d(), c19374qE7.a());
        }
        if (abstractC20556sC7 instanceof ID7) {
            ID7 id7 = (ID7) abstractC20556sC7;
            return n2(id7.b(), id7.a());
        }
        if (abstractC20556sC7 instanceof KD7) {
            KD7 kd7 = (KD7) abstractC20556sC7;
            return p2(kd7.c(), kd7.d(), kd7.e(), kd7.a(), kd7.b());
        }
        if (abstractC20556sC7 instanceof WD7) {
            WD7 wd7 = (WD7) abstractC20556sC7;
            InterfaceC8038Ug3.a.a().c(abstractC20556sC7);
            return C2(wd7.b(), wd7.d(), wd7.c(), wd7.a(), Integer.valueOf(wd7.e()), wd7.f());
        }
        if (abstractC20556sC7 instanceof C23037wE7) {
            C23037wE7 c23037wE7 = (C23037wE7) abstractC20556sC7;
            return K2(c23037wE7.b(), c23037wE7.c(), c23037wE7.d(), c23037wE7.a());
        }
        if (abstractC20556sC7 instanceof C21851uE7) {
            C21851uE7 c21851uE7 = (C21851uE7) abstractC20556sC7;
            return J2(c21851uE7.b(), c21851uE7.d(), c21851uE7.e(), c21851uE7.c(), c21851uE7.a());
        }
        if (abstractC20556sC7 instanceof C20574sE7) {
            C20574sE7 c20574sE7 = (C20574sE7) abstractC20556sC7;
            return I2(c20574sE7.b(), c20574sE7.d(), c20574sE7.e(), c20574sE7.c(), c20574sE7.a(), c20574sE7.f());
        }
        if (abstractC20556sC7 instanceof C12219eE7) {
            C12219eE7 c12219eE7 = (C12219eE7) abstractC20556sC7;
            return B2(c12219eE7.a(), c12219eE7.b());
        }
        if (abstractC20556sC7 instanceof YD7) {
            YD7 yd7 = (YD7) abstractC20556sC7;
            return z2(yd7.a(), yd7.b(), yd7.c());
        }
        if (abstractC20556sC7 instanceof C15828kE7) {
            C15828kE7 c15828kE7 = (C15828kE7) abstractC20556sC7;
            return w2(c15828kE7.a(), c15828kE7.b());
        }
        if (abstractC20556sC7 instanceof C10812cE7) {
            C10812cE7 c10812cE7 = (C10812cE7) abstractC20556sC7;
            return A2(c10812cE7.a(), c10812cE7.b());
        }
        if (abstractC20556sC7 instanceof UD7) {
            UD7 ud7 = (UD7) abstractC20556sC7;
            return s2(ud7.b(), ud7.a());
        }
        if (abstractC20556sC7 instanceof MD7) {
            return r2(((MD7) abstractC20556sC7).a());
        }
        if (abstractC20556sC7 instanceof C14639iE7) {
            C14639iE7 c14639iE7 = (C14639iE7) abstractC20556sC7;
            return D2(c14639iE7.a(), c14639iE7.b());
        }
        if (abstractC20556sC7 instanceof UC7) {
            UC7 uc7 = (UC7) abstractC20556sC7;
            return q2(uc7.c(), uc7.a(), uc7.b());
        }
        if (abstractC20556sC7 instanceof WC7) {
            WC7 wc7 = (WC7) abstractC20556sC7;
            return o2(wc7.b(), wc7.a());
        }
        if (abstractC20556sC7 instanceof C13446gE7) {
            C13446gE7 c13446gE7 = (C13446gE7) abstractC20556sC7;
            return E2(c13446gE7.a(), c13446gE7.b());
        }
        if (abstractC20556sC7 instanceof C17010mE7) {
            C17010mE7 c17010mE7 = (C17010mE7) abstractC20556sC7;
            return F2(c17010mE7.a(), c17010mE7.b());
        }
        if (abstractC20556sC7 instanceof C18192oE7) {
            C18192oE7 c18192oE7 = (C18192oE7) abstractC20556sC7;
            return y2(c18192oE7.a(), c18192oE7.b());
        }
        if (abstractC20556sC7 instanceof C9602aE7) {
            C9602aE7 c9602aE7 = (C9602aE7) abstractC20556sC7;
            return x2(c9602aE7.a(), c9602aE7.b(), c9602aE7.c());
        }
        if (!(abstractC20556sC7 instanceof SD7)) {
            return C6517Nv5.l0(C14505i18.a);
        }
        SD7 sd7 = (SD7) abstractC20556sC7;
        return t2(sd7.a(), sd7.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I1(ArrayList arrayList, final List list, final C24878zM2 c24878zM2, final C7234Qv5 c7234Qv5, C14505i18 c14505i18) {
        AbstractC5969Lp4.d().k0().l(arrayList).I(new InterfaceC17569nB2() { // from class: ir.nasim.HN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.G1(list, (C21231tK7) obj);
            }
        }).M().m0(new InterfaceC24449ye1() { // from class: ir.nasim.JN2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                RN2.H1(c24878zM2, c7234Qv5, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J1(final int i, final int i2, final BytesValue bytesValue, final C24878zM2 c24878zM2, final List list, final ArrayList arrayList, final C7234Qv5 c7234Qv5) {
        this.m.E().X1().a(i).H(new InterfaceC17569nB2() { // from class: ir.nasim.AN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.E1(i, i2, bytesValue, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.BN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.F1(c24878zM2, list, arrayList, (GroupsOuterClass$ResponseLoadMembers) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.CN2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                RN2.I1(arrayList, list, c24878zM2, c7234Qv5, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 K1(String str, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.J(str));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 L1(EnumC6364Nh enumC6364Nh, int i, C14697iL2 c14697iL2) {
        if (enumC6364Nh == EnumC6364Nh.c || enumC6364Nh == EnumC6364Nh.d) {
            this.m.G().H0(C11458d25.y(i)).b(0L);
        }
        this.m.E().X1().e(c14697iL2.K(EnumC4599Fv.valueOf(enumC6364Nh.toString())));
        return C6517Nv5.l0(C14505i18.a);
    }

    private void L2(C11458d25 c11458d25, final List list) {
        if (c11458d25.s() != W25.b) {
            return;
        }
        final int peerId = c11458d25.getPeerId();
        this.m.E().X1().a(peerId).m0(new InterfaceC24449ye1() { // from class: ir.nasim.QM2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.m2(peerId, list, (C14697iL2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 M1(C14697iL2 c14697iL2, J44 j44, C14505i18 c14505i18) {
        return m1().x(c14697iL2.I0(), j44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 N1(C6984Pv c6984Pv, long j, long j2, int i, final C14697iL2 c14697iL2) {
        C14697iL2 c14697iL2M = c14697iL2.M(c6984Pv);
        this.m.E().X1().e(c14697iL2M);
        C6517Nv5 c6517Nv5U2 = u2(c14697iL2M);
        final J44 j44 = new J44(j, j2, j2, i, i == this.m.i0() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN, new C16786lr6(c6984Pv));
        c6517Nv5U2.A(new InterfaceC17569nB2() { // from class: ir.nasim.DN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.M1(c14697iL2, j44, (C14505i18) obj);
            }
        });
        return c6517Nv5U2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 O1(String str, String str2, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.N(str, str2));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 P1(C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.Y(Boolean.TRUE));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 Q1(C7714Sx c7714Sx, int i, C14697iL2 c14697iL2) {
        C17067mL1 c17067mL1;
        C14697iL2 c14697iL2R = c14697iL2.R(c7714Sx);
        this.m.E().X1().e(c14697iL2R);
        long jU = C11458d25.y(i).u();
        if (c14697iL2R.x0() != null && (c17067mL1 = (C17067mL1) this.m.G().J0().a(jU)) != null) {
            this.m.G().J0().d(c17067mL1.z(c14697iL2R.x0()));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 R1(DA da, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.S(da, this.m.i0()));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 S1(int i, int i2, C14697iL2 c14697iL2) {
        int iW0 = c14697iL2.w0();
        C14697iL2 c14697iL2A0 = c14697iL2.a0(i);
        if (i == this.m.i0() || iW0 == this.m.i0()) {
            c14697iL2A0 = c14697iL2A0.P(true).O(true).Q(true);
            this.m.V().t0(new ArrayList(), Arrays.asList(new C25238zy(i2, c14697iL2A0.getAccessHash())), true);
        }
        this.m.E().X1().e(c14697iL2A0);
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 T1(DA da, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.T(da));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 U1(W06 w06, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.U(w06.j()));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 V1(int i, boolean z, int i2, C14697iL2 c14697iL2) {
        C23104wM2 c23104wM2R0 = c14697iL2.r0(i);
        C14697iL2 c14697iL2J0 = c14697iL2.J0(i);
        if (c23104wM2R0 != null) {
            c14697iL2J0 = c14697iL2J0.w(c23104wM2R0.f(), c23104wM2R0.b(), c23104wM2R0.a(), z);
        }
        if (i == this.m.i0() && z) {
            C14697iL2 c14697iL2Q = c14697iL2J0.P(true).O(true).Q(true);
            this.m.E().X1().e(c14697iL2Q);
            this.m.V().t0(new ArrayList(), Arrays.asList(new C25238zy(i2, c14697iL2Q.getAccessHash())), true);
        } else if (i != this.m.i0() || z) {
            this.m.E().X1().e(c14697iL2J0);
        } else {
            C14697iL2 c14697iL2Q2 = c14697iL2J0.P(false).O(false).Q(false);
            this.m.E().X1().e(c14697iL2Q2);
            this.m.V().t0(new ArrayList(), Arrays.asList(new C25238zy(i2, c14697iL2Q2.getAccessHash())), true);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 W1(int i, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.W(i));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 X1(List list, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.N0(list));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 Y1(int i, C14505i18 c14505i18) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C18766pD(i, 0L));
        return this.m.V().s0(arrayList, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 a2(final int i, final long j, final int i2, final long j2, final Integer num, final boolean z, C14505i18 c14505i18) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.sN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.Z1(i, j, i2, j2, num, z, (C14697iL2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 b2(Exception exc) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 c2(String str, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.X(str));
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 d1(final List list) {
        this.o = true;
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.eN2
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.n1(list, c7234Qv5);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.fN2
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                this.a.o1((C14505i18) obj, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 d2(C25247zz c25247zz, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.y(c25247zz));
        return C6517Nv5.l0(C14505i18.a);
    }

    private void e1() {
        this.m.E().X1().h().m0(new InterfaceC24449ye1() { // from class: ir.nasim.IN2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.p1((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 e2(MessageIdentifier messageIdentifier, C14697iL2 c14697iL2) {
        this.m.E().X1().e(c14697iL2.K0(new C3460Az(messageIdentifier.getDate(), messageIdentifier.getRid(), messageIdentifier.getSeq())));
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 f1(List list, final Boolean bool) {
        this.o = true;
        final HashMap map = new HashMap();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            map.put((C25238zy) list.get(i), 0L);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(Long.valueOf(((C25238zy) list.get(i2)).q()));
        }
        return this.m.E().X1().g(arrayList).h0(new InterfaceC17569nB2() { // from class: ir.nasim.jN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.q1(map, bool, (List) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.kN2
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                this.a.r1((List) obj, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 f2(C14697iL2 c14697iL2, J44 j44, C14505i18 c14505i18) {
        return m1().x(c14697iL2.I0(), j44);
    }

    private C6517Nv5 g1(int i, final InterfaceC17569nB2 interfaceC17569nB2) {
        this.o = true;
        return this.m.E().X1().a(i).G(new InterfaceC17569nB2() { // from class: ir.nasim.wN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.s1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.yN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.t1(interfaceC17569nB2, (C14697iL2) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.zN2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.u1((C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 g2(String str, long j, long j2, int i, final C14697iL2 c14697iL2) {
        C14697iL2 c14697iL2C0 = c14697iL2.c0(str);
        this.m.E().X1().e(c14697iL2C0);
        C6517Nv5 c6517Nv5U2 = u2(c14697iL2C0);
        final J44 j44 = new J44(j, j2, j2, i, i == this.m.i0() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN, new C23404wr6(str));
        c6517Nv5U2.A(new InterfaceC17569nB2() { // from class: ir.nasim.tN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.f2(c14697iL2, j44, (C14505i18) obj);
            }
        });
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 h1(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C14697iL2((C23464wy) it.next(), null));
        }
        this.m.E().X1().c(arrayList);
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 h2(int i, int i2, long j, boolean z, long j2, C14697iL2 c14697iL2) {
        AbstractC17457n0 c25178zr6;
        int iI0;
        int i3 = i;
        boolean z2 = false;
        boolean z3 = c14697iL2.r0(i3) != null || (i3 == this.m.i0() && c14697iL2.H0());
        C14697iL2 c14697iL2W = c14697iL2.w(i, i2, j, i3 == c14697iL2.w0());
        if (i3 == this.m.i0()) {
            c14697iL2W = c14697iL2W.V(true);
        }
        this.m.E().X1().e(c14697iL2W);
        if ((c14697iL2.q0().equals(ZN2.CHANNEL) && i3 != this.m.i0()) || z3) {
            return C6517Nv5.l0(C14505i18.a);
        }
        C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(i2);
        if (c17637nI7 != null && c17637nI7.p0() && c17637nI7.d0() != null && c17637nI7.d0().equals(c14697iL2.v0())) {
            z2 = true;
        }
        C24584yr6 c24584yr6 = new C24584yr6(i3);
        if (i3 == this.m.i0() && z2) {
            iI0 = this.m.i0();
            c25178zr6 = new C25178zr6();
        } else {
            c25178zr6 = c24584yr6;
            iI0 = i2;
        }
        if (z) {
            c25178zr6 = new C25178zr6();
        } else {
            i3 = iI0;
        }
        return m1().x(c14697iL2.I0(), new J44(j2, j, j, i3, i3 == this.m.i0() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN, c25178zr6));
    }

    private C6517Nv5 i1(final int i) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.ZM2
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.z1(i, arrayList, arrayList2, c7234Qv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 i2(int i, int i2, int i3, long j, long j2, C14697iL2 c14697iL2) {
        boolean z = c14697iL2.r0(i) != null || (i == this.m.i0() && c14697iL2.H0());
        if (i == this.m.i0()) {
            C14697iL2 c14697iL2V = c14697iL2.F().V(false);
            if (c14697iL2.q0().equals(ZN2.CHANNEL)) {
                c14697iL2V = c14697iL2V.P(false).O(false).Q(false);
            }
            this.m.E().X1().e(c14697iL2V);
            this.m.G().m0(c14697iL2.I0());
            this.m.G().j0(c14697iL2.I0());
            this.m.V().Q(i2);
        } else {
            this.m.E().X1().e(c14697iL2.J0(i));
        }
        if (z && (!c14697iL2.q0().equals(ZN2.CHANNEL) || i == this.m.i0() || i3 == this.m.i0())) {
            return m1().x(c14697iL2.I0(), new J44(j, j2, j2, i3, i3 == this.m.i0() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN, new C3395Ar6(i)));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 j1(final int i) {
        C6517Nv5 c6517Nv5 = (C6517Nv5) this.n.get(Integer.valueOf(i));
        if (c6517Nv5 != null) {
            C19406qI3.a("GroupRouter", "getFullGroup " + i + " is running", new Object[0]);
            return c6517Nv5;
        }
        C19406qI3.a("GroupRouter", "Start getFullGroup " + i, new Object[0]);
        C6517Nv5 c6517Nv5H = L(new C22871vx5("/bale.groups.v1.Groups/GetFullGroup", GroupsOuterClass$RequestGetFullGroup.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i).a()).a(), GroupsOuterClass$ResponseGetFullGroup.getDefaultInstance())).z(new InterfaceC3273Ae1() { // from class: ir.nasim.ON2
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                this.a.A1(i, (GroupsOuterClass$ResponseGetFullGroup) obj, (Exception) obj2);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.PN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.B1((GroupsOuterClass$ResponseGetFullGroup) obj);
            }
        });
        this.n.put(Integer.valueOf(i), c6517Nv5H);
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 j2(int i, int i2, long j, long j2, C14697iL2 c14697iL2) {
        boolean z = c14697iL2.r0(i) != null || (i == this.m.i0() && c14697iL2.H0());
        if (i != this.m.i0()) {
            this.m.E().X1().e(c14697iL2.J0(i));
            if (!z || (c14697iL2.q0().equals(ZN2.CHANNEL) && i != this.m.i0())) {
                return C6517Nv5.l0(C14505i18.a);
            }
            return m1().x(c14697iL2.I0(), new J44(j, j2, j2, i, i == this.m.i0() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN, new C3634Br6(i)));
        }
        C14697iL2 c14697iL2V = c14697iL2.F().V(false);
        ZN2 zn2Q0 = c14697iL2.q0();
        ZN2 zn2 = ZN2.CHANNEL;
        if (zn2Q0.equals(zn2)) {
            c14697iL2V = c14697iL2V.P(false).O(false).Q(false);
        }
        this.m.E().X1().e(c14697iL2V);
        this.m.V().Q(i2);
        if (c14697iL2.q0().equals(zn2)) {
            this.m.G().m0(c14697iL2.I0());
            this.m.G().j0(c14697iL2.I0());
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 k1(final int i) {
        return this.m.E().X1().a(i).H(new InterfaceC17569nB2() { // from class: ir.nasim.qN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.C1(i, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.rN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.D1((GroupsOuterClass$ResponseFetchGroupAdmins) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(C14697iL2 c14697iL2, List list, Misc$ResponseVoid misc$ResponseVoid) {
        this.m.E().X1().e(c14697iL2.L(list));
    }

    private C6517Nv5 l1(final int i, final BytesValue bytesValue, final int i2) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final C24878zM2 c24878zM2 = new C24878zM2(new ArrayList(), BytesValue.getDefaultInstance());
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.YM2
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.J1(i, i2, bytesValue, c24878zM2, arrayList, arrayList2, c7234Qv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l2(Exception exc) {
        C19406qI3.b("GroupRouter", "setGroupAvailableReactions: " + exc.fillInStackTrace());
    }

    private C16342l66 m1() {
        return this.m.G().T0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(int i, final List list, final C14697iL2 c14697iL2) {
        if (c14697iL2 != null) {
            L(new C22871vx5("/bale.groups.v1.Groups/SetAvailableReactions", (GroupsOuterClass$RequestSetAvailableReactions) GroupsOuterClass$RequestSetAvailableReactions.newBuilder().B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i).a()).A(list).a(), Misc$ResponseVoid.getDefaultInstance())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.uN2
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.k2(c14697iL2, list, (Misc$ResponseVoid) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.vN2
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    RN2.l2((Exception) obj);
                }
            });
            return;
        }
        C19406qI3.b("GroupRouter", "setGroupAvailableReactions: group(" + i + ") was null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(List list, C7234Qv5 c7234Qv5) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C14697iL2((C23464wy) it.next(), null));
        }
        this.m.E().X1().c(arrayList);
        c7234Qv5.b(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(C14505i18 c14505i18, Exception exc) {
        this.o = false;
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C14697iL2 c14697iL2 = (C14697iL2) it.next();
            if (c14697iL2.q0() == ZN2.GROUP) {
                arrayList.add(c14697iL2.T(null).S(null, this.m.i0()));
            }
        }
        this.m.E().X1().c(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List q1(HashMap map, Boolean bool, List list) {
        ArrayList arrayList = new ArrayList();
        for (C25238zy c25238zy : map.keySet()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    arrayList.add(c25238zy);
                    break;
                }
                C14697iL2 c14697iL2 = (C14697iL2) it.next();
                if (c14697iL2.p0() != c25238zy.q() || (!c14697iL2.H0() && !bool.booleanValue())) {
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1(List list, Exception exc) {
        this.o = false;
        w();
    }

    private C6517Nv5 r2(int i) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.bN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.P1((C14697iL2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 s1(Exception exc) {
        return C6517Nv5.l0(null);
    }

    private C6517Nv5 s2(final int i, final C7714Sx c7714Sx) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.hN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.Q1(c7714Sx, i, (C14697iL2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 t1(InterfaceC17569nB2 interfaceC17569nB2, C14697iL2 c14697iL2) {
        return c14697iL2 != null ? (C6517Nv5) interfaceC17569nB2.apply(c14697iL2) : C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(C14505i18 c14505i18) {
        this.o = false;
        w();
    }

    private C6517Nv5 u2(C14697iL2 c14697iL2) {
        return m1().t(c14697iL2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 v1(int i, C14697iL2 c14697iL2) {
        return L(new C22871vx5("/bale.groups.v1.Groups/LoadMembers", GroupsOuterClass$RequestLoadMembers.newBuilder().B(PeersStruct$GroupOutPeer.newBuilder().B(i).A(c14697iL2.getAccessHash())).C(100).A((GroupsStruct$LoadMembersCondition) GroupsStruct$LoadMembersCondition.newBuilder().A((BoolValue) BoolValue.newBuilder().A(true).a()).a()).D(BytesValue.getDefaultInstance()).a(), GroupsOuterClass$ResponseLoadMembers.getDefaultInstance()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v2, reason: merged with bridge method [inline-methods] */
    public C6517Nv5 Z1(C14697iL2 c14697iL2, int i, long j, int i2, long j2, Integer num, boolean z) {
        AbstractC17457n0 c25178zr6;
        int iF;
        this.m.E().X1().e(c14697iL2.w(this.m.i0(), i2, j2, this.m.i0() == c14697iL2.w0()).V(true));
        int iIntValue = num != null ? num.intValue() : 0;
        OK okC = this.m.T().C();
        C6937Pp6 c6937Pp6E = C6937Pp6.y().E(okC);
        c6937Pp6E.q(i, c14697iL2.getAccessHash(), new byte[0]);
        c6937Pp6E.D(i, iIntValue);
        okC.e(new C9863ah0(4L, c6937Pp6E.toByteArray()));
        if (i2 == this.m.i0()) {
            return m1().x(c14697iL2.I0(), new J44(j, j2, j2, i2, EnumC23558x74.UNKNOWN, new C20941sr6()));
        }
        AbstractC17457n0 c24584yr6 = new C24584yr6(this.m.i0());
        if (z) {
            iF = AbstractC5969Lp4.f();
            c25178zr6 = new C25178zr6();
        } else {
            c25178zr6 = c24584yr6;
            iF = i2;
        }
        return m1().x(c14697iL2.I0(), new J44(j, j2, j2, iF, EnumC23558x74.SENT, c25178zr6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 w1(List list, ArrayList arrayList, GroupsOuterClass$ResponseLoadMembers groupsOuterClass$ResponseLoadMembers) {
        for (GroupsStruct$Member groupsStruct$Member : groupsOuterClass$ResponseLoadMembers.getMembersList()) {
            C23104wM2 c23104wM2 = new C23104wM2(groupsStruct$Member.getUid(), groupsStruct$Member.getInviterUid(), groupsStruct$Member.getDate(), groupsStruct$Member.getIsAdmin().getValue(), Integer.valueOf(groupsStruct$Member.getPromoterUserId().getValue()), groupsStruct$Member.hasTitle() ? groupsStruct$Member.getTitle().getValue() : null);
            DA daK0 = C18732p92.K0(groupsStruct$Member.getPermissions());
            if (groupsStruct$Member.getPermissions() != null && daK0 != null) {
                c23104wM2.k(C18732p92.t(daK0));
            }
            list.add(c23104wM2);
            arrayList.add(Integer.valueOf(groupsStruct$Member.getUid()));
        }
        return AbstractC5969Lp4.d().V0(arrayList);
    }

    private C6517Nv5 w2(final int i, final int i2) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.XM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.S1(i2, i, (C14697iL2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 x1(List list, C21231tK7 c21231tK7) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C23104wM2 c23104wM2 = (C23104wM2) it.next();
            if (c23104wM2.f() == c21231tK7.o()) {
                c23104wM2.l(c21231tK7);
                return C6517Nv5.l0(c23104wM2);
            }
        }
        return C6517Nv5.F(new Exception("Not Found GroupMember"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y1(ArrayList arrayList, final List list, C7234Qv5 c7234Qv5, C14505i18 c14505i18) {
        C6517Nv5 c6517Nv5M = AbstractC5969Lp4.d().k0().l(arrayList).I(new InterfaceC17569nB2() { // from class: ir.nasim.KN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.x1(list, (C21231tK7) obj);
            }
        }).M();
        Objects.requireNonNull(c7234Qv5);
        c6517Nv5M.m0(new LN2(c7234Qv5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z1(final int i, final List list, final ArrayList arrayList, final C7234Qv5 c7234Qv5) {
        this.m.E().X1().a(i).H(new InterfaceC17569nB2() { // from class: ir.nasim.EN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.v1(i, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.FN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.w1(list, arrayList, (GroupsOuterClass$ResponseLoadMembers) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.GN2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                RN2.y1(arrayList, list, c7234Qv5, (C14505i18) obj);
            }
        });
    }

    private C6517Nv5 z2(final int i, final int i2, final boolean z) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.nN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.V1(i2, z, i, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 B2(int i, final List list) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.mN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.X1(list, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 C2(final int i, final long j, final int i2, final long j2, final Integer num, final boolean z) {
        return j1(i).H(new InterfaceC17569nB2() { // from class: ir.nasim.RM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.Y1(i2, (C14505i18) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.SM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.a2(i, j, i2, j2, num, z, (C14505i18) obj);
            }
        }).G(new InterfaceC17569nB2() { // from class: ir.nasim.TM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return RN2.b2((Exception) obj);
            }
        });
    }

    public C6517Nv5 D2(int i, final String str) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.aN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.c2(str, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 E2(int i, final C25247zz c25247zz) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.iN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.d2(c25247zz, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 F2(int i, final MessageIdentifier messageIdentifier) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.VM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.e2(messageIdentifier, (C14697iL2) obj);
            }
        });
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (obj instanceof C15160j66) {
            if (!this.o) {
                return H2(((C15160j66) obj).a());
            }
            t();
            return null;
        }
        if (obj instanceof P56) {
            if (!this.o) {
                return d1(((P56) obj).a());
            }
            t();
            return null;
        }
        if (obj instanceof X56) {
            if (this.o) {
                t();
                return null;
            }
            X56 x56 = (X56) obj;
            return f1(x56.a(), x56.b());
        }
        if (obj instanceof Z56) {
            return h1(((Z56) obj).a());
        }
        if (obj instanceof C12142e66) {
            return k1(((C12142e66) obj).a());
        }
        if (obj instanceof C10119b66) {
            return i1(((C10119b66) obj).a());
        }
        if (!(obj instanceof C12733f66)) {
            return obj instanceof C10735c66 ? j1(((C10735c66) obj).a()) : super.G(obj);
        }
        C12733f66 c12733f66 = (C12733f66) obj;
        return l1(c12733f66.a(), c12733f66.b(), c12733f66.c());
    }

    public C6517Nv5 G2(int i, final long j, final int i2, final String str, final long j2) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.cN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.g2(str, j, j2, i2, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 I2(int i, final long j, final int i2, final int i3, final long j2, final boolean z) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.WM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.h2(i2, i3, j2, z, j, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 J2(final int i, final long j, final int i2, final int i3, final long j2) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.dN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.i2(i2, i, i3, j, j2, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 K2(final int i, final long j, final int i2, final long j2) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.UM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.j2(i2, i, j, j2, (C14697iL2) obj);
            }
        });
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof S56) {
            e1();
        } else if (!(obj instanceof C24730z66)) {
            super.m(obj);
        } else {
            C24730z66 c24730z66 = (C24730z66) obj;
            L2(c24730z66.a(), c24730z66.b());
        }
    }

    public C6517Nv5 n2(int i, final String str) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.xN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.K1(str, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 o2(final int i, final EnumC6364Nh enumC6364Nh) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.pN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.L1(enumC6364Nh, i, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 p2(int i, final long j, final int i2, final C6984Pv c6984Pv, final long j2) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.lN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.N1(c6984Pv, j, j2, i2, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 q2(int i, final String str, final String str2) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.MN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.O1(str, str2, (C14697iL2) obj);
            }
        });
    }

    public C6517Nv5 t2(C25238zy c25238zy, final DA da) {
        return c25238zy != null ? g1(c25238zy.q(), new InterfaceC17569nB2() { // from class: ir.nasim.QN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.R1(da, (C14697iL2) obj);
            }
        }) : C6517Nv5.l0(C14505i18.a);
    }

    public C6517Nv5 x2(int i, final DA da, int i2) {
        return i2 == this.m.i0() ? g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.gN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.T1(da, (C14697iL2) obj);
            }
        }) : C6517Nv5.l0(C14505i18.a);
    }

    public C6517Nv5 y2(int i, final W06 w06) {
        return g1(i, new InterfaceC17569nB2() { // from class: ir.nasim.oN2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.U1(w06, (C14697iL2) obj);
            }
        });
    }
}
