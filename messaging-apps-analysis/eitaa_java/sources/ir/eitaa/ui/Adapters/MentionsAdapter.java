package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInfo;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaAuto;
import ir.eitaa.tgnet.TLRPC$TL_channelFull;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsMentions;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipants;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolveUsername;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolvedPeer;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inlineBotSwitchPM;
import ir.eitaa.tgnet.TLRPC$TL_inputGeoPoint;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_botResults;
import ir.eitaa.tgnet.TLRPC$TL_messages_getInlineBotResults;
import ir.eitaa.tgnet.TLRPC$TL_messages_getStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickers;
import ir.eitaa.tgnet.TLRPC$TL_photo;
import ir.eitaa.tgnet.TLRPC$TL_photoSize;
import ir.eitaa.tgnet.TLRPC$TL_photoSizeProgressive;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import ir.eitaa.ui.Cells.BotSwitchCell;
import ir.eitaa.ui.Cells.ContextLinkCell;
import ir.eitaa.ui.Cells.MentionCell;
import ir.eitaa.ui.Cells.StickerCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.EmojiView;
import ir.eitaa.ui.Components.RecyclerListView;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class MentionsAdapter extends RecyclerListView.SelectionAdapter implements NotificationCenter.NotificationCenterDelegate {
    private LongSparseArray<TLRPC$BotInfo> botInfo;
    private int botsCount;
    private Runnable cancelDelayRunnable;
    private int channelLastReqId;
    private int channelReqId;
    private boolean contextMedia;
    private int contextQueryReqid;
    private Runnable contextQueryRunnable;
    private int contextUsernameReqid;
    private boolean delayLocalResults;
    private MentionsAdapterDelegate delegate;
    private long dialog_id;
    private TLRPC$User foundContextBot;
    private TLRPC$ChatFull info;
    private boolean isDarkTheme;
    private boolean isSearchingMentions;
    private boolean lastForSearch;
    private Location lastKnownLocation;
    private int lastPosition;
    private int lastReqId;
    private String[] lastSearchKeyboardLanguage;
    private String lastSticker;
    private String lastText;
    private boolean lastUsernameOnly;
    private Context mContext;
    private EmojiView.ChooseStickerActionTracker mentionsStickersActionTracker;
    private ArrayList<MessageObject> messages;
    private String nextQueryOffset;
    private boolean noUserName;
    private ChatActivity parentFragment;
    private final Theme.ResourcesProvider resourcesProvider;
    private int resultLength;
    private int resultStartPosition;
    private SearchAdapterHelper searchAdapterHelper;
    private Runnable searchGlobalRunnable;
    private ArrayList<TLRPC$BotInlineResult> searchResultBotContext;
    private TLRPC$TL_inlineBotSwitchPM searchResultBotContextSwitch;
    private ArrayList<String> searchResultCommands;
    private ArrayList<String> searchResultCommandsHelp;
    private ArrayList<TLRPC$User> searchResultCommandsUsers;
    private ArrayList<String> searchResultHashtags;
    private ArrayList<MediaDataController.KeywordResult> searchResultSuggestions;
    private ArrayList<TLObject> searchResultUsernames;
    private LongSparseArray<TLObject> searchResultUsernamesMap;
    private String searchingContextQuery;
    private String searchingContextUsername;
    private ArrayList<StickerResult> stickers;
    private HashMap<String, TLRPC$Document> stickersMap;
    private int threadMessageId;
    private boolean visibleByStickersSearch;
    private int currentAccount = UserConfig.selectedAccount;
    private boolean needUsernames = true;
    private boolean needBotContext = true;
    private boolean inlineMediaEnabled = true;
    private ArrayList<String> stickersToLoad = new ArrayList<>();
    private SendMessagesHelper.LocationProvider locationProvider = new SendMessagesHelper.LocationProvider(new SendMessagesHelper.LocationProvider.LocationProviderDelegate() { // from class: ir.eitaa.ui.Adapters.MentionsAdapter.1
        @Override // ir.eitaa.messenger.SendMessagesHelper.LocationProvider.LocationProviderDelegate
        public void onLocationAcquired(Location location) {
            if (MentionsAdapter.this.foundContextBot == null || !MentionsAdapter.this.foundContextBot.bot_inline_geo) {
                return;
            }
            MentionsAdapter.this.lastKnownLocation = location;
            MentionsAdapter mentionsAdapter = MentionsAdapter.this;
            mentionsAdapter.searchForContextBotResults(true, mentionsAdapter.foundContextBot, MentionsAdapter.this.searchingContextQuery, "");
        }

        @Override // ir.eitaa.messenger.SendMessagesHelper.LocationProvider.LocationProviderDelegate
        public void onUnableLocationAcquire() {
            MentionsAdapter.this.onLocationUnavailable();
        }
    }) { // from class: ir.eitaa.ui.Adapters.MentionsAdapter.2
        @Override // ir.eitaa.messenger.SendMessagesHelper.LocationProvider
        public void stop() {
            super.stop();
            MentionsAdapter.this.lastKnownLocation = null;
        }
    };

    public interface MentionsAdapterDelegate {
        void needChangePanelVisibility(boolean show);

        void onContextClick(TLRPC$BotInlineResult result);

        void onContextSearch(boolean searching);
    }

    static /* synthetic */ int access$1704(MentionsAdapter mentionsAdapter) {
        int i = mentionsAdapter.channelLastReqId + 1;
        mentionsAdapter.channelLastReqId = i;
        return i;
    }

    private static class StickerResult {
        public Object parent;
        public TLRPC$Document sticker;

        public StickerResult(TLRPC$Document s, Object p) {
            this.sticker = s;
            this.parent = p;
        }
    }

    public MentionsAdapter(Context context, boolean darkTheme, long did, int threadMessageId, MentionsAdapterDelegate mentionsAdapterDelegate, Theme.ResourcesProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
        this.mContext = context;
        this.delegate = mentionsAdapterDelegate;
        this.isDarkTheme = darkTheme;
        this.dialog_id = did;
        this.threadMessageId = threadMessageId;
        SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(true);
        this.searchAdapterHelper = searchAdapterHelper;
        searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: ir.eitaa.ui.Adapters.MentionsAdapter.3
            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ boolean canApplySearchResults(int i) {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ LongSparseArray getExcludeCallParticipants() {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ LongSparseArray getExcludeUsers() {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public void onDataSetChanged(int searchId) {
                MentionsAdapter.this.notifyDataSetChanged();
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public void onSetHashtags(ArrayList<SearchAdapterHelper.HashtagObject> arrayList, HashMap<String, SearchAdapterHelper.HashtagObject> hashMap) {
                if (MentionsAdapter.this.lastText != null) {
                    MentionsAdapter mentionsAdapter = MentionsAdapter.this;
                    mentionsAdapter.searchUsernameOrHashtag(mentionsAdapter.lastText, MentionsAdapter.this.lastPosition, MentionsAdapter.this.messages, MentionsAdapter.this.lastUsernameOnly, MentionsAdapter.this.lastForSearch);
                }
            }
        });
        if (darkTheme) {
            return;
        }
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadFailed);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, final Object... args) {
        ArrayList<StickerResult> arrayList;
        if ((id != NotificationCenter.fileLoaded && id != NotificationCenter.fileLoadFailed) || (arrayList = this.stickers) == null || arrayList.isEmpty() || this.stickersToLoad.isEmpty() || !this.visibleByStickersSearch) {
            return;
        }
        boolean z = false;
        this.stickersToLoad.remove((String) args[0]);
        if (this.stickersToLoad.isEmpty()) {
            MentionsAdapterDelegate mentionsAdapterDelegate = this.delegate;
            ArrayList<StickerResult> arrayList2 = this.stickers;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z = true;
            }
            mentionsAdapterDelegate.needChangePanelVisibility(z);
        }
    }

    private void addStickerToResult(TLRPC$Document document, Object parent) {
        if (document == null) {
            return;
        }
        String str = document.dc_id + "_" + document.id;
        HashMap<String, TLRPC$Document> map = this.stickersMap;
        if (map == null || !map.containsKey(str)) {
            if (this.stickers == null) {
                this.stickers = new ArrayList<>();
                this.stickersMap = new HashMap<>();
            }
            this.stickers.add(new StickerResult(document, parent));
            this.stickersMap.put(str, document);
            EmojiView.ChooseStickerActionTracker chooseStickerActionTracker = this.mentionsStickersActionTracker;
            if (chooseStickerActionTracker != null) {
                chooseStickerActionTracker.checkVisibility();
            }
        }
    }

    private void addStickersToResult(ArrayList<TLRPC$Document> documents, Object parent) {
        if (documents == null || documents.isEmpty()) {
            return;
        }
        int size = documents.size();
        for (int i = 0; i < size; i++) {
            TLRPC$Document tLRPC$Document = documents.get(i);
            String str = tLRPC$Document.dc_id + "_" + tLRPC$Document.id;
            HashMap<String, TLRPC$Document> map = this.stickersMap;
            if (map == null || !map.containsKey(str)) {
                if (this.stickers == null) {
                    this.stickers = new ArrayList<>();
                    this.stickersMap = new HashMap<>();
                }
                int size2 = tLRPC$Document.attributes.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i2);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                        parent = tLRPC$DocumentAttribute.stickerset;
                        break;
                    }
                    i2++;
                }
                this.stickers.add(new StickerResult(tLRPC$Document, parent));
                this.stickersMap.put(str, tLRPC$Document);
            }
        }
    }

    private boolean checkStickerFilesExistAndDownload() {
        if (this.stickers == null) {
            return false;
        }
        this.stickersToLoad.clear();
        int iMin = Math.min(6, this.stickers.size());
        for (int i = 0; i < iMin; i++) {
            StickerResult stickerResult = this.stickers.get(i);
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(stickerResult.sticker.thumbs, 90);
            if (((closestPhotoSizeWithSize instanceof TLRPC$TL_photoSize) || (closestPhotoSizeWithSize instanceof TLRPC$TL_photoSizeProgressive)) && !FileLoader.getPathToAttach(closestPhotoSizeWithSize, "webp", true).exists()) {
                this.stickersToLoad.add(FileLoader.getAttachFileName(closestPhotoSizeWithSize, "webp"));
                FileLoader.getInstance(this.currentAccount).loadFile(ImageLocation.getForDocument(closestPhotoSizeWithSize, stickerResult.sticker), stickerResult.parent, "webp", 1, 1);
            }
        }
        return this.stickersToLoad.isEmpty();
    }

    private boolean isValidSticker(TLRPC$Document document, String emoji) {
        int size = document.attributes.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                String str = tLRPC$DocumentAttribute.alt;
                if (str == null || !str.contains(emoji)) {
                    break;
                }
                return true;
            }
            i++;
        }
        return false;
    }

    private void searchServerStickers(final String emoji, final String originalEmoji) {
        TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers = new TLRPC$TL_messages_getStickers();
        tLRPC$TL_messages_getStickers.emoticon = originalEmoji;
        tLRPC$TL_messages_getStickers.hash = 0L;
        this.lastReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getStickers, new RequestDelegate() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$F1OlNjdutWTLyzJPq45-tXfVTHc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$searchServerStickers$1$MentionsAdapter(emoji, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchServerStickers$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchServerStickers$1$MentionsAdapter(final String str, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$pS7mGX7i9TUT4Wx_fxy014ls1P8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchServerStickers$0$MentionsAdapter(str, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchServerStickers$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchServerStickers$0$MentionsAdapter(String str, TLObject tLObject) {
        ArrayList<StickerResult> arrayList;
        this.lastReqId = 0;
        if (str.equals(this.lastSticker) && (tLObject instanceof TLRPC$TL_messages_stickers)) {
            this.delayLocalResults = false;
            TLRPC$TL_messages_stickers tLRPC$TL_messages_stickers = (TLRPC$TL_messages_stickers) tLObject;
            ArrayList<StickerResult> arrayList2 = this.stickers;
            int size = arrayList2 != null ? arrayList2.size() : 0;
            addStickersToResult(tLRPC$TL_messages_stickers.stickers, "sticker_search_" + str);
            ArrayList<StickerResult> arrayList3 = this.stickers;
            int size2 = arrayList3 != null ? arrayList3.size() : 0;
            if (!this.visibleByStickersSearch && (arrayList = this.stickers) != null && !arrayList.isEmpty()) {
                checkStickerFilesExistAndDownload();
                this.delegate.needChangePanelVisibility(this.stickersToLoad.isEmpty());
                this.visibleByStickersSearch = true;
            }
            if (size != size2) {
                notifyDataSetChanged();
            }
        }
    }

    private void clearStickers() {
        this.lastSticker = null;
        this.stickers = null;
        this.stickersMap = null;
        notifyDataSetChanged();
        if (this.lastReqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.lastReqId, true);
            this.lastReqId = 0;
        }
        EmojiView.ChooseStickerActionTracker chooseStickerActionTracker = this.mentionsStickersActionTracker;
        if (chooseStickerActionTracker != null) {
            chooseStickerActionTracker.checkVisibility();
        }
    }

    public void onDestroy() {
        SendMessagesHelper.LocationProvider locationProvider = this.locationProvider;
        if (locationProvider != null) {
            locationProvider.stop();
        }
        Runnable runnable = this.contextQueryRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.contextQueryRunnable = null;
        }
        if (this.contextUsernameReqid != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.contextUsernameReqid, true);
            this.contextUsernameReqid = 0;
        }
        if (this.contextQueryReqid != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.contextQueryReqid, true);
            this.contextQueryReqid = 0;
        }
        this.foundContextBot = null;
        this.inlineMediaEnabled = true;
        this.searchingContextUsername = null;
        this.searchingContextQuery = null;
        this.noUserName = false;
        if (this.isDarkTheme) {
            return;
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadFailed);
    }

    public void setParentFragment(ChatActivity fragment) {
        this.parentFragment = fragment;
    }

    public void setChatInfo(TLRPC$ChatFull chatInfo) {
        ChatActivity chatActivity;
        TLRPC$Chat currentChat;
        this.currentAccount = UserConfig.selectedAccount;
        this.info = chatInfo;
        if (!this.inlineMediaEnabled && this.foundContextBot != null && (chatActivity = this.parentFragment) != null && (currentChat = chatActivity.getCurrentChat()) != null) {
            boolean zCanSendStickers = ChatObject.canSendStickers(currentChat);
            this.inlineMediaEnabled = zCanSendStickers;
            if (zCanSendStickers) {
                this.searchResultUsernames = null;
                notifyDataSetChanged();
                this.delegate.needChangePanelVisibility(false);
                processFoundUser(this.foundContextBot);
            }
        }
        String str = this.lastText;
        if (str != null) {
            searchUsernameOrHashtag(str, this.lastPosition, this.messages, this.lastUsernameOnly, this.lastForSearch);
        }
    }

    public void setNeedUsernames(boolean value) {
        this.needUsernames = value;
    }

    public void setNeedBotContext(boolean value) {
        this.needBotContext = value;
    }

    public void setBotInfo(LongSparseArray<TLRPC$BotInfo> info) {
        this.botInfo = info;
    }

    public void setBotsCount(int count) {
        this.botsCount = count;
    }

    public void clearRecentHashtags() {
        this.searchAdapterHelper.clearRecentHashtags();
        this.searchResultHashtags.clear();
        notifyDataSetChanged();
        MentionsAdapterDelegate mentionsAdapterDelegate = this.delegate;
        if (mentionsAdapterDelegate != null) {
            mentionsAdapterDelegate.needChangePanelVisibility(false);
        }
    }

    public TLRPC$TL_inlineBotSwitchPM getBotContextSwitch() {
        return this.searchResultBotContextSwitch;
    }

    public long getContextBotId() {
        TLRPC$User tLRPC$User = this.foundContextBot;
        if (tLRPC$User != null) {
            return tLRPC$User.id;
        }
        return 0L;
    }

    public TLRPC$User getContextBotUser() {
        return this.foundContextBot;
    }

    public String getContextBotName() {
        TLRPC$User tLRPC$User = this.foundContextBot;
        return tLRPC$User != null ? tLRPC$User.username : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processFoundUser(TLRPC$User user) {
        ChatActivity chatActivity;
        TLRPC$Chat currentChat;
        this.contextUsernameReqid = 0;
        this.locationProvider.stop();
        if (user != null && user.bot && user.bot_inline_placeholder != null) {
            this.foundContextBot = user;
            ChatActivity chatActivity2 = this.parentFragment;
            if (chatActivity2 != null && (currentChat = chatActivity2.getCurrentChat()) != null) {
                boolean zCanSendStickers = ChatObject.canSendStickers(currentChat);
                this.inlineMediaEnabled = zCanSendStickers;
                if (!zCanSendStickers) {
                    notifyDataSetChanged();
                    this.delegate.needChangePanelVisibility(true);
                    return;
                }
            }
            if (this.foundContextBot.bot_inline_geo) {
                if (!MessagesController.getNotificationsSettings(this.currentAccount).getBoolean("inlinegeo_" + this.foundContextBot.id, false) && (chatActivity = this.parentFragment) != null && chatActivity.getParentActivity() != null) {
                    final TLRPC$User tLRPC$User = this.foundContextBot;
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.parentFragment.getParentActivity());
                    builder.setTitle(LocaleController.getString("ShareYouLocationTitle", R.string.ShareYouLocationTitle));
                    builder.setMessage(LocaleController.getString("ShareYouLocationInline", R.string.ShareYouLocationInline));
                    final boolean[] zArr = new boolean[1];
                    builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$kJE_JReRyTLz07Wk1RcjefLLIpA
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$processFoundUser$2$MentionsAdapter(zArr, tLRPC$User, dialogInterface, i);
                        }
                    });
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$lSFgDizN9OKU8OaA6uclU-33CEM
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$processFoundUser$3$MentionsAdapter(zArr, dialogInterface, i);
                        }
                    });
                    this.parentFragment.showDialog(builder.create(), new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$Z3TgaDL--7TRDvIbepogYddjzy0
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.f$0.lambda$processFoundUser$4$MentionsAdapter(zArr, dialogInterface);
                        }
                    });
                } else {
                    checkLocationPermissionsOrStart();
                }
            }
        } else {
            this.foundContextBot = null;
            this.inlineMediaEnabled = true;
        }
        if (this.foundContextBot == null) {
            this.noUserName = true;
            return;
        }
        MentionsAdapterDelegate mentionsAdapterDelegate = this.delegate;
        if (mentionsAdapterDelegate != null) {
            mentionsAdapterDelegate.onContextSearch(true);
        }
        searchForContextBotResults(true, this.foundContextBot, this.searchingContextQuery, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processFoundUser$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processFoundUser$2$MentionsAdapter(boolean[] zArr, TLRPC$User tLRPC$User, DialogInterface dialogInterface, int i) {
        zArr[0] = true;
        if (tLRPC$User != null) {
            MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean("inlinegeo_" + tLRPC$User.id, true).commit();
            checkLocationPermissionsOrStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processFoundUser$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processFoundUser$3$MentionsAdapter(boolean[] zArr, DialogInterface dialogInterface, int i) {
        zArr[0] = true;
        onLocationUnavailable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processFoundUser$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processFoundUser$4$MentionsAdapter(boolean[] zArr, DialogInterface dialogInterface) {
        if (zArr[0]) {
            return;
        }
        onLocationUnavailable();
    }

    private void searchForContextBot(final String username, final String query) {
        String str;
        String str2;
        String str3;
        TLRPC$User tLRPC$User = this.foundContextBot;
        if (tLRPC$User == null || (str2 = tLRPC$User.username) == null || !str2.equals(username) || (str3 = this.searchingContextQuery) == null || !str3.equals(query)) {
            this.searchResultBotContext = null;
            this.searchResultBotContextSwitch = null;
            notifyDataSetChanged();
            if (this.foundContextBot != null) {
                if (!this.inlineMediaEnabled && username != null && query != null) {
                    return;
                } else {
                    this.delegate.needChangePanelVisibility(false);
                }
            }
            Runnable runnable = this.contextQueryRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.contextQueryRunnable = null;
            }
            if (TextUtils.isEmpty(username) || ((str = this.searchingContextUsername) != null && !str.equals(username))) {
                if (this.contextUsernameReqid != 0) {
                    ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.contextUsernameReqid, true);
                    this.contextUsernameReqid = 0;
                }
                if (this.contextQueryReqid != 0) {
                    ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.contextQueryReqid, true);
                    this.contextQueryReqid = 0;
                }
                this.foundContextBot = null;
                this.inlineMediaEnabled = true;
                this.searchingContextUsername = null;
                this.searchingContextQuery = null;
                this.locationProvider.stop();
                this.noUserName = false;
                MentionsAdapterDelegate mentionsAdapterDelegate = this.delegate;
                if (mentionsAdapterDelegate != null) {
                    mentionsAdapterDelegate.onContextSearch(false);
                }
                if (username == null || username.length() == 0) {
                    return;
                }
            }
            if (query == null) {
                if (this.contextQueryReqid != 0) {
                    ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.contextQueryReqid, true);
                    this.contextQueryReqid = 0;
                }
                this.searchingContextQuery = null;
                MentionsAdapterDelegate mentionsAdapterDelegate2 = this.delegate;
                if (mentionsAdapterDelegate2 != null) {
                    mentionsAdapterDelegate2.onContextSearch(false);
                    return;
                }
                return;
            }
            MentionsAdapterDelegate mentionsAdapterDelegate3 = this.delegate;
            if (mentionsAdapterDelegate3 != null) {
                if (this.foundContextBot != null) {
                    mentionsAdapterDelegate3.onContextSearch(true);
                } else if (username.equals("gif")) {
                    this.searchingContextUsername = "gif";
                    this.delegate.onContextSearch(false);
                }
            }
            MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
            MessagesStorage messagesStorage = MessagesStorage.getInstance(this.currentAccount);
            this.searchingContextQuery = query;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(query, username, messagesController, messagesStorage);
            this.contextQueryRunnable = anonymousClass4;
            AndroidUtilities.runOnUIThread(anonymousClass4, 400L);
        }
    }

    /* renamed from: ir.eitaa.ui.Adapters.MentionsAdapter$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ MessagesController val$messagesController;
        final /* synthetic */ MessagesStorage val$messagesStorage;
        final /* synthetic */ String val$query;
        final /* synthetic */ String val$username;

        AnonymousClass4(final String val$query, final String val$username, final MessagesController val$messagesController, final MessagesStorage val$messagesStorage) {
            this.val$query = val$query;
            this.val$username = val$username;
            this.val$messagesController = val$messagesController;
            this.val$messagesStorage = val$messagesStorage;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MentionsAdapter.this.contextQueryRunnable != this) {
                return;
            }
            MentionsAdapter.this.contextQueryRunnable = null;
            if (MentionsAdapter.this.foundContextBot != null || MentionsAdapter.this.noUserName) {
                if (MentionsAdapter.this.noUserName) {
                    return;
                }
                MentionsAdapter mentionsAdapter = MentionsAdapter.this;
                mentionsAdapter.searchForContextBotResults(true, mentionsAdapter.foundContextBot, this.val$query, "");
                return;
            }
            MentionsAdapter.this.searchingContextUsername = this.val$username;
            TLObject userOrChat = this.val$messagesController.getUserOrChat(MentionsAdapter.this.searchingContextUsername);
            if (userOrChat instanceof TLRPC$User) {
                MentionsAdapter.this.processFoundUser((TLRPC$User) userOrChat);
                return;
            }
            TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
            tLRPC$TL_contacts_resolveUsername.username = MentionsAdapter.this.searchingContextUsername;
            MentionsAdapter mentionsAdapter2 = MentionsAdapter.this;
            ConnectionsManager connectionsManager = ConnectionsManager.getInstance(mentionsAdapter2.currentAccount);
            final String str = this.val$username;
            final MessagesController messagesController = this.val$messagesController;
            final MessagesStorage messagesStorage = this.val$messagesStorage;
            mentionsAdapter2.contextUsernameReqid = connectionsManager.sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$4$FEuppeTIjEhBK0sWEexLBBUyI_g
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$run$1$MentionsAdapter$4(str, messagesController, messagesStorage, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$1$MentionsAdapter$4(final String str, final MessagesController messagesController, final MessagesStorage messagesStorage, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$4$RxkHos2_eskiMlCK0bnmB2Q4DhY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$MentionsAdapter$4(str, tLRPC$TL_error, tLObject, messagesController, messagesStorage);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$MentionsAdapter$4(String str, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, MessagesController messagesController, MessagesStorage messagesStorage) {
            if (MentionsAdapter.this.searchingContextUsername == null || !MentionsAdapter.this.searchingContextUsername.equals(str)) {
                return;
            }
            TLRPC$User tLRPC$User = null;
            if (tLRPC$TL_error == null) {
                TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
                if (!tLRPC$TL_contacts_resolvedPeer.users.isEmpty()) {
                    TLRPC$User tLRPC$User2 = tLRPC$TL_contacts_resolvedPeer.users.get(0);
                    messagesController.putUser(tLRPC$User2, false);
                    messagesStorage.putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, null, true, true);
                    tLRPC$User = tLRPC$User2;
                }
            }
            MentionsAdapter.this.processFoundUser(tLRPC$User);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLocationUnavailable() {
        TLRPC$User tLRPC$User = this.foundContextBot;
        if (tLRPC$User == null || !tLRPC$User.bot_inline_geo) {
            return;
        }
        Location location = new Location("network");
        this.lastKnownLocation = location;
        location.setLatitude(-1000.0d);
        this.lastKnownLocation.setLongitude(-1000.0d);
        searchForContextBotResults(true, this.foundContextBot, this.searchingContextQuery, "");
    }

    private void checkLocationPermissionsOrStart() {
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity == null || chatActivity.getParentActivity() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && this.parentFragment.getParentActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            this.parentFragment.getParentActivity().requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
            return;
        }
        TLRPC$User tLRPC$User = this.foundContextBot;
        if (tLRPC$User == null || !tLRPC$User.bot_inline_geo) {
            return;
        }
        this.locationProvider.start();
    }

    public void setSearchingMentions(boolean value) {
        this.isSearchingMentions = value;
    }

    public String getBotCaption() {
        TLRPC$User tLRPC$User = this.foundContextBot;
        if (tLRPC$User != null) {
            return tLRPC$User.bot_inline_placeholder;
        }
        return null;
    }

    public void searchForContextBotForNextOffset() {
        String str;
        TLRPC$User tLRPC$User;
        String str2;
        if (this.contextQueryReqid != 0 || (str = this.nextQueryOffset) == null || str.length() == 0 || (tLRPC$User = this.foundContextBot) == null || (str2 = this.searchingContextQuery) == null) {
            return;
        }
        searchForContextBotResults(true, tLRPC$User, str2, this.nextQueryOffset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchForContextBotResults(final boolean cache, final TLRPC$User user, final String query, final String offset) {
        Location location;
        if (this.contextQueryReqid != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.contextQueryReqid, true);
            this.contextQueryReqid = 0;
        }
        if (!this.inlineMediaEnabled) {
            MentionsAdapterDelegate mentionsAdapterDelegate = this.delegate;
            if (mentionsAdapterDelegate != null) {
                mentionsAdapterDelegate.onContextSearch(false);
                return;
            }
            return;
        }
        if (query == null || user == null) {
            this.searchingContextQuery = null;
            return;
        }
        if (user.bot_inline_geo && this.lastKnownLocation == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.dialog_id);
        sb.append("_");
        sb.append(query);
        sb.append("_");
        sb.append(offset);
        sb.append("_");
        sb.append(this.dialog_id);
        sb.append("_");
        sb.append(user.id);
        sb.append("_");
        sb.append((!user.bot_inline_geo || this.lastKnownLocation.getLatitude() == -1000.0d) ? "" : Double.valueOf(this.lastKnownLocation.getLatitude() + this.lastKnownLocation.getLongitude()));
        final String string = sb.toString();
        final MessagesStorage messagesStorage = MessagesStorage.getInstance(this.currentAccount);
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$5r2KAYoWzvJ48JkrRyRaLqpkIT4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$searchForContextBotResults$6$MentionsAdapter(query, cache, user, offset, messagesStorage, string, tLObject, tLRPC$TL_error);
            }
        };
        if (cache) {
            messagesStorage.getBotCache(string, requestDelegate);
            return;
        }
        TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
        tLRPC$TL_messages_getInlineBotResults.bot = MessagesController.getInstance(this.currentAccount).getInputUser(user);
        tLRPC$TL_messages_getInlineBotResults.query = query;
        tLRPC$TL_messages_getInlineBotResults.offset = offset;
        if (user.bot_inline_geo && (location = this.lastKnownLocation) != null && location.getLatitude() != -1000.0d) {
            tLRPC$TL_messages_getInlineBotResults.flags |= 1;
            TLRPC$TL_inputGeoPoint tLRPC$TL_inputGeoPoint = new TLRPC$TL_inputGeoPoint();
            tLRPC$TL_messages_getInlineBotResults.geo_point = tLRPC$TL_inputGeoPoint;
            tLRPC$TL_inputGeoPoint.lat = AndroidUtilities.fixLocationCoord(this.lastKnownLocation.getLatitude());
            tLRPC$TL_messages_getInlineBotResults.geo_point._long = AndroidUtilities.fixLocationCoord(this.lastKnownLocation.getLongitude());
        }
        if (DialogObject.isEncryptedDialog(this.dialog_id)) {
            tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
        } else {
            tLRPC$TL_messages_getInlineBotResults.peer = MessagesController.getInstance(this.currentAccount).getInputPeer(this.dialog_id);
        }
        this.contextQueryReqid = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, requestDelegate, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchForContextBotResults$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchForContextBotResults$6$MentionsAdapter(final String str, final boolean z, final TLRPC$User tLRPC$User, final String str2, final MessagesStorage messagesStorage, final String str3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$j8RHz6xBX2GcB9PWCiM75cat27A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchForContextBotResults$5$MentionsAdapter(str, z, tLObject, tLRPC$User, str2, messagesStorage, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchForContextBotResults$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchForContextBotResults$5$MentionsAdapter(String str, boolean z, TLObject tLObject, TLRPC$User tLRPC$User, String str2, MessagesStorage messagesStorage, String str3) {
        boolean z2;
        if (str.equals(this.searchingContextQuery)) {
            this.contextQueryReqid = 0;
            if (z && tLObject == null) {
                searchForContextBotResults(false, tLRPC$User, str, str2);
            } else {
                MentionsAdapterDelegate mentionsAdapterDelegate = this.delegate;
                if (mentionsAdapterDelegate != null) {
                    mentionsAdapterDelegate.onContextSearch(false);
                }
            }
            if (tLObject instanceof TLRPC$TL_messages_botResults) {
                TLRPC$TL_messages_botResults tLRPC$TL_messages_botResults = (TLRPC$TL_messages_botResults) tLObject;
                if (!z && tLRPC$TL_messages_botResults.cache_time != 0) {
                    messagesStorage.saveBotCache(str3, tLRPC$TL_messages_botResults);
                }
                this.nextQueryOffset = tLRPC$TL_messages_botResults.next_offset;
                if (this.searchResultBotContextSwitch == null) {
                    this.searchResultBotContextSwitch = tLRPC$TL_messages_botResults.switch_pm;
                }
                int i = 0;
                while (i < tLRPC$TL_messages_botResults.results.size()) {
                    TLRPC$BotInlineResult tLRPC$BotInlineResult = tLRPC$TL_messages_botResults.results.get(i);
                    if (!(tLRPC$BotInlineResult.document instanceof TLRPC$TL_document) && !(tLRPC$BotInlineResult.photo instanceof TLRPC$TL_photo) && !"game".equals(tLRPC$BotInlineResult.type) && tLRPC$BotInlineResult.content == null && (tLRPC$BotInlineResult.send_message instanceof TLRPC$TL_botInlineMessageMediaAuto)) {
                        tLRPC$TL_messages_botResults.results.remove(i);
                        i--;
                    }
                    tLRPC$BotInlineResult.query_id = tLRPC$TL_messages_botResults.query_id;
                    i++;
                }
                if (this.searchResultBotContext == null || str2.length() == 0) {
                    this.searchResultBotContext = tLRPC$TL_messages_botResults.results;
                    this.contextMedia = tLRPC$TL_messages_botResults.gallery;
                    z2 = false;
                } else {
                    this.searchResultBotContext.addAll(tLRPC$TL_messages_botResults.results);
                    if (tLRPC$TL_messages_botResults.results.isEmpty()) {
                        this.nextQueryOffset = "";
                    }
                    z2 = true;
                }
                Runnable runnable = this.cancelDelayRunnable;
                if (runnable != null) {
                    AndroidUtilities.cancelRunOnUIThread(runnable);
                    this.cancelDelayRunnable = null;
                }
                this.searchResultHashtags = null;
                this.stickers = null;
                this.searchResultUsernames = null;
                this.searchResultUsernamesMap = null;
                this.searchResultCommands = null;
                this.searchResultSuggestions = null;
                this.searchResultCommandsHelp = null;
                this.searchResultCommandsUsers = null;
                if (z2) {
                    int i2 = this.searchResultBotContextSwitch != null ? 1 : 0;
                    notifyItemChanged(((this.searchResultBotContext.size() - tLRPC$TL_messages_botResults.results.size()) + i2) - 1);
                    notifyItemRangeInserted((this.searchResultBotContext.size() - tLRPC$TL_messages_botResults.results.size()) + i2, tLRPC$TL_messages_botResults.results.size());
                } else {
                    notifyDataSetChanged();
                }
                this.delegate.needChangePanelVisibility((this.searchResultBotContext.isEmpty() && this.searchResultBotContextSwitch == null) ? false : true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03e9  */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void searchUsernameOrHashtag(java.lang.String r21, int r22, java.util.ArrayList<ir.eitaa.messenger.MessageObject> r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 1849
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Adapters.MentionsAdapter.searchUsernameOrHashtag(java.lang.String, int, java.util.ArrayList, boolean, boolean):void");
    }

    /* renamed from: ir.eitaa.ui.Adapters.MentionsAdapter$5, reason: invalid class name */
    class AnonymousClass5 implements Comparator<StickerResult>, j$.util.Comparator {
        final /* synthetic */ ArrayList val$favsStickers;
        final /* synthetic */ ArrayList val$recentStickers;

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        AnonymousClass5(final ArrayList val$favsStickers, final ArrayList val$recentStickers) {
            this.val$favsStickers = val$favsStickers;
            this.val$recentStickers = val$recentStickers;
        }

        private int getIndex(StickerResult result) {
            for (int i = 0; i < this.val$favsStickers.size(); i++) {
                if (((TLRPC$Document) this.val$favsStickers.get(i)).id == result.sticker.id) {
                    return i + 2000000;
                }
            }
            for (int i2 = 0; i2 < Math.min(20, this.val$recentStickers.size()); i2++) {
                if (((TLRPC$Document) this.val$recentStickers.get(i2)).id == result.sticker.id) {
                    return (this.val$recentStickers.size() - i2) + MediaController.VIDEO_BITRATE_480;
                }
            }
            return -1;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(StickerResult lhs, StickerResult rhs) {
            boolean zIsAnimatedStickerDocument = MessageObject.isAnimatedStickerDocument(lhs.sticker, true);
            if (zIsAnimatedStickerDocument != MessageObject.isAnimatedStickerDocument(rhs.sticker, true)) {
                return zIsAnimatedStickerDocument ? -1 : 1;
            }
            int index = getIndex(lhs);
            int index2 = getIndex(rhs);
            if (index > index2) {
                return -1;
            }
            return index < index2 ? 1 : 0;
        }
    }

    /* renamed from: ir.eitaa.ui.Adapters.MentionsAdapter$6, reason: invalid class name */
    class AnonymousClass6 implements java.util.Comparator<TLObject>, j$.util.Comparator {
        final /* synthetic */ LongSparseArray val$newMap;
        final /* synthetic */ ArrayList val$users;

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        AnonymousClass6(final LongSparseArray val$newMap, final ArrayList val$users) {
            this.val$newMap = val$newMap;
            this.val$users = val$users;
        }

        private long getId(TLObject object) {
            if (object instanceof TLRPC$User) {
                return ((TLRPC$User) object).id;
            }
            return -((TLRPC$Chat) object).id;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(TLObject lhs, TLObject rhs) {
            long id = getId(lhs);
            long id2 = getId(rhs);
            if (this.val$newMap.indexOfKey(id) >= 0 && this.val$newMap.indexOfKey(id2) >= 0) {
                return 0;
            }
            if (this.val$newMap.indexOfKey(id) >= 0) {
                return -1;
            }
            if (this.val$newMap.indexOfKey(id2) >= 0) {
                return 1;
            }
            int iIndexOf = this.val$users.indexOf(Long.valueOf(id));
            int iIndexOf2 = this.val$users.indexOf(Long.valueOf(id2));
            if (iIndexOf != -1 && iIndexOf2 != -1) {
                if (iIndexOf < iIndexOf2) {
                    return -1;
                }
                return iIndexOf == iIndexOf2 ? 0 : 1;
            }
            if (iIndexOf == -1 || iIndexOf2 != -1) {
                return (iIndexOf != -1 || iIndexOf2 == -1) ? 0 : 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchUsernameOrHashtag$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchUsernameOrHashtag$7$MentionsAdapter(ArrayList arrayList, LongSparseArray longSparseArray) {
        this.cancelDelayRunnable = null;
        showUsersResult(arrayList, longSparseArray, true);
    }

    /* renamed from: ir.eitaa.ui.Adapters.MentionsAdapter$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ TLRPC$Chat val$chat;
        final /* synthetic */ MessagesController val$messagesController;
        final /* synthetic */ LongSparseArray val$newMap;
        final /* synthetic */ ArrayList val$newResult;
        final /* synthetic */ int val$threadId;
        final /* synthetic */ String val$usernameString;

        AnonymousClass7(final TLRPC$Chat val$chat, final String val$usernameString, final int val$threadId, final ArrayList val$newResult, final LongSparseArray val$newMap, final MessagesController val$messagesController) {
            this.val$chat = val$chat;
            this.val$usernameString = val$usernameString;
            this.val$threadId = val$threadId;
            this.val$newResult = val$newResult;
            this.val$newMap = val$newMap;
            this.val$messagesController = val$messagesController;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MentionsAdapter.this.searchGlobalRunnable != this) {
                return;
            }
            TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
            tLRPC$TL_channels_getParticipants.channel = MessagesController.getInputChannel(this.val$chat);
            tLRPC$TL_channels_getParticipants.limit = 20;
            tLRPC$TL_channels_getParticipants.offset = 0;
            TLRPC$TL_channelParticipantsMentions tLRPC$TL_channelParticipantsMentions = new TLRPC$TL_channelParticipantsMentions();
            int i = tLRPC$TL_channelParticipantsMentions.flags | 1;
            tLRPC$TL_channelParticipantsMentions.flags = i;
            tLRPC$TL_channelParticipantsMentions.q = this.val$usernameString;
            int i2 = this.val$threadId;
            if (i2 != 0) {
                tLRPC$TL_channelParticipantsMentions.flags = i | 2;
                tLRPC$TL_channelParticipantsMentions.top_msg_id = i2;
            }
            tLRPC$TL_channels_getParticipants.filter = tLRPC$TL_channelParticipantsMentions;
            final int iAccess$1704 = MentionsAdapter.access$1704(MentionsAdapter.this);
            MentionsAdapter mentionsAdapter = MentionsAdapter.this;
            ConnectionsManager connectionsManager = ConnectionsManager.getInstance(mentionsAdapter.currentAccount);
            final ArrayList arrayList = this.val$newResult;
            final LongSparseArray longSparseArray = this.val$newMap;
            final MessagesController messagesController = this.val$messagesController;
            mentionsAdapter.channelReqId = connectionsManager.sendRequest(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$7$OhZeWwU5ReupojCeg9DRdnAcp-A
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$run$1$MentionsAdapter$7(iAccess$1704, arrayList, longSparseArray, messagesController, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$1$MentionsAdapter$7(final int i, final ArrayList arrayList, final LongSparseArray longSparseArray, final MessagesController messagesController, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$7$o5FD9pnRc3yGvvIAVANqyLmmr8U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$MentionsAdapter$7(i, arrayList, longSparseArray, tLRPC$TL_error, tLObject, messagesController);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$MentionsAdapter$7(int i, ArrayList arrayList, LongSparseArray longSparseArray, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, MessagesController messagesController) {
            if (MentionsAdapter.this.channelReqId != 0 && i == MentionsAdapter.this.channelLastReqId && MentionsAdapter.this.searchResultUsernamesMap != null && MentionsAdapter.this.searchResultUsernames != null) {
                MentionsAdapter.this.showUsersResult(arrayList, longSparseArray, false);
                if (tLRPC$TL_error == null) {
                    TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
                    messagesController.putUsers(tLRPC$TL_channels_channelParticipants.users, false);
                    messagesController.putChats(tLRPC$TL_channels_channelParticipants.chats, false);
                    MentionsAdapter.this.searchResultUsernames.isEmpty();
                    if (!tLRPC$TL_channels_channelParticipants.participants.isEmpty()) {
                        long clientUserId = UserConfig.getInstance(MentionsAdapter.this.currentAccount).getClientUserId();
                        for (int i2 = 0; i2 < tLRPC$TL_channels_channelParticipants.participants.size(); i2++) {
                            long peerId = MessageObject.getPeerId(tLRPC$TL_channels_channelParticipants.participants.get(i2).peer);
                            if (MentionsAdapter.this.searchResultUsernamesMap.indexOfKey(peerId) < 0 && (MentionsAdapter.this.isSearchingMentions || peerId != clientUserId)) {
                                if (peerId > 0) {
                                    TLRPC$User user = messagesController.getUser(Long.valueOf(peerId));
                                    if (user == null) {
                                        return;
                                    } else {
                                        MentionsAdapter.this.searchResultUsernames.add(user);
                                    }
                                } else {
                                    TLRPC$Chat chat = messagesController.getChat(Long.valueOf(-peerId));
                                    if (chat == null) {
                                        return;
                                    } else {
                                        MentionsAdapter.this.searchResultUsernames.add(chat);
                                    }
                                }
                            }
                        }
                    }
                }
                MentionsAdapter.this.notifyDataSetChanged();
                MentionsAdapter.this.delegate.needChangePanelVisibility(!MentionsAdapter.this.searchResultUsernames.isEmpty());
            }
            MentionsAdapter.this.channelReqId = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchUsernameOrHashtag$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchUsernameOrHashtag$8$MentionsAdapter(ArrayList arrayList, String str) {
        this.searchResultSuggestions = arrayList;
        this.searchResultHashtags = null;
        this.stickers = null;
        this.searchResultUsernames = null;
        this.searchResultUsernamesMap = null;
        this.searchResultCommands = null;
        this.searchResultCommandsHelp = null;
        this.searchResultCommandsUsers = null;
        notifyDataSetChanged();
        MentionsAdapterDelegate mentionsAdapterDelegate = this.delegate;
        ArrayList<MediaDataController.KeywordResult> arrayList2 = this.searchResultSuggestions;
        mentionsAdapterDelegate.needChangePanelVisibility((arrayList2 == null || arrayList2.isEmpty()) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUsersResult(ArrayList<TLObject> newResult, LongSparseArray<TLObject> newMap, boolean notify) {
        this.searchResultUsernames = newResult;
        this.searchResultUsernamesMap = newMap;
        Runnable runnable = this.cancelDelayRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.cancelDelayRunnable = null;
        }
        if (notify) {
            notifyDataSetChanged();
            this.delegate.needChangePanelVisibility(!this.searchResultUsernames.isEmpty());
        }
    }

    public int getResultStartPosition() {
        return this.resultStartPosition;
    }

    public int getResultLength() {
        return this.resultLength;
    }

    public ArrayList<TLRPC$BotInlineResult> getSearchResultBotContext() {
        return this.searchResultBotContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.foundContextBot != null && !this.inlineMediaEnabled) {
            return 1;
        }
        ArrayList<StickerResult> arrayList = this.stickers;
        if (arrayList != null) {
            return arrayList.size();
        }
        ArrayList<TLRPC$BotInlineResult> arrayList2 = this.searchResultBotContext;
        if (arrayList2 != null) {
            return arrayList2.size() + (this.searchResultBotContextSwitch == null ? 0 : 1);
        }
        ArrayList<TLObject> arrayList3 = this.searchResultUsernames;
        if (arrayList3 != null) {
            return arrayList3.size();
        }
        ArrayList<String> arrayList4 = this.searchResultHashtags;
        if (arrayList4 != null) {
            return arrayList4.size();
        }
        ArrayList<String> arrayList5 = this.searchResultCommands;
        if (arrayList5 != null) {
            return arrayList5.size();
        }
        ArrayList<MediaDataController.KeywordResult> arrayList6 = this.searchResultSuggestions;
        if (arrayList6 != null) {
            return arrayList6.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.stickers != null) {
            return 4;
        }
        if (this.foundContextBot != null && !this.inlineMediaEnabled) {
            return 3;
        }
        if (this.searchResultBotContext != null) {
            return (position != 0 || this.searchResultBotContextSwitch == null) ? 1 : 2;
        }
        return 0;
    }

    public void addHashtagsFromMessage(CharSequence message) {
        this.searchAdapterHelper.addHashtagsFromMessage(message);
    }

    public int getItemPosition(int i) {
        return (this.searchResultBotContext == null || this.searchResultBotContextSwitch == null) ? i : i - 1;
    }

    public Object getItemParent(int i) {
        ArrayList<StickerResult> arrayList = this.stickers;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.stickers.get(i).parent;
    }

    public Object getItem(int i) {
        ArrayList<StickerResult> arrayList = this.stickers;
        if (arrayList != null) {
            if (i < 0 || i >= arrayList.size()) {
                return null;
            }
            return this.stickers.get(i).sticker;
        }
        ArrayList<TLRPC$BotInlineResult> arrayList2 = this.searchResultBotContext;
        if (arrayList2 != null) {
            TLRPC$TL_inlineBotSwitchPM tLRPC$TL_inlineBotSwitchPM = this.searchResultBotContextSwitch;
            if (tLRPC$TL_inlineBotSwitchPM != null) {
                if (i == 0) {
                    return tLRPC$TL_inlineBotSwitchPM;
                }
                i--;
            }
            if (i < 0 || i >= arrayList2.size()) {
                return null;
            }
            return this.searchResultBotContext.get(i);
        }
        ArrayList<TLObject> arrayList3 = this.searchResultUsernames;
        if (arrayList3 != null) {
            if (i < 0 || i >= arrayList3.size()) {
                return null;
            }
            return this.searchResultUsernames.get(i);
        }
        ArrayList<String> arrayList4 = this.searchResultHashtags;
        if (arrayList4 != null) {
            if (i < 0 || i >= arrayList4.size()) {
                return null;
            }
            return this.searchResultHashtags.get(i);
        }
        ArrayList<MediaDataController.KeywordResult> arrayList5 = this.searchResultSuggestions;
        if (arrayList5 != null) {
            if (i < 0 || i >= arrayList5.size()) {
                return null;
            }
            return this.searchResultSuggestions.get(i);
        }
        ArrayList<String> arrayList6 = this.searchResultCommands;
        if (arrayList6 == null || i < 0 || i >= arrayList6.size()) {
            return null;
        }
        ArrayList<TLRPC$User> arrayList7 = this.searchResultCommandsUsers;
        if (arrayList7 != null && (this.botsCount != 1 || (this.info instanceof TLRPC$TL_channelFull))) {
            if (arrayList7.get(i) == null) {
                return String.format("%s", this.searchResultCommands.get(i));
            }
            Object[] objArr = new Object[2];
            objArr[0] = this.searchResultCommands.get(i);
            objArr[1] = this.searchResultCommandsUsers.get(i) != null ? this.searchResultCommandsUsers.get(i).username : "";
            return String.format("%s@%s", objArr);
        }
        return this.searchResultCommands.get(i);
    }

    public boolean isLongClickEnabled() {
        return (this.searchResultHashtags == null && this.searchResultCommands == null) ? false : true;
    }

    public boolean isBotCommands() {
        return this.searchResultCommands != null;
    }

    public boolean isStickers() {
        return this.stickers != null;
    }

    public boolean isBotContext() {
        return this.searchResultBotContext != null;
    }

    public boolean isBannedInline() {
        return (this.foundContextBot == null || this.inlineMediaEnabled) ? false : true;
    }

    public boolean isMediaLayout() {
        return this.contextMedia || this.stickers != null;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        return (this.foundContextBot == null || this.inlineMediaEnabled) && this.stickers == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreateViewHolder$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreateViewHolder$9$MentionsAdapter(ContextLinkCell contextLinkCell) {
        this.delegate.onContextClick(contextLinkCell.getResult());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View botSwitchCell;
        if (i == 0) {
            MentionCell mentionCell = new MentionCell(this.mContext);
            mentionCell.setIsDarkTheme(this.isDarkTheme);
            botSwitchCell = mentionCell;
        } else if (i == 1) {
            ContextLinkCell contextLinkCell = new ContextLinkCell(this.mContext);
            contextLinkCell.setDelegate(new ContextLinkCell.ContextLinkCellDelegate() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$MentionsAdapter$3rtTEfftFTmUqohY38ANg2qANo0
                @Override // ir.eitaa.ui.Cells.ContextLinkCell.ContextLinkCellDelegate
                public final void didPressedImage(ContextLinkCell contextLinkCell2) {
                    this.f$0.lambda$onCreateViewHolder$9$MentionsAdapter(contextLinkCell2);
                }
            });
            botSwitchCell = contextLinkCell;
        } else if (i == 2) {
            botSwitchCell = new BotSwitchCell(this.mContext);
        } else if (i == 3) {
            TextView textView = new TextView(this.mContext);
            textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            textView.setTextSize(1, 14.0f);
            textView.setTypeface(AndroidUtilities.getFontFamily(false));
            textView.setTextColor(getThemedColor("windowBackgroundWhiteGrayText2"));
            botSwitchCell = textView;
        } else {
            botSwitchCell = new StickerCell(this.mContext);
        }
        return new RecyclerListView.Holder(botSwitchCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 4) {
            StickerCell stickerCell = (StickerCell) holder.itemView;
            StickerResult stickerResult = this.stickers.get(position);
            stickerCell.setSticker(stickerResult.sticker, stickerResult.parent);
            stickerCell.setClearsInputField(true);
            return;
        }
        if (itemViewType == 3) {
            TextView textView = (TextView) holder.itemView;
            TLRPC$Chat currentChat = this.parentFragment.getCurrentChat();
            if (currentChat != null) {
                if (!ChatObject.hasAdminRights(currentChat) && (tLRPC$TL_chatBannedRights = currentChat.default_banned_rights) != null && tLRPC$TL_chatBannedRights.send_inline) {
                    textView.setText(LocaleController.getString("GlobalAttachInlineRestricted", R.string.GlobalAttachInlineRestricted));
                    return;
                } else if (AndroidUtilities.isBannedForever(currentChat.banned_rights)) {
                    textView.setText(LocaleController.getString("AttachInlineRestrictedForever", R.string.AttachInlineRestrictedForever));
                    return;
                } else {
                    textView.setText(LocaleController.formatString("AttachInlineRestricted", R.string.AttachInlineRestricted, LocaleController.formatDateForBan(currentChat.banned_rights.until_date)));
                    return;
                }
            }
            return;
        }
        if (this.searchResultBotContext != null) {
            boolean z = this.searchResultBotContextSwitch != null;
            if (holder.getItemViewType() == 2) {
                if (z) {
                    ((BotSwitchCell) holder.itemView).setText(this.searchResultBotContextSwitch.text);
                    return;
                }
                return;
            } else {
                if (z) {
                    position--;
                }
                ((ContextLinkCell) holder.itemView).setLink(this.searchResultBotContext.get(position), this.foundContextBot, this.contextMedia, position != this.searchResultBotContext.size() - 1, z && position == 0, "gif".equals(this.searchingContextUsername));
                return;
            }
        }
        ArrayList<TLObject> arrayList = this.searchResultUsernames;
        if (arrayList != null) {
            TLObject tLObject = arrayList.get(position);
            if (tLObject instanceof TLRPC$User) {
                ((MentionCell) holder.itemView).setUser((TLRPC$User) tLObject);
                return;
            } else {
                if (tLObject instanceof TLRPC$Chat) {
                    ((MentionCell) holder.itemView).setChat((TLRPC$Chat) tLObject);
                    return;
                }
                return;
            }
        }
        ArrayList<String> arrayList2 = this.searchResultHashtags;
        if (arrayList2 != null) {
            ((MentionCell) holder.itemView).setText(arrayList2.get(position));
            return;
        }
        ArrayList<MediaDataController.KeywordResult> arrayList3 = this.searchResultSuggestions;
        if (arrayList3 != null) {
            ((MentionCell) holder.itemView).setEmojiSuggestion(arrayList3.get(position));
            return;
        }
        ArrayList<String> arrayList4 = this.searchResultCommands;
        if (arrayList4 != null) {
            MentionCell mentionCell = (MentionCell) holder.itemView;
            String str = arrayList4.get(position);
            String str2 = this.searchResultCommandsHelp.get(position);
            ArrayList<TLRPC$User> arrayList5 = this.searchResultCommandsUsers;
            mentionCell.setBotCommand(str, str2, arrayList5 != null ? arrayList5.get(position) : null);
        }
    }

    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        TLRPC$User tLRPC$User;
        if (requestCode == 2 && (tLRPC$User = this.foundContextBot) != null && tLRPC$User.bot_inline_geo) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                this.locationProvider.start();
            } else {
                onLocationUnavailable();
            }
        }
    }

    public void doSomeStickersAction() {
        if (isStickers()) {
            if (this.mentionsStickersActionTracker == null) {
                EmojiView.ChooseStickerActionTracker chooseStickerActionTracker = new EmojiView.ChooseStickerActionTracker(this.currentAccount, this.dialog_id, this.threadMessageId) { // from class: ir.eitaa.ui.Adapters.MentionsAdapter.8
                    @Override // ir.eitaa.ui.Components.EmojiView.ChooseStickerActionTracker
                    public boolean isShown() {
                        return MentionsAdapter.this.isStickers();
                    }
                };
                this.mentionsStickersActionTracker = chooseStickerActionTracker;
                chooseStickerActionTracker.checkVisibility();
            }
            this.mentionsStickersActionTracker.doSomeAction();
        }
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
