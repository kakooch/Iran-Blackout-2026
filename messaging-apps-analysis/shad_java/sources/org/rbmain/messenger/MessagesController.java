package org.rbmain.messenger;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidMessenger.ServiceLocator;
import androidMessenger.model.CustomParameters;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.proxy.IdStorage;
import androidx.collection.LongSparseArray;
import androidx.core.util.Consumer;
import com.facebook.stetho.websocket.CloseCodes;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.utilites.Objects;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.model.ChildLockCheck;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.rbmain.SQLite.SQLiteCursor;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.support.LongSparseIntArray;
import org.rbmain.messenger.support.SparseLongArray;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$ChannelParticipant;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$DialogPeer;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DraftMessage;
import org.rbmain.tgnet.TLRPC$EmojiStatus;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputChannel;
import org.rbmain.tgnet.TLRPC$InputChatPhoto;
import org.rbmain.tgnet.TLRPC$InputDialogPeer;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$InputPhoto;
import org.rbmain.tgnet.TLRPC$InputUser;
import org.rbmain.tgnet.TLRPC$InputWallPaper;
import org.rbmain.tgnet.TLRPC$JSONValue;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$PeerNotifySettings;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$Poll;
import org.rbmain.tgnet.TLRPC$RecentMeUrl;
import org.rbmain.tgnet.TLRPC$ReportReason;
import org.rbmain.tgnet.TLRPC$SendMessageAction;
import org.rbmain.tgnet.TLRPC$TL_account_getNotifySettings;
import org.rbmain.tgnet.TLRPC$TL_account_installTheme;
import org.rbmain.tgnet.TLRPC$TL_account_installWallPaper;
import org.rbmain.tgnet.TLRPC$TL_account_registerDevice;
import org.rbmain.tgnet.TLRPC$TL_account_reportPeer;
import org.rbmain.tgnet.TLRPC$TL_account_saveTheme;
import org.rbmain.tgnet.TLRPC$TL_account_saveWallPaper;
import org.rbmain.tgnet.TLRPC$TL_account_unregisterDevice;
import org.rbmain.tgnet.TLRPC$TL_account_uploadWallPaper;
import org.rbmain.tgnet.TLRPC$TL_boolFalse;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_botInfo;
import org.rbmain.tgnet.TLRPC$TL_channel;
import org.rbmain.tgnet.TLRPC$TL_channelForbidden;
import org.rbmain.tgnet.TLRPC$TL_channelFull;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantSelf;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsAdmins;
import org.rbmain.tgnet.TLRPC$TL_channels_channelParticipant;
import org.rbmain.tgnet.TLRPC$TL_channels_channelParticipants;
import org.rbmain.tgnet.TLRPC$TL_channels_convertToGigagroup;
import org.rbmain.tgnet.TLRPC$TL_channels_createChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_deleteChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_deleteMessages;
import org.rbmain.tgnet.TLRPC$TL_channels_deleteUserHistory;
import org.rbmain.tgnet.TLRPC$TL_channels_editAdmin;
import org.rbmain.tgnet.TLRPC$TL_channels_editBanned;
import org.rbmain.tgnet.TLRPC$TL_channels_editPhoto;
import org.rbmain.tgnet.TLRPC$TL_channels_editTitle;
import org.rbmain.tgnet.TLRPC$TL_channels_getChannels;
import org.rbmain.tgnet.TLRPC$TL_channels_getMessages;
import org.rbmain.tgnet.TLRPC$TL_channels_getParticipant;
import org.rbmain.tgnet.TLRPC$TL_channels_getParticipants;
import org.rbmain.tgnet.TLRPC$TL_channels_inviteToChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_joinChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_leaveChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_readMessageContents;
import org.rbmain.tgnet.TLRPC$TL_channels_sendAsPeers;
import org.rbmain.tgnet.TLRPC$TL_channels_togglePreHistoryHidden;
import org.rbmain.tgnet.TLRPC$TL_channels_toggleSignatures;
import org.rbmain.tgnet.TLRPC$TL_channels_toggleSlowMode;
import org.rbmain.tgnet.TLRPC$TL_channels_updateUsername;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsAll;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsNone;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsSome;
import org.rbmain.tgnet.TLRPC$TL_config;
import org.rbmain.tgnet.TLRPC$TL_contacts_block;
import org.rbmain.tgnet.TLRPC$TL_contacts_getBlocked;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolveUsername;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolvedPeer;
import org.rbmain.tgnet.TLRPC$TL_contacts_unblock;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_dialogFilterSuggested;
import org.rbmain.tgnet.TLRPC$TL_dialogFolder;
import org.rbmain.tgnet.TLRPC$TL_dialogPeer;
import org.rbmain.tgnet.TLRPC$TL_documentEmpty;
import org.rbmain.tgnet.TLRPC$TL_draftMessage;
import org.rbmain.tgnet.TLRPC$TL_encryptedChat;
import org.rbmain.tgnet.TLRPC$TL_encryptedChatRequested;
import org.rbmain.tgnet.TLRPC$TL_encryptedChatWaiting;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_folder;
import org.rbmain.tgnet.TLRPC$TL_folderPeer;
import org.rbmain.tgnet.TLRPC$TL_groupCallDiscarded;
import org.rbmain.tgnet.TLRPC$TL_help_dismissSuggestion;
import org.rbmain.tgnet.TLRPC$TL_help_getAppChangelog;
import org.rbmain.tgnet.TLRPC$TL_help_getRecentMeUrls;
import org.rbmain.tgnet.TLRPC$TL_help_hidePromoData;
import org.rbmain.tgnet.TLRPC$TL_help_recentMeUrls;
import org.rbmain.tgnet.TLRPC$TL_inputChannel;
import org.rbmain.tgnet.TLRPC$TL_inputChannelEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputChatPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputChatUploadedPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputDialogPeer;
import org.rbmain.tgnet.TLRPC$TL_inputDocument;
import org.rbmain.tgnet.TLRPC$TL_inputEncryptedChat;
import org.rbmain.tgnet.TLRPC$TL_inputGeoPoint;
import org.rbmain.tgnet.TLRPC$TL_inputGroupCall;
import org.rbmain.tgnet.TLRPC$TL_inputNotifyBroadcasts;
import org.rbmain.tgnet.TLRPC$TL_inputNotifyChats;
import org.rbmain.tgnet.TLRPC$TL_inputNotifyUsers;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputPeerSelf;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_inputTheme;
import org.rbmain.tgnet.TLRPC$TL_inputUser;
import org.rbmain.tgnet.TLRPC$TL_inputUserEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputUserSelf;
import org.rbmain.tgnet.TLRPC$TL_inputWallPaper;
import org.rbmain.tgnet.TLRPC$TL_inputWallPaperSlug;
import org.rbmain.tgnet.TLRPC$TL_jsonArray;
import org.rbmain.tgnet.TLRPC$TL_jsonBool;
import org.rbmain.tgnet.TLRPC$TL_jsonNumber;
import org.rbmain.tgnet.TLRPC$TL_jsonObject;
import org.rbmain.tgnet.TLRPC$TL_jsonObjectValue;
import org.rbmain.tgnet.TLRPC$TL_jsonString;
import org.rbmain.tgnet.TLRPC$TL_messageActionChannelCreate;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatDeleteUser;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatEditPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatMigrateTo;
import org.rbmain.tgnet.TLRPC$TL_messageEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPoll;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWebPage;
import org.rbmain.tgnet.TLRPC$TL_messageService;
import org.rbmain.tgnet.TLRPC$TL_messages_addChatUser;
import org.rbmain.tgnet.TLRPC$TL_messages_affectedHistory;
import org.rbmain.tgnet.TLRPC$TL_messages_affectedMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_chatFull;
import org.rbmain.tgnet.TLRPC$TL_messages_chats;
import org.rbmain.tgnet.TLRPC$TL_messages_createChat;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteChat;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteChatUser;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteScheduledMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_dialogs;
import org.rbmain.tgnet.TLRPC$TL_messages_editChatAbout;
import org.rbmain.tgnet.TLRPC$TL_messages_editChatAdmin;
import org.rbmain.tgnet.TLRPC$TL_messages_editChatDefaultBannedRights;
import org.rbmain.tgnet.TLRPC$TL_messages_editChatPhoto;
import org.rbmain.tgnet.TLRPC$TL_messages_editChatTitle;
import org.rbmain.tgnet.TLRPC$TL_messages_getChats;
import org.rbmain.tgnet.TLRPC$TL_messages_getDialogs;
import org.rbmain.tgnet.TLRPC$TL_messages_getMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_getPeerDialogs;
import org.rbmain.tgnet.TLRPC$TL_messages_getPeerSettings;
import org.rbmain.tgnet.TLRPC$TL_messages_getPinnedDialogs;
import org.rbmain.tgnet.TLRPC$TL_messages_getUnreadMentions;
import org.rbmain.tgnet.TLRPC$TL_messages_getWebPagePreview;
import org.rbmain.tgnet.TLRPC$TL_messages_hidePeerSettingsBar;
import org.rbmain.tgnet.TLRPC$TL_messages_markDialogUnread;
import org.rbmain.tgnet.TLRPC$TL_messages_messages;
import org.rbmain.tgnet.TLRPC$TL_messages_migrateChat;
import org.rbmain.tgnet.TLRPC$TL_messages_peerDialogs;
import org.rbmain.tgnet.TLRPC$TL_messages_readMentions;
import org.rbmain.tgnet.TLRPC$TL_messages_readMessageContents;
import org.rbmain.tgnet.TLRPC$TL_messages_readReactions;
import org.rbmain.tgnet.TLRPC$TL_messages_reorderPinnedDialogs;
import org.rbmain.tgnet.TLRPC$TL_messages_reportEncryptedSpam;
import org.rbmain.tgnet.TLRPC$TL_messages_reportSpam;
import org.rbmain.tgnet.TLRPC$TL_messages_saveGif;
import org.rbmain.tgnet.TLRPC$TL_messages_saveRecentSticker;
import org.rbmain.tgnet.TLRPC$TL_messages_setChatAvailableReactions;
import org.rbmain.tgnet.TLRPC$TL_messages_setEncryptedTyping;
import org.rbmain.tgnet.TLRPC$TL_messages_setHistoryTTL;
import org.rbmain.tgnet.TLRPC$TL_messages_setTyping;
import org.rbmain.tgnet.TLRPC$TL_messages_startBot;
import org.rbmain.tgnet.TLRPC$TL_messages_unpinAllMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_updatePinnedMessage;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerNotifySettings;
import org.rbmain.tgnet.TLRPC$TL_peerSettings;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_phone_getGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_groupCall;
import org.rbmain.tgnet.TLRPC$TL_photo;
import org.rbmain.tgnet.TLRPC$TL_photoEmpty;
import org.rbmain.tgnet.TLRPC$TL_photos_photo;
import org.rbmain.tgnet.TLRPC$TL_photos_updateProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.tgnet.TLRPC$TL_replyKeyboardHide;
import org.rbmain.tgnet.TLRPC$TL_restrictionReason;
import org.rbmain.tgnet.TLRPC$TL_sendMessageCancelAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageGamePlayAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageRecordAudioAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageRecordRoundAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageRecordVideoAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageTypingAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadAudioAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadDocumentAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadPhotoAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadRoundAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadVideoAction;
import org.rbmain.tgnet.TLRPC$TL_theme;
import org.rbmain.tgnet.TLRPC$TL_updateAddedUsers;
import org.rbmain.tgnet.TLRPC$TL_updateChannel;
import org.rbmain.tgnet.TLRPC$TL_updateChannelAvailableMessages;
import org.rbmain.tgnet.TLRPC$TL_updateChannelMessageForwards;
import org.rbmain.tgnet.TLRPC$TL_updateChannelMessageViews;
import org.rbmain.tgnet.TLRPC$TL_updateChannelReadMessagesContents;
import org.rbmain.tgnet.TLRPC$TL_updateChannelTooLong;
import org.rbmain.tgnet.TLRPC$TL_updateChannelUserTyping;
import org.rbmain.tgnet.TLRPC$TL_updateChannelWebPage;
import org.rbmain.tgnet.TLRPC$TL_updateDeleteChannelMessages;
import org.rbmain.tgnet.TLRPC$TL_updateDeleteMessages;
import org.rbmain.tgnet.TLRPC$TL_updateEditChannelMessage;
import org.rbmain.tgnet.TLRPC$TL_updateEditMessage;
import org.rbmain.tgnet.TLRPC$TL_updateFolderPeers;
import org.rbmain.tgnet.TLRPC$TL_updateLangPack;
import org.rbmain.tgnet.TLRPC$TL_updateMessageID;
import org.rbmain.tgnet.TLRPC$TL_updateNewChannelMessage;
import org.rbmain.tgnet.TLRPC$TL_updateNewEncryptedMessage;
import org.rbmain.tgnet.TLRPC$TL_updateNewMessage;
import org.rbmain.tgnet.TLRPC$TL_updatePeerBlocked;
import org.rbmain.tgnet.TLRPC$TL_updatePinnedChannelMessages;
import org.rbmain.tgnet.TLRPC$TL_updatePinnedMessages;
import org.rbmain.tgnet.TLRPC$TL_updateReadChannelDiscussionInbox;
import org.rbmain.tgnet.TLRPC$TL_updateReadChannelDiscussionOutbox;
import org.rbmain.tgnet.TLRPC$TL_updateReadChannelInbox;
import org.rbmain.tgnet.TLRPC$TL_updateReadChannelOutbox;
import org.rbmain.tgnet.TLRPC$TL_updateReadHistoryInbox;
import org.rbmain.tgnet.TLRPC$TL_updateReadHistoryOutbox;
import org.rbmain.tgnet.TLRPC$TL_updateReadMessagesContents;
import org.rbmain.tgnet.TLRPC$TL_updateServiceNotification;
import org.rbmain.tgnet.TLRPC$TL_updateWebPage;
import org.rbmain.tgnet.TLRPC$TL_updatesCombined;
import org.rbmain.tgnet.TLRPC$TL_updates_difference;
import org.rbmain.tgnet.TLRPC$TL_updates_differenceEmpty;
import org.rbmain.tgnet.TLRPC$TL_updates_differenceSlice;
import org.rbmain.tgnet.TLRPC$TL_updates_differenceTooLong;
import org.rbmain.tgnet.TLRPC$TL_updates_getDifference;
import org.rbmain.tgnet.TLRPC$TL_updates_state;
import org.rbmain.tgnet.TLRPC$TL_userForeign_old2;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhotoEmpty;
import org.rbmain.tgnet.TLRPC$TL_userStatusEmpty;
import org.rbmain.tgnet.TLRPC$TL_userStatusOffline;
import org.rbmain.tgnet.TLRPC$TL_userStatusOnline;
import org.rbmain.tgnet.TLRPC$TL_users_getUsers;
import org.rbmain.tgnet.TLRPC$TL_wallPaper;
import org.rbmain.tgnet.TLRPC$TL_wallPaperSettings;
import org.rbmain.tgnet.TLRPC$TL_webPage;
import org.rbmain.tgnet.TLRPC$TL_webPageEmpty;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$UserStatus;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.tgnet.TLRPC$WallPaper;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.tgnet.TLRPC$contacts_Blocked;
import org.rbmain.tgnet.TLRPC$messages_Dialogs;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.tgnet.TLRPC$photos_Photos;
import org.rbmain.tgnet.TLRPC$updates_ChannelDifference;
import org.rbmain.tgnet.TLRPC$updates_Difference;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.ImageUpdater;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.ProfileActivity;

/* loaded from: classes.dex */
public class MessagesController extends BaseController implements NotificationCenter.NotificationCenterDelegate {
    public static int DIALOG_FILTER_FLAG_BOTS = 16;
    public static int DIALOG_FILTER_FLAG_CHANNELS = 8;
    public static int DIALOG_FILTER_FLAG_CONTACTS = 1;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED = 128;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_MUTED = 32;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_READ = 64;
    public static int DIALOG_FILTER_FLAG_GROUPS = 4;
    public static int DIALOG_FILTER_FLAG_NON_CONTACTS = 2;
    public static int DIALOG_FILTER_FLAG_ONLY_ARCHIVED = 256;
    public static final int PROMO_TYPE_OTHER = 2;
    public static final int PROMO_TYPE_PROXY = 0;
    public static final int PROMO_TYPE_PSA = 1;
    public static final int UPDATE_MASK_AVATAR = 2;
    public static final int UPDATE_MASK_CHAT = 8192;
    public static final int UPDATE_MASK_CHAT_AVATAR = 8;
    public static final int UPDATE_MASK_CHAT_MEMBERS = 32;
    public static final int UPDATE_MASK_CHAT_MUTE = 262144;
    public static final int UPDATE_MASK_CHAT_NAME = 16;
    public static final int UPDATE_MASK_CHAT_SHOW_SPAM = 524288;
    public static final int UPDATE_MASK_CHECK = 65536;
    public static int UPDATE_MASK_EMOJI_INTERACTIONS = 262144;
    public static int UPDATE_MASK_EMOJI_STATUS = 524288;
    public static final int UPDATE_MASK_MESSAGE_TEXT = 32768;
    public static final int UPDATE_MASK_NAME = 1;
    public static final int UPDATE_MASK_NEW_MESSAGE = 2048;
    public static final int UPDATE_MASK_PHONE = 1024;
    public static int UPDATE_MASK_REACTIONS_READ = 1048576;
    public static final int UPDATE_MASK_READ_DIALOG_MESSAGE = 256;
    public static final int UPDATE_MASK_REORDER = 131072;
    public static final int UPDATE_MASK_SELECT_DIALOG = 512;
    public static final int UPDATE_MASK_SEND_STATE = 4096;
    public static final int UPDATE_MASK_STATUS = 4;
    public static final int UPDATE_MASK_USER_PHONE = 128;
    public static final int UPDATE_MASK_USER_PRINT = 64;
    private static volatile long lastPasswordCheckTime;
    private static volatile long lastThemeCheckTime;
    private int DIALOGS_LOAD_TYPE_CACHE;
    private int DIALOGS_LOAD_TYPE_CHANNEL;
    private int DIALOGS_LOAD_TYPE_UNKNOWN;
    public ArrayList<TLRPC$Dialog> adsDialogs;
    protected ArrayList<TLRPC$Dialog> allDialogs;
    public float animatedEmojisZoom;
    public Set<String> authDomains;
    public boolean autoarchiveAvailable;
    public Set<String> autologinDomains;
    public String autologinToken;
    public int availableMapProviders;
    public boolean backgroundConnection;
    public SparseIntArray blockePeers;
    public boolean blockedCountry;
    public boolean blockedEndReached;
    public int callConnectTimeout;
    public int callPacketTimeout;
    public int callReceiveTimeout;
    public int callRingTimeout;
    public boolean canRevokePmInbox;
    private SparseArray<SparseArray<TLRPC$ChannelParticipant>> channelAdmins;
    private SparseArray<ArrayList<Long>> channelViewsToSend;
    private SparseIntArray channelsPts;
    public int chatReadMarkSizeThreshold;
    private ConcurrentHashMap<Integer, TLRPC$Chat> chats;
    private SparseBooleanArray checkingLastMessagesDialogs;
    private boolean checkingPromoInfo;
    private int checkingPromoInfoRequestId;
    private boolean checkingTosUpdate;
    private LongSparseArray<TLRPC$Dialog> clearingHistoryDialogs;
    private ArrayList<Long> createdDialogIds;
    private ArrayList<Long> createdDialogMainThreadIds;
    private ArrayList<Long> createdScheduledDialogIds;
    private Runnable currentDeleteTaskRunnable;
    private int currentDeletingTaskChannelId;
    private boolean currentDeletingTaskMedia;
    private ArrayList<Long> currentDeletingTaskMids;
    private int currentDeletingTaskTime;
    public String dcDomainName;
    public LongSparseArray<Long> deletedHistory;
    private LongSparseArray<TLRPC$Dialog> deletingDialogs;
    private final Comparator<TLRPC$Dialog> dialogComparator;
    private final Comparator<TLRPC$Dialog> dialogDateComparator;
    public ArrayList<DialogFilter> dialogFilters;
    public SparseArray<DialogFilter> dialogFiltersById;
    public boolean dialogFiltersLoaded;
    public LongSparseArray<MessageObject> dialogMessage;
    public LongSparseArray<MessageObject> dialogMessagesByIds;
    public LongSparseArray<MessageObject> dialogMessagesByRandomIds;
    public SparseArray<ArrayList<TLRPC$Dialog>> dialogsByFolder;
    public ArrayList<TLRPC$Dialog> dialogsCanAddUsers;
    public ArrayList<TLRPC$Dialog> dialogsChannelsOnly;
    private SparseBooleanArray dialogsEndReached;
    public ArrayList<TLRPC$Dialog> dialogsForBlock;
    public ArrayList<TLRPC$Dialog> dialogsForward;
    public ArrayList<TLRPC$Dialog> dialogsGroupsOnly;
    private boolean dialogsInTransaction;
    public boolean dialogsLoaded;
    private int dialogsLoadedTillDate;
    public ArrayList<TLRPC$Dialog> dialogsServerOnly;
    public ArrayList<TLRPC$Dialog> dialogsUsersOnly;
    public LongSparseArray<TLRPC$Dialog> dialogs_dict;
    public ConcurrentHashMap<Long, Long> dialogs_read_inbox_max;
    public ConcurrentHashMap<Long, Long> dialogs_read_outbox_max;
    public HashSet<String> diceEmojies;
    public HashMap<String, DiceFrameSuccess> diceSuccess;
    private SharedPreferences emojiPreferences;
    public HashMap<String, EmojiSound> emojiSounds;
    public boolean enableJoined;
    private ConcurrentHashMap<Integer, TLRPC$EncryptedChat> encryptedChats;
    public Set<String> exportGroupUri;
    public Set<String> exportPrivateUri;
    public Set<String> exportUri;
    private SparseArray<TLRPC$TL_chatInviteExported> exportedChats;
    public ArrayList<FaqSearchResult> faqSearchArray;
    public TLRPC$WebPage faqWebPage;
    public boolean filtersEnabled;
    public boolean firstGettingTask;
    private SparseArray<TLRPC$ChatFull> fullChats;
    private SparseArray<TLRPC$UserFull> fullUsers;
    private boolean getDifferenceFirstSync;
    private boolean gettingAppChangelog;
    private SparseBooleanArray gettingChatInviters;
    public boolean gettingDifference;
    private SparseBooleanArray gettingDifferenceChannels;
    private boolean gettingNewDeleteTask;
    private SparseBooleanArray gettingUnknownChannels;
    private LongSparseArray<Boolean> gettingUnknownDialogs;
    public String gifSearchBot;
    public ArrayList<String> gifSearchEmojies;
    public int groupCallVideoMaxParticipants;
    private Map<String, ChatObject.Call> groupCalls;
    private SparseArray<ChatObject.Call> groupCallsByChatId;
    public ArrayList<TLRPC$RecentMeUrl> hintDialogs;
    public volatile boolean ignoreSetOnline;
    public String imageSearchBot;
    private String installReferer;
    private boolean isLeftPromoChannel;
    private ArrayList<Integer> joiningToChannels;
    public boolean keepAliveService;
    private int lastCheckPromoId;
    private int lastPrintingStringCount;
    private long lastPushRegisterSendTime;
    private LongSparseArray<Long> lastScheduledServerQueryTime;
    private LongSparseArray<Long> lastServerQueryTime;
    private long lastStatusUpdateTime;
    private long lastViewsCheckTime;
    public String linkPrefix;
    private ArrayList<Integer> loadedFullChats;
    private ArrayList<Integer> loadedFullParticipants;
    private ArrayList<Integer> loadedFullUsers;
    private boolean loadingAppConfig;
    public boolean loadingBlockedPeers;
    private SparseIntArray loadingChannelAdmins;
    private SparseBooleanArray loadingDialogs;
    private ArrayList<Integer> loadingFullChats;
    private ArrayList<Integer> loadingFullParticipants;
    private ArrayList<Integer> loadingFullUsers;
    private ArrayList<Integer> loadingGroupCalls;
    private int loadingNotificationSettings;
    private boolean loadingNotificationSignUpSettings;
    private LongSparseArray<Boolean> loadingPeerSettings;
    private SparseIntArray loadingPinnedDialogs;
    private boolean loadingRemoteFilters;
    private boolean loadingSuggestedFilters;
    private boolean loadingUnreadDialogs;
    private SharedPreferences mainPreferences;
    public String mapKey;
    public int mapProvider;
    public int maxBroadcastCount;
    public int maxCaptionLength;
    public int maxEditTime;
    public int maxFaveStickersCount;
    public int maxFolderPinnedDialogsCount;
    public int maxGroupCount;
    public int maxMegagroupCount;
    public int maxMessageLength;
    public int maxPinnedDialogsCount;
    public int maxRecentGifsCount;
    public int maxRecentStickersCount;
    private SparseIntArray migratedChats;
    private boolean migratingDialogs;
    public int minGroupConvertSize;
    private SparseArray<ArrayList<Integer>> needShortPollChannels;
    private SparseArray<ArrayList<Integer>> needShortPollOnlines;
    public String nextBlockedPeersId;
    private SparseArray<Long> nextDialogsCacheOffset;
    private int nextPromoInfoCheckTime;
    private int nextTosCheckTime;
    private SharedPreferences notificationsPreferences;
    private ConcurrentHashMap<String, TLObject> objectsByUsernames;
    private boolean offlineSent;
    public ConcurrentHashMap<Integer, Integer> onlinePrivacy;
    private Runnable passwordCheckRunnable;
    public Set<String> pendingSuggestions;
    public LongSparseArray<ImageUpdater> photoSuggestion;
    private LongSparseArray<LongSparseArray<MessageObject>> pollsToCheck;
    private int pollsToCheckSize;
    public boolean preloadFeaturedStickers;
    public boolean premiumLocked;
    public LongSparseArray<LongSparseArray<CharSequence>> printingStrings;
    public LongSparseArray<LongSparseArray<Integer>> printingStringsTypes;
    public ConcurrentHashMap<Long, ConcurrentHashMap<Long, ArrayList<PrintingUser>>> printingUsers;
    private TLRPC$Dialog promoDialog;
    private long promoDialogId;
    public int promoDialogType;
    public String promoPsaMessage;
    public String promoPsaType;
    private String proxyDialogAddress;
    public boolean qrLoginCamera;
    public int ratingDecay;
    public int reactionsUserMaxDefault;
    public int reactionsUserMaxPremium;
    private ArrayList<ReadTask> readTasks;
    private LongSparseArray<ReadTask> readTasksMap;
    public boolean registeringForPush;
    private LongSparseArray<ArrayList<Long>> reloadingMessages;
    private HashMap<String, ArrayList<MessageObject>> reloadingScheduledWebpages;
    private LongSparseArray<ArrayList<MessageObject>> reloadingScheduledWebpagesPending;
    private HashMap<String, ArrayList<MessageObject>> reloadingWebpages;
    private LongSparseArray<ArrayList<MessageObject>> reloadingWebpagesPending;
    private ArrayList<ReadTask> repliesReadTasks;
    private boolean requestDeleteAcountInProgress;
    private TLRPC$messages_Dialogs resetDialogsAll;
    private TLRPC$TL_messages_peerDialogs resetDialogsPinned;
    private boolean resetingDialogs;
    public int revokeTimeLimit;
    public int revokeTimePmLimit;
    public boolean saveGifsWithStickers;
    public int secretWebpagePreview;
    public DialogFilter[] selectedDialogFilter;
    public LongSparseArray<LongSparseArray<Boolean>>[] sendingTypings;
    private SparseBooleanArray serverDialogsEndReached;
    private SparseIntArray shortPollChannels;
    private SparseIntArray shortPollOnlines;
    public boolean showFiltersTooltip;
    private DialogFilter sortingDialogFilter;
    private int statusRequest;
    private int statusSettingState;
    public boolean suggestContacts;
    public boolean suggestStickersApiOnly;
    public ArrayList<TLRPC$TL_dialogFilterSuggested> suggestedFilters;
    public String suggestedLangCode;
    private Runnable themeCheckRunnable;
    private LongSparseArray<ReadTask> threadsReadTasksMap;
    public int totalBlockedCount;
    public int unreadUnmutedDialogs;
    public int updateCheckDelay;
    private final Comparator<TLRPC$Update> updatesComparator;
    private SparseArray<ArrayList<TLRPC$Updates>> updatesQueueChannels;
    private ArrayList<TLRPC$Updates> updatesQueuePts;
    private ArrayList<TLRPC$Updates> updatesQueueQts;
    private ArrayList<TLRPC$Updates> updatesQueueSeq;
    private SparseLongArray updatesStartWaitTimeChannels;
    private long updatesStartWaitTimePts;
    private long updatesStartWaitTimeQts;
    private long updatesStartWaitTimeSeq;
    public boolean updatingState;
    private String uploadingAvatar;
    private HashMap<String, Object> uploadingThemes;
    private String uploadingWallpaper;
    private Theme.OverrideWallpaperInfo uploadingWallpaperInfo;
    private UploadingFileWallpaper uploadingWallpaperObject;
    private String uploadingWallpaperThumb;
    private ConcurrentHashMap<Integer, TLRPC$User> users;
    public String venueSearchBot;
    private ArrayList<Long> visibleDialogMainThreadIds;
    private ArrayList<Long> visibleScheduledDialogMainThreadIds;
    public int webFileDatacenterId;
    public String youtubePipType;
    public static int UPDATE_MASK_ALL = 1048576 | 1535;
    public static int DIALOG_FILTER_FLAG_ALL_CHATS = (((1 | 2) | 4) | 8) | 16;
    private static volatile MessagesController[] Instance = new MessagesController[3];

    /* loaded from: classes4.dex */
    public interface MessagesLoadedCallback {
        void onError();

        void onMessagesLoaded(boolean z);
    }

    /* loaded from: classes4.dex */
    public static class PrintingUser {
        public TLRPC$SendMessageAction action;
        public long lastTime;
        public int userId;
    }

    /* loaded from: classes4.dex */
    public static class UploadingFileWallpaper {
        public String location;
        public String locationThumb;
        public TLRPC$InputFile main;
        public TLRPC$InputFile thumb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkPromoInfoInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$checkPromoInfo$102(boolean z) {
    }

    private void checkTosUpdate() {
    }

    private void completeReadTask(ReadTask readTask) {
    }

    public static boolean isSupportId(long j) {
        return j == 777000 || j == 333000 || j == 4240000 || j == 4244000 || j == 4245000 || j == 4246000 || j == 410000 || j == 420000 || j == 431000 || j == 431415000 || j == 434000 || j == 4243000 || j == 439000 || j == 449000 || j == 450000 || j == 452000 || j == 454000 || j == 4254000 || j == 455000 || j == 460000 || j == 470000 || j == 479000 || j == 796000 || j == 482000 || j == 490000 || j == 496000 || j == 497000 || j == 498000 || j == 4298000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$blockPeer$51(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteParticipantFromChat$177(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$hidePeerSettingsBar$38(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$hidePromoDialog$87(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$installTheme$77(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$installTheme$78(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$markMentionMessageAsRead$140(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$markMentionsAsRead$145(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$markMessageContentAsRead$138(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$markReactionsAsRead$277(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$pinMessage$84(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processUpdates$236(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removeSuggestion$15(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportSpam$39(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportSpam$40(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportSpam$41(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveTheme$76(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unpinAllMessages$83(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unregistedPush$183(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    protected void checkLastDialogMessage(TLRPC$Dialog tLRPC$Dialog, TLRPC$InputPeer tLRPC$InputPeer, long j) {
    }

    public void getNextReactionMention(long j, int i, int i2, Consumer<Integer> consumer) {
    }

    public TLRPC$TL_channels_sendAsPeers getSendAsPeers(long j) {
        return null;
    }

    public boolean isForum(long j) {
        return false;
    }

    public boolean isForum(MessageObject messageObject) {
        return false;
    }

    public void loadChannelParticipants(Integer num) {
    }

    public void loadDialogs(int i, int i2, int i3, boolean z, Runnable runnable) {
    }

    protected void loadUnknownChannel(TLRPC$Chat tLRPC$Chat, long j) {
    }

    protected void loadUnknownDialog(TLRPC$InputPeer tLRPC$InputPeer, long j) {
    }

    public void updateConfig(TLRPC$TL_config tLRPC$TL_config) {
    }

    public void updateEmojiStatus(TLRPC$EmojiStatus tLRPC$EmojiStatus) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        getUserConfig().checkSavedPassword();
    }

    /* loaded from: classes4.dex */
    public static class FaqSearchResult {
        public int num;
        public String[] path;
        public String title;
        public String url;

        public FaqSearchResult(String str, String[] strArr, String str2) {
            this.title = str;
            this.path = strArr;
            this.url = str2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof FaqSearchResult) {
                return this.title.equals(((FaqSearchResult) obj).title);
            }
            return false;
        }

        public String toString() {
            SerializedData serializedData = new SerializedData();
            serializedData.writeInt32(this.num);
            int i = 0;
            serializedData.writeInt32(0);
            serializedData.writeString(this.title);
            String[] strArr = this.path;
            serializedData.writeInt32(strArr != null ? strArr.length : 0);
            if (this.path != null) {
                while (true) {
                    String[] strArr2 = this.path;
                    if (i >= strArr2.length) {
                        break;
                    }
                    serializedData.writeString(strArr2[i]);
                    i++;
                }
            }
            serializedData.writeString(this.url);
            return Utilities.bytesToHex(serializedData.toByteArray());
        }
    }

    /* loaded from: classes4.dex */
    public static class EmojiSound {
        public long accessHash;
        public byte[] fileReference;
        public long id;

        public EmojiSound(long j, long j2, String str) {
            this.id = j;
            this.accessHash = j2;
            this.fileReference = Base64.decode(str, 8);
        }

        public EmojiSound(long j, long j2, byte[] bArr) {
            this.id = j;
            this.accessHash = j2;
            this.fileReference = bArr;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof EmojiSound)) {
                return false;
            }
            EmojiSound emojiSound = (EmojiSound) obj;
            return this.id == emojiSound.id && this.accessHash == emojiSound.accessHash && Arrays.equals(this.fileReference, emojiSound.fileReference);
        }
    }

    public void clearQueryTime() {
        this.lastServerQueryTime.clear();
        this.lastScheduledServerQueryTime.clear();
    }

    /* loaded from: classes4.dex */
    public static class DiceFrameSuccess {
        public int frame;
        public int num;

        public DiceFrameSuccess(int i, int i2) {
            this.frame = i;
            this.num = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DiceFrameSuccess)) {
                return false;
            }
            DiceFrameSuccess diceFrameSuccess = (DiceFrameSuccess) obj;
            return this.frame == diceFrameSuccess.frame && this.num == diceFrameSuccess.num;
        }
    }

    /* loaded from: classes4.dex */
    private static class UserActionUpdatesSeq extends TLRPC$Updates {
        private UserActionUpdatesSeq() {
        }
    }

    /* loaded from: classes4.dex */
    private static class UserActionUpdatesPts extends TLRPC$Updates {
        private UserActionUpdatesPts() {
        }
    }

    /* loaded from: classes4.dex */
    private static class ReadTask {
        public long dialogId;
        public int maxDate;
        public long maxId;
        public long replyId;
        public long sendRequestTime;

        private ReadTask() {
        }
    }

    /* loaded from: classes4.dex */
    public static class DialogFilter {
        private static int dialogFilterPointer = 10;
        public int flags;
        public int id;
        public boolean isSuggested;
        public int localId;
        public String name;
        public int order;
        public volatile int pendingUnreadCount;
        public String suggestedFolderId;
        public int unreadCount;
        public ArrayList<Integer> alwaysShow = new ArrayList<>();
        public ArrayList<Integer> neverShow = new ArrayList<>();
        public LongSparseArray<Integer> pinnedDialogs = new LongSparseArray<>();
        public ArrayList<TLRPC$Dialog> dialogs = new ArrayList<>();

        public DialogFilter() {
            int i = dialogFilterPointer;
            dialogFilterPointer = i + 1;
            this.localId = i;
        }

        public boolean includesDialog(AccountInstance accountInstance, int i) {
            TLRPC$Dialog tLRPC$Dialog = accountInstance.getMessagesController().dialogs_dict.get(i);
            if (tLRPC$Dialog == null) {
                return false;
            }
            return includesDialog(accountInstance, i, tLRPC$Dialog);
        }

        public boolean includesDialog(AccountInstance accountInstance, int i, TLRPC$Dialog tLRPC$Dialog) {
            TLRPC$Chat chat;
            if (this.neverShow.contains(Integer.valueOf(i))) {
                return false;
            }
            if (this.alwaysShow.contains(Integer.valueOf(i))) {
                return true;
            }
            if (tLRPC$Dialog.folder_id != 0 && (this.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED) != 0) {
                return false;
            }
            MessagesController messagesController = accountInstance.getMessagesController();
            ContactsController contactsController = accountInstance.getContactsController();
            if (((this.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED) != 0 && messagesController.isDialogMuted(tLRPC$Dialog.id) && tLRPC$Dialog.unread_mentions_count == 0) || ((this.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0 && tLRPC$Dialog.unread_count == 0 && !tLRPC$Dialog.unread_mark && tLRPC$Dialog.unread_mentions_count == 0)) {
                return false;
            }
            if (i > 0) {
                TLRPC$User user = messagesController.getUser(Integer.valueOf(i));
                if (user != null) {
                    if (!user.bot && !user.support) {
                        if (user.self || user.contact || contactsController.isContact(i)) {
                            if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_CONTACTS) != 0) {
                                return true;
                            }
                        } else if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS) != 0) {
                            return true;
                        }
                    } else {
                        if (user.support) {
                            return (this.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0;
                        }
                        if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_BOTS) != 0) {
                            return true;
                        }
                    }
                }
            } else if (i < 0 && (chat = messagesController.getChat(Integer.valueOf(-i))) != null) {
                if (ChatObject.isChannel(chat) && !chat.megagroup) {
                    if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_CHANNELS) != 0) {
                        return true;
                    }
                } else if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_GROUPS) != 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean alwaysShow(int i, TLRPC$Dialog tLRPC$Dialog) {
            TLRPC$EncryptedChat encryptedChat;
            if (tLRPC$Dialog == null) {
                return false;
            }
            long j = tLRPC$Dialog.id;
            int i2 = (int) j;
            int i3 = (int) (j >> 32);
            if (i2 == 0 && (encryptedChat = MessagesController.getInstance(i).getEncryptedChat(Integer.valueOf(i3))) != null) {
                i2 = encryptedChat.user_id;
            }
            return this.alwaysShow.contains(Integer.valueOf(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$new$1(TLRPC$Dialog tLRPC$Dialog, TLRPC$Dialog tLRPC$Dialog2) {
        int iIntValue = this.sortingDialogFilter.pinnedDialogs.get(tLRPC$Dialog.id, Integer.MIN_VALUE).intValue();
        int iIntValue2 = this.sortingDialogFilter.pinnedDialogs.get(tLRPC$Dialog2.id, Integer.MIN_VALUE).intValue();
        boolean z = tLRPC$Dialog instanceof TLRPC$TL_dialogFolder;
        if (z && !(tLRPC$Dialog2 instanceof TLRPC$TL_dialogFolder)) {
            return -1;
        }
        if (!z && (tLRPC$Dialog2 instanceof TLRPC$TL_dialogFolder)) {
            return 1;
        }
        if (iIntValue == Integer.MIN_VALUE && iIntValue2 != Integer.MIN_VALUE) {
            return 1;
        }
        if (iIntValue != Integer.MIN_VALUE && iIntValue2 == Integer.MIN_VALUE) {
            return -1;
        }
        MediaDataController mediaDataController = getMediaDataController();
        long lastMessageOrDraftDate = DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog, mediaDataController.getDraft(tLRPC$Dialog.id, 0L));
        long lastMessageOrDraftDate2 = DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog2, mediaDataController.getDraft(tLRPC$Dialog2.id, 0L));
        if (lastMessageOrDraftDate < lastMessageOrDraftDate2) {
            return 1;
        }
        return lastMessageOrDraftDate > lastMessageOrDraftDate2 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$new$2(TLRPC$Dialog tLRPC$Dialog, TLRPC$Dialog tLRPC$Dialog2) {
        boolean z = tLRPC$Dialog instanceof TLRPC$TL_dialogFolder;
        if (z && !(tLRPC$Dialog2 instanceof TLRPC$TL_dialogFolder)) {
            return -1;
        }
        if (!z && (tLRPC$Dialog2 instanceof TLRPC$TL_dialogFolder)) {
            return 1;
        }
        boolean z2 = tLRPC$Dialog.pinned;
        if (!z2 && tLRPC$Dialog2.pinned) {
            return 1;
        }
        if (z2 && !tLRPC$Dialog2.pinned) {
            return -1;
        }
        if (z2) {
            int i = tLRPC$Dialog.last_message_date;
            int i2 = tLRPC$Dialog2.last_message_date;
            if (i < i2) {
                return 1;
            }
            return i > i2 ? -1 : 0;
        }
        MediaDataController mediaDataController = getMediaDataController();
        long lastMessageOrDraftDate = DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog, mediaDataController.getDraft(tLRPC$Dialog.id, 0L));
        long lastMessageOrDraftDate2 = DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog2, mediaDataController.getDraft(tLRPC$Dialog2.id, 0L));
        if (lastMessageOrDraftDate < lastMessageOrDraftDate2) {
            return 1;
        }
        return lastMessageOrDraftDate > lastMessageOrDraftDate2 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$new$3(TLRPC$Update tLRPC$Update, TLRPC$Update tLRPC$Update2) {
        int updateType = getUpdateType(tLRPC$Update);
        int updateType2 = getUpdateType(tLRPC$Update2);
        if (updateType != updateType2) {
            return AndroidUtilities.compare(updateType, updateType2);
        }
        if (updateType == 0) {
            return AndroidUtilities.compare(getUpdatePts(tLRPC$Update), getUpdatePts(tLRPC$Update2));
        }
        if (updateType == 1) {
            return AndroidUtilities.compare(getUpdateQts(tLRPC$Update), getUpdateQts(tLRPC$Update2));
        }
        if (updateType != 2) {
            return 0;
        }
        int updateChannelId = getUpdateChannelId(tLRPC$Update);
        int updateChannelId2 = getUpdateChannelId(tLRPC$Update2);
        if (updateChannelId == updateChannelId2) {
            return AndroidUtilities.compare(getUpdatePts(tLRPC$Update), getUpdatePts(tLRPC$Update2));
        }
        return AndroidUtilities.compare(updateChannelId, updateChannelId2);
    }

    public static MessagesController getInstance(int i) {
        MessagesController messagesController = Instance[i];
        if (messagesController == null) {
            synchronized (MessagesController.class) {
                messagesController = Instance[i];
                if (messagesController == null) {
                    MessagesController[] messagesControllerArr = Instance;
                    MessagesController messagesController2 = new MessagesController(i);
                    messagesControllerArr[i] = messagesController2;
                    messagesController = messagesController2;
                }
            }
        }
        return messagesController;
    }

    public boolean isPremiumUser(TLRPC$User tLRPC$User) {
        return !this.premiumLocked && tLRPC$User.premium;
    }

    public static SharedPreferences getNotificationsSettings(int i) {
        return getInstance(i).notificationsPreferences;
    }

    public static SharedPreferences getGlobalNotificationsSettings() {
        return getInstance(0).notificationsPreferences;
    }

    public static SharedPreferences getMainSettings(int i) {
        return getInstance(i).mainPreferences;
    }

    public static SharedPreferences getGlobalMainSettings() {
        return getInstance(0).mainPreferences;
    }

    public static SharedPreferences getEmojiSettings(int i) {
        return getInstance(i).emojiPreferences;
    }

    public static SharedPreferences getGlobalEmojiSettings() {
        return getInstance(0).emojiPreferences;
    }

    public MessagesController(int i) {
        super(i);
        this.chats = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.encryptedChats = new ConcurrentHashMap<>(10, 1.0f, 2);
        this.users = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.objectsByUsernames = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.joiningToChannels = new ArrayList<>();
        this.exportedChats = new SparseArray<>();
        this.hintDialogs = new ArrayList<>();
        this.dialogsByFolder = new SparseArray<>();
        this.allDialogs = new ArrayList<>();
        this.dialogsForward = new ArrayList<>();
        this.dialogsServerOnly = new ArrayList<>();
        this.dialogsCanAddUsers = new ArrayList<>();
        this.dialogsChannelsOnly = new ArrayList<>();
        this.dialogsUsersOnly = new ArrayList<>();
        this.dialogsForBlock = new ArrayList<>();
        this.dialogsGroupsOnly = new ArrayList<>();
        this.selectedDialogFilter = new DialogFilter[2];
        this.dialogsLoadedTillDate = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.dialogs_read_inbox_max = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.dialogs_read_outbox_max = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.dialogs_dict = new LongSparseArray<>();
        this.dialogMessage = new LongSparseArray<>();
        this.dialogMessagesByRandomIds = new LongSparseArray<>();
        this.deletedHistory = new LongSparseArray<>();
        this.dialogMessagesByIds = new LongSparseArray<>();
        this.printingUsers = new ConcurrentHashMap<>(20, 1.0f, 2);
        this.printingStrings = new LongSparseArray<>();
        this.printingStringsTypes = new LongSparseArray<>();
        this.sendingTypings = new LongSparseArray[10];
        this.onlinePrivacy = new ConcurrentHashMap<>(20, 1.0f, 2);
        this.loadingPeerSettings = new LongSparseArray<>();
        this.createdDialogIds = new ArrayList<>();
        this.createdScheduledDialogIds = new ArrayList<>();
        this.createdDialogMainThreadIds = new ArrayList<>();
        this.visibleDialogMainThreadIds = new ArrayList<>();
        this.visibleScheduledDialogMainThreadIds = new ArrayList<>();
        this.shortPollChannels = new SparseIntArray();
        this.needShortPollChannels = new SparseArray<>();
        this.shortPollOnlines = new SparseIntArray();
        this.needShortPollOnlines = new SparseArray<>();
        this.deletingDialogs = new LongSparseArray<>();
        this.clearingHistoryDialogs = new LongSparseArray<>();
        this.loadingBlockedPeers = false;
        this.blockePeers = new SparseIntArray();
        this.nextBlockedPeersId = null;
        this.totalBlockedCount = -1;
        this.channelViewsToSend = new SparseArray<>();
        this.pollsToCheck = new LongSparseArray<>();
        this.dialogFilters = new ArrayList<>();
        this.dialogFiltersById = new SparseArray<>();
        this.suggestedFilters = new ArrayList<>();
        this.updatesQueueChannels = new SparseArray<>();
        this.updatesStartWaitTimeChannels = new SparseLongArray();
        this.channelsPts = new SparseIntArray();
        this.gettingDifferenceChannels = new SparseBooleanArray();
        this.gettingChatInviters = new SparseBooleanArray();
        this.gettingUnknownChannels = new SparseBooleanArray();
        this.gettingUnknownDialogs = new LongSparseArray<>();
        this.checkingLastMessagesDialogs = new SparseBooleanArray();
        this.updatesQueueSeq = new ArrayList<>();
        this.updatesQueuePts = new ArrayList<>();
        this.updatesQueueQts = new ArrayList<>();
        this.fullUsers = new SparseArray<>();
        this.fullChats = new SparseArray<>();
        this.groupCalls = new HashMap();
        this.groupCallsByChatId = new SparseArray<>();
        this.loadingFullUsers = new ArrayList<>();
        this.loadedFullUsers = new ArrayList<>();
        this.loadingFullChats = new ArrayList<>();
        this.loadingGroupCalls = new ArrayList<>();
        this.loadingFullParticipants = new ArrayList<>();
        this.loadedFullParticipants = new ArrayList<>();
        this.loadedFullChats = new ArrayList<>();
        this.channelAdmins = new SparseArray<>();
        this.loadingChannelAdmins = new SparseIntArray();
        this.migratedChats = new SparseIntArray();
        this.reloadingWebpages = new HashMap<>();
        this.reloadingWebpagesPending = new LongSparseArray<>();
        this.reloadingScheduledWebpages = new HashMap<>();
        this.reloadingScheduledWebpagesPending = new LongSparseArray<>();
        this.lastScheduledServerQueryTime = new LongSparseArray<>();
        this.lastServerQueryTime = new LongSparseArray<>();
        this.reloadingMessages = new LongSparseArray<>();
        this.readTasks = new ArrayList<>();
        this.readTasksMap = new LongSparseArray<>();
        this.repliesReadTasks = new ArrayList<>();
        this.threadsReadTasksMap = new LongSparseArray<>();
        this.nextDialogsCacheOffset = new SparseArray<>();
        this.loadingDialogs = new SparseBooleanArray();
        this.dialogsEndReached = new SparseBooleanArray();
        this.serverDialogsEndReached = new SparseBooleanArray();
        this.getDifferenceFirstSync = true;
        this.loadingPinnedDialogs = new SparseIntArray();
        this.faqSearchArray = new ArrayList<>();
        this.adsDialogs = new ArrayList<>();
        this.suggestContacts = true;
        this.themeCheckRunnable = MessagesController$$ExternalSyntheticLambda180.INSTANCE;
        this.passwordCheckRunnable = new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.uploadingThemes = new HashMap<>();
        this.maxBroadcastCount = 100;
        this.minGroupConvertSize = 200;
        this.gifSearchEmojies = new ArrayList<>();
        this.diceSuccess = new HashMap<>();
        this.emojiSounds = new HashMap<>();
        this.photoSuggestion = new LongSparseArray<>();
        this.dialogDateComparator = new Comparator() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda182
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f$0.lambda$new$1((TLRPC$Dialog) obj, (TLRPC$Dialog) obj2);
            }
        };
        this.dialogComparator = new Comparator() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda181
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f$0.lambda$new$2((TLRPC$Dialog) obj, (TLRPC$Dialog) obj2);
            }
        };
        this.updatesComparator = new Comparator() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda183
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f$0.lambda$new$3((TLRPC$Update) obj, (TLRPC$Update) obj2);
            }
        };
        this.DIALOGS_LOAD_TYPE_CACHE = 1;
        this.DIALOGS_LOAD_TYPE_CHANNEL = 2;
        this.DIALOGS_LOAD_TYPE_UNKNOWN = 3;
        this.currentAccount = i;
        ImageLoader.getInstance();
        getMessagesStorage();
        getLocationController();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$4();
            }
        });
        if (this.currentAccount == 0) {
            this.notificationsPreferences = ApplicationLoader.applicationContext.getSharedPreferences("Notifications", 0);
            this.mainPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
            this.emojiPreferences = ApplicationLoader.applicationContext.getSharedPreferences("emoji", 0);
        } else {
            this.notificationsPreferences = ApplicationLoader.applicationContext.getSharedPreferences("Notifications" + this.currentAccount, 0);
            this.mainPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig" + this.currentAccount, 0);
            this.emojiPreferences = ApplicationLoader.applicationContext.getSharedPreferences("emoji" + this.currentAccount, 0);
        }
        this.enableJoined = this.notificationsPreferences.getBoolean("EnableContactJoined", true);
        this.secretWebpagePreview = this.mainPreferences.getInt("secretWebpage2", 2);
        this.maxGroupCount = this.mainPreferences.getInt("maxGroupCount", 200);
        this.maxMegagroupCount = this.mainPreferences.getInt("maxMegagroupCount", 10000);
        this.maxRecentGifsCount = this.mainPreferences.getInt("maxRecentGifsCount", 200);
        this.maxRecentStickersCount = this.mainPreferences.getInt("maxRecentStickersCount", 30);
        this.maxFaveStickersCount = this.mainPreferences.getInt("maxFaveStickersCount", 5);
        this.maxEditTime = this.mainPreferences.getInt("maxEditTime", 3600);
        this.ratingDecay = this.mainPreferences.getInt("ratingDecay", 2419200);
        if (ApplicationLoader.applicationContext != null) {
            this.linkPrefix = ApplicationLoader.applicationContext.getString(ir.medu.shad.R.string.appHostDomainPlain);
        }
        this.callReceiveTimeout = this.mainPreferences.getInt("callReceiveTimeout", 20000);
        this.callRingTimeout = this.mainPreferences.getInt("callRingTimeout", 90000);
        this.callConnectTimeout = this.mainPreferences.getInt("callConnectTimeout", 30000);
        this.callPacketTimeout = this.mainPreferences.getInt("callPacketTimeout", 10000);
        this.updateCheckDelay = this.mainPreferences.getInt("updateCheckDelay", 86400);
        this.maxPinnedDialogsCount = this.mainPreferences.getInt("maxPinnedDialogsCount", 5);
        this.maxFolderPinnedDialogsCount = this.mainPreferences.getInt("maxFolderPinnedDialogsCount", 100);
        this.maxMessageLength = this.mainPreferences.getInt("maxMessageLength", 4096);
        this.maxCaptionLength = this.mainPreferences.getInt("maxCaptionLength", 2048);
        this.mapProvider = this.mainPreferences.getInt("mapProvider", 2);
        this.availableMapProviders = this.mainPreferences.getInt("availableMapProviders", 3);
        this.mapKey = this.mainPreferences.getString("pk", null);
        this.installReferer = this.mainPreferences.getString("installReferer", null);
        this.revokeTimeLimit = this.mainPreferences.getInt("revokeTimeLimit", this.revokeTimeLimit);
        this.revokeTimePmLimit = this.mainPreferences.getInt("revokeTimePmLimit", this.revokeTimePmLimit);
        this.canRevokePmInbox = false;
        this.preloadFeaturedStickers = this.mainPreferences.getBoolean("preloadFeaturedStickers", false);
        this.youtubePipType = this.mainPreferences.getString("youtubePipType", "disabled");
        this.keepAliveService = this.mainPreferences.getBoolean("keepAliveService", false);
        this.backgroundConnection = this.mainPreferences.getBoolean("keepAliveService", false);
        this.promoDialogId = this.mainPreferences.getLong("proxy_dialog", 0L);
        this.nextPromoInfoCheckTime = this.mainPreferences.getInt("nextPromoInfoCheckTime", 0);
        this.promoDialogType = this.mainPreferences.getInt("promo_dialog_type", 0);
        this.promoPsaMessage = this.mainPreferences.getString("promo_psa_message", null);
        this.promoPsaType = this.mainPreferences.getString("promo_psa_type", null);
        this.proxyDialogAddress = this.mainPreferences.getString("proxyDialogAddress", null);
        this.nextTosCheckTime = this.notificationsPreferences.getInt("nextTosCheckTime", 0);
        this.venueSearchBot = this.mainPreferences.getString("venueSearchBot", "foursquare");
        this.gifSearchBot = this.mainPreferences.getString("gifSearchBot", "gif");
        this.imageSearchBot = this.mainPreferences.getString("imageSearchBot", "pic");
        this.blockedCountry = this.mainPreferences.getBoolean("blockedCountry", false);
        this.dcDomainName = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        this.webFileDatacenterId = 4;
        this.suggestedLangCode = this.mainPreferences.getString("suggestedLangCode", "en");
        this.animatedEmojisZoom = this.mainPreferences.getFloat("animatedEmojisZoom", 0.625f);
        this.qrLoginCamera = this.mainPreferences.getBoolean("qrLoginCamera", false);
        this.saveGifsWithStickers = this.mainPreferences.getBoolean("saveGifsWithStickers", false);
        this.filtersEnabled = this.mainPreferences.getBoolean("filtersEnabled", false);
        this.showFiltersTooltip = this.mainPreferences.getBoolean("showFiltersTooltip", false);
        this.autoarchiveAvailable = this.mainPreferences.getBoolean("autoarchiveAvailable", false);
        this.suggestStickersApiOnly = this.mainPreferences.getBoolean("suggestStickersApiOnly", false);
        this.reactionsUserMaxDefault = this.mainPreferences.getInt("reactionsUserMaxDefault", 1);
        this.reactionsUserMaxPremium = this.mainPreferences.getInt("reactionsUserMaxPremium", 3);
        this.chatReadMarkSizeThreshold = this.mainPreferences.getInt("chatReadMarkSizeThreshold", 100);
        this.groupCallVideoMaxParticipants = this.mainPreferences.getInt("groipCallVideoMaxParticipants", 30);
        Set<String> stringSet = this.mainPreferences.getStringSet("pendingSuggestions", null);
        this.pendingSuggestions = stringSet;
        if (stringSet != null) {
            this.pendingSuggestions = new HashSet(this.pendingSuggestions);
        } else {
            this.pendingSuggestions = new HashSet();
        }
        Set<String> stringSet2 = this.mainPreferences.getStringSet("exportUri2", null);
        this.exportUri = stringSet2;
        if (stringSet2 != null) {
            this.exportUri = new HashSet(this.exportUri);
        } else {
            HashSet hashSet = new HashSet();
            this.exportUri = hashSet;
            hashSet.add("content://(\\d+@)?com\\.whatsapp\\.provider\\.media/export_chat/");
            this.exportUri.add("content://(\\d+@)?com\\.whatsapp\\.w4b\\.provider\\.media/export_chat/");
            this.exportUri.add("content://jp\\.naver\\.line\\.android\\.line\\.common\\.FileProvider/export-chat/");
            this.exportUri.add(".*WhatsApp.*\\.txt$");
        }
        Set<String> stringSet3 = this.mainPreferences.getStringSet("exportGroupUri", null);
        this.exportGroupUri = stringSet3;
        if (stringSet3 != null) {
            this.exportGroupUri = new HashSet(this.exportGroupUri);
        } else {
            HashSet hashSet2 = new HashSet();
            this.exportGroupUri = hashSet2;
            hashSet2.add("@g.us/");
        }
        Set<String> stringSet4 = this.mainPreferences.getStringSet("exportPrivateUri", null);
        this.exportPrivateUri = stringSet4;
        if (stringSet4 != null) {
            this.exportPrivateUri = new HashSet(this.exportPrivateUri);
        } else {
            HashSet hashSet3 = new HashSet();
            this.exportPrivateUri = hashSet3;
            hashSet3.add("@s.whatsapp.net/");
        }
        Set<String> stringSet5 = this.mainPreferences.getStringSet("autologinDomains", null);
        this.autologinDomains = stringSet5;
        if (stringSet5 != null) {
            this.autologinDomains = new HashSet(this.autologinDomains);
        } else {
            this.autologinDomains = new HashSet();
        }
        Set<String> stringSet6 = this.mainPreferences.getStringSet("authDomains", null);
        this.authDomains = stringSet6;
        if (stringSet6 != null) {
            this.authDomains = new HashSet(this.authDomains);
        } else {
            this.authDomains = new HashSet();
        }
        this.autologinToken = this.mainPreferences.getString("autologinToken", null);
        Set<String> stringSet7 = this.mainPreferences.getStringSet("diceEmojies", null);
        if (stringSet7 == null) {
            this.diceEmojies = new HashSet<>();
        } else {
            this.diceEmojies = new HashSet<>(stringSet7);
        }
        String string = this.mainPreferences.getString("diceSuccess", null);
        if (string == null) {
            this.diceSuccess.put("🎯", new DiceFrameSuccess(62, 6));
        } else {
            try {
                byte[] bArrDecode = Base64.decode(string, 0);
                if (bArrDecode != null) {
                    SerializedData serializedData = new SerializedData(bArrDecode);
                    int int32 = serializedData.readInt32(true);
                    for (int i2 = 0; i2 < int32; i2++) {
                        this.diceSuccess.put(serializedData.readString(true), new DiceFrameSuccess(serializedData.readInt32(true), serializedData.readInt32(true)));
                    }
                    serializedData.cleanup();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        String string2 = this.mainPreferences.getString("emojiSounds", null);
        if (string2 != null) {
            try {
                byte[] bArrDecode2 = Base64.decode(string2, 0);
                if (bArrDecode2 != null) {
                    SerializedData serializedData2 = new SerializedData(bArrDecode2);
                    int int322 = serializedData2.readInt32(true);
                    for (int i3 = 0; i3 < int322; i3++) {
                        this.emojiSounds.put(serializedData2.readString(true), new EmojiSound(serializedData2.readInt64(true), serializedData2.readInt64(true), serializedData2.readByteArray(true)));
                    }
                    serializedData2.cleanup();
                }
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        String string3 = this.mainPreferences.getString("gifSearchEmojies", null);
        if (string3 == null) {
            this.gifSearchEmojies.add("👍");
            this.gifSearchEmojies.add("👎");
            this.gifSearchEmojies.add("😍");
            this.gifSearchEmojies.add("😂");
            this.gifSearchEmojies.add("😮");
            this.gifSearchEmojies.add("🙄");
            this.gifSearchEmojies.add("😥");
            this.gifSearchEmojies.add("😡");
            this.gifSearchEmojies.add("🥳");
            this.gifSearchEmojies.add("😎");
            return;
        }
        try {
            byte[] bArrDecode3 = Base64.decode(string3, 0);
            if (bArrDecode3 != null) {
                SerializedData serializedData3 = new SerializedData(bArrDecode3);
                int int323 = serializedData3.readInt32(true);
                for (int i4 = 0; i4 < int323; i4++) {
                    this.gifSearchEmojies.add(serializedData3.readString(true));
                }
                serializedData3.cleanup();
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4() {
        MessagesController messagesController = getMessagesController();
        getNotificationCenter().addObserver(messagesController, NotificationCenter.FileDidUpload);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.FileDidFailUpload);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.fileDidLoad);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.fileDidFailToLoad);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.messageReceivedByServer);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.updateMessageMedia);
    }

    private void sendLoadPeersRequest(final TLObject tLObject, final ArrayList<TLObject> arrayList, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, final ArrayList<TLRPC$User> arrayList2, final ArrayList<TLRPC$Chat> arrayList3, final ArrayList<DialogFilter> arrayList4, final SparseArray<DialogFilter> sparseArray, final ArrayList<Integer> arrayList5, final HashMap<Integer, HashSet<Integer>> map, final HashMap<Integer, HashSet<Integer>> map2, final HashSet<Integer> hashSet) {
        getConnectionsManager().sendRequest(tLObject, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda245
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendLoadPeersRequest$5(arrayList3, arrayList2, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, tLObject, arrayList4, sparseArray, arrayList5, map, map2, hashSet, tLObject2, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendLoadPeersRequest$5(ArrayList arrayList, ArrayList arrayList2, TLRPC$messages_Dialogs tLRPC$messages_Dialogs, TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, ArrayList arrayList3, TLObject tLObject, ArrayList arrayList4, SparseArray sparseArray, ArrayList arrayList5, HashMap map, HashMap map2, HashSet hashSet, TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject2 instanceof TLRPC$TL_messages_chats) {
            arrayList.addAll(((TLRPC$TL_messages_chats) tLObject2).chats);
        } else if (tLObject2 instanceof TLRPC$Vector) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject2;
            int size = tLRPC$Vector.objects.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add((TLRPC$User) tLRPC$Vector.objects.get(i));
            }
        } else if (tLObject2 instanceof TLRPC$TL_messages_peerDialogs) {
            TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = (TLRPC$TL_messages_peerDialogs) tLObject2;
            tLRPC$messages_Dialogs.dialogs.addAll(tLRPC$TL_messages_peerDialogs.dialogs);
            tLRPC$messages_Dialogs.messages.addAll(tLRPC$TL_messages_peerDialogs.messages);
            tLRPC$messages_Dialogs2.dialogs.addAll(tLRPC$TL_messages_peerDialogs.dialogs);
            tLRPC$messages_Dialogs2.messages.addAll(tLRPC$TL_messages_peerDialogs.messages);
            arrayList2.addAll(tLRPC$TL_messages_peerDialogs.users);
            arrayList.addAll(tLRPC$TL_messages_peerDialogs.chats);
        }
        arrayList3.remove(tLObject);
        if (arrayList3.isEmpty()) {
            getMessagesStorage().processLoadedFilterPeers(tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList2, arrayList, arrayList4, sparseArray, arrayList5, map, map2, hashSet);
        }
    }

    protected void loadFilterPeers(final HashMap<Integer, TLRPC$InputPeer> map, final HashMap<Integer, TLRPC$InputPeer> map2, final HashMap<Integer, TLRPC$InputPeer> map3, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, final ArrayList<TLRPC$User> arrayList, final ArrayList<TLRPC$Chat> arrayList2, final ArrayList<DialogFilter> arrayList3, final SparseArray<DialogFilter> sparseArray, final ArrayList<Integer> arrayList4, final HashMap<Integer, HashSet<Integer>> map4, final HashMap<Integer, HashSet<Integer>> map5, final HashSet<Integer> hashSet) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda110
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFilterPeers$6(map2, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map4, map5, hashSet, map3, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFilterPeers$6(HashMap map, TLRPC$messages_Dialogs tLRPC$messages_Dialogs, TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, SparseArray sparseArray, ArrayList arrayList4, HashMap map2, HashMap map3, HashSet hashSet, HashMap map4, HashMap map5) {
        TLRPC$TL_users_getUsers tLRPC$TL_users_getUsers;
        int i;
        TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs;
        TLRPC$TL_messages_getChats tLRPC$TL_messages_getChats;
        TLRPC$TL_channels_getChannels tLRPC$TL_channels_getChannels;
        ArrayList<TLObject> arrayList5 = new ArrayList<>();
        loop0: while (true) {
            tLRPC$TL_users_getUsers = null;
            for (Map.Entry entry : map.entrySet()) {
                if (tLRPC$TL_users_getUsers == null) {
                    tLRPC$TL_users_getUsers = new TLRPC$TL_users_getUsers();
                    arrayList5.add(tLRPC$TL_users_getUsers);
                }
                tLRPC$TL_users_getUsers.id.add(getInputUser((TLRPC$InputPeer) entry.getValue()));
                if (tLRPC$TL_users_getUsers.id.size() == 100) {
                    break;
                }
            }
            sendLoadPeersRequest(tLRPC$TL_users_getUsers, arrayList5, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map2, map3, hashSet);
        }
        if (tLRPC$TL_users_getUsers != null) {
            i = 100;
            sendLoadPeersRequest(tLRPC$TL_users_getUsers, arrayList5, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map2, map3, hashSet);
        } else {
            i = 100;
        }
        Iterator it = map4.entrySet().iterator();
        TLRPC$TL_messages_getChats tLRPC$TL_messages_getChats2 = null;
        TLRPC$TL_channels_getChannels tLRPC$TL_channels_getChannels2 = null;
        while (it.hasNext()) {
            TLRPC$InputPeer tLRPC$InputPeer = (TLRPC$InputPeer) ((Map.Entry) it.next()).getValue();
            if (tLRPC$InputPeer.chat_id != 0) {
                if (tLRPC$TL_messages_getChats2 == null) {
                    tLRPC$TL_messages_getChats = new TLRPC$TL_messages_getChats();
                    arrayList5.add(tLRPC$TL_messages_getChats);
                } else {
                    tLRPC$TL_messages_getChats = tLRPC$TL_messages_getChats2;
                }
                tLRPC$TL_messages_getChats.id.add(Long.valueOf(((Integer) r0.getKey()).intValue()));
                if (tLRPC$TL_messages_getChats.id.size() == i) {
                    sendLoadPeersRequest(tLRPC$TL_messages_getChats, arrayList5, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map2, map3, hashSet);
                    tLRPC$TL_messages_getChats2 = null;
                } else {
                    tLRPC$TL_messages_getChats2 = tLRPC$TL_messages_getChats;
                }
            } else if (tLRPC$InputPeer.channel_id != 0) {
                if (tLRPC$TL_channels_getChannels2 == null) {
                    TLRPC$TL_channels_getChannels tLRPC$TL_channels_getChannels3 = new TLRPC$TL_channels_getChannels();
                    arrayList5.add(tLRPC$TL_channels_getChannels3);
                    tLRPC$TL_channels_getChannels = tLRPC$TL_channels_getChannels3;
                } else {
                    tLRPC$TL_channels_getChannels = tLRPC$TL_channels_getChannels2;
                }
                tLRPC$TL_channels_getChannels.id.add(getInputChannel(tLRPC$InputPeer));
                if (tLRPC$TL_channels_getChannels.id.size() == i) {
                    sendLoadPeersRequest(tLRPC$TL_channels_getChannels, arrayList5, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map2, map3, hashSet);
                    tLRPC$TL_channels_getChannels2 = null;
                } else {
                    tLRPC$TL_channels_getChannels2 = tLRPC$TL_channels_getChannels;
                }
            }
        }
        if (tLRPC$TL_messages_getChats2 != null) {
            sendLoadPeersRequest(tLRPC$TL_messages_getChats2, arrayList5, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map2, map3, hashSet);
        }
        if (tLRPC$TL_channels_getChannels2 != null) {
            sendLoadPeersRequest(tLRPC$TL_channels_getChannels2, arrayList5, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map2, map3, hashSet);
        }
        loop3: while (true) {
            tLRPC$TL_messages_getPeerDialogs = null;
            for (Map.Entry entry2 : map5.entrySet()) {
                if (tLRPC$TL_messages_getPeerDialogs == null) {
                    tLRPC$TL_messages_getPeerDialogs = new TLRPC$TL_messages_getPeerDialogs();
                    arrayList5.add(tLRPC$TL_messages_getPeerDialogs);
                }
                TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
                tLRPC$TL_inputDialogPeer.peer = (TLRPC$InputPeer) entry2.getValue();
                tLRPC$TL_messages_getPeerDialogs.peers.add(tLRPC$TL_inputDialogPeer);
                if (tLRPC$TL_messages_getPeerDialogs.peers.size() == i) {
                    break;
                }
            }
            sendLoadPeersRequest(tLRPC$TL_messages_getPeerDialogs, arrayList5, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map2, map3, hashSet);
        }
        if (tLRPC$TL_messages_getPeerDialogs != null) {
            sendLoadPeersRequest(tLRPC$TL_messages_getPeerDialogs, arrayList5, tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map2, map3, hashSet);
        }
    }

    public void processLoadedDialogFilters(final ArrayList<DialogFilter> arrayList, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, final ArrayList<TLRPC$User> arrayList2, final ArrayList<TLRPC$Chat> arrayList3, final ArrayList<TLRPC$EncryptedChat> arrayList4, final int i) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda157
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDialogFilters$9(tLRPC$messages_Dialogs, arrayList4, tLRPC$messages_Dialogs2, arrayList, i, arrayList2, arrayList3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0150, code lost:
    
        if (r11 == r4.id) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0170, code lost:
    
        if (r11.migrated_to != null) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processLoadedDialogFilters$9(org.rbmain.tgnet.TLRPC$messages_Dialogs r20, final java.util.ArrayList r21, final org.rbmain.tgnet.TLRPC$messages_Dialogs r22, final java.util.ArrayList r23, final int r24, final java.util.ArrayList r25, final java.util.ArrayList r26) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.lambda$processLoadedDialogFilters$9(org.rbmain.tgnet.TLRPC$messages_Dialogs, java.util.ArrayList, org.rbmain.tgnet.TLRPC$messages_Dialogs, java.util.ArrayList, int, java.util.ArrayList, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public /* synthetic */ void lambda$processLoadedDialogFilters$8(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, TLRPC$messages_Dialogs tLRPC$messages_Dialogs, ArrayList arrayList4, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        int i2;
        LongSparseArray<TLRPC$Dialog> longSparseArray3;
        TLRPC$messages_Dialogs tLRPC$messages_Dialogs2 = tLRPC$messages_Dialogs;
        if (i != 2) {
            this.dialogFilters = arrayList;
            this.dialogFiltersById.clear();
            int size = this.dialogFilters.size();
            for (int i3 = 0; i3 < size; i3++) {
                DialogFilter dialogFilter = this.dialogFilters.get(i3);
                this.dialogFiltersById.put(dialogFilter.id, dialogFilter);
            }
            Collections.sort(this.dialogFilters, new Comparator() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda185
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return MessagesController.lambda$processLoadedDialogFilters$7((MessagesController.DialogFilter) obj, (MessagesController.DialogFilter) obj2);
                }
            });
            putUsers(arrayList2, true);
            putChats(arrayList3, true);
            this.dialogFiltersLoaded = true;
            getNotificationCenter().postNotificationName(NotificationCenter.dialogFiltersUpdated, new Object[0]);
            if (i == 0) {
                loadRemoteFilters(false);
            }
            if (tLRPC$messages_Dialogs2 != null && !tLRPC$messages_Dialogs2.dialogs.isEmpty()) {
                applyDialogsNotificationsSettings(tLRPC$messages_Dialogs2.dialogs);
            }
            if (arrayList4 != null) {
                for (int i4 = 0; i4 < arrayList4.size(); i4++) {
                    TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) arrayList4.get(i4);
                    if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) && AndroidUtilities.getMyLayerVersion(tLRPC$EncryptedChat.layer) < 101) {
                        getSecretChatHelper().sendNotifyLayerMessage(tLRPC$EncryptedChat, null);
                    }
                    putEncryptedChat(tLRPC$EncryptedChat, true);
                }
            }
            int i5 = 0;
            while (i5 < longSparseArray.size()) {
                long jKeyAt = longSparseArray.keyAt(i5);
                TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) longSparseArray.valueAt(i5);
                TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(jKeyAt);
                if (tLRPC$messages_Dialogs2 != null && tLRPC$messages_Dialogs2.dialogs.contains(tLRPC$Dialog)) {
                    if (tLRPC$Dialog.draft instanceof TLRPC$TL_draftMessage) {
                        getMediaDataController().saveDraft(tLRPC$Dialog.id, 0L, tLRPC$Dialog.draft, null, false);
                    }
                    if (tLRPC$Dialog2 != null) {
                        tLRPC$Dialog2.notify_settings = tLRPC$Dialog.notify_settings;
                    }
                }
                MessageObject messageObject = (MessageObject) longSparseArray2.get(tLRPC$Dialog.id);
                if (tLRPC$Dialog2 == null) {
                    FirebaseEventSender.setKey("dialogs_dictput7", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
                    this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
                    this.dialogMessage.put(jKeyAt, messageObject);
                    if (messageObject != null && messageObject.messageOwner.peer_id.channel_id == 0) {
                        this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                        long j = messageObject.messageOwner.random_id;
                        if (j != 0) {
                            this.dialogMessagesByRandomIds.put(j, messageObject);
                        }
                    }
                } else {
                    tLRPC$Dialog2.pinned = tLRPC$Dialog.pinned;
                    tLRPC$Dialog2.pinnedNum = tLRPC$Dialog.pinnedNum;
                    MessageObject messageObject2 = this.dialogMessage.get(jKeyAt);
                    if ((messageObject2 != null && messageObject2.deleted) || messageObject2 == null || tLRPC$Dialog2.top_message > 0) {
                        long j2 = jKeyAt;
                        if (tLRPC$Dialog.top_message >= tLRPC$Dialog2.top_message) {
                            FirebaseEventSender.setKey("dialogs_dictput8", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
                            this.dialogs_dict.put(j2, tLRPC$Dialog);
                            this.dialogMessage.put(j2, messageObject);
                            if (messageObject2 != null) {
                                if (messageObject2.messageOwner.peer_id.channel_id == 0) {
                                    this.dialogMessagesByIds.remove(messageObject2.getId());
                                }
                                long j3 = messageObject2.messageOwner.random_id;
                                if (j3 != 0) {
                                    this.dialogMessagesByRandomIds.remove(j3);
                                }
                            }
                            if (messageObject != null && messageObject.messageOwner.peer_id.channel_id == 0) {
                                if (messageObject2 != null && messageObject2.getId() == messageObject.getId()) {
                                    messageObject.deleted = messageObject2.deleted;
                                }
                                this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                                long j4 = messageObject.messageOwner.random_id;
                                if (j4 != 0) {
                                    this.dialogMessagesByRandomIds.put(j4, messageObject);
                                }
                            }
                        }
                    } else if (messageObject == null || messageObject.messageOwner.date > messageObject2.messageOwner.date) {
                        FirebaseEventSender.setKey("dialogs_dictput9", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
                        this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
                        this.dialogMessage.put(jKeyAt, messageObject);
                        if (messageObject2.messageOwner.peer_id.channel_id == 0) {
                            this.dialogMessagesByIds.remove(messageObject2.getId());
                        }
                        if (messageObject != null) {
                            if (messageObject2.getId() == messageObject.getId()) {
                                messageObject.deleted = messageObject2.deleted;
                            }
                            if (messageObject.messageOwner.peer_id.channel_id == 0) {
                                this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                                long j5 = messageObject.messageOwner.random_id;
                                if (j5 != 0) {
                                    this.dialogMessagesByRandomIds.put(j5, messageObject);
                                }
                            }
                        }
                        long j6 = messageObject2.messageOwner.random_id;
                        if (j6 != 0) {
                            this.dialogMessagesByRandomIds.remove(j6);
                        }
                    }
                }
                i5++;
                tLRPC$messages_Dialogs2 = tLRPC$messages_Dialogs;
            }
            this.allDialogs.clear();
            int size2 = this.dialogs_dict.size();
            for (int i6 = 0; i6 < size2; i6++) {
                TLRPC$Dialog tLRPC$DialogValueAt = this.dialogs_dict.valueAt(i6);
                if (tLRPC$DialogValueAt != null && ((longSparseArray3 = this.deletingDialogs) == null || longSparseArray3.indexOfKey(tLRPC$DialogValueAt.id) < 0)) {
                    this.allDialogs.add(tLRPC$DialogValueAt);
                }
            }
            sortDialogs(null);
            i2 = 0;
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        } else {
            i2 = 0;
        }
        if (i != 0) {
            getUserConfig().filtersLoaded = true;
            getUserConfig().saveConfig(i2);
            this.loadingRemoteFilters = i2;
            getNotificationCenter().postNotificationName(NotificationCenter.filterSettingsUpdated, new Object[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$processLoadedDialogFilters$7(DialogFilter dialogFilter, DialogFilter dialogFilter2) {
        int i = dialogFilter.order;
        int i2 = dialogFilter2.order;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public void loadSuggestedFilters() {
        if (this.loadingSuggestedFilters) {
            return;
        }
        this.loadingSuggestedFilters = true;
        getDialogsProxy().loadSuggestedFolders(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_getSuggestedDialogFilters
            public static int constructor = -1566780372;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                int int32 = abstractSerializedData.readInt32(z);
                for (int i2 = 0; i2 < int32; i2++) {
                    TLRPC$TL_dialogFilterSuggested tLRPC$TL_dialogFilterSuggestedTLdeserialize = TLRPC$TL_dialogFilterSuggested.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (tLRPC$TL_dialogFilterSuggestedTLdeserialize == null) {
                        return tLRPC$Vector;
                    }
                    tLRPC$Vector.objects.add(tLRPC$TL_dialogFilterSuggestedTLdeserialize);
                }
                return tLRPC$Vector;
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda208
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadSuggestedFilters$11(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSuggestedFilters$10() {
        this.loadingSuggestedFilters = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSuggestedFilters$11(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSuggestedFilters$10();
            }
        });
        getDialogsProxy().processSuggestedFolders(this.dialogFilters);
    }

    public void processLoadedDialogFiltersSuggested(final ArrayList<TLRPC$TL_dialogFilterSuggested> arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda89
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDialogFiltersSuggested$12(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDialogFiltersSuggested$12(ArrayList arrayList) {
        this.suggestedFilters = arrayList;
        getNotificationCenter().postNotificationName(NotificationCenter.suggestedFiltersLoaded, new Object[0]);
    }

    public void loadRemoteFilters(boolean z) {
        if (this.loadingRemoteFilters || !getUserConfig().isClientActivated()) {
            return;
        }
        if (z || !getUserConfig().filtersLoaded) {
            if (z) {
                getUserConfig().filtersLoaded = false;
                getUserConfig().saveConfig(false);
            }
            getDialogsProxy().getFolders(z);
        }
    }

    public void selectDialogFilter(DialogFilter dialogFilter, int i) {
        DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
        if (dialogFilterArr[i] == dialogFilter) {
            return;
        }
        DialogFilter dialogFilter2 = dialogFilterArr[i];
        dialogFilterArr[i] = dialogFilter;
        if (dialogFilterArr[i == 0 ? (char) 1 : (char) 0] == dialogFilter) {
            dialogFilterArr[i != 0 ? (char) 0 : (char) 1] = null;
        }
        if (dialogFilterArr[i] != null) {
            sortDialogs(null);
        } else if (dialogFilter2 != null) {
            dialogFilter2.dialogs.clear();
        }
    }

    public void onFilterUpdate(DialogFilter dialogFilter) {
        for (int i = 0; i < 2; i++) {
            if (this.selectedDialogFilter[i] == dialogFilter) {
                sortDialogs(null);
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
                return;
            }
        }
    }

    public void addFilter(DialogFilter dialogFilter, boolean z) {
        if (z) {
            int iMin = 254;
            int size = this.dialogFilters.size();
            for (int i = 0; i < size; i++) {
                iMin = Math.min(iMin, this.dialogFilters.get(i).order);
            }
            dialogFilter.order = iMin - 1;
            this.dialogFilters.add(0, dialogFilter);
        } else {
            int size2 = this.dialogFilters.size();
            int iMax = 0;
            for (int i2 = 0; i2 < size2; i2++) {
                iMax = Math.max(iMax, this.dialogFilters.get(i2).order);
            }
            dialogFilter.order = iMax + 1;
            this.dialogFilters.add(dialogFilter);
        }
        this.dialogFiltersById.put(dialogFilter.id, dialogFilter);
        if (this.dialogFilters.size() != 1 || SharedConfig.getChatSwipeAction(this.currentAccount) == 4) {
            return;
        }
        SharedConfig.updateChatListSwipeSetting(4);
    }

    public void removeFilter(DialogFilter dialogFilter) {
        this.dialogFilters.remove(dialogFilter);
        this.dialogFiltersById.remove(dialogFilter.id);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogFiltersUpdated, new Object[0]);
    }

    private void loadAppConfig() {
        if (this.loadingAppConfig) {
            return;
        }
        this.loadingAppConfig = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_help_getAppConfig
            public static int constructor = -1735311088;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                return TLRPC$JSONValue.TLdeserialize(abstractSerializedData, i, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda197
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAppConfig$14(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAppConfig$14(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda117
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAppConfig$13(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public /* synthetic */ void lambda$loadAppConfig$13(TLObject tLObject) {
        TLRPC$TL_jsonObjectValue tLRPC$TL_jsonObjectValue;
        TLRPC$TL_jsonObject tLRPC$TL_jsonObject;
        int i;
        TLRPC$TL_jsonObject tLRPC$TL_jsonObject2;
        TLRPC$TL_jsonObject tLRPC$TL_jsonObject3;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        TLRPC$TL_jsonObject tLRPC$TL_jsonObject4;
        int i3;
        int i4;
        boolean z5;
        boolean z6;
        boolean z7;
        int iIntValue;
        boolean z8;
        if (tLObject instanceof TLRPC$TL_jsonObject) {
            SharedPreferences.Editor editorEdit = this.mainPreferences.edit();
            TLRPC$TL_jsonObject tLRPC$TL_jsonObject5 = (TLRPC$TL_jsonObject) tLObject;
            int size = tLRPC$TL_jsonObject5.value.size();
            int i5 = 0;
            boolean z9 = false;
            boolean z10 = false;
            while (i5 < size) {
                tLRPC$TL_jsonObjectValue = tLRPC$TL_jsonObject5.value.get(i5);
                String str = tLRPC$TL_jsonObjectValue.key;
                str.hashCode();
                switch (str) {
                    case "dialog_filters_tooltip":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue = tLRPC$TL_jsonObjectValue.value;
                        if (!(tLRPC$JSONValue instanceof TLRPC$TL_jsonBool) || (z = ((TLRPC$TL_jsonBool) tLRPC$JSONValue).value) == this.showFiltersTooltip) {
                            break;
                        } else {
                            this.showFiltersTooltip = z;
                            editorEdit.putBoolean("showFiltersTooltip", z);
                            getNotificationCenter().postNotificationName(NotificationCenter.filterSettingsUpdated, new Object[0]);
                            z9 = true;
                            break;
                        }
                        break;
                    case "qr_login_camera":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue2 = tLRPC$TL_jsonObjectValue.value;
                        if (!(tLRPC$JSONValue2 instanceof TLRPC$TL_jsonBool) || (z2 = ((TLRPC$TL_jsonBool) tLRPC$JSONValue2).value) == this.qrLoginCamera) {
                            break;
                        } else {
                            this.qrLoginCamera = z2;
                            editorEdit.putBoolean("qrLoginCamera", z2);
                            z9 = true;
                            break;
                        }
                    case "pending_suggestions":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        HashSet hashSet = new HashSet();
                        TLRPC$JSONValue tLRPC$JSONValue3 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue3 instanceof TLRPC$TL_jsonArray) {
                            TLRPC$TL_jsonArray tLRPC$TL_jsonArray = (TLRPC$TL_jsonArray) tLRPC$JSONValue3;
                            int size2 = tLRPC$TL_jsonArray.value.size();
                            for (int i6 = 0; i6 < size2; i6++) {
                                TLRPC$JSONValue tLRPC$JSONValue4 = tLRPC$TL_jsonArray.value.get(i6);
                                if (tLRPC$JSONValue4 instanceof TLRPC$TL_jsonString) {
                                    hashSet.add(((TLRPC$TL_jsonString) tLRPC$JSONValue4).value);
                                }
                            }
                        }
                        if (this.pendingSuggestions.equals(hashSet)) {
                            break;
                        } else {
                            this.pendingSuggestions = hashSet;
                            editorEdit.putStringSet("pendingSuggestions", hashSet);
                            getNotificationCenter().postNotificationName(NotificationCenter.newSuggestionsAvailable, new Object[0]);
                            z9 = true;
                            break;
                        }
                    case "emojies_send_dice":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        HashSet<String> hashSet2 = new HashSet<>();
                        TLRPC$JSONValue tLRPC$JSONValue5 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue5 instanceof TLRPC$TL_jsonArray) {
                            TLRPC$TL_jsonArray tLRPC$TL_jsonArray2 = (TLRPC$TL_jsonArray) tLRPC$JSONValue5;
                            int size3 = tLRPC$TL_jsonArray2.value.size();
                            for (int i7 = 0; i7 < size3; i7++) {
                                TLRPC$JSONValue tLRPC$JSONValue6 = tLRPC$TL_jsonArray2.value.get(i7);
                                if (tLRPC$JSONValue6 instanceof TLRPC$TL_jsonString) {
                                    hashSet2.add(((TLRPC$TL_jsonString) tLRPC$JSONValue6).value.replace("️", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR));
                                }
                            }
                        }
                        if (this.diceEmojies.equals(hashSet2)) {
                            break;
                        } else {
                            this.diceEmojies = hashSet2;
                            editorEdit.putStringSet("diceEmojies", hashSet2);
                            z9 = true;
                            break;
                        }
                    case "url_auth_domains":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        HashSet hashSet3 = new HashSet();
                        TLRPC$JSONValue tLRPC$JSONValue7 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue7 instanceof TLRPC$TL_jsonArray) {
                            TLRPC$TL_jsonArray tLRPC$TL_jsonArray3 = (TLRPC$TL_jsonArray) tLRPC$JSONValue7;
                            int size4 = tLRPC$TL_jsonArray3.value.size();
                            for (int i8 = 0; i8 < size4; i8++) {
                                TLRPC$JSONValue tLRPC$JSONValue8 = tLRPC$TL_jsonArray3.value.get(i8);
                                if (tLRPC$JSONValue8 instanceof TLRPC$TL_jsonString) {
                                    hashSet3.add(((TLRPC$TL_jsonString) tLRPC$JSONValue8).value);
                                }
                            }
                        }
                        if (this.authDomains.equals(hashSet3)) {
                            break;
                        } else {
                            this.authDomains = hashSet3;
                            editorEdit.putStringSet("authDomains", hashSet3);
                            z9 = true;
                            break;
                        }
                    case "export_regex":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        HashSet hashSet4 = new HashSet();
                        TLRPC$JSONValue tLRPC$JSONValue9 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue9 instanceof TLRPC$TL_jsonArray) {
                            TLRPC$TL_jsonArray tLRPC$TL_jsonArray4 = (TLRPC$TL_jsonArray) tLRPC$JSONValue9;
                            int size5 = tLRPC$TL_jsonArray4.value.size();
                            for (int i9 = 0; i9 < size5; i9++) {
                                TLRPC$JSONValue tLRPC$JSONValue10 = tLRPC$TL_jsonArray4.value.get(i9);
                                if (tLRPC$JSONValue10 instanceof TLRPC$TL_jsonString) {
                                    hashSet4.add(((TLRPC$TL_jsonString) tLRPC$JSONValue10).value);
                                }
                            }
                        }
                        if (this.exportUri.equals(hashSet4)) {
                            break;
                        } else {
                            this.exportUri = hashSet4;
                            editorEdit.putStringSet("exportUri2", hashSet4);
                            z9 = true;
                            break;
                        }
                    case "keep_alive_service":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue11 = tLRPC$TL_jsonObjectValue.value;
                        if (!(tLRPC$JSONValue11 instanceof TLRPC$TL_jsonBool) || (z3 = ((TLRPC$TL_jsonBool) tLRPC$JSONValue11).value) == this.keepAliveService) {
                            break;
                        } else {
                            this.keepAliveService = z3;
                            editorEdit.putBoolean("keepAliveService", z3);
                            z9 = true;
                            z10 = true;
                            break;
                        }
                    case "background_connection":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue12 = tLRPC$TL_jsonObjectValue.value;
                        if (!(tLRPC$JSONValue12 instanceof TLRPC$TL_jsonBool) || (z4 = ((TLRPC$TL_jsonBool) tLRPC$JSONValue12).value) == this.backgroundConnection) {
                            break;
                        } else {
                            this.backgroundConnection = z4;
                            editorEdit.putBoolean("backgroundConnection", z4);
                            z9 = true;
                            z10 = true;
                            break;
                        }
                        break;
                    case "emojies_send_dice_success":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        try {
                            HashMap<String, DiceFrameSuccess> map = new HashMap<>();
                            TLRPC$JSONValue tLRPC$JSONValue13 = tLRPC$TL_jsonObjectValue.value;
                            if (tLRPC$JSONValue13 instanceof TLRPC$TL_jsonObject) {
                                TLRPC$TL_jsonObject tLRPC$TL_jsonObject6 = (TLRPC$TL_jsonObject) tLRPC$JSONValue13;
                                int size6 = tLRPC$TL_jsonObject6.value.size();
                                int i10 = 0;
                                while (i10 < size6) {
                                    TLRPC$TL_jsonObjectValue tLRPC$TL_jsonObjectValue2 = tLRPC$TL_jsonObject6.value.get(i10);
                                    TLRPC$JSONValue tLRPC$JSONValue14 = tLRPC$TL_jsonObjectValue2.value;
                                    if (tLRPC$JSONValue14 instanceof TLRPC$TL_jsonObject) {
                                        TLRPC$TL_jsonObject tLRPC$TL_jsonObject7 = (TLRPC$TL_jsonObject) tLRPC$JSONValue14;
                                        int size7 = tLRPC$TL_jsonObject7.value.size();
                                        tLRPC$TL_jsonObject4 = tLRPC$TL_jsonObject6;
                                        int i11 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                                        int i12 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                                        int i13 = 0;
                                        while (i13 < size7) {
                                            int i14 = size6;
                                            TLRPC$TL_jsonObjectValue tLRPC$TL_jsonObjectValue3 = tLRPC$TL_jsonObject7.value.get(i13);
                                            TLRPC$TL_jsonObject tLRPC$TL_jsonObject8 = tLRPC$TL_jsonObject7;
                                            if (tLRPC$TL_jsonObjectValue3.value instanceof TLRPC$TL_jsonNumber) {
                                                i4 = size7;
                                                if ("value".equals(tLRPC$TL_jsonObjectValue3.key)) {
                                                    i11 = (int) ((TLRPC$TL_jsonNumber) tLRPC$TL_jsonObjectValue3.value).value;
                                                } else if ("frame_start".equals(tLRPC$TL_jsonObjectValue3.key)) {
                                                    i12 = (int) ((TLRPC$TL_jsonNumber) tLRPC$TL_jsonObjectValue3.value).value;
                                                }
                                            } else {
                                                i4 = size7;
                                            }
                                            i13++;
                                            size6 = i14;
                                            tLRPC$TL_jsonObject7 = tLRPC$TL_jsonObject8;
                                            size7 = i4;
                                        }
                                        i3 = size6;
                                        if (i12 != Integer.MAX_VALUE && i11 != Integer.MAX_VALUE) {
                                            map.put(tLRPC$TL_jsonObjectValue2.key.replace("️", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR), new DiceFrameSuccess(i12, i11));
                                        }
                                    } else {
                                        tLRPC$TL_jsonObject4 = tLRPC$TL_jsonObject6;
                                        i3 = size6;
                                    }
                                    i10++;
                                    tLRPC$TL_jsonObject6 = tLRPC$TL_jsonObject4;
                                    size6 = i3;
                                }
                            }
                            if (this.diceSuccess.equals(map)) {
                                break;
                            } else {
                                this.diceSuccess = map;
                                SerializedData serializedData = new SerializedData();
                                serializedData.writeInt32(this.diceSuccess.size());
                                for (Map.Entry<String, DiceFrameSuccess> entry : this.diceSuccess.entrySet()) {
                                    serializedData.writeString(entry.getKey());
                                    DiceFrameSuccess value = entry.getValue();
                                    serializedData.writeInt32(value.frame);
                                    serializedData.writeInt32(value.num);
                                }
                                editorEdit.putString("diceSuccess", Base64.encodeToString(serializedData.toByteArray(), 0));
                                serializedData.cleanup();
                                z9 = true;
                                break;
                            }
                        } catch (Exception e) {
                            FileLog.e(e);
                            break;
                        }
                        break;
                    case "autoarchive_setting_available":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue15 = tLRPC$TL_jsonObjectValue.value;
                        if (!(tLRPC$JSONValue15 instanceof TLRPC$TL_jsonBool) || (z5 = ((TLRPC$TL_jsonBool) tLRPC$JSONValue15).value) == this.autoarchiveAvailable) {
                            break;
                        } else {
                            this.autoarchiveAvailable = z5;
                            editorEdit.putBoolean("autoarchiveAvailable", z5);
                            z9 = true;
                            break;
                        }
                    case "youtube_pip":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue16 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue16 instanceof TLRPC$TL_jsonString) {
                            TLRPC$TL_jsonString tLRPC$TL_jsonString = (TLRPC$TL_jsonString) tLRPC$JSONValue16;
                            if (tLRPC$TL_jsonString.value.equals(this.youtubePipType)) {
                                break;
                            } else {
                                String str2 = tLRPC$TL_jsonString.value;
                                this.youtubePipType = str2;
                                editorEdit.putString("youtubePipType", str2);
                                z9 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    case "emojies_animated_zoom":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue17 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue17 instanceof TLRPC$TL_jsonNumber) {
                            double d = this.animatedEmojisZoom;
                            double d2 = ((TLRPC$TL_jsonNumber) tLRPC$JSONValue17).value;
                            if (d != d2) {
                                float f = (float) d2;
                                this.animatedEmojisZoom = f;
                                editorEdit.putFloat("animatedEmojisZoom", f);
                                z9 = true;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case "stickers_emoji_suggest_only_api":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue18 = tLRPC$TL_jsonObjectValue.value;
                        if (!(tLRPC$JSONValue18 instanceof TLRPC$TL_jsonBool) || (z6 = ((TLRPC$TL_jsonBool) tLRPC$JSONValue18).value) == this.suggestStickersApiOnly) {
                            break;
                        } else {
                            this.suggestStickersApiOnly = z6;
                            editorEdit.putBoolean("suggestStickersApiOnly", z6);
                            z9 = true;
                            break;
                        }
                    case "gif_search_emojies":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        ArrayList<String> arrayList = new ArrayList<>();
                        TLRPC$JSONValue tLRPC$JSONValue19 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue19 instanceof TLRPC$TL_jsonArray) {
                            TLRPC$TL_jsonArray tLRPC$TL_jsonArray5 = (TLRPC$TL_jsonArray) tLRPC$JSONValue19;
                            int size8 = tLRPC$TL_jsonArray5.value.size();
                            for (int i15 = 0; i15 < size8; i15++) {
                                TLRPC$JSONValue tLRPC$JSONValue20 = tLRPC$TL_jsonArray5.value.get(i15);
                                if (tLRPC$JSONValue20 instanceof TLRPC$TL_jsonString) {
                                    arrayList.add(((TLRPC$TL_jsonString) tLRPC$JSONValue20).value.replace("️", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR));
                                }
                            }
                        }
                        if (this.gifSearchEmojies.equals(arrayList)) {
                            break;
                        } else {
                            this.gifSearchEmojies = arrayList;
                            SerializedData serializedData2 = new SerializedData();
                            serializedData2.writeInt32(this.gifSearchEmojies.size());
                            int size9 = this.gifSearchEmojies.size();
                            for (int i16 = 0; i16 < size9; i16++) {
                                serializedData2.writeString(this.gifSearchEmojies.get(i16));
                            }
                            editorEdit.putString("gifSearchEmojies", Base64.encodeToString(serializedData2.toByteArray(), 0));
                            serializedData2.cleanup();
                            z9 = true;
                            break;
                        }
                    case "autologin_domains":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        HashSet hashSet5 = new HashSet();
                        TLRPC$JSONValue tLRPC$JSONValue21 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue21 instanceof TLRPC$TL_jsonArray) {
                            TLRPC$TL_jsonArray tLRPC$TL_jsonArray6 = (TLRPC$TL_jsonArray) tLRPC$JSONValue21;
                            int size10 = tLRPC$TL_jsonArray6.value.size();
                            for (int i17 = 0; i17 < size10; i17++) {
                                TLRPC$JSONValue tLRPC$JSONValue22 = tLRPC$TL_jsonArray6.value.get(i17);
                                if (tLRPC$JSONValue22 instanceof TLRPC$TL_jsonString) {
                                    hashSet5.add(((TLRPC$TL_jsonString) tLRPC$JSONValue22).value);
                                }
                            }
                        }
                        if (this.autologinDomains.equals(hashSet5)) {
                            break;
                        } else {
                            this.autologinDomains = hashSet5;
                            editorEdit.putStringSet("autologinDomains", hashSet5);
                            z9 = true;
                            break;
                        }
                    case "export_group_urls":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        HashSet hashSet6 = new HashSet();
                        TLRPC$JSONValue tLRPC$JSONValue23 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue23 instanceof TLRPC$TL_jsonArray) {
                            TLRPC$TL_jsonArray tLRPC$TL_jsonArray7 = (TLRPC$TL_jsonArray) tLRPC$JSONValue23;
                            int size11 = tLRPC$TL_jsonArray7.value.size();
                            for (int i18 = 0; i18 < size11; i18++) {
                                TLRPC$JSONValue tLRPC$JSONValue24 = tLRPC$TL_jsonArray7.value.get(i18);
                                if (tLRPC$JSONValue24 instanceof TLRPC$TL_jsonString) {
                                    hashSet6.add(((TLRPC$TL_jsonString) tLRPC$JSONValue24).value);
                                }
                            }
                        }
                        if (this.exportGroupUri.equals(hashSet6)) {
                            break;
                        } else {
                            this.exportGroupUri = hashSet6;
                            editorEdit.putStringSet("exportGroupUri", hashSet6);
                            z9 = true;
                            break;
                        }
                    case "autologin_token":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue25 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue25 instanceof TLRPC$TL_jsonString) {
                            TLRPC$TL_jsonString tLRPC$TL_jsonString2 = (TLRPC$TL_jsonString) tLRPC$JSONValue25;
                            if (tLRPC$TL_jsonString2.value.equals(this.autologinToken)) {
                                break;
                            } else {
                                String str3 = tLRPC$TL_jsonString2.value;
                                this.autologinToken = str3;
                                editorEdit.putString("autologinToken", str3);
                                z9 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    case "save_gifs_with_stickers":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue26 = tLRPC$TL_jsonObjectValue.value;
                        if (!(tLRPC$JSONValue26 instanceof TLRPC$TL_jsonBool) || (z7 = ((TLRPC$TL_jsonBool) tLRPC$JSONValue26).value) == this.saveGifsWithStickers) {
                            break;
                        } else {
                            this.saveGifsWithStickers = z7;
                            editorEdit.putBoolean("saveGifsWithStickers", z7);
                            z9 = true;
                            break;
                        }
                        break;
                    case "inapp_update_check_delay":
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        TLRPC$JSONValue tLRPC$JSONValue27 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue27 instanceof TLRPC$TL_jsonNumber) {
                            double d3 = ((TLRPC$TL_jsonNumber) tLRPC$JSONValue27).value;
                            if (d3 != this.updateCheckDelay) {
                                int i19 = (int) d3;
                                this.updateCheckDelay = i19;
                                editorEdit.putInt("updateCheckDelay", i19);
                                z9 = true;
                                break;
                            } else {
                                break;
                            }
                        } else if (!(tLRPC$JSONValue27 instanceof TLRPC$TL_jsonString) || (iIntValue = Utilities.parseInt(((TLRPC$TL_jsonString) tLRPC$JSONValue27).value).intValue()) == this.updateCheckDelay) {
                            break;
                        } else {
                            this.updateCheckDelay = iIntValue;
                            editorEdit.putInt("updateCheckDelay", iIntValue);
                            z9 = true;
                        }
                        break;
                    case "emojies_sounds":
                        try {
                            HashMap<String, EmojiSound> map2 = new HashMap<>();
                            TLRPC$JSONValue tLRPC$JSONValue28 = tLRPC$TL_jsonObjectValue.value;
                            if (tLRPC$JSONValue28 instanceof TLRPC$TL_jsonObject) {
                                TLRPC$TL_jsonObject tLRPC$TL_jsonObject9 = (TLRPC$TL_jsonObject) tLRPC$JSONValue28;
                                int size12 = tLRPC$TL_jsonObject9.value.size();
                                int i20 = 0;
                                while (i20 < size12) {
                                    TLRPC$TL_jsonObjectValue tLRPC$TL_jsonObjectValue4 = tLRPC$TL_jsonObject9.value.get(i20);
                                    TLRPC$JSONValue tLRPC$JSONValue29 = tLRPC$TL_jsonObjectValue4.value;
                                    if (tLRPC$JSONValue29 instanceof TLRPC$TL_jsonObject) {
                                        TLRPC$TL_jsonObject tLRPC$TL_jsonObject10 = (TLRPC$TL_jsonObject) tLRPC$JSONValue29;
                                        int size13 = tLRPC$TL_jsonObject10.value.size();
                                        tLRPC$TL_jsonObject2 = tLRPC$TL_jsonObject9;
                                        long jLongValue = 0;
                                        long jLongValue2 = 0;
                                        int i21 = 0;
                                        String str4 = null;
                                        while (i21 < size13) {
                                            int i22 = size13;
                                            TLRPC$TL_jsonObjectValue tLRPC$TL_jsonObjectValue5 = tLRPC$TL_jsonObject10.value.get(i21);
                                            tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                                            try {
                                                if (tLRPC$TL_jsonObjectValue5.value instanceof TLRPC$TL_jsonString) {
                                                    i = size;
                                                    try {
                                                        if ("id".equals(tLRPC$TL_jsonObjectValue5.key)) {
                                                            jLongValue = Utilities.parseLong(((TLRPC$TL_jsonString) tLRPC$TL_jsonObjectValue5.value).value).longValue();
                                                        } else if ("access_hash".equals(tLRPC$TL_jsonObjectValue5.key)) {
                                                            jLongValue2 = Utilities.parseLong(((TLRPC$TL_jsonString) tLRPC$TL_jsonObjectValue5.value).value).longValue();
                                                        } else if ("file_reference_base64".equals(tLRPC$TL_jsonObjectValue5.key)) {
                                                            str4 = ((TLRPC$TL_jsonString) tLRPC$TL_jsonObjectValue5.value).value;
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        FileLog.e(e);
                                                        i5++;
                                                        tLRPC$TL_jsonObject5 = tLRPC$TL_jsonObject;
                                                        size = i;
                                                    }
                                                } else {
                                                    i = size;
                                                }
                                                i21++;
                                                size13 = i22;
                                                tLRPC$TL_jsonObject5 = tLRPC$TL_jsonObject;
                                                size = i;
                                            } catch (Exception e3) {
                                                e = e3;
                                                i = size;
                                                FileLog.e(e);
                                                i5++;
                                                tLRPC$TL_jsonObject5 = tLRPC$TL_jsonObject;
                                                size = i;
                                            }
                                        }
                                        tLRPC$TL_jsonObject3 = tLRPC$TL_jsonObject5;
                                        i2 = size;
                                        if (jLongValue != 0 && jLongValue2 != 0 && str4 != null) {
                                            map2.put(tLRPC$TL_jsonObjectValue4.key.replace("️", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR), new EmojiSound(jLongValue, jLongValue2, str4));
                                        }
                                    } else {
                                        tLRPC$TL_jsonObject2 = tLRPC$TL_jsonObject9;
                                        tLRPC$TL_jsonObject3 = tLRPC$TL_jsonObject5;
                                        i2 = size;
                                    }
                                    i20++;
                                    tLRPC$TL_jsonObject9 = tLRPC$TL_jsonObject2;
                                    tLRPC$TL_jsonObject5 = tLRPC$TL_jsonObject3;
                                    size = i2;
                                }
                            }
                            tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                            i = size;
                            if (!this.emojiSounds.equals(map2)) {
                                this.emojiSounds = map2;
                                SerializedData serializedData3 = new SerializedData();
                                serializedData3.writeInt32(this.emojiSounds.size());
                                for (Map.Entry<String, EmojiSound> entry2 : this.emojiSounds.entrySet()) {
                                    serializedData3.writeString(entry2.getKey());
                                    EmojiSound value2 = entry2.getValue();
                                    serializedData3.writeInt64(value2.id);
                                    serializedData3.writeInt64(value2.accessHash);
                                    serializedData3.writeByteArray(value2.fileReference);
                                }
                                editorEdit.putString("emojiSounds", Base64.encodeToString(serializedData3.toByteArray(), 0));
                                serializedData3.cleanup();
                                z9 = true;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        }
                        break;
                    case "export_private_urls":
                        HashSet hashSet7 = new HashSet();
                        TLRPC$JSONValue tLRPC$JSONValue30 = tLRPC$TL_jsonObjectValue.value;
                        if (tLRPC$JSONValue30 instanceof TLRPC$TL_jsonArray) {
                            TLRPC$TL_jsonArray tLRPC$TL_jsonArray8 = (TLRPC$TL_jsonArray) tLRPC$JSONValue30;
                            int size14 = tLRPC$TL_jsonArray8.value.size();
                            for (int i23 = 0; i23 < size14; i23++) {
                                TLRPC$JSONValue tLRPC$JSONValue31 = tLRPC$TL_jsonArray8.value.get(i23);
                                if (tLRPC$JSONValue31 instanceof TLRPC$TL_jsonString) {
                                    hashSet7.add(((TLRPC$TL_jsonString) tLRPC$JSONValue31).value);
                                }
                            }
                        }
                        if (!this.exportPrivateUri.equals(hashSet7)) {
                            this.exportPrivateUri = hashSet7;
                            editorEdit.putStringSet("exportPrivateUri", hashSet7);
                            tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                            i = size;
                            z9 = true;
                            break;
                        }
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        break;
                    case "dialog_filters_enabled":
                        TLRPC$JSONValue tLRPC$JSONValue32 = tLRPC$TL_jsonObjectValue.value;
                        if ((tLRPC$JSONValue32 instanceof TLRPC$TL_jsonBool) && (z8 = ((TLRPC$TL_jsonBool) tLRPC$JSONValue32).value) != this.filtersEnabled) {
                            this.filtersEnabled = z8;
                            editorEdit.putBoolean("filtersEnabled", z8);
                            z9 = true;
                        }
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        break;
                    default:
                        tLRPC$TL_jsonObject = tLRPC$TL_jsonObject5;
                        i = size;
                        break;
                }
                i5++;
                tLRPC$TL_jsonObject5 = tLRPC$TL_jsonObject;
                size = i;
            }
            if (z9) {
                editorEdit.apply();
            }
            if (z10) {
                ApplicationLoader.startPushService();
                ConnectionsManager connectionsManager = getConnectionsManager();
                connectionsManager.setPushConnectionEnabled(connectionsManager.isPushConnectionEnabled());
            }
        }
        this.loadingAppConfig = false;
    }

    public void removeSuggestion(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (j == 0) {
            if (!this.pendingSuggestions.remove(str)) {
                return;
            }
            SharedPreferences.Editor editorEdit = this.mainPreferences.edit();
            editorEdit.putStringSet("pendingSuggestions", this.pendingSuggestions);
            editorEdit.apply();
        }
        TLRPC$TL_help_dismissSuggestion tLRPC$TL_help_dismissSuggestion = new TLRPC$TL_help_dismissSuggestion();
        tLRPC$TL_help_dismissSuggestion.suggestion = str;
        if (j == 0) {
            tLRPC$TL_help_dismissSuggestion.peer = new TLRPC$TL_inputPeerEmpty();
        } else {
            tLRPC$TL_help_dismissSuggestion.peer = getInputPeer((int) j);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_help_dismissSuggestion, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda277
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$removeSuggestion$15(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void addSupportUser() {
        TLRPC$TL_userForeign_old2 tLRPC$TL_userForeign_old2 = new TLRPC$TL_userForeign_old2();
        tLRPC$TL_userForeign_old2.phone = "333";
        tLRPC$TL_userForeign_old2.id = 333000;
        tLRPC$TL_userForeign_old2.first_name = LocaleController.getString(ir.medu.shad.R.string.FilePath);
        tLRPC$TL_userForeign_old2.last_name = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        tLRPC$TL_userForeign_old2.status = null;
        tLRPC$TL_userForeign_old2.photo = new TLRPC$TL_userProfilePhotoEmpty();
        putUser(tLRPC$TL_userForeign_old2, true);
        TLRPC$TL_userForeign_old2 tLRPC$TL_userForeign_old22 = new TLRPC$TL_userForeign_old2();
        tLRPC$TL_userForeign_old22.phone = "42777";
        tLRPC$TL_userForeign_old22.id = 777000;
        tLRPC$TL_userForeign_old22.verified = true;
        tLRPC$TL_userForeign_old22.first_name = LocaleController.getString(ir.medu.shad.R.string.FilePath);
        tLRPC$TL_userForeign_old22.last_name = "Notifications";
        tLRPC$TL_userForeign_old22.status = null;
        tLRPC$TL_userForeign_old22.photo = new TLRPC$TL_userProfilePhotoEmpty();
        putUser(tLRPC$TL_userForeign_old22, true);
    }

    public TLRPC$InputUser getInputUser(TLRPC$User tLRPC$User) {
        if (tLRPC$User == null) {
            return new TLRPC$TL_inputUserEmpty();
        }
        if (tLRPC$User.id == getUserConfig().getClientUserId()) {
            return new TLRPC$TL_inputUserSelf();
        }
        TLRPC$TL_inputUser tLRPC$TL_inputUser = new TLRPC$TL_inputUser();
        tLRPC$TL_inputUser.user_id = tLRPC$User.id;
        tLRPC$TL_inputUser.access_hash = tLRPC$User.access_hash;
        return tLRPC$TL_inputUser;
    }

    public TLRPC$InputUser getInputUser(TLRPC$InputPeer tLRPC$InputPeer) {
        if (tLRPC$InputPeer == null) {
            return new TLRPC$TL_inputUserEmpty();
        }
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerSelf) {
            return new TLRPC$TL_inputUserSelf();
        }
        TLRPC$TL_inputUser tLRPC$TL_inputUser = new TLRPC$TL_inputUser();
        tLRPC$TL_inputUser.user_id = tLRPC$InputPeer.user_id;
        tLRPC$TL_inputUser.access_hash = tLRPC$InputPeer.access_hash;
        return tLRPC$TL_inputUser;
    }

    public TLRPC$InputUser getInputUser(int i) {
        return getInputUser(getInstance(UserConfig.selectedAccount).getUser(Integer.valueOf(i)));
    }

    public static TLRPC$InputChannel getInputChannel(TLRPC$Chat tLRPC$Chat) {
        if ((tLRPC$Chat instanceof TLRPC$TL_channel) || (tLRPC$Chat instanceof TLRPC$TL_channelForbidden)) {
            TLRPC$TL_inputChannel tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
            tLRPC$TL_inputChannel.channel_id = tLRPC$Chat.id;
            tLRPC$TL_inputChannel.access_hash = tLRPC$Chat.access_hash;
            return tLRPC$TL_inputChannel;
        }
        return new TLRPC$TL_inputChannelEmpty();
    }

    public static TLRPC$InputChannel getInputChannel(TLRPC$InputPeer tLRPC$InputPeer) {
        TLRPC$TL_inputChannel tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
        tLRPC$TL_inputChannel.channel_id = tLRPC$InputPeer.channel_id;
        tLRPC$TL_inputChannel.access_hash = tLRPC$InputPeer.access_hash;
        return tLRPC$TL_inputChannel;
    }

    public TLRPC$InputChannel getInputChannel(int i) {
        return getInputChannel(getChat(Integer.valueOf(i)));
    }

    public TLRPC$InputPeer getInputPeer(TLRPC$Peer tLRPC$Peer) {
        if (tLRPC$Peer instanceof TLRPC$TL_peerChat) {
            TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            tLRPC$TL_inputPeerChat.chat_id = tLRPC$Peer.chat_id;
            return tLRPC$TL_inputPeerChat;
        }
        if (tLRPC$Peer instanceof TLRPC$TL_peerChannel) {
            TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
            int i = tLRPC$Peer.channel_id;
            tLRPC$TL_inputPeerChannel.channel_id = i;
            TLRPC$Chat chat = getChat(Integer.valueOf(i));
            if (chat == null) {
                return tLRPC$TL_inputPeerChannel;
            }
            tLRPC$TL_inputPeerChannel.access_hash = chat.access_hash;
            return tLRPC$TL_inputPeerChannel;
        }
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        int i2 = tLRPC$Peer.user_id;
        tLRPC$TL_inputPeerUser.user_id = i2;
        TLRPC$User user = getUser(Integer.valueOf(i2));
        if (user == null) {
            return tLRPC$TL_inputPeerUser;
        }
        tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
        return tLRPC$TL_inputPeerUser;
    }

    public TLRPC$InputPeer getInputPeer(int i) {
        if (i < 0) {
            int i2 = -i;
            TLRPC$Chat chat = getChat(Integer.valueOf(i2));
            if (ChatObject.isChannel(chat)) {
                TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                tLRPC$TL_inputPeerChannel.channel_id = i2;
                tLRPC$TL_inputPeerChannel.access_hash = chat.access_hash;
                return tLRPC$TL_inputPeerChannel;
            }
            TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            tLRPC$TL_inputPeerChat.chat_id = i2;
            return tLRPC$TL_inputPeerChat;
        }
        TLRPC$User user = getUser(Integer.valueOf(i));
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        tLRPC$TL_inputPeerUser.user_id = i;
        if (user == null) {
            return tLRPC$TL_inputPeerUser;
        }
        tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
        return tLRPC$TL_inputPeerUser;
    }

    public static TLRPC$InputPeer getInputPeer(TLRPC$Chat tLRPC$Chat) {
        if (ChatObject.isChannel(tLRPC$Chat)) {
            TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
            tLRPC$TL_inputPeerChannel.channel_id = tLRPC$Chat.id;
            tLRPC$TL_inputPeerChannel.access_hash = tLRPC$Chat.access_hash;
            return tLRPC$TL_inputPeerChannel;
        }
        TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
        tLRPC$TL_inputPeerChat.chat_id = tLRPC$Chat.id;
        return tLRPC$TL_inputPeerChat;
    }

    public static TLRPC$InputPeer getInputPeer(TLRPC$User tLRPC$User) {
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        tLRPC$TL_inputPeerUser.user_id = tLRPC$User.id;
        tLRPC$TL_inputPeerUser.access_hash = tLRPC$User.access_hash;
        return tLRPC$TL_inputPeerUser;
    }

    public TLRPC$Peer getPeer(int i) {
        if (i < 0) {
            int i2 = -i;
            TLRPC$Chat chat = getChat(Integer.valueOf(i2));
            if ((chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden)) {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                tLRPC$TL_peerChannel.channel_id = i2;
                return tLRPC$TL_peerChannel;
            }
            TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
            tLRPC$TL_peerChat.chat_id = i2;
            return tLRPC$TL_peerChat;
        }
        getUser(Integer.valueOf(i));
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_peerUser.user_id = i;
        return tLRPC$TL_peerUser;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        MessageObject messageObject;
        if (i == NotificationCenter.FileDidUpload) {
            String str = (String) objArr[0];
            TLRPC$InputFile tLRPC$InputFile = (TLRPC$InputFile) objArr[1];
            String str2 = this.uploadingAvatar;
            if (str2 == null || !str2.equals(str)) {
                return;
            }
            TLRPC$TL_photos_uploadProfilePhoto tLRPC$TL_photos_uploadProfilePhoto = new TLRPC$TL_photos_uploadProfilePhoto();
            tLRPC$TL_photos_uploadProfilePhoto.file = tLRPC$InputFile;
            tLRPC$TL_photos_uploadProfilePhoto.flags |= 1;
            getConnectionsManager().sendRequest(tLRPC$TL_photos_uploadProfilePhoto, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda207
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didReceivedNotification$17(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (i == NotificationCenter.FileDidFailUpload) {
            String str3 = (String) objArr[0];
            String str4 = this.uploadingAvatar;
            if (str4 != null && str4.equals(str3)) {
                this.uploadingAvatar = null;
                return;
            }
            String str5 = this.uploadingWallpaper;
            if (str5 != null && str5.equals(str3)) {
                this.uploadingWallpaper = null;
                this.uploadingWallpaperInfo = null;
                return;
            }
            Object objRemove = this.uploadingThemes.remove(str3);
            if (objRemove instanceof Theme.ThemeInfo) {
                Theme.ThemeInfo themeInfo = (Theme.ThemeInfo) objRemove;
                themeInfo.uploadedFile = null;
                themeInfo.uploadedThumb = null;
                getNotificationCenter().postNotificationName(NotificationCenter.themeUploadError, themeInfo, null);
                return;
            }
            if (objRemove instanceof Theme.ThemeAccent) {
                Theme.ThemeAccent themeAccent = (Theme.ThemeAccent) objRemove;
                themeAccent.uploadingThumb = null;
                getNotificationCenter().postNotificationName(NotificationCenter.themeUploadError, themeAccent.parentTheme, themeAccent);
                return;
            }
            return;
        }
        if (i == NotificationCenter.messageReceivedByServer) {
            if (((Boolean) objArr[6]).booleanValue()) {
                return;
            }
            Long l = (Long) objArr[0];
            Long l2 = (Long) objArr[1];
            Long l3 = (Long) objArr[3];
            MessageObject messageObject2 = this.dialogMessage.get(l3.longValue());
            if (messageObject2 != null && (messageObject2.getId() == l.longValue() || messageObject2.messageOwner.local_id == l.longValue())) {
                messageObject2.messageOwner.id = l2.longValue();
                messageObject2.messageOwner.send_state = 0;
            }
            TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(l3.longValue());
            if (tLRPC$Dialog != null && tLRPC$Dialog.top_message == l.longValue()) {
                tLRPC$Dialog.top_message = l2.longValue();
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            }
            MessageObject messageObject3 = this.dialogMessagesByIds.get(l.longValue());
            if (messageObject3 != null) {
                this.dialogMessagesByIds.remove(l.longValue());
                this.dialogMessagesByIds.put(l2.longValue(), messageObject3);
            }
            int iLongValue = (int) l3.longValue();
            if (iLongValue < 0) {
                int i3 = -iLongValue;
                TLRPC$ChatFull tLRPC$ChatFull = this.fullChats.get(i3);
                TLRPC$Chat chat = getChat(Integer.valueOf(i3));
                if (chat == null || ChatObject.hasAdminRights(chat) || tLRPC$ChatFull == null || tLRPC$ChatFull.slowmode_seconds == 0) {
                    return;
                }
                tLRPC$ChatFull.slowmode_next_send_date = getConnectionsManager().getCurrentTime() + tLRPC$ChatFull.slowmode_seconds;
                tLRPC$ChatFull.flags |= UPDATE_MASK_CHAT_MUTE;
                getMessagesStorage().updateChatInfo(tLRPC$ChatFull, false);
                return;
            }
            return;
        }
        if (i == NotificationCenter.updateMessageMedia) {
            TLRPC$Message tLRPC$Message = (TLRPC$Message) objArr[0];
            if (tLRPC$Message.peer_id.channel_id != 0 || (messageObject = this.dialogMessagesByIds.get(tLRPC$Message.id)) == null) {
                return;
            }
            messageObject.messageOwner.media = tLRPC$Message.media;
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (tLRPC$MessageMedia.ttl_seconds != 0) {
                if ((tLRPC$MessageMedia.photo instanceof TLRPC$TL_photoEmpty) || (tLRPC$MessageMedia.document instanceof TLRPC$TL_documentEmpty)) {
                    messageObject.setType();
                    getNotificationCenter().postNotificationName(NotificationCenter.notificationsSettingsUpdated, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$17(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$User user = getUser(Integer.valueOf(getUserConfig().getClientUserId()));
            if (user == null) {
                user = getUserConfig().getCurrentUser();
                putUser(user, true);
            } else {
                getUserConfig().setCurrentUser(user);
            }
            if (user == null) {
                return;
            }
            TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
            ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$TL_photos_photo.photo.sizes;
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(arrayList, 100);
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(arrayList, CloseCodes.NORMAL_CLOSURE);
            TLRPC$TL_userProfilePhoto tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto();
            user.photo = tLRPC$TL_userProfilePhoto;
            tLRPC$TL_userProfilePhoto.photo_id = tLRPC$TL_photos_photo.photo.id;
            if (closestPhotoSizeWithSize != null) {
                tLRPC$TL_userProfilePhoto.photo_small = closestPhotoSizeWithSize.location;
            }
            if (closestPhotoSizeWithSize2 != null) {
                tLRPC$TL_userProfilePhoto.photo_big = closestPhotoSizeWithSize2.location;
            }
            getMessagesStorage().clearUserPhotos(user.id);
            ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
            arrayList2.add(user);
            getMessagesStorage().putUsersAndChats(arrayList2, null, false, true);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didReceivedNotification$16();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$16() {
        getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 2);
        getUserConfig().saveConfig(true);
    }

    private void addWallpaper() {
        if (this.uploadingWallpaperObject == null) {
            return;
        }
        TLRPC$TL_account_uploadWallPaper tLRPC$TL_account_uploadWallPaper = new TLRPC$TL_account_uploadWallPaper();
        UploadingFileWallpaper uploadingFileWallpaper = this.uploadingWallpaperObject;
        tLRPC$TL_account_uploadWallPaper.file = uploadingFileWallpaper.main;
        tLRPC$TL_account_uploadWallPaper.thumb = uploadingFileWallpaper.thumb;
        tLRPC$TL_account_uploadWallPaper.mime_type = "image/jpeg";
        final Theme.OverrideWallpaperInfo overrideWallpaperInfo = this.uploadingWallpaperInfo;
        final TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings = new TLRPC$TL_wallPaperSettings();
        tLRPC$TL_wallPaperSettings.blur = overrideWallpaperInfo.isBlurred;
        tLRPC$TL_wallPaperSettings.motion = overrideWallpaperInfo.isMotion;
        tLRPC$TL_account_uploadWallPaper.settings = tLRPC$TL_wallPaperSettings;
        AccountInstance.getInstance(this.currentAccount).getContactsProxy().addWallpaper(tLRPC$TL_account_uploadWallPaper, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda257
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$addWallpaper$19(overrideWallpaperInfo, tLRPC$TL_wallPaperSettings, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addWallpaper$19(final Theme.OverrideWallpaperInfo overrideWallpaperInfo, final TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) tLObject;
        final File file = new File(ApplicationLoader.getFilesDirFixed(), overrideWallpaperInfo.originalFileName);
        if (tLRPC$TL_wallPaper != null) {
            try {
                AndroidUtilities.copyFile(file, FileLoader.getPathToAttach(tLRPC$TL_wallPaper.document, true));
            } catch (Exception unused) {
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda148
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addWallpaper$18(tLRPC$TL_wallPaper, tLRPC$TL_wallPaperSettings, overrideWallpaperInfo, file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addWallpaper$18(TLRPC$TL_wallPaper tLRPC$TL_wallPaper, TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings, Theme.OverrideWallpaperInfo overrideWallpaperInfo, File file) {
        if (this.uploadingWallpaper == null || tLRPC$TL_wallPaper == null) {
            return;
        }
        tLRPC$TL_wallPaper.settings = tLRPC$TL_wallPaperSettings;
        tLRPC$TL_wallPaper.flags |= 4;
        overrideWallpaperInfo.slug = tLRPC$TL_wallPaper.slug;
        overrideWallpaperInfo.saveOverrideWallpaper();
        ArrayList<TLRPC$WallPaper> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$TL_wallPaper);
        getMessagesStorage().putWallpapers(arrayList, 2);
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_wallPaper.document.thumbs, 320);
        if (closestPhotoSizeWithSize != null) {
            ImageLoader.getInstance().replaceImageInCache(Utilities.MD5(file.getAbsolutePath()) + "@100_100", closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@100_100", ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$TL_wallPaper.document), false);
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.wallpapersNeedReload, tLRPC$TL_wallPaper.slug);
    }

    public void cleanup() {
        getContactsController().cleanup();
        MediaController.getInstance().cleanup();
        MediaController.getInstance().cleanupSSH();
        getNotificationsController().cleanup();
        getSendMessagesHelper().cleanup();
        getSecretChatHelper().cleanup();
        getLocationController().cleanup();
        getMediaDataController().cleanup();
        this.showFiltersTooltip = false;
        DialogsActivity.dialogsLoaded[this.currentAccount] = false;
        this.notificationsPreferences.edit().clear().apply();
        this.emojiPreferences.edit().putLong("lastGifLoadTime", 0L).putLong("lastStickersLoadTime", 0L).putLong("lastStickersLoadTimeMask", 0L).putLong("lastStickersLoadTimeFavs", 0L).apply();
        this.mainPreferences.edit().remove("archivehint").remove("proximityhint").remove("archivehint_l").remove("gifhint").remove("reminderhint").remove("soundHint").remove("dcDomainName2").remove("webFileDatacenterId").remove("themehint").remove("showFiltersTooltip").apply();
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("shortcut_widget", 0);
        SharedPreferences.Editor editorEdit = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        AppWidgetManager appWidgetManager = null;
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("account") && ((Integer) entry.getValue()).intValue() == this.currentAccount) {
                int iIntValue = Utilities.parseInt(key).intValue();
                if (editorEdit == null) {
                    editorEdit = sharedPreferences.edit();
                    appWidgetManager = AppWidgetManager.getInstance(ApplicationLoader.applicationContext);
                }
                editorEdit.putBoolean("deleted" + iIntValue, true);
                if (sharedPreferences.getInt("type" + iIntValue, 0) == 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(Integer.valueOf(iIntValue));
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(Integer.valueOf(iIntValue));
                }
            }
        }
        if (editorEdit != null) {
            editorEdit.apply();
        }
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ChatsWidgetProvider.updateWidget(ApplicationLoader.applicationContext, appWidgetManager, ((Integer) arrayList.get(i)).intValue(), true);
            }
        }
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ContactsWidgetProvider.updateWidget(ApplicationLoader.applicationContext, appWidgetManager, ((Integer) arrayList2.get(i2)).intValue(), true);
            }
        }
        this.lastScheduledServerQueryTime.clear();
        this.lastServerQueryTime.clear();
        this.reloadingWebpages.clear();
        this.reloadingWebpagesPending.clear();
        this.reloadingScheduledWebpages.clear();
        this.reloadingScheduledWebpagesPending.clear();
        FirebaseEventSender.setKey("dialogs_dict_clear1", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
        this.dialogs_dict.clear();
        this.dialogs_read_inbox_max.clear();
        this.loadingPinnedDialogs.clear();
        this.dialogs_read_outbox_max.clear();
        this.exportedChats.clear();
        this.fullUsers.clear();
        this.fullChats.clear();
        this.loadingGroupCalls.clear();
        this.groupCallsByChatId.clear();
        this.dialogsByFolder.clear();
        this.unreadUnmutedDialogs = 0;
        this.joiningToChannels.clear();
        this.migratedChats.clear();
        this.channelViewsToSend.clear();
        this.pollsToCheck.clear();
        this.pollsToCheckSize = 0;
        this.dialogsServerOnly.clear();
        this.dialogsForward.clear();
        this.allDialogs.clear();
        this.dialogsLoadedTillDate = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.dialogsCanAddUsers.clear();
        this.dialogsChannelsOnly.clear();
        this.dialogsGroupsOnly.clear();
        this.dialogsUsersOnly.clear();
        this.dialogsForBlock.clear();
        this.dialogMessagesByIds.clear();
        this.dialogMessagesByRandomIds.clear();
        this.channelAdmins.clear();
        this.loadingChannelAdmins.clear();
        this.users.clear();
        this.objectsByUsernames.clear();
        this.chats.clear();
        this.dialogMessage.clear();
        this.deletedHistory.clear();
        this.printingUsers.clear();
        this.printingStrings.clear();
        this.printingStringsTypes.clear();
        this.onlinePrivacy.clear();
        this.loadingPeerSettings.clear();
        this.deletingDialogs.clear();
        this.clearingHistoryDialogs.clear();
        this.lastPrintingStringCount = 0;
        DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
        dialogFilterArr[1] = null;
        dialogFilterArr[0] = null;
        this.dialogFilters.clear();
        this.dialogFiltersById.clear();
        this.loadingSuggestedFilters = false;
        this.loadingRemoteFilters = false;
        this.suggestedFilters.clear();
        this.gettingAppChangelog = false;
        this.dialogFiltersLoaded = false;
        this.ignoreSetOnline = false;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$20();
            }
        });
        this.createdDialogMainThreadIds.clear();
        this.visibleDialogMainThreadIds.clear();
        this.visibleScheduledDialogMainThreadIds.clear();
        this.blockePeers.clear();
        int i3 = 0;
        while (true) {
            LongSparseArray<LongSparseArray<Boolean>>[] longSparseArrayArr = this.sendingTypings;
            if (i3 >= longSparseArrayArr.length) {
                break;
            }
            if (longSparseArrayArr[i3] != null) {
                longSparseArrayArr[i3].clear();
            }
            i3++;
        }
        this.loadingFullUsers.clear();
        this.loadedFullUsers.clear();
        this.reloadingMessages.clear();
        this.loadingFullChats.clear();
        this.loadingFullParticipants.clear();
        this.loadedFullParticipants.clear();
        this.loadedFullChats.clear();
        this.dialogsLoaded = false;
        this.nextDialogsCacheOffset.clear();
        this.loadingDialogs.clear();
        this.dialogsEndReached.clear();
        this.serverDialogsEndReached.clear();
        this.loadingAppConfig = false;
        this.checkingTosUpdate = false;
        this.nextTosCheckTime = 0;
        this.nextPromoInfoCheckTime = 0;
        this.checkingPromoInfo = false;
        this.loadingUnreadDialogs = false;
        this.currentDeletingTaskTime = 0;
        this.currentDeletingTaskMids = null;
        this.currentDeletingTaskMedia = false;
        this.currentDeletingTaskChannelId = 0;
        this.gettingNewDeleteTask = false;
        this.loadingBlockedPeers = false;
        this.totalBlockedCount = -1;
        this.blockedEndReached = false;
        this.firstGettingTask = false;
        this.updatingState = false;
        this.resetingDialogs = false;
        this.lastStatusUpdateTime = 0L;
        this.offlineSent = false;
        this.registeringForPush = false;
        this.getDifferenceFirstSync = true;
        this.uploadingAvatar = null;
        this.uploadingWallpaper = null;
        this.uploadingWallpaperInfo = null;
        this.uploadingThemes.clear();
        this.gettingChatInviters.clear();
        this.statusRequest = 0;
        this.statusSettingState = 0;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$21();
            }
        });
        if (this.currentDeleteTaskRunnable != null) {
            Utilities.stageQueue.cancelRunnable(this.currentDeleteTaskRunnable);
            this.currentDeleteTaskRunnable = null;
        }
        addSupportUser();
        getNotificationCenter().postNotificationName(NotificationCenter.suggestedFiltersLoaded, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogFiltersUpdated, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanup$20() {
        this.readTasks.clear();
        this.readTasksMap.clear();
        this.repliesReadTasks.clear();
        this.threadsReadTasksMap.clear();
        this.updatesQueueSeq.clear();
        this.updatesQueuePts.clear();
        this.updatesQueueQts.clear();
        this.gettingUnknownChannels.clear();
        this.gettingUnknownDialogs.clear();
        this.updatesStartWaitTimeSeq = 0L;
        this.updatesStartWaitTimePts = 0L;
        this.updatesStartWaitTimeQts = 0L;
        this.createdDialogIds.clear();
        this.createdScheduledDialogIds.clear();
        this.gettingDifference = false;
        this.resetDialogsPinned = null;
        this.resetDialogsAll = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanup$21() {
        getConnectionsManager().setIsUpdating(false);
        this.updatesQueueChannels.clear();
        this.updatesStartWaitTimeChannels.clear();
        this.gettingDifferenceChannels.clear();
        this.channelsPts.clear();
        this.shortPollChannels.clear();
        this.needShortPollChannels.clear();
        this.shortPollOnlines.clear();
        this.needShortPollOnlines.clear();
    }

    public boolean isChatNoForwards(TLRPC$Chat tLRPC$Chat) {
        TLRPC$Chat chat;
        if (tLRPC$Chat == null) {
            return false;
        }
        TLRPC$InputChannel tLRPC$InputChannel = tLRPC$Chat.migrated_to;
        if (tLRPC$InputChannel != null && (chat = getChat(Integer.valueOf(tLRPC$InputChannel.channel_id))) != null) {
            return chat.noforwards;
        }
        return tLRPC$Chat.noforwards;
    }

    public boolean isChatNoForwards(int i) {
        return isChatNoForwards(getChat(Integer.valueOf(i)));
    }

    public TLRPC$User getUser(Integer num) {
        return this.users.get(num);
    }

    public TLRPC$User getUser(Long l) {
        if (l != null) {
            return this.users.get(Integer.valueOf(l.intValue()));
        }
        return null;
    }

    public TLObject getUserOrChat(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return this.objectsByUsernames.get(str.toLowerCase());
    }

    public ConcurrentHashMap<Integer, TLRPC$User> getUsers() {
        return this.users;
    }

    public ConcurrentHashMap<Integer, TLRPC$Chat> getChats() {
        return this.chats;
    }

    public TLRPC$Chat getChat(Integer num) {
        if (num != null) {
            return this.chats.get(num);
        }
        return null;
    }

    public TLRPC$Chat getChat(Long l) {
        if (l != null) {
            return this.chats.get(Integer.valueOf(l.intValue()));
        }
        return null;
    }

    public TLRPC$EncryptedChat getEncryptedChat(Integer num) {
        return this.encryptedChats.get(num);
    }

    public TLRPC$EncryptedChat getEncryptedChatDB(int i, boolean z) throws InterruptedException {
        TLRPC$EncryptedChat tLRPC$EncryptedChat = this.encryptedChats.get(Integer.valueOf(i));
        if (tLRPC$EncryptedChat != null) {
            if (!z) {
                return tLRPC$EncryptedChat;
            }
            if (!(tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatWaiting) && !(tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatRequested)) {
                return tLRPC$EncryptedChat;
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ArrayList<TLObject> arrayList = new ArrayList<>();
        getMessagesStorage().getEncryptedChat(i, countDownLatch, arrayList);
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (arrayList.size() != 2) {
            return tLRPC$EncryptedChat;
        }
        TLRPC$EncryptedChat tLRPC$EncryptedChat2 = (TLRPC$EncryptedChat) arrayList.get(0);
        TLRPC$User tLRPC$User = (TLRPC$User) arrayList.get(1);
        putEncryptedChat(tLRPC$EncryptedChat2, false);
        putUser(tLRPC$User, true);
        return tLRPC$EncryptedChat2;
    }

    public boolean isDialogVisible(long j, boolean z) {
        return (z ? this.visibleScheduledDialogMainThreadIds : this.visibleDialogMainThreadIds).contains(Long.valueOf(j));
    }

    public void setLastVisibleDialogId(long j, boolean z, boolean z2) {
        ArrayList<Long> arrayList = z ? this.visibleScheduledDialogMainThreadIds : this.visibleDialogMainThreadIds;
        if (z2) {
            if (arrayList.contains(Long.valueOf(j))) {
                return;
            }
            arrayList.add(Long.valueOf(j));
            return;
        }
        arrayList.remove(Long.valueOf(j));
    }

    public void setLastCreatedDialogId(final long j, final boolean z, final boolean z2) {
        if (!z) {
            ArrayList<Long> arrayList = this.createdDialogMainThreadIds;
            if (z2) {
                if (arrayList.contains(Long.valueOf(j))) {
                    return;
                } else {
                    arrayList.add(Long.valueOf(j));
                }
            } else {
                arrayList.remove(Long.valueOf(j));
                LongSparseArray<MessageObject> longSparseArray = this.pollsToCheck.get(j);
                if (longSparseArray != null) {
                    int size = longSparseArray.size();
                    for (int i = 0; i < size; i++) {
                        longSparseArray.valueAt(i).pollVisibleOnScreen = false;
                    }
                }
            }
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda173
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setLastCreatedDialogId$22(z, z2, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setLastCreatedDialogId$22(boolean z, boolean z2, long j) {
        ArrayList<Long> arrayList = z ? this.createdScheduledDialogIds : this.createdDialogIds;
        if (z2) {
            if (arrayList.contains(Long.valueOf(j))) {
                return;
            }
            arrayList.add(Long.valueOf(j));
            return;
        }
        arrayList.remove(Long.valueOf(j));
    }

    public TLRPC$TL_chatInviteExported getExportedInvite(int i) {
        return this.exportedChats.get(i);
    }

    public boolean putUser(TLRPC$User tLRPC$User, boolean z) {
        if (tLRPC$User == null) {
            return false;
        }
        if (!z || tLRPC$User.id / CloseCodes.NORMAL_CLOSURE != 333) {
        }
        TLRPC$User tLRPC$User2 = this.users.get(Integer.valueOf(tLRPC$User.id));
        if (tLRPC$User2 == tLRPC$User) {
            return false;
        }
        if (tLRPC$User2 != null && !tLRPC$User2.bot && !tLRPC$User2.support && tLRPC$User2.userInfotimeStamp > tLRPC$User.userInfotimeStamp) {
            return false;
        }
        this.users.put(Integer.valueOf(tLRPC$User.id), tLRPC$User);
        return true;
    }

    private boolean isExactLastOnline(TLRPC$UserStatus tLRPC$UserStatus) {
        return (tLRPC$UserStatus instanceof TLRPC$TL_userStatusOffline) || (tLRPC$UserStatus instanceof TLRPC$TL_userStatusOnline) || (tLRPC$UserStatus instanceof TLRPC$TL_userStatusEmpty);
    }

    public void putUsers(ArrayList<TLRPC$User> arrayList, boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            if (putUser(arrayList.get(i), z)) {
                z2 = true;
            }
        }
        if (z2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putUsers$23();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putUsers$23() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 4);
    }

    public void putChat(TLRPC$Chat tLRPC$Chat, boolean z) {
        TLRPC$Chat tLRPC$Chat2;
        if (tLRPC$Chat == null || (tLRPC$Chat2 = this.chats.get(Integer.valueOf(tLRPC$Chat.id))) == tLRPC$Chat) {
            return;
        }
        if (tLRPC$Chat2 != null && !TextUtils.isEmpty(tLRPC$Chat2.username)) {
            this.objectsByUsernames.remove(tLRPC$Chat2.username.toLowerCase());
        }
        if (!TextUtils.isEmpty(tLRPC$Chat.username)) {
            this.objectsByUsernames.put(tLRPC$Chat.username.toLowerCase(), tLRPC$Chat);
        }
        this.chats.put(Integer.valueOf(tLRPC$Chat.id), tLRPC$Chat);
    }

    public void putChats(ArrayList<TLRPC$Chat> arrayList, boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            putChat(arrayList.get(i), z);
        }
    }

    public void setReferer(String str) {
        if (str == null) {
            return;
        }
        this.installReferer = str;
        this.mainPreferences.edit().putString("installReferer", str).apply();
    }

    public void putEncryptedChat(TLRPC$EncryptedChat tLRPC$EncryptedChat, boolean z) {
        if (tLRPC$EncryptedChat == null) {
            return;
        }
        if (z) {
            this.encryptedChats.putIfAbsent(Integer.valueOf(tLRPC$EncryptedChat.id), tLRPC$EncryptedChat);
        } else {
            this.encryptedChats.put(Integer.valueOf(tLRPC$EncryptedChat.id), tLRPC$EncryptedChat);
        }
    }

    public void putEncryptedChats(ArrayList<TLRPC$EncryptedChat> arrayList, boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            putEncryptedChat(arrayList.get(i), z);
        }
    }

    public TLRPC$UserFull getUserFull(int i) {
        return this.fullUsers.get(i);
    }

    public TLRPC$ChatFull getChatFull(int i) {
        return this.fullChats.get(i);
    }

    public void putGroupCall(int i, ChatObject.Call call) {
        this.groupCalls.put(call.call.id, call);
        this.groupCallsByChatId.put(i, call);
        TLRPC$ChatFull chatFull = getChatFull(i);
        if (chatFull != null) {
            chatFull.call = call.getInputGroupCall();
        }
        getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(i), call.call.id, Boolean.FALSE);
        loadFullChat(i, 0, true);
    }

    public ChatObject.Call getGroupCall(int i, boolean z) {
        return getGroupCall(i, z, null);
    }

    public ChatObject.Call getGroupCall(final int i, boolean z, final Runnable runnable) {
        TLRPC$TL_inputGroupCall tLRPC$TL_inputGroupCall;
        TLRPC$ChatFull chatFull = getChatFull(i);
        if (chatFull == null || (tLRPC$TL_inputGroupCall = chatFull.call) == null) {
            return null;
        }
        ChatObject.Call call = this.groupCalls.get(tLRPC$TL_inputGroupCall.id);
        if (call == null && z && !this.loadingGroupCalls.contains(Integer.valueOf(i))) {
            this.loadingGroupCalls.add(Integer.valueOf(i));
            if (chatFull.call != null) {
                TLRPC$TL_phone_getGroupCall tLRPC$TL_phone_getGroupCall = new TLRPC$TL_phone_getGroupCall();
                tLRPC$TL_phone_getGroupCall.call = chatFull.call;
                getCallProxy().getGroupCall(tLRPC$TL_phone_getGroupCall, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda220
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$getGroupCall$25(i, runnable, tLObject, tLRPC$TL_error);
                    }
                });
            }
        }
        if (call == null || !(call.call instanceof TLRPC$TL_groupCallDiscarded)) {
            return call;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getGroupCall$25(final int i, final Runnable runnable, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda122
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getGroupCall$24(tLObject, i, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getGroupCall$24(TLObject tLObject, int i, Runnable runnable) {
        if (tLObject != null) {
            TLRPC$TL_phone_groupCall tLRPC$TL_phone_groupCall = (TLRPC$TL_phone_groupCall) tLObject;
            putUsers(tLRPC$TL_phone_groupCall.users, false);
            putChats(tLRPC$TL_phone_groupCall.chats, false);
            ChatObject.Call groupCall = getGroupCall(i, false);
            if (groupCall == null) {
                groupCall = new ChatObject.Call();
            }
            groupCall.setCall(getAccountInstance(), i, tLRPC$TL_phone_groupCall);
            this.groupCalls.put(tLRPC$TL_phone_groupCall.call.id, groupCall);
            this.groupCallsByChatId.put(i, groupCall);
            getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(i), tLRPC$TL_phone_groupCall.call.id, Boolean.FALSE);
            if (runnable != null) {
                runnable.run();
            }
        }
        this.loadingGroupCalls.remove(Integer.valueOf(i));
    }

    public void cancelLoadFullUser(int i) {
        this.loadingFullUsers.remove(Integer.valueOf(i));
    }

    public void cancelLoadFullChat(int i) {
        this.loadingFullChats.remove(Integer.valueOf(i));
    }

    protected void clearFullUsers() {
        this.loadedFullUsers.clear();
        this.loadedFullChats.clear();
    }

    private void reloadDialogsReadValue(ArrayList<TLRPC$Dialog> arrayList, long j) {
        if (j == 0 && (arrayList == null || arrayList.isEmpty())) {
            return;
        }
        TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs = new TLRPC$TL_messages_getPeerDialogs();
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$InputPeer inputPeer = getInputPeer((int) arrayList.get(i).id);
                if (!(inputPeer instanceof TLRPC$TL_inputPeerChannel) || inputPeer.access_hash != 0) {
                    TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
                    tLRPC$TL_inputDialogPeer.peer = inputPeer;
                    tLRPC$TL_messages_getPeerDialogs.peers.add(tLRPC$TL_inputDialogPeer);
                }
            }
        } else {
            TLRPC$InputPeer inputPeer2 = getInputPeer((int) j);
            if ((inputPeer2 instanceof TLRPC$TL_inputPeerChannel) && inputPeer2.access_hash == 0) {
                return;
            }
            TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer2 = new TLRPC$TL_inputDialogPeer();
            tLRPC$TL_inputDialogPeer2.peer = inputPeer2;
            tLRPC$TL_messages_getPeerDialogs.peers.add(tLRPC$TL_inputDialogPeer2);
        }
        if (tLRPC$TL_messages_getPeerDialogs.peers.isEmpty()) {
            return;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerDialogs, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda203
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
                this.f$0.lambda$reloadDialogsReadValue$26(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadDialogsReadValue$26(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
        if (tLObject != null) {
            TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = (TLRPC$TL_messages_peerDialogs) tLObject;
            ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
            for (int i = 0; i < tLRPC$TL_messages_peerDialogs.dialogs.size(); i++) {
                TLRPC$Dialog tLRPC$Dialog = tLRPC$TL_messages_peerDialogs.dialogs.get(i);
                DialogObject.initDialog(tLRPC$Dialog);
                Long l = this.dialogs_read_inbox_max.get(Long.valueOf(tLRPC$Dialog.id));
                if (l == null) {
                    l = 0L;
                }
                this.dialogs_read_inbox_max.put(Long.valueOf(tLRPC$Dialog.id), Long.valueOf(Math.max(tLRPC$Dialog.read_inbox_max_id, l.longValue())));
                if (l.longValue() == 0) {
                    if (tLRPC$Dialog.peer.channel_id != 0) {
                        TLRPC$TL_updateReadChannelInbox tLRPC$TL_updateReadChannelInbox = new TLRPC$TL_updateReadChannelInbox();
                        tLRPC$TL_updateReadChannelInbox.channel_id = tLRPC$Dialog.peer.channel_id;
                        tLRPC$TL_updateReadChannelInbox.max_id = tLRPC$Dialog.read_inbox_max_id;
                        arrayList.add(tLRPC$TL_updateReadChannelInbox);
                    } else {
                        TLRPC$TL_updateReadHistoryInbox tLRPC$TL_updateReadHistoryInbox = new TLRPC$TL_updateReadHistoryInbox();
                        tLRPC$TL_updateReadHistoryInbox.peer = tLRPC$Dialog.peer;
                        tLRPC$TL_updateReadHistoryInbox.max_id = tLRPC$Dialog.read_inbox_max_id;
                        arrayList.add(tLRPC$TL_updateReadHistoryInbox);
                    }
                }
                Long l2 = this.dialogs_read_outbox_max.get(Long.valueOf(tLRPC$Dialog.id));
                if (l2 == null) {
                    l2 = 0L;
                }
                this.dialogs_read_outbox_max.put(Long.valueOf(tLRPC$Dialog.id), Long.valueOf(Math.max(tLRPC$Dialog.read_outbox_max_id, l2.longValue())));
                if (tLRPC$Dialog.read_outbox_max_id > l2.longValue()) {
                    if (tLRPC$Dialog.peer.channel_id != 0) {
                        TLRPC$TL_updateReadChannelOutbox tLRPC$TL_updateReadChannelOutbox = new TLRPC$TL_updateReadChannelOutbox();
                        tLRPC$TL_updateReadChannelOutbox.channel_id = tLRPC$Dialog.peer.channel_id;
                        tLRPC$TL_updateReadChannelOutbox.max_id = tLRPC$Dialog.read_outbox_max_id;
                        arrayList.add(tLRPC$TL_updateReadChannelOutbox);
                    } else {
                        TLRPC$TL_updateReadHistoryOutbox tLRPC$TL_updateReadHistoryOutbox = new TLRPC$TL_updateReadHistoryOutbox();
                        tLRPC$TL_updateReadHistoryOutbox.peer = tLRPC$Dialog.peer;
                        tLRPC$TL_updateReadHistoryOutbox.max_id = tLRPC$Dialog.read_outbox_max_id;
                        arrayList.add(tLRPC$TL_updateReadHistoryOutbox);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            processUpdateArray(arrayList, null, null, false, 0);
        }
    }

    public TLRPC$ChannelParticipant getAdminInChannel(int i, int i2) {
        SparseArray<TLRPC$ChannelParticipant> sparseArray = this.channelAdmins.get(i2);
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    public String getAdminRank(int i, int i2) {
        SparseArray<TLRPC$ChannelParticipant> sparseArray = this.channelAdmins.get(i);
        if (sparseArray == null || sparseArray.get(i2) == null) {
            return null;
        }
        String str = sparseArray.get(i2).rank;
        return str != null ? str : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
    }

    public boolean isChannelAdminsLoaded(int i) {
        return this.channelAdmins.get(i) != null;
    }

    public void loadChannelAdmins(final int i, boolean z) {
        if (SystemClock.elapsedRealtime() - this.loadingChannelAdmins.get(i) < 60) {
            return;
        }
        this.loadingChannelAdmins.put(i, (int) (SystemClock.elapsedRealtime() / 1000));
        if (z) {
            getMessagesStorage().loadChannelAdmins(i);
            return;
        }
        TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
        tLRPC$TL_channels_getParticipants.channel = getInputChannel(i);
        tLRPC$TL_channels_getParticipants.limit = 100;
        tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsAdmins();
        getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda211
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadChannelAdmins$27(i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChannelAdmins$27(int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_channels_channelParticipants) {
            processLoadedAdminsResponse(i, (TLRPC$TL_channels_channelParticipants) tLObject);
        }
    }

    public void processLoadedAdminsResponse(int i, TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants) {
        SparseArray<TLRPC$ChannelParticipant> sparseArray = new SparseArray<>(tLRPC$TL_channels_channelParticipants.participants.size());
        for (int i2 = 0; i2 < tLRPC$TL_channels_channelParticipants.participants.size(); i2++) {
            TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_channels_channelParticipants.participants.get(i2);
            sparseArray.put(MessageObject.getPeerId(tLRPC$ChannelParticipant.peer), tLRPC$ChannelParticipant);
        }
        processLoadedChannelAdmins(sparseArray, i, false);
    }

    public void processLoadedChannelAdmins(final SparseArray<TLRPC$ChannelParticipant> sparseArray, final int i, final boolean z) {
        if (!z) {
            getMessagesStorage().putChannelAdmins(i, sparseArray);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda51
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedChannelAdmins$28(i, sparseArray, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedChannelAdmins$28(int i, SparseArray sparseArray, boolean z) {
        this.channelAdmins.put(i, sparseArray);
        if (z) {
            this.loadingChannelAdmins.delete(i);
            loadChannelAdmins(i, false);
            getNotificationCenter().postNotificationName(NotificationCenter.didLoadChatAdmins, Integer.valueOf(i));
        }
    }

    public void loadFullChat(int i, int i2, boolean z) {
        boolean zContains = this.loadedFullChats.contains(Integer.valueOf(i));
        if (!this.loadingFullChats.contains(Integer.valueOf(i)) && (z || !zContains)) {
            this.loadingFullChats.add(Integer.valueOf(i));
            getDialogsProxy().loadFullChat(getChat(Integer.valueOf(i)), i2, z);
        } else if (zContains) {
            long j = -i;
            getDialogsProxy().proxyObjectInfo(IdStorage.getInstance().getDialogId(j), getDialogsProxy().getChatType(j));
        }
    }

    public void processFullChat(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error, final int i, long j) throws InterruptedException {
        if (j == 0) {
            return;
        }
        final int i2 = (int) (-j);
        TLRPC$Chat chat = getChat(Integer.valueOf(i2));
        if (tLRPC$TL_error == null) {
            final TLRPC$TL_messages_chatFull tLRPC$TL_messages_chatFull = (TLRPC$TL_messages_chatFull) tLObject;
            if (ChatObject.isChannel(chat)) {
                Long lValueOf = this.dialogs_read_inbox_max.get(Long.valueOf(j));
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(getMessagesStorage().getDialogReadMax(false, j));
                }
                this.dialogs_read_inbox_max.put(Long.valueOf(j), Long.valueOf(Math.max(tLRPC$TL_messages_chatFull.full_chat.read_inbox_max_id, lValueOf.longValue())));
                if (tLRPC$TL_messages_chatFull.full_chat.read_inbox_max_id > lValueOf.longValue()) {
                    ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
                    TLRPC$TL_updateReadChannelInbox tLRPC$TL_updateReadChannelInbox = new TLRPC$TL_updateReadChannelInbox();
                    tLRPC$TL_updateReadChannelInbox.channel_id = i2;
                    tLRPC$TL_updateReadChannelInbox.max_id = tLRPC$TL_messages_chatFull.full_chat.read_inbox_max_id;
                    arrayList.add(tLRPC$TL_updateReadChannelInbox);
                    processUpdateArray(arrayList, null, null, false, 0);
                }
                Long lValueOf2 = this.dialogs_read_outbox_max.get(Long.valueOf(j));
                if (lValueOf2 == null) {
                    lValueOf2 = Long.valueOf(getMessagesStorage().getDialogReadMax(true, j));
                }
                this.dialogs_read_outbox_max.put(Long.valueOf(j), Long.valueOf(Math.max(tLRPC$TL_messages_chatFull.full_chat.read_outbox_max_id, lValueOf2.longValue())));
                if (tLRPC$TL_messages_chatFull.full_chat.read_outbox_max_id > lValueOf2.longValue()) {
                    ArrayList<TLRPC$Update> arrayList2 = new ArrayList<>();
                    TLRPC$TL_updateReadChannelOutbox tLRPC$TL_updateReadChannelOutbox = new TLRPC$TL_updateReadChannelOutbox();
                    tLRPC$TL_updateReadChannelOutbox.channel_id = i2;
                    tLRPC$TL_updateReadChannelOutbox.max_id = tLRPC$TL_messages_chatFull.full_chat.read_outbox_max_id;
                    arrayList2.add(tLRPC$TL_updateReadChannelOutbox);
                    processUpdateArray(arrayList2, null, null, false, 0);
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda59
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processFullChat$29(i2, tLRPC$TL_messages_chatFull, i);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda132
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processFullChat$30(tLRPC$TL_error, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processFullChat$29(int i, TLRPC$TL_messages_chatFull tLRPC$TL_messages_chatFull, int i2) {
        TLRPC$Dialog tLRPC$Dialog;
        TLRPC$ChatFull tLRPC$ChatFull = this.fullChats.get(i);
        if (tLRPC$ChatFull != null) {
            tLRPC$TL_messages_chatFull.full_chat.inviterId = tLRPC$ChatFull.inviterId;
        }
        this.fullChats.put(i, tLRPC$TL_messages_chatFull.full_chat);
        int i3 = -i;
        long j = i3;
        applyDialogNotificationsSettings(j, tLRPC$TL_messages_chatFull.full_chat.notify_settings);
        for (int i4 = 0; i4 < tLRPC$TL_messages_chatFull.full_chat.bot_info.size(); i4++) {
            getMediaDataController().putBotInfo(tLRPC$TL_messages_chatFull.full_chat.bot_info.get(i4));
        }
        int iIndexOfKey = this.blockePeers.indexOfKey(i3);
        if (tLRPC$TL_messages_chatFull.full_chat.blocked) {
            if (iIndexOfKey < 0) {
                this.blockePeers.put(i3, 1);
                getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
            }
        } else if (iIndexOfKey >= 0) {
            this.blockePeers.removeAt(iIndexOfKey);
            getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        }
        this.exportedChats.put(i, tLRPC$TL_messages_chatFull.full_chat.exported_invite);
        this.loadingFullChats.remove(Integer.valueOf(i));
        this.loadedFullChats.add(Integer.valueOf(i));
        putUsers(tLRPC$TL_messages_chatFull.users, false);
        putChats(tLRPC$TL_messages_chatFull.chats, false);
        if (tLRPC$TL_messages_chatFull.full_chat.stickerset != null) {
            getMediaDataController().getGroupStickerSetById(tLRPC$TL_messages_chatFull.full_chat.stickerset);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.chatInfoDidLoad, tLRPC$TL_messages_chatFull.full_chat, Integer.valueOf(i2), Boolean.FALSE, Boolean.TRUE);
        if ((tLRPC$TL_messages_chatFull.full_chat.flags & 2048) == 0 || (tLRPC$Dialog = this.dialogs_dict.get(j)) == null) {
            return;
        }
        int i5 = tLRPC$Dialog.folder_id;
        int i6 = tLRPC$TL_messages_chatFull.full_chat.folder_id;
        if (i5 != i6) {
            tLRPC$Dialog.folder_id = i6;
            sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processFullChat$30(TLRPC$TL_error tLRPC$TL_error, int i) {
        checkChannelError(tLRPC$TL_error.text, i);
        this.loadingFullChats.remove(Integer.valueOf(i));
    }

    public void loadFullUser(final TLRPC$User tLRPC$User, final int i, final boolean z) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda151
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFullUser$31(tLRPC$User, z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFullUser$31(TLRPC$User tLRPC$User, boolean z, int i) {
        if (tLRPC$User == null || this.loadingFullUsers.contains(Integer.valueOf(tLRPC$User.id)) || (!z && this.loadedFullUsers.contains(Integer.valueOf(tLRPC$User.id)))) {
            if (tLRPC$User == null || !this.loadedFullUsers.contains(Integer.valueOf(tLRPC$User.id))) {
                return;
            }
            getDialogsProxy().proxyObjectInfo(IdStorage.getInstance().getDialogId(tLRPC$User.id), getDialogsProxy().getChatType(tLRPC$User.id));
            return;
        }
        this.loadingFullUsers.add(Integer.valueOf(tLRPC$User.id));
        putUser(tLRPC$User, true);
        getDialogsProxy().loadFullUser(tLRPC$User, i, z);
    }

    public void processFullUser(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, final int i, long j) {
        if (j == 0) {
            return;
        }
        final int i2 = (int) j;
        final TLRPC$User user = getUser(Integer.valueOf(i2));
        if (tLRPC$TL_error == null && user != null) {
            final TLRPC$UserFull tLRPC$UserFull = (TLRPC$UserFull) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda152
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processFullUser$32(tLRPC$UserFull, user, i);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processFullUser$33(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processFullUser$32(TLRPC$UserFull tLRPC$UserFull, TLRPC$User tLRPC$User, int i) {
        TLRPC$Dialog tLRPC$Dialog;
        savePeerSettings(tLRPC$UserFull.user.id, tLRPC$UserFull.settings, false);
        applyDialogNotificationsSettings(tLRPC$User.id, tLRPC$UserFull.notify_settings);
        if (tLRPC$UserFull.bot_info instanceof TLRPC$TL_botInfo) {
            getMediaDataController().putBotInfo(tLRPC$UserFull.bot_info);
        }
        int iIndexOfKey = this.blockePeers.indexOfKey(tLRPC$User.id);
        if (tLRPC$UserFull.blocked) {
            if (iIndexOfKey < 0) {
                this.blockePeers.put(tLRPC$User.id, 1);
                getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
            }
        } else if (iIndexOfKey >= 0) {
            this.blockePeers.removeAt(iIndexOfKey);
            getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        }
        this.fullUsers.put(tLRPC$User.id, tLRPC$UserFull);
        this.loadingFullUsers.remove(Integer.valueOf(tLRPC$User.id));
        this.loadedFullUsers.add(Integer.valueOf(tLRPC$User.id));
        String str = tLRPC$User.first_name + tLRPC$User.last_name + tLRPC$User.username;
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$UserFull.user);
        putUsers(arrayList, false);
        if (!str.equals(tLRPC$UserFull.user.first_name + tLRPC$UserFull.user.last_name + tLRPC$UserFull.user.username)) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 1);
        }
        if (tLRPC$UserFull.bot_info instanceof TLRPC$TL_botInfo) {
            getNotificationCenter().postNotificationName(NotificationCenter.botInfoDidLoad, tLRPC$UserFull.bot_info, Integer.valueOf(i));
        }
        getNotificationCenter().postNotificationName(NotificationCenter.userInfoDidLoad, Integer.valueOf(tLRPC$User.id), tLRPC$UserFull);
        if ((tLRPC$UserFull.flags & 2048) == 0 || (tLRPC$Dialog = this.dialogs_dict.get(tLRPC$User.id)) == null) {
            return;
        }
        int i2 = tLRPC$Dialog.folder_id;
        int i3 = tLRPC$UserFull.folder_id;
        if (i2 != i3) {
            tLRPC$Dialog.folder_id = i3;
            sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processFullUser$33(int i) {
        this.loadingFullUsers.remove(Integer.valueOf(i));
    }

    public void processDialogUpdate(final TLRPC$Dialog tLRPC$Dialog, final int i) {
        if (tLRPC$Dialog != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda129
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processDialogUpdate$34(tLRPC$Dialog, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDialogUpdate$34(TLRPC$Dialog tLRPC$Dialog, int i) {
        String str;
        TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(tLRPC$Dialog.id);
        if (tLRPC$Dialog2 == null || tLRPC$Dialog2.id != tLRPC$Dialog.id) {
            return;
        }
        if (this.dialogs_dict != null) {
            str = this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        } else {
            str = "null";
        }
        FirebaseEventSender.setKey("dialogs_dictput10", str);
        this.dialogs_dict.put(tLRPC$Dialog.id, tLRPC$Dialog);
        sortDialogs(null);
        if ((262144 & i) != 0) {
            applyDialogNotificationsSettings(tLRPC$Dialog.id, tLRPC$Dialog.notify_settings);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.chatNeedReload, Long.valueOf(tLRPC$Dialog.id), Integer.valueOf(i), Long.valueOf(tLRPC$Dialog.read_outbox_max_id), Long.valueOf(tLRPC$Dialog.read_inbox_max_id), Long.valueOf(tLRPC$Dialog.top_message));
    }

    public void processNewMessages(TLRPC$messages_Messages tLRPC$messages_Messages, final long j) {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < tLRPC$messages_Messages.messages.size(); i++) {
            arrayList.add(new MessageObject(this.currentAccount, tLRPC$messages_Messages.messages.get(i), true, true));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda68
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processNewMessages$35(j, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processNewMessages$35(long j, ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.didReceiveNewMessages, Long.valueOf(j), arrayList, Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void reloadMessages(ArrayList<Long> arrayList, final long j, final boolean z) {
        TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages;
        if (arrayList.isEmpty()) {
            return;
        }
        final ArrayList<Long> arrayList2 = new ArrayList<>();
        TLRPC$Chat chatByDialog = ChatObject.getChatByDialog(j, this.currentAccount);
        if (ChatObject.isChannel(chatByDialog)) {
            TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
            tLRPC$TL_channels_getMessages.channel = getInputChannel(chatByDialog);
            tLRPC$TL_channels_getMessages.id = arrayList2;
            tLRPC$TL_messages_getMessages = tLRPC$TL_channels_getMessages;
        } else {
            TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages2 = new TLRPC$TL_messages_getMessages();
            tLRPC$TL_messages_getMessages2.id = arrayList2;
            tLRPC$TL_messages_getMessages = tLRPC$TL_messages_getMessages2;
        }
        TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages3 = tLRPC$TL_messages_getMessages;
        ArrayList<Long> arrayList3 = this.reloadingMessages.get(j);
        for (int i = 0; i < arrayList.size(); i++) {
            Long l = arrayList.get(i);
            if (arrayList3 == null || !arrayList3.contains(l)) {
                arrayList2.add(l);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        if (arrayList3 == null) {
            arrayList3 = new ArrayList<>();
            this.reloadingMessages.put(j, arrayList3);
        }
        arrayList3.addAll(arrayList2);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages3, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda238
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reloadMessages$37(j, z, arrayList2, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadMessages$37(final long j, boolean z, final ArrayList arrayList, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        long j2 = j;
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            SparseArray sparseArray = new SparseArray();
            for (int i = 0; i < tLRPC$messages_Messages.users.size(); i++) {
                TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i);
                sparseArray.put(tLRPC$User.id, tLRPC$User);
            }
            SparseArray sparseArray2 = new SparseArray();
            for (int i2 = 0; i2 < tLRPC$messages_Messages.chats.size(); i2++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$messages_Messages.chats.get(i2);
                sparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
            }
            Long lValueOf = this.dialogs_read_inbox_max.get(Long.valueOf(j));
            if (lValueOf == null) {
                lValueOf = Long.valueOf(getMessagesStorage().getDialogReadMax(false, j2));
                this.dialogs_read_inbox_max.put(Long.valueOf(j), lValueOf);
            }
            Long lValueOf2 = this.dialogs_read_outbox_max.get(Long.valueOf(j));
            if (lValueOf2 == null) {
                lValueOf2 = Long.valueOf(getMessagesStorage().getDialogReadMax(true, j2));
                this.dialogs_read_outbox_max.put(Long.valueOf(j), lValueOf2);
            }
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < tLRPC$messages_Messages.messages.size()) {
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i3);
                tLRPC$Message.dialog_id = j2;
                if (!z) {
                    tLRPC$Message.unread = (tLRPC$Message.out ? lValueOf2 : lValueOf).longValue() < tLRPC$Message.id;
                }
                Long l = lValueOf;
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new MessageObject(this.currentAccount, tLRPC$Message, (SparseArray<TLRPC$User>) sparseArray, (SparseArray<TLRPC$Chat>) sparseArray2, true, true));
                i3++;
                j2 = j;
                arrayList2 = arrayList3;
                lValueOf = l;
            }
            final ArrayList arrayList4 = arrayList2;
            ImageLoader.saveMessagesThumbs(tLRPC$messages_Messages.messages);
            getMessagesStorage().putMessages(tLRPC$messages_Messages, j, -1, 0L, false, z);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda69
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reloadMessages$36(j, arrayList, arrayList4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadMessages$36(long j, ArrayList arrayList, ArrayList arrayList2) {
        ArrayList<Long> arrayList3 = this.reloadingMessages.get(j);
        if (arrayList3 != null) {
            arrayList3.removeAll(arrayList);
            if (arrayList3.isEmpty()) {
                this.reloadingMessages.remove(j);
            }
        }
        MessageObject messageObject = this.dialogMessage.get(j);
        if (messageObject != null) {
            int i = 0;
            while (true) {
                if (i >= arrayList2.size()) {
                    break;
                }
                MessageObject messageObject2 = (MessageObject) arrayList2.get(i);
                if (messageObject.getId() == messageObject2.getId()) {
                    this.dialogMessage.put(j, messageObject2);
                    if (messageObject2.messageOwner.peer_id.channel_id == 0) {
                        MessageObject messageObject3 = this.dialogMessagesByIds.get(messageObject2.getId());
                        this.dialogMessagesByIds.remove(messageObject2.getId());
                        if (messageObject3 != null) {
                            this.dialogMessagesByIds.put(messageObject3.getId(), messageObject3);
                        }
                    }
                    getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
                } else {
                    i++;
                }
            }
        }
        getNotificationCenter().postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(j), arrayList2);
    }

    public void hidePeerSettingsBar(long j, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat) {
        if (tLRPC$User == null && tLRPC$Chat == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
        editorEdit.putInt("dialog_bar_vis3" + j, 3);
        editorEdit.remove("dialog_bar_invite" + j);
        editorEdit.apply();
        if (((int) j) != 0) {
            TLRPC$TL_messages_hidePeerSettingsBar tLRPC$TL_messages_hidePeerSettingsBar = new TLRPC$TL_messages_hidePeerSettingsBar();
            if (tLRPC$User != null) {
                tLRPC$TL_messages_hidePeerSettingsBar.peer = getInputPeer(tLRPC$User.id);
            } else {
                tLRPC$TL_messages_hidePeerSettingsBar.peer = getInputPeer(-tLRPC$Chat.id);
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_hidePeerSettingsBar, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda267
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$hidePeerSettingsBar$38(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    public void reportSpam(long j, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, TLRPC$EncryptedChat tLRPC$EncryptedChat, boolean z) {
        if (tLRPC$User == null && tLRPC$Chat == null && tLRPC$EncryptedChat == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
        editorEdit.putInt("dialog_bar_vis3" + j, 3);
        editorEdit.apply();
        if (((int) j) == 0) {
            if (tLRPC$EncryptedChat == null || tLRPC$EncryptedChat.access_hash == 0) {
                return;
            }
            TLRPC$TL_messages_reportEncryptedSpam tLRPC$TL_messages_reportEncryptedSpam = new TLRPC$TL_messages_reportEncryptedSpam();
            TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat = new TLRPC$TL_inputEncryptedChat();
            tLRPC$TL_messages_reportEncryptedSpam.peer = tLRPC$TL_inputEncryptedChat;
            tLRPC$TL_inputEncryptedChat.chat_id = tLRPC$EncryptedChat.id;
            tLRPC$TL_inputEncryptedChat.access_hash = tLRPC$EncryptedChat.access_hash;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_reportEncryptedSpam, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda272
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$reportSpam$39(tLObject, tLRPC$TL_error);
                }
            }, 2);
            return;
        }
        if (z) {
            TLRPC$TL_account_reportPeer tLRPC$TL_account_reportPeer = new TLRPC$TL_account_reportPeer();
            if (tLRPC$Chat != null) {
                tLRPC$TL_account_reportPeer.peer = getInputPeer(-tLRPC$Chat.id);
            } else if (tLRPC$User != null) {
                tLRPC$TL_account_reportPeer.peer = getInputPeer(tLRPC$User.id);
            }
            tLRPC$TL_account_reportPeer.message = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            tLRPC$TL_account_reportPeer.reason = new TLRPC$ReportReason() { // from class: org.rbmain.tgnet.TLRPC$TL_inputReportReasonGeoIrrelevant
                public static int constructor = -606798099;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            };
            getConnectionsManager().sendRequest(tLRPC$TL_account_reportPeer, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda274
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$reportSpam$40(tLObject, tLRPC$TL_error);
                }
            }, 2);
            return;
        }
        TLRPC$TL_messages_reportSpam tLRPC$TL_messages_reportSpam = new TLRPC$TL_messages_reportSpam();
        if (tLRPC$Chat != null) {
            tLRPC$TL_messages_reportSpam.peer = getInputPeer(-tLRPC$Chat.id);
        } else if (tLRPC$User != null) {
            tLRPC$TL_messages_reportSpam.peer = getInputPeer(tLRPC$User.id);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_reportSpam, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda266
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$reportSpam$41(tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    private void savePeerSettings(long j, TLRPC$TL_peerSettings tLRPC$TL_peerSettings, boolean z) {
        if (tLRPC$TL_peerSettings != null) {
            if (this.notificationsPreferences.getInt("dialog_bar_vis3" + j, 0) == 3) {
                return;
            }
            SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
            boolean z2 = (tLRPC$TL_peerSettings.report_spam || tLRPC$TL_peerSettings.add_contact || tLRPC$TL_peerSettings.block_contact || tLRPC$TL_peerSettings.share_contact || tLRPC$TL_peerSettings.report_geo || tLRPC$TL_peerSettings.invite_members) ? false : true;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("peer settings loaded for " + j + " add = " + tLRPC$TL_peerSettings.add_contact + " block = " + tLRPC$TL_peerSettings.block_contact + " spam = " + tLRPC$TL_peerSettings.report_spam + " share = " + tLRPC$TL_peerSettings.share_contact + " geo = " + tLRPC$TL_peerSettings.report_geo + " hide = " + z2 + " distance = " + tLRPC$TL_peerSettings.geo_distance + " invite = " + tLRPC$TL_peerSettings.invite_members);
            }
            editorEdit.putInt("dialog_bar_vis3" + j, z2 ? 1 : 2);
            editorEdit.putBoolean("dialog_bar_share" + j, tLRPC$TL_peerSettings.share_contact);
            editorEdit.putBoolean("dialog_bar_report" + j, tLRPC$TL_peerSettings.report_spam);
            editorEdit.putBoolean("dialog_bar_add" + j, tLRPC$TL_peerSettings.add_contact);
            editorEdit.putBoolean("dialog_bar_block" + j, tLRPC$TL_peerSettings.block_contact);
            editorEdit.putBoolean("dialog_bar_exception" + j, tLRPC$TL_peerSettings.need_contacts_exception);
            editorEdit.putBoolean("dialog_bar_location" + j, tLRPC$TL_peerSettings.report_geo);
            editorEdit.putBoolean("dialog_bar_archived" + j, tLRPC$TL_peerSettings.autoarchived);
            editorEdit.putBoolean("dialog_bar_invite" + j, tLRPC$TL_peerSettings.invite_members);
            if (this.notificationsPreferences.getInt("dialog_bar_distance" + j, -1) != -2) {
                if ((tLRPC$TL_peerSettings.flags & 64) != 0) {
                    editorEdit.putInt("dialog_bar_distance" + j, tLRPC$TL_peerSettings.geo_distance);
                } else {
                    editorEdit.remove("dialog_bar_distance" + j);
                }
            }
            editorEdit.apply();
            getNotificationCenter().postNotificationName(NotificationCenter.peerSettingsDidLoad, Long.valueOf(j));
        }
    }

    public void loadPeerSettings(TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat) {
        int i;
        if (tLRPC$User == null && tLRPC$Chat == null) {
            return;
        }
        if (tLRPC$User != null) {
            i = tLRPC$User.id;
        } else {
            i = -tLRPC$Chat.id;
        }
        final long j = i;
        if (this.loadingPeerSettings.indexOfKey(j) >= 0) {
            return;
        }
        this.loadingPeerSettings.put(j, Boolean.TRUE);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("request spam button for " + j);
        }
        int i2 = this.notificationsPreferences.getInt("dialog_bar_vis3" + j, 0);
        if (i2 == 1 || i2 == 3) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("dialog bar already hidden for " + j);
                return;
            }
            return;
        }
        TLRPC$TL_messages_getPeerSettings tLRPC$TL_messages_getPeerSettings = new TLRPC$TL_messages_getPeerSettings();
        if (tLRPC$User != null) {
            tLRPC$TL_messages_getPeerSettings.peer = getInputPeer(tLRPC$User.id);
        } else {
            tLRPC$TL_messages_getPeerSettings.peer = getInputPeer(-tLRPC$Chat.id);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerSettings, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda227
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPeerSettings$43(j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPeerSettings$43(final long j, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda70
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPeerSettings$42(j, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPeerSettings$42(long j, TLObject tLObject) {
        this.loadingPeerSettings.remove(j);
        if (tLObject != null) {
            savePeerSettings(j, (TLRPC$TL_peerSettings) tLObject, false);
        }
    }

    protected void processNewChannelDifferenceParams(int i, int i2, int i3) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("processNewChannelDifferenceParams pts = " + i + " pts_count = " + i2 + " channeldId = " + i3);
        }
        int channelPtsSync = this.channelsPts.get(i3);
        if (channelPtsSync == 0) {
            channelPtsSync = getMessagesStorage().getChannelPtsSync(i3);
            if (channelPtsSync == 0) {
                channelPtsSync = 1;
            }
            this.channelsPts.put(i3, channelPtsSync);
        }
        if (channelPtsSync + i2 == i) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("APPLY CHANNEL PTS");
            }
            this.channelsPts.put(i3, i);
            getMessagesStorage().saveChannelPts(i3, i);
            return;
        }
        if (channelPtsSync != i) {
            long j = this.updatesStartWaitTimeChannels.get(i3);
            if (this.gettingDifferenceChannels.get(i3) || j == 0 || Math.abs(System.currentTimeMillis() - j) <= 1500) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("ADD CHANNEL UPDATE TO QUEUE pts = " + i + " pts_count = " + i2);
                }
                if (j == 0) {
                    this.updatesStartWaitTimeChannels.put(i3, System.currentTimeMillis());
                }
                UserActionUpdatesPts userActionUpdatesPts = new UserActionUpdatesPts();
                userActionUpdatesPts.pts = i;
                userActionUpdatesPts.pts_count = i2;
                userActionUpdatesPts.chat_id = i3;
                ArrayList<TLRPC$Updates> arrayList = this.updatesQueueChannels.get(i3);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.updatesQueueChannels.put(i3, arrayList);
                }
                arrayList.add(userActionUpdatesPts);
                return;
            }
            getChannelDifference(i3);
        }
    }

    public void processNewDifferenceParams(int i, int i2, int i3, int i4) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("processNewDifferenceParams seq = " + i + " pts = " + i2 + " date = " + i3 + " pts_count = " + i4);
        }
        if (i2 != -1) {
            if (getMessagesStorage().getLastPtsValue() + i4 == i2) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("APPLY PTS");
                }
                getMessagesStorage().setLastPtsValue(i2);
                getMessagesStorage().saveDiffParams(getMessagesStorage().getLastSeqValue(), getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue());
            } else if (getMessagesStorage().getLastPtsValue() != i2) {
                if (this.gettingDifference || this.updatesStartWaitTimePts == 0 || Math.abs(System.currentTimeMillis() - this.updatesStartWaitTimePts) <= 1500) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("ADD UPDATE TO QUEUE pts = " + i2 + " pts_count = " + i4);
                    }
                    if (this.updatesStartWaitTimePts == 0) {
                        this.updatesStartWaitTimePts = System.currentTimeMillis();
                    }
                    UserActionUpdatesPts userActionUpdatesPts = new UserActionUpdatesPts();
                    userActionUpdatesPts.pts = i2;
                    userActionUpdatesPts.pts_count = i4;
                    this.updatesQueuePts.add(userActionUpdatesPts);
                } else {
                    getDifference();
                }
            }
        }
        if (i != -1) {
            if (getMessagesStorage().getLastSeqValue() + 1 == i) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("APPLY SEQ");
                }
                getMessagesStorage().setLastSeqValue(i);
                if (i3 != -1) {
                    getMessagesStorage().setLastDateValue(i3);
                }
                getMessagesStorage().saveDiffParams(getMessagesStorage().getLastSeqValue(), getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue());
                return;
            }
            if (getMessagesStorage().getLastSeqValue() != i) {
                if (this.gettingDifference || this.updatesStartWaitTimeSeq == 0 || Math.abs(System.currentTimeMillis() - this.updatesStartWaitTimeSeq) <= 1500) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("ADD UPDATE TO QUEUE seq = " + i);
                    }
                    if (this.updatesStartWaitTimeSeq == 0) {
                        this.updatesStartWaitTimeSeq = System.currentTimeMillis();
                    }
                    UserActionUpdatesSeq userActionUpdatesSeq = new UserActionUpdatesSeq();
                    userActionUpdatesSeq.seq = i;
                    this.updatesQueueSeq.add(userActionUpdatesSeq);
                    return;
                }
                getDifference();
            }
        }
    }

    public void didAddedNewTask(final int i, final SparseArray<ArrayList<Long>> sparseArray) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didAddedNewTask$44(i);
            }
        });
        if (sparseArray != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda71
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didAddedNewTask$45(sparseArray);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didAddedNewTask$44(int i) {
        int i2;
        if ((this.currentDeletingTaskMids != null || this.gettingNewDeleteTask) && ((i2 = this.currentDeletingTaskTime) == 0 || i >= i2)) {
            return;
        }
        getNewDeleteTask(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didAddedNewTask$45(SparseArray sparseArray) {
        getNotificationCenter().postNotificationName(NotificationCenter.didCreatedNewDeleteTask, sparseArray);
    }

    public void getNewDeleteTask(final ArrayList<Long> arrayList, final int i) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda100
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getNewDeleteTask$46(arrayList, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getNewDeleteTask$46(ArrayList arrayList, int i) {
        this.gettingNewDeleteTask = true;
        getMessagesStorage().getNewTask(arrayList, i);
    }

    private boolean checkDeletingTask(boolean z) {
        int i;
        int currentTime = getConnectionsManager().getCurrentTime();
        if (this.currentDeletingTaskMids == null || (!z && ((i = this.currentDeletingTaskTime) == 0 || i > currentTime))) {
            return false;
        }
        this.currentDeletingTaskTime = 0;
        if (this.currentDeleteTaskRunnable != null && !z) {
            Utilities.stageQueue.cancelRunnable(this.currentDeleteTaskRunnable);
        }
        this.currentDeleteTaskRunnable = null;
        final ArrayList arrayList = new ArrayList(this.currentDeletingTaskMids);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda96
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkDeletingTask$48(arrayList);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDeletingTask$48(final ArrayList arrayList) {
        if (this.currentDeletingTaskMedia) {
            getMessagesStorage().emptyMessagesMedia(arrayList);
        } else {
            deleteMessages(arrayList, null, null, 0L, 0, false, false, !arrayList.isEmpty() && ((Long) arrayList.get(0)).longValue() > 0);
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda95
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkDeletingTask$47(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDeletingTask$47(ArrayList arrayList) {
        getNewDeleteTask(arrayList, this.currentDeletingTaskChannelId);
        this.currentDeletingTaskTime = 0;
        this.currentDeletingTaskMids = null;
        this.currentDeletingTaskMedia = false;
        this.currentDeletingTaskChannelId = 0;
    }

    public void processLoadedDeleteTask(final int i, final ArrayList<Long> arrayList, final boolean z, final int i2) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda103
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDeleteTask$50(arrayList, i, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDeleteTask$50(ArrayList arrayList, int i, boolean z, int i2) {
        this.gettingNewDeleteTask = false;
        if (arrayList != null) {
            this.currentDeletingTaskTime = i;
            this.currentDeletingTaskMids = arrayList;
            this.currentDeletingTaskMedia = z;
            this.currentDeletingTaskChannelId = i2;
            if (this.currentDeleteTaskRunnable != null) {
                Utilities.stageQueue.cancelRunnable(this.currentDeleteTaskRunnable);
                this.currentDeleteTaskRunnable = null;
            }
            if (checkDeletingTask(false)) {
                return;
            }
            this.currentDeleteTaskRunnable = new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedDeleteTask$49();
                }
            };
            Utilities.stageQueue.postRunnable(this.currentDeleteTaskRunnable, Math.abs(getConnectionsManager().getCurrentTime() - this.currentDeletingTaskTime) * 1000);
            return;
        }
        this.currentDeletingTaskTime = 0;
        this.currentDeletingTaskMids = null;
        this.currentDeletingTaskMedia = false;
        this.currentDeletingTaskChannelId = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDeleteTask$49() {
        checkDeletingTask(true);
    }

    public void loadDialogPhotos(int i, int i2, long j, boolean z, int i3) {
        getDialogsProxy().loadDialogPhotos(i, i2, j, z, i3);
    }

    public void blockPeer(int i) {
        TLRPC$Chat chat;
        TLRPC$User tLRPC$User = null;
        if (i > 0) {
            TLRPC$User user = getUser(Integer.valueOf(i));
            if (user == null) {
                return;
            }
            chat = null;
            tLRPC$User = user;
        } else {
            chat = getChat(Integer.valueOf(-i));
            if (chat == null) {
                return;
            }
        }
        if (this.blockePeers.indexOfKey(i) >= 0) {
            return;
        }
        this.blockePeers.put(i, 1);
        if (tLRPC$User != null && tLRPC$User.bot) {
            getMediaDataController().removeInline(i);
        }
        int i2 = this.totalBlockedCount;
        if (i2 >= 0) {
            this.totalBlockedCount = i2 + 1;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        TLRPC$TL_contacts_block tLRPC$TL_contacts_block = new TLRPC$TL_contacts_block();
        if (tLRPC$User != null) {
            tLRPC$TL_contacts_block.id = getInputPeer(tLRPC$User);
        } else {
            tLRPC$TL_contacts_block.id = getInputPeer(chat);
        }
        getDialogsProxy().blockOrUnblockUserOrChat(tLRPC$TL_contacts_block, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda268
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$blockPeer$51(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void setParticipantBannedRole(final int i, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final boolean z, final BaseFragment baseFragment) {
        if ((tLRPC$User == null && tLRPC$Chat == null) || tLRPC$TL_chatBannedRights == null) {
            return;
        }
        final TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned = new TLRPC$TL_channels_editBanned();
        tLRPC$TL_channels_editBanned.channel = getInputChannel(i);
        if (tLRPC$User != null) {
            tLRPC$TL_channels_editBanned.participant = getInputPeer(tLRPC$User);
        } else {
            tLRPC$TL_channels_editBanned.participant = getInputPeer(tLRPC$Chat);
        }
        tLRPC$TL_channels_editBanned.banned_rights = tLRPC$TL_chatBannedRights;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_editBanned, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda224
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setParticipantBannedRole$54(i, baseFragment, tLRPC$TL_channels_editBanned, z, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParticipantBannedRole$54(final int i, final BaseFragment baseFragment, final TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned, final boolean z, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setParticipantBannedRole$52(i);
                }
            }, 1000L);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda137
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setParticipantBannedRole$53(tLRPC$TL_error, baseFragment, tLRPC$TL_channels_editBanned, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParticipantBannedRole$52(int i) {
        loadFullChat(i, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParticipantBannedRole$53(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned, boolean z) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_editBanned, Boolean.valueOf(z));
    }

    public void setChannelSlowMode(final int i, int i2) {
        TLRPC$TL_channels_toggleSlowMode tLRPC$TL_channels_toggleSlowMode = new TLRPC$TL_channels_toggleSlowMode();
        tLRPC$TL_channels_toggleSlowMode.seconds = i2;
        tLRPC$TL_channels_toggleSlowMode.channel = getInputChannel(i);
        getDialogsProxy().setChannelSlowMode(tLRPC$TL_channels_toggleSlowMode, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda212
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setChannelSlowMode$56(i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setChannelSlowMode$56(final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda44
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setChannelSlowMode$55(i);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setChannelSlowMode$55(int i) {
        loadFullChat(i, 0, true);
    }

    public void setDefaultBannedRole(final int i, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final boolean z, final BaseFragment baseFragment) {
        if (tLRPC$TL_chatBannedRights == null) {
            return;
        }
        final TLRPC$TL_messages_editChatDefaultBannedRights tLRPC$TL_messages_editChatDefaultBannedRights = new TLRPC$TL_messages_editChatDefaultBannedRights();
        tLRPC$TL_messages_editChatDefaultBannedRights.peer = getInputPeer(-i);
        tLRPC$TL_messages_editChatDefaultBannedRights.banned_rights = tLRPC$TL_chatBannedRights;
        getDialogsProxy().setDefaultBannedRights(tLRPC$TL_messages_editChatDefaultBannedRights, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda226
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setDefaultBannedRole$59(i, baseFragment, tLRPC$TL_messages_editChatDefaultBannedRights, z, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultBannedRole$59(final int i, final BaseFragment baseFragment, final TLRPC$TL_messages_editChatDefaultBannedRights tLRPC$TL_messages_editChatDefaultBannedRights, final boolean z, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda37
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setDefaultBannedRole$57(i);
                }
            }, 1000L);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda141
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setDefaultBannedRole$58(tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editChatDefaultBannedRights, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultBannedRole$57(int i) {
        loadFullChat(i, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultBannedRole$58(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_editChatDefaultBannedRights tLRPC$TL_messages_editChatDefaultBannedRights, boolean z) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editChatDefaultBannedRights, Boolean.valueOf(z));
    }

    public void setUserAdminRole(final int i, TLRPC$User tLRPC$User, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, String str, final boolean z, final BaseFragment baseFragment, boolean z2, boolean z3) {
        if (tLRPC$User == null || tLRPC$TL_chatAdminRights == null) {
            return;
        }
        TLRPC$Chat chat = getChat(Integer.valueOf(i));
        if (ChatObject.isChannel(chat)) {
            final TLRPC$TL_channels_editAdmin tLRPC$TL_channels_editAdmin = new TLRPC$TL_channels_editAdmin();
            tLRPC$TL_channels_editAdmin.channel = getInputChannel(chat);
            tLRPC$TL_channels_editAdmin.user_id = getInputUser(tLRPC$User);
            tLRPC$TL_channels_editAdmin.admin_rights = tLRPC$TL_chatAdminRights;
            tLRPC$TL_channels_editAdmin.rank = str;
            tLRPC$TL_channels_editAdmin.unset = z3;
            getDialogsProxy().setChatAdmin(tLRPC$TL_channels_editAdmin, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda223
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$setUserAdminRole$62(i, baseFragment, tLRPC$TL_channels_editAdmin, z, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        final TLRPC$TL_messages_editChatAdmin tLRPC$TL_messages_editChatAdmin = new TLRPC$TL_messages_editChatAdmin();
        tLRPC$TL_messages_editChatAdmin.chat_id = i;
        tLRPC$TL_messages_editChatAdmin.user_id = getInputUser(tLRPC$User);
        tLRPC$TL_messages_editChatAdmin.is_admin = tLRPC$TL_chatAdminRights.change_info || tLRPC$TL_chatAdminRights.delete_messages || tLRPC$TL_chatAdminRights.ban_users || tLRPC$TL_chatAdminRights.invite_users || tLRPC$TL_chatAdminRights.pin_messages || tLRPC$TL_chatAdminRights.add_admins || tLRPC$TL_chatAdminRights.manage_call;
        final RequestDelegate requestDelegate = new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda225
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setUserAdminRole$65(i, baseFragment, tLRPC$TL_messages_editChatAdmin, tLObject, tLRPC$TL_error);
            }
        };
        if (tLRPC$TL_messages_editChatAdmin.is_admin && z2) {
            addUserToChat(i, tLRPC$User, 0, null, baseFragment, new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda142
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$66(tLRPC$TL_messages_editChatAdmin, requestDelegate);
                }
            });
        } else {
            getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatAdmin, requestDelegate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserAdminRole$62(final int i, final BaseFragment baseFragment, final TLRPC$TL_channels_editAdmin tLRPC$TL_channels_editAdmin, final boolean z, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$60(i);
                }
            }, 1000L);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda136
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$61(tLRPC$TL_error, baseFragment, tLRPC$TL_channels_editAdmin, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserAdminRole$60(int i) {
        loadFullChat(i, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserAdminRole$61(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_editAdmin tLRPC$TL_channels_editAdmin, boolean z) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_editAdmin, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserAdminRole$63(int i) {
        loadFullChat(i, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserAdminRole$65(final int i, final BaseFragment baseFragment, final TLRPC$TL_messages_editChatAdmin tLRPC$TL_messages_editChatAdmin, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$63(i);
                }
            }, 1000L);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda140
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$64(tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editChatAdmin);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserAdminRole$64(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_editChatAdmin tLRPC$TL_messages_editChatAdmin) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editChatAdmin, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUserAdminRole$66(TLRPC$TL_messages_editChatAdmin tLRPC$TL_messages_editChatAdmin, RequestDelegate requestDelegate) {
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatAdmin, requestDelegate);
    }

    public void unblockPeer(int i) {
        unblockPeer(i, null);
    }

    public void unblockPeer(int i, final Runnable runnable) {
        TLRPC$Chat chat;
        TLRPC$TL_contacts_unblock tLRPC$TL_contacts_unblock = new TLRPC$TL_contacts_unblock();
        TLRPC$User tLRPC$User = null;
        if (i > 0) {
            TLRPC$User user = getUser(Integer.valueOf(i));
            if (user == null) {
                return;
            }
            chat = null;
            tLRPC$User = user;
        } else {
            chat = getChat(Integer.valueOf(-i));
            if (chat == null) {
                return;
            }
        }
        this.totalBlockedCount--;
        this.blockePeers.delete(i);
        if (tLRPC$User != null) {
            tLRPC$TL_contacts_unblock.id = getInputPeer(tLRPC$User);
        } else {
            tLRPC$TL_contacts_unblock.id = getInputPeer(chat);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        getDialogsProxy().blockOrUnblockUserOrChat(tLRPC$TL_contacts_unblock, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda190
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$unblockPeer$68(runnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unblockPeer$68(final Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                MessagesController.lambda$unblockPeer$67(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unblockPeer$67(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public void getBlockedPeers(final boolean z) {
        if (!getUserConfig().isClientActivated() || this.loadingBlockedPeers) {
            return;
        }
        this.loadingBlockedPeers = true;
        TLRPC$TL_contacts_getBlocked tLRPC$TL_contacts_getBlocked = new TLRPC$TL_contacts_getBlocked();
        tLRPC$TL_contacts_getBlocked.offset = z ? 0 : this.blockePeers.size();
        String str = z ? null : this.nextBlockedPeersId;
        this.nextBlockedPeersId = str;
        tLRPC$TL_contacts_getBlocked.nextStartId = str;
        tLRPC$TL_contacts_getBlocked.limit = z ? 20 : 100;
        getDialogsProxy().getBlockedUsers(tLRPC$TL_contacts_getBlocked, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda258
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getBlockedPeers$70(z, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBlockedPeers$70(final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda123
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getBlockedPeers$69(tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBlockedPeers$69(TLObject tLObject, boolean z) {
        if (tLObject != null) {
            TLRPC$contacts_Blocked tLRPC$contacts_Blocked = (TLRPC$contacts_Blocked) tLObject;
            putUsers(tLRPC$contacts_Blocked.users, false);
            putChats(tLRPC$contacts_Blocked.chats, false);
            getMessagesStorage().putUsersAndChats(tLRPC$contacts_Blocked.users, tLRPC$contacts_Blocked.chats, true, true);
            if (z) {
                this.blockePeers.clear();
            }
            this.totalBlockedCount = Math.max(tLRPC$contacts_Blocked.count, tLRPC$contacts_Blocked.blocked.size());
            this.nextBlockedPeersId = tLRPC$contacts_Blocked.nextStartId;
            this.blockedEndReached = !tLRPC$contacts_Blocked.hasContinue;
            int size = tLRPC$contacts_Blocked.blocked.size();
            for (int i = 0; i < size; i++) {
                this.blockePeers.put(MessageObject.getPeerId(tLRPC$contacts_Blocked.blocked.get(i).peer_id), 1);
            }
            this.loadingBlockedPeers = false;
            getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        }
    }

    public void deleteUserPhoto(TLRPC$InputPhoto tLRPC$InputPhoto, boolean z) {
        if (tLRPC$InputPhoto != null) {
            TLRPC$TL_photos_updateProfilePhoto tLRPC$TL_photos_updateProfilePhoto = new TLRPC$TL_photos_updateProfilePhoto();
            tLRPC$TL_photos_updateProfilePhoto.id = tLRPC$InputPhoto;
            if (z) {
                getUserConfig().getCurrentUser().photo = new TLRPC$TL_userProfilePhotoEmpty();
                TLRPC$User user = getUser(Integer.valueOf(getUserConfig().getClientUserId()));
                if (user == null) {
                    user = getUserConfig().getCurrentUser();
                }
                if (user == null) {
                    return;
                }
                user.photo = getUserConfig().getCurrentUser().photo;
                getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
                getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_ALL));
            }
            getAccountInstance().getFileProxy().deleteAvatar(0L, tLRPC$TL_photos_updateProfilePhoto, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda191
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$deleteUserPhoto$72(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteUserPhoto$72(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null || tLObject == null) {
            return;
        }
        TLRPC$User user = getUser(Integer.valueOf(getUserConfig().getClientUserId()));
        if (user == null) {
            user = getUserConfig().getCurrentUser();
            putUser(user, false);
        } else {
            getUserConfig().setCurrentUser(user);
        }
        if (user == null) {
            return;
        }
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        arrayList.add(user);
        getMessagesStorage().putUsersAndChats(arrayList, null, false, true);
        if (tLObject instanceof TLRPC$UserProfilePhoto) {
            user.photo = (TLRPC$UserProfilePhoto) tLObject;
        } else {
            user.photo = new TLRPC$TL_userProfilePhotoEmpty();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteUserPhoto$71();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteUserPhoto$71() {
        getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_ALL));
        getUserConfig().saveConfig(true);
    }

    public void deleteChatPhoto(long j, TLRPC$InputPhoto tLRPC$InputPhoto) {
        if (tLRPC$InputPhoto != null) {
            TLRPC$TL_photos_updateProfilePhoto tLRPC$TL_photos_updateProfilePhoto = new TLRPC$TL_photos_updateProfilePhoto();
            tLRPC$TL_photos_updateProfilePhoto.id = tLRPC$InputPhoto;
            getAccountInstance().getFileProxy().deleteAvatar(j, tLRPC$TL_photos_updateProfilePhoto, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda196
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$deleteChatPhoto$74(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteChatPhoto$74(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteChatPhoto$73();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteChatPhoto$73() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 2);
    }

    public void processLoadedUserPhotos(final TLRPC$photos_Photos tLRPC$photos_Photos, final ArrayList<TLRPC$Message> arrayList, final int i, final int i2, long j, final boolean z, final int i3) {
        if (tLRPC$photos_Photos == null || tLRPC$photos_Photos.photos.isEmpty()) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedUserPhotos$75(i, i2, z, i3, tLRPC$photos_Photos, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedUserPhotos$75(int i, int i2, boolean z, int i3, TLRPC$photos_Photos tLRPC$photos_Photos, ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.dialogPhotosLoaded, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), tLRPC$photos_Photos.photos, arrayList);
    }

    public void uploadAndApplyUserAvatar(TLRPC$FileLocation tLRPC$FileLocation) {
        if (tLRPC$FileLocation == null) {
            return;
        }
        this.uploadingAvatar = FileLoader.getDirectory(4) + "/" + tLRPC$FileLocation.volume_id + "_" + tLRPC$FileLocation.local_id + ".jpg";
        getFileLoader().uploadFile(this.uploadingAvatar, false, true, ConnectionsManager.FileTypePhoto, null);
    }

    public void saveTheme(Theme.ThemeInfo themeInfo, Theme.ThemeAccent themeAccent, boolean z, boolean z2) {
        TLRPC$TL_theme tLRPC$TL_theme = themeAccent != null ? themeAccent.info : themeInfo.info;
        if (tLRPC$TL_theme != null) {
            TLRPC$TL_account_saveTheme tLRPC$TL_account_saveTheme = new TLRPC$TL_account_saveTheme();
            TLRPC$TL_inputTheme tLRPC$TL_inputTheme = new TLRPC$TL_inputTheme();
            tLRPC$TL_inputTheme.id = tLRPC$TL_theme.id;
            tLRPC$TL_inputTheme.access_hash = tLRPC$TL_theme.access_hash;
            tLRPC$TL_account_saveTheme.theme = tLRPC$TL_inputTheme;
            tLRPC$TL_account_saveTheme.unsave = z2;
            getConnectionsManager().sendRequest(tLRPC$TL_account_saveTheme, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda275
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$saveTheme$76(tLObject, tLRPC$TL_error);
                }
            });
            getConnectionsManager().resumeNetworkMaybe();
        }
        if (z2) {
            return;
        }
        installTheme(themeInfo, themeAccent, z);
    }

    public void installTheme(Theme.ThemeInfo themeInfo, Theme.ThemeAccent themeAccent, boolean z) {
        TLRPC$TL_theme tLRPC$TL_theme = themeAccent != null ? themeAccent.info : themeInfo.info;
        String str = themeAccent != null ? themeAccent.patternSlug : themeInfo.slug;
        boolean z2 = themeAccent == null && themeInfo.isBlured;
        boolean z3 = themeAccent != null ? themeAccent.patternMotion : themeInfo.isMotion;
        TLRPC$TL_account_installTheme tLRPC$TL_account_installTheme = new TLRPC$TL_account_installTheme();
        tLRPC$TL_account_installTheme.dark = z;
        if (tLRPC$TL_theme != null) {
            tLRPC$TL_account_installTheme.format = "android";
            TLRPC$TL_inputTheme tLRPC$TL_inputTheme = new TLRPC$TL_inputTheme();
            tLRPC$TL_inputTheme.id = tLRPC$TL_theme.id;
            tLRPC$TL_inputTheme.access_hash = tLRPC$TL_theme.access_hash;
            tLRPC$TL_account_installTheme.theme = tLRPC$TL_inputTheme;
            tLRPC$TL_account_installTheme.flags |= 2;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_account_installTheme, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda262
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$installTheme$77(tLObject, tLRPC$TL_error);
            }
        });
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TLRPC$TL_account_installWallPaper tLRPC$TL_account_installWallPaper = new TLRPC$TL_account_installWallPaper();
        TLRPC$TL_inputWallPaperSlug tLRPC$TL_inputWallPaperSlug = new TLRPC$TL_inputWallPaperSlug();
        tLRPC$TL_inputWallPaperSlug.slug = str;
        tLRPC$TL_account_installWallPaper.wallpaper = tLRPC$TL_inputWallPaperSlug;
        TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings = new TLRPC$TL_wallPaperSettings();
        tLRPC$TL_account_installWallPaper.settings = tLRPC$TL_wallPaperSettings;
        tLRPC$TL_wallPaperSettings.blur = z2;
        tLRPC$TL_wallPaperSettings.motion = z3;
        getConnectionsManager().sendRequest(tLRPC$TL_account_installWallPaper, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda276
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$installTheme$78(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void saveThemeToServer(final Theme.ThemeInfo themeInfo, final Theme.ThemeAccent themeAccent) {
        String absolutePath;
        File pathToWallpaper;
        if (themeInfo == null) {
            return;
        }
        if (themeAccent != 0) {
            absolutePath = themeAccent.saveToFile().getAbsolutePath();
            pathToWallpaper = themeAccent.getPathToWallpaper();
        } else {
            absolutePath = themeInfo.pathToFile;
            pathToWallpaper = null;
        }
        final String str = absolutePath;
        final File file = pathToWallpaper;
        if (str == null || this.uploadingThemes.containsKey(str)) {
            return;
        }
        this.uploadingThemes.put(str, themeAccent != 0 ? themeAccent : themeInfo);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda81
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveThemeToServer$80(str, file, themeAccent, themeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveThemeToServer$80(final String str, File file, final Theme.ThemeAccent themeAccent, final Theme.ThemeInfo themeInfo) {
        final String strCreateThemePreviewImage = Theme.createThemePreviewImage(str, file != null ? file.getAbsolutePath() : null, themeAccent);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda82
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveThemeToServer$79(strCreateThemePreviewImage, str, themeAccent, themeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$saveThemeToServer$79(String str, String str2, Theme.ThemeAccent themeAccent, Theme.ThemeInfo themeInfo) {
        if (str == null) {
            this.uploadingThemes.remove(str2);
            return;
        }
        this.uploadingThemes.put(str, themeAccent != null ? themeAccent : themeInfo);
        if (themeAccent == null) {
            themeInfo.uploadingFile = str2;
            themeInfo.uploadingThumb = str;
        }
        getFileLoader().uploadFile(str2, false, true, ConnectionsManager.FileTypeFile, null);
        getFileLoader().uploadFile(str, false, true, ConnectionsManager.FileTypePhoto, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void saveWallpaperToServer(File file, Theme.OverrideWallpaperInfo overrideWallpaperInfo, boolean z, final long j) {
        TLRPC$TL_account_saveWallPaper tLRPC$TL_account_saveWallPaper;
        NativeByteBuffer nativeByteBuffer;
        NativeByteBuffer nativeByteBuffer2 = null;
        if (this.uploadingWallpaper != null) {
            File file2 = new File(ApplicationLoader.getFilesDirFixed(), overrideWallpaperInfo.originalFileName);
            if (file != null && (file.getAbsolutePath().equals(this.uploadingWallpaper) || file.equals(file2))) {
                this.uploadingWallpaperInfo = overrideWallpaperInfo;
                return;
            }
            getFileLoader().cancelUploadFile(this.uploadingWallpaper, false);
            this.uploadingWallpaper = null;
            this.uploadingWallpaperInfo = null;
            this.uploadingWallpaperObject = null;
            this.uploadingWallpaperThumb = null;
        }
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            this.uploadingWallpaper = absolutePath;
            this.uploadingWallpaperInfo = overrideWallpaperInfo;
            Bitmap bitmapLoadBitmap = ImageLoader.loadBitmap(absolutePath, null, 90.0f, 90.0f, true);
            if (bitmapLoadBitmap != null) {
                TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmapLoadBitmap, 90.0f, 90.0f, 85, false);
                if (tLRPC$PhotoSizeScaleAndSaveImage != null) {
                    this.uploadingWallpaperThumb = FileLoader.getPathToAttach(tLRPC$PhotoSizeScaleAndSaveImage.location, true).toString();
                }
                bitmapLoadBitmap.recycle();
            }
            UploadingFileWallpaper uploadingFileWallpaper = new UploadingFileWallpaper();
            this.uploadingWallpaperObject = uploadingFileWallpaper;
            uploadingFileWallpaper.location = this.uploadingWallpaper;
            uploadingFileWallpaper.locationThumb = this.uploadingWallpaperThumb;
            getFileLoader().uploadFile(this.uploadingWallpaper, false, true, ConnectionsManager.FileTypePhoto, null);
            return;
        }
        if (overrideWallpaperInfo.isDefault() || overrideWallpaperInfo.isColor() || overrideWallpaperInfo.isTheme()) {
            return;
        }
        TLRPC$TL_inputWallPaperSlug tLRPC$TL_inputWallPaperSlug = new TLRPC$TL_inputWallPaperSlug();
        tLRPC$TL_inputWallPaperSlug.slug = overrideWallpaperInfo.slug;
        TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings = new TLRPC$TL_wallPaperSettings();
        tLRPC$TL_wallPaperSettings.blur = overrideWallpaperInfo.isBlurred;
        tLRPC$TL_wallPaperSettings.motion = overrideWallpaperInfo.isMotion;
        int i = overrideWallpaperInfo.color;
        if (i != 0) {
            tLRPC$TL_wallPaperSettings.background_color = i;
            int i2 = tLRPC$TL_wallPaperSettings.flags | 1;
            tLRPC$TL_wallPaperSettings.flags = i2;
            tLRPC$TL_wallPaperSettings.intensity = (int) (overrideWallpaperInfo.intensity * 100.0f);
            tLRPC$TL_wallPaperSettings.flags = i2 | 8;
        }
        int i3 = overrideWallpaperInfo.gradientColor;
        if (i3 != 0) {
            tLRPC$TL_wallPaperSettings.second_background_color = i3;
            tLRPC$TL_wallPaperSettings.rotation = AndroidUtilities.getWallpaperRotation(overrideWallpaperInfo.rotation, true);
            tLRPC$TL_wallPaperSettings.flags |= 16;
        }
        if (z) {
            TLRPC$TL_account_installWallPaper tLRPC$TL_account_installWallPaper = new TLRPC$TL_account_installWallPaper();
            tLRPC$TL_account_installWallPaper.wallpaper = tLRPC$TL_inputWallPaperSlug;
            tLRPC$TL_account_installWallPaper.settings = tLRPC$TL_wallPaperSettings;
            tLRPC$TL_account_saveWallPaper = tLRPC$TL_account_installWallPaper;
        } else {
            TLRPC$TL_account_saveWallPaper tLRPC$TL_account_saveWallPaper2 = new TLRPC$TL_account_saveWallPaper();
            tLRPC$TL_account_saveWallPaper2.wallpaper = tLRPC$TL_inputWallPaperSlug;
            tLRPC$TL_account_saveWallPaper2.settings = tLRPC$TL_wallPaperSettings;
            tLRPC$TL_account_saveWallPaper = tLRPC$TL_account_saveWallPaper2;
        }
        if (j == 0) {
            try {
                nativeByteBuffer = new NativeByteBuffer(1024);
            } catch (Exception e) {
                e = e;
            }
            try {
                nativeByteBuffer.writeInt32(21);
                nativeByteBuffer.writeBool(overrideWallpaperInfo.isBlurred);
                nativeByteBuffer.writeBool(overrideWallpaperInfo.isMotion);
                nativeByteBuffer.writeInt32(overrideWallpaperInfo.color);
                nativeByteBuffer.writeInt32(overrideWallpaperInfo.gradientColor);
                nativeByteBuffer.writeInt32(overrideWallpaperInfo.rotation);
                nativeByteBuffer.writeDouble(overrideWallpaperInfo.intensity);
                nativeByteBuffer.writeBool(z);
                nativeByteBuffer.writeString(overrideWallpaperInfo.slug);
                nativeByteBuffer.writeString(overrideWallpaperInfo.originalFileName);
                nativeByteBuffer.limit(nativeByteBuffer.position());
            } catch (Exception e2) {
                e = e2;
                nativeByteBuffer2 = nativeByteBuffer;
                FileLog.e(e);
                nativeByteBuffer = nativeByteBuffer2;
                j = getMessagesStorage().createPendingTask(nativeByteBuffer);
                getConnectionsManager().sendRequest(tLRPC$TL_account_saveWallPaper, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda235
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$saveWallpaperToServer$81(j, tLObject, tLRPC$TL_error);
                    }
                });
            }
            j = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_account_saveWallPaper, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda235
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$saveWallpaperToServer$81(j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveWallpaperToServer$81(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        getMessagesStorage().removePendingTask(j);
    }

    public static TLRPC$InputWallPaper getInputWallpaper(Theme.OverrideWallpaperInfo overrideWallpaperInfo) {
        if (overrideWallpaperInfo.wallpaperId > 0) {
            TLRPC$TL_inputWallPaper tLRPC$TL_inputWallPaper = new TLRPC$TL_inputWallPaper();
            tLRPC$TL_inputWallPaper.id = overrideWallpaperInfo.wallpaperId;
            tLRPC$TL_inputWallPaper.access_hash = overrideWallpaperInfo.accessHash;
            return tLRPC$TL_inputWallPaper;
        }
        TLRPC$TL_inputWallPaperSlug tLRPC$TL_inputWallPaperSlug = new TLRPC$TL_inputWallPaperSlug();
        tLRPC$TL_inputWallPaperSlug.slug = overrideWallpaperInfo.slug;
        return tLRPC$TL_inputWallPaperSlug;
    }

    public static TLRPC$TL_wallPaperSettings getWallpaperSetting(Theme.OverrideWallpaperInfo overrideWallpaperInfo) {
        TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings = new TLRPC$TL_wallPaperSettings();
        tLRPC$TL_wallPaperSettings.blur = overrideWallpaperInfo.isBlurred;
        tLRPC$TL_wallPaperSettings.motion = overrideWallpaperInfo.isMotion;
        int i = overrideWallpaperInfo.color;
        if (i != 0) {
            tLRPC$TL_wallPaperSettings.background_color = i & 16777215;
            int i2 = tLRPC$TL_wallPaperSettings.flags | 1;
            tLRPC$TL_wallPaperSettings.flags = i2;
            tLRPC$TL_wallPaperSettings.intensity = (int) (overrideWallpaperInfo.intensity * 100.0f);
            tLRPC$TL_wallPaperSettings.flags = i2 | 8;
        } else {
            float f = overrideWallpaperInfo.intensity;
            if (f > 0.0f) {
                tLRPC$TL_wallPaperSettings.intensity = (int) (f * 100.0f);
                tLRPC$TL_wallPaperSettings.flags |= 8;
            }
        }
        int i3 = overrideWallpaperInfo.gradientColor1;
        if (i3 != 0) {
            tLRPC$TL_wallPaperSettings.second_background_color = i3 & 16777215;
            tLRPC$TL_wallPaperSettings.rotation = AndroidUtilities.getWallpaperRotation(overrideWallpaperInfo.rotation, true);
            tLRPC$TL_wallPaperSettings.flags |= 16;
        }
        int i4 = overrideWallpaperInfo.gradientColor2;
        if (i4 != 0) {
            tLRPC$TL_wallPaperSettings.third_background_color = i4 & 16777215;
            tLRPC$TL_wallPaperSettings.flags |= 32;
        }
        int i5 = overrideWallpaperInfo.gradientColor3;
        if (i5 != 0) {
            tLRPC$TL_wallPaperSettings.fourth_background_color = i5 & 16777215;
            tLRPC$TL_wallPaperSettings.flags |= 64;
        }
        return tLRPC$TL_wallPaperSettings;
    }

    public void markDialogMessageAsDeleted(ArrayList<Long> arrayList, long j) {
        MessageObject messageObject = this.dialogMessage.get(j);
        if (messageObject != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (messageObject.getId() == arrayList.get(i).longValue()) {
                    messageObject.deleted = true;
                    return;
                }
            }
        }
    }

    public void deleteMessages(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, TLRPC$EncryptedChat tLRPC$EncryptedChat, long j, int i, boolean z, boolean z2) {
        deleteMessages(arrayList, arrayList2, tLRPC$EncryptedChat, j, i, z, z2, false, 0L, null);
    }

    public void deleteMessages(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, TLRPC$EncryptedChat tLRPC$EncryptedChat, long j, int i, boolean z, boolean z2, boolean z3) {
        deleteMessages(arrayList, arrayList2, tLRPC$EncryptedChat, j, i, z, z2, z3, 0L, null);
    }

    public void deleteMessages(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, TLRPC$EncryptedChat tLRPC$EncryptedChat, long j, int i, boolean z, boolean z2, boolean z3, long j2, TLObject tLObject) {
        ArrayList<Long> arrayList3;
        NativeByteBuffer nativeByteBuffer;
        NativeByteBuffer nativeByteBuffer2;
        NativeByteBuffer nativeByteBuffer3;
        NativeByteBuffer nativeByteBuffer4;
        NativeByteBuffer nativeByteBuffer5;
        NativeByteBuffer nativeByteBuffer6;
        NativeByteBuffer nativeByteBuffer7;
        final long jCreatePendingTask;
        TLRPC$TL_messages_deleteScheduledMessages tLRPC$TL_messages_deleteScheduledMessages;
        ArrayList<Long> arrayList4;
        char c;
        if ((arrayList == null || arrayList.isEmpty()) && j2 == 0) {
            return;
        }
        if (j2 == 0) {
            if (z3) {
                arrayList4 = null;
            } else {
                ArrayList<Long> arrayList5 = new ArrayList<>();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Long l = arrayList.get(i2);
                    if (l.longValue() > 0) {
                        arrayList5.add(l);
                    }
                }
                arrayList4 = arrayList5;
            }
            if (z2) {
                c = 1;
                getMessagesStorage().markMessagesAsDeleted(arrayList, true, i, false, true);
            } else {
                c = 1;
                if (i == 0) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        MessageObject messageObject = this.dialogMessagesByIds.get(arrayList.get(i3).longValue());
                        if (messageObject != null) {
                            messageObject.deleted = true;
                        }
                    }
                } else {
                    markDialogMessageAsDeleted(arrayList, -i);
                }
            }
            NotificationCenter notificationCenter = getNotificationCenter();
            int i4 = NotificationCenter.messagesDeleted;
            Object[] objArr = new Object[3];
            objArr[0] = arrayList;
            objArr[c] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(z2);
            notificationCenter.postNotificationName(i4, objArr);
            arrayList3 = arrayList4;
        } else {
            arrayList3 = null;
        }
        if (z3) {
            return;
        }
        if (z2) {
            if (tLObject != null) {
                tLRPC$TL_messages_deleteScheduledMessages = (TLRPC$TL_messages_deleteScheduledMessages) tLObject;
                jCreatePendingTask = j2;
            } else {
                TLRPC$TL_messages_deleteScheduledMessages tLRPC$TL_messages_deleteScheduledMessages2 = new TLRPC$TL_messages_deleteScheduledMessages();
                tLRPC$TL_messages_deleteScheduledMessages2.id = arrayList3;
                tLRPC$TL_messages_deleteScheduledMessages2.peer = getInputPeer((int) j);
                try {
                    nativeByteBuffer7 = new NativeByteBuffer(tLRPC$TL_messages_deleteScheduledMessages2.getObjectSize() + 16);
                } catch (Exception e) {
                    e = e;
                    nativeByteBuffer6 = null;
                }
                try {
                    nativeByteBuffer7.writeInt32(18);
                    nativeByteBuffer7.writeInt64(j);
                    nativeByteBuffer7.writeInt32(i);
                    tLRPC$TL_messages_deleteScheduledMessages2.serializeToStream(nativeByteBuffer7);
                } catch (Exception e2) {
                    e = e2;
                    nativeByteBuffer6 = nativeByteBuffer7;
                    FileLog.e(e);
                    nativeByteBuffer7 = nativeByteBuffer6;
                    jCreatePendingTask = getMessagesStorage().createPendingTask(nativeByteBuffer7);
                    tLRPC$TL_messages_deleteScheduledMessages = tLRPC$TL_messages_deleteScheduledMessages2;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_deleteScheduledMessages, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda234
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$deleteMessages$82(jCreatePendingTask, tLObject2, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                jCreatePendingTask = getMessagesStorage().createPendingTask(nativeByteBuffer7);
                tLRPC$TL_messages_deleteScheduledMessages = tLRPC$TL_messages_deleteScheduledMessages2;
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_deleteScheduledMessages, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda234
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$deleteMessages$82(jCreatePendingTask, tLObject2, tLRPC$TL_error);
                }
            });
            return;
        }
        if (i != 0) {
            if (tLObject != null) {
            } else {
                TLRPC$TL_channels_deleteMessages tLRPC$TL_channels_deleteMessages = new TLRPC$TL_channels_deleteMessages();
                tLRPC$TL_channels_deleteMessages.id = arrayList3;
                tLRPC$TL_channels_deleteMessages.channel = getInputChannel(i);
                try {
                    nativeByteBuffer5 = new NativeByteBuffer(tLRPC$TL_channels_deleteMessages.getObjectSize() + 8);
                } catch (Exception e3) {
                    e = e3;
                    nativeByteBuffer4 = null;
                }
                try {
                    nativeByteBuffer5.writeInt32(7);
                    nativeByteBuffer5.writeInt32(i);
                    tLRPC$TL_channels_deleteMessages.serializeToStream(nativeByteBuffer5);
                } catch (Exception e4) {
                    e = e4;
                    nativeByteBuffer4 = nativeByteBuffer5;
                    FileLog.e(e);
                    nativeByteBuffer5 = nativeByteBuffer4;
                    getMessagesStorage().createPendingTask(nativeByteBuffer5);
                    getMessagesProxy().deleteMessages(arrayList, arrayList3, true, j, z, false);
                    return;
                }
                getMessagesStorage().createPendingTask(nativeByteBuffer5);
            }
            getMessagesProxy().deleteMessages(arrayList, arrayList3, true, j, z, false);
            return;
        }
        if (arrayList2 == null || tLRPC$EncryptedChat == null || arrayList2.isEmpty()) {
            nativeByteBuffer = null;
        } else {
            nativeByteBuffer = null;
            getSecretChatHelper().sendMessagesDeleteMessage(tLRPC$EncryptedChat, arrayList2, null);
        }
        if (tLObject != null) {
        } else {
            TLRPC$TL_messages_deleteMessages tLRPC$TL_messages_deleteMessages = new TLRPC$TL_messages_deleteMessages();
            tLRPC$TL_messages_deleteMessages.id = arrayList3;
            tLRPC$TL_messages_deleteMessages.revoke = z;
            try {
                nativeByteBuffer3 = new NativeByteBuffer(tLRPC$TL_messages_deleteMessages.getObjectSize() + 8);
                try {
                    nativeByteBuffer3.writeInt32(7);
                    nativeByteBuffer3.writeInt32(i);
                    tLRPC$TL_messages_deleteMessages.serializeToStream(nativeByteBuffer3);
                } catch (Exception e5) {
                    e = e5;
                    nativeByteBuffer2 = nativeByteBuffer3;
                    FileLog.e(e);
                    nativeByteBuffer3 = nativeByteBuffer2;
                    getMessagesStorage().createPendingTask(nativeByteBuffer3);
                    getMessagesProxy().deleteMessages(arrayList, arrayList3, true, j, z, false);
                }
            } catch (Exception e6) {
                e = e6;
                nativeByteBuffer2 = nativeByteBuffer;
            }
            getMessagesStorage().createPendingTask(nativeByteBuffer3);
        }
        getMessagesProxy().deleteMessages(arrayList, arrayList3, true, j, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteMessages$82(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void unpinAllMessages(TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User) {
        if (tLRPC$Chat == null && tLRPC$User == null) {
            return;
        }
        TLRPC$TL_messages_unpinAllMessages tLRPC$TL_messages_unpinAllMessages = new TLRPC$TL_messages_unpinAllMessages();
        tLRPC$TL_messages_unpinAllMessages.peer = getInputPeer(tLRPC$Chat != null ? -tLRPC$Chat.id : tLRPC$User.id);
        getDialogsProxy().unpinAllMessages(tLRPC$TL_messages_unpinAllMessages, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda265
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$unpinAllMessages$83(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void pinMessage(TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, long j, boolean z, boolean z2, boolean z3) {
        if (tLRPC$Chat == null && tLRPC$User == null) {
            return;
        }
        TLRPC$TL_messages_updatePinnedMessage tLRPC$TL_messages_updatePinnedMessage = new TLRPC$TL_messages_updatePinnedMessage();
        tLRPC$TL_messages_updatePinnedMessage.peer = getInputPeer(tLRPC$Chat != null ? -tLRPC$Chat.id : tLRPC$User.id);
        tLRPC$TL_messages_updatePinnedMessage.id = j;
        tLRPC$TL_messages_updatePinnedMessage.unpin = z;
        tLRPC$TL_messages_updatePinnedMessage.silent = !z3;
        tLRPC$TL_messages_updatePinnedMessage.pm_oneside = z2;
        getMessagesProxy().pinMessage(tLRPC$TL_messages_updatePinnedMessage, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda264
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$pinMessage$84(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void deleteUserChannelHistory(final TLRPC$Chat tLRPC$Chat, final TLRPC$User tLRPC$User, int i) {
        if (i == 0) {
            getMessagesStorage().deleteUserChatHistory(-r0, tLRPC$Chat.id, tLRPC$User.id);
        }
        TLRPC$TL_channels_deleteUserHistory tLRPC$TL_channels_deleteUserHistory = new TLRPC$TL_channels_deleteUserHistory();
        tLRPC$TL_channels_deleteUserHistory.channel = getInputChannel(tLRPC$Chat);
        tLRPC$TL_channels_deleteUserHistory.user_id = getInputUser(tLRPC$User);
        getConnectionsManager().sendRequest(tLRPC$TL_channels_deleteUserHistory, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda247
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteUserChannelHistory$85(tLRPC$Chat, tLRPC$User, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteUserChannelHistory$85(TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedHistory tLRPC$TL_messages_affectedHistory = (TLRPC$TL_messages_affectedHistory) tLObject;
            int i = tLRPC$TL_messages_affectedHistory.offset;
            if (i > 0) {
                deleteUserChannelHistory(tLRPC$Chat, tLRPC$User, i);
            }
            processNewChannelDifferenceParams(tLRPC$TL_messages_affectedHistory.pts, tLRPC$TL_messages_affectedHistory.pts_count, tLRPC$Chat.id);
        }
    }

    public ArrayList<TLRPC$Dialog> getAllDialogs() {
        return this.allDialogs;
    }

    public boolean isDialogsEndReached(int i) {
        return this.dialogsEndReached.get(i);
    }

    public boolean isLoadingDialogs(int i) {
        return this.loadingDialogs.get(i);
    }

    public boolean isServerDialogsEndReached(int i) {
        return this.serverDialogsEndReached.get(i);
    }

    public boolean hasHiddenArchive() {
        return SharedConfig.archiveHidden && this.dialogs_dict.get(DialogObject.makeFolderDialogId(1)) != null;
    }

    public ArrayList<TLRPC$Dialog> getDialogs(int i) {
        ArrayList<TLRPC$Dialog> arrayList = this.dialogsByFolder.get(i);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public int getTotalDialogsCount() {
        ArrayList<TLRPC$Dialog> arrayList = this.dialogsByFolder.get(0);
        if (arrayList != null) {
            return 0 + arrayList.size();
        }
        return 0;
    }

    public void putAllNeededDraftDialogs() {
        LongSparseArray<LongSparseArray<TLRPC$DraftMessage>> drafts = getMediaDataController().getDrafts();
        int size = drafts.size();
        for (int i = 0; i < size; i++) {
            TLRPC$DraftMessage tLRPC$DraftMessage = drafts.valueAt(i).get(0L);
            if (tLRPC$DraftMessage != null) {
                putDraftDialogIfNeed(drafts.keyAt(i), tLRPC$DraftMessage);
            }
        }
    }

    public void putDraftDialogIfNeed(long j, TLRPC$DraftMessage tLRPC$DraftMessage) {
        String str;
        if (this.dialogs_dict.indexOfKey(j) >= 0 || IdStorage.getInstance().getDialogId(j) == null) {
            return;
        }
        MediaDataController mediaDataController = getMediaDataController();
        int size = this.allDialogs.size();
        if (size > 0) {
            TLRPC$Dialog tLRPC$Dialog = this.allDialogs.get(size - 1);
            if (tLRPC$DraftMessage.date < DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog, mediaDataController.getDraft(tLRPC$Dialog.id, 0L))) {
                return;
            }
        }
        TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
        tLRPC$TL_dialog.id = j;
        tLRPC$TL_dialog.draft = tLRPC$DraftMessage;
        tLRPC$TL_dialog.folder_id = mediaDataController.getDraftFolderId(j);
        tLRPC$TL_dialog.flags = (j >= 0 || !ChatObject.isChannel(getChat(Integer.valueOf((int) (-j))))) ? 0 : 1;
        if (this.dialogs_dict != null) {
            str = this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        } else {
            str = "null";
        }
        FirebaseEventSender.setKey("dialogs_dictput11", str);
        this.dialogs_dict.put(j, tLRPC$TL_dialog);
        this.allDialogs.add(tLRPC$TL_dialog);
        sortDialogs(null);
    }

    public void removeDraftDialogIfNeed(long j) {
        String str;
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        if (tLRPC$Dialog == null || tLRPC$Dialog.top_message != 0) {
            return;
        }
        if (this.dialogs_dict != null) {
            str = this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        } else {
            str = "null";
        }
        FirebaseEventSender.setKey("dialogs_dict_remove2", str);
        this.dialogs_dict.remove(tLRPC$Dialog.id);
        this.allDialogs.remove(tLRPC$Dialog);
    }

    public void removeDialog(TLRPC$Dialog tLRPC$Dialog) {
        String str;
        if (tLRPC$Dialog == null) {
            return;
        }
        final long j = tLRPC$Dialog.id;
        if (this.dialogsServerOnly.remove(tLRPC$Dialog) && DialogObject.isChannel(tLRPC$Dialog)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda62
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDialog$86(j);
                }
            });
        }
        this.allDialogs.remove(tLRPC$Dialog);
        this.dialogsCanAddUsers.remove(tLRPC$Dialog);
        this.dialogsChannelsOnly.remove(tLRPC$Dialog);
        this.dialogsGroupsOnly.remove(tLRPC$Dialog);
        this.dialogsUsersOnly.remove(tLRPC$Dialog);
        this.dialogsForBlock.remove(tLRPC$Dialog);
        this.dialogsForward.remove(tLRPC$Dialog);
        int i = 0;
        while (true) {
            DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
            if (i >= dialogFilterArr.length) {
                break;
            }
            if (dialogFilterArr[i] != null) {
                dialogFilterArr[i].dialogs.remove(tLRPC$Dialog);
            }
            i++;
        }
        if (this.dialogs_dict != null) {
            str = this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        } else {
            str = "null";
        }
        FirebaseEventSender.setKey("dialogs_dict_remove3", str);
        this.dialogs_dict.remove(j);
        ArrayList<TLRPC$Dialog> arrayList = this.dialogsByFolder.get(tLRPC$Dialog.folder_id);
        if (arrayList != null) {
            arrayList.remove(tLRPC$Dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeDialog$86(long j) {
        int i = -((int) j);
        this.channelsPts.delete(i);
        this.shortPollChannels.delete(i);
        this.needShortPollChannels.delete(i);
        this.shortPollOnlines.delete(i);
        this.needShortPollOnlines.delete(i);
    }

    public void hidePromoDialog() {
        if (this.promoDialog == null) {
            return;
        }
        TLRPC$TL_help_hidePromoData tLRPC$TL_help_hidePromoData = new TLRPC$TL_help_hidePromoData();
        tLRPC$TL_help_hidePromoData.peer = getInputPeer((int) this.promoDialog.id);
        getConnectionsManager().sendRequest(tLRPC$TL_help_hidePromoData, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda269
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$hidePromoDialog$87(tLObject, tLRPC$TL_error);
            }
        });
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hidePromoDialog$88();
            }
        });
        removePromoDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hidePromoDialog$88() {
        this.promoDialogId = 0L;
        this.proxyDialogAddress = null;
        this.nextPromoInfoCheckTime = getConnectionsManager().getCurrentTime() + 3600;
        getGlobalMainSettings().edit().putLong("proxy_dialog", this.promoDialogId).remove("proxyDialogAddress").putInt("nextPromoInfoCheckTime", this.nextPromoInfoCheckTime).apply();
    }

    public void deleteDialog(long j, int i) {
        deleteDialog(j, i, false);
    }

    public void deleteDialog(long j, int i, boolean z) {
        deleteDialog(j, 1, i, 0L, z, null, 0L);
    }

    public void setDialogHistoryTTL(long j, int i) {
        TLRPC$UserFull userFull;
        TLRPC$TL_messages_setHistoryTTL tLRPC$TL_messages_setHistoryTTL = new TLRPC$TL_messages_setHistoryTTL();
        int i2 = (int) j;
        tLRPC$TL_messages_setHistoryTTL.peer = getInputPeer(i2);
        tLRPC$TL_messages_setHistoryTTL.period = i;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_setHistoryTTL, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda201
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setDialogHistoryTTL$89(tLObject, tLRPC$TL_error);
            }
        });
        TLRPC$ChatFull tLRPC$ChatFull = null;
        if (i2 > 0) {
            userFull = getUserFull(i2);
            if (userFull == null) {
                return;
            }
            userFull.ttl_period = i;
            userFull.flags |= LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
        } else {
            TLRPC$ChatFull chatFull = getChatFull(-i2);
            if (chatFull == null) {
                return;
            }
            chatFull.ttl_period = i;
            if (chatFull instanceof TLRPC$TL_channelFull) {
                chatFull.flags |= ConnectionsManager.FileTypePhoto;
            } else {
                chatFull.flags |= LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
            }
            userFull = null;
            tLRPC$ChatFull = chatFull;
        }
        if (tLRPC$ChatFull != null) {
            NotificationCenter notificationCenter = getNotificationCenter();
            int i3 = NotificationCenter.chatInfoDidLoad;
            Boolean bool = Boolean.FALSE;
            notificationCenter.postNotificationName(i3, tLRPC$ChatFull, 0, bool, bool);
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.userInfoDidLoad, Integer.valueOf(i2), userFull);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDialogHistoryTTL$89(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public void setDialogsInTransaction(boolean z) {
        this.dialogsInTransaction = z;
        if (z) {
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void deleteDialog(final long r23, int r25, final int r26, long r27, final boolean r29, final org.rbmain.tgnet.TLRPC$InputPeer r30, final long r31) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.deleteDialog(long, int, int, long, boolean, org.rbmain.tgnet.TLRPC$InputPeer, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialog$90(long j, int i, boolean z, TLRPC$InputPeer tLRPC$InputPeer, long j2, long j3) {
        deleteDialog(j, 2, i, Math.max(0L, j3), z, tLRPC$InputPeer, j2);
        checkIfFolderEmpty(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialog$91(long j) {
        getNotificationsController().removeNotificationsForDialog(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialog$92(final long j) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda63
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteDialog$91(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialog$93(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialog$95(long j, final long j2, final int i, final long j3, final boolean z, final TLRPC$InputPeer tLRPC$InputPeer, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedHistory tLRPC$TL_messages_affectedHistory = (TLRPC$TL_messages_affectedHistory) tLObject;
            if (tLRPC$TL_messages_affectedHistory.offset > 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda64
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$deleteDialog$94(j2, i, j3, z, tLRPC$InputPeer);
                    }
                });
            }
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedHistory.pts, -1, tLRPC$TL_messages_affectedHistory.pts_count);
            getMessagesStorage().onDeleteQueryComplete(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialog$94(long j, int i, long j2, boolean z, TLRPC$InputPeer tLRPC$InputPeer) {
        deleteDialog(j, 0, i, j2, z, tLRPC$InputPeer, 0L);
    }

    public void saveGif(final Object obj, TLRPC$Document tLRPC$Document) {
        if (obj == null || !MessageObject.isGifDocument(tLRPC$Document)) {
            return;
        }
        final TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif = new TLRPC$TL_messages_saveGif();
        TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
        tLRPC$TL_messages_saveGif.id = tLRPC$TL_inputDocument;
        tLRPC$TL_inputDocument.id = tLRPC$Document.id;
        tLRPC$TL_inputDocument.access_hash = tLRPC$Document.access_hash;
        byte[] bArr = tLRPC$Document.file_reference;
        tLRPC$TL_inputDocument.file_reference = bArr;
        if (bArr == null) {
            tLRPC$TL_inputDocument.file_reference = new byte[0];
        }
        tLRPC$TL_messages_saveGif.unsave = false;
        if (obj instanceof MessageObject) {
            tLRPC$TL_messages_saveGif.message = ((MessageObject) obj).messageOwner;
        }
        getMessagesProxy().saveGif(tLRPC$TL_messages_saveGif, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda242
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$saveGif$96(obj, tLRPC$TL_messages_saveGif, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveGif$96(Object obj, TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || !FileRefController.isFileRefError(tLRPC$TL_error.text)) {
            return;
        }
        getFileRefController().requestReference(obj, tLRPC$TL_messages_saveGif);
    }

    public void saveRecentSticker(final Object obj, TLRPC$Document tLRPC$Document, boolean z) {
        if (obj == null || tLRPC$Document == null) {
            return;
        }
        final TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker = new TLRPC$TL_messages_saveRecentSticker();
        TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
        tLRPC$TL_messages_saveRecentSticker.id = tLRPC$TL_inputDocument;
        tLRPC$TL_inputDocument.id = tLRPC$Document.id;
        tLRPC$TL_inputDocument.access_hash = tLRPC$Document.access_hash;
        byte[] bArr = tLRPC$Document.file_reference;
        tLRPC$TL_inputDocument.file_reference = bArr;
        if (bArr == null) {
            tLRPC$TL_inputDocument.file_reference = new byte[0];
        }
        tLRPC$TL_messages_saveRecentSticker.unsave = false;
        tLRPC$TL_messages_saveRecentSticker.attached = z;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_saveRecentSticker, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda243
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$saveRecentSticker$97(obj, tLRPC$TL_messages_saveRecentSticker, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveRecentSticker$97(Object obj, TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || !FileRefController.isFileRefError(tLRPC$TL_error.text)) {
            return;
        }
        getFileRefController().requestReference(obj, tLRPC$TL_messages_saveRecentSticker);
    }

    public void putChatFull(TLRPC$ChatFull tLRPC$ChatFull) {
        this.fullChats.put(tLRPC$ChatFull.id, tLRPC$ChatFull);
    }

    public void processChatInfo(final int i, final TLRPC$ChatFull tLRPC$ChatFull, final ArrayList<TLRPC$User> arrayList, final boolean z, final boolean z2, final boolean z3, final ArrayList<Long> arrayList2, final HashMap<Long, MessageObject> map, final int i2, final boolean z4) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda170
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processChatInfo$98(z, i, z3, z2, tLRPC$ChatFull, arrayList, arrayList2, map, i2, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processChatInfo$98(boolean z, int i, boolean z2, boolean z3, TLRPC$ChatFull tLRPC$ChatFull, ArrayList arrayList, ArrayList arrayList2, HashMap map, int i2, boolean z4) {
        if (z && i > 0 && !z2) {
            loadFullChat(i, 0, z3);
        }
        if (tLRPC$ChatFull != null) {
            if (this.fullChats.get(i) == null) {
                this.fullChats.put(i, tLRPC$ChatFull);
            }
            putUsers(arrayList, z);
            if (tLRPC$ChatFull.stickerset != null) {
                getMediaDataController().getGroupStickerSetById(tLRPC$ChatFull.stickerset);
            }
            getNotificationCenter().postNotificationName(NotificationCenter.chatInfoDidLoad, tLRPC$ChatFull, 0, Boolean.valueOf(z2), Boolean.FALSE);
        }
        if (arrayList2 != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.pinnedInfoDidLoad, Long.valueOf(-i), arrayList2, map, Integer.valueOf(i2), Boolean.valueOf(z4));
        }
    }

    public void loadUserInfo(TLRPC$User tLRPC$User, boolean z, int i) {
        loadUserInfo(tLRPC$User, z, i, 0L);
    }

    public void loadUserInfo(TLRPC$User tLRPC$User, boolean z, int i, long j) {
        loadFullUser(tLRPC$User, i, z);
    }

    public void processUserInfo(final TLRPC$User tLRPC$User, final TLRPC$UserFull tLRPC$UserFull, final boolean z, final boolean z2, final int i, final ArrayList<Long> arrayList, final HashMap<Long, MessageObject> map, final int i2, final boolean z3) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda172
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUserInfo$99(z, tLRPC$User, i, z2, tLRPC$UserFull, arrayList, map, i2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUserInfo$99(boolean z, TLRPC$User tLRPC$User, int i, boolean z2, TLRPC$UserFull tLRPC$UserFull, ArrayList arrayList, HashMap map, int i2, boolean z3) {
        if (z) {
            loadFullUser(tLRPC$User, i, z2);
        }
        if (tLRPC$UserFull != null) {
            if (this.fullUsers.get(tLRPC$User.id) == null) {
                this.fullUsers.put(tLRPC$User.id, tLRPC$UserFull);
                if (tLRPC$UserFull.blocked) {
                    this.blockePeers.put(tLRPC$User.id, 1);
                } else {
                    this.blockePeers.delete(tLRPC$User.id);
                }
            }
            getNotificationCenter().postNotificationName(NotificationCenter.userInfoDidLoad, Integer.valueOf(tLRPC$User.id), tLRPC$UserFull);
        }
        if (arrayList != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.pinnedInfoDidLoad, Long.valueOf(tLRPC$User.id), arrayList, map, Integer.valueOf(i2), Boolean.valueOf(z3));
        }
    }

    public void updateTimerProc() {
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        checkDeletingTask(false);
        checkReadTasks();
        int currentTime = getConnectionsManager().getCurrentTime();
        if (!this.onlinePrivacy.isEmpty()) {
            ArrayList arrayList2 = null;
            for (Map.Entry<Integer, Integer> entry : this.onlinePrivacy.entrySet()) {
                if (entry.getValue().intValue() < currentTime - 30) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(entry.getKey());
                }
            }
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    this.onlinePrivacy.remove((Integer) it.next());
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda15
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateTimerProc$100();
                    }
                });
            }
        }
        if (this.printingUsers.isEmpty() && this.lastPrintingStringCount == this.printingUsers.size()) {
            i = 1;
        } else {
            ArrayList arrayList3 = new ArrayList(this.printingUsers.keySet());
            int i4 = 0;
            boolean z = false;
            while (i4 < arrayList3.size()) {
                Long l = (Long) arrayList3.get(i4);
                ConcurrentHashMap<Long, ArrayList<PrintingUser>> concurrentHashMap = this.printingUsers.get(l);
                if (concurrentHashMap != null) {
                    ArrayList arrayList4 = new ArrayList(concurrentHashMap.keySet());
                    int i5 = 0;
                    while (i5 < arrayList4.size()) {
                        Long l2 = (Long) arrayList4.get(i5);
                        ArrayList<PrintingUser> arrayList5 = concurrentHashMap.get(l2);
                        if (arrayList5 != null) {
                            int i6 = 0;
                            while (i6 < arrayList5.size()) {
                                PrintingUser printingUser = arrayList5.get(i6);
                                int i7 = i4;
                                ArrayList arrayList6 = arrayList3;
                                if (printingUser.lastTime + (printingUser.action instanceof TLRPC$TL_sendMessageGamePlayAction ? 30000 : 5900) < jCurrentTimeMillis) {
                                    arrayList5.remove(printingUser);
                                    i6--;
                                    i3 = 1;
                                    z = true;
                                } else {
                                    i3 = 1;
                                }
                                i6 += i3;
                                i4 = i7;
                                arrayList3 = arrayList6;
                            }
                        }
                        ArrayList arrayList7 = arrayList3;
                        int i8 = i4;
                        if (arrayList5 == null || arrayList5.isEmpty()) {
                            concurrentHashMap.remove(l2);
                            arrayList4.remove(i5);
                            i5--;
                        }
                        i5++;
                        i4 = i8;
                        arrayList3 = arrayList7;
                    }
                }
                ArrayList arrayList8 = arrayList3;
                int i9 = i4;
                if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
                    this.printingUsers.remove(l);
                    arrayList = arrayList8;
                    arrayList.remove(i9);
                    i2 = i9 - 1;
                } else {
                    i2 = i9;
                    arrayList = arrayList8;
                }
                i4 = i2 + 1;
                arrayList3 = arrayList;
            }
            i = 1;
            updatePrintingStrings();
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateTimerProc$101();
                    }
                });
            }
        }
        if (Theme.selectedAutoNightType == i && Math.abs(jCurrentTimeMillis - lastThemeCheckTime) >= 60) {
            AndroidUtilities.runOnUIThread(this.themeCheckRunnable);
            lastThemeCheckTime = jCurrentTimeMillis;
        }
        if (getUserConfig().savedPasswordHash != null && Math.abs(jCurrentTimeMillis - lastPasswordCheckTime) >= 60) {
            AndroidUtilities.runOnUIThread(this.passwordCheckRunnable);
            lastPasswordCheckTime = jCurrentTimeMillis;
        }
        getLocationController().update();
        lambda$checkPromoInfo$102(false);
        checkTosUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTimerProc$100() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTimerProc$101() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 64);
    }

    public void checkPromoInfo(final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda168
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkPromoInfo$102(z);
            }
        });
    }

    private void removePromoDialog() {
        TLRPC$Dialog tLRPC$Dialog = this.promoDialog;
        if (tLRPC$Dialog == null) {
            return;
        }
        int i = (int) tLRPC$Dialog.id;
        if (i < 0) {
            TLRPC$Chat chat = getChat(Integer.valueOf(-i));
            if (ChatObject.isNotInChat(chat) || chat.restricted) {
                removeDialog(this.promoDialog);
            }
        } else {
            removeDialog(tLRPC$Dialog);
        }
        this.promoDialog = null;
        sortDialogs(null);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    public boolean isPromoDialog(long j, boolean z) {
        TLRPC$Dialog tLRPC$Dialog = this.promoDialog;
        return tLRPC$Dialog != null && tLRPC$Dialog.id == j && (!z || this.isLeftPromoChannel);
    }

    private String getUserNameForTyping(TLRPC$User tLRPC$User) {
        if (tLRPC$User == null) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        String str = tLRPC$User.first_name;
        if (str != null && str.length() > 0) {
            return tLRPC$User.first_name;
        }
        String str2 = tLRPC$User.last_name;
        return (str2 == null || str2.length() <= 0) ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : tLRPC$User.last_name;
    }

    public void updatePrintingStrings() {
        Iterator<Map.Entry<Long, ConcurrentHashMap<Long, ArrayList<PrintingUser>>>> it;
        int i;
        int i2;
        int i3;
        final LongSparseArray longSparseArray = new LongSparseArray();
        final LongSparseArray longSparseArray2 = new LongSparseArray();
        Iterator<Map.Entry<Long, ConcurrentHashMap<Long, ArrayList<PrintingUser>>>> it2 = this.printingUsers.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<Long, ConcurrentHashMap<Long, ArrayList<PrintingUser>>> next = it2.next();
            Long key = next.getKey();
            ConcurrentHashMap<Long, ArrayList<PrintingUser>> value = next.getValue();
            int iLongValue = (int) key.longValue();
            for (Map.Entry<Long, ArrayList<PrintingUser>> entry : value.entrySet()) {
                Long key2 = entry.getKey();
                ArrayList<PrintingUser> value2 = entry.getValue();
                LongSparseArray longSparseArray3 = new LongSparseArray();
                LongSparseArray longSparseArray4 = new LongSparseArray();
                longSparseArray.put(key.longValue(), longSparseArray3);
                longSparseArray2.put(key.longValue(), longSparseArray4);
                if (iLongValue > 0 || iLongValue == 0 || value2.size() == 1) {
                    it = it2;
                    PrintingUser printingUser = value2.get(0);
                    TLRPC$User user = getUser(Integer.valueOf(printingUser.userId));
                    if (user != null) {
                        TLRPC$SendMessageAction tLRPC$SendMessageAction = printingUser.action;
                        if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageRecordAudioAction) {
                            if (iLongValue < 0) {
                                longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsRecordingAudio", ir.medu.shad.R.string.IsRecordingAudio, getUserNameForTyping(user)));
                            } else {
                                longSparseArray3.put(key2.longValue(), LocaleController.getString("RecordingAudio", ir.medu.shad.R.string.RecordingAudio));
                            }
                            longSparseArray4.put(key2.longValue(), 1);
                        } else if ((tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageRecordRoundAction) || (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadRoundAction)) {
                            if (iLongValue < 0) {
                                longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsRecordingRound", ir.medu.shad.R.string.IsRecordingRound, getUserNameForTyping(user)));
                            } else {
                                longSparseArray3.put(key2.longValue(), LocaleController.getString("RecordingRound", ir.medu.shad.R.string.RecordingRound));
                            }
                            longSparseArray4.put(key2.longValue(), 4);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadAudioAction) {
                            if (iLongValue < 0) {
                                longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsSendingAudio", ir.medu.shad.R.string.IsSendingAudio, getUserNameForTyping(user)));
                            } else {
                                longSparseArray3.put(key2.longValue(), LocaleController.getString("SendingAudio", ir.medu.shad.R.string.SendingAudio));
                            }
                            longSparseArray4.put(key2.longValue(), 2);
                        } else if ((tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadVideoAction) || (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageRecordVideoAction)) {
                            if (iLongValue < 0) {
                                longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsSendingVideo", ir.medu.shad.R.string.IsSendingVideo, getUserNameForTyping(user)));
                            } else {
                                longSparseArray3.put(key2.longValue(), LocaleController.getString("SendingVideoStatus", ir.medu.shad.R.string.SendingVideoStatus));
                            }
                            longSparseArray4.put(key2.longValue(), 2);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadDocumentAction) {
                            if (iLongValue < 0) {
                                longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsSendingFile", ir.medu.shad.R.string.IsSendingFile, getUserNameForTyping(user)));
                            } else {
                                longSparseArray3.put(key2.longValue(), LocaleController.getString("SendingFile", ir.medu.shad.R.string.SendingFile));
                            }
                            longSparseArray4.put(key2.longValue(), 2);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadPhotoAction) {
                            if (iLongValue < 0) {
                                longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsSendingPhoto", ir.medu.shad.R.string.IsSendingPhoto, getUserNameForTyping(user)));
                            } else {
                                longSparseArray3.put(key2.longValue(), LocaleController.getString("SendingPhoto", ir.medu.shad.R.string.SendingPhoto));
                            }
                            longSparseArray4.put(key2.longValue(), 2);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageGamePlayAction) {
                            if (iLongValue < 0) {
                                longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsSendingGame", ir.medu.shad.R.string.IsSendingGame, getUserNameForTyping(user)));
                            } else {
                                longSparseArray3.put(key2.longValue(), LocaleController.getString("SendingGame", ir.medu.shad.R.string.SendingGame));
                            }
                            longSparseArray4.put(key2.longValue(), 3);
                        } else {
                            if (iLongValue < 0) {
                                i = 0;
                                longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsTypingGroup", ir.medu.shad.R.string.IsTypingGroup, getUserNameForTyping(user)));
                            } else {
                                i = 0;
                                longSparseArray3.put(key2.longValue(), LocaleController.getString("Typing", ir.medu.shad.R.string.Typing));
                            }
                            longSparseArray4.put(key2.longValue(), Integer.valueOf(i));
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    Iterator<PrintingUser> it3 = value2.iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            i2 = i4;
                            break;
                        }
                        TLRPC$User user2 = getUser(Integer.valueOf(it3.next().userId));
                        if (user2 != null) {
                            if (sb.length() != 0) {
                                sb.append(", ");
                            }
                            sb.append(getUserNameForTyping(user2));
                            i4++;
                        }
                        i2 = i4;
                        if (i2 == 2) {
                            break;
                        } else {
                            i4 = i2;
                        }
                    }
                    if (sb.length() != 0) {
                        if (i2 == 1) {
                            longSparseArray3.put(key2.longValue(), LocaleController.formatString("IsTypingGroup", ir.medu.shad.R.string.IsTypingGroup, sb.toString()));
                            it = it2;
                        } else if (value2.size() > 2) {
                            String pluralString = LocaleController.getPluralString("AndMoreTypingGroup", value2.size() - 2);
                            try {
                                it = it2;
                                try {
                                    longSparseArray3.put(key2.longValue(), String.format(pluralString, sb.toString(), Integer.valueOf(value2.size() - 2)));
                                } catch (Exception unused) {
                                    longSparseArray3.put(key2.longValue(), "LOC_ERR: AndMoreTypingGroup");
                                    i3 = 0;
                                    longSparseArray4.put(key2.longValue(), Integer.valueOf(i3));
                                    it2 = it;
                                }
                            } catch (Exception unused2) {
                                it = it2;
                            }
                        } else {
                            it = it2;
                            i3 = 0;
                            longSparseArray3.put(key2.longValue(), LocaleController.formatString("AreTypingGroup", ir.medu.shad.R.string.AreTypingGroup, sb.toString()));
                            longSparseArray4.put(key2.longValue(), Integer.valueOf(i3));
                        }
                        i3 = 0;
                        longSparseArray4.put(key2.longValue(), Integer.valueOf(i3));
                    } else {
                        it = it2;
                    }
                }
                it2 = it;
            }
        }
        this.lastPrintingStringCount = longSparseArray.size();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda79
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updatePrintingStrings$103(longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePrintingStrings$103(LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        this.printingStrings = longSparseArray;
        this.printingStringsTypes = longSparseArray2;
    }

    /* renamed from: cancelTyping, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$sendTyping$106(int i, long j, long j2) {
        LongSparseArray<LongSparseArray<Boolean>> longSparseArray;
        LongSparseArray<Boolean> longSparseArray2;
        if (i >= 0) {
            LongSparseArray<LongSparseArray<Boolean>>[] longSparseArrayArr = this.sendingTypings;
            if (i >= longSparseArrayArr.length || longSparseArrayArr[i] == null || (longSparseArray2 = (longSparseArray = longSparseArrayArr[i]).get(j)) == null) {
                return;
            }
            longSparseArray2.remove(j2);
            if (longSparseArray2.size() == 0) {
                longSparseArray.remove(j);
            }
        }
    }

    public boolean sendTyping(final long j, final long j2, final int i, int i2) {
        TLRPC$Chat chat;
        if (i < 0 || i >= this.sendingTypings.length || j == 0) {
            return false;
        }
        int i3 = (int) j;
        if (i3 < 0) {
            if (ChatObject.shouldSendAnonymously(getChat(Integer.valueOf(-i3)))) {
                return false;
            }
        } else {
            TLRPC$User user = getUser(Integer.valueOf(i3));
            if (user != null) {
                if (user.id == getUserConfig().getClientUserId()) {
                    return false;
                }
                TLRPC$UserStatus tLRPC$UserStatus = user.status;
                if (tLRPC$UserStatus != null && tLRPC$UserStatus.expires != -100 && !this.onlinePrivacy.containsKey(Integer.valueOf(user.id))) {
                    if (user.status.expires <= getConnectionsManager().getCurrentTime() - 120) {
                        return false;
                    }
                }
            }
        }
        LongSparseArray<LongSparseArray<Boolean>>[] longSparseArrayArr = this.sendingTypings;
        LongSparseArray<LongSparseArray<Boolean>> longSparseArray = longSparseArrayArr[i];
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray<>();
            longSparseArrayArr[i] = longSparseArray;
        }
        LongSparseArray<Boolean> longSparseArray2 = longSparseArray.get(j);
        if (longSparseArray2 == null) {
            longSparseArray2 = new LongSparseArray<>();
            longSparseArray.put(j, longSparseArray2);
        }
        if (longSparseArray2.get(j2) != null) {
            return false;
        }
        int i4 = (int) (j >> 32);
        if (i3 != 0) {
            TLRPC$TL_messages_setTyping tLRPC$TL_messages_setTyping = new TLRPC$TL_messages_setTyping();
            if (j2 != 0) {
                tLRPC$TL_messages_setTyping.top_msg_id = j2;
                tLRPC$TL_messages_setTyping.flags |= 1;
            }
            TLRPC$InputPeer inputPeer = getInputPeer(i3);
            tLRPC$TL_messages_setTyping.peer = inputPeer;
            if (((inputPeer instanceof TLRPC$TL_inputPeerChannel) && ((chat = getChat(Integer.valueOf(inputPeer.channel_id))) == null || !chat.megagroup)) || tLRPC$TL_messages_setTyping.peer == null) {
                return false;
            }
            if (i == 0) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageTypingAction();
            } else if (i == 1) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageRecordAudioAction();
            } else if (i == 2) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageCancelAction();
            } else if (i == 3) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadDocumentAction();
            } else if (i == 4) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadPhotoAction();
            } else if (i == 5) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadVideoAction();
            } else if (i == 6) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageGamePlayAction();
            } else if (i == 7) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageRecordRoundAction();
            } else if (i == 8) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadRoundAction();
            } else if (i == 9) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadAudioAction();
            }
            longSparseArray2.put(j2, Boolean.TRUE);
            int iSendChatAction = getDialogsProxy().sendChatAction(tLRPC$TL_messages_setTyping, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda219
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$sendTyping$105(i, j, j2, tLObject, tLRPC$TL_error);
                }
            });
            if (i2 != 0) {
                getConnectionsManager().bindRequestToGuid(iSendChatAction, i2);
            }
        } else {
            if (i != 0) {
                return false;
            }
            TLRPC$EncryptedChat encryptedChat = getEncryptedChat(Integer.valueOf(i4));
            byte[] bArr = encryptedChat.auth_key;
            if (bArr != null && bArr.length > 1 && (encryptedChat instanceof TLRPC$TL_encryptedChat)) {
                TLRPC$TL_messages_setEncryptedTyping tLRPC$TL_messages_setEncryptedTyping = new TLRPC$TL_messages_setEncryptedTyping();
                TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat = new TLRPC$TL_inputEncryptedChat();
                tLRPC$TL_messages_setEncryptedTyping.peer = tLRPC$TL_inputEncryptedChat;
                tLRPC$TL_inputEncryptedChat.chat_id = encryptedChat.id;
                tLRPC$TL_inputEncryptedChat.access_hash = encryptedChat.access_hash;
                tLRPC$TL_messages_setEncryptedTyping.typing = true;
                longSparseArray2.put(j2, Boolean.TRUE);
                int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_setEncryptedTyping, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda218
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$sendTyping$107(i, j, j2, tLObject, tLRPC$TL_error);
                    }
                }, 2);
                if (i2 != 0) {
                    getConnectionsManager().bindRequestToGuid(iSendRequest, i2);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendTyping$105(final int i, final long j, final long j2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendTyping$104(i, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendTyping$107(final int i, final long j, final long j2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda50
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendTyping$106(i, j, j2);
            }
        });
    }

    protected void removeDeletedMessagesFromArray(long j, ArrayList<TLRPC$Message> arrayList) {
        long jLongValue = this.deletedHistory.get(j, 0L).longValue();
        if (jLongValue == 0) {
            return;
        }
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            if (arrayList.get(i).id <= jLongValue) {
                arrayList.remove(i);
                i--;
                size--;
            }
            i++;
        }
    }

    public void loadMessages(long j, long j2, boolean z, int i, long j3, int i2, boolean z2, int i3, int i4, int i5, long j4, boolean z3, int i6, long j5, long j6, int i7) {
        loadMessages(j, j2, z, i, j3, i2, z2, i3, i4, i5, j4, z3, i6, j5, i7, j5 != 0 ? j6 : 0L, 0, 0, false, 0);
    }

    public void loadMessages(long j, long j2, boolean z, int i, long j3, int i2, boolean z2, int i3, int i4, int i5, long j4, boolean z3, int i6, long j5, int i7, long j6, int i8, int i9, boolean z4, int i10) {
        loadMessagesInternal(j, j2, z, i, j3, i2, z2, i3, i4, i5, j4, z3, i6, j5, i7, j6, i8, i9, z4, i10, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMessagesInternal(long j, long j2, boolean z, int i, long j3, int i2, boolean z2, int i3, int i4, int i5, long j4, boolean z3, int i6, long j5, int i7, long j6, int i8, int i9, boolean z4, int i10, boolean z5, boolean z6) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("load messages in chat " + j + " count " + i + " max_id " + j3 + " cache " + z2 + " mindate = " + i3 + " guid " + i4 + " load_type " + i5 + " last_message_id " + j4 + " mode " + i6 + " index " + i7 + " firstUnread " + j6 + " unread_count " + i8 + " last_date " + i9 + " queryFromServer " + z4);
        }
        getMessagesProxy().loadMessagesInternal(j, j2, z, i, j3, i2, z2, i3, i4, i5, j4, z3, i6, j5, i7, j6, i8, i9, z4, i10, z5, z6);
    }

    public void reloadWebPages(final long j, HashMap<String, ArrayList<MessageObject>> map, final boolean z) {
        final HashMap<String, ArrayList<MessageObject>> map2 = z ? this.reloadingScheduledWebpages : this.reloadingWebpages;
        final LongSparseArray<ArrayList<MessageObject>> longSparseArray = z ? this.reloadingScheduledWebpagesPending : this.reloadingWebpagesPending;
        for (Map.Entry<String, ArrayList<MessageObject>> entry : map.entrySet()) {
            final String key = entry.getKey();
            ArrayList<MessageObject> value = entry.getValue();
            ArrayList<MessageObject> arrayList = map2.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map2.put(key, arrayList);
            }
            arrayList.addAll(value);
            TLRPC$TL_messages_getWebPagePreview tLRPC$TL_messages_getWebPagePreview = new TLRPC$TL_messages_getWebPagePreview();
            tLRPC$TL_messages_getWebPagePreview.message = key;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getWebPagePreview, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda246
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$reloadWebPages$109(map2, key, longSparseArray, j, z, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadWebPages$109(final HashMap map, final String str, final LongSparseArray longSparseArray, final long j, final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda109
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reloadWebPages$108(map, str, tLObject, longSparseArray, j, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadWebPages$108(HashMap map, String str, TLObject tLObject, LongSparseArray longSparseArray, long j, boolean z) {
        ArrayList arrayList = (ArrayList) map.remove(str);
        if (arrayList == null) {
            return;
        }
        TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
        if (!(tLObject instanceof TLRPC$TL_messageMediaWebPage)) {
            for (int i = 0; i < arrayList.size(); i++) {
                ((MessageObject) arrayList.get(i)).messageOwner.media.webpage = new TLRPC$TL_webPageEmpty();
                tLRPC$TL_messages_messages.messages.add(((MessageObject) arrayList.get(i)).messageOwner);
            }
        } else {
            TLRPC$TL_messageMediaWebPage tLRPC$TL_messageMediaWebPage = (TLRPC$TL_messageMediaWebPage) tLObject;
            TLRPC$WebPage tLRPC$WebPage = tLRPC$TL_messageMediaWebPage.webpage;
            if ((tLRPC$WebPage instanceof TLRPC$TL_webPage) || (tLRPC$WebPage instanceof TLRPC$TL_webPageEmpty)) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ((MessageObject) arrayList.get(i2)).messageOwner.media.webpage = tLRPC$TL_messageMediaWebPage.webpage;
                    if (i2 == 0) {
                        ImageLoader.saveMessageThumbs(((MessageObject) arrayList.get(i2)).messageOwner);
                    }
                    tLRPC$TL_messages_messages.messages.add(((MessageObject) arrayList.get(i2)).messageOwner);
                }
            } else {
                longSparseArray.put(tLRPC$WebPage.id, arrayList);
            }
        }
        if (tLRPC$TL_messages_messages.messages.isEmpty()) {
            return;
        }
        getMessagesStorage().putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, j, -2, 0L, false, z);
        getNotificationCenter().postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(j), arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x02d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0291  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processLoadedMessages(final org.rbmain.tgnet.TLRPC$messages_Messages r29, final int r30, final long r31, long r33, final int r35, final long r36, int r38, final boolean r39, final int r40, final long r41, final long r43, final int r45, final int r46, final int r47, boolean r48, final boolean r49, final int r50, long r51, final int r53, boolean r54, final int r55, final boolean r56, final androidMessenger.model.CustomParameters r57) {
        /*
            Method dump skipped, instructions count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.processLoadedMessages(org.rbmain.tgnet.TLRPC$messages_Messages, int, long, long, int, long, int, boolean, int, long, long, int, int, int, boolean, boolean, int, long, int, boolean, int, boolean, androidMessenger.model.CustomParameters):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedMessages$110(int i, TLRPC$messages_Messages tLRPC$messages_Messages, boolean z, boolean z2, long j) {
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDidLoadWithoutProcess, Integer.valueOf(i), Integer.valueOf(tLRPC$messages_Messages.messages.size()), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedMessages$111(TLRPC$messages_Messages tLRPC$messages_Messages, boolean z, int i, long j, int i2, long j2, ArrayList arrayList, boolean z2, int i3, int i4, boolean z3, long j3, int i5, int i6, int i7, int i8, long j4, int i9, CustomParameters customParameters, ArrayList arrayList2, HashMap map) {
        putUsers(tLRPC$messages_Messages.users, z);
        putChats(tLRPC$messages_Messages.chats, z);
        long j5 = i == 1 ? 0L : j;
        if (i == 1 && i2 == 1) {
            getNotificationCenter().postNotificationName(NotificationCenter.scheduledMessagesUpdated, Long.valueOf(j2), Integer.valueOf(arrayList.size()));
        }
        if (((int) j2) != 0 && !z2) {
            getNotificationCenter().postNotificationName(NotificationCenter.messagesDidLoadWithoutProcess, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z3), Long.valueOf(j3));
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.messagesDidLoad, Long.valueOf(j2), Integer.valueOf(i2), arrayList, Boolean.valueOf(z), Long.valueOf(j5), Long.valueOf(j3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z3), Integer.valueOf(i3), Integer.valueOf(i8), Long.valueOf(j4), Integer.valueOf(i9), Integer.valueOf(i), customParameters);
        }
        if (!arrayList2.isEmpty()) {
            reloadMessages(arrayList2, j2, i == 1);
        }
        if (map.isEmpty()) {
            return;
        }
        reloadWebPages(j2, map, i == 1);
    }

    public void loadHintDialogs() {
        if (this.hintDialogs.isEmpty()) {
            TLRPC$TL_help_getRecentMeUrls tLRPC$TL_help_getRecentMeUrls = new TLRPC$TL_help_getRecentMeUrls();
            tLRPC$TL_help_getRecentMeUrls.referer = this.installReferer;
            getDialogsProxy().getAllHintDialogs(tLRPC$TL_help_getRecentMeUrls, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda194
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadHintDialogs$113(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHintDialogs$113(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda118
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHintDialogs$112(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHintDialogs$112(TLObject tLObject) {
        TLRPC$TL_help_recentMeUrls tLRPC$TL_help_recentMeUrls = (TLRPC$TL_help_recentMeUrls) tLObject;
        putUsers(tLRPC$TL_help_recentMeUrls.users, false);
        putChats(tLRPC$TL_help_recentMeUrls.chats, false);
        this.hintDialogs.clear();
        this.hintDialogs.addAll(tLRPC$TL_help_recentMeUrls.urls);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    private TLRPC$TL_dialogFolder ensureFolderDialogExists(int i, boolean[] zArr) {
        if (i == 0) {
            return null;
        }
        long jMakeFolderDialogId = DialogObject.makeFolderDialogId(i);
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(jMakeFolderDialogId);
        if (tLRPC$Dialog instanceof TLRPC$TL_dialogFolder) {
            if (zArr != null) {
                zArr[0] = false;
            }
            return (TLRPC$TL_dialogFolder) tLRPC$Dialog;
        }
        if (zArr != null) {
            zArr[0] = true;
        }
        TLRPC$TL_dialogFolder tLRPC$TL_dialogFolder = new TLRPC$TL_dialogFolder();
        tLRPC$TL_dialogFolder.id = jMakeFolderDialogId;
        tLRPC$TL_dialogFolder.peer = new TLRPC$TL_peerUser();
        TLRPC$TL_folder tLRPC$TL_folder = new TLRPC$TL_folder();
        tLRPC$TL_dialogFolder.folder = tLRPC$TL_folder;
        tLRPC$TL_folder.id = i;
        tLRPC$TL_folder.title = LocaleController.getString("ArchivedChats", ir.medu.shad.R.string.ArchivedChats);
        tLRPC$TL_dialogFolder.pinned = true;
        int iMax = 0;
        for (int i2 = 0; i2 < this.allDialogs.size(); i2++) {
            TLRPC$Dialog tLRPC$Dialog2 = this.allDialogs.get(i2);
            if (!tLRPC$Dialog2.pinned) {
                if (tLRPC$Dialog2.id != this.promoDialogId) {
                    break;
                }
            } else {
                iMax = Math.max(tLRPC$Dialog2.pinnedNum, iMax);
            }
        }
        tLRPC$TL_dialogFolder.pinnedNum = iMax + 1;
        TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
        tLRPC$TL_messages_dialogs.dialogs.add(tLRPC$TL_dialogFolder);
        getMessagesStorage().putDialogs(tLRPC$TL_messages_dialogs, 1);
        FirebaseEventSender.setKey("dialogs_dictput12", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
        this.dialogs_dict.put(jMakeFolderDialogId, tLRPC$TL_dialogFolder);
        this.allDialogs.add(0, tLRPC$TL_dialogFolder);
        return tLRPC$TL_dialogFolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeFolder, reason: merged with bridge method [inline-methods] */
    public void lambda$onFolderEmpty$114(int i) {
        String str;
        long jMakeFolderDialogId = DialogObject.makeFolderDialogId(i);
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(jMakeFolderDialogId);
        if (tLRPC$Dialog == null) {
            return;
        }
        if (this.dialogs_dict != null) {
            str = this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        } else {
            str = "null";
        }
        FirebaseEventSender.setKey("dialogs_dict_remove4", str);
        this.dialogs_dict.remove(jMakeFolderDialogId);
        this.allDialogs.remove(tLRPC$Dialog);
        sortDialogs(null);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.folderBecomeEmpty, Integer.valueOf(i));
    }

    protected void onFolderEmpty(final int i) {
        if (getUserConfig().getDialogLoadOffsets(i)[0] == Integer.MAX_VALUE) {
            lambda$onFolderEmpty$114(i);
        } else {
            loadDialogs(i, 0, 10, false, new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda41
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFolderEmpty$114(i);
                }
            });
        }
    }

    public void checkIfFolderEmpty(int i) {
        if (i == 0) {
            return;
        }
        getMessagesStorage().checkIfFolderEmpty(i);
    }

    public int addDialogToFolder(long j, int i, int i2, long j2) {
        ArrayList<Long> arrayList = new ArrayList<>(1);
        arrayList.add(Long.valueOf(j));
        return addDialogToFolder(arrayList, i, i2, null, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0145 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int addDialogToFolder(java.util.ArrayList<java.lang.Long> r22, int r23, int r24, java.util.ArrayList<org.rbmain.tgnet.TLRPC$TL_inputFolderPeer> r25, long r26) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.addDialogToFolder(java.util.ArrayList, int, int, java.util.ArrayList, long):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addDialogToFolder$115(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void loadDialogs(int i, int i2, int i3, boolean z) {
        loadDialogs(i, i2, i3, z, null);
    }

    public void loadGlobalNotificationsSettings() {
        if (this.loadingNotificationSettings == 0 && !getUserConfig().notificationsSettingsLoaded) {
            SharedPreferences notificationsSettings = getNotificationsSettings(this.currentAccount);
            SharedPreferences.Editor editorEdit = null;
            if (notificationsSettings.contains("EnableGroup")) {
                boolean z = notificationsSettings.getBoolean("EnableGroup", true);
                SharedPreferences.Editor editorEdit2 = notificationsSettings.edit();
                if (!z) {
                    editorEdit2.putInt("EnableGroup2", ConnectionsManager.DEFAULT_DATACENTER_ID);
                    editorEdit2.putInt("EnableChannel2", ConnectionsManager.DEFAULT_DATACENTER_ID);
                }
                editorEdit2.remove("EnableGroup").apply();
                editorEdit = editorEdit2;
            }
            if (notificationsSettings.contains("EnableAll")) {
                boolean z2 = notificationsSettings.getBoolean("EnableAll", true);
                if (editorEdit == null) {
                    editorEdit = notificationsSettings.edit();
                }
                if (!z2) {
                    editorEdit.putInt("EnableAll2", ConnectionsManager.DEFAULT_DATACENTER_ID);
                }
                editorEdit.remove("EnableAll").apply();
            }
            if (editorEdit != null) {
                editorEdit.apply();
            }
            this.loadingNotificationSettings = 3;
            for (final int i = 0; i < 3; i++) {
                TLRPC$TL_account_getNotifySettings tLRPC$TL_account_getNotifySettings = new TLRPC$TL_account_getNotifySettings();
                if (i == 0) {
                    tLRPC$TL_account_getNotifySettings.peer = new TLRPC$TL_inputNotifyChats();
                } else if (i == 1) {
                    tLRPC$TL_account_getNotifySettings.peer = new TLRPC$TL_inputNotifyUsers();
                } else {
                    tLRPC$TL_account_getNotifySettings.peer = new TLRPC$TL_inputNotifyBroadcasts();
                }
                getConnectionsManager().sendRequest(tLRPC$TL_account_getNotifySettings, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda210
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$loadGlobalNotificationsSettings$117(i, tLObject, tLRPC$TL_error);
                    }
                });
            }
        }
        if (getUserConfig().notificationsSignUpSettingsLoaded) {
            return;
        }
        loadSignUpNotificationsSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGlobalNotificationsSettings$117(final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda121
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadGlobalNotificationsSettings$116(tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGlobalNotificationsSettings$116(TLObject tLObject, int i) {
        if (tLObject != null) {
            this.loadingNotificationSettings--;
            TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = (TLRPC$TL_peerNotifySettings) tLObject;
            SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
            if (i == 0) {
                if ((tLRPC$TL_peerNotifySettings.flags & 1) != 0) {
                    editorEdit.putBoolean("EnablePreviewGroup", tLRPC$TL_peerNotifySettings.show_previews);
                }
                if ((tLRPC$TL_peerNotifySettings.flags & 4) != 0) {
                    editorEdit.putInt("EnableGroup2", tLRPC$TL_peerNotifySettings.mute_until);
                }
            } else if (i == 1) {
                if ((tLRPC$TL_peerNotifySettings.flags & 1) != 0) {
                    editorEdit.putBoolean("EnablePreviewAll", tLRPC$TL_peerNotifySettings.show_previews);
                }
                if ((tLRPC$TL_peerNotifySettings.flags & 4) != 0) {
                    editorEdit.putInt("EnableAll2", tLRPC$TL_peerNotifySettings.mute_until);
                }
            } else {
                if ((tLRPC$TL_peerNotifySettings.flags & 1) != 0) {
                    editorEdit.putBoolean("EnablePreviewChannel", tLRPC$TL_peerNotifySettings.show_previews);
                }
                if ((tLRPC$TL_peerNotifySettings.flags & 4) != 0) {
                    editorEdit.putInt("EnableChannel2", tLRPC$TL_peerNotifySettings.mute_until);
                }
            }
            editorEdit.apply();
            if (this.loadingNotificationSettings == 0) {
                getUserConfig().notificationsSettingsLoaded = true;
                getUserConfig().saveConfig(false);
            }
        }
    }

    public void loadSignUpNotificationsSettings() {
        if (this.loadingNotificationSignUpSettings) {
            return;
        }
        this.loadingNotificationSignUpSettings = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_getContactSignUpNotification
            public static int constructor = -1626880216;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda193
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadSignUpNotificationsSettings$119(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSignUpNotificationsSettings$119(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda120
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSignUpNotificationsSettings$118(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSignUpNotificationsSettings$118(TLObject tLObject) {
        this.loadingNotificationSignUpSettings = false;
        SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
        boolean z = tLObject instanceof TLRPC$TL_boolFalse;
        this.enableJoined = z;
        editorEdit.putBoolean("EnableContactJoined", z);
        editorEdit.apply();
        getUserConfig().notificationsSignUpSettingsLoaded = true;
        getUserConfig().saveConfig(false);
    }

    public void forceResetDialogs() {
        resetDialogs(true, getMessagesStorage().getLastSeqValue(), getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue());
        getNotificationsController().deleteAllNotificationChannels();
    }

    private void fetchFolderInLoadedPinnedDialogs(TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs) {
        TLRPC$InputPeer tLRPC$TL_inputPeerUser;
        int size = tLRPC$TL_messages_peerDialogs.dialogs.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$Dialog tLRPC$Dialog = tLRPC$TL_messages_peerDialogs.dialogs.get(i2);
            if (tLRPC$Dialog instanceof TLRPC$TL_dialogFolder) {
                TLRPC$TL_dialogFolder tLRPC$TL_dialogFolder = (TLRPC$TL_dialogFolder) tLRPC$Dialog;
                long peerDialogId = DialogObject.getPeerDialogId(tLRPC$Dialog.peer);
                if (tLRPC$TL_dialogFolder.top_message == 0 || peerDialogId == 0) {
                    tLRPC$TL_messages_peerDialogs.dialogs.remove(tLRPC$TL_dialogFolder);
                } else {
                    int size2 = tLRPC$TL_messages_peerDialogs.messages.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        TLRPC$Message tLRPC$Message = tLRPC$TL_messages_peerDialogs.messages.get(i3);
                        if (peerDialogId == MessageObject.getDialogId(tLRPC$Message) && tLRPC$Dialog.top_message == tLRPC$Message.id) {
                            TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
                            tLRPC$TL_dialog.peer = tLRPC$Dialog.peer;
                            tLRPC$TL_dialog.top_message = tLRPC$Dialog.top_message;
                            tLRPC$TL_dialog.folder_id = tLRPC$TL_dialogFolder.folder.id;
                            tLRPC$TL_dialog.flags |= 16;
                            tLRPC$TL_messages_peerDialogs.dialogs.add(tLRPC$TL_dialog);
                            TLRPC$Peer tLRPC$Peer = tLRPC$Dialog.peer;
                            if (tLRPC$Peer instanceof TLRPC$TL_peerChannel) {
                                tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerChannel();
                                tLRPC$TL_inputPeerUser.channel_id = tLRPC$Dialog.peer.channel_id;
                                int size3 = tLRPC$TL_messages_peerDialogs.chats.size();
                                while (true) {
                                    if (i >= size3) {
                                        break;
                                    }
                                    TLRPC$Chat tLRPC$Chat = tLRPC$TL_messages_peerDialogs.chats.get(i);
                                    if (tLRPC$Chat.id == tLRPC$TL_inputPeerUser.channel_id) {
                                        tLRPC$TL_inputPeerUser.access_hash = tLRPC$Chat.access_hash;
                                        break;
                                    }
                                    i++;
                                }
                            } else if (tLRPC$Peer instanceof TLRPC$TL_peerChat) {
                                tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerChat();
                                tLRPC$TL_inputPeerUser.chat_id = tLRPC$Dialog.peer.chat_id;
                            } else {
                                tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
                                tLRPC$TL_inputPeerUser.user_id = tLRPC$Dialog.peer.user_id;
                                int size4 = tLRPC$TL_messages_peerDialogs.users.size();
                                while (true) {
                                    if (i >= size4) {
                                        break;
                                    }
                                    TLRPC$User tLRPC$User = tLRPC$TL_messages_peerDialogs.users.get(i);
                                    if (tLRPC$User.id == tLRPC$TL_inputPeerUser.user_id) {
                                        tLRPC$TL_inputPeerUser.access_hash = tLRPC$User.access_hash;
                                        break;
                                    }
                                    i++;
                                }
                            }
                            loadUnknownDialog(tLRPC$TL_inputPeerUser, 0L);
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void resetDialogs(boolean r27, final int r28, final int r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 727
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.resetDialogs(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetDialogs$120(int i, int i2, int i3, int i4, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            this.resetDialogsPinned = (TLRPC$TL_messages_peerDialogs) tLObject;
            for (int i5 = 0; i5 < this.resetDialogsPinned.dialogs.size(); i5++) {
                this.resetDialogsPinned.dialogs.get(i5).pinned = true;
            }
            resetDialogs(false, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetDialogs$121(int i, int i2, int i3, int i4, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.resetDialogsAll = (TLRPC$messages_Dialogs) tLObject;
            resetDialogs(false, i, i2, i3, i4);
        }
    }

    public void completeDialogsReset(final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, int i, int i2, final int i3, final int i4, final int i5, final LongSparseArray<TLRPC$Dialog> longSparseArray, final LongSparseArray<MessageObject> longSparseArray2, TLRPC$Message tLRPC$Message) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$completeDialogsReset$123(i3, i4, i5, tLRPC$messages_Dialogs, longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$completeDialogsReset$123(int i, int i2, int i3, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final LongSparseArray longSparseArray, final LongSparseArray longSparseArray2) {
        this.gettingDifference = false;
        getMessagesStorage().setLastPtsValue(i);
        getMessagesStorage().setLastDateValue(i2);
        getMessagesStorage().setLastQtsValue(i3);
        getDifference();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda155
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$completeDialogsReset$122(tLRPC$messages_Dialogs, longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$completeDialogsReset$122(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        TLRPC$Dialog tLRPC$Dialog;
        long j;
        long j2;
        this.resetingDialogs = false;
        applyDialogsNotificationsSettings(tLRPC$messages_Dialogs.dialogs);
        MediaDataController mediaDataController = getMediaDataController();
        mediaDataController.clearAllDrafts(false);
        mediaDataController.loadDraftsIfNeed();
        putUsers(tLRPC$messages_Dialogs.users, false);
        putChats(tLRPC$messages_Dialogs.chats, false);
        int i = 0;
        while (true) {
            if (i >= this.allDialogs.size()) {
                break;
            }
            TLRPC$Dialog tLRPC$Dialog2 = this.allDialogs.get(i);
            if (!DialogObject.isSecretDialogId(tLRPC$Dialog2.id)) {
                FirebaseEventSender.setKey("dialogs_dict_remove5", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
                this.dialogs_dict.remove(tLRPC$Dialog2.id);
                MessageObject messageObject = this.dialogMessage.get(tLRPC$Dialog2.id);
                this.dialogMessage.remove(tLRPC$Dialog2.id);
                if (messageObject != null) {
                    if (messageObject.messageOwner.peer_id.channel_id == 0) {
                        this.dialogMessagesByIds.remove(messageObject.getId());
                    }
                    long j3 = messageObject.messageOwner.random_id;
                    if (j3 != 0) {
                        this.dialogMessagesByRandomIds.remove(j3);
                    }
                }
            }
            i++;
        }
        for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
            long jKeyAt = longSparseArray.keyAt(i2);
            TLRPC$Dialog tLRPC$Dialog3 = (TLRPC$Dialog) longSparseArray.valueAt(i2);
            TLRPC$DraftMessage tLRPC$DraftMessage = tLRPC$Dialog3.draft;
            if (tLRPC$DraftMessage instanceof TLRPC$TL_draftMessage) {
                tLRPC$Dialog = tLRPC$Dialog3;
                j = jKeyAt;
                mediaDataController.saveDraft(tLRPC$Dialog3.id, 0L, tLRPC$DraftMessage, null, false);
            } else {
                tLRPC$Dialog = tLRPC$Dialog3;
                j = jKeyAt;
            }
            FirebaseEventSender.setKey("dialogs_dictput13", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
            this.dialogs_dict.put(j, tLRPC$Dialog);
            MessageObject messageObject2 = (MessageObject) longSparseArray2.get(tLRPC$Dialog.id);
            this.dialogMessage.put(j, messageObject2);
            if (messageObject2 == null || messageObject2.messageOwner.peer_id.channel_id != 0) {
                j2 = 0;
            } else {
                this.dialogMessagesByIds.put(messageObject2.getId(), messageObject2);
                this.dialogsLoadedTillDate = Math.min(this.dialogsLoadedTillDate, messageObject2.messageOwner.date);
                long j4 = messageObject2.messageOwner.random_id;
                j2 = 0;
                if (j4 != 0) {
                    this.dialogMessagesByRandomIds.put(j4, messageObject2);
                }
            }
        }
        this.allDialogs.clear();
        int size = this.dialogs_dict.size();
        for (int i3 = 0; i3 < size; i3++) {
            TLRPC$Dialog tLRPC$DialogValueAt = this.dialogs_dict.valueAt(i3);
            if (tLRPC$DialogValueAt != null || this.deletingDialogs.indexOfKey(tLRPC$DialogValueAt.id) < 0) {
                this.allDialogs.add(tLRPC$DialogValueAt);
            }
        }
        sortDialogs(null);
        this.dialogsEndReached.put(0, true);
        this.serverDialogsEndReached.put(0, false);
        this.dialogsEndReached.put(1, true);
        this.serverDialogsEndReached.put(1, false);
        int totalDialogsCount = getUserConfig().getTotalDialogsCount(0);
        int[] dialogLoadOffsets = getUserConfig().getDialogLoadOffsets(0);
        if (totalDialogsCount < 400 && dialogLoadOffsets[0] != -1 && dialogLoadOffsets[0] != Integer.MAX_VALUE) {
            loadDialogs(0, 0, 100, false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    private void migrateDialogs(final long j, int i, int i2, int i3, int i4, long j2) {
        if (this.migratingDialogs || j == -1) {
            return;
        }
        this.migratingDialogs = true;
        TLRPC$TL_messages_getDialogs tLRPC$TL_messages_getDialogs = new TLRPC$TL_messages_getDialogs();
        tLRPC$TL_messages_getDialogs.exclude_pinned = true;
        tLRPC$TL_messages_getDialogs.limit = 100;
        tLRPC$TL_messages_getDialogs.offset_id = j;
        tLRPC$TL_messages_getDialogs.offset_date = i;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start migrate with id " + j + " date " + LocaleController.getInstance().formatterStats.format(i * 1000));
        }
        if (j == 0) {
            tLRPC$TL_messages_getDialogs.offset_peer = new TLRPC$TL_inputPeerEmpty();
        } else {
            if (i4 != 0) {
                TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                tLRPC$TL_messages_getDialogs.offset_peer = tLRPC$TL_inputPeerChannel;
                tLRPC$TL_inputPeerChannel.channel_id = i4;
            } else if (i2 != 0) {
                TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
                tLRPC$TL_messages_getDialogs.offset_peer = tLRPC$TL_inputPeerUser;
                tLRPC$TL_inputPeerUser.user_id = i2;
            } else {
                TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
                tLRPC$TL_messages_getDialogs.offset_peer = tLRPC$TL_inputPeerChat;
                tLRPC$TL_inputPeerChat.chat_id = i3;
            }
            tLRPC$TL_messages_getDialogs.offset_peer.access_hash = j2;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getDialogs, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda229
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$migrateDialogs$127(j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$migrateDialogs$127(final long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            final TLRPC$messages_Dialogs tLRPC$messages_Dialogs = (TLRPC$messages_Dialogs) tLObject;
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda154
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$migrateDialogs$125(tLRPC$messages_Dialogs, j);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$migrateDialogs$126();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$migrateDialogs$125(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, long j) {
        long j2;
        SQLiteCursor sQLiteCursor;
        TLRPC$Message tLRPC$Message;
        SQLiteCursor sQLiteCursor2;
        long j3;
        try {
            int i = 0;
            getUserConfig().setTotalDialogsCount(0, getUserConfig().getTotalDialogsCount(0) + tLRPC$messages_Dialogs.dialogs.size());
            TLRPC$Message tLRPC$Message2 = null;
            for (int i2 = 0; i2 < tLRPC$messages_Dialogs.messages.size(); i2++) {
                TLRPC$Message tLRPC$Message3 = tLRPC$messages_Dialogs.messages.get(i2);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("search migrate id " + tLRPC$Message3.id + " date " + LocaleController.getInstance().formatterStats.format(tLRPC$Message3.date * 1000));
                }
                if (tLRPC$Message2 == null || tLRPC$Message3.date < tLRPC$Message2.date) {
                    tLRPC$Message2 = tLRPC$Message3;
                }
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("migrate step with id " + tLRPC$Message2.id + " date " + LocaleController.getInstance().formatterStats.format(tLRPC$Message2.date * 1000));
            }
            if (tLRPC$messages_Dialogs.dialogs.size() >= 100) {
                j2 = tLRPC$Message2.id;
            } else {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("migrate stop due to not 100 dialogs");
                }
                for (int i3 = 0; i3 < 2; i3++) {
                    getUserConfig().setDialogsLoadOffset(i3, 2147483647L, getUserConfig().migrateOffsetDate, getUserConfig().migrateOffsetUserId, getUserConfig().migrateOffsetChatId, getUserConfig().migrateOffsetChannelId, getUserConfig().migrateOffsetAccess);
                }
                j2 = -1;
            }
            StringBuilder sb = new StringBuilder(tLRPC$messages_Dialogs.dialogs.size() * 12);
            LongSparseArray longSparseArray = new LongSparseArray();
            for (int i4 = 0; i4 < tLRPC$messages_Dialogs.dialogs.size(); i4++) {
                TLRPC$Dialog tLRPC$Dialog = tLRPC$messages_Dialogs.dialogs.get(i4);
                DialogObject.initDialog(tLRPC$Dialog);
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(tLRPC$Dialog.id);
                longSparseArray.put(tLRPC$Dialog.id, tLRPC$Dialog);
            }
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT did, folder_id FROM dialogs WHERE did IN (%s)", sb.toString()), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(i);
                int iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                TLRPC$Dialog tLRPC$Dialog2 = (TLRPC$Dialog) longSparseArray.get(jLongValue);
                if (tLRPC$Dialog2 != null) {
                    if (tLRPC$Dialog2.folder_id == iIntValue) {
                        tLRPC$messages_Dialogs.dialogs.remove(tLRPC$Dialog2);
                        int i5 = 0;
                        while (i5 < tLRPC$messages_Dialogs.messages.size()) {
                            TLRPC$Message tLRPC$Message4 = tLRPC$messages_Dialogs.messages.get(i5);
                            if (MessageObject.getDialogId(tLRPC$Message4) == jLongValue) {
                                tLRPC$messages_Dialogs.messages.remove(i5);
                                i5--;
                                j3 = j2;
                                if (tLRPC$Message4.id == tLRPC$Dialog2.top_message) {
                                    tLRPC$Dialog2.top_message = 0L;
                                    break;
                                }
                            } else {
                                j3 = j2;
                            }
                            i5++;
                            j2 = j3;
                        }
                    }
                }
                j3 = j2;
                longSparseArray.remove(jLongValue);
                j2 = j3;
                i = 0;
            }
            long j4 = j2;
            sQLiteCursorQueryFinalized.dispose();
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("migrate found missing dialogs " + tLRPC$messages_Dialogs.dialogs.size());
            }
            SQLiteCursor sQLiteCursorQueryFinalized2 = getMessagesStorage().getDatabase().queryFinalized("SELECT min(date) FROM dialogs WHERE date != 0 AND did >> 32 IN (0, -1)", new Object[0]);
            if (sQLiteCursorQueryFinalized2.next()) {
                int iMax = Math.max(1441062000, sQLiteCursorQueryFinalized2.intValue(0));
                int i6 = 0;
                while (i6 < tLRPC$messages_Dialogs.messages.size()) {
                    TLRPC$Message tLRPC$Message5 = tLRPC$messages_Dialogs.messages.get(i6);
                    if (tLRPC$Message5.date < iMax) {
                        if (j != -1) {
                            int i7 = 0;
                            for (int i8 = 2; i7 < i8; i8 = 2) {
                                getUserConfig().setDialogsLoadOffset(i7, getUserConfig().migrateOffsetId, getUserConfig().migrateOffsetDate, getUserConfig().migrateOffsetUserId, getUserConfig().migrateOffsetChatId, getUserConfig().migrateOffsetChannelId, getUserConfig().migrateOffsetAccess);
                                i7++;
                                tLRPC$Message2 = tLRPC$Message2;
                                sQLiteCursorQueryFinalized2 = sQLiteCursorQueryFinalized2;
                            }
                            tLRPC$Message = tLRPC$Message2;
                            sQLiteCursor2 = sQLiteCursorQueryFinalized2;
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("migrate stop due to reached loaded dialogs " + LocaleController.getInstance().formatterStats.format(iMax * 1000));
                            }
                            j4 = -1;
                        } else {
                            tLRPC$Message = tLRPC$Message2;
                            sQLiteCursor2 = sQLiteCursorQueryFinalized2;
                        }
                        tLRPC$messages_Dialogs.messages.remove(i6);
                        i6--;
                        long dialogId = MessageObject.getDialogId(tLRPC$Message5);
                        TLRPC$Dialog tLRPC$Dialog3 = (TLRPC$Dialog) longSparseArray.get(dialogId);
                        longSparseArray.remove(dialogId);
                        if (tLRPC$Dialog3 != null) {
                            tLRPC$messages_Dialogs.dialogs.remove(tLRPC$Dialog3);
                        }
                    } else {
                        tLRPC$Message = tLRPC$Message2;
                        sQLiteCursor2 = sQLiteCursorQueryFinalized2;
                    }
                    i6++;
                    tLRPC$Message2 = tLRPC$Message;
                    sQLiteCursorQueryFinalized2 = sQLiteCursor2;
                }
                TLRPC$Message tLRPC$Message6 = tLRPC$Message2;
                sQLiteCursor = sQLiteCursorQueryFinalized2;
                if (tLRPC$Message6 != null) {
                    tLRPC$Message2 = tLRPC$Message6;
                    if (tLRPC$Message2.date < iMax && j != -1) {
                        for (int i9 = 0; i9 < 2; i9++) {
                            getUserConfig().setDialogsLoadOffset(i9, getUserConfig().migrateOffsetId, getUserConfig().migrateOffsetDate, getUserConfig().migrateOffsetUserId, getUserConfig().migrateOffsetChatId, getUserConfig().migrateOffsetChannelId, getUserConfig().migrateOffsetAccess);
                        }
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("migrate stop due to reached loaded dialogs " + LocaleController.getInstance().formatterStats.format(iMax * 1000));
                        }
                        j4 = -1;
                    }
                } else {
                    tLRPC$Message2 = tLRPC$Message6;
                }
            } else {
                sQLiteCursor = sQLiteCursorQueryFinalized2;
            }
            sQLiteCursor.dispose();
            getUserConfig().migrateOffsetDate = tLRPC$Message2.date;
            TLRPC$Peer tLRPC$Peer = tLRPC$Message2.peer_id;
            if (tLRPC$Peer.channel_id != 0) {
                getUserConfig().migrateOffsetChannelId = tLRPC$Message2.peer_id.channel_id;
                getUserConfig().migrateOffsetChatId = 0;
                getUserConfig().migrateOffsetUserId = 0;
                int i10 = 0;
                while (true) {
                    if (i10 >= tLRPC$messages_Dialogs.chats.size()) {
                        break;
                    }
                    TLRPC$Chat tLRPC$Chat = tLRPC$messages_Dialogs.chats.get(i10);
                    if (tLRPC$Chat.id == getUserConfig().migrateOffsetChannelId) {
                        getUserConfig().migrateOffsetAccess = tLRPC$Chat.access_hash;
                        break;
                    }
                    i10++;
                }
            } else if (tLRPC$Peer.chat_id != 0) {
                getUserConfig().migrateOffsetChatId = tLRPC$Message2.peer_id.chat_id;
                getUserConfig().migrateOffsetChannelId = 0;
                getUserConfig().migrateOffsetUserId = 0;
                int i11 = 0;
                while (true) {
                    if (i11 >= tLRPC$messages_Dialogs.chats.size()) {
                        break;
                    }
                    TLRPC$Chat tLRPC$Chat2 = tLRPC$messages_Dialogs.chats.get(i11);
                    if (tLRPC$Chat2.id == getUserConfig().migrateOffsetChatId) {
                        getUserConfig().migrateOffsetAccess = tLRPC$Chat2.access_hash;
                        break;
                    }
                    i11++;
                }
            } else if (tLRPC$Peer.user_id != 0) {
                getUserConfig().migrateOffsetUserId = tLRPC$Message2.peer_id.user_id;
                int i12 = 0;
                getUserConfig().migrateOffsetChatId = 0;
                getUserConfig().migrateOffsetChannelId = 0;
                while (true) {
                    if (i12 >= tLRPC$messages_Dialogs.users.size()) {
                        break;
                    }
                    TLRPC$User tLRPC$User = tLRPC$messages_Dialogs.users.get(i12);
                    if (tLRPC$User.id == getUserConfig().migrateOffsetUserId) {
                        getUserConfig().migrateOffsetAccess = tLRPC$User.access_hash;
                        break;
                    }
                    i12++;
                }
            }
            processLoadedDialogs(tLRPC$messages_Dialogs, null, 0, j4, 0, 0, false, true, false);
        } catch (Exception e) {
            FileLog.e(e);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$migrateDialogs$124();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$migrateDialogs$124() {
        this.migratingDialogs = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$migrateDialogs$126() {
        this.migratingDialogs = false;
    }

    public void processLoadedDialogs(final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final ArrayList<TLRPC$EncryptedChat> arrayList, final int i, final long j, final int i2, final int i3, final boolean z, final boolean z2, final boolean z3) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDialogs$131(i, i3, tLRPC$messages_Dialogs, z, arrayList, j, i2, z3, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processLoadedDialogs$131(final int r29, final int r30, final org.rbmain.tgnet.TLRPC$messages_Dialogs r31, final boolean r32, final java.util.ArrayList r33, final long r34, final int r36, final boolean r37, final boolean r38) {
        /*
            Method dump skipped, instructions count: 1226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.lambda$processLoadedDialogs$131(int, int, org.rbmain.tgnet.TLRPC$messages_Dialogs, boolean, java.util.ArrayList, long, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDialogs$128(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, int i, boolean z, boolean z2) {
        putUsers(tLRPC$messages_Dialogs.users, true);
        this.loadingDialogs.put(i, false);
        if (z) {
            this.dialogsEndReached.put(i, false);
            this.serverDialogsEndReached.put(i, false);
        } else if (z2) {
            this.dialogsEndReached.put(i, true);
            this.serverDialogsEndReached.put(i, true);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDialogs$129(TLRPC$Chat tLRPC$Chat) {
        checkChatInviter(tLRPC$Chat.id, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    public /* synthetic */ void lambda$processLoadedDialogs$130(TLRPC$Message tLRPC$Message, int i, TLRPC$messages_Dialogs tLRPC$messages_Dialogs, ArrayList arrayList, boolean z, int i2, LongSparseArray longSparseArray, LongSparseArray longSparseArray2, LongSparseArray longSparseArray3, SparseArray sparseArray, boolean z2, boolean z3, int i3, long j, ArrayList arrayList2) {
        int i4;
        int i5;
        int i6;
        TLRPC$Dialog tLRPC$DialogValueAt;
        int i7;
        String string;
        boolean z4;
        long j2;
        LongSparseArray longSparseArray4 = longSparseArray;
        if (tLRPC$Message != null) {
            this.dialogsLoadedTillDate = Math.min(this.dialogsLoadedTillDate, tLRPC$Message.date);
        } else {
            this.dialogsLoadedTillDate = Integer.MIN_VALUE;
        }
        if (i != this.DIALOGS_LOAD_TYPE_CACHE) {
            applyDialogsNotificationsSettings(tLRPC$messages_Dialogs.dialogs);
            getMediaDataController().loadDraftsIfNeed();
        }
        putUsers(tLRPC$messages_Dialogs.users, i == this.DIALOGS_LOAD_TYPE_CACHE);
        putChats(tLRPC$messages_Dialogs.chats, i == this.DIALOGS_LOAD_TYPE_CACHE);
        if (arrayList != null) {
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) arrayList.get(i8);
                if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) && AndroidUtilities.getMyLayerVersion(tLRPC$EncryptedChat.layer) < 101) {
                    getSecretChatHelper().sendNotifyLayerMessage(tLRPC$EncryptedChat, null);
                }
                putEncryptedChat(tLRPC$EncryptedChat, true);
            }
        }
        if (!z && i != this.DIALOGS_LOAD_TYPE_UNKNOWN && i != this.DIALOGS_LOAD_TYPE_CHANNEL) {
            this.loadingDialogs.put(i2, false);
        }
        this.dialogsLoaded = true;
        if (!z || this.allDialogs.isEmpty()) {
            i4 = 0;
        } else {
            ArrayList<TLRPC$Dialog> arrayList3 = this.allDialogs;
            i4 = arrayList3.get(arrayList3.size() - 1).last_message_date;
        }
        int i9 = 0;
        int i10 = 0;
        boolean z5 = false;
        while (true) {
            i5 = i10;
            if (i9 >= longSparseArray.size()) {
                break;
            }
            long jKeyAt = longSparseArray4.keyAt(i9);
            TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) longSparseArray4.valueAt(i9);
            TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(jKeyAt);
            if (z && tLRPC$Dialog2 != null) {
                tLRPC$Dialog2.folder_id = tLRPC$Dialog.folder_id;
            }
            if (!z || i4 == 0 || tLRPC$Dialog.last_message_date >= i4) {
                if (i == this.DIALOGS_LOAD_TYPE_CACHE || !(tLRPC$Dialog.draft instanceof TLRPC$TL_draftMessage)) {
                    i7 = i4;
                } else {
                    i7 = i4;
                    getMediaDataController().saveDraft(tLRPC$Dialog.id, 0L, tLRPC$Dialog.draft, null, false);
                }
                if (tLRPC$Dialog.folder_id != i2) {
                    i5++;
                }
                MessageObject messageObject = (MessageObject) longSparseArray2.get(tLRPC$Dialog.id);
                string = "null";
                if (tLRPC$Dialog2 == null) {
                    FirebaseEventSender.setKey("dialogs_dict", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
                    this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
                    this.dialogMessage.put(jKeyAt, messageObject);
                    if (messageObject != null && messageObject.messageOwner.peer_id.channel_id == 0) {
                        this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                        long j3 = messageObject.messageOwner.random_id;
                        if (j3 != 0) {
                            this.dialogMessagesByRandomIds.put(j3, messageObject);
                        }
                    }
                    i10 = i5;
                    z5 = true;
                } else {
                    if (i != this.DIALOGS_LOAD_TYPE_CACHE) {
                        tLRPC$Dialog2.notify_settings = tLRPC$Dialog.notify_settings;
                    }
                    tLRPC$Dialog2.pinned = tLRPC$Dialog.pinned;
                    tLRPC$Dialog2.pinnedNum = tLRPC$Dialog.pinnedNum;
                    MessageObject messageObject2 = this.dialogMessage.get(jKeyAt);
                    if (this.dialogs_dict != null) {
                        StringBuilder sb = new StringBuilder();
                        z4 = z5;
                        sb.append(this.dialogs_dict.size());
                        sb.append(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                        string = sb.toString();
                    } else {
                        z4 = z5;
                    }
                    FirebaseEventSender.setKey("dialogs_dictput1", string);
                    this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
                    this.dialogMessage.put(jKeyAt, messageObject);
                    if (messageObject2 != null && messageObject2.messageOwner.peer_id.channel_id == 0) {
                        this.dialogMessagesByIds.remove(messageObject2.getId());
                    }
                    if (messageObject == null || messageObject.messageOwner.peer_id.channel_id != 0) {
                        j2 = 0;
                    } else {
                        this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                        long j4 = messageObject.messageOwner.random_id;
                        j2 = 0;
                        if (j4 != 0) {
                            this.dialogMessagesByRandomIds.put(j4, messageObject);
                        }
                    }
                    if (messageObject2 != null) {
                        long j5 = messageObject2.messageOwner.random_id;
                        if (j5 != j2) {
                            this.dialogMessagesByRandomIds.remove(j5);
                        }
                    }
                    long j6 = tLRPC$Dialog2.read_inbox_max_id;
                    if (j6 > j2 && j6 < tLRPC$Dialog.read_inbox_max_id) {
                        longSparseArray3.put(tLRPC$Dialog.id, Integer.valueOf(tLRPC$Dialog.unread_count));
                    }
                    i10 = i5;
                    z5 = z4;
                }
            } else {
                i10 = i5;
                i7 = i4;
            }
            i9++;
            longSparseArray4 = longSparseArray;
            i4 = i7;
        }
        boolean z6 = z5;
        this.allDialogs.clear();
        int size = this.dialogs_dict.size();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                tLRPC$DialogValueAt = this.dialogs_dict.valueAt(i11);
            } catch (Exception unused) {
                tLRPC$DialogValueAt = null;
            }
            if (tLRPC$DialogValueAt != null && this.deletingDialogs.indexOfKey(tLRPC$DialogValueAt.id) < 0) {
                this.allDialogs.add(tLRPC$DialogValueAt);
            }
        }
        sortDialogs(z ? sparseArray : null);
        putAllNeededDraftDialogs();
        if (i != this.DIALOGS_LOAD_TYPE_CHANNEL && i != this.DIALOGS_LOAD_TYPE_UNKNOWN && !z) {
            this.dialogsEndReached.put(i2, !z2);
            if (i5 > 0 && i5 < 20 && i2 == 0) {
                this.dialogsEndReached.put(1, true);
                if (getUserConfig().getDialogLoadOffsets(i2)[0] == Integer.MAX_VALUE) {
                    this.serverDialogsEndReached.put(1, true);
                }
            }
            if (!z3) {
                this.serverDialogsEndReached.put(i2, (tLRPC$messages_Dialogs.dialogs.size() == 0 || tLRPC$messages_Dialogs.dialogs.size() != i3) && i == 0);
            }
        }
        int totalDialogsCount = getUserConfig().getTotalDialogsCount(i2);
        int[] dialogLoadOffsets = getUserConfig().getDialogLoadOffsets(i2);
        if (z3 || z || totalDialogsCount >= 400) {
            i6 = 0;
        } else {
            i6 = 0;
            i6 = 0;
            i6 = 0;
            if (dialogLoadOffsets[0] != -1 && dialogLoadOffsets[0] != Integer.MAX_VALUE) {
                loadDialogs(i2, 0, 100, false);
            }
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[i6]);
        if (z) {
            getUserConfig().migrateOffsetId = j;
            getUserConfig().saveConfig(i6);
            this.migratingDialogs = i6;
            getNotificationCenter().postNotificationName(NotificationCenter.needReloadRecentDialogsSearch, new Object[i6]);
        } else {
            generateUpdateMessage();
            if (!z6 && i == this.DIALOGS_LOAD_TYPE_CACHE && this.dialogsEndReached.get(i2)) {
                loadDialogs(i2, i6, i3, i6);
            }
        }
        migrateDialogs(getUserConfig().migrateOffsetId, getUserConfig().migrateOffsetDate, getUserConfig().migrateOffsetUserId, getUserConfig().migrateOffsetChatId, getUserConfig().migrateOffsetChannelId, getUserConfig().migrateOffsetAccess);
        if (!arrayList2.isEmpty()) {
            reloadDialogsReadValue(arrayList2, 0L);
        }
        if (longSparseArray3.size() > 0) {
            getNotificationsController().processDialogsUpdateRead((LongSparseArray<Integer>) longSparseArray3);
        }
        loadUnreadDialogs();
    }

    private void applyDialogNotificationsSettings(long j, TLRPC$PeerNotifySettings tLRPC$PeerNotifySettings) {
        boolean z;
        int i;
        int i2;
        if (tLRPC$PeerNotifySettings == null) {
            return;
        }
        String dialogId = IdStorage.getInstance().getDialogId(j);
        int i3 = this.notificationsPreferences.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + j, -1);
        int i4 = this.notificationsPreferences.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + j, 0);
        SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        if (tLRPC$Dialog != null) {
            tLRPC$Dialog.notify_settings = tLRPC$PeerNotifySettings;
        }
        if ((tLRPC$PeerNotifySettings.flags & 2) != 0) {
            editorEdit.putBoolean(NotificationsSettingsFacade.PROPERTY_SILENT + j, tLRPC$PeerNotifySettings.silent);
        } else {
            editorEdit.remove(NotificationsSettingsFacade.PROPERTY_SILENT + j);
        }
        boolean z2 = true;
        if ((tLRPC$PeerNotifySettings.flags & 4) != 0) {
            if (tLRPC$PeerNotifySettings.mute_until > getConnectionsManager().getCurrentTime()) {
                if (tLRPC$PeerNotifySettings.mute_until <= getConnectionsManager().getCurrentTime() + 31536000) {
                    if (i3 == 3 && i4 == tLRPC$PeerNotifySettings.mute_until) {
                        z2 = false;
                    } else {
                        editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + j, 3);
                        editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId, 3);
                        editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + j, tLRPC$PeerNotifySettings.mute_until);
                        if (tLRPC$Dialog != null) {
                            tLRPC$Dialog.notify_settings.mute_until = 0;
                        }
                    }
                    z = z2;
                    i2 = tLRPC$PeerNotifySettings.mute_until;
                } else if (i3 != 2) {
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + j, 2);
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId, 2);
                    if (tLRPC$Dialog != null) {
                        tLRPC$Dialog.notify_settings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    }
                    i2 = 0;
                    z = true;
                } else {
                    i2 = 0;
                    z = false;
                }
                getMessagesStorage().setDialogFlags(j, (i2 << 32) | 1);
                getNotificationsController().removeNotificationsForDialog(j);
            } else {
                if (i3 == 0 || i3 == 1) {
                    z2 = false;
                } else {
                    if (tLRPC$Dialog != null) {
                        i = 0;
                        tLRPC$Dialog.notify_settings.mute_until = 0;
                    } else {
                        i = 0;
                    }
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + j, i);
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId, i);
                }
                getMessagesStorage().setDialogFlags(j, 0L);
                z = z2;
            }
        } else {
            if (i3 != -1) {
                if (tLRPC$Dialog != null) {
                    tLRPC$Dialog.notify_settings.mute_until = 0;
                }
                editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + j);
                editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId);
                z = true;
            } else {
                z = false;
            }
            getMessagesStorage().setDialogFlags(j, 0L);
        }
        editorEdit.apply();
        if (z) {
            getNotificationCenter().postNotificationName(NotificationCenter.notificationsSettingsUpdated, new Object[0]);
        }
    }

    private void applyDialogsNotificationsSettings(ArrayList<TLRPC$Dialog> arrayList) {
        SharedPreferences.Editor editorEdit = null;
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$Dialog tLRPC$Dialog = arrayList.get(i);
            if (tLRPC$Dialog.peer != null && (tLRPC$Dialog.notify_settings instanceof TLRPC$TL_peerNotifySettings)) {
                if (editorEdit == null) {
                    editorEdit = this.notificationsPreferences.edit();
                }
                TLRPC$Peer tLRPC$Peer = tLRPC$Dialog.peer;
                int i2 = tLRPC$Peer.user_id;
                if (i2 == 0) {
                    int i3 = tLRPC$Peer.chat_id;
                    i2 = i3 != 0 ? -i3 : -tLRPC$Peer.channel_id;
                }
                String dialogId = IdStorage.getInstance().getDialogId(i2);
                if ((tLRPC$Dialog.notify_settings.flags & 2) != 0) {
                    editorEdit.putBoolean(NotificationsSettingsFacade.PROPERTY_SILENT + i2, tLRPC$Dialog.notify_settings.silent);
                } else {
                    editorEdit.remove(NotificationsSettingsFacade.PROPERTY_SILENT + i2);
                }
                TLRPC$PeerNotifySettings tLRPC$PeerNotifySettings = tLRPC$Dialog.notify_settings;
                if ((tLRPC$PeerNotifySettings.flags & 4) == 0) {
                    editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId);
                    editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + i2);
                } else if (tLRPC$PeerNotifySettings.mute_until <= getConnectionsManager().getCurrentTime()) {
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId, 0);
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + i2, 0);
                } else if (tLRPC$Dialog.notify_settings.mute_until > getConnectionsManager().getCurrentTime() + 31536000) {
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId, 2);
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + i2, 2);
                    tLRPC$Dialog.notify_settings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                } else {
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId, 3);
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + i2, 3);
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + dialogId, tLRPC$Dialog.notify_settings.mute_until);
                    editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + i2, tLRPC$Dialog.notify_settings.mute_until);
                }
            }
        }
        if (editorEdit != null) {
            editorEdit.apply();
        }
    }

    public void reloadMentionsCountForChannel(final TLRPC$InputPeer tLRPC$InputPeer, final long j) {
        NativeByteBuffer nativeByteBuffer;
        Exception e;
        if (j == 0) {
            try {
                nativeByteBuffer = new NativeByteBuffer(tLRPC$InputPeer.getObjectSize() + 4);
            } catch (Exception e2) {
                nativeByteBuffer = null;
                e = e2;
            }
            try {
                nativeByteBuffer.writeInt32(22);
                tLRPC$InputPeer.serializeToStream(nativeByteBuffer);
            } catch (Exception e3) {
                e = e3;
                FileLog.e(e);
                j = getMessagesStorage().createPendingTask(nativeByteBuffer);
                TLRPC$TL_messages_getUnreadMentions tLRPC$TL_messages_getUnreadMentions = new TLRPC$TL_messages_getUnreadMentions();
                tLRPC$TL_messages_getUnreadMentions.peer = tLRPC$InputPeer;
                tLRPC$TL_messages_getUnreadMentions.limit = 1;
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getUnreadMentions, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda250
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$reloadMentionsCountForChannel$132(tLRPC$InputPeer, j, tLObject, tLRPC$TL_error);
                    }
                });
            }
            j = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        TLRPC$TL_messages_getUnreadMentions tLRPC$TL_messages_getUnreadMentions2 = new TLRPC$TL_messages_getUnreadMentions();
        tLRPC$TL_messages_getUnreadMentions2.peer = tLRPC$InputPeer;
        tLRPC$TL_messages_getUnreadMentions2.limit = 1;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getUnreadMentions2, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda250
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reloadMentionsCountForChannel$132(tLRPC$InputPeer, j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadMentionsCountForChannel$132(TLRPC$InputPeer tLRPC$InputPeer, long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
        if (tLRPC$messages_Messages != null) {
            int size = tLRPC$messages_Messages.count;
            if (size == 0) {
                size = tLRPC$messages_Messages.messages.size();
            }
            getMessagesStorage().resetMentionsCount(-tLRPC$InputPeer.channel_id, size);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void reloadMentionsCountForChannels(final ArrayList<Integer> arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda93
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reloadMentionsCountForChannels$133(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadMentionsCountForChannels$133(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            reloadMentionsCountForChannel(getInputPeer(-((Integer) arrayList.get(i)).intValue()), 0L);
        }
    }

    public void processDialogsUpdateRead(final LongSparseArray<Integer> longSparseArray, final LongSparseArray<Integer> longSparseArray2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda78
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDialogsUpdateRead$134(longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDialogsUpdateRead$134(LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        boolean z;
        if (longSparseArray != null) {
            z = false;
            for (int i = 0; i < longSparseArray.size(); i++) {
                long jKeyAt = longSparseArray.keyAt(i);
                TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(jKeyAt);
                if (tLRPC$Dialog != null) {
                    int i2 = tLRPC$Dialog.unread_count;
                    int iIntValue = ((Integer) longSparseArray.valueAt(i)).intValue();
                    tLRPC$Dialog.unread_count = iIntValue;
                    if (i2 != 0 && iIntValue == 0) {
                        if (!isDialogMuted(jKeyAt)) {
                            this.unreadUnmutedDialogs--;
                        }
                        if (!z) {
                            int i3 = 0;
                            while (true) {
                                DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
                                if (i3 >= dialogFilterArr.length) {
                                    break;
                                }
                                if (dialogFilterArr[i3] != null && (dialogFilterArr[i3].flags & DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0) {
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            z = true;
                        }
                    } else if (i2 == 0 && !tLRPC$Dialog.unread_mark && iIntValue != 0) {
                        if (!isDialogMuted(jKeyAt)) {
                            this.unreadUnmutedDialogs++;
                        }
                        if (!z) {
                            int i4 = 0;
                            while (true) {
                                DialogFilter[] dialogFilterArr2 = this.selectedDialogFilter;
                                if (i4 >= dialogFilterArr2.length) {
                                    break;
                                }
                                if (dialogFilterArr2[i4] != null && (dialogFilterArr2[i4].flags & DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0) {
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            z = true;
                        }
                    }
                }
            }
        } else {
            z = false;
        }
        if (longSparseArray2 != null) {
            for (int i5 = 0; i5 < longSparseArray2.size(); i5++) {
                TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(longSparseArray2.keyAt(i5));
                if (tLRPC$Dialog2 != null) {
                    tLRPC$Dialog2.unread_mentions_count = ((Integer) longSparseArray2.valueAt(i5)).intValue();
                    if (this.createdDialogMainThreadIds.contains(Long.valueOf(tLRPC$Dialog2.id))) {
                        getNotificationCenter().postNotificationName(NotificationCenter.updateMentionsCount, Long.valueOf(tLRPC$Dialog2.id), Integer.valueOf(tLRPC$Dialog2.unread_mentions_count));
                    }
                    if (!z) {
                        int i6 = 0;
                        while (true) {
                            DialogFilter[] dialogFilterArr3 = this.selectedDialogFilter;
                            if (i6 >= dialogFilterArr3.length) {
                                break;
                            }
                            if (dialogFilterArr3[i6] != null && ((dialogFilterArr3[i6].flags & DIALOG_FILTER_FLAG_EXCLUDE_MUTED) != 0 || (dialogFilterArr3[i6].flags & DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0)) {
                                break;
                            } else {
                                i6++;
                            }
                        }
                        z = true;
                    }
                }
            }
        }
        if (z) {
            sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 256);
        if (longSparseArray != null) {
            getNotificationsController().processDialogsUpdateRead((LongSparseArray<Integer>) longSparseArray);
        }
    }

    public void processDialogsUpdate(final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, ArrayList<TLRPC$EncryptedChat> arrayList, final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda158
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDialogsUpdate$136(tLRPC$messages_Dialogs, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processDialogsUpdate$136(final org.rbmain.tgnet.TLRPC$messages_Dialogs r19, final boolean r20) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.lambda$processDialogsUpdate$136(org.rbmain.tgnet.TLRPC$messages_Dialogs, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processDialogsUpdate$135(org.rbmain.tgnet.TLRPC$messages_Dialogs r21, androidx.collection.LongSparseArray r22, androidx.collection.LongSparseArray r23, boolean r24, androidx.collection.LongSparseArray r25) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.lambda$processDialogsUpdate$135(org.rbmain.tgnet.TLRPC$messages_Dialogs, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, boolean, androidx.collection.LongSparseArray):void");
    }

    public void addToViewsQueue(final MessageObject messageObject) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda111
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addToViewsQueue$137(messageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addToViewsQueue$137(MessageObject messageObject) {
        int dialogId = (int) messageObject.getDialogId();
        long id = messageObject.getId();
        ArrayList<Long> arrayList = this.channelViewsToSend.get(dialogId);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.channelViewsToSend.put(dialogId, arrayList);
        }
        if (arrayList.contains(Long.valueOf(id))) {
            return;
        }
        arrayList.add(Long.valueOf(id));
    }

    public void addToPollsQueue(long j, ArrayList<MessageObject> arrayList) {
        int i;
        LongSparseArray<MessageObject> longSparseArray = this.pollsToCheck.get(j);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray<>();
            this.pollsToCheck.put(j, longSparseArray);
            this.pollsToCheckSize++;
        }
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            longSparseArray.valueAt(i2).pollVisibleOnScreen = false;
        }
        int currentTime = getConnectionsManager().getCurrentTime();
        int size2 = arrayList.size();
        boolean z = false;
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        for (int i3 = 0; i3 < size2; i3++) {
            MessageObject messageObject = arrayList.get(i3);
            if (messageObject.type == 17) {
                TLRPC$Poll tLRPC$Poll = ((TLRPC$TL_messageMediaPoll) messageObject.messageOwner.media).poll;
                if (!tLRPC$Poll.closed && (i = tLRPC$Poll.close_date) != 0) {
                    if (i <= currentTime) {
                        z = true;
                    } else {
                        iMin = Math.min(iMin, i - currentTime);
                    }
                }
                long id = messageObject.getId();
                MessageObject messageObject2 = longSparseArray.get(id);
                if (messageObject2 != null) {
                    messageObject2.pollVisibleOnScreen = true;
                } else {
                    longSparseArray.put(id, messageObject);
                }
            }
        }
        if (z) {
            this.lastViewsCheckTime = 0L;
        } else if (iMin < 5) {
            this.lastViewsCheckTime = Math.min(this.lastViewsCheckTime, System.currentTimeMillis() - ((5 - iMin) * CloseCodes.NORMAL_CLOSURE));
        }
    }

    public void markMessageContentAsRead(MessageObject messageObject) {
        if (messageObject.scheduled) {
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        long id = messageObject.getId();
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        int i = tLRPC$Message.peer_id.channel_id;
        if (i != 0) {
            id |= i << 32;
        }
        if (tLRPC$Message.mentioned) {
            getMessagesStorage().markMentionMessageAsRead(messageObject.getId(), messageObject.messageOwner.peer_id.channel_id, messageObject.getDialogId());
        }
        arrayList.add(Long.valueOf(id));
        getMessagesStorage().markMessagesContentAsRead(arrayList, 0);
        getNotificationCenter().postNotificationName(NotificationCenter.messagesReadContent, arrayList);
        if (messageObject.getId() < 0) {
            markMessageAsRead(messageObject.getDialogId(), messageObject.messageOwner.random_id, Integer.MIN_VALUE);
            return;
        }
        if (messageObject.messageOwner.peer_id.channel_id != 0) {
            TLRPC$TL_channels_readMessageContents tLRPC$TL_channels_readMessageContents = new TLRPC$TL_channels_readMessageContents();
            TLRPC$InputChannel inputChannel = getInputChannel(messageObject.messageOwner.peer_id.channel_id);
            tLRPC$TL_channels_readMessageContents.channel = inputChannel;
            if (inputChannel == null) {
                return;
            }
            tLRPC$TL_channels_readMessageContents.id.add(Long.valueOf(messageObject.getId()));
            getConnectionsManager().sendRequest(tLRPC$TL_channels_readMessageContents, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda263
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$markMessageContentAsRead$138(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        TLRPC$TL_messages_readMessageContents tLRPC$TL_messages_readMessageContents = new TLRPC$TL_messages_readMessageContents();
        tLRPC$TL_messages_readMessageContents.id.add(Long.valueOf(messageObject.getId()));
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readMessageContents, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda204
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$markMessageContentAsRead$139(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessageContentAsRead$139(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
        }
    }

    public void markMentionMessageAsRead(long j, int i, long j2) {
        getMessagesStorage().markMentionMessageAsRead(j, i, j2);
        if (i != 0) {
            TLRPC$TL_channels_readMessageContents tLRPC$TL_channels_readMessageContents = new TLRPC$TL_channels_readMessageContents();
            TLRPC$InputChannel inputChannel = getInputChannel(i);
            tLRPC$TL_channels_readMessageContents.channel = inputChannel;
            if (inputChannel == null) {
                return;
            }
            tLRPC$TL_channels_readMessageContents.id.add(Long.valueOf(j));
            getConnectionsManager().sendRequest(tLRPC$TL_channels_readMessageContents, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda270
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$markMentionMessageAsRead$140(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        TLRPC$TL_messages_readMessageContents tLRPC$TL_messages_readMessageContents = new TLRPC$TL_messages_readMessageContents();
        tLRPC$TL_messages_readMessageContents.id.add(Long.valueOf(j));
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readMessageContents, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda195
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$markMentionMessageAsRead$141(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMentionMessageAsRead$141(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void markMessageAsRead(long r17, int r19, org.rbmain.tgnet.TLRPC$InputChannel r20, int r21, long r22) {
        /*
            r16 = this;
            r1 = r16
            r10 = r17
            r12 = r19
            r8 = r21
            r2 = 0
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 == 0) goto Lae
            if (r8 > 0) goto L12
            goto Lae
        L12:
            if (r12 == 0) goto L1f
            if (r20 != 0) goto L1f
            org.rbmain.tgnet.TLRPC$InputChannel r0 = r1.getInputChannel(r12)
            if (r0 != 0) goto L1d
            return
        L1d:
            r13 = r0
            goto L21
        L1f:
            r13 = r20
        L21:
            int r0 = (r22 > r2 ? 1 : (r22 == r2 ? 0 : -1))
            if (r0 != 0) goto L5c
            r2 = 0
            org.rbmain.tgnet.NativeByteBuffer r3 = new org.rbmain.tgnet.NativeByteBuffer     // Catch: java.lang.Exception -> L4d
            r0 = 16
            if (r13 == 0) goto L31
            int r4 = r13.getObjectSize()     // Catch: java.lang.Exception -> L4d
            goto L32
        L31:
            r4 = 0
        L32:
            int r0 = r0 + r4
            r3.<init>(r0)     // Catch: java.lang.Exception -> L4d
            r0 = 11
            r3.writeInt32(r0)     // Catch: java.lang.Exception -> L4a
            r3.writeInt64(r10)     // Catch: java.lang.Exception -> L4a
            r3.writeInt32(r12)     // Catch: java.lang.Exception -> L4a
            r3.writeInt32(r8)     // Catch: java.lang.Exception -> L4a
            if (r12 == 0) goto L52
            r13.serializeToStream(r3)     // Catch: java.lang.Exception -> L4a
            goto L52
        L4a:
            r0 = move-exception
            r2 = r3
            goto L4e
        L4d:
            r0 = move-exception
        L4e:
            org.rbmain.messenger.FileLog.e(r0)
            r3 = r2
        L52:
            org.rbmain.messenger.MessagesStorage r0 = r16.getMessagesStorage()
            long r2 = r0.createPendingTask(r3)
            r14 = r2
            goto L5e
        L5c:
            r14 = r22
        L5e:
            org.rbmain.tgnet.ConnectionsManager r0 = r16.getConnectionsManager()
            int r7 = r0.getCurrentTime()
            org.rbmain.messenger.MessagesStorage r2 = r16.getMessagesStorage()
            r9 = 0
            r3 = r17
            r5 = r19
            r6 = r7
            r8 = r21
            r2.createTaskForMid(r3, r5, r6, r7, r8, r9)
            if (r12 == 0) goto L94
            org.rbmain.tgnet.TLRPC$TL_channels_readMessageContents r0 = new org.rbmain.tgnet.TLRPC$TL_channels_readMessageContents
            r0.<init>()
            r0.channel = r13
            java.util.ArrayList<java.lang.Long> r2 = r0.id
            java.lang.Long r3 = java.lang.Long.valueOf(r17)
            r2.add(r3)
            org.rbmain.tgnet.ConnectionsManager r2 = r16.getConnectionsManager()
            org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda233 r3 = new org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda233
            r3.<init>()
            r2.sendRequest(r0, r3)
            goto Lae
        L94:
            org.rbmain.tgnet.TLRPC$TL_messages_readMessageContents r0 = new org.rbmain.tgnet.TLRPC$TL_messages_readMessageContents
            r0.<init>()
            java.util.ArrayList<java.lang.Long> r2 = r0.id
            java.lang.Long r3 = java.lang.Long.valueOf(r17)
            r2.add(r3)
            org.rbmain.tgnet.ConnectionsManager r2 = r16.getConnectionsManager()
            org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda228 r3 = new org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda228
            r3.<init>()
            r2.sendRequest(r0, r3)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.markMessageAsRead(long, int, org.rbmain.tgnet.TLRPC$InputChannel, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessageAsRead$142(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessageAsRead$143(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void markMessageAsRead(long j, long j2, int i) {
        TLRPC$EncryptedChat encryptedChat;
        if (j2 == 0 || j == 0) {
            return;
        }
        if (i > 0 || i == Integer.MIN_VALUE) {
            int i2 = (int) (j >> 32);
            if (((int) j) == 0 && (encryptedChat = getEncryptedChat(Integer.valueOf(i2))) != null) {
                ArrayList<Long> arrayList = new ArrayList<>();
                arrayList.add(Long.valueOf(j2));
                getSecretChatHelper().sendMessagesReadMessage(encryptedChat, arrayList, null);
                if (i > 0) {
                    int currentTime = getConnectionsManager().getCurrentTime();
                    getMessagesStorage().createTaskForSecretChat(encryptedChat.id, currentTime, currentTime, 0, arrayList);
                }
            }
        }
    }

    private void checkReadTasks() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int size = this.readTasks.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            ReadTask readTask = this.readTasks.get(i2);
            if (readTask.sendRequestTime <= jElapsedRealtime) {
                completeReadTask(readTask);
                this.readTasks.remove(i2);
                this.readTasksMap.remove(readTask.dialogId);
                i2--;
                size--;
            }
            i2++;
        }
        int size2 = this.repliesReadTasks.size();
        while (i < size2) {
            ReadTask readTask2 = this.repliesReadTasks.get(i);
            if (readTask2.sendRequestTime <= jElapsedRealtime) {
                completeReadTask(readTask2);
                this.repliesReadTasks.remove(i);
                this.threadsReadTasksMap.remove(readTask2.replyId);
                i--;
                size2--;
            }
            i++;
        }
    }

    public void markDialogAsReadNow(final long j, final long j2) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda67
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markDialogAsReadNow$144(j2, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markDialogAsReadNow$144(long j, long j2) {
        if (j != 0) {
            ReadTask readTask = this.threadsReadTasksMap.get(j);
            if (readTask == null) {
                return;
            }
            completeReadTask(readTask);
            this.repliesReadTasks.remove(readTask);
            this.threadsReadTasksMap.remove(j);
            return;
        }
        ReadTask readTask2 = this.readTasksMap.get(j2);
        if (readTask2 == null) {
            return;
        }
        completeReadTask(readTask2);
        this.readTasks.remove(readTask2);
        this.readTasksMap.remove(j2);
    }

    public void markMentionsAsRead(long j) {
        int i = (int) j;
        if (i == 0) {
            return;
        }
        getMessagesStorage().resetMentionsCount(j, 0);
        TLRPC$TL_messages_readMentions tLRPC$TL_messages_readMentions = new TLRPC$TL_messages_readMentions();
        tLRPC$TL_messages_readMentions.peer = getInputPeer(i);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readMentions, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda273
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$markMentionsAsRead$145(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void markDialogAsRead(final long j, final long j2, long j3, int i, final boolean z, long j4, final int i2, boolean z2, int i3) {
        int i4 = (int) j;
        if (j4 == 0) {
            boolean z3 = getNotificationsController().showBadgeMessages;
            if (i4 != 0) {
                if (j2 == 0) {
                    return;
                }
                if (i4 < 0) {
                    ChatObject.isChannel(getChat(Integer.valueOf(-i4)));
                }
                Long l = this.dialogs_read_inbox_max.get(Long.valueOf(j));
                if (l == null) {
                    l = 0L;
                }
                this.dialogs_read_inbox_max.put(Long.valueOf(j), Long.valueOf(Math.max(l.longValue(), j2)));
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda66
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$markDialogAsRead$147(j, i2, z, j2);
                    }
                });
            }
        }
        getMessagesProxy().seenChat(i4, j2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markDialogAsRead$147(final long j, final int i, final boolean z, final long j2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda65
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markDialogAsRead$146(j, i, z, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markDialogAsRead$146(long j, int i, boolean z, long j2) {
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        if (tLRPC$Dialog != null) {
            int i2 = tLRPC$Dialog.unread_count;
            tLRPC$Dialog.unread_count = Math.max(i2 - i, 0);
            getMessagesProxy().setUnreadCount(j, tLRPC$Dialog.unread_count);
            boolean z2 = tLRPC$Dialog.unread_mark;
            if (z2) {
                tLRPC$Dialog.unread_mark = false;
                getMessagesStorage().setDialogUnread(tLRPC$Dialog.id, false);
            }
            if ((i2 != 0 || z2) && tLRPC$Dialog.unread_count == 0) {
                if (!isDialogMuted(j)) {
                    this.unreadUnmutedDialogs--;
                }
                int i3 = 0;
                while (true) {
                    DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
                    if (i3 < dialogFilterArr.length) {
                        if (dialogFilterArr[i3] != null && (dialogFilterArr[i3].flags & DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0) {
                            sortDialogs(null);
                            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
            }
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 256);
        }
        if (!z) {
            getNotificationsController().processReadMessages((LongSparseIntArray) null, j, 0, j2, false);
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(1);
            longSparseArray.put(j, 0);
            getNotificationsController().processDialogsUpdateRead(longSparseArray);
            return;
        }
        getNotificationsController().processReadMessages((LongSparseIntArray) null, j, 0, j2, true);
        LongSparseArray<Integer> longSparseArray2 = new LongSparseArray<>(1);
        longSparseArray2.put(j, -1);
        getNotificationsController().processDialogsUpdateRead(longSparseArray2);
    }

    public int createChat(String str, ArrayList<Integer> arrayList, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, String str2, int i, boolean z, Location location, String str3, final BaseFragment baseFragment) {
        if (i == 0 && !z) {
            final TLRPC$TL_messages_createChat tLRPC$TL_messages_createChat = new TLRPC$TL_messages_createChat();
            tLRPC$TL_messages_createChat.title = str;
            tLRPC$TL_messages_createChat.photo = tLRPC$InputFile;
            tLRPC$TL_messages_createChat.smallPhoto = tLRPC$InputFile2;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                TLRPC$User user = getUser(arrayList.get(i2));
                if (user != null) {
                    tLRPC$TL_messages_createChat.users.add(getInputUser(user));
                }
            }
            return getDialogsProxy().createChat(tLRPC$TL_messages_createChat, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda256
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createChat$150(baseFragment, tLRPC$TL_messages_createChat, tLObject, tLRPC$TL_error);
                }
            });
        }
        if (z || i == 2 || i == 4) {
            TLRPC$TL_channels_createChannel tLRPC$TL_channels_createChannel = new TLRPC$TL_channels_createChannel();
            tLRPC$TL_channels_createChannel.title = str;
            if (str2 == null) {
                str2 = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            tLRPC$TL_channels_createChannel.about = str2;
            tLRPC$TL_channels_createChannel.for_import = z;
            if (z || i == 4) {
                tLRPC$TL_channels_createChannel.megagroup = true;
            } else {
                tLRPC$TL_channels_createChannel.broadcast = true;
            }
            if (location != null) {
                TLRPC$TL_inputGeoPoint tLRPC$TL_inputGeoPoint = new TLRPC$TL_inputGeoPoint();
                tLRPC$TL_channels_createChannel.geo_point = tLRPC$TL_inputGeoPoint;
                tLRPC$TL_inputGeoPoint.lat = location.getLatitude();
                tLRPC$TL_channels_createChannel.geo_point._long = location.getLongitude();
                tLRPC$TL_channels_createChannel.address = str3;
                tLRPC$TL_channels_createChannel.flags |= 4;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createChat$151();
                }
            });
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createChat$150(final BaseFragment baseFragment, final TLRPC$TL_messages_createChat tLRPC$TL_messages_createChat, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda139
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createChat$148(tLRPC$TL_error, baseFragment, tLRPC$TL_messages_createChat);
                }
            });
        } else {
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda149
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createChat$149(tLRPC$Updates);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createChat$148(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_createChat tLRPC$TL_messages_createChat) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_createChat, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.chatDidFailCreate, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createChat$149(TLRPC$Updates tLRPC$Updates) {
        ArrayList<TLRPC$Chat> arrayList = tLRPC$Updates.chats;
        if (arrayList != null && !arrayList.isEmpty()) {
            getNotificationCenter().postNotificationName(NotificationCenter.chatDidCreated, Integer.valueOf(tLRPC$Updates.chats.get(0).id));
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.chatDidFailCreate, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createChat$151() {
        getNotificationCenter().postNotificationName(NotificationCenter.chatDidCreated, Integer.valueOf(ConnectionsManager.DEFAULT_DATACENTER_ID));
    }

    public void convertToMegaGroup(final Context context, int i, final BaseFragment baseFragment, final MessagesStorage.IntCallback intCallback) {
        final TLRPC$TL_messages_migrateChat tLRPC$TL_messages_migrateChat = new TLRPC$TL_messages_migrateChat();
        tLRPC$TL_messages_migrateChat.chat_id = i;
        AlertDialog alertDialog = context != null ? new AlertDialog(context, 3) : null;
        final AlertDialog alertDialog2 = alertDialog;
        final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_migrateChat, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda240
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$convertToMegaGroup$155(context, alertDialog2, intCallback, baseFragment, tLRPC$TL_messages_migrateChat, tLObject, tLRPC$TL_error);
            }
        });
        if (alertDialog != null) {
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$convertToMegaGroup$156(iSendRequest, dialogInterface);
                }
            });
            try {
                alertDialog.show();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convertToMegaGroup$155(final Context context, final AlertDialog alertDialog, final MessagesStorage.IntCallback intCallback, final BaseFragment baseFragment, final TLRPC$TL_messages_migrateChat tLRPC$TL_messages_migrateChat, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            if (context != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessagesController.lambda$convertToMegaGroup$152(context, alertDialog);
                    }
                });
            }
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            processUpdates(tLRPC$Updates, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda177
                @Override // java.lang.Runnable
                public final void run() {
                    MessagesController.lambda$convertToMegaGroup$153(intCallback, tLRPC$Updates);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda113
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$convertToMegaGroup$154(intCallback, context, alertDialog, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_migrateChat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertToMegaGroup$152(Context context, AlertDialog alertDialog) {
        if (((Activity) context).isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertToMegaGroup$153(MessagesStorage.IntCallback intCallback, TLRPC$Updates tLRPC$Updates) {
        if (intCallback != null) {
            for (int i = 0; i < tLRPC$Updates.chats.size(); i++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$Updates.chats.get(i);
                if (ChatObject.isChannel(tLRPC$Chat)) {
                    intCallback.run(tLRPC$Chat.id);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convertToMegaGroup$154(MessagesStorage.IntCallback intCallback, Context context, AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_migrateChat tLRPC$TL_messages_migrateChat) {
        if (intCallback != null) {
            intCallback.run(0);
        }
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_migrateChat, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convertToMegaGroup$156(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }

    public void convertToGigaGroup(final Context context, TLRPC$Chat tLRPC$Chat, final BaseFragment baseFragment, final MessagesStorage.BooleanCallback booleanCallback) {
        final TLRPC$TL_channels_convertToGigagroup tLRPC$TL_channels_convertToGigagroup = new TLRPC$TL_channels_convertToGigagroup();
        tLRPC$TL_channels_convertToGigagroup.channel = getInputChannel(tLRPC$Chat);
        AlertDialog alertDialog = context != null ? new AlertDialog(context, 3) : null;
        final AlertDialog alertDialog2 = alertDialog;
        final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_channels_convertToGigagroup, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda239
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$convertToGigaGroup$160(context, alertDialog2, booleanCallback, baseFragment, tLRPC$TL_channels_convertToGigagroup, tLObject, tLRPC$TL_error);
            }
        });
        if (alertDialog != null) {
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$convertToGigaGroup$161(iSendRequest, dialogInterface);
                }
            });
            try {
                alertDialog.showDelayed(400L);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convertToGigaGroup$160(final Context context, final AlertDialog alertDialog, final MessagesStorage.BooleanCallback booleanCallback, final BaseFragment baseFragment, final TLRPC$TL_channels_convertToGigagroup tLRPC$TL_channels_convertToGigagroup, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            if (context != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessagesController.lambda$convertToGigaGroup$157(context, alertDialog);
                    }
                });
            }
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda176
                @Override // java.lang.Runnable
                public final void run() {
                    MessagesController.lambda$convertToGigaGroup$158(booleanCallback);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda112
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$convertToGigaGroup$159(booleanCallback, context, alertDialog, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_convertToGigagroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertToGigaGroup$157(Context context, AlertDialog alertDialog) {
        if (((Activity) context).isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertToGigaGroup$158(MessagesStorage.BooleanCallback booleanCallback) {
        if (booleanCallback != null) {
            booleanCallback.run(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convertToGigaGroup$159(MessagesStorage.BooleanCallback booleanCallback, Context context, AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_convertToGigagroup tLRPC$TL_channels_convertToGigagroup) {
        if (booleanCallback != null) {
            booleanCallback.run(false);
        }
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_convertToGigagroup, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convertToGigaGroup$161(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }

    public void addUsersToChannel(int i, ArrayList<TLRPC$InputUser> arrayList, final BaseFragment baseFragment) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        final TLRPC$TL_channels_inviteToChannel tLRPC$TL_channels_inviteToChannel = new TLRPC$TL_channels_inviteToChannel();
        tLRPC$TL_channels_inviteToChannel.channel = getInputChannel(i);
        tLRPC$TL_channels_inviteToChannel.users = arrayList;
        getDialogsProxy().addMembersToChat(tLRPC$TL_channels_inviteToChannel, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda255
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$addUsersToChannel$163(baseFragment, tLRPC$TL_channels_inviteToChannel, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUsersToChannel$162(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_inviteToChannel tLRPC$TL_channels_inviteToChannel) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_inviteToChannel, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUsersToChannel$163(final BaseFragment baseFragment, final TLRPC$TL_channels_inviteToChannel tLRPC$TL_channels_inviteToChannel, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda138
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUsersToChannel$162(tLRPC$TL_error, baseFragment, tLRPC$TL_channels_inviteToChannel);
                }
            });
        } else {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public void toogleChannelSignatures(int i, boolean z) {
        TLRPC$TL_channels_toggleSignatures tLRPC$TL_channels_toggleSignatures = new TLRPC$TL_channels_toggleSignatures();
        tLRPC$TL_channels_toggleSignatures.channel = getInputChannel(i);
        tLRPC$TL_channels_toggleSignatures.enabled = z;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_toggleSignatures, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda199
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toogleChannelSignatures$165(tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toogleChannelSignatures$165(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$toogleChannelSignatures$164();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toogleChannelSignatures$164() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 8192);
    }

    public void toogleChannelInvitesHistory(int i, boolean z) {
        TLRPC$TL_channels_togglePreHistoryHidden tLRPC$TL_channels_togglePreHistoryHidden = new TLRPC$TL_channels_togglePreHistoryHidden();
        tLRPC$TL_channels_togglePreHistoryHidden.channel = getInputChannel(i);
        tLRPC$TL_channels_togglePreHistoryHidden.enabled = z;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_togglePreHistoryHidden, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda209
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toogleChannelInvitesHistory$167(tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toogleChannelInvitesHistory$167(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$toogleChannelInvitesHistory$166();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toogleChannelInvitesHistory$166() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 8192);
    }

    public void updateChatAbout(int i, final String str, final TLRPC$ChatFull tLRPC$ChatFull) {
        TLRPC$TL_messages_editChatAbout tLRPC$TL_messages_editChatAbout = new TLRPC$TL_messages_editChatAbout();
        tLRPC$TL_messages_editChatAbout.peer = getInputPeer(-i);
        tLRPC$TL_messages_editChatAbout.about = str;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatAbout, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda249
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$updateChatAbout$169(tLRPC$ChatFull, str, tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatAbout$169(final TLRPC$ChatFull tLRPC$ChatFull, final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (!(tLObject instanceof TLRPC$TL_boolTrue) || tLRPC$ChatFull == null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda128
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatAbout$168(tLRPC$ChatFull, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatAbout$168(TLRPC$ChatFull tLRPC$ChatFull, String str) {
        tLRPC$ChatFull.about = str;
        getMessagesStorage().updateChatInfo(tLRPC$ChatFull, false);
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.chatInfoDidLoad;
        Boolean bool = Boolean.FALSE;
        notificationCenter.postNotificationName(i, tLRPC$ChatFull, 0, bool, bool);
    }

    public void updateChannelUserName(final int i, final String str) {
        TLRPC$TL_channels_updateUsername tLRPC$TL_channels_updateUsername = new TLRPC$TL_channels_updateUsername();
        tLRPC$TL_channels_updateUsername.channel = getInputChannel(i);
        tLRPC$TL_channels_updateUsername.username = str;
        getDialogsProxy().updateChannelUserName(tLRPC$TL_channels_updateUsername, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda221
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$updateChannelUserName$171(i, str, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChannelUserName$171(final int i, final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda52
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateChannelUserName$170(i, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChannelUserName$170(int i, String str) {
        TLRPC$Chat chat = getChat(Integer.valueOf(i));
        if (str.length() != 0) {
            chat.flags |= 64;
        } else {
            chat.flags &= -65;
        }
        chat.username = str;
        ArrayList<TLRPC$Chat> arrayList = new ArrayList<>();
        arrayList.add(chat);
        getMessagesStorage().putUsersAndChats(null, arrayList, true, true);
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 8192);
    }

    public void sendBotStart(TLRPC$User tLRPC$User, String str) {
        if (tLRPC$User == null) {
            return;
        }
        TLRPC$TL_messages_startBot tLRPC$TL_messages_startBot = new TLRPC$TL_messages_startBot();
        tLRPC$TL_messages_startBot.bot = getInputUser(tLRPC$User);
        tLRPC$TL_messages_startBot.peer = getInputPeer(tLRPC$User.id);
        tLRPC$TL_messages_startBot.start_param = str;
        tLRPC$TL_messages_startBot.random_id = Utilities.random.nextLong();
        getConnectionsManager().sendRequest(tLRPC$TL_messages_startBot, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda200
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendBotStart$172(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendBotStart$172(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        processUpdates((TLRPC$Updates) tLObject, false);
    }

    public boolean isJoiningChannel(int i) {
        return this.joiningToChannels.contains(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addUserToChat(final int i, TLRPC$User tLRPC$User, int i2, String str, final BaseFragment baseFragment, final Runnable runnable) {
        TLRPC$TL_messages_addChatUser tLRPC$TL_messages_addChatUser;
        if (tLRPC$User == null) {
            return;
        }
        final boolean zIsChannel = ChatObject.isChannel(i, this.currentAccount);
        final boolean z = zIsChannel && getChat(Integer.valueOf(i)).megagroup;
        final TLRPC$InputUser inputUser = getInputUser(tLRPC$User);
        if (str != null && (!zIsChannel || z)) {
            TLRPC$TL_messages_startBot tLRPC$TL_messages_startBot = new TLRPC$TL_messages_startBot();
            tLRPC$TL_messages_startBot.bot = inputUser;
            if (zIsChannel) {
                tLRPC$TL_messages_startBot.peer = getInputPeer(-i);
            } else {
                TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
                tLRPC$TL_messages_startBot.peer = tLRPC$TL_inputPeerChat;
                tLRPC$TL_inputPeerChat.chat_id = i;
            }
            tLRPC$TL_messages_startBot.start_param = str;
            tLRPC$TL_messages_startBot.random_id = Utilities.random.nextLong();
            tLRPC$TL_messages_addChatUser = tLRPC$TL_messages_startBot;
        } else if (zIsChannel) {
            if (inputUser instanceof TLRPC$TL_inputUserSelf) {
                if (this.joiningToChannels.contains(Integer.valueOf(i))) {
                    return;
                }
                TLRPC$TL_channels_joinChannel tLRPC$TL_channels_joinChannel = new TLRPC$TL_channels_joinChannel();
                tLRPC$TL_channels_joinChannel.channel = getInputChannel(i);
                this.joiningToChannels.add(Integer.valueOf(i));
                tLRPC$TL_messages_addChatUser = tLRPC$TL_channels_joinChannel;
            } else {
                TLRPC$TL_channels_inviteToChannel tLRPC$TL_channels_inviteToChannel = new TLRPC$TL_channels_inviteToChannel();
                tLRPC$TL_channels_inviteToChannel.channel = getInputChannel(i);
                tLRPC$TL_channels_inviteToChannel.users.add(inputUser);
                tLRPC$TL_messages_addChatUser = tLRPC$TL_channels_inviteToChannel;
            }
        } else {
            TLRPC$TL_messages_addChatUser tLRPC$TL_messages_addChatUser2 = new TLRPC$TL_messages_addChatUser();
            tLRPC$TL_messages_addChatUser2.chat_id = i;
            tLRPC$TL_messages_addChatUser2.fwd_limit = i2;
            tLRPC$TL_messages_addChatUser2.user_id = inputUser;
            tLRPC$TL_messages_addChatUser = tLRPC$TL_messages_addChatUser2;
        }
        final TLRPC$TL_messages_addChatUser tLRPC$TL_messages_addChatUser3 = tLRPC$TL_messages_addChatUser;
        getDialogsProxy().addMembersToChat(tLRPC$TL_messages_addChatUser3, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda259
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$addUserToChat$176(zIsChannel, inputUser, i, baseFragment, tLRPC$TL_messages_addChatUser3, z, runnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUserToChat$176(final boolean z, final TLRPC$InputUser tLRPC$InputUser, final int i, final BaseFragment baseFragment, final TLObject tLObject, final boolean z2, Runnable runnable, TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        if (z && (tLRPC$InputUser instanceof TLRPC$TL_inputUserSelf)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUserToChat$173(i);
                }
            });
        }
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda135
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUserToChat$174(tLRPC$TL_error, baseFragment, tLObject, z, z2, tLRPC$InputUser);
                }
            });
            return;
        }
        TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject2;
        for (int i2 = 0; i2 < tLRPC$Updates.updates.size(); i2++) {
            TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i2);
            if ((tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) && (((TLRPC$TL_updateNewChannelMessage) tLRPC$Update).message.action instanceof TLRPC$TL_messageActionChatAddUser)) {
                break;
            }
        }
        processUpdates(tLRPC$Updates, false);
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda42
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUserToChat$175(i);
                }
            }, 1000L);
        }
        if (runnable != null) {
            AndroidUtilities.runOnUIThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUserToChat$173(int i) {
        this.joiningToChannels.remove(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUserToChat$174(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLObject tLObject, boolean z, boolean z2, TLRPC$InputUser tLRPC$InputUser) {
        int i = this.currentAccount;
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(z && !z2);
        AlertsCreator.processError(i, tLRPC$TL_error, baseFragment, tLObject, objArr);
        if (z && (tLRPC$InputUser instanceof TLRPC$TL_inputUserSelf)) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 8192);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUserToChat$175(int i) {
        loadFullChat(i, 0, false);
    }

    public void deleteParticipantFromChat(int i, TLRPC$User tLRPC$User, TLRPC$ChatFull tLRPC$ChatFull) {
        deleteParticipantFromChat(i, tLRPC$User, null, tLRPC$ChatFull, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void deleteParticipantFromChat(final int i, final TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, TLRPC$ChatFull tLRPC$ChatFull, boolean z, boolean z2) {
        TLRPC$InputPeer inputPeer;
        TLRPC$TL_messages_deleteChatUser tLRPC$TL_messages_deleteChatUser;
        if (tLRPC$User == null && tLRPC$Chat == null) {
            return;
        }
        if (tLRPC$User != null) {
            inputPeer = getInputPeer(tLRPC$User);
        } else {
            inputPeer = getInputPeer(tLRPC$Chat);
        }
        TLRPC$Chat chat = getChat(Integer.valueOf(i));
        final boolean z3 = ChatObject.isChannel(chat) && !chat.megagroup;
        if (z3) {
            if (UserObject.isUserSelf(tLRPC$User)) {
                if (getDialogsProxy().canRemoveObject(chat.id) && z) {
                    TLRPC$TL_channels_deleteChannel tLRPC$TL_channels_deleteChannel = new TLRPC$TL_channels_deleteChannel();
                    tLRPC$TL_channels_deleteChannel.channel = getInputChannel(chat);
                    tLRPC$TL_messages_deleteChatUser = tLRPC$TL_channels_deleteChannel;
                } else {
                    TLRPC$TL_channels_leaveChannel tLRPC$TL_channels_leaveChannel = new TLRPC$TL_channels_leaveChannel();
                    tLRPC$TL_channels_leaveChannel.channel = getInputChannel(chat);
                    tLRPC$TL_messages_deleteChatUser = tLRPC$TL_channels_leaveChannel;
                }
            } else {
                TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned = new TLRPC$TL_channels_editBanned();
                tLRPC$TL_channels_editBanned.channel = getInputChannel(chat);
                tLRPC$TL_channels_editBanned.participant = inputPeer;
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = new TLRPC$TL_chatBannedRights();
                tLRPC$TL_channels_editBanned.banned_rights = tLRPC$TL_chatBannedRights;
                tLRPC$TL_chatBannedRights.view_messages = true;
                tLRPC$TL_chatBannedRights.send_media = true;
                tLRPC$TL_chatBannedRights.send_messages = true;
                tLRPC$TL_chatBannedRights.send_stickers = true;
                tLRPC$TL_chatBannedRights.send_gifs = true;
                tLRPC$TL_chatBannedRights.send_games = true;
                tLRPC$TL_chatBannedRights.send_inline = true;
                tLRPC$TL_chatBannedRights.embed_links = true;
                tLRPC$TL_chatBannedRights.pin_messages = true;
                tLRPC$TL_chatBannedRights.send_polls = true;
                tLRPC$TL_chatBannedRights.invite_users = true;
                tLRPC$TL_chatBannedRights.change_info = true;
                tLRPC$TL_messages_deleteChatUser = tLRPC$TL_channels_editBanned;
            }
        } else if (z) {
            TLRPC$TL_messages_deleteChat tLRPC$TL_messages_deleteChat = new TLRPC$TL_messages_deleteChat();
            tLRPC$TL_messages_deleteChat.chat_id = i;
            getDialogsProxy().deleteGroup(tLRPC$TL_messages_deleteChat, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda279
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$deleteParticipantFromChat$177(tLObject, tLRPC$TL_error);
                }
            });
            return;
        } else {
            TLRPC$TL_messages_deleteChatUser tLRPC$TL_messages_deleteChatUser2 = new TLRPC$TL_messages_deleteChatUser();
            tLRPC$TL_messages_deleteChatUser2.chat_id = i;
            tLRPC$TL_messages_deleteChatUser2.user_id = getInputUser(tLRPC$User);
            tLRPC$TL_messages_deleteChatUser2.revoke_history = true;
            tLRPC$TL_messages_deleteChatUser = tLRPC$TL_messages_deleteChatUser2;
        }
        if (UserObject.isUserSelf(tLRPC$User)) {
            deleteDialog(-i, 0, z2);
        }
        getDialogsProxy().removeMemberFromChat(tLRPC$TL_messages_deleteChatUser, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda260
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteParticipantFromChat$179(z3, tLRPC$User, i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteParticipantFromChat$179(boolean z, TLRPC$User tLRPC$User, final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        processUpdates((TLRPC$Updates) tLObject, false);
        if (!z || UserObject.isUserSelf(tLRPC$User)) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteParticipantFromChat$178(i);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteParticipantFromChat$178(int i) {
        loadFullChat(i, 0, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void changeChatTitle(int i, String str) {
        TLRPC$TL_messages_editChatTitle tLRPC$TL_messages_editChatTitle;
        if (i > 0) {
            if (ChatObject.isChannel(i, this.currentAccount)) {
                TLRPC$TL_channels_editTitle tLRPC$TL_channels_editTitle = new TLRPC$TL_channels_editTitle();
                tLRPC$TL_channels_editTitle.channel = getInputChannel(i);
                tLRPC$TL_channels_editTitle.title = str;
                tLRPC$TL_messages_editChatTitle = tLRPC$TL_channels_editTitle;
            } else {
                TLRPC$TL_messages_editChatTitle tLRPC$TL_messages_editChatTitle2 = new TLRPC$TL_messages_editChatTitle();
                tLRPC$TL_messages_editChatTitle2.chat_id = i;
                tLRPC$TL_messages_editChatTitle2.title = str;
                tLRPC$TL_messages_editChatTitle = tLRPC$TL_messages_editChatTitle2;
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatTitle, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda202
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$changeChatTitle$180(tLObject, tLRPC$TL_error);
                }
            }, 64);
            return;
        }
        TLRPC$Chat chat = getChat(Integer.valueOf(i));
        chat.title = str;
        ArrayList<TLRPC$Chat> arrayList = new ArrayList<>();
        arrayList.add(chat);
        getMessagesStorage().putUsersAndChats(null, arrayList, true, true);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeChatTitle$180(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        processUpdates((TLRPC$Updates) tLObject, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [org.rbmain.tgnet.TLRPC$TL_inputChatPhotoEmpty] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.rbmain.tgnet.TLRPC$TL_inputChatUploadedPhoto] */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.rbmain.tgnet.TLRPC$TL_inputChatPhotoEmpty] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [org.rbmain.tgnet.TLRPC$TL_inputChatUploadedPhoto] */
    public void changeChatAvatar(int i, final TLRPC$TL_inputChatPhoto tLRPC$TL_inputChatPhoto, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, TLRPC$InputFile tLRPC$InputFile3, double d, final String str, final TLRPC$FileLocation tLRPC$FileLocation, final TLRPC$FileLocation tLRPC$FileLocation2, final Runnable runnable) {
        ?? tLRPC$TL_inputChatUploadedPhoto;
        ?? tLRPC$TL_inputChatUploadedPhoto2;
        MessagesController messagesController;
        TLRPC$TL_inputChatPhoto tLRPC$TL_inputChatPhoto2;
        TLRPC$TL_inputChatPhoto tLRPC$TL_inputChatPhoto3;
        TLRPC$TL_messages_editChatPhoto tLRPC$TL_messages_editChatPhoto;
        if (tLRPC$TL_inputChatPhoto != null) {
            messagesController = this;
            TLRPC$TL_inputChatPhoto tLRPC$TL_inputChatPhoto4 = tLRPC$TL_inputChatPhoto;
            tLRPC$TL_inputChatPhoto2 = tLRPC$TL_inputChatPhoto4;
            tLRPC$TL_inputChatPhoto3 = tLRPC$TL_inputChatPhoto4;
        } else {
            if ((tLRPC$InputFile != null && tLRPC$InputFile3 != null) || tLRPC$InputFile2 != null) {
                tLRPC$TL_inputChatUploadedPhoto = new TLRPC$TL_inputChatUploadedPhoto();
                tLRPC$TL_inputChatUploadedPhoto2 = new TLRPC$TL_inputChatUploadedPhoto();
                if (tLRPC$InputFile != null) {
                    tLRPC$TL_inputChatUploadedPhoto.file = tLRPC$InputFile;
                    tLRPC$TL_inputChatUploadedPhoto.flags |= 1;
                }
                if (tLRPC$InputFile3 != null) {
                    tLRPC$TL_inputChatUploadedPhoto2.file = tLRPC$InputFile3;
                    tLRPC$TL_inputChatUploadedPhoto2.flags |= 1;
                }
                if (tLRPC$InputFile2 != null) {
                    tLRPC$TL_inputChatUploadedPhoto.video = tLRPC$InputFile2;
                    int i2 = tLRPC$TL_inputChatUploadedPhoto.flags | 2;
                    tLRPC$TL_inputChatUploadedPhoto.flags = i2;
                    tLRPC$TL_inputChatUploadedPhoto.video_start_ts = d;
                    tLRPC$TL_inputChatUploadedPhoto.flags = i2 | 4;
                }
            } else {
                tLRPC$TL_inputChatUploadedPhoto = new TLRPC$InputChatPhoto() { // from class: org.rbmain.tgnet.TLRPC$TL_inputChatPhotoEmpty
                    public static int constructor = 480546647;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                        abstractSerializedData.writeInt32(constructor);
                    }
                };
                tLRPC$TL_inputChatUploadedPhoto2 = new TLRPC$InputChatPhoto() { // from class: org.rbmain.tgnet.TLRPC$TL_inputChatPhotoEmpty
                    public static int constructor = 480546647;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                        abstractSerializedData.writeInt32(constructor);
                    }
                };
            }
            messagesController = this;
            tLRPC$TL_inputChatPhoto3 = tLRPC$TL_inputChatUploadedPhoto;
            tLRPC$TL_inputChatPhoto2 = tLRPC$TL_inputChatUploadedPhoto2;
        }
        if (ChatObject.isChannel(i, messagesController.currentAccount)) {
            TLRPC$TL_channels_editPhoto tLRPC$TL_channels_editPhoto = new TLRPC$TL_channels_editPhoto();
            tLRPC$TL_channels_editPhoto.channel = getInputChannel(i);
            tLRPC$TL_channels_editPhoto.photo = tLRPC$TL_inputChatPhoto3;
            tLRPC$TL_channels_editPhoto.smallPhoto = tLRPC$TL_inputChatPhoto2;
            tLRPC$TL_messages_editChatPhoto = tLRPC$TL_channels_editPhoto;
        } else {
            TLRPC$TL_messages_editChatPhoto tLRPC$TL_messages_editChatPhoto2 = new TLRPC$TL_messages_editChatPhoto();
            tLRPC$TL_messages_editChatPhoto2.chat_id = i;
            tLRPC$TL_messages_editChatPhoto2.photo = tLRPC$TL_inputChatPhoto3;
            tLRPC$TL_messages_editChatPhoto = tLRPC$TL_messages_editChatPhoto2;
        }
        getAccountInstance().getFileProxy().sendUploadPhotoReq(tLRPC$TL_messages_editChatPhoto, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda251
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$changeChatAvatar$182(tLRPC$TL_inputChatPhoto, tLRPC$FileLocation, tLRPC$FileLocation2, str, runnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeChatAvatar$182(TLRPC$TL_inputChatPhoto tLRPC$TL_inputChatPhoto, TLRPC$FileLocation tLRPC$FileLocation, TLRPC$FileLocation tLRPC$FileLocation2, String str, final Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        TLRPC$Photo tLRPC$Photo;
        if (tLRPC$TL_error != null) {
            return;
        }
        TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
        if (tLRPC$TL_inputChatPhoto == null) {
            int size = tLRPC$Updates.updates.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    tLRPC$Photo = null;
                    break;
                }
                TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
                if (tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) {
                    TLRPC$MessageAction tLRPC$MessageAction = ((TLRPC$TL_updateNewChannelMessage) tLRPC$Update).message.action;
                    if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionChatEditPhoto) {
                        tLRPC$Photo = tLRPC$MessageAction.photo;
                        if (tLRPC$Photo instanceof TLRPC$TL_photo) {
                            break;
                        }
                    } else {
                        continue;
                    }
                    i++;
                } else {
                    if (tLRPC$Update instanceof TLRPC$TL_updateNewMessage) {
                        TLRPC$MessageAction tLRPC$MessageAction2 = ((TLRPC$TL_updateNewMessage) tLRPC$Update).message.action;
                        if (tLRPC$MessageAction2 instanceof TLRPC$TL_messageActionChatEditPhoto) {
                            tLRPC$Photo = tLRPC$MessageAction2.photo;
                            if (tLRPC$Photo instanceof TLRPC$TL_photo) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                    i++;
                }
            }
            if (tLRPC$Photo != null) {
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
                TLRPC$VideoSize tLRPC$VideoSize = tLRPC$Photo.video_sizes.isEmpty() ? null : tLRPC$Photo.video_sizes.get(0);
                if (closestPhotoSizeWithSize != null && tLRPC$FileLocation != null) {
                    FileLoader.getPathToAttach(tLRPC$FileLocation, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize, true));
                    ImageLoader.getInstance().replaceImageInCache(tLRPC$FileLocation.volume_id + "_" + tLRPC$FileLocation.local_id + "@50_50", closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@50_50", ImageLocation.getForPhoto(closestPhotoSizeWithSize, tLRPC$Photo), true);
                }
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, MediaController.MAX_WIDTH_HEIGHT_SIZE);
                if (closestPhotoSizeWithSize2 != null && tLRPC$FileLocation2 != null) {
                    FileLoader.getPathToAttach(tLRPC$FileLocation2, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize2, true));
                }
                if (tLRPC$VideoSize != null && str != null) {
                    new File(str).renameTo(FileLoader.getPathToAttach(tLRPC$VideoSize, "mp4", true));
                }
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda80
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$changeChatAvatar$181(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeChatAvatar$181(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.updateInterfaces;
        notificationCenter.postNotificationName(i, 2);
        getNotificationCenter().postNotificationName(i, 8, Boolean.TRUE);
    }

    public void unregistedPush() {
        if (getUserConfig().registeredForPush && SharedConfig.pushString.length() == 0) {
            TLRPC$TL_account_unregisterDevice tLRPC$TL_account_unregisterDevice = new TLRPC$TL_account_unregisterDevice();
            tLRPC$TL_account_unregisterDevice.token = SharedConfig.pushString;
            tLRPC$TL_account_unregisterDevice.token_type = 2;
            for (int i = 0; i < 3; i++) {
                UserConfig userConfig = UserConfig.getInstance(i);
                if (i != this.currentAccount && userConfig.isClientActivated()) {
                    tLRPC$TL_account_unregisterDevice.other_uids.add(Integer.valueOf(userConfig.getClientUserId()));
                }
            }
            getConnectionsManager().sendRequest(tLRPC$TL_account_unregisterDevice, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda278
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$unregistedPush$183(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    public void performLogout(int i) {
        FileLog.e("LogOut\t" + i);
        Log.e("LogOut", "LogOut\t" + i);
        FirebaseEventSender.setKey("performLogout", "cleanup" + i);
        boolean z = true;
        if (i == 1) {
            unregistedPush();
            TLObject tLObject = new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_auth_logOut
                public static int constructor = 1461180992;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i2, boolean z2) {
                    return TLRPC$Bool.TLdeserialize(abstractSerializedData, i2, z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            };
            final AlertDialog alertDialog = new AlertDialog(ApplicationLoader.applicationActivity, 3);
            alertDialog.setCanCancel(false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda179
                @Override // java.lang.Runnable
                public final void run() {
                    MessagesController.lambda$performLogout$184(alertDialog);
                }
            });
            getDialogsProxy().performLogOut(tLObject, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda252
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$performLogout$186(alertDialog, tLObject2, tLRPC$TL_error);
                }
            });
            return;
        }
        getConnectionsManager().cleanup(i == 2);
        getUserConfig().clearConfig();
        ArrayList<NotificationCenter.NotificationCenterDelegate> observers = getNotificationCenter().getObservers(NotificationCenter.appDidLogout);
        if (observers != null) {
            int size = observers.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (observers.get(i2) instanceof LaunchActivity) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        if (z && UserConfig.selectedAccount == this.currentAccount) {
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    i3 = -1;
                    break;
                } else if (UserConfig.getInstance(i3).isClientActivated()) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 != -1) {
                UserConfig.selectedAccount = i3;
                UserConfig.getInstance(0).saveConfig(false);
                LaunchActivity.clearFragments();
            }
        }
        getNotificationCenter().postNotificationName(NotificationCenter.appDidLogout, new Object[0]);
        getMessagesStorage().cleanup(false);
        FirebaseEventSender.setKey("performLogout", "cleanup" + i);
        cleanup();
        getContactsController().deleteUnknownAppAccounts();
        ApiRequestMessanger.getInstance(this.currentAccount).localLogout();
        ServiceLocator.getInstance(this.currentAccount).cleanUp();
        ServiceLocator.clearInstance(this.currentAccount);
        ApiRequestMessangerRx.getInstance(this.currentAccount).auth = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$performLogout$184(AlertDialog alertDialog) {
        try {
            alertDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performLogout$186(final AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda166
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performLogout$185(alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performLogout$185(AlertDialog alertDialog) {
        try {
            alertDialog.dismiss();
        } catch (Exception unused) {
        }
        getConnectionsManager().cleanup(false);
        performLogout(0);
    }

    public void generateUpdateMessage() {
        String str;
        if (this.gettingAppChangelog || BuildVars.DEBUG_VERSION || (str = SharedConfig.lastUpdateVersion) == null || str.equals(BuildVars.BUILD_VERSION_STRING)) {
            return;
        }
        this.gettingAppChangelog = true;
        TLRPC$TL_help_getAppChangelog tLRPC$TL_help_getAppChangelog = new TLRPC$TL_help_getAppChangelog();
        tLRPC$TL_help_getAppChangelog.prev_app_version = SharedConfig.lastUpdateVersion;
        getConnectionsManager().sendRequest(tLRPC$TL_help_getAppChangelog, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda206
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$generateUpdateMessage$187(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateUpdateMessage$187(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            SharedConfig.lastUpdateVersion = BuildVars.BUILD_VERSION_STRING;
            SharedConfig.saveConfig();
        }
        if (tLObject instanceof TLRPC$Updates) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public void registerForPush(final String str) {
        if (TextUtils.isEmpty(str) || this.registeringForPush || getUserConfig().getClientUserId() == 0) {
            return;
        }
        if (getUserConfig().registeredForPush && str.equals(SharedConfig.pushString)) {
            return;
        }
        this.registeringForPush = true;
        this.lastPushRegisterSendTime = SystemClock.elapsedRealtime();
        if (SharedConfig.pushAuthKey == null) {
            SharedConfig.pushAuthKey = new byte[256];
            Utilities.random.nextBytes(SharedConfig.pushAuthKey);
            SharedConfig.saveConfig();
        }
        TLRPC$TL_account_registerDevice tLRPC$TL_account_registerDevice = new TLRPC$TL_account_registerDevice();
        tLRPC$TL_account_registerDevice.token_type = 2;
        tLRPC$TL_account_registerDevice.token = str;
        tLRPC$TL_account_registerDevice.no_muted = false;
        tLRPC$TL_account_registerDevice.secret = SharedConfig.pushAuthKey;
        for (int i = 0; i < 3; i++) {
            UserConfig userConfig = UserConfig.getInstance(i);
            if (i != this.currentAccount && userConfig.isClientActivated()) {
                int clientUserId = userConfig.getClientUserId();
                tLRPC$TL_account_registerDevice.other_uids.add(Integer.valueOf(clientUserId));
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("add other uid = " + clientUserId + " for account " + this.currentAccount);
                }
            }
        }
        getConnectionsManager().sendRequest(tLRPC$TL_account_registerDevice, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda244
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$registerForPush$189(str, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerForPush$189(String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("account " + this.currentAccount + " registered for push");
            }
            getUserConfig().registeredForPush = true;
            SharedConfig.pushString = str;
            getUserConfig().saveConfig(false);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$registerForPush$188();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerForPush$188() {
        this.registeringForPush = false;
    }

    public void loadCurrentState() {
        if (this.updatingState) {
            return;
        }
        this.updatingState = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_updates_getState
            public static int constructor = -304838614;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                return TLRPC$TL_updates_state.TLdeserialize(abstractSerializedData, i, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda198
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadCurrentState$190(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCurrentState$190(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        this.updatingState = false;
        if (tLRPC$TL_error == null) {
            TLRPC$TL_updates_state tLRPC$TL_updates_state = (TLRPC$TL_updates_state) tLObject;
            getMessagesStorage().setLastDateValue(tLRPC$TL_updates_state.date);
            getMessagesStorage().setLastPtsValue(tLRPC$TL_updates_state.pts);
            getMessagesStorage().setLastSeqValue(tLRPC$TL_updates_state.seq);
            getMessagesStorage().setLastQtsValue(tLRPC$TL_updates_state.qts);
            for (int i = 0; i < 3; i++) {
                processUpdatesQueue(i, 2);
            }
            getMessagesStorage().saveDiffParams(getMessagesStorage().getLastSeqValue(), getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue());
            return;
        }
        if (tLRPC$TL_error.code != 401) {
            loadCurrentState();
        }
    }

    private int getUpdateSeq(TLRPC$Updates tLRPC$Updates) {
        if (tLRPC$Updates instanceof TLRPC$TL_updatesCombined) {
            return tLRPC$Updates.seq_start;
        }
        return tLRPC$Updates.seq;
    }

    private void setUpdatesStartTime(int i, long j) {
        if (i == 0) {
            this.updatesStartWaitTimeSeq = j;
        } else if (i == 1) {
            this.updatesStartWaitTimePts = j;
        } else if (i == 2) {
            this.updatesStartWaitTimeQts = j;
        }
    }

    public long getUpdatesStartTime(int i) {
        if (i == 0) {
            return this.updatesStartWaitTimeSeq;
        }
        if (i == 1) {
            return this.updatesStartWaitTimePts;
        }
        if (i == 2) {
            return this.updatesStartWaitTimeQts;
        }
        return 0L;
    }

    private int isValidUpdate(TLRPC$Updates tLRPC$Updates, int i) {
        if (i == 0) {
            int updateSeq = getUpdateSeq(tLRPC$Updates);
            if (getMessagesStorage().getLastSeqValue() + 1 == updateSeq || getMessagesStorage().getLastSeqValue() == updateSeq) {
                return 0;
            }
            return getMessagesStorage().getLastSeqValue() < updateSeq ? 1 : 2;
        }
        if (i == 1) {
            if (tLRPC$Updates.pts <= getMessagesStorage().getLastPtsValue()) {
                return 2;
            }
            return getMessagesStorage().getLastPtsValue() + tLRPC$Updates.pts_count == tLRPC$Updates.pts ? 0 : 1;
        }
        if (i != 2) {
            return 0;
        }
        if (tLRPC$Updates.pts <= getMessagesStorage().getLastQtsValue()) {
            return 2;
        }
        return getMessagesStorage().getLastQtsValue() + tLRPC$Updates.updates.size() == tLRPC$Updates.pts ? 0 : 1;
    }

    private void processChannelsUpdatesQueue(int i, int i2) {
        char c;
        ArrayList<TLRPC$Updates> arrayList = this.updatesQueueChannels.get(i);
        if (arrayList == null) {
            return;
        }
        int i3 = this.channelsPts.get(i);
        if (arrayList.isEmpty() || i3 == 0) {
            this.updatesQueueChannels.remove(i);
            return;
        }
        Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda187
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MessagesController.lambda$processChannelsUpdatesQueue$191((TLRPC$Updates) obj, (TLRPC$Updates) obj2);
            }
        });
        if (i2 == 2) {
            this.channelsPts.put(i, arrayList.get(0).pts);
        }
        boolean z = false;
        while (arrayList.size() > 0) {
            TLRPC$Updates tLRPC$Updates = arrayList.get(0);
            int i4 = tLRPC$Updates.pts;
            if (i4 <= i3) {
                c = 2;
            } else {
                c = tLRPC$Updates.pts_count + i3 == i4 ? (char) 0 : (char) 1;
            }
            if (c == 0) {
                processUpdates(tLRPC$Updates, true);
                arrayList.remove(0);
                z = true;
            } else {
                if (c == 1) {
                    long j = this.updatesStartWaitTimeChannels.get(i);
                    if (j != 0 && (z || Math.abs(System.currentTimeMillis() - j) <= 1500)) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("HOLE IN CHANNEL " + i + " UPDATES QUEUE - will wait more time");
                        }
                        if (z) {
                            this.updatesStartWaitTimeChannels.put(i, System.currentTimeMillis());
                            return;
                        }
                        return;
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("HOLE IN CHANNEL " + i + " UPDATES QUEUE - getChannelDifference ");
                    }
                    this.updatesStartWaitTimeChannels.delete(i);
                    this.updatesQueueChannels.remove(i);
                    getChannelDifference(i);
                    return;
                }
                arrayList.remove(0);
            }
        }
        this.updatesQueueChannels.remove(i);
        this.updatesStartWaitTimeChannels.delete(i);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("UPDATES CHANNEL " + i + " QUEUE PROCEED - OK");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$processChannelsUpdatesQueue$191(TLRPC$Updates tLRPC$Updates, TLRPC$Updates tLRPC$Updates2) {
        return AndroidUtilities.compare(tLRPC$Updates.pts, tLRPC$Updates2.pts);
    }

    private void processUpdatesQueue(int i, int i2) {
        ArrayList<TLRPC$Updates> arrayList;
        if (i == 0) {
            arrayList = this.updatesQueueSeq;
            Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda184
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return this.f$0.lambda$processUpdatesQueue$192((TLRPC$Updates) obj, (TLRPC$Updates) obj2);
                }
            });
        } else if (i == 1) {
            arrayList = this.updatesQueuePts;
            Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda188
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return MessagesController.lambda$processUpdatesQueue$193((TLRPC$Updates) obj, (TLRPC$Updates) obj2);
                }
            });
        } else if (i == 2) {
            arrayList = this.updatesQueueQts;
            Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda186
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return MessagesController.lambda$processUpdatesQueue$194((TLRPC$Updates) obj, (TLRPC$Updates) obj2);
                }
            });
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (i2 == 2) {
                TLRPC$Updates tLRPC$Updates = arrayList.get(0);
                if (i == 0) {
                    getMessagesStorage().setLastSeqValue(getUpdateSeq(tLRPC$Updates));
                } else if (i == 1) {
                    getMessagesStorage().setLastPtsValue(tLRPC$Updates.pts);
                } else {
                    getMessagesStorage().setLastQtsValue(tLRPC$Updates.pts);
                }
            }
            boolean z = false;
            while (arrayList.size() > 0) {
                TLRPC$Updates tLRPC$Updates2 = arrayList.get(0);
                int iIsValidUpdate = isValidUpdate(tLRPC$Updates2, i);
                if (iIsValidUpdate == 0) {
                    processUpdates(tLRPC$Updates2, true);
                    arrayList.remove(0);
                    z = true;
                } else {
                    if (iIsValidUpdate == 1) {
                        if (getUpdatesStartTime(i) != 0 && (z || Math.abs(System.currentTimeMillis() - getUpdatesStartTime(i)) <= 1500)) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("HOLE IN UPDATES QUEUE - will wait more time");
                            }
                            if (z) {
                                setUpdatesStartTime(i, System.currentTimeMillis());
                                return;
                            }
                            return;
                        }
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("HOLE IN UPDATES QUEUE - getDifference");
                        }
                        setUpdatesStartTime(i, 0L);
                        arrayList.clear();
                        getDifference();
                        return;
                    }
                    arrayList.remove(0);
                }
            }
            arrayList.clear();
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("UPDATES QUEUE PROCEED - OK");
            }
        }
        setUpdatesStartTime(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$processUpdatesQueue$192(TLRPC$Updates tLRPC$Updates, TLRPC$Updates tLRPC$Updates2) {
        return AndroidUtilities.compare(getUpdateSeq(tLRPC$Updates), getUpdateSeq(tLRPC$Updates2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$processUpdatesQueue$193(TLRPC$Updates tLRPC$Updates, TLRPC$Updates tLRPC$Updates2) {
        return AndroidUtilities.compare(tLRPC$Updates.pts, tLRPC$Updates2.pts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$processUpdatesQueue$194(TLRPC$Updates tLRPC$Updates, TLRPC$Updates tLRPC$Updates2) {
        return AndroidUtilities.compare(tLRPC$Updates.pts, tLRPC$Updates2.pts);
    }

    public void startShortPoll(final TLRPC$Chat tLRPC$Chat, final int i, final boolean z) {
        if (tLRPC$Chat == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda127
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startShortPoll$195(tLRPC$Chat, z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startShortPoll$195(TLRPC$Chat tLRPC$Chat, boolean z, int i) {
        ArrayList<Integer> arrayList = this.needShortPollChannels.get(tLRPC$Chat.id);
        ArrayList<Integer> arrayList2 = this.needShortPollOnlines.get(tLRPC$Chat.id);
        if (z) {
            if (arrayList != null) {
                arrayList.remove(Integer.valueOf(i));
            }
            if (arrayList == null || arrayList.isEmpty()) {
                this.needShortPollChannels.delete(tLRPC$Chat.id);
            }
            if (tLRPC$Chat.megagroup) {
                if (arrayList2 != null) {
                    arrayList2.remove(Integer.valueOf(i));
                }
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    this.needShortPollOnlines.delete(tLRPC$Chat.id);
                    return;
                }
                return;
            }
            return;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.needShortPollChannels.put(tLRPC$Chat.id, arrayList);
        }
        if (!arrayList.contains(Integer.valueOf(i))) {
            arrayList.add(Integer.valueOf(i));
        }
        if (this.shortPollChannels.indexOfKey(tLRPC$Chat.id) < 0) {
            getChannelDifference(tLRPC$Chat.id, 3, 0L, null);
        }
        if (tLRPC$Chat.megagroup) {
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                this.needShortPollOnlines.put(tLRPC$Chat.id, arrayList2);
            }
            if (!arrayList2.contains(Integer.valueOf(i))) {
                arrayList2.add(Integer.valueOf(i));
            }
            if (this.shortPollOnlines.indexOfKey(tLRPC$Chat.id) < 0) {
                this.shortPollOnlines.put(tLRPC$Chat.id, 0);
            }
        }
    }

    private void getChannelDifference(int i) {
        getChannelDifference(i, 0, 0L, null);
    }

    public static boolean isSupportUser(TLRPC$User tLRPC$User) {
        int i;
        return tLRPC$User != null && (tLRPC$User.support || (i = tLRPC$User.id) == 777000 || i == 333000 || i == 4240000 || i == 4244000 || i == 4245000 || i == 4246000 || i == 410000 || i == 420000 || i == 431000 || i == 431415000 || i == 434000 || i == 4243000 || i == 439000 || i == 449000 || i == 450000 || i == 452000 || i == 454000 || i == 4254000 || i == 455000 || i == 460000 || i == 470000 || i == 479000 || i == 796000 || i == 482000 || i == 490000 || i == 496000 || i == 497000 || i == 498000 || i == 4298000);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void getChannelDifference(final int r16, final int r17, long r18, org.rbmain.tgnet.TLRPC$InputChannel r20) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.getChannelDifference(int, int, long, org.rbmain.tgnet.TLRPC$InputChannel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelDifference$204(final int i, final int i2, final long j, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$Chat tLRPC$Chat;
        if (tLObject == null) {
            if (tLRPC$TL_error != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda133
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getChannelDifference$203(tLRPC$TL_error, i);
                    }
                });
                this.gettingDifferenceChannels.delete(i);
                if (j != 0) {
                    getMessagesStorage().removePendingTask(j);
                    return;
                }
                return;
            }
            return;
        }
        final TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference = (TLRPC$updates_ChannelDifference) tLObject;
        final SparseArray sparseArray = new SparseArray();
        int i3 = 0;
        for (int i4 = 0; i4 < tLRPC$updates_ChannelDifference.users.size(); i4++) {
            TLRPC$User tLRPC$User = tLRPC$updates_ChannelDifference.users.get(i4);
            sparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        int i5 = 0;
        while (true) {
            if (i5 >= tLRPC$updates_ChannelDifference.chats.size()) {
                tLRPC$Chat = null;
                break;
            }
            tLRPC$Chat = tLRPC$updates_ChannelDifference.chats.get(i5);
            if (tLRPC$Chat.id == i) {
                break;
            } else {
                i5++;
            }
        }
        final ArrayList arrayList = new ArrayList();
        if (!tLRPC$updates_ChannelDifference.other_updates.isEmpty()) {
            while (i3 < tLRPC$updates_ChannelDifference.other_updates.size()) {
                TLRPC$Update tLRPC$Update = tLRPC$updates_ChannelDifference.other_updates.get(i3);
                if (tLRPC$Update instanceof TLRPC$TL_updateMessageID) {
                    arrayList.add((TLRPC$TL_updateMessageID) tLRPC$Update);
                    tLRPC$updates_ChannelDifference.other_updates.remove(i3);
                    i3--;
                }
                i3++;
            }
        }
        getMessagesStorage().putUsersAndChats(tLRPC$updates_ChannelDifference.users, tLRPC$updates_ChannelDifference.chats, true, true);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda160
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChannelDifference$196(tLRPC$updates_ChannelDifference);
            }
        });
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda102
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChannelDifference$202(arrayList, i, tLRPC$updates_ChannelDifference, tLRPC$Chat, sparseArray, i2, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelDifference$196(TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference) {
        putUsers(tLRPC$updates_ChannelDifference.users, false);
        putChats(tLRPC$updates_ChannelDifference.chats, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getChannelDifference$202(java.util.ArrayList r14, final int r15, final org.rbmain.tgnet.TLRPC$updates_ChannelDifference r16, final org.rbmain.tgnet.TLRPC$Chat r17, final android.util.SparseArray r18, final int r19, final long r20) {
        /*
            r13 = this;
            boolean r0 = r14.isEmpty()
            if (r0 != 0) goto L44
            androidx.collection.LongSparseArray r0 = new androidx.collection.LongSparseArray
            r0.<init>()
            java.util.Iterator r1 = r14.iterator()
        Lf:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L34
            java.lang.Object r2 = r1.next()
            org.rbmain.tgnet.TLRPC$TL_updateMessageID r2 = (org.rbmain.tgnet.TLRPC$TL_updateMessageID) r2
            org.rbmain.messenger.MessagesStorage r3 = r13.getMessagesStorage()
            long r4 = r2.random_id
            r6 = 0
            long r7 = r2.id
            r9 = 0
            r10 = 0
            r12 = -1
            r11 = r15
            long[] r3 = r3.updateMessageStateAndId(r4, r6, r7, r9, r10, r11, r12)
            if (r3 == 0) goto Lf
            long r4 = r2.id
            r0.put(r4, r3)
            goto Lf
        L34:
            int r1 = r0.size()
            if (r1 == 0) goto L44
            org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda73 r1 = new org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda73
            r11 = r13
            r1.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r1)
            goto L45
        L44:
            r11 = r13
        L45:
            org.rbmain.messenger.DispatchQueue r0 = org.rbmain.messenger.Utilities.stageQueue
            org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda161 r1 = new org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda161
            r2 = r1
            r3 = r13
            r4 = r16
            r5 = r15
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r2.<init>()
            r0.postRunnable(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.lambda$getChannelDifference$202(java.util.ArrayList, int, org.rbmain.tgnet.TLRPC$updates_ChannelDifference, org.rbmain.tgnet.TLRPC$Chat, android.util.SparseArray, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelDifference$197(LongSparseArray longSparseArray) {
        for (int i = 0; i < longSparseArray.size(); i++) {
            long jKeyAt = longSparseArray.keyAt(i);
            long[] jArr = (long[]) longSparseArray.valueAt(i);
            int i2 = (int) jArr[1];
            getSendMessagesHelper().processSentMessage(i2);
            getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Integer.valueOf(i2), Long.valueOf(jKeyAt), null, Long.valueOf(jArr[0]), 0L, -1, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getChannelDifference$201(final org.rbmain.tgnet.TLRPC$updates_ChannelDifference r23, int r24, org.rbmain.tgnet.TLRPC$Chat r25, android.util.SparseArray r26, int r27, long r28) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.lambda$getChannelDifference$201(org.rbmain.tgnet.TLRPC$updates_ChannelDifference, int, org.rbmain.tgnet.TLRPC$Chat, android.util.SparseArray, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelDifference$198(LongSparseArray longSparseArray) {
        for (int i = 0; i < longSparseArray.size(); i++) {
            updateInterfaceWithMessages(longSparseArray.keyAt(i), (ArrayList) longSparseArray.valueAt(i), false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelDifference$200(final ArrayList arrayList, TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference) {
        if (!arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda88
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getChannelDifference$199(arrayList);
                }
            });
        }
        getMessagesStorage().putMessages(tLRPC$updates_ChannelDifference.new_messages, true, false, false, getDownloadController().getAutodownloadMask(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelDifference$199(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelDifference$203(TLRPC$TL_error tLRPC$TL_error, int i) {
        checkChannelError(tLRPC$TL_error.text, i);
    }

    private void checkChannelError(String str, int i) {
        str.hashCode();
        switch (str) {
            case "USER_BANNED_IN_CHANNEL":
                getNotificationCenter().postNotificationName(NotificationCenter.chatInfoCantLoad, Integer.valueOf(i), 2);
                break;
            case "CHANNEL_PRIVATE":
                getNotificationCenter().postNotificationName(NotificationCenter.chatInfoCantLoad, Integer.valueOf(i), 0);
                break;
            case "CHANNEL_PUBLIC_GROUP_NA":
                getNotificationCenter().postNotificationName(NotificationCenter.chatInfoCantLoad, Integer.valueOf(i), 1);
                break;
        }
    }

    public void getDifference() {
        getDifference(getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue(), false);
    }

    public void getDifference(int i, final int i2, final int i3, boolean z) {
        registerForPush(SharedConfig.pushString);
        if (getMessagesStorage().getLastPtsValue() == 0) {
            loadCurrentState();
            return;
        }
        if (z || !this.gettingDifference) {
            this.gettingDifference = true;
            TLRPC$TL_updates_getDifference tLRPC$TL_updates_getDifference = new TLRPC$TL_updates_getDifference();
            tLRPC$TL_updates_getDifference.pts = i;
            tLRPC$TL_updates_getDifference.date = i2;
            tLRPC$TL_updates_getDifference.qts = i3;
            if (this.getDifferenceFirstSync) {
                tLRPC$TL_updates_getDifference.flags |= 1;
                if (ApplicationLoader.isConnectedOrConnectingToWiFi()) {
                    tLRPC$TL_updates_getDifference.pts_total_limit = 5000;
                } else {
                    tLRPC$TL_updates_getDifference.pts_total_limit = CloseCodes.NORMAL_CLOSURE;
                }
                this.getDifferenceFirstSync = false;
            }
            if (tLRPC$TL_updates_getDifference.date == 0) {
                tLRPC$TL_updates_getDifference.date = getConnectionsManager().getCurrentTime();
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("start getDifference with date = " + i2 + " pts = " + i + " qts = " + i3);
            }
            getConnectionsManager().setIsUpdating(true);
            getConnectionsManager().sendRequest(tLRPC$TL_updates_getDifference, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda214
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$getDifference$213(i2, i3, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$213(final int i, final int i2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        int i3 = 0;
        if (tLRPC$TL_error == null) {
            final TLRPC$updates_Difference tLRPC$updates_Difference = (TLRPC$updates_Difference) tLObject;
            if (tLRPC$updates_Difference instanceof TLRPC$TL_updates_differenceTooLong) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda163
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getDifference$205(tLRPC$updates_Difference, i, i2);
                    }
                });
                return;
            }
            if (tLRPC$updates_Difference instanceof TLRPC$TL_updates_differenceSlice) {
                TLRPC$TL_updates_state tLRPC$TL_updates_state = tLRPC$updates_Difference.intermediate_state;
                getDifference(tLRPC$TL_updates_state.pts, tLRPC$TL_updates_state.date, tLRPC$TL_updates_state.qts, true);
            }
            final SparseArray sparseArray = new SparseArray();
            final SparseArray sparseArray2 = new SparseArray();
            for (int i4 = 0; i4 < tLRPC$updates_Difference.users.size(); i4++) {
                TLRPC$User tLRPC$User = tLRPC$updates_Difference.users.get(i4);
                sparseArray.put(tLRPC$User.id, tLRPC$User);
            }
            for (int i5 = 0; i5 < tLRPC$updates_Difference.chats.size(); i5++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$updates_Difference.chats.get(i5);
                sparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
            }
            final ArrayList arrayList = new ArrayList();
            if (!tLRPC$updates_Difference.other_updates.isEmpty()) {
                while (i3 < tLRPC$updates_Difference.other_updates.size()) {
                    TLRPC$Update tLRPC$Update = tLRPC$updates_Difference.other_updates.get(i3);
                    if (tLRPC$Update instanceof TLRPC$TL_updateMessageID) {
                        arrayList.add((TLRPC$TL_updateMessageID) tLRPC$Update);
                        tLRPC$updates_Difference.other_updates.remove(i3);
                    } else {
                        if (getUpdateType(tLRPC$Update) == 2) {
                            int updateChannelId = getUpdateChannelId(tLRPC$Update);
                            int channelPtsSync = this.channelsPts.get(updateChannelId);
                            if (channelPtsSync == 0 && (channelPtsSync = getMessagesStorage().getChannelPtsSync(updateChannelId)) != 0) {
                                this.channelsPts.put(updateChannelId, channelPtsSync);
                            }
                            if (channelPtsSync != 0 && getUpdatePts(tLRPC$Update) <= channelPtsSync) {
                                tLRPC$updates_Difference.other_updates.remove(i3);
                            }
                        }
                        i3++;
                    }
                    i3--;
                    i3++;
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda162
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDifference$206(tLRPC$updates_Difference);
                }
            });
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda165
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDifference$212(tLRPC$updates_Difference, arrayList, sparseArray, sparseArray2);
                }
            });
            return;
        }
        this.gettingDifference = false;
        getConnectionsManager().setIsUpdating(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$205(TLRPC$updates_Difference tLRPC$updates_Difference, int i, int i2) {
        this.loadedFullUsers.clear();
        this.loadedFullChats.clear();
        resetDialogs(true, getMessagesStorage().getLastSeqValue(), tLRPC$updates_Difference.pts, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$206(TLRPC$updates_Difference tLRPC$updates_Difference) {
        this.loadedFullUsers.clear();
        this.loadedFullChats.clear();
        putUsers(tLRPC$updates_Difference.users, false);
        putChats(tLRPC$updates_Difference.chats, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$212(final TLRPC$updates_Difference tLRPC$updates_Difference, ArrayList arrayList, final SparseArray sparseArray, final SparseArray sparseArray2) {
        getMessagesStorage().putUsersAndChats(tLRPC$updates_Difference.users, tLRPC$updates_Difference.chats, true, false);
        if (!arrayList.isEmpty()) {
            final LongSparseArray longSparseArray = new LongSparseArray();
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$TL_updateMessageID tLRPC$TL_updateMessageID = (TLRPC$TL_updateMessageID) arrayList.get(i);
                long[] jArrUpdateMessageStateAndId = getMessagesStorage().updateMessageStateAndId(tLRPC$TL_updateMessageID.random_id, null, tLRPC$TL_updateMessageID.id, 0, false, 0, -1);
                if (jArrUpdateMessageStateAndId != null) {
                    longSparseArray.put(tLRPC$TL_updateMessageID.id, jArrUpdateMessageStateAndId);
                }
            }
            if (longSparseArray.size() != 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda75
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getDifference$207(longSparseArray);
                    }
                });
            }
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda164
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$getDifference$211(tLRPC$updates_Difference, sparseArray, sparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$207(LongSparseArray longSparseArray) {
        for (int i = 0; i < longSparseArray.size(); i++) {
            long jKeyAt = longSparseArray.keyAt(i);
            long[] jArr = (long[]) longSparseArray.valueAt(i);
            int i2 = (int) jArr[1];
            getSendMessagesHelper().processSentMessage(i2);
            getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Integer.valueOf(i2), Long.valueOf(jKeyAt), null, Long.valueOf(jArr[0]), 0L, -1, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$211(final TLRPC$updates_Difference tLRPC$updates_Difference, SparseArray sparseArray, SparseArray sparseArray2) throws InterruptedException {
        TLRPC$User tLRPC$User;
        int i = 0;
        if (!tLRPC$updates_Difference.new_messages.isEmpty() || !tLRPC$updates_Difference.new_encrypted_messages.isEmpty()) {
            final LongSparseArray longSparseArray = new LongSparseArray();
            for (int i2 = 0; i2 < tLRPC$updates_Difference.new_encrypted_messages.size(); i2++) {
                ArrayList<TLRPC$Message> arrayListDecryptMessage = getSecretChatHelper().decryptMessage(tLRPC$updates_Difference.new_encrypted_messages.get(i2));
                if (arrayListDecryptMessage != null && !arrayListDecryptMessage.isEmpty()) {
                    tLRPC$updates_Difference.new_messages.addAll(arrayListDecryptMessage);
                }
            }
            ImageLoader.saveMessagesThumbs(tLRPC$updates_Difference.new_messages);
            final ArrayList arrayList = new ArrayList();
            int clientUserId = getUserConfig().getClientUserId();
            for (int i3 = 0; i3 < tLRPC$updates_Difference.new_messages.size(); i3++) {
                TLRPC$Message tLRPC$Message = tLRPC$updates_Difference.new_messages.get(i3);
                if (!(tLRPC$Message instanceof TLRPC$TL_messageEmpty)) {
                    MessageObject.getDialogId(tLRPC$Message);
                    if (((int) tLRPC$Message.dialog_id) != 0) {
                        TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
                        if ((tLRPC$MessageAction instanceof TLRPC$TL_messageActionChatDeleteUser) && (tLRPC$User = (TLRPC$User) sparseArray.get(tLRPC$MessageAction.user_id)) != null && tLRPC$User.bot) {
                            tLRPC$Message.reply_markup = new TLRPC$TL_replyKeyboardHide();
                            tLRPC$Message.flags |= 64;
                        }
                        TLRPC$MessageAction tLRPC$MessageAction2 = tLRPC$Message.action;
                        if ((tLRPC$MessageAction2 instanceof TLRPC$TL_messageActionChatMigrateTo) || (tLRPC$MessageAction2 instanceof TLRPC$TL_messageActionChannelCreate)) {
                            tLRPC$Message.unread = false;
                            tLRPC$Message.media_unread = false;
                        } else {
                            ConcurrentHashMap<Long, Long> concurrentHashMap = tLRPC$Message.out ? this.dialogs_read_outbox_max : this.dialogs_read_inbox_max;
                            Long lValueOf = concurrentHashMap.get(Long.valueOf(tLRPC$Message.dialog_id));
                            if (lValueOf == null) {
                                lValueOf = Long.valueOf(getMessagesStorage().getDialogReadMax(tLRPC$Message.out, tLRPC$Message.dialog_id));
                                concurrentHashMap.put(Long.valueOf(tLRPC$Message.dialog_id), lValueOf);
                            }
                            tLRPC$Message.unread = lValueOf.longValue() < tLRPC$Message.id;
                        }
                    }
                    long j = tLRPC$Message.dialog_id;
                    if (j == clientUserId) {
                        tLRPC$Message.unread = false;
                        tLRPC$Message.media_unread = false;
                        tLRPC$Message.out = true;
                    }
                    boolean zContains = this.createdDialogIds.contains(Long.valueOf(j));
                    MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$Message, (SparseArray<TLRPC$User>) sparseArray, (SparseArray<TLRPC$Chat>) sparseArray2, zContains, zContains);
                    if ((!messageObject.isOut() || messageObject.messageOwner.from_scheduled) && messageObject.isUnread()) {
                        arrayList.add(messageObject);
                    }
                    ArrayList arrayList2 = (ArrayList) longSparseArray.get(tLRPC$Message.dialog_id);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        longSparseArray.put(tLRPC$Message.dialog_id, arrayList2);
                    }
                    arrayList2.add(messageObject);
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda74
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDifference$208(longSparseArray);
                }
            });
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda108
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDifference$210(arrayList, tLRPC$updates_Difference);
                }
            });
            getSecretChatHelper().processPendingEncMessages();
        }
        if (!tLRPC$updates_Difference.other_updates.isEmpty()) {
            processUpdateArray(tLRPC$updates_Difference.other_updates, tLRPC$updates_Difference.users, tLRPC$updates_Difference.chats, true, 0);
        }
        if (tLRPC$updates_Difference instanceof TLRPC$TL_updates_difference) {
            this.gettingDifference = false;
            getMessagesStorage().setLastSeqValue(tLRPC$updates_Difference.state.seq);
            getMessagesStorage().setLastDateValue(tLRPC$updates_Difference.state.date);
            getMessagesStorage().setLastPtsValue(tLRPC$updates_Difference.state.pts);
            getMessagesStorage().setLastQtsValue(tLRPC$updates_Difference.state.qts);
            getConnectionsManager().setIsUpdating(false);
            while (i < 3) {
                processUpdatesQueue(i, 1);
                i++;
            }
        } else if (tLRPC$updates_Difference instanceof TLRPC$TL_updates_differenceSlice) {
            getMessagesStorage().setLastDateValue(tLRPC$updates_Difference.intermediate_state.date);
            getMessagesStorage().setLastPtsValue(tLRPC$updates_Difference.intermediate_state.pts);
            getMessagesStorage().setLastQtsValue(tLRPC$updates_Difference.intermediate_state.qts);
        } else if (tLRPC$updates_Difference instanceof TLRPC$TL_updates_differenceEmpty) {
            this.gettingDifference = false;
            getMessagesStorage().setLastSeqValue(tLRPC$updates_Difference.seq);
            getMessagesStorage().setLastDateValue(tLRPC$updates_Difference.date);
            getConnectionsManager().setIsUpdating(false);
            while (i < 3) {
                processUpdatesQueue(i, 1);
                i++;
            }
        }
        getMessagesStorage().saveDiffParams(getMessagesStorage().getLastSeqValue(), getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue());
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("received difference with date = " + getMessagesStorage().getLastDateValue() + " pts = " + getMessagesStorage().getLastPtsValue() + " seq = " + getMessagesStorage().getLastSeqValue() + " messages = " + tLRPC$updates_Difference.new_messages.size() + " users = " + tLRPC$updates_Difference.users.size() + " chats = " + tLRPC$updates_Difference.chats.size() + " other updates = " + tLRPC$updates_Difference.other_updates.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$208(LongSparseArray longSparseArray) {
        for (int i = 0; i < longSparseArray.size(); i++) {
            updateInterfaceWithMessages(longSparseArray.keyAt(i), (ArrayList) longSparseArray.valueAt(i), false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$210(final ArrayList arrayList, final TLRPC$updates_Difference tLRPC$updates_Difference) {
        if (!arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda107
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDifference$209(arrayList, tLRPC$updates_Difference);
                }
            });
        }
        getMessagesStorage().putMessages(tLRPC$updates_Difference.new_messages, true, false, false, getDownloadController().getAutodownloadMask(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDifference$209(ArrayList arrayList, TLRPC$updates_Difference tLRPC$updates_Difference) {
        getNotificationsController().processNewMessages(arrayList, !(tLRPC$updates_Difference instanceof TLRPC$TL_updates_differenceSlice), false, null);
    }

    public void markDialogAsUnread(long j, TLRPC$InputPeer tLRPC$InputPeer, final long j2) {
        NativeByteBuffer nativeByteBuffer;
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        NativeByteBuffer nativeByteBuffer2 = null;
        if (tLRPC$Dialog != null) {
            tLRPC$Dialog.unread_mark = true;
            if (tLRPC$Dialog.unread_count == 0 && !isDialogMuted(j)) {
                this.unreadUnmutedDialogs++;
            }
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 256);
            getMessagesStorage().setDialogUnread(j, true);
            int i = 0;
            while (true) {
                DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
                if (i < dialogFilterArr.length) {
                    if (dialogFilterArr[i] != null && (dialogFilterArr[i].flags & DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0) {
                        sortDialogs(null);
                        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        int i2 = (int) j;
        if (i2 != 0) {
            TLRPC$TL_messages_markDialogUnread tLRPC$TL_messages_markDialogUnread = new TLRPC$TL_messages_markDialogUnread();
            tLRPC$TL_messages_markDialogUnread.unread = true;
            if (tLRPC$InputPeer == null) {
                tLRPC$InputPeer = getInputPeer(i2);
            }
            if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerEmpty) {
                return;
            }
            TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
            tLRPC$TL_inputDialogPeer.peer = tLRPC$InputPeer;
            tLRPC$TL_messages_markDialogUnread.peer = tLRPC$TL_inputDialogPeer;
            if (j2 == 0) {
                try {
                    nativeByteBuffer = new NativeByteBuffer(tLRPC$InputPeer.getObjectSize() + 12);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    nativeByteBuffer.writeInt32(9);
                    nativeByteBuffer.writeInt64(j);
                    tLRPC$InputPeer.serializeToStream(nativeByteBuffer);
                } catch (Exception e2) {
                    e = e2;
                    nativeByteBuffer2 = nativeByteBuffer;
                    FileLog.e(e);
                    nativeByteBuffer = nativeByteBuffer2;
                    j2 = getMessagesStorage().createPendingTask(nativeByteBuffer);
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_markDialogUnread, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda231
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$markDialogAsUnread$214(j2, tLObject, tLRPC$TL_error);
                        }
                    });
                }
                j2 = getMessagesStorage().createPendingTask(nativeByteBuffer);
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_markDialogUnread, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda231
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$markDialogAsUnread$214(j2, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markDialogAsUnread$214(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void loadUnreadDialogs() {
        if (this.loadingUnreadDialogs || getUserConfig().unreadDialogsLoaded) {
            return;
        }
        this.loadingUnreadDialogs = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_getDialogUnreadMarks
            public static int constructor = 585256482;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                int int32 = abstractSerializedData.readInt32(z);
                for (int i2 = 0; i2 < int32; i2++) {
                    TLRPC$DialogPeer tLRPC$DialogPeerTLdeserialize = TLRPC$DialogPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (tLRPC$DialogPeerTLdeserialize == null) {
                        return tLRPC$Vector;
                    }
                    tLRPC$Vector.objects.add(tLRPC$DialogPeerTLdeserialize);
                }
                return tLRPC$Vector;
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda192
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadUnreadDialogs$216(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadUnreadDialogs$216(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda119
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadUnreadDialogs$215(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadUnreadDialogs$215(TLObject tLObject) {
        long j;
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            int size = tLRPC$Vector.objects.size();
            for (int i = 0; i < size; i++) {
                TLRPC$DialogPeer tLRPC$DialogPeer = (TLRPC$DialogPeer) tLRPC$Vector.objects.get(i);
                if (tLRPC$DialogPeer instanceof TLRPC$TL_dialogPeer) {
                    TLRPC$Peer tLRPC$Peer = ((TLRPC$TL_dialogPeer) tLRPC$DialogPeer).peer;
                    int i2 = tLRPC$Peer.user_id;
                    if (i2 != 0) {
                        j = i2;
                    } else {
                        int i3 = tLRPC$Peer.chat_id;
                        j = i3 != 0 ? -i3 : -tLRPC$Peer.channel_id;
                    }
                    getMessagesStorage().setDialogUnread(j, true);
                    TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
                    if (tLRPC$Dialog != null && !tLRPC$Dialog.unread_mark) {
                        tLRPC$Dialog.unread_mark = true;
                        if (tLRPC$Dialog.unread_count == 0 && !isDialogMuted(j)) {
                            this.unreadUnmutedDialogs++;
                        }
                    }
                }
            }
            getUserConfig().unreadDialogsLoaded = true;
            getUserConfig().saveConfig(false);
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 256);
            this.loadingUnreadDialogs = false;
        }
    }

    public void reorderPinnedDialogs(int i, ArrayList<TLRPC$InputDialogPeer> arrayList, final long j) {
        NativeByteBuffer nativeByteBuffer;
        TLRPC$TL_messages_reorderPinnedDialogs tLRPC$TL_messages_reorderPinnedDialogs = new TLRPC$TL_messages_reorderPinnedDialogs();
        tLRPC$TL_messages_reorderPinnedDialogs.folder_id = i;
        tLRPC$TL_messages_reorderPinnedDialogs.force = true;
        if (j == 0) {
            ArrayList<TLRPC$Dialog> dialogs = getDialogs(i);
            if (dialogs.isEmpty()) {
                return;
            }
            ArrayList<Long> arrayList2 = new ArrayList<>();
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            int size = dialogs.size();
            int objectSize = 0;
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$Dialog tLRPC$Dialog = dialogs.get(i2);
                if (!(tLRPC$Dialog instanceof TLRPC$TL_dialogFolder)) {
                    if (!tLRPC$Dialog.pinned) {
                        if (tLRPC$Dialog.id != this.promoDialogId) {
                            break;
                        }
                    } else {
                        arrayList2.add(Long.valueOf(tLRPC$Dialog.id));
                        arrayList3.add(Integer.valueOf(tLRPC$Dialog.pinnedNum));
                        if (((int) tLRPC$Dialog.id) != 0) {
                            TLRPC$InputPeer inputPeer = getInputPeer((int) dialogs.get(i2).id);
                            TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
                            tLRPC$TL_inputDialogPeer.peer = inputPeer;
                            tLRPC$TL_messages_reorderPinnedDialogs.order.add(tLRPC$TL_inputDialogPeer);
                            objectSize += tLRPC$TL_inputDialogPeer.getObjectSize();
                        }
                    }
                }
            }
            getMessagesStorage().setDialogsPinned(arrayList2, arrayList3);
            NativeByteBuffer nativeByteBuffer2 = null;
            try {
                nativeByteBuffer = new NativeByteBuffer(objectSize + 12);
            } catch (Exception e) {
                e = e;
            }
            try {
                nativeByteBuffer.writeInt32(16);
                nativeByteBuffer.writeInt32(i);
                nativeByteBuffer.writeInt32(tLRPC$TL_messages_reorderPinnedDialogs.order.size());
                int size2 = tLRPC$TL_messages_reorderPinnedDialogs.order.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    tLRPC$TL_messages_reorderPinnedDialogs.order.get(i3).serializeToStream(nativeByteBuffer);
                }
            } catch (Exception e2) {
                e = e2;
                nativeByteBuffer2 = nativeByteBuffer;
                FileLog.e(e);
                nativeByteBuffer = nativeByteBuffer2;
                j = getMessagesStorage().createPendingTask(nativeByteBuffer);
                getConnectionsManager().sendRequest(tLRPC$TL_messages_reorderPinnedDialogs, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda236
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$reorderPinnedDialogs$217(j, tLObject, tLRPC$TL_error);
                    }
                });
            }
            j = getMessagesStorage().createPendingTask(nativeByteBuffer);
        } else {
            tLRPC$TL_messages_reorderPinnedDialogs.order = arrayList;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_reorderPinnedDialogs, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda236
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reorderPinnedDialogs$217(j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reorderPinnedDialogs$217(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public boolean pinDialog(long j, final boolean z, TLRPC$InputPeer tLRPC$InputPeer, long j2) {
        final String dialogId = IdStorage.getInstance().getDialogId(j);
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        if (tLRPC$Dialog == null || tLRPC$Dialog.pinned == z) {
            return tLRPC$Dialog != null;
        }
        int i = tLRPC$Dialog.folder_id;
        ArrayList<TLRPC$Dialog> dialogs = getDialogs(i);
        tLRPC$Dialog.pinned = z;
        if (z) {
            int iMax = 0;
            for (int i2 = 0; i2 < dialogs.size(); i2++) {
                TLRPC$Dialog tLRPC$Dialog2 = dialogs.get(i2);
                if (!(tLRPC$Dialog2 instanceof TLRPC$TL_dialogFolder)) {
                    if (!tLRPC$Dialog2.pinned) {
                        if (tLRPC$Dialog2.id != this.promoDialogId) {
                            break;
                        }
                    } else {
                        iMax = Math.max(tLRPC$Dialog2.pinnedNum, iMax);
                    }
                }
            }
            tLRPC$Dialog.pinnedNum = iMax + 1;
        } else {
            tLRPC$Dialog.pinnedNum = 0;
        }
        sortDialogs(null);
        if (!z && !dialogs.isEmpty() && dialogs.get(dialogs.size() - 1) == tLRPC$Dialog && !this.dialogsEndReached.get(i)) {
            dialogs.remove(dialogs.size() - 1);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda83
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$pinDialog$218(dialogId, z);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pinDialog$218(String str, boolean z) {
        getAccountInstance().getCoreMainClass().togglePinChat(str, z);
    }

    public void loadPinnedDialogs(final int i, long j, ArrayList<Long> arrayList) {
        if (this.loadingPinnedDialogs.indexOfKey(i) >= 0 || getUserConfig().isPinnedDialogsLoaded(i)) {
            return;
        }
        this.loadingPinnedDialogs.put(i, 1);
        TLRPC$TL_messages_getPinnedDialogs tLRPC$TL_messages_getPinnedDialogs = new TLRPC$TL_messages_getPinnedDialogs();
        tLRPC$TL_messages_getPinnedDialogs.folder_id = i;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPinnedDialogs, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda213
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPinnedDialogs$221(i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadPinnedDialogs$221(final int r18, org.rbmain.tgnet.TLObject r19, org.rbmain.tgnet.TLRPC$TL_error r20) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.lambda$loadPinnedDialogs$221(int, org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPinnedDialogs$220(final int i, final ArrayList arrayList, final boolean z, final TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs, final LongSparseArray longSparseArray, final TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda57
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPinnedDialogs$219(i, arrayList, z, tLRPC$TL_messages_peerDialogs, longSparseArray, tLRPC$TL_messages_dialogs);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPinnedDialogs$219(int i, ArrayList arrayList, boolean z, TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs, LongSparseArray longSparseArray, TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs) {
        boolean z2;
        boolean z3;
        ArrayList<Integer> arrayList2;
        int i2;
        this.loadingPinnedDialogs.delete(i);
        applyDialogsNotificationsSettings(arrayList);
        ArrayList<TLRPC$Dialog> dialogs = getDialogs(i);
        int i3 = z ? 1 : 0;
        int iMax = 0;
        boolean z4 = false;
        for (int i4 = 0; i4 < dialogs.size(); i4++) {
            TLRPC$Dialog tLRPC$Dialog = dialogs.get(i4);
            if (!(tLRPC$Dialog instanceof TLRPC$TL_dialogFolder)) {
                long j = tLRPC$Dialog.id;
                if (((int) j) == 0) {
                    if (i3 < arrayList.size()) {
                        arrayList.add(i3, tLRPC$Dialog);
                    } else {
                        arrayList.add(tLRPC$Dialog);
                    }
                    i3++;
                } else if (!tLRPC$Dialog.pinned) {
                    if (j != this.promoDialogId) {
                        break;
                    }
                } else {
                    iMax = Math.max(tLRPC$Dialog.pinnedNum, iMax);
                    tLRPC$Dialog.pinned = false;
                    tLRPC$Dialog.pinnedNum = 0;
                    i3++;
                    z4 = true;
                }
            }
        }
        ArrayList<Long> arrayList3 = new ArrayList<>();
        if (arrayList.isEmpty()) {
            z2 = false;
        } else {
            putUsers(tLRPC$TL_messages_peerDialogs.users, false);
            putChats(tLRPC$TL_messages_peerDialogs.chats, false);
            ArrayList<Long> arrayList4 = new ArrayList<>();
            ArrayList<Integer> arrayList5 = new ArrayList<>();
            int size = arrayList.size();
            int i5 = 0;
            z2 = false;
            while (i5 < size) {
                TLRPC$Dialog tLRPC$Dialog2 = (TLRPC$Dialog) arrayList.get(i5);
                tLRPC$Dialog2.pinnedNum = (size - i5) + iMax;
                arrayList3.add(Long.valueOf(tLRPC$Dialog2.id));
                TLRPC$Dialog tLRPC$Dialog3 = this.dialogs_dict.get(tLRPC$Dialog2.id);
                if (tLRPC$Dialog3 != null) {
                    tLRPC$Dialog3.pinned = true;
                    tLRPC$Dialog3.pinnedNum = tLRPC$Dialog2.pinnedNum;
                    arrayList4.add(Long.valueOf(tLRPC$Dialog2.id));
                    arrayList5.add(Integer.valueOf(tLRPC$Dialog2.pinnedNum));
                    arrayList2 = arrayList5;
                    i2 = size;
                } else {
                    FirebaseEventSender.setKey("dialogs_dictput4", this.dialogs_dict != null ? this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "null");
                    this.dialogs_dict.put(tLRPC$Dialog2.id, tLRPC$Dialog2);
                    MessageObject messageObject = (MessageObject) longSparseArray.get(tLRPC$Dialog2.id);
                    arrayList2 = arrayList5;
                    this.dialogMessage.put(tLRPC$Dialog2.id, messageObject);
                    if (messageObject == null || messageObject.messageOwner.peer_id.channel_id != 0) {
                        i2 = size;
                    } else {
                        i2 = size;
                        this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                        this.dialogsLoadedTillDate = Math.min(this.dialogsLoadedTillDate, messageObject.messageOwner.date);
                        long j2 = messageObject.messageOwner.random_id;
                        if (j2 != 0) {
                            this.dialogMessagesByRandomIds.put(j2, messageObject);
                        }
                    }
                    z2 = true;
                }
                i5++;
                arrayList5 = arrayList2;
                size = i2;
                z4 = true;
            }
            getMessagesStorage().setDialogsPinned(arrayList4, arrayList5);
        }
        if (z4) {
            if (z2) {
                this.allDialogs.clear();
                int size2 = this.dialogs_dict.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    TLRPC$Dialog tLRPC$DialogValueAt = this.dialogs_dict.valueAt(i6);
                    if (tLRPC$DialogValueAt != null && this.deletingDialogs.indexOfKey(tLRPC$DialogValueAt.id) < 0) {
                        this.allDialogs.add(tLRPC$DialogValueAt);
                    }
                }
            }
            sortDialogs(null);
            z3 = false;
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        } else {
            z3 = false;
        }
        getMessagesStorage().unpinAllDialogsExceptNew(arrayList3, i);
        getMessagesStorage().putDialogs(tLRPC$TL_messages_dialogs, 1);
        getUserConfig().setPinnedDialogsLoaded(i, true);
        getUserConfig().saveConfig(z3);
    }

    public void generateJoinMessage(final int i, boolean z) {
        TLRPC$Chat chat = getChat(Integer.valueOf(i));
        if (chat == null || !ChatObject.isChannel(i, this.currentAccount)) {
            return;
        }
        if ((chat.left || chat.kicked) && !z) {
            return;
        }
        TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
        tLRPC$TL_messageService.flags = 256;
        long newMessageId = getUserConfig().getNewMessageId();
        tLRPC$TL_messageService.id = newMessageId;
        tLRPC$TL_messageService.local_id = newMessageId;
        tLRPC$TL_messageService.date = getConnectionsManager().getCurrentTime();
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = getUserConfig().getClientUserId();
        TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
        tLRPC$TL_messageService.peer_id = tLRPC$TL_peerChannel;
        tLRPC$TL_peerChannel.channel_id = i;
        tLRPC$TL_messageService.dialog_id = -i;
        tLRPC$TL_messageService.post = true;
        TLRPC$TL_messageActionChatAddUser tLRPC$TL_messageActionChatAddUser = new TLRPC$TL_messageActionChatAddUser();
        tLRPC$TL_messageService.action = tLRPC$TL_messageActionChatAddUser;
        tLRPC$TL_messageActionChatAddUser.users.add(Integer.valueOf(getUserConfig().getClientUserId()));
        getUserConfig().saveConfig(false);
        final ArrayList arrayList = new ArrayList();
        ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
        arrayList2.add(tLRPC$TL_messageService);
        arrayList.add(new MessageObject(this.currentAccount, tLRPC$TL_messageService, true, false));
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda90
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateJoinMessage$223(arrayList);
            }
        });
        getMessagesStorage().putMessages(arrayList2, true, true, false, 0, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateJoinMessage$224(i, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateJoinMessage$222(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateJoinMessage$223(final ArrayList arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda97
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateJoinMessage$222(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateJoinMessage$224(int i, ArrayList arrayList) {
        updateInterfaceWithMessages(-i, arrayList, false);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    protected void deleteMessagesByPush(final long j, final ArrayList<Long> arrayList, final int i) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda101
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteMessagesByPush$226(arrayList, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteMessagesByPush$226(final ArrayList arrayList, final int i, long j) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda99
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteMessagesByPush$225(arrayList, i);
            }
        });
        getMessagesStorage().deletePushMessages(j, arrayList);
        getMessagesStorage().updateDialogsWithDeletedMessages(arrayList, getMessagesStorage().markMessagesAsDeleted(arrayList, false, i, true, false), false, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteMessagesByPush$225(ArrayList arrayList, int i) {
        int i2 = 0;
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDeleted, arrayList, Integer.valueOf(i), Boolean.FALSE);
        if (i == 0) {
            int size = arrayList.size();
            while (i2 < size) {
                MessageObject messageObject = this.dialogMessagesByIds.get(((Long) arrayList.get(i2)).longValue());
                if (messageObject != null) {
                    messageObject.deleted = true;
                }
                i2++;
            }
            return;
        }
        MessageObject messageObject2 = this.dialogMessage.get(-i);
        if (messageObject2 != null) {
            int size2 = arrayList.size();
            while (i2 < size2) {
                if (messageObject2.getId() == ((Long) arrayList.get(i2)).longValue()) {
                    messageObject2.deleted = true;
                    return;
                }
                i2++;
            }
        }
    }

    public void checkChatInviter(final int i, final boolean z) {
        final TLRPC$Chat chat = getChat(Integer.valueOf(i));
        if (!ChatObject.isChannel(chat) || chat.creator || this.gettingChatInviters.indexOfKey(i) >= 0) {
            return;
        }
        this.gettingChatInviters.put(i, true);
        TLRPC$TL_channels_getParticipant tLRPC$TL_channels_getParticipant = new TLRPC$TL_channels_getParticipant();
        tLRPC$TL_channels_getParticipant.channel = getInputChannel(i);
        tLRPC$TL_channels_getParticipant.participant = getInputPeer(getUserConfig().getClientUserId());
        getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipant, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda248
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkChatInviter$231(chat, z, i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChatInviter$231(TLRPC$Chat tLRPC$Chat, boolean z, final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final ArrayList arrayList;
        final TLRPC$TL_channels_channelParticipant tLRPC$TL_channels_channelParticipant = (TLRPC$TL_channels_channelParticipant) tLObject;
        if (tLRPC$TL_channels_channelParticipant != null) {
            TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_channels_channelParticipant.participant;
            if (!(tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantSelf) || tLRPC$ChannelParticipant.inviter_id == getUserConfig().getClientUserId()) {
                return;
            }
            if (tLRPC$Chat.megagroup && getMessagesStorage().isMigratedChat(tLRPC$Chat.id)) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda131
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkChatInviter$227(tLRPC$TL_channels_channelParticipant);
                }
            });
            getMessagesStorage().putUsersAndChats(tLRPC$TL_channels_channelParticipant.users, tLRPC$TL_channels_channelParticipant.chats, true, true);
            if (!z || getMessagesStorage().hasInviteMeMessage(i)) {
                arrayList = null;
            } else {
                TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
                tLRPC$TL_messageService.media_unread = true;
                tLRPC$TL_messageService.unread = true;
                tLRPC$TL_messageService.flags = 256;
                tLRPC$TL_messageService.post = true;
                long newMessageId = getUserConfig().getNewMessageId();
                tLRPC$TL_messageService.id = newMessageId;
                tLRPC$TL_messageService.local_id = newMessageId;
                tLRPC$TL_messageService.date = tLRPC$TL_channels_channelParticipant.participant.date;
                tLRPC$TL_messageService.action = new TLRPC$TL_messageActionChatAddUser();
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = tLRPC$TL_channels_channelParticipant.participant.inviter_id;
                tLRPC$TL_messageService.action.users.add(Integer.valueOf(getUserConfig().getClientUserId()));
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                tLRPC$TL_messageService.peer_id = tLRPC$TL_peerChannel;
                tLRPC$TL_peerChannel.channel_id = i;
                tLRPC$TL_messageService.dialog_id = -i;
                getUserConfig().saveConfig(false);
                arrayList = new ArrayList();
                ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (int i2 = 0; i2 < tLRPC$TL_channels_channelParticipant.users.size(); i2++) {
                    TLRPC$User tLRPC$User = tLRPC$TL_channels_channelParticipant.users.get(i2);
                    concurrentHashMap.put(Integer.valueOf(tLRPC$User.id), tLRPC$User);
                }
                arrayList2.add(tLRPC$TL_messageService);
                arrayList.add(new MessageObject(this.currentAccount, (TLRPC$Message) tLRPC$TL_messageService, (AbstractMap<Integer, TLRPC$User>) concurrentHashMap, true, false));
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda85
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkChatInviter$229(arrayList);
                    }
                });
                getMessagesStorage().putMessages(arrayList2, true, true, false, 0, false);
            }
            getMessagesStorage().saveChatInviter(i, tLRPC$TL_channels_channelParticipant.participant.inviter_id);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda56
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkChatInviter$230(i, arrayList, tLRPC$TL_channels_channelParticipant);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChatInviter$227(TLRPC$TL_channels_channelParticipant tLRPC$TL_channels_channelParticipant) {
        putUsers(tLRPC$TL_channels_channelParticipant.users, false);
        putChats(tLRPC$TL_channels_channelParticipant.chats, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChatInviter$228(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChatInviter$229(final ArrayList arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda94
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkChatInviter$228(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChatInviter$230(int i, ArrayList arrayList, TLRPC$TL_channels_channelParticipant tLRPC$TL_channels_channelParticipant) {
        this.gettingChatInviters.delete(i);
        if (arrayList != null) {
            updateInterfaceWithMessages(-i, arrayList, false);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.didLoadChatInviter, Integer.valueOf(i), Integer.valueOf(tLRPC$TL_channels_channelParticipant.participant.inviter_id));
    }

    private int getUpdateType(TLRPC$Update tLRPC$Update) {
        if ((tLRPC$Update instanceof TLRPC$TL_updateNewMessage) || (tLRPC$Update instanceof TLRPC$TL_updateReadMessagesContents) || (tLRPC$Update instanceof TLRPC$TL_updateReadHistoryInbox) || (tLRPC$Update instanceof TLRPC$TL_updateReadHistoryOutbox) || (tLRPC$Update instanceof TLRPC$TL_updateDeleteMessages) || (tLRPC$Update instanceof TLRPC$TL_updateWebPage) || (tLRPC$Update instanceof TLRPC$TL_updateEditMessage) || (tLRPC$Update instanceof TLRPC$TL_updateFolderPeers) || (tLRPC$Update instanceof TLRPC$TL_updatePinnedMessages)) {
            return 0;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateNewEncryptedMessage) {
            return 1;
        }
        return ((tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) || (tLRPC$Update instanceof TLRPC$TL_updateDeleteChannelMessages) || (tLRPC$Update instanceof TLRPC$TL_updateEditChannelMessage) || (tLRPC$Update instanceof TLRPC$TL_updateChannelWebPage) || (tLRPC$Update instanceof TLRPC$TL_updatePinnedChannelMessages)) ? 2 : 3;
    }

    private static int getUpdatePts(TLRPC$Update tLRPC$Update) {
        if (tLRPC$Update instanceof TLRPC$TL_updateDeleteMessages) {
            return ((TLRPC$TL_updateDeleteMessages) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) {
            return ((TLRPC$TL_updateNewChannelMessage) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadHistoryOutbox) {
            return ((TLRPC$TL_updateReadHistoryOutbox) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateNewMessage) {
            return ((TLRPC$TL_updateNewMessage) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateEditMessage) {
            return ((TLRPC$TL_updateEditMessage) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateWebPage) {
            return ((TLRPC$TL_updateWebPage) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadHistoryInbox) {
            return ((TLRPC$TL_updateReadHistoryInbox) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelWebPage) {
            return ((TLRPC$TL_updateChannelWebPage) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateDeleteChannelMessages) {
            return ((TLRPC$TL_updateDeleteChannelMessages) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateEditChannelMessage) {
            return ((TLRPC$TL_updateEditChannelMessage) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadMessagesContents) {
            return ((TLRPC$TL_updateReadMessagesContents) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelTooLong) {
            return ((TLRPC$TL_updateChannelTooLong) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateFolderPeers) {
            return ((TLRPC$TL_updateFolderPeers) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updatePinnedChannelMessages) {
            return ((TLRPC$TL_updatePinnedChannelMessages) tLRPC$Update).pts;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updatePinnedMessages) {
            return ((TLRPC$TL_updatePinnedMessages) tLRPC$Update).pts;
        }
        return 0;
    }

    private static int getUpdatePtsCount(TLRPC$Update tLRPC$Update) {
        if (tLRPC$Update instanceof TLRPC$TL_updateDeleteMessages) {
            return ((TLRPC$TL_updateDeleteMessages) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) {
            return ((TLRPC$TL_updateNewChannelMessage) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadHistoryOutbox) {
            return ((TLRPC$TL_updateReadHistoryOutbox) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateNewMessage) {
            return ((TLRPC$TL_updateNewMessage) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateEditMessage) {
            return ((TLRPC$TL_updateEditMessage) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateWebPage) {
            return ((TLRPC$TL_updateWebPage) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadHistoryInbox) {
            return ((TLRPC$TL_updateReadHistoryInbox) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelWebPage) {
            return ((TLRPC$TL_updateChannelWebPage) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateDeleteChannelMessages) {
            return ((TLRPC$TL_updateDeleteChannelMessages) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateEditChannelMessage) {
            return ((TLRPC$TL_updateEditChannelMessage) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadMessagesContents) {
            return ((TLRPC$TL_updateReadMessagesContents) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateFolderPeers) {
            return ((TLRPC$TL_updateFolderPeers) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updatePinnedChannelMessages) {
            return ((TLRPC$TL_updatePinnedChannelMessages) tLRPC$Update).pts_count;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updatePinnedMessages) {
            return ((TLRPC$TL_updatePinnedMessages) tLRPC$Update).pts_count;
        }
        return 0;
    }

    private static int getUpdateQts(TLRPC$Update tLRPC$Update) {
        if (tLRPC$Update instanceof TLRPC$TL_updateNewEncryptedMessage) {
            return ((TLRPC$TL_updateNewEncryptedMessage) tLRPC$Update).qts;
        }
        return 0;
    }

    public static int getUpdateChannelId(TLRPC$Update tLRPC$Update) {
        if (tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) {
            return ((TLRPC$TL_updateNewChannelMessage) tLRPC$Update).message.peer_id.channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateEditChannelMessage) {
            return ((TLRPC$TL_updateEditChannelMessage) tLRPC$Update).message.peer_id.channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadChannelOutbox) {
            return ((TLRPC$TL_updateReadChannelOutbox) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelMessageViews) {
            return ((TLRPC$TL_updateChannelMessageViews) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelMessageForwards) {
            return ((TLRPC$TL_updateChannelMessageForwards) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelTooLong) {
            return ((TLRPC$TL_updateChannelTooLong) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelReadMessagesContents) {
            return ((TLRPC$TL_updateChannelReadMessagesContents) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelAvailableMessages) {
            return ((TLRPC$TL_updateChannelAvailableMessages) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannel) {
            return ((TLRPC$TL_updateChannel) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelWebPage) {
            return ((TLRPC$TL_updateChannelWebPage) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateDeleteChannelMessages) {
            return ((TLRPC$TL_updateDeleteChannelMessages) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadChannelInbox) {
            return ((TLRPC$TL_updateReadChannelInbox) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadChannelDiscussionInbox) {
            return ((TLRPC$TL_updateReadChannelDiscussionInbox) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateReadChannelDiscussionOutbox) {
            return ((TLRPC$TL_updateReadChannelDiscussionOutbox) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updateChannelUserTyping) {
            return ((TLRPC$TL_updateChannelUserTyping) tLRPC$Update).channel_id;
        }
        if (tLRPC$Update instanceof TLRPC$TL_updatePinnedChannelMessages) {
            return ((TLRPC$TL_updatePinnedChannelMessages) tLRPC$Update).channel_id;
        }
        if (!BuildVars.LOGS_ENABLED) {
            return 0;
        }
        FileLog.e("trying to get unknown update channel_id for " + tLRPC$Update);
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0760 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x097e  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x09b8  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x09d2  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x03e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:474:0x075c A[EDGE_INSN: B:474:0x075c->B:343:0x075c BREAK  A[LOOP:9: B:326:0x071c->B:342:0x0759], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d9 A[PHI: r9
      0x01d9: PHI (r9v23 java.util.ArrayList) = (r9v20 java.util.ArrayList), (r9v24 java.util.ArrayList), (r9v26 java.util.ArrayList), (r9v26 java.util.ArrayList) binds: [B:131:0x0314, B:97:0x0243, B:83:0x01b3, B:84:0x01b5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processUpdates(final org.rbmain.tgnet.TLRPC$Updates r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 2562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.processUpdates(org.rbmain.tgnet.TLRPC$Updates, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdates$232(boolean z, int i, ArrayList arrayList) {
        if (z) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 64);
        }
        updateInterfaceWithMessages(i, arrayList, false);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdates$233(boolean z, TLRPC$Updates tLRPC$Updates, ArrayList arrayList) {
        if (z) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 64);
        }
        updateInterfaceWithMessages(-tLRPC$Updates.chat_id, arrayList, false);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdates$234(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdates$235(final ArrayList arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda84
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdates$234(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdates$237() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 4);
    }

    private boolean applyFoldersUpdates(ArrayList<TLRPC$TL_updateFolderPeers> arrayList) {
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            TLRPC$TL_updateFolderPeers tLRPC$TL_updateFolderPeers = arrayList.get(i);
            int size2 = tLRPC$TL_updateFolderPeers.folder_peers.size();
            for (int i2 = 0; i2 < size2; i2++) {
                TLRPC$TL_folderPeer tLRPC$TL_folderPeer = tLRPC$TL_updateFolderPeers.folder_peers.get(i2);
                TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(DialogObject.getPeerDialogId(tLRPC$TL_folderPeer.peer));
                if (tLRPC$Dialog != null) {
                    int i3 = tLRPC$Dialog.folder_id;
                    int i4 = tLRPC$TL_folderPeer.folder_id;
                    if (i3 != i4) {
                        tLRPC$Dialog.pinned = false;
                        tLRPC$Dialog.pinnedNum = 0;
                        tLRPC$Dialog.folder_id = i4;
                        ensureFolderDialogExists(i4, null);
                    }
                }
            }
            getMessagesStorage().setDialogsFolderId(arrayList.get(i).folder_peers, null, 0L, 0);
            i++;
            z = true;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:931:0x136d, code lost:
    
        if (r0.action.user_id == r14) goto L824;
     */
    /* JADX WARN: Removed duplicated region for block: B:1001:0x14b9  */
    /* JADX WARN: Removed duplicated region for block: B:1004:0x14c3  */
    /* JADX WARN: Removed duplicated region for block: B:1009:0x14d2  */
    /* JADX WARN: Removed duplicated region for block: B:1012:0x14f3  */
    /* JADX WARN: Removed duplicated region for block: B:1013:0x14f6  */
    /* JADX WARN: Removed duplicated region for block: B:1017:0x14fe  */
    /* JADX WARN: Removed duplicated region for block: B:1020:0x150e  */
    /* JADX WARN: Removed duplicated region for block: B:1033:0x153b  */
    /* JADX WARN: Removed duplicated region for block: B:1034:0x1542  */
    /* JADX WARN: Removed duplicated region for block: B:1098:0x1732  */
    /* JADX WARN: Removed duplicated region for block: B:1101:0x1743  */
    /* JADX WARN: Removed duplicated region for block: B:1104:0x1756  */
    /* JADX WARN: Removed duplicated region for block: B:1109:0x1782  */
    /* JADX WARN: Removed duplicated region for block: B:1114:0x17a9  */
    /* JADX WARN: Removed duplicated region for block: B:1119:0x17cf  */
    /* JADX WARN: Removed duplicated region for block: B:667:0x0e97  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x0ea5  */
    /* JADX WARN: Removed duplicated region for block: B:699:0x0f10  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x0f13  */
    /* JADX WARN: Removed duplicated region for block: B:703:0x0f23  */
    /* JADX WARN: Removed duplicated region for block: B:706:0x0f46  */
    /* JADX WARN: Removed duplicated region for block: B:707:0x0f48  */
    /* JADX WARN: Removed duplicated region for block: B:710:0x0f52  */
    /* JADX WARN: Removed duplicated region for block: B:718:0x0f91  */
    /* JADX WARN: Removed duplicated region for block: B:719:0x0f98  */
    /* JADX WARN: Removed duplicated region for block: B:722:0x0fa4  */
    /* JADX WARN: Removed duplicated region for block: B:805:0x1161  */
    /* JADX WARN: Removed duplicated region for block: B:875:0x128a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean processUpdateArray(java.util.ArrayList<org.rbmain.tgnet.TLRPC$Update> r64, final java.util.ArrayList<org.rbmain.tgnet.TLRPC$User> r65, final java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r66, boolean r67, final int r68) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 6133
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.processUpdateArray(java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, boolean, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$238(ArrayList arrayList, ArrayList arrayList2) {
        putUsers(arrayList, false);
        putChats(arrayList2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$239(ArrayList arrayList, ArrayList arrayList2) {
        putUsers(arrayList, false);
        putChats(arrayList2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$241(final TLRPC$TL_updatePeerBlocked tLRPC$TL_updatePeerBlocked) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda145
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdateArray$240(tLRPC$TL_updatePeerBlocked);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$240(TLRPC$TL_updatePeerBlocked tLRPC$TL_updatePeerBlocked) {
        int peerId = MessageObject.getPeerId(tLRPC$TL_updatePeerBlocked.peer_id);
        if (tLRPC$TL_updatePeerBlocked.blocked) {
            if (this.blockePeers.indexOfKey(peerId) < 0) {
                this.blockePeers.put(peerId, 1);
            }
        } else {
            this.blockePeers.delete(peerId);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$242(TLRPC$TL_updateServiceNotification tLRPC$TL_updateServiceNotification) {
        getNotificationCenter().postNotificationName(NotificationCenter.needShowAlert, 2, tLRPC$TL_updateServiceNotification.message, tLRPC$TL_updateServiceNotification.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$243(TLRPC$TL_updateLangPack tLRPC$TL_updateLangPack) throws IOException {
        LocaleController.getInstance().saveRemoteLocaleStringsForCurrentLocale(tLRPC$TL_updateLangPack.difference, this.currentAccount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$244(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$245(final ArrayList arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda91
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdateArray$244(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$246(LongSparseArray longSparseArray) {
        getNotificationsController().processEditedMessages(longSparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$247(final LongSparseArray longSparseArray) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda76
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdateArray$246(longSparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$248(TLRPC$User tLRPC$User) {
        getContactsController().addContactToPhoneBook(tLRPC$User, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$249() {
        getNotificationsController().deleteNotificationChannelGlobal(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$250() {
        getNotificationsController().deleteNotificationChannelGlobal(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$251() {
        getNotificationsController().deleteNotificationChannelGlobal(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$252(TLRPC$TL_updateChannel tLRPC$TL_updateChannel) {
        getChannelDifference(tLRPC$TL_updateChannel.channel_id, 1, 0L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$253(TLRPC$Chat tLRPC$Chat) {
        getNotificationCenter().postNotificationName(NotificationCenter.channelRightsUpdated, tLRPC$Chat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$254(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x07e3, code lost:
    
        if (r6.getCallStateForSubscription() == 0) goto L348;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x07e6, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x07ec, code lost:
    
        if (r6.getCallState() == 0) goto L348;
     */
    /* JADX WARN: Removed duplicated region for block: B:223:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0859 A[Catch: all -> 0x086b, TryCatch #0 {all -> 0x086b, blocks: (B:370:0x084d, B:372:0x0853, B:374:0x085e, B:376:0x0862, B:378:0x0866, B:373:0x0859), top: B:642:0x084d }] */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0d38  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0d54  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0e07  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0e15  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x0e19  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x0e21  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0e41  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0e5c  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x0e72  */
    /* JADX WARN: Removed duplicated region for block: B:687:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processUpdateArray$255(int r41, java.util.ArrayList r42, android.util.SparseArray r43, int r44, androidx.collection.LongSparseArray r45, androidx.collection.LongSparseArray r46, androidx.collection.LongSparseArray r47, java.util.ArrayList r48, androidx.collection.LongSparseArray r49, androidx.collection.LongSparseArray r50, boolean r51, java.util.ArrayList r52, java.util.ArrayList r53, android.util.SparseArray r54, android.util.SparseArray r55, android.util.SparseArray r56, java.util.ArrayList r57) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 3706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.lambda$processUpdateArray$255(int, java.util.ArrayList, android.util.SparseArray, int, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, java.util.ArrayList, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, boolean, java.util.ArrayList, java.util.ArrayList, android.util.SparseArray, android.util.SparseArray, android.util.SparseArray, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$257(final SparseLongArray sparseLongArray, final SparseLongArray sparseLongArray2, final SparseIntArray sparseIntArray, final ArrayList arrayList, final SparseArray sparseArray, final SparseIntArray sparseIntArray2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda116
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdateArray$256(sparseLongArray, sparseLongArray2, sparseIntArray, arrayList, sparseArray, sparseIntArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$256(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2, SparseIntArray sparseIntArray, ArrayList arrayList, SparseArray sparseArray, SparseIntArray sparseIntArray2) {
        int i;
        MessageObject messageObject;
        MessageObject messageObject2;
        MessageObject messageObject3;
        SparseLongArray sparseLongArray3 = sparseLongArray;
        if (sparseLongArray3 == null && sparseLongArray2 == null) {
            i = 0;
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.messagesRead, sparseLongArray3, sparseLongArray2);
            if (sparseLongArray3 != null) {
                getNotificationsController().processReadMessages2(sparseLongArray, 0L, 0, 0, false);
                SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
                int size = sparseLongArray.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int iKeyAt = sparseLongArray3.keyAt(i2);
                    int iValueAt = (int) sparseLongArray3.valueAt(i2);
                    TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(iKeyAt);
                    if (tLRPC$Dialog != null) {
                        long j = tLRPC$Dialog.top_message;
                        if (j > 0 && j <= iValueAt && (messageObject2 = this.dialogMessage.get(tLRPC$Dialog.id)) != null && !messageObject2.isOut()) {
                            messageObject2.setIsRead();
                            i |= 256;
                        }
                    }
                    if (iKeyAt != getUserConfig().getClientUserId()) {
                        editorEdit.remove("diditem" + iKeyAt);
                        editorEdit.remove("diditemo" + iKeyAt);
                    }
                    i2++;
                    sparseLongArray3 = sparseLongArray;
                }
                editorEdit.apply();
            } else {
                i = 0;
            }
            if (sparseLongArray2 != null) {
                int size2 = sparseLongArray2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    int iKeyAt2 = sparseLongArray2.keyAt(i3);
                    int iValueAt2 = (int) sparseLongArray2.valueAt(i3);
                    TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(iKeyAt2);
                    if (tLRPC$Dialog2 != null) {
                        long j2 = tLRPC$Dialog2.top_message;
                        if (j2 > 0 && j2 <= iValueAt2 && (messageObject = this.dialogMessage.get(tLRPC$Dialog2.id)) != null && messageObject.isOut()) {
                            messageObject.setIsRead();
                            i |= 256;
                        }
                    }
                }
            }
        }
        if (sparseIntArray != null) {
            int size3 = sparseIntArray.size();
            for (int i4 = 0; i4 < size3; i4++) {
                int iKeyAt3 = sparseIntArray.keyAt(i4);
                int iValueAt3 = sparseIntArray.valueAt(i4);
                getNotificationCenter().postNotificationName(NotificationCenter.messagesReadEncrypted, Integer.valueOf(iKeyAt3), Integer.valueOf(iValueAt3));
                long j3 = iKeyAt3 << 32;
                if (this.dialogs_dict.get(j3) != null && (messageObject3 = this.dialogMessage.get(j3)) != null && messageObject3.messageOwner.date <= iValueAt3) {
                    messageObject3.setIsRead();
                    i |= 256;
                }
            }
        }
        if (arrayList != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.messagesReadContent, arrayList);
        }
        if (sparseArray != null) {
            int size4 = sparseArray.size();
            for (int i5 = 0; i5 < size4; i5++) {
                int iKeyAt4 = sparseArray.keyAt(i5);
                ArrayList arrayList2 = (ArrayList) sparseArray.valueAt(i5);
                if (arrayList2 != null) {
                    getNotificationCenter().postNotificationName(NotificationCenter.messagesDeleted, arrayList2, Integer.valueOf(iKeyAt4), Boolean.TRUE);
                }
            }
        }
        if (sparseIntArray2 != null) {
            int size5 = sparseIntArray2.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size5) {
                    break;
                }
                int iKeyAt5 = sparseIntArray2.keyAt(i6);
                int iValueAt4 = sparseIntArray2.valueAt(i6);
                long j4 = -iKeyAt5;
                getNotificationCenter().postNotificationName(NotificationCenter.historyCleared, Long.valueOf(j4), Integer.valueOf(iValueAt4));
                MessageObject messageObject4 = this.dialogMessage.get(j4);
                if (messageObject4 != null && messageObject4.getId() <= iValueAt4) {
                    messageObject4.deleted = true;
                    break;
                }
                i6++;
            }
            getNotificationsController().removeDeletedHisoryFromNotifications(sparseIntArray2);
        }
        if (i != 0) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$258(ArrayList arrayList, int i) {
        getMessagesStorage().updateDialogsWithDeletedMessages(arrayList, getMessagesStorage().markMessagesAsDeleted(arrayList, false, i, true, false), false, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateArray$259(int i, int i2) {
        getMessagesStorage().updateDialogsWithDeletedMessages(new ArrayList<>(), getMessagesStorage().markMessagesAsDeleted(i, i2, false, true), false, i);
    }

    public boolean isDialogMuted(long j, int i) {
        return isDialogMuted(j, i, null);
    }

    public boolean isDialogNotificationsSoundEnabled(long j, int i) {
        return this.notificationsPreferences.getBoolean("sound_enabled_" + NotificationsController.getSharedPrefKey(j, i), true);
    }

    public boolean isDialogMuted(long j) {
        return isDialogMuted(j, 0, null);
    }

    public boolean isDialogMuted(long j, int i, TLRPC$Chat tLRPC$Chat) {
        Boolean boolValueOf;
        int i2 = this.notificationsPreferences.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + j, -1);
        boolean z = false;
        if (i2 == -1) {
            if (tLRPC$Chat != null) {
                if (ChatObject.isChannel(tLRPC$Chat) && !tLRPC$Chat.megagroup) {
                    z = true;
                }
                boolValueOf = Boolean.valueOf(z);
            } else {
                boolValueOf = null;
            }
            return !getNotificationsController().isGlobalNotificationsEnabled(j, boolValueOf);
        }
        if (i2 == 2) {
            return true;
        }
        if (i2 == 3) {
            if (this.notificationsPreferences.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + j, 0) >= getConnectionsManager().getCurrentTime()) {
                return true;
            }
        }
        return false;
    }

    public CharSequence getPrintingString(long j, long j2, boolean z) {
        LongSparseArray<CharSequence> longSparseArray;
        int i;
        TLRPC$User user;
        TLRPC$UserStatus tLRPC$UserStatus;
        if ((!z || (i = (int) j) <= 0 || (user = getUser(Integer.valueOf(i))) == null || (tLRPC$UserStatus = user.status) == null || tLRPC$UserStatus.expires >= 0) && (longSparseArray = this.printingStrings.get(j)) != null) {
            return longSparseArray.get(j2);
        }
        return null;
    }

    public Integer getPrintingStringType(long j, long j2) {
        LongSparseArray<Integer> longSparseArray = this.printingStringsTypes.get(j);
        if (longSparseArray == null) {
            return null;
        }
        return longSparseArray.get(j2);
    }

    public boolean updatePrintingUsersWithNewMessages(long j, ArrayList<MessageObject> arrayList) {
        boolean z;
        if (j > 0) {
            if (this.printingUsers.get(Long.valueOf(j)) != null) {
                this.printingUsers.remove(Long.valueOf(j));
                return true;
            }
        } else if (j < 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<MessageObject> it = arrayList.iterator();
            while (it.hasNext()) {
                MessageObject next = it.next();
                if (next.isFromUser() && !arrayList2.contains(Integer.valueOf(next.messageOwner.from_id.user_id))) {
                    arrayList2.add(Integer.valueOf(next.messageOwner.from_id.user_id));
                }
            }
            ConcurrentHashMap<Long, ArrayList<PrintingUser>> concurrentHashMap = this.printingUsers.get(Long.valueOf(j));
            if (concurrentHashMap != null) {
                ArrayList arrayList3 = null;
                z = false;
                for (Map.Entry<Long, ArrayList<PrintingUser>> entry : concurrentHashMap.entrySet()) {
                    Long key = entry.getKey();
                    ArrayList<PrintingUser> value = entry.getValue();
                    int i = 0;
                    while (i < value.size()) {
                        if (arrayList2.contains(Integer.valueOf(value.get(i).userId))) {
                            value.remove(i);
                            i--;
                            if (value.isEmpty()) {
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(key);
                            }
                            z = true;
                        }
                        i++;
                    }
                }
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        concurrentHashMap.remove(arrayList3.get(i2));
                    }
                    if (concurrentHashMap.isEmpty()) {
                        this.printingUsers.remove(Long.valueOf(j));
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean updateInterfaceWithMessages(final long r23, java.util.ArrayList<org.rbmain.messenger.MessageObject> r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 1012
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.updateInterfaceWithMessages(long, java.util.ArrayList, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateInterfaceWithMessages$260(TLRPC$Dialog tLRPC$Dialog, long j, long j2, int i) {
        int i2;
        if (i == -1) {
            if (j <= 0 || (i2 = (int) j2) == 0) {
                return;
            }
            loadUnknownDialog(getInputPeer(i2), 0L);
            return;
        }
        if (i != 0) {
            tLRPC$Dialog.folder_id = i;
            sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
        }
    }

    public void addDialogAction(long j, boolean z) {
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        if (tLRPC$Dialog == null) {
            return;
        }
        if (z) {
            this.clearingHistoryDialogs.put(j, tLRPC$Dialog);
        } else {
            this.deletingDialogs.put(j, tLRPC$Dialog);
            this.allDialogs.remove(tLRPC$Dialog);
            sortDialogs(null);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    public void removeDialogAction(long j, boolean z, boolean z2) {
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        if (tLRPC$Dialog == null) {
            this.deletingDialogs.remove(j);
            return;
        }
        if (z) {
            this.clearingHistoryDialogs.remove(j);
        } else {
            this.deletingDialogs.remove(j);
            if (!z2) {
                this.allDialogs.add(tLRPC$Dialog);
                sortDialogs(null);
            }
        }
        if (z2) {
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    public boolean isClearingDialog(long j) {
        return this.clearingHistoryDialogs.get(j) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sortDialogs(android.util.SparseArray<org.rbmain.tgnet.TLRPC$Chat> r14) {
        /*
            Method dump skipped, instructions count: 647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesController.sortDialogs(android.util.SparseArray):void");
    }

    private void addDialogToItsFolder(int i, TLRPC$Dialog tLRPC$Dialog) {
        int i2 = tLRPC$Dialog instanceof TLRPC$TL_dialogFolder ? 0 : tLRPC$Dialog.folder_id;
        ArrayList<TLRPC$Dialog> arrayList = this.dialogsByFolder.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.dialogsByFolder.put(i2, arrayList);
        }
        if (i == -1) {
            arrayList.add(tLRPC$Dialog);
            return;
        }
        if (i == -2) {
            if (arrayList.isEmpty() || !(arrayList.get(0) instanceof TLRPC$TL_dialogFolder)) {
                arrayList.add(0, tLRPC$Dialog);
                return;
            } else {
                arrayList.add(1, tLRPC$Dialog);
                return;
            }
        }
        arrayList.add(i, tLRPC$Dialog);
    }

    public static String getRestrictionReason(ArrayList<TLRPC$TL_restrictionReason> arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_restrictionReason tLRPC$TL_restrictionReason = arrayList.get(i);
            if ("all".equals(tLRPC$TL_restrictionReason.platform) || !(AndroidUtilities.isStandaloneApp() || AndroidUtilities.isBetaApp() || !"android".equals(tLRPC$TL_restrictionReason.platform))) {
                return tLRPC$TL_restrictionReason.text;
            }
        }
        return null;
    }

    public static void showCantOpenAlert(BaseFragment baseFragment, String str) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", ir.medu.shad.R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", ir.medu.shad.R.string.OK), null);
        builder.setMessage(str);
        baseFragment.showDialog(builder.create());
    }

    public boolean checkCanOpenChat(Bundle bundle, BaseFragment baseFragment) {
        return checkCanOpenChat(bundle, baseFragment, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean checkCanOpenChat(final Bundle bundle, final BaseFragment baseFragment, MessageObject messageObject) {
        TLRPC$Chat chat;
        long j;
        String restrictionReason;
        int dialogId;
        TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages;
        if (bundle != null && baseFragment != null) {
            int i = bundle.getInt("user_id", 0);
            int i2 = bundle.getInt("chat_id", 0);
            long j2 = bundle.getLong("message_id", 0L);
            TLRPC$User user = null;
            if (i != 0) {
                j = i;
                user = getUser(Integer.valueOf(i));
                chat = null;
            } else if (i2 != 0) {
                j = -i2;
                chat = getChat(Integer.valueOf(i2));
            } else {
                chat = null;
                j = 0;
            }
            if (user == null && chat == null) {
                return true;
            }
            String dialogId2 = IdStorage.getInstance().getDialogId(j);
            ChatType chatType = DialogsProxy.getInstance(this.currentAccount).getChatType(j);
            if (dialogId2 != null && chatType != null) {
                if (!ChildLockCheck.canOpenMessengerChatWithAlert(dialogId2, chatType)) {
                    return false;
                }
                if (chat != null) {
                    restrictionReason = getRestrictionReason(chat.restriction_reason);
                } else {
                    restrictionReason = getRestrictionReason(user.restriction_reason);
                }
                if (restrictionReason != null) {
                    showCantOpenAlert(baseFragment, restrictionReason);
                    return false;
                }
                if (j2 != 0 && messageObject != null && chat != null && chat.access_hash == 0 && (dialogId = (int) messageObject.getDialogId()) != 0) {
                    final AlertDialog alertDialog = new AlertDialog(baseFragment.getParentActivity(), 3);
                    if (dialogId < 0) {
                        chat = getChat(Integer.valueOf(-dialogId));
                    }
                    if (dialogId > 0 || !ChatObject.isChannel(chat)) {
                        TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages2 = new TLRPC$TL_messages_getMessages();
                        tLRPC$TL_messages_getMessages2.id.add(Long.valueOf(messageObject.getId()));
                        tLRPC$TL_messages_getMessages = tLRPC$TL_messages_getMessages2;
                    } else {
                        TLRPC$Chat chat2 = getChat(Integer.valueOf(-dialogId));
                        TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                        tLRPC$TL_channels_getMessages.channel = getInputChannel(chat2);
                        tLRPC$TL_channels_getMessages.id.add(Long.valueOf(messageObject.getId()));
                        tLRPC$TL_messages_getMessages = tLRPC$TL_channels_getMessages;
                    }
                    final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda253
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$checkCanOpenChat$262(alertDialog, baseFragment, bundle, tLObject, tLRPC$TL_error);
                        }
                    });
                    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            this.f$0.lambda$checkCanOpenChat$263(iSendRequest, baseFragment, dialogInterface);
                        }
                    });
                    baseFragment.setVisibleDialog(alertDialog);
                    alertDialog.show();
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkCanOpenChat$262(final AlertDialog alertDialog, final BaseFragment baseFragment, final Bundle bundle, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda167
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkCanOpenChat$261(alertDialog, tLObject, baseFragment, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkCanOpenChat$261(AlertDialog alertDialog, TLObject tLObject, BaseFragment baseFragment, Bundle bundle) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
        putUsers(tLRPC$messages_Messages.users, false);
        putChats(tLRPC$messages_Messages.chats, false);
        getMessagesStorage().putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
        baseFragment.presentFragment(new ChatActivity(bundle), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkCanOpenChat$263(int i, BaseFragment baseFragment, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
        baseFragment.setVisibleDialog(null);
    }

    public static void openChatOrProfileWith(TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, BaseFragment baseFragment, int i, boolean z) {
        long j;
        String restrictionReason;
        if ((tLRPC$User == null && tLRPC$Chat == null) || baseFragment == null) {
            return;
        }
        if (tLRPC$Chat != null) {
            j = -tLRPC$Chat.id;
            restrictionReason = getRestrictionReason(tLRPC$Chat.restriction_reason);
        } else {
            j = tLRPC$User.id;
            restrictionReason = getRestrictionReason(tLRPC$User.restriction_reason);
            if (i != 3 && tLRPC$User.bot) {
                i = 1;
                z = true;
            }
        }
        String dialogId = IdStorage.getInstance().getDialogId(j);
        ChatType chatType = DialogsProxy.getInstance(baseFragment.getCurrentAccount()).getChatType(j);
        String myGuid = ServiceLocator.getInstance(baseFragment.getCurrentAccount()).getCoreMainClass().getMyGuid();
        if (TextUtils.isEmpty(dialogId) || chatType == null || j == UserConfig.getInstance(baseFragment.getCurrentAccount()).getClientUserId() || ChildLockCheck.canOpenMessengerChatWithAlert(dialogId, chatType)) {
            if (restrictionReason != null) {
                showCantOpenAlert(baseFragment, restrictionReason);
                return;
            }
            Bundle bundle = new Bundle();
            if (tLRPC$Chat != null) {
                bundle.putInt("chat_id", tLRPC$Chat.id);
            } else {
                bundle.putInt("user_id", tLRPC$User.id);
            }
            if (i == 0 && !Objects.equals(myGuid, dialogId)) {
                baseFragment.presentFragment(new ProfileActivity(bundle));
            } else if (i == 2) {
                baseFragment.presentFragment(new ChatActivity(bundle), true, true);
            } else {
                baseFragment.presentFragment(new ChatActivity(bundle), z);
            }
        }
    }

    public static void openChatOrProfileWith(TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, BaseFragment baseFragment, String str, String str2) {
        long j;
        if ((tLRPC$User == null && tLRPC$Chat == null) || baseFragment == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (tLRPC$Chat != null) {
            int i = tLRPC$Chat.id;
            j = -i;
            bundle.putInt("chat_id", i);
        } else {
            int i2 = tLRPC$User.id;
            j = i2;
            bundle.putInt("user_id", i2);
        }
        String dialogId = IdStorage.getInstance().getDialogId(j);
        ChatType chatType = DialogsProxy.getInstance(baseFragment.getCurrentAccount()).getChatType(j);
        if (TextUtils.isEmpty(dialogId) || chatType == null || j == UserConfig.getInstance(baseFragment.getCurrentAccount()).getClientUserId() || ChildLockCheck.canOpenMessengerChatWithAlert(dialogId, chatType)) {
            ChatActivity chatActivity = new ChatActivity(bundle);
            baseFragment.presentFragment(chatActivity, false);
            chatActivity.startBot(str, str2);
        }
    }

    public void openByUserName(String str, final BaseFragment baseFragment, final int i) {
        if (str == null || baseFragment == null) {
            return;
        }
        TLObject userOrChat = getUserOrChat(str);
        if (userOrChat instanceof TLRPC$User) {
            boolean z = ((TLRPC$User) userOrChat).min;
        } else if (userOrChat instanceof TLRPC$Chat) {
            boolean z2 = ((TLRPC$Chat) userOrChat).min;
        }
        if (baseFragment.getParentActivity() == null) {
            return;
        }
        final AlertDialog[] alertDialogArr = {new AlertDialog(baseFragment.getParentActivity(), 3)};
        TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
        tLRPC$TL_contacts_resolveUsername.username = str;
        final int objectInfoByUserName = getDialogsProxy().getObjectInfoByUserName(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda261
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$openByUserName$265(alertDialogArr, baseFragment, i, tLObject, tLRPC$TL_error);
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda174
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openByUserName$267(alertDialogArr, objectInfoByUserName, baseFragment);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openByUserName$265(final AlertDialog[] alertDialogArr, final BaseFragment baseFragment, final int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda175
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openByUserName$264(alertDialogArr, baseFragment, tLRPC$TL_error, tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openByUserName$264(AlertDialog[] alertDialogArr, BaseFragment baseFragment, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i) {
        try {
            alertDialogArr[0].dismiss();
        } catch (Exception unused) {
        }
        alertDialogArr[0] = null;
        baseFragment.setVisibleDialog(null);
        if (tLRPC$TL_error == null) {
            TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
            putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
            putChats(tLRPC$TL_contacts_resolvedPeer.chats, false);
            getMessagesStorage().putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, false, true);
            if (!tLRPC$TL_contacts_resolvedPeer.chats.isEmpty()) {
                openChatOrProfileWith((TLRPC$User) null, tLRPC$TL_contacts_resolvedPeer.chats.get(0), baseFragment, 1, false);
                return;
            } else {
                if (tLRPC$TL_contacts_resolvedPeer.users.isEmpty()) {
                    return;
                }
                openChatOrProfileWith(tLRPC$TL_contacts_resolvedPeer.users.get(0), (TLRPC$Chat) null, baseFragment, i, false);
                return;
            }
        }
        if (baseFragment.getParentActivity() != null) {
            try {
                if (tLRPC$TL_error.code == -1) {
                    BulletinFactory.of(baseFragment).createErrorBulletin(LocaleController.getString("NoUsernameFound", ir.medu.shad.R.string.NoUsernameFound)).show();
                } else {
                    BulletinFactory.of(baseFragment).createErrorBulletin(tLRPC$TL_error.text).show();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openByUserName$267(AlertDialog[] alertDialogArr, final int i, BaseFragment baseFragment) {
        if (alertDialogArr[0] == null) {
            return;
        }
        alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$openByUserName$266(i, dialogInterface);
            }
        });
        baseFragment.showDialog(alertDialogArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openByUserName$266(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }

    public void ensureMessagesLoaded(final long j, long j2, final MessagesLoadedCallback messagesLoadedCallback) {
        long j3;
        SharedPreferences notificationsSettings = getNotificationsSettings(this.currentAccount);
        if (j2 == 0) {
            j3 = notificationsSettings.getLong("diditem" + j, 0L);
        } else {
            j3 = j2;
        }
        final int iGenerateClassGuid = ConnectionsManager.generateClassGuid();
        int i = (int) j;
        final int i2 = i < 0 ? -i : 0;
        TLRPC$Chat chat = null;
        if (i2 != 0 && (chat = getMessagesController().getChat(Integer.valueOf(i2))) == null) {
            final MessagesStorage messagesStorage = getMessagesStorage();
            final long j4 = j3;
            messagesStorage.getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda114
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$ensureMessagesLoaded$269(messagesStorage, i2, j, j4, messagesLoadedCallback);
                }
            });
            return;
        }
        final boolean zIsChannel = ChatObject.isChannel(chat);
        int i3 = AndroidUtilities.isTablet() ? 30 : 20;
        final int i4 = i3;
        final long j5 = j3;
        NotificationCenter.NotificationCenterDelegate notificationCenterDelegate = new NotificationCenter.NotificationCenterDelegate() { // from class: org.rbmain.messenger.MessagesController.1
            @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
            public void didReceivedNotification(int i5, int i6, Object... objArr) {
                int i7 = NotificationCenter.messagesDidLoadWithoutProcess;
                if (i5 == i7 && ((Integer) objArr[0]).intValue() == iGenerateClassGuid) {
                    ((Integer) objArr[1]).intValue();
                    boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                    ((Boolean) objArr[3]).booleanValue();
                    ((Long) objArr[4]).longValue();
                    int i8 = i4 / 2;
                    MessagesController.this.getNotificationCenter().removeObserver(this, i7);
                    MessagesController.this.getNotificationCenter().removeObserver(this, NotificationCenter.loadingMessagesFailed);
                    MessagesLoadedCallback messagesLoadedCallback2 = messagesLoadedCallback;
                    if (messagesLoadedCallback2 != null) {
                        messagesLoadedCallback2.onMessagesLoaded(zBooleanValue);
                        return;
                    }
                    return;
                }
                int i9 = NotificationCenter.loadingMessagesFailed;
                if (i5 == i9 && ((Integer) objArr[0]).intValue() == iGenerateClassGuid) {
                    MessagesController.this.getNotificationCenter().removeObserver(this, i7);
                    MessagesController.this.getNotificationCenter().removeObserver(this, i9);
                    MessagesLoadedCallback messagesLoadedCallback3 = messagesLoadedCallback;
                    if (messagesLoadedCallback3 != null) {
                        messagesLoadedCallback3.onError();
                    }
                }
            }
        };
        getNotificationCenter().addObserver(notificationCenterDelegate, NotificationCenter.messagesDidLoadWithoutProcess);
        getNotificationCenter().addObserver(notificationCenterDelegate, NotificationCenter.loadingMessagesFailed);
        if (j3 != 0) {
            loadMessagesInternal(j, 0L, true, i3, j3, 0, true, 0, iGenerateClassGuid, 3, 0L, zIsChannel, 0, 0L, 0, 0L, 0, 0, false, 0, true, false);
        } else {
            loadMessagesInternal(j, 0L, true, i3, j3, 0, true, 0, iGenerateClassGuid, 2, 0L, zIsChannel, 0, 0L, 0, 0L, 0, 0, false, 0, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureMessagesLoaded$269(MessagesStorage messagesStorage, int i, final long j, final long j2, final MessagesLoadedCallback messagesLoadedCallback) {
        final TLRPC$Chat chat = messagesStorage.getChat(i);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda126
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$ensureMessagesLoaded$268(chat, j, j2, messagesLoadedCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureMessagesLoaded$268(TLRPC$Chat tLRPC$Chat, long j, long j2, MessagesLoadedCallback messagesLoadedCallback) {
        if (tLRPC$Chat != null) {
            getMessagesController().putChat(tLRPC$Chat, true);
            ensureMessagesLoaded(j, j2, messagesLoadedCallback);
        } else if (messagesLoadedCallback != null) {
            messagesLoadedCallback.onError();
        }
    }

    public void processAdsDialogs(final ArrayList<TLRPC$Dialog> arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda86
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processAdsDialogs$270(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processAdsDialogs$270(ArrayList arrayList) {
        String str;
        this.adsDialogs.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) it.next();
            this.adsDialogs.add(tLRPC$Dialog);
            if (this.dialogs_dict != null) {
                str = this.dialogs_dict.size() + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            } else {
                str = "null";
            }
            FirebaseEventSender.setKey("dialogs_dictput6", str);
            this.dialogs_dict.put(tLRPC$Dialog.id, tLRPC$Dialog);
        }
        sortDialogs(null);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    public void requestDeleteAccount() {
        if (this.requestDeleteAcountInProgress) {
            return;
        }
        this.requestDeleteAcountInProgress = true;
        final LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                MessagesController.lambda$requestDeleteAccount$271(loadingDialog);
            }
        });
        getDialogsProxy().requestDeleteAccount(new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda241
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$requestDeleteAccount$272(loadingDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestDeleteAccount$271(LoadingDialog loadingDialog) {
        try {
            loadingDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDeleteAccount$272(LoadingDialog loadingDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        try {
            this.requestDeleteAcountInProgress = false;
            loadingDialog.dismiss();
        } catch (Exception unused) {
        }
        if (tLRPC$TL_error == null) {
            return;
        }
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [androidMessenger.proxy.DialogsProxy] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v6, types: [org.rbmain.tgnet.TLObject] */
    /* JADX WARN: Type inference failed for: r12v7, types: [org.rbmain.tgnet.TLRPC$TL_channels_inviteToChannel] */
    public void addUsersToChat(final int i, ArrayList<TLRPC$User> arrayList, int i2, String str, final BaseFragment baseFragment, final Utilities.CallBack<ArrayList<TLRPC$User>> callBack) {
        ?? tLRPC$TL_channels_inviteToChannel;
        if (arrayList == null) {
            return;
        }
        final boolean zIsChannel = ChatObject.isChannel(i, this.currentAccount);
        final boolean z = zIsChannel && getChat(Integer.valueOf(i)).megagroup;
        if (str == null || (zIsChannel && !z)) {
            if (zIsChannel) {
                tLRPC$TL_channels_inviteToChannel = new TLRPC$TL_channels_inviteToChannel();
                tLRPC$TL_channels_inviteToChannel.channel = getInputChannel(i);
                Iterator<TLRPC$User> it = arrayList.iterator();
                while (it.hasNext()) {
                    TLRPC$InputUser inputUser = getInputUser(it.next());
                    if (!(inputUser instanceof TLRPC$TL_inputUserSelf)) {
                        tLRPC$TL_channels_inviteToChannel.users.add(inputUser);
                    }
                }
            } else {
                TLRPC$TL_messages_addChatUser tLRPC$TL_messages_addChatUser = new TLRPC$TL_messages_addChatUser();
                tLRPC$TL_messages_addChatUser.chat_id = i;
                tLRPC$TL_messages_addChatUser.fwd_limit = i2;
                Iterator<TLRPC$User> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    TLRPC$InputUser inputUser2 = getInputUser(it2.next());
                    if (!(inputUser2 instanceof TLRPC$TL_inputUserSelf)) {
                        tLRPC$TL_messages_addChatUser.user_ids.add(inputUser2);
                    }
                }
                tLRPC$TL_channels_inviteToChannel = tLRPC$TL_messages_addChatUser;
            }
            final TLObject tLObject = tLRPC$TL_channels_inviteToChannel;
            getDialogsProxy().addMembersToChat(tLRPC$TL_channels_inviteToChannel, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda254
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$addUsersToChat$276(baseFragment, tLObject, zIsChannel, z, i, callBack, tLObject2, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUsersToChat$276(final BaseFragment baseFragment, final TLObject tLObject, final boolean z, final boolean z2, final int i, final Utilities.CallBack callBack, TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda134
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUsersToChat$273(tLRPC$TL_error, baseFragment, tLObject, z, z2);
                }
            });
            return;
        }
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUsersToChat$274(i);
                }
            }, 1000L);
        }
        final ArrayList arrayList = new ArrayList();
        if (tLObject2 instanceof TLRPC$Updates) {
            Iterator<TLRPC$Update> it = ((TLRPC$Updates) tLObject2).updates.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TLRPC$Update next = it.next();
                if (next instanceof TLRPC$TL_updateAddedUsers) {
                    Iterator<TLRPC$User> it2 = ((TLRPC$TL_updateAddedUsers) next).users.iterator();
                    while (it2.hasNext()) {
                        TLRPC$User next2 = it2.next();
                        if (next2 != null) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        if (callBack == null || arrayList.isEmpty()) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda178
            @Override // java.lang.Runnable
            public final void run() {
                callBack.run(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUsersToChat$273(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLObject tLObject, boolean z, boolean z2) {
        int i = this.currentAccount;
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(z && !z2);
        AlertsCreator.processError(i, tLRPC$TL_error, baseFragment, tLObject, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUsersToChat$274(int i) {
        loadFullChat(i, 0, false);
    }

    public void markReactionsAsRead(long j, int i) {
        TLRPC$Dialog tLRPC$Dialog;
        if (i == 0 && (tLRPC$Dialog = this.dialogs_dict.get(j)) != null) {
            tLRPC$Dialog.unread_reactions_count = 0;
        }
        TLRPC$TL_messages_readReactions tLRPC$TL_messages_readReactions = new TLRPC$TL_messages_readReactions();
        tLRPC$TL_messages_readReactions.peer = getInputPeer((int) j);
        if (i != 0) {
            tLRPC$TL_messages_readReactions.top_msg_id = i;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readReactions, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda280
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$markReactionsAsRead$277(tLObject, tLRPC$TL_error);
            }
        });
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_REACTIONS_READ));
    }

    public int getMaxUserReactionsCount() {
        return getUserConfig().isPremium() ? this.reactionsUserMaxPremium : this.reactionsUserMaxDefault;
    }

    public void setChatReactions(final int i, int i2, List<String> list) {
        final TLRPC$TL_messages_setChatAvailableReactions tLRPC$TL_messages_setChatAvailableReactions = new TLRPC$TL_messages_setChatAvailableReactions();
        tLRPC$TL_messages_setChatAvailableReactions.peer = getInputPeer(-i);
        if (i2 == 2) {
            tLRPC$TL_messages_setChatAvailableReactions.available_reactions = new TLRPC$TL_chatReactionsNone();
        } else if (i2 == 0) {
            tLRPC$TL_messages_setChatAvailableReactions.available_reactions = new TLRPC$TL_chatReactionsAll();
        } else {
            TLRPC$TL_chatReactionsSome tLRPC$TL_chatReactionsSome = new TLRPC$TL_chatReactionsSome();
            tLRPC$TL_messages_setChatAvailableReactions.available_reactions = tLRPC$TL_chatReactionsSome;
            for (int i3 = 0; i3 < list.size(); i3++) {
                TLRPC$TL_reactionEmoji tLRPC$TL_reactionEmoji = new TLRPC$TL_reactionEmoji();
                tLRPC$TL_reactionEmoji.reactionId = list.get(i3);
                tLRPC$TL_chatReactionsSome.reactions.add(tLRPC$TL_reactionEmoji);
            }
        }
        getDialogsProxy().editChatReactionSetting(tLRPC$TL_messages_setChatAvailableReactions, new RequestDelegate() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda222
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setChatReactions$279(i, tLRPC$TL_messages_setChatAvailableReactions, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setChatReactions$279(final int i, TLRPC$TL_messages_setChatAvailableReactions tLRPC$TL_messages_setChatAvailableReactions, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            getChatFull(i).available_reactions = tLRPC$TL_messages_setChatAvailableReactions.available_reactions;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesController$$ExternalSyntheticLambda43
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setChatReactions$278(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setChatReactions$278(int i) {
        getNotificationCenter().postNotificationName(NotificationCenter.chatAvailableReactionsUpdated, Integer.valueOf(i), 0);
    }
}
