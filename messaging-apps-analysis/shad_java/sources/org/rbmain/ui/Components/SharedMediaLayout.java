package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$ChannelParticipant;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatParticipant;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$InputUser;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator;
import org.rbmain.tgnet.TLRPC$TL_chatChannelParticipant;
import org.rbmain.tgnet.TLRPC$TL_chatParticipantAdmin;
import org.rbmain.tgnet.TLRPC$TL_chatParticipantCreator;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeImageSize;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterDocument;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterMusic;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterUrl;
import org.rbmain.tgnet.TLRPC$TL_inputUserEmpty;
import org.rbmain.tgnet.TLRPC$TL_messages_getCommonChats;
import org.rbmain.tgnet.TLRPC$TL_messages_search;
import org.rbmain.tgnet.TLRPC$TL_webPageEmpty;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.tgnet.TLRPC$messages_Chats;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.ArticleViewer;
import org.rbmain.ui.Cells.ChatActionCell;
import org.rbmain.ui.Cells.ContextLinkCell;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.ManageChatUserCell;
import org.rbmain.ui.Cells.ProfileSearchCell;
import org.rbmain.ui.Cells.SharedAudioCell;
import org.rbmain.ui.Cells.SharedDocumentCell;
import org.rbmain.ui.Cells.SharedLinkCell;
import org.rbmain.ui.Cells.SharedMediaSectionCell;
import org.rbmain.ui.Cells.SharedPhotoVideoCell;
import org.rbmain.ui.Cells.UserCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.FragmentContextView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ScrollSlidingTextTabStrip;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.PhotoViewer;
import org.rbmain.ui.ProfileActivity;

