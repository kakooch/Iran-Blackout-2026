package org.rbmain.ui;

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
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterDocument;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterMusic;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterUrl;
import org.rbmain.tgnet.TLRPC$TL_messages_search;
import org.rbmain.tgnet.TLRPC$TL_webPageEmpty;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.SharedAudioCell;
import org.rbmain.ui.Cells.SharedDocumentCell;
import org.rbmain.ui.Cells.SharedLinkCell;
import org.rbmain.ui.Cells.SharedMediaSectionCell;
import org.rbmain.ui.Cells.SharedPhotoVideoCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.ClippingImageView;
import org.rbmain.ui.Components.EmbedBottomSheet;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.FragmentContextView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberTextView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ScrollSlidingTextTabStrip;
import org.rbmain.ui.Components.SharedMediaLayout;
import org.rbmain.ui.Components.StickerEmptyView;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.PhotoViewer;

/* loaded from: classes4.dex */
public class MediaActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private static final Interpolator interpolator = new Interpolator() { // from class: org.rbmain.ui.MediaActivity$$ExternalSyntheticLambda2
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
    private long dialog_id;
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
    private LongSparseArray<MessageObject>[] selectedFiles;
    private NumberTextView selectedMessagesCountTextView;
    SharedLinkCell.SharedLinkCellDelegate sharedLinkCellDelegate;
    private SharedMediaLayout.SharedMediaData[] sharedMediaData;
    private boolean swipeBackEnabled;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private SharedDocumentsAdapter voiceAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$4(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$0(float f) {
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

    public MediaActivity(Bundle bundle, int[] iArr, SharedMediaLayout.SharedMediaData[] sharedMediaDataArr, int i) {
        TLRPC$ChatFull tLRPC$ChatFull;
        super(bundle);
        this.mediaPages = new MediaPage[2];
        this.cellCache = new ArrayList<>(10);
        this.cache = new ArrayList<>(10);
        this.audioCellCache = new ArrayList<>(10);
        this.audioCache = new ArrayList<>(10);
        this.backgroundPaint = new Paint();
        this.selectedFiles = new LongSparseArray[]{new LongSparseArray<>(), new LongSparseArray<>()};
        this.actionModeViews = new ArrayList<>();
        this.info = null;
        this.columnsCount = 3;
        this.SCROLL_Y = new AnimationProperties.FloatProperty<MediaActivity>("animationValue") { // from class: org.rbmain.ui.MediaActivity.1
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(MediaActivity mediaActivity, float f) {
                mediaActivity.setScrollY(f);
                for (int i2 = 0; i2 < MediaActivity.this.mediaPages.length; i2++) {
                    MediaActivity.this.mediaPages[i2].listView.checkSection(true);
                }
            }

            @Override // android.util.Property
            public Float get(MediaActivity mediaActivity) {
                return Float.valueOf(((BaseFragment) MediaActivity.this).actionBar.getTranslationY());
            }
        };
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: org.rbmain.ui.MediaActivity.2
            /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public org.rbmain.ui.PhotoViewer.PlaceProviderObject getPlaceForPhoto(org.rbmain.messenger.MessageObject r17, org.rbmain.tgnet.TLRPC$FileLocation r18, int r19, boolean r20) {
                /*
                    Method dump skipped, instructions count: 395
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.MediaActivity.AnonymousClass2.getPlaceForPhoto(org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$FileLocation, int, boolean):org.rbmain.ui.PhotoViewer$PlaceProviderObject");
            }
        };
        this.sharedMediaData = new SharedMediaLayout.SharedMediaData[6];
        this.sharedLinkCellDelegate = new AnonymousClass15();
        this.hasMedia = iArr;
        this.initialTab = i;
        this.dialog_id = bundle.getLong("dialog_id", 0L);
        int i2 = 0;
        while (true) {
            SharedMediaLayout.SharedMediaData[] sharedMediaDataArr2 = this.sharedMediaData;
            if (i2 >= sharedMediaDataArr2.length) {
                return;
            }
            sharedMediaDataArr2[i2] = new SharedMediaLayout.SharedMediaData();
            SharedMediaLayout.SharedMediaData[] sharedMediaDataArr3 = this.sharedMediaData;
            sharedMediaDataArr3[i2].max_id[0] = ((int) this.dialog_id) == 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
            if (this.mergeDialogId != 0 && (tLRPC$ChatFull = this.info) != null) {
                sharedMediaDataArr3[i2].max_id[1] = tLRPC$ChatFull.migrated_from_max_id;
                sharedMediaDataArr3[i2].endReached[1] = false;
            }
            if (sharedMediaDataArr != null) {
                sharedMediaDataArr3[i2].totalCount = sharedMediaDataArr[i2].totalCount;
                sharedMediaDataArr3[i2].messages.addAll(sharedMediaDataArr[i2].messages);
                this.sharedMediaData[i2].sections.addAll(sharedMediaDataArr[i2].sections);
                for (Map.Entry<String, ArrayList<MessageObject>> entry : sharedMediaDataArr[i2].sectionArrays.entrySet()) {
                    this.sharedMediaData[i2].sectionArrays.put(entry.getKey(), new ArrayList<>(entry.getValue()));
                }
                for (int i3 = 0; i3 < 2; i3++) {
                    SharedMediaLayout.SharedMediaData[] sharedMediaDataArr4 = this.sharedMediaData;
                    sharedMediaDataArr4[i2].endReached[i3] = sharedMediaDataArr[i2].endReached[i3];
                    sharedMediaDataArr4[i2].messagesDict[i3] = sharedMediaDataArr[i2].messagesDict[i3].m132clone();
                    this.sharedMediaData[i2].max_id[i3] = sharedMediaDataArr[i2].max_id[i3];
                }
            }
            i2++;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mediaDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) throws Resources.NotFoundException {
        TLRPC$User user;
        int i;
        int i2;
        for (int i3 = 0; i3 < 10; i3++) {
            this.cellCache.add(new SharedPhotoVideoCell(context));
            if (this.initialTab == 4) {
                SharedAudioCell sharedAudioCell = new SharedAudioCell(context) { // from class: org.rbmain.ui.MediaActivity.3
                    @Override // org.rbmain.ui.Cells.SharedAudioCell
                    public boolean needPlayMessage(MessageObject messageObject) {
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
        int i4 = (int) this.dialog_id;
        if (i4 == 0) {
            TLRPC$EncryptedChat encryptedChat = MessagesController.getInstance(this.currentAccount).getEncryptedChat(Integer.valueOf((int) (this.dialog_id >> 32)));
            if (encryptedChat != null && (user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(encryptedChat.user_id))) != null) {
                this.actionBar.setTitle(ContactsController.formatName(user.first_name, user.last_name));
            }
        } else if (i4 > 0) {
            TLRPC$User user2 = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(i4));
            if (user2 != null) {
                if (user2.self) {
                    this.actionBar.setTitle(LocaleController.getString("SavedMessages", R.string.SavedMessages));
                } else {
                    this.actionBar.setTitle(ContactsController.formatName(user2.first_name, user2.last_name));
                }
            }
        } else {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(-i4));
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
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundGrayShadow), PorterDuff.Mode.MULTIPLY));
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (scrollSlidingTextTabStrip != null) {
            this.initialTab = scrollSlidingTextTabStrip.getCurrentTabId();
        }
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip2 = new ScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = scrollSlidingTextTabStrip2;
        int i5 = this.initialTab;
        int i6 = -1;
        if (i5 != -1) {
            scrollSlidingTextTabStrip2.setInitialTabId(i5);
            this.initialTab = -1;
        }
        this.actionBar.addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: org.rbmain.ui.MediaActivity.5
            @Override // org.rbmain.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public /* synthetic */ void onSamePageSelected() {
                ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate.CC.$default$onSamePageSelected(this);
            }

            @Override // org.rbmain.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i7, boolean z) {
                if (MediaActivity.this.mediaPages[0].selectedType == i7) {
                    return;
                }
                MediaActivity mediaActivity = MediaActivity.this;
                mediaActivity.swipeBackEnabled = i7 == mediaActivity.scrollSlidingTextTabStrip.getFirstTabId();
                MediaActivity.this.mediaPages[1].selectedType = i7;
                MediaActivity.this.mediaPages[1].setVisibility(0);
                MediaActivity.this.switchToCurrentSelectedMode(true);
                MediaActivity.this.animatingForward = z;
            }

            @Override // org.rbmain.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float f) {
                if (f != 1.0f || MediaActivity.this.mediaPages[1].getVisibility() == 0) {
                    if (MediaActivity.this.animatingForward) {
                        MediaActivity.this.mediaPages[0].setTranslationX((-f) * MediaActivity.this.mediaPages[0].getMeasuredWidth());
                        MediaActivity.this.mediaPages[1].setTranslationX(MediaActivity.this.mediaPages[0].getMeasuredWidth() - (MediaActivity.this.mediaPages[0].getMeasuredWidth() * f));
                    } else {
                        MediaActivity.this.mediaPages[0].setTranslationX(MediaActivity.this.mediaPages[0].getMeasuredWidth() * f);
                        MediaActivity.this.mediaPages[1].setTranslationX((MediaActivity.this.mediaPages[0].getMeasuredWidth() * f) - MediaActivity.this.mediaPages[0].getMeasuredWidth());
                    }
                    if (MediaActivity.this.searchItemState == 1) {
                        MediaActivity.this.searchItem.setAlpha(f);
                    } else if (MediaActivity.this.searchItemState == 2) {
                        MediaActivity.this.searchItem.setAlpha(1.0f - f);
                    }
                    if (f == 1.0f) {
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
        for (int i7 = 1; i7 >= 0; i7--) {
            this.selectedFiles[i7].clear();
        }
        this.cantDeleteMessagesCount = 0;
        this.actionModeViews.clear();
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: org.rbmain.ui.MediaActivity.6
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                MediaActivity.this.searching = true;
                MediaActivity.this.resetScroll();
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
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

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
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
        ActionBar actionBar = this.actionBar;
        int i8 = Theme.key_actionBarDefaultIcon;
        actionBar.setItemsColor(Theme.getColor(i8), true);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarDefaultSelector), true);
        View view = new View(context);
        this.actionModeBackground = view;
        view.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.actionModeBackground.setAlpha(0.0f);
        ActionBar actionBar2 = this.actionBar;
        actionBar2.addView(this.actionModeBackground, actionBar2.indexOfChild(actionBarMenuCreateActionMode));
        NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
        this.selectedMessagesCountTextView = numberTextView;
        numberTextView.setTextSize(18);
        this.selectedMessagesCountTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.selectedMessagesCountTextView.setTextColor(Theme.getColor(i8));
        this.selectedMessagesCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.MediaActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return MediaActivity.lambda$createView$1(view2, motionEvent);
            }
        });
        actionBarMenuCreateActionMode.addView(this.selectedMessagesCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
        if (((int) this.dialog_id) != 0) {
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
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.MediaActivity.7
            private boolean globalIgnoreLayout;
            private boolean maybeStartTracking;
            private boolean startedTracking;
            private int startedTrackingPointerId;
            private int startedTrackingX;
            private int startedTrackingY;
            private VelocityTracker velocityTracker;

            private boolean prepareForMoving(MotionEvent motionEvent, boolean z) {
                int nextPageId = MediaActivity.this.scrollSlidingTextTabStrip.getNextPageId(z);
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
                this.startedTrackingX = (int) motionEvent.getX();
                ((BaseFragment) MediaActivity.this).actionBar.setEnabled(false);
                MediaActivity.this.scrollSlidingTextTabStrip.setEnabled(false);
                MediaActivity.this.mediaPages[1].selectedType = nextPageId;
                MediaActivity.this.mediaPages[1].setVisibility(0);
                MediaActivity.this.animatingForward = z;
                MediaActivity.this.switchToCurrentSelectedMode(true);
                if (z) {
                    MediaActivity.this.mediaPages[1].setTranslationX(MediaActivity.this.mediaPages[0].getMeasuredWidth());
                } else {
                    MediaActivity.this.mediaPages[1].setTranslationX(-MediaActivity.this.mediaPages[0].getMeasuredWidth());
                }
                return true;
            }

            @Override // android.view.View
            public void forceHasOverlappingRendering(boolean z) {
                super.forceHasOverlappingRendering(z);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i9, int i10) {
                setMeasuredDimension(View.MeasureSpec.getSize(i9), View.MeasureSpec.getSize(i10));
                measureChildWithMargins(((BaseFragment) MediaActivity.this).actionBar, i9, 0, i10, 0);
                int measuredHeight = ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight();
                this.globalIgnoreLayout = true;
                for (int i11 = 0; i11 < MediaActivity.this.mediaPages.length; i11++) {
                    if (MediaActivity.this.mediaPages[i11] != null) {
                        if (MediaActivity.this.mediaPages[i11].listView != null) {
                            MediaActivity.this.mediaPages[i11].listView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, AndroidUtilities.dp(4.0f));
                        }
                        if (MediaActivity.this.mediaPages[i11].emptyView != null) {
                            MediaActivity.this.mediaPages[i11].emptyView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, 0);
                        }
                        if (MediaActivity.this.mediaPages[i11].progressView != null) {
                            MediaActivity.this.mediaPages[i11].progressView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, 0);
                        }
                    }
                }
                this.globalIgnoreLayout = false;
                int childCount = getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (childAt != null && childAt.getVisibility() != 8 && childAt != ((BaseFragment) MediaActivity.this).actionBar) {
                        measureChildWithMargins(childAt, i9, 0, i10, 0);
                    }
                }
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i9, int i10, int i11, int i12) {
                super.onLayout(z, i9, i10, i11, i12);
                if (MediaActivity.this.fragmentContextView != null) {
                    int measuredHeight = ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight();
                    MediaActivity.this.fragmentContextView.layout(MediaActivity.this.fragmentContextView.getLeft(), MediaActivity.this.fragmentContextView.getTop() + measuredHeight, MediaActivity.this.fragmentContextView.getRight(), MediaActivity.this.fragmentContextView.getBottom() + measuredHeight);
                }
            }

            @Override // android.view.View
            public void setPadding(int i9, int i10, int i11, int i12) {
                MediaActivity.this.additionalPadding = i10;
                if (MediaActivity.this.fragmentContextView != null) {
                    MediaActivity.this.fragmentContextView.setTranslationY(i10 + ((BaseFragment) MediaActivity.this).actionBar.getTranslationY());
                }
                int measuredHeight = ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight();
                for (int i13 = 0; i13 < MediaActivity.this.mediaPages.length; i13++) {
                    if (MediaActivity.this.mediaPages[i13] != null) {
                        if (MediaActivity.this.mediaPages[i13].emptyView != null) {
                            MediaActivity.this.mediaPages[i13].emptyView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, 0);
                        }
                        if (MediaActivity.this.mediaPages[i13].progressView != null) {
                            MediaActivity.this.mediaPages[i13].progressView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, 0);
                        }
                        if (MediaActivity.this.mediaPages[i13].listView != null) {
                            MediaActivity.this.mediaPages[i13].listView.setPadding(0, MediaActivity.this.additionalPadding + measuredHeight, 0, AndroidUtilities.dp(4.0f));
                            MediaActivity.this.mediaPages[i13].listView.checkSection(true);
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
            protected boolean drawChild(Canvas canvas, View view2, long j) {
                if (view2 == MediaActivity.this.fragmentContextView && MediaActivity.this.fragmentContextView.isCallStyle()) {
                    return true;
                }
                return super.drawChild(canvas, view2, j);
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
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    boolean r0 = org.rbmain.ui.MediaActivity.access$5900(r0)
                    r1 = 0
                    if (r0 == 0) goto Lc3
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    boolean r0 = org.rbmain.ui.MediaActivity.access$6000(r0)
                    r2 = -1
                    r3 = 0
                    r4 = 1065353216(0x3f800000, float:1.0)
                    r5 = 1
                    if (r0 == 0) goto L59
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity$MediaPage[] r0 = org.rbmain.ui.MediaActivity.access$100(r0)
                    r0 = r0[r1]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity$MediaPage[] r0 = org.rbmain.ui.MediaActivity.access$100(r0)
                    r0 = r0[r1]
                    r0.setTranslationX(r3)
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity$MediaPage[] r0 = org.rbmain.ui.MediaActivity.access$100(r0)
                    r0 = r0[r5]
                    org.rbmain.ui.MediaActivity r3 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity$MediaPage[] r3 = org.rbmain.ui.MediaActivity.access$100(r3)
                    r3 = r3[r1]
                    int r3 = r3.getMeasuredWidth()
                    org.rbmain.ui.MediaActivity r4 = org.rbmain.ui.MediaActivity.this
                    boolean r4 = org.rbmain.ui.MediaActivity.access$3400(r4)
                    if (r4 == 0) goto L52
                    r2 = 1
                L52:
                    int r3 = r3 * r2
                    float r2 = (float) r3
                    r0.setTranslationX(r2)
                    goto L9e
                L59:
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity$MediaPage[] r0 = org.rbmain.ui.MediaActivity.access$100(r0)
                    r0 = r0[r5]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity$MediaPage[] r0 = org.rbmain.ui.MediaActivity.access$100(r0)
                    r0 = r0[r1]
                    org.rbmain.ui.MediaActivity r4 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity$MediaPage[] r4 = org.rbmain.ui.MediaActivity.access$100(r4)
                    r4 = r4[r1]
                    int r4 = r4.getMeasuredWidth()
                    org.rbmain.ui.MediaActivity r6 = org.rbmain.ui.MediaActivity.this
                    boolean r6 = org.rbmain.ui.MediaActivity.access$3400(r6)
                    if (r6 == 0) goto L8a
                    goto L8b
                L8a:
                    r2 = 1
                L8b:
                    int r4 = r4 * r2
                    float r2 = (float) r4
                    r0.setTranslationX(r2)
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity$MediaPage[] r0 = org.rbmain.ui.MediaActivity.access$100(r0)
                    r0 = r0[r5]
                    r0.setTranslationX(r3)
                    goto L9e
                L9d:
                    r5 = 0
                L9e:
                    if (r5 == 0) goto Lbc
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    android.animation.AnimatorSet r0 = org.rbmain.ui.MediaActivity.access$6100(r0)
                    if (r0 == 0) goto Lb7
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    android.animation.AnimatorSet r0 = org.rbmain.ui.MediaActivity.access$6100(r0)
                    r0.cancel()
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    r2 = 0
                    org.rbmain.ui.MediaActivity.access$6102(r0, r2)
                Lb7:
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    org.rbmain.ui.MediaActivity.access$5902(r0, r1)
                Lbc:
                    org.rbmain.ui.MediaActivity r0 = org.rbmain.ui.MediaActivity.this
                    boolean r0 = org.rbmain.ui.MediaActivity.access$5900(r0)
                    return r0
                Lc3:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.MediaActivity.AnonymousClass7.checkTabsAnimationInProgress():boolean");
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return checkTabsAnimationInProgress() || MediaActivity.this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(motionEvent);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                MediaActivity.this.backgroundPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                canvas.drawRect(0.0f, ((BaseFragment) MediaActivity.this).actionBar.getMeasuredHeight() + ((BaseFragment) MediaActivity.this).actionBar.getTranslationY(), getMeasuredWidth(), getMeasuredHeight(), MediaActivity.this.backgroundPaint);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                float xVelocity;
                float yVelocity;
                float measuredWidth;
                int measuredWidth2;
                if (((BaseFragment) MediaActivity.this).parentLayout.checkTransitionAnimation() || checkTabsAnimationInProgress()) {
                    return false;
                }
                if (motionEvent != null) {
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    this.velocityTracker.addMovement(motionEvent);
                }
                if (motionEvent != null && motionEvent.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking) {
                    this.startedTrackingPointerId = motionEvent.getPointerId(0);
                    this.maybeStartTracking = true;
                    this.startedTrackingX = (int) motionEvent.getX();
                    this.startedTrackingY = (int) motionEvent.getY();
                    this.velocityTracker.clear();
                } else if (motionEvent != null && motionEvent.getAction() == 2 && motionEvent.getPointerId(0) == this.startedTrackingPointerId) {
                    int x = (int) (motionEvent.getX() - this.startedTrackingX);
                    int iAbs = Math.abs(((int) motionEvent.getY()) - this.startedTrackingY);
                    if (this.startedTracking && ((MediaActivity.this.animatingForward && x > 0) || (!MediaActivity.this.animatingForward && x < 0))) {
                        if (!prepareForMoving(motionEvent, x < 0)) {
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
                        prepareForMoving(motionEvent, x < 0);
                    }
                } else if (motionEvent == null || (motionEvent.getPointerId(0) == this.startedTrackingPointerId && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6))) {
                    this.velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE, MediaActivity.this.maximumVelocity);
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
                        MediaActivity.this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.MediaActivity.7.1
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
        int i9 = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i9 >= mediaPageArr.length) {
                break;
            }
            if (i9 != 0 || mediaPageArr[i9] == null || mediaPageArr[i9].layoutManager == null) {
                i = iFindFirstVisibleItemPosition;
                i2 = top;
            } else {
                iFindFirstVisibleItemPosition = this.mediaPages[i9].layoutManager.findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition != this.mediaPages[i9].layoutManager.getItemCount() - 1) {
                    RecyclerListView.Holder holder = (RecyclerListView.Holder) this.mediaPages[i9].listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
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
            final MediaPage mediaPage = new MediaPage(context) { // from class: org.rbmain.ui.MediaActivity.8
                @Override // android.view.View
                public void setTranslationX(float f) {
                    super.setTranslationX(f);
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
            frameLayout.addView(mediaPage, LayoutHelper.createFrame(i6, -1.0f));
            MediaPage[] mediaPageArr2 = this.mediaPages;
            mediaPageArr2[i9] = mediaPage;
            int i10 = i2;
            final LinearLayoutManager linearLayoutManager = mediaPageArr2[i9].layoutManager = new LinearLayoutManager(context, 1, false) { // from class: org.rbmain.ui.MediaActivity.9
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean supportsPredictiveItemAnimations() {
                    return false;
                }

                @Override // androidx.recyclerview.widget.LinearLayoutManager
                protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
                    super.calculateExtraLayoutSpace(state, iArr);
                    if (mediaPage.selectedType == 0) {
                        iArr[1] = Math.max(iArr[1], SharedPhotoVideoCell.getItemSize(MediaActivity.this.columnsCount) * 2);
                    } else if (mediaPage.selectedType == 1) {
                        iArr[1] = Math.max(iArr[1], AndroidUtilities.dp(56.0f) * 2);
                    }
                }
            };
            this.mediaPages[i9].listView = new RecyclerListView(context) { // from class: org.rbmain.ui.MediaActivity.10
                @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean z, int i11, int i12, int i13, int i14) {
                    super.onLayout(z, i11, i12, i13, i14);
                    MediaActivity.this.updateSections(this, true);
                }
            };
            this.mediaPages[i9].listView.setScrollingTouchSlop(1);
            this.mediaPages[i9].listView.setItemAnimator(null);
            this.mediaPages[i9].listView.setClipToPadding(false);
            this.mediaPages[i9].listView.setSectionsType(2);
            this.mediaPages[i9].listView.setLayoutManager(linearLayoutManager);
            MediaPage[] mediaPageArr3 = this.mediaPages;
            mediaPageArr3[i9].addView(mediaPageArr3[i9].listView, LayoutHelper.createFrame(-1, -1.0f));
            this.mediaPages[i9].listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.MediaActivity$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view2, int i11) {
                    this.f$0.lambda$createView$2(mediaPage, view2, i11);
                }
            });
            this.mediaPages[i9].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.MediaActivity.11
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
                    if (i11 == 1) {
                        AndroidUtilities.hideKeyboard(MediaActivity.this.getParentActivity().getCurrentFocus());
                    }
                    MediaActivity.this.scrolling = i11 != 0;
                    if (i11 != 1) {
                        int i12 = (int) (-((BaseFragment) MediaActivity.this).actionBar.getTranslationY());
                        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
                        if (i12 == 0 || i12 == currentActionBarHeight) {
                            return;
                        }
                        if (i12 < currentActionBarHeight / 2) {
                            MediaActivity.this.mediaPages[0].listView.smoothScrollBy(0, -i12);
                        } else if (MediaActivity.this.mediaPages[0].listView.canScrollVertically(1)) {
                            MediaActivity.this.mediaPages[0].listView.smoothScrollBy(0, currentActionBarHeight - i12);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                    int i13;
                    if (MediaActivity.this.searching && MediaActivity.this.searchWas) {
                        return;
                    }
                    int iFindFirstVisibleItemPosition2 = linearLayoutManager.findFirstVisibleItemPosition();
                    int iAbs = iFindFirstVisibleItemPosition2 == -1 ? 0 : Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition2) + 1;
                    int itemCount = recyclerView.getAdapter().getItemCount();
                    int i14 = mediaPage.selectedType == 0 ? 3 : 6;
                    if (iAbs != 0 && iFindFirstVisibleItemPosition2 + iAbs > itemCount - i14 && !MediaActivity.this.sharedMediaData[mediaPage.selectedType].loading) {
                        if (mediaPage.selectedType == 0) {
                            i13 = 0;
                        } else if (mediaPage.selectedType == 1) {
                            i13 = 1;
                        } else if (mediaPage.selectedType == 2) {
                            i13 = 2;
                        } else if (mediaPage.selectedType == 4) {
                            i13 = 4;
                        } else {
                            i13 = mediaPage.selectedType == 5 ? 5 : 3;
                        }
                        if (!MediaActivity.this.sharedMediaData[mediaPage.selectedType].endReached[0]) {
                            MediaActivity.this.sharedMediaData[mediaPage.selectedType].loading = true;
                            MediaDataController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).loadMedia(MediaActivity.this.dialog_id, 50, MediaActivity.this.sharedMediaData[mediaPage.selectedType].max_id[0], i13, 1, ((BaseFragment) MediaActivity.this).classGuid);
                        } else if (MediaActivity.this.mergeDialogId != 0 && !MediaActivity.this.sharedMediaData[mediaPage.selectedType].endReached[1]) {
                            MediaActivity.this.sharedMediaData[mediaPage.selectedType].loading = true;
                            MediaDataController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).loadMedia(MediaActivity.this.mergeDialogId, 50, MediaActivity.this.sharedMediaData[mediaPage.selectedType].max_id[1], i13, 1, ((BaseFragment) MediaActivity.this).classGuid);
                        }
                    }
                    if (recyclerView == MediaActivity.this.mediaPages[0].listView && !MediaActivity.this.searching && !((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed() && !MediaActivity.this.disableActionBarScrolling) {
                        float translationY = ((BaseFragment) MediaActivity.this).actionBar.getTranslationY();
                        float f = translationY - i12;
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
            this.mediaPages[i9].listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.MediaActivity$$ExternalSyntheticLambda5
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
                public final boolean onItemClick(View view2, int i11) {
                    return this.f$0.lambda$createView$3(mediaPage, view2, i11);
                }
            });
            if (i9 != 0 || i == -1) {
                top = i10;
            } else {
                top = i10;
                linearLayoutManager.scrollToPositionWithOffset(i, top);
            }
            final RecyclerListView recyclerListView = this.mediaPages[i9].listView;
            this.mediaPages[i9].animatingImageView = new ClippingImageView(this, context) { // from class: org.rbmain.ui.MediaActivity.12
                @Override // android.view.View
                public void invalidate() {
                    super.invalidate();
                    recyclerListView.invalidate();
                }
            };
            this.mediaPages[i9].animatingImageView.setVisibility(8);
            this.mediaPages[i9].listView.addOverlayView(this.mediaPages[i9].animatingImageView, LayoutHelper.createFrame(-1, -1.0f));
            this.mediaPages[i9].progressView = new FlickerLoadingView(context) { // from class: org.rbmain.ui.MediaActivity.13
                @Override // org.rbmain.ui.Components.FlickerLoadingView
                public int getColumnsCount() {
                    return MediaActivity.this.columnsCount;
                }

                @Override // org.rbmain.ui.Components.FlickerLoadingView
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

                @Override // org.rbmain.ui.Components.FlickerLoadingView, android.view.View
                protected void onDraw(Canvas canvas) {
                    MediaActivity.this.backgroundPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), MediaActivity.this.backgroundPaint);
                    super.onDraw(canvas);
                }
            };
            this.mediaPages[i9].progressView.setUseHeaderOffset(true);
            this.mediaPages[i9].progressView.showDate(false);
            if (i9 != 0) {
                this.mediaPages[i9].setVisibility(8);
            }
            this.mediaPages[i9].emptyView = new StickerEmptyView(context, this.mediaPages[i9].progressView, 1);
            this.mediaPages[i9].emptyView.setVisibility(8);
            this.mediaPages[i9].emptyView.setAnimateLayoutChange(true);
            MediaPage[] mediaPageArr4 = this.mediaPages;
            mediaPageArr4[i9].addView(mediaPageArr4[i9].emptyView, LayoutHelper.createFrame(-1, -1.0f));
            this.mediaPages[i9].emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.MediaActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return MediaActivity.lambda$createView$4(view2, motionEvent);
                }
            });
            this.mediaPages[i9].emptyView.showProgress(true, false);
            this.mediaPages[i9].emptyView.title.setText(LocaleController.getString("NoResult", R.string.NoResult));
            this.mediaPages[i9].emptyView.subtitle.setText(LocaleController.getString("SearchEmptyViewFilteredSubtitle2", R.string.SearchEmptyViewFilteredSubtitle2));
            this.mediaPages[i9].emptyView.addView(this.mediaPages[i9].progressView, LayoutHelper.createFrame(-1, -1.0f));
            this.mediaPages[i9].listView.setEmptyView(this.mediaPages[i9].emptyView);
            this.mediaPages[i9].listView.setAnimateEmptyView(true, 0);
            i9++;
            iFindFirstVisibleItemPosition = i;
            i6 = -1;
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

    /* renamed from: org.rbmain.ui.MediaActivity$4, reason: invalid class name */
    class AnonymousClass4 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass4() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) {
            TLRPC$User user;
            TLRPC$Chat chat;
            TLRPC$EncryptedChat encryptedChat;
            if (i == -1) {
                if (MediaActivity.this.closeActionMode()) {
                    return;
                }
                MediaActivity.this.finishFragment();
                return;
            }
            if (i == 4) {
                int i2 = (int) MediaActivity.this.dialog_id;
                if (i2 == 0) {
                    user = null;
                    chat = null;
                    encryptedChat = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getEncryptedChat(Integer.valueOf((int) (MediaActivity.this.dialog_id >> 32)));
                } else if (i2 > 0) {
                    chat = null;
                    encryptedChat = null;
                    user = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getUser(Integer.valueOf(i2));
                } else {
                    user = null;
                    encryptedChat = null;
                    chat = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getChat(Integer.valueOf(-i2));
                }
                MediaActivity mediaActivity = MediaActivity.this;
                AlertsCreator.createDeleteMessagesAlert(mediaActivity, user, chat, encryptedChat, null, mediaActivity.mergeDialogId, null, MediaActivity.this.selectedFiles, null, false, 1, new Runnable() { // from class: org.rbmain.ui.MediaActivity$4$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onItemClick$0();
                    }
                }, null);
                return;
            }
            if (i != 3) {
                if (i == 7 && MediaActivity.this.selectedFiles[0].size() == 1) {
                    Bundle bundle = new Bundle();
                    int i3 = (int) MediaActivity.this.dialog_id;
                    int i4 = (int) (MediaActivity.this.dialog_id >> 32);
                    if (i3 == 0) {
                        bundle.putInt("enc_id", i4);
                    } else if (i3 > 0) {
                        bundle.putInt("user_id", i3);
                    } else if (i3 < 0) {
                        TLRPC$Chat chat2 = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getChat(Integer.valueOf(-i3));
                        if (chat2 != null && chat2.migrated_to != null) {
                            bundle.putInt("migrated_to", i3);
                            i3 = -chat2.migrated_to.channel_id;
                        }
                        bundle.putInt("chat_id", -i3);
                    }
                    bundle.putLong("message_id", MediaActivity.this.selectedFiles[0].keyAt(0));
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
            dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: org.rbmain.ui.MediaActivity$4$$ExternalSyntheticLambda1
                @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                    this.f$0.lambda$onItemClick$1(dialogsActivity2, arrayList, charSequence, z);
                }
            });
            MediaActivity.this.presentFragment(dialogsActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            ((BaseFragment) MediaActivity.this).actionBar.hideActionMode();
            ((BaseFragment) MediaActivity.this).actionBar.closeSearchField();
            MediaActivity.this.cantDeleteMessagesCount = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
            ArrayList<MessageObject> arrayList2 = new ArrayList<>();
            int i = 1;
            while (true) {
                if (i < 0) {
                    break;
                }
                ArrayList arrayList3 = new ArrayList();
                for (int i2 = 0; i2 < MediaActivity.this.selectedFiles[i].size(); i2++) {
                    arrayList3.add(Long.valueOf(MediaActivity.this.selectedFiles[i].keyAt(i2)));
                }
                Collections.sort(arrayList3);
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    Long l = (Long) it.next();
                    if (l.longValue() > 0) {
                        arrayList2.add((MessageObject) MediaActivity.this.selectedFiles[i].get(l.longValue()));
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
                        SendMessagesHelper.getInstance(((BaseFragment) MediaActivity.this).currentAccount).sendMessage(charSequence.toString(), jLongValue, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                    }
                    SendMessagesHelper.getInstance(((BaseFragment) MediaActivity.this).currentAccount).sendMessage(arrayList2, jLongValue, true, 0);
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
            } else if (i4 < 0) {
                bundle.putInt("chat_id", -i4);
            }
            if (i4 == 0 || MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).checkCanOpenChat(bundle, dialogsActivity)) {
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
    public /* synthetic */ void lambda$createView$2(MediaPage mediaPage, View view, int i) {
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
    public /* synthetic */ boolean lambda$createView$3(MediaPage mediaPage, View view, int i) {
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
    public void setScrollY(float f) {
        this.actionBar.setTranslationY(f);
        FragmentContextView fragmentContextView = this.fragmentContextView;
        if (fragmentContextView != null) {
            fragmentContextView.setTranslationY(this.additionalPadding + f);
        }
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i < mediaPageArr.length) {
                mediaPageArr[i].listView.setPinnedSectionOffsetY((int) f);
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b0  */
    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r23, int r24, java.lang.Object... r25) {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.MediaActivity.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent motionEvent) {
        return this.swipeBackEnabled;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                return;
            }
            if (mediaPageArr[i].listView != null) {
                this.mediaPages[i].listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.MediaActivity.14
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return this.actionBar.isEnabled() && !closeActionMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSections(RecyclerView recyclerView, boolean z) {
        int childCount = recyclerView.getChildCount();
        float paddingTop = recyclerView.getPaddingTop() + this.actionBar.getTranslationY();
        View view = null;
        int iMax = 0;
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
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
        if (z) {
            if (iMax != 0 && iMax < recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom()) {
                resetScroll();
            } else {
                if (iMin == Integer.MAX_VALUE || iMin <= recyclerView.getPaddingTop() + this.actionBar.getTranslationY()) {
                    return;
                }
                scrollWithoutActionBar(recyclerView, -recyclerView.computeVerticalScrollOffset());
                resetScroll();
            }
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
            SharedMediaLayout.SharedMediaData[] sharedMediaDataArr = this.sharedMediaData;
            if (i2 >= sharedMediaDataArr.length) {
                return;
            }
            sharedMediaDataArr[i2].max_id[1] = this.info.migrated_from_max_id;
            sharedMediaDataArr[i2].endReached[1] = false;
            i2++;
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

    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateTabs() {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.MediaActivity.updateTabs():void");
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
                MediaDataController.getInstance(this.currentAccount).loadMedia(this.dialog_id, 50, 0L, this.mediaPages[z ? 1 : 0].selectedType, 1, this.classGuid);
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
    public boolean onItemLongClick(MessageObject messageObject, View view, int i) {
        if (this.actionBar.isActionModeShowed() || getParentActivity() == null) {
            return false;
        }
        AndroidUtilities.hideKeyboard(getParentActivity().getCurrentFocus());
        this.selectedFiles[messageObject.getDialogId() == this.dialog_id ? (char) 0 : (char) 1].put(messageObject.getId(), messageObject);
        if (!messageObject.canDeleteMessage(false, null)) {
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
        }
        if (!this.actionBar.isActionModeShowed()) {
            this.actionBar.showActionMode(true, null, this.actionModeBackground, null, null, null, 0);
            resetScroll();
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
        if (this.actionBar.isActionModeShowed()) {
            char c = messageObject.getDialogId() == this.dialog_id ? (char) 0 : (char) 1;
            if (this.selectedFiles[c].indexOfKey(messageObject.getId()) >= 0) {
                this.selectedFiles[c].remove(messageObject.getId());
                if (!messageObject.canDeleteMessage(false, null)) {
                    this.cantDeleteMessagesCount--;
                }
            } else {
                if (this.selectedFiles[0].size() + this.selectedFiles[1].size() >= 100) {
                    return;
                }
                this.selectedFiles[c].put(messageObject.getId(), messageObject);
                if (!messageObject.canDeleteMessage(false, null)) {
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
            } else {
                if (view instanceof SharedAudioCell) {
                    ((SharedAudioCell) view).setChecked(this.selectedFiles[c].indexOfKey(messageObject.getId()) >= 0, true);
                    return;
                }
                return;
            }
        }
        if (i3 == 0) {
            PhotoViewer.getInstance().setParentActivity(getParentActivity());
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
        if (i3 == 1) {
            if (view instanceof SharedDocumentCell) {
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) view;
                TLRPC$Document document = messageObject.getDocument();
                if (sharedDocumentCell.isLoaded()) {
                    if (messageObject.canPreviewDocument()) {
                        PhotoViewer.getInstance().setParentActivity(getParentActivity());
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
                    AndroidUtilities.openDocument(messageObject, getParentActivity(), this);
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
        if (i3 == 3) {
            try {
                TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
                TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia != null ? tLRPC$MessageMedia.webpage : null;
                if (tLRPC$WebPage != null && !(tLRPC$WebPage instanceof TLRPC$TL_webPageEmpty)) {
                    if (tLRPC$WebPage.cached_page != null) {
                        ArticleViewer.getInstance().setParentActivity(getParentActivity(), this);
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
            AlertsCreator.showOpenUrlAlert(this, str, true, true);
        } else {
            Browser.openUrl(getParentActivity(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebView(TLRPC$WebPage tLRPC$WebPage) {
        EmbedBottomSheet.show(getParentActivity(), tLRPC$WebPage.site_name, tLRPC$WebPage.description, tLRPC$WebPage.url, tLRPC$WebPage.embed_url, tLRPC$WebPage.embed_width, tLRPC$WebPage.embed_height, false);
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
    public void scrollWithoutActionBar(RecyclerView recyclerView, int i) {
        this.disableActionBarScrolling = true;
        recyclerView.scrollBy(0, i);
        this.disableActionBarScrolling = false;
    }

    /* renamed from: org.rbmain.ui.MediaActivity$15, reason: invalid class name */
    class AnonymousClass15 implements SharedLinkCell.SharedLinkCellDelegate {
        AnonymousClass15() {
        }

        @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public void needOpenWebView(TLRPC$WebPage tLRPC$WebPage) {
            MediaActivity.this.openWebView(tLRPC$WebPage);
        }

        @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public boolean canPerformActions() {
            return !((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed();
        }

        @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
        public void onLinkPress(final String str, boolean z) {
            if (!z) {
                MediaActivity.this.openUrl(str);
                return;
            }
            BottomSheet.Builder builder = new BottomSheet.Builder(MediaActivity.this.getParentActivity());
            builder.setTitle(str);
            builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.MediaActivity$15$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onLinkPress$0(str, dialogInterface, i);
                }
            });
            MediaActivity.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLinkPress$0(String str, DialogInterface dialogInterface, int i) {
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int i, int i2) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            return i2 != 0;
        }

        public SharedLinksAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int i) {
            if ((MediaActivity.this.sharedMediaData[3].sections.size() != 0 || MediaActivity.this.sharedMediaData[3].loading) && i < MediaActivity.this.sharedMediaData[3].sections.size()) {
                return MediaActivity.this.sharedMediaData[3].sectionArrays.get(MediaActivity.this.sharedMediaData[3].sections.get(i)).size() + 1;
            }
            return 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor(Theme.key_graySection) & (-218103809));
            }
            if (MediaActivity.this.sharedMediaData[3].sections.size() != 0) {
                if (i < MediaActivity.this.sharedMediaData[3].sections.size()) {
                    view.setAlpha(1.0f);
                    ((GraySectionCell) view).setText(LocaleController.formatSectionDate(MediaActivity.this.sharedMediaData[3].sectionArrays.get(MediaActivity.this.sharedMediaData[3].sections.get(i)).get(0).messageOwner.date));
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
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 3, MediaActivity.this.dialog_id);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                graySectionCell = new LoadingCell(this.mContext, AndroidUtilities.dp(32.0f), AndroidUtilities.dp(54.0f));
            }
            return new RecyclerListView.Holder(graySectionCell);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 2 || viewHolder.getItemViewType() == 3) {
                return;
            }
            ArrayList<MessageObject> arrayList = MediaActivity.this.sharedMediaData[3].sectionArrays.get(MediaActivity.this.sharedMediaData[3].sections.get(i));
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((GraySectionCell) viewHolder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                return;
            }
            if (itemViewType != 1) {
                return;
            }
            SharedLinkCell sharedLinkCell = (SharedLinkCell) viewHolder.itemView;
            MessageObject messageObject = arrayList.get(i2 - 1);
            sharedLinkCell.setLink(messageObject, i2 != arrayList.size() || (i == MediaActivity.this.sharedMediaData[3].sections.size() - 1 && MediaActivity.this.sharedMediaData[3].loading));
            if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                sharedLinkCell.setChecked(MediaActivity.this.selectedFiles[(messageObject.getDialogId() > MediaActivity.this.dialog_id ? 1 : (messageObject.getDialogId() == MediaActivity.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !MediaActivity.this.scrolling);
            } else {
                sharedLinkCell.setChecked(false, !MediaActivity.this.scrolling);
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            if (MediaActivity.this.sharedMediaData[3].sections.size() == 0 && !MediaActivity.this.sharedMediaData[3].loading) {
                return 3;
            }
            if (i < MediaActivity.this.sharedMediaData[3].sections.size()) {
                return i2 == 0 ? 0 : 1;
            }
            return 2;
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

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            return i2 != 0;
        }

        public SharedDocumentsAdapter(Context context, int i) {
            this.mContext = context;
            this.currentType = i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int i) {
            if ((MediaActivity.this.sharedMediaData[this.currentType].sections.size() != 0 || MediaActivity.this.sharedMediaData[this.currentType].loading) && i < MediaActivity.this.sharedMediaData[this.currentType].sections.size()) {
                return MediaActivity.this.sharedMediaData[this.currentType].sectionArrays.get(MediaActivity.this.sharedMediaData[this.currentType].sections.get(i)).size() + 1;
            }
            return 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor(Theme.key_graySection) & (-218103809));
            }
            if (MediaActivity.this.sharedMediaData[this.currentType].sections.size() != 0) {
                if (i < MediaActivity.this.sharedMediaData[this.currentType].sections.size()) {
                    view.setAlpha(1.0f);
                    ((GraySectionCell) view).setText(LocaleController.formatSectionDate(MediaActivity.this.sharedMediaData[this.currentType].sectionArrays.get(MediaActivity.this.sharedMediaData[this.currentType].sections.get(i)).get(0).messageOwner.date));
                }
            } else {
                view.setAlpha(0.0f);
            }
            return view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View graySectionCell;
            if (i == 0) {
                graySectionCell = new GraySectionCell(this.mContext);
            } else if (i == 1) {
                graySectionCell = new SharedDocumentCell(this.mContext);
            } else if (i == 2) {
                graySectionCell = new LoadingCell(this.mContext, AndroidUtilities.dp(32.0f), AndroidUtilities.dp(54.0f));
            } else {
                if (i == 4) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, this.currentType, MediaActivity.this.dialog_id);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                if (this.currentType == 4 && !MediaActivity.this.audioCellCache.isEmpty()) {
                    graySectionCell = (View) MediaActivity.this.audioCellCache.get(0);
                    MediaActivity.this.audioCellCache.remove(0);
                    ViewGroup viewGroup2 = (ViewGroup) graySectionCell.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(graySectionCell);
                    }
                } else {
                    graySectionCell = new SharedAudioCell(this.mContext) { // from class: org.rbmain.ui.MediaActivity.SharedDocumentsAdapter.1
                        @Override // org.rbmain.ui.Cells.SharedAudioCell
                        public boolean needPlayMessage(MessageObject messageObject) {
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 2 || viewHolder.getItemViewType() == 4) {
                return;
            }
            ArrayList<MessageObject> arrayList = MediaActivity.this.sharedMediaData[this.currentType].sectionArrays.get(MediaActivity.this.sharedMediaData[this.currentType].sections.get(i));
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((GraySectionCell) viewHolder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                return;
            }
            if (itemViewType == 1) {
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) viewHolder.itemView;
                MessageObject messageObject = arrayList.get(i2 - 1);
                sharedDocumentCell.setDocument(messageObject, i2 != arrayList.size() || (i == MediaActivity.this.sharedMediaData[this.currentType].sections.size() - 1 && MediaActivity.this.sharedMediaData[this.currentType].loading));
                if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                    sharedDocumentCell.setChecked(MediaActivity.this.selectedFiles[(messageObject.getDialogId() > MediaActivity.this.dialog_id ? 1 : (messageObject.getDialogId() == MediaActivity.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !MediaActivity.this.scrolling);
                    return;
                } else {
                    sharedDocumentCell.setChecked(false, !MediaActivity.this.scrolling);
                    return;
                }
            }
            if (itemViewType != 3) {
                return;
            }
            SharedAudioCell sharedAudioCell = (SharedAudioCell) viewHolder.itemView;
            MessageObject messageObject2 = arrayList.get(i2 - 1);
            sharedAudioCell.setMessageObject(messageObject2, i2 != arrayList.size() || (i == MediaActivity.this.sharedMediaData[this.currentType].sections.size() - 1 && MediaActivity.this.sharedMediaData[this.currentType].loading));
            if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                sharedAudioCell.setChecked(MediaActivity.this.selectedFiles[(messageObject2.getDialogId() > MediaActivity.this.dialog_id ? 1 : (messageObject2.getDialogId() == MediaActivity.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject2.getId()) >= 0, !MediaActivity.this.scrolling);
            } else {
                sharedAudioCell.setChecked(false, !MediaActivity.this.scrolling);
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            if (MediaActivity.this.sharedMediaData[this.currentType].sections.size() == 0 && !MediaActivity.this.sharedMediaData[this.currentType].loading) {
                return 4;
            }
            if (i >= MediaActivity.this.sharedMediaData[this.currentType].sections.size()) {
                return 2;
            }
            if (i2 == 0) {
                return 0;
            }
            int i3 = this.currentType;
            return (i3 == 2 || i3 == 4) ? 3 : 1;
        }
    }

    private class SharedPhotoVideoAdapter extends RecyclerListView.SectionsAdapter {
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int i, int i2) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            return false;
        }

        public SharedPhotoVideoAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int i) {
            if ((MediaActivity.this.sharedMediaData[0].sections.size() != 0 || MediaActivity.this.sharedMediaData[0].loading) && i < MediaActivity.this.sharedMediaData[0].sections.size()) {
                return ((int) Math.ceil(MediaActivity.this.sharedMediaData[0].sectionArrays.get(MediaActivity.this.sharedMediaData[0].sections.get(i)).size() / MediaActivity.this.columnsCount)) + 1;
            }
            return 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            if (view == null) {
                view = new SharedMediaSectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite) & (-436207617));
            }
            if (MediaActivity.this.sharedMediaData[0].sections.size() != 0) {
                if (i < MediaActivity.this.sharedMediaData[0].sections.size()) {
                    view.setAlpha(1.0f);
                    ((SharedMediaSectionCell) view).setText(LocaleController.formatSectionDate(MediaActivity.this.sharedMediaData[0].sectionArrays.get(MediaActivity.this.sharedMediaData[0].sections.get(i)).get(0).messageOwner.date));
                }
            } else {
                view.setAlpha(0.0f);
            }
            return view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View sharedMediaSectionCell;
            if (i == 0) {
                sharedMediaSectionCell = new SharedMediaSectionCell(this.mContext);
            } else if (i == 1) {
                if (!MediaActivity.this.cellCache.isEmpty()) {
                    sharedMediaSectionCell = (View) MediaActivity.this.cellCache.get(0);
                    MediaActivity.this.cellCache.remove(0);
                    ViewGroup viewGroup2 = (ViewGroup) sharedMediaSectionCell.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(sharedMediaSectionCell);
                    }
                } else {
                    sharedMediaSectionCell = new SharedPhotoVideoCell(this.mContext);
                }
                SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) sharedMediaSectionCell;
                sharedPhotoVideoCell.setDelegate(new SharedPhotoVideoCell.SharedPhotoVideoCellDelegate() { // from class: org.rbmain.ui.MediaActivity.SharedPhotoVideoAdapter.1
                    @Override // org.rbmain.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public void didClickItem(SharedPhotoVideoCell sharedPhotoVideoCell2, int i2, MessageObject messageObject, int i3) {
                        MediaActivity.this.onItemClick(i2, sharedPhotoVideoCell2, messageObject, i3, 0);
                    }

                    @Override // org.rbmain.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public boolean didLongClickItem(SharedPhotoVideoCell sharedPhotoVideoCell2, int i2, MessageObject messageObject, int i3) {
                        if (!((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                            return MediaActivity.this.onItemLongClick(messageObject, sharedPhotoVideoCell2, i3);
                        }
                        didClickItem(sharedPhotoVideoCell2, i2, messageObject, i3);
                        return true;
                    }
                });
                MediaActivity.this.cache.add(sharedPhotoVideoCell);
            } else {
                if (i == 3) {
                    View viewCreateEmptyStubView = SharedMediaLayout.createEmptyStubView(this.mContext, 0, MediaActivity.this.dialog_id);
                    viewCreateEmptyStubView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    return new RecyclerListView.Holder(viewCreateEmptyStubView);
                }
                sharedMediaSectionCell = new LoadingCell(this.mContext, AndroidUtilities.dp(32.0f), AndroidUtilities.dp(74.0f));
            }
            return new RecyclerListView.Holder(sharedMediaSectionCell);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 2 || viewHolder.getItemViewType() == 3) {
                return;
            }
            ArrayList<MessageObject> arrayList = MediaActivity.this.sharedMediaData[0].sectionArrays.get(MediaActivity.this.sharedMediaData[0].sections.get(i));
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((SharedMediaSectionCell) viewHolder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                return;
            }
            if (itemViewType != 1) {
                return;
            }
            SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) viewHolder.itemView;
            sharedPhotoVideoCell.setItemsCount(MediaActivity.this.columnsCount);
            sharedPhotoVideoCell.setIsFirst(i2 == 1);
            for (int i3 = 0; i3 < MediaActivity.this.columnsCount; i3++) {
                int i4 = ((i2 - 1) * MediaActivity.this.columnsCount) + i3;
                if (i4 < arrayList.size()) {
                    MessageObject messageObject = arrayList.get(i4);
                    sharedPhotoVideoCell.setItem(i3, MediaActivity.this.sharedMediaData[0].messages.indexOf(messageObject), messageObject);
                    if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                        sharedPhotoVideoCell.setChecked(i3, MediaActivity.this.selectedFiles[(messageObject.getDialogId() > MediaActivity.this.dialog_id ? 1 : (messageObject.getDialogId() == MediaActivity.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(messageObject.getId()) >= 0, !MediaActivity.this.scrolling);
                    } else {
                        sharedPhotoVideoCell.setChecked(i3, false, !MediaActivity.this.scrolling);
                    }
                } else {
                    sharedPhotoVideoCell.setItem(i3, i4, null);
                }
            }
            sharedPhotoVideoCell.requestLayout();
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            if (MediaActivity.this.sharedMediaData[0].sections.size() == 0 && !MediaActivity.this.sharedMediaData[0].loading) {
                return 3;
            }
            if (i < MediaActivity.this.sharedMediaData[0].sections.size()) {
                return i2 == 0 ? 0 : 1;
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
                ConnectionsManager.getInstance(((BaseFragment) MediaActivity.this).currentAccount).cancelRequest(this.reqId, true);
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
            TLRPC$InputPeer inputPeer = MessagesController.getInstance(((BaseFragment) MediaActivity.this).currentAccount).getInputPeer(i);
            tLRPC$TL_messages_search.peer = inputPeer;
            if (inputPeer == null) {
                return;
            }
            final int i3 = this.lastReqId + 1;
            this.lastReqId = i3;
            this.searchesInProgress++;
            this.reqId = ConnectionsManager.getInstance(((BaseFragment) MediaActivity.this).currentAccount).sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: org.rbmain.ui.MediaActivity$MediaSearchAdapter$$ExternalSyntheticLambda4
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$queryServerSearch$1(j, i3, tLObject, tLRPC$TL_error);
                }
            }, 2);
            ConnectionsManager.getInstance(((BaseFragment) MediaActivity.this).currentAccount).bindRequestToGuid(this.reqId, ((BaseFragment) MediaActivity.this).classGuid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$queryServerSearch$1(long j, final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            final ArrayList arrayList = new ArrayList();
            if (tLRPC$TL_error == null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                for (int i2 = 0; i2 < tLRPC$messages_Messages.messages.size(); i2++) {
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i2);
                    if (j == 0 || tLRPC$Message.id <= j) {
                        arrayList.add(new MessageObject(((BaseFragment) MediaActivity.this).currentAccount, tLRPC$Message, false, true));
                    }
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.MediaActivity$MediaSearchAdapter$$ExternalSyntheticLambda0
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

        public void search(final String str) {
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
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (int i = 0; i < MediaActivity.this.mediaPages.length; i++) {
                if (MediaActivity.this.mediaPages[i].selectedType == this.currentType) {
                    MediaActivity.this.mediaPages[i].emptyView.showProgress(true, true);
                }
            }
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.MediaActivity$MediaSearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$3(str);
                }
            };
            this.searchRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 600L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$search$3(final String str) {
            int i;
            if (!MediaActivity.this.sharedMediaData[this.currentType].messages.isEmpty() && ((i = this.currentType) == 1 || i == 4)) {
                MessageObject messageObject = MediaActivity.this.sharedMediaData[this.currentType].messages.get(MediaActivity.this.sharedMediaData[this.currentType].messages.size() - 1);
                queryServerSearch(str, messageObject.getId(), messageObject.getDialogId());
            } else if (this.currentType == 3) {
                queryServerSearch(str, 0L, MediaActivity.this.dialog_id);
            }
            int i2 = this.currentType;
            if (i2 == 1 || i2 == 4) {
                final ArrayList arrayList = new ArrayList(MediaActivity.this.sharedMediaData[this.currentType].messages);
                this.searchesInProgress++;
                Utilities.searchQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.MediaActivity$MediaSearchAdapter$$ExternalSyntheticLambda2
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.MediaActivity$MediaSearchAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$4(ArrayList arrayList) {
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
                sharedDocumentCell = new SharedAudioCell(this.mContext) { // from class: org.rbmain.ui.MediaActivity.MediaSearchAdapter.1
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
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int i2 = this.currentType;
            if (i2 == 1) {
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) viewHolder.itemView;
                MessageObject item = getItem(i);
                sharedDocumentCell.setDocument(item, i != getItemCount() - 1);
                if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                    sharedDocumentCell.setChecked(MediaActivity.this.selectedFiles[(item.getDialogId() > MediaActivity.this.dialog_id ? 1 : (item.getDialogId() == MediaActivity.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item.getId()) >= 0, !MediaActivity.this.scrolling);
                    return;
                } else {
                    sharedDocumentCell.setChecked(false, !MediaActivity.this.scrolling);
                    return;
                }
            }
            if (i2 == 3) {
                SharedLinkCell sharedLinkCell = (SharedLinkCell) viewHolder.itemView;
                MessageObject item2 = getItem(i);
                sharedLinkCell.setLink(item2, i != getItemCount() - 1);
                if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                    sharedLinkCell.setChecked(MediaActivity.this.selectedFiles[(item2.getDialogId() > MediaActivity.this.dialog_id ? 1 : (item2.getDialogId() == MediaActivity.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item2.getId()) >= 0, !MediaActivity.this.scrolling);
                    return;
                } else {
                    sharedLinkCell.setChecked(false, !MediaActivity.this.scrolling);
                    return;
                }
            }
            if (i2 == 4) {
                SharedAudioCell sharedAudioCell = (SharedAudioCell) viewHolder.itemView;
                MessageObject item3 = getItem(i);
                sharedAudioCell.setMessageObject(item3, i != getItemCount() - 1);
                if (((BaseFragment) MediaActivity.this).actionBar.isActionModeShowed()) {
                    sharedAudioCell.setChecked(MediaActivity.this.selectedFiles[(item3.getDialogId() > MediaActivity.this.dialog_id ? 1 : (item3.getDialogId() == MediaActivity.this.dialog_id ? 0 : -1)) == 0 ? (char) 0 : (char) 1].indexOfKey(item3.getId()) >= 0, !MediaActivity.this.scrolling);
                } else {
                    sharedAudioCell.setChecked(false, !MediaActivity.this.scrolling);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateItemsEnter(final RecyclerListView recyclerListView, final int i) {
        if (recyclerListView == null) {
            return;
        }
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
        recyclerListView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this) { // from class: org.rbmain.ui.MediaActivity.16
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                recyclerListView.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount2 = recyclerListView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = recyclerListView.getChildAt(i3);
                    if (recyclerListView.getChildAdapterPosition(childAt2) >= i - 1) {
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
                            objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.MediaActivity.16.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    view.setAlpha(1.0f);
                                    layoutManager.stopIgnoringView(view);
                                    AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, 0, null, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_AB_ITEMSCOLOR;
        int i2 = Theme.key_actionBarDefaultIcon;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        ActionBar actionBar2 = this.actionBar;
        int i3 = ThemeDescription.FLAG_AB_SELECTORCOLOR;
        int i4 = Theme.key_actionBarDefaultSelector;
        arrayList.add(new ThemeDescription(actionBar2, i3, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, Theme.key_actionBarDefaultSubmenuBackground));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, Theme.key_actionBarDefaultSubmenuItem));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_actionBarDefaultSubmenuItemIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_ITEMSCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_SELECTORCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, Theme.key_actionBarDefaultSearch));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, Theme.key_actionBarDefaultSearchPlaceholder));
        arrayList.add(new ThemeDescription(this.selectedMessagesCountTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerBackground));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{FragmentContextView.class}, new String[]{"playButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerPlayPause));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerTitle));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_FASTSCROLL, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerPerformer));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{FragmentContextView.class}, new String[]{"closeButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_inappPlayerClose));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_returnToCallBackground));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_returnToCallText));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip, 0, new Class[]{ScrollSlidingTextTabStrip.class}, new String[]{"selectorDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_actionBarTabLine));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, Theme.key_actionBarTabActiveText));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, Theme.key_actionBarTabUnactiveText));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{TextView.class}, null, null, null, Theme.key_actionBarTabSelector));
        for (final int i5 = 0; i5 < this.mediaPages.length; i5++) {
            ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.MediaActivity$$ExternalSyntheticLambda3
                @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                public final void didSetColor() {
                    this.f$0.lambda$getThemeDescriptions$5(i5);
                }
            };
            StickerEmptyView stickerEmptyView = this.mediaPages[i5].emptyView;
            int i6 = Theme.key_windowBackgroundGray;
            arrayList.add(new ThemeDescription(stickerEmptyView, 0, null, null, null, null, i6));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].progressView, 0, null, null, null, null, i6));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_actionBarDefault));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_emptyListPlaceholder));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_graySectionText));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, null, null, null, Theme.key_graySection));
            int i7 = Theme.key_windowBackgroundWhiteBlackText;
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"dateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText3));
            int i8 = Theme.key_sharedMedia_startStopLoadIcon;
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{SharedDocumentCell.class}, new String[]{"progressView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"statusImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
            int i9 = Theme.key_checkbox;
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
            int i10 = Theme.key_checkboxCheck;
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i10));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_folderIcon));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"extTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_iconText));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_progressCircle));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i10));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_titleTextPaint, null, null, i7));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_descriptionTextPaint, null, null, Theme.key_windowBackgroundWhiteGrayText2));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i10));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, 0, new Class[]{SharedLinkCell.class}, new String[]{"titleTextPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, 0, new Class[]{SharedLinkCell.class}, null, null, null, Theme.key_windowBackgroundWhiteLinkText));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, 0, new Class[]{SharedLinkCell.class}, Theme.linkSelectionPaint, null, null, Theme.key_windowBackgroundWhiteLinkSelection));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, 0, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_sharedMedia_linkPlaceholderText));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_sharedMedia_linkPlaceholder));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, 0, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, 0, new Class[]{SharedPhotoVideoCell.class}, new String[]{"backgroundPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_sharedMedia_photoPlaceholder));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedPhotoVideoCell.class}, null, null, themeDescriptionDelegate, i9));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedPhotoVideoCell.class}, null, null, themeDescriptionDelegate, i10));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].listView, 0, null, null, new Drawable[]{this.pinnedHeaderShadowDrawable}, null, Theme.key_windowBackgroundGrayShadow));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
            arrayList.add(new ThemeDescription(this.mediaPages[i5].emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$5(int i) {
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
