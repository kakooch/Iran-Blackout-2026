package org.rbmain.messenger;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.ViewCompat;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import ir.aaap.messengercore.exceptions.NotificationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes4.dex */
public class NotificationCenter {
    public static final int FileDidFailUpload;
    public static final int FileDidUpload;
    public static final int FileLoadProgressChanged;
    public static final int FileUploadProgressChanged;
    private static volatile NotificationCenter[] Instance = new NotificationCenter[3];
    public static final int albumsDidLoad;
    public static int allStoriesIsSeenChanged = 0;
    public static final int animatedEmojiDocumentLoaded;
    public static final int appDidLogout;
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
    public static final int chatAvailableReactionsUpdated;
    public static final int chatDidCreated;
    public static final int chatDidFailCreate;
    public static final int chatInfoCantLoad;
    public static final int chatInfoDidLoad;
    public static final int chatNeedReload;
    public static final int chatOnlineCountDidLoad;
    public static final int chatSearchResultsAvailable;
    public static final int chatSearchResultsLoading;
    public static final int closeChats;
    public static final int closeInCallActivity;
    public static final int closeOtherAppActivities;
    public static final int closeSearchByActiveAction;
    public static final int commentsRead;
    public static final int compressVideoDone;
    public static final int compressVideoFaild;
    public static final int compressVideoProgressChanged;
    public static int compressVideoStarted = 0;
    public static final int configLoaded;
    public static final int contactsDidLoad;
    public static final int contactsImported;
    public static final int dialogDeleted;
    public static final int dialogFiltersUpdated;
    public static final int dialogIsTranslatable;
    public static final int dialogPhotosLoaded;
    public static final int dialogTranslate;
    public static final int dialogsLoadingChange;
    public static final int dialogsNeedReload;
    public static final int dialogsUnreadCounterChanged;
    public static final int dialogsUnreadReactionsCounterChanged;
    public static final int diceStickersDidLoad;
    public static final int didApplyNewTheme;
    public static final int didClearDatabase;
    public static final int didCreatedNewDeleteTask;
    public static final int didEndCall;
    public static final int didLoadChatAdmins;
    public static final int didLoadChatInviter;
    public static final int didLoadPinnedMessages;
    public static final int didLoadSendAsPeers;
    public static final int didLoadSponsoredMessages;
    public static final int didReceiveCall;
    public static final int didReceiveNewMessages;
    public static final int didReceiveSmsCode;
    public static final int didReceivedWebpages;
    public static final int didReceivedWebpagesInUpdates;
    public static final int didRemoveTwoStepPassword;
    public static final int didReplacedPhotoInMemCache;
    public static final int didSetChildLockPassword;
    public static final int didSetNewTheme;
    public static final int didSetNewWallpapper;
    public static final int didSetOrRemoveTwoStepPassword;
    public static final int didSetPasscode;
    public static final int didStartedCall;
    public static final int didUpdateConnectionState;
    public static final int didUpdateExtendedMedia;
    public static final int didUpdateMessagesViews;
    public static final int didUpdatePollResults;
    public static final int didUpdateReactions;
    public static final int didVerifyMessagesStickers;
    public static final int emojiDidLoad;
    public static final int encryptedChatCreated;
    public static final int encryptedChatUpdated;
    public static final int explorePlayerDidStartPlaying;
    public static final int explorePlayersShouldPause;
    public static final int featuredStickersDidLoad;
    public static final int fileDidFailToLoad;
    public static final int fileDidLoad;
    public static final int fileNewChunkAvailable;
    public static final int filePreparingFailed;
    public static final int filePreparingStarted;
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
    public static int highlightAdded = 0;
    public static int highlightDeleted = 0;
    public static int highlightEdited = 0;
    public static int highlightStoryIdsDidLoad = 0;
    public static final int historyCleared;
    public static final int historyImportProgressChanged;
    public static final int httpFileDidFailedLoad;
    public static final int httpFileDidLoad;
    public static final int igtvPlayerAdjustVolume;
    public static final int invalidateMotionBackground;
    public static final int lastOnlineUpdated;
    public static final int liveLocationsCacheChanged;
    public static final int liveLocationsChanged;
    public static final int liveStatusChanged;
    public static final int loadingMessagesFailed;
    public static final int locationPermissionDenied = 1;
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
    public static final int messageThumbGenerated;
    public static final int messageTranslated;
    public static final int messageTranslating;
    public static final int messagesDeleted;
    public static final int messagesDidFailed;
    public static final int messagesDidLoad;
    public static final int messagesDidLoadWithoutProcess;
    public static final int messagesRead;
    public static final int messagesReadContent;
    public static final int messagesReadEncrypted;
    public static final int moreMusicDidLoad;
    public static final int musicDidLoad;
    public static final int myDownloadCompleted;
    public static final int myDownloadStarted;
    public static final int myFileUploadDoneInsta;
    public static final int myFileUploadDoneMessengerV2;
    public static final int myFileUploadFaildInsta;
    public static final int myFileUploadFaildMessengerV2;
    public static final int myFileUploadProgressInsta;
    public static final int myFileUploadProgressMessengerV2;
    public static final int myFileUploadStartedMessengerV2;
    public static int myFirstStoryAdded = 0;
    public static final int myInstaPostChangeProgressView;
    public static final int myInstaRefreshSendingView;
    public static final int myInstaSendPostDone;
    public static final int myInstaUploadProfileDone;
    public static final int myInstaUploadProfilePhotoProgressView;
    public static final int myInstaUploadProfileRefreshView;
    public static final int myMessengerUploadProfileDone;
    public static final int myMessengerUploadProfilePhotoProgressView;
    public static final int myMessengerUploadProfileRefreshView;
    public static final int myMuteInsta;
    public static final int myNewChatUser;
    public static int myStoryAdded = 0;
    public static int myStoryDeleted = 0;
    public static final int myUpdateUserChat;
    public static final int mydownloadFaild;
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
    public static final int onEmojiInteractionsReceived;
    public static int onOldStateMessageUpdate = 0;
    public static final int openArticle;
    public static final int openedChatChanged;
    public static final int paymentFinished;
    public static final int peerSettingsDidLoad;
    public static final int permissionsGranted;
    public static final int pinnedInfoDidLoad;
    public static final int playerAdjustVolume;
    public static final int playerDidStartPlaying;
    public static final int playersShouldPause;
    public static final int privacyRulesUpdated;
    public static int profileStoryIdsDidLoad = 0;
    public static int profileStoryIdsFailed = 0;
    public static final int proxyCheckDone;
    public static final int proxySettingsChanged;
    public static final int pushMessagesUpdated;
    public static final int reactionsDidLoad;
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
    public static final int requestPermissions;
    public static final int requestToLoadDataListNextPage;
    public static final int responseOfDataListNextPage;
    public static int rubinoBookmarkPostChanged = 0;
    public static int rubinoCommentCountChange = 0;
    public static int rubinoExploreTopicsUpdated = 0;
    public static int rubinoFollowBlockChanged = 0;
    public static int rubinoLikeCommentChanged = 0;
    public static int rubinoLikePostChanged = 0;
    public static int rubinoLiveStatusChanged = 0;
    public static int rubinoMyProfileListUpdated = 0;
    public static int rubinoMyProfileNotifCountChange = 0;
    public static int rubinoNewEventDeleted = 0;
    public static int rubinoPostDeleted = 0;
    public static int rubinoPostEdited = 0;
    public static int rubinoPostEditedFailed = 0;
    public static int rubinoProfileDeleted = 0;
    public static int rubinoProfileDidLoad = 0;
    public static int rubinoProfileLoadingFailed = 0;
    public static int rubinoProfileUpdated = 0;
    public static int rubinoRequestAnswered = 0;
    public static final int scheduledMessagesUpdated;
    public static final int screenStateChanged;
    public static final int screenshotTook;
    public static final int sendingMessagesChanged;
    public static int sendingStoryStatusChanges = 0;
    public static final int showBulletin;
    public static final int sshFileNewChunkAvailable;
    public static final int sshFilePreparingFailed;
    public static final int sshFilePreparingStarted;
    public static final int startAllHeavyOperations;
    public static final int startSpoilers;
    public static final int stickersDidLoad;
    public static final int stopAllHeavyOperations;
    public static final int stopEncodingService;
    public static final int stopSpoilers;
    public static int storyBackgroundCreated = 0;
    public static int storyCurrentLoadingProfileChanged = 0;
    public static final int storyFileUploadDone;
    public static final int storyFileUploadFaild;
    public static final int storyFileUploadProgress;
    public static final int storyFileUploadStarted;
    public static int storyListEmptyDetected = 0;
    public static int storyObjectDidLoad = 0;
    public static int storySeenCountChange = 0;
    public static int storySendFailedOrRetry = 0;
    public static int storySendProgressCanceled = 0;
    public static int storySendProgressChange = 0;
    public static int storySendProgressCompleted = 0;
    public static final int suggestedFiltersLoaded;
    public static final int suggestedLangpack;
    public static final int themeAccentListUpdated;
    public static final int themeListUpdated;
    public static final int themeUploadError;
    public static final int themeUploadedToServer;
    public static final int threadMessagesRead;
    public static int topicsDidLoaded = 0;
    private static int totalEvents = 1;
    public static final int twoStepPasswordChanged;
    public static final int updateDefaultSendAsPeer;
    public static int updateGroupedMessages;
    public static final int updateInterfaces;
    public static final int updateMentionsCount;
    public static final int updateMessageMedia;
    public static final int userEmojiStatusUpdated;
    public static final int userInfoDidLoad;
    public static final int videoLoadingStateChanged;
    public static final int voiceTranscriptionUpdate;
    public static final int voipServiceCreated;
    public static final int walletPendingTransactionsChanged;
    public static final int walletSyncProgressChanged;
    public static int wallpaperSettedToUser;
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

