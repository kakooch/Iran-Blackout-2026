package ir.nasim;

import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.FilesStruct$Avatars;
import ai.bale.proto.Misc$ResponseSeq;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.UsersOuterClass$RequestBlockUser;
import ai.bale.proto.UsersOuterClass$RequestEditAbout;
import ai.bale.proto.UsersOuterClass$RequestEditName;
import ai.bale.proto.UsersOuterClass$RequestEditNickName;
import ai.bale.proto.UsersOuterClass$RequestEditUserLocalName;
import ai.bale.proto.UsersOuterClass$RequestLoadAvatars;
import ai.bale.proto.UsersOuterClass$RequestLoadBlockedUsers;
import ai.bale.proto.UsersOuterClass$RequestUnblockUser;
import ai.bale.proto.UsersOuterClass$ResponseLoadAvatars;
import ai.bale.proto.UsersOuterClass$ResponseLoadBlockedUsers;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class OK7 extends AbstractC21707u0 implements InterfaceC3817Cm0 {
    public static final int f = 8;
    private final C9057Yh4 b;
    private final VL3 c;
    private final C17064mK7 d;
    private final InterfaceC8344Vo3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OK7(C9057Yh4 c9057Yh4, VL3 vl3) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(vl3, "users");
        this.b = c9057Yh4;
        this.c = vl3;
        this.d = new C17064mK7(c9057Yh4);
        InterfaceC8344Vo3 interfaceC8344Vo3O = vl3.o();
        AbstractC13042fc3.h(interfaceC8344Vo3O, "getEngine(...)");
        this.e = interfaceC8344Vo3O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List A0(UsersOuterClass$ResponseLoadAvatars usersOuterClass$ResponseLoadAvatars) {
        List<FilesStruct$Avatar> avatarsList;
        AbstractC13042fc3.i(usersOuterClass$ResponseLoadAvatars, "responseLoadAvatars");
        FilesStruct$Avatars avatars = usersOuterClass$ResponseLoadAvatars.getAvatars();
        if (avatars == null || (avatarsList = avatars.getAvatarsList()) == null) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = avatarsList.iterator();
        while (it.hasNext()) {
            C6984Pv c6984PvR = C18732p92.R((FilesStruct$Avatar) it.next());
            if (c6984PvR != null) {
                arrayList.add(c6984PvR);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new Avatar((C6984Pv) it2.next()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 D0(OK7 ok7, C17557nA c17557nA) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(c17557nA, "apiOutPeer");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestUnblockUser.newBuilder().A((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(c17557nA.q()).A(c17557nA.getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return ok7.x(new C22871vx5("/bale.users.v1.Users/UnblockUser", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 E0(OK7 ok7, int i, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(misc$ResponseSeq, "responseSeq");
        return ok7.b.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new C23055wG7(i), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(Exception exc) {
        AbstractC13042fc3.i(exc, "e");
        C19406qI3.d("UserModule", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 V(OK7 ok7, C17557nA c17557nA) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(c17557nA, "apiOutPeer");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestBlockUser.newBuilder().A((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(c17557nA.q()).A(c17557nA.getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return ok7.x(new C22871vx5("/bale.users.v1.Users/BlockUser", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 W(OK7 ok7, int i, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(misc$ResponseSeq, "responseSeq");
        return ok7.b.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new QF7(i), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Y(OK7 ok7, String str, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(str, "$about");
        AbstractC13042fc3.i(misc$ResponseSeq, "responseSeq");
        return ok7.b.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new NF7(ok7.b.i0(), str), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 a0(OK7 ok7, String str, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(str, "$newName");
        AbstractC13042fc3.i(misc$ResponseSeq, "responseSeq");
        return ok7.b.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new C18210oG7(ok7.b.i0(), str), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long c0(C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c17637nI7, "user");
        return Long.valueOf(c17637nI7.getAccessHash());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 d0(OK7 ok7, int i, String str, Long l) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(str, "$name");
        UsersOuterClass$RequestEditUserLocalName.a aVarC = UsersOuterClass$RequestEditUserLocalName.newBuilder().C(i);
        AbstractC13042fc3.f(l);
        GeneratedMessageLite generatedMessageLiteA = aVarC.A(l.longValue()).B(str).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return ok7.x(new C22871vx5("/bale.users.v1.Users/EditUserLocalName", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 e0(OK7 ok7, int i, String str, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(misc$ResponseSeq, "responseSeq");
        return ok7.b.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new C17028mG7(i, str), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 g0(OK7 ok7, String str, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(misc$ResponseSeq, "responseSeq");
        return ok7.b.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new C19392qG7(ok7.b.i0(), str), 0);
    }

    private final C6517Nv5 h0(int i) {
        C6517Nv5 c6517Nv5H0 = r(new C23742xR5(i), 16500).h0(new InterfaceC17569nB2() { // from class: ir.nasim.IK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.i0((KX5) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List i0(KX5 kx5) {
        ArrayList arrayList = new ArrayList();
        C5784Kv c5784KvU = kx5.u();
        if (c5784KvU == null) {
            return arrayList;
        }
        for (AbstractC17566nB abstractC17566nB : c5784KvU.u()) {
            if (abstractC17566nB instanceof OC) {
                String strU = ((OC) abstractC17566nB).u();
                AbstractC13042fc3.h(strU, "getText(...)");
                arrayList.add(strU);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String m0(C18970pZ5 c18970pZ5) {
        AbstractC13042fc3.i(c18970pZ5, "responseGetUserContext");
        return "{\"userId\":" + c18970pZ5.y() + ",\"nonce\": \"" + c18970pZ5.getNonce() + "\" ,\"sign\": \"" + c18970pZ5.w() + "\" ,\"botUserId\":" + c18970pZ5.u() + "}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean r0(String str, List list) {
        AbstractC13042fc3.i(str, "$url");
        AbstractC13042fc3.i(list, "whiteList");
        return Boolean.valueOf(list.contains(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 t0(OK7 ok7, UsersOuterClass$ResponseLoadBlockedUsers usersOuterClass$ResponseLoadBlockedUsers) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(usersOuterClass$ResponseLoadBlockedUsers, "response");
        UG7 ug7V = ok7.b.V();
        List<PeersStruct$UserOutPeer> userPeersList = usersOuterClass$ResponseLoadBlockedUsers.getUserPeersList();
        AbstractC13042fc3.h(userPeersList, "getUserPeersList(...)");
        List<PeersStruct$UserOutPeer> list = userPeersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$UserOutPeer peersStruct$UserOutPeer : list) {
            C18732p92 c18732p92 = C18732p92.a;
            AbstractC13042fc3.f(peersStruct$UserOutPeer);
            arrayList.add(c18732p92.w1(peersStruct$UserOutPeer));
        }
        return ug7V.s0(arrayList, AbstractC10360bX0.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 u0(final OK7 ok7, UsersOuterClass$ResponseLoadBlockedUsers usersOuterClass$ResponseLoadBlockedUsers) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(usersOuterClass$ResponseLoadBlockedUsers, "responseLoadBlockedUsers");
        return C16835lw5.K(usersOuterClass$ResponseLoadBlockedUsers.getUserPeersList()).I(new InterfaceC17569nB2() { // from class: ir.nasim.AK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.v0(this.a, (PeersStruct$UserOutPeer) obj);
            }
        }).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 v0(OK7 ok7, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        AbstractC13042fc3.i(ok7, "this$0");
        AbstractC13042fc3.i(peersStruct$UserOutPeer, "apiUserOutPeer");
        return ok7.b.W().e.a(peersStruct$UserOutPeer.getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long y0(C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c17637nI7, "user");
        return Long.valueOf(c17637nI7.getAccessHash());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 z0(OK7 ok7, int i, long j) {
        AbstractC13042fc3.i(ok7, "this$0");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestLoadAvatars.newBuilder().A((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(i).A(j).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        UsersOuterClass$ResponseLoadAvatars defaultInstance = UsersOuterClass$ResponseLoadAvatars.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return ok7.x(new C22871vx5("/bale.users.v1.Users/LoadAvatars", generatedMessageLiteA, defaultInstance));
    }

    public final void B0() {
        this.b.a().h(this, "UserLoggedId");
    }

    public final C6517Nv5 C0(final int i) {
        C6517Nv5 c6517Nv5E = this.b.o(C11458d25.E(i)).H(new InterfaceC17569nB2() { // from class: ir.nasim.BK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.D0(this.a, (C17557nA) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.CK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.E0(this.a, i, (Misc$ResponseSeq) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.DK7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                OK7.F0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 U(final int i) {
        if (i == this.b.i0()) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("CAN_NOT_BLOCK_SAVED_MESSAGE"));
            AbstractC13042fc3.f(c6517Nv5F);
            return c6517Nv5F;
        }
        C6517Nv5 c6517Nv5H = this.b.o(C11458d25.E(i)).H(new InterfaceC17569nB2() { // from class: ir.nasim.uK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.V(this.a, (C17557nA) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.FK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.W(this.a, i, (Misc$ResponseSeq) obj);
            }
        });
        AbstractC13042fc3.f(c6517Nv5H);
        return c6517Nv5H;
    }

    public final C6517Nv5 X(final String str) {
        AbstractC13042fc3.i(str, "about");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestEditAbout.newBuilder().A(StringValue.of(str)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.users.v1.Users/EditAbout", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.GK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.Y(this.a, str, (Misc$ResponseSeq) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 Z(final String str) {
        AbstractC13042fc3.i(str, "newName");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestEditName.newBuilder().A(str).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.users.v1.Users/EditName", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.MK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.a0(this.a, str, (Misc$ResponseSeq) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 b0(final int i, final String str) {
        AbstractC13042fc3.i(str, "name");
        C6517Nv5 c6517Nv5H = this.e.a(i).h0(new InterfaceC17569nB2() { // from class: ir.nasim.NK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.c0((C17637nI7) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.vK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.d0(this.a, i, str, (Long) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.wK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.e0(this.a, i, str, (Misc$ResponseSeq) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 f0(final String str) {
        AbstractC13042fc3.i(str, "nick");
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestEditNickName.newBuilder().A(StringValue.of(str)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.users.v1.Users/EditNickName", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.xK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.g0(this.a, str, (Misc$ResponseSeq) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    @Override // ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        AbstractC13042fc3.i(abstractC18385oa2, "event");
        if (abstractC18385oa2 instanceof EI7) {
            this.d.p();
        }
    }

    public final C6517Nv5 j0(int i) {
        return this.d.o(i);
    }

    public final C6517Nv5 k0() {
        C6517Nv5 c6517Nv5A = this.e.a(this.b.w().p());
        AbstractC13042fc3.h(c6517Nv5A, "getValue(...)");
        return c6517Nv5A;
    }

    public final C6517Nv5 l0(int i) {
        C6517Nv5 c6517Nv5H0 = r(new C14170hT5(i), 16500).h0(new InterfaceC17569nB2() { // from class: ir.nasim.EK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.m0((C18970pZ5) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C17064mK7 n0() {
        return this.d;
    }

    public final VL3 o0() {
        return this.c;
    }

    public final InterfaceC8344Vo3 p0() {
        return this.e;
    }

    public final C6517Nv5 q0(int i, final String str) {
        AbstractC13042fc3.i(str, "url");
        C6517Nv5 c6517Nv5H0 = h0(i).h0(new InterfaceC17569nB2() { // from class: ir.nasim.HK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.r0(str, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C6517Nv5 s0() {
        UsersOuterClass$RequestLoadBlockedUsers defaultInstance = UsersOuterClass$RequestLoadBlockedUsers.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        UsersOuterClass$ResponseLoadBlockedUsers defaultInstance2 = UsersOuterClass$ResponseLoadBlockedUsers.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.users.v1.Users/LoadBlockedUsers", defaultInstance, defaultInstance2)).A(new InterfaceC17569nB2() { // from class: ir.nasim.yK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.t0(this.a, (UsersOuterClass$ResponseLoadBlockedUsers) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.zK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.u0(this.a, (UsersOuterClass$ResponseLoadBlockedUsers) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 w0(List list, boolean z) {
        AbstractC13042fc3.i(list, "uids");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C18766pD(((Number) it.next()).intValue(), 0L));
        }
        C6517Nv5 c6517Nv5T0 = this.b.V().t0(arrayList, AbstractC10360bX0.m(), z);
        AbstractC13042fc3.h(c6517Nv5T0, "loadRequiredPeers(...)");
        return c6517Nv5T0;
    }

    public final C6517Nv5 x0(final int i) {
        C6517Nv5 c6517Nv5H0 = this.e.a(i).h0(new InterfaceC17569nB2() { // from class: ir.nasim.JK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.y0((C17637nI7) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.KK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.z0(this.a, i, ((Long) obj).longValue());
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.LK7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return OK7.A0((UsersOuterClass$ResponseLoadAvatars) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }
}
