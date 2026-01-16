package ir.nasim;

import ai.bale.proto.Misc$ResponseSeq;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.UsersOuterClass$RequestAddContact;
import ai.bale.proto.UsersOuterClass$RequestRemoveContact;
import ai.bale.proto.UsersOuterClass$RequestSearchContacts;
import ai.bale.proto.UsersOuterClass$ResponseSearchContacts;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C5210Ij1;
import ir.nasim.core.network.RpcInternalException;
import ir.nasim.database.entity.ContactEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ui1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8054Ui1 extends AbstractC21707u0 {
    private final C9057Yh4 b;
    private final DB3 c;
    private C6859Ph0 d;
    private C7052Qb3 e;
    private C9528a7 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8054Ui1(C9057Yh4 c9057Yh4, DB3 db3) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(db3, ContactEntity.TABLE_NAME);
        this.b = c9057Yh4;
        this.c = db3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 A0(C8054Ui1 c8054Ui1) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        return new C6620Oh0(c8054Ui1.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 B0(C8054Ui1 c8054Ui1) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        return new C6808Pb3(c8054Ui1.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(final C8054Ui1 c8054Ui1, final int i, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "callback");
        C17637nI7 c17637nI7 = (C17637nI7) c8054Ui1.b.W().p0().d(i);
        if (c17637nI7 == null) {
            c8054Ui1.z(new Runnable() { // from class: ir.nasim.Mi1
                @Override // java.lang.Runnable
                public final void run() {
                    C8054Ui1.W(interfaceC15419jZ0, i);
                }
            });
            return;
        }
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestAddContact.newBuilder().B(i).A(c17637nI7.getAccessHash()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        c8054Ui1.x(new C22871vx5("/bale.users.v1.Users/AddContact", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Ni1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C8054Ui1.X(this.a, interfaceC15419jZ0, (Misc$ResponseSeq) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Oi1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C8054Ui1.Z(this.a, interfaceC15419jZ0, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(InterfaceC15419jZ0 interfaceC15419jZ0, int i) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.onError(new Exception("User with uid{" + i + "} not found"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(C8054Ui1 c8054Ui1, final InterfaceC15419jZ0 interfaceC15419jZ0, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        c8054Ui1.z(new Runnable() { // from class: ir.nasim.Ci1
            @Override // java.lang.Runnable
            public final void run() {
                C8054Ui1.Y(interfaceC15419jZ0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(InterfaceC15419jZ0 interfaceC15419jZ0) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.a(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(C8054Ui1 c8054Ui1, final InterfaceC15419jZ0 interfaceC15419jZ0, final Exception exc) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        c8054Ui1.z(new Runnable() { // from class: ir.nasim.Ti1
            @Override // java.lang.Runnable
            public final void run() {
                C8054Ui1.a0(interfaceC15419jZ0, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(InterfaceC15419jZ0 interfaceC15419jZ0, Exception exc) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.onError(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 e0(C8054Ui1 c8054Ui1, UsersOuterClass$ResponseSearchContacts usersOuterClass$ResponseSearchContacts) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(usersOuterClass$ResponseSearchContacts, "responseSearchContacts");
        List<PeersStruct$GroupOutPeer> groupPeersList = usersOuterClass$ResponseSearchContacts.getGroupPeersList();
        AbstractC13042fc3.h(groupPeersList, "getGroupPeersList(...)");
        List<PeersStruct$GroupOutPeer> list = groupPeersList;
        final ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$GroupOutPeer peersStruct$GroupOutPeer : list) {
            C18732p92 c18732p92 = C18732p92.a;
            AbstractC13042fc3.f(peersStruct$GroupOutPeer);
            arrayList.add(c18732p92.q1(peersStruct$GroupOutPeer));
        }
        return c8054Ui1.b.V().t0(AbstractC10360bX0.m(), arrayList, true).H(new InterfaceC17569nB2() { // from class: ir.nasim.Ki1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C8054Ui1.f0(arrayList, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 f0(List list, C14505i18 c14505i18) {
        AbstractC13042fc3.i(list, "$groupOutPeers");
        return C6517Nv5.l0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14733iO2[] g0(C8054Ui1 c8054Ui1, List list) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(list, "groupPeers");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C14733iO2 c14733iO2 = (C14733iO2) c8054Ui1.b.E().Y1().n(((C25238zy) it.next()).q());
            if (c14733iO2 != null) {
                arrayList.add(c14733iO2);
            }
        }
        return (C14733iO2[]) arrayList.toArray(new C14733iO2[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4382Ew7 i0(C8054Ui1 c8054Ui1, UsersOuterClass$ResponseSearchContacts usersOuterClass$ResponseSearchContacts) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(usersOuterClass$ResponseSearchContacts, "responseSearchContacts1");
        ArrayList arrayList = new ArrayList();
        Iterator<PeersStruct$UserOutPeer> it = usersOuterClass$ResponseSearchContacts.getUserPeersList().iterator();
        while (it.hasNext()) {
            C21231tK7 c21231tK7 = (C21231tK7) c8054Ui1.b.W().o0().n(it.next().getUid());
            if (c21231tK7 != null) {
                arrayList.add(c21231tK7);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<PeersStruct$GroupOutPeer> it2 = usersOuterClass$ResponseSearchContacts.getGroupPeersList().iterator();
        while (it2.hasNext()) {
            C14733iO2 c14733iO2 = (C14733iO2) c8054Ui1.b.E().Y1().n(it2.next().getGroupId());
            if (c14733iO2 != null) {
                arrayList2.add(c14733iO2);
            }
        }
        return new C4382Ew7(arrayList.toArray(new C21231tK7[0]), arrayList2.toArray(new C14733iO2[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 j0(C8054Ui1 c8054Ui1, UsersOuterClass$ResponseSearchContacts usersOuterClass$ResponseSearchContacts) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(usersOuterClass$ResponseSearchContacts, "responseSearchContacts");
        UG7 ug7V = c8054Ui1.b.V();
        List<PeersStruct$UserOutPeer> userPeersList = usersOuterClass$ResponseSearchContacts.getUserPeersList();
        AbstractC13042fc3.h(userPeersList, "getUserPeersList(...)");
        List<PeersStruct$UserOutPeer> list = userPeersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$UserOutPeer peersStruct$UserOutPeer : list) {
            C18732p92 c18732p92 = C18732p92.a;
            AbstractC13042fc3.f(peersStruct$UserOutPeer);
            arrayList.add(c18732p92.w1(peersStruct$UserOutPeer));
        }
        List<PeersStruct$GroupOutPeer> groupPeersList = usersOuterClass$ResponseSearchContacts.getGroupPeersList();
        AbstractC13042fc3.h(groupPeersList, "getGroupPeersList(...)");
        List<PeersStruct$GroupOutPeer> list2 = groupPeersList;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (PeersStruct$GroupOutPeer peersStruct$GroupOutPeer : list2) {
            C18732p92 c18732p922 = C18732p92.a;
            AbstractC13042fc3.f(peersStruct$GroupOutPeer);
            arrayList2.add(c18732p922.q1(peersStruct$GroupOutPeer));
        }
        return ug7V.t0(arrayList, arrayList2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(final C8054Ui1 c8054Ui1, final int i, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "callback");
        C17637nI7 c17637nI7 = (C17637nI7) c8054Ui1.b.W().p0().d(i);
        if (c17637nI7 == null) {
            c8054Ui1.z(new Runnable() { // from class: ir.nasim.Pi1
                @Override // java.lang.Runnable
                public final void run() {
                    C8054Ui1.t0(interfaceC15419jZ0, i);
                }
            });
            return;
        }
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestRemoveContact.newBuilder().B(i).A(c17637nI7.getAccessHash()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        c8054Ui1.x(new C22871vx5("/bale.users.v1.Users/RemoveContact", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Qi1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C8054Ui1.u0(this.a, i, interfaceC15419jZ0, (Misc$ResponseSeq) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Ri1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C8054Ui1.w0(this.a, interfaceC15419jZ0, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(InterfaceC15419jZ0 interfaceC15419jZ0, int i) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.onError(new Exception("User with uid {" + i + "} not found"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(C8054Ui1 c8054Ui1, int i, final InterfaceC15419jZ0 interfaceC15419jZ0, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        c8054Ui1.b.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new C14630iD7(AbstractC9766aX0.e(Integer.valueOf(i))), 0);
        c8054Ui1.z(new Runnable() { // from class: ir.nasim.Bi1
            @Override // java.lang.Runnable
            public final void run() {
                C8054Ui1.v0(interfaceC15419jZ0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(InterfaceC15419jZ0 interfaceC15419jZ0) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.a(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(C8054Ui1 c8054Ui1, final InterfaceC15419jZ0 interfaceC15419jZ0, Exception exc) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        c8054Ui1.z(new Runnable() { // from class: ir.nasim.Si1
            @Override // java.lang.Runnable
            public final void run() {
                C8054Ui1.x0(interfaceC15419jZ0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(InterfaceC15419jZ0 interfaceC15419jZ0) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.onError(new RpcInternalException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 z0(C8054Ui1 c8054Ui1) {
        AbstractC13042fc3.i(c8054Ui1, "this$0");
        return new C5210Ij1(c8054Ui1.b);
    }

    public final C6517Nv5 C0(String str) {
        AbstractC13042fc3.i(str, "query");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestSearchContacts.newBuilder().B(str).A(PC.b).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        UsersOuterClass$ResponseSearchContacts defaultInstance = UsersOuterClass$ResponseSearchContacts.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5X = x(new C22871vx5("/bale.users.v1.Users/SearchContacts", generatedMessageLiteA, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5X, "rpcApi(...)");
        return c6517Nv5X;
    }

    public final InterfaceC14830iZ0 U(final int i) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Li1
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                C8054Ui1.V(this.a, i, interfaceC15419jZ0);
            }
        };
    }

    public final void b0(List list, HashMap map) {
        AbstractC13042fc3.i(list, "apiUsers");
        AbstractC13042fc3.i(map, "phones");
        C7052Qb3 c7052Qb3 = this.e;
        if (c7052Qb3 == null) {
            AbstractC13042fc3.y("internalPhoneBookActorInt");
            c7052Qb3 = null;
        }
        c7052Qb3.j(list, map);
    }

    public final void c0() {
        l0().d(new C5210Ij1.d());
        l0().d(new C5210Ij1.e());
        p0();
        C7052Qb3 c7052Qb3 = this.e;
        if (c7052Qb3 == null) {
            AbstractC13042fc3.y("internalPhoneBookActorInt");
            c7052Qb3 = null;
        }
        c7052Qb3.k();
    }

    public final C6517Nv5 d0(String str) {
        AbstractC13042fc3.i(str, "query");
        C6517Nv5 c6517Nv5H0 = C0(str).H(new InterfaceC17569nB2() { // from class: ir.nasim.Ii1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C8054Ui1.e0(this.a, (UsersOuterClass$ResponseSearchContacts) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Ji1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C8054Ui1.g0(this.a, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C6517Nv5 h0(String str) {
        AbstractC13042fc3.i(str, "query");
        if (str.length() == 0) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception());
            AbstractC13042fc3.h(c6517Nv5F, "failure(...)");
            return c6517Nv5F;
        }
        C6517Nv5 c6517Nv5H0 = C0(str).A(new InterfaceC17569nB2() { // from class: ir.nasim.Gi1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C8054Ui1.j0(this.a, (UsersOuterClass$ResponseSearchContacts) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Hi1
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C8054Ui1.i0(this.a, (UsersOuterClass$ResponseSearchContacts) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C3512Be1 k0(long j) {
        return (C3512Be1) this.c.a(j);
    }

    public final C9528a7 l0() {
        C9528a7 c9528a7 = this.f;
        if (c9528a7 != null) {
            return c9528a7;
        }
        AbstractC13042fc3.y("contactSyncActor");
        return null;
    }

    public final DB3 m0() {
        return this.c;
    }

    public final C19938rB7 n0() {
        l0().d(new C5210Ij1.e());
        return C19938rB7.a;
    }

    public final C6517Nv5 o0(String str, long j) {
        AbstractC13042fc3.i(str, "name");
        C6859Ph0 c6859Ph0 = this.d;
        if (c6859Ph0 == null) {
            AbstractC13042fc3.y("bookImportActorInt");
            c6859Ph0 = null;
        }
        return c6859Ph0.j(str, j);
    }

    public final void p0() {
        C6859Ph0 c6859Ph0 = this.d;
        if (c6859Ph0 == null) {
            AbstractC13042fc3.y("bookImportActorInt");
            c6859Ph0 = null;
        }
        c6859Ph0.k();
    }

    public final void q0() {
        C6859Ph0 c6859Ph0 = this.d;
        if (c6859Ph0 == null) {
            AbstractC13042fc3.y("bookImportActorInt");
            c6859Ph0 = null;
        }
        c6859Ph0.l();
    }

    public final InterfaceC14830iZ0 r0(final int i) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Ai1
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                C8054Ui1.s0(this.a, i, interfaceC15419jZ0);
            }
        };
    }

    public final void y0() {
        this.f = C12736f7.n().g("actor/contacts_sync", C4614Fw5.d(new V6() { // from class: ir.nasim.Di1
            @Override // ir.nasim.V6
            public final K6 create() {
                return C8054Ui1.z0(this.a);
            }
        }).a("D_heavy"), true);
        C9528a7 c9528a7G = C12736f7.n().g("actor/book_import", C4614Fw5.d(new V6() { // from class: ir.nasim.Ei1
            @Override // ir.nasim.V6
            public final K6 create() {
                return C8054Ui1.A0(this.a);
            }
        }).a("D_heavy"), true);
        AbstractC13042fc3.h(c9528a7G, "actorOf(...)");
        this.d = new C6859Ph0(c9528a7G);
        C9528a7 c9528a7G2 = C12736f7.n().g("actor/internal_phone_book", C4614Fw5.d(new V6() { // from class: ir.nasim.Fi1
            @Override // ir.nasim.V6
            public final K6 create() {
                return C8054Ui1.B0(this.a);
            }
        }).a("D_heavy"), true);
        AbstractC13042fc3.h(c9528a7G2, "actorOf(...)");
        this.e = new C7052Qb3(c9528a7G2);
    }
}