    /* loaded from: classes.dex */
    public interface NotificationCenterDelegate {
        void didReceivedNotification(int i, int i2, Object... objArr);
    }

    public interface PostponeNotificationCallback {
        boolean needPostpone(int i, int i2, Object[] objArr);
    }

    static {
        int i = 1 + 1;
        totalEvents = i;
        int i2 = i + 1;
        totalEvents = i2;
        onEmojiInteractionsReceived = i;
        int i3 = i2 + 1;
        totalEvents = i3;
        didLoadSponsoredMessages = i2;
        int i4 = i3 + 1;
        totalEvents = i4;
        didLoadSendAsPeers = i3;
        int i5 = i4 + 1;
        totalEvents = i5;
        updateDefaultSendAsPeer = i4;
        int i6 = i5 + 1;
        totalEvents = i6;
        didUpdateExtendedMedia = i5;
        int i7 = i6 + 1;
        totalEvents = i7;
        topicsDidLoaded = i6;
        int i8 = i7 + 1;
        totalEvents = i8;
        chatAvailableReactionsUpdated = i7;
        int i9 = i8 + 1;
        totalEvents = i9;
        dialogsUnreadReactionsCounterChanged = i8;
        int i10 = i9 + 1;
        totalEvents = i10;
        dialogTranslate = i9;
        int i11 = i10 + 1;
        totalEvents = i11;
        messageTranslated = i10;
        int i12 = i11 + 1;
        totalEvents = i12;
        messageTranslating = i11;
        int i13 = i12 + 1;
        totalEvents = i13;
        dialogIsTranslatable = i12;
        int i14 = i13 + 1;
        totalEvents = i14;
        voiceTranscriptionUpdate = i13;
        int i15 = i14 + 1;
        totalEvents = i15;
        wallpaperSettedToUser = i14;
        int i16 = i15 + 1;
        totalEvents = i16;
        highlightStoryIdsDidLoad = i15;
        int i17 = i16 + 1;
        totalEvents = i17;
        highlightAdded = i16;
        int i18 = i17 + 1;
        totalEvents = i18;
        highlightDeleted = i17;
        int i19 = i18 + 1;
        totalEvents = i19;
        highlightEdited = i18;
        int i20 = i19 + 1;
        totalEvents = i20;
        igtvPlayerAdjustVolume = i19;
        int i21 = i20 + 1;
        totalEvents = i21;
        requestToLoadDataListNextPage = i20;
        int i22 = i21 + 1;
        totalEvents = i22;
        responseOfDataListNextPage = i21;
        int i23 = i22 + 1;
        totalEvents = i23;
        messageThumbGenerated = i22;
        int i24 = i23 + 1;
        totalEvents = i24;
        myNewChatUser = i23;
        int i25 = i24 + 1;
        totalEvents = i25;
        myUpdateUserChat = i24;
        int i26 = i25 + 1;
        totalEvents = i26;
        myMessengerUploadProfileRefreshView = i25;
        int i27 = i26 + 1;
        totalEvents = i27;
        myMessengerUploadProfilePhotoProgressView = i26;
        int i28 = i27 + 1;
        totalEvents = i28;
        myMessengerUploadProfileDone = i27;
        int i29 = i28 + 1;
        totalEvents = i29;
        myDownloadCompleted = i28;
        int i30 = i29 + 1;
        totalEvents = i30;
        myDownloadStarted = i29;
        int i31 = i30 + 1;
        totalEvents = i31;
        mydownloadFaild = i30;
        int i32 = i31 + 1;
        totalEvents = i32;
        compressVideoStarted = i31;
        int i33 = i32 + 1;
        totalEvents = i33;
        compressVideoProgressChanged = i32;
        int i34 = i33 + 1;
        totalEvents = i34;
        compressVideoDone = i33;
        int i35 = i34 + 1;
        totalEvents = i35;
        compressVideoFaild = i34;
        int i36 = i35 + 1;
        totalEvents = i36;
        storyFileUploadProgress = i35;
        int i37 = i36 + 1;
        totalEvents = i37;
        storyFileUploadDone = i36;
        int i38 = i37 + 1;
        totalEvents = i38;
        storyFileUploadFaild = i37;
        int i39 = i38 + 1;
        totalEvents = i39;
        storyFileUploadStarted = i38;
        int i40 = i39 + 1;
        totalEvents = i40;
        sshFilePreparingFailed = i39;
        int i41 = i40 + 1;
        totalEvents = i41;
        sshFilePreparingStarted = i40;
        int i42 = i41 + 1;
        totalEvents = i42;
        sshFileNewChunkAvailable = i41;
        int i43 = i42 + 1;
        totalEvents = i43;
        myFileUploadProgressInsta = i42;
        int i44 = i43 + 1;
        totalEvents = i44;
        myFileUploadDoneInsta = i43;
        int i45 = i44 + 1;
        totalEvents = i45;
        myFileUploadFaildInsta = i44;
        int i46 = i45 + 1;
        totalEvents = i46;
        myInstaRefreshSendingView = i45;
        int i47 = i46 + 1;
        totalEvents = i47;
        myInstaPostChangeProgressView = i46;
        int i48 = i47 + 1;
        totalEvents = i48;
        myInstaSendPostDone = i47;
        int i49 = i48 + 1;
        totalEvents = i49;
        myInstaUploadProfileRefreshView = i48;
        int i50 = i49 + 1;
        totalEvents = i50;
        myInstaUploadProfilePhotoProgressView = i49;
        int i51 = i50 + 1;
        totalEvents = i51;
        myInstaUploadProfileDone = i50;
        int i52 = i51 + 1;
        totalEvents = i52;
        myMuteInsta = i51;
        int i53 = i52 + 1;
        totalEvents = i53;
        myFileUploadProgressMessengerV2 = i52;
        int i54 = i53 + 1;
        totalEvents = i54;
        myFileUploadDoneMessengerV2 = i53;
        int i55 = i54 + 1;
        totalEvents = i55;
        myFileUploadFaildMessengerV2 = i54;
        int i56 = i55 + 1;
        totalEvents = i56;
        myFileUploadStartedMessengerV2 = i55;
        int i57 = i56 + 1;
        totalEvents = i57;
        playerDidStartPlaying = i56;
        int i58 = i57 + 1;
        totalEvents = i58;
        explorePlayerDidStartPlaying = i57;
        int i59 = i58 + 1;
        totalEvents = i59;
        explorePlayersShouldPause = i58;
        int i60 = i59 + 1;
        totalEvents = i60;
        playersShouldPause = i59;
        int i61 = i60 + 1;
        totalEvents = i61;
        playerAdjustVolume = i60;
        int i62 = i61 + 1;
        totalEvents = i62;
        storyListEmptyDetected = i61;
        int i63 = i62 + 1;
        totalEvents = i63;
        storySendFailedOrRetry = i62;
        int i64 = i63 + 1;
        totalEvents = i64;
        storySendProgressChange = i63;
        int i65 = i64 + 1;
        totalEvents = i65;
        storySendProgressCompleted = i64;
        int i66 = i65 + 1;
        totalEvents = i66;
        storySendProgressCanceled = i65;
        int i67 = i66 + 1;
        totalEvents = i67;
        storyBackgroundCreated = i66;
        int i68 = i67 + 1;
        totalEvents = i68;
        storyCurrentLoadingProfileChanged = i67;
        int i69 = i68 + 1;
        totalEvents = i69;
        rubinoMyProfileListUpdated = i68;
        int i70 = i69 + 1;
        totalEvents = i70;
        rubinoLiveStatusChanged = i69;
        int i71 = i70 + 1;
        totalEvents = i71;
        rubinoLikeCommentChanged = i70;
        int i72 = i71 + 1;
        totalEvents = i72;
        rubinoRequestAnswered = i71;
        int i73 = i72 + 1;
        totalEvents = i73;
        rubinoNewEventDeleted = i72;
        int i74 = i73 + 1;
        totalEvents = i74;
        rubinoExploreTopicsUpdated = i73;
        int i75 = i74 + 1;
        totalEvents = i75;
        rubinoPostEditedFailed = i74;
        int i76 = i75 + 1;
        totalEvents = i76;
        rubinoPostEdited = i75;
        int i77 = i76 + 1;
        totalEvents = i77;
        rubinoCommentCountChange = i76;
        int i78 = i77 + 1;
        totalEvents = i78;
        rubinoProfileUpdated = i77;
        int i79 = i78 + 1;
        totalEvents = i79;
        rubinoPostDeleted = i78;
        int i80 = i79 + 1;
        totalEvents = i80;
        rubinoProfileDeleted = i79;
        int i81 = i80 + 1;
        totalEvents = i81;
        rubinoProfileLoadingFailed = i80;
        int i82 = i81 + 1;
        totalEvents = i82;
        rubinoMyProfileNotifCountChange = i81;
        int i83 = i82 + 1;
        totalEvents = i83;
        rubinoProfileDidLoad = i82;
        int i84 = i83 + 1;
        totalEvents = i84;
        rubinoBookmarkPostChanged = i83;
        int i85 = i84 + 1;
        totalEvents = i85;
        rubinoLikePostChanged = i84;
        int i86 = i85 + 1;
        totalEvents = i86;
        rubinoFollowBlockChanged = i85;
        int i87 = i86 + 1;
        totalEvents = i87;
        sendingStoryStatusChanges = i86;
        int i88 = i87 + 1;
        totalEvents = i88;
        storySeenCountChange = i87;
        int i89 = i88 + 1;
        totalEvents = i89;
        myFirstStoryAdded = i88;
        int i90 = i89 + 1;
        totalEvents = i90;
        allStoriesIsSeenChanged = i89;
        int i91 = i90 + 1;
        totalEvents = i91;
        myStoryAdded = i90;
        int i92 = i91 + 1;
        totalEvents = i92;
        myStoryDeleted = i91;
        int i93 = i92 + 1;
        totalEvents = i93;
        storyObjectDidLoad = i92;
        int i94 = i93 + 1;
        totalEvents = i94;
        profileStoryIdsDidLoad = i93;
        int i95 = i94 + 1;
        totalEvents = i95;
        profileStoryIdsFailed = i94;
        int i96 = i95 + 1;
        totalEvents = i96;
        updateGroupedMessages = i95;
        int i97 = i96 + 1;
        totalEvents = i97;
        onOldStateMessageUpdate = i96;
        int i98 = i97 + 1;
        totalEvents = i98;
        lastOnlineUpdated = i97;
        int i99 = i98 + 1;
        totalEvents = i99;
        didReceiveNewMessages = i98;
        int i100 = i99 + 1;
        totalEvents = i100;
        updateInterfaces = i99;
        int i101 = i100 + 1;
        totalEvents = i101;
        dialogsNeedReload = i100;
        int i102 = i101 + 1;
        totalEvents = i102;
        closeChats = i101;
        int i103 = i102 + 1;
        totalEvents = i103;
        messagesDeleted = i102;
        int i104 = i103 + 1;
        totalEvents = i104;
        historyCleared = i103;
        int i105 = i104 + 1;
        totalEvents = i105;
        messagesRead = i104;
        int i106 = i105 + 1;
        totalEvents = i106;
        threadMessagesRead = i105;
        int i107 = i106 + 1;
        totalEvents = i107;
        commentsRead = i106;
        int i108 = i107 + 1;
        totalEvents = i108;
        changeRepliesCounter = i107;
        int i109 = i108 + 1;
        totalEvents = i109;
        messagesDidFailed = i108;
        int i110 = i109 + 1;
        totalEvents = i110;
        messagesDidLoad = i109;
        int i111 = i110 + 1;
        totalEvents = i111;
        messagesDidLoadWithoutProcess = i110;
        int i112 = i111 + 1;
        totalEvents = i112;
        loadingMessagesFailed = i111;
        int i113 = i112 + 1;
        totalEvents = i113;
        messageReceivedByAck = i112;
        int i114 = i113 + 1;
        totalEvents = i114;
        messageReceivedByServer = i113;
        int i115 = i114 + 1;
        totalEvents = i115;
        messageSendError = i114;
        int i116 = i115 + 1;
        totalEvents = i116;
        contactsDidLoad = i115;
        int i117 = i116 + 1;
        totalEvents = i117;
        contactsImported = i116;
        int i118 = i117 + 1;
        totalEvents = i118;
        hasNewContactsToImport = i117;
        int i119 = i118 + 1;
        totalEvents = i119;
        chatDidCreated = i118;
        int i120 = i119 + 1;
        totalEvents = i120;
        chatDidFailCreate = i119;
        int i121 = i120 + 1;
        totalEvents = i121;
        chatInfoDidLoad = i120;
        int i122 = i121 + 1;
        totalEvents = i122;
        chatInfoCantLoad = i121;
        int i123 = i122 + 1;
        totalEvents = i123;
        mediaDidLoad = i122;
        int i124 = i123 + 1;
        totalEvents = i124;
        mediaCountDidLoad = i123;
        int i125 = i124 + 1;
        totalEvents = i125;
        mediaCountsDidLoad = i124;
        int i126 = i125 + 1;
        totalEvents = i126;
        encryptedChatUpdated = i125;
        int i127 = i126 + 1;
        totalEvents = i127;
        messagesReadEncrypted = i126;
        int i128 = i127 + 1;
        totalEvents = i128;
        encryptedChatCreated = i127;
        int i129 = i128 + 1;
        totalEvents = i129;
        dialogPhotosLoaded = i128;
        int i130 = i129 + 1;
        totalEvents = i130;
        reloadDialogPhotos = i129;
        int i131 = i130 + 1;
        totalEvents = i131;
        folderBecomeEmpty = i130;
        int i132 = i131 + 1;
        totalEvents = i132;
        removeAllMessagesFromDialog = i131;
        int i133 = i132 + 1;
        totalEvents = i133;
        notificationsSettingsUpdated = i132;
        int i134 = i133 + 1;
        totalEvents = i134;
        blockedUsersDidLoad = i133;
        int i135 = i134 + 1;
        totalEvents = i135;
        openedChatChanged = i134;
        int i136 = i135 + 1;
        totalEvents = i136;
        didCreatedNewDeleteTask = i135;
        int i137 = i136 + 1;
        totalEvents = i137;
        mainUserInfoChanged = i136;
        int i138 = i137 + 1;
        totalEvents = i138;
        privacyRulesUpdated = i137;
        int i139 = i138 + 1;
        totalEvents = i139;
        updateMessageMedia = i138;
        int i140 = i139 + 1;
        totalEvents = i140;
        replaceMessagesObjects = i139;
        int i141 = i140 + 1;
        totalEvents = i141;
        didSetPasscode = i140;
        int i142 = i141 + 1;
        totalEvents = i142;
        twoStepPasswordChanged = i141;
        int i143 = i142 + 1;
        totalEvents = i143;
        didSetOrRemoveTwoStepPassword = i142;
        int i144 = i143 + 1;
        totalEvents = i144;
        didRemoveTwoStepPassword = i143;
        int i145 = i144 + 1;
        totalEvents = i145;
        replyMessagesDidLoad = i144;
        int i146 = i145 + 1;
        totalEvents = i146;
        didLoadPinnedMessages = i145;
        int i147 = i146 + 1;
        totalEvents = i147;
        newSessionReceived = i146;
        int i148 = i147 + 1;
        totalEvents = i148;
        didReceivedWebpages = i147;
        int i149 = i148 + 1;
        totalEvents = i149;
        didReceivedWebpagesInUpdates = i148;
        int i150 = i149 + 1;
        totalEvents = i150;
        stickersDidLoad = i149;
        int i151 = i150 + 1;
        totalEvents = i151;
        diceStickersDidLoad = i150;
        int i152 = i151 + 1;
        totalEvents = i152;
        featuredStickersDidLoad = i151;
        int i153 = i152 + 1;
        totalEvents = i153;
        groupStickersDidLoad = i152;
        int i154 = i153 + 1;
        totalEvents = i154;
        messagesReadContent = i153;
        int i155 = i154 + 1;
        totalEvents = i155;
        botInfoDidLoad = i154;
        int i156 = i155 + 1;
        totalEvents = i156;
        userInfoDidLoad = i155;
        int i157 = i156 + 1;
        totalEvents = i157;
        pinnedInfoDidLoad = i156;
        int i158 = i157 + 1;
        totalEvents = i158;
        botKeyboardDidLoad = i157;
        int i159 = i158 + 1;
        totalEvents = i159;
        chatSearchResultsAvailable = i158;
        int i160 = i159 + 1;
        totalEvents = i160;
        chatSearchResultsLoading = i159;
        int i161 = i160 + 1;
        totalEvents = i161;
        musicDidLoad = i160;
        int i162 = i161 + 1;
        totalEvents = i162;
        moreMusicDidLoad = i161;
        int i163 = i162 + 1;
        totalEvents = i163;
        needShowAlert = i162;
        int i164 = i163 + 1;
        totalEvents = i164;
        needShowPlayServicesAlert = i163;
        int i165 = i164 + 1;
        totalEvents = i165;
        didUpdateMessagesViews = i164;
        int i166 = i165 + 1;
        totalEvents = i166;
        needReloadRecentDialogsSearch = i165;
        int i167 = i166 + 1;
        totalEvents = i167;
        peerSettingsDidLoad = i166;
        int i168 = i167 + 1;
        totalEvents = i168;
        wasUnableToFindCurrentLocation = i167;
        int i169 = i168 + 1;
        totalEvents = i169;
        reloadHints = i168;
        int i170 = i169 + 1;
        totalEvents = i170;
        reloadInlineHints = i169;
        int i171 = i170 + 1;
        totalEvents = i171;
        newDraftReceived = i170;
        int i172 = i171 + 1;
        totalEvents = i172;
        recentDocumentsDidLoad = i171;
        int i173 = i172 + 1;
        totalEvents = i173;
        needAddArchivedStickers = i172;
        int i174 = i173 + 1;
        totalEvents = i174;
        archivedStickersCountDidLoad = i173;
        int i175 = i174 + 1;
        totalEvents = i175;
        paymentFinished = i174;
        int i176 = i175 + 1;
        totalEvents = i176;
        channelRightsUpdated = i175;
        int i177 = i176 + 1;
        totalEvents = i177;
        openArticle = i176;
        int i178 = i177 + 1;
        totalEvents = i178;
        updateMentionsCount = i177;
        int i179 = i178 + 1;
        totalEvents = i179;
        didUpdatePollResults = i178;
        int i180 = i179 + 1;
        totalEvents = i180;
        chatOnlineCountDidLoad = i179;
        int i181 = i180 + 1;
        totalEvents = i181;
        videoLoadingStateChanged = i180;
        int i182 = i181 + 1;
        totalEvents = i182;
        newPeopleNearbyAvailable = i181;
        int i183 = i182 + 1;
        totalEvents = i183;
        stopAllHeavyOperations = i182;
        int i184 = i183 + 1;
        totalEvents = i184;
        startAllHeavyOperations = i183;
        int i185 = i184 + 1;
        totalEvents = i185;
        stopSpoilers = i184;
        int i186 = i185 + 1;
        totalEvents = i186;
        startSpoilers = i185;
        int i187 = i186 + 1;
        totalEvents = i187;
        sendingMessagesChanged = i186;
        int i188 = i187 + 1;
        totalEvents = i188;
        didUpdateReactions = i187;
        int i189 = i188 + 1;
        totalEvents = i189;
        didVerifyMessagesStickers = i188;
        int i190 = i189 + 1;
        totalEvents = i190;
        scheduledMessagesUpdated = i189;
        int i191 = i190 + 1;
        totalEvents = i191;
        newSuggestionsAvailable = i190;
        int i192 = i191 + 1;
        totalEvents = i192;
        didLoadChatInviter = i191;
        int i193 = i192 + 1;
        totalEvents = i193;
        didLoadChatAdmins = i192;
        int i194 = i193 + 1;
        totalEvents = i194;
        historyImportProgressChanged = i193;
        int i195 = i194 + 1;
        totalEvents = i195;
        dialogDeleted = i194;
        int i196 = i195 + 1;
        totalEvents = i196;
        animatedEmojiDocumentLoaded = i195;
        int i197 = i196 + 1;
        totalEvents = i197;
        walletPendingTransactionsChanged = i196;
        int i198 = i197 + 1;
        totalEvents = i198;
        walletSyncProgressChanged = i197;
        int i199 = i198 + 1;
        totalEvents = i199;
        httpFileDidLoad = i198;
        int i200 = i199 + 1;
        totalEvents = i200;
        httpFileDidFailedLoad = i199;
        int i201 = i200 + 1;
        totalEvents = i201;
        didUpdateConnectionState = i200;
        int i202 = i201 + 1;
        totalEvents = i202;
        FileDidUpload = i201;
        int i203 = i202 + 1;
        totalEvents = i203;
        FileDidFailUpload = i202;
        int i204 = i203 + 1;
        totalEvents = i204;
        FileUploadProgressChanged = i203;
        int i205 = i204 + 1;
        totalEvents = i205;
        FileLoadProgressChanged = i204;
        int i206 = i205 + 1;
        totalEvents = i206;
        fileDidLoad = i205;
        int i207 = i206 + 1;
        totalEvents = i207;
        fileDidFailToLoad = i206;
        int i208 = i207 + 1;
        totalEvents = i208;
        filePreparingStarted = i207;
        int i209 = i208 + 1;
        totalEvents = i209;
        fileNewChunkAvailable = i208;
        int i210 = i209 + 1;
        totalEvents = i210;
        filePreparingFailed = i209;
        int i211 = i210 + 1;
        totalEvents = i211;
        dialogsUnreadCounterChanged = i210;
        int i212 = i211 + 1;
        totalEvents = i212;
        messagePlayingProgressDidChanged = i211;
        int i213 = i212 + 1;
        totalEvents = i213;
        messagePlayingDidReset = i212;
        int i214 = i213 + 1;
        totalEvents = i214;
        messagePlayingPlayStateChanged = i213;
        int i215 = i214 + 1;
        totalEvents = i215;
        messagePlayingDidStart = i214;
        int i216 = i215 + 1;
        totalEvents = i216;
        messagePlayingDidSeek = i215;
        int i217 = i216 + 1;
        totalEvents = i217;
        messagePlayingGoingToStop = i216;
        int i218 = i217 + 1;
        totalEvents = i218;
        recordProgressChanged = i217;
        int i219 = i218 + 1;
        totalEvents = i219;
        recordStarted = i218;
        int i220 = i219 + 1;
        totalEvents = i220;
        recordStartError = i219;
        int i221 = i220 + 1;
        totalEvents = i221;
        recordStopped = i220;
        int i222 = i221 + 1;
        totalEvents = i222;
        screenshotTook = i221;
        int i223 = i222 + 1;
        totalEvents = i223;
        albumsDidLoad = i222;
        int i224 = i223 + 1;
        totalEvents = i224;
        audioDidSent = i223;
        int i225 = i224 + 1;
        totalEvents = i225;
        audioRecordTooShort = i224;
        int i226 = i225 + 1;
        totalEvents = i226;
        audioRouteChanged = i225;
        int i227 = i226 + 1;
        totalEvents = i227;
        didStartedCall = i226;
        int i228 = i227 + 1;
        totalEvents = i228;
        groupCallUpdated = i227;
        int i229 = i228 + 1;
        totalEvents = i229;
        applyGroupCallVisibleParticipants = i228;
        int i230 = i229 + 1;
        totalEvents = i230;
        groupCallTypingsUpdated = i229;
        int i231 = i230 + 1;
        totalEvents = i231;
        didEndCall = i230;
        int i232 = i231 + 1;
        totalEvents = i232;
        closeInCallActivity = i231;
        int i233 = i232 + 1;
        totalEvents = i233;
        groupCallVisibilityChanged = i232;
        int i234 = i233 + 1;
        totalEvents = i234;
        appDidLogout = i233;
        int i235 = i234 + 1;
        totalEvents = i235;
        configLoaded = i234;
        int i236 = i235 + 1;
        totalEvents = i236;
        needDeleteDialog = i235;
        int i237 = i236 + 1;
        totalEvents = i237;
        newEmojiSuggestionsAvailable = i236;
        int i238 = i237 + 1;
        totalEvents = i238;
        themeUploadedToServer = i237;
        int i239 = i238 + 1;
        totalEvents = i239;
        themeUploadError = i238;
        int i240 = i239 + 1;
        totalEvents = i240;
        dialogFiltersUpdated = i239;
        int i241 = i240 + 1;
        totalEvents = i241;
        filterSettingsUpdated = i240;
        int i242 = i241 + 1;
        totalEvents = i242;
        suggestedFiltersLoaded = i241;
        int i243 = i242 + 1;
        totalEvents = i243;
        dialogsLoadingChange = i242;
        int i244 = i243 + 1;
        totalEvents = i244;
        pushMessagesUpdated = i243;
        int i245 = i244 + 1;
        totalEvents = i245;
        stopEncodingService = i244;
        int i246 = i245 + 1;
        totalEvents = i246;
        wallpapersDidLoad = i245;
        int i247 = i246 + 1;
        totalEvents = i247;
        wallpapersNeedReload = i246;
        int i248 = i247 + 1;
        totalEvents = i248;
        didReceiveSmsCode = i247;
        int i249 = i248 + 1;
        totalEvents = i249;
        didReceiveCall = i248;
        int i250 = i249 + 1;
        totalEvents = i250;
        emojiDidLoad = i249;
        int i251 = i250 + 1;
        totalEvents = i251;
        invalidateMotionBackground = i250;
        int i252 = i251 + 1;
        totalEvents = i252;
        closeOtherAppActivities = i251;
        int i253 = i252 + 1;
        totalEvents = i253;
        cameraInitied = i252;
        int i254 = i253 + 1;
        totalEvents = i254;
        didReplacedPhotoInMemCache = i253;
        int i255 = i254 + 1;
        totalEvents = i255;
        didSetNewTheme = i254;
        int i256 = i255 + 1;
        totalEvents = i256;
        themeListUpdated = i255;
        int i257 = i256 + 1;
        totalEvents = i257;
        didApplyNewTheme = i256;
        int i258 = i257 + 1;
        totalEvents = i258;
        themeAccentListUpdated = i257;
        int i259 = i258 + 1;
        totalEvents = i259;
        needCheckSystemBarColors = i258;
        int i260 = i259 + 1;
        totalEvents = i260;
        needShareTheme = i259;
        int i261 = i260 + 1;
        totalEvents = i261;
        needSetDayNightTheme = i260;
        int i262 = i261 + 1;
        totalEvents = i262;
        goingToPreviewTheme = i261;
        int i263 = i262 + 1;
        totalEvents = i263;
        locationPermissionGranted = i262;
        int i264 = i263 + 1;
        totalEvents = i264;
        reloadInterface = i263;
        int i265 = i264 + 1;
        totalEvents = i265;
        suggestedLangpack = i264;
        int i266 = i265 + 1;
        totalEvents = i266;
        didSetNewWallpapper = i265;
        int i267 = i266 + 1;
        totalEvents = i267;
        proxySettingsChanged = i266;
        int i268 = i267 + 1;
        totalEvents = i268;
        proxyCheckDone = i267;
        int i269 = i268 + 1;
        totalEvents = i269;
        liveLocationsChanged = i268;
        int i270 = i269 + 1;
        totalEvents = i270;
        newLocationAvailable = i269;
        int i271 = i270 + 1;
        totalEvents = i271;
        liveLocationsCacheChanged = i270;
        int i272 = i271 + 1;
        totalEvents = i272;
        notificationsCountUpdated = i271;
        int i273 = i272 + 1;
        totalEvents = i273;
        closeSearchByActiveAction = i272;
        int i274 = i273 + 1;
        totalEvents = i274;
        messagePlayingSpeedChanged = i273;
        int i275 = i274 + 1;
        totalEvents = i275;
        screenStateChanged = i274;
        int i276 = i275 + 1;
        totalEvents = i276;
        didClearDatabase = i275;
        int i277 = i276 + 1;
        totalEvents = i277;
        voipServiceCreated = i276;
        int i278 = i277 + 1;
        totalEvents = i278;
        webRtcMicAmplitudeEvent = i277;
        int i279 = i278 + 1;
        totalEvents = i279;
        webRtcSpeakerAmplitudeEvent = i278;
        int i280 = i279 + 1;
        totalEvents = i280;
        showBulletin = i279;
        int i281 = i280 + 1;
        totalEvents = i281;
        chatNeedReload = i280;
        int i282 = i281 + 1;
        totalEvents = i282;
        liveStatusChanged = i281;
        int i283 = i282 + 1;
        totalEvents = i283;
        didSetChildLockPassword = i282;
        int i284 = i283 + 1;
        totalEvents = i284;
        requestPermissions = i283;
        int i285 = i284 + 1;
        totalEvents = i285;
        permissionsGranted = i284;
        int i286 = i285 + 1;
        totalEvents = i286;
        reactionsDidLoad = i285;
        int i287 = i286 + 1;
        totalEvents = i287;
        userEmojiStatusUpdated = i286;
        int i288 = i287 + 1;
        totalEvents = i288;
        groupCallSpeakingUsersUpdated = i287;
        totalEvents = i288 + 1;
        groupCallScreencastStateChanged = i288;
    }

