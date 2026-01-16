package ir.nasim;

import ai.bale.proto.AbacusOuterClass$UpdateMessageNewReaction;
import ai.bale.proto.AbacusOuterClass$UpdateMessageReactions;
import ai.bale.proto.AbacusOuterClass$UpdateMessageReactionsReadByMe;
import ai.bale.proto.ConfigsOuterClass$UpdateEndpointChanged;
import ai.bale.proto.ConfigsOuterClass$UpdateHashEndpointChanged;
import ai.bale.proto.ConfigsOuterClass$UpdateParameterChanged;
import ai.bale.proto.GroupsOuterClass$UpdateChannelAdTagIdChanged;
import ai.bale.proto.GroupsOuterClass$UpdateChannelAdvertisementTypeChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupAboutChangedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupAvatarChangedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupBecameOrphaned;
import ai.bale.proto.GroupsOuterClass$UpdateGroupDefaultPermissionsChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupExInfoChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupInviteObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMemberAdminChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMemberPermissionsChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMembersCountChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMembersUpdateObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMessagePinned;
import ai.bale.proto.GroupsOuterClass$UpdateGroupNicknameChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupOwnerChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupPinRemoved;
import ai.bale.proto.GroupsOuterClass$UpdateGroupRestrictionChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupTitleChangedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupUserInvitedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupUserKickObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupUserLeaveObsolete;
import ai.bale.proto.ImagesOuterClass$UpdateSavedGifsChanged;
import ai.bale.proto.ImagesOuterClass$UpdateStickerPacksChanged;
import ai.bale.proto.LahzeOuterClass$UpdateEndLive;
import ai.bale.proto.LahzeOuterClass$UpdateStartLive;
import ai.bale.proto.MavizStreamOuterClass$Event;
import ai.bale.proto.MavizStreamOuterClass$WeakEvent;
import ai.bale.proto.MeetOuterClass$UpdateCallAccepted;
import ai.bale.proto.MeetOuterClass$UpdateCallDiscarded;
import ai.bale.proto.MeetOuterClass$UpdateCallEvent;
import ai.bale.proto.MeetOuterClass$UpdateCallJoinRequestAnswered;
import ai.bale.proto.MeetOuterClass$UpdateCallReactionSent;
import ai.bale.proto.MeetOuterClass$UpdateCallReceived;
import ai.bale.proto.MeetOuterClass$UpdateCallStarted;
import ai.bale.proto.MeetOuterClass$UpdateCallUpgraded;
import ai.bale.proto.MeetOuterClass$UpdateGroupCallEnded;
import ai.bale.proto.MeetOuterClass$UpdateGroupCallStarted;
import ai.bale.proto.MeetOuterClass$UpdateMultiPeerCallStarted;
import ai.bale.proto.MeetOuterClass$UpdatePeersStateChanged;
import ai.bale.proto.MessagingOuterClass$UpdateChatClear;
import ai.bale.proto.MessagingOuterClass$UpdateChatDelete;
import ai.bale.proto.MessagingOuterClass$UpdateChatGroupsChanged;
import ai.bale.proto.MessagingOuterClass$UpdateDialogsMarkedAsRead;
import ai.bale.proto.MessagingOuterClass$UpdateDialogsMarkedAsUnread;
import ai.bale.proto.MessagingOuterClass$UpdateDialogsUnpinned;
import ai.bale.proto.MessagingOuterClass$UpdateFolderCreated;
import ai.bale.proto.MessagingOuterClass$UpdateFolderDeleted;
import ai.bale.proto.MessagingOuterClass$UpdateFolderEdited;
import ai.bale.proto.MessagingOuterClass$UpdateFoldersReordered;
import ai.bale.proto.MessagingOuterClass$UpdateMentionReadByMe;
import ai.bale.proto.MessagingOuterClass$UpdateMessage;
import ai.bale.proto.MessagingOuterClass$UpdateMessageContentChanged;
import ai.bale.proto.MessagingOuterClass$UpdateMessageDelete;
import ai.bale.proto.MessagingOuterClass$UpdateMessagePinned;
import ai.bale.proto.MessagingOuterClass$UpdateMessageRead;
import ai.bale.proto.MessagingOuterClass$UpdateMessageReadByMe;
import ai.bale.proto.MessagingOuterClass$UpdateMessageReceived;
import ai.bale.proto.MessagingOuterClass$UpdateMessageSent;
import ai.bale.proto.MessagingOuterClass$UpdateMessages;
import ai.bale.proto.MessagingOuterClass$UpdateMessagesUnPinned;
import ai.bale.proto.MessagingOuterClass$UpdatePinnedDialogsChanged;
import ai.bale.proto.PremiumOuterClass$UpdatePremiumPurchaseStatus;
import ai.bale.proto.PresenceOuterClass$UpdateTyping;
import ai.bale.proto.PresenceOuterClass$UpdateTypingStop;
import ai.bale.proto.PresenceOuterClass$UpdateUserLastSeen;
import ai.bale.proto.PresenceOuterClass$UpdateUserLastSeenUnknown;
import ai.bale.proto.PresenceOuterClass$UpdateUserOffline;
import ai.bale.proto.PresenceOuterClass$UpdateUserOnline;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import ai.bale.proto.TimcheOuterClass$UpdateAskBotReview;
import ai.bale.proto.Turing$UpdateGeneralNotificationMessage;
import ai.bale.proto.Turing$UpdateTranscriptReady;
import ai.bale.proto.UsersOuterClass$UpdateContactRegistered;
import ai.bale.proto.UsersOuterClass$UpdateContactsAdded;
import ai.bale.proto.UsersOuterClass$UpdateContactsRemoved;
import ai.bale.proto.UsersOuterClass$UpdateUserAboutChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserAvatarChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserBlocked;
import ai.bale.proto.UsersOuterClass$UpdateUserBotCommandsChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserContactsChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserDefaultBankAccountChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserDefaultCardNumberChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserDefaultCardNumberRemoved;
import ai.bale.proto.UsersOuterClass$UpdateUserExInfoChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserExtChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserFullExtChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserLocalNameChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserNameChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserNickChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserUnblocked;
import ai.bale.proto.WalletOuterClass$UpdateWalletBalanceUpdated;
import ai.bale.proto.WalletOuterClass$UpdateWalletUpdated;
import ir.nasim.AbstractC14258hd0;

