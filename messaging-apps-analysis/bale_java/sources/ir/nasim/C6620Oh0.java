package ir.nasim;

import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.UsersOuterClass$RequestImportContacts;
import ai.bale.proto.UsersOuterClass$ResponseImportContacts;
import ai.bale.proto.UsersStruct$PhoneToImport;
import ai.bale.proto.UsersStruct$User;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Oh0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6620Oh0 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;
    private boolean n;
    private boolean o;
    private final ArrayList p;
    private C7103Qh0 q;

    /* renamed from: ir.nasim.Oh0$a */
    public static final class a {
    }

    /* renamed from: ir.nasim.Oh0$b */
    public static final class b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6620Oh0(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.p = new ArrayList();
        this.q = new C7103Qh0();
        b0("sequences_synced");
    }

    private final C6517Nv5 h0(String str, long j) {
        UsersOuterClass$RequestImportContacts usersOuterClass$RequestImportContacts = (UsersOuterClass$RequestImportContacts) UsersOuterClass$RequestImportContacts.newBuilder().B((UsersStruct$PhoneToImport) UsersStruct$PhoneToImport.newBuilder().B(j).A(StringValue.of(str)).a()).A(PC.b).a();
        AbstractC13042fc3.f(usersOuterClass$RequestImportContacts);
        UsersOuterClass$ResponseImportContacts defaultInstance = UsersOuterClass$ResponseImportContacts.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.users.v1.Users/ImportContacts", usersOuterClass$RequestImportContacts, defaultInstance)).A(new InterfaceC17569nB2() { // from class: ir.nasim.Kh0
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C6620Oh0.i0(this.a, (UsersOuterClass$ResponseImportContacts) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Lh0
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C6620Oh0.j0((UsersOuterClass$ResponseImportContacts) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 i0(C6620Oh0 c6620Oh0, UsersOuterClass$ResponseImportContacts usersOuterClass$ResponseImportContacts) {
        AbstractC13042fc3.i(c6620Oh0, "this$0");
        AbstractC13042fc3.i(usersOuterClass$ResponseImportContacts, "response");
        List<PeersStruct$UserOutPeer> userPeersList = usersOuterClass$ResponseImportContacts.getUserPeersList();
        AbstractC13042fc3.h(userPeersList, "getUserPeersList(...)");
        List<PeersStruct$UserOutPeer> list = userPeersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$UserOutPeer peersStruct$UserOutPeer : list) {
            arrayList.add(new C18766pD(peersStruct$UserOutPeer.getUid(), peersStruct$UserOutPeer.getAccessHash()));
        }
        return c6620Oh0.m.V().t0(arrayList, new ArrayList(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer j0(UsersOuterClass$ResponseImportContacts usersOuterClass$ResponseImportContacts) {
        AbstractC13042fc3.i(usersOuterClass$ResponseImportContacts, "response");
        List<PeersStruct$UserOutPeer> userPeersList = usersOuterClass$ResponseImportContacts.getUserPeersList();
        AbstractC13042fc3.f(userPeersList);
        if (!userPeersList.isEmpty()) {
            return Integer.valueOf(userPeersList.get(0).getUid());
        }
        return null;
    }

    private final void k0(List list) {
        C19406qI3.j("stashHandler", "onPhoneBookLoaded: Book load completed", new Object[0]);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            L75 l75 = (L75) it.next();
            Iterator it2 = l75.q().iterator();
            while (it2.hasNext()) {
                C16910m43 c16910m43 = new C16910m43(((O75) it2.next()).q(), l75.getName());
                arrayList.add(c16910m43);
                if (!this.q.r(c16910m43)) {
                    this.p.add(c16910m43);
                    i++;
                }
            }
        }
        if (i == 0) {
            C19406qI3.j("stashHandler", "No new contacts found", new Object[0]);
        } else {
            C19406qI3.j("stashHandler", "Founded new " + i + " contact records", new Object[0]);
        }
        l0(arrayList);
    }

    private final void l0(final List list) {
        C19406qI3.j("stashHandler", "performImportIfRequired called", new Object[0]);
        if (this.o) {
            C19406qI3.j("stashHandler", "performImportIfRequired:exiting:already importing", new Object[0]);
            return;
        }
        if (this.p.size() == 0) {
            C19406qI3.j("stashHandler", "performImportIfRequired:exiting:nothing to import", new Object[0]);
            this.n = false;
            this.m.v().H(new C16110kj1(null, false, false, false, false, 31, null).g());
            this.m.v().I();
            ArrayList arrayList = new ArrayList();
            Iterator it = this.q.q().iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            while (it.hasNext()) {
                C16910m43 c16910m43 = (C16910m43) it.next();
                if (!list.contains(c16910m43)) {
                    AbstractC13042fc3.f(c16910m43);
                    arrayList.add(c16910m43);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.q.u((C16910m43) it2.next());
            }
            this.m.T().C().e(new C9863ah0(16L, this.q.toByteArray()));
            return;
        }
        this.o = true;
        ArrayList<RA> arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < 50 && this.p.size() > 0; i++) {
            Object objRemove = this.p.remove(0);
            AbstractC13042fc3.h(objRemove, "removeAt(...)");
            C16910m43 c16910m432 = (C16910m43) objRemove;
            arrayList2.add(new RA(c16910m432.q(), c16910m432.getName()));
            arrayList3.add(c16910m432);
        }
        UsersOuterClass$RequestImportContacts.b bVarNewBuilder = UsersOuterClass$RequestImportContacts.newBuilder();
        for (RA ra : arrayList2) {
            bVarNewBuilder.B((UsersStruct$PhoneToImport) UsersStruct$PhoneToImport.newBuilder().B(ra.q()).A(StringValue.of(ra.getName())).a());
        }
        bVarNewBuilder.A(PC.b);
        GeneratedMessageLite generatedMessageLiteA = bVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        UsersOuterClass$ResponseImportContacts defaultInstance = UsersOuterClass$ResponseImportContacts.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.users.v1.Users/ImportContacts", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Mh0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6620Oh0.m0(arrayList3, this, list, (UsersOuterClass$ResponseImportContacts) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Nh0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6620Oh0.n0(this.a, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(List list, C6620Oh0 c6620Oh0, List list2, UsersOuterClass$ResponseImportContacts usersOuterClass$ResponseImportContacts) {
        AbstractC13042fc3.i(list, "$importItems");
        AbstractC13042fc3.i(c6620Oh0, "this$0");
        AbstractC13042fc3.i(list2, "$phoneBookPhones");
        AbstractC13042fc3.i(usersOuterClass$ResponseImportContacts, "response");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C16910m43 c16910m43 = (C16910m43) it.next();
            c6620Oh0.q.s(c16910m43);
            c6620Oh0.p.remove(c16910m43);
        }
        c6620Oh0.m.T().C().e(new C9863ah0(16L, c6620Oh0.q.toByteArray()));
        if (usersOuterClass$ResponseImportContacts.getUserPeersCount() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<PeersStruct$UserOutPeer> it2 = usersOuterClass$ResponseImportContacts.getUserPeersList().iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(it2.next().getUid()));
            }
            C19406qI3.j("stashHandler", "Import success with " + usersOuterClass$ResponseImportContacts.getUserPeersCount() + " new contacts (userPeers)", new Object[0]);
        } else if (usersOuterClass$ResponseImportContacts.getUsersCount() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<UsersStruct$User> it3 = usersOuterClass$ResponseImportContacts.getUsersList().iterator();
            while (it3.hasNext()) {
                arrayList2.add(Integer.valueOf(it3.next().getId()));
            }
            C19406qI3.j("stashHandler", "Import success with " + usersOuterClass$ResponseImportContacts.getUsersCount() + " new contacts (users)", new Object[0]);
        } else {
            C19406qI3.j("stashHandler", "Import success, but no new contacts found", new Object[0]);
        }
        c6620Oh0.o = false;
        c6620Oh0.l0(list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(C6620Oh0 c6620Oh0, Exception exc) {
        AbstractC13042fc3.i(c6620Oh0, "this$0");
        AbstractC13042fc3.i(exc, "e");
        C19406qI3.j("stashHandler", "Import failure : " + exc.getMessage(), new Object[0]);
        c6620Oh0.o = false;
        c6620Oh0.n = false;
        c6620Oh0.m.v().H(new C16110kj1(null, false, false, false, false, 31, null).h(exc));
    }

    private final void o0() {
        if (!C21753u45.S(C5721Ko.a.d())) {
            C19406qI3.j("stashHandler", "No permission to sync contacts", new Object[0]);
            return;
        }
        if (this.n) {
            C19406qI3.j("stashHandler", "Sync ContactsImport in progress", new Object[0]);
            return;
        }
        if (!C15542jl4.a.a()) {
            C19406qI3.a("stashHandler", "return because sync is off.", new Object[0]);
            return;
        }
        this.n = true;
        C9863ah0 c9863ah0 = (C9863ah0) this.m.T().C().n(16L);
        if (c9863ah0 != null) {
            try {
                this.q = new C7103Qh0(c9863ah0.q());
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Exception e) {
                e.getLocalizedMessage();
            }
        } else {
            this.m.v().H(new C16110kj1(null, false, false, false, false, 31, null).j());
        }
        C19406qI3.a("stashHandler", "performSync: Starting book loading...", new Object[0]);
        k0(this.m.z().b().a());
    }

    private final void p0() {
        this.m.T().C().b(16L);
        this.q = new C7103Qh0();
        o0();
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof C17501n43) {
            C17501n43 c17501n43 = (C17501n43) obj;
            return h0(c17501n43.a(), c17501n43.b());
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.f(c6517Nv5G);
        return c6517Nv5G;
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        o0();
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof a) {
            o0();
        } else if (obj instanceof b) {
            p0();
        } else {
            super.m(obj);
        }
    }
}
