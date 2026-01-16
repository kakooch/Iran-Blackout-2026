package ir.nasim;

import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.UsersOuterClass$RequestGetContacts;
import ai.bale.proto.UsersOuterClass$ResponseGetContacts;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EF2;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ij1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5210Ij1 extends AbstractC6360Ng4 {
    public static final a r = new a(null);
    public static final int s = 8;
    private final C9057Yh4 m;
    private final ArrayList n;
    private boolean o;
    private boolean p;
    private final InterfaceC6118Mg1 q;

    /* renamed from: ir.nasim.Ij1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ij1$b */
    public static final class b {
        private final int[] a;
        private final HashMap b;

        public b(int[] iArr, HashMap map) {
            AbstractC13042fc3.i(iArr, "uids");
            AbstractC13042fc3.i(map, "phones");
            this.a = iArr;
            this.b = map;
        }

        public final HashMap a() {
            return this.b;
        }

        public final int[] b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Ij1$c */
    public static final class c {
        private final int[] a;

        public c(int[] iArr) {
            AbstractC13042fc3.i(iArr, "uids");
            this.a = iArr;
        }

        public final int[] a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Ij1$d */
    public static final class d {
    }

    /* renamed from: ir.nasim.Ij1$e */
    public static final class e {
    }

    /* renamed from: ir.nasim.Ij1$f */
    public static final class f {
        private final C17637nI7 a;

        public f(C17637nI7 c17637nI7) {
            AbstractC13042fc3.i(c17637nI7, "user");
            this.a = c17637nI7;
        }

        public final C17637nI7 a() {
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5210Ij1(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = new ArrayList();
        b0("sequences_synced");
        this.q = ((InterfaceC13191fo5) I22.a(C5721Ko.a.d(), InterfaceC13191fo5.class)).o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A0(C17637nI7 c17637nI7, C17637nI7 c17637nI72) {
        AbstractC13042fc3.i(c17637nI7, "lhs");
        AbstractC13042fc3.i(c17637nI72, "rhs");
        String name = c17637nI7.getName();
        String name2 = c17637nI72.getName();
        AbstractC13042fc3.h(name2, "getName(...)");
        return name.compareTo(name2);
    }

    private final void B0(ArrayList arrayList) {
        C8512Wh0 c8512Wh0Z;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            C18766pD c18766pD = (C18766pD) next;
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(c18766pD.q());
            if (c17637nI7 != null) {
                arrayList2.add(c17637nI7);
            }
            C21231tK7 c21231tK7 = (C21231tK7) this.m.W().o0().n(c18766pD.q());
            if (c21231tK7 != null && (c8512Wh0Z = c21231tK7.z()) != null) {
                c8512Wh0Z.i(Boolean.TRUE);
            }
        }
        if (!arrayList2.isEmpty()) {
            this.m.G().T0().G(arrayList2);
        }
    }

    private final void k0(HashSet hashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            int iIntValue = ((Number) next).intValue();
            if (!this.n.contains(Integer.valueOf(iIntValue))) {
                this.n.add(Integer.valueOf(iIntValue));
                arrayList.add(Long.valueOf(iIntValue));
            }
        }
        List listF = this.m.W().p0().f(arrayList);
        int size = listF.size();
        for (int i = 0; i < size; i++) {
            listF.set(i, ((C17637nI7) listF.get(i)).N(true));
        }
        this.m.W().p0().c(listF);
        x0();
        W().g("contacts_loaded", true);
        this.o = false;
        y0();
        this.m.v().M(EF2.d.a);
    }

    private final void m0() {
        this.m.v().K(this.m.A().m0().isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 o0(C5210Ij1 c5210Ij1, ArrayList arrayList, HashMap map, List list) {
        AbstractC13042fc3.i(c5210Ij1, "this$0");
        AbstractC13042fc3.i(arrayList, "$arrayOfOutPeer");
        AbstractC13042fc3.i(map, "$phones");
        AbstractC13042fc3.i(list, "apiUsers");
        c5210Ij1.B0(arrayList);
        c5210Ij1.x0();
        c5210Ij1.y0();
        c5210Ij1.m.A().b0(list, map);
        return C6517Nv5.l0(list);
    }

    private final void p0(int[] iArr) {
        for (int i : iArr) {
            this.n.remove(Integer.valueOf(i));
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(i);
            if (c17637nI7 != null) {
                this.m.W().p0().e(c17637nI7.N(false));
            }
        }
        x0();
        y0();
    }

    private final void q0(UsersOuterClass$ResponseGetContacts usersOuterClass$ResponseGetContacts) {
        this.m.v().J();
        if (usersOuterClass$ResponseGetContacts.getIsNotChanged()) {
            C19406qI3.a("ContactsSyncActor", "Sync: Not changed", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        final HashSet hashSet = new HashSet();
        List<PeersStruct$UserOutPeer> userPeersList = usersOuterClass$ResponseGetContacts.getUserPeersList();
        AbstractC13042fc3.h(userPeersList, "getUserPeersList(...)");
        List<PeersStruct$UserOutPeer> list = userPeersList;
        ArrayList<C18766pD> arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$UserOutPeer peersStruct$UserOutPeer : list) {
            C18732p92 c18732p92 = C18732p92.a;
            AbstractC13042fc3.f(peersStruct$UserOutPeer);
            arrayList2.add(c18732p92.w1(peersStruct$UserOutPeer));
        }
        for (C18766pD c18766pD : arrayList2) {
            hashSet.add(Integer.valueOf(c18766pD.q()));
            arrayList.add(c18766pD);
        }
        this.m.V().s0(arrayList, new ArrayList()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Gj1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C5210Ij1.r0(this.a, hashSet, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Hj1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C5210Ij1.s0(this.a, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(C5210Ij1 c5210Ij1, HashSet hashSet, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c5210Ij1, "this$0");
        AbstractC13042fc3.i(hashSet, "$uids");
        c5210Ij1.k0(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(C5210Ij1 c5210Ij1, Exception exc) {
        AbstractC13042fc3.i(c5210Ij1, "this$0");
        AbstractC13042fc3.i(exc, "e");
        C19406qI3.a("ContactsSyncActor", "loadRequiredPeers failure", new Object[0]);
        c5210Ij1.W().g("contacts_loaded", false);
        c5210Ij1.m.v().M(new EF2.a(exc));
        c5210Ij1.o = false;
    }

    private final void u0() {
        C19406qI3.a("ContactsSyncActor", "Checking sync", new Object[0]);
        if (this.o) {
            C19406qI3.a("ContactsSyncActor", "Sync in progress, invalidating current sync", new Object[0]);
            return;
        }
        boolean zH = W().h("contacts_loaded", false);
        C19406qI3.a("ContactsSyncActor", "contactsLoaded value : " + zH, new Object[0]);
        if (zH) {
            this.m.v().M(EF2.d.a);
            return;
        }
        this.o = true;
        this.m.v().M(EF2.c.a);
        C19406qI3.a("ContactsSyncActor", "Starting sync", new Object[0]);
        Integer[] numArr = (Integer[]) this.n.toArray(new Integer[0]);
        Arrays.sort(numArr);
        StringBuilder sb = new StringBuilder();
        for (Integer num : numArr) {
            int iIntValue = num.intValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(iIntValue);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        Charset charset = StandardCharsets.UTF_8;
        AbstractC13042fc3.h(charset, "UTF_8");
        byte[] bytes = string.getBytes(charset);
        AbstractC13042fc3.h(bytes, "getBytes(...)");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestGetContacts.newBuilder().A(PC.b).B(AbstractC7464Rv1.i(AbstractC7464Rv1.f(bytes))).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        UsersOuterClass$ResponseGetContacts defaultInstance = UsersOuterClass$ResponseGetContacts.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        M(new C22871vx5("/bale.users.v1.Users/GetContacts", generatedMessageLiteA, defaultInstance), 15000L).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Bj1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C5210Ij1.v0(this.a, (UsersOuterClass$ResponseGetContacts) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Cj1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C5210Ij1.w0(this.a, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(C5210Ij1 c5210Ij1, UsersOuterClass$ResponseGetContacts usersOuterClass$ResponseGetContacts) {
        AbstractC13042fc3.i(c5210Ij1, "this$0");
        AbstractC13042fc3.f(usersOuterClass$ResponseGetContacts);
        c5210Ij1.q0(usersOuterClass$ResponseGetContacts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(C5210Ij1 c5210Ij1, Exception exc) {
        AbstractC13042fc3.i(c5210Ij1, "this$0");
        AbstractC13042fc3.i(exc, "e");
        c5210Ij1.m.v().M(new EF2.a(exc));
        c5210Ij1.o = false;
    }

    private final void x0() {
        C12658ez1 c12658ez1 = new C12658ez1();
        c12658ez1.h(this.n.size());
        Iterator it = this.n.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            c12658ez1.h(((Number) next).intValue());
        }
        C19406qI3.a(InterfaceC6118Mg1.a.a(), "SAVE_LIST", new Object[0]);
        W().f("contact_list", c12658ez1.c());
    }

    private final void y0() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.n.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            AbstractC13042fc3.h(it.next(), "next(...)");
            arrayList.add(Long.valueOf(((Number) r2).intValue()));
        }
        List<C17637nI7> listF = this.m.W().p0().f(arrayList);
        int i = 0;
        if (listF.size() == 0 && !this.m.A().m0().isEmpty()) {
            this.m.A().m0().l(false);
            this.q.b();
            return;
        }
        AbstractC13042fc3.f(listF);
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.Ej1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(C5210Ij1.A0((C17637nI7) obj, (C17637nI7) obj2));
            }
        };
        AbstractC12992fX0.B(listF, new Comparator() { // from class: ir.nasim.Fj1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C5210Ij1.z0(interfaceC14603iB2, obj, obj2);
            }
        });
        ArrayList arrayList2 = new ArrayList();
        int i2 = -1;
        for (C17637nI7 c17637nI7 : listF) {
            arrayList2.add(new C3512Be1(c17637nI7.n0(), i2, c17637nI7.S(), c17637nI7.getName(), c17637nI7.p0()));
            i2--;
        }
        this.m.A().m0().s(arrayList2);
        this.q.e(arrayList2);
        int[] iArr = new int[this.n.size()];
        Iterator it2 = listF.iterator();
        while (it2.hasNext()) {
            iArr[i] = ((C17637nI7) it2.next()).n0();
            i++;
        }
        this.m.Q().N(iArr);
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int z0(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        l0();
        u0();
    }

    public final void l0() {
        if (this.p) {
            return;
        }
        if (!this.n.isEmpty()) {
            this.n.clear();
        }
        byte[] bArrB = W().b("contact_list");
        if (bArrB != null) {
            try {
                C9207Yy1 c9207Yy1 = new C9207Yy1(bArrB, 0, bArrB.length);
                int iD = c9207Yy1.d();
                for (int i = 0; i < iD; i++) {
                    int iD2 = c9207Yy1.d();
                    if (!this.n.contains(Integer.valueOf(iD2))) {
                        this.n.add(Integer.valueOf(iD2));
                    }
                }
            } catch (IOException e2) {
                C19406qI3.c("ContactsSyncActor", "initSync", e2);
            }
        }
        this.p = true;
        m0();
        w();
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof d) {
            l0();
            return;
        }
        if (obj instanceof C11963dq6) {
            V();
            return;
        }
        if (!this.p) {
            t();
            return;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            n0(bVar.b(), bVar.a());
        } else {
            if (obj instanceof c) {
                p0(((c) obj).a());
                return;
            }
            if (obj instanceof f) {
                t0(((f) obj).a());
            } else if (obj instanceof e) {
                u0();
            } else {
                super.m(obj);
            }
        }
    }

    public final void n0(int[] iArr, final HashMap map) {
        AbstractC13042fc3.i(iArr, "uids");
        AbstractC13042fc3.i(map, "phones");
        this.m.v().H(new C16110kj1(null, false, false, false, false, 31, null).i());
        final ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(i);
            if (c17637nI7 == null) {
                arrayList.add(new C18766pD(i, 0L));
            } else if (c17637nI7.n0() != C5735Kp4.w().i().X0()) {
                arrayList.add(new C18766pD(c17637nI7.n0(), c17637nI7.getAccessHash()));
            }
            if (!this.n.contains(Integer.valueOf(i))) {
                this.n.add(Integer.valueOf(i));
            }
        }
        if (!arrayList.isEmpty()) {
            this.m.V().Y(arrayList).H(new InterfaceC17569nB2() { // from class: ir.nasim.Dj1
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C5210Ij1.o0(this.a, arrayList, map, (List) obj);
                }
            });
        } else {
            x0();
            y0();
        }
    }

    public final void t0(C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c17637nI7, "user");
        if (this.n.contains(Integer.valueOf(c17637nI7.n0()))) {
            y0();
        }
    }
}
