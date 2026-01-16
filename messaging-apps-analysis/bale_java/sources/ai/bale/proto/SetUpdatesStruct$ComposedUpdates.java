package ai.bale.proto;

import ai.bale.proto.AbacusOuterClass$UpdateMessageNewReaction;
import ai.bale.proto.AbacusOuterClass$UpdateMessageReactions;
import ai.bale.proto.AbacusOuterClass$UpdateMessageReactionsReadByMe;
import ai.bale.proto.AbacusOuterClass$UpdateReactionsUpdate;
import ai.bale.proto.AuthOuterClass$UpdateAccountDeleted;
import ai.bale.proto.BankOuterClass$UpdateRequestBankiAccessFor;
import ai.bale.proto.BankOuterClass$UpdateRequestLogin;
import ai.bale.proto.ConfigsOuterClass$UpdateEndpointChanged;
import ai.bale.proto.ConfigsOuterClass$UpdateParameterChanged;
import ai.bale.proto.GroupsOuterClass$UpdateChannelAdTagIdChanged;
import ai.bale.proto.GroupsOuterClass$UpdateChannelAdvertisementTypeChanged;
import ai.bale.proto.GroupsOuterClass$UpdateChannelNickChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupAboutChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupAboutChangedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupAvatarChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupAvatarChangedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupBecameOrphaned;
import ai.bale.proto.GroupsOuterClass$UpdateGroupCanInviteMembersChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupCanSendMessagesChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupCanViewMembersChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupDefaultPermissionsChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupExInfoChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupExtChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupFullExtChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupHistoryShared;
import ai.bale.proto.GroupsOuterClass$UpdateGroupInviteObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMemberAdminChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMemberChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMemberDiff;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMemberPermissionsChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMembersBecameAsync;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMembersCountChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMembersUpdateObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMembersUpdated;
import ai.bale.proto.GroupsOuterClass$UpdateGroupMessagePinned;
import ai.bale.proto.GroupsOuterClass$UpdateGroupNicknameChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupOwnerChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupPinRemoved;
import ai.bale.proto.GroupsOuterClass$UpdateGroupRestrictionChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupTitleChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupTitleChangedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupTopicChanged;
import ai.bale.proto.GroupsOuterClass$UpdateGroupTopicChangedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupUserInvitedObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupUserKickObsolete;
import ai.bale.proto.GroupsOuterClass$UpdateGroupUserLeaveObsolete;
import ai.bale.proto.ImagesOuterClass$UpdateOwnStickersChanged;
import ai.bale.proto.ImagesOuterClass$UpdateSavedGifsChanged;
import ai.bale.proto.ImagesOuterClass$UpdateStickerCollectionsChanged;
import ai.bale.proto.ImagesOuterClass$UpdateStickerPacksChanged;
import ai.bale.proto.LahzeOuterClass$UpdateEndLive;
import ai.bale.proto.LahzeOuterClass$UpdateStartLive;
import ai.bale.proto.MeetOuterClass$UpdateCallAccepted;
import ai.bale.proto.MeetOuterClass$UpdateCallAction;
import ai.bale.proto.MeetOuterClass$UpdateCallDiscarded;
import ai.bale.proto.MeetOuterClass$UpdateCallEvent;
import ai.bale.proto.MeetOuterClass$UpdateCallJoinRequestAnswered;
import ai.bale.proto.MeetOuterClass$UpdateCallJoinRequestReceived;
import ai.bale.proto.MeetOuterClass$UpdateCallLinkGenerated;
import ai.bale.proto.MeetOuterClass$UpdateCallReactionSent;
import ai.bale.proto.MeetOuterClass$UpdateCallReceived;
import ai.bale.proto.MeetOuterClass$UpdateCallStarted;
import ai.bale.proto.MeetOuterClass$UpdateCallUpgraded;
import ai.bale.proto.MeetOuterClass$UpdateGroupCallEnded;
import ai.bale.proto.MeetOuterClass$UpdateGroupCallStarted;
import ai.bale.proto.MeetOuterClass$UpdateMultiPeerCallStarted;
import ai.bale.proto.MeetOuterClass$UpdatePeersInvited;
import ai.bale.proto.MeetOuterClass$UpdatePeersStateChanged;
import ai.bale.proto.MessagingOuterClass$UpdateCardinalityChanged;
import ai.bale.proto.MessagingOuterClass$UpdateChatArchive;
import ai.bale.proto.MessagingOuterClass$UpdateChatClear;
import ai.bale.proto.MessagingOuterClass$UpdateChatDelete;
import ai.bale.proto.MessagingOuterClass$UpdateChatFavourite;
import ai.bale.proto.MessagingOuterClass$UpdateChatGroupsChanged;
import ai.bale.proto.MessagingOuterClass$UpdateChatShow;
import ai.bale.proto.MessagingOuterClass$UpdateDialogArchiveStatus;
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
import ai.bale.proto.MessagingOuterClass$UpdateMessageDateChanged;
import ai.bale.proto.MessagingOuterClass$UpdateMessageDelete;
import ai.bale.proto.MessagingOuterClass$UpdateMessagePinned;
import ai.bale.proto.MessagingOuterClass$UpdateMessageQuotedChanged;
import ai.bale.proto.MessagingOuterClass$UpdateMessageRead;
import ai.bale.proto.MessagingOuterClass$UpdateMessageReadByMe;
import ai.bale.proto.MessagingOuterClass$UpdateMessageReceived;
import ai.bale.proto.MessagingOuterClass$UpdateMessageSent;
import ai.bale.proto.MessagingOuterClass$UpdateMessages;
import ai.bale.proto.MessagingOuterClass$UpdateMessagesUnPinned;
import ai.bale.proto.MessagingOuterClass$UpdatePinnedDialogsChanged;
import ai.bale.proto.PremiumOuterClass$UpdatePremiumPurchaseStatus;
import ai.bale.proto.PresenceOuterClass$UpdateGroupOnline;
import ai.bale.proto.PresenceOuterClass$UpdateTyping;
import ai.bale.proto.PresenceOuterClass$UpdateTypingStop;
import ai.bale.proto.PresenceOuterClass$UpdateUserLastSeen;
import ai.bale.proto.PresenceOuterClass$UpdateUserLastSeenUnknown;
import ai.bale.proto.PresenceOuterClass$UpdateUserOffline;
import ai.bale.proto.PresenceOuterClass$UpdateUserOnline;
import ai.bale.proto.ReportOuterClass$UpdateHidePrivacyBar;
import ai.bale.proto.Sequence$UpdateEmptyUpdate;
import ai.bale.proto.Sequence$UpdateForceClearCache;
import ai.bale.proto.Sequence$UpdateRawUpdate;
import ai.bale.proto.TimcheOuterClass$UpdateAskBotReview;
import ai.bale.proto.Turing$UpdateGeneralNotificationMessage;
import ai.bale.proto.Turing$UpdateTranscriptReady;
import ai.bale.proto.UsersOuterClass$UpdateContactRegistered;
import ai.bale.proto.UsersOuterClass$UpdateContactsAdded;
import ai.bale.proto.UsersOuterClass$UpdateContactsRemoved;
import ai.bale.proto.UsersOuterClass$UpdatePhoneNumberChanged;
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
import ai.bale.proto.UsersOuterClass$UpdateUserPreferredLanguagesChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserTimeZoneChanged;
import ai.bale.proto.UsersOuterClass$UpdateUserUnblocked;
import ai.bale.proto.VitrineOuterClass$UpdateVitrineChanged;
import ai.bale.proto.WalletOuterClass$UpdateWalletBalanceUpdated;
import ai.bale.proto.WalletOuterClass$UpdateWalletUpdated;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SetUpdatesStruct$ComposedUpdates extends GeneratedMessageLite implements Y1 {
    public static final int ACCOUNT_DELETED_FIELD_NUMBER = 43607;
    public static final int ASK_BOT_REVIEW_FIELD_NUMBER = 54344;
    public static final int CALL_ACCEPTED_FIELD_NUMBER = 52808;
    public static final int CALL_ACTION_FIELD_NUMBER = 54338;
    public static final int CALL_DISCARDED_FIELD_NUMBER = 52809;
    public static final int CALL_EVENT_FIELD_NUMBER = 54324;
    public static final int CALL_JOIN_REQUEST_ANSWERED_FIELD_NUMBER = 52828;
    public static final int CALL_JOIN_REQUEST_RECEIVED_FIELD_NUMBER = 52827;
    public static final int CALL_LINK_GENERATED_FIELD_NUMBER = 52826;
    public static final int CALL_REACTION_SENT_FIELD_NUMBER = 52813;
    public static final int CALL_RECEIVED_FIELD_NUMBER = 52810;
    public static final int CALL_STARTED_FIELD_NUMBER = 52807;
    public static final int CALL_UPGRADED_FIELD_NUMBER = 52816;
    public static final int CARDINALITY_CHANGED_FIELD_NUMBER = 254;
    public static final int CHANNEL_ADVERTISEMENT_TYPE_CHANGED_FIELD_NUMBER = 52801;
    public static final int CHANNEL_AD_TAG_ID_CHANGED_FIELD_NUMBER = 52802;
    public static final int CHANNEL_NICK_CHANGED_FIELD_NUMBER = 2880;
    public static final int CHAT_ARCHIVE_FIELD_NUMBER = 94;
    public static final int CHAT_CLEAR_FIELD_NUMBER = 47;
    public static final int CHAT_DELETE_FIELD_NUMBER = 48;
    public static final int CHAT_FAVOURITE_FIELD_NUMBER = 95;
    public static final int CHAT_GROUPS_CHANGED_FIELD_NUMBER = 1;
    public static final int CHAT_SHOW_FIELD_NUMBER = 93;
    public static final int CONTACTS_ADDED_FIELD_NUMBER = 40;
    public static final int CONTACTS_REMOVED_FIELD_NUMBER = 41;
    public static final int CONTACT_REGISTERED_FIELD_NUMBER = 5;
    private static final SetUpdatesStruct$ComposedUpdates DEFAULT_INSTANCE;
    public static final int DIALOGS_MARKED_AS_READ_FIELD_NUMBER = 54335;
    public static final int DIALOGS_MARKED_AS_UNREAD_FIELD_NUMBER = 54336;
    public static final int DIALOGS_UNPINNED_FIELD_NUMBER = 54339;
    public static final int DIALOG_ARCHIVE_STATUS_FIELD_NUMBER = 54345;
    public static final int EMPTY_UPDATE_FIELD_NUMBER = 85;
    public static final int ENDPOINT_CHANGED_FIELD_NUMBER = 54347;
    public static final int END_LIVE_FIELD_NUMBER = 54329;
    public static final int FOLDERS_REORDERED_FIELD_NUMBER = 54334;
    public static final int FOLDER_CREATED_FIELD_NUMBER = 54332;
    public static final int FOLDER_DELETED_FIELD_NUMBER = 54333;
    public static final int FOLDER_EDITED_FIELD_NUMBER = 54337;
    public static final int FORCE_CLEAR_CACHE_FIELD_NUMBER = 86;
    public static final int GENERAL_NOTIFICATION_MESSAGE_FIELD_NUMBER = 54343;
    public static final int GROUP_ABOUT_CHANGED_FIELD_NUMBER = 2617;
    public static final int GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER = 214;
    public static final int GROUP_AVATAR_CHANGED_FIELD_NUMBER = 2610;
    public static final int GROUP_AVATAR_CHANGED_OBSOLETE_FIELD_NUMBER = 39;
    public static final int GROUP_BECAME_ORPHANED_FIELD_NUMBER = 2628;
    public static final int GROUP_CALL_ENDED_FIELD_NUMBER = 52812;
    public static final int GROUP_CALL_STARTED_FIELD_NUMBER = 52811;
    public static final int GROUP_CAN_INVITE_MEMBERS_CHANGED_FIELD_NUMBER = 2626;
    public static final int GROUP_CAN_SEND_MESSAGES_CHANGED_FIELD_NUMBER = 2624;
    public static final int GROUP_CAN_VIEW_MEMBERS_CHANGED_FIELD_NUMBER = 2625;
    public static final int GROUP_DEFAULT_PERMISSIONS_CHANGED_FIELD_NUMBER = 52805;
    public static final int GROUP_EXT_CHANGED_FIELD_NUMBER = 2613;
    public static final int GROUP_EX_INFO_CHANGED_FIELD_NUMBER = 2865;
    public static final int GROUP_FULL_EXT_CHANGED_FIELD_NUMBER = 2618;
    public static final int GROUP_HISTORY_SHARED_FIELD_NUMBER = 2620;
    public static final int GROUP_INVITE_OBSOLETE_FIELD_NUMBER = 36;
    public static final int GROUP_MEMBERS_BECAME_ASYNC_FIELD_NUMBER = 2615;
    public static final int GROUP_MEMBERS_COUNT_CHANGED_FIELD_NUMBER = 2622;
    public static final int GROUP_MEMBERS_UPDATED_FIELD_NUMBER = 2614;
    public static final int GROUP_MEMBERS_UPDATE_OBSOLETE_FIELD_NUMBER = 44;
    public static final int GROUP_MEMBER_ADMIN_CHANGED_FIELD_NUMBER = 2627;
    public static final int GROUP_MEMBER_CHANGED_FIELD_NUMBER = 2612;
    public static final int GROUP_MEMBER_DIFF_FIELD_NUMBER = 2623;
    public static final int GROUP_MEMBER_PERMISSIONS_CHANGED_FIELD_NUMBER = 52804;
    public static final int GROUP_MESSAGE_PINNED_FIELD_NUMBER = 721;
    public static final int GROUP_NICKNAME_CHANGED_FIELD_NUMBER = 57;
    public static final int GROUP_ONLINE_FIELD_NUMBER = 33;
    public static final int GROUP_OWNER_CHANGED_FIELD_NUMBER = 2619;
    public static final int GROUP_PIN_REMOVED_FIELD_NUMBER = 722;
    public static final int GROUP_RESTRICTION_CHANGED_FIELD_NUMBER = 723;
    public static final int GROUP_TITLE_CHANGED_FIELD_NUMBER = 2609;
    public static final int GROUP_TITLE_CHANGED_OBSOLETE_FIELD_NUMBER = 38;
    public static final int GROUP_TOPIC_CHANGED_FIELD_NUMBER = 2616;
    public static final int GROUP_TOPIC_CHANGED_OBSOLETE_FIELD_NUMBER = 213;
    public static final int GROUP_USER_INVITED_OBSOLETE_FIELD_NUMBER = 21;
    public static final int GROUP_USER_KICK_OBSOLETE_FIELD_NUMBER = 24;
    public static final int GROUP_USER_LEAVE_OBSOLETE_FIELD_NUMBER = 23;
    public static final int HIDE_PRIVACY_BAR_FIELD_NUMBER = 52824;
    public static final int MENTION_READ_BY_ME_FIELD_NUMBER = 52829;
    public static final int MESSAGES_UN_PINNED_FIELD_NUMBER = 54341;
    public static final int MESSAGE_CONTENT_CHANGED_FIELD_NUMBER = 162;
    public static final int MESSAGE_DATE_CHANGED_FIELD_NUMBER = 163;
    public static final int MESSAGE_DELETE_FIELD_NUMBER = 46;
    public static final int MESSAGE_NEW_REACTION_FIELD_NUMBER = 54323;
    public static final int MESSAGE_PINNED_FIELD_NUMBER = 54340;
    public static final int MESSAGE_QUOTED_CHANGED_FIELD_NUMBER = 169;
    public static final int MESSAGE_REACTIONS_FIELD_NUMBER = 52825;
    public static final int MESSAGE_REACTIONS_READ_BY_ME_FIELD_NUMBER = 52832;
    public static final int MESSAGE_READ_BY_ME_FIELD_NUMBER = 50;
    public static final int MESSAGE_READ_FIELD_NUMBER = 19;
    public static final int MESSAGE_RECEIVED_FIELD_NUMBER = 54;
    public static final int MESSAGE_SENT_FIELD_NUMBER = 4;
    public static final int MULTI_PEER_CALL_STARTED_FIELD_NUMBER = 52818;
    public static final int OWN_STICKERS_CHANGED_FIELD_NUMBER = 161;
    public static final int PARAMETER_CHANGED_FIELD_NUMBER = 131;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_INVITED_FIELD_NUMBER = 52817;
    public static final int PEERS_STATE_CHANGED_FIELD_NUMBER = 52819;
    public static final int PHONE_NUMBER_CHANGED_FIELD_NUMBER = 52803;
    public static final int PINNED_DIALOGS_CHANGED_FIELD_NUMBER = 52830;
    public static final int PREMIUM_PURCHASE_STATUS_FIELD_NUMBER = 54346;
    public static final int RAW_UPDATE_FIELD_NUMBER = 80;
    public static final int REACTIONS_UPDATE_FIELD_NUMBER = 222;
    public static final int REQUEST_BANKI_ACCESS_FOR_FIELD_NUMBER = 62398;
    public static final int REQUEST_LOGIN_FIELD_NUMBER = 3897;
    public static final int SAVED_GIFS_CHANGED_FIELD_NUMBER = 52820;
    public static final int START_LIVE_FIELD_NUMBER = 54328;
    public static final int STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER = 164;
    public static final int STICKER_PACKS_CHANGED_FIELD_NUMBER = 52814;
    public static final int TRANSCRIPT_READY_FIELD_NUMBER = 54342;
    public static final int TYPING_FIELD_NUMBER = 6;
    public static final int TYPING_STOP_FIELD_NUMBER = 81;
    public static final int USER_ABOUT_CHANGED_FIELD_NUMBER = 210;
    public static final int USER_AVATAR_CHANGED_FIELD_NUMBER = 16;
    public static final int USER_BLOCKED_FIELD_NUMBER = 2629;
    public static final int USER_BOT_COMMANDS_CHANGED_FIELD_NUMBER = 217;
    public static final int USER_CONTACTS_CHANGED_FIELD_NUMBER = 134;
    public static final int USER_DEFAULT_BANK_ACCOUNT_CHANGED_FIELD_NUMBER = 226;
    public static final int USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER = 227;
    public static final int USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER = 228;
    public static final int USER_EXT_CHANGED_FIELD_NUMBER = 218;
    public static final int USER_EX_INFO_CHANGED_FIELD_NUMBER = 225;
    public static final int USER_FULL_EXT_CHANGED_FIELD_NUMBER = 219;
    public static final int USER_LAST_SEEN_FIELD_NUMBER = 9;
    public static final int USER_LAST_SEEN_UNKNOWN_FIELD_NUMBER = 34;
    public static final int USER_LOCAL_NAME_CHANGED_FIELD_NUMBER = 51;
    public static final int USER_NAME_CHANGED_FIELD_NUMBER = 32;
    public static final int USER_NICK_CHANGED_FIELD_NUMBER = 209;
    public static final int USER_OFFLINE_FIELD_NUMBER = 8;
    public static final int USER_ONLINE_FIELD_NUMBER = 7;
    public static final int USER_PREFERRED_LANGUAGES_CHANGED_FIELD_NUMBER = 212;
    public static final int USER_TIME_ZONE_CHANGED_FIELD_NUMBER = 216;
    public static final int USER_UNBLOCKED_FIELD_NUMBER = 2630;
    public static final int VITRINE_CHANGED_FIELD_NUMBER = 52806;
    public static final int WALLET_BALANCE_UPDATED_FIELD_NUMBER = 62753;
    public static final int WALLET_UPDATED_FIELD_NUMBER = 62732;
    public static final int _MESSAGES_FIELD_NUMBER = 52815;
    public static final int _MESSAGE_FIELD_NUMBER = 55;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements Y1 {
        private a() {
            super(SetUpdatesStruct$ComposedUpdates.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        CHAT_GROUPS_CHANGED(1),
        MESSAGE_SENT(4),
        CONTACT_REGISTERED(5),
        TYPING(6),
        USER_ONLINE(7),
        USER_OFFLINE(8),
        USER_LAST_SEEN(9),
        USER_AVATAR_CHANGED(16),
        MESSAGE_READ(19),
        GROUP_USER_INVITED_OBSOLETE(21),
        GROUP_USER_LEAVE_OBSOLETE(23),
        GROUP_USER_KICK_OBSOLETE(24),
        USER_NAME_CHANGED(32),
        GROUP_ONLINE(33),
        USER_LAST_SEEN_UNKNOWN(34),
        GROUP_INVITE_OBSOLETE(36),
        GROUP_TITLE_CHANGED_OBSOLETE(38),
        GROUP_AVATAR_CHANGED_OBSOLETE(39),
        CONTACTS_ADDED(40),
        CONTACTS_REMOVED(41),
        GROUP_MEMBERS_UPDATE_OBSOLETE(44),
        MESSAGE_DELETE(46),
        CHAT_CLEAR(47),
        CHAT_DELETE(48),
        MESSAGE_READ_BY_ME(50),
        USER_LOCAL_NAME_CHANGED(51),
        MESSAGE_RECEIVED(54),
        _MESSAGE(55),
        GROUP_NICKNAME_CHANGED(57),
        RAW_UPDATE(80),
        TYPING_STOP(81),
        EMPTY_UPDATE(85),
        FORCE_CLEAR_CACHE(86),
        CHAT_SHOW(93),
        CHAT_ARCHIVE(94),
        CHAT_FAVOURITE(95),
        PARAMETER_CHANGED(131),
        USER_CONTACTS_CHANGED(134),
        OWN_STICKERS_CHANGED(SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER),
        MESSAGE_CONTENT_CHANGED(SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER),
        MESSAGE_DATE_CHANGED(SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER),
        STICKER_COLLECTIONS_CHANGED(SetUpdatesStruct$ComposedUpdates.STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER),
        MESSAGE_QUOTED_CHANGED(SetUpdatesStruct$ComposedUpdates.MESSAGE_QUOTED_CHANGED_FIELD_NUMBER),
        USER_NICK_CHANGED(209),
        USER_ABOUT_CHANGED(210),
        USER_PREFERRED_LANGUAGES_CHANGED(212),
        GROUP_TOPIC_CHANGED_OBSOLETE(213),
        GROUP_ABOUT_CHANGED_OBSOLETE(SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER),
        USER_TIME_ZONE_CHANGED(216),
        USER_BOT_COMMANDS_CHANGED(217),
        USER_EXT_CHANGED(218),
        USER_FULL_EXT_CHANGED(219),
        REACTIONS_UPDATE(222),
        USER_EX_INFO_CHANGED(225),
        USER_DEFAULT_BANK_ACCOUNT_CHANGED(226),
        USER_DEFAULT_CARD_NUMBER_CHANGED(SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER),
        USER_DEFAULT_CARD_NUMBER_REMOVED(SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER),
        CARDINALITY_CHANGED(254),
        GROUP_MESSAGE_PINNED(SetUpdatesStruct$ComposedUpdates.GROUP_MESSAGE_PINNED_FIELD_NUMBER),
        GROUP_PIN_REMOVED(SetUpdatesStruct$ComposedUpdates.GROUP_PIN_REMOVED_FIELD_NUMBER),
        GROUP_RESTRICTION_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_RESTRICTION_CHANGED_FIELD_NUMBER),
        GROUP_TITLE_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_TITLE_CHANGED_FIELD_NUMBER),
        GROUP_AVATAR_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_AVATAR_CHANGED_FIELD_NUMBER),
        GROUP_MEMBER_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_MEMBER_CHANGED_FIELD_NUMBER),
        GROUP_EXT_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_EXT_CHANGED_FIELD_NUMBER),
        GROUP_MEMBERS_UPDATED(SetUpdatesStruct$ComposedUpdates.GROUP_MEMBERS_UPDATED_FIELD_NUMBER),
        GROUP_MEMBERS_BECAME_ASYNC(SetUpdatesStruct$ComposedUpdates.GROUP_MEMBERS_BECAME_ASYNC_FIELD_NUMBER),
        GROUP_TOPIC_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_TOPIC_CHANGED_FIELD_NUMBER),
        GROUP_ABOUT_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_FIELD_NUMBER),
        GROUP_FULL_EXT_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_FULL_EXT_CHANGED_FIELD_NUMBER),
        GROUP_OWNER_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_OWNER_CHANGED_FIELD_NUMBER),
        GROUP_HISTORY_SHARED(SetUpdatesStruct$ComposedUpdates.GROUP_HISTORY_SHARED_FIELD_NUMBER),
        GROUP_MEMBERS_COUNT_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_MEMBERS_COUNT_CHANGED_FIELD_NUMBER),
        GROUP_MEMBER_DIFF(SetUpdatesStruct$ComposedUpdates.GROUP_MEMBER_DIFF_FIELD_NUMBER),
        GROUP_CAN_SEND_MESSAGES_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_CAN_SEND_MESSAGES_CHANGED_FIELD_NUMBER),
        GROUP_CAN_VIEW_MEMBERS_CHANGED(2625),
        GROUP_CAN_INVITE_MEMBERS_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_CAN_INVITE_MEMBERS_CHANGED_FIELD_NUMBER),
        GROUP_MEMBER_ADMIN_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_MEMBER_ADMIN_CHANGED_FIELD_NUMBER),
        GROUP_BECAME_ORPHANED(2628),
        USER_BLOCKED(2629),
        USER_UNBLOCKED(SetUpdatesStruct$ComposedUpdates.USER_UNBLOCKED_FIELD_NUMBER),
        GROUP_EX_INFO_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_EX_INFO_CHANGED_FIELD_NUMBER),
        CHANNEL_NICK_CHANGED(SetUpdatesStruct$ComposedUpdates.CHANNEL_NICK_CHANGED_FIELD_NUMBER),
        REQUEST_LOGIN(SetUpdatesStruct$ComposedUpdates.REQUEST_LOGIN_FIELD_NUMBER),
        ACCOUNT_DELETED(SetUpdatesStruct$ComposedUpdates.ACCOUNT_DELETED_FIELD_NUMBER),
        REQUEST_BANKI_ACCESS_FOR(SetUpdatesStruct$ComposedUpdates.REQUEST_BANKI_ACCESS_FOR_FIELD_NUMBER),
        WALLET_UPDATED(SetUpdatesStruct$ComposedUpdates.WALLET_UPDATED_FIELD_NUMBER),
        WALLET_BALANCE_UPDATED(SetUpdatesStruct$ComposedUpdates.WALLET_BALANCE_UPDATED_FIELD_NUMBER),
        CHANNEL_ADVERTISEMENT_TYPE_CHANGED(SetUpdatesStruct$ComposedUpdates.CHANNEL_ADVERTISEMENT_TYPE_CHANGED_FIELD_NUMBER),
        CHANNEL_AD_TAG_ID_CHANGED(SetUpdatesStruct$ComposedUpdates.CHANNEL_AD_TAG_ID_CHANGED_FIELD_NUMBER),
        PHONE_NUMBER_CHANGED(SetUpdatesStruct$ComposedUpdates.PHONE_NUMBER_CHANGED_FIELD_NUMBER),
        GROUP_MEMBER_PERMISSIONS_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_MEMBER_PERMISSIONS_CHANGED_FIELD_NUMBER),
        GROUP_DEFAULT_PERMISSIONS_CHANGED(SetUpdatesStruct$ComposedUpdates.GROUP_DEFAULT_PERMISSIONS_CHANGED_FIELD_NUMBER),
        VITRINE_CHANGED(SetUpdatesStruct$ComposedUpdates.VITRINE_CHANGED_FIELD_NUMBER),
        CALL_STARTED(SetUpdatesStruct$ComposedUpdates.CALL_STARTED_FIELD_NUMBER),
        CALL_ACCEPTED(SetUpdatesStruct$ComposedUpdates.CALL_ACCEPTED_FIELD_NUMBER),
        CALL_DISCARDED(SetUpdatesStruct$ComposedUpdates.CALL_DISCARDED_FIELD_NUMBER),
        CALL_RECEIVED(SetUpdatesStruct$ComposedUpdates.CALL_RECEIVED_FIELD_NUMBER),
        GROUP_CALL_STARTED(SetUpdatesStruct$ComposedUpdates.GROUP_CALL_STARTED_FIELD_NUMBER),
        GROUP_CALL_ENDED(SetUpdatesStruct$ComposedUpdates.GROUP_CALL_ENDED_FIELD_NUMBER),
        CALL_REACTION_SENT(SetUpdatesStruct$ComposedUpdates.CALL_REACTION_SENT_FIELD_NUMBER),
        CALL_LINK_GENERATED(SetUpdatesStruct$ComposedUpdates.CALL_LINK_GENERATED_FIELD_NUMBER),
        STICKER_PACKS_CHANGED(SetUpdatesStruct$ComposedUpdates.STICKER_PACKS_CHANGED_FIELD_NUMBER),
        _MESSAGES(SetUpdatesStruct$ComposedUpdates._MESSAGES_FIELD_NUMBER),
        CALL_UPGRADED(SetUpdatesStruct$ComposedUpdates.CALL_UPGRADED_FIELD_NUMBER),
        PEERS_INVITED(SetUpdatesStruct$ComposedUpdates.PEERS_INVITED_FIELD_NUMBER),
        MULTI_PEER_CALL_STARTED(SetUpdatesStruct$ComposedUpdates.MULTI_PEER_CALL_STARTED_FIELD_NUMBER),
        PEERS_STATE_CHANGED(SetUpdatesStruct$ComposedUpdates.PEERS_STATE_CHANGED_FIELD_NUMBER),
        SAVED_GIFS_CHANGED(SetUpdatesStruct$ComposedUpdates.SAVED_GIFS_CHANGED_FIELD_NUMBER),
        HIDE_PRIVACY_BAR(SetUpdatesStruct$ComposedUpdates.HIDE_PRIVACY_BAR_FIELD_NUMBER),
        MESSAGE_REACTIONS(SetUpdatesStruct$ComposedUpdates.MESSAGE_REACTIONS_FIELD_NUMBER),
        CALL_JOIN_REQUEST_RECEIVED(SetUpdatesStruct$ComposedUpdates.CALL_JOIN_REQUEST_RECEIVED_FIELD_NUMBER),
        CALL_JOIN_REQUEST_ANSWERED(SetUpdatesStruct$ComposedUpdates.CALL_JOIN_REQUEST_ANSWERED_FIELD_NUMBER),
        MENTION_READ_BY_ME(SetUpdatesStruct$ComposedUpdates.MENTION_READ_BY_ME_FIELD_NUMBER),
        PINNED_DIALOGS_CHANGED(SetUpdatesStruct$ComposedUpdates.PINNED_DIALOGS_CHANGED_FIELD_NUMBER),
        MESSAGE_REACTIONS_READ_BY_ME(SetUpdatesStruct$ComposedUpdates.MESSAGE_REACTIONS_READ_BY_ME_FIELD_NUMBER),
        MESSAGE_NEW_REACTION(SetUpdatesStruct$ComposedUpdates.MESSAGE_NEW_REACTION_FIELD_NUMBER),
        CALL_EVENT(SetUpdatesStruct$ComposedUpdates.CALL_EVENT_FIELD_NUMBER),
        START_LIVE(SetUpdatesStruct$ComposedUpdates.START_LIVE_FIELD_NUMBER),
        END_LIVE(SetUpdatesStruct$ComposedUpdates.END_LIVE_FIELD_NUMBER),
        FOLDER_CREATED(SetUpdatesStruct$ComposedUpdates.FOLDER_CREATED_FIELD_NUMBER),
        FOLDER_DELETED(SetUpdatesStruct$ComposedUpdates.FOLDER_DELETED_FIELD_NUMBER),
        FOLDERS_REORDERED(SetUpdatesStruct$ComposedUpdates.FOLDERS_REORDERED_FIELD_NUMBER),
        DIALOGS_MARKED_AS_READ(SetUpdatesStruct$ComposedUpdates.DIALOGS_MARKED_AS_READ_FIELD_NUMBER),
        DIALOGS_MARKED_AS_UNREAD(SetUpdatesStruct$ComposedUpdates.DIALOGS_MARKED_AS_UNREAD_FIELD_NUMBER),
        FOLDER_EDITED(SetUpdatesStruct$ComposedUpdates.FOLDER_EDITED_FIELD_NUMBER),
        CALL_ACTION(SetUpdatesStruct$ComposedUpdates.CALL_ACTION_FIELD_NUMBER),
        DIALOGS_UNPINNED(SetUpdatesStruct$ComposedUpdates.DIALOGS_UNPINNED_FIELD_NUMBER),
        MESSAGE_PINNED(SetUpdatesStruct$ComposedUpdates.MESSAGE_PINNED_FIELD_NUMBER),
        MESSAGES_UN_PINNED(SetUpdatesStruct$ComposedUpdates.MESSAGES_UN_PINNED_FIELD_NUMBER),
        TRANSCRIPT_READY(SetUpdatesStruct$ComposedUpdates.TRANSCRIPT_READY_FIELD_NUMBER),
        GENERAL_NOTIFICATION_MESSAGE(SetUpdatesStruct$ComposedUpdates.GENERAL_NOTIFICATION_MESSAGE_FIELD_NUMBER),
        ASK_BOT_REVIEW(SetUpdatesStruct$ComposedUpdates.ASK_BOT_REVIEW_FIELD_NUMBER),
        DIALOG_ARCHIVE_STATUS(SetUpdatesStruct$ComposedUpdates.DIALOG_ARCHIVE_STATUS_FIELD_NUMBER),
        PREMIUM_PURCHASE_STATUS(SetUpdatesStruct$ComposedUpdates.PREMIUM_PURCHASE_STATUS_FIELD_NUMBER),
        ENDPOINT_CHANGED(SetUpdatesStruct$ComposedUpdates.ENDPOINT_CHANGED_FIELD_NUMBER),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return CHAT_GROUPS_CHANGED;
            }
            if (i == 4) {
                return MESSAGE_SENT;
            }
            if (i == 5) {
                return CONTACT_REGISTERED;
            }
            if (i == 6) {
                return TYPING;
            }
            if (i != 7) {
                if (i == 23) {
                    return GROUP_USER_LEAVE_OBSOLETE;
                }
                if (i == 24) {
                    return GROUP_USER_KICK_OBSOLETE;
                }
                if (i == 50) {
                    return MESSAGE_READ_BY_ME;
                }
                if (i == 51) {
                    return USER_LOCAL_NAME_CHANGED;
                }
                if (i == 54) {
                    return MESSAGE_RECEIVED;
                }
                if (i == 55) {
                    return _MESSAGE;
                }
                if (i == 80) {
                    return RAW_UPDATE;
                }
                if (i == 81) {
                    return TYPING_STOP;
                }
                if (i == 85) {
                    return EMPTY_UPDATE;
                }
                if (i == 86) {
                    return FORCE_CLEAR_CACHE;
                }
                switch (i) {
                    case 7:
                        break;
                    case 8:
                        return USER_OFFLINE;
                    case 9:
                        return USER_LAST_SEEN;
                    case 16:
                        return USER_AVATAR_CHANGED;
                    case 19:
                        return MESSAGE_READ;
                    case 21:
                        return GROUP_USER_INVITED_OBSOLETE;
                    case 36:
                        return GROUP_INVITE_OBSOLETE;
                    case 44:
                        return GROUP_MEMBERS_UPDATE_OBSOLETE;
                    case 57:
                        return GROUP_NICKNAME_CHANGED;
                    case 93:
                        return CHAT_SHOW;
                    case 94:
                        return CHAT_ARCHIVE;
                    case 95:
                        return CHAT_FAVOURITE;
                    case 131:
                        return PARAMETER_CHANGED;
                    case 134:
                        return USER_CONTACTS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER /* 161 */:
                        return OWN_STICKERS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER /* 162 */:
                        return MESSAGE_CONTENT_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER /* 163 */:
                        return MESSAGE_DATE_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER /* 164 */:
                        return STICKER_COLLECTIONS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.MESSAGE_QUOTED_CHANGED_FIELD_NUMBER /* 169 */:
                        return MESSAGE_QUOTED_CHANGED;
                    case 209:
                        return USER_NICK_CHANGED;
                    case 210:
                        return USER_ABOUT_CHANGED;
                    case 212:
                        return USER_PREFERRED_LANGUAGES_CHANGED;
                    case 213:
                        return GROUP_TOPIC_CHANGED_OBSOLETE;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER /* 214 */:
                        return GROUP_ABOUT_CHANGED_OBSOLETE;
                    case 216:
                        return USER_TIME_ZONE_CHANGED;
                    case 217:
                        return USER_BOT_COMMANDS_CHANGED;
                    case 218:
                        return USER_EXT_CHANGED;
                    case 219:
                        return USER_FULL_EXT_CHANGED;
                    case 222:
                        return REACTIONS_UPDATE;
                    case 225:
                        return USER_EX_INFO_CHANGED;
                    case 226:
                        return USER_DEFAULT_BANK_ACCOUNT_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER /* 227 */:
                        return USER_DEFAULT_CARD_NUMBER_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER /* 228 */:
                        return USER_DEFAULT_CARD_NUMBER_REMOVED;
                    case 254:
                        return CARDINALITY_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_MESSAGE_PINNED_FIELD_NUMBER /* 721 */:
                        return GROUP_MESSAGE_PINNED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_PIN_REMOVED_FIELD_NUMBER /* 722 */:
                        return GROUP_PIN_REMOVED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_RESTRICTION_CHANGED_FIELD_NUMBER /* 723 */:
                        return GROUP_RESTRICTION_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_TITLE_CHANGED_FIELD_NUMBER /* 2609 */:
                        return GROUP_TITLE_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_AVATAR_CHANGED_FIELD_NUMBER /* 2610 */:
                        return GROUP_AVATAR_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_MEMBER_CHANGED_FIELD_NUMBER /* 2612 */:
                        return GROUP_MEMBER_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_EXT_CHANGED_FIELD_NUMBER /* 2613 */:
                        return GROUP_EXT_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_MEMBERS_UPDATED_FIELD_NUMBER /* 2614 */:
                        return GROUP_MEMBERS_UPDATED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_MEMBERS_BECAME_ASYNC_FIELD_NUMBER /* 2615 */:
                        return GROUP_MEMBERS_BECAME_ASYNC;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_TOPIC_CHANGED_FIELD_NUMBER /* 2616 */:
                        return GROUP_TOPIC_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_FIELD_NUMBER /* 2617 */:
                        return GROUP_ABOUT_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_FULL_EXT_CHANGED_FIELD_NUMBER /* 2618 */:
                        return GROUP_FULL_EXT_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_OWNER_CHANGED_FIELD_NUMBER /* 2619 */:
                        return GROUP_OWNER_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_HISTORY_SHARED_FIELD_NUMBER /* 2620 */:
                        return GROUP_HISTORY_SHARED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_MEMBERS_COUNT_CHANGED_FIELD_NUMBER /* 2622 */:
                        return GROUP_MEMBERS_COUNT_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_MEMBER_DIFF_FIELD_NUMBER /* 2623 */:
                        return GROUP_MEMBER_DIFF;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_CAN_SEND_MESSAGES_CHANGED_FIELD_NUMBER /* 2624 */:
                        return GROUP_CAN_SEND_MESSAGES_CHANGED;
                    case 2625:
                        return GROUP_CAN_VIEW_MEMBERS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_CAN_INVITE_MEMBERS_CHANGED_FIELD_NUMBER /* 2626 */:
                        return GROUP_CAN_INVITE_MEMBERS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_MEMBER_ADMIN_CHANGED_FIELD_NUMBER /* 2627 */:
                        return GROUP_MEMBER_ADMIN_CHANGED;
                    case 2628:
                        return GROUP_BECAME_ORPHANED;
                    case 2629:
                        return USER_BLOCKED;
                    case SetUpdatesStruct$ComposedUpdates.USER_UNBLOCKED_FIELD_NUMBER /* 2630 */:
                        return USER_UNBLOCKED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_EX_INFO_CHANGED_FIELD_NUMBER /* 2865 */:
                        return GROUP_EX_INFO_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.CHANNEL_NICK_CHANGED_FIELD_NUMBER /* 2880 */:
                        return CHANNEL_NICK_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.REQUEST_LOGIN_FIELD_NUMBER /* 3897 */:
                        return REQUEST_LOGIN;
                    case SetUpdatesStruct$ComposedUpdates.ACCOUNT_DELETED_FIELD_NUMBER /* 43607 */:
                        return ACCOUNT_DELETED;
                    case SetUpdatesStruct$ComposedUpdates.CHANNEL_ADVERTISEMENT_TYPE_CHANGED_FIELD_NUMBER /* 52801 */:
                        return CHANNEL_ADVERTISEMENT_TYPE_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.CHANNEL_AD_TAG_ID_CHANGED_FIELD_NUMBER /* 52802 */:
                        return CHANNEL_AD_TAG_ID_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.PHONE_NUMBER_CHANGED_FIELD_NUMBER /* 52803 */:
                        return PHONE_NUMBER_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_MEMBER_PERMISSIONS_CHANGED_FIELD_NUMBER /* 52804 */:
                        return GROUP_MEMBER_PERMISSIONS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_DEFAULT_PERMISSIONS_CHANGED_FIELD_NUMBER /* 52805 */:
                        return GROUP_DEFAULT_PERMISSIONS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.VITRINE_CHANGED_FIELD_NUMBER /* 52806 */:
                        return VITRINE_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.CALL_STARTED_FIELD_NUMBER /* 52807 */:
                        return CALL_STARTED;
                    case SetUpdatesStruct$ComposedUpdates.CALL_ACCEPTED_FIELD_NUMBER /* 52808 */:
                        return CALL_ACCEPTED;
                    case SetUpdatesStruct$ComposedUpdates.CALL_DISCARDED_FIELD_NUMBER /* 52809 */:
                        return CALL_DISCARDED;
                    case SetUpdatesStruct$ComposedUpdates.CALL_RECEIVED_FIELD_NUMBER /* 52810 */:
                        return CALL_RECEIVED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_CALL_STARTED_FIELD_NUMBER /* 52811 */:
                        return GROUP_CALL_STARTED;
                    case SetUpdatesStruct$ComposedUpdates.GROUP_CALL_ENDED_FIELD_NUMBER /* 52812 */:
                        return GROUP_CALL_ENDED;
                    case SetUpdatesStruct$ComposedUpdates.CALL_REACTION_SENT_FIELD_NUMBER /* 52813 */:
                        return CALL_REACTION_SENT;
                    case SetUpdatesStruct$ComposedUpdates.STICKER_PACKS_CHANGED_FIELD_NUMBER /* 52814 */:
                        return STICKER_PACKS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates._MESSAGES_FIELD_NUMBER /* 52815 */:
                        return _MESSAGES;
                    case SetUpdatesStruct$ComposedUpdates.CALL_UPGRADED_FIELD_NUMBER /* 52816 */:
                        return CALL_UPGRADED;
                    case SetUpdatesStruct$ComposedUpdates.PEERS_INVITED_FIELD_NUMBER /* 52817 */:
                        return PEERS_INVITED;
                    case SetUpdatesStruct$ComposedUpdates.MULTI_PEER_CALL_STARTED_FIELD_NUMBER /* 52818 */:
                        return MULTI_PEER_CALL_STARTED;
                    case SetUpdatesStruct$ComposedUpdates.PEERS_STATE_CHANGED_FIELD_NUMBER /* 52819 */:
                        return PEERS_STATE_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.SAVED_GIFS_CHANGED_FIELD_NUMBER /* 52820 */:
                        return SAVED_GIFS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.HIDE_PRIVACY_BAR_FIELD_NUMBER /* 52824 */:
                        return HIDE_PRIVACY_BAR;
                    case SetUpdatesStruct$ComposedUpdates.MESSAGE_REACTIONS_FIELD_NUMBER /* 52825 */:
                        return MESSAGE_REACTIONS;
                    case SetUpdatesStruct$ComposedUpdates.CALL_LINK_GENERATED_FIELD_NUMBER /* 52826 */:
                        return CALL_LINK_GENERATED;
                    case SetUpdatesStruct$ComposedUpdates.CALL_JOIN_REQUEST_RECEIVED_FIELD_NUMBER /* 52827 */:
                        return CALL_JOIN_REQUEST_RECEIVED;
                    case SetUpdatesStruct$ComposedUpdates.CALL_JOIN_REQUEST_ANSWERED_FIELD_NUMBER /* 52828 */:
                        return CALL_JOIN_REQUEST_ANSWERED;
                    case SetUpdatesStruct$ComposedUpdates.MENTION_READ_BY_ME_FIELD_NUMBER /* 52829 */:
                        return MENTION_READ_BY_ME;
                    case SetUpdatesStruct$ComposedUpdates.PINNED_DIALOGS_CHANGED_FIELD_NUMBER /* 52830 */:
                        return PINNED_DIALOGS_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.MESSAGE_REACTIONS_READ_BY_ME_FIELD_NUMBER /* 52832 */:
                        return MESSAGE_REACTIONS_READ_BY_ME;
                    case SetUpdatesStruct$ComposedUpdates.MESSAGE_NEW_REACTION_FIELD_NUMBER /* 54323 */:
                        return MESSAGE_NEW_REACTION;
                    case SetUpdatesStruct$ComposedUpdates.CALL_EVENT_FIELD_NUMBER /* 54324 */:
                        return CALL_EVENT;
                    case SetUpdatesStruct$ComposedUpdates.START_LIVE_FIELD_NUMBER /* 54328 */:
                        return START_LIVE;
                    case SetUpdatesStruct$ComposedUpdates.END_LIVE_FIELD_NUMBER /* 54329 */:
                        return END_LIVE;
                    case SetUpdatesStruct$ComposedUpdates.FOLDER_CREATED_FIELD_NUMBER /* 54332 */:
                        return FOLDER_CREATED;
                    case SetUpdatesStruct$ComposedUpdates.FOLDER_DELETED_FIELD_NUMBER /* 54333 */:
                        return FOLDER_DELETED;
                    case SetUpdatesStruct$ComposedUpdates.FOLDERS_REORDERED_FIELD_NUMBER /* 54334 */:
                        return FOLDERS_REORDERED;
                    case SetUpdatesStruct$ComposedUpdates.DIALOGS_MARKED_AS_READ_FIELD_NUMBER /* 54335 */:
                        return DIALOGS_MARKED_AS_READ;
                    case SetUpdatesStruct$ComposedUpdates.DIALOGS_MARKED_AS_UNREAD_FIELD_NUMBER /* 54336 */:
                        return DIALOGS_MARKED_AS_UNREAD;
                    case SetUpdatesStruct$ComposedUpdates.FOLDER_EDITED_FIELD_NUMBER /* 54337 */:
                        return FOLDER_EDITED;
                    case SetUpdatesStruct$ComposedUpdates.CALL_ACTION_FIELD_NUMBER /* 54338 */:
                        return CALL_ACTION;
                    case SetUpdatesStruct$ComposedUpdates.DIALOGS_UNPINNED_FIELD_NUMBER /* 54339 */:
                        return DIALOGS_UNPINNED;
                    case SetUpdatesStruct$ComposedUpdates.MESSAGE_PINNED_FIELD_NUMBER /* 54340 */:
                        return MESSAGE_PINNED;
                    case SetUpdatesStruct$ComposedUpdates.MESSAGES_UN_PINNED_FIELD_NUMBER /* 54341 */:
                        return MESSAGES_UN_PINNED;
                    case SetUpdatesStruct$ComposedUpdates.TRANSCRIPT_READY_FIELD_NUMBER /* 54342 */:
                        return TRANSCRIPT_READY;
                    case SetUpdatesStruct$ComposedUpdates.GENERAL_NOTIFICATION_MESSAGE_FIELD_NUMBER /* 54343 */:
                        return GENERAL_NOTIFICATION_MESSAGE;
                    case SetUpdatesStruct$ComposedUpdates.ASK_BOT_REVIEW_FIELD_NUMBER /* 54344 */:
                        return ASK_BOT_REVIEW;
                    case SetUpdatesStruct$ComposedUpdates.DIALOG_ARCHIVE_STATUS_FIELD_NUMBER /* 54345 */:
                        return DIALOG_ARCHIVE_STATUS;
                    case SetUpdatesStruct$ComposedUpdates.PREMIUM_PURCHASE_STATUS_FIELD_NUMBER /* 54346 */:
                        return PREMIUM_PURCHASE_STATUS;
                    case SetUpdatesStruct$ComposedUpdates.ENDPOINT_CHANGED_FIELD_NUMBER /* 54347 */:
                        return ENDPOINT_CHANGED;
                    case SetUpdatesStruct$ComposedUpdates.REQUEST_BANKI_ACCESS_FOR_FIELD_NUMBER /* 62398 */:
                        return REQUEST_BANKI_ACCESS_FOR;
                    case SetUpdatesStruct$ComposedUpdates.WALLET_UPDATED_FIELD_NUMBER /* 62732 */:
                        return WALLET_UPDATED;
                    case SetUpdatesStruct$ComposedUpdates.WALLET_BALANCE_UPDATED_FIELD_NUMBER /* 62753 */:
                        return WALLET_BALANCE_UPDATED;
                    default:
                        switch (i) {
                            case 32:
                                return USER_NAME_CHANGED;
                            case 33:
                                return GROUP_ONLINE;
                            case 34:
                                return USER_LAST_SEEN_UNKNOWN;
                            default:
                                switch (i) {
                                    case 38:
                                        return GROUP_TITLE_CHANGED_OBSOLETE;
                                    case 39:
                                        return GROUP_AVATAR_CHANGED_OBSOLETE;
                                    case 40:
                                        return CONTACTS_ADDED;
                                    case 41:
                                        return CONTACTS_REMOVED;
                                    default:
                                        switch (i) {
                                            case 46:
                                                return MESSAGE_DELETE;
                                            case 47:
                                                return CHAT_CLEAR;
                                            case 48:
                                                return CHAT_DELETE;
                                            default:
                                                return null;
                                        }
                                }
                        }
                }
            }
            return USER_ONLINE;
        }
    }

    static {
        SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates = new SetUpdatesStruct$ComposedUpdates();
        DEFAULT_INSTANCE = setUpdatesStruct$ComposedUpdates;
        GeneratedMessageLite.registerDefaultInstance(SetUpdatesStruct$ComposedUpdates.class, setUpdatesStruct$ComposedUpdates);
    }

    private SetUpdatesStruct$ComposedUpdates() {
    }

    private void clearAccountDeleted() {
        if (this.traitCase_ == 43607) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAskBotReview() {
        if (this.traitCase_ == 54344) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallAccepted() {
        if (this.traitCase_ == 52808) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallAction() {
        if (this.traitCase_ == 54338) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallDiscarded() {
        if (this.traitCase_ == 52809) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallEvent() {
        if (this.traitCase_ == 54324) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallJoinRequestAnswered() {
        if (this.traitCase_ == 52828) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallJoinRequestReceived() {
        if (this.traitCase_ == 52827) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallLinkGenerated() {
        if (this.traitCase_ == 52826) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallReactionSent() {
        if (this.traitCase_ == 52813) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallReceived() {
        if (this.traitCase_ == 52810) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallStarted() {
        if (this.traitCase_ == 52807) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCallUpgraded() {
        if (this.traitCase_ == 52816) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCardinalityChanged() {
        if (this.traitCase_ == 254) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChannelAdTagIdChanged() {
        if (this.traitCase_ == 52802) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChannelAdvertisementTypeChanged() {
        if (this.traitCase_ == 52801) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChannelNickChanged() {
        if (this.traitCase_ == 2880) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChatArchive() {
        if (this.traitCase_ == 94) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChatClear() {
        if (this.traitCase_ == 47) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChatDelete() {
        if (this.traitCase_ == 48) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChatFavourite() {
        if (this.traitCase_ == 95) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChatGroupsChanged() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChatShow() {
        if (this.traitCase_ == 93) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearContactRegistered() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearContactsAdded() {
        if (this.traitCase_ == 40) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearContactsRemoved() {
        if (this.traitCase_ == 41) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDialogArchiveStatus() {
        if (this.traitCase_ == 54345) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDialogsMarkedAsRead() {
        if (this.traitCase_ == 54335) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDialogsMarkedAsUnread() {
        if (this.traitCase_ == 54336) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDialogsUnpinned() {
        if (this.traitCase_ == 54339) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEmptyUpdate() {
        if (this.traitCase_ == 85) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEndLive() {
        if (this.traitCase_ == 54329) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEndpointChanged() {
        if (this.traitCase_ == 54347) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFolderCreated() {
        if (this.traitCase_ == 54332) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFolderDeleted() {
        if (this.traitCase_ == 54333) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFolderEdited() {
        if (this.traitCase_ == 54337) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFoldersReordered() {
        if (this.traitCase_ == 54334) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearForceClearCache() {
        if (this.traitCase_ == 86) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGeneralNotificationMessage() {
        if (this.traitCase_ == 54343) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupAboutChanged() {
        if (this.traitCase_ == 2617) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupAboutChangedObsolete() {
        if (this.traitCase_ == 214) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupAvatarChanged() {
        if (this.traitCase_ == 2610) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupAvatarChangedObsolete() {
        if (this.traitCase_ == 39) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupBecameOrphaned() {
        if (this.traitCase_ == 2628) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupCallEnded() {
        if (this.traitCase_ == 52812) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupCallStarted() {
        if (this.traitCase_ == 52811) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupCanInviteMembersChanged() {
        if (this.traitCase_ == 2626) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupCanSendMessagesChanged() {
        if (this.traitCase_ == 2624) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupCanViewMembersChanged() {
        if (this.traitCase_ == 2625) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupDefaultPermissionsChanged() {
        if (this.traitCase_ == 52805) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupExInfoChanged() {
        if (this.traitCase_ == 2865) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupExtChanged() {
        if (this.traitCase_ == 2613) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupFullExtChanged() {
        if (this.traitCase_ == 2618) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupHistoryShared() {
        if (this.traitCase_ == 2620) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupInviteObsolete() {
        if (this.traitCase_ == 36) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMemberAdminChanged() {
        if (this.traitCase_ == 2627) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMemberChanged() {
        if (this.traitCase_ == 2612) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMemberDiff() {
        if (this.traitCase_ == 2623) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMemberPermissionsChanged() {
        if (this.traitCase_ == 52804) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMembersBecameAsync() {
        if (this.traitCase_ == 2615) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMembersCountChanged() {
        if (this.traitCase_ == 2622) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMembersUpdateObsolete() {
        if (this.traitCase_ == 44) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMembersUpdated() {
        if (this.traitCase_ == 2614) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupMessagePinned() {
        if (this.traitCase_ == 721) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupNicknameChanged() {
        if (this.traitCase_ == 57) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupOnline() {
        if (this.traitCase_ == 33) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupOwnerChanged() {
        if (this.traitCase_ == 2619) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupPinRemoved() {
        if (this.traitCase_ == 722) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupRestrictionChanged() {
        if (this.traitCase_ == 723) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupTitleChanged() {
        if (this.traitCase_ == 2609) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupTitleChangedObsolete() {
        if (this.traitCase_ == 38) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupTopicChanged() {
        if (this.traitCase_ == 2616) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupTopicChangedObsolete() {
        if (this.traitCase_ == 213) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupUserInvitedObsolete() {
        if (this.traitCase_ == 21) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupUserKickObsolete() {
        if (this.traitCase_ == 24) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGroupUserLeaveObsolete() {
        if (this.traitCase_ == 23) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearHidePrivacyBar() {
        if (this.traitCase_ == 52824) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMentionReadByMe() {
        if (this.traitCase_ == 52829) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessage() {
        if (this.traitCase_ == 55) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageContentChanged() {
        if (this.traitCase_ == 162) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageDateChanged() {
        if (this.traitCase_ == 163) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageDelete() {
        if (this.traitCase_ == 46) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageNewReaction() {
        if (this.traitCase_ == 54323) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessagePinned() {
        if (this.traitCase_ == 54340) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageQuotedChanged() {
        if (this.traitCase_ == 169) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageReactions() {
        if (this.traitCase_ == 52825) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageReactionsReadByMe() {
        if (this.traitCase_ == 52832) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageRead() {
        if (this.traitCase_ == 19) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageReadByMe() {
        if (this.traitCase_ == 50) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageReceived() {
        if (this.traitCase_ == 54) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageSent() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessages() {
        if (this.traitCase_ == 52815) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessagesUnPinned() {
        if (this.traitCase_ == 54341) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMultiPeerCallStarted() {
        if (this.traitCase_ == 52818) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearOwnStickersChanged() {
        if (this.traitCase_ == 161) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearParameterChanged() {
        if (this.traitCase_ == 131) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPeersInvited() {
        if (this.traitCase_ == 52817) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPeersStateChanged() {
        if (this.traitCase_ == 52819) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPhoneNumberChanged() {
        if (this.traitCase_ == 52803) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPinnedDialogsChanged() {
        if (this.traitCase_ == 52830) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPremiumPurchaseStatus() {
        if (this.traitCase_ == 54346) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRawUpdate() {
        if (this.traitCase_ == 80) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearReactionsUpdate() {
        if (this.traitCase_ == 222) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRequestBankiAccessFor() {
        if (this.traitCase_ == 62398) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRequestLogin() {
        if (this.traitCase_ == 3897) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSavedGifsChanged() {
        if (this.traitCase_ == 52820) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStartLive() {
        if (this.traitCase_ == 54328) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStickerCollectionsChanged() {
        if (this.traitCase_ == 164) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStickerPacksChanged() {
        if (this.traitCase_ == 52814) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearTranscriptReady() {
        if (this.traitCase_ == 54342) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTyping() {
        if (this.traitCase_ == 6) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTypingStop() {
        if (this.traitCase_ == 81) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserAboutChanged() {
        if (this.traitCase_ == 210) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserAvatarChanged() {
        if (this.traitCase_ == 16) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserBlocked() {
        if (this.traitCase_ == 2629) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserBotCommandsChanged() {
        if (this.traitCase_ == 217) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserContactsChanged() {
        if (this.traitCase_ == 134) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserDefaultBankAccountChanged() {
        if (this.traitCase_ == 226) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserDefaultCardNumberChanged() {
        if (this.traitCase_ == 227) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserDefaultCardNumberRemoved() {
        if (this.traitCase_ == 228) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserExInfoChanged() {
        if (this.traitCase_ == 225) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserExtChanged() {
        if (this.traitCase_ == 218) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserFullExtChanged() {
        if (this.traitCase_ == 219) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserLastSeen() {
        if (this.traitCase_ == 9) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserLastSeenUnknown() {
        if (this.traitCase_ == 34) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserLocalNameChanged() {
        if (this.traitCase_ == 51) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserNameChanged() {
        if (this.traitCase_ == 32) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserNickChanged() {
        if (this.traitCase_ == 209) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserOffline() {
        if (this.traitCase_ == 8) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserOnline() {
        if (this.traitCase_ == 7) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserPreferredLanguagesChanged() {
        if (this.traitCase_ == 212) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserTimeZoneChanged() {
        if (this.traitCase_ == 216) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserUnblocked() {
        if (this.traitCase_ == 2630) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearVitrineChanged() {
        if (this.traitCase_ == 52806) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearWalletBalanceUpdated() {
        if (this.traitCase_ == 62753) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearWalletUpdated() {
        if (this.traitCase_ == 62732) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    public static SetUpdatesStruct$ComposedUpdates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAccountDeleted(AuthOuterClass$UpdateAccountDeleted authOuterClass$UpdateAccountDeleted) {
        authOuterClass$UpdateAccountDeleted.getClass();
        if (this.traitCase_ != 43607 || this.trait_ == AuthOuterClass$UpdateAccountDeleted.getDefaultInstance()) {
            this.trait_ = authOuterClass$UpdateAccountDeleted;
        } else {
            this.trait_ = ((AuthOuterClass$UpdateAccountDeleted.a) AuthOuterClass$UpdateAccountDeleted.newBuilder((AuthOuterClass$UpdateAccountDeleted) this.trait_).v(authOuterClass$UpdateAccountDeleted)).j();
        }
        this.traitCase_ = ACCOUNT_DELETED_FIELD_NUMBER;
    }

    private void mergeAskBotReview(TimcheOuterClass$UpdateAskBotReview timcheOuterClass$UpdateAskBotReview) {
        timcheOuterClass$UpdateAskBotReview.getClass();
        if (this.traitCase_ != 54344 || this.trait_ == TimcheOuterClass$UpdateAskBotReview.getDefaultInstance()) {
            this.trait_ = timcheOuterClass$UpdateAskBotReview;
        } else {
            this.trait_ = ((TimcheOuterClass$UpdateAskBotReview.a) TimcheOuterClass$UpdateAskBotReview.newBuilder((TimcheOuterClass$UpdateAskBotReview) this.trait_).v(timcheOuterClass$UpdateAskBotReview)).j();
        }
        this.traitCase_ = ASK_BOT_REVIEW_FIELD_NUMBER;
    }

    private void mergeCallAccepted(MeetOuterClass$UpdateCallAccepted meetOuterClass$UpdateCallAccepted) {
        meetOuterClass$UpdateCallAccepted.getClass();
        if (this.traitCase_ != 52808 || this.trait_ == MeetOuterClass$UpdateCallAccepted.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallAccepted;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallAccepted.a) MeetOuterClass$UpdateCallAccepted.newBuilder((MeetOuterClass$UpdateCallAccepted) this.trait_).v(meetOuterClass$UpdateCallAccepted)).j();
        }
        this.traitCase_ = CALL_ACCEPTED_FIELD_NUMBER;
    }

    private void mergeCallAction(MeetOuterClass$UpdateCallAction meetOuterClass$UpdateCallAction) {
        meetOuterClass$UpdateCallAction.getClass();
        if (this.traitCase_ != 54338 || this.trait_ == MeetOuterClass$UpdateCallAction.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallAction;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallAction.a) MeetOuterClass$UpdateCallAction.newBuilder((MeetOuterClass$UpdateCallAction) this.trait_).v(meetOuterClass$UpdateCallAction)).j();
        }
        this.traitCase_ = CALL_ACTION_FIELD_NUMBER;
    }

    private void mergeCallDiscarded(MeetOuterClass$UpdateCallDiscarded meetOuterClass$UpdateCallDiscarded) {
        meetOuterClass$UpdateCallDiscarded.getClass();
        if (this.traitCase_ != 52809 || this.trait_ == MeetOuterClass$UpdateCallDiscarded.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallDiscarded;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallDiscarded.a) MeetOuterClass$UpdateCallDiscarded.newBuilder((MeetOuterClass$UpdateCallDiscarded) this.trait_).v(meetOuterClass$UpdateCallDiscarded)).j();
        }
        this.traitCase_ = CALL_DISCARDED_FIELD_NUMBER;
    }

    private void mergeCallEvent(MeetOuterClass$UpdateCallEvent meetOuterClass$UpdateCallEvent) {
        meetOuterClass$UpdateCallEvent.getClass();
        if (this.traitCase_ != 54324 || this.trait_ == MeetOuterClass$UpdateCallEvent.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallEvent;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallEvent.a) MeetOuterClass$UpdateCallEvent.newBuilder((MeetOuterClass$UpdateCallEvent) this.trait_).v(meetOuterClass$UpdateCallEvent)).j();
        }
        this.traitCase_ = CALL_EVENT_FIELD_NUMBER;
    }

    private void mergeCallJoinRequestAnswered(MeetOuterClass$UpdateCallJoinRequestAnswered meetOuterClass$UpdateCallJoinRequestAnswered) {
        meetOuterClass$UpdateCallJoinRequestAnswered.getClass();
        if (this.traitCase_ != 52828 || this.trait_ == MeetOuterClass$UpdateCallJoinRequestAnswered.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallJoinRequestAnswered;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallJoinRequestAnswered.a) MeetOuterClass$UpdateCallJoinRequestAnswered.newBuilder((MeetOuterClass$UpdateCallJoinRequestAnswered) this.trait_).v(meetOuterClass$UpdateCallJoinRequestAnswered)).j();
        }
        this.traitCase_ = CALL_JOIN_REQUEST_ANSWERED_FIELD_NUMBER;
    }

    private void mergeCallJoinRequestReceived(MeetOuterClass$UpdateCallJoinRequestReceived meetOuterClass$UpdateCallJoinRequestReceived) {
        meetOuterClass$UpdateCallJoinRequestReceived.getClass();
        if (this.traitCase_ != 52827 || this.trait_ == MeetOuterClass$UpdateCallJoinRequestReceived.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallJoinRequestReceived;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallJoinRequestReceived.a) MeetOuterClass$UpdateCallJoinRequestReceived.newBuilder((MeetOuterClass$UpdateCallJoinRequestReceived) this.trait_).v(meetOuterClass$UpdateCallJoinRequestReceived)).j();
        }
        this.traitCase_ = CALL_JOIN_REQUEST_RECEIVED_FIELD_NUMBER;
    }

    private void mergeCallLinkGenerated(MeetOuterClass$UpdateCallLinkGenerated meetOuterClass$UpdateCallLinkGenerated) {
        meetOuterClass$UpdateCallLinkGenerated.getClass();
        if (this.traitCase_ != 52826 || this.trait_ == MeetOuterClass$UpdateCallLinkGenerated.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallLinkGenerated;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallLinkGenerated.a) MeetOuterClass$UpdateCallLinkGenerated.newBuilder((MeetOuterClass$UpdateCallLinkGenerated) this.trait_).v(meetOuterClass$UpdateCallLinkGenerated)).j();
        }
        this.traitCase_ = CALL_LINK_GENERATED_FIELD_NUMBER;
    }

    private void mergeCallReactionSent(MeetOuterClass$UpdateCallReactionSent meetOuterClass$UpdateCallReactionSent) {
        meetOuterClass$UpdateCallReactionSent.getClass();
        if (this.traitCase_ != 52813 || this.trait_ == MeetOuterClass$UpdateCallReactionSent.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallReactionSent;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallReactionSent.a) MeetOuterClass$UpdateCallReactionSent.newBuilder((MeetOuterClass$UpdateCallReactionSent) this.trait_).v(meetOuterClass$UpdateCallReactionSent)).j();
        }
        this.traitCase_ = CALL_REACTION_SENT_FIELD_NUMBER;
    }

    private void mergeCallReceived(MeetOuterClass$UpdateCallReceived meetOuterClass$UpdateCallReceived) {
        meetOuterClass$UpdateCallReceived.getClass();
        if (this.traitCase_ != 52810 || this.trait_ == MeetOuterClass$UpdateCallReceived.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallReceived;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallReceived.a) MeetOuterClass$UpdateCallReceived.newBuilder((MeetOuterClass$UpdateCallReceived) this.trait_).v(meetOuterClass$UpdateCallReceived)).j();
        }
        this.traitCase_ = CALL_RECEIVED_FIELD_NUMBER;
    }

    private void mergeCallStarted(MeetOuterClass$UpdateCallStarted meetOuterClass$UpdateCallStarted) {
        meetOuterClass$UpdateCallStarted.getClass();
        if (this.traitCase_ != 52807 || this.trait_ == MeetOuterClass$UpdateCallStarted.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallStarted;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallStarted.a) MeetOuterClass$UpdateCallStarted.newBuilder((MeetOuterClass$UpdateCallStarted) this.trait_).v(meetOuterClass$UpdateCallStarted)).j();
        }
        this.traitCase_ = CALL_STARTED_FIELD_NUMBER;
    }

    private void mergeCallUpgraded(MeetOuterClass$UpdateCallUpgraded meetOuterClass$UpdateCallUpgraded) {
        meetOuterClass$UpdateCallUpgraded.getClass();
        if (this.traitCase_ != 52816 || this.trait_ == MeetOuterClass$UpdateCallUpgraded.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateCallUpgraded;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateCallUpgraded.a) MeetOuterClass$UpdateCallUpgraded.newBuilder((MeetOuterClass$UpdateCallUpgraded) this.trait_).v(meetOuterClass$UpdateCallUpgraded)).j();
        }
        this.traitCase_ = CALL_UPGRADED_FIELD_NUMBER;
    }

    private void mergeCardinalityChanged(MessagingOuterClass$UpdateCardinalityChanged messagingOuterClass$UpdateCardinalityChanged) {
        messagingOuterClass$UpdateCardinalityChanged.getClass();
        if (this.traitCase_ != 254 || this.trait_ == MessagingOuterClass$UpdateCardinalityChanged.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateCardinalityChanged;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateCardinalityChanged.a) MessagingOuterClass$UpdateCardinalityChanged.newBuilder((MessagingOuterClass$UpdateCardinalityChanged) this.trait_).v(messagingOuterClass$UpdateCardinalityChanged)).j();
        }
        this.traitCase_ = 254;
    }

    private void mergeChannelAdTagIdChanged(GroupsOuterClass$UpdateChannelAdTagIdChanged groupsOuterClass$UpdateChannelAdTagIdChanged) {
        groupsOuterClass$UpdateChannelAdTagIdChanged.getClass();
        if (this.traitCase_ != 52802 || this.trait_ == GroupsOuterClass$UpdateChannelAdTagIdChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateChannelAdTagIdChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateChannelAdTagIdChanged.a) GroupsOuterClass$UpdateChannelAdTagIdChanged.newBuilder((GroupsOuterClass$UpdateChannelAdTagIdChanged) this.trait_).v(groupsOuterClass$UpdateChannelAdTagIdChanged)).j();
        }
        this.traitCase_ = CHANNEL_AD_TAG_ID_CHANGED_FIELD_NUMBER;
    }

    private void mergeChannelAdvertisementTypeChanged(GroupsOuterClass$UpdateChannelAdvertisementTypeChanged groupsOuterClass$UpdateChannelAdvertisementTypeChanged) {
        groupsOuterClass$UpdateChannelAdvertisementTypeChanged.getClass();
        if (this.traitCase_ != 52801 || this.trait_ == GroupsOuterClass$UpdateChannelAdvertisementTypeChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateChannelAdvertisementTypeChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateChannelAdvertisementTypeChanged.a) GroupsOuterClass$UpdateChannelAdvertisementTypeChanged.newBuilder((GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) this.trait_).v(groupsOuterClass$UpdateChannelAdvertisementTypeChanged)).j();
        }
        this.traitCase_ = CHANNEL_ADVERTISEMENT_TYPE_CHANGED_FIELD_NUMBER;
    }

    private void mergeChannelNickChanged(GroupsOuterClass$UpdateChannelNickChanged groupsOuterClass$UpdateChannelNickChanged) {
        groupsOuterClass$UpdateChannelNickChanged.getClass();
        if (this.traitCase_ != 2880 || this.trait_ == GroupsOuterClass$UpdateChannelNickChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateChannelNickChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateChannelNickChanged.a) GroupsOuterClass$UpdateChannelNickChanged.newBuilder((GroupsOuterClass$UpdateChannelNickChanged) this.trait_).v(groupsOuterClass$UpdateChannelNickChanged)).j();
        }
        this.traitCase_ = CHANNEL_NICK_CHANGED_FIELD_NUMBER;
    }

    private void mergeChatArchive(MessagingOuterClass$UpdateChatArchive messagingOuterClass$UpdateChatArchive) {
        messagingOuterClass$UpdateChatArchive.getClass();
        if (this.traitCase_ != 94 || this.trait_ == MessagingOuterClass$UpdateChatArchive.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateChatArchive;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateChatArchive.a) MessagingOuterClass$UpdateChatArchive.newBuilder((MessagingOuterClass$UpdateChatArchive) this.trait_).v(messagingOuterClass$UpdateChatArchive)).j();
        }
        this.traitCase_ = 94;
    }

    private void mergeChatClear(MessagingOuterClass$UpdateChatClear messagingOuterClass$UpdateChatClear) {
        messagingOuterClass$UpdateChatClear.getClass();
        if (this.traitCase_ != 47 || this.trait_ == MessagingOuterClass$UpdateChatClear.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateChatClear;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateChatClear.a) MessagingOuterClass$UpdateChatClear.newBuilder((MessagingOuterClass$UpdateChatClear) this.trait_).v(messagingOuterClass$UpdateChatClear)).j();
        }
        this.traitCase_ = 47;
    }

    private void mergeChatDelete(MessagingOuterClass$UpdateChatDelete messagingOuterClass$UpdateChatDelete) {
        messagingOuterClass$UpdateChatDelete.getClass();
        if (this.traitCase_ != 48 || this.trait_ == MessagingOuterClass$UpdateChatDelete.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateChatDelete;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateChatDelete.a) MessagingOuterClass$UpdateChatDelete.newBuilder((MessagingOuterClass$UpdateChatDelete) this.trait_).v(messagingOuterClass$UpdateChatDelete)).j();
        }
        this.traitCase_ = 48;
    }

    private void mergeChatFavourite(MessagingOuterClass$UpdateChatFavourite messagingOuterClass$UpdateChatFavourite) {
        messagingOuterClass$UpdateChatFavourite.getClass();
        if (this.traitCase_ != 95 || this.trait_ == MessagingOuterClass$UpdateChatFavourite.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateChatFavourite;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateChatFavourite.a) MessagingOuterClass$UpdateChatFavourite.newBuilder((MessagingOuterClass$UpdateChatFavourite) this.trait_).v(messagingOuterClass$UpdateChatFavourite)).j();
        }
        this.traitCase_ = 95;
    }

    private void mergeChatGroupsChanged(MessagingOuterClass$UpdateChatGroupsChanged messagingOuterClass$UpdateChatGroupsChanged) {
        messagingOuterClass$UpdateChatGroupsChanged.getClass();
        if (this.traitCase_ != 1 || this.trait_ == MessagingOuterClass$UpdateChatGroupsChanged.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateChatGroupsChanged;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateChatGroupsChanged.a) MessagingOuterClass$UpdateChatGroupsChanged.newBuilder((MessagingOuterClass$UpdateChatGroupsChanged) this.trait_).v(messagingOuterClass$UpdateChatGroupsChanged)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeChatShow(MessagingOuterClass$UpdateChatShow messagingOuterClass$UpdateChatShow) {
        messagingOuterClass$UpdateChatShow.getClass();
        if (this.traitCase_ != 93 || this.trait_ == MessagingOuterClass$UpdateChatShow.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateChatShow;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateChatShow.a) MessagingOuterClass$UpdateChatShow.newBuilder((MessagingOuterClass$UpdateChatShow) this.trait_).v(messagingOuterClass$UpdateChatShow)).j();
        }
        this.traitCase_ = 93;
    }

    private void mergeContactRegistered(UsersOuterClass$UpdateContactRegistered usersOuterClass$UpdateContactRegistered) {
        usersOuterClass$UpdateContactRegistered.getClass();
        if (this.traitCase_ != 5 || this.trait_ == UsersOuterClass$UpdateContactRegistered.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateContactRegistered;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateContactRegistered.a) UsersOuterClass$UpdateContactRegistered.newBuilder((UsersOuterClass$UpdateContactRegistered) this.trait_).v(usersOuterClass$UpdateContactRegistered)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeContactsAdded(UsersOuterClass$UpdateContactsAdded usersOuterClass$UpdateContactsAdded) {
        usersOuterClass$UpdateContactsAdded.getClass();
        if (this.traitCase_ != 40 || this.trait_ == UsersOuterClass$UpdateContactsAdded.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateContactsAdded;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateContactsAdded.a) UsersOuterClass$UpdateContactsAdded.newBuilder((UsersOuterClass$UpdateContactsAdded) this.trait_).v(usersOuterClass$UpdateContactsAdded)).j();
        }
        this.traitCase_ = 40;
    }

    private void mergeContactsRemoved(UsersOuterClass$UpdateContactsRemoved usersOuterClass$UpdateContactsRemoved) {
        usersOuterClass$UpdateContactsRemoved.getClass();
        if (this.traitCase_ != 41 || this.trait_ == UsersOuterClass$UpdateContactsRemoved.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateContactsRemoved;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateContactsRemoved.a) UsersOuterClass$UpdateContactsRemoved.newBuilder((UsersOuterClass$UpdateContactsRemoved) this.trait_).v(usersOuterClass$UpdateContactsRemoved)).j();
        }
        this.traitCase_ = 41;
    }

    private void mergeDialogArchiveStatus(MessagingOuterClass$UpdateDialogArchiveStatus messagingOuterClass$UpdateDialogArchiveStatus) {
        messagingOuterClass$UpdateDialogArchiveStatus.getClass();
        if (this.traitCase_ != 54345 || this.trait_ == MessagingOuterClass$UpdateDialogArchiveStatus.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateDialogArchiveStatus;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateDialogArchiveStatus.a) MessagingOuterClass$UpdateDialogArchiveStatus.newBuilder((MessagingOuterClass$UpdateDialogArchiveStatus) this.trait_).v(messagingOuterClass$UpdateDialogArchiveStatus)).j();
        }
        this.traitCase_ = DIALOG_ARCHIVE_STATUS_FIELD_NUMBER;
    }

    private void mergeDialogsMarkedAsRead(MessagingOuterClass$UpdateDialogsMarkedAsRead messagingOuterClass$UpdateDialogsMarkedAsRead) {
        messagingOuterClass$UpdateDialogsMarkedAsRead.getClass();
        if (this.traitCase_ != 54335 || this.trait_ == MessagingOuterClass$UpdateDialogsMarkedAsRead.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateDialogsMarkedAsRead;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateDialogsMarkedAsRead.a) MessagingOuterClass$UpdateDialogsMarkedAsRead.newBuilder((MessagingOuterClass$UpdateDialogsMarkedAsRead) this.trait_).v(messagingOuterClass$UpdateDialogsMarkedAsRead)).j();
        }
        this.traitCase_ = DIALOGS_MARKED_AS_READ_FIELD_NUMBER;
    }

    private void mergeDialogsMarkedAsUnread(MessagingOuterClass$UpdateDialogsMarkedAsUnread messagingOuterClass$UpdateDialogsMarkedAsUnread) {
        messagingOuterClass$UpdateDialogsMarkedAsUnread.getClass();
        if (this.traitCase_ != 54336 || this.trait_ == MessagingOuterClass$UpdateDialogsMarkedAsUnread.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateDialogsMarkedAsUnread;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateDialogsMarkedAsUnread.a) MessagingOuterClass$UpdateDialogsMarkedAsUnread.newBuilder((MessagingOuterClass$UpdateDialogsMarkedAsUnread) this.trait_).v(messagingOuterClass$UpdateDialogsMarkedAsUnread)).j();
        }
        this.traitCase_ = DIALOGS_MARKED_AS_UNREAD_FIELD_NUMBER;
    }

    private void mergeDialogsUnpinned(MessagingOuterClass$UpdateDialogsUnpinned messagingOuterClass$UpdateDialogsUnpinned) {
        messagingOuterClass$UpdateDialogsUnpinned.getClass();
        if (this.traitCase_ != 54339 || this.trait_ == MessagingOuterClass$UpdateDialogsUnpinned.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateDialogsUnpinned;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateDialogsUnpinned.a) MessagingOuterClass$UpdateDialogsUnpinned.newBuilder((MessagingOuterClass$UpdateDialogsUnpinned) this.trait_).v(messagingOuterClass$UpdateDialogsUnpinned)).j();
        }
        this.traitCase_ = DIALOGS_UNPINNED_FIELD_NUMBER;
    }

    private void mergeEmptyUpdate(Sequence$UpdateEmptyUpdate sequence$UpdateEmptyUpdate) {
        sequence$UpdateEmptyUpdate.getClass();
        if (this.traitCase_ != 85 || this.trait_ == Sequence$UpdateEmptyUpdate.getDefaultInstance()) {
            this.trait_ = sequence$UpdateEmptyUpdate;
        } else {
            this.trait_ = ((Sequence$UpdateEmptyUpdate.a) Sequence$UpdateEmptyUpdate.newBuilder((Sequence$UpdateEmptyUpdate) this.trait_).v(sequence$UpdateEmptyUpdate)).j();
        }
        this.traitCase_ = 85;
    }

    private void mergeEndLive(LahzeOuterClass$UpdateEndLive lahzeOuterClass$UpdateEndLive) {
        lahzeOuterClass$UpdateEndLive.getClass();
        if (this.traitCase_ != 54329 || this.trait_ == LahzeOuterClass$UpdateEndLive.getDefaultInstance()) {
            this.trait_ = lahzeOuterClass$UpdateEndLive;
        } else {
            this.trait_ = ((LahzeOuterClass$UpdateEndLive.a) LahzeOuterClass$UpdateEndLive.newBuilder((LahzeOuterClass$UpdateEndLive) this.trait_).v(lahzeOuterClass$UpdateEndLive)).j();
        }
        this.traitCase_ = END_LIVE_FIELD_NUMBER;
    }

    private void mergeEndpointChanged(ConfigsOuterClass$UpdateEndpointChanged configsOuterClass$UpdateEndpointChanged) {
        configsOuterClass$UpdateEndpointChanged.getClass();
        if (this.traitCase_ != 54347 || this.trait_ == ConfigsOuterClass$UpdateEndpointChanged.getDefaultInstance()) {
            this.trait_ = configsOuterClass$UpdateEndpointChanged;
        } else {
            this.trait_ = ((ConfigsOuterClass$UpdateEndpointChanged.a) ConfigsOuterClass$UpdateEndpointChanged.newBuilder((ConfigsOuterClass$UpdateEndpointChanged) this.trait_).v(configsOuterClass$UpdateEndpointChanged)).j();
        }
        this.traitCase_ = ENDPOINT_CHANGED_FIELD_NUMBER;
    }

    private void mergeFolderCreated(MessagingOuterClass$UpdateFolderCreated messagingOuterClass$UpdateFolderCreated) {
        messagingOuterClass$UpdateFolderCreated.getClass();
        if (this.traitCase_ != 54332 || this.trait_ == MessagingOuterClass$UpdateFolderCreated.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateFolderCreated;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateFolderCreated.a) MessagingOuterClass$UpdateFolderCreated.newBuilder((MessagingOuterClass$UpdateFolderCreated) this.trait_).v(messagingOuterClass$UpdateFolderCreated)).j();
        }
        this.traitCase_ = FOLDER_CREATED_FIELD_NUMBER;
    }

    private void mergeFolderDeleted(MessagingOuterClass$UpdateFolderDeleted messagingOuterClass$UpdateFolderDeleted) {
        messagingOuterClass$UpdateFolderDeleted.getClass();
        if (this.traitCase_ != 54333 || this.trait_ == MessagingOuterClass$UpdateFolderDeleted.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateFolderDeleted;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateFolderDeleted.a) MessagingOuterClass$UpdateFolderDeleted.newBuilder((MessagingOuterClass$UpdateFolderDeleted) this.trait_).v(messagingOuterClass$UpdateFolderDeleted)).j();
        }
        this.traitCase_ = FOLDER_DELETED_FIELD_NUMBER;
    }

    private void mergeFolderEdited(MessagingOuterClass$UpdateFolderEdited messagingOuterClass$UpdateFolderEdited) {
        messagingOuterClass$UpdateFolderEdited.getClass();
        if (this.traitCase_ != 54337 || this.trait_ == MessagingOuterClass$UpdateFolderEdited.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateFolderEdited;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateFolderEdited.a) MessagingOuterClass$UpdateFolderEdited.newBuilder((MessagingOuterClass$UpdateFolderEdited) this.trait_).v(messagingOuterClass$UpdateFolderEdited)).j();
        }
        this.traitCase_ = FOLDER_EDITED_FIELD_NUMBER;
    }

    private void mergeFoldersReordered(MessagingOuterClass$UpdateFoldersReordered messagingOuterClass$UpdateFoldersReordered) {
        messagingOuterClass$UpdateFoldersReordered.getClass();
        if (this.traitCase_ != 54334 || this.trait_ == MessagingOuterClass$UpdateFoldersReordered.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateFoldersReordered;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateFoldersReordered.a) MessagingOuterClass$UpdateFoldersReordered.newBuilder((MessagingOuterClass$UpdateFoldersReordered) this.trait_).v(messagingOuterClass$UpdateFoldersReordered)).j();
        }
        this.traitCase_ = FOLDERS_REORDERED_FIELD_NUMBER;
    }

    private void mergeForceClearCache(Sequence$UpdateForceClearCache sequence$UpdateForceClearCache) {
        sequence$UpdateForceClearCache.getClass();
        if (this.traitCase_ != 86 || this.trait_ == Sequence$UpdateForceClearCache.getDefaultInstance()) {
            this.trait_ = sequence$UpdateForceClearCache;
        } else {
            this.trait_ = ((Sequence$UpdateForceClearCache.a) Sequence$UpdateForceClearCache.newBuilder((Sequence$UpdateForceClearCache) this.trait_).v(sequence$UpdateForceClearCache)).j();
        }
        this.traitCase_ = 86;
    }

    private void mergeGeneralNotificationMessage(Turing$UpdateGeneralNotificationMessage turing$UpdateGeneralNotificationMessage) {
        turing$UpdateGeneralNotificationMessage.getClass();
        if (this.traitCase_ != 54343 || this.trait_ == Turing$UpdateGeneralNotificationMessage.getDefaultInstance()) {
            this.trait_ = turing$UpdateGeneralNotificationMessage;
        } else {
            this.trait_ = ((Turing$UpdateGeneralNotificationMessage.a) Turing$UpdateGeneralNotificationMessage.newBuilder((Turing$UpdateGeneralNotificationMessage) this.trait_).v(turing$UpdateGeneralNotificationMessage)).j();
        }
        this.traitCase_ = GENERAL_NOTIFICATION_MESSAGE_FIELD_NUMBER;
    }

    private void mergeGroupAboutChanged(GroupsOuterClass$UpdateGroupAboutChanged groupsOuterClass$UpdateGroupAboutChanged) {
        groupsOuterClass$UpdateGroupAboutChanged.getClass();
        if (this.traitCase_ != 2617 || this.trait_ == GroupsOuterClass$UpdateGroupAboutChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupAboutChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupAboutChanged.a) GroupsOuterClass$UpdateGroupAboutChanged.newBuilder((GroupsOuterClass$UpdateGroupAboutChanged) this.trait_).v(groupsOuterClass$UpdateGroupAboutChanged)).j();
        }
        this.traitCase_ = GROUP_ABOUT_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupAboutChangedObsolete(GroupsOuterClass$UpdateGroupAboutChangedObsolete groupsOuterClass$UpdateGroupAboutChangedObsolete) {
        groupsOuterClass$UpdateGroupAboutChangedObsolete.getClass();
        if (this.traitCase_ != 214 || this.trait_ == GroupsOuterClass$UpdateGroupAboutChangedObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupAboutChangedObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupAboutChangedObsolete.a) GroupsOuterClass$UpdateGroupAboutChangedObsolete.newBuilder((GroupsOuterClass$UpdateGroupAboutChangedObsolete) this.trait_).v(groupsOuterClass$UpdateGroupAboutChangedObsolete)).j();
        }
        this.traitCase_ = GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER;
    }

    private void mergeGroupAvatarChanged(GroupsOuterClass$UpdateGroupAvatarChanged groupsOuterClass$UpdateGroupAvatarChanged) {
        groupsOuterClass$UpdateGroupAvatarChanged.getClass();
        if (this.traitCase_ != 2610 || this.trait_ == GroupsOuterClass$UpdateGroupAvatarChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupAvatarChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupAvatarChanged.a) GroupsOuterClass$UpdateGroupAvatarChanged.newBuilder((GroupsOuterClass$UpdateGroupAvatarChanged) this.trait_).v(groupsOuterClass$UpdateGroupAvatarChanged)).j();
        }
        this.traitCase_ = GROUP_AVATAR_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupAvatarChangedObsolete(GroupsOuterClass$UpdateGroupAvatarChangedObsolete groupsOuterClass$UpdateGroupAvatarChangedObsolete) {
        groupsOuterClass$UpdateGroupAvatarChangedObsolete.getClass();
        if (this.traitCase_ != 39 || this.trait_ == GroupsOuterClass$UpdateGroupAvatarChangedObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupAvatarChangedObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupAvatarChangedObsolete.a) GroupsOuterClass$UpdateGroupAvatarChangedObsolete.newBuilder((GroupsOuterClass$UpdateGroupAvatarChangedObsolete) this.trait_).v(groupsOuterClass$UpdateGroupAvatarChangedObsolete)).j();
        }
        this.traitCase_ = 39;
    }

    private void mergeGroupBecameOrphaned(GroupsOuterClass$UpdateGroupBecameOrphaned groupsOuterClass$UpdateGroupBecameOrphaned) {
        groupsOuterClass$UpdateGroupBecameOrphaned.getClass();
        if (this.traitCase_ != 2628 || this.trait_ == GroupsOuterClass$UpdateGroupBecameOrphaned.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupBecameOrphaned;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupBecameOrphaned.a) GroupsOuterClass$UpdateGroupBecameOrphaned.newBuilder((GroupsOuterClass$UpdateGroupBecameOrphaned) this.trait_).v(groupsOuterClass$UpdateGroupBecameOrphaned)).j();
        }
        this.traitCase_ = 2628;
    }

    private void mergeGroupCallEnded(MeetOuterClass$UpdateGroupCallEnded meetOuterClass$UpdateGroupCallEnded) {
        meetOuterClass$UpdateGroupCallEnded.getClass();
        if (this.traitCase_ != 52812 || this.trait_ == MeetOuterClass$UpdateGroupCallEnded.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateGroupCallEnded;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateGroupCallEnded.a) MeetOuterClass$UpdateGroupCallEnded.newBuilder((MeetOuterClass$UpdateGroupCallEnded) this.trait_).v(meetOuterClass$UpdateGroupCallEnded)).j();
        }
        this.traitCase_ = GROUP_CALL_ENDED_FIELD_NUMBER;
    }

    private void mergeGroupCallStarted(MeetOuterClass$UpdateGroupCallStarted meetOuterClass$UpdateGroupCallStarted) {
        meetOuterClass$UpdateGroupCallStarted.getClass();
        if (this.traitCase_ != 52811 || this.trait_ == MeetOuterClass$UpdateGroupCallStarted.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateGroupCallStarted;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateGroupCallStarted.a) MeetOuterClass$UpdateGroupCallStarted.newBuilder((MeetOuterClass$UpdateGroupCallStarted) this.trait_).v(meetOuterClass$UpdateGroupCallStarted)).j();
        }
        this.traitCase_ = GROUP_CALL_STARTED_FIELD_NUMBER;
    }

    private void mergeGroupCanInviteMembersChanged(GroupsOuterClass$UpdateGroupCanInviteMembersChanged groupsOuterClass$UpdateGroupCanInviteMembersChanged) {
        groupsOuterClass$UpdateGroupCanInviteMembersChanged.getClass();
        if (this.traitCase_ != 2626 || this.trait_ == GroupsOuterClass$UpdateGroupCanInviteMembersChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupCanInviteMembersChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupCanInviteMembersChanged.a) GroupsOuterClass$UpdateGroupCanInviteMembersChanged.newBuilder((GroupsOuterClass$UpdateGroupCanInviteMembersChanged) this.trait_).v(groupsOuterClass$UpdateGroupCanInviteMembersChanged)).j();
        }
        this.traitCase_ = GROUP_CAN_INVITE_MEMBERS_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupCanSendMessagesChanged(GroupsOuterClass$UpdateGroupCanSendMessagesChanged groupsOuterClass$UpdateGroupCanSendMessagesChanged) {
        groupsOuterClass$UpdateGroupCanSendMessagesChanged.getClass();
        if (this.traitCase_ != 2624 || this.trait_ == GroupsOuterClass$UpdateGroupCanSendMessagesChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupCanSendMessagesChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupCanSendMessagesChanged.a) GroupsOuterClass$UpdateGroupCanSendMessagesChanged.newBuilder((GroupsOuterClass$UpdateGroupCanSendMessagesChanged) this.trait_).v(groupsOuterClass$UpdateGroupCanSendMessagesChanged)).j();
        }
        this.traitCase_ = GROUP_CAN_SEND_MESSAGES_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupCanViewMembersChanged(GroupsOuterClass$UpdateGroupCanViewMembersChanged groupsOuterClass$UpdateGroupCanViewMembersChanged) {
        groupsOuterClass$UpdateGroupCanViewMembersChanged.getClass();
        if (this.traitCase_ != 2625 || this.trait_ == GroupsOuterClass$UpdateGroupCanViewMembersChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupCanViewMembersChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupCanViewMembersChanged.a) GroupsOuterClass$UpdateGroupCanViewMembersChanged.newBuilder((GroupsOuterClass$UpdateGroupCanViewMembersChanged) this.trait_).v(groupsOuterClass$UpdateGroupCanViewMembersChanged)).j();
        }
        this.traitCase_ = 2625;
    }

    private void mergeGroupDefaultPermissionsChanged(GroupsOuterClass$UpdateGroupDefaultPermissionsChanged groupsOuterClass$UpdateGroupDefaultPermissionsChanged) {
        groupsOuterClass$UpdateGroupDefaultPermissionsChanged.getClass();
        if (this.traitCase_ != 52805 || this.trait_ == GroupsOuterClass$UpdateGroupDefaultPermissionsChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupDefaultPermissionsChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupDefaultPermissionsChanged.a) GroupsOuterClass$UpdateGroupDefaultPermissionsChanged.newBuilder((GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) this.trait_).v(groupsOuterClass$UpdateGroupDefaultPermissionsChanged)).j();
        }
        this.traitCase_ = GROUP_DEFAULT_PERMISSIONS_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupExInfoChanged(GroupsOuterClass$UpdateGroupExInfoChanged groupsOuterClass$UpdateGroupExInfoChanged) {
        groupsOuterClass$UpdateGroupExInfoChanged.getClass();
        if (this.traitCase_ != 2865 || this.trait_ == GroupsOuterClass$UpdateGroupExInfoChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupExInfoChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupExInfoChanged.a) GroupsOuterClass$UpdateGroupExInfoChanged.newBuilder((GroupsOuterClass$UpdateGroupExInfoChanged) this.trait_).v(groupsOuterClass$UpdateGroupExInfoChanged)).j();
        }
        this.traitCase_ = GROUP_EX_INFO_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupExtChanged(GroupsOuterClass$UpdateGroupExtChanged groupsOuterClass$UpdateGroupExtChanged) {
        groupsOuterClass$UpdateGroupExtChanged.getClass();
        if (this.traitCase_ != 2613 || this.trait_ == GroupsOuterClass$UpdateGroupExtChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupExtChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupExtChanged.a) GroupsOuterClass$UpdateGroupExtChanged.newBuilder((GroupsOuterClass$UpdateGroupExtChanged) this.trait_).v(groupsOuterClass$UpdateGroupExtChanged)).j();
        }
        this.traitCase_ = GROUP_EXT_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupFullExtChanged(GroupsOuterClass$UpdateGroupFullExtChanged groupsOuterClass$UpdateGroupFullExtChanged) {
        groupsOuterClass$UpdateGroupFullExtChanged.getClass();
        if (this.traitCase_ != 2618 || this.trait_ == GroupsOuterClass$UpdateGroupFullExtChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupFullExtChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupFullExtChanged.a) GroupsOuterClass$UpdateGroupFullExtChanged.newBuilder((GroupsOuterClass$UpdateGroupFullExtChanged) this.trait_).v(groupsOuterClass$UpdateGroupFullExtChanged)).j();
        }
        this.traitCase_ = GROUP_FULL_EXT_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupHistoryShared(GroupsOuterClass$UpdateGroupHistoryShared groupsOuterClass$UpdateGroupHistoryShared) {
        groupsOuterClass$UpdateGroupHistoryShared.getClass();
        if (this.traitCase_ != 2620 || this.trait_ == GroupsOuterClass$UpdateGroupHistoryShared.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupHistoryShared;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupHistoryShared.a) GroupsOuterClass$UpdateGroupHistoryShared.newBuilder((GroupsOuterClass$UpdateGroupHistoryShared) this.trait_).v(groupsOuterClass$UpdateGroupHistoryShared)).j();
        }
        this.traitCase_ = GROUP_HISTORY_SHARED_FIELD_NUMBER;
    }

    private void mergeGroupInviteObsolete(GroupsOuterClass$UpdateGroupInviteObsolete groupsOuterClass$UpdateGroupInviteObsolete) {
        groupsOuterClass$UpdateGroupInviteObsolete.getClass();
        if (this.traitCase_ != 36 || this.trait_ == GroupsOuterClass$UpdateGroupInviteObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupInviteObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupInviteObsolete.a) GroupsOuterClass$UpdateGroupInviteObsolete.newBuilder((GroupsOuterClass$UpdateGroupInviteObsolete) this.trait_).v(groupsOuterClass$UpdateGroupInviteObsolete)).j();
        }
        this.traitCase_ = 36;
    }

    private void mergeGroupMemberAdminChanged(GroupsOuterClass$UpdateGroupMemberAdminChanged groupsOuterClass$UpdateGroupMemberAdminChanged) {
        groupsOuterClass$UpdateGroupMemberAdminChanged.getClass();
        if (this.traitCase_ != 2627 || this.trait_ == GroupsOuterClass$UpdateGroupMemberAdminChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMemberAdminChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMemberAdminChanged.a) GroupsOuterClass$UpdateGroupMemberAdminChanged.newBuilder((GroupsOuterClass$UpdateGroupMemberAdminChanged) this.trait_).v(groupsOuterClass$UpdateGroupMemberAdminChanged)).j();
        }
        this.traitCase_ = GROUP_MEMBER_ADMIN_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupMemberChanged(GroupsOuterClass$UpdateGroupMemberChanged groupsOuterClass$UpdateGroupMemberChanged) {
        groupsOuterClass$UpdateGroupMemberChanged.getClass();
        if (this.traitCase_ != 2612 || this.trait_ == GroupsOuterClass$UpdateGroupMemberChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMemberChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMemberChanged.a) GroupsOuterClass$UpdateGroupMemberChanged.newBuilder((GroupsOuterClass$UpdateGroupMemberChanged) this.trait_).v(groupsOuterClass$UpdateGroupMemberChanged)).j();
        }
        this.traitCase_ = GROUP_MEMBER_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupMemberDiff(GroupsOuterClass$UpdateGroupMemberDiff groupsOuterClass$UpdateGroupMemberDiff) {
        groupsOuterClass$UpdateGroupMemberDiff.getClass();
        if (this.traitCase_ != 2623 || this.trait_ == GroupsOuterClass$UpdateGroupMemberDiff.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMemberDiff;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMemberDiff.a) GroupsOuterClass$UpdateGroupMemberDiff.newBuilder((GroupsOuterClass$UpdateGroupMemberDiff) this.trait_).v(groupsOuterClass$UpdateGroupMemberDiff)).j();
        }
        this.traitCase_ = GROUP_MEMBER_DIFF_FIELD_NUMBER;
    }

    private void mergeGroupMemberPermissionsChanged(GroupsOuterClass$UpdateGroupMemberPermissionsChanged groupsOuterClass$UpdateGroupMemberPermissionsChanged) {
        groupsOuterClass$UpdateGroupMemberPermissionsChanged.getClass();
        if (this.traitCase_ != 52804 || this.trait_ == GroupsOuterClass$UpdateGroupMemberPermissionsChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMemberPermissionsChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMemberPermissionsChanged.a) GroupsOuterClass$UpdateGroupMemberPermissionsChanged.newBuilder((GroupsOuterClass$UpdateGroupMemberPermissionsChanged) this.trait_).v(groupsOuterClass$UpdateGroupMemberPermissionsChanged)).j();
        }
        this.traitCase_ = GROUP_MEMBER_PERMISSIONS_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupMembersBecameAsync(GroupsOuterClass$UpdateGroupMembersBecameAsync groupsOuterClass$UpdateGroupMembersBecameAsync) {
        groupsOuterClass$UpdateGroupMembersBecameAsync.getClass();
        if (this.traitCase_ != 2615 || this.trait_ == GroupsOuterClass$UpdateGroupMembersBecameAsync.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMembersBecameAsync;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMembersBecameAsync.a) GroupsOuterClass$UpdateGroupMembersBecameAsync.newBuilder((GroupsOuterClass$UpdateGroupMembersBecameAsync) this.trait_).v(groupsOuterClass$UpdateGroupMembersBecameAsync)).j();
        }
        this.traitCase_ = GROUP_MEMBERS_BECAME_ASYNC_FIELD_NUMBER;
    }

    private void mergeGroupMembersCountChanged(GroupsOuterClass$UpdateGroupMembersCountChanged groupsOuterClass$UpdateGroupMembersCountChanged) {
        groupsOuterClass$UpdateGroupMembersCountChanged.getClass();
        if (this.traitCase_ != 2622 || this.trait_ == GroupsOuterClass$UpdateGroupMembersCountChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMembersCountChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMembersCountChanged.a) GroupsOuterClass$UpdateGroupMembersCountChanged.newBuilder((GroupsOuterClass$UpdateGroupMembersCountChanged) this.trait_).v(groupsOuterClass$UpdateGroupMembersCountChanged)).j();
        }
        this.traitCase_ = GROUP_MEMBERS_COUNT_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupMembersUpdateObsolete(GroupsOuterClass$UpdateGroupMembersUpdateObsolete groupsOuterClass$UpdateGroupMembersUpdateObsolete) {
        groupsOuterClass$UpdateGroupMembersUpdateObsolete.getClass();
        if (this.traitCase_ != 44 || this.trait_ == GroupsOuterClass$UpdateGroupMembersUpdateObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMembersUpdateObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMembersUpdateObsolete.a) GroupsOuterClass$UpdateGroupMembersUpdateObsolete.newBuilder((GroupsOuterClass$UpdateGroupMembersUpdateObsolete) this.trait_).v(groupsOuterClass$UpdateGroupMembersUpdateObsolete)).j();
        }
        this.traitCase_ = 44;
    }

    private void mergeGroupMembersUpdated(GroupsOuterClass$UpdateGroupMembersUpdated groupsOuterClass$UpdateGroupMembersUpdated) {
        groupsOuterClass$UpdateGroupMembersUpdated.getClass();
        if (this.traitCase_ != 2614 || this.trait_ == GroupsOuterClass$UpdateGroupMembersUpdated.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMembersUpdated;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMembersUpdated.a) GroupsOuterClass$UpdateGroupMembersUpdated.newBuilder((GroupsOuterClass$UpdateGroupMembersUpdated) this.trait_).v(groupsOuterClass$UpdateGroupMembersUpdated)).j();
        }
        this.traitCase_ = GROUP_MEMBERS_UPDATED_FIELD_NUMBER;
    }

    private void mergeGroupMessagePinned(GroupsOuterClass$UpdateGroupMessagePinned groupsOuterClass$UpdateGroupMessagePinned) {
        groupsOuterClass$UpdateGroupMessagePinned.getClass();
        if (this.traitCase_ != 721 || this.trait_ == GroupsOuterClass$UpdateGroupMessagePinned.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupMessagePinned;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupMessagePinned.a) GroupsOuterClass$UpdateGroupMessagePinned.newBuilder((GroupsOuterClass$UpdateGroupMessagePinned) this.trait_).v(groupsOuterClass$UpdateGroupMessagePinned)).j();
        }
        this.traitCase_ = GROUP_MESSAGE_PINNED_FIELD_NUMBER;
    }

    private void mergeGroupNicknameChanged(GroupsOuterClass$UpdateGroupNicknameChanged groupsOuterClass$UpdateGroupNicknameChanged) {
        groupsOuterClass$UpdateGroupNicknameChanged.getClass();
        if (this.traitCase_ != 57 || this.trait_ == GroupsOuterClass$UpdateGroupNicknameChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupNicknameChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupNicknameChanged.a) GroupsOuterClass$UpdateGroupNicknameChanged.newBuilder((GroupsOuterClass$UpdateGroupNicknameChanged) this.trait_).v(groupsOuterClass$UpdateGroupNicknameChanged)).j();
        }
        this.traitCase_ = 57;
    }

    private void mergeGroupOnline(PresenceOuterClass$UpdateGroupOnline presenceOuterClass$UpdateGroupOnline) {
        presenceOuterClass$UpdateGroupOnline.getClass();
        if (this.traitCase_ != 33 || this.trait_ == PresenceOuterClass$UpdateGroupOnline.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$UpdateGroupOnline;
        } else {
            this.trait_ = ((PresenceOuterClass$UpdateGroupOnline.a) PresenceOuterClass$UpdateGroupOnline.newBuilder((PresenceOuterClass$UpdateGroupOnline) this.trait_).v(presenceOuterClass$UpdateGroupOnline)).j();
        }
        this.traitCase_ = 33;
    }

    private void mergeGroupOwnerChanged(GroupsOuterClass$UpdateGroupOwnerChanged groupsOuterClass$UpdateGroupOwnerChanged) {
        groupsOuterClass$UpdateGroupOwnerChanged.getClass();
        if (this.traitCase_ != 2619 || this.trait_ == GroupsOuterClass$UpdateGroupOwnerChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupOwnerChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupOwnerChanged.a) GroupsOuterClass$UpdateGroupOwnerChanged.newBuilder((GroupsOuterClass$UpdateGroupOwnerChanged) this.trait_).v(groupsOuterClass$UpdateGroupOwnerChanged)).j();
        }
        this.traitCase_ = GROUP_OWNER_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupPinRemoved(GroupsOuterClass$UpdateGroupPinRemoved groupsOuterClass$UpdateGroupPinRemoved) {
        groupsOuterClass$UpdateGroupPinRemoved.getClass();
        if (this.traitCase_ != 722 || this.trait_ == GroupsOuterClass$UpdateGroupPinRemoved.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupPinRemoved;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupPinRemoved.a) GroupsOuterClass$UpdateGroupPinRemoved.newBuilder((GroupsOuterClass$UpdateGroupPinRemoved) this.trait_).v(groupsOuterClass$UpdateGroupPinRemoved)).j();
        }
        this.traitCase_ = GROUP_PIN_REMOVED_FIELD_NUMBER;
    }

    private void mergeGroupRestrictionChanged(GroupsOuterClass$UpdateGroupRestrictionChanged groupsOuterClass$UpdateGroupRestrictionChanged) {
        groupsOuterClass$UpdateGroupRestrictionChanged.getClass();
        if (this.traitCase_ != 723 || this.trait_ == GroupsOuterClass$UpdateGroupRestrictionChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupRestrictionChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupRestrictionChanged.a) GroupsOuterClass$UpdateGroupRestrictionChanged.newBuilder((GroupsOuterClass$UpdateGroupRestrictionChanged) this.trait_).v(groupsOuterClass$UpdateGroupRestrictionChanged)).j();
        }
        this.traitCase_ = GROUP_RESTRICTION_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupTitleChanged(GroupsOuterClass$UpdateGroupTitleChanged groupsOuterClass$UpdateGroupTitleChanged) {
        groupsOuterClass$UpdateGroupTitleChanged.getClass();
        if (this.traitCase_ != 2609 || this.trait_ == GroupsOuterClass$UpdateGroupTitleChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupTitleChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupTitleChanged.a) GroupsOuterClass$UpdateGroupTitleChanged.newBuilder((GroupsOuterClass$UpdateGroupTitleChanged) this.trait_).v(groupsOuterClass$UpdateGroupTitleChanged)).j();
        }
        this.traitCase_ = GROUP_TITLE_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupTitleChangedObsolete(GroupsOuterClass$UpdateGroupTitleChangedObsolete groupsOuterClass$UpdateGroupTitleChangedObsolete) {
        groupsOuterClass$UpdateGroupTitleChangedObsolete.getClass();
        if (this.traitCase_ != 38 || this.trait_ == GroupsOuterClass$UpdateGroupTitleChangedObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupTitleChangedObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupTitleChangedObsolete.a) GroupsOuterClass$UpdateGroupTitleChangedObsolete.newBuilder((GroupsOuterClass$UpdateGroupTitleChangedObsolete) this.trait_).v(groupsOuterClass$UpdateGroupTitleChangedObsolete)).j();
        }
        this.traitCase_ = 38;
    }

    private void mergeGroupTopicChanged(GroupsOuterClass$UpdateGroupTopicChanged groupsOuterClass$UpdateGroupTopicChanged) {
        groupsOuterClass$UpdateGroupTopicChanged.getClass();
        if (this.traitCase_ != 2616 || this.trait_ == GroupsOuterClass$UpdateGroupTopicChanged.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupTopicChanged;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupTopicChanged.a) GroupsOuterClass$UpdateGroupTopicChanged.newBuilder((GroupsOuterClass$UpdateGroupTopicChanged) this.trait_).v(groupsOuterClass$UpdateGroupTopicChanged)).j();
        }
        this.traitCase_ = GROUP_TOPIC_CHANGED_FIELD_NUMBER;
    }

    private void mergeGroupTopicChangedObsolete(GroupsOuterClass$UpdateGroupTopicChangedObsolete groupsOuterClass$UpdateGroupTopicChangedObsolete) {
        groupsOuterClass$UpdateGroupTopicChangedObsolete.getClass();
        if (this.traitCase_ != 213 || this.trait_ == GroupsOuterClass$UpdateGroupTopicChangedObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupTopicChangedObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupTopicChangedObsolete.a) GroupsOuterClass$UpdateGroupTopicChangedObsolete.newBuilder((GroupsOuterClass$UpdateGroupTopicChangedObsolete) this.trait_).v(groupsOuterClass$UpdateGroupTopicChangedObsolete)).j();
        }
        this.traitCase_ = 213;
    }

    private void mergeGroupUserInvitedObsolete(GroupsOuterClass$UpdateGroupUserInvitedObsolete groupsOuterClass$UpdateGroupUserInvitedObsolete) {
        groupsOuterClass$UpdateGroupUserInvitedObsolete.getClass();
        if (this.traitCase_ != 21 || this.trait_ == GroupsOuterClass$UpdateGroupUserInvitedObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupUserInvitedObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupUserInvitedObsolete.a) GroupsOuterClass$UpdateGroupUserInvitedObsolete.newBuilder((GroupsOuterClass$UpdateGroupUserInvitedObsolete) this.trait_).v(groupsOuterClass$UpdateGroupUserInvitedObsolete)).j();
        }
        this.traitCase_ = 21;
    }

    private void mergeGroupUserKickObsolete(GroupsOuterClass$UpdateGroupUserKickObsolete groupsOuterClass$UpdateGroupUserKickObsolete) {
        groupsOuterClass$UpdateGroupUserKickObsolete.getClass();
        if (this.traitCase_ != 24 || this.trait_ == GroupsOuterClass$UpdateGroupUserKickObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupUserKickObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupUserKickObsolete.a) GroupsOuterClass$UpdateGroupUserKickObsolete.newBuilder((GroupsOuterClass$UpdateGroupUserKickObsolete) this.trait_).v(groupsOuterClass$UpdateGroupUserKickObsolete)).j();
        }
        this.traitCase_ = 24;
    }

    private void mergeGroupUserLeaveObsolete(GroupsOuterClass$UpdateGroupUserLeaveObsolete groupsOuterClass$UpdateGroupUserLeaveObsolete) {
        groupsOuterClass$UpdateGroupUserLeaveObsolete.getClass();
        if (this.traitCase_ != 23 || this.trait_ == GroupsOuterClass$UpdateGroupUserLeaveObsolete.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$UpdateGroupUserLeaveObsolete;
        } else {
            this.trait_ = ((GroupsOuterClass$UpdateGroupUserLeaveObsolete.a) GroupsOuterClass$UpdateGroupUserLeaveObsolete.newBuilder((GroupsOuterClass$UpdateGroupUserLeaveObsolete) this.trait_).v(groupsOuterClass$UpdateGroupUserLeaveObsolete)).j();
        }
        this.traitCase_ = 23;
    }

    private void mergeHidePrivacyBar(ReportOuterClass$UpdateHidePrivacyBar reportOuterClass$UpdateHidePrivacyBar) {
        reportOuterClass$UpdateHidePrivacyBar.getClass();
        if (this.traitCase_ != 52824 || this.trait_ == ReportOuterClass$UpdateHidePrivacyBar.getDefaultInstance()) {
            this.trait_ = reportOuterClass$UpdateHidePrivacyBar;
        } else {
            this.trait_ = ((ReportOuterClass$UpdateHidePrivacyBar.a) ReportOuterClass$UpdateHidePrivacyBar.newBuilder((ReportOuterClass$UpdateHidePrivacyBar) this.trait_).v(reportOuterClass$UpdateHidePrivacyBar)).j();
        }
        this.traitCase_ = HIDE_PRIVACY_BAR_FIELD_NUMBER;
    }

    private void mergeMentionReadByMe(MessagingOuterClass$UpdateMentionReadByMe messagingOuterClass$UpdateMentionReadByMe) {
        messagingOuterClass$UpdateMentionReadByMe.getClass();
        if (this.traitCase_ != 52829 || this.trait_ == MessagingOuterClass$UpdateMentionReadByMe.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMentionReadByMe;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMentionReadByMe.a) MessagingOuterClass$UpdateMentionReadByMe.newBuilder((MessagingOuterClass$UpdateMentionReadByMe) this.trait_).v(messagingOuterClass$UpdateMentionReadByMe)).j();
        }
        this.traitCase_ = MENTION_READ_BY_ME_FIELD_NUMBER;
    }

    private void mergeMessage(MessagingOuterClass$UpdateMessage messagingOuterClass$UpdateMessage) {
        messagingOuterClass$UpdateMessage.getClass();
        if (this.traitCase_ != 55 || this.trait_ == MessagingOuterClass$UpdateMessage.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessage;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessage.a) MessagingOuterClass$UpdateMessage.newBuilder((MessagingOuterClass$UpdateMessage) this.trait_).v(messagingOuterClass$UpdateMessage)).j();
        }
        this.traitCase_ = 55;
    }

    private void mergeMessageContentChanged(MessagingOuterClass$UpdateMessageContentChanged messagingOuterClass$UpdateMessageContentChanged) {
        messagingOuterClass$UpdateMessageContentChanged.getClass();
        if (this.traitCase_ != 162 || this.trait_ == MessagingOuterClass$UpdateMessageContentChanged.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessageContentChanged;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessageContentChanged.a) MessagingOuterClass$UpdateMessageContentChanged.newBuilder((MessagingOuterClass$UpdateMessageContentChanged) this.trait_).v(messagingOuterClass$UpdateMessageContentChanged)).j();
        }
        this.traitCase_ = MESSAGE_CONTENT_CHANGED_FIELD_NUMBER;
    }

    private void mergeMessageDateChanged(MessagingOuterClass$UpdateMessageDateChanged messagingOuterClass$UpdateMessageDateChanged) {
        messagingOuterClass$UpdateMessageDateChanged.getClass();
        if (this.traitCase_ != 163 || this.trait_ == MessagingOuterClass$UpdateMessageDateChanged.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessageDateChanged;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessageDateChanged.a) MessagingOuterClass$UpdateMessageDateChanged.newBuilder((MessagingOuterClass$UpdateMessageDateChanged) this.trait_).v(messagingOuterClass$UpdateMessageDateChanged)).j();
        }
        this.traitCase_ = MESSAGE_DATE_CHANGED_FIELD_NUMBER;
    }

    private void mergeMessageDelete(MessagingOuterClass$UpdateMessageDelete messagingOuterClass$UpdateMessageDelete) {
        messagingOuterClass$UpdateMessageDelete.getClass();
        if (this.traitCase_ != 46 || this.trait_ == MessagingOuterClass$UpdateMessageDelete.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessageDelete;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessageDelete.a) MessagingOuterClass$UpdateMessageDelete.newBuilder((MessagingOuterClass$UpdateMessageDelete) this.trait_).v(messagingOuterClass$UpdateMessageDelete)).j();
        }
        this.traitCase_ = 46;
    }

    private void mergeMessageNewReaction(AbacusOuterClass$UpdateMessageNewReaction abacusOuterClass$UpdateMessageNewReaction) {
        abacusOuterClass$UpdateMessageNewReaction.getClass();
        if (this.traitCase_ != 54323 || this.trait_ == AbacusOuterClass$UpdateMessageNewReaction.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$UpdateMessageNewReaction;
        } else {
            this.trait_ = ((AbacusOuterClass$UpdateMessageNewReaction.a) AbacusOuterClass$UpdateMessageNewReaction.newBuilder((AbacusOuterClass$UpdateMessageNewReaction) this.trait_).v(abacusOuterClass$UpdateMessageNewReaction)).j();
        }
        this.traitCase_ = MESSAGE_NEW_REACTION_FIELD_NUMBER;
    }

    private void mergeMessagePinned(MessagingOuterClass$UpdateMessagePinned messagingOuterClass$UpdateMessagePinned) {
        messagingOuterClass$UpdateMessagePinned.getClass();
        if (this.traitCase_ != 54340 || this.trait_ == MessagingOuterClass$UpdateMessagePinned.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessagePinned;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessagePinned.a) MessagingOuterClass$UpdateMessagePinned.newBuilder((MessagingOuterClass$UpdateMessagePinned) this.trait_).v(messagingOuterClass$UpdateMessagePinned)).j();
        }
        this.traitCase_ = MESSAGE_PINNED_FIELD_NUMBER;
    }

    private void mergeMessageQuotedChanged(MessagingOuterClass$UpdateMessageQuotedChanged messagingOuterClass$UpdateMessageQuotedChanged) {
        messagingOuterClass$UpdateMessageQuotedChanged.getClass();
        if (this.traitCase_ != 169 || this.trait_ == MessagingOuterClass$UpdateMessageQuotedChanged.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessageQuotedChanged;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessageQuotedChanged.a) MessagingOuterClass$UpdateMessageQuotedChanged.newBuilder((MessagingOuterClass$UpdateMessageQuotedChanged) this.trait_).v(messagingOuterClass$UpdateMessageQuotedChanged)).j();
        }
        this.traitCase_ = MESSAGE_QUOTED_CHANGED_FIELD_NUMBER;
    }

    private void mergeMessageReactions(AbacusOuterClass$UpdateMessageReactions abacusOuterClass$UpdateMessageReactions) {
        abacusOuterClass$UpdateMessageReactions.getClass();
        if (this.traitCase_ != 52825 || this.trait_ == AbacusOuterClass$UpdateMessageReactions.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$UpdateMessageReactions;
        } else {
            this.trait_ = ((AbacusOuterClass$UpdateMessageReactions.a) AbacusOuterClass$UpdateMessageReactions.newBuilder((AbacusOuterClass$UpdateMessageReactions) this.trait_).v(abacusOuterClass$UpdateMessageReactions)).j();
        }
        this.traitCase_ = MESSAGE_REACTIONS_FIELD_NUMBER;
    }

    private void mergeMessageReactionsReadByMe(AbacusOuterClass$UpdateMessageReactionsReadByMe abacusOuterClass$UpdateMessageReactionsReadByMe) {
        abacusOuterClass$UpdateMessageReactionsReadByMe.getClass();
        if (this.traitCase_ != 52832 || this.trait_ == AbacusOuterClass$UpdateMessageReactionsReadByMe.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$UpdateMessageReactionsReadByMe;
        } else {
            this.trait_ = ((AbacusOuterClass$UpdateMessageReactionsReadByMe.a) AbacusOuterClass$UpdateMessageReactionsReadByMe.newBuilder((AbacusOuterClass$UpdateMessageReactionsReadByMe) this.trait_).v(abacusOuterClass$UpdateMessageReactionsReadByMe)).j();
        }
        this.traitCase_ = MESSAGE_REACTIONS_READ_BY_ME_FIELD_NUMBER;
    }

    private void mergeMessageRead(MessagingOuterClass$UpdateMessageRead messagingOuterClass$UpdateMessageRead) {
        messagingOuterClass$UpdateMessageRead.getClass();
        if (this.traitCase_ != 19 || this.trait_ == MessagingOuterClass$UpdateMessageRead.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessageRead;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessageRead.a) MessagingOuterClass$UpdateMessageRead.newBuilder((MessagingOuterClass$UpdateMessageRead) this.trait_).v(messagingOuterClass$UpdateMessageRead)).j();
        }
        this.traitCase_ = 19;
    }

    private void mergeMessageReadByMe(MessagingOuterClass$UpdateMessageReadByMe messagingOuterClass$UpdateMessageReadByMe) {
        messagingOuterClass$UpdateMessageReadByMe.getClass();
        if (this.traitCase_ != 50 || this.trait_ == MessagingOuterClass$UpdateMessageReadByMe.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessageReadByMe;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessageReadByMe.a) MessagingOuterClass$UpdateMessageReadByMe.newBuilder((MessagingOuterClass$UpdateMessageReadByMe) this.trait_).v(messagingOuterClass$UpdateMessageReadByMe)).j();
        }
        this.traitCase_ = 50;
    }

    private void mergeMessageReceived(MessagingOuterClass$UpdateMessageReceived messagingOuterClass$UpdateMessageReceived) {
        messagingOuterClass$UpdateMessageReceived.getClass();
        if (this.traitCase_ != 54 || this.trait_ == MessagingOuterClass$UpdateMessageReceived.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessageReceived;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessageReceived.a) MessagingOuterClass$UpdateMessageReceived.newBuilder((MessagingOuterClass$UpdateMessageReceived) this.trait_).v(messagingOuterClass$UpdateMessageReceived)).j();
        }
        this.traitCase_ = 54;
    }

    private void mergeMessageSent(MessagingOuterClass$UpdateMessageSent messagingOuterClass$UpdateMessageSent) {
        messagingOuterClass$UpdateMessageSent.getClass();
        if (this.traitCase_ != 4 || this.trait_ == MessagingOuterClass$UpdateMessageSent.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessageSent;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessageSent.a) MessagingOuterClass$UpdateMessageSent.newBuilder((MessagingOuterClass$UpdateMessageSent) this.trait_).v(messagingOuterClass$UpdateMessageSent)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeMessages(MessagingOuterClass$UpdateMessages messagingOuterClass$UpdateMessages) {
        messagingOuterClass$UpdateMessages.getClass();
        if (this.traitCase_ != 52815 || this.trait_ == MessagingOuterClass$UpdateMessages.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessages;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessages.a) MessagingOuterClass$UpdateMessages.newBuilder((MessagingOuterClass$UpdateMessages) this.trait_).v(messagingOuterClass$UpdateMessages)).j();
        }
        this.traitCase_ = _MESSAGES_FIELD_NUMBER;
    }

    private void mergeMessagesUnPinned(MessagingOuterClass$UpdateMessagesUnPinned messagingOuterClass$UpdateMessagesUnPinned) {
        messagingOuterClass$UpdateMessagesUnPinned.getClass();
        if (this.traitCase_ != 54341 || this.trait_ == MessagingOuterClass$UpdateMessagesUnPinned.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdateMessagesUnPinned;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdateMessagesUnPinned.a) MessagingOuterClass$UpdateMessagesUnPinned.newBuilder((MessagingOuterClass$UpdateMessagesUnPinned) this.trait_).v(messagingOuterClass$UpdateMessagesUnPinned)).j();
        }
        this.traitCase_ = MESSAGES_UN_PINNED_FIELD_NUMBER;
    }

    private void mergeMultiPeerCallStarted(MeetOuterClass$UpdateMultiPeerCallStarted meetOuterClass$UpdateMultiPeerCallStarted) {
        meetOuterClass$UpdateMultiPeerCallStarted.getClass();
        if (this.traitCase_ != 52818 || this.trait_ == MeetOuterClass$UpdateMultiPeerCallStarted.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdateMultiPeerCallStarted;
        } else {
            this.trait_ = ((MeetOuterClass$UpdateMultiPeerCallStarted.a) MeetOuterClass$UpdateMultiPeerCallStarted.newBuilder((MeetOuterClass$UpdateMultiPeerCallStarted) this.trait_).v(meetOuterClass$UpdateMultiPeerCallStarted)).j();
        }
        this.traitCase_ = MULTI_PEER_CALL_STARTED_FIELD_NUMBER;
    }

    private void mergeOwnStickersChanged(ImagesOuterClass$UpdateOwnStickersChanged imagesOuterClass$UpdateOwnStickersChanged) {
        imagesOuterClass$UpdateOwnStickersChanged.getClass();
        if (this.traitCase_ != 161 || this.trait_ == ImagesOuterClass$UpdateOwnStickersChanged.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$UpdateOwnStickersChanged;
        } else {
            this.trait_ = ((ImagesOuterClass$UpdateOwnStickersChanged.a) ImagesOuterClass$UpdateOwnStickersChanged.newBuilder((ImagesOuterClass$UpdateOwnStickersChanged) this.trait_).v(imagesOuterClass$UpdateOwnStickersChanged)).j();
        }
        this.traitCase_ = OWN_STICKERS_CHANGED_FIELD_NUMBER;
    }

    private void mergeParameterChanged(ConfigsOuterClass$UpdateParameterChanged configsOuterClass$UpdateParameterChanged) {
        configsOuterClass$UpdateParameterChanged.getClass();
        if (this.traitCase_ != 131 || this.trait_ == ConfigsOuterClass$UpdateParameterChanged.getDefaultInstance()) {
            this.trait_ = configsOuterClass$UpdateParameterChanged;
        } else {
            this.trait_ = ((ConfigsOuterClass$UpdateParameterChanged.a) ConfigsOuterClass$UpdateParameterChanged.newBuilder((ConfigsOuterClass$UpdateParameterChanged) this.trait_).v(configsOuterClass$UpdateParameterChanged)).j();
        }
        this.traitCase_ = 131;
    }

    private void mergePeersInvited(MeetOuterClass$UpdatePeersInvited meetOuterClass$UpdatePeersInvited) {
        meetOuterClass$UpdatePeersInvited.getClass();
        if (this.traitCase_ != 52817 || this.trait_ == MeetOuterClass$UpdatePeersInvited.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdatePeersInvited;
        } else {
            this.trait_ = ((MeetOuterClass$UpdatePeersInvited.a) MeetOuterClass$UpdatePeersInvited.newBuilder((MeetOuterClass$UpdatePeersInvited) this.trait_).v(meetOuterClass$UpdatePeersInvited)).j();
        }
        this.traitCase_ = PEERS_INVITED_FIELD_NUMBER;
    }

    private void mergePeersStateChanged(MeetOuterClass$UpdatePeersStateChanged meetOuterClass$UpdatePeersStateChanged) {
        meetOuterClass$UpdatePeersStateChanged.getClass();
        if (this.traitCase_ != 52819 || this.trait_ == MeetOuterClass$UpdatePeersStateChanged.getDefaultInstance()) {
            this.trait_ = meetOuterClass$UpdatePeersStateChanged;
        } else {
            this.trait_ = ((MeetOuterClass$UpdatePeersStateChanged.a) MeetOuterClass$UpdatePeersStateChanged.newBuilder((MeetOuterClass$UpdatePeersStateChanged) this.trait_).v(meetOuterClass$UpdatePeersStateChanged)).j();
        }
        this.traitCase_ = PEERS_STATE_CHANGED_FIELD_NUMBER;
    }

    private void mergePhoneNumberChanged(UsersOuterClass$UpdatePhoneNumberChanged usersOuterClass$UpdatePhoneNumberChanged) {
        usersOuterClass$UpdatePhoneNumberChanged.getClass();
        if (this.traitCase_ != 52803 || this.trait_ == UsersOuterClass$UpdatePhoneNumberChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdatePhoneNumberChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdatePhoneNumberChanged.a) UsersOuterClass$UpdatePhoneNumberChanged.newBuilder((UsersOuterClass$UpdatePhoneNumberChanged) this.trait_).v(usersOuterClass$UpdatePhoneNumberChanged)).j();
        }
        this.traitCase_ = PHONE_NUMBER_CHANGED_FIELD_NUMBER;
    }

    private void mergePinnedDialogsChanged(MessagingOuterClass$UpdatePinnedDialogsChanged messagingOuterClass$UpdatePinnedDialogsChanged) {
        messagingOuterClass$UpdatePinnedDialogsChanged.getClass();
        if (this.traitCase_ != 52830 || this.trait_ == MessagingOuterClass$UpdatePinnedDialogsChanged.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$UpdatePinnedDialogsChanged;
        } else {
            this.trait_ = ((MessagingOuterClass$UpdatePinnedDialogsChanged.a) MessagingOuterClass$UpdatePinnedDialogsChanged.newBuilder((MessagingOuterClass$UpdatePinnedDialogsChanged) this.trait_).v(messagingOuterClass$UpdatePinnedDialogsChanged)).j();
        }
        this.traitCase_ = PINNED_DIALOGS_CHANGED_FIELD_NUMBER;
    }

    private void mergePremiumPurchaseStatus(PremiumOuterClass$UpdatePremiumPurchaseStatus premiumOuterClass$UpdatePremiumPurchaseStatus) {
        premiumOuterClass$UpdatePremiumPurchaseStatus.getClass();
        if (this.traitCase_ != 54346 || this.trait_ == PremiumOuterClass$UpdatePremiumPurchaseStatus.getDefaultInstance()) {
            this.trait_ = premiumOuterClass$UpdatePremiumPurchaseStatus;
        } else {
            this.trait_ = ((PremiumOuterClass$UpdatePremiumPurchaseStatus.a) PremiumOuterClass$UpdatePremiumPurchaseStatus.newBuilder((PremiumOuterClass$UpdatePremiumPurchaseStatus) this.trait_).v(premiumOuterClass$UpdatePremiumPurchaseStatus)).j();
        }
        this.traitCase_ = PREMIUM_PURCHASE_STATUS_FIELD_NUMBER;
    }

    private void mergeRawUpdate(Sequence$UpdateRawUpdate sequence$UpdateRawUpdate) {
        sequence$UpdateRawUpdate.getClass();
        if (this.traitCase_ != 80 || this.trait_ == Sequence$UpdateRawUpdate.getDefaultInstance()) {
            this.trait_ = sequence$UpdateRawUpdate;
        } else {
            this.trait_ = ((Sequence$UpdateRawUpdate.a) Sequence$UpdateRawUpdate.newBuilder((Sequence$UpdateRawUpdate) this.trait_).v(sequence$UpdateRawUpdate)).j();
        }
        this.traitCase_ = 80;
    }

    private void mergeReactionsUpdate(AbacusOuterClass$UpdateReactionsUpdate abacusOuterClass$UpdateReactionsUpdate) {
        abacusOuterClass$UpdateReactionsUpdate.getClass();
        if (this.traitCase_ != 222 || this.trait_ == AbacusOuterClass$UpdateReactionsUpdate.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$UpdateReactionsUpdate;
        } else {
            this.trait_ = ((AbacusOuterClass$UpdateReactionsUpdate.a) AbacusOuterClass$UpdateReactionsUpdate.newBuilder((AbacusOuterClass$UpdateReactionsUpdate) this.trait_).v(abacusOuterClass$UpdateReactionsUpdate)).j();
        }
        this.traitCase_ = 222;
    }

    private void mergeRequestBankiAccessFor(BankOuterClass$UpdateRequestBankiAccessFor bankOuterClass$UpdateRequestBankiAccessFor) {
        bankOuterClass$UpdateRequestBankiAccessFor.getClass();
        if (this.traitCase_ != 62398 || this.trait_ == BankOuterClass$UpdateRequestBankiAccessFor.getDefaultInstance()) {
            this.trait_ = bankOuterClass$UpdateRequestBankiAccessFor;
        } else {
            this.trait_ = ((BankOuterClass$UpdateRequestBankiAccessFor.a) BankOuterClass$UpdateRequestBankiAccessFor.newBuilder((BankOuterClass$UpdateRequestBankiAccessFor) this.trait_).v(bankOuterClass$UpdateRequestBankiAccessFor)).j();
        }
        this.traitCase_ = REQUEST_BANKI_ACCESS_FOR_FIELD_NUMBER;
    }

    private void mergeRequestLogin(BankOuterClass$UpdateRequestLogin bankOuterClass$UpdateRequestLogin) {
        bankOuterClass$UpdateRequestLogin.getClass();
        if (this.traitCase_ != 3897 || this.trait_ == BankOuterClass$UpdateRequestLogin.getDefaultInstance()) {
            this.trait_ = bankOuterClass$UpdateRequestLogin;
        } else {
            this.trait_ = ((BankOuterClass$UpdateRequestLogin.a) BankOuterClass$UpdateRequestLogin.newBuilder((BankOuterClass$UpdateRequestLogin) this.trait_).v(bankOuterClass$UpdateRequestLogin)).j();
        }
        this.traitCase_ = REQUEST_LOGIN_FIELD_NUMBER;
    }

    private void mergeSavedGifsChanged(ImagesOuterClass$UpdateSavedGifsChanged imagesOuterClass$UpdateSavedGifsChanged) {
        imagesOuterClass$UpdateSavedGifsChanged.getClass();
        if (this.traitCase_ != 52820 || this.trait_ == ImagesOuterClass$UpdateSavedGifsChanged.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$UpdateSavedGifsChanged;
        } else {
            this.trait_ = ((ImagesOuterClass$UpdateSavedGifsChanged.a) ImagesOuterClass$UpdateSavedGifsChanged.newBuilder((ImagesOuterClass$UpdateSavedGifsChanged) this.trait_).v(imagesOuterClass$UpdateSavedGifsChanged)).j();
        }
        this.traitCase_ = SAVED_GIFS_CHANGED_FIELD_NUMBER;
    }

    private void mergeStartLive(LahzeOuterClass$UpdateStartLive lahzeOuterClass$UpdateStartLive) {
        lahzeOuterClass$UpdateStartLive.getClass();
        if (this.traitCase_ != 54328 || this.trait_ == LahzeOuterClass$UpdateStartLive.getDefaultInstance()) {
            this.trait_ = lahzeOuterClass$UpdateStartLive;
        } else {
            this.trait_ = ((LahzeOuterClass$UpdateStartLive.a) LahzeOuterClass$UpdateStartLive.newBuilder((LahzeOuterClass$UpdateStartLive) this.trait_).v(lahzeOuterClass$UpdateStartLive)).j();
        }
        this.traitCase_ = START_LIVE_FIELD_NUMBER;
    }

    private void mergeStickerCollectionsChanged(ImagesOuterClass$UpdateStickerCollectionsChanged imagesOuterClass$UpdateStickerCollectionsChanged) {
        imagesOuterClass$UpdateStickerCollectionsChanged.getClass();
        if (this.traitCase_ != 164 || this.trait_ == ImagesOuterClass$UpdateStickerCollectionsChanged.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$UpdateStickerCollectionsChanged;
        } else {
            this.trait_ = ((ImagesOuterClass$UpdateStickerCollectionsChanged.a) ImagesOuterClass$UpdateStickerCollectionsChanged.newBuilder((ImagesOuterClass$UpdateStickerCollectionsChanged) this.trait_).v(imagesOuterClass$UpdateStickerCollectionsChanged)).j();
        }
        this.traitCase_ = STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER;
    }

    private void mergeStickerPacksChanged(ImagesOuterClass$UpdateStickerPacksChanged imagesOuterClass$UpdateStickerPacksChanged) {
        imagesOuterClass$UpdateStickerPacksChanged.getClass();
        if (this.traitCase_ != 52814 || this.trait_ == ImagesOuterClass$UpdateStickerPacksChanged.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$UpdateStickerPacksChanged;
        } else {
            this.trait_ = ((ImagesOuterClass$UpdateStickerPacksChanged.a) ImagesOuterClass$UpdateStickerPacksChanged.newBuilder((ImagesOuterClass$UpdateStickerPacksChanged) this.trait_).v(imagesOuterClass$UpdateStickerPacksChanged)).j();
        }
        this.traitCase_ = STICKER_PACKS_CHANGED_FIELD_NUMBER;
    }

    private void mergeTranscriptReady(Turing$UpdateTranscriptReady turing$UpdateTranscriptReady) {
        turing$UpdateTranscriptReady.getClass();
        if (this.traitCase_ != 54342 || this.trait_ == Turing$UpdateTranscriptReady.getDefaultInstance()) {
            this.trait_ = turing$UpdateTranscriptReady;
        } else {
            this.trait_ = ((Turing$UpdateTranscriptReady.a) Turing$UpdateTranscriptReady.newBuilder((Turing$UpdateTranscriptReady) this.trait_).v(turing$UpdateTranscriptReady)).j();
        }
        this.traitCase_ = TRANSCRIPT_READY_FIELD_NUMBER;
    }

    private void mergeTyping(PresenceOuterClass$UpdateTyping presenceOuterClass$UpdateTyping) {
        presenceOuterClass$UpdateTyping.getClass();
        if (this.traitCase_ != 6 || this.trait_ == PresenceOuterClass$UpdateTyping.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$UpdateTyping;
        } else {
            this.trait_ = ((PresenceOuterClass$UpdateTyping.a) PresenceOuterClass$UpdateTyping.newBuilder((PresenceOuterClass$UpdateTyping) this.trait_).v(presenceOuterClass$UpdateTyping)).j();
        }
        this.traitCase_ = 6;
    }

    private void mergeTypingStop(PresenceOuterClass$UpdateTypingStop presenceOuterClass$UpdateTypingStop) {
        presenceOuterClass$UpdateTypingStop.getClass();
        if (this.traitCase_ != 81 || this.trait_ == PresenceOuterClass$UpdateTypingStop.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$UpdateTypingStop;
        } else {
            this.trait_ = ((PresenceOuterClass$UpdateTypingStop.a) PresenceOuterClass$UpdateTypingStop.newBuilder((PresenceOuterClass$UpdateTypingStop) this.trait_).v(presenceOuterClass$UpdateTypingStop)).j();
        }
        this.traitCase_ = 81;
    }

    private void mergeUserAboutChanged(UsersOuterClass$UpdateUserAboutChanged usersOuterClass$UpdateUserAboutChanged) {
        usersOuterClass$UpdateUserAboutChanged.getClass();
        if (this.traitCase_ != 210 || this.trait_ == UsersOuterClass$UpdateUserAboutChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserAboutChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserAboutChanged.a) UsersOuterClass$UpdateUserAboutChanged.newBuilder((UsersOuterClass$UpdateUserAboutChanged) this.trait_).v(usersOuterClass$UpdateUserAboutChanged)).j();
        }
        this.traitCase_ = 210;
    }

    private void mergeUserAvatarChanged(UsersOuterClass$UpdateUserAvatarChanged usersOuterClass$UpdateUserAvatarChanged) {
        usersOuterClass$UpdateUserAvatarChanged.getClass();
        if (this.traitCase_ != 16 || this.trait_ == UsersOuterClass$UpdateUserAvatarChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserAvatarChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserAvatarChanged.a) UsersOuterClass$UpdateUserAvatarChanged.newBuilder((UsersOuterClass$UpdateUserAvatarChanged) this.trait_).v(usersOuterClass$UpdateUserAvatarChanged)).j();
        }
        this.traitCase_ = 16;
    }

    private void mergeUserBlocked(UsersOuterClass$UpdateUserBlocked usersOuterClass$UpdateUserBlocked) {
        usersOuterClass$UpdateUserBlocked.getClass();
        if (this.traitCase_ != 2629 || this.trait_ == UsersOuterClass$UpdateUserBlocked.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserBlocked;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserBlocked.a) UsersOuterClass$UpdateUserBlocked.newBuilder((UsersOuterClass$UpdateUserBlocked) this.trait_).v(usersOuterClass$UpdateUserBlocked)).j();
        }
        this.traitCase_ = 2629;
    }

    private void mergeUserBotCommandsChanged(UsersOuterClass$UpdateUserBotCommandsChanged usersOuterClass$UpdateUserBotCommandsChanged) {
        usersOuterClass$UpdateUserBotCommandsChanged.getClass();
        if (this.traitCase_ != 217 || this.trait_ == UsersOuterClass$UpdateUserBotCommandsChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserBotCommandsChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserBotCommandsChanged.a) UsersOuterClass$UpdateUserBotCommandsChanged.newBuilder((UsersOuterClass$UpdateUserBotCommandsChanged) this.trait_).v(usersOuterClass$UpdateUserBotCommandsChanged)).j();
        }
        this.traitCase_ = 217;
    }

    private void mergeUserContactsChanged(UsersOuterClass$UpdateUserContactsChanged usersOuterClass$UpdateUserContactsChanged) {
        usersOuterClass$UpdateUserContactsChanged.getClass();
        if (this.traitCase_ != 134 || this.trait_ == UsersOuterClass$UpdateUserContactsChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserContactsChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserContactsChanged.a) UsersOuterClass$UpdateUserContactsChanged.newBuilder((UsersOuterClass$UpdateUserContactsChanged) this.trait_).v(usersOuterClass$UpdateUserContactsChanged)).j();
        }
        this.traitCase_ = 134;
    }

    private void mergeUserDefaultBankAccountChanged(UsersOuterClass$UpdateUserDefaultBankAccountChanged usersOuterClass$UpdateUserDefaultBankAccountChanged) {
        usersOuterClass$UpdateUserDefaultBankAccountChanged.getClass();
        if (this.traitCase_ != 226 || this.trait_ == UsersOuterClass$UpdateUserDefaultBankAccountChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserDefaultBankAccountChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserDefaultBankAccountChanged.a) UsersOuterClass$UpdateUserDefaultBankAccountChanged.newBuilder((UsersOuterClass$UpdateUserDefaultBankAccountChanged) this.trait_).v(usersOuterClass$UpdateUserDefaultBankAccountChanged)).j();
        }
        this.traitCase_ = 226;
    }

    private void mergeUserDefaultCardNumberChanged(UsersOuterClass$UpdateUserDefaultCardNumberChanged usersOuterClass$UpdateUserDefaultCardNumberChanged) {
        usersOuterClass$UpdateUserDefaultCardNumberChanged.getClass();
        if (this.traitCase_ != 227 || this.trait_ == UsersOuterClass$UpdateUserDefaultCardNumberChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserDefaultCardNumberChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserDefaultCardNumberChanged.a) UsersOuterClass$UpdateUserDefaultCardNumberChanged.newBuilder((UsersOuterClass$UpdateUserDefaultCardNumberChanged) this.trait_).v(usersOuterClass$UpdateUserDefaultCardNumberChanged)).j();
        }
        this.traitCase_ = USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER;
    }

    private void mergeUserDefaultCardNumberRemoved(UsersOuterClass$UpdateUserDefaultCardNumberRemoved usersOuterClass$UpdateUserDefaultCardNumberRemoved) {
        usersOuterClass$UpdateUserDefaultCardNumberRemoved.getClass();
        if (this.traitCase_ != 228 || this.trait_ == UsersOuterClass$UpdateUserDefaultCardNumberRemoved.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserDefaultCardNumberRemoved;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserDefaultCardNumberRemoved.a) UsersOuterClass$UpdateUserDefaultCardNumberRemoved.newBuilder((UsersOuterClass$UpdateUserDefaultCardNumberRemoved) this.trait_).v(usersOuterClass$UpdateUserDefaultCardNumberRemoved)).j();
        }
        this.traitCase_ = USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER;
    }

    private void mergeUserExInfoChanged(UsersOuterClass$UpdateUserExInfoChanged usersOuterClass$UpdateUserExInfoChanged) {
        usersOuterClass$UpdateUserExInfoChanged.getClass();
        if (this.traitCase_ != 225 || this.trait_ == UsersOuterClass$UpdateUserExInfoChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserExInfoChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserExInfoChanged.a) UsersOuterClass$UpdateUserExInfoChanged.newBuilder((UsersOuterClass$UpdateUserExInfoChanged) this.trait_).v(usersOuterClass$UpdateUserExInfoChanged)).j();
        }
        this.traitCase_ = 225;
    }

    private void mergeUserExtChanged(UsersOuterClass$UpdateUserExtChanged usersOuterClass$UpdateUserExtChanged) {
        usersOuterClass$UpdateUserExtChanged.getClass();
        if (this.traitCase_ != 218 || this.trait_ == UsersOuterClass$UpdateUserExtChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserExtChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserExtChanged.a) UsersOuterClass$UpdateUserExtChanged.newBuilder((UsersOuterClass$UpdateUserExtChanged) this.trait_).v(usersOuterClass$UpdateUserExtChanged)).j();
        }
        this.traitCase_ = 218;
    }

    private void mergeUserFullExtChanged(UsersOuterClass$UpdateUserFullExtChanged usersOuterClass$UpdateUserFullExtChanged) {
        usersOuterClass$UpdateUserFullExtChanged.getClass();
        if (this.traitCase_ != 219 || this.trait_ == UsersOuterClass$UpdateUserFullExtChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserFullExtChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserFullExtChanged.a) UsersOuterClass$UpdateUserFullExtChanged.newBuilder((UsersOuterClass$UpdateUserFullExtChanged) this.trait_).v(usersOuterClass$UpdateUserFullExtChanged)).j();
        }
        this.traitCase_ = 219;
    }

    private void mergeUserLastSeen(PresenceOuterClass$UpdateUserLastSeen presenceOuterClass$UpdateUserLastSeen) {
        presenceOuterClass$UpdateUserLastSeen.getClass();
        if (this.traitCase_ != 9 || this.trait_ == PresenceOuterClass$UpdateUserLastSeen.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$UpdateUserLastSeen;
        } else {
            this.trait_ = ((PresenceOuterClass$UpdateUserLastSeen.a) PresenceOuterClass$UpdateUserLastSeen.newBuilder((PresenceOuterClass$UpdateUserLastSeen) this.trait_).v(presenceOuterClass$UpdateUserLastSeen)).j();
        }
        this.traitCase_ = 9;
    }

    private void mergeUserLastSeenUnknown(PresenceOuterClass$UpdateUserLastSeenUnknown presenceOuterClass$UpdateUserLastSeenUnknown) {
        presenceOuterClass$UpdateUserLastSeenUnknown.getClass();
        if (this.traitCase_ != 34 || this.trait_ == PresenceOuterClass$UpdateUserLastSeenUnknown.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$UpdateUserLastSeenUnknown;
        } else {
            this.trait_ = ((PresenceOuterClass$UpdateUserLastSeenUnknown.a) PresenceOuterClass$UpdateUserLastSeenUnknown.newBuilder((PresenceOuterClass$UpdateUserLastSeenUnknown) this.trait_).v(presenceOuterClass$UpdateUserLastSeenUnknown)).j();
        }
        this.traitCase_ = 34;
    }

    private void mergeUserLocalNameChanged(UsersOuterClass$UpdateUserLocalNameChanged usersOuterClass$UpdateUserLocalNameChanged) {
        usersOuterClass$UpdateUserLocalNameChanged.getClass();
        if (this.traitCase_ != 51 || this.trait_ == UsersOuterClass$UpdateUserLocalNameChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserLocalNameChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserLocalNameChanged.a) UsersOuterClass$UpdateUserLocalNameChanged.newBuilder((UsersOuterClass$UpdateUserLocalNameChanged) this.trait_).v(usersOuterClass$UpdateUserLocalNameChanged)).j();
        }
        this.traitCase_ = 51;
    }

    private void mergeUserNameChanged(UsersOuterClass$UpdateUserNameChanged usersOuterClass$UpdateUserNameChanged) {
        usersOuterClass$UpdateUserNameChanged.getClass();
        if (this.traitCase_ != 32 || this.trait_ == UsersOuterClass$UpdateUserNameChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserNameChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserNameChanged.a) UsersOuterClass$UpdateUserNameChanged.newBuilder((UsersOuterClass$UpdateUserNameChanged) this.trait_).v(usersOuterClass$UpdateUserNameChanged)).j();
        }
        this.traitCase_ = 32;
    }

    private void mergeUserNickChanged(UsersOuterClass$UpdateUserNickChanged usersOuterClass$UpdateUserNickChanged) {
        usersOuterClass$UpdateUserNickChanged.getClass();
        if (this.traitCase_ != 209 || this.trait_ == UsersOuterClass$UpdateUserNickChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserNickChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserNickChanged.a) UsersOuterClass$UpdateUserNickChanged.newBuilder((UsersOuterClass$UpdateUserNickChanged) this.trait_).v(usersOuterClass$UpdateUserNickChanged)).j();
        }
        this.traitCase_ = 209;
    }

    private void mergeUserOffline(PresenceOuterClass$UpdateUserOffline presenceOuterClass$UpdateUserOffline) {
        presenceOuterClass$UpdateUserOffline.getClass();
        if (this.traitCase_ != 8 || this.trait_ == PresenceOuterClass$UpdateUserOffline.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$UpdateUserOffline;
        } else {
            this.trait_ = ((PresenceOuterClass$UpdateUserOffline.a) PresenceOuterClass$UpdateUserOffline.newBuilder((PresenceOuterClass$UpdateUserOffline) this.trait_).v(presenceOuterClass$UpdateUserOffline)).j();
        }
        this.traitCase_ = 8;
    }

    private void mergeUserOnline(PresenceOuterClass$UpdateUserOnline presenceOuterClass$UpdateUserOnline) {
        presenceOuterClass$UpdateUserOnline.getClass();
        if (this.traitCase_ != 7 || this.trait_ == PresenceOuterClass$UpdateUserOnline.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$UpdateUserOnline;
        } else {
            this.trait_ = ((PresenceOuterClass$UpdateUserOnline.a) PresenceOuterClass$UpdateUserOnline.newBuilder((PresenceOuterClass$UpdateUserOnline) this.trait_).v(presenceOuterClass$UpdateUserOnline)).j();
        }
        this.traitCase_ = 7;
    }

    private void mergeUserPreferredLanguagesChanged(UsersOuterClass$UpdateUserPreferredLanguagesChanged usersOuterClass$UpdateUserPreferredLanguagesChanged) {
        usersOuterClass$UpdateUserPreferredLanguagesChanged.getClass();
        if (this.traitCase_ != 212 || this.trait_ == UsersOuterClass$UpdateUserPreferredLanguagesChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserPreferredLanguagesChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserPreferredLanguagesChanged.a) UsersOuterClass$UpdateUserPreferredLanguagesChanged.newBuilder((UsersOuterClass$UpdateUserPreferredLanguagesChanged) this.trait_).v(usersOuterClass$UpdateUserPreferredLanguagesChanged)).j();
        }
        this.traitCase_ = 212;
    }

    private void mergeUserTimeZoneChanged(UsersOuterClass$UpdateUserTimeZoneChanged usersOuterClass$UpdateUserTimeZoneChanged) {
        usersOuterClass$UpdateUserTimeZoneChanged.getClass();
        if (this.traitCase_ != 216 || this.trait_ == UsersOuterClass$UpdateUserTimeZoneChanged.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserTimeZoneChanged;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserTimeZoneChanged.a) UsersOuterClass$UpdateUserTimeZoneChanged.newBuilder((UsersOuterClass$UpdateUserTimeZoneChanged) this.trait_).v(usersOuterClass$UpdateUserTimeZoneChanged)).j();
        }
        this.traitCase_ = 216;
    }

    private void mergeUserUnblocked(UsersOuterClass$UpdateUserUnblocked usersOuterClass$UpdateUserUnblocked) {
        usersOuterClass$UpdateUserUnblocked.getClass();
        if (this.traitCase_ != 2630 || this.trait_ == UsersOuterClass$UpdateUserUnblocked.getDefaultInstance()) {
            this.trait_ = usersOuterClass$UpdateUserUnblocked;
        } else {
            this.trait_ = ((UsersOuterClass$UpdateUserUnblocked.a) UsersOuterClass$UpdateUserUnblocked.newBuilder((UsersOuterClass$UpdateUserUnblocked) this.trait_).v(usersOuterClass$UpdateUserUnblocked)).j();
        }
        this.traitCase_ = USER_UNBLOCKED_FIELD_NUMBER;
    }

    private void mergeVitrineChanged(VitrineOuterClass$UpdateVitrineChanged vitrineOuterClass$UpdateVitrineChanged) {
        vitrineOuterClass$UpdateVitrineChanged.getClass();
        if (this.traitCase_ != 52806 || this.trait_ == VitrineOuterClass$UpdateVitrineChanged.getDefaultInstance()) {
            this.trait_ = vitrineOuterClass$UpdateVitrineChanged;
        } else {
            this.trait_ = ((VitrineOuterClass$UpdateVitrineChanged.a) VitrineOuterClass$UpdateVitrineChanged.newBuilder((VitrineOuterClass$UpdateVitrineChanged) this.trait_).v(vitrineOuterClass$UpdateVitrineChanged)).j();
        }
        this.traitCase_ = VITRINE_CHANGED_FIELD_NUMBER;
    }

    private void mergeWalletBalanceUpdated(WalletOuterClass$UpdateWalletBalanceUpdated walletOuterClass$UpdateWalletBalanceUpdated) {
        walletOuterClass$UpdateWalletBalanceUpdated.getClass();
        if (this.traitCase_ != 62753 || this.trait_ == WalletOuterClass$UpdateWalletBalanceUpdated.getDefaultInstance()) {
            this.trait_ = walletOuterClass$UpdateWalletBalanceUpdated;
        } else {
            this.trait_ = ((WalletOuterClass$UpdateWalletBalanceUpdated.a) WalletOuterClass$UpdateWalletBalanceUpdated.newBuilder((WalletOuterClass$UpdateWalletBalanceUpdated) this.trait_).v(walletOuterClass$UpdateWalletBalanceUpdated)).j();
        }
        this.traitCase_ = WALLET_BALANCE_UPDATED_FIELD_NUMBER;
    }

    private void mergeWalletUpdated(WalletOuterClass$UpdateWalletUpdated walletOuterClass$UpdateWalletUpdated) {
        walletOuterClass$UpdateWalletUpdated.getClass();
        if (this.traitCase_ != 62732 || this.trait_ == WalletOuterClass$UpdateWalletUpdated.getDefaultInstance()) {
            this.trait_ = walletOuterClass$UpdateWalletUpdated;
        } else {
            this.trait_ = ((WalletOuterClass$UpdateWalletUpdated.a) WalletOuterClass$UpdateWalletUpdated.newBuilder((WalletOuterClass$UpdateWalletUpdated) this.trait_).v(walletOuterClass$UpdateWalletUpdated)).j();
        }
        this.traitCase_ = WALLET_UPDATED_FIELD_NUMBER;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SetUpdatesStruct$ComposedUpdates parseDelimitedFrom(InputStream inputStream) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(ByteBuffer byteBuffer) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountDeleted(AuthOuterClass$UpdateAccountDeleted authOuterClass$UpdateAccountDeleted) {
        authOuterClass$UpdateAccountDeleted.getClass();
        this.trait_ = authOuterClass$UpdateAccountDeleted;
        this.traitCase_ = ACCOUNT_DELETED_FIELD_NUMBER;
    }

    private void setAskBotReview(TimcheOuterClass$UpdateAskBotReview timcheOuterClass$UpdateAskBotReview) {
        timcheOuterClass$UpdateAskBotReview.getClass();
        this.trait_ = timcheOuterClass$UpdateAskBotReview;
        this.traitCase_ = ASK_BOT_REVIEW_FIELD_NUMBER;
    }

    private void setCallAccepted(MeetOuterClass$UpdateCallAccepted meetOuterClass$UpdateCallAccepted) {
        meetOuterClass$UpdateCallAccepted.getClass();
        this.trait_ = meetOuterClass$UpdateCallAccepted;
        this.traitCase_ = CALL_ACCEPTED_FIELD_NUMBER;
    }

    private void setCallAction(MeetOuterClass$UpdateCallAction meetOuterClass$UpdateCallAction) {
        meetOuterClass$UpdateCallAction.getClass();
        this.trait_ = meetOuterClass$UpdateCallAction;
        this.traitCase_ = CALL_ACTION_FIELD_NUMBER;
    }

    private void setCallDiscarded(MeetOuterClass$UpdateCallDiscarded meetOuterClass$UpdateCallDiscarded) {
        meetOuterClass$UpdateCallDiscarded.getClass();
        this.trait_ = meetOuterClass$UpdateCallDiscarded;
        this.traitCase_ = CALL_DISCARDED_FIELD_NUMBER;
    }

    private void setCallEvent(MeetOuterClass$UpdateCallEvent meetOuterClass$UpdateCallEvent) {
        meetOuterClass$UpdateCallEvent.getClass();
        this.trait_ = meetOuterClass$UpdateCallEvent;
        this.traitCase_ = CALL_EVENT_FIELD_NUMBER;
    }

    private void setCallJoinRequestAnswered(MeetOuterClass$UpdateCallJoinRequestAnswered meetOuterClass$UpdateCallJoinRequestAnswered) {
        meetOuterClass$UpdateCallJoinRequestAnswered.getClass();
        this.trait_ = meetOuterClass$UpdateCallJoinRequestAnswered;
        this.traitCase_ = CALL_JOIN_REQUEST_ANSWERED_FIELD_NUMBER;
    }

    private void setCallJoinRequestReceived(MeetOuterClass$UpdateCallJoinRequestReceived meetOuterClass$UpdateCallJoinRequestReceived) {
        meetOuterClass$UpdateCallJoinRequestReceived.getClass();
        this.trait_ = meetOuterClass$UpdateCallJoinRequestReceived;
        this.traitCase_ = CALL_JOIN_REQUEST_RECEIVED_FIELD_NUMBER;
    }

    private void setCallLinkGenerated(MeetOuterClass$UpdateCallLinkGenerated meetOuterClass$UpdateCallLinkGenerated) {
        meetOuterClass$UpdateCallLinkGenerated.getClass();
        this.trait_ = meetOuterClass$UpdateCallLinkGenerated;
        this.traitCase_ = CALL_LINK_GENERATED_FIELD_NUMBER;
    }

    private void setCallReactionSent(MeetOuterClass$UpdateCallReactionSent meetOuterClass$UpdateCallReactionSent) {
        meetOuterClass$UpdateCallReactionSent.getClass();
        this.trait_ = meetOuterClass$UpdateCallReactionSent;
        this.traitCase_ = CALL_REACTION_SENT_FIELD_NUMBER;
    }

    private void setCallReceived(MeetOuterClass$UpdateCallReceived meetOuterClass$UpdateCallReceived) {
        meetOuterClass$UpdateCallReceived.getClass();
        this.trait_ = meetOuterClass$UpdateCallReceived;
        this.traitCase_ = CALL_RECEIVED_FIELD_NUMBER;
    }

    private void setCallStarted(MeetOuterClass$UpdateCallStarted meetOuterClass$UpdateCallStarted) {
        meetOuterClass$UpdateCallStarted.getClass();
        this.trait_ = meetOuterClass$UpdateCallStarted;
        this.traitCase_ = CALL_STARTED_FIELD_NUMBER;
    }

    private void setCallUpgraded(MeetOuterClass$UpdateCallUpgraded meetOuterClass$UpdateCallUpgraded) {
        meetOuterClass$UpdateCallUpgraded.getClass();
        this.trait_ = meetOuterClass$UpdateCallUpgraded;
        this.traitCase_ = CALL_UPGRADED_FIELD_NUMBER;
    }

    private void setCardinalityChanged(MessagingOuterClass$UpdateCardinalityChanged messagingOuterClass$UpdateCardinalityChanged) {
        messagingOuterClass$UpdateCardinalityChanged.getClass();
        this.trait_ = messagingOuterClass$UpdateCardinalityChanged;
        this.traitCase_ = 254;
    }

    private void setChannelAdTagIdChanged(GroupsOuterClass$UpdateChannelAdTagIdChanged groupsOuterClass$UpdateChannelAdTagIdChanged) {
        groupsOuterClass$UpdateChannelAdTagIdChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateChannelAdTagIdChanged;
        this.traitCase_ = CHANNEL_AD_TAG_ID_CHANGED_FIELD_NUMBER;
    }

    private void setChannelAdvertisementTypeChanged(GroupsOuterClass$UpdateChannelAdvertisementTypeChanged groupsOuterClass$UpdateChannelAdvertisementTypeChanged) {
        groupsOuterClass$UpdateChannelAdvertisementTypeChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateChannelAdvertisementTypeChanged;
        this.traitCase_ = CHANNEL_ADVERTISEMENT_TYPE_CHANGED_FIELD_NUMBER;
    }

    private void setChannelNickChanged(GroupsOuterClass$UpdateChannelNickChanged groupsOuterClass$UpdateChannelNickChanged) {
        groupsOuterClass$UpdateChannelNickChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateChannelNickChanged;
        this.traitCase_ = CHANNEL_NICK_CHANGED_FIELD_NUMBER;
    }

    private void setChatArchive(MessagingOuterClass$UpdateChatArchive messagingOuterClass$UpdateChatArchive) {
        messagingOuterClass$UpdateChatArchive.getClass();
        this.trait_ = messagingOuterClass$UpdateChatArchive;
        this.traitCase_ = 94;
    }

    private void setChatClear(MessagingOuterClass$UpdateChatClear messagingOuterClass$UpdateChatClear) {
        messagingOuterClass$UpdateChatClear.getClass();
        this.trait_ = messagingOuterClass$UpdateChatClear;
        this.traitCase_ = 47;
    }

    private void setChatDelete(MessagingOuterClass$UpdateChatDelete messagingOuterClass$UpdateChatDelete) {
        messagingOuterClass$UpdateChatDelete.getClass();
        this.trait_ = messagingOuterClass$UpdateChatDelete;
        this.traitCase_ = 48;
    }

    private void setChatFavourite(MessagingOuterClass$UpdateChatFavourite messagingOuterClass$UpdateChatFavourite) {
        messagingOuterClass$UpdateChatFavourite.getClass();
        this.trait_ = messagingOuterClass$UpdateChatFavourite;
        this.traitCase_ = 95;
    }

    private void setChatGroupsChanged(MessagingOuterClass$UpdateChatGroupsChanged messagingOuterClass$UpdateChatGroupsChanged) {
        messagingOuterClass$UpdateChatGroupsChanged.getClass();
        this.trait_ = messagingOuterClass$UpdateChatGroupsChanged;
        this.traitCase_ = 1;
    }

    private void setChatShow(MessagingOuterClass$UpdateChatShow messagingOuterClass$UpdateChatShow) {
        messagingOuterClass$UpdateChatShow.getClass();
        this.trait_ = messagingOuterClass$UpdateChatShow;
        this.traitCase_ = 93;
    }

    private void setContactRegistered(UsersOuterClass$UpdateContactRegistered usersOuterClass$UpdateContactRegistered) {
        usersOuterClass$UpdateContactRegistered.getClass();
        this.trait_ = usersOuterClass$UpdateContactRegistered;
        this.traitCase_ = 5;
    }

    private void setContactsAdded(UsersOuterClass$UpdateContactsAdded usersOuterClass$UpdateContactsAdded) {
        usersOuterClass$UpdateContactsAdded.getClass();
        this.trait_ = usersOuterClass$UpdateContactsAdded;
        this.traitCase_ = 40;
    }

    private void setContactsRemoved(UsersOuterClass$UpdateContactsRemoved usersOuterClass$UpdateContactsRemoved) {
        usersOuterClass$UpdateContactsRemoved.getClass();
        this.trait_ = usersOuterClass$UpdateContactsRemoved;
        this.traitCase_ = 41;
    }

    private void setDialogArchiveStatus(MessagingOuterClass$UpdateDialogArchiveStatus messagingOuterClass$UpdateDialogArchiveStatus) {
        messagingOuterClass$UpdateDialogArchiveStatus.getClass();
        this.trait_ = messagingOuterClass$UpdateDialogArchiveStatus;
        this.traitCase_ = DIALOG_ARCHIVE_STATUS_FIELD_NUMBER;
    }

    private void setDialogsMarkedAsRead(MessagingOuterClass$UpdateDialogsMarkedAsRead messagingOuterClass$UpdateDialogsMarkedAsRead) {
        messagingOuterClass$UpdateDialogsMarkedAsRead.getClass();
        this.trait_ = messagingOuterClass$UpdateDialogsMarkedAsRead;
        this.traitCase_ = DIALOGS_MARKED_AS_READ_FIELD_NUMBER;
    }

    private void setDialogsMarkedAsUnread(MessagingOuterClass$UpdateDialogsMarkedAsUnread messagingOuterClass$UpdateDialogsMarkedAsUnread) {
        messagingOuterClass$UpdateDialogsMarkedAsUnread.getClass();
        this.trait_ = messagingOuterClass$UpdateDialogsMarkedAsUnread;
        this.traitCase_ = DIALOGS_MARKED_AS_UNREAD_FIELD_NUMBER;
    }

    private void setDialogsUnpinned(MessagingOuterClass$UpdateDialogsUnpinned messagingOuterClass$UpdateDialogsUnpinned) {
        messagingOuterClass$UpdateDialogsUnpinned.getClass();
        this.trait_ = messagingOuterClass$UpdateDialogsUnpinned;
        this.traitCase_ = DIALOGS_UNPINNED_FIELD_NUMBER;
    }

    private void setEmptyUpdate(Sequence$UpdateEmptyUpdate sequence$UpdateEmptyUpdate) {
        sequence$UpdateEmptyUpdate.getClass();
        this.trait_ = sequence$UpdateEmptyUpdate;
        this.traitCase_ = 85;
    }

    private void setEndLive(LahzeOuterClass$UpdateEndLive lahzeOuterClass$UpdateEndLive) {
        lahzeOuterClass$UpdateEndLive.getClass();
        this.trait_ = lahzeOuterClass$UpdateEndLive;
        this.traitCase_ = END_LIVE_FIELD_NUMBER;
    }

    private void setEndpointChanged(ConfigsOuterClass$UpdateEndpointChanged configsOuterClass$UpdateEndpointChanged) {
        configsOuterClass$UpdateEndpointChanged.getClass();
        this.trait_ = configsOuterClass$UpdateEndpointChanged;
        this.traitCase_ = ENDPOINT_CHANGED_FIELD_NUMBER;
    }

    private void setFolderCreated(MessagingOuterClass$UpdateFolderCreated messagingOuterClass$UpdateFolderCreated) {
        messagingOuterClass$UpdateFolderCreated.getClass();
        this.trait_ = messagingOuterClass$UpdateFolderCreated;
        this.traitCase_ = FOLDER_CREATED_FIELD_NUMBER;
    }

    private void setFolderDeleted(MessagingOuterClass$UpdateFolderDeleted messagingOuterClass$UpdateFolderDeleted) {
        messagingOuterClass$UpdateFolderDeleted.getClass();
        this.trait_ = messagingOuterClass$UpdateFolderDeleted;
        this.traitCase_ = FOLDER_DELETED_FIELD_NUMBER;
    }

    private void setFolderEdited(MessagingOuterClass$UpdateFolderEdited messagingOuterClass$UpdateFolderEdited) {
        messagingOuterClass$UpdateFolderEdited.getClass();
        this.trait_ = messagingOuterClass$UpdateFolderEdited;
        this.traitCase_ = FOLDER_EDITED_FIELD_NUMBER;
    }

    private void setFoldersReordered(MessagingOuterClass$UpdateFoldersReordered messagingOuterClass$UpdateFoldersReordered) {
        messagingOuterClass$UpdateFoldersReordered.getClass();
        this.trait_ = messagingOuterClass$UpdateFoldersReordered;
        this.traitCase_ = FOLDERS_REORDERED_FIELD_NUMBER;
    }

    private void setForceClearCache(Sequence$UpdateForceClearCache sequence$UpdateForceClearCache) {
        sequence$UpdateForceClearCache.getClass();
        this.trait_ = sequence$UpdateForceClearCache;
        this.traitCase_ = 86;
    }

    private void setGeneralNotificationMessage(Turing$UpdateGeneralNotificationMessage turing$UpdateGeneralNotificationMessage) {
        turing$UpdateGeneralNotificationMessage.getClass();
        this.trait_ = turing$UpdateGeneralNotificationMessage;
        this.traitCase_ = GENERAL_NOTIFICATION_MESSAGE_FIELD_NUMBER;
    }

    private void setGroupAboutChanged(GroupsOuterClass$UpdateGroupAboutChanged groupsOuterClass$UpdateGroupAboutChanged) {
        groupsOuterClass$UpdateGroupAboutChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupAboutChanged;
        this.traitCase_ = GROUP_ABOUT_CHANGED_FIELD_NUMBER;
    }

    private void setGroupAboutChangedObsolete(GroupsOuterClass$UpdateGroupAboutChangedObsolete groupsOuterClass$UpdateGroupAboutChangedObsolete) {
        groupsOuterClass$UpdateGroupAboutChangedObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupAboutChangedObsolete;
        this.traitCase_ = GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER;
    }

    private void setGroupAvatarChanged(GroupsOuterClass$UpdateGroupAvatarChanged groupsOuterClass$UpdateGroupAvatarChanged) {
        groupsOuterClass$UpdateGroupAvatarChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupAvatarChanged;
        this.traitCase_ = GROUP_AVATAR_CHANGED_FIELD_NUMBER;
    }

    private void setGroupAvatarChangedObsolete(GroupsOuterClass$UpdateGroupAvatarChangedObsolete groupsOuterClass$UpdateGroupAvatarChangedObsolete) {
        groupsOuterClass$UpdateGroupAvatarChangedObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupAvatarChangedObsolete;
        this.traitCase_ = 39;
    }

    private void setGroupBecameOrphaned(GroupsOuterClass$UpdateGroupBecameOrphaned groupsOuterClass$UpdateGroupBecameOrphaned) {
        groupsOuterClass$UpdateGroupBecameOrphaned.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupBecameOrphaned;
        this.traitCase_ = 2628;
    }

    private void setGroupCallEnded(MeetOuterClass$UpdateGroupCallEnded meetOuterClass$UpdateGroupCallEnded) {
        meetOuterClass$UpdateGroupCallEnded.getClass();
        this.trait_ = meetOuterClass$UpdateGroupCallEnded;
        this.traitCase_ = GROUP_CALL_ENDED_FIELD_NUMBER;
    }

    private void setGroupCallStarted(MeetOuterClass$UpdateGroupCallStarted meetOuterClass$UpdateGroupCallStarted) {
        meetOuterClass$UpdateGroupCallStarted.getClass();
        this.trait_ = meetOuterClass$UpdateGroupCallStarted;
        this.traitCase_ = GROUP_CALL_STARTED_FIELD_NUMBER;
    }

    private void setGroupCanInviteMembersChanged(GroupsOuterClass$UpdateGroupCanInviteMembersChanged groupsOuterClass$UpdateGroupCanInviteMembersChanged) {
        groupsOuterClass$UpdateGroupCanInviteMembersChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupCanInviteMembersChanged;
        this.traitCase_ = GROUP_CAN_INVITE_MEMBERS_CHANGED_FIELD_NUMBER;
    }

    private void setGroupCanSendMessagesChanged(GroupsOuterClass$UpdateGroupCanSendMessagesChanged groupsOuterClass$UpdateGroupCanSendMessagesChanged) {
        groupsOuterClass$UpdateGroupCanSendMessagesChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupCanSendMessagesChanged;
        this.traitCase_ = GROUP_CAN_SEND_MESSAGES_CHANGED_FIELD_NUMBER;
    }

    private void setGroupCanViewMembersChanged(GroupsOuterClass$UpdateGroupCanViewMembersChanged groupsOuterClass$UpdateGroupCanViewMembersChanged) {
        groupsOuterClass$UpdateGroupCanViewMembersChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupCanViewMembersChanged;
        this.traitCase_ = 2625;
    }

    private void setGroupDefaultPermissionsChanged(GroupsOuterClass$UpdateGroupDefaultPermissionsChanged groupsOuterClass$UpdateGroupDefaultPermissionsChanged) {
        groupsOuterClass$UpdateGroupDefaultPermissionsChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupDefaultPermissionsChanged;
        this.traitCase_ = GROUP_DEFAULT_PERMISSIONS_CHANGED_FIELD_NUMBER;
    }

    private void setGroupExInfoChanged(GroupsOuterClass$UpdateGroupExInfoChanged groupsOuterClass$UpdateGroupExInfoChanged) {
        groupsOuterClass$UpdateGroupExInfoChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupExInfoChanged;
        this.traitCase_ = GROUP_EX_INFO_CHANGED_FIELD_NUMBER;
    }

    private void setGroupExtChanged(GroupsOuterClass$UpdateGroupExtChanged groupsOuterClass$UpdateGroupExtChanged) {
        groupsOuterClass$UpdateGroupExtChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupExtChanged;
        this.traitCase_ = GROUP_EXT_CHANGED_FIELD_NUMBER;
    }

    private void setGroupFullExtChanged(GroupsOuterClass$UpdateGroupFullExtChanged groupsOuterClass$UpdateGroupFullExtChanged) {
        groupsOuterClass$UpdateGroupFullExtChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupFullExtChanged;
        this.traitCase_ = GROUP_FULL_EXT_CHANGED_FIELD_NUMBER;
    }

    private void setGroupHistoryShared(GroupsOuterClass$UpdateGroupHistoryShared groupsOuterClass$UpdateGroupHistoryShared) {
        groupsOuterClass$UpdateGroupHistoryShared.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupHistoryShared;
        this.traitCase_ = GROUP_HISTORY_SHARED_FIELD_NUMBER;
    }

    private void setGroupInviteObsolete(GroupsOuterClass$UpdateGroupInviteObsolete groupsOuterClass$UpdateGroupInviteObsolete) {
        groupsOuterClass$UpdateGroupInviteObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupInviteObsolete;
        this.traitCase_ = 36;
    }

    private void setGroupMemberAdminChanged(GroupsOuterClass$UpdateGroupMemberAdminChanged groupsOuterClass$UpdateGroupMemberAdminChanged) {
        groupsOuterClass$UpdateGroupMemberAdminChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMemberAdminChanged;
        this.traitCase_ = GROUP_MEMBER_ADMIN_CHANGED_FIELD_NUMBER;
    }

    private void setGroupMemberChanged(GroupsOuterClass$UpdateGroupMemberChanged groupsOuterClass$UpdateGroupMemberChanged) {
        groupsOuterClass$UpdateGroupMemberChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMemberChanged;
        this.traitCase_ = GROUP_MEMBER_CHANGED_FIELD_NUMBER;
    }

    private void setGroupMemberDiff(GroupsOuterClass$UpdateGroupMemberDiff groupsOuterClass$UpdateGroupMemberDiff) {
        groupsOuterClass$UpdateGroupMemberDiff.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMemberDiff;
        this.traitCase_ = GROUP_MEMBER_DIFF_FIELD_NUMBER;
    }

    private void setGroupMemberPermissionsChanged(GroupsOuterClass$UpdateGroupMemberPermissionsChanged groupsOuterClass$UpdateGroupMemberPermissionsChanged) {
        groupsOuterClass$UpdateGroupMemberPermissionsChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMemberPermissionsChanged;
        this.traitCase_ = GROUP_MEMBER_PERMISSIONS_CHANGED_FIELD_NUMBER;
    }

    private void setGroupMembersBecameAsync(GroupsOuterClass$UpdateGroupMembersBecameAsync groupsOuterClass$UpdateGroupMembersBecameAsync) {
        groupsOuterClass$UpdateGroupMembersBecameAsync.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMembersBecameAsync;
        this.traitCase_ = GROUP_MEMBERS_BECAME_ASYNC_FIELD_NUMBER;
    }

    private void setGroupMembersCountChanged(GroupsOuterClass$UpdateGroupMembersCountChanged groupsOuterClass$UpdateGroupMembersCountChanged) {
        groupsOuterClass$UpdateGroupMembersCountChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMembersCountChanged;
        this.traitCase_ = GROUP_MEMBERS_COUNT_CHANGED_FIELD_NUMBER;
    }

    private void setGroupMembersUpdateObsolete(GroupsOuterClass$UpdateGroupMembersUpdateObsolete groupsOuterClass$UpdateGroupMembersUpdateObsolete) {
        groupsOuterClass$UpdateGroupMembersUpdateObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMembersUpdateObsolete;
        this.traitCase_ = 44;
    }

    private void setGroupMembersUpdated(GroupsOuterClass$UpdateGroupMembersUpdated groupsOuterClass$UpdateGroupMembersUpdated) {
        groupsOuterClass$UpdateGroupMembersUpdated.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMembersUpdated;
        this.traitCase_ = GROUP_MEMBERS_UPDATED_FIELD_NUMBER;
    }

    private void setGroupMessagePinned(GroupsOuterClass$UpdateGroupMessagePinned groupsOuterClass$UpdateGroupMessagePinned) {
        groupsOuterClass$UpdateGroupMessagePinned.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupMessagePinned;
        this.traitCase_ = GROUP_MESSAGE_PINNED_FIELD_NUMBER;
    }

    private void setGroupNicknameChanged(GroupsOuterClass$UpdateGroupNicknameChanged groupsOuterClass$UpdateGroupNicknameChanged) {
        groupsOuterClass$UpdateGroupNicknameChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupNicknameChanged;
        this.traitCase_ = 57;
    }

    private void setGroupOnline(PresenceOuterClass$UpdateGroupOnline presenceOuterClass$UpdateGroupOnline) {
        presenceOuterClass$UpdateGroupOnline.getClass();
        this.trait_ = presenceOuterClass$UpdateGroupOnline;
        this.traitCase_ = 33;
    }

    private void setGroupOwnerChanged(GroupsOuterClass$UpdateGroupOwnerChanged groupsOuterClass$UpdateGroupOwnerChanged) {
        groupsOuterClass$UpdateGroupOwnerChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupOwnerChanged;
        this.traitCase_ = GROUP_OWNER_CHANGED_FIELD_NUMBER;
    }

    private void setGroupPinRemoved(GroupsOuterClass$UpdateGroupPinRemoved groupsOuterClass$UpdateGroupPinRemoved) {
        groupsOuterClass$UpdateGroupPinRemoved.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupPinRemoved;
        this.traitCase_ = GROUP_PIN_REMOVED_FIELD_NUMBER;
    }

    private void setGroupRestrictionChanged(GroupsOuterClass$UpdateGroupRestrictionChanged groupsOuterClass$UpdateGroupRestrictionChanged) {
        groupsOuterClass$UpdateGroupRestrictionChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupRestrictionChanged;
        this.traitCase_ = GROUP_RESTRICTION_CHANGED_FIELD_NUMBER;
    }

    private void setGroupTitleChanged(GroupsOuterClass$UpdateGroupTitleChanged groupsOuterClass$UpdateGroupTitleChanged) {
        groupsOuterClass$UpdateGroupTitleChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupTitleChanged;
        this.traitCase_ = GROUP_TITLE_CHANGED_FIELD_NUMBER;
    }

    private void setGroupTitleChangedObsolete(GroupsOuterClass$UpdateGroupTitleChangedObsolete groupsOuterClass$UpdateGroupTitleChangedObsolete) {
        groupsOuterClass$UpdateGroupTitleChangedObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupTitleChangedObsolete;
        this.traitCase_ = 38;
    }

    private void setGroupTopicChanged(GroupsOuterClass$UpdateGroupTopicChanged groupsOuterClass$UpdateGroupTopicChanged) {
        groupsOuterClass$UpdateGroupTopicChanged.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupTopicChanged;
        this.traitCase_ = GROUP_TOPIC_CHANGED_FIELD_NUMBER;
    }

    private void setGroupTopicChangedObsolete(GroupsOuterClass$UpdateGroupTopicChangedObsolete groupsOuterClass$UpdateGroupTopicChangedObsolete) {
        groupsOuterClass$UpdateGroupTopicChangedObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupTopicChangedObsolete;
        this.traitCase_ = 213;
    }

    private void setGroupUserInvitedObsolete(GroupsOuterClass$UpdateGroupUserInvitedObsolete groupsOuterClass$UpdateGroupUserInvitedObsolete) {
        groupsOuterClass$UpdateGroupUserInvitedObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupUserInvitedObsolete;
        this.traitCase_ = 21;
    }

    private void setGroupUserKickObsolete(GroupsOuterClass$UpdateGroupUserKickObsolete groupsOuterClass$UpdateGroupUserKickObsolete) {
        groupsOuterClass$UpdateGroupUserKickObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupUserKickObsolete;
        this.traitCase_ = 24;
    }

    private void setGroupUserLeaveObsolete(GroupsOuterClass$UpdateGroupUserLeaveObsolete groupsOuterClass$UpdateGroupUserLeaveObsolete) {
        groupsOuterClass$UpdateGroupUserLeaveObsolete.getClass();
        this.trait_ = groupsOuterClass$UpdateGroupUserLeaveObsolete;
        this.traitCase_ = 23;
    }

    private void setHidePrivacyBar(ReportOuterClass$UpdateHidePrivacyBar reportOuterClass$UpdateHidePrivacyBar) {
        reportOuterClass$UpdateHidePrivacyBar.getClass();
        this.trait_ = reportOuterClass$UpdateHidePrivacyBar;
        this.traitCase_ = HIDE_PRIVACY_BAR_FIELD_NUMBER;
    }

    private void setMentionReadByMe(MessagingOuterClass$UpdateMentionReadByMe messagingOuterClass$UpdateMentionReadByMe) {
        messagingOuterClass$UpdateMentionReadByMe.getClass();
        this.trait_ = messagingOuterClass$UpdateMentionReadByMe;
        this.traitCase_ = MENTION_READ_BY_ME_FIELD_NUMBER;
    }

    private void setMessage(MessagingOuterClass$UpdateMessage messagingOuterClass$UpdateMessage) {
        messagingOuterClass$UpdateMessage.getClass();
        this.trait_ = messagingOuterClass$UpdateMessage;
        this.traitCase_ = 55;
    }

    private void setMessageContentChanged(MessagingOuterClass$UpdateMessageContentChanged messagingOuterClass$UpdateMessageContentChanged) {
        messagingOuterClass$UpdateMessageContentChanged.getClass();
        this.trait_ = messagingOuterClass$UpdateMessageContentChanged;
        this.traitCase_ = MESSAGE_CONTENT_CHANGED_FIELD_NUMBER;
    }

    private void setMessageDateChanged(MessagingOuterClass$UpdateMessageDateChanged messagingOuterClass$UpdateMessageDateChanged) {
        messagingOuterClass$UpdateMessageDateChanged.getClass();
        this.trait_ = messagingOuterClass$UpdateMessageDateChanged;
        this.traitCase_ = MESSAGE_DATE_CHANGED_FIELD_NUMBER;
    }

    private void setMessageDelete(MessagingOuterClass$UpdateMessageDelete messagingOuterClass$UpdateMessageDelete) {
        messagingOuterClass$UpdateMessageDelete.getClass();
        this.trait_ = messagingOuterClass$UpdateMessageDelete;
        this.traitCase_ = 46;
    }

    private void setMessageNewReaction(AbacusOuterClass$UpdateMessageNewReaction abacusOuterClass$UpdateMessageNewReaction) {
        abacusOuterClass$UpdateMessageNewReaction.getClass();
        this.trait_ = abacusOuterClass$UpdateMessageNewReaction;
        this.traitCase_ = MESSAGE_NEW_REACTION_FIELD_NUMBER;
    }

    private void setMessagePinned(MessagingOuterClass$UpdateMessagePinned messagingOuterClass$UpdateMessagePinned) {
        messagingOuterClass$UpdateMessagePinned.getClass();
        this.trait_ = messagingOuterClass$UpdateMessagePinned;
        this.traitCase_ = MESSAGE_PINNED_FIELD_NUMBER;
    }

    private void setMessageQuotedChanged(MessagingOuterClass$UpdateMessageQuotedChanged messagingOuterClass$UpdateMessageQuotedChanged) {
        messagingOuterClass$UpdateMessageQuotedChanged.getClass();
        this.trait_ = messagingOuterClass$UpdateMessageQuotedChanged;
        this.traitCase_ = MESSAGE_QUOTED_CHANGED_FIELD_NUMBER;
    }

    private void setMessageReactions(AbacusOuterClass$UpdateMessageReactions abacusOuterClass$UpdateMessageReactions) {
        abacusOuterClass$UpdateMessageReactions.getClass();
        this.trait_ = abacusOuterClass$UpdateMessageReactions;
        this.traitCase_ = MESSAGE_REACTIONS_FIELD_NUMBER;
    }

    private void setMessageReactionsReadByMe(AbacusOuterClass$UpdateMessageReactionsReadByMe abacusOuterClass$UpdateMessageReactionsReadByMe) {
        abacusOuterClass$UpdateMessageReactionsReadByMe.getClass();
        this.trait_ = abacusOuterClass$UpdateMessageReactionsReadByMe;
        this.traitCase_ = MESSAGE_REACTIONS_READ_BY_ME_FIELD_NUMBER;
    }

    private void setMessageRead(MessagingOuterClass$UpdateMessageRead messagingOuterClass$UpdateMessageRead) {
        messagingOuterClass$UpdateMessageRead.getClass();
        this.trait_ = messagingOuterClass$UpdateMessageRead;
        this.traitCase_ = 19;
    }

    private void setMessageReadByMe(MessagingOuterClass$UpdateMessageReadByMe messagingOuterClass$UpdateMessageReadByMe) {
        messagingOuterClass$UpdateMessageReadByMe.getClass();
        this.trait_ = messagingOuterClass$UpdateMessageReadByMe;
        this.traitCase_ = 50;
    }

    private void setMessageReceived(MessagingOuterClass$UpdateMessageReceived messagingOuterClass$UpdateMessageReceived) {
        messagingOuterClass$UpdateMessageReceived.getClass();
        this.trait_ = messagingOuterClass$UpdateMessageReceived;
        this.traitCase_ = 54;
    }

    private void setMessageSent(MessagingOuterClass$UpdateMessageSent messagingOuterClass$UpdateMessageSent) {
        messagingOuterClass$UpdateMessageSent.getClass();
        this.trait_ = messagingOuterClass$UpdateMessageSent;
        this.traitCase_ = 4;
    }

    private void setMessages(MessagingOuterClass$UpdateMessages messagingOuterClass$UpdateMessages) {
        messagingOuterClass$UpdateMessages.getClass();
        this.trait_ = messagingOuterClass$UpdateMessages;
        this.traitCase_ = _MESSAGES_FIELD_NUMBER;
    }

    private void setMessagesUnPinned(MessagingOuterClass$UpdateMessagesUnPinned messagingOuterClass$UpdateMessagesUnPinned) {
        messagingOuterClass$UpdateMessagesUnPinned.getClass();
        this.trait_ = messagingOuterClass$UpdateMessagesUnPinned;
        this.traitCase_ = MESSAGES_UN_PINNED_FIELD_NUMBER;
    }

    private void setMultiPeerCallStarted(MeetOuterClass$UpdateMultiPeerCallStarted meetOuterClass$UpdateMultiPeerCallStarted) {
        meetOuterClass$UpdateMultiPeerCallStarted.getClass();
        this.trait_ = meetOuterClass$UpdateMultiPeerCallStarted;
        this.traitCase_ = MULTI_PEER_CALL_STARTED_FIELD_NUMBER;
    }

    private void setOwnStickersChanged(ImagesOuterClass$UpdateOwnStickersChanged imagesOuterClass$UpdateOwnStickersChanged) {
        imagesOuterClass$UpdateOwnStickersChanged.getClass();
        this.trait_ = imagesOuterClass$UpdateOwnStickersChanged;
        this.traitCase_ = OWN_STICKERS_CHANGED_FIELD_NUMBER;
    }

    private void setParameterChanged(ConfigsOuterClass$UpdateParameterChanged configsOuterClass$UpdateParameterChanged) {
        configsOuterClass$UpdateParameterChanged.getClass();
        this.trait_ = configsOuterClass$UpdateParameterChanged;
        this.traitCase_ = 131;
    }

    private void setPeersInvited(MeetOuterClass$UpdatePeersInvited meetOuterClass$UpdatePeersInvited) {
        meetOuterClass$UpdatePeersInvited.getClass();
        this.trait_ = meetOuterClass$UpdatePeersInvited;
        this.traitCase_ = PEERS_INVITED_FIELD_NUMBER;
    }

    private void setPeersStateChanged(MeetOuterClass$UpdatePeersStateChanged meetOuterClass$UpdatePeersStateChanged) {
        meetOuterClass$UpdatePeersStateChanged.getClass();
        this.trait_ = meetOuterClass$UpdatePeersStateChanged;
        this.traitCase_ = PEERS_STATE_CHANGED_FIELD_NUMBER;
    }

    private void setPhoneNumberChanged(UsersOuterClass$UpdatePhoneNumberChanged usersOuterClass$UpdatePhoneNumberChanged) {
        usersOuterClass$UpdatePhoneNumberChanged.getClass();
        this.trait_ = usersOuterClass$UpdatePhoneNumberChanged;
        this.traitCase_ = PHONE_NUMBER_CHANGED_FIELD_NUMBER;
    }

    private void setPinnedDialogsChanged(MessagingOuterClass$UpdatePinnedDialogsChanged messagingOuterClass$UpdatePinnedDialogsChanged) {
        messagingOuterClass$UpdatePinnedDialogsChanged.getClass();
        this.trait_ = messagingOuterClass$UpdatePinnedDialogsChanged;
        this.traitCase_ = PINNED_DIALOGS_CHANGED_FIELD_NUMBER;
    }

    private void setPremiumPurchaseStatus(PremiumOuterClass$UpdatePremiumPurchaseStatus premiumOuterClass$UpdatePremiumPurchaseStatus) {
        premiumOuterClass$UpdatePremiumPurchaseStatus.getClass();
        this.trait_ = premiumOuterClass$UpdatePremiumPurchaseStatus;
        this.traitCase_ = PREMIUM_PURCHASE_STATUS_FIELD_NUMBER;
    }

    private void setRawUpdate(Sequence$UpdateRawUpdate sequence$UpdateRawUpdate) {
        sequence$UpdateRawUpdate.getClass();
        this.trait_ = sequence$UpdateRawUpdate;
        this.traitCase_ = 80;
    }

    private void setReactionsUpdate(AbacusOuterClass$UpdateReactionsUpdate abacusOuterClass$UpdateReactionsUpdate) {
        abacusOuterClass$UpdateReactionsUpdate.getClass();
        this.trait_ = abacusOuterClass$UpdateReactionsUpdate;
        this.traitCase_ = 222;
    }

    private void setRequestBankiAccessFor(BankOuterClass$UpdateRequestBankiAccessFor bankOuterClass$UpdateRequestBankiAccessFor) {
        bankOuterClass$UpdateRequestBankiAccessFor.getClass();
        this.trait_ = bankOuterClass$UpdateRequestBankiAccessFor;
        this.traitCase_ = REQUEST_BANKI_ACCESS_FOR_FIELD_NUMBER;
    }

    private void setRequestLogin(BankOuterClass$UpdateRequestLogin bankOuterClass$UpdateRequestLogin) {
        bankOuterClass$UpdateRequestLogin.getClass();
        this.trait_ = bankOuterClass$UpdateRequestLogin;
        this.traitCase_ = REQUEST_LOGIN_FIELD_NUMBER;
    }

    private void setSavedGifsChanged(ImagesOuterClass$UpdateSavedGifsChanged imagesOuterClass$UpdateSavedGifsChanged) {
        imagesOuterClass$UpdateSavedGifsChanged.getClass();
        this.trait_ = imagesOuterClass$UpdateSavedGifsChanged;
        this.traitCase_ = SAVED_GIFS_CHANGED_FIELD_NUMBER;
    }

    private void setStartLive(LahzeOuterClass$UpdateStartLive lahzeOuterClass$UpdateStartLive) {
        lahzeOuterClass$UpdateStartLive.getClass();
        this.trait_ = lahzeOuterClass$UpdateStartLive;
        this.traitCase_ = START_LIVE_FIELD_NUMBER;
    }

    private void setStickerCollectionsChanged(ImagesOuterClass$UpdateStickerCollectionsChanged imagesOuterClass$UpdateStickerCollectionsChanged) {
        imagesOuterClass$UpdateStickerCollectionsChanged.getClass();
        this.trait_ = imagesOuterClass$UpdateStickerCollectionsChanged;
        this.traitCase_ = STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER;
    }

    private void setStickerPacksChanged(ImagesOuterClass$UpdateStickerPacksChanged imagesOuterClass$UpdateStickerPacksChanged) {
        imagesOuterClass$UpdateStickerPacksChanged.getClass();
        this.trait_ = imagesOuterClass$UpdateStickerPacksChanged;
        this.traitCase_ = STICKER_PACKS_CHANGED_FIELD_NUMBER;
    }

    private void setTranscriptReady(Turing$UpdateTranscriptReady turing$UpdateTranscriptReady) {
        turing$UpdateTranscriptReady.getClass();
        this.trait_ = turing$UpdateTranscriptReady;
        this.traitCase_ = TRANSCRIPT_READY_FIELD_NUMBER;
    }

    private void setTyping(PresenceOuterClass$UpdateTyping presenceOuterClass$UpdateTyping) {
        presenceOuterClass$UpdateTyping.getClass();
        this.trait_ = presenceOuterClass$UpdateTyping;
        this.traitCase_ = 6;
    }

    private void setTypingStop(PresenceOuterClass$UpdateTypingStop presenceOuterClass$UpdateTypingStop) {
        presenceOuterClass$UpdateTypingStop.getClass();
        this.trait_ = presenceOuterClass$UpdateTypingStop;
        this.traitCase_ = 81;
    }

    private void setUserAboutChanged(UsersOuterClass$UpdateUserAboutChanged usersOuterClass$UpdateUserAboutChanged) {
        usersOuterClass$UpdateUserAboutChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserAboutChanged;
        this.traitCase_ = 210;
    }

    private void setUserAvatarChanged(UsersOuterClass$UpdateUserAvatarChanged usersOuterClass$UpdateUserAvatarChanged) {
        usersOuterClass$UpdateUserAvatarChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserAvatarChanged;
        this.traitCase_ = 16;
    }

    private void setUserBlocked(UsersOuterClass$UpdateUserBlocked usersOuterClass$UpdateUserBlocked) {
        usersOuterClass$UpdateUserBlocked.getClass();
        this.trait_ = usersOuterClass$UpdateUserBlocked;
        this.traitCase_ = 2629;
    }

    private void setUserBotCommandsChanged(UsersOuterClass$UpdateUserBotCommandsChanged usersOuterClass$UpdateUserBotCommandsChanged) {
        usersOuterClass$UpdateUserBotCommandsChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserBotCommandsChanged;
        this.traitCase_ = 217;
    }

    private void setUserContactsChanged(UsersOuterClass$UpdateUserContactsChanged usersOuterClass$UpdateUserContactsChanged) {
        usersOuterClass$UpdateUserContactsChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserContactsChanged;
        this.traitCase_ = 134;
    }

    private void setUserDefaultBankAccountChanged(UsersOuterClass$UpdateUserDefaultBankAccountChanged usersOuterClass$UpdateUserDefaultBankAccountChanged) {
        usersOuterClass$UpdateUserDefaultBankAccountChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserDefaultBankAccountChanged;
        this.traitCase_ = 226;
    }

    private void setUserDefaultCardNumberChanged(UsersOuterClass$UpdateUserDefaultCardNumberChanged usersOuterClass$UpdateUserDefaultCardNumberChanged) {
        usersOuterClass$UpdateUserDefaultCardNumberChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserDefaultCardNumberChanged;
        this.traitCase_ = USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER;
    }

    private void setUserDefaultCardNumberRemoved(UsersOuterClass$UpdateUserDefaultCardNumberRemoved usersOuterClass$UpdateUserDefaultCardNumberRemoved) {
        usersOuterClass$UpdateUserDefaultCardNumberRemoved.getClass();
        this.trait_ = usersOuterClass$UpdateUserDefaultCardNumberRemoved;
        this.traitCase_ = USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER;
    }

    private void setUserExInfoChanged(UsersOuterClass$UpdateUserExInfoChanged usersOuterClass$UpdateUserExInfoChanged) {
        usersOuterClass$UpdateUserExInfoChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserExInfoChanged;
        this.traitCase_ = 225;
    }

    private void setUserExtChanged(UsersOuterClass$UpdateUserExtChanged usersOuterClass$UpdateUserExtChanged) {
        usersOuterClass$UpdateUserExtChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserExtChanged;
        this.traitCase_ = 218;
    }

    private void setUserFullExtChanged(UsersOuterClass$UpdateUserFullExtChanged usersOuterClass$UpdateUserFullExtChanged) {
        usersOuterClass$UpdateUserFullExtChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserFullExtChanged;
        this.traitCase_ = 219;
    }

    private void setUserLastSeen(PresenceOuterClass$UpdateUserLastSeen presenceOuterClass$UpdateUserLastSeen) {
        presenceOuterClass$UpdateUserLastSeen.getClass();
        this.trait_ = presenceOuterClass$UpdateUserLastSeen;
        this.traitCase_ = 9;
    }

    private void setUserLastSeenUnknown(PresenceOuterClass$UpdateUserLastSeenUnknown presenceOuterClass$UpdateUserLastSeenUnknown) {
        presenceOuterClass$UpdateUserLastSeenUnknown.getClass();
        this.trait_ = presenceOuterClass$UpdateUserLastSeenUnknown;
        this.traitCase_ = 34;
    }

    private void setUserLocalNameChanged(UsersOuterClass$UpdateUserLocalNameChanged usersOuterClass$UpdateUserLocalNameChanged) {
        usersOuterClass$UpdateUserLocalNameChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserLocalNameChanged;
        this.traitCase_ = 51;
    }

    private void setUserNameChanged(UsersOuterClass$UpdateUserNameChanged usersOuterClass$UpdateUserNameChanged) {
        usersOuterClass$UpdateUserNameChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserNameChanged;
        this.traitCase_ = 32;
    }

    private void setUserNickChanged(UsersOuterClass$UpdateUserNickChanged usersOuterClass$UpdateUserNickChanged) {
        usersOuterClass$UpdateUserNickChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserNickChanged;
        this.traitCase_ = 209;
    }

    private void setUserOffline(PresenceOuterClass$UpdateUserOffline presenceOuterClass$UpdateUserOffline) {
        presenceOuterClass$UpdateUserOffline.getClass();
        this.trait_ = presenceOuterClass$UpdateUserOffline;
        this.traitCase_ = 8;
    }

    private void setUserOnline(PresenceOuterClass$UpdateUserOnline presenceOuterClass$UpdateUserOnline) {
        presenceOuterClass$UpdateUserOnline.getClass();
        this.trait_ = presenceOuterClass$UpdateUserOnline;
        this.traitCase_ = 7;
    }

    private void setUserPreferredLanguagesChanged(UsersOuterClass$UpdateUserPreferredLanguagesChanged usersOuterClass$UpdateUserPreferredLanguagesChanged) {
        usersOuterClass$UpdateUserPreferredLanguagesChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserPreferredLanguagesChanged;
        this.traitCase_ = 212;
    }

    private void setUserTimeZoneChanged(UsersOuterClass$UpdateUserTimeZoneChanged usersOuterClass$UpdateUserTimeZoneChanged) {
        usersOuterClass$UpdateUserTimeZoneChanged.getClass();
        this.trait_ = usersOuterClass$UpdateUserTimeZoneChanged;
        this.traitCase_ = 216;
    }

    private void setUserUnblocked(UsersOuterClass$UpdateUserUnblocked usersOuterClass$UpdateUserUnblocked) {
        usersOuterClass$UpdateUserUnblocked.getClass();
        this.trait_ = usersOuterClass$UpdateUserUnblocked;
        this.traitCase_ = USER_UNBLOCKED_FIELD_NUMBER;
    }

    private void setVitrineChanged(VitrineOuterClass$UpdateVitrineChanged vitrineOuterClass$UpdateVitrineChanged) {
        vitrineOuterClass$UpdateVitrineChanged.getClass();
        this.trait_ = vitrineOuterClass$UpdateVitrineChanged;
        this.traitCase_ = VITRINE_CHANGED_FIELD_NUMBER;
    }

    private void setWalletBalanceUpdated(WalletOuterClass$UpdateWalletBalanceUpdated walletOuterClass$UpdateWalletBalanceUpdated) {
        walletOuterClass$UpdateWalletBalanceUpdated.getClass();
        this.trait_ = walletOuterClass$UpdateWalletBalanceUpdated;
        this.traitCase_ = WALLET_BALANCE_UPDATED_FIELD_NUMBER;
    }

    private void setWalletUpdated(WalletOuterClass$UpdateWalletUpdated walletOuterClass$UpdateWalletUpdated) {
        walletOuterClass$UpdateWalletUpdated.getClass();
        this.trait_ = walletOuterClass$UpdateWalletUpdated;
        this.traitCase_ = WALLET_UPDATED_FIELD_NUMBER;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (X1.a[gVar.ordinal()]) {
            case 1:
                return new SetUpdatesStruct$ComposedUpdates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0088\u0001\u0000\u0001\uf521\u0007\u0088\u0000\u0000\u0000\u0001<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\u0010<\u0000\u0013<\u0000\u0015<\u0000\u0017<\u0000\u0018<\u0000 <\u0000!<\u0000\"<\u0000$<\u0000&<\u0000'<\u0000(<\u0000)<\u0000,<\u0000.<\u0000/<\u00000<\u00002<\u00003<\u00006<\u00007<\u00009<\u0000P<\u0000Q<\u0000U<\u0000V<\u0000]<\u0000^<\u0000_<\u0000\u0083<\u0000\u0086<\u0000¡<\u0000¢<\u0000£<\u0000¤<\u0000©<\u0000Ñ<\u0000Ò<\u0000Ô<\u0000Õ<\u0000Ö<\u0000Ø<\u0000Ù<\u0000Ú<\u0000Û<\u0000Þ<\u0000á<\u0000â<\u0000ã<\u0000ä<\u0000þ<\u0000ˑ<\u0000˒<\u0000˓<\u0000\u0a31<\u0000ਲ<\u0000\u0a34<\u0000ਵ<\u0000ਸ਼<\u0000\u0a37<\u0000ਸ<\u0000ਹ<\u0000\u0a3a<\u0000\u0a3b<\u0000਼<\u0000ਾ<\u0000ਿ<\u0000ੀ<\u0000ੁ<\u0000ੂ<\u0000\u0a43<\u0000\u0a44<\u0000\u0a45<\u0000\u0a46<\u0000\u0b31<\u0000ୀ<\u0000༹<\u0000꩗<\u0000칁<\u0000칂<\u0000칃<\u0000칄<\u0000칅<\u0000칆<\u0000칇<\u0000칈<\u0000칉<\u0000칊<\u0000칋<\u0000칌<\u0000칍<\u0000칎<\u0000칏<\u0000칐<\u0000칑<\u0000칒<\u0000칓<\u0000칔<\u0000치<\u0000칙<\u0000칚<\u0000칛<\u0000친<\u0000칝<\u0000칞<\u0000칠<\u0000퐳<\u0000퐴<\u0000퐸<\u0000퐹<\u0000퐼<\u0000퐽<\u0000퐾<\u0000퐿<\u0000푀<\u0000푁<\u0000푂<\u0000푃<\u0000푄<\u0000푅<\u0000푆<\u0000푇<\u0000푈<\u0000푉<\u0000푊<\u0000푋<\u0000\uf3be\u0007<\u0000\uf50c\u0007<\u0000\uf521\u0007<\u0000", new Object[]{"trait_", "traitCase_", MessagingOuterClass$UpdateChatGroupsChanged.class, MessagingOuterClass$UpdateMessageSent.class, UsersOuterClass$UpdateContactRegistered.class, PresenceOuterClass$UpdateTyping.class, PresenceOuterClass$UpdateUserOnline.class, PresenceOuterClass$UpdateUserOffline.class, PresenceOuterClass$UpdateUserLastSeen.class, UsersOuterClass$UpdateUserAvatarChanged.class, MessagingOuterClass$UpdateMessageRead.class, GroupsOuterClass$UpdateGroupUserInvitedObsolete.class, GroupsOuterClass$UpdateGroupUserLeaveObsolete.class, GroupsOuterClass$UpdateGroupUserKickObsolete.class, UsersOuterClass$UpdateUserNameChanged.class, PresenceOuterClass$UpdateGroupOnline.class, PresenceOuterClass$UpdateUserLastSeenUnknown.class, GroupsOuterClass$UpdateGroupInviteObsolete.class, GroupsOuterClass$UpdateGroupTitleChangedObsolete.class, GroupsOuterClass$UpdateGroupAvatarChangedObsolete.class, UsersOuterClass$UpdateContactsAdded.class, UsersOuterClass$UpdateContactsRemoved.class, GroupsOuterClass$UpdateGroupMembersUpdateObsolete.class, MessagingOuterClass$UpdateMessageDelete.class, MessagingOuterClass$UpdateChatClear.class, MessagingOuterClass$UpdateChatDelete.class, MessagingOuterClass$UpdateMessageReadByMe.class, UsersOuterClass$UpdateUserLocalNameChanged.class, MessagingOuterClass$UpdateMessageReceived.class, MessagingOuterClass$UpdateMessage.class, GroupsOuterClass$UpdateGroupNicknameChanged.class, Sequence$UpdateRawUpdate.class, PresenceOuterClass$UpdateTypingStop.class, Sequence$UpdateEmptyUpdate.class, Sequence$UpdateForceClearCache.class, MessagingOuterClass$UpdateChatShow.class, MessagingOuterClass$UpdateChatArchive.class, MessagingOuterClass$UpdateChatFavourite.class, ConfigsOuterClass$UpdateParameterChanged.class, UsersOuterClass$UpdateUserContactsChanged.class, ImagesOuterClass$UpdateOwnStickersChanged.class, MessagingOuterClass$UpdateMessageContentChanged.class, MessagingOuterClass$UpdateMessageDateChanged.class, ImagesOuterClass$UpdateStickerCollectionsChanged.class, MessagingOuterClass$UpdateMessageQuotedChanged.class, UsersOuterClass$UpdateUserNickChanged.class, UsersOuterClass$UpdateUserAboutChanged.class, UsersOuterClass$UpdateUserPreferredLanguagesChanged.class, GroupsOuterClass$UpdateGroupTopicChangedObsolete.class, GroupsOuterClass$UpdateGroupAboutChangedObsolete.class, UsersOuterClass$UpdateUserTimeZoneChanged.class, UsersOuterClass$UpdateUserBotCommandsChanged.class, UsersOuterClass$UpdateUserExtChanged.class, UsersOuterClass$UpdateUserFullExtChanged.class, AbacusOuterClass$UpdateReactionsUpdate.class, UsersOuterClass$UpdateUserExInfoChanged.class, UsersOuterClass$UpdateUserDefaultBankAccountChanged.class, UsersOuterClass$UpdateUserDefaultCardNumberChanged.class, UsersOuterClass$UpdateUserDefaultCardNumberRemoved.class, MessagingOuterClass$UpdateCardinalityChanged.class, GroupsOuterClass$UpdateGroupMessagePinned.class, GroupsOuterClass$UpdateGroupPinRemoved.class, GroupsOuterClass$UpdateGroupRestrictionChanged.class, GroupsOuterClass$UpdateGroupTitleChanged.class, GroupsOuterClass$UpdateGroupAvatarChanged.class, GroupsOuterClass$UpdateGroupMemberChanged.class, GroupsOuterClass$UpdateGroupExtChanged.class, GroupsOuterClass$UpdateGroupMembersUpdated.class, GroupsOuterClass$UpdateGroupMembersBecameAsync.class, GroupsOuterClass$UpdateGroupTopicChanged.class, GroupsOuterClass$UpdateGroupAboutChanged.class, GroupsOuterClass$UpdateGroupFullExtChanged.class, GroupsOuterClass$UpdateGroupOwnerChanged.class, GroupsOuterClass$UpdateGroupHistoryShared.class, GroupsOuterClass$UpdateGroupMembersCountChanged.class, GroupsOuterClass$UpdateGroupMemberDiff.class, GroupsOuterClass$UpdateGroupCanSendMessagesChanged.class, GroupsOuterClass$UpdateGroupCanViewMembersChanged.class, GroupsOuterClass$UpdateGroupCanInviteMembersChanged.class, GroupsOuterClass$UpdateGroupMemberAdminChanged.class, GroupsOuterClass$UpdateGroupBecameOrphaned.class, UsersOuterClass$UpdateUserBlocked.class, UsersOuterClass$UpdateUserUnblocked.class, GroupsOuterClass$UpdateGroupExInfoChanged.class, GroupsOuterClass$UpdateChannelNickChanged.class, BankOuterClass$UpdateRequestLogin.class, AuthOuterClass$UpdateAccountDeleted.class, GroupsOuterClass$UpdateChannelAdvertisementTypeChanged.class, GroupsOuterClass$UpdateChannelAdTagIdChanged.class, UsersOuterClass$UpdatePhoneNumberChanged.class, GroupsOuterClass$UpdateGroupMemberPermissionsChanged.class, GroupsOuterClass$UpdateGroupDefaultPermissionsChanged.class, VitrineOuterClass$UpdateVitrineChanged.class, MeetOuterClass$UpdateCallStarted.class, MeetOuterClass$UpdateCallAccepted.class, MeetOuterClass$UpdateCallDiscarded.class, MeetOuterClass$UpdateCallReceived.class, MeetOuterClass$UpdateGroupCallStarted.class, MeetOuterClass$UpdateGroupCallEnded.class, MeetOuterClass$UpdateCallReactionSent.class, ImagesOuterClass$UpdateStickerPacksChanged.class, MessagingOuterClass$UpdateMessages.class, MeetOuterClass$UpdateCallUpgraded.class, MeetOuterClass$UpdatePeersInvited.class, MeetOuterClass$UpdateMultiPeerCallStarted.class, MeetOuterClass$UpdatePeersStateChanged.class, ImagesOuterClass$UpdateSavedGifsChanged.class, ReportOuterClass$UpdateHidePrivacyBar.class, AbacusOuterClass$UpdateMessageReactions.class, MeetOuterClass$UpdateCallLinkGenerated.class, MeetOuterClass$UpdateCallJoinRequestReceived.class, MeetOuterClass$UpdateCallJoinRequestAnswered.class, MessagingOuterClass$UpdateMentionReadByMe.class, MessagingOuterClass$UpdatePinnedDialogsChanged.class, AbacusOuterClass$UpdateMessageReactionsReadByMe.class, AbacusOuterClass$UpdateMessageNewReaction.class, MeetOuterClass$UpdateCallEvent.class, LahzeOuterClass$UpdateStartLive.class, LahzeOuterClass$UpdateEndLive.class, MessagingOuterClass$UpdateFolderCreated.class, MessagingOuterClass$UpdateFolderDeleted.class, MessagingOuterClass$UpdateFoldersReordered.class, MessagingOuterClass$UpdateDialogsMarkedAsRead.class, MessagingOuterClass$UpdateDialogsMarkedAsUnread.class, MessagingOuterClass$UpdateFolderEdited.class, MeetOuterClass$UpdateCallAction.class, MessagingOuterClass$UpdateDialogsUnpinned.class, MessagingOuterClass$UpdateMessagePinned.class, MessagingOuterClass$UpdateMessagesUnPinned.class, Turing$UpdateTranscriptReady.class, Turing$UpdateGeneralNotificationMessage.class, TimcheOuterClass$UpdateAskBotReview.class, MessagingOuterClass$UpdateDialogArchiveStatus.class, PremiumOuterClass$UpdatePremiumPurchaseStatus.class, ConfigsOuterClass$UpdateEndpointChanged.class, BankOuterClass$UpdateRequestBankiAccessFor.class, WalletOuterClass$UpdateWalletUpdated.class, WalletOuterClass$UpdateWalletBalanceUpdated.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SetUpdatesStruct$ComposedUpdates.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public AuthOuterClass$UpdateAccountDeleted getAccountDeleted() {
        return this.traitCase_ == 43607 ? (AuthOuterClass$UpdateAccountDeleted) this.trait_ : AuthOuterClass$UpdateAccountDeleted.getDefaultInstance();
    }

    public TimcheOuterClass$UpdateAskBotReview getAskBotReview() {
        return this.traitCase_ == 54344 ? (TimcheOuterClass$UpdateAskBotReview) this.trait_ : TimcheOuterClass$UpdateAskBotReview.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallAccepted getCallAccepted() {
        return this.traitCase_ == 52808 ? (MeetOuterClass$UpdateCallAccepted) this.trait_ : MeetOuterClass$UpdateCallAccepted.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallAction getCallAction() {
        return this.traitCase_ == 54338 ? (MeetOuterClass$UpdateCallAction) this.trait_ : MeetOuterClass$UpdateCallAction.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallDiscarded getCallDiscarded() {
        return this.traitCase_ == 52809 ? (MeetOuterClass$UpdateCallDiscarded) this.trait_ : MeetOuterClass$UpdateCallDiscarded.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallEvent getCallEvent() {
        return this.traitCase_ == 54324 ? (MeetOuterClass$UpdateCallEvent) this.trait_ : MeetOuterClass$UpdateCallEvent.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallJoinRequestAnswered getCallJoinRequestAnswered() {
        return this.traitCase_ == 52828 ? (MeetOuterClass$UpdateCallJoinRequestAnswered) this.trait_ : MeetOuterClass$UpdateCallJoinRequestAnswered.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallJoinRequestReceived getCallJoinRequestReceived() {
        return this.traitCase_ == 52827 ? (MeetOuterClass$UpdateCallJoinRequestReceived) this.trait_ : MeetOuterClass$UpdateCallJoinRequestReceived.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallLinkGenerated getCallLinkGenerated() {
        return this.traitCase_ == 52826 ? (MeetOuterClass$UpdateCallLinkGenerated) this.trait_ : MeetOuterClass$UpdateCallLinkGenerated.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallReactionSent getCallReactionSent() {
        return this.traitCase_ == 52813 ? (MeetOuterClass$UpdateCallReactionSent) this.trait_ : MeetOuterClass$UpdateCallReactionSent.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallReceived getCallReceived() {
        return this.traitCase_ == 52810 ? (MeetOuterClass$UpdateCallReceived) this.trait_ : MeetOuterClass$UpdateCallReceived.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallStarted getCallStarted() {
        return this.traitCase_ == 52807 ? (MeetOuterClass$UpdateCallStarted) this.trait_ : MeetOuterClass$UpdateCallStarted.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallUpgraded getCallUpgraded() {
        return this.traitCase_ == 52816 ? (MeetOuterClass$UpdateCallUpgraded) this.trait_ : MeetOuterClass$UpdateCallUpgraded.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateCardinalityChanged getCardinalityChanged() {
        return this.traitCase_ == 254 ? (MessagingOuterClass$UpdateCardinalityChanged) this.trait_ : MessagingOuterClass$UpdateCardinalityChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateChannelAdTagIdChanged getChannelAdTagIdChanged() {
        return this.traitCase_ == 52802 ? (GroupsOuterClass$UpdateChannelAdTagIdChanged) this.trait_ : GroupsOuterClass$UpdateChannelAdTagIdChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateChannelAdvertisementTypeChanged getChannelAdvertisementTypeChanged() {
        return this.traitCase_ == 52801 ? (GroupsOuterClass$UpdateChannelAdvertisementTypeChanged) this.trait_ : GroupsOuterClass$UpdateChannelAdvertisementTypeChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateChannelNickChanged getChannelNickChanged() {
        return this.traitCase_ == 2880 ? (GroupsOuterClass$UpdateChannelNickChanged) this.trait_ : GroupsOuterClass$UpdateChannelNickChanged.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateChatArchive getChatArchive() {
        return this.traitCase_ == 94 ? (MessagingOuterClass$UpdateChatArchive) this.trait_ : MessagingOuterClass$UpdateChatArchive.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateChatClear getChatClear() {
        return this.traitCase_ == 47 ? (MessagingOuterClass$UpdateChatClear) this.trait_ : MessagingOuterClass$UpdateChatClear.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateChatDelete getChatDelete() {
        return this.traitCase_ == 48 ? (MessagingOuterClass$UpdateChatDelete) this.trait_ : MessagingOuterClass$UpdateChatDelete.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateChatFavourite getChatFavourite() {
        return this.traitCase_ == 95 ? (MessagingOuterClass$UpdateChatFavourite) this.trait_ : MessagingOuterClass$UpdateChatFavourite.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateChatGroupsChanged getChatGroupsChanged() {
        return this.traitCase_ == 1 ? (MessagingOuterClass$UpdateChatGroupsChanged) this.trait_ : MessagingOuterClass$UpdateChatGroupsChanged.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateChatShow getChatShow() {
        return this.traitCase_ == 93 ? (MessagingOuterClass$UpdateChatShow) this.trait_ : MessagingOuterClass$UpdateChatShow.getDefaultInstance();
    }

    public UsersOuterClass$UpdateContactRegistered getContactRegistered() {
        return this.traitCase_ == 5 ? (UsersOuterClass$UpdateContactRegistered) this.trait_ : UsersOuterClass$UpdateContactRegistered.getDefaultInstance();
    }

    public UsersOuterClass$UpdateContactsAdded getContactsAdded() {
        return this.traitCase_ == 40 ? (UsersOuterClass$UpdateContactsAdded) this.trait_ : UsersOuterClass$UpdateContactsAdded.getDefaultInstance();
    }

    public UsersOuterClass$UpdateContactsRemoved getContactsRemoved() {
        return this.traitCase_ == 41 ? (UsersOuterClass$UpdateContactsRemoved) this.trait_ : UsersOuterClass$UpdateContactsRemoved.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateDialogArchiveStatus getDialogArchiveStatus() {
        return this.traitCase_ == 54345 ? (MessagingOuterClass$UpdateDialogArchiveStatus) this.trait_ : MessagingOuterClass$UpdateDialogArchiveStatus.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateDialogsMarkedAsRead getDialogsMarkedAsRead() {
        return this.traitCase_ == 54335 ? (MessagingOuterClass$UpdateDialogsMarkedAsRead) this.trait_ : MessagingOuterClass$UpdateDialogsMarkedAsRead.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateDialogsMarkedAsUnread getDialogsMarkedAsUnread() {
        return this.traitCase_ == 54336 ? (MessagingOuterClass$UpdateDialogsMarkedAsUnread) this.trait_ : MessagingOuterClass$UpdateDialogsMarkedAsUnread.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateDialogsUnpinned getDialogsUnpinned() {
        return this.traitCase_ == 54339 ? (MessagingOuterClass$UpdateDialogsUnpinned) this.trait_ : MessagingOuterClass$UpdateDialogsUnpinned.getDefaultInstance();
    }

    public Sequence$UpdateEmptyUpdate getEmptyUpdate() {
        return this.traitCase_ == 85 ? (Sequence$UpdateEmptyUpdate) this.trait_ : Sequence$UpdateEmptyUpdate.getDefaultInstance();
    }

    public LahzeOuterClass$UpdateEndLive getEndLive() {
        return this.traitCase_ == 54329 ? (LahzeOuterClass$UpdateEndLive) this.trait_ : LahzeOuterClass$UpdateEndLive.getDefaultInstance();
    }

    public ConfigsOuterClass$UpdateEndpointChanged getEndpointChanged() {
        return this.traitCase_ == 54347 ? (ConfigsOuterClass$UpdateEndpointChanged) this.trait_ : ConfigsOuterClass$UpdateEndpointChanged.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateFolderCreated getFolderCreated() {
        return this.traitCase_ == 54332 ? (MessagingOuterClass$UpdateFolderCreated) this.trait_ : MessagingOuterClass$UpdateFolderCreated.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateFolderDeleted getFolderDeleted() {
        return this.traitCase_ == 54333 ? (MessagingOuterClass$UpdateFolderDeleted) this.trait_ : MessagingOuterClass$UpdateFolderDeleted.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateFolderEdited getFolderEdited() {
        return this.traitCase_ == 54337 ? (MessagingOuterClass$UpdateFolderEdited) this.trait_ : MessagingOuterClass$UpdateFolderEdited.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateFoldersReordered getFoldersReordered() {
        return this.traitCase_ == 54334 ? (MessagingOuterClass$UpdateFoldersReordered) this.trait_ : MessagingOuterClass$UpdateFoldersReordered.getDefaultInstance();
    }

    public Sequence$UpdateForceClearCache getForceClearCache() {
        return this.traitCase_ == 86 ? (Sequence$UpdateForceClearCache) this.trait_ : Sequence$UpdateForceClearCache.getDefaultInstance();
    }

    public Turing$UpdateGeneralNotificationMessage getGeneralNotificationMessage() {
        return this.traitCase_ == 54343 ? (Turing$UpdateGeneralNotificationMessage) this.trait_ : Turing$UpdateGeneralNotificationMessage.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupAboutChanged getGroupAboutChanged() {
        return this.traitCase_ == 2617 ? (GroupsOuterClass$UpdateGroupAboutChanged) this.trait_ : GroupsOuterClass$UpdateGroupAboutChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupAboutChangedObsolete getGroupAboutChangedObsolete() {
        return this.traitCase_ == 214 ? (GroupsOuterClass$UpdateGroupAboutChangedObsolete) this.trait_ : GroupsOuterClass$UpdateGroupAboutChangedObsolete.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupAvatarChanged getGroupAvatarChanged() {
        return this.traitCase_ == 2610 ? (GroupsOuterClass$UpdateGroupAvatarChanged) this.trait_ : GroupsOuterClass$UpdateGroupAvatarChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupAvatarChangedObsolete getGroupAvatarChangedObsolete() {
        return this.traitCase_ == 39 ? (GroupsOuterClass$UpdateGroupAvatarChangedObsolete) this.trait_ : GroupsOuterClass$UpdateGroupAvatarChangedObsolete.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupBecameOrphaned getGroupBecameOrphaned() {
        return this.traitCase_ == 2628 ? (GroupsOuterClass$UpdateGroupBecameOrphaned) this.trait_ : GroupsOuterClass$UpdateGroupBecameOrphaned.getDefaultInstance();
    }

    public MeetOuterClass$UpdateGroupCallEnded getGroupCallEnded() {
        return this.traitCase_ == 52812 ? (MeetOuterClass$UpdateGroupCallEnded) this.trait_ : MeetOuterClass$UpdateGroupCallEnded.getDefaultInstance();
    }

    public MeetOuterClass$UpdateGroupCallStarted getGroupCallStarted() {
        return this.traitCase_ == 52811 ? (MeetOuterClass$UpdateGroupCallStarted) this.trait_ : MeetOuterClass$UpdateGroupCallStarted.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupCanInviteMembersChanged getGroupCanInviteMembersChanged() {
        return this.traitCase_ == 2626 ? (GroupsOuterClass$UpdateGroupCanInviteMembersChanged) this.trait_ : GroupsOuterClass$UpdateGroupCanInviteMembersChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupCanSendMessagesChanged getGroupCanSendMessagesChanged() {
        return this.traitCase_ == 2624 ? (GroupsOuterClass$UpdateGroupCanSendMessagesChanged) this.trait_ : GroupsOuterClass$UpdateGroupCanSendMessagesChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupCanViewMembersChanged getGroupCanViewMembersChanged() {
        return this.traitCase_ == 2625 ? (GroupsOuterClass$UpdateGroupCanViewMembersChanged) this.trait_ : GroupsOuterClass$UpdateGroupCanViewMembersChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupDefaultPermissionsChanged getGroupDefaultPermissionsChanged() {
        return this.traitCase_ == 52805 ? (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) this.trait_ : GroupsOuterClass$UpdateGroupDefaultPermissionsChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupExInfoChanged getGroupExInfoChanged() {
        return this.traitCase_ == 2865 ? (GroupsOuterClass$UpdateGroupExInfoChanged) this.trait_ : GroupsOuterClass$UpdateGroupExInfoChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupExtChanged getGroupExtChanged() {
        return this.traitCase_ == 2613 ? (GroupsOuterClass$UpdateGroupExtChanged) this.trait_ : GroupsOuterClass$UpdateGroupExtChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupFullExtChanged getGroupFullExtChanged() {
        return this.traitCase_ == 2618 ? (GroupsOuterClass$UpdateGroupFullExtChanged) this.trait_ : GroupsOuterClass$UpdateGroupFullExtChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupHistoryShared getGroupHistoryShared() {
        return this.traitCase_ == 2620 ? (GroupsOuterClass$UpdateGroupHistoryShared) this.trait_ : GroupsOuterClass$UpdateGroupHistoryShared.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupInviteObsolete getGroupInviteObsolete() {
        return this.traitCase_ == 36 ? (GroupsOuterClass$UpdateGroupInviteObsolete) this.trait_ : GroupsOuterClass$UpdateGroupInviteObsolete.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMemberAdminChanged getGroupMemberAdminChanged() {
        return this.traitCase_ == 2627 ? (GroupsOuterClass$UpdateGroupMemberAdminChanged) this.trait_ : GroupsOuterClass$UpdateGroupMemberAdminChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMemberChanged getGroupMemberChanged() {
        return this.traitCase_ == 2612 ? (GroupsOuterClass$UpdateGroupMemberChanged) this.trait_ : GroupsOuterClass$UpdateGroupMemberChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMemberDiff getGroupMemberDiff() {
        return this.traitCase_ == 2623 ? (GroupsOuterClass$UpdateGroupMemberDiff) this.trait_ : GroupsOuterClass$UpdateGroupMemberDiff.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMemberPermissionsChanged getGroupMemberPermissionsChanged() {
        return this.traitCase_ == 52804 ? (GroupsOuterClass$UpdateGroupMemberPermissionsChanged) this.trait_ : GroupsOuterClass$UpdateGroupMemberPermissionsChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMembersBecameAsync getGroupMembersBecameAsync() {
        return this.traitCase_ == 2615 ? (GroupsOuterClass$UpdateGroupMembersBecameAsync) this.trait_ : GroupsOuterClass$UpdateGroupMembersBecameAsync.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMembersCountChanged getGroupMembersCountChanged() {
        return this.traitCase_ == 2622 ? (GroupsOuterClass$UpdateGroupMembersCountChanged) this.trait_ : GroupsOuterClass$UpdateGroupMembersCountChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMembersUpdateObsolete getGroupMembersUpdateObsolete() {
        return this.traitCase_ == 44 ? (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) this.trait_ : GroupsOuterClass$UpdateGroupMembersUpdateObsolete.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMembersUpdated getGroupMembersUpdated() {
        return this.traitCase_ == 2614 ? (GroupsOuterClass$UpdateGroupMembersUpdated) this.trait_ : GroupsOuterClass$UpdateGroupMembersUpdated.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupMessagePinned getGroupMessagePinned() {
        return this.traitCase_ == 721 ? (GroupsOuterClass$UpdateGroupMessagePinned) this.trait_ : GroupsOuterClass$UpdateGroupMessagePinned.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupNicknameChanged getGroupNicknameChanged() {
        return this.traitCase_ == 57 ? (GroupsOuterClass$UpdateGroupNicknameChanged) this.trait_ : GroupsOuterClass$UpdateGroupNicknameChanged.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateGroupOnline getGroupOnline() {
        return this.traitCase_ == 33 ? (PresenceOuterClass$UpdateGroupOnline) this.trait_ : PresenceOuterClass$UpdateGroupOnline.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupOwnerChanged getGroupOwnerChanged() {
        return this.traitCase_ == 2619 ? (GroupsOuterClass$UpdateGroupOwnerChanged) this.trait_ : GroupsOuterClass$UpdateGroupOwnerChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupPinRemoved getGroupPinRemoved() {
        return this.traitCase_ == 722 ? (GroupsOuterClass$UpdateGroupPinRemoved) this.trait_ : GroupsOuterClass$UpdateGroupPinRemoved.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupRestrictionChanged getGroupRestrictionChanged() {
        return this.traitCase_ == 723 ? (GroupsOuterClass$UpdateGroupRestrictionChanged) this.trait_ : GroupsOuterClass$UpdateGroupRestrictionChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupTitleChanged getGroupTitleChanged() {
        return this.traitCase_ == 2609 ? (GroupsOuterClass$UpdateGroupTitleChanged) this.trait_ : GroupsOuterClass$UpdateGroupTitleChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupTitleChangedObsolete getGroupTitleChangedObsolete() {
        return this.traitCase_ == 38 ? (GroupsOuterClass$UpdateGroupTitleChangedObsolete) this.trait_ : GroupsOuterClass$UpdateGroupTitleChangedObsolete.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupTopicChanged getGroupTopicChanged() {
        return this.traitCase_ == 2616 ? (GroupsOuterClass$UpdateGroupTopicChanged) this.trait_ : GroupsOuterClass$UpdateGroupTopicChanged.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupTopicChangedObsolete getGroupTopicChangedObsolete() {
        return this.traitCase_ == 213 ? (GroupsOuterClass$UpdateGroupTopicChangedObsolete) this.trait_ : GroupsOuterClass$UpdateGroupTopicChangedObsolete.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupUserInvitedObsolete getGroupUserInvitedObsolete() {
        return this.traitCase_ == 21 ? (GroupsOuterClass$UpdateGroupUserInvitedObsolete) this.trait_ : GroupsOuterClass$UpdateGroupUserInvitedObsolete.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupUserKickObsolete getGroupUserKickObsolete() {
        return this.traitCase_ == 24 ? (GroupsOuterClass$UpdateGroupUserKickObsolete) this.trait_ : GroupsOuterClass$UpdateGroupUserKickObsolete.getDefaultInstance();
    }

    public GroupsOuterClass$UpdateGroupUserLeaveObsolete getGroupUserLeaveObsolete() {
        return this.traitCase_ == 23 ? (GroupsOuterClass$UpdateGroupUserLeaveObsolete) this.trait_ : GroupsOuterClass$UpdateGroupUserLeaveObsolete.getDefaultInstance();
    }

    public ReportOuterClass$UpdateHidePrivacyBar getHidePrivacyBar() {
        return this.traitCase_ == 52824 ? (ReportOuterClass$UpdateHidePrivacyBar) this.trait_ : ReportOuterClass$UpdateHidePrivacyBar.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMentionReadByMe getMentionReadByMe() {
        return this.traitCase_ == 52829 ? (MessagingOuterClass$UpdateMentionReadByMe) this.trait_ : MessagingOuterClass$UpdateMentionReadByMe.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessage getMessage() {
        return this.traitCase_ == 55 ? (MessagingOuterClass$UpdateMessage) this.trait_ : MessagingOuterClass$UpdateMessage.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageContentChanged getMessageContentChanged() {
        return this.traitCase_ == 162 ? (MessagingOuterClass$UpdateMessageContentChanged) this.trait_ : MessagingOuterClass$UpdateMessageContentChanged.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageDateChanged getMessageDateChanged() {
        return this.traitCase_ == 163 ? (MessagingOuterClass$UpdateMessageDateChanged) this.trait_ : MessagingOuterClass$UpdateMessageDateChanged.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageDelete getMessageDelete() {
        return this.traitCase_ == 46 ? (MessagingOuterClass$UpdateMessageDelete) this.trait_ : MessagingOuterClass$UpdateMessageDelete.getDefaultInstance();
    }

    public AbacusOuterClass$UpdateMessageNewReaction getMessageNewReaction() {
        return this.traitCase_ == 54323 ? (AbacusOuterClass$UpdateMessageNewReaction) this.trait_ : AbacusOuterClass$UpdateMessageNewReaction.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessagePinned getMessagePinned() {
        return this.traitCase_ == 54340 ? (MessagingOuterClass$UpdateMessagePinned) this.trait_ : MessagingOuterClass$UpdateMessagePinned.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageQuotedChanged getMessageQuotedChanged() {
        return this.traitCase_ == 169 ? (MessagingOuterClass$UpdateMessageQuotedChanged) this.trait_ : MessagingOuterClass$UpdateMessageQuotedChanged.getDefaultInstance();
    }

    public AbacusOuterClass$UpdateMessageReactions getMessageReactions() {
        return this.traitCase_ == 52825 ? (AbacusOuterClass$UpdateMessageReactions) this.trait_ : AbacusOuterClass$UpdateMessageReactions.getDefaultInstance();
    }

    public AbacusOuterClass$UpdateMessageReactionsReadByMe getMessageReactionsReadByMe() {
        return this.traitCase_ == 52832 ? (AbacusOuterClass$UpdateMessageReactionsReadByMe) this.trait_ : AbacusOuterClass$UpdateMessageReactionsReadByMe.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageRead getMessageRead() {
        return this.traitCase_ == 19 ? (MessagingOuterClass$UpdateMessageRead) this.trait_ : MessagingOuterClass$UpdateMessageRead.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageReadByMe getMessageReadByMe() {
        return this.traitCase_ == 50 ? (MessagingOuterClass$UpdateMessageReadByMe) this.trait_ : MessagingOuterClass$UpdateMessageReadByMe.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageReceived getMessageReceived() {
        return this.traitCase_ == 54 ? (MessagingOuterClass$UpdateMessageReceived) this.trait_ : MessagingOuterClass$UpdateMessageReceived.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageSent getMessageSent() {
        return this.traitCase_ == 4 ? (MessagingOuterClass$UpdateMessageSent) this.trait_ : MessagingOuterClass$UpdateMessageSent.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessages getMessages() {
        return this.traitCase_ == 52815 ? (MessagingOuterClass$UpdateMessages) this.trait_ : MessagingOuterClass$UpdateMessages.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessagesUnPinned getMessagesUnPinned() {
        return this.traitCase_ == 54341 ? (MessagingOuterClass$UpdateMessagesUnPinned) this.trait_ : MessagingOuterClass$UpdateMessagesUnPinned.getDefaultInstance();
    }

    public MeetOuterClass$UpdateMultiPeerCallStarted getMultiPeerCallStarted() {
        return this.traitCase_ == 52818 ? (MeetOuterClass$UpdateMultiPeerCallStarted) this.trait_ : MeetOuterClass$UpdateMultiPeerCallStarted.getDefaultInstance();
    }

    public ImagesOuterClass$UpdateOwnStickersChanged getOwnStickersChanged() {
        return this.traitCase_ == 161 ? (ImagesOuterClass$UpdateOwnStickersChanged) this.trait_ : ImagesOuterClass$UpdateOwnStickersChanged.getDefaultInstance();
    }

    public ConfigsOuterClass$UpdateParameterChanged getParameterChanged() {
        return this.traitCase_ == 131 ? (ConfigsOuterClass$UpdateParameterChanged) this.trait_ : ConfigsOuterClass$UpdateParameterChanged.getDefaultInstance();
    }

    public MeetOuterClass$UpdatePeersInvited getPeersInvited() {
        return this.traitCase_ == 52817 ? (MeetOuterClass$UpdatePeersInvited) this.trait_ : MeetOuterClass$UpdatePeersInvited.getDefaultInstance();
    }

    public MeetOuterClass$UpdatePeersStateChanged getPeersStateChanged() {
        return this.traitCase_ == 52819 ? (MeetOuterClass$UpdatePeersStateChanged) this.trait_ : MeetOuterClass$UpdatePeersStateChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdatePhoneNumberChanged getPhoneNumberChanged() {
        return this.traitCase_ == 52803 ? (UsersOuterClass$UpdatePhoneNumberChanged) this.trait_ : UsersOuterClass$UpdatePhoneNumberChanged.getDefaultInstance();
    }

    public MessagingOuterClass$UpdatePinnedDialogsChanged getPinnedDialogsChanged() {
        return this.traitCase_ == 52830 ? (MessagingOuterClass$UpdatePinnedDialogsChanged) this.trait_ : MessagingOuterClass$UpdatePinnedDialogsChanged.getDefaultInstance();
    }

    public PremiumOuterClass$UpdatePremiumPurchaseStatus getPremiumPurchaseStatus() {
        return this.traitCase_ == 54346 ? (PremiumOuterClass$UpdatePremiumPurchaseStatus) this.trait_ : PremiumOuterClass$UpdatePremiumPurchaseStatus.getDefaultInstance();
    }

    public Sequence$UpdateRawUpdate getRawUpdate() {
        return this.traitCase_ == 80 ? (Sequence$UpdateRawUpdate) this.trait_ : Sequence$UpdateRawUpdate.getDefaultInstance();
    }

    public AbacusOuterClass$UpdateReactionsUpdate getReactionsUpdate() {
        return this.traitCase_ == 222 ? (AbacusOuterClass$UpdateReactionsUpdate) this.trait_ : AbacusOuterClass$UpdateReactionsUpdate.getDefaultInstance();
    }

    public BankOuterClass$UpdateRequestBankiAccessFor getRequestBankiAccessFor() {
        return this.traitCase_ == 62398 ? (BankOuterClass$UpdateRequestBankiAccessFor) this.trait_ : BankOuterClass$UpdateRequestBankiAccessFor.getDefaultInstance();
    }

    public BankOuterClass$UpdateRequestLogin getRequestLogin() {
        return this.traitCase_ == 3897 ? (BankOuterClass$UpdateRequestLogin) this.trait_ : BankOuterClass$UpdateRequestLogin.getDefaultInstance();
    }

    public ImagesOuterClass$UpdateSavedGifsChanged getSavedGifsChanged() {
        return this.traitCase_ == 52820 ? (ImagesOuterClass$UpdateSavedGifsChanged) this.trait_ : ImagesOuterClass$UpdateSavedGifsChanged.getDefaultInstance();
    }

    public LahzeOuterClass$UpdateStartLive getStartLive() {
        return this.traitCase_ == 54328 ? (LahzeOuterClass$UpdateStartLive) this.trait_ : LahzeOuterClass$UpdateStartLive.getDefaultInstance();
    }

    public ImagesOuterClass$UpdateStickerCollectionsChanged getStickerCollectionsChanged() {
        return this.traitCase_ == 164 ? (ImagesOuterClass$UpdateStickerCollectionsChanged) this.trait_ : ImagesOuterClass$UpdateStickerCollectionsChanged.getDefaultInstance();
    }

    public ImagesOuterClass$UpdateStickerPacksChanged getStickerPacksChanged() {
        return this.traitCase_ == 52814 ? (ImagesOuterClass$UpdateStickerPacksChanged) this.trait_ : ImagesOuterClass$UpdateStickerPacksChanged.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public Turing$UpdateTranscriptReady getTranscriptReady() {
        return this.traitCase_ == 54342 ? (Turing$UpdateTranscriptReady) this.trait_ : Turing$UpdateTranscriptReady.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateTyping getTyping() {
        return this.traitCase_ == 6 ? (PresenceOuterClass$UpdateTyping) this.trait_ : PresenceOuterClass$UpdateTyping.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateTypingStop getTypingStop() {
        return this.traitCase_ == 81 ? (PresenceOuterClass$UpdateTypingStop) this.trait_ : PresenceOuterClass$UpdateTypingStop.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserAboutChanged getUserAboutChanged() {
        return this.traitCase_ == 210 ? (UsersOuterClass$UpdateUserAboutChanged) this.trait_ : UsersOuterClass$UpdateUserAboutChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserAvatarChanged getUserAvatarChanged() {
        return this.traitCase_ == 16 ? (UsersOuterClass$UpdateUserAvatarChanged) this.trait_ : UsersOuterClass$UpdateUserAvatarChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserBlocked getUserBlocked() {
        return this.traitCase_ == 2629 ? (UsersOuterClass$UpdateUserBlocked) this.trait_ : UsersOuterClass$UpdateUserBlocked.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserBotCommandsChanged getUserBotCommandsChanged() {
        return this.traitCase_ == 217 ? (UsersOuterClass$UpdateUserBotCommandsChanged) this.trait_ : UsersOuterClass$UpdateUserBotCommandsChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserContactsChanged getUserContactsChanged() {
        return this.traitCase_ == 134 ? (UsersOuterClass$UpdateUserContactsChanged) this.trait_ : UsersOuterClass$UpdateUserContactsChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserDefaultBankAccountChanged getUserDefaultBankAccountChanged() {
        return this.traitCase_ == 226 ? (UsersOuterClass$UpdateUserDefaultBankAccountChanged) this.trait_ : UsersOuterClass$UpdateUserDefaultBankAccountChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserDefaultCardNumberChanged getUserDefaultCardNumberChanged() {
        return this.traitCase_ == 227 ? (UsersOuterClass$UpdateUserDefaultCardNumberChanged) this.trait_ : UsersOuterClass$UpdateUserDefaultCardNumberChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserDefaultCardNumberRemoved getUserDefaultCardNumberRemoved() {
        return this.traitCase_ == 228 ? (UsersOuterClass$UpdateUserDefaultCardNumberRemoved) this.trait_ : UsersOuterClass$UpdateUserDefaultCardNumberRemoved.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserExInfoChanged getUserExInfoChanged() {
        return this.traitCase_ == 225 ? (UsersOuterClass$UpdateUserExInfoChanged) this.trait_ : UsersOuterClass$UpdateUserExInfoChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserExtChanged getUserExtChanged() {
        return this.traitCase_ == 218 ? (UsersOuterClass$UpdateUserExtChanged) this.trait_ : UsersOuterClass$UpdateUserExtChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserFullExtChanged getUserFullExtChanged() {
        return this.traitCase_ == 219 ? (UsersOuterClass$UpdateUserFullExtChanged) this.trait_ : UsersOuterClass$UpdateUserFullExtChanged.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateUserLastSeen getUserLastSeen() {
        return this.traitCase_ == 9 ? (PresenceOuterClass$UpdateUserLastSeen) this.trait_ : PresenceOuterClass$UpdateUserLastSeen.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateUserLastSeenUnknown getUserLastSeenUnknown() {
        return this.traitCase_ == 34 ? (PresenceOuterClass$UpdateUserLastSeenUnknown) this.trait_ : PresenceOuterClass$UpdateUserLastSeenUnknown.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserLocalNameChanged getUserLocalNameChanged() {
        return this.traitCase_ == 51 ? (UsersOuterClass$UpdateUserLocalNameChanged) this.trait_ : UsersOuterClass$UpdateUserLocalNameChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserNameChanged getUserNameChanged() {
        return this.traitCase_ == 32 ? (UsersOuterClass$UpdateUserNameChanged) this.trait_ : UsersOuterClass$UpdateUserNameChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserNickChanged getUserNickChanged() {
        return this.traitCase_ == 209 ? (UsersOuterClass$UpdateUserNickChanged) this.trait_ : UsersOuterClass$UpdateUserNickChanged.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateUserOffline getUserOffline() {
        return this.traitCase_ == 8 ? (PresenceOuterClass$UpdateUserOffline) this.trait_ : PresenceOuterClass$UpdateUserOffline.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateUserOnline getUserOnline() {
        return this.traitCase_ == 7 ? (PresenceOuterClass$UpdateUserOnline) this.trait_ : PresenceOuterClass$UpdateUserOnline.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserPreferredLanguagesChanged getUserPreferredLanguagesChanged() {
        return this.traitCase_ == 212 ? (UsersOuterClass$UpdateUserPreferredLanguagesChanged) this.trait_ : UsersOuterClass$UpdateUserPreferredLanguagesChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserTimeZoneChanged getUserTimeZoneChanged() {
        return this.traitCase_ == 216 ? (UsersOuterClass$UpdateUserTimeZoneChanged) this.trait_ : UsersOuterClass$UpdateUserTimeZoneChanged.getDefaultInstance();
    }

    public UsersOuterClass$UpdateUserUnblocked getUserUnblocked() {
        return this.traitCase_ == 2630 ? (UsersOuterClass$UpdateUserUnblocked) this.trait_ : UsersOuterClass$UpdateUserUnblocked.getDefaultInstance();
    }

    public VitrineOuterClass$UpdateVitrineChanged getVitrineChanged() {
        return this.traitCase_ == 52806 ? (VitrineOuterClass$UpdateVitrineChanged) this.trait_ : VitrineOuterClass$UpdateVitrineChanged.getDefaultInstance();
    }

    public WalletOuterClass$UpdateWalletBalanceUpdated getWalletBalanceUpdated() {
        return this.traitCase_ == 62753 ? (WalletOuterClass$UpdateWalletBalanceUpdated) this.trait_ : WalletOuterClass$UpdateWalletBalanceUpdated.getDefaultInstance();
    }

    public WalletOuterClass$UpdateWalletUpdated getWalletUpdated() {
        return this.traitCase_ == 62732 ? (WalletOuterClass$UpdateWalletUpdated) this.trait_ : WalletOuterClass$UpdateWalletUpdated.getDefaultInstance();
    }

    public boolean hasAccountDeleted() {
        return this.traitCase_ == 43607;
    }

    public boolean hasAskBotReview() {
        return this.traitCase_ == 54344;
    }

    public boolean hasCallAccepted() {
        return this.traitCase_ == 52808;
    }

    public boolean hasCallAction() {
        return this.traitCase_ == 54338;
    }

    public boolean hasCallDiscarded() {
        return this.traitCase_ == 52809;
    }

    public boolean hasCallEvent() {
        return this.traitCase_ == 54324;
    }

    public boolean hasCallJoinRequestAnswered() {
        return this.traitCase_ == 52828;
    }

    public boolean hasCallJoinRequestReceived() {
        return this.traitCase_ == 52827;
    }

    public boolean hasCallLinkGenerated() {
        return this.traitCase_ == 52826;
    }

    public boolean hasCallReactionSent() {
        return this.traitCase_ == 52813;
    }

    public boolean hasCallReceived() {
        return this.traitCase_ == 52810;
    }

    public boolean hasCallStarted() {
        return this.traitCase_ == 52807;
    }

    public boolean hasCallUpgraded() {
        return this.traitCase_ == 52816;
    }

    public boolean hasCardinalityChanged() {
        return this.traitCase_ == 254;
    }

    public boolean hasChannelAdTagIdChanged() {
        return this.traitCase_ == 52802;
    }

    public boolean hasChannelAdvertisementTypeChanged() {
        return this.traitCase_ == 52801;
    }

    public boolean hasChannelNickChanged() {
        return this.traitCase_ == 2880;
    }

    public boolean hasChatArchive() {
        return this.traitCase_ == 94;
    }

    public boolean hasChatClear() {
        return this.traitCase_ == 47;
    }

    public boolean hasChatDelete() {
        return this.traitCase_ == 48;
    }

    public boolean hasChatFavourite() {
        return this.traitCase_ == 95;
    }

    public boolean hasChatGroupsChanged() {
        return this.traitCase_ == 1;
    }

    public boolean hasChatShow() {
        return this.traitCase_ == 93;
    }

    public boolean hasContactRegistered() {
        return this.traitCase_ == 5;
    }

    public boolean hasContactsAdded() {
        return this.traitCase_ == 40;
    }

    public boolean hasContactsRemoved() {
        return this.traitCase_ == 41;
    }

    public boolean hasDialogArchiveStatus() {
        return this.traitCase_ == 54345;
    }

    public boolean hasDialogsMarkedAsRead() {
        return this.traitCase_ == 54335;
    }

    public boolean hasDialogsMarkedAsUnread() {
        return this.traitCase_ == 54336;
    }

    public boolean hasDialogsUnpinned() {
        return this.traitCase_ == 54339;
    }

    public boolean hasEmptyUpdate() {
        return this.traitCase_ == 85;
    }

    public boolean hasEndLive() {
        return this.traitCase_ == 54329;
    }

    public boolean hasEndpointChanged() {
        return this.traitCase_ == 54347;
    }

    public boolean hasFolderCreated() {
        return this.traitCase_ == 54332;
    }

    public boolean hasFolderDeleted() {
        return this.traitCase_ == 54333;
    }

    public boolean hasFolderEdited() {
        return this.traitCase_ == 54337;
    }

    public boolean hasFoldersReordered() {
        return this.traitCase_ == 54334;
    }

    public boolean hasForceClearCache() {
        return this.traitCase_ == 86;
    }

    public boolean hasGeneralNotificationMessage() {
        return this.traitCase_ == 54343;
    }

    public boolean hasGroupAboutChanged() {
        return this.traitCase_ == 2617;
    }

    public boolean hasGroupAboutChangedObsolete() {
        return this.traitCase_ == 214;
    }

    public boolean hasGroupAvatarChanged() {
        return this.traitCase_ == 2610;
    }

    public boolean hasGroupAvatarChangedObsolete() {
        return this.traitCase_ == 39;
    }

    public boolean hasGroupBecameOrphaned() {
        return this.traitCase_ == 2628;
    }

    public boolean hasGroupCallEnded() {
        return this.traitCase_ == 52812;
    }

    public boolean hasGroupCallStarted() {
        return this.traitCase_ == 52811;
    }

    public boolean hasGroupCanInviteMembersChanged() {
        return this.traitCase_ == 2626;
    }

    public boolean hasGroupCanSendMessagesChanged() {
        return this.traitCase_ == 2624;
    }

    public boolean hasGroupCanViewMembersChanged() {
        return this.traitCase_ == 2625;
    }

    public boolean hasGroupDefaultPermissionsChanged() {
        return this.traitCase_ == 52805;
    }

    public boolean hasGroupExInfoChanged() {
        return this.traitCase_ == 2865;
    }

    public boolean hasGroupExtChanged() {
        return this.traitCase_ == 2613;
    }

    public boolean hasGroupFullExtChanged() {
        return this.traitCase_ == 2618;
    }

    public boolean hasGroupHistoryShared() {
        return this.traitCase_ == 2620;
    }

    public boolean hasGroupInviteObsolete() {
        return this.traitCase_ == 36;
    }

    public boolean hasGroupMemberAdminChanged() {
        return this.traitCase_ == 2627;
    }

    public boolean hasGroupMemberChanged() {
        return this.traitCase_ == 2612;
    }

    public boolean hasGroupMemberDiff() {
        return this.traitCase_ == 2623;
    }

    public boolean hasGroupMemberPermissionsChanged() {
        return this.traitCase_ == 52804;
    }

    public boolean hasGroupMembersBecameAsync() {
        return this.traitCase_ == 2615;
    }

    public boolean hasGroupMembersCountChanged() {
        return this.traitCase_ == 2622;
    }

    public boolean hasGroupMembersUpdateObsolete() {
        return this.traitCase_ == 44;
    }

    public boolean hasGroupMembersUpdated() {
        return this.traitCase_ == 2614;
    }

    public boolean hasGroupMessagePinned() {
        return this.traitCase_ == 721;
    }

    public boolean hasGroupNicknameChanged() {
        return this.traitCase_ == 57;
    }

    public boolean hasGroupOnline() {
        return this.traitCase_ == 33;
    }

    public boolean hasGroupOwnerChanged() {
        return this.traitCase_ == 2619;
    }

    public boolean hasGroupPinRemoved() {
        return this.traitCase_ == 722;
    }

    public boolean hasGroupRestrictionChanged() {
        return this.traitCase_ == 723;
    }

    public boolean hasGroupTitleChanged() {
        return this.traitCase_ == 2609;
    }

    public boolean hasGroupTitleChangedObsolete() {
        return this.traitCase_ == 38;
    }

    public boolean hasGroupTopicChanged() {
        return this.traitCase_ == 2616;
    }

    public boolean hasGroupTopicChangedObsolete() {
        return this.traitCase_ == 213;
    }

    public boolean hasGroupUserInvitedObsolete() {
        return this.traitCase_ == 21;
    }

    public boolean hasGroupUserKickObsolete() {
        return this.traitCase_ == 24;
    }

    public boolean hasGroupUserLeaveObsolete() {
        return this.traitCase_ == 23;
    }

    public boolean hasHidePrivacyBar() {
        return this.traitCase_ == 52824;
    }

    public boolean hasMentionReadByMe() {
        return this.traitCase_ == 52829;
    }

    public boolean hasMessage() {
        return this.traitCase_ == 55;
    }

    public boolean hasMessageContentChanged() {
        return this.traitCase_ == 162;
    }

    public boolean hasMessageDateChanged() {
        return this.traitCase_ == 163;
    }

    public boolean hasMessageDelete() {
        return this.traitCase_ == 46;
    }

    public boolean hasMessageNewReaction() {
        return this.traitCase_ == 54323;
    }

    public boolean hasMessagePinned() {
        return this.traitCase_ == 54340;
    }

    public boolean hasMessageQuotedChanged() {
        return this.traitCase_ == 169;
    }

    public boolean hasMessageReactions() {
        return this.traitCase_ == 52825;
    }

    public boolean hasMessageReactionsReadByMe() {
        return this.traitCase_ == 52832;
    }

    public boolean hasMessageRead() {
        return this.traitCase_ == 19;
    }

    public boolean hasMessageReadByMe() {
        return this.traitCase_ == 50;
    }

    public boolean hasMessageReceived() {
        return this.traitCase_ == 54;
    }

    public boolean hasMessageSent() {
        return this.traitCase_ == 4;
    }

    public boolean hasMessages() {
        return this.traitCase_ == 52815;
    }

    public boolean hasMessagesUnPinned() {
        return this.traitCase_ == 54341;
    }

    public boolean hasMultiPeerCallStarted() {
        return this.traitCase_ == 52818;
    }

    public boolean hasOwnStickersChanged() {
        return this.traitCase_ == 161;
    }

    public boolean hasParameterChanged() {
        return this.traitCase_ == 131;
    }

    public boolean hasPeersInvited() {
        return this.traitCase_ == 52817;
    }

    public boolean hasPeersStateChanged() {
        return this.traitCase_ == 52819;
    }

    public boolean hasPhoneNumberChanged() {
        return this.traitCase_ == 52803;
    }

    public boolean hasPinnedDialogsChanged() {
        return this.traitCase_ == 52830;
    }

    public boolean hasPremiumPurchaseStatus() {
        return this.traitCase_ == 54346;
    }

    public boolean hasRawUpdate() {
        return this.traitCase_ == 80;
    }

    public boolean hasReactionsUpdate() {
        return this.traitCase_ == 222;
    }

    public boolean hasRequestBankiAccessFor() {
        return this.traitCase_ == 62398;
    }

    public boolean hasRequestLogin() {
        return this.traitCase_ == 3897;
    }

    public boolean hasSavedGifsChanged() {
        return this.traitCase_ == 52820;
    }

    public boolean hasStartLive() {
        return this.traitCase_ == 54328;
    }

    public boolean hasStickerCollectionsChanged() {
        return this.traitCase_ == 164;
    }

    public boolean hasStickerPacksChanged() {
        return this.traitCase_ == 52814;
    }

    public boolean hasTranscriptReady() {
        return this.traitCase_ == 54342;
    }

    public boolean hasTyping() {
        return this.traitCase_ == 6;
    }

    public boolean hasTypingStop() {
        return this.traitCase_ == 81;
    }

    public boolean hasUserAboutChanged() {
        return this.traitCase_ == 210;
    }

    public boolean hasUserAvatarChanged() {
        return this.traitCase_ == 16;
    }

    public boolean hasUserBlocked() {
        return this.traitCase_ == 2629;
    }

    public boolean hasUserBotCommandsChanged() {
        return this.traitCase_ == 217;
    }

    public boolean hasUserContactsChanged() {
        return this.traitCase_ == 134;
    }

    public boolean hasUserDefaultBankAccountChanged() {
        return this.traitCase_ == 226;
    }

    public boolean hasUserDefaultCardNumberChanged() {
        return this.traitCase_ == 227;
    }

    public boolean hasUserDefaultCardNumberRemoved() {
        return this.traitCase_ == 228;
    }

    public boolean hasUserExInfoChanged() {
        return this.traitCase_ == 225;
    }

    public boolean hasUserExtChanged() {
        return this.traitCase_ == 218;
    }

    public boolean hasUserFullExtChanged() {
        return this.traitCase_ == 219;
    }

    public boolean hasUserLastSeen() {
        return this.traitCase_ == 9;
    }

    public boolean hasUserLastSeenUnknown() {
        return this.traitCase_ == 34;
    }

    public boolean hasUserLocalNameChanged() {
        return this.traitCase_ == 51;
    }

    public boolean hasUserNameChanged() {
        return this.traitCase_ == 32;
    }

    public boolean hasUserNickChanged() {
        return this.traitCase_ == 209;
    }

    public boolean hasUserOffline() {
        return this.traitCase_ == 8;
    }

    public boolean hasUserOnline() {
        return this.traitCase_ == 7;
    }

    public boolean hasUserPreferredLanguagesChanged() {
        return this.traitCase_ == 212;
    }

    public boolean hasUserTimeZoneChanged() {
        return this.traitCase_ == 216;
    }

    public boolean hasUserUnblocked() {
        return this.traitCase_ == 2630;
    }

    public boolean hasVitrineChanged() {
        return this.traitCase_ == 52806;
    }

    public boolean hasWalletBalanceUpdated() {
        return this.traitCase_ == 62753;
    }

    public boolean hasWalletUpdated() {
        return this.traitCase_ == 62732;
    }

    public static a newBuilder(SetUpdatesStruct$ComposedUpdates setUpdatesStruct$ComposedUpdates) {
        return (a) DEFAULT_INSTANCE.createBuilder(setUpdatesStruct$ComposedUpdates);
    }

    public static SetUpdatesStruct$ComposedUpdates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(AbstractC2383g abstractC2383g) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(byte[] bArr) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(byte[] bArr, C2394s c2394s) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(InputStream inputStream) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(AbstractC2384h abstractC2384h) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SetUpdatesStruct$ComposedUpdates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SetUpdatesStruct$ComposedUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