/* loaded from: classes5.dex */
public class SharedMediaLayout extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private static final Interpolator interpolator = new Interpolator() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda5
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return SharedMediaLayout.lambda$static$1(f);
        }
    };
    private ActionBar actionBar;
    private AnimatorSet actionModeAnimation;
    private LinearLayout actionModeLayout;
    private ArrayList<View> actionModeViews;
    private float additionalFloatingTranslation;
    private boolean animatingForward;
    private SharedDocumentsAdapter audioAdapter;
    private ArrayList<SharedAudioCell> audioCache;
    private ArrayList<SharedAudioCell> audioCellCache;
    private MediaSearchAdapter audioSearchAdapter;
    private boolean backAnimation;
    private BackDrawable backDrawable;
    private Paint backgroundPaint;
    private ArrayList<SharedPhotoVideoCell> cache;
    private int cantDeleteMessagesCount;
    private ArrayList<SharedPhotoVideoCell> cellCache;
    private ChatUsersAdapter chatUsersAdapter;
    private ImageView closeButton;
    private int columnsCount;
    private CommonGroupsAdapter commonGroupsAdapter;
    private ActionBarMenuItem deleteItem;
    private long dialog_id;
    private SharedDocumentsAdapter documentsAdapter;
    private MediaSearchAdapter documentsSearchAdapter;
    private AnimatorSet floatingDateAnimation;
    private ChatActionCell floatingDateView;
    private ActionBarMenuItem forwardItem;
    private FragmentContextView fragmentContextView;
    private GifAdapter gifAdapter;
    private ActionBarMenuItem gotoItem;
    private GroupUsersSearchAdapter groupUsersSearchAdapter;
    private int[] hasMedia;
    private Runnable hideFloatingDateRunnable;
    private boolean ignoreSearchCollapse;
    private TLRPC$ChatFull info;
    private int initialTab;
    private boolean isActionModeShowed;
    int lastMeasuredTopPadding;
    private SharedLinksAdapter linksAdapter;
    private MediaSearchAdapter linksSearchAdapter;
    private int maxSelectedCount;
    private int maximumVelocity;
    private boolean maybeStartTracking;
    private MediaPage[] mediaPages;
    private long mergeDialogId;
    private SharedPhotoVideoAdapter photoVideoAdapter;
    private Drawable pinnedHeaderShadowDrawable;
    private ProfileActivity profileActivity;
    private PhotoViewer.PhotoViewerProvider provider;
    private ScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private boolean scrolling;
    private ActionBarMenuItem searchItem;
    private int searchItemState;
    private boolean searchWas;
    private boolean searching;
    private LongSparseArray<MessageObject>[] selectedFiles;
    private NumberTextView selectedMessagesCountTextView;
    private View shadowLine;
    SharedLinkCell.SharedLinkCellDelegate sharedLinkCellDelegate;
    private SharedMediaData[] sharedMediaData;
    private SharedMediaPreloader sharedMediaPreloader;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private int startedTrackingX;
    private int startedTrackingY;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    int topPadding;
    private VelocityTracker velocityTracker;
    private SharedDocumentsAdapter voiceAdapter;

    public interface SharedMediaPreloaderDelegate {
        void mediaCountUpdated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$8(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$1(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    protected boolean canShowSearchItem() {
        return true;
    }

    protected boolean onMemberClick(TLRPC$ChatParticipant tLRPC$ChatParticipant, boolean z) {
        return false;
    }

    protected void onSearchStateChanged(boolean z) {
    }

    protected void onSelectedTabChanged() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class MediaPage extends FrameLayout {
        private ClippingImageView animatingImageView;
        private StickerEmptyView emptyView;
        private ExtendedGridLayoutManager layoutManager;
        private RecyclerListView listView;
        private FlickerLoadingView progressView;
        private RecyclerAnimationScrollHelper scrollHelper;
        private int selectedType;

        public MediaPage(Context context) {
            super(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        hideFloatingDateView(true);
    }

    public static class SharedMediaPreloader implements NotificationCenter.NotificationCenterDelegate {
        private long dialogId;
        private boolean mediaWasLoaded;
        private long mergeDialogId;
        private BaseFragment parentFragment;
        private SharedMediaData[] sharedMediaData;
        private int[] mediaCount = {-1, -1, -1, -1, -1, -1};
        private int[] mediaMergeCount = {-1, -1, -1, -1, -1, -1};
        private int[] lastMediaCount = {-1, -1, -1, -1, -1, -1};
        private int[] lastLoadMediaCount = {-1, -1, -1, -1, -1, -1};
        private ArrayList<SharedMediaPreloaderDelegate> delegates = new ArrayList<>();

        public SharedMediaPreloader(BaseFragment baseFragment) {
            this.parentFragment = baseFragment;
            if (baseFragment instanceof ChatActivity) {
                ChatActivity chatActivity = (ChatActivity) baseFragment;
                this.dialogId = chatActivity.getDialogId();
                this.mergeDialogId = chatActivity.getMergeDialogId();
            } else if (baseFragment instanceof ProfileActivity) {
                this.dialogId = ((ProfileActivity) baseFragment).getDialogId();
            }
            this.sharedMediaData = new SharedMediaData[6];
            int i = 0;
            while (true) {
                SharedMediaData[] sharedMediaDataArr = this.sharedMediaData;
                if (i < sharedMediaDataArr.length) {
                    sharedMediaDataArr[i] = new SharedMediaData();
                    this.sharedMediaData[i].setMaxId(0, ((int) this.dialogId) == 0 ? Long.MIN_VALUE : Long.MAX_VALUE);
                    i++;
                } else {
                    loadMediaCounts();
                    NotificationCenter notificationCenter = this.parentFragment.getNotificationCenter();
                    notificationCenter.addObserver(this, NotificationCenter.mediaCountsDidLoad);
                    notificationCenter.addObserver(this, NotificationCenter.mediaCountDidLoad);
                    notificationCenter.addObserver(this, NotificationCenter.didReceiveNewMessages);
                    notificationCenter.addObserver(this, NotificationCenter.messageReceivedByServer);
                    notificationCenter.addObserver(this, NotificationCenter.mediaDidLoad);
                    notificationCenter.addObserver(this, NotificationCenter.messagesDeleted);
                    notificationCenter.addObserver(this, NotificationCenter.replaceMessagesObjects);
                    notificationCenter.addObserver(this, NotificationCenter.chatInfoDidLoad);
                    return;
                }
            }
        }

        public void addDelegate(SharedMediaPreloaderDelegate sharedMediaPreloaderDelegate) {
            this.delegates.add(sharedMediaPreloaderDelegate);
        }

        public void removeDelegate(SharedMediaPreloaderDelegate sharedMediaPreloaderDelegate) {
            this.delegates.remove(sharedMediaPreloaderDelegate);
        }

        public void onDestroy(BaseFragment baseFragment) {
            if (baseFragment != this.parentFragment) {
                return;
            }
            this.delegates.clear();
            NotificationCenter notificationCenter = this.parentFragment.getNotificationCenter();
            notificationCenter.removeObserver(this, NotificationCenter.mediaCountsDidLoad);
            notificationCenter.removeObserver(this, NotificationCenter.mediaCountDidLoad);
            notificationCenter.removeObserver(this, NotificationCenter.didReceiveNewMessages);
            notificationCenter.removeObserver(this, NotificationCenter.messageReceivedByServer);
            notificationCenter.removeObserver(this, NotificationCenter.mediaDidLoad);
            notificationCenter.removeObserver(this, NotificationCenter.messagesDeleted);
            notificationCenter.removeObserver(this, NotificationCenter.replaceMessagesObjects);
            notificationCenter.removeObserver(this, NotificationCenter.chatInfoDidLoad);
        }

        public int[] getLastMediaCount() {
            return this.lastMediaCount;
        }

        public SharedMediaData[] getSharedMediaData() {
            return this.sharedMediaData;
        }

        /* JADX WARN: Removed duplicated region for block: B:157:0x02be  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
        @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void didReceivedNotification(int r12, int r13, java.lang.Object... r14) {
            /*
                Method dump skipped, instructions count: 943
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.SharedMediaLayout.SharedMediaPreloader.didReceivedNotification(int, int, java.lang.Object[]):void");
        }

        private void loadMediaCounts() {
            this.parentFragment.getMediaDataController().getMediaCounts(this.dialogId, this.parentFragment.getClassGuid());
            if (this.mergeDialogId != 0) {
                this.parentFragment.getMediaDataController().getMediaCounts(this.mergeDialogId, this.parentFragment.getClassGuid());
            }
        }

        private void setChatInfo(TLRPC$ChatFull tLRPC$ChatFull) {
            int i;
            if (tLRPC$ChatFull == null || (i = tLRPC$ChatFull.migrated_from_chat_id) == 0 || this.mergeDialogId != 0) {
                return;
            }
            this.mergeDialogId = -i;
            this.parentFragment.getMediaDataController().getMediaCounts(this.mergeDialogId, this.parentFragment.getClassGuid());
        }

        public boolean isMediaWasLoaded() {
            return this.mediaWasLoaded;
        }
    }

    public static class SharedMediaData {
        public boolean loading;
        public int totalCount;
        public ArrayList<MessageObject> messages = new ArrayList<>();
        public LongSparseArray<MessageObject>[] messagesDict = {new LongSparseArray<>(), new LongSparseArray<>()};
        public ArrayList<String> sections = new ArrayList<>();
        public HashMap<String, ArrayList<MessageObject>> sectionArrays = new HashMap<>();
        public boolean[] endReached = {false, true};
        public long[] max_id = {0, 0};

        public void setTotalCount(int i) {
            this.totalCount = i;
        }

        public void setMaxId(int i, long j) {
            this.max_id[i] = j;
        }

        public void setEndReached(int i, boolean z) {
            this.endReached[i] = z;
        }

        public boolean addMessage(MessageObject messageObject, int i, boolean z, boolean z2) {
            if (this.messagesDict[i].indexOfKey(messageObject.getId()) >= 0) {
                return false;
            }
            String str = LocaleController.getInstance().getCurrentLocale().getLanguage().equals("fa") ? messageObject.monthKeyPersian : messageObject.monthKey;
            ArrayList<MessageObject> arrayList = this.sectionArrays.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.sectionArrays.put(str, arrayList);
                if (z) {
                    this.sections.add(0, str);
                } else {
                    this.sections.add(str);
                }
            }
            if (z) {
                arrayList.add(0, messageObject);
                this.messages.add(0, messageObject);
            } else {
                arrayList.add(messageObject);
                this.messages.add(messageObject);
            }
            this.messagesDict[i].put(messageObject.getId(), messageObject);
            if (z2) {
                this.max_id[i] = Math.max(messageObject.getId(), this.max_id[i]);
                return true;
            }
            if (messageObject.getId() <= 0) {
                return true;
            }
            this.max_id[i] = Math.min(messageObject.getId(), this.max_id[i]);
            return true;
        }

        public MessageObject deleteMessage(long j, int i) {
            MessageObject messageObject = this.messagesDict[i].get(j);
            if (messageObject == null) {
                return null;
            }
            String str = LocaleController.getInstance().getCurrentLocale().getLanguage().equals("fa") ? messageObject.monthKeyPersian : messageObject.monthKey;
            ArrayList<MessageObject> arrayList = this.sectionArrays.get(str);
            if (arrayList == null) {
                return null;
            }
            arrayList.remove(messageObject);
            this.messages.remove(messageObject);
            this.messagesDict[i].remove(messageObject.getId());
            if (arrayList.isEmpty()) {
                this.sectionArrays.remove(str);
                this.sections.remove(str);
            }
            this.totalCount--;
            return messageObject;
        }

        public void replaceMid(long j, long j2) {
            MessageObject messageObject = this.messagesDict[0].get(j);
            if (messageObject != null) {
                this.messagesDict[0].remove(j);
                this.messagesDict[0].put(j2, messageObject);
                messageObject.messageOwner.id = j2;
                long[] jArr = this.max_id;
                jArr[0] = Math.min(j2, jArr[0]);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedMediaLayout(Context context, long j, SharedMediaPreloader sharedMediaPreloader, int i, ArrayList<Integer> arrayList, TLRPC$ChatFull tLRPC$ChatFull, boolean z, ProfileActivity profileActivity) throws Resources.NotFoundException {
        RecyclerListView.Holder holder;
        TLRPC$ChatFull tLRPC$ChatFull2;
        super(context);
        TLRPC$ChatFull tLRPC$ChatFull3 = tLRPC$ChatFull;
        this.maxSelectedCount = 30;
        this.mediaPages = new MediaPage[2];
        this.cellCache = new ArrayList<>(10);
        this.cache = new ArrayList<>(10);
        this.audioCellCache = new ArrayList<>(10);
        this.audioCache = new ArrayList<>(10);
        this.hideFloatingDateRunnable = new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.actionModeViews = new ArrayList<>();
        this.backgroundPaint = new Paint();
        this.selectedFiles = new LongSparseArray[]{new LongSparseArray<>(), new LongSparseArray<>()};
        this.columnsCount = 3;
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: org.rbmain.ui.Components.SharedMediaLayout.1
            /* JADX WARN: Removed duplicated region for block: B:52:0x0119  */
            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public org.rbmain.ui.PhotoViewer.PlaceProviderObject getPlaceForPhoto(org.rbmain.messenger.MessageObject r21, org.rbmain.tgnet.TLRPC$FileLocation r22, int r23, boolean r24) {
                /*
                    Method dump skipped, instructions count: 597
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.SharedMediaLayout.AnonymousClass1.getPlaceForPhoto(org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$FileLocation, int, boolean):org.rbmain.ui.PhotoViewer$PlaceProviderObject");
            }
        };
        this.sharedMediaData = new SharedMediaData[6];
        this.sharedLinkCellDelegate = new AnonymousClass20();
        this.sharedMediaPreloader = sharedMediaPreloader;
        if (sharedMediaPreloader != null) {
            int[] lastMediaCount = sharedMediaPreloader.getLastMediaCount();
            this.hasMedia = new int[]{lastMediaCount[0], lastMediaCount[1], lastMediaCount[2], lastMediaCount[3], lastMediaCount[4], lastMediaCount[5], i};
        } else {
            this.hasMedia = new int[0];
        }
        if (z) {
            this.initialTab = 7;
        } else {
            int i2 = 0;
            while (true) {
                int[] iArr = this.hasMedia;
                if (i2 >= iArr.length) {
                    break;
                }
                if (iArr[i2] == -1 || iArr[i2] > 0) {
                    break;
                } else {
                    i2++;
                }
            }
            this.initialTab = i2;
        }
        this.info = tLRPC$ChatFull3;
        if (tLRPC$ChatFull3 != null) {
            this.mergeDialogId = -tLRPC$ChatFull3.migrated_from_chat_id;
        }
        this.dialog_id = j;
        int i3 = 0;
        while (true) {
            SharedMediaData[] sharedMediaDataArr = this.sharedMediaData;
            if (i3 >= sharedMediaDataArr.length) {
                break;
            }
            sharedMediaDataArr[i3] = new SharedMediaData();
            this.sharedMediaData[i3].max_id[0] = ((int) this.dialog_id) == 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
            fillMediaData(i3);
            if (this.mergeDialogId != 0 && (tLRPC$ChatFull2 = this.info) != null) {
                SharedMediaData[] sharedMediaDataArr2 = this.sharedMediaData;
                sharedMediaDataArr2[i3].max_id[1] = tLRPC$ChatFull2.migrated_from_max_id;
                sharedMediaDataArr2[i3].endReached[1] = false;
            }
            i3++;
        }
        this.profileActivity = profileActivity;
        ActionBar actionBar = profileActivity.getActionBar();
        this.actionBar = actionBar;
        actionBar.setRtlLayout(true);
        this.profileActivity.getNotificationCenter().addObserver(this, NotificationCenter.mediaDidLoad);
        this.profileActivity.getNotificationCenter().addObserver(this, NotificationCenter.messagesDeleted);
        this.profileActivity.getNotificationCenter().addObserver(this, NotificationCenter.didReceiveNewMessages);
        this.profileActivity.getNotificationCenter().addObserver(this, NotificationCenter.messageReceivedByServer);
        this.profileActivity.getNotificationCenter().addObserver(this, NotificationCenter.messagePlayingDidReset);
        this.profileActivity.getNotificationCenter().addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        this.profileActivity.getNotificationCenter().addObserver(this, NotificationCenter.messagePlayingDidStart);
        for (int i4 = 0; i4 < 10; i4++) {
            this.cellCache.add(new SharedPhotoVideoCell(context));
            if (this.initialTab == 4) {
                SharedAudioCell sharedAudioCell = new SharedAudioCell(context) { // from class: org.rbmain.ui.Components.SharedMediaLayout.2
                    @Override // org.rbmain.ui.Cells.SharedAudioCell
                    public boolean needPlayMessage(MessageObject messageObject) {
                        if (messageObject.isVoice() || messageObject.isRoundVideo()) {
                            boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject);
                            MediaController.getInstance().setVoiceMessagesPlaylist(zPlayMessage ? SharedMediaLayout.this.sharedMediaData[4].messages : null, false);
                            return zPlayMessage;
                        }
                        if (messageObject.isMusic()) {
                            return MediaController.getInstance().setPlaylist(SharedMediaLayout.this.sharedMediaData[4].messages, messageObject, SharedMediaLayout.this.mergeDialogId);
                        }
                        return false;
                    }
                };
                sharedAudioCell.initStreamingIcons();
                this.audioCellCache.add(sharedAudioCell);
            }
        }
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.searching = false;
        this.searchWas = false;
        Drawable drawable = context.getResources().getDrawable(R.drawable.photos_header_shadow);
        this.pinnedHeaderShadowDrawable = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundGrayShadow), PorterDuff.Mode.MULTIPLY));
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (scrollSlidingTextTabStrip != null) {
            this.initialTab = scrollSlidingTextTabStrip.getCurrentTabId();
        }
        this.scrollSlidingTextTabStrip = createScrollingTextTabStrip(context);
        for (int i5 = 1; i5 >= 0; i5--) {
            this.selectedFiles[i5].clear();
        }
        this.cantDeleteMessagesCount = 0;
        this.actionModeViews.clear();
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        actionBarMenuCreateMenu.setRtlLayout(true);
        ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout.3
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                SharedMediaLayout.this.searching = true;
                SharedMediaLayout.this.onSearchStateChanged(true);
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                SharedMediaLayout.this.searching = false;
                SharedMediaLayout.this.searchWas = false;
                SharedMediaLayout.this.documentsSearchAdapter.search(null, true);
                SharedMediaLayout.this.linksSearchAdapter.search(null, true);
                SharedMediaLayout.this.audioSearchAdapter.search(null, true);
                SharedMediaLayout.this.groupUsersSearchAdapter.search(null, true);
                SharedMediaLayout.this.onSearchStateChanged(false);
                if (SharedMediaLayout.this.ignoreSearchCollapse) {
                    SharedMediaLayout.this.ignoreSearchCollapse = false;
                } else {
                    SharedMediaLayout.this.switchToCurrentSelectedMode(false);
                }
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                String string = editText.getText().toString();
                if (string.length() != 0) {
                    SharedMediaLayout.this.searchWas = true;
                } else {
                    SharedMediaLayout.this.searchWas = false;
                }
                SharedMediaLayout.this.switchToCurrentSelectedMode(false);
                if (SharedMediaLayout.this.mediaPages[0].selectedType == 1) {
                    if (SharedMediaLayout.this.documentsSearchAdapter == null) {
                        return;
                    }
                    SharedMediaLayout.this.documentsSearchAdapter.search(string, true);
                } else if (SharedMediaLayout.this.mediaPages[0].selectedType == 3) {
                    if (SharedMediaLayout.this.linksSearchAdapter == null) {
                        return;
                    }
                    SharedMediaLayout.this.linksSearchAdapter.search(string, true);
                } else if (SharedMediaLayout.this.mediaPages[0].selectedType == 4) {
                    if (SharedMediaLayout.this.audioSearchAdapter == null) {
                        return;
                    }
                    SharedMediaLayout.this.audioSearchAdapter.search(string, true);
                } else {
                    if (SharedMediaLayout.this.mediaPages[0].selectedType != 7 || SharedMediaLayout.this.groupUsersSearchAdapter == null) {
                        return;
                    }
                    SharedMediaLayout.this.groupUsersSearchAdapter.search(string, true);
                }
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onLayout(int i6, int i7, int i8, int i9) {
                View view = (View) SharedMediaLayout.this.searchItem.getParent();
                if (SharedMediaLayout.this.actionBar.isRtlLayout()) {
                    SharedMediaLayout.this.searchItem.setTranslationX(-i6);
                } else {
                    SharedMediaLayout.this.searchItem.setTranslationX(view.getMeasuredWidth() - i8);
                }
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setTranslationY(AndroidUtilities.dp(10.0f));
        this.searchItem.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setContentDescription(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setVisibility(4);
        EditTextBoldCursor searchField = this.searchItem.getSearchField();
        int i6 = Theme.key_windowBackgroundWhiteBlackText;
        searchField.setTextColor(Theme.getColor(i6));
        searchField.setHintTextColor(Theme.getColor(Theme.key_player_time));
        searchField.setCursorColor(Theme.getColor(i6));
        this.searchItemState = 0;
        LinearLayout linearLayout = new LinearLayout(context);
        this.actionModeLayout = linearLayout;
        linearLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.actionModeLayout.setAlpha(0.0f);
        this.actionModeLayout.setClickable(true);
        this.actionModeLayout.setVisibility(4);
        ImageView imageView = new ImageView(context);
        this.closeButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView2 = this.closeButton;
        BackDrawable backDrawable = new BackDrawable(true);
        this.backDrawable = backDrawable;
        imageView2.setImageDrawable(backDrawable);
        BackDrawable backDrawable2 = this.backDrawable;
        int i7 = Theme.key_windowBackgroundWhiteGrayText2;
        backDrawable2.setColor(Theme.getColor(i7));
        ImageView imageView3 = this.closeButton;
        int i8 = Theme.key_actionBarActionModeDefaultSelector;
        imageView3.setBackground(Theme.createSelectorDrawable(Theme.getColor(i8), 1));
        this.closeButton.setContentDescription(LocaleController.getString("Close", R.string.Close));
        this.actionModeLayout.addView(this.closeButton, new LinearLayout.LayoutParams(AndroidUtilities.dp(54.0f), -1));
        this.actionModeViews.add(this.closeButton);
        this.closeButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2(view);
            }
        });
        NumberTextView numberTextView = new NumberTextView(context);
        this.selectedMessagesCountTextView = numberTextView;
        numberTextView.setTextSize(18);
        this.selectedMessagesCountTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.selectedMessagesCountTextView.setTextColor(Theme.getColor(i7));
        this.actionModeLayout.addView(this.selectedMessagesCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 18, 0, 0, 0));
        this.actionModeViews.add(this.selectedMessagesCountTextView);
        if (((int) this.dialog_id) != 0) {
            ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, (ActionBarMenu) null, Theme.getColor(i8), Theme.getColor(i7), false);
            this.gotoItem = actionBarMenuItem;
            actionBarMenuItem.setRtlLayout(true);
            this.gotoItem.setIcon(R.drawable.msg_message);
            this.gotoItem.setContentDescription(LocaleController.getString("AccDescrGoToMessage", R.string.AccDescrGoToMessage));
            this.gotoItem.setDuplicateParentStateEnabled(false);
            this.actionModeLayout.addView(this.gotoItem, new LinearLayout.LayoutParams(AndroidUtilities.dp(54.0f), -1));
            this.actionModeViews.add(this.gotoItem);
            this.gotoItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$3(view);
                }
            });
            ActionBarMenuItem actionBarMenuItem2 = new ActionBarMenuItem(context, (ActionBarMenu) null, Theme.getColor(i8), Theme.getColor(i7), false);
            this.forwardItem = actionBarMenuItem2;
            actionBarMenuItem2.setRtlLayout(true);
            this.forwardItem.setIcon(R.drawable.msg_forward);
            this.forwardItem.setContentDescription(LocaleController.getString("Forward", R.string.Forward));
            this.forwardItem.setDuplicateParentStateEnabled(false);
            this.actionModeLayout.addView(this.forwardItem, new LinearLayout.LayoutParams(AndroidUtilities.dp(54.0f), -1));
            this.actionModeViews.add(this.forwardItem);
            this.forwardItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$4(view);
                }
            });
        }
        ActionBarMenuItem actionBarMenuItem3 = new ActionBarMenuItem(context, (ActionBarMenu) null, Theme.getColor(i8), Theme.getColor(i7), false);
        this.deleteItem = actionBarMenuItem3;
        actionBarMenuItem3.setRtlLayout(true);
        this.deleteItem.setIcon(R.drawable.msg_delete);
        this.deleteItem.setContentDescription(LocaleController.getString("Delete", R.string.Delete));
        this.deleteItem.setDuplicateParentStateEnabled(false);
        this.actionModeLayout.addView(this.deleteItem, new LinearLayout.LayoutParams(AndroidUtilities.dp(54.0f), -1));
        this.actionModeViews.add(this.deleteItem);
        this.deleteItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$5(view);
            }
        });
        this.photoVideoAdapter = new SharedPhotoVideoAdapter(context);
        this.documentsAdapter = new SharedDocumentsAdapter(context, 1);
        this.voiceAdapter = new SharedDocumentsAdapter(context, 2);
        this.audioAdapter = new SharedDocumentsAdapter(context, 4);
        this.gifAdapter = new GifAdapter(context);
        this.documentsSearchAdapter = new MediaSearchAdapter(context, 1);
        this.audioSearchAdapter = new MediaSearchAdapter(context, 4);
        this.linksSearchAdapter = new MediaSearchAdapter(context, 3);
        this.groupUsersSearchAdapter = new GroupUsersSearchAdapter(context);
        this.commonGroupsAdapter = new CommonGroupsAdapter(context);
        ChatUsersAdapter chatUsersAdapter = new ChatUsersAdapter(context);
        this.chatUsersAdapter = chatUsersAdapter;
        chatUsersAdapter.sortedUsers = arrayList;
        RecyclerView.ItemAnimator itemAnimator = null;
        this.chatUsersAdapter.chatInfo = z ? tLRPC$ChatFull3 : null;
        this.linksAdapter = new SharedLinksAdapter(context);
        setWillNotDraw(false);
        int iFindFirstVisibleItemPosition = -1;
        int i9 = 0;
        int top = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i9 < mediaPageArr.length) {
                if (i9 == 0 && mediaPageArr[i9] != null && mediaPageArr[i9].layoutManager != null) {
                    iFindFirstVisibleItemPosition = this.mediaPages[i9].layoutManager.findFirstVisibleItemPosition();
                    if (iFindFirstVisibleItemPosition == this.mediaPages[i9].layoutManager.getItemCount() - 1 || (holder = (RecyclerListView.Holder) this.mediaPages[i9].listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) == null) {
                        iFindFirstVisibleItemPosition = -1;
                    } else {
                        top = holder.itemView.getTop();
                    }
                }
                final MediaPage mediaPage = new MediaPage(context) { // from class: org.rbmain.ui.Components.SharedMediaLayout.4
                    @Override // android.view.View
                    public void setTranslationX(float f) {
                        super.setTranslationX(f);
                        if (SharedMediaLayout.this.tabsAnimationInProgress && SharedMediaLayout.this.mediaPages[0] == this) {
                            float fAbs = Math.abs(SharedMediaLayout.this.mediaPages[0].getTranslationX()) / SharedMediaLayout.this.mediaPages[0].getMeasuredWidth();
                            SharedMediaLayout.this.scrollSlidingTextTabStrip.selectTabWithId(SharedMediaLayout.this.mediaPages[1].selectedType, fAbs);
                            if (SharedMediaLayout.this.canShowSearchItem()) {
                                if (SharedMediaLayout.this.searchItemState == 2) {
                                    SharedMediaLayout.this.searchItem.setAlpha(1.0f - fAbs);
                                    return;
                                } else {
                                    if (SharedMediaLayout.this.searchItemState == 1) {
                                        SharedMediaLayout.this.searchItem.setAlpha(fAbs);
                                        return;
                                    }
                                    return;
                                }
                            }
                            SharedMediaLayout.this.searchItem.setAlpha(0.0f);
                        }
                    }
                };
                addView(mediaPage, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 48.0f, 0.0f, 0.0f));
                MediaPage[] mediaPageArr2 = this.mediaPages;
                mediaPageArr2[i9] = mediaPage;
                final ExtendedGridLayoutManager extendedGridLayoutManager = mediaPageArr2[i9].layoutManager = new ExtendedGridLayoutManager(context, 100) { // from class: org.rbmain.ui.Components.SharedMediaLayout.5
                    private Size size = new Size();

                    @Override // org.rbmain.ui.Components.ExtendedGridLayoutManager, androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public boolean supportsPredictiveItemAnimations() {
                        return false;
                    }

                    @Override // androidx.recyclerview.widget.LinearLayoutManager
                    protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr2) {
                        super.calculateExtraLayoutSpace(state, iArr2);
                        if (mediaPage.selectedType == 0) {
                            iArr2[1] = Math.max(iArr2[1], SharedPhotoVideoCell.getItemSize(SharedMediaLayout.this.columnsCount) * 2);
                        } else if (mediaPage.selectedType == 1) {
                            iArr2[1] = Math.max(iArr2[1], AndroidUtilities.dp(56.0f) * 2);
                        }
                    }

                    @Override // org.rbmain.ui.Components.ExtendedGridLayoutManager
                    protected Size getSizeForItem(int i10) {
                        int i11;
                        int i12;
                        TLRPC$Document document = (mediaPage.listView.getAdapter() != SharedMediaLayout.this.gifAdapter || SharedMediaLayout.this.sharedMediaData[5].messages.isEmpty()) ? null : SharedMediaLayout.this.sharedMediaData[5].messages.get(i10).getDocument();
                        Size size = this.size;
                        size.height = 100.0f;
                        size.width = 100.0f;
                        if (document != null) {
                            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90);
                            if (closestPhotoSizeWithSize != null && (i11 = closestPhotoSizeWithSize.w) != 0 && (i12 = closestPhotoSizeWithSize.h) != 0) {
                                Size size2 = this.size;
                                size2.width = i11;
                                size2.height = i12;
                            }
                            ArrayList<TLRPC$DocumentAttribute> arrayList2 = document.attributes;
                            for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = arrayList2.get(i13);
                                if ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) || (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo)) {
                                    Size size3 = this.size;
                                    size3.width = tLRPC$DocumentAttribute.w;
                                    size3.height = tLRPC$DocumentAttribute.h;
                                    break;
                                }
                            }
                        }
                        return this.size;
                    }

                    @Override // org.rbmain.ui.Components.ExtendedGridLayoutManager
                    protected int getFlowItemCount() {
                        if (mediaPage.listView.getAdapter() != SharedMediaLayout.this.gifAdapter) {
                            return 0;
                        }
                        return getItemCount();
                    }

                    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        super.onInitializeAccessibilityNodeInfoForItem(recycler, state, view, accessibilityNodeInfoCompat);
                        AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfo = accessibilityNodeInfoCompat.getCollectionItemInfo();
                        if (collectionItemInfo == null || !collectionItemInfo.isHeading()) {
                            return;
                        }
                        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(collectionItemInfo.getRowIndex(), collectionItemInfo.getRowSpan(), collectionItemInfo.getColumnIndex(), collectionItemInfo.getColumnSpan(), false));
                    }
                };
                extendedGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.Components.SharedMediaLayout.6
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i10) {
                        if (mediaPage.listView.getAdapter() != SharedMediaLayout.this.gifAdapter) {
                            return mediaPage.layoutManager.getSpanCount();
                        }
                        return (mediaPage.listView.getAdapter() == SharedMediaLayout.this.gifAdapter && SharedMediaLayout.this.sharedMediaData[5].messages.isEmpty()) ? mediaPage.layoutManager.getSpanCount() : mediaPage.layoutManager.getSpanSizeForItem(i10);
                    }
                });
                this.mediaPages[i9].listView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.SharedMediaLayout.7
                    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean z2, int i10, int i11, int i12, int i13) {
                        super.onLayout(z2, i10, i11, i12, i13);
                    }

                    @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
                    protected void dispatchDraw(Canvas canvas) {
                        if (getAdapter() == SharedMediaLayout.this.photoVideoAdapter) {
                            for (int i10 = 0; i10 < getChildCount(); i10++) {
                                if (getChildViewHolder(getChildAt(i10)).getItemViewType() == 1) {
                                    canvas.save();
                                    canvas.translate(getChildAt(i10).getX(), (getChildAt(i10).getY() - getChildAt(i10).getMeasuredHeight()) + AndroidUtilities.dp(2.0f));
                                    getChildAt(i10).draw(canvas);
                                    canvas.restore();
                                    invalidate();
                                }
                            }
                        }
                        super.dispatchDraw(canvas);
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                    public boolean drawChild(Canvas canvas, View view, long j2) {
                        if (getAdapter() == SharedMediaLayout.this.photoVideoAdapter && getChildViewHolder(view).getItemViewType() == 1) {
                            return true;
                        }
                        return super.drawChild(canvas, view, j2);
                    }
                };
                this.mediaPages[i9].listView.setScrollingTouchSlop(1);
                this.mediaPages[i9].listView.setPinnedSectionOffsetY(-AndroidUtilities.dp(2.0f));
                this.mediaPages[i9].listView.setPadding(0, AndroidUtilities.dp(2.0f), 0, 0);
                this.mediaPages[i9].listView.setItemAnimator(itemAnimator);
                this.mediaPages[i9].listView.setClipToPadding(false);
                this.mediaPages[i9].listView.setSectionsType(2);
                this.mediaPages[i9].listView.setLayoutManager(extendedGridLayoutManager);
                MediaPage[] mediaPageArr3 = this.mediaPages;
                mediaPageArr3[i9].addView(mediaPageArr3[i9].listView, LayoutHelper.createFrame(-1, -1.0f));
                this.mediaPages[i9].listView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: org.rbmain.ui.Components.SharedMediaLayout.8
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(android.graphics.Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                        if (mediaPage.listView.getAdapter() == SharedMediaLayout.this.gifAdapter) {
                            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                            rect.left = 0;
                            rect.bottom = 0;
                            if (!mediaPage.layoutManager.isFirstRow(childAdapterPosition)) {
                                rect.top = AndroidUtilities.dp(2.0f);
                            } else {
                                rect.top = 0;
                            }
                            rect.right = mediaPage.layoutManager.isLastInRow(childAdapterPosition) ? 0 : AndroidUtilities.dp(2.0f);
                            return;
                        }
                        rect.left = 0;
                        rect.top = 0;
                        rect.bottom = 0;
                        rect.right = 0;
                    }
                });
                this.mediaPages[i9].listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda10
                    @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                    public final void onItemClick(View view, int i10) {
                        this.f$0.lambda$new$6(mediaPage, view, i10);
                    }
                });
                this.mediaPages[i9].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout.9
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
                        SharedMediaLayout.this.scrolling = i10 != 0;
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
                        SharedMediaLayout.this.checkLoadMoreScroll(mediaPage, recyclerView, extendedGridLayoutManager);
                        if (i11 != 0) {
                            if ((SharedMediaLayout.this.mediaPages[0].selectedType == 0 || SharedMediaLayout.this.mediaPages[0].selectedType == 5) && !SharedMediaLayout.this.sharedMediaData[0].messages.isEmpty()) {
                                SharedMediaLayout.this.showFloatingDateView();
                            }
                        }
                    }
                });
                this.mediaPages[i9].listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda11
                    @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
                    public final boolean onItemClick(View view, int i10) {
                        return this.f$0.lambda$new$7(mediaPage, view, i10);
                    }
                });
                if (i9 == 0 && iFindFirstVisibleItemPosition != -1) {
                    extendedGridLayoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
                }
                final RecyclerListView recyclerListView = this.mediaPages[i9].listView;
                this.mediaPages[i9].animatingImageView = new ClippingImageView(this, context) { // from class: org.rbmain.ui.Components.SharedMediaLayout.10
                    @Override // android.view.View
                    public void invalidate() {
                        super.invalidate();
                        recyclerListView.invalidate();
                    }
                };
                this.mediaPages[i9].animatingImageView.setVisibility(8);
                this.mediaPages[i9].listView.addOverlayView(this.mediaPages[i9].animatingImageView, LayoutHelper.createFrame(-1, -1.0f));
                this.mediaPages[i9].progressView = new FlickerLoadingView(context) { // from class: org.rbmain.ui.Components.SharedMediaLayout.11
                    @Override // org.rbmain.ui.Components.FlickerLoadingView
                    public int getColumnsCount() {
                        return SharedMediaLayout.this.columnsCount;
                    }

                    @Override // org.rbmain.ui.Components.FlickerLoadingView
                    public int getViewType() {
                        setIsSingleCell(false);
                        if (mediaPage.selectedType == 0 || mediaPage.selectedType == 5) {
                            return 2;
                        }
                        if (mediaPage.selectedType == 1) {
                            return 3;
                        }
                        if (mediaPage.selectedType == 2 || mediaPage.selectedType == 4) {
                            return 4;
                        }
                        if (mediaPage.selectedType == 3) {
                            return 5;
                        }
                        if (mediaPage.selectedType == 7) {
                            return 6;
                        }
                        if (mediaPage.selectedType == 6 && SharedMediaLayout.this.scrollSlidingTextTabStrip.getTabsCount() == 1) {
                            setIsSingleCell(true);
                        }
                        return 1;
                    }

                    @Override // org.rbmain.ui.Components.FlickerLoadingView, android.view.View
                    protected void onDraw(Canvas canvas) {
                        SharedMediaLayout.this.backgroundPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), SharedMediaLayout.this.backgroundPaint);
                        super.onDraw(canvas);
                    }
                };
                this.mediaPages[i9].progressView.showDate(false);
                if (i9 != 0) {
                    this.mediaPages[i9].setVisibility(8);
                }
                MediaPage[] mediaPageArr4 = this.mediaPages;
                mediaPageArr4[i9].emptyView = new StickerEmptyView(context, mediaPageArr4[i9].progressView, 1);
                this.mediaPages[i9].emptyView.setVisibility(8);
                this.mediaPages[i9].emptyView.setAnimateLayoutChange(true);
                MediaPage[] mediaPageArr5 = this.mediaPages;
                mediaPageArr5[i9].addView(mediaPageArr5[i9].emptyView, LayoutHelper.createFrame(-1, -1.0f));
                this.mediaPages[i9].emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return SharedMediaLayout.lambda$new$8(view, motionEvent);
                    }
                });
                this.mediaPages[i9].emptyView.showProgress(true, false);
                this.mediaPages[i9].emptyView.title.setText(LocaleController.getString("NoResult", R.string.NoResult));
                this.mediaPages[i9].emptyView.subtitle.setText(LocaleController.getString("SearchEmptyViewFilteredSubtitle2", R.string.SearchEmptyViewFilteredSubtitle2));
                this.mediaPages[i9].emptyView.addView(this.mediaPages[i9].progressView, LayoutHelper.createFrame(-1, -1.0f));
                this.mediaPages[i9].listView.setEmptyView(this.mediaPages[i9].emptyView);
                this.mediaPages[i9].listView.setAnimateEmptyView(true, 0);
                MediaPage[] mediaPageArr6 = this.mediaPages;
                mediaPageArr6[i9].scrollHelper = new RecyclerAnimationScrollHelper(mediaPageArr6[i9].listView, this.mediaPages[i9].layoutManager);
                i9++;
                itemAnimator = null;
            } else {
                ChatActionCell chatActionCell = new ChatActionCell(context);
                this.floatingDateView = chatActionCell;
                chatActionCell.setCustomDate((int) (System.currentTimeMillis() / 1000), false, false);
                this.floatingDateView.setAlpha(0.0f);
                this.floatingDateView.setOverrideColor(Theme.key_chat_mediaTimeBackground, Theme.key_chat_mediaTimeText);
                this.floatingDateView.setTranslationY(-AndroidUtilities.dp(48.0f));
                addView(this.floatingDateView, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 52.0f, 0.0f, 0.0f));
                FragmentContextView fragmentContextView = new FragmentContextView(context, profileActivity, this, false, null);
                this.fragmentContextView = fragmentContextView;
                addView(fragmentContextView, LayoutHelper.createFrame(-1, 38.0f, 51, 0.0f, 48.0f, 0.0f, 0.0f));
                this.fragmentContextView.setDelegate(new FragmentContextView.FragmentContextViewDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda9
                    @Override // org.rbmain.ui.Components.FragmentContextView.FragmentContextViewDelegate
                    public final void onAnimation(boolean z2, boolean z3) {
                        this.f$0.lambda$new$9(z2, z3);
                    }
                });
                addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 48, 51));
                addView(this.actionModeLayout, LayoutHelper.createFrame(-1, 48, 51));
                View view = new View(context);
                this.shadowLine = view;
                view.setBackgroundColor(Theme.getColor(Theme.key_divider));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
                layoutParams.topMargin = AndroidUtilities.dp(48.0f) - 1;
                addView(this.shadowLine, layoutParams);
                updateTabs(false);
                switchToCurrentSelectedMode(false);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        closeActionMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        onActionBarItemClick(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(View view) {
        onActionBarItemClick(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(View view) {
        onActionBarItemClick(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(MediaPage mediaPage, View view, int i) {
        int peerId;
        if (mediaPage.selectedType != 7) {
            if (mediaPage.selectedType != 6 || !(view instanceof ProfileSearchCell)) {
                if (mediaPage.selectedType != 1 || !(view instanceof SharedDocumentCell)) {
                    if (mediaPage.selectedType != 3 || !(view instanceof SharedLinkCell)) {
                        if ((mediaPage.selectedType == 2 || mediaPage.selectedType == 4) && (view instanceof SharedAudioCell)) {
                            onItemClick(i, view, ((SharedAudioCell) view).getMessage(), 0, mediaPage.selectedType);
                            return;
                        } else {
                            if (mediaPage.selectedType == 5 && (view instanceof ContextLinkCell)) {
                                onItemClick(i, view, (MessageObject) ((ContextLinkCell) view).getParentObject(), 0, mediaPage.selectedType);
                                return;
                            }
                            return;
                        }
                    }
                    onItemClick(i, view, ((SharedLinkCell) view).getMessage(), 0, mediaPage.selectedType);
                    return;
                }
                onItemClick(i, view, ((SharedDocumentCell) view).getMessage(), 0, mediaPage.selectedType);
                return;
            }
            TLRPC$Chat chat = ((ProfileSearchCell) view).getChat();
            Bundle bundle = new Bundle();
            bundle.putInt("chat_id", chat.id);
            if (this.profileActivity.getMessagesController().checkCanOpenChat(bundle, this.profileActivity)) {
                this.profileActivity.presentFragment(new ChatActivity(bundle));
                return;
            }
            return;
        }
        if (!(view instanceof UserCell)) {
            RecyclerView.Adapter adapter = mediaPage.listView.getAdapter();
            GroupUsersSearchAdapter groupUsersSearchAdapter = this.groupUsersSearchAdapter;
            if (adapter == groupUsersSearchAdapter) {
                TLObject item = groupUsersSearchAdapter.getItem(i);
                if (item instanceof TLRPC$ChannelParticipant) {
                    peerId = MessageObject.getPeerId(((TLRPC$ChannelParticipant) item).peer);
                } else if (!(item instanceof TLRPC$ChatParticipant)) {
                    return;
                } else {
                    peerId = ((TLRPC$ChatParticipant) item).user_id;
                }
                if (peerId == 0 || peerId == this.profileActivity.getUserConfig().getClientUserId()) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("user_id", peerId);
                this.profileActivity.presentFragment(new ProfileActivity(bundle2));
                return;
            }
            return;
        }
        onMemberClick(!this.chatUsersAdapter.sortedUsers.isEmpty() ? this.chatUsersAdapter.chatInfo.participants.participants.get(((Integer) this.chatUsersAdapter.sortedUsers.get(i)).intValue()) : this.chatUsersAdapter.chatInfo.participants.participants.get(i), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$7(MediaPage mediaPage, View view, int i) {
        if (this.isActionModeShowed) {
            mediaPage.listView.getOnItemClickListener().onItemClick(view, i);
            return true;
        }
        if (mediaPage.selectedType != 7 || !(view instanceof UserCell)) {
            if (mediaPage.selectedType != 1 || !(view instanceof SharedDocumentCell)) {
                if (mediaPage.selectedType != 3 || !(view instanceof SharedLinkCell)) {
                    if ((mediaPage.selectedType != 2 && mediaPage.selectedType != 4) || !(view instanceof SharedAudioCell)) {
                        if (mediaPage.selectedType == 5 && (view instanceof ContextLinkCell)) {
                            return onItemLongClick((MessageObject) ((ContextLinkCell) view).getParentObject(), view, 0);
                        }
                        return false;
                    }
                    return onItemLongClick(((SharedAudioCell) view).getMessage(), view, 0);
                }
                return onItemLongClick(((SharedLinkCell) view).getMessage(), view, 0);
            }
            return onItemLongClick(((SharedDocumentCell) view).getMessage(), view, 0);
        }
        return onMemberClick(!this.chatUsersAdapter.sortedUsers.isEmpty() ? this.chatUsersAdapter.chatInfo.participants.participants.get(((Integer) this.chatUsersAdapter.sortedUsers.get(i)).intValue()) : this.chatUsersAdapter.chatInfo.participants.participants.get(i), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(boolean z, boolean z2) {
        if (z) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        FragmentContextView fragmentContextView = this.fragmentContextView;
        if (fragmentContextView == null || !fragmentContextView.isCallStyle()) {
            return;
        }
        canvas.save();
        canvas.translate(this.fragmentContextView.getX(), this.fragmentContextView.getY());
        this.fragmentContextView.setDrawOverlay(true);
        this.fragmentContextView.draw(canvas);
        this.fragmentContextView.setDrawOverlay(false);
        canvas.restore();
    }

    private ScrollSlidingTextTabStrip createScrollingTextTabStrip(Context context) {
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = new ScrollSlidingTextTabStrip(context);
        int i = this.initialTab;
        if (i != -1) {
            scrollSlidingTextTabStrip.setInitialTabId(i);
            this.initialTab = -1;
        }
        scrollSlidingTextTabStrip.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        scrollSlidingTextTabStrip.setColors(Theme.key_profile_tabSelectedLine, Theme.key_profile_tabSelectedText, Theme.key_profile_tabText, Theme.key_profile_tabSelector);
        scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout.12
            @Override // org.rbmain.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i2, boolean z) {
                if (SharedMediaLayout.this.mediaPages[0].selectedType == i2) {
                    return;
                }
                SharedMediaLayout.this.mediaPages[1].selectedType = i2;
                SharedMediaLayout.this.mediaPages[1].setVisibility(0);
                SharedMediaLayout.this.hideFloatingDateView(true);
                SharedMediaLayout.this.switchToCurrentSelectedMode(true);
                SharedMediaLayout.this.animatingForward = z;
                SharedMediaLayout.this.onSelectedTabChanged();
            }

            @Override // org.rbmain.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onSamePageSelected() {
                SharedMediaLayout.this.scrollToTop();
            }

            @Override // org.rbmain.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float f) {
                if (f != 1.0f || SharedMediaLayout.this.mediaPages[1].getVisibility() == 0) {
                    if (SharedMediaLayout.this.animatingForward) {
                        SharedMediaLayout.this.mediaPages[0].setTranslationX((-f) * SharedMediaLayout.this.mediaPages[0].getMeasuredWidth());
                        SharedMediaLayout.this.mediaPages[1].setTranslationX(SharedMediaLayout.this.mediaPages[0].getMeasuredWidth() - (SharedMediaLayout.this.mediaPages[0].getMeasuredWidth() * f));
                    } else {
                        SharedMediaLayout.this.mediaPages[0].setTranslationX(SharedMediaLayout.this.mediaPages[0].getMeasuredWidth() * f);
                        SharedMediaLayout.this.mediaPages[1].setTranslationX((SharedMediaLayout.this.mediaPages[0].getMeasuredWidth() * f) - SharedMediaLayout.this.mediaPages[0].getMeasuredWidth());
                    }
                    if (SharedMediaLayout.this.canShowSearchItem()) {
                        if (SharedMediaLayout.this.searchItemState == 1) {
                            SharedMediaLayout.this.searchItem.setAlpha(f);
                        } else if (SharedMediaLayout.this.searchItemState == 2) {
                            SharedMediaLayout.this.searchItem.setAlpha(1.0f - f);
                        }
                    } else {
                        SharedMediaLayout.this.searchItem.setVisibility(4);
                        SharedMediaLayout.this.searchItem.setAlpha(0.0f);
                    }
                    if (f == 1.0f) {
                        MediaPage mediaPage = SharedMediaLayout.this.mediaPages[0];
                        SharedMediaLayout.this.mediaPages[0] = SharedMediaLayout.this.mediaPages[1];
                        SharedMediaLayout.this.mediaPages[1] = mediaPage;
                        SharedMediaLayout.this.mediaPages[1].setVisibility(8);
                        if (SharedMediaLayout.this.searchItemState == 2) {
                            SharedMediaLayout.this.searchItem.setVisibility(4);
                        }
                        SharedMediaLayout.this.searchItemState = 0;
                        SharedMediaLayout.this.startStopVisibleGifs();
                    }
                }
            }
        });
        return scrollSlidingTextTabStrip;
    }

    private boolean fillMediaData(int i) {
        SharedMediaPreloader sharedMediaPreloader = this.sharedMediaPreloader;
        SharedMediaData[] sharedMediaData = sharedMediaPreloader != null ? sharedMediaPreloader.getSharedMediaData() : null;
        if (sharedMediaData == null) {
            return false;
        }
        SharedMediaData[] sharedMediaDataArr = this.sharedMediaData;
        sharedMediaDataArr[i].totalCount = sharedMediaData[i].totalCount;
        sharedMediaDataArr[i].messages.addAll(sharedMediaData[i].messages);
        this.sharedMediaData[i].sections.addAll(sharedMediaData[i].sections);
        for (Map.Entry<String, ArrayList<MessageObject>> entry : sharedMediaData[i].sectionArrays.entrySet()) {
            this.sharedMediaData[i].sectionArrays.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.sharedMediaData[i].messagesDict[i2] = sharedMediaData[i].messagesDict[i2].m132clone();
            SharedMediaData[] sharedMediaDataArr2 = this.sharedMediaData;
            sharedMediaDataArr2[i].max_id[i2] = sharedMediaData[i].max_id[i2];
            sharedMediaDataArr2[i].endReached[i2] = sharedMediaData[i].endReached[i2];
        }
        return !sharedMediaData[i].messages.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatingDateView() {
        AndroidUtilities.cancelRunOnUIThread(this.hideFloatingDateRunnable);
        AndroidUtilities.runOnUIThread(this.hideFloatingDateRunnable, 650L);
        if (this.floatingDateView.getTag() != null) {
            return;
        }
        AnimatorSet animatorSet = this.floatingDateAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.floatingDateView.setTag(1);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.floatingDateAnimation = animatorSet2;
        animatorSet2.setDuration(180L);
        this.floatingDateAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.TRANSLATION_Y, this.additionalFloatingTranslation));
        this.floatingDateAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        this.floatingDateAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.SharedMediaLayout.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SharedMediaLayout.this.floatingDateAnimation = null;
            }
        });
        this.floatingDateAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingDateView(boolean z) {
        AndroidUtilities.cancelRunOnUIThread(this.hideFloatingDateRunnable);
        if (this.floatingDateView.getTag() == null) {
            return;
        }
        this.floatingDateView.setTag(null);
        AnimatorSet animatorSet = this.floatingDateAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.floatingDateAnimation = null;
        }
        if (z) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.floatingDateAnimation = animatorSet2;
            animatorSet2.setDuration(180L);
            this.floatingDateAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.TRANSLATION_Y, (-AndroidUtilities.dp(48.0f)) + this.additionalFloatingTranslation));
            this.floatingDateAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            this.floatingDateAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.SharedMediaLayout.14
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SharedMediaLayout.this.floatingDateAnimation = null;
                }
            });
            this.floatingDateAnimation.start();
            return;
        }
        this.floatingDateView.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void scrollToTop() {
        /*
            r5 = this;
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r5.mediaPages
            r1 = 0
            r0 = r0[r1]
            int r0 = org.rbmain.ui.Components.SharedMediaLayout.MediaPage.access$100(r0)
            r2 = 1
            if (r0 == 0) goto L36
            if (r0 == r2) goto L2f
            r3 = 2
            if (r0 == r3) goto L2f
            r3 = 3
            if (r0 == r3) goto L28
            r3 = 4
            if (r0 == r3) goto L2f
            r3 = 5
            if (r0 == r3) goto L21
            r0 = 1114112000(0x42680000, float:58.0)
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
            goto L3c
        L21:
            r0 = 1114636288(0x42700000, float:60.0)
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
            goto L3c
        L28:
            r0 = 1120403456(0x42c80000, float:100.0)
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
            goto L3c
        L2f:
            r0 = 1113587712(0x42600000, float:56.0)
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
            goto L3c
        L36:
            int r0 = r5.columnsCount
            int r0 = org.rbmain.ui.Cells.SharedPhotoVideoCell.getItemSize(r0)
        L3c:
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r3 = r5.mediaPages
            r3 = r3[r1]
            org.rbmain.ui.Components.ExtendedGridLayoutManager r3 = org.rbmain.ui.Components.SharedMediaLayout.MediaPage.access$600(r3)
            int r3 = r3.findFirstVisibleItemPosition()
            int r3 = r3 * r0
            float r0 = (float) r3
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r3 = r5.mediaPages
            r3 = r3[r1]
            org.rbmain.ui.Components.RecyclerListView r3 = org.rbmain.ui.Components.SharedMediaLayout.MediaPage.access$200(r3)
            int r3 = r3.getMeasuredHeight()
            float r3 = (float) r3
            r4 = 1067030938(0x3f99999a, float:1.2)
            float r3 = r3 * r4
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto L78
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            org.rbmain.ui.Components.RecyclerAnimationScrollHelper r0 = org.rbmain.ui.Components.SharedMediaLayout.MediaPage.access$3300(r0)
            r0.setScrollDirection(r2)
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            org.rbmain.ui.Components.RecyclerAnimationScrollHelper r0 = org.rbmain.ui.Components.SharedMediaLayout.MediaPage.access$3300(r0)
            r0.scrollToPosition(r1, r1, r1, r2)
            goto L83
        L78:
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            org.rbmain.ui.Components.RecyclerListView r0 = org.rbmain.ui.Components.SharedMediaLayout.MediaPage.access$200(r0)
            r0.smoothScrollToPosition(r1)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.SharedMediaLayout.scrollToTop():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLoadMoreScroll(MediaPage mediaPage, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        int i;
        if ((this.searching && this.searchWas) || mediaPage.selectedType == 7) {
            return;
        }
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iAbs = iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (mediaPage.selectedType == 7) {
            return;
        }
        int i2 = 6;
        if (mediaPage.selectedType != 6) {
            if (mediaPage.selectedType == 0) {
                i2 = 3;
            } else if (mediaPage.selectedType == 5) {
                i2 = 10;
            }
            if (iAbs + iFindFirstVisibleItemPosition > itemCount - i2 && !this.sharedMediaData[mediaPage.selectedType].loading) {
                if (mediaPage.selectedType == 0) {
                    i = 0;
                } else if (mediaPage.selectedType == 1) {
                    i = 1;
                } else if (mediaPage.selectedType == 2) {
                    i = 2;
                } else if (mediaPage.selectedType == 4) {
                    i = 4;
                } else {
                    i = mediaPage.selectedType == 5 ? 5 : 3;
                }
                if (!this.sharedMediaData[mediaPage.selectedType].endReached[0]) {
                    this.sharedMediaData[mediaPage.selectedType].loading = true;
                    this.profileActivity.getMediaDataController().loadMedia(this.dialog_id, 50, this.sharedMediaData[mediaPage.selectedType].max_id[0], i, 1, this.profileActivity.getClassGuid());
                } else if (this.mergeDialogId != 0 && !this.sharedMediaData[mediaPage.selectedType].endReached[1]) {
                    this.sharedMediaData[mediaPage.selectedType].loading = true;
                    this.profileActivity.getMediaDataController().loadMedia(this.mergeDialogId, 50, this.sharedMediaData[mediaPage.selectedType].max_id[1], i, 1, this.profileActivity.getClassGuid());
                }
            }
            if (this.mediaPages[0].listView == recyclerView) {
                if ((this.mediaPages[0].selectedType == 0 || this.mediaPages[0].selectedType == 5) && iFindFirstVisibleItemPosition != -1 && (viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) != null && viewHolderFindViewHolderForAdapterPosition.getItemViewType() == 0) {
                    View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                    if (view instanceof SharedPhotoVideoCell) {
                        MessageObject messageObject = ((SharedPhotoVideoCell) view).getMessageObject(0);
                        if (messageObject != null) {
                            this.floatingDateView.setCustomDate(messageObject.messageOwner.date, false, true);
                            return;
                        }
                        return;
                    }
                    if (view instanceof ContextLinkCell) {
                        this.floatingDateView.setCustomDate(((ContextLinkCell) view).getDate(), false, true);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (iAbs <= 0 || this.commonGroupsAdapter.endReached || this.commonGroupsAdapter.loading || this.commonGroupsAdapter.chats.isEmpty() || iFindFirstVisibleItemPosition + iAbs < itemCount - 5) {
            return;
        }
        this.commonGroupsAdapter.getChats(((TLRPC$Chat) r1.chats.get(this.commonGroupsAdapter.chats.size() - 1)).id, 100);
    }

    public ActionBarMenuItem getSearchItem() {
        return this.searchItem;
    }

    public boolean isSearchItemVisible() {
        if (this.mediaPages[0].selectedType == 7) {
            return this.profileActivity.canSearchMembers();
        }
        return (this.mediaPages[0].selectedType == 0 || this.mediaPages[0].selectedType == 2 || this.mediaPages[0].selectedType == 5 || this.mediaPages[0].selectedType == 6) ? false : true;
    }

    public int getSelectedTab() {
        return this.scrollSlidingTextTabStrip.getCurrentTabId();
    }

    public int getClosestTab() {
        MediaPage[] mediaPageArr = this.mediaPages;
        if (mediaPageArr[1] == null || mediaPageArr[1].getVisibility() != 0 || ((!this.tabsAnimationInProgress || this.backAnimation) && Math.abs(this.mediaPages[1].getTranslationX()) >= this.mediaPages[1].getMeasuredWidth() / 2.0f)) {
            return this.scrollSlidingTextTabStrip.getCurrentTabId();
        }
        return this.mediaPages[1].selectedType;
    }

    public void onDestroy() {
        this.profileActivity.getNotificationCenter().removeObserver(this, NotificationCenter.mediaDidLoad);
        this.profileActivity.getNotificationCenter().removeObserver(this, NotificationCenter.didReceiveNewMessages);
        this.profileActivity.getNotificationCenter().removeObserver(this, NotificationCenter.messagesDeleted);
        this.profileActivity.getNotificationCenter().removeObserver(this, NotificationCenter.messageReceivedByServer);
        this.profileActivity.getNotificationCenter().removeObserver(this, NotificationCenter.messagePlayingDidReset);
        this.profileActivity.getNotificationCenter().removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        this.profileActivity.getNotificationCenter().removeObserver(this, NotificationCenter.messagePlayingDidStart);
    }

    private void checkCurrentTabValid() {
        if (this.scrollSlidingTextTabStrip.hasTab(this.scrollSlidingTextTabStrip.getCurrentTabId())) {
            return;
        }
        int firstTabId = this.scrollSlidingTextTabStrip.getFirstTabId();
        this.scrollSlidingTextTabStrip.setInitialTabId(firstTabId);
        this.mediaPages[0].selectedType = firstTabId;
        switchToCurrentSelectedMode(false);
    }

    public void setNewMediaCounts(int[] iArr) {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= 6) {
                z = false;
                break;
            } else {
                if (this.hasMedia[i] >= 0) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        System.arraycopy(iArr, 0, this.hasMedia, 0, 6);
        updateTabs(true);
        if (!z && this.scrollSlidingTextTabStrip.getCurrentTabId() == 6) {
            this.scrollSlidingTextTabStrip.resetTab();
        }
        checkCurrentTabValid();
    }

    public void setCommonGroupsCount(int i) {
        this.hasMedia[6] = i;
        updateTabs(true);
        checkCurrentTabValid();
    }

    public void onActionBarItemClick(int i) {
        TLRPC$EncryptedChat encryptedChat;
        TLRPC$User user;
        TLRPC$Chat chat;
        if (i == 101) {
            int i2 = (int) this.dialog_id;
            if (i2 == 0) {
                encryptedChat = this.profileActivity.getMessagesController().getEncryptedChat(Integer.valueOf((int) (this.dialog_id >> 32)));
                user = null;
                chat = null;
            } else if (i2 > 0) {
                user = this.profileActivity.getMessagesController().getUser(Integer.valueOf(i2));
                chat = null;
                encryptedChat = null;
            } else {
                chat = this.profileActivity.getMessagesController().getChat(Integer.valueOf(-i2));
                user = null;
                encryptedChat = null;
            }
            AlertsCreator.createDeleteMessagesAlert(this.profileActivity, user, chat, encryptedChat, null, this.mergeDialogId, null, this.selectedFiles, null, false, 1, new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onActionBarItemClick$10();
                }
            }, null);
            return;
        }
        if (i == 100) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("onlySelect", true);
            bundle.putInt("dialogsType", 3);
            DialogsActivity dialogsActivity = new DialogsActivity(bundle);
            dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda12
                @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                    this.f$0.lambda$onActionBarItemClick$11(dialogsActivity2, arrayList, charSequence, z);
                }
            });
            this.profileActivity.presentFragment(dialogsActivity);
            return;
        }
        if (i == 102 && this.selectedFiles[0].size() + this.selectedFiles[1].size() == 1) {
            LongSparseArray<MessageObject>[] longSparseArrayArr = this.selectedFiles;
            MessageObject messageObjectValueAt = longSparseArrayArr[longSparseArrayArr[0].size() == 1 ? (char) 0 : (char) 1].valueAt(0);
            Bundle bundle2 = new Bundle();
            int dialogId = (int) messageObjectValueAt.getDialogId();
            int dialogId2 = (int) (messageObjectValueAt.getDialogId() >> 32);
            if (dialogId == 0) {
                bundle2.putInt("enc_id", dialogId2);
            } else if (dialogId > 0) {
                bundle2.putInt("user_id", dialogId);
            } else {
                TLRPC$Chat chat2 = this.profileActivity.getMessagesController().getChat(Integer.valueOf(-dialogId));
                if (chat2 != null && chat2.migrated_to != null) {
                    bundle2.putInt("migrated_to", dialogId);
                    dialogId = -chat2.migrated_to.channel_id;
                }
                bundle2.putInt("chat_id", -dialogId);
            }
            bundle2.putLong("message_id", messageObjectValueAt.getId());
            bundle2.putBoolean("need_remove_previous_same_chat_activity", false);
            this.profileActivity.presentFragment(new ChatActivity(bundle2), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActionBarItemClick$10() {
        showActionMode(false);
        this.actionBar.closeSearchField();
        this.cantDeleteMessagesCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActionBarItemClick$11(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        ArrayList<MessageObject> arrayList2 = new ArrayList<>();
        int i = 1;
        while (true) {
            if (i < 0) {
                break;
            }
            ArrayList arrayList3 = new ArrayList();
            for (int i2 = 0; i2 < this.selectedFiles[i].size(); i2++) {
                arrayList3.add(Long.valueOf(this.selectedFiles[i].keyAt(i2)));
            }
            Collections.sort(arrayList3);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                if (l.longValue() > 0) {
                    arrayList2.add(this.selectedFiles[i].get(l.longValue()));
                }
            }
            this.selectedFiles[i].clear();
            i--;
        }
        this.cantDeleteMessagesCount = 0;
        showActionMode(false);
        if (arrayList.size() > 1 || ((Long) arrayList.get(0)).longValue() == this.profileActivity.getUserConfig().getClientUserId() || charSequence != null) {
            updateRowsSelection();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                long jLongValue = ((Long) arrayList.get(i3)).longValue();
                if (charSequence != null) {
                    this.profileActivity.getSendMessagesHelper().sendMessage(charSequence.toString(), jLongValue, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                }
                this.profileActivity.getSendMessagesHelper().sendMessage(arrayList2, jLongValue, true, 0);
            }
            dialogsActivity.finishFragment();
            return;
        }
        long jLongValue2 = ((Long) arrayList.get(0)).longValue();
        int i4 = (int) jLongValue2;
        int i5 = (int) (jLongValue2 >> 32);
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        if (i4 == 0) {
            bundle.putInt("enc_id", i5);
        } else if (i4 > 0) {
            bundle.putInt("user_id", i4);
        } else {
            bundle.putInt("chat_id", -i4);
        }
        if (i4 == 0 || this.profileActivity.getMessagesController().checkCanOpenChat(bundle, dialogsActivity)) {
            this.profileActivity.getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
            ChatActivity chatActivity = new ChatActivity(bundle);
            dialogsActivity.presentFragment(chatActivity, true);
            chatActivity.showFieldPanelForForward(true, arrayList2);
        }
    }

    private boolean prepareForMoving(MotionEvent motionEvent, boolean z) {
        int nextPageId = this.scrollSlidingTextTabStrip.getNextPageId(z);
        if (nextPageId < 0) {
            return false;
        }
        if (canShowSearchItem()) {
            int i = this.searchItemState;
            if (i != 0) {
                if (i == 2) {
                    this.searchItem.setAlpha(1.0f);
                } else if (i == 1) {
                    this.searchItem.setAlpha(0.0f);
                    this.searchItem.setVisibility(4);
                }
                this.searchItemState = 0;
            }
        } else {
            this.searchItem.setVisibility(4);
            this.searchItem.setAlpha(0.0f);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        hideFloatingDateView(true);
        this.maybeStartTracking = false;
        this.startedTracking = true;
        this.startedTrackingX = (int) motionEvent.getX();
        this.actionBar.setEnabled(false);
        this.scrollSlidingTextTabStrip.setEnabled(false);
        this.mediaPages[1].selectedType = nextPageId;
        this.mediaPages[1].setVisibility(0);
        this.animatingForward = z;
        switchToCurrentSelectedMode(true);
        if (z) {
            this.mediaPages[1].setTranslationX(r8[0].getMeasuredWidth());
        } else {
            this.mediaPages[1].setTranslationX(-r8[0].getMeasuredWidth());
        }
        return true;
    }

    @Override // android.view.View
    public void forceHasOverlappingRendering(boolean z) {
        super.forceHasOverlappingRendering(z);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.topPadding = i2;
        int i5 = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i5 >= mediaPageArr.length) {
                break;
            }
            mediaPageArr[i5].setTranslationY(this.topPadding - this.lastMeasuredTopPadding);
            i5++;
        }
        this.fragmentContextView.setTranslationY(AndroidUtilities.dp(48.0f) + i2);
        this.additionalFloatingTranslation = i2;
        ChatActionCell chatActionCell = this.floatingDateView;
        chatActionCell.setTranslationY((chatActionCell.getTag() == null ? -AndroidUtilities.dp(48.0f) : 0) + this.additionalFloatingTranslation);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int height = this.profileActivity.getListView().getHeight();
        if (height == 0) {
            height = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(size, height);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (childAt instanceof MediaPage) {
                    measureChildWithMargins(childAt, i, 0, View.MeasureSpec.makeMeasureSpec(height, 1073741824), 0);
                    ((MediaPage) childAt).listView.setPadding(0, 0, 0, this.topPadding);
                } else {
                    measureChildWithMargins(childAt, i, 0, i2, 0);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkTabsAnimationInProgress() {
        /*
            r7 = this;
            boolean r0 = r7.tabsAnimationInProgress
            r1 = 0
            if (r0 == 0) goto L7b
            boolean r0 = r7.backAnimation
            r2 = -1
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1
            if (r0 == 0) goto L3b
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r1]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r1]
            r0.setTranslationX(r3)
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r7.mediaPages
            r3 = r0[r5]
            r0 = r0[r1]
            int r0 = r0.getMeasuredWidth()
            boolean r4 = r7.animatingForward
            if (r4 == 0) goto L34
            r2 = 1
        L34:
            int r0 = r0 * r2
            float r0 = (float) r0
            r3.setTranslationX(r0)
            goto L6a
        L3b:
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r5]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r7.mediaPages
            r4 = r0[r1]
            r0 = r0[r1]
            int r0 = r0.getMeasuredWidth()
            boolean r6 = r7.animatingForward
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            r2 = 1
        L5b:
            int r0 = r0 * r2
            float r0 = (float) r0
            r4.setTranslationX(r0)
            org.rbmain.ui.Components.SharedMediaLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r5]
            r0.setTranslationX(r3)
            goto L6a
        L69:
            r5 = 0
        L6a:
            if (r5 == 0) goto L78
            android.animation.AnimatorSet r0 = r7.tabsAnimation
            if (r0 == 0) goto L76
            r0.cancel()
            r0 = 0
            r7.tabsAnimation = r0
        L76:
            r7.tabsAnimationInProgress = r1
        L78:
            boolean r0 = r7.tabsAnimationInProgress
            return r0
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.SharedMediaLayout.checkTabsAnimationInProgress():boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return checkTabsAnimationInProgress() || this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(motionEvent);
    }

    public boolean isCurrentTabFirst() {
        return this.scrollSlidingTextTabStrip.getCurrentTabId() == this.scrollSlidingTextTabStrip.getFirstTabId();
    }

    public RecyclerListView getCurrentListView() {
        return this.mediaPages[0].listView;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float xVelocity;
        float yVelocity;
        float measuredWidth;
        int measuredWidth2;
        boolean z;
        if (this.profileActivity.getParentLayout() == null || this.profileActivity.getParentLayout().checkTransitionAnimation() || checkTabsAnimationInProgress()) {
            return false;
        }
        if (motionEvent != null) {
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
        }
        if (motionEvent != null && motionEvent.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking && motionEvent.getY() >= AndroidUtilities.dp(48.0f)) {
            this.startedTrackingPointerId = motionEvent.getPointerId(0);
            this.maybeStartTracking = true;
            this.startedTrackingX = (int) motionEvent.getX();
            this.startedTrackingY = (int) motionEvent.getY();
            this.velocityTracker.clear();
        } else if (motionEvent != null && motionEvent.getAction() == 2 && motionEvent.getPointerId(0) == this.startedTrackingPointerId) {
            int x = (int) (motionEvent.getX() - this.startedTrackingX);
            int iAbs = Math.abs(((int) motionEvent.getY()) - this.startedTrackingY);
            if (this.startedTracking && (((z = this.animatingForward) && x > 0) || (!z && x < 0))) {
                if (!prepareForMoving(motionEvent, x < 0)) {
                    this.maybeStartTracking = true;
                    this.startedTracking = false;
                    this.mediaPages[0].setTranslationX(0.0f);
                    this.mediaPages[1].setTranslationX(this.animatingForward ? r7[0].getMeasuredWidth() : -r7[0].getMeasuredWidth());
                    this.scrollSlidingTextTabStrip.selectTabWithId(this.mediaPages[1].selectedType, 0.0f);
                }
            }
            if (!this.maybeStartTracking || this.startedTracking) {
                if (this.startedTracking) {
                    this.mediaPages[0].setTranslationX(x);
                    if (this.animatingForward) {
                        this.mediaPages[1].setTranslationX(r12[0].getMeasuredWidth() + x);
                    } else {
                        this.mediaPages[1].setTranslationX(x - r12[0].getMeasuredWidth());
                    }
                    float fAbs = Math.abs(x) / this.mediaPages[0].getMeasuredWidth();
                    if (canShowSearchItem()) {
                        int i = this.searchItemState;
                        if (i == 2) {
                            this.searchItem.setAlpha(1.0f - fAbs);
                        } else if (i == 1) {
                            this.searchItem.setAlpha(fAbs);
                        }
                    } else {
                        this.searchItem.setAlpha(0.0f);
                    }
                    this.scrollSlidingTextTabStrip.selectTabWithId(this.mediaPages[1].selectedType, fAbs);
                    onSelectedTabChanged();
                }
            } else if (Math.abs(x) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x) > iAbs) {
                prepareForMoving(motionEvent, x < 0);
            }
        } else if (motionEvent == null || (motionEvent.getPointerId(0) == this.startedTrackingPointerId && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6))) {
            this.velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE, this.maximumVelocity);
            if (motionEvent == null || motionEvent.getAction() == 3) {
                xVelocity = 0.0f;
                yVelocity = 0.0f;
            } else {
                xVelocity = this.velocityTracker.getXVelocity();
                yVelocity = this.velocityTracker.getYVelocity();
                if (!this.startedTracking && Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                    prepareForMoving(motionEvent, xVelocity < 0.0f);
                }
            }
            if (this.startedTracking) {
                float x2 = this.mediaPages[0].getX();
                this.tabsAnimation = new AnimatorSet();
                boolean z2 = Math.abs(x2) < ((float) this.mediaPages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity) < 3500.0f || Math.abs(xVelocity) < Math.abs(yVelocity));
                this.backAnimation = z2;
                if (z2) {
                    measuredWidth = Math.abs(x2);
                    if (this.animatingForward) {
                        this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, r7[1].getMeasuredWidth()));
                    } else {
                        this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, -r7[1].getMeasuredWidth()));
                    }
                } else {
                    measuredWidth = this.mediaPages[0].getMeasuredWidth() - Math.abs(x2);
                    if (this.animatingForward) {
                        this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, -r7[0].getMeasuredWidth()), ObjectAnimator.ofFloat(this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f));
                    } else {
                        this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, r7[0].getMeasuredWidth()), ObjectAnimator.ofFloat(this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f));
                    }
                }
                this.tabsAnimation.setInterpolator(interpolator);
                int measuredWidth3 = getMeasuredWidth();
                float f = measuredWidth3 / 2;
                float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                float fAbs2 = Math.abs(xVelocity);
                if (fAbs2 > 0.0f) {
                    measuredWidth2 = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / fAbs2) * 1000.0f) * 4;
                } else {
                    measuredWidth2 = (int) (((measuredWidth / getMeasuredWidth()) + 1.0f) * 100.0f);
                }
                this.tabsAnimation.setDuration(Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min(measuredWidth2, 600)));
                this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.SharedMediaLayout.15
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SharedMediaLayout.this.tabsAnimation = null;
                        if (SharedMediaLayout.this.backAnimation) {
                            SharedMediaLayout.this.mediaPages[1].setVisibility(8);
                            if (SharedMediaLayout.this.canShowSearchItem()) {
                                if (SharedMediaLayout.this.searchItemState == 2) {
                                    SharedMediaLayout.this.searchItem.setAlpha(1.0f);
                                } else if (SharedMediaLayout.this.searchItemState == 1) {
                                    SharedMediaLayout.this.searchItem.setAlpha(0.0f);
                                    SharedMediaLayout.this.searchItem.setVisibility(4);
                                }
                            } else {
                                SharedMediaLayout.this.searchItem.setVisibility(4);
                                SharedMediaLayout.this.searchItem.setAlpha(0.0f);
                            }
                            SharedMediaLayout.this.searchItemState = 0;
                        } else {
                            MediaPage mediaPage = SharedMediaLayout.this.mediaPages[0];
                            SharedMediaLayout.this.mediaPages[0] = SharedMediaLayout.this.mediaPages[1];
                            SharedMediaLayout.this.mediaPages[1] = mediaPage;
                            SharedMediaLayout.this.mediaPages[1].setVisibility(8);
                            if (SharedMediaLayout.this.searchItemState == 2) {
                                SharedMediaLayout.this.searchItem.setVisibility(4);
                            }
                            SharedMediaLayout.this.searchItemState = 0;
                            SharedMediaLayout.this.scrollSlidingTextTabStrip.selectTabWithId(SharedMediaLayout.this.mediaPages[0].selectedType, 1.0f);
                            SharedMediaLayout.this.onSelectedTabChanged();
                            SharedMediaLayout.this.startStopVisibleGifs();
                        }
                        SharedMediaLayout.this.tabsAnimationInProgress = false;
                        SharedMediaLayout.this.maybeStartTracking = false;
                        SharedMediaLayout.this.startedTracking = false;
                        SharedMediaLayout.this.actionBar.setEnabled(true);
                        SharedMediaLayout.this.scrollSlidingTextTabStrip.setEnabled(true);
                    }
                });
                this.tabsAnimation.start();
                this.tabsAnimationInProgress = true;
                this.startedTracking = false;
                onSelectedTabChanged();
            } else {
                this.maybeStartTracking = false;
                this.actionBar.setEnabled(true);
                this.scrollSlidingTextTabStrip.setEnabled(true);
            }
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
        }
        return this.startedTracking;
    }

    public boolean closeActionMode() {
        if (!this.isActionModeShowed) {
            return false;
        }
        for (int i = 1; i >= 0; i--) {
            this.selectedFiles[i].clear();
        }
        this.cantDeleteMessagesCount = 0;
        showActionMode(false);
        updateRowsSelection();
        return true;
    }

    public void setVisibleHeight(int i) {
        int iMax = Math.max(i, AndroidUtilities.dp(120.0f));
        for (int i2 = 0; i2 < this.mediaPages.length; i2++) {
            float f = (-(getMeasuredHeight() - iMax)) / 2.0f;
            this.mediaPages[i2].emptyView.setTranslationY(f);
            this.mediaPages[i2].progressView.setTranslationY(-f);
        }
    }

    private void showActionMode(final boolean z) {
        if (this.isActionModeShowed == z) {
            return;
        }
        this.isActionModeShowed = z;
        AnimatorSet animatorSet = this.actionModeAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (z) {
            this.actionModeLayout.setVisibility(0);
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.actionModeAnimation = animatorSet2;
        Animator[] animatorArr = new Animator[1];
        LinearLayout linearLayout = this.actionModeLayout;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = z ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(linearLayout, (Property<LinearLayout, Float>) property, fArr);
        animatorSet2.playTogether(animatorArr);
        this.actionModeAnimation.setDuration(180L);
        this.actionModeAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.SharedMediaLayout.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                SharedMediaLayout.this.actionModeAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SharedMediaLayout.this.actionModeAnimation == null) {
                    return;
                }
                SharedMediaLayout.this.actionModeAnimation = null;
                if (z) {
                    return;
                }
                SharedMediaLayout.this.actionModeLayout.setVisibility(4);
            }
        });
        this.actionModeAnimation.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x032b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:? A[RETURN, SYNTHETIC] */
    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r24, int r25, java.lang.Object... r26) {
        /*
            Method dump skipped, instructions count: 1001
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.SharedMediaLayout.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateItemsEnter(final RecyclerListView recyclerListView, final int i) {
        int childCount = recyclerListView.getChildCount();
        final View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerListView.getChildAt(i2);
            if (childAt instanceof FlickerLoadingView) {
                view = childAt;
            }
        }
        if (view != null) {
            recyclerListView.removeView(view);
        }
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout.17
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SharedMediaLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount2 = recyclerListView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = recyclerListView.getChildAt(i3);
                    if (childAt2 != view && recyclerListView.getChildAdapterPosition(childAt2) >= i - 1) {
                        childAt2.setAlpha(0.0f);
                        int iMin = (int) ((Math.min(recyclerListView.getMeasuredHeight(), Math.max(0, childAt2.getTop())) / recyclerListView.getMeasuredHeight()) * 100.0f);
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt2, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                        objectAnimatorOfFloat.setStartDelay(iMin);
                        objectAnimatorOfFloat.setDuration(200L);
                        animatorSet.playTogether(objectAnimatorOfFloat);
                    }
                    View view2 = view;
                    if (view2 != null && view2.getParent() == null) {
                        recyclerListView.addView(view);
                        final RecyclerView.LayoutManager layoutManager = recyclerListView.getLayoutManager();
                        if (layoutManager != null) {
                            layoutManager.ignoreView(view);
                            View view3 = view;
                            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.ALPHA, view3.getAlpha(), 0.0f);
                            objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.SharedMediaLayout.17.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    view.setAlpha(1.0f);
                                    layoutManager.stopIgnoringView(view);
                                    AnonymousClass17 anonymousClass17 = AnonymousClass17.this;
                                    recyclerListView.removeView(view);
                                }
                            });
                            objectAnimatorOfFloat2.start();
                        }
                    }
                }
                animatorSet.start();
                return true;
            }
        });
    }

    public void onResume() {
        this.scrolling = true;
        SharedPhotoVideoAdapter sharedPhotoVideoAdapter = this.photoVideoAdapter;
        if (sharedPhotoVideoAdapter != null) {
            sharedPhotoVideoAdapter.notifyDataSetChanged();
        }
        SharedDocumentsAdapter sharedDocumentsAdapter = this.documentsAdapter;
        if (sharedDocumentsAdapter != null) {
            sharedDocumentsAdapter.notifyDataSetChanged();
        }
        SharedLinksAdapter sharedLinksAdapter = this.linksAdapter;
        if (sharedLinksAdapter != null) {
            sharedLinksAdapter.notifyDataSetChanged();
        }
        for (int i = 0; i < this.mediaPages.length; i++) {
            fixLayoutInternal(i);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                return;
            }
            if (mediaPageArr[i].listView != null) {
                this.mediaPages[i].listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout.18
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        SharedMediaLayout.this.mediaPages[i].getViewTreeObserver().removeOnPreDrawListener(this);
                        SharedMediaLayout.this.fixLayoutInternal(i);
                        return true;
                    }
                });
            }
            i++;
        }
    }

    public void setChatInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        int i;
        this.info = tLRPC$ChatFull;
        if (tLRPC$ChatFull == null || (i = tLRPC$ChatFull.migrated_from_chat_id) == 0 || this.mergeDialogId != 0) {
            return;
        }
        this.mergeDialogId = -i;
        int i2 = 0;
        while (true) {
            SharedMediaData[] sharedMediaDataArr = this.sharedMediaData;
            if (i2 >= sharedMediaDataArr.length) {
                return;
            }
            sharedMediaDataArr[i2].max_id[1] = this.info.migrated_from_max_id;
            sharedMediaDataArr[i2].endReached[1] = false;
            i2++;
        }
    }

    public void setChatUsers(ArrayList<Integer> arrayList, TLRPC$ChatFull tLRPC$ChatFull) {
        this.chatUsersAdapter.chatInfo = tLRPC$ChatFull;
        this.chatUsersAdapter.sortedUsers = arrayList;
        updateTabs(true);
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                return;
            }
            if (mediaPageArr[i].selectedType == 7) {
                this.mediaPages[i].listView.getAdapter().notifyDataSetChanged();
            }
            i++;
        }
    }

    private void updateRowsSelection() {
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                return;
            }
            int childCount = mediaPageArr[i].listView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.mediaPages[i].listView.getChildAt(i2);
                if (childAt instanceof SharedDocumentCell) {
                    ((SharedDocumentCell) childAt).setChecked(false, true);
                } else if (childAt instanceof SharedPhotoVideoCell) {
                    for (int i3 = 0; i3 < 6; i3++) {
                        ((SharedPhotoVideoCell) childAt).setChecked(i3, false, true);
                    }
                } else if (childAt instanceof SharedLinkCell) {
                    ((SharedLinkCell) childAt).setChecked(false, true);
                } else if (childAt instanceof SharedAudioCell) {
                    ((SharedAudioCell) childAt).setChecked(false, true);
                } else if (childAt instanceof ContextLinkCell) {
                    ((ContextLinkCell) childAt).setChecked(false, true);
                }
            }
            i++;
        }
    }

    public void setMergeDialogId(long j) {
        this.mergeDialogId = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8 A[PHI: r0
      0x00a8: PHI (r0v11 int) = (r0v10 int), (r0v82 int) binds: [B:55:0x00a6, B:44:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateTabs(boolean r15) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.SharedMediaLayout.updateTabs(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startStopVisibleGifs() {
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                return;
            }
            int childCount = mediaPageArr[i].listView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.mediaPages[i].listView.getChildAt(i2);
                if (childAt instanceof ContextLinkCell) {
                    ImageReceiver photoImage = ((ContextLinkCell) childAt).getPhotoImage();
                    if (i == 0) {
                        photoImage.setAllowStartAnimation(true);
                        photoImage.startAnimation();
                    } else {
                        photoImage.setAllowStartAnimation(false);
                        photoImage.stopAnimation();
                    }
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode(boolean z) {
        MediaPage[] mediaPageArr;
        GroupUsersSearchAdapter groupUsersSearchAdapter;
        int i = 0;
        while (true) {
            mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                break;
            }
            mediaPageArr[i].listView.stopScroll();
            i++;
        }
        RecyclerView.Adapter adapter = mediaPageArr[z ? 1 : 0].listView.getAdapter();
        if (!this.searching || !this.searchWas) {
            this.mediaPages[z ? 1 : 0].listView.setPinnedHeaderShadowDrawable(null);
            if (this.mediaPages[z ? 1 : 0].selectedType != 0) {
                if (this.mediaPages[z ? 1 : 0].selectedType != 1) {
                    if (this.mediaPages[z ? 1 : 0].selectedType != 2) {
                        if (this.mediaPages[z ? 1 : 0].selectedType != 3) {
                            if (this.mediaPages[z ? 1 : 0].selectedType != 4) {
                                if (this.mediaPages[z ? 1 : 0].selectedType != 5) {
                                    if (this.mediaPages[z ? 1 : 0].selectedType != 6) {
                                        if (this.mediaPages[z ? 1 : 0].selectedType == 7 && adapter != this.chatUsersAdapter) {
                                            recycleAdapter(adapter);
                                            this.mediaPages[z ? 1 : 0].listView.setAdapter(this.chatUsersAdapter);
                                        }
                                    } else if (adapter != this.commonGroupsAdapter) {
                                        recycleAdapter(adapter);
                                        this.mediaPages[z ? 1 : 0].listView.setAdapter(this.commonGroupsAdapter);
                                    }
                                } else if (adapter != this.gifAdapter) {
                                    recycleAdapter(adapter);
                                    this.mediaPages[z ? 1 : 0].listView.setAdapter(this.gifAdapter);
                                }
                            } else if (adapter != this.audioAdapter) {
                                recycleAdapter(adapter);
                                this.mediaPages[z ? 1 : 0].listView.setAdapter(this.audioAdapter);
                            }
                        } else if (adapter != this.linksAdapter) {
                            recycleAdapter(adapter);
                            this.mediaPages[z ? 1 : 0].listView.setAdapter(this.linksAdapter);
                        }
                    } else if (adapter != this.voiceAdapter) {
                        recycleAdapter(adapter);
                        this.mediaPages[z ? 1 : 0].listView.setAdapter(this.voiceAdapter);
                    }
                } else if (adapter != this.documentsAdapter) {
                    recycleAdapter(adapter);
                    this.mediaPages[z ? 1 : 0].listView.setAdapter(this.documentsAdapter);
                }
            } else {
                if (adapter != this.photoVideoAdapter) {
                    recycleAdapter(adapter);
                    this.mediaPages[z ? 1 : 0].listView.setAdapter(this.photoVideoAdapter);
                }
                this.mediaPages[z ? 1 : 0].listView.setPinnedHeaderShadowDrawable(this.pinnedHeaderShadowDrawable);
            }
            if (this.mediaPages[z ? 1 : 0].selectedType == 0 || this.mediaPages[z ? 1 : 0].selectedType == 2 || this.mediaPages[z ? 1 : 0].selectedType == 5 || this.mediaPages[z ? 1 : 0].selectedType == 6 || (this.mediaPages[z ? 1 : 0].selectedType == 7 && !this.profileActivity.canSearchMembers())) {
                if (z) {
                    this.searchItemState = 2;
                } else {
                    this.searchItemState = 0;
                    this.searchItem.setVisibility(4);
                }
            } else if (z) {
                if (this.searchItem.getVisibility() == 4 && !this.actionBar.isSearchFieldVisible()) {
                    if (canShowSearchItem()) {
                        this.searchItemState = 1;
                        this.searchItem.setVisibility(0);
                    } else {
                        this.searchItem.setVisibility(4);
                    }
                    this.searchItem.setAlpha(0.0f);
                } else {
                    this.searchItemState = 0;
                }
            } else if (this.searchItem.getVisibility() == 4) {
                if (canShowSearchItem()) {
                    this.searchItemState = 0;
                    this.searchItem.setAlpha(1.0f);
                    this.searchItem.setVisibility(0);
                } else {
                    this.searchItem.setVisibility(4);
                    this.searchItem.setAlpha(0.0f);
                }
            }
            if (this.mediaPages[z ? 1 : 0].selectedType != 6) {
                if (this.mediaPages[z ? 1 : 0].selectedType != 7 && this.profileActivity.getUserConfig().getClientUserId() != this.dialog_id && !this.sharedMediaData[this.mediaPages[z ? 1 : 0].selectedType].loading && !this.sharedMediaData[this.mediaPages[z ? 1 : 0].selectedType].endReached[0] && this.sharedMediaData[this.mediaPages[z ? 1 : 0].selectedType].messages.isEmpty()) {
                    this.sharedMediaData[this.mediaPages[z ? 1 : 0].selectedType].loading = true;
                    this.documentsAdapter.notifyDataSetChanged();
                    this.profileActivity.getMediaDataController().loadMedia(this.dialog_id, 50, 0L, this.mediaPages[z ? 1 : 0].selectedType, 1, this.profileActivity.getClassGuid());
                }
            } else if (!this.commonGroupsAdapter.loading && !this.commonGroupsAdapter.endReached && this.commonGroupsAdapter.chats.isEmpty()) {
                this.commonGroupsAdapter.getChats(0L, 100);
            }
            this.mediaPages[z ? 1 : 0].listView.setVisibility(0);
        } else if (z) {
            if (this.mediaPages[z ? 1 : 0].selectedType == 0 || this.mediaPages[z ? 1 : 0].selectedType == 2 || this.mediaPages[z ? 1 : 0].selectedType == 5 || this.mediaPages[z ? 1 : 0].selectedType == 6 || (this.mediaPages[z ? 1 : 0].selectedType == 7 && !this.profileActivity.canSearchMembers())) {
                this.searching = false;
                this.searchWas = false;
                switchToCurrentSelectedMode(true);
                return;
            }
            String string = this.searchItem.getSearchField().getText().toString();
            if (this.mediaPages[z ? 1 : 0].selectedType != 1) {
                if (this.mediaPages[z ? 1 : 0].selectedType != 3) {
                    if (this.mediaPages[z ? 1 : 0].selectedType != 4) {
                        if (this.mediaPages[z ? 1 : 0].selectedType == 7 && (groupUsersSearchAdapter = this.groupUsersSearchAdapter) != null) {
                            groupUsersSearchAdapter.search(string, false);
                            if (adapter != this.groupUsersSearchAdapter) {
                                recycleAdapter(adapter);
                                this.mediaPages[z ? 1 : 0].listView.setAdapter(this.groupUsersSearchAdapter);
                            }
                        }
                    } else {
                        MediaSearchAdapter mediaSearchAdapter = this.audioSearchAdapter;
                        if (mediaSearchAdapter != null) {
                            mediaSearchAdapter.search(string, false);
                            if (adapter != this.audioSearchAdapter) {
                                recycleAdapter(adapter);
                                this.mediaPages[z ? 1 : 0].listView.setAdapter(this.audioSearchAdapter);
                            }
                        }
                    }
                } else {
                    MediaSearchAdapter mediaSearchAdapter2 = this.linksSearchAdapter;
                    if (mediaSearchAdapter2 != null) {
                        mediaSearchAdapter2.search(string, false);
                        if (adapter != this.linksSearchAdapter) {
                            recycleAdapter(adapter);
                            this.mediaPages[z ? 1 : 0].listView.setAdapter(this.linksSearchAdapter);
                        }
                    }
                }
            } else {
                MediaSearchAdapter mediaSearchAdapter3 = this.documentsSearchAdapter;
                if (mediaSearchAdapter3 != null) {
                    mediaSearchAdapter3.search(string, false);
                    if (adapter != this.documentsSearchAdapter) {
                        recycleAdapter(adapter);
                        this.mediaPages[z ? 1 : 0].listView.setAdapter(this.documentsSearchAdapter);
                    }
                }
            }
        } else if (this.mediaPages[z ? 1 : 0].listView != null) {
            if (this.mediaPages[z ? 1 : 0].selectedType != 1) {
                if (this.mediaPages[z ? 1 : 0].selectedType != 3) {
                    if (this.mediaPages[z ? 1 : 0].selectedType != 4) {
                        if (this.mediaPages[z ? 1 : 0].selectedType == 7) {
                            if (adapter != this.groupUsersSearchAdapter) {
                                recycleAdapter(adapter);
                                this.mediaPages[z ? 1 : 0].listView.setAdapter(this.groupUsersSearchAdapter);
                            }
                            this.groupUsersSearchAdapter.notifyDataSetChanged();
                        }
                    } else {
                        if (adapter != this.audioSearchAdapter) {
                            recycleAdapter(adapter);
                            this.mediaPages[z ? 1 : 0].listView.setAdapter(this.audioSearchAdapter);
                        }
                        this.audioSearchAdapter.notifyDataSetChanged();
                    }
                } else {
                    if (adapter != this.linksSearchAdapter) {
                        recycleAdapter(adapter);
                        this.mediaPages[z ? 1 : 0].listView.setAdapter(this.linksSearchAdapter);
                    }
                    this.linksSearchAdapter.notifyDataSetChanged();
                }
            } else {
                if (adapter != this.documentsSearchAdapter) {
                    recycleAdapter(adapter);
                    this.mediaPages[z ? 1 : 0].listView.setAdapter(this.documentsSearchAdapter);
                }
                this.documentsSearchAdapter.notifyDataSetChanged();
            }
        }
        if (this.searchItemState == 2 && this.actionBar.isSearchFieldVisible()) {
            this.ignoreSearchCollapse = true;
            this.actionBar.closeSearchField();
            this.searchItemState = 0;
            this.searchItem.setAlpha(0.0f);
            this.searchItem.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onItemLongClick(MessageObject messageObject, View view, int i) {
        if (this.isActionModeShowed || this.profileActivity.getParentActivity() == null) {
            return false;
        }
        AndroidUtilities.hideKeyboard(this.profileActivity.getParentActivity().getCurrentFocus());
        this.selectedFiles[messageObject.getDialogId() == this.dialog_id ? (char) 0 : (char) 1].put(messageObject.getId(), messageObject);
        if (!messageObject.canDeleteMessage(false, null)) {
            this.cantDeleteMessagesCount++;
        }
        this.deleteItem.setVisibility(this.cantDeleteMessagesCount == 0 ? 0 : 8);
        ActionBarMenuItem actionBarMenuItem = this.gotoItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setVisibility(0);
        }
        this.selectedMessagesCountTextView.setNumber(1, false);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.actionModeViews.size(); i2++) {
            View view2 = this.actionModeViews.get(i2);
            AndroidUtilities.clearDrawableAnimation(view2);
            arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_Y, 0.1f, 1.0f));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(250L);
        animatorSet.start();
        this.scrolling = false;
        if (view instanceof SharedDocumentCell) {
            ((SharedDocumentCell) view).setChecked(true, true);
        } else if (view instanceof SharedPhotoVideoCell) {
            ((SharedPhotoVideoCell) view).setChecked(i, true, true);
        } else if (view instanceof SharedLinkCell) {
            ((SharedLinkCell) view).setChecked(true, true);
        } else if (view instanceof SharedAudioCell) {
            ((SharedAudioCell) view).setChecked(true, true);
        } else if (view instanceof ContextLinkCell) {
            ((ContextLinkCell) view).setChecked(true, true);
        }
        if (!this.isActionModeShowed) {
            showActionMode(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(int i, View view, MessageObject messageObject, int i2, int i3) {
        int i4;
        if (messageObject == null) {
            return;
        }
        String link = null;
        if (this.isActionModeShowed) {
            char c = messageObject.getDialogId() == this.dialog_id ? (char) 0 : (char) 1;
            if (this.selectedFiles[c].indexOfKey(messageObject.getId()) >= 0) {
                this.selectedFiles[c].remove(messageObject.getId());
                if (!messageObject.canDeleteMessage(false, null)) {
                    this.cantDeleteMessagesCount--;
                }
            } else {
                if (this.selectedFiles[0].size() + this.selectedFiles[1].size() >= this.maxSelectedCount) {
                    return;
                }
                this.selectedFiles[c].put(messageObject.getId(), messageObject);
                if (!messageObject.canDeleteMessage(false, null)) {
                    this.cantDeleteMessagesCount++;
                }
            }
            if (this.selectedFiles[0].size() == 0 && this.selectedFiles[1].size() == 0) {
                showActionMode(false);
            } else {
                this.selectedMessagesCountTextView.setNumber(this.selectedFiles[0].size() + this.selectedFiles[1].size(), true);
                this.deleteItem.setVisibility(this.cantDeleteMessagesCount == 0 ? 0 : 8);
                ActionBarMenuItem actionBarMenuItem = this.gotoItem;
                if (actionBarMenuItem != null) {
                    actionBarMenuItem.setVisibility(this.selectedFiles[0].size() == 1 ? 0 : 8);
                }
            }
            this.scrolling = false;
            if (view instanceof SharedDocumentCell) {
                ((SharedDocumentCell) view).setChecked(this.selectedFiles[c].indexOfKey(messageObject.getId()) >= 0, true);
                return;
            }
            if (view instanceof SharedPhotoVideoCell) {
                SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) view;
                if (this.selectedFiles[c].indexOfKey(messageObject.getId()) >= 0) {
                    i4 = i2;
                    z = true;
                } else {
                    i4 = i2;
                }
                sharedPhotoVideoCell.setChecked(i4, z, true);
                return;
            }
            if (view instanceof SharedLinkCell) {
                ((SharedLinkCell) view).setChecked(this.selectedFiles[c].indexOfKey(messageObject.getId()) >= 0, true);
                return;
            } else if (view instanceof SharedAudioCell) {
                ((SharedAudioCell) view).setChecked(this.selectedFiles[c].indexOfKey(messageObject.getId()) >= 0, true);
                return;
            } else {
                if (view instanceof ContextLinkCell) {
                    ((ContextLinkCell) view).setChecked(this.selectedFiles[c].indexOfKey(messageObject.getId()) >= 0, true);
                    return;
                }
                return;
            }
        }
        if (i3 == 0) {
            PhotoViewer.getInstance().setParentActivity(this.profileActivity.getParentActivity());
            PhotoViewer.getInstance().openPhoto(this.sharedMediaData[i3].messages, i, this.dialog_id, this.mergeDialogId, this.provider);
            return;
        }
        if (i3 == 2 || i3 == 4) {
            if (view instanceof SharedAudioCell) {
                ((SharedAudioCell) view).didPressedButton();
                return;
            }
            return;
        }
        if (i3 == 5) {
            PhotoViewer.getInstance().setParentActivity(this.profileActivity.getParentActivity());
            int iIndexOf = this.sharedMediaData[i3].messages.indexOf(messageObject);
            if (iIndexOf < 0) {
                ArrayList<MessageObject> arrayList = new ArrayList<>();
                arrayList.add(messageObject);
                PhotoViewer.getInstance().openPhoto(arrayList, 0, 0L, 0L, this.provider);
                return;
            }
            PhotoViewer.getInstance().openPhoto(this.sharedMediaData[i3].messages, iIndexOf, this.dialog_id, this.mergeDialogId, this.provider);
            return;
        }
        if (i3 == 1) {
            if (view instanceof SharedDocumentCell) {
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) view;
                TLRPC$Document document = messageObject.getDocument();
                if (sharedDocumentCell.isLoaded()) {
                    if (messageObject.canPreviewDocument()) {
                        PhotoViewer.getInstance().setParentActivity(this.profileActivity.getParentActivity());
                        int iIndexOf2 = this.sharedMediaData[i3].messages.indexOf(messageObject);
                        if (iIndexOf2 < 0) {
                            ArrayList<MessageObject> arrayList2 = new ArrayList<>();
                            arrayList2.add(messageObject);
                            PhotoViewer.getInstance().openPhoto(arrayList2, 0, 0L, 0L, this.provider);
                            return;
                        }
                        PhotoViewer.getInstance().openPhoto(this.sharedMediaData[i3].messages, iIndexOf2, this.dialog_id, this.mergeDialogId, this.provider);
                        return;
                    }
                    AndroidUtilities.openDocument(messageObject, this.profileActivity.getParentActivity(), this.profileActivity);
                    return;
                }
                if (!sharedDocumentCell.isLoading()) {
                    this.profileActivity.getFileLoader().loadFile(document, sharedDocumentCell.getMessage(), 0, 0);
                    sharedDocumentCell.updateFileExistIcon(true);
                    return;
                } else {
                    this.profileActivity.getFileLoader().cancelLoadFile(document);
                    sharedDocumentCell.updateFileExistIcon(true);
                    return;
                }
            }
            return;
        }
        if (i3 == 3) {
            try {
                TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
                TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia != null ? tLRPC$MessageMedia.webpage : null;
                if (tLRPC$WebPage != null && !(tLRPC$WebPage instanceof TLRPC$TL_webPageEmpty)) {
                    if (tLRPC$WebPage.cached_page != null) {
                        ArticleViewer.getInstance().setParentActivity(this.profileActivity.getParentActivity(), this.profileActivity);
                        ArticleViewer.getInstance().open(messageObject);
                        return;
                    }
                    String str = tLRPC$WebPage.embed_url;
                    if (str != null && str.length() != 0) {
                        openWebView(tLRPC$WebPage);
                        return;
                    }
                    link = tLRPC$WebPage.url;
                }
                if (link == null) {
                    link = ((SharedLinkCell) view).getLink(0);
                }
                if (link != null) {
                    openUrl(link);
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        if (AndroidUtilities.shouldShowUrlInAlert(str)) {
            AlertsCreator.showOpenUrlAlert(this.profileActivity, str, true, true);
        } else {
            Browser.openUrl(this.profileActivity.getParentActivity(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebView(TLRPC$WebPage tLRPC$WebPage) {
        EmbedBottomSheet.show(this.profileActivity.getParentActivity(), tLRPC$WebPage.site_name, tLRPC$WebPage.description, tLRPC$WebPage.url, tLRPC$WebPage.embed_url, tLRPC$WebPage.embed_width, tLRPC$WebPage.embed_height, false);
    }

    private void recycleAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof SharedPhotoVideoAdapter) {
            this.cellCache.addAll(this.cache);
            this.cache.clear();
        } else if (adapter == this.audioAdapter) {
            this.audioCellCache.addAll(this.audioCache);
            this.audioCache.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal(int i) {
        int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i == 0) {
            if (!AndroidUtilities.isTablet() && ApplicationLoader.applicationContext.getResources().getConfiguration().orientation == 2) {
                this.selectedMessagesCountTextView.setTextSize(18);
            } else {
                this.selectedMessagesCountTextView.setTextSize(20);
            }
        }
        if (AndroidUtilities.isTablet()) {
            this.columnsCount = 3;
        } else if (rotation == 3 || rotation == 1) {
            this.columnsCount = 6;
        } else {
            this.columnsCount = 3;
        }
        if (i == 0) {
            this.photoVideoAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: org.rbmain.ui.Components.SharedMediaLayout$20, reason: invalid class name */
    class AnonymousClass20 implements SharedLinkCell.SharedLinkCellDelegate {
        AnonymousClass20() {
        }

        @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public void needOpenWebView(TLRPC$WebPage tLRPC$WebPage) {
            SharedMediaLayout.this.openWebView(tLRPC$WebPage);
        }

        @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public boolean canPerformActions() {
            return !SharedMediaLayout.this.isActionModeShowed;
        }

        @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public void onLinkPress(final String str, boolean z) {
            if (!z) {
                SharedMediaLayout.this.openUrl(str);
                return;
            }
            BottomSheet.Builder builder = new BottomSheet.Builder(SharedMediaLayout.this.profileActivity.getParentActivity());
            builder.setTitle(str);
            builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.SharedMediaLayout$20$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onLinkPress$0(str, dialogInterface, i);
                }
            });
            SharedMediaLayout.this.profileActivity.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLinkPress$0(String str, DialogInterface dialogInterface, int i) {
            if (i == 0) {
                SharedMediaLayout.this.openUrl(str);
                return;
            }
            if (i == 1) {
                if (str.startsWith("mailto:")) {
                    str = str.substring(7);
                } else if (str.startsWith("tel:")) {
                    str = str.substring(4);
                }
                AndroidUtilities.addToClipboard(str);
            }
        }
    }

    private class SharedLinksAdapter extends RecyclerListView.SectionsAdapter {
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int i, int i2) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            return null;
        }

        public SharedLinksAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            if (SharedMediaLayout.this.sharedMediaData[3].sections.size() != 0 || SharedMediaLayout.this.sharedMediaData[3].loading) {
                return i == 0 || i2 != 0;
            }
            return false;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            int i = 1;
            if (SharedMediaLayout.this.sharedMediaData[3].sections.size() == 0 && !SharedMediaLayout.this.sharedMediaData[3].loading) {
                return 1;
            }
            int size = SharedMediaLayout.this.sharedMediaData[3].sections.size();
            if (SharedMediaLayout.this.sharedMediaData[3].sections.isEmpty() || (SharedMediaLayout.this.sharedMediaData[3].endReached[0] && SharedMediaLayout.this.sharedMediaData[3].endReached[1])) {
                i = 0;
            }
            return size + i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int i) {
            if ((SharedMediaLayout.this.sharedMediaData[3].sections.size() != 0 || SharedMediaLayout.this.sharedMediaData[3].loading) && i < SharedMediaLayout.this.sharedMediaData[3].sections.size()) {
                return SharedMediaLayout.this.sharedMediaData[3].sectionArrays.get(SharedMediaLayout.this.sharedMediaData[3].sections.get(i)).size() + (i == 0 ? 0 : 1);
            }
            return 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor(Theme.key_graySection) & (-218103809));
            }
            if (i != 0) {
                if (i < SharedMediaLayout.this.sharedMediaData[3].sections.size()) {
                    view.setAlpha(1.0f);
                    ((GraySectionCell) view).setText(LocaleController.formatSectionDate(SharedMediaLayout.this.sharedMediaData[3].sectionArrays.get(SharedMediaLayout.this.sharedMediaData[3].sections.get(i)).get(0).messageOwner.date));
                }
            } else {
                view.setAlpha(0.0f);
            }
            return view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            GraySectionCell graySectionCell;
            if (i == 0) {
                graySectionCell = new GraySectionCell(this.mContext);
            } else if (i == 1) {
                SharedLinkCell sharedLinkCell = new SharedLinkCell(this.mContext);
                sharedLinkCell.setDelegate(SharedMediaLayout.this.sharedLinkCellDelegate);
                graySectionCell = sharedLinkCell;
            } else {
                if (i == 3) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 3, SharedMediaLayout.this.dialog_id);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                flickerLoadingView.setIsSingleCell(true);
                flickerLoadingView.showDate(false);
                flickerLoadingView.setViewType(5);
                graySectionCell = flickerLoadingView;
            }
            graySectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(graySectionCell);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 2 || viewHolder.getItemViewType() == 3) {
                return;
            }
            ArrayList<MessageObject> arrayList = SharedMediaLayout.this.sharedMediaData[3].sectionArrays.get(SharedMediaLayout.this.sharedMediaData[3].sections.get(i));
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((GraySectionCell) viewHolder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                return;
            }
            if (itemViewType != 1) {
                return;
            }
            if (i != 0) {
                i2--;
            }
            SharedLinkCell sharedLinkCell = (SharedLinkCell) viewHolder.itemView;
            MessageObject messageObject = arrayList.get(i2);
            sharedLinkCell.setLink(messageObject, i2 != arrayList.size() - 1 || (i == SharedMediaLayout.this.sharedMediaData[3].sections.size() - 1 && SharedMediaLayout.this.sharedMediaData[3].loading));
            if (SharedMediaLayout.this.isActionModeShowed) {
                sharedLinkCell.setChecked(SharedMediaLayout.this.selectedFiles[(messageObject.getDialogId() > SharedMediaLayout.this.dialog_id ? 1 : (messageObject.getDialogId() == SharedMediaLayout.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !SharedMediaLayout.this.scrolling);
            } else {
                sharedLinkCell.setChecked(false, !SharedMediaLayout.this.scrolling);
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            if (SharedMediaLayout.this.sharedMediaData[3].sections.size() == 0 && !SharedMediaLayout.this.sharedMediaData[3].loading) {
                return 3;
            }
            if (i < SharedMediaLayout.this.sharedMediaData[3].sections.size()) {
                return (i == 0 || i2 != 0) ? 1 : 0;
            }
            return 2;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
    }

    private class SharedDocumentsAdapter extends RecyclerListView.SectionsAdapter {
        private int currentType;
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int i, int i2) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            return null;
        }

        public SharedDocumentsAdapter(Context context, int i) {
            this.mContext = context;
            this.currentType = i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            if (SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size() != 0 || SharedMediaLayout.this.sharedMediaData[this.currentType].loading) {
                return i == 0 || i2 != 0;
            }
            return false;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            int i = 1;
            if (SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size() == 0 && !SharedMediaLayout.this.sharedMediaData[this.currentType].loading) {
                return 1;
            }
            int size = SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size();
            if (SharedMediaLayout.this.sharedMediaData[this.currentType].sections.isEmpty() || (SharedMediaLayout.this.sharedMediaData[this.currentType].endReached[0] && SharedMediaLayout.this.sharedMediaData[this.currentType].endReached[1])) {
                i = 0;
            }
            return size + i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int i) {
            if ((SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size() != 0 || SharedMediaLayout.this.sharedMediaData[this.currentType].loading) && i < SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size()) {
                return SharedMediaLayout.this.sharedMediaData[this.currentType].sectionArrays.get(SharedMediaLayout.this.sharedMediaData[this.currentType].sections.get(i)).size() + (i == 0 ? 0 : 1);
            }
            return 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor(Theme.key_graySection) & (-218103809));
            }
            if (i != 0) {
                if (i < SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size()) {
                    view.setAlpha(1.0f);
                    ((GraySectionCell) view).setText(LocaleController.formatSectionDate(SharedMediaLayout.this.sharedMediaData[this.currentType].sectionArrays.get(SharedMediaLayout.this.sharedMediaData[this.currentType].sections.get(i)).get(0).messageOwner.date));
                }
            } else {
                view.setAlpha(0.0f);
            }
            return view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View graySectionCell;
            View view;
            if (i == 0) {
                graySectionCell = new GraySectionCell(this.mContext);
            } else if (i == 1) {
                graySectionCell = new SharedDocumentCell(this.mContext);
            } else if (i == 2) {
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                if (this.currentType == 2) {
                    flickerLoadingView.setViewType(4);
                } else {
                    flickerLoadingView.setViewType(3);
                }
                flickerLoadingView.showDate(false);
                flickerLoadingView.setIsSingleCell(true);
                graySectionCell = flickerLoadingView;
            } else {
                if (i == 4) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, this.currentType, SharedMediaLayout.this.dialog_id);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                if (this.currentType == 4 && !SharedMediaLayout.this.audioCellCache.isEmpty()) {
                    View view2 = (View) SharedMediaLayout.this.audioCellCache.get(0);
                    SharedMediaLayout.this.audioCellCache.remove(0);
                    ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                    view = view2;
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(view2);
                        view = view2;
                    }
                } else {
                    view = new SharedAudioCell(this.mContext) { // from class: org.rbmain.ui.Components.SharedMediaLayout.SharedDocumentsAdapter.1
                        @Override // org.rbmain.ui.Cells.SharedAudioCell
                        public boolean needPlayMessage(MessageObject messageObject) {
                            if (messageObject.isVoice() || messageObject.isRoundVideo()) {
                                boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject);
                                MediaController.getInstance().setVoiceMessagesPlaylist(zPlayMessage ? SharedMediaLayout.this.sharedMediaData[SharedDocumentsAdapter.this.currentType].messages : null, false);
                                return zPlayMessage;
                            }
                            if (messageObject.isMusic()) {
                                return MediaController.getInstance().setPlaylist(SharedMediaLayout.this.sharedMediaData[SharedDocumentsAdapter.this.currentType].messages, messageObject, SharedMediaLayout.this.mergeDialogId);
                            }
                            return false;
                        }
                    };
                }
                graySectionCell = view;
                if (this.currentType == 4) {
                    SharedMediaLayout.this.audioCache.add((SharedAudioCell) view);
                    graySectionCell = view;
                }
            }
            graySectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(graySectionCell);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 2 || viewHolder.getItemViewType() == 4) {
                return;
            }
            ArrayList<MessageObject> arrayList = SharedMediaLayout.this.sharedMediaData[this.currentType].sectionArrays.get(SharedMediaLayout.this.sharedMediaData[this.currentType].sections.get(i));
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((GraySectionCell) viewHolder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                return;
            }
            if (itemViewType == 1) {
                if (i != 0) {
                    i2--;
                }
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) viewHolder.itemView;
                MessageObject messageObject = arrayList.get(i2);
                sharedDocumentCell.setDocument(messageObject, i2 != arrayList.size() - 1 || (i == SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size() - 1 && SharedMediaLayout.this.sharedMediaData[this.currentType].loading));
                if (SharedMediaLayout.this.isActionModeShowed) {
                    sharedDocumentCell.setChecked(SharedMediaLayout.this.selectedFiles[(messageObject.getDialogId() > SharedMediaLayout.this.dialog_id ? 1 : (messageObject.getDialogId() == SharedMediaLayout.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !SharedMediaLayout.this.scrolling);
                    return;
                } else {
                    sharedDocumentCell.setChecked(false, !SharedMediaLayout.this.scrolling);
                    return;
                }
            }
            if (itemViewType != 3) {
                return;
            }
            if (i != 0) {
                i2--;
            }
            SharedAudioCell sharedAudioCell = (SharedAudioCell) viewHolder.itemView;
            MessageObject messageObject2 = arrayList.get(i2);
            sharedAudioCell.setMessageObject(messageObject2, i2 != arrayList.size() - 1 || (i == SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size() - 1 && SharedMediaLayout.this.sharedMediaData[this.currentType].loading));
            if (SharedMediaLayout.this.isActionModeShowed) {
                sharedAudioCell.setChecked(SharedMediaLayout.this.selectedFiles[(messageObject2.getDialogId() > SharedMediaLayout.this.dialog_id ? 1 : (messageObject2.getDialogId() == SharedMediaLayout.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject2.getId()) >= 0, !SharedMediaLayout.this.scrolling);
            } else {
                sharedAudioCell.setChecked(false, !SharedMediaLayout.this.scrolling);
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            if (SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size() == 0 && !SharedMediaLayout.this.sharedMediaData[this.currentType].loading) {
                return 4;
            }
            if (i >= SharedMediaLayout.this.sharedMediaData[this.currentType].sections.size()) {
                return 2;
            }
            if (i != 0 && i2 == 0) {
                return 0;
            }
            int i3 = this.currentType;
            return (i3 == 2 || i3 == 4) ? 3 : 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
            int measuredHeight = recyclerListView.getChildAt(0).getMeasuredHeight();
            float totalItemsCount = f * ((getTotalItemsCount() * measuredHeight) - (recyclerListView.getMeasuredHeight() - recyclerListView.getPaddingTop()));
            iArr[0] = (int) (totalItemsCount / measuredHeight);
            iArr[1] = ((int) totalItemsCount) % measuredHeight;
        }
    }

    public static View createEmptyStubView(Context context, int i, long j) {
        EmptyStubView emptyStubView = new EmptyStubView(context);
        if (i == 0) {
            emptyStubView.emptyImageView.setImageResource(R.drawable.tip1);
            if (((int) j) == 0) {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoMediaSecret", R.string.NoMediaSecret));
            } else {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoMedia", R.string.NoMedia));
            }
        } else if (i == 1) {
            emptyStubView.emptyImageView.setImageResource(R.drawable.tip2);
            if (((int) j) == 0) {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedFilesSecret", R.string.NoSharedFilesSecret));
            } else {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedFiles", R.string.NoSharedFiles));
            }
        } else if (i == 2) {
            emptyStubView.emptyImageView.setImageResource(R.drawable.tip5);
            if (((int) j) == 0) {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedVoiceSecret", R.string.NoSharedVoiceSecret));
            } else {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedVoice", R.string.NoSharedVoice));
            }
        } else if (i == 3) {
            emptyStubView.emptyImageView.setImageResource(R.drawable.tip3);
            if (((int) j) == 0) {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedLinksSecret", R.string.NoSharedLinksSecret));
            } else {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedLinks", R.string.NoSharedLinks));
            }
        } else if (i == 4) {
            emptyStubView.emptyImageView.setImageResource(R.drawable.tip4);
            if (((int) j) == 0) {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedAudioSecret", R.string.NoSharedAudioSecret));
            } else {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedAudio", R.string.NoSharedAudio));
            }
        } else if (i == 5) {
            emptyStubView.emptyImageView.setImageResource(R.drawable.tip1);
            if (((int) j) == 0) {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoSharedGifSecret", R.string.NoSharedGifSecret));
            } else {
                emptyStubView.emptyTextView.setText(LocaleController.getString("NoGIFs", R.string.NoGIFs));
            }
        } else if (i == 6) {
            emptyStubView.emptyImageView.setImageDrawable(null);
            emptyStubView.emptyTextView.setText(LocaleController.getString("NoGroupsInCommon", R.string.NoGroupsInCommon));
        } else if (i == 7) {
            emptyStubView.emptyImageView.setImageDrawable(null);
            emptyStubView.emptyTextView.setText(BuildConfig.FLAVOR);
        }
        return emptyStubView;
    }

    private static class EmptyStubView extends LinearLayout {
        final ImageView emptyImageView;
        final TextView emptyTextView;
        boolean ignoreRequestLayout;

        public EmptyStubView(Context context) {
            super(context);
            TextView textView = new TextView(context);
            this.emptyTextView = textView;
            ImageView imageView = new ImageView(context);
            this.emptyImageView = imageView;
            setOrientation(1);
            setGravity(17);
            addView(imageView, LayoutHelper.createLinear(-2, -2));
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2));
            textView.setGravity(17);
            textView.setTextSize(1, 17.0f);
            textView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(128.0f));
            addView(textView, LayoutHelper.createLinear(-2, -2, 17, 0, 24, 0, 0));
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
            this.ignoreRequestLayout = true;
            if (AndroidUtilities.isTablet()) {
                this.emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(128.0f));
            } else if (rotation == 3 || rotation == 1) {
                this.emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
            } else {
                this.emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(128.0f));
            }
            this.ignoreRequestLayout = false;
            super.onMeasure(i, i2);
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreRequestLayout) {
                return;
            }
            super.requestLayout();
        }
    }

    private class SharedPhotoVideoAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public SharedPhotoVideoAdapter(Context context) {
            this.mContext = context;
        }

        public int getPositionForIndex(int i) {
            return i / SharedMediaLayout.this.columnsCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (SharedMediaLayout.this.sharedMediaData[0].messages.size() == 0 && !SharedMediaLayout.this.sharedMediaData[0].loading) {
                return 1;
            }
            int iCeil = (int) Math.ceil(SharedMediaLayout.this.sharedMediaData[0].messages.size() / SharedMediaLayout.this.columnsCount);
            return iCeil != 0 ? (SharedMediaLayout.this.sharedMediaData[0].endReached[0] && SharedMediaLayout.this.sharedMediaData[0].endReached[1]) ? iCeil : iCeil + 1 : iCeil;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View sharedPhotoVideoCell;
            View view;
            if (i == 0) {
                if (!SharedMediaLayout.this.cellCache.isEmpty()) {
                    View view2 = (View) SharedMediaLayout.this.cellCache.get(0);
                    SharedMediaLayout.this.cellCache.remove(0);
                    ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                    sharedPhotoVideoCell = view2;
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(view2);
                        sharedPhotoVideoCell = view2;
                    }
                } else {
                    sharedPhotoVideoCell = new SharedPhotoVideoCell(this.mContext);
                }
                SharedPhotoVideoCell sharedPhotoVideoCell2 = (SharedPhotoVideoCell) sharedPhotoVideoCell;
                sharedPhotoVideoCell2.setDelegate(new SharedPhotoVideoCell.SharedPhotoVideoCellDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout.SharedPhotoVideoAdapter.1
                    @Override // org.rbmain.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public void didClickItem(SharedPhotoVideoCell sharedPhotoVideoCell3, int i2, MessageObject messageObject, int i3) {
                        SharedMediaLayout.this.onItemClick(i2, sharedPhotoVideoCell3, messageObject, i3, 0);
                    }

                    @Override // org.rbmain.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public boolean didLongClickItem(SharedPhotoVideoCell sharedPhotoVideoCell3, int i2, MessageObject messageObject, int i3) {
                        if (!SharedMediaLayout.this.isActionModeShowed) {
                            return SharedMediaLayout.this.onItemLongClick(messageObject, sharedPhotoVideoCell3, i3);
                        }
                        didClickItem(sharedPhotoVideoCell3, i2, messageObject, i3);
                        return true;
                    }
                });
                SharedMediaLayout.this.cache.add(sharedPhotoVideoCell2);
                view = sharedPhotoVideoCell;
            } else {
                if (i != 1) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 0, SharedMediaLayout.this.dialog_id);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext) { // from class: org.rbmain.ui.Components.SharedMediaLayout.SharedPhotoVideoAdapter.2
                    @Override // org.rbmain.ui.Components.FlickerLoadingView
                    public int getColumnsCount() {
                        return SharedMediaLayout.this.columnsCount;
                    }
                };
                flickerLoadingView.setIsSingleCell(true);
                flickerLoadingView.setViewType(2);
                view = flickerLoadingView;
            }
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ArrayList<MessageObject> arrayList = SharedMediaLayout.this.sharedMediaData[0].messages;
                SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) viewHolder.itemView;
                sharedPhotoVideoCell.setItemsCount(SharedMediaLayout.this.columnsCount);
                sharedPhotoVideoCell.setIsFirst(i == 0);
                for (int i2 = 0; i2 < SharedMediaLayout.this.columnsCount; i2++) {
                    int i3 = (SharedMediaLayout.this.columnsCount * i) + i2;
                    if (i3 < arrayList.size()) {
                        MessageObject messageObject = arrayList.get(i3);
                        sharedPhotoVideoCell.setItem(i2, SharedMediaLayout.this.sharedMediaData[0].messages.indexOf(messageObject), messageObject);
                        if (SharedMediaLayout.this.isActionModeShowed) {
                            sharedPhotoVideoCell.setChecked(i2, SharedMediaLayout.this.selectedFiles[(messageObject.getDialogId() > SharedMediaLayout.this.dialog_id ? 1 : (messageObject.getDialogId() == SharedMediaLayout.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !SharedMediaLayout.this.scrolling);
                        } else {
                            sharedPhotoVideoCell.setChecked(i2, false, !SharedMediaLayout.this.scrolling);
                        }
                    } else {
                        sharedPhotoVideoCell.setItem(i2, i3, null);
                    }
                }
                sharedPhotoVideoCell.requestLayout();
                return;
            }
            if (viewHolder.getItemViewType() == 1) {
                ((FlickerLoadingView) viewHolder.itemView).skipDrawItemsCount(SharedMediaLayout.this.columnsCount - ((SharedMediaLayout.this.columnsCount * ((int) Math.ceil(SharedMediaLayout.this.sharedMediaData[0].messages.size() / SharedMediaLayout.this.columnsCount))) - SharedMediaLayout.this.sharedMediaData[0].messages.size()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (SharedMediaLayout.this.sharedMediaData[0].messages.size() != 0 || SharedMediaLayout.this.sharedMediaData[0].loading) {
                return i < ((int) Math.ceil((double) (((float) SharedMediaLayout.this.sharedMediaData[0].messages.size()) / ((float) SharedMediaLayout.this.columnsCount)))) ? 0 : 1;
            }
            return 2;
        }
    }

    public class MediaSearchAdapter extends RecyclerListView.SelectionAdapter {
        private int currentType;
        private int lastReqId;
        private Context mContext;
        private Runnable searchRunnable;
        private int searchesInProgress;
        private ArrayList<MessageObject> searchResult = new ArrayList<>();
        protected ArrayList<MessageObject> globalSearch = new ArrayList<>();
        private int reqId = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        public MediaSearchAdapter(Context context, int i) {
            this.mContext = context;
            this.currentType = i;
        }

        public void queryServerSearch(String str, final long j, long j2) {
            int i = (int) j2;
            if (i == 0) {
                return;
            }
            if (this.reqId != 0) {
                SharedMediaLayout.this.profileActivity.getConnectionsManager().cancelRequest(this.reqId, true);
                this.reqId = 0;
                this.searchesInProgress--;
            }
            if (str == null || str.length() == 0) {
                this.globalSearch.clear();
                this.lastReqId = 0;
                notifyDataSetChanged();
                return;
            }
            TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
            tLRPC$TL_messages_search.limit = 50;
            tLRPC$TL_messages_search.offset_id = j;
            int i2 = this.currentType;
            if (i2 == 1) {
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterDocument();
            } else if (i2 == 3) {
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterUrl();
            } else if (i2 == 4) {
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterMusic();
            }
            tLRPC$TL_messages_search.q = str;
            TLRPC$InputPeer inputPeer = SharedMediaLayout.this.profileActivity.getMessagesController().getInputPeer(i);
            tLRPC$TL_messages_search.peer = inputPeer;
            if (inputPeer == null) {
                return;
            }
            final int i3 = this.lastReqId + 1;
            this.lastReqId = i3;
            this.searchesInProgress++;
            this.reqId = SharedMediaLayout.this.profileActivity.getConnectionsManager().sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout$MediaSearchAdapter$$ExternalSyntheticLambda4
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$queryServerSearch$1(j, i3, tLObject, tLRPC$TL_error);
                }
            }, 2);
            SharedMediaLayout.this.profileActivity.getConnectionsManager().bindRequestToGuid(this.reqId, SharedMediaLayout.this.profileActivity.getClassGuid());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$queryServerSearch$1(long j, final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            final ArrayList arrayList = new ArrayList();
            if (tLRPC$TL_error == null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                for (int i2 = 0; i2 < tLRPC$messages_Messages.messages.size(); i2++) {
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i2);
                    if (j == 0 || tLRPC$Message.id <= j) {
                        arrayList.add(new MessageObject(SharedMediaLayout.this.profileActivity.getCurrentAccount(), tLRPC$Message, false, true));
                    }
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$MediaSearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$queryServerSearch$0(i, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$queryServerSearch$0(int i, ArrayList arrayList) {
            if (this.reqId != 0) {
                if (i == this.lastReqId) {
                    int itemCount = getItemCount();
                    this.globalSearch = arrayList;
                    this.searchesInProgress--;
                    int itemCount2 = getItemCount();
                    if (this.searchesInProgress == 0 || itemCount2 != 0) {
                        SharedMediaLayout.this.switchToCurrentSelectedMode(false);
                    }
                    for (int i2 = 0; i2 < SharedMediaLayout.this.mediaPages.length; i2++) {
                        if (SharedMediaLayout.this.mediaPages[i2].selectedType == this.currentType) {
                            if (this.searchesInProgress == 0 && itemCount2 == 0) {
                                SharedMediaLayout.this.mediaPages[i2].emptyView.showProgress(false, true);
                            } else if (itemCount == 0) {
                                SharedMediaLayout sharedMediaLayout = SharedMediaLayout.this;
                                sharedMediaLayout.animateItemsEnter(sharedMediaLayout.mediaPages[i2].listView, 0);
                            }
                        }
                    }
                    notifyDataSetChanged();
                }
                this.reqId = 0;
            }
        }

        public void search(final String str, boolean z) {
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.searchRunnable = null;
            }
            if (!this.searchResult.isEmpty() || !this.globalSearch.isEmpty()) {
                this.searchResult.clear();
                this.globalSearch.clear();
                notifyDataSetChanged();
            }
            if (!TextUtils.isEmpty(str)) {
                for (int i = 0; i < SharedMediaLayout.this.mediaPages.length; i++) {
                    if (SharedMediaLayout.this.mediaPages[i].selectedType == this.currentType) {
                        SharedMediaLayout.this.mediaPages[i].emptyView.showProgress(true, z);
                    }
                }
                Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$MediaSearchAdapter$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$search$3(str);
                    }
                };
                this.searchRunnable = runnable2;
                AndroidUtilities.runOnUIThread(runnable2, 300L);
                return;
            }
            if (this.searchResult.isEmpty() && this.globalSearch.isEmpty() && this.searchesInProgress == 0) {
                return;
            }
            this.searchResult.clear();
            this.globalSearch.clear();
            if (this.reqId != 0) {
                SharedMediaLayout.this.profileActivity.getConnectionsManager().cancelRequest(this.reqId, true);
                this.reqId = 0;
                this.searchesInProgress--;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$search$3(final String str) {
            int i;
            if (!SharedMediaLayout.this.sharedMediaData[this.currentType].messages.isEmpty() && ((i = this.currentType) == 1 || i == 4)) {
                MessageObject messageObject = SharedMediaLayout.this.sharedMediaData[this.currentType].messages.get(SharedMediaLayout.this.sharedMediaData[this.currentType].messages.size() - 1);
                queryServerSearch(str, messageObject.getId(), messageObject.getDialogId());
            } else if (this.currentType == 3) {
                queryServerSearch(str, 0L, SharedMediaLayout.this.dialog_id);
            }
            int i2 = this.currentType;
            if (i2 == 1 || i2 == 4) {
                final ArrayList arrayList = new ArrayList(SharedMediaLayout.this.sharedMediaData[this.currentType].messages);
                this.searchesInProgress++;
                Utilities.searchQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$MediaSearchAdapter$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$search$2(str, arrayList);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$search$2(String str, ArrayList arrayList) {
            TLRPC$Document tLRPC$Document;
            boolean zContains;
            String str2;
            String lowerCase = str.trim().toLowerCase();
            if (lowerCase.length() == 0) {
                updateSearchResults(new ArrayList<>());
                return;
            }
            String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
            if (lowerCase.equals(translitString) || translitString.length() == 0) {
                translitString = null;
            }
            int i = (translitString != null ? 1 : 0) + 1;
            String[] strArr = new String[i];
            strArr[0] = lowerCase;
            if (translitString != null) {
                strArr[1] = translitString;
            }
            ArrayList<MessageObject> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                MessageObject messageObject = (MessageObject) arrayList.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 < i) {
                        String str3 = strArr[i3];
                        String documentName = messageObject.getDocumentName();
                        if (documentName != null && documentName.length() != 0) {
                            if (documentName.toLowerCase().contains(str3)) {
                                arrayList2.add(messageObject);
                                break;
                            }
                            if (this.currentType == 4) {
                                if (messageObject.type == 0) {
                                    tLRPC$Document = messageObject.messageOwner.media.webpage.document;
                                } else {
                                    tLRPC$Document = messageObject.messageOwner.media.document;
                                }
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= tLRPC$Document.attributes.size()) {
                                        zContains = false;
                                        break;
                                    }
                                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i4);
                                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                                        String str4 = tLRPC$DocumentAttribute.performer;
                                        zContains = str4 != null ? str4.toLowerCase().contains(str3) : false;
                                        if (!zContains && (str2 = tLRPC$DocumentAttribute.title) != null) {
                                            zContains = str2.toLowerCase().contains(str3);
                                        }
                                    } else {
                                        i4++;
                                    }
                                }
                                if (zContains) {
                                    arrayList2.add(messageObject);
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                        i3++;
                    }
                }
            }
            updateSearchResults(arrayList2);
        }

        private void updateSearchResults(final ArrayList<MessageObject> arrayList) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$MediaSearchAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$4(ArrayList arrayList) {
            if (SharedMediaLayout.this.searching) {
                this.searchesInProgress--;
                int itemCount = getItemCount();
                this.searchResult = arrayList;
                int itemCount2 = getItemCount();
                if (this.searchesInProgress == 0 || itemCount2 != 0) {
                    SharedMediaLayout.this.switchToCurrentSelectedMode(false);
                }
                for (int i = 0; i < SharedMediaLayout.this.mediaPages.length; i++) {
                    if (SharedMediaLayout.this.mediaPages[i].selectedType == this.currentType) {
                        if (this.searchesInProgress == 0 && itemCount2 == 0) {
                            SharedMediaLayout.this.mediaPages[i].emptyView.showProgress(false, true);
                        } else if (itemCount == 0) {
                            SharedMediaLayout sharedMediaLayout = SharedMediaLayout.this;
                            sharedMediaLayout.animateItemsEnter(sharedMediaLayout.mediaPages[i].listView, 0);
                        }
                    }
                }
                notifyDataSetChanged();
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() != this.searchResult.size() + this.globalSearch.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.searchResult.size();
            int size2 = this.globalSearch.size();
            return size2 != 0 ? size + size2 : size;
        }

        public MessageObject getItem(int i) {
            if (i < this.searchResult.size()) {
                return this.searchResult.get(i);
            }
            return this.globalSearch.get(i - this.searchResult.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout sharedDocumentCell;
            int i2 = this.currentType;
            if (i2 == 1) {
                sharedDocumentCell = new SharedDocumentCell(this.mContext);
            } else if (i2 == 4) {
                sharedDocumentCell = new SharedAudioCell(this.mContext) { // from class: org.rbmain.ui.Components.SharedMediaLayout.MediaSearchAdapter.1
                    @Override // org.rbmain.ui.Cells.SharedAudioCell
                    public boolean needPlayMessage(MessageObject messageObject) {
                        if (messageObject.isVoice() || messageObject.isRoundVideo()) {
                            boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject);
                            MediaController.getInstance().setVoiceMessagesPlaylist(zPlayMessage ? MediaSearchAdapter.this.searchResult : null, false);
                            if (messageObject.isRoundVideo()) {
                                MediaController.getInstance().setCurrentVideoVisible(false);
                            }
                            return zPlayMessage;
                        }
                        if (messageObject.isMusic()) {
                            return MediaController.getInstance().setPlaylist(MediaSearchAdapter.this.searchResult, messageObject, SharedMediaLayout.this.mergeDialogId);
                        }
                        return false;
                    }
                };
            } else {
                SharedLinkCell sharedLinkCell = new SharedLinkCell(this.mContext);
                sharedLinkCell.setDelegate(SharedMediaLayout.this.sharedLinkCellDelegate);
                sharedDocumentCell = sharedLinkCell;
            }
            sharedDocumentCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(sharedDocumentCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int i2 = this.currentType;
            if (i2 == 1) {
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) viewHolder.itemView;
                MessageObject item = getItem(i);
                sharedDocumentCell.setDocument(item, i != getItemCount() - 1);
                if (SharedMediaLayout.this.isActionModeShowed) {
                    sharedDocumentCell.setChecked(SharedMediaLayout.this.selectedFiles[(item.getDialogId() > SharedMediaLayout.this.dialog_id ? 1 : (item.getDialogId() == SharedMediaLayout.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item.getId()) >= 0, !SharedMediaLayout.this.scrolling);
                    return;
                } else {
                    sharedDocumentCell.setChecked(false, !SharedMediaLayout.this.scrolling);
                    return;
                }
            }
            if (i2 == 3) {
                SharedLinkCell sharedLinkCell = (SharedLinkCell) viewHolder.itemView;
                MessageObject item2 = getItem(i);
                sharedLinkCell.setLink(item2, i != getItemCount() - 1);
                if (SharedMediaLayout.this.isActionModeShowed) {
                    sharedLinkCell.setChecked(SharedMediaLayout.this.selectedFiles[(item2.getDialogId() > SharedMediaLayout.this.dialog_id ? 1 : (item2.getDialogId() == SharedMediaLayout.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item2.getId()) >= 0, !SharedMediaLayout.this.scrolling);
                    return;
                } else {
                    sharedLinkCell.setChecked(false, !SharedMediaLayout.this.scrolling);
                    return;
                }
            }
            if (i2 == 4) {
                SharedAudioCell sharedAudioCell = (SharedAudioCell) viewHolder.itemView;
                MessageObject item3 = getItem(i);
                sharedAudioCell.setMessageObject(item3, i != getItemCount() - 1);
                if (SharedMediaLayout.this.isActionModeShowed) {
                    sharedAudioCell.setChecked(SharedMediaLayout.this.selectedFiles[(item3.getDialogId() > SharedMediaLayout.this.dialog_id ? 1 : (item3.getDialogId() == SharedMediaLayout.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item3.getId()) >= 0, !SharedMediaLayout.this.scrolling);
                } else {
                    sharedAudioCell.setChecked(false, !SharedMediaLayout.this.scrolling);
                }
            }
        }
    }

    private class GifAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        public GifAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return SharedMediaLayout.this.sharedMediaData[5].messages.size() != 0 || SharedMediaLayout.this.sharedMediaData[5].loading;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (SharedMediaLayout.this.sharedMediaData[5].messages.size() != 0 || SharedMediaLayout.this.sharedMediaData[5].loading) {
                return SharedMediaLayout.this.sharedMediaData[5].messages.size();
            }
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (SharedMediaLayout.this.sharedMediaData[5].messages.size() != 0 || SharedMediaLayout.this.sharedMediaData[5].loading) ? 0 : 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 5, SharedMediaLayout.this.dialog_id);
                viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                return new RecyclerListView.Holder(viewCreateEmptyStubView);
            }
            ContextLinkCell contextLinkCell = new ContextLinkCell(this.mContext, true);
            contextLinkCell.setCanPreviewGif(true);
            return new RecyclerListView.Holder(contextLinkCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            MessageObject messageObject;
            TLRPC$Document document;
            if (viewHolder.getItemViewType() == 1 || (document = (messageObject = SharedMediaLayout.this.sharedMediaData[5].messages.get(i)).getDocument()) == null) {
                return;
            }
            ContextLinkCell contextLinkCell = (ContextLinkCell) viewHolder.itemView;
            contextLinkCell.setGif(document, messageObject, messageObject.messageOwner.date, false);
            if (SharedMediaLayout.this.isActionModeShowed) {
                contextLinkCell.setChecked(SharedMediaLayout.this.selectedFiles[(messageObject.getDialogId() > SharedMediaLayout.this.dialog_id ? 1 : (messageObject.getDialogId() == SharedMediaLayout.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !SharedMediaLayout.this.scrolling);
            } else {
                contextLinkCell.setChecked(false, !SharedMediaLayout.this.scrolling);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ContextLinkCell) {
                ImageReceiver photoImage = ((ContextLinkCell) view).getPhotoImage();
                if (SharedMediaLayout.this.mediaPages[0].selectedType == 5) {
                    photoImage.setAllowStartAnimation(true);
                    photoImage.startAnimation();
                } else {
                    photoImage.setAllowStartAnimation(false);
                    photoImage.stopAnimation();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CommonGroupsAdapter extends RecyclerListView.SelectionAdapter {
        private ArrayList<TLRPC$Chat> chats = new ArrayList<>();
        private boolean endReached;
        private boolean firstLoaded;
        private boolean loading;
        private Context mContext;

        public CommonGroupsAdapter(Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getChats(long j, int i) {
            if (this.loading) {
                return;
            }
            TLRPC$TL_messages_getCommonChats tLRPC$TL_messages_getCommonChats = new TLRPC$TL_messages_getCommonChats();
            int i2 = (int) SharedMediaLayout.this.dialog_id;
            int i3 = (int) (SharedMediaLayout.this.dialog_id >> 32);
            if (i2 == 0) {
                i2 = SharedMediaLayout.this.profileActivity.getMessagesController().getEncryptedChat(Integer.valueOf(i3)).user_id;
            }
            TLRPC$InputUser inputUser = SharedMediaLayout.this.profileActivity.getMessagesController().getInputUser(i2);
            tLRPC$TL_messages_getCommonChats.user_id = inputUser;
            if (inputUser instanceof TLRPC$TL_inputUserEmpty) {
                return;
            }
            tLRPC$TL_messages_getCommonChats.limit = i;
            tLRPC$TL_messages_getCommonChats.max_id = j;
            this.loading = true;
            notifyDataSetChanged();
            SharedMediaLayout.this.profileActivity.getConnectionsManager().bindRequestToGuid(SharedMediaLayout.this.profileActivity.getDialogsProxy().getCommonGroups(tLRPC$TL_messages_getCommonChats, new RequestDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout$CommonGroupsAdapter$$ExternalSyntheticLambda1
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$getChats$1(tLObject, tLRPC$TL_error);
                }
            }), SharedMediaLayout.this.profileActivity.getClassGuid());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getChats$1(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$CommonGroupsAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getChats$0(tLRPC$TL_error, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getChats$0(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
            int itemCount = getItemCount();
            if (tLRPC$TL_error == null) {
                TLRPC$messages_Chats tLRPC$messages_Chats = (TLRPC$messages_Chats) tLObject;
                SharedMediaLayout.this.profileActivity.getMessagesController().putChats(tLRPC$messages_Chats.chats, false);
                this.endReached = true;
                this.chats.addAll(tLRPC$messages_Chats.chats);
            } else {
                this.endReached = true;
            }
            for (int i = 0; i < SharedMediaLayout.this.mediaPages.length; i++) {
                if (SharedMediaLayout.this.mediaPages[i].selectedType == 6 && SharedMediaLayout.this.mediaPages[i].listView != null) {
                    RecyclerListView recyclerListView = SharedMediaLayout.this.mediaPages[i].listView;
                    if (this.firstLoaded || itemCount == 0) {
                        SharedMediaLayout.this.animateItemsEnter(recyclerListView, 0);
                    }
                }
            }
            this.loading = false;
            this.firstLoaded = true;
            notifyDataSetChanged();
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getAdapterPosition() != this.chats.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.chats.isEmpty() && !this.loading) {
                return 1;
            }
            int size = this.chats.size();
            return (this.chats.isEmpty() || this.endReached) ? size : size + 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ProfileSearchCell profileSearchCell;
            if (i == 0) {
                profileSearchCell = new ProfileSearchCell(this.mContext);
            } else {
                if (i == 2) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 6, SharedMediaLayout.this.dialog_id);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                flickerLoadingView.setIsSingleCell(true);
                flickerLoadingView.showDate(false);
                flickerLoadingView.setViewType(1);
                profileSearchCell = flickerLoadingView;
            }
            profileSearchCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(profileSearchCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ProfileSearchCell profileSearchCell = (ProfileSearchCell) viewHolder.itemView;
                profileSearchCell.setData(this.chats.get(i), null, null, null, false, false);
                boolean z = true;
                if (i == this.chats.size() - 1 && this.endReached) {
                    z = false;
                }
                profileSearchCell.useSeparator = z;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (!this.chats.isEmpty() || this.loading) {
                return i < this.chats.size() ? 0 : 1;
            }
            return 2;
        }
    }

    private class ChatUsersAdapter extends RecyclerListView.SelectionAdapter {
        private TLRPC$ChatFull chatInfo;
        private Context mContext;
        private ArrayList<Integer> sortedUsers;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public ChatUsersAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
            if (tLRPC$ChatFull != null && tLRPC$ChatFull.participants == null) {
                return 0;
            }
            if (tLRPC$ChatFull != null && tLRPC$ChatFull.participants.participants.isEmpty()) {
                return 1;
            }
            TLRPC$ChatFull tLRPC$ChatFull2 = this.chatInfo;
            if (tLRPC$ChatFull2 != null) {
                return tLRPC$ChatFull2.participants.participants.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 7, SharedMediaLayout.this.dialog_id);
                viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                return new RecyclerListView.Holder(viewCreateEmptyStubView);
            }
            UserCell userCell = new UserCell(this.mContext, 9, 0, true);
            userCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(userCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            TLRPC$ChatParticipant tLRPC$ChatParticipant;
            String string;
            View view = viewHolder.itemView;
            if (view instanceof UserCell) {
                UserCell userCell = (UserCell) view;
                if (!this.sortedUsers.isEmpty()) {
                    tLRPC$ChatParticipant = this.chatInfo.participants.participants.get(this.sortedUsers.get(i).intValue());
                } else {
                    tLRPC$ChatParticipant = this.chatInfo.participants.participants.get(i);
                }
                if (tLRPC$ChatParticipant != null) {
                    String string2 = null;
                    if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatChannelParticipant) {
                        TLRPC$ChannelParticipant tLRPC$ChannelParticipant = ((TLRPC$TL_chatChannelParticipant) tLRPC$ChatParticipant).channelParticipant;
                        if (!TextUtils.isEmpty(tLRPC$ChannelParticipant.rank)) {
                            string = tLRPC$ChannelParticipant.rank;
                        } else if (tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantCreator) {
                            string = LocaleController.getString("ChannelCreator", R.string.ChannelCreator);
                        } else if (tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantAdmin) {
                            string = LocaleController.getString("ChannelAdmin", R.string.ChannelAdmin);
                        }
                        string2 = string;
                    } else if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantCreator) {
                        string2 = LocaleController.getString("ChannelCreator", R.string.ChannelCreator);
                    } else if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantAdmin) {
                        string2 = LocaleController.getString("ChannelAdmin", R.string.ChannelAdmin);
                    }
                    userCell.setAdminRole(string2);
                    userCell.setData(SharedMediaLayout.this.profileActivity.getMessagesController().getUser(Integer.valueOf(tLRPC$ChatParticipant.user_id)), null, null, 0, i != this.chatInfo.participants.participants.size() - 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
            return (tLRPC$ChatFull == null || !tLRPC$ChatFull.participants.participants.isEmpty()) ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class GroupUsersSearchAdapter extends RecyclerListView.SelectionAdapter {
        private TLRPC$Chat currentChat;
        private Context mContext;
        private SearchAdapterHelper searchAdapterHelper;
        private Runnable searchRunnable;
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private int totalCount = 0;
        int searchCount = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        public GroupUsersSearchAdapter(Context context) {
            this.mContext = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(true);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout$GroupUsersSearchAdapter$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public final void onDataSetChanged(int i) {
                    this.f$0.lambda$new$0(i);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }
            });
            this.currentChat = SharedMediaLayout.this.profileActivity.getCurrentChat();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(int i) {
            notifyDataSetChanged();
            if (i == 1) {
                int i2 = this.searchCount - 1;
                this.searchCount = i2;
                if (i2 == 0) {
                    for (int i3 = 0; i3 < SharedMediaLayout.this.mediaPages.length; i3++) {
                        if (SharedMediaLayout.this.mediaPages[i3].selectedType == 7) {
                            if (getItemCount() == 0) {
                                SharedMediaLayout.this.mediaPages[i3].emptyView.showProgress(false, true);
                            } else {
                                SharedMediaLayout sharedMediaLayout = SharedMediaLayout.this;
                                sharedMediaLayout.animateItemsEnter(sharedMediaLayout.mediaPages[i3].listView, 0);
                            }
                        }
                    }
                }
            }
        }

        private boolean createMenuForParticipant(TLObject tLObject, boolean z) {
            if (tLObject instanceof TLRPC$ChannelParticipant) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) tLObject;
                TLRPC$TL_chatChannelParticipant tLRPC$TL_chatChannelParticipant = new TLRPC$TL_chatChannelParticipant();
                tLRPC$TL_chatChannelParticipant.channelParticipant = tLRPC$ChannelParticipant;
                tLRPC$TL_chatChannelParticipant.user_id = MessageObject.getPeerId(tLRPC$ChannelParticipant.peer);
                tLRPC$TL_chatChannelParticipant.inviter_id = tLRPC$ChannelParticipant.inviter_id;
                tLRPC$TL_chatChannelParticipant.date = tLRPC$ChannelParticipant.date;
                tLObject = tLRPC$TL_chatChannelParticipant;
            }
            return SharedMediaLayout.this.profileActivity.onMemberClick((TLRPC$ChatParticipant) tLObject, true, z);
        }

        public void search(final String str, boolean z) {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            this.searchResultNames.clear();
            this.searchAdapterHelper.mergeResults(null);
            this.searchAdapterHelper.queryServerSearch(null, true, false, true, false, false, ChatObject.isChannel(this.currentChat) ? this.currentChat.id : 0, false, 2, 0);
            notifyDataSetChanged();
            for (int i = 0; i < SharedMediaLayout.this.mediaPages.length; i++) {
                if (SharedMediaLayout.this.mediaPages[i].selectedType == 7 && !TextUtils.isEmpty(str)) {
                    SharedMediaLayout.this.mediaPages[i].emptyView.showProgress(true, z);
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$GroupUsersSearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$1(str);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable, 600L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processSearch, reason: merged with bridge method [inline-methods] */
        public void lambda$search$1(final String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$GroupUsersSearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$3(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processSearch$3(final String str) {
            final ArrayList arrayList = null;
            this.searchRunnable = null;
            if (!ChatObject.isChannel(this.currentChat) && SharedMediaLayout.this.info != null) {
                arrayList = new ArrayList(SharedMediaLayout.this.info.participants.participants);
            }
            this.searchCount = 2;
            if (arrayList != null) {
                Utilities.searchQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$GroupUsersSearchAdapter$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processSearch$2(str, arrayList);
                    }
                });
            } else {
                this.searchCount = 2 - 1;
            }
            this.searchAdapterHelper.queryServerSearch(str, false, false, true, false, false, ChatObject.isChannel(this.currentChat) ? this.currentChat.id : 0, false, 2, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0145 A[LOOP:1: B:33:0x00b3->B:57:0x0145, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0106 A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$processSearch$2(java.lang.String r19, java.util.ArrayList r20) {
            /*
                Method dump skipped, instructions count: 344
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.SharedMediaLayout.GroupUsersSearchAdapter.lambda$processSearch$2(java.lang.String, java.util.ArrayList):void");
        }

        private void updateSearchResults(final ArrayList<CharSequence> arrayList, final ArrayList<TLObject> arrayList2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.SharedMediaLayout$GroupUsersSearchAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4(arrayList, arrayList2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$4(ArrayList arrayList, ArrayList arrayList2) {
            if (SharedMediaLayout.this.searching) {
                this.searchResultNames = arrayList;
                this.searchCount--;
                if (!ChatObject.isChannel(this.currentChat)) {
                    ArrayList<TLObject> groupSearch = this.searchAdapterHelper.getGroupSearch();
                    groupSearch.clear();
                    groupSearch.addAll(arrayList2);
                }
                if (this.searchCount == 0) {
                    for (int i = 0; i < SharedMediaLayout.this.mediaPages.length; i++) {
                        if (SharedMediaLayout.this.mediaPages[i].selectedType == 7) {
                            if (getItemCount() == 0) {
                                SharedMediaLayout.this.mediaPages[i].emptyView.showProgress(false, true);
                            } else {
                                SharedMediaLayout sharedMediaLayout = SharedMediaLayout.this;
                                sharedMediaLayout.animateItemsEnter(sharedMediaLayout.mediaPages[i].listView, 0);
                            }
                        }
                    }
                }
                notifyDataSetChanged();
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.totalCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            int size = this.searchAdapterHelper.getGroupSearch().size();
            this.totalCount = size;
            if (size > 0 && SharedMediaLayout.this.searching && SharedMediaLayout.this.mediaPages[0].selectedType == 7 && SharedMediaLayout.this.mediaPages[0].listView.getAdapter() != this) {
                SharedMediaLayout.this.switchToCurrentSelectedMode(false);
            }
            super.notifyDataSetChanged();
        }

        public TLObject getItem(int i) {
            int size = this.searchAdapterHelper.getGroupSearch().size();
            if (i < 0 || i >= size) {
                return null;
            }
            return this.searchAdapterHelper.getGroupSearch().get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ManageChatUserCell manageChatUserCell = new ManageChatUserCell(this.mContext, 9, 5, true);
            manageChatUserCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            manageChatUserCell.setDelegate(new ManageChatUserCell.ManageChatUserCellDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout$GroupUsersSearchAdapter$$ExternalSyntheticLambda5
                @Override // org.rbmain.ui.Cells.ManageChatUserCell.ManageChatUserCellDelegate
                public final boolean onOptionsButtonCheck(ManageChatUserCell manageChatUserCell2, boolean z) {
                    return this.f$0.lambda$onCreateViewHolder$5(manageChatUserCell2, z);
                }
            });
            return new RecyclerListView.Holder(manageChatUserCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$5(ManageChatUserCell manageChatUserCell, boolean z) {
            TLObject item = getItem(((Integer) manageChatUserCell.getTag()).intValue());
            if (item instanceof TLRPC$ChannelParticipant) {
                return createMenuForParticipant((TLRPC$ChannelParticipant) item, !z);
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            TLRPC$User user;
            SpannableStringBuilder spannableStringBuilder;
            TLObject item = getItem(i);
            if (item instanceof TLRPC$ChannelParticipant) {
                user = SharedMediaLayout.this.profileActivity.getMessagesController().getUser(Integer.valueOf(MessageObject.getPeerId(((TLRPC$ChannelParticipant) item).peer)));
            } else if (!(item instanceof TLRPC$ChatParticipant)) {
                return;
            } else {
                user = SharedMediaLayout.this.profileActivity.getMessagesController().getUser(Integer.valueOf(((TLRPC$ChatParticipant) item).user_id));
            }
            String str = user.username;
            this.searchAdapterHelper.getGroupSearch().size();
            String lastFoundChannel = this.searchAdapterHelper.getLastFoundChannel();
            if (lastFoundChannel != null) {
                String userName = UserObject.getUserName(user);
                spannableStringBuilder = new SpannableStringBuilder(userName);
                int iIndexOfIgnoreCase = AndroidUtilities.indexOfIgnoreCase(userName, lastFoundChannel);
                if (iIndexOfIgnoreCase != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText4)), iIndexOfIgnoreCase, lastFoundChannel.length() + iIndexOfIgnoreCase, 33);
                }
            } else {
                spannableStringBuilder = null;
            }
            ManageChatUserCell manageChatUserCell = (ManageChatUserCell) viewHolder.itemView;
            manageChatUserCell.setTag(Integer.valueOf(i));
            manageChatUserCell.setData(user, spannableStringBuilder, null, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }
    }

    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        NumberTextView numberTextView = this.selectedMessagesCountTextView;
        int i = ThemeDescription.FLAG_TEXTCOLOR;
        int i2 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(numberTextView, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.shadowLine, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.deleteItem.getIconView(), ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, i2));
        ActionBarMenuItem actionBarMenuItem = this.deleteItem;
        int i3 = ThemeDescription.FLAG_BACKGROUNDFILTER;
        int i4 = Theme.key_actionBarActionModeDefaultSelector;
        arrayList.add(new ThemeDescription(actionBarMenuItem, i3, null, null, null, null, i4));
        if (this.gotoItem != null) {
            arrayList.add(new ThemeDescription(this.gotoItem.getIconView(), ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, i2));
            arrayList.add(new ThemeDescription(this.gotoItem, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i4));
        }
        if (this.forwardItem != null) {
            arrayList.add(new ThemeDescription(this.forwardItem.getIconView(), ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, i2));
            arrayList.add(new ThemeDescription(this.forwardItem, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i4));
        }
        int i5 = 1;
        arrayList.add(new ThemeDescription(this.closeButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, new Drawable[]{this.backDrawable}, null, i2));
        arrayList.add(new ThemeDescription(this.closeButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i4));
        LinearLayout linearLayout = this.actionModeLayout;
        int i6 = ThemeDescription.FLAG_BACKGROUND;
        int i7 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(linearLayout, i6, null, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.floatingDateView, 0, null, null, null, null, Theme.key_chat_mediaTimeBackground));
        arrayList.add(new ThemeDescription(this.floatingDateView, 0, null, null, null, null, Theme.key_chat_mediaTimeText));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip, 0, new Class[]{ScrollSlidingTextTabStrip.class}, new String[]{"selectorDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_profile_tabSelectedLine));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, Theme.key_profile_tabSelectedText));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, Theme.key_profile_tabText));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{TextView.class}, null, null, null, Theme.key_profile_tabSelector));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerBackground));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{FragmentContextView.class}, new String[]{"playButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerPlayPause));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerTitle));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_FASTSCROLL, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerPerformer));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{FragmentContextView.class}, new String[]{"closeButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerClose));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_returnToCallBackground));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_returnToCallText));
        final int i8 = 0;
        while (i8 < this.mediaPages.length) {
            ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.Components.SharedMediaLayout$$ExternalSyntheticLambda8
                @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                public final void didSetColor() {
                    this.f$0.lambda$getThemeDescriptions$12(i8);
                }
            };
            RecyclerListView recyclerListView = this.mediaPages[i8].listView;
            Class[] clsArr = new Class[i5];
            clsArr[0] = View.class;
            arrayList.add(new ThemeDescription(recyclerListView, 0, clsArr, Theme.dividerPaint, null, null, Theme.key_divider));
            FlickerLoadingView flickerLoadingView = this.mediaPages[i8].progressView;
            int i9 = Theme.key_windowBackgroundWhite;
            arrayList.add(new ThemeDescription(flickerLoadingView, 0, null, null, null, null, i9));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_actionBarDefault));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_emptyListPlaceholder));
            RecyclerListView recyclerListView2 = this.mediaPages[i8].listView;
            int i10 = ThemeDescription.FLAG_SECTIONS;
            Class[] clsArr2 = new Class[i5];
            clsArr2[0] = GraySectionCell.class;
            String[] strArr = new String[i5];
            strArr[0] = "textView";
            arrayList.add(new ThemeDescription(recyclerListView2, i10, clsArr2, strArr, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_graySectionText));
            RecyclerListView recyclerListView3 = this.mediaPages[i8].listView;
            int i11 = ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS;
            Class[] clsArr3 = new Class[i5];
            clsArr3[0] = GraySectionCell.class;
            arrayList.add(new ThemeDescription(recyclerListView3, i11, clsArr3, null, null, null, Theme.key_graySection));
            RecyclerListView recyclerListView4 = this.mediaPages[i8].listView;
            Class[] clsArr4 = new Class[i5];
            clsArr4[0] = LoadingCell.class;
            String[] strArr2 = new String[i5];
            strArr2[0] = "progressBar";
            int i12 = Theme.key_progressCircle;
            arrayList.add(new ThemeDescription(recyclerListView4, 0, clsArr4, strArr2, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i12));
            RecyclerListView recyclerListView5 = this.mediaPages[i8].listView;
            int i13 = ThemeDescription.FLAG_TEXTCOLOR;
            Class[] clsArr5 = new Class[i5];
            clsArr5[0] = UserCell.class;
            String[] strArr3 = new String[i5];
            strArr3[0] = "adminTextView";
            arrayList.add(new ThemeDescription(recyclerListView5, i13, clsArr5, strArr3, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_profile_creatorIcon));
            RecyclerListView recyclerListView6 = this.mediaPages[i8].listView;
            Class[] clsArr6 = new Class[i5];
            clsArr6[0] = UserCell.class;
            String[] strArr4 = new String[i5];
            strArr4[0] = "imageView";
            arrayList.add(new ThemeDescription(recyclerListView6, 0, clsArr6, strArr4, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayIcon));
            RecyclerListView recyclerListView7 = this.mediaPages[i8].listView;
            Class[] clsArr7 = new Class[i5];
            clsArr7[0] = UserCell.class;
            String[] strArr5 = new String[i5];
            strArr5[0] = "nameTextView";
            int i14 = Theme.key_windowBackgroundWhiteBlackText;
            arrayList.add(new ThemeDescription(recyclerListView7, 0, clsArr7, strArr5, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
            RecyclerListView recyclerListView8 = this.mediaPages[i8].listView;
            Class[] clsArr8 = new Class[i5];
            clsArr8[0] = UserCell.class;
            String[] strArr6 = new String[i5];
            strArr6[0] = "statusColor";
            int i15 = Theme.key_windowBackgroundWhiteGrayText;
            arrayList.add(new ThemeDescription(recyclerListView8, 0, clsArr8, strArr6, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, i15));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{UserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlueText));
            Drawable[] drawableArr = Theme.avatarDrawables;
            int i16 = Theme.key_avatar_text;
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{UserCell.class}, null, drawableArr, null, i16));
            TextPaint[] textPaintArr = Theme.dialogs_namePaint;
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr[0], textPaintArr[1], Theme.dialogs_searchNamePaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_name));
            TextPaint[] textPaintArr2 = Theme.dialogs_nameEncryptedPaint;
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr2[0], textPaintArr2[1], Theme.dialogs_searchNameEncryptedPaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_secretName));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{ProfileSearchCell.class}, null, Theme.avatarDrawables, null, i16));
            arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
            arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
            arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
            arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
            arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
            arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
            arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
            int i17 = Theme.key_windowBackgroundWhiteGrayText2;
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{EmptyStubView.class}, new String[]{"emptyTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i17));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"dateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText3));
            int i18 = Theme.key_sharedMedia_startStopLoadIcon;
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{SharedDocumentCell.class}, new String[]{"progressView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i18));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"statusImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i18));
            int i19 = Theme.key_checkbox;
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i19));
            int i20 = Theme.key_checkboxCheck;
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i20));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_folderIcon));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"extTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_iconText));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i12));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i19));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i20));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_titleTextPaint, null, null, i14));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_descriptionTextPaint, null, null, i17));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i19));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i20));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{SharedLinkCell.class}, new String[]{"titleTextPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{SharedLinkCell.class}, null, null, null, Theme.key_windowBackgroundWhiteLinkText));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{SharedLinkCell.class}, Theme.linkSelectionPaint, null, null, Theme.key_windowBackgroundWhiteLinkSelection));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_sharedMedia_linkPlaceholderText));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_sharedMedia_linkPlaceholder));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, null, null, null, i9));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
            int i21 = Theme.key_sharedMedia_photoPlaceholder;
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{SharedPhotoVideoCell.class}, new String[]{"backgroundPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i21));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedPhotoVideoCell.class}, null, null, themeDescriptionDelegate, i19));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedPhotoVideoCell.class}, null, null, themeDescriptionDelegate, i20));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, new Class[]{ContextLinkCell.class}, new String[]{"backgroundPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i21));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{ContextLinkCell.class}, null, null, themeDescriptionDelegate, i19));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{ContextLinkCell.class}, null, null, themeDescriptionDelegate, i20));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].listView, 0, null, null, new Drawable[]{this.pinnedHeaderShadowDrawable}, null, Theme.key_windowBackgroundGrayShadow));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i14));
            arrayList.add(new ThemeDescription(this.mediaPages[i8].emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
            i8++;
            i5 = 1;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$12(int i) {
        if (this.mediaPages[i].listView != null) {
            int childCount = this.mediaPages[i].listView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.mediaPages[i].listView.getChildAt(i2);
                if (childAt instanceof SharedPhotoVideoCell) {
                    ((SharedPhotoVideoCell) childAt).updateCheckboxColor();
                } else if (childAt instanceof ProfileSearchCell) {
                    ((ProfileSearchCell) childAt).update(0);
                } else if (childAt instanceof UserCell) {
                    ((UserCell) childAt).update(0);
                }
            }
        }
    }
}
