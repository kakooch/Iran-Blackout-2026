package ir.eitaa.messenger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import androidx.core.content.pm.ShortcutManagerCompat;
import ir.eitaa.SQLite.SQLiteCursor;
import ir.eitaa.SQLite.SQLiteDatabase;
import ir.eitaa.SQLite.SQLiteException;
import ir.eitaa.SQLite.SQLitePreparedStatement;
import ir.eitaa.messenger.support.SparseLongArray;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInfo;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$DraftMessage;
import ir.eitaa.tgnet.TLRPC$EmojiKeyword;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$MessagesFilter;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_channels_getMessages;
import ir.eitaa.tgnet.TLRPC$TL_contacts_getTopPeers;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resetTopPeerRating;
import ir.eitaa.tgnet.TLRPC$TL_contacts_topPeers;
import ir.eitaa.tgnet.TLRPC$TL_contacts_topPeersDisabled;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAnimated;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_documentEmpty;
import ir.eitaa.tgnet.TLRPC$TL_draftMessage;
import ir.eitaa.tgnet.TLRPC$TL_draftMessageEmpty;
import ir.eitaa.tgnet.TLRPC$TL_emojiKeyword;
import ir.eitaa.tgnet.TLRPC$TL_emojiKeywordDeleted;
import ir.eitaa.tgnet.TLRPC$TL_emojiKeywordsDifference;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputMessageEntityMentionName;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterGif;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterMusic;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterPhotoVideo;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterPinned;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterRoundVoice;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterUrl;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetAnimatedEmoji;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetDice;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetShortName;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageActionGameScore;
import ir.eitaa.tgnet.TLRPC$TL_messageActionHistoryClear;
import ir.eitaa.tgnet.TLRPC$TL_messageActionPaymentSent;
import ir.eitaa.tgnet.TLRPC$TL_messageActionPinMessage;
import ir.eitaa.tgnet.TLRPC$TL_messageEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityBlockquote;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityBold;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityCode;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityEmail;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityItalic;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityMentionName;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityPre;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityStrike;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityTextUrl;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityUnderline;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityUrl;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageReplyHeader;
import ir.eitaa.tgnet.TLRPC$TL_messageService;
import ir.eitaa.tgnet.TLRPC$TL_message_secret;
import ir.eitaa.tgnet.TLRPC$TL_messages_allStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_archivedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_channelMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_faveSticker;
import ir.eitaa.tgnet.TLRPC$TL_messages_featuredStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getAllStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getArchivedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getFeaturedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getMaskStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_getSearchCounters;
import ir.eitaa.tgnet.TLRPC$TL_messages_getStickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_installStickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_messagesSlice;
import ir.eitaa.tgnet.TLRPC$TL_messages_readFeaturedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_saveDraft;
import ir.eitaa.tgnet.TLRPC$TL_messages_saveGif;
import ir.eitaa.tgnet.TLRPC$TL_messages_saveRecentSticker;
import ir.eitaa.tgnet.TLRPC$TL_messages_savedGifs;
import ir.eitaa.tgnet.TLRPC$TL_messages_search;
import ir.eitaa.tgnet.TLRPC$TL_messages_searchCounter;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSetInstallResultArchive;
import ir.eitaa.tgnet.TLRPC$TL_messages_toggleStickerSets;
import ir.eitaa.tgnet.TLRPC$TL_messages_uninstallStickerSet;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_stickerPack;
import ir.eitaa.tgnet.TLRPC$TL_topPeer;
import ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryBotsInline;
import ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryCorrespondents;
import ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryPeers;
import ir.eitaa.tgnet.TLRPC$TL_updateBotCommands;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.StickerSetBulletinLayout;
import ir.eitaa.ui.Components.StickersArchiveAlert;
import ir.eitaa.ui.Components.TextStyleSpan;
import ir.eitaa.ui.Components.URLSpanReplacement;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public class MediaDataController extends BaseController {
    public static final int MEDIA_AUDIO = 2;
    public static final int MEDIA_FILE = 1;
    public static final int MEDIA_GIF = 5;
    public static final int MEDIA_MUSIC = 4;
    public static final int MEDIA_PHOTOVIDEO = 0;
    public static final int MEDIA_TYPES_COUNT = 6;
    public static final int MEDIA_URL = 3;
    public static String SHORTCUT_CATEGORY = "ir.eitaa.messenger.SHORTCUT_SHARE";
    public static final int TYPE_EMOJI = 4;
    public static final int TYPE_FAVE = 2;
    public static final int TYPE_FEATURED = 3;
    public static final int TYPE_GREETINGS = 3;
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_MASK = 1;
    private static RectF bitmapRect;
    private static Paint erasePaint;
    private static Paint roundPaint;
    private static Path roundPath;
    private HashMap<String, ArrayList<TLRPC$Document>> allStickers;
    private HashMap<String, ArrayList<TLRPC$Document>> allStickersFeatured;
    private int[] archivedStickersCount;
    private HashMap<String, TLRPC$BotInfo> botInfos;
    private LongSparseArray<TLRPC$Message> botKeyboards;
    private SparseLongArray botKeyboardsByMids;
    private HashMap<String, Boolean> currentFetchingEmoji;
    private LongSparseArray<String> diceEmojiStickerSetsById;
    private HashMap<String, TLRPC$TL_messages_stickerSet> diceStickerSetsByEmoji;
    private LongSparseArray<SparseArray<TLRPC$Message>> draftMessages;
    private SharedPreferences draftPreferences;
    private LongSparseArray<SparseArray<TLRPC$DraftMessage>> drafts;
    private LongSparseArray<Integer> draftsFolderIds;
    private ArrayList<TLRPC$StickerSetCovered> featuredStickerSets;
    private LongSparseArray<TLRPC$StickerSetCovered> featuredStickerSetsById;
    private boolean featuredStickersLoaded;
    private TLRPC$Document greetingsSticker;
    private LongSparseArray<TLRPC$TL_messages_stickerSet> groupStickerSets;
    public ArrayList<TLRPC$TL_topPeer> hints;
    private boolean inTransaction;
    public ArrayList<TLRPC$TL_topPeer> inlineBots;
    private LongSparseArray<TLRPC$TL_messages_stickerSet> installedStickerSetsById;
    private long lastDialogId;
    private int lastGuid;
    private long lastMergeDialogId;
    private int lastReplyMessageId;
    private int lastReqId;
    private int lastReturnedNum;
    private TLRPC$Chat lastSearchChat;
    private String lastSearchQuery;
    private TLRPC$User lastSearchUser;
    private int[] loadDate;
    private int loadFeaturedDate;
    private long loadFeaturedHash;
    private long[] loadHash;
    boolean loaded;
    boolean loading;
    private HashSet<String> loadingDiceStickerSets;
    private boolean loadingDrafts;
    private boolean loadingFeaturedStickers;
    private boolean loadingMoreSearchMessages;
    private LongSparseArray<Boolean> loadingPinnedMessages;
    private boolean loadingRecentGifs;
    private boolean[] loadingRecentStickers;
    private boolean[] loadingStickers;
    private int mergeReqId;
    private int[] messagesSearchCount;
    private boolean[] messagesSearchEndReached;
    private ArrayList<Long> readingStickerSets;
    private ArrayList<TLRPC$Document> recentGifs;
    private boolean recentGifsLoaded;
    private ArrayList<TLRPC$Document>[] recentStickers;
    private boolean[] recentStickersLoaded;
    private LongSparseArray<Runnable> removingStickerSetsUndos;
    private int reqId;
    private Runnable[] scheduledLoadStickers;
    private ArrayList<MessageObject> searchResultMessages;
    private SparseArray<MessageObject>[] searchResultMessagesMap;
    private ArrayList<TLRPC$TL_messages_stickerSet>[] stickerSets;
    private LongSparseArray<TLRPC$TL_messages_stickerSet> stickerSetsById;
    private ConcurrentHashMap<String, TLRPC$TL_messages_stickerSet> stickerSetsByName;
    private LongSparseArray<String> stickersByEmoji;
    private LongSparseArray<TLRPC$Document>[] stickersByIds;
    private boolean[] stickersLoaded;
    private ArrayList<Long> unreadStickerSets;
    private HashMap<String, ArrayList<TLRPC$Message>> verifyingMessages;
    private static volatile MediaDataController[] Instance = new MediaDataController[3];
    private static Comparator<TLRPC$MessageEntity> entityComparator = $$Lambda$MediaDataController$NVeiwl1lJrh182MOC9WR73HTY3c.INSTANCE;

    public static class KeywordResult {
        public String emoji;
        public String keyword;
    }

    public interface KeywordResultCallback {
        void run(ArrayList<KeywordResult> param, String alias);
    }

    public static long calcHash(long hash, long id) {
        return (((hash ^ (id >> 21)) ^ (id << 35)) ^ (id >> 4)) + id;
    }

    static /* synthetic */ void lambda$markFaturedStickersAsRead$30(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$markFaturedStickersByIdAsRead$31(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$removeInline$96(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$removePeer$97(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$saveDraft$124(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public static MediaDataController getInstance(int num) {
        MediaDataController mediaDataController = Instance[num];
        if (mediaDataController == null) {
            synchronized (MediaDataController.class) {
                mediaDataController = Instance[num];
                if (mediaDataController == null) {
                    MediaDataController[] mediaDataControllerArr = Instance;
                    MediaDataController mediaDataController2 = new MediaDataController(num);
                    mediaDataControllerArr[num] = mediaDataController2;
                    mediaDataController = mediaDataController2;
                }
            }
        }
        return mediaDataController;
    }

    public MediaDataController(int num) {
        String key;
        long jLongValue;
        SerializedData serializedData;
        boolean zStartsWith;
        super(num);
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
        this.scheduledLoadStickers = new Runnable[5];
        this.loadingStickers = new boolean[5];
        this.stickersLoaded = new boolean[5];
        this.loadHash = new long[5];
        this.loadDate = new int[5];
        this.verifyingMessages = new HashMap<>();
        this.archivedStickersCount = new int[2];
        this.stickersByEmoji = new LongSparseArray<>();
        this.allStickers = new HashMap<>();
        this.allStickersFeatured = new HashMap<>();
        this.recentStickers = new ArrayList[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()};
        this.loadingRecentStickers = new boolean[4];
        this.recentStickersLoaded = new boolean[4];
        this.recentGifs = new ArrayList<>();
        this.featuredStickerSets = new ArrayList<>();
        this.featuredStickerSetsById = new LongSparseArray<>();
        this.unreadStickerSets = new ArrayList<>();
        this.readingStickerSets = new ArrayList<>();
        this.messagesSearchCount = new int[]{0, 0};
        this.messagesSearchEndReached = new boolean[]{false, false};
        this.searchResultMessages = new ArrayList<>();
        this.searchResultMessagesMap = new SparseArray[]{new SparseArray<>(), new SparseArray<>()};
        this.hints = new ArrayList<>();
        this.inlineBots = new ArrayList<>();
        this.loadingPinnedMessages = new LongSparseArray<>();
        this.draftsFolderIds = new LongSparseArray<>();
        this.drafts = new LongSparseArray<>();
        this.draftMessages = new LongSparseArray<>();
        this.botInfos = new HashMap<>();
        this.botKeyboards = new LongSparseArray<>();
        this.botKeyboardsByMids = new SparseLongArray();
        this.currentFetchingEmoji = new HashMap<>();
        if (this.currentAccount == 0) {
            this.draftPreferences = ApplicationLoader.applicationContext.getSharedPreferences("drafts", 0);
        } else {
            this.draftPreferences = ApplicationLoader.applicationContext.getSharedPreferences("drafts" + this.currentAccount, 0);
        }
        for (Map.Entry<String, ?> entry : this.draftPreferences.getAll().entrySet()) {
            try {
                key = entry.getKey();
                jLongValue = Utilities.parseLong(key).longValue();
                serializedData = new SerializedData(Utilities.hexToBytes((String) entry.getValue()));
            } catch (Exception unused) {
            }
            if (key.startsWith("r_")) {
                zStartsWith = false;
            } else {
                zStartsWith = key.startsWith("rt_");
                if (!zStartsWith) {
                    TLRPC$DraftMessage tLRPC$DraftMessageTLdeserialize = TLRPC$DraftMessage.TLdeserialize(serializedData, serializedData.readInt32(true), true);
                    if (tLRPC$DraftMessageTLdeserialize != null) {
                        SparseArray<TLRPC$DraftMessage> sparseArray = this.drafts.get(jLongValue);
                        if (sparseArray == null) {
                            sparseArray = new SparseArray<>();
                            this.drafts.put(jLongValue, sparseArray);
                        }
                        sparseArray.put(key.startsWith("t_") ? Utilities.parseInt(key.substring(key.lastIndexOf(95) + 1)).intValue() : 0, tLRPC$DraftMessageTLdeserialize);
                    }
                    serializedData.cleanup();
                }
            }
            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(serializedData, serializedData.readInt32(true), true);
            if (tLRPC$MessageTLdeserialize != null) {
                tLRPC$MessageTLdeserialize.readAttachPath(serializedData, getUserConfig().clientUserId);
                SparseArray<TLRPC$Message> sparseArray2 = this.draftMessages.get(jLongValue);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray<>();
                    this.draftMessages.put(jLongValue, sparseArray2);
                }
                sparseArray2.put(zStartsWith ? Utilities.parseInt(key.substring(key.lastIndexOf(95) + 1)).intValue() : 0, tLRPC$MessageTLdeserialize);
            }
            serializedData.cleanup();
        }
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
        this.loadingPinnedMessages.clear();
        this.loadFeaturedDate = 0;
        this.loadFeaturedHash = 0L;
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
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$F1bkcnAYa1lnJLWLLI7TIF8Qp1s
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
        this.draftPreferences.edit().clear().commit();
        this.botInfos.clear();
        this.botKeyboards.clear();
        this.botKeyboardsByMids.clear();
    }

    static /* synthetic */ void lambda$cleanup$0() {
        try {
            ShortcutManagerCompat.removeAllDynamicShortcuts(ApplicationLoader.applicationContext);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void checkStickers(int type) {
        if (this.loadingStickers[type]) {
            return;
        }
        if (!this.stickersLoaded[type] || Math.abs((System.currentTimeMillis() / 1000) - this.loadDate[type]) >= 3600) {
            loadStickers(type, true, false);
        }
    }

    public void checkFeaturedStickers() {
        if (this.loadingFeaturedStickers) {
            return;
        }
        if (!this.featuredStickersLoaded || Math.abs((System.currentTimeMillis() / 1000) - this.loadFeaturedDate) >= 3600) {
            loadFeaturedStickers(true, false);
        }
    }

    public ArrayList<TLRPC$Document> getRecentStickers(int type) {
        ArrayList<TLRPC$Document> arrayList = this.recentStickers[type];
        return new ArrayList<>(arrayList.subList(0, Math.min(arrayList.size(), 20)));
    }

    public ArrayList<TLRPC$Document> getRecentStickersNoCopy(int type) {
        return this.recentStickers[type];
    }

    public boolean isStickerInFavorites(TLRPC$Document document) {
        if (document == null) {
            return false;
        }
        for (int i = 0; i < this.recentStickers[2].size(); i++) {
            TLRPC$Document tLRPC$Document = this.recentStickers[2].get(i);
            if (tLRPC$Document.id == document.id && tLRPC$Document.dc_id == document.dc_id) {
                return true;
            }
        }
        return false;
    }

    public void addRecentSticker(final int type, final Object parentObject, TLRPC$Document document, int date, boolean remove) {
        boolean z;
        int i;
        final TLRPC$Document tLRPC$DocumentRemove;
        if (type != 3) {
            if (MessageObject.isStickerDocument(document) || MessageObject.isAnimatedStickerDocument(document, true)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.recentStickers[type].size()) {
                        z = false;
                        break;
                    }
                    TLRPC$Document tLRPC$Document = this.recentStickers[type].get(i2);
                    if (tLRPC$Document.id == document.id) {
                        this.recentStickers[type].remove(i2);
                        if (!remove) {
                            this.recentStickers[type].add(0, tLRPC$Document);
                        }
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (!z && !remove) {
                    this.recentStickers[type].add(0, document);
                }
                if (type == 2) {
                    if (remove) {
                        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 0, document, 4);
                    } else {
                        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 0, document, 5);
                    }
                    final TLRPC$TL_messages_faveSticker tLRPC$TL_messages_faveSticker = new TLRPC$TL_messages_faveSticker();
                    TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
                    tLRPC$TL_messages_faveSticker.id = tLRPC$TL_inputDocument;
                    tLRPC$TL_inputDocument.id = document.id;
                    tLRPC$TL_inputDocument.access_hash = document.access_hash;
                    byte[] bArr = document.file_reference;
                    tLRPC$TL_inputDocument.file_reference = bArr;
                    if (bArr == null) {
                        tLRPC$TL_inputDocument.file_reference = new byte[0];
                    }
                    tLRPC$TL_messages_faveSticker.unfave = remove;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_faveSticker, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$w1XMmVY8pQ_u1FX2OSnVn-mr_Uc
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$addRecentSticker$2$MediaDataController(parentObject, tLRPC$TL_messages_faveSticker, tLObject, tLRPC$TL_error);
                        }
                    });
                    i = getMessagesController().maxFaveStickersCount;
                } else {
                    if (type == 0 && remove) {
                        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 0, document, 3);
                        final TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker = new TLRPC$TL_messages_saveRecentSticker();
                        TLRPC$TL_inputDocument tLRPC$TL_inputDocument2 = new TLRPC$TL_inputDocument();
                        tLRPC$TL_messages_saveRecentSticker.id = tLRPC$TL_inputDocument2;
                        tLRPC$TL_inputDocument2.id = document.id;
                        tLRPC$TL_inputDocument2.access_hash = document.access_hash;
                        byte[] bArr2 = document.file_reference;
                        tLRPC$TL_inputDocument2.file_reference = bArr2;
                        if (bArr2 == null) {
                            tLRPC$TL_inputDocument2.file_reference = new byte[0];
                        }
                        tLRPC$TL_messages_saveRecentSticker.unsave = true;
                        getConnectionsManager().sendRequest(tLRPC$TL_messages_saveRecentSticker, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$YIB8s9TrZS7OrrDcJJ3cqkWqMhI
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$addRecentSticker$3$MediaDataController(parentObject, tLRPC$TL_messages_saveRecentSticker, tLObject, tLRPC$TL_error);
                            }
                        });
                    }
                    i = getMessagesController().maxRecentStickersCount;
                }
                if (this.recentStickers[type].size() > i || remove) {
                    if (remove) {
                        tLRPC$DocumentRemove = document;
                    } else {
                        ArrayList<TLRPC$Document>[] arrayListArr = this.recentStickers;
                        tLRPC$DocumentRemove = arrayListArr[type].remove(arrayListArr[type].size() - 1);
                    }
                    getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$2rMcrYFf-FvhVfvZ5zAe6KMmpCU
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$addRecentSticker$4$MediaDataController(type, tLRPC$DocumentRemove);
                        }
                    });
                }
                if (!remove) {
                    ArrayList<TLRPC$Document> arrayList = new ArrayList<>();
                    arrayList.add(document);
                    processLoadedRecentDocuments(type, arrayList, false, date, false);
                }
                if (type == 2 || (type == 0 && remove)) {
                    getNotificationCenter().postNotificationName(NotificationCenter.recentDocumentsDidLoad, Boolean.FALSE, Integer.valueOf(type));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addRecentSticker$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addRecentSticker$2$MediaDataController(Object obj, TLRPC$TL_messages_faveSticker tLRPC$TL_messages_faveSticker, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null && FileRefController.isFileRefError(tLRPC$TL_error.text) && obj != null) {
            getFileRefController().requestReference(obj, tLRPC$TL_messages_faveSticker);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$6kJb30W006tNNE3Y-SyxtwQl0R4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addRecentSticker$1$MediaDataController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addRecentSticker$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addRecentSticker$1$MediaDataController() {
        getMediaDataController().loadRecents(2, false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addRecentSticker$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addRecentSticker$3$MediaDataController(Object obj, TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || !FileRefController.isFileRefError(tLRPC$TL_error.text) || obj == null) {
            return;
        }
        getFileRefController().requestReference(obj, tLRPC$TL_messages_saveRecentSticker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addRecentSticker$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addRecentSticker$4$MediaDataController(int i, TLRPC$Document tLRPC$Document) {
        int i2 = i == 0 ? 3 : i == 1 ? 4 : 5;
        try {
            getMessagesStorage().getDatabase().executeFast("DELETE FROM web_recent_v3 WHERE id = '" + tLRPC$Document.id + "' AND type = " + i2).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public ArrayList<TLRPC$Document> getRecentGifs() {
        return new ArrayList<>(this.recentGifs);
    }

    public void removeRecentGif(final TLRPC$Document document) {
        int size = this.recentGifs.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (this.recentGifs.get(i).id == document.id) {
                this.recentGifs.remove(i);
                break;
            }
            i++;
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
        tLRPC$TL_messages_saveGif.unsave = true;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_saveGif, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$mr6TwupzyYnvgFGdhVk_XTbQde4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$removeRecentGif$5$MediaDataController(tLRPC$TL_messages_saveGif, tLObject, tLRPC$TL_error);
            }
        });
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$A4JujCdJT1hV4UkkhvXL5s1P3U4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeRecentGif$6$MediaDataController(document);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeRecentGif$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeRecentGif$5$MediaDataController(TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null || !FileRefController.isFileRefError(tLRPC$TL_error.text)) {
            return;
        }
        getFileRefController().requestReference("gif", tLRPC$TL_messages_saveGif);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeRecentGif$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeRecentGif$6$MediaDataController(TLRPC$Document tLRPC$Document) {
        try {
            getMessagesStorage().getDatabase().executeFast("DELETE FROM web_recent_v3 WHERE id = '" + tLRPC$Document.id + "' AND type = 2").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public boolean hasRecentGif(TLRPC$Document document) {
        for (int i = 0; i < this.recentGifs.size(); i++) {
            TLRPC$Document tLRPC$Document = this.recentGifs.get(i);
            if (tLRPC$Document.id == document.id) {
                this.recentGifs.remove(i);
                this.recentGifs.add(0, tLRPC$Document);
                return true;
            }
        }
        return false;
    }

    public void addRecentGif(TLRPC$Document document, int date) {
        boolean z;
        if (document == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.recentGifs.size()) {
                z = false;
                break;
            }
            TLRPC$Document tLRPC$Document = this.recentGifs.get(i);
            if (tLRPC$Document.id == document.id) {
                this.recentGifs.remove(i);
                this.recentGifs.add(0, tLRPC$Document);
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            this.recentGifs.add(0, document);
        }
        if (this.recentGifs.size() > getMessagesController().maxRecentGifsCount) {
            ArrayList<TLRPC$Document> arrayList = this.recentGifs;
            final TLRPC$Document tLRPC$DocumentRemove = arrayList.remove(arrayList.size() - 1);
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$BjvHoOVV5lYg8qVvTCrEb1RLTiU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addRecentGif$7$MediaDataController(tLRPC$DocumentRemove);
                }
            });
        }
        ArrayList<TLRPC$Document> arrayList2 = new ArrayList<>();
        arrayList2.add(document);
        processLoadedRecentDocuments(0, arrayList2, true, date, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addRecentGif$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addRecentGif$7$MediaDataController(TLRPC$Document tLRPC$Document) {
        try {
            getMessagesStorage().getDatabase().executeFast("DELETE FROM web_recent_v3 WHERE id = '" + tLRPC$Document.id + "' AND type = 2").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public boolean isLoadingStickers(int type) {
        return this.loadingStickers[type];
    }

    public void replaceStickerSet(final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2 = this.stickerSetsById.get(tLRPC$TL_messages_stickerSet.set.id);
        String str = this.diceEmojiStickerSetsById.get(tLRPC$TL_messages_stickerSet.set.id);
        if (str != null) {
            this.diceStickerSetsByEmoji.put(str, tLRPC$TL_messages_stickerSet);
            putDiceStickersToCache(str, tLRPC$TL_messages_stickerSet, (int) (System.currentTimeMillis() / 1000));
        }
        if (tLRPC$TL_messages_stickerSet2 == null) {
            tLRPC$TL_messages_stickerSet2 = (TLRPC$TL_messages_stickerSet) this.stickerSetsByName.get(tLRPC$TL_messages_stickerSet.set.short_name);
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$9o63GvmpKBCpV5fBDvmOURExNWs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$replaceStickerSet$8$MediaDataController(tLRPC$TL_messages_stickerSet);
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
    /* renamed from: lambda$replaceStickerSet$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$replaceStickerSet$8$MediaDataController(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        LongSparseArray<TLRPC$Document> stickerByIds = getStickerByIds(4);
        for (int i = 0; i < tLRPC$TL_messages_stickerSet.documents.size(); i++) {
            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i);
            stickerByIds.put(tLRPC$Document.id, tLRPC$Document);
        }
    }

    public TLRPC$TL_messages_stickerSet getStickerSetByName(String name) {
        return (TLRPC$TL_messages_stickerSet) this.stickerSetsByName.get(name);
    }

    public TLRPC$TL_messages_stickerSet getStickerSetByEmojiOrName(String emoji) {
        return this.diceStickerSetsByEmoji.get(emoji);
    }

    public TLRPC$TL_messages_stickerSet getStickerSetById(long id) {
        return this.stickerSetsById.get(id);
    }

    public TLRPC$TL_messages_stickerSet getGroupStickerSetById(TLRPC$StickerSet stickerSet) {
        TLRPC$StickerSet tLRPC$StickerSet;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSetsById.get(stickerSet.id);
        if (tLRPC$TL_messages_stickerSet == null) {
            tLRPC$TL_messages_stickerSet = this.groupStickerSets.get(stickerSet.id);
            if (tLRPC$TL_messages_stickerSet == null || (tLRPC$StickerSet = tLRPC$TL_messages_stickerSet.set) == null) {
                loadGroupStickerSet(stickerSet, true);
            } else if (tLRPC$StickerSet.hash != stickerSet.hash) {
                loadGroupStickerSet(stickerSet, false);
            }
        }
        return tLRPC$TL_messages_stickerSet;
    }

    public void putGroupStickerSet(TLRPC$TL_messages_stickerSet stickerSet) {
        this.groupStickerSets.put(stickerSet.set.id, stickerSet);
    }

    private void loadGroupStickerSet(final TLRPC$StickerSet stickerSet, boolean cache) {
        if (cache) {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$fj2ka77MQYGQkyYR-yNjt9tt9UA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadGroupStickerSet$10$MediaDataController(stickerSet);
                }
            });
            return;
        }
        TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
        TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
        tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetID;
        tLRPC$TL_inputStickerSetID.id = stickerSet.id;
        tLRPC$TL_inputStickerSetID.access_hash = stickerSet.access_hash;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$_wdBy37xd-GPUuezGTccq_xhY4c
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadGroupStickerSet$12$MediaDataController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadGroupStickerSet$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadGroupStickerSet$10$MediaDataController(TLRPC$StickerSet tLRPC$StickerSet) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$cCaBsRdpo9hUdBv_vrUaP4XRXh0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadGroupStickerSet$9$MediaDataController(tLRPC$TL_messages_stickerSetTLdeserialize);
                }
            });
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadGroupStickerSet$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadGroupStickerSet$9$MediaDataController(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        this.groupStickerSets.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
        getNotificationCenter().postNotificationName(NotificationCenter.groupStickersDidLoad, Long.valueOf(tLRPC$TL_messages_stickerSet.set.id));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadGroupStickerSet$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadGroupStickerSet$12$MediaDataController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$jlaPaSml_F4AymUnRKqjkplDh5U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadGroupStickerSet$11$MediaDataController(tLRPC$TL_messages_stickerSet);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadGroupStickerSet$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadGroupStickerSet$11$MediaDataController(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        this.groupStickerSets.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
        getNotificationCenter().postNotificationName(NotificationCenter.groupStickersDidLoad, Long.valueOf(tLRPC$TL_messages_stickerSet.set.id));
    }

    private void putSetToCache(final TLRPC$TL_messages_stickerSet set) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$OS58u0M__kAUmL9Z6yAblct6j0Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putSetToCache$13$MediaDataController(set);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putSetToCache$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putSetToCache$13$MediaDataController(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO web_recent_v3 VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindString(1, "s_" + tLRPC$TL_messages_stickerSet.set.id);
            sQLitePreparedStatementExecuteFast.bindInteger(2, 6);
            sQLitePreparedStatementExecuteFast.bindString(3, "");
            sQLitePreparedStatementExecuteFast.bindString(4, "");
            sQLitePreparedStatementExecuteFast.bindString(5, "");
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

    public TLRPC$Document getEmojiAnimatedSticker(CharSequence message) {
        String strReplace = message.toString().replace("️", "");
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

    public ArrayList<TLRPC$TL_messages_stickerSet> getStickerSets(int type) {
        if (type == 3) {
            return this.stickerSets[2];
        }
        return this.stickerSets[type];
    }

    public LongSparseArray<TLRPC$Document> getStickerByIds(int type) {
        return this.stickersByIds[type];
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

    public boolean isStickerPackInstalled(long id) {
        return this.installedStickerSetsById.indexOfKey(id) >= 0;
    }

    public boolean isStickerPackUnread(long id) {
        return this.unreadStickerSets.contains(Long.valueOf(id));
    }

    public boolean isStickerPackInstalled(String name) {
        return this.stickerSetsByName.containsKey(name);
    }

    public String getEmojiForSticker(long id) {
        String str = this.stickersByEmoji.get(id);
        return str != null ? str : "";
    }

    public static long calcDocumentsHash(ArrayList<TLRPC$Document> arrayList) {
        return calcDocumentsHash(arrayList, 200);
    }

    public static long calcDocumentsHash(ArrayList<TLRPC$Document> arrayList, int maxCount) {
        long jCalcHash = 0;
        if (arrayList == null) {
            return 0L;
        }
        int iMin = Math.min(maxCount, arrayList.size());
        for (int i = 0; i < iMin; i++) {
            TLRPC$Document tLRPC$Document = arrayList.get(i);
            if (tLRPC$Document != null) {
                jCalcHash = calcHash(jCalcHash, tLRPC$Document.id);
            }
        }
        return jCalcHash;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadRecents(final int r7, final boolean r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.loadRecents(int, boolean, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRecents$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadRecents$15$MediaDataController(final boolean z, final int i) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        int i2 = 3;
        if (z) {
            i2 = 2;
        } else if (i != 0) {
            i2 = i == 1 ? 4 : i == 3 ? 6 : 5;
        }
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized("SELECT document FROM web_recent_v3 WHERE type = " + i2 + " ORDER BY date DESC", new Object[0]);
            final ArrayList arrayList = new ArrayList();
            while (sQLiteCursorQueryFinalized.next()) {
                if (!sQLiteCursorQueryFinalized.isNull(0) && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                    TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    if (tLRPC$DocumentTLdeserialize != null) {
                        arrayList.add(tLRPC$DocumentTLdeserialize);
                    }
                    nativeByteBufferByteBufferValue.reuse();
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$wPyP_2JUF9g41Y3CFN6A3MNNqfc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadRecents$14$MediaDataController(z, arrayList, i);
                }
            });
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$loadRecents$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadRecents$14$MediaDataController(boolean z, ArrayList arrayList, int i) {
        if (z) {
            this.recentGifs = arrayList;
            this.loadingRecentGifs = false;
            this.recentGifsLoaded = true;
        } else {
            this.recentStickers[i] = arrayList;
            this.loadingRecentStickers[i] = false;
            this.recentStickersLoaded[i] = true;
        }
        if (i == 3) {
            preloadNextGreetingsSticker();
        }
        getNotificationCenter().postNotificationName(NotificationCenter.recentDocumentsDidLoad, Boolean.valueOf(z), Integer.valueOf(i));
        loadRecents(i, z, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRecents$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadRecents$16$MediaDataController(int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        processLoadedRecentDocuments(i, tLObject instanceof TLRPC$TL_messages_savedGifs ? ((TLRPC$TL_messages_savedGifs) tLObject).gifs : null, true, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /* renamed from: lambda$loadRecents$17, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadRecents$17$MediaDataController(int r7, ir.eitaa.tgnet.TLObject r8, ir.eitaa.tgnet.TLRPC$TL_error r9) {
        /*
            r6 = this;
            r9 = 3
            if (r7 != r9) goto Lc
            boolean r9 = r8 instanceof ir.eitaa.tgnet.TLRPC$TL_messages_stickers
            if (r9 == 0) goto L21
            ir.eitaa.tgnet.TLRPC$TL_messages_stickers r8 = (ir.eitaa.tgnet.TLRPC$TL_messages_stickers) r8
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Document> r8 = r8.stickers
            goto L22
        Lc:
            r9 = 2
            if (r7 != r9) goto L18
            boolean r9 = r8 instanceof ir.eitaa.tgnet.TLRPC$TL_messages_favedStickers
            if (r9 == 0) goto L21
            ir.eitaa.tgnet.TLRPC$TL_messages_favedStickers r8 = (ir.eitaa.tgnet.TLRPC$TL_messages_favedStickers) r8
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Document> r8 = r8.stickers
            goto L22
        L18:
            boolean r9 = r8 instanceof ir.eitaa.tgnet.TLRPC$TL_messages_recentStickers
            if (r9 == 0) goto L21
            ir.eitaa.tgnet.TLRPC$TL_messages_recentStickers r8 = (ir.eitaa.tgnet.TLRPC$TL_messages_recentStickers) r8
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Document> r8 = r8.stickers
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.lambda$loadRecents$17$MediaDataController(int, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
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

    protected void processLoadedRecentDocuments(final int type, final ArrayList<TLRPC$Document> documents, final boolean gif, final int date, final boolean replace) {
        if (documents != null) {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$ltSi8yDeDZmMGubsLfQCdExQ90I
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedRecentDocuments$18$MediaDataController(gif, type, documents, replace, date);
                }
            });
        }
        if (date == 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$6xiyUBzFwsjQXn4A_yRiTlQvV8I
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedRecentDocuments$19$MediaDataController(gif, type, documents);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedRecentDocuments$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedRecentDocuments$18$MediaDataController(boolean z, int i, ArrayList arrayList, boolean z2, int i2) {
        int i3;
        try {
            SQLiteDatabase database = getMessagesStorage().getDatabase();
            int i4 = 2;
            if (z) {
                i3 = getMessagesController().maxRecentGifsCount;
            } else if (i == 3) {
                i3 = 200;
            } else if (i == 2) {
                i3 = getMessagesController().maxFaveStickersCount;
            } else {
                i3 = getMessagesController().maxRecentStickersCount;
            }
            database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = database.executeFast("REPLACE INTO web_recent_v3 VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            int size = arrayList.size();
            int i5 = z ? 2 : i == 0 ? 3 : i == 1 ? 4 : i == 3 ? 6 : 5;
            if (z2) {
                database.executeFast("DELETE FROM web_recent_v3 WHERE type = " + i5).stepThis().dispose();
            }
            int i6 = 0;
            while (i6 < size && i6 != i3) {
                TLRPC$Document tLRPC$Document = (TLRPC$Document) arrayList.get(i6);
                sQLitePreparedStatementExecuteFast.requery();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                int i7 = i6;
                sb.append(tLRPC$Document.id);
                sQLitePreparedStatementExecuteFast.bindString(1, sb.toString());
                sQLitePreparedStatementExecuteFast.bindInteger(i4, i5);
                sQLitePreparedStatementExecuteFast.bindString(3, "");
                sQLitePreparedStatementExecuteFast.bindString(4, "");
                sQLitePreparedStatementExecuteFast.bindString(5, "");
                sQLitePreparedStatementExecuteFast.bindInteger(6, 0);
                sQLitePreparedStatementExecuteFast.bindInteger(7, 0);
                sQLitePreparedStatementExecuteFast.bindInteger(8, 0);
                sQLitePreparedStatementExecuteFast.bindInteger(9, i2 != 0 ? i2 : size - i7);
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Document.getObjectSize());
                tLRPC$Document.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(10, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
                i6 = i7 + 1;
                i4 = 2;
            }
            sQLitePreparedStatementExecuteFast.dispose();
            database.commitTransaction();
            if (arrayList.size() >= i3) {
                database.beginTransaction();
                while (i3 < arrayList.size()) {
                    database.executeFast("DELETE FROM web_recent_v3 WHERE id = '" + ((TLRPC$Document) arrayList.get(i3)).id + "' AND type = " + i5).stepThis().dispose();
                    i3++;
                }
                database.commitTransaction();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$processLoadedRecentDocuments$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedRecentDocuments$19$MediaDataController(boolean z, int i, ArrayList arrayList) {
        SharedPreferences.Editor editorEdit = MessagesController.getEmojiSettings(this.currentAccount).edit();
        if (z) {
            this.loadingRecentGifs = false;
            this.recentGifsLoaded = true;
            editorEdit.putLong("lastGifLoadTime", System.currentTimeMillis()).commit();
        } else {
            this.loadingRecentStickers[i] = false;
            this.recentStickersLoaded[i] = true;
            if (i == 0) {
                editorEdit.putLong("lastStickersLoadTime", System.currentTimeMillis()).commit();
            } else if (i == 1) {
                editorEdit.putLong("lastStickersLoadTimeMask", System.currentTimeMillis()).commit();
            } else if (i == 3) {
                editorEdit.putLong("lastStickersLoadTimeGreet", System.currentTimeMillis()).commit();
            } else {
                editorEdit.putLong("lastStickersLoadTimeFavs", System.currentTimeMillis()).commit();
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

    public void reorderStickers(int type, ArrayList<Long> order) {
        Collections.sort(this.stickerSets[type], new $$Lambda$MediaDataController$psd8iXY6Hblf8x38zF3O985zaoM(order));
        this.loadHash[type] = calcStickersHash(this.stickerSets[type]);
        getNotificationCenter().postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(type));
        loadStickers(type, false, true);
    }

    static /* synthetic */ int lambda$reorderStickers$20(ArrayList arrayList, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2) {
        int iIndexOf = arrayList.indexOf(Long.valueOf(tLRPC$TL_messages_stickerSet.set.id));
        int iIndexOf2 = arrayList.indexOf(Long.valueOf(tLRPC$TL_messages_stickerSet2.set.id));
        if (iIndexOf > iIndexOf2) {
            return 1;
        }
        return iIndexOf < iIndexOf2 ? -1 : 0;
    }

    public void calcNewHash(int type) {
        this.loadHash[type] = calcStickersHash(this.stickerSets[type]);
    }

    public void storeTempStickerSet(TLRPC$TL_messages_stickerSet set) {
        this.stickerSetsById.put(set.set.id, set);
        this.stickerSetsByName.put(set.set.short_name, set);
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
            String strReplace = tLRPC$TL_stickerPack.emoticon.replace("️", "");
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

    public void loadFeaturedStickers(boolean cache, boolean force) {
        if (this.loadingFeaturedStickers) {
            return;
        }
        this.loadingFeaturedStickers = true;
        if (cache) {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$kSQFOoaHv097ywsjZpnZ9gvQoBM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadFeaturedStickers$21$MediaDataController();
                }
            });
            return;
        }
        final TLRPC$TL_messages_getFeaturedStickers tLRPC$TL_messages_getFeaturedStickers = new TLRPC$TL_messages_getFeaturedStickers();
        tLRPC$TL_messages_getFeaturedStickers.hash = force ? 0L : this.loadFeaturedHash;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getFeaturedStickers, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Sx-cLA4jsFIAMz6iCNlKZzYbdBE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadFeaturedStickers$23$MediaDataController(tLRPC$TL_messages_getFeaturedStickers, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFeaturedStickers$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFeaturedStickers$21$MediaDataController() {
        ArrayList<TLRPC$StickerSetCovered> arrayList;
        Throwable th;
        SQLiteCursor sQLiteCursorQueryFinalized;
        long j;
        int i;
        ArrayList<TLRPC$StickerSetCovered> arrayList2;
        ArrayList<Long> arrayList3 = new ArrayList<>();
        ArrayList<TLRPC$StickerSetCovered> arrayList4 = null;
        int iIntValue = 0;
        long jCalcFeaturedStickersHash = 0;
        try {
            sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized("SELECT data, unread, date, hash FROM stickers_featured WHERE 1", new Object[0]);
            try {
                if (sQLiteCursorQueryFinalized.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue != null) {
                        arrayList = new ArrayList<>();
                        try {
                            int int32 = nativeByteBufferByteBufferValue.readInt32(false);
                            for (int i2 = 0; i2 < int32; i2++) {
                                arrayList.add(TLRPC$StickerSetCovered.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false));
                            }
                            nativeByteBufferByteBufferValue.reuse();
                            arrayList4 = arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                FileLog.e(th);
                                j = 0;
                                i = iIntValue;
                                arrayList2 = arrayList;
                                processLoadedFeaturedStickers(arrayList2, arrayList3, true, i, j);
                            } finally {
                                if (sQLiteCursorQueryFinalized != null) {
                                    sQLiteCursorQueryFinalized.dispose();
                                }
                            }
                        }
                    }
                    NativeByteBuffer nativeByteBufferByteBufferValue2 = sQLiteCursorQueryFinalized.byteBufferValue(1);
                    if (nativeByteBufferByteBufferValue2 != null) {
                        int int322 = nativeByteBufferByteBufferValue2.readInt32(false);
                        for (int i3 = 0; i3 < int322; i3++) {
                            arrayList3.add(Long.valueOf(nativeByteBufferByteBufferValue2.readInt64(false)));
                        }
                        nativeByteBufferByteBufferValue2.reuse();
                    }
                    iIntValue = sQLiteCursorQueryFinalized.intValue(2);
                    jCalcFeaturedStickersHash = calcFeaturedStickersHash(arrayList4);
                }
                sQLiteCursorQueryFinalized.dispose();
                j = jCalcFeaturedStickersHash;
                i = iIntValue;
                arrayList2 = arrayList4;
            } catch (Throwable th3) {
                arrayList = arrayList4;
                th = th3;
            }
        } catch (Throwable th4) {
            arrayList = null;
            th = th4;
            sQLiteCursorQueryFinalized = null;
        }
        processLoadedFeaturedStickers(arrayList2, arrayList3, true, i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFeaturedStickers$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFeaturedStickers$23$MediaDataController(final TLRPC$TL_messages_getFeaturedStickers tLRPC$TL_messages_getFeaturedStickers, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$S7Ra7F90ymASGhoXSw9Frtzm6TQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFeaturedStickers$22$MediaDataController(tLObject, tLRPC$TL_messages_getFeaturedStickers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFeaturedStickers$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFeaturedStickers$22$MediaDataController(TLObject tLObject, TLRPC$TL_messages_getFeaturedStickers tLRPC$TL_messages_getFeaturedStickers) {
        if (tLObject instanceof TLRPC$TL_messages_featuredStickers) {
            TLRPC$TL_messages_featuredStickers tLRPC$TL_messages_featuredStickers = (TLRPC$TL_messages_featuredStickers) tLObject;
            processLoadedFeaturedStickers(tLRPC$TL_messages_featuredStickers.sets, tLRPC$TL_messages_featuredStickers.unread, false, (int) (System.currentTimeMillis() / 1000), tLRPC$TL_messages_featuredStickers.hash);
        } else {
            processLoadedFeaturedStickers(null, null, false, (int) (System.currentTimeMillis() / 1000), tLRPC$TL_messages_getFeaturedStickers.hash);
        }
    }

    private void processLoadedFeaturedStickers(final ArrayList<TLRPC$StickerSetCovered> res, final ArrayList<Long> unreadStickers, final boolean cache, final int date, final long hash) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$zTRNxnQrvP5jmuaMLmqNnEYaFEw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedFeaturedStickers$24$MediaDataController();
            }
        });
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$I670-MA4j7wEdkNcXo-Ifjd41VA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedFeaturedStickers$28$MediaDataController(cache, res, date, hash, unreadStickers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedFeaturedStickers$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$24$MediaDataController() {
        this.loadingFeaturedStickers = false;
        this.featuredStickersLoaded = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedFeaturedStickers$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$28$MediaDataController(boolean z, final ArrayList arrayList, final int i, final long j, final ArrayList arrayList2) {
        long j2 = 0;
        if ((z && (arrayList == null || Math.abs((System.currentTimeMillis() / 1000) - i) >= 3600)) || (!z && arrayList == null && j == 0)) {
            Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Zbb0phmaOVnCcMNX4VM8LDH8myU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedFeaturedStickers$25$MediaDataController(arrayList, j);
                }
            };
            if (arrayList == null && !z) {
                j2 = 1000;
            }
            AndroidUtilities.runOnUIThread(runnable, j2);
            if (arrayList == null) {
                return;
            }
        }
        if (arrayList != null) {
            try {
                final ArrayList<TLRPC$StickerSetCovered> arrayList3 = new ArrayList<>();
                final LongSparseArray longSparseArray = new LongSparseArray();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) arrayList.get(i2);
                    arrayList3.add(tLRPC$StickerSetCovered);
                    longSparseArray.put(tLRPC$StickerSetCovered.set.id, tLRPC$StickerSetCovered);
                }
                if (!z) {
                    putFeaturedStickersToCache(arrayList3, arrayList2, i, j);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$-1eU8o5bxefxB_xLKAK8_nibefQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processLoadedFeaturedStickers$26$MediaDataController(arrayList2, longSparseArray, arrayList3, j, i);
                    }
                });
                return;
            } catch (Throwable th) {
                FileLog.e(th);
                return;
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$uWsJhmqLd5p79N5o5ydAXrI6PxA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedFeaturedStickers$27$MediaDataController(i);
            }
        });
        putFeaturedStickersToCache(null, null, i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedFeaturedStickers$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$25$MediaDataController(ArrayList arrayList, long j) {
        if (arrayList != null && j != 0) {
            this.loadFeaturedHash = j;
        }
        loadFeaturedStickers(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedFeaturedStickers$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$26$MediaDataController(ArrayList arrayList, LongSparseArray longSparseArray, ArrayList arrayList2, long j, int i) {
        this.unreadStickerSets = arrayList;
        this.featuredStickerSetsById = longSparseArray;
        this.featuredStickerSets = arrayList2;
        this.loadFeaturedHash = j;
        this.loadFeaturedDate = i;
        loadStickers(3, true, false);
        getNotificationCenter().postNotificationName(NotificationCenter.featuredStickersDidLoad, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedFeaturedStickers$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedFeaturedStickers$27$MediaDataController(int i) {
        this.loadFeaturedDate = i;
    }

    private void putFeaturedStickersToCache(ArrayList<TLRPC$StickerSetCovered> stickers, final ArrayList<Long> unreadStickers, final int date, final long hash) {
        final ArrayList arrayList = stickers != null ? new ArrayList(stickers) : null;
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$C84d5Z_8AXlVWzpCl4lNoPY3LE0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putFeaturedStickersToCache$29$MediaDataController(arrayList, unreadStickers, date, hash);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putFeaturedStickersToCache$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putFeaturedStickersToCache$29$MediaDataController(ArrayList arrayList, ArrayList arrayList2, int i, long j) {
        try {
            if (arrayList != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO stickers_featured VALUES(?, ?, ?, ?, ?)");
                sQLitePreparedStatementExecuteFast.requery();
                int objectSize = 4;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    objectSize += ((TLRPC$StickerSetCovered) arrayList.get(i2)).getObjectSize();
                }
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(objectSize);
                NativeByteBuffer nativeByteBuffer2 = new NativeByteBuffer((arrayList2.size() * 8) + 4);
                nativeByteBuffer.writeInt32(arrayList.size());
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ((TLRPC$StickerSetCovered) arrayList.get(i3)).serializeToStream(nativeByteBuffer);
                }
                nativeByteBuffer2.writeInt32(arrayList2.size());
                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                    nativeByteBuffer2.writeInt64(((Long) arrayList2.get(i4)).longValue());
                }
                sQLitePreparedStatementExecuteFast.bindInteger(1, 1);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer2);
                sQLitePreparedStatementExecuteFast.bindInteger(4, i);
                sQLitePreparedStatementExecuteFast.bindLong(5, j);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
                nativeByteBuffer2.reuse();
                sQLitePreparedStatementExecuteFast.dispose();
                return;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = getMessagesStorage().getDatabase().executeFast("UPDATE stickers_featured SET date = ?");
            sQLitePreparedStatementExecuteFast2.requery();
            sQLitePreparedStatementExecuteFast2.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast2.step();
            sQLitePreparedStatementExecuteFast2.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private long calcFeaturedStickersHash(ArrayList<TLRPC$StickerSetCovered> sets) {
        long jCalcHash = 0;
        if (sets != null && !sets.isEmpty()) {
            for (int i = 0; i < sets.size(); i++) {
                TLRPC$StickerSet tLRPC$StickerSet = sets.get(i).set;
                if (!tLRPC$StickerSet.archived) {
                    jCalcHash = calcHash(jCalcHash, tLRPC$StickerSet.id);
                    if (this.unreadStickerSets.contains(Long.valueOf(tLRPC$StickerSet.id))) {
                        jCalcHash = calcHash(jCalcHash, 1L);
                    }
                }
            }
        }
        return jCalcHash;
    }

    public void markFaturedStickersAsRead(boolean query) {
        if (this.unreadStickerSets.isEmpty()) {
            return;
        }
        this.unreadStickerSets.clear();
        this.loadFeaturedHash = calcFeaturedStickersHash(this.featuredStickerSets);
        getNotificationCenter().postNotificationName(NotificationCenter.featuredStickersDidLoad, new Object[0]);
        putFeaturedStickersToCache(this.featuredStickerSets, this.unreadStickerSets, this.loadFeaturedDate, this.loadFeaturedHash);
        if (query) {
            getConnectionsManager().sendRequest(new TLRPC$TL_messages_readFeaturedStickers(), new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$8gvbJW4EBveghNJgZWLxvc_-BI4
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    MediaDataController.lambda$markFaturedStickersAsRead$30(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    public long getFeaturesStickersHashWithoutUnread() {
        long jCalcHash = 0;
        for (int i = 0; i < this.featuredStickerSets.size(); i++) {
            TLRPC$StickerSet tLRPC$StickerSet = this.featuredStickerSets.get(i).set;
            if (!tLRPC$StickerSet.archived) {
                jCalcHash = calcHash(jCalcHash, tLRPC$StickerSet.id);
            }
        }
        return jCalcHash;
    }

    public void markFaturedStickersByIdAsRead(final long id) {
        if (!this.unreadStickerSets.contains(Long.valueOf(id)) || this.readingStickerSets.contains(Long.valueOf(id))) {
            return;
        }
        this.readingStickerSets.add(Long.valueOf(id));
        TLRPC$TL_messages_readFeaturedStickers tLRPC$TL_messages_readFeaturedStickers = new TLRPC$TL_messages_readFeaturedStickers();
        tLRPC$TL_messages_readFeaturedStickers.id.add(Long.valueOf(id));
        getConnectionsManager().sendRequest(tLRPC$TL_messages_readFeaturedStickers, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$aetP53-9lHvbtAkFL5eJY7O8cbA
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MediaDataController.lambda$markFaturedStickersByIdAsRead$31(tLObject, tLRPC$TL_error);
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$zuouvdubnOHllLQiNwQkkY7gZKI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markFaturedStickersByIdAsRead$32$MediaDataController(id);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markFaturedStickersByIdAsRead$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markFaturedStickersByIdAsRead$32$MediaDataController(long j) {
        this.unreadStickerSets.remove(Long.valueOf(j));
        this.readingStickerSets.remove(Long.valueOf(j));
        this.loadFeaturedHash = calcFeaturedStickersHash(this.featuredStickerSets);
        getNotificationCenter().postNotificationName(NotificationCenter.featuredStickersDidLoad, new Object[0]);
        putFeaturedStickersToCache(this.featuredStickerSets, this.unreadStickerSets, this.loadFeaturedDate, this.loadFeaturedHash);
    }

    public int getArchivedStickersCount(int type) {
        return this.archivedStickersCount[type];
    }

    public void verifyAnimatedStickerMessage(TLRPC$Message message) {
        verifyAnimatedStickerMessage(message, false);
    }

    public void verifyAnimatedStickerMessage(final TLRPC$Message message, boolean safe) {
        if (message == null) {
            return;
        }
        TLRPC$Document document = MessageObject.getDocument(message);
        final String stickerSetName = MessageObject.getStickerSetName(document);
        if (TextUtils.isEmpty(stickerSetName)) {
            return;
        }
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) this.stickerSetsByName.get(stickerSetName);
        if (tLRPC$TL_messages_stickerSet == null) {
            if (safe) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$b0pYX3gJuqSqOXxgPuLBEZvWJ54
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$verifyAnimatedStickerMessage$33$MediaDataController(message, stickerSetName);
                    }
                });
                return;
            } else {
                lambda$verifyAnimatedStickerMessage$33(message, stickerSetName);
                return;
            }
        }
        int size = tLRPC$TL_messages_stickerSet.documents.size();
        for (int i = 0; i < size; i++) {
            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i);
            if (tLRPC$Document.id == document.id && tLRPC$Document.dc_id == document.dc_id) {
                message.stickerVerified = 1;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verifyAnimatedStickerMessageInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$verifyAnimatedStickerMessage$33$MediaDataController(TLRPC$Message message, final String name) {
        ArrayList<TLRPC$Message> arrayList = this.verifyingMessages.get(name);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.verifyingMessages.put(name, arrayList);
        }
        arrayList.add(message);
        TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
        tLRPC$TL_messages_getStickerSet.stickerset = MessageObject.getInputStickerSet(message);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$oww7dqacYXJ0YBTklKX-Y-PoBQo
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$verifyAnimatedStickerMessageInternal$35$MediaDataController(name, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$verifyAnimatedStickerMessageInternal$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$verifyAnimatedStickerMessageInternal$35$MediaDataController(final String str, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$RlXeFpcVUS8a9kJ9emGbC4i8UsA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$verifyAnimatedStickerMessageInternal$34$MediaDataController(str, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$verifyAnimatedStickerMessageInternal$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$verifyAnimatedStickerMessageInternal$34$MediaDataController(String str, TLObject tLObject) {
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

    public void loadArchivedStickersCount(final int type, boolean cache) {
        if (cache) {
            int i = MessagesController.getNotificationsSettings(this.currentAccount).getInt("archivedStickersCount" + type, -1);
            if (i == -1) {
                loadArchivedStickersCount(type, false);
                return;
            } else {
                this.archivedStickersCount[type] = i;
                getNotificationCenter().postNotificationName(NotificationCenter.archivedStickersCountDidLoad, Integer.valueOf(type));
                return;
            }
        }
        TLRPC$TL_messages_getArchivedStickers tLRPC$TL_messages_getArchivedStickers = new TLRPC$TL_messages_getArchivedStickers();
        tLRPC$TL_messages_getArchivedStickers.limit = 0;
        tLRPC$TL_messages_getArchivedStickers.masks = type == 1;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getArchivedStickers, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$_f8GRjZKVLnzdQbXGFbewyYRiNQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadArchivedStickersCount$37$MediaDataController(type, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadArchivedStickersCount$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadArchivedStickersCount$37$MediaDataController(final int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$zZqio60ZN90pBeWwC0ig8I6AZig
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadArchivedStickersCount$36$MediaDataController(tLRPC$TL_error, tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadArchivedStickersCount$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadArchivedStickersCount$36$MediaDataController(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_archivedStickers tLRPC$TL_messages_archivedStickers = (TLRPC$TL_messages_archivedStickers) tLObject;
            this.archivedStickersCount[i] = tLRPC$TL_messages_archivedStickers.count;
            MessagesController.getNotificationsSettings(this.currentAccount).edit().putInt("archivedStickersCount" + i, tLRPC$TL_messages_archivedStickers.count).commit();
            getNotificationCenter().postNotificationName(NotificationCenter.archivedStickersCountDidLoad, Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void processLoadStickersResponse(final int r17, final ir.eitaa.tgnet.TLRPC$TL_messages_allStickers r18) {
        /*
            r16 = this;
            r8 = r18
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$StickerSet> r0 = r8.sets
            boolean r0 = r0.isEmpty()
            r10 = 1000(0x3e8, double:4.94E-321)
            if (r0 == 0) goto L26
            r3 = 0
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 / r10
            int r4 = (int) r0
            long r5 = r8.hash
            r0 = r16
            r1 = r17
            r2 = r9
            r0.processLoadedStickers(r1, r2, r3, r4, r5)
        L22:
            r14 = r16
            goto Lbc
        L26:
            androidx.collection.LongSparseArray r12 = new androidx.collection.LongSparseArray
            r12.<init>()
            r0 = 0
            r13 = 0
        L2d:
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$StickerSet> r0 = r8.sets
            int r0 = r0.size()
            if (r13 >= r0) goto L22
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$StickerSet> r0 = r8.sets
            java.lang.Object r0 = r0.get(r13)
            r5 = r0
            ir.eitaa.tgnet.TLRPC$StickerSet r5 = (ir.eitaa.tgnet.TLRPC$StickerSet) r5
            r14 = r16
            androidx.collection.LongSparseArray<ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet> r0 = r14.stickerSetsById
            long r1 = r5.id
            java.lang.Object r0 = r0.get(r1)
            ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet r0 = (ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet) r0
            if (r0 == 0) goto L86
            ir.eitaa.tgnet.TLRPC$StickerSet r1 = r0.set
            int r2 = r1.hash
            int r3 = r5.hash
            if (r2 != r3) goto L86
            boolean r2 = r5.archived
            r1.archived = r2
            boolean r2 = r5.installed
            r1.installed = r2
            boolean r2 = r5.official
            r1.official = r2
            long r1 = r1.id
            r12.put(r1, r0)
            r9.add(r0)
            int r0 = r12.size()
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$StickerSet> r1 = r8.sets
            int r1 = r1.size()
            if (r0 != r1) goto Lb6
            r3 = 0
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 / r10
            int r4 = (int) r0
            long r5 = r8.hash
            r0 = r16
            r1 = r17
            r2 = r9
            r0.processLoadedStickers(r1, r2, r3, r4, r5)
            goto Lb6
        L86:
            r0 = 0
            r9.add(r0)
            ir.eitaa.tgnet.TLRPC$TL_messages_getStickerSet r15 = new ir.eitaa.tgnet.TLRPC$TL_messages_getStickerSet
            r15.<init>()
            ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID r0 = new ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID
            r0.<init>()
            r15.stickerset = r0
            long r1 = r5.id
            r0.id = r1
            long r1 = r5.access_hash
            r0.access_hash = r1
            ir.eitaa.tgnet.ConnectionsManager r7 = r16.getConnectionsManager()
            ir.eitaa.messenger.-$$Lambda$MediaDataController$Ru7OmjRzZg_evR4hCoqG0C8l6ws r6 = new ir.eitaa.messenger.-$$Lambda$MediaDataController$Ru7OmjRzZg_evR4hCoqG0C8l6ws
            r0 = r6
            r1 = r16
            r2 = r9
            r3 = r13
            r4 = r12
            r10 = r6
            r6 = r18
            r11 = r7
            r7 = r17
            r0.<init>()
            r11.sendRequest(r15, r10)
        Lb6:
            int r13 = r13 + 1
            r10 = 1000(0x3e8, double:4.94E-321)
            goto L2d
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.processLoadStickersResponse(int, ir.eitaa.tgnet.TLRPC$TL_messages_allStickers):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadStickersResponse$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadStickersResponse$39$MediaDataController(final ArrayList arrayList, final int i, final LongSparseArray longSparseArray, final TLRPC$StickerSet tLRPC$StickerSet, final TLRPC$TL_messages_allStickers tLRPC$TL_messages_allStickers, final int i2, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$-eeifEzB_ZD6hVtTl4l8eF9NKUo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadStickersResponse$38$MediaDataController(tLObject, arrayList, i, longSparseArray, tLRPC$StickerSet, tLRPC$TL_messages_allStickers, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadStickersResponse$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadStickersResponse$38$MediaDataController(TLObject tLObject, ArrayList arrayList, int i, LongSparseArray longSparseArray, TLRPC$StickerSet tLRPC$StickerSet, TLRPC$TL_messages_allStickers tLRPC$TL_messages_allStickers, int i2) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) tLObject;
        arrayList.set(i, tLRPC$TL_messages_stickerSet);
        longSparseArray.put(tLRPC$StickerSet.id, tLRPC$TL_messages_stickerSet);
        if (longSparseArray.size() == tLRPC$TL_messages_allStickers.sets.size()) {
            int i3 = 0;
            while (i3 < arrayList.size()) {
                if (arrayList.get(i3) == null) {
                    arrayList.remove(i3);
                    i3--;
                }
                i3++;
            }
            processLoadedStickers(i2, arrayList, false, (int) (System.currentTimeMillis() / 1000), tLRPC$TL_messages_allStickers.hash);
        }
    }

    public void loadStickersByEmojiOrName(final String name, final boolean isEmoji, boolean cache) {
        if (this.loadingDiceStickerSets.contains(name)) {
            return;
        }
        if (!isEmoji || this.diceStickerSetsByEmoji.get(name) == null) {
            this.loadingDiceStickerSets.add(name);
            if (cache) {
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$gFlHvJbBllZEYksfd7xbyrC9bRc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadStickersByEmojiOrName$40$MediaDataController(name, isEmoji);
                    }
                });
                return;
            }
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
            if (isEmoji) {
                TLRPC$TL_inputStickerSetDice tLRPC$TL_inputStickerSetDice = new TLRPC$TL_inputStickerSetDice();
                tLRPC$TL_inputStickerSetDice.emoticon = name;
                tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetDice;
            } else {
                TLRPC$TL_inputStickerSetShortName tLRPC$TL_inputStickerSetShortName = new TLRPC$TL_inputStickerSetShortName();
                tLRPC$TL_inputStickerSetShortName.short_name = name;
                tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetShortName;
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$jz2z6TiCRMOpwGRI2roGKC-OHbs
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadStickersByEmojiOrName$42$MediaDataController(name, isEmoji, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickersByEmojiOrName$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickersByEmojiOrName$40$MediaDataController(String str, boolean z) {
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
    /* renamed from: lambda$loadStickersByEmojiOrName$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickersByEmojiOrName$42$MediaDataController(final String str, final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$B7_swSRbQ1hQsq8EXnlU0YfOgb0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStickersByEmojiOrName$41$MediaDataController(tLRPC$TL_error, tLObject, str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickersByEmojiOrName$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickersByEmojiOrName$41$MediaDataController(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str, boolean z) {
        if (tLObject instanceof TLRPC$TL_messages_stickerSet) {
            processLoadedDiceStickers(str, z, (TLRPC$TL_messages_stickerSet) tLObject, false, (int) (System.currentTimeMillis() / 1000));
        } else {
            processLoadedDiceStickers(str, z, null, false, (int) (System.currentTimeMillis() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedDiceStickers$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDiceStickers$43$MediaDataController(String str) {
        this.loadingDiceStickerSets.remove(str);
    }

    private void processLoadedDiceStickers(final String name, final boolean isEmoji, final TLRPC$TL_messages_stickerSet res, final boolean cache, final int date) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$m8slIsEM3gZrh2i3DTh0Xo8rSzg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDiceStickers$43$MediaDataController(name);
            }
        });
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Os-cGhqWl29-zvDkDnlXckzuVR4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedDiceStickers$46$MediaDataController(cache, res, date, name, isEmoji);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedDiceStickers$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDiceStickers$46$MediaDataController(boolean z, final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, int i, final String str, final boolean z2) {
        if ((z && (tLRPC$TL_messages_stickerSet == null || Math.abs((System.currentTimeMillis() / 1000) - i) >= 86400)) || (!z && tLRPC$TL_messages_stickerSet == null)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$DXu-K95MWqjfJWikg_l0Avi5QjY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedDiceStickers$44$MediaDataController(str, z2);
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$VDx95b6CZ59stYIQX9VWd_qBOv8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedDiceStickers$45$MediaDataController(str, tLRPC$TL_messages_stickerSet);
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
    /* renamed from: lambda$processLoadedDiceStickers$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDiceStickers$44$MediaDataController(String str, boolean z) {
        loadStickersByEmojiOrName(str, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedDiceStickers$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedDiceStickers$45$MediaDataController(String str, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        this.diceStickerSetsByEmoji.put(str, tLRPC$TL_messages_stickerSet);
        this.diceEmojiStickerSetsById.put(tLRPC$TL_messages_stickerSet.set.id, str);
        getNotificationCenter().postNotificationName(NotificationCenter.diceStickersDidLoad, str);
    }

    private void putDiceStickersToCache(final String emoji, final TLRPC$TL_messages_stickerSet stickers, final int date) {
        if (TextUtils.isEmpty(emoji)) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$7CTkK2YCETj6P_JKRdj8BRec3Ok
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putDiceStickersToCache$47$MediaDataController(stickers, emoji, date);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putDiceStickersToCache$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putDiceStickersToCache$47$MediaDataController(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, String str, int i) {
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

    public void loadStickers(int type, boolean cache, boolean useHash) {
        loadStickers(type, cache, useHash, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadStickers(final int i, boolean z, final boolean z2, boolean z3) {
        final long j;
        TLRPC$TL_messages_getMaskStickers tLRPC$TL_messages_getMaskStickers;
        if (this.loadingStickers[i]) {
            if (z3) {
                this.scheduledLoadStickers[i] = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$YNOu1E2wjzPT_PPdySA1-7NTsvI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadStickers$48$MediaDataController(i, z2);
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
        this.loadingStickers[i] = true;
        if (z) {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$b3xjdkn_Z3xoQluUwmEBY8nI22Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadStickers$49$MediaDataController(i);
                }
            });
            return;
        }
        if (i == 3) {
            TLRPC$TL_messages_allStickers tLRPC$TL_messages_allStickers = new TLRPC$TL_messages_allStickers();
            tLRPC$TL_messages_allStickers.hash = this.loadFeaturedHash;
            int size = this.featuredStickerSets.size();
            for (int i2 = 0; i2 < size; i2++) {
                tLRPC$TL_messages_allStickers.sets.add(this.featuredStickerSets.get(i2).set);
            }
            processLoadStickersResponse(i, tLRPC$TL_messages_allStickers);
            return;
        }
        if (i == 4) {
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
            tLRPC$TL_messages_getStickerSet.stickerset = new TLRPC$TL_inputStickerSetAnimatedEmoji();
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Tu3YSizCNMOWhNWR3sH2fSZcr30
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadStickers$50$MediaDataController(i, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (i == 0) {
            TLRPC$TL_messages_getAllStickers tLRPC$TL_messages_getAllStickers = new TLRPC$TL_messages_getAllStickers();
            j = z2 ? 0L : this.loadHash[i];
            tLRPC$TL_messages_getAllStickers.hash = j;
            tLRPC$TL_messages_getMaskStickers = tLRPC$TL_messages_getAllStickers;
        } else {
            TLRPC$TL_messages_getMaskStickers tLRPC$TL_messages_getMaskStickers2 = new TLRPC$TL_messages_getMaskStickers();
            j = z2 ? 0L : this.loadHash[i];
            tLRPC$TL_messages_getMaskStickers2.hash = j;
            tLRPC$TL_messages_getMaskStickers = tLRPC$TL_messages_getMaskStickers2;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getMaskStickers, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$5SnXSSIVFgvpJNzkYYPlXwFwT4E
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadStickers$52$MediaDataController(i, j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickers$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickers$48$MediaDataController(int i, boolean z) {
        loadStickers(i, false, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickers$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickers$49$MediaDataController(int i) {
        ArrayList<TLRPC$TL_messages_stickerSet> arrayList;
        Throwable th;
        SQLiteCursor sQLiteCursorQueryFinalized;
        long j;
        int i2;
        ArrayList<TLRPC$TL_messages_stickerSet> arrayList2;
        ArrayList<TLRPC$TL_messages_stickerSet> arrayList3 = null;
        int iIntValue = 0;
        long jCalcStickersHash = 0;
        try {
            sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized("SELECT data, date, hash FROM stickers_v2 WHERE id = " + (i + 1), new Object[0]);
            try {
                if (sQLiteCursorQueryFinalized.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue != null) {
                        arrayList = new ArrayList<>();
                        try {
                            int int32 = nativeByteBufferByteBufferValue.readInt32(false);
                            for (int i3 = 0; i3 < int32; i3++) {
                                arrayList.add(TLRPC$TL_messages_stickerSet.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false));
                            }
                            nativeByteBufferByteBufferValue.reuse();
                            arrayList3 = arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                FileLog.e(th);
                                i2 = iIntValue;
                                j = 0;
                                arrayList2 = arrayList;
                                processLoadedStickers(i, arrayList2, true, i2, j);
                            } finally {
                                if (sQLiteCursorQueryFinalized != null) {
                                    sQLiteCursorQueryFinalized.dispose();
                                }
                            }
                        }
                    }
                    iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                    jCalcStickersHash = calcStickersHash(arrayList3);
                }
                sQLiteCursorQueryFinalized.dispose();
                arrayList2 = arrayList3;
                i2 = iIntValue;
                j = jCalcStickersHash;
            } catch (Throwable th3) {
                arrayList = arrayList3;
                th = th3;
            }
        } catch (Throwable th4) {
            arrayList = null;
            th = th4;
            sQLiteCursorQueryFinalized = null;
        }
        processLoadedStickers(i, arrayList2, true, i2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickers$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickers$50$MediaDataController(int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_messages_stickerSet) {
            ArrayList<TLRPC$TL_messages_stickerSet> arrayList = new ArrayList<>();
            arrayList.add((TLRPC$TL_messages_stickerSet) tLObject);
            processLoadedStickers(i, arrayList, false, (int) (System.currentTimeMillis() / 1000), calcStickersHash(arrayList));
            return;
        }
        processLoadedStickers(i, null, false, (int) (System.currentTimeMillis() / 1000), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickers$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickers$52$MediaDataController(final int i, final long j, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$YmCbRalgMS22pm0DrLNxwEhpEu8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStickers$51$MediaDataController(tLObject, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickers$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickers$51$MediaDataController(TLObject tLObject, int i, long j) {
        if (tLObject instanceof TLRPC$TL_messages_allStickers) {
            processLoadStickersResponse(i, (TLRPC$TL_messages_allStickers) tLObject);
        } else {
            processLoadedStickers(i, null, false, (int) (System.currentTimeMillis() / 1000), j);
        }
    }

    private void putStickersToCache(final int type, ArrayList<TLRPC$TL_messages_stickerSet> stickers, final int date, final long hash) {
        final ArrayList arrayList = stickers != null ? new ArrayList(stickers) : null;
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$c5Fp_BAlCrysW3iOV_CWZkWBX6Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putStickersToCache$53$MediaDataController(arrayList, type, date, hash);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putStickersToCache$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putStickersToCache$53$MediaDataController(ArrayList arrayList, int i, int i2, long j) {
        try {
            if (arrayList != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO stickers_v2 VALUES(?, ?, ?, ?)");
                sQLitePreparedStatementExecuteFast.requery();
                int objectSize = 4;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    objectSize += ((TLRPC$TL_messages_stickerSet) arrayList.get(i3)).getObjectSize();
                }
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(objectSize);
                nativeByteBuffer.writeInt32(arrayList.size());
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    ((TLRPC$TL_messages_stickerSet) arrayList.get(i4)).serializeToStream(nativeByteBuffer);
                }
                sQLitePreparedStatementExecuteFast.bindInteger(1, i + 1);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(3, i2);
                sQLitePreparedStatementExecuteFast.bindLong(4, j);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
                sQLitePreparedStatementExecuteFast.dispose();
                return;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = getMessagesStorage().getDatabase().executeFast("UPDATE stickers_v2 SET date = ?");
            sQLitePreparedStatementExecuteFast2.requery();
            sQLitePreparedStatementExecuteFast2.bindLong(1, i2);
            sQLitePreparedStatementExecuteFast2.step();
            sQLitePreparedStatementExecuteFast2.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public String getStickerSetName(long setId) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSetsById.get(setId);
        if (tLRPC$TL_messages_stickerSet != null) {
            return tLRPC$TL_messages_stickerSet.set.short_name;
        }
        TLRPC$StickerSetCovered tLRPC$StickerSetCovered = this.featuredStickerSetsById.get(setId);
        if (tLRPC$StickerSetCovered != null) {
            return tLRPC$StickerSetCovered.set.short_name;
        }
        return null;
    }

    public static long getStickerSetId(TLRPC$Document document) {
        for (int i = 0; i < document.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
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

    public static TLRPC$InputStickerSet getInputStickerSet(TLRPC$Document document) {
        for (int i = 0; i < document.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
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

    private static long calcStickersHash(ArrayList<TLRPC$TL_messages_stickerSet> sets) {
        long jCalcHash = 0;
        for (int i = 0; i < sets.size(); i++) {
            if (!sets.get(i).set.archived) {
                jCalcHash = calcHash(jCalcHash, r3.hash);
            }
        }
        return jCalcHash;
    }

    private void processLoadedStickers(final int type, final ArrayList<TLRPC$TL_messages_stickerSet> res, final boolean cache, final int date, final long hash) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$gOrl_nvqDPAnkn1loSek-ROoo7U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedStickers$54$MediaDataController(type);
            }
        });
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$p9TE1Ne-ggzjNmq7-uFQnHw91XI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedStickers$58$MediaDataController(cache, res, date, hash, type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedStickers$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedStickers$54$MediaDataController(int i) {
        this.loadingStickers[i] = false;
        this.stickersLoaded[i] = true;
        Runnable[] runnableArr = this.scheduledLoadStickers;
        if (runnableArr[i] != null) {
            runnableArr[i].run();
            this.scheduledLoadStickers[i] = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedStickers$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedStickers$58$MediaDataController(boolean z, final ArrayList arrayList, final int i, final long j, final int i2) {
        int i3;
        String str;
        int i4;
        MediaDataController mediaDataController = this;
        ArrayList arrayList2 = arrayList;
        long j2 = 0;
        if ((z && (arrayList2 == null || Math.abs((System.currentTimeMillis() / 1000) - i) >= 3600)) || (!z && arrayList2 == null && j == 0)) {
            Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$_wXt0oIFS3LLVVt6HGOKOHK3B6A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedStickers$55$MediaDataController(arrayList, j, i2);
                }
            };
            if (arrayList2 == null && !z) {
                j2 = 1000;
            }
            AndroidUtilities.runOnUIThread(runnable, j2);
            if (arrayList2 == null) {
                return;
            }
        }
        if (arrayList2 != null) {
            try {
                final ArrayList<TLRPC$TL_messages_stickerSet> arrayList3 = new ArrayList<>();
                final LongSparseArray longSparseArray = new LongSparseArray();
                final HashMap map = new HashMap();
                final LongSparseArray longSparseArray2 = new LongSparseArray();
                final LongSparseArray longSparseArray3 = new LongSparseArray();
                HashMap map2 = new HashMap();
                int i5 = 0;
                while (i5 < arrayList.size()) {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) arrayList2.get(i5);
                    if (tLRPC$TL_messages_stickerSet == null || mediaDataController.removingStickerSetsUndos.indexOfKey(tLRPC$TL_messages_stickerSet.set.id) >= 0) {
                        i3 = i5;
                    } else {
                        arrayList3.add(tLRPC$TL_messages_stickerSet);
                        longSparseArray.put(tLRPC$TL_messages_stickerSet.set.id, tLRPC$TL_messages_stickerSet);
                        map.put(tLRPC$TL_messages_stickerSet.set.short_name, tLRPC$TL_messages_stickerSet);
                        int i6 = 0;
                        while (i6 < tLRPC$TL_messages_stickerSet.documents.size()) {
                            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i6);
                            if (tLRPC$Document == null || (tLRPC$Document instanceof TLRPC$TL_documentEmpty)) {
                                i4 = i5;
                            } else {
                                i4 = i5;
                                longSparseArray3.put(tLRPC$Document.id, tLRPC$Document);
                            }
                            i6++;
                            i5 = i4;
                        }
                        i3 = i5;
                        if (!tLRPC$TL_messages_stickerSet.set.archived) {
                            int i7 = 0;
                            while (i7 < tLRPC$TL_messages_stickerSet.packs.size()) {
                                TLRPC$TL_stickerPack tLRPC$TL_stickerPack = tLRPC$TL_messages_stickerSet.packs.get(i7);
                                if (tLRPC$TL_stickerPack != null && (str = tLRPC$TL_stickerPack.emoticon) != null) {
                                    String strReplace = str.replace("️", "");
                                    tLRPC$TL_stickerPack.emoticon = strReplace;
                                    ArrayList arrayList4 = (ArrayList) map2.get(strReplace);
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                        map2.put(tLRPC$TL_stickerPack.emoticon, arrayList4);
                                    }
                                    int i8 = 0;
                                    while (i8 < tLRPC$TL_stickerPack.documents.size()) {
                                        Long l = tLRPC$TL_stickerPack.documents.get(i8);
                                        HashMap map3 = map2;
                                        if (longSparseArray2.indexOfKey(l.longValue()) < 0) {
                                            longSparseArray2.put(l.longValue(), tLRPC$TL_stickerPack.emoticon);
                                        }
                                        TLRPC$Document tLRPC$Document2 = (TLRPC$Document) longSparseArray3.get(l.longValue());
                                        if (tLRPC$Document2 != null) {
                                            arrayList4.add(tLRPC$Document2);
                                        }
                                        i8++;
                                        map2 = map3;
                                    }
                                }
                                i7++;
                                map2 = map2;
                            }
                        }
                    }
                    i5 = i3 + 1;
                    mediaDataController = this;
                    arrayList2 = arrayList;
                    map2 = map2;
                }
                final HashMap map4 = map2;
                if (!z) {
                    putStickersToCache(i2, arrayList3, i, j);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$cL7ddnAoZHahqRAR75Z7WIutfAA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processLoadedStickers$56$MediaDataController(i2, longSparseArray, map, arrayList3, j, i, longSparseArray3, map4, longSparseArray2);
                    }
                });
            } catch (Throwable th) {
                FileLog.e(th);
            }
        } else if (!z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$0z_oBPnrT8EOJfs9dL-Z9xDXvyk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedStickers$57$MediaDataController(i2, i);
                }
            });
            putStickersToCache(i2, null, i, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedStickers$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedStickers$55$MediaDataController(ArrayList arrayList, long j, int i) {
        if (arrayList != null && j != 0) {
            this.loadHash[i] = j;
        }
        loadStickers(i, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$processLoadedStickers$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedStickers$56$MediaDataController(int i, LongSparseArray longSparseArray, HashMap map, ArrayList arrayList, long j, int i2, LongSparseArray longSparseArray2, HashMap map2, LongSparseArray longSparseArray3) {
        for (int i3 = 0; i3 < this.stickerSets[i].size(); i3++) {
            TLRPC$StickerSet tLRPC$StickerSet = this.stickerSets[i].get(i3).set;
            this.stickerSetsById.remove(tLRPC$StickerSet.id);
            this.stickerSetsByName.remove(tLRPC$StickerSet.short_name);
            if (i != 3 && i != 4) {
                this.installedStickerSetsById.remove(tLRPC$StickerSet.id);
            }
        }
        for (int i4 = 0; i4 < longSparseArray.size(); i4++) {
            this.stickerSetsById.put(longSparseArray.keyAt(i4), (TLRPC$TL_messages_stickerSet) longSparseArray.valueAt(i4));
            if (i != 3 && i != 4) {
                this.installedStickerSetsById.put(longSparseArray.keyAt(i4), (TLRPC$TL_messages_stickerSet) longSparseArray.valueAt(i4));
            }
        }
        this.stickerSetsByName.putAll(map);
        this.stickerSets[i] = arrayList;
        this.loadHash[i] = j;
        this.loadDate[i] = i2;
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
    /* renamed from: lambda$processLoadedStickers$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedStickers$57$MediaDataController(int i, int i2) {
        this.loadDate[i] = i2;
    }

    public boolean cancelRemovingStickerSet(long id) {
        Runnable runnable = this.removingStickerSetsUndos.get(id);
        if (runnable == null) {
            return false;
        }
        runnable.run();
        return true;
    }

    public void preloadStickerSetThumb(TLRPC$TL_messages_stickerSet stickerSet) {
        ArrayList<TLRPC$Document> arrayList;
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(stickerSet.set.thumbs, 90);
        if (closestPhotoSizeWithSize == null || (arrayList = stickerSet.documents) == null || arrayList.isEmpty()) {
            return;
        }
        loadStickerSetThumbInternal(closestPhotoSizeWithSize, stickerSet, arrayList.get(0), stickerSet.set.thumb_version);
    }

    public void preloadStickerSetThumb(TLRPC$StickerSetCovered stickerSet) {
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(stickerSet.set.thumbs, 90);
        if (closestPhotoSizeWithSize != null) {
            TLRPC$Document tLRPC$Document = stickerSet.cover;
            if (tLRPC$Document == null) {
                if (stickerSet.covers.isEmpty()) {
                    return;
                } else {
                    tLRPC$Document = stickerSet.covers.get(0);
                }
            }
            loadStickerSetThumbInternal(closestPhotoSizeWithSize, stickerSet, tLRPC$Document, stickerSet.set.thumb_version);
        }
    }

    private void loadStickerSetThumbInternal(TLRPC$PhotoSize thumb, Object parentObject, TLRPC$Document sticker, int thumbVersion) {
        ImageLocation forSticker = ImageLocation.getForSticker(thumb, sticker, thumbVersion);
        if (forSticker != null) {
            getFileLoader().loadFile(forSticker, parentObject, forSticker.imageType == 1 ? "tgs" : "webp", 2, 1);
        }
    }

    public void toggleStickerSet(final Context context, final TLObject tLObject, final int i, final BaseFragment baseFragment, final boolean z, boolean z2) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet;
        TLRPC$StickerSet tLRPC$StickerSet;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2;
        int i2;
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
        final int i4 = i2;
        final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet5 = tLRPC$TL_messages_stickerSet2;
        final int i5 = z3 ? 1 : 0;
        Bulletin.UndoButton undoAction = undoButton.setUndoAction(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$za2cBm4B9_L96ko0fdXm3JrzVtE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSet$59$MediaDataController(tLRPC$StickerSet3, i5, i4, tLRPC$TL_messages_stickerSet5);
            }
        });
        final TLRPC$StickerSet tLRPC$StickerSet4 = tLRPC$StickerSet;
        final int i6 = z3 ? 1 : 0;
        final Bulletin.UndoButton delayedAction = undoAction.setDelayedAction(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$LojlCXNFRRgb151dX45b8MLXGxg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSet$60$MediaDataController(context, i, baseFragment, z, tLObject, tLRPC$StickerSet4, i6);
            }
        });
        stickerSetBulletinLayout.setButton(delayedAction);
        LongSparseArray<Runnable> longSparseArray = this.removingStickerSetsUndos;
        long j = tLRPC$StickerSet.id;
        delayedAction.getClass();
        longSparseArray.put(j, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$0o2exMWG9Vlf17r2y0oq43sjzdw
            @Override // java.lang.Runnable
            public final void run() {
                delayedAction.undo();
            }
        });
        Bulletin.make(baseFragment, stickerSetBulletinLayout, 2750).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleStickerSet$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleStickerSet$59$MediaDataController(TLRPC$StickerSet tLRPC$StickerSet, int i, int i2, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
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
    /* renamed from: lambda$toggleStickerSet$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleStickerSet$60$MediaDataController(Context context, int i, BaseFragment baseFragment, boolean z, TLObject tLObject, TLRPC$StickerSet tLRPC$StickerSet, int i2) {
        toggleStickerSetInternal(context, i, baseFragment, z, tLObject, tLRPC$StickerSet, i2, false);
    }

    private void toggleStickerSetInternal(final Context context, int toggle, final BaseFragment baseFragment, final boolean showSettings, final TLObject stickerSetObject, final TLRPC$StickerSet stickerSet, final int type, final boolean showTooltip) {
        TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
        tLRPC$TL_inputStickerSetID.access_hash = stickerSet.access_hash;
        tLRPC$TL_inputStickerSetID.id = stickerSet.id;
        if (toggle != 0) {
            TLRPC$TL_messages_installStickerSet tLRPC$TL_messages_installStickerSet = new TLRPC$TL_messages_installStickerSet();
            tLRPC$TL_messages_installStickerSet.stickerset = tLRPC$TL_inputStickerSetID;
            tLRPC$TL_messages_installStickerSet.archived = toggle == 1;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_installStickerSet, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$LABAEifUpLZg5M9jRdSl42Bf558
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$toggleStickerSetInternal$62$MediaDataController(stickerSet, baseFragment, showSettings, type, showTooltip, context, stickerSetObject, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        TLRPC$TL_messages_uninstallStickerSet tLRPC$TL_messages_uninstallStickerSet = new TLRPC$TL_messages_uninstallStickerSet();
        tLRPC$TL_messages_uninstallStickerSet.stickerset = tLRPC$TL_inputStickerSetID;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_uninstallStickerSet, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$zhPlxTtYMWq4tyfxPNo1WQ-HJl4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toggleStickerSetInternal$64$MediaDataController(stickerSet, type, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleStickerSetInternal$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleStickerSetInternal$62$MediaDataController(final TLRPC$StickerSet tLRPC$StickerSet, final BaseFragment baseFragment, final boolean z, final int i, final boolean z2, final Context context, final TLObject tLObject, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$nQQlGJr4sR0-9h1wrO14R4CAsBo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSetInternal$61$MediaDataController(tLRPC$StickerSet, tLObject2, baseFragment, z, i, tLRPC$TL_error, z2, context, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleStickerSetInternal$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleStickerSetInternal$61$MediaDataController(TLRPC$StickerSet tLRPC$StickerSet, TLObject tLObject, BaseFragment baseFragment, boolean z, int i, TLRPC$TL_error tLRPC$TL_error, boolean z2, Context context, TLObject tLObject2) {
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
    /* renamed from: lambda$toggleStickerSetInternal$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleStickerSetInternal$64$MediaDataController(final TLRPC$StickerSet tLRPC$StickerSet, final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$eP3nx5ezXvkrfgHx8OOL5YOFdIU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSetInternal$63$MediaDataController(tLRPC$StickerSet, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleStickerSetInternal$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleStickerSetInternal$63$MediaDataController(TLRPC$StickerSet tLRPC$StickerSet, int i) {
        this.removingStickerSetsUndos.remove(tLRPC$StickerSet.id);
        loadStickers(i, false, true);
    }

    public void toggleStickerSets(ArrayList<TLRPC$StickerSet> stickerSetList, final int type, final int toggle, final BaseFragment baseFragment, final boolean showSettings) {
        int size = stickerSetList.size();
        ArrayList<TLRPC$InputStickerSet> arrayList = new ArrayList<>(size);
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            TLRPC$StickerSet tLRPC$StickerSet = stickerSetList.get(i);
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
            tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
            tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
            arrayList.add(tLRPC$TL_inputStickerSetID);
            if (toggle != 0) {
                tLRPC$StickerSet.archived = toggle == 1;
            }
            int size2 = this.stickerSets[type].size();
            int i2 = 0;
            while (true) {
                if (i2 < size2) {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSets[type].get(i2);
                    if (tLRPC$TL_messages_stickerSet.set.id == tLRPC$TL_inputStickerSetID.id) {
                        this.stickerSets[type].remove(i2);
                        if (toggle == 2) {
                            this.stickerSets[type].add(0, tLRPC$TL_messages_stickerSet);
                        } else {
                            this.stickerSetsById.remove(tLRPC$TL_messages_stickerSet.set.id);
                            this.installedStickerSetsById.remove(tLRPC$TL_messages_stickerSet.set.id);
                            this.stickerSetsByName.remove(tLRPC$TL_messages_stickerSet.set.short_name);
                        }
                    } else {
                        i2++;
                    }
                }
            }
            i++;
        }
        this.loadHash[type] = calcStickersHash(this.stickerSets[type]);
        putStickersToCache(type, this.stickerSets[type], this.loadDate[type], this.loadHash[type]);
        getNotificationCenter().postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(type));
        TLRPC$TL_messages_toggleStickerSets tLRPC$TL_messages_toggleStickerSets = new TLRPC$TL_messages_toggleStickerSets();
        tLRPC$TL_messages_toggleStickerSets.stickersets = arrayList;
        if (toggle == 0) {
            tLRPC$TL_messages_toggleStickerSets.uninstall = true;
        } else if (toggle == 1) {
            tLRPC$TL_messages_toggleStickerSets.archive = true;
        } else if (toggle == 2) {
            tLRPC$TL_messages_toggleStickerSets.unarchive = true;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_toggleStickerSets, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$GjhtpKtlsp9cnEDSWt5rHU7jV9o
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toggleStickerSets$66$MediaDataController(toggle, baseFragment, showSettings, type, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleStickerSets$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleStickerSets$66$MediaDataController(final int i, final BaseFragment baseFragment, final boolean z, final int i2, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$L0f8lmlouxGPlpw9rYZCwZuB3nU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSets$65$MediaDataController(i, tLObject, baseFragment, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleStickerSets$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleStickerSets$65$MediaDataController(int i, TLObject tLObject, BaseFragment baseFragment, boolean z, int i2) {
        if (i != 0) {
            if (tLObject instanceof TLRPC$TL_messages_stickerSetInstallResultArchive) {
                processStickerSetInstallResultArchive(baseFragment, z, i2, (TLRPC$TL_messages_stickerSetInstallResultArchive) tLObject);
            }
            loadStickers(i2, false, false, true);
            return;
        }
        loadStickers(i2, false, true);
    }

    public void processStickerSetInstallResultArchive(BaseFragment baseFragment, boolean showSettings, int type, TLRPC$TL_messages_stickerSetInstallResultArchive response) {
        int size = response.sets.size();
        for (int i = 0; i < size; i++) {
            this.installedStickerSetsById.remove(response.sets.get(i).set.id);
        }
        loadArchivedStickersCount(type, false);
        getNotificationCenter().postNotificationName(NotificationCenter.needAddArchivedStickers, response.sets);
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        baseFragment.showDialog(new StickersArchiveAlert(baseFragment.getParentActivity(), showSettings ? baseFragment : null, response.sets).create());
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

    public boolean isMessageFound(int i, boolean z) {
        return this.searchResultMessagesMap[z ? 1 : 0].indexOfKey(i) >= 0;
    }

    public void searchMessagesInChat(String query, long dialogId, long mergeDialogId, int guid, int direction, int replyMessageId, TLRPC$User user, TLRPC$Chat chat) {
        searchMessagesInChat(query, dialogId, mergeDialogId, guid, direction, replyMessageId, false, user, chat, true);
    }

    public void jumpToSearchedMessage(int guid, int index) {
        if (index < 0 || index >= this.searchResultMessages.size()) {
            return;
        }
        this.lastReturnedNum = index;
        MessageObject messageObject = this.searchResultMessages.get(index);
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.chatSearchResultsAvailable;
        int[] iArr = this.messagesSearchCount;
        notificationCenter.postNotificationName(i, Integer.valueOf(guid), Integer.valueOf(messageObject.getId()), Integer.valueOf(getMask()), Long.valueOf(messageObject.getDialogId()), Integer.valueOf(this.lastReturnedNum), Integer.valueOf(iArr[0] + iArr[1]), Boolean.TRUE);
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

    private void searchMessagesInChat(String query, final long dialogId, final long mergeDialogId, final int guid, final int direction, final int replyMessageId, boolean internal, final TLRPC$User user, final TLRPC$Chat chat, final boolean jumpToMessage) {
        String str;
        long j;
        int i;
        long j2;
        String str2;
        int id;
        long j3;
        boolean z = !internal;
        if (this.reqId != 0) {
            getConnectionsManager().cancelRequest(this.reqId, true);
            this.reqId = 0;
        }
        if (this.mergeReqId != 0) {
            getConnectionsManager().cancelRequest(this.mergeReqId, true);
            this.mergeReqId = 0;
        }
        if (query != null) {
            if (z) {
                boolean[] zArr = this.messagesSearchEndReached;
                zArr[1] = false;
                zArr[0] = false;
                int[] iArr = this.messagesSearchCount;
                iArr[1] = 0;
                iArr[0] = 0;
                this.searchResultMessages.clear();
                this.searchResultMessagesMap[0].clear();
                this.searchResultMessagesMap[1].clear();
                getNotificationCenter().postNotificationName(NotificationCenter.chatSearchResultsLoading, Integer.valueOf(guid));
            }
            str = query;
            j = dialogId;
            i = 0;
        } else {
            if (this.searchResultMessages.isEmpty()) {
                return;
            }
            if (direction != 1) {
                if (direction == 2) {
                    int i2 = this.lastReturnedNum - 1;
                    this.lastReturnedNum = i2;
                    if (i2 < 0) {
                        this.lastReturnedNum = 0;
                        return;
                    }
                    if (i2 >= this.searchResultMessages.size()) {
                        this.lastReturnedNum = this.searchResultMessages.size() - 1;
                    }
                    MessageObject messageObject = this.searchResultMessages.get(this.lastReturnedNum);
                    NotificationCenter notificationCenter = getNotificationCenter();
                    int i3 = NotificationCenter.chatSearchResultsAvailable;
                    int[] iArr2 = this.messagesSearchCount;
                    notificationCenter.postNotificationName(i3, Integer.valueOf(guid), Integer.valueOf(messageObject.getId()), Integer.valueOf(getMask()), Long.valueOf(messageObject.getDialogId()), Integer.valueOf(this.lastReturnedNum), Integer.valueOf(iArr2[0] + iArr2[1]), Boolean.valueOf(jumpToMessage));
                    return;
                }
                return;
            }
            int i4 = this.lastReturnedNum + 1;
            this.lastReturnedNum = i4;
            if (i4 < this.searchResultMessages.size()) {
                MessageObject messageObject2 = this.searchResultMessages.get(this.lastReturnedNum);
                NotificationCenter notificationCenter2 = getNotificationCenter();
                int i5 = NotificationCenter.chatSearchResultsAvailable;
                int[] iArr3 = this.messagesSearchCount;
                notificationCenter2.postNotificationName(i5, Integer.valueOf(guid), Integer.valueOf(messageObject2.getId()), Integer.valueOf(getMask()), Long.valueOf(messageObject2.getDialogId()), Integer.valueOf(this.lastReturnedNum), Integer.valueOf(iArr3[0] + iArr3[1]), Boolean.valueOf(jumpToMessage));
                return;
            }
            boolean[] zArr2 = this.messagesSearchEndReached;
            if (zArr2[0] && mergeDialogId == 0 && zArr2[1]) {
                this.lastReturnedNum--;
                return;
            }
            String str3 = this.lastSearchQuery;
            ArrayList<MessageObject> arrayList = this.searchResultMessages;
            MessageObject messageObject3 = arrayList.get(arrayList.size() - 1);
            if (messageObject3.getDialogId() == dialogId && !this.messagesSearchEndReached[0]) {
                id = messageObject3.getId();
                j3 = dialogId;
            } else {
                id = messageObject3.getDialogId() == mergeDialogId ? messageObject3.getId() : 0;
                this.messagesSearchEndReached[1] = false;
                j3 = mergeDialogId;
            }
            j = j3;
            i = id;
            str = str3;
            z = false;
        }
        boolean[] zArr3 = this.messagesSearchEndReached;
        if (!zArr3[0] || zArr3[1]) {
            j2 = 0;
        } else {
            j2 = 0;
            if (mergeDialogId != 0) {
                j = mergeDialogId;
            }
        }
        if (j != dialogId || !z) {
            str2 = str;
        } else {
            if (mergeDialogId != j2) {
                TLRPC$InputPeer inputPeer = getMessagesController().getInputPeer(mergeDialogId);
                if (inputPeer == null) {
                    return;
                }
                final TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
                tLRPC$TL_messages_search.peer = inputPeer;
                this.lastMergeDialogId = mergeDialogId;
                tLRPC$TL_messages_search.limit = 1;
                tLRPC$TL_messages_search.q = str;
                if (user != null) {
                    tLRPC$TL_messages_search.from_id = MessagesController.getInputPeer(user);
                    tLRPC$TL_messages_search.flags = 1 | tLRPC$TL_messages_search.flags;
                } else if (chat != null) {
                    tLRPC$TL_messages_search.from_id = MessagesController.getInputPeer(chat);
                    tLRPC$TL_messages_search.flags = 1 | tLRPC$TL_messages_search.flags;
                }
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterEmpty();
                this.mergeReqId = getConnectionsManager().sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$R-v35ALkFx94cm-5Xe7gJnhMT2Y
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$searchMessagesInChat$68$MediaDataController(mergeDialogId, tLRPC$TL_messages_search, dialogId, guid, direction, replyMessageId, user, chat, jumpToMessage, tLObject, tLRPC$TL_error);
                    }
                }, 2);
                return;
            }
            str2 = str;
            this.lastMergeDialogId = 0L;
            zArr3[1] = true;
            this.messagesSearchCount[1] = 0;
        }
        final TLRPC$TL_messages_search tLRPC$TL_messages_search2 = new TLRPC$TL_messages_search();
        TLRPC$InputPeer inputPeer2 = getMessagesController().getInputPeer(j);
        tLRPC$TL_messages_search2.peer = inputPeer2;
        if (inputPeer2 == null) {
            return;
        }
        this.lastGuid = guid;
        this.lastDialogId = dialogId;
        this.lastSearchUser = user;
        this.lastSearchChat = chat;
        this.lastReplyMessageId = replyMessageId;
        tLRPC$TL_messages_search2.limit = 21;
        tLRPC$TL_messages_search2.q = str2 != null ? str2 : "";
        tLRPC$TL_messages_search2.offset_id = i;
        if (user != null) {
            tLRPC$TL_messages_search2.from_id = MessagesController.getInputPeer(user);
            tLRPC$TL_messages_search2.flags |= 1;
        } else if (chat != null) {
            tLRPC$TL_messages_search2.from_id = MessagesController.getInputPeer(chat);
            tLRPC$TL_messages_search2.flags |= 1;
        }
        int i6 = this.lastReplyMessageId;
        if (i6 != 0) {
            tLRPC$TL_messages_search2.top_msg_id = i6;
            tLRPC$TL_messages_search2.flags |= 2;
        }
        tLRPC$TL_messages_search2.filter = new TLRPC$TL_inputMessagesFilterEmpty();
        final int i7 = this.lastReqId + 1;
        this.lastReqId = i7;
        this.lastSearchQuery = str2;
        final String str4 = str2;
        final long j4 = j;
        this.reqId = getConnectionsManager().sendRequest(tLRPC$TL_messages_search2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$VgwP9o7hnW9jAa-6qtedSBrerfw
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$searchMessagesInChat$70$MediaDataController(str4, i7, jumpToMessage, tLRPC$TL_messages_search2, j4, dialogId, guid, mergeDialogId, replyMessageId, user, chat, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchMessagesInChat$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchMessagesInChat$68$MediaDataController(final long j, final TLRPC$TL_messages_search tLRPC$TL_messages_search, final long j2, final int i, final int i2, final int i3, final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$0Yao32cduGh5p9B_cRFJnv0SLtM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchMessagesInChat$67$MediaDataController(j, tLObject, tLRPC$TL_messages_search, j2, i, i2, i3, tLRPC$User, tLRPC$Chat, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchMessagesInChat$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchMessagesInChat$67$MediaDataController(long j, TLObject tLObject, TLRPC$TL_messages_search tLRPC$TL_messages_search, long j2, int i, int i2, int i3, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, boolean z) {
        if (this.lastMergeDialogId == j) {
            this.mergeReqId = 0;
            if (tLObject != null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                this.messagesSearchEndReached[1] = tLRPC$messages_Messages.messages.isEmpty();
                this.messagesSearchCount[1] = tLRPC$messages_Messages instanceof TLRPC$TL_messages_messagesSlice ? tLRPC$messages_Messages.count : tLRPC$messages_Messages.messages.size();
                searchMessagesInChat(tLRPC$TL_messages_search.q, j2, j, i, i2, i3, true, tLRPC$User, tLRPC$Chat, z);
                return;
            }
            this.messagesSearchEndReached[1] = true;
            this.messagesSearchCount[1] = 0;
            searchMessagesInChat(tLRPC$TL_messages_search.q, j2, j, i, i2, i3, true, tLRPC$User, tLRPC$Chat, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchMessagesInChat$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchMessagesInChat$70$MediaDataController(String str, final int i, final boolean z, final TLRPC$TL_messages_search tLRPC$TL_messages_search, final long j, final long j2, final int i2, final long j3, final int i3, final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final ArrayList arrayList = new ArrayList();
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            int iMin = Math.min(tLRPC$messages_Messages.messages.size(), 20);
            for (int i4 = 0; i4 < iMin; i4++) {
                MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$messages_Messages.messages.get(i4), false, false);
                messageObject.setQuery(str);
                arrayList.add(messageObject);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$RJ_kmkvEGu5Rk9qBPn2aM56u49A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchMessagesInChat$69$MediaDataController(i, z, tLObject, tLRPC$TL_messages_search, j, j2, i2, arrayList, j3, i3, tLRPC$User, tLRPC$Chat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchMessagesInChat$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchMessagesInChat$69$MediaDataController(int i, boolean z, TLObject tLObject, TLRPC$TL_messages_search tLRPC$TL_messages_search, long j, long j2, int i2, ArrayList arrayList, long j3, int i3, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat) {
        if (i == this.lastReqId) {
            this.reqId = 0;
            if (!z) {
                this.loadingMoreSearchMessages = false;
            }
            if (tLObject != null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                int i4 = 0;
                while (i4 < tLRPC$messages_Messages.messages.size()) {
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i4);
                    if ((tLRPC$Message instanceof TLRPC$TL_messageEmpty) || (tLRPC$Message.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                        tLRPC$messages_Messages.messages.remove(i4);
                        i4--;
                    }
                    i4++;
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
                int iMin = Math.min(tLRPC$messages_Messages.messages.size(), 20);
                int i5 = 0;
                boolean z2 = false;
                while (i5 < iMin) {
                    tLRPC$messages_Messages.messages.get(i5);
                    MessageObject messageObject = (MessageObject) arrayList.get(i5);
                    this.searchResultMessages.add(messageObject);
                    this.searchResultMessagesMap[j == j2 ? (char) 0 : (char) 1].put(messageObject.getId(), messageObject);
                    i5++;
                    z2 = true;
                }
                this.messagesSearchEndReached[j == j2 ? (char) 0 : (char) 1] = tLRPC$messages_Messages.messages.size() < 21;
                this.messagesSearchCount[j == j2 ? (char) 0 : (char) 1] = ((tLRPC$messages_Messages instanceof TLRPC$TL_messages_messagesSlice) || (tLRPC$messages_Messages instanceof TLRPC$TL_messages_channelMessages)) ? tLRPC$messages_Messages.count : tLRPC$messages_Messages.messages.size();
                if (this.searchResultMessages.isEmpty()) {
                    getNotificationCenter().postNotificationName(NotificationCenter.chatSearchResultsAvailable, Integer.valueOf(i2), 0, Integer.valueOf(getMask()), 0L, 0, 0, Boolean.valueOf(z));
                } else if (z2) {
                    if (this.lastReturnedNum >= this.searchResultMessages.size()) {
                        this.lastReturnedNum = this.searchResultMessages.size() - 1;
                    }
                    MessageObject messageObject2 = this.searchResultMessages.get(this.lastReturnedNum);
                    NotificationCenter notificationCenter = getNotificationCenter();
                    int i6 = NotificationCenter.chatSearchResultsAvailable;
                    int[] iArr = this.messagesSearchCount;
                    notificationCenter.postNotificationName(i6, Integer.valueOf(i2), Integer.valueOf(messageObject2.getId()), Integer.valueOf(getMask()), Long.valueOf(messageObject2.getDialogId()), Integer.valueOf(this.lastReturnedNum), Integer.valueOf(iArr[0] + iArr[1]), Boolean.valueOf(z));
                }
                if (j == j2) {
                    boolean[] zArr = this.messagesSearchEndReached;
                    if (!zArr[0] || j3 == 0 || zArr[1]) {
                        return;
                    }
                    searchMessagesInChat(this.lastSearchQuery, j2, j3, i2, 0, i3, true, tLRPC$User, tLRPC$Chat, z);
                }
            }
        }
    }

    public String getLastSearchQuery() {
        return this.lastSearchQuery;
    }

    public void loadMedia(final long dialogId, final int count, final int max_id, final int type, int fromCache, final int classGuid) {
        TLRPC$Chat chat;
        boolean z = DialogObject.isChatDialog(dialogId) && ChatObject.isChannel(-dialogId, this.currentAccount);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("load media did " + dialogId + " count = " + count + " max_id " + max_id + " type = " + type + " cache = " + fromCache + " classGuid = " + classGuid);
        }
        if (fromCache != 0 || DialogObject.isEncryptedDialog(dialogId)) {
            loadMediaDatabase(dialogId, count, max_id, type, classGuid, z, fromCache);
            return;
        }
        TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
        tLRPC$TL_messages_search.limit = count;
        tLRPC$TL_messages_search.offset_id = max_id;
        if (type == 0) {
            tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterPhotoVideo();
        } else if (type == 1) {
            tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterDocument();
        } else if (type == 2) {
            tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterRoundVoice();
        } else if (type == 3) {
            tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterUrl();
        } else if (type == 4) {
            tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterMusic();
        } else if (type == 5) {
            tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterGif();
        }
        tLRPC$TL_messages_search.q = "";
        TLRPC$InputPeer inputPeer = getMessagesController().getInputPeer(dialogId);
        tLRPC$TL_messages_search.peer = inputPeer;
        if (inputPeer == null) {
            return;
        }
        if (dialogId < 0 && (chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-dialogId))) != null && chat.isMediaContent) {
            tLRPC$TL_messages_search.flags = 2 | tLRPC$TL_messages_search.flags;
        }
        final boolean z2 = z;
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$YScXo14uP3oouH-jQ3RdSe1zwtY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadMedia$71$MediaDataController(dialogId, count, max_id, type, classGuid, z2, tLObject, tLRPC$TL_error);
            }
        }), classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMedia$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMedia$71$MediaDataController(long j, int i, int i2, int i3, int i4, boolean z, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            getMessagesController().removeDeletedMessagesFromArray(j, tLRPC$messages_Messages.messages);
            processLoadedMedia(tLRPC$messages_Messages, j, i, i2, i3, 0, i4, z, tLRPC$messages_Messages.messages.size() == 0);
        }
    }

    public void getMediaCounts(final long dialogId, final int classGuid) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$8tvKmH-07vGnyGfEXOXseMY3dCA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMediaCounts$76$MediaDataController(dialogId, classGuid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMediaCounts$76, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMediaCounts$76$MediaDataController(final long j, int i) {
        try {
            final int[] iArr = new int[6];
            iArr[0] = -1;
            iArr[1] = -1;
            iArr[2] = -1;
            iArr[3] = -1;
            iArr[4] = -1;
            iArr[5] = -1;
            final int[] iArr2 = new int[6];
            iArr2[0] = -1;
            iArr2[1] = -1;
            iArr2[2] = -1;
            iArr2[3] = -1;
            iArr2[4] = -1;
            iArr2[5] = -1;
            int[] iArr3 = new int[6];
            iArr3[0] = 0;
            iArr3[1] = 0;
            iArr3[2] = 0;
            iArr3[3] = 0;
            iArr3[4] = 0;
            iArr3[5] = 0;
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT type, count, old FROM media_counts_v2 WHERE uid = %d", Long.valueOf(j)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                if (iIntValue >= 0 && iIntValue < 6) {
                    int iIntValue2 = sQLiteCursorQueryFinalized.intValue(1);
                    iArr[iIntValue] = iIntValue2;
                    iArr2[iIntValue] = iIntValue2;
                    iArr3[iIntValue] = sQLiteCursorQueryFinalized.intValue(2);
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (DialogObject.isEncryptedDialog(j)) {
                for (int i2 = 0; i2 < 6; i2++) {
                    if (iArr[i2] == -1) {
                        SQLiteCursor sQLiteCursorQueryFinalized2 = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT COUNT(mid) FROM media_v3 WHERE uid = %d AND type = %d LIMIT 1", Long.valueOf(j), Integer.valueOf(i2)), new Object[0]);
                        if (sQLiteCursorQueryFinalized2.next()) {
                            iArr[i2] = sQLiteCursorQueryFinalized2.intValue(0);
                        } else {
                            iArr[i2] = 0;
                        }
                        sQLiteCursorQueryFinalized2.dispose();
                        putMediaCountDatabase(j, i2, iArr[i2]);
                    }
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$fHXsdS3UGuRDiR6FqFH51GakxVc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getMediaCounts$72$MediaDataController(j, iArr);
                    }
                });
                return;
            }
            TLRPC$TL_messages_getSearchCounters tLRPC$TL_messages_getSearchCounters = new TLRPC$TL_messages_getSearchCounters();
            tLRPC$TL_messages_getSearchCounters.peer = getMessagesController().getInputPeer(j);
            int i3 = 0;
            boolean z = false;
            for (int i4 = 6; i3 < i4; i4 = 6) {
                if (tLRPC$TL_messages_getSearchCounters.peer == null) {
                    iArr[i3] = 0;
                } else if (iArr[i3] == -1 || iArr3[i3] == 1) {
                    if (i3 == 0) {
                        tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterPhotoVideo());
                    } else if (i3 == 1) {
                        tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterDocument());
                    } else if (i3 == 2) {
                        tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterRoundVoice());
                    } else if (i3 == 3) {
                        tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterUrl());
                    } else if (i3 == 4) {
                        tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterMusic());
                    } else {
                        tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterGif());
                    }
                    if (iArr[i3] == -1) {
                        z = true;
                    } else if (iArr3[i3] == 1) {
                        iArr[i3] = -1;
                    }
                }
                i3++;
            }
            if (!tLRPC$TL_messages_getSearchCounters.filters.isEmpty()) {
                getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getSearchCounters, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$HyHa9VSfDH_Cy5JAixCdy4_pWeA
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$getMediaCounts$74$MediaDataController(iArr, j, tLObject, tLRPC$TL_error);
                    }
                }), i);
            }
            if (z) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$_sQgELQFiNQfdRaVyhqZ36Q88vQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getMediaCounts$75$MediaDataController(j, iArr2);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMediaCounts$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMediaCounts$72$MediaDataController(long j, int[] iArr) {
        getNotificationCenter().postNotificationName(NotificationCenter.mediaCountsDidLoad, Long.valueOf(j), iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMediaCounts$74, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMediaCounts$74$MediaDataController(final int[] iArr, final long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        int i;
        Arrays.fill(iArr, 0);
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            int size = tLRPC$Vector.objects.size();
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$TL_messages_searchCounter tLRPC$TL_messages_searchCounter = (TLRPC$TL_messages_searchCounter) tLRPC$Vector.objects.get(i2);
                TLRPC$MessagesFilter tLRPC$MessagesFilter = tLRPC$TL_messages_searchCounter.filter;
                if (tLRPC$MessagesFilter instanceof TLRPC$TL_inputMessagesFilterPhotoVideo) {
                    i = 0;
                } else if (tLRPC$MessagesFilter instanceof TLRPC$TL_inputMessagesFilterDocument) {
                    i = 1;
                } else if (tLRPC$MessagesFilter instanceof TLRPC$TL_inputMessagesFilterRoundVoice) {
                    i = 2;
                } else if (tLRPC$MessagesFilter instanceof TLRPC$TL_inputMessagesFilterUrl) {
                    i = 3;
                } else if (tLRPC$MessagesFilter instanceof TLRPC$TL_inputMessagesFilterMusic) {
                    i = 4;
                } else if (tLRPC$MessagesFilter instanceof TLRPC$TL_inputMessagesFilterGif) {
                    i = 5;
                }
                iArr[i] = tLRPC$TL_messages_searchCounter.count;
                putMediaCountDatabase(j, i, iArr[i]);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$6QTJG7uxl228nLy_646eONAP-bc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMediaCounts$73$MediaDataController(j, iArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMediaCounts$73, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMediaCounts$73$MediaDataController(long j, int[] iArr) {
        getNotificationCenter().postNotificationName(NotificationCenter.mediaCountsDidLoad, Long.valueOf(j), iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMediaCounts$75, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMediaCounts$75$MediaDataController(long j, int[] iArr) {
        getNotificationCenter().postNotificationName(NotificationCenter.mediaCountsDidLoad, Long.valueOf(j), iArr);
    }

    public void getMediaCount(final long dialogId, final int type, final int classGuid, boolean fromCache) {
        if (fromCache || DialogObject.isEncryptedDialog(dialogId)) {
            getMediaCountDatabase(dialogId, type, classGuid);
            return;
        }
        TLRPC$TL_messages_getSearchCounters tLRPC$TL_messages_getSearchCounters = new TLRPC$TL_messages_getSearchCounters();
        if (type == 0) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterPhotoVideo());
        } else if (type == 1) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterDocument());
        } else if (type == 2) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterRoundVoice());
        } else if (type == 3) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterUrl());
        } else if (type == 4) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterMusic());
        } else if (type == 5) {
            tLRPC$TL_messages_getSearchCounters.filters.add(new TLRPC$TL_inputMessagesFilterGif());
        }
        TLRPC$InputPeer inputPeer = getMessagesController().getInputPeer(dialogId);
        tLRPC$TL_messages_getSearchCounters.peer = inputPeer;
        if (inputPeer == null) {
            return;
        }
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getSearchCounters, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Sb2ZmwFfQHq6VK1D4BiUAl5kazM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getMediaCount$77$MediaDataController(dialogId, type, classGuid, tLObject, tLRPC$TL_error);
            }
        }), classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMediaCount$77, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMediaCount$77$MediaDataController(long j, int i, int i2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            if (tLRPC$Vector.objects.isEmpty()) {
                return;
            }
            processLoadedMediaCount(((TLRPC$TL_messages_searchCounter) tLRPC$Vector.objects.get(0)).count, j, i, i2, false, 0);
        }
    }

    public static int getMediaType(TLRPC$Message message) {
        if (message == null) {
            return -1;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
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
        if (!message.entities.isEmpty()) {
            for (int i2 = 0; i2 < message.entities.size(); i2++) {
                TLRPC$MessageEntity tLRPC$MessageEntity = message.entities.get(i2);
                if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityUrl) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityTextUrl) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityEmail)) {
                    return 3;
                }
            }
        }
        return -1;
    }

    public static boolean canAddMessageToMedia(TLRPC$Message message) {
        int i;
        boolean z = message instanceof TLRPC$TL_message_secret;
        if (z && (((message.media instanceof TLRPC$TL_messageMediaPhoto) || MessageObject.isVideoMessage(message) || MessageObject.isGifMessage(message)) && (i = message.media.ttl_seconds) != 0 && i <= 60)) {
            return false;
        }
        if (!z && (message instanceof TLRPC$TL_message)) {
            TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument)) && tLRPC$MessageMedia.ttl_seconds != 0) {
                return false;
            }
        }
        return getMediaType(message) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLoadedMedia(final TLRPC$messages_Messages res, final long dialogId, int count, int max_id, final int type, final int fromCache, final int classGuid, boolean isChannel, final boolean topReached) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("process load media did " + dialogId + " count = " + count + " max_id " + max_id + " type = " + type + " cache = " + fromCache + " classGuid = " + classGuid);
        }
        if (fromCache != 0 && res.messages.isEmpty() && !DialogObject.isEncryptedDialog(dialogId)) {
            if (fromCache == 2) {
                return;
            }
            loadMedia(dialogId, count, max_id, type, 0, classGuid);
        } else {
            if (fromCache == 0) {
                ImageLoader.saveMessagesThumbs(res.messages);
                getMessagesStorage().putUsersAndChats(res.users, res.chats, true, true);
                putMediaDatabase(dialogId, type, res.messages, max_id, topReached);
            }
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$ItzlnYUGctrYHf86KKlxx6DbBXg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedMedia$79$MediaDataController(res, fromCache, dialogId, classGuid, type, topReached);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedMedia$79, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedMedia$79$MediaDataController(final TLRPC$messages_Messages tLRPC$messages_Messages, final int i, final long j, final int i2, final int i3, final boolean z) {
        LongSparseArray longSparseArray = new LongSparseArray();
        for (int i4 = 0; i4 < tLRPC$messages_Messages.users.size(); i4++) {
            TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i4);
            longSparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        final ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < tLRPC$messages_Messages.messages.size(); i5++) {
            MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$messages_Messages.messages.get(i5), (LongSparseArray<TLRPC$User>) longSparseArray, true, true);
            messageObject.createStrippedThumb();
            arrayList.add(messageObject);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$WBV0qjtPKwtfFixUHJVxdfTtHdc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedMedia$78$MediaDataController(tLRPC$messages_Messages, i, j, arrayList, i2, i3, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedMedia$78, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedMedia$78$MediaDataController(TLRPC$messages_Messages tLRPC$messages_Messages, int i, long j, ArrayList arrayList, int i2, int i3, boolean z) {
        int i4 = tLRPC$messages_Messages.count;
        getMessagesController().putUsers(tLRPC$messages_Messages.users, i != 0);
        getMessagesController().putChats(tLRPC$messages_Messages.chats, i != 0);
        getNotificationCenter().postNotificationName(NotificationCenter.mediaDidLoad, Long.valueOf(j), Integer.valueOf(i4), arrayList, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
    }

    private void processLoadedMediaCount(final int count, final long dialogId, final int type, final int classGuid, final boolean fromCache, final int old) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$zOwjJ0QanU1SSWC_02frRght8Ik
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedMediaCount$80$MediaDataController(dialogId, fromCache, count, type, old, classGuid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedMediaCount$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedMediaCount$80$MediaDataController(long j, boolean z, int i, int i2, int i3, int i4) {
        boolean zIsEncryptedDialog = DialogObject.isEncryptedDialog(j);
        boolean z2 = z && (i == -1 || (i == 0 && i2 == 2)) && !zIsEncryptedDialog;
        if (z2 || (i3 == 1 && !zIsEncryptedDialog)) {
            getMediaCount(j, i2, i4, false);
        }
        if (z2) {
            return;
        }
        if (!z) {
            putMediaCountDatabase(j, i2, i);
        }
        NotificationCenter notificationCenter = getNotificationCenter();
        int i5 = NotificationCenter.mediaCountDidLoad;
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Integer.valueOf((z && i == -1) ? 0 : i);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(i2);
        notificationCenter.postNotificationName(i5, objArr);
    }

    private void putMediaCountDatabase(final long uid, final int type, final int count) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$asimlEuaHVlWiETBjAIYWkCHo_M
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putMediaCountDatabase$81$MediaDataController(uid, type, count);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putMediaCountDatabase$81, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putMediaCountDatabase$81$MediaDataController(long j, int i, int i2) {
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

    private void getMediaCountDatabase(final long dialogId, final int type, final int classGuid) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Xm4J_SMzCXcFIduG_n-jc5Qujn8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMediaCountDatabase$82$MediaDataController(dialogId, type, classGuid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080 A[PHI: r2
      0x0080: PHI (r2v5 int) = (r2v4 int), (r2v4 int), (r2v7 int) binds: [B:7:0x003d, B:9:0x0043, B:14:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: lambda$getMediaCountDatabase$82, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getMediaCountDatabase$82$MediaDataController(long r17, int r19, int r20) {
        /*
            r16 = this;
            ir.eitaa.messenger.MessagesStorage r0 = r16.getMessagesStorage()     // Catch: java.lang.Exception -> L96
            ir.eitaa.SQLite.SQLiteDatabase r0 = r0.getDatabase()     // Catch: java.lang.Exception -> L96
            java.util.Locale r1 = java.util.Locale.US     // Catch: java.lang.Exception -> L96
            java.lang.String r2 = "SELECT count, old FROM media_counts_v2 WHERE uid = %d AND type = %d LIMIT 1"
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L96
            java.lang.Long r5 = java.lang.Long.valueOf(r17)     // Catch: java.lang.Exception -> L96
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Exception -> L96
            java.lang.Integer r5 = java.lang.Integer.valueOf(r19)     // Catch: java.lang.Exception -> L96
            r7 = 1
            r4[r7] = r5     // Catch: java.lang.Exception -> L96
            java.lang.String r2 = java.lang.String.format(r1, r2, r4)     // Catch: java.lang.Exception -> L96
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L96
            ir.eitaa.SQLite.SQLiteCursor r0 = r0.queryFinalized(r2, r4)     // Catch: java.lang.Exception -> L96
            boolean r2 = r0.next()     // Catch: java.lang.Exception -> L96
            r4 = -1
            if (r2 == 0) goto L38
            int r2 = r0.intValue(r6)     // Catch: java.lang.Exception -> L96
            int r5 = r0.intValue(r7)     // Catch: java.lang.Exception -> L96
            r15 = r5
            goto L3a
        L38:
            r2 = -1
            r15 = 0
        L3a:
            r0.dispose()     // Catch: java.lang.Exception -> L96
            if (r2 != r4) goto L80
            boolean r0 = ir.eitaa.messenger.DialogObject.isEncryptedDialog(r17)     // Catch: java.lang.Exception -> L96
            if (r0 == 0) goto L80
            ir.eitaa.messenger.MessagesStorage r0 = r16.getMessagesStorage()     // Catch: java.lang.Exception -> L96
            ir.eitaa.SQLite.SQLiteDatabase r0 = r0.getDatabase()     // Catch: java.lang.Exception -> L96
            java.lang.String r5 = "SELECT COUNT(mid) FROM media_v3 WHERE uid = %d AND type = %d LIMIT 1"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L96
            java.lang.Long r8 = java.lang.Long.valueOf(r17)     // Catch: java.lang.Exception -> L96
            r3[r6] = r8     // Catch: java.lang.Exception -> L96
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)     // Catch: java.lang.Exception -> L96
            r3[r7] = r8     // Catch: java.lang.Exception -> L96
            java.lang.String r1 = java.lang.String.format(r1, r5, r3)     // Catch: java.lang.Exception -> L96
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L96
            ir.eitaa.SQLite.SQLiteCursor r0 = r0.queryFinalized(r1, r3)     // Catch: java.lang.Exception -> L96
            boolean r1 = r0.next()     // Catch: java.lang.Exception -> L96
            if (r1 == 0) goto L71
            int r2 = r0.intValue(r6)     // Catch: java.lang.Exception -> L96
        L71:
            r0.dispose()     // Catch: java.lang.Exception -> L96
            if (r2 == r4) goto L80
            r1 = r16
            r3 = r17
            r0 = r19
            r1.putMediaCountDatabase(r3, r0, r2)     // Catch: java.lang.Exception -> L94
            goto L86
        L80:
            r1 = r16
            r3 = r17
            r0 = r19
        L86:
            r9 = r2
            r14 = 1
            r8 = r16
            r10 = r17
            r12 = r19
            r13 = r20
            r8.processLoadedMediaCount(r9, r10, r12, r13, r14, r15)     // Catch: java.lang.Exception -> L94
            goto L9c
        L94:
            r0 = move-exception
            goto L99
        L96:
            r0 = move-exception
            r1 = r16
        L99:
            ir.eitaa.messenger.FileLog.e(r0)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.lambda$getMediaCountDatabase$82$MediaDataController(long, int, int):void");
    }

    /* renamed from: ir.eitaa.messenger.MediaDataController$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int val$classGuid;
        final /* synthetic */ int val$count;
        final /* synthetic */ int val$fromCache;
        final /* synthetic */ boolean val$isChannel;
        final /* synthetic */ int val$max_id;
        final /* synthetic */ int val$type;
        final /* synthetic */ long val$uid;

        AnonymousClass1(final int val$count, final long val$uid, final int val$type, final int val$max_id, final int val$classGuid, final int val$fromCache, final boolean val$isChannel) {
            this.val$count = val$count;
            this.val$uid = val$uid;
            this.val$type = val$type;
            this.val$max_id = val$max_id;
            this.val$classGuid = val$classGuid;
            this.val$fromCache = val$fromCache;
            this.val$isChannel = val$isChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00ae A[Catch: all -> 0x02eb, Exception -> 0x02ed, TryCatch #0 {Exception -> 0x02ed, blocks: (B:3:0x0007, B:5:0x0029, B:7:0x004f, B:16:0x00a7, B:18:0x00ae, B:20:0x00dd, B:22:0x00e3, B:24:0x00e8, B:40:0x0244, B:42:0x024a, B:44:0x0250, B:46:0x0276, B:48:0x027f, B:50:0x028a, B:53:0x0295, B:54:0x02a4, B:56:0x02aa, B:57:0x02b9, B:59:0x02c3, B:25:0x0122, B:26:0x0155, B:28:0x017b, B:30:0x0181, B:32:0x0186, B:33:0x01b6, B:10:0x0057, B:12:0x007e, B:14:0x0084, B:35:0x01e0, B:37:0x01e4, B:38:0x0219), top: B:73:0x0007, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0155 A[Catch: all -> 0x02eb, Exception -> 0x02ed, TryCatch #0 {Exception -> 0x02ed, blocks: (B:3:0x0007, B:5:0x0029, B:7:0x004f, B:16:0x00a7, B:18:0x00ae, B:20:0x00dd, B:22:0x00e3, B:24:0x00e8, B:40:0x0244, B:42:0x024a, B:44:0x0250, B:46:0x0276, B:48:0x027f, B:50:0x028a, B:53:0x0295, B:54:0x02a4, B:56:0x02aa, B:57:0x02b9, B:59:0x02c3, B:25:0x0122, B:26:0x0155, B:28:0x017b, B:30:0x0181, B:32:0x0186, B:33:0x01b6, B:10:0x0057, B:12:0x007e, B:14:0x0084, B:35:0x01e0, B:37:0x01e4, B:38:0x0219), top: B:73:0x0007, outer: #1 }] */
        /* JADX WARN: Type inference failed for: r7v12, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 832
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.AnonymousClass1.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$MediaDataController$1(Runnable runnable, int i) {
            MediaDataController.this.getMessagesStorage().completeTaskForGuid(runnable, i);
        }
    }

    private void loadMediaDatabase(long uid, int count, int max_id, int type, int classGuid, boolean isChannel, int fromCache) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(count, uid, type, max_id, classGuid, fromCache, isChannel);
        MessagesStorage messagesStorage = getMessagesStorage();
        messagesStorage.getStorageQueue().postRunnable(anonymousClass1);
        messagesStorage.bindTaskToGuid(anonymousClass1, classGuid);
    }

    private void putMediaDatabase(final long uid, final int type, final ArrayList<TLRPC$Message> messages, final int max_id, final boolean topReached) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$dSY3DIYpAGyrNLwFVfGe0YkQ8Ww
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putMediaDatabase$83$MediaDataController(messages, topReached, uid, max_id, type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putMediaDatabase$83, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putMediaDatabase$83$MediaDataController(ArrayList arrayList, boolean z, long j, int i, int i2) {
        try {
            if (arrayList.isEmpty() || z) {
                getMessagesStorage().doneHolesInMedia(j, i, i2);
                if (arrayList.isEmpty()) {
                    return;
                }
            }
            getMessagesStorage().getDatabase().beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO media_v3 VALUES(?, ?, ?, ?, ?)");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) it.next();
                if (canAddMessageToMedia(tLRPC$Message)) {
                    sQLitePreparedStatementExecuteFast.requery();
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                    tLRPC$Message.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$Message.id);
                    sQLitePreparedStatementExecuteFast.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast.bindInteger(3, tLRPC$Message.date);
                    sQLitePreparedStatementExecuteFast.bindInteger(4, i2);
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(5, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            if (!z || i != 0) {
                int i3 = z ? 1 : ((TLRPC$Message) arrayList.get(arrayList.size() - 1)).id;
                if (i != 0) {
                    getMessagesStorage().closeHolesInMedia(j, i3, i, i2);
                } else {
                    getMessagesStorage().closeHolesInMedia(j, i3, ConnectionsManager.DEFAULT_DATACENTER_ID, i2);
                }
            }
            getMessagesStorage().getDatabase().commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void loadMusic(final long dialogId, final long maxId, final long minId) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$yN2YQZrucLFqy0A9UDIskFyglQg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMusic$85$MediaDataController(dialogId, maxId, minId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMusic$85, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMusic$85$MediaDataController(final long j, long j2, long j3) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (i < 2) {
            ArrayList arrayList3 = i == 0 ? arrayList : arrayList2;
            if (i == 0) {
                try {
                    if (!DialogObject.isEncryptedDialog(j)) {
                        sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid FROM media_v3 WHERE uid = %d AND mid < %d AND type = %d ORDER BY date DESC, mid DESC LIMIT 1000", Long.valueOf(j), Long.valueOf(j2), 4), new Object[0]);
                    } else {
                        sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid FROM media_v3 WHERE uid = %d AND mid > %d AND type = %d ORDER BY date DESC, mid DESC LIMIT 1000", Long.valueOf(j), Long.valueOf(j2), 4), new Object[0]);
                    }
                } catch (Exception e) {
                    e = e;
                    FileLog.e(e);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$GjJQw3gFBpvRGKR8afSrG5h6ZFs
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$loadMusic$84$MediaDataController(j, arrayList, arrayList2);
                        }
                    });
                }
            } else if (!DialogObject.isEncryptedDialog(j)) {
                sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid FROM media_v3 WHERE uid = %d AND mid > %d AND type = %d ORDER BY date DESC, mid DESC LIMIT 1000", Long.valueOf(j), Long.valueOf(j3), 4), new Object[0]);
            } else {
                sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid FROM media_v3 WHERE uid = %d AND mid < %d AND type = %d ORDER BY date DESC, mid DESC LIMIT 1000", Long.valueOf(j), Long.valueOf(j3), 4), new Object[0]);
            }
            while (sQLiteCursorQueryFinalized.next()) {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    if (MessageObject.isMusicMessage(tLRPC$MessageTLdeserialize)) {
                        tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(1);
                        try {
                            tLRPC$MessageTLdeserialize.dialog_id = j;
                        } catch (Exception e2) {
                            e = e2;
                        }
                        try {
                            arrayList3.add(0, new MessageObject(this.currentAccount, tLRPC$MessageTLdeserialize, false, true));
                        } catch (Exception e3) {
                            e = e3;
                            FileLog.e(e);
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$GjJQw3gFBpvRGKR8afSrG5h6ZFs
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$loadMusic$84$MediaDataController(j, arrayList, arrayList2);
                                }
                            });
                        }
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            i++;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$GjJQw3gFBpvRGKR8afSrG5h6ZFs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMusic$84$MediaDataController(j, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMusic$84, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMusic$84$MediaDataController(long j, ArrayList arrayList, ArrayList arrayList2) {
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
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$CjCfWDMYazcArCdOMxukj8sme_A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$buildShortcuts$86$MediaDataController(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x028f A[Catch: all -> 0x02ca, TryCatch #3 {all -> 0x02ca, blocks: (B:3:0x0004, B:5:0x0009, B:6:0x002a, B:9:0x0045, B:11:0x004b, B:12:0x004f, B:14:0x0055, B:16:0x0077, B:18:0x007d, B:20:0x008d, B:21:0x0090, B:22:0x0096, B:24:0x009c, B:27:0x00a3, B:29:0x00ee, B:31:0x00f9, B:33:0x0102, B:34:0x0107, B:35:0x0112, B:37:0x0118, B:39:0x0133, B:42:0x015d, B:47:0x0169, B:49:0x0175, B:55:0x0188, B:74:0x0261, B:77:0x0278, B:79:0x028f, B:81:0x0294, B:83:0x02a8, B:85:0x02b5, B:87:0x02c0, B:86:0x02bb, B:82:0x029c, B:72:0x025b, B:50:0x0178, B:52:0x017e, B:40:0x0147, B:30:0x00f4), top: B:98:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0294 A[Catch: all -> 0x02ca, TryCatch #3 {all -> 0x02ca, blocks: (B:3:0x0004, B:5:0x0009, B:6:0x002a, B:9:0x0045, B:11:0x004b, B:12:0x004f, B:14:0x0055, B:16:0x0077, B:18:0x007d, B:20:0x008d, B:21:0x0090, B:22:0x0096, B:24:0x009c, B:27:0x00a3, B:29:0x00ee, B:31:0x00f9, B:33:0x0102, B:34:0x0107, B:35:0x0112, B:37:0x0118, B:39:0x0133, B:42:0x015d, B:47:0x0169, B:49:0x0175, B:55:0x0188, B:74:0x0261, B:77:0x0278, B:79:0x028f, B:81:0x0294, B:83:0x02a8, B:85:0x02b5, B:87:0x02c0, B:86:0x02bb, B:82:0x029c, B:72:0x025b, B:50:0x0178, B:52:0x017e, B:40:0x0147, B:30:0x00f4), top: B:98:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x029c A[Catch: all -> 0x02ca, TryCatch #3 {all -> 0x02ca, blocks: (B:3:0x0004, B:5:0x0009, B:6:0x002a, B:9:0x0045, B:11:0x004b, B:12:0x004f, B:14:0x0055, B:16:0x0077, B:18:0x007d, B:20:0x008d, B:21:0x0090, B:22:0x0096, B:24:0x009c, B:27:0x00a3, B:29:0x00ee, B:31:0x00f9, B:33:0x0102, B:34:0x0107, B:35:0x0112, B:37:0x0118, B:39:0x0133, B:42:0x015d, B:47:0x0169, B:49:0x0175, B:55:0x0188, B:74:0x0261, B:77:0x0278, B:79:0x028f, B:81:0x0294, B:83:0x02a8, B:85:0x02b5, B:87:0x02c0, B:86:0x02bb, B:82:0x029c, B:72:0x025b, B:50:0x0178, B:52:0x017e, B:40:0x0147, B:30:0x00f4), top: B:98:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02b5 A[Catch: all -> 0x02ca, TryCatch #3 {all -> 0x02ca, blocks: (B:3:0x0004, B:5:0x0009, B:6:0x002a, B:9:0x0045, B:11:0x004b, B:12:0x004f, B:14:0x0055, B:16:0x0077, B:18:0x007d, B:20:0x008d, B:21:0x0090, B:22:0x0096, B:24:0x009c, B:27:0x00a3, B:29:0x00ee, B:31:0x00f9, B:33:0x0102, B:34:0x0107, B:35:0x0112, B:37:0x0118, B:39:0x0133, B:42:0x015d, B:47:0x0169, B:49:0x0175, B:55:0x0188, B:74:0x0261, B:77:0x0278, B:79:0x028f, B:81:0x0294, B:83:0x02a8, B:85:0x02b5, B:87:0x02c0, B:86:0x02bb, B:82:0x029c, B:72:0x025b, B:50:0x0178, B:52:0x017e, B:40:0x0147, B:30:0x00f4), top: B:98:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02bb A[Catch: all -> 0x02ca, TryCatch #3 {all -> 0x02ca, blocks: (B:3:0x0004, B:5:0x0009, B:6:0x002a, B:9:0x0045, B:11:0x004b, B:12:0x004f, B:14:0x0055, B:16:0x0077, B:18:0x007d, B:20:0x008d, B:21:0x0090, B:22:0x0096, B:24:0x009c, B:27:0x00a3, B:29:0x00ee, B:31:0x00f9, B:33:0x0102, B:34:0x0107, B:35:0x0112, B:37:0x0118, B:39:0x0133, B:42:0x015d, B:47:0x0169, B:49:0x0175, B:55:0x0188, B:74:0x0261, B:77:0x0278, B:79:0x028f, B:81:0x0294, B:83:0x02a8, B:85:0x02b5, B:87:0x02c0, B:86:0x02bb, B:82:0x029c, B:72:0x025b, B:50:0x0178, B:52:0x017e, B:40:0x0147, B:30:0x00f4), top: B:98:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: lambda$buildShortcuts$86, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$buildShortcuts$86$MediaDataController(java.util.ArrayList r21) {
        /*
            Method dump skipped, instructions count: 715
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.lambda$buildShortcuts$86$MediaDataController(java.util.ArrayList):void");
    }

    public void loadHints(boolean cache) {
        if (this.loading || !getUserConfig().suggestContacts) {
            return;
        }
        if (cache) {
            if (this.loaded) {
                return;
            }
            this.loading = true;
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$ZTl8bl8n1TWcqC-NWeBCS9kclGw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHints$88$MediaDataController();
                }
            });
            this.loaded = true;
            return;
        }
        this.loading = true;
        TLRPC$TL_contacts_getTopPeers tLRPC$TL_contacts_getTopPeers = new TLRPC$TL_contacts_getTopPeers();
        tLRPC$TL_contacts_getTopPeers.hash = 0L;
        tLRPC$TL_contacts_getTopPeers.bots_pm = false;
        tLRPC$TL_contacts_getTopPeers.correspondents = true;
        tLRPC$TL_contacts_getTopPeers.groups = false;
        tLRPC$TL_contacts_getTopPeers.channels = false;
        tLRPC$TL_contacts_getTopPeers.bots_inline = true;
        tLRPC$TL_contacts_getTopPeers.offset = 0;
        tLRPC$TL_contacts_getTopPeers.limit = 20;
        getConnectionsManager().sendRequest(tLRPC$TL_contacts_getTopPeers, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$lzVZM-nVSGIOIdZTaofttSRWm8A
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadHints$93$MediaDataController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadHints$88, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHints$88$MediaDataController() {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList<TLRPC$User> arrayList3 = new ArrayList<>();
        final ArrayList<TLRPC$Chat> arrayList4 = new ArrayList<>();
        long clientUserId = getUserConfig().getClientUserId();
        try {
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            int i = 0;
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized("SELECT did, type, rating FROM chat_hints WHERE 1 ORDER BY rating DESC", new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(i);
                if (jLongValue != clientUserId) {
                    int iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                    TLRPC$TL_topPeer tLRPC$TL_topPeer = new TLRPC$TL_topPeer();
                    tLRPC$TL_topPeer.rating = sQLiteCursorQueryFinalized.doubleValue(2);
                    if (jLongValue > 0) {
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        tLRPC$TL_topPeer.peer = tLRPC$TL_peerUser;
                        tLRPC$TL_peerUser.user_id = jLongValue;
                        arrayList5.add(Long.valueOf(jLongValue));
                    } else {
                        TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
                        tLRPC$TL_topPeer.peer = tLRPC$TL_peerChat;
                        long j = -jLongValue;
                        tLRPC$TL_peerChat.chat_id = j;
                        arrayList6.add(Long.valueOf(j));
                    }
                    if (iIntValue == 0) {
                        arrayList.add(tLRPC$TL_topPeer);
                    } else if (iIntValue == 1) {
                        arrayList2.add(tLRPC$TL_topPeer);
                    }
                    i = 0;
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (!arrayList5.isEmpty()) {
                getMessagesStorage().getUsersInternal(TextUtils.join(",", arrayList5), arrayList3);
            }
            if (!arrayList6.isEmpty()) {
                getMessagesStorage().getChatsInternal(TextUtils.join(",", arrayList6), arrayList4);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$nqiha2T96n2LuiQDeg_88o220QE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHints$87$MediaDataController(arrayList3, arrayList4, arrayList, arrayList2);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadHints$87, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHints$87$MediaDataController(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
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
    /* renamed from: lambda$loadHints$93, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHints$93$MediaDataController(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_contacts_topPeers) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$KTNGNTZ-kfLTNG0qzyY971t8eFQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHints$91$MediaDataController(tLObject);
                }
            });
        } else if (tLObject instanceof TLRPC$TL_contacts_topPeersDisabled) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$FPfzUOHkIl2zGwP3Aixns5VsxhI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHints$92$MediaDataController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadHints$91, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHints$91$MediaDataController(TLObject tLObject) {
        final TLRPC$TL_contacts_topPeers tLRPC$TL_contacts_topPeers = (TLRPC$TL_contacts_topPeers) tLObject;
        getMessagesController().putUsers(tLRPC$TL_contacts_topPeers.users, false);
        getMessagesController().putChats(tLRPC$TL_contacts_topPeers.chats, false);
        for (int i = 0; i < tLRPC$TL_contacts_topPeers.categories.size(); i++) {
            TLRPC$TL_topPeerCategoryPeers tLRPC$TL_topPeerCategoryPeers = tLRPC$TL_contacts_topPeers.categories.get(i);
            if (tLRPC$TL_topPeerCategoryPeers.category instanceof TLRPC$TL_topPeerCategoryBotsInline) {
                this.inlineBots = tLRPC$TL_topPeerCategoryPeers.peers;
                getUserConfig().botRatingLoadTime = (int) (System.currentTimeMillis() / 1000);
            } else {
                this.hints = tLRPC$TL_topPeerCategoryPeers.peers;
                long clientUserId = getUserConfig().getClientUserId();
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
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Amm0wjkWDeFnQdyUpFxCGCRkrTY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadHints$90$MediaDataController(tLRPC$TL_contacts_topPeers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadHints$90, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHints$90$MediaDataController(TLRPC$TL_contacts_topPeers tLRPC$TL_contacts_topPeers) {
        try {
            getMessagesStorage().getDatabase().executeFast("DELETE FROM chat_hints WHERE 1").stepThis().dispose();
            getMessagesStorage().getDatabase().beginTransaction();
            getMessagesStorage().putUsersAndChats(tLRPC$TL_contacts_topPeers.users, tLRPC$TL_contacts_topPeers.chats, false, false);
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO chat_hints VALUES(?, ?, ?, ?)");
            for (int i = 0; i < tLRPC$TL_contacts_topPeers.categories.size(); i++) {
                TLRPC$TL_topPeerCategoryPeers tLRPC$TL_topPeerCategoryPeers = tLRPC$TL_contacts_topPeers.categories.get(i);
                int i2 = tLRPC$TL_topPeerCategoryPeers.category instanceof TLRPC$TL_topPeerCategoryBotsInline ? 1 : 0;
                for (int i3 = 0; i3 < tLRPC$TL_topPeerCategoryPeers.peers.size(); i3++) {
                    TLRPC$TL_topPeer tLRPC$TL_topPeer = tLRPC$TL_topPeerCategoryPeers.peers.get(i3);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, MessageObject.getPeerId(tLRPC$TL_topPeer.peer));
                    sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
                    sQLitePreparedStatementExecuteFast.bindDouble(3, tLRPC$TL_topPeer.rating);
                    sQLitePreparedStatementExecuteFast.bindInteger(4, 0);
                    sQLitePreparedStatementExecuteFast.step();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            getMessagesStorage().getDatabase().commitTransaction();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$zPf0wNTdizkU03g1MP1_piw333E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadHints$89$MediaDataController();
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadHints$89, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHints$89$MediaDataController() {
        getUserConfig().suggestContacts = true;
        getUserConfig().lastHintsSyncTime = (int) (System.currentTimeMillis() / 1000);
        getUserConfig().saveConfig(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadHints$92, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadHints$92$MediaDataController() {
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
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$5dGIr5AZCtf5iR6afUb3J9nWEOA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearTopPeers$94$MediaDataController();
            }
        });
        buildShortcuts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearTopPeers$94, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearTopPeers$94$MediaDataController() {
        try {
            getMessagesStorage().getDatabase().executeFast("DELETE FROM chat_hints WHERE 1").stepThis().dispose();
        } catch (Exception unused) {
        }
    }

    public void increaseInlineRaiting(long uid) {
        if (getUserConfig().suggestContacts) {
            int iMax = getUserConfig().botRatingLoadTime != 0 ? Math.max(1, ((int) (System.currentTimeMillis() / 1000)) - getUserConfig().botRatingLoadTime) : 60;
            TLRPC$TL_topPeer tLRPC$TL_topPeer = null;
            int i = 0;
            while (true) {
                if (i >= this.inlineBots.size()) {
                    break;
                }
                TLRPC$TL_topPeer tLRPC$TL_topPeer2 = this.inlineBots.get(i);
                if (tLRPC$TL_topPeer2.peer.user_id == uid) {
                    tLRPC$TL_topPeer = tLRPC$TL_topPeer2;
                    break;
                }
                i++;
            }
            if (tLRPC$TL_topPeer == null) {
                tLRPC$TL_topPeer = new TLRPC$TL_topPeer();
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_topPeer.peer = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = uid;
                this.inlineBots.add(tLRPC$TL_topPeer);
            }
            tLRPC$TL_topPeer.rating += Math.exp(iMax / getMessagesController().ratingDecay);
            Collections.sort(this.inlineBots, $$Lambda$MediaDataController$TtSpxwRuUa0fgZ5gbxN5N94KB0.INSTANCE);
            if (this.inlineBots.size() > 20) {
                ArrayList<TLRPC$TL_topPeer> arrayList = this.inlineBots;
                arrayList.remove(arrayList.size() - 1);
            }
            savePeer(uid, 1, tLRPC$TL_topPeer.rating);
            getNotificationCenter().postNotificationName(NotificationCenter.reloadInlineHints, new Object[0]);
        }
    }

    static /* synthetic */ int lambda$increaseInlineRaiting$95(TLRPC$TL_topPeer tLRPC$TL_topPeer, TLRPC$TL_topPeer tLRPC$TL_topPeer2) {
        double d = tLRPC$TL_topPeer.rating;
        double d2 = tLRPC$TL_topPeer2.rating;
        if (d > d2) {
            return -1;
        }
        return d < d2 ? 1 : 0;
    }

    public void removeInline(long dialogId) {
        for (int i = 0; i < this.inlineBots.size(); i++) {
            if (this.inlineBots.get(i).peer.user_id == dialogId) {
                this.inlineBots.remove(i);
                TLRPC$TL_contacts_resetTopPeerRating tLRPC$TL_contacts_resetTopPeerRating = new TLRPC$TL_contacts_resetTopPeerRating();
                tLRPC$TL_contacts_resetTopPeerRating.category = new TLRPC$TL_topPeerCategoryBotsInline();
                tLRPC$TL_contacts_resetTopPeerRating.peer = getMessagesController().getInputPeer(dialogId);
                getConnectionsManager().sendRequest(tLRPC$TL_contacts_resetTopPeerRating, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$OI2Drwg6BM2CZroT1bcjQIN4LbQ
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        MediaDataController.lambda$removeInline$96(tLObject, tLRPC$TL_error);
                    }
                });
                deletePeer(dialogId, 1);
                getNotificationCenter().postNotificationName(NotificationCenter.reloadInlineHints, new Object[0]);
                return;
            }
        }
    }

    public void removePeer(long uid) {
        for (int i = 0; i < this.hints.size(); i++) {
            if (this.hints.get(i).peer.user_id == uid) {
                this.hints.remove(i);
                getNotificationCenter().postNotificationName(NotificationCenter.reloadHints, new Object[0]);
                TLRPC$TL_contacts_resetTopPeerRating tLRPC$TL_contacts_resetTopPeerRating = new TLRPC$TL_contacts_resetTopPeerRating();
                tLRPC$TL_contacts_resetTopPeerRating.category = new TLRPC$TL_topPeerCategoryCorrespondents();
                tLRPC$TL_contacts_resetTopPeerRating.peer = getMessagesController().getInputPeer(uid);
                deletePeer(uid, 0);
                getConnectionsManager().sendRequest(tLRPC$TL_contacts_resetTopPeerRating, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$C-vXOJoqmuAvcYxHuVlVRWorFgY
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        MediaDataController.lambda$removePeer$97(tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
        }
    }

    public void increasePeerRaiting(final long dialogId) {
        TLRPC$User user;
        if (!getUserConfig().suggestContacts || !DialogObject.isUserDialog(dialogId) || (user = getMessagesController().getUser(Long.valueOf(dialogId))) == null || user.bot || user.self) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$OCzkHIfqi5FfBau2oAcSX79IXlQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$increasePeerRaiting$100$MediaDataController(dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$increasePeerRaiting$100, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$increasePeerRaiting$100$MediaDataController(final long j) {
        int iIntValue;
        double d = 0.0d;
        try {
            int iIntValue2 = 0;
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT MAX(mid), MAX(date) FROM messages_v2 WHERE uid = %d AND out = 1", Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next()) {
                iIntValue2 = sQLiteCursorQueryFinalized.intValue(0);
                iIntValue = sQLiteCursorQueryFinalized.intValue(1);
            } else {
                iIntValue = 0;
            }
            sQLiteCursorQueryFinalized.dispose();
            if (iIntValue2 > 0 && getUserConfig().ratingLoadTime != 0) {
                d = iIntValue - getUserConfig().ratingLoadTime;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        final double d2 = d;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$4jLH-2g--xbmUr2ABNybSIHLrJ4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$increasePeerRaiting$99$MediaDataController(j, d2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$increasePeerRaiting$99, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$increasePeerRaiting$99$MediaDataController(long j, double d) {
        TLRPC$TL_topPeer tLRPC$TL_topPeer;
        int i = 0;
        while (true) {
            if (i >= this.hints.size()) {
                tLRPC$TL_topPeer = null;
                break;
            }
            tLRPC$TL_topPeer = this.hints.get(i);
            if (tLRPC$TL_topPeer.peer.user_id == j) {
                break;
            } else {
                i++;
            }
        }
        if (tLRPC$TL_topPeer == null) {
            tLRPC$TL_topPeer = new TLRPC$TL_topPeer();
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_topPeer.peer = tLRPC$TL_peerUser;
            tLRPC$TL_peerUser.user_id = j;
            this.hints.add(tLRPC$TL_topPeer);
        }
        double d2 = tLRPC$TL_topPeer.rating;
        double d3 = getMessagesController().ratingDecay;
        Double.isNaN(d3);
        tLRPC$TL_topPeer.rating = d2 + Math.exp(d / d3);
        Collections.sort(this.hints, $$Lambda$MediaDataController$nexFFsO9q7IfSusqNuCCWSyC0RY.INSTANCE);
        savePeer(j, 0, tLRPC$TL_topPeer.rating);
        getNotificationCenter().postNotificationName(NotificationCenter.reloadHints, new Object[0]);
    }

    static /* synthetic */ int lambda$increasePeerRaiting$98(TLRPC$TL_topPeer tLRPC$TL_topPeer, TLRPC$TL_topPeer tLRPC$TL_topPeer2) {
        double d = tLRPC$TL_topPeer.rating;
        double d2 = tLRPC$TL_topPeer2.rating;
        if (d > d2) {
            return -1;
        }
        return d < d2 ? 1 : 0;
    }

    private void savePeer(final long did, final int type, final double rating) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$zsj0HiPDzW92UfVjM8j3Z40ZUDk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$savePeer$101$MediaDataController(did, type, rating);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$savePeer$101, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$savePeer$101$MediaDataController(long j, int i, double d) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO chat_hints VALUES(?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, j);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i);
            sQLitePreparedStatementExecuteFast.bindDouble(3, d);
            sQLitePreparedStatementExecuteFast.bindInteger(4, ((int) System.currentTimeMillis()) / 1000);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void deletePeer(final long dialogId, final int type) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Xvom_dV1UCN4VN0zCSTiQqI_8eg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deletePeer$102$MediaDataController(dialogId, type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deletePeer$102, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deletePeer$102$MediaDataController(long j, int i) {
        try {
            getMessagesStorage().getDatabase().executeFast(String.format(Locale.US, "DELETE FROM chat_hints WHERE did = %d AND type = %d", Long.valueOf(j), Integer.valueOf(i))).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private Intent createIntrnalShortcutIntent(long dialogId) {
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) OpenChatReceiver.class);
        if (DialogObject.isEncryptedDialog(dialogId)) {
            int encryptedChatId = DialogObject.getEncryptedChatId(dialogId);
            intent.putExtra("encId", encryptedChatId);
            if (getMessagesController().getEncryptedChat(Integer.valueOf(encryptedChatId)) == null) {
                return null;
            }
        } else if (DialogObject.isUserDialog(dialogId)) {
            intent.putExtra("userId", dialogId);
        } else {
            if (!DialogObject.isChatDialog(dialogId)) {
                return null;
            }
            intent.putExtra("chatId", -dialogId);
        }
        intent.putExtra("currentAccount", this.currentAccount);
        intent.setAction("com.tmessages.openchat" + dialogId);
        intent.addFlags(ConnectionsManager.FileTypeFile);
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: Exception -> 0x024f, TryCatch #0 {Exception -> 0x024f, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x0020, B:21:0x0062, B:23:0x0068, B:66:0x0171, B:68:0x0183, B:70:0x01a5, B:82:0x01e4, B:72:0x01af, B:74:0x01b3, B:75:0x01bd, B:76:0x01c7, B:78:0x01cd, B:80:0x01d1, B:81:0x01db, B:83:0x01ee, B:85:0x01f5, B:99:0x0234, B:89:0x01ff, B:91:0x0203, B:92:0x020d, B:93:0x0217, B:95:0x021d, B:97:0x0221, B:98:0x022b, B:65:0x016e, B:25:0x0074, B:27:0x007a, B:28:0x0084, B:30:0x0090, B:31:0x0093, B:33:0x0099, B:9:0x002f, B:11:0x0035, B:13:0x0044, B:15:0x004a), top: B:106:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[Catch: Exception -> 0x024f, TryCatch #0 {Exception -> 0x024f, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x0020, B:21:0x0062, B:23:0x0068, B:66:0x0171, B:68:0x0183, B:70:0x01a5, B:82:0x01e4, B:72:0x01af, B:74:0x01b3, B:75:0x01bd, B:76:0x01c7, B:78:0x01cd, B:80:0x01d1, B:81:0x01db, B:83:0x01ee, B:85:0x01f5, B:99:0x0234, B:89:0x01ff, B:91:0x0203, B:92:0x020d, B:93:0x0217, B:95:0x021d, B:97:0x0221, B:98:0x022b, B:65:0x016e, B:25:0x0074, B:27:0x007a, B:28:0x0084, B:30:0x0090, B:31:0x0093, B:33:0x0099, B:9:0x002f, B:11:0x0035, B:13:0x0044, B:15:0x004a), top: B:106:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c A[PHI: r8
      0x009c: PHI (r8v1 java.lang.String) = (r8v0 java.lang.String), (r8v7 java.lang.String) binds: [B:32:0x0097, B:29:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d4 A[Catch: all -> 0x016d, TryCatch #3 {all -> 0x016d, blocks: (B:50:0x00c0, B:52:0x00d4, B:54:0x00df, B:56:0x00e8, B:61:0x013e, B:62:0x0168, B:55:0x00e5, B:57:0x00ef, B:59:0x00fa, B:60:0x0108), top: B:111:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ef A[Catch: all -> 0x016d, TryCatch #3 {all -> 0x016d, blocks: (B:50:0x00c0, B:52:0x00d4, B:54:0x00df, B:56:0x00e8, B:61:0x013e, B:62:0x0168, B:55:0x00e5, B:57:0x00ef, B:59:0x00fa, B:60:0x0108), top: B:111:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0183 A[Catch: Exception -> 0x024f, TryCatch #0 {Exception -> 0x024f, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x0020, B:21:0x0062, B:23:0x0068, B:66:0x0171, B:68:0x0183, B:70:0x01a5, B:82:0x01e4, B:72:0x01af, B:74:0x01b3, B:75:0x01bd, B:76:0x01c7, B:78:0x01cd, B:80:0x01d1, B:81:0x01db, B:83:0x01ee, B:85:0x01f5, B:99:0x0234, B:89:0x01ff, B:91:0x0203, B:92:0x020d, B:93:0x0217, B:95:0x021d, B:97:0x0221, B:98:0x022b, B:65:0x016e, B:25:0x0074, B:27:0x007a, B:28:0x0084, B:30:0x0090, B:31:0x0093, B:33:0x0099, B:9:0x002f, B:11:0x0035, B:13:0x0044, B:15:0x004a), top: B:106:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ee A[Catch: Exception -> 0x024f, TryCatch #0 {Exception -> 0x024f, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x0020, B:21:0x0062, B:23:0x0068, B:66:0x0171, B:68:0x0183, B:70:0x01a5, B:82:0x01e4, B:72:0x01af, B:74:0x01b3, B:75:0x01bd, B:76:0x01c7, B:78:0x01cd, B:80:0x01d1, B:81:0x01db, B:83:0x01ee, B:85:0x01f5, B:99:0x0234, B:89:0x01ff, B:91:0x0203, B:92:0x020d, B:93:0x0217, B:95:0x021d, B:97:0x0221, B:98:0x022b, B:65:0x016e, B:25:0x0074, B:27:0x007a, B:28:0x0084, B:30:0x0090, B:31:0x0093, B:33:0x0099, B:9:0x002f, B:11:0x0035, B:13:0x0044, B:15:0x004a), top: B:106:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void installShortcut(long r17) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.installShortcut(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a4 A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x003c, B:7:0x004b, B:9:0x0052, B:12:0x0065, B:24:0x00a4, B:26:0x00af, B:25:0x00ad, B:13:0x0074, B:15:0x007a, B:17:0x008a, B:19:0x0090), top: B:32:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x003c, B:7:0x004b, B:9:0x0052, B:12:0x0065, B:24:0x00a4, B:26:0x00af, B:25:0x00ad, B:13:0x0074, B:15:0x007a, B:17:0x008a, B:19:0x0090), top: B:32:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void uninstallShortcut(long r7) {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Ld4
            r1 = 26
            if (r0 < r1) goto L4b
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld4
            r1.<init>()     // Catch: java.lang.Exception -> Ld4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld4
            r2.<init>()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r3 = "sdid_"
            r2.append(r3)     // Catch: java.lang.Exception -> Ld4
            r2.append(r7)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Ld4
            r1.add(r2)     // Catch: java.lang.Exception -> Ld4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld4
            r2.<init>()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r3 = "ndid_"
            r2.append(r3)     // Catch: java.lang.Exception -> Ld4
            r2.append(r7)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Exception -> Ld4
            r1.add(r7)     // Catch: java.lang.Exception -> Ld4
            android.content.Context r7 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Ld4
            androidx.core.content.pm.ShortcutManagerCompat.removeDynamicShortcuts(r7, r1)     // Catch: java.lang.Exception -> Ld4
            r7 = 30
            if (r0 < r7) goto Ld8
            android.content.Context r7 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Ld4
            java.lang.Class<android.content.pm.ShortcutManager> r8 = android.content.pm.ShortcutManager.class
            java.lang.Object r7 = r7.getSystemService(r8)     // Catch: java.lang.Exception -> Ld4
            android.content.pm.ShortcutManager r7 = (android.content.pm.ShortcutManager) r7     // Catch: java.lang.Exception -> Ld4
            r7.removeLongLivedShortcuts(r1)     // Catch: java.lang.Exception -> Ld4
            goto Ld8
        L4b:
            boolean r0 = ir.eitaa.messenger.DialogObject.isEncryptedDialog(r7)     // Catch: java.lang.Exception -> Ld4
            r1 = 0
            if (r0 == 0) goto L74
            int r0 = ir.eitaa.messenger.DialogObject.getEncryptedChatId(r7)     // Catch: java.lang.Exception -> Ld4
            ir.eitaa.messenger.MessagesController r2 = r6.getMessagesController()     // Catch: java.lang.Exception -> Ld4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> Ld4
            ir.eitaa.tgnet.TLRPC$EncryptedChat r0 = r2.getEncryptedChat(r0)     // Catch: java.lang.Exception -> Ld4
            if (r0 != 0) goto L65
            return
        L65:
            ir.eitaa.messenger.MessagesController r2 = r6.getMessagesController()     // Catch: java.lang.Exception -> Ld4
            long r3 = r0.user_id     // Catch: java.lang.Exception -> Ld4
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Exception -> Ld4
            ir.eitaa.tgnet.TLRPC$User r0 = r2.getUser(r0)     // Catch: java.lang.Exception -> Ld4
            goto L86
        L74:
            boolean r0 = ir.eitaa.messenger.DialogObject.isUserDialog(r7)     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto L8a
            ir.eitaa.messenger.MessagesController r0 = r6.getMessagesController()     // Catch: java.lang.Exception -> Ld4
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Exception -> Ld4
            ir.eitaa.tgnet.TLRPC$User r0 = r0.getUser(r2)     // Catch: java.lang.Exception -> Ld4
        L86:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L9d
        L8a:
            boolean r0 = ir.eitaa.messenger.DialogObject.isChatDialog(r7)     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto Ld3
            ir.eitaa.messenger.MessagesController r0 = r6.getMessagesController()     // Catch: java.lang.Exception -> Ld4
            long r2 = -r7
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> Ld4
            ir.eitaa.tgnet.TLRPC$Chat r0 = r0.getChat(r2)     // Catch: java.lang.Exception -> Ld4
        L9d:
            if (r1 != 0) goto La2
            if (r0 != 0) goto La2
            return
        La2:
            if (r1 == 0) goto Lad
            java.lang.String r0 = r1.first_name     // Catch: java.lang.Exception -> Ld4
            java.lang.String r1 = r1.last_name     // Catch: java.lang.Exception -> Ld4
            java.lang.String r0 = ir.eitaa.messenger.ContactsController.formatName(r0, r1)     // Catch: java.lang.Exception -> Ld4
            goto Laf
        Lad:
            java.lang.String r0 = r0.title     // Catch: java.lang.Exception -> Ld4
        Laf:
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> Ld4
            r1.<init>()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r2 = "android.intent.extra.shortcut.INTENT"
            android.content.Intent r7 = r6.createIntrnalShortcutIntent(r7)     // Catch: java.lang.Exception -> Ld4
            r1.putExtra(r2, r7)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r7 = "android.intent.extra.shortcut.NAME"
            r1.putExtra(r7, r0)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r7 = "duplicate"
            r8 = 0
            r1.putExtra(r7, r8)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r7 = "com.android.launcher.action.UNINSTALL_SHORTCUT"
            r1.setAction(r7)     // Catch: java.lang.Exception -> Ld4
            android.content.Context r7 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Ld4
            r7.sendBroadcast(r1)     // Catch: java.lang.Exception -> Ld4
            goto Ld8
        Ld3:
            return
        Ld4:
            r7 = move-exception
            ir.eitaa.messenger.FileLog.e(r7)
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.uninstallShortcut(long):void");
    }

    static /* synthetic */ int lambda$static$103(TLRPC$MessageEntity tLRPC$MessageEntity, TLRPC$MessageEntity tLRPC$MessageEntity2) {
        int i = tLRPC$MessageEntity.offset;
        int i2 = tLRPC$MessageEntity2.offset;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    /* renamed from: ir.eitaa.messenger.MediaDataController$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$channelId;
        final /* synthetic */ int val$chatId;
        final /* synthetic */ boolean val$fromCache;
        final /* synthetic */ int val$mid;

        AnonymousClass2(final int val$mid, final boolean val$fromCache, final int val$channelId, final int val$chatId) {
            this.val$mid = val$mid;
            this.val$fromCache = val$fromCache;
            this.val$channelId = val$channelId;
            this.val$chatId = val$chatId;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeByteBuffer nativeByteBufferByteBufferValue;
            try {
                long j = this.val$mid;
                final ArrayList<TLRPC$User> arrayList = new ArrayList<>();
                final ArrayList<TLRPC$Chat> arrayList2 = new ArrayList<>();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                TLRPC$Message tLRPC$Message = null;
                if (this.val$fromCache) {
                    SQLiteCursor sQLiteCursorQueryFinalized = MessagesStorage.getInstance(MediaDataController.this.currentAccount).getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid, date FROM messages_v2 WHERE mid = %d AND uid = %d", Long.valueOf(j), Integer.valueOf(-this.val$channelId)), new Object[0]);
                    if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, UserConfig.getInstance(MediaDataController.this.currentAccount).clientUserId);
                        nativeByteBufferByteBufferValue.reuse();
                        if (!(tLRPC$MessageTLdeserialize.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                            tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(1);
                            tLRPC$MessageTLdeserialize.date = sQLiteCursorQueryFinalized.intValue(2);
                            tLRPC$MessageTLdeserialize.dialog_id = -this.val$channelId;
                            MessagesStorage.addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList3, arrayList4);
                            tLRPC$Message = tLRPC$MessageTLdeserialize;
                        }
                    }
                    sQLiteCursorQueryFinalized.dispose();
                }
                final TLRPC$Message tLRPC$Message2 = tLRPC$Message;
                if (tLRPC$Message2 == null) {
                    if (this.val$channelId != 0) {
                        TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                        tLRPC$TL_channels_getMessages.channel = MessagesController.getInstance(MediaDataController.this.currentAccount).getInputChannel(this.val$channelId);
                        tLRPC$TL_channels_getMessages.id.add(Integer.valueOf(this.val$mid));
                        ConnectionsManager.getInstance(MediaDataController.this.currentAccount).sendRequest(tLRPC$TL_channels_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.MediaDataController.2.1
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public void run(TLObject response, TLRPC$TL_error error) {
                                if (error == null) {
                                    TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) response;
                                    MediaDataController.removeEmptyMessages(tLRPC$messages_Messages.messages);
                                    if (!tLRPC$messages_Messages.messages.isEmpty()) {
                                        ImageLoader.saveMessagesThumbs(tLRPC$messages_Messages.messages);
                                        final TLRPC$Message tLRPC$Message3 = tLRPC$messages_Messages.messages.get(0);
                                        final ArrayList<TLRPC$User> arrayList5 = tLRPC$messages_Messages.users;
                                        final ArrayList<TLRPC$Chat> arrayList6 = tLRPC$messages_Messages.chats;
                                        final LongSparseArray longSparseArray = new LongSparseArray();
                                        for (int i = 0; i < arrayList5.size(); i++) {
                                            longSparseArray.put((int) r1.id, arrayList5.get(i));
                                        }
                                        final LongSparseArray longSparseArray2 = new LongSparseArray();
                                        for (int i2 = 0; i2 < arrayList6.size(); i2++) {
                                            longSparseArray2.put((int) r11.id, arrayList6.get(i2));
                                        }
                                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MediaDataController.2.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                MessagesController.getInstance(MediaDataController.this.currentAccount).putUsers(arrayList5, false);
                                                MessagesController.getInstance(MediaDataController.this.currentAccount).putChats(arrayList6, false);
                                                NotificationCenter.getInstance(MediaDataController.this.currentAccount).postNotificationName(NotificationCenter.didLoadedMessage, Integer.valueOf(AnonymousClass2.this.val$channelId), Integer.valueOf(AnonymousClass2.this.val$mid), new MessageObject(MediaDataController.this.currentAccount, tLRPC$Message3, (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, false, true));
                                            }
                                        });
                                        MessagesStorage.getInstance(MediaDataController.this.currentAccount).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
                                        return;
                                    }
                                }
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MediaDataController.2.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NotificationCenter.getInstance(MediaDataController.this.currentAccount).postNotificationName(NotificationCenter.didLoadedMessage, Integer.valueOf(AnonymousClass2.this.val$channelId), Integer.valueOf(AnonymousClass2.this.val$mid), null);
                                    }
                                });
                            }
                        });
                        return;
                    }
                    TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages = new TLRPC$TL_messages_getMessages();
                    tLRPC$TL_messages_getMessages.id.add(Integer.valueOf((int) j));
                    ConnectionsManager.getInstance(MediaDataController.this.currentAccount).sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.MediaDataController.2.2
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public void run(TLObject response, TLRPC$TL_error error) {
                            if (error == null) {
                                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) response;
                                MediaDataController.removeEmptyMessages(tLRPC$messages_Messages.messages);
                                if (!tLRPC$messages_Messages.messages.isEmpty()) {
                                    ImageLoader.saveMessagesThumbs(tLRPC$messages_Messages.messages);
                                    final TLRPC$Message tLRPC$Message3 = tLRPC$messages_Messages.messages.get(0);
                                    final ArrayList<TLRPC$User> arrayList5 = tLRPC$messages_Messages.users;
                                    final ArrayList<TLRPC$Chat> arrayList6 = tLRPC$messages_Messages.chats;
                                    final LongSparseArray longSparseArray = new LongSparseArray();
                                    for (int i = 0; i < arrayList5.size(); i++) {
                                        longSparseArray.put((int) r1.id, arrayList5.get(i));
                                    }
                                    final LongSparseArray longSparseArray2 = new LongSparseArray();
                                    for (int i2 = 0; i2 < arrayList6.size(); i2++) {
                                        longSparseArray2.put((int) r11.id, arrayList6.get(i2));
                                    }
                                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MediaDataController.2.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            MessagesController.getInstance(MediaDataController.this.currentAccount).putUsers(arrayList5, false);
                                            MessagesController.getInstance(MediaDataController.this.currentAccount).putChats(arrayList6, false);
                                            NotificationCenter.getInstance(MediaDataController.this.currentAccount).postNotificationName(NotificationCenter.didLoadedMessage, Integer.valueOf(AnonymousClass2.this.val$chatId), Integer.valueOf(AnonymousClass2.this.val$mid), new MessageObject(MediaDataController.this.currentAccount, tLRPC$Message3, (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, false, true));
                                        }
                                    });
                                    MessagesStorage.getInstance(MediaDataController.this.currentAccount).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
                                    return;
                                }
                            }
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MediaDataController.2.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    NotificationCenter.getInstance(MediaDataController.this.currentAccount).postNotificationName(NotificationCenter.didLoadedMessage, Integer.valueOf(AnonymousClass2.this.val$channelId), Integer.valueOf(AnonymousClass2.this.val$mid), null);
                                }
                            });
                        }
                    });
                    return;
                }
                if (!arrayList3.isEmpty()) {
                    MessagesStorage.getInstance(MediaDataController.this.currentAccount).getUsersInternal(TextUtils.join(",", arrayList3), arrayList);
                }
                if (!arrayList4.isEmpty()) {
                    MessagesStorage.getInstance(MediaDataController.this.currentAccount).getChatsInternal(TextUtils.join(",", arrayList4), arrayList2);
                }
                final LongSparseArray longSparseArray = new LongSparseArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    longSparseArray.put((int) r1.id, arrayList.get(i));
                }
                final LongSparseArray longSparseArray2 = new LongSparseArray();
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    longSparseArray2.put((int) r1.id, arrayList2.get(i2));
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MediaDataController.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        MessagesController.getInstance(MediaDataController.this.currentAccount).putUsers(arrayList, true);
                        MessagesController.getInstance(MediaDataController.this.currentAccount).putChats(arrayList2, true);
                        NotificationCenter notificationCenter = NotificationCenter.getInstance(MediaDataController.this.currentAccount);
                        int i3 = NotificationCenter.didLoadedMessage;
                        Object[] objArr = new Object[3];
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        int i4 = anonymousClass2.val$channelId;
                        if (i4 == 0) {
                            i4 = anonymousClass2.val$chatId;
                        }
                        objArr[0] = Integer.valueOf(i4);
                        objArr[1] = Integer.valueOf(AnonymousClass2.this.val$mid);
                        objArr[2] = new MessageObject(MediaDataController.this.currentAccount, tLRPC$Message2, (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, false, true);
                        notificationCenter.postNotificationName(i3, objArr);
                    }
                });
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public void loadMessage(final int channelId, final int chatId, final int mid, boolean fromCache) {
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new AnonymousClass2(mid, fromCache, channelId, chatId));
    }

    public void loadPinnedMessages(final long dialogId, final int maxId, final int fallback) {
        if (this.loadingPinnedMessages.indexOfKey(dialogId) >= 0) {
            return;
        }
        this.loadingPinnedMessages.put(dialogId, Boolean.TRUE);
        final TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
        tLRPC$TL_messages_search.peer = getMessagesController().getInputPeer(dialogId);
        tLRPC$TL_messages_search.limit = 40;
        tLRPC$TL_messages_search.offset_id = maxId;
        tLRPC$TL_messages_search.q = "";
        tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterPinned();
        getConnectionsManager().sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$WIm2r8qSv33ucaATGr9V1s3Ojf8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPinnedMessages$105$MediaDataController(fallback, tLRPC$TL_messages_search, dialogId, maxId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPinnedMessages$105, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPinnedMessages$105$MediaDataController(int i, TLRPC$TL_messages_search tLRPC$TL_messages_search, final long j, int i2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        int i3;
        int iMax;
        boolean z;
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, MessageObject> map = new HashMap<>();
        if (tLObject instanceof TLRPC$messages_Messages) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            LongSparseArray longSparseArray = new LongSparseArray();
            for (int i4 = 0; i4 < tLRPC$messages_Messages.users.size(); i4++) {
                TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i4);
                longSparseArray.put(tLRPC$User.id, tLRPC$User);
            }
            LongSparseArray longSparseArray2 = new LongSparseArray();
            for (int i5 = 0; i5 < tLRPC$messages_Messages.chats.size(); i5++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$messages_Messages.chats.get(i5);
                longSparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
            }
            getMessagesStorage().putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
            getMessagesController().putUsers(tLRPC$messages_Messages.users, false);
            getMessagesController().putChats(tLRPC$messages_Messages.chats, false);
            int size = tLRPC$messages_Messages.messages.size();
            for (int i6 = 0; i6 < size; i6++) {
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i6);
                if (!(tLRPC$Message instanceof TLRPC$TL_messageService) && !(tLRPC$Message instanceof TLRPC$TL_messageEmpty)) {
                    arrayList.add(Integer.valueOf(tLRPC$Message.id));
                    map.put(Integer.valueOf(tLRPC$Message.id), new MessageObject(this.currentAccount, tLRPC$Message, (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, false, false));
                }
            }
            if (i != 0 && arrayList.isEmpty()) {
                arrayList.add(Integer.valueOf(i));
            }
            boolean z2 = tLRPC$messages_Messages.messages.size() < tLRPC$TL_messages_search.limit;
            iMax = Math.max(tLRPC$messages_Messages.count, tLRPC$messages_Messages.messages.size());
            z = z2;
        } else {
            if (i != 0) {
                arrayList.add(Integer.valueOf(i));
                i3 = 1;
            } else {
                i3 = 0;
            }
            iMax = i3;
            z = false;
        }
        getMessagesStorage().updatePinnedMessages(j, arrayList, true, iMax, i2, z, map);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$s2qrJKm4CW0cOY5HDu9IlBJXSlg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPinnedMessages$104$MediaDataController(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPinnedMessages$104, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPinnedMessages$104$MediaDataController(long j) {
        this.loadingPinnedMessages.remove(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPinnedMessages$106, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPinnedMessages$106$MediaDataController(long j, long j2, ArrayList arrayList) {
        loadPinnedMessageInternal(j, j2, arrayList, false);
    }

    public ArrayList<MessageObject> loadPinnedMessages(final long dialogId, final long channelId, final ArrayList<Integer> mids, boolean useQueue) {
        if (useQueue) {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$xUZnLBfwJQSgFbgNID774busNII
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadPinnedMessages$106$MediaDataController(dialogId, channelId, mids);
                }
            });
            return null;
        }
        return loadPinnedMessageInternal(dialogId, channelId, mids, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v10, types: [ir.eitaa.tgnet.TLRPC$Message, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r17v0, types: [ir.eitaa.messenger.BaseController, ir.eitaa.messenger.MediaDataController] */
    /* JADX WARN: Type inference failed for: r2v2, types: [ir.eitaa.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v14, types: [ir.eitaa.tgnet.AbstractSerializedData, ir.eitaa.tgnet.NativeByteBuffer] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    private ArrayList<MessageObject> loadPinnedMessageInternal(final long dialogId, final long channelId, ArrayList<Integer> mids, boolean returnValue) {
        ?? Join;
        ArrayList<TLRPC$User> arrayList;
        ArrayList<TLRPC$Chat> arrayList2;
        try {
            ArrayList<Integer> arrayList3 = new ArrayList<>(mids);
            if (channelId != 0) {
                Join = new StringBuilder();
                int size = mids.size();
                for (int i = 0; i < size; i++) {
                    Integer num = mids.get(i);
                    if (Join.length() != 0) {
                        Join.append(",");
                    }
                    Join.append(num);
                }
            } else {
                Join = TextUtils.join(",", mids);
            }
            ArrayList arrayList4 = new ArrayList();
            ArrayList<TLRPC$User> arrayList5 = new ArrayList<>();
            ArrayList<TLRPC$Chat> arrayList6 = new ArrayList<>();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            long j = getUserConfig().clientUserId;
            ?? r4 = 0;
            ?? QueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data, mid, date FROM messages_v2 WHERE mid IN (%s) AND uid = %d", new Object[]{Join, Long.valueOf(dialogId)}), new Object[0]);
            while (QueryFinalized.next()) {
                ?? ByteBufferValue = QueryFinalized.byteBufferValue(r4);
                if (ByteBufferValue != 0) {
                    ?? TLdeserialize = TLRPC$Message.TLdeserialize(ByteBufferValue, ByteBufferValue.readInt32(r4), r4);
                    if (!(TLdeserialize.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                        TLdeserialize.readAttachPath(ByteBufferValue, j);
                        TLdeserialize.id = QueryFinalized.intValue(1);
                        TLdeserialize.date = QueryFinalized.intValue(2);
                        TLdeserialize.dialog_id = dialogId;
                        MessagesStorage.addUsersAndChatsFromMessage(TLdeserialize, arrayList7, arrayList8);
                        arrayList4.add(TLdeserialize);
                        arrayList3.remove(Integer.valueOf(TLdeserialize.id));
                    }
                    ByteBufferValue.reuse();
                }
                r4 = 0;
            }
            QueryFinalized.dispose();
            if (!arrayList3.isEmpty()) {
                SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data FROM chat_pinned_v2 WHERE uid = %d AND mid IN (%s)", Long.valueOf(dialogId), TextUtils.join(",", arrayList3)), new Object[0]);
                while (sQLiteCursorQueryFinalized.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue != null) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        if (!(tLRPC$MessageTLdeserialize.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                            tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, j);
                            tLRPC$MessageTLdeserialize.dialog_id = dialogId;
                            MessagesStorage.addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList7, arrayList8);
                            arrayList4.add(tLRPC$MessageTLdeserialize);
                            arrayList3.remove(Integer.valueOf(tLRPC$MessageTLdeserialize.id));
                        }
                        nativeByteBufferByteBufferValue.reuse();
                    }
                }
                sQLiteCursorQueryFinalized.dispose();
            }
            if (!arrayList3.isEmpty()) {
                if (channelId != 0) {
                    final TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                    tLRPC$TL_channels_getMessages.channel = getMessagesController().getInputChannel(channelId);
                    tLRPC$TL_channels_getMessages.id = arrayList3;
                    getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$Omfn9s0KjyONAtUAishGXfORELw
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$loadPinnedMessageInternal$107$MediaDataController(channelId, dialogId, tLRPC$TL_channels_getMessages, tLObject, tLRPC$TL_error);
                        }
                    });
                } else {
                    final TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages = new TLRPC$TL_messages_getMessages();
                    tLRPC$TL_messages_getMessages.id = arrayList3;
                    try {
                        getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$SaekjO6_AA7JwzhwhYAK72i9Aqc
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$loadPinnedMessageInternal$108$MediaDataController(dialogId, tLRPC$TL_messages_getMessages, tLObject, tLRPC$TL_error);
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
            if (arrayList7.isEmpty()) {
                arrayList = arrayList5;
            } else {
                arrayList = arrayList5;
                getMessagesStorage().getUsersInternal(TextUtils.join(",", arrayList7), arrayList);
            }
            if (arrayList8.isEmpty()) {
                arrayList2 = arrayList6;
            } else {
                arrayList2 = arrayList6;
                getMessagesStorage().getChatsInternal(TextUtils.join(",", arrayList8), arrayList2);
            }
            if (returnValue) {
                return broadcastPinnedMessage(arrayList4, arrayList, arrayList2, true, true);
            }
            broadcastPinnedMessage(arrayList4, arrayList, arrayList2, true, false);
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0043  */
    /* renamed from: lambda$loadPinnedMessageInternal$107, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadPinnedMessageInternal$107$MediaDataController(long r13, long r15, ir.eitaa.tgnet.TLRPC$TL_channels_getMessages r17, ir.eitaa.tgnet.TLObject r18, ir.eitaa.tgnet.TLRPC$TL_error r19) {
        /*
            r12 = this;
            r0 = 1
            if (r19 != 0) goto L43
            r1 = r18
            ir.eitaa.tgnet.TLRPC$messages_Messages r1 = (ir.eitaa.tgnet.TLRPC$messages_Messages) r1
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r1.messages
            removeEmptyMessages(r2)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r1.messages
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L43
            ir.eitaa.messenger.MessagesController r2 = r12.getMessagesController()
            java.lang.Long r3 = java.lang.Long.valueOf(r13)
            r2.getChat(r3)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r1.messages
            ir.eitaa.messenger.ImageLoader.saveMessagesThumbs(r2)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r4 = r1.messages
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$User> r5 = r1.users
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r6 = r1.chats
            r7 = 0
            r8 = 0
            r3 = r12
            r3.broadcastPinnedMessage(r4, r5, r6, r7, r8)
            ir.eitaa.messenger.MessagesStorage r2 = r12.getMessagesStorage()
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$User> r3 = r1.users
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r4 = r1.chats
            r2.putUsersAndChats(r3, r4, r0, r0)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r1 = r1.messages
            r2 = r12
            r4 = r15
            r12.savePinnedMessages(r4, r1)
            goto L46
        L43:
            r2 = r12
            r4 = r15
            r0 = 0
        L46:
            if (r0 != 0) goto L59
            ir.eitaa.messenger.MessagesStorage r3 = r12.getMessagesStorage()
            r0 = r17
            java.util.ArrayList<java.lang.Integer> r6 = r0.id
            r7 = 0
            r8 = -1
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r15
            r3.updatePinnedMessages(r4, r6, r7, r8, r9, r10, r11)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.lambda$loadPinnedMessageInternal$107$MediaDataController(long, long, ir.eitaa.tgnet.TLRPC$TL_channels_getMessages, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    /* renamed from: lambda$loadPinnedMessageInternal$108, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadPinnedMessageInternal$108$MediaDataController(long r11, ir.eitaa.tgnet.TLRPC$TL_messages_getMessages r13, ir.eitaa.tgnet.TLObject r14, ir.eitaa.tgnet.TLRPC$TL_error r15) {
        /*
            r10 = this;
            r0 = 1
            if (r15 != 0) goto L34
            ir.eitaa.tgnet.TLRPC$messages_Messages r14 = (ir.eitaa.tgnet.TLRPC$messages_Messages) r14
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r15 = r14.messages
            removeEmptyMessages(r15)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r15 = r14.messages
            boolean r15 = r15.isEmpty()
            if (r15 != 0) goto L34
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r15 = r14.messages
            ir.eitaa.messenger.ImageLoader.saveMessagesThumbs(r15)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r2 = r14.messages
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$User> r3 = r14.users
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r4 = r14.chats
            r5 = 0
            r6 = 0
            r1 = r10
            r1.broadcastPinnedMessage(r2, r3, r4, r5, r6)
            ir.eitaa.messenger.MessagesStorage r15 = r10.getMessagesStorage()
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$User> r1 = r14.users
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r2 = r14.chats
            r15.putUsersAndChats(r1, r2, r0, r0)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r14 = r14.messages
            r10.savePinnedMessages(r11, r14)
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 != 0) goto L46
            ir.eitaa.messenger.MessagesStorage r1 = r10.getMessagesStorage()
            java.util.ArrayList<java.lang.Integer> r4 = r13.id
            r5 = 0
            r6 = -1
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            r1.updatePinnedMessages(r2, r4, r5, r6, r7, r8, r9)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.lambda$loadPinnedMessageInternal$108$MediaDataController(long, ir.eitaa.tgnet.TLRPC$TL_messages_getMessages, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    private void savePinnedMessages(final long dialogId, final ArrayList<TLRPC$Message> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$8Opf9cL5F-gx_TBD3Kz0VQ5O5pM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$savePinnedMessages$109$MediaDataController(arrayList, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$savePinnedMessages$109, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$savePinnedMessages$109$MediaDataController(ArrayList arrayList, long j) {
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
                sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$Message.id);
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

    private ArrayList<MessageObject> broadcastPinnedMessage(final ArrayList<TLRPC$Message> results, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final boolean isCache, boolean returnValue) {
        if (results.isEmpty()) {
            return null;
        }
        final LongSparseArray longSparseArray = new LongSparseArray();
        for (int i = 0; i < users.size(); i++) {
            TLRPC$User tLRPC$User = users.get(i);
            longSparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        final LongSparseArray longSparseArray2 = new LongSparseArray();
        for (int i2 = 0; i2 < chats.size(); i2++) {
            TLRPC$Chat tLRPC$Chat = chats.get(i2);
            longSparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
        }
        final ArrayList<MessageObject> arrayList = new ArrayList<>();
        if (returnValue) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$duyvBr-t_smpYkFaKYOcmB5aqTs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$broadcastPinnedMessage$110$MediaDataController(users, isCache, chats);
                }
            });
            int size = results.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                TLRPC$Message tLRPC$Message = results.get(i4);
                TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
                if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto)) {
                    i3++;
                }
                int i5 = i3;
                arrayList.add(new MessageObject(this.currentAccount, tLRPC$Message, (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, false, i5 < 30));
                i4++;
                i3 = i5;
            }
            return arrayList;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$RdbbBz_-okEda2tgUJvKyLo1j6s
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$broadcastPinnedMessage$112$MediaDataController(users, isCache, chats, results, arrayList, longSparseArray, longSparseArray2);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$broadcastPinnedMessage$110, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$broadcastPinnedMessage$110$MediaDataController(ArrayList arrayList, boolean z, ArrayList arrayList2) {
        getMessagesController().putUsers(arrayList, z);
        getMessagesController().putChats(arrayList2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$broadcastPinnedMessage$112, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$broadcastPinnedMessage$112$MediaDataController(ArrayList arrayList, boolean z, ArrayList arrayList2, ArrayList arrayList3, final ArrayList arrayList4, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
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
            arrayList4.add(new MessageObject(this.currentAccount, tLRPC$Message, (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, false, i < 30));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$MI4dk5Ws0zdrO6Rn-iDC3CItVqo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$broadcastPinnedMessage$111$MediaDataController(arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$broadcastPinnedMessage$111, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$broadcastPinnedMessage$111$MediaDataController(ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.didLoadPinnedMessages, Long.valueOf(((MessageObject) arrayList.get(0)).getDialogId()), null, Boolean.TRUE, arrayList, null, 0, -1, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeEmptyMessages(ArrayList<TLRPC$Message> messages) {
        int i = 0;
        while (i < messages.size()) {
            TLRPC$Message tLRPC$Message = messages.get(i);
            if (tLRPC$Message == null || (tLRPC$Message instanceof TLRPC$TL_messageEmpty) || (tLRPC$Message.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                messages.remove(i);
                i--;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c1 A[PHI: r12
      0x00c1: PHI (r12v1 long) = (r12v0 long), (r12v3 long) binds: [B:43:0x00bf, B:40:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadReplyMessagesForMessages(java.util.ArrayList<ir.eitaa.messenger.MessageObject> r15, final long r16, final boolean r18, final java.lang.Runnable r19) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.loadReplyMessagesForMessages(java.util.ArrayList, long, boolean, java.lang.Runnable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadReplyMessagesForMessages$114, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadReplyMessagesForMessages$114$MediaDataController(ArrayList arrayList, final long j, LongSparseArray longSparseArray, Runnable runnable) {
        try {
            final ArrayList arrayList2 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT m.data, m.mid, m.date, r.random_id FROM randoms_v2 as r INNER JOIN messages_v2 as m ON r.mid = m.mid AND r.uid = m.uid WHERE r.random_id IN(%s)", TextUtils.join(",", arrayList)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(1);
                    tLRPC$MessageTLdeserialize.date = sQLiteCursorQueryFinalized.intValue(2);
                    tLRPC$MessageTLdeserialize.dialog_id = j;
                    long jLongValue = sQLiteCursorQueryFinalized.longValue(3);
                    ArrayList arrayList3 = (ArrayList) longSparseArray.get(jLongValue);
                    longSparseArray.remove(jLongValue);
                    if (arrayList3 != null) {
                        MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$MessageTLdeserialize, false, false);
                        arrayList2.add(messageObject);
                        for (int i = 0; i < arrayList3.size(); i++) {
                            MessageObject messageObject2 = (MessageObject) arrayList3.get(i);
                            messageObject2.replyMessageObject = messageObject;
                            messageObject2.messageOwner.reply_to = new TLRPC$TL_messageReplyHeader();
                            messageObject2.messageOwner.reply_to.reply_to_msg_id = messageObject.getId();
                        }
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (longSparseArray.size() != 0) {
                for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                    ArrayList arrayList4 = (ArrayList) longSparseArray.valueAt(i2);
                    for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = ((MessageObject) arrayList4.get(i3)).messageOwner.reply_to;
                        if (tLRPC$TL_messageReplyHeader != null) {
                            tLRPC$TL_messageReplyHeader.reply_to_random_id = 0L;
                        }
                    }
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$HCNC5zas5fcQOT5JOhDvsuFuOgw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadReplyMessagesForMessages$113$MediaDataController(j, arrayList2);
                }
            });
            if (runnable != null) {
                runnable.run();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadReplyMessagesForMessages$113, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadReplyMessagesForMessages$113$MediaDataController(long j, ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.replyMessagesDidLoad, Long.valueOf(j), arrayList, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* renamed from: lambda$loadReplyMessagesForMessages$117, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadReplyMessagesForMessages$117$MediaDataController(final LongSparseArray longSparseArray, LongSparseArray longSparseArray2, final long j, final boolean z, final Runnable runnable) {
        int i;
        try {
            ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
            ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
            ArrayList<TLRPC$Chat> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            int size = longSparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                long jKeyAt = longSparseArray.keyAt(i2);
                ArrayList arrayList6 = (ArrayList) longSparseArray2.get(jKeyAt);
                if (arrayList6 != null) {
                    SQLiteDatabase database = getMessagesStorage().getDatabase();
                    Locale locale = Locale.US;
                    String strJoin = TextUtils.join(",", arrayList6);
                    ?? r13 = 0;
                    int i3 = 1;
                    SQLiteCursor sQLiteCursorQueryFinalized = database.queryFinalized(String.format(locale, "SELECT data, mid, date, uid FROM messages_v2 WHERE mid IN(%s) AND uid = %d", strJoin, Long.valueOf(j)), new Object[0]);
                    while (sQLiteCursorQueryFinalized.next()) {
                        NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(r13);
                        if (nativeByteBufferByteBufferValue != 0) {
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(r13), r13);
                            tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                            nativeByteBufferByteBufferValue.reuse();
                            tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(i3);
                            tLRPC$MessageTLdeserialize.date = sQLiteCursorQueryFinalized.intValue(2);
                            tLRPC$MessageTLdeserialize.dialog_id = j;
                            MessagesStorage.addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList4, arrayList5);
                            arrayList.add(tLRPC$MessageTLdeserialize);
                            TLRPC$Peer tLRPC$Peer = tLRPC$MessageTLdeserialize.peer_id;
                            long j2 = tLRPC$Peer != null ? tLRPC$Peer.channel_id : 0L;
                            ArrayList arrayList7 = (ArrayList) longSparseArray2.get(j2);
                            if (arrayList7 != null) {
                                arrayList7.remove(Integer.valueOf(tLRPC$MessageTLdeserialize.id));
                                if (arrayList7.isEmpty()) {
                                    longSparseArray2.remove(j2);
                                }
                            }
                        }
                        i3 = 1;
                        r13 = 0;
                    }
                    sQLiteCursorQueryFinalized.dispose();
                }
            }
            if (!arrayList4.isEmpty()) {
                getMessagesStorage().getUsersInternal(TextUtils.join(",", arrayList4), arrayList2);
            }
            if (!arrayList5.isEmpty()) {
                getMessagesStorage().getChatsInternal(TextUtils.join(",", arrayList5), arrayList3);
            }
            broadcastReplyMessages(arrayList, longSparseArray, arrayList2, arrayList3, j, true);
            if (longSparseArray2.isEmpty()) {
                if (runnable != null) {
                    AndroidUtilities.runOnUIThread(runnable);
                    return;
                }
                return;
            }
            int size2 = longSparseArray2.size();
            int i4 = 0;
            while (i4 < size2) {
                final long jKeyAt2 = longSparseArray2.keyAt(i4);
                if (jKeyAt2 != 0) {
                    TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                    tLRPC$TL_channels_getMessages.channel = getMessagesController().getInputChannel(jKeyAt2);
                    tLRPC$TL_channels_getMessages.id = (ArrayList) longSparseArray2.valueAt(i4);
                    i = size2;
                    getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$HrGqvOlkgF2wEK4Ya2fm3vO_fds
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$loadReplyMessagesForMessages$115$MediaDataController(j, jKeyAt2, longSparseArray, z, runnable, tLObject, tLRPC$TL_error);
                        }
                    });
                } else {
                    i = size2;
                    TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages = new TLRPC$TL_messages_getMessages();
                    tLRPC$TL_messages_getMessages.id = (ArrayList) longSparseArray2.valueAt(i4);
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$I1rM3JpsLdoZvr8YrWsUtg3tgTc
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$loadReplyMessagesForMessages$116$MediaDataController(j, longSparseArray, z, runnable, tLObject, tLRPC$TL_error);
                        }
                    });
                }
                i4++;
                size2 = i;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadReplyMessagesForMessages$115, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadReplyMessagesForMessages$115$MediaDataController(long j, long j2, LongSparseArray longSparseArray, boolean z, Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            for (int i = 0; i < tLRPC$messages_Messages.messages.size(); i++) {
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i);
                if (tLRPC$Message.dialog_id == 0) {
                    tLRPC$Message.dialog_id = j;
                }
            }
            MessageObject.fixMessagePeer(tLRPC$messages_Messages.messages, j2);
            ImageLoader.saveMessagesThumbs(tLRPC$messages_Messages.messages);
            broadcastReplyMessages(tLRPC$messages_Messages.messages, longSparseArray, tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, j, false);
            getMessagesStorage().putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
            saveReplyMessages(longSparseArray, tLRPC$messages_Messages.messages, z);
        }
        if (runnable != null) {
            AndroidUtilities.runOnUIThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadReplyMessagesForMessages$116, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadReplyMessagesForMessages$116$MediaDataController(long j, LongSparseArray longSparseArray, boolean z, Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            for (int i = 0; i < tLRPC$messages_Messages.messages.size(); i++) {
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i);
                if (tLRPC$Message.dialog_id == 0) {
                    tLRPC$Message.dialog_id = j;
                }
            }
            ImageLoader.saveMessagesThumbs(tLRPC$messages_Messages.messages);
            broadcastReplyMessages(tLRPC$messages_Messages.messages, longSparseArray, tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, j, false);
            getMessagesStorage().putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
            saveReplyMessages(longSparseArray, tLRPC$messages_Messages.messages, z);
        }
        if (runnable != null) {
            AndroidUtilities.runOnUIThread(runnable);
        }
    }

    private void saveReplyMessages(final LongSparseArray<SparseArray<ArrayList<MessageObject>>> replyMessageOwners, final ArrayList<TLRPC$Message> result, final boolean scheduled) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$ZsHsn0cfWUsblvWDgK9fMhoUzoc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveReplyMessages$118$MediaDataController(scheduled, result, replyMessageOwners);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveReplyMessages$118, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveReplyMessages$118$MediaDataController(boolean z, ArrayList arrayList, LongSparseArray longSparseArray) {
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast;
        ArrayList arrayList2;
        try {
            getMessagesStorage().getDatabase().beginTransaction();
            if (z) {
                sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("UPDATE scheduled_messages_v2 SET replydata = ? WHERE mid = ? AND uid = ?");
            } else {
                sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("UPDATE messages_v2 SET replydata = ? WHERE mid = ? AND uid = ?");
            }
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList.get(i);
                SparseArray sparseArray = (SparseArray) longSparseArray.get(MessageObject.getDialogId(tLRPC$Message));
                if (sparseArray != null && (arrayList2 = (ArrayList) sparseArray.get(tLRPC$Message.id)) != null) {
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                    tLRPC$Message.serializeToStream(nativeByteBuffer);
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        MessageObject messageObject = (MessageObject) arrayList2.get(i2);
                        sQLitePreparedStatementExecuteFast.requery();
                        sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                        sQLitePreparedStatementExecuteFast.bindInteger(2, messageObject.getId());
                        sQLitePreparedStatementExecuteFast.bindLong(3, messageObject.getDialogId());
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

    private void broadcastReplyMessages(ArrayList<TLRPC$Message> result, final LongSparseArray<SparseArray<ArrayList<MessageObject>>> replyMessageOwners, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final long dialog_id, final boolean isCache) {
        LongSparseArray longSparseArray = new LongSparseArray();
        for (int i = 0; i < users.size(); i++) {
            TLRPC$User tLRPC$User = users.get(i);
            longSparseArray.put(tLRPC$User.id, tLRPC$User);
        }
        LongSparseArray longSparseArray2 = new LongSparseArray();
        for (int i2 = 0; i2 < chats.size(); i2++) {
            TLRPC$Chat tLRPC$Chat = chats.get(i2);
            longSparseArray2.put(tLRPC$Chat.id, tLRPC$Chat);
        }
        final ArrayList arrayList = new ArrayList();
        int size = result.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new MessageObject(this.currentAccount, result.get(i3), (LongSparseArray<TLRPC$User>) longSparseArray, (LongSparseArray<TLRPC$Chat>) longSparseArray2, false, false));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$SZUjmMCRUNSgz75Ij2OEO86xMcA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$broadcastReplyMessages$119$MediaDataController(users, isCache, chats, arrayList, replyMessageOwners, dialog_id);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$broadcastReplyMessages$119, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$broadcastReplyMessages$119$MediaDataController(ArrayList arrayList, boolean z, ArrayList arrayList2, ArrayList arrayList3, LongSparseArray longSparseArray, long j) {
        ArrayList arrayList4;
        getMessagesController().putUsers(arrayList, z);
        getMessagesController().putChats(arrayList2, z);
        int size = arrayList3.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            MessageObject messageObject = (MessageObject) arrayList3.get(i);
            SparseArray sparseArray = (SparseArray) longSparseArray.get(messageObject.getDialogId());
            if (sparseArray != null && (arrayList4 = (ArrayList) sparseArray.get(messageObject.getId())) != null) {
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
            getNotificationCenter().postNotificationName(NotificationCenter.replyMessagesDidLoad, Long.valueOf(j), arrayList3, longSparseArray);
        }
    }

    public static void sortEntities(ArrayList<TLRPC$MessageEntity> entities) {
        Collections.sort(entities, entityComparator);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean checkInclusion(int r5, java.util.ArrayList<ir.eitaa.tgnet.TLRPC$MessageEntity> r6, boolean r7) {
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
            ir.eitaa.tgnet.TLRPC$MessageEntity r3 = (ir.eitaa.tgnet.TLRPC$MessageEntity) r3
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.checkInclusion(int, java.util.ArrayList, boolean):boolean");
    }

    private static boolean checkIntersection(int start, int end, ArrayList<TLRPC$MessageEntity> entities) {
        if (entities != null && !entities.isEmpty()) {
            int size = entities.size();
            for (int i = 0; i < size; i++) {
                TLRPC$MessageEntity tLRPC$MessageEntity = entities.get(i);
                int i2 = tLRPC$MessageEntity.offset;
                if (i2 > start && i2 + tLRPC$MessageEntity.length <= end) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void removeOffsetAfter(int start, int countToRemove, ArrayList<TLRPC$MessageEntity> entities) {
        int size = entities.size();
        for (int i = 0; i < size; i++) {
            TLRPC$MessageEntity tLRPC$MessageEntity = entities.get(i);
            int i2 = tLRPC$MessageEntity.offset;
            if (i2 > start) {
                tLRPC$MessageEntity.offset = i2 - countToRemove;
            }
        }
    }

    public CharSequence substring(CharSequence source, int start, int end) {
        if (source instanceof SpannableStringBuilder) {
            return source.subSequence(start, end);
        }
        if (source instanceof SpannedString) {
            return source.subSequence(start, end);
        }
        return TextUtils.substring(source, start, end);
    }

    private static CharacterStyle createNewSpan(CharacterStyle baseSpan, TextStyleSpan.TextStyleRun textStyleRun, TextStyleSpan.TextStyleRun newStyleRun, boolean allowIntersection) {
        TextStyleSpan.TextStyleRun textStyleRun2 = new TextStyleSpan.TextStyleRun(textStyleRun);
        if (newStyleRun != null) {
            if (allowIntersection) {
                textStyleRun2.merge(newStyleRun);
            } else {
                textStyleRun2.replace(newStyleRun);
            }
        }
        if (baseSpan instanceof TextStyleSpan) {
            return new TextStyleSpan(textStyleRun2);
        }
        if (baseSpan instanceof URLSpanReplacement) {
            return new URLSpanReplacement(((URLSpanReplacement) baseSpan).getURL(), textStyleRun2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void addStyleToText(ir.eitaa.ui.Components.TextStyleSpan r11, int r12, int r13, android.text.Spannable r14, boolean r15) {
        /*
            java.lang.Class<android.text.style.CharacterStyle> r0 = android.text.style.CharacterStyle.class
            java.lang.Object[] r0 = r14.getSpans(r12, r13, r0)     // Catch: java.lang.Exception -> Lb2
            android.text.style.CharacterStyle[] r0 = (android.text.style.CharacterStyle[]) r0     // Catch: java.lang.Exception -> Lb2
            r1 = 33
            if (r0 == 0) goto Laa
            int r2 = r0.length     // Catch: java.lang.Exception -> Lb2
            if (r2 <= 0) goto Laa
            r2 = 0
        L10:
            int r3 = r0.length     // Catch: java.lang.Exception -> Lb2
            if (r2 >= r3) goto Laa
            r3 = r0[r2]     // Catch: java.lang.Exception -> Lb2
            if (r11 == 0) goto L1c
            ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun r4 = r11.getTextStyleRun()     // Catch: java.lang.Exception -> Lb2
            goto L21
        L1c:
            ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun r4 = new ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun     // Catch: java.lang.Exception -> Lb2
            r4.<init>()     // Catch: java.lang.Exception -> Lb2
        L21:
            boolean r5 = r3 instanceof ir.eitaa.ui.Components.TextStyleSpan     // Catch: java.lang.Exception -> Lb2
            if (r5 == 0) goto L2d
            r5 = r3
            ir.eitaa.ui.Components.TextStyleSpan r5 = (ir.eitaa.ui.Components.TextStyleSpan) r5     // Catch: java.lang.Exception -> Lb2
            ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun r5 = r5.getTextStyleRun()     // Catch: java.lang.Exception -> Lb2
            goto L3f
        L2d:
            boolean r5 = r3 instanceof ir.eitaa.ui.Components.URLSpanReplacement     // Catch: java.lang.Exception -> Lb2
            if (r5 == 0) goto La6
            r5 = r3
            ir.eitaa.ui.Components.URLSpanReplacement r5 = (ir.eitaa.ui.Components.URLSpanReplacement) r5     // Catch: java.lang.Exception -> Lb2
            ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun r5 = r5.getTextStyleRun()     // Catch: java.lang.Exception -> Lb2
            if (r5 != 0) goto L3f
            ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun r5 = new ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun     // Catch: java.lang.Exception -> Lb2
            r5.<init>()     // Catch: java.lang.Exception -> Lb2
        L3f:
            if (r5 != 0) goto L43
            goto La6
        L43:
            int r6 = r14.getSpanStart(r3)     // Catch: java.lang.Exception -> Lb2
            int r7 = r14.getSpanEnd(r3)     // Catch: java.lang.Exception -> Lb2
            r14.removeSpan(r3)     // Catch: java.lang.Exception -> Lb2
            if (r6 <= r12) goto L6a
            if (r13 <= r7) goto L6a
            android.text.style.CharacterStyle r3 = createNewSpan(r3, r5, r4, r15)     // Catch: java.lang.Exception -> Lb2
            r14.setSpan(r3, r6, r7, r1)     // Catch: java.lang.Exception -> Lb2
            if (r11 == 0) goto L68
            ir.eitaa.ui.Components.TextStyleSpan r3 = new ir.eitaa.ui.Components.TextStyleSpan     // Catch: java.lang.Exception -> Lb2
            ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun r5 = new ir.eitaa.ui.Components.TextStyleSpan$TextStyleRun     // Catch: java.lang.Exception -> Lb2
            r5.<init>(r4)     // Catch: java.lang.Exception -> Lb2
            r3.<init>(r5)     // Catch: java.lang.Exception -> Lb2
            r14.setSpan(r3, r7, r13, r1)     // Catch: java.lang.Exception -> Lb2
        L68:
            r13 = r6
            goto La6
        L6a:
            r8 = 0
            if (r6 > r12) goto L87
            if (r6 == r12) goto L76
            android.text.style.CharacterStyle r9 = createNewSpan(r3, r5, r8, r15)     // Catch: java.lang.Exception -> Lb2
            r14.setSpan(r9, r6, r12, r1)     // Catch: java.lang.Exception -> Lb2
        L76:
            if (r7 <= r12) goto L87
            if (r11 == 0) goto L85
            android.text.style.CharacterStyle r9 = createNewSpan(r3, r5, r4, r15)     // Catch: java.lang.Exception -> Lb2
            int r10 = java.lang.Math.min(r7, r13)     // Catch: java.lang.Exception -> Lb2
            r14.setSpan(r9, r12, r10, r1)     // Catch: java.lang.Exception -> Lb2
        L85:
            r9 = r7
            goto L88
        L87:
            r9 = r12
        L88:
            if (r7 < r13) goto La5
            if (r7 == r13) goto L93
            android.text.style.CharacterStyle r8 = createNewSpan(r3, r5, r8, r15)     // Catch: java.lang.Exception -> Lb2
            r14.setSpan(r8, r13, r7, r1)     // Catch: java.lang.Exception -> Lb2
        L93:
            if (r13 <= r6) goto La5
            if (r7 > r12) goto La5
            if (r11 == 0) goto La4
            android.text.style.CharacterStyle r12 = createNewSpan(r3, r5, r4, r15)     // Catch: java.lang.Exception -> Lb2
            int r13 = java.lang.Math.min(r7, r13)     // Catch: java.lang.Exception -> Lb2
            r14.setSpan(r12, r6, r13, r1)     // Catch: java.lang.Exception -> Lb2
        La4:
            r13 = r6
        La5:
            r12 = r9
        La6:
            int r2 = r2 + 1
            goto L10
        Laa:
            if (r11 == 0) goto Lb6
            if (r12 >= r13) goto Lb6
            r14.setSpan(r11, r12, r13, r1)     // Catch: java.lang.Exception -> Lb2
            goto Lb6
        Lb2:
            r11 = move-exception
            ir.eitaa.messenger.FileLog.e(r11)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.addStyleToText(ir.eitaa.ui.Components.TextStyleSpan, int, int, android.text.Spannable, boolean):void");
    }

    public static ArrayList<TextStyleSpan.TextStyleRun> getTextStyleRuns(ArrayList<TLRPC$MessageEntity> entities, CharSequence text) {
        int i;
        ArrayList<TextStyleSpan.TextStyleRun> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList(entities);
        Collections.sort(arrayList2, $$Lambda$MediaDataController$x3FRSyjP4_ySvJjKQQqtIGcZLO0.INSTANCE);
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$MessageEntity tLRPC$MessageEntity = (TLRPC$MessageEntity) arrayList2.get(i2);
            if (tLRPC$MessageEntity.length > 0 && (i = tLRPC$MessageEntity.offset) >= 0 && i < text.length()) {
                if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length > text.length()) {
                    tLRPC$MessageEntity.length = text.length() - tLRPC$MessageEntity.offset;
                }
                TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
                int i3 = tLRPC$MessageEntity.offset;
                textStyleRun.start = i3;
                textStyleRun.end = i3 + tLRPC$MessageEntity.length;
                if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityStrike) {
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
                int size2 = arrayList.size();
                int i4 = 0;
                while (i4 < size2) {
                    TextStyleSpan.TextStyleRun textStyleRun2 = arrayList.get(i4);
                    int i5 = textStyleRun.start;
                    int i6 = textStyleRun2.start;
                    if (i5 > i6) {
                        int i7 = textStyleRun2.end;
                        if (i5 < i7) {
                            if (textStyleRun.end < i7) {
                                TextStyleSpan.TextStyleRun textStyleRun3 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                textStyleRun3.merge(textStyleRun2);
                                int i8 = i4 + 1;
                                arrayList.add(i8, textStyleRun3);
                                TextStyleSpan.TextStyleRun textStyleRun4 = new TextStyleSpan.TextStyleRun(textStyleRun2);
                                textStyleRun4.start = textStyleRun.end;
                                i4 = i8 + 1;
                                size2 = size2 + 1 + 1;
                                arrayList.add(i4, textStyleRun4);
                            } else {
                                TextStyleSpan.TextStyleRun textStyleRun5 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                textStyleRun5.merge(textStyleRun2);
                                textStyleRun5.end = textStyleRun2.end;
                                i4++;
                                size2++;
                                arrayList.add(i4, textStyleRun5);
                            }
                            int i9 = textStyleRun.start;
                            textStyleRun.start = textStyleRun2.end;
                            textStyleRun2.end = i9;
                        }
                    } else {
                        int i10 = textStyleRun.end;
                        if (i6 < i10) {
                            int i11 = textStyleRun2.end;
                            if (i10 == i11) {
                                textStyleRun2.merge(textStyleRun);
                            } else if (i10 < i11) {
                                TextStyleSpan.TextStyleRun textStyleRun6 = new TextStyleSpan.TextStyleRun(textStyleRun2);
                                textStyleRun6.merge(textStyleRun);
                                textStyleRun6.end = textStyleRun.end;
                                i4++;
                                size2++;
                                arrayList.add(i4, textStyleRun6);
                                textStyleRun2.start = textStyleRun.end;
                            } else {
                                TextStyleSpan.TextStyleRun textStyleRun7 = new TextStyleSpan.TextStyleRun(textStyleRun);
                                textStyleRun7.start = textStyleRun2.end;
                                i4++;
                                size2++;
                                arrayList.add(i4, textStyleRun7);
                                textStyleRun2.merge(textStyleRun);
                            }
                            textStyleRun.end = i6;
                        }
                    }
                    i4++;
                }
                if (textStyleRun.start < textStyleRun.end) {
                    arrayList.add(textStyleRun);
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ int lambda$getTextStyleRuns$120(TLRPC$MessageEntity tLRPC$MessageEntity, TLRPC$MessageEntity tLRPC$MessageEntity2) {
        int i = tLRPC$MessageEntity.offset;
        int i2 = tLRPC$MessageEntity2.offset;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public void addStyle(int flags, int spanStart, int spanEnd, ArrayList<TLRPC$MessageEntity> entities) {
        if ((flags & 1) != 0) {
            TLRPC$TL_messageEntityBold tLRPC$TL_messageEntityBold = new TLRPC$TL_messageEntityBold();
            tLRPC$TL_messageEntityBold.offset = spanStart;
            tLRPC$TL_messageEntityBold.length = spanEnd - spanStart;
            entities.add(tLRPC$TL_messageEntityBold);
        }
        if ((flags & 2) != 0) {
            TLRPC$TL_messageEntityItalic tLRPC$TL_messageEntityItalic = new TLRPC$TL_messageEntityItalic();
            tLRPC$TL_messageEntityItalic.offset = spanStart;
            tLRPC$TL_messageEntityItalic.length = spanEnd - spanStart;
            entities.add(tLRPC$TL_messageEntityItalic);
        }
        if ((flags & 4) != 0) {
            TLRPC$TL_messageEntityCode tLRPC$TL_messageEntityCode = new TLRPC$TL_messageEntityCode();
            tLRPC$TL_messageEntityCode.offset = spanStart;
            tLRPC$TL_messageEntityCode.length = spanEnd - spanStart;
            entities.add(tLRPC$TL_messageEntityCode);
        }
        if ((flags & 8) != 0) {
            TLRPC$TL_messageEntityStrike tLRPC$TL_messageEntityStrike = new TLRPC$TL_messageEntityStrike();
            tLRPC$TL_messageEntityStrike.offset = spanStart;
            tLRPC$TL_messageEntityStrike.length = spanEnd - spanStart;
            entities.add(tLRPC$TL_messageEntityStrike);
        }
        if ((flags & 16) != 0) {
            TLRPC$TL_messageEntityUnderline tLRPC$TL_messageEntityUnderline = new TLRPC$TL_messageEntityUnderline();
            tLRPC$TL_messageEntityUnderline.offset = spanStart;
            tLRPC$TL_messageEntityUnderline.length = spanEnd - spanStart;
            entities.add(tLRPC$TL_messageEntityUnderline);
        }
        if ((flags & 32) != 0) {
            TLRPC$TL_messageEntityBlockquote tLRPC$TL_messageEntityBlockquote = new TLRPC$TL_messageEntityBlockquote();
            tLRPC$TL_messageEntityBlockquote.offset = spanStart;
            tLRPC$TL_messageEntityBlockquote.length = spanEnd - spanStart;
            entities.add(tLRPC$TL_messageEntityBlockquote);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        if (r1 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        r1 = new java.util.ArrayList<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        if (r4 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        r13 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        r13 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        r13 = r13 + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        if (r13 >= r20[0].length()) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
    
        if (r20[0].charAt(r13) != '`') goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
    
        r5 = r5 + 1;
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0078, code lost:
    
        if (r4 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
    
        r12 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
    
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
    
        r12 = r12 + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007e, code lost:
    
        if (r4 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0080, code lost:
    
        if (r6 <= 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0082, code lost:
    
        r4 = r20[0].charAt(r6 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008b, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008c, code lost:
    
        if (r4 == ' ') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008e, code lost:
    
        if (r4 != '\n') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0091, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0094, code lost:
    
        r13 = substring(r20[0], 0, r6 - r4);
        r14 = substring(r20[0], r6 + 3, r5);
        r15 = r5 + 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ac, code lost:
    
        if (r15 >= r20[0].length()) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ae, code lost:
    
        r3 = r20[0].charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b5, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b6, code lost:
    
        r9 = r20[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b8, code lost:
    
        if (r3 == ' ') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ba, code lost:
    
        if (r3 != '\n') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bd, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bf, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c0, code lost:
    
        r3 = substring(r9, r15 + r3, r20[0].length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d1, code lost:
    
        if (r13.length() == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d3, code lost:
    
        r13 = ir.eitaa.messenger.AndroidUtilities.concat(r13, "\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00de, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e3, code lost:
    
        if (r3.length() == 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e5, code lost:
    
        r3 = ir.eitaa.messenger.AndroidUtilities.concat("\n", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f3, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) != false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f5, code lost:
    
        r20[0] = ir.eitaa.messenger.AndroidUtilities.concat(r13, r14, r3);
        r3 = new ir.eitaa.tgnet.TLRPC$TL_messageEntityPre();
        r3.offset = (r4 ^ 1) + r6;
        r3.length = ((r5 - r6) - 3) + (r4 ^ 1);
        r3.language = "";
        r1.add(r3);
        r12 = r12 - 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0120, code lost:
    
        r3 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0122, code lost:
    
        if (r3 == r5) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0124, code lost:
    
        r20[0] = ir.eitaa.messenger.AndroidUtilities.concat(substring(r20[0], 0, r6), substring(r20[0], r3, r5), substring(r20[0], r5 + 1, r20[0].length()));
        r3 = new ir.eitaa.tgnet.TLRPC$TL_messageEntityCode();
        r3.offset = r6;
        r3.length = (r5 - r6) - 1;
        r1.add(r3);
        r12 = r12 - 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<ir.eitaa.tgnet.TLRPC$MessageEntity> getEntities(java.lang.CharSequence[] r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 973
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.getEntities(java.lang.CharSequence[], boolean):java.util.ArrayList");
    }

    public void loadDraftsIfNeed() {
        if (getUserConfig().draftsLoaded || this.loadingDrafts) {
            return;
        }
        this.loadingDrafts = true;
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_getAllDrafts
            public static int constructor = 1782549861;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$IjWnobpBxfW2gCgGfK_hq-o02Tc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadDraftsIfNeed$123$MediaDataController(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDraftsIfNeed$121, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadDraftsIfNeed$121$MediaDataController() {
        this.loadingDrafts = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDraftsIfNeed$123, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadDraftsIfNeed$123$MediaDataController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$2K3cCTRx-KsybsAKl4AtOib856o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadDraftsIfNeed$121$MediaDataController();
                }
            });
        } else {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$xiitKVX-M68T4KJieYfODrab8l8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadDraftsIfNeed$122$MediaDataController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDraftsIfNeed$122, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadDraftsIfNeed$122$MediaDataController() {
        this.loadingDrafts = false;
        UserConfig userConfig = getUserConfig();
        userConfig.draftsLoaded = true;
        userConfig.saveConfig(false);
    }

    public int getDraftFolderId(long dialogId) {
        return this.draftsFolderIds.get(dialogId, 0).intValue();
    }

    public void setDraftFolderId(long dialogId, int folderId) {
        this.draftsFolderIds.put(dialogId, Integer.valueOf(folderId));
    }

    public void clearDraftsFolderIds() {
        this.draftsFolderIds.clear();
    }

    public LongSparseArray<SparseArray<TLRPC$DraftMessage>> getDrafts() {
        return this.drafts;
    }

    public TLRPC$DraftMessage getDraft(long dialogId, int threadId) {
        SparseArray<TLRPC$DraftMessage> sparseArray = this.drafts.get(dialogId);
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(threadId);
    }

    public TLRPC$Message getDraftMessage(long dialogId, int threadId) {
        SparseArray<TLRPC$Message> sparseArray = this.draftMessages.get(dialogId);
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(threadId);
    }

    public void saveDraft(long dialogId, int threadId, CharSequence message, ArrayList<TLRPC$MessageEntity> entities, TLRPC$Message replyToMessage, boolean noWebpage) {
        saveDraft(dialogId, threadId, message, entities, replyToMessage, noWebpage, false);
    }

    public void saveDraft(long dialogId, int threadId, CharSequence message, ArrayList<TLRPC$MessageEntity> entities, TLRPC$Message replyToMessage, boolean noWebpage, boolean clean) {
        TLRPC$DraftMessage tLRPC$TL_draftMessage;
        if (!TextUtils.isEmpty(message) || replyToMessage != null) {
            tLRPC$TL_draftMessage = new TLRPC$TL_draftMessage();
        } else {
            tLRPC$TL_draftMessage = new TLRPC$TL_draftMessageEmpty();
        }
        TLRPC$DraftMessage tLRPC$DraftMessage = tLRPC$TL_draftMessage;
        tLRPC$DraftMessage.date = (int) (System.currentTimeMillis() / 1000);
        tLRPC$DraftMessage.message = message == null ? "" : message.toString();
        tLRPC$DraftMessage.no_webpage = noWebpage;
        if (replyToMessage != null) {
            tLRPC$DraftMessage.reply_to_msg_id = replyToMessage.id;
            tLRPC$DraftMessage.flags |= 1;
        }
        if (entities != null && !entities.isEmpty()) {
            tLRPC$DraftMessage.entities = entities;
            tLRPC$DraftMessage.flags |= 8;
        }
        SparseArray<TLRPC$DraftMessage> sparseArray = this.drafts.get(dialogId);
        TLRPC$DraftMessage tLRPC$DraftMessage2 = sparseArray == null ? null : sparseArray.get(threadId);
        if (!clean) {
            if (tLRPC$DraftMessage2 != null && tLRPC$DraftMessage2.message.equals(tLRPC$DraftMessage.message) && tLRPC$DraftMessage2.reply_to_msg_id == tLRPC$DraftMessage.reply_to_msg_id && tLRPC$DraftMessage2.no_webpage == tLRPC$DraftMessage.no_webpage) {
                return;
            }
            if (tLRPC$DraftMessage2 == null && TextUtils.isEmpty(tLRPC$DraftMessage.message) && tLRPC$DraftMessage.reply_to_msg_id == 0) {
                return;
            }
        }
        saveDraft(dialogId, threadId, tLRPC$DraftMessage, replyToMessage, false);
        if (threadId == 0) {
            if (!DialogObject.isEncryptedDialog(dialogId)) {
                TLRPC$TL_messages_saveDraft tLRPC$TL_messages_saveDraft = new TLRPC$TL_messages_saveDraft();
                TLRPC$InputPeer inputPeer = getMessagesController().getInputPeer(dialogId);
                tLRPC$TL_messages_saveDraft.peer = inputPeer;
                if (inputPeer == null) {
                    return;
                }
                tLRPC$TL_messages_saveDraft.message = tLRPC$DraftMessage.message;
                tLRPC$TL_messages_saveDraft.no_webpage = tLRPC$DraftMessage.no_webpage;
                tLRPC$TL_messages_saveDraft.reply_to_msg_id = tLRPC$DraftMessage.reply_to_msg_id;
                tLRPC$TL_messages_saveDraft.entities = tLRPC$DraftMessage.entities;
                tLRPC$TL_messages_saveDraft.flags = tLRPC$DraftMessage.flags;
                getConnectionsManager().sendRequest(tLRPC$TL_messages_saveDraft, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$PshygAheUrig88HTW4YeOCCtYX4
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        MediaDataController.lambda$saveDraft$124(tLObject, tLRPC$TL_error);
                    }
                });
            }
            getMessagesController().sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
    }

    public void saveDraft(final long dialogId, final int threadId, TLRPC$DraftMessage draft, TLRPC$Message replyToMessage, boolean fromServer) {
        StringBuilder sb;
        TLRPC$Chat chat;
        String str;
        SharedPreferences.Editor editorEdit = this.draftPreferences.edit();
        MessagesController messagesController = getMessagesController();
        if (draft == null || (draft instanceof TLRPC$TL_draftMessageEmpty)) {
            SparseArray<TLRPC$DraftMessage> sparseArray = this.drafts.get(dialogId);
            if (sparseArray != null) {
                sparseArray.remove(threadId);
                if (sparseArray.size() == 0) {
                    this.drafts.remove(dialogId);
                }
            }
            SparseArray<TLRPC$Message> sparseArray2 = this.draftMessages.get(dialogId);
            if (sparseArray2 != null) {
                sparseArray2.remove(threadId);
                if (sparseArray2.size() == 0) {
                    this.draftMessages.remove(dialogId);
                }
            }
            if (threadId == 0) {
                this.draftPreferences.edit().remove("" + dialogId).remove("r_" + dialogId).commit();
            } else {
                this.draftPreferences.edit().remove("t_" + dialogId + "_" + threadId).remove("rt_" + dialogId + "_" + threadId).commit();
            }
            messagesController.removeDraftDialogIfNeed(dialogId);
        } else {
            SparseArray<TLRPC$DraftMessage> sparseArray3 = this.drafts.get(dialogId);
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray<>();
                this.drafts.put(dialogId, sparseArray3);
            }
            sparseArray3.put(threadId, draft);
            if (threadId == 0) {
                messagesController.putDraftDialogIfNeed(dialogId, draft);
            }
            try {
                SerializedData serializedData = new SerializedData(draft.getObjectSize());
                draft.serializeToStream(serializedData);
                if (threadId == 0) {
                    str = "" + dialogId;
                } else {
                    str = "t_" + dialogId + "_" + threadId;
                }
                editorEdit.putString(str, Utilities.bytesToHex(serializedData.toByteArray()));
                serializedData.cleanup();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        SparseArray<TLRPC$Message> sparseArray4 = this.draftMessages.get(dialogId);
        if (replyToMessage == null) {
            if (sparseArray4 != null) {
                sparseArray4.remove(threadId);
                if (sparseArray4.size() == 0) {
                    this.draftMessages.remove(dialogId);
                }
            }
            if (threadId == 0) {
                editorEdit.remove("r_" + dialogId);
            } else {
                editorEdit.remove("rt_" + dialogId + "_" + threadId);
            }
        } else {
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray<>();
                this.draftMessages.put(dialogId, sparseArray4);
            }
            sparseArray4.put(threadId, replyToMessage);
            SerializedData serializedData2 = new SerializedData(replyToMessage.getObjectSize());
            replyToMessage.serializeToStream(serializedData2);
            if (threadId == 0) {
                sb = new StringBuilder();
                sb.append("r_");
                sb.append(dialogId);
            } else {
                sb = new StringBuilder();
                sb.append("rt_");
                sb.append(dialogId);
                sb.append("_");
                sb.append(threadId);
            }
            editorEdit.putString(sb.toString(), Utilities.bytesToHex(serializedData2.toByteArray()));
            serializedData2.cleanup();
        }
        editorEdit.commit();
        if (fromServer && threadId == 0) {
            if (draft != null && draft.reply_to_msg_id != 0 && replyToMessage == null) {
                TLRPC$User user = null;
                if (DialogObject.isUserDialog(dialogId)) {
                    user = getMessagesController().getUser(Long.valueOf(dialogId));
                    chat = null;
                } else {
                    chat = getMessagesController().getChat(Long.valueOf(-dialogId));
                }
                if (user != null || chat != null) {
                    final long j = ChatObject.isChannel(chat) ? chat.id : 0L;
                    final int i = draft.reply_to_msg_id;
                    getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$bi_pLPun-yKnHZiSop_aofbssSI
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$saveDraft$127$MediaDataController(i, dialogId, j, threadId);
                        }
                    });
                }
            }
            getNotificationCenter().postNotificationName(NotificationCenter.newDraftReceived, Long.valueOf(dialogId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveDraft$127, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveDraft$127$MediaDataController(int i, final long j, long j2, final int i2) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        TLRPC$Message tLRPC$MessageTLdeserialize = null;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT data FROM messages_v2 WHERE mid = %d and uid = %d", Integer.valueOf(i), Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$MessageTLdeserialize != null) {
                saveDraftReplyMessage(j, i2, tLRPC$MessageTLdeserialize);
                return;
            }
            if (j2 != 0) {
                TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                tLRPC$TL_channels_getMessages.channel = getMessagesController().getInputChannel(j2);
                tLRPC$TL_channels_getMessages.id.add(Integer.valueOf(i));
                getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$3pIEDBtV8UdsRshF9dcYayX6GeA
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$saveDraft$125$MediaDataController(j, i2, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages = new TLRPC$TL_messages_getMessages();
            tLRPC$TL_messages_getMessages.id.add(Integer.valueOf(i));
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$lGnrIooQWJ9rnWStz2TblgGw7rQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$saveDraft$126$MediaDataController(j, i2, tLObject, tLRPC$TL_error);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveDraft$125, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveDraft$125$MediaDataController(long j, int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            if (tLRPC$messages_Messages.messages.isEmpty()) {
                return;
            }
            saveDraftReplyMessage(j, i, tLRPC$messages_Messages.messages.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveDraft$126, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveDraft$126$MediaDataController(long j, int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            if (tLRPC$messages_Messages.messages.isEmpty()) {
                return;
            }
            saveDraftReplyMessage(j, i, tLRPC$messages_Messages.messages.get(0));
        }
    }

    private void saveDraftReplyMessage(final long dialogId, final int threadId, final TLRPC$Message message) {
        if (message == null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$hHJTe5dhodXZHRZpHOiuyRBEcRw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveDraftReplyMessage$128$MediaDataController(dialogId, threadId, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveDraftReplyMessage$128, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveDraftReplyMessage$128$MediaDataController(long j, int i, TLRPC$Message tLRPC$Message) {
        String str;
        SparseArray<TLRPC$DraftMessage> sparseArray = this.drafts.get(j);
        TLRPC$DraftMessage tLRPC$DraftMessage = sparseArray != null ? sparseArray.get(i) : null;
        if (tLRPC$DraftMessage == null || tLRPC$DraftMessage.reply_to_msg_id != tLRPC$Message.id) {
            return;
        }
        SparseArray<TLRPC$Message> sparseArray2 = this.draftMessages.get(j);
        if (sparseArray2 == null) {
            sparseArray2 = new SparseArray<>();
            this.draftMessages.put(j, sparseArray2);
        }
        sparseArray2.put(i, tLRPC$Message);
        SerializedData serializedData = new SerializedData(tLRPC$Message.getObjectSize());
        tLRPC$Message.serializeToStream(serializedData);
        SharedPreferences.Editor editorEdit = this.draftPreferences.edit();
        if (i == 0) {
            str = "r_" + j;
        } else {
            str = "rt_" + j + "_" + i;
        }
        editorEdit.putString(str, Utilities.bytesToHex(serializedData.toByteArray())).commit();
        getNotificationCenter().postNotificationName(NotificationCenter.newDraftReceived, Long.valueOf(j));
        serializedData.cleanup();
    }

    public void clearAllDrafts(boolean notify) {
        this.drafts.clear();
        this.draftMessages.clear();
        this.draftsFolderIds.clear();
        this.draftPreferences.edit().clear().commit();
        if (notify) {
            getMessagesController().sortDialogs(null);
            getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        }
    }

    public void cleanDraft(long dialogId, int threadId, boolean replyOnly) {
        SparseArray<TLRPC$DraftMessage> sparseArray = this.drafts.get(dialogId);
        TLRPC$DraftMessage tLRPC$DraftMessage = sparseArray != null ? sparseArray.get(threadId) : null;
        if (tLRPC$DraftMessage == null) {
            return;
        }
        if (!replyOnly) {
            SparseArray<TLRPC$DraftMessage> sparseArray2 = this.drafts.get(dialogId);
            if (sparseArray2 != null) {
                sparseArray2.remove(threadId);
                if (sparseArray2.size() == 0) {
                    this.drafts.remove(dialogId);
                }
            }
            SparseArray<TLRPC$Message> sparseArray3 = this.draftMessages.get(dialogId);
            if (sparseArray3 != null) {
                sparseArray3.remove(threadId);
                if (sparseArray3.size() == 0) {
                    this.draftMessages.remove(dialogId);
                }
            }
            if (threadId == 0) {
                this.draftPreferences.edit().remove("" + dialogId).remove("r_" + dialogId).commit();
                getMessagesController().sortDialogs(null);
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
                return;
            }
            this.draftPreferences.edit().remove("t_" + dialogId + "_" + threadId).remove("rt_" + dialogId + "_" + threadId).commit();
            return;
        }
        if (tLRPC$DraftMessage.reply_to_msg_id != 0) {
            tLRPC$DraftMessage.reply_to_msg_id = 0;
            tLRPC$DraftMessage.flags &= -2;
            saveDraft(dialogId, threadId, tLRPC$DraftMessage.message, tLRPC$DraftMessage.entities, null, tLRPC$DraftMessage.no_webpage, true);
        }
    }

    public void beginTransaction() {
        this.inTransaction = true;
    }

    public void endTransaction() {
        this.inTransaction = false;
    }

    public void clearBotKeyboard(final long dialogId, final ArrayList<Integer> messages) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$2AbC6-pjGlQtVmjKfneIOSTVmtY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearBotKeyboard$129$MediaDataController(messages, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearBotKeyboard$129, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearBotKeyboard$129$MediaDataController(ArrayList arrayList, long j) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                long j2 = this.botKeyboardsByMids.get(((Integer) arrayList.get(i)).intValue());
                if (j2 != 0) {
                    this.botKeyboards.remove(j2);
                    this.botKeyboardsByMids.delete(((Integer) arrayList.get(i)).intValue());
                    getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, null, Long.valueOf(j2));
                }
            }
            return;
        }
        this.botKeyboards.remove(j);
        getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, null, Long.valueOf(j));
    }

    public void loadBotKeyboard(final long dialogId) {
        TLRPC$Message tLRPC$Message = this.botKeyboards.get(dialogId);
        if (tLRPC$Message != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, tLRPC$Message, Long.valueOf(dialogId));
        } else {
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$q-8I0BYrM4ZRzM7W51AdhoopiU0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadBotKeyboard$131$MediaDataController(dialogId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadBotKeyboard$131, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadBotKeyboard$131$MediaDataController(final long j) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        final TLRPC$Message tLRPC$MessageTLdeserialize = null;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT info FROM bot_keyboard WHERE uid = %d", Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && !sQLiteCursorQueryFinalized.isNull(0) && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$MessageTLdeserialize != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$-MHew6CVZAS0-mS7aDXMHKtM_uo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadBotKeyboard$130$MediaDataController(tLRPC$MessageTLdeserialize, j);
                    }
                });
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadBotKeyboard$130, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadBotKeyboard$130$MediaDataController(TLRPC$Message tLRPC$Message, long j) {
        getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, tLRPC$Message, Long.valueOf(j));
    }

    private TLRPC$BotInfo loadBotInfoInternal(long uid, long dialogId) throws SQLiteException {
        TLRPC$BotInfo tLRPC$BotInfoTLdeserialize;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT info FROM bot_info_v2 WHERE uid = %d AND dialogId = %d", Long.valueOf(uid), Long.valueOf(dialogId)), new Object[0]);
        if (!sQLiteCursorQueryFinalized.next() || sQLiteCursorQueryFinalized.isNull(0) || (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) == null) {
            tLRPC$BotInfoTLdeserialize = null;
        } else {
            tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
            nativeByteBufferByteBufferValue.reuse();
        }
        sQLiteCursorQueryFinalized.dispose();
        return tLRPC$BotInfoTLdeserialize;
    }

    public void loadBotInfo(final long uid, final long dialogId, boolean cache, final int classGuid) {
        if (cache) {
            TLRPC$BotInfo tLRPC$BotInfo = this.botInfos.get(uid + "_" + dialogId);
            if (tLRPC$BotInfo != null) {
                getNotificationCenter().postNotificationName(NotificationCenter.botInfoDidLoad, tLRPC$BotInfo, Integer.valueOf(classGuid));
                return;
            }
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$2tKEZyR1QlPgX_FjZIna9UQyfqE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadBotInfo$133$MediaDataController(uid, dialogId, classGuid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadBotInfo$133, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadBotInfo$133$MediaDataController(long j, long j2, final int i) {
        try {
            final TLRPC$BotInfo tLRPC$BotInfoLoadBotInfoInternal = loadBotInfoInternal(j, j2);
            if (tLRPC$BotInfoLoadBotInfoInternal != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$JQeF_764AHVLK2mnJ2Zbx8cLUBw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadBotInfo$132$MediaDataController(tLRPC$BotInfoLoadBotInfoInternal, i);
                    }
                });
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadBotInfo$132, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadBotInfo$132$MediaDataController(TLRPC$BotInfo tLRPC$BotInfo, int i) {
        getNotificationCenter().postNotificationName(NotificationCenter.botInfoDidLoad, tLRPC$BotInfo, Integer.valueOf(i));
    }

    public void putBotKeyboard(final long dialogId, final TLRPC$Message message) {
        if (message == null) {
            return;
        }
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT mid FROM bot_keyboard WHERE uid = %d", Long.valueOf(dialogId)), new Object[0]);
            int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            if (iIntValue >= message.id) {
                return;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO bot_keyboard VALUES(?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(message.getObjectSize());
            message.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindLong(1, dialogId);
            sQLitePreparedStatementExecuteFast.bindInteger(2, message.id);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
            sQLitePreparedStatementExecuteFast.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$oKHmzTfRJQVB_0egLmfZka1dVL0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putBotKeyboard$134$MediaDataController(dialogId, message);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putBotKeyboard$134, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putBotKeyboard$134$MediaDataController(long j, TLRPC$Message tLRPC$Message) {
        TLRPC$Message tLRPC$Message2 = this.botKeyboards.get(j);
        this.botKeyboards.put(j, tLRPC$Message);
        if (MessageObject.getChannelId(tLRPC$Message) == 0) {
            if (tLRPC$Message2 != null) {
                this.botKeyboardsByMids.delete(tLRPC$Message2.id);
            }
            this.botKeyboardsByMids.put(tLRPC$Message.id, j);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.botKeyboardDidLoad, tLRPC$Message, Long.valueOf(j));
    }

    public void putBotInfo(final long dialogId, final TLRPC$BotInfo botInfo) {
        if (botInfo == null) {
            return;
        }
        this.botInfos.put(botInfo.user_id + "_" + dialogId, botInfo);
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$dH20O66jDnD8jo6GGhFSB8Nz11A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putBotInfo$135$MediaDataController(botInfo, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putBotInfo$135, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putBotInfo$135$MediaDataController(TLRPC$BotInfo tLRPC$BotInfo, long j) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO bot_info_v2 VALUES(?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$BotInfo.getObjectSize());
            tLRPC$BotInfo.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$BotInfo.user_id);
            sQLitePreparedStatementExecuteFast.bindLong(2, j);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateBotInfo(final long dialogId, final TLRPC$TL_updateBotCommands update) {
        TLRPC$BotInfo tLRPC$BotInfo = this.botInfos.get(update.bot_id + "_" + dialogId);
        if (tLRPC$BotInfo != null) {
            tLRPC$BotInfo.commands = update.commands;
            getNotificationCenter().postNotificationName(NotificationCenter.botInfoDidLoad, tLRPC$BotInfo, 0);
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$NM9arnS7tkI93ouX2_e7uOILCZM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateBotInfo$136$MediaDataController(update, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateBotInfo$136, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateBotInfo$136$MediaDataController(TLRPC$TL_updateBotCommands tLRPC$TL_updateBotCommands, long j) {
        try {
            TLRPC$BotInfo tLRPC$BotInfoLoadBotInfoInternal = loadBotInfoInternal(tLRPC$TL_updateBotCommands.bot_id, j);
            if (tLRPC$BotInfoLoadBotInfoInternal != null) {
                tLRPC$BotInfoLoadBotInfoInternal.commands = tLRPC$TL_updateBotCommands.commands;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO bot_info_v2 VALUES(?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$BotInfoLoadBotInfoInternal.getObjectSize());
            tLRPC$BotInfoLoadBotInfoInternal.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$BotInfoLoadBotInfoInternal.user_id);
            sQLitePreparedStatementExecuteFast.bindLong(2, j);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void fetchNewEmojiKeywords(String[] langCodes) {
        if (langCodes == null) {
            return;
        }
        for (final String str : langCodes) {
            if (TextUtils.isEmpty(str) || this.currentFetchingEmoji.get(str) != null) {
                return;
            }
            this.currentFetchingEmoji.put(str, Boolean.TRUE);
            getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$nCPi96nCL0uo41BMSG0Zq-ZJ8U4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fetchNewEmojiKeywords$142$MediaDataController(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* renamed from: lambda$fetchNewEmojiKeywords$142, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$142$MediaDataController(final java.lang.String r10) {
        /*
            r9 = this;
            r0 = -1
            r1 = 0
            r2 = 0
            ir.eitaa.messenger.MessagesStorage r4 = r9.getMessagesStorage()     // Catch: java.lang.Exception -> L33
            ir.eitaa.SQLite.SQLiteDatabase r4 = r4.getDatabase()     // Catch: java.lang.Exception -> L33
            java.lang.String r5 = "SELECT alias, version, date FROM emoji_keywords_info_v2 WHERE lang = ?"
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L33
            r8 = 0
            r7[r8] = r10     // Catch: java.lang.Exception -> L33
            ir.eitaa.SQLite.SQLiteCursor r4 = r4.queryFinalized(r5, r7)     // Catch: java.lang.Exception -> L33
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
            ir.eitaa.messenger.FileLog.e(r4)
        L38:
            boolean r4 = ir.eitaa.messenger.BuildVars.DEBUG_VERSION
            if (r4 != 0) goto L55
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r2
            long r2 = java.lang.Math.abs(r6)
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 >= 0) goto L55
            ir.eitaa.messenger.-$$Lambda$MediaDataController$-fOJJrG0uSKPC-UeZg47pnWZ2Yk r0 = new ir.eitaa.messenger.-$$Lambda$MediaDataController$-fOJJrG0uSKPC-UeZg47pnWZ2Yk
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        L55:
            if (r5 != r0) goto L5f
            ir.eitaa.tgnet.TLRPC$TL_messages_getEmojiKeywords r0 = new ir.eitaa.tgnet.TLRPC$TL_messages_getEmojiKeywords
            r0.<init>()
            r0.lang_code = r10
            goto L68
        L5f:
            ir.eitaa.tgnet.TLRPC$TL_messages_getEmojiKeywordsDifference r0 = new ir.eitaa.tgnet.TLRPC$TL_messages_getEmojiKeywordsDifference
            r0.<init>()
            r0.lang_code = r10
            r0.from_version = r5
        L68:
            ir.eitaa.tgnet.ConnectionsManager r2 = r9.getConnectionsManager()
            ir.eitaa.messenger.-$$Lambda$MediaDataController$2LYpZ4Q1IxCw46md0U0DAqOsnsU r3 = new ir.eitaa.messenger.-$$Lambda$MediaDataController$2LYpZ4Q1IxCw46md0U0DAqOsnsU
            r3.<init>()
            r2.sendRequest(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.lambda$fetchNewEmojiKeywords$142$MediaDataController(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fetchNewEmojiKeywords$137, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$137$MediaDataController(String str) {
        this.currentFetchingEmoji.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fetchNewEmojiKeywords$141, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$141$MediaDataController(int i, String str, final String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$TL_emojiKeywordsDifference tLRPC$TL_emojiKeywordsDifference = (TLRPC$TL_emojiKeywordsDifference) tLObject;
            if (i != -1 && !tLRPC$TL_emojiKeywordsDifference.lang_code.equals(str)) {
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$waLOGM9xCqm-hXygus0-QqmZOQo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$fetchNewEmojiKeywords$139$MediaDataController(str2);
                    }
                });
                return;
            } else {
                putEmojiKeywords(str2, tLRPC$TL_emojiKeywordsDifference);
                return;
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$tG9CcF0dwvpjZj_oNyaIFYVybXY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fetchNewEmojiKeywords$140$MediaDataController(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fetchNewEmojiKeywords$139, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$139$MediaDataController(final String str) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("DELETE FROM emoji_keywords_info_v2 WHERE lang = ?");
            sQLitePreparedStatementExecuteFast.bindString(1, str);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$3gtfTs550sGZRZa6CjyhYPQnYxs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fetchNewEmojiKeywords$138$MediaDataController(str);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fetchNewEmojiKeywords$138, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$138$MediaDataController(String str) {
        this.currentFetchingEmoji.remove(str);
        fetchNewEmojiKeywords(new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fetchNewEmojiKeywords$140, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fetchNewEmojiKeywords$140$MediaDataController(String str) {
        this.currentFetchingEmoji.remove(str);
    }

    private void putEmojiKeywords(final String lang, final TLRPC$TL_emojiKeywordsDifference res) {
        if (res == null) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$CiHbNcLX-CmWRf0g3CUREPPbSao
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putEmojiKeywords$144$MediaDataController(res, lang);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putEmojiKeywords$144, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putEmojiKeywords$144$MediaDataController(TLRPC$TL_emojiKeywordsDifference tLRPC$TL_emojiKeywordsDifference, final String str) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$z4M370XaSKn7gntdIVrO0gxHG6g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putEmojiKeywords$143$MediaDataController(str);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putEmojiKeywords$143, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putEmojiKeywords$143$MediaDataController(String str) {
        this.currentFetchingEmoji.remove(str);
        getNotificationCenter().postNotificationName(NotificationCenter.newEmojiSuggestionsAvailable, str);
    }

    public void getEmojiSuggestions(String[] langCodes, String keyword, boolean fullMatch, KeywordResultCallback callback) {
        getEmojiSuggestions(langCodes, keyword, fullMatch, callback, null);
    }

    public void getEmojiSuggestions(final String[] langCodes, final String keyword, final boolean fullMatch, final KeywordResultCallback callback, final CountDownLatch sync) {
        if (callback == null) {
            return;
        }
        if (TextUtils.isEmpty(keyword) || langCodes == null) {
            callback.run(new ArrayList<>(), null);
            return;
        }
        final ArrayList arrayList = new ArrayList(Emoji.recentEmoji);
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MediaDataController$5tCskxYo4OGGvXZgflAUYWY5hp4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getEmojiSuggestions$148$MediaDataController(langCodes, callback, keyword, fullMatch, arrayList, sync);
            }
        });
        if (sync != null) {
            try {
                sync.await();
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
    /* renamed from: lambda$getEmojiSuggestions$148, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getEmojiSuggestions$148$MediaDataController(final java.lang.String[] r15, final ir.eitaa.messenger.MediaDataController.KeywordResultCallback r16, java.lang.String r17, boolean r18, java.util.ArrayList r19, java.util.concurrent.CountDownLatch r20) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MediaDataController.lambda$getEmojiSuggestions$148$MediaDataController(java.lang.String[], ir.eitaa.messenger.MediaDataController$KeywordResultCallback, java.lang.String, boolean, java.util.ArrayList, java.util.concurrent.CountDownLatch):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getEmojiSuggestions$145, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getEmojiSuggestions$145$MediaDataController(String[] strArr, KeywordResultCallback keywordResultCallback, ArrayList arrayList) {
        for (String str : strArr) {
            if (this.currentFetchingEmoji.get(str) != null) {
                return;
            }
        }
        keywordResultCallback.run(arrayList, null);
    }

    static /* synthetic */ int lambda$getEmojiSuggestions$146(ArrayList arrayList, KeywordResult keywordResult, KeywordResult keywordResult2) {
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
}
