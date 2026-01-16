package ir.eitaa.ui;

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
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterMusic;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterUrl;
import ir.eitaa.tgnet.TLRPC$TL_messages_search;
import ir.eitaa.tgnet.TLRPC$TL_webPageEmpty;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.SharedAudioCell;
import ir.eitaa.ui.Cells.SharedDocumentCell;
import ir.eitaa.ui.Cells.SharedLinkCell;
import ir.eitaa.ui.Cells.SharedMediaSectionCell;
import ir.eitaa.ui.Cells.SharedPhotoVideoCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.ClippingImageView;
import ir.eitaa.ui.Components.EmbedBottomSheet;
import ir.eitaa.ui.Components.FlickerLoadingView;
import ir.eitaa.ui.Components.FragmentContextView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.NumberTextView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ScrollSlidingTextTabStrip;
import ir.eitaa.ui.Components.SharedMediaLayout;
import ir.eitaa.ui.Components.StickerEmptyView;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.PhotoViewer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class MediaActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$6gs2BeDTaN_QkPus1XmyGCeAygs
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return MediaActivity.lambda$static$0(f);
        }
    };
    public final Property<MediaActivity, Float> SCROLL_Y;
    private View actionModeBackground;
    private ArrayList<View> actionModeViews;
    private int additionalPadding;
    private boolean animatingForward;
    private SharedDocumentsAdapter audioAdapter;
    private ArrayList<SharedAudioCell> audioCache;
    private ArrayList<SharedAudioCell> audioCellCache;
    private MediaSearchAdapter audioSearchAdapter;
    private boolean backAnimation;
    private Paint backgroundPaint;
    private ArrayList<SharedPhotoVideoCell> cache;
    private int cantDeleteMessagesCount;
    private ArrayList<SharedPhotoVideoCell> cellCache;
    private int columnsCount;
    private long dialogId;
    private boolean disableActionBarScrolling;
    private SharedDocumentsAdapter documentsAdapter;
    private MediaSearchAdapter documentsSearchAdapter;
    private FragmentContextView fragmentContextView;
    private ActionBarMenuItem gotoItem;
    private int[] hasMedia;
    private boolean ignoreSearchCollapse;
    protected TLRPC$ChatFull info;
    private int initialTab;
    private SharedLinksAdapter linksAdapter;
    private MediaSearchAdapter linksSearchAdapter;
    private int maximumVelocity;
    private MediaPage[] mediaPages;
    private long mergeDialogId;
    private SharedPhotoVideoAdapter photoVideoAdapter;
    private Drawable pinnedHeaderShadowDrawable;
    private PhotoViewer.PhotoViewerProvider provider;
    private ScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private boolean scrolling;
    private ActionBarMenuItem searchItem;
    private int searchItemState;
    private boolean searchWas;
    private boolean searching;
    private SparseArray<MessageObject>[] selectedFiles;
    private NumberTextView selectedMessagesCountTextView;
    SharedLinkCell.SharedLinkCellDelegate sharedLinkCellDelegate;
    private SharedMediaLayout.SharedMediaData[] sharedMediaData;
    private boolean swipeBackEnabled;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private SharedDocumentsAdapter voiceAdapter;

    static /* synthetic */ boolean lambda$createView$1(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ boolean lambda$createView$4(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class MediaPage extends FrameLayout {
        private ClippingImageView animatingImageView;
        private StickerEmptyView emptyView;
        private LinearLayoutManager layoutManager;
        private RecyclerListView listView;
        private FlickerLoadingView progressView;
        private int selectedType;

        public MediaPage(Context context) {
            super(context);
        }
    }

    public MediaActivity(Bundle args, int[] media, SharedMediaLayout.SharedMediaData[] mediaData, int initTab) {
        TLRPC$ChatFull tLRPC$ChatFull;
        super(args);
        this.mediaPages = new MediaPage[2];
        this.cellCache = new ArrayList<>(10);
        this.cache = new ArrayList<>(10);
        this.audioCellCache = new ArrayList<>(10);
        this.audioCache = new ArrayList<>(10);
        this.backgroundPaint = new Paint();
        this.selectedFiles = new SparseArray[]{new SparseArray<>(), new SparseArray<>()};
        this.actionModeViews = new ArrayList<>();
        this.info = null;
        this.columnsCount = 3;
        this.SCROLL_Y = new AnimationProperties.FloatProperty<MediaActivity>("animationValue") { // from class: ir.eitaa.ui.MediaActivity.1
            @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
            public void setValue(MediaActivity object, float value) {
                object.setScrollY(value);
                for (int i = 0; i < MediaActivity.this.mediaPages.length; i++) {
                    MediaActivity.this.mediaPages[i].listView.checkSection();
                }
            }

            @Override // android.util.Property
            public Float get(MediaActivity object) {
                return Float.valueOf(((BaseFragment) MediaActivity.this).actionBar.getTranslationY());
            }
        };
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.MediaActivity.2
            /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ir.eitaa.ui.PhotoViewer.PlaceProviderObject getPlaceForPhoto(ir.eitaa.messenger.MessageObject r11, ir.eitaa.tgnet.TLRPC$FileLocation r12, int r13, boolean r14) {
                /*
                    Method dump skipped, instructions count: 504
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MediaActivity.AnonymousClass2.getPlaceForPhoto(ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$FileLocation, int, boolean):ir.eitaa.ui.PhotoViewer$PlaceProviderObject");
            }
        };
        this.sharedMediaData = new SharedMediaLayout.SharedMediaData[6];
        this.sharedLinkCellDelegate = new AnonymousClass15();
        this.hasMedia = media;
        this.initialTab = initTab;
        this.dialogId = args.getLong("dialog_id", 0L);
        int i = 0;
        while (true) {
            SharedMediaLayout.SharedMediaData[] sharedMediaDataArr = this.sharedMediaData;
            if (i >= sharedMediaDataArr.length) {
                return;
            }
            sharedMediaDataArr[i] = new SharedMediaLayout.SharedMediaData();
            this.sharedMediaData[i].max_id[0] = DialogObject.isEncryptedDialog(this.dialogId) ? Integer.MIN_VALUE : ConnectionsManager.DEFAULT_DATACENTER_ID;
            if (this.mergeDialogId != 0 && (tLRPC$ChatFull = this.info) != null) {
                SharedMediaLayout.SharedMediaData[] sharedMediaDataArr2 = this.sharedMediaData;
                sharedMediaDataArr2[i].max_id[1] = tLRPC$ChatFull.migrated_from_max_id;
                sharedMediaDataArr2[i].endReached[1] = false;
            }
            if (mediaData != null) {
                SharedMediaLayout.SharedMediaData[] sharedMediaDataArr3 = this.sharedMediaData;
                sharedMediaDataArr3[i].totalCount = mediaData[i].totalCount;
                sharedMediaDataArr3[i].messages.addAll(mediaData[i].messages);
                this.sharedMediaData[i].sections.addAll(mediaData[i].sections);
                for (Map.Entry<String, ArrayList<MessageObject>> entry : mediaData[i].sectionArrays.entrySet()) {
                    this.sharedMediaData[i].sectionArrays.put(entry.getKey(), new ArrayList<>(entry.getValue()));
                }
                for (int i2 = 0; i2 < 2; i2++) {
                    SharedMediaLayout.SharedMediaData[] sharedMediaDataArr4 = this.sharedMediaData;
                    sharedMediaDataArr4[i].endReached[i2] = mediaData[i].endReached[i2];
                    sharedMediaDataArr4[i].messagesDict[i2] = mediaData[i].messagesDict[i2].clone();
                    this.sharedMediaData[i].max_id[i2] = mediaData[i].max_id[i2];
                }
            }
            i++;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mediaDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mediaDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) throws Resources.NotFoundException {
        int i;
        int i2;
        TLRPC$User user;
        for (int i3 = 0; i3 < 10; i3++) {
            this.cellCache.add(new SharedPhotoVideoCell(context));
            if (this.initialTab == 4) {
                SharedAudioCell sharedAudioCell = new SharedAudioCell(context) { // from class: ir.eitaa.ui.MediaActivity.3
                    @Override // ir.eitaa.ui.Cells.SharedAudioCell
                    public boolean needPlayMessage(MessageObject messageObject) throws IOException {
                        if (messageObject.isVoice() || messageObject.isRoundVideo()) {
                            boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject);
                            MediaController.getInstance().setVoiceMessagesPlaylist(zPlayMessage ? MediaActivity.this.sharedMediaData[4].messages : null, false);
                            return zPlayMessage;
                        }
                        if (messageObject.isMusic()) {
                            return MediaController.getInstance().setPlaylist(MediaActivity.this.sharedMediaData[4].messages, messageObject, MediaActivity.this.mergeDialogId);
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
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setAddToContainer(false);
        this.actionBar.setClipContent(true);
        if (DialogObject.isEncryptedDialog(this.dialogId)) {
            TLRPC$EncryptedChat encryptedChat = getMessagesController().getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(this.dialogId)));
            if (encryptedChat != null && (user = getMessagesController().getUser(Long.valueOf(encryptedChat.user_id))) != null) {
                this.actionBar.setTitle(ContactsController.formatName(user.first_name, user.last_name));
            }
        } else if (DialogObject.isUserDialog(this.dialogId)) {
            TLRPC$User user2 = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.dialogId));
            if (user2 != null) {
                if (user2.self) {
                    this.actionBar.setTitle(LocaleController.getString("SavedMessages", R.string.SavedMessages));
                } else {
                    this.actionBar.setTitle(ContactsController.formatName(user2.first_name, user2.last_name));
                }
            }
        } else {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-this.dialogId));
            if (chat != null) {
                this.actionBar.setTitle(chat.title);
            }
        }
        if (TextUtils.isEmpty(this.actionBar.getTitle())) {
            this.actionBar.setTitle(LocaleController.getString("SharedContentTitle", R.string.SharedContentTitle));
        }
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass4());
        Drawable drawable = context.getResources().getDrawable(R.drawable.photos_header_shadow);
        this.pinnedHeaderShadowDrawable = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundGrayShadow"), PorterDuff.Mode.MULTIPLY));
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (scrollSlidingTextTabStrip != null) {
            this.initialTab = scrollSlidingTextTabStrip.getCurrentTabId();
        }
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip2 = new ScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = scrollSlidingTextTabStrip2;
        int i4 = this.initialTab;
        int i5 = -1;
        if (i4 != -1) {
            scrollSlidingTextTabStrip2.setInitialTabId(i4);
            this.initialTab = -1;
        }
        this.actionBar.addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.eitaa.ui.MediaActivity.5
            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public /* synthetic */ void onSamePageSelected() {
                ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate.CC.$default$onSamePageSelected(this);
            }

            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int id, boolean forward) {
                if (MediaActivity.this.mediaPages[0].selectedType == id) {
                    return;
                }
                MediaActivity mediaActivity = MediaActivity.this;
                mediaActivity.swipeBackEnabled = id == mediaActivity.scrollSlidingTextTabStrip.getFirstTabId();
                MediaActivity.this.mediaPages[1].selectedType = id;
                MediaActivity.this.mediaPages[1].setVisibility(0);
                MediaActivity.this.switchToCurrentSelectedMode(true);
                MediaActivity.this.animatingForward = forward;
            }

            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float progress) {
                if (progress != 1.0f || MediaActivity.this.mediaPages[1].getVisibility() == 0) {
                    if (MediaActivity.this.animatingForward) {
                        MediaActivity.this.mediaPages[0].setTranslationX((-progress) * MediaActivity.this.mediaPages[0].getMeasuredWidth());
                        MediaActivity.this.mediaPages[1].setTranslationX(MediaActivity.this.mediaPages[0].getMeasuredWidth() - (MediaActivity.this.mediaPages[0].getMeasuredWidth() * progress));
                    } else {
                        MediaActivity.this.mediaPages[0].setTranslationX(MediaActivity.this.mediaPages[0].getMeasuredWidth() * progress);
                        MediaActivity.this.mediaPages[1].setTranslationX((MediaActivity.this.mediaPages[0].getMeasuredWidth() * progress) - MediaActivity.this.mediaPages[0].getMeasuredWidth());
                    }
                    if (MediaActivity.this.searchItemState == 1) {
                        MediaActivity.this.searchItem.setAlpha(progress);
                    } else if (MediaActivity.this.searchItemState == 2) {
                        MediaActivity.this.searchItem.setAlpha(1.0f - progress);
                    }
                    if (progress == 1.0f) {
                        MediaPage mediaPage = MediaActivity.this.mediaPages[0];
                        MediaActivity.this.mediaPages[0] = MediaActivity.this.mediaPages[1];
                        MediaActivity.this.mediaPages[1] = mediaPage;
                        MediaActivity.this.mediaPages[1].setVisibility(8);
                        if (MediaActivity.this.searchItemState == 2) {
                            MediaActivity.this.searchItem.setVisibility(4);
                        }
                        MediaActivity.this.searchItemState = 0;
                    }
                }
            }
        });
        for (int i6 = 1; i6 >= 0; i6--) {
            this.selectedFiles[i6].clear();
        }
        this.cantDeleteMessagesCount = 0;
        this.actionModeViews.clear();
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.MediaActivity.6
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                MediaActivity.this.searching = true;
                MediaActivity.this.resetScroll();
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                MediaActivity.this.searching = false;
                MediaActivity.this.searchWas = false;
                MediaActivity.this.documentsSearchAdapter.search(null);
                MediaActivity.this.linksSearchAdapter.search(null);
                MediaActivity.this.audioSearchAdapter.search(null);
                if (MediaActivity.this.ignoreSearchCollapse) {
                    MediaActivity.this.ignoreSearchCollapse = false;
                } else {
                    MediaActivity.this.switchToCurrentSelectedMode(false);
                }
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                String string = editText.getText().toString();
                if (string.length() != 0) {
                    MediaActivity.this.searchWas = true;
                    MediaActivity.this.switchToCurrentSelectedMode(false);
                } else {
                    MediaActivity.this.searchWas = false;
                    MediaActivity.this.switchToCurrentSelectedMode(false);
                }
                if (MediaActivity.this.mediaPages[0].selectedType == 1) {
                    if (MediaActivity.this.documentsSearchAdapter == null) {
                        return;
                    }
                    MediaActivity.this.documentsSearchAdapter.search(string);
                } else if (MediaActivity.this.mediaPages[0].selectedType == 3) {
                    if (MediaActivity.this.linksSearchAdapter == null) {
                        return;
                    }
                    MediaActivity.this.linksSearchAdapter.search(string);
                } else {
                    if (MediaActivity.this.mediaPages[0].selectedType != 4 || MediaActivity.this.audioSearchAdapter == null) {
                        return;
                    }
                    MediaActivity.this.audioSearchAdapter.search(string);
                }
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setContentDescription(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setVisibility(4);
        this.searchItemState = 0;
        this.hasOwnBackground = true;
        ActionBarMenu actionBarMenuCreateActionMode = this.actionBar.createActionMode(false, null);
        actionBarMenuCreateActionMode.setBackgroundDrawable(null);
        this.actionBar.setItemsColor(Theme.getColor("actionBarDefaultIcon"), true);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarDefaultSelector"), true);
        View view = new View(context);
        this.actionModeBackground = view;
        view.setBackgroundColor(Theme.getColor("sharedMedia_actionMode"));
        this.actionModeBackground.setAlpha(0.0f);
        ActionBar actionBar = this.actionBar;
        actionBar.addView(this.actionModeBackground, actionBar.indexOfChild(actionBarMenuCreateActionMode));
        NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
        this.selectedMessagesCountTextView = numberTextView;
        numberTextView.setTextSize(18);
        this.selectedMessagesCountTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.selectedMessagesCountTextView.setTextColor(Theme.getColor("actionBarDefaultIcon"));
        this.selectedMessagesCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$gs23WtVortZKf_OIAWCfEiEXI2U
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return MediaActivity.lambda$createView$1(view2, motionEvent);
            }
        });
        actionBarMenuCreateActionMode.addView(this.selectedMessagesCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
        if (!DialogObject.isEncryptedDialog(this.dialogId)) {
            ArrayList<View> arrayList = this.actionModeViews;
            ActionBarMenuItem actionBarMenuItemAddItemWithWidth = actionBarMenuCreateActionMode.addItemWithWidth(7, R.drawable.msg_message, AndroidUtilities.dp(54.0f), LocaleController.getString("AccDescrGoToMessage", R.string.AccDescrGoToMessage));
            this.gotoItem = actionBarMenuItemAddItemWithWidth;
            arrayList.add(actionBarMenuItemAddItemWithWidth);
            this.actionModeViews.add(actionBarMenuCreateActionMode.addItemWithWidth(3, R.drawable.msg_forward, AndroidUtilities.dp(54.0f), LocaleController.getString("Forward", R.string.Forward)));
        }
        this.actionModeViews.add(actionBarMenuCreateActionMode.addItemWithWidth(4, R.drawable.msg_delete, AndroidUtilities.dp(54.0f), LocaleController.getString("Delete", R.string.Delete)));
        this.photoVideoAdapter = new SharedPhotoVideoAdapter(context);
        this.documentsAdapter = new SharedDocumentsAdapter(context, 1);
        this.voiceAdapter = new SharedDocumentsAdapter(context, 2);
        this.audioAdapter = new SharedDocumentsAdapter(context, 4);
        this.documentsSearchAdapter = new MediaSearchAdapter(context, 1);
        this.audioSearchAdapter = new MediaSearchAdapter(context, 4);
        this.linksSearchAdapter = new MediaSearchAdapter(context, 3);
        this.linksAdapter = new SharedLinksAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.MediaActivity.7
            private boolean globalIgnoreLayout;
            private boolean maybeStartTracking;
            private boolean startedTracking;
            private int startedTrackingPointerId;
            private int startedTrackingX;
            private int startedTrackingY;
            private VelocityTracker velocityTracker;

            private boolean prepareForMoving(MotionEvent ev, boolean forward) {
                int nextPageId = MediaActivity.this.scrollSlidingTextTabStrip.getNextPageId(forward);
                if (nextPageId < 0) {
                    return false;
                }
                if (MediaActivity.this.searchItemState != 0) {
                    if (MediaActivity.this.searchItemState == 2) {
                        MediaActivity.this.searchItem.setAlpha(1.0f);
                    } else if (MediaActivity.this.searchItemState == 1) {
                        MediaActivity.this.searchItem.setAlpha(0.0f);
                        MediaActivity.this.searchItem.setVisibility(4);
                    }
                    MediaActivity.this.searchItemState = 0;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                this.maybeStartTracking = false;
                this.startedTracking = true;
                this.startedTrackingX = (int) ev.getX();
                ((BaseFragment) MediaActivity.this).actionBar.setEnabled(false);
                MediaActivity.this.scrollSlidingTextTabStrip.setEnabled(false);
                MediaActivity.this.mediaPages[1].selectedType = nextPageId;
                MediaActivity.this.mediaPages[1].setVisibility(0);
                MediaActivity.this.animatingForward = forward;
                MediaActivity.this.switchToCurrentSelectedMode(true);
                if (forward) {
                    MediaActivity.this.mediaPages[1].setTranslationX(MediaActivity.this.mediaPages[0].getMeasuredWidth());
                } else {
                    MediaActivity.this.mediaPages[1].setTranslationX(-MediaActivity.this.mediaPages[0].getMeasuredWidth());
                }
                return true;
            }

            @Override // android.view.View
            public void forceHasOverlappingRendering(boolean hasOverlappingRendering) {
                super.forceHasOverlappingRendering(hasOverlappingRendering);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
                measureChildWithMargins(((BaseFragment) MediaActivity.this).actionBar, widthMeasureSpec, 0, heightMeasureSpec, 0);
                int measuredHeight = ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight();
                this.globalIgnoreLayout = true;
                for (int i7 = 0; i7 < MediaActivity.this.mediaPages.length; i7++) {
                    if (MediaActivity.this.mediaPages[i7] != null) {
                        if (MediaActivity.this.mediaPages[i7].listView != null) {
                            MediaActivity.this.mediaPages[i7].listView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, AndroidUtilities.dp(4.0f));
                        }
                        if (MediaActivity.this.mediaPages[i7].emptyView != null) {
                            MediaActivity.this.mediaPages[i7].emptyView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, 0);
                        }
                        if (MediaActivity.this.mediaPages[i7].progressView != null) {
                            MediaActivity.this.mediaPages[i7].progressView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, 0);
                        }
                    }
                }
                this.globalIgnoreLayout = false;
                int childCount = getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
                    if (childAt != null && childAt.getVisibility() != 8 && childAt != ((BaseFragment) MediaActivity.this).actionBar) {
                        measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    }
                }
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                if (MediaActivity.this.fragmentContextView != null) {
                    int measuredHeight = ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight();
                    MediaActivity.this.fragmentContextView.layout(MediaActivity.this.fragmentContextView.getLeft(), MediaActivity.this.fragmentContextView.getTop() + measuredHeight, MediaActivity.this.fragmentContextView.getRight(), MediaActivity.this.fragmentContextView.getBottom() + measuredHeight);
                }
            }

            @Override // android.view.View
            public void setPadding(int left, int top, int right, int bottom) {
                MediaActivity.this.additionalPadding = top;
                if (MediaActivity.this.fragmentContextView != null) {
                    MediaActivity.this.fragmentContextView.setTranslationY(top + ((BaseFragment) MediaActivity.this).actionBar.getTranslationY());
                }
                int measuredHeight = ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight();
                for (int i7 = 0; i7 < MediaActivity.this.mediaPages.length; i7++) {
                    if (MediaActivity.this.mediaPages[i7] != null) {
                        if (MediaActivity.this.mediaPages[i7].emptyView != null) {
                            MediaActivity.this.mediaPages[i7].emptyView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, 0);
                        }
                        if (MediaActivity.this.mediaPages[i7].progressView != null) {
                            MediaActivity.this.mediaPages[i7].progressView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, 0);
                        }
                        if (MediaActivity.this.mediaPages[i7].listView != null) {
                            MediaActivity.this.mediaPages[i7].listView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, AndroidUtilities.dp(4.0f));
                            MediaActivity.this.mediaPages[i7].listView.checkSection();
                        }
                    }
                }
                MediaActivity.this.fixScrollOffset();
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                if (((BaseFragment) MediaActivity.this).parentLayout != null) {
                    ((BaseFragment) MediaActivity.this).parentLayout.drawHeaderShadow(canvas, ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight() + ((int) ((BaseFragment) MediaActivity.this).actionBar.getTranslationY()));
                }
                if (MediaActivity.this.fragmentContextView == null || !MediaActivity.this.fragmentContextView.isCallStyle()) {
                    return;
                }
                canvas.save();
                canvas.translate(MediaActivity.this.fragmentContextView.getX(), MediaActivity.this.fragmentContextView.getY());
                MediaActivity.this.fragmentContextView.setDrawOverlay(true);
                MediaActivity.this.fragmentContextView.draw(canvas);
                MediaActivity.this.fragmentContextView.setDrawOverlay(false);
                canvas.restore();
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (child == MediaActivity.this.fragmentContextView && MediaActivity.this.fragmentContextView.isCallStyle()) {
                    return true;
                }
                return super.drawChild(canvas, child, drawingTime);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.globalIgnoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean checkTabsAnimationInProgress() {
                /*
                    r7 = this;
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    boolean r0 = ir.eitaa.ui.MediaActivity.access$6100(r0)
                    r1 = 0
                    if (r0 == 0) goto Lc3
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    boolean r0 = ir.eitaa.ui.MediaActivity.access$6200(r0)
                    r2 = -1
                    r3 = 0
                    r4 = 1065353216(0x3f800000, float:1.0)
                    r5 = 1
                    if (r0 == 0) goto L59
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity$MediaPage[] r0 = ir.eitaa.ui.MediaActivity.access$100(r0)
                    r0 = r0[r1]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity$MediaPage[] r0 = ir.eitaa.ui.MediaActivity.access$100(r0)
                    r0 = r0[r1]
                    r0.setTranslationX(r3)
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity$MediaPage[] r0 = ir.eitaa.ui.MediaActivity.access$100(r0)
                    r0 = r0[r5]
                    ir.eitaa.ui.MediaActivity r3 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity$MediaPage[] r3 = ir.eitaa.ui.MediaActivity.access$100(r3)
                    r3 = r3[r1]
                    int r3 = r3.getMeasuredWidth()
                    ir.eitaa.ui.MediaActivity r4 = ir.eitaa.ui.MediaActivity.this
                    boolean r4 = ir.eitaa.ui.MediaActivity.access$3600(r4)
                    if (r4 == 0) goto L52
                    r2 = 1
                L52:
                    int r3 = r3 * r2
                    float r2 = (float) r3
                    r0.setTranslationX(r2)
                    goto L9e
                L59:
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity$MediaPage[] r0 = ir.eitaa.ui.MediaActivity.access$100(r0)
                    r0 = r0[r5]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity$MediaPage[] r0 = ir.eitaa.ui.MediaActivity.access$100(r0)
                    r0 = r0[r1]
                    ir.eitaa.ui.MediaActivity r4 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity$MediaPage[] r4 = ir.eitaa.ui.MediaActivity.access$100(r4)
                    r4 = r4[r1]
                    int r4 = r4.getMeasuredWidth()
                    ir.eitaa.ui.MediaActivity r6 = ir.eitaa.ui.MediaActivity.this
                    boolean r6 = ir.eitaa.ui.MediaActivity.access$3600(r6)
                    if (r6 == 0) goto L8a
                    goto L8b
                L8a:
                    r2 = 1
                L8b:
                    int r4 = r4 * r2
                    float r2 = (float) r4
                    r0.setTranslationX(r2)
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity$MediaPage[] r0 = ir.eitaa.ui.MediaActivity.access$100(r0)
                    r0 = r0[r5]
                    r0.setTranslationX(r3)
                    goto L9e
                L9d:
                    r5 = 0
                L9e:
                    if (r5 == 0) goto Lbc
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    android.animation.AnimatorSet r0 = ir.eitaa.ui.MediaActivity.access$6300(r0)
                    if (r0 == 0) goto Lb7
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    android.animation.AnimatorSet r0 = ir.eitaa.ui.MediaActivity.access$6300(r0)
                    r0.cancel()
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    r2 = 0
                    ir.eitaa.ui.MediaActivity.access$6302(r0, r2)
                Lb7:
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    ir.eitaa.ui.MediaActivity.access$6102(r0, r1)
                Lbc:
                    ir.eitaa.ui.MediaActivity r0 = ir.eitaa.ui.MediaActivity.this
                    boolean r0 = ir.eitaa.ui.MediaActivity.access$6100(r0)
                    return r0
                Lc3:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MediaActivity.AnonymousClass7.checkTabsAnimationInProgress():boolean");
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return checkTabsAnimationInProgress() || MediaActivity.this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(ev);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                MediaActivity.this.backgroundPaint.setColor(Theme.getColor("windowBackgroundWhite"));
                canvas.drawRect(0.0f, ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight() + ((BaseFragment) MediaActivity.this).actionBar.getTranslationY(), getMeasuredWidth(), getMeasuredHeight(), MediaActivity.this.backgroundPaint);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent ev) {
                float xVelocity;
                float yVelocity;
                float measuredWidth;
                int measuredWidth2;
                if (((BaseFragment) MediaActivity.this).parentLayout.checkTransitionAnimation() || checkTabsAnimationInProgress()) {
                    return false;
                }
                if (ev != null) {
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    this.velocityTracker.addMovement(ev);
                }
                if (ev != null && ev.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking) {
                    this.startedTrackingPointerId = ev.getPointerId(0);
                    this.maybeStartTracking = true;
                    this.startedTrackingX = (int) ev.getX();
                    this.startedTrackingY = (int) ev.getY();
                    this.velocityTracker.clear();
                } else if (ev != null && ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId) {
                    int x = (int) (ev.getX() - this.startedTrackingX);
                    int iAbs = Math.abs(((int) ev.getY()) - this.startedTrackingY);
                    if (this.startedTracking && ((MediaActivity.this.animatingForward && x > 0) || (!MediaActivity.this.animatingForward && x < 0))) {
                        if (!prepareForMoving(ev, x < 0)) {
                            this.maybeStartTracking = true;
                            this.startedTracking = false;
                            MediaActivity.this.mediaPages[0].setTranslationX(0.0f);
                            MediaActivity.this.mediaPages[1].setTranslationX(MediaActivity.this.animatingForward ? MediaActivity.this.mediaPages[0].getMeasuredWidth() : -MediaActivity.this.mediaPages[0].getMeasuredWidth());
                            MediaActivity.this.scrollSlidingTextTabStrip.selectTabWithId(MediaActivity.this.mediaPages[1].selectedType, 0.0f);
                        }
                    }
                    if (!this.maybeStartTracking || this.startedTracking) {
                        if (this.startedTracking) {
                            MediaActivity.this.mediaPages[0].setTranslationX(x);
                            if (MediaActivity.this.animatingForward) {
                                MediaActivity.this.mediaPages[1].setTranslationX(MediaActivity.this.mediaPages[0].getMeasuredWidth() + x);
                            } else {
                                MediaActivity.this.mediaPages[1].setTranslationX(x - MediaActivity.this.mediaPages[0].getMeasuredWidth());
                            }
                            float fAbs = Math.abs(x) / MediaActivity.this.mediaPages[0].getMeasuredWidth();
                            if (MediaActivity.this.searchItemState == 2) {
                                MediaActivity.this.searchItem.setAlpha(1.0f - fAbs);
                            } else if (MediaActivity.this.searchItemState == 1) {
                                MediaActivity.this.searchItem.setAlpha(fAbs);
                            }
                            MediaActivity.this.scrollSlidingTextTabStrip.selectTabWithId(MediaActivity.this.mediaPages[1].selectedType, fAbs);
                        }
                    } else if (Math.abs(x) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x) > iAbs) {
                        prepareForMoving(ev, x < 0);
                    }
                } else if (ev == null || (ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6))) {
                    this.velocityTracker.computeCurrentVelocity(1000, MediaActivity.this.maximumVelocity);
                    if (ev == null || ev.getAction() == 3) {
                        xVelocity = 0.0f;
                        yVelocity = 0.0f;
                    } else {
                        xVelocity = this.velocityTracker.getXVelocity();
                        yVelocity = this.velocityTracker.getYVelocity();
                        if (!this.startedTracking && Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                            prepareForMoving(ev, xVelocity < 0.0f);
                        }
                    }
                    if (this.startedTracking) {
                        float x2 = MediaActivity.this.mediaPages[0].getX();
                        MediaActivity.this.tabsAnimation = new AnimatorSet();
                        MediaActivity.this.backAnimation = Math.abs(x2) < ((float) MediaActivity.this.mediaPages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity) < 3500.0f || Math.abs(xVelocity) < Math.abs(yVelocity));
                        if (!MediaActivity.this.backAnimation) {
                            measuredWidth = MediaActivity.this.mediaPages[0].getMeasuredWidth() - Math.abs(x2);
                            if (MediaActivity.this.animatingForward) {
                                MediaActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(MediaActivity.this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, -MediaActivity.this.mediaPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(MediaActivity.this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f));
                            } else {
                                MediaActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(MediaActivity.this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, MediaActivity.this.mediaPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(MediaActivity.this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f));
                            }
                        } else {
                            measuredWidth = Math.abs(x2);
                            if (MediaActivity.this.animatingForward) {
                                MediaActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(MediaActivity.this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(MediaActivity.this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, MediaActivity.this.mediaPages[1].getMeasuredWidth()));
                            } else {
                                MediaActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(MediaActivity.this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(MediaActivity.this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, -MediaActivity.this.mediaPages[1].getMeasuredWidth()));
                            }
                        }
                        MediaActivity.this.tabsAnimation.setInterpolator(MediaActivity.interpolator);
                        int measuredWidth3 = getMeasuredWidth();
                        float f = measuredWidth3 / 2;
                        float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                        float fAbs2 = Math.abs(xVelocity);
                        if (fAbs2 > 0.0f) {
                            measuredWidth2 = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / fAbs2) * 1000.0f) * 4;
                        } else {
                            measuredWidth2 = (int) (((measuredWidth / getMeasuredWidth()) + 1.0f) * 100.0f);
                        }
                        MediaActivity.this.tabsAnimation.setDuration(Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min(measuredWidth2, 600)));
                        MediaActivity.this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.MediaActivity.7.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                MediaActivity.this.tabsAnimation = null;
                                if (MediaActivity.this.backAnimation) {
                                    MediaActivity.this.mediaPages[1].setVisibility(8);
                                    if (MediaActivity.this.searchItemState == 2) {
                                        MediaActivity.this.searchItem.setAlpha(1.0f);
                                    } else if (MediaActivity.this.searchItemState == 1) {
                                        MediaActivity.this.searchItem.setAlpha(0.0f);
                                        MediaActivity.this.searchItem.setVisibility(4);
                                    }
                                    MediaActivity.this.searchItemState = 0;
                                } else {
                                    MediaPage mediaPage = MediaActivity.this.mediaPages[0];
                                    MediaActivity.this.mediaPages[0] = MediaActivity.this.mediaPages[1];
                                    MediaActivity.this.mediaPages[1] = mediaPage;
                                    MediaActivity.this.mediaPages[1].setVisibility(8);
                                    if (MediaActivity.this.searchItemState == 2) {
                                        MediaActivity.this.searchItem.setVisibility(4);
                                    }
                                    MediaActivity.this.searchItemState = 0;
                                    MediaActivity mediaActivity = MediaActivity.this;
                                    mediaActivity.swipeBackEnabled = mediaActivity.mediaPages[0].selectedType == MediaActivity.this.scrollSlidingTextTabStrip.getFirstTabId();
                                    MediaActivity.this.scrollSlidingTextTabStrip.selectTabWithId(MediaActivity.this.mediaPages[0].selectedType, 1.0f);
                                }
                                MediaActivity.this.tabsAnimationInProgress = false;
                                AnonymousClass7.this.maybeStartTracking = false;
                                AnonymousClass7.this.startedTracking = false;
                                ((BaseFragment) MediaActivity.this).actionBar.setEnabled(true);
                                MediaActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                            }
                        });
                        MediaActivity.this.tabsAnimation.start();
                        MediaActivity.this.tabsAnimationInProgress = true;
                        this.startedTracking = false;
                    } else {
                        this.maybeStartTracking = false;
                        ((BaseFragment) MediaActivity.this).actionBar.setEnabled(true);
                        MediaActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                }
                return this.startedTracking;
            }
        };
        this.fragmentView = frameLayout;
        frameLayout.setWillNotDraw(false);
        int iFindFirstVisibleItemPosition = -1;
        int top = 0;
        int i7 = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i7 >= mediaPageArr.length) {
                break;
            }
            if (i7 != 0 || mediaPageArr[i7] == null || mediaPageArr[i7].layoutManager == null) {
                i = iFindFirstVisibleItemPosition;
                i2 = top;
            } else {
                iFindFirstVisibleItemPosition = this.mediaPages[i7].layoutManager.findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition != this.mediaPages[i7].layoutManager.getItemCount() - 1) {
                    RecyclerListView.Holder holder = (RecyclerListView.Holder) this.mediaPages[i7].listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                    if (holder != null) {
                        top = holder.itemView.getTop();
                    } else {
                        iFindFirstVisibleItemPosition = -1;
                    }
                    i = iFindFirstVisibleItemPosition;
                    i2 = top;
                } else {
                    i2 = top;
                    i = -1;
                }
            }
            final MediaPage mediaPage = new MediaPage(context) { // from class: ir.eitaa.ui.MediaActivity.8
                @Override // android.view.View
                public void setTranslationX(float translationX) {
                    super.setTranslationX(translationX);
                    if (MediaActivity.this.tabsAnimationInProgress && MediaActivity.this.mediaPages[0] == this) {
                        float fAbs = Math.abs(MediaActivity.this.mediaPages[0].getTranslationX()) / MediaActivity.this.mediaPages[0].getMeasuredWidth();
                        MediaActivity.this.scrollSlidingTextTabStrip.selectTabWithId(MediaActivity.this.mediaPages[1].selectedType, fAbs);
                        if (MediaActivity.this.searchItemState == 2) {
                            MediaActivity.this.searchItem.setAlpha(1.0f - fAbs);
                        } else if (MediaActivity.this.searchItemState == 1) {
                            MediaActivity.this.searchItem.setAlpha(fAbs);
                        }
                    }
                }
            };
            frameLayout.addView(mediaPage, LayoutHelper.createFrame(i5, -1.0f));
            MediaPage[] mediaPageArr2 = this.mediaPages;
            mediaPageArr2[i7] = mediaPage;
            int i8 = i2;
            final LinearLayoutManager linearLayoutManager = mediaPageArr2[i7].layoutManager = new LinearLayoutManager(context, 1, false) { // from class: ir.eitaa.ui.MediaActivity.9
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean supportsPredictiveItemAnimations() {
                    return false;
                }

                @Override // androidx.recyclerview.widget.LinearLayoutManager
                protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
                    super.calculateExtraLayoutSpace(state, extraLayoutSpace);
                    if (mediaPage.selectedType == 0) {
                        extraLayoutSpace[1] = Math.max(extraLayoutSpace[1], SharedPhotoVideoCell.getItemSize(MediaActivity.this.columnsCount) * 2);
                    } else if (mediaPage.selectedType == 1) {
                        extraLayoutSpace[1] = Math.max(extraLayoutSpace[1], AndroidUtilities.dp(56.0f) * 2);
                    }
                }
            };
            this.mediaPages[i7].listView = new RecyclerListView(context) { // from class: ir.eitaa.ui.MediaActivity.10
                @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean changed, int l, int t, int r, int b) {
                    super.onLayout(changed, l, t, r, b);
                    MediaActivity.this.updateSections(this, true);
                    if (mediaPage.selectedType == 0) {
                        PhotoViewer.getInstance().checkCurrentImageVisibility();
                    }
                }
            };
            this.mediaPages[i7].listView.setScrollingTouchSlop(1);
            this.mediaPages[i7].listView.setItemAnimator(null);
            this.mediaPages[i7].listView.setClipToPadding(false);
            this.mediaPages[i7].listView.setSectionsType(2);
            this.mediaPages[i7].listView.setLayoutManager(linearLayoutManager);
            MediaPage[] mediaPageArr3 = this.mediaPages;
            mediaPageArr3[i7].addView(mediaPageArr3[i7].listView, LayoutHelper.createFrame(-1, -1.0f));
            this.mediaPages[i7].listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$rNcZbgat10eyh8QfFQ8WxzxpUiQ
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view2, int i9) throws Resources.NotFoundException {
                    this.f$0.lambda$createView$2$MediaActivity(mediaPage, view2, i9);
                }
            });
            this.mediaPages[i7].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.MediaActivity.11
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (newState == 1) {
                        AndroidUtilities.hideKeyboard(MediaActivity.this.getParentActivity().getCurrentFocus());
                    }
                    MediaActivity.this.scrolling = newState != 0;
                    if (newState != 1) {
                        int i9 = (int) (-((BaseFragment) MediaActivity.this).actionBar.getTranslationY());
                        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
                        if (i9 == 0 || i9 == currentActionBarHeight) {
                            return;
                        }
                        if (i9 < currentActionBarHeight / 2) {
                            MediaActivity.this.mediaPages[0].listView.smoothScrollBy(0, -i9);
                        } else if (MediaActivity.this.mediaPages[0].listView.canScrollVertically(1)) {
                            MediaActivity.this.mediaPages[0].listView.smoothScrollBy(0, currentActionBarHeight - i9);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    int i9;
                    if (MediaActivity.this.searching && MediaActivity.this.searchWas) {
                        return;
                    }
                    int iFindFirstVisibleItemPosition2 = linearLayoutManager.findFirstVisibleItemPosition();
                    int iAbs = iFindFirstVisibleItemPosition2 == -1 ? 0 : Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition2) + 1;
                    int itemCount = recyclerView.getAdapter().getItemCount();
                    int i10 = mediaPage.selectedType == 0 ? 3 : 6;
                    if (iAbs != 0 && iFindFirstVisibleItemPosition2 + iAbs > itemCount - i10 && !MediaActivity.this.sharedMediaData[mediaPage.selectedType].loading) {
                        if (mediaPage.selectedType == 0) {
                            i9 = 0;
                        } else if (mediaPage.selectedType == 1) {
                            i9 = 1;
                        } else if (mediaPage.selectedType == 2) {
                            i9 = 2;
                        } else if (mediaPage.selectedType == 4) {
                            i9 = 4;
                        } else {
                            i9 = mediaPage.selectedType == 5 ? 5 : 3;
                        }
                        if (!MediaActivity.this.sharedMediaData[mediaPage.selectedType].endReached[0]) {
                            MediaActivity.this.sharedMediaData[mediaPage.selectedType].loading = true;
                            MediaDataController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).loadMedia(MediaActivity.this.dialogId, 50, MediaActivity.this.sharedMediaData[mediaPage.selectedType].max_id[0], i9, 1, ((BaseFragment) MediaActivity.this).classGuid);
                        } else if (MediaActivity.this.mergeDialogId != 0 && !MediaActivity.this.sharedMediaData[mediaPage.selectedType].endReached[1]) {
                            MediaActivity.this.sharedMediaData[mediaPage.selectedType].loading = true;
                            MediaDataController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).loadMedia(MediaActivity.this.mergeDialogId, 50, MediaActivity.this.sharedMediaData[mediaPage.selectedType].max_id[1], i9, 1, ((BaseFragment) MediaActivity.this).classGuid);
                        }
                    }
                    if (recyclerView == MediaActivity.this.mediaPages[0].listView && !MediaActivity.this.searching && !((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed() && !MediaActivity.this.disableActionBarScrolling) {
                        float translationY = ((BaseFragment) MediaActivity.this).actionBar.getTranslationY();
                        float f = translationY - dy;
                        if (f < (-ActionBar.getCurrentActionBarHeight())) {
                            f = -ActionBar.getCurrentActionBarHeight();
                        } else if (f > 0.0f) {
                            f = 0.0f;
                        }
                        if (f != translationY) {
                            MediaActivity.this.setScrollY(f);
                        }
                    }
                    MediaActivity.this.updateSections(recyclerView, false);
                }
            });
            this.mediaPages[i7].listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$BDkncFpoSBxZL0TmMWdvkYI0lyM
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
                public final boolean onItemClick(View view2, int i9) {
                    return this.f$0.lambda$createView$3$MediaActivity(mediaPage, view2, i9);
                }
            });
            if (i7 != 0 || i == -1) {
                top = i8;
            } else {
                top = i8;
                linearLayoutManager.scrollToPositionWithOffset(i, top);
            }
            final RecyclerListView recyclerListView = this.mediaPages[i7].listView;
            this.mediaPages[i7].animatingImageView = new ClippingImageView(context) { // from class: ir.eitaa.ui.MediaActivity.12
                @Override // android.view.View
                public void invalidate() {
                    super.invalidate();
                    recyclerListView.invalidate();
                }
            };
            this.mediaPages[i7].animatingImageView.setVisibility(8);
            this.mediaPages[i7].listView.addOverlayView(this.mediaPages[i7].animatingImageView, LayoutHelper.createFrame(-1, -1.0f));
            this.mediaPages[i7].progressView = new FlickerLoadingView(context) { // from class: ir.eitaa.ui.MediaActivity.13
                @Override // ir.eitaa.ui.Components.FlickerLoadingView
                public int getColumnsCount() {
                    return MediaActivity.this.columnsCount;
                }

                @Override // ir.eitaa.ui.Components.FlickerLoadingView
                public int getViewType() {
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
                    return mediaPage.selectedType == 7 ? 6 : 1;
                }

                @Override // ir.eitaa.ui.Components.FlickerLoadingView, android.view.View
                protected void onDraw(Canvas canvas) {
                    MediaActivity.this.backgroundPaint.setColor(Theme.getColor("windowBackgroundWhite"));
                    canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), MediaActivity.this.backgroundPaint);
                    super.onDraw(canvas);
                }
            };
            this.mediaPages[i7].progressView.setUseHeaderOffset(true);
            this.mediaPages[i7].progressView.showDate(false);
            if (i7 != 0) {
                this.mediaPages[i7].setVisibility(8);
            }
            this.mediaPages[i7].emptyView = new StickerEmptyView(context, this.mediaPages[i7].progressView, 1);
            this.mediaPages[i7].emptyView.setVisibility(8);
            this.mediaPages[i7].emptyView.setAnimateLayoutChange(true);
            MediaPage[] mediaPageArr4 = this.mediaPages;
            mediaPageArr4[i7].addView(mediaPageArr4[i7].emptyView, LayoutHelper.createFrame(-1, -1.0f));
            this.mediaPages[i7].emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$8jlQT-dlakU1eCk8yXbAEl44xJk
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return MediaActivity.lambda$createView$4(view2, motionEvent);
                }
            });
            this.mediaPages[i7].emptyView.showProgress(true, false);
            this.mediaPages[i7].emptyView.title.setText(LocaleController.getString("NoResult", R.string.NoResult));
            this.mediaPages[i7].emptyView.addView(this.mediaPages[i7].progressView, LayoutHelper.createFrame(-1, -1.0f));
            this.mediaPages[i7].listView.setEmptyView(this.mediaPages[i7].emptyView);
            this.mediaPages[i7].listView.setAnimateEmptyView(true, 0);
            i7++;
            iFindFirstVisibleItemPosition = i;
            i5 = -1;
        }
        if (!AndroidUtilities.isTablet()) {
            FragmentContextView fragmentContextView = new FragmentContextView(context, this, false);
            this.fragmentContextView = fragmentContextView;
            frameLayout.addView(fragmentContextView, LayoutHelper.createFrame(-1, 38.0f, 51, 0.0f, 8.0f, 0.0f, 0.0f));
        }
        frameLayout.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        updateTabs();
        switchToCurrentSelectedMode(false);
        this.swipeBackEnabled = this.scrollSlidingTextTabStrip.getCurrentTabId() == this.scrollSlidingTextTabStrip.getFirstTabId();
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.MediaActivity$4, reason: invalid class name */
    class AnonymousClass4 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass4() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) {
            TLRPC$Chat chat;
            TLRPC$User user;
            TLRPC$EncryptedChat encryptedChat;
            if (id == -1) {
                if (MediaActivity.this.closeActionMode()) {
                    return;
                }
                MediaActivity.this.finishFragment();
                return;
            }
            if (id == 4) {
                if (DialogObject.isEncryptedDialog(MediaActivity.this.dialogId)) {
                    encryptedChat = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(MediaActivity.this.dialogId)));
                    user = null;
                    chat = null;
                } else if (DialogObject.isUserDialog(MediaActivity.this.dialogId)) {
                    user = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getUser(Long.valueOf(MediaActivity.this.dialogId));
                    chat = null;
                    encryptedChat = null;
                } else {
                    chat = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getChat(Long.valueOf(-MediaActivity.this.dialogId));
                    user = null;
                    encryptedChat = null;
                }
                MediaActivity mediaActivity = MediaActivity.this;
                AlertsCreator.createDeleteMessagesAlert(mediaActivity, user, chat, encryptedChat, null, mediaActivity.mergeDialogId, null, MediaActivity.this.selectedFiles, null, false, 1, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$4$dOE65eLYLEHBaug_pSEymSL0Rvo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onItemClick$0$MediaActivity$4();
                    }
                }, null);
                return;
            }
            if (id != 3) {
                if (id == 7 && MediaActivity.this.selectedFiles[0].size() == 1) {
                    Bundle bundle = new Bundle();
                    if (DialogObject.isEncryptedDialog(MediaActivity.this.dialogId)) {
                        bundle.putInt("enc_id", DialogObject.getEncryptedChatId(MediaActivity.this.dialogId));
                    } else if (DialogObject.isUserDialog(MediaActivity.this.dialogId)) {
                        bundle.putLong("user_id", MediaActivity.this.dialogId);
                    } else {
                        long j = MediaActivity.this.dialogId;
                        TLRPC$Chat chat2 = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getChat(Long.valueOf(-j));
                        if (chat2 != null && chat2.migrated_to != null) {
                            bundle.putLong("migrated_to", j);
                            j = -chat2.migrated_to.channel_id;
                        }
                        bundle.putLong("chat_id", -j);
                    }
                    bundle.putInt("message_id", MediaActivity.this.selectedFiles[0].keyAt(0));
                    bundle.putBoolean("need_remove_previous_same_chat_activity", false);
                    MediaActivity.this.presentFragment(new ChatActivity(bundle), false);
                    return;
                }
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("onlySelect", true);
            bundle2.putInt("dialogsType", 3);
            DialogsActivity dialogsActivity = new DialogsActivity(bundle2);
            dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$4$dDg4ZdZcFk0rdWQqKRF_IuRgne0
                @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
                public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                    this.f$0.lambda$onItemClick$1$MediaActivity$4(dialogsActivity2, arrayList, charSequence, z);
                }
            });
            MediaActivity.this.presentFragment(dialogsActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$MediaActivity$4() {
            ((BaseFragment) MediaActivity.this).actionBar.hideActionMode();
            ((BaseFragment) MediaActivity.this).actionBar.closeSearchField();
            MediaActivity.this.cantDeleteMessagesCount = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$MediaActivity$4(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
            ArrayList<MessageObject> arrayList2 = new ArrayList<>();
            int i = 1;
            while (true) {
                if (i < 0) {
                    break;
                }
                ArrayList arrayList3 = new ArrayList();
                for (int i2 = 0; i2 < MediaActivity.this.selectedFiles[i].size(); i2++) {
                    arrayList3.add(Integer.valueOf(MediaActivity.this.selectedFiles[i].keyAt(i2)));
                }
                Collections.sort(arrayList3);
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    if (num.intValue() > 0) {
                        arrayList2.add((MessageObject) MediaActivity.this.selectedFiles[i].get(num.intValue()));
                    }
                }
                MediaActivity.this.selectedFiles[i].clear();
                i--;
            }
            MediaActivity.this.cantDeleteMessagesCount = 0;
            ((BaseFragment) MediaActivity.this).actionBar.hideActionMode();
            if (arrayList.size() > 1 || ((Long) arrayList.get(0)).longValue() == UserConfig.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getClientUserId() || charSequence != null) {
                MediaActivity.this.updateRowsSelection();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    long jLongValue = ((Long) arrayList.get(i3)).longValue();
                    if (charSequence != null) {
                        SendMessagesHelper.getInstance(((BaseFragment) MediaActivity.this).currentAccount).sendMessage(charSequence.toString(), jLongValue, null, null, null, true, null, null, null, true, 0, null);
                    }
                    SendMessagesHelper.getInstance(((BaseFragment) MediaActivity.this).currentAccount).sendMessage(arrayList2, jLongValue, false, false, true, 0);
                }
                dialogsActivity.finishFragment();
                return;
            }
            long jLongValue2 = ((Long) arrayList.get(0)).longValue();
            Bundle bundle = new Bundle();
            bundle.putBoolean("scrollToTopOnResume", true);
            if (DialogObject.isEncryptedDialog(jLongValue2)) {
                bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue2));
            } else if (DialogObject.isUserDialog(jLongValue2)) {
                bundle.putLong("user_id", jLongValue2);
            } else {
                bundle.putLong("chat_id", -jLongValue2);
            }
            if (DialogObject.isEncryptedDialog(jLongValue2) || MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).checkCanOpenChat(bundle, dialogsActivity)) {
                NotificationCenter.getInstance(((BaseFragment) MediaActivity.this).currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
                ChatActivity chatActivity = new ChatActivity(bundle);
                MediaActivity.this.presentFragment(chatActivity, true);
                chatActivity.showFieldPanelForForward(true, arrayList2);
                if (AndroidUtilities.isTablet()) {
                    return;
                }
                MediaActivity.this.removeSelfFromStack();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$MediaActivity(MediaPage mediaPage, View view, int i) throws Resources.NotFoundException {
        if (mediaPage.selectedType != 1 || !(view instanceof SharedDocumentCell)) {
            if (mediaPage.selectedType != 3 || !(view instanceof SharedLinkCell)) {
                if ((mediaPage.selectedType == 2 || mediaPage.selectedType == 4) && (view instanceof SharedAudioCell)) {
                    onItemClick(i, view, ((SharedAudioCell) view).getMessage(), 0, mediaPage.selectedType);
                    return;
                }
                return;
            }
            onItemClick(i, view, ((SharedLinkCell) view).getMessage(), 0, mediaPage.selectedType);
            return;
        }
        onItemClick(i, view, ((SharedDocumentCell) view).getMessage(), 0, mediaPage.selectedType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$3$MediaActivity(MediaPage mediaPage, View view, int i) {
        if (this.actionBar.isActionModeShowed()) {
            mediaPage.listView.getOnItemClickListener().onItemClick(view, i);
            return true;
        }
        if (mediaPage.selectedType != 1 || !(view instanceof SharedDocumentCell)) {
            if (mediaPage.selectedType != 3 || !(view instanceof SharedLinkCell)) {
                if ((mediaPage.selectedType == 2 || mediaPage.selectedType == 4) && (view instanceof SharedAudioCell)) {
                    return onItemLongClick(((SharedAudioCell) view).getMessage(), view, 0);
                }
                return false;
            }
            return onItemLongClick(((SharedLinkCell) view).getMessage(), view, 0);
        }
        return onItemLongClick(((SharedDocumentCell) view).getMessage(), view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean closeActionMode() {
        if (!this.actionBar.isActionModeShowed()) {
            return false;
        }
        for (int i = 1; i >= 0; i--) {
            this.selectedFiles[i].clear();
        }
        this.cantDeleteMessagesCount = 0;
        this.actionBar.hideActionMode();
        updateRowsSelection();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollY(float value) {
        this.actionBar.setTranslationY(value);
        FragmentContextView fragmentContextView = this.fragmentContextView;
        if (fragmentContextView != null) {
            fragmentContextView.setTranslationY(this.additionalPadding + value);
        }
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i < mediaPageArr.length) {
                mediaPageArr[i].listView.setPinnedSectionOffsetY((int) value);
                i++;
            } else {
                this.fragmentView.invalidate();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetScroll() {
        if (this.actionBar.getTranslationY() == 0.0f) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, this.SCROLL_Y, 0.0f));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(180L);
        animatorSet.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b8  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r22, int r23, java.lang.Object... r24) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MediaActivity.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        return this.swipeBackEnabled;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                return;
            }
            if (mediaPageArr[i].listView != null) {
                this.mediaPages[i].listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.MediaActivity.14
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        MediaActivity.this.mediaPages[i].getViewTreeObserver().removeOnPreDrawListener(this);
                        MediaActivity.this.fixLayoutInternal(i);
                        return true;
                    }
                });
            }
            i++;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return this.actionBar.isEnabled() && !closeActionMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSections(RecyclerView listView, boolean checkTopBottom) {
        int childCount = listView.getChildCount();
        float paddingTop = listView.getPaddingTop() + this.actionBar.getTranslationY();
        View view = null;
        int iMax = 0;
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = listView.getChildAt(i2);
            int bottom = childAt.getBottom();
            iMin = Math.min(iMin, childAt.getTop());
            iMax = Math.max(bottom, iMax);
            if (bottom > paddingTop) {
                int bottom2 = childAt.getBottom();
                if ((childAt instanceof SharedMediaSectionCell) || (childAt instanceof GraySectionCell)) {
                    if (childAt.getAlpha() != 1.0f) {
                        childAt.setAlpha(1.0f);
                    }
                    if (bottom2 < i) {
                        view = childAt;
                        i = bottom2;
                    }
                }
            }
        }
        if (view != null) {
            if (view.getTop() > paddingTop) {
                if (view.getAlpha() != 1.0f) {
                    view.setAlpha(1.0f);
                }
            } else if (view.getAlpha() != 0.0f) {
                view.setAlpha(0.0f);
            }
        }
        if (checkTopBottom) {
            if (iMax != 0 && iMax < listView.getMeasuredHeight() - listView.getPaddingBottom()) {
                resetScroll();
            } else {
                if (iMin == Integer.MAX_VALUE || iMin <= listView.getPaddingTop() + this.actionBar.getTranslationY()) {
                    return;
                }
                scrollWithoutActionBar(listView, -listView.computeVerticalScrollOffset());
                resetScroll();
            }
        }
    }

    public void setChatInfo(TLRPC$ChatFull chatInfo) {
        this.info = chatInfo;
        if (chatInfo == null) {
            return;
        }
        long j = chatInfo.migrated_from_chat_id;
        if (j == 0 || this.mergeDialogId != 0) {
            return;
        }
        this.mergeDialogId = -j;
        int i = 0;
        while (true) {
            SharedMediaLayout.SharedMediaData[] sharedMediaDataArr = this.sharedMediaData;
            if (i >= sharedMediaDataArr.length) {
                return;
            }
            sharedMediaDataArr[i].max_id[1] = this.info.migrated_from_max_id;
            sharedMediaDataArr[i].endReached[1] = false;
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowsSelection() {
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
                }
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateTabs() {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MediaActivity.updateTabs():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode(boolean z) {
        MediaPage[] mediaPageArr;
        MediaSearchAdapter mediaSearchAdapter;
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
                            if (this.mediaPages[z ? 1 : 0].selectedType == 4 && adapter != this.audioAdapter) {
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
            if (this.mediaPages[z ? 1 : 0].selectedType == 0 || this.mediaPages[z ? 1 : 0].selectedType == 2) {
                if (z) {
                    this.searchItemState = 2;
                } else {
                    this.searchItemState = 0;
                    this.searchItem.setVisibility(4);
                }
            } else if (z) {
                if (this.searchItem.getVisibility() == 4 && !this.actionBar.isSearchFieldVisible()) {
                    this.searchItemState = 1;
                    this.searchItem.setVisibility(0);
                    this.searchItem.setAlpha(0.0f);
                } else {
                    this.searchItemState = 0;
                }
            } else if (this.searchItem.getVisibility() == 4) {
                this.searchItemState = 0;
                this.searchItem.setAlpha(1.0f);
                this.searchItem.setVisibility(0);
            }
            if (!this.sharedMediaData[this.mediaPages[z ? 1 : 0].selectedType].loading && !this.sharedMediaData[this.mediaPages[z ? 1 : 0].selectedType].endReached[0] && this.sharedMediaData[this.mediaPages[z ? 1 : 0].selectedType].messages.isEmpty()) {
                this.sharedMediaData[this.mediaPages[z ? 1 : 0].selectedType].loading = true;
                MediaDataController.getInstance(this.currentAccount).loadMedia(this.dialogId, 50, 0, this.mediaPages[z ? 1 : 0].selectedType, 1, this.classGuid);
            }
            this.mediaPages[z ? 1 : 0].listView.setVisibility(0);
        } else if (z) {
            if (this.mediaPages[z ? 1 : 0].selectedType == 0 || this.mediaPages[z ? 1 : 0].selectedType == 2) {
                this.searching = false;
                this.searchWas = false;
                switchToCurrentSelectedMode(true);
                return;
            }
            String string = this.searchItem.getSearchField().getText().toString();
            if (this.mediaPages[z ? 1 : 0].selectedType != 1) {
                if (this.mediaPages[z ? 1 : 0].selectedType != 3) {
                    if (this.mediaPages[z ? 1 : 0].selectedType == 4 && (mediaSearchAdapter = this.audioSearchAdapter) != null) {
                        mediaSearchAdapter.search(string);
                        if (adapter != this.audioSearchAdapter) {
                            recycleAdapter(adapter);
                            this.mediaPages[z ? 1 : 0].listView.setAdapter(this.audioSearchAdapter);
                        }
                    }
                } else {
                    MediaSearchAdapter mediaSearchAdapter2 = this.linksSearchAdapter;
                    if (mediaSearchAdapter2 != null) {
                        mediaSearchAdapter2.search(string);
                        if (adapter != this.linksSearchAdapter) {
                            recycleAdapter(adapter);
                            this.mediaPages[z ? 1 : 0].listView.setAdapter(this.linksSearchAdapter);
                        }
                    }
                }
            } else {
                MediaSearchAdapter mediaSearchAdapter3 = this.documentsSearchAdapter;
                if (mediaSearchAdapter3 != null) {
                    mediaSearchAdapter3.search(string);
                    if (adapter != this.documentsSearchAdapter) {
                        recycleAdapter(adapter);
                        this.mediaPages[z ? 1 : 0].listView.setAdapter(this.documentsSearchAdapter);
                    }
                }
            }
        } else if (this.mediaPages[z ? 1 : 0].listView != null) {
            if (this.mediaPages[z ? 1 : 0].selectedType != 1) {
                if (this.mediaPages[z ? 1 : 0].selectedType != 3) {
                    if (this.mediaPages[z ? 1 : 0].selectedType == 4) {
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
        }
        if (this.actionBar.getTranslationY() != 0.0f) {
            this.mediaPages[z ? 1 : 0].layoutManager.scrollToPositionWithOffset(0, (int) this.actionBar.getTranslationY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onItemLongClick(MessageObject item, View view, int a) {
        if (this.actionBar.isActionModeShowed() || getParentActivity() == null) {
            return false;
        }
        AndroidUtilities.hideKeyboard(getParentActivity().getCurrentFocus());
        this.selectedFiles[item.getDialogId() == this.dialogId ? (char) 0 : (char) 1].put(item.getId(), item);
        if (!item.canDeleteMessage(false, null)) {
            this.cantDeleteMessagesCount++;
        }
        this.actionBar.createActionMode().getItem(4).setVisibility(this.cantDeleteMessagesCount == 0 ? 0 : 8);
        ActionBarMenuItem actionBarMenuItem = this.gotoItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setVisibility(0);
        }
        this.selectedMessagesCountTextView.setNumber(1, false);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.actionModeViews.size(); i++) {
            View view2 = this.actionModeViews.get(i);
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
            ((SharedPhotoVideoCell) view).setChecked(a, true, true);
        } else if (view instanceof SharedLinkCell) {
            ((SharedLinkCell) view).setChecked(true, true);
        } else if (view instanceof SharedAudioCell) {
            ((SharedAudioCell) view).setChecked(true, true);
        }
        if (!this.actionBar.isActionModeShowed()) {
            this.actionBar.showActionMode(true, null, this.actionModeBackground, null, null, null, 0);
            resetScroll();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(int index, View view, MessageObject message, int a, int selectedMode) throws Resources.NotFoundException {
        int i;
        if (message == null) {
            return;
        }
        String link = null;
        if (this.actionBar.isActionModeShowed()) {
            char c = message.getDialogId() == this.dialogId ? (char) 0 : (char) 1;
            if (this.selectedFiles[c].indexOfKey(message.getId()) >= 0) {
                this.selectedFiles[c].remove(message.getId());
                if (!message.canDeleteMessage(false, null)) {
                    this.cantDeleteMessagesCount--;
                }
            } else {
                if (this.selectedFiles[0].size() + this.selectedFiles[1].size() >= 100) {
                    return;
                }
                this.selectedFiles[c].put(message.getId(), message);
                if (!message.canDeleteMessage(false, null)) {
                    this.cantDeleteMessagesCount++;
                }
            }
            if (this.selectedFiles[0].size() == 0 && this.selectedFiles[1].size() == 0) {
                this.actionBar.hideActionMode();
            } else {
                this.selectedMessagesCountTextView.setNumber(this.selectedFiles[0].size() + this.selectedFiles[1].size(), true);
                this.actionBar.createActionMode().getItem(4).setVisibility(this.cantDeleteMessagesCount == 0 ? 0 : 8);
                ActionBarMenuItem actionBarMenuItem = this.gotoItem;
                if (actionBarMenuItem != null) {
                    actionBarMenuItem.setVisibility(this.selectedFiles[0].size() == 1 ? 0 : 8);
                }
            }
            this.scrolling = false;
            if (view instanceof SharedDocumentCell) {
                ((SharedDocumentCell) view).setChecked(this.selectedFiles[c].indexOfKey(message.getId()) >= 0, true);
                return;
            }
            if (view instanceof SharedPhotoVideoCell) {
                SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) view;
                if (this.selectedFiles[c].indexOfKey(message.getId()) >= 0) {
                    i = a;
                    z = true;
                } else {
                    i = a;
                }
                sharedPhotoVideoCell.setChecked(i, z, true);
                return;
            }
            if (view instanceof SharedLinkCell) {
                ((SharedLinkCell) view).setChecked(this.selectedFiles[c].indexOfKey(message.getId()) >= 0, true);
                return;
            } else {
                if (view instanceof SharedAudioCell) {
                    ((SharedAudioCell) view).setChecked(this.selectedFiles[c].indexOfKey(message.getId()) >= 0, true);
                    return;
                }
                return;
            }
        }
        if (selectedMode == 0) {
            PhotoViewer.getInstance().setParentActivity(getParentActivity());
            PhotoViewer.getInstance().openPhoto(this.sharedMediaData[selectedMode].messages, index, this.dialogId, this.mergeDialogId, this.provider);
            return;
        }
        if (selectedMode == 2 || selectedMode == 4) {
            if (view instanceof SharedAudioCell) {
                ((SharedAudioCell) view).didPressedButton();
                return;
            }
            return;
        }
        if (selectedMode == 1) {
            if (view instanceof SharedDocumentCell) {
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) view;
                TLRPC$Document document = message.getDocument();
                if (sharedDocumentCell.isLoaded()) {
                    if (message.canPreviewDocument()) {
                        PhotoViewer.getInstance().setParentActivity(getParentActivity());
                        int iIndexOf = this.sharedMediaData[selectedMode].messages.indexOf(message);
                        if (iIndexOf < 0) {
                            ArrayList<MessageObject> arrayList = new ArrayList<>();
                            arrayList.add(message);
                            PhotoViewer.getInstance().openPhoto(arrayList, 0, 0L, 0L, this.provider);
                            return;
                        }
                        PhotoViewer.getInstance().openPhoto(this.sharedMediaData[selectedMode].messages, iIndexOf, this.dialogId, this.mergeDialogId, this.provider);
                        return;
                    }
                    AndroidUtilities.openDocument(message, getParentActivity(), this);
                    return;
                }
                if (!sharedDocumentCell.isLoading()) {
                    FileLoader.getInstance(this.currentAccount).loadFile(document, sharedDocumentCell.getMessage(), 0, 0);
                    sharedDocumentCell.updateFileExistIcon(true);
                    return;
                } else {
                    FileLoader.getInstance(this.currentAccount).cancelLoadFile(document);
                    sharedDocumentCell.updateFileExistIcon(true);
                    return;
                }
            }
            return;
        }
        if (selectedMode == 3) {
            try {
                TLRPC$MessageMedia tLRPC$MessageMedia = message.messageOwner.media;
                TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia != null ? tLRPC$MessageMedia.webpage : null;
                if (tLRPC$WebPage != null && !(tLRPC$WebPage instanceof TLRPC$TL_webPageEmpty)) {
                    if (tLRPC$WebPage.cached_page != null) {
                        ArticleViewer.getInstance().setParentActivity(getParentActivity(), this);
                        ArticleViewer.getInstance().open(message);
                        return;
                    }
                    String str = tLRPC$WebPage.embed_url;
                    if (str != null && str.length() != 0) {
                        openWebView(tLRPC$WebPage, message);
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
    public void openUrl(String link) {
        if (AndroidUtilities.shouldShowUrlInAlert(link)) {
            AlertsCreator.showOpenUrlAlert(this, link, true, true);
        } else {
            Browser.openUrl(getParentActivity(), link);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebView(TLRPC$WebPage webPage, MessageObject messageObject) {
        EmbedBottomSheet.show(getParentActivity(), messageObject, this.provider, webPage.site_name, webPage.description, webPage.url, webPage.embed_url, webPage.embed_width, webPage.embed_height, false);
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
    public void fixLayoutInternal(int num) {
        int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (num == 0) {
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
        if (num == 0) {
            this.photoVideoAdapter.notifyDataSetChanged();
            fixScrollOffset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixScrollOffset() {
        RecyclerListView recyclerListView;
        View childAt;
        int y;
        if (this.actionBar.getTranslationY() == 0.0f || (childAt = (recyclerListView = this.mediaPages[0].listView).getChildAt(0)) == null || (y = (int) (childAt.getY() - ((this.actionBar.getMeasuredHeight() + this.actionBar.getTranslationY()) + this.additionalPadding))) <= 0) {
            return;
        }
        scrollWithoutActionBar(recyclerListView, y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollWithoutActionBar(RecyclerView listView, int dy) {
        this.disableActionBarScrolling = true;
        listView.scrollBy(0, dy);
        this.disableActionBarScrolling = false;
    }

    /* renamed from: ir.eitaa.ui.MediaActivity$15, reason: invalid class name */
    class AnonymousClass15 implements SharedLinkCell.SharedLinkCellDelegate {
        AnonymousClass15() {
        }

        @Override // ir.eitaa.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public void needOpenWebView(TLRPC$WebPage webPage, MessageObject message) {
            MediaActivity.this.openWebView(webPage, message);
        }

        @Override // ir.eitaa.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public boolean canPerformActions() {
            return !((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed();
        }

        @Override // ir.eitaa.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public void onLinkPress(final String urlFinal, boolean longPress) {
            if (!longPress) {
                MediaActivity.this.openUrl(urlFinal);
                return;
            }
            BottomSheet.Builder builder = new BottomSheet.Builder(MediaActivity.this.getParentActivity());
            builder.setTitle(urlFinal);
            builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$15$CCmIe7xCAspNBcxKwAyJK-CYFqA
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onLinkPress$0$MediaActivity$15(urlFinal, dialogInterface, i);
                }
            });
            MediaActivity.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onLinkPress$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLinkPress$0$MediaActivity$15(String str, DialogInterface dialogInterface, int i) {
            if (i == 0) {
                MediaActivity.this.openUrl(str);
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int section, int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
            return row != 0;
        }

        public SharedLinksAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            int i = 1;
            if (MediaActivity.this.sharedMediaData[3].sections.size() == 0 && !MediaActivity.this.sharedMediaData[3].loading) {
                return 1;
            }
            int size = MediaActivity.this.sharedMediaData[3].sections.size();
            if (MediaActivity.this.sharedMediaData[3].sections.isEmpty() || (MediaActivity.this.sharedMediaData[3].endReached[0] && MediaActivity.this.sharedMediaData[3].endReached[1])) {
                i = 0;
            }
            return size + i;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int section) {
            if ((MediaActivity.this.sharedMediaData[3].sections.size() != 0 || MediaActivity.this.sharedMediaData[3].loading) && section < MediaActivity.this.sharedMediaData[3].sections.size()) {
                return MediaActivity.this.sharedMediaData[3].sectionArrays.get(MediaActivity.this.sharedMediaData[3].sections.get(section)).size() + 1;
            }
            return 1;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int section, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor("graySection") & (-218103809));
            }
            if (MediaActivity.this.sharedMediaData[3].sections.size() != 0) {
                if (section < MediaActivity.this.sharedMediaData[3].sections.size()) {
                    view.setAlpha(1.0f);
                    ((GraySectionCell) view).setText(LocaleController.formatSectionDate(MediaActivity.this.sharedMediaData[3].sectionArrays.get(MediaActivity.this.sharedMediaData[3].sections.get(section)).get(0).messageOwner.date));
                }
            } else {
                view.setAlpha(0.0f);
            }
            return view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout graySectionCell;
            if (i == 0) {
                graySectionCell = new GraySectionCell(this.mContext);
            } else if (i == 1) {
                SharedLinkCell sharedLinkCell = new SharedLinkCell(this.mContext);
                sharedLinkCell.setDelegate(MediaActivity.this.sharedLinkCellDelegate);
                graySectionCell = sharedLinkCell;
            } else {
                if (i == 3) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 3, MediaActivity.this.dialogId);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                graySectionCell = new LoadingCell(this.mContext, AndroidUtilities.dp(32.0f), AndroidUtilities.dp(54.0f));
            }
            return new RecyclerListView.Holder(graySectionCell);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 2 || holder.getItemViewType() == 3) {
                return;
            }
            ArrayList<MessageObject> arrayList = MediaActivity.this.sharedMediaData[3].sectionArrays.get(MediaActivity.this.sharedMediaData[3].sections.get(section));
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                ((GraySectionCell) holder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                return;
            }
            if (itemViewType != 1) {
                return;
            }
            SharedLinkCell sharedLinkCell = (SharedLinkCell) holder.itemView;
            MessageObject messageObject = arrayList.get(position - 1);
            sharedLinkCell.setLink(messageObject, position != arrayList.size() || (section == MediaActivity.this.sharedMediaData[3].sections.size() - 1 && MediaActivity.this.sharedMediaData[3].loading));
            if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                sharedLinkCell.setChecked(MediaActivity.this.selectedFiles[(messageObject.getDialogId() > MediaActivity.this.dialogId ? 1 : (messageObject.getDialogId() == MediaActivity.this.dialogId ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !MediaActivity.this.scrolling);
            } else {
                sharedLinkCell.setChecked(false, !MediaActivity.this.scrolling);
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int section, int position) {
            if (MediaActivity.this.sharedMediaData[3].sections.size() == 0 && !MediaActivity.this.sharedMediaData[3].loading) {
                return 3;
            }
            if (section < MediaActivity.this.sharedMediaData[3].sections.size()) {
                return position == 0 ? 0 : 1;
            }
            return 2;
        }
    }

    private class SharedDocumentsAdapter extends RecyclerListView.SectionsAdapter {
        private int currentType;
        private Context mContext;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int section, int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
            return row != 0;
        }

        public SharedDocumentsAdapter(Context context, int type) {
            this.mContext = context;
            this.currentType = type;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            int i = 1;
            if (MediaActivity.this.sharedMediaData[this.currentType].sections.size() == 0 && !MediaActivity.this.sharedMediaData[this.currentType].loading) {
                return 1;
            }
            int size = MediaActivity.this.sharedMediaData[this.currentType].sections.size();
            if (MediaActivity.this.sharedMediaData[this.currentType].sections.isEmpty() || (MediaActivity.this.sharedMediaData[this.currentType].endReached[0] && MediaActivity.this.sharedMediaData[this.currentType].endReached[1])) {
                i = 0;
            }
            return size + i;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int section) {
            if ((MediaActivity.this.sharedMediaData[this.currentType].sections.size() != 0 || MediaActivity.this.sharedMediaData[this.currentType].loading) && section < MediaActivity.this.sharedMediaData[this.currentType].sections.size()) {
                return MediaActivity.this.sharedMediaData[this.currentType].sectionArrays.get(MediaActivity.this.sharedMediaData[this.currentType].sections.get(section)).size() + 1;
            }
            return 1;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int section, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor("graySection") & (-218103809));
            }
            if (MediaActivity.this.sharedMediaData[this.currentType].sections.size() != 0) {
                if (section < MediaActivity.this.sharedMediaData[this.currentType].sections.size()) {
                    view.setAlpha(1.0f);
                    ((GraySectionCell) view).setText(LocaleController.formatSectionDate(MediaActivity.this.sharedMediaData[this.currentType].sectionArrays.get(MediaActivity.this.sharedMediaData[this.currentType].sections.get(section)).get(0).messageOwner.date));
                }
            } else {
                view.setAlpha(0.0f);
            }
            return view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View graySectionCell;
            if (viewType == 0) {
                graySectionCell = new GraySectionCell(this.mContext);
            } else if (viewType == 1) {
                graySectionCell = new SharedDocumentCell(this.mContext);
            } else if (viewType == 2) {
                graySectionCell = new LoadingCell(this.mContext, AndroidUtilities.dp(32.0f), AndroidUtilities.dp(54.0f));
            } else {
                if (viewType == 4) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, this.currentType, MediaActivity.this.dialogId);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                if (this.currentType == 4 && !MediaActivity.this.audioCellCache.isEmpty()) {
                    graySectionCell = (View) MediaActivity.this.audioCellCache.get(0);
                    MediaActivity.this.audioCellCache.remove(0);
                    ViewGroup viewGroup = (ViewGroup) graySectionCell.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(graySectionCell);
                    }
                } else {
                    graySectionCell = new SharedAudioCell(this.mContext) { // from class: ir.eitaa.ui.MediaActivity.SharedDocumentsAdapter.1
                        @Override // ir.eitaa.ui.Cells.SharedAudioCell
                        public boolean needPlayMessage(MessageObject messageObject) throws IOException {
                            if (messageObject.isVoice() || messageObject.isRoundVideo()) {
                                boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject);
                                MediaController.getInstance().setVoiceMessagesPlaylist(zPlayMessage ? MediaActivity.this.sharedMediaData[SharedDocumentsAdapter.this.currentType].messages : null, false);
                                return zPlayMessage;
                            }
                            if (messageObject.isMusic()) {
                                return MediaController.getInstance().setPlaylist(MediaActivity.this.sharedMediaData[SharedDocumentsAdapter.this.currentType].messages, messageObject, MediaActivity.this.mergeDialogId);
                            }
                            return false;
                        }
                    };
                }
                if (this.currentType == 4) {
                    MediaActivity.this.audioCache.add((SharedAudioCell) graySectionCell);
                }
            }
            return new RecyclerListView.Holder(graySectionCell);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 2 || holder.getItemViewType() == 4) {
                return;
            }
            ArrayList<MessageObject> arrayList = MediaActivity.this.sharedMediaData[this.currentType].sectionArrays.get(MediaActivity.this.sharedMediaData[this.currentType].sections.get(section));
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                ((GraySectionCell) holder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                return;
            }
            if (itemViewType == 1) {
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) holder.itemView;
                MessageObject messageObject = arrayList.get(position - 1);
                sharedDocumentCell.setDocument(messageObject, position != arrayList.size() || (section == MediaActivity.this.sharedMediaData[this.currentType].sections.size() - 1 && MediaActivity.this.sharedMediaData[this.currentType].loading));
                if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                    sharedDocumentCell.setChecked(MediaActivity.this.selectedFiles[(messageObject.getDialogId() > MediaActivity.this.dialogId ? 1 : (messageObject.getDialogId() == MediaActivity.this.dialogId ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !MediaActivity.this.scrolling);
                    return;
                } else {
                    sharedDocumentCell.setChecked(false, !MediaActivity.this.scrolling);
                    return;
                }
            }
            if (itemViewType != 3) {
                return;
            }
            SharedAudioCell sharedAudioCell = (SharedAudioCell) holder.itemView;
            MessageObject messageObject2 = arrayList.get(position - 1);
            sharedAudioCell.setMessageObject(messageObject2, position != arrayList.size() || (section == MediaActivity.this.sharedMediaData[this.currentType].sections.size() - 1 && MediaActivity.this.sharedMediaData[this.currentType].loading));
            if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                sharedAudioCell.setChecked(MediaActivity.this.selectedFiles[(messageObject2.getDialogId() > MediaActivity.this.dialogId ? 1 : (messageObject2.getDialogId() == MediaActivity.this.dialogId ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject2.getId()) >= 0, !MediaActivity.this.scrolling);
            } else {
                sharedAudioCell.setChecked(false, !MediaActivity.this.scrolling);
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int section, int position) {
            if (MediaActivity.this.sharedMediaData[this.currentType].sections.size() == 0 && !MediaActivity.this.sharedMediaData[this.currentType].loading) {
                return 4;
            }
            if (section >= MediaActivity.this.sharedMediaData[this.currentType].sections.size()) {
                return 2;
            }
            if (position == 0) {
                return 0;
            }
            int i = this.currentType;
            return (i == 2 || i == 4) ? 3 : 1;
        }
    }

    private class SharedPhotoVideoAdapter extends RecyclerListView.SectionsAdapter {
        private Context mContext;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int section, int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
            return false;
        }

        public SharedPhotoVideoAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            int i = 0;
            if (MediaActivity.this.sharedMediaData[0].sections.size() == 0 && !MediaActivity.this.sharedMediaData[0].loading) {
                return 1;
            }
            int size = MediaActivity.this.sharedMediaData[0].sections.size();
            if (!MediaActivity.this.sharedMediaData[0].sections.isEmpty() && (!MediaActivity.this.sharedMediaData[0].endReached[0] || !MediaActivity.this.sharedMediaData[0].endReached[1])) {
                i = 1;
            }
            return size + i;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int section) {
            if ((MediaActivity.this.sharedMediaData[0].sections.size() != 0 || MediaActivity.this.sharedMediaData[0].loading) && section < MediaActivity.this.sharedMediaData[0].sections.size()) {
                return ((int) Math.ceil(MediaActivity.this.sharedMediaData[0].sectionArrays.get(MediaActivity.this.sharedMediaData[0].sections.get(section)).size() / MediaActivity.this.columnsCount)) + 1;
            }
            return 1;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int section, View view) {
            if (view == null) {
                view = new SharedMediaSectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor("windowBackgroundWhite") & (-436207617));
            }
            if (MediaActivity.this.sharedMediaData[0].sections.size() != 0) {
                if (section < MediaActivity.this.sharedMediaData[0].sections.size()) {
                    view.setAlpha(1.0f);
                    ((SharedMediaSectionCell) view).setText(LocaleController.formatSectionDate(MediaActivity.this.sharedMediaData[0].sectionArrays.get(MediaActivity.this.sharedMediaData[0].sections.get(section)).get(0).messageOwner.date));
                }
            } else {
                view.setAlpha(0.0f);
            }
            return view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View sharedMediaSectionCell;
            if (viewType == 0) {
                sharedMediaSectionCell = new SharedMediaSectionCell(this.mContext);
            } else if (viewType == 1) {
                if (!MediaActivity.this.cellCache.isEmpty()) {
                    sharedMediaSectionCell = (View) MediaActivity.this.cellCache.get(0);
                    MediaActivity.this.cellCache.remove(0);
                    ViewGroup viewGroup = (ViewGroup) sharedMediaSectionCell.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(sharedMediaSectionCell);
                    }
                } else {
                    sharedMediaSectionCell = new SharedPhotoVideoCell(this.mContext);
                }
                SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) sharedMediaSectionCell;
                sharedPhotoVideoCell.setDelegate(new SharedPhotoVideoCell.SharedPhotoVideoCellDelegate() { // from class: ir.eitaa.ui.MediaActivity.SharedPhotoVideoAdapter.1
                    @Override // ir.eitaa.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public void didClickItem(SharedPhotoVideoCell cell, int index, MessageObject messageObject, int a) throws Resources.NotFoundException {
                        MediaActivity.this.onItemClick(index, cell, messageObject, a, 0);
                    }

                    @Override // ir.eitaa.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public boolean didLongClickItem(SharedPhotoVideoCell cell, int index, MessageObject messageObject, int a) throws Resources.NotFoundException {
                        if (!((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                            return MediaActivity.this.onItemLongClick(messageObject, cell, a);
                        }
                        didClickItem(cell, index, messageObject, a);
                        return true;
                    }
                });
                MediaActivity.this.cache.add(sharedPhotoVideoCell);
            } else {
                if (viewType == 3) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 0, MediaActivity.this.dialogId);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                sharedMediaSectionCell = new LoadingCell(this.mContext, AndroidUtilities.dp(32.0f), AndroidUtilities.dp(74.0f));
            }
            return new RecyclerListView.Holder(sharedMediaSectionCell);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 2 || holder.getItemViewType() == 3) {
                return;
            }
            ArrayList<MessageObject> arrayList = MediaActivity.this.sharedMediaData[0].sectionArrays.get(MediaActivity.this.sharedMediaData[0].sections.get(section));
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                ((SharedMediaSectionCell) holder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                return;
            }
            if (itemViewType != 1) {
                return;
            }
            SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) holder.itemView;
            sharedPhotoVideoCell.setItemsCount(MediaActivity.this.columnsCount);
            sharedPhotoVideoCell.setIsFirst(position == 1);
            for (int i = 0; i < MediaActivity.this.columnsCount; i++) {
                int i2 = ((position - 1) * MediaActivity.this.columnsCount) + i;
                if (i2 < arrayList.size()) {
                    MessageObject messageObject = arrayList.get(i2);
                    sharedPhotoVideoCell.setItem(i, MediaActivity.this.sharedMediaData[0].messages.indexOf(messageObject), messageObject);
                    if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                        sharedPhotoVideoCell.setChecked(i, MediaActivity.this.selectedFiles[(messageObject.getDialogId() > MediaActivity.this.dialogId ? 1 : (messageObject.getDialogId() == MediaActivity.this.dialogId ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !MediaActivity.this.scrolling);
                    } else {
                        sharedPhotoVideoCell.setChecked(i, false, !MediaActivity.this.scrolling);
                    }
                } else {
                    sharedPhotoVideoCell.setItem(i, i2, null);
                }
            }
            sharedPhotoVideoCell.requestLayout();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int section, int position) {
            if (MediaActivity.this.sharedMediaData[0].sections.size() == 0 && !MediaActivity.this.sharedMediaData[0].loading) {
                return 3;
            }
            if (section < MediaActivity.this.sharedMediaData[0].sections.size()) {
                return position == 0 ? 0 : 1;
            }
            return 2;
        }

        public int getPositionForIndex(int i) {
            return i / MediaActivity.this.columnsCount;
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

        public MediaSearchAdapter(Context context, int type) {
            this.mContext = context;
            this.currentType = type;
        }

        public void queryServerSearch(final String query, final int max_id, long did) {
            if (DialogObject.isEncryptedDialog(did)) {
                return;
            }
            if (this.reqId != 0) {
                ConnectionsManager.getInstance(((BaseFragment) MediaActivity.this).currentAccount).cancelRequest(this.reqId, true);
                this.reqId = 0;
                this.searchesInProgress--;
            }
            if (query == null || query.length() == 0) {
                this.globalSearch.clear();
                this.lastReqId = 0;
                notifyDataSetChanged();
                return;
            }
            TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
            tLRPC$TL_messages_search.limit = 50;
            tLRPC$TL_messages_search.offset_id = max_id;
            int i = this.currentType;
            if (i == 1) {
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterDocument();
            } else if (i == 3) {
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterUrl();
            } else if (i == 4) {
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterMusic();
            }
            tLRPC$TL_messages_search.q = query;
            TLRPC$InputPeer inputPeer = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getInputPeer(did);
            tLRPC$TL_messages_search.peer = inputPeer;
            if (inputPeer == null) {
                return;
            }
            final int i2 = this.lastReqId + 1;
            this.lastReqId = i2;
            this.searchesInProgress++;
            this.reqId = ConnectionsManager.getInstance(((BaseFragment) MediaActivity.this).currentAccount).sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$MediaSearchAdapter$2zvNqAiEZsWaRHxS3h8JgXPoaAw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$queryServerSearch$1$MediaActivity$MediaSearchAdapter(max_id, i2, tLObject, tLRPC$TL_error);
                }
            }, 2);
            ConnectionsManager.getInstance(((BaseFragment) MediaActivity.this).currentAccount).bindRequestToGuid(this.reqId, ((BaseFragment) MediaActivity.this).classGuid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$queryServerSearch$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$queryServerSearch$1$MediaActivity$MediaSearchAdapter(int i, final int i2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            final ArrayList arrayList = new ArrayList();
            if (tLRPC$TL_error == null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                for (int i3 = 0; i3 < tLRPC$messages_Messages.messages.size(); i3++) {
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i3);
                    if (i == 0 || tLRPC$Message.id <= i) {
                        arrayList.add(new MessageObject(((BaseFragment) MediaActivity.this).currentAccount, tLRPC$Message, false, true));
                    }
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$MediaSearchAdapter$WHtO1q2hUqtmtfioltTdc4NqjeE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$queryServerSearch$0$MediaActivity$MediaSearchAdapter(i2, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$queryServerSearch$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$queryServerSearch$0$MediaActivity$MediaSearchAdapter(int i, ArrayList arrayList) {
            if (this.reqId != 0) {
                if (i == this.lastReqId) {
                    this.globalSearch = arrayList;
                    this.searchesInProgress--;
                    int itemCount = getItemCount();
                    notifyDataSetChanged();
                    for (int i2 = 0; i2 < MediaActivity.this.mediaPages.length; i2++) {
                        if (MediaActivity.this.mediaPages[i2].listView.getAdapter() == this && itemCount == 0 && ((BaseFragment) MediaActivity.this).actionBar.getTranslationY() != 0.0f) {
                            MediaActivity.this.mediaPages[i2].layoutManager.scrollToPositionWithOffset(0, (int) ((BaseFragment) MediaActivity.this).actionBar.getTranslationY());
                        }
                        if (MediaActivity.this.mediaPages[i2].selectedType == this.currentType) {
                            if (this.searchesInProgress == 0 && itemCount == 0) {
                                MediaActivity.this.mediaPages[i2].emptyView.showProgress(false, true);
                            } else if (itemCount == 0) {
                                MediaActivity mediaActivity = MediaActivity.this;
                                mediaActivity.animateItemsEnter(mediaActivity.mediaPages[i2].listView, 0);
                            }
                        }
                    }
                }
                this.reqId = 0;
            }
        }

        public void search(final String query) {
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.searchRunnable = null;
            }
            if (!this.searchResult.isEmpty() || !this.globalSearch.isEmpty() || this.searchesInProgress != 0) {
                this.searchResult.clear();
                this.globalSearch.clear();
                if (this.reqId != 0) {
                    ConnectionsManager.getInstance(((BaseFragment) MediaActivity.this).currentAccount).cancelRequest(this.reqId, true);
                    this.reqId = 0;
                    this.searchesInProgress--;
                }
            }
            notifyDataSetChanged();
            if (TextUtils.isEmpty(query)) {
                return;
            }
            for (int i = 0; i < MediaActivity.this.mediaPages.length; i++) {
                if (MediaActivity.this.mediaPages[i].selectedType == this.currentType) {
                    MediaActivity.this.mediaPages[i].emptyView.showProgress(true, true);
                }
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$MediaSearchAdapter$hgJGrTjWlB5zCHXQhHT5IPk7H-o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$3$MediaActivity$MediaSearchAdapter(query);
                }
            };
            this.searchRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$3$MediaActivity$MediaSearchAdapter(final String str) {
            int i;
            if (!MediaActivity.this.sharedMediaData[this.currentType].messages.isEmpty() && ((i = this.currentType) == 1 || i == 4)) {
                MessageObject messageObject = MediaActivity.this.sharedMediaData[this.currentType].messages.get(MediaActivity.this.sharedMediaData[this.currentType].messages.size() - 1);
                queryServerSearch(str, messageObject.getId(), messageObject.getDialogId());
            } else if (this.currentType == 3) {
                queryServerSearch(str, 0, MediaActivity.this.dialogId);
            }
            int i2 = this.currentType;
            if (i2 == 1 || i2 == 4) {
                final ArrayList arrayList = new ArrayList(MediaActivity.this.sharedMediaData[this.currentType].messages);
                this.searchesInProgress++;
                Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$MediaSearchAdapter$y9i6j7Np949tPSLJNlJziymfukI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$search$2$MediaActivity$MediaSearchAdapter(str, arrayList);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$2$MediaActivity$MediaSearchAdapter(String str, ArrayList arrayList) {
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

        private void updateSearchResults(final ArrayList<MessageObject> documents) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$MediaSearchAdapter$LDcIGxSunGXt7f7buGa9quxX9dM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4$MediaActivity$MediaSearchAdapter(documents);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$4$MediaActivity$MediaSearchAdapter(ArrayList arrayList) {
            if (MediaActivity.this.searching) {
                this.searchesInProgress--;
                this.searchResult = arrayList;
                int itemCount = getItemCount();
                notifyDataSetChanged();
                for (int i = 0; i < MediaActivity.this.mediaPages.length; i++) {
                    if (MediaActivity.this.mediaPages[i].listView.getAdapter() == this && itemCount == 0 && ((BaseFragment) MediaActivity.this).actionBar.getTranslationY() != 0.0f) {
                        MediaActivity.this.mediaPages[i].layoutManager.scrollToPositionWithOffset(0, (int) ((BaseFragment) MediaActivity.this).actionBar.getTranslationY());
                        return;
                    }
                }
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() != this.searchResult.size() + this.globalSearch.size();
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
                sharedDocumentCell = new SharedAudioCell(this.mContext) { // from class: ir.eitaa.ui.MediaActivity.MediaSearchAdapter.1
                    @Override // ir.eitaa.ui.Cells.SharedAudioCell
                    public boolean needPlayMessage(MessageObject messageObject) throws IOException {
                        if (messageObject.isVoice() || messageObject.isRoundVideo()) {
                            boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject);
                            MediaController.getInstance().setVoiceMessagesPlaylist(zPlayMessage ? MediaSearchAdapter.this.searchResult : null, false);
                            if (messageObject.isRoundVideo()) {
                                MediaController.getInstance().setCurrentVideoVisible(false);
                            }
                            return zPlayMessage;
                        }
                        if (messageObject.isMusic()) {
                            return MediaController.getInstance().setPlaylist(MediaSearchAdapter.this.searchResult, messageObject, MediaActivity.this.mergeDialogId);
                        }
                        return false;
                    }
                };
            } else {
                SharedLinkCell sharedLinkCell = new SharedLinkCell(this.mContext);
                sharedLinkCell.setDelegate(MediaActivity.this.sharedLinkCellDelegate);
                sharedDocumentCell = sharedLinkCell;
            }
            return new RecyclerListView.Holder(sharedDocumentCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int i = this.currentType;
            if (i == 1) {
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) holder.itemView;
                MessageObject item = getItem(position);
                sharedDocumentCell.setDocument(item, position != getItemCount() - 1);
                if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                    sharedDocumentCell.setChecked(MediaActivity.this.selectedFiles[(item.getDialogId() > MediaActivity.this.dialogId ? 1 : (item.getDialogId() == MediaActivity.this.dialogId ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item.getId()) >= 0, !MediaActivity.this.scrolling);
                    return;
                } else {
                    sharedDocumentCell.setChecked(false, !MediaActivity.this.scrolling);
                    return;
                }
            }
            if (i == 3) {
                SharedLinkCell sharedLinkCell = (SharedLinkCell) holder.itemView;
                MessageObject item2 = getItem(position);
                sharedLinkCell.setLink(item2, position != getItemCount() - 1);
                if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                    sharedLinkCell.setChecked(MediaActivity.this.selectedFiles[(item2.getDialogId() > MediaActivity.this.dialogId ? 1 : (item2.getDialogId() == MediaActivity.this.dialogId ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item2.getId()) >= 0, !MediaActivity.this.scrolling);
                    return;
                } else {
                    sharedLinkCell.setChecked(false, !MediaActivity.this.scrolling);
                    return;
                }
            }
            if (i == 4) {
                SharedAudioCell sharedAudioCell = (SharedAudioCell) holder.itemView;
                MessageObject item3 = getItem(position);
                sharedAudioCell.setMessageObject(item3, position != getItemCount() - 1);
                if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                    sharedAudioCell.setChecked(MediaActivity.this.selectedFiles[(item3.getDialogId() > MediaActivity.this.dialogId ? 1 : (item3.getDialogId() == MediaActivity.this.dialogId ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item3.getId()) >= 0, !MediaActivity.this.scrolling);
                } else {
                    sharedAudioCell.setChecked(false, !MediaActivity.this.scrolling);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateItemsEnter(final RecyclerListView listView, final int oldItemCount) {
        if (listView == null) {
            return;
        }
        int childCount = listView.getChildCount();
        final View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = listView.getChildAt(i);
            if (childAt instanceof FlickerLoadingView) {
                view = childAt;
            }
        }
        if (view != null) {
            listView.removeView(view);
        }
        listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.MediaActivity.16
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                listView.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount2 = listView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt2 = listView.getChildAt(i2);
                    if (listView.getChildAdapterPosition(childAt2) >= oldItemCount - 1) {
                        childAt2.setAlpha(0.0f);
                        int iMin = (int) ((Math.min(listView.getMeasuredHeight(), Math.max(0, childAt2.getTop())) / listView.getMeasuredHeight()) * 100.0f);
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt2, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                        objectAnimatorOfFloat.setStartDelay(iMin);
                        objectAnimatorOfFloat.setDuration(200L);
                        animatorSet.playTogether(objectAnimatorOfFloat);
                    }
                    View view2 = view;
                    if (view2 != null && view2.getParent() == null) {
                        listView.addView(view);
                        final RecyclerView.LayoutManager layoutManager = listView.getLayoutManager();
                        if (layoutManager != null) {
                            layoutManager.ignoreView(view);
                            View view3 = view;
                            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.ALPHA, view3.getAlpha(), 0.0f);
                            objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.MediaActivity.16.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animation) {
                                    view.setAlpha(1.0f);
                                    layoutManager.stopIgnoringView(view);
                                    AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                                    listView.removeView(view);
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, 0, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "actionBarDefaultSubmenuItemIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionModeBackground, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "sharedMedia_actionMode"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "actionBarDefaultSearch"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "actionBarDefaultSearchPlaceholder"));
        arrayList.add(new ThemeDescription(this.selectedMessagesCountTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, new Class[]{FragmentContextView.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerBackground"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{FragmentContextView.class}, new String[]{"playButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerPlayPause"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerTitle"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_FASTSCROLL, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerPerformer"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{FragmentContextView.class}, new String[]{"closeButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerClose"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "returnToCallBackground"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "returnToCallText"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip, 0, new Class[]{ScrollSlidingTextTabStrip.class}, new String[]{"selectorDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "actionBarTabLine"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, "actionBarTabActiveText"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, "actionBarTabUnactiveText"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{TextView.class}, null, null, null, "actionBarTabSelector"));
        for (final int i = 0; i < this.mediaPages.length; i++) {
            ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MediaActivity$BVQ0FIPRsdf3o83pGfrrEeJSCA4
                @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                public final void didSetColor() {
                    this.f$0.lambda$getThemeDescriptions$5$MediaActivity(i);
                }

                @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                public /* synthetic */ void onAnimationProgress(float f) {
                    ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
                }
            };
            arrayList.add(new ThemeDescription(this.mediaPages[i].emptyView, 0, null, null, null, null, "windowBackgroundGray"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].progressView, 0, null, null, null, null, "windowBackgroundGray"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"dateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{SharedDocumentCell.class}, new String[]{"progressView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_startStopLoadIcon"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"statusImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_startStopLoadIcon"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_folderIcon"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"extTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_iconText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "progressCircle"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_titleTextPaint, null, null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_descriptionTextPaint, null, null, "windowBackgroundWhiteGrayText2"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, 0, new Class[]{SharedLinkCell.class}, new String[]{"titleTextPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, 0, new Class[]{SharedLinkCell.class}, null, null, null, "windowBackgroundWhiteLinkText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, 0, new Class[]{SharedLinkCell.class}, Theme.linkSelectionPaint, null, null, "windowBackgroundWhiteLinkSelection"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, 0, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_linkPlaceholderText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_linkPlaceholder"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, 0, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, 0, new Class[]{SharedPhotoVideoCell.class}, new String[]{"backgroundPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_photoPlaceholder"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedPhotoVideoCell.class}, null, null, themeDescriptionDelegate, "checkbox"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedPhotoVideoCell.class}, null, null, themeDescriptionDelegate, "checkboxCheck"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].listView, 0, null, null, new Drawable[]{this.pinnedHeaderShadowDrawable}, null, "windowBackgroundGrayShadow"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.mediaPages[i].emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText"));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$5$MediaActivity(int i) {
        if (this.mediaPages[i].listView != null) {
            int childCount = this.mediaPages[i].listView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.mediaPages[i].listView.getChildAt(i2);
                if (childAt instanceof SharedPhotoVideoCell) {
                    ((SharedPhotoVideoCell) childAt).updateCheckboxColor();
                }
            }
        }
    }
}
