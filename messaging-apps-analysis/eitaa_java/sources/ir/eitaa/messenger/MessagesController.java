package ir.eitaa.messenger;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.collection.LongSparseArray;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.support.LongSparseIntArray;
import ir.eitaa.messenger.support.LongSparseLongArray;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$Ads_Location;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$DialogPeer;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DraftMessage;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputChannel;
import ir.eitaa.tgnet.TLRPC$InputChatPhoto;
import ir.eitaa.tgnet.TLRPC$InputDialogPeer;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$InputPhoto;
import ir.eitaa.tgnet.TLRPC$InputUser;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$MessageReplies;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PeerNotifySettings;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$Poll;
import ir.eitaa.tgnet.TLRPC$RecentMeUrl;
import ir.eitaa.tgnet.TLRPC$ReportReason;
import ir.eitaa.tgnet.TLRPC$SendMessageAction;
import ir.eitaa.tgnet.TLRPC$TL_Live_getMedia;
import ir.eitaa.tgnet.TLRPC$TL_Stat_ShopTile;
import ir.eitaa.tgnet.TLRPC$TL_UrlWhiteList;
import ir.eitaa.tgnet.TLRPC$TL_account_createTheme;
import ir.eitaa.tgnet.TLRPC$TL_account_getNotifySettings;
import ir.eitaa.tgnet.TLRPC$TL_account_installTheme;
import ir.eitaa.tgnet.TLRPC$TL_account_installWallPaper;
import ir.eitaa.tgnet.TLRPC$TL_account_registerDevice;
import ir.eitaa.tgnet.TLRPC$TL_account_reportPeer;
import ir.eitaa.tgnet.TLRPC$TL_account_sendDeviceUserIds;
import ir.eitaa.tgnet.TLRPC$TL_account_unregisterDevice;
import ir.eitaa.tgnet.TLRPC$TL_account_updateStatus;
import ir.eitaa.tgnet.TLRPC$TL_account_updateTheme;
import ir.eitaa.tgnet.TLRPC$TL_account_uploadTheme;
import ir.eitaa.tgnet.TLRPC$TL_account_uploadWallPaper;
import ir.eitaa.tgnet.TLRPC$TL_ads_AdPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_dialogAd;
import ir.eitaa.tgnet.TLRPC$TL_ads_emptyAd;
import ir.eitaa.tgnet.TLRPC$TL_ads_getAdsPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationDialog;
import ir.eitaa.tgnet.TLRPC$TL_boolFalse;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_botInfo;
import ir.eitaa.tgnet.TLRPC$TL_channel;
import ir.eitaa.tgnet.TLRPC$TL_channelForbidden;
import ir.eitaa.tgnet.TLRPC$TL_channelFull;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantSelf;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsAdmins;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsRecent;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipants;
import ir.eitaa.tgnet.TLRPC$TL_channels_convertToGigagroup;
import ir.eitaa.tgnet.TLRPC$TL_channels_createChannel;
import ir.eitaa.tgnet.TLRPC$TL_channels_deleteChannel;
import ir.eitaa.tgnet.TLRPC$TL_channels_deleteUserHistory;
import ir.eitaa.tgnet.TLRPC$TL_channels_editAdmin;
import ir.eitaa.tgnet.TLRPC$TL_channels_editBanned;
import ir.eitaa.tgnet.TLRPC$TL_channels_editPhoto;
import ir.eitaa.tgnet.TLRPC$TL_channels_editTitle;
import ir.eitaa.tgnet.TLRPC$TL_channels_getChannels;
import ir.eitaa.tgnet.TLRPC$TL_channels_getMessages;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants_2;
import ir.eitaa.tgnet.TLRPC$TL_channels_getSponsoredMessages;
import ir.eitaa.tgnet.TLRPC$TL_channels_inviteToChannel;
import ir.eitaa.tgnet.TLRPC$TL_channels_joinChannel;
import ir.eitaa.tgnet.TLRPC$TL_channels_leaveChannel;
import ir.eitaa.tgnet.TLRPC$TL_channels_readHistory;
import ir.eitaa.tgnet.TLRPC$TL_channels_readMessageContents;
import ir.eitaa.tgnet.TLRPC$TL_channels_toggleContentType;
import ir.eitaa.tgnet.TLRPC$TL_channels_togglePreHistoryHidden;
import ir.eitaa.tgnet.TLRPC$TL_channels_toggleSignatures;
import ir.eitaa.tgnet.TLRPC$TL_channels_toggleSlowMode;
import ir.eitaa.tgnet.TLRPC$TL_channels_updateUsername;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_chatOnlines;
import ir.eitaa.tgnet.TLRPC$TL_config;
import ir.eitaa.tgnet.TLRPC$TL_contacts_block;
import ir.eitaa.tgnet.TLRPC$TL_contacts_getBlocked;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolvedPeer;
import ir.eitaa.tgnet.TLRPC$TL_contacts_unblock;
import ir.eitaa.tgnet.TLRPC$TL_dialog;
import ir.eitaa.tgnet.TLRPC$TL_dialogFilterSuggested;
import ir.eitaa.tgnet.TLRPC$TL_dialogFolder;
import ir.eitaa.tgnet.TLRPC$TL_dialogPeer;
import ir.eitaa.tgnet.TLRPC$TL_documentEmpty;
import ir.eitaa.tgnet.TLRPC$TL_draftMessage;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChat;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChatWaiting;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_folder;
import ir.eitaa.tgnet.TLRPC$TL_folderPeer;
import ir.eitaa.tgnet.TLRPC$TL_groupCallDiscarded;
import ir.eitaa.tgnet.TLRPC$TL_help_dismissSuggestion;
import ir.eitaa.tgnet.TLRPC$TL_help_getAppChangelog;
import ir.eitaa.tgnet.TLRPC$TL_help_getRecentMeUrls;
import ir.eitaa.tgnet.TLRPC$TL_help_hidePromoData;
import ir.eitaa.tgnet.TLRPC$TL_help_promoData;
import ir.eitaa.tgnet.TLRPC$TL_help_recentMeUrls;
import ir.eitaa.tgnet.TLRPC$TL_help_termsOfServiceUpdate;
import ir.eitaa.tgnet.TLRPC$TL_help_termsOfServiceUpdateEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputChannelEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputChatPhoto;
import ir.eitaa.tgnet.TLRPC$TL_inputChatUploadedPhoto;
import ir.eitaa.tgnet.TLRPC$TL_inputDialogPeer;
import ir.eitaa.tgnet.TLRPC$TL_inputDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputEncryptedChat;
import ir.eitaa.tgnet.TLRPC$TL_inputGeoPoint;
import ir.eitaa.tgnet.TLRPC$TL_inputGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterChatPhotos;
import ir.eitaa.tgnet.TLRPC$TL_inputNotifyBroadcasts;
import ir.eitaa.tgnet.TLRPC$TL_inputNotifyChats;
import ir.eitaa.tgnet.TLRPC$TL_inputNotifyUsers;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerSelf;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_inputPhotoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputTheme;
import ir.eitaa.tgnet.TLRPC$TL_inputThemeSettings;
import ir.eitaa.tgnet.TLRPC$TL_inputUser;
import ir.eitaa.tgnet.TLRPC$TL_inputUserEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputUserSelf;
import ir.eitaa.tgnet.TLRPC$TL_inputWallPaperNoFile;
import ir.eitaa.tgnet.TLRPC$TL_inputWallPaperSlug;
import ir.eitaa.tgnet.TLRPC$TL_liveStreamConfig;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser;
import ir.eitaa.tgnet.TLRPC$TL_messageActionChatEditPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messageService;
import ir.eitaa.tgnet.TLRPC$TL_messageViews;
import ir.eitaa.tgnet.TLRPC$TL_messages_addChatUser;
import ir.eitaa.tgnet.TLRPC$TL_messages_affectedHistory;
import ir.eitaa.tgnet.TLRPC$TL_messages_affectedMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_chatFull;
import ir.eitaa.tgnet.TLRPC$TL_messages_chats;
import ir.eitaa.tgnet.TLRPC$TL_messages_createChat;
import ir.eitaa.tgnet.TLRPC$TL_messages_deleteChat;
import ir.eitaa.tgnet.TLRPC$TL_messages_deleteChatUser;
import ir.eitaa.tgnet.TLRPC$TL_messages_dialogs;
import ir.eitaa.tgnet.TLRPC$TL_messages_dialogsSlice;
import ir.eitaa.tgnet.TLRPC$TL_messages_editChatAbout;
import ir.eitaa.tgnet.TLRPC$TL_messages_editChatAdmin;
import ir.eitaa.tgnet.TLRPC$TL_messages_editChatDefaultBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_messages_editChatPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messages_editChatTitle;
import ir.eitaa.tgnet.TLRPC$TL_messages_getChats;
import ir.eitaa.tgnet.TLRPC$TL_messages_getDialogs;
import ir.eitaa.tgnet.TLRPC$TL_messages_getHistory;
import ir.eitaa.tgnet.TLRPC$TL_messages_getMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_getMessagesViews;
import ir.eitaa.tgnet.TLRPC$TL_messages_getOnlines;
import ir.eitaa.tgnet.TLRPC$TL_messages_getPeerDialogs;
import ir.eitaa.tgnet.TLRPC$TL_messages_getPeerSettings;
import ir.eitaa.tgnet.TLRPC$TL_messages_getPinnedDialogs;
import ir.eitaa.tgnet.TLRPC$TL_messages_getPollResults;
import ir.eitaa.tgnet.TLRPC$TL_messages_getReplies;
import ir.eitaa.tgnet.TLRPC$TL_messages_getScheduledHistory;
import ir.eitaa.tgnet.TLRPC$TL_messages_getUnreadMentions;
import ir.eitaa.tgnet.TLRPC$TL_messages_getWebPagePreview;
import ir.eitaa.tgnet.TLRPC$TL_messages_hidePeerSettingsBar;
import ir.eitaa.tgnet.TLRPC$TL_messages_markDialogUnread;
import ir.eitaa.tgnet.TLRPC$TL_messages_messageViews;
import ir.eitaa.tgnet.TLRPC$TL_messages_messages;
import ir.eitaa.tgnet.TLRPC$TL_messages_messagesNotModified;
import ir.eitaa.tgnet.TLRPC$TL_messages_migrateChat;
import ir.eitaa.tgnet.TLRPC$TL_messages_peerDialogs;
import ir.eitaa.tgnet.TLRPC$TL_messages_readDiscussion;
import ir.eitaa.tgnet.TLRPC$TL_messages_readEncryptedHistory;
import ir.eitaa.tgnet.TLRPC$TL_messages_readHistory;
import ir.eitaa.tgnet.TLRPC$TL_messages_readMentions;
import ir.eitaa.tgnet.TLRPC$TL_messages_readMessageContents;
import ir.eitaa.tgnet.TLRPC$TL_messages_reorderPinnedDialogs;
import ir.eitaa.tgnet.TLRPC$TL_messages_reportEncryptedSpam;
import ir.eitaa.tgnet.TLRPC$TL_messages_reportSpam;
import ir.eitaa.tgnet.TLRPC$TL_messages_saveGif;
import ir.eitaa.tgnet.TLRPC$TL_messages_saveRecentSticker;
import ir.eitaa.tgnet.TLRPC$TL_messages_search;
import ir.eitaa.tgnet.TLRPC$TL_messages_setEncryptedTyping;
import ir.eitaa.tgnet.TLRPC$TL_messages_setHistoryTTL;
import ir.eitaa.tgnet.TLRPC$TL_messages_setTyping;
import ir.eitaa.tgnet.TLRPC$TL_messages_sponsoredMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_startBot;
import ir.eitaa.tgnet.TLRPC$TL_messages_toggleDialogPin;
import ir.eitaa.tgnet.TLRPC$TL_messages_unpinAllMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_updatePinnedMessage;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings;
import ir.eitaa.tgnet.TLRPC$TL_peerSettings;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_phone_getGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_groupCall;
import ir.eitaa.tgnet.TLRPC$TL_photo;
import ir.eitaa.tgnet.TLRPC$TL_photoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_photos_deletePhotos;
import ir.eitaa.tgnet.TLRPC$TL_photos_getUserPhotos;
import ir.eitaa.tgnet.TLRPC$TL_photos_photo;
import ir.eitaa.tgnet.TLRPC$TL_photos_photos;
import ir.eitaa.tgnet.TLRPC$TL_photos_updateProfilePhoto;
import ir.eitaa.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import ir.eitaa.tgnet.TLRPC$TL_report_getReasons;
import ir.eitaa.tgnet.TLRPC$TL_report_reason;
import ir.eitaa.tgnet.TLRPC$TL_restrictionReason;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageCancelAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageChooseContactAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageChooseStickerAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageEmojiInteraction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageEmojiInteractionSeen;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageGamePlayAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageGeoLocationAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageRecordAudioAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageRecordRoundAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageRecordVideoAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageTypingAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageUploadAudioAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageUploadDocumentAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageUploadPhotoAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageUploadRoundAction;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageUploadVideoAction;
import ir.eitaa.tgnet.TLRPC$TL_sponsoredMessage;
import ir.eitaa.tgnet.TLRPC$TL_stat_ad;
import ir.eitaa.tgnet.TLRPC$TL_stat_reportAdActionPerformed;
import ir.eitaa.tgnet.TLRPC$TL_stat_reportAdView;
import ir.eitaa.tgnet.TLRPC$TL_stat_reportShopTileView;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.tgnet.TLRPC$TL_updateChannel;
import ir.eitaa.tgnet.TLRPC$TL_updateChannelAvailableMessages;
import ir.eitaa.tgnet.TLRPC$TL_updateChannelMessageForwards;
import ir.eitaa.tgnet.TLRPC$TL_updateChannelMessageViews;
import ir.eitaa.tgnet.TLRPC$TL_updateChannelReadMessagesContents;
import ir.eitaa.tgnet.TLRPC$TL_updateChannelTooLong;
import ir.eitaa.tgnet.TLRPC$TL_updateChannelUserTyping;
import ir.eitaa.tgnet.TLRPC$TL_updateChannelWebPage;
import ir.eitaa.tgnet.TLRPC$TL_updateChatUserTyping;
import ir.eitaa.tgnet.TLRPC$TL_updateDeleteChannelMessages;
import ir.eitaa.tgnet.TLRPC$TL_updateDeleteMessages;
import ir.eitaa.tgnet.TLRPC$TL_updateEditChannelMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateEditMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateFolderPeers;
import ir.eitaa.tgnet.TLRPC$TL_updateLangPack;
import ir.eitaa.tgnet.TLRPC$TL_updateMessageID;
import ir.eitaa.tgnet.TLRPC$TL_updateMessagePoll;
import ir.eitaa.tgnet.TLRPC$TL_updateNewChannelMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateNewEncryptedMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateNewMessage;
import ir.eitaa.tgnet.TLRPC$TL_updatePeerBlocked;
import ir.eitaa.tgnet.TLRPC$TL_updatePinnedChannelMessages;
import ir.eitaa.tgnet.TLRPC$TL_updatePinnedMessages;
import ir.eitaa.tgnet.TLRPC$TL_updateReadChannelDiscussionInbox;
import ir.eitaa.tgnet.TLRPC$TL_updateReadChannelDiscussionOutbox;
import ir.eitaa.tgnet.TLRPC$TL_updateReadChannelInbox;
import ir.eitaa.tgnet.TLRPC$TL_updateReadChannelOutbox;
import ir.eitaa.tgnet.TLRPC$TL_updateReadHistoryInbox;
import ir.eitaa.tgnet.TLRPC$TL_updateReadHistoryOutbox;
import ir.eitaa.tgnet.TLRPC$TL_updateReadMessagesContents;
import ir.eitaa.tgnet.TLRPC$TL_updateServiceNotification;
import ir.eitaa.tgnet.TLRPC$TL_updateUserTyping;
import ir.eitaa.tgnet.TLRPC$TL_updateWebPage;
import ir.eitaa.tgnet.TLRPC$TL_updatesCombined;
import ir.eitaa.tgnet.TLRPC$TL_updates_differenceSlice;
import ir.eitaa.tgnet.TLRPC$TL_updates_differenceTooLong;
import ir.eitaa.tgnet.TLRPC$TL_updates_getDifference;
import ir.eitaa.tgnet.TLRPC$TL_updates_state;
import ir.eitaa.tgnet.TLRPC$TL_userForeign_old2;
import ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto;
import ir.eitaa.tgnet.TLRPC$TL_userProfilePhotoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_users_getFullUser;
import ir.eitaa.tgnet.TLRPC$TL_users_getUsers;
import ir.eitaa.tgnet.TLRPC$TL_wallPaperSettings;
import ir.eitaa.tgnet.TLRPC$TL_webPage;
import ir.eitaa.tgnet.TLRPC$TL_webPageEmpty;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.tgnet.TLRPC$WallPaper;
import ir.eitaa.tgnet.TLRPC$WallPaperSettings;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.tgnet.TLRPC$contacts_Blocked;
import ir.eitaa.tgnet.TLRPC$messages_Dialogs;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.tgnet.TLRPC$photos_Photos;
import ir.eitaa.tgnet.TLRPC$updates_ChannelDifference;
import ir.eitaa.tgnet.TLRPC$updates_Difference;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.MediaChannelActivity;
import ir.eitaa.ui.ProfileActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class MessagesController extends BaseController implements NotificationCenter.NotificationCenterDelegate {
    public static int DIALOG_FILTER_FLAG_ADMIN = 512;
    public static int DIALOG_FILTER_FLAG_BOTS = 16;
    public static int DIALOG_FILTER_FLAG_CHANNELS = 8;
    public static int DIALOG_FILTER_FLAG_CONTACTS = 1;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED = 128;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_MUTED = 32;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_READ = 64;
    public static int DIALOG_FILTER_FLAG_FAVORITE = 1024;
    public static int DIALOG_FILTER_FLAG_GROUPS = 4;
    public static int DIALOG_FILTER_FLAG_MEDIA_CHANNEL = 2048;
    public static int DIALOG_FILTER_FLAG_NON_CONTACTS = 2;
    public static int DIALOG_FILTER_FLAG_ONLY_ARCHIVED = 256;
    public static int PROMO_TYPE_OTHER = 2;
    public static int PROMO_TYPE_PROXY = 0;
    public static int PROMO_TYPE_PSA = 1;
    public static int UPDATE_MASK_AVATAR = 2;
    public static int UPDATE_MASK_CHAT = 8192;
    public static int UPDATE_MASK_CHAT_AVATAR = 8;
    public static int UPDATE_MASK_CHAT_MEMBERS = 32;
    public static int UPDATE_MASK_CHAT_NAME = 16;
    public static int UPDATE_MASK_CHECK = 65536;
    public static int UPDATE_MASK_EMOJI_INTERACTIONS = 262144;
    public static int UPDATE_MASK_MESSAGE_TEXT = 32768;
    public static int UPDATE_MASK_NAME = 1;
    public static int UPDATE_MASK_NEW_MESSAGE = 2048;
    public static int UPDATE_MASK_PHONE = 1024;
    public static int UPDATE_MASK_READ_DIALOG_MESSAGE = 256;
    public static int UPDATE_MASK_REORDER = 131072;
    public static int UPDATE_MASK_SELECT_DIALOG = 512;
    public static int UPDATE_MASK_SEND_STATE = 4096;
    public static int UPDATE_MASK_STATUS = 4;
    public static int UPDATE_MASK_USER_PHONE = 128;
    public static int UPDATE_MASK_USER_PRINT = 64;
    private static volatile long lastPasswordCheckTime;
    private static volatile long lastThemeCheckTime;
    private int DIALOGS_LOAD_TYPE_CACHE;
    private int DIALOGS_LOAD_TYPE_CHANNEL;
    private int DIALOGS_LOAD_TYPE_UNKNOWN;
    private HashMap<Long, TLRPC$Chat> activeVoiceChatsMap;
    private ArrayList<TLRPC$TL_stat_ad> adActionsToSend;
    private ArrayList<TLRPC$TL_stat_ad> adViewsToSend;
    protected ArrayList<TLRPC$Dialog> allDialogs;
    public float animatedEmojisZoom;
    public String appURL;
    public Set<String> authDomains;
    public boolean autoarchiveAvailable;
    public Set<String> autologinDomains;
    public String autologinToken;
    public int availableMapProviders;
    public boolean backgroundConnection;
    public LongSparseIntArray blockePeers;
    public boolean blockedCountry;
    public boolean blockedEndReached;
    public int callConnectTimeout;
    public boolean callOutEnabled;
    public int callPacketTimeout;
    public int callReceiveTimeout;
    public int callRingTimeout;
    public boolean callsEnabled;
    public boolean canRevokePmInbox;
    private LongSparseArray<LongSparseArray<TLRPC$ChannelParticipant>> channelAdmins;
    private LongSparseArray<ArrayList<Long>> channelViewsToSend;
    private LongSparseIntArray channelsPts;
    private ConcurrentHashMap<Long, TLRPC$Chat> chats;
    private boolean checkingDialogAd;
    private LongSparseArray<Boolean> checkingLastMessagesDialogs;
    private boolean checkingPromoInfo;
    private int checkingPromoInfoRequestId;
    private boolean checkingTosUpdate;
    private LongSparseArray<TLRPC$Dialog> clearingHistoryDialogs;
    private ArrayList<Long> createdDialogIds;
    private ArrayList<Long> createdDialogMainThreadIds;
    private ArrayList<Long> createdScheduledDialogIds;
    private Runnable currentDeleteTaskRunnable;
    private LongSparseArray<ArrayList<Integer>> currentDeletingTaskMediaMids;
    private LongSparseArray<ArrayList<Integer>> currentDeletingTaskMids;
    private int currentDeletingTaskTime;
    public String currentThemeType;
    public String dcDomainName;
    public LongSparseIntArray deletedHistory;
    private LongSparseArray<TLRPC$Dialog> deletingDialogs;
    public TLRPC$TL_ads_dialogAd dialogAd;
    private Comparator<TLRPC$Dialog> dialogComparator;
    private Comparator<TLRPC$Dialog> dialogDateComparator;
    public ArrayList<DialogFilter> dialogFilters;
    public SparseArray<DialogFilter> dialogFiltersById;
    public boolean dialogFiltersLoaded;
    public LongSparseArray<MessageObject> dialogMessage;
    public SparseArray<MessageObject> dialogMessagesByIds;
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
    public ArrayList<TLRPC$TL_dialog> dialogsMediaChannels;
    public ArrayList<TLRPC$Dialog> dialogsServerOnly;
    public ArrayList<TLRPC$Dialog> dialogsUsersOnly;
    public LongSparseArray<TLRPC$Dialog> dialogs_dict;
    public ConcurrentHashMap<Long, Integer> dialogs_read_inbox_max;
    public ConcurrentHashMap<Long, Integer> dialogs_read_outbox_max;
    public HashSet<String> diceEmojies;
    public HashMap<String, DiceFrameSuccess> diceSuccess;
    public int downloadChunkSize_KB;
    public HashMap<Long, ArrayList<TLRPC$TL_sendMessageEmojiInteraction>> emojiInteractions;
    private SharedPreferences emojiPreferences;
    public HashMap<String, EmojiSound> emojiSounds;
    public boolean enableJoined;
    private ConcurrentHashMap<Integer, TLRPC$EncryptedChat> encryptedChats;
    public boolean exploreEnabled;
    public Set<String> exportGroupUri;
    public Set<String> exportPrivateUri;
    public Set<String> exportUri;
    private LongSparseArray<TLRPC$TL_chatInviteExported> exportedChats;
    public ArrayList<FaqSearchResult> faqSearchArray;
    public TLRPC$WebPage faqWebPage;
    public SharedPreferences favoritesPreferences;
    public boolean filtersEnabled;
    public boolean firstGettingTask;
    public boolean foregroundConnection;
    private LongSparseArray<TLRPC$ChatFull> fullChats;
    private LongSparseArray<TLRPC$UserFull> fullUsers;
    private boolean getDifferenceFirstSync;
    private boolean gettingAppChangelog;
    private LongSparseArray<Boolean> gettingChatInviters;
    public boolean gettingDifference;
    private LongSparseArray<Boolean> gettingDifferenceChannels;
    private boolean gettingNewDeleteTask;
    private LongSparseArray<Boolean> gettingUnknownChannels;
    private LongSparseArray<Boolean> gettingUnknownDialogs;
    public String gifSearchBot;
    public ArrayList<String> gifSearchEmojies;
    public int groipCallVideoMaxParticipants;
    private LongSparseArray<ChatObject.Call> groupCalls;
    private LongSparseArray<ChatObject.Call> groupCallsByChatId;
    public ArrayList<TLRPC$RecentMeUrl> hintDialogs;
    public volatile boolean ignoreSetOnline;
    public String imageSearchBot;
    private String installReferer;
    private boolean isLeftPromoChannel;
    public boolean isUrlWhiteListLoaded;
    private ArrayList<Long> joiningToChannels;
    public boolean keepAliveService;
    private long lastAdViewsCheckTime;
    private int lastCheckPromoId;
    private int lastPrintingStringCount;
    private long lastPushRegisterSendTime;
    private int lastReportReasonCheckTime;
    private LongSparseArray<Long> lastScheduledServerQueryTime;
    private LongSparseArray<Long> lastServerQueryTime;
    private long lastStatusUpdateTime;
    private int lastTempCacheCheckTime;
    private long lastViewsCheckTime;
    public String linkPrefix;
    public long liveDialogId;
    public int liveDialogMsgId;
    public long liveStreamAccessHash;
    public TLRPC$TL_liveStreamConfig liveStreamConfig;
    public long liveStreamId;
    public ConcurrentHashMap<Integer, TLRPC$Chat> livechats;
    private android.util.LongSparseArray<SparseArray<MessageObject>> livesToCheck;
    private int livesToCheckSize;
    private ArrayList<Long> loadedFullChats;
    private ArrayList<Long> loadedFullParticipants;
    private ArrayList<Long> loadedFullUsers;
    private boolean loadingAppConfig;
    public boolean loadingBlockedPeers;
    private LongSparseIntArray loadingChannelAdmins;
    private SparseBooleanArray loadingDialogs;
    private ArrayList<Long> loadingFullChats;
    private ArrayList<Long> loadingFullParticipants;
    private ArrayList<Long> loadingFullUsers;
    private ArrayList<Long> loadingGroupCalls;
    private int loadingNotificationSettings;
    private boolean loadingNotificationSignUpSettings;
    private LongSparseArray<Boolean> loadingPeerSettings;
    private SparseIntArray loadingPinnedDialogs;
    private boolean loadingRemoteFilters;
    private boolean loadingSuggestedFilters;
    private boolean loadingUnreadDialogs;
    public ArrayList<Long> lockedDialogsId;
    private SharedPreferences mainPreferences;
    public String mapHostUrl;
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
    public boolean mxbEnabled;
    private LongSparseArray<ArrayList<Integer>> needShortPollChannels;
    private LongSparseArray<ArrayList<Integer>> needShortPollOnlines;
    private int nextDialogAdCheckTime;
    private SparseIntArray nextDialogsCacheOffset;
    private int nextPromoInfoCheckTime;
    private int nextTosCheckTime;
    private SharedPreferences notificationsPreferences;
    private ConcurrentHashMap<String, TLObject> objectsByUsernames;
    private boolean offlineSent;
    public ConcurrentHashMap<Long, Integer> onlinePrivacy;
    private Runnable passwordCheckRunnable;
    public boolean payEnabled;
    public String payHost;
    public Set<String> pendingSuggestions;
    private LongSparseArray<SparseArray<MessageObject>> pollsToCheck;
    private int pollsToCheckSize;
    public boolean preloadFeaturedStickers;
    public LongSparseArray<SparseArray<CharSequence>> printingStrings;
    public LongSparseArray<SparseArray<Integer>> printingStringsTypes;
    public ConcurrentHashMap<Long, ConcurrentHashMap<Integer, ArrayList<PrintingUser>>> printingUsers;
    private TLRPC$Dialog promoDialog;
    private long promoDialogId;
    public int promoDialogType;
    public String promoPsaMessage;
    public String promoPsaType;
    private String proxyDialogAddress;
    public boolean proxyDisableJoin;
    public boolean proxyRemoveAfterSeen;
    private boolean proxyShowInAllTabs;
    public boolean proxyStayPinAfterJoin;
    public boolean qrLoginCamera;
    public int ratingDecay;
    private ArrayList<ReadTask> readTasks;
    private LongSparseArray<ReadTask> readTasksMap;
    public long recommendCacheClearTime;
    public int recommendCacheIndex;
    public ArrayList<TLRPC$Message> recommendCacheMessages;
    public int recommendCacheSeed;
    public boolean recommendEnabled;
    public boolean registeringForPush;
    private LongSparseArray<ArrayList<Integer>> reloadingMessages;
    private HashMap<String, ArrayList<MessageObject>> reloadingScheduledWebpages;
    private LongSparseArray<ArrayList<MessageObject>> reloadingScheduledWebpagesPending;
    private HashMap<String, ArrayList<MessageObject>> reloadingWebpages;
    private LongSparseArray<ArrayList<MessageObject>> reloadingWebpagesPending;
    private ArrayList<ReadTask> repliesReadTasks;
    public ArrayList<TLRPC$TL_report_reason> reportReasons;
    public boolean reportVersion;
    public int reportedDialogAdId;
    private TLRPC$messages_Dialogs resetDialogsAll;
    private TLRPC$TL_messages_peerDialogs resetDialogsPinned;
    private boolean resetingDialogs;
    public int revokeTimeLimit;
    public int revokeTimePmLimit;
    public int roundAudioBitrate;
    public int roundVideoBitrate;
    public int roundVideoSize;
    public boolean saveGifsWithStickers;
    public int schedule_period_background_delay_ms;
    public int schedule_period_background_ms;
    public int schedule_period_forground_ms;
    public int secretWebpagePreview;
    public DialogFilter[] selectedDialogFilter;
    public LongSparseArray<SparseArray<Boolean>>[] sendingTypings;
    private SparseBooleanArray serverDialogsEndReached;
    public boolean shopEnabled;
    private ArrayList<TLRPC$TL_Stat_ShopTile> shopTileViewsToSend;
    private LongSparseIntArray shortPollChannels;
    private LongSparseIntArray shortPollOnlines;
    public boolean showFiltersTooltip;
    public String socketURL;
    private DialogFilter sortingDialogFilter;
    private LongSparseArray<SponsoredMessagesInfo> sponsoredMessages;
    private int statusRequest;
    private int statusSettingState;
    public boolean suggestContacts;
    public boolean suggestStickersApiOnly;
    public ArrayList<TLRPC$TL_dialogFilterSuggested> suggestedFilters;
    public String suggestedLangCode;
    private Runnable themeCheckRunnable;
    private HashMap<String, ReadTask> threadsReadTasksMap;
    public int totalBlockedCount;
    public int unreadUnmutedDialogs;
    public int updateCheckDelay;
    public boolean update_available;
    private Comparator<TLRPC$Update> updatesComparator;
    private LongSparseArray<ArrayList<TLRPC$Updates>> updatesQueueChannels;
    private ArrayList<TLRPC$Updates> updatesQueuePts;
    private ArrayList<TLRPC$Updates> updatesQueueQts;
    private ArrayList<TLRPC$Updates> updatesQueueSeq;
    private LongSparseLongArray updatesStartWaitTimeChannels;
    private long updatesStartWaitTimePts;
    private long updatesStartWaitTimeQts;
    private long updatesStartWaitTimeSeq;
    public boolean updatingState;
    public int uploadChunkSize_KB;
    private String uploadingAvatar;
    private HashMap<String, Object> uploadingThemes;
    private String uploadingWallpaper;
    private Theme.OverrideWallpaperInfo uploadingWallpaperInfo;
    private ArrayList<String> urlWhiteList;
    private ConcurrentHashMap<Long, TLRPC$User> users;
    public String venueSearchBot;
    private ArrayList<Long> visibleDialogMainThreadIds;
    private ArrayList<Long> visibleScheduledDialogMainThreadIds;
    public int webFileDatacenterId;
    public String youtubePipType;
    public static int UPDATE_MASK_ALL = ((((((((2 | 4) | 1) | 8) | 16) | 32) | 64) | 128) | Factory.DEVICE_HAS_CRAPPY_OPENSLES) | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV;
    public static int DIALOG_FILTER_FLAG_ALL_CHATS = (((((1 | 2) | 4) | 8) | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) | Factory.DEVICE_USE_ANDROID_CAMCORDER;
    private static volatile MessagesController[] Instance = new MessagesController[3];

    public interface MessagesLoadedCallback {
        void onError();

        void onMessagesLoaded(boolean fromCache);
    }

    public static class PrintingUser {
        public TLRPC$SendMessageAction action;
        public long lastTime;
        public long userId;
    }

    static /* synthetic */ void lambda$blockPeer$62(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$completeReadTask$199(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$completeReadTask$201(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$deleteParticipantFromChat$241(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$deleteUserPhoto$83(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$hidePeerSettingsBar$47(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$hidePromoDialog$97(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$installTheme$85(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$installTheme$86(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$markMentionMessageAsRead$195(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$markMentionsAsRead$203(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$markMessageContentAsRead$193(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$processUpdates$302(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$removeSuggestion$16(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$reportSpam$48(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$reportSpam$49(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$reportSpam$50(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$unblockPeer$78(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$unregistedPush$247(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$updateTimerProc$115(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$updateTimerProc$116(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$updateTimerProc$117(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public void loadSignUpNotificationsSettings() {
    }

    public void saveTheme(Theme.ThemeInfo themeInfo, Theme.ThemeAccent accent, boolean night, boolean unsave) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$MessagesController() {
        getUserConfig().checkSavedPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SponsoredMessagesInfo {
        private long loadTime;
        private boolean loading;
        private ArrayList<MessageObject> messages;

        private SponsoredMessagesInfo() {
        }
    }

    public static class FaqSearchResult {
        public int num;
        public String[] path;
        public String title;
        public String url;

        public FaqSearchResult(String t, String[] p, String u) {
            this.title = t;
            this.path = p;
            this.url = u;
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

    public static class EmojiSound {
        public long accessHash;
        public byte[] fileReference;
        public long id;

        public EmojiSound(long i, long ah, String fr) {
            this.id = i;
            this.accessHash = ah;
            this.fileReference = Base64.decode(fr, 8);
        }

        public EmojiSound(long i, long ah, byte[] fr) {
            this.id = i;
            this.accessHash = ah;
            this.fileReference = fr;
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

    public static class DiceFrameSuccess {
        public int frame;
        public int num;

        public DiceFrameSuccess(int f, int n) {
            this.frame = f;
            this.num = n;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DiceFrameSuccess)) {
                return false;
            }
            DiceFrameSuccess diceFrameSuccess = (DiceFrameSuccess) obj;
            return this.frame == diceFrameSuccess.frame && this.num == diceFrameSuccess.num;
        }
    }

    private static class UserActionUpdatesSeq extends TLRPC$Updates {
        private UserActionUpdatesSeq() {
        }
    }

    private static class UserActionUpdatesPts extends TLRPC$Updates {
        private UserActionUpdatesPts() {
        }
    }

    private static class ReadTask {
        public long dialogId;
        public int maxDate;
        public int maxId;
        public long replyId;
        public long sendRequestTime;

        private ReadTask() {
        }
    }

    public static class DialogFilter {
        private static int dialogFilterPointer = 10;
        public int flags;
        public int id;
        public int localId;
        public String name;
        public int order;
        public volatile int pendingUnreadCount;
        public int unreadCount;
        public ArrayList<Long> alwaysShow = new ArrayList<>();
        public ArrayList<Long> neverShow = new ArrayList<>();
        public LongSparseIntArray pinnedDialogs = new LongSparseIntArray();
        public ArrayList<TLRPC$Dialog> dialogs = new ArrayList<>();

        public DialogFilter() {
            int i = dialogFilterPointer;
            dialogFilterPointer = i + 1;
            this.localId = i;
        }

        public boolean includesDialog(AccountInstance accountInstance, long dialogId) {
            TLRPC$Dialog tLRPC$Dialog = accountInstance.getMessagesController().dialogs_dict.get(dialogId);
            if (tLRPC$Dialog == null) {
                return false;
            }
            return includesDialog(accountInstance, dialogId, tLRPC$Dialog);
        }

        public boolean includesDialog(AccountInstance accountInstance, long dialogId, TLRPC$Dialog d) {
            TLRPC$Chat chat;
            if (this.neverShow.contains(Long.valueOf(dialogId))) {
                return false;
            }
            if (this.alwaysShow.contains(Long.valueOf(dialogId))) {
                return true;
            }
            if (d.folder_id != 0 && (this.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED) != 0) {
                return false;
            }
            MessagesController messagesController = accountInstance.getMessagesController();
            ContactsController contactsController = accountInstance.getContactsController();
            if (((this.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED) != 0 && messagesController.isDialogMuted(d.id) && d.unread_mentions_count == 0) || ((this.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0 && d.unread_count == 0 && !d.unread_mark && d.unread_mentions_count == 0)) {
                return false;
            }
            if (dialogId > 0) {
                TLRPC$User user = messagesController.getUser(Long.valueOf(dialogId));
                if (user != null) {
                    ArrayList<Long> arrayList = new ArrayList<>();
                    arrayList.add(Long.valueOf(dialogId));
                    if (MessagesController.getInstance(UserConfig.selectedAccount).isDialogFavorite(arrayList) && (this.flags & MessagesController.DIALOG_FILTER_FLAG_FAVORITE) != 0) {
                        return true;
                    }
                    if (!user.bot) {
                        if (user.self || user.contact || contactsController.isContact(dialogId)) {
                            if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_CONTACTS) != 0) {
                                return true;
                            }
                        } else if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS) != 0) {
                            return true;
                        }
                    } else if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_BOTS) != 0) {
                        return true;
                    }
                }
            } else if (dialogId < 0 && (chat = messagesController.getChat(Long.valueOf(-dialogId))) != null) {
                ArrayList<Long> arrayList2 = new ArrayList<>();
                arrayList2.add(Long.valueOf(dialogId));
                if (MessagesController.getInstance(UserConfig.selectedAccount).isDialogFavorite(arrayList2) && (this.flags & MessagesController.DIALOG_FILTER_FLAG_FAVORITE) != 0) {
                    return true;
                }
                if ((chat.creator || chat.admin_rights != null) && (this.flags & MessagesController.DIALOG_FILTER_FLAG_ADMIN) != 0) {
                    return true;
                }
                if (ChatObject.isChannel(chat) && !chat.megagroup) {
                    int i = this.flags;
                    if ((MessagesController.DIALOG_FILTER_FLAG_CHANNELS & i) != 0) {
                        return true;
                    }
                    if ((i & MessagesController.DIALOG_FILTER_FLAG_MEDIA_CHANNEL) != 0 && chat.isMediaContent) {
                        return true;
                    }
                } else if ((this.flags & MessagesController.DIALOG_FILTER_FLAG_GROUPS) != 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean alwaysShow(int currentAccount, TLRPC$Dialog dialog) {
            TLRPC$EncryptedChat encryptedChat;
            if (dialog == null) {
                return false;
            }
            long j = dialog.id;
            if (DialogObject.isEncryptedDialog(j) && (encryptedChat = MessagesController.getInstance(currentAccount).getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(j)))) != null) {
                j = encryptedChat.user_id;
            }
            return this.alwaysShow.contains(Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$new$1$MessagesController(TLRPC$Dialog tLRPC$Dialog, TLRPC$Dialog tLRPC$Dialog2) {
        int i = this.sortingDialogFilter.pinnedDialogs.get(tLRPC$Dialog.id, Integer.MIN_VALUE);
        int i2 = this.sortingDialogFilter.pinnedDialogs.get(tLRPC$Dialog2.id, Integer.MIN_VALUE);
        boolean z = tLRPC$Dialog instanceof TLRPC$TL_dialogFolder;
        if (z && !(tLRPC$Dialog2 instanceof TLRPC$TL_dialogFolder)) {
            return -1;
        }
        if (!z && (tLRPC$Dialog2 instanceof TLRPC$TL_dialogFolder)) {
            return 1;
        }
        if (i == Integer.MIN_VALUE && i2 != Integer.MIN_VALUE) {
            return 1;
        }
        if (i != Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
            return -1;
        }
        if (i != Integer.MIN_VALUE) {
            if (i > i2) {
                return 1;
            }
            return i < i2 ? -1 : 0;
        }
        MediaDataController mediaDataController = getMediaDataController();
        long lastMessageOrDraftDate = DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog, mediaDataController.getDraft(tLRPC$Dialog.id, 0));
        long lastMessageOrDraftDate2 = DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog2, mediaDataController.getDraft(tLRPC$Dialog2.id, 0));
        if (lastMessageOrDraftDate < lastMessageOrDraftDate2) {
            return 1;
        }
        return lastMessageOrDraftDate > lastMessageOrDraftDate2 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$new$2$MessagesController(TLRPC$Dialog tLRPC$Dialog, TLRPC$Dialog tLRPC$Dialog2) {
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
            int i = tLRPC$Dialog.pinnedNum;
            int i2 = tLRPC$Dialog2.pinnedNum;
            if (i < i2) {
                return 1;
            }
            return i > i2 ? -1 : 0;
        }
        MediaDataController mediaDataController = getMediaDataController();
        long lastMessageOrDraftDate = DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog, mediaDataController.getDraft(tLRPC$Dialog.id, 0));
        long lastMessageOrDraftDate2 = DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog2, mediaDataController.getDraft(tLRPC$Dialog2.id, 0));
        if (lastMessageOrDraftDate < lastMessageOrDraftDate2) {
            return 1;
        }
        return lastMessageOrDraftDate > lastMessageOrDraftDate2 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$new$3$MessagesController(TLRPC$Update tLRPC$Update, TLRPC$Update tLRPC$Update2) {
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
        long updateChannelId = getUpdateChannelId(tLRPC$Update);
        long updateChannelId2 = getUpdateChannelId(tLRPC$Update2);
        if (updateChannelId == updateChannelId2) {
            return AndroidUtilities.compare(getUpdatePts(tLRPC$Update), getUpdatePts(tLRPC$Update2));
        }
        return AndroidUtilities.compare(updateChannelId, updateChannelId2);
    }

    public static MessagesController getInstance(int num) {
        MessagesController messagesController = Instance[num];
        if (messagesController == null) {
            synchronized (MessagesController.class) {
                messagesController = Instance[num];
                if (messagesController == null) {
                    MessagesController[] messagesControllerArr = Instance;
                    MessagesController messagesController2 = new MessagesController(num);
                    messagesControllerArr[num] = messagesController2;
                    messagesController = messagesController2;
                }
            }
        }
        return messagesController;
    }

    public static SharedPreferences getNotificationsSettings(int account) {
        return getInstance(account).notificationsPreferences;
    }

    public static SharedPreferences getGlobalNotificationsSettings() {
        return getInstance(0).notificationsPreferences;
    }

    public static SharedPreferences getMainSettings(int account) {
        return getInstance(account).mainPreferences;
    }

    public static SharedPreferences getGlobalMainSettings() {
        return getInstance(0).mainPreferences;
    }

    public static SharedPreferences getEmojiSettings(int account) {
        return getInstance(account).emojiPreferences;
    }

    public static SharedPreferences getGlobalEmojiSettings() {
        return getInstance(0).emojiPreferences;
    }

    public MessagesController(int num) {
        super(num);
        this.chats = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.encryptedChats = new ConcurrentHashMap<>(10, 1.0f, 2);
        this.users = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.objectsByUsernames = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.activeVoiceChatsMap = new HashMap<>();
        this.joiningToChannels = new ArrayList<>();
        this.exportedChats = new LongSparseArray<>();
        this.dialogAd = null;
        this.hintDialogs = new ArrayList<>();
        this.lockedDialogsId = new ArrayList<>();
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
        this.deletedHistory = new LongSparseIntArray();
        this.dialogMessagesByIds = new SparseArray<>();
        this.printingUsers = new ConcurrentHashMap<>(20, 1.0f, 2);
        this.printingStrings = new LongSparseArray<>();
        this.printingStringsTypes = new LongSparseArray<>();
        this.sendingTypings = new LongSparseArray[12];
        this.onlinePrivacy = new ConcurrentHashMap<>(20, 1.0f, 2);
        this.loadingPeerSettings = new LongSparseArray<>();
        this.createdDialogIds = new ArrayList<>();
        this.createdScheduledDialogIds = new ArrayList<>();
        this.createdDialogMainThreadIds = new ArrayList<>();
        this.visibleDialogMainThreadIds = new ArrayList<>();
        this.visibleScheduledDialogMainThreadIds = new ArrayList<>();
        this.shortPollChannels = new LongSparseIntArray();
        this.needShortPollChannels = new LongSparseArray<>();
        this.shortPollOnlines = new LongSparseIntArray();
        this.needShortPollOnlines = new LongSparseArray<>();
        this.deletingDialogs = new LongSparseArray<>();
        this.clearingHistoryDialogs = new LongSparseArray<>();
        this.loadingBlockedPeers = false;
        this.blockePeers = new LongSparseIntArray();
        this.totalBlockedCount = -1;
        this.channelViewsToSend = new LongSparseArray<>();
        this.pollsToCheck = new LongSparseArray<>();
        this.shopTileViewsToSend = new ArrayList<>();
        this.adViewsToSend = new ArrayList<>();
        this.adActionsToSend = new ArrayList<>();
        this.dialogFilters = new ArrayList<>();
        this.dialogFiltersById = new SparseArray<>();
        this.suggestedFilters = new ArrayList<>();
        this.updatesQueueChannels = new LongSparseArray<>();
        this.updatesStartWaitTimeChannels = new LongSparseLongArray();
        this.channelsPts = new LongSparseIntArray();
        this.gettingDifferenceChannels = new LongSparseArray<>();
        this.gettingChatInviters = new LongSparseArray<>();
        this.gettingUnknownChannels = new LongSparseArray<>();
        this.gettingUnknownDialogs = new LongSparseArray<>();
        this.checkingLastMessagesDialogs = new LongSparseArray<>();
        this.updatesQueueSeq = new ArrayList<>();
        this.updatesQueuePts = new ArrayList<>();
        this.updatesQueueQts = new ArrayList<>();
        this.fullUsers = new LongSparseArray<>();
        this.fullChats = new LongSparseArray<>();
        this.groupCalls = new LongSparseArray<>();
        this.groupCallsByChatId = new LongSparseArray<>();
        this.loadingFullUsers = new ArrayList<>();
        this.loadedFullUsers = new ArrayList<>();
        this.loadingFullChats = new ArrayList<>();
        this.loadingGroupCalls = new ArrayList<>();
        this.loadingFullParticipants = new ArrayList<>();
        this.loadedFullParticipants = new ArrayList<>();
        this.loadedFullChats = new ArrayList<>();
        this.channelAdmins = new LongSparseArray<>();
        this.loadingChannelAdmins = new LongSparseIntArray();
        this.migratedChats = new SparseIntArray();
        this.sponsoredMessages = new LongSparseArray<>();
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
        this.threadsReadTasksMap = new HashMap<>();
        this.nextDialogsCacheOffset = new SparseIntArray();
        this.loadingDialogs = new SparseBooleanArray();
        this.dialogsEndReached = new SparseBooleanArray();
        this.serverDialogsEndReached = new SparseBooleanArray();
        this.getDifferenceFirstSync = true;
        this.loadingPinnedDialogs = new SparseIntArray();
        this.faqSearchArray = new ArrayList<>();
        this.suggestContacts = true;
        this.themeCheckRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$CjpvJp3l2DdHlQZdDH24E06dqFQ
            @Override // java.lang.Runnable
            public final void run() {
                Theme.checkAutoNightThemeConditions();
            }
        };
        this.passwordCheckRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Lt5Kl2XXN8MmmBKqth2BVM7Q2Lw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$MessagesController();
            }
        };
        this.uploadingThemes = new HashMap<>();
        this.maxBroadcastCount = 100;
        this.minGroupConvertSize = 200;
        this.gifSearchEmojies = new ArrayList<>();
        this.diceSuccess = new HashMap<>();
        this.emojiSounds = new HashMap<>();
        this.emojiInteractions = new HashMap<>();
        this.livechats = new ConcurrentHashMap<>(100, 1.0f, 2);
        this.livesToCheck = new android.util.LongSparseArray<>();
        this.liveStreamConfig = new TLRPC$TL_liveStreamConfig();
        this.dialogsMediaChannels = new ArrayList<>();
        this.reportReasons = new ArrayList<>();
        this.shopEnabled = true;
        this.recommendEnabled = true;
        this.recommendCacheMessages = new ArrayList<>();
        this.urlWhiteList = new ArrayList<>();
        this.isUrlWhiteListLoaded = false;
        this.dialogDateComparator = new $$Lambda$MessagesController$00USao0G8cZjHUm7RkjNLWdFx8(this);
        this.dialogComparator = new $$Lambda$MessagesController$Xz1THjQgUgqk0eGoW_rynTXYT3Q(this);
        this.updatesComparator = new $$Lambda$MessagesController$p4wKvEjoE_hOoXaOxq7i0RiF_4I(this);
        this.DIALOGS_LOAD_TYPE_CACHE = 1;
        this.DIALOGS_LOAD_TYPE_CHANNEL = 2;
        this.DIALOGS_LOAD_TYPE_UNKNOWN = 3;
        this.currentAccount = num;
        ImageLoader.getInstance();
        getMessagesStorage();
        getLocationController();
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$d6WouMaREW9MPlQb1H_j23oBRp8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$4$MessagesController();
            }
        });
        addSupportUser();
        if (this.currentAccount == 0) {
            this.notificationsPreferences = ApplicationLoader.applicationContext.getSharedPreferences("Notifications", 0);
            this.mainPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
            this.emojiPreferences = ApplicationLoader.applicationContext.getSharedPreferences("emoji", 0);
            this.favoritesPreferences = ApplicationLoader.applicationContext.getSharedPreferences("Favorites", 0);
        } else {
            this.notificationsPreferences = ApplicationLoader.applicationContext.getSharedPreferences("Notifications" + this.currentAccount, 0);
            this.mainPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig" + this.currentAccount, 0);
            this.emojiPreferences = ApplicationLoader.applicationContext.getSharedPreferences("emoji" + this.currentAccount, 0);
            this.favoritesPreferences = ApplicationLoader.applicationContext.getSharedPreferences("Favorites" + this.currentAccount, 0);
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
        this.linkPrefix = this.mainPreferences.getString("linkPrefix", "eitaa.com");
        this.callReceiveTimeout = this.mainPreferences.getInt("callReceiveTimeout", 20000);
        this.callRingTimeout = this.mainPreferences.getInt("callRingTimeout", 90000);
        this.callConnectTimeout = this.mainPreferences.getInt("callConnectTimeout", 30000);
        this.callPacketTimeout = this.mainPreferences.getInt("callPacketTimeout", 10000);
        this.updateCheckDelay = this.mainPreferences.getInt("updateCheckDelay", 86400);
        this.maxPinnedDialogsCount = this.mainPreferences.getInt("maxPinnedDialogsCount", 5);
        this.maxFolderPinnedDialogsCount = this.mainPreferences.getInt("maxFolderPinnedDialogsCount", 100);
        this.maxMessageLength = this.mainPreferences.getInt("maxMessageLength", Factory.DEVICE_HAS_CRAPPY_AAUDIO);
        this.maxCaptionLength = this.mainPreferences.getInt("maxCaptionLength", 1404);
        this.mapProvider = this.mainPreferences.getInt("mapProvider", 0);
        this.availableMapProviders = this.mainPreferences.getInt("availableMapProviders", 3);
        this.mapHostUrl = this.mainPreferences.getString("pk", null);
        this.installReferer = this.mainPreferences.getString("installReferer", null);
        this.revokeTimeLimit = this.mainPreferences.getInt("revokeTimeLimit", 31536000);
        this.revokeTimePmLimit = this.mainPreferences.getInt("revokeTimePmLimit", 31536000);
        this.canRevokePmInbox = this.mainPreferences.getBoolean("canRevokePmInbox", false);
        this.preloadFeaturedStickers = this.mainPreferences.getBoolean("preloadFeaturedStickers", false);
        this.youtubePipType = this.mainPreferences.getString("youtubePipType", "disabled");
        this.keepAliveService = this.mainPreferences.getBoolean("keepAliveService", true);
        this.backgroundConnection = this.mainPreferences.getBoolean("keepAliveService", true);
        this.promoDialogId = this.mainPreferences.getLong("proxy_dialog", 0L);
        this.nextPromoInfoCheckTime = this.mainPreferences.getInt("nextPromoInfoCheckTime", 0);
        this.promoDialogType = this.mainPreferences.getInt("promo_dialog_type", 0);
        this.promoPsaMessage = this.mainPreferences.getString("promo_psa_message", null);
        this.promoPsaType = this.mainPreferences.getString("promo_psa_type", null);
        this.proxyDialogAddress = this.mainPreferences.getString("proxyDialogAddress", null);
        this.proxyStayPinAfterJoin = sharedPreferences.getBoolean("proxy_stay_pin_after_join", false);
        this.proxyShowInAllTabs = sharedPreferences.getBoolean("proxy_show_in_all_tabs", false);
        this.proxyRemoveAfterSeen = sharedPreferences.getBoolean("proxy_remove_after_seen", false);
        this.proxyDisableJoin = sharedPreferences.getBoolean("proxy_disable_join", false);
        this.nextTosCheckTime = this.notificationsPreferences.getInt("nextTosCheckTime", 0);
        this.venueSearchBot = this.mainPreferences.getString("venueSearchBot", "foursquare");
        this.gifSearchBot = this.mainPreferences.getString("gifSearchBot", "gif");
        this.imageSearchBot = this.mainPreferences.getString("imageSearchBot", "pic");
        this.blockedCountry = this.mainPreferences.getBoolean("blockedCountry", false);
        this.dcDomainName = this.mainPreferences.getString("dcDomainName2", ConnectionsManager.native_isTestBackend(this.currentAccount) != 0 ? "tapv3.stel.com" : "apv3.stel.com");
        this.webFileDatacenterId = this.mainPreferences.getInt("webFileDatacenterId", ConnectionsManager.native_isTestBackend(this.currentAccount) == 0 ? 4 : 2);
        this.suggestedLangCode = this.mainPreferences.getString("suggestedLangCode", "en");
        this.animatedEmojisZoom = this.mainPreferences.getFloat("animatedEmojisZoom", 0.625f);
        this.qrLoginCamera = this.mainPreferences.getBoolean("qrLoginCamera", false);
        this.saveGifsWithStickers = this.mainPreferences.getBoolean("saveGifsWithStickers", false);
        this.filtersEnabled = this.mainPreferences.getBoolean("filtersEnabled", false);
        this.showFiltersTooltip = this.mainPreferences.getBoolean("showFiltersTooltip", false);
        this.autoarchiveAvailable = this.mainPreferences.getBoolean("autoarchiveAvailable", false);
        this.groipCallVideoMaxParticipants = this.mainPreferences.getInt("groipCallVideoMaxParticipants", 30);
        this.suggestStickersApiOnly = this.mainPreferences.getBoolean("suggestStickersApiOnly", false);
        this.roundVideoSize = this.mainPreferences.getInt("roundVideoSize", 384);
        this.roundVideoBitrate = this.mainPreferences.getInt("roundVideoBitrate", 1000);
        this.roundAudioBitrate = this.mainPreferences.getInt("roundAudioBitrate", 64);
        this.pendingSuggestions = this.mainPreferences.getStringSet("pendingSuggestions", null);
        this.currentThemeType = this.mainPreferences.getString("current_theme_type", "Day");
        this.callsEnabled = this.mainPreferences.getBoolean("callsEnabled", false);
        this.schedule_period_forground_ms = this.mainPreferences.getInt("schedule_period_forground_gems", 5000);
        this.schedule_period_background_ms = this.mainPreferences.getInt("schedule_period_background_ms", 60000);
        this.schedule_period_background_delay_ms = this.mainPreferences.getInt("schedule_period_background_delay_ms", 60000);
        this.uploadChunkSize_KB = this.mainPreferences.getInt("uploadChunkSize_KB", 128);
        this.downloadChunkSize_KB = this.mainPreferences.getInt("downloadChunkSize_KB", 32);
        this.update_available = this.mainPreferences.getBoolean("updateAvailable", false);
        this.appURL = this.mainPreferences.getString("appUrl", "");
        this.socketURL = this.mainPreferences.getString("socketURL", "");
        this.lastTempCacheCheckTime = this.mainPreferences.getInt("lastTempCacheCheckTime", 0);
        this.payHost = this.mainPreferences.getString("payHost", null);
        this.payEnabled = this.mainPreferences.getBoolean("payEnabled", false);
        this.exploreEnabled = this.mainPreferences.getBoolean("exploreEnabled", false);
        this.mxbEnabled = this.mainPreferences.getBoolean("mxbEnabled", false);
        this.callOutEnabled = this.mainPreferences.getBoolean("callOutEnabled", false);
        this.reportVersion = this.mainPreferences.getBoolean("reportVersion", false);
        this.foregroundConnection = this.notificationsPreferences.getBoolean("foregroundConnection", false);
        this.liveStreamId = this.mainPreferences.getLong("live_stream_id", 0L);
        this.liveStreamAccessHash = this.mainPreferences.getLong("live_stream_access_hash", 0L);
        this.liveDialogId = this.mainPreferences.getLong("live_dialog_id", 0L);
        this.liveDialogMsgId = this.mainPreferences.getInt("live_dialog_msg_id", 0);
        this.liveStreamConfig = new TLRPC$TL_liveStreamConfig(Base64.decode(this.mainPreferences.getString("live_stream_config", ""), 0));
        if (this.pendingSuggestions != null) {
            this.pendingSuggestions = new HashSet(this.pendingSuggestions);
        } else {
            this.pendingSuggestions = new HashSet();
        }
        Set<String> stringSet = this.mainPreferences.getStringSet("exportUri2", null);
        this.exportUri = stringSet;
        if (stringSet != null) {
            this.exportUri = new HashSet(this.exportUri);
        } else {
            HashSet hashSet = new HashSet();
            this.exportUri = hashSet;
            hashSet.add("content://(\\d+@)?com\\.whatsapp\\.provider\\.media/export_chat/");
            this.exportUri.add("content://(\\d+@)?com\\.whatsapp\\.w4b\\.provider\\.media/export_chat/");
            this.exportUri.add("content://jp\\.naver\\.line\\.android\\.line\\.common\\.FileProvider/export-chat/");
            this.exportUri.add(".*WhatsApp.*\\.txt$");
        }
        Set<String> stringSet2 = this.mainPreferences.getStringSet("exportGroupUri", null);
        this.exportGroupUri = stringSet2;
        if (stringSet2 != null) {
            this.exportGroupUri = new HashSet(this.exportGroupUri);
        } else {
            HashSet hashSet2 = new HashSet();
            this.exportGroupUri = hashSet2;
            hashSet2.add("@g.us/");
        }
        Set<String> stringSet3 = this.mainPreferences.getStringSet("exportPrivateUri", null);
        this.exportPrivateUri = stringSet3;
        if (stringSet3 != null) {
            this.exportPrivateUri = new HashSet(this.exportPrivateUri);
        } else {
            HashSet hashSet3 = new HashSet();
            this.exportPrivateUri = hashSet3;
            hashSet3.add("@s.whatsapp.net/");
        }
        Set<String> stringSet4 = this.mainPreferences.getStringSet("autologinDomains", null);
        this.autologinDomains = stringSet4;
        if (stringSet4 != null) {
            this.autologinDomains = new HashSet(this.autologinDomains);
        } else {
            this.autologinDomains = new HashSet();
        }
        Set<String> stringSet5 = this.mainPreferences.getStringSet("authDomains", null);
        this.authDomains = stringSet5;
        if (stringSet5 != null) {
            this.authDomains = new HashSet(this.authDomains);
        } else {
            this.authDomains = new HashSet();
        }
        this.autologinToken = this.mainPreferences.getString("autologinToken", null);
        Set<String> stringSet6 = this.mainPreferences.getStringSet("diceEmojies", null);
        if (stringSet6 == null) {
            this.diceEmojies = new HashSet<>();
        } else {
            this.diceEmojies = new HashSet<>(stringSet6);
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
                    for (int i = 0; i < int32; i++) {
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
                    for (int i2 = 0; i2 < int322; i2++) {
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
                for (int i3 = 0; i3 < int323; i3++) {
                    this.gifSearchEmojies.add(serializedData3.readString(true));
                }
                serializedData3.cleanup();
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$MessagesController() {
        MessagesController messagesController = getMessagesController();
        getNotificationCenter().addObserver(messagesController, NotificationCenter.fileUploaded);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.fileUploadFailed);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.fileLoaded);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.fileLoadFailed);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.messageReceivedByServer);
        getNotificationCenter().addObserver(messagesController, NotificationCenter.updateMessageMedia);
    }

    public void clearLiveDialogId() {
        updateLiveDialogId(0L, 0L, 0L, 0);
    }

    public void updateLiveDialogId(long liveId, long access_hash, long did, int msgId) {
        this.mainPreferences.edit().putLong("live_stream_id", liveId).putLong("live_stream_access_hash", access_hash).putLong("live_dialog_id", did).putInt("live_dialog_msg_id", msgId).apply();
        this.liveStreamId = liveId;
        this.liveStreamAccessHash = access_hash;
        this.liveDialogId = did;
        this.liveDialogMsgId = msgId;
    }

    private void sendLoadPeersRequest(final TLObject req, final ArrayList<TLObject> requests, final TLRPC$messages_Dialogs pinnedDialogs, final TLRPC$messages_Dialogs pinnedRemoteDialogs, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final ArrayList<DialogFilter> filtersToSave, final SparseArray<DialogFilter> filtersToDelete, final ArrayList<Integer> filtersOrder, final HashMap<Integer, HashSet<Long>> filterDialogRemovals, final HashMap<Integer, HashSet<Long>> filterUserRemovals, final HashSet<Integer> filtersUnreadCounterReset) {
        getConnectionsManager().sendRequest(req, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$_1RfEg6M4tNyDrAuOE8PE8uJ6g4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendLoadPeersRequest$5$MessagesController(chats, users, pinnedDialogs, pinnedRemoteDialogs, requests, req, filtersToSave, filtersToDelete, filtersOrder, filterDialogRemovals, filterUserRemovals, filtersUnreadCounterReset, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendLoadPeersRequest$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendLoadPeersRequest$5$MessagesController(ArrayList arrayList, ArrayList arrayList2, TLRPC$messages_Dialogs tLRPC$messages_Dialogs, TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, ArrayList arrayList3, TLObject tLObject, ArrayList arrayList4, SparseArray sparseArray, ArrayList arrayList5, HashMap map, HashMap map2, HashSet hashSet, TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
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

    protected void loadFilterPeers(final HashMap<Long, TLRPC$InputPeer> dialogsToLoadMap, final HashMap<Long, TLRPC$InputPeer> usersToLoadMap, final HashMap<Long, TLRPC$InputPeer> chatsToLoadMap, final TLRPC$messages_Dialogs pinnedDialogs, final TLRPC$messages_Dialogs pinnedRemoteDialogs, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final ArrayList<DialogFilter> filtersToSave, final SparseArray<DialogFilter> filtersToDelete, final ArrayList<Integer> filtersOrder, final HashMap<Integer, HashSet<Long>> filterDialogRemovals, final HashMap<Integer, HashSet<Long>> filterUserRemovals, final HashSet<Integer> filtersUnreadCounterReset) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$EM_CBIlYta7-3t8fuZRMhvmo7to
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFilterPeers$6$MessagesController(usersToLoadMap, pinnedDialogs, pinnedRemoteDialogs, users, chats, filtersToSave, filtersToDelete, filtersOrder, filterDialogRemovals, filterUserRemovals, filtersUnreadCounterReset, chatsToLoadMap, dialogsToLoadMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFilterPeers$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFilterPeers$6$MessagesController(HashMap map, TLRPC$messages_Dialogs tLRPC$messages_Dialogs, TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, SparseArray sparseArray, ArrayList arrayList4, HashMap map2, HashMap map3, HashSet hashSet, HashMap map4, HashMap map5) {
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
        TLRPC$TL_messages_getChats tLRPC$TL_messages_getChats2 = null;
        TLRPC$TL_channels_getChannels tLRPC$TL_channels_getChannels2 = null;
        for (Map.Entry entry2 : map4.entrySet()) {
            TLRPC$InputPeer tLRPC$InputPeer = (TLRPC$InputPeer) entry2.getValue();
            if (tLRPC$InputPeer.chat_id != 0) {
                if (tLRPC$TL_messages_getChats2 == null) {
                    tLRPC$TL_messages_getChats = new TLRPC$TL_messages_getChats();
                    arrayList5.add(tLRPC$TL_messages_getChats);
                } else {
                    tLRPC$TL_messages_getChats = tLRPC$TL_messages_getChats2;
                }
                tLRPC$TL_messages_getChats.id.add((Long) entry2.getKey());
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
            for (Map.Entry entry3 : map5.entrySet()) {
                if (tLRPC$TL_messages_getPeerDialogs == null) {
                    tLRPC$TL_messages_getPeerDialogs = new TLRPC$TL_messages_getPeerDialogs();
                    arrayList5.add(tLRPC$TL_messages_getPeerDialogs);
                }
                TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
                TLRPC$InputPeer tLRPC$InputPeer2 = (TLRPC$InputPeer) entry3.getValue();
                tLRPC$TL_inputDialogPeer.peer = tLRPC$InputPeer2;
                tLRPC$TL_messages_getPeerDialogs.peers.add(tLRPC$InputPeer2);
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

    protected void processLoadedDialogFilters(final ArrayList<DialogFilter> filters, final TLRPC$messages_Dialogs pinnedDialogs, final TLRPC$messages_Dialogs pinnedRemoteDialogs, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final ArrayList<TLRPC$EncryptedChat> encryptedChats, final int remote) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$FXHoobk4DsQnZGYbE6hH9X9PCnY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDialogFilters$9$MessagesController(pinnedDialogs, encryptedChats, pinnedRemoteDialogs, remote, filters, users, chats);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b5  */
    /* renamed from: lambda$processLoadedDialogFilters$9, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processLoadedDialogFilters$9$MessagesController(ir.eitaa.tgnet.TLRPC$messages_Dialogs r20, final java.util.ArrayList r21, final ir.eitaa.tgnet.TLRPC$messages_Dialogs r22, final int r23, final java.util.ArrayList r24, final java.util.ArrayList r25, final java.util.ArrayList r26) {
        /*
            Method dump skipped, instructions count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$processLoadedDialogFilters$9$MessagesController(ir.eitaa.tgnet.TLRPC$messages_Dialogs, java.util.ArrayList, ir.eitaa.tgnet.TLRPC$messages_Dialogs, int, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedDialogFilters$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDialogFilters$8$MessagesController(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, TLRPC$messages_Dialogs tLRPC$messages_Dialogs, ArrayList arrayList4, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        if (i != 2) {
            this.dialogFilters = arrayList;
            this.dialogFiltersById.clear();
            int size = this.dialogFilters.size();
            for (int i2 = 0; i2 < size; i2++) {
                DialogFilter dialogFilter = this.dialogFilters.get(i2);
                this.dialogFiltersById.put(dialogFilter.id, dialogFilter);
            }
            Collections.sort(this.dialogFilters, $$Lambda$MessagesController$KcXSitjG807BbF9eTn1R0VbSeiE.INSTANCE);
            putUsers(arrayList2, true);
            putChats(arrayList3, true);
            this.dialogFiltersLoaded = true;
            getNotificationCenter().postNotificationName(NotificationCenter.dialogFiltersUpdated, new Object[0]);
            if (i == 0) {
                loadRemoteFilters(false);
            }
            if (tLRPC$messages_Dialogs != null && !tLRPC$messages_Dialogs.dialogs.isEmpty()) {
                applyDialogsNotificationsSettings(tLRPC$messages_Dialogs.dialogs);
            }
            if (arrayList4 != null) {
                for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                    TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) arrayList4.get(i3);
                    if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) && AndroidUtilities.getMyLayerVersion(tLRPC$EncryptedChat.layer) < SecretChatHelper.CURRENT_SECRET_CHAT_LAYER) {
                        getSecretChatHelper().sendNotifyLayerMessage(tLRPC$EncryptedChat, null);
                    }
                    putEncryptedChat(tLRPC$EncryptedChat, true);
                }
            }
            for (int i4 = 0; i4 < longSparseArray.size(); i4++) {
                long jKeyAt = longSparseArray.keyAt(i4);
                TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) longSparseArray.valueAt(i4);
                TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(jKeyAt);
                if (tLRPC$messages_Dialogs != null && tLRPC$messages_Dialogs.dialogs.contains(tLRPC$Dialog)) {
                    if (tLRPC$Dialog.draft instanceof TLRPC$TL_draftMessage) {
                        getMediaDataController().saveDraft(tLRPC$Dialog.id, 0, tLRPC$Dialog.draft, null, false);
                    }
                    if (tLRPC$Dialog2 != null) {
                        tLRPC$Dialog2.notify_settings = tLRPC$Dialog.notify_settings;
                    }
                }
                MessageObject messageObject = (MessageObject) longSparseArray2.get(tLRPC$Dialog.id);
                if (tLRPC$Dialog2 == null) {
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
                        if (tLRPC$Dialog.top_message >= tLRPC$Dialog2.top_message) {
                            this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
                            this.dialogMessage.put(jKeyAt, messageObject);
                            if (messageObject2 != null) {
                                if (messageObject2.messageOwner.peer_id.channel_id == 0) {
                                    this.dialogMessagesByIds.remove(messageObject2.getId());
                                }
                                long j2 = messageObject2.messageOwner.random_id;
                                if (j2 != 0) {
                                    this.dialogMessagesByRandomIds.remove(j2);
                                }
                            }
                            if (messageObject != null && messageObject.messageOwner.peer_id.channel_id == 0) {
                                if (messageObject2 != null && messageObject2.getId() == messageObject.getId()) {
                                    messageObject.deleted = messageObject2.deleted;
                                }
                                this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                                long j3 = messageObject.messageOwner.random_id;
                                if (j3 != 0) {
                                    this.dialogMessagesByRandomIds.put(j3, messageObject);
                                }
                            }
                        }
                    } else if (messageObject == null || messageObject.messageOwner.date > messageObject2.messageOwner.date) {
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
                                long j4 = messageObject.messageOwner.random_id;
                                if (j4 != 0) {
                                    this.dialogMessagesByRandomIds.put(j4, messageObject);
                                }
                            }
                        }
                        long j5 = messageObject2.messageOwner.random_id;
                        if (j5 != 0) {
                            this.dialogMessagesByRandomIds.remove(j5);
                        }
                    }
                }
            }
            this.allDialogs.clear();
            int size2 = this.dialogs_dict.size();
            for (int i5 = 0; i5 < size2; i5++) {
                TLRPC$Dialog tLRPC$DialogValueAt = this.dialogs_dict.valueAt(i5);
                if (this.deletingDialogs.indexOfKey(tLRPC$DialogValueAt.id) < 0) {
                    this.allDialogs.add(tLRPC$DialogValueAt);
                }
            }
            sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
        if (i != 0) {
            getUserConfig().filtersLoaded = true;
            getUserConfig().saveConfig(false);
            this.loadingRemoteFilters = false;
            getNotificationCenter().postNotificationName(NotificationCenter.filterSettingsUpdated, new Object[0]);
        }
    }

    static /* synthetic */ int lambda$processLoadedDialogFilters$7(DialogFilter dialogFilter, DialogFilter dialogFilter2) {
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
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_getSuggestedDialogFilters
            public static int constructor = -1566780372;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                int int32 = stream.readInt32(exception);
                for (int i = 0; i < int32; i++) {
                    TLRPC$TL_dialogFilterSuggested tLRPC$TL_dialogFilterSuggestedTLdeserialize = TLRPC$TL_dialogFilterSuggested.TLdeserialize(stream, stream.readInt32(exception), exception);
                    if (tLRPC$TL_dialogFilterSuggestedTLdeserialize == null) {
                        return tLRPC$Vector;
                    }
                    tLRPC$Vector.objects.add(tLRPC$TL_dialogFilterSuggestedTLdeserialize);
                }
                return tLRPC$Vector;
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$7PfcN9FxcRKvmdqmNuGdb-s5VfY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadSuggestedFilters$11$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSuggestedFilters$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSuggestedFilters$11$MessagesController(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$8_nDm9TWS23phjMqM6RT31y36xE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSuggestedFilters$10$MessagesController(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSuggestedFilters$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSuggestedFilters$10$MessagesController(TLObject tLObject) {
        this.loadingSuggestedFilters = false;
        this.suggestedFilters.clear();
        if (tLObject instanceof TLRPC$Vector) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            int size = tLRPC$Vector.objects.size();
            for (int i = 0; i < size; i++) {
                this.suggestedFilters.add((TLRPC$TL_dialogFilterSuggested) tLRPC$Vector.objects.get(i));
            }
        }
        getNotificationCenter().postNotificationName(NotificationCenter.suggestedFiltersLoaded, new Object[0]);
    }

    public void loadRemoteFilters(boolean force) {
        if (this.loadingRemoteFilters || !getUserConfig().isClientActivated()) {
            return;
        }
        if (force || !getUserConfig().filtersLoaded) {
            if (force) {
                getUserConfig().filtersLoaded = false;
                getUserConfig().saveConfig(false);
            }
            getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_getDialogFilters
                public static int constructor = -241247891;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                    int int32 = stream.readInt32(exception);
                    for (int i = 0; i < int32; i++) {
                        TLRPC$TL_dialogFilter tLRPC$TL_dialogFilterTLdeserialize = TLRPC$TL_dialogFilter.TLdeserialize(stream, stream.readInt32(exception), exception);
                        if (tLRPC$TL_dialogFilterTLdeserialize == null) {
                            return tLRPC$Vector;
                        }
                        tLRPC$Vector.objects.add(tLRPC$TL_dialogFilterTLdeserialize);
                    }
                    return tLRPC$Vector;
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$1tEdyotvGNcvlz8fbLqvXOmIT9g
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadRemoteFilters$13$MessagesController(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRemoteFilters$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadRemoteFilters$13$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$Vector) {
            getMessagesStorage().checkLoadedRemoteFilters((TLRPC$Vector) tLObject);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$nXtOf638qwVRNsQt-UVSlVXJdyw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadRemoteFilters$12$MessagesController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRemoteFilters$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadRemoteFilters$12$MessagesController() {
        this.loadingRemoteFilters = false;
    }

    public void selectDialogFilter(DialogFilter filter, int index) {
        DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
        if (dialogFilterArr[index] == filter) {
            return;
        }
        DialogFilter dialogFilter = dialogFilterArr[index];
        dialogFilterArr[index] = filter;
        if (dialogFilterArr[index == 0 ? (char) 1 : (char) 0] == filter) {
            dialogFilterArr[index != 0 ? (char) 0 : (char) 1] = null;
        }
        if (dialogFilterArr[index] != null) {
            sortDialogs(null);
        } else if (dialogFilter != null) {
            dialogFilter.dialogs.clear();
        }
    }

    public void onFilterUpdate(DialogFilter filter) {
        for (int i = 0; i < 2; i++) {
            if (this.selectedDialogFilter[i] == filter) {
                sortDialogs(null);
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
                return;
            }
        }
    }

    public void addFilter(DialogFilter filter, boolean atBegin) {
        if (atBegin) {
            int iMin = 254;
            int size = this.dialogFilters.size();
            for (int i = 0; i < size; i++) {
                iMin = Math.min(iMin, this.dialogFilters.get(i).order);
            }
            filter.order = iMin - 1;
            this.dialogFilters.add(0, filter);
        } else {
            int size2 = this.dialogFilters.size();
            int iMax = 0;
            for (int i2 = 0; i2 < size2; i2++) {
                iMax = Math.max(iMax, this.dialogFilters.get(i2).order);
            }
            filter.order = iMax + 1;
            this.dialogFilters.add(filter);
        }
        this.dialogFiltersById.put(filter.id, filter);
        if (this.dialogFilters.size() != 1 || SharedConfig.getChatSwipeAction(this.currentAccount) == 5) {
            return;
        }
        SharedConfig.updateChatListSwipeSetting(5);
    }

    public void removeFilter(DialogFilter filter) {
        this.dialogFilters.remove(filter);
        this.dialogFiltersById.remove(filter.id);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogFiltersUpdated, new Object[0]);
    }

    private void loadAppConfig() {
        if (this.loadingAppConfig) {
            return;
        }
        this.loadingAppConfig = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_getAppConfig
            public static int constructor = -1735311088;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$JSONValue.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xza1TCtDNd3QwyPwKjbks5jpo9o
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAppConfig$15$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAppConfig$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAppConfig$15$MessagesController(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Hek_s-xU6Ax4C1s9gdhOWB6t234
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAppConfig$14$MessagesController(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:180:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /* renamed from: lambda$loadAppConfig$14, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadAppConfig$14$MessagesController(ir.eitaa.tgnet.TLObject r28) {
        /*
            Method dump skipped, instructions count: 2330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$loadAppConfig$14$MessagesController(ir.eitaa.tgnet.TLObject):void");
    }

    public void removeSuggestion(long did, String suggestion) {
        if (TextUtils.isEmpty(suggestion)) {
            return;
        }
        if (did == 0) {
            if (!this.pendingSuggestions.remove(suggestion)) {
                return;
            }
            SharedPreferences.Editor editorEdit = this.mainPreferences.edit();
            editorEdit.putStringSet("pendingSuggestions", this.pendingSuggestions);
            editorEdit.commit();
            getNotificationCenter().postNotificationName(NotificationCenter.newSuggestionsAvailable, new Object[0]);
        }
        TLRPC$TL_help_dismissSuggestion tLRPC$TL_help_dismissSuggestion = new TLRPC$TL_help_dismissSuggestion();
        tLRPC$TL_help_dismissSuggestion.suggestion = suggestion;
        if (did == 0) {
            tLRPC$TL_help_dismissSuggestion.peer = new TLRPC$TL_inputPeerEmpty();
        } else {
            tLRPC$TL_help_dismissSuggestion.peer = getInputPeer(did);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_help_dismissSuggestion, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$MiE9PKaLrpGV7n6E1EcjE_AGr5E
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$removeSuggestion$16(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void updateConfig(final TLRPC$TL_config config) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$trfuMRgzS2V-0xlNP-Gr3nK8TTs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateConfig$17$MessagesController(config);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateConfig$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateConfig$17$MessagesController(TLRPC$TL_config tLRPC$TL_config) {
        String str;
        getDownloadController().loadAutoDownloadConfig(false);
        loadAppConfig();
        boolean z = this.update_available;
        boolean z2 = this.callsEnabled;
        this.maxMegagroupCount = tLRPC$TL_config.megagroup_size_max;
        this.maxGroupCount = tLRPC$TL_config.chat_size_max;
        this.maxEditTime = tLRPC$TL_config.edit_time_limit;
        this.ratingDecay = tLRPC$TL_config.rating_e_decay;
        this.maxRecentGifsCount = tLRPC$TL_config.saved_gifs_limit;
        this.maxRecentStickersCount = tLRPC$TL_config.stickers_recent_limit;
        this.maxFaveStickersCount = tLRPC$TL_config.stickers_faved_limit;
        this.revokeTimeLimit = tLRPC$TL_config.revoke_time_limit;
        this.revokeTimePmLimit = tLRPC$TL_config.revoke_pm_time_limit;
        this.canRevokePmInbox = tLRPC$TL_config.revoke_pm_inbox;
        String str2 = tLRPC$TL_config.me_url_prefix;
        this.linkPrefix = str2;
        if (str2.endsWith("/")) {
            this.linkPrefix = this.linkPrefix.substring(0, r3.length() - 1);
        }
        if (this.linkPrefix.startsWith("https://")) {
            this.linkPrefix = this.linkPrefix.substring(8);
        } else if (this.linkPrefix.startsWith("http://")) {
            this.linkPrefix = this.linkPrefix.substring(7);
        }
        this.callReceiveTimeout = tLRPC$TL_config.call_receive_timeout_ms;
        this.callRingTimeout = tLRPC$TL_config.call_ring_timeout_ms;
        this.callConnectTimeout = tLRPC$TL_config.call_connect_timeout_ms;
        this.callPacketTimeout = tLRPC$TL_config.call_packet_timeout_ms;
        this.maxPinnedDialogsCount = tLRPC$TL_config.pinned_dialogs_count_max;
        this.maxFolderPinnedDialogsCount = tLRPC$TL_config.pinned_infolder_count_max;
        this.maxMessageLength = tLRPC$TL_config.message_length_max;
        this.maxCaptionLength = tLRPC$TL_config.caption_length_max;
        this.preloadFeaturedStickers = tLRPC$TL_config.preload_featured_stickers;
        String str3 = tLRPC$TL_config.venue_search_username;
        if (str3 != null) {
            this.venueSearchBot = str3;
        }
        String str4 = tLRPC$TL_config.gif_search_username;
        if (str4 != null) {
            this.gifSearchBot = str4;
        }
        if (this.imageSearchBot != null) {
            this.imageSearchBot = tLRPC$TL_config.img_search_username;
        }
        this.blockedCountry = tLRPC$TL_config.blocked_mode;
        this.dcDomainName = tLRPC$TL_config.dc_txt_domain_name;
        this.webFileDatacenterId = tLRPC$TL_config.webfile_dc_id;
        String str5 = tLRPC$TL_config.suggested_lang_code;
        if (str5 != null && ((str = this.suggestedLangCode) == null || !str.equals(str5))) {
            this.suggestedLangCode = tLRPC$TL_config.suggested_lang_code;
            LocaleController.getInstance().loadRemoteLanguages(this.currentAccount);
        }
        this.liveStreamConfig = tLRPC$TL_config.liveStreamConfig;
        boolean z3 = this.payEnabled;
        this.payEnabled = tLRPC$TL_config.payEnabled;
        boolean z4 = this.exploreEnabled;
        boolean z5 = tLRPC$TL_config.exploreEnabled;
        this.exploreEnabled = z5;
        if (z5 != z4) {
            getNotificationCenter().postNotificationName(NotificationCenter.exploreStatusNeedReload, new Object[0]);
        }
        boolean z6 = this.mxbEnabled;
        boolean z7 = tLRPC$TL_config.mxbEnabled;
        this.mxbEnabled = z7;
        if (z7 != z6) {
            getNotificationCenter().postNotificationName(NotificationCenter.mxbStatusNeedReload, new Object[0]);
        }
        boolean z8 = this.callOutEnabled;
        if (Build.VERSION.SDK_INT >= 23) {
            this.callOutEnabled = tLRPC$TL_config.callOutEnabled;
        } else {
            this.callOutEnabled = false;
        }
        this.reportVersion = tLRPC$TL_config.reportVersion;
        this.payHost = tLRPC$TL_config.payHost;
        this.callsEnabled = tLRPC$TL_config.phonecalls_enabled;
        this.update_available = tLRPC$TL_config.update_available;
        this.appURL = tLRPC$TL_config.appURL;
        this.socketURL = tLRPC$TL_config.socketURL;
        Theme.loadRemoteThemes(this.currentAccount, false);
        Theme.checkCurrentRemoteTheme(false);
        if (tLRPC$TL_config.static_maps_provider == null) {
            tLRPC$TL_config.static_maps_provider = "eitaa";
        }
        this.schedule_period_background_delay_ms = tLRPC$TL_config.schedule_period_background_delay_ms;
        this.schedule_period_background_ms = tLRPC$TL_config.schedule_period_background_ms;
        this.schedule_period_forground_ms = tLRPC$TL_config.schedule_period_forground_ms;
        this.uploadChunkSize_KB = tLRPC$TL_config.uploadChunkSize_KB;
        this.downloadChunkSize_KB = tLRPC$TL_config.downloadChunkSize_KB;
        this.mapProvider = 2;
        this.availableMapProviders = 0;
        FileLog.d("map providers = " + tLRPC$TL_config.static_maps_provider);
        this.mapHostUrl = tLRPC$TL_config.static_maps_provider;
        SharedPreferences.Editor editorEdit = this.mainPreferences.edit();
        editorEdit.putInt("maxGroupCount", this.maxGroupCount);
        editorEdit.putInt("maxMegagroupCount", this.maxMegagroupCount);
        editorEdit.putInt("maxEditTime", this.maxEditTime);
        editorEdit.putInt("ratingDecay", this.ratingDecay);
        editorEdit.putInt("maxRecentGifsCount", this.maxRecentGifsCount);
        editorEdit.putInt("maxRecentStickersCount", this.maxRecentStickersCount);
        editorEdit.putInt("maxFaveStickersCount", this.maxFaveStickersCount);
        editorEdit.putInt("callReceiveTimeout", this.callReceiveTimeout);
        editorEdit.putInt("callRingTimeout", this.callRingTimeout);
        editorEdit.putInt("callConnectTimeout", this.callConnectTimeout);
        editorEdit.putInt("callPacketTimeout", this.callPacketTimeout);
        editorEdit.putString("linkPrefix", this.linkPrefix);
        editorEdit.putInt("maxPinnedDialogsCount", this.maxPinnedDialogsCount);
        editorEdit.putInt("maxFolderPinnedDialogsCount", this.maxFolderPinnedDialogsCount);
        editorEdit.putInt("maxMessageLength", this.maxMessageLength);
        editorEdit.putInt("maxCaptionLength", this.maxCaptionLength);
        editorEdit.putBoolean("preloadFeaturedStickers", this.preloadFeaturedStickers);
        editorEdit.putInt("revokeTimeLimit", this.revokeTimeLimit);
        editorEdit.putInt("revokeTimePmLimit", this.revokeTimePmLimit);
        editorEdit.putInt("schedule_period_forground_gems", this.schedule_period_forground_ms);
        editorEdit.putInt("schedule_period_background_ms", this.schedule_period_background_ms);
        editorEdit.putInt("schedule_period_background_delay_ms", this.schedule_period_background_delay_ms);
        editorEdit.putInt("uploadChunkSize_KB", this.uploadChunkSize_KB);
        editorEdit.putInt("downloadChunkSize_KB", this.downloadChunkSize_KB);
        editorEdit.putInt("mapProvider", this.mapProvider);
        editorEdit.putBoolean("payEnabled", this.payEnabled);
        editorEdit.putBoolean("exploreEnabled", this.exploreEnabled);
        editorEdit.putBoolean("mxbEnabled", this.mxbEnabled);
        editorEdit.putBoolean("callOutEnabled", this.callOutEnabled);
        editorEdit.putBoolean("reportVersion", this.reportVersion);
        editorEdit.putBoolean("updateAvailable", this.update_available);
        editorEdit.putString("appUrl", this.appURL);
        editorEdit.putString("socketURL", this.socketURL);
        editorEdit.putString("payHost", this.payHost);
        String str6 = this.mapHostUrl;
        if (str6 != null) {
            editorEdit.putString("pk", str6);
        }
        editorEdit.putBoolean("canRevokePmInbox", this.canRevokePmInbox);
        editorEdit.putBoolean("blockedCountry", this.blockedCountry);
        editorEdit.putString("venueSearchBot", this.venueSearchBot);
        editorEdit.putString("gifSearchBot", this.gifSearchBot);
        editorEdit.putString("imageSearchBot", this.imageSearchBot);
        editorEdit.putString("dcDomainName2", this.dcDomainName);
        editorEdit.putInt("webFileDatacenterId", this.webFileDatacenterId);
        editorEdit.putString("suggestedLangCode", this.suggestedLangCode);
        SerializedData serializedData = new SerializedData();
        this.liveStreamConfig.serializeToStream(serializedData);
        editorEdit.putString("live_stream_config", Base64.encodeToString(serializedData.toByteArray(), 0));
        editorEdit.commit();
        if (this.callsEnabled != z2 || this.update_available != z || this.payEnabled != z3 || this.exploreEnabled != z4 || this.mxbEnabled != z6 || this.callOutEnabled != z8) {
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
        }
        LocaleController.getInstance().checkUpdateForCurrentRemoteLocale(this.currentAccount, tLRPC$TL_config.lang_pack_version, tLRPC$TL_config.base_lang_pack_version);
        getNotificationCenter().postNotificationName(NotificationCenter.configLoaded, new Object[0]);
    }

    public void saveUrlWhiteList(TLRPC$TL_UrlWhiteList list) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        this.urlWhiteList = list.urls;
        try {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            File file = new File(ApplicationLoader.applicationContext.getApplicationInfo().dataDir, "files");
            if (!file.exists()) {
                file.mkdirs();
            }
            FileWriter fileWriter = new FileWriter(new File(file, "Urls"));
            Iterator<String> it = this.urlWhiteList.iterator();
            while (it.hasNext()) {
                fileWriter.append((CharSequence) Base64.encodeToString(cipher.doFinal((it.next() + "\n").getBytes("UTF-8")), 0));
            }
            fileWriter.flush();
            fileWriter.close();
            ApplicationLoader.applicationContext.getSharedPreferences("dataconfig", 0).edit().putString("encryptionKey", Base64.encodeToString(bArr, 0)).apply();
            this.isUrlWhiteListLoaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadUrlWhiteList() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        if (this.isUrlWhiteListLoaded) {
            return;
        }
        String string = ApplicationLoader.applicationContext.getSharedPreferences("dataconfig", 0).getString("encryptionKey", "");
        if (string.isEmpty()) {
            getConnectionsManager().updateUrlWhiteList();
            return;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(string, 0), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(new File(ApplicationLoader.applicationContext.getApplicationInfo().dataDir, "files"), "Urls")));
            this.urlWhiteList.clear();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    String str = new String(cipher.doFinal(Base64.decode(line, 0)), "UTF-8");
                    this.urlWhiteList.add(str.substring(0, str.length() - 1));
                } else {
                    bufferedReader.close();
                    this.isUrlWhiteListLoaded = true;
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isWhiteListedUrl(String url) {
        if (url.startsWith("www.")) {
            url = url.substring(4);
        }
        Iterator<String> it = this.urlWhiteList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(url)) {
                return true;
            }
        }
        return false;
    }

    public void addSupportUser() {
        TLRPC$TL_userForeign_old2 tLRPC$TL_userForeign_old2 = new TLRPC$TL_userForeign_old2();
        tLRPC$TL_userForeign_old2.phone = "333";
        tLRPC$TL_userForeign_old2.id = 333000L;
        tLRPC$TL_userForeign_old2.first_name = "Eitaa";
        tLRPC$TL_userForeign_old2.last_name = "";
        tLRPC$TL_userForeign_old2.status = null;
        tLRPC$TL_userForeign_old2.photo = new TLRPC$TL_userProfilePhotoEmpty();
        putUser(tLRPC$TL_userForeign_old2, true);
        TLRPC$TL_userForeign_old2 tLRPC$TL_userForeign_old22 = new TLRPC$TL_userForeign_old2();
        tLRPC$TL_userForeign_old22.phone = "42777";
        tLRPC$TL_userForeign_old22.id = 777000L;
        tLRPC$TL_userForeign_old22.verified = true;
        tLRPC$TL_userForeign_old22.first_name = "Eitaa";
        tLRPC$TL_userForeign_old22.last_name = "Notifications";
        tLRPC$TL_userForeign_old22.status = null;
        tLRPC$TL_userForeign_old22.photo = new TLRPC$TL_userProfilePhotoEmpty();
        putUser(tLRPC$TL_userForeign_old22, true);
    }

    public TLRPC$InputUser getInputUser(TLRPC$User user) {
        if (user == null) {
            return new TLRPC$TL_inputUserEmpty();
        }
        if (user.id == getUserConfig().getClientUserId()) {
            return new TLRPC$TL_inputUserSelf();
        }
        TLRPC$TL_inputUser tLRPC$TL_inputUser = new TLRPC$TL_inputUser();
        tLRPC$TL_inputUser.user_id = user.id;
        tLRPC$TL_inputUser.access_hash = user.access_hash;
        return tLRPC$TL_inputUser;
    }

    public TLRPC$InputUser getInputUser(TLRPC$InputPeer peer) {
        if (peer == null) {
            return new TLRPC$TL_inputUserEmpty();
        }
        if (peer instanceof TLRPC$TL_inputPeerSelf) {
            return new TLRPC$TL_inputUserSelf();
        }
        TLRPC$TL_inputUser tLRPC$TL_inputUser = new TLRPC$TL_inputUser();
        tLRPC$TL_inputUser.user_id = peer.user_id;
        tLRPC$TL_inputUser.access_hash = peer.access_hash;
        return tLRPC$TL_inputUser;
    }

    public TLRPC$InputUser getInputUser(long userId) {
        return getInputUser(getUser(Long.valueOf(userId)));
    }

    public static TLRPC$InputChannel getInputChannel(TLRPC$Chat chat) {
        if ((chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden)) {
            TLRPC$TL_inputChannel tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
            tLRPC$TL_inputChannel.channel_id = chat.id;
            tLRPC$TL_inputChannel.access_hash = chat.access_hash;
            return tLRPC$TL_inputChannel;
        }
        return new TLRPC$TL_inputChannelEmpty();
    }

    public static TLRPC$InputChannel getInputChannel(TLRPC$InputPeer peer) {
        TLRPC$TL_inputChannel tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
        tLRPC$TL_inputChannel.channel_id = peer.channel_id;
        tLRPC$TL_inputChannel.access_hash = peer.access_hash;
        return tLRPC$TL_inputChannel;
    }

    public TLRPC$InputChannel getInputChannel(long chatId) {
        return getInputChannel(getChat(Long.valueOf(chatId)));
    }

    public TLRPC$InputPeer getInputPeer(TLRPC$Peer peer) {
        if (peer instanceof TLRPC$TL_peerChat) {
            TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            tLRPC$TL_inputPeerChat.chat_id = peer.chat_id;
            return tLRPC$TL_inputPeerChat;
        }
        if (peer instanceof TLRPC$TL_peerChannel) {
            TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
            long j = peer.channel_id;
            tLRPC$TL_inputPeerChannel.channel_id = j;
            TLRPC$Chat chat = getChat(Long.valueOf(j));
            if (chat == null) {
                return tLRPC$TL_inputPeerChannel;
            }
            tLRPC$TL_inputPeerChannel.access_hash = chat.access_hash;
            return tLRPC$TL_inputPeerChannel;
        }
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        long j2 = peer.user_id;
        tLRPC$TL_inputPeerUser.user_id = j2;
        TLRPC$User user = getUser(Long.valueOf(j2));
        if (user == null) {
            return tLRPC$TL_inputPeerUser;
        }
        tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
        return tLRPC$TL_inputPeerUser;
    }

    public TLRPC$InputPeer getInputPeer(long id) {
        if (id < 0) {
            long j = -id;
            TLRPC$Chat chat = getChat(Long.valueOf(j));
            if (ChatObject.isChannel(chat)) {
                TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                tLRPC$TL_inputPeerChannel.channel_id = j;
                tLRPC$TL_inputPeerChannel.access_hash = chat.access_hash;
                return tLRPC$TL_inputPeerChannel;
            }
            TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            tLRPC$TL_inputPeerChat.chat_id = j;
            return tLRPC$TL_inputPeerChat;
        }
        TLRPC$User user = getUser(Long.valueOf(id));
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        tLRPC$TL_inputPeerUser.user_id = id;
        if (user == null) {
            return tLRPC$TL_inputPeerUser;
        }
        tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
        return tLRPC$TL_inputPeerUser;
    }

    public static TLRPC$InputPeer getInputPeer(TLRPC$Chat chat) {
        if (ChatObject.isChannel(chat)) {
            TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
            tLRPC$TL_inputPeerChannel.channel_id = chat.id;
            tLRPC$TL_inputPeerChannel.access_hash = chat.access_hash;
            return tLRPC$TL_inputPeerChannel;
        }
        TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
        tLRPC$TL_inputPeerChat.chat_id = chat.id;
        return tLRPC$TL_inputPeerChat;
    }

    public static TLRPC$InputPeer getInputPeer(TLRPC$User user) {
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        tLRPC$TL_inputPeerUser.user_id = user.id;
        tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
        return tLRPC$TL_inputPeerUser;
    }

    public TLRPC$Peer getPeer(long id) {
        if (id < 0) {
            long j = -id;
            TLRPC$Chat chat = getChat(Long.valueOf(j));
            if ((chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden)) {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                tLRPC$TL_peerChannel.channel_id = j;
                return tLRPC$TL_peerChannel;
            }
            TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
            tLRPC$TL_peerChat.chat_id = j;
            return tLRPC$TL_peerChat;
        }
        getUser(Long.valueOf(id));
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_peerUser.user_id = id;
        return tLRPC$TL_peerUser;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        MessageObject messageObject;
        TLRPC$InputFile tLRPC$InputFile;
        TLRPC$InputFile tLRPC$InputFile2;
        final Theme.ThemeInfo themeInfo;
        final Theme.ThemeAccent themeAccent;
        TLRPC$TL_theme tLRPC$TL_theme;
        TLRPC$TL_inputThemeSettings tLRPC$TL_inputThemeSettings = null;
        if (id == NotificationCenter.fileUploaded) {
            String str = (String) args[0];
            TLRPC$InputFile tLRPC$InputFile3 = (TLRPC$InputFile) args[1];
            String str2 = this.uploadingAvatar;
            if (str2 != null && str2.equals(str)) {
                TLRPC$TL_photos_uploadProfilePhoto tLRPC$TL_photos_uploadProfilePhoto = new TLRPC$TL_photos_uploadProfilePhoto();
                tLRPC$TL_photos_uploadProfilePhoto.file = tLRPC$InputFile3;
                tLRPC$TL_photos_uploadProfilePhoto.flags |= 1;
                getConnectionsManager().sendRequest(tLRPC$TL_photos_uploadProfilePhoto, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$aTYIF09FZKNi8EvWfrJlLJKDKJE
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$didReceivedNotification$19$MessagesController(tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            String str3 = this.uploadingWallpaper;
            if (str3 != null && str3.equals(str)) {
                TLRPC$TL_account_uploadWallPaper tLRPC$TL_account_uploadWallPaper = new TLRPC$TL_account_uploadWallPaper();
                tLRPC$TL_account_uploadWallPaper.file = tLRPC$InputFile3;
                tLRPC$TL_account_uploadWallPaper.mime_type = "image/jpeg";
                final Theme.OverrideWallpaperInfo overrideWallpaperInfo = this.uploadingWallpaperInfo;
                final TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings = new TLRPC$TL_wallPaperSettings();
                tLRPC$TL_wallPaperSettings.blur = overrideWallpaperInfo.isBlurred;
                tLRPC$TL_wallPaperSettings.motion = overrideWallpaperInfo.isMotion;
                tLRPC$TL_account_uploadWallPaper.settings = tLRPC$TL_wallPaperSettings;
                getConnectionsManager().sendRequest(tLRPC$TL_account_uploadWallPaper, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$nM8jW2umqG4KZnYOkqrMQKJc6o8
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$didReceivedNotification$21$MessagesController(overrideWallpaperInfo, tLRPC$TL_wallPaperSettings, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            Object obj = this.uploadingThemes.get(str);
            if (obj instanceof Theme.ThemeInfo) {
                Theme.ThemeInfo themeInfo2 = (Theme.ThemeInfo) obj;
                if (str.equals(themeInfo2.uploadingThumb)) {
                    themeInfo2.uploadedThumb = tLRPC$InputFile3;
                    themeInfo2.uploadingThumb = null;
                } else if (str.equals(themeInfo2.uploadingFile)) {
                    themeInfo2.uploadedFile = tLRPC$InputFile3;
                    themeInfo2.uploadingFile = null;
                }
                tLRPC$InputFile = themeInfo2.uploadedThumb;
                tLRPC$InputFile2 = themeInfo2.uploadedFile;
                themeInfo = themeInfo2;
                themeAccent = null;
            } else if (obj instanceof Theme.ThemeAccent) {
                Theme.ThemeAccent themeAccent2 = (Theme.ThemeAccent) obj;
                if (str.equals(themeAccent2.uploadingThumb)) {
                    themeAccent2.uploadedThumb = tLRPC$InputFile3;
                    themeAccent2.uploadingThumb = null;
                } else if (str.equals(themeAccent2.uploadingFile)) {
                    themeAccent2.uploadedFile = tLRPC$InputFile3;
                    themeAccent2.uploadingFile = null;
                }
                themeInfo = themeAccent2.parentTheme;
                themeAccent = themeAccent2;
                tLRPC$InputFile = themeAccent2.uploadedThumb;
                tLRPC$InputFile2 = themeAccent2.uploadedFile;
            } else {
                tLRPC$InputFile = null;
                tLRPC$InputFile2 = null;
                themeInfo = null;
                themeAccent = null;
            }
            this.uploadingThemes.remove(str);
            if (tLRPC$InputFile2 == null || tLRPC$InputFile == null) {
                return;
            }
            new File(str);
            TLRPC$TL_account_uploadTheme tLRPC$TL_account_uploadTheme = new TLRPC$TL_account_uploadTheme();
            tLRPC$TL_account_uploadTheme.mime_type = "application/x-tgtheme-android";
            tLRPC$TL_account_uploadTheme.file_name = "theme.attheme";
            tLRPC$TL_account_uploadTheme.file = tLRPC$InputFile2;
            tLRPC$InputFile2.name = "theme.attheme";
            tLRPC$TL_account_uploadTheme.thumb = tLRPC$InputFile;
            tLRPC$InputFile.name = "theme-preview.jpg";
            tLRPC$TL_account_uploadTheme.flags |= 1;
            if (themeAccent != null) {
                themeAccent.uploadedFile = null;
                themeAccent.uploadedThumb = null;
                tLRPC$TL_theme = themeAccent.info;
                tLRPC$TL_inputThemeSettings = new TLRPC$TL_inputThemeSettings();
                tLRPC$TL_inputThemeSettings.base_theme = Theme.getBaseThemeByKey(themeInfo.name);
                tLRPC$TL_inputThemeSettings.accent_color = themeAccent.accentColor;
                int i = themeAccent.accentColor2;
                if (i != 0) {
                    tLRPC$TL_inputThemeSettings.flags |= 8;
                    tLRPC$TL_inputThemeSettings.outbox_accent_color = i;
                }
                int i2 = themeAccent.myMessagesAccentColor;
                if (i2 != 0) {
                    tLRPC$TL_inputThemeSettings.message_colors.add(Integer.valueOf(i2));
                    tLRPC$TL_inputThemeSettings.flags |= 1;
                    int i3 = themeAccent.myMessagesGradientAccentColor1;
                    if (i3 != 0) {
                        tLRPC$TL_inputThemeSettings.message_colors.add(Integer.valueOf(i3));
                        int i4 = themeAccent.myMessagesGradientAccentColor2;
                        if (i4 != 0) {
                            tLRPC$TL_inputThemeSettings.message_colors.add(Integer.valueOf(i4));
                            int i5 = themeAccent.myMessagesGradientAccentColor3;
                            if (i5 != 0) {
                                tLRPC$TL_inputThemeSettings.message_colors.add(Integer.valueOf(i5));
                            }
                        }
                    }
                    tLRPC$TL_inputThemeSettings.message_colors_animated = themeAccent.myMessagesAnimated;
                }
                tLRPC$TL_inputThemeSettings.flags |= 2;
                tLRPC$TL_inputThemeSettings.wallpaper_settings = new TLRPC$TL_wallPaperSettings();
                if (!TextUtils.isEmpty(themeAccent.patternSlug)) {
                    TLRPC$TL_inputWallPaperSlug tLRPC$TL_inputWallPaperSlug = new TLRPC$TL_inputWallPaperSlug();
                    tLRPC$TL_inputWallPaperSlug.slug = themeAccent.patternSlug;
                    tLRPC$TL_inputThemeSettings.wallpaper = tLRPC$TL_inputWallPaperSlug;
                    TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$TL_inputThemeSettings.wallpaper_settings;
                    tLRPC$WallPaperSettings.intensity = (int) (themeAccent.patternIntensity * 100.0f);
                    tLRPC$WallPaperSettings.flags |= 8;
                } else {
                    TLRPC$TL_inputWallPaperNoFile tLRPC$TL_inputWallPaperNoFile = new TLRPC$TL_inputWallPaperNoFile();
                    tLRPC$TL_inputWallPaperNoFile.id = 0L;
                    tLRPC$TL_inputThemeSettings.wallpaper = tLRPC$TL_inputWallPaperNoFile;
                }
                TLRPC$WallPaperSettings tLRPC$WallPaperSettings2 = tLRPC$TL_inputThemeSettings.wallpaper_settings;
                tLRPC$WallPaperSettings2.motion = themeAccent.patternMotion;
                long j = themeAccent.backgroundOverrideColor;
                if (j != 0) {
                    tLRPC$WallPaperSettings2.background_color = (int) j;
                    tLRPC$WallPaperSettings2.flags |= 1;
                }
                long j2 = themeAccent.backgroundGradientOverrideColor1;
                if (j2 != 0) {
                    tLRPC$WallPaperSettings2.second_background_color = (int) j2;
                    tLRPC$WallPaperSettings2.flags |= 16;
                    tLRPC$WallPaperSettings2.rotation = AndroidUtilities.getWallpaperRotation(themeAccent.backgroundRotation, true);
                }
                long j3 = themeAccent.backgroundGradientOverrideColor2;
                if (j3 != 0) {
                    TLRPC$WallPaperSettings tLRPC$WallPaperSettings3 = tLRPC$TL_inputThemeSettings.wallpaper_settings;
                    tLRPC$WallPaperSettings3.third_background_color = (int) j3;
                    tLRPC$WallPaperSettings3.flags |= 32;
                }
                long j4 = themeAccent.backgroundGradientOverrideColor3;
                if (j4 != 0) {
                    TLRPC$WallPaperSettings tLRPC$WallPaperSettings4 = tLRPC$TL_inputThemeSettings.wallpaper_settings;
                    tLRPC$WallPaperSettings4.fourth_background_color = (int) j4;
                    tLRPC$WallPaperSettings4.flags |= 64;
                }
            } else {
                themeInfo.uploadedFile = null;
                themeInfo.uploadedThumb = null;
                tLRPC$TL_theme = themeInfo.info;
            }
            final TLRPC$TL_theme tLRPC$TL_theme2 = tLRPC$TL_theme;
            final TLRPC$TL_inputThemeSettings tLRPC$TL_inputThemeSettings2 = tLRPC$TL_inputThemeSettings;
            getConnectionsManager().sendRequest(tLRPC$TL_account_uploadTheme, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$QjtkLU4wOSqmOYHiaG2gBxSMtTM
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didReceivedNotification$27$MessagesController(tLRPC$TL_theme2, themeInfo, tLRPC$TL_inputThemeSettings2, themeAccent, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (id == NotificationCenter.fileUploadFailed) {
            String str4 = (String) args[0];
            String str5 = this.uploadingAvatar;
            if (str5 != null && str5.equals(str4)) {
                this.uploadingAvatar = null;
                return;
            }
            String str6 = this.uploadingWallpaper;
            if (str6 != null && str6.equals(str4)) {
                this.uploadingWallpaper = null;
                this.uploadingWallpaperInfo = null;
                return;
            }
            Object objRemove = this.uploadingThemes.remove(str4);
            if (objRemove instanceof Theme.ThemeInfo) {
                Theme.ThemeInfo themeInfo3 = (Theme.ThemeInfo) objRemove;
                themeInfo3.uploadedFile = null;
                themeInfo3.uploadedThumb = null;
                getNotificationCenter().postNotificationName(NotificationCenter.themeUploadError, themeInfo3, null);
                return;
            }
            if (objRemove instanceof Theme.ThemeAccent) {
                Theme.ThemeAccent themeAccent3 = (Theme.ThemeAccent) objRemove;
                themeAccent3.uploadingThumb = null;
                getNotificationCenter().postNotificationName(NotificationCenter.themeUploadError, themeAccent3.parentTheme, themeAccent3);
                return;
            }
            return;
        }
        if (id == NotificationCenter.messageReceivedByServer) {
            if (((Boolean) args[6]).booleanValue()) {
                return;
            }
            Integer num = (Integer) args[0];
            Integer num2 = (Integer) args[1];
            Long l = (Long) args[3];
            MessageObject messageObject2 = this.dialogMessage.get(l.longValue());
            if (messageObject2 != null && (messageObject2.getId() == num.intValue() || messageObject2.messageOwner.local_id == num.intValue())) {
                messageObject2.messageOwner.id = num2.intValue();
                messageObject2.messageOwner.send_state = 0;
            }
            TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(l.longValue());
            if (tLRPC$Dialog != null && tLRPC$Dialog.top_message == num.intValue()) {
                tLRPC$Dialog.top_message = num2.intValue();
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            }
            MessageObject messageObject3 = this.dialogMessagesByIds.get(num.intValue());
            if (messageObject3 != null) {
                this.dialogMessagesByIds.remove(num.intValue());
                this.dialogMessagesByIds.put(num2.intValue(), messageObject3);
            }
            if (DialogObject.isChatDialog(l.longValue())) {
                TLRPC$ChatFull tLRPC$ChatFull = this.fullChats.get(-l.longValue());
                TLRPC$Chat chat = getChat(Long.valueOf(-l.longValue()));
                if (chat == null || ChatObject.hasAdminRights(chat) || tLRPC$ChatFull == null || tLRPC$ChatFull.slowmode_seconds == 0) {
                    return;
                }
                tLRPC$ChatFull.slowmode_next_send_date = getConnectionsManager().getCurrentTime() + tLRPC$ChatFull.slowmode_seconds;
                tLRPC$ChatFull.flags |= 262144;
                getMessagesStorage().updateChatInfo(tLRPC$ChatFull, false);
                return;
            }
            return;
        }
        if (id == NotificationCenter.updateMessageMedia) {
            TLRPC$Message tLRPC$Message = (TLRPC$Message) args[0];
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
    /* renamed from: lambda$didReceivedNotification$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$19$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$User user = getUser(Long.valueOf(getUserConfig().getClientUserId()));
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
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(arrayList, 1000);
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$tRezEwInZKds5fRKdPhlfsJGeg0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didReceivedNotification$18$MessagesController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$18$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_AVATAR));
        getUserConfig().saveConfig(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$21$MessagesController(final Theme.OverrideWallpaperInfo overrideWallpaperInfo, final TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$WallPaper tLRPC$WallPaper = (TLRPC$WallPaper) tLObject;
        final File file = new File(ApplicationLoader.getFilesDirFixed(), overrideWallpaperInfo.originalFileName);
        if (tLRPC$WallPaper != null) {
            try {
                AndroidUtilities.copyFile(file, FileLoader.getPathToAttach(tLRPC$WallPaper.document, true));
            } catch (Exception unused) {
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$3svA2FiMN3lvac5AxLGpydWQ7vk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$20$MessagesController(tLRPC$WallPaper, tLRPC$TL_wallPaperSettings, overrideWallpaperInfo, file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$20$MessagesController(TLRPC$WallPaper tLRPC$WallPaper, TLRPC$TL_wallPaperSettings tLRPC$TL_wallPaperSettings, Theme.OverrideWallpaperInfo overrideWallpaperInfo, File file) {
        if (this.uploadingWallpaper == null || tLRPC$WallPaper == null) {
            return;
        }
        tLRPC$WallPaper.settings = tLRPC$TL_wallPaperSettings;
        tLRPC$WallPaper.flags |= 4;
        overrideWallpaperInfo.slug = tLRPC$WallPaper.slug;
        overrideWallpaperInfo.saveOverrideWallpaper();
        ArrayList<TLRPC$WallPaper> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$WallPaper);
        getMessagesStorage().putWallpapers(arrayList, 2);
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$WallPaper.document.thumbs, 320);
        if (closestPhotoSizeWithSize != null) {
            ImageLoader.getInstance().replaceImageInCache(Utilities.MD5(file.getAbsolutePath()) + "@100_100", closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@100_100", ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$WallPaper.document), false);
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.wallpapersNeedReload, tLRPC$WallPaper.slug);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$27$MessagesController(TLRPC$TL_theme tLRPC$TL_theme, final Theme.ThemeInfo themeInfo, TLRPC$TL_inputThemeSettings tLRPC$TL_inputThemeSettings, final Theme.ThemeAccent themeAccent, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        String name = tLRPC$TL_theme != null ? tLRPC$TL_theme.title : themeInfo.getName();
        int iLastIndexOf = name.lastIndexOf(".attheme");
        if (iLastIndexOf > 0) {
            name = name.substring(0, iLastIndexOf);
        }
        if (tLObject != null) {
            TLRPC$Document tLRPC$Document = (TLRPC$Document) tLObject;
            TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
            tLRPC$TL_inputDocument.access_hash = tLRPC$Document.access_hash;
            tLRPC$TL_inputDocument.id = tLRPC$Document.id;
            tLRPC$TL_inputDocument.file_reference = tLRPC$Document.file_reference;
            if (tLRPC$TL_theme == null || !tLRPC$TL_theme.creator) {
                TLRPC$TL_account_createTheme tLRPC$TL_account_createTheme = new TLRPC$TL_account_createTheme();
                tLRPC$TL_account_createTheme.document = tLRPC$TL_inputDocument;
                tLRPC$TL_account_createTheme.flags |= 4;
                tLRPC$TL_account_createTheme.slug = (tLRPC$TL_theme == null || TextUtils.isEmpty(tLRPC$TL_theme.slug)) ? "" : tLRPC$TL_theme.slug;
                tLRPC$TL_account_createTheme.title = name;
                if (tLRPC$TL_inputThemeSettings != null) {
                    tLRPC$TL_account_createTheme.settings = tLRPC$TL_inputThemeSettings;
                    tLRPC$TL_account_createTheme.flags |= 8;
                }
                getConnectionsManager().sendRequest(tLRPC$TL_account_createTheme, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$3X9KmVZH10xHditdQu-DktTTXYw
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                        this.f$0.lambda$didReceivedNotification$23$MessagesController(themeInfo, themeAccent, tLObject2, tLRPC$TL_error2);
                    }
                });
                return;
            }
            TLRPC$TL_account_updateTheme tLRPC$TL_account_updateTheme = new TLRPC$TL_account_updateTheme();
            TLRPC$TL_inputTheme tLRPC$TL_inputTheme = new TLRPC$TL_inputTheme();
            tLRPC$TL_inputTheme.id = tLRPC$TL_theme.id;
            tLRPC$TL_inputTheme.access_hash = tLRPC$TL_theme.access_hash;
            tLRPC$TL_account_updateTheme.theme = tLRPC$TL_inputTheme;
            tLRPC$TL_account_updateTheme.slug = tLRPC$TL_theme.slug;
            int i = tLRPC$TL_account_updateTheme.flags | 1;
            tLRPC$TL_account_updateTheme.flags = i;
            tLRPC$TL_account_updateTheme.title = name;
            int i2 = i | 2;
            tLRPC$TL_account_updateTheme.flags = i2;
            tLRPC$TL_account_updateTheme.document = tLRPC$TL_inputDocument;
            int i3 = i2 | 4;
            tLRPC$TL_account_updateTheme.flags = i3;
            if (tLRPC$TL_inputThemeSettings != null) {
                tLRPC$TL_account_updateTheme.settings = tLRPC$TL_inputThemeSettings;
                tLRPC$TL_account_updateTheme.flags = i3 | 8;
            }
            tLRPC$TL_account_updateTheme.format = "android";
            getConnectionsManager().sendRequest(tLRPC$TL_account_updateTheme, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$CdfzTU2nqeuOXCOoPU-mssE7OU8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$didReceivedNotification$25$MessagesController(themeInfo, themeAccent, tLObject2, tLRPC$TL_error2);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$WX81DZD2MSGX8aYOya6QDxWivDs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$26$MessagesController(themeInfo, themeAccent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$23$MessagesController(final Theme.ThemeInfo themeInfo, final Theme.ThemeAccent themeAccent, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$NB3Wa48k78gvPmvRQIopPf1_VCo
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f$0.lambda$didReceivedNotification$22$MessagesController(tLObject, themeInfo, themeAccent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$22$MessagesController(TLObject tLObject, Theme.ThemeInfo themeInfo, Theme.ThemeAccent themeAccent) throws JSONException {
        if (tLObject instanceof TLRPC$TL_theme) {
            Theme.setThemeUploadInfo(themeInfo, themeAccent, (TLRPC$TL_theme) tLObject, this.currentAccount, false);
            installTheme(themeInfo, themeAccent, themeInfo == Theme.getCurrentNightTheme());
            getNotificationCenter().postNotificationName(NotificationCenter.themeUploadedToServer, themeInfo, themeAccent);
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.themeUploadError, themeInfo, themeAccent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$25$MessagesController(final Theme.ThemeInfo themeInfo, final Theme.ThemeAccent themeAccent, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$mIjtvp7MvicOF19OJsRb7ZUZxpw
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f$0.lambda$didReceivedNotification$24$MessagesController(tLObject, themeInfo, themeAccent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$24$MessagesController(TLObject tLObject, Theme.ThemeInfo themeInfo, Theme.ThemeAccent themeAccent) throws JSONException {
        if (tLObject instanceof TLRPC$TL_theme) {
            Theme.setThemeUploadInfo(themeInfo, themeAccent, (TLRPC$TL_theme) tLObject, this.currentAccount, false);
            getNotificationCenter().postNotificationName(NotificationCenter.themeUploadedToServer, themeInfo, themeAccent);
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.themeUploadError, themeInfo, themeAccent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$26$MessagesController(Theme.ThemeInfo themeInfo, Theme.ThemeAccent themeAccent) {
        getNotificationCenter().postNotificationName(NotificationCenter.themeUploadError, themeInfo, themeAccent);
    }

    public void cleanup() throws InterruptedException {
        getContactsController().cleanup();
        MediaController.getInstance().cleanup();
        getNotificationsController().cleanup();
        getSendMessagesHelper().cleanup();
        getSecretChatHelper().cleanup();
        getLocationController().cleanup();
        getMediaDataController().cleanup();
        this.showFiltersTooltip = false;
        DialogsActivity.dialogsLoaded[this.currentAccount] = false;
        this.notificationsPreferences.edit().clear().commit();
        this.emojiPreferences.edit().putLong("lastGifLoadTime", 0L).putLong("lastStickersLoadTime", 0L).putLong("lastStickersLoadTimeMask", 0L).putLong("lastStickersLoadTimeFavs", 0L).commit();
        this.mainPreferences.edit().remove("archivehint").remove("proximityhint").remove("archivehint_l").remove("gifhint").remove("reminderhint").remove("soundHint").remove("dcDomainName2").remove("webFileDatacenterId").remove("themehint").remove("showFiltersTooltip").commit();
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
            editorEdit.commit();
        }
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ChatsWidgetProvider.updateWidget(ApplicationLoader.applicationContext, appWidgetManager, ((Integer) arrayList.get(i)).intValue());
            }
        }
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ContactsWidgetProvider.updateWidget(ApplicationLoader.applicationContext, appWidgetManager, ((Integer) arrayList2.get(i2)).intValue());
            }
        }
        this.lastScheduledServerQueryTime.clear();
        this.lastServerQueryTime.clear();
        this.reloadingWebpages.clear();
        this.reloadingWebpagesPending.clear();
        this.reloadingScheduledWebpages.clear();
        this.reloadingScheduledWebpagesPending.clear();
        this.sponsoredMessages.clear();
        this.dialogs_dict.clear();
        this.dialogs_read_inbox_max.clear();
        this.loadingPinnedDialogs.clear();
        this.dialogs_read_outbox_max.clear();
        this.exportedChats.clear();
        this.fullUsers.clear();
        this.fullChats.clear();
        this.activeVoiceChatsMap.clear();
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
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$FKtVBn97w9YfJyZ_JEuA_zWt-j8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$28$MessagesController();
            }
        });
        this.createdDialogMainThreadIds.clear();
        this.visibleDialogMainThreadIds.clear();
        this.visibleScheduledDialogMainThreadIds.clear();
        this.blockePeers.clear();
        int i3 = 0;
        while (true) {
            LongSparseArray<SparseArray<Boolean>>[] longSparseArrayArr = this.sendingTypings;
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
        this.checkingDialogAd = false;
        this.nextDialogAdCheckTime = 0;
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
        this.currentDeletingTaskMediaMids = null;
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
        this.livesToCheck.clear();
        this.livesToCheckSize = 0;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Lvqo4mB6mCE03urNQbj-3k5GJlc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$29$MessagesController();
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
    /* renamed from: lambda$cleanup$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanup$28$MessagesController() {
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
    /* renamed from: lambda$cleanup$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanup$29$MessagesController() {
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

    public TLRPC$User getUser(Long id) {
        return (TLRPC$User) this.users.get(id);
    }

    public TLObject getUserOrChat(String username) {
        if (username == null || username.length() == 0) {
            return null;
        }
        return (TLObject) this.objectsByUsernames.get(username.toLowerCase());
    }

    public ConcurrentHashMap<Long, TLRPC$User> getUsers() {
        return this.users;
    }

    public ConcurrentHashMap<Long, TLRPC$Chat> getChats() {
        return this.chats;
    }

    public TLRPC$Chat getChat(Long id) {
        return (TLRPC$Chat) this.chats.get(id);
    }

    public TLRPC$EncryptedChat getEncryptedChat(Integer id) {
        return (TLRPC$EncryptedChat) this.encryptedChats.get(id);
    }

    public TLRPC$EncryptedChat getEncryptedChatDB(int chatId, boolean created) throws InterruptedException {
        TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) this.encryptedChats.get(Integer.valueOf(chatId));
        if (tLRPC$EncryptedChat != null) {
            if (!created) {
                return tLRPC$EncryptedChat;
            }
            if (!(tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatWaiting) && !(tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatRequested)) {
                return tLRPC$EncryptedChat;
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ArrayList<TLObject> arrayList = new ArrayList<>();
        getMessagesStorage().getEncryptedChat(chatId, countDownLatch, arrayList);
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

    public boolean isDialogVisible(long dialogId, boolean scheduled) {
        return (scheduled ? this.visibleScheduledDialogMainThreadIds : this.visibleDialogMainThreadIds).contains(Long.valueOf(dialogId));
    }

    public void setLastVisibleDialogId(final long dialogId, boolean scheduled, boolean set) {
        ArrayList<Long> arrayList = scheduled ? this.visibleScheduledDialogMainThreadIds : this.visibleDialogMainThreadIds;
        if (set) {
            if (arrayList.contains(Long.valueOf(dialogId))) {
                return;
            }
            arrayList.add(Long.valueOf(dialogId));
            return;
        }
        arrayList.remove(Long.valueOf(dialogId));
    }

    public void setLastCreatedDialogId(final long dialogId, final boolean scheduled, final boolean set) {
        if (!scheduled) {
            ArrayList<Long> arrayList = this.createdDialogMainThreadIds;
            if (set) {
                if (arrayList.contains(Long.valueOf(dialogId))) {
                    return;
                } else {
                    arrayList.add(Long.valueOf(dialogId));
                }
            } else {
                SparseArray<MessageObject> sparseArray = this.livesToCheck.get(dialogId);
                if (sparseArray != null) {
                    int size = sparseArray.size();
                    for (int i = 0; i < size; i++) {
                        sparseArray.valueAt(i).liveVisibleOnScreen = false;
                    }
                }
                arrayList.remove(Long.valueOf(dialogId));
                SparseArray<MessageObject> sparseArray2 = this.pollsToCheck.get(dialogId);
                if (sparseArray2 != null) {
                    int size2 = sparseArray2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        sparseArray2.valueAt(i2).pollVisibleOnScreen = false;
                    }
                }
            }
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$pL9TM9CdhS2GYh6EicdbhvwRDbA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setLastCreatedDialogId$30$MessagesController(scheduled, set, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setLastCreatedDialogId$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setLastCreatedDialogId$30$MessagesController(boolean z, boolean z2, long j) {
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

    public TLRPC$TL_chatInviteExported getExportedInvite(long chatId) {
        return this.exportedChats.get(chatId);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean putUser(ir.eitaa.tgnet.TLRPC$User r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.putUser(ir.eitaa.tgnet.TLRPC$User, boolean):boolean");
    }

    public void putUsers(ArrayList<TLRPC$User> users, boolean fromCache) {
        if (users == null || users.isEmpty()) {
            return;
        }
        int size = users.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            if (putUser(users.get(i), fromCache)) {
                z = true;
            }
        }
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$swTfApQpepnDUjTrn6MUUGyt_Mg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putUsers$31$MessagesController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putUsers$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putUsers$31$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_STATUS));
    }

    public void putChat(final TLRPC$Chat chat, boolean fromCache) {
        TLRPC$Chat tLRPC$Chat;
        ArrayList<TLRPC$TL_restrictionReason> arrayList;
        if (chat == null || (tLRPC$Chat = (TLRPC$Chat) this.chats.get(Long.valueOf(chat.id))) == chat) {
            return;
        }
        if (tLRPC$Chat != null && !TextUtils.isEmpty(tLRPC$Chat.username)) {
            this.objectsByUsernames.remove(tLRPC$Chat.username.toLowerCase());
        }
        if (!TextUtils.isEmpty(chat.username)) {
            this.objectsByUsernames.put(chat.username.toLowerCase(), chat);
        }
        if (chat.min) {
            if (tLRPC$Chat == null) {
                this.chats.put(Long.valueOf(chat.id), chat);
                addOrRemoveActiveVoiceChat(chat);
                return;
            }
            if (fromCache) {
                return;
            }
            tLRPC$Chat.title = chat.title;
            tLRPC$Chat.photo = chat.photo;
            tLRPC$Chat.broadcast = chat.broadcast;
            tLRPC$Chat.verified = chat.verified;
            tLRPC$Chat.megagroup = chat.megagroup;
            tLRPC$Chat.call_not_empty = chat.call_not_empty;
            tLRPC$Chat.call_active = chat.call_active;
            boolean z = chat.restricted;
            tLRPC$Chat.restricted = z;
            if (!z && (arrayList = tLRPC$Chat.restriction_reason) != null) {
                arrayList.clear();
            } else if (z && chat.restriction_reason != null) {
                for (int i = 0; i < chat.restriction_reason.size(); i++) {
                    ArrayList<TLRPC$TL_restrictionReason> arrayList2 = tLRPC$Chat.restriction_reason;
                    if (arrayList2 == null) {
                        ArrayList<TLRPC$TL_restrictionReason> arrayList3 = new ArrayList<>();
                        tLRPC$Chat.restriction_reason = arrayList3;
                        arrayList3.add(chat.restriction_reason.get(i));
                    } else {
                        if (i == 0) {
                            arrayList2.clear();
                        }
                        tLRPC$Chat.restriction_reason.add(chat.restriction_reason.get(i));
                    }
                }
            }
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = chat.default_banned_rights;
            if (tLRPC$TL_chatBannedRights != null) {
                tLRPC$Chat.default_banned_rights = tLRPC$TL_chatBannedRights;
                tLRPC$Chat.flags |= 262144;
            }
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = chat.admin_rights;
            if (tLRPC$TL_chatAdminRights != null) {
                tLRPC$Chat.admin_rights = tLRPC$TL_chatAdminRights;
                tLRPC$Chat.flags |= 16384;
            }
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = chat.banned_rights;
            if (tLRPC$TL_chatBannedRights2 != null) {
                tLRPC$Chat.banned_rights = tLRPC$TL_chatBannedRights2;
                tLRPC$Chat.flags |= 32768;
            }
            String str = chat.username;
            if (str != null) {
                tLRPC$Chat.username = str;
                tLRPC$Chat.flags |= 64;
            } else {
                tLRPC$Chat.flags &= -65;
                tLRPC$Chat.username = null;
            }
            int i2 = chat.participants_count;
            if (i2 != 0) {
                tLRPC$Chat.participants_count = i2;
            }
            int i3 = chat.live_stream_msg_id;
            if (i3 != 0) {
                tLRPC$Chat.live_stream_msg_id = i3;
                tLRPC$Chat.flags |= 536870912;
            } else {
                tLRPC$Chat.flags &= -536870913;
                tLRPC$Chat.live_stream_msg_id = 0;
            }
            addOrRemoveActiveVoiceChat(tLRPC$Chat);
            return;
        }
        if (!fromCache) {
            if (tLRPC$Chat != null) {
                if (chat.version != tLRPC$Chat.version) {
                    this.loadedFullChats.remove(Long.valueOf(chat.id));
                }
                int i4 = tLRPC$Chat.participants_count;
                if (i4 != 0 && chat.participants_count == 0) {
                    chat.participants_count = i4;
                    chat.flags |= 131072;
                }
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights3 = tLRPC$Chat.banned_rights;
                int i5 = tLRPC$TL_chatBannedRights3 != null ? tLRPC$TL_chatBannedRights3.flags : 0;
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights4 = chat.banned_rights;
                int i6 = tLRPC$TL_chatBannedRights4 != null ? tLRPC$TL_chatBannedRights4.flags : 0;
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights5 = tLRPC$Chat.default_banned_rights;
                int i7 = tLRPC$TL_chatBannedRights5 != null ? tLRPC$TL_chatBannedRights5.flags : 0;
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights6 = chat.default_banned_rights;
                int i8 = tLRPC$TL_chatBannedRights6 != null ? tLRPC$TL_chatBannedRights6.flags : 0;
                tLRPC$Chat.default_banned_rights = tLRPC$TL_chatBannedRights6;
                if (tLRPC$TL_chatBannedRights6 == null) {
                    tLRPC$Chat.flags &= -262145;
                } else {
                    tLRPC$Chat.flags |= 262144;
                }
                tLRPC$Chat.banned_rights = tLRPC$TL_chatBannedRights4;
                if (tLRPC$TL_chatBannedRights4 == null) {
                    tLRPC$Chat.flags &= -32769;
                } else {
                    tLRPC$Chat.flags |= 32768;
                }
                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2 = chat.admin_rights;
                tLRPC$Chat.admin_rights = tLRPC$TL_chatAdminRights2;
                if (tLRPC$TL_chatAdminRights2 == null) {
                    tLRPC$Chat.flags &= -16385;
                } else {
                    tLRPC$Chat.flags |= 16384;
                }
                if (i5 != i6 || i7 != i8) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$hwQKxzj0AitmJJHvTlgmM8US6iI
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$putChat$32$MessagesController(chat);
                        }
                    });
                }
            }
            this.chats.put(Long.valueOf(chat.id), chat);
        } else if (tLRPC$Chat == null) {
            this.chats.put(Long.valueOf(chat.id), chat);
        } else if (tLRPC$Chat.min) {
            chat.title = tLRPC$Chat.title;
            chat.photo = tLRPC$Chat.photo;
            chat.broadcast = tLRPC$Chat.broadcast;
            chat.verified = tLRPC$Chat.verified;
            chat.megagroup = tLRPC$Chat.megagroup;
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights7 = tLRPC$Chat.default_banned_rights;
            if (tLRPC$TL_chatBannedRights7 != null) {
                chat.default_banned_rights = tLRPC$TL_chatBannedRights7;
                chat.flags |= 262144;
            }
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights3 = tLRPC$Chat.admin_rights;
            if (tLRPC$TL_chatAdminRights3 != null) {
                chat.admin_rights = tLRPC$TL_chatAdminRights3;
                chat.flags |= 16384;
            }
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights8 = tLRPC$Chat.banned_rights;
            if (tLRPC$TL_chatBannedRights8 != null) {
                chat.banned_rights = tLRPC$TL_chatBannedRights8;
                chat.flags |= 32768;
            }
            String str2 = tLRPC$Chat.username;
            if (str2 != null) {
                chat.username = str2;
                chat.flags |= 64;
            } else {
                chat.flags &= -65;
                chat.username = null;
            }
            int i9 = tLRPC$Chat.participants_count;
            if (i9 != 0 && chat.participants_count == 0) {
                chat.participants_count = i9;
                chat.flags |= 131072;
            }
            int i10 = tLRPC$Chat.live_stream_msg_id;
            if (i10 != 0) {
                chat.live_stream_msg_id = i10;
                chat.flags |= 536870912;
            } else {
                chat.flags &= -536870913;
                chat.live_stream_msg_id = 0;
            }
            this.chats.put(Long.valueOf(chat.id), chat);
        }
        addOrRemoveActiveVoiceChat(chat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putChat$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putChat$32$MessagesController(TLRPC$Chat tLRPC$Chat) {
        getNotificationCenter().postNotificationName(NotificationCenter.channelRightsUpdated, tLRPC$Chat);
    }

    public void putChats(ArrayList<TLRPC$Chat> chats, boolean fromCache) {
        if (chats == null || chats.isEmpty()) {
            return;
        }
        int size = chats.size();
        for (int i = 0; i < size; i++) {
            putChat(chats.get(i), fromCache);
        }
    }

    private void addOrRemoveActiveVoiceChat(final TLRPC$Chat chat) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$VLauwLBcLE86HODvgpJ_qXI_sfc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addOrRemoveActiveVoiceChat$33$MessagesController(chat);
                }
            });
        } else {
            lambda$addOrRemoveActiveVoiceChat$33(chat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addOrRemoveActiveVoiceChatInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$addOrRemoveActiveVoiceChat$33$MessagesController(TLRPC$Chat chat) {
        TLRPC$Chat tLRPC$Chat = this.activeVoiceChatsMap.get(Long.valueOf(chat.id));
        if (chat.call_active && chat.call_not_empty && chat.migrated_to == null && !ChatObject.isNotInChat(chat)) {
            if (tLRPC$Chat != null) {
                return;
            }
            this.activeVoiceChatsMap.put(Long.valueOf(chat.id), chat);
            getNotificationCenter().postNotificationName(NotificationCenter.activeGroupCallsUpdated, new Object[0]);
            return;
        }
        if (tLRPC$Chat == null) {
            return;
        }
        this.activeVoiceChatsMap.remove(Long.valueOf(chat.id));
        getNotificationCenter().postNotificationName(NotificationCenter.activeGroupCallsUpdated, new Object[0]);
    }

    public ArrayList<Long> getActiveGroupCalls() {
        return new ArrayList<>(this.activeVoiceChatsMap.keySet());
    }

    public void setReferer(String referer) {
        if (referer == null) {
            return;
        }
        this.installReferer = referer;
        this.mainPreferences.edit().putString("installReferer", referer).commit();
    }

    public void putEncryptedChat(TLRPC$EncryptedChat encryptedChat, boolean fromCache) {
        if (encryptedChat == null) {
            return;
        }
        if (fromCache) {
            this.encryptedChats.putIfAbsent(Integer.valueOf(encryptedChat.id), encryptedChat);
        } else {
            this.encryptedChats.put(Integer.valueOf(encryptedChat.id), encryptedChat);
        }
    }

    public void putEncryptedChats(ArrayList<TLRPC$EncryptedChat> encryptedChats, boolean fromCache) {
        if (encryptedChats == null || encryptedChats.isEmpty()) {
            return;
        }
        int size = encryptedChats.size();
        for (int i = 0; i < size; i++) {
            putEncryptedChat(encryptedChats.get(i), fromCache);
        }
    }

    public TLRPC$UserFull getUserFull(long uid) {
        return this.fullUsers.get(uid);
    }

    public TLRPC$ChatFull getChatFull(long chatId) {
        return this.fullChats.get(chatId);
    }

    public void putGroupCall(long chatId, ChatObject.Call call) {
        this.groupCalls.put(call.call.id, call);
        this.groupCallsByChatId.put(chatId, call);
        TLRPC$ChatFull chatFull = getChatFull(chatId);
        if (chatFull != null) {
            chatFull.call = call.getInputGroupCall();
        }
        getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(chatId), Long.valueOf(call.call.id), Boolean.FALSE);
        loadFullChat(chatId, 0, true);
    }

    public ChatObject.Call getGroupCall(long chatId, boolean load) {
        return getGroupCall(chatId, load, null);
    }

    public ChatObject.Call getGroupCall(final long chatId, boolean load, final Runnable onLoad) {
        TLRPC$TL_inputGroupCall tLRPC$TL_inputGroupCall;
        TLRPC$ChatFull chatFull = getChatFull(chatId);
        if (chatFull == null || (tLRPC$TL_inputGroupCall = chatFull.call) == null) {
            return null;
        }
        ChatObject.Call call = this.groupCalls.get(tLRPC$TL_inputGroupCall.id);
        if (call == null && load && !this.loadingGroupCalls.contains(Long.valueOf(chatId))) {
            this.loadingGroupCalls.add(Long.valueOf(chatId));
            if (chatFull.call != null) {
                TLRPC$TL_phone_getGroupCall tLRPC$TL_phone_getGroupCall = new TLRPC$TL_phone_getGroupCall();
                tLRPC$TL_phone_getGroupCall.call = chatFull.call;
                tLRPC$TL_phone_getGroupCall.limit = 20;
                getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupCall, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$IxeJE1u3jH0mr0SbryfM3tTFhCE
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$getGroupCall$35$MessagesController(chatId, onLoad, tLObject, tLRPC$TL_error);
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
    /* renamed from: lambda$getGroupCall$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getGroupCall$35$MessagesController(final long j, final Runnable runnable, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$RM56nxl5JLc1f-pMvvSGg_KBK3A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getGroupCall$34$MessagesController(tLObject, j, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getGroupCall$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getGroupCall$34$MessagesController(TLObject tLObject, long j, Runnable runnable) {
        if (tLObject != null) {
            TLRPC$TL_phone_groupCall tLRPC$TL_phone_groupCall = (TLRPC$TL_phone_groupCall) tLObject;
            putUsers(tLRPC$TL_phone_groupCall.users, false);
            putChats(tLRPC$TL_phone_groupCall.chats, false);
            ChatObject.Call call = new ChatObject.Call();
            call.setCall(getAccountInstance(), j, tLRPC$TL_phone_groupCall);
            this.groupCalls.put(tLRPC$TL_phone_groupCall.call.id, call);
            this.groupCallsByChatId.put(j, call);
            getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(j), Long.valueOf(tLRPC$TL_phone_groupCall.call.id), Boolean.FALSE);
            if (runnable != null) {
                runnable.run();
            }
        }
        this.loadingGroupCalls.remove(Long.valueOf(j));
    }

    public void cancelLoadFullUser(long userId) {
        this.loadingFullUsers.remove(Long.valueOf(userId));
    }

    public void cancelLoadFullChat(long chatId) {
        this.loadingFullChats.remove(Long.valueOf(chatId));
    }

    protected void clearFullUsers() {
        this.loadedFullUsers.clear();
        this.loadedFullChats.clear();
    }

    private void reloadDialogsReadValue(ArrayList<TLRPC$Dialog> dialogs, long did) {
        if (did == 0 && (dialogs == null || dialogs.isEmpty())) {
            return;
        }
        TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs = new TLRPC$TL_messages_getPeerDialogs();
        if (dialogs != null) {
            for (int i = 0; i < dialogs.size(); i++) {
                TLRPC$InputPeer inputPeer = getInputPeer(dialogs.get(i).id);
                if (!(inputPeer instanceof TLRPC$TL_inputPeerChannel) || inputPeer.access_hash != 0) {
                    new TLRPC$TL_inputDialogPeer().peer = inputPeer;
                    tLRPC$TL_messages_getPeerDialogs.peers.add(inputPeer);
                }
            }
        } else {
            TLRPC$InputPeer inputPeer2 = getInputPeer(did);
            if ((inputPeer2 instanceof TLRPC$TL_inputPeerChannel) && inputPeer2.access_hash == 0) {
                return;
            }
            new TLRPC$TL_inputDialogPeer().peer = inputPeer2;
            tLRPC$TL_messages_getPeerDialogs.peers.add(inputPeer2);
        }
        if (tLRPC$TL_messages_getPeerDialogs.peers.isEmpty()) {
            return;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$2U_MW3txsc5ZGidARI6i8gpyeiY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
                this.f$0.lambda$reloadDialogsReadValue$36$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadDialogsReadValue$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadDialogsReadValue$36$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
        if (tLObject != null) {
            TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = (TLRPC$TL_messages_peerDialogs) tLObject;
            ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
            for (int i = 0; i < tLRPC$TL_messages_peerDialogs.dialogs.size(); i++) {
                TLRPC$Dialog tLRPC$Dialog = tLRPC$TL_messages_peerDialogs.dialogs.get(i);
                DialogObject.initDialog(tLRPC$Dialog);
                Integer num = (Integer) this.dialogs_read_inbox_max.get(Long.valueOf(tLRPC$Dialog.id));
                if (num == null) {
                    num = 0;
                }
                this.dialogs_read_inbox_max.put(Long.valueOf(tLRPC$Dialog.id), Integer.valueOf(Math.max(tLRPC$Dialog.read_inbox_max_id, num.intValue())));
                if (num.intValue() == 0) {
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
                Integer num2 = (Integer) this.dialogs_read_outbox_max.get(Long.valueOf(tLRPC$Dialog.id));
                if (num2 == null) {
                    num2 = 0;
                }
                this.dialogs_read_outbox_max.put(Long.valueOf(tLRPC$Dialog.id), Integer.valueOf(Math.max(tLRPC$Dialog.read_outbox_max_id, num2.intValue())));
                if (tLRPC$Dialog.read_outbox_max_id > num2.intValue()) {
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

    public TLRPC$ChannelParticipant getAdminInChannel(long uid, long chatId) {
        LongSparseArray<TLRPC$ChannelParticipant> longSparseArray = this.channelAdmins.get(chatId);
        if (longSparseArray == null) {
            return null;
        }
        return longSparseArray.get(uid);
    }

    public String getAdminRank(long chatId, long uid) {
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant;
        LongSparseArray<TLRPC$ChannelParticipant> longSparseArray = this.channelAdmins.get(chatId);
        if (longSparseArray == null || (tLRPC$ChannelParticipant = longSparseArray.get(uid)) == null) {
            return null;
        }
        String str = tLRPC$ChannelParticipant.rank;
        return str != null ? str : "";
    }

    public boolean isChannelAdminsLoaded(long chatId) {
        return this.channelAdmins.get(chatId) != null;
    }

    public void loadChannelAdmins(final long chatId, boolean cache) {
        if ((SystemClock.elapsedRealtime() / 1000) - this.loadingChannelAdmins.get(chatId) < 120) {
            return;
        }
        this.loadingChannelAdmins.put(chatId, (int) (SystemClock.elapsedRealtime() / 1000));
        if (cache) {
            getMessagesStorage().loadChannelAdmins(chatId);
            return;
        }
        TLRPC$TL_channels_getParticipants_2 tLRPC$TL_channels_getParticipants_2 = new TLRPC$TL_channels_getParticipants_2();
        tLRPC$TL_channels_getParticipants_2.channel = getInputChannel(chatId);
        tLRPC$TL_channels_getParticipants_2.limit = 100;
        tLRPC$TL_channels_getParticipants_2.filter = new TLRPC$TL_channelParticipantsAdmins();
        getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipants_2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$FDZo-XiPrTLZJy-H5GWev0pX3uk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadChannelAdmins$37$MessagesController(chatId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChannelAdmins$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChannelAdmins$37$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_channels_channelParticipants) {
            processLoadedAdminsResponse(j, (TLRPC$TL_channels_channelParticipants) tLObject);
        }
    }

    public void processLoadedAdminsResponse(long chatId, TLRPC$TL_channels_channelParticipants participants) {
        LongSparseArray<TLRPC$ChannelParticipant> longSparseArray = new LongSparseArray<>(participants.participants.size());
        for (int i = 0; i < participants.participants.size(); i++) {
            TLRPC$ChannelParticipant tLRPC$ChannelParticipant = participants.participants.get(i);
            longSparseArray.put(MessageObject.getPeerId(tLRPC$ChannelParticipant.peer), tLRPC$ChannelParticipant);
        }
        processLoadedChannelAdmins(longSparseArray, chatId, false);
    }

    public void processLoadedChannelAdmins(final LongSparseArray<TLRPC$ChannelParticipant> array, final long chatId, final boolean cache) {
        if (!cache) {
            getMessagesStorage().putChannelAdmins(chatId, array);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xyFMBQnEMYhDhSiUgG7_mdiQ-t8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedChannelAdmins$38$MessagesController(chatId, array, cache);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedChannelAdmins$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedChannelAdmins$38$MessagesController(long j, LongSparseArray longSparseArray, boolean z) {
        this.channelAdmins.put(j, longSparseArray);
        if (z) {
            this.loadingChannelAdmins.delete(j);
            loadChannelAdmins(j, false);
            getNotificationCenter().postNotificationName(NotificationCenter.didLoadChatAdmins, Long.valueOf(j));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadFullChat(final long r11, final int r13, boolean r14) {
        /*
            r10 = this;
            java.util.ArrayList<java.lang.Long> r0 = r10.loadedFullChats
            java.lang.Long r1 = java.lang.Long.valueOf(r11)
            boolean r0 = r0.contains(r1)
            java.util.ArrayList<java.lang.Long> r1 = r10.loadingFullChats
            java.lang.Long r2 = java.lang.Long.valueOf(r11)
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L81
            if (r14 != 0) goto L1b
            if (r0 == 0) goto L1b
            goto L81
        L1b:
            java.util.ArrayList<java.lang.Long> r14 = r10.loadingFullChats
            java.lang.Long r1 = java.lang.Long.valueOf(r11)
            r14.add(r1)
            long r5 = -r11
            java.lang.Long r14 = java.lang.Long.valueOf(r11)
            ir.eitaa.tgnet.TLRPC$Chat r4 = r10.getChat(r14)
            boolean r14 = ir.eitaa.messenger.ChatObject.isChannel(r4)
            if (r14 == 0) goto L44
            ir.eitaa.tgnet.TLRPC$TL_channels_getFullChannel r14 = new ir.eitaa.tgnet.TLRPC$TL_channels_getFullChannel
            r14.<init>()
            ir.eitaa.tgnet.TLRPC$InputChannel r1 = getInputChannel(r4)
            r14.channel = r1
            r0 = r0 ^ 1
            r10.loadChannelAdmins(r11, r0)
            goto L67
        L44:
            ir.eitaa.tgnet.TLRPC$TL_messages_getFullChat r14 = new ir.eitaa.tgnet.TLRPC$TL_messages_getFullChat
            r14.<init>()
            r14.chat_id = r11
            j$.util.concurrent.ConcurrentHashMap<java.lang.Long, java.lang.Integer> r0 = r10.dialogs_read_inbox_max
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L63
            j$.util.concurrent.ConcurrentHashMap<java.lang.Long, java.lang.Integer> r0 = r10.dialogs_read_outbox_max
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.Object r0 = r0.get(r1)
            if (r0 != 0) goto L67
        L63:
            r0 = 0
            r10.reloadDialogsReadValue(r0, r5)
        L67:
            ir.eitaa.tgnet.ConnectionsManager r0 = r10.getConnectionsManager()
            ir.eitaa.messenger.-$$Lambda$MessagesController$6Mr3nnNbs3K8TBXLE7XNl8Y5w0o r1 = new ir.eitaa.messenger.-$$Lambda$MessagesController$6Mr3nnNbs3K8TBXLE7XNl8Y5w0o
            r2 = r1
            r3 = r10
            r7 = r11
            r9 = r13
            r2.<init>()
            int r11 = r0.sendRequest(r14, r1)
            if (r13 == 0) goto L81
            ir.eitaa.tgnet.ConnectionsManager r12 = r10.getConnectionsManager()
            r12.bindRequestToGuid(r11, r13)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.loadFullChat(long, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFullChat$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFullChat$41$MessagesController(TLRPC$Chat tLRPC$Chat, long j, final long j2, final int i, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
        if (tLRPC$TL_error == null) {
            final TLRPC$TL_messages_chatFull tLRPC$TL_messages_chatFull = (TLRPC$TL_messages_chatFull) tLObject;
            getMessagesStorage().putUsersAndChats(tLRPC$TL_messages_chatFull.users, tLRPC$TL_messages_chatFull.chats, true, true);
            getMessagesStorage().updateChatInfo(tLRPC$TL_messages_chatFull.full_chat, false);
            if (ChatObject.isChannel(tLRPC$Chat)) {
                Integer numValueOf = (Integer) this.dialogs_read_inbox_max.get(Long.valueOf(j));
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(getMessagesStorage().getDialogReadMax(false, j));
                }
                this.dialogs_read_inbox_max.put(Long.valueOf(j), Integer.valueOf(Math.max(tLRPC$TL_messages_chatFull.full_chat.read_inbox_max_id, numValueOf.intValue())));
                if (tLRPC$TL_messages_chatFull.full_chat.read_inbox_max_id > numValueOf.intValue()) {
                    ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
                    TLRPC$TL_updateReadChannelInbox tLRPC$TL_updateReadChannelInbox = new TLRPC$TL_updateReadChannelInbox();
                    tLRPC$TL_updateReadChannelInbox.channel_id = j2;
                    tLRPC$TL_updateReadChannelInbox.max_id = tLRPC$TL_messages_chatFull.full_chat.read_inbox_max_id;
                    arrayList.add(tLRPC$TL_updateReadChannelInbox);
                    processUpdateArray(arrayList, null, null, false, 0);
                }
                Integer numValueOf2 = (Integer) this.dialogs_read_outbox_max.get(Long.valueOf(j));
                if (numValueOf2 == null) {
                    numValueOf2 = Integer.valueOf(getMessagesStorage().getDialogReadMax(true, j));
                }
                this.dialogs_read_outbox_max.put(Long.valueOf(j), Integer.valueOf(Math.max(tLRPC$TL_messages_chatFull.full_chat.read_outbox_max_id, numValueOf2.intValue())));
                if (tLRPC$TL_messages_chatFull.full_chat.read_outbox_max_id > numValueOf2.intValue()) {
                    ArrayList<TLRPC$Update> arrayList2 = new ArrayList<>();
                    TLRPC$TL_updateReadChannelOutbox tLRPC$TL_updateReadChannelOutbox = new TLRPC$TL_updateReadChannelOutbox();
                    tLRPC$TL_updateReadChannelOutbox.channel_id = j2;
                    tLRPC$TL_updateReadChannelOutbox.max_id = tLRPC$TL_messages_chatFull.full_chat.read_outbox_max_id;
                    arrayList2.add(tLRPC$TL_updateReadChannelOutbox);
                    processUpdateArray(arrayList2, null, null, false, 0);
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$9mHmF8lJn-erjdPnfglbcbI_oyw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadFullChat$39$MessagesController(j2, tLRPC$TL_messages_chatFull, i);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$MhoSnRQ-z5cFvH0hVA9d-6nfUcI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFullChat$40$MessagesController(tLRPC$TL_error, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFullChat$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFullChat$39$MessagesController(long j, TLRPC$TL_messages_chatFull tLRPC$TL_messages_chatFull, int i) {
        TLRPC$Dialog tLRPC$Dialog;
        TLRPC$ChatFull tLRPC$ChatFull = this.fullChats.get(j);
        if (tLRPC$ChatFull != null) {
            tLRPC$TL_messages_chatFull.full_chat.inviterId = tLRPC$ChatFull.inviterId;
        }
        this.fullChats.put(j, tLRPC$TL_messages_chatFull.full_chat);
        long j2 = -j;
        applyDialogNotificationsSettings(j2, tLRPC$TL_messages_chatFull.full_chat.notify_settings);
        for (int i2 = 0; i2 < tLRPC$TL_messages_chatFull.full_chat.bot_info.size(); i2++) {
            getMediaDataController().putBotInfo(j2, tLRPC$TL_messages_chatFull.full_chat.bot_info.get(i2));
        }
        int iIndexOfKey = this.blockePeers.indexOfKey(j2);
        if (tLRPC$TL_messages_chatFull.full_chat.blocked) {
            if (iIndexOfKey < 0) {
                this.blockePeers.put(j2, 1);
                getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
            }
        } else if (iIndexOfKey >= 0) {
            this.blockePeers.removeAt(iIndexOfKey);
            getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        }
        this.loadingFullChats.remove(Long.valueOf(j));
        this.loadedFullChats.add(Long.valueOf(j));
        putUsers(tLRPC$TL_messages_chatFull.users, false);
        putChats(tLRPC$TL_messages_chatFull.chats, false);
        if (tLRPC$TL_messages_chatFull.full_chat.stickerset != null) {
            getMediaDataController().getGroupStickerSetById(tLRPC$TL_messages_chatFull.full_chat.stickerset);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.chatInfoDidLoad, tLRPC$TL_messages_chatFull.full_chat, Integer.valueOf(i), Boolean.FALSE, Boolean.TRUE);
        if ((tLRPC$TL_messages_chatFull.full_chat.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) == 0 || (tLRPC$Dialog = this.dialogs_dict.get(j2)) == null) {
            return;
        }
        int i3 = tLRPC$Dialog.folder_id;
        int i4 = tLRPC$TL_messages_chatFull.full_chat.folder_id;
        if (i3 != i4) {
            tLRPC$Dialog.folder_id = i4;
            sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFullChat$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFullChat$40$MessagesController(TLRPC$TL_error tLRPC$TL_error, long j) {
        checkChannelError(tLRPC$TL_error.text, j);
        this.loadingFullChats.remove(Long.valueOf(j));
    }

    public void loadFullUser(final TLRPC$User user, final int classGuid, boolean force) {
        if (user == null || this.loadingFullUsers.contains(Long.valueOf(user.id))) {
            return;
        }
        if (force || !this.loadedFullUsers.contains(Long.valueOf(user.id))) {
            this.loadingFullUsers.add(Long.valueOf(user.id));
            TLRPC$TL_users_getFullUser tLRPC$TL_users_getFullUser = new TLRPC$TL_users_getFullUser();
            tLRPC$TL_users_getFullUser.id = getInputUser(user);
            long j = user.id;
            if (this.dialogs_read_inbox_max.get(Long.valueOf(j)) == null || this.dialogs_read_outbox_max.get(Long.valueOf(j)) == null) {
                reloadDialogsReadValue(null, j);
            }
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_users_getFullUser, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$TLNj3HDLRys4Uv4zRLEWoETSEPY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadFullUser$44$MessagesController(user, classGuid, tLObject, tLRPC$TL_error);
                }
            }), classGuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFullUser$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFullUser$44$MessagesController(final TLRPC$User tLRPC$User, final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            final TLRPC$UserFull tLRPC$UserFull = (TLRPC$UserFull) tLObject;
            getMessagesStorage().updateUserInfo(tLRPC$UserFull, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$MQ3-O2nNBgZxunCXFpSroCpgT_g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadFullUser$42$MessagesController(tLRPC$UserFull, tLRPC$User, i);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Y-tWIp8QB4CgsfvOY8VQ5nFcGs4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFullUser$43$MessagesController(tLRPC$User);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFullUser$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFullUser$42$MessagesController(TLRPC$UserFull tLRPC$UserFull, TLRPC$User tLRPC$User, int i) {
        TLRPC$Dialog tLRPC$Dialog;
        if (tLRPC$UserFull.bot_info instanceof TLRPC$TL_botInfo) {
            getMediaDataController().putBotInfo(tLRPC$User.id, tLRPC$UserFull.bot_info);
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
        this.loadingFullUsers.remove(Long.valueOf(tLRPC$User.id));
        this.loadedFullUsers.add(Long.valueOf(tLRPC$User.id));
        String str = tLRPC$User.first_name + tLRPC$User.last_name + tLRPC$User.username;
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$UserFull.user);
        putUsers(arrayList, false);
        getMessagesStorage().putUsersAndChats(arrayList, null, false, true);
        if (!str.equals(tLRPC$UserFull.user.first_name + tLRPC$UserFull.user.last_name + tLRPC$UserFull.user.username)) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_NAME));
        }
        if (tLRPC$UserFull.bot_info instanceof TLRPC$TL_botInfo) {
            getNotificationCenter().postNotificationName(NotificationCenter.botInfoDidLoad, tLRPC$UserFull.bot_info, Integer.valueOf(i));
        }
        getNotificationCenter().postNotificationName(NotificationCenter.userInfoDidLoad, Long.valueOf(tLRPC$User.id), tLRPC$UserFull);
        if ((tLRPC$UserFull.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) == 0 || (tLRPC$Dialog = this.dialogs_dict.get(tLRPC$User.id)) == null) {
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
    /* renamed from: lambda$loadFullUser$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFullUser$43$MessagesController(TLRPC$User tLRPC$User) {
        this.loadingFullUsers.remove(Long.valueOf(tLRPC$User.id));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void reloadMessages(ArrayList<Integer> arrayList, final long j, final boolean z) {
        TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages;
        if (arrayList.isEmpty()) {
            return;
        }
        final ArrayList<Integer> arrayList2 = new ArrayList<>();
        TLRPC$Chat chat = DialogObject.isChatDialog(j) ? getChat(Long.valueOf(-j)) : null;
        if (ChatObject.isChannel(chat)) {
            TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
            tLRPC$TL_channels_getMessages.channel = getInputChannel(chat);
            tLRPC$TL_channels_getMessages.id = arrayList2;
            tLRPC$TL_messages_getMessages = tLRPC$TL_channels_getMessages;
        } else {
            TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages2 = new TLRPC$TL_messages_getMessages();
            tLRPC$TL_messages_getMessages2.id = arrayList2;
            tLRPC$TL_messages_getMessages = tLRPC$TL_messages_getMessages2;
        }
        TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages3 = tLRPC$TL_messages_getMessages;
        ArrayList<Integer> arrayList3 = this.reloadingMessages.get(j);
        for (int i = 0; i < arrayList.size(); i++) {
            Integer num = arrayList.get(i);
            if (arrayList3 == null || !arrayList3.contains(num)) {
                arrayList2.add(num);
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
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages3, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$6CTqUvW1WVvaOU1W_QMg_yULqio
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reloadMessages$46$MessagesController(j, z, arrayList2, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadMessages$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadMessages$46$MessagesController(final long j, boolean z, final ArrayList arrayList, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            LongSparseArray longSparseArray = new LongSparseArray();
            for (int i = 0; i < tLRPC$messages_Messages.users.size(); i++) {
                TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i);
                longSparseArray.put(tLRPC$User.id, tLRPC$User);
            }
            LongSparseArray longSparseArray2 = new LongSparseArray();
            for (int i2 = 0; i2 < tLRPC$messages_Messages.chats.size(); i2++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$messages_Messages.chats.get(i2);
                longSparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
            }
            Integer numValueOf = (Integer) this.dialogs_read_inbox_max.get(Long.valueOf(j));
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(getMessagesStorage().getDialogReadMax(false, j));
                this.dialogs_read_inbox_max.put(Long.valueOf(j), numValueOf);
            }
            Integer numValueOf2 = (Integer) this.dialogs_read_outbox_max.get(Long.valueOf(j));
            if (numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(getMessagesStorage().getDialogReadMax(true, j));
                this.dialogs_read_outbox_max.put(Long.valueOf(j), numValueOf2);
            }
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < tLRPC$messages_Messages.messages.size()) {
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i3);
                tLRPC$Message.dialog_id = j;
                if (!z) {
                    tLRPC$Message.unread = (tLRPC$Message.out ? numValueOf2 : numValueOf).intValue() < tLRPC$Message.id;
                }
                Integer num = numValueOf;
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new MessageObject(this.currentAccount, tLRPC$Message, (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, true, true));
                i3++;
                arrayList2 = arrayList3;
                numValueOf = num;
            }
            final ArrayList arrayList4 = arrayList2;
            ImageLoader.saveMessagesThumbs(tLRPC$messages_Messages.messages);
            getMessagesStorage().putMessages(tLRPC$messages_Messages, j, -1, 0, false, z);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$OEW4ThBDdgOclMTbVZikOeRXdLI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reloadMessages$45$MessagesController(j, arrayList, arrayList4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadMessages$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadMessages$45$MessagesController(long j, ArrayList arrayList, ArrayList arrayList2) {
        ArrayList<Integer> arrayList3 = this.reloadingMessages.get(j);
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

    public void hidePeerSettingsBar(final long dialogId, TLRPC$User currentUser, TLRPC$Chat currentChat) {
        if (currentUser == null && currentChat == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
        editorEdit.putInt("dialog_bar_vis3" + dialogId, 3);
        editorEdit.remove("dialog_bar_invite" + dialogId);
        editorEdit.commit();
        if (DialogObject.isEncryptedDialog(dialogId)) {
            return;
        }
        TLRPC$TL_messages_hidePeerSettingsBar tLRPC$TL_messages_hidePeerSettingsBar = new TLRPC$TL_messages_hidePeerSettingsBar();
        if (currentUser != null) {
            tLRPC$TL_messages_hidePeerSettingsBar.peer = getInputPeer(currentUser.id);
        } else {
            tLRPC$TL_messages_hidePeerSettingsBar.peer = getInputPeer(-currentChat.id);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_hidePeerSettingsBar, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$h1L2C2LdATnLnDlqLBvJ3c4NeMg
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$hidePeerSettingsBar$47(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void reportSpam(final long dialogId, TLRPC$User currentUser, TLRPC$Chat currentChat, TLRPC$EncryptedChat currentEncryptedChat, boolean geo) {
        if (currentUser == null && currentChat == null && currentEncryptedChat == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
        editorEdit.putInt("dialog_bar_vis3" + dialogId, 3);
        editorEdit.commit();
        if (DialogObject.isEncryptedDialog(dialogId)) {
            if (currentEncryptedChat == null || currentEncryptedChat.access_hash == 0) {
                return;
            }
            TLRPC$TL_messages_reportEncryptedSpam tLRPC$TL_messages_reportEncryptedSpam = new TLRPC$TL_messages_reportEncryptedSpam();
            TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat = new TLRPC$TL_inputEncryptedChat();
            tLRPC$TL_messages_reportEncryptedSpam.peer = tLRPC$TL_inputEncryptedChat;
            tLRPC$TL_inputEncryptedChat.chat_id = currentEncryptedChat.id;
            tLRPC$TL_inputEncryptedChat.access_hash = currentEncryptedChat.access_hash;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_reportEncryptedSpam, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$FUl713VVMnUVHXIqLLHpcUjYrNs
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$reportSpam$48(tLObject, tLRPC$TL_error);
                }
            }, 2);
            return;
        }
        if (geo) {
            TLRPC$TL_account_reportPeer tLRPC$TL_account_reportPeer = new TLRPC$TL_account_reportPeer();
            if (currentChat != null) {
                tLRPC$TL_account_reportPeer.peer = getInputPeer(-currentChat.id);
            } else if (currentUser != null) {
                tLRPC$TL_account_reportPeer.peer = getInputPeer(currentUser.id);
            }
            tLRPC$TL_account_reportPeer.message = "";
            tLRPC$TL_account_reportPeer.reason = new TLRPC$ReportReason() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputReportReasonGeoIrrelevant
                public static int constructor = -606798099;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            };
            getConnectionsManager().sendRequest(tLRPC$TL_account_reportPeer, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$hMxcFH2HsWDnpgDvXaBdMmi26vg
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$reportSpam$49(tLObject, tLRPC$TL_error);
                }
            }, 2);
            return;
        }
        TLRPC$TL_messages_reportSpam tLRPC$TL_messages_reportSpam = new TLRPC$TL_messages_reportSpam();
        if (currentChat != null) {
            tLRPC$TL_messages_reportSpam.peer = getInputPeer(-currentChat.id);
        } else if (currentUser != null) {
            tLRPC$TL_messages_reportSpam.peer = getInputPeer(currentUser.id);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_reportSpam, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xOVch6j-FN0ToOgnsYnFgafBSho
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$reportSpam$50(tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    private void savePeerSettings(long dialogId, TLRPC$TL_peerSettings settings, boolean update) {
        if (settings != null) {
            if (this.notificationsPreferences.getInt("dialog_bar_vis3" + dialogId, 0) == 3) {
                return;
            }
            SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
            boolean z = (settings.report_spam || settings.add_contact || settings.block_contact || settings.share_contact || settings.report_geo || settings.invite_members) ? false : true;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("peer settings loaded for " + dialogId + " add = " + settings.add_contact + " block = " + settings.block_contact + " spam = " + settings.report_spam + " share = " + settings.share_contact + " geo = " + settings.report_geo + " hide = " + z + " distance = " + settings.geo_distance + " invite = " + settings.invite_members);
            }
            editorEdit.putInt("dialog_bar_vis3" + dialogId, z ? 1 : 2);
            editorEdit.putBoolean("dialog_bar_share" + dialogId, settings.share_contact);
            editorEdit.putBoolean("dialog_bar_report" + dialogId, settings.report_spam);
            editorEdit.putBoolean("dialog_bar_add" + dialogId, settings.add_contact);
            editorEdit.putBoolean("dialog_bar_block" + dialogId, settings.block_contact);
            editorEdit.putBoolean("dialog_bar_exception" + dialogId, settings.need_contacts_exception);
            editorEdit.putBoolean("dialog_bar_location" + dialogId, settings.report_geo);
            editorEdit.putBoolean("dialog_bar_archived" + dialogId, settings.autoarchived);
            editorEdit.putBoolean("dialog_bar_invite" + dialogId, settings.invite_members);
            if (this.notificationsPreferences.getInt("dialog_bar_distance" + dialogId, -1) != -2) {
                if ((settings.flags & 64) != 0) {
                    editorEdit.putInt("dialog_bar_distance" + dialogId, settings.geo_distance);
                } else {
                    editorEdit.remove("dialog_bar_distance" + dialogId);
                }
            }
            editorEdit.apply();
            getNotificationCenter().postNotificationName(NotificationCenter.peerSettingsDidLoad, Long.valueOf(dialogId));
        }
    }

    public void loadPeerSettings(TLRPC$User currentUser, TLRPC$Chat currentChat) {
        final long j;
        if (currentUser == null && currentChat == null) {
            return;
        }
        if (currentUser != null) {
            j = currentUser.id;
        } else {
            j = -currentChat.id;
        }
        if (this.loadingPeerSettings.indexOfKey(j) >= 0) {
            return;
        }
        this.loadingPeerSettings.put(j, Boolean.TRUE);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("request spam button for " + j);
        }
        int i = this.notificationsPreferences.getInt("dialog_bar_vis3" + j, 0);
        if (i == 1 || i == 3) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("dialog bar already hidden for " + j);
                return;
            }
            return;
        }
        TLRPC$TL_messages_getPeerSettings tLRPC$TL_messages_getPeerSettings = new TLRPC$TL_messages_getPeerSettings();
        if (currentUser != null) {
            tLRPC$TL_messages_getPeerSettings.peer = getInputPeer(currentUser.id);
        } else {
            tLRPC$TL_messages_getPeerSettings.peer = getInputPeer(-currentChat.id);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerSettings, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$sgNwNYCR5k6ojTtTgN8l9kK52Hg
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPeerSettings$52$MessagesController(j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPeerSettings$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPeerSettings$52$MessagesController(final long j, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$-iUrbA0o6LGw0CW30Gas9TqxRTg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPeerSettings$51$MessagesController(j, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPeerSettings$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPeerSettings$51$MessagesController(long j, TLObject tLObject) {
        this.loadingPeerSettings.remove(j);
        if (tLObject != null) {
            savePeerSettings(j, (TLRPC$TL_peerSettings) tLObject, false);
        }
    }

    protected void processNewChannelDifferenceParams(int pts, int pts_count, long channelId) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("processNewChannelDifferenceParams pts = " + pts + " pts_count = " + pts_count + " channeldId = " + channelId);
        }
        int channelPtsSync = this.channelsPts.get(channelId);
        if (channelPtsSync == 0) {
            channelPtsSync = getMessagesStorage().getChannelPtsSync(channelId);
            if (channelPtsSync == 0) {
                channelPtsSync = 1;
            }
            this.channelsPts.put(channelId, channelPtsSync);
        }
        if (channelPtsSync + pts_count == pts) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("APPLY CHANNEL PTS");
            }
            this.channelsPts.put(channelId, pts);
            getMessagesStorage().saveChannelPts(channelId, pts);
            return;
        }
        if (channelPtsSync != pts) {
            long j = this.updatesStartWaitTimeChannels.get(channelId);
            if (this.gettingDifferenceChannels.get(channelId, Boolean.FALSE).booleanValue() || j == 0 || Math.abs(System.currentTimeMillis() - j) <= 1500) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("ADD CHANNEL UPDATE TO QUEUE pts = " + pts + " pts_count = " + pts_count);
                }
                if (j == 0) {
                    this.updatesStartWaitTimeChannels.put(channelId, System.currentTimeMillis());
                }
                UserActionUpdatesPts userActionUpdatesPts = new UserActionUpdatesPts();
                userActionUpdatesPts.pts = pts;
                userActionUpdatesPts.pts_count = pts_count;
                userActionUpdatesPts.chat_id = channelId;
                ArrayList<TLRPC$Updates> arrayList = this.updatesQueueChannels.get(channelId);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.updatesQueueChannels.put(channelId, arrayList);
                }
                arrayList.add(userActionUpdatesPts);
                return;
            }
            getChannelDifference(channelId);
        }
    }

    public void processNewDifferenceParams(int seq, int pts, int date, int pts_count) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("processNewDifferenceParams seq = " + seq + " pts = " + pts + " date = " + date + " pts_count = " + pts_count);
        }
        if (pts != -1) {
            if (getMessagesStorage().getLastPtsValue() + pts_count == pts) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("APPLY PTS");
                }
                getMessagesStorage().setLastPtsValue(pts);
                getMessagesStorage().saveDiffParams(getMessagesStorage().getLastSeqValue(), getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue());
            } else if (getMessagesStorage().getLastPtsValue() != pts) {
                if (this.gettingDifference || this.updatesStartWaitTimePts == 0 || Math.abs(System.currentTimeMillis() - this.updatesStartWaitTimePts) <= 1500) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("ADD UPDATE TO QUEUE pts = " + pts + " pts_count = " + pts_count);
                    }
                    if (this.updatesStartWaitTimePts == 0) {
                        this.updatesStartWaitTimePts = System.currentTimeMillis();
                    }
                    UserActionUpdatesPts userActionUpdatesPts = new UserActionUpdatesPts();
                    userActionUpdatesPts.pts = pts;
                    userActionUpdatesPts.pts_count = pts_count;
                    this.updatesQueuePts.add(userActionUpdatesPts);
                } else {
                    getDifference();
                }
            }
        }
        if (seq != -1) {
            if (getMessagesStorage().getLastSeqValue() + 1 == seq) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("APPLY SEQ");
                }
                getMessagesStorage().setLastSeqValue(seq);
                if (date != -1) {
                    getMessagesStorage().setLastDateValue(date);
                }
                getMessagesStorage().saveDiffParams(getMessagesStorage().getLastSeqValue(), getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue());
                return;
            }
            if (getMessagesStorage().getLastSeqValue() != seq) {
                if (this.gettingDifference || this.updatesStartWaitTimeSeq == 0 || Math.abs(System.currentTimeMillis() - this.updatesStartWaitTimeSeq) <= 1500) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("ADD UPDATE TO QUEUE seq = " + seq);
                    }
                    if (this.updatesStartWaitTimeSeq == 0) {
                        this.updatesStartWaitTimeSeq = System.currentTimeMillis();
                    }
                    UserActionUpdatesSeq userActionUpdatesSeq = new UserActionUpdatesSeq();
                    userActionUpdatesSeq.seq = seq;
                    this.updatesQueueSeq.add(userActionUpdatesSeq);
                    return;
                }
                getDifference();
            }
        }
    }

    public void didAddedNewTask(final int minDate, final long dialogId, final SparseArray<ArrayList<Integer>> mids) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$yUcg15Jeu-NI3KAPktXe50Bl5bw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didAddedNewTask$53$MessagesController(minDate);
            }
        });
        if (mids != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$zwF_UpMwmHIBkRoyVdBl-A8Yu-c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didAddedNewTask$54$MessagesController(dialogId, mids);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didAddedNewTask$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didAddedNewTask$53$MessagesController(int i) {
        int i2;
        if (!(this.currentDeletingTaskMids == null && this.currentDeletingTaskMediaMids == null && !this.gettingNewDeleteTask) && ((i2 = this.currentDeletingTaskTime) == 0 || i >= i2)) {
            return;
        }
        getNewDeleteTask(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didAddedNewTask$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didAddedNewTask$54$MessagesController(long j, SparseArray sparseArray) {
        getNotificationCenter().postNotificationName(NotificationCenter.didCreatedNewDeleteTask, Long.valueOf(j), sparseArray);
    }

    public void getNewDeleteTask(final LongSparseArray<ArrayList<Integer>> oldTask, final LongSparseArray<ArrayList<Integer>> oldTaskMedia) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$35ukoo6LUvsxF8hl7ydTq07BXqs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getNewDeleteTask$55$MessagesController(oldTask, oldTaskMedia);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getNewDeleteTask$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getNewDeleteTask$55$MessagesController(LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        this.gettingNewDeleteTask = true;
        getMessagesStorage().getNewTask(longSparseArray, longSparseArray2);
    }

    private boolean checkDeletingTask(boolean runnable) throws InterruptedException {
        int i;
        int currentTime = getConnectionsManager().getCurrentTime();
        if ((this.currentDeletingTaskMids == null && this.currentDeletingTaskMediaMids == null) || (!runnable && ((i = this.currentDeletingTaskTime) == 0 || i > currentTime))) {
            return false;
        }
        this.currentDeletingTaskTime = 0;
        if (this.currentDeleteTaskRunnable != null && !runnable) {
            Utilities.stageQueue.cancelRunnable(this.currentDeleteTaskRunnable);
        }
        this.currentDeleteTaskRunnable = null;
        LongSparseArray<ArrayList<Integer>> longSparseArray = this.currentDeletingTaskMids;
        final LongSparseArray<ArrayList<Integer>> longSparseArrayM1clone = longSparseArray != null ? longSparseArray.m1clone() : null;
        LongSparseArray<ArrayList<Integer>> longSparseArray2 = this.currentDeletingTaskMediaMids;
        final LongSparseArray<ArrayList<Integer>> longSparseArrayM1clone2 = longSparseArray2 != null ? longSparseArray2.m1clone() : null;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$eA5GpIMKll4PDCWt9T7J-lNaZDc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkDeletingTask$57$MessagesController(longSparseArrayM1clone, longSparseArrayM1clone2);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDeletingTask$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDeletingTask$57$MessagesController(final LongSparseArray longSparseArray, final LongSparseArray longSparseArray2) {
        if (longSparseArray != null) {
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> arrayList = (ArrayList) longSparseArray.valueAt(i);
                deleteMessages(arrayList, null, null, longSparseArray.keyAt(i), true, false, !arrayList.isEmpty() && arrayList.get(0).intValue() > 0);
            }
        }
        if (longSparseArray2 != null) {
            int size2 = longSparseArray2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                getMessagesStorage().emptyMessagesMedia(longSparseArray2.keyAt(i2), (ArrayList) longSparseArray2.valueAt(i2));
            }
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$3bABXM-hRK8uqTp5yCrvr3Q4i0A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkDeletingTask$56$MessagesController(longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDeletingTask$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDeletingTask$56$MessagesController(LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        getNewDeleteTask(longSparseArray, longSparseArray2);
        this.currentDeletingTaskTime = 0;
        this.currentDeletingTaskMids = null;
        this.currentDeletingTaskMediaMids = null;
    }

    public void processLoadedDeleteTask(final int taskTime, final LongSparseArray<ArrayList<Integer>> task, final LongSparseArray<ArrayList<Integer>> taskMedia) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$wXPo11B8imkFoHuj_sBpVl-NtCY
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$processLoadedDeleteTask$59$MessagesController(task, taskMedia, taskTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedDeleteTask$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDeleteTask$59$MessagesController(LongSparseArray longSparseArray, LongSparseArray longSparseArray2, int i) throws InterruptedException {
        this.gettingNewDeleteTask = false;
        if (longSparseArray != null || longSparseArray2 != null) {
            this.currentDeletingTaskTime = i;
            this.currentDeletingTaskMids = longSparseArray;
            this.currentDeletingTaskMediaMids = longSparseArray2;
            if (this.currentDeleteTaskRunnable != null) {
                Utilities.stageQueue.cancelRunnable(this.currentDeleteTaskRunnable);
                this.currentDeleteTaskRunnable = null;
            }
            if (checkDeletingTask(false)) {
                return;
            }
            this.currentDeleteTaskRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$XD_YRchAYYCEh4wnUdWQk4AN97Y
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$processLoadedDeleteTask$58$MessagesController();
                }
            };
            Utilities.stageQueue.postRunnable(this.currentDeleteTaskRunnable, Math.abs(getConnectionsManager().getCurrentTime() - this.currentDeletingTaskTime) * 1000);
            return;
        }
        this.currentDeletingTaskTime = 0;
        this.currentDeletingTaskMids = null;
        this.currentDeletingTaskMediaMids = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedDeleteTask$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDeleteTask$58$MessagesController() throws InterruptedException {
        checkDeletingTask(true);
    }

    public void loadDialogPhotos(final long did, final int count, final int maxId, boolean fromCache, final int classGuid) {
        if (fromCache) {
            getMessagesStorage().getDialogPhotos(did, count, maxId, classGuid);
            return;
        }
        if (did > 0) {
            TLRPC$User user = getUser(Long.valueOf(did));
            if (user == null) {
                return;
            }
            TLRPC$TL_photos_getUserPhotos tLRPC$TL_photos_getUserPhotos = new TLRPC$TL_photos_getUserPhotos();
            tLRPC$TL_photos_getUserPhotos.limit = count;
            tLRPC$TL_photos_getUserPhotos.offset = 0;
            tLRPC$TL_photos_getUserPhotos.max_id = maxId;
            tLRPC$TL_photos_getUserPhotos.user_id = getInputUser(user);
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_photos_getUserPhotos, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$hlgiHPG7Y57SmYn0mBCDKYqxE2c
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadDialogPhotos$60$MessagesController(did, count, maxId, classGuid, tLObject, tLRPC$TL_error);
                }
            }), classGuid);
            return;
        }
        if (did < 0) {
            TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
            tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterChatPhotos();
            tLRPC$TL_messages_search.limit = count;
            tLRPC$TL_messages_search.offset_id = maxId;
            tLRPC$TL_messages_search.q = "";
            tLRPC$TL_messages_search.peer = getInputPeer(did);
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$fRS9CCfpV_KPs_QdBsAzuQzHPy8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadDialogPhotos$61$MessagesController(did, count, maxId, classGuid, tLObject, tLRPC$TL_error);
                }
            }), classGuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDialogPhotos$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadDialogPhotos$60$MessagesController(long j, int i, int i2, int i3, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processLoadedUserPhotos((TLRPC$photos_Photos) tLObject, null, j, i, i2, false, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDialogPhotos$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadDialogPhotos$61$MessagesController(long j, int i, int i2, int i3, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        TLRPC$Photo tLRPC$Photo;
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            TLRPC$TL_photos_photos tLRPC$TL_photos_photos = new TLRPC$TL_photos_photos();
            ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
            tLRPC$TL_photos_photos.count = tLRPC$messages_Messages.count;
            tLRPC$TL_photos_photos.users.addAll(tLRPC$messages_Messages.users);
            for (int i4 = 0; i4 < tLRPC$messages_Messages.messages.size(); i4++) {
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i4);
                TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
                if (tLRPC$MessageAction != null && (tLRPC$Photo = tLRPC$MessageAction.photo) != null) {
                    tLRPC$TL_photos_photos.photos.add(tLRPC$Photo);
                    arrayList.add(tLRPC$Message);
                }
            }
            processLoadedUserPhotos(tLRPC$TL_photos_photos, arrayList, j, i, i2, false, i3);
        }
    }

    public void blockPeer(long id) {
        TLRPC$Chat chat;
        TLRPC$User tLRPC$User = null;
        if (id > 0) {
            TLRPC$User user = getUser(Long.valueOf(id));
            if (user == null) {
                return;
            }
            chat = null;
            tLRPC$User = user;
        } else {
            chat = getChat(Long.valueOf(-id));
            if (chat == null) {
                return;
            }
        }
        if (this.blockePeers.indexOfKey(id) >= 0) {
            return;
        }
        this.blockePeers.put(id, 1);
        if (tLRPC$User != null) {
            if (tLRPC$User.bot) {
                getMediaDataController().removeInline(id);
            } else {
                getMediaDataController().removePeer(id);
            }
        }
        int i = this.totalBlockedCount;
        if (i >= 0) {
            this.totalBlockedCount = i + 1;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        TLRPC$TL_contacts_block tLRPC$TL_contacts_block = new TLRPC$TL_contacts_block();
        if (tLRPC$User != null) {
            tLRPC$TL_contacts_block.id = getInputPeer(tLRPC$User);
        } else {
            tLRPC$TL_contacts_block.id = getInputPeer(chat);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_contacts_block, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Z8bGOSTq3Ktc6bFFR7EY4AcDQBM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$blockPeer$62(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void setParticipantBannedRole(final long chatId, TLRPC$User user, TLRPC$Chat chat, TLRPC$TL_chatBannedRights rights, final boolean isChannel, final BaseFragment parentFragment) {
        if ((user == null && chat == null) || rights == null) {
            return;
        }
        final TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned = new TLRPC$TL_channels_editBanned();
        tLRPC$TL_channels_editBanned.channel = getInputChannel(chatId);
        if (user != null) {
            tLRPC$TL_channels_editBanned.participant = getInputPeer(user);
        } else {
            tLRPC$TL_channels_editBanned.participant = getInputPeer(chat);
        }
        tLRPC$TL_channels_editBanned.banned_rights = rights;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_editBanned, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$sz4dt4Q6p6wt4csPHMe8OC1BW4w
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setParticipantBannedRole$65$MessagesController(chatId, parentFragment, tLRPC$TL_channels_editBanned, isChannel, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParticipantBannedRole$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParticipantBannedRole$65$MessagesController(final long j, final BaseFragment baseFragment, final TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned, final boolean z, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$cbXeqH3mbYshXid3-U0qyl2nzB8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setParticipantBannedRole$63$MessagesController(j);
                }
            }, 1000L);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$mcOnzqho4MCKCu1CkNfWPxCmlGk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setParticipantBannedRole$64$MessagesController(tLRPC$TL_error, baseFragment, tLRPC$TL_channels_editBanned, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParticipantBannedRole$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParticipantBannedRole$63$MessagesController(long j) {
        loadFullChat(j, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParticipantBannedRole$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParticipantBannedRole$64$MessagesController(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned, boolean z) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_editBanned, Boolean.valueOf(z));
    }

    public void setChannelSlowMode(final long chatId, int seconds) {
        TLRPC$TL_channels_toggleSlowMode tLRPC$TL_channels_toggleSlowMode = new TLRPC$TL_channels_toggleSlowMode();
        tLRPC$TL_channels_toggleSlowMode.seconds = seconds;
        tLRPC$TL_channels_toggleSlowMode.channel = getInputChannel(chatId);
        getConnectionsManager().sendRequest(tLRPC$TL_channels_toggleSlowMode, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$UFGioXJo0jaliFQULU2fYCDhOt4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setChannelSlowMode$67$MessagesController(chatId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setChannelSlowMode$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setChannelSlowMode$67$MessagesController(final long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Zl-5fMf7tRovKWxlrvcHHKDWcEc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setChannelSlowMode$66$MessagesController(j);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setChannelSlowMode$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setChannelSlowMode$66$MessagesController(long j) {
        loadFullChat(j, 0, true);
    }

    public void setDefaultBannedRole(final long chatId, TLRPC$TL_chatBannedRights rights, final boolean isChannel, final BaseFragment parentFragment) {
        if (rights == null) {
            return;
        }
        final TLRPC$TL_messages_editChatDefaultBannedRights tLRPC$TL_messages_editChatDefaultBannedRights = new TLRPC$TL_messages_editChatDefaultBannedRights();
        tLRPC$TL_messages_editChatDefaultBannedRights.peer = getInputPeer(-chatId);
        tLRPC$TL_messages_editChatDefaultBannedRights.banned_rights = rights;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatDefaultBannedRights, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$A9N8xVz91gDw7ARdPugRlJhOVo0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setDefaultBannedRole$70$MessagesController(chatId, parentFragment, tLRPC$TL_messages_editChatDefaultBannedRights, isChannel, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDefaultBannedRole$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDefaultBannedRole$70$MessagesController(final long j, final BaseFragment baseFragment, final TLRPC$TL_messages_editChatDefaultBannedRights tLRPC$TL_messages_editChatDefaultBannedRights, final boolean z, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$d8JKj9ghd0TRtkM2s0GGe9i8s6E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setDefaultBannedRole$68$MessagesController(j);
                }
            }, 1000L);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$iHVwGLN15rW5G0_ITH3VYq2PZgQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setDefaultBannedRole$69$MessagesController(tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editChatDefaultBannedRights, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDefaultBannedRole$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDefaultBannedRole$68$MessagesController(long j) {
        loadFullChat(j, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDefaultBannedRole$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDefaultBannedRole$69$MessagesController(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_editChatDefaultBannedRights tLRPC$TL_messages_editChatDefaultBannedRights, boolean z) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editChatDefaultBannedRights, Boolean.valueOf(z));
    }

    public void setUserAdminRole(final long chatId, TLRPC$User user, TLRPC$TL_chatAdminRights rights, String rank, final boolean isChannel, final BaseFragment parentFragment, boolean addingNew) {
        if (user == null || rights == null) {
            return;
        }
        TLRPC$Chat chat = getChat(Long.valueOf(chatId));
        if (ChatObject.isChannel(chat)) {
            final TLRPC$TL_channels_editAdmin tLRPC$TL_channels_editAdmin = new TLRPC$TL_channels_editAdmin();
            tLRPC$TL_channels_editAdmin.channel = getInputChannel(chat);
            tLRPC$TL_channels_editAdmin.user_id = getInputUser(user);
            tLRPC$TL_channels_editAdmin.admin_rights = rights;
            tLRPC$TL_channels_editAdmin.rank = rank;
            getConnectionsManager().sendRequest(tLRPC$TL_channels_editAdmin, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$PZYDwqpPyxJ0sjufGGrFx6zvJpE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$setUserAdminRole$73$MessagesController(chatId, parentFragment, tLRPC$TL_channels_editAdmin, isChannel, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        final TLRPC$TL_messages_editChatAdmin tLRPC$TL_messages_editChatAdmin = new TLRPC$TL_messages_editChatAdmin();
        tLRPC$TL_messages_editChatAdmin.chat_id = chatId;
        tLRPC$TL_messages_editChatAdmin.user_id = getInputUser(user);
        boolean z = rights.change_info || rights.delete_messages || rights.ban_users || rights.invite_users || rights.pin_messages || rights.add_admins || rights.manage_call;
        tLRPC$TL_messages_editChatAdmin.is_admin = z;
        final RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ytoxL09nGMR6tZueopasP7rA_hI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setUserAdminRole$76$MessagesController(chatId, parentFragment, tLRPC$TL_messages_editChatAdmin, tLObject, tLRPC$TL_error);
            }
        };
        if (z && addingNew) {
            addUserToChat(chatId, user, 0, null, parentFragment, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$_oW5vF9rvoy7KHQGGKkkfRon2Hw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$77$MessagesController(tLRPC$TL_messages_editChatAdmin, requestDelegate);
                }
            });
        } else {
            getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatAdmin, requestDelegate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setUserAdminRole$73, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setUserAdminRole$73$MessagesController(final long j, final BaseFragment baseFragment, final TLRPC$TL_channels_editAdmin tLRPC$TL_channels_editAdmin, final boolean z, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$-DcZWK-4qyugnTluunfBcnf4-K8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$71$MessagesController(j);
                }
            }, 1000L);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$AbBnYUn3-Q4eIYTWTq7P1dqVVpc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$72$MessagesController(tLRPC$TL_error, baseFragment, tLRPC$TL_channels_editAdmin, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setUserAdminRole$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setUserAdminRole$71$MessagesController(long j) {
        loadFullChat(j, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setUserAdminRole$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setUserAdminRole$72$MessagesController(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_editAdmin tLRPC$TL_channels_editAdmin, boolean z) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_editAdmin, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setUserAdminRole$74, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setUserAdminRole$74$MessagesController(long j) {
        loadFullChat(j, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setUserAdminRole$76, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setUserAdminRole$76$MessagesController(final long j, final BaseFragment baseFragment, final TLRPC$TL_messages_editChatAdmin tLRPC$TL_messages_editChatAdmin, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$b6nV0soMN3ddV6qXQF8HiyE_BvY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$74$MessagesController(j);
                }
            }, 1000L);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ysBVofE0hoxqRhAugm9zJZqBuYI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setUserAdminRole$75$MessagesController(tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editChatAdmin);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setUserAdminRole$75, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setUserAdminRole$75$MessagesController(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_editChatAdmin tLRPC$TL_messages_editChatAdmin) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editChatAdmin, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setUserAdminRole$77, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setUserAdminRole$77$MessagesController(TLRPC$TL_messages_editChatAdmin tLRPC$TL_messages_editChatAdmin, RequestDelegate requestDelegate) {
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatAdmin, requestDelegate);
    }

    public void unblockPeer(long id) {
        TLRPC$Chat chat;
        TLRPC$TL_contacts_unblock tLRPC$TL_contacts_unblock = new TLRPC$TL_contacts_unblock();
        TLRPC$User tLRPC$User = null;
        if (id > 0) {
            TLRPC$User user = getUser(Long.valueOf(id));
            if (user == null) {
                return;
            }
            chat = null;
            tLRPC$User = user;
        } else {
            chat = getChat(Long.valueOf(-id));
            if (chat == null) {
                return;
            }
        }
        this.totalBlockedCount--;
        this.blockePeers.delete(id);
        if (tLRPC$User != null) {
            tLRPC$TL_contacts_unblock.id = getInputPeer(tLRPC$User);
        } else {
            tLRPC$TL_contacts_unblock.id = getInputPeer(chat);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        getConnectionsManager().sendRequest(tLRPC$TL_contacts_unblock, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$2XPExpbaY9nv-LC44QvuhZz0qGg
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$unblockPeer$78(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void getBlockedPeers(final boolean reset) {
        if (!getUserConfig().isClientActivated() || this.loadingBlockedPeers) {
            return;
        }
        this.loadingBlockedPeers = true;
        final TLRPC$TL_contacts_getBlocked tLRPC$TL_contacts_getBlocked = new TLRPC$TL_contacts_getBlocked();
        tLRPC$TL_contacts_getBlocked.offset = reset ? 0 : this.blockePeers.size();
        tLRPC$TL_contacts_getBlocked.limit = reset ? 20 : 100;
        getConnectionsManager().sendRequest(tLRPC$TL_contacts_getBlocked, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$y_rsok0XCO3ATtUyYkWNv5kfyME
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getBlockedPeers$80$MessagesController(reset, tLRPC$TL_contacts_getBlocked, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getBlockedPeers$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getBlockedPeers$80$MessagesController(final boolean z, final TLRPC$TL_contacts_getBlocked tLRPC$TL_contacts_getBlocked, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$jAk_P4f5_0YJciYjGx-Dy2-e6yg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getBlockedPeers$79$MessagesController(tLObject, z, tLRPC$TL_contacts_getBlocked);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getBlockedPeers$79, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getBlockedPeers$79$MessagesController(TLObject tLObject, boolean z, TLRPC$TL_contacts_getBlocked tLRPC$TL_contacts_getBlocked) {
        if (tLObject != null) {
            TLRPC$contacts_Blocked tLRPC$contacts_Blocked = (TLRPC$contacts_Blocked) tLObject;
            putUsers(tLRPC$contacts_Blocked.users, false);
            putChats(tLRPC$contacts_Blocked.chats, false);
            getMessagesStorage().putUsersAndChats(tLRPC$contacts_Blocked.users, tLRPC$contacts_Blocked.chats, true, true);
            if (z) {
                this.blockePeers.clear();
            }
            this.totalBlockedCount = Math.max(tLRPC$contacts_Blocked.count, tLRPC$contacts_Blocked.blocked.size());
            this.blockedEndReached = tLRPC$contacts_Blocked.blocked.size() < tLRPC$TL_contacts_getBlocked.limit;
            int size = tLRPC$contacts_Blocked.blocked.size();
            for (int i = 0; i < size; i++) {
                this.blockePeers.put(MessageObject.getPeerId(tLRPC$contacts_Blocked.blocked.get(i).peer_id), 1);
            }
            this.loadingBlockedPeers = false;
            getNotificationCenter().postNotificationName(NotificationCenter.blockedUsersDidLoad, new Object[0]);
        }
    }

    public void deleteUserPhoto(TLRPC$InputPhoto photo) {
        if (photo == null) {
            TLRPC$TL_photos_updateProfilePhoto tLRPC$TL_photos_updateProfilePhoto = new TLRPC$TL_photos_updateProfilePhoto();
            tLRPC$TL_photos_updateProfilePhoto.id = new TLRPC$TL_inputPhotoEmpty();
            getUserConfig().getCurrentUser().photo = new TLRPC$TL_userProfilePhotoEmpty();
            TLRPC$User user = getUser(Long.valueOf(getUserConfig().getClientUserId()));
            if (user == null) {
                user = getUserConfig().getCurrentUser();
            }
            if (user == null) {
                return;
            }
            user.photo = getUserConfig().getCurrentUser().photo;
            getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_ALL));
            getConnectionsManager().sendRequest(tLRPC$TL_photos_updateProfilePhoto, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$YLUvKkWNMlc6cZxhlDrwQ4bjKqw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$deleteUserPhoto$82$MessagesController(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        TLRPC$TL_photos_deletePhotos tLRPC$TL_photos_deletePhotos = new TLRPC$TL_photos_deletePhotos();
        tLRPC$TL_photos_deletePhotos.id.add(photo);
        getConnectionsManager().sendRequest(tLRPC$TL_photos_deletePhotos, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$bc0krOVfbA8IRljIa9TTMX7v_y0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$deleteUserPhoto$83(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteUserPhoto$82, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteUserPhoto$82$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
            TLRPC$User user = getUser(Long.valueOf(getUserConfig().getClientUserId()));
            if (user == null) {
                user = getUserConfig().getCurrentUser();
                putUser(user, false);
            } else {
                getUserConfig().setCurrentUser(user);
            }
            if (user == null) {
                return;
            }
            getMessagesStorage().clearUserPhotos(user.id);
            ArrayList<TLRPC$User> arrayList = new ArrayList<>();
            arrayList.add(user);
            getMessagesStorage().putUsersAndChats(arrayList, null, false, true);
            if (tLRPC$TL_photos_photo.photo instanceof TLRPC$TL_photo) {
                TLRPC$TL_userProfilePhoto tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto();
                user.photo = tLRPC$TL_userProfilePhoto;
                tLRPC$TL_userProfilePhoto.has_video = !tLRPC$TL_photos_photo.photo.video_sizes.isEmpty();
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = user.photo;
                TLRPC$Photo tLRPC$Photo = tLRPC$TL_photos_photo.photo;
                tLRPC$UserProfilePhoto.photo_id = tLRPC$Photo.id;
                tLRPC$UserProfilePhoto.photo_small = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, ImageReceiver.DEFAULT_CROSSFADE_DURATION).location;
                user.photo.photo_big = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_photos_photo.photo.sizes, 800).location;
                user.photo.dc_id = tLRPC$TL_photos_photo.photo.dc_id;
            } else {
                user.photo = new TLRPC$TL_userProfilePhotoEmpty();
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$2YlOPbzrZ5RkfzehB4JlDlw9DdE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deleteUserPhoto$81$MessagesController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteUserPhoto$81, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteUserPhoto$81$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_ALL));
        getUserConfig().saveConfig(true);
    }

    public void processLoadedUserPhotos(final TLRPC$photos_Photos res, final ArrayList<TLRPC$Message> messages, final long did, final int count, int maxId, final boolean fromCache, final int classGuid) {
        if (!fromCache) {
            getMessagesStorage().putUsersAndChats(res.users, null, true, true);
            getMessagesStorage().putDialogPhotos(did, res, messages);
        } else if (res == null || res.photos.isEmpty()) {
            loadDialogPhotos(did, count, maxId, false, classGuid);
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$rRfD7DI5wvs1Aow2qT-ZBVjsk0g
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedUserPhotos$84$MessagesController(res, fromCache, did, count, classGuid, messages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedUserPhotos$84, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedUserPhotos$84$MessagesController(TLRPC$photos_Photos tLRPC$photos_Photos, boolean z, long j, int i, int i2, ArrayList arrayList) {
        putUsers(tLRPC$photos_Photos.users, z);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogPhotosLoaded, Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), tLRPC$photos_Photos.photos, arrayList);
    }

    public void uploadAndApplyUserAvatar(TLRPC$FileLocation location) {
        if (location == null) {
            return;
        }
        this.uploadingAvatar = FileLoader.getDirectory(4) + "/" + location.volume_id + "_" + location.local_id + ".jpg";
        getFileLoader().uploadFile(this.uploadingAvatar, false, true, ConnectionsManager.FileTypePhoto);
    }

    public void installTheme(Theme.ThemeInfo themeInfo, Theme.ThemeAccent accent, boolean night) {
        TLRPC$TL_theme tLRPC$TL_theme = accent != null ? accent.info : themeInfo.info;
        String str = accent != null ? accent.patternSlug : themeInfo.slug;
        boolean z = accent == null && themeInfo.isBlured;
        boolean z2 = accent != null ? accent.patternMotion : themeInfo.isMotion;
        TLRPC$TL_account_installTheme tLRPC$TL_account_installTheme = new TLRPC$TL_account_installTheme();
        tLRPC$TL_account_installTheme.dark = night;
        if (tLRPC$TL_theme != null) {
            tLRPC$TL_account_installTheme.format = "android";
            TLRPC$TL_inputTheme tLRPC$TL_inputTheme = new TLRPC$TL_inputTheme();
            tLRPC$TL_inputTheme.id = tLRPC$TL_theme.id;
            tLRPC$TL_inputTheme.access_hash = tLRPC$TL_theme.access_hash;
            tLRPC$TL_account_installTheme.theme = tLRPC$TL_inputTheme;
            tLRPC$TL_account_installTheme.flags |= 2;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_account_installTheme, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$73E_ekeIGvFJjgdpH4BmANn_sU4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$installTheme$85(tLObject, tLRPC$TL_error);
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
        tLRPC$TL_wallPaperSettings.blur = z;
        tLRPC$TL_wallPaperSettings.motion = z2;
        getConnectionsManager().sendRequest(tLRPC$TL_account_installWallPaper, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$rJr2iZcWgNXeWktSnUl37M66Iyw
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$installTheme$86(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void saveThemeToServer(final Theme.ThemeInfo themeInfo, final Theme.ThemeAccent accent) {
        String absolutePath;
        File pathToWallpaper;
        if (themeInfo == null) {
            return;
        }
        if (accent != 0) {
            absolutePath = accent.saveToFile().getAbsolutePath();
            pathToWallpaper = accent.getPathToWallpaper();
        } else {
            absolutePath = themeInfo.pathToFile;
            pathToWallpaper = null;
        }
        final String str = absolutePath;
        final File file = pathToWallpaper;
        if (str == null || this.uploadingThemes.containsKey(str)) {
            return;
        }
        this.uploadingThemes.put(str, accent != 0 ? accent : themeInfo);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$zFjN0VeX_87V0DyP24Fr_t8M3xY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveThemeToServer$88$MessagesController(str, file, accent, themeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveThemeToServer$88, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveThemeToServer$88$MessagesController(final String str, File file, final Theme.ThemeAccent themeAccent, final Theme.ThemeInfo themeInfo) {
        final String strCreateThemePreviewImage = Theme.createThemePreviewImage(str, file != null ? file.getAbsolutePath() : null, themeAccent);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$j5rneOqyAkqoJkpZNIK3ToHM5oI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveThemeToServer$87$MessagesController(strCreateThemePreviewImage, str, themeAccent, themeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$saveThemeToServer$87, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveThemeToServer$87$MessagesController(String str, String str2, Theme.ThemeAccent themeAccent, Theme.ThemeInfo themeInfo) {
        if (str == null) {
            this.uploadingThemes.remove(str2);
            return;
        }
        this.uploadingThemes.put(str, themeAccent != null ? themeAccent : themeInfo);
        if (themeAccent == null) {
            themeInfo.uploadingFile = str2;
            themeInfo.uploadingThumb = str;
        } else {
            themeAccent.uploadingFile = str2;
            themeAccent.uploadingThumb = str;
        }
        getFileLoader().uploadFile(str2, false, true, ConnectionsManager.FileTypeFile);
        getFileLoader().uploadFile(str, false, true, ConnectionsManager.FileTypePhoto);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void saveWallpaperToServer(java.io.File r10, ir.eitaa.ui.ActionBar.Theme.OverrideWallpaperInfo r11, boolean r12, final long r13) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.saveWallpaperToServer(java.io.File, ir.eitaa.ui.ActionBar.Theme$OverrideWallpaperInfo, boolean, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveWallpaperToServer$89, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveWallpaperToServer$89$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        getMessagesStorage().removePendingTask(j);
    }

    public void markDialogMessageAsDeleted(long dialogId, ArrayList<Integer> messages) {
        MessageObject messageObject = this.dialogMessage.get(dialogId);
        if (messageObject != null) {
            for (int i = 0; i < messages.size(); i++) {
                if (messageObject.getId() == messages.get(i).intValue()) {
                    messageObject.deleted = true;
                    return;
                }
            }
        }
    }

    public void deleteMessages(ArrayList<Integer> messages, ArrayList<Long> messageDialogIds, TLRPC$EncryptedChat encryptedChat, long dialogId, boolean forAll, boolean scheduled) {
        deleteMessages(messages, messageDialogIds, encryptedChat, dialogId, forAll, scheduled, false, 0L, null, false);
    }

    public void deleteMessages(ArrayList<Integer> messages, ArrayList<Long> messageDialogIds, TLRPC$EncryptedChat encryptedChat, long dialogId, boolean forAll, boolean scheduled, boolean cacheOnly) {
        deleteMessages(messages, messageDialogIds, encryptedChat, dialogId, forAll, scheduled, cacheOnly, 0L, null, false);
    }

    public void deleteMessages(ArrayList<Integer> messages, ArrayList<Long> messageDialogIds, TLRPC$EncryptedChat encryptedChat, long dialogId, boolean forAll, boolean scheduled, boolean cacheOnly, long taskId, TLObject taskRequest) {
        deleteMessages(messages, messageDialogIds, encryptedChat, dialogId, forAll, scheduled, cacheOnly, taskId, taskRequest, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void deleteMessages(java.util.ArrayList<java.lang.Integer> r23, java.util.ArrayList<java.lang.Long> r24, ir.eitaa.tgnet.TLRPC$EncryptedChat r25, long r26, boolean r28, boolean r29, boolean r30, long r31, ir.eitaa.tgnet.TLObject r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.deleteMessages(java.util.ArrayList, java.util.ArrayList, ir.eitaa.tgnet.TLRPC$EncryptedChat, long, boolean, boolean, boolean, long, ir.eitaa.tgnet.TLObject, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteMessages$90, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteMessages$90$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteMessages$91, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteMessages$91$MessagesController(long j, long j2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewChannelDifferenceParams(tLRPC$TL_messages_affectedMessages.pts, tLRPC$TL_messages_affectedMessages.pts_count, j);
        }
        if (j2 != 0) {
            getMessagesStorage().removePendingTask(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteMessages$92, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteMessages$92$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void unpinAllMessages(final TLRPC$Chat chat, final TLRPC$User user) {
        if (chat == null && user == null) {
            return;
        }
        TLRPC$TL_messages_unpinAllMessages tLRPC$TL_messages_unpinAllMessages = new TLRPC$TL_messages_unpinAllMessages();
        tLRPC$TL_messages_unpinAllMessages.peer = getInputPeer(chat != null ? -chat.id : user.id);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_unpinAllMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$78VSlqBgNxEmnyxjvc1sP7rc078
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$unpinAllMessages$93$MessagesController(chat, user, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$unpinAllMessages$93, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$unpinAllMessages$93$MessagesController(TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$TL_messages_affectedHistory tLRPC$TL_messages_affectedHistory = (TLRPC$TL_messages_affectedHistory) tLObject;
            if (ChatObject.isChannel(tLRPC$Chat)) {
                processNewChannelDifferenceParams(tLRPC$TL_messages_affectedHistory.pts, tLRPC$TL_messages_affectedHistory.pts_count, tLRPC$Chat.id);
            } else {
                processNewDifferenceParams(-1, tLRPC$TL_messages_affectedHistory.pts, -1, tLRPC$TL_messages_affectedHistory.pts_count);
            }
            new ArrayList();
            getMessagesStorage().updatePinnedMessages(tLRPC$Chat != null ? -tLRPC$Chat.id : tLRPC$User.id, null, false, 0, 0, false, null);
        }
    }

    public void pinMessage(final TLRPC$Chat chat, final TLRPC$User user, final int id, final boolean unpin, boolean oneSide, boolean notify) {
        if (chat == null && user == null) {
            return;
        }
        TLRPC$TL_messages_updatePinnedMessage tLRPC$TL_messages_updatePinnedMessage = new TLRPC$TL_messages_updatePinnedMessage();
        tLRPC$TL_messages_updatePinnedMessage.peer = getInputPeer(chat != null ? -chat.id : user.id);
        tLRPC$TL_messages_updatePinnedMessage.id = id;
        tLRPC$TL_messages_updatePinnedMessage.unpin = unpin;
        tLRPC$TL_messages_updatePinnedMessage.silent = !notify;
        tLRPC$TL_messages_updatePinnedMessage.pm_oneside = oneSide;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_updatePinnedMessage, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$OrKXXhNuwRDRy3cZYElHPznWJmo
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$pinMessage$94$MessagesController(id, chat, user, unpin, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$pinMessage$94, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$pinMessage$94$MessagesController(int i, TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, boolean z, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(i));
            getMessagesStorage().updatePinnedMessages(tLRPC$Chat != null ? -tLRPC$Chat.id : tLRPC$User.id, arrayList, !z, -1, 0, false, null);
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public void deleteUserChannelHistory(final TLRPC$Chat chat, final TLRPC$User user, int offset) {
        if (offset == 0) {
            getMessagesStorage().deleteUserChatHistory(-chat.id, user.id);
        }
        TLRPC$TL_channels_deleteUserHistory tLRPC$TL_channels_deleteUserHistory = new TLRPC$TL_channels_deleteUserHistory();
        tLRPC$TL_channels_deleteUserHistory.channel = getInputChannel(chat);
        tLRPC$TL_channels_deleteUserHistory.user_id = getInputUser(user);
        getConnectionsManager().sendRequest(tLRPC$TL_channels_deleteUserHistory, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$k7TRTUZbHcN1BX2cWPlDggTUsPc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteUserChannelHistory$95$MessagesController(chat, user, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteUserChannelHistory$95, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteUserChannelHistory$95$MessagesController(TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

    public boolean isDialogsEndReached(int folderId) {
        return this.dialogsEndReached.get(folderId);
    }

    public boolean isLoadingDialogs(int folderId) {
        return this.loadingDialogs.get(folderId);
    }

    public boolean isServerDialogsEndReached(int folderId) {
        return this.serverDialogsEndReached.get(folderId);
    }

    public boolean hasHiddenArchive() {
        return SharedConfig.archiveHidden && this.dialogs_dict.get(DialogObject.makeFolderDialogId(1)) != null;
    }

    public ArrayList<TLRPC$Dialog> getDialogs(int folderId) {
        ArrayList<TLRPC$Dialog> arrayList = this.dialogsByFolder.get(folderId);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<Long> getLockedDialogs() {
        return this.lockedDialogsId;
    }

    public ArrayList<TLRPC$Dialog> getDialogsForward() {
        return this.dialogsForward;
    }

    public int getTotalDialogsCount() {
        ArrayList<TLRPC$Dialog> arrayList = this.dialogsByFolder.get(0);
        if (arrayList != null) {
            return 0 + arrayList.size();
        }
        return 0;
    }

    public void putAllNeededDraftDialogs() {
        LongSparseArray<SparseArray<TLRPC$DraftMessage>> drafts = getMediaDataController().getDrafts();
        int size = drafts.size();
        for (int i = 0; i < size; i++) {
            TLRPC$DraftMessage tLRPC$DraftMessage = drafts.valueAt(i).get(0);
            if (tLRPC$DraftMessage != null) {
                putDraftDialogIfNeed(drafts.keyAt(i), tLRPC$DraftMessage);
            }
        }
    }

    public void putDraftDialogIfNeed(long dialogId, TLRPC$DraftMessage draftMessage) {
        if (this.dialogs_dict.indexOfKey(dialogId) < 0) {
            MediaDataController mediaDataController = getMediaDataController();
            int size = this.allDialogs.size();
            int i = 0;
            if (size > 0) {
                TLRPC$Dialog tLRPC$Dialog = this.allDialogs.get(size - 1);
                if (draftMessage.date < DialogObject.getLastMessageOrDraftDate(tLRPC$Dialog, mediaDataController.getDraft(tLRPC$Dialog.id, 0))) {
                    return;
                }
            }
            TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
            tLRPC$TL_dialog.id = dialogId;
            tLRPC$TL_dialog.draft = draftMessage;
            tLRPC$TL_dialog.folder_id = mediaDataController.getDraftFolderId(dialogId);
            if (dialogId < 0 && ChatObject.isChannel(getChat(Long.valueOf(-dialogId)))) {
                i = 1;
            }
            tLRPC$TL_dialog.flags = i;
            this.dialogs_dict.put(dialogId, tLRPC$TL_dialog);
            this.allDialogs.add(tLRPC$TL_dialog);
            sortDialogs(null);
        }
    }

    public void removeDraftDialogIfNeed(long dialogId) {
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(dialogId);
        if (tLRPC$Dialog == null || tLRPC$Dialog.top_message != 0) {
            return;
        }
        this.dialogs_dict.remove(tLRPC$Dialog.id);
        this.allDialogs.remove(tLRPC$Dialog);
    }

    private void removeDialog(TLRPC$Dialog dialog) {
        if (dialog == null) {
            return;
        }
        final long j = dialog.id;
        if (this.dialogsServerOnly.remove(dialog) && DialogObject.isChannel(dialog)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$auTrJ4o91QSh9u5Pzzgzp-1fQ_s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeDialog$96$MessagesController(j);
                }
            });
        }
        this.allDialogs.remove(dialog);
        this.dialogsCanAddUsers.remove(dialog);
        this.dialogsChannelsOnly.remove(dialog);
        this.dialogsGroupsOnly.remove(dialog);
        this.dialogsUsersOnly.remove(dialog);
        this.dialogsForBlock.remove(dialog);
        this.dialogsForward.remove(dialog);
        int i = 0;
        while (true) {
            DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
            if (i >= dialogFilterArr.length) {
                break;
            }
            if (dialogFilterArr[i] != null) {
                dialogFilterArr[i].dialogs.remove(dialog);
            }
            i++;
        }
        this.dialogs_dict.remove(j);
        ArrayList<TLRPC$Dialog> arrayList = this.dialogsByFolder.get(dialog.folder_id);
        if (arrayList != null) {
            arrayList.remove(dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeDialog$96, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeDialog$96$MessagesController(long j) {
        long j2 = -j;
        this.channelsPts.delete(j2);
        this.shortPollChannels.delete(j2);
        this.needShortPollChannels.delete(j2);
        this.shortPollOnlines.delete(j2);
        this.needShortPollOnlines.delete(j2);
    }

    public void hidePromoDialog() {
        if (this.promoDialog == null) {
            return;
        }
        TLRPC$TL_help_hidePromoData tLRPC$TL_help_hidePromoData = new TLRPC$TL_help_hidePromoData();
        tLRPC$TL_help_hidePromoData.peer = getInputPeer(this.promoDialog.id);
        getConnectionsManager().sendRequest(tLRPC$TL_help_hidePromoData, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$bAMv-LcsoyJXyZlYfxb5NtlqFrk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$hidePromoDialog$97(tLObject, tLRPC$TL_error);
            }
        });
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$zsTAGtVCDLfOamVbXvCAoIztY2E
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hidePromoDialog$98$MessagesController();
            }
        });
        removePromoDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hidePromoDialog$98, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hidePromoDialog$98$MessagesController() {
        this.promoDialogId = 0L;
        this.proxyDialogAddress = null;
        this.nextPromoInfoCheckTime = getConnectionsManager().getCurrentTime() + 3600;
        getGlobalMainSettings().edit().putLong("proxy_dialog", this.promoDialogId).remove("proxyDialogAddress").putInt("nextPromoInfoCheckTime", this.nextPromoInfoCheckTime).commit();
    }

    public void deleteDialog(final long did, int onlyHistory) {
        deleteDialog(did, onlyHistory, false);
    }

    public void deleteDialog(final long did, int onlyHistory, boolean revoke) {
        deleteDialog(did, 1, onlyHistory, 0, revoke, null, 0L);
    }

    public void setDialogHistoryTTL(long did, int ttl) {
        TLRPC$UserFull userFull;
        TLRPC$TL_messages_setHistoryTTL tLRPC$TL_messages_setHistoryTTL = new TLRPC$TL_messages_setHistoryTTL();
        tLRPC$TL_messages_setHistoryTTL.peer = getInputPeer(did);
        tLRPC$TL_messages_setHistoryTTL.period = ttl;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_setHistoryTTL, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$-c1DrCGScUifIiK3Cyn3R8QGqdk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setDialogHistoryTTL$99$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
        TLRPC$ChatFull tLRPC$ChatFull = null;
        if (did > 0) {
            userFull = getUserFull(did);
            if (userFull == null) {
                return;
            }
            userFull.ttl_period = ttl;
            userFull.flags |= 16384;
        } else {
            TLRPC$ChatFull chatFull = getChatFull(-did);
            if (chatFull == null) {
                return;
            }
            chatFull.ttl_period = ttl;
            if (chatFull instanceof TLRPC$TL_channelFull) {
                chatFull.flags |= ConnectionsManager.FileTypePhoto;
            } else {
                chatFull.flags |= 16384;
            }
            userFull = null;
            tLRPC$ChatFull = chatFull;
        }
        if (tLRPC$ChatFull != null) {
            NotificationCenter notificationCenter = getNotificationCenter();
            int i = NotificationCenter.chatInfoDidLoad;
            Boolean bool = Boolean.FALSE;
            notificationCenter.postNotificationName(i, tLRPC$ChatFull, 0, bool, bool);
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.userInfoDidLoad, Long.valueOf(did), userFull);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDialogHistoryTTL$99, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDialogHistoryTTL$99$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public void setDialogsInTransaction(boolean transaction) {
        this.dialogsInTransaction = transaction;
        if (transaction) {
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0329  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void deleteDialog(final long r27, int r29, final int r30, int r31, final boolean r32, final ir.eitaa.tgnet.TLRPC$InputPeer r33, final long r34) {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.deleteDialog(long, int, int, int, boolean, ir.eitaa.tgnet.TLRPC$InputPeer, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteDialog$100, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteDialog$100$MessagesController(long j, int i, boolean z, TLRPC$InputPeer tLRPC$InputPeer, long j2, int i2) {
        deleteDialog(j, 2, i, Math.max(0, i2), z, tLRPC$InputPeer, j2);
        checkIfFolderEmpty(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteDialog$101, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteDialog$101$MessagesController(long j) {
        getNotificationsController().removeNotificationsForDialog(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteDialog$102, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteDialog$102$MessagesController(final long j) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Zbhzf5qHyKg4wzXIaQAGco0y0yg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteDialog$101$MessagesController(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteDialog$103, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteDialog$103$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteDialog$104, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteDialog$104$MessagesController(long j, long j2, int i, int i2, boolean z, TLRPC$InputPeer tLRPC$InputPeer, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedHistory tLRPC$TL_messages_affectedHistory = (TLRPC$TL_messages_affectedHistory) tLObject;
            if (tLRPC$TL_messages_affectedHistory.offset > 0) {
                deleteDialog(j2, 0, i, i2, z, tLRPC$InputPeer, 0L);
            }
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedHistory.pts, -1, tLRPC$TL_messages_affectedHistory.pts_count);
            getMessagesStorage().onDeleteQueryComplete(j2);
        }
    }

    public void saveGif(final Object parentObject, TLRPC$Document document) {
        if (parentObject == null || !MessageObject.isGifDocument(document)) {
            return;
        }
        final TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif = new TLRPC$TL_messages_saveGif();
        TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
        tLRPC$TL_messages_saveGif.id = tLRPC$TL_inputDocument;
        tLRPC$TL_inputDocument.id = document.id;
        tLRPC$TL_inputDocument.access_hash = document.access_hash;
        byte[] bArr = document.file_reference;
        tLRPC$TL_inputDocument.file_reference = bArr;
        if (bArr == null) {
            tLRPC$TL_inputDocument.file_reference = new byte[0];
        }
        tLRPC$TL_messages_saveGif.unsave = false;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_saveGif, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$UDCJKtGX0khtdvEsEBa_hcS7Dqc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$saveGif$105$MessagesController(parentObject, tLRPC$TL_messages_saveGif, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveGif$105, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveGif$105$MessagesController(Object obj, TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || !FileRefController.isFileRefError(tLRPC$TL_error.text)) {
            return;
        }
        getFileRefController().requestReference(obj, tLRPC$TL_messages_saveGif);
    }

    public void saveRecentSticker(final Object parentObject, TLRPC$Document document, boolean asMask) {
        if (parentObject == null || document == null) {
            return;
        }
        final TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker = new TLRPC$TL_messages_saveRecentSticker();
        TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
        tLRPC$TL_messages_saveRecentSticker.id = tLRPC$TL_inputDocument;
        tLRPC$TL_inputDocument.id = document.id;
        tLRPC$TL_inputDocument.access_hash = document.access_hash;
        byte[] bArr = document.file_reference;
        tLRPC$TL_inputDocument.file_reference = bArr;
        if (bArr == null) {
            tLRPC$TL_inputDocument.file_reference = new byte[0];
        }
        tLRPC$TL_messages_saveRecentSticker.unsave = false;
        tLRPC$TL_messages_saveRecentSticker.attached = asMask;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_saveRecentSticker, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$WGpiCj0G-lAKwWDk4ToF5LPUU8c
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$saveRecentSticker$106$MessagesController(parentObject, tLRPC$TL_messages_saveRecentSticker, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveRecentSticker$106, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveRecentSticker$106$MessagesController(Object obj, TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || !FileRefController.isFileRefError(tLRPC$TL_error.text)) {
            return;
        }
        getFileRefController().requestReference(obj, tLRPC$TL_messages_saveRecentSticker);
    }

    public void loadChannelParticipants(final Long chatId) {
        if (this.loadingFullParticipants.contains(chatId) || this.loadedFullParticipants.contains(chatId)) {
            return;
        }
        this.loadingFullParticipants.add(chatId);
        TLRPC$TL_channels_getParticipants_2 tLRPC$TL_channels_getParticipants_2 = new TLRPC$TL_channels_getParticipants_2();
        tLRPC$TL_channels_getParticipants_2.channel = getInputChannel(chatId.longValue());
        tLRPC$TL_channels_getParticipants_2.filter = new TLRPC$TL_channelParticipantsRecent();
        tLRPC$TL_channels_getParticipants_2.offset = 0;
        tLRPC$TL_channels_getParticipants_2.limit = 32;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipants_2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$rC0id5OCmxthrE0wS27OOWQeAnE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadChannelParticipants$108$MessagesController(chatId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChannelParticipants$108, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChannelParticipants$108$MessagesController(final Long l, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$LdadWfiTdLGFCid2oV9CNfmn7WU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChannelParticipants$107$MessagesController(tLRPC$TL_error, tLObject, l);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChannelParticipants$107, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChannelParticipants$107$MessagesController(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, Long l) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
            putUsers(tLRPC$TL_channels_channelParticipants.users, false);
            putChats(tLRPC$TL_channels_channelParticipants.chats, false);
            getMessagesStorage().putUsersAndChats(tLRPC$TL_channels_channelParticipants.users, tLRPC$TL_channels_channelParticipants.chats, true, true);
            getMessagesStorage().updateChannelUsers(l.longValue(), tLRPC$TL_channels_channelParticipants.participants);
            this.loadedFullParticipants.add(l);
        }
        this.loadingFullParticipants.remove(l);
    }

    public void putChatFull(TLRPC$ChatFull chatFull) {
        this.fullChats.put(chatFull.id, chatFull);
    }

    public void loadChatInfo(final long chat_id, boolean isChannel, CountDownLatch countDownLatch, boolean force) {
        MessagesStorage.getInstance(this.currentAccount).loadChatInfo(chat_id, isChannel, countDownLatch, force, false);
    }

    public void processChatInfo(final long chatId, final TLRPC$ChatFull info, final ArrayList<TLRPC$User> usersArr, final boolean fromCache, final boolean force, final boolean byChannelUsers, final ArrayList<Integer> pinnedMessages, final HashMap<Integer, MessageObject> pinnedMessagesMap, final int totalPinnedCount, final boolean pinnedEndReached) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$6FJoLFy68DE9YLAFRT0dABlxwOQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processChatInfo$109$MessagesController(fromCache, chatId, byChannelUsers, force, info, usersArr, pinnedMessages, pinnedMessagesMap, totalPinnedCount, pinnedEndReached);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processChatInfo$109, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processChatInfo$109$MessagesController(boolean z, long j, boolean z2, boolean z3, TLRPC$ChatFull tLRPC$ChatFull, ArrayList arrayList, ArrayList arrayList2, HashMap map, int i, boolean z4) {
        if (z && j > 0 && !z2) {
            loadFullChat(j, 0, z3);
        }
        if (tLRPC$ChatFull != null) {
            if (this.fullChats.get(j) == null) {
                this.fullChats.put(j, tLRPC$ChatFull);
            }
            putUsers(arrayList, z);
            if (tLRPC$ChatFull.stickerset != null) {
                getMediaDataController().getGroupStickerSetById(tLRPC$ChatFull.stickerset);
            }
            getNotificationCenter().postNotificationName(NotificationCenter.chatInfoDidLoad, tLRPC$ChatFull, 0, Boolean.valueOf(z2), Boolean.FALSE);
        }
        if (arrayList2 != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.pinnedInfoDidLoad, Long.valueOf(-j), arrayList2, map, Integer.valueOf(i), Boolean.valueOf(z4));
        }
    }

    public void loadUserInfo(TLRPC$User user, boolean force, int classGuid) {
        loadUserInfo(user, force, classGuid, 0);
    }

    public void loadUserInfo(TLRPC$User user, boolean force, int classGuid, int fromMessageId) {
        getMessagesStorage().loadUserInfo(user, force, classGuid, fromMessageId);
    }

    public void processUserInfo(final TLRPC$User user, final TLRPC$UserFull info, final boolean fromCache, final boolean force, final int classGuid, final ArrayList<Integer> pinnedMessages, final HashMap<Integer, MessageObject> pinnedMessagesMap, final int totalPinnedCount, final boolean pinnedEndReached) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$fGGskP9sij-dHJyM8PucF9scXCk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUserInfo$110$MessagesController(fromCache, user, classGuid, force, info, pinnedMessages, pinnedMessagesMap, totalPinnedCount, pinnedEndReached);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUserInfo$110, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUserInfo$110$MessagesController(boolean z, TLRPC$User tLRPC$User, int i, boolean z2, TLRPC$UserFull tLRPC$UserFull, ArrayList arrayList, HashMap map, int i2, boolean z3) {
        if (z) {
            loadFullUser(tLRPC$User, i, z2);
        }
        if (tLRPC$UserFull != null) {
            if (this.fullUsers.get(tLRPC$User.id) == null) {
                this.fullUsers.put(tLRPC$User.id, tLRPC$UserFull);
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
            }
            getNotificationCenter().postNotificationName(NotificationCenter.userInfoDidLoad, Long.valueOf(tLRPC$User.id), tLRPC$UserFull);
        }
        if (arrayList != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.pinnedInfoDidLoad, Long.valueOf(tLRPC$User.id), arrayList, map, Integer.valueOf(i2), Boolean.valueOf(z3));
        }
    }

    public void updateTimerProc() throws InterruptedException {
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        checkDeletingTask(false);
        checkReadTasks();
        long j = this.recommendCacheClearTime;
        if (j == 0) {
            this.recommendCacheClearTime = jCurrentTimeMillis;
        } else if (jCurrentTimeMillis - j > 300000) {
            this.recommendCacheIndex = 0;
            this.recommendCacheMessages.clear();
            this.recommendCacheClearTime = jCurrentTimeMillis;
        }
        if (getUserConfig().isClientActivated()) {
            if (!this.ignoreSetOnline && getConnectionsManager().getPauseTime() == 0 && ApplicationLoader.isScreenOn && !ApplicationLoader.mainInterfacePausedStageQueue) {
                if (ApplicationLoader.mainInterfacePausedStageQueueTime != 0 && Math.abs(ApplicationLoader.mainInterfacePausedStageQueueTime - System.currentTimeMillis()) > 1000 && this.statusSettingState != 1 && (this.lastStatusUpdateTime == 0 || Math.abs(System.currentTimeMillis() - this.lastStatusUpdateTime) >= 55000 || this.offlineSent)) {
                    this.statusSettingState = 1;
                    if (this.statusRequest != 0) {
                        getConnectionsManager().cancelRequest(this.statusRequest, true);
                    }
                    TLRPC$TL_account_updateStatus tLRPC$TL_account_updateStatus = new TLRPC$TL_account_updateStatus();
                    tLRPC$TL_account_updateStatus.offline = false;
                    this.statusRequest = getConnectionsManager().sendRequest(tLRPC$TL_account_updateStatus, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$6Cb9WuIFt---qsurwArtDTxPAfw
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$updateTimerProc$111$MessagesController(tLObject, tLRPC$TL_error);
                        }
                    });
                }
            } else if (this.statusSettingState != 2 && !this.offlineSent && Math.abs(System.currentTimeMillis() - getConnectionsManager().getPauseTime()) >= 2000) {
                this.statusSettingState = 2;
                if (this.statusRequest != 0) {
                    getConnectionsManager().cancelRequest(this.statusRequest, true);
                }
                TLRPC$TL_account_updateStatus tLRPC$TL_account_updateStatus2 = new TLRPC$TL_account_updateStatus();
                tLRPC$TL_account_updateStatus2.offline = true;
                this.statusRequest = getConnectionsManager().sendRequest(tLRPC$TL_account_updateStatus2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ekLGa4ev9NwcrZhWPyUdZ8i6LYs
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$updateTimerProc$112$MessagesController(tLObject, tLRPC$TL_error);
                    }
                });
            }
            if (this.updatesQueueChannels.size() != 0) {
                for (int i4 = 0; i4 < this.updatesQueueChannels.size(); i4++) {
                    long jKeyAt = this.updatesQueueChannels.keyAt(i4);
                    if (Math.abs(jCurrentTimeMillis - this.updatesStartWaitTimeChannels.valueAt(i4)) >= 1500) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("QUEUE CHANNEL " + jKeyAt + " UPDATES WAIT TIMEOUT - CHECK QUEUE");
                        }
                        processChannelsUpdatesQueue(jKeyAt, 0);
                    }
                }
            }
            for (int i5 = 0; i5 < 3; i5++) {
                if (getUpdatesStartTime(i5) != 0 && Math.abs(jCurrentTimeMillis - getUpdatesStartTime(i5)) >= 1500) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d(i5 + " QUEUE UPDATES WAIT TIMEOUT - CHECK QUEUE");
                    }
                    processUpdatesQueue(i5, 0);
                }
            }
        }
        if (this.livesToCheckSize > 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Yvu1EdIvYmsZ5AVYQgLG6fsKDj4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateTimerProc$114$MessagesController();
                }
            });
        }
        if (this.shopTileViewsToSend.size() >= 10) {
            TLRPC$TL_stat_reportShopTileView tLRPC$TL_stat_reportShopTileView = new TLRPC$TL_stat_reportShopTileView();
            for (int size = this.shopTileViewsToSend.size() - 1; size >= 0; size--) {
                tLRPC$TL_stat_reportShopTileView.shopTiles.add(this.shopTileViewsToSend.get(size));
                this.shopTileViewsToSend.remove(size);
            }
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_stat_reportShopTileView, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$crQsVD2R-FcooD_kfTIRBGg60zY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$updateTimerProc$115(tLObject, tLRPC$TL_error);
                }
            });
        }
        if (this.adViewsToSend.size() != 0 && Math.abs(System.currentTimeMillis() - this.lastAdViewsCheckTime) >= 5000) {
            this.lastAdViewsCheckTime = System.currentTimeMillis();
            TLRPC$TL_stat_reportAdView tLRPC$TL_stat_reportAdView = new TLRPC$TL_stat_reportAdView();
            for (int size2 = this.adViewsToSend.size() - 1; size2 >= 0; size2--) {
                tLRPC$TL_stat_reportAdView.statAds.add(this.adViewsToSend.get(size2));
                this.adViewsToSend.remove(size2);
            }
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_stat_reportAdView, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$6mVSzm_gTSg3acO-KNwXZq6hZ_Q
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$updateTimerProc$116(tLObject, tLRPC$TL_error);
                }
            });
        }
        if (this.adActionsToSend.size() != 0) {
            for (int size3 = this.adActionsToSend.size() - 1; size3 >= 0; size3--) {
                TLRPC$TL_stat_reportAdActionPerformed tLRPC$TL_stat_reportAdActionPerformed = new TLRPC$TL_stat_reportAdActionPerformed();
                tLRPC$TL_stat_reportAdActionPerformed.statAd = this.adActionsToSend.get(size3);
                ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_stat_reportAdActionPerformed, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Mi_-PcsdpBTrI6rQUyUKwae4QBM
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        MessagesController.lambda$updateTimerProc$117(tLObject, tLRPC$TL_error);
                    }
                });
                this.adActionsToSend.remove(size3);
            }
        }
        final int currentTime = getConnectionsManager().getCurrentTime();
        if (Math.abs(System.currentTimeMillis() - this.lastViewsCheckTime) >= 5000) {
            this.lastViewsCheckTime = System.currentTimeMillis();
            if (this.channelViewsToSend.size() != 0) {
                int i6 = 0;
                while (i6 < this.channelViewsToSend.size()) {
                    final long jKeyAt2 = this.channelViewsToSend.keyAt(i6);
                    ArrayList<Long> arrayListValueAt = this.channelViewsToSend.valueAt(i6);
                    SparseArray sparseArray = new SparseArray();
                    Iterator<Long> it = arrayListValueAt.iterator();
                    while (it.hasNext()) {
                        long jLongValue = it.next().longValue();
                        int i7 = (int) jLongValue;
                        int i8 = (int) (jLongValue >> 32);
                        ArrayList arrayList2 = (ArrayList) sparseArray.get(i8);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            sparseArray.put(i8, arrayList2);
                        }
                        arrayList2.add(Integer.valueOf(i7));
                    }
                    final TLRPC$TL_messages_getMessagesViews tLRPC$TL_messages_getMessagesViews = new TLRPC$TL_messages_getMessagesViews();
                    for (int i9 = 0; i9 < sparseArray.size(); i9++) {
                        tLRPC$TL_messages_getMessagesViews.peer = getInputPeer(jKeyAt2);
                        int iKeyAt = sparseArray.keyAt(i9);
                        tLRPC$TL_messages_getMessagesViews.id = (ArrayList) sparseArray.valueAt(i9);
                        tLRPC$TL_messages_getMessagesViews.flags = iKeyAt;
                        tLRPC$TL_messages_getMessagesViews.increment = i6 == 0;
                        getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessagesViews, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Oa0v6rjoVe_bbtkcjiIywZxnukQ
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$updateTimerProc$119$MessagesController(jKeyAt2, tLRPC$TL_messages_getMessagesViews, tLObject, tLRPC$TL_error);
                            }
                        });
                    }
                    i6++;
                }
                this.channelViewsToSend.clear();
            }
            if (this.pollsToCheckSize > 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$hC69dkSRGn5az0T0vDBdkPLLbwA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateTimerProc$121$MessagesController(currentTime);
                    }
                });
            }
        }
        if (!this.onlinePrivacy.isEmpty()) {
            ArrayList arrayList3 = null;
            for (Map.Entry entry : this.onlinePrivacy.entrySet()) {
                if (((Integer) entry.getValue()).intValue() < currentTime - 30) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add((Long) entry.getKey());
                }
            }
            if (arrayList3 != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    this.onlinePrivacy.remove((Long) it2.next());
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$lwcMoxQKw1JEhwKfrcYzV9aCOcY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateTimerProc$122$MessagesController();
                    }
                });
            }
        }
        if (this.shortPollChannels.size() != 0) {
            int i10 = 0;
            while (i10 < this.shortPollChannels.size()) {
                long jKeyAt3 = this.shortPollChannels.keyAt(i10);
                if (this.shortPollChannels.valueAt(i10) < System.currentTimeMillis() / 1000) {
                    this.shortPollChannels.delete(jKeyAt3);
                    i10--;
                    if (this.needShortPollChannels.indexOfKey(jKeyAt3) >= 0) {
                        getChannelDifference(jKeyAt3);
                    }
                }
                i10++;
            }
        }
        if (this.shortPollOnlines.size() != 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            int i11 = 0;
            while (i11 < this.shortPollOnlines.size()) {
                final long jKeyAt4 = this.shortPollOnlines.keyAt(i11);
                if (this.shortPollOnlines.valueAt(i11) < jElapsedRealtime) {
                    if (this.needShortPollChannels.indexOfKey(jKeyAt4) >= 0) {
                        this.shortPollOnlines.put(jKeyAt4, (int) (300 + jElapsedRealtime));
                    } else {
                        this.shortPollOnlines.delete(jKeyAt4);
                        i11--;
                    }
                    TLRPC$TL_messages_getOnlines tLRPC$TL_messages_getOnlines = new TLRPC$TL_messages_getOnlines();
                    tLRPC$TL_messages_getOnlines.peer = getInputPeer(-jKeyAt4);
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_getOnlines, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$-FhBEnpHCAssi5PrMh8PeKRip8Y
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$updateTimerProc$124$MessagesController(jKeyAt4, tLObject, tLRPC$TL_error);
                        }
                    });
                }
                i11++;
            }
        }
        if (this.printingUsers.isEmpty() && this.lastPrintingStringCount == this.printingUsers.size()) {
            i = 1;
        } else {
            ArrayList arrayList4 = new ArrayList(this.printingUsers.keySet());
            int i12 = 0;
            boolean z = false;
            while (i12 < arrayList4.size()) {
                Long l = (Long) arrayList4.get(i12);
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.printingUsers.get(l);
                if (concurrentHashMap != null) {
                    ArrayList arrayList5 = new ArrayList(concurrentHashMap.keySet());
                    int i13 = 0;
                    while (i13 < arrayList5.size()) {
                        Integer num = (Integer) arrayList5.get(i13);
                        ArrayList arrayList6 = (ArrayList) concurrentHashMap.get(num);
                        if (arrayList6 != null) {
                            int i14 = 0;
                            while (i14 < arrayList6.size()) {
                                PrintingUser printingUser = (PrintingUser) arrayList6.get(i14);
                                int i15 = i12;
                                ArrayList arrayList7 = arrayList4;
                                if (printingUser.lastTime + (printingUser.action instanceof TLRPC$TL_sendMessageGamePlayAction ? 30000 : 5900) < jCurrentTimeMillis) {
                                    arrayList6.remove(printingUser);
                                    i14--;
                                    i3 = 1;
                                    z = true;
                                } else {
                                    i3 = 1;
                                }
                                i14 += i3;
                                i12 = i15;
                                arrayList4 = arrayList7;
                            }
                        }
                        ArrayList arrayList8 = arrayList4;
                        int i16 = i12;
                        if (arrayList6 == null || arrayList6.isEmpty()) {
                            concurrentHashMap.remove(num);
                            arrayList5.remove(i13);
                            i13--;
                        }
                        i13++;
                        i12 = i16;
                        arrayList4 = arrayList8;
                    }
                }
                ArrayList arrayList9 = arrayList4;
                int i17 = i12;
                if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
                    this.printingUsers.remove(l);
                    arrayList = arrayList9;
                    arrayList.remove(i17);
                    i2 = i17 - 1;
                } else {
                    i2 = i17;
                    arrayList = arrayList9;
                }
                i12 = i2 + 1;
                arrayList4 = arrayList;
            }
            i = 1;
            updatePrintingStrings();
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$HTw8OCcOzceL7cYSsmBcZG3OXYk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateTimerProc$125$MessagesController();
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
        if (!ConnectionsManager.getInstance(this.currentAccount).getAppPaused()) {
            checkDialogAd();
        }
        getLocationController().update();
        cleanTempCache();
        lambda$checkPromoInfo$130(false);
        checkTosUpdate();
        checkReportReasons();
        checkLiveChats();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$111, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$111$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.lastStatusUpdateTime = System.currentTimeMillis();
            this.offlineSent = false;
            this.statusSettingState = 0;
        } else {
            long j = this.lastStatusUpdateTime;
            if (j != 0) {
                this.lastStatusUpdateTime = j + 5000;
            }
        }
        this.statusRequest = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$112, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$112$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.offlineSent = true;
        } else {
            long j = this.lastStatusUpdateTime;
            if (j != 0) {
                this.lastStatusUpdateTime = j + 5000;
            }
        }
        this.statusRequest = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$114, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$114$MessagesController() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        int size = this.livesToCheck.size();
        int i = 0;
        while (i < size) {
            SparseArray<MessageObject> sparseArrayValueAt = this.livesToCheck.valueAt(i);
            if (sparseArrayValueAt != null) {
                int size2 = sparseArrayValueAt.size();
                int i2 = 0;
                while (i2 < size2) {
                    final MessageObject messageObjectValueAt = sparseArrayValueAt.valueAt(i2);
                    if (Math.abs(jUptimeMillis - messageObjectValueAt.liveLastCheckTime) < 30000) {
                        if (!messageObjectValueAt.liveVisibleOnScreen) {
                            sparseArrayValueAt.remove(messageObjectValueAt.getId());
                            size2--;
                            i2--;
                        }
                    } else {
                        messageObjectValueAt.liveLastCheckTime = jUptimeMillis;
                        TLRPC$TL_Live_getMedia tLRPC$TL_Live_getMedia = new TLRPC$TL_Live_getMedia();
                        final TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream = (TLRPC$TL_messageMediaLiveStream) messageObjectValueAt.messageOwner.media;
                        tLRPC$TL_Live_getMedia.id = tLRPC$TL_messageMediaLiveStream.id;
                        tLRPC$TL_Live_getMedia.access_hash = tLRPC$TL_messageMediaLiveStream.access_hash;
                        tLRPC$TL_Live_getMedia.flags = 0;
                        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_Live_getMedia, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$KCm9bRpC0ULwhEGzQnkV4klTlCI
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$updateTimerProc$113$MessagesController(tLRPC$TL_messageMediaLiveStream, messageObjectValueAt, tLObject, tLRPC$TL_error);
                            }
                        });
                    }
                    i2++;
                }
                if (sparseArrayValueAt.size() == 0) {
                    android.util.LongSparseArray<SparseArray<MessageObject>> longSparseArray = this.livesToCheck;
                    longSparseArray.remove(longSparseArray.keyAt(i));
                    size--;
                    i--;
                }
            }
            i++;
        }
        this.livesToCheckSize = this.livesToCheck.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$113, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$113$MessagesController(TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream, final MessageObject messageObject, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream2 = (TLRPC$TL_messageMediaLiveStream) tLObject;
            MessageObject.updateLiveMedia(tLRPC$TL_messageMediaLiveStream, tLRPC$TL_messageMediaLiveStream2);
            MessagesStorage.getInstance(this.currentAccount).updateMessageLiveMedia(messageObject.messageOwner, tLRPC$TL_messageMediaLiveStream2);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MessagesController.1
                @Override // java.lang.Runnable
                public void run() {
                    NotificationCenter.getInstance(MessagesController.this.currentAccount).postNotificationName(NotificationCenter.didUpdateLive, messageObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$119, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$119$MessagesController(long j, TLRPC$TL_messages_getMessagesViews tLRPC$TL_messages_getMessagesViews, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$TL_messages_messageViews tLRPC$TL_messages_messageViews = (TLRPC$TL_messages_messageViews) tLObject;
            final LongSparseArray<SparseIntArray> longSparseArray = new LongSparseArray<>();
            final LongSparseArray<SparseIntArray> longSparseArray2 = new LongSparseArray<>();
            final LongSparseArray<SparseArray<TLRPC$MessageReplies>> longSparseArray3 = new LongSparseArray<>();
            SparseIntArray sparseIntArray = longSparseArray.get(j);
            SparseIntArray sparseIntArray2 = longSparseArray2.get(j);
            SparseArray<TLRPC$MessageReplies> sparseArray = longSparseArray3.get(j);
            for (int i = 0; i < tLRPC$TL_messages_getMessagesViews.id.size() && i < tLRPC$TL_messages_messageViews.views.size(); i++) {
                TLRPC$TL_messageViews tLRPC$TL_messageViews = tLRPC$TL_messages_messageViews.views.get(i);
                if ((1 & tLRPC$TL_messageViews.flags) != 0) {
                    if (sparseIntArray == null) {
                        sparseIntArray = new SparseIntArray();
                        longSparseArray.put(j, sparseIntArray);
                    }
                    sparseIntArray.put(tLRPC$TL_messages_getMessagesViews.id.get(i).intValue(), tLRPC$TL_messageViews.views);
                }
                if ((tLRPC$TL_messageViews.flags & 2) != 0) {
                    if (sparseIntArray2 == null) {
                        sparseIntArray2 = new SparseIntArray();
                        longSparseArray2.put(j, sparseIntArray2);
                    }
                    sparseIntArray2.put(tLRPC$TL_messages_getMessagesViews.id.get(i).intValue(), tLRPC$TL_messageViews.forwards);
                }
                if ((tLRPC$TL_messageViews.flags & 4) != 0) {
                    if (sparseArray == null) {
                        sparseArray = new SparseArray<>();
                        longSparseArray3.put(j, sparseArray);
                    }
                    sparseArray.put(tLRPC$TL_messages_getMessagesViews.id.get(i).intValue(), tLRPC$TL_messageViews.replies);
                }
            }
            getMessagesStorage().putUsersAndChats(tLRPC$TL_messages_messageViews.users, tLRPC$TL_messages_messageViews.chats, true, true);
            getMessagesStorage().putChannelViews(longSparseArray, longSparseArray2, longSparseArray3, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$IXtsmtsRgPgHPnli3X3M8UP8cco
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateTimerProc$118$MessagesController(tLRPC$TL_messages_messageViews, longSparseArray, longSparseArray2, longSparseArray3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$118, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$118$MessagesController(TLRPC$TL_messages_messageViews tLRPC$TL_messages_messageViews, LongSparseArray longSparseArray, LongSparseArray longSparseArray2, LongSparseArray longSparseArray3) {
        putUsers(tLRPC$TL_messages_messageViews.users, false);
        putChats(tLRPC$TL_messages_messageViews.chats, false);
        getNotificationCenter().postNotificationName(NotificationCenter.didUpdateMessagesViews, longSparseArray, longSparseArray2, longSparseArray3, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$121, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$121$MessagesController(int i) {
        int i2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int size = this.pollsToCheck.size();
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int i3 = 0;
        while (i3 < size) {
            SparseArray<MessageObject> sparseArrayValueAt = this.pollsToCheck.valueAt(i3);
            if (sparseArrayValueAt != null) {
                int size2 = sparseArrayValueAt.size();
                int i4 = 0;
                while (true) {
                    int i5 = 1000;
                    if (i4 >= size2) {
                        break;
                    }
                    MessageObject messageObjectValueAt = sparseArrayValueAt.valueAt(i4);
                    TLRPC$Poll tLRPC$Poll = ((TLRPC$TL_messageMediaPoll) messageObjectValueAt.messageOwner.media).poll;
                    int i6 = tLRPC$Poll.close_date;
                    final boolean z = (i6 == 0 || tLRPC$Poll.closed) ? false : true;
                    if (!z) {
                        i2 = size2;
                        i5 = 30000;
                    } else if (i6 <= i) {
                        i2 = size2;
                    } else {
                        iMin = Math.min(iMin, i6 - i);
                        i2 = size2;
                        i5 = 30000;
                    }
                    int i7 = iMin;
                    if (Math.abs(jElapsedRealtime - messageObjectValueAt.pollLastCheckTime) < i5) {
                        if (!messageObjectValueAt.pollVisibleOnScreen && !z) {
                            sparseArrayValueAt.remove(messageObjectValueAt.getId());
                            size2 = i2 - 1;
                            i4--;
                        }
                        i4++;
                        iMin = i7;
                    } else {
                        messageObjectValueAt.pollLastCheckTime = jElapsedRealtime;
                        TLRPC$TL_messages_getPollResults tLRPC$TL_messages_getPollResults = new TLRPC$TL_messages_getPollResults();
                        tLRPC$TL_messages_getPollResults.peer = getInputPeer(messageObjectValueAt.getDialogId());
                        tLRPC$TL_messages_getPollResults.msg_id = messageObjectValueAt.getId();
                        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPollResults, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$oEusDTbUyolF7fK-9dqO8AYw22U
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$updateTimerProc$120$MessagesController(z, tLObject, tLRPC$TL_error);
                            }
                        });
                    }
                    size2 = i2;
                    i4++;
                    iMin = i7;
                }
                if (iMin < 5) {
                    this.lastViewsCheckTime = Math.min(this.lastViewsCheckTime, System.currentTimeMillis() - ((5 - iMin) * 1000));
                }
                if (sparseArrayValueAt.size() == 0) {
                    LongSparseArray<SparseArray<MessageObject>> longSparseArray = this.pollsToCheck;
                    longSparseArray.remove(longSparseArray.keyAt(i3));
                    size--;
                    i3--;
                }
            }
            i3++;
        }
        this.pollsToCheckSize = this.pollsToCheck.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$120, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$120$MessagesController(boolean z, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        TLRPC$Poll tLRPC$Poll;
        if (tLRPC$TL_error == null) {
            TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            if (z) {
                for (int i = 0; i < tLRPC$Updates.updates.size(); i++) {
                    TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
                    if ((tLRPC$Update instanceof TLRPC$TL_updateMessagePoll) && (tLRPC$Poll = ((TLRPC$TL_updateMessagePoll) tLRPC$Update).poll) != null && !tLRPC$Poll.closed) {
                        this.lastViewsCheckTime = System.currentTimeMillis() - 4000;
                    }
                }
            }
            processUpdates(tLRPC$Updates, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$122, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$122$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_STATUS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$124, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$124$MessagesController(final long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$TL_chatOnlines tLRPC$TL_chatOnlines = (TLRPC$TL_chatOnlines) tLObject;
            getMessagesStorage().updateChatOnlineCount(j, tLRPC$TL_chatOnlines.onlines);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$0fbbFpaBza7Aqma_F3vgazD1uvI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateTimerProc$123$MessagesController(j, tLRPC$TL_chatOnlines);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$123, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$123$MessagesController(long j, TLRPC$TL_chatOnlines tLRPC$TL_chatOnlines) {
        getNotificationCenter().postNotificationName(NotificationCenter.chatOnlineCountDidLoad, Long.valueOf(j), Integer.valueOf(tLRPC$TL_chatOnlines.onlines));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTimerProc$125, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTimerProc$125$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_USER_PRINT));
    }

    private void checkLiveChats() {
        ArrayList<TLRPC$Chat> arrayList = new ArrayList();
        Iterator it = this.chats.keySet().iterator();
        while (it.hasNext()) {
            TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) this.chats.get(Long.valueOf(((Long) it.next()).longValue()));
            if (tLRPC$Chat.live_stream_msg_id != 0 && !ChatObject.isLeftFromChat(tLRPC$Chat)) {
                arrayList.add(tLRPC$Chat);
            }
        }
        arrayList.size();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MessagesController.2
            @Override // java.lang.Runnable
            public void run() {
                NotificationCenter.getInstance(MessagesController.this.currentAccount).postNotificationName(NotificationCenter.liveChatsNeedReload, new Object[0]);
            }
        });
        this.livechats.clear();
        for (TLRPC$Chat tLRPC$Chat2 : arrayList) {
            this.livechats.put(Integer.valueOf((int) tLRPC$Chat2.id), tLRPC$Chat2);
        }
    }

    private void checkTosUpdate() {
        if (this.nextTosCheckTime > getConnectionsManager().getCurrentTime() || this.checkingTosUpdate || !getUserConfig().isClientActivated()) {
            return;
        }
        this.checkingTosUpdate = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_getTermsOfServiceUpdate
            public static int constructor = 749019089;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$help_TermsOfServiceUpdate.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$meJF2o-JsPgyzC_Du4ulum4XIQs
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkTosUpdate$127$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkTosUpdate$127, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkTosUpdate$127$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        this.checkingTosUpdate = false;
        if (tLObject instanceof TLRPC$TL_help_termsOfServiceUpdateEmpty) {
            this.nextTosCheckTime = ((TLRPC$TL_help_termsOfServiceUpdateEmpty) tLObject).expires;
        } else if (tLObject instanceof TLRPC$TL_help_termsOfServiceUpdate) {
            final TLRPC$TL_help_termsOfServiceUpdate tLRPC$TL_help_termsOfServiceUpdate = (TLRPC$TL_help_termsOfServiceUpdate) tLObject;
            this.nextTosCheckTime = tLRPC$TL_help_termsOfServiceUpdate.expires;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$_INiYMYWPb4TsKqjUZMQhRYAzc4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkTosUpdate$126$MessagesController(tLRPC$TL_help_termsOfServiceUpdate);
                }
            });
        } else {
            this.nextTosCheckTime = getConnectionsManager().getCurrentTime() + 3600;
        }
        this.notificationsPreferences.edit().putInt("nextTosCheckTime", this.nextTosCheckTime).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkTosUpdate$126, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkTosUpdate$126$MessagesController(TLRPC$TL_help_termsOfServiceUpdate tLRPC$TL_help_termsOfServiceUpdate) {
        getNotificationCenter().postNotificationName(NotificationCenter.needShowAlert, 4, tLRPC$TL_help_termsOfServiceUpdate.terms_of_service);
    }

    public void sendDeviceUserIds() {
        TLRPC$TL_account_sendDeviceUserIds tLRPC$TL_account_sendDeviceUserIds = new TLRPC$TL_account_sendDeviceUserIds();
        for (int i = 0; i < 3; i++) {
            if (UserConfig.isValidAccount(i)) {
                tLRPC$TL_account_sendDeviceUserIds.userIds.add(Long.valueOf(UserConfig.getInstance(i).clientUserId));
            }
        }
        getAccountInstance().getConnectionsManager().sendRequest(tLRPC$TL_account_sendDeviceUserIds, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$1oqh5MYDBydE6X9ND-fHHVu4aHc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$2uj-Uc2DiobGW0njw9D-xmuie5s
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessagesController.lambda$sendDeviceUserIds$128(tLObject);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$sendDeviceUserIds$128(TLObject tLObject) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            SharedConfig.updateSentDeviceUserIds(true);
        } else {
            SharedConfig.updateSentDeviceUserIds(false);
        }
    }

    public void checkPromoInfo(final boolean reset) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$sx3H1KrcRs4XLqAv7z-6umpsM8k
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkPromoInfo$130$MessagesController(reset);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkPromoInfoInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$checkPromoInfo$130$MessagesController(boolean reset) {
        String str;
        boolean z = false;
        if (reset && this.checkingPromoInfo) {
            this.checkingPromoInfo = false;
        }
        if ((reset || this.nextPromoInfoCheckTime <= getConnectionsManager().getCurrentTime()) && !this.checkingPromoInfo) {
            if (this.checkingPromoInfoRequestId != 0) {
                getConnectionsManager().cancelRequest(this.checkingPromoInfoRequestId, true);
                this.checkingPromoInfoRequestId = 0;
            }
            SharedPreferences globalMainSettings = getGlobalMainSettings();
            globalMainSettings.getBoolean("proxy_enabled", false);
            final String string = globalMainSettings.getString("proxy_ip", "");
            final String string2 = globalMainSettings.getString("proxy_secret", "");
            if (this.promoDialogId != 0 && this.promoDialogType == PROMO_TYPE_PROXY && (str = this.proxyDialogAddress) != null) {
                if (!str.equals(string + string2)) {
                    z = true;
                }
            }
            final int i = this.lastCheckPromoId + 1;
            this.lastCheckPromoId = i;
            this.checkingPromoInfo = true;
            this.checkingPromoInfoRequestId = getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_getPromoData
                public static int constructor = -1063816159;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$help_PromoData.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$m__BkHmm1TblKS0GgbtAR-M4in8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$checkPromoInfoInternal$135$MessagesController(i, string, string2, tLObject, tLRPC$TL_error);
                }
            });
            if (z) {
                this.promoDialogId = 0L;
                this.proxyDialogAddress = null;
                this.nextPromoInfoCheckTime = getConnectionsManager().getCurrentTime() + 3600;
                getGlobalMainSettings().edit().putLong("proxy_dialog", this.promoDialogId).remove("proxyDialogAddress").putInt("nextPromoInfoCheckTime", this.nextPromoInfoCheckTime).commit();
                AndroidUtilities.runOnUIThread(new $$Lambda$MessagesController$og_uVNDITyR6Mkc5OjMbP3_qV3o(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: lambda$checkPromoInfoInternal$135, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$checkPromoInfoInternal$135$MessagesController(final int r17, java.lang.String r18, java.lang.String r19, ir.eitaa.tgnet.TLObject r20, ir.eitaa.tgnet.TLRPC$TL_error r21) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$checkPromoInfoInternal$135$MessagesController(int, java.lang.String, java.lang.String, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkPromoInfoInternal$134, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPromoInfoInternal$134$MessagesController(final long j, final TLRPC$TL_help_promoData tLRPC$TL_help_promoData, final int i) {
        TLRPC$Dialog tLRPC$Dialog = this.promoDialog;
        if (tLRPC$Dialog != null && j != tLRPC$Dialog.id) {
            removePromoDialog();
        }
        TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(j);
        this.promoDialog = tLRPC$Dialog2;
        if (tLRPC$Dialog2 != null) {
            this.checkingPromoInfo = false;
            sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
            return;
        }
        LongSparseArray longSparseArray = new LongSparseArray();
        LongSparseArray longSparseArray2 = new LongSparseArray();
        for (int i2 = 0; i2 < tLRPC$TL_help_promoData.users.size(); i2++) {
            TLRPC$User tLRPC$User = tLRPC$TL_help_promoData.users.get(i2);
            longSparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        for (int i3 = 0; i3 < tLRPC$TL_help_promoData.chats.size(); i3++) {
            TLRPC$Chat tLRPC$Chat = tLRPC$TL_help_promoData.chats.get(i3);
            longSparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
        }
        TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs = new TLRPC$TL_messages_getPeerDialogs();
        TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
        TLRPC$Peer tLRPC$Peer = tLRPC$TL_help_promoData.peer;
        if (tLRPC$Peer.user_id != 0) {
            TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
            tLRPC$TL_inputDialogPeer.peer = tLRPC$TL_inputPeerUser;
            long j2 = tLRPC$TL_help_promoData.peer.user_id;
            tLRPC$TL_inputPeerUser.user_id = j2;
            TLRPC$User tLRPC$User2 = (TLRPC$User) longSparseArray.get(j2);
            if (tLRPC$User2 != null) {
                tLRPC$TL_inputDialogPeer.peer.access_hash = tLRPC$User2.access_hash;
            }
        } else if (tLRPC$Peer.chat_id != 0) {
            TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            tLRPC$TL_inputDialogPeer.peer = tLRPC$TL_inputPeerChat;
            long j3 = tLRPC$TL_help_promoData.peer.chat_id;
            tLRPC$TL_inputPeerChat.chat_id = j3;
            TLRPC$Chat tLRPC$Chat2 = (TLRPC$Chat) longSparseArray2.get(j3);
            if (tLRPC$Chat2 != null) {
                tLRPC$TL_inputDialogPeer.peer.access_hash = tLRPC$Chat2.access_hash;
            }
        } else {
            TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
            tLRPC$TL_inputDialogPeer.peer = tLRPC$TL_inputPeerChannel;
            long j4 = tLRPC$TL_help_promoData.peer.channel_id;
            tLRPC$TL_inputPeerChannel.channel_id = j4;
            TLRPC$Chat tLRPC$Chat3 = (TLRPC$Chat) longSparseArray2.get(j4);
            if (tLRPC$Chat3 != null) {
                tLRPC$TL_inputDialogPeer.peer.access_hash = tLRPC$Chat3.access_hash;
            }
        }
        tLRPC$TL_messages_getPeerDialogs.peers.add(tLRPC$TL_inputDialogPeer.peer);
        this.checkingPromoInfoRequestId = getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$KH5YM0vOwkkXmbG6xBxjsH9-1X4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkPromoInfoInternal$133$MessagesController(i, tLRPC$TL_help_promoData, j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkPromoInfoInternal$133, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPromoInfoInternal$133$MessagesController(int i, final TLRPC$TL_help_promoData tLRPC$TL_help_promoData, final long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (i != this.lastCheckPromoId) {
            return;
        }
        this.checkingPromoInfoRequestId = 0;
        final TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = (TLRPC$TL_messages_peerDialogs) tLObject;
        if (tLRPC$TL_messages_peerDialogs != null && !tLRPC$TL_messages_peerDialogs.dialogs.isEmpty()) {
            getMessagesStorage().putUsersAndChats(tLRPC$TL_help_promoData.users, tLRPC$TL_help_promoData.chats, true, true);
            TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
            tLRPC$TL_messages_dialogs.chats = tLRPC$TL_messages_peerDialogs.chats;
            tLRPC$TL_messages_dialogs.users = tLRPC$TL_messages_peerDialogs.users;
            tLRPC$TL_messages_dialogs.dialogs = tLRPC$TL_messages_peerDialogs.dialogs;
            tLRPC$TL_messages_dialogs.messages = tLRPC$TL_messages_peerDialogs.messages;
            getMessagesStorage().putDialogs(tLRPC$TL_messages_dialogs, 2);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$q3t2-IierjFMkjv6TazoZbEPutE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkPromoInfoInternal$131$MessagesController(tLRPC$TL_help_promoData, tLRPC$TL_messages_peerDialogs, j);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ZD6rx_PRm6ZLPDVLQnV_7EFovy4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkPromoInfoInternal$132$MessagesController();
                }
            });
        }
        this.checkingPromoInfo = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkPromoInfoInternal$131, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPromoInfoInternal$131$MessagesController(TLRPC$TL_help_promoData tLRPC$TL_help_promoData, TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs, long j) {
        putUsers(tLRPC$TL_help_promoData.users, false);
        putChats(tLRPC$TL_help_promoData.chats, false);
        putUsers(tLRPC$TL_messages_peerDialogs.users, false);
        putChats(tLRPC$TL_messages_peerDialogs.chats, false);
        TLRPC$Dialog tLRPC$Dialog = this.promoDialog;
        if (tLRPC$Dialog != null) {
            long j2 = tLRPC$Dialog.id;
            if (j2 < 0) {
                TLRPC$Chat chat = getChat(Long.valueOf(-j2));
                if (ChatObject.isNotInChat(chat) || chat.restricted) {
                    removeDialog(this.promoDialog);
                }
            } else {
                removeDialog(tLRPC$Dialog);
            }
        }
        TLRPC$Dialog tLRPC$Dialog2 = tLRPC$TL_messages_peerDialogs.dialogs.get(0);
        this.promoDialog = tLRPC$Dialog2;
        tLRPC$Dialog2.id = j;
        tLRPC$Dialog2.folder_id = 0;
        if (DialogObject.isChannel(tLRPC$Dialog2)) {
            LongSparseIntArray longSparseIntArray = this.channelsPts;
            TLRPC$Dialog tLRPC$Dialog3 = this.promoDialog;
            longSparseIntArray.put(-tLRPC$Dialog3.id, tLRPC$Dialog3.pts);
        }
        Integer num = (Integer) this.dialogs_read_inbox_max.get(Long.valueOf(this.promoDialog.id));
        if (num == null) {
            num = num;
        }
        this.dialogs_read_inbox_max.put(Long.valueOf(this.promoDialog.id), Integer.valueOf(Math.max(num.intValue(), this.promoDialog.read_inbox_max_id)));
        Integer num2 = (Integer) this.dialogs_read_outbox_max.get(Long.valueOf(this.promoDialog.id));
        this.dialogs_read_outbox_max.put(Long.valueOf(this.promoDialog.id), Integer.valueOf(Math.max((num2 != null ? num2 : 0).intValue(), this.promoDialog.read_outbox_max_id)));
        this.dialogs_dict.put(j, this.promoDialog);
        if (!tLRPC$TL_messages_peerDialogs.messages.isEmpty()) {
            LongSparseArray longSparseArray = new LongSparseArray();
            LongSparseArray longSparseArray2 = new LongSparseArray();
            for (int i = 0; i < tLRPC$TL_messages_peerDialogs.users.size(); i++) {
                TLRPC$User tLRPC$User = tLRPC$TL_messages_peerDialogs.users.get(i);
                longSparseArray.put(tLRPC$User.id, tLRPC$User);
            }
            for (int i2 = 0; i2 < tLRPC$TL_messages_peerDialogs.chats.size(); i2++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$TL_messages_peerDialogs.chats.get(i2);
                longSparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
            }
            MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$TL_messages_peerDialogs.messages.get(0), (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, false, true);
            this.dialogMessage.put(j, messageObject);
            TLRPC$Dialog tLRPC$Dialog4 = this.promoDialog;
            if (tLRPC$Dialog4.last_message_date == 0) {
                tLRPC$Dialog4.last_message_date = messageObject.messageOwner.date;
            }
        }
        sortDialogs(null);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkPromoInfoInternal$132, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPromoInfoInternal$132$MessagesController() {
        TLRPC$Dialog tLRPC$Dialog = this.promoDialog;
        if (tLRPC$Dialog != null) {
            long j = tLRPC$Dialog.id;
            if (j < 0) {
                TLRPC$Chat chat = getChat(Long.valueOf(-j));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePromoDialog() {
        TLRPC$Dialog tLRPC$Dialog = this.promoDialog;
        if (tLRPC$Dialog == null) {
            return;
        }
        long j = tLRPC$Dialog.id;
        if (j < 0) {
            TLRPC$Chat chat = getChat(Long.valueOf(-j));
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

    public boolean isPromoDialog(long did, boolean checkLeft) {
        TLRPC$Dialog tLRPC$Dialog = this.promoDialog;
        return tLRPC$Dialog != null && tLRPC$Dialog.id == did && (!checkLeft || this.isLeftPromoChannel);
    }

    private void checkReportReasons() {
        int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
        if (currentTime < this.lastReportReasonCheckTime + 86400) {
            return;
        }
        this.lastReportReasonCheckTime = currentTime;
        TLRPC$TL_report_getReasons tLRPC$TL_report_getReasons = new TLRPC$TL_report_getReasons();
        if (LocaleController.getInstance().getCurrentLocaleInfo() != null) {
            tLRPC$TL_report_getReasons.lang = LocaleController.getInstance().getCurrentLocaleInfo().shortName;
        } else {
            tLRPC$TL_report_getReasons.lang = "fa";
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_report_getReasons, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$F8Ss93LsYUNz1CvVEoKBd741gtg
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkReportReasons$137$MessagesController(tLObject, tLRPC$TL_error);
            }
        }, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkReportReasons$137, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkReportReasons$137$MessagesController(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$V8y3r_VBhcxN6RrnpN8J9qnZqx8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkReportReasons$136$MessagesController(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkReportReasons$136, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkReportReasons$136$MessagesController(TLObject tLObject) {
        this.reportReasons.clear();
        Iterator<Object> it = ((TLRPC$Vector) tLObject).objects.iterator();
        while (it.hasNext()) {
            this.reportReasons.add((TLRPC$TL_report_reason) it.next());
        }
    }

    private String getUserNameForTyping(TLRPC$User user) {
        if (user == null) {
            return "";
        }
        String str = user.first_name;
        if (str != null && str.length() > 0) {
            return user.first_name;
        }
        String str2 = user.last_name;
        return (str2 == null || str2.length() <= 0) ? "" : user.last_name;
    }

    private void cleanTempCache() {
        if (this.lastTempCacheCheckTime + 3600 > ConnectionsManager.getInstance(this.currentAccount).getCurrentTime()) {
            return;
        }
        this.lastTempCacheCheckTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
        this.mainPreferences.edit().putInt("lastTempCacheCheckTime", this.lastTempCacheCheckTime).commit();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.MessagesController.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Utilities.clearDir(ImageLoader.getInstance().createMediaPaths().get(57).getAbsolutePath(), 0, (System.currentTimeMillis() / 1000) - 3600, false);
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        });
    }

    private void updatePrintingStrings() {
        String str;
        int i;
        int i2;
        final LongSparseArray longSparseArray = new LongSparseArray();
        final LongSparseArray longSparseArray2 = new LongSparseArray();
        for (Map.Entry entry : this.printingUsers.entrySet()) {
            Long l = (Long) entry.getKey();
            boolean zIsEncryptedDialog = DialogObject.isEncryptedDialog(l.longValue());
            for (Map.Entry entry2 : ((ConcurrentHashMap) entry.getValue()).entrySet()) {
                Integer num = (Integer) entry2.getKey();
                ArrayList arrayList = (ArrayList) entry2.getValue();
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                longSparseArray.put(l.longValue(), sparseArray);
                longSparseArray2.put(l.longValue(), sparseArray2);
                String str2 = "IsTypingGroup";
                if (l.longValue() > 0 || zIsEncryptedDialog || arrayList.size() == 1) {
                    PrintingUser printingUser = (PrintingUser) arrayList.get(0);
                    TLRPC$User user = getUser(Long.valueOf(printingUser.userId));
                    if (user != null) {
                        TLRPC$SendMessageAction tLRPC$SendMessageAction = printingUser.action;
                        if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageRecordAudioAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsRecordingAudio", R.string.IsRecordingAudio, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("RecordingAudio", R.string.RecordingAudio));
                            }
                            sparseArray2.put(num.intValue(), 1);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageRecordRoundAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsRecordingRound", R.string.IsRecordingRound, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("RecordingRound", R.string.RecordingRound));
                            }
                            sparseArray2.put(num.intValue(), 4);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadRoundAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsSendingVideo", R.string.IsSendingVideo, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("SendingVideoStatus", R.string.SendingVideoStatus));
                            }
                            sparseArray2.put(num.intValue(), 4);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadAudioAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsSendingAudio", R.string.IsSendingAudio, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("SendingAudio", R.string.SendingAudio));
                            }
                            sparseArray2.put(num.intValue(), 2);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadVideoAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsSendingVideo", R.string.IsSendingVideo, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("SendingVideoStatus", R.string.SendingVideoStatus));
                            }
                            sparseArray2.put(num.intValue(), 2);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageRecordVideoAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsRecordingVideo", R.string.IsRecordingVideo, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("RecordingVideoStatus", R.string.RecordingVideoStatus));
                            }
                            sparseArray2.put(num.intValue(), 2);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadDocumentAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsSendingFile", R.string.IsSendingFile, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("SendingFile", R.string.SendingFile));
                            }
                            sparseArray2.put(num.intValue(), 2);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadPhotoAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsSendingPhoto", R.string.IsSendingPhoto, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("SendingPhoto", R.string.SendingPhoto));
                            }
                            sparseArray2.put(num.intValue(), 2);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageGamePlayAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsSendingGame", R.string.IsSendingGame, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("SendingGame", R.string.SendingGame));
                            }
                            sparseArray2.put(num.intValue(), 3);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageGeoLocationAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsSelectingLocation", R.string.IsSelectingLocation, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("SelectingLocation", R.string.SelectingLocation));
                            }
                            sparseArray2.put(num.intValue(), 0);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageChooseContactAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsSelectingContact", R.string.IsSelectingContact, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("SelectingContact", R.string.SelectingContact));
                            }
                            sparseArray2.put(num.intValue(), 0);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageEmojiInteractionSeen) {
                            String str3 = ((TLRPC$TL_sendMessageEmojiInteractionSeen) tLRPC$SendMessageAction).emoticon;
                            sparseArray.put(num.intValue(), (l.longValue() >= 0 || zIsEncryptedDialog) ? LocaleController.formatString("EnjoyngAnimations", R.string.EnjoyngAnimations, str3) : LocaleController.formatString("IsEnjoyngAnimations", R.string.IsEnjoyngAnimations, getUserNameForTyping(user), str3));
                            sparseArray2.put(num.intValue(), 5);
                        } else if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageChooseStickerAction) {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsChoosingSticker", R.string.IsChoosingSticker, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("ChoosingSticker", R.string.ChoosingSticker));
                            }
                            sparseArray2.put(num.intValue(), 5);
                        } else {
                            if (l.longValue() < 0 && !zIsEncryptedDialog) {
                                sparseArray.put(num.intValue(), LocaleController.formatString("IsTypingGroup", R.string.IsTypingGroup, getUserNameForTyping(user)));
                            } else {
                                sparseArray.put(num.intValue(), LocaleController.getString("Typing", R.string.Typing));
                            }
                            sparseArray2.put(num.intValue(), 0);
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    Iterator it = arrayList.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            str = str2;
                            i = i3;
                            break;
                        }
                        str = str2;
                        TLRPC$User user2 = getUser(Long.valueOf(((PrintingUser) it.next()).userId));
                        if (user2 != null) {
                            if (sb.length() != 0) {
                                sb.append(", ");
                            }
                            sb.append(getUserNameForTyping(user2));
                            i3++;
                        }
                        i = i3;
                        if (i == 2) {
                            break;
                        }
                        i3 = i;
                        str2 = str;
                    }
                    if (sb.length() != 0) {
                        if (i == 1) {
                            sparseArray.put(num.intValue(), LocaleController.formatString(str, R.string.IsTypingGroup, sb.toString()));
                        } else if (arrayList.size() > 2) {
                            try {
                                sparseArray.put(num.intValue(), String.format(LocaleController.getPluralString("AndMoreTypingGroup", arrayList.size() - 2), sb.toString(), Integer.valueOf(arrayList.size() - 2)));
                            } catch (Exception unused) {
                                sparseArray.put(num.intValue(), "LOC_ERR: AndMoreTypingGroup");
                            }
                        } else {
                            i2 = 0;
                            sparseArray.put(num.intValue(), LocaleController.formatString("AreTypingGroup", R.string.AreTypingGroup, sb.toString()));
                            sparseArray2.put(num.intValue(), Integer.valueOf(i2));
                        }
                        i2 = 0;
                        sparseArray2.put(num.intValue(), Integer.valueOf(i2));
                    }
                }
            }
        }
        this.lastPrintingStringCount = longSparseArray.size();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$o7UwKQZgPChPGiBfKpEG0ec_kWg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updatePrintingStrings$138$MessagesController(longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updatePrintingStrings$138, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updatePrintingStrings$138$MessagesController(LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        this.printingStrings = longSparseArray;
        this.printingStringsTypes = longSparseArray2;
    }

    /* renamed from: cancelTyping, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$sendTyping$141$MessagesController(int action, long dialogId, int threadMsgId) {
        LongSparseArray<SparseArray<Boolean>> longSparseArray;
        SparseArray<Boolean> sparseArray;
        if (action >= 0) {
            LongSparseArray<SparseArray<Boolean>>[] longSparseArrayArr = this.sendingTypings;
            if (action >= longSparseArrayArr.length || longSparseArrayArr[action] == null || (sparseArray = (longSparseArray = longSparseArrayArr[action]).get(dialogId)) == null) {
                return;
            }
            sparseArray.remove(threadMsgId);
            if (sparseArray.size() == 0) {
                longSparseArray.remove(dialogId);
            }
        }
    }

    public boolean sendTyping(long dialogId, int threadMsgId, int action, int classGuid) {
        return sendTyping(dialogId, threadMsgId, action, null, classGuid);
    }

    public boolean sendTyping(final long dialogId, final int threadMsgId, final int action, String emojicon, int classGuid) {
        TLRPC$Chat chat;
        if (action < 0 || action >= this.sendingTypings.length || dialogId == 0) {
            return false;
        }
        if (dialogId < 0) {
            if (ChatObject.shouldSendAnonymously(getChat(Long.valueOf(-dialogId)))) {
                return false;
            }
        } else {
            TLRPC$User user = getUser(Long.valueOf(dialogId));
            if (user != null) {
                if (user.id == getUserConfig().getClientUserId()) {
                    return false;
                }
                TLRPC$UserStatus tLRPC$UserStatus = user.status;
                if (tLRPC$UserStatus != null && tLRPC$UserStatus.expires != -100 && !this.onlinePrivacy.containsKey(Long.valueOf(user.id))) {
                    if (user.status.expires <= getConnectionsManager().getCurrentTime() - 30) {
                        return false;
                    }
                }
            }
        }
        LongSparseArray<SparseArray<Boolean>>[] longSparseArrayArr = this.sendingTypings;
        LongSparseArray<SparseArray<Boolean>> longSparseArray = longSparseArrayArr[action];
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray<>();
            longSparseArrayArr[action] = longSparseArray;
        }
        SparseArray<Boolean> sparseArray = longSparseArray.get(dialogId);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            longSparseArray.put(dialogId, sparseArray);
        }
        if (sparseArray.get(threadMsgId) != null) {
            return false;
        }
        if (!DialogObject.isEncryptedDialog(dialogId)) {
            TLRPC$TL_messages_setTyping tLRPC$TL_messages_setTyping = new TLRPC$TL_messages_setTyping();
            if (threadMsgId != 0) {
                tLRPC$TL_messages_setTyping.top_msg_id = threadMsgId;
                tLRPC$TL_messages_setTyping.flags |= 1;
            }
            TLRPC$InputPeer inputPeer = getInputPeer(dialogId);
            tLRPC$TL_messages_setTyping.peer = inputPeer;
            if (((inputPeer instanceof TLRPC$TL_inputPeerChannel) && ((chat = getChat(Long.valueOf(inputPeer.channel_id))) == null || !chat.megagroup)) || tLRPC$TL_messages_setTyping.peer == null) {
                return false;
            }
            if (action == 0) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageTypingAction();
            } else if (action == 1) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageRecordAudioAction();
            } else if (action == 2) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageCancelAction();
            } else if (action == 3) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadDocumentAction();
            } else if (action == 4) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadPhotoAction();
            } else if (action == 5) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadVideoAction();
            } else if (action == 6) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageGamePlayAction();
            } else if (action == 7) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageRecordRoundAction();
            } else if (action == 8) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadRoundAction();
            } else if (action == 9) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageUploadAudioAction();
            } else if (action == 10) {
                tLRPC$TL_messages_setTyping.action = new TLRPC$TL_sendMessageChooseStickerAction();
            } else if (action == 11) {
                TLRPC$TL_sendMessageEmojiInteractionSeen tLRPC$TL_sendMessageEmojiInteractionSeen = new TLRPC$TL_sendMessageEmojiInteractionSeen();
                tLRPC$TL_sendMessageEmojiInteractionSeen.emoticon = emojicon;
                tLRPC$TL_messages_setTyping.action = tLRPC$TL_sendMessageEmojiInteractionSeen;
            }
            sparseArray.put(threadMsgId, Boolean.TRUE);
            int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_setTyping, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$QwhwNcN8aZpJ3Zw_nqxTKX6KBMs
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$sendTyping$140$MessagesController(action, dialogId, threadMsgId, tLObject, tLRPC$TL_error);
                }
            }, 2);
            if (classGuid != 0) {
                getConnectionsManager().bindRequestToGuid(iSendRequest, classGuid);
            }
        } else {
            if (action != 0) {
                return false;
            }
            TLRPC$EncryptedChat encryptedChat = getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(dialogId)));
            byte[] bArr = encryptedChat.auth_key;
            if (bArr != null && bArr.length > 1 && (encryptedChat instanceof TLRPC$TL_encryptedChat)) {
                TLRPC$TL_messages_setEncryptedTyping tLRPC$TL_messages_setEncryptedTyping = new TLRPC$TL_messages_setEncryptedTyping();
                TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat = new TLRPC$TL_inputEncryptedChat();
                tLRPC$TL_messages_setEncryptedTyping.peer = tLRPC$TL_inputEncryptedChat;
                tLRPC$TL_inputEncryptedChat.chat_id = encryptedChat.id;
                tLRPC$TL_inputEncryptedChat.access_hash = encryptedChat.access_hash;
                tLRPC$TL_messages_setEncryptedTyping.typing = true;
                sparseArray.put(threadMsgId, Boolean.TRUE);
                int iSendRequest2 = getConnectionsManager().sendRequest(tLRPC$TL_messages_setEncryptedTyping, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$skKLigbEfybf8KcWPKJaPqITz0w
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$sendTyping$142$MessagesController(action, dialogId, threadMsgId, tLObject, tLRPC$TL_error);
                    }
                }, 2);
                if (classGuid != 0) {
                    getConnectionsManager().bindRequestToGuid(iSendRequest2, classGuid);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendTyping$140, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendTyping$140$MessagesController(final int i, final long j, final int i2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$yvXXDmGUjqLLFOJkRcL4LxUujDM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendTyping$139$MessagesController(i, j, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendTyping$142, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendTyping$142$MessagesController(final int i, final long j, final int i2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$f_4bgEOi8DKDouDUlCtMDECh1JI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendTyping$141$MessagesController(i, j, i2);
            }
        });
    }

    protected void removeDeletedMessagesFromArray(final long dialogId, ArrayList<TLRPC$Message> messages) {
        int i = 0;
        int i2 = this.deletedHistory.get(dialogId, 0);
        if (i2 == 0) {
            return;
        }
        int size = messages.size();
        while (i < size) {
            if (messages.get(i).id <= i2) {
                messages.remove(i);
                i--;
                size--;
            }
            i++;
        }
    }

    public void loadMessages(long dialogId, long mergeDialogId, boolean loadInfo, int count, int max_id, int offset_date, boolean fromCache, int midDate, int classGuid, int load_type, int last_message_id, int mode, int threadMessageId, int replyFirstUnread, int loadIndex) {
        loadMessages(dialogId, mergeDialogId, loadInfo, count, max_id, offset_date, fromCache, midDate, classGuid, load_type, last_message_id, mode, threadMessageId, loadIndex, threadMessageId != 0 ? replyFirstUnread : 0, 0, 0, false, 0);
    }

    public void loadMessages(long dialogId, long mergeDialogId, boolean loadInfo, int count, int max_id, int offset_date, boolean fromCache, int midDate, int classGuid, int load_type, int last_message_id, int mode, int threadMessageId, int loadIndex, int first_unread, int unread_count, int last_date, boolean queryFromServer, int mentionsCount) {
        loadMessagesInternal(dialogId, mergeDialogId, loadInfo, count, max_id, offset_date, fromCache, midDate, classGuid, load_type, last_message_id, mode, threadMessageId, loadIndex, first_unread, unread_count, last_date, queryFromServer, mentionsCount, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMessagesInternal(final long dialogId, final long mergeDialogId, final boolean loadInfo, final int count, final int max_id, final int offset_date, boolean fromCache, final int minDate, final int classGuid, final int load_type, final int last_message_id, final int mode, final int threadMessageId, final int loadIndex, final int first_unread, final int unread_count, final int last_date, final boolean queryFromServer, final int mentionsCount, boolean loadDialog, final boolean processMessages) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("load messages in chat " + dialogId + " count " + count + " max_id " + max_id + " cache " + fromCache + " mindate = " + minDate + " guid " + classGuid + " load_type " + load_type + " last_message_id " + last_message_id + " mode " + mode + " index " + loadIndex + " firstUnread " + first_unread + " unread_count " + unread_count + " last_date " + last_date + " queryFromServer " + queryFromServer);
        }
        if (threadMessageId == 0 && mode != 2 && (fromCache || DialogObject.isEncryptedDialog(dialogId))) {
            getMessagesStorage().getMessages(dialogId, mergeDialogId, loadInfo, count, max_id, offset_date, minDate, classGuid, load_type, mode == 1, threadMessageId, loadIndex, processMessages);
            return;
        }
        if (threadMessageId != 0) {
            if (mode != 0) {
                return;
            }
            final TLRPC$TL_messages_getReplies tLRPC$TL_messages_getReplies = new TLRPC$TL_messages_getReplies();
            tLRPC$TL_messages_getReplies.peer = getInputPeer(dialogId);
            tLRPC$TL_messages_getReplies.msg_id = threadMessageId;
            tLRPC$TL_messages_getReplies.offset_date = offset_date;
            if (load_type == 4) {
                tLRPC$TL_messages_getReplies.add_offset = (-count) + 5;
            } else if (load_type == 3) {
                tLRPC$TL_messages_getReplies.add_offset = (-count) / 2;
            } else if (load_type == 1) {
                tLRPC$TL_messages_getReplies.add_offset = (-count) - 1;
            } else if (load_type == 2 && max_id != 0) {
                tLRPC$TL_messages_getReplies.add_offset = (-count) + 10;
            } else if (dialogId < 0 && max_id != 0 && ChatObject.isChannel(getChat(Long.valueOf(-dialogId)))) {
                tLRPC$TL_messages_getReplies.add_offset = -1;
                tLRPC$TL_messages_getReplies.limit++;
            }
            tLRPC$TL_messages_getReplies.limit = count;
            tLRPC$TL_messages_getReplies.offset_id = max_id;
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getReplies, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Tu46v40FVkJVvGUbtyiBjoXhF8w
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMessagesInternal$144$MessagesController(count, max_id, offset_date, first_unread, load_type, dialogId, mergeDialogId, classGuid, last_message_id, unread_count, last_date, threadMessageId, loadIndex, queryFromServer, mentionsCount, processMessages, tLRPC$TL_messages_getReplies, tLObject, tLRPC$TL_error);
                }
            }), classGuid);
            return;
        }
        if (mode == 2) {
            return;
        }
        if (mode == 1) {
            TLRPC$TL_messages_getScheduledHistory tLRPC$TL_messages_getScheduledHistory = new TLRPC$TL_messages_getScheduledHistory();
            tLRPC$TL_messages_getScheduledHistory.peer = getInputPeer(dialogId);
            tLRPC$TL_messages_getScheduledHistory.hash = minDate;
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getScheduledHistory, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$AgYqMUVyopjKuuBaLdq9nkgVbfE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMessagesInternal$145$MessagesController(max_id, offset_date, dialogId, mergeDialogId, count, classGuid, first_unread, last_message_id, unread_count, last_date, load_type, mode, threadMessageId, loadIndex, queryFromServer, mentionsCount, processMessages, tLObject, tLRPC$TL_error);
                }
            }), classGuid);
            return;
        }
        if (loadDialog && ((load_type == 3 || load_type == 2) && last_message_id == 0)) {
            final TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs = new TLRPC$TL_messages_getPeerDialogs();
            TLRPC$InputPeer inputPeer = getInputPeer(dialogId);
            new TLRPC$TL_inputDialogPeer().peer = inputPeer;
            tLRPC$TL_messages_getPeerDialogs.peers.add(inputPeer);
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ZA-rgnvtP1sFxociJ1Rt7Po6AgA
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMessagesInternal$147$MessagesController(dialogId, mergeDialogId, loadInfo, count, max_id, offset_date, minDate, classGuid, load_type, threadMessageId, loadIndex, first_unread, last_date, queryFromServer, processMessages, tLRPC$TL_messages_getPeerDialogs, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        final TLRPC$TL_messages_getHistory tLRPC$TL_messages_getHistory = new TLRPC$TL_messages_getHistory();
        tLRPC$TL_messages_getHistory.peer = getInputPeer(dialogId);
        if (load_type == 4) {
            tLRPC$TL_messages_getHistory.add_offset = (-count) + 5;
        } else if (load_type == 3) {
            tLRPC$TL_messages_getHistory.add_offset = (-count) / 2;
        } else if (load_type == 1) {
            tLRPC$TL_messages_getHistory.add_offset = (-count) - 1;
        } else if (load_type == 2 && max_id != 0) {
            tLRPC$TL_messages_getHistory.add_offset = (-count) + 6;
        } else {
            if (dialogId < 0 && max_id != 0) {
                if (ChatObject.isChannel(getChat(Long.valueOf(-dialogId)))) {
                    tLRPC$TL_messages_getHistory.add_offset = -1;
                    tLRPC$TL_messages_getHistory.limit++;
                }
            }
            tLRPC$TL_messages_getHistory.limit = count;
            tLRPC$TL_messages_getHistory.offset_id = max_id;
            tLRPC$TL_messages_getHistory.offset_date = offset_date;
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getHistory, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xMJTfcin8-ss_mMI3TlWHLsbe08
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMessagesInternal$149$MessagesController(dialogId, count, max_id, offset_date, mergeDialogId, classGuid, first_unread, last_message_id, unread_count, last_date, load_type, threadMessageId, loadIndex, queryFromServer, mentionsCount, processMessages, tLRPC$TL_messages_getHistory, tLObject, tLRPC$TL_error);
                }
            }), classGuid);
        }
        tLRPC$TL_messages_getHistory.limit = count;
        tLRPC$TL_messages_getHistory.offset_id = max_id;
        tLRPC$TL_messages_getHistory.offset_date = offset_date;
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getHistory, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xMJTfcin8-ss_mMI3TlWHLsbe08
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadMessagesInternal$149$MessagesController(dialogId, count, max_id, offset_date, mergeDialogId, classGuid, first_unread, last_message_id, unread_count, last_date, load_type, threadMessageId, loadIndex, queryFromServer, mentionsCount, processMessages, tLRPC$TL_messages_getHistory, tLObject, tLRPC$TL_error);
            }
        }), classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    /* renamed from: lambda$loadMessagesInternal$144, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadMessagesInternal$144$MessagesController(int r25, int r26, int r27, int r28, int r29, long r30, long r32, final int r34, int r35, int r36, int r37, int r38, int r39, boolean r40, int r41, boolean r42, final ir.eitaa.tgnet.TLRPC$TL_messages_getReplies r43, ir.eitaa.tgnet.TLObject r44, final ir.eitaa.tgnet.TLRPC$TL_error r45) {
        /*
            r24 = this;
            r9 = r27
            r0 = r28
            if (r44 == 0) goto Lb2
            r1 = r44
            ir.eitaa.tgnet.TLRPC$messages_Messages r1 = (ir.eitaa.tgnet.TLRPC$messages_Messages) r1
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r1.messages
            int r2 = r2.size()
            r3 = 0
            r7 = r25
            if (r2 <= r7) goto L1a
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r1.messages
            r2.remove(r3)
        L1a:
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r1.messages
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L7e
            if (r9 == 0) goto L54
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r0 = r1.messages
            int r2 = r0.size()
            int r2 = r2 + (-1)
            java.lang.Object r0 = r0.get(r2)
            ir.eitaa.tgnet.TLRPC$Message r0 = (ir.eitaa.tgnet.TLRPC$Message) r0
            int r0 = r0.id
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r1.messages
            int r2 = r2.size()
            int r2 = r2 + (-1)
        L3c:
            if (r2 < 0) goto L50
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r4 = r1.messages
            java.lang.Object r4 = r4.get(r2)
            ir.eitaa.tgnet.TLRPC$Message r4 = (ir.eitaa.tgnet.TLRPC$Message) r4
            int r5 = r4.date
            if (r5 <= r9) goto L4d
            int r0 = r4.id
            goto L50
        L4d:
            int r2 = r2 + (-1)
            goto L3c
        L50:
            r15 = r29
            r8 = r0
            goto L82
        L54:
            if (r0 == 0) goto L7e
            r2 = 2
            r15 = r29
            if (r15 != r2) goto L80
            if (r26 <= 0) goto L80
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r1.messages
            int r2 = r2.size()
            int r2 = r2 + (-1)
        L65:
            if (r2 < 0) goto L80
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r4 = r1.messages
            java.lang.Object r4 = r4.get(r2)
            ir.eitaa.tgnet.TLRPC$Message r4 = (ir.eitaa.tgnet.TLRPC$Message) r4
            int r5 = r4.id
            if (r5 <= r0) goto L7b
            boolean r4 = r4.out
            if (r4 != 0) goto L7b
            r8 = r26
            r12 = r5
            goto L83
        L7b:
            int r2 = r2 + (-1)
            goto L65
        L7e:
            r15 = r29
        L80:
            r8 = r26
        L82:
            r12 = 0
        L83:
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r0 = r1.messages
            int r2 = r0.size()
            r10 = 0
            r17 = 0
            r18 = 0
            r0 = r24
            r3 = r30
            r5 = r32
            r7 = r25
            r9 = r27
            r11 = r34
            r13 = r35
            r14 = r36
            r15 = r37
            r16 = r29
            r19 = r38
            r20 = r39
            r21 = r40
            r22 = r41
            r23 = r42
            r0.processLoadedMessages(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r1 = r24
            goto Lc2
        Lb2:
            ir.eitaa.messenger.-$$Lambda$MessagesController$i2KNPj6tbEo1bMV7z9m52udJKIk r0 = new ir.eitaa.messenger.-$$Lambda$MessagesController$i2KNPj6tbEo1bMV7z9m52udJKIk
            r1 = r24
            r2 = r34
            r3 = r43
            r4 = r45
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$loadMessagesInternal$144$MessagesController(int, int, int, int, int, long, long, int, int, int, int, int, int, boolean, int, boolean, ir.eitaa.tgnet.TLRPC$TL_messages_getReplies, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessagesInternal$143, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessagesInternal$143$MessagesController(int i, TLRPC$TL_messages_getReplies tLRPC$TL_messages_getReplies, TLRPC$TL_error tLRPC$TL_error) {
        getNotificationCenter().postNotificationName(NotificationCenter.loadingMessagesFailed, Integer.valueOf(i), tLRPC$TL_messages_getReplies, tLRPC$TL_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessagesInternal$145, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessagesInternal$145$MessagesController(int i, int i2, long j, long j2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z, int i13, boolean z2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        int i14;
        if (tLObject != null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            if (tLRPC$messages_Messages instanceof TLRPC$TL_messages_messagesNotModified) {
                return;
            }
            if (i2 == 0 || tLRPC$messages_Messages.messages.isEmpty()) {
                i14 = i;
            } else {
                int i15 = tLRPC$messages_Messages.messages.get(r0.size() - 1).id;
                int size = tLRPC$messages_Messages.messages.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(size);
                    if (tLRPC$Message.date > i2) {
                        i15 = tLRPC$Message.id;
                        break;
                    }
                    size--;
                }
                i14 = i15;
            }
            processLoadedMessages(tLRPC$messages_Messages, tLRPC$messages_Messages.messages.size(), j, j2, i3, i14, i2, false, i4, i5, i6, i7, i8, i9, false, i10, i11, i12, z, i13, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessagesInternal$147, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessagesInternal$147$MessagesController(long j, long j2, boolean z, int i, int i2, int i3, int i4, final int i5, int i6, int i7, int i8, int i9, int i10, boolean z2, boolean z3, final TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = (TLRPC$TL_messages_peerDialogs) tLObject;
            if (!tLRPC$TL_messages_peerDialogs.dialogs.isEmpty()) {
                TLRPC$Dialog tLRPC$Dialog = tLRPC$TL_messages_peerDialogs.dialogs.get(0);
                if (tLRPC$Dialog.top_message != 0) {
                    TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
                    tLRPC$TL_messages_dialogs.chats = tLRPC$TL_messages_peerDialogs.chats;
                    tLRPC$TL_messages_dialogs.users = tLRPC$TL_messages_peerDialogs.users;
                    tLRPC$TL_messages_dialogs.dialogs = tLRPC$TL_messages_peerDialogs.dialogs;
                    tLRPC$TL_messages_dialogs.messages = tLRPC$TL_messages_peerDialogs.messages;
                    getMessagesStorage().putDialogs(tLRPC$TL_messages_dialogs, 2);
                }
                loadMessagesInternal(j, j2, z, i, i2, i3, false, i4, i5, i6, tLRPC$Dialog.top_message, 0, i7, i8, i9, tLRPC$Dialog.unread_count, i10, z2, tLRPC$Dialog.unread_mentions_count, false, z3);
            }
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$1zEio_Z7p8ufGjBi8q0vxxAos6A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMessagesInternal$146$MessagesController(i5, tLRPC$TL_messages_getPeerDialogs, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessagesInternal$146, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessagesInternal$146$MessagesController(int i, TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs, TLRPC$TL_error tLRPC$TL_error) {
        getNotificationCenter().postNotificationName(NotificationCenter.loadingMessagesFailed, Integer.valueOf(i), tLRPC$TL_messages_getPeerDialogs, tLRPC$TL_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessagesInternal$149, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessagesInternal$149$MessagesController(long j, int i, int i2, int i3, long j2, final int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, int i12, boolean z2, final TLRPC$TL_messages_getHistory tLRPC$TL_messages_getHistory, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        int i13;
        if (tLObject != null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            removeDeletedMessagesFromArray(j, tLRPC$messages_Messages.messages);
            if (tLRPC$messages_Messages.messages.size() > i) {
                tLRPC$messages_Messages.messages.remove(0);
            }
            if (i3 == 0 || tLRPC$messages_Messages.messages.isEmpty()) {
                i13 = i2;
            } else {
                int i14 = tLRPC$messages_Messages.messages.get(r0.size() - 1).id;
                int size = tLRPC$messages_Messages.messages.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(size);
                    if (tLRPC$Message.date > i3) {
                        i14 = tLRPC$Message.id;
                        break;
                    }
                    size--;
                }
                i13 = i14;
            }
            processLoadedMessages(tLRPC$messages_Messages, tLRPC$messages_Messages.messages.size(), j, j2, i, i13, i3, false, i4, i5, i6, i7, i8, i9, false, 0, i10, i11, z, i12, z2);
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$k-X25K0iGzqPJ_BBtCJs1Pg5yO0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMessagesInternal$148$MessagesController(i4, tLRPC$TL_messages_getHistory, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessagesInternal$148, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessagesInternal$148$MessagesController(int i, TLRPC$TL_messages_getHistory tLRPC$TL_messages_getHistory, TLRPC$TL_error tLRPC$TL_error) {
        getNotificationCenter().postNotificationName(NotificationCenter.loadingMessagesFailed, Integer.valueOf(i), tLRPC$TL_messages_getHistory, tLRPC$TL_error);
    }

    public void reloadWebPages(final long dialogId, HashMap<String, ArrayList<MessageObject>> webpagesToReload, final boolean scheduled) {
        final HashMap<String, ArrayList<MessageObject>> map = scheduled ? this.reloadingScheduledWebpages : this.reloadingWebpages;
        final LongSparseArray<ArrayList<MessageObject>> longSparseArray = scheduled ? this.reloadingScheduledWebpagesPending : this.reloadingWebpagesPending;
        for (Map.Entry<String, ArrayList<MessageObject>> entry : webpagesToReload.entrySet()) {
            final String key = entry.getKey();
            ArrayList<MessageObject> value = entry.getValue();
            ArrayList<MessageObject> arrayList = map.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(key, arrayList);
            }
            arrayList.addAll(value);
            TLRPC$TL_messages_getWebPagePreview tLRPC$TL_messages_getWebPagePreview = new TLRPC$TL_messages_getWebPagePreview();
            tLRPC$TL_messages_getWebPagePreview.message = key;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getWebPagePreview, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$iouC8EclwfoHxKWe4MX1WhFH0tI
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$reloadWebPages$151$MessagesController(map, key, longSparseArray, dialogId, scheduled, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadWebPages$151, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadWebPages$151$MessagesController(final HashMap map, final String str, final LongSparseArray longSparseArray, final long j, final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$zJbi3c5rIcn_4qOUHl11lfF51ro
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reloadWebPages$150$MessagesController(map, str, tLObject, longSparseArray, j, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadWebPages$150, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadWebPages$150$MessagesController(HashMap map, String str, TLObject tLObject, LongSparseArray longSparseArray, long j, boolean z) {
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
        getMessagesStorage().putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, j, -2, 0, false, z);
        getNotificationCenter().postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(j), arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x041b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processLoadedMessages(final ir.eitaa.tgnet.TLRPC$messages_Messages r31, final int r32, final long r33, final long r35, final int r37, final int r38, final int r39, final boolean r40, final int r41, final int r42, final int r43, final int r44, final int r45, final int r46, final boolean r47, final int r48, final int r49, final int r50, final boolean r51, final int r52, final boolean r53) {
        /*
            Method dump skipped, instructions count: 1173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.processLoadedMessages(ir.eitaa.tgnet.TLRPC$messages_Messages, int, long, long, int, int, int, boolean, int, int, int, int, int, int, boolean, int, int, int, boolean, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedMessages$152, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedMessages$152$MessagesController(long j, long j2, int i, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, boolean z2) {
        loadMessagesInternal(j, j2, false, i, (i2 == 2 && z) ? i3 : i4, i5, false, i6, i7, i2, i8, i9, i10, i11, i3, i12, i13, z, i14, true, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedMessages$153, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedMessages$153$MessagesController(int i, TLRPC$messages_Messages tLRPC$messages_Messages, boolean z, boolean z2, int i2) {
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDidLoadWithoutProcess, Integer.valueOf(i), Integer.valueOf(tLRPC$messages_Messages.messages.size()), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$processLoadedMessages$155, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedMessages$155$MessagesController(TLRPC$messages_Messages tLRPC$messages_Messages, final boolean z, final int i, boolean z2, final int i2, int i3, final int i4, final long j, final ArrayList arrayList, final boolean z3, final int i5, final int i6, final boolean z4, final int i7, final int i8, final int i9, final int i10, final int i11, final int i12, ArrayList arrayList2, HashMap map) {
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z5;
        MessagesController messagesController;
        boolean z6;
        long j2;
        HashMap map2;
        putUsers(tLRPC$messages_Messages.users, z);
        putChats(tLRPC$messages_Messages.chats, z);
        if (i == 1) {
            i15 = 0;
        } else {
            if (z2 && i2 == 2) {
                i14 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                for (int i17 = 0; i17 < tLRPC$messages_Messages.messages.size(); i17++) {
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i17);
                    if ((!tLRPC$Message.out || tLRPC$Message.from_scheduled) && (i16 = tLRPC$Message.id) > i3 && i16 < i14) {
                        i14 = i16;
                    }
                }
                i13 = i3;
            } else {
                i13 = i3;
                i14 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            }
            i15 = i14 == Integer.MAX_VALUE ? i13 : i14;
        }
        if (i == 1 && i4 == 1) {
            getNotificationCenter().postNotificationName(NotificationCenter.scheduledMessagesUpdated, Long.valueOf(j), Integer.valueOf(arrayList.size()));
        }
        if (!DialogObject.isEncryptedDialog(j)) {
            final int i18 = i15;
            getMediaDataController().loadReplyMessagesForMessages(arrayList, j, i == 1, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ntYxSzomKt9wap2pdFwLYi5ua80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedMessages$154$MessagesController(z3, i5, i6, z, z4, i7, j, i4, arrayList, i18, i8, i9, i2, i10, i11, i12, i);
                }
            });
            z5 = true;
        } else {
            z5 = true;
            getNotificationCenter().postNotificationName(NotificationCenter.messagesDidLoad, Long.valueOf(j), Integer.valueOf(i4), arrayList, Boolean.valueOf(z), Integer.valueOf(i15), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i2), Boolean.valueOf(z4), Integer.valueOf(i5), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i));
        }
        if (arrayList2.isEmpty()) {
            messagesController = this;
            z6 = i;
            j2 = j;
        } else {
            z6 = i;
            messagesController = this;
            j2 = j;
            messagesController.reloadMessages(arrayList2, j2, z6 == z5);
        }
        if (map.isEmpty()) {
            return;
        }
        if (z6 == z5) {
            map2 = map;
        } else {
            map2 = map;
            z5 = false;
        }
        messagesController.reloadWebPages(j2, map2, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedMessages$154, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedMessages$154$MessagesController(boolean z, int i, int i2, boolean z2, boolean z3, int i3, long j, int i4, ArrayList arrayList, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        if (!z) {
            getNotificationCenter().postNotificationName(NotificationCenter.messagesDidLoadWithoutProcess, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i3));
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.messagesDidLoad, Long.valueOf(j), Integer.valueOf(i4), arrayList, Boolean.valueOf(z2), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z3), Integer.valueOf(i), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }
    }

    public void loadHintDialogs() {
        if (!this.hintDialogs.isEmpty() || TextUtils.isEmpty(this.installReferer)) {
            return;
        }
        TLRPC$TL_help_getRecentMeUrls tLRPC$TL_help_getRecentMeUrls = new TLRPC$TL_help_getRecentMeUrls();
        tLRPC$TL_help_getRecentMeUrls.referer = this.installReferer;
        getConnectionsManager().sendRequest(tLRPC$TL_help_getRecentMeUrls, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$nqx74ajAwddI7OPNEsZGMcN7DkM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadHintDialogs$157$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadHintDialogs$157, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHintDialogs$157$MessagesController(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$l8anvIuR_ghG-eNyQJDxGQ_bvUA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHintDialogs$156$MessagesController(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadHintDialogs$156, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHintDialogs$156$MessagesController(TLObject tLObject) {
        TLRPC$TL_help_recentMeUrls tLRPC$TL_help_recentMeUrls = (TLRPC$TL_help_recentMeUrls) tLObject;
        putUsers(tLRPC$TL_help_recentMeUrls.users, false);
        putChats(tLRPC$TL_help_recentMeUrls.chats, false);
        this.hintDialogs.clear();
        this.hintDialogs.addAll(tLRPC$TL_help_recentMeUrls.urls);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    public void checkDialogAd() {
        if (this.checkingDialogAd || this.nextDialogAdCheckTime > ConnectionsManager.getInstance(this.currentAccount).getCurrentTime()) {
            return;
        }
        this.checkingDialogAd = true;
        TLRPC$TL_ads_getAdsPack tLRPC$TL_ads_getAdsPack = new TLRPC$TL_ads_getAdsPack();
        tLRPC$TL_ads_getAdsPack.location = new TLRPC$TL_ads_inputAdsLocationDialog();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_ads_getAdsPack, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$BGorWLhDwnQDFm02FrdFOIguSzE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkDialogAd$159$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDialogAd$159, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDialogAd$159$MessagesController(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xnGInOi7E4RECjRxsYEJNjftNq0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkDialogAd$158$MessagesController(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDialogAd$158, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDialogAd$158$MessagesController(TLObject tLObject) {
        ArrayList arrayList = new ArrayList();
        Iterator<TLRPC$Ads_Ad> it = ((TLRPC$TL_ads_AdPack) tLObject).ads.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        ImageLoader.saveAdsThumbs(arrayList);
        if (!arrayList.isEmpty()) {
            if (arrayList.get(0) instanceof TLRPC$TL_ads_dialogAd) {
                this.dialogAd = (TLRPC$TL_ads_dialogAd) arrayList.get(0);
                this.nextDialogAdCheckTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + this.dialogAd.expire;
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
            } else if (arrayList.get(0) instanceof TLRPC$TL_ads_emptyAd) {
                TLRPC$TL_ads_emptyAd tLRPC$TL_ads_emptyAd = (TLRPC$TL_ads_emptyAd) arrayList.get(0);
                this.dialogAd = null;
                this.nextDialogAdCheckTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + tLRPC$TL_ads_emptyAd.expires;
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
            }
        }
        this.checkingDialogAd = false;
    }

    private TLRPC$TL_dialogFolder ensureFolderDialogExists(int folderId, boolean[] folderCreated) {
        if (folderId == 0) {
            return null;
        }
        long jMakeFolderDialogId = DialogObject.makeFolderDialogId(folderId);
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(jMakeFolderDialogId);
        if (tLRPC$Dialog instanceof TLRPC$TL_dialogFolder) {
            if (folderCreated != null) {
                folderCreated[0] = false;
            }
            return (TLRPC$TL_dialogFolder) tLRPC$Dialog;
        }
        if (folderCreated != null) {
            folderCreated[0] = true;
        }
        TLRPC$TL_dialogFolder tLRPC$TL_dialogFolder = new TLRPC$TL_dialogFolder();
        tLRPC$TL_dialogFolder.id = jMakeFolderDialogId;
        tLRPC$TL_dialogFolder.peer = new TLRPC$TL_peerUser();
        TLRPC$TL_folder tLRPC$TL_folder = new TLRPC$TL_folder();
        tLRPC$TL_dialogFolder.folder = tLRPC$TL_folder;
        tLRPC$TL_folder.id = folderId;
        tLRPC$TL_folder.title = LocaleController.getString("ArchivedChats", R.string.ArchivedChats);
        tLRPC$TL_dialogFolder.pinned = true;
        int iMax = 0;
        for (int i = 0; i < this.allDialogs.size(); i++) {
            TLRPC$Dialog tLRPC$Dialog2 = this.allDialogs.get(i);
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
        this.dialogs_dict.put(jMakeFolderDialogId, tLRPC$TL_dialogFolder);
        this.allDialogs.add(0, tLRPC$TL_dialogFolder);
        return tLRPC$TL_dialogFolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeFolder, reason: merged with bridge method [inline-methods] */
    public void lambda$onFolderEmpty$160$MessagesController(int folderId) {
        long jMakeFolderDialogId = DialogObject.makeFolderDialogId(folderId);
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(jMakeFolderDialogId);
        if (tLRPC$Dialog == null) {
            return;
        }
        this.dialogs_dict.remove(jMakeFolderDialogId);
        this.allDialogs.remove(tLRPC$Dialog);
        sortDialogs(null);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.folderBecomeEmpty, Integer.valueOf(folderId));
    }

    protected void onFolderEmpty(final int folderId) {
        if (getUserConfig().getDialogLoadOffsets(folderId)[0] == 2147483647L) {
            lambda$onFolderEmpty$160(folderId);
        } else {
            loadDialogs(folderId, 0, 10, false, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$lXmdbpRqKnl-EG8iT4dYa_xPX4Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFolderEmpty$160$MessagesController(folderId);
                }
            });
        }
    }

    public void checkIfFolderEmpty(int folderId) {
        if (folderId == 0) {
            return;
        }
        getMessagesStorage().checkIfFolderEmpty(folderId);
    }

    public int addDialogToFolder(long dialogId, int folderId, int pinnedNum, long taskId) {
        ArrayList<Long> arrayList = new ArrayList<>(1);
        arrayList.add(Long.valueOf(dialogId));
        return addDialogToFolder(arrayList, folderId, pinnedNum, null, taskId);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0145 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int addDialogToFolder(java.util.ArrayList<java.lang.Long> r24, int r25, int r26, java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_inputFolderPeer> r27, long r28) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.addDialogToFolder(java.util.ArrayList, int, int, java.util.ArrayList, long):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addDialogToFolder$161, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addDialogToFolder$161$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void loadDialogs(final int folderId, int offset, int count, boolean fromCache) {
        loadDialogs(folderId, offset, count, fromCache, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0150 A[PHI: r7
      0x0150: PHI (r7v7 long) = (r7v5 long), (r7v6 long) binds: [B:54:0x014e, B:57:0x0156] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadDialogs(final int r17, int r18, final int r19, boolean r20, final java.lang.Runnable r21) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.loadDialogs(int, int, int, boolean, java.lang.Runnable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDialogs$162, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadDialogs$162$MessagesController(int i, int i2, Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Dialogs tLRPC$messages_Dialogs = (TLRPC$messages_Dialogs) tLObject;
            processLoadedDialogs(tLRPC$messages_Dialogs, null, i, 0, i2, 0, false, false, false);
            if (runnable == null || !tLRPC$messages_Dialogs.dialogs.isEmpty()) {
                return;
            }
            AndroidUtilities.runOnUIThread(runnable);
        }
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
                editorEdit2.remove("EnableGroup").commit();
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
                editorEdit.remove("EnableAll").commit();
            }
            if (editorEdit != null) {
                editorEdit.commit();
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
                getConnectionsManager().sendRequest(tLRPC$TL_account_getNotifySettings, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$YLA69eHkizzeiDSI3_YVJjD_hjs
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$loadGlobalNotificationsSettings$164$MessagesController(i, tLObject, tLRPC$TL_error);
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
    /* renamed from: lambda$loadGlobalNotificationsSettings$164, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadGlobalNotificationsSettings$164$MessagesController(final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xrA8LoiT1Hza8ogW94LDoQ3DIRc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadGlobalNotificationsSettings$163$MessagesController(tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadGlobalNotificationsSettings$163, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadGlobalNotificationsSettings$163$MessagesController(TLObject tLObject, int i) {
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
            editorEdit.commit();
            if (this.loadingNotificationSettings == 0) {
                getUserConfig().notificationsSettingsLoaded = true;
                getUserConfig().saveConfig(false);
            }
        }
    }

    private /* synthetic */ void lambda$loadSignUpNotificationsSettings$166(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$_lsuLJQKUfVBt_Rjwdnw2di5MIE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSignUpNotificationsSettings$165$MessagesController(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSignUpNotificationsSettings$165, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSignUpNotificationsSettings$165$MessagesController(TLObject tLObject) {
        this.loadingNotificationSignUpSettings = false;
        SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
        boolean z = tLObject instanceof TLRPC$TL_boolFalse;
        this.enableJoined = z;
        editorEdit.putBoolean("EnableContactJoined", z);
        editorEdit.commit();
        getUserConfig().notificationsSignUpSettingsLoaded = true;
        getUserConfig().saveConfig(false);
    }

    public void forceResetDialogs() {
        resetDialogs(true, getMessagesStorage().getLastSeqValue(), getMessagesStorage().getLastPtsValue(), getMessagesStorage().getLastDateValue(), getMessagesStorage().getLastQtsValue());
        getNotificationsController().deleteAllNotificationChannels();
    }

    protected void loadUnknownDialog(final TLRPC$InputPeer peer, long taskId) {
        NativeByteBuffer nativeByteBuffer;
        if (peer == null) {
            return;
        }
        final long peerDialogId = DialogObject.getPeerDialogId(peer);
        if (this.gettingUnknownDialogs.indexOfKey(peerDialogId) >= 0) {
            return;
        }
        this.gettingUnknownDialogs.put(peerDialogId, Boolean.TRUE);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("load unknown dialog " + peerDialogId);
        }
        TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs = new TLRPC$TL_messages_getPeerDialogs();
        new TLRPC$TL_inputDialogPeer().peer = peer;
        tLRPC$TL_messages_getPeerDialogs.peers.add(peer);
        if (taskId == 0) {
            NativeByteBuffer nativeByteBuffer2 = null;
            try {
                nativeByteBuffer = new NativeByteBuffer(peer.getObjectSize() + 4);
            } catch (Exception e) {
                e = e;
            }
            try {
                nativeByteBuffer.writeInt32(15);
                peer.serializeToStream(nativeByteBuffer);
            } catch (Exception e2) {
                e = e2;
                nativeByteBuffer2 = nativeByteBuffer;
                FileLog.e(e);
                nativeByteBuffer = nativeByteBuffer2;
                taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
                final long j = taskId;
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$c3xkkv3EKVlV4FR4i-8ejGjgaDQ
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$loadUnknownDialog$167$MessagesController(j, peerDialogId, tLObject, tLRPC$TL_error);
                    }
                });
            }
            taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        final long j2 = taskId;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$c3xkkv3EKVlV4FR4i-8ejGjgaDQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadUnknownDialog$167$MessagesController(j2, peerDialogId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUnknownDialog$167, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUnknownDialog$167$MessagesController(long j, long j2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = (TLRPC$TL_messages_peerDialogs) tLObject;
            if (!tLRPC$TL_messages_peerDialogs.dialogs.isEmpty()) {
                TLRPC$TL_dialog tLRPC$TL_dialog = (TLRPC$TL_dialog) tLRPC$TL_messages_peerDialogs.dialogs.get(0);
                TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
                tLRPC$TL_messages_dialogs.dialogs.addAll(tLRPC$TL_messages_peerDialogs.dialogs);
                tLRPC$TL_messages_dialogs.messages.addAll(tLRPC$TL_messages_peerDialogs.messages);
                tLRPC$TL_messages_dialogs.users.addAll(tLRPC$TL_messages_peerDialogs.users);
                tLRPC$TL_messages_dialogs.chats.addAll(tLRPC$TL_messages_peerDialogs.chats);
                processLoadedDialogs(tLRPC$TL_messages_dialogs, null, tLRPC$TL_dialog.folder_id, 0, 1, this.DIALOGS_LOAD_TYPE_UNKNOWN, false, false, false);
            }
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
        this.gettingUnknownDialogs.delete(j2);
    }

    private void fetchFolderInLoadedPinnedDialogs(TLRPC$TL_messages_peerDialogs res) {
        TLRPC$InputPeer tLRPC$TL_inputPeerUser;
        int size = res.dialogs.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$Dialog tLRPC$Dialog = res.dialogs.get(i2);
            if (tLRPC$Dialog instanceof TLRPC$TL_dialogFolder) {
                TLRPC$TL_dialogFolder tLRPC$TL_dialogFolder = (TLRPC$TL_dialogFolder) tLRPC$Dialog;
                long peerDialogId = DialogObject.getPeerDialogId(tLRPC$Dialog.peer);
                if (tLRPC$TL_dialogFolder.top_message == 0 || peerDialogId == 0) {
                    res.dialogs.remove(tLRPC$TL_dialogFolder);
                } else {
                    int size2 = res.messages.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        TLRPC$Message tLRPC$Message = res.messages.get(i3);
                        if (peerDialogId == MessageObject.getDialogId(tLRPC$Message) && tLRPC$Dialog.top_message == tLRPC$Message.id) {
                            TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
                            tLRPC$TL_dialog.peer = tLRPC$Dialog.peer;
                            tLRPC$TL_dialog.top_message = tLRPC$Dialog.top_message;
                            tLRPC$TL_dialog.folder_id = tLRPC$TL_dialogFolder.folder.id;
                            tLRPC$TL_dialog.flags |= 16;
                            res.dialogs.add(tLRPC$TL_dialog);
                            TLRPC$Peer tLRPC$Peer = tLRPC$Dialog.peer;
                            if (tLRPC$Peer instanceof TLRPC$TL_peerChannel) {
                                tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerChannel();
                                tLRPC$TL_inputPeerUser.channel_id = tLRPC$Dialog.peer.channel_id;
                                int size3 = res.chats.size();
                                while (true) {
                                    if (i >= size3) {
                                        break;
                                    }
                                    TLRPC$Chat tLRPC$Chat = res.chats.get(i);
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
                                int size4 = res.users.size();
                                while (true) {
                                    if (i >= size4) {
                                        break;
                                    }
                                    TLRPC$User tLRPC$User = res.users.get(i);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resetDialogs$168, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resetDialogs$168$MessagesController(int i, int i2, int i3, int i4, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            this.resetDialogsPinned = (TLRPC$TL_messages_peerDialogs) tLObject;
            for (int i5 = 0; i5 < this.resetDialogsPinned.dialogs.size(); i5++) {
                this.resetDialogsPinned.dialogs.get(i5).pinned = true;
            }
            resetDialogs(false, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resetDialogs$169, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resetDialogs$169$MessagesController(int i, int i2, int i3, int i4, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.resetDialogsAll = (TLRPC$messages_Dialogs) tLObject;
            resetDialogs(false, i, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0205  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void resetDialogs(boolean r27, final int r28, final int r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.resetDialogs(boolean, int, int, int, int):void");
    }

    protected void completeDialogsReset(final TLRPC$messages_Dialogs dialogsRes, int messagesCount, int seq, final int newPts, final int date, final int qts, final LongSparseArray<TLRPC$Dialog> new_dialogs_dict, final LongSparseArray<MessageObject> new_dialogMessage, TLRPC$Message lastMessage) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$kjpm6QbkptTfUOSzEsJeVpTQvz8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$completeDialogsReset$171$MessagesController(newPts, date, qts, dialogsRes, new_dialogs_dict, new_dialogMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$completeDialogsReset$171, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$completeDialogsReset$171$MessagesController(int i, int i2, int i3, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final LongSparseArray longSparseArray, final LongSparseArray longSparseArray2) {
        this.gettingDifference = false;
        getMessagesStorage().setLastPtsValue(i);
        getMessagesStorage().setLastDateValue(i2);
        getMessagesStorage().setLastQtsValue(i3);
        getDifference();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ENuqkiC67BiKUA3al7u2Ao3EBfU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$completeDialogsReset$170$MessagesController(tLRPC$messages_Dialogs, longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$completeDialogsReset$170, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$completeDialogsReset$170$MessagesController(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        TLRPC$Dialog tLRPC$Dialog;
        this.resetingDialogs = false;
        applyDialogsNotificationsSettings(tLRPC$messages_Dialogs.dialogs);
        MediaDataController mediaDataController = getMediaDataController();
        mediaDataController.clearAllDrafts(false);
        mediaDataController.loadDraftsIfNeed();
        putUsers(tLRPC$messages_Dialogs.users, false);
        putChats(tLRPC$messages_Dialogs.chats, false);
        for (int i = 0; i < this.allDialogs.size(); i++) {
            TLRPC$Dialog tLRPC$Dialog2 = this.allDialogs.get(i);
            if (!DialogObject.isEncryptedDialog(tLRPC$Dialog2.id)) {
                this.dialogs_dict.remove(tLRPC$Dialog2.id);
                MessageObject messageObject = this.dialogMessage.get(tLRPC$Dialog2.id);
                this.dialogMessage.remove(tLRPC$Dialog2.id);
                if (messageObject != null) {
                    if (messageObject.messageOwner.peer_id.channel_id == 0) {
                        this.dialogMessagesByIds.remove(messageObject.getId());
                    }
                    long j = messageObject.messageOwner.random_id;
                    if (j != 0) {
                        this.dialogMessagesByRandomIds.remove(j);
                    }
                }
            }
        }
        for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
            long jKeyAt = longSparseArray.keyAt(i2);
            TLRPC$Dialog tLRPC$Dialog3 = (TLRPC$Dialog) longSparseArray.valueAt(i2);
            TLRPC$DraftMessage tLRPC$DraftMessage = tLRPC$Dialog3.draft;
            if (tLRPC$DraftMessage instanceof TLRPC$TL_draftMessage) {
                tLRPC$Dialog = tLRPC$Dialog3;
                mediaDataController.saveDraft(tLRPC$Dialog3.id, 0, tLRPC$DraftMessage, null, false);
            } else {
                tLRPC$Dialog = tLRPC$Dialog3;
            }
            this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
            MessageObject messageObject2 = (MessageObject) longSparseArray2.get(tLRPC$Dialog.id);
            this.dialogMessage.put(jKeyAt, messageObject2);
            if (messageObject2 != null && messageObject2.messageOwner.peer_id.channel_id == 0) {
                this.dialogMessagesByIds.put(messageObject2.getId(), messageObject2);
                this.dialogsLoadedTillDate = Math.min(this.dialogsLoadedTillDate, messageObject2.messageOwner.date);
                long j2 = messageObject2.messageOwner.random_id;
                if (j2 != 0) {
                    this.dialogMessagesByRandomIds.put(j2, messageObject2);
                }
            }
        }
        this.allDialogs.clear();
        int size = this.dialogs_dict.size();
        for (int i3 = 0; i3 < size; i3++) {
            TLRPC$Dialog tLRPC$DialogValueAt = this.dialogs_dict.valueAt(i3);
            if (this.deletingDialogs.indexOfKey(tLRPC$DialogValueAt.id) < 0) {
                this.allDialogs.add(tLRPC$DialogValueAt);
            }
        }
        sortDialogs(null);
        this.dialogsEndReached.put(0, true);
        this.serverDialogsEndReached.put(0, false);
        this.dialogsEndReached.put(1, true);
        this.serverDialogsEndReached.put(1, false);
        int totalDialogsCount = getUserConfig().getTotalDialogsCount(0);
        long[] dialogLoadOffsets = getUserConfig().getDialogLoadOffsets(0);
        if (totalDialogsCount < 400 && dialogLoadOffsets[0] != -1 && dialogLoadOffsets[0] != 2147483647L) {
            loadDialogs(0, 0, 100, false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    private void migrateDialogs(final int offset, int offsetDate, long offsetUser, long offsetChat, long offsetChannel, long accessPeer) {
        if (this.migratingDialogs || offset == -1) {
            return;
        }
        this.migratingDialogs = true;
        TLRPC$TL_messages_getDialogs tLRPC$TL_messages_getDialogs = new TLRPC$TL_messages_getDialogs();
        tLRPC$TL_messages_getDialogs.exclude_pinned = true;
        tLRPC$TL_messages_getDialogs.limit = 100;
        tLRPC$TL_messages_getDialogs.offset_id = offset;
        tLRPC$TL_messages_getDialogs.offset_date = offsetDate;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start migrate with id " + offset + " date " + LocaleController.getInstance().formatterStats.format(offsetDate * 1000));
        }
        if (offset == 0) {
            tLRPC$TL_messages_getDialogs.offset_peer = new TLRPC$TL_inputPeerEmpty();
        } else {
            if (offsetChannel != 0) {
                TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                tLRPC$TL_messages_getDialogs.offset_peer = tLRPC$TL_inputPeerChannel;
                tLRPC$TL_inputPeerChannel.channel_id = offsetChannel;
            } else if (offsetUser != 0) {
                TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
                tLRPC$TL_messages_getDialogs.offset_peer = tLRPC$TL_inputPeerUser;
                tLRPC$TL_inputPeerUser.user_id = offsetUser;
            } else {
                TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
                tLRPC$TL_messages_getDialogs.offset_peer = tLRPC$TL_inputPeerChat;
                tLRPC$TL_inputPeerChat.chat_id = offsetChat;
            }
            tLRPC$TL_messages_getDialogs.offset_peer.access_hash = accessPeer;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Dy_BpxpNiQgy6J24NkoEAwNk5TQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$migrateDialogs$175$MessagesController(offset, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$migrateDialogs$175, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$migrateDialogs$175$MessagesController(final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            final TLRPC$messages_Dialogs tLRPC$messages_Dialogs = (TLRPC$messages_Dialogs) tLObject;
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$76b5lpyp73bxFbor7usQB3k568g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$migrateDialogs$173$MessagesController(tLRPC$messages_Dialogs, i);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$opcY5RKOntS2g1pTrWGIyjWQHSY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$migrateDialogs$174$MessagesController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0384 A[Catch: Exception -> 0x041f, TryCatch #0 {Exception -> 0x041f, blocks: (B:3:0x0004, B:4:0x001d, B:7:0x0029, B:9:0x0035, B:11:0x0062, B:14:0x0069, B:15:0x006c, B:17:0x0070, B:18:0x009b, B:20:0x00a7, B:28:0x00f1, B:29:0x0104, B:31:0x010c, B:33:0x011d, B:34:0x0122, B:35:0x012f, B:36:0x014e, B:38:0x0154, B:40:0x0164, B:43:0x0169, B:44:0x016f, B:46:0x0177, B:52:0x0198, B:49:0x0188, B:51:0x0195, B:53:0x019a, B:54:0x019e, B:56:0x01a5, B:57:0x01bf, B:59:0x01d5, B:60:0x01e1, B:63:0x01eb, B:69:0x01fd, B:70:0x024c, B:72:0x0256, B:75:0x027f, B:77:0x0295, B:79:0x029d, B:82:0x02ad, B:88:0x02bc, B:89:0x02f9, B:91:0x0301, B:97:0x032f, B:99:0x0344, B:100:0x035b, B:102:0x0363, B:104:0x0377, B:105:0x0381, B:124:0x040e, B:106:0x0384, B:108:0x038a, B:109:0x03a1, B:111:0x03a9, B:113:0x03bd, B:114:0x03c6, B:115:0x03c9, B:117:0x03cf, B:118:0x03e6, B:120:0x03ee, B:122:0x0402, B:123:0x040b, B:21:0x00aa, B:23:0x00ae, B:26:0x00b6), top: B:129:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0344 A[Catch: Exception -> 0x041f, TryCatch #0 {Exception -> 0x041f, blocks: (B:3:0x0004, B:4:0x001d, B:7:0x0029, B:9:0x0035, B:11:0x0062, B:14:0x0069, B:15:0x006c, B:17:0x0070, B:18:0x009b, B:20:0x00a7, B:28:0x00f1, B:29:0x0104, B:31:0x010c, B:33:0x011d, B:34:0x0122, B:35:0x012f, B:36:0x014e, B:38:0x0154, B:40:0x0164, B:43:0x0169, B:44:0x016f, B:46:0x0177, B:52:0x0198, B:49:0x0188, B:51:0x0195, B:53:0x019a, B:54:0x019e, B:56:0x01a5, B:57:0x01bf, B:59:0x01d5, B:60:0x01e1, B:63:0x01eb, B:69:0x01fd, B:70:0x024c, B:72:0x0256, B:75:0x027f, B:77:0x0295, B:79:0x029d, B:82:0x02ad, B:88:0x02bc, B:89:0x02f9, B:91:0x0301, B:97:0x032f, B:99:0x0344, B:100:0x035b, B:102:0x0363, B:104:0x0377, B:105:0x0381, B:124:0x040e, B:106:0x0384, B:108:0x038a, B:109:0x03a1, B:111:0x03a9, B:113:0x03bd, B:114:0x03c6, B:115:0x03c9, B:117:0x03cf, B:118:0x03e6, B:120:0x03ee, B:122:0x0402, B:123:0x040b, B:21:0x00aa, B:23:0x00ae, B:26:0x00b6), top: B:129:0x0004 }] */
    /* renamed from: lambda$migrateDialogs$173, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$migrateDialogs$173$MessagesController(ir.eitaa.tgnet.TLRPC$messages_Dialogs r36, int r37) {
        /*
            Method dump skipped, instructions count: 1070
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$migrateDialogs$173$MessagesController(ir.eitaa.tgnet.TLRPC$messages_Dialogs, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$migrateDialogs$172, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$migrateDialogs$172$MessagesController() {
        this.migratingDialogs = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$migrateDialogs$174, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$migrateDialogs$174$MessagesController() {
        this.migratingDialogs = false;
    }

    public void processLoadedDialogs(final TLRPC$messages_Dialogs dialogsRes, final ArrayList<TLRPC$EncryptedChat> encChats, final int folderId, final int offset, final int count, final int loadType, final boolean resetEnd, final boolean migrate, final boolean fromCache) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$5WABzPuPCheosmarMNIFEyXroY8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDialogs$179$MessagesController(folderId, loadType, dialogsRes, resetEnd, count, encChats, offset, fromCache, migrate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0340, code lost:
    
        if (r6 == r0.id) goto L147;
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03d5  */
    /* renamed from: lambda$processLoadedDialogs$179, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processLoadedDialogs$179$MessagesController(final int r34, final int r35, final ir.eitaa.tgnet.TLRPC$messages_Dialogs r36, final boolean r37, final int r38, final java.util.ArrayList r39, final int r40, final boolean r41, final boolean r42) {
        /*
            Method dump skipped, instructions count: 1256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$processLoadedDialogs$179$MessagesController(int, int, ir.eitaa.tgnet.TLRPC$messages_Dialogs, boolean, int, java.util.ArrayList, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedDialogs$176, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDialogs$176$MessagesController(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, int i, boolean z, long[] jArr, int i2) {
        putUsers(tLRPC$messages_Dialogs.users, true);
        this.loadingDialogs.put(i, false);
        if (z) {
            this.dialogsEndReached.put(i, false);
            this.serverDialogsEndReached.put(i, false);
        } else if (jArr[0] == 2147483647L) {
            this.dialogsEndReached.put(i, true);
            this.serverDialogsEndReached.put(i, true);
        } else {
            loadDialogs(i, 0, i2, false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedDialogs$177, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDialogs$177$MessagesController(TLRPC$Chat tLRPC$Chat) {
        checkChatInviter(tLRPC$Chat.id, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r1v88 */
    /* renamed from: lambda$processLoadedDialogs$178, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDialogs$178$MessagesController(TLRPC$Message tLRPC$Message, int i, TLRPC$messages_Dialogs tLRPC$messages_Dialogs, ArrayList arrayList, boolean z, int i2, LongSparseArray longSparseArray, LongSparseArray longSparseArray2, LongSparseArray longSparseArray3, boolean z2, int i3, int i4, ArrayList arrayList2) {
        int i5;
        int i6;
        int i7;
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
                if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) && AndroidUtilities.getMyLayerVersion(tLRPC$EncryptedChat.layer) < SecretChatHelper.CURRENT_SECRET_CHAT_LAYER) {
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
            i5 = 0;
        } else {
            ArrayList<TLRPC$Dialog> arrayList3 = this.allDialogs;
            i5 = arrayList3.get(arrayList3.size() - 1).last_message_date;
        }
        int i9 = 0;
        int i10 = 0;
        boolean z3 = false;
        while (i9 < longSparseArray.size()) {
            long jKeyAt = longSparseArray.keyAt(i9);
            TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) longSparseArray.valueAt(i9);
            TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(jKeyAt);
            if (z && tLRPC$Dialog2 != null) {
                tLRPC$Dialog2.folder_id = tLRPC$Dialog.folder_id;
            }
            if (!z || i5 == 0 || tLRPC$Dialog.last_message_date >= i5) {
                if (i != this.DIALOGS_LOAD_TYPE_CACHE && (tLRPC$Dialog.draft instanceof TLRPC$TL_draftMessage)) {
                    getMediaDataController().saveDraft(tLRPC$Dialog.id, 0, tLRPC$Dialog.draft, null, false);
                }
                if (tLRPC$Dialog.folder_id != i2) {
                    i10++;
                }
                MessageObject messageObject = (MessageObject) longSparseArray2.get(tLRPC$Dialog.id);
                if (tLRPC$Dialog2 == null) {
                    this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
                    this.dialogMessage.put(jKeyAt, messageObject);
                    if (messageObject != null && messageObject.messageOwner.peer_id.channel_id == 0) {
                        this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                        long j = messageObject.messageOwner.random_id;
                        if (j != 0) {
                            this.dialogMessagesByRandomIds.put(j, messageObject);
                        }
                    }
                    i7 = i5;
                    z3 = true;
                } else {
                    if (i != this.DIALOGS_LOAD_TYPE_CACHE) {
                        tLRPC$Dialog2.notify_settings = tLRPC$Dialog.notify_settings;
                    }
                    tLRPC$Dialog2.pinned = tLRPC$Dialog.pinned;
                    tLRPC$Dialog2.pinnedNum = tLRPC$Dialog.pinnedNum;
                    MessageObject messageObject2 = this.dialogMessage.get(jKeyAt);
                    i7 = i5;
                    if ((messageObject2 != null && messageObject2.deleted) || messageObject2 == null || tLRPC$Dialog2.top_message > 0) {
                        if (tLRPC$Dialog.top_message >= tLRPC$Dialog2.top_message) {
                            this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
                            this.dialogMessage.put(jKeyAt, messageObject);
                            if (messageObject2 != null) {
                                if (messageObject2.messageOwner.peer_id.channel_id == 0) {
                                    this.dialogMessagesByIds.remove(messageObject2.getId());
                                }
                                long j2 = messageObject2.messageOwner.random_id;
                                if (j2 != 0) {
                                    this.dialogMessagesByRandomIds.remove(j2);
                                }
                            }
                            if (messageObject != null) {
                                if (messageObject2 != null && messageObject2.getId() == messageObject.getId()) {
                                    messageObject.deleted = messageObject2.deleted;
                                }
                                if (messageObject.messageOwner.peer_id.channel_id == 0) {
                                    this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                                    long j3 = messageObject.messageOwner.random_id;
                                    if (j3 != 0) {
                                        this.dialogMessagesByRandomIds.put(j3, messageObject);
                                    }
                                }
                            }
                        }
                    } else if ((messageObject == null && messageObject2.getId() > 0) || (messageObject != null && messageObject.messageOwner.date > messageObject2.messageOwner.date)) {
                        this.dialogs_dict.put(jKeyAt, tLRPC$Dialog);
                        this.dialogMessage.put(jKeyAt, messageObject);
                        if (messageObject2.messageOwner.peer_id.channel_id == 0) {
                            this.dialogMessagesByIds.remove(messageObject2.getId());
                        }
                        if (messageObject != null && messageObject.messageOwner.peer_id.channel_id == 0) {
                            this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                            long j4 = messageObject.messageOwner.random_id;
                            if (j4 != 0) {
                                this.dialogMessagesByRandomIds.put(j4, messageObject);
                            }
                        }
                        long j5 = messageObject2.messageOwner.random_id;
                        if (j5 != 0) {
                            this.dialogMessagesByRandomIds.remove(j5);
                        }
                    }
                }
            } else {
                i7 = i5;
            }
            i9++;
            i5 = i7;
        }
        this.allDialogs.clear();
        int size = this.dialogs_dict.size();
        for (int i11 = 0; i11 < size; i11++) {
            TLRPC$Dialog tLRPC$DialogValueAt = this.dialogs_dict.valueAt(i11);
            if (this.deletingDialogs.indexOfKey(tLRPC$DialogValueAt.id) < 0) {
                this.allDialogs.add(tLRPC$DialogValueAt);
            }
        }
        sortDialogs(z ? longSparseArray3 : null);
        putAllNeededDraftDialogs();
        if (i != this.DIALOGS_LOAD_TYPE_CHANNEL && i != this.DIALOGS_LOAD_TYPE_UNKNOWN && !z) {
            this.dialogsEndReached.put(i2, (tLRPC$messages_Dialogs.dialogs.size() == 0 || !(tLRPC$messages_Dialogs instanceof TLRPC$TL_messages_dialogsSlice)) && i == 0);
            if (i10 > 0 && i10 < 20 && i2 == 0) {
                this.dialogsEndReached.put(1, true);
                if (getUserConfig().getDialogLoadOffsets(i2)[0] == 2147483647L) {
                    this.serverDialogsEndReached.put(1, true);
                }
            }
            if (!z2) {
                this.serverDialogsEndReached.put(i2, (tLRPC$messages_Dialogs.dialogs.size() == 0 || !(tLRPC$messages_Dialogs instanceof TLRPC$TL_messages_dialogsSlice)) && i == 0);
            }
        }
        int totalDialogsCount = getUserConfig().getTotalDialogsCount(i2);
        long[] dialogLoadOffsets = getUserConfig().getDialogLoadOffsets(i2);
        if (z2 || z || totalDialogsCount >= 400) {
            i6 = 0;
        } else {
            i6 = 0;
            i6 = 0;
            i6 = 0;
            if (dialogLoadOffsets[0] != -1 && dialogLoadOffsets[0] != 2147483647L) {
                loadDialogs(i2, 0, 100, false);
            }
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[i6]);
        if (z) {
            getUserConfig().migrateOffsetId = i3;
            getUserConfig().saveConfig(i6);
            this.migratingDialogs = i6;
            getNotificationCenter().postNotificationName(NotificationCenter.needReloadRecentDialogsSearch, new Object[i6]);
        } else {
            generateUpdateMessage();
            if (!z3 && i == this.DIALOGS_LOAD_TYPE_CACHE && this.dialogsEndReached.get(i2)) {
                loadDialogs(i2, i6, i4, i6);
            }
        }
        migrateDialogs(getUserConfig().migrateOffsetId, getUserConfig().migrateOffsetDate, getUserConfig().migrateOffsetUserId, getUserConfig().migrateOffsetChatId, getUserConfig().migrateOffsetChannelId, getUserConfig().migrateOffsetAccess);
        if (!arrayList2.isEmpty()) {
            reloadDialogsReadValue(arrayList2, 0L);
        }
        loadUnreadDialogs();
    }

    private void applyDialogNotificationsSettings(long dialogId, TLRPC$PeerNotifySettings notify_settings) {
        int i;
        if (notify_settings == null) {
            return;
        }
        int i2 = this.notificationsPreferences.getInt("notify2_" + dialogId, -1);
        int i3 = this.notificationsPreferences.getInt("notifyuntil_" + dialogId, 0);
        SharedPreferences.Editor editorEdit = this.notificationsPreferences.edit();
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(dialogId);
        if (tLRPC$Dialog != null) {
            tLRPC$Dialog.notify_settings = notify_settings;
        }
        if ((notify_settings.flags & 2) != 0) {
            editorEdit.putBoolean("silent_" + dialogId, notify_settings.silent);
        } else {
            editorEdit.remove("silent_" + dialogId);
        }
        boolean z = true;
        if ((notify_settings.flags & 4) != 0) {
            if (notify_settings.mute_until > getConnectionsManager().getCurrentTime()) {
                if (notify_settings.mute_until <= getConnectionsManager().getCurrentTime() + 31536000) {
                    if (i2 == 3 && i3 == notify_settings.mute_until) {
                        z = false;
                    } else {
                        editorEdit.putInt("notify2_" + dialogId, 3);
                        editorEdit.putInt("notifyuntil_" + dialogId, notify_settings.mute_until);
                        if (tLRPC$Dialog != null) {
                            tLRPC$Dialog.notify_settings.mute_until = 0;
                        }
                    }
                    i = notify_settings.mute_until;
                } else if (i2 != 2) {
                    editorEdit.putInt("notify2_" + dialogId, 2);
                    if (tLRPC$Dialog != null) {
                        tLRPC$Dialog.notify_settings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    }
                    i = 0;
                } else {
                    i = 0;
                    z = false;
                }
                getMessagesStorage().setDialogNotificationFlags(dialogId, (i << 32) | 1);
                getNotificationsController().removeNotificationsForDialog(dialogId);
            } else {
                if (i2 == 0 || i2 == 1) {
                    z = false;
                } else {
                    if (tLRPC$Dialog != null) {
                        tLRPC$Dialog.notify_settings.mute_until = 0;
                    }
                    editorEdit.putInt("notify2_" + dialogId, 0);
                }
                getMessagesStorage().setDialogNotificationFlags(dialogId, 0L);
            }
        } else {
            if (i2 != -1) {
                if (tLRPC$Dialog != null) {
                    tLRPC$Dialog.notify_settings.mute_until = 0;
                }
                editorEdit.remove("notify2_" + dialogId);
            } else {
                z = false;
            }
            getMessagesStorage().setDialogNotificationFlags(dialogId, 0L);
        }
        editorEdit.commit();
        if (z) {
            getNotificationCenter().postNotificationName(NotificationCenter.notificationsSettingsUpdated, new Object[0]);
        }
    }

    private void applyDialogsNotificationsSettings(ArrayList<TLRPC$Dialog> dialogs) {
        SharedPreferences.Editor editorEdit = null;
        for (int i = 0; i < dialogs.size(); i++) {
            TLRPC$Dialog tLRPC$Dialog = dialogs.get(i);
            if (tLRPC$Dialog.peer != null && (tLRPC$Dialog.notify_settings instanceof TLRPC$TL_peerNotifySettings)) {
                if (editorEdit == null) {
                    editorEdit = this.notificationsPreferences.edit();
                }
                long peerId = MessageObject.getPeerId(tLRPC$Dialog.peer);
                if ((tLRPC$Dialog.notify_settings.flags & 2) != 0) {
                    editorEdit.putBoolean("silent_" + peerId, tLRPC$Dialog.notify_settings.silent);
                } else {
                    editorEdit.remove("silent_" + peerId);
                }
                TLRPC$PeerNotifySettings tLRPC$PeerNotifySettings = tLRPC$Dialog.notify_settings;
                if ((tLRPC$PeerNotifySettings.flags & 4) == 0) {
                    editorEdit.remove("notify2_" + peerId);
                } else if (tLRPC$PeerNotifySettings.mute_until <= getConnectionsManager().getCurrentTime()) {
                    editorEdit.putInt("notify2_" + peerId, 0);
                } else if (tLRPC$Dialog.notify_settings.mute_until > getConnectionsManager().getCurrentTime() + 31536000) {
                    editorEdit.putInt("notify2_" + peerId, 2);
                    tLRPC$Dialog.notify_settings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                } else {
                    editorEdit.putInt("notify2_" + peerId, 3);
                    editorEdit.putInt("notifyuntil_" + peerId, tLRPC$Dialog.notify_settings.mute_until);
                }
            }
        }
        if (editorEdit != null) {
            editorEdit.commit();
        }
    }

    public void reloadMentionsCountForChannel(final TLRPC$InputPeer peer, final long taskId) {
        NativeByteBuffer nativeByteBuffer;
        Exception e;
        if (taskId == 0) {
            try {
                nativeByteBuffer = new NativeByteBuffer(peer.getObjectSize() + 4);
            } catch (Exception e2) {
                nativeByteBuffer = null;
                e = e2;
            }
            try {
                nativeByteBuffer.writeInt32(22);
                peer.serializeToStream(nativeByteBuffer);
            } catch (Exception e3) {
                e = e3;
                FileLog.e(e);
                taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
                TLRPC$TL_messages_getUnreadMentions tLRPC$TL_messages_getUnreadMentions = new TLRPC$TL_messages_getUnreadMentions();
                tLRPC$TL_messages_getUnreadMentions.peer = peer;
                tLRPC$TL_messages_getUnreadMentions.limit = 1;
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getUnreadMentions, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$WExEuZx16aoaFzLX_ViKKWYPn6g
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$reloadMentionsCountForChannel$180$MessagesController(peer, taskId, tLObject, tLRPC$TL_error);
                    }
                });
            }
            taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        TLRPC$TL_messages_getUnreadMentions tLRPC$TL_messages_getUnreadMentions2 = new TLRPC$TL_messages_getUnreadMentions();
        tLRPC$TL_messages_getUnreadMentions2.peer = peer;
        tLRPC$TL_messages_getUnreadMentions2.limit = 1;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getUnreadMentions2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$WExEuZx16aoaFzLX_ViKKWYPn6g
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reloadMentionsCountForChannel$180$MessagesController(peer, taskId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadMentionsCountForChannel$180, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadMentionsCountForChannel$180$MessagesController(TLRPC$InputPeer tLRPC$InputPeer, long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

    public void reloadMentionsCountForChannels(final ArrayList<Long> arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$seyRQlWcS6cUMxOcP0eEpCUWkM0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reloadMentionsCountForChannels$181$MessagesController(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadMentionsCountForChannels$181, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadMentionsCountForChannels$181$MessagesController(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            reloadMentionsCountForChannel(getInputPeer(-((Long) arrayList.get(i)).longValue()), 0L);
        }
    }

    public void processDialogsUpdateRead(final LongSparseIntArray dialogsToUpdate, final LongSparseIntArray dialogsMentionsToUpdate) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$dgoxQcOZm4MdlNJfSKe7Rs5MgqI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDialogsUpdateRead$182$MessagesController(dialogsToUpdate, dialogsMentionsToUpdate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDialogsUpdateRead$182, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDialogsUpdateRead$182$MessagesController(LongSparseIntArray longSparseIntArray, LongSparseIntArray longSparseIntArray2) {
        boolean z;
        if (longSparseIntArray != null) {
            z = false;
            for (int i = 0; i < longSparseIntArray.size(); i++) {
                long jKeyAt = longSparseIntArray.keyAt(i);
                TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(jKeyAt);
                if (tLRPC$Dialog != null) {
                    int i2 = tLRPC$Dialog.unread_count;
                    int iValueAt = longSparseIntArray.valueAt(i);
                    tLRPC$Dialog.unread_count = iValueAt;
                    if (i2 != 0 && iValueAt == 0) {
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
                    } else if (i2 == 0 && !tLRPC$Dialog.unread_mark && iValueAt != 0) {
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
        if (longSparseIntArray2 != null) {
            for (int i5 = 0; i5 < longSparseIntArray2.size(); i5++) {
                TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(longSparseIntArray2.keyAt(i5));
                if (tLRPC$Dialog2 != null) {
                    tLRPC$Dialog2.unread_mentions_count = longSparseIntArray2.valueAt(i5);
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
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_READ_DIALOG_MESSAGE));
        if (longSparseIntArray != null) {
            getNotificationsController().processDialogsUpdateRead(longSparseIntArray);
        }
    }

    protected void checkLastDialogMessage(final TLRPC$Dialog dialog, TLRPC$InputPeer peer, final long taskId) {
        NativeByteBuffer nativeByteBuffer;
        Exception e;
        if (DialogObject.isEncryptedDialog(dialog.id) || this.checkingLastMessagesDialogs.indexOfKey(dialog.id) >= 0) {
            return;
        }
        TLRPC$TL_messages_getHistory tLRPC$TL_messages_getHistory = new TLRPC$TL_messages_getHistory();
        if (peer == null) {
            peer = getInputPeer(dialog.id);
        }
        tLRPC$TL_messages_getHistory.peer = peer;
        if (peer == null) {
            return;
        }
        tLRPC$TL_messages_getHistory.limit = 1;
        this.checkingLastMessagesDialogs.put(dialog.id, Boolean.TRUE);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("checkLastDialogMessage for " + dialog.id);
        }
        if (taskId == 0) {
            try {
                nativeByteBuffer = new NativeByteBuffer(tLRPC$TL_messages_getHistory.peer.getObjectSize() + 60);
            } catch (Exception e2) {
                nativeByteBuffer = null;
                e = e2;
            }
            try {
                nativeByteBuffer.writeInt32(14);
                nativeByteBuffer.writeInt64(dialog.id);
                nativeByteBuffer.writeInt32(dialog.top_message);
                nativeByteBuffer.writeInt32(dialog.read_inbox_max_id);
                nativeByteBuffer.writeInt32(dialog.read_outbox_max_id);
                nativeByteBuffer.writeInt32(dialog.unread_count);
                nativeByteBuffer.writeInt32(dialog.last_message_date);
                nativeByteBuffer.writeInt32(dialog.pts);
                nativeByteBuffer.writeInt32(dialog.flags);
                nativeByteBuffer.writeBool(dialog.pinned);
                nativeByteBuffer.writeInt32(dialog.pinnedNum);
                nativeByteBuffer.writeInt32(dialog.unread_mentions_count);
                nativeByteBuffer.writeBool(dialog.unread_mark);
                nativeByteBuffer.writeInt32(dialog.folder_id);
                tLRPC$TL_messages_getHistory.peer.serializeToStream(nativeByteBuffer);
            } catch (Exception e3) {
                e = e3;
                FileLog.e(e);
                taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getHistory, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$oBvQJHXxeJBCB5PEeoldqfOBu7A
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$checkLastDialogMessage$186$MessagesController(dialog, taskId, tLObject, tLRPC$TL_error);
                    }
                });
            }
            taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getHistory, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$oBvQJHXxeJBCB5PEeoldqfOBu7A
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkLastDialogMessage$186$MessagesController(dialog, taskId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkLastDialogMessage$186, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkLastDialogMessage$186$MessagesController(final TLRPC$Dialog tLRPC$Dialog, long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            removeDeletedMessagesFromArray(tLRPC$Dialog.id, tLRPC$messages_Messages.messages);
            if (!tLRPC$messages_Messages.messages.isEmpty()) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("checkLastDialogMessage for " + tLRPC$Dialog.id + " has message");
                }
                TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(0);
                TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
                tLRPC$TL_dialog.flags = tLRPC$Dialog.flags;
                tLRPC$TL_dialog.top_message = tLRPC$Message.id;
                tLRPC$TL_dialog.last_message_date = tLRPC$Message.date;
                tLRPC$TL_dialog.notify_settings = tLRPC$Dialog.notify_settings;
                tLRPC$TL_dialog.pts = tLRPC$Dialog.pts;
                tLRPC$TL_dialog.unread_count = tLRPC$Dialog.unread_count;
                tLRPC$TL_dialog.unread_mark = tLRPC$Dialog.unread_mark;
                tLRPC$TL_dialog.unread_mentions_count = tLRPC$Dialog.unread_mentions_count;
                tLRPC$TL_dialog.read_inbox_max_id = tLRPC$Dialog.read_inbox_max_id;
                tLRPC$TL_dialog.read_outbox_max_id = tLRPC$Dialog.read_outbox_max_id;
                tLRPC$TL_dialog.pinned = tLRPC$Dialog.pinned;
                tLRPC$TL_dialog.pinnedNum = tLRPC$Dialog.pinnedNum;
                tLRPC$TL_dialog.folder_id = tLRPC$Dialog.folder_id;
                long j2 = tLRPC$Dialog.id;
                tLRPC$TL_dialog.id = j2;
                tLRPC$Message.dialog_id = j2;
                tLRPC$TL_messages_dialogs.users.addAll(tLRPC$messages_Messages.users);
                tLRPC$TL_messages_dialogs.chats.addAll(tLRPC$messages_Messages.chats);
                tLRPC$TL_messages_dialogs.dialogs.add(tLRPC$TL_dialog);
                tLRPC$TL_messages_dialogs.messages.addAll(tLRPC$messages_Messages.messages);
                tLRPC$TL_messages_dialogs.count = 1;
                processDialogsUpdate(tLRPC$TL_messages_dialogs, null, false);
                getMessagesStorage().putMessages(tLRPC$messages_Messages.messages, true, true, false, getDownloadController().getAutodownloadMask(), true, false);
            } else {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$QRT3YN4x4T988PhhxeoPps3iHHQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkLastDialogMessage$184$MessagesController(tLRPC$Dialog);
                    }
                });
            }
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$3MdEvuDnzkx8CuvvWv50HKnmkWo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkLastDialogMessage$185$MessagesController(tLRPC$Dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkLastDialogMessage$184, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkLastDialogMessage$184$MessagesController(final TLRPC$Dialog tLRPC$Dialog) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("checkLastDialogMessage for " + tLRPC$Dialog.id + " has not message");
        }
        if (getMediaDataController().getDraft(tLRPC$Dialog.id, 0) == null) {
            TLRPC$Dialog tLRPC$Dialog2 = this.dialogs_dict.get(tLRPC$Dialog.id);
            if (tLRPC$Dialog2 == null) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("checkLastDialogMessage for " + tLRPC$Dialog.id + " current dialog not found");
                }
                getMessagesStorage().isDialogHasTopMessage(tLRPC$Dialog.id, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Fmjp0krepAv7jMZtjfubjS5bwpY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkLastDialogMessage$183$MessagesController(tLRPC$Dialog);
                    }
                });
                return;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("checkLastDialogMessage for " + tLRPC$Dialog.id + " current dialog top message " + tLRPC$Dialog2.top_message);
            }
            if (tLRPC$Dialog2.top_message == 0) {
                deleteDialog(tLRPC$Dialog.id, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkLastDialogMessage$183, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkLastDialogMessage$183$MessagesController(TLRPC$Dialog tLRPC$Dialog) {
        deleteDialog(tLRPC$Dialog.id, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkLastDialogMessage$185, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkLastDialogMessage$185$MessagesController(TLRPC$Dialog tLRPC$Dialog) {
        this.checkingLastMessagesDialogs.delete(tLRPC$Dialog.id);
    }

    public void processDialogsUpdate(final TLRPC$messages_Dialogs dialogsRes, ArrayList<TLRPC$EncryptedChat> encChats, final boolean fromCache) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$vK7Ei1JbAP2NwkMGOlzj3SXbCYg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDialogsUpdate$188$MessagesController(dialogsRes, fromCache);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* renamed from: lambda$processDialogsUpdate$188, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processDialogsUpdate$188$MessagesController(final ir.eitaa.tgnet.TLRPC$messages_Dialogs r19, final boolean r20) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$processDialogsUpdate$188$MessagesController(ir.eitaa.tgnet.TLRPC$messages_Dialogs, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:114:0x026e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025d  */
    /* renamed from: lambda$processDialogsUpdate$187, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processDialogsUpdate$187$MessagesController(ir.eitaa.tgnet.TLRPC$messages_Dialogs r19, androidx.collection.LongSparseArray r20, androidx.collection.LongSparseArray r21, boolean r22, ir.eitaa.messenger.support.LongSparseIntArray r23) {
        /*
            Method dump skipped, instructions count: 693
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$processDialogsUpdate$187$MessagesController(ir.eitaa.tgnet.TLRPC$messages_Dialogs, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, boolean, ir.eitaa.messenger.support.LongSparseIntArray):void");
    }

    public void addToViewsQueue(MessageObject message) {
        addToViewsQueue(message, 0);
    }

    public void addToViewsQueue(final MessageObject messageObject, final int flags) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$uBZKUuqYZTv3unual0Ym4YAGAvA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addToViewsQueue$189$MessagesController(messageObject, flags);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addToViewsQueue$189, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addToViewsQueue$189$MessagesController(MessageObject messageObject, int i) {
        long dialogId = messageObject.getDialogId();
        int id = messageObject.getId();
        ArrayList<Long> arrayList = this.channelViewsToSend.get(dialogId);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.channelViewsToSend.put(dialogId, arrayList);
        }
        if (arrayList.contains(Integer.valueOf(id))) {
            return;
        }
        arrayList.add(Long.valueOf(id + (i << 32)));
    }

    public void addToShopTileViewsQueue(final TLRPC$Message message, final int categoryId) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$m5gbmWWa3M8jWl_SBhsOXnbCmDQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addToShopTileViewsQueue$190$MessagesController(message, categoryId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000a A[PHI: r1
      0x000a: PHI (r1v5 long) = (r1v0 long), (r1v1 long) binds: [B:3:0x0008, B:7:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: lambda$addToShopTileViewsQueue$190, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$addToShopTileViewsQueue$190$MessagesController(ir.eitaa.tgnet.TLRPC$Message r7, int r8) {
        /*
            r6 = this;
            ir.eitaa.tgnet.TLRPC$Peer r0 = r7.peer_id
            long r1 = r0.channel_id
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Ld
        La:
            long r0 = -r1
        Lb:
            int r1 = (int) r0
            goto L17
        Ld:
            long r1 = r0.chat_id
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L14
            goto La
        L14:
            long r0 = r0.user_id
            goto Lb
        L17:
            ir.eitaa.tgnet.TLRPC$TL_Stat_ShopTile r0 = new ir.eitaa.tgnet.TLRPC$TL_Stat_ShopTile
            r0.<init>()
            long r1 = (long) r1
            ir.eitaa.tgnet.TLRPC$InputPeer r1 = r6.getInputPeer(r1)
            r0.peer = r1
            r0.categoryId = r8
            int r7 = r7.id
            r0.id = r7
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_Stat_ShopTile> r7 = r6.shopTileViewsToSend
            r7.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$addToShopTileViewsQueue$190$MessagesController(ir.eitaa.tgnet.TLRPC$Message, int):void");
    }

    public void addToAdViewsQueue(final int adId, final TLRPC$Ads_Location location) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$3eMzl_vh-lrY9bAHp4kchHiAlSE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addToAdViewsQueue$191$MessagesController(adId, location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addToAdViewsQueue$191, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addToAdViewsQueue$191$MessagesController(int i, TLRPC$Ads_Location tLRPC$Ads_Location) {
        TLRPC$TL_stat_ad tLRPC$TL_stat_ad = new TLRPC$TL_stat_ad();
        tLRPC$TL_stat_ad.id = i;
        tLRPC$TL_stat_ad.location = tLRPC$Ads_Location;
        this.adViewsToSend.add(tLRPC$TL_stat_ad);
    }

    public void addToAdActionsQueue(final int adId, final TLRPC$Ads_Location location) {
        if (ConnectionsManager.getInstance(this.currentAccount).getConnectionState() != 3) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$KAQ0IuQAoh7su5acRHzMG8d9csg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addToAdActionsQueue$192$MessagesController(adId, location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addToAdActionsQueue$192, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addToAdActionsQueue$192$MessagesController(int i, TLRPC$Ads_Location tLRPC$Ads_Location) {
        TLRPC$TL_stat_ad tLRPC$TL_stat_ad = new TLRPC$TL_stat_ad();
        tLRPC$TL_stat_ad.id = i;
        tLRPC$TL_stat_ad.location = tLRPC$Ads_Location;
        this.adActionsToSend.add(tLRPC$TL_stat_ad);
    }

    public void addToLivesQueue(long dialogId, ArrayList<MessageObject> visibleObjects) {
        SparseArray<MessageObject> sparseArray = this.livesToCheck.get(dialogId);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.livesToCheck.put(dialogId, sparseArray);
            this.livesToCheckSize++;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            sparseArray.valueAt(i).liveVisibleOnScreen = false;
        }
        int size2 = visibleObjects.size();
        for (int i2 = 0; i2 < size2; i2++) {
            MessageObject messageObject = visibleObjects.get(i2);
            if (messageObject.type == 72) {
                int id = messageObject.getId();
                MessageObject messageObject2 = sparseArray.get(id);
                if (messageObject2 != null) {
                    messageObject2.liveVisibleOnScreen = true;
                } else {
                    sparseArray.put(id, messageObject);
                }
            }
        }
    }

    public void addToPollsQueue(long dialogId, ArrayList<MessageObject> visibleObjects) {
        int i;
        SparseArray<MessageObject> sparseArray = this.pollsToCheck.get(dialogId);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.pollsToCheck.put(dialogId, sparseArray);
            this.pollsToCheckSize++;
        }
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.valueAt(i2).pollVisibleOnScreen = false;
        }
        int currentTime = getConnectionsManager().getCurrentTime();
        int size2 = visibleObjects.size();
        boolean z = false;
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        for (int i3 = 0; i3 < size2; i3++) {
            MessageObject messageObject = visibleObjects.get(i3);
            if (messageObject.type == 17) {
                TLRPC$Poll tLRPC$Poll = ((TLRPC$TL_messageMediaPoll) messageObject.messageOwner.media).poll;
                if (!tLRPC$Poll.closed && (i = tLRPC$Poll.close_date) != 0) {
                    if (i <= currentTime) {
                        z = true;
                    } else {
                        iMin = Math.min(iMin, i - currentTime);
                    }
                }
                int id = messageObject.getId();
                MessageObject messageObject2 = sparseArray.get(id);
                if (messageObject2 != null) {
                    messageObject2.pollVisibleOnScreen = true;
                } else {
                    sparseArray.put(id, messageObject);
                }
            }
        }
        if (z) {
            this.lastViewsCheckTime = 0L;
        } else if (iMin < 5) {
            this.lastViewsCheckTime = Math.min(this.lastViewsCheckTime, System.currentTimeMillis() - ((5 - iMin) * 1000));
        }
    }

    public void markMessageContentAsRead(MessageObject messageObject) {
        if (messageObject.scheduled) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (messageObject.messageOwner.mentioned) {
            getMessagesStorage().markMentionMessageAsRead(-messageObject.messageOwner.peer_id.channel_id, messageObject.getId(), messageObject.getDialogId());
        }
        arrayList.add(Integer.valueOf(messageObject.getId()));
        long dialogId = messageObject.getDialogId();
        getMessagesStorage().markMessagesContentAsRead(dialogId, arrayList, 0);
        getNotificationCenter().postNotificationName(NotificationCenter.messagesReadContent, Long.valueOf(dialogId), arrayList);
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
            tLRPC$TL_channels_readMessageContents.id.add(Integer.valueOf(messageObject.getId()));
            getConnectionsManager().sendRequest(tLRPC$TL_channels_readMessageContents, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$lBKy0_Tym8W_CWM4owuxbuQmRoQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$markMessageContentAsRead$193(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        TLRPC$TL_messages_readMessageContents tLRPC$TL_messages_readMessageContents = new TLRPC$TL_messages_readMessageContents();
        tLRPC$TL_messages_readMessageContents.id.add(Integer.valueOf(messageObject.getId()));
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readMessageContents, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$dEijpPqvxs_UJz9YaEr6uFUyh78
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$markMessageContentAsRead$194$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessageContentAsRead$194, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessageContentAsRead$194$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
        }
    }

    public void markMentionMessageAsRead(int mid, long channelId, long did) {
        getMessagesStorage().markMentionMessageAsRead(-channelId, mid, did);
        if (channelId != 0) {
            TLRPC$TL_channels_readMessageContents tLRPC$TL_channels_readMessageContents = new TLRPC$TL_channels_readMessageContents();
            TLRPC$InputChannel inputChannel = getInputChannel(channelId);
            tLRPC$TL_channels_readMessageContents.channel = inputChannel;
            if (inputChannel == null) {
                return;
            }
            tLRPC$TL_channels_readMessageContents.id.add(Integer.valueOf(mid));
            getConnectionsManager().sendRequest(tLRPC$TL_channels_readMessageContents, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$EXAJ-QeQlV7ae-15df5zxy7A3v0
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$markMentionMessageAsRead$195(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        TLRPC$TL_messages_readMessageContents tLRPC$TL_messages_readMessageContents = new TLRPC$TL_messages_readMessageContents();
        tLRPC$TL_messages_readMessageContents.id.add(Integer.valueOf(mid));
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readMessageContents, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$qsD4UTtIW24snynf0zoXtMbG3us
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$markMentionMessageAsRead$196$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMentionMessageAsRead$196, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMentionMessageAsRead$196$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void markMessageAsRead2(long r15, int r17, ir.eitaa.tgnet.TLRPC$InputChannel r18, int r19, long r20) {
        /*
            r14 = this;
            r1 = r14
            r10 = r17
            r8 = r19
            if (r10 == 0) goto Lb2
            if (r8 > 0) goto Lb
            goto Lb2
        Lb:
            boolean r0 = ir.eitaa.messenger.DialogObject.isChatDialog(r15)
            if (r0 == 0) goto L1c
            if (r18 != 0) goto L1c
            ir.eitaa.tgnet.TLRPC$InputChannel r0 = r14.getInputChannel(r15)
            if (r0 != 0) goto L1a
            return
        L1a:
            r11 = r0
            goto L1e
        L1c:
            r11 = r18
        L1e:
            r2 = 0
            int r0 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r0 != 0) goto L60
            r2 = 0
            ir.eitaa.tgnet.NativeByteBuffer r3 = new ir.eitaa.tgnet.NativeByteBuffer     // Catch: java.lang.Exception -> L50
            r0 = 20
            if (r11 == 0) goto L30
            int r4 = r11.getObjectSize()     // Catch: java.lang.Exception -> L50
            goto L31
        L30:
            r4 = 0
        L31:
            int r0 = r0 + r4
            r3.<init>(r0)     // Catch: java.lang.Exception -> L50
            r0 = 23
            r3.writeInt32(r0)     // Catch: java.lang.Exception -> L4c
            r4 = r15
            r3.writeInt64(r4)     // Catch: java.lang.Exception -> L4a
            r3.writeInt32(r10)     // Catch: java.lang.Exception -> L4a
            r3.writeInt32(r8)     // Catch: java.lang.Exception -> L4a
            if (r11 == 0) goto L56
            r11.serializeToStream(r3)     // Catch: java.lang.Exception -> L4a
            goto L56
        L4a:
            r0 = move-exception
            goto L4e
        L4c:
            r0 = move-exception
            r4 = r15
        L4e:
            r2 = r3
            goto L52
        L50:
            r0 = move-exception
            r4 = r15
        L52:
            ir.eitaa.messenger.FileLog.e(r0)
            r3 = r2
        L56:
            ir.eitaa.messenger.MessagesStorage r0 = r14.getMessagesStorage()
            long r2 = r0.createPendingTask(r3)
            r12 = r2
            goto L63
        L60:
            r4 = r15
            r12 = r20
        L63:
            ir.eitaa.tgnet.ConnectionsManager r0 = r14.getConnectionsManager()
            int r7 = r0.getCurrentTime()
            ir.eitaa.messenger.MessagesStorage r2 = r14.getMessagesStorage()
            r9 = 0
            r3 = r15
            r5 = r17
            r6 = r7
            r8 = r19
            r2.createTaskForMid(r3, r5, r6, r7, r8, r9)
            if (r11 == 0) goto L98
            ir.eitaa.tgnet.TLRPC$TL_channels_readMessageContents r0 = new ir.eitaa.tgnet.TLRPC$TL_channels_readMessageContents
            r0.<init>()
            r0.channel = r11
            java.util.ArrayList<java.lang.Integer> r2 = r0.id
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)
            r2.add(r3)
            ir.eitaa.tgnet.ConnectionsManager r2 = r14.getConnectionsManager()
            ir.eitaa.messenger.-$$Lambda$MessagesController$r-nOAFvHj2ro16bSfn-aeAC2u4s r3 = new ir.eitaa.messenger.-$$Lambda$MessagesController$r-nOAFvHj2ro16bSfn-aeAC2u4s
            r3.<init>()
            r2.sendRequest(r0, r3)
            goto Lb2
        L98:
            ir.eitaa.tgnet.TLRPC$TL_messages_readMessageContents r0 = new ir.eitaa.tgnet.TLRPC$TL_messages_readMessageContents
            r0.<init>()
            java.util.ArrayList<java.lang.Integer> r2 = r0.id
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)
            r2.add(r3)
            ir.eitaa.tgnet.ConnectionsManager r2 = r14.getConnectionsManager()
            ir.eitaa.messenger.-$$Lambda$MessagesController$AF0oxmV9Dpq-fHDXXpRRooSQB1E r3 = new ir.eitaa.messenger.-$$Lambda$MessagesController$AF0oxmV9Dpq-fHDXXpRRooSQB1E
            r3.<init>()
            r2.sendRequest(r0, r3)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.markMessageAsRead2(long, int, ir.eitaa.tgnet.TLRPC$InputChannel, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessageAsRead2$197, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessageAsRead2$197$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessageAsRead2$198, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessageAsRead2$198$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void markMessageAsRead(long dialogId, long randomId, int ttl) {
        TLRPC$EncryptedChat encryptedChat;
        if (randomId == 0 || dialogId == 0) {
            return;
        }
        if ((ttl > 0 || ttl == Integer.MIN_VALUE) && DialogObject.isEncryptedDialog(dialogId) && (encryptedChat = getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(dialogId)))) != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(randomId));
            getSecretChatHelper().sendMessagesReadMessage(encryptedChat, arrayList, null);
            if (ttl > 0) {
                int currentTime = getConnectionsManager().getCurrentTime();
                getMessagesStorage().createTaskForSecretChat(encryptedChat.id, currentTime, currentTime, 0, arrayList);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void completeReadTask(ReadTask readTask) {
        TLRPC$TL_messages_readHistory tLRPC$TL_messages_readHistory;
        if (readTask.replyId != 0) {
            TLRPC$TL_messages_readDiscussion tLRPC$TL_messages_readDiscussion = new TLRPC$TL_messages_readDiscussion();
            tLRPC$TL_messages_readDiscussion.msg_id = (int) readTask.replyId;
            tLRPC$TL_messages_readDiscussion.peer = getInputPeer(readTask.dialogId);
            tLRPC$TL_messages_readDiscussion.read_max_id = readTask.maxId;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_readDiscussion, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$4envWl1l1q1wAkzDwLkopakhmbU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$completeReadTask$199(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (!DialogObject.isEncryptedDialog(readTask.dialogId)) {
            TLRPC$InputPeer inputPeer = getInputPeer(readTask.dialogId);
            if (inputPeer instanceof TLRPC$TL_inputPeerChannel) {
                TLRPC$TL_channels_readHistory tLRPC$TL_channels_readHistory = new TLRPC$TL_channels_readHistory();
                tLRPC$TL_channels_readHistory.channel = getInputChannel(-readTask.dialogId);
                tLRPC$TL_channels_readHistory.max_id = readTask.maxId;
                tLRPC$TL_messages_readHistory = tLRPC$TL_channels_readHistory;
            } else {
                TLRPC$TL_messages_readHistory tLRPC$TL_messages_readHistory2 = new TLRPC$TL_messages_readHistory();
                tLRPC$TL_messages_readHistory2.peer = inputPeer;
                tLRPC$TL_messages_readHistory2.max_id = readTask.maxId;
                tLRPC$TL_messages_readHistory = tLRPC$TL_messages_readHistory2;
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_readHistory, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$SycELPXmCducTkPPuOTuFTHAYuw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$completeReadTask$200$MessagesController(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        TLRPC$EncryptedChat encryptedChat = getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(readTask.dialogId)));
        byte[] bArr = encryptedChat.auth_key;
        if (bArr == null || bArr.length <= 1 || !(encryptedChat instanceof TLRPC$TL_encryptedChat)) {
            return;
        }
        TLRPC$TL_messages_readEncryptedHistory tLRPC$TL_messages_readEncryptedHistory = new TLRPC$TL_messages_readEncryptedHistory();
        TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat = new TLRPC$TL_inputEncryptedChat();
        tLRPC$TL_messages_readEncryptedHistory.peer = tLRPC$TL_inputEncryptedChat;
        tLRPC$TL_inputEncryptedChat.chat_id = encryptedChat.id;
        tLRPC$TL_inputEncryptedChat.access_hash = encryptedChat.access_hash;
        tLRPC$TL_messages_readEncryptedHistory.max_date = readTask.maxDate;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readEncryptedHistory, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$3TchU_Y8Thm6xyF7_07ei2K2Gvc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$completeReadTask$201(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$completeReadTask$200, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$completeReadTask$200$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_messages_affectedMessages)) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
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
                this.threadsReadTasksMap.remove(readTask2.dialogId + "_" + readTask2.replyId);
                i += -1;
                size2 += -1;
            }
            i++;
        }
    }

    public void markDialogAsReadNow(final long dialogId, final int replyId) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$hL__vXTHtAqKfM2OLmH4MM990YQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markDialogAsReadNow$202$MessagesController(replyId, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markDialogAsReadNow$202, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markDialogAsReadNow$202$MessagesController(int i, long j) {
        if (i != 0) {
            String str = j + "_" + i;
            ReadTask readTask = this.threadsReadTasksMap.get(str);
            if (readTask == null) {
                return;
            }
            completeReadTask(readTask);
            this.repliesReadTasks.remove(readTask);
            this.threadsReadTasksMap.remove(str);
            return;
        }
        ReadTask readTask2 = this.readTasksMap.get(j);
        if (readTask2 == null) {
            return;
        }
        completeReadTask(readTask2);
        this.readTasks.remove(readTask2);
        this.readTasksMap.remove(j);
    }

    public void markMentionsAsRead(long dialogId) {
        if (DialogObject.isEncryptedDialog(dialogId)) {
            return;
        }
        getMessagesStorage().resetMentionsCount(dialogId, 0);
        TLRPC$TL_messages_readMentions tLRPC$TL_messages_readMentions = new TLRPC$TL_messages_readMentions();
        tLRPC$TL_messages_readMentions.peer = getInputPeer(dialogId);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readMentions, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$O_1MTiyijzq2OWBFLxmwTci8BYM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MessagesController.lambda$markMentionsAsRead$203(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void markDialogAsRead(final long r16, final int r18, final int r19, final int r20, final boolean r21, final int r22, final int r23, final boolean r24, int r25) {
        /*
            r15 = this;
            r8 = r15
            r9 = r18
            r10 = r20
            r7 = 2147483647(0x7fffffff, float:NaN)
            r11 = 1
            r12 = 0
            if (r22 == 0) goto L13
            if (r9 == r7) goto L10
            goto Lce
        L10:
            r11 = 0
            goto Lce
        L13:
            ir.eitaa.messenger.NotificationsController r0 = r15.getNotificationsController()
            boolean r0 = r0.showBadgeMessages
            boolean r0 = ir.eitaa.messenger.DialogObject.isEncryptedDialog(r16)
            if (r0 != 0) goto L75
            if (r9 != 0) goto L22
            return
        L22:
            j$.util.concurrent.ConcurrentHashMap<java.lang.Long, java.lang.Integer> r0 = r8.dialogs_read_inbox_max
            java.lang.Long r1 = java.lang.Long.valueOf(r16)
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 != 0) goto L34
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
        L34:
            j$.util.concurrent.ConcurrentHashMap<java.lang.Long, java.lang.Integer> r1 = r8.dialogs_read_inbox_max
            java.lang.Long r2 = java.lang.Long.valueOf(r16)
            int r0 = r0.intValue()
            int r0 = java.lang.Math.max(r0, r9)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.put(r2, r0)
            ir.eitaa.messenger.MessagesStorage r0 = r15.getMessagesStorage()
            r1 = r16
            r3 = r18
            r4 = r19
            r5 = r25
            r0.processPendingRead(r1, r3, r4, r5)
            ir.eitaa.messenger.MessagesStorage r0 = r15.getMessagesStorage()
            ir.eitaa.messenger.DispatchQueue r13 = r0.getStorageQueue()
            ir.eitaa.messenger.-$$Lambda$MessagesController$0go0NFGoLAMd1JvfmS_kRtzcYz8 r14 = new ir.eitaa.messenger.-$$Lambda$MessagesController$0go0NFGoLAMd1JvfmS_kRtzcYz8
            r0 = r14
            r1 = r15
            r2 = r16
            r4 = r23
            r5 = r18
            r6 = r21
            r0.<init>()
            r13.postRunnable(r14)
            if (r9 == r7) goto L10
            goto Lce
        L75:
            if (r10 != 0) goto L78
            return
        L78:
            int r0 = ir.eitaa.messenger.DialogObject.getEncryptedChatId(r16)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            ir.eitaa.tgnet.TLRPC$EncryptedChat r12 = r15.getEncryptedChat(r0)
            ir.eitaa.messenger.MessagesStorage r0 = r15.getMessagesStorage()
            r1 = r16
            r3 = r18
            r4 = r19
            r5 = r25
            r0.processPendingRead(r1, r3, r4, r5)
            ir.eitaa.messenger.MessagesStorage r0 = r15.getMessagesStorage()
            ir.eitaa.messenger.DispatchQueue r13 = r0.getStorageQueue()
            ir.eitaa.messenger.-$$Lambda$MessagesController$VsKwsqaiv938ymlm1xSu0DhNSc0 r14 = new ir.eitaa.messenger.-$$Lambda$MessagesController$VsKwsqaiv938ymlm1xSu0DhNSc0
            r0 = r14
            r1 = r15
            r2 = r16
            r4 = r20
            r5 = r21
            r6 = r23
            r7 = r19
            r0.<init>()
            r13.postRunnable(r14)
            if (r12 == 0) goto Lce
            int r0 = r12.ttl
            if (r0 <= 0) goto Lce
            ir.eitaa.tgnet.ConnectionsManager r0 = r15.getConnectionsManager()
            int r0 = r0.getCurrentTime()
            int r3 = java.lang.Math.max(r0, r10)
            ir.eitaa.messenger.MessagesStorage r0 = r15.getMessagesStorage()
            int r1 = r12.id
            r4 = 0
            r5 = 0
            r2 = r20
            r0.createTaskForSecretChat(r1, r2, r3, r4, r5)
        Lce:
            if (r11 == 0) goto Le6
            ir.eitaa.messenger.DispatchQueue r11 = ir.eitaa.messenger.Utilities.stageQueue
            ir.eitaa.messenger.-$$Lambda$MessagesController$OvOEjgKzKOO0TGHrPXXkUCBhVVg r12 = new ir.eitaa.messenger.-$$Lambda$MessagesController$OvOEjgKzKOO0TGHrPXXkUCBhVVg
            r0 = r12
            r1 = r15
            r2 = r22
            r3 = r16
            r5 = r24
            r6 = r20
            r7 = r18
            r0.<init>()
            r11.postRunnable(r12)
        Le6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.markDialogAsRead(long, int, int, int, boolean, int, int, boolean, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markDialogAsRead$205, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markDialogAsRead$205$MessagesController(final long j, final int i, final int i2, final boolean z) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$JT2DovTGIWGK6w83gd51edksR90
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markDialogAsRead$204$MessagesController(j, i, i2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markDialogAsRead$204, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markDialogAsRead$204$MessagesController(long j, int i, int i2, boolean z) {
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        if (tLRPC$Dialog != null) {
            int i3 = tLRPC$Dialog.unread_count;
            if (i == 0 || i2 >= tLRPC$Dialog.top_message) {
                tLRPC$Dialog.unread_count = 0;
            } else {
                int iMax = Math.max(i3 - i, 0);
                tLRPC$Dialog.unread_count = iMax;
                if (i2 != Integer.MIN_VALUE) {
                    int i4 = tLRPC$Dialog.top_message;
                    if (iMax > i4 - i2) {
                        tLRPC$Dialog.unread_count = i4 - i2;
                    }
                }
            }
            boolean z2 = tLRPC$Dialog.unread_mark;
            if (z2) {
                tLRPC$Dialog.unread_mark = false;
                getMessagesStorage().setDialogUnread(tLRPC$Dialog.id, false);
            }
            if ((i3 != 0 || z2) && tLRPC$Dialog.unread_count == 0) {
                if (!isDialogMuted(j)) {
                    this.unreadUnmutedDialogs--;
                }
                int i5 = 0;
                while (true) {
                    DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
                    if (i5 < dialogFilterArr.length) {
                        if (dialogFilterArr[i5] != null && (dialogFilterArr[i5].flags & DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0) {
                            sortDialogs(null);
                            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
                            break;
                        }
                        i5++;
                    } else {
                        break;
                    }
                }
            }
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_READ_DIALOG_MESSAGE));
        }
        if (!z) {
            getNotificationsController().processReadMessages(null, j, 0, i2, false);
            LongSparseIntArray longSparseIntArray = new LongSparseIntArray(1);
            longSparseIntArray.put(j, 0);
            getNotificationsController().processDialogsUpdateRead(longSparseIntArray);
            return;
        }
        getNotificationsController().processReadMessages(null, j, 0, i2, true);
        LongSparseIntArray longSparseIntArray2 = new LongSparseIntArray(1);
        longSparseIntArray2.put(j, -1);
        getNotificationsController().processDialogsUpdateRead(longSparseIntArray2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markDialogAsRead$207, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markDialogAsRead$207$MessagesController(final long j, final int i, final boolean z, final int i2, final int i3) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$41mVxdEkUfdryldCeBXkYubkUqY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markDialogAsRead$206$MessagesController(j, i, z, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markDialogAsRead$206, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markDialogAsRead$206$MessagesController(long j, int i, boolean z, int i2, int i3) {
        getNotificationsController().processReadMessages(null, j, i, 0, z);
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(j);
        if (tLRPC$Dialog != null) {
            int i4 = tLRPC$Dialog.unread_count;
            if (i2 == 0 || i3 <= tLRPC$Dialog.top_message) {
                tLRPC$Dialog.unread_count = 0;
            } else {
                int iMax = Math.max(i4 - i2, 0);
                tLRPC$Dialog.unread_count = iMax;
                if (i3 != Integer.MAX_VALUE) {
                    int i5 = tLRPC$Dialog.top_message;
                    if (iMax > i3 - i5) {
                        tLRPC$Dialog.unread_count = i3 - i5;
                    }
                }
            }
            boolean z2 = tLRPC$Dialog.unread_mark;
            if (z2) {
                tLRPC$Dialog.unread_mark = false;
                getMessagesStorage().setDialogUnread(tLRPC$Dialog.id, false);
            }
            if ((i4 != 0 || z2) && tLRPC$Dialog.unread_count == 0) {
                if (!isDialogMuted(j)) {
                    this.unreadUnmutedDialogs--;
                }
                int i6 = 0;
                while (true) {
                    DialogFilter[] dialogFilterArr = this.selectedDialogFilter;
                    if (i6 < dialogFilterArr.length) {
                        if (dialogFilterArr[i6] != null && (dialogFilterArr[i6].flags & DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0) {
                            sortDialogs(null);
                            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
                            break;
                        }
                        i6++;
                    } else {
                        break;
                    }
                }
            }
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_READ_DIALOG_MESSAGE));
        }
        LongSparseIntArray longSparseIntArray = new LongSparseIntArray(1);
        longSparseIntArray.put(j, 0);
        getNotificationsController().processDialogsUpdateRead(longSparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markDialogAsRead$208, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markDialogAsRead$208$MessagesController(int i, long j, boolean z, int i2, int i3) {
        ReadTask readTask;
        if (i != 0) {
            readTask = this.threadsReadTasksMap.get(j + "_" + i);
        } else {
            readTask = this.readTasksMap.get(j);
        }
        if (readTask == null) {
            readTask = new ReadTask();
            readTask.dialogId = j;
            readTask.replyId = i;
            readTask.sendRequestTime = SystemClock.elapsedRealtime() + 9000;
            if (!z) {
                if (i != 0) {
                    this.threadsReadTasksMap.put(j + "_" + i, readTask);
                    this.repliesReadTasks.add(readTask);
                } else {
                    this.readTasksMap.put(j, readTask);
                    this.readTasks.add(readTask);
                }
            }
        }
        readTask.maxDate = i2;
        readTask.maxId = i3;
        if (z) {
            completeReadTask(readTask);
        }
    }

    public int createChat(String title, ArrayList<Long> selectedContacts, String about, int type, boolean forImport, Location location, String locationAddress, final BaseFragment fragment) {
        if (type == 0 && !forImport) {
            final TLRPC$TL_messages_createChat tLRPC$TL_messages_createChat = new TLRPC$TL_messages_createChat();
            tLRPC$TL_messages_createChat.title = title;
            for (int i = 0; i < selectedContacts.size(); i++) {
                TLRPC$User user = getUser(selectedContacts.get(i));
                if (user != null) {
                    tLRPC$TL_messages_createChat.users.add(getInputUser(user));
                }
            }
            return getConnectionsManager().sendRequest(tLRPC$TL_messages_createChat, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$nK07oqcvG_clBKyrEfAJ4mE8wgU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createChat$211$MessagesController(fragment, tLRPC$TL_messages_createChat, tLObject, tLRPC$TL_error);
                }
            }, 2);
        }
        if (!forImport && type != 2 && type != 4) {
            return 0;
        }
        final TLRPC$TL_channels_createChannel tLRPC$TL_channels_createChannel = new TLRPC$TL_channels_createChannel();
        tLRPC$TL_channels_createChannel.title = title;
        if (about == null) {
            about = "";
        }
        tLRPC$TL_channels_createChannel.about = about;
        tLRPC$TL_channels_createChannel.for_import = forImport;
        if (forImport || type == 4) {
            tLRPC$TL_channels_createChannel.megagroup = true;
        } else {
            tLRPC$TL_channels_createChannel.broadcast = true;
        }
        if (location != null) {
            TLRPC$TL_inputGeoPoint tLRPC$TL_inputGeoPoint = new TLRPC$TL_inputGeoPoint();
            tLRPC$TL_channels_createChannel.geo_point = tLRPC$TL_inputGeoPoint;
            tLRPC$TL_inputGeoPoint.lat = location.getLatitude();
            tLRPC$TL_channels_createChannel.geo_point._long = location.getLongitude();
            tLRPC$TL_channels_createChannel.address = locationAddress;
            tLRPC$TL_channels_createChannel.flags |= 4;
        }
        return getConnectionsManager().sendRequest(tLRPC$TL_channels_createChannel, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$j9yDy3zguFRB95v0t3qTJTkY4VQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createChat$214$MessagesController(fragment, tLRPC$TL_channels_createChannel, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createChat$211, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createChat$211$MessagesController(final BaseFragment baseFragment, final TLRPC$TL_messages_createChat tLRPC$TL_messages_createChat, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$AJ2uxpc6-QYNrHdCCbogG7fg8gc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createChat$209$MessagesController(tLRPC$TL_error, baseFragment, tLRPC$TL_messages_createChat);
                }
            });
            return;
        }
        final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
        processUpdates(tLRPC$Updates, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$tu40LwLgjHzk_WPdsP7kEqiwD0s
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createChat$210$MessagesController(tLRPC$Updates);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createChat$209, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createChat$209$MessagesController(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_createChat tLRPC$TL_messages_createChat) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_createChat, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.chatDidFailCreate, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createChat$210, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createChat$210$MessagesController(TLRPC$Updates tLRPC$Updates) {
        putUsers(tLRPC$Updates.users, false);
        putChats(tLRPC$Updates.chats, false);
        ArrayList<TLRPC$Chat> arrayList = tLRPC$Updates.chats;
        if (arrayList != null && !arrayList.isEmpty()) {
            getNotificationCenter().postNotificationName(NotificationCenter.chatDidCreated, Long.valueOf(tLRPC$Updates.chats.get(0).id));
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.chatDidFailCreate, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createChat$214, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createChat$214$MessagesController(final BaseFragment baseFragment, final TLRPC$TL_channels_createChannel tLRPC$TL_channels_createChannel, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$g0FyELcAbNlG64AWHQ54Xc2dH9A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createChat$212$MessagesController(tLRPC$TL_error, baseFragment, tLRPC$TL_channels_createChannel);
                }
            });
            return;
        }
        final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
        processUpdates(tLRPC$Updates, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$jSCJKOo4FHmBBGfKh82cTXMk_pY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createChat$213$MessagesController(tLRPC$Updates);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createChat$212, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createChat$212$MessagesController(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_createChannel tLRPC$TL_channels_createChannel) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_createChannel, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.chatDidFailCreate, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createChat$213, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createChat$213$MessagesController(TLRPC$Updates tLRPC$Updates) {
        putUsers(tLRPC$Updates.users, false);
        putChats(tLRPC$Updates.chats, false);
        ArrayList<TLRPC$Chat> arrayList = tLRPC$Updates.chats;
        if (arrayList != null && !arrayList.isEmpty()) {
            getNotificationCenter().postNotificationName(NotificationCenter.chatDidCreated, Long.valueOf(tLRPC$Updates.chats.get(0).id));
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.chatDidFailCreate, new Object[0]);
        }
    }

    public void convertToMegaGroup(final Context context, long chatId, final BaseFragment fragment, final MessagesStorage.LongCallback convertRunnable) {
        final TLRPC$TL_messages_migrateChat tLRPC$TL_messages_migrateChat = new TLRPC$TL_messages_migrateChat();
        tLRPC$TL_messages_migrateChat.chat_id = chatId;
        AlertDialog alertDialog = context != null ? new AlertDialog(context, 3) : null;
        final AlertDialog alertDialog2 = alertDialog;
        final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_migrateChat, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$8ECPXbFAtNu09VgwCmThyXl2iFk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$convertToMegaGroup$218$MessagesController(context, alertDialog2, convertRunnable, fragment, tLRPC$TL_messages_migrateChat, tLObject, tLRPC$TL_error);
            }
        });
        if (alertDialog != null) {
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$RQmQZtRSDMMuWBhEp64bl66eN5w
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$convertToMegaGroup$219$MessagesController(iSendRequest, dialogInterface);
                }
            });
            try {
                alertDialog.show();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$convertToMegaGroup$218, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$convertToMegaGroup$218$MessagesController(final Context context, final AlertDialog alertDialog, final MessagesStorage.LongCallback longCallback, final BaseFragment baseFragment, final TLRPC$TL_messages_migrateChat tLRPC$TL_messages_migrateChat, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            if (context != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$U5oYpFOyxu7GjdHXqr1IW-xRmdc
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessagesController.lambda$convertToMegaGroup$215(context, alertDialog);
                    }
                });
            }
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            processUpdates(tLRPC$Updates, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$YjR7AVhcvja-Tb3gF2SdRBf6b3c
                @Override // java.lang.Runnable
                public final void run() {
                    MessagesController.lambda$convertToMegaGroup$216(longCallback, tLRPC$Updates);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$pWXlTsC9g3ygt6nFFYljJiHyHvI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$convertToMegaGroup$217$MessagesController(longCallback, context, alertDialog, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_migrateChat);
            }
        });
    }

    static /* synthetic */ void lambda$convertToMegaGroup$215(Context context, AlertDialog alertDialog) {
        if (((Activity) context).isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    static /* synthetic */ void lambda$convertToMegaGroup$216(MessagesStorage.LongCallback longCallback, TLRPC$Updates tLRPC$Updates) {
        if (longCallback != null) {
            for (int i = 0; i < tLRPC$Updates.chats.size(); i++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$Updates.chats.get(i);
                if (ChatObject.isChannel(tLRPC$Chat)) {
                    longCallback.run(tLRPC$Chat.id);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$convertToMegaGroup$217, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$convertToMegaGroup$217$MessagesController(MessagesStorage.LongCallback longCallback, Context context, AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_migrateChat tLRPC$TL_messages_migrateChat) {
        if (longCallback != null) {
            longCallback.run(0L);
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
    /* renamed from: lambda$convertToMegaGroup$219, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$convertToMegaGroup$219$MessagesController(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }

    public void convertToGigaGroup(final Context context, TLRPC$Chat chat, final BaseFragment fragment, final MessagesStorage.BooleanCallback convertRunnable) {
        final TLRPC$TL_channels_convertToGigagroup tLRPC$TL_channels_convertToGigagroup = new TLRPC$TL_channels_convertToGigagroup();
        tLRPC$TL_channels_convertToGigagroup.channel = getInputChannel(chat);
        AlertDialog alertDialog = context != null ? new AlertDialog(context, 3) : null;
        final AlertDialog alertDialog2 = alertDialog;
        final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_channels_convertToGigagroup, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$SR5zij6bUFwGpB01t9uT8M9JcDI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$convertToGigaGroup$223$MessagesController(context, alertDialog2, convertRunnable, fragment, tLRPC$TL_channels_convertToGigagroup, tLObject, tLRPC$TL_error);
            }
        });
        if (alertDialog != null) {
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$yInWJCJFP6NxagZ9zm2y0cdJeok
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$convertToGigaGroup$224$MessagesController(iSendRequest, dialogInterface);
                }
            });
            try {
                alertDialog.showDelayed(400L);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$convertToGigaGroup$223, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$convertToGigaGroup$223$MessagesController(final Context context, final AlertDialog alertDialog, final MessagesStorage.BooleanCallback booleanCallback, final BaseFragment baseFragment, final TLRPC$TL_channels_convertToGigagroup tLRPC$TL_channels_convertToGigagroup, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            if (context != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$F3dqGEGmOsS9cMaTf5JoueSmmjQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessagesController.lambda$convertToGigaGroup$220(context, alertDialog);
                    }
                });
            }
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$kDhIa2-OoRcAOMKuma_PeCpTWvA
                @Override // java.lang.Runnable
                public final void run() {
                    MessagesController.lambda$convertToGigaGroup$221(booleanCallback);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$LjqxEQMlYwolwShFsKsz3RbN_EY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$convertToGigaGroup$222$MessagesController(booleanCallback, context, alertDialog, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_convertToGigagroup);
            }
        });
    }

    static /* synthetic */ void lambda$convertToGigaGroup$220(Context context, AlertDialog alertDialog) {
        if (((Activity) context).isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    static /* synthetic */ void lambda$convertToGigaGroup$221(MessagesStorage.BooleanCallback booleanCallback) {
        if (booleanCallback != null) {
            booleanCallback.run(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$convertToGigaGroup$222, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$convertToGigaGroup$222$MessagesController(MessagesStorage.BooleanCallback booleanCallback, Context context, AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_convertToGigagroup tLRPC$TL_channels_convertToGigagroup) {
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
    /* renamed from: lambda$convertToGigaGroup$224, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$convertToGigaGroup$224$MessagesController(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }

    public void addUsersToChannel(long chatId, ArrayList<TLRPC$InputUser> users, final BaseFragment fragment) {
        if (users == null || users.isEmpty()) {
            return;
        }
        final TLRPC$TL_channels_inviteToChannel tLRPC$TL_channels_inviteToChannel = new TLRPC$TL_channels_inviteToChannel();
        tLRPC$TL_channels_inviteToChannel.channel = getInputChannel(chatId);
        tLRPC$TL_channels_inviteToChannel.users = users;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_inviteToChannel, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xE4fPnf6rvcmCAa5iYMGEkJNg2w
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$addUsersToChannel$226$MessagesController(fragment, tLRPC$TL_channels_inviteToChannel, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addUsersToChannel$225, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addUsersToChannel$225$MessagesController(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_channels_inviteToChannel tLRPC$TL_channels_inviteToChannel) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_channels_inviteToChannel, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addUsersToChannel$226, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addUsersToChannel$226$MessagesController(final BaseFragment baseFragment, final TLRPC$TL_channels_inviteToChannel tLRPC$TL_channels_inviteToChannel, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$OiIhV6K4x-geMLe-M7Q2zUJ1C40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUsersToChannel$225$MessagesController(tLRPC$TL_error, baseFragment, tLRPC$TL_channels_inviteToChannel);
                }
            });
        } else {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public void toogleChannelSignatures(long chatId, boolean enabled) {
        TLRPC$TL_channels_toggleSignatures tLRPC$TL_channels_toggleSignatures = new TLRPC$TL_channels_toggleSignatures();
        tLRPC$TL_channels_toggleSignatures.channel = getInputChannel(chatId);
        tLRPC$TL_channels_toggleSignatures.enabled = enabled;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_toggleSignatures, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$B8EpL2r1x9C0ytAwRuSiLUOcASk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toogleChannelSignatures$228$MessagesController(tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toogleChannelSignatures$228, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toogleChannelSignatures$228$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$E64ZHViL-SnyIR3WTEkCoTFWum4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$toogleChannelSignatures$227$MessagesController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toogleChannelSignatures$227, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toogleChannelSignatures$227$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_CHAT));
    }

    public void toggleChannelContentType(int chat_id, boolean isMedia) {
        TLRPC$TL_channels_toggleContentType tLRPC$TL_channels_toggleContentType = new TLRPC$TL_channels_toggleContentType();
        tLRPC$TL_channels_toggleContentType.channel = getInputChannel(chat_id);
        tLRPC$TL_channels_toggleContentType.isMedia = isMedia;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_toggleContentType, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$gVe9kGenhTbv1X0Ix-89-kIkFlQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toggleChannelContentType$229$MessagesController(tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleChannelContentType$229, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleChannelContentType$229$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MessagesController.4
                @Override // java.lang.Runnable
                public void run() {
                    NotificationCenter.getInstance(MessagesController.this.currentAccount).postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_CHAT));
                }
            });
        } else if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MessagesController.5
                @Override // java.lang.Runnable
                public void run() {
                    NotificationCenter.getInstance(MessagesController.this.currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("FloodWait", R.string.FloodWait));
                }
            });
        }
    }

    public void toogleChannelInvitesHistory(long chatId, boolean enabled) {
        TLRPC$TL_channels_togglePreHistoryHidden tLRPC$TL_channels_togglePreHistoryHidden = new TLRPC$TL_channels_togglePreHistoryHidden();
        tLRPC$TL_channels_togglePreHistoryHidden.channel = getInputChannel(chatId);
        tLRPC$TL_channels_togglePreHistoryHidden.enabled = enabled;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_togglePreHistoryHidden, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$n5c0rJG7jDHB-FQlGcNrGiYWnG0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toogleChannelInvitesHistory$231$MessagesController(tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toogleChannelInvitesHistory$231, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toogleChannelInvitesHistory$231$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$DgMZX2_5rIgnuZpeKODFHMxJDAw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$toogleChannelInvitesHistory$230$MessagesController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toogleChannelInvitesHistory$230, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toogleChannelInvitesHistory$230$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_CHAT));
    }

    public void updateChatAbout(long chatId, final String about, final TLRPC$ChatFull info) {
        TLRPC$TL_messages_editChatAbout tLRPC$TL_messages_editChatAbout = new TLRPC$TL_messages_editChatAbout();
        tLRPC$TL_messages_editChatAbout.peer = getInputPeer(-chatId);
        tLRPC$TL_messages_editChatAbout.about = about;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatAbout, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$F3U4xH4L_PECrVOdF5oF7HYYOjE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$updateChatAbout$233$MessagesController(info, about, tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChatAbout$233, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatAbout$233$MessagesController(final TLRPC$ChatFull tLRPC$ChatFull, final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (!(tLObject instanceof TLRPC$TL_boolTrue) || tLRPC$ChatFull == null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$XBg1v58e15Nc7hycNkjQdMCiJPE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatAbout$232$MessagesController(tLRPC$ChatFull, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChatAbout$232, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatAbout$232$MessagesController(TLRPC$ChatFull tLRPC$ChatFull, String str) {
        tLRPC$ChatFull.about = str;
        getMessagesStorage().updateChatInfo(tLRPC$ChatFull, false);
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.chatInfoDidLoad;
        Boolean bool = Boolean.FALSE;
        notificationCenter.postNotificationName(i, tLRPC$ChatFull, 0, bool, bool);
    }

    public void updateChannelUserName(final long chatId, final String userName) {
        TLRPC$TL_channels_updateUsername tLRPC$TL_channels_updateUsername = new TLRPC$TL_channels_updateUsername();
        tLRPC$TL_channels_updateUsername.channel = getInputChannel(chatId);
        tLRPC$TL_channels_updateUsername.username = userName;
        getConnectionsManager().sendRequest(tLRPC$TL_channels_updateUsername, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$sRKu2v3NmDX7Kz9XEoWN5-IEyuw
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$updateChannelUserName$235$MessagesController(chatId, userName, tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChannelUserName$235, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChannelUserName$235$MessagesController(final long j, final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$42O1JS7VqTAQRALxdhsCEVBaSK4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateChannelUserName$234$MessagesController(j, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChannelUserName$234, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChannelUserName$234$MessagesController(long j, String str) {
        TLRPC$Chat chat = getChat(Long.valueOf(j));
        if (str.length() != 0) {
            chat.flags |= 64;
        } else {
            chat.flags &= -65;
        }
        chat.username = str;
        ArrayList<TLRPC$Chat> arrayList = new ArrayList<>();
        arrayList.add(chat);
        getMessagesStorage().putUsersAndChats(null, arrayList, true, true);
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_CHAT));
    }

    public void sendBotStart(final TLRPC$User user, String botHash) {
        if (user == null) {
            return;
        }
        TLRPC$TL_messages_startBot tLRPC$TL_messages_startBot = new TLRPC$TL_messages_startBot();
        tLRPC$TL_messages_startBot.bot = getInputUser(user);
        tLRPC$TL_messages_startBot.peer = getInputPeer(user.id);
        tLRPC$TL_messages_startBot.start_param = botHash;
        tLRPC$TL_messages_startBot.random_id = Utilities.random.nextLong();
        getConnectionsManager().sendRequest(tLRPC$TL_messages_startBot, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$PH8__VNNS7uDY0nvBYj3qCN92D0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendBotStart$236$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendBotStart$236, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendBotStart$236$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        processUpdates((TLRPC$Updates) tLObject, false);
    }

    public boolean isJoiningChannel(long chatId) {
        return this.joiningToChannels.contains(Long.valueOf(chatId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addUserToChat(final long j, TLRPC$User tLRPC$User, int i, String str, final BaseFragment baseFragment, final Runnable runnable) {
        TLRPC$TL_messages_addChatUser tLRPC$TL_messages_addChatUser;
        if (tLRPC$User == null) {
            return;
        }
        final boolean zIsChannel = ChatObject.isChannel(j, this.currentAccount);
        final boolean z = zIsChannel && getChat(Long.valueOf(j)).megagroup;
        final TLRPC$InputUser inputUser = getInputUser(tLRPC$User);
        if (str != null && (!zIsChannel || z)) {
            TLRPC$TL_messages_startBot tLRPC$TL_messages_startBot = new TLRPC$TL_messages_startBot();
            tLRPC$TL_messages_startBot.bot = inputUser;
            if (zIsChannel) {
                tLRPC$TL_messages_startBot.peer = getInputPeer(-j);
            } else {
                TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
                tLRPC$TL_messages_startBot.peer = tLRPC$TL_inputPeerChat;
                tLRPC$TL_inputPeerChat.chat_id = j;
            }
            tLRPC$TL_messages_startBot.start_param = str;
            tLRPC$TL_messages_startBot.random_id = Utilities.random.nextLong();
            tLRPC$TL_messages_addChatUser = tLRPC$TL_messages_startBot;
        } else if (zIsChannel) {
            if (inputUser instanceof TLRPC$TL_inputUserSelf) {
                if (this.joiningToChannels.contains(Long.valueOf(j))) {
                    return;
                }
                TLRPC$TL_channels_joinChannel tLRPC$TL_channels_joinChannel = new TLRPC$TL_channels_joinChannel();
                tLRPC$TL_channels_joinChannel.channel = getInputChannel(j);
                this.joiningToChannels.add(Long.valueOf(j));
                tLRPC$TL_messages_addChatUser = tLRPC$TL_channels_joinChannel;
            } else {
                TLRPC$TL_channels_inviteToChannel tLRPC$TL_channels_inviteToChannel = new TLRPC$TL_channels_inviteToChannel();
                tLRPC$TL_channels_inviteToChannel.channel = getInputChannel(j);
                tLRPC$TL_channels_inviteToChannel.users.add(inputUser);
                tLRPC$TL_messages_addChatUser = tLRPC$TL_channels_inviteToChannel;
            }
        } else {
            TLRPC$TL_messages_addChatUser tLRPC$TL_messages_addChatUser2 = new TLRPC$TL_messages_addChatUser();
            tLRPC$TL_messages_addChatUser2.chat_id = j;
            tLRPC$TL_messages_addChatUser2.fwd_limit = i;
            tLRPC$TL_messages_addChatUser2.user_id = inputUser;
            tLRPC$TL_messages_addChatUser = tLRPC$TL_messages_addChatUser2;
        }
        final TLRPC$TL_messages_addChatUser tLRPC$TL_messages_addChatUser3 = tLRPC$TL_messages_addChatUser;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_addChatUser3, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$H1cJuOfLcSrEsau5XbzpBAcSldM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$addUserToChat$240$MessagesController(zIsChannel, inputUser, j, baseFragment, tLRPC$TL_messages_addChatUser3, z, runnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addUserToChat$240, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addUserToChat$240$MessagesController(final boolean z, final TLRPC$InputUser tLRPC$InputUser, final long j, final BaseFragment baseFragment, final TLObject tLObject, final boolean z2, Runnable runnable, TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        boolean z3;
        if (z && (tLRPC$InputUser instanceof TLRPC$TL_inputUserSelf)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$9TLJTmA2V2043QhUQ5bj2plfSy8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUserToChat$237$MessagesController(j);
                }
            });
        }
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$nq5icqqA83rZwCe1jZChlsLyjmQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUserToChat$238$MessagesController(tLRPC$TL_error, baseFragment, tLObject, z, z2, tLRPC$InputUser);
                }
            });
            return;
        }
        TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject2;
        int i = 0;
        while (true) {
            if (i >= tLRPC$Updates.updates.size()) {
                z3 = false;
                break;
            }
            TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
            if ((tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) && (((TLRPC$TL_updateNewChannelMessage) tLRPC$Update).message.action instanceof TLRPC$TL_messageActionChatAddUser)) {
                z3 = true;
                break;
            }
            i++;
        }
        processUpdates(tLRPC$Updates, false);
        if (z) {
            if (!z3 && (tLRPC$InputUser instanceof TLRPC$TL_inputUserSelf)) {
                generateJoinMessage(j, true);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$5J3JUGEaXRs6p9tPqAFcVKWNqVk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addUserToChat$239$MessagesController(j);
                }
            }, 1000L);
        }
        if (z && (tLRPC$InputUser instanceof TLRPC$TL_inputUserSelf)) {
            getMessagesStorage().updateDialogsWithDeletedMessages(-j, j, new ArrayList<>(), null, true);
        }
        if (runnable != null) {
            AndroidUtilities.runOnUIThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addUserToChat$237, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addUserToChat$237$MessagesController(long j) {
        this.joiningToChannels.remove(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addUserToChat$238, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addUserToChat$238$MessagesController(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLObject tLObject, boolean z, boolean z2, TLRPC$InputUser tLRPC$InputUser) {
        int i = this.currentAccount;
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(z && !z2);
        AlertsCreator.processError(i, tLRPC$TL_error, baseFragment, tLObject, objArr);
        if (z && (tLRPC$InputUser instanceof TLRPC$TL_inputUserSelf)) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_CHAT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addUserToChat$239, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addUserToChat$239$MessagesController(long j) {
        loadFullChat(j, 0, true);
    }

    public void deleteParticipantFromChat(long chatId, TLRPC$User user, TLRPC$ChatFull info) {
        deleteParticipantFromChat(chatId, user, null, info, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void deleteParticipantFromChat(final long j, final TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, TLRPC$ChatFull tLRPC$ChatFull, boolean z, boolean z2) {
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
        TLRPC$Chat chat = getChat(Long.valueOf(j));
        final boolean zIsChannel = ChatObject.isChannel(chat);
        if (zIsChannel) {
            if (UserObject.isUserSelf(tLRPC$User)) {
                if (chat.creator) {
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
        } else if (chat.creator) {
            TLRPC$TL_messages_deleteChat tLRPC$TL_messages_deleteChat = new TLRPC$TL_messages_deleteChat();
            tLRPC$TL_messages_deleteChat.chat_id = j;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_deleteChat, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$DYB9hJSIiiPI6QJYviiu4EeahX4
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$deleteParticipantFromChat$241(tLObject, tLRPC$TL_error);
                }
            });
            return;
        } else {
            TLRPC$TL_messages_deleteChatUser tLRPC$TL_messages_deleteChatUser2 = new TLRPC$TL_messages_deleteChatUser();
            tLRPC$TL_messages_deleteChatUser2.chat_id = j;
            tLRPC$TL_messages_deleteChatUser2.user_id = getInputUser(tLRPC$User);
            tLRPC$TL_messages_deleteChatUser2.revoke_history = true;
            tLRPC$TL_messages_deleteChatUser = tLRPC$TL_messages_deleteChatUser2;
        }
        if (UserObject.isUserSelf(tLRPC$User)) {
            deleteDialog(-j, 0, z2);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_deleteChatUser, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$sS2yr_77AobfrjuTZ7lIwGc8axo
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteParticipantFromChat$243$MessagesController(zIsChannel, tLRPC$User, j, tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteParticipantFromChat$243, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteParticipantFromChat$243$MessagesController(boolean z, TLRPC$User tLRPC$User, final long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MessagesController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        NotificationCenter.getInstance(MessagesController.this.currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("FloodWait", R.string.FloodWait));
                    }
                });
            }
        } else {
            processUpdates((TLRPC$Updates) tLObject, false);
            if (!z || UserObject.isUserSelf(tLRPC$User)) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$At5bbAlVseDb5uHM4DR-h7Th4Zw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deleteParticipantFromChat$242$MessagesController(j);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteParticipantFromChat$242, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteParticipantFromChat$242$MessagesController(long j) {
        loadFullChat(j, 0, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void changeChatTitle(long j, String str) {
        TLRPC$TL_messages_editChatTitle tLRPC$TL_messages_editChatTitle;
        if (ChatObject.isChannel(j, this.currentAccount)) {
            TLRPC$TL_channels_editTitle tLRPC$TL_channels_editTitle = new TLRPC$TL_channels_editTitle();
            tLRPC$TL_channels_editTitle.channel = getInputChannel(j);
            tLRPC$TL_channels_editTitle.title = str;
            tLRPC$TL_messages_editChatTitle = tLRPC$TL_channels_editTitle;
        } else {
            TLRPC$TL_messages_editChatTitle tLRPC$TL_messages_editChatTitle2 = new TLRPC$TL_messages_editChatTitle();
            tLRPC$TL_messages_editChatTitle2.chat_id = j;
            tLRPC$TL_messages_editChatTitle2.title = str;
            tLRPC$TL_messages_editChatTitle = tLRPC$TL_messages_editChatTitle2;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatTitle, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$4e7zW_yj4rEl1BFAhDtkNUQVPqk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$changeChatTitle$244$MessagesController(tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$changeChatTitle$244, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$changeChatTitle$244$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        processUpdates((TLRPC$Updates) tLObject, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void changeChatAvatar(long j, final TLRPC$TL_inputChatPhoto tLRPC$TL_inputChatPhoto, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, double d, final String str, final TLRPC$FileLocation tLRPC$FileLocation, final TLRPC$FileLocation tLRPC$FileLocation2, final Runnable runnable) {
        MessagesController messagesController;
        TLRPC$InputChatPhoto tLRPC$InputChatPhoto;
        TLRPC$TL_messages_editChatPhoto tLRPC$TL_messages_editChatPhoto;
        if (tLRPC$TL_inputChatPhoto != null) {
            messagesController = this;
            tLRPC$InputChatPhoto = tLRPC$TL_inputChatPhoto;
        } else if (tLRPC$InputFile != null || tLRPC$InputFile2 != null) {
            TLRPC$TL_inputChatUploadedPhoto tLRPC$TL_inputChatUploadedPhoto = new TLRPC$TL_inputChatUploadedPhoto();
            if (tLRPC$InputFile != null) {
                tLRPC$TL_inputChatUploadedPhoto.file = tLRPC$InputFile;
                tLRPC$TL_inputChatUploadedPhoto.flags |= 1;
            }
            if (tLRPC$InputFile2 != null) {
                tLRPC$TL_inputChatUploadedPhoto.video = tLRPC$InputFile2;
                int i = tLRPC$TL_inputChatUploadedPhoto.flags | 2;
                tLRPC$TL_inputChatUploadedPhoto.flags = i;
                tLRPC$TL_inputChatUploadedPhoto.video_start_ts = d;
                tLRPC$TL_inputChatUploadedPhoto.flags = i | 4;
            }
            messagesController = this;
            tLRPC$InputChatPhoto = tLRPC$TL_inputChatUploadedPhoto;
        } else {
            tLRPC$InputChatPhoto = new TLRPC$InputChatPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputChatPhotoEmpty
                public static int constructor = 480546647;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            };
            messagesController = this;
        }
        if (ChatObject.isChannel(j, messagesController.currentAccount)) {
            TLRPC$TL_channels_editPhoto tLRPC$TL_channels_editPhoto = new TLRPC$TL_channels_editPhoto();
            tLRPC$TL_channels_editPhoto.channel = getInputChannel(j);
            tLRPC$TL_channels_editPhoto.photo = tLRPC$InputChatPhoto;
            tLRPC$TL_messages_editChatPhoto = tLRPC$TL_channels_editPhoto;
        } else {
            TLRPC$TL_messages_editChatPhoto tLRPC$TL_messages_editChatPhoto2 = new TLRPC$TL_messages_editChatPhoto();
            tLRPC$TL_messages_editChatPhoto2.chat_id = j;
            tLRPC$TL_messages_editChatPhoto2.photo = tLRPC$InputChatPhoto;
            tLRPC$TL_messages_editChatPhoto = tLRPC$TL_messages_editChatPhoto2;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editChatPhoto, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$5_UmyP4erZ_zJeEpg897cjocFvY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$changeChatAvatar$246$MessagesController(tLRPC$TL_inputChatPhoto, tLRPC$FileLocation, tLRPC$FileLocation2, str, runnable, tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$changeChatAvatar$246, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$changeChatAvatar$246$MessagesController(TLRPC$TL_inputChatPhoto tLRPC$TL_inputChatPhoto, TLRPC$FileLocation tLRPC$FileLocation, TLRPC$FileLocation tLRPC$FileLocation2, String str, final Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, 800);
                if (closestPhotoSizeWithSize2 != null && tLRPC$FileLocation2 != null) {
                    FileLoader.getPathToAttach(tLRPC$FileLocation2, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize2, true));
                }
                if (tLRPC$VideoSize != null && str != null) {
                    new File(str).renameTo(FileLoader.getPathToAttach(tLRPC$VideoSize, "mp4", true));
                }
            }
        }
        processUpdates(tLRPC$Updates, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xcW-N1QcL8AnUKxNyeZJlmRlfAk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$changeChatAvatar$245$MessagesController(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$changeChatAvatar$245, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$changeChatAvatar$245$MessagesController(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_AVATAR));
    }

    public void unregistedPush() {
        if (getUserConfig().registeredForPush && SharedConfig.pushString.length() == 0) {
            TLRPC$TL_account_unregisterDevice tLRPC$TL_account_unregisterDevice = new TLRPC$TL_account_unregisterDevice();
            tLRPC$TL_account_unregisterDevice.token = SharedConfig.pushString;
            tLRPC$TL_account_unregisterDevice.token_type = 2;
            for (int i = 0; i < 3; i++) {
                UserConfig userConfig = UserConfig.getInstance(i);
                if (i != this.currentAccount && userConfig.isClientActivated()) {
                    tLRPC$TL_account_unregisterDevice.other_uids.add(Long.valueOf(userConfig.getClientUserId()));
                }
            }
            getConnectionsManager().sendRequest(tLRPC$TL_account_unregisterDevice, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$7mNcmCRdt_VOXRR6oRjTj5Wy20c
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MessagesController.lambda$unregistedPush$247(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    public void performLogout(int type) throws InterruptedException {
        unlockAllDialogs();
        boolean z = true;
        if (type == 1) {
            unregistedPush();
            getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_logOut
                public static int constructor = 1461180992;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Xp1nib5_abIJsZPg-G_L7ABgASQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$performLogout$248$MessagesController(tLObject, tLRPC$TL_error);
                }
            });
        } else {
            getConnectionsManager().cleanup(type == 2);
        }
        getUserConfig().clearConfig();
        ArrayList<NotificationCenter.NotificationCenterDelegate> observers = getNotificationCenter().getObservers(NotificationCenter.appDidLogout);
        if (observers != null) {
            int size = observers.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (observers.get(i) instanceof LaunchActivity) {
                    z = false;
                    break;
                }
                i++;
            }
        }
        if (z && UserConfig.selectedAccount == this.currentAccount) {
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    i2 = -1;
                    break;
                } else if (UserConfig.getInstance(i2).isClientActivated()) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                UserConfig.selectedAccount = i2;
                UserConfig.getInstance(0).saveConfig(false);
                LaunchActivity.clearFragments();
            }
        }
        getNotificationCenter().postNotificationName(NotificationCenter.appDidLogout, new Object[0]);
        getMessagesStorage().cleanup(false);
        cleanup();
        getContactsController().deleteUnknownAppAccounts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performLogout$248, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performLogout$248$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        getConnectionsManager().cleanup(false);
    }

    public void restartAllActions() throws InterruptedException {
        getContactsController().cleanup();
        MediaController.getInstance().cleanup();
        getSendMessagesHelper().cleanup();
        getSecretChatHelper().cleanup();
        getLocationController().cleanup();
        getMediaDataController().cleanup();
        this.showFiltersTooltip = false;
        DialogsActivity.dialogsLoaded[this.currentAccount] = false;
        this.lastScheduledServerQueryTime.clear();
        this.lastServerQueryTime.clear();
        this.reloadingWebpages.clear();
        this.reloadingWebpagesPending.clear();
        this.reloadingScheduledWebpages.clear();
        this.reloadingScheduledWebpagesPending.clear();
        this.sponsoredMessages.clear();
        this.dialogs_dict.clear();
        this.dialogs_read_inbox_max.clear();
        this.loadingPinnedDialogs.clear();
        this.dialogs_read_outbox_max.clear();
        this.exportedChats.clear();
        this.fullUsers.clear();
        this.fullChats.clear();
        this.activeVoiceChatsMap.clear();
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
        this.loadingPeerSettings.clear();
        this.deletingDialogs.clear();
        this.clearingHistoryDialogs.clear();
        this.lastPrintingStringCount = 0;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Y7ITi8HXoPer39Ps2X53i4SEnhs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$restartAllActions$249$MessagesController();
            }
        });
        this.createdDialogMainThreadIds.clear();
        this.visibleDialogMainThreadIds.clear();
        this.visibleScheduledDialogMainThreadIds.clear();
        this.blockePeers.clear();
        int i = 0;
        while (true) {
            LongSparseArray<SparseArray<Boolean>>[] longSparseArrayArr = this.sendingTypings;
            if (i >= longSparseArrayArr.length) {
                break;
            }
            if (longSparseArrayArr[i] != null) {
                longSparseArrayArr[i].clear();
            }
            i++;
        }
        this.loadingFullUsers.clear();
        this.loadedFullUsers.clear();
        this.reloadingMessages.clear();
        this.loadingFullChats.clear();
        this.loadingFullParticipants.clear();
        this.loadedFullParticipants.clear();
        this.loadedFullChats.clear();
        this.checkingDialogAd = false;
        this.nextDialogAdCheckTime = 0;
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
        this.currentDeletingTaskMediaMids = null;
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
        this.livesToCheck.clear();
        this.livesToCheckSize = 0;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$P_LiZ7rIoq9inXqgXWyqZEpJ8Uo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$restartAllActions$250$MessagesController();
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
        getConnectionsManager().cleanup(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$restartAllActions$249, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$restartAllActions$249$MessagesController() {
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
    /* renamed from: lambda$restartAllActions$250, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$restartAllActions$250$MessagesController() {
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

    public void generateUpdateMessage() {
        String str;
        if (this.gettingAppChangelog || BuildVars.DEBUG_VERSION || (str = SharedConfig.lastUpdateVersion) == null || str.equals(BuildVars.BUILD_VERSION_STRING)) {
            return;
        }
        this.gettingAppChangelog = true;
        TLRPC$TL_help_getAppChangelog tLRPC$TL_help_getAppChangelog = new TLRPC$TL_help_getAppChangelog();
        tLRPC$TL_help_getAppChangelog.prev_app_version = SharedConfig.lastUpdateVersion;
        getConnectionsManager().sendRequest(tLRPC$TL_help_getAppChangelog, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$xtu5vXYrEcQGGaP7WmEUFUCpqx8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$generateUpdateMessage$251$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateUpdateMessage$251, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateUpdateMessage$251$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            SharedConfig.lastUpdateVersion = BuildVars.BUILD_VERSION_STRING;
            SharedConfig.saveConfig();
        }
        if (tLObject instanceof TLRPC$Updates) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public void registerForPush(final String regid) {
        if (TextUtils.isEmpty(regid) || this.registeringForPush || getUserConfig().getClientUserId() == 0) {
            return;
        }
        if (getUserConfig().registeredForPush && regid.equals(SharedConfig.pushString)) {
            return;
        }
        this.registeringForPush = true;
        this.lastPushRegisterSendTime = SystemClock.elapsedRealtime();
        if (SharedConfig.pushAuthKey == null) {
            SharedConfig.pushAuthKey = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            Utilities.random.nextBytes(SharedConfig.pushAuthKey);
            SharedConfig.saveConfig();
        }
        TLRPC$TL_account_registerDevice tLRPC$TL_account_registerDevice = new TLRPC$TL_account_registerDevice();
        tLRPC$TL_account_registerDevice.token_type = 2;
        tLRPC$TL_account_registerDevice.token = regid;
        tLRPC$TL_account_registerDevice.no_muted = false;
        tLRPC$TL_account_registerDevice.secret = SharedConfig.pushAuthKey;
        for (int i = 0; i < 3; i++) {
            UserConfig userConfig = UserConfig.getInstance(i);
            if (i != this.currentAccount && userConfig.isClientActivated()) {
                long clientUserId = userConfig.getClientUserId();
                tLRPC$TL_account_registerDevice.other_uids.add(Long.valueOf(clientUserId));
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("add other uid = " + clientUserId + " for account " + this.currentAccount);
                }
            }
        }
        getConnectionsManager().sendRequest(tLRPC$TL_account_registerDevice, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$zBIHDr8_mW5-MaBy0GKVH4Gkk78
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$registerForPush$253$MessagesController(regid, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$registerForPush$253, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$registerForPush$253$MessagesController(String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("account " + this.currentAccount + " registered for push");
            }
            getUserConfig().registeredForPush = true;
            SharedConfig.pushString = str;
            getUserConfig().saveConfig(false);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$STgzjY6Ajrr-Q-sefzqUpvzy_RY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$registerForPush$252$MessagesController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$registerForPush$252, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$registerForPush$252$MessagesController() {
        this.registeringForPush = false;
    }

    public void loadCurrentState() {
        if (this.updatingState) {
            return;
        }
        this.updatingState = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_updates_getState
            public static int constructor = -304838614;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$TL_updates_state.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$3km81lBxxKiI53oGr_qU2XCVOFk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadCurrentState$254$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadCurrentState$254, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadCurrentState$254$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

    private int getUpdateSeq(TLRPC$Updates updates) {
        if (updates instanceof TLRPC$TL_updatesCombined) {
            return updates.seq_start;
        }
        return updates.seq;
    }

    private void setUpdatesStartTime(int type, long time) {
        if (type == 0) {
            this.updatesStartWaitTimeSeq = time;
        } else if (type == 1) {
            this.updatesStartWaitTimePts = time;
        } else if (type == 2) {
            this.updatesStartWaitTimeQts = time;
        }
    }

    public long getUpdatesStartTime(int type) {
        if (type == 0) {
            return this.updatesStartWaitTimeSeq;
        }
        if (type == 1) {
            return this.updatesStartWaitTimePts;
        }
        if (type == 2) {
            return this.updatesStartWaitTimeQts;
        }
        return 0L;
    }

    private int isValidUpdate(TLRPC$Updates updates, int type) {
        if (type == 0) {
            int updateSeq = getUpdateSeq(updates);
            if (getMessagesStorage().getLastSeqValue() + 1 == updateSeq || getMessagesStorage().getLastSeqValue() == updateSeq) {
                return 0;
            }
            return getMessagesStorage().getLastSeqValue() < updateSeq ? 1 : 2;
        }
        if (type == 1) {
            if (updates.pts <= getMessagesStorage().getLastPtsValue()) {
                return 2;
            }
            return getMessagesStorage().getLastPtsValue() + updates.pts_count == updates.pts ? 0 : 1;
        }
        if (type != 2) {
            return 0;
        }
        if (updates.pts <= getMessagesStorage().getLastQtsValue()) {
            return 2;
        }
        return getMessagesStorage().getLastQtsValue() + updates.updates.size() == updates.pts ? 0 : 1;
    }

    private void processChannelsUpdatesQueue(long channelId, int state) {
        char c;
        ArrayList<TLRPC$Updates> arrayList = this.updatesQueueChannels.get(channelId);
        if (arrayList == null) {
            return;
        }
        int i = this.channelsPts.get(channelId);
        if (arrayList.isEmpty() || i == 0) {
            this.updatesQueueChannels.remove(channelId);
            return;
        }
        Collections.sort(arrayList, $$Lambda$MessagesController$yjX7onQ45XUHdROnoOycdXTDzI8.INSTANCE);
        if (state == 2) {
            this.channelsPts.put(channelId, arrayList.get(0).pts);
        }
        boolean z = false;
        while (arrayList.size() > 0) {
            TLRPC$Updates tLRPC$Updates = arrayList.get(0);
            int i2 = tLRPC$Updates.pts;
            if (i2 <= i) {
                c = 2;
            } else {
                c = tLRPC$Updates.pts_count + i == i2 ? (char) 0 : (char) 1;
            }
            if (c == 0) {
                processUpdates(tLRPC$Updates, true);
                arrayList.remove(0);
                z = true;
            } else {
                if (c == 1) {
                    long j = this.updatesStartWaitTimeChannels.get(channelId);
                    if (j != 0 && (z || Math.abs(System.currentTimeMillis() - j) <= 1500)) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("HOLE IN CHANNEL " + channelId + " UPDATES QUEUE - will wait more time");
                        }
                        if (z) {
                            this.updatesStartWaitTimeChannels.put(channelId, System.currentTimeMillis());
                            return;
                        }
                        return;
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("HOLE IN CHANNEL " + channelId + " UPDATES QUEUE - getChannelDifference ");
                    }
                    this.updatesStartWaitTimeChannels.delete(channelId);
                    this.updatesQueueChannels.remove(channelId);
                    getChannelDifference(channelId);
                    return;
                }
                arrayList.remove(0);
            }
        }
        this.updatesQueueChannels.remove(channelId);
        this.updatesStartWaitTimeChannels.delete(channelId);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("UPDATES CHANNEL " + channelId + " QUEUE PROCEED - OK");
        }
    }

    private void processUpdatesQueue(int type, int state) {
        ArrayList<TLRPC$Updates> arrayList;
        if (type == 0) {
            arrayList = this.updatesQueueSeq;
            Collections.sort(arrayList, new $$Lambda$MessagesController$PtWSsNVkfL4Mgl52XAhIv7h0_Yo(this));
        } else if (type == 1) {
            arrayList = this.updatesQueuePts;
            Collections.sort(arrayList, $$Lambda$MessagesController$bUUs6DlF69I8qLryMuAQbvLw60.INSTANCE);
        } else if (type == 2) {
            arrayList = this.updatesQueueQts;
            Collections.sort(arrayList, $$Lambda$MessagesController$EiZl9ECVBbePkhEHKxauOweFFc.INSTANCE);
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (state == 2) {
                TLRPC$Updates tLRPC$Updates = arrayList.get(0);
                if (type == 0) {
                    getMessagesStorage().setLastSeqValue(getUpdateSeq(tLRPC$Updates));
                } else if (type == 1) {
                    getMessagesStorage().setLastPtsValue(tLRPC$Updates.pts);
                } else {
                    getMessagesStorage().setLastQtsValue(tLRPC$Updates.pts);
                }
            }
            boolean z = false;
            while (arrayList.size() > 0) {
                TLRPC$Updates tLRPC$Updates2 = arrayList.get(0);
                int iIsValidUpdate = isValidUpdate(tLRPC$Updates2, type);
                if (iIsValidUpdate == 0) {
                    processUpdates(tLRPC$Updates2, true);
                    arrayList.remove(0);
                    z = true;
                } else {
                    if (iIsValidUpdate == 1) {
                        if (getUpdatesStartTime(type) != 0 && (z || Math.abs(System.currentTimeMillis() - getUpdatesStartTime(type)) <= 1500)) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("HOLE IN UPDATES QUEUE - will wait more time");
                            }
                            if (z) {
                                setUpdatesStartTime(type, System.currentTimeMillis());
                                return;
                            }
                            return;
                        }
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("HOLE IN UPDATES QUEUE - getDifference");
                        }
                        setUpdatesStartTime(type, 0L);
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
        setUpdatesStartTime(type, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdatesQueue$256, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$processUpdatesQueue$256$MessagesController(TLRPC$Updates tLRPC$Updates, TLRPC$Updates tLRPC$Updates2) {
        return AndroidUtilities.compare(getUpdateSeq(tLRPC$Updates), getUpdateSeq(tLRPC$Updates2));
    }

    protected void loadUnknownChannel(final TLRPC$Chat channel, final long taskId) {
        NativeByteBuffer nativeByteBuffer;
        Exception e;
        if (!(channel instanceof TLRPC$TL_channel) || this.gettingUnknownChannels.indexOfKey(channel.id) >= 0) {
            return;
        }
        if (channel.access_hash == 0) {
            if (taskId != 0) {
                getMessagesStorage().removePendingTask(taskId);
                return;
            }
            return;
        }
        TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
        long j = channel.id;
        tLRPC$TL_inputPeerChannel.channel_id = j;
        tLRPC$TL_inputPeerChannel.access_hash = channel.access_hash;
        this.gettingUnknownChannels.put(j, Boolean.TRUE);
        TLRPC$TL_messages_getPeerDialogs tLRPC$TL_messages_getPeerDialogs = new TLRPC$TL_messages_getPeerDialogs();
        new TLRPC$TL_inputDialogPeer().peer = tLRPC$TL_inputPeerChannel;
        tLRPC$TL_messages_getPeerDialogs.peers.add(tLRPC$TL_inputPeerChannel);
        if (taskId == 0) {
            try {
                nativeByteBuffer = new NativeByteBuffer(channel.getObjectSize() + 4);
                try {
                    nativeByteBuffer.writeInt32(0);
                    channel.serializeToStream(nativeByteBuffer);
                } catch (Exception e2) {
                    e = e2;
                    FileLog.e(e);
                    taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$BhsBHkxCPhpakCdY_t8IHhkzptE
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$loadUnknownChannel$259$MessagesController(taskId, channel, tLObject, tLRPC$TL_error);
                        }
                    });
                }
            } catch (Exception e3) {
                nativeByteBuffer = null;
                e = e3;
            }
            taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPeerDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$BhsBHkxCPhpakCdY_t8IHhkzptE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadUnknownChannel$259$MessagesController(taskId, channel, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUnknownChannel$259, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUnknownChannel$259$MessagesController(long j, TLRPC$Chat tLRPC$Chat, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = (TLRPC$TL_messages_peerDialogs) tLObject;
            if (!tLRPC$TL_messages_peerDialogs.dialogs.isEmpty() && !tLRPC$TL_messages_peerDialogs.chats.isEmpty()) {
                TLRPC$TL_dialog tLRPC$TL_dialog = (TLRPC$TL_dialog) tLRPC$TL_messages_peerDialogs.dialogs.get(0);
                TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
                tLRPC$TL_messages_dialogs.dialogs.addAll(tLRPC$TL_messages_peerDialogs.dialogs);
                tLRPC$TL_messages_dialogs.messages.addAll(tLRPC$TL_messages_peerDialogs.messages);
                tLRPC$TL_messages_dialogs.users.addAll(tLRPC$TL_messages_peerDialogs.users);
                tLRPC$TL_messages_dialogs.chats.addAll(tLRPC$TL_messages_peerDialogs.chats);
                processLoadedDialogs(tLRPC$TL_messages_dialogs, null, tLRPC$TL_dialog.folder_id, 0, 1, this.DIALOGS_LOAD_TYPE_CHANNEL, false, false, false);
            }
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
        this.gettingUnknownChannels.delete(tLRPC$Chat.id);
    }

    public void startShortPoll(final TLRPC$Chat chat, final int guid, final boolean stop) {
        if (chat == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$BcLJNUlQAcg_7E5r3H8X-xJU5mQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startShortPoll$260$MessagesController(chat, stop, guid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startShortPoll$260, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startShortPoll$260$MessagesController(TLRPC$Chat tLRPC$Chat, boolean z, int i) {
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

    private void getChannelDifference(long channelId) {
        getChannelDifference(channelId, 0, 0L, null);
    }

    public static boolean isSupportUser(TLRPC$User user) {
        if (user != null) {
            if (!user.support) {
                long j = user.id;
                if (j == 777000 || j == 333000 || j == 4240000 || j == 4244000 || j == 4245000 || j == 4246000 || j == 410000 || j == 420000 || j == 431000 || j == 431415000 || j == 434000 || j == 4243000 || j == 439000 || j == 449000 || j == 450000 || j == 452000 || j == 454000 || j == 4254000 || j == 455000 || j == 460000 || j == 470000 || j == 479000 || j == 796000 || j == 482000 || j == 490000 || j == 496000 || j == 497000 || j == 498000 || j == 4298000) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void getChannelDifference(final long r17, final int r19, long r20, ir.eitaa.tgnet.TLRPC$InputChannel r22) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.getChannelDifference(long, int, long, ir.eitaa.tgnet.TLRPC$InputChannel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelDifference$269, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelDifference$269$MessagesController(final long j, final int i, final long j2, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$Chat tLRPC$Chat;
        if (tLObject == null) {
            if (tLRPC$TL_error != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$GUMRCIiLwkXrjovV6uFTf78RNjY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getChannelDifference$268$MessagesController(tLRPC$TL_error, j);
                    }
                });
                this.gettingDifferenceChannels.delete(j);
                if (j2 != 0) {
                    getMessagesStorage().removePendingTask(j2);
                    return;
                }
                return;
            }
            return;
        }
        final TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference = (TLRPC$updates_ChannelDifference) tLObject;
        final LongSparseArray longSparseArray = new LongSparseArray();
        int i2 = 0;
        for (int i3 = 0; i3 < tLRPC$updates_ChannelDifference.users.size(); i3++) {
            TLRPC$User tLRPC$User = tLRPC$updates_ChannelDifference.users.get(i3);
            longSparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        int i4 = 0;
        while (true) {
            if (i4 >= tLRPC$updates_ChannelDifference.chats.size()) {
                tLRPC$Chat = null;
                break;
            }
            tLRPC$Chat = tLRPC$updates_ChannelDifference.chats.get(i4);
            if (tLRPC$Chat.id == j) {
                break;
            } else {
                i4++;
            }
        }
        final ArrayList arrayList = new ArrayList();
        if (!tLRPC$updates_ChannelDifference.other_updates.isEmpty()) {
            while (i2 < tLRPC$updates_ChannelDifference.other_updates.size()) {
                TLRPC$Update tLRPC$Update = tLRPC$updates_ChannelDifference.other_updates.get(i2);
                if (tLRPC$Update instanceof TLRPC$TL_updateMessageID) {
                    arrayList.add((TLRPC$TL_updateMessageID) tLRPC$Update);
                    tLRPC$updates_ChannelDifference.other_updates.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        getMessagesStorage().putUsersAndChats(tLRPC$updates_ChannelDifference.users, tLRPC$updates_ChannelDifference.chats, true, true);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$KqPAABnoXSDpluLhiDFJlEvjZ0M
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChannelDifference$261$MessagesController(tLRPC$updates_ChannelDifference);
            }
        });
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$t4EorFLZxVTYfGiUS1a5X8ARnRY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChannelDifference$267$MessagesController(arrayList, j, tLRPC$updates_ChannelDifference, tLRPC$Chat, longSparseArray, i, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelDifference$261, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelDifference$261$MessagesController(TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference) {
        putUsers(tLRPC$updates_ChannelDifference.users, false);
        putChats(tLRPC$updates_ChannelDifference.chats, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelDifference$267, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelDifference$267$MessagesController(ArrayList arrayList, final long j, final TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference, final TLRPC$Chat tLRPC$Chat, final LongSparseArray longSparseArray, final int i, final long j2) {
        if (!arrayList.isEmpty()) {
            final SparseArray sparseArray = new SparseArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TLRPC$TL_updateMessageID tLRPC$TL_updateMessageID = (TLRPC$TL_updateMessageID) it.next();
                long[] jArrUpdateMessageStateAndId = getMessagesStorage().updateMessageStateAndId(tLRPC$TL_updateMessageID.random_id, -j, null, tLRPC$TL_updateMessageID.id, 0, false, -1);
                if (jArrUpdateMessageStateAndId != null) {
                    sparseArray.put(tLRPC$TL_updateMessageID.id, jArrUpdateMessageStateAndId);
                }
            }
            if (sparseArray.size() != 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$hO2QR_doV2XbjF4MNDEgaIX_JMk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getChannelDifference$262$MessagesController(sparseArray);
                    }
                });
            }
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Y5l_K-3yedHS3H8hv9GwquczQTg
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$getChannelDifference$266$MessagesController(tLRPC$updates_ChannelDifference, j, tLRPC$Chat, longSparseArray, i, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelDifference$262, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelDifference$262$MessagesController(SparseArray sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            long[] jArr = (long[]) sparseArray.valueAt(i);
            getSendMessagesHelper().processSentMessage((int) jArr[1]);
            getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Integer.valueOf((int) jArr[1]), Integer.valueOf(iKeyAt), null, Long.valueOf(jArr[0]), 0L, -1, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0138  */
    /* renamed from: lambda$getChannelDifference$266, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getChannelDifference$266$MessagesController(final ir.eitaa.tgnet.TLRPC$updates_ChannelDifference r23, long r24, ir.eitaa.tgnet.TLRPC$Chat r26, androidx.collection.LongSparseArray r27, int r28, long r29) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$getChannelDifference$266$MessagesController(ir.eitaa.tgnet.TLRPC$updates_ChannelDifference, long, ir.eitaa.tgnet.TLRPC$Chat, androidx.collection.LongSparseArray, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelDifference$263, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelDifference$263$MessagesController(LongSparseArray longSparseArray) {
        for (int i = 0; i < longSparseArray.size(); i++) {
            updateInterfaceWithMessages(longSparseArray.keyAt(i), (ArrayList) longSparseArray.valueAt(i), false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelDifference$265, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelDifference$265$MessagesController(final ArrayList arrayList, TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference) {
        if (!arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$kehcPy4XDCcfvwsTw9WJ8aG1j6U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getChannelDifference$264$MessagesController(arrayList);
                }
            });
        }
        getMessagesStorage().putMessages(tLRPC$updates_ChannelDifference.new_messages, true, false, false, getDownloadController().getAutodownloadMask(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelDifference$264, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelDifference$264$MessagesController(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelDifference$268, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelDifference$268$MessagesController(TLRPC$TL_error tLRPC$TL_error, long j) {
        checkChannelError(tLRPC$TL_error.text, j);
    }

    private void checkChannelError(String text, long channelId) {
        text.hashCode();
        switch (text) {
            case "USER_BANNED_IN_CHANNEL":
                getNotificationCenter().postNotificationName(NotificationCenter.chatInfoCantLoad, Long.valueOf(channelId), 2);
                break;
            case "CHANNEL_PRIVATE":
                getNotificationCenter().postNotificationName(NotificationCenter.chatInfoCantLoad, Long.valueOf(channelId), 0);
                break;
            case "CHANNEL_PUBLIC_GROUP_NA":
                getNotificationCenter().postNotificationName(NotificationCenter.chatInfoCantLoad, Long.valueOf(channelId), 1);
                break;
        }
    }

    public void getDifference() {
        getDifference(null);
    }

    public void getDifference(CountDownLatch completionLock) {
        getDifference(MessagesStorage.getInstance(this.currentAccount).getLastPtsValue(), MessagesStorage.getInstance(this.currentAccount).getLastDateValue(), MessagesStorage.getInstance(this.currentAccount).getLastQtsValue(), false, completionLock);
    }

    public void getDifference(int pts, final int date, final int qts, boolean slice, CountDownLatch completionLock) {
        registerForPush(SharedConfig.pushString);
        if (getMessagesStorage().getLastPtsValue() == 0) {
            FileLog.d("load current state, account index: " + this.currentAccount);
            loadCurrentState();
            if (completionLock != null) {
                completionLock.countDown();
                return;
            }
            return;
        }
        if (!slice && this.gettingDifference && ConnectionsManager.getInstance(this.currentAccount).lastGetDifferenceTime > System.currentTimeMillis() - 60000) {
            FileLog.d("don't getdifference in middle of another, account index: " + this.currentAccount);
            if (completionLock != null) {
                completionLock.countDown();
                return;
            }
            return;
        }
        this.gettingDifference = true;
        TLRPC$TL_updates_getDifference tLRPC$TL_updates_getDifference = new TLRPC$TL_updates_getDifference();
        tLRPC$TL_updates_getDifference.pts = pts;
        tLRPC$TL_updates_getDifference.date = date;
        tLRPC$TL_updates_getDifference.qts = qts;
        if (this.getDifferenceFirstSync) {
            tLRPC$TL_updates_getDifference.flags |= 1;
            if (ApplicationLoader.isConnectedOrConnectingToWiFi()) {
                tLRPC$TL_updates_getDifference.pts_total_limit = 5000;
            } else {
                tLRPC$TL_updates_getDifference.pts_total_limit = 1000;
            }
            this.getDifferenceFirstSync = false;
        }
        if (tLRPC$TL_updates_getDifference.date == 0) {
            tLRPC$TL_updates_getDifference.date = getConnectionsManager().getCurrentTime();
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start getDifference with date = " + date + " pts = " + pts + " qts = " + qts);
        }
        final CountDownLatch[] countDownLatchArr = {completionLock};
        getConnectionsManager().setIsUpdating(true);
        getConnectionsManager().sendRequest(tLRPC$TL_updates_getDifference, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$E4NttMenQE6VBqf04MmyenRwASI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getDifference$278$MessagesController(date, qts, countDownLatchArr, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDifference$278, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDifference$278$MessagesController(final int i, final int i2, CountDownLatch[] countDownLatchArr, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            final TLRPC$updates_Difference tLRPC$updates_Difference = (TLRPC$updates_Difference) tLObject;
            if (tLRPC$updates_Difference instanceof TLRPC$TL_updates_differenceTooLong) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$RBdlFmosYzLmyGCc7D36Y1g40FQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getDifference$270$MessagesController(tLRPC$updates_Difference, i, i2);
                    }
                });
            } else {
                if (tLRPC$updates_Difference instanceof TLRPC$TL_updates_differenceSlice) {
                    TLRPC$TL_updates_state tLRPC$TL_updates_state = tLRPC$updates_Difference.intermediate_state;
                    getDifference(tLRPC$TL_updates_state.pts, tLRPC$TL_updates_state.date, tLRPC$TL_updates_state.qts, true, null);
                }
                final LongSparseArray longSparseArray = new LongSparseArray();
                final LongSparseArray longSparseArray2 = new LongSparseArray();
                for (int i3 = 0; i3 < tLRPC$updates_Difference.users.size(); i3++) {
                    TLRPC$User tLRPC$User = tLRPC$updates_Difference.users.get(i3);
                    longSparseArray.put(tLRPC$User.id, tLRPC$User);
                }
                for (int i4 = 0; i4 < tLRPC$updates_Difference.chats.size(); i4++) {
                    TLRPC$Chat tLRPC$Chat = tLRPC$updates_Difference.chats.get(i4);
                    longSparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
                }
                final ArrayList arrayList = new ArrayList();
                if (!tLRPC$updates_Difference.other_updates.isEmpty()) {
                    int i5 = 0;
                    while (i5 < tLRPC$updates_Difference.other_updates.size()) {
                        TLRPC$Update tLRPC$Update = tLRPC$updates_Difference.other_updates.get(i5);
                        if (tLRPC$Update instanceof TLRPC$TL_updateMessageID) {
                            arrayList.add((TLRPC$TL_updateMessageID) tLRPC$Update);
                            tLRPC$updates_Difference.other_updates.remove(i5);
                        } else {
                            if (getUpdateType(tLRPC$Update) == 2) {
                                long updateChannelId = getUpdateChannelId(tLRPC$Update);
                                int channelPtsSync = this.channelsPts.get(updateChannelId);
                                if (channelPtsSync == 0 && (channelPtsSync = getMessagesStorage().getChannelPtsSync(updateChannelId)) != 0) {
                                    this.channelsPts.put(updateChannelId, channelPtsSync);
                                }
                                if (channelPtsSync != 0 && getUpdatePts(tLRPC$Update) <= channelPtsSync) {
                                    tLRPC$updates_Difference.other_updates.remove(i5);
                                }
                            }
                            i5++;
                        }
                        i5--;
                        i5++;
                    }
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$jIYnXkvv-Xu4ygeI8QbcgPMxT1w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getDifference$271$MessagesController(tLRPC$updates_Difference);
                    }
                });
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$QSlobCzfwVU3vEP91cVMBNaYNiI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getDifference$277$MessagesController(tLRPC$updates_Difference, arrayList, longSparseArray, longSparseArray2);
                    }
                });
            }
        } else {
            this.gettingDifference = false;
            getConnectionsManager().setIsUpdating(false);
        }
        if (countDownLatchArr[0] != null) {
            countDownLatchArr[0].countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDifference$270, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDifference$270$MessagesController(TLRPC$updates_Difference tLRPC$updates_Difference, int i, int i2) {
        this.loadedFullUsers.clear();
        this.loadedFullChats.clear();
        resetDialogs(true, getMessagesStorage().getLastSeqValue(), tLRPC$updates_Difference.pts, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDifference$271, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDifference$271$MessagesController(TLRPC$updates_Difference tLRPC$updates_Difference) {
        this.loadedFullUsers.clear();
        this.loadedFullChats.clear();
        putUsers(tLRPC$updates_Difference.users, false);
        putChats(tLRPC$updates_Difference.chats, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDifference$277, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDifference$277$MessagesController(final TLRPC$updates_Difference tLRPC$updates_Difference, ArrayList arrayList, final LongSparseArray longSparseArray, final LongSparseArray longSparseArray2) {
        getMessagesStorage().putUsersAndChats(tLRPC$updates_Difference.users, tLRPC$updates_Difference.chats, true, false);
        if (!arrayList.isEmpty()) {
            final SparseArray sparseArray = new SparseArray();
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$TL_updateMessageID tLRPC$TL_updateMessageID = (TLRPC$TL_updateMessageID) arrayList.get(i);
                long[] jArrUpdateMessageStateAndId = getMessagesStorage().updateMessageStateAndId(tLRPC$TL_updateMessageID.random_id, 0L, null, tLRPC$TL_updateMessageID.id, 0, false, -1);
                if (jArrUpdateMessageStateAndId != null) {
                    sparseArray.put(tLRPC$TL_updateMessageID.id, jArrUpdateMessageStateAndId);
                }
            }
            if (sparseArray.size() != 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$5XWUTb5gVuPLGYv3Hf8GtxhxikI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getDifference$272$MessagesController(sparseArray);
                    }
                });
            }
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$mkupyPcxs6ZEg7VEmlVqY03U4sQ
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$getDifference$276$MessagesController(tLRPC$updates_Difference, longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDifference$272, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDifference$272$MessagesController(SparseArray sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            long[] jArr = (long[]) sparseArray.valueAt(i);
            getSendMessagesHelper().processSentMessage((int) jArr[1]);
            getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Integer.valueOf((int) jArr[1]), Integer.valueOf(iKeyAt), null, Long.valueOf(jArr[0]), 0L, -1, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0154  */
    /* renamed from: lambda$getDifference$276, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getDifference$276$MessagesController(final ir.eitaa.tgnet.TLRPC$updates_Difference r19, androidx.collection.LongSparseArray r20, androidx.collection.LongSparseArray r21) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$getDifference$276$MessagesController(ir.eitaa.tgnet.TLRPC$updates_Difference, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDifference$273, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDifference$273$MessagesController(LongSparseArray longSparseArray) {
        for (int i = 0; i < longSparseArray.size(); i++) {
            updateInterfaceWithMessages(longSparseArray.keyAt(i), (ArrayList) longSparseArray.valueAt(i), false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDifference$275, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDifference$275$MessagesController(final ArrayList arrayList, final TLRPC$updates_Difference tLRPC$updates_Difference) {
        if (!arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$gAAomLtkihw72Xey7Gc72ar6qZE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDifference$274$MessagesController(arrayList, tLRPC$updates_Difference);
                }
            });
        }
        getMessagesStorage().putMessages(tLRPC$updates_Difference.new_messages, true, false, false, getDownloadController().getAutodownloadMask(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDifference$274, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDifference$274$MessagesController(ArrayList arrayList, TLRPC$updates_Difference tLRPC$updates_Difference) {
        getNotificationsController().processNewMessages(arrayList, !(tLRPC$updates_Difference instanceof TLRPC$TL_updates_differenceSlice), false, null);
    }

    public void markDialogAsUnread(long dialogId, TLRPC$InputPeer peer, final long taskId) {
        NativeByteBuffer nativeByteBuffer;
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(dialogId);
        NativeByteBuffer nativeByteBuffer2 = null;
        if (tLRPC$Dialog != null) {
            tLRPC$Dialog.unread_mark = true;
            if (tLRPC$Dialog.unread_count == 0 && !isDialogMuted(dialogId)) {
                this.unreadUnmutedDialogs++;
            }
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_READ_DIALOG_MESSAGE));
            getMessagesStorage().setDialogUnread(dialogId, true);
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
        if (DialogObject.isEncryptedDialog(dialogId)) {
            return;
        }
        TLRPC$TL_messages_markDialogUnread tLRPC$TL_messages_markDialogUnread = new TLRPC$TL_messages_markDialogUnread();
        tLRPC$TL_messages_markDialogUnread.unread = true;
        if (peer == null) {
            peer = getInputPeer(dialogId);
        }
        if (peer instanceof TLRPC$TL_inputPeerEmpty) {
            return;
        }
        TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
        tLRPC$TL_inputDialogPeer.peer = peer;
        tLRPC$TL_messages_markDialogUnread.peer = tLRPC$TL_inputDialogPeer;
        if (taskId == 0) {
            try {
                nativeByteBuffer = new NativeByteBuffer(peer.getObjectSize() + 12);
            } catch (Exception e) {
                e = e;
            }
            try {
                nativeByteBuffer.writeInt32(9);
                nativeByteBuffer.writeInt64(dialogId);
                peer.serializeToStream(nativeByteBuffer);
            } catch (Exception e2) {
                e = e2;
                nativeByteBuffer2 = nativeByteBuffer;
                FileLog.e(e);
                nativeByteBuffer = nativeByteBuffer2;
                taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
                getConnectionsManager().sendRequest(tLRPC$TL_messages_markDialogUnread, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$2_F2aNrxy20UQM1yPVEuSYkzw5w
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$markDialogAsUnread$279$MessagesController(taskId, tLObject, tLRPC$TL_error);
                    }
                });
            }
            taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_markDialogUnread, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$2_F2aNrxy20UQM1yPVEuSYkzw5w
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$markDialogAsUnread$279$MessagesController(taskId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markDialogAsUnread$279, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markDialogAsUnread$279$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void loadUnreadDialogs() {
        if (this.loadingUnreadDialogs || getUserConfig().unreadDialogsLoaded) {
            return;
        }
        this.loadingUnreadDialogs = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_getDialogUnreadMarks
            public static int constructor = 585256482;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                int int32 = stream.readInt32(exception);
                for (int i = 0; i < int32; i++) {
                    TLRPC$DialogPeer tLRPC$DialogPeerTLdeserialize = TLRPC$DialogPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
                    if (tLRPC$DialogPeerTLdeserialize == null) {
                        return tLRPC$Vector;
                    }
                    tLRPC$Vector.objects.add(tLRPC$DialogPeerTLdeserialize);
                }
                return tLRPC$Vector;
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$tsTKecyhqyvas69_MVGbRk_BRqI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadUnreadDialogs$281$MessagesController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUnreadDialogs$281, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUnreadDialogs$281$MessagesController(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$-OJNPeJ8GHs0i2njYkd-DTKGmIU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadUnreadDialogs$280$MessagesController(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUnreadDialogs$280, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUnreadDialogs$280$MessagesController(TLObject tLObject) {
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            int size = tLRPC$Vector.objects.size();
            for (int i = 0; i < size; i++) {
                TLRPC$DialogPeer tLRPC$DialogPeer = (TLRPC$DialogPeer) tLRPC$Vector.objects.get(i);
                if (tLRPC$DialogPeer instanceof TLRPC$TL_dialogPeer) {
                    TLRPC$Peer tLRPC$Peer = ((TLRPC$TL_dialogPeer) tLRPC$DialogPeer).peer;
                    long j = tLRPC$Peer.user_id;
                    if (j == 0) {
                        long j2 = tLRPC$Peer.chat_id;
                        j = j2 != 0 ? -j2 : -tLRPC$Peer.channel_id;
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
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_READ_DIALOG_MESSAGE));
            this.loadingUnreadDialogs = false;
        }
    }

    public void reorderPinnedDialogs(int folderId, ArrayList<TLRPC$InputDialogPeer> order, final long taskId) {
        NativeByteBuffer nativeByteBuffer;
        TLRPC$TL_messages_reorderPinnedDialogs tLRPC$TL_messages_reorderPinnedDialogs = new TLRPC$TL_messages_reorderPinnedDialogs();
        tLRPC$TL_messages_reorderPinnedDialogs.folder_id = folderId;
        tLRPC$TL_messages_reorderPinnedDialogs.force = true;
        if (taskId == 0) {
            ArrayList<TLRPC$Dialog> dialogs = getDialogs(folderId);
            if (dialogs.isEmpty()) {
                return;
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            int size = dialogs.size();
            int objectSize = 0;
            for (int i = 0; i < size; i++) {
                TLRPC$Dialog tLRPC$Dialog = dialogs.get(i);
                if (!(tLRPC$Dialog instanceof TLRPC$TL_dialogFolder)) {
                    if (!tLRPC$Dialog.pinned) {
                        if (tLRPC$Dialog.id != this.promoDialogId) {
                            break;
                        }
                    } else {
                        arrayList.add(Long.valueOf(tLRPC$Dialog.id));
                        arrayList2.add(Integer.valueOf(tLRPC$Dialog.pinnedNum));
                        if (!DialogObject.isEncryptedDialog(tLRPC$Dialog.id)) {
                            TLRPC$InputPeer inputPeer = getInputPeer(tLRPC$Dialog.id);
                            TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
                            tLRPC$TL_inputDialogPeer.peer = inputPeer;
                            tLRPC$TL_messages_reorderPinnedDialogs.order.add(tLRPC$TL_inputDialogPeer);
                            objectSize += tLRPC$TL_inputDialogPeer.getObjectSize();
                        }
                    }
                }
            }
            getMessagesStorage().setDialogsPinned(arrayList, arrayList2);
            NativeByteBuffer nativeByteBuffer2 = null;
            try {
                nativeByteBuffer = new NativeByteBuffer(objectSize + 12);
                try {
                    nativeByteBuffer.writeInt32(16);
                    nativeByteBuffer.writeInt32(folderId);
                    nativeByteBuffer.writeInt32(tLRPC$TL_messages_reorderPinnedDialogs.order.size());
                    int size2 = tLRPC$TL_messages_reorderPinnedDialogs.order.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        tLRPC$TL_messages_reorderPinnedDialogs.order.get(i2).serializeToStream(nativeByteBuffer);
                    }
                } catch (Exception e) {
                    e = e;
                    nativeByteBuffer2 = nativeByteBuffer;
                    FileLog.e(e);
                    nativeByteBuffer = nativeByteBuffer2;
                    taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_reorderPinnedDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$hl57iSs7jGC-F1zrNlly_8SVzLM
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$reorderPinnedDialogs$282$MessagesController(taskId, tLObject, tLRPC$TL_error);
                        }
                    });
                }
            } catch (Exception e2) {
                e = e2;
            }
            taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
        } else {
            tLRPC$TL_messages_reorderPinnedDialogs.order = order;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_reorderPinnedDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$hl57iSs7jGC-F1zrNlly_8SVzLM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reorderPinnedDialogs$282$MessagesController(taskId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reorderPinnedDialogs$282, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reorderPinnedDialogs$282$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public boolean pinDialog(long dialogId, boolean pin, TLRPC$InputPeer peer, long taskId) {
        NativeByteBuffer nativeByteBuffer;
        final long jCreatePendingTask;
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(dialogId);
        if (tLRPC$Dialog == null || tLRPC$Dialog.pinned == pin) {
            return tLRPC$Dialog != null;
        }
        int i = tLRPC$Dialog.folder_id;
        ArrayList<TLRPC$Dialog> dialogs = getDialogs(i);
        tLRPC$Dialog.pinned = pin;
        if (pin) {
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
        NativeByteBuffer nativeByteBuffer2 = null;
        sortDialogs(null);
        if (!pin && !dialogs.isEmpty() && dialogs.get(dialogs.size() - 1) == tLRPC$Dialog && !this.dialogsEndReached.get(i)) {
            dialogs.remove(dialogs.size() - 1);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        if (!DialogObject.isEncryptedDialog(dialogId) && taskId != -1) {
            TLRPC$TL_messages_toggleDialogPin tLRPC$TL_messages_toggleDialogPin = new TLRPC$TL_messages_toggleDialogPin();
            tLRPC$TL_messages_toggleDialogPin.pinned = pin;
            TLRPC$InputPeer inputPeer = peer == null ? getInputPeer(dialogId) : peer;
            if (inputPeer instanceof TLRPC$TL_inputPeerEmpty) {
                return false;
            }
            TLRPC$TL_inputDialogPeer tLRPC$TL_inputDialogPeer = new TLRPC$TL_inputDialogPeer();
            tLRPC$TL_inputDialogPeer.peer = inputPeer;
            tLRPC$TL_messages_toggleDialogPin.peer = tLRPC$TL_inputDialogPeer;
            if (taskId == 0) {
                try {
                    nativeByteBuffer = new NativeByteBuffer(inputPeer.getObjectSize() + 16);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    nativeByteBuffer.writeInt32(4);
                    nativeByteBuffer.writeInt64(dialogId);
                    nativeByteBuffer.writeBool(pin);
                    inputPeer.serializeToStream(nativeByteBuffer);
                } catch (Exception e2) {
                    e = e2;
                    nativeByteBuffer2 = nativeByteBuffer;
                    FileLog.e(e);
                    nativeByteBuffer = nativeByteBuffer2;
                    jCreatePendingTask = getMessagesStorage().createPendingTask(nativeByteBuffer);
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_toggleDialogPin, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$lT2B3gjg0aYap1SxiM5IfGMzNgk
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$pinDialog$283$MessagesController(jCreatePendingTask, tLObject, tLRPC$TL_error);
                        }
                    });
                    getMessagesStorage().setDialogPinned(dialogId, tLRPC$Dialog.pinnedNum);
                    return true;
                }
                jCreatePendingTask = getMessagesStorage().createPendingTask(nativeByteBuffer);
            } else {
                jCreatePendingTask = taskId;
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_toggleDialogPin, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$lT2B3gjg0aYap1SxiM5IfGMzNgk
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$pinDialog$283$MessagesController(jCreatePendingTask, tLObject, tLRPC$TL_error);
                }
            });
        }
        getMessagesStorage().setDialogPinned(dialogId, tLRPC$Dialog.pinnedNum);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$pinDialog$283, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$pinDialog$283$MessagesController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void loadPinnedDialogs(final int folderId, long newDialogId, ArrayList<Long> order) {
        if (this.loadingPinnedDialogs.indexOfKey(folderId) >= 0 || getUserConfig().isPinnedDialogsLoaded(folderId)) {
            return;
        }
        this.loadingPinnedDialogs.put(folderId, 1);
        TLRPC$TL_messages_getPinnedDialogs tLRPC$TL_messages_getPinnedDialogs = new TLRPC$TL_messages_getPinnedDialogs();
        tLRPC$TL_messages_getPinnedDialogs.folder_id = folderId;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getPinnedDialogs, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$MAgMGhqV1ytaV1gy9xsiWS-nzyU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPinnedDialogs$286$MessagesController(folderId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0121  */
    /* renamed from: lambda$loadPinnedDialogs$286, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadPinnedDialogs$286$MessagesController(final int r18, ir.eitaa.tgnet.TLObject r19, ir.eitaa.tgnet.TLRPC$TL_error r20) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$loadPinnedDialogs$286$MessagesController(int, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPinnedDialogs$285, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPinnedDialogs$285$MessagesController(final int i, final ArrayList arrayList, final boolean z, final TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs, final LongSparseArray longSparseArray, final TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$HUY73N3INcxoas0G7fW6VlXhVKo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPinnedDialogs$284$MessagesController(i, arrayList, z, tLRPC$TL_messages_peerDialogs, longSparseArray, tLRPC$TL_messages_dialogs);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPinnedDialogs$284, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPinnedDialogs$284$MessagesController(int i, ArrayList arrayList, boolean z, TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs, LongSparseArray longSparseArray, TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs) {
        boolean z2;
        boolean z3;
        ArrayList<Integer> arrayList2;
        this.loadingPinnedDialogs.delete(i);
        applyDialogsNotificationsSettings(arrayList);
        ArrayList<TLRPC$Dialog> dialogs = getDialogs(i);
        int i2 = z ? 1 : 0;
        int iMax = 0;
        boolean z4 = false;
        for (int i3 = 0; i3 < dialogs.size(); i3++) {
            TLRPC$Dialog tLRPC$Dialog = dialogs.get(i3);
            if (!(tLRPC$Dialog instanceof TLRPC$TL_dialogFolder)) {
                if (DialogObject.isEncryptedDialog(tLRPC$Dialog.id)) {
                    if (i2 < arrayList.size()) {
                        arrayList.add(i2, tLRPC$Dialog);
                    } else {
                        arrayList.add(tLRPC$Dialog);
                    }
                    i2++;
                } else if (!tLRPC$Dialog.pinned) {
                    if (tLRPC$Dialog.id != this.promoDialogId) {
                        break;
                    }
                } else {
                    iMax = Math.max(tLRPC$Dialog.pinnedNum, iMax);
                    tLRPC$Dialog.pinned = false;
                    tLRPC$Dialog.pinnedNum = 0;
                    i2++;
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
            int i4 = 0;
            z2 = false;
            while (i4 < size) {
                TLRPC$Dialog tLRPC$Dialog2 = (TLRPC$Dialog) arrayList.get(i4);
                tLRPC$Dialog2.pinnedNum = (size - i4) + iMax;
                arrayList3.add(Long.valueOf(tLRPC$Dialog2.id));
                TLRPC$Dialog tLRPC$Dialog3 = this.dialogs_dict.get(tLRPC$Dialog2.id);
                if (tLRPC$Dialog3 != null) {
                    tLRPC$Dialog3.pinned = true;
                    tLRPC$Dialog3.pinnedNum = tLRPC$Dialog2.pinnedNum;
                    arrayList4.add(Long.valueOf(tLRPC$Dialog2.id));
                    arrayList5.add(Integer.valueOf(tLRPC$Dialog2.pinnedNum));
                    arrayList2 = arrayList5;
                } else {
                    this.dialogs_dict.put(tLRPC$Dialog2.id, tLRPC$Dialog2);
                    MessageObject messageObject = (MessageObject) longSparseArray.get(tLRPC$Dialog2.id);
                    arrayList2 = arrayList5;
                    this.dialogMessage.put(tLRPC$Dialog2.id, messageObject);
                    if (messageObject != null && messageObject.messageOwner.peer_id.channel_id == 0) {
                        this.dialogMessagesByIds.put(messageObject.getId(), messageObject);
                        this.dialogsLoadedTillDate = Math.min(this.dialogsLoadedTillDate, messageObject.messageOwner.date);
                        long j = messageObject.messageOwner.random_id;
                        if (j != 0) {
                            this.dialogMessagesByRandomIds.put(j, messageObject);
                        }
                    }
                    z2 = true;
                }
                i4++;
                arrayList5 = arrayList2;
                z4 = true;
            }
            getMessagesStorage().setDialogsPinned(arrayList4, arrayList5);
        }
        if (z4) {
            if (z2) {
                this.allDialogs.clear();
                int size2 = this.dialogs_dict.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    TLRPC$Dialog tLRPC$DialogValueAt = this.dialogs_dict.valueAt(i5);
                    if (this.deletingDialogs.indexOfKey(tLRPC$DialogValueAt.id) < 0) {
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

    public void updateDialogLockState(TLRPC$Dialog dialog, boolean lockState) {
        getMessagesStorage().updateDialogLockStateInternal(dialog, lockState);
        if (lockState) {
            addToLockedDialogs(dialog.id);
        } else {
            this.lockedDialogsId.remove(Long.valueOf(dialog.id));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ikWDnDbiKDTesxCyOT4u5psGrqM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateDialogLockState$287$MessagesController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateDialogLockState$287, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateDialogLockState$287$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    public void unlockAllDialogs() {
        Iterator<Long> it = this.lockedDialogsId.iterator();
        while (it.hasNext()) {
            getMessagesStorage().updateDialogLockStateInternal(this.dialogs_dict.get(it.next().longValue()), false);
        }
        this.lockedDialogsId.clear();
    }

    public void generateJoinMessage(final long chatId, boolean ignoreLeft) {
        TLRPC$Chat chat = getChat(Long.valueOf(chatId));
        if (chat == null || !ChatObject.isChannel(chatId, this.currentAccount)) {
            return;
        }
        if ((chat.left || chat.kicked) && !ignoreLeft) {
            return;
        }
        TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
        tLRPC$TL_messageService.flags = Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        int newMessageId = getUserConfig().getNewMessageId();
        tLRPC$TL_messageService.id = newMessageId;
        tLRPC$TL_messageService.local_id = newMessageId;
        tLRPC$TL_messageService.date = getConnectionsManager().getCurrentTime();
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = getUserConfig().getClientUserId();
        TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
        tLRPC$TL_messageService.peer_id = tLRPC$TL_peerChannel;
        tLRPC$TL_peerChannel.channel_id = chatId;
        tLRPC$TL_messageService.dialog_id = -chatId;
        tLRPC$TL_messageService.post = true;
        TLRPC$TL_messageActionChatAddUser tLRPC$TL_messageActionChatAddUser = new TLRPC$TL_messageActionChatAddUser();
        tLRPC$TL_messageService.action = tLRPC$TL_messageActionChatAddUser;
        tLRPC$TL_messageActionChatAddUser.users.add(Long.valueOf(getUserConfig().getClientUserId()));
        getUserConfig().saveConfig(false);
        final ArrayList arrayList = new ArrayList();
        ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
        arrayList2.add(tLRPC$TL_messageService);
        arrayList.add(new MessageObject(this.currentAccount, tLRPC$TL_messageService, true, false));
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$lfiUPgQEQAVdAvtqOmcpjY5kd_8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateJoinMessage$289$MessagesController(arrayList);
            }
        });
        getMessagesStorage().putMessages(arrayList2, true, true, false, 0, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$z6CMsC1rFIfOgF_0cMzlFEXdSJU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateJoinMessage$290$MessagesController(chatId, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateJoinMessage$288, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateJoinMessage$288$MessagesController(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateJoinMessage$289, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateJoinMessage$289$MessagesController(final ArrayList arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$vyZ4S1Q2b_BAh0KC0frAafEvgIA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateJoinMessage$288$MessagesController(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateJoinMessage$290, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateJoinMessage$290$MessagesController(long j, ArrayList arrayList) {
        updateInterfaceWithMessages(-j, arrayList, false);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    protected void deleteMessagesByPush(final long dialogId, final ArrayList<Integer> ids, final long channelId) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$OupN5trH9YjTASh7X6H-xjZxBi4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteMessagesByPush$292$MessagesController(ids, channelId, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteMessagesByPush$292, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteMessagesByPush$292$MessagesController(final ArrayList arrayList, final long j, long j2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$qCIJeH6VyDA73som2RFVGj8kx28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteMessagesByPush$291$MessagesController(arrayList, j);
            }
        });
        getMessagesStorage().deletePushMessages(j2, arrayList);
        getMessagesStorage().updateDialogsWithDeletedMessages(j2, j, arrayList, getMessagesStorage().markMessagesAsDeleted(j2, arrayList, false, true, false), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteMessagesByPush$291, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteMessagesByPush$291$MessagesController(ArrayList arrayList, long j) {
        int i = 0;
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDeleted, arrayList, Long.valueOf(j), Boolean.FALSE);
        if (j == 0) {
            int size = arrayList.size();
            while (i < size) {
                MessageObject messageObject = this.dialogMessagesByIds.get(((Integer) arrayList.get(i)).intValue());
                if (messageObject != null) {
                    messageObject.deleted = true;
                }
                i++;
            }
            return;
        }
        MessageObject messageObject2 = this.dialogMessage.get(-j);
        if (messageObject2 != null) {
            int size2 = arrayList.size();
            while (i < size2) {
                if (messageObject2.getId() == ((Integer) arrayList.get(i)).intValue()) {
                    messageObject2.deleted = true;
                    return;
                }
                i++;
            }
        }
    }

    public void checkChatInviter(final long chatId, final boolean createMessage) {
        final TLRPC$Chat chat = getChat(Long.valueOf(chatId));
        if (!ChatObject.isChannel(chat) || chat.creator || this.gettingChatInviters.indexOfKey(chatId) >= 0) {
            return;
        }
        this.gettingChatInviters.put(chatId, Boolean.TRUE);
        TLRPC$TL_channels_getParticipant tLRPC$TL_channels_getParticipant = new TLRPC$TL_channels_getParticipant();
        tLRPC$TL_channels_getParticipant.channel = getInputChannel(chatId);
        tLRPC$TL_channels_getParticipant.participant = getInputPeer(getUserConfig().getClientUserId());
        getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipant, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$dPaFhTu3WlT_muyU8jSosZT3QPM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkChatInviter$297$MessagesController(chat, createMessage, chatId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkChatInviter$297, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkChatInviter$297$MessagesController(TLRPC$Chat tLRPC$Chat, boolean z, final long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$4q3btkR93WE-rDlY2crOEuEDGKs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkChatInviter$293$MessagesController(tLRPC$TL_channels_channelParticipant);
                }
            });
            getMessagesStorage().putUsersAndChats(tLRPC$TL_channels_channelParticipant.users, tLRPC$TL_channels_channelParticipant.chats, true, true);
            if (!z || Math.abs(getConnectionsManager().getCurrentTime() - tLRPC$TL_channels_channelParticipant.participant.date) >= 86400 || getMessagesStorage().hasInviteMeMessage(j)) {
                arrayList = null;
            } else {
                TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
                tLRPC$TL_messageService.media_unread = true;
                tLRPC$TL_messageService.unread = true;
                tLRPC$TL_messageService.flags = Factory.DEVICE_HAS_CRAPPY_OPENSLES;
                tLRPC$TL_messageService.post = true;
                int newMessageId = getUserConfig().getNewMessageId();
                tLRPC$TL_messageService.id = newMessageId;
                tLRPC$TL_messageService.local_id = newMessageId;
                tLRPC$TL_messageService.date = tLRPC$TL_channels_channelParticipant.participant.date;
                tLRPC$TL_messageService.action = new TLRPC$TL_messageActionChatAddUser();
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = tLRPC$TL_channels_channelParticipant.participant.inviter_id;
                tLRPC$TL_messageService.action.users.add(Long.valueOf(getUserConfig().getClientUserId()));
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                tLRPC$TL_messageService.peer_id = tLRPC$TL_peerChannel;
                tLRPC$TL_peerChannel.channel_id = j;
                tLRPC$TL_messageService.dialog_id = -j;
                getUserConfig().saveConfig(false);
                arrayList = new ArrayList();
                ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (int i = 0; i < tLRPC$TL_channels_channelParticipant.users.size(); i++) {
                    TLRPC$User tLRPC$User = tLRPC$TL_channels_channelParticipant.users.get(i);
                    concurrentHashMap.put(Long.valueOf(tLRPC$User.id), tLRPC$User);
                }
                arrayList2.add(tLRPC$TL_messageService);
                arrayList.add(new MessageObject(this.currentAccount, (TLRPC$Message) tLRPC$TL_messageService, (AbstractMap<Long, TLRPC$User>) concurrentHashMap, true, false));
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$wGiLYZBWLUunMmLYLx9JlsoDmxs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkChatInviter$295$MessagesController(arrayList);
                    }
                });
                getMessagesStorage().putMessages(arrayList2, true, true, false, 0, false);
            }
            final ArrayList arrayList3 = arrayList;
            getMessagesStorage().saveChatInviter(j, tLRPC$TL_channels_channelParticipant.participant.inviter_id);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$iSHIVOFec4nnP5kNqtwZt2pfCp4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkChatInviter$296$MessagesController(j, arrayList3, tLRPC$TL_channels_channelParticipant);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkChatInviter$293, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkChatInviter$293$MessagesController(TLRPC$TL_channels_channelParticipant tLRPC$TL_channels_channelParticipant) {
        putUsers(tLRPC$TL_channels_channelParticipant.users, false);
        putChats(tLRPC$TL_channels_channelParticipant.chats, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkChatInviter$294, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkChatInviter$294$MessagesController(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkChatInviter$295, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkChatInviter$295$MessagesController(final ArrayList arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$O0QTDUmyEog5WsK060UZd-pj3Xo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkChatInviter$294$MessagesController(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkChatInviter$296, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkChatInviter$296$MessagesController(long j, ArrayList arrayList, TLRPC$TL_channels_channelParticipant tLRPC$TL_channels_channelParticipant) {
        this.gettingChatInviters.delete(j);
        if (arrayList != null) {
            updateInterfaceWithMessages(-j, arrayList, false);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.didLoadChatInviter, Long.valueOf(j), Long.valueOf(tLRPC$TL_channels_channelParticipant.participant.inviter_id));
    }

    private int getUpdateType(TLRPC$Update update) {
        if ((update instanceof TLRPC$TL_updateNewMessage) || (update instanceof TLRPC$TL_updateReadMessagesContents) || (update instanceof TLRPC$TL_updateReadHistoryInbox) || (update instanceof TLRPC$TL_updateReadHistoryOutbox) || (update instanceof TLRPC$TL_updateDeleteMessages) || (update instanceof TLRPC$TL_updateWebPage) || (update instanceof TLRPC$TL_updateEditMessage) || (update instanceof TLRPC$TL_updateFolderPeers) || (update instanceof TLRPC$TL_updatePinnedMessages)) {
            return 0;
        }
        if (update instanceof TLRPC$TL_updateNewEncryptedMessage) {
            return 1;
        }
        return ((update instanceof TLRPC$TL_updateNewChannelMessage) || (update instanceof TLRPC$TL_updateDeleteChannelMessages) || (update instanceof TLRPC$TL_updateEditChannelMessage) || (update instanceof TLRPC$TL_updateChannelWebPage) || (update instanceof TLRPC$TL_updatePinnedChannelMessages)) ? 2 : 3;
    }

    private static int getUpdatePts(TLRPC$Update update) {
        if (update instanceof TLRPC$TL_updateDeleteMessages) {
            return ((TLRPC$TL_updateDeleteMessages) update).pts;
        }
        if (update instanceof TLRPC$TL_updateNewChannelMessage) {
            return ((TLRPC$TL_updateNewChannelMessage) update).pts;
        }
        if (update instanceof TLRPC$TL_updateReadHistoryOutbox) {
            return ((TLRPC$TL_updateReadHistoryOutbox) update).pts;
        }
        if (update instanceof TLRPC$TL_updateNewMessage) {
            return ((TLRPC$TL_updateNewMessage) update).pts;
        }
        if (update instanceof TLRPC$TL_updateEditMessage) {
            return ((TLRPC$TL_updateEditMessage) update).pts;
        }
        if (update instanceof TLRPC$TL_updateWebPage) {
            return ((TLRPC$TL_updateWebPage) update).pts;
        }
        if (update instanceof TLRPC$TL_updateReadHistoryInbox) {
            return ((TLRPC$TL_updateReadHistoryInbox) update).pts;
        }
        if (update instanceof TLRPC$TL_updateChannelWebPage) {
            return ((TLRPC$TL_updateChannelWebPage) update).pts;
        }
        if (update instanceof TLRPC$TL_updateDeleteChannelMessages) {
            return ((TLRPC$TL_updateDeleteChannelMessages) update).pts;
        }
        if (update instanceof TLRPC$TL_updateEditChannelMessage) {
            return ((TLRPC$TL_updateEditChannelMessage) update).pts;
        }
        if (update instanceof TLRPC$TL_updateReadMessagesContents) {
            return ((TLRPC$TL_updateReadMessagesContents) update).pts;
        }
        if (update instanceof TLRPC$TL_updateChannelTooLong) {
            return ((TLRPC$TL_updateChannelTooLong) update).pts;
        }
        if (update instanceof TLRPC$TL_updateFolderPeers) {
            return ((TLRPC$TL_updateFolderPeers) update).pts;
        }
        if (update instanceof TLRPC$TL_updatePinnedChannelMessages) {
            return ((TLRPC$TL_updatePinnedChannelMessages) update).pts;
        }
        if (update instanceof TLRPC$TL_updatePinnedMessages) {
            return ((TLRPC$TL_updatePinnedMessages) update).pts;
        }
        return 0;
    }

    private static int getUpdatePtsCount(TLRPC$Update update) {
        if (update instanceof TLRPC$TL_updateDeleteMessages) {
            return ((TLRPC$TL_updateDeleteMessages) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateNewChannelMessage) {
            return ((TLRPC$TL_updateNewChannelMessage) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateReadHistoryOutbox) {
            return ((TLRPC$TL_updateReadHistoryOutbox) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateNewMessage) {
            return ((TLRPC$TL_updateNewMessage) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateEditMessage) {
            return ((TLRPC$TL_updateEditMessage) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateWebPage) {
            return ((TLRPC$TL_updateWebPage) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateReadHistoryInbox) {
            return ((TLRPC$TL_updateReadHistoryInbox) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateChannelWebPage) {
            return ((TLRPC$TL_updateChannelWebPage) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateDeleteChannelMessages) {
            return ((TLRPC$TL_updateDeleteChannelMessages) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateEditChannelMessage) {
            return ((TLRPC$TL_updateEditChannelMessage) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateReadMessagesContents) {
            return ((TLRPC$TL_updateReadMessagesContents) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updateFolderPeers) {
            return ((TLRPC$TL_updateFolderPeers) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updatePinnedChannelMessages) {
            return ((TLRPC$TL_updatePinnedChannelMessages) update).pts_count;
        }
        if (update instanceof TLRPC$TL_updatePinnedMessages) {
            return ((TLRPC$TL_updatePinnedMessages) update).pts_count;
        }
        return 0;
    }

    private static int getUpdateQts(TLRPC$Update update) {
        if (update instanceof TLRPC$TL_updateNewEncryptedMessage) {
            return ((TLRPC$TL_updateNewEncryptedMessage) update).qts;
        }
        return 0;
    }

    public static long getUpdateChannelId(TLRPC$Update update) {
        if (update instanceof TLRPC$TL_updateNewChannelMessage) {
            return ((TLRPC$TL_updateNewChannelMessage) update).message.peer_id.channel_id;
        }
        if (update instanceof TLRPC$TL_updateEditChannelMessage) {
            return ((TLRPC$TL_updateEditChannelMessage) update).message.peer_id.channel_id;
        }
        if (update instanceof TLRPC$TL_updateReadChannelOutbox) {
            return ((TLRPC$TL_updateReadChannelOutbox) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateChannelMessageViews) {
            return ((TLRPC$TL_updateChannelMessageViews) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateChannelMessageForwards) {
            return ((TLRPC$TL_updateChannelMessageForwards) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateChannelTooLong) {
            return ((TLRPC$TL_updateChannelTooLong) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateChannelReadMessagesContents) {
            return ((TLRPC$TL_updateChannelReadMessagesContents) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateChannelAvailableMessages) {
            return ((TLRPC$TL_updateChannelAvailableMessages) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateChannel) {
            return ((TLRPC$TL_updateChannel) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateChannelWebPage) {
            return ((TLRPC$TL_updateChannelWebPage) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateDeleteChannelMessages) {
            return ((TLRPC$TL_updateDeleteChannelMessages) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateReadChannelInbox) {
            return ((TLRPC$TL_updateReadChannelInbox) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateReadChannelDiscussionInbox) {
            return ((TLRPC$TL_updateReadChannelDiscussionInbox) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateReadChannelDiscussionOutbox) {
            return ((TLRPC$TL_updateReadChannelDiscussionOutbox) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updateChannelUserTyping) {
            return ((TLRPC$TL_updateChannelUserTyping) update).channel_id;
        }
        if (update instanceof TLRPC$TL_updatePinnedChannelMessages) {
            return ((TLRPC$TL_updatePinnedChannelMessages) update).channel_id;
        }
        if (!BuildVars.LOGS_ENABLED) {
            return 0L;
        }
        FileLog.e("trying to get unknown update channel_id for " + update);
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x070f  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0711  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0791 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x07c1  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x09b0  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x09ea  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0a04  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x03f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:477:0x078d A[EDGE_INSN: B:477:0x078d->B:346:0x078d BREAK  A[LOOP:9: B:329:0x074d->B:345:0x078a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e0 A[PHI: r9
      0x01e0: PHI (r9v37 java.util.ArrayList) = (r9v34 java.util.ArrayList), (r9v38 java.util.ArrayList), (r9v40 java.util.ArrayList), (r9v40 java.util.ArrayList) binds: [B:131:0x031d, B:97:0x024a, B:83:0x01ba, B:84:0x01bc] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processUpdates(final ir.eitaa.tgnet.TLRPC$Updates r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 2612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.processUpdates(ir.eitaa.tgnet.TLRPC$Updates, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdates$298, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdates$298$MessagesController(boolean z, long j, ArrayList arrayList) {
        if (z) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_USER_PRINT));
        }
        updateInterfaceWithMessages(j, arrayList, false);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdates$299, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdates$299$MessagesController(boolean z, TLRPC$Updates tLRPC$Updates, ArrayList arrayList) {
        if (z) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_USER_PRINT));
        }
        updateInterfaceWithMessages(-tLRPC$Updates.chat_id, arrayList, false);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdates$300, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdates$300$MessagesController(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdates$301, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdates$301$MessagesController(final ArrayList arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$yQLXLTrxJQ7dE9eCvRlbPP2ySuI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdates$300$MessagesController(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdates$303, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdates$303$MessagesController() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(UPDATE_MASK_STATUS));
    }

    private boolean applyFoldersUpdates(ArrayList<TLRPC$TL_updateFolderPeers> folderUpdates) {
        if (folderUpdates == null) {
            return false;
        }
        int size = folderUpdates.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            TLRPC$TL_updateFolderPeers tLRPC$TL_updateFolderPeers = folderUpdates.get(i);
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
            getMessagesStorage().setDialogsFolderId(folderUpdates.get(i).folder_peers, null, 0L, 0);
            i++;
            z = true;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:947:0x13ce, code lost:
    
        if (r1.action.user_id == r31) goto L839;
     */
    /* JADX WARN: Removed duplicated region for block: B:1017:0x1510  */
    /* JADX WARN: Removed duplicated region for block: B:1020:0x1519  */
    /* JADX WARN: Removed duplicated region for block: B:1024:0x1526  */
    /* JADX WARN: Removed duplicated region for block: B:1027:0x1543  */
    /* JADX WARN: Removed duplicated region for block: B:1029:0x1548  */
    /* JADX WARN: Removed duplicated region for block: B:1033:0x1551  */
    /* JADX WARN: Removed duplicated region for block: B:1034:0x1558  */
    /* JADX WARN: Removed duplicated region for block: B:1037:0x1563  */
    /* JADX WARN: Removed duplicated region for block: B:1040:0x1576  */
    /* JADX WARN: Removed duplicated region for block: B:1042:0x157c  */
    /* JADX WARN: Removed duplicated region for block: B:1050:0x1590  */
    /* JADX WARN: Removed duplicated region for block: B:1051:0x1596  */
    /* JADX WARN: Removed duplicated region for block: B:1115:0x17a9  */
    /* JADX WARN: Removed duplicated region for block: B:1120:0x17d2  */
    /* JADX WARN: Removed duplicated region for block: B:1133:0x182e  */
    /* JADX WARN: Removed duplicated region for block: B:1138:0x1851  */
    /* JADX WARN: Removed duplicated region for block: B:1143:0x1877  */
    /* JADX WARN: Removed duplicated region for block: B:780:0x10bd  */
    /* JADX WARN: Removed duplicated region for block: B:820:0x119f  */
    /* JADX WARN: Removed duplicated region for block: B:843:0x1249 A[PHI: r3
      0x1249: PHI (r3v69 long) = (r3v20 long), (r3v21 long) binds: [B:842:0x1247, B:845:0x1250] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:853:0x1264  */
    /* JADX WARN: Removed duplicated region for block: B:862:0x128f  */
    /* JADX WARN: Removed duplicated region for block: B:864:0x1293  */
    /* JADX WARN: Removed duplicated region for block: B:891:0x12e7  */
    /* JADX WARN: Removed duplicated region for block: B:937:0x139c  */
    /* JADX WARN: Removed duplicated region for block: B:972:0x142e  */
    /* JADX WARN: Removed duplicated region for block: B:980:0x1450  */
    /* JADX WARN: Removed duplicated region for block: B:981:0x1456  */
    /* JADX WARN: Removed duplicated region for block: B:985:0x1461  */
    /* JADX WARN: Removed duplicated region for block: B:996:0x14b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean processUpdateArray(java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Update> r66, final java.util.ArrayList<ir.eitaa.tgnet.TLRPC$User> r67, final java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r68, boolean r69, final int r70) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 6295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.processUpdateArray(java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, boolean, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$304, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$304$MessagesController(ArrayList arrayList, ArrayList arrayList2) {
        putUsers(arrayList, false);
        putChats(arrayList2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$305, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$305$MessagesController(ArrayList arrayList, ArrayList arrayList2) {
        putUsers(arrayList, false);
        putChats(arrayList2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$306, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$306$MessagesController(TLRPC$TL_updateUserTyping tLRPC$TL_updateUserTyping) {
        getNotificationCenter().postNotificationName(NotificationCenter.onEmojiInteractionsReceived, Long.valueOf(tLRPC$TL_updateUserTyping.user_id), tLRPC$TL_updateUserTyping.action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$307, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$307$MessagesController(TLRPC$TL_updateChatUserTyping tLRPC$TL_updateChatUserTyping) {
        getNotificationCenter().postNotificationName(NotificationCenter.onEmojiInteractionsReceived, Long.valueOf(-tLRPC$TL_updateChatUserTyping.chat_id), tLRPC$TL_updateChatUserTyping.action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$309, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$309$MessagesController(final TLRPC$TL_updatePeerBlocked tLRPC$TL_updatePeerBlocked) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$WHN_LqrUOySuBbV7DtdcA06iE7Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdateArray$308$MessagesController(tLRPC$TL_updatePeerBlocked);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$308, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$308$MessagesController(TLRPC$TL_updatePeerBlocked tLRPC$TL_updatePeerBlocked) {
        long peerId = MessageObject.getPeerId(tLRPC$TL_updatePeerBlocked.peer_id);
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
    /* renamed from: lambda$processUpdateArray$310, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$310$MessagesController(TLRPC$TL_updateServiceNotification tLRPC$TL_updateServiceNotification) {
        getNotificationCenter().postNotificationName(NotificationCenter.needShowAlert, 2, tLRPC$TL_updateServiceNotification.message, tLRPC$TL_updateServiceNotification.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$311, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$311$MessagesController(TLRPC$TL_updateLangPack tLRPC$TL_updateLangPack) {
        LocaleController.getInstance().saveRemoteLocaleStringsForCurrentLocale(tLRPC$TL_updateLangPack.difference, this.currentAccount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$312, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$312$MessagesController(ArrayList arrayList) {
        getNotificationsController().processNewMessages(arrayList, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$313, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$313$MessagesController(final ArrayList arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$60XGS23sAW_Q1obfylgX4QmToS4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdateArray$312$MessagesController(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$314, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$314$MessagesController(LongSparseArray longSparseArray) {
        getNotificationsController().processEditedMessages(longSparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$315, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$315$MessagesController(final LongSparseArray longSparseArray) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$mPFfLkqrrLsHPgPEBy36wmSHZWU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdateArray$314$MessagesController(longSparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$316, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$316$MessagesController(TLRPC$User tLRPC$User) {
        getContactsController().addContactToPhoneBook(tLRPC$User, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$317, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$317$MessagesController() {
        getNotificationsController().deleteNotificationChannelGlobal(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$318, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$318$MessagesController() {
        getNotificationsController().deleteNotificationChannelGlobal(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$319, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$319$MessagesController() {
        getNotificationsController().deleteNotificationChannelGlobal(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$320, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$320$MessagesController(TLRPC$TL_updateChannel tLRPC$TL_updateChannel) {
        getChannelDifference(tLRPC$TL_updateChannel.channel_id, 1, 0L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$321, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$321$MessagesController(TLRPC$Chat tLRPC$Chat) {
        getNotificationCenter().postNotificationName(NotificationCenter.channelRightsUpdated, tLRPC$Chat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$322, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$322$MessagesController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x09c4 A[PHI: r2
      0x09c4: PHI (r2v41 long) = (r2v37 long), (r2v38 long) binds: [B:434:0x09c2, B:437:0x09ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:575:0x0d37  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0d53  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x0e04  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x0e12  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x0e18  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x0e24  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0e44  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x0e60  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x0e76  */
    /* JADX WARN: Removed duplicated region for block: B:676:? A[RETURN, SYNTHETIC] */
    /* renamed from: lambda$processUpdateArray$323, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processUpdateArray$323$MessagesController(int r39, java.util.ArrayList r40, androidx.collection.LongSparseArray r41, int r42, ir.eitaa.messenger.support.LongSparseIntArray r43, androidx.collection.LongSparseArray r44, androidx.collection.LongSparseArray r45, java.util.ArrayList r46, androidx.collection.LongSparseArray r47, androidx.collection.LongSparseArray r48, boolean r49, java.util.ArrayList r50, java.util.ArrayList r51, androidx.collection.LongSparseArray r52, androidx.collection.LongSparseArray r53, androidx.collection.LongSparseArray r54, java.util.ArrayList r55) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 3710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$processUpdateArray$323$MessagesController(int, java.util.ArrayList, androidx.collection.LongSparseArray, int, ir.eitaa.messenger.support.LongSparseIntArray, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, java.util.ArrayList, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, boolean, java.util.ArrayList, java.util.ArrayList, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$325, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$325$MessagesController(final LongSparseIntArray longSparseIntArray, final LongSparseIntArray longSparseIntArray2, final SparseIntArray sparseIntArray, final LongSparseArray longSparseArray, final LongSparseArray longSparseArray2, final LongSparseArray longSparseArray3, final LongSparseIntArray longSparseIntArray3) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$fX2MIpUTtDjybOAnUeyi-I0mcAo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdateArray$324$MessagesController(longSparseIntArray, longSparseIntArray2, sparseIntArray, longSparseArray, longSparseArray2, longSparseArray3, longSparseIntArray3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:97:0x026e  */
    /* renamed from: lambda$processUpdateArray$324, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processUpdateArray$324$MessagesController(ir.eitaa.messenger.support.LongSparseIntArray r20, ir.eitaa.messenger.support.LongSparseIntArray r21, android.util.SparseIntArray r22, androidx.collection.LongSparseArray r23, androidx.collection.LongSparseArray r24, androidx.collection.LongSparseArray r25, ir.eitaa.messenger.support.LongSparseIntArray r26) {
        /*
            Method dump skipped, instructions count: 731
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.lambda$processUpdateArray$324$MessagesController(ir.eitaa.messenger.support.LongSparseIntArray, ir.eitaa.messenger.support.LongSparseIntArray, android.util.SparseIntArray, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray, ir.eitaa.messenger.support.LongSparseIntArray):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$326, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$326$MessagesController(long j, ArrayList arrayList) {
        getMessagesStorage().updateDialogsWithDeletedMessages(j, -j, arrayList, getMessagesStorage().markMessagesAsDeleted(j, arrayList, false, true, false), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateArray$327, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateArray$327$MessagesController(long j, int i) {
        getMessagesStorage().updateDialogsWithDeletedMessages(j, -j, new ArrayList<>(), getMessagesStorage().markMessagesAsDeleted(j, i, false, true), false);
    }

    public boolean isDialogMuted(long dialogId) {
        return isDialogMuted(dialogId, null);
    }

    public boolean isDialogMuted(long dialogId, TLRPC$Chat chat) {
        Boolean boolValueOf;
        int i = this.notificationsPreferences.getInt("notify2_" + dialogId, -1);
        boolean z = false;
        if (i == -1) {
            if (chat != null) {
                if (ChatObject.isChannel(chat) && !chat.megagroup) {
                    z = true;
                }
                boolValueOf = Boolean.valueOf(z);
            } else {
                boolValueOf = null;
            }
            return !getNotificationsController().isGlobalNotificationsEnabled(dialogId, boolValueOf);
        }
        if (i == 2) {
            return true;
        }
        if (i == 3) {
            if (this.notificationsPreferences.getInt("notifyuntil_" + dialogId, 0) >= getConnectionsManager().getCurrentTime()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<MessageObject> getSponsoredMessages(final long dialogId) {
        SponsoredMessagesInfo sponsoredMessagesInfo = this.sponsoredMessages.get(dialogId);
        if (sponsoredMessagesInfo != null && sponsoredMessagesInfo.loading && Math.abs(SystemClock.elapsedRealtime() - sponsoredMessagesInfo.loadTime) <= 300000) {
            return sponsoredMessagesInfo.messages;
        }
        TLRPC$Chat chat = getChat(Long.valueOf(-dialogId));
        if (ChatObject.isChannel(chat) && !chat.megagroup && !chat.gigagroup && chat.sponsoredMessage) {
            final SponsoredMessagesInfo sponsoredMessagesInfo2 = new SponsoredMessagesInfo();
            sponsoredMessagesInfo2.loading = true;
            this.sponsoredMessages.put(dialogId, sponsoredMessagesInfo2);
            TLRPC$TL_channels_getSponsoredMessages tLRPC$TL_channels_getSponsoredMessages = new TLRPC$TL_channels_getSponsoredMessages();
            tLRPC$TL_channels_getSponsoredMessages.channel = getInputChannel(chat);
            getConnectionsManager().sendRequest(tLRPC$TL_channels_getSponsoredMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$QQV-Rlzos8ANqCJs5vt3Tipmsbw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$getSponsoredMessages$330$MessagesController(dialogId, sponsoredMessagesInfo2, tLObject, tLRPC$TL_error);
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getSponsoredMessages$330, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getSponsoredMessages$330$MessagesController(final long j, final SponsoredMessagesInfo sponsoredMessagesInfo, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        ArrayList arrayList = null;
        if (tLObject != null) {
            final TLRPC$TL_messages_sponsoredMessages tLRPC$TL_messages_sponsoredMessages = (TLRPC$TL_messages_sponsoredMessages) tLObject;
            if (!tLRPC$TL_messages_sponsoredMessages.messages.isEmpty()) {
                arrayList = new ArrayList();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ZL33jadymE-hhgDV_IbxpK2k6nE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getSponsoredMessages$328$MessagesController(tLRPC$TL_messages_sponsoredMessages);
                    }
                });
                LongSparseArray longSparseArray = new LongSparseArray();
                LongSparseArray longSparseArray2 = new LongSparseArray();
                int i = 0;
                for (int i2 = 0; i2 < tLRPC$TL_messages_sponsoredMessages.users.size(); i2++) {
                    TLRPC$User tLRPC$User = tLRPC$TL_messages_sponsoredMessages.users.get(i2);
                    longSparseArray.put(tLRPC$User.id, tLRPC$User);
                }
                for (int i3 = 0; i3 < tLRPC$TL_messages_sponsoredMessages.chats.size(); i3++) {
                    TLRPC$Chat tLRPC$Chat = tLRPC$TL_messages_sponsoredMessages.chats.get(i3);
                    longSparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
                }
                int i4 = -10000000;
                int size = tLRPC$TL_messages_sponsoredMessages.messages.size();
                while (i < size) {
                    TLRPC$TL_sponsoredMessage tLRPC$TL_sponsoredMessage = tLRPC$TL_messages_sponsoredMessages.messages.get(i);
                    TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
                    tLRPC$TL_message.message = tLRPC$TL_sponsoredMessage.message;
                    if (!tLRPC$TL_sponsoredMessage.entities.isEmpty()) {
                        tLRPC$TL_message.entities = tLRPC$TL_sponsoredMessage.entities;
                        tLRPC$TL_message.flags |= 128;
                    }
                    tLRPC$TL_message.peer_id = getPeer(j);
                    tLRPC$TL_message.from_id = tLRPC$TL_sponsoredMessage.from_id;
                    tLRPC$TL_message.flags |= Factory.DEVICE_HAS_CRAPPY_OPENSLES;
                    tLRPC$TL_message.date = getConnectionsManager().getCurrentTime();
                    int i5 = i4 - 1;
                    tLRPC$TL_message.id = i4;
                    MessageObject messageObject = new MessageObject(this.currentAccount, (TLRPC$Message) tLRPC$TL_message, (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, true, true);
                    messageObject.sponsoredId = tLRPC$TL_sponsoredMessage.random_id;
                    messageObject.botStartParam = tLRPC$TL_sponsoredMessage.start_param;
                    arrayList.add(messageObject);
                    i++;
                    i4 = i5;
                }
            }
        }
        final ArrayList arrayList2 = arrayList;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$jLxMpcjPMOpK6o777RnrPoukoFE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getSponsoredMessages$329$MessagesController(arrayList2, j, sponsoredMessagesInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getSponsoredMessages$328, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getSponsoredMessages$328$MessagesController(TLRPC$TL_messages_sponsoredMessages tLRPC$TL_messages_sponsoredMessages) {
        putUsers(tLRPC$TL_messages_sponsoredMessages.users, false);
        putChats(tLRPC$TL_messages_sponsoredMessages.chats, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getSponsoredMessages$329, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getSponsoredMessages$329$MessagesController(ArrayList arrayList, long j, SponsoredMessagesInfo sponsoredMessagesInfo) {
        if (arrayList != null) {
            sponsoredMessagesInfo.loadTime = SystemClock.elapsedRealtime();
            sponsoredMessagesInfo.messages = arrayList;
            getNotificationCenter().postNotificationName(NotificationCenter.didLoadSponsoredMessages, Long.valueOf(j), arrayList);
            return;
        }
        this.sponsoredMessages.remove(j);
    }

    public CharSequence getPrintingString(long dialogId, int threadId, boolean isDialog) {
        SparseArray<CharSequence> sparseArray;
        TLRPC$User user;
        TLRPC$UserStatus tLRPC$UserStatus;
        if ((!isDialog || !DialogObject.isUserDialog(dialogId) || (user = getUser(Long.valueOf(dialogId))) == null || (tLRPC$UserStatus = user.status) == null || tLRPC$UserStatus.expires >= 0) && (sparseArray = this.printingStrings.get(dialogId)) != null) {
            return sparseArray.get(threadId);
        }
        return null;
    }

    public Integer getPrintingStringType(long dialogId, int threadId) {
        SparseArray<Integer> sparseArray = this.printingStringsTypes.get(dialogId);
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(threadId);
    }

    private boolean updatePrintingUsersWithNewMessages(long uid, ArrayList<MessageObject> messages) {
        boolean z;
        if (uid > 0) {
            if (((ConcurrentHashMap) this.printingUsers.get(Long.valueOf(uid))) != null) {
                this.printingUsers.remove(Long.valueOf(uid));
                return true;
            }
        } else if (uid < 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<MessageObject> it = messages.iterator();
            while (it.hasNext()) {
                MessageObject next = it.next();
                if (next.isFromUser() && !arrayList.contains(Long.valueOf(next.messageOwner.from_id.user_id))) {
                    arrayList.add(Long.valueOf(next.messageOwner.from_id.user_id));
                }
            }
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.printingUsers.get(Long.valueOf(uid));
            if (concurrentHashMap != null) {
                ArrayList arrayList2 = null;
                z = false;
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    Integer num = (Integer) entry.getKey();
                    ArrayList arrayList3 = (ArrayList) entry.getValue();
                    int i = 0;
                    while (i < arrayList3.size()) {
                        if (arrayList.contains(Long.valueOf(((PrintingUser) arrayList3.get(i)).userId))) {
                            arrayList3.remove(i);
                            i--;
                            if (arrayList3.isEmpty()) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(num);
                            }
                            z = true;
                        }
                        i++;
                    }
                }
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        concurrentHashMap.remove(arrayList2.get(i2));
                    }
                    if (concurrentHashMap.isEmpty()) {
                        this.printingUsers.remove(Long.valueOf(uid));
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

    /* JADX WARN: Removed duplicated region for block: B:176:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean updateInterfaceWithMessages(final long r25, java.util.ArrayList<ir.eitaa.messenger.MessageObject> r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 976
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.updateInterfaceWithMessages(long, java.util.ArrayList, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateInterfaceWithMessages$331, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateInterfaceWithMessages$331$MessagesController(TLRPC$Dialog tLRPC$Dialog, int i, long j, int i2) {
        if (i2 == -1) {
            if (i <= 0 || DialogObject.isEncryptedDialog(j)) {
                return;
            }
            loadUnknownDialog(getInputPeer(j), 0L);
            return;
        }
        if (i2 != 0) {
            tLRPC$Dialog.folder_id = i2;
            sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
        }
    }

    public void addDialogAction(long did, boolean clean) {
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(did);
        if (tLRPC$Dialog == null) {
            return;
        }
        if (clean) {
            this.clearingHistoryDialogs.put(did, tLRPC$Dialog);
        } else {
            this.deletingDialogs.put(did, tLRPC$Dialog);
            this.allDialogs.remove(tLRPC$Dialog);
            sortDialogs(null);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    public void removeDialogAction(long did, boolean clean, boolean apply) {
        TLRPC$Dialog tLRPC$Dialog = this.dialogs_dict.get(did);
        if (tLRPC$Dialog == null) {
            return;
        }
        if (clean) {
            this.clearingHistoryDialogs.remove(did);
        } else {
            this.deletingDialogs.remove(did);
            if (!apply) {
                this.allDialogs.add(tLRPC$Dialog);
                sortDialogs(null);
            }
        }
        if (apply) {
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
    }

    public boolean isClearingDialog(long did) {
        return this.clearingHistoryDialogs.get(did) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sortDialogs(androidx.collection.LongSparseArray<ir.eitaa.tgnet.TLRPC$Chat> r16) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.sortDialogs(androidx.collection.LongSparseArray):void");
    }

    private void addDialogToItsFolder(int index, TLRPC$Dialog dialog) {
        int i = dialog instanceof TLRPC$TL_dialogFolder ? 0 : dialog.folder_id;
        ArrayList<TLRPC$Dialog> arrayList = this.dialogsByFolder.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.dialogsByFolder.put(i, arrayList);
        }
        if (index == -1) {
            arrayList.add(dialog);
            return;
        }
        if (index == -2) {
            if (arrayList.isEmpty() || !(arrayList.get(0) instanceof TLRPC$TL_dialogFolder)) {
                arrayList.add(0, dialog);
                return;
            } else {
                arrayList.add(1, dialog);
                return;
            }
        }
        arrayList.add(index, dialog);
    }

    public static String getRestrictionReason(ArrayList<TLRPC$TL_restrictionReason> reasons) {
        if (reasons.isEmpty()) {
            return null;
        }
        int size = reasons.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_restrictionReason tLRPC$TL_restrictionReason = reasons.get(i);
            if ("all".equals(tLRPC$TL_restrictionReason.platform) || !(BuildVars.isStandaloneApp() || BuildVars.isBetaApp() || !"android".equals(tLRPC$TL_restrictionReason.platform))) {
                return tLRPC$TL_restrictionReason.text;
            }
        }
        return null;
    }

    private static void showCantOpenAlert(BaseFragment fragment, String reason) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setMessage(reason);
        fragment.showDialog(builder.create());
    }

    public boolean checkCanOpenChat(Bundle bundle, BaseFragment fragment) {
        return checkCanOpenChat(bundle, fragment, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean checkCanOpenChat(final Bundle bundle, final BaseFragment baseFragment, MessageObject messageObject) {
        TLRPC$Chat chat;
        String restrictionReason;
        TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages;
        if (bundle != null && baseFragment != null) {
            long j = bundle.getLong("user_id", 0L);
            long j2 = bundle.getLong("chat_id", 0L);
            int i = bundle.getInt("message_id", 0);
            TLRPC$User user = null;
            if (j != 0) {
                user = getUser(Long.valueOf(j));
                chat = null;
            } else {
                chat = j2 != 0 ? getChat(Long.valueOf(j2)) : null;
            }
            if (user == null && chat == null) {
                return true;
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
            if (i != 0 && messageObject != null && chat != null && chat.access_hash == 0) {
                long dialogId = messageObject.getDialogId();
                if (!DialogObject.isEncryptedDialog(dialogId)) {
                    final AlertDialog alertDialog = new AlertDialog(baseFragment.getParentActivity(), 3);
                    if (dialogId < 0) {
                        chat = getChat(Long.valueOf(-dialogId));
                    }
                    if (dialogId > 0 || !ChatObject.isChannel(chat)) {
                        TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages2 = new TLRPC$TL_messages_getMessages();
                        tLRPC$TL_messages_getMessages2.id.add(Integer.valueOf(messageObject.getId()));
                        tLRPC$TL_messages_getMessages = tLRPC$TL_messages_getMessages2;
                    } else {
                        TLRPC$Chat chat2 = getChat(Long.valueOf(-dialogId));
                        TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                        tLRPC$TL_channels_getMessages.channel = getInputChannel(chat2);
                        tLRPC$TL_channels_getMessages.id.add(Integer.valueOf(messageObject.getId()));
                        tLRPC$TL_messages_getMessages = tLRPC$TL_channels_getMessages;
                    }
                    final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$2KllC_Rx0OExhmu4Iox4qruLBnQ
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$checkCanOpenChat$333$MessagesController(alertDialog, baseFragment, bundle, tLObject, tLRPC$TL_error);
                        }
                    });
                    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$cQJERYQjwTNv6dDaRj2nvhJJ1kM
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            this.f$0.lambda$checkCanOpenChat$334$MessagesController(iSendRequest, baseFragment, dialogInterface);
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
    /* renamed from: lambda$checkCanOpenChat$333, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkCanOpenChat$333$MessagesController(final AlertDialog alertDialog, final BaseFragment baseFragment, final Bundle bundle, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$d1GrdNixIuZPm8YbvGNo102lktg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkCanOpenChat$332$MessagesController(alertDialog, tLObject, baseFragment, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkCanOpenChat$332, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkCanOpenChat$332$MessagesController(AlertDialog alertDialog, TLObject tLObject, BaseFragment baseFragment, Bundle bundle) {
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
    /* renamed from: lambda$checkCanOpenChat$334, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkCanOpenChat$334$MessagesController(int i, BaseFragment baseFragment, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
        baseFragment.setVisibleDialog(null);
    }

    public static void openChatOrProfileWith(TLRPC$User user, TLRPC$Chat chat, BaseFragment fragment, int type, boolean closeLast) {
        String restrictionReason;
        if ((user == null && chat == null) || fragment == null) {
            return;
        }
        if (chat != null) {
            restrictionReason = getRestrictionReason(chat.restriction_reason);
        } else {
            restrictionReason = getRestrictionReason(user.restriction_reason);
            if (type != 3 && user.bot) {
                type = 1;
                closeLast = true;
            }
        }
        if (restrictionReason != null) {
            showCantOpenAlert(fragment, restrictionReason);
            return;
        }
        Bundle bundle = new Bundle();
        if (chat != null) {
            bundle.putLong("chat_id", chat.id);
        } else {
            bundle.putLong("user_id", user.id);
        }
        if (type == 0) {
            fragment.presentFragment(new ProfileActivity(bundle));
            return;
        }
        if (type == 2) {
            fragment.presentFragment(new ChatActivity(bundle), true, true);
        } else if (chat != null && chat.isMediaContent) {
            bundle.putLong("dialog_id", -chat.id);
            fragment.presentFragment(new MediaChannelActivity(bundle), closeLast);
        } else {
            fragment.presentFragment(new ChatActivity(bundle), closeLast);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void openByUserName(java.lang.String r6, final ir.eitaa.ui.ActionBar.BaseFragment r7, final int r8) {
        /*
            r5 = this;
            if (r6 == 0) goto L69
            if (r7 != 0) goto L6
            goto L69
        L6:
            ir.eitaa.tgnet.TLObject r0 = r5.getUserOrChat(r6)
            boolean r1 = r0 instanceof ir.eitaa.tgnet.TLRPC$User
            r2 = 0
            if (r1 == 0) goto L18
            ir.eitaa.tgnet.TLRPC$User r0 = (ir.eitaa.tgnet.TLRPC$User) r0
            boolean r1 = r0.min
            if (r1 == 0) goto L16
            goto L26
        L16:
            r1 = r2
            goto L28
        L18:
            boolean r1 = r0 instanceof ir.eitaa.tgnet.TLRPC$Chat
            if (r1 == 0) goto L26
            ir.eitaa.tgnet.TLRPC$Chat r0 = (ir.eitaa.tgnet.TLRPC$Chat) r0
            boolean r1 = r0.min
            if (r1 == 0) goto L23
            goto L26
        L23:
            r1 = r0
            r0 = r2
            goto L28
        L26:
            r0 = r2
            r1 = r0
        L28:
            r3 = 0
            if (r0 == 0) goto L2f
            openChatOrProfileWith(r0, r2, r7, r8, r3)
            goto L69
        L2f:
            r0 = 1
            if (r1 == 0) goto L36
            openChatOrProfileWith(r2, r1, r7, r0, r3)
            goto L69
        L36:
            android.app.Activity r1 = r7.getParentActivity()
            if (r1 != 0) goto L3d
            return
        L3d:
            ir.eitaa.ui.ActionBar.AlertDialog[] r0 = new ir.eitaa.ui.ActionBar.AlertDialog[r0]
            ir.eitaa.ui.ActionBar.AlertDialog r1 = new ir.eitaa.ui.ActionBar.AlertDialog
            android.app.Activity r2 = r7.getParentActivity()
            r4 = 3
            r1.<init>(r2, r4)
            r0[r3] = r1
            ir.eitaa.tgnet.TLRPC$TL_contacts_resolveUsername r1 = new ir.eitaa.tgnet.TLRPC$TL_contacts_resolveUsername
            r1.<init>()
            r1.username = r6
            ir.eitaa.tgnet.ConnectionsManager r6 = r5.getConnectionsManager()
            ir.eitaa.messenger.-$$Lambda$MessagesController$9yyE7HHSFrNJP1icgA7UwICXbHo r2 = new ir.eitaa.messenger.-$$Lambda$MessagesController$9yyE7HHSFrNJP1icgA7UwICXbHo
            r2.<init>()
            int r6 = r6.sendRequest(r1, r2)
            ir.eitaa.messenger.-$$Lambda$MessagesController$aVuVc86OADBU9FHdeX9kPrYOt7o r8 = new ir.eitaa.messenger.-$$Lambda$MessagesController$aVuVc86OADBU9FHdeX9kPrYOt7o
            r8.<init>()
            r6 = 500(0x1f4, double:2.47E-321)
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r8, r6)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesController.openByUserName(java.lang.String, ir.eitaa.ui.ActionBar.BaseFragment, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openByUserName$336, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openByUserName$336$MessagesController(final AlertDialog[] alertDialogArr, final BaseFragment baseFragment, final int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$Zy-pTMK_JLEG8-aXZIM8k1I9EMs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openByUserName$335$MessagesController(alertDialogArr, baseFragment, tLRPC$TL_error, tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openByUserName$335, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openByUserName$335$MessagesController(AlertDialog[] alertDialogArr, BaseFragment baseFragment, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i) {
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
                openChatOrProfileWith(null, tLRPC$TL_contacts_resolvedPeer.chats.get(0), baseFragment, 1, false);
                return;
            } else {
                if (tLRPC$TL_contacts_resolvedPeer.users.isEmpty()) {
                    return;
                }
                openChatOrProfileWith(tLRPC$TL_contacts_resolvedPeer.users.get(0), null, baseFragment, i, false);
                return;
            }
        }
        if (baseFragment.getParentActivity() != null) {
            try {
                BulletinFactory.of(baseFragment).createErrorBulletin(LocaleController.getString("NoUsernameFound", R.string.NoUsernameFound)).show();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openByUserName$338, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openByUserName$338$MessagesController(AlertDialog[] alertDialogArr, final int i, BaseFragment baseFragment) {
        if (alertDialogArr[0] == null) {
            return;
        }
        alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$ahVjqr5GrYxMIQjYug4Ljy_qzZw
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$openByUserName$337$MessagesController(i, dialogInterface);
            }
        });
        baseFragment.showDialog(alertDialogArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openByUserName$337, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openByUserName$337$MessagesController(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }

    public void ensureMessagesLoaded(final long dialogId, int messageId, final MessagesLoadedCallback callback) {
        int i;
        SharedPreferences notificationsSettings = getNotificationsSettings(this.currentAccount);
        if (messageId == 0) {
            i = notificationsSettings.getInt("diditem" + dialogId, 0);
        } else {
            i = messageId;
        }
        final int iGenerateClassGuid = ConnectionsManager.generateClassGuid();
        final long j = DialogObject.isChatDialog(dialogId) ? -dialogId : 0L;
        if (j != 0 && getMessagesController().getChat(Long.valueOf(j)) == null) {
            final MessagesStorage messagesStorage = getMessagesStorage();
            final int i2 = i;
            messagesStorage.getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$rnaVlOUJTg6NYneXAjw7XYaWrkk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$ensureMessagesLoaded$340$MessagesController(messagesStorage, j, dialogId, i2, callback);
                }
            });
            return;
        }
        int i3 = AndroidUtilities.isTablet() ? 30 : 20;
        final int i4 = i3;
        final int i5 = i;
        NotificationCenter.NotificationCenterDelegate notificationCenterDelegate = new NotificationCenter.NotificationCenterDelegate() { // from class: ir.eitaa.messenger.MessagesController.7
            @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
            public void didReceivedNotification(int id, int account, Object... args) {
                int i6 = NotificationCenter.messagesDidLoadWithoutProcess;
                if (id == i6 && ((Integer) args[0]).intValue() == iGenerateClassGuid) {
                    int iIntValue = ((Integer) args[1]).intValue();
                    boolean zBooleanValue = ((Boolean) args[2]).booleanValue();
                    boolean zBooleanValue2 = ((Boolean) args[3]).booleanValue();
                    int iIntValue2 = ((Integer) args[4]).intValue();
                    int i7 = i4;
                    if (iIntValue < i7 / 2 && !zBooleanValue2 && zBooleanValue) {
                        int i8 = i5;
                        if (i8 != 0) {
                            MessagesController.this.loadMessagesInternal(dialogId, 0L, false, i7, i8, 0, false, 0, iGenerateClassGuid, 3, iIntValue2, 0, 0, 0, 0, 0, 0, false, 0, true, false);
                            return;
                        } else {
                            MessagesController.this.loadMessagesInternal(dialogId, 0L, false, i7, i8, 0, false, 0, iGenerateClassGuid, 2, iIntValue2, 0, 0, 0, 0, 0, 0, false, 0, true, false);
                            return;
                        }
                    }
                    MessagesController.this.getNotificationCenter().removeObserver(this, i6);
                    MessagesController.this.getNotificationCenter().removeObserver(this, NotificationCenter.loadingMessagesFailed);
                    MessagesLoadedCallback messagesLoadedCallback = callback;
                    if (messagesLoadedCallback != null) {
                        messagesLoadedCallback.onMessagesLoaded(zBooleanValue);
                        return;
                    }
                    return;
                }
                int i9 = NotificationCenter.loadingMessagesFailed;
                if (id == i9 && ((Integer) args[0]).intValue() == iGenerateClassGuid) {
                    MessagesController.this.getNotificationCenter().removeObserver(this, i6);
                    MessagesController.this.getNotificationCenter().removeObserver(this, i9);
                    MessagesLoadedCallback messagesLoadedCallback2 = callback;
                    if (messagesLoadedCallback2 != null) {
                        messagesLoadedCallback2.onError();
                    }
                }
            }
        };
        getNotificationCenter().addObserver(notificationCenterDelegate, NotificationCenter.messagesDidLoadWithoutProcess);
        getNotificationCenter().addObserver(notificationCenterDelegate, NotificationCenter.loadingMessagesFailed);
        if (i != 0) {
            loadMessagesInternal(dialogId, 0L, true, i3, i, 0, true, 0, iGenerateClassGuid, 3, 0, 0, 0, 0, 0, 0, 0, false, 0, true, false);
        } else {
            loadMessagesInternal(dialogId, 0L, true, i3, i, 0, true, 0, iGenerateClassGuid, 2, 0, 0, 0, 0, 0, 0, 0, false, 0, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$ensureMessagesLoaded$340, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$ensureMessagesLoaded$340$MessagesController(MessagesStorage messagesStorage, long j, final long j2, final int i, final MessagesLoadedCallback messagesLoadedCallback) {
        final TLRPC$Chat chat = messagesStorage.getChat(j);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesController$IagFbKRnm0SMlWFCGkTF8sQ6sF8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$ensureMessagesLoaded$339$MessagesController(chat, j2, i, messagesLoadedCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$ensureMessagesLoaded$339, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$ensureMessagesLoaded$339$MessagesController(TLRPC$Chat tLRPC$Chat, long j, int i, MessagesLoadedCallback messagesLoadedCallback) {
        if (tLRPC$Chat != null) {
            getMessagesController().putChat(tLRPC$Chat, true);
            ensureMessagesLoaded(j, i, messagesLoadedCallback);
        } else if (messagesLoadedCallback != null) {
            messagesLoadedCallback.onError();
        }
    }

    public boolean isDialogFavorite(ArrayList<Long> dialog_id) {
        Iterator<Long> it = dialog_id.iterator();
        int i = 0;
        while (it.hasNext()) {
            Long next = it.next();
            i = this.favoritesPreferences.getInt("isFav_" + next, 0);
            if (i == 0) {
                break;
            }
        }
        return i == 1;
    }

    public void setDialogFavorites(ArrayList<Long> dialog_id, boolean addToFavorite) {
        Iterator<Long> it = dialog_id.iterator();
        while (it.hasNext()) {
            Long next = it.next();
            if (addToFavorite) {
                this.favoritesPreferences.edit().putInt("isFav_" + next, 1).apply();
            } else {
                this.favoritesPreferences.edit().remove("isFav_" + next).apply();
            }
        }
    }

    private void addToLockedDialogs(long id) {
        for (int i = 0; i < this.lockedDialogsId.size(); i++) {
            if (this.lockedDialogsId.contains(Long.valueOf(id))) {
                return;
            }
        }
        this.lockedDialogsId.add(Long.valueOf(id));
    }

    public boolean isLockedDialog(TLRPC$Dialog dialog) {
        return ((dialog.flags & 1048576) != 0 || dialog.isLocked || this.lockedDialogsId.contains(Long.valueOf(dialog.id))) && SharedConfig.chatLockPasscodeHash.length() != 0;
    }

    public boolean isLockedDialog(Long id) {
        return this.lockedDialogsId.contains(id) && SharedConfig.chatLockPasscodeHash.length() != 0;
    }

    public boolean isLockedChatOrUser(Long id) {
        for (int i = 0; i < this.lockedDialogsId.size(); i++) {
            if (MessagesController$$ExternalSynthetic0.m0(this.lockedDialogsId.get(i).longValue(), id.longValue()) == 0 && SharedConfig.chatLockPasscodeHash.length() != 0) {
                return true;
            }
        }
        return false;
    }
}
