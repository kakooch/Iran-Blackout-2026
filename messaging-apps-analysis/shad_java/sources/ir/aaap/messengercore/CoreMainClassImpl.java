package ir.aaap.messengercore;

import android.text.TextUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.MessageUtils;
import ir.aaap.messengercore.db.DB;
import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.exceptions.InvalidInputException;
import ir.aaap.messengercore.exceptions.LogInException;
import ir.aaap.messengercore.exceptions.SendMessageException;
import ir.aaap.messengercore.model.AuxDataObject;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.ChannelInfo;
import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatExtra;
import ir.aaap.messengercore.model.ChatInviteObject;
import ir.aaap.messengercore.model.ChatNeedReloadResult;
import ir.aaap.messengercore.model.ChatParamUpdateTimeObject;
import ir.aaap.messengercore.model.ChatReactionSetting;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.CheckChannelsWithUsernameResult;
import ir.aaap.messengercore.model.ContactMessageObject;
import ir.aaap.messengercore.model.DialogFilterSuggested;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.FolderObject;
import ir.aaap.messengercore.model.ForwardMessageResult;
import ir.aaap.messengercore.model.GetFileInput;
import ir.aaap.messengercore.model.GetFileResult;
import ir.aaap.messengercore.model.GetGroupMessageReadParticipantsResult;
import ir.aaap.messengercore.model.GetLinkFromAppUrlOutput;
import ir.aaap.messengercore.model.GetTokenResult;
import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.GroupInfo;
import ir.aaap.messengercore.model.InChatMember;
import ir.aaap.messengercore.model.Link;
import ir.aaap.messengercore.model.LiveLocationInfo;
import ir.aaap.messengercore.model.LiveLocationObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.LoadMessagesIntervalResult;
import ir.aaap.messengercore.model.LoadMessagesResult;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MapViewObject;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageReactionObject;
import ir.aaap.messengercore.model.MessageUpdateObject;
import ir.aaap.messengercore.model.MessageUpdateResult;
import ir.aaap.messengercore.model.MessengerUpdateObject;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.aaap.messengercore.model.PinMessageResult;
import ir.aaap.messengercore.model.PollModels;
import ir.aaap.messengercore.model.PollObject;
import ir.aaap.messengercore.model.PollStatusObject;
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
import ir.aaap.messengercore.model.api.GetTimeInput;
import ir.aaap.messengercore.model.api.GetTimeOutput;
import ir.aaap.messengercore.model.api.InSearchObject;
import ir.aaap.messengercore.model.api.LoginDisableTwoStepOutput;
import ir.aaap.messengercore.model.api.LoginTwoStepForgetPasswordOutput;
import ir.aaap.messengercore.model.api.PrivacySettings;
import ir.aaap.messengercore.model.api.RegisterDeviceInput;
import ir.aaap.messengercore.model.api.ReportObjectInput;
import ir.aaap.messengercore.model.api.ReportObjectOutput;
import ir.aaap.messengercore.model.api.RequestChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.RequestSendFileInput;
import ir.aaap.messengercore.model.api.RequestSendFileOutput;
import ir.aaap.messengercore.model.api.SearchGlobalMessagesOutput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsInput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsOutput;
import ir.aaap.messengercore.model.api.SendCodeOutput;
import ir.aaap.messengercore.model.api.SendFileInput;
import ir.aaap.messengercore.model.api.SendFileOutput;
import ir.aaap.messengercore.model.api.SendMessageOutput;
import ir.aaap.messengercore.model.api.SignInOutput;
import ir.aaap.messengercore.model.api.TwoPasscodeStatusOutput;
import ir.aaap.messengercore.model.api.TwoStepStatusObject;
import ir.aaap.messengercore.model.api.UpdateChannelUsernameOutput;
import ir.aaap.messengercore.model.api.UpdateUserUsernameOutput;
import ir.aaap.messengercore.model.api.VerifyChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.VerifyRecoveryEmailOutput;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.DataCenterManager;
import ir.aaap.messengercore.network.Network;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.usecase.GetChatAccessUseCase;
import ir.aaap.messengercore.usecase.GetMyUserGuidUsecase;
import ir.aaap.messengercore.usecase.LinkUsecase;
import ir.aaap.messengercore.usecase.LoadAbsUsecase;
import ir.aaap.messengercore.usecase.NotificationUsecase;
import ir.aaap.messengercore.usecase.UpdateBotInfoUsecase;
import ir.aaap.messengercore.usecase.UpdateChatAndMessageUsecase;
import ir.aaap.messengercore.usecase.UpdateChatUsecase;
import ir.aaap.messengercore.usecase.UpdateGroupVoiceChatUsecase;
import ir.aaap.messengercore.usecase.UpdateMessageUsecase;
import ir.aaap.messengercore.utilites.CoreLog;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class CoreMainClassImpl implements CoreMainClass {
    public static int CHAT_HINTS_UPDATE_DURATION = 86400000;
    public static int GET_ABS_LIMIT = 50;
    public static int GET_CONTACT_LAST_ONLINE_LIMIT = 200;
    public static int IMPORT_ADDRESS_BOOK_LIMIT = 200;
    public static int MAX_FOLDER_COUNT = 10;
    public static int MAX_PIN_IN_FOLDER_COUNT = 10;
    public static long OBJECT_INFO_VALID_CACHE_DURATION = 5184000000L;
    public static int RECENT_CHATS_UPDATE_LAST_ONLINE_DURATION = 60000;
    public static int getChatAdsPeriodMillis = 170000;
    public static int getChatUpdatePeriodMillis = 60000;
    public static long getFolderUpdatePeriodMillis = 3600000;
    public static int getInfoUpdatePeriodMillis = 60000;
    public static int groupOnlineCountUpdatePeriodMillis = 200000;
    public static float ignoreChangeApiTime = 1900.0f;
    private int getBotInfoDurationLevel = 0;
    private boolean isCoreInitiated;
    private boolean isGetContactAndImportPhoneBookInProgress;
    private LoadAbsUsecase loadAbsUsecase;
    public Network.NetworkErrorListener networkErrorListener;
    public ServiceLocator serviceLocator;
    GetMyUserGuidUsecase userGuidUsecase;

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getDiffForOnline() {
        return 120;
    }

    public CoreMainClassImpl(int i) {
    }

    public void init(boolean z, boolean z2, DB db, Network network, AbsNotificationCenter absNotificationCenter, JsonHelper jsonHelper, CoreEncryptionHelper coreEncryptionHelper, KeyValueStorage keyValueStorage, CoreLog coreLog, TimerHelper timerHelper, PushNotification pushNotification, DeviceUtils deviceUtils, PhoneBookHelper phoneBookHelper, Network.NetworkErrorListener networkErrorListener, RubinoUtils rubinoUtils) {
        ServiceLocator serviceLocator = new ServiceLocator();
        this.serviceLocator = serviceLocator;
        serviceLocator.init(db, network, absNotificationCenter, jsonHelper, coreEncryptionHelper, keyValueStorage, coreLog, timerHelper, pushNotification, deviceUtils, phoneBookHelper, rubinoUtils);
        getNetworkHelper().setVersionEncryptionHelper(new NetworkHelper.VersionEncryptionHelper() { // from class: ir.aaap.messengercore.CoreMainClassImpl.1
            @Override // ir.aaap.messengercore.network.NetworkHelper.VersionEncryptionHelper
            public boolean isVersion6() {
                return CoreMainClassImpl.this.getLoginUtils().isVersion6(CoreMainClassImpl.this.getKeyValueStorageHelper());
            }

            @Override // ir.aaap.messengercore.network.NetworkHelper.VersionEncryptionHelper
            public PrivateKey getPrivateKey() {
                return CoreMainClassImpl.this.getLoginUtils().getPrivateKey(CoreMainClassImpl.this.getKeyValueStorageHelper());
            }

            @Override // ir.aaap.messengercore.network.NetworkHelper.VersionEncryptionHelper
            public void switchToV6() {
                CoreMainClassImpl.this.getLoginUtils().switchToV6(CoreMainClassImpl.this.getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getKeyValueStorageHelper(), CoreMainClassImpl.this.getCoreEncryptionHelper());
            }
        });
        this.networkErrorListener = networkErrorListener;
        if (z) {
            initOnActivated(z2);
        }
    }

    public void initOnActivated(boolean z) {
        if (this.isCoreInitiated) {
            return;
        }
        getDataCenterManager().init(getKeyValueStorageHelper().getAuth(), getTimerHelper());
        getNetworkHelper().setNetworkErrorListener(this.networkErrorListener);
        registerDeviceIfNeededInternal(z, false, true, RetryObject.getDefaultRetry(), null);
        this.isCoreInitiated = true;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void initMessenger() {
        syncTimeWithServer();
        initChatListAndMap();
        initFolders();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isChatListInited() {
        return getChatUtils().isChatListInited();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void initChatMapFromDbIfNeeded() {
        getChatUtils().initChatMapFromDbIfNeeded(getDBHelper(), getNotificationCenter());
    }

    public void increaseApiServerOnError() {
        getDataCenterManager().increaseApiServerIfNeeded();
    }

    public void increaseCdnCounterIfNeeded(String str) {
        getDataCenterManager().increaseCdnCounterIfNeeded(str);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void onInvalidAuth() {
        if (isAccountLoggedIn()) {
            clearDataBaseAndStorage(true);
            getNotificationCenter().onInvalidAuth();
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void initSettingIfNeeded() {
        if (isAccountLoggedIn()) {
            getSettingUtils().initSettingIfNeeded(getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), getNotificationCenter());
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadStickerSetting(LoadListener<Integer> loadListener) {
        if (isAccountLoggedIn()) {
            getSettingUtils().getStickerSettingObjectFromServer(getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), getNotificationCenter(), loadListener);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int sendLive(String str, String str2, String str3, boolean z, LoadListener<LiveModels.SendLiveResult> loadListener) {
        return getLiveUtils().sendLive(str, str3, str2, getKeyValueStorageHelper().getNextRnd(), z, getAuth(), getNetworkHelper(), getDBHelper(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int stopLive(String str) {
        return getLiveUtils().stopLive(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int setLiveSetting(String str, boolean z) {
        return getLiveUtils().setLiveSetting(str, z, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getLiveStatus(String str, String str2, LiveModels.GetLiveStatusType getLiveStatusType) {
        return getLiveUtils().getLiveStatus(str, str2, getLiveStatusType, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getLivePlayUrl(String str, String str2, LoadListener<LiveModels.GetLivePlayUrlResult> loadListener) {
        return getLiveUtils().getLivePlayUrl(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int addLiveComment(String str, String str2, String str3, LoadListener<LiveModels.AddLiveCommentOutput> loadListener) {
        return getLiveUtils().addLiveComment(str, str2, str3, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getLiveComments(String str, String str2, String str3, LoadListener<LiveModels.GetLiveCommentsOutput> loadListener) {
        return getLiveUtils().getLiveComments(str, str2, str3, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getLiveViewers(String str, String str2, LoadListener<LiveModels.GetLiveViewersOutput> loadListener) {
        return getLiveUtils().getLiveViewers(str, str2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int setCurrentLiveLocation(double d, double d2, LoadListener<Integer> loadListener) {
        return getMessageUtils().setCurrentLiveLocation(d, d2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getLiveLocationInfoArray(LoadListener<ArrayList<LiveLocationInfo>> loadListener) {
        getMessageUtils().getLiveLocationInfoArray(getDBHelper(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addLiveLocationInfo(LiveLocationInfo liveLocationInfo) {
        getMessageUtils().addLiveLocationInfo(liveLocationInfo, getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeLiveLocationInfo(LiveLocationInfo liveLocationInfo) {
        getMessageUtils().removeLocationInfo(liveLocationInfo, getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeAllLiveLocationInfo() {
        getMessageUtils().removeAllLocationInfos(getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getPollOptionVoters(String str, String str2, String str3, LoadListener<PollModels.GetPollOptionVotersOutput> loadListener) {
        return getMessageUtils().getPollOptionVoters(str, str2, str3, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getPollStatus(String str, ChatType chatType, long j, String str2) {
        return getMessageUtils().getPollStatus(str, chatType, j, str2, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int votePoll(String str, ChatType chatType, long j, String str2, Integer[] numArr, LoadListener<Integer> loadListener) {
        return getMessageUtils().votePoll(str, chatType, j, str2, numArr, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int stopPoll(String str, ChatType chatType, long j, String str2, LoadListener<Integer> loadListener) {
        return getMessageUtils().stopPoll(str, chatType, j, str2, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int retractPoll(String str, ChatType chatType, long j, String str2, LoadListener<Integer> loadListener) {
        return getMessageUtils().retractPoll(str, chatType, j, str2, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int sendMessageAPICall(final String str, long j, String str2, FileInlineObject fileInlineObject, LocationObject locationObject, AuxDataObject auxDataObject, final LoadListener<Integer> loadListener) {
        return getBotUtils().sendMessageAPICall(getDataCenterManager().getBotApiUrl(), str, j, str2, fileInlineObject, locationObject, auxDataObject, getAuth(), getNetworkHelper(), new UpdateChatAndMessageUsecase(this), new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.2
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                CoreMainClassImpl.this.resetBotInfoDurationLevel(str, ChatType.Bot);
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(num);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int stopBot(String str) {
        return getBotUtils().stopBot(str, getAuth(), getNetworkHelper(), getDBHelper(), new UpdateChatAndMessageUsecase(this));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getBotSelectionItems(String str, String str2, String str3, LoadListener<BotModels.GetBotSelectionOutput> loadListener) {
        return getBotUtils().getSelection(getDataCenterManager().getBotApiUrl(), str, str2, str3, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int searchBotSelectionItems(String str, String str2, String str3, int i, LoadListener<BotModels.SearchBotSelectionOutput> loadListener) {
        return getBotUtils().searchSelection(getDataCenterManager().getBotApiUrl(), str, str2, str3, i, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public SettingModels.DataSettingObject getDataSettingInstant() {
        return getSettingUtils().getDataSettingObjectInstant(getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public SettingModels.NotificationSettingObject getNotificationSettingInstant(boolean z) {
        return getSettingUtils().getNotificationSettingObjectInstant(getKeyValueStorageHelper(), z);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public SettingModels.AppearanceSettingObject getAppearanceSettingInstant() {
        return getSettingUtils().getAppearanceSettingObjectInstant(getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public SettingModels.StickerSettingObject getStickerSettingInstant() {
        return getSettingUtils().getStickerSettingObjectInstant(getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeAllRecentChat() {
        getChatUtils().removeAllRecentChat(getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeRecentChat(String str) {
        getChatUtils().removeRecentChat(str, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getAllChatHints(boolean z, LoadListener<ArrayList<ChatAbsObject>> loadListener) {
        getChatUtils().getAllChatHints(z, getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeChatHint(String str, LoadListener<Integer> loadListener) {
        getChatUtils().removeChatHint(str, getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getAllRecentChatGuid(boolean z, LoadListener<ArrayList<InSearchObject>> loadListener) {
        getChatUtils().getAllRecentChatGuid(z, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addRecentChat(String str) {
        getChatUtils().addRecentChat(str, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void startGroupCall(String str, int i, LoadListener<GroupCallModels.GroupVoiceChat> loadListener) {
        getCallUtils().createGroupVoiceChat(str, i, getAuth(), getNetworkHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void joinGroupVoiceChat(String str, String str2, ChatType chatType, String str3, String str4, LoadListener<String> loadListener) {
        getCallUtils().joinGroupVoiceChat(str, str2, chatType, str3, str4, getAuth(), getNetworkHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void leaveGroupVoiceChat(String str, String str2, LoadListener<Integer> loadListener) {
        getCallUtils().leaveGroupVoiceChat(str, str2, getAuth(), getNetworkHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void discardGroupVoiceChat(String str, String str2, LoadListener<Integer> loadListener) {
        getCallUtils().discardGroupVoiceChat(str, str2, getAuth(), getNetworkHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setGroupVoiceChatTitle(String str, String str2, String str3, LoadListener<GroupCallModels.Status> loadListener) {
        getCallUtils().setGroupVoiceChatTitle(str, str2, str3, getAuth(), getNetworkHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setGroupVoiceChatJoinMuted(String str, String str2, boolean z, LoadListener<GroupCallModels.Status> loadListener) {
        getCallUtils().setGroupVoiceChatJoinMute(str, str2, z, getAuth(), getNetworkHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getGroupVoiceChat(String str, String str2, LoadListener<GroupCallModels.GroupVoiceChat> loadListener) {
        getCallUtils().getGroupVoiceChat(str, str2, getAuth(), getNetworkHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void sendGroupVoiceChatActivity(GroupCallModels.SendGroupVoiceChatActivityEnum sendGroupVoiceChatActivityEnum, String str, String str2, LoadListener<GroupCallModels.Status> loadListener) {
        getCallUtils().sendGroupVoiceChatActivity(sendGroupVoiceChatActivityEnum, str, str2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getDisplayAsInGroupVoiceChat(String str, String str2, LoadListener<GroupCallModels.GetDisplayAsInGroupVoiceChatOutput> loadListener) {
        getCallUtils().getDisplayAsInGroupVoiceChat(str, str2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getGroupVoiceChatParticipants(String str, String str2, String str3, LoadListener<GroupCallModels.GetGroupVoiceChatParticipantsOutput> loadListener) {
        getCallUtils().getGroupVoiceChatParticipants(str, str2, str3, getAuth(), getNetworkHelper(), new LoadAbsUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void toggleGroupVoiceChatMuteUnMute(String str, String str2, String str3, boolean z, LoadListener<GroupCallModels.SetGroupVoiceChatStateStatusEnum> loadListener) {
        getCallUtils().toggleGroupVoiceChatMuteUnMute(str, str2, str3, z, getAuth(), getNetworkHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setGroupVoiceChatRaiseHand(String str, String str2, String str3, boolean z, LoadListener<GroupCallModels.SetGroupVoiceChatStateStatusEnum> loadListener) {
        getCallUtils().setGroupVoiceChatRaiseHand(str, str2, str3, z, getAuth(), getNetworkHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadUnknownParticipants(String str, String str2, Set<String> set, LoadListener<GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsOutput> loadListener) {
        getCallUtils().loadUnknownParticipants(str, str2, set, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void requestCall(String str, int i, int i2, boolean z, ArrayList<String> arrayList, LoadListener<VoiceCallModels.PhoneCall> loadListener) {
        getCallUtils().requestCall(str, i, i2, z, arrayList, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getNotificationCenter(), getKeyValueStorageHelper(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void receivedCall(String str, LoadListener<Integer> loadListener) {
        getCallUtils().receivedCall(str, getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void discardCall(String str, int i, VoiceCallModels.EnumDiscardCallReason enumDiscardCallReason, LoadListener<Integer> loadListener) {
        getCallUtils().discardCall(str, i, enumDiscardCallReason, getAuth(), getNetworkHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getCalls(boolean z, String str, VoiceCallModels.FilterTypeEnum filterTypeEnum, LoadListener<VoiceCallModels.GetCallsOutput> loadListener) {
        getCallUtils().getCalls(z, str, filterTypeEnum, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getGroupVoiceChatUpdates(String str, String str2, String str3, LoadListener<GroupCallModels.GetGroupVoiceChatUpdatesResult> loadListener) {
        getCallUtils().getGroupVoiceChatUpdates(str2, str, str3, getAuth(), getNetworkHelper(), getNotificationCenter(), loadListener);
    }

    private void processCallSignalData(ArrayList<VoiceCallModels.CallSignalDataObject> arrayList) {
        String str;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<VoiceCallModels.CallSignalDataObject> it = arrayList.iterator();
        while (it.hasNext()) {
            VoiceCallModels.CallSignalDataObject next = it.next();
            if (next != null && (str = next.call_id) != null && !str.isEmpty()) {
                getNotificationCenter().onCallSignalDataReceived(next.call_id, next.data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCallSignalData(String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                getNotificationCenter().onCallSignalDataReceived(str, next);
            }
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void acceptCall(String str, int i, int i2, ArrayList<String> arrayList, LoadListener<String> loadListener) {
        getCallUtils().acceptCall(str, i, i2, arrayList, getAuth(), getNetworkHelper(), getNotificationCenter(), getKeyValueStorageHelper(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void rateCall(String str, int i, String str2) {
        getCallUtils().rateCall(str, i, str2, getAuth(), getNetworkHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int sendSignalingData(String str, String str2, LoadListener<Integer> loadListener) {
        return getCallUtils().sendSignalingData(str, str2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getSignalingData(final String str) {
        return getCallUtils().getSignalingData(str, getAuth(), getNetworkHelper(), new LoadListener<VoiceCallModels.GetSignalingDataOutput>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.3
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(VoiceCallModels.GetSignalingDataOutput getSignalingDataOutput) {
                if (getSignalingDataOutput != null) {
                    CoreMainClassImpl.this.getCoreLog().e("GetSignalData", "okay with: " + getSignalingDataOutput.data_list.size() + " items");
                    CoreMainClassImpl.this.processCallSignalData(str, getSignalingDataOutput.data_list);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                CoreMainClassImpl.this.getCoreLog().e("GetSignalData", "errored with: " + exc.getMessage());
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int callStarted(String str) {
        return getCallUtils().callStarted(str, getAuth(), getNetworkHelper(), new LoadListener<Integer>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.4
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getWalletTransferMessage(String str, String str2, LoadListener<WalletTransferMessageObject> loadListener) {
        return getWalletUtils().getWalletTransferMessage(str, str2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadMyUserInfo() {
        if (isAccountLoggedIn()) {
            getChatUtils().loadMyUserInfoFromServer(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper());
        }
    }

    private void logIfPossible(String str, String str2) {
        CoreLog coreLog = getCoreLog();
        if (coreLog != null) {
            coreLog.e(str, str2);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void forceRegisterDevice(boolean z) {
        registerDeviceIfNeededInternal(z, true, true, RetryObject.getDefaultRetry(), null);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void onAuthSuccess(boolean z) {
        if (isAccountLoggedIn()) {
            getPushNotification().getToken(null);
            initSettingIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerDeviceIfNeededInternal(final boolean z, final boolean z2, boolean z3, final RetryObject retryObject, final LoadListener<Integer> loadListener) {
        if (!isAccountLoggedIn()) {
            if (loadListener != null) {
                loadListener.onError(new Exception("Account is not login"));
            }
        } else if (z3) {
            getPushNotification().getToken(new LoadListener<GetTokenResult>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.5
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(GetTokenResult getTokenResult) {
                    if (getTokenResult == null) {
                        loadListener.onError(new Exception());
                        return;
                    }
                    boolean z4 = !CoreMainClassImpl.this.getDeviceUtils().getAppVersion().equals(CoreMainClassImpl.this.getKeyValueStorageHelper().getLastVersion());
                    if (z4) {
                        CoreMainClassImpl.this.getNotificationCenter().versionChanged();
                    }
                    String lastFireBaseTokenRegistered = CoreMainClassImpl.this.getKeyValueStorageHelper().getLastFireBaseTokenRegistered();
                    if (!z2 && lastFireBaseTokenRegistered != null && lastFireBaseTokenRegistered.equals(getTokenResult.token) && !z4) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    CoreMainClassImpl.this.getLoginUtils().registerDevice(z, CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getCoreLog(), CoreMainClassImpl.this.getKeyValueStorageHelper(), CoreMainClassImpl.this.getDeviceUtils(), getTokenResult.token, getTokenResult.tokenType, retryObject, loadListener);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } else {
            getKeyValueStorageHelper().setLastFireBaseTokenRegistered(BuildConfig.FLAVOR);
            getLoginUtils().registerDevice(z, getNetworkHelper(), getCoreLog(), getKeyValueStorageHelper(), getDeviceUtils(), BuildConfig.FLAVOR, RegisterDeviceInput.TokenTypeEnum.Firebase, retryObject, loadListener);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void handleMessengerNotification(MessengerUpdateObject messengerUpdateObject, boolean z) {
        if (messengerUpdateObject == null) {
            return;
        }
        processMessageAndChatUpdate(messengerUpdateObject.message_updates, messengerUpdateObject.chat_updates, true, true);
        getNotificationCenter().onProcessCallUpdate(messengerUpdateObject.call_updates);
        processGroupVoiceChatParticipantUpdate(messengerUpdateObject.group_voice_chat_participant_updates, true);
        processGroupVoiceChatUpdates(messengerUpdateObject.group_voice_chat_updates);
        getChatUtils().processShowActivities(messengerUpdateObject.show_activities, getNotificationCenter());
        getLiveUtils().processLiveStatusChanged(messengerUpdateObject.live_updates, getDBHelper(), getNotificationCenter());
        processCallSignalData(messengerUpdateObject.call_signal_data);
        getNotificationUtils().processNotification(messengerUpdateObject.mode == MessengerUpdateObject.Mode.Silent, z, messengerUpdateObject.show_notifications, messengerUpdateObject.edit_notifications, messengerUpdateObject.remove_notifications, getDBHelper(), getNotificationCenter(), new NotificationUsecase(this));
    }

    public void processGroupVoiceChatUpdates(ArrayList<GroupCallModels.GroupVoiceChatUpdate> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<GroupCallModels.GroupVoiceChatUpdate> it = arrayList.iterator();
        while (it.hasNext()) {
            getNotificationCenter().processGroupCallUpdate(it.next());
        }
    }

    public void processGroupVoiceChatParticipantUpdate(ArrayList<GroupCallModels.GroupVoiceChatParticipantUpdate> arrayList, boolean z) {
        if (arrayList != null) {
            getNotificationCenter().processGroupVoiceChatParticipantUpdate(arrayList, z);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getUpdate() {
        getNotificationUtils().getUpdate(getAuth(), getNetworkHelper(), new LoadListener<MessengerUpdateObject>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.6
            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(MessengerUpdateObject messengerUpdateObject) {
                CoreMainClassImpl.this.handleMessengerNotification(messengerUpdateObject, true);
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setNotificationReadByGuid(String str) {
        if (isAccountLoggedIn()) {
            getNotificationUtils().setNotificationReadByGuid(str, getDBHelper());
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setAllNotificationsRead() {
        if (isAccountLoggedIn()) {
            getNotificationUtils().setAllNotificationRead(getDBHelper());
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadAllNotificationsFromDb() {
        if (isAccountLoggedIn()) {
            getNotificationUtils().loadAllNotificationsFromDb(getDBHelper(), getNotificationCenter(), new NotificationUsecase(this));
        }
    }

    private NotificationUtils getNotificationUtils() {
        return this.serviceLocator.getNotificationUtils();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canDeleteAvatar(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.ChangeInfo);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean equalsCurrentDeviceHash(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return getDeviceUtils().generateDeviceIdentifier().equals(str);
    }

    public void onLinkClick(Link link) {
        getNotificationCenter().onLinkClicked(link);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void cancelRequest(int i) {
        if (!this.isCoreInitiated || this.serviceLocator == null) {
            return;
        }
        getNetworkHelper().cancelCall(i);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canRemoveObject(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.RemoveObject);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canSetAccess(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.SetMemberAccess);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canViewMembers(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.ViewMembers);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canSetLink(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.SetJoinLink);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canDeleteGlobalMyMessage(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.DeleteGlobalMyMessages);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canDeleteGlobalAllMessages(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.DeleteGlobalAllMessages);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canSendMessage(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        ChatAbsObject absInstant = getAbsInstant(str);
        if (str != null && (chatForceGetChatInstant = forceGetChatInstant(str)) != null && (hashSet = chatForceGetChatInstant.access) != null) {
            return hashSet.contains(Chat.ChatAccessEnum.SendMessages);
        }
        if (absInstant == null) {
            return false;
        }
        ChatType chatType = absInstant.type;
        return chatType == ChatType.User || chatType == ChatType.Group;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canDeleteLocalMessage(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.DeleteLocalMessages);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public LiveModels.LastLiveState getLastLiveState() {
        return getLiveUtils().getLastLiveState(getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setLastLiveState(String str, String str2, boolean z, String str3) {
        getLiveUtils().setLastLiveState(str, str2, z, str3, getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public UserInfo getMyUserInfo() {
        return getChatUtils().getMyUserInfo(getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<StickerObject> getRecentStickersInstant() {
        return getMessageUtils().getRecentStickersInstant(getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<StickerObject> getFavoriteStickersInstant() {
        return getMessageUtils().getFavoriteStickersInstant(getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int sendChatAction(String str, SendChatActivityInput.ActivityEnum activityEnum, LoadListener<Integer> loadListener) {
        return getChatUtils().sendChatActivity(str, activityEnum, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addToMyGifSet(String str, long j, FileInlineObject fileInlineObject, LoadListener<Integer> loadListener) {
        getMessageUtils().addToMyGifSet(str, j, fileInlineObject, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeFromMyGifSet(long j, LoadListener<Integer> loadListener) {
        getMessageUtils().removeFromMyGifSet(j, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addRecentGif(FileInlineObject fileInlineObject, long j) {
        getMessageUtils().addOrUpdateRecentGif(fileInlineObject, j, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getAllRecentGif(LoadListener<ArrayList<FileInlineObject>> loadListener) {
        getMessageUtils().initAndLoadMyGifSetIfNeeded(false, getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addRecentSticker(ArrayList<StickerObject> arrayList, long j, boolean z) {
        getMessageUtils().addRecentSticker(arrayList, j, z, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addFavoriteSticker(ArrayList<StickerObject> arrayList, long j, boolean z) {
        getMessageUtils().addFavoriteSticker(arrayList, j, z, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeFavoriteSticker(String str) {
        getMessageUtils().removeFavoriteSticker(str, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addStickerSet(String str, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener) {
        getMessageUtils().addStickerSet(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void archiveStickerSet(String str, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener) {
        getMessageUtils().archiveStickerSet(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeStickerSet(String str, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener) {
        getMessageUtils().removeStickerSet(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<StickerSetObject> getMyStickerSetInstant() {
        return getMessageUtils().getMyStickerSetInstant();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public StickerSetObject getStickerSetByIdInstant(String str) {
        return getMessageUtils().getStickerSetByIdInstant(str);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<StickerObject> getStickersBySetIdInstant(String str) {
        return getMessageUtils().getStickersBySetIdInstant(str);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public String getMyGuid() {
        return getKeyValueStorageHelper().getUserGuid();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public String getAuth() {
        return getKeyValueStorageHelper().getAuth();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isAccountLoggedIn() {
        return CoreUtilities.isNotEmpty(getAuth());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void sendCode(String str, String str2, LoadListener<SendCodeOutput> loadListener) {
        getLoginUtils().sendCode(str, str2, getNetworkHelper(), getKeyValueStorageHelper(), getCoreLog(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void requestChangePhoneNumber(String str, LoadListener<RequestChangePhoneNumberOutput> loadListener) {
        getLoginUtils().requestChangePhoneNumber(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getPendingObjectOwner(String str, LoadListener<ChangeOwnerModels.GetPendingObjectOwnerOutput> loadListener) {
        getChatUtils().getPendingObjectOwner(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void requestChangeObjectOwner(String str, String str2, LoadListener<ChangeOwnerModels.RequestChangeOwnerOutput> loadListener) {
        getChatUtils().requestChangeObjectOwner(str, str2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void cancelChangeObjectOwner(String str, LoadListener<Integer> loadListener) {
        getChatUtils().cancelChangeObjectOwner(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void acceptRequestObjectOwner(String str, LoadListener<Integer> loadListener) {
        getChatUtils().acceptRequestObjectOwner(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void rejectRequestObjectOwner(String str, LoadListener<Integer> loadListener) {
        getChatUtils().rejectRequestObjectOwner(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void verifyChangePhoneNumber(String str, String str2, final LoadListener<VerifyChangePhoneNumberOutput.Status> loadListener) {
        getLoginUtils().verifyChangePhoneNumber(str, str2, getAuth(), getKeyValueStorageHelper(), getNetworkHelper(), new LoadListener<VerifyChangePhoneNumberOutput>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.7
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(VerifyChangePhoneNumberOutput verifyChangePhoneNumberOutput) {
                if (verifyChangePhoneNumberOutput != null && verifyChangePhoneNumberOutput.status == VerifyChangePhoneNumberOutput.Status.IsValid && verifyChangePhoneNumberOutput.user != null) {
                    CoreMainClassImpl.this.getChatUtils().processUserInfoDidLoad(verifyChangePhoneNumberOutput.user, null, 0L, true, true, true, verifyChangePhoneNumberOutput.timestamp, CoreMainClassImpl.this.getDBHelper(), false, CoreMainClassImpl.this.getNotificationCenter());
                }
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    if (verifyChangePhoneNumberOutput != null) {
                        loadListener2.onDidLoad(verifyChangePhoneNumberOutput.status);
                    } else {
                        loadListener2.onError(new ApiServerException());
                    }
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public PrivacySettings getPrivacySettingInstant() {
        return getSettingUtils().getPrivacySettingInstant();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public SettingModels.GetThemesOutput getThemesInstant() {
        return getSettingUtils().getThemesInstant(getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void checkTwoStepPasscode(String str, LoadListener<Boolean> loadListener) {
        getLoginUtils().checkTwoStepPasscode(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getWallpapers(LoadListener<SettingModels.WallpapersOutput> loadListener) {
        getSettingUtils().getWallpapers(getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void resetWallpapers(LoadListener<SettingModels.WallpapersOutput> loadListener) {
        getSettingUtils().resetWallpapers(getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addWallpaperSetThemeBackground(long j, String str, long j2, String str2, String str3, LoadListener<SettingModels.AddWallpaperSetThemeBackgroundOutput> loadListener) {
        getSettingUtils().addWallpaperSetThemeBackground(j, str, j2, str2, str3, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getPrivacySettingFromServer(LoadListener<PrivacySettings> loadListener) {
        getSettingUtils().getPrivacySettingFromServer(getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setSettings(boolean z, Map<SettingModels.ParameterNameEnum, Object> map, LoadListener<Integer> loadListener) {
        getSettingUtils().setSettings(z, map, getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void changePassword(String str, String str2, String str3, LoadListener<TwoStepStatusObject> loadListener) {
        getLoginUtils().changePassword(str, str2, str3, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void turnOffTwoStepPassword(String str, LoadListener<Integer> loadListener) {
        getLoginUtils().turnOffTwoStep(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setupTwoStepVerification(String str, String str2, String str3, LoadListener<TwoStepStatusObject> loadListener) {
        getLoginUtils().setupTwoStepVerification(str, str2, str3, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void verifyRecoveryEmail(String str, String str2, LoadListener<VerifyRecoveryEmailOutput.StatusEnum> loadListener) {
        getLoginUtils().verifyRecoveryEmail(str, str2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void resendCodeRecoveryEmail(String str, LoadListener<Integer> loadListener) {
        getLoginUtils().resendCodeRecoveryEmail(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void abortSetRecoveryEmail(String str, LoadListener<TwoStepStatusObject> loadListener) {
        getLoginUtils().abortSetRecoveryEmail(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void requestRecoveryEmail(String str, String str2, LoadListener<TwoStepStatusObject> loadListener) {
        getLoginUtils().requestRecoveryEmail(str, str2, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void requestForgetPassword(LoadListener<Integer> loadListener) {
        getLoginUtils().requestForgetPassword(getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void disableTwoStepByForgetPassword(String str, LoadListener<DisableTwoStepByForgetPasswordOutput.StatusEnum> loadListener) {
        getLoginUtils().disableTwoStepByForgetPassword(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int loginTwoStepForgetPassword(String str, LoadListener<LoginTwoStepForgetPasswordOutput> loadListener) {
        return getLoginUtils().loginTwoStepForgetPassword(str, getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int loginDisableTwoStep(String str, String str2, String str3, LoadListener<LoginDisableTwoStepOutput.StatusEnum> loadListener) {
        return getLoginUtils().loginDisableTwoStep(str, str2, str3, getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getTwoPasscodeStatus(LoadListener<TwoPasscodeStatusOutput> loadListener) {
        getLoginUtils().getTwoPasscodeStatus(getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void abortTwoStepSetup(LoadListener<Integer> loadListener) {
        getLoginUtils().abortTwoStepSetup(getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getMySessions(LoadListener<GetMySessionsOutput> loadListener) {
        return getLoginUtils().getMySessions(getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void terminateSession(String str, LoadListener<Integer> loadListener) {
        getLoginUtils().terminateSession(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void terminateOtherSessions(LoadListener<Integer> loadListener) {
        getLoginUtils().terminateOtherSessions(getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void signIn(final boolean z, String str, String str2, String str3, final LoadListener<String> loadListener) {
        getLoginUtils().signIn(getNetworkHelper(), getKeyValueStorageHelper(), getJsonHelper(), getCoreEncryptionHelper(), getCoreLog(), str, str2, str3, new LoadListener<SignInOutput>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.8
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(SignInOutput signInOutput) {
                SignInOutput.Status status = signInOutput.status;
                if (status == SignInOutput.Status.OK) {
                    final String str4 = null;
                    if (signInOutput.user != null) {
                        CoreMainClassImpl.this.getChatUtils().processUserInfoDidLoad(signInOutput.user, null, 0L, false, false, true, signInOutput.timeStamp, CoreMainClassImpl.this.getDBHelper(), false, null);
                        str4 = signInOutput.user.user_guid;
                    }
                    CoreMainClassImpl.this.registerDeviceIfNeededInternal(z, true, false, RetryObject.getCountAndDelayRetryWithTime(5, 1, 2, 2), new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.8.1
                        @Override // ir.aaap.messengercore.LoadListener
                        public void onDidLoad(Integer num) {
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(str4);
                            }
                        }

                        @Override // ir.aaap.messengercore.LoadListener
                        public void onError(Exception exc) {
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(str4);
                            }
                        }
                    });
                    return;
                }
                if (loadListener != null) {
                    LogInException.ErrorEnum errorEnum = LogInException.ErrorEnum.signInFailed;
                    int i = AnonymousClass40.$SwitchMap$ir$aaap$messengercore$model$api$SignInOutput$Status[status.ordinal()];
                    if (i == 1) {
                        errorEnum = LogInException.ErrorEnum.CodeIsExpired;
                    } else if (i == 2) {
                        errorEnum = LogInException.ErrorEnum.CodeIsUsed;
                    } else if (i == 3) {
                        errorEnum = LogInException.ErrorEnum.CodeIsInvalid;
                    }
                    loadListener.onError(new LogInException(errorEnum));
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    /* renamed from: ir.aaap.messengercore.CoreMainClassImpl$40, reason: invalid class name */
    static /* synthetic */ class AnonymousClass40 {
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$api$SignInOutput$Status;

        static {
            int[] iArr = new int[SignInOutput.Status.values().length];
            $SwitchMap$ir$aaap$messengercore$model$api$SignInOutput$Status = iArr;
            try {
                iArr[SignInOutput.Status.CodeIsExpired.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$api$SignInOutput$Status[SignInOutput.Status.CodeIsUsed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$api$SignInOutput$Status[SignInOutput.Status.CodeIsInvalid.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void checkChatListInited(LoadListener<Integer> loadListener) {
        if (loadListener != null) {
            if (getChatUtils().isChatListInited()) {
                loadListener.onDidLoad(1);
            } else {
                getChatUtils().initChatList(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), getTimerHelper(), true, new UpdateChatUsecase(this), loadListener);
            }
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public long getTimeMillis() {
        return System.currentTimeMillis() - getKeyValueStorageHelper().getServerTimeDiff(0L);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getServerTimeDiffMillis() {
        return (int) getKeyValueStorageHelper().getServerTimeDiff(0L);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isOnline(int i) {
        return i + getDiffForOnline() > ((int) (getTimeMillis() / 1000));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public long getRnd() {
        return getKeyValueStorageHelper().getNextRnd();
    }

    public void syncTimeWithServer() {
        try {
            getNetworkHelper().getTime(getAuth(), new GetTimeInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetTimeOutput>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.9
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetTimeOutput getTimeOutput) {
                    if (getTimeOutput != null) {
                        CoreMainClassImpl.this.getKeyValueStorageHelper().setServerTimeDiff(System.currentTimeMillis() - (getTimeOutput.time * 1000));
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadMessages(final String str, final ChatType chatType, final MessageUtils.FilterTypeEnum filterTypeEnum, final boolean z, final long j, final long j2, final long j3, final long j4, final int i, final Object obj, final boolean z2, final boolean z3) {
        logIfPossible("CoreMainClassImpl", "loadMessages: chat_guid " + str + " filter_type " + filterTypeEnum + " minId " + j + " maxId " + j2 + " fromMin " + z + " limit " + i);
        if (z && j < 0) {
            LoadMessagesResult loadMessagesResult = new LoadMessagesResult();
            loadMessagesResult.messages = new ArrayList<>();
            loadMessagesResult.hasContinue = false;
            loadMessagesResult.isFromDb = true;
            loadMessagesResult.chatId = str;
            loadMessagesResult.chatType = chatType;
            loadMessagesResult.filterType = filterTypeEnum;
            loadMessagesResult.minId = j;
            loadMessagesResult.maxId = j2;
            loadMessagesResult.extraInfo = obj;
            getNotificationCenter().messagesDidLoad(loadMessagesResult);
            return;
        }
        checkChatListInited(new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.10
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                HashSet<Chat.ChatAccessEnum> hashSet;
                Chat chatInstant = CoreMainClassImpl.this.getChatInstant(str);
                if (chatInstant != null && (hashSet = chatInstant.access) != null && !hashSet.contains(Chat.ChatAccessEnum.ViewMessages)) {
                    LoadMessagesResult loadMessagesResult2 = new LoadMessagesResult();
                    loadMessagesResult2.messages = new ArrayList<>();
                    loadMessagesResult2.hasContinue = false;
                    loadMessagesResult2.isFromDb = true;
                    loadMessagesResult2.chatId = str;
                    loadMessagesResult2.chatType = chatType;
                    loadMessagesResult2.filterType = filterTypeEnum;
                    loadMessagesResult2.minId = j;
                    loadMessagesResult2.maxId = j2;
                    loadMessagesResult2.extraInfo = obj;
                    CoreMainClassImpl.this.getNotificationCenter().messagesDidLoad(loadMessagesResult2);
                    return;
                }
                long j5 = 9223372036854775797L;
                long j6 = 0;
                if (chatInstant != null) {
                    j5 = chatInstant.last_message_id;
                    j6 = chatInstant.last_deleted_mid;
                }
                CoreMainClassImpl.this.getMessageUtils().loadMessagesWithCheckLocal(z3, CoreMainClassImpl.this.getKeyValueStorageHelper().getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getDBHelper(), CoreMainClassImpl.this.getKeyValueStorageHelper(), str, chatType, filterTypeEnum, z, j, j2, j3, j4, j5, j6, i, obj, new LoadMessagesListener() { // from class: ir.aaap.messengercore.CoreMainClassImpl.10.1
                    @Override // ir.aaap.messengercore.LoadMessagesListener
                    public void onMessagesDidLoad(LoadMessagesResult loadMessagesResult3) {
                        ArrayList<Message> arrayList;
                        if (loadMessagesResult3 != null) {
                            if (!loadMessagesResult3.hasContinue) {
                                loadMessagesResult3.newMinDate = 0L;
                                loadMessagesResult3.newMaxDate = 0L;
                                loadMessagesResult3.newMinId = 0L;
                                loadMessagesResult3.newMaxId = 0L;
                            }
                            if (loadMessagesResult3.messages == null) {
                                loadMessagesResult3.messages = new ArrayList<>();
                            }
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            CoreMainClassImpl.this.checkForReactions(str, chatType, loadMessagesResult3.messages);
                            CoreMainClassImpl.this.getNotificationCenter().messagesDidLoad(loadMessagesResult3);
                            AnonymousClass10 anonymousClass102 = AnonymousClass10.this;
                            if (!z2 || (arrayList = loadMessagesResult3.messages) == null) {
                                return;
                            }
                            CoreMainClassImpl.this.loadAbsAndRepliesForMessages(loadMessagesResult3.chatId, loadMessagesResult3.chatType, arrayList, loadMessagesResult3.isFromDb, null);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadMessagesListener
                    public void onLoadingMessagesFailed(LoadMessagesResult loadMessagesResult3) {
                        CoreMainClassImpl.this.getNotificationCenter().loadingMessagesFailed(loadMessagesResult3);
                    }
                });
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadMessagesResult loadMessagesResult2 = new LoadMessagesResult();
                loadMessagesResult2.chatId = str;
                loadMessagesResult2.chatType = chatType;
                loadMessagesResult2.filterType = filterTypeEnum;
                loadMessagesResult2.minId = j;
                loadMessagesResult2.maxId = j2;
                loadMessagesResult2.extraInfo = obj;
                CoreMainClassImpl.this.getNotificationCenter().loadingMessagesFailed(loadMessagesResult2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForReactions(String str, ChatType chatType, ArrayList<Message> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || canShowReactions(str, chatType)) {
            return;
        }
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().reactions = null;
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canShowReactions(String str, ChatType chatType) {
        ObjectInfo objectInfoInstant;
        if (chatType == ChatType.User) {
            return true;
        }
        ChatType chatType2 = ChatType.Group;
        if ((chatType != chatType2 && chatType != ChatType.Channel) || (objectInfoInstant = getObjectInfoInstant(str)) == null) {
            return false;
        }
        ChatReactionSetting chatReactionSetting = null;
        GroupInfo groupInfo = objectInfoInstant.groupInfo;
        if (groupInfo != null && chatType == chatType2) {
            chatReactionSetting = groupInfo.chat_reaction_setting;
        } else {
            ChannelInfo channelInfo = objectInfoInstant.channelInfo;
            if (channelInfo != null && chatType == ChatType.Channel) {
                chatReactionSetting = channelInfo.chat_reaction_setting;
            }
        }
        return (chatReactionSetting == null || chatReactionSetting.reaction_type == ChatReactionSetting.ReactionType.Disabled) ? false : true;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadMessagesInterval(final String str, final ChatType chatType, final MessageUtils.FilterTypeEnum filterTypeEnum, final long j, final int i, final int i2, final Object obj, final boolean z, final boolean z2) {
        logIfPossible("CoreMainClassImpl", "loadMessagesInterval: chat_guid " + str + " filter_type " + filterTypeEnum + " middle_message_id " + j + " olderLimit " + i + " newerLimit " + i2 + " limit " + i2);
        checkChatListInited(new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.11
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                HashSet<Chat.ChatAccessEnum> hashSet;
                Chat chatInstant = CoreMainClassImpl.this.getChatInstant(str);
                if (chatInstant != null && (hashSet = chatInstant.access) != null && !hashSet.contains(Chat.ChatAccessEnum.ViewMessages)) {
                    LoadMessagesIntervalResult loadMessagesIntervalResult = new LoadMessagesIntervalResult();
                    loadMessagesIntervalResult.messages = new ArrayList<>();
                    loadMessagesIntervalResult.new_has_continue = false;
                    loadMessagesIntervalResult.old_has_continue = false;
                    loadMessagesIntervalResult.isFromDb = true;
                    loadMessagesIntervalResult.chatId = str;
                    loadMessagesIntervalResult.chatType = chatType;
                    loadMessagesIntervalResult.filterType = filterTypeEnum;
                    loadMessagesIntervalResult.middleId = j;
                    loadMessagesIntervalResult.extraInfo = obj;
                    CoreMainClassImpl.this.getNotificationCenter().messagesDidLoadInterval(loadMessagesIntervalResult);
                    return;
                }
                long j2 = 9223372036854775797L;
                long j3 = 0;
                if (chatInstant != null) {
                    j2 = chatInstant.last_message_id;
                    j3 = chatInstant.last_deleted_mid;
                }
                CoreMainClassImpl.this.getMessageUtils().loadMessagesIntervalWithCheckLocal(z2, CoreMainClassImpl.this.getKeyValueStorageHelper().getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getDBHelper(), CoreMainClassImpl.this.getKeyValueStorageHelper(), str, chatType, filterTypeEnum, j, j2, j3, i, i2, obj, new LoadMessagesIntervalListener() { // from class: ir.aaap.messengercore.CoreMainClassImpl.11.1
                    @Override // ir.aaap.messengercore.LoadMessagesIntervalListener
                    public void onMessagesDidLoadInterval(LoadMessagesIntervalResult loadMessagesIntervalResult2) {
                        ArrayList<Message> arrayList;
                        if (loadMessagesIntervalResult2 != null) {
                            if (!loadMessagesIntervalResult2.new_has_continue) {
                                loadMessagesIntervalResult2.new_min_id = 0L;
                            }
                            if (!loadMessagesIntervalResult2.old_has_continue) {
                                loadMessagesIntervalResult2.old_max_id = 0L;
                            }
                            if (loadMessagesIntervalResult2.messages == null) {
                                loadMessagesIntervalResult2.messages = new ArrayList<>();
                            }
                            AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                            CoreMainClassImpl.this.checkForReactions(str, chatType, loadMessagesIntervalResult2.messages);
                            CoreMainClassImpl.this.getNotificationCenter().messagesDidLoadInterval(loadMessagesIntervalResult2);
                            AnonymousClass11 anonymousClass112 = AnonymousClass11.this;
                            if (!z || (arrayList = loadMessagesIntervalResult2.messages) == null) {
                                return;
                            }
                            CoreMainClassImpl.this.loadAbsAndRepliesForMessages(loadMessagesIntervalResult2.chatId, loadMessagesIntervalResult2.chatType, arrayList, loadMessagesIntervalResult2.isFromDb, null);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadMessagesIntervalListener
                    public void onLoadingMessagesFailedInterval(LoadMessagesIntervalResult loadMessagesIntervalResult2) {
                        CoreMainClassImpl.this.getNotificationCenter().loadingMessagesFailedInterval(loadMessagesIntervalResult2);
                    }
                });
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadMessagesIntervalResult loadMessagesIntervalResult = new LoadMessagesIntervalResult();
                loadMessagesIntervalResult.chatId = str;
                loadMessagesIntervalResult.chatType = chatType;
                loadMessagesIntervalResult.filterType = filterTypeEnum;
                loadMessagesIntervalResult.middleId = j;
                loadMessagesIntervalResult.extraInfo = obj;
                CoreMainClassImpl.this.getNotificationCenter().loadingMessagesFailedInterval(loadMessagesIntervalResult);
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadPinMessageForChat(final String str) {
        checkChatListInited(new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.12
            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                ArrayList<Long> arrayList;
                final Chat chatInstant = CoreMainClassImpl.this.getChatInstant(str);
                if (chatInstant == null || (arrayList = chatInstant.pinned_message_ids) == null || arrayList.size() <= 0) {
                    return;
                }
                CoreMainClassImpl.this.getMessageUtils().loadMessagesById(str, chatInstant.pinned_message_ids, CoreMainClassImpl.this.getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getDBHelper(), new LoadListener<Map<Long, Message>>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.12.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Map<Long, Message> map) {
                        ArrayList<Long> arrayList2 = new ArrayList<>();
                        Iterator<Long> it = chatInstant.pinned_message_ids.iterator();
                        while (it.hasNext()) {
                            Long next = it.next();
                            Message message = map.get(next);
                            if (message != null && !message.isDeleted) {
                                arrayList2.add(next);
                            }
                        }
                        CoreMainClassImpl.this.getNotificationCenter().didLoadPinnedMessages(str, arrayList2);
                    }
                });
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadMessageForChat(String str, long j, LoadListener<Integer> loadListener) {
        getMessageUtils().loadMessageForChat(str, j, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int callForwardMessage(String str, final String str2, final ChatType chatType, ArrayList<Long> arrayList, int i, final LoadListener<ForwardMessageResult> loadListener) {
        logIfPossible("CoreMainClassImpl", "forwardMessage:  fromGuid " + str + " to guid " + str2);
        return getMessageUtils().forwardMessages(getKeyValueStorageHelper().getAuth(), str, str2, false, i, arrayList, getNetworkHelper(), new LoadListener<SendMessageOutput>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.13
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(SendMessageOutput sendMessageOutput) {
                Message message;
                ForwardMessageResult forwardMessageResult = new ForwardMessageResult();
                SendMessageOutput.SendMessageStatus sendMessageStatus = sendMessageOutput.status;
                forwardMessageResult.status = sendMessageStatus;
                if (sendMessageStatus == SendMessageOutput.SendMessageStatus.OK) {
                    Iterator<MessageUpdateObject> it = sendMessageOutput.message_updates.iterator();
                    while (it.hasNext()) {
                        MessageUpdateObject next = it.next();
                        if (next.action == MessageUpdateObject.Action.New && (message = next.message) != null) {
                            forwardMessageResult.messages.add(message);
                            forwardMessageResult.prevMessageIds.add(Long.valueOf(next.prev_message_id));
                        }
                    }
                }
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(forwardMessageResult);
                }
                ChatType chatType2 = chatType;
                ChatType chatType3 = ChatType.Bot;
                if (chatType2 == chatType3) {
                    CoreMainClassImpl.this.resetBotInfoDurationLevel(str2, chatType3);
                }
                if (sendMessageOutput.status == SendMessageOutput.SendMessageStatus.OK) {
                    CoreMainClassImpl.this.processMessageAndChatUpdate(sendMessageOutput.message_updates, sendMessageOutput.chat_update, false, false);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    private SendMessageException checkMessageInput(Message message) {
        String str;
        String str2;
        String str3;
        StickerObject stickerObject;
        String str4;
        String str5;
        String str6;
        Message.MessageTypeEnum messageTypeEnum = message.type;
        if (messageTypeEnum == Message.MessageTypeEnum.FileInline || messageTypeEnum == Message.MessageTypeEnum.FileInlineCaption) {
            FileInlineObject fileInlineObject = message.file_inline;
            if (fileInlineObject == null) {
                return new SendMessageException("FileInline null");
            }
            if (fileInlineObject.file_id == 0) {
                return new SendMessageException("FileInline fileId 0");
            }
            String str7 = fileInlineObject.access_hash_rec;
            if (str7 == null || str7.isEmpty()) {
                return new SendMessageException("FileInline access_hash_rec\tfileId: " + message.file_inline.file_id);
            }
            String str8 = message.file_inline.dc_id;
            if (str8 == null || str8.isEmpty()) {
                return new SendMessageException("FileInline dcId");
            }
            FileInlineObject fileInlineObject2 = message.file_inline;
            FileInlineObject.FileInlineType fileInlineType = fileInlineObject2.type;
            if (fileInlineType == FileInlineObject.FileInlineType.Gif && (fileInlineObject2.width == 0 || fileInlineObject2.height == 0 || fileInlineObject2.time == 0)) {
                return new SendMessageException("FileInline Gif");
            }
            if (fileInlineType == FileInlineObject.FileInlineType.Voice && fileInlineObject2.time == 0) {
                return new SendMessageException("FileInline Voice");
            }
            if (fileInlineType == FileInlineObject.FileInlineType.Video && (fileInlineObject2.width == 0 || fileInlineObject2.height == 0 || fileInlineObject2.time == 0 || (str3 = fileInlineObject2.thumb_inline) == null || str3.isEmpty())) {
                return new SendMessageException("FileInline Video");
            }
            FileInlineObject fileInlineObject3 = message.file_inline;
            if (fileInlineObject3.type == FileInlineObject.FileInlineType.Image && (fileInlineObject3.width == 0 || fileInlineObject3.height == 0 || (str2 = fileInlineObject3.thumb_inline) == null || str2.isEmpty())) {
                return new SendMessageException("FileInline Image");
            }
            FileInlineObject fileInlineObject4 = message.file_inline;
            if (fileInlineObject4.type == FileInlineObject.FileInlineType.Music && ((str = fileInlineObject4.music_performer) == null || str.isEmpty() || message.file_inline.time == 0)) {
                return new SendMessageException("FileInline Music");
            }
        } else if (messageTypeEnum == Message.MessageTypeEnum.Sticker && ((stickerObject = message.sticker) == null || (str4 = stickerObject.emoji_character) == null || str4.isEmpty() || (str5 = message.sticker.sticker_id) == null || str5.isEmpty() || (str6 = message.sticker.sticker_set_id) == null || str6.isEmpty())) {
            return new SendMessageException("Sticker");
        }
        return null;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int callSendMessage(final String str, final ChatType chatType, Message message, boolean z, final LoadListener<SendMessageResult> loadListener) {
        if (str != null && chatType != null) {
            final SendMessageException sendMessageExceptionCheckMessageInput = checkMessageInput(message);
            return getMessageUtils().sendMessage(getKeyValueStorageHelper().getAuth(), str, chatType, message, z, getNetworkHelper(), getRubinoUtils(), new LoadListener<SendMessageOutput>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.14
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(SendMessageOutput sendMessageOutput) {
                    MessageUpdateObject messageUpdateObject;
                    SendMessageResult sendMessageResult = new SendMessageResult();
                    SendMessageOutput.SendMessageStatus sendMessageStatus = sendMessageOutput.status;
                    sendMessageResult.status = sendMessageStatus;
                    SendMessageOutput.SendMessageStatus sendMessageStatus2 = SendMessageOutput.SendMessageStatus.OK;
                    if (sendMessageStatus == sendMessageStatus2 && (messageUpdateObject = sendMessageOutput.message_update) != null) {
                        sendMessageResult.message = messageUpdateObject.message;
                        sendMessageResult.prev_message_id = messageUpdateObject.prev_message_id;
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(sendMessageResult);
                    }
                    ChatType chatType2 = chatType;
                    if (chatType2 == ChatType.Bot) {
                        CoreMainClassImpl.this.resetBotInfoDurationLevel(str, chatType2);
                    }
                    if (sendMessageOutput.status == sendMessageStatus2) {
                        CoreMainClassImpl.this.processMessageAndChatUpdate(sendMessageOutput.message_update, sendMessageOutput.chat_update, false, false);
                    }
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        SendMessageException sendMessageException = sendMessageExceptionCheckMessageInput;
                        if (sendMessageException != null) {
                            loadListener2.onError(sendMessageException);
                        } else {
                            loadListener2.onError(exc);
                        }
                    }
                }
            });
        }
        if (loadListener == null) {
            return 0;
        }
        loadListener.onError(new Exception());
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void saveMessageSendState(String str, Message message) {
        if (message == null) {
            return;
        }
        message.setTime();
        getMessageUtils().saveMessageSendingState(message, getDBHelper());
        Chat chatInstant = getChatInstant(str);
        if (chatInstant == null || chatInstant.lastMessageId != message.message_id) {
            return;
        }
        if (chatInstant.chatExtra == null) {
            chatInstant.chatExtra = new ChatExtra(str);
        }
        ChatExtra chatExtra = chatInstant.chatExtra;
        int i = chatExtra.local_last_message_send_state;
        int i2 = message.sendState;
        if (i != i2) {
            chatExtra.local_last_message_send_state = i2;
            getChatUtils().changeChatExtra(chatInstant.object_guid, chatInstant.chatExtra, getDBHelper());
            ChatNeedReloadResult chatNeedReloadResult = new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.SomeChatsUpdated);
            chatNeedReloadResult.updatedChats = new HashMap();
            HashSet hashSet = new HashSet();
            hashSet.add(ChatParamUpdateTimeObject.Params.last_message);
            chatNeedReloadResult.updatedChats.put(str, hashSet);
            getNotificationCenter().chatsNeedReload(chatNeedReloadResult);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void updateLocalMessage(String str, Message message) {
        if (message == null) {
            return;
        }
        message.setTime();
        getMessageUtils().addMessageToDb(str, message, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void deleteMessages(String str, ArrayList<Long> arrayList, DeleteMessagesInput.DeleteMessagesType deleteMessagesType, LoadListener<Integer> loadListener) {
        getMessageUtils().deleteMessages(str, arrayList, deleteMessagesType, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isChannel(String str) {
        ChatAbsObject absInstant = getAbsInstant(str);
        return absInstant != null && absInstant.type == ChatType.Channel;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isGroupChannel(String str) {
        ChatType chatType;
        ChatAbsObject absInstant = getAbsInstant(str);
        return absInstant != null && ((chatType = absInstant.type) == ChatType.Channel || chatType == ChatType.Group);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isBot(String str) {
        ChatAbsObject absInstant = getAbsInstant(str);
        return absInstant != null && absInstant.type == ChatType.Bot;
    }

    public boolean isUser(String str) {
        ChatAbsObject absInstant = getAbsInstant(str);
        return absInstant != null && absInstant.type == ChatType.User;
    }

    public boolean isGroup(String str) {
        ChatAbsObject absInstant = getAbsInstant(str);
        return absInstant != null && absInstant.type == ChatType.Group;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isService(String str) {
        ChatAbsObject absInstant = getAbsInstant(str);
        return absInstant != null && absInstant.type == ChatType.Service;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean hasAccessToViewSettingPage(String str) {
        HashSet<Chat.ChatAccessEnum> hashSet;
        Chat chatInstant = getChatInstant(str);
        if (chatInstant == null || (hashSet = chatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.ChangeInfo) || chatInstant.access.contains(Chat.ChatAccessEnum.BanMember) || (isChannel(str) && chatInstant.access.contains(Chat.ChatAccessEnum.ViewMembers)) || chatInstant.access.contains(Chat.ChatAccessEnum.SetAdmin) || chatInstant.access.contains(Chat.ChatAccessEnum.SetJoinLink);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean hasAccessToViewStats(String str) {
        Chat chatInstant = getChatInstant(str);
        return chatInstant != null && chatInstant.access != null && isChannel(str) && chatInstant.access.contains(Chat.ChatAccessEnum.ChangeInfo);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canSetType(String str) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (str == null || (chatForceGetChatInstant = forceGetChatInstant(str)) == null || (hashSet = chatForceGetChatInstant.access) == null) {
            return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.SuperAdmin);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isChannelPrivate(String str) {
        ChannelInfo channelInfo;
        ObjectInfo objectInfoInstant = getObjectInfoInstant(str);
        return objectInfoInstant == null || objectInfoInstant.objectType != ChatType.Channel || (channelInfo = objectInfoInstant.channelInfo) == null || channelInfo.channel_type == ChannelInfoFromServer.ChannelTypeEnum.Private;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int callEditMessage(final String str, final Message message, final LoadListener<Integer> loadListener) {
        return getMessageUtils().callEditMessage(str, message, getAuth(), getNetworkHelper(), getDBHelper(), new UpdateChatAndMessageUsecase(this), new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.15
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                CoreMainClassImpl.this.getMessageUtils().saveMessageOnLocallyEditChange(message, false, CoreMainClassImpl.this.getDBHelper(), true);
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(num);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                CoreMainClassImpl.this.revertEditingMessage(str, message);
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void prepareEditMessage(String str, Message message) {
        message.setTime();
        getMessageUtils().saveMessageOnLocallyEditChange(message, true, getDBHelper(), false);
        Chat chatInstant = getChatUtils().getChatInstant(str);
        if (chatInstant == null || chatInstant.last_message_id != message.message_id) {
            return;
        }
        getChatUtils().editChatLastMessage(str, message, getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void cancelEditMessage(String str, Message message, int i) {
        getNetworkHelper().cancelCall(i);
        revertEditingMessage(str, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void revertEditingMessage(String str, Message message) {
        getMessageUtils().saveMessageOnLocallyEditChange(message, false, getDBHelper(), false);
        Chat chatInstant = getChatUtils().getChatInstant(str);
        if (chatInstant == null || chatInstant.last_message_id != message.message_id) {
            return;
        }
        getChatUtils().editChatLastMessage(str, message, getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getGroupMessageReadParticipants(String str, long j, LoadListener<GetGroupMessageReadParticipantsResult> loadListener) {
        if (canGetGroupMessageReadParticipants(str, j)) {
            return getChatUtils().getGroupMessageReadParticipants(str, j, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
        }
        if (loadListener == null) {
            return 0;
        }
        loadListener.onError(new InputException());
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean canGetGroupMessageReadParticipants(String str, long j) {
        Chat chatForceGetChatInstant;
        HashSet<Chat.ChatAccessEnum> hashSet;
        ObjectInfo objectInfoInstant;
        GroupInfo groupInfo;
        Message messageByIdFromMapOrDb;
        String str2;
        ChatAbsObject chatAbsInstant = getChatUtils().getChatAbsInstant(str, getDBHelper());
        if (chatAbsInstant == null || chatAbsInstant.type != ChatType.Group || (chatForceGetChatInstant = getChatUtils().forceGetChatInstant(str, getDBHelper())) == null || (hashSet = chatForceGetChatInstant.access) == null || !hashSet.contains(Chat.ChatAccessEnum.ViewMembers) || (objectInfoInstant = getChatUtils().getObjectInfoInstant(str)) == null || (groupInfo = objectInfoInstant.groupInfo) == null || groupInfo.count_members > 100 || (messageByIdFromMapOrDb = getMessageUtils().getMessageByIdFromMapOrDb(str, j, getDBHelper())) == null || (str2 = messageByIdFromMapOrDb.author_object_guid) == null || !str2.equals(getMyGuid())) {
            return false;
        }
        long j2 = messageByIdFromMapOrDb.message_id;
        return j2 >= 0 && messageByIdFromMapOrDb.sendState == 0 && j2 <= chatForceGetChatInstant.last_seen_peer_mid && getTimeMillis() - (messageByIdFromMapOrDb.time * 1000) < 604800000;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void prepareSendMessage(String str, Message message) {
        message.setTime();
        getChatUtils().updateChatLastLocal(str, message, getDBHelper(), getNotificationCenter());
        getMessageUtils().addMessageToDb(str, message, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void cancelSendingMessage(String str, long j, int i) {
        getNetworkHelper().cancelCall(i);
        getMessageUtils().removeLocalMessage(str, j, getDBHelper());
        Chat chatInstant = getChatUtils().getChatInstant(str);
        if (chatInstant == null || j != chatInstant.lastMessageId) {
            return;
        }
        Message lastLocalMessage = getDBHelper().getLastLocalMessage(str, null);
        if (lastLocalMessage != null) {
            getChatUtils().removeChatLastLocal(str, getDBHelper(), getNotificationCenter(), false);
            getChatUtils().updateChatLastLocal(str, lastLocalMessage, getDBHelper(), getNotificationCenter());
        } else {
            getChatUtils().removeChatLastLocal(str, getDBHelper(), getNotificationCenter(), true);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void localMessageSent(String str, long j) {
        getMessageUtils().removeLocalMessage(str, j, getDBHelper());
        Chat chatInstant = getChatUtils().getChatInstant(str);
        if (chatInstant == null || j != chatInstant.lastMessageId) {
            return;
        }
        getChatUtils().removeChatLastLocal(str, getDBHelper(), getNotificationCenter(), false);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<Message> getAllUnsentMessages(Set<Integer> set) {
        return getMessageUtils().getAllUnsentMessages(getDBHelper(), set);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void startChatList() {
        getChatUtils().startChatList(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), getTimerHelper(), false, new UpdateChatUsecase(this));
        getContactAndImportPhoneBookIfNeeded(true, false);
    }

    public void loadChatsByGuidIfNeeded(Set<String> set, LoadListener<Set<String>> loadListener) {
        getChatUtils().loadChatsByGuidIfNeeded(set, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    public void initChatListAndMap() {
        if (isAccountLoggedIn()) {
            getChatUtils().initChatList(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), getTimerHelper(), false, new UpdateChatUsecase(this), null);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void initFolders() {
        if (isAccountLoggedIn()) {
            getChatUtils().initFolders(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter());
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void forceGetFolders() {
        if (isAccountLoggedIn()) {
            getChatUtils().getFoldersFromServerIfNeeded(true, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter());
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadSuggestedFilters(LoadListener<ArrayList<DialogFilterSuggested>> loadListener) {
        if (isAccountLoggedIn()) {
            getChatUtils().getSuggestedFolders(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), loadListener);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addOrEditFolder(String str, int i, String str2, ArrayList<ObjectGuidType> arrayList, ArrayList<ObjectGuidType> arrayList2, String str3, LoadListener<FolderObject> loadListener) {
        if (isAccountLoggedIn()) {
            getChatUtils().addOrEditFolder(str, i, str2, arrayList, arrayList2, str3, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), loadListener);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void deleteFolder(String str, LoadListener<String> loadListener) {
        if (isAccountLoggedIn()) {
            getChatUtils().deleteFolder(str, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), loadListener);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void reorderFolders(ArrayList<String> arrayList) {
        if (isAccountLoggedIn()) {
            getChatUtils().reorderFolders(arrayList, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper());
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int searchGlobalObjects(String str, String str2, ArrayList<SearchGlobalObjectsInput.FilterType> arrayList, LoadListener<SearchGlobalObjectsOutput> loadListener) {
        if (isAccountLoggedIn()) {
            return getChatUtils().searchGlobalObjects(str, str2, arrayList, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
        }
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int searchGlobalMessagesText(String str, String str2, LoadListener<SearchGlobalMessagesOutput> loadListener) {
        if (isAccountLoggedIn()) {
            return getMessageUtils().searchGlobalMessagesText(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
        }
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<InSearchObject> searchLocalInContacts(String str) {
        if (isAccountLoggedIn()) {
            return getChatUtils().searchLocalInContacts(str, getDBHelper(), getNotificationCenter());
        }
        return new ArrayList<>();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<InSearchObject> searchLocalInChats(String str, String str2) {
        if (isAccountLoggedIn()) {
            return getChatUtils().searchLocalInChats(str, str2, getDBHelper(), getNotificationCenter());
        }
        return new ArrayList<>();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int searchGlobalMessagesHashtag(String str, String str2, LoadListener<SearchGlobalMessagesOutput> loadListener) {
        if (isAccountLoggedIn()) {
            return getMessageUtils().searchGlobalMessagesHashtag(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
        }
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int searchChatMessagesText(String str, String str2, LoadListener<SearchChatMessagesResult> loadListener) {
        if (isAccountLoggedIn()) {
            return getMessageUtils().searchChatMessagesText(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
        }
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int searchChatMessagesHashtag(String str, String str2, LoadListener<SearchChatMessagesResult> loadListener) {
        if (isAccountLoggedIn()) {
            return getMessageUtils().searchChatMessagesHashtag(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
        }
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void seenChat(String str, ChatType chatType, long j, boolean z) {
        if (isAccountLoggedIn()) {
            getNotificationUtils().removeNotificationToMessageId(str, chatType, j, getNotificationCenter(), getDBHelper());
            getChatUtils().seenChat(str, j, z, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getTimerHelper(), new UpdateChatUsecase(this));
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void seenChannelMessages(String str, long j, long j2) {
        getMessageUtils().seenChannelMessages(str, j, j2, getKeyValueStorageHelper().getAuth(), getNetworkHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getChannelMessagesSeenCount(String str, long j, long j2) {
        getMessageUtils().getChannelMessagesSeenCount(str, str, j, j2, null, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getChatReaction(String str, long j, long j2) {
        getMessageUtils().getChatReaction(str, j, j2, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new LoadAbsUsecase(this), isChannel(str));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void actionOnMessageReaction(String str, long j, String str2, boolean z, LoadListener<ArrayList<MessageReactionObject>> loadListener) {
        getMessageUtils().actionOnMessageReaction(str, j, str2, z ? SettingModels.ActionOnMessageReactionTypeEnum.Add : SettingModels.ActionOnMessageReactionTypeEnum.Remove, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getMessageReactions(String str, ChatType chatType, long j, String str2, LoadListener<SettingModels.GetMessageReactionsOutput> loadListener) {
        if ((isUser(str) || isGroup(str)) && canShowReactions(str, chatType)) {
            getMessageUtils().getMessageReactions(str, chatType, j, str2, getAuth(), getNetworkHelper(), getDBHelper(), loadListener, new LoadAbsUsecase(this));
        } else if (loadListener != null) {
            loadListener.onError(new InvalidInputException("message reaction"));
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void changeChatLocalCountUnseen(String str, int i) {
        if (isAccountLoggedIn()) {
            getChatUtils().changeChatLocalCountUnseen(str, i, getDBHelper(), getNotificationCenter());
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void togglePinMessage(String str, long j, boolean z, LoadListener<PinMessageResult> loadListener) {
        if (isAccountLoggedIn()) {
            getMessageUtils().togglePinMessage(str, j, z, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), new UpdateChatAndMessageUsecase(this), loadListener);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void unpinAllMessages(String str, LoadListener<PinMessageResult> loadListener) {
        if (isAccountLoggedIn()) {
            getMessageUtils().unPinAllMessages(str, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), new UpdateChatAndMessageUsecase(this), loadListener);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadMoreChat() {
        if (isAccountLoggedIn()) {
            getChatUtils().loadMoreChat(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long getBotInfoUpdateDuration() {
        /*
            r4 = this;
            int r0 = r4.getBotInfoDurationLevel
            r1 = 2
            r2 = 60
            if (r0 != 0) goto La
        L7:
            r1 = 60
            goto L17
        La:
            r3 = 1
            if (r0 != r3) goto L10
            r1 = 15
            goto L17
        L10:
            if (r0 != r1) goto L14
            r1 = 5
            goto L17
        L14:
            r3 = 3
            if (r0 != r3) goto L7
        L17:
            int r1 = r1 * 1000
            long r0 = (long) r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.aaap.messengercore.CoreMainClassImpl.getBotInfoUpdateDuration():long");
    }

    public void resetBotInfoDurationLevel(String str, ChatType chatType) {
        this.getBotInfoDurationLevel = 3;
        onBotInfoLevelChanged(str, chatType);
    }

    public void decreaseBotInfoDurationLevel(String str, ChatType chatType) {
        int i = this.getBotInfoDurationLevel;
        if (i > 0) {
            this.getBotInfoDurationLevel = i - 1;
            onBotInfoLevelChanged(str, chatType);
        }
    }

    private void onBotInfoLevelChanged(String str, ChatType chatType) {
        UpdateBotInfoUsecase updateBotInfoUsecase = new UpdateBotInfoUsecase(this);
        getMessageUtils().onBotInfoLevelChanged(str, chatType, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), getTimerHelper(), new UpdateMessageUsecase(this), new GetChatAccessUseCase(this), updateBotInfoUsecase);
        getChatUtils().onBotInfoLevelChanged(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getTimerHelper(), str, chatType, updateBotInfoUsecase);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void stopChatList() {
        getChatUtils().stopChatList(getTimerHelper(), getNetworkHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void startMessageList(String str, ChatType chatType) {
        UpdateBotInfoUsecase updateBotInfoUsecase = new UpdateBotInfoUsecase(this);
        getMessageUtils().startMessageList(str, chatType, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), getTimerHelper(), new UpdateMessageUsecase(this), new GetChatAccessUseCase(this), updateBotInfoUsecase);
        getChatUtils().startObjectInfoUpdate(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getTimerHelper(), str, chatType, updateBotInfoUsecase);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void stopMessageList(String str) {
        getMessageUtils().stopMessageList(getAuth(), getNetworkHelper(), getTimerHelper(), str);
        getChatUtils().stopObjectInfoUpdate(getNetworkHelper(), getTimerHelper(), str);
        getChatUtils().forceLastRunnableSeenChat(str, getTimerHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getCurrentLiveLocation(String str, long j, String str2, LoadListener<LiveLocationObject> loadListener) {
        getMessageUtils().requestUpdateLiveLocation(str, j, str2, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int stopLiveLocation(String str, long j, String str2, LoadListener<LiveLocationObject> loadListener) {
        return getMessageUtils().stopLiveLocation(str, j, str2, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<Chat> getChatListInstant() {
        return getChatUtils().getChatList();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<FolderObject> getFolderListInstant() {
        return getChatUtils().getFoldersInstant();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<ChatAdsObject> getChatAdsInstant() {
        return getChatUtils().getChatAdsInstant(getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void actionOnChatAds(String str, ActionOnChatAdsInput.Action action) {
        getChatUtils().actionOnChatAds(str, action, getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<DialogFilterSuggested> getSuggestedFolderListInstant() {
        return getChatUtils().getSuggestedFolderListInstant();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getFolderUnreadCount(String str) {
        if (isCoreInitiated() && isAccountLoggedIn()) {
            return getChatUtils().getFolderCountUnread(str);
        }
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getAllUnreadCountAccount() {
        if (isAccountLoggedIn()) {
            return getChatUtils().getAllCountUnread(getDBHelper());
        }
        return 0;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getMaxFoldersCount() {
        return MAX_FOLDER_COUNT;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean getChatListHasContinue() {
        return getChatUtils().getChatListHasContinue();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public Chat getChatInstant(String str) {
        return getChatUtils().getChatInstant(str);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public Chat forceGetChatInstant(String str) {
        return getChatUtils().forceGetChatInstant(str, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public Message getMessageInstant(String str, long j) {
        return getMessageUtils().getMessageByIdFromMapOrDb(str, j, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ChatAbsObject getAbsInstant(String str) {
        return getChatUtils().getChatAbsInstant(str, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean loadForGuid(String str) {
        return getChatUtils().loadForGuid(str, getDBHelper(), getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void initAndLoadMyStickersIfNeeded(boolean z) {
        getMessageUtils().initAndLoadMyStickersIfNeeded(z, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getTrendStickerSet(boolean z, String str, LoadListener<GetStickersOutput> loadListener) {
        if (isAccountLoggedIn()) {
            getMessageUtils().getTrendStickerSet(z, str, getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), loadListener);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getMyArchivedStickerSets(String str, String str2, LoadListener<GetStickersOutput> loadListener) {
        getMessageUtils().getMyArchivedStickerSets(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int searchStickerSets(String str, String str2, LoadListener<GetStickersOutput> loadListener) {
        return getMessageUtils().searchStickerSets(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getStickersByEmoji(String str, String str2, LoadListener<GetStickersByEmojiOutput> loadListener) {
        getMessageUtils().getStickersByEmoji(str, str2, SettingModels.StickerSettingObject.SuggestTypeEnum.All, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getStickersSetById(String str, LoadListener<Integer> loadListener) {
        getMessageUtils().getStickerSetByID(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getMessageShareUrl(String str, long j, LoadListener<GetMessageShareUrlOutput> loadListener) {
        getMessageUtils().getMessageShareUrl(str, j, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getLinkFromAppUrl(String str, LoadListener<GetLinkFromAppUrlOutput> loadListener) {
        return getMessageUtils().getLinkFromAppUrl(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void clickMessageUrl(String str, String str2, String str3) {
        getMessageUtils().clickMessageUrl(str, str2, str3, getAuth(), getNetworkHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void reorderStickerSets(ArrayList<String> arrayList) {
        getMessageUtils().reorderStickerSets(arrayList, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getGroupAllMembers(String str, String str2, String str3, final GetMemberListener getMemberListener) {
        return getChatUtils().getGroupAllMembersFromServer(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), str, str2, str3, new GetMemberListener() { // from class: ir.aaap.messengercore.CoreMainClassImpl.16
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(final ArrayList<InChatMember> arrayList, final boolean z, final String str4) {
                CoreMainClassImpl.this.loadAbsForInChatMembers(arrayList, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.16.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersDidLoad(arrayList, z, str4);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersLoadingFailed();
                        }
                    }
                });
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersLoadingFailed();
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getGroupNotAdminMembers(String str, String str2, String str3, final GetMemberListener getMemberListener) {
        return getChatUtils().getGroupNotAdminMembersFromServer(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), str, str2, str3, new GetMemberListener() { // from class: ir.aaap.messengercore.CoreMainClassImpl.17
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(final ArrayList<InChatMember> arrayList, final boolean z, final String str4) {
                CoreMainClassImpl.this.loadAbsForInChatMembers(arrayList, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.17.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersDidLoad(arrayList, z, str4);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersLoadingFailed();
                        }
                    }
                });
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersLoadingFailed();
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getChannelAllMembers(String str, String str2, String str3, final GetMemberListener getMemberListener) {
        return getChatUtils().getChannelAllMembersFromServer(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), str, str2, str3, new GetMemberListener() { // from class: ir.aaap.messengercore.CoreMainClassImpl.18
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(final ArrayList<InChatMember> arrayList, final boolean z, final String str4) {
                CoreMainClassImpl.this.loadAbsForInChatMembers(arrayList, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.18.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersDidLoad(arrayList, z, str4);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersLoadingFailed();
                        }
                    }
                });
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersLoadingFailed();
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getChannelNotAdminMembers(String str, String str2, String str3, final GetMemberListener getMemberListener) {
        return getChatUtils().getChannelNotAdminMembersFromServer(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), str, str2, str3, new GetMemberListener() { // from class: ir.aaap.messengercore.CoreMainClassImpl.19
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(final ArrayList<InChatMember> arrayList, final boolean z, final String str4) {
                CoreMainClassImpl.this.loadAbsForInChatMembers(arrayList, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.19.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersDidLoad(arrayList, z, str4);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersLoadingFailed();
                        }
                    }
                });
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersLoadingFailed();
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getGroupMentionList(String str, String str2, String str3, GetMemberListener getMemberListener) {
        return getChatUtils().getGroupMentionListFromServer(str, str2, str3, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getMemberListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getGroupAdmins(String str, String str2, String str3, final GetMemberListener getMemberListener) {
        return getChatUtils().getGroupAdminsFromServer(str, str2, str3, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), new GetMemberListener() { // from class: ir.aaap.messengercore.CoreMainClassImpl.20
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(final ArrayList<InChatMember> arrayList, final boolean z, final String str4) {
                CoreMainClassImpl.this.loadAbsForInChatMembers(arrayList, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.20.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersDidLoad(arrayList, z, str4);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersLoadingFailed();
                        }
                    }
                });
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersLoadingFailed();
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getChannelAdmins(String str, String str2, String str3, final GetMemberListener getMemberListener) {
        return getChatUtils().getChannelAdminsFromServer(str, str2, str3, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), new GetMemberListener() { // from class: ir.aaap.messengercore.CoreMainClassImpl.21
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(final ArrayList<InChatMember> arrayList, final boolean z, final String str4) {
                CoreMainClassImpl.this.loadAbsForInChatMembers(arrayList, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.21.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersDidLoad(arrayList, z, str4);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        GetMemberListener getMemberListener2 = getMemberListener;
                        if (getMemberListener2 != null) {
                            getMemberListener2.onMembersLoadingFailed();
                        }
                    }
                });
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersLoadingFailed();
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getGroupBannedMembers(String str, String str2, String str3, final GetMemberListener getMemberListener) {
        return getChatUtils().getGroupBannedMembersFromServer(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), str, str2, str3, new GetMemberListener(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.22
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(ArrayList<InChatMember> arrayList, boolean z, String str4) {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersDidLoad(arrayList, z, str4);
                }
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersLoadingFailed();
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getChannelBannedMembers(String str, String str2, String str3, final GetMemberListener getMemberListener) {
        return getChatUtils().getChannelBannedMembersFromServer(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), str, str2, str3, new GetMemberListener(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.23
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(ArrayList<InChatMember> arrayList, boolean z, String str4) {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersDidLoad(arrayList, z, str4);
                }
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                GetMemberListener getMemberListener2 = getMemberListener;
                if (getMemberListener2 != null) {
                    getMemberListener2.onMembersLoadingFailed();
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getGroupAdminAccessList(String str, String str2, GetGroupAdminAccessListListener getGroupAdminAccessListListener) {
        getChatUtils().getGroupAdminAccessList(str, str2, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getGroupAdminAccessListListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getGroupDefaultAccessList(String str, GetGroupDefaultAccessListListener getGroupDefaultAccessListListener) {
        getChatUtils().getGroupDefaultAccess(str, getAuth(), getNetworkHelper(), getGroupDefaultAccessListListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setGroupDefaultAccessList(String str, ArrayList<Chat.EnumSetGroupMemberAccess> arrayList) {
        getChatUtils().setGroupDefaultAccess(str, arrayList, getAuth(), getNetworkHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getChannelAdminAccessList(String str, String str2, GetChannelAdminAccessListListener getChannelAdminAccessListListener) {
        getChatUtils().getChannelAdminAccessList(str, str2, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getChannelAdminAccessListListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void reportObject(String str, ReportObjectInput.ReportTypeEnum reportTypeEnum, String str2, LoadListener<Integer> loadListener) {
        ReportObjectInput reportObjectInput = new ReportObjectInput();
        reportObjectInput.object_guid = str;
        reportObjectInput.report_type_object = ReportObjectInput.ReportType.Object;
        reportObjectInput.report_type = reportTypeEnum != null ? reportTypeEnum.value : ReportObjectInput.ReportTypeEnum.Other.value;
        reportObjectInput.report_description = str2;
        callReport(reportObjectInput, loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void reportMessage(String str, String str2, ReportObjectInput.ReportTypeEnum reportTypeEnum, String str3, LoadListener<Integer> loadListener) {
        ReportObjectInput reportObjectInput = new ReportObjectInput();
        reportObjectInput.object_guid = str;
        reportObjectInput.message_id = str2;
        reportObjectInput.report_type_object = ReportObjectInput.ReportType.Message;
        reportObjectInput.report_type = reportTypeEnum != null ? reportTypeEnum.value : ReportObjectInput.ReportTypeEnum.Other.value;
        reportObjectInput.report_description = str3;
        callReport(reportObjectInput, loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void reportLive(String str, ReportObjectInput.ReportTypeEnum reportTypeEnum, String str2, LoadListener<Integer> loadListener) {
        ReportObjectInput reportObjectInput = new ReportObjectInput();
        reportObjectInput.live_id = str;
        reportObjectInput.report_type_object = ReportObjectInput.ReportType.Live;
        reportObjectInput.report_type = reportTypeEnum != null ? reportTypeEnum.value : ReportObjectInput.ReportTypeEnum.Other.value;
        reportObjectInput.report_description = str2;
        callReport(reportObjectInput, loadListener);
    }

    private void callReport(ReportObjectInput reportObjectInput, final LoadListener<Integer> loadListener) {
        try {
            getNetworkHelper().reportObject(getAuth(), reportObjectInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ReportObjectOutput>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.24
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ReportObjectOutput reportObjectOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            getCoreLog().handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getCommonGroups(String str, LoadListener<ArrayList<ChatAbsObject>> loadListener) {
        return getChatUtils().getCommonGroups(str, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getGroupLink(String str, LoadListener<String> loadListener) {
        getChatUtils().getGroupLink(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int groupPreviewByJoinLink(String str, LoadListener<ChatInviteObject> loadListener) {
        return getChatUtils().groupPreviewByJoinLink(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int channelPreviewByJoinLink(String str, LoadListener<ChatInviteObject> loadListener) {
        return getChatUtils().channelPreviewByJoinLink(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int checkChannelUsername(String str, LoadListener<CoreUtilities.UsernameCheckType> loadListener) {
        return getChatUtils().checkChannelUsername(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int updateProfile(String str, String str2, String str3, LoadListener<Integer> loadListener) {
        return getChatUtils().updateProfile(str, str2, str3, getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int updateProfileName(String str, String str2, LoadListener<Integer> loadListener) {
        UserInfo myUserInfo = getMyUserInfo();
        return getChatUtils().updateProfile(str, str2, myUserInfo != null ? myUserInfo.bio : null, getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int updateProfileBio(String str, LoadListener<Integer> loadListener) {
        String myGuid = getMyGuid();
        ChatAbsObject absInstant = myGuid != null ? getAbsInstant(myGuid) : null;
        return getChatUtils().updateProfile(absInstant != null ? absInstant.first_name : null, absInstant != null ? absInstant.last_name : null, str, getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int updateUserLocation(LocationObject locationObject, LoadListener<Integer> loadListener) {
        return getChatUtils().updateUserLocation(locationObject, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int checkUserUsername(String str, LoadListener<CoreUtilities.UsernameCheckType> loadListener) {
        return getChatUtils().checkUserUsername(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int checkRubinoUsername(String str, LoadListener<CoreUtilities.UsernameCheckType> loadListener) {
        return getChatUtils().checkRubinoUsername(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void updateChannelUsername(String str, String str2, LoadListener<UpdateChannelUsernameOutput.StatusEnum> loadListener) {
        getChatUtils().updateChannelUsername(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int updateUserUsername(String str, String str2, LoadListener<UpdateUserUsernameOutput.StatusEnum> loadListener) {
        return getChatUtils().updateUserUsername(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int checkChannelsWithUsername(LoadListener<CheckChannelsWithUsernameResult> loadListener) {
        return getChatUtils().checkChannelsWithUsername(getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getAllChannelStatistics(String str, LoadListener<GetAllStatisticsOutput> loadListener) {
        getChatUtils().getAllChannelStatistics(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getChannelLink(String str, LoadListener<String> loadListener) {
        getChatUtils().getChannelLink(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setGroupLink(String str, LoadListener<String> loadListener) {
        getChatUtils().setGroupLink(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setChannelLink(String str, LoadListener<String> loadListener) {
        getChatUtils().setChannelLink(str, getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setGroupAdmin(String str, String str2, ArrayList<Chat.EnumSetGroupAdminAccess> arrayList, String str3, LoadListener<InChatMember> loadListener) {
        getChatUtils().setGroupAdmin(str, str2, arrayList, str3, getAuth(), getNetworkHelper(), getDBHelper(), new UpdateGroupVoiceChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void unSetGroupAdmin(String str, String str2, LoadListener<InChatMember> loadListener) {
        getChatUtils().unsetGroupAdmin(str, str2, getAuth(), getNetworkHelper(), getDBHelper(), new UpdateGroupVoiceChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setChannelAdmin(String str, String str2, ChatType chatType, ArrayList<Chat.EnumSetChannelAdminAccess> arrayList, LoadListener<InChatMember> loadListener) {
        getChatUtils().setChannelAdmin(str, str2, chatType, arrayList, getAuth(), getNetworkHelper(), getDBHelper(), new UpdateGroupVoiceChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void unSetChannelAdmin(String str, String str2, ChatType chatType, LoadListener<InChatMember> loadListener) {
        getChatUtils().unsetChannelAdmin(str, str2, chatType, getAuth(), getNetworkHelper(), getDBHelper(), new UpdateGroupVoiceChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void banGroupMember(String str, String str2, boolean z, LoadListener<Integer> loadListener) {
        getChatUtils().banGroupMember(str, str2, z, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), new UpdateGroupVoiceChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void banChannelMember(String str, String str2, boolean z, LoadListener<Integer> loadListener) {
        getChatUtils().banChannelMember(str, str2, z, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateGroupVoiceChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addGroupMembers(String str, ArrayList<String> arrayList, LoadListener<ArrayList<InChatMember>> loadListener) {
        getChatUtils().addGroupMembers(str, arrayList, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addChannelMembers(String str, ArrayList<String> arrayList, LoadListener<ArrayList<InChatMember>> loadListener) {
        getChatUtils().addChannelMembers(str, arrayList, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getAvatars(String str, GetAvatarsListener getAvatarsListener) {
        getChatUtils().getAvatars(getAuth(), getNetworkHelper(), str, getAvatarsListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void uploadAvatar(String str, String str2, String str3, LoadListener<AvatarFileInline> loadListener) {
        getChatUtils().uploadAvatar(getAuth(), str, str2, str3, getNetworkHelper(), getDBHelper(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void deleteAvatar(String str, String str2, LoadListener<AvatarFileInline> loadListener) {
        getChatUtils().deleteAvatar(getAuth(), str, str2, getNetworkHelper(), getDBHelper(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void requestSendFile(String str, String str2, long j, final LoadListener<RequestSendFileOutput> loadListener) {
        RequestSendFileInput requestSendFileInput = new RequestSendFileInput();
        requestSendFileInput.file_name = str;
        requestSendFileInput.mime = str2;
        requestSendFileInput.size = j;
        try {
            getNetworkHelper().requestSendFile(getKeyValueStorageHelper().getAuth(), requestSendFileInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<RequestSendFileOutput>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.25
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RequestSendFileOutput requestSendFileOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(requestSendFileOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            getCoreLog().handleException(e);
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int sendFile(String str, SendFileInput sendFileInput, final CoreMainClass.FileUpLoadResponseListener fileUpLoadResponseListener) {
        try {
            return getNetworkHelper().sendFile(str, getKeyValueStorageHelper().getAuth(), sendFileInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendFileOutput>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.26
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendFileOutput sendFileOutput) {
                    if (fileUpLoadResponseListener != null) {
                        if (sendFileOutput == null || TextUtils.isEmpty(sendFileOutput.access_hash_rec)) {
                            fileUpLoadResponseListener.onFileDidUpload(null);
                            return;
                        }
                        SendFileResult sendFileResult = new SendFileResult();
                        sendFileResult.access_hash_rec = sendFileOutput.access_hash_rec;
                        fileUpLoadResponseListener.onFileDidUpload(sendFileResult);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    CoreMainClass.FileUpLoadResponseListener fileUpLoadResponseListener2 = fileUpLoadResponseListener;
                    if (fileUpLoadResponseListener2 != null) {
                        fileUpLoadResponseListener2.onFileUploadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (fileUpLoadResponseListener != null) {
                fileUpLoadResponseListener.onFileUploadingFailed();
            }
            getCoreLog().handleException(e);
            return 0;
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getFile(String str, String str2, long j, long j2, String str3, String str4, final CoreMainClass.FileLoadResponseListener fileLoadResponseListener) {
        logIfPossible("CoreMainClassImpl", "getFile: dc_id " + str + " startIndex " + j + " endIndex " + j2);
        String storageUrl = getDataCenterManager().getStorageUrl(getKeyValueStorageHelper().getAuth(), str, str2);
        if (storageUrl == null || storageUrl.isEmpty()) {
            getDataCenterManager().reloadDcs(getKeyValueStorageHelper().getAuth());
            if (fileLoadResponseListener == null) {
                return -1;
            }
            fileLoadResponseListener.onFileLoadingFailed();
            return -1;
        }
        GetFileInput getFileInput = new GetFileInput(str, j, j2, str3, str4);
        if (str2 != null) {
            try {
                return getNetworkHelper().getFileCdn(str, str2, getKeyValueStorageHelper().getAuth(), getFileInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetFileResult>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.27
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(GetFileResult getFileResult) {
                        CoreMainClass.FileLoadResponseListener fileLoadResponseListener2 = fileLoadResponseListener;
                        if (fileLoadResponseListener2 != null) {
                            fileLoadResponseListener2.onFileDidLoad(getFileResult);
                        }
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        CoreMainClass.FileLoadResponseListener fileLoadResponseListener2 = fileLoadResponseListener;
                        if (fileLoadResponseListener2 != null) {
                            fileLoadResponseListener2.onFileLoadingFailed();
                        }
                    }
                });
            } catch (Exception e) {
                getCoreLog().handleException(e);
                if (getCoreLog().isDebug()) {
                    throw new RuntimeException();
                }
                return -1;
            }
        }
        try {
            return getNetworkHelper().getFile(storageUrl, getKeyValueStorageHelper().getAuth(), getFileInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetFileResult>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.28
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetFileResult getFileResult) {
                    CoreMainClass.FileLoadResponseListener fileLoadResponseListener2 = fileLoadResponseListener;
                    if (fileLoadResponseListener2 != null) {
                        fileLoadResponseListener2.onFileDidLoad(getFileResult);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    CoreMainClass.FileLoadResponseListener fileLoadResponseListener2 = fileLoadResponseListener;
                    if (fileLoadResponseListener2 != null) {
                        fileLoadResponseListener2.onFileLoadingFailed();
                    }
                }
            });
        } catch (Exception e2) {
            getCoreLog().handleException(e2);
            if (getCoreLog().isDebug()) {
                throw new RuntimeException();
            }
            return -1;
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getExternalFile(String str, final CoreMainClass.FileLoadResponseListener fileLoadResponseListener) {
        logIfPossible("CoreMainClassImpl", "getExternalFile: " + str);
        if (str == null || str.isEmpty()) {
            return -1;
        }
        try {
            return getNetworkHelper().getExternalFile(str, getKeyValueStorageHelper().getAuth(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetFileResult>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.29
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetFileResult getFileResult) {
                    CoreMainClass.FileLoadResponseListener fileLoadResponseListener2 = fileLoadResponseListener;
                    if (fileLoadResponseListener2 != null) {
                        fileLoadResponseListener2.onFileDidLoad(getFileResult);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    CoreMainClass.FileLoadResponseListener fileLoadResponseListener2 = fileLoadResponseListener;
                    if (fileLoadResponseListener2 != null) {
                        fileLoadResponseListener2.onFileLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            getCoreLog().handleException(e);
            if (getCoreLog().isDebug()) {
                throw new RuntimeException();
            }
            return -1;
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void cancelGetFile(int i) {
        getNetworkHelper().cancelCall(i);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void cancelRefreshObjectInfo(String str) {
        getChatUtils().cancelRefreshObjectInfo(str);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int refreshObjectInfo(String str, ChatType chatType, boolean z, LoadListener<String> loadListener, boolean z2) {
        return getChatUtils().refreshObjectInfoIfNeeded(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener, str, chatType, z, new UpdateBotInfoUsecase(this), z2);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getObjectInfoByUsername(String str, boolean z, LoadListener<String> loadListener) {
        return getChatUtils().getObjectInfoByUsername(str, z, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getProfileLinkItems(String str, LoadListener<GetProfileLinkItemsOutputs> loadListener) {
        return getChatUtils().getProfileLinkItems(str, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void saveHiddenWarningId(String str, String str2) {
        getChatUtils().saveHiddenWarningId(str, str2, getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public String getHiddenWarningId(String str) {
        return getChatUtils().getHiddenWarningId(str, getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ObjectInfo getObjectInfoInstant(String str) {
        return getChatUtils().getObjectInfoInstant(str);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getMapView(LocationObject locationObject, LoadListener<MapViewObject> loadListener) {
        return getMessageUtils().getMapView(locationObject, getAuth(), getNetworkHelper(), loadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadReplyForMessages(final String str, final ChatType chatType, ArrayList<Message> arrayList, final LoadListener<Integer> loadListener) {
        getMessageUtils().loadReplyForMessages(str, arrayList, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), new LoadListener<ArrayList<Message>>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.30
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ArrayList<Message> arrayList2) {
                CoreMainClassImpl.this.getNotificationCenter().replyMessagesDidLoad(str, chatType, arrayList2);
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(1);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAbsAndRepliesForMessages(final String str, final ChatType chatType, final ArrayList<Message> arrayList, final boolean z, final LoadListener<Integer> loadListener) {
        loadAbsForMessages(arrayList, str, chatType, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.31
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                CoreMainClassImpl.this.loadReplyForMessages(str, chatType, arrayList, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.31.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num2) {
                        Message.ForwardFromObject forwardFromObject;
                        ArrayList arrayList2 = arrayList;
                        if (arrayList2 != null) {
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                Message message = (Message) it.next();
                                AnonymousClass31 anonymousClass31 = AnonymousClass31.this;
                                if (chatType != ChatType.Channel && (forwardFromObject = message.forwarded_from) != null && forwardFromObject.type_from == Message.ForwardFromType.Channel) {
                                    MessageUtils messageUtils = CoreMainClassImpl.this.getMessageUtils();
                                    AnonymousClass31 anonymousClass312 = AnonymousClass31.this;
                                    messageUtils.getForwardedFromChannelMessagesSeenCount(str, message, CoreMainClassImpl.this.getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getDBHelper(), CoreMainClassImpl.this.getNotificationCenter());
                                }
                            }
                        }
                        AnonymousClass31 anonymousClass313 = AnonymousClass31.this;
                        if (chatType == ChatType.Channel && z) {
                            MessageUtils messageUtils2 = CoreMainClassImpl.this.getMessageUtils();
                            AnonymousClass31 anonymousClass314 = AnonymousClass31.this;
                            messageUtils2.getChannelMessagesSeenCount(str, arrayList, CoreMainClassImpl.this.getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getDBHelper(), CoreMainClassImpl.this.getNotificationCenter());
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onError(exc);
                        }
                    }
                });
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    private void loadAbsForMessages(ArrayList<Message> arrayList, final String str, ChatType chatType, final LoadListener<Integer> loadListener) {
        String str2;
        ArrayList<ObjectGuidType> arrayList2;
        ObjectGuidType objectGuidType;
        String str3;
        PollStatusObject pollStatusObject;
        ArrayList<String> arrayList3;
        String str4;
        String str5;
        if (arrayList == null || arrayList.size() <= 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(0);
                return;
            }
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            if ((chatType == ChatType.Group || next.type == Message.MessageTypeEnum.LiveLocation) && (str2 = next.author_object_guid) != null) {
                hashSet.add(str2);
            }
            Message.ForwardFromObject forwardFromObject = next.forwarded_from;
            if (forwardFromObject != null && (str5 = forwardFromObject.object_guid) != null) {
                hashSet.add(str5);
            }
            ContactMessageObject contactMessageObject = next.contact_message;
            if (contactMessageObject != null && (str4 = contactMessageObject.user_guid) != null) {
                hashSet.add(str4);
            }
            PollObject pollObject = next.poll;
            if (pollObject != null && (pollStatusObject = pollObject.poll_status) != null && (arrayList3 = pollStatusObject.voters_object_guids) != null && arrayList3.size() > 0) {
                hashSet.addAll(next.poll.poll_status.voters_object_guids);
            }
            Message.EventObject eventObject = next.event_data;
            if (eventObject != null && (objectGuidType = eventObject.performer_object) != null && (str3 = objectGuidType.object_guid) != null) {
                hashSet.add(str3);
            }
            Message.EventObject eventObject2 = next.event_data;
            if (eventObject2 != null && (arrayList2 = eventObject2.peer_objects) != null && arrayList2.size() > 0) {
                Iterator<ObjectGuidType> it2 = next.event_data.peer_objects.iterator();
                while (it2.hasNext()) {
                    String str6 = it2.next().object_guid;
                    if (str6 != null) {
                        hashSet.add(str6);
                    }
                }
            }
        }
        getChatUtils().loadAbsObjectsIfNeeded(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), hashSet, false, new LoadListener<Set<String>>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.32
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Set<String> set) {
                CoreMainClassImpl.this.getNotificationCenter().absForMessagesDidLoad(str, set);
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(1);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getChatAbs(final String str, final LoadListener<ChatAbsObject> loadListener) {
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        getChatUtils().loadAbsObjectsIfNeeded(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), hashSet, false, new LoadListener<Set<String>>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.33
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Set<String> set) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(CoreMainClassImpl.this.getAbsInstant(str));
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    public void addToAbsIfNotExist(ArrayList<ChatAbsObject> arrayList, long j) {
        if (this.isCoreInitiated) {
            getChatUtils().addToAbsIfNotExist(arrayList, j, getDBHelper());
        }
    }

    public void loadAbsForInChatMembers(ArrayList<InChatMember> arrayList, final LoadListener<Integer> loadListener) {
        if (arrayList == null || arrayList.size() <= 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(0);
                return;
            }
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<InChatMember> it = arrayList.iterator();
        while (it.hasNext()) {
            String str = it.next().promoted_by_object_guid;
            if (str != null) {
                hashSet.add(str);
            }
        }
        getChatUtils().loadAbsObjectsIfNeeded(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), hashSet, false, new LoadListener<Set<String>>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.34
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Set<String> set) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(1);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    DataCenterManager getDataCenterManager() {
        return this.serviceLocator.getDataCenterManager();
    }

    public MessageUtils getMessageUtils() {
        return this.serviceLocator.getMessageUtils();
    }

    ChatUtils getChatUtils() {
        if (this.userGuidUsecase == null) {
            this.userGuidUsecase = new GetMyUserGuidUsecase(this);
        }
        return this.serviceLocator.getChatUtils(this.userGuidUsecase);
    }

    LoginUtils getLoginUtils() {
        return this.serviceLocator.getLoginUtils();
    }

    SettingUtils getSettingUtils() {
        return this.serviceLocator.getSettingUtils();
    }

    BotUtils getBotUtils() {
        return this.serviceLocator.getBotUtils();
    }

    WalletUtils getWalletUtils() {
        return this.serviceLocator.getWalletUtils();
    }

    LiveUtils getLiveUtils() {
        return this.serviceLocator.getLiveUtils();
    }

    AbsNotificationCenter getNotificationCenter() {
        return this.serviceLocator.getNotificationCenter();
    }

    CoreLog getCoreLog() {
        return this.serviceLocator.getCoreLog();
    }

    CallUtils getCallUtils() {
        if (this.userGuidUsecase == null) {
            this.userGuidUsecase = new GetMyUserGuidUsecase(this);
        }
        if (this.loadAbsUsecase == null) {
            this.loadAbsUsecase = new LoadAbsUsecase(this);
        }
        return this.serviceLocator.getCallUtils(this.userGuidUsecase, this.loadAbsUsecase);
    }

    JsonHelper getJsonHelper() {
        return this.serviceLocator.getJsonHelper();
    }

    CoreEncryptionHelper getCoreEncryptionHelper() {
        return this.serviceLocator.getCoreEncryptionHelper();
    }

    NetworkHelper getNetworkHelper() {
        return this.serviceLocator.getNetworkHelper();
    }

    KeyValueStorageHelper getKeyValueStorageHelper() {
        return this.serviceLocator.getKeyValueStorageHelper();
    }

    TimerHelper getTimerHelper() {
        return this.serviceLocator.getTimerHelper();
    }

    DBHelper getDBHelper() {
        return this.serviceLocator.getDBHelper();
    }

    RubinoUtils getRubinoUtils() {
        return this.serviceLocator.getRubinoUtils();
    }

    PhoneBookHelper getPhoneBookHelper() {
        return this.serviceLocator.getPhoneBookHelper();
    }

    PushNotification getPushNotification() {
        return this.serviceLocator.getPushNotification();
    }

    DeviceUtils getDeviceUtils() {
        return this.serviceLocator.getDeviceUtils();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void toggleMuteChat(String str, boolean z) {
        getChatUtils().toggleMuteChat(str, z, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void togglePinChat(String str, boolean z) {
        getChatUtils().togglePinChat(str, z, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void togglePinChatInFolder(String str, String str2, boolean z) {
        getChatUtils().togglePinChatInFolder(str, str2, z, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void joinGroup(String str, String str2, LoadListener<String> loadListener) {
        getChatUtils().joinGroup(str, str2, new UpdateChatAndMessageUsecase(this), loadListener, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int addGroup(String str, ArrayList<String> arrayList, String str2, String str3, LoadListener<String> loadListener) {
        return getChatUtils().addGroup(str, arrayList, str2, str3, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int editGroupInfo(String str, String str2, String str3, boolean z, boolean z2, LoadListener<String> loadListener) {
        return getChatUtils().editGroup(str, str2, str3, z, z2, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int editGroupSlowMode(String str, int i, LoadListener<String> loadListener) {
        return getChatUtils().editGroup(str, i, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int editGroupAvailableReactions(String str, ChatReactionSetting chatReactionSetting, LoadListener<String> loadListener) {
        return getChatUtils().editGroup(str, chatReactionSetting, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int editChannelInfo(String str, String str2, String str3, boolean z, boolean z2, LoadListener<String> loadListener) {
        return getChatUtils().editChannel(str, str2, str3, z, z2, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int editChannelInfo(String str, ChatReactionSetting chatReactionSetting, LoadListener<String> loadListener) {
        return getChatUtils().editChannel(str, chatReactionSetting, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void leaveGroup(String str, LoadListener<String> loadListener) {
        getChatUtils().leaveGroup(str, new UpdateChatUsecase(this), loadListener, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void deleteGroup(String str, LoadListener<String> loadListener) {
        getChatUtils().deleteGroup(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void deleteChannel(String str, LoadListener<String> loadListener) {
        getChatUtils().deleteChannel(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int clearChatHistory(String str, ChatType chatType, long j, LoadListener<String> loadListener) {
        return getChatUtils().clearChatHistory(str, chatType, j, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int deleteChat(String str, ChatType chatType, long j, LoadListener<String> loadListener) {
        return getChatUtils().deleteChat(str, chatType, j, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), new UpdateChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void joinChannel(String str, LoadListener<String> loadListener) {
        getChatUtils().joinChannel(str, new UpdateChatUsecase(this), loadListener, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void joinChannelByLink(String str, LoadListener<String> loadListener) {
        getChatUtils().joinChannelByLink(str, new UpdateChatUsecase(this), loadListener, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int addChannel(String str, ArrayList<String> arrayList, String str2, boolean z, String str3, String str4, LoadListener<String> loadListener) {
        return getChatUtils().addChannel(str, arrayList, str2, z, str3, str4, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatAndMessageUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void leaveChannel(String str, LoadListener<String> loadListener) {
        getChatUtils().leaveChannel(str, new UpdateChatUsecase(this), loadListener, getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setBlockUser(String str, boolean z, LoadListener<Integer> loadListener) {
        getChatUtils().blockActionUser(str, z, getAuth(), getNetworkHelper(), getNotificationCenter(), getDBHelper(), new UpdateChatUsecase(this), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getBlockedUsers(String str, LoadListener<GetBlockedUsersOutput> loadListener) {
        getChatUtils().getBlockedUsers(str, getAuth(), getNetworkHelper(), getDBHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setAskSpamActionReportAndLeave(String str) {
        getChatUtils().setAskSpamActionReportAndLeave(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatUsecase(this));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setAskSpamActionBlockUser(String str) {
        getChatUtils().setAskSpamActionBlockUser(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatUsecase(this));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setAskSpamActionCancel(String str) {
        getChatUtils().setAskSpamActionCancel(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatUsecase(this));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void setAskSpamActionAddToContact(String str) {
        getChatUtils().setAskSpamActionAddToContact(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), new UpdateChatUsecase(this));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void logout(final LoadListener<Integer> loadListener) {
        getLoginUtils().logout(getAuth(), getNetworkHelper(), new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.35
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                CoreMainClassImpl.this.clearDataBaseAndStorage(true);
                loadListener.onDidLoad(1);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                CoreMainClassImpl.this.clearDataBaseAndStorage(true);
                loadListener.onError(exc);
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void requestDeleteAccount(final LoadListener<Integer> loadListener) {
        getLoginUtils().requestDeleteAccount(getAuth(), getNetworkHelper(), new LoadListener<Integer>(this) { // from class: ir.aaap.messengercore.CoreMainClassImpl.36
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                loadListener.onDidLoad(1);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                loadListener.onError(exc);
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public int getGroupOnlineCount(String str) {
        return getChatUtils().getOnlineCountInstant(str);
    }

    public void clearDataBaseAndStorage(boolean z) {
        getKeyValueStorageHelper().clear();
        getDBHelper().clearDatabase(z);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void clearDataBaseAndStorageForDebug() {
        getKeyValueStorageHelper().clearForDebug();
        getDBHelper().clearDatabase(false);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public SortedContactResult getSortedContactListInstant() {
        return getChatUtils().getSortedContactListInstant();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isContact(String str) {
        return getChatUtils().isContact(str);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void startContactList() {
        getChatUtils().startContactList();
        getContactAndImportPhoneBookIfNeeded(true, true);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void stopContactList() {
        getChatUtils().stopContactList();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void getContactAndImportPhoneBookIfNeeded(final boolean z, final boolean z2) {
        getCoreLog().e("getContactAndImportPhoneBookIfNeeded", "1");
        if (this.isGetContactAndImportPhoneBookInProgress) {
            return;
        }
        getCoreLog().e("getContactAndImportPhoneBookIfNeeded", "2");
        this.isGetContactAndImportPhoneBookInProgress = true;
        getChatUtils().initContactMap(getKeyValueStorageHelper().getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), getKeyValueStorageHelper(), getTimerHelper(), new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.37
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                CoreMainClassImpl.this.getChatUtils().importPhoneBookAndSendToServer(z, CoreMainClassImpl.this.getKeyValueStorageHelper().getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getDBHelper(), CoreMainClassImpl.this.getNotificationCenter(), CoreMainClassImpl.this.getKeyValueStorageHelper(), new UpdateChatUsecase(CoreMainClassImpl.this), CoreMainClassImpl.this.getPhoneBookHelper(), CoreMainClassImpl.this.getTimerHelper(), new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.37.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num2) {
                        CoreMainClassImpl.this.getCoreLog().e("getContactAndImportPhoneBookIfNeeded", "3");
                        ChatUtils chatUtils = CoreMainClassImpl.this.getChatUtils();
                        AnonymousClass37 anonymousClass37 = AnonymousClass37.this;
                        chatUtils.getContactUpdates(z2, 60000L, CoreMainClassImpl.this.getKeyValueStorageHelper().getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getDBHelper(), CoreMainClassImpl.this.getNotificationCenter(), CoreMainClassImpl.this.getKeyValueStorageHelper(), CoreMainClassImpl.this.getTimerHelper());
                        AnonymousClass37 anonymousClass372 = AnonymousClass37.this;
                        if (z2) {
                            CoreMainClassImpl.this.getChatUtils().getContactLastOnlineFromServer(CoreMainClassImpl.this.getKeyValueStorageHelper().getAuth(), CoreMainClassImpl.this.getNetworkHelper(), CoreMainClassImpl.this.getDBHelper(), CoreMainClassImpl.this.getNotificationCenter(), CoreMainClassImpl.this.getTimerHelper(), null);
                        }
                        CoreMainClassImpl.this.getCoreLog().e("coreMainClass", "importPhoneBookIfNeeded onDidLoad");
                        CoreMainClassImpl.this.isGetContactAndImportPhoneBookInProgress = false;
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        CoreMainClassImpl.this.getCoreLog().e("coreMainClass", "importPhoneBookIfNeeded onError");
                        CoreMainClassImpl.this.isGetContactAndImportPhoneBookInProgress = false;
                    }
                });
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                CoreMainClassImpl.this.isGetContactAndImportPhoneBookInProgress = false;
            }
        });
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void deleteContact(String str, LoadListener<Integer> loadListener) {
        getChatUtils().deleteContact(str, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener, new UpdateChatUsecase(this));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void resetContacts(LoadListener<Integer> loadListener) {
        getChatUtils().resetContact(getAuth(), getNetworkHelper(), getDBHelper(), getKeyValueStorageHelper(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addContact(String str, String str2, String str3, LoadListener<String> loadListener) {
        getChatUtils().addContact(str, str2, str3, getAuth(), getNetworkHelper(), getDBHelper(), getNotificationCenter(), loadListener, new UpdateChatUsecase(this), new LinkUsecase(this));
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public String getSocketUrl(int i) {
        return getDataCenterManager().getSocketUrl(i);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean isCoreInitiated() {
        return this.isCoreInitiated;
    }

    public void processMessageAndChatUpdate(ArrayList<MessageUpdateObject> arrayList, final ArrayList<ChatUpdateObject> arrayList2, boolean z, boolean z2) {
        if (arrayList == null || arrayList.size() == 0) {
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            getChatUtils().processChatsUpdate(arrayList2, new UpdateChatUsecase(this), getNotificationCenter(), getDBHelper());
            return;
        }
        getMessageUtils().processMessageUpdate(arrayList, z, getNotificationCenter(), getDBHelper(), getKeyValueStorageHelper(), new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.38
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                CoreMainClassImpl.this.getChatUtils().processChatsUpdate(arrayList2, new UpdateChatUsecase(CoreMainClassImpl.this), CoreMainClassImpl.this.getNotificationCenter(), CoreMainClassImpl.this.getDBHelper());
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                CoreMainClassImpl.this.getChatUtils().processChatsUpdate(arrayList2, new UpdateChatUsecase(CoreMainClassImpl.this), CoreMainClassImpl.this.getNotificationCenter(), CoreMainClassImpl.this.getDBHelper());
            }
        }, new UpdateMessageUsecase(this), z2);
    }

    public void processMessageAndChatUpdate(MessageUpdateObject messageUpdateObject, ChatUpdateObject chatUpdateObject, boolean z, boolean z2) {
        if (messageUpdateObject == null && chatUpdateObject == null) {
            return;
        }
        ArrayList<MessageUpdateObject> arrayList = null;
        if (messageUpdateObject != null) {
            arrayList = new ArrayList<>();
            arrayList.add(messageUpdateObject);
        }
        processMessageAndChatUpdate(arrayList, chatUpdateObject, z, z2);
    }

    public void processChatUpdate(ChatUpdateObject chatUpdateObject) {
        if (chatUpdateObject != null) {
            getChatUtils().processChatsUpdate(chatUpdateObject, new UpdateChatUsecase(this), getNotificationCenter(), getDBHelper());
        }
    }

    public void processMessageAndChatUpdate(ArrayList<MessageUpdateObject> arrayList, final ChatUpdateObject chatUpdateObject, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() != 0) {
            getMessageUtils().processMessageUpdate(arrayList, z, getNotificationCenter(), getDBHelper(), getKeyValueStorageHelper(), new LoadListener<Integer>() { // from class: ir.aaap.messengercore.CoreMainClassImpl.39
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    CoreMainClassImpl.this.getChatUtils().processChatsUpdate(chatUpdateObject, new UpdateChatUsecase(CoreMainClassImpl.this), CoreMainClassImpl.this.getNotificationCenter(), CoreMainClassImpl.this.getDBHelper());
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    CoreMainClassImpl.this.getChatUtils().processChatsUpdate(chatUpdateObject, new UpdateChatUsecase(CoreMainClassImpl.this), CoreMainClassImpl.this.getNotificationCenter(), CoreMainClassImpl.this.getDBHelper());
                }
            }, new UpdateMessageUsecase(this), z2);
        } else if (chatUpdateObject != null) {
            getChatUtils().processChatsUpdate(chatUpdateObject, new UpdateChatUsecase(this), getNotificationCenter(), getDBHelper());
        }
    }

    public void onMessageAdded(String str, ChatType chatType, ArrayList<Message> arrayList, boolean z, boolean z2) {
        if (z) {
            loadAbsAndRepliesForMessages(str, chatType, arrayList, false, null);
        }
        if (z2) {
            getNotificationCenter().didReceiveNewMessages(str, chatType, arrayList);
        }
    }

    public void onMessageDeleted(String str, ChatType chatType, ArrayList<Long> arrayList, boolean z) {
        if (z) {
            getNotificationCenter().messagesDeleted(str, chatType, arrayList);
        }
    }

    public void onMessageUpdated(String str, ChatType chatType, ArrayList<MessageUpdateResult> arrayList, boolean z) {
        if (z) {
            getNotificationCenter().messagesUpdated(str, chatType, arrayList);
        }
    }

    public void loadAbs(Set<String> set, boolean z, LoadListener<Set<String>> loadListener) {
        getChatUtils().loadAbsObjectsIfNeeded(getAuth(), getNetworkHelper(), getDBHelper(), set, z, loadListener);
    }

    public void onChatClearHistory(ArrayList<String> arrayList) {
        getMessageUtils().onChatMessagesDeleted(getDBHelper(), getKeyValueStorageHelper(), arrayList);
    }

    public void onSeenChatChanged(String str, ChatType chatType, long j) {
        getNotificationUtils().removeNotificationToMessageId(str, chatType, j, getNotificationCenter(), getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void removeNotificationsForChat(String str, ChatType chatType) {
        getNotificationUtils().removeAllNotificationByChat(str, chatType, getNotificationCenter(), getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public boolean hasMessageReply(String str, long j) {
        Message messageInstant = getMessageInstant(str, j);
        return messageInstant != null && messageInstant.reply_to_message_id > 0;
    }

    public void onChatsDeleted(ArrayList<String> arrayList, boolean z) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        getChatUtils().deleteChatFromMapAndDb(arrayList, z, getNotificationCenter(), getDBHelper());
        onChatClearHistory(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            ChatAbsObject absInstant = getAbsInstant(next);
            getNotificationUtils().removeAllNotificationByChat(next, absInstant != null ? absInstant.type : null, getNotificationCenter(), getDBHelper());
        }
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void updateMessageRubinoStory(String str, long j, RubinoStoryData rubinoStoryData) {
        getMessageUtils().updateMessageRubinoStory(str, j, rubinoStoryData, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void updateMessageRubinoPost(String str, long j, RubinoPostData rubinoPostData) {
        getMessageUtils().updateMessageRubinoPost(str, j, rubinoPostData, getDBHelper());
    }

    public HashSet<Chat.ChatAccessEnum> getChatAccess(String str, ChatType chatType) {
        Chat chatForceGetChatInstant = forceGetChatInstant(str);
        if (chatForceGetChatInstant != null) {
            return chatForceGetChatInstant.access;
        }
        return null;
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void addSentFile(String str, FileInlineObject fileInlineObject) {
        getChatUtils().saveSentFile(str, fileInlineObject, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public FileInlineObject getSentFile(String str) {
        return getChatUtils().getSentFile(str, getDBHelper());
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public String getUrlByCdnTag(String str, String str2) {
        return getDataCenterManager().getStorageUrl(getAuth(), str, str2);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public long getNewGroupedMessageId() {
        return getMessageUtils().generateNewGroupId();
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public void loadAvailableReactions(LoadListener<Integer> loadListener) {
        getSettingUtils().getAvailableReactionsIfNeeded(getAuth(), getNetworkHelper(), getKeyValueStorageHelper(), getNotificationCenter(), loadListener);
    }

    @Override // ir.aaap.messengercore.CoreMainClass
    public ArrayList<ReactionObject> getAvailableReactions() {
        return getSettingUtils().getAvailableReactionsInstant(getKeyValueStorageHelper());
    }
}