/* renamed from: ir.nasim.kp6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16175kp6 implements InterfaceC14123hO3 {
    private final C23645xG7 A;
    private final TF7 A0;
    private final CF7 A1;
    private final C22459vG7 B;
    private final VF7 B0;
    private final AF7 B1;
    private final C12846fG7 C0;
    private final JF7 C1;
    private final C21195tG7 D;
    private final C14055hG7 D0;
    private final LF7 D1;
    private final C11594dG7 E0;
    private final C24226yF7 E1;
    private final XF7 F0;
    private final C21833uC7 F1;
    private final C15255jG7 G;
    private final ZF7 G0;
    private final HD7 G1;
    private final C16437lG7 H;
    private final C10214bG7 H0;
    private final GF7 H1;
    private final VE7 I0;
    private final C17610nF7 I1;
    private final C18801pG7 J;
    private final TE7 J0;
    private final SE7 K0;
    private final C14028hD7 L0;
    private final C15228jD7 M0;
    private final C16410lD7 N0;
    private final C17592nD7 O0;
    private final C18774pD7 P0;
    private final C21168tD7 Q0;
    private final C24208yD7 R0;
    private final AD7 S0;
    private final CD7 T0;
    private final ED7 U0;
    private final JD7 V0;
    private final LD7 W0;
    private final ND7 X0;
    private final C17619nG7 Y;
    private final TD7 Y0;
    private final C19983rG7 Z;
    private final VD7 Z0;
    private final MF7 a;
    private final XD7 a1;
    private final HE7 b;
    private final ZD7 b1;
    private final FC7 c;
    private final C10196bE7 c1;
    private final HC7 d;
    private final C11576dE7 d1;
    private final JC7 e;
    private final C12828fE7 e1;
    private final LC7 f;
    private final C15237jE7 f1;
    private final NC7 g;
    private final C16419lE7 g1;
    private final RD7 h;
    private final C14037hE7 h1;
    private final PD7 i;
    private final C17601nE7 i1;
    private final PC7 j;
    private final C18783pE7 j1;
    private final RC7 k;
    private final C19965rE7 k1;
    private final TC7 l;
    private final C23627xE7 l1;
    private final C11585dF7 m;
    private final C22441vE7 m1;
    private final ZC7 n;
    private final C21177tE7 n1;
    private final XC7 o;
    private final BE7 o1;
    private final VC7 p;
    private final EE7 p1;
    private final C10187bD7 q;
    private final GE7 q1;
    private final C22432vD7 r;
    private final JE7 r1;
    private final C24811zE7 s;
    private final LE7 s1;
    private final C11567dD7 t;
    private final NE7 t1;
    private final C14046hF7 u;
    private final PE7 u1;
    private final MF7 v;
    private final ZE7 v1;
    private final C12819fD7 w;
    private final XE7 w1;
    private final CG7 x;
    private final C10205bF7 x1;
    private final AG7 y;
    private final C12837fF7 y1;
    private final RF7 z;
    private final PF7 z0;
    private final C16428lF7 z1;

    public C16175kp6(MF7 mf7, HE7 he7, FC7 fc7, HC7 hc7, JC7 jc7, LC7 lc7, NC7 nc7, RD7 rd7, PD7 pd7, PC7 pc7, RC7 rc7, TC7 tc7, C11585dF7 c11585dF7, ZC7 zc7, XC7 xc7, VC7 vc7, C10187bD7 c10187bD7, C22432vD7 c22432vD7, C24811zE7 c24811zE7, C11567dD7 c11567dD7, C14046hF7 c14046hF7, MF7 mf72, C12819fD7 c12819fD7, CG7 cg7, AG7 ag7, RF7 rf7, C23645xG7 c23645xG7, C22459vG7 c22459vG7, C21195tG7 c21195tG7, C15255jG7 c15255jG7, C16437lG7 c16437lG7, C18801pG7 c18801pG7, C17619nG7 c17619nG7, C19983rG7 c19983rG7, PF7 pf7, TF7 tf7, VF7 vf7, C12846fG7 c12846fG7, C14055hG7 c14055hG7, C11594dG7 c11594dG7, XF7 xf7, ZF7 zf7, C10214bG7 c10214bG7, VE7 ve7, TE7 te7, SE7 se7, C14028hD7 c14028hD7, C15228jD7 c15228jD7, C16410lD7 c16410lD7, C17592nD7 c17592nD7, C18774pD7 c18774pD7, C21168tD7 c21168tD7, C24208yD7 c24208yD7, AD7 ad7, CD7 cd7, ED7 ed7, JD7 jd7, LD7 ld7, ND7 nd7, TD7 td7, VD7 vd7, XD7 xd7, ZD7 zd7, C10196bE7 c10196bE7, C11576dE7 c11576dE7, C12828fE7 c12828fE7, C15237jE7 c15237jE7, C16419lE7 c16419lE7, C14037hE7 c14037hE7, C17601nE7 c17601nE7, C18783pE7 c18783pE7, C19965rE7 c19965rE7, C23627xE7 c23627xE7, C22441vE7 c22441vE7, C21177tE7 c21177tE7, BE7 be7, EE7 ee7, GE7 ge7, JE7 je7, LE7 le7, NE7 ne7, PE7 pe7, ZE7 ze7, XE7 xe7, C10205bF7 c10205bF7, C12837fF7 c12837fF7, C16428lF7 c16428lF7, CF7 cf7, AF7 af7, JF7 jf7, LF7 lf7, C24226yF7 c24226yF7, C21833uC7 c21833uC7, HD7 hd7, GF7 gf7, C17610nF7 c17610nF7) {
        AbstractC13042fc3.i(mf7, "aboutChangeMapper");
        AbstractC13042fc3.i(he7, "messageMapper");
        AbstractC13042fc3.i(fc7, "callAcceptedMapper");
        AbstractC13042fc3.i(hc7, "callDiscardedMapper");
        AbstractC13042fc3.i(jc7, "callEventMapper");
        AbstractC13042fc3.i(lc7, "callJoinRequestAnsweredMapper");
        AbstractC13042fc3.i(nc7, "callReactionSentMapper");
        AbstractC13042fc3.i(rd7, "groupCallStartedMapper");
        AbstractC13042fc3.i(pd7, "groupCallEndedMapper");
        AbstractC13042fc3.i(pc7, "callReceivedMapper");
        AbstractC13042fc3.i(rc7, "callStartedMapper");
        AbstractC13042fc3.i(tc7, "callUpgradedMapper");
        AbstractC13042fc3.i(c11585dF7, "multiPeerCallStartedMapper");
        AbstractC13042fc3.i(zc7, "chatClearMapper");
        AbstractC13042fc3.i(xc7, "channelAdvertisementTypeChangedMapper");
        AbstractC13042fc3.i(vc7, "channelAdTagIdChangedMapper");
        AbstractC13042fc3.i(c10187bD7, "chatDeleteMapper");
        AbstractC13042fc3.i(c22432vD7, "endpointChangedMapper");
        AbstractC13042fc3.i(c24811zE7, "hashEndpointChangedMapper");
        AbstractC13042fc3.i(c11567dD7, "chatGroupsChangedMapper");
        AbstractC13042fc3.i(c14046hF7, "peersStateChangedMapper");
        AbstractC13042fc3.i(mf72, "userAboutChangeMapper");
        AbstractC13042fc3.i(c12819fD7, "contactRegisteredMapper");
        AbstractC13042fc3.i(cg7, "walletUpdatedMapper");
        AbstractC13042fc3.i(ag7, "walletBalanceUpdatedMapper");
        AbstractC13042fc3.i(rf7, "userBlockedMapper");
        AbstractC13042fc3.i(c23645xG7, "userUnblockedMapper");
        AbstractC13042fc3.i(c22459vG7, "userOnlineMapper");
        AbstractC13042fc3.i(c21195tG7, "userOfflineMapper");
        AbstractC13042fc3.i(c15255jG7, "userLastSeenMapper");
        AbstractC13042fc3.i(c16437lG7, "userLastSeenUnknownMapper");
        AbstractC13042fc3.i(c18801pG7, "userNameChangedMapper");
        AbstractC13042fc3.i(c17619nG7, "userLocalNameChangedMapper");
        AbstractC13042fc3.i(c19983rG7, "userNickChangedMapper");
        AbstractC13042fc3.i(pf7, "userAvatarChangedMapper");
        AbstractC13042fc3.i(tf7, "userBotCommandsChangedMapper");
        AbstractC13042fc3.i(vf7, "updateUserContactsChangedMapper");
        AbstractC13042fc3.i(c12846fG7, "userExtChangedMapper");
        AbstractC13042fc3.i(c14055hG7, "userFullExtChangedMapper");
        AbstractC13042fc3.i(c11594dG7, "userExInfoChangedMapper");
        AbstractC13042fc3.i(xf7, "userDefaultBankAccountChangedMapper");
        AbstractC13042fc3.i(zf7, "userDefaultCardNumberChangedMapper");
        AbstractC13042fc3.i(c10214bG7, "userDefaultCardNumberRemovedMapper");
        AbstractC13042fc3.i(ve7, "messageReceivedMapper");
        AbstractC13042fc3.i(te7, "messageReadMapper");
        AbstractC13042fc3.i(se7, "messageReadByMeMapper");
        AbstractC13042fc3.i(c14028hD7, "contactsAddedMapper");
        AbstractC13042fc3.i(c15228jD7, "contactsRemovedMapper");
        AbstractC13042fc3.i(c16410lD7, "dialogsMarkedAsReadMapper");
        AbstractC13042fc3.i(c17592nD7, "dialogsMarkedAsUnreadMapper");
        AbstractC13042fc3.i(c18774pD7, "dialogsUnpinnedMapper");
        AbstractC13042fc3.i(c21168tD7, "endLiveMapper");
        AbstractC13042fc3.i(c24208yD7, "folderCreatedMapper");
        AbstractC13042fc3.i(ad7, "folderDeletedMapper");
        AbstractC13042fc3.i(cd7, "folderEditedMapper");
        AbstractC13042fc3.i(ed7, "foldersReorderedMapper");
        AbstractC13042fc3.i(jd7, "groupAboutChangedObsoleteMapper");
        AbstractC13042fc3.i(ld7, "groupAvatarChangedObsoleteMapper");
        AbstractC13042fc3.i(nd7, "groupBecameOrphanedMapper");
        AbstractC13042fc3.i(td7, "groupDefaultPermissionsChangedMapper");
        AbstractC13042fc3.i(vd7, "groupExInfoChangedMapper");
        AbstractC13042fc3.i(xd7, "groupInviteObsoleteMapper");
        AbstractC13042fc3.i(zd7, "groupMemberAdminChangedMapper");
        AbstractC13042fc3.i(c10196bE7, "groupMemberPermissionsChangedMapper");
        AbstractC13042fc3.i(c11576dE7, "groupMembersCountChangedMapper");
        AbstractC13042fc3.i(c12828fE7, "groupMembersUpdateObsoleteMapper");
        AbstractC13042fc3.i(c15237jE7, "groupNicknameChangedMapper");
        AbstractC13042fc3.i(c16419lE7, "groupOwnerChangedMapper");
        AbstractC13042fc3.i(c14037hE7, "groupMessagePinnedMapper");
        AbstractC13042fc3.i(c17601nE7, "groupPinRemovedMapper");
        AbstractC13042fc3.i(c18783pE7, "groupRestrictionChangedMapper");
        AbstractC13042fc3.i(c19965rE7, "groupTitleChangedObsoleteMapper");
        AbstractC13042fc3.i(c23627xE7, "groupUserLeaveObsoleteMapper");
        AbstractC13042fc3.i(c22441vE7, "groupUserKickObsoleteMapper");
        AbstractC13042fc3.i(c21177tE7, "groupUserInvitedObsoleteMapper");
        AbstractC13042fc3.i(be7, "mentionReadByMeMapper");
        AbstractC13042fc3.i(ee7, "messageContentChangedMapper");
        AbstractC13042fc3.i(ge7, "messageDeleteMapper");
        AbstractC13042fc3.i(je7, "messageNewReactionMapper");
        AbstractC13042fc3.i(le7, "messagePinnedMapper");
        AbstractC13042fc3.i(ne7, "messageReactionsMapper");
        AbstractC13042fc3.i(pe7, "messageReactionsReadByMeMapper");
        AbstractC13042fc3.i(ze7, "messagesMapper");
        AbstractC13042fc3.i(xe7, "messageSentMapper");
        AbstractC13042fc3.i(c10205bF7, "messagesUnPinnedMapper");
        AbstractC13042fc3.i(c12837fF7, "parameterChangedMapper");
        AbstractC13042fc3.i(c16428lF7, "pinnedDialogsChangedMapper");
        AbstractC13042fc3.i(cf7, "stickerPacksChangedMapper");
        AbstractC13042fc3.i(af7, "startLiveMapper");
        AbstractC13042fc3.i(jf7, "typingMapper");
        AbstractC13042fc3.i(lf7, "typingStopMapper");
        AbstractC13042fc3.i(c24226yF7, "savedGifsChangedMapper");
        AbstractC13042fc3.i(c21833uC7, "askBotReviewMapper");
        AbstractC13042fc3.i(hd7, "generalNotificationMessageMapper");
        AbstractC13042fc3.i(gf7, "transcriptReadyMapper");
        AbstractC13042fc3.i(c17610nF7, "premiumPurchaseStatusMapper");
        this.a = mf7;
        this.b = he7;
        this.c = fc7;
        this.d = hc7;
        this.e = jc7;
        this.f = lc7;
        this.g = nc7;
        this.h = rd7;
        this.i = pd7;
        this.j = pc7;
        this.k = rc7;
        this.l = tc7;
        this.m = c11585dF7;
        this.n = zc7;
        this.o = xc7;
        this.p = vc7;
        this.q = c10187bD7;
        this.r = c22432vD7;
        this.s = c24811zE7;
        this.t = c11567dD7;
        this.u = c14046hF7;
        this.v = mf72;
        this.w = c12819fD7;
        this.x = cg7;
        this.y = ag7;
        this.z = rf7;
        this.A = c23645xG7;
        this.B = c22459vG7;
        this.D = c21195tG7;
        this.G = c15255jG7;
        this.H = c16437lG7;
        this.J = c18801pG7;
        this.Y = c17619nG7;
        this.Z = c19983rG7;
        this.z0 = pf7;
        this.A0 = tf7;
        this.B0 = vf7;
        this.C0 = c12846fG7;
        this.D0 = c14055hG7;
        this.E0 = c11594dG7;
        this.F0 = xf7;
        this.G0 = zf7;
        this.H0 = c10214bG7;
        this.I0 = ve7;
        this.J0 = te7;
        this.K0 = se7;
        this.L0 = c14028hD7;
        this.M0 = c15228jD7;
        this.N0 = c16410lD7;
        this.O0 = c17592nD7;
        this.P0 = c18774pD7;
        this.Q0 = c21168tD7;
        this.R0 = c24208yD7;
        this.S0 = ad7;
        this.T0 = cd7;
        this.U0 = ed7;
        this.V0 = jd7;
        this.W0 = ld7;
        this.X0 = nd7;
        this.Y0 = td7;
        this.Z0 = vd7;
        this.a1 = xd7;
        this.b1 = zd7;
        this.c1 = c10196bE7;
        this.d1 = c11576dE7;
        this.e1 = c12828fE7;
        this.f1 = c15237jE7;
        this.g1 = c16419lE7;
        this.h1 = c14037hE7;
        this.i1 = c17601nE7;
        this.j1 = c18783pE7;
        this.k1 = c19965rE7;
        this.l1 = c23627xE7;
        this.m1 = c22441vE7;
        this.n1 = c21177tE7;
        this.o1 = be7;
        this.p1 = ee7;
        this.q1 = ge7;
        this.r1 = je7;
        this.s1 = le7;
        this.t1 = ne7;
        this.u1 = pe7;
        this.v1 = ze7;
        this.w1 = xe7;
        this.x1 = c10205bF7;
        this.y1 = c12837fF7;
        this.z1 = c16428lF7;
        this.A1 = cf7;
        this.B1 = af7;
        this.C1 = jf7;
        this.D1 = lf7;
        this.E1 = c24226yF7;
        this.F1 = c21833uC7;
        this.G1 = hd7;
        this.H1 = gf7;
        this.I1 = c17610nF7;
    }

    private final AbstractC20556sC7 d(MavizStreamOuterClass$WeakEvent mavizStreamOuterClass$WeakEvent) {
        if (mavizStreamOuterClass$WeakEvent.hasTyping()) {
            JF7 jf7 = this.C1;
            PresenceOuterClass$UpdateTyping typing = mavizStreamOuterClass$WeakEvent.getTyping();
            AbstractC13042fc3.h(typing, "getTyping(...)");
            return jf7.a(typing);
        }
        if (mavizStreamOuterClass$WeakEvent.hasTypingStop()) {
            LF7 lf7 = this.D1;
            PresenceOuterClass$UpdateTypingStop typingStop = mavizStreamOuterClass$WeakEvent.getTypingStop();
            AbstractC13042fc3.h(typingStop, "getTypingStop(...)");
            return lf7.a(typingStop);
        }
        if (mavizStreamOuterClass$WeakEvent.hasUserOnline()) {
            C22459vG7 c22459vG7 = this.B;
            PresenceOuterClass$UpdateUserOnline userOnline = mavizStreamOuterClass$WeakEvent.getUserOnline();
            AbstractC13042fc3.h(userOnline, "getUserOnline(...)");
            return c22459vG7.a(userOnline);
        }
        if (mavizStreamOuterClass$WeakEvent.hasUserOffline()) {
            C21195tG7 c21195tG7 = this.D;
            PresenceOuterClass$UpdateUserOffline userOffline = mavizStreamOuterClass$WeakEvent.getUserOffline();
            AbstractC13042fc3.h(userOffline, "getUserOffline(...)");
            return c21195tG7.a(userOffline);
        }
        if (mavizStreamOuterClass$WeakEvent.hasUserLastSeen()) {
            C15255jG7 c15255jG7 = this.G;
            PresenceOuterClass$UpdateUserLastSeen userLastSeen = mavizStreamOuterClass$WeakEvent.getUserLastSeen();
            AbstractC13042fc3.h(userLastSeen, "getUserLastSeen(...)");
            return c15255jG7.a(userLastSeen);
        }
        if (mavizStreamOuterClass$WeakEvent.hasUserLastSeenUnknown()) {
            C16437lG7 c16437lG7 = this.H;
            PresenceOuterClass$UpdateUserLastSeenUnknown userLastSeenUnknown = mavizStreamOuterClass$WeakEvent.getUserLastSeenUnknown();
            AbstractC13042fc3.h(userLastSeenUnknown, "getUserLastSeenUnknown(...)");
            return c16437lG7.a(userLastSeenUnknown);
        }
        if (mavizStreamOuterClass$WeakEvent.hasCallReactionSent()) {
            NC7 nc7 = this.g;
            MeetOuterClass$UpdateCallReactionSent callReactionSent = mavizStreamOuterClass$WeakEvent.getCallReactionSent();
            AbstractC13042fc3.h(callReactionSent, "getCallReactionSent(...)");
            return nc7.a(callReactionSent);
        }
        if (mavizStreamOuterClass$WeakEvent.hasMessageReaction()) {
            NE7 ne7 = this.t1;
            AbacusOuterClass$UpdateMessageReactions messageReaction = mavizStreamOuterClass$WeakEvent.getMessageReaction();
            AbstractC13042fc3.h(messageReaction, "getMessageReaction(...)");
            return ne7.a(messageReaction);
        }
        if (mavizStreamOuterClass$WeakEvent.hasThreadMessage()) {
            HE7 he7 = this.b;
            MessagingOuterClass$UpdateMessage threadMessage = mavizStreamOuterClass$WeakEvent.getThreadMessage();
            AbstractC13042fc3.h(threadMessage, "getThreadMessage(...)");
            return he7.a(threadMessage);
        }
        if (mavizStreamOuterClass$WeakEvent.hasThreadEditMessage()) {
            EE7 ee7 = this.p1;
            MessagingOuterClass$UpdateMessageContentChanged threadEditMessage = mavizStreamOuterClass$WeakEvent.getThreadEditMessage();
            AbstractC13042fc3.h(threadEditMessage, "getThreadEditMessage(...)");
            return ee7.a(threadEditMessage);
        }
        if (mavizStreamOuterClass$WeakEvent.hasThreadDeleteMessage()) {
            GE7 ge7 = this.q1;
            MessagingOuterClass$UpdateMessageDelete threadDeleteMessage = mavizStreamOuterClass$WeakEvent.getThreadDeleteMessage();
            AbstractC13042fc3.h(threadDeleteMessage, "getThreadDeleteMessage(...)");
            return ge7.a(threadDeleteMessage);
        }
        if (mavizStreamOuterClass$WeakEvent.hasAskBotReview()) {
            C21833uC7 c21833uC7 = this.F1;
            TimcheOuterClass$UpdateAskBotReview askBotReview = mavizStreamOuterClass$WeakEvent.getAskBotReview();
            AbstractC13042fc3.h(askBotReview, "getAskBotReview(...)");
            return c21833uC7.a(askBotReview);
        }
        if (mavizStreamOuterClass$WeakEvent.hasEndpointChanged()) {
            C22432vD7 c22432vD7 = this.r;
            ConfigsOuterClass$UpdateEndpointChanged endpointChanged = mavizStreamOuterClass$WeakEvent.getEndpointChanged();
            AbstractC13042fc3.h(endpointChanged, "getEndpointChanged(...)");
            return c22432vD7.a(endpointChanged);
        }
        if (!mavizStreamOuterClass$WeakEvent.hasHashEndpointChanged()) {
            return null;
        }
        C24811zE7 c24811zE7 = this.s;
        ConfigsOuterClass$UpdateHashEndpointChanged hashEndpointChanged = mavizStreamOuterClass$WeakEvent.getHashEndpointChanged();
        AbstractC13042fc3.h(hashEndpointChanged, "getHashEndpointChanged(...)");
        return c24811zE7.a(hashEndpointChanged);
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC14258hd0 a(MavizStreamOuterClass$Event mavizStreamOuterClass$Event) {
        AbstractC13042fc3.i(mavizStreamOuterClass$Event, "input");
        if (mavizStreamOuterClass$Event.hasUpdate()) {
            SetUpdatesStruct$ComposedUpdates update = mavizStreamOuterClass$Event.getUpdate();
            int sequence = mavizStreamOuterClass$Event.getSequence();
            int routeId = mavizStreamOuterClass$Event.getRouteId();
            AbstractC13042fc3.f(update);
            AbstractC20556sC7 abstractC20556sC7C = c(update);
            if (abstractC20556sC7C == null) {
                return null;
            }
            return new AbstractC14258hd0.a(sequence, abstractC20556sC7C, new byte[0], routeId);
        }
        if (!mavizStreamOuterClass$Event.hasWeakEvent()) {
            return null;
        }
        MavizStreamOuterClass$WeakEvent weakEvent = mavizStreamOuterClass$Event.getWeakEvent();
        AbstractC13042fc3.f(weakEvent);
        AbstractC20556sC7 abstractC20556sC7D = d(weakEvent);
        if (abstractC20556sC7D == null) {
            return null;
        }
        return new AbstractC14258hd0.b(abstractC20556sC7D, 0L);
    }

    public final AbstractC20556sC7 c(SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        AbstractC13042fc3.i(setUpdatesStruct$ComposedUpdates, "protoUpdate");
        if (setUpdatesStruct$ComposedUpdates.hasUserAboutChanged()) {
            MF7 mf7 = this.a;
            UsersOuterClass$UpdateUserAboutChanged userAboutChanged = setUpdatesStruct$ComposedUpdates.getUserAboutChanged();
            AbstractC13042fc3.h(userAboutChanged, "getUserAboutChanged(...)");
            return mf7.a(userAboutChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessage()) {
            HE7 he7 = this.b;
            MessagingOuterClass$UpdateMessage message = setUpdatesStruct$ComposedUpdates.getMessage();
            AbstractC13042fc3.h(message, "getMessage(...)");
            return he7.a(message);
        }
        if (setUpdatesStruct$ComposedUpdates.hasCallAccepted()) {
            FC7 fc7 = this.c;
            MeetOuterClass$UpdateCallAccepted callAccepted = setUpdatesStruct$ComposedUpdates.getCallAccepted();
            AbstractC13042fc3.h(callAccepted, "getCallAccepted(...)");
            return fc7.a(callAccepted);
        }
        if (setUpdatesStruct$ComposedUpdates.hasCallDiscarded()) {
            HC7 hc7 = this.d;
            MeetOuterClass$UpdateCallDiscarded callDiscarded = setUpdatesStruct$ComposedUpdates.getCallDiscarded();
            AbstractC13042fc3.h(callDiscarded, "getCallDiscarded(...)");
            return hc7.a(callDiscarded);
        }
        if (setUpdatesStruct$ComposedUpdates.hasCallEvent()) {
            JC7 jc7 = this.e;
            MeetOuterClass$UpdateCallEvent callEvent = setUpdatesStruct$ComposedUpdates.getCallEvent();
            AbstractC13042fc3.h(callEvent, "getCallEvent(...)");
            return jc7.a(callEvent);
        }
        if (setUpdatesStruct$ComposedUpdates.hasCallJoinRequestAnswered()) {
            LC7 lc7 = this.f;
            MeetOuterClass$UpdateCallJoinRequestAnswered callJoinRequestAnswered = setUpdatesStruct$ComposedUpdates.getCallJoinRequestAnswered();
            AbstractC13042fc3.h(callJoinRequestAnswered, "getCallJoinRequestAnswered(...)");
            return lc7.a(callJoinRequestAnswered);
        }
        if (setUpdatesStruct$ComposedUpdates.hasCallReactionSent()) {
            NC7 nc7 = this.g;
            MeetOuterClass$UpdateCallReactionSent callReactionSent = setUpdatesStruct$ComposedUpdates.getCallReactionSent();
            AbstractC13042fc3.h(callReactionSent, "getCallReactionSent(...)");
            return nc7.a(callReactionSent);
        }
        if (setUpdatesStruct$ComposedUpdates.hasChatClear()) {
            ZC7 zc7 = this.n;
            MessagingOuterClass$UpdateChatClear chatClear = setUpdatesStruct$ComposedUpdates.getChatClear();
            AbstractC13042fc3.h(chatClear, "getChatClear(...)");
            return zc7.a(chatClear);
        }
        if (setUpdatesStruct$ComposedUpdates.hasChannelAdvertisementTypeChanged()) {
            XC7 xc7 = this.o;
            GroupsOuterClass$UpdateChannelAdvertisementTypeChanged channelAdvertisementTypeChanged = setUpdatesStruct$ComposedUpdates.getChannelAdvertisementTypeChanged();
            AbstractC13042fc3.h(channelAdvertisementTypeChanged, "getChannelAdvertisementTypeChanged(...)");
            return xc7.a(channelAdvertisementTypeChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasChatDelete()) {
            C10187bD7 c10187bD7 = this.q;
            MessagingOuterClass$UpdateChatDelete chatDelete = setUpdatesStruct$ComposedUpdates.getChatDelete();
            AbstractC13042fc3.h(chatDelete, "getChatDelete(...)");
            return c10187bD7.a(chatDelete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasChatGroupsChanged()) {
            C11567dD7 c11567dD7 = this.t;
            MessagingOuterClass$UpdateChatGroupsChanged chatGroupsChanged = setUpdatesStruct$ComposedUpdates.getChatGroupsChanged();
            AbstractC13042fc3.h(chatGroupsChanged, "getChatGroupsChanged(...)");
            return c11567dD7.a(chatGroupsChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupCallStarted()) {
            RD7 rd7 = this.h;
            MeetOuterClass$UpdateGroupCallStarted groupCallStarted = setUpdatesStruct$ComposedUpdates.getGroupCallStarted();
            AbstractC13042fc3.h(groupCallStarted, "getGroupCallStarted(...)");
            return rd7.a(groupCallStarted);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupCallEnded()) {
            PD7 pd7 = this.i;
            MeetOuterClass$UpdateGroupCallEnded groupCallEnded = setUpdatesStruct$ComposedUpdates.getGroupCallEnded();
            AbstractC13042fc3.h(groupCallEnded, "getGroupCallEnded(...)");
            return pd7.a(groupCallEnded);
        }
        if (setUpdatesStruct$ComposedUpdates.hasCallReceived()) {
            PC7 pc7 = this.j;
            MeetOuterClass$UpdateCallReceived callReceived = setUpdatesStruct$ComposedUpdates.getCallReceived();
            AbstractC13042fc3.h(callReceived, "getCallReceived(...)");
            return pc7.a(callReceived);
        }
        if (setUpdatesStruct$ComposedUpdates.hasCallStarted()) {
            RC7 rc7 = this.k;
            MeetOuterClass$UpdateCallStarted callStarted = setUpdatesStruct$ComposedUpdates.getCallStarted();
            AbstractC13042fc3.h(callStarted, "getCallStarted(...)");
            return rc7.a(callStarted);
        }
        if (setUpdatesStruct$ComposedUpdates.hasCallUpgraded()) {
            TC7 tc7 = this.l;
            MeetOuterClass$UpdateCallUpgraded callUpgraded = setUpdatesStruct$ComposedUpdates.getCallUpgraded();
            AbstractC13042fc3.h(callUpgraded, "getCallUpgraded(...)");
            return tc7.a(callUpgraded);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMultiPeerCallStarted()) {
            C11585dF7 c11585dF7 = this.m;
            MeetOuterClass$UpdateMultiPeerCallStarted multiPeerCallStarted = setUpdatesStruct$ComposedUpdates.getMultiPeerCallStarted();
            AbstractC13042fc3.h(multiPeerCallStarted, "getMultiPeerCallStarted(...)");
            return c11585dF7.a(multiPeerCallStarted);
        }
        if (setUpdatesStruct$ComposedUpdates.hasChannelAdTagIdChanged()) {
            VC7 vc7 = this.p;
            GroupsOuterClass$UpdateChannelAdTagIdChanged channelAdTagIdChanged = setUpdatesStruct$ComposedUpdates.getChannelAdTagIdChanged();
            AbstractC13042fc3.h(channelAdTagIdChanged, "getChannelAdTagIdChanged(...)");
            return vc7.a(channelAdTagIdChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasPeersStateChanged()) {
            C14046hF7 c14046hF7 = this.u;
            MeetOuterClass$UpdatePeersStateChanged peersStateChanged = setUpdatesStruct$ComposedUpdates.getPeersStateChanged();
            AbstractC13042fc3.h(peersStateChanged, "getPeersStateChanged(...)");
            return c14046hF7.a(peersStateChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserAboutChanged()) {
            MF7 mf72 = this.v;
            UsersOuterClass$UpdateUserAboutChanged userAboutChanged2 = setUpdatesStruct$ComposedUpdates.getUserAboutChanged();
            AbstractC13042fc3.h(userAboutChanged2, "getUserAboutChanged(...)");
            return mf72.a(userAboutChanged2);
        }
        if (setUpdatesStruct$ComposedUpdates.hasContactRegistered()) {
            C12819fD7 c12819fD7 = this.w;
            UsersOuterClass$UpdateContactRegistered contactRegistered = setUpdatesStruct$ComposedUpdates.getContactRegistered();
            AbstractC13042fc3.h(contactRegistered, "getContactRegistered(...)");
            return c12819fD7.a(contactRegistered);
        }
        if (setUpdatesStruct$ComposedUpdates.hasWalletUpdated()) {
            CG7 cg7 = this.x;
            WalletOuterClass$UpdateWalletUpdated walletUpdated = setUpdatesStruct$ComposedUpdates.getWalletUpdated();
            AbstractC13042fc3.h(walletUpdated, "getWalletUpdated(...)");
            return cg7.a(walletUpdated);
        }
        if (setUpdatesStruct$ComposedUpdates.hasWalletBalanceUpdated()) {
            AG7 ag7 = this.y;
            WalletOuterClass$UpdateWalletBalanceUpdated walletBalanceUpdated = setUpdatesStruct$ComposedUpdates.getWalletBalanceUpdated();
            AbstractC13042fc3.h(walletBalanceUpdated, "getWalletBalanceUpdated(...)");
            return ag7.a(walletBalanceUpdated);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserBlocked()) {
            RF7 rf7 = this.z;
            UsersOuterClass$UpdateUserBlocked userBlocked = setUpdatesStruct$ComposedUpdates.getUserBlocked();
            AbstractC13042fc3.h(userBlocked, "getUserBlocked(...)");
            return rf7.a(userBlocked);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserUnblocked()) {
            C23645xG7 c23645xG7 = this.A;
            UsersOuterClass$UpdateUserUnblocked userUnblocked = setUpdatesStruct$ComposedUpdates.getUserUnblocked();
            AbstractC13042fc3.h(userUnblocked, "getUserUnblocked(...)");
            return c23645xG7.a(userUnblocked);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserOnline()) {
            C22459vG7 c22459vG7 = this.B;
            PresenceOuterClass$UpdateUserOnline userOnline = setUpdatesStruct$ComposedUpdates.getUserOnline();
            AbstractC13042fc3.h(userOnline, "getUserOnline(...)");
            return c22459vG7.a(userOnline);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserOffline()) {
            C21195tG7 c21195tG7 = this.D;
            PresenceOuterClass$UpdateUserOffline userOffline = setUpdatesStruct$ComposedUpdates.getUserOffline();
            AbstractC13042fc3.h(userOffline, "getUserOffline(...)");
            return c21195tG7.a(userOffline);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserLastSeen()) {
            C15255jG7 c15255jG7 = this.G;
            PresenceOuterClass$UpdateUserLastSeen userLastSeen = setUpdatesStruct$ComposedUpdates.getUserLastSeen();
            AbstractC13042fc3.h(userLastSeen, "getUserLastSeen(...)");
            return c15255jG7.a(userLastSeen);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserLastSeenUnknown()) {
            C16437lG7 c16437lG7 = this.H;
            PresenceOuterClass$UpdateUserLastSeenUnknown userLastSeenUnknown = setUpdatesStruct$ComposedUpdates.getUserLastSeenUnknown();
            AbstractC13042fc3.h(userLastSeenUnknown, "getUserLastSeenUnknown(...)");
            return c16437lG7.a(userLastSeenUnknown);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserNameChanged()) {
            C18801pG7 c18801pG7 = this.J;
            UsersOuterClass$UpdateUserNameChanged userNameChanged = setUpdatesStruct$ComposedUpdates.getUserNameChanged();
            AbstractC13042fc3.h(userNameChanged, "getUserNameChanged(...)");
            return c18801pG7.a(userNameChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserLocalNameChanged()) {
            C17619nG7 c17619nG7 = this.Y;
            UsersOuterClass$UpdateUserLocalNameChanged userLocalNameChanged = setUpdatesStruct$ComposedUpdates.getUserLocalNameChanged();
            AbstractC13042fc3.h(userLocalNameChanged, "getUserLocalNameChanged(...)");
            return c17619nG7.a(userLocalNameChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserNickChanged()) {
            C19983rG7 c19983rG7 = this.Z;
            UsersOuterClass$UpdateUserNickChanged userNickChanged = setUpdatesStruct$ComposedUpdates.getUserNickChanged();
            AbstractC13042fc3.h(userNickChanged, "getUserNickChanged(...)");
            return c19983rG7.a(userNickChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserAvatarChanged()) {
            PF7 pf7 = this.z0;
            UsersOuterClass$UpdateUserAvatarChanged userAvatarChanged = setUpdatesStruct$ComposedUpdates.getUserAvatarChanged();
            AbstractC13042fc3.h(userAvatarChanged, "getUserAvatarChanged(...)");
            return pf7.a(userAvatarChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserBotCommandsChanged()) {
            TF7 tf7 = this.A0;
            UsersOuterClass$UpdateUserBotCommandsChanged userBotCommandsChanged = setUpdatesStruct$ComposedUpdates.getUserBotCommandsChanged();
            AbstractC13042fc3.h(userBotCommandsChanged, "getUserBotCommandsChanged(...)");
            return tf7.a(userBotCommandsChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserContactsChanged()) {
            VF7 vf7 = this.B0;
            UsersOuterClass$UpdateUserContactsChanged userContactsChanged = setUpdatesStruct$ComposedUpdates.getUserContactsChanged();
            AbstractC13042fc3.h(userContactsChanged, "getUserContactsChanged(...)");
            return vf7.a(userContactsChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserExtChanged()) {
            C12846fG7 c12846fG7 = this.C0;
            UsersOuterClass$UpdateUserExtChanged userExtChanged = setUpdatesStruct$ComposedUpdates.getUserExtChanged();
            AbstractC13042fc3.h(userExtChanged, "getUserExtChanged(...)");
            return c12846fG7.a(userExtChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserFullExtChanged()) {
            C14055hG7 c14055hG7 = this.D0;
            UsersOuterClass$UpdateUserFullExtChanged userFullExtChanged = setUpdatesStruct$ComposedUpdates.getUserFullExtChanged();
            AbstractC13042fc3.h(userFullExtChanged, "getUserFullExtChanged(...)");
            return c14055hG7.a(userFullExtChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserExInfoChanged()) {
            C11594dG7 c11594dG7 = this.E0;
            UsersOuterClass$UpdateUserExInfoChanged userExInfoChanged = setUpdatesStruct$ComposedUpdates.getUserExInfoChanged();
            AbstractC13042fc3.h(userExInfoChanged, "getUserExInfoChanged(...)");
            return c11594dG7.a(userExInfoChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserDefaultBankAccountChanged()) {
            XF7 xf7 = this.F0;
            UsersOuterClass$UpdateUserDefaultBankAccountChanged userDefaultBankAccountChanged = setUpdatesStruct$ComposedUpdates.getUserDefaultBankAccountChanged();
            AbstractC13042fc3.h(userDefaultBankAccountChanged, "getUserDefaultBankAccountChanged(...)");
            return xf7.a(userDefaultBankAccountChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserDefaultCardNumberChanged()) {
            ZF7 zf7 = this.G0;
            UsersOuterClass$UpdateUserDefaultCardNumberChanged userDefaultCardNumberChanged = setUpdatesStruct$ComposedUpdates.getUserDefaultCardNumberChanged();
            AbstractC13042fc3.h(userDefaultCardNumberChanged, "getUserDefaultCardNumberChanged(...)");
            return zf7.a(userDefaultCardNumberChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasUserDefaultCardNumberRemoved()) {
            C10214bG7 c10214bG7 = this.H0;
            UsersOuterClass$UpdateUserDefaultCardNumberRemoved userDefaultCardNumberRemoved = setUpdatesStruct$ComposedUpdates.getUserDefaultCardNumberRemoved();
            AbstractC13042fc3.h(userDefaultCardNumberRemoved, "getUserDefaultCardNumberRemoved(...)");
            return c10214bG7.a(userDefaultCardNumberRemoved);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessageReceived()) {
            VE7 ve7 = this.I0;
            MessagingOuterClass$UpdateMessageReceived messageReceived = setUpdatesStruct$ComposedUpdates.getMessageReceived();
            AbstractC13042fc3.h(messageReceived, "getMessageReceived(...)");
            return ve7.a(messageReceived);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessageRead()) {
            TE7 te7 = this.J0;
            MessagingOuterClass$UpdateMessageRead messageRead = setUpdatesStruct$ComposedUpdates.getMessageRead();
            AbstractC13042fc3.h(messageRead, "getMessageRead(...)");
            return te7.a(messageRead);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessageReadByMe()) {
            SE7 se7 = this.K0;
            MessagingOuterClass$UpdateMessageReadByMe messageReadByMe = setUpdatesStruct$ComposedUpdates.getMessageReadByMe();
            AbstractC13042fc3.h(messageReadByMe, "getMessageReadByMe(...)");
            return se7.a(messageReadByMe);
        }
        if (setUpdatesStruct$ComposedUpdates.hasContactsAdded()) {
            C14028hD7 c14028hD7 = this.L0;
            UsersOuterClass$UpdateContactsAdded contactsAdded = setUpdatesStruct$ComposedUpdates.getContactsAdded();
            AbstractC13042fc3.h(contactsAdded, "getContactsAdded(...)");
            return c14028hD7.a(contactsAdded);
        }
        if (setUpdatesStruct$ComposedUpdates.hasContactsRemoved()) {
            C15228jD7 c15228jD7 = this.M0;
            UsersOuterClass$UpdateContactsRemoved contactsRemoved = setUpdatesStruct$ComposedUpdates.getContactsRemoved();
            AbstractC13042fc3.h(contactsRemoved, "getContactsRemoved(...)");
            return c15228jD7.a(contactsRemoved);
        }
        if (setUpdatesStruct$ComposedUpdates.hasDialogsMarkedAsRead()) {
            C16410lD7 c16410lD7 = this.N0;
            MessagingOuterClass$UpdateDialogsMarkedAsRead dialogsMarkedAsRead = setUpdatesStruct$ComposedUpdates.getDialogsMarkedAsRead();
            AbstractC13042fc3.h(dialogsMarkedAsRead, "getDialogsMarkedAsRead(...)");
            return c16410lD7.a(dialogsMarkedAsRead);
        }
        if (setUpdatesStruct$ComposedUpdates.hasDialogsMarkedAsUnread()) {
            C17592nD7 c17592nD7 = this.O0;
            MessagingOuterClass$UpdateDialogsMarkedAsUnread dialogsMarkedAsUnread = setUpdatesStruct$ComposedUpdates.getDialogsMarkedAsUnread();
            AbstractC13042fc3.h(dialogsMarkedAsUnread, "getDialogsMarkedAsUnread(...)");
            return c17592nD7.a(dialogsMarkedAsUnread);
        }
        if (setUpdatesStruct$ComposedUpdates.hasDialogsUnpinned()) {
            C18774pD7 c18774pD7 = this.P0;
            MessagingOuterClass$UpdateDialogsUnpinned dialogsUnpinned = setUpdatesStruct$ComposedUpdates.getDialogsUnpinned();
            AbstractC13042fc3.h(dialogsUnpinned, "getDialogsUnpinned(...)");
            return c18774pD7.a(dialogsUnpinned);
        }
        if (setUpdatesStruct$ComposedUpdates.hasEndLive()) {
            C21168tD7 c21168tD7 = this.Q0;
            LahzeOuterClass$UpdateEndLive endLive = setUpdatesStruct$ComposedUpdates.getEndLive();
            AbstractC13042fc3.h(endLive, "getEndLive(...)");
            return c21168tD7.a(endLive);
        }
        if (setUpdatesStruct$ComposedUpdates.hasFolderCreated()) {
            C24208yD7 c24208yD7 = this.R0;
            MessagingOuterClass$UpdateFolderCreated folderCreated = setUpdatesStruct$ComposedUpdates.getFolderCreated();
            AbstractC13042fc3.h(folderCreated, "getFolderCreated(...)");
            return c24208yD7.a(folderCreated);
        }
        if (setUpdatesStruct$ComposedUpdates.hasFolderDeleted()) {
            AD7 ad7 = this.S0;
            MessagingOuterClass$UpdateFolderDeleted folderDeleted = setUpdatesStruct$ComposedUpdates.getFolderDeleted();
            AbstractC13042fc3.h(folderDeleted, "getFolderDeleted(...)");
            return ad7.a(folderDeleted);
        }
        if (setUpdatesStruct$ComposedUpdates.hasFolderEdited()) {
            CD7 cd7 = this.T0;
            MessagingOuterClass$UpdateFolderEdited folderEdited = setUpdatesStruct$ComposedUpdates.getFolderEdited();
            AbstractC13042fc3.h(folderEdited, "getFolderEdited(...)");
            return cd7.a(folderEdited);
        }
        if (setUpdatesStruct$ComposedUpdates.hasFoldersReordered()) {
            ED7 ed7 = this.U0;
            MessagingOuterClass$UpdateFoldersReordered foldersReordered = setUpdatesStruct$ComposedUpdates.getFoldersReordered();
            AbstractC13042fc3.h(foldersReordered, "getFoldersReordered(...)");
            return ed7.a(foldersReordered);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupAboutChangedObsolete()) {
            JD7 jd7 = this.V0;
            GroupsOuterClass$UpdateGroupAboutChangedObsolete groupAboutChangedObsolete = setUpdatesStruct$ComposedUpdates.getGroupAboutChangedObsolete();
            AbstractC13042fc3.h(groupAboutChangedObsolete, "getGroupAboutChangedObsolete(...)");
            return jd7.a(groupAboutChangedObsolete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupAvatarChangedObsolete()) {
            LD7 ld7 = this.W0;
            GroupsOuterClass$UpdateGroupAvatarChangedObsolete groupAvatarChangedObsolete = setUpdatesStruct$ComposedUpdates.getGroupAvatarChangedObsolete();
            AbstractC13042fc3.h(groupAvatarChangedObsolete, "getGroupAvatarChangedObsolete(...)");
            return ld7.a(groupAvatarChangedObsolete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupBecameOrphaned()) {
            ND7 nd7 = this.X0;
            GroupsOuterClass$UpdateGroupBecameOrphaned groupBecameOrphaned = setUpdatesStruct$ComposedUpdates.getGroupBecameOrphaned();
            AbstractC13042fc3.h(groupBecameOrphaned, "getGroupBecameOrphaned(...)");
            return nd7.a(groupBecameOrphaned);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupDefaultPermissionsChanged()) {
            TD7 td7 = this.Y0;
            GroupsOuterClass$UpdateGroupDefaultPermissionsChanged groupDefaultPermissionsChanged = setUpdatesStruct$ComposedUpdates.getGroupDefaultPermissionsChanged();
            AbstractC13042fc3.h(groupDefaultPermissionsChanged, "getGroupDefaultPermissionsChanged(...)");
            return td7.a(groupDefaultPermissionsChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupExInfoChanged()) {
            VD7 vd7 = this.Z0;
            GroupsOuterClass$UpdateGroupExInfoChanged groupExInfoChanged = setUpdatesStruct$ComposedUpdates.getGroupExInfoChanged();
            AbstractC13042fc3.h(groupExInfoChanged, "getGroupExInfoChanged(...)");
            return vd7.a(groupExInfoChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupInviteObsolete()) {
            XD7 xd7 = this.a1;
            GroupsOuterClass$UpdateGroupInviteObsolete groupInviteObsolete = setUpdatesStruct$ComposedUpdates.getGroupInviteObsolete();
            AbstractC13042fc3.h(groupInviteObsolete, "getGroupInviteObsolete(...)");
            return xd7.a(groupInviteObsolete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupMemberAdminChanged()) {
            ZD7 zd7 = this.b1;
            GroupsOuterClass$UpdateGroupMemberAdminChanged groupMemberAdminChanged = setUpdatesStruct$ComposedUpdates.getGroupMemberAdminChanged();
            AbstractC13042fc3.h(groupMemberAdminChanged, "getGroupMemberAdminChanged(...)");
            return zd7.a(groupMemberAdminChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupMemberPermissionsChanged()) {
            C10196bE7 c10196bE7 = this.c1;
            GroupsOuterClass$UpdateGroupMemberPermissionsChanged groupMemberPermissionsChanged = setUpdatesStruct$ComposedUpdates.getGroupMemberPermissionsChanged();
            AbstractC13042fc3.h(groupMemberPermissionsChanged, "getGroupMemberPermissionsChanged(...)");
            return c10196bE7.a(groupMemberPermissionsChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupMembersCountChanged()) {
            C11576dE7 c11576dE7 = this.d1;
            GroupsOuterClass$UpdateGroupMembersCountChanged groupMembersCountChanged = setUpdatesStruct$ComposedUpdates.getGroupMembersCountChanged();
            AbstractC13042fc3.h(groupMembersCountChanged, "getGroupMembersCountChanged(...)");
            return c11576dE7.a(groupMembersCountChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupMembersUpdateObsolete()) {
            C12828fE7 c12828fE7 = this.e1;
            GroupsOuterClass$UpdateGroupMembersUpdateObsolete groupMembersUpdateObsolete = setUpdatesStruct$ComposedUpdates.getGroupMembersUpdateObsolete();
            AbstractC13042fc3.h(groupMembersUpdateObsolete, "getGroupMembersUpdateObsolete(...)");
            return c12828fE7.a(groupMembersUpdateObsolete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupNicknameChanged()) {
            C15237jE7 c15237jE7 = this.f1;
            GroupsOuterClass$UpdateGroupNicknameChanged groupNicknameChanged = setUpdatesStruct$ComposedUpdates.getGroupNicknameChanged();
            AbstractC13042fc3.h(groupNicknameChanged, "getGroupNicknameChanged(...)");
            return c15237jE7.a(groupNicknameChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupOwnerChanged()) {
            C16419lE7 c16419lE7 = this.g1;
            GroupsOuterClass$UpdateGroupOwnerChanged groupOwnerChanged = setUpdatesStruct$ComposedUpdates.getGroupOwnerChanged();
            AbstractC13042fc3.h(groupOwnerChanged, "getGroupOwnerChanged(...)");
            return c16419lE7.a(groupOwnerChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupMessagePinned()) {
            C14037hE7 c14037hE7 = this.h1;
            GroupsOuterClass$UpdateGroupMessagePinned groupMessagePinned = setUpdatesStruct$ComposedUpdates.getGroupMessagePinned();
            AbstractC13042fc3.h(groupMessagePinned, "getGroupMessagePinned(...)");
            return c14037hE7.a(groupMessagePinned);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupPinRemoved()) {
            C17601nE7 c17601nE7 = this.i1;
            GroupsOuterClass$UpdateGroupPinRemoved groupPinRemoved = setUpdatesStruct$ComposedUpdates.getGroupPinRemoved();
            AbstractC13042fc3.h(groupPinRemoved, "getGroupPinRemoved(...)");
            return c17601nE7.a(groupPinRemoved);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupRestrictionChanged()) {
            C18783pE7 c18783pE7 = this.j1;
            GroupsOuterClass$UpdateGroupRestrictionChanged groupRestrictionChanged = setUpdatesStruct$ComposedUpdates.getGroupRestrictionChanged();
            AbstractC13042fc3.h(groupRestrictionChanged, "getGroupRestrictionChanged(...)");
            return c18783pE7.a(groupRestrictionChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupTitleChangedObsolete()) {
            C19965rE7 c19965rE7 = this.k1;
            GroupsOuterClass$UpdateGroupTitleChangedObsolete groupTitleChangedObsolete = setUpdatesStruct$ComposedUpdates.getGroupTitleChangedObsolete();
            AbstractC13042fc3.h(groupTitleChangedObsolete, "getGroupTitleChangedObsolete(...)");
            return c19965rE7.a(groupTitleChangedObsolete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupUserLeaveObsolete()) {
            C23627xE7 c23627xE7 = this.l1;
            GroupsOuterClass$UpdateGroupUserLeaveObsolete groupUserLeaveObsolete = setUpdatesStruct$ComposedUpdates.getGroupUserLeaveObsolete();
            AbstractC13042fc3.h(groupUserLeaveObsolete, "getGroupUserLeaveObsolete(...)");
            return c23627xE7.a(groupUserLeaveObsolete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupUserKickObsolete()) {
            C22441vE7 c22441vE7 = this.m1;
            GroupsOuterClass$UpdateGroupUserKickObsolete groupUserKickObsolete = setUpdatesStruct$ComposedUpdates.getGroupUserKickObsolete();
            AbstractC13042fc3.h(groupUserKickObsolete, "getGroupUserKickObsolete(...)");
            return c22441vE7.a(groupUserKickObsolete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGroupUserInvitedObsolete()) {
            C21177tE7 c21177tE7 = this.n1;
            GroupsOuterClass$UpdateGroupUserInvitedObsolete groupUserInvitedObsolete = setUpdatesStruct$ComposedUpdates.getGroupUserInvitedObsolete();
            AbstractC13042fc3.h(groupUserInvitedObsolete, "getGroupUserInvitedObsolete(...)");
            return c21177tE7.a(groupUserInvitedObsolete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMentionReadByMe()) {
            BE7 be7 = this.o1;
            MessagingOuterClass$UpdateMentionReadByMe mentionReadByMe = setUpdatesStruct$ComposedUpdates.getMentionReadByMe();
            AbstractC13042fc3.h(mentionReadByMe, "getMentionReadByMe(...)");
            return be7.a(mentionReadByMe);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessageContentChanged()) {
            EE7 ee7 = this.p1;
            MessagingOuterClass$UpdateMessageContentChanged messageContentChanged = setUpdatesStruct$ComposedUpdates.getMessageContentChanged();
            AbstractC13042fc3.h(messageContentChanged, "getMessageContentChanged(...)");
            return ee7.a(messageContentChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessageDelete()) {
            GE7 ge7 = this.q1;
            MessagingOuterClass$UpdateMessageDelete messageDelete = setUpdatesStruct$ComposedUpdates.getMessageDelete();
            AbstractC13042fc3.h(messageDelete, "getMessageDelete(...)");
            return ge7.a(messageDelete);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessageNewReaction()) {
            JE7 je7 = this.r1;
            AbacusOuterClass$UpdateMessageNewReaction messageNewReaction = setUpdatesStruct$ComposedUpdates.getMessageNewReaction();
            AbstractC13042fc3.h(messageNewReaction, "getMessageNewReaction(...)");
            return je7.a(messageNewReaction);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessagePinned()) {
            LE7 le7 = this.s1;
            MessagingOuterClass$UpdateMessagePinned messagePinned = setUpdatesStruct$ComposedUpdates.getMessagePinned();
            AbstractC13042fc3.h(messagePinned, "getMessagePinned(...)");
            return le7.a(messagePinned);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessageReactionsReadByMe()) {
            PE7 pe7 = this.u1;
            AbacusOuterClass$UpdateMessageReactionsReadByMe messageReactionsReadByMe = setUpdatesStruct$ComposedUpdates.getMessageReactionsReadByMe();
            AbstractC13042fc3.h(messageReactionsReadByMe, "getMessageReactionsReadByMe(...)");
            return pe7.a(messageReactionsReadByMe);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessages()) {
            ZE7 ze7 = this.v1;
            MessagingOuterClass$UpdateMessages messages = setUpdatesStruct$ComposedUpdates.getMessages();
            AbstractC13042fc3.h(messages, "getMessages(...)");
            return ze7.a(messages);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessageSent()) {
            XE7 xe7 = this.w1;
            MessagingOuterClass$UpdateMessageSent messageSent = setUpdatesStruct$ComposedUpdates.getMessageSent();
            AbstractC13042fc3.h(messageSent, "getMessageSent(...)");
            return xe7.a(messageSent);
        }
        if (setUpdatesStruct$ComposedUpdates.hasMessagesUnPinned()) {
            C10205bF7 c10205bF7 = this.x1;
            MessagingOuterClass$UpdateMessagesUnPinned messagesUnPinned = setUpdatesStruct$ComposedUpdates.getMessagesUnPinned();
            AbstractC13042fc3.h(messagesUnPinned, "getMessagesUnPinned(...)");
            return c10205bF7.a(messagesUnPinned);
        }
        if (setUpdatesStruct$ComposedUpdates.hasParameterChanged()) {
            C12837fF7 c12837fF7 = this.y1;
            ConfigsOuterClass$UpdateParameterChanged parameterChanged = setUpdatesStruct$ComposedUpdates.getParameterChanged();
            AbstractC13042fc3.h(parameterChanged, "getParameterChanged(...)");
            return c12837fF7.a(parameterChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasPinnedDialogsChanged()) {
            C16428lF7 c16428lF7 = this.z1;
            MessagingOuterClass$UpdatePinnedDialogsChanged pinnedDialogsChanged = setUpdatesStruct$ComposedUpdates.getPinnedDialogsChanged();
            AbstractC13042fc3.h(pinnedDialogsChanged, "getPinnedDialogsChanged(...)");
            return c16428lF7.a(pinnedDialogsChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasStickerPacksChanged()) {
            CF7 cf7 = this.A1;
            ImagesOuterClass$UpdateStickerPacksChanged stickerPacksChanged = setUpdatesStruct$ComposedUpdates.getStickerPacksChanged();
            AbstractC13042fc3.h(stickerPacksChanged, "getStickerPacksChanged(...)");
            return cf7.a(stickerPacksChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasStartLive()) {
            AF7 af7 = this.B1;
            LahzeOuterClass$UpdateStartLive startLive = setUpdatesStruct$ComposedUpdates.getStartLive();
            AbstractC13042fc3.h(startLive, "getStartLive(...)");
            return af7.a(startLive);
        }
        if (setUpdatesStruct$ComposedUpdates.hasSavedGifsChanged()) {
            C24226yF7 c24226yF7 = this.E1;
            ImagesOuterClass$UpdateSavedGifsChanged savedGifsChanged = setUpdatesStruct$ComposedUpdates.getSavedGifsChanged();
            AbstractC13042fc3.h(savedGifsChanged, "getSavedGifsChanged(...)");
            return c24226yF7.a(savedGifsChanged);
        }
        if (setUpdatesStruct$ComposedUpdates.hasAskBotReview()) {
            C21833uC7 c21833uC7 = this.F1;
            TimcheOuterClass$UpdateAskBotReview askBotReview = setUpdatesStruct$ComposedUpdates.getAskBotReview();
            AbstractC13042fc3.h(askBotReview, "getAskBotReview(...)");
            return c21833uC7.a(askBotReview);
        }
        if (setUpdatesStruct$ComposedUpdates.hasGeneralNotificationMessage()) {
            HD7 hd7 = this.G1;
            Turing$UpdateGeneralNotificationMessage generalNotificationMessage = setUpdatesStruct$ComposedUpdates.getGeneralNotificationMessage();
            AbstractC13042fc3.h(generalNotificationMessage, "getGeneralNotificationMessage(...)");
            return hd7.a(generalNotificationMessage);
        }
        if (setUpdatesStruct$ComposedUpdates.hasTranscriptReady()) {
            GF7 gf7 = this.H1;
            Turing$UpdateTranscriptReady transcriptReady = setUpdatesStruct$ComposedUpdates.getTranscriptReady();
            AbstractC13042fc3.h(transcriptReady, "getTranscriptReady(...)");
            return gf7.a(transcriptReady);
        }
        if (!setUpdatesStruct$ComposedUpdates.hasPremiumPurchaseStatus()) {
            if (setUpdatesStruct$ComposedUpdates.hasEmptyUpdate()) {
                return C19956rD7.a;
            }
            return null;
        }
        C17610nF7 c17610nF7 = this.I1;
        PremiumOuterClass$UpdatePremiumPurchaseStatus premiumPurchaseStatus = setUpdatesStruct$ComposedUpdates.getPremiumPurchaseStatus();
        AbstractC13042fc3.h(premiumPurchaseStatus, "getPremiumPurchaseStatus(...)");
        return c17610nF7.a(premiumPurchaseStatus);
    }
}
