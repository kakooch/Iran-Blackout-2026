package ir.aaap.messengercore;

import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.MessageUtils;
import ir.aaap.messengercore.model.AuxDataObject;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatInviteObject;
import ir.aaap.messengercore.model.ChatReactionSetting;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.CheckChannelsWithUsernameResult;
import ir.aaap.messengercore.model.DialogFilterSuggested;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.FolderObject;
import ir.aaap.messengercore.model.ForwardMessageResult;
import ir.aaap.messengercore.model.GetFileResult;
import ir.aaap.messengercore.model.GetGroupMessageReadParticipantsResult;
import ir.aaap.messengercore.model.GetLinkFromAppUrlOutput;
import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.InChatMember;
import ir.aaap.messengercore.model.LiveLocationInfo;
import ir.aaap.messengercore.model.LiveLocationObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MapViewObject;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageReactionObject;
import ir.aaap.messengercore.model.MessengerUpdateObject;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.aaap.messengercore.model.PinMessageResult;
import ir.aaap.messengercore.model.PollModels;
import ir.aaap.messengercore.model.ReactionObject;
import ir.aaap.messengercore.model.RubinoPostData;
import ir.aaap.messengercore.model.RubinoStoryData;
import ir.aaap.messengercore.model.SearchChatMessagesResult;
import ir.aaap.messengercore.model.SendChatActivityInput;
import ir.aaap.messengercore.model.SendFileResult;
import ir.aaap.messengercore.model.SendMessageResult;
import ir.aaap.messengercore.model.SettingModels;
import ir.aaap.messengercore.model.SortedContactResult;
import ir.aaap.messengercore.model.StickerObject;
import ir.aaap.messengercore.model.StickerSetObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.VoiceCallModels;
import ir.aaap.messengercore.model.WalletTransferMessageObject;
import ir.aaap.messengercore.model.api.ActionOnChatAdsInput;
import ir.aaap.messengercore.model.api.ActionOnStickersOutput;
import ir.aaap.messengercore.model.api.BotModels;
import ir.aaap.messengercore.model.api.ChangeOwnerModels;
import ir.aaap.messengercore.model.api.ChatAdsObject;
import ir.aaap.messengercore.model.api.DeleteMessagesInput;
import ir.aaap.messengercore.model.api.DisableTwoStepByForgetPasswordOutput;
import ir.aaap.messengercore.model.api.GetAllStatisticsOutput;
import ir.aaap.messengercore.model.api.GetBlockedUsersOutput;
import ir.aaap.messengercore.model.api.GetMessageShareUrlOutput;
import ir.aaap.messengercore.model.api.GetMySessionsOutput;
import ir.aaap.messengercore.model.api.GetProfileLinkItemsOutputs;
import ir.aaap.messengercore.model.api.GetStickersByEmojiOutput;
import ir.aaap.messengercore.model.api.GetStickersOutput;
import ir.aaap.messengercore.model.api.InSearchObject;
import ir.aaap.messengercore.model.api.LoginDisableTwoStepOutput;
import ir.aaap.messengercore.model.api.LoginTwoStepForgetPasswordOutput;
import ir.aaap.messengercore.model.api.PrivacySettings;
import ir.aaap.messengercore.model.api.ReportObjectInput;
import ir.aaap.messengercore.model.api.RequestChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.RequestSendFileOutput;
import ir.aaap.messengercore.model.api.SearchGlobalMessagesOutput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsInput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsOutput;
import ir.aaap.messengercore.model.api.SendCodeOutput;
import ir.aaap.messengercore.model.api.SendFileInput;
import ir.aaap.messengercore.model.api.TwoPasscodeStatusOutput;
import ir.aaap.messengercore.model.api.TwoStepStatusObject;
import ir.aaap.messengercore.model.api.UpdateChannelUsernameOutput;
import ir.aaap.messengercore.model.api.UpdateUserUsernameOutput;
import ir.aaap.messengercore.model.api.VerifyChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.VerifyRecoveryEmailOutput;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface CoreMainClass {

    public interface FileLoadResponseListener {
        void onFileDidLoad(GetFileResult getFileResult);

        void onFileLoadingFailed();
    }

    public interface FileUpLoadResponseListener {
        void onFileDidUpload(SendFileResult sendFileResult);

        void onFileUploadingFailed();
    }

    void abortSetRecoveryEmail(String str, LoadListener<TwoStepStatusObject> loadListener);

    void abortTwoStepSetup(LoadListener<Integer> loadListener);

    void acceptCall(String str, int i, int i2, ArrayList<String> arrayList, LoadListener<String> loadListener);

    void acceptRequestObjectOwner(String str, LoadListener<Integer> loadListener);

    void actionOnChatAds(String str, ActionOnChatAdsInput.Action action);

    void actionOnMessageReaction(String str, long j, String str2, boolean z, LoadListener<ArrayList<MessageReactionObject>> loadListener);

    int addChannel(String str, ArrayList<String> arrayList, String str2, boolean z, String str3, String str4, LoadListener<String> loadListener);

    void addChannelMembers(String str, ArrayList<String> arrayList, LoadListener<ArrayList<InChatMember>> loadListener);

    void addContact(String str, String str2, String str3, LoadListener<String> loadListener);

    void addFavoriteSticker(ArrayList<StickerObject> arrayList, long j, boolean z);

    int addGroup(String str, ArrayList<String> arrayList, String str2, String str3, LoadListener<String> loadListener);

    void addGroupMembers(String str, ArrayList<String> arrayList, LoadListener<ArrayList<InChatMember>> loadListener);

    int addLiveComment(String str, String str2, String str3, LoadListener<LiveModels.AddLiveCommentOutput> loadListener);

    void addLiveLocationInfo(LiveLocationInfo liveLocationInfo);

    void addOrEditFolder(String str, int i, String str2, ArrayList<ObjectGuidType> arrayList, ArrayList<ObjectGuidType> arrayList2, String str3, LoadListener<FolderObject> loadListener);

    void addRecentChat(String str);

    void addRecentGif(FileInlineObject fileInlineObject, long j);

    void addRecentSticker(ArrayList<StickerObject> arrayList, long j, boolean z);

    void addSentFile(String str, FileInlineObject fileInlineObject);

    void addStickerSet(String str, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener);

    void addToMyGifSet(String str, long j, FileInlineObject fileInlineObject, LoadListener<Integer> loadListener);

    void addWallpaperSetThemeBackground(long j, String str, long j2, String str2, String str3, LoadListener<SettingModels.AddWallpaperSetThemeBackgroundOutput> loadListener);

    void archiveStickerSet(String str, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener);

    void banChannelMember(String str, String str2, boolean z, LoadListener<Integer> loadListener);

    void banGroupMember(String str, String str2, boolean z, LoadListener<Integer> loadListener);

    int callEditMessage(String str, Message message, LoadListener<Integer> loadListener);

    int callForwardMessage(String str, String str2, ChatType chatType, ArrayList<Long> arrayList, int i, LoadListener<ForwardMessageResult> loadListener);

    int callSendMessage(String str, ChatType chatType, Message message, boolean z, LoadListener<SendMessageResult> loadListener);

    int callStarted(String str);

    boolean canDeleteAvatar(String str);

    boolean canDeleteGlobalAllMessages(String str);

    boolean canDeleteGlobalMyMessage(String str);

    boolean canDeleteLocalMessage(String str);

    boolean canGetGroupMessageReadParticipants(String str, long j);

    boolean canRemoveObject(String str);

    boolean canSendMessage(String str);

    boolean canSetAccess(String str);

    boolean canSetLink(String str);

    boolean canSetType(String str);

    boolean canShowReactions(String str, ChatType chatType);

    boolean canViewMembers(String str);

    void cancelChangeObjectOwner(String str, LoadListener<Integer> loadListener);

    void cancelEditMessage(String str, Message message, int i);

    void cancelGetFile(int i);

    void cancelRefreshObjectInfo(String str);

    void cancelRequest(int i);

    void cancelSendingMessage(String str, long j, int i);

    void changeChatLocalCountUnseen(String str, int i);

    void changePassword(String str, String str2, String str3, LoadListener<TwoStepStatusObject> loadListener);

    int channelPreviewByJoinLink(String str, LoadListener<ChatInviteObject> loadListener);

    int checkChannelUsername(String str, LoadListener<CoreUtilities.UsernameCheckType> loadListener);

    int checkChannelsWithUsername(LoadListener<CheckChannelsWithUsernameResult> loadListener);

    int checkRubinoUsername(String str, LoadListener<CoreUtilities.UsernameCheckType> loadListener);

    void checkTwoStepPasscode(String str, LoadListener<Boolean> loadListener);

    int checkUserUsername(String str, LoadListener<CoreUtilities.UsernameCheckType> loadListener);

    int clearChatHistory(String str, ChatType chatType, long j, LoadListener<String> loadListener);

    void clearDataBaseAndStorageForDebug();

    void clickMessageUrl(String str, String str2, String str3);

    void deleteAvatar(String str, String str2, LoadListener<AvatarFileInline> loadListener);

    void deleteChannel(String str, LoadListener<String> loadListener);

    int deleteChat(String str, ChatType chatType, long j, LoadListener<String> loadListener);

    void deleteContact(String str, LoadListener<Integer> loadListener);

    void deleteFolder(String str, LoadListener<String> loadListener);

    void deleteGroup(String str, LoadListener<String> loadListener);

    void deleteMessages(String str, ArrayList<Long> arrayList, DeleteMessagesInput.DeleteMessagesType deleteMessagesType, LoadListener<Integer> loadListener);

    void disableTwoStepByForgetPassword(String str, LoadListener<DisableTwoStepByForgetPasswordOutput.StatusEnum> loadListener);

    void discardCall(String str, int i, VoiceCallModels.EnumDiscardCallReason enumDiscardCallReason, LoadListener<Integer> loadListener);

    void discardGroupVoiceChat(String str, String str2, LoadListener<Integer> loadListener);

    int editChannelInfo(String str, ChatReactionSetting chatReactionSetting, LoadListener<String> loadListener);

    int editChannelInfo(String str, String str2, String str3, boolean z, boolean z2, LoadListener<String> loadListener);

    int editGroupAvailableReactions(String str, ChatReactionSetting chatReactionSetting, LoadListener<String> loadListener);

    int editGroupInfo(String str, String str2, String str3, boolean z, boolean z2, LoadListener<String> loadListener);

    int editGroupSlowMode(String str, int i, LoadListener<String> loadListener);

    boolean equalsCurrentDeviceHash(String str);

    Chat forceGetChatInstant(String str);

    void forceGetFolders();

    void forceRegisterDevice(boolean z);

    ChatAbsObject getAbsInstant(String str);

    void getAllChannelStatistics(String str, LoadListener<GetAllStatisticsOutput> loadListener);

    void getAllChatHints(boolean z, LoadListener<ArrayList<ChatAbsObject>> loadListener);

    void getAllRecentChatGuid(boolean z, LoadListener<ArrayList<InSearchObject>> loadListener);

    void getAllRecentGif(LoadListener<ArrayList<FileInlineObject>> loadListener);

    int getAllUnreadCountAccount();

    ArrayList<Message> getAllUnsentMessages(Set<Integer> set);

    SettingModels.AppearanceSettingObject getAppearanceSettingInstant();

    String getAuth();

    ArrayList<ReactionObject> getAvailableReactions();

    void getAvatars(String str, GetAvatarsListener getAvatarsListener);

    void getBlockedUsers(String str, LoadListener<GetBlockedUsersOutput> loadListener);

    int getBotSelectionItems(String str, String str2, String str3, LoadListener<BotModels.GetBotSelectionOutput> loadListener);

    void getCalls(boolean z, String str, VoiceCallModels.FilterTypeEnum filterTypeEnum, LoadListener<VoiceCallModels.GetCallsOutput> loadListener);

    void getChannelAdminAccessList(String str, String str2, GetChannelAdminAccessListListener getChannelAdminAccessListListener);

    int getChannelAdmins(String str, String str2, String str3, GetMemberListener getMemberListener);

    int getChannelAllMembers(String str, String str2, String str3, GetMemberListener getMemberListener);

    int getChannelBannedMembers(String str, String str2, String str3, GetMemberListener getMemberListener);

    void getChannelLink(String str, LoadListener<String> loadListener);

    void getChannelMessagesSeenCount(String str, long j, long j2);

    int getChannelNotAdminMembers(String str, String str2, String str3, GetMemberListener getMemberListener);

    void getChatAbs(String str, LoadListener<ChatAbsObject> loadListener);

    ArrayList<ChatAdsObject> getChatAdsInstant();

    Chat getChatInstant(String str);

    boolean getChatListHasContinue();

    ArrayList<Chat> getChatListInstant();

    void getChatReaction(String str, long j, long j2);

    int getCommonGroups(String str, LoadListener<ArrayList<ChatAbsObject>> loadListener);

    void getContactAndImportPhoneBookIfNeeded(boolean z, boolean z2);

    void getCurrentLiveLocation(String str, long j, String str2, LoadListener<LiveLocationObject> loadListener);

    SettingModels.DataSettingObject getDataSettingInstant();

    int getDiffForOnline();

    void getDisplayAsInGroupVoiceChat(String str, String str2, LoadListener<GroupCallModels.GetDisplayAsInGroupVoiceChatOutput> loadListener);

    int getExternalFile(String str, FileLoadResponseListener fileLoadResponseListener);

    ArrayList<StickerObject> getFavoriteStickersInstant();

    int getFile(String str, String str2, long j, long j2, String str3, String str4, FileLoadResponseListener fileLoadResponseListener);

    ArrayList<FolderObject> getFolderListInstant();

    int getFolderUnreadCount(String str);

    void getGroupAdminAccessList(String str, String str2, GetGroupAdminAccessListListener getGroupAdminAccessListListener);

    int getGroupAdmins(String str, String str2, String str3, GetMemberListener getMemberListener);

    int getGroupAllMembers(String str, String str2, String str3, GetMemberListener getMemberListener);

    int getGroupBannedMembers(String str, String str2, String str3, GetMemberListener getMemberListener);

    void getGroupDefaultAccessList(String str, GetGroupDefaultAccessListListener getGroupDefaultAccessListListener);

    void getGroupLink(String str, LoadListener<String> loadListener);

    int getGroupMentionList(String str, String str2, String str3, GetMemberListener getMemberListener);

    int getGroupMessageReadParticipants(String str, long j, LoadListener<GetGroupMessageReadParticipantsResult> loadListener);

    int getGroupNotAdminMembers(String str, String str2, String str3, GetMemberListener getMemberListener);

    int getGroupOnlineCount(String str);

    void getGroupVoiceChat(String str, String str2, LoadListener<GroupCallModels.GroupVoiceChat> loadListener);

    void getGroupVoiceChatParticipants(String str, String str2, String str3, LoadListener<GroupCallModels.GetGroupVoiceChatParticipantsOutput> loadListener);

    void getGroupVoiceChatUpdates(String str, String str2, String str3, LoadListener<GroupCallModels.GetGroupVoiceChatUpdatesResult> loadListener);

    String getHiddenWarningId(String str);

    LiveModels.LastLiveState getLastLiveState();

    int getLinkFromAppUrl(String str, LoadListener<GetLinkFromAppUrlOutput> loadListener);

    int getLiveComments(String str, String str2, String str3, LoadListener<LiveModels.GetLiveCommentsOutput> loadListener);

    void getLiveLocationInfoArray(LoadListener<ArrayList<LiveLocationInfo>> loadListener);

    int getLivePlayUrl(String str, String str2, LoadListener<LiveModels.GetLivePlayUrlResult> loadListener);

    int getLiveStatus(String str, String str2, LiveModels.GetLiveStatusType getLiveStatusType);

    int getLiveViewers(String str, String str2, LoadListener<LiveModels.GetLiveViewersOutput> loadListener);

    int getMapView(LocationObject locationObject, LoadListener<MapViewObject> loadListener);

    int getMaxFoldersCount();

    Message getMessageInstant(String str, long j);

    void getMessageReactions(String str, ChatType chatType, long j, String str2, LoadListener<SettingModels.GetMessageReactionsOutput> loadListener);

    void getMessageShareUrl(String str, long j, LoadListener<GetMessageShareUrlOutput> loadListener);

    void getMyArchivedStickerSets(String str, String str2, LoadListener<GetStickersOutput> loadListener);

    String getMyGuid();

    int getMySessions(LoadListener<GetMySessionsOutput> loadListener);

    ArrayList<StickerSetObject> getMyStickerSetInstant();

    UserInfo getMyUserInfo();

    long getNewGroupedMessageId();

    SettingModels.NotificationSettingObject getNotificationSettingInstant(boolean z);

    int getObjectInfoByUsername(String str, boolean z, LoadListener<String> loadListener);

    ObjectInfo getObjectInfoInstant(String str);

    void getPendingObjectOwner(String str, LoadListener<ChangeOwnerModels.GetPendingObjectOwnerOutput> loadListener);

    int getPollOptionVoters(String str, String str2, String str3, LoadListener<PollModels.GetPollOptionVotersOutput> loadListener);

    int getPollStatus(String str, ChatType chatType, long j, String str2);

    void getPrivacySettingFromServer(LoadListener<PrivacySettings> loadListener);

    PrivacySettings getPrivacySettingInstant();

    int getProfileLinkItems(String str, LoadListener<GetProfileLinkItemsOutputs> loadListener);

    ArrayList<StickerObject> getRecentStickersInstant();

    long getRnd();

    FileInlineObject getSentFile(String str);

    int getServerTimeDiffMillis();

    int getSignalingData(String str);

    String getSocketUrl(int i);

    SortedContactResult getSortedContactListInstant();

    StickerSetObject getStickerSetByIdInstant(String str);

    SettingModels.StickerSettingObject getStickerSettingInstant();

    void getStickersByEmoji(String str, String str2, LoadListener<GetStickersByEmojiOutput> loadListener);

    ArrayList<StickerObject> getStickersBySetIdInstant(String str);

    void getStickersSetById(String str, LoadListener<Integer> loadListener);

    ArrayList<DialogFilterSuggested> getSuggestedFolderListInstant();

    SettingModels.GetThemesOutput getThemesInstant();

    long getTimeMillis();

    void getTrendStickerSet(boolean z, String str, LoadListener<GetStickersOutput> loadListener);

    void getTwoPasscodeStatus(LoadListener<TwoPasscodeStatusOutput> loadListener);

    void getUpdate();

    String getUrlByCdnTag(String str, String str2);

    int getWalletTransferMessage(String str, String str2, LoadListener<WalletTransferMessageObject> loadListener);

    void getWallpapers(LoadListener<SettingModels.WallpapersOutput> loadListener);

    int groupPreviewByJoinLink(String str, LoadListener<ChatInviteObject> loadListener);

    void handleMessengerNotification(MessengerUpdateObject messengerUpdateObject, boolean z);

    boolean hasAccessToViewSettingPage(String str);

    boolean hasAccessToViewStats(String str);

    boolean hasMessageReply(String str, long j);

    void initAndLoadMyStickersIfNeeded(boolean z);

    void initChatMapFromDbIfNeeded();

    void initFolders();

    void initMessenger();

    void initSettingIfNeeded();

    boolean isAccountLoggedIn();

    boolean isBot(String str);

    boolean isChannel(String str);

    boolean isChannelPrivate(String str);

    boolean isChatListInited();

    boolean isContact(String str);

    boolean isCoreInitiated();

    boolean isGroupChannel(String str);

    boolean isOnline(int i);

    boolean isService(String str);

    void joinChannel(String str, LoadListener<String> loadListener);

    void joinChannelByLink(String str, LoadListener<String> loadListener);

    void joinGroup(String str, String str2, LoadListener<String> loadListener);

    void joinGroupVoiceChat(String str, String str2, ChatType chatType, String str3, String str4, LoadListener<String> loadListener);

    void leaveChannel(String str, LoadListener<String> loadListener);

    void leaveGroup(String str, LoadListener<String> loadListener);

    void leaveGroupVoiceChat(String str, String str2, LoadListener<Integer> loadListener);

    void loadAllNotificationsFromDb();

    void loadAvailableReactions(LoadListener<Integer> loadListener);

    boolean loadForGuid(String str);

    void loadMessageForChat(String str, long j, LoadListener<Integer> loadListener);

    void loadMessages(String str, ChatType chatType, MessageUtils.FilterTypeEnum filterTypeEnum, boolean z, long j, long j2, long j3, long j4, int i, Object obj, boolean z2, boolean z3);

    void loadMessagesInterval(String str, ChatType chatType, MessageUtils.FilterTypeEnum filterTypeEnum, long j, int i, int i2, Object obj, boolean z, boolean z2);

    void loadMoreChat();

    void loadMyUserInfo();

    void loadPinMessageForChat(String str);

    void loadStickerSetting(LoadListener<Integer> loadListener);

    void loadSuggestedFilters(LoadListener<ArrayList<DialogFilterSuggested>> loadListener);

    void loadUnknownParticipants(String str, String str2, Set<String> set, LoadListener<GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsOutput> loadListener);

    void localMessageSent(String str, long j);

    int loginDisableTwoStep(String str, String str2, String str3, LoadListener<LoginDisableTwoStepOutput.StatusEnum> loadListener);

    int loginTwoStepForgetPassword(String str, LoadListener<LoginTwoStepForgetPasswordOutput> loadListener);

    void logout(LoadListener<Integer> loadListener);

    void onAuthSuccess(boolean z);

    void onInvalidAuth();

    void prepareEditMessage(String str, Message message);

    void prepareSendMessage(String str, Message message);

    void rateCall(String str, int i, String str2);

    void receivedCall(String str, LoadListener<Integer> loadListener);

    int refreshObjectInfo(String str, ChatType chatType, boolean z, LoadListener<String> loadListener, boolean z2);

    void rejectRequestObjectOwner(String str, LoadListener<Integer> loadListener);

    void removeAllLiveLocationInfo();

    void removeAllRecentChat();

    void removeChatHint(String str, LoadListener<Integer> loadListener);

    void removeFavoriteSticker(String str);

    void removeFromMyGifSet(long j, LoadListener<Integer> loadListener);

    void removeLiveLocationInfo(LiveLocationInfo liveLocationInfo);

    void removeNotificationsForChat(String str, ChatType chatType);

    void removeRecentChat(String str);

    void removeStickerSet(String str, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener);

    void reorderFolders(ArrayList<String> arrayList);

    void reorderStickerSets(ArrayList<String> arrayList);

    void reportLive(String str, ReportObjectInput.ReportTypeEnum reportTypeEnum, String str2, LoadListener<Integer> loadListener);

    void reportMessage(String str, String str2, ReportObjectInput.ReportTypeEnum reportTypeEnum, String str3, LoadListener<Integer> loadListener);

    void reportObject(String str, ReportObjectInput.ReportTypeEnum reportTypeEnum, String str2, LoadListener<Integer> loadListener);

    void requestCall(String str, int i, int i2, boolean z, ArrayList<String> arrayList, LoadListener<VoiceCallModels.PhoneCall> loadListener);

    void requestChangeObjectOwner(String str, String str2, LoadListener<ChangeOwnerModels.RequestChangeOwnerOutput> loadListener);

    void requestChangePhoneNumber(String str, LoadListener<RequestChangePhoneNumberOutput> loadListener);

    void requestDeleteAccount(LoadListener<Integer> loadListener);

    void requestForgetPassword(LoadListener<Integer> loadListener);

    void requestRecoveryEmail(String str, String str2, LoadListener<TwoStepStatusObject> loadListener);

    void requestSendFile(String str, String str2, long j, LoadListener<RequestSendFileOutput> loadListener);

    void resendCodeRecoveryEmail(String str, LoadListener<Integer> loadListener);

    void resetContacts(LoadListener<Integer> loadListener);

    void resetWallpapers(LoadListener<SettingModels.WallpapersOutput> loadListener);

    int retractPoll(String str, ChatType chatType, long j, String str2, LoadListener<Integer> loadListener);

    void saveHiddenWarningId(String str, String str2);

    void saveMessageSendState(String str, Message message);

    int searchBotSelectionItems(String str, String str2, String str3, int i, LoadListener<BotModels.SearchBotSelectionOutput> loadListener);

    int searchChatMessagesHashtag(String str, String str2, LoadListener<SearchChatMessagesResult> loadListener);

    int searchChatMessagesText(String str, String str2, LoadListener<SearchChatMessagesResult> loadListener);

    int searchGlobalMessagesHashtag(String str, String str2, LoadListener<SearchGlobalMessagesOutput> loadListener);

    int searchGlobalMessagesText(String str, String str2, LoadListener<SearchGlobalMessagesOutput> loadListener);

    int searchGlobalObjects(String str, String str2, ArrayList<SearchGlobalObjectsInput.FilterType> arrayList, LoadListener<SearchGlobalObjectsOutput> loadListener);

    ArrayList<InSearchObject> searchLocalInChats(String str, String str2);

    ArrayList<InSearchObject> searchLocalInContacts(String str);

    int searchStickerSets(String str, String str2, LoadListener<GetStickersOutput> loadListener);

    void seenChannelMessages(String str, long j, long j2);

    void seenChat(String str, ChatType chatType, long j, boolean z);

    int sendChatAction(String str, SendChatActivityInput.ActivityEnum activityEnum, LoadListener<Integer> loadListener);

    void sendCode(String str, String str2, LoadListener<SendCodeOutput> loadListener);

    int sendFile(String str, SendFileInput sendFileInput, FileUpLoadResponseListener fileUpLoadResponseListener);

    void sendGroupVoiceChatActivity(GroupCallModels.SendGroupVoiceChatActivityEnum sendGroupVoiceChatActivityEnum, String str, String str2, LoadListener<GroupCallModels.Status> loadListener);

    int sendLive(String str, String str2, String str3, boolean z, LoadListener<LiveModels.SendLiveResult> loadListener);

    int sendMessageAPICall(String str, long j, String str2, FileInlineObject fileInlineObject, LocationObject locationObject, AuxDataObject auxDataObject, LoadListener<Integer> loadListener);

    int sendSignalingData(String str, String str2, LoadListener<Integer> loadListener);

    void setAllNotificationsRead();

    void setAskSpamActionAddToContact(String str);

    void setAskSpamActionBlockUser(String str);

    void setAskSpamActionCancel(String str);

    void setAskSpamActionReportAndLeave(String str);

    void setBlockUser(String str, boolean z, LoadListener<Integer> loadListener);

    void setChannelAdmin(String str, String str2, ChatType chatType, ArrayList<Chat.EnumSetChannelAdminAccess> arrayList, LoadListener<InChatMember> loadListener);

    void setChannelLink(String str, LoadListener<String> loadListener);

    int setCurrentLiveLocation(double d, double d2, LoadListener<Integer> loadListener);

    void setGroupAdmin(String str, String str2, ArrayList<Chat.EnumSetGroupAdminAccess> arrayList, String str3, LoadListener<InChatMember> loadListener);

    void setGroupDefaultAccessList(String str, ArrayList<Chat.EnumSetGroupMemberAccess> arrayList);

    void setGroupLink(String str, LoadListener<String> loadListener);

    void setGroupVoiceChatJoinMuted(String str, String str2, boolean z, LoadListener<GroupCallModels.Status> loadListener);

    void setGroupVoiceChatRaiseHand(String str, String str2, String str3, boolean z, LoadListener<GroupCallModels.SetGroupVoiceChatStateStatusEnum> loadListener);

    void setGroupVoiceChatTitle(String str, String str2, String str3, LoadListener<GroupCallModels.Status> loadListener);

    void setLastLiveState(String str, String str2, boolean z, String str3);

    int setLiveSetting(String str, boolean z);

    void setNotificationReadByGuid(String str);

    void setSettings(boolean z, Map<SettingModels.ParameterNameEnum, Object> map, LoadListener<Integer> loadListener);

    void setupTwoStepVerification(String str, String str2, String str3, LoadListener<TwoStepStatusObject> loadListener);

    void signIn(boolean z, String str, String str2, String str3, LoadListener<String> loadListener);

    void startChatList();

    void startContactList();

    void startGroupCall(String str, int i, LoadListener<GroupCallModels.GroupVoiceChat> loadListener);

    void startMessageList(String str, ChatType chatType);

    int stopBot(String str);

    void stopChatList();

    void stopContactList();

    int stopLive(String str);

    int stopLiveLocation(String str, long j, String str2, LoadListener<LiveLocationObject> loadListener);

    void stopMessageList(String str);

    int stopPoll(String str, ChatType chatType, long j, String str2, LoadListener<Integer> loadListener);

    void terminateOtherSessions(LoadListener<Integer> loadListener);

    void terminateSession(String str, LoadListener<Integer> loadListener);

    void toggleGroupVoiceChatMuteUnMute(String str, String str2, String str3, boolean z, LoadListener<GroupCallModels.SetGroupVoiceChatStateStatusEnum> loadListener);

    void toggleMuteChat(String str, boolean z);

    void togglePinChat(String str, boolean z);

    void togglePinChatInFolder(String str, String str2, boolean z);

    void togglePinMessage(String str, long j, boolean z, LoadListener<PinMessageResult> loadListener);

    void turnOffTwoStepPassword(String str, LoadListener<Integer> loadListener);

    void unSetChannelAdmin(String str, String str2, ChatType chatType, LoadListener<InChatMember> loadListener);

    void unSetGroupAdmin(String str, String str2, LoadListener<InChatMember> loadListener);

    void unpinAllMessages(String str, LoadListener<PinMessageResult> loadListener);

    void updateChannelUsername(String str, String str2, LoadListener<UpdateChannelUsernameOutput.StatusEnum> loadListener);

    void updateLocalMessage(String str, Message message);

    void updateMessageRubinoPost(String str, long j, RubinoPostData rubinoPostData);

    void updateMessageRubinoStory(String str, long j, RubinoStoryData rubinoStoryData);

    int updateProfile(String str, String str2, String str3, LoadListener<Integer> loadListener);

    int updateProfileBio(String str, LoadListener<Integer> loadListener);

    int updateProfileName(String str, String str2, LoadListener<Integer> loadListener);

    int updateUserLocation(LocationObject locationObject, LoadListener<Integer> loadListener);

    int updateUserUsername(String str, String str2, LoadListener<UpdateUserUsernameOutput.StatusEnum> loadListener);

    void uploadAvatar(String str, String str2, String str3, LoadListener<AvatarFileInline> loadListener);

    void verifyChangePhoneNumber(String str, String str2, LoadListener<VerifyChangePhoneNumberOutput.Status> loadListener);

    void verifyRecoveryEmail(String str, String str2, LoadListener<VerifyRecoveryEmailOutput.StatusEnum> loadListener);

    int votePoll(String str, ChatType chatType, long j, String str2, Integer[] numArr, LoadListener<Integer> loadListener);

    /* renamed from: ir.aaap.messengercore.CoreMainClass$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean isAccountLoggedIn(KeyValueStorage keyValueStorage, JsonHelper jsonHelper, CoreLog coreLog) {
            return CoreUtilities.isNotEmpty(new KeyValueStorageHelper(keyValueStorage, jsonHelper, null, coreLog).getAuth());
        }

        public static void setLastAuth(String str, KeyValueStorage keyValueStorage, JsonHelper jsonHelper, CoreLog coreLog) {
            KeyValueStorageHelper keyValueStorageHelper = new KeyValueStorageHelper(keyValueStorage, jsonHelper, null, coreLog);
            keyValueStorageHelper.setAuth(str);
            keyValueStorageHelper.setCurrentApiVersion(5);
        }

        public static void setLastAuthV6(String str, String str2, KeyValueStorage keyValueStorage, JsonHelper jsonHelper, CoreLog coreLog) {
            KeyValueStorageHelper keyValueStorageHelper = new KeyValueStorageHelper(keyValueStorage, jsonHelper, null, coreLog);
            keyValueStorageHelper.setAuth(str);
            keyValueStorageHelper.setPrivateKeyString(str2);
            keyValueStorageHelper.setCurrentApiVersion(6);
            coreLog.e("setLastAuthV6", "auth" + str + " " + str2);
        }
    }
}