    public void removeDelayed(Runnable runnable) {
        this.delayedRunnables.remove(runnable);
    }

    public static void listenEmojiLoading(final View view) {
        if (view == null) {
            return;
        }
        final NotificationCenterDelegate notificationCenterDelegate = new NotificationCenterDelegate() { // from class: org.rbmain.messenger.NotificationCenter$$ExternalSyntheticLambda3
            @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
            public final void didReceivedNotification(int i, int i2, Object[] objArr) {
                NotificationCenter.lambda$listenEmojiLoading$0(view, i, i2, objArr);
            }
        };
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: org.rbmain.messenger.NotificationCenter.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                NotificationCenter.getGlobalInstance().addObserver(notificationCenterDelegate, NotificationCenter.emojiDidLoad);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                NotificationCenter.getGlobalInstance().removeObserver(notificationCenterDelegate, NotificationCenter.emojiDidLoad);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$listenEmojiLoading$0(View view, int i, int i2, Object[] objArr) {
        if (i == emojiDidLoad && view != null && ViewCompat.isAttachedToWindow(view)) {
            view.invalidate();
        }
    }

    private static class DelayedPost {
        private Object[] args;
        private int id;

        private DelayedPost(int i, Object[] objArr) {
            this.id = i;
            this.args = objArr;
        }
    }

    public static NotificationCenter getInstance(int i) {
        NotificationCenter notificationCenter = Instance[i];
        if (notificationCenter == null) {
            synchronized (NotificationCenter.class) {
                notificationCenter = Instance[i];
                if (notificationCenter == null) {
                    NotificationCenter[] notificationCenterArr = Instance;
                    NotificationCenter notificationCenter2 = new NotificationCenter(i);
                    notificationCenterArr[i] = notificationCenter2;
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

    public NotificationCenter(int i) {
        this.currentAccount = i;
    }

    public int setAnimationInProgress(int i, int[] iArr) {
        return setAnimationInProgress(i, iArr, true);
    }

    public int setAnimationInProgress(int i, int[] iArr, boolean z) {
        onAnimationFinish(i);
        if (this.heavyOperationsCounter.isEmpty() && z) {
            getGlobalInstance().postNotificationName(stopAllHeavyOperations, 512);
        }
        this.animationInProgressCount++;
        int i2 = this.animationInProgressPointer + 1;
        this.animationInProgressPointer = i2;
        if (z) {
            this.heavyOperationsCounter.add(Integer.valueOf(i2));
        }
        AllowedNotifications allowedNotifications = new AllowedNotifications();
        allowedNotifications.allowedIds = iArr;
        this.allowedNotifications.put(Integer.valueOf(this.animationInProgressPointer), allowedNotifications);
        if (this.checkForExpiredNotifications == null) {
            NotificationCenter$$ExternalSyntheticLambda1 notificationCenter$$ExternalSyntheticLambda1 = new NotificationCenter$$ExternalSyntheticLambda1(this);
            this.checkForExpiredNotifications = notificationCenter$$ExternalSyntheticLambda1;
            AndroidUtilities.runOnUIThread(notificationCenter$$ExternalSyntheticLambda1, 1017L);
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationCenter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkForExpiredNotifications$1();
                }
            }, Math.max(17L, 1017 - (jElapsedRealtime - jMin)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkForExpiredNotifications$1() {
        this.checkForExpiredNotifications = new NotificationCenter$$ExternalSyntheticLambda1(this);
    }

    public void updateAllowedNotifications(int i, int[] iArr) {
        AllowedNotifications allowedNotifications = this.allowedNotifications.get(Integer.valueOf(i));
        if (allowedNotifications != null) {
            allowedNotifications.allowedIds = iArr;
        }
    }

    public void onAnimationFinish(int i) {
        if (this.allowedNotifications.remove(Integer.valueOf(i)) != null) {
            this.animationInProgressCount--;
            if (!this.heavyOperationsCounter.isEmpty()) {
                this.heavyOperationsCounter.remove(Integer.valueOf(i));
                if (this.heavyOperationsCounter.isEmpty()) {
                    getGlobalInstance().postNotificationName(startAllHeavyOperations, 512);
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

    public ArrayList<NotificationCenterDelegate> getObservers(int i) {
        return this.observers.get(i);
    }

    public void postNotificationName(int i, Object... objArr) {
        boolean z = i == startAllHeavyOperations || i == stopAllHeavyOperations || i == didReplacedPhotoInMemCache || i == closeChats || i == invalidateMotionBackground;
        ArrayList arrayList = null;
        if (!z && !this.allowedNotifications.isEmpty()) {
            int size = this.allowedNotifications.size();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i2 = 0;
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
                int i3 = 0;
                while (true) {
                    if (i3 >= iArr.length) {
                        break;
                    }
                    if (iArr[i3] == i) {
                        i2++;
                        break;
                    }
                    i3++;
                }
            }
            z = size == i2;
        }
        if (i == startAllHeavyOperations) {
            this.currentHeavyOperationFlags = (((Integer) objArr[0]).intValue() ^ (-1)) & this.currentHeavyOperationFlags;
        } else if (i == stopAllHeavyOperations) {
            this.currentHeavyOperationFlags = ((Integer) objArr[0]).intValue() | this.currentHeavyOperationFlags;
        }
        postNotificationNameInternal(i, z, objArr);
        if (arrayList != null) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                onAnimationFinish(((Integer) arrayList.get(i4)).intValue());
            }
        }
    }

    public void postNotificationNameInternal(int i, boolean z, Object... objArr) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.NotificationCenter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationCenter.lambda$postNotificationNameInternal$2();
                }
            });
        }
        if (!z && isAnimationInProgress()) {
            this.delayedPosts.add(new DelayedPost(i, objArr));
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("delay post notification " + i + " with args count = " + objArr.length);
                return;
            }
            return;
        }
        if (!this.postponeCallbackList.isEmpty()) {
            for (int i2 = 0; i2 < this.postponeCallbackList.size(); i2++) {
                if (this.postponeCallbackList.get(i2).needPostpone(i, this.currentAccount, objArr)) {
                    this.delayedPosts.add(new DelayedPost(i, objArr));
                    return;
                }
            }
        }
        this.broadcasting++;
        ArrayList<NotificationCenterDelegate> arrayList = this.observers.get(i);
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList.get(i3).didReceivedNotification(i, this.currentAccount, objArr);
            }
        }
        int i4 = this.broadcasting - 1;
        this.broadcasting = i4;
        if (i4 == 0) {
            if (this.removeAfterBroadcast.size() != 0) {
                for (int i5 = 0; i5 < this.removeAfterBroadcast.size(); i5++) {
                    int iKeyAt = this.removeAfterBroadcast.keyAt(i5);
                    ArrayList<NotificationCenterDelegate> arrayList2 = this.removeAfterBroadcast.get(iKeyAt);
                    for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                        removeObserver(arrayList2.get(i6), iKeyAt);
                    }
                }
                this.removeAfterBroadcast.clear();
            }
            if (this.addAfterBroadcast.size() != 0) {
                for (int i7 = 0; i7 < this.addAfterBroadcast.size(); i7++) {
                    int iKeyAt2 = this.addAfterBroadcast.keyAt(i7);
                    ArrayList<NotificationCenterDelegate> arrayList3 = this.addAfterBroadcast.get(iKeyAt2);
                    for (int i8 = 0; i8 < arrayList3.size(); i8++) {
                        addObserver(arrayList3.get(i8), iKeyAt2);
                    }
                }
                this.addAfterBroadcast.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$postNotificationNameInternal$2() {
        throw new NotificationException("postNotificationName allowed only from MAIN thread");
    }

    public void addObserver(NotificationCenterDelegate notificationCenterDelegate, int i) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("addObserver allowed only from MAIN thread");
        }
        if (this.broadcasting != 0) {
            ArrayList<NotificationCenterDelegate> arrayList = this.addAfterBroadcast.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.addAfterBroadcast.put(i, arrayList);
            }
            arrayList.add(notificationCenterDelegate);
            return;
        }
        ArrayList<NotificationCenterDelegate> arrayList2 = this.observers.get(i);
        if (arrayList2 == null) {
            SparseArray<ArrayList<NotificationCenterDelegate>> sparseArray = this.observers;
            ArrayList<NotificationCenterDelegate> arrayList3 = new ArrayList<>();
            sparseArray.put(i, arrayList3);
            arrayList2 = arrayList3;
        }
        if (arrayList2.contains(notificationCenterDelegate)) {
            return;
        }
        arrayList2.add(notificationCenterDelegate);
    }

    public void removeObserver(NotificationCenterDelegate notificationCenterDelegate, int i) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("removeObserver allowed only from MAIN thread");
        }
        if (this.broadcasting != 0) {
            ArrayList<NotificationCenterDelegate> arrayList = this.removeAfterBroadcast.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.removeAfterBroadcast.put(i, arrayList);
            }
            arrayList.add(notificationCenterDelegate);
            return;
        }
        ArrayList<NotificationCenterDelegate> arrayList2 = this.observers.get(i);
        if (arrayList2 != null) {
            arrayList2.remove(notificationCenterDelegate);
        }
    }

    public boolean hasObservers(int i) {
        return this.observers.indexOfKey(i) >= 0;
    }

    public void addPostponeNotificationsCallback(PostponeNotificationCallback postponeNotificationCallback) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("PostponeNotificationsCallback allowed only from MAIN thread");
        }
        if (this.postponeCallbackList.contains(postponeNotificationCallback)) {
            return;
        }
        this.postponeCallbackList.add(postponeNotificationCallback);
    }

    public void removePostponeNotificationsCallback(PostponeNotificationCallback postponeNotificationCallback) {
        if (BuildVars.DEBUG_VERSION && Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            throw new RuntimeException("removePostponeNotificationsCallback allowed only from MAIN thread");
        }
        if (this.postponeCallbackList.remove(postponeNotificationCallback)) {
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

    private static class AllowedNotifications {
        int[] allowedIds;
        final long time;

        private AllowedNotifications() {
            this.time = SystemClock.elapsedRealtime();
        }
    }

    public void postNotificationNameOnUIThread(final int i, final Object... objArr) {
        Observable.just(1).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Integer>() { // from class: org.rbmain.messenger.NotificationCenter.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Integer num) throws Exception {
                NotificationCenter.this.postNotificationName(i, objArr);
            }
        }).subscribe();
    }
}
