package org.rbmain.messenger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.URLSpan;
import android.util.SparseArray;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.MyLog;
import androidx.collection.LongSparseArray;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.stetho.websocket.CloseCodes;
import ir.aaap.messengercore.model.ChatType;
import ir.resaneh1.iptv.model.Link;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.rbmain.SQLite.SQLiteCursor;
import org.rbmain.SQLite.SQLitePreparedStatement;
import org.rbmain.messenger.NotificationBadge;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInfo;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$DraftMessage;
import org.rbmain.tgnet.TLRPC$EmojiKeyword;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$Reaction;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$StickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_attachMenuBot;
import org.rbmain.tgnet.TLRPC$TL_attachMenuBotIcon;
import org.rbmain.tgnet.TLRPC$TL_availableReaction;
import org.rbmain.tgnet.TLRPC$TL_channels_getMessages;
import org.rbmain.tgnet.TLRPC$TL_contacts_getTopPeers;
import org.rbmain.tgnet.TLRPC$TL_contacts_resetTopPeerRating;
import org.rbmain.tgnet.TLRPC$TL_contacts_topPeers;
import org.rbmain.tgnet.TLRPC$TL_contacts_topPeersDisabled;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAnimated;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeSticker;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo;
import org.rbmain.tgnet.TLRPC$TL_documentEmpty;
import org.rbmain.tgnet.TLRPC$TL_draftMessage;
import org.rbmain.tgnet.TLRPC$TL_draftMessageEmpty;
import org.rbmain.tgnet.TLRPC$TL_emojiKeyword;
import org.rbmain.tgnet.TLRPC$TL_emojiKeywordDeleted;
import org.rbmain.tgnet.TLRPC$TL_emojiKeywordsDifference;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputDocument;
import org.rbmain.tgnet.TLRPC$TL_inputMessageEntityMentionName;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterDocument;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterGif;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterMusic;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterPhotoVideo;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterRoundVoice;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterUrl;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetDice;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetID;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetShortName;
import org.rbmain.tgnet.TLRPC$TL_message;
import org.rbmain.tgnet.TLRPC$TL_messageActionGameScore;
import org.rbmain.tgnet.TLRPC$TL_messageActionHistoryClear;
import org.rbmain.tgnet.TLRPC$TL_messageActionPaymentSent;
import org.rbmain.tgnet.TLRPC$TL_messageActionPinMessage;
import org.rbmain.tgnet.TLRPC$TL_messageEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageEntityBlockquote;
import org.rbmain.tgnet.TLRPC$TL_messageEntityBold;
import org.rbmain.tgnet.TLRPC$TL_messageEntityCode;
import org.rbmain.tgnet.TLRPC$TL_messageEntityCustomEmoji;
import org.rbmain.tgnet.TLRPC$TL_messageEntityEmail;
import org.rbmain.tgnet.TLRPC$TL_messageEntityItalic;
import org.rbmain.tgnet.TLRPC$TL_messageEntityMentionName;
import org.rbmain.tgnet.TLRPC$TL_messageEntityPre;
import org.rbmain.tgnet.TLRPC$TL_messageEntitySpoiler;
import org.rbmain.tgnet.TLRPC$TL_messageEntityStrike;
import org.rbmain.tgnet.TLRPC$TL_messageEntityTextUrl;
import org.rbmain.tgnet.TLRPC$TL_messageEntityUnderline;
import org.rbmain.tgnet.TLRPC$TL_messageEntityUrl;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_message_secret;
import org.rbmain.tgnet.TLRPC$TL_messages_allStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_archivedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_channelMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_faveSticker;
import org.rbmain.tgnet.TLRPC$TL_messages_featuredStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getArchivedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getAvailableReactions;
import org.rbmain.tgnet.TLRPC$TL_messages_getFavedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getFeaturedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_getRecentReactions;
import org.rbmain.tgnet.TLRPC$TL_messages_getRecentStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getSavedGifs;
import org.rbmain.tgnet.TLRPC$TL_messages_getSearchCounters;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getTopReactions;
import org.rbmain.tgnet.TLRPC$TL_messages_installStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_messagesSlice;
import org.rbmain.tgnet.TLRPC$TL_messages_reactions;
import org.rbmain.tgnet.TLRPC$TL_messages_reactionsNotModified;
import org.rbmain.tgnet.TLRPC$TL_messages_readFeaturedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_saveDraft;
import org.rbmain.tgnet.TLRPC$TL_messages_saveGif;
import org.rbmain.tgnet.TLRPC$TL_messages_saveRecentSticker;
import org.rbmain.tgnet.TLRPC$TL_messages_savedGifs;
import org.rbmain.tgnet.TLRPC$TL_messages_search;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSetInstallResultArchive;
import org.rbmain.tgnet.TLRPC$TL_messages_toggleStickerSets;
import org.rbmain.tgnet.TLRPC$TL_messages_uninstallStickerSet;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_stickerPack;
import org.rbmain.tgnet.TLRPC$TL_topPeer;
import org.rbmain.tgnet.TLRPC$TL_topPeerCategoryBotsInline;
import org.rbmain.tgnet.TLRPC$TL_topPeerCategoryCorrespondents;
import org.rbmain.tgnet.TLRPC$TL_topPeerCategoryPeers;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.AnimatedEmojiSpan;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.StickerSetBulletinLayout;
import org.rbmain.ui.Components.StickersArchiveAlert;
import org.rbmain.ui.Components.TextStyleSpan;
import org.rbmain.ui.Components.URLSpanReplacement;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes4.dex */
public class MediaDataController extends BaseController {
    public static final String ATTACH_MENU_BOT_ANIMATED_ICON_KEY = "android_animated";
    public static final String ATTACH_MENU_BOT_COLOR_DARK_ICON = "dark_icon";
    public static final String ATTACH_MENU_BOT_COLOR_DARK_TEXT = "dark_text";
    public static final String ATTACH_MENU_BOT_COLOR_LIGHT_ICON = "light_icon";
    public static final String ATTACH_MENU_BOT_COLOR_LIGHT_TEXT = "light_text";
    public static final String ATTACH_MENU_BOT_PLACEHOLDER_STATIC_KEY = "placeholder_static";
    public static final String ATTACH_MENU_BOT_STATIC_ICON_KEY = "default_static";
    public static final int MEDIA_AUDIO = 2;
    public static final int MEDIA_FILE = 1;
    public static final int MEDIA_GIF = 5;
    public static final int MEDIA_MUSIC = 4;
    public static final int MEDIA_PHOTOVIDEO = 0;
    public static final int MEDIA_TYPES_COUNT = 6;
    public static final int MEDIA_URL = 3;
    public static String SHORTCUT_CATEGORY = "ir.resaneh1.iptv.SHORTCUT_SHARE";
    public static final int TYPE_EMOJI = 4;
    public static final int TYPE_EMOJIPACKS = 5;
    public static final int TYPE_FAVE = 2;
    public static final int TYPE_FEATURED = 3;
    public static final int TYPE_FEATURED_EMOJIPACKS = 6;
    public static final int TYPE_GREETINGS = 3;
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_MASK = 1;
    public static final int TYPE_PREMIUM_STICKERS = 7;
    private static RectF bitmapRect;
    private static Paint erasePaint;
    private static Paint roundPaint;
    private static Path roundPath;
    private HashMap<String, ArrayList<TLRPC$Document>> allStickers;
    private HashMap<String, ArrayList<TLRPC$Document>> allStickersFeatured;
    private int[] archivedStickersCount;
    private SparseArray<TLRPC$BotInfo> botInfos;
    private LongSparseArray<TLRPC$Message> botKeyboards;
    private LongSparseArray<Long> botKeyboardsByMids;
    private HashMap<String, Boolean> currentFetchingEmoji;
    private LongSparseArray<String> diceEmojiStickerSetsById;
    private HashMap<String, TLRPC$TL_messages_stickerSet> diceStickerSetsByEmoji;
    private String doubleTapReaction;
    private LongSparseArray<LongSparseArray<TLRPC$Message>> draftMessages;
    private SharedPreferences draftPreferences;
    private LongSparseArray<LongSparseArray<TLRPC$DraftMessage>> drafts;
    private LongSparseArray<Integer> draftsFolderIds;
    private List<TLRPC$TL_availableReaction> enabledReactionsList;
    private ArrayList<TLRPC$StickerSetCovered> featuredStickerSets;
    private LongSparseArray<TLRPC$StickerSetCovered> featuredStickerSetsById;
    private boolean featuredStickersLoaded;
    private TLRPC$Document greetingsSticker;
    private LongSparseArray<TLRPC$TL_messages_stickerSet> groupStickerSets;
    private boolean hasContinue;
    public ArrayList<TLRPC$TL_topPeer> hints;
    private boolean inTransaction;
    public ArrayList<TLRPC$TL_topPeer> inlineBots;
    private LongSparseArray<TLRPC$TL_messages_stickerSet> installedStickerSetsById;
    private boolean isLoadingReactions;
    private long lastDialogId;
    private int lastGuid;
    private long lastMergeDialogId;
    private long lastReplyMessageId;
    private int lastReqId;
    private int lastReturnedNum;
    private TLRPC$Chat lastSearchChat;
    private String lastSearchQuery;
    private TLRPC$User lastSearchUser;
    private int[] loadDate;
    private int loadFeaturedDate;
    private int loadFeaturedHash;
    private int[] loadHash;
    boolean loaded;
    boolean loading;
    private HashSet<String> loadingDiceStickerSets;
    private boolean loadingDrafts;
    private boolean loadingFeaturedStickers;
    private boolean loadingMoreSearchMessages;
    private LongSparseArray<Boolean> loadingPinnedMessages;
    private boolean loadingRecentGifs;
    boolean loadingRecentReactions;
    private boolean[] loadingRecentStickers;
    private boolean[] loadingStickers;
    private boolean localDraftsLoaded;
    private int mergeReqId;
    private int[] messagesSearchCount;
    private boolean[] messagesSearchEndReached;
    private String nextStartId;
    private boolean reactionsCacheGenerated;
    private List<TLRPC$TL_availableReaction> reactionsList;
    private HashMap<String, TLRPC$TL_availableReaction> reactionsMap;
    private int reactionsUpdateDate;
    private int reactionsUpdateHash;
    private ArrayList<Long> readingStickerSets;
    private ArrayList<TLRPC$Document> recentGifs;
    private boolean recentGifsLoaded;
    ArrayList<TLRPC$Reaction> recentReactions;
    private ArrayList<TLRPC$Document>[] recentStickers;
    private boolean[] recentStickersLoaded;
    private LongSparseArray<Runnable> removingStickerSetsUndos;
    private int reqId;
    private Runnable[] scheduledLoadStickers;
    private ArrayList<MessageObject> searchResultMessages;
    private LongSparseArray<MessageObject>[] searchResultMessagesMap;
    private ArrayList<TLRPC$TL_messages_stickerSet>[] stickerSets;
    private LongSparseArray<TLRPC$TL_messages_stickerSet> stickerSetsById;
    private ConcurrentHashMap<String, TLRPC$TL_messages_stickerSet> stickerSetsByName;
    private LongSparseArray<String> stickersByEmoji;
    private LongSparseArray<TLRPC$Document>[] stickersByIds;
    private boolean[] stickersLoaded;
    ArrayList<TLRPC$Reaction> topReactions;
    private ArrayList<Long> unreadStickerSets;
    private HashMap<String, ArrayList<TLRPC$Message>> verifyingMessages;
    private static Pattern BOLD_PATTERN = Pattern.compile("\\*\\*(.+?)\\*\\*");
    private static Pattern ITALIC_PATTERN = Pattern.compile("__(.+?)__");
    private static Pattern SPOILER_PATTERN = Pattern.compile("\\|\\|(.+?)\\|\\|");
    private static Pattern STRIKE_PATTERN = Pattern.compile("~~(.+?)~~");
    private static volatile MediaDataController[] Instance = new MediaDataController[3];
    private static Comparator<TLRPC$MessageEntity> entityComparator = new Comparator() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda90
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return MediaDataController.lambda$static$85((TLRPC$MessageEntity) obj, (TLRPC$MessageEntity) obj2);
        }
    };

    public static class KeywordResult {
        public String emoji;
        public String keyword;
    }

    public interface KeywordResultCallback {
        void run(ArrayList<KeywordResult> arrayList, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadReactions$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$markFaturedStickersAsRead$28(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$markFaturedStickersByIdAsRead$29(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removeInline$81(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removePeer$82(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveDraft$104(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public TLRPC$TL_messages_stickerSet getStickerSet(TLRPC$InputStickerSet tLRPC$InputStickerSet, Integer num, boolean z, Utilities.Callback16<TLRPC$TL_messages_stickerSet> callback16) {
        return null;
    }

    public void increasePeerRaiting(long j) {
    }

    public void loadPinnedMessages(long j, long j2, long j3) {
    }

    public boolean saveToRingtones(TLRPC$Document tLRPC$Document) {
        return tLRPC$Document != null;
    }

    public static MediaDataController getInstance(int i) {
        MediaDataController mediaDataController = Instance[i];
        if (mediaDataController == null) {
            synchronized (MediaDataController.class) {
                mediaDataController = Instance[i];
                if (mediaDataController == null) {
                    MediaDataController[] mediaDataControllerArr = Instance;
                    MediaDataController mediaDataController2 = new MediaDataController(i);
                    mediaDataControllerArr[i] = mediaDataController2;
                    mediaDataController = mediaDataController2;
                }
            }
        }
        return mediaDataController;
    }

    public MediaDataController(int i) {
        super(i);
        this.stickerSets = new ArrayList[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>(0), new ArrayList<>(), new ArrayList<>()};
        this.stickersByIds = new LongSparseArray[]{new LongSparseArray<>(), new LongSparseArray<>(), new LongSparseArray<>(), new LongSparseArray<>(), new LongSparseArray<>()};
        this.stickerSetsById = new LongSparseArray<>();
        this.installedStickerSetsById = new LongSparseArray<>();
        this.groupStickerSets = new LongSparseArray<>();
        this.stickerSetsByName = new ConcurrentHashMap<>(100, 1.0f, 1);
        this.diceStickerSetsByEmoji = new HashMap<>();
        this.diceEmojiStickerSetsById = new LongSparseArray<>();
        this.loadingDiceStickerSets = new HashSet<>();
        this.removingStickerSetsUndos = new LongSparseArray<>();
        this.scheduledLoadStickers = new Runnable[7];
        this.loadingStickers = new boolean[7];
        this.stickersLoaded = new boolean[7];
        this.loadHash = new int[7];
        this.loadDate = new int[7];
        this.verifyingMessages = new HashMap<>();
        this.archivedStickersCount = new int[7];
        this.stickersByEmoji = new LongSparseArray<>();
        this.allStickers = new HashMap<>();
        this.allStickersFeatured = new HashMap<>();
        this.recentStickers = new ArrayList[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()};
        this.loadingRecentStickers = new boolean[9];
        this.recentStickersLoaded = new boolean[9];
        this.recentGifs = new ArrayList<>();
        this.hasContinue = true;
        this.featuredStickerSets = new ArrayList<>();
        this.featuredStickerSetsById = new LongSparseArray<>();
        this.unreadStickerSets = new ArrayList<>();
        this.readingStickerSets = new ArrayList<>();
        this.reactionsList = new ArrayList();
        this.enabledReactionsList = new ArrayList();
        this.reactionsMap = new HashMap<>();
        this.messagesSearchCount = new int[]{0, 0};
        this.messagesSearchEndReached = new boolean[]{false, false};
        this.searchResultMessages = new ArrayList<>();
        this.searchResultMessagesMap = new LongSparseArray[]{new LongSparseArray<>(), new LongSparseArray<>()};
        this.hints = new ArrayList<>();
        this.inlineBots = new ArrayList<>();
        this.loadingPinnedMessages = new LongSparseArray<>();
        this.draftsFolderIds = new LongSparseArray<>();
        this.drafts = new LongSparseArray<>();
        this.draftMessages = new LongSparseArray<>();
        this.botInfos = new SparseArray<>();
        this.botKeyboards = new LongSparseArray<>();
        this.botKeyboardsByMids = new LongSparseArray<>();
        this.currentFetchingEmoji = new HashMap<>();
        this.recentReactions = new ArrayList<>();
        this.topReactions = new ArrayList<>();
        if (this.currentAccount == 0) {
            this.draftPreferences = ApplicationLoader.applicationContext.getSharedPreferences("drafts", 0);
        } else {
            this.draftPreferences = ApplicationLoader.applicationContext.getSharedPreferences("drafts" + this.currentAccount, 0);
        }
        loadLocalDraftsIfNeeded();
        loadRecentAndTopReactions(false);
    }

    public void loadLocalDraftsIfNeeded() {
        long jGenerateDialogId;
        if (!getCoreMainClass().isChatListInited() || this.localDraftsLoaded) {
            return;
        }
        for (Map.Entry<String, ?> entry : this.draftPreferences.getAll().entrySet()) {
            try {
                String key = entry.getKey();
                if (getCoreMainClass().isGroupChannel(key)) {
                    jGenerateDialogId = IdStorage.getInstance().generateNegativeDialogId(key);
                } else {
                    jGenerateDialogId = IdStorage.getInstance().generateDialogId(key);
                }
                SerializedData serializedData = new SerializedData(Utilities.hexToBytes((String) entry.getValue()));
                boolean zStartsWith = false;
                if (key.startsWith("r_") || (zStartsWith = key.startsWith("rt_"))) {
                    TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(serializedData, serializedData.readInt32(true), true);
                    if (tLRPC$MessageTLdeserialize != null) {
                        tLRPC$MessageTLdeserialize.readAttachPath(serializedData, getUserConfig().clientUserId);
                        LongSparseArray<TLRPC$Message> longSparseArray = this.draftMessages.get(jGenerateDialogId);
                        if (longSparseArray == null) {
                            longSparseArray = new LongSparseArray<>();
                            this.draftMessages.put(jGenerateDialogId, longSparseArray);
                        }
                        longSparseArray.put(zStartsWith ? Utilities.parseInt(key.substring(key.lastIndexOf(95) + 1)).intValue() : 0L, tLRPC$MessageTLdeserialize);
                    }
                } else {
                    TLRPC$DraftMessage tLRPC$DraftMessageTLdeserialize = TLRPC$DraftMessage.TLdeserialize(serializedData, serializedData.readInt32(true), true);
                    if (tLRPC$DraftMessageTLdeserialize != null) {
                        LongSparseArray<TLRPC$DraftMessage> longSparseArray2 = this.drafts.get(jGenerateDialogId);
                        if (longSparseArray2 == null) {
                            longSparseArray2 = new LongSparseArray<>();
                            this.drafts.put(jGenerateDialogId, longSparseArray2);
                        }
                        longSparseArray2.put(key.startsWith("t_") ? Utilities.parseInt(key.substring(key.lastIndexOf(95) + 1)).intValue() : 0L, tLRPC$DraftMessageTLdeserialize);
                    }
                }
                serializedData.cleanup();
            } catch (Exception unused) {
            }
        }
        this.localDraftsLoaded = true;
    }

    public void cleanup() {
        int i = 0;
        while (true) {
            ArrayList<TLRPC$Document>[] arrayListArr = this.recentStickers;
            if (i >= arrayListArr.length) {
                break;
            }
            arrayListArr[i].clear();
            this.loadingRecentStickers[i] = false;
            this.recentStickersLoaded[i] = false;
            i++;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.loadHash[i2] = 0;
            this.loadDate[i2] = 0;
            this.stickerSets[i2].clear();
            this.loadingStickers[i2] = false;
            this.stickersLoaded[i2] = false;
        }
        this.featuredStickerSets.clear();
        this.loadingPinnedMessages.clear();
        this.loadFeaturedDate = 0;
        this.loadFeaturedHash = 0;
        this.nextStartId = null;
        this.hasContinue = true;
        this.allStickers.clear();
        this.allStickersFeatured.clear();
        this.stickersByEmoji.clear();
        this.featuredStickerSetsById.clear();
        this.featuredStickerSets.clear();
        this.unreadStickerSets.clear();
        this.recentGifs.clear();
        this.stickerSetsById.clear();
        this.installedStickerSetsById.clear();
        this.stickerSetsByName.clear();
        this.diceStickerSetsByEmoji.clear();
        this.diceEmojiStickerSetsById.clear();
        this.loadingDiceStickerSets.clear();
        this.loadingFeaturedStickers = false;
        this.featuredStickersLoaded = false;
        this.loadingRecentGifs = false;
        this.recentGifsLoaded = false;
        this.currentFetchingEmoji.clear();
        if (Build.VERSION.SDK_INT >= 25) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda85
                @Override // java.lang.Runnable
                public final void run() {
                    MediaDataController.lambda$cleanup$0();
                }
            });
        }
        this.verifyingMessages.clear();
        this.loading = false;
        this.loaded = false;
        this.hints.clear();
        this.inlineBots.clear();
        getNotificationCenter().postNotificationName(NotificationCenter.reloadHints, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.reloadInlineHints, new Object[0]);
        this.drafts.clear();
        this.draftMessages.clear();
        this.draftPreferences.edit().clear().apply();
        this.botInfos.clear();
        this.botKeyboards.clear();
        this.botKeyboardsByMids.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cleanup$0() {
        try {
            ShortcutManagerCompat.removeAllDynamicShortcuts(ApplicationLoader.applicationContext);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void checkStickers(int i) {
        if (this.loadingStickers[i]) {
            return;
        }
        if (!this.stickersLoaded[i] || Math.abs((System.currentTimeMillis() / 1000) - this.loadDate[i]) >= 3600) {
            loadStickers(i, true, false);
        }
    }

    public void checkReactions() {
        if (this.isLoadingReactions) {
            return;
        }
        loadReactions(true, false);
    }

    public List<TLRPC$TL_availableReaction> getReactionsList() {
        return this.reactionsList;
    }

    public void loadReactions(boolean z, boolean z2) {
        this.isLoadingReactions = true;
        TLRPC$TL_messages_getAvailableReactions tLRPC$TL_messages_getAvailableReactions = new TLRPC$TL_messages_getAvailableReactions();
        tLRPC$TL_messages_getAvailableReactions.hash = z2 ? 0 : this.reactionsUpdateHash;
        getContactsProxy().getAvailableReactions(tLRPC$TL_messages_getAvailableReactions, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda124
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MediaDataController.lambda$loadReactions$2(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadReactions$2(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda86
            @Override // java.lang.Runnable
            public final void run() {
                MediaDataController.lambda$loadReactions$1();
            }
        });
    }

    public void processLoadedReactions(List<TLRPC$TL_availableReaction> list, int i, int i2, boolean z) {
        if (list != null && i2 != 0) {
            this.reactionsList.clear();
            this.reactionsMap.clear();
            this.enabledReactionsList.clear();
            this.reactionsList.addAll(list);
            for (int i3 = 0; i3 < this.reactionsList.size(); i3++) {
                this.reactionsList.get(i3).positionInList = i3;
                this.reactionsMap.put(this.reactionsList.get(i3).reaction, this.reactionsList.get(i3));
                if (!this.reactionsList.get(i3).inactive) {
                    this.enabledReactionsList.add(this.reactionsList.get(i3));
                }
            }
            this.reactionsUpdateHash = i;
        }
        this.reactionsUpdateDate = i2;
        if (list != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedReactions$3();
                }
            });
        }
        this.isLoadingReactions = false;
        if (!z) {
            putReactionsToCache(list, i, i2);
        } else {
            Math.abs((System.currentTimeMillis() / 1000) - i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedReactions$3() {
        preloadDefaultReactions();
        getNotificationCenter().postNotificationName(NotificationCenter.reactionsDidLoad, new Object[0]);
    }

    public void preloadDefaultReactions() {
        if (this.reactionsList == null || this.reactionsCacheGenerated || !LiteMode.isEnabled(LiteMode.FLAG_ANIMATED_EMOJI_REACTIONS) || this.currentAccount != UserConfig.selectedAccount) {
            return;
        }
        this.reactionsCacheGenerated = true;
        ArrayList arrayList = new ArrayList(this.reactionsList);
        int iMin = Math.min(arrayList.size(), 10);
        for (int i = 0; i < iMin; i++) {
            TLRPC$TL_availableReaction tLRPC$TL_availableReaction = (TLRPC$TL_availableReaction) arrayList.get(i);
            preloadImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.activate_animation));
            preloadImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.appear_animation));
        }
        for (int i2 = 0; i2 < iMin; i2++) {
            preloadImage(ImageLocation.getForDocument(((TLRPC$TL_availableReaction) arrayList.get(i2)).effect_animation));
        }
    }

    private void preloadImage(ImageLocation imageLocation) {
        getFileLoader().loadFile(imageLocation, null, null, 0, 11);
    }

    public void preloadImage(ImageReceiver imageReceiver, ImageLocation imageLocation, String str) {
        if (LiteMode.isEnabled(LiteMode.FLAG_ANIMATED_EMOJI_REACTIONS)) {
            imageReceiver.setUniqKeyPrefix("preload");
            imageReceiver.setFileLoadingPriority(0);
            imageReceiver.setImage(imageLocation, str, null, null, 0, 11);
        }
    }

    private void putReactionsToCache(List<TLRPC$TL_availableReaction> list, final int i, final int i2) {
        final ArrayList arrayList = list != null ? new ArrayList(list) : null;
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putReactionsToCache$4(arrayList, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putReactionsToCache$4(ArrayList arrayList, int i, int i2) {
        try {
            if (arrayList != null) {
                getMessagesStorage().getDatabase().executeFast("DELETE FROM reactions").stepThis().dispose();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO reactions VALUES(?, ?, ?)");
                sQLitePreparedStatementExecuteFast.requery();
                int objectSize = 4;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    objectSize += ((TLRPC$TL_availableReaction) arrayList.get(i3)).getObjectSize();
                }
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(objectSize);
                nativeByteBuffer.writeInt32(arrayList.size());
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    ((TLRPC$TL_availableReaction) arrayList.get(i4)).serializeToStream(nativeByteBuffer);
                }
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(2, i);
                sQLitePreparedStatementExecuteFast.bindInteger(3, i2);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
                sQLitePreparedStatementExecuteFast.dispose();
                return;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = getMessagesStorage().getDatabase().executeFast("UPDATE reactions SET date = ?");
            sQLitePreparedStatementExecuteFast2.requery();
            sQLitePreparedStatementExecuteFast2.bindLong(1, i2);
            sQLitePreparedStatementExecuteFast2.step();
            sQLitePreparedStatementExecuteFast2.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void checkFeaturedStickers() {
        checkFeaturedStickers(false);
    }

    public void checkFeaturedStickers(boolean z) {
        loadFeaturedStickers(true, false, z);
    }

    public ArrayList<TLRPC$Document> getRecentStickers(int i) {
        ArrayList<TLRPC$Document> arrayList = this.recentStickers[i];
        return new ArrayList<>(arrayList.subList(0, Math.min(arrayList.size(), 20)));
    }

    public ArrayList<TLRPC$Document> getRecentStickersNoCopy(int i) {
        return this.recentStickers[i];
    }

    public boolean isStickerInFavorites(TLRPC$Document tLRPC$Document) {
        if (tLRPC$Document == null) {
            return false;
        }
        for (int i = 0; i < this.recentStickers[2].size(); i++) {
            TLRPC$Document tLRPC$Document2 = this.recentStickers[2].get(i);
            if (tLRPC$Document2.id == tLRPC$Document.id && tLRPC$Document2.dc_id == tLRPC$Document.dc_id) {
                return true;
            }
        }
        return false;
    }

    public void addRecentSticker(final int i, final Object obj, TLRPC$Document tLRPC$Document, int i2, boolean z) {
        boolean z2;
        int i3;
        final TLRPC$Document tLRPC$DocumentRemove;
        if (i != 3) {
            if (MessageObject.isStickerDocument(tLRPC$Document) || MessageObject.isAnimatedStickerDocument(tLRPC$Document, true)) {
                int i4 = 0;
                while (true) {
                    if (i4 >= this.recentStickers[i].size()) {
                        z2 = false;
                        break;
                    }
                    TLRPC$Document tLRPC$Document2 = this.recentStickers[i].get(i4);
                    if (tLRPC$Document2.id == tLRPC$Document.id) {
                        this.recentStickers[i].remove(i4);
                        if (!z) {
                            this.recentStickers[i].add(0, tLRPC$Document2);
                        }
                        z2 = true;
                    } else {
                        i4++;
                    }
                }
                if (!z2 && !z) {
                    this.recentStickers[i].add(0, tLRPC$Document);
                }
                if (i == 2) {
                    if (z) {
                        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 0, tLRPC$Document, 4);
                    } else {
                        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 0, tLRPC$Document, 5);
                    }
                    final TLRPC$TL_messages_faveSticker tLRPC$TL_messages_faveSticker = new TLRPC$TL_messages_faveSticker();
                    TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
                    tLRPC$TL_messages_faveSticker.id = tLRPC$TL_inputDocument;
                    tLRPC$TL_inputDocument.id = tLRPC$Document.id;
                    tLRPC$TL_inputDocument.access_hash = tLRPC$Document.access_hash;
                    byte[] bArr = tLRPC$Document.file_reference;
                    tLRPC$TL_inputDocument.file_reference = bArr;
                    if (bArr == null) {
                        tLRPC$TL_inputDocument.file_reference = new byte[0];
                    }
                    tLRPC$TL_messages_faveSticker.unfave = z;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_faveSticker, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda112
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$addRecentSticker$6(obj, tLRPC$TL_messages_faveSticker, tLObject, tLRPC$TL_error);
                        }
                    });
                    i3 = getMessagesController().maxFaveStickersCount;
                } else {
                    if (i == 0 && z) {
                        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 0, tLRPC$Document, 3);
                        final TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker = new TLRPC$TL_messages_saveRecentSticker();
                        TLRPC$TL_inputDocument tLRPC$TL_inputDocument2 = new TLRPC$TL_inputDocument();
                        tLRPC$TL_messages_saveRecentSticker.id = tLRPC$TL_inputDocument2;
                        tLRPC$TL_inputDocument2.id = tLRPC$Document.id;
                        tLRPC$TL_inputDocument2.access_hash = tLRPC$Document.access_hash;
                        byte[] bArr2 = tLRPC$Document.file_reference;
                        tLRPC$TL_inputDocument2.file_reference = bArr2;
                        if (bArr2 == null) {
                            tLRPC$TL_inputDocument2.file_reference = new byte[0];
                        }
                        tLRPC$TL_messages_saveRecentSticker.unsave = true;
                        getConnectionsManager().sendRequest(tLRPC$TL_messages_saveRecentSticker, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda113
                            @Override // org.rbmain.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$addRecentSticker$7(obj, tLRPC$TL_messages_saveRecentSticker, tLObject, tLRPC$TL_error);
                            }
                        });
                    }
                    i3 = getMessagesController().maxRecentStickersCount;
                }
                if (this.recentStickers[i].size() > i3 || z) {
                    if (z) {
                        tLRPC$DocumentRemove = tLRPC$Document;
                    } else {
                        ArrayList<TLRPC$Document>[] arrayListArr = this.recentStickers;
                        tLRPC$DocumentRemove = arrayListArr[i].remove(arrayListArr[i].size() - 1);
                    }
                    getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda17
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$addRecentSticker$8(i, tLRPC$DocumentRemove);
                        }
                    });
                }
                if (!z) {
                    ArrayList<TLRPC$Document> arrayList = new ArrayList<>();
                    arrayList.add(tLRPC$Document);
                    processLoadedRecentDocuments(i, arrayList, false, i2, false);
                }
                if (i == 2 || (i == 0 && z)) {
                    getNotificationCenter().postNotificationName(NotificationCenter.recentDocumentsDidLoad, Boolean.FALSE, Integer.valueOf(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecentSticker$6(Object obj, TLRPC$TL_messages_faveSticker tLRPC$TL_messages_faveSticker, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null && FileRefController.isFileRefError(tLRPC$TL_error.text) && obj != null) {
            getFileRefController().requestReference(obj, tLRPC$TL_messages_faveSticker);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addRecentSticker$5();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecentSticker$5() {
        getMediaDataController().loadRecents(2, false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecentSticker$7(Object obj, TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || !FileRefController.isFileRefError(tLRPC$TL_error.text) || obj == null) {
            return;
        }
        getFileRefController().requestReference(obj, tLRPC$TL_messages_saveRecentSticker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecentSticker$8(int i, TLRPC$Document tLRPC$Document) {
        getMessagesProxy().removeRecentOrFavoriteSticker(tLRPC$Document, i);
    }

    public ArrayList<TLRPC$Document> getRecentGifs() {
        return new ArrayList<>(this.recentGifs);
    }

    public void removeRecentGif(TLRPC$Document tLRPC$Document) {
        int size = this.recentGifs.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (this.recentGifs.get(i).id == tLRPC$Document.id) {
                this.recentGifs.remove(i);
                break;
            }
            i++;
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
        tLRPC$TL_messages_saveGif.unsave = true;
        getMessagesProxy().removeRecentGif(tLRPC$TL_messages_saveGif, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda119
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$removeRecentGif$9(tLRPC$TL_messages_saveGif, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeRecentGif$9(TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || !FileRefController.isFileRefError(tLRPC$TL_error.text)) {
            return;
        }
        getFileRefController().requestReference("gif", tLRPC$TL_messages_saveGif);
    }

    public boolean hasRecentGif(TLRPC$Document tLRPC$Document) {
        for (int i = 0; i < this.recentGifs.size(); i++) {
            TLRPC$Document tLRPC$Document2 = this.recentGifs.get(i);
            if (tLRPC$Document2.id == tLRPC$Document.id) {
                this.recentGifs.remove(i);
                this.recentGifs.add(0, tLRPC$Document2);
                return true;
            }
        }
        return false;
    }

    public void addRecentGif(TLRPC$Document tLRPC$Document, int i) {
        addRecentGif(tLRPC$Document, i, false);
    }

    public void addRecentGif(TLRPC$Document tLRPC$Document, int i, boolean z) {
        boolean z2;
        if (tLRPC$Document == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.recentGifs.size()) {
                z2 = false;
                break;
            }
            TLRPC$Document tLRPC$Document2 = this.recentGifs.get(i2);
            if (tLRPC$Document2.id == tLRPC$Document.id) {
                this.recentGifs.remove(i2);
                this.recentGifs.add(0, tLRPC$Document2);
                z2 = true;
                break;
            }
            i2++;
        }
        if (!z2) {
            this.recentGifs.add(0, tLRPC$Document);
        }
        if (this.recentGifs.size() > getMessagesController().maxRecentGifsCount) {
            ArrayList<TLRPC$Document> arrayList = this.recentGifs;
            final TLRPC$Document tLRPC$DocumentRemove = arrayList.remove(arrayList.size() - 1);
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda61
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addRecentGif$10(tLRPC$DocumentRemove);
                }
            });
        }
        ArrayList<TLRPC$Document> arrayList2 = new ArrayList<>();
        arrayList2.add(tLRPC$Document);
        processLoadedRecentDocuments(0, arrayList2, true, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecentGif$10(TLRPC$Document tLRPC$Document) {
        try {
            getMessagesStorage().getDatabase().executeFast("DELETE FROM web_recent_v3 WHERE id = '" + tLRPC$Document.id + "' AND type = 2").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public boolean isLoadingStickers(int i) {
        return this.loadingStickers[i];
    }

    public void replaceStickerSet(final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2 = this.stickerSetsById.get(tLRPC$TL_messages_stickerSet.set.id);
        String str = this.diceEmojiStickerSetsById.get(tLRPC$TL_messages_stickerSet.set.id);
        if (str != null) {
            this.diceStickerSetsByEmoji.put(str, tLRPC$TL_messages_stickerSet);
            putDiceStickersToCache(str, tLRPC$TL_messages_stickerSet, (int) (System.currentTimeMillis() / 1000));
        }
        if (tLRPC$TL_messages_stickerSet2 == null) {
            tLRPC$TL_messages_stickerSet2 = this.stickerSetsByName.get(tLRPC$TL_messages_stickerSet.set.short_name);
        }
        boolean z = true;
        boolean z2 = tLRPC$TL_messages_stickerSet2 == null && (tLRPC$TL_messages_stickerSet2 = this.groupStickerSets.get(tLRPC$TL_messages_stickerSet.set.id)) != null;
        if (tLRPC$TL_messages_stickerSet2 == null) {
            return;
        }
        if ("AnimatedEmojies".equals(tLRPC$TL_messages_stickerSet.set.short_name)) {
            tLRPC$TL_messages_stickerSet2.documents = tLRPC$TL_messages_stickerSet.documents;
            tLRPC$TL_messages_stickerSet2.packs = tLRPC$TL_messages_stickerSet.packs;
            tLRPC$TL_messages_stickerSet2.set = tLRPC$TL_messages_stickerSet.set;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda73
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$replaceStickerSet$11(tLRPC$TL_messages_stickerSet);
                }
            });
        } else {
            LongSparseArray longSparseArray = new LongSparseArray();
            int size = tLRPC$TL_messages_stickerSet.documents.size();
            for (int i = 0; i < size; i++) {
                TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i);
                longSparseArray.put(tLRPC$Document.id, tLRPC$Document);
            }
            int size2 = tLRPC$TL_messages_stickerSet2.documents.size();
            boolean z3 = false;
            for (int i2 = 0; i2 < size2; i2++) {
                TLRPC$Document tLRPC$Document2 = (TLRPC$Document) longSparseArray.get(tLRPC$TL_messages_stickerSet2.documents.get(i2).id);
                if (tLRPC$Document2 != null) {
                    tLRPC$TL_messages_stickerSet2.documents.set(i2, tLRPC$Document2);
                    z3 = true;
                }
            }
            z = z3;
        }
        if (z) {
            if (z2) {
                putSetToCache(tLRPC$TL_messages_stickerSet2);
                return;
            }
            boolean z4 = tLRPC$TL_messages_stickerSet.set.masks;
            putStickersToCache(z4 ? 1 : 0, this.stickerSets[z4 ? 1 : 0], this.loadDate[z4 ? 1 : 0], this.loadHash[z4 ? 1 : 0]);
            if ("AnimatedEmojies".equals(tLRPC$TL_messages_stickerSet.set.short_name)) {
                putStickersToCache(4, this.stickerSets[4], this.loadDate[4], this.loadHash[4]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$replaceStickerSet$11(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        LongSparseArray<TLRPC$Document> stickerByIds = getStickerByIds(4);
        for (int i = 0; i < tLRPC$TL_messages_stickerSet.documents.size(); i++) {
            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i);
            stickerByIds.put(tLRPC$Document.id, tLRPC$Document);
        }
    }

    public TLRPC$TL_messages_stickerSet getStickerSetByName(String str) {
        return this.stickerSetsByName.get(str);
    }

    public TLRPC$TL_messages_stickerSet getStickerSetByEmojiOrName(String str) {
        return this.diceStickerSetsByEmoji.get(str);
    }

    public TLRPC$TL_messages_stickerSet getStickerSetById(long j) {
        return this.stickerSetsById.get(j);
    }

    public TLRPC$TL_messages_stickerSet getGroupStickerSetById(TLRPC$StickerSet tLRPC$StickerSet) {
        TLRPC$StickerSet tLRPC$StickerSet2;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSetsById.get(tLRPC$StickerSet.id);
        if (tLRPC$TL_messages_stickerSet == null) {
            tLRPC$TL_messages_stickerSet = this.groupStickerSets.get(tLRPC$StickerSet.id);
            if (tLRPC$TL_messages_stickerSet == null || (tLRPC$StickerSet2 = tLRPC$TL_messages_stickerSet.set) == null) {
                loadGroupStickerSet(tLRPC$StickerSet, true);
            } else if (tLRPC$StickerSet2.hash != tLRPC$StickerSet.hash) {
                loadGroupStickerSet(tLRPC$StickerSet, false);
            }
        }
        return tLRPC$TL_messages_stickerSet;
    }

    public void putGroupStickerSet(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        this.groupStickerSets.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
    }

    private void loadGroupStickerSet(final TLRPC$StickerSet tLRPC$StickerSet, boolean z) {
        if (z) {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda63
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadGroupStickerSet$13(tLRPC$StickerSet);
                }
            });
            return;
        }
        TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
        TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
        tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetID;
        tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
        tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda96
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadGroupStickerSet$15(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGroupStickerSet$13(TLRPC$StickerSet tLRPC$StickerSet) {
        TLRPC$StickerSet tLRPC$StickerSet2;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized("SELECT document FROM web_recent_v3 WHERE id = 's_" + tLRPC$StickerSet.id + "'", new Object[0]);
            final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSetTLdeserialize = null;
            if (sQLiteCursorQueryFinalized.next() && !sQLiteCursorQueryFinalized.isNull(0) && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$TL_messages_stickerSetTLdeserialize = TLRPC$TL_messages_stickerSet.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$TL_messages_stickerSetTLdeserialize == null || (tLRPC$StickerSet2 = tLRPC$TL_messages_stickerSetTLdeserialize.set) == null || tLRPC$StickerSet2.hash != tLRPC$StickerSet.hash) {
                loadGroupStickerSet(tLRPC$StickerSet, false);
            }
            if (tLRPC$TL_messages_stickerSetTLdeserialize == null || tLRPC$TL_messages_stickerSetTLdeserialize.set == null) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadGroupStickerSet$12(tLRPC$TL_messages_stickerSetTLdeserialize);
                }
            });
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGroupStickerSet$12(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        this.groupStickerSets.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
        getNotificationCenter().postNotificationName(NotificationCenter.groupStickersDidLoad, Long.valueOf(tLRPC$TL_messages_stickerSet.set.id));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGroupStickerSet$15(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda71
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadGroupStickerSet$14(tLRPC$TL_messages_stickerSet);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGroupStickerSet$14(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        this.groupStickerSets.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
        getNotificationCenter().postNotificationName(NotificationCenter.groupStickersDidLoad, Long.valueOf(tLRPC$TL_messages_stickerSet.set.id));
    }

    private void putSetToCache(final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda72
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putSetToCache$16(tLRPC$TL_messages_stickerSet);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putSetToCache$16(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO web_recent_v3 VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindString(1, "s_" + tLRPC$TL_messages_stickerSet.set.id);
            sQLitePreparedStatementExecuteFast.bindInteger(2, 6);
            sQLitePreparedStatementExecuteFast.bindString(3, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            sQLitePreparedStatementExecuteFast.bindString(4, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            sQLitePreparedStatementExecuteFast.bindString(5, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            sQLitePreparedStatementExecuteFast.bindInteger(6, 0);
            sQLitePreparedStatementExecuteFast.bindInteger(7, 0);
            sQLitePreparedStatementExecuteFast.bindInteger(8, 0);
            sQLitePreparedStatementExecuteFast.bindInteger(9, 0);
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$TL_messages_stickerSet.getObjectSize());
            tLRPC$TL_messages_stickerSet.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(10, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public HashMap<String, ArrayList<TLRPC$Document>> getAllStickers() {
        return this.allStickers;
    }

    public HashMap<String, ArrayList<TLRPC$Document>> getAllStickersFeatured() {
        return this.allStickersFeatured;
    }

    public TLRPC$Document getEmojiAnimatedSticker(CharSequence charSequence) {
        String strReplace = charSequence.toString().replace("️", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = getStickerSets(4);
        int size = stickerSets.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = stickerSets.get(i);
            int size2 = tLRPC$TL_messages_stickerSet.packs.size();
            for (int i2 = 0; i2 < size2; i2++) {
                TLRPC$TL_stickerPack tLRPC$TL_stickerPack = tLRPC$TL_messages_stickerSet.packs.get(i2);
                if (!tLRPC$TL_stickerPack.documents.isEmpty() && TextUtils.equals(tLRPC$TL_stickerPack.emoticon, strReplace)) {
                    return getStickerByIds(4).get(tLRPC$TL_stickerPack.documents.get(0).longValue());
                }
            }
        }
        return null;
    }

    public boolean canAddStickerToFavorites() {
        return (this.stickersLoaded[0] && this.stickerSets[0].size() < 5 && this.recentStickers[2].isEmpty()) ? false : true;
    }

    public ArrayList<TLRPC$TL_messages_stickerSet> getStickerSets(int i) {
        if (i == 3) {
            return this.stickerSets[2];
        }
        return this.stickerSets[i];
    }

    public LongSparseArray<TLRPC$Document> getStickerByIds(int i) {
        return this.stickersByIds[i];
    }

    public ArrayList<TLRPC$StickerSetCovered> getFeaturedStickerSets() {
        return this.featuredStickerSets;
    }

    public ArrayList<Long> getUnreadStickerSets() {
        return this.unreadStickerSets;
    }

    public boolean areAllTrendingStickerSetsUnread() {
        int size = this.featuredStickerSets.size();
        for (int i = 0; i < size; i++) {
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered = this.featuredStickerSets.get(i);
            if (!isStickerPackInstalled(tLRPC$StickerSetCovered.set.id) && ((!tLRPC$StickerSetCovered.covers.isEmpty() || tLRPC$StickerSetCovered.cover != null) && !this.unreadStickerSets.contains(Long.valueOf(tLRPC$StickerSetCovered.set.id)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isStickerPackInstalled(long j) {
        return this.installedStickerSetsById.indexOfKey(j) >= 0;
    }

    public boolean isStickerPackUnread(long j) {
        return this.unreadStickerSets.contains(Long.valueOf(j));
    }

    public boolean isStickerPackInstalled(String str) {
        return this.stickerSetsByName.containsKey(str);
    }

    public String getEmojiForSticker(long j) {
        String str = this.stickersByEmoji.get(j);
        return str != null ? str : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
    }

    public static int calcDocumentsHash(ArrayList<TLRPC$Document> arrayList) {
        return calcDocumentsHash(arrayList, 200);
    }

    public static int calcDocumentsHash(ArrayList<TLRPC$Document> arrayList, int i) {
        if (arrayList == null) {
            return 0;
        }
        long j = 0;
        int iMin = Math.min(i, arrayList.size());
        for (int i2 = 0; i2 < iMin; i2++) {
            TLRPC$Document tLRPC$Document = arrayList.get(i2);
            if (tLRPC$Document != null) {
                long j2 = tLRPC$Document.id;
                j = (((((((j * 20261) + 2147483648L) + ((int) (j2 >> 32))) % 2147483648L) * 20261) + 2147483648L) + ((int) j2)) % 2147483648L;
            }
        }
        return (int) j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadRecents(final int i, final boolean z, boolean z2, boolean z3) {
        TLRPC$TL_messages_getRecentStickers tLRPC$TL_messages_getRecentStickers;
        if (z) {
            if (this.loadingRecentGifs) {
                return;
            } else {
                this.loadingRecentGifs = true;
            }
        } else {
            boolean[] zArr = this.loadingRecentStickers;
            if (zArr[i]) {
                return;
            }
            zArr[i] = true;
            boolean z4 = this.recentStickersLoaded[i];
        }
        if (z) {
            TLRPC$TL_messages_getSavedGifs tLRPC$TL_messages_getSavedGifs = new TLRPC$TL_messages_getSavedGifs();
            tLRPC$TL_messages_getSavedGifs.hash = calcDocumentsHash(this.recentGifs);
            getMessagesProxy().loadRecentGifs(tLRPC$TL_messages_getSavedGifs, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda104
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadRecents$17(i, z, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (i == 2) {
            TLRPC$TL_messages_getFavedStickers tLRPC$TL_messages_getFavedStickers = new TLRPC$TL_messages_getFavedStickers();
            tLRPC$TL_messages_getFavedStickers.hash = calcDocumentsHash(this.recentStickers[i]);
            tLRPC$TL_messages_getRecentStickers = tLRPC$TL_messages_getFavedStickers;
        } else if (i == 3) {
            TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers = new TLRPC$TL_messages_getStickers();
            tLRPC$TL_messages_getStickers.emoticon = "👋" + Emoji.fixEmoji("⭐");
            tLRPC$TL_messages_getStickers.hash = calcDocumentsHash(this.recentStickers[i]);
            tLRPC$TL_messages_getRecentStickers = tLRPC$TL_messages_getStickers;
        } else {
            TLRPC$TL_messages_getRecentStickers tLRPC$TL_messages_getRecentStickers2 = new TLRPC$TL_messages_getRecentStickers();
            tLRPC$TL_messages_getRecentStickers2.hash = calcDocumentsHash(this.recentStickers[i]);
            tLRPC$TL_messages_getRecentStickers2.attached = i == 1;
            tLRPC$TL_messages_getRecentStickers = tLRPC$TL_messages_getRecentStickers2;
        }
        getMessagesProxy().getRecentStickers(tLRPC$TL_messages_getRecentStickers, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda100
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadRecents$18(i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadRecents$17(int i, boolean z, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        processLoadedRecentDocuments(i, tLObject instanceof TLRPC$TL_messages_savedGifs ? ((TLRPC$TL_messages_savedGifs) tLObject).gifs : null, z, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadRecents$18(int r7, org.rbmain.tgnet.TLObject r8, org.rbmain.tgnet.TLRPC$TL_error r9) {
        /*
            r6 = this;
            r9 = 3
            if (r7 != r9) goto Lc
            boolean r9 = r8 instanceof org.rbmain.tgnet.TLRPC$TL_messages_stickers
            if (r9 == 0) goto L21
            org.rbmain.tgnet.TLRPC$TL_messages_stickers r8 = (org.rbmain.tgnet.TLRPC$TL_messages_stickers) r8
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Document> r8 = r8.stickers
            goto L22
        Lc:
            r9 = 2
            if (r7 != r9) goto L18
            boolean r9 = r8 instanceof org.rbmain.tgnet.TLRPC$TL_messages_favedStickers
            if (r9 == 0) goto L21
            org.rbmain.tgnet.TLRPC$TL_messages_favedStickers r8 = (org.rbmain.tgnet.TLRPC$TL_messages_favedStickers) r8
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Document> r8 = r8.stickers
            goto L22
        L18:
            boolean r9 = r8 instanceof org.rbmain.tgnet.TLRPC$TL_messages_recentStickers
            if (r9 == 0) goto L21
            org.rbmain.tgnet.TLRPC$TL_messages_recentStickers r8 = (org.rbmain.tgnet.TLRPC$TL_messages_recentStickers) r8
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Document> r8 = r8.stickers
            goto L22
        L21:
            r8 = 0
        L22:
            r2 = r8
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r6
            r1 = r7
            r0.processLoadedRecentDocuments(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.lambda$loadRecents$18(int, org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
    }

    private void preloadNextGreetingsSticker() {
        if (this.recentStickers[3].isEmpty()) {
            return;
        }
        ArrayList<TLRPC$Document>[] arrayListArr = this.recentStickers;
        this.greetingsSticker = arrayListArr[3].get(Utilities.random.nextInt(arrayListArr[3].size()));
        getFileLoader().loadFile(ImageLocation.getForDocument(this.greetingsSticker), this.greetingsSticker, null, 0, 1);
    }

    public TLRPC$Document getGreetingsSticker() {
        TLRPC$Document tLRPC$Document = this.greetingsSticker;
        preloadNextGreetingsSticker();
        return tLRPC$Document;
    }

    protected void processLoadedRecentDocuments(final int i, final ArrayList<TLRPC$Document> arrayList, final boolean z, final int i2, final boolean z2) {
        if (arrayList != null) {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedRecentDocuments$19(i, arrayList, z, i2, z2);
                }
            });
        }
        if (i2 == 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda77
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedRecentDocuments$20(z, i, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedRecentDocuments$19(int i, ArrayList arrayList, boolean z, int i2, boolean z2) {
        getMessagesProxy().processLoadedRecentDocuments(i, arrayList, z, i2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$processLoadedRecentDocuments$20(boolean z, int i, ArrayList arrayList) {
        SharedPreferences.Editor editorEdit = MessagesController.getEmojiSettings(this.currentAccount).edit();
        if (z) {
            this.loadingRecentGifs = false;
            this.recentGifsLoaded = true;
            editorEdit.putLong("lastGifLoadTime", System.currentTimeMillis()).apply();
        } else {
            this.loadingRecentStickers[i] = false;
            this.recentStickersLoaded[i] = true;
            if (i == 0) {
                editorEdit.putLong("lastStickersLoadTime", System.currentTimeMillis()).apply();
            } else if (i == 1) {
                editorEdit.putLong("lastStickersLoadTimeMask", System.currentTimeMillis()).apply();
            } else if (i == 3) {
                editorEdit.putLong("lastStickersLoadTimeGreet", System.currentTimeMillis()).apply();
            } else {
                editorEdit.putLong("lastStickersLoadTimeFavs", System.currentTimeMillis()).apply();
            }
        }
        if (arrayList != null) {
            if (z) {
                this.recentGifs = arrayList;
            } else {
                this.recentStickers[i] = arrayList;
            }
            if (i == 3) {
                preloadNextGreetingsSticker();
            }
            getNotificationCenter().postNotificationName(NotificationCenter.recentDocumentsDidLoad, Boolean.valueOf(z), Integer.valueOf(i));
        }
    }

    public void reorderStickers(int i, ArrayList<Long> arrayList) {
        this.loadHash[i] = calcStickersHash(this.stickerSets[i]);
        getNotificationCenter().postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(i));
        loadStickers(i, false, true);
    }

    public void calcNewHash(int i) {
        this.loadHash[i] = calcStickersHash(this.stickerSets[i]);
    }

    public void storeTempStickerSet(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        this.stickerSetsById.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
        this.stickerSetsByName.put(tLRPC$TL_messages_stickerSet.set.short_name, tLRPC$TL_messages_stickerSet);
    }

    public void addNewStickerSet(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        if (this.stickerSetsById.indexOfKey(tLRPC$TL_messages_stickerSet.set.id) >= 0 || this.stickerSetsByName.containsKey(tLRPC$TL_messages_stickerSet.set.short_name)) {
            return;
        }
        boolean z = tLRPC$TL_messages_stickerSet.set.masks;
        this.stickerSets[z ? 1 : 0].add(0, tLRPC$TL_messages_stickerSet);
        this.stickerSetsById.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
        this.installedStickerSetsById.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
        this.stickerSetsByName.put(tLRPC$TL_messages_stickerSet.set.short_name, tLRPC$TL_messages_stickerSet);
        LongSparseArray longSparseArray = new LongSparseArray();
        for (int i = 0; i < tLRPC$TL_messages_stickerSet.documents.size(); i++) {
            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i);
            longSparseArray.put(tLRPC$Document.id, tLRPC$Document);
        }
        for (int i2 = 0; i2 < tLRPC$TL_messages_stickerSet.packs.size(); i2++) {
            TLRPC$TL_stickerPack tLRPC$TL_stickerPack = tLRPC$TL_messages_stickerSet.packs.get(i2);
            String strReplace = tLRPC$TL_stickerPack.emoticon.replace("️", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            tLRPC$TL_stickerPack.emoticon = strReplace;
            ArrayList<TLRPC$Document> arrayList = this.allStickers.get(strReplace);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.allStickers.put(tLRPC$TL_stickerPack.emoticon, arrayList);
            }
            for (int i3 = 0; i3 < tLRPC$TL_stickerPack.documents.size(); i3++) {
                Long l = tLRPC$TL_stickerPack.documents.get(i3);
                if (this.stickersByEmoji.indexOfKey(l.longValue()) < 0) {
                    this.stickersByEmoji.put(l.longValue(), tLRPC$TL_stickerPack.emoticon);
                }
                TLRPC$Document tLRPC$Document2 = (TLRPC$Document) longSparseArray.get(l.longValue());
                if (tLRPC$Document2 != null) {
                    arrayList.add(tLRPC$Document2);
                }
            }
        }
        this.loadHash[z ? 1 : 0] = calcStickersHash(this.stickerSets[z ? 1 : 0]);
        getNotificationCenter().postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(z ? 1 : 0));
        loadStickers(z ? 1 : 0, false, true);
    }

    public void loadFeaturedStickers(boolean z, boolean z2, final boolean z3) {
        if (!this.hasContinue) {
            this.loadingFeaturedStickers = false;
            return;
        }
        if (this.loadingFeaturedStickers) {
            return;
        }
        this.loadingFeaturedStickers = true;
        final TLRPC$TL_messages_getFeaturedStickers tLRPC$TL_messages_getFeaturedStickers = new TLRPC$TL_messages_getFeaturedStickers();
        tLRPC$TL_messages_getFeaturedStickers.hash = z2 ? 0 : this.loadFeaturedHash;
        tLRPC$TL_messages_getFeaturedStickers.startId = z2 ? null : this.nextStartId;
        tLRPC$TL_messages_getFeaturedStickers.forceLoadFromServer = z3;
        getMessagesProxy().loadTrendStickers(tLRPC$TL_messages_getFeaturedStickers, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda120
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadFeaturedStickers$22(z3, tLRPC$TL_messages_getFeaturedStickers, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFeaturedStickers$22(final boolean z, final TLRPC$TL_messages_getFeaturedStickers tLRPC$TL_messages_getFeaturedStickers, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda58
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFeaturedStickers$21(tLObject, z, tLRPC$TL_messages_getFeaturedStickers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFeaturedStickers$21(TLObject tLObject, boolean z, TLRPC$TL_messages_getFeaturedStickers tLRPC$TL_messages_getFeaturedStickers) {
        if (tLObject instanceof TLRPC$TL_messages_featuredStickers) {
            TLRPC$TL_messages_featuredStickers tLRPC$TL_messages_featuredStickers = (TLRPC$TL_messages_featuredStickers) tLObject;
            this.nextStartId = tLRPC$TL_messages_featuredStickers.nextStartId;
            this.hasContinue = tLRPC$TL_messages_featuredStickers.hasContinue;
            processLoadedFeaturedStickers(tLRPC$TL_messages_featuredStickers.sets, tLRPC$TL_messages_featuredStickers.unread, false, (int) (System.currentTimeMillis() / 1000), tLRPC$TL_messages_featuredStickers.hash, z);
            return;
        }
        processLoadedFeaturedStickers(null, null, false, (int) (System.currentTimeMillis() / 1000), tLRPC$TL_messages_getFeaturedStickers.hash, z);
    }

    private void processLoadedFeaturedStickers(final ArrayList<TLRPC$StickerSetCovered> arrayList, final ArrayList<Long> arrayList2, final boolean z, final int i, final int i2, boolean z2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedFeaturedStickers$23();
            }
        });
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda79
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedFeaturedStickers$27(z, arrayList, i, i2, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$23() {
        this.loadingFeaturedStickers = false;
        this.featuredStickersLoaded = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$27(boolean z, final ArrayList arrayList, final int i, final int i2, final ArrayList arrayList2) {
        if ((z && (arrayList == null || Math.abs((System.currentTimeMillis() / 1000) - i) >= 3600)) || (!z && arrayList == null && i2 == 0)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedFeaturedStickers$24(arrayList, i2);
                }
            }, (arrayList != null || z) ? 0L : 1000L);
            if (arrayList == null) {
                return;
            }
        }
        if (arrayList == null) {
            if (z) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedFeaturedStickers$26(i);
                }
            });
            putFeaturedStickersToCache(null, null, i, 0);
            return;
        }
        try {
            final ArrayList<TLRPC$StickerSetCovered> arrayList3 = new ArrayList<>();
            final LongSparseArray longSparseArray = new LongSparseArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) arrayList.get(i3);
                arrayList3.add(tLRPC$StickerSetCovered);
                longSparseArray.put(tLRPC$StickerSetCovered.set.id, tLRPC$StickerSetCovered);
            }
            if (!z) {
                putFeaturedStickersToCache(arrayList3, arrayList2, i, i2);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedFeaturedStickers$25(arrayList2, longSparseArray, arrayList3, i2, i);
                }
            });
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$24(ArrayList arrayList, int i) {
        if (arrayList == null || i == 0) {
            return;
        }
        this.loadFeaturedHash = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$25(ArrayList arrayList, LongSparseArray longSparseArray, ArrayList arrayList2, int i, int i2) {
        this.unreadStickerSets = arrayList;
        this.featuredStickerSetsById = longSparseArray;
        this.featuredStickerSets = arrayList2;
        this.loadFeaturedHash = i;
        this.loadFeaturedDate = i2;
        loadStickers(3, true, false);
        getNotificationCenter().postNotificationName(NotificationCenter.featuredStickersDidLoad, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$26(int i) {
        this.loadFeaturedDate = i;
    }

    private void putFeaturedStickersToCache(ArrayList<TLRPC$StickerSetCovered> arrayList, ArrayList<Long> arrayList2, int i, int i2) {
        if (arrayList != null) {
            new ArrayList(arrayList);
        }
    }

    private int calcFeaturedStickersHash(ArrayList<TLRPC$StickerSetCovered> arrayList) {
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$StickerSet tLRPC$StickerSet = arrayList.get(i).set;
            if (!tLRPC$StickerSet.archived) {
                j = (((((((j * 20261) + 2147483648L) + ((int) (r3 >> 32))) % 2147483648L) * 20261) + 2147483648L) + ((int) r3)) % 2147483648L;
                if (this.unreadStickerSets.contains(Long.valueOf(tLRPC$StickerSet.id))) {
                    j = (((j * 20261) + 2147483648L) + 1) % 2147483648L;
                }
            }
        }
        return (int) j;
    }

    public void markFaturedStickersAsRead(boolean z) {
        if (this.unreadStickerSets.isEmpty()) {
            return;
        }
        this.unreadStickerSets.clear();
        this.loadFeaturedHash = calcFeaturedStickersHash(this.featuredStickerSets);
        getNotificationCenter().postNotificationName(NotificationCenter.featuredStickersDidLoad, new Object[0]);
        putFeaturedStickersToCache(this.featuredStickerSets, this.unreadStickerSets, this.loadFeaturedDate, this.loadFeaturedHash);
        if (z) {
            getConnectionsManager().sendRequest(new TLRPC$TL_messages_readFeaturedStickers(), new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda121
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MediaDataController.lambda$markFaturedStickersAsRead$28(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    public int getFeaturesStickersHashWithoutUnread() {
        long j = 0;
        for (int i = 0; i < this.featuredStickerSets.size(); i++) {
            TLRPC$StickerSet tLRPC$StickerSet = this.featuredStickerSets.get(i).set;
            if (!tLRPC$StickerSet.archived) {
                long j2 = tLRPC$StickerSet.id;
                j = (((((((j * 20261) + 2147483648L) + ((int) (j2 >> 32))) % 2147483648L) * 20261) + 2147483648L) + ((int) j2)) % 2147483648L;
            }
        }
        return (int) j;
    }

    public void markFaturedStickersByIdAsRead(final long j) {
        if (!this.unreadStickerSets.contains(Long.valueOf(j)) || this.readingStickerSets.contains(Long.valueOf(j))) {
            return;
        }
        this.readingStickerSets.add(Long.valueOf(j));
        TLRPC$TL_messages_readFeaturedStickers tLRPC$TL_messages_readFeaturedStickers = new TLRPC$TL_messages_readFeaturedStickers();
        tLRPC$TL_messages_readFeaturedStickers.id.add(Long.valueOf(j));
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readFeaturedStickers, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda123
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MediaDataController.lambda$markFaturedStickersByIdAsRead$29(tLObject, tLRPC$TL_error);
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markFaturedStickersByIdAsRead$30(j);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markFaturedStickersByIdAsRead$30(long j) {
        this.unreadStickerSets.remove(Long.valueOf(j));
        this.readingStickerSets.remove(Long.valueOf(j));
        this.loadFeaturedHash = calcFeaturedStickersHash(this.featuredStickerSets);
        getNotificationCenter().postNotificationName(NotificationCenter.featuredStickersDidLoad, new Object[0]);
        putFeaturedStickersToCache(this.featuredStickerSets, this.unreadStickerSets, this.loadFeaturedDate, this.loadFeaturedHash);
    }

    public int getArchivedStickersCount(int i) {
        return this.archivedStickersCount[i];
    }

    public void verifyAnimatedStickerMessage(TLRPC$Message tLRPC$Message) {
        verifyAnimatedStickerMessage(tLRPC$Message, false);
    }

    public void verifyAnimatedStickerMessage(final TLRPC$Message tLRPC$Message, boolean z) {
        if (tLRPC$Message == null) {
            return;
        }
        TLRPC$Document document = MessageObject.getDocument(tLRPC$Message);
        final String stickerSetName = MessageObject.getStickerSetName(document);
        if (TextUtils.isEmpty(stickerSetName)) {
            return;
        }
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSetsByName.get(stickerSetName);
        if (tLRPC$TL_messages_stickerSet == null) {
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda62
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$verifyAnimatedStickerMessage$31(tLRPC$Message, stickerSetName);
                    }
                });
                return;
            } else {
                lambda$verifyAnimatedStickerMessage$31(tLRPC$Message, stickerSetName);
                return;
            }
        }
        int size = tLRPC$TL_messages_stickerSet.documents.size();
        for (int i = 0; i < size; i++) {
            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i);
            if (tLRPC$Document.id == document.id && tLRPC$Document.dc_id == document.dc_id) {
                tLRPC$Message.stickerVerified = 1;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verifyAnimatedStickerMessageInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$verifyAnimatedStickerMessage$31(TLRPC$Message tLRPC$Message, final String str) {
        ArrayList<TLRPC$Message> arrayList = this.verifyingMessages.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.verifyingMessages.put(str, arrayList);
        }
        arrayList.add(tLRPC$Message);
        TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
        tLRPC$TL_messages_getStickerSet.stickerset = MessageObject.getInputStickerSet(tLRPC$Message);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda114
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$verifyAnimatedStickerMessageInternal$33(str, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$verifyAnimatedStickerMessageInternal$33(final String str, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$verifyAnimatedStickerMessageInternal$32(str, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$verifyAnimatedStickerMessageInternal$32(String str, TLObject tLObject) {
        ArrayList<TLRPC$Message> arrayList = this.verifyingMessages.get(str);
        if (tLObject != null) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) tLObject;
            storeTempStickerSet(tLRPC$TL_messages_stickerSet);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TLRPC$Message tLRPC$Message = arrayList.get(i);
                TLRPC$Document document = MessageObject.getDocument(tLRPC$Message);
                int size2 = tLRPC$TL_messages_stickerSet.documents.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i2);
                    if (tLRPC$Document.id == document.id && tLRPC$Document.dc_id == document.dc_id) {
                        tLRPC$Message.stickerVerified = 1;
                        break;
                    }
                    i2++;
                }
                if (tLRPC$Message.stickerVerified == 0) {
                    tLRPC$Message.stickerVerified = 2;
                }
            }
        } else {
            int size3 = arrayList.size();
            for (int i3 = 0; i3 < size3; i3++) {
                arrayList.get(i3).stickerVerified = 2;
            }
        }
        getNotificationCenter().postNotificationName(NotificationCenter.didVerifyMessagesStickers, arrayList);
        getMessagesStorage().updateMessageVerifyFlags(arrayList);
    }

    public void loadArchivedStickersCount(final int i, boolean z) {
        if (z) {
            int i2 = MessagesController.getNotificationsSettings(this.currentAccount).getInt("archivedStickersCount" + i, -1);
            if (i2 == -1) {
                loadArchivedStickersCount(i, false);
                return;
            } else {
                this.archivedStickersCount[i] = i2;
                getNotificationCenter().postNotificationName(NotificationCenter.archivedStickersCountDidLoad, Integer.valueOf(i));
                return;
            }
        }
        TLRPC$TL_messages_getArchivedStickers tLRPC$TL_messages_getArchivedStickers = new TLRPC$TL_messages_getArchivedStickers();
        tLRPC$TL_messages_getArchivedStickers.limit = 0;
        tLRPC$TL_messages_getArchivedStickers.masks = i == 1;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getArchivedStickers, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda99
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadArchivedStickersCount$35(i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadArchivedStickersCount$35(final int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda68
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadArchivedStickersCount$34(tLRPC$TL_error, tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadArchivedStickersCount$34(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_archivedStickers tLRPC$TL_messages_archivedStickers = (TLRPC$TL_messages_archivedStickers) tLObject;
            this.archivedStickersCount[i] = tLRPC$TL_messages_archivedStickers.count;
            MessagesController.getNotificationsSettings(this.currentAccount).edit().putInt("archivedStickersCount" + i, tLRPC$TL_messages_archivedStickers.count).apply();
            getNotificationCenter().postNotificationName(NotificationCenter.archivedStickersCountDidLoad, Integer.valueOf(i));
        }
    }

    private void processLoadStickersResponse(int i, TLRPC$TL_messages_allStickers tLRPC$TL_messages_allStickers) {
        new ArrayList();
        throw null;
    }

    private /* synthetic */ void lambda$processLoadStickersResponse$37(final ArrayList arrayList, final int i, final LongSparseArray longSparseArray, final TLRPC$StickerSet tLRPC$StickerSet, final TLRPC$TL_messages_allStickers tLRPC$TL_messages_allStickers, final int i2, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable(tLObject, arrayList, i, longSparseArray, tLRPC$StickerSet, tLRPC$TL_messages_allStickers, i2) { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda57
            public final /* synthetic */ TLObject f$1;
            public final /* synthetic */ ArrayList f$2;
            public final /* synthetic */ int f$3;
            public final /* synthetic */ LongSparseArray f$4;
            public final /* synthetic */ TLRPC$StickerSet f$5;
            public final /* synthetic */ TLRPC$TL_messages_allStickers f$6;
            public final /* synthetic */ int f$7;

            {
                this.f$7 = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadStickersResponse$36(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadStickersResponse$36(TLObject tLObject, ArrayList arrayList, int i, LongSparseArray longSparseArray, TLRPC$StickerSet tLRPC$StickerSet, TLRPC$TL_messages_allStickers tLRPC$TL_messages_allStickers, int i2) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) tLObject;
        arrayList.set(i, tLRPC$TL_messages_stickerSet);
        longSparseArray.put(tLRPC$StickerSet.id, tLRPC$TL_messages_stickerSet);
        longSparseArray.size();
        throw null;
    }

    public void loadStickersByEmojiOrName(final String str, final boolean z, boolean z2) {
        if (this.loadingDiceStickerSets.contains(str)) {
            return;
        }
        if (!z || this.diceStickerSetsByEmoji.get(str) == null) {
            this.loadingDiceStickerSets.add(str);
            if (z2) {
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda41
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadStickersByEmojiOrName$38(str, z);
                    }
                });
                return;
            }
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
            if (z) {
                TLRPC$TL_inputStickerSetDice tLRPC$TL_inputStickerSetDice = new TLRPC$TL_inputStickerSetDice();
                tLRPC$TL_inputStickerSetDice.emoticon = str;
                tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetDice;
            } else {
                TLRPC$TL_inputStickerSetShortName tLRPC$TL_inputStickerSetShortName = new TLRPC$TL_inputStickerSetShortName();
                tLRPC$TL_inputStickerSetShortName.short_name = str;
                tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetShortName;
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda116
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadStickersByEmojiOrName$40(str, z, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadStickersByEmojiOrName$38(String str, boolean z) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2;
        int i;
        SQLiteCursor sQLiteCursor = null;
        tLRPC$TL_messages_stickerSetTLdeserialize = null;
        tLRPC$TL_messages_stickerSetTLdeserialize = null;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSetTLdeserialize = null;
        int iIntValue = 0;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized("SELECT data, date FROM stickers_dice WHERE emoji = ?", str);
            try {
                if (sQLiteCursorQueryFinalized.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue != null) {
                        tLRPC$TL_messages_stickerSetTLdeserialize = TLRPC$TL_messages_stickerSet.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        nativeByteBufferByteBufferValue.reuse();
                    }
                    iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                }
                sQLiteCursorQueryFinalized.dispose();
                tLRPC$TL_messages_stickerSet2 = tLRPC$TL_messages_stickerSetTLdeserialize;
                i = iIntValue;
            } catch (Throwable th) {
                th = th;
                tLRPC$TL_messages_stickerSet = tLRPC$TL_messages_stickerSetTLdeserialize;
                sQLiteCursor = sQLiteCursorQueryFinalized;
                try {
                    FileLog.e(th);
                    tLRPC$TL_messages_stickerSet2 = tLRPC$TL_messages_stickerSet;
                    i = 0;
                    processLoadedDiceStickers(str, z, tLRPC$TL_messages_stickerSet2, true, i);
                } finally {
                    if (sQLiteCursor != null) {
                        sQLiteCursor.dispose();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            tLRPC$TL_messages_stickerSet = null;
        }
        processLoadedDiceStickers(str, z, tLRPC$TL_messages_stickerSet2, true, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadStickersByEmojiOrName$40(final String str, final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda69
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStickersByEmojiOrName$39(tLRPC$TL_error, tLObject, str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadStickersByEmojiOrName$39(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str, boolean z) {
        if (tLObject instanceof TLRPC$TL_messages_stickerSet) {
            processLoadedDiceStickers(str, z, (TLRPC$TL_messages_stickerSet) tLObject, false, (int) (System.currentTimeMillis() / 1000));
        } else {
            processLoadedDiceStickers(str, z, null, false, (int) (System.currentTimeMillis() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDiceStickers$41(String str) {
        this.loadingDiceStickerSets.remove(str);
    }

    private void processLoadedDiceStickers(final String str, final boolean z, final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, final boolean z2, final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDiceStickers$41(str);
            }
        });
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda81
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDiceStickers$44(z2, tLRPC$TL_messages_stickerSet, i, str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDiceStickers$44(boolean z, final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, int i, final String str, final boolean z2) {
        if ((z && (tLRPC$TL_messages_stickerSet == null || Math.abs((System.currentTimeMillis() / 1000) - i) >= 3600)) || (!z && tLRPC$TL_messages_stickerSet == null)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda42
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedDiceStickers$42(str, z2);
                }
            }, (tLRPC$TL_messages_stickerSet != null || z) ? 0L : 1000L);
            if (tLRPC$TL_messages_stickerSet == null) {
                return;
            }
        }
        if (tLRPC$TL_messages_stickerSet != null) {
            if (!z) {
                putDiceStickersToCache(str, tLRPC$TL_messages_stickerSet, i);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedDiceStickers$43(str, tLRPC$TL_messages_stickerSet);
                }
            });
        } else {
            if (z) {
                return;
            }
            putDiceStickersToCache(str, null, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDiceStickers$42(String str, boolean z) {
        loadStickersByEmojiOrName(str, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedDiceStickers$43(String str, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        this.diceStickerSetsByEmoji.put(str, tLRPC$TL_messages_stickerSet);
        this.diceEmojiStickerSetsById.put(tLRPC$TL_messages_stickerSet.set.id, str);
        getNotificationCenter().postNotificationName(NotificationCenter.diceStickersDidLoad, str);
    }

    private void putDiceStickersToCache(final String str, final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda74
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putDiceStickersToCache$45(tLRPC$TL_messages_stickerSet, str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putDiceStickersToCache$45(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, String str, int i) {
        try {
            if (tLRPC$TL_messages_stickerSet != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO stickers_dice VALUES(?, ?, ?)");
                sQLitePreparedStatementExecuteFast.requery();
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$TL_messages_stickerSet.getObjectSize());
                tLRPC$TL_messages_stickerSet.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindString(1, str);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(3, i);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
                sQLitePreparedStatementExecuteFast.dispose();
            } else {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = getMessagesStorage().getDatabase().executeFast("UPDATE stickers_dice SET date = ?");
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindInteger(1, i);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void loadStickers(int i, boolean z, boolean z2) {
        loadStickers(i, z, z2, false);
    }

    public void loadStickers(final int i, boolean z, final boolean z2, boolean z3) {
        if (this.loadingStickers[i]) {
            if (z3) {
                this.scheduledLoadStickers[i] = new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda18
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadStickers$46(i, z2);
                    }
                };
                return;
            }
            return;
        }
        if (i == 3) {
            if (this.featuredStickerSets.isEmpty() || !getMessagesController().preloadFeaturedStickers) {
                return;
            }
        } else if (i != 4) {
            loadArchivedStickersCount(i, z);
        }
        boolean[] zArr = this.loadingStickers;
        zArr[i] = true;
        if (i == 0) {
            getMessagesProxy().loadStickers(i);
        } else {
            zArr[i] = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadStickers$46(int i, boolean z) {
        loadStickers(i, false, z, false);
    }

    private void putStickersToCache(int i, ArrayList<TLRPC$TL_messages_stickerSet> arrayList, int i2, int i3) {
        if (arrayList != null) {
            new ArrayList(arrayList);
        }
    }

    public String getStickerSetName(long j) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSetsById.get(j);
        if (tLRPC$TL_messages_stickerSet != null) {
            return tLRPC$TL_messages_stickerSet.set.short_name;
        }
        TLRPC$StickerSetCovered tLRPC$StickerSetCovered = this.featuredStickerSetsById.get(j);
        if (tLRPC$StickerSetCovered != null) {
            return tLRPC$StickerSetCovered.set.short_name;
        }
        return null;
    }

    public static long getStickerSetId(TLRPC$Document tLRPC$Document) {
        for (int i = 0; i < tLRPC$Document.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                TLRPC$InputStickerSet tLRPC$InputStickerSet = tLRPC$DocumentAttribute.stickerset;
                if (tLRPC$InputStickerSet instanceof TLRPC$TL_inputStickerSetID) {
                    return tLRPC$InputStickerSet.id;
                }
                return -1L;
            }
        }
        return -1L;
    }

    public static TLRPC$InputStickerSet getInputStickerSet(TLRPC$Document tLRPC$Document) {
        for (int i = 0; i < tLRPC$Document.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                TLRPC$InputStickerSet tLRPC$InputStickerSet = tLRPC$DocumentAttribute.stickerset;
                if (tLRPC$InputStickerSet instanceof TLRPC$TL_inputStickerSetEmpty) {
                    return null;
                }
                return tLRPC$InputStickerSet;
            }
        }
        return null;
    }

    private static int calcStickersHash(ArrayList<TLRPC$TL_messages_stickerSet> arrayList) {
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList.get(i).set.archived) {
                j = (((j * 20261) + 2147483648L) + r3.hash) % 2147483648L;
            }
        }
        return (int) j;
    }

    public void processLoadedStickers(final int i, final ArrayList<TLRPC$TL_messages_stickerSet> arrayList, final boolean z, final int i2, final int i3) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedStickers$47(i);
            }
        });
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda78
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedStickers$51(z, arrayList, i2, i3, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedStickers$47(int i) {
        this.loadingStickers[i] = false;
        this.stickersLoaded[i] = true;
        Runnable[] runnableArr = this.scheduledLoadStickers;
        if (runnableArr[i] != null) {
            runnableArr[i].run();
            this.scheduledLoadStickers[i] = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedStickers$51(boolean z, ArrayList arrayList, final int i, final int i2, final int i3) {
        int i4;
        String str;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet;
        final ArrayList arrayList2 = arrayList;
        if ((z && (arrayList2 == null || Math.abs((System.currentTimeMillis() / 1000) - i) >= 3600)) || (!z && arrayList2 == null && i2 == 0)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda46
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedStickers$48(arrayList2, i2, i3);
                }
            }, (arrayList2 != null || z) ? 0L : 10000L);
            if (arrayList2 == null) {
                return;
            }
        }
        if (arrayList2 == null) {
            if (z) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedStickers$50(i3, i);
                }
            });
            putStickersToCache(i3, null, i, 0);
            return;
        }
        try {
            final ArrayList<TLRPC$TL_messages_stickerSet> arrayList3 = new ArrayList<>();
            LongSparseArray longSparseArray = new LongSparseArray();
            HashMap map = new HashMap();
            final LongSparseArray longSparseArray2 = new LongSparseArray();
            final LongSparseArray longSparseArray3 = new LongSparseArray();
            final HashMap map2 = new HashMap();
            int i5 = 0;
            while (i5 < arrayList.size()) {
                TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2 = (TLRPC$TL_messages_stickerSet) arrayList2.get(i5);
                if (tLRPC$TL_messages_stickerSet2 != null) {
                    i4 = i5;
                    if (this.removingStickerSetsUndos.indexOfKey(tLRPC$TL_messages_stickerSet2.set.id) < 0) {
                        arrayList3.add(tLRPC$TL_messages_stickerSet2);
                        longSparseArray.put(tLRPC$TL_messages_stickerSet2.set.id, tLRPC$TL_messages_stickerSet2);
                        map.put(tLRPC$TL_messages_stickerSet2.set.short_name, tLRPC$TL_messages_stickerSet2);
                        for (int i6 = 0; i6 < tLRPC$TL_messages_stickerSet2.documents.size(); i6++) {
                            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet2.documents.get(i6);
                            if (tLRPC$Document != null && !(tLRPC$Document instanceof TLRPC$TL_documentEmpty)) {
                                longSparseArray3.put(tLRPC$Document.id, tLRPC$Document);
                            }
                        }
                        if (!tLRPC$TL_messages_stickerSet2.set.archived) {
                            int i7 = 0;
                            while (i7 < tLRPC$TL_messages_stickerSet2.packs.size()) {
                                TLRPC$TL_stickerPack tLRPC$TL_stickerPack = tLRPC$TL_messages_stickerSet2.packs.get(i7);
                                if (tLRPC$TL_stickerPack != null && (str = tLRPC$TL_stickerPack.emoticon) != null) {
                                    String strReplace = str.replace("️", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                                    tLRPC$TL_stickerPack.emoticon = strReplace;
                                    ArrayList arrayList4 = (ArrayList) map2.get(strReplace);
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                        map2.put(tLRPC$TL_stickerPack.emoticon, arrayList4);
                                    }
                                    int i8 = 0;
                                    while (i8 < tLRPC$TL_stickerPack.documents.size()) {
                                        Long l = tLRPC$TL_stickerPack.documents.get(i8);
                                        LongSparseArray longSparseArray4 = longSparseArray;
                                        HashMap map3 = map;
                                        if (longSparseArray2.indexOfKey(l.longValue()) < 0) {
                                            tLRPC$TL_messages_stickerSet = tLRPC$TL_messages_stickerSet2;
                                            longSparseArray2.put(l.longValue(), tLRPC$TL_stickerPack.emoticon);
                                        } else {
                                            tLRPC$TL_messages_stickerSet = tLRPC$TL_messages_stickerSet2;
                                        }
                                        TLRPC$Document tLRPC$Document2 = (TLRPC$Document) longSparseArray3.get(l.longValue());
                                        if (tLRPC$Document2 != null) {
                                            arrayList4.add(tLRPC$Document2);
                                        }
                                        i8++;
                                        longSparseArray = longSparseArray4;
                                        map = map3;
                                        tLRPC$TL_messages_stickerSet2 = tLRPC$TL_messages_stickerSet;
                                    }
                                }
                                i7++;
                                longSparseArray = longSparseArray;
                                map = map;
                                tLRPC$TL_messages_stickerSet2 = tLRPC$TL_messages_stickerSet2;
                            }
                        }
                    }
                } else {
                    i4 = i5;
                }
                i5 = i4 + 1;
                arrayList2 = arrayList;
                longSparseArray = longSparseArray;
                map = map;
            }
            final LongSparseArray longSparseArray5 = longSparseArray;
            final HashMap map4 = map;
            if (!z) {
                putStickersToCache(i3, arrayList3, i, i2);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedStickers$49(i3, longSparseArray5, map4, arrayList3, i2, i, longSparseArray3, map2, longSparseArray2);
                }
            });
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedStickers$48(ArrayList arrayList, int i, int i2) {
        if (arrayList != null && i != 0) {
            this.loadHash[i2] = i;
        }
        loadStickers(i2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$processLoadedStickers$49(int i, LongSparseArray longSparseArray, HashMap map, ArrayList arrayList, int i2, int i3, LongSparseArray longSparseArray2, HashMap map2, LongSparseArray longSparseArray3) {
        for (int i4 = 0; i4 < this.stickerSets[i].size(); i4++) {
            TLRPC$StickerSet tLRPC$StickerSet = this.stickerSets[i].get(i4).set;
            this.stickerSetsById.remove(tLRPC$StickerSet.id);
            this.stickerSetsByName.remove(tLRPC$StickerSet.short_name);
            if (i != 3 && i != 4) {
                this.installedStickerSetsById.remove(tLRPC$StickerSet.id);
            }
        }
        for (int i5 = 0; i5 < longSparseArray.size(); i5++) {
            this.stickerSetsById.put(longSparseArray.keyAt(i5), (TLRPC$TL_messages_stickerSet) longSparseArray.valueAt(i5));
            if (i != 3 && i != 4) {
                this.installedStickerSetsById.put(longSparseArray.keyAt(i5), (TLRPC$TL_messages_stickerSet) longSparseArray.valueAt(i5));
            }
        }
        this.stickerSetsByName.putAll(map);
        this.stickerSets[i] = arrayList;
        this.loadHash[i] = i2;
        this.loadDate[i] = i3;
        this.stickersByIds[i] = longSparseArray2;
        if (i == 0) {
            this.allStickers = map2;
            this.stickersByEmoji = longSparseArray3;
        } else if (i == 3) {
            this.allStickersFeatured = map2;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedStickers$50(int i, int i2) {
        this.loadDate[i] = i2;
    }

    public boolean cancelRemovingStickerSet(long j) {
        Runnable runnable = this.removingStickerSetsUndos.get(j);
        if (runnable == null) {
            return false;
        }
        runnable.run();
        return true;
    }

    public void preloadStickerSetThumb(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        ArrayList<TLRPC$Document> arrayList;
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_messages_stickerSet.set.thumbs, 90);
        if (closestPhotoSizeWithSize == null || (arrayList = tLRPC$TL_messages_stickerSet.documents) == null || arrayList.isEmpty()) {
            return;
        }
        loadStickerSetThumbInternal(closestPhotoSizeWithSize, tLRPC$TL_messages_stickerSet, arrayList.get(0));
    }

    public void preloadStickerSetThumb(TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$StickerSetCovered.set.thumbs, 90);
        if (closestPhotoSizeWithSize != null) {
            TLRPC$Document tLRPC$Document = tLRPC$StickerSetCovered.cover;
            if (tLRPC$Document == null) {
                if (tLRPC$StickerSetCovered.covers.isEmpty()) {
                    return;
                } else {
                    tLRPC$Document = tLRPC$StickerSetCovered.covers.get(0);
                }
            }
            loadStickerSetThumbInternal(closestPhotoSizeWithSize, tLRPC$StickerSetCovered, tLRPC$Document);
        }
    }

    private void loadStickerSetThumbInternal(TLRPC$PhotoSize tLRPC$PhotoSize, Object obj, TLRPC$Document tLRPC$Document) {
        ImageLocation forSticker = ImageLocation.getForSticker(tLRPC$PhotoSize, tLRPC$Document);
        if (forSticker != null) {
            getFileLoader().loadFile(forSticker, obj, forSticker.imageType == 1 ? "tgs" : "webp", 2, 1);
        }
    }

    public void toggleStickerSet(final Context context, final TLObject tLObject, final int i, final BaseFragment baseFragment, final boolean z, boolean z2) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet;
        TLRPC$StickerSet tLRPC$StickerSet;
        final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2;
        final int i2;
        if (tLObject instanceof TLRPC$TL_messages_stickerSet) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet3 = (TLRPC$TL_messages_stickerSet) tLObject;
            tLRPC$TL_messages_stickerSet2 = tLRPC$TL_messages_stickerSet3;
            tLRPC$StickerSet = tLRPC$TL_messages_stickerSet3.set;
        } else if (tLObject instanceof TLRPC$StickerSetCovered) {
            TLRPC$StickerSet tLRPC$StickerSet2 = ((TLRPC$StickerSetCovered) tLObject).set;
            if (i != 2) {
                tLRPC$TL_messages_stickerSet = this.stickerSetsById.get(tLRPC$StickerSet2.id);
                if (tLRPC$TL_messages_stickerSet == null) {
                    return;
                }
            } else {
                tLRPC$TL_messages_stickerSet = null;
            }
            tLRPC$StickerSet = tLRPC$StickerSet2;
            tLRPC$TL_messages_stickerSet2 = tLRPC$TL_messages_stickerSet;
        } else {
            throw new IllegalArgumentException("Invalid type of the given stickerSetObject: " + tLObject.getClass());
        }
        boolean z3 = tLRPC$StickerSet.masks;
        tLRPC$StickerSet.archived = i == 1;
        int i3 = 0;
        while (true) {
            if (i3 >= this.stickerSets[z3 ? 1 : 0].size()) {
                i2 = 0;
                break;
            }
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet4 = this.stickerSets[z3 ? 1 : 0].get(i3);
            if (tLRPC$TL_messages_stickerSet4.set.id == tLRPC$StickerSet.id) {
                this.stickerSets[z3 ? 1 : 0].remove(i3);
                if (i == 2) {
                    this.stickerSets[z3 ? 1 : 0].add(0, tLRPC$TL_messages_stickerSet4);
                } else {
                    this.stickerSetsById.remove(tLRPC$TL_messages_stickerSet4.set.id);
                    this.installedStickerSetsById.remove(tLRPC$TL_messages_stickerSet4.set.id);
                    this.stickerSetsByName.remove(tLRPC$TL_messages_stickerSet4.set.short_name);
                }
                i2 = i3;
            } else {
                i3++;
            }
        }
        this.loadHash[z3 ? 1 : 0] = calcStickersHash(this.stickerSets[z3 ? 1 : 0]);
        putStickersToCache(z3 ? 1 : 0, this.stickerSets[z3 ? 1 : 0], this.loadDate[z3 ? 1 : 0], this.loadHash[z3 ? 1 : 0]);
        getNotificationCenter().postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(z3 ? 1 : 0));
        if (i == 2) {
            if (cancelRemovingStickerSet(tLRPC$StickerSet.id)) {
                return;
            }
            toggleStickerSetInternal(context, i, baseFragment, z, tLObject, tLRPC$StickerSet, z3 ? 1 : 0, z2);
            return;
        }
        if (!z2 || baseFragment == null) {
            toggleStickerSetInternal(context, i, baseFragment, z, tLObject, tLRPC$StickerSet, z3 ? 1 : 0, false);
            return;
        }
        StickerSetBulletinLayout stickerSetBulletinLayout = new StickerSetBulletinLayout(context, tLObject, i);
        Bulletin.UndoButton undoButton = new Bulletin.UndoButton(context, false);
        final TLRPC$StickerSet tLRPC$StickerSet3 = tLRPC$StickerSet;
        final int i4 = z3 ? 1 : 0;
        Bulletin.UndoButton undoAction = undoButton.setUndoAction(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda65
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSet$52(tLRPC$StickerSet3, i4, i2, tLRPC$TL_messages_stickerSet2);
            }
        });
        final TLRPC$StickerSet tLRPC$StickerSet4 = tLRPC$StickerSet;
        final int i5 = z3 ? 1 : 0;
        final Bulletin.UndoButton delayedAction = undoAction.setDelayedAction(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSet$53(context, i, baseFragment, z, tLObject, tLRPC$StickerSet4, i5);
            }
        });
        stickerSetBulletinLayout.setButton(delayedAction);
        LongSparseArray<Runnable> longSparseArray = this.removingStickerSetsUndos;
        long j = tLRPC$StickerSet.id;
        delayedAction.getClass();
        longSparseArray.put(j, new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda84
            @Override // java.lang.Runnable
            public final void run() {
                delayedAction.undo();
            }
        });
        Bulletin.make(baseFragment, stickerSetBulletinLayout, 2750).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSet$52(TLRPC$StickerSet tLRPC$StickerSet, int i, int i2, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        tLRPC$StickerSet.archived = false;
        this.stickerSets[i].add(i2, tLRPC$TL_messages_stickerSet);
        this.stickerSetsById.put(tLRPC$StickerSet.id, tLRPC$TL_messages_stickerSet);
        this.installedStickerSetsById.put(tLRPC$StickerSet.id, tLRPC$TL_messages_stickerSet);
        this.stickerSetsByName.put(tLRPC$StickerSet.short_name, tLRPC$TL_messages_stickerSet);
        this.removingStickerSetsUndos.remove(tLRPC$StickerSet.id);
        this.loadHash[i] = calcStickersHash(this.stickerSets[i]);
        putStickersToCache(i, this.stickerSets[i], this.loadDate[i], this.loadHash[i]);
        getNotificationCenter().postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSet$53(Context context, int i, BaseFragment baseFragment, boolean z, TLObject tLObject, TLRPC$StickerSet tLRPC$StickerSet, int i2) {
        toggleStickerSetInternal(context, i, baseFragment, z, tLObject, tLRPC$StickerSet, i2, false);
    }

    private void toggleStickerSetInternal(final Context context, int i, final BaseFragment baseFragment, final boolean z, final TLObject tLObject, final TLRPC$StickerSet tLRPC$StickerSet, final int i2, final boolean z2) {
        TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
        tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
        tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
        if (i != 0) {
            TLRPC$TL_messages_installStickerSet tLRPC$TL_messages_installStickerSet = new TLRPC$TL_messages_installStickerSet();
            tLRPC$TL_messages_installStickerSet.stickerset = tLRPC$TL_inputStickerSetID;
            tLRPC$TL_messages_installStickerSet.archived = i == 1;
            getMessagesProxy().toggleStickerSet(tLRPC$TL_messages_installStickerSet, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda118
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$toggleStickerSetInternal$55(tLRPC$StickerSet, baseFragment, z, i2, z2, context, tLObject, tLObject2, tLRPC$TL_error);
                }
            });
            return;
        }
        TLRPC$TL_messages_uninstallStickerSet tLRPC$TL_messages_uninstallStickerSet = new TLRPC$TL_messages_uninstallStickerSet();
        tLRPC$TL_messages_uninstallStickerSet.stickerset = tLRPC$TL_inputStickerSetID;
        getMessagesProxy().toggleStickerSet(tLRPC$TL_messages_uninstallStickerSet, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda117
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toggleStickerSetInternal$57(tLRPC$StickerSet, i2, tLObject2, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSetInternal$55(final TLRPC$StickerSet tLRPC$StickerSet, final BaseFragment baseFragment, final boolean z, final int i, final boolean z2, final Context context, final TLObject tLObject, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda66
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSetInternal$54(tLRPC$StickerSet, tLObject2, baseFragment, z, i, tLRPC$TL_error, z2, context, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSetInternal$54(TLRPC$StickerSet tLRPC$StickerSet, TLObject tLObject, BaseFragment baseFragment, boolean z, int i, TLRPC$TL_error tLRPC$TL_error, boolean z2, Context context, TLObject tLObject2) {
        this.removingStickerSetsUndos.remove(tLRPC$StickerSet.id);
        if (tLObject instanceof TLRPC$TL_messages_stickerSetInstallResultArchive) {
            processStickerSetInstallResultArchive(baseFragment, z, i, (TLRPC$TL_messages_stickerSetInstallResultArchive) tLObject);
        }
        loadStickers(i, false, false, true);
        if (tLRPC$TL_error == null && z2 && baseFragment != null) {
            Bulletin.make(baseFragment, new StickerSetBulletinLayout(context, tLObject2, 2), 1500).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSetInternal$57(final TLRPC$StickerSet tLRPC$StickerSet, final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda64
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSetInternal$56(tLRPC$StickerSet, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSetInternal$56(TLRPC$StickerSet tLRPC$StickerSet, int i) {
        this.removingStickerSetsUndos.remove(tLRPC$StickerSet.id);
        loadStickers(i, false, true);
    }

    public void toggleStickerSets(ArrayList<TLRPC$StickerSet> arrayList, final int i, final int i2, final BaseFragment baseFragment, final boolean z) {
        int i3;
        int size = arrayList.size();
        ArrayList<TLRPC$InputStickerSet> arrayList2 = new ArrayList<>(size);
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            TLRPC$StickerSet tLRPC$StickerSet = arrayList.get(i4);
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
            tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
            tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
            arrayList2.add(tLRPC$TL_inputStickerSetID);
            if (i2 != 0) {
                tLRPC$StickerSet.archived = i2 == 1;
            }
            int size2 = this.stickerSets[i].size();
            int i5 = 0;
            while (true) {
                if (i5 >= size2) {
                    i3 = i4;
                    break;
                }
                TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSets[i].get(i5);
                i3 = i4;
                if (tLRPC$TL_messages_stickerSet.set.id == tLRPC$TL_inputStickerSetID.id) {
                    this.stickerSets[i].remove(i5);
                    if (i2 == 2) {
                        this.stickerSets[i].add(0, tLRPC$TL_messages_stickerSet);
                    } else {
                        this.stickerSetsById.remove(tLRPC$TL_messages_stickerSet.set.id);
                        this.installedStickerSetsById.remove(tLRPC$TL_messages_stickerSet.set.id);
                        this.stickerSetsByName.remove(tLRPC$TL_messages_stickerSet.set.short_name);
                    }
                } else {
                    i5++;
                    i4 = i3;
                }
            }
            i4 = i3 + 1;
        }
        this.loadHash[i] = calcStickersHash(this.stickerSets[i]);
        putStickersToCache(i, this.stickerSets[i], this.loadDate[i], this.loadHash[i]);
        getNotificationCenter().postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(i));
        TLRPC$TL_messages_toggleStickerSets tLRPC$TL_messages_toggleStickerSets = new TLRPC$TL_messages_toggleStickerSets();
        tLRPC$TL_messages_toggleStickerSets.stickersets = arrayList2;
        if (i2 == 0) {
            tLRPC$TL_messages_toggleStickerSets.uninstall = true;
        } else if (i2 == 1) {
            tLRPC$TL_messages_toggleStickerSets.archive = true;
        } else if (i2 == 2) {
            tLRPC$TL_messages_toggleStickerSets.unarchive = true;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_toggleStickerSets, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda103
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toggleStickerSets$59(i2, baseFragment, z, i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSets$59(final int i, final BaseFragment baseFragment, final boolean z, final int i2, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSets$58(i, tLObject, baseFragment, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSets$58(int i, TLObject tLObject, BaseFragment baseFragment, boolean z, int i2) {
        if (i != 0) {
            if (tLObject instanceof TLRPC$TL_messages_stickerSetInstallResultArchive) {
                processStickerSetInstallResultArchive(baseFragment, z, i2, (TLRPC$TL_messages_stickerSetInstallResultArchive) tLObject);
            }
            loadStickers(i2, false, false, true);
            return;
        }
        loadStickers(i2, false, true);
    }

    public void processStickerSetInstallResultArchive(BaseFragment baseFragment, boolean z, int i, TLRPC$TL_messages_stickerSetInstallResultArchive tLRPC$TL_messages_stickerSetInstallResultArchive) {
        int size = tLRPC$TL_messages_stickerSetInstallResultArchive.sets.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.installedStickerSetsById.remove(tLRPC$TL_messages_stickerSetInstallResultArchive.sets.get(i2).set.id);
        }
        loadArchivedStickersCount(i, false);
        getNotificationCenter().postNotificationName(NotificationCenter.needAddArchivedStickers, tLRPC$TL_messages_stickerSetInstallResultArchive.sets);
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        baseFragment.showDialog(new StickersArchiveAlert(baseFragment.getParentActivity(), z ? baseFragment : null, tLRPC$TL_messages_stickerSetInstallResultArchive.sets).create());
    }

    private int getMask() {
        int i = 1;
        if (this.lastReturnedNum >= this.searchResultMessages.size() - 1) {
            boolean[] zArr = this.messagesSearchEndReached;
            if (zArr[0] && zArr[1]) {
                i = 0;
            }
        }
        return this.lastReturnedNum > 0 ? i | 2 : i;
    }

    public ArrayList<MessageObject> getFoundMessageObjects() {
        return this.searchResultMessages;
    }

    public void clearFoundMessageObjects() {
        this.searchResultMessages.clear();
    }

    public boolean isMessageFound(long j, boolean z) {
        return this.searchResultMessagesMap[z ? 1 : 0].indexOfKey(j) >= 0;
    }

    public void searchMessagesInChat(String str, long j, long j2, int i, int i2, long j3, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat) {
        searchMessagesInChat(str, j, j2, i, i2, j3, false, tLRPC$User, tLRPC$Chat, true);
    }

    public void jumpToSearchedMessage(int i, int i2) {
        if (i2 < 0 || i2 >= this.searchResultMessages.size()) {
            return;
        }
        this.lastReturnedNum = i2;
        MessageObject messageObject = this.searchResultMessages.get(i2);
        NotificationCenter notificationCenter = getNotificationCenter();
        int i3 = NotificationCenter.chatSearchResultsAvailable;
        int[] iArr = this.messagesSearchCount;
        notificationCenter.postNotificationName(i3, Integer.valueOf(i), Long.valueOf(messageObject.getId()), Integer.valueOf(getMask()), Long.valueOf(messageObject.getDialogId()), Integer.valueOf(this.lastReturnedNum), Integer.valueOf(iArr[0] + iArr[1]), Boolean.TRUE);
    }

    public void loadMoreSearchMessages() {
        if (this.loadingMoreSearchMessages) {
            return;
        }
        boolean[] zArr = this.messagesSearchEndReached;
        if (zArr[0] && this.lastMergeDialogId == 0 && zArr[1]) {
            return;
        }
        int size = this.searchResultMessages.size();
        this.lastReturnedNum = this.searchResultMessages.size();
        searchMessagesInChat(null, this.lastDialogId, this.lastMergeDialogId, this.lastGuid, 1, this.lastReplyMessageId, false, this.lastSearchUser, this.lastSearchChat, false);
        this.lastReturnedNum = size;
        this.loadingMoreSearchMessages = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0254 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void searchMessagesInChat(java.lang.String r27, final long r28, final long r30, final int r32, final int r33, final long r34, boolean r36, final org.rbmain.tgnet.TLRPC$User r37, final org.rbmain.tgnet.TLRPC$Chat r38, final boolean r39) {
        /*
            Method dump skipped, instructions count: 743
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.searchMessagesInChat(java.lang.String, long, long, int, int, long, boolean, org.rbmain.tgnet.TLRPC$User, org.rbmain.tgnet.TLRPC$Chat, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchMessagesInChat$61(final long j, final TLRPC$TL_messages_search tLRPC$TL_messages_search, final long j2, final int i, final int i2, final long j3, final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchMessagesInChat$60(j, tLObject, tLRPC$TL_messages_search, j2, i, i2, j3, tLRPC$User, tLRPC$Chat, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchMessagesInChat$60(long j, TLObject tLObject, TLRPC$TL_messages_search tLRPC$TL_messages_search, long j2, int i, int i2, long j3, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, boolean z) {
        if (this.lastMergeDialogId == j) {
            this.mergeReqId = 0;
            if (tLObject != null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                this.messagesSearchEndReached[1] = tLRPC$messages_Messages.messages.isEmpty();
                this.messagesSearchCount[1] = tLRPC$messages_Messages instanceof TLRPC$TL_messages_messagesSlice ? tLRPC$messages_Messages.count : tLRPC$messages_Messages.messages.size();
                searchMessagesInChat(tLRPC$TL_messages_search.q, j2, j, i, i2, j3, true, tLRPC$User, tLRPC$Chat, z);
                return;
            }
            this.messagesSearchEndReached[1] = true;
            this.messagesSearchCount[1] = 0;
            searchMessagesInChat(tLRPC$TL_messages_search.q, j2, j, i, i2, j3, true, tLRPC$User, tLRPC$Chat, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchMessagesInChat$63(String str, final int i, final boolean z, final TLRPC$TL_messages_search tLRPC$TL_messages_search, final long j, final long j2, final int i2, final long j3, final long j4, final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final ArrayList arrayList = new ArrayList();
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            int iMin = Math.min(tLRPC$messages_Messages.messages.size(), CloseCodes.NORMAL_CLOSURE);
            for (int i3 = 0; i3 < iMin; i3++) {
                MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$messages_Messages.messages.get(i3), false, false);
                messageObject.setQuery(str);
                arrayList.add(messageObject);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchMessagesInChat$62(i, z, tLObject, tLRPC$TL_messages_search, j, j2, i2, arrayList, j3, j4, tLRPC$User, tLRPC$Chat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchMessagesInChat$62(int i, boolean z, TLObject tLObject, TLRPC$TL_messages_search tLRPC$TL_messages_search, long j, long j2, int i2, ArrayList arrayList, long j3, long j4, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat) {
        if (i == this.lastReqId) {
            this.reqId = 0;
            if (!z) {
                this.loadingMoreSearchMessages = false;
            }
            if (tLObject != null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                int i3 = 0;
                while (i3 < tLRPC$messages_Messages.messages.size()) {
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i3);
                    if ((tLRPC$Message instanceof TLRPC$TL_messageEmpty) || (tLRPC$Message.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                        tLRPC$messages_Messages.messages.remove(i3);
                        i3--;
                    }
                    i3++;
                }
                getMessagesStorage().putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
                getMessagesController().putUsers(tLRPC$messages_Messages.users, false);
                getMessagesController().putChats(tLRPC$messages_Messages.chats, false);
                if (tLRPC$TL_messages_search.offset_id == 0 && j == j2) {
                    this.lastReturnedNum = 0;
                    this.searchResultMessages.clear();
                    this.searchResultMessagesMap[0].clear();
                    this.searchResultMessagesMap[1].clear();
                    this.messagesSearchCount[0] = 0;
                    getNotificationCenter().postNotificationName(NotificationCenter.chatSearchResultsLoading, Integer.valueOf(i2));
                }
                int iMin = Math.min(tLRPC$messages_Messages.messages.size(), CloseCodes.NORMAL_CLOSURE);
                int i4 = 0;
                boolean z2 = false;
                while (i4 < iMin) {
                    tLRPC$messages_Messages.messages.get(i4);
                    MessageObject messageObject = (MessageObject) arrayList.get(i4);
                    this.searchResultMessages.add(messageObject);
                    this.searchResultMessagesMap[j == j2 ? (char) 0 : (char) 1].put(messageObject.getId(), messageObject);
                    i4++;
                    z2 = true;
                }
                this.messagesSearchEndReached[j == j2 ? (char) 0 : (char) 1] = true;
                this.messagesSearchCount[j == j2 ? (char) 0 : (char) 1] = ((tLRPC$messages_Messages instanceof TLRPC$TL_messages_messagesSlice) || (tLRPC$messages_Messages instanceof TLRPC$TL_messages_channelMessages)) ? tLRPC$messages_Messages.count : tLRPC$messages_Messages.messages.size();
                if (this.searchResultMessages.isEmpty()) {
                    getNotificationCenter().postNotificationName(NotificationCenter.chatSearchResultsAvailable, Integer.valueOf(i2), 0L, Integer.valueOf(getMask()), 0L, 0, 0, Boolean.valueOf(z));
                } else if (z2) {
                    if (this.lastReturnedNum >= this.searchResultMessages.size()) {
                        this.lastReturnedNum = this.searchResultMessages.size() - 1;
                    }
                    MessageObject messageObject2 = this.searchResultMessages.get(this.lastReturnedNum);
                    NotificationCenter notificationCenter = getNotificationCenter();
                    int i5 = NotificationCenter.chatSearchResultsAvailable;
                    int[] iArr = this.messagesSearchCount;
                    notificationCenter.postNotificationName(i5, Integer.valueOf(i2), Long.valueOf(messageObject2.getId()), Integer.valueOf(getMask()), Long.valueOf(messageObject2.getDialogId()), Integer.valueOf(this.lastReturnedNum), Integer.valueOf(iArr[0] + iArr[1]), Boolean.valueOf(z));
                }
                if (j == j2) {
                    boolean[] zArr = this.messagesSearchEndReached;
                    if (!zArr[0] || j3 == 0 || zArr[1]) {
                        return;
                    }
                    searchMessagesInChat(this.lastSearchQuery, j2, j3, i2, 0, j4, true, tLRPC$User, tLRPC$Chat, z);
                }
            }
        }
    }

    public String getLastSearchQuery() {
        return this.lastSearchQuery;
    }

    public void loadMedia(long j, int i, long j2, int i2, int i3, int i4) {
        int i5 = (int) j;
        if (i5 < 0) {
            ChatObject.isChannel(-i5, this.currentAccount);
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("load media did " + j + " count = " + i + " max_id " + j2 + " type = " + i2 + " cache = " + i3 + " classGuid = " + i4);
        }
        getAccountInstance().getMediaProxy().loadMedia(j, i, j2, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMediaCounts$64(long j, int[] iArr) {
        getNotificationCenter().postNotificationName(NotificationCenter.mediaCountsDidLoad, Long.valueOf(j), iArr);
    }

    public void getMediaCounts(final long j, int i) {
        final int[] iArr = {100, 100, 100, 0, 100, 0};
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMediaCounts$64(j, iArr);
            }
        });
    }

    public void getMediaCount(final long j, final int i, final int i2, boolean z) {
        int i3 = (int) j;
        if (z || i3 == 0) {
            getMediaCountDatabase(j, i, i2);
            return;
        }
        TLRPC$TL_messages_getSearchCounters tLRPC$TL_messages_getSearchCounters = new TLRPC$TL_messages_getSearchCounters();
        if (i == 0) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterPhotoVideo());
        } else if (i == 1) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterDocument());
        } else if (i == 2) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterRoundVoice());
        } else if (i == 3) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterUrl());
        } else if (i == 4) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterMusic());
        } else if (i == 5) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterGif());
        }
        TLRPC$InputPeer inputPeer = getMessagesController().getInputPeer(i3);
        tLRPC$TL_messages_getSearchCounters.peer = inputPeer;
        if (inputPeer == null) {
            return;
        }
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getSearchCounters, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda105
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getMediaCount$65(j, i, i2, tLObject, tLRPC$TL_error);
            }
        }), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMediaCount$65(long j, int i, int i2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            if (tLRPC$Vector.objects.isEmpty()) {
                return;
            }
            processLoadedMediaCount(100, j, i, i2, false, 0);
        }
    }

    public static int getMediaType(TLRPC$Message tLRPC$Message) {
        if (tLRPC$Message == null) {
            return -1;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            return 0;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            TLRPC$Document tLRPC$Document = tLRPC$MessageMedia.document;
            if (tLRPC$Document == null) {
                return -1;
            }
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            for (int i = 0; i < tLRPC$Document.attributes.size(); i++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                    z = tLRPC$DocumentAttribute.round_message;
                    z2 = !z;
                } else if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAnimated) {
                    z3 = true;
                } else if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                    z = tLRPC$DocumentAttribute.voice;
                    z5 = !z;
                } else if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                    z4 = true;
                }
            }
            if (z) {
                return 2;
            }
            if (z2 && !z3) {
                return 0;
            }
            if (z4) {
                return -1;
            }
            if (z3) {
                return 5;
            }
            return z5 ? 4 : 1;
        }
        if (!tLRPC$Message.entities.isEmpty()) {
            for (int i2 = 0; i2 < tLRPC$Message.entities.size(); i2++) {
                TLRPC$MessageEntity tLRPC$MessageEntity = tLRPC$Message.entities.get(i2);
                if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityUrl) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityTextUrl) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityEmail)) {
                    return 3;
                }
            }
        }
        return -1;
    }

    public static boolean canAddMessageToMedia(TLRPC$Message tLRPC$Message) {
        int i;
        boolean z = tLRPC$Message instanceof TLRPC$TL_message_secret;
        if (z && (((tLRPC$Message.media instanceof TLRPC$TL_messageMediaPhoto) || MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isGifMessage(tLRPC$Message)) && (i = tLRPC$Message.media.ttl_seconds) != 0 && i <= 60)) {
            return false;
        }
        if (!z && (tLRPC$Message instanceof TLRPC$TL_message)) {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument)) && tLRPC$MessageMedia.ttl_seconds != 0) {
                return false;
            }
        }
        return getMediaType(tLRPC$Message) != -1;
    }

    public void processLoadedMedia(final TLRPC$messages_Messages tLRPC$messages_Messages, final long j, int i, long j2, final int i2, final int i3, final int i4, boolean z, final boolean z2) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("process load media did " + j + " count = " + i + " max_id " + j2 + " type = " + i2 + " cache = " + i3 + " classGuid = " + i4);
        }
        int i5 = (int) j;
        if (i3 == 0 || !tLRPC$messages_Messages.messages.isEmpty() || i5 == 0) {
            if (i3 == 0) {
                ImageLoader.saveMessagesThumbs(tLRPC$messages_Messages.messages);
            }
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda75
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedMedia$67(tLRPC$messages_Messages, i3, j, i4, i2, z2);
                }
            });
        } else {
            if (i3 == 2) {
                return;
            }
            loadMedia(j, i, j2, i2, 0, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedMedia$67(final TLRPC$messages_Messages tLRPC$messages_Messages, final int i, final long j, final int i2, final int i3, final boolean z) {
        SparseArray sparseArray = new SparseArray();
        for (int i4 = 0; i4 < tLRPC$messages_Messages.users.size(); i4++) {
            TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i4);
            sparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        final ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < tLRPC$messages_Messages.messages.size(); i5++) {
            MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$messages_Messages.messages.get(i5), (SparseArray<TLRPC$User>) sparseArray, true, true);
            if (!messageObject.isRoundVideo() && !messageObject.isBanned) {
                arrayList.add(messageObject);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda76
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedMedia$66(tLRPC$messages_Messages, i, j, arrayList, i2, i3, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedMedia$66(TLRPC$messages_Messages tLRPC$messages_Messages, int i, long j, ArrayList arrayList, int i2, int i3, boolean z) {
        int i4 = tLRPC$messages_Messages.count;
        getMessagesController().putUsers(tLRPC$messages_Messages.users, i != 0);
        getMessagesController().putChats(tLRPC$messages_Messages.chats, i != 0);
        getNotificationCenter().postNotificationName(NotificationCenter.mediaDidLoad, Long.valueOf(j), Integer.valueOf(i4), arrayList, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
    }

    private void processLoadedMediaCount(final int i, final long j, final int i2, final int i3, final boolean z, final int i4) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedMediaCount$68(j, z, i, i2, i4, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedMediaCount$68(long j, boolean z, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = (int) j;
        boolean z2 = z && (i5 == -1 || (i5 == 0 && i2 == 2)) && i6 != 0;
        if (z2 || (i3 == 1 && i6 != 0)) {
            getMediaCount(j, i2, i4, false);
        }
        if (z2) {
            return;
        }
        if (!z) {
            putMediaCountDatabase(j, i2, i5);
        }
        NotificationCenter notificationCenter = getNotificationCenter();
        int i7 = NotificationCenter.mediaCountDidLoad;
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(j);
        if (z && i5 == -1) {
            i5 = 0;
        }
        objArr[1] = Integer.valueOf(i5);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(i2);
        notificationCenter.postNotificationName(i7, objArr);
    }

    private void putMediaCountDatabase(final long j, final int i, final int i2) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putMediaCountDatabase$69(j, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putMediaCountDatabase$69(long j, int i, int i2) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO media_counts_v2 VALUES(?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, j);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i);
            sQLitePreparedStatementExecuteFast.bindInteger(3, i2);
            sQLitePreparedStatementExecuteFast.bindInteger(4, 0);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void getMediaCountDatabase(long j, int i, int i2) {
        processLoadedMediaCount(100, j, i, i2, true, 0);
    }

    /* renamed from: org.rbmain.messenger.MediaDataController$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int val$classGuid;
        final /* synthetic */ int val$count;
        final /* synthetic */ int val$fromCache;
        final /* synthetic */ boolean val$isChannel;
        final /* synthetic */ long val$max_id;
        final /* synthetic */ int val$type;
        final /* synthetic */ long val$uid;

        AnonymousClass1(int i, long j, long j2, boolean z, int i2, int i3, int i4) {
            this.val$count = i;
            this.val$uid = j;
            this.val$max_id = j2;
            this.val$isChannel = z;
            this.val$type = i2;
            this.val$classGuid = i3;
            this.val$fromCache = i4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00cf  */
        /* JADX WARN: Type inference failed for: r3v10, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v27 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 938
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.AnonymousClass1.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(Runnable runnable, int i) {
            MediaDataController.this.getMessagesStorage().completeTaskForGuid(runnable, i);
        }
    }

    private void loadMediaDatabase(long j, int i, long j2, int i2, int i3, boolean z, int i4) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i, j, j2, z, i2, i3, i4);
        MessagesStorage messagesStorage = getMessagesStorage();
        messagesStorage.getStorageQueue().postRunnable(anonymousClass1);
        messagesStorage.bindTaskToGuid(anonymousClass1, i3);
    }

    private void putMediaDatabase(final long j, final int i, final ArrayList<TLRPC$Message> arrayList, final long j2, final boolean z) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putMediaDatabase$70(arrayList, z, j, j2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putMediaDatabase$70(ArrayList arrayList, boolean z, long j, long j2, int i) {
        try {
            if (arrayList.isEmpty() || z) {
                getMessagesStorage().doneHolesInMedia(j, j2, i);
                if (arrayList.isEmpty()) {
                    return;
                }
            }
            getMessagesStorage().getDatabase().beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO media_v2 VALUES(?, ?, ?, ?, ?)");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) it.next();
                if (canAddMessageToMedia(tLRPC$Message)) {
                    long j3 = tLRPC$Message.id;
                    int i2 = tLRPC$Message.peer_id.channel_id;
                    if (i2 != 0) {
                        j3 |= i2 << 32;
                    }
                    sQLitePreparedStatementExecuteFast.requery();
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                    tLRPC$Message.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindLong(1, j3);
                    sQLitePreparedStatementExecuteFast.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast.bindInteger(3, tLRPC$Message.date);
                    sQLitePreparedStatementExecuteFast.bindInteger(4, i);
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(5, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            if (!z || j2 != 0) {
                long j4 = z ? 1L : ((TLRPC$Message) arrayList.get(arrayList.size() - 1)).id;
                if (j2 != 0) {
                    getMessagesStorage().closeHolesInMedia(j, j4, j2, i);
                } else {
                    getMessagesStorage().closeHolesInMedia(j, j4, 2147483647L, i);
                }
            }
            getMessagesStorage().getDatabase().commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void loadMusic(final long j, final long j2, final long j3) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMusic$72(j, j2, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMusic$72(final long j, long j2, long j3) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int i = (int) j;
        int i2 = 0;
        while (i2 < 2) {
            ArrayList arrayList3 = i2 == 0 ? arrayList : arrayList2;
            if (i2 == 0) {
                if (i != 0) {
                    try {
                        sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid FROM media_v2 WHERE uid = %d AND mid < %d AND type = %d ORDER BY date DESC, mid DESC LIMIT 1000", Long.valueOf(j), Long.valueOf(j2), 4), new Object[0]);
                    } catch (Exception e) {
                        e = e;
                        FileLog.e(e);
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda26
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$loadMusic$71(j, arrayList, arrayList2);
                            }
                        });
                    }
                } else {
                    sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid FROM media_v2 WHERE uid = %d AND mid > %d AND type = %d ORDER BY date DESC, mid DESC LIMIT 1000", Long.valueOf(j), Long.valueOf(j2), 4), new Object[0]);
                }
            } else if (i != 0) {
                sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid FROM media_v2 WHERE uid = %d AND mid > %d AND type = %d ORDER BY date DESC, mid DESC LIMIT 1000", Long.valueOf(j), Long.valueOf(j3), 4), new Object[0]);
            } else {
                sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid FROM media_v2 WHERE uid = %d AND mid < %d AND type = %d ORDER BY date DESC, mid DESC LIMIT 1000", Long.valueOf(j), Long.valueOf(j3), 4), new Object[0]);
            }
            while (sQLiteCursorQueryFinalized.next()) {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    if (MessageObject.isMusicMessage(tLRPC$MessageTLdeserialize)) {
                        tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(1);
                        tLRPC$MessageTLdeserialize.dialog_id = j;
                        try {
                            arrayList3.add(0, new MessageObject(this.currentAccount, tLRPC$MessageTLdeserialize, false, true));
                        } catch (Exception e2) {
                            e = e2;
                            FileLog.e(e);
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda26
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$loadMusic$71(j, arrayList, arrayList2);
                                }
                            });
                        }
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            i2++;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMusic$71(j, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMusic$71(long j, ArrayList arrayList, ArrayList arrayList2) {
        getNotificationCenter().postNotificationName(NotificationCenter.musicDidLoad, Long.valueOf(j), arrayList, arrayList2);
    }

    public void buildShortcuts() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        int maxShortcutCountPerActivity = ShortcutManagerCompat.getMaxShortcutCountPerActivity(ApplicationLoader.applicationContext) - 2;
        if (maxShortcutCountPerActivity <= 0) {
            maxShortcutCountPerActivity = 5;
        }
        final ArrayList arrayList = new ArrayList();
        if (SharedConfig.passcodeHash.length() <= 0) {
            for (int i = 0; i < this.hints.size(); i++) {
                arrayList.add(this.hints.get(i));
                if (arrayList.size() == maxShortcutCountPerActivity - 2) {
                    break;
                }
            }
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$buildShortcuts$73(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0275 A[Catch: all -> 0x02b0, TryCatch #0 {all -> 0x02b0, blocks: (B:56:0x016a, B:71:0x023f, B:73:0x0245, B:76:0x025e, B:78:0x0275, B:80:0x027a, B:82:0x028e, B:84:0x029b, B:86:0x02a6, B:85:0x02a1, B:81:0x0282), top: B:93:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x027a A[Catch: all -> 0x02b0, TryCatch #0 {all -> 0x02b0, blocks: (B:56:0x016a, B:71:0x023f, B:73:0x0245, B:76:0x025e, B:78:0x0275, B:80:0x027a, B:82:0x028e, B:84:0x029b, B:86:0x02a6, B:85:0x02a1, B:81:0x0282), top: B:93:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0282 A[Catch: all -> 0x02b0, TryCatch #0 {all -> 0x02b0, blocks: (B:56:0x016a, B:71:0x023f, B:73:0x0245, B:76:0x025e, B:78:0x0275, B:80:0x027a, B:82:0x028e, B:84:0x029b, B:86:0x02a6, B:85:0x02a1, B:81:0x0282), top: B:93:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x029b A[Catch: all -> 0x02b0, TryCatch #0 {all -> 0x02b0, blocks: (B:56:0x016a, B:71:0x023f, B:73:0x0245, B:76:0x025e, B:78:0x0275, B:80:0x027a, B:82:0x028e, B:84:0x029b, B:86:0x02a6, B:85:0x02a1, B:81:0x0282), top: B:93:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a1 A[Catch: all -> 0x02b0, TryCatch #0 {all -> 0x02b0, blocks: (B:56:0x016a, B:71:0x023f, B:73:0x0245, B:76:0x025e, B:78:0x0275, B:80:0x027a, B:82:0x028e, B:84:0x029b, B:86:0x02a6, B:85:0x02a1, B:81:0x0282), top: B:93:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$buildShortcuts$73(java.util.ArrayList r20) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.lambda$buildShortcuts$73(java.util.ArrayList):void");
    }

    public void loadHints(boolean z) {
        if (this.loading) {
            return;
        }
        this.loading = true;
        TLRPC$TL_contacts_getTopPeers tLRPC$TL_contacts_getTopPeers = new TLRPC$TL_contacts_getTopPeers();
        tLRPC$TL_contacts_getTopPeers.hash = 0;
        tLRPC$TL_contacts_getTopPeers.bots_pm = false;
        tLRPC$TL_contacts_getTopPeers.correspondents = true;
        tLRPC$TL_contacts_getTopPeers.groups = false;
        tLRPC$TL_contacts_getTopPeers.channels = false;
        tLRPC$TL_contacts_getTopPeers.bots_inline = true;
        tLRPC$TL_contacts_getTopPeers.offset = 0;
        tLRPC$TL_contacts_getTopPeers.limit = 20;
        getDialogsProxy().getAllHintDialogs(tLRPC$TL_contacts_getTopPeers, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda97
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadHints$78(tLObject, tLRPC$TL_error);
            }
        });
    }

    private /* synthetic */ void lambda$loadHints$75() {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList<TLRPC$User> arrayList3 = new ArrayList<>();
        final ArrayList<TLRPC$Chat> arrayList4 = new ArrayList<>();
        int clientUserId = getUserConfig().getClientUserId();
        try {
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized("SELECT did, type, rating FROM chat_hints WHERE 1 ORDER BY rating DESC", new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                if (iIntValue != clientUserId) {
                    int iIntValue2 = sQLiteCursorQueryFinalized.intValue(1);
                    TLRPC$TL_topPeer tLRPC$TL_topPeer = new TLRPC$TL_topPeer();
                    tLRPC$TL_topPeer.rating = sQLiteCursorQueryFinalized.doubleValue(2);
                    if (iIntValue > 0) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        tLRPC$TL_topPeer.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = iIntValue;
                        arrayList5.add(Integer.valueOf(iIntValue));
                    } else {
                        TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
                        tLRPC$TL_topPeer.peer = tLRPC$TL_peerChat;
                        int i = -iIntValue;
                        tLRPC$TL_peerChat.chat_id = i;
                        arrayList6.add(Integer.valueOf(i));
                    }
                    if (iIntValue2 == 0) {
                        arrayList.add(tLRPC$TL_topPeer);
                    } else if (iIntValue2 == 1) {
                        arrayList2.add(tLRPC$TL_topPeer);
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (!arrayList5.isEmpty()) {
                getMessagesStorage().getUsersInternal(TextUtils.join(",", arrayList5), arrayList3);
            }
            if (!arrayList6.isEmpty()) {
                getMessagesStorage().getChatsInternal(TextUtils.join(",", arrayList6), arrayList4);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda51
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHints$74(arrayList3, arrayList4, arrayList, arrayList2);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHints$74(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        this.loading = false;
        this.loaded = true;
        this.hints = arrayList3;
        this.inlineBots = arrayList4;
        buildShortcuts();
        getNotificationCenter().postNotificationName(NotificationCenter.reloadHints, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.reloadInlineHints, new Object[0]);
        if (Math.abs(getUserConfig().lastHintsSyncTime - ((int) (System.currentTimeMillis() / 1000))) >= 86400) {
            loadHints(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHints$78(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_contacts_topPeers) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda56
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHints$76(tLObject);
                }
            });
        } else if (tLObject instanceof TLRPC$TL_contacts_topPeersDisabled) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHints$77();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHints$76(TLObject tLObject) {
        this.loading = false;
        TLRPC$TL_contacts_topPeers tLRPC$TL_contacts_topPeers = (TLRPC$TL_contacts_topPeers) tLObject;
        getMessagesController().putUsers(tLRPC$TL_contacts_topPeers.users, false);
        getMessagesController().putChats(tLRPC$TL_contacts_topPeers.chats, false);
        for (int i = 0; i < tLRPC$TL_contacts_topPeers.categories.size(); i++) {
            TLRPC$TL_topPeerCategoryPeers tLRPC$TL_topPeerCategoryPeers = tLRPC$TL_contacts_topPeers.categories.get(i);
            if (tLRPC$TL_topPeerCategoryPeers.category instanceof TLRPC$TL_topPeerCategoryBotsInline) {
                this.inlineBots = tLRPC$TL_topPeerCategoryPeers.peers;
                getUserConfig().botRatingLoadTime = (int) (System.currentTimeMillis() / 1000);
            } else {
                this.hints = tLRPC$TL_topPeerCategoryPeers.peers;
                int clientUserId = getUserConfig().getClientUserId();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.hints.size()) {
                        break;
                    }
                    if (this.hints.get(i2).peer.user_id == clientUserId) {
                        this.hints.remove(i2);
                        break;
                    }
                    i2++;
                }
                getUserConfig().ratingLoadTime = (int) (System.currentTimeMillis() / 1000);
            }
        }
        getUserConfig().saveConfig(false);
        buildShortcuts();
        getNotificationCenter().postNotificationName(NotificationCenter.reloadHints, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.reloadInlineHints, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHints$77() {
        getUserConfig().suggestContacts = false;
        getUserConfig().lastHintsSyncTime = (int) (System.currentTimeMillis() / 1000);
        getUserConfig().saveConfig(false);
        clearTopPeers();
    }

    public void clearTopPeers() {
        this.hints.clear();
        this.inlineBots.clear();
        getNotificationCenter().postNotificationName(NotificationCenter.reloadHints, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.reloadInlineHints, new Object[0]);
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearTopPeers$79();
            }
        });
        buildShortcuts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearTopPeers$79() {
        try {
            getMessagesStorage().getDatabase().executeFast("DELETE FROM chat_hints WHERE 1").stepThis().dispose();
        } catch (Exception unused) {
        }
    }

    public void increaseInlineRaiting(int i) {
        if (getUserConfig().suggestContacts) {
            int iMax = getUserConfig().botRatingLoadTime != 0 ? Math.max(1, ((int) (System.currentTimeMillis() / 1000)) - getUserConfig().botRatingLoadTime) : 60;
            TLRPC$TL_topPeer tLRPC$TL_topPeer = null;
            int i2 = 0;
            while (true) {
                if (i2 >= this.inlineBots.size()) {
                    break;
                }
                TLRPC$TL_topPeer tLRPC$TL_topPeer2 = this.inlineBots.get(i2);
                if (tLRPC$TL_topPeer2.peer.user_id == i) {
                    tLRPC$TL_topPeer = tLRPC$TL_topPeer2;
                    break;
                }
                i2++;
            }
            if (tLRPC$TL_topPeer == null) {
                tLRPC$TL_topPeer = new TLRPC$TL_topPeer();
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_topPeer.peer = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = i;
                this.inlineBots.add(tLRPC$TL_topPeer);
            }
            tLRPC$TL_topPeer.rating += Math.exp(iMax / getMessagesController().ratingDecay);
            Collections.sort(this.inlineBots, new Comparator() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda91
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return MediaDataController.lambda$increaseInlineRaiting$80((TLRPC$TL_topPeer) obj, (TLRPC$TL_topPeer) obj2);
                }
            });
            if (this.inlineBots.size() > 20) {
                ArrayList<TLRPC$TL_topPeer> arrayList = this.inlineBots;
                arrayList.remove(arrayList.size() - 1);
            }
            savePeer(i, 1, tLRPC$TL_topPeer.rating);
            getNotificationCenter().postNotificationName(NotificationCenter.reloadInlineHints, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$increaseInlineRaiting$80(TLRPC$TL_topPeer tLRPC$TL_topPeer, TLRPC$TL_topPeer tLRPC$TL_topPeer2) {
        double d = tLRPC$TL_topPeer.rating;
        double d2 = tLRPC$TL_topPeer2.rating;
        if (d > d2) {
            return -1;
        }
        return d < d2 ? 1 : 0;
    }

    public void removeInline(int i) {
        for (int i2 = 0; i2 < this.inlineBots.size(); i2++) {
            if (this.inlineBots.get(i2).peer.user_id == i) {
                this.inlineBots.remove(i2);
                TLRPC$TL_contacts_resetTopPeerRating tLRPC$TL_contacts_resetTopPeerRating = new TLRPC$TL_contacts_resetTopPeerRating();
                tLRPC$TL_contacts_resetTopPeerRating.category = new TLRPC$TL_topPeerCategoryBotsInline();
                tLRPC$TL_contacts_resetTopPeerRating.peer = getMessagesController().getInputPeer(i);
                getConnectionsManager().sendRequest(tLRPC$TL_contacts_resetTopPeerRating, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda126
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        MediaDataController.lambda$removeInline$81(tLObject, tLRPC$TL_error);
                    }
                });
                deletePeer(i, 1);
                getNotificationCenter().postNotificationName(NotificationCenter.reloadInlineHints, new Object[0]);
                return;
            }
        }
    }

    public void removePeer(int i) {
        for (int i2 = 0; i2 < this.hints.size(); i2++) {
            if (this.hints.get(i2).peer.user_id == i) {
                this.hints.remove(i2);
                getNotificationCenter().postNotificationName(NotificationCenter.reloadHints, new Object[0]);
                TLRPC$TL_contacts_resetTopPeerRating tLRPC$TL_contacts_resetTopPeerRating = new TLRPC$TL_contacts_resetTopPeerRating();
                tLRPC$TL_contacts_resetTopPeerRating.category = new TLRPC$TL_topPeerCategoryCorrespondents();
                tLRPC$TL_contacts_resetTopPeerRating.peer = getMessagesController().getInputPeer(i);
                deletePeer(i, 0);
                getDialogsProxy().removeChatHint(tLRPC$TL_contacts_resetTopPeerRating, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda125
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        MediaDataController.lambda$removePeer$82(tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
        }
    }

    private void savePeer(final int i, final int i2, final double d) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$savePeer$83(i, i2, d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$savePeer$83(int i, int i2, double d) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO chat_hints VALUES(?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            sQLitePreparedStatementExecuteFast.bindDouble(3, d);
            sQLitePreparedStatementExecuteFast.bindInteger(4, ((int) System.currentTimeMillis()) / CloseCodes.NORMAL_CLOSURE);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void deletePeer(final int i, final int i2) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deletePeer$84(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deletePeer$84(int i, int i2) {
        try {
            getMessagesStorage().getDatabase().executeFast(String.format(Locale.US, "DELETE FROM chat_hints WHERE did = %d AND type = %d", Integer.valueOf(i), Integer.valueOf(i2))).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private Intent createIntrnalShortcutIntent(long j) {
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) OpenChatReceiver.class);
        int i = (int) j;
        int i2 = (int) (j >> 32);
        String dialogId = IdStorage.getInstance().getDialogId(j);
        ChatType chatType = getDialogsProxy().getChatType(j);
        if (chatType == null) {
            return null;
        }
        intent.putExtra("object_guid", dialogId);
        intent.putExtra("object_type", chatType.name());
        if (i == 0) {
            intent.putExtra("encId", i2);
            if (getMessagesController().getEncryptedChat(Integer.valueOf(i2)) == null) {
                return null;
            }
        } else if (i > 0) {
            intent.putExtra("userId", i);
        } else {
            if (i >= 0) {
                return null;
            }
            intent.putExtra("chatId", -i);
        }
        intent.putExtra("currentAccount", this.currentAccount);
        intent.setAction("com.tmessages.openchat" + j);
        intent.addFlags(ConnectionsManager.FileTypeFile);
        return intent;
    }

    private Intent createIntrnalShortcutIntent(Link link) {
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) LaunchActivity.class);
        intent.setAction("android.intent.action.MAIN");
        if (link != null) {
            intent.putExtra("link", ApplicationLoader.getGson().toJson(link));
        }
        return intent;
    }

    public boolean updateShortcutIfExist(Context context, Link link, Bitmap bitmap, String str, String str2) {
        ShortcutManager shortcutManager;
        if (str2 != null && Build.VERSION.SDK_INT >= 25 && (shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class)) != null) {
            Iterator<ShortcutInfo> it = shortcutManager.getPinnedShortcuts().iterator();
            while (it.hasNext()) {
                if (str2.equals(it.next().getId())) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new ShortcutInfo.Builder(context, str2).setShortLabel(str).setIntent(createIntrnalShortcutIntent(link)).setIcon(Icon.createWithBitmap(bitmap)).build());
                    shortcutManager.updateShortcuts(arrayList);
                    MyLog.e("ShortcutHelper", "shortcut update");
                    return true;
                }
            }
        }
        return false;
    }

    public void installShortcut(Link link, Bitmap bitmap, String str, String str2) {
        try {
            Intent intentCreateIntrnalShortcutIntent = createIntrnalShortcutIntent(link);
            if (Build.VERSION.SDK_INT >= 26) {
                ShortcutInfoCompat.Builder intent = new ShortcutInfoCompat.Builder(ApplicationLoader.applicationContext, str2).setShortLabel(str).setIntent(intentCreateIntrnalShortcutIntent);
                if (bitmap != null) {
                    intent.setIcon(IconCompat.createWithBitmap(bitmap));
                }
                ShortcutManagerCompat.requestPinShortcut(ApplicationLoader.applicationContext, intent.build(), null);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058 A[Catch: Exception -> 0x023f, TryCatch #1 {Exception -> 0x023f, blocks: (B:3:0x0002, B:5:0x000f, B:8:0x001e, B:19:0x0058, B:21:0x005e, B:64:0x0166, B:66:0x0178, B:68:0x0191, B:81:0x01d2, B:70:0x019b, B:72:0x019f, B:73:0x01a9, B:75:0x01b5, B:77:0x01bb, B:79:0x01bf, B:80:0x01c9, B:82:0x01dc, B:84:0x01e3, B:99:0x0224, B:88:0x01ed, B:90:0x01f1, B:91:0x01fb, B:93:0x0207, B:95:0x020d, B:97:0x0211, B:98:0x021b, B:63:0x0163, B:23:0x006a, B:25:0x0070, B:26:0x007a, B:28:0x0086, B:29:0x0089, B:31:0x008f, B:10:0x002f, B:13:0x0040), top: B:108:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[Catch: Exception -> 0x023f, TryCatch #1 {Exception -> 0x023f, blocks: (B:3:0x0002, B:5:0x000f, B:8:0x001e, B:19:0x0058, B:21:0x005e, B:64:0x0166, B:66:0x0178, B:68:0x0191, B:81:0x01d2, B:70:0x019b, B:72:0x019f, B:73:0x01a9, B:75:0x01b5, B:77:0x01bb, B:79:0x01bf, B:80:0x01c9, B:82:0x01dc, B:84:0x01e3, B:99:0x0224, B:88:0x01ed, B:90:0x01f1, B:91:0x01fb, B:93:0x0207, B:95:0x020d, B:97:0x0211, B:98:0x021b, B:63:0x0163, B:23:0x006a, B:25:0x0070, B:26:0x007a, B:28:0x0086, B:29:0x0089, B:31:0x008f, B:10:0x002f, B:13:0x0040), top: B:108:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092 A[PHI: r8
      0x0092: PHI (r8v1 java.lang.String) = (r8v0 java.lang.String), (r8v7 java.lang.String) binds: [B:30:0x008d, B:27:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[Catch: all -> 0x0162, TryCatch #2 {all -> 0x0162, blocks: (B:48:0x00b6, B:50:0x00ca, B:52:0x00d5, B:54:0x00de, B:59:0x0134, B:60:0x015d, B:53:0x00db, B:55:0x00e5, B:57:0x00f0, B:58:0x00fe), top: B:109:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e5 A[Catch: all -> 0x0162, TryCatch #2 {all -> 0x0162, blocks: (B:48:0x00b6, B:50:0x00ca, B:52:0x00d5, B:54:0x00de, B:59:0x0134, B:60:0x015d, B:53:0x00db, B:55:0x00e5, B:57:0x00f0, B:58:0x00fe), top: B:109:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0178 A[Catch: Exception -> 0x023f, TryCatch #1 {Exception -> 0x023f, blocks: (B:3:0x0002, B:5:0x000f, B:8:0x001e, B:19:0x0058, B:21:0x005e, B:64:0x0166, B:66:0x0178, B:68:0x0191, B:81:0x01d2, B:70:0x019b, B:72:0x019f, B:73:0x01a9, B:75:0x01b5, B:77:0x01bb, B:79:0x01bf, B:80:0x01c9, B:82:0x01dc, B:84:0x01e3, B:99:0x0224, B:88:0x01ed, B:90:0x01f1, B:91:0x01fb, B:93:0x0207, B:95:0x020d, B:97:0x0211, B:98:0x021b, B:63:0x0163, B:23:0x006a, B:25:0x0070, B:26:0x007a, B:28:0x0086, B:29:0x0089, B:31:0x008f, B:10:0x002f, B:13:0x0040), top: B:108:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01dc A[Catch: Exception -> 0x023f, TryCatch #1 {Exception -> 0x023f, blocks: (B:3:0x0002, B:5:0x000f, B:8:0x001e, B:19:0x0058, B:21:0x005e, B:64:0x0166, B:66:0x0178, B:68:0x0191, B:81:0x01d2, B:70:0x019b, B:72:0x019f, B:73:0x01a9, B:75:0x01b5, B:77:0x01bb, B:79:0x01bf, B:80:0x01c9, B:82:0x01dc, B:84:0x01e3, B:99:0x0224, B:88:0x01ed, B:90:0x01f1, B:91:0x01fb, B:93:0x0207, B:95:0x020d, B:97:0x0211, B:98:0x021b, B:63:0x0163, B:23:0x006a, B:25:0x0070, B:26:0x007a, B:28:0x0086, B:29:0x0089, B:31:0x008f, B:10:0x002f, B:13:0x0040), top: B:108:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void installShortcut(long r17) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.installShortcut(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0099 A[Catch: Exception -> 0x00c9, TryCatch #0 {Exception -> 0x00c9, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x0039, B:7:0x004b, B:9:0x0053, B:12:0x0062, B:22:0x0099, B:24:0x00a4, B:23:0x00a2, B:14:0x0073, B:17:0x0085), top: B:30:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2 A[Catch: Exception -> 0x00c9, TryCatch #0 {Exception -> 0x00c9, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x0039, B:7:0x004b, B:9:0x0053, B:12:0x0062, B:22:0x0099, B:24:0x00a4, B:23:0x00a2, B:14:0x0073, B:17:0x0085), top: B:30:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void uninstallShortcut(long r7) {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lc9
            r1 = 26
            r2 = 0
            if (r0 < r1) goto L4b
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lc9
            r1.<init>()     // Catch: java.lang.Exception -> Lc9
            androidMessenger.proxy.IdStorage r3 = androidMessenger.proxy.IdStorage.getInstance()     // Catch: java.lang.Exception -> Lc9
            java.lang.String r3 = r3.getDialogId(r7)     // Catch: java.lang.Exception -> Lc9
            r1.add(r3)     // Catch: java.lang.Exception -> Lc9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc9
            r3.<init>()     // Catch: java.lang.Exception -> Lc9
            java.lang.String r4 = "ndid_"
            r3.append(r4)     // Catch: java.lang.Exception -> Lc9
            r3.append(r7)     // Catch: java.lang.Exception -> Lc9
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Exception -> Lc9
            r1.add(r7)     // Catch: java.lang.Exception -> Lc9
            android.content.Context r7 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Lc9
            androidx.core.content.pm.ShortcutManagerCompat.disableShortcuts(r7, r1, r2)     // Catch: java.lang.Exception -> Lc9
            android.content.Context r7 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Lc9
            androidx.core.content.pm.ShortcutManagerCompat.removeDynamicShortcuts(r7, r1)     // Catch: java.lang.Exception -> Lc9
            r7 = 30
            if (r0 < r7) goto Lcd
            android.content.Context r7 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Lc9
            java.lang.Class<android.content.pm.ShortcutManager> r8 = android.content.pm.ShortcutManager.class
            java.lang.Object r7 = r7.getSystemService(r8)     // Catch: java.lang.Exception -> Lc9
            android.content.pm.ShortcutManager r7 = (android.content.pm.ShortcutManager) r7     // Catch: java.lang.Exception -> Lc9
            r7.disableShortcuts(r1)     // Catch: java.lang.Exception -> Lc9
            r7.removeLongLivedShortcuts(r1)     // Catch: java.lang.Exception -> Lc9
            goto Lcd
        L4b:
            int r0 = (int) r7     // Catch: java.lang.Exception -> Lc9
            r1 = 32
            long r3 = r7 >> r1
            int r1 = (int) r3     // Catch: java.lang.Exception -> Lc9
            if (r0 != 0) goto L71
            org.rbmain.messenger.MessagesController r0 = r6.getMessagesController()     // Catch: java.lang.Exception -> Lc9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> Lc9
            org.rbmain.tgnet.TLRPC$EncryptedChat r0 = r0.getEncryptedChat(r1)     // Catch: java.lang.Exception -> Lc9
            if (r0 != 0) goto L62
            return
        L62:
            org.rbmain.messenger.MessagesController r1 = r6.getMessagesController()     // Catch: java.lang.Exception -> Lc9
            int r0 = r0.user_id     // Catch: java.lang.Exception -> Lc9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> Lc9
            org.rbmain.tgnet.TLRPC$User r0 = r1.getUser(r0)     // Catch: java.lang.Exception -> Lc9
            goto L7f
        L71:
            if (r0 <= 0) goto L83
            org.rbmain.messenger.MessagesController r1 = r6.getMessagesController()     // Catch: java.lang.Exception -> Lc9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> Lc9
            org.rbmain.tgnet.TLRPC$User r0 = r1.getUser(r0)     // Catch: java.lang.Exception -> Lc9
        L7f:
            r5 = r2
            r2 = r0
            r0 = r5
            goto L92
        L83:
            if (r0 >= 0) goto Lc8
            org.rbmain.messenger.MessagesController r1 = r6.getMessagesController()     // Catch: java.lang.Exception -> Lc9
            int r0 = -r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> Lc9
            org.rbmain.tgnet.TLRPC$Chat r0 = r1.getChat(r0)     // Catch: java.lang.Exception -> Lc9
        L92:
            if (r2 != 0) goto L97
            if (r0 != 0) goto L97
            return
        L97:
            if (r2 == 0) goto La2
            java.lang.String r0 = r2.first_name     // Catch: java.lang.Exception -> Lc9
            java.lang.String r1 = r2.last_name     // Catch: java.lang.Exception -> Lc9
            java.lang.String r0 = org.rbmain.messenger.ContactsController.formatName(r0, r1)     // Catch: java.lang.Exception -> Lc9
            goto La4
        La2:
            java.lang.String r0 = r0.title     // Catch: java.lang.Exception -> Lc9
        La4:
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> Lc9
            r1.<init>()     // Catch: java.lang.Exception -> Lc9
            java.lang.String r2 = "android.intent.extra.shortcut.INTENT"
            android.content.Intent r7 = r6.createIntrnalShortcutIntent(r7)     // Catch: java.lang.Exception -> Lc9
            r1.putExtra(r2, r7)     // Catch: java.lang.Exception -> Lc9
            java.lang.String r7 = "android.intent.extra.shortcut.NAME"
            r1.putExtra(r7, r0)     // Catch: java.lang.Exception -> Lc9
            java.lang.String r7 = "duplicate"
            r8 = 0
            r1.putExtra(r7, r8)     // Catch: java.lang.Exception -> Lc9
            java.lang.String r7 = "com.android.launcher.action.UNINSTALL_SHORTCUT"
            r1.setAction(r7)     // Catch: java.lang.Exception -> Lc9
            android.content.Context r7 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Lc9
            r7.sendBroadcast(r1)     // Catch: java.lang.Exception -> Lc9
            goto Lcd
        Lc8:
            return
        Lc9:
            r7 = move-exception
            org.rbmain.messenger.FileLog.e(r7)
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.uninstallShortcut(long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$85(TLRPC$MessageEntity tLRPC$MessageEntity, TLRPC$MessageEntity tLRPC$MessageEntity2) {
        int i = tLRPC$MessageEntity.offset;
        int i2 = tLRPC$MessageEntity2.offset;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPinnedMessages$86(long j, int i, ArrayList arrayList) {
        loadPinnedMessageInternal(j, i, arrayList, false);
    }

    public ArrayList<MessageObject> loadPinnedMessages(final long j, final int i, final ArrayList<Long> arrayList, boolean z) {
        if (z) {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadPinnedMessages$86(j, i, arrayList);
                }
            });
            return null;
        }
        return loadPinnedMessageInternal(j, i, arrayList, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.lang.StringBuilder] */
    private ArrayList<MessageObject> loadPinnedMessageInternal(final long j, final int i, ArrayList<Long> arrayList, boolean z) {
        ?? Join;
        String str;
        ArrayList<TLRPC$Chat> arrayList2;
        String str2;
        try {
            ArrayList<Long> arrayList3 = new ArrayList<>(arrayList);
            String str3 = ",";
            if (i != 0) {
                Join = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    long jLongValue = arrayList.get(i2).longValue() | (i << 32);
                    if (Join.length() != 0) {
                        Join.append(",");
                    }
                    Join.append(jLongValue);
                }
            } else {
                Join = TextUtils.join(",", arrayList);
            }
            ArrayList<TLRPC$Message> arrayList4 = new ArrayList<>();
            ArrayList<TLRPC$User> arrayList5 = new ArrayList<>();
            ArrayList<TLRPC$Chat> arrayList6 = new ArrayList<>();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            int i3 = 1;
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid, date FROM messages WHERE mid IN (%s)", new Object[]{Join}), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$MessageTLdeserialize.action instanceof TLRPC$TL_messageActionHistoryClear) {
                        str2 = str3;
                        tLRPC$MessageTLdeserialize = null;
                    } else {
                        str2 = str3;
                        tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(i3);
                        tLRPC$MessageTLdeserialize.date = sQLiteCursorQueryFinalized.intValue(2);
                        tLRPC$MessageTLdeserialize.dialog_id = j;
                        MessagesStorage.addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList7, arrayList8);
                        arrayList4.add(tLRPC$MessageTLdeserialize);
                    }
                    arrayList3.remove(Long.valueOf(tLRPC$MessageTLdeserialize.id));
                } else {
                    str2 = str3;
                }
                str3 = str2;
                i3 = 1;
            }
            String str4 = str3;
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList3.isEmpty()) {
                str = str4;
            } else {
                str = str4;
                SQLiteCursor sQLiteCursorQueryFinalized2 = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data FROM chat_pinned_v2 WHERE uid = %d AND mid IN (%s)", Long.valueOf(j), TextUtils.join(str, arrayList3)), new Object[0]);
                while (sQLiteCursorQueryFinalized2.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue2 = sQLiteCursorQueryFinalized2.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue2 != null) {
                        TLRPC$Message tLRPC$MessageTLdeserialize2 = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue2, nativeByteBufferByteBufferValue2.readInt32(false), false);
                        tLRPC$MessageTLdeserialize2.readAttachPath(nativeByteBufferByteBufferValue2, getUserConfig().clientUserId);
                        nativeByteBufferByteBufferValue2.reuse();
                        if (tLRPC$MessageTLdeserialize2.action instanceof TLRPC$TL_messageActionHistoryClear) {
                            tLRPC$MessageTLdeserialize2 = null;
                        } else {
                            tLRPC$MessageTLdeserialize2.dialog_id = j;
                            MessagesStorage.addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize2, arrayList7, arrayList8);
                            arrayList4.add(tLRPC$MessageTLdeserialize2);
                        }
                        arrayList3.remove(Long.valueOf(tLRPC$MessageTLdeserialize2.id));
                    }
                }
                sQLiteCursorQueryFinalized2.dispose();
            }
            if (!arrayList3.isEmpty()) {
                if (i != 0) {
                    final TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                    tLRPC$TL_channels_getMessages.channel = getMessagesController().getInputChannel(i);
                    tLRPC$TL_channels_getMessages.id = arrayList3;
                    getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda101
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$loadPinnedMessageInternal$87(i, j, tLRPC$TL_channels_getMessages, tLObject, tLRPC$TL_error);
                        }
                    });
                } else {
                    final TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages = new TLRPC$TL_messages_getMessages();
                    tLRPC$TL_messages_getMessages.id = arrayList3;
                    try {
                        getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda108
                            @Override // org.rbmain.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$loadPinnedMessageInternal$88(j, tLRPC$TL_messages_getMessages, tLObject, tLRPC$TL_error);
                            }
                        });
                    } catch (Exception e) {
                        e = e;
                        FileLog.e(e);
                        return null;
                    }
                }
            }
            if (arrayList4.isEmpty()) {
                return null;
            }
            if (!arrayList7.isEmpty()) {
                getMessagesStorage().getUsersInternal(TextUtils.join(str, arrayList7), arrayList5);
            }
            if (arrayList8.isEmpty()) {
                arrayList2 = arrayList6;
            } else {
                arrayList2 = arrayList6;
                getMessagesStorage().getChatsInternal(TextUtils.join(str, arrayList8), arrayList2);
            }
            if (z) {
                return broadcastPinnedMessage(arrayList4, arrayList5, arrayList2, true, true);
            }
            broadcastPinnedMessage(arrayList4, arrayList5, arrayList2, true, false);
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadPinnedMessageInternal$87(int r14, long r15, org.rbmain.tgnet.TLRPC$TL_channels_getMessages r17, org.rbmain.tgnet.TLObject r18, org.rbmain.tgnet.TLRPC$TL_error r19) {
        /*
            r13 = this;
            r0 = 1
            if (r19 != 0) goto L43
            r1 = r18
            org.rbmain.tgnet.TLRPC$messages_Messages r1 = (org.rbmain.tgnet.TLRPC$messages_Messages) r1
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r2 = r1.messages
            removeEmptyMessages(r2)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r2 = r1.messages
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L43
            org.rbmain.messenger.MessagesController r2 = r13.getMessagesController()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            r2.getChat(r3)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r2 = r1.messages
            org.rbmain.messenger.ImageLoader.saveMessagesThumbs(r2)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r4 = r1.messages
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$User> r5 = r1.users
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r6 = r1.chats
            r7 = 0
            r8 = 0
            r3 = r13
            r3.broadcastPinnedMessage(r4, r5, r6, r7, r8)
            org.rbmain.messenger.MessagesStorage r2 = r13.getMessagesStorage()
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$User> r3 = r1.users
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r4 = r1.chats
            r2.putUsersAndChats(r3, r4, r0, r0)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r1 = r1.messages
            r2 = r13
            r4 = r15
            r13.savePinnedMessages(r4, r1)
            goto L46
        L43:
            r2 = r13
            r4 = r15
            r0 = 0
        L46:
            if (r0 != 0) goto L5a
            org.rbmain.messenger.MessagesStorage r3 = r13.getMessagesStorage()
            r0 = r17
            java.util.ArrayList<java.lang.Long> r6 = r0.id
            r7 = 0
            r8 = -1
            r9 = 0
            r11 = 0
            r12 = 0
            r4 = r15
            r3.updatePinnedMessages(r4, r6, r7, r8, r9, r11, r12)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.lambda$loadPinnedMessageInternal$87(int, long, org.rbmain.tgnet.TLRPC$TL_channels_getMessages, org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadPinnedMessageInternal$88(long r14, org.rbmain.tgnet.TLRPC$TL_messages_getMessages r16, org.rbmain.tgnet.TLObject r17, org.rbmain.tgnet.TLRPC$TL_error r18) {
        /*
            r13 = this;
            r0 = 1
            if (r18 != 0) goto L38
            r1 = r17
            org.rbmain.tgnet.TLRPC$messages_Messages r1 = (org.rbmain.tgnet.TLRPC$messages_Messages) r1
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r2 = r1.messages
            removeEmptyMessages(r2)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r2 = r1.messages
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L38
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r2 = r1.messages
            org.rbmain.messenger.ImageLoader.saveMessagesThumbs(r2)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r4 = r1.messages
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$User> r5 = r1.users
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r6 = r1.chats
            r7 = 0
            r8 = 0
            r3 = r13
            r3.broadcastPinnedMessage(r4, r5, r6, r7, r8)
            org.rbmain.messenger.MessagesStorage r2 = r13.getMessagesStorage()
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$User> r3 = r1.users
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r4 = r1.chats
            r2.putUsersAndChats(r3, r4, r0, r0)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r1 = r1.messages
            r2 = r13
            r4 = r14
            r13.savePinnedMessages(r14, r1)
            goto L3b
        L38:
            r2 = r13
            r4 = r14
            r0 = 0
        L3b:
            if (r0 != 0) goto L4f
            org.rbmain.messenger.MessagesStorage r3 = r13.getMessagesStorage()
            r0 = r16
            java.util.ArrayList<java.lang.Long> r6 = r0.id
            r7 = 0
            r8 = -1
            r9 = 0
            r11 = 0
            r12 = 0
            r4 = r14
            r3.updatePinnedMessages(r4, r6, r7, r8, r9, r11, r12)
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.lambda$loadPinnedMessageInternal$88(long, org.rbmain.tgnet.TLRPC$TL_messages_getMessages, org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
    }

    private void savePinnedMessages(final long j, final ArrayList<TLRPC$Message> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$savePinnedMessages$89(arrayList, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$savePinnedMessages$89(ArrayList arrayList, long j) {
        try {
            getMessagesStorage().getDatabase().beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO chat_pinned_v2 VALUES(?, ?, ?)");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList.get(i);
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                tLRPC$Message.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                sQLitePreparedStatementExecuteFast.bindLong(2, tLRPC$Message.id);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            getMessagesStorage().getDatabase().commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private ArrayList<MessageObject> broadcastPinnedMessage(final ArrayList<TLRPC$Message> arrayList, final ArrayList<TLRPC$User> arrayList2, final ArrayList<TLRPC$Chat> arrayList3, final boolean z, boolean z2) {
        if (arrayList.isEmpty()) {
            return null;
        }
        final SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < arrayList2.size(); i++) {
            TLRPC$User tLRPC$User = arrayList2.get(i);
            sparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        final SparseArray sparseArray2 = new SparseArray();
        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
            TLRPC$Chat tLRPC$Chat = arrayList3.get(i2);
            sparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
        }
        final ArrayList<MessageObject> arrayList4 = new ArrayList<>();
        if (z2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda53
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$broadcastPinnedMessage$90(arrayList2, z, arrayList3);
                }
            });
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                TLRPC$Message tLRPC$Message = arrayList.get(i4);
                TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
                if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto)) {
                    i3++;
                }
                int i5 = i3;
                arrayList4.add(new MessageObject(this.currentAccount, tLRPC$Message, (SparseArray<TLRPC$User>) sparseArray, (SparseArray<TLRPC$Chat>) sparseArray2, false, i5 < 30));
                i4++;
                i3 = i5;
            }
            return arrayList4;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$broadcastPinnedMessage$92(arrayList2, z, arrayList3, arrayList, arrayList4, sparseArray, sparseArray2);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$broadcastPinnedMessage$90(ArrayList arrayList, boolean z, ArrayList arrayList2) {
        getMessagesController().putUsers(arrayList, z);
        getMessagesController().putChats(arrayList2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$broadcastPinnedMessage$92(ArrayList arrayList, boolean z, ArrayList arrayList2, ArrayList arrayList3, final ArrayList arrayList4, SparseArray sparseArray, SparseArray sparseArray2) {
        getMessagesController().putUsers(arrayList, z);
        getMessagesController().putChats(arrayList2, z);
        int size = arrayList3.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList3.get(i2);
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto)) {
                i++;
            }
            arrayList4.add(new MessageObject(this.currentAccount, tLRPC$Message, (SparseArray<TLRPC$User>) sparseArray, (SparseArray<TLRPC$Chat>) sparseArray2, false, i < 30));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$broadcastPinnedMessage$91(arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$broadcastPinnedMessage$91(ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.didLoadPinnedMessages, Long.valueOf(((MessageObject) arrayList.get(0)).getDialogId()), null, Boolean.TRUE, arrayList, null, 0, -1, Boolean.FALSE);
    }

    private static void removeEmptyMessages(ArrayList<TLRPC$Message> arrayList) {
        int i = 0;
        while (i < arrayList.size()) {
            TLRPC$Message tLRPC$Message = arrayList.get(i);
            if (tLRPC$Message == null || (tLRPC$Message instanceof TLRPC$TL_messageEmpty) || (tLRPC$Message.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                arrayList.remove(i);
                i--;
            }
            i++;
        }
    }

    public void loadReplyMessagesForMessages(ArrayList<MessageObject> arrayList, long j, boolean z, Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    private void saveReplyMessages(final LongSparseArray<ArrayList<MessageObject>> longSparseArray, final ArrayList<TLRPC$Message> arrayList, final boolean z) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda80
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveReplyMessages$93(z, arrayList, longSparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveReplyMessages$93(boolean z, ArrayList arrayList, LongSparseArray longSparseArray) {
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast;
        try {
            getMessagesStorage().getDatabase().beginTransaction();
            if (z) {
                sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("UPDATE scheduled_messages SET replydata = ? WHERE mid = ?");
            } else {
                sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("UPDATE messages SET replydata = ? WHERE mid = ?");
            }
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList.get(i);
                ArrayList arrayList2 = (ArrayList) longSparseArray.get(MessageObject.getIdWithChannel(tLRPC$Message));
                if (arrayList2 != null) {
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                    tLRPC$Message.serializeToStream(nativeByteBuffer);
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        MessageObject messageObject = (MessageObject) arrayList2.get(i2);
                        sQLitePreparedStatementExecuteFast.requery();
                        long id = messageObject.getId();
                        int i3 = messageObject.messageOwner.peer_id.channel_id;
                        if (i3 != 0) {
                            id |= i3 << 32;
                        }
                        sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                        sQLitePreparedStatementExecuteFast.bindLong(2, id);
                        sQLitePreparedStatementExecuteFast.step();
                    }
                    nativeByteBuffer.reuse();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            getMessagesStorage().getDatabase().commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void broadcastReplyMessages(ArrayList<TLRPC$Message> arrayList, final LongSparseArray<ArrayList<MessageObject>> longSparseArray, final ArrayList<TLRPC$User> arrayList2, final ArrayList<TLRPC$Chat> arrayList3, final long j, final boolean z) {
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < arrayList2.size(); i++) {
            TLRPC$User tLRPC$User = arrayList2.get(i);
            sparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        SparseArray sparseArray2 = new SparseArray();
        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
            TLRPC$Chat tLRPC$Chat = arrayList3.get(i2);
            sparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
        }
        final ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList4.add(new MessageObject(this.currentAccount, arrayList.get(i3), (SparseArray<TLRPC$User>) sparseArray, (SparseArray<TLRPC$Chat>) sparseArray2, false, false));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda54
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$broadcastReplyMessages$94(arrayList2, z, arrayList3, arrayList4, longSparseArray, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$broadcastReplyMessages$94(ArrayList arrayList, boolean z, ArrayList arrayList2, ArrayList arrayList3, LongSparseArray longSparseArray, long j) {
        getMessagesController().putUsers(arrayList, z);
        getMessagesController().putChats(arrayList2, z);
        int size = arrayList3.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            MessageObject messageObject = (MessageObject) arrayList3.get(i);
            ArrayList arrayList4 = (ArrayList) longSparseArray.get(messageObject.getIdWithChannel());
            if (arrayList4 != null) {
                for (int i2 = 0; i2 < arrayList4.size(); i2++) {
                    MessageObject messageObject2 = (MessageObject) arrayList4.get(i2);
                    messageObject2.replyMessageObject = messageObject;
                    TLRPC$MessageAction tLRPC$MessageAction = messageObject2.messageOwner.action;
                    if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionPinMessage) {
                        messageObject2.generatePinMessageText(null, null);
                    } else if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionGameScore) {
                        messageObject2.generateGameMessageText(null);
                    } else if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionPaymentSent) {
                        messageObject2.generatePaymentSentMessageText(null);
                    }
                }
                z2 = true;
            }
        }
        if (z2) {
            getNotificationCenter().postNotificationName(NotificationCenter.replyMessagesDidLoad, Long.valueOf(j), arrayList3);
        }
    }

    public static void sortEntities(ArrayList<TLRPC$MessageEntity> arrayList) {
        Collections.sort(arrayList, entityComparator);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean checkInclusion(int r5, java.util.ArrayList<org.rbmain.tgnet.TLRPC$MessageEntity> r6, boolean r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L2c
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto La
            goto L2c
        La:
            int r1 = r6.size()
            r2 = 0
        Lf:
            if (r2 >= r1) goto L2c
            java.lang.Object r3 = r6.get(r2)
            org.rbmain.tgnet.TLRPC$MessageEntity r3 = (org.rbmain.tgnet.TLRPC$MessageEntity) r3
            int r4 = r3.offset
            if (r7 == 0) goto L1e
            if (r4 >= r5) goto L29
            goto L20
        L1e:
            if (r4 > r5) goto L29
        L20:
            int r4 = r3.offset
            int r3 = r3.length
            int r4 = r4 + r3
            if (r4 <= r5) goto L29
            r5 = 1
            return r5
        L29:
            int r2 = r2 + 1
            goto Lf
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.checkInclusion(int, java.util.ArrayList, boolean):boolean");
    }

    private static boolean checkIntersection(int i, int i2, ArrayList<TLRPC$MessageEntity> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                TLRPC$MessageEntity tLRPC$MessageEntity = arrayList.get(i3);
                int i4 = tLRPC$MessageEntity.offset;
                if (i4 > i && i4 + tLRPC$MessageEntity.length <= i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void removeOffsetAfter(int i, int i2, ArrayList<TLRPC$MessageEntity> arrayList) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            TLRPC$MessageEntity tLRPC$MessageEntity = arrayList.get(i3);
            int i4 = tLRPC$MessageEntity.offset;
            if (i4 > i) {
                tLRPC$MessageEntity.offset = i4 - i2;
            }
        }
    }

    public CharSequence substring(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof SpannableStringBuilder) {
            return charSequence.subSequence(i, i2);
        }
        if (charSequence instanceof SpannedString) {
            return charSequence.subSequence(i, i2);
        }
        return TextUtils.substring(charSequence, i, i2);
    }

    private static CharacterStyle createNewSpan(CharacterStyle characterStyle, TextStyleSpan.TextStyleRun textStyleRun, TextStyleSpan.TextStyleRun textStyleRun2, boolean z) {
        TextStyleSpan.TextStyleRun textStyleRun3 = new TextStyleSpan.TextStyleRun(textStyleRun);
        if (textStyleRun2 != null) {
            if (z) {
                textStyleRun3.merge(textStyleRun2);
            } else {
                textStyleRun3.replace(textStyleRun2);
            }
        }
        if (characterStyle instanceof TextStyleSpan) {
            return new TextStyleSpan(textStyleRun3);
        }
        if (characterStyle instanceof URLSpanReplacement) {
            return new URLSpanReplacement(((URLSpanReplacement) characterStyle).getURL(), textStyleRun3);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void addStyleToText(org.rbmain.ui.Components.TextStyleSpan r11, int r12, int r13, android.text.Spannable r14, boolean r15) {
        /*
            java.lang.Class<android.text.style.CharacterStyle> r0 = android.text.style.CharacterStyle.class
            java.lang.Object[] r0 = r14.getSpans(r12, r13, r0)     // Catch: java.lang.Exception -> Lc0
            android.text.style.CharacterStyle[] r0 = (android.text.style.CharacterStyle[]) r0     // Catch: java.lang.Exception -> Lc0
            r1 = 33
            if (r0 == 0) goto Laa
            int r2 = r0.length     // Catch: java.lang.Exception -> Lc0
            if (r2 <= 0) goto Laa
            r2 = 0
        L10:
            int r3 = r0.length     // Catch: java.lang.Exception -> Lc0
            if (r2 >= r3) goto Laa
            r3 = r0[r2]     // Catch: java.lang.Exception -> Lc0
            if (r11 == 0) goto L1c
            org.rbmain.ui.Components.TextStyleSpan$TextStyleRun r4 = r11.getTextStyleRun()     // Catch: java.lang.Exception -> Lc0
            goto L21
        L1c:
            org.rbmain.ui.Components.TextStyleSpan$TextStyleRun r4 = new org.rbmain.ui.Components.TextStyleSpan$TextStyleRun     // Catch: java.lang.Exception -> Lc0
            r4.<init>()     // Catch: java.lang.Exception -> Lc0
        L21:
            boolean r5 = r3 instanceof org.rbmain.ui.Components.TextStyleSpan     // Catch: java.lang.Exception -> Lc0
            if (r5 == 0) goto L2d
            r5 = r3
            org.rbmain.ui.Components.TextStyleSpan r5 = (org.rbmain.ui.Components.TextStyleSpan) r5     // Catch: java.lang.Exception -> Lc0
            org.rbmain.ui.Components.TextStyleSpan$TextStyleRun r5 = r5.getTextStyleRun()     // Catch: java.lang.Exception -> Lc0
            goto L3f
        L2d:
            boolean r5 = r3 instanceof org.rbmain.ui.Components.URLSpanReplacement     // Catch: java.lang.Exception -> Lc0
            if (r5 == 0) goto La6
            r5 = r3
            org.rbmain.ui.Components.URLSpanReplacement r5 = (org.rbmain.ui.Components.URLSpanReplacement) r5     // Catch: java.lang.Exception -> Lc0
            org.rbmain.ui.Components.TextStyleSpan$TextStyleRun r5 = r5.getTextStyleRun()     // Catch: java.lang.Exception -> Lc0
            if (r5 != 0) goto L3f
            org.rbmain.ui.Components.TextStyleSpan$TextStyleRun r5 = new org.rbmain.ui.Components.TextStyleSpan$TextStyleRun     // Catch: java.lang.Exception -> Lc0
            r5.<init>()     // Catch: java.lang.Exception -> Lc0
        L3f:
            if (r5 != 0) goto L43
            goto La6
        L43:
            int r6 = r14.getSpanStart(r3)     // Catch: java.lang.Exception -> Lc0
            int r7 = r14.getSpanEnd(r3)     // Catch: java.lang.Exception -> Lc0
            r14.removeSpan(r3)     // Catch: java.lang.Exception -> Lc0
            if (r6 <= r12) goto L6a
            if (r13 <= r7) goto L6a
            android.text.style.CharacterStyle r3 = createNewSpan(r3, r5, r4, r15)     // Catch: java.lang.Exception -> Lc0
            r14.setSpan(r3, r6, r7, r1)     // Catch: java.lang.Exception -> Lc0
            if (r11 == 0) goto L68
            org.rbmain.ui.Components.TextStyleSpan r3 = new org.rbmain.ui.Components.TextStyleSpan     // Catch: java.lang.Exception -> Lc0
            org.rbmain.ui.Components.TextStyleSpan$TextStyleRun r5 = new org.rbmain.ui.Components.TextStyleSpan$TextStyleRun     // Catch: java.lang.Exception -> Lc0
            r5.<init>(r4)     // Catch: java.lang.Exception -> Lc0
            r3.<init>(r5)     // Catch: java.lang.Exception -> Lc0
            r14.setSpan(r3, r7, r13, r1)     // Catch: java.lang.Exception -> Lc0
        L68:
            r13 = r6
            goto La6
        L6a:
            r8 = 0
            if (r6 > r12) goto L87
            if (r6 == r12) goto L76
            android.text.style.CharacterStyle r9 = createNewSpan(r3, r5, r8, r15)     // Catch: java.lang.Exception -> Lc0
            r14.setSpan(r9, r6, r12, r1)     // Catch: java.lang.Exception -> Lc0
        L76:
            if (r7 <= r12) goto L87
            if (r11 == 0) goto L85
            android.text.style.CharacterStyle r9 = createNewSpan(r3, r5, r4, r15)     // Catch: java.lang.Exception -> Lc0
            int r10 = java.lang.Math.min(r7, r13)     // Catch: java.lang.Exception -> Lc0
            r14.setSpan(r9, r12, r10, r1)     // Catch: java.lang.Exception -> Lc0
        L85:
            r9 = r7
            goto L88
        L87:
            r9 = r12
        L88:
            if (r7 < r13) goto La5
            if (r7 == r13) goto L93
            android.text.style.CharacterStyle r8 = createNewSpan(r3, r5, r8, r15)     // Catch: java.lang.Exception -> Lc0
            r14.setSpan(r8, r13, r7, r1)     // Catch: java.lang.Exception -> Lc0
        L93:
            if (r13 <= r6) goto La5
            if (r7 > r12) goto La5
            if (r11 == 0) goto La4
            android.text.style.CharacterStyle r12 = createNewSpan(r3, r5, r4, r15)     // Catch: java.lang.Exception -> Lc0
            int r13 = java.lang.Math.min(r7, r13)     // Catch: java.lang.Exception -> Lc0
            r14.setSpan(r12, r6, r13, r1)     // Catch: java.lang.Exception -> Lc0
        La4:
            r13 = r6
        La5:
            r12 = r9
        La6:
            int r2 = r2 + 1
            goto L10
        Laa:
            if (r11 == 0) goto Lc4
            if (r12 >= r13) goto Lc4
            int r15 = r14.length()     // Catch: java.lang.Exception -> Lc0
            if (r12 >= r15) goto Lc4
            int r15 = r14.length()     // Catch: java.lang.Exception -> Lc0
            int r13 = java.lang.Math.min(r15, r13)     // Catch: java.lang.Exception -> Lc0
            r14.setSpan(r11, r12, r13, r1)     // Catch: java.lang.Exception -> Lc0
            goto Lc4
        Lc0:
            r11 = move-exception
            org.rbmain.messenger.FileLog.e(r11)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.addStyleToText(org.rbmain.ui.Components.TextStyleSpan, int, int, android.text.Spannable, boolean):void");
    }

    public static ArrayList<TextStyleSpan.TextStyleRun> getTextStyleRuns(ArrayList<TLRPC$MessageEntity> arrayList, CharSequence charSequence) {
        int i;
        ArrayList<TextStyleSpan.TextStyleRun> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList(arrayList);
        Collections.sort(arrayList3, new Comparator() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda88
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaDataController.lambda$getTextStyleRuns$95((TLRPC$MessageEntity) obj, (TLRPC$MessageEntity) obj2);
            }
        });
        int size = arrayList3.size();
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$MessageEntity tLRPC$MessageEntity = (TLRPC$MessageEntity) arrayList3.get(i2);
            if (tLRPC$MessageEntity.length > 0 && (i = tLRPC$MessageEntity.offset) >= 0 && i < charSequence.length()) {
                if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length > charSequence.length()) {
                    tLRPC$MessageEntity.length = charSequence.length() - tLRPC$MessageEntity.offset;
                }
                TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
                int i3 = tLRPC$MessageEntity.offset;
                textStyleRun.start = i3;
                textStyleRun.end = i3 + tLRPC$MessageEntity.length;
                if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntitySpoiler) {
                    textStyleRun.flags = 256;
                } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityStrike) {
                    textStyleRun.flags = 8;
                } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityUnderline) {
                    textStyleRun.flags = 16;
                } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityBlockquote) {
                    textStyleRun.flags = 32;
                } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityBold) {
                    textStyleRun.flags = 1;
                } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityItalic) {
                    textStyleRun.flags = 2;
                } else if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityCode) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityPre)) {
                    textStyleRun.flags = 4;
                } else if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityMentionName) || (tLRPC$MessageEntity instanceof TLRPC$TL_inputMessageEntityMentionName)) {
                    textStyleRun.flags = 64;
                    textStyleRun.urlEntity = tLRPC$MessageEntity;
                } else {
                    textStyleRun.flags = 128;
                    textStyleRun.urlEntity = tLRPC$MessageEntity;
                }
                int size2 = arrayList2.size();
                int i4 = 0;
                while (i4 < size2) {
                    TextStyleSpan.TextStyleRun textStyleRun2 = arrayList2.get(i4);
                    int i5 = textStyleRun.start;
                    int i6 = textStyleRun2.start;
                    if (i5 > i6) {
                        int i7 = textStyleRun2.end;
                        if (i5 < i7) {
                            int i8 = textStyleRun.end;
                            if (i8 < i7) {
                                TextStyleSpan.TextStyleRun textStyleRun3 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                textStyleRun3.merge(textStyleRun2);
                                int i9 = i4 + 1;
                                arrayList2.add(i9, textStyleRun3);
                                TextStyleSpan.TextStyleRun textStyleRun4 = new TextStyleSpan.TextStyleRun(textStyleRun2);
                                textStyleRun4.start = textStyleRun.end;
                                i4 = i9 + 1;
                                size2 = size2 + 1 + 1;
                                arrayList2.add(i4, textStyleRun4);
                            } else if (i8 >= i7) {
                                TextStyleSpan.TextStyleRun textStyleRun5 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                textStyleRun5.merge(textStyleRun2);
                                textStyleRun5.end = textStyleRun2.end;
                                i4++;
                                size2++;
                                arrayList2.add(i4, textStyleRun5);
                            }
                            int i10 = textStyleRun.start;
                            textStyleRun.start = textStyleRun2.end;
                            textStyleRun2.end = i10;
                        }
                    } else {
                        int i11 = textStyleRun.end;
                        if (i6 < i11) {
                            int i12 = textStyleRun2.end;
                            if (i11 == i12) {
                                textStyleRun2.merge(textStyleRun);
                            } else if (i11 < i12) {
                                TextStyleSpan.TextStyleRun textStyleRun6 = new TextStyleSpan.TextStyleRun(textStyleRun2);
                                textStyleRun6.merge(textStyleRun);
                                textStyleRun6.end = textStyleRun.end;
                                i4++;
                                size2++;
                                arrayList2.add(i4, textStyleRun6);
                                textStyleRun2.start = textStyleRun.end;
                            } else {
                                TextStyleSpan.TextStyleRun textStyleRun7 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                textStyleRun7.start = textStyleRun2.end;
                                i4++;
                                size2++;
                                arrayList2.add(i4, textStyleRun7);
                                textStyleRun2.merge(textStyleRun);
                            }
                            textStyleRun.end = i6;
                        }
                    }
                    i4++;
                }
                if (textStyleRun.start < textStyleRun.end) {
                    arrayList2.add(textStyleRun);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getTextStyleRuns$95(TLRPC$MessageEntity tLRPC$MessageEntity, TLRPC$MessageEntity tLRPC$MessageEntity2) {
        int i = tLRPC$MessageEntity.offset;
        int i2 = tLRPC$MessageEntity2.offset;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        if (r0 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        r0 = new java.util.ArrayList<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        if (r4 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
    
        r12 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        r12 = r12 + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r12 >= r19[0].length()) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r19[0].charAt(r12) != '`') goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        r5 = r5 + 1;
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0074, code lost:
    
        if (r4 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
    
        r10 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0078, code lost:
    
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        r10 = r10 + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007a, code lost:
    
        if (r4 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
    
        if (r6 <= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
    
        r4 = r19[0].charAt(r6 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0087, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008a, code lost:
    
        if (r4 == ' ') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008c, code lost:
    
        if (r4 != '\n') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008f, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0091, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0092, code lost:
    
        r13 = substring(r19[0], 0, r6 - r4);
        r14 = substring(r19[0], r6 + 3, r5);
        r15 = r5 + 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
    
        if (r15 >= r19[0].length()) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ac, code lost:
    
        r3 = r19[0].charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b3, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
    
        r11 = r19[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
    
        if (r3 == ' ') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
    
        if (r3 != '\n') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bb, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bd, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00be, code lost:
    
        r3 = substring(r11, r15 + r3, r19[0].length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cf, code lost:
    
        if (r13.length() == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        r13 = org.rbmain.messenger.AndroidUtilities.concat(r13, "\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00dc, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e1, code lost:
    
        if (r3.length() == 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e3, code lost:
    
        r3 = org.rbmain.messenger.AndroidUtilities.concat("\n", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f1, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) != false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f3, code lost:
    
        r19[0] = org.rbmain.messenger.AndroidUtilities.concat(r13, r14, r3);
        r3 = new org.rbmain.tgnet.TLRPC$TL_messageEntityPre();
        r3.offset = (r4 ^ 1) + r6;
        r3.length = ((r5 - r6) - 3) + (r4 ^ 1);
        r3.language = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        r0.add(r3);
        r10 = r10 - 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x011e, code lost:
    
        r3 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0120, code lost:
    
        if (r3 == r5) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0122, code lost:
    
        r19[0] = org.rbmain.messenger.AndroidUtilities.concat(substring(r19[0], 0, r6), substring(r19[0], r3, r5), substring(r19[0], r5 + 1, r19[0].length()));
        r3 = new org.rbmain.tgnet.TLRPC$TL_messageEntityCode();
        r3.offset = r6;
        r3.length = (r5 - r6) - 1;
        r0.add(r3);
        r10 = r10 - 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<org.rbmain.tgnet.TLRPC$MessageEntity> getEntities(java.lang.CharSequence[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 927
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.getEntities(java.lang.CharSequence[], boolean):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TLRPC$MessageEntity lambda$getEntities$96(Void r0) {
        return new TLRPC$TL_messageEntityBold();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TLRPC$MessageEntity lambda$getEntities$97(Void r0) {
        return new TLRPC$TL_messageEntityItalic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TLRPC$MessageEntity lambda$getEntities$98(Void r0) {
        return new TLRPC$TL_messageEntitySpoiler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TLRPC$MessageEntity lambda$getEntities$99(Void r0) {
        return new TLRPC$TL_messageEntityStrike();
    }

    public static ArrayList<TextStyleSpan.TextStyleRun> getTextStyleRuns(ArrayList<TLRPC$MessageEntity> arrayList, CharSequence charSequence, int i) {
        int i2;
        ArrayList<TextStyleSpan.TextStyleRun> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList(arrayList);
        Collections.sort(arrayList3, new Comparator() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda89
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaDataController.lambda$getTextStyleRuns$100((TLRPC$MessageEntity) obj, (TLRPC$MessageEntity) obj2);
            }
        });
        int size = arrayList3.size();
        for (int i3 = 0; i3 < size; i3++) {
            TLRPC$MessageEntity tLRPC$MessageEntity = (TLRPC$MessageEntity) arrayList3.get(i3);
            if (tLRPC$MessageEntity != null && tLRPC$MessageEntity.length > 0 && (i2 = tLRPC$MessageEntity.offset) >= 0 && i2 < charSequence.length()) {
                if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length > charSequence.length()) {
                    tLRPC$MessageEntity.length = charSequence.length() - tLRPC$MessageEntity.offset;
                }
                if (!(tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityCustomEmoji)) {
                    TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
                    int i4 = tLRPC$MessageEntity.offset;
                    textStyleRun.start = i4;
                    textStyleRun.end = i4 + tLRPC$MessageEntity.length;
                    if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntitySpoiler) {
                        textStyleRun.flags = 256;
                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityStrike) {
                        textStyleRun.flags = 8;
                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityUnderline) {
                        textStyleRun.flags = 16;
                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityBlockquote) {
                        textStyleRun.flags = 32;
                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityBold) {
                        textStyleRun.flags = 1;
                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityItalic) {
                        textStyleRun.flags = 2;
                    } else if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityCode) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityPre)) {
                        textStyleRun.flags = 4;
                    } else if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityMentionName) || (tLRPC$MessageEntity instanceof TLRPC$TL_inputMessageEntityMentionName)) {
                        textStyleRun.flags = 64;
                        textStyleRun.urlEntity = tLRPC$MessageEntity;
                    } else {
                        textStyleRun.flags = 128;
                        textStyleRun.urlEntity = tLRPC$MessageEntity;
                    }
                    if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityTextUrl) {
                        textStyleRun.flags |= 1024;
                    }
                    textStyleRun.flags &= i;
                    int size2 = arrayList2.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        TextStyleSpan.TextStyleRun textStyleRun2 = arrayList2.get(i5);
                        int i6 = textStyleRun.start;
                        int i7 = textStyleRun2.start;
                        if (i6 > i7) {
                            int i8 = textStyleRun2.end;
                            if (i6 < i8) {
                                if (textStyleRun.end < i8) {
                                    TextStyleSpan.TextStyleRun textStyleRun3 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                    textStyleRun3.merge(textStyleRun2);
                                    int i9 = i5 + 1;
                                    arrayList2.add(i9, textStyleRun3);
                                    TextStyleSpan.TextStyleRun textStyleRun4 = new TextStyleSpan.TextStyleRun(textStyleRun2);
                                    textStyleRun4.start = textStyleRun.end;
                                    i5 = i9 + 1;
                                    size2 = size2 + 1 + 1;
                                    arrayList2.add(i5, textStyleRun4);
                                } else {
                                    TextStyleSpan.TextStyleRun textStyleRun5 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                    textStyleRun5.merge(textStyleRun2);
                                    textStyleRun5.end = textStyleRun2.end;
                                    i5++;
                                    size2++;
                                    arrayList2.add(i5, textStyleRun5);
                                }
                                int i10 = textStyleRun.start;
                                textStyleRun.start = textStyleRun2.end;
                                textStyleRun2.end = i10;
                            }
                        } else {
                            int i11 = textStyleRun.end;
                            if (i7 < i11) {
                                int i12 = textStyleRun2.end;
                                if (i11 == i12) {
                                    textStyleRun2.merge(textStyleRun);
                                } else if (i11 < i12) {
                                    TextStyleSpan.TextStyleRun textStyleRun6 = new TextStyleSpan.TextStyleRun(textStyleRun2);
                                    textStyleRun6.merge(textStyleRun);
                                    textStyleRun6.end = textStyleRun.end;
                                    i5++;
                                    size2++;
                                    arrayList2.add(i5, textStyleRun6);
                                    textStyleRun2.start = textStyleRun.end;
                                } else {
                                    TextStyleSpan.TextStyleRun textStyleRun7 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                    textStyleRun7.start = textStyleRun2.end;
                                    i5++;
                                    size2++;
                                    arrayList2.add(i5, textStyleRun7);
                                    textStyleRun2.merge(textStyleRun);
                                }
                                textStyleRun.end = i7;
                            }
                        }
                        i5++;
                    }
                    if (textStyleRun.start < textStyleRun.end) {
                        arrayList2.add(textStyleRun);
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getTextStyleRuns$100(TLRPC$MessageEntity tLRPC$MessageEntity, TLRPC$MessageEntity tLRPC$MessageEntity2) {
        int i = tLRPC$MessageEntity.offset;
        int i2 = tLRPC$MessageEntity2.offset;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public void addStyle(int i, int i2, int i3, ArrayList<TLRPC$MessageEntity> arrayList) {
        if ((i & 256) != 0) {
            arrayList.add(setEntityStartEnd(new TLRPC$TL_messageEntitySpoiler(), i2, i3));
        }
        if ((i & 1) != 0) {
            arrayList.add(setEntityStartEnd(new TLRPC$TL_messageEntityBold(), i2, i3));
        }
        if ((i & 2) != 0) {
            arrayList.add(setEntityStartEnd(new TLRPC$TL_messageEntityItalic(), i2, i3));
        }
        if ((i & 4) != 0) {
            arrayList.add(setEntityStartEnd(new TLRPC$TL_messageEntityCode(), i2, i3));
        }
        if ((i & 8) != 0) {
            arrayList.add(setEntityStartEnd(new TLRPC$TL_messageEntityStrike(), i2, i3));
        }
        if ((i & 16) != 0) {
            arrayList.add(setEntityStartEnd(new TLRPC$TL_messageEntityUnderline(), i2, i3));
        }
        if ((i & 32) != 0) {
            arrayList.add(setEntityStartEnd(new TLRPC$TL_messageEntityBlockquote(), i2, i3));
        }
    }

    private TLRPC$MessageEntity setEntityStartEnd(TLRPC$MessageEntity tLRPC$MessageEntity, int i, int i2) {
        tLRPC$MessageEntity.offset = i;
        tLRPC$MessageEntity.length = i2 - i;
        return tLRPC$MessageEntity;
    }

    private CharSequence parsePattern(CharSequence charSequence, Pattern pattern, ArrayList<TLRPC$MessageEntity> arrayList, GenericProvider<Void, TLRPC$MessageEntity> genericProvider) {
        URLSpan[] uRLSpanArr;
        Matcher matcher = pattern.matcher(charSequence);
        int iEnd = 0;
        while (matcher.find()) {
            boolean z = true;
            String strGroup = matcher.group(1);
            if ((charSequence instanceof Spannable) && (uRLSpanArr = (URLSpan[]) ((Spannable) charSequence).getSpans(matcher.start() - iEnd, matcher.end() - iEnd, URLSpan.class)) != null && uRLSpanArr.length > 0) {
                z = false;
            }
            if (z) {
                charSequence = ((Object) charSequence.subSequence(0, matcher.start() - iEnd)) + strGroup + ((Object) charSequence.subSequence(matcher.end() - iEnd, charSequence.length()));
                TLRPC$MessageEntity tLRPC$MessageEntityProvide = genericProvider.provide(null);
                tLRPC$MessageEntityProvide.offset = matcher.start() - iEnd;
                int length = strGroup.length();
                tLRPC$MessageEntityProvide.length = length;
                int i = tLRPC$MessageEntityProvide.offset;
                removeOffset4After(i, length + i, arrayList);
                arrayList.add(tLRPC$MessageEntityProvide);
            }
            iEnd += (matcher.end() - matcher.start()) - strGroup.length();
        }
        return charSequence;
    }

    private static void removeOffset4After(int i, int i2, ArrayList<TLRPC$MessageEntity> arrayList) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            TLRPC$MessageEntity tLRPC$MessageEntity = arrayList.get(i3);
            int i4 = tLRPC$MessageEntity.offset;
            if (i4 > i2) {
                tLRPC$MessageEntity.offset = i4 - 4;
            } else if (i4 > i) {
                tLRPC$MessageEntity.offset = i4 - 2;
            }
        }
    }

    public void loadDraftsIfNeed() {
        if (getUserConfig().draftsLoaded || this.loadingDrafts) {
            return;
        }
        this.loadingDrafts = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_getAllDrafts
            public static int constructor = 1782549861;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda98
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadDraftsIfNeed$103(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDraftsIfNeed$101() {
        this.loadingDrafts = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDraftsIfNeed$103(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadDraftsIfNeed$101();
                }
            });
        } else {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadDraftsIfNeed$102();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDraftsIfNeed$102() {
        this.loadingDrafts = false;
        UserConfig userConfig = getUserConfig();
        userConfig.draftsLoaded = true;
        userConfig.saveConfig(false);
    }

    public int getDraftFolderId(long j) {
        return this.draftsFolderIds.get(j, 0).intValue();
    }

    public void setDraftFolderId(long j, int i) {
        this.draftsFolderIds.put(j, Integer.valueOf(i));
    }

    public void clearDraftsFolderIds() {
        this.draftsFolderIds.clear();
    }

    public LongSparseArray<LongSparseArray<TLRPC$DraftMessage>> getDrafts() {
        return this.drafts;
    }

    public TLRPC$DraftMessage getDraft(long j, long j2) {
        LongSparseArray<TLRPC$DraftMessage> longSparseArray = this.drafts.get(j);
        if (longSparseArray == null) {
            return null;
        }
        return longSparseArray.get(j2);
    }

    public TLRPC$Message getDraftMessage(long j, long j2) {
        LongSparseArray<TLRPC$Message> longSparseArray = this.draftMessages.get(j);
        if (longSparseArray == null) {
            return null;
        }
        return longSparseArray.get(j2);
    }

    public void saveDraft(long j, long j2, CharSequence charSequence, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$Message tLRPC$Message, boolean z) {
        saveDraft(j, j2, charSequence, arrayList, tLRPC$Message, z, false);
    }

    public void saveDraft(long j, long j2, CharSequence charSequence, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$Message tLRPC$Message, boolean z, boolean z2) {
        TLRPC$DraftMessage tLRPC$TL_draftMessage;
        if (!TextUtils.isEmpty(charSequence) || tLRPC$Message != null) {
            tLRPC$TL_draftMessage = new TLRPC$TL_draftMessage();
        } else {
            tLRPC$TL_draftMessage = new TLRPC$TL_draftMessageEmpty();
        }
        TLRPC$DraftMessage tLRPC$DraftMessage = tLRPC$TL_draftMessage;
        tLRPC$DraftMessage.date = (int) (System.currentTimeMillis() / 1000);
        tLRPC$DraftMessage.message = charSequence == null ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : charSequence.toString();
        tLRPC$DraftMessage.no_webpage = z;
        if (tLRPC$Message != null) {
            tLRPC$DraftMessage.reply_to_msg_id = tLRPC$Message.id;
            tLRPC$DraftMessage.flags |= 1;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            tLRPC$DraftMessage.entities = arrayList;
            tLRPC$DraftMessage.flags |= 8;
        }
        LongSparseArray<TLRPC$DraftMessage> longSparseArray = this.drafts.get(j);
        TLRPC$DraftMessage tLRPC$DraftMessage2 = longSparseArray == null ? null : longSparseArray.get(j2);
        if (!z2) {
            if (tLRPC$DraftMessage2 != null && tLRPC$DraftMessage2.message.equals(tLRPC$DraftMessage.message) && tLRPC$DraftMessage2.reply_to_msg_id == tLRPC$DraftMessage.reply_to_msg_id && tLRPC$DraftMessage2.no_webpage == tLRPC$DraftMessage.no_webpage) {
                return;
            }
            if (tLRPC$DraftMessage2 == null && TextUtils.isEmpty(tLRPC$DraftMessage.message) && tLRPC$DraftMessage.reply_to_msg_id == 0) {
                return;
            }
        }
        saveDraft(j, j2, tLRPC$DraftMessage, tLRPC$Message, false);
        if (j2 == 0) {
            int i = (int) j;
            if (i != 0) {
                TLRPC$TL_messages_saveDraft tLRPC$TL_messages_saveDraft = new TLRPC$TL_messages_saveDraft();
                TLRPC$InputPeer inputPeer = getMessagesController().getInputPeer(i);
                tLRPC$TL_messages_saveDraft.peer = inputPeer;
                if (inputPeer == null) {
                    return;
                }
                tLRPC$TL_messages_saveDraft.message = tLRPC$DraftMessage.message;
                tLRPC$TL_messages_saveDraft.no_webpage = tLRPC$DraftMessage.no_webpage;
                tLRPC$TL_messages_saveDraft.reply_to_msg_id = tLRPC$DraftMessage.reply_to_msg_id;
                tLRPC$TL_messages_saveDraft.entities = tLRPC$DraftMessage.entities;
                tLRPC$TL_messages_saveDraft.flags = tLRPC$DraftMessage.flags;
                getConnectionsManager().sendRequest(tLRPC$TL_messages_saveDraft, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda122
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        MediaDataController.lambda$saveDraft$104(tLObject, tLRPC$TL_error);
                    }
                });
            }
            getMessagesController().sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
    }

    public void saveDraft(final long j, final long j2, TLRPC$DraftMessage tLRPC$DraftMessage, TLRPC$Message tLRPC$Message, boolean z) {
        StringBuilder sb;
        TLRPC$Chat chat;
        final int i;
        StringBuilder sb2;
        SharedPreferences.Editor editorEdit = this.draftPreferences.edit();
        MessagesController messagesController = getMessagesController();
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (tLRPC$DraftMessage == null || (tLRPC$DraftMessage instanceof TLRPC$TL_draftMessageEmpty)) {
            LongSparseArray<TLRPC$DraftMessage> longSparseArray = this.drafts.get(j);
            if (longSparseArray != null) {
                longSparseArray.remove(j2);
                if (longSparseArray.size() == 0) {
                    this.drafts.remove(j);
                }
            }
            LongSparseArray<TLRPC$Message> longSparseArray2 = this.draftMessages.get(j);
            if (longSparseArray2 != null) {
                longSparseArray2.remove(j2);
                if (longSparseArray2.size() == 0) {
                    this.draftMessages.remove(j);
                }
            }
            if (j2 == 0) {
                this.draftPreferences.edit().remove(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + dialogId).remove("r_" + dialogId).apply();
            } else {
                this.draftPreferences.edit().remove("t_" + dialogId + "_" + j2).remove("rt_" + dialogId + "_" + j2).apply();
            }
            messagesController.removeDraftDialogIfNeed(j);
        } else {
            LongSparseArray<TLRPC$DraftMessage> longSparseArray3 = this.drafts.get(j);
            if (longSparseArray3 == null) {
                longSparseArray3 = new LongSparseArray<>();
                this.drafts.put(j, longSparseArray3);
            }
            longSparseArray3.put(j2, tLRPC$DraftMessage);
            if (j2 == 0) {
                messagesController.putDraftDialogIfNeed(j, tLRPC$DraftMessage);
            }
            try {
                SerializedData serializedData = new SerializedData(tLRPC$DraftMessage.getObjectSize());
                tLRPC$DraftMessage.serializeToStream(serializedData);
                if (j2 == 0) {
                    sb2 = new StringBuilder();
                    sb2.append(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                    sb2.append(dialogId);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("t_");
                    sb2.append(dialogId);
                    sb2.append("_");
                    sb2.append(j2);
                }
                editorEdit.putString(sb2.toString(), Utilities.bytesToHex(serializedData.toByteArray()));
                serializedData.cleanup();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        LongSparseArray<TLRPC$Message> longSparseArray4 = this.draftMessages.get(j);
        if (tLRPC$Message == null) {
            if (longSparseArray4 != null) {
                longSparseArray4.remove(j2);
                if (longSparseArray4.size() == 0) {
                    this.draftMessages.remove(j);
                }
            }
            if (j2 == 0) {
                editorEdit.remove("r_" + dialogId);
            } else {
                editorEdit.remove("rt_" + dialogId + "_" + j2);
            }
        } else {
            if (longSparseArray4 == null) {
                longSparseArray4 = new LongSparseArray<>();
                this.draftMessages.put(j, longSparseArray4);
            }
            longSparseArray4.put(j2, tLRPC$Message);
            SerializedData serializedData2 = new SerializedData(tLRPC$Message.getObjectSize());
            tLRPC$Message.serializeToStream(serializedData2);
            if (j2 == 0) {
                sb = new StringBuilder();
                sb.append("r_");
                sb.append(dialogId);
            } else {
                sb = new StringBuilder();
                sb.append("rt_");
                sb.append(dialogId);
                sb.append("_");
                sb.append(j2);
            }
            editorEdit.putString(sb.toString(), Utilities.bytesToHex(serializedData2.toByteArray()));
            serializedData2.cleanup();
        }
        editorEdit.apply();
        if (z && j2 == 0) {
            if (tLRPC$DraftMessage.reply_to_msg_id != 0 && tLRPC$Message == null) {
                int i2 = (int) j;
                TLRPC$User user = null;
                if (i2 > 0) {
                    user = getMessagesController().getUser(Integer.valueOf(i2));
                    chat = null;
                } else {
                    chat = getMessagesController().getChat(Integer.valueOf(-i2));
                }
                if (user != null || chat != null) {
                    final long j3 = tLRPC$DraftMessage.reply_to_msg_id;
                    if (ChatObject.isChannel(chat)) {
                        int i3 = chat.id;
                        j3 |= i3 << 32;
                        i = i3;
                    } else {
                        i = 0;
                    }
                    getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda22
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$saveDraft$107(j3, i, j, j2);
                        }
                    });
                }
            }
            getNotificationCenter().postNotificationName(NotificationCenter.newDraftReceived, Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveDraft$107(long j, int i, final long j2, final long j3) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        TLRPC$Message tLRPC$MessageTLdeserialize = null;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data FROM messages WHERE mid = %d", Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                nativeByteBufferByteBufferValue.reuse();
            }
            TLRPC$Message tLRPC$Message = tLRPC$MessageTLdeserialize;
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$Message != null) {
                saveDraftReplyMessage(j2, j3, tLRPC$Message);
                return;
            }
            if (i != 0) {
                TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                tLRPC$TL_channels_getMessages.channel = getMessagesController().getInputChannel(i);
                tLRPC$TL_channels_getMessages.id.add(Long.valueOf(j));
                getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda107
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$saveDraft$105(j2, j3, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages = new TLRPC$TL_messages_getMessages();
            tLRPC$TL_messages_getMessages.id.add(Long.valueOf(j));
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda106
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$saveDraft$106(j2, j3, tLObject, tLRPC$TL_error);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveDraft$105(long j, long j2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            if (tLRPC$messages_Messages.messages.isEmpty()) {
                return;
            }
            saveDraftReplyMessage(j, j2, tLRPC$messages_Messages.messages.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveDraft$106(long j, long j2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            if (tLRPC$messages_Messages.messages.isEmpty()) {
                return;
            }
            saveDraftReplyMessage(j, j2, tLRPC$messages_Messages.messages.get(0));
        }
    }

    private void saveDraftReplyMessage(final long j, final long j2, final TLRPC$Message tLRPC$Message) {
        final String dialogId = IdStorage.getInstance().getDialogId(j);
        if (tLRPC$Message == null || dialogId == null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveDraftReplyMessage$108(j, j2, tLRPC$Message, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveDraftReplyMessage$108(long j, long j2, TLRPC$Message tLRPC$Message, String str) {
        String str2;
        LongSparseArray<TLRPC$DraftMessage> longSparseArray = this.drafts.get(j);
        TLRPC$DraftMessage tLRPC$DraftMessage = longSparseArray != null ? longSparseArray.get(j2) : null;
        if (tLRPC$DraftMessage == null || tLRPC$DraftMessage.reply_to_msg_id != tLRPC$Message.id) {
            return;
        }
        LongSparseArray<TLRPC$Message> longSparseArray2 = this.draftMessages.get(j);
        if (longSparseArray2 == null) {
            longSparseArray2 = new LongSparseArray<>();
            this.draftMessages.put(j, longSparseArray2);
        }
        longSparseArray2.put(j2, tLRPC$Message);
        SerializedData serializedData = new SerializedData(tLRPC$Message.getObjectSize());
        tLRPC$Message.serializeToStream(serializedData);
        SharedPreferences.Editor editorEdit = this.draftPreferences.edit();
        if (j2 == 0) {
            str2 = "r_" + str;
        } else {
            str2 = "rt_" + str + "_" + j2;
        }
        editorEdit.putString(str2, Utilities.bytesToHex(serializedData.toByteArray())).apply();
        getNotificationCenter().postNotificationName(NotificationCenter.newDraftReceived, Long.valueOf(j));
        serializedData.cleanup();
    }

    public void clearAllDrafts(boolean z) {
        this.drafts.clear();
        this.draftMessages.clear();
        this.draftsFolderIds.clear();
        this.draftPreferences.edit().clear().apply();
        if (z) {
            getMessagesController().sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
    }

    public void cleanDraft(long j, long j2, boolean z) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        LongSparseArray<TLRPC$DraftMessage> longSparseArray = this.drafts.get(j);
        TLRPC$DraftMessage tLRPC$DraftMessage = longSparseArray != null ? longSparseArray.get(j2) : null;
        if (tLRPC$DraftMessage == null || dialogId == null) {
            return;
        }
        if (z) {
            if (tLRPC$DraftMessage.reply_to_msg_id != 0) {
                tLRPC$DraftMessage.reply_to_msg_id = 0L;
                tLRPC$DraftMessage.flags &= -2;
                saveDraft(j, j2, tLRPC$DraftMessage.message, tLRPC$DraftMessage.entities, null, tLRPC$DraftMessage.no_webpage, true);
                return;
            }
            return;
        }
        LongSparseArray<TLRPC$DraftMessage> longSparseArray2 = this.drafts.get(j);
        if (longSparseArray2 != null) {
            longSparseArray2.remove(j2);
            if (longSparseArray2.size() == 0) {
                this.drafts.remove(j);
            }
        }
        LongSparseArray<TLRPC$Message> longSparseArray3 = this.draftMessages.get(j);
        if (longSparseArray3 != null) {
            longSparseArray3.remove(j2);
            if (longSparseArray3.size() == 0) {
                this.draftMessages.remove(j);
            }
        }
        if (j2 == 0) {
            this.draftPreferences.edit().remove(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + dialogId).remove("r_" + dialogId).apply();
            getMessagesController().sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            return;
        }
        this.draftPreferences.edit().remove("t_" + dialogId + "_" + j2).remove("rt_" + dialogId + "_" + j2).apply();
    }

    public void beginTransaction() {
        this.inTransaction = true;
    }

    public void endTransaction() {
        this.inTransaction = false;
    }

    public void clearBotKeyboard(final long j, final ArrayList<Long> arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearBotKeyboard$109(arrayList, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearBotKeyboard$109(ArrayList arrayList, long j) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                Long l = this.botKeyboardsByMids.get(((Long) arrayList.get(i)).longValue());
                if (l != null && l.longValue() != 0) {
                    this.botKeyboards.remove(l.longValue());
                    this.botKeyboardsByMids.delete(((Long) arrayList.get(i)).longValue());
                    getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, null, l);
                }
            }
            return;
        }
        this.botKeyboards.remove(j);
        getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, null, Long.valueOf(j));
    }

    public void loadBotKeyboard(long j) {
        TLRPC$Message tLRPC$Message = this.botKeyboards.get(j);
        if (tLRPC$Message != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, tLRPC$Message, Long.valueOf(j));
        } else {
            getMessagesProxy().getBotKeyboard(j);
        }
    }

    public void loadBotInfo(final int i, boolean z, final int i2) {
        TLRPC$BotInfo tLRPC$BotInfo;
        if (z && (tLRPC$BotInfo = this.botInfos.get(i)) != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.botInfoDidLoad, tLRPC$BotInfo, Integer.valueOf(i2));
        } else {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadBotInfo$111(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBotInfo$111(int i, final int i2) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        final TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = null;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT info FROM bot_info WHERE uid = %d", Integer.valueOf(i)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && !sQLiteCursorQueryFinalized.isNull(0) && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$BotInfoTLdeserialize != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda60
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadBotInfo$110(tLRPC$BotInfoTLdeserialize, i2);
                    }
                });
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBotInfo$110(TLRPC$BotInfo tLRPC$BotInfo, int i) {
        getNotificationCenter().postNotificationName(NotificationCenter.botInfoDidLoad, tLRPC$BotInfo, Integer.valueOf(i));
    }

    public HashMap<String, TLRPC$TL_availableReaction> getReactionsMap() {
        return this.reactionsMap;
    }

    public String getDoubleTapReaction() {
        String str = this.doubleTapReaction;
        if (str != null) {
            return str;
        }
        if (getReactionsList().isEmpty()) {
            return null;
        }
        String string = MessagesController.getEmojiSettings(this.currentAccount).getString("reaction_on_double_tap", null);
        if (string != null && (getReactionsMap().get(string) != null || string.startsWith("animated_"))) {
            this.doubleTapReaction = string;
            return string;
        }
        return getReactionsList().get(0).reaction;
    }

    public void setDoubleTapReaction(String str) {
        MessagesController.getEmojiSettings(this.currentAccount).edit().putString("reaction_on_double_tap", str).apply();
        this.doubleTapReaction = str;
    }

    public List<TLRPC$TL_availableReaction> getEnabledReactionsList() {
        return this.enabledReactionsList;
    }

    public void checkAllMedia(boolean z) {
        if (z) {
            this.reactionsUpdateDate = 0;
        }
        checkReactions();
    }

    public void putBotKeyboard(final long j, final TLRPC$Message tLRPC$Message) {
        if (tLRPC$Message == null) {
            return;
        }
        try {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putBotKeyboard$112(j, tLRPC$Message);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putBotKeyboard$112(long j, TLRPC$Message tLRPC$Message) {
        TLRPC$Message tLRPC$Message2 = this.botKeyboards.get(j);
        this.botKeyboards.put(j, tLRPC$Message);
        if (tLRPC$Message2 != null) {
            this.botKeyboardsByMids.delete(tLRPC$Message2.id);
        }
        this.botKeyboardsByMids.put(tLRPC$Message.id, Long.valueOf(j));
        getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, tLRPC$Message, Long.valueOf(j));
    }

    public void putBotInfo(final TLRPC$BotInfo tLRPC$BotInfo) {
        if (tLRPC$BotInfo == null) {
            return;
        }
        this.botInfos.put(tLRPC$BotInfo.user_id, tLRPC$BotInfo);
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda59
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putBotInfo$113(tLRPC$BotInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putBotInfo$113(TLRPC$BotInfo tLRPC$BotInfo) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO bot_info(uid, info) VALUES(?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$BotInfo.getObjectSize());
            tLRPC$BotInfo.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$BotInfo.user_id);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void fetchNewEmojiKeywords(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (final String str : strArr) {
            if (TextUtils.isEmpty(str) || this.currentFetchingEmoji.get(str) != null) {
                return;
            }
            this.currentFetchingEmoji.put(str, Boolean.TRUE);
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fetchNewEmojiKeywords$119(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$119(final java.lang.String r10) {
        /*
            r9 = this;
            r0 = -1
            r1 = 0
            r2 = 0
            org.rbmain.messenger.MessagesStorage r4 = r9.getMessagesStorage()     // Catch: java.lang.Exception -> L33
            org.rbmain.SQLite.SQLiteDatabase r4 = r4.getDatabase()     // Catch: java.lang.Exception -> L33
            java.lang.String r5 = "SELECT alias, version, date FROM emoji_keywords_info_v2 WHERE lang = ?"
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L33
            r8 = 0
            r7[r8] = r10     // Catch: java.lang.Exception -> L33
            org.rbmain.SQLite.SQLiteCursor r4 = r4.queryFinalized(r5, r7)     // Catch: java.lang.Exception -> L33
            boolean r5 = r4.next()     // Catch: java.lang.Exception -> L33
            if (r5 == 0) goto L2c
            java.lang.String r1 = r4.stringValue(r8)     // Catch: java.lang.Exception -> L33
            int r5 = r4.intValue(r6)     // Catch: java.lang.Exception -> L33
            r6 = 2
            long r2 = r4.longValue(r6)     // Catch: java.lang.Exception -> L31
            goto L2d
        L2c:
            r5 = -1
        L2d:
            r4.dispose()     // Catch: java.lang.Exception -> L31
            goto L38
        L31:
            r4 = move-exception
            goto L35
        L33:
            r4 = move-exception
            r5 = -1
        L35:
            org.rbmain.messenger.FileLog.e(r4)
        L38:
            boolean r4 = org.rbmain.messenger.BuildVars.DEBUG_VERSION
            if (r4 != 0) goto L55
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r2
            long r2 = java.lang.Math.abs(r6)
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 >= 0) goto L55
            org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda33 r0 = new org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda33
            r0.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        L55:
            if (r5 != r0) goto L5f
            org.rbmain.tgnet.TLRPC$TL_messages_getEmojiKeywords r0 = new org.rbmain.tgnet.TLRPC$TL_messages_getEmojiKeywords
            r0.<init>()
            r0.lang_code = r10
            goto L68
        L5f:
            org.rbmain.tgnet.TLRPC$TL_messages_getEmojiKeywordsDifference r0 = new org.rbmain.tgnet.TLRPC$TL_messages_getEmojiKeywordsDifference
            r0.<init>()
            r0.lang_code = r10
            r0.from_version = r5
        L68:
            org.rbmain.tgnet.ConnectionsManager r2 = r9.getConnectionsManager()
            org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda102 r3 = new org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda102
            r3.<init>()
            r2.sendRequest(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.lambda$fetchNewEmojiKeywords$119(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$114(String str) {
        this.currentFetchingEmoji.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$118(int i, String str, final String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$TL_emojiKeywordsDifference tLRPC$TL_emojiKeywordsDifference = (TLRPC$TL_emojiKeywordsDifference) tLObject;
            if (i != -1 && !tLRPC$TL_emojiKeywordsDifference.lang_code.equals(str)) {
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda36
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$fetchNewEmojiKeywords$116(str2);
                    }
                });
                return;
            } else {
                putEmojiKeywords(str2, tLRPC$TL_emojiKeywordsDifference);
                return;
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fetchNewEmojiKeywords$117(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$116(final String str) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("DELETE FROM emoji_keywords_info_v2 WHERE lang = ?");
            sQLitePreparedStatementExecuteFast.bindString(1, str);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fetchNewEmojiKeywords$115(str);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$115(String str) {
        this.currentFetchingEmoji.remove(str);
        fetchNewEmojiKeywords(new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$117(String str) {
        this.currentFetchingEmoji.remove(str);
    }

    private void putEmojiKeywords(final String str, final TLRPC$TL_emojiKeywordsDifference tLRPC$TL_emojiKeywordsDifference) {
        if (tLRPC$TL_emojiKeywordsDifference == null) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda67
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putEmojiKeywords$121(tLRPC$TL_emojiKeywordsDifference, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putEmojiKeywords$121(TLRPC$TL_emojiKeywordsDifference tLRPC$TL_emojiKeywordsDifference, final String str) {
        try {
            if (!tLRPC$TL_emojiKeywordsDifference.keywords.isEmpty()) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO emoji_keywords_v2 VALUES(?, ?, ?)");
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = getMessagesStorage().getDatabase().executeFast("DELETE FROM emoji_keywords_v2 WHERE lang = ? AND keyword = ? AND emoji = ?");
                getMessagesStorage().getDatabase().beginTransaction();
                int size = tLRPC$TL_emojiKeywordsDifference.keywords.size();
                for (int i = 0; i < size; i++) {
                    TLRPC$EmojiKeyword tLRPC$EmojiKeyword = tLRPC$TL_emojiKeywordsDifference.keywords.get(i);
                    if (tLRPC$EmojiKeyword instanceof TLRPC$TL_emojiKeyword) {
                        TLRPC$TL_emojiKeyword tLRPC$TL_emojiKeyword = (TLRPC$TL_emojiKeyword) tLRPC$EmojiKeyword;
                        String lowerCase = tLRPC$TL_emojiKeyword.keyword.toLowerCase();
                        int size2 = tLRPC$TL_emojiKeyword.emoticons.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            sQLitePreparedStatementExecuteFast.requery();
                            sQLitePreparedStatementExecuteFast.bindString(1, tLRPC$TL_emojiKeywordsDifference.lang_code);
                            sQLitePreparedStatementExecuteFast.bindString(2, lowerCase);
                            sQLitePreparedStatementExecuteFast.bindString(3, tLRPC$TL_emojiKeyword.emoticons.get(i2));
                            sQLitePreparedStatementExecuteFast.step();
                        }
                    } else if (tLRPC$EmojiKeyword instanceof TLRPC$TL_emojiKeywordDeleted) {
                        TLRPC$TL_emojiKeywordDeleted tLRPC$TL_emojiKeywordDeleted = (TLRPC$TL_emojiKeywordDeleted) tLRPC$EmojiKeyword;
                        String lowerCase2 = tLRPC$TL_emojiKeywordDeleted.keyword.toLowerCase();
                        int size3 = tLRPC$TL_emojiKeywordDeleted.emoticons.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            sQLitePreparedStatementExecuteFast2.requery();
                            sQLitePreparedStatementExecuteFast2.bindString(1, tLRPC$TL_emojiKeywordsDifference.lang_code);
                            sQLitePreparedStatementExecuteFast2.bindString(2, lowerCase2);
                            sQLitePreparedStatementExecuteFast2.bindString(3, tLRPC$TL_emojiKeywordDeleted.emoticons.get(i3));
                            sQLitePreparedStatementExecuteFast2.step();
                        }
                    }
                }
                getMessagesStorage().getDatabase().commitTransaction();
                sQLitePreparedStatementExecuteFast.dispose();
                sQLitePreparedStatementExecuteFast2.dispose();
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = getMessagesStorage().getDatabase().executeFast("REPLACE INTO emoji_keywords_info_v2 VALUES(?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast3.bindString(1, str);
            sQLitePreparedStatementExecuteFast3.bindString(2, tLRPC$TL_emojiKeywordsDifference.lang_code);
            sQLitePreparedStatementExecuteFast3.bindInteger(3, tLRPC$TL_emojiKeywordsDifference.version);
            sQLitePreparedStatementExecuteFast3.bindLong(4, System.currentTimeMillis());
            sQLitePreparedStatementExecuteFast3.step();
            sQLitePreparedStatementExecuteFast3.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putEmojiKeywords$120(str);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putEmojiKeywords$120(String str) {
        this.currentFetchingEmoji.remove(str);
        getNotificationCenter().postNotificationName(NotificationCenter.newEmojiSuggestionsAvailable, str);
    }

    public void getEmojiSuggestions(String[] strArr, String str, boolean z, KeywordResultCallback keywordResultCallback) {
        getEmojiSuggestions(strArr, str, z, keywordResultCallback, null);
    }

    public void getEmojiSuggestions(final String[] strArr, final String str, final boolean z, final KeywordResultCallback keywordResultCallback, final CountDownLatch countDownLatch) {
        if (keywordResultCallback == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null) {
            keywordResultCallback.run(new ArrayList<>(), null);
            return;
        }
        final ArrayList arrayList = new ArrayList(Emoji.recentEmoji);
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda82
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getEmojiSuggestions$125(strArr, keywordResultCallback, str, z, arrayList, countDownLatch);
            }
        });
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070 A[Catch: Exception -> 0x0109, TryCatch #1 {Exception -> 0x0109, blocks: (B:15:0x0042, B:17:0x0049, B:21:0x0054, B:25:0x0065, B:27:0x0070, B:29:0x007d, B:32:0x0085, B:36:0x00d2, B:38:0x00d8, B:41:0x00ec, B:42:0x0102, B:34:0x009a, B:35:0x00af), top: B:56:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085 A[Catch: Exception -> 0x0109, TryCatch #1 {Exception -> 0x0109, blocks: (B:15:0x0042, B:17:0x0049, B:21:0x0054, B:25:0x0065, B:27:0x0070, B:29:0x007d, B:32:0x0085, B:36:0x00d2, B:38:0x00d8, B:41:0x00ec, B:42:0x0102, B:34:0x009a, B:35:0x00af), top: B:56:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8 A[Catch: Exception -> 0x0109, TryCatch #1 {Exception -> 0x0109, blocks: (B:15:0x0042, B:17:0x0049, B:21:0x0054, B:25:0x0065, B:27:0x0070, B:29:0x007d, B:32:0x0085, B:36:0x00d2, B:38:0x00d8, B:41:0x00ec, B:42:0x0102, B:34:0x009a, B:35:0x00af), top: B:56:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0082 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getEmojiSuggestions$125(final java.lang.String[] r15, final org.rbmain.messenger.MediaDataController.KeywordResultCallback r16, java.lang.String r17, boolean r18, final java.util.ArrayList r19, java.util.concurrent.CountDownLatch r20) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MediaDataController.lambda$getEmojiSuggestions$125(java.lang.String[], org.rbmain.messenger.MediaDataController$KeywordResultCallback, java.lang.String, boolean, java.util.ArrayList, java.util.concurrent.CountDownLatch):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getEmojiSuggestions$122(String[] strArr, KeywordResultCallback keywordResultCallback, ArrayList arrayList) {
        for (String str : strArr) {
            if (this.currentFetchingEmoji.get(str) != null) {
                return;
            }
        }
        keywordResultCallback.run(arrayList, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getEmojiSuggestions$123(ArrayList arrayList, KeywordResult keywordResult, KeywordResult keywordResult2) {
        int iIndexOf = arrayList.indexOf(keywordResult.emoji);
        int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
        if (iIndexOf < 0) {
            iIndexOf = ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        int iIndexOf2 = arrayList.indexOf(keywordResult2.emoji);
        if (iIndexOf2 >= 0) {
            i = iIndexOf2;
        }
        if (iIndexOf < i) {
            return -1;
        }
        if (iIndexOf > i) {
            return 1;
        }
        int length = keywordResult.keyword.length();
        int length2 = keywordResult2.keyword.length();
        if (length < length2) {
            return -1;
        }
        return length > length2 ? 1 : 0;
    }

    public static TLRPC$TL_attachMenuBotIcon getStaticAttachMenuBotIcon(TLRPC$TL_attachMenuBot tLRPC$TL_attachMenuBot) {
        throw null;
    }

    public static void addTextStyleRuns(MessageObject messageObject, Spannable spannable) {
        addTextStyleRuns(messageObject.messageOwner.entities, messageObject.messageText, spannable, -1);
    }

    public static void addTextStyleRuns(TLRPC$DraftMessage tLRPC$DraftMessage, Spannable spannable, int i) {
        addTextStyleRuns(tLRPC$DraftMessage.entities, tLRPC$DraftMessage.message, spannable, i);
    }

    public static void addTextStyleRuns(MessageObject messageObject, Spannable spannable, int i) {
        addTextStyleRuns(messageObject.messageOwner.entities, messageObject.messageText, spannable, i);
    }

    public static void addTextStyleRuns(ArrayList<TLRPC$MessageEntity> arrayList, CharSequence charSequence, Spannable spannable) {
        addTextStyleRuns(arrayList, charSequence, spannable, -1);
    }

    public static void addTextStyleRuns(ArrayList<TLRPC$MessageEntity> arrayList, CharSequence charSequence, Spannable spannable, int i) {
        for (TextStyleSpan textStyleSpan : (TextStyleSpan[]) spannable.getSpans(0, spannable.length(), TextStyleSpan.class)) {
            spannable.removeSpan(textStyleSpan);
        }
        Iterator<TextStyleSpan.TextStyleRun> it = getTextStyleRuns(arrayList, charSequence, i).iterator();
        while (it.hasNext()) {
            TextStyleSpan.TextStyleRun next = it.next();
            addStyleToText(new TextStyleSpan(next), next.start, next.end, spannable, true);
        }
    }

    public ArrayList<TLRPC$Reaction> getRecentReactions() {
        return this.recentReactions;
    }

    public void clearRecentReactions() {
        this.recentReactions.clear();
        ApplicationLoader.applicationContext.getSharedPreferences("recent_reactions_" + this.currentAccount, 0).edit().clear().apply();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_clearRecentReactions
            public static int constructor = -1644236876;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController.2
            @Override // org.rbmain.tgnet.RequestDelegate
            public void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            }
        });
    }

    public ArrayList<TLRPC$Reaction> getTopReactions() {
        return this.topReactions;
    }

    public void loadRecentAndTopReactions(boolean z) {
        if (this.loadingRecentReactions || !this.recentReactions.isEmpty() || z) {
            return;
        }
        final SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("recent_reactions_" + this.currentAccount, 0);
        final SharedPreferences sharedPreferences2 = ApplicationLoader.applicationContext.getSharedPreferences("top_reactions_" + this.currentAccount, 0);
        this.recentReactions.clear();
        this.topReactions.clear();
        this.recentReactions.addAll(loadReactionsFromPref(sharedPreferences));
        this.topReactions.addAll(loadReactionsFromPref(sharedPreferences2));
        this.loadingRecentReactions = true;
        TLRPC$TL_messages_getRecentReactions tLRPC$TL_messages_getRecentReactions = new TLRPC$TL_messages_getRecentReactions();
        tLRPC$TL_messages_getRecentReactions.hash = sharedPreferences.getLong("hash", 0L);
        tLRPC$TL_messages_getRecentReactions.limit = 50;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getRecentReactions, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda110
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadRecentAndTopReactions$126(sharedPreferences, tLObject, tLRPC$TL_error);
            }
        });
        TLRPC$TL_messages_getTopReactions tLRPC$TL_messages_getTopReactions = new TLRPC$TL_messages_getTopReactions();
        tLRPC$TL_messages_getTopReactions.hash = sharedPreferences2.getLong("hash", 0L);
        tLRPC$TL_messages_getTopReactions.limit = 100;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getTopReactions, new RequestDelegate() { // from class: org.rbmain.messenger.MediaDataController$$ExternalSyntheticLambda111
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadRecentAndTopReactions$127(sharedPreferences2, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadRecentAndTopReactions$126(SharedPreferences sharedPreferences, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            if (tLObject instanceof TLRPC$TL_messages_reactions) {
                TLRPC$TL_messages_reactions tLRPC$TL_messages_reactions = (TLRPC$TL_messages_reactions) tLObject;
                this.recentReactions.clear();
                this.recentReactions.addAll(tLRPC$TL_messages_reactions.reactions);
                saveReactionsToPref(sharedPreferences, tLRPC$TL_messages_reactions.hash, tLRPC$TL_messages_reactions.reactions);
            }
            boolean z = tLObject instanceof TLRPC$TL_messages_reactionsNotModified;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadRecentAndTopReactions$127(SharedPreferences sharedPreferences, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            if (tLObject instanceof TLRPC$TL_messages_reactions) {
                TLRPC$TL_messages_reactions tLRPC$TL_messages_reactions = (TLRPC$TL_messages_reactions) tLObject;
                this.topReactions.clear();
                this.topReactions.addAll(tLRPC$TL_messages_reactions.reactions);
                saveReactionsToPref(sharedPreferences, tLRPC$TL_messages_reactions.hash, tLRPC$TL_messages_reactions.reactions);
            }
            boolean z = tLObject instanceof TLRPC$TL_messages_reactionsNotModified;
        }
    }

    public static void saveReactionsToPref(SharedPreferences sharedPreferences, long j, ArrayList<? extends TLObject> arrayList) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt(NotificationBadge.NewHtcHomeBadger.COUNT, arrayList.size());
        editorEdit.putLong("hash", j);
        for (int i = 0; i < arrayList.size(); i++) {
            TLObject tLObject = arrayList.get(i);
            SerializedData serializedData = new SerializedData(tLObject.getObjectSize());
            tLObject.serializeToStream(serializedData);
            editorEdit.putString("object_" + i, Utilities.bytesToHex(serializedData.toByteArray()));
        }
        editorEdit.apply();
    }

    public static ArrayList<TLRPC$Reaction> loadReactionsFromPref(SharedPreferences sharedPreferences) {
        int i = sharedPreferences.getInt(NotificationBadge.NewHtcHomeBadger.COUNT, 0);
        ArrayList<TLRPC$Reaction> arrayList = new ArrayList<>(i);
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                SerializedData serializedData = new SerializedData(Utilities.hexToBytes(sharedPreferences.getString("object_" + i2, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR)));
                try {
                    arrayList.add(TLRPC$Reaction.TLdeserialize(serializedData, serializedData.readInt32(true), true));
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        }
        return arrayList;
    }

    public TLRPC$TL_messages_stickerSet getStickerSet(TLRPC$InputStickerSet tLRPC$InputStickerSet, boolean z) {
        return getStickerSet(tLRPC$InputStickerSet, null, z, null);
    }

    public TLRPC$TL_messages_stickerSet getStickerSet(TLRPC$InputStickerSet tLRPC$InputStickerSet, Integer num, boolean z) {
        return getStickerSet(tLRPC$InputStickerSet, num, z, null);
    }

    public static void addAnimatedEmojiSpans(ArrayList<TLRPC$MessageEntity> arrayList, CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt) {
        AnimatedEmojiSpan animatedEmojiSpan;
        if (!(charSequence instanceof Spannable) || arrayList == null) {
            return;
        }
        Spannable spannable = (Spannable) charSequence;
        for (AnimatedEmojiSpan animatedEmojiSpan2 : (AnimatedEmojiSpan[]) spannable.getSpans(0, spannable.length(), AnimatedEmojiSpan.class)) {
            if (animatedEmojiSpan2 != null) {
                spannable.removeSpan(animatedEmojiSpan2);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$MessageEntity tLRPC$MessageEntity = arrayList.get(i);
            if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityCustomEmoji) {
                TLRPC$TL_messageEntityCustomEmoji tLRPC$TL_messageEntityCustomEmoji = (TLRPC$TL_messageEntityCustomEmoji) tLRPC$MessageEntity;
                int i2 = tLRPC$MessageEntity.offset;
                int i3 = tLRPC$MessageEntity.length + i2;
                if (i2 < i3 && i3 <= spannable.length()) {
                    if (tLRPC$TL_messageEntityCustomEmoji.document != null) {
                        animatedEmojiSpan = new AnimatedEmojiSpan(tLRPC$TL_messageEntityCustomEmoji.document, fontMetricsInt);
                    } else {
                        animatedEmojiSpan = new AnimatedEmojiSpan(tLRPC$TL_messageEntityCustomEmoji.document_id, fontMetricsInt);
                    }
                    spannable.setSpan(animatedEmojiSpan, i2, i3, 33);
                }
            }
        }
    }
}
