package ir.eitaa.messenger;

import android.os.SystemClock;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class NotificationCenter {
    private static volatile NotificationCenter[] Instance = null;
    public static final int activeGroupCallsUpdated;
    public static final int albumsDidLoad;
    public static final int appDidLogout;
    public static final int appUpdateAvailable;
    public static final int applyGroupCallVisibleParticipants;
    public static final int archivedStickersCountDidLoad;
    public static final int audioDidSent;
    public static final int audioRecordTooShort;
    public static final int audioRouteChanged;
    public static final int blockedUsersDidLoad;
    public static final int botInfoDidLoad;
    public static final int botKeyboardDidLoad;
    public static final int cameraInitied;
    public static final int changeRepliesCounter;
    public static final int channelRightsUpdated;
    public static final int chatDidCreated;
    public static final int chatDidFailCreate;
    public static final int chatInfoCantLoad;
    public static final int chatInfoDidLoad;
    public static final int chatOnlineCountDidLoad;
    public static final int chatSearchResultsAvailable;
    public static final int chatSearchResultsLoading;
    public static final int closeChats;
    public static final int closeInCallActivity;
    public static final int closeOtherAppActivities;
    public static final int closeSearchByActiveAction;
    public static final int commentsRead;
    public static final int configLoaded;
    public static final int contactsDidLoad;
    public static final int contactsImported;
    public static final int dialogDeleted;
    public static final int dialogFiltersUpdated;
    public static final int dialogPhotosLoaded;
    public static final int dialogsNeedReload;
    public static final int dialogsUnreadCounterChanged;
    public static final int diceStickersDidLoad;
    public static final int didApplyNewTheme;
    public static final int didClearDatabase;
    public static final int didCreatedNewDeleteTask;
    public static final int didEndCall;
    public static final int didLoadChatAdmins;
    public static final int didLoadChatInviter;
    public static final int didLoadPinnedMessages;
    public static final int didLoadSponsoredMessages;
    public static final int didLoadedMessage;
    public static final int didReceiveCall;
    public static final int didReceiveNewMessages = 1;
    public static final int didReceiveSmsCode;
    public static final int didReceivedWebpages;
    public static final int didReceivedWebpagesInUpdates;
    public static final int didRemoveTwoStepPassword;
    public static final int didReplacedPhotoInMemCache;
    public static final int didSetChatLockPasscode;
    public static final int didSetNewTheme;
    public static final int didSetNewWallpapper;
    public static final int didSetOrRemoveTwoStepPassword;
    public static final int didSetPasscode;
    public static final int didStartedCall;
    public static final int didUpdateConnectionState;
    public static final int didUpdateLive;
    public static final int didUpdateMessagesViews;
    public static final int didUpdatePollResults;
    public static final int didUpdateReactions;
    public static final int didVerifyMessagesStickers;
    public static final int emojiLoaded;
    public static final int encryptedChatCreated;
    public static final int encryptedChatUpdated;
    public static final int exploreStatusNeedReload;
    public static final int featuredStickersDidLoad;
    public static final int fileLoadFailed;
    public static final int fileLoadProgressChanged;
    public static final int fileLoaded;
    public static final int fileNewChunkAvailable;
    public static final int filePreparingFailed;
    public static final int filePreparingStarted;
    public static final int fileUploadFailed;
    public static final int fileUploadProgressChanged;
    public static final int fileUploaded;
    public static final int filterSettingsUpdated;
    public static final int folderBecomeEmpty;
    private static volatile NotificationCenter globalInstance = null;
    public static final int goingToPreviewTheme;
    public static final int groupCallScreencastStateChanged;
    public static final int groupCallSpeakingUsersUpdated;
    public static final int groupCallTypingsUpdated;
    public static final int groupCallUpdated;
    public static final int groupCallVisibilityChanged;
    public static final int groupStickersDidLoad;
    public static final int hasNewContactsToImport;
    public static final int historyCleared;
    public static final int historyImportProgressChanged;
    public static final int httpFileDidFailedLoad;
    public static final int httpFileDidLoad;
    public static final int invalidateMotionBackground;
    public static final int liveChatsNeedReload;
    public static final int liveLocationsCacheChanged;
    public static final int liveLocationsChanged;
    public static final int loadingMessagesFailed;
    public static final int locationPermissionGranted;
    public static final int mainUserInfoChanged;
    public static final int mediaCountDidLoad;
    public static final int mediaCountsDidLoad;
    public static final int mediaDidLoad;
    public static final int messagePlayingDidReset;
    public static final int messagePlayingDidSeek;
    public static final int messagePlayingDidStart;
    public static final int messagePlayingGoingToStop;
    public static final int messagePlayingPlayStateChanged;
    public static final int messagePlayingProgressDidChanged;
    public static final int messagePlayingSpeedChanged;
    public static final int messageReceivedByAck;
    public static final int messageReceivedByServer;
    public static final int messageSendError;
    public static final int messagesDeleted;
    public static final int messagesDidLoad;
    public static final int messagesDidLoadWithoutProcess;
    public static final int messagesRead;
    public static final int messagesReadContent;
    public static final int messagesReadEncrypted;
    public static final int moreMusicDidLoad;
    public static final int musicDidLoad;
    public static final int mxbStatusNeedReload;
    public static final int needAddArchivedStickers;
    public static final int needCheckSystemBarColors;
    public static final int needDeleteDialog;
    public static final int needReloadRecentDialogsSearch;
    public static final int needSetDayNightTheme;
    public static final int needShareTheme;
    public static final int needShowAlert;
    public static final int needShowPlayServicesAlert;
    public static final int newDraftReceived;
    public static final int newEmojiSuggestionsAvailable;
    public static final int newLocationAvailable;
    public static final int newPeopleNearbyAvailable;
    public static final int newSessionReceived;
    public static final int newSuggestionsAvailable;
    public static final int notificationsCountUpdated;
    public static final int notificationsSettingsUpdated;
    public static final int onDatabaseMigration;
    public static final int onEmojiInteractionsReceived;
    public static final int openArticle;
    public static final int openedChatChanged;
    public static final int paymentFinished;
    public static final int peerSettingsDidLoad;
    public static final int pinnedInfoDidLoad;
    public static final int playerDidStartPlaying;
    public static final int privacyRulesUpdated;
    public static final int proxyCheckDone;
    public static final int proxySettingsChanged;
    public static final int pushMessagesUpdated;
    public static final int recentDocumentsDidLoad;
    public static final int recordProgressChanged;
    public static final int recordStartError;
    public static final int recordStarted;
    public static final int recordStopped;
    public static final int reloadDialogPhotos;
    public static final int reloadHints;
    public static final int reloadInlineHints;
    public static final int reloadInterface;
    public static final int removeAllMessagesFromDialog;
    public static final int replaceMessagesObjects;
    public static final int replyMessagesDidLoad;
    public static final int scheduledMessagesUpdated;
    public static final int screenStateChanged;
    public static final int screenshotTook;
    public static final int sendingMessagesChanged;
    public static final int showBulletin;
    public static final int socketAvailable;
    public static final int startAllHeavyOperations;
    public static final int stickersDidLoad;
    public static final int stickersImportComplete;
    public static final int stickersImportProgressChanged;
    public static final int stopAllHeavyOperations;
    public static final int stopEncodingService;
    public static final int suggestedFiltersLoaded;
    public static final int suggestedLangpack;
    public static final int themeAccentListUpdated;
    public static final int themeListUpdated;
    public static final int themeUploadError;
    public static final int themeUploadedToServer;
    public static final int threadMessagesRead;
    private static int totalEvents = 1;
    public static final int twoStepPasswordChanged;
    public static final int updateInterfaces;
    public static final int updateMentionsCount;
    public static final int updateMessageMedia;
    public static final int userInfoDidLoad;
    public static final int videoLoadingStateChanged;
    public static final int voipServiceCreated;
    public static final int walletPendingTransactionsChanged;
    public static final int walletSyncProgressChanged;
    public static final int wallpapersDidLoad;
    public static final int wallpapersNeedReload;
    public static final int wasUnableToFindCurrentLocation;
    public static final int webRtcMicAmplitudeEvent;
    public static final int webRtcSpeakerAmplitudeEvent;
    private int animationInProgressCount;
    private Runnable checkForExpiredNotifications;
    private int currentAccount;
    private int currentHeavyOperationFlags;
    private SparseArray<ArrayList<NotificationCenterDelegate>> observers = new SparseArray<>();
    private SparseArray<ArrayList<NotificationCenterDelegate>> removeAfterBroadcast = new SparseArray<>();
    private SparseArray<ArrayList<NotificationCenterDelegate>> addAfterBroadcast = new SparseArray<>();
    private ArrayList<DelayedPost> delayedPosts = new ArrayList<>(10);
    private ArrayList<Runnable> delayedRunnables = new ArrayList<>(10);
    private ArrayList<Runnable> delayedRunnablesTmp = new ArrayList<>(10);
    private ArrayList<DelayedPost> delayedPostsTmp = new ArrayList<>(10);
    private ArrayList<PostponeNotificationCallback> postponeCallbackList = new ArrayList<>(10);
    private int broadcasting = 0;
    private int animationInProgressPointer = 1;
    HashSet<Integer> heavyOperationsCounter = new HashSet<>();
    private final HashMap<Integer, AllowedNotifications> allowedNotifications = new HashMap<>();

    public interface NotificationCenterDelegate {

        /* renamed from: ir.eitaa.messenger.NotificationCenter$NotificationCenterDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didReceivedNotification(NotificationCenterDelegate notificationCenterDelegate, int i, int i2, Object... objArr) {
            }
        }

        void didReceivedNotification(int id, int account, Object... args);
    }

    public interface PostponeNotificationCallback {
        boolean needPostpone(int id, int currentAccount, Object[] args);
    }

    static {
        int i = 1 + 1;
        totalEvents = i;
        int i2 = i + 1;
        totalEvents = i2;
        updateInterfaces = i;
        int i3 = i2 + 1;
        totalEvents = i3;
        dialogsNeedReload = i2;
        int i4 = i3 + 1;
        totalEvents = i4;
        closeChats = i3;
        int i5 = i4 + 1;
        totalEvents = i5;
        messagesDeleted = i4;
        int i6 = i5 + 1;
        totalEvents = i6;
        historyCleared = i5;
        int i7 = i6 + 1;
        totalEvents = i7;
        messagesRead = i6;
        int i8 = i7 + 1;
        totalEvents = i8;
        threadMessagesRead = i7;
        int i9 = i8 + 1;
        totalEvents = i9;
        commentsRead = i8;
        int i10 = i9 + 1;
        totalEvents = i10;
        changeRepliesCounter = i9;
        int i11 = i10 + 1;
        totalEvents = i11;
        messagesDidLoad = i10;
        int i12 = i11 + 1;
        totalEvents = i12;
        didLoadSponsoredMessages = i11;
        int i13 = i12 + 1;
        totalEvents = i13;
        messagesDidLoadWithoutProcess = i12;
        int i14 = i13 + 1;
        totalEvents = i14;
        loadingMessagesFailed = i13;
        int i15 = i14 + 1;
        totalEvents = i15;
        messageReceivedByAck = i14;
        int i16 = i15 + 1;
        totalEvents = i16;
        messageReceivedByServer = i15;
        int i17 = i16 + 1;
        totalEvents = i17;
        messageSendError = i16;
        int i18 = i17 + 1;
        totalEvents = i18;
        contactsDidLoad = i17;
        int i19 = i18 + 1;
        totalEvents = i19;
        contactsImported = i18;
        int i20 = i19 + 1;
        totalEvents = i20;
        hasNewContactsToImport = i19;
        int i21 = i20 + 1;
        totalEvents = i21;
        chatDidCreated = i20;
        int i22 = i21 + 1;
        totalEvents = i22;
        chatDidFailCreate = i21;
        int i23 = i22 + 1;
        totalEvents = i23;
        chatInfoDidLoad = i22;
        int i24 = i23 + 1;
        totalEvents = i24;
        chatInfoCantLoad = i23;
        int i25 = i24 + 1;
        totalEvents = i25;
        mediaDidLoad = i24;
        int i26 = i25 + 1;
        totalEvents = i26;
        mediaCountDidLoad = i25;
        int i27 = i26 + 1;
        totalEvents = i27;
        mediaCountsDidLoad = i26;
        int i28 = i27 + 1;
        totalEvents = i28;
        encryptedChatUpdated = i27;
        int i29 = i28 + 1;
        totalEvents = i29;
        messagesReadEncrypted = i28;
        int i30 = i29 + 1;
        totalEvents = i30;
        encryptedChatCreated = i29;
        int i31 = i30 + 1;
        totalEvents = i31;
        dialogPhotosLoaded = i30;
        int i32 = i31 + 1;
        totalEvents = i32;
        reloadDialogPhotos = i31;
        int i33 = i32 + 1;
        totalEvents = i33;
        folderBecomeEmpty = i32;
        int i34 = i33 + 1;
        totalEvents = i34;
        removeAllMessagesFromDialog = i33;
        int i35 = i34 + 1;
        totalEvents = i35;
        notificationsSettingsUpdated = i34;
        int i36 = i35 + 1;
        totalEvents = i36;
        blockedUsersDidLoad = i35;
        int i37 = i36 + 1;
        totalEvents = i37;
        openedChatChanged = i36;
        int i38 = i37 + 1;
        totalEvents = i38;
        didCreatedNewDeleteTask = i37;
        int i39 = i38 + 1;
        totalEvents = i39;
        mainUserInfoChanged = i38;
        int i40 = i39 + 1;
        totalEvents = i40;
        privacyRulesUpdated = i39;
        int i41 = i40 + 1;
        totalEvents = i41;
        updateMessageMedia = i40;
        int i42 = i41 + 1;
        totalEvents = i42;
        replaceMessagesObjects = i41;
        int i43 = i42 + 1;
        totalEvents = i43;
        didSetPasscode = i42;
        int i44 = i43 + 1;
        totalEvents = i44;
        didSetChatLockPasscode = i43;
        int i45 = i44 + 1;
        totalEvents = i45;
        twoStepPasswordChanged = i44;
        int i46 = i45 + 1;
        totalEvents = i46;
        didSetOrRemoveTwoStepPassword = i45;
        int i47 = i46 + 1;
        totalEvents = i47;
        didRemoveTwoStepPassword = i46;
        int i48 = i47 + 1;
        totalEvents = i48;
        replyMessagesDidLoad = i47;
        int i49 = i48 + 1;
        totalEvents = i49;
        didLoadPinnedMessages = i48;
        totalEvents = i49 + 1;
        didLoadedMessage = i49;
        int i50 = totalEvents;
        totalEvents = i50 + 1;
        newSessionReceived = i50;
        int i51 = totalEvents;
        totalEvents = i51 + 1;
        didReceivedWebpages = i51;
        int i52 = totalEvents;
        totalEvents = i52 + 1;
        didReceivedWebpagesInUpdates = i52;
        int i53 = totalEvents;
        totalEvents = i53 + 1;
        stickersDidLoad = i53;
        int i54 = totalEvents;
        totalEvents = i54 + 1;
        diceStickersDidLoad = i54;
        int i55 = totalEvents;
        totalEvents = i55 + 1;
        featuredStickersDidLoad = i55;
        int i56 = totalEvents;
        totalEvents = i56 + 1;
        groupStickersDidLoad = i56;
        int i57 = totalEvents;
        totalEvents = i57 + 1;
        messagesReadContent = i57;
        int i58 = totalEvents;
        totalEvents = i58 + 1;
        botInfoDidLoad = i58;
        int i59 = totalEvents;
        totalEvents = i59 + 1;
        userInfoDidLoad = i59;
        int i60 = totalEvents;
        totalEvents = i60 + 1;
        pinnedInfoDidLoad = i60;
        int i61 = totalEvents;
        totalEvents = i61 + 1;
        botKeyboardDidLoad = i61;
        int i62 = totalEvents;
        totalEvents = i62 + 1;
        chatSearchResultsAvailable = i62;
        int i63 = totalEvents;
        totalEvents = i63 + 1;
        chatSearchResultsLoading = i63;
        int i64 = totalEvents;
        totalEvents = i64 + 1;
        musicDidLoad = i64;
        int i65 = totalEvents;
        totalEvents = i65 + 1;
        moreMusicDidLoad = i65;
        int i66 = totalEvents;
        totalEvents = i66 + 1;
        needShowAlert = i66;
        int i67 = totalEvents;
        totalEvents = i67 + 1;
        needShowPlayServicesAlert = i67;
        int i68 = totalEvents;
        totalEvents = i68 + 1;
        didUpdateMessagesViews = i68;
        int i69 = totalEvents;
        totalEvents = i69 + 1;
        needReloadRecentDialogsSearch = i69;
        int i70 = totalEvents;
        totalEvents = i70 + 1;
        peerSettingsDidLoad = i70;
        int i71 = totalEvents;
        totalEvents = i71 + 1;
        wasUnableToFindCurrentLocation = i71;
        int i72 = totalEvents;
        totalEvents = i72 + 1;
        reloadHints = i72;
        int i73 = totalEvents;
        totalEvents = i73 + 1;
        reloadInlineHints = i73;
        int i74 = totalEvents;
        totalEvents = i74 + 1;
        newDraftReceived = i74;
        int i75 = totalEvents;
        totalEvents = i75 + 1;
        recentDocumentsDidLoad = i75;
        int i76 = totalEvents;
        totalEvents = i76 + 1;
        needAddArchivedStickers = i76;
        int i77 = totalEvents;
        totalEvents = i77 + 1;
        archivedStickersCountDidLoad = i77;
        int i78 = totalEvents;
        totalEvents = i78 + 1;
        paymentFinished = i78;
        int i79 = totalEvents;
        totalEvents = i79 + 1;
        channelRightsUpdated = i79;
        int i80 = totalEvents;
        totalEvents = i80 + 1;
        openArticle = i80;
        int i81 = totalEvents;
        totalEvents = i81 + 1;
        updateMentionsCount = i81;
        int i82 = totalEvents;
        totalEvents = i82 + 1;
        didUpdatePollResults = i82;
        int i83 = totalEvents;
        totalEvents = i83 + 1;
        chatOnlineCountDidLoad = i83;
        int i84 = totalEvents;
        totalEvents = i84 + 1;
        videoLoadingStateChanged = i84;
        int i85 = totalEvents;
        totalEvents = i85 + 1;
        newPeopleNearbyAvailable = i85;
        int i86 = totalEvents;
        totalEvents = i86 + 1;
        stopAllHeavyOperations = i86;
        int i87 = totalEvents;
        totalEvents = i87 + 1;
        startAllHeavyOperations = i87;
        int i88 = totalEvents;
        totalEvents = i88 + 1;
        sendingMessagesChanged = i88;
        int i89 = totalEvents;
        totalEvents = i89 + 1;
        didUpdateReactions = i89;
        int i90 = totalEvents;
        totalEvents = i90 + 1;
        didVerifyMessagesStickers = i90;
        int i91 = totalEvents;
        totalEvents = i91 + 1;
        scheduledMessagesUpdated = i91;
        int i92 = totalEvents;
        totalEvents = i92 + 1;
        newSuggestionsAvailable = i92;
        int i93 = totalEvents;
        totalEvents = i93 + 1;
        didLoadChatInviter = i93;
        int i94 = totalEvents;
        totalEvents = i94 + 1;
        didLoadChatAdmins = i94;
        int i95 = totalEvents;
        totalEvents = i95 + 1;
        historyImportProgressChanged = i95;
        int i96 = totalEvents;
        totalEvents = i96 + 1;
        stickersImportProgressChanged = i96;
        int i97 = totalEvents;
        totalEvents = i97 + 1;
        stickersImportComplete = i97;
        int i98 = totalEvents;
        totalEvents = i98 + 1;
        dialogDeleted = i98;
        int i99 = totalEvents;
        totalEvents = i99 + 1;
        walletPendingTransactionsChanged = i99;
        int i100 = totalEvents;
        totalEvents = i100 + 1;
        walletSyncProgressChanged = i100;
        int i101 = totalEvents;
        totalEvents = i101 + 1;
        httpFileDidLoad = i101;
        int i102 = totalEvents;
        totalEvents = i102 + 1;
        httpFileDidFailedLoad = i102;
        int i103 = totalEvents;
        totalEvents = i103 + 1;
        didUpdateConnectionState = i103;
        int i104 = totalEvents;
        totalEvents = i104 + 1;
        liveChatsNeedReload = i104;
        int i105 = totalEvents;
        totalEvents = i105 + 1;
        exploreStatusNeedReload = i105;
        int i106 = totalEvents;
        totalEvents = i106 + 1;
        mxbStatusNeedReload = i106;
        int i107 = totalEvents;
        totalEvents = i107 + 1;
        didUpdateLive = i107;
        int i108 = totalEvents;
        totalEvents = i108 + 1;
        socketAvailable = i108;
        int i109 = totalEvents;
        totalEvents = i109 + 1;
        fileUploaded = i109;
        int i110 = totalEvents;
        totalEvents = i110 + 1;
        fileUploadFailed = i110;
        int i111 = totalEvents;
        totalEvents = i111 + 1;
        fileUploadProgressChanged = i111;
        int i112 = totalEvents;
        totalEvents = i112 + 1;
        fileLoadProgressChanged = i112;
        int i113 = totalEvents;
        totalEvents = i113 + 1;
        fileLoaded = i113;
        int i114 = totalEvents;
        totalEvents = i114 + 1;
        fileLoadFailed = i114;
        int i115 = totalEvents;
        totalEvents = i115 + 1;
        filePreparingStarted = i115;
        int i116 = totalEvents;
        totalEvents = i116 + 1;
        fileNewChunkAvailable = i116;
        int i117 = totalEvents;
        totalEvents = i117 + 1;
        filePreparingFailed = i117;
        int i118 = totalEvents;
        totalEvents = i118 + 1;
        dialogsUnreadCounterChanged = i118;
        int i119 = totalEvents;
        totalEvents = i119 + 1;
        messagePlayingProgressDidChanged = i119;
        int i120 = totalEvents;
        totalEvents = i120 + 1;
        messagePlayingDidReset = i120;
        int i121 = totalEvents;
        totalEvents = i121 + 1;
        messagePlayingPlayStateChanged = i121;
        int i122 = totalEvents;
        totalEvents = i122 + 1;
        messagePlayingDidStart = i122;
        int i123 = totalEvents;
        totalEvents = i123 + 1;
        messagePlayingDidSeek = i123;
        int i124 = totalEvents;
        totalEvents = i124 + 1;
        messagePlayingGoingToStop = i124;
        int i125 = totalEvents;
        totalEvents = i125 + 1;
        recordProgressChanged = i125;
        int i126 = totalEvents;
        totalEvents = i126 + 1;
        recordStarted = i126;
        int i127 = totalEvents;
        totalEvents = i127 + 1;
        recordStartError = i127;
        int i128 = totalEvents;
        totalEvents = i128 + 1;
        recordStopped = i128;
        int i129 = totalEvents;
        totalEvents = i129 + 1;
        screenshotTook = i129;
        int i130 = totalEvents;
        totalEvents = i130 + 1;
        albumsDidLoad = i130;
        int i131 = totalEvents;
        totalEvents = i131 + 1;
        audioDidSent = i131;
        int i132 = totalEvents;
        totalEvents = i132 + 1;
        audioRecordTooShort = i132;
        int i133 = totalEvents;
        totalEvents = i133 + 1;
        audioRouteChanged = i133;
        int i134 = totalEvents;
        totalEvents = i134 + 1;
        didStartedCall = i134;
        int i135 = totalEvents;
        totalEvents = i135 + 1;
        groupCallUpdated = i135;
        int i136 = totalEvents;
        totalEvents = i136 + 1;
        groupCallSpeakingUsersUpdated = i136;
        int i137 = totalEvents;
        totalEvents = i137 + 1;
        groupCallScreencastStateChanged = i137;
        int i138 = totalEvents;
        totalEvents = i138 + 1;
        activeGroupCallsUpdated = i138;
        int i139 = totalEvents;
        totalEvents = i139 + 1;
        applyGroupCallVisibleParticipants = i139;
        int i140 = totalEvents;
        totalEvents = i140 + 1;
        groupCallTypingsUpdated = i140;
        int i141 = totalEvents;
        totalEvents = i141 + 1;
        didEndCall = i141;
        int i142 = totalEvents;
        totalEvents = i142 + 1;
        closeInCallActivity = i142;
        int i143 = totalEvents;
        totalEvents = i143 + 1;
        groupCallVisibilityChanged = i143;
        int i144 = totalEvents;
        totalEvents = i144 + 1;
        appDidLogout = i144;
        int i145 = totalEvents;
        totalEvents = i145 + 1;
        configLoaded = i145;
        int i146 = totalEvents;
        totalEvents = i146 + 1;
        needDeleteDialog = i146;
        int i147 = totalEvents;
        totalEvents = i147 + 1;
        newEmojiSuggestionsAvailable = i147;
        int i148 = totalEvents;
        totalEvents = i148 + 1;
        themeUploadedToServer = i148;
        int i149 = totalEvents;
        totalEvents = i149 + 1;
        themeUploadError = i149;
        int i150 = totalEvents;
        totalEvents = i150 + 1;
        dialogFiltersUpdated = i150;
        int i151 = totalEvents;
        totalEvents = i151 + 1;
        filterSettingsUpdated = i151;
        int i152 = totalEvents;
        totalEvents = i152 + 1;
        suggestedFiltersLoaded = i152;
        int i153 = totalEvents;
        totalEvents = i153 + 1;
        pushMessagesUpdated = i153;
        int i154 = totalEvents;
        totalEvents = i154 + 1;
        stopEncodingService = i154;
        int i155 = totalEvents;
        totalEvents = i155 + 1;
        wallpapersDidLoad = i155;
        int i156 = totalEvents;
        totalEvents = i156 + 1;
        wallpapersNeedReload = i156;
        int i157 = totalEvents;
        totalEvents = i157 + 1;
        didReceiveSmsCode = i157;
        int i158 = totalEvents;
        totalEvents = i158 + 1;
        didReceiveCall = i158;
        int i159 = totalEvents;
        totalEvents = i159 + 1;
        emojiLoaded = i159;
        int i160 = totalEvents;
        totalEvents = i160 + 1;
        invalidateMotionBackground = i160;
        int i161 = totalEvents;
        totalEvents = i161 + 1;
        closeOtherAppActivities = i161;
        int i162 = totalEvents;
        totalEvents = i162 + 1;
        cameraInitied = i162;
        int i163 = totalEvents;
        totalEvents = i163 + 1;
        didReplacedPhotoInMemCache = i163;
        int i164 = totalEvents;
        totalEvents = i164 + 1;
        didSetNewTheme = i164;
        int i165 = totalEvents;
        totalEvents = i165 + 1;
        themeListUpdated = i165;
        int i166 = totalEvents;
        totalEvents = i166 + 1;
        didApplyNewTheme = i166;
        int i167 = totalEvents;
        totalEvents = i167 + 1;
        themeAccentListUpdated = i167;
        int i168 = totalEvents;
        totalEvents = i168 + 1;
        needCheckSystemBarColors = i168;
        int i169 = totalEvents;
        totalEvents = i169 + 1;
        needShareTheme = i169;
        int i170 = totalEvents;
        totalEvents = i170 + 1;
        needSetDayNightTheme = i170;
        int i171 = totalEvents;
        totalEvents = i171 + 1;
        goingToPreviewTheme = i171;
        int i172 = totalEvents;
        totalEvents = i172 + 1;
        locationPermissionGranted = i172;
        int i173 = totalEvents;
        totalEvents = i173 + 1;
        reloadInterface = i173;
        int i174 = totalEvents;
        totalEvents = i174 + 1;
        suggestedLangpack = i174;
        int i175 = totalEvents;
        totalEvents = i175 + 1;
        didSetNewWallpapper = i175;
        int i176 = totalEvents;
        totalEvents = i176 + 1;
        proxySettingsChanged = i176;
        int i177 = totalEvents;
        totalEvents = i177 + 1;
        proxyCheckDone = i177;
        int i178 = totalEvents;
        totalEvents = i178 + 1;
        liveLocationsChanged = i178;
        int i179 = totalEvents;
        totalEvents = i179 + 1;
        newLocationAvailable = i179;
        int i180 = totalEvents;
        totalEvents = i180 + 1;
        liveLocationsCacheChanged = i180;
        int i181 = totalEvents;
        totalEvents = i181 + 1;
        notificationsCountUpdated = i181;
        int i182 = totalEvents;
        totalEvents = i182 + 1;
        playerDidStartPlaying = i182;
        int i183 = totalEvents;
        totalEvents = i183 + 1;
        closeSearchByActiveAction = i183;
        int i184 = totalEvents;
        totalEvents = i184 + 1;
        messagePlayingSpeedChanged = i184;
        int i185 = totalEvents;
        totalEvents = i185 + 1;
        screenStateChanged = i185;
        int i186 = totalEvents;
        totalEvents = i186 + 1;
        didClearDatabase = i186;
        int i187 = totalEvents;
        totalEvents = i187 + 1;
        voipServiceCreated = i187;
        int i188 = totalEvents;
        totalEvents = i188 + 1;
        webRtcMicAmplitudeEvent = i188;
        int i189 = totalEvents;
        totalEvents = i189 + 1;
        webRtcSpeakerAmplitudeEvent = i189;
        int i190 = totalEvents;
        totalEvents = i190 + 1;
        showBulletin = i190;
        int i191 = totalEvents;
        totalEvents = i191 + 1;
        appUpdateAvailable = i191;
        int i192 = totalEvents;
        totalEvents = i192 + 1;
        onDatabaseMigration = i192;
        int i193 = totalEvents;
        totalEvents = i193 + 1;
        onEmojiInteractionsReceived = i193;
        Instance = new NotificationCenter[3];
    }

    private static class DelayedPost {
        private Object[] args;
        private int id;

        private DelayedPost(int id, Object[] args) {
            this.id = id;
            this.args = args;
        }
    }

    public static NotificationCenter getInstance(int num) {
        NotificationCenter notificationCenter = Instance[num];
        if (notificationCenter == null) {
            synchronized (NotificationCenter.class) {
                notificationCenter = Instance[num];
                if (notificationCenter == null) {
                    NotificationCenter[] notificationCenterArr = Instance;
                    NotificationCenter notificationCenter2 = new NotificationCenter(num);
                    notificationCenterArr[num] = notificationCenter2;
                    notificationCenter = notificationCenter2;
                }
            }
        }
        return notificationCenter;
    }

    public static NotificationCenter getGlobalInstance() {
        NotificationCenter notificationCenter = globalInstance;
        if (notificationCenter == null) {
            synchronized (NotificationCenter.class) {
                notificationCenter = globalInstance;
                if (notificationCenter == null) {
                    notificationCenter = new NotificationCenter(-1);
                    globalInstance = notificationCenter;
                }
            }
        }
        return notificationCenter;
    }

    public NotificationCenter(int account) {
        this.currentAccount = account;
    }

    public int setAnimationInProgress(int oldIndex, int[] allowedNotifications) {
        return setAnimationInProgress(oldIndex, allowedNotifications, true);
    }

    public int setAnimationInProgress(int oldIndex, int[] allowedNotifications, boolean stopHeavyOperations) {
        onAnimationFinish(oldIndex);
        if (this.heavyOperationsCounter.isEmpty() && stopHeavyOperations) {
            getGlobalInstance().postNotificationName(stopAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
        }
        this.animationInProgressCount++;
        int i = this.animationInProgressPointer + 1;
        this.animationInProgressPointer = i;
        if (stopHeavyOperations) {
            this.heavyOperationsCounter.add(Integer.valueOf(i));
        }
        AllowedNotifications allowedNotifications2 = new AllowedNotifications();
        allowedNotifications2.allowedIds = allowedNotifications;
        this.allowedNotifications.put(Integer.valueOf(this.animationInProgressPointer), allowedNotifications2);
        if (this.checkForExpiredNotifications == null) {
            $$Lambda$NotificationCenter$0jiSmMcr7oeC22pb3aVzZFE9X4 __lambda_notificationcenter_0jismmcr7oec22pb3avzzfe9x4 = new $$Lambda$NotificationCenter$0jiSmMcr7oeC22pb3aVzZFE9X4(this);
            this.checkForExpiredNotifications = __lambda_notificationcenter_0jismmcr7oec22pb3avzzfe9x4;
            AndroidUtilities.runOnUIThread(__lambda_notificationcenter_0jismmcr7oec22pb3avzzfe9x4, 1017L);
        }
        return this.animationInProgressPointer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForExpiredNotifications() {
        ArrayList arrayList = null;
        this.checkForExpiredNotifications = null;
        if (this.allowedNotifications.isEmpty()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jMin = Long.MAX_VALUE;
        for (Map.Entry<Integer, AllowedNotifications> entry : this.allowedNotifications.entrySet()) {
            long j = entry.getValue().time;
            if (jElapsedRealtime - j > 1000) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(entry.getKey());
            } else {
                jMin = Math.min(j, jMin);
            }
        }
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                onAnimationFinish(((Integer) arrayList.get(i)).intValue());
            }
        }
        if (jMin != Long.MAX_VALUE) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationCenter$KHz1OwLpNrJHH9madvce7XL1YCw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkForExpiredNotifications$0$NotificationCenter();
                }
            }, Math.max(17L, 1017 - (jElapsedRealtime - jMin)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkForExpiredNotifications$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkForExpiredNotifications$0$NotificationCenter() {
        this.checkForExpiredNotifications = new $$Lambda$NotificationCenter$0jiSmMcr7oeC22pb3aVzZFE9X4(this);
    }

    public void updateAllowedNotifications(int transitionAnimationIndex, int[] allowedNotifications) {
        AllowedNotifications allowedNotifications2 = this.allowedNotifications.get(Integer.valueOf(transitionAnimationIndex));
        if (allowedNotifications2 != null) {
            allowedNotifications2.allowedIds = allowedNotifications;
        }
    }

    public void onAnimationFinish(int index) {
        if (this.allowedNotifications.remove(Integer.valueOf(index)) != null) {
            this.animationInProgressCount--;
            if (!this.heavyOperationsCounter.isEmpty()) {
                this.heavyOperationsCounter.remove(Integer.valueOf(index));
                if (this.heavyOperationsCounter.isEmpty()) {
                    getGlobalInstance().postNotificationName(startAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
                }
            }
            if (this.animationInProgressCount == 0) {
                runDelayedNotifications();
            }
        }
        if (this.checkForExpiredNotifications == null || !this.allowedNotifications.isEmpty()) {
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(this.checkForExpiredNotifications);
        this.checkForExpiredNotifications = null;
    }

    public void runDelayedNotifications() {
        if (!this.delayedPosts.isEmpty()) {
            this.delayedPostsTmp.clear();
            this.delayedPostsTmp.addAll(this.delayedPosts);
            this.delayedPosts.clear();
            for (int i = 0; i < this.delayedPostsTmp.size(); i++) {
                DelayedPost delayedPost = this.delayedPostsTmp.get(i);
                postNotificationNameInternal(delayedPost.id, true, delayedPost.args);
            }
            this.delayedPostsTmp.clear();
        }
        if (this.delayedRunnables.isEmpty()) {
            return;
        }
        this.delayedRunnablesTmp.clear();
        this.delayedRunnablesTmp.addAll(this.delayedRunnables);
        this.delayedRunnables.clear();
        for (int i2 = 0; i2 < this.delayedRunnablesTmp.size(); i2++) {
            this.delayedRunnablesTmp.get(i2).run();
        }
        this.delayedRunnablesTmp.clear();
    }

    public boolean isAnimationInProgress() {
        return this.animationInProgressCount > 0;
    }

    public int getCurrentHeavyOperationFlags() {
        return this.currentHeavyOperationFlags;
    }

    public ArrayList<NotificationCenterDelegate> getObservers(int id) {
        return this.observers.get(id);
    }

    public void postNotificationName(int id, Object... args) {
        boolean z = id == startAllHeavyOperations || id == stopAllHeavyOperations || id == didReplacedPhotoInMemCache || id == closeChats || id == invalidateMotionBackground;
        ArrayList arrayList = null;
        if (!z && !this.allowedNotifications.isEmpty()) {
            int size = this.allowedNotifications.size();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i = 0;
            for (Map.Entry<Integer, AllowedNotifications> entry : this.allowedNotifications.entrySet()) {
                AllowedNotifications value = entry.getValue();
                if (jElapsedRealtime - value.time > 1000) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(entry.getKey());
                }
                int[] iArr = value.allowedIds;
                if (iArr == null) {
                    break;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= iArr.length) {
                        break;
                    }
                    if (iArr[i2] == id) {
                        i++;
                        break;
                    }
                    i2++;
                }
            }
            z = size == i;
        }
        if (id == startAllHeavyOperations) {
            this.currentHeavyOperationFlags = (((Integer) args[0]).intValue() ^ (-1)) & this.currentHeavyOperationFlags;
        } else if (id == stopAllHeavyOperations) {
            this.currentHeavyOperationFlags = ((Integer) args[0]).intValue() | this.currentHeavyOperationFlags;
        }
        postNotificationNameInternal(id, z, args);
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                onAnimationFinish(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    public void postNotificationNameInternal(int id, boolean allowDuringAnimation, Object... args) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("postNotificationName allowed only from MAIN thread");
        }
        if (!allowDuringAnimation && isAnimationInProgress()) {
            this.delayedPosts.add(new DelayedPost(id, args));
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("delay post notification " + id + " with args count = " + args.length);
                return;
            }
            return;
        }
        if (!this.postponeCallbackList.isEmpty()) {
            for (int i = 0; i < this.postponeCallbackList.size(); i++) {
                if (this.postponeCallbackList.get(i).needPostpone(id, this.currentAccount, args)) {
                    this.delayedPosts.add(new DelayedPost(id, args));
                    return;
                }
            }
        }
        this.broadcasting++;
        ArrayList<NotificationCenterDelegate> arrayList = this.observers.get(id);
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList.get(i2).didReceivedNotification(id, this.currentAccount, args);
            }
        }
        int i3 = this.broadcasting - 1;
        this.broadcasting = i3;
        if (i3 == 0) {
            if (this.removeAfterBroadcast.size() != 0) {
                for (int i4 = 0; i4 < this.removeAfterBroadcast.size(); i4++) {
                    int iKeyAt = this.removeAfterBroadcast.keyAt(i4);
                    ArrayList<NotificationCenterDelegate> arrayList2 = this.removeAfterBroadcast.get(iKeyAt);
                    for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                        removeObserver(arrayList2.get(i5), iKeyAt);
                    }
                }
                this.removeAfterBroadcast.clear();
            }
            if (this.addAfterBroadcast.size() != 0) {
                for (int i6 = 0; i6 < this.addAfterBroadcast.size(); i6++) {
                    int iKeyAt2 = this.addAfterBroadcast.keyAt(i6);
                    ArrayList<NotificationCenterDelegate> arrayList3 = this.addAfterBroadcast.get(iKeyAt2);
                    for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                        addObserver(arrayList3.get(i7), iKeyAt2);
                    }
                }
                this.addAfterBroadcast.clear();
            }
        }
    }

    public void addObserver(NotificationCenterDelegate observer, int id) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("addObserver allowed only from MAIN thread");
        }
        if (this.broadcasting != 0) {
            ArrayList<NotificationCenterDelegate> arrayList = this.addAfterBroadcast.get(id);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.addAfterBroadcast.put(id, arrayList);
            }
            arrayList.add(observer);
            return;
        }
        ArrayList<NotificationCenterDelegate> arrayList2 = this.observers.get(id);
        if (arrayList2 == null) {
            SparseArray<ArrayList<NotificationCenterDelegate>> sparseArray = this.observers;
            ArrayList<NotificationCenterDelegate> arrayList3 = new ArrayList<>();
            sparseArray.put(id, arrayList3);
            arrayList2 = arrayList3;
        }
        if (arrayList2.contains(observer)) {
            return;
        }
        arrayList2.add(observer);
    }

    public void removeObserver(NotificationCenterDelegate observer, int id) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("removeObserver allowed only from MAIN thread");
        }
        if (this.broadcasting != 0) {
            ArrayList<NotificationCenterDelegate> arrayList = this.removeAfterBroadcast.get(id);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.removeAfterBroadcast.put(id, arrayList);
            }
            arrayList.add(observer);
            return;
        }
        ArrayList<NotificationCenterDelegate> arrayList2 = this.observers.get(id);
        if (arrayList2 != null) {
            arrayList2.remove(observer);
        }
    }

    public boolean hasObservers(int id) {
        return this.observers.indexOfKey(id) >= 0;
    }

    public void addPostponeNotificationsCallback(PostponeNotificationCallback callback) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("PostponeNotificationsCallback allowed only from MAIN thread");
        }
        if (this.postponeCallbackList.contains(callback)) {
            return;
        }
        this.postponeCallbackList.add(callback);
    }

    public void removePostponeNotificationsCallback(PostponeNotificationCallback callback) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("removePostponeNotificationsCallback allowed only from MAIN thread");
        }
        if (this.postponeCallbackList.remove(callback)) {
            runDelayedNotifications();
        }
    }

    public void doOnIdle(Runnable runnable) {
        if (isAnimationInProgress()) {
            this.delayedRunnables.add(runnable);
        } else {
            runnable.run();
        }
    }

    public void removeDelayed(Runnable runnable) {
        this.delayedRunnables.remove(runnable);
    }

    private static class AllowedNotifications {
        int[] allowedIds;
        final long time;

        private AllowedNotifications() {
            this.time = SystemClock.elapsedRealtime();
        }
    }
}
