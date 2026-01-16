package ir.nasim;

import ai.bale.proto.AdvertisementOuterClass$RequestUpdateClick;
import ai.bale.proto.AdvertisementOuterClass$RequestUpdateView;
import ai.bale.proto.AdvertisementOuterClass$ResponseUpdateView;
import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.GroupsOuterClass$RequestCreateGroup;
import ai.bale.proto.GroupsOuterClass$RequestEditChannelNick;
import ai.bale.proto.GroupsOuterClass$RequestEditGroupAbout;
import ai.bale.proto.GroupsOuterClass$RequestEditGroupTitle;
import ai.bale.proto.GroupsOuterClass$RequestGetGroupInviteUrl;
import ai.bale.proto.GroupsOuterClass$RequestGetMemberPermissions;
import ai.bale.proto.GroupsOuterClass$RequestGetPins;
import ai.bale.proto.GroupsOuterClass$RequestInviteUser;
import ai.bale.proto.GroupsOuterClass$RequestJoinGroup;
import ai.bale.proto.GroupsOuterClass$RequestJoinPublicGroup;
import ai.bale.proto.GroupsOuterClass$RequestKickUser;
import ai.bale.proto.GroupsOuterClass$RequestLoadGroupAvatars;
import ai.bale.proto.GroupsOuterClass$RequestMakeUserAdmin;
import ai.bale.proto.GroupsOuterClass$RequestPinMessage;
import ai.bale.proto.GroupsOuterClass$RequestRemovePin;
import ai.bale.proto.GroupsOuterClass$RequestRemoveSingePin;
import ai.bale.proto.GroupsOuterClass$RequestRemoveUserAdmin;
import ai.bale.proto.GroupsOuterClass$RequestRevokeInviteUrl;
import ai.bale.proto.GroupsOuterClass$RequestSetCanSeeMessages;
import ai.bale.proto.GroupsOuterClass$RequestSetGroupDefaultPermissions;
import ai.bale.proto.GroupsOuterClass$RequestSetMemberCustomTitle;
import ai.bale.proto.GroupsOuterClass$RequestSetMemberPermissions;
import ai.bale.proto.GroupsOuterClass$RequestSetRestriction;
import ai.bale.proto.GroupsOuterClass$RequestTransferOwnership;
import ai.bale.proto.GroupsOuterClass$ResponseCreateGroup;
import ai.bale.proto.GroupsOuterClass$ResponseGetMemberPermissions;
import ai.bale.proto.GroupsOuterClass$ResponseGetPins;
import ai.bale.proto.GroupsOuterClass$ResponseInviteUrl;
import ai.bale.proto.GroupsOuterClass$ResponseJoinGroup;
import ai.bale.proto.GroupsOuterClass$ResponseLoadGroupAvatars;
import ai.bale.proto.GroupsOuterClass$ResponseSetMemberCustomTitle;
import ai.bale.proto.GroupsStruct$Group;
import ai.bale.proto.GroupsStruct$Permissions;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ai.bale.proto.Misc$ResponseSeqDate;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$Peer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.SearchOuterClass$RequestSearchMembers;
import ai.bale.proto.SearchOuterClass$ResponseSearchMembers;
import ai.bale.proto.SearchStruct$SearchPieceText;
import ai.bale.proto.UsersStruct$User;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.bQ2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10299bQ2 extends AbstractC21707u0 implements InterfaceC3817Cm0 {
    public static final a i = new a(null);
    public static final int j = 8;
    private final C9057Yh4 b;
    private final VL3 c;
    private final String d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC9173Yu3 f;
    private final InterfaceC9173Yu3 g;
    private C22508vM2 h;

    /* renamed from: ir.nasim.bQ2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bQ2$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA2 = C10299bQ2.this.a2(0, 0, 0, this);
            return objA2 == AbstractC14862ic3.e() ? objA2 : C9475a16.a(objA2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10299bQ2(C9057Yh4 c9057Yh4, VL3 vl3) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(vl3, "groupsCollection");
        this.b = c9057Yh4;
        this.c = vl3;
        this.d = "GroupModule";
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.tP2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10299bQ2.f2(this.a);
            }
        });
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.uP2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10299bQ2.n1(this.a);
            }
        });
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.vP2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10299bQ2.y3(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 A1(C10299bQ2 c10299bQ2, GroupsOuterClass$ResponseCreateGroup groupsOuterClass$ResponseCreateGroup) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(groupsOuterClass$ResponseCreateGroup, "response");
        C19406qI3.a(c10299bQ2.d, "request create group ended : " + C11458d25.y(groupsOuterClass$ResponseCreateGroup.getGroup().getId()).u(), new Object[0]);
        return C6517Nv5.l0(new C17428mw7(Integer.valueOf(groupsOuterClass$ResponseCreateGroup.getGroup().getId()), groupsOuterClass$ResponseCreateGroup.getInviteLink(), groupsOuterClass$ResponseCreateGroup.getNotAddedUserPeersList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List A2(GroupsOuterClass$ResponseLoadGroupAvatars groupsOuterClass$ResponseLoadGroupAvatars) {
        AbstractC13042fc3.i(groupsOuterClass$ResponseLoadGroupAvatars, "responseLoadAvatars");
        List<FilesStruct$Avatar> avatarsList = groupsOuterClass$ResponseLoadGroupAvatars.getAvatars().getAvatarsList();
        ArrayList arrayList = new ArrayList();
        Iterator<FilesStruct$Avatar> it = avatarsList.iterator();
        while (it.hasNext()) {
            C6984Pv c6984PvR = C18732p92.R(it.next());
            if (c6984PvR != null) {
                arrayList.add(new Avatar(c6984PvR));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 A3(C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        return new C21918uM2(c10299bQ2.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(C10299bQ2 c10299bQ2, String str, C17428mw7 c17428mw7) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        c10299bQ2.R1(((Number) c17428mw7.f()).intValue());
        if (str != null) {
            c10299bQ2.o1(((Number) c17428mw7.f()).intValue(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 C1(C10299bQ2 c10299bQ2, Integer[] numArr, Integer[] numArr2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(numArr, "$uids");
        return c10299bQ2.b.W().w0(AbstractC10242bK.f1(numArr), false);
    }

    private final void C2(C11458d25 c11458d25) {
        if (M1(c11458d25) == ExPeerType.CHANNEL) {
            int i2 = c11458d25.getPeerId() == 255637216 ? 1 : 0;
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            C17213mb2.l("Channel_open", "Bale_Official_Channel", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 C3(C10299bQ2 c10299bQ2, int i2, int i3, boolean z, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestSetCanSeeMessages.newBuilder().B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(c14697iL2.getAccessHash()).a()).C(i3).A(z).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/SetCanSeeMessages", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 D3(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 E1(C10299bQ2 c10299bQ2, long j2, String str, C14697iL2 c14697iL2) {
        StringValue defaultInstance;
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GroupsOuterClass$RequestEditGroupAbout.b bVarD = GroupsOuterClass$RequestEditGroupAbout.newBuilder().C((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).D(j2);
        if (str == null || (defaultInstance = (StringValue) StringValue.newBuilder().A(str).a()) == null) {
            defaultInstance = StringValue.getDefaultInstance();
        }
        GeneratedMessageLite generatedMessageLiteA = bVarD.B(defaultInstance).A(PC.b).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance2 = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/EditGroupAbout", generatedMessageLiteA, defaultInstance2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 E2(C10299bQ2 c10299bQ2, int i2, String str, int i3, C4382Ew7 c4382Ew7) {
        StringValue defaultInstance;
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        GroupsOuterClass$RequestMakeUserAdmin.a aVarB = GroupsOuterClass$RequestMakeUserAdmin.newBuilder().B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(((C14697iL2) c4382Ew7.a()).getAccessHash()).a());
        if (str == null || (defaultInstance = (StringValue) StringValue.newBuilder().A(str).a()) == null) {
            defaultInstance = StringValue.getDefaultInstance();
        }
        GeneratedMessageLite generatedMessageLiteA = aVarB.A(defaultInstance).C((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(i3).A(((C17637nI7) c4382Ew7.b()).getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance2 = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/MakeUserAdmin", generatedMessageLiteA, defaultInstance2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 F1(C10299bQ2 c10299bQ2, int i2, String str, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(misc$ResponseSeqDate, "r");
        return c10299bQ2.b.V().S(misc$ResponseSeqDate.getSeq(), misc$ResponseSeqDate.getState().a0(), new ID7(i2, str), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 F2(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 G3(final C10299bQ2 c10299bQ2, final int i2, final int i3, final C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestTransferOwnership.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(((C14697iL2) c4382Ew7.a()).getAccessHash()).a()).B(i3).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/TransferOwnership", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.JO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.H3(this.a, c4382Ew7, i2, i3, (Misc$ResponseSeqDate) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 H1(C10299bQ2 c10299bQ2, String str, long j2, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(c14697iL2, "group");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestEditChannelNick.newBuilder().B(str).A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).C(j2).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/EditChannelNick", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void H2(ir.nasim.UA2 r16, ir.nasim.C10299bQ2 r17, int r18, ir.nasim.C12889fL5 r19, boolean r20, java.util.List r21) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10299bQ2.H2(ir.nasim.UA2, ir.nasim.bQ2, int, ir.nasim.fL5, boolean, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 H3(C10299bQ2 c10299bQ2, C4382Ew7 c4382Ew7, int i2, int i3, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(misc$ResponseSeqDate, "r");
        return c10299bQ2.b.V().S(misc$ResponseSeqDate.getSeq(), misc$ResponseSeqDate.getState().a0(), new C15828kE7(i2, i3), c10299bQ2.d2((C14697iL2) c4382Ew7.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 I1(C10299bQ2 c10299bQ2, int i2, long j2, String str, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(misc$ResponseSeqDate, "responseSeqDate");
        return c10299bQ2.b.V().S(misc$ResponseSeqDate.getSeq(), misc$ResponseSeqDate.getState().a0(), new C14639iE7(i2, j2, c10299bQ2.b.i0(), str, misc$ResponseSeqDate.getDate()), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(final C10299bQ2 c10299bQ2, final UA2 ua2, final ArrayList arrayList, final int i2, final C12889fL5 c12889fL5, final boolean z, final SearchOuterClass$ResponseSearchMembers searchOuterClass$ResponseSearchMembers) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(ua2, "$onSuccess");
        AbstractC13042fc3.i(arrayList, "$results");
        AbstractC13042fc3.i(c12889fL5, "$query");
        OK7 ok7W = c10299bQ2.b.W();
        List<PeersStruct$UserOutPeer> usersList = searchOuterClass$ResponseSearchMembers.getUsersList();
        AbstractC13042fc3.h(usersList, "getUsersList(...)");
        List<PeersStruct$UserOutPeer> list = usersList;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((PeersStruct$UserOutPeer) it.next()).getUid()));
        }
        ok7W.w0(arrayList2, false).m0(new InterfaceC24449ye1() { // from class: ir.nasim.RP2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.J2(this.a, searchOuterClass$ResponseSearchMembers, ua2, arrayList, i2, c12889fL5, z, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(final C10299bQ2 c10299bQ2, SearchOuterClass$ResponseSearchMembers searchOuterClass$ResponseSearchMembers, final UA2 ua2, final ArrayList arrayList, final int i2, final C12889fL5 c12889fL5, final boolean z, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(ua2, "$onSuccess");
        AbstractC13042fc3.i(arrayList, "$results");
        AbstractC13042fc3.i(c12889fL5, "$query");
        InterfaceC8344Vo3 interfaceC8344Vo3P0 = c10299bQ2.b.W().p0();
        List<PeersStruct$UserOutPeer> usersList = searchOuterClass$ResponseSearchMembers.getUsersList();
        AbstractC13042fc3.h(usersList, "getUsersList(...)");
        List<PeersStruct$UserOutPeer> list = usersList;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((PeersStruct$UserOutPeer) it.next()).getUid()));
        }
        interfaceC8344Vo3P0.g(arrayList2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.VP2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.K2(ua2, arrayList, c10299bQ2, i2, c12889fL5, z, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J3(final C10299bQ2 c10299bQ2, final int i2, final int i3, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "callback");
        c10299bQ2.k1(i2, i3, 0).m0(new InterfaceC24449ye1() { // from class: ir.nasim.LO2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.K3(this.a, i2, i3, interfaceC15419jZ0, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.MO2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.L3(this.a, i2, i3, interfaceC15419jZ0, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 K1(C10299bQ2 c10299bQ2, int i2, long j2, String str, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GroupsOuterClass$RequestEditGroupTitle.b bVarC = GroupsOuterClass$RequestEditGroupTitle.newBuilder().B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(c14697iL2.getAccessHash()).a()).C(j2);
        if (str == null) {
            str = "";
        }
        GeneratedMessageLite generatedMessageLiteA = bVarC.D(str).A(PC.b).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/EditGroupTitle", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(UA2 ua2, ArrayList arrayList, C10299bQ2 c10299bQ2, int i2, C12889fL5 c12889fL5, boolean z, List list) {
        String name;
        String strB0;
        List list2;
        AbstractC13042fc3.i(ua2, "$onSuccess");
        AbstractC13042fc3.i(arrayList, "$results");
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$query");
        AbstractC13042fc3.f(list);
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.XP2
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(C10299bQ2.L2((C17637nI7) obj, (C17637nI7) obj2));
            }
        };
        for (C17637nI7 c17637nI7 : AbstractC15401jX0.a1(list, new Comparator() { // from class: ir.nasim.YP2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C10299bQ2.M2(interfaceC14603iB2, obj, obj2);
            }
        })) {
            boolean z2 = c17637nI7.d0() != null;
            if (z2) {
                name = c17637nI7.d0();
                strB0 = c17637nI7.getName();
            } else if (c17637nI7.b0() != null) {
                name = c17637nI7.l0();
                strB0 = c17637nI7.b0();
            } else {
                name = c17637nI7.getName();
                strB0 = null;
            }
            String str = name;
            if (((CharSequence) c12889fL5.a).length() > 0) {
                List<QY6> listA = RY6.a(str, (String) c12889fL5.a);
                if (strB0 != null) {
                    List listA2 = RY6.a(strB0, (String) c12889fL5.a);
                    if (listA.size() > 0 || listA2.size() > 0) {
                        if (z2) {
                            ArrayList arrayList2 = new ArrayList();
                            for (QY6 qy6 : listA) {
                                arrayList2.add(new QY6(qy6.b() + 1, qy6.a()));
                            }
                            list2 = arrayList2;
                        } else {
                            list2 = listA;
                        }
                        int iN0 = c17637nI7.n0();
                        if (z2) {
                            str = Separators.AT + str;
                        }
                        arrayList.add(new Y34(iN0, str, list2, strB0, c17637nI7.d0(), listA2));
                    }
                } else if (listA.size() > 0) {
                    arrayList.add(new Y34(c17637nI7.n0(), str, listA, null, c17637nI7.d0(), null));
                }
            }
        }
        List listR0 = AbstractC15401jX0.R0(arrayList, c10299bQ2.O1(i2, (String) c12889fL5.a, z));
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : listR0) {
            if (hashSet.add(Integer.valueOf(((Y34) obj).e()))) {
                arrayList3.add(obj);
            }
        }
        ua2.invoke(AbstractC15401jX0.f1(arrayList3, 30));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K3(C10299bQ2 c10299bQ2, int i2, int i3, InterfaceC15419jZ0 interfaceC15419jZ0, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        c10299bQ2.F3(i2, i3).m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 L1(C10299bQ2 c10299bQ2, int i2, long j2, String str, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(misc$ResponseSeqDate, "responseSeqDate");
        return c10299bQ2.b.V().S(misc$ResponseSeqDate.getSeq(), misc$ResponseSeqDate.getState().a0(), new C19374qE7(i2, j2, c10299bQ2.b.i0(), str == null ? "" : str, misc$ResponseSeqDate.getDate()), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int L2(C17637nI7 c17637nI7, C17637nI7 c17637nI72) {
        AbstractC13042fc3.i(c17637nI7, "a");
        AbstractC13042fc3.i(c17637nI72, "b");
        String name = c17637nI7.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        String name2 = c17637nI72.getName();
        AbstractC13042fc3.h(name2, "getName(...)");
        return AbstractC20153rZ6.v(name, name2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L3(C10299bQ2 c10299bQ2, int i2, int i3, InterfaceC15419jZ0 interfaceC15419jZ0, Exception exc) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        AbstractC13042fc3.i(exc, "e");
        if ((exc instanceof RpcException) && AbstractC13042fc3.d(((RpcException) exc).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "ALREADY_INVITED")) {
            c10299bQ2.F3(i2, i3).m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
        } else {
            interfaceC15419jZ0.onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int M2(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    private final ExPeerType N1(int i2) {
        C14733iO2 c14733iO2 = (C14733iO2) this.c.n(i2);
        if (c14733iO2 != null) {
            return c14733iO2.p();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int P1(C17637nI7 c17637nI7, C17637nI7 c17637nI72) {
        AbstractC13042fc3.i(c17637nI7, "a");
        AbstractC13042fc3.i(c17637nI72, "b");
        String name = c17637nI7.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        String name2 = c17637nI72.getName();
        AbstractC13042fc3.h(name2, "getName(...)");
        return AbstractC20153rZ6.v(name, name2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 P2(C10299bQ2 c10299bQ2, int i2, long j2, long j3, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestPinMessage.newBuilder().D(i2).B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).A(j2).C(j3).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/PinMessage", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Q1(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Q2(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final void R1(int i2) {
        OK okC = this.b.T().C();
        C6937Pp6 c6937Pp6E = C6937Pp6.y().E(okC);
        c6937Pp6E.q(i2, i2, new byte[0]);
        c6937Pp6E.D(i2, 0);
        okC.e(new C9863ah0(4L, c6937Pp6E.toByteArray()));
        this.b.V().V();
        C19406qI3.a(this.d, "getDiff invoke for create group", new Object[0]);
    }

    private final C21909uL2 S1() {
        return (C21909uL2) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 S2(C10299bQ2 c10299bQ2, int i2, int i3, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestRemoveUserAdmin.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(((C14697iL2) c4382Ew7.a()).getAccessHash()).a()).B((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(i3).A(((C17637nI7) c4382Ew7.b()).getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/RemoveUserAdmin", generatedMessageLiteA, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.KO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.T2((Misc$ResponseSeqDate) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14505i18 T2(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 V2(C10299bQ2 c10299bQ2, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestRemovePin.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/RemovePin", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 W2(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Y2(C10299bQ2 c10299bQ2, long j2, long j3, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestRemoveSingePin.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).C(j2).B(j3).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/RemoveSinglePin", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Z2(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 b2(C10299bQ2 c10299bQ2, int i2, int i3, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestGetPins.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).C(i2).B(i3).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseGetPins defaultInstance = GroupsOuterClass$ResponseGetPins.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/GetPins", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 b3(C10299bQ2 c10299bQ2, int i2, int i3, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestGetMemberPermissions.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(((C14697iL2) c4382Ew7.a()).getAccessHash()).a()).B((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(i3).A(((C17637nI7) c4382Ew7.b()).getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseGetMemberPermissions defaultInstance = GroupsOuterClass$ResponseGetMemberPermissions.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/GetMemberPermissions", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 c2(GroupsOuterClass$ResponseGetPins groupsOuterClass$ResponseGetPins) {
        Integer numValueOf = Integer.valueOf(groupsOuterClass$ResponseGetPins.getPinsCount());
        List<MessagingStruct$MessageContainer> pinsList = groupsOuterClass$ResponseGetPins.getPinsList();
        AbstractC13042fc3.h(pinsList, "getPinsList(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = pinsList.iterator();
        while (it.hasNext()) {
            C25247zz c25247zzE = C18732p92.a.E((MessagingStruct$MessageContainer) it.next());
            J44 j44M = c25247zzE != null ? C18732p92.M(c25247zzE) : null;
            if (j44M != null) {
                arrayList.add(j44M);
            }
        }
        return C6517Nv5.l0(new XV4(numValueOf, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DA c3(GroupsOuterClass$ResponseGetMemberPermissions groupsOuterClass$ResponseGetMemberPermissions) {
        AbstractC13042fc3.i(groupsOuterClass$ResponseGetMemberPermissions, "responseGetMemberPermissions");
        return C18732p92.K0(groupsOuterClass$ResponseGetMemberPermissions.getPermissions());
    }

    private final int d2(C14697iL2 c14697iL2) {
        if (c14697iL2 == null || c14697iL2.q0() != ZN2.GROUP) {
            return 0;
        }
        return c14697iL2.p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 e3(C10299bQ2 c10299bQ2, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestGetGroupInviteUrl.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseInviteUrl defaultInstance = GroupsOuterClass$ResponseInviteUrl.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/GetGroupInviteURL", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC8344Vo3 f2(C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        return c10299bQ2.c.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4382Ew7 f3(GroupsOuterClass$ResponseInviteUrl groupsOuterClass$ResponseInviteUrl) {
        AbstractC13042fc3.i(groupsOuterClass$ResponseInviteUrl, "responseInviteUrl");
        return new C4382Ew7(groupsOuterClass$ResponseInviteUrl.getUrl(), groupsOuterClass$ResponseInviteUrl.getUrl());
    }

    private final C6517Nv5 g2(final C5212Ij3 c5212Ij3) {
        C6517Nv5 c6517Nv5H0 = C6517Nv5.l0(c5212Ij3).A(new InterfaceC17569nB2() { // from class: ir.nasim.KP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.h2(this.a, (C5212Ij3) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.LP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.i2(this.a, (C5212Ij3) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.MP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.j2(this.a, c5212Ij3, (C5212Ij3) obj);
            }
        }).G(new InterfaceC17569nB2() { // from class: ir.nasim.NP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.l2(c5212Ij3, (Exception) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.OP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.m2((C23464wy) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 h1(AdvertisementOuterClass$ResponseUpdateView advertisementOuterClass$ResponseUpdateView) {
        return C6517Nv5.l0(new G06());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 h2(C10299bQ2 c10299bQ2, C5212Ij3 c5212Ij3) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c5212Ij3, "joinGroupResponse");
        return c10299bQ2.b.V().R(c5212Ij3.h(), AbstractC9766aX0.e(c5212Ij3.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(final C10299bQ2 c10299bQ2, final int i2, final int i3, String str, final DA da, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        c10299bQ2.D2(i2, i3, str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dP2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.i3(this.a, i2, i3, da, c7234Qv5, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.eP2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 i2(C10299bQ2 c10299bQ2, C5212Ij3 c5212Ij3) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c5212Ij3, "res");
        return c10299bQ2.b.V().s0(AbstractC9766aX0.e(new C18766pD(c5212Ij3.d(), 0L)), new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i3(C10299bQ2 c10299bQ2, int i2, int i3, DA da, final C7234Qv5 c7234Qv5, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        c10299bQ2.r3(i2, i3, da).m0(new InterfaceC24449ye1() { // from class: ir.nasim.kP2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.j3(c7234Qv5, (C14505i18) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.lP2
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C10299bQ2.k3(c7234Qv5, (C14505i18) obj, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 j1(AdvertisementOuterClass$ResponseUpdateView advertisementOuterClass$ResponseUpdateView) {
        AbstractC13042fc3.i(advertisementOuterClass$ResponseUpdateView, "responseUpdateView");
        return C6517Nv5.l0(new H06(advertisementOuterClass$ResponseUpdateView.getIsSuccessful()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 j2(C10299bQ2 c10299bQ2, final C5212Ij3 c5212Ij3, C5212Ij3 c5212Ij32) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c5212Ij3, "$joinGroupResponseEntity");
        AbstractC13042fc3.i(c5212Ij32, "res");
        return c10299bQ2.b.V().S(c5212Ij32.f(), c5212Ij32.g(), new WD7(c5212Ij32.b().D(), c5212Ij32.e(), c5212Ij32.d(), c5212Ij32.a(), c5212Ij32.c(), c5212Ij3.i()), 0).h0(new InterfaceC17569nB2() { // from class: ir.nasim.WP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.k2(c5212Ij3, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j3(C7234Qv5 c7234Qv5, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        c7234Qv5.b(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23464wy k2(C5212Ij3 c5212Ij3, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c5212Ij3, "$joinGroupResponseEntity");
        return c5212Ij3.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k3(C7234Qv5 c7234Qv5, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        c7234Qv5.b(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 l1(C10299bQ2 c10299bQ2, int i2, int i3, long j2, int i4, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestInviteUser.newBuilder().A(PC.b).B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(((C14697iL2) c4382Ew7.a()).getAccessHash()).a()).E((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(i3).A(((C17637nI7) c4382Ew7.b()).getAccessHash()).a()).D(j2).C((Int32Value) Int32Value.newBuilder().A(i4).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.y(new C22871vx5("/bale.groups.v1.Groups/InviteUser", generatedMessageLiteA, defaultInstance), 15000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 l2(C5212Ij3 c5212Ij3, Exception exc) {
        AbstractC13042fc3.i(c5212Ij3, "$joinGroupResponseEntity");
        return C6517Nv5.l0(c5212Ij3.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 m1(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14505i18 m2(C23464wy c23464wy) {
        return C14505i18.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 m3(C10299bQ2 c10299bQ2, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestRevokeInviteUrl.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseInviteUrl defaultInstance = GroupsOuterClass$ResponseInviteUrl.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.y(new C22871vx5("/bale.groups.v1.Groups/RevokeInviteURL", generatedMessageLiteA, defaultInstance), 16500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C21909uL2 n1(C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        return new C21909uL2(c10299bQ2.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4382Ew7 n3(GroupsOuterClass$ResponseInviteUrl groupsOuterClass$ResponseInviteUrl) {
        AbstractC13042fc3.i(groupsOuterClass$ResponseInviteUrl, "responseInviteUrl");
        return new C4382Ew7(groupsOuterClass$ResponseInviteUrl.getUrl(), groupsOuterClass$ResponseInviteUrl.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 o2(C10299bQ2 c10299bQ2, GroupsOuterClass$ResponseJoinGroup groupsOuterClass$ResponseJoinGroup) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(groupsOuterClass$ResponseJoinGroup, "responseJoinGroup");
        GroupsStruct$Group group = groupsOuterClass$ResponseJoinGroup.getGroup();
        AbstractC13042fc3.h(group, "getGroup(...)");
        C23464wy c23464wyB = C18732p92.b(group);
        int inviterUserId = groupsOuterClass$ResponseJoinGroup.getInviterUserId();
        List<UsersStruct$User> usersList = groupsOuterClass$ResponseJoinGroup.getUsersList();
        AbstractC13042fc3.h(usersList, "getUsersList(...)");
        List listK = C18732p92.K(usersList);
        List<PeersStruct$UserOutPeer> userPeersList = groupsOuterClass$ResponseJoinGroup.getUserPeersList();
        AbstractC13042fc3.h(userPeersList, "getUserPeersList(...)");
        List listJ = C18732p92.J(userPeersList);
        long rid = groupsOuterClass$ResponseJoinGroup.getRid();
        int seq = groupsOuterClass$ResponseJoinGroup.getSeq();
        int groupSeq = groupsOuterClass$ResponseJoinGroup.getGroupSeq();
        byte[] bArrA0 = groupsOuterClass$ResponseJoinGroup.getState().a0();
        AbstractC13042fc3.h(bArrA0, "toByteArray(...)");
        return c10299bQ2.g2(new C5212Ij3(c23464wyB, inviterUserId, listK, listJ, rid, seq, groupSeq, bArrA0, groupsOuterClass$ResponseJoinGroup.getDate(), true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer p2(GroupsOuterClass$ResponseJoinGroup groupsOuterClass$ResponseJoinGroup) {
        return Integer.valueOf(groupsOuterClass$ResponseJoinGroup.getGroup().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 p3(C10299bQ2 c10299bQ2, int i2, DA da, C14697iL2 c14697iL2) {
        GroupsStruct$Permissions defaultInstance;
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GroupsOuterClass$RequestSetGroupDefaultPermissions.a aVarA = GroupsOuterClass$RequestSetGroupDefaultPermissions.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(c14697iL2.getAccessHash()).a());
        if (da == null || (defaultInstance = C18732p92.J0(da)) == null) {
            defaultInstance = GroupsStruct$Permissions.getDefaultInstance();
        }
        GeneratedMessageLite generatedMessageLiteA = aVarA.B(defaultInstance).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance2 = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/SetGroupDefaultPermissions", generatedMessageLiteA, defaultInstance2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 q1(C10299bQ2 c10299bQ2, W06 w06, String str, C14697iL2 c14697iL2) {
        BB bbJ;
        StringValue defaultInstance;
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "group");
        GroupsOuterClass$RequestSetRestriction.a aVarA = GroupsOuterClass$RequestSetRestriction.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a());
        if (w06 == null || (bbJ = w06.j()) == null) {
            bbJ = BB.PRIVATE;
        }
        GroupsOuterClass$RequestSetRestriction.a aVarC = aVarA.C(C18732p92.y(bbJ));
        if (str == null || (defaultInstance = (StringValue) StringValue.newBuilder().A(str).a()) == null) {
            defaultInstance = StringValue.getDefaultInstance();
        }
        GeneratedMessageLite generatedMessageLiteA = aVarC.B(defaultInstance).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance2 = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/SetRestriction", generatedMessageLiteA, defaultInstance2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 q3(Misc$ResponseVoid misc$ResponseVoid) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 r1(C10299bQ2 c10299bQ2, int i2, W06 w06, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(misc$ResponseSeqDate, "r");
        UG7 ug7V = c10299bQ2.b.V();
        int seq = misc$ResponseSeqDate.getSeq();
        byte[] bArrA0 = misc$ResponseSeqDate.getState().a0();
        if (w06 == null) {
            w06 = W06.PRIVATE;
        }
        return ug7V.S(seq, bArrA0, new C18192oE7(i2, w06), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 r2(C10299bQ2 c10299bQ2, GroupsOuterClass$ResponseJoinGroup groupsOuterClass$ResponseJoinGroup) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(groupsOuterClass$ResponseJoinGroup, "responseJoinGroup");
        GroupsStruct$Group group = groupsOuterClass$ResponseJoinGroup.getGroup();
        AbstractC13042fc3.h(group, "getGroup(...)");
        C23464wy c23464wyB = C18732p92.b(group);
        int inviterUserId = groupsOuterClass$ResponseJoinGroup.getInviterUserId();
        List<UsersStruct$User> usersList = groupsOuterClass$ResponseJoinGroup.getUsersList();
        AbstractC13042fc3.h(usersList, "getUsersList(...)");
        List listK = C18732p92.K(usersList);
        List<PeersStruct$UserOutPeer> userPeersList = groupsOuterClass$ResponseJoinGroup.getUserPeersList();
        AbstractC13042fc3.h(userPeersList, "getUserPeersList(...)");
        List listJ = C18732p92.J(userPeersList);
        long rid = groupsOuterClass$ResponseJoinGroup.getRid();
        int seq = groupsOuterClass$ResponseJoinGroup.getSeq();
        int groupSeq = groupsOuterClass$ResponseJoinGroup.getGroupSeq();
        byte[] bArrA0 = groupsOuterClass$ResponseJoinGroup.getState().a0();
        AbstractC13042fc3.h(bArrA0, "toByteArray(...)");
        return c10299bQ2.g2(new C5212Ij3(c23464wyB, inviterUserId, listK, listJ, rid, seq, groupSeq, bArrA0, groupsOuterClass$ResponseJoinGroup.getDate(), true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer s2(GroupsOuterClass$ResponseJoinGroup groupsOuterClass$ResponseJoinGroup) {
        AbstractC13042fc3.i(groupsOuterClass$ResponseJoinGroup, "responseJoinGroup");
        return Integer.valueOf(groupsOuterClass$ResponseJoinGroup.getGroup().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 s3(C10299bQ2 c10299bQ2, int i2, int i3, DA da, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(c4382Ew7, "groupUserTuple2");
        GroupsOuterClass$RequestSetMemberPermissions.a aVarC = GroupsOuterClass$RequestSetMemberPermissions.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(((C14697iL2) c4382Ew7.a()).getAccessHash()).a()).C((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(i3).A(((C17637nI7) c4382Ew7.b()).getAccessHash()).a());
        if (da != null) {
            GroupsStruct$Permissions groupsStruct$PermissionsJ0 = C18732p92.J0(da);
            if (groupsStruct$PermissionsJ0 == null) {
                groupsStruct$PermissionsJ0 = GroupsStruct$Permissions.getDefaultInstance();
            }
            aVarC.B(groupsStruct$PermissionsJ0);
        }
        C19938rB7 c19938rB7 = C19938rB7.a;
        GeneratedMessageLite generatedMessageLiteA = aVarC.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/SetMemberPermissions", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 t3(Misc$ResponseVoid misc$ResponseVoid) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u1(C10299bQ2 c10299bQ2, Integer[] numArr, Integer[] numArr2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(numArr, "$uids");
        InterfaceC8344Vo3 interfaceC8344Vo3P0 = c10299bQ2.b.W().p0();
        ArrayList arrayList = new ArrayList(numArr.length);
        for (Integer num : numArr) {
            arrayList.add(Long.valueOf(num.intValue()));
        }
        List<C17637nI7> listF = interfaceC8344Vo3P0.f(arrayList);
        AbstractC13042fc3.f(listF);
        ArrayList arrayList2 = new ArrayList();
        for (C17637nI7 c17637nI7 : listF) {
            PeersStruct$UserOutPeer peersStruct$UserOutPeer = (PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(c17637nI7.n0()).A(c17637nI7.getAccessHash()).a();
            if (peersStruct$UserOutPeer != null) {
                arrayList2.add(peersStruct$UserOutPeer);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 u2(C10299bQ2 c10299bQ2, int i2, long j2, int i3, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestKickUser.newBuilder().B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(i2).A(((C14697iL2) c4382Ew7.a()).getAccessHash()).a()).C(j2).D((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(i3).A(((C17637nI7) c4382Ew7.b()).getAccessHash()).a()).A(PC.b).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeqDate defaultInstance = Misc$ResponseSeqDate.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/KickUser", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 v1(C10299bQ2 c10299bQ2, long j2, String str, ZN2 zn2, String str2, BB bb, List list) {
        StringValue defaultInstance;
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(list, "apiUserOutPeers");
        GroupsOuterClass$RequestCreateGroup.b bVarB = GroupsOuterClass$RequestCreateGroup.newBuilder().F(j2).G(str).B(list);
        if (zn2 == null) {
            zn2 = ZN2.GROUP;
        }
        GroupsOuterClass$RequestCreateGroup.b bVarA = bVarB.C(C18732p92.j(zn2)).A(PC.b);
        if (str2 == null || (defaultInstance = (StringValue) StringValue.newBuilder().A(str2).a()) == null) {
            defaultInstance = StringValue.getDefaultInstance();
        }
        GroupsOuterClass$RequestCreateGroup.b bVarD = bVarA.D(defaultInstance);
        if (bb == null) {
            bb = BB.PRIVATE;
        }
        GeneratedMessageLite generatedMessageLiteA = bVarD.E(C18732p92.z(bb)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseCreateGroup defaultInstance2 = GroupsOuterClass$ResponseCreateGroup.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/CreateGroup", generatedMessageLiteA, defaultInstance2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 v2(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v3(final C10299bQ2 c10299bQ2, int i2, final int i3, final String str, GroupsOuterClass$ResponseSetMemberCustomTitle groupsOuterClass$ResponseSetMemberCustomTitle) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(str, "$name");
        c10299bQ2.X1().a(i2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.PO2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.w3(this.a, i3, str, (C14697iL2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(C10299bQ2 c10299bQ2, Exception exc) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        C19406qI3.a(c10299bQ2.d, "error on create group request with message : " + exc.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w3(C10299bQ2 c10299bQ2, int i2, String str, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(str, "$name");
        c10299bQ2.X1().e(c14697iL2.b0(i2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 x1(C10299bQ2 c10299bQ2, GroupsOuterClass$ResponseCreateGroup groupsOuterClass$ResponseCreateGroup) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(groupsOuterClass$ResponseCreateGroup, "response");
        UG7 ug7V = c10299bQ2.b.V();
        List<UsersStruct$User> usersList = groupsOuterClass$ResponseCreateGroup.getUsersList();
        AbstractC13042fc3.h(usersList, "getUsersList(...)");
        List listK = C18732p92.K(usersList);
        GroupsStruct$Group group = groupsOuterClass$ResponseCreateGroup.getGroup();
        AbstractC13042fc3.h(group, "getGroup(...)");
        return ug7V.R(listK, AbstractC9766aX0.e(C18732p92.b(group)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 x3(GroupsOuterClass$ResponseSetMemberCustomTitle groupsOuterClass$ResponseSetMemberCustomTitle) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 y1(final C10299bQ2 c10299bQ2, long j2, GroupsOuterClass$ResponseCreateGroup groupsOuterClass$ResponseCreateGroup) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        AbstractC13042fc3.i(groupsOuterClass$ResponseCreateGroup, "response");
        return c10299bQ2.b.V().S(groupsOuterClass$ResponseCreateGroup.getSeq(), groupsOuterClass$ResponseCreateGroup.getState().a0(), new WD7(groupsOuterClass$ResponseCreateGroup.getGroup().getId(), j2, c10299bQ2.b.i0(), AbstractC20507s76.o(), 0, false), 0).E(new InterfaceC24449ye1() { // from class: ir.nasim.fP2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.z1(this.a, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long y2(C14697iL2 c14697iL2) {
        return Long.valueOf(c14697iL2.getAccessHash());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TN2 y3(C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        return new TN2(c10299bQ2.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(C10299bQ2 c10299bQ2, Exception exc) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        C19406qI3.a(c10299bQ2.d, "error on update create group request with message : " + exc.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 z2(C10299bQ2 c10299bQ2, int i2, Long l) {
        AbstractC13042fc3.i(c10299bQ2, "this$0");
        GroupsOuterClass$RequestLoadGroupAvatars.a aVarNewBuilder = GroupsOuterClass$RequestLoadGroupAvatars.newBuilder();
        PeersStruct$GroupOutPeer.a aVarB = PeersStruct$GroupOutPeer.newBuilder().B(i2);
        AbstractC13042fc3.f(l);
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.A((PeersStruct$GroupOutPeer) aVarB.A(l.longValue()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseLoadGroupAvatars defaultInstance = GroupsOuterClass$ResponseLoadGroupAvatars.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return c10299bQ2.x(new C22871vx5("/bale.groups.v1.Groups/LoadGroupAvatars", generatedMessageLiteA, defaultInstance));
    }

    public final C6517Nv5 B2(ArrayList arrayList, boolean z) {
        AbstractC13042fc3.i(arrayList, "uids");
        UG7 ug7V = this.b.V();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(new C25238zy(((Number) it.next()).intValue(), 0L));
        }
        C6517Nv5 c6517Nv5T0 = ug7V.t0(arrayList2, arrayList3, z);
        AbstractC13042fc3.h(c6517Nv5T0, "loadRequiredPeers(...)");
        return c6517Nv5T0;
    }

    public final C6517Nv5 B3(final int i2, final int i3, final boolean z) {
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.nP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.C3(this.a, i2, i3, z, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.oP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.D3((Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 D1(final int i2, final String str) {
        final String string;
        final long jA = AbstractC19981rG5.a();
        if (str != null) {
            int length = str.length() - 1;
            int i3 = 0;
            boolean z = false;
            while (i3 <= length) {
                boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i3 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i3++;
                } else {
                    z = true;
                }
            }
            string = str.subSequence(i3, length + 1).toString();
        } else {
            string = null;
        }
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.xP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.E1(this.a, jA, str, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.IP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.F1(this.a, i2, string, (Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 D2(final int i2, final int i3, final String str) {
        C6517Nv5 c6517Nv5H = AbstractC7941Tv5.f(X1().a(i2), this.b.W().p0().a(i3)).H(new InterfaceC17569nB2() { // from class: ir.nasim.iP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.E2(this.a, i2, str, i3, (C4382Ew7) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.jP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.F2((Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final void E3(C11458d25 c11458d25, List list) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "reactions");
        e2().u(c11458d25, AbstractC15401jX0.n0(list));
    }

    public final C6517Nv5 F3(final int i2, final int i3) {
        C6517Nv5 c6517Nv5H = AbstractC7941Tv5.f(X1().a(i2), this.b.W().p0().a(i3)).H(new InterfaceC17569nB2() { // from class: ir.nasim.CO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.G3(this.a, i2, i3, (C4382Ew7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 G1(final int i2, final String str) {
        AbstractC13042fc3.i(str, "nick");
        final long jA = AbstractC19981rG5.a();
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.FP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.H1(this.a, str, jA, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.GP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.I1(this.a, i2, jA, str, (Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final void G2(final int i2, String str, final boolean z, final UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onSuccess");
        final C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = str;
        if (str == null) {
            C19406qI3.b(this.d, "findMentions query is null!");
            ua2.invoke(AbstractC10360bX0.m());
            return;
        }
        int length = str.length() - 1;
        int i3 = 0;
        boolean z2 = false;
        while (i3 <= length) {
            boolean z3 = AbstractC13042fc3.k(str.charAt(!z2 ? i3 : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i3++;
            } else {
                z2 = true;
            }
        }
        String string = str.subSequence(i3, length + 1).toString();
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        c12889fL5.a = lowerCase;
        C14697iL2 c14697iL2 = (C14697iL2) X1().d(i2);
        final ArrayList arrayList = new ArrayList();
        if (((CharSequence) c12889fL5.a).length() != 0) {
            GeneratedMessageLite generatedMessageLiteA = SearchOuterClass$RequestSearchMembers.newBuilder().C((SearchStruct$SearchPieceText) SearchStruct$SearchPieceText.newBuilder().A((String) c12889fL5.a).a()).B((PeersStruct$ExPeer) PeersStruct$ExPeer.newBuilder().B(c14697iL2.p0()).C(c14697iL2.q0() == ZN2.GROUP ? EnumC10088b35.ExPeerType_GROUP : EnumC10088b35.ExPeerType_CHANNEL).A(0L).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            SearchOuterClass$ResponseSearchMembers defaultInstance = SearchOuterClass$ResponseSearchMembers.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
            x(new C22871vx5("/bale.search.v1.Search/SearchMembers", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.CP2
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C10299bQ2.I2(this.a, ua2, arrayList, i2, c12889fL5, z, (SearchOuterClass$ResponseSearchMembers) obj);
                }
            });
            return;
        }
        List listS0 = c14697iL2.s0();
        AbstractC13042fc3.h(listS0, "getMembers(...)");
        Object[] array = listS0.toArray(new C23104wM2[0]);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : array) {
            C23104wM2 c23104wM2 = (C23104wM2) obj;
            if (z || c23104wM2.f() != this.b.i0()) {
                arrayList2.add(obj);
            }
        }
        InterfaceC8344Vo3 interfaceC8344Vo3P0 = this.b.W().p0();
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf(((C23104wM2) it.next()).f()));
        }
        interfaceC8344Vo3P0.g(arrayList3).m0(new InterfaceC24449ye1() { // from class: ir.nasim.BP2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj2) {
                C10299bQ2.H2(ua2, this, i2, c12889fL5, z, (List) obj2);
            }
        });
    }

    public final InterfaceC14830iZ0 I3(final int i2, final int i3) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.DO2
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                C10299bQ2.J3(this.a, i2, i3, interfaceC15419jZ0);
            }
        };
    }

    public final C6517Nv5 J1(final int i2, final String str) {
        final long jA = AbstractC19981rG5.a();
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.wP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.K1(this.a, i2, jA, str, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.yP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.L1(this.a, i2, jA, str, (Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final ExPeerType M1(C11458d25 c11458d25) {
        if (c11458d25 == null) {
            return null;
        }
        if (!c11458d25.C()) {
            if (c11458d25.z()) {
                return N1(c11458d25.getPeerId());
            }
            return null;
        }
        OK7 ok7W = this.b.W();
        C21231tK7 c21231tK7 = ok7W != null ? (C21231tK7) ok7W.o0().n(c11458d25.getPeerId()) : null;
        if (c21231tK7 != null) {
            return c21231tK7.n();
        }
        return null;
    }

    public final C6517Nv5 N2(int i2, long j2) {
        C6517Nv5 c6517Nv5M = S1().m(i2, j2);
        AbstractC13042fc3.h(c6517Nv5M, "removeAvatarNew(...)");
        return c6517Nv5M;
    }

    public final List O1(int i2, String str, boolean z) {
        String name;
        String strB0;
        List list;
        if (str == null) {
            C19406qI3.b(this.d, "findMentions query is null!");
            return new ArrayList();
        }
        int length = str.length() - 1;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length) {
            boolean z4 = AbstractC13042fc3.k(str.charAt(!z3 ? i3 : length), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                }
                length--;
            } else if (z4) {
                i3++;
            } else {
                z3 = true;
            }
        }
        String string = str.subSequence(i3, length + 1).toString();
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList(30);
        List listS0 = ((C14697iL2) X1().d(i2)).s0();
        AbstractC13042fc3.h(listS0, "getMembers(...)");
        Object[] array = listS0.toArray(new C23104wM2[0]);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : array) {
            C23104wM2 c23104wM2 = (C23104wM2) obj;
            if (z || c23104wM2.f() != this.b.i0()) {
                arrayList2.add(obj);
            }
        }
        InterfaceC8344Vo3 interfaceC8344Vo3P0 = this.b.W().p0();
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf(((C23104wM2) it.next()).f()));
        }
        List listF = interfaceC8344Vo3P0.f(arrayList3);
        AbstractC13042fc3.f(listF);
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.HP2
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj2, Object obj3) {
                return Integer.valueOf(C10299bQ2.P1((C17637nI7) obj2, (C17637nI7) obj3));
            }
        };
        AbstractC12992fX0.B(listF, new Comparator() { // from class: ir.nasim.JP2
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return C10299bQ2.Q1(interfaceC14603iB2, obj2, obj3);
            }
        });
        for (C17637nI7 c17637nI7 : AbstractC15401jX0.n0(listF)) {
            if (arrayList.size() >= 30) {
                break;
            }
            boolean z5 = c17637nI7.d0() != null ? true : z2;
            if (z5) {
                name = c17637nI7.d0();
                strB0 = c17637nI7.getName();
            } else if (c17637nI7.b0() != null) {
                name = c17637nI7.l0();
                strB0 = c17637nI7.b0();
            } else {
                name = c17637nI7.getName();
                strB0 = null;
            }
            String str2 = name;
            if (lowerCase.length() == 0) {
                int iN0 = c17637nI7.n0();
                if (z5) {
                    str2 = Separators.AT + str2;
                }
                arrayList.add(new Y34(iN0, str2, new ArrayList(), strB0, c17637nI7.d0(), new ArrayList()));
            } else {
                List<QY6> listA = RY6.a(str2, lowerCase);
                if (strB0 != null) {
                    List listA2 = RY6.a(strB0, lowerCase);
                    if (listA.size() > 0 || listA2.size() > 0) {
                        if (z5) {
                            ArrayList arrayList4 = new ArrayList();
                            for (QY6 qy6 : listA) {
                                arrayList4.add(new QY6(qy6.b() + 1, qy6.a()));
                            }
                            list = arrayList4;
                        } else {
                            list = listA;
                        }
                        int iN02 = c17637nI7.n0();
                        if (z5) {
                            str2 = Separators.AT + str2;
                        }
                        arrayList.add(new Y34(iN02, str2, list, strB0, c17637nI7.d0(), listA2));
                    }
                } else if (listA.size() > 0) {
                    arrayList.add(new Y34(c17637nI7.n0(), str2, listA, null, c17637nI7.d0(), null));
                }
                z2 = false;
            }
        }
        return arrayList;
    }

    public final C6517Nv5 O2(int i2, final int i3, final long j2, final long j3) {
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.yO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.P2(this.a, i3, j2, j3, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.zO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.Q2((Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 R2(final int i2, final int i3) {
        C6517Nv5 c6517Nv5H = AbstractC7941Tv5.f(X1().a(i2), this.b.W().p0().a(i3)).H(new InterfaceC17569nB2() { // from class: ir.nasim.uO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.S2(this.a, i2, i3, (C4382Ew7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 T1(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C6517Nv5 c6517Nv5P = e2().p(c11458d25.getPeerId());
        AbstractC13042fc3.h(c6517Nv5P, "getFullGroup(...)");
        return c6517Nv5P;
    }

    public final C6517Nv5 U1(int i2) {
        C6517Nv5 c6517Nv5Q = e2().q(i2);
        AbstractC13042fc3.h(c6517Nv5Q, "getGroupAdmins(...)");
        return c6517Nv5Q;
    }

    public final C6517Nv5 U2(int i2) {
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.QO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.V2(this.a, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.bP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.W2((Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final int V1(int i2) {
        C14697iL2 c14697iL2 = (C14697iL2) X1().d(i2);
        if (c14697iL2 != null) {
            return c14697iL2.p0();
        }
        return 0;
    }

    public final C6517Nv5 W1(int i2, BytesValue bytesValue, int i3) {
        TN2 tn2E2 = e2();
        if (bytesValue == null) {
            bytesValue = BytesValue.getDefaultInstance();
        }
        C6517Nv5 c6517Nv5R = tn2E2.r(i2, bytesValue, i3);
        AbstractC13042fc3.h(c6517Nv5R, "getGroupMembers(...)");
        return c6517Nv5R;
    }

    public final InterfaceC8344Vo3 X1() {
        Object value = this.e.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (InterfaceC8344Vo3) value;
    }

    public final C6517Nv5 X2(int i2, final long j2, final long j3) {
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.TP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.Y2(this.a, j3, j2, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.ZP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.Z2((Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final VL3 Y1() {
        return this.c;
    }

    public final C6517Nv5 Z1(int i2) {
        C6517Nv5 c6517Nv5O = e2().o(i2);
        AbstractC13042fc3.h(c6517Nv5O, "getExceptedMembers(...)");
        return c6517Nv5O;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a2(int r7, final int r8, final int r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof ir.nasim.C10299bQ2.b
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.bQ2$b r0 = (ir.nasim.C10299bQ2.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.bQ2$b r0 = new ir.nasim.bQ2$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
            java.lang.Object r7 = r10.l()
            goto L64
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.Vo3 r10 = r6.X1()
            long r4 = (long) r7
            ir.nasim.Nv5 r7 = r10.a(r4)
            ir.nasim.HO2 r10 = new ir.nasim.HO2
            r10.<init>()
            ir.nasim.Nv5 r7 = r7.H(r10)
            ir.nasim.IO2 r8 = new ir.nasim.IO2
            r8.<init>()
            ir.nasim.Nv5 r7 = r7.H(r8)
            java.lang.String r8 = "flatMap(...)"
            ir.nasim.AbstractC13042fc3.h(r7, r8)
            r0.c = r3
            r8 = 0
            java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r8, r0, r3, r8)
            if (r7 != r1) goto L64
            return r1
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10299bQ2.a2(int, int, int, ir.nasim.rm1):java.lang.Object");
    }

    public final C6517Nv5 a3(final int i2, final int i3) {
        C6517Nv5 c6517Nv5H0 = AbstractC7941Tv5.f(X1().a(i2), this.b.W().p0().a(i3)).H(new InterfaceC17569nB2() { // from class: ir.nasim.gP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.b3(this.a, i2, i3, (C4382Ew7) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.hP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.c3((GroupsOuterClass$ResponseGetMemberPermissions) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C6517Nv5 d3(int i2) {
        C6517Nv5 c6517Nv5H0 = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.DP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.e3(this.a, (C14697iL2) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.EP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.f3((GroupsOuterClass$ResponseInviteUrl) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final TN2 e2() {
        return (TN2) this.g.getValue();
    }

    @Override // ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        AbstractC13042fc3.i(abstractC18385oa2, "event");
        if (abstractC18385oa2 instanceof C18074o25) {
            C2(((C18074o25) abstractC18385oa2).c());
        }
    }

    public final C6517Nv5 g1(String str) {
        AbstractC13042fc3.i(str, "id");
        GeneratedMessageLite generatedMessageLiteA = AdvertisementOuterClass$RequestUpdateClick.newBuilder().B(str).A(1).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        AdvertisementOuterClass$ResponseUpdateView defaultInstance = AdvertisementOuterClass$ResponseUpdateView.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.advertisement.v1.Advertisement/UpdateClick", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.mP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.h1((AdvertisementOuterClass$ResponseUpdateView) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 g3(final int i2, final int i3, final String str, final DA da) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.ZO2
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                C10299bQ2.h3(this.a, i2, i3, str, da, c7234Qv5);
            }
        });
    }

    public final C6517Nv5 i1(String str, C25238zy c25238zy) {
        AbstractC13042fc3.i(str, "id");
        GeneratedMessageLite generatedMessageLiteA = AdvertisementOuterClass$RequestUpdateView.newBuilder().C(c25238zy == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : (PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c25238zy.q()).A(c25238zy.getAccessHash()).a()).A(1).B(str).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        AdvertisementOuterClass$ResponseUpdateView defaultInstance = AdvertisementOuterClass$ResponseUpdateView.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.advertisement.v1.Advertisement/UpdateView", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.FO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.j1((AdvertisementOuterClass$ResponseUpdateView) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 k1(final int i2, final int i3, final int i4) {
        final long jA = AbstractC19981rG5.a();
        C6517Nv5 c6517Nv5H = AbstractC7941Tv5.f(X1().a(i2), this.b.W().p0().a(i3)).H(new InterfaceC17569nB2() { // from class: ir.nasim.wO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.l1(this.a, i2, i3, jA, i4, (C4382Ew7) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.xO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.m1((Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 l3(int i2) {
        C6517Nv5 c6517Nv5H0 = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.SP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.m3(this.a, (C14697iL2) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.UP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.n3((GroupsOuterClass$ResponseInviteUrl) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C6517Nv5 n2(String str) {
        AbstractC13042fc3.i(str, "token");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestJoinGroup.newBuilder().B(str).A(PC.b).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseJoinGroup defaultInstance = GroupsOuterClass$ResponseJoinGroup.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H0 = y(new C22871vx5("/bale.groups.v1.Groups/JoinGroup", generatedMessageLiteA, defaultInstance), 15000L).A(new InterfaceC17569nB2() { // from class: ir.nasim.zP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.o2(this.a, (GroupsOuterClass$ResponseJoinGroup) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.AP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.p2((GroupsOuterClass$ResponseJoinGroup) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final void o1(int i2, String str) {
        S1().k(i2, str);
    }

    public final C6517Nv5 o3(final int i2, final DA da) {
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.aP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.p3(this.a, i2, da, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.cP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.q3((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 p1(final int i2, final W06 w06, final String str) {
        C6517Nv5 c6517Nv5H = X1().a(i2).H(new InterfaceC17569nB2() { // from class: ir.nasim.aQ2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.q1(this.a, w06, str, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.vO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.r1(this.a, i2, w06, (Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 q2(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestJoinPublicGroup.newBuilder().B((PeersStruct$Peer) PeersStruct$Peer.newBuilder().A(c11458d25.getPeerId()).B(C18732p92.s(c11458d25.s())).a()).A(PC.b).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseJoinGroup defaultInstance = GroupsOuterClass$ResponseJoinGroup.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H0 = x(new C22871vx5("/bale.groups.v1.Groups/JoinPublicGroup", generatedMessageLiteA, defaultInstance)).A(new InterfaceC17569nB2() { // from class: ir.nasim.PP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.r2(this.a, (GroupsOuterClass$ResponseJoinGroup) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.QP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.s2((GroupsOuterClass$ResponseJoinGroup) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C6517Nv5 r3(final int i2, final int i3, final DA da) {
        C6517Nv5 c6517Nv5H = AbstractC7941Tv5.f(X1().a(i2), this.b.W().p0().a(i3)).H(new InterfaceC17569nB2() { // from class: ir.nasim.NO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.s3(this.a, i2, i3, da, (C4382Ew7) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.OO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.t3((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final void s1() {
        e2().l();
    }

    public final C6517Nv5 t1(final String str, final String str2, final String str3, final Integer[] numArr, final ZN2 zn2, final BB bb) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(numArr, "uids");
        final long jA = AbstractC19981rG5.a();
        C6517Nv5 c6517Nv5M0 = C6517Nv5.l0(numArr).A(new InterfaceC17569nB2() { // from class: ir.nasim.RO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.C1(this.a, numArr, (Integer[]) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.SO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.u1(this.a, numArr, (Integer[]) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.TO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.v1(this.a, jA, str, zn2, str2, bb, (List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.UO2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.w1(this.a, (Exception) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.VO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.x1(this.a, (GroupsOuterClass$ResponseCreateGroup) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.WO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.y1(this.a, jA, (GroupsOuterClass$ResponseCreateGroup) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.XO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.A1(this.a, (GroupsOuterClass$ResponseCreateGroup) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.YO2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.B1(this.a, str3, (C17428mw7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    public final C6517Nv5 t2(final int i2, final int i3) {
        final long jA = AbstractC19981rG5.a();
        C6517Nv5 c6517Nv5H = AbstractC7941Tv5.f(X1().a(i2), this.b.W().p0().a(i3)).H(new InterfaceC17569nB2() { // from class: ir.nasim.AO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.u2(this.a, i2, jA, i3, (C4382Ew7) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.BO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.v2((Misc$ResponseSeqDate) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 u3(final int i2, final int i3, final String str) {
        AbstractC13042fc3.i(str, "name");
        GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestSetMemberCustomTitle.newBuilder().A(i2).B(i3).C(AbstractC20762sZ6.n1(str).toString()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GroupsOuterClass$ResponseSetMemberCustomTitle defaultInstance = GroupsOuterClass$ResponseSetMemberCustomTitle.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.groups.v1.Groups/SetMemberCustomTitle", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.EO2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10299bQ2.v3(this.a, i2, i3, str, (GroupsOuterClass$ResponseSetMemberCustomTitle) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.GO2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.x3((GroupsOuterClass$ResponseSetMemberCustomTitle) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 w2(int i2) {
        C6517Nv5 c6517Nv5J;
        C22508vM2 c22508vM2 = this.h;
        if (c22508vM2 != null && (c6517Nv5J = c22508vM2.j(C11458d25.y(i2))) != null) {
            return c6517Nv5J;
        }
        C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("groupLeaveActorInt is null"));
        AbstractC13042fc3.h(c6517Nv5F, "failure(...)");
        return c6517Nv5F;
    }

    public final C6517Nv5 x2(final int i2) {
        C6517Nv5 c6517Nv5H0 = X1().a(i2).h0(new InterfaceC17569nB2() { // from class: ir.nasim.qP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.y2((C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.rP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.z2(this.a, i2, (Long) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.sP2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C10299bQ2.A2((GroupsOuterClass$ResponseLoadGroupAvatars) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final void z3() {
        this.h = new C22508vM2(C12736f7.n().d("actor/groupLeave", new V6() { // from class: ir.nasim.pP2
            @Override // ir.nasim.V6
            public final K6 create() {
                return C10299bQ2.A3(this.a);
            }
        }));
        this.b.a().h(this, "peer_chat_opened");
    }
}
