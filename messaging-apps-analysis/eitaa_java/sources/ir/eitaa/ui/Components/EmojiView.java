package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSmoothScrollerCustom;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.EmojiData;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolveUsername;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolvedPeer;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeImageSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_emojiURL;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_foundStickerSets;
import ir.eitaa.tgnet.TLRPC$TL_messages_getEmojiURL;
import ir.eitaa.tgnet.TLRPC$TL_messages_getInlineBotResults;
import ir.eitaa.tgnet.TLRPC$TL_messages_getStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_reorderStickerSets;
import ir.eitaa.tgnet.TLRPC$TL_messages_searchStickerSets;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickers;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import ir.eitaa.tgnet.TLRPC$messages_BotResults;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ContextLinkCell;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell;
import ir.eitaa.ui.Cells.StickerEmojiCell;
import ir.eitaa.ui.Cells.StickerSetGroupInfoCell;
import ir.eitaa.ui.Cells.StickerSetNameCell;
import ir.eitaa.ui.Components.EmojiView;
import ir.eitaa.ui.Components.PagerSlidingTabStrip;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ScrollSlidingTabStrip;
import ir.eitaa.ui.Components.TrendingStickersLayout;
import ir.eitaa.ui.ContentPreviewViewer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class EmojiView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private static final ViewTreeObserver.OnScrollChangedListener NOP;
    private static final Field superListenerField;
    private ImageView backspaceButton;
    private AnimatorSet backspaceButtonAnimation;
    private boolean backspaceOnce;
    private boolean backspacePressed;
    private FrameLayout bottomTabContainer;
    private AnimatorSet bottomTabContainerAnimation;
    private View bottomTabContainerBackground;
    private Runnable checkExpandStickerTabsRunnable;
    private ChooseStickerActionTracker chooseStickerActionTracker;
    private ContentPreviewViewer.ContentPreviewViewerDelegate contentPreviewViewerDelegate;
    private int currentAccount;
    private int currentBackgroundType;
    private long currentChatId;
    private int currentPage;
    private EmojiViewDelegate delegate;
    private Paint dotPaint;
    private DragListener dragListener;
    private EmojiGridAdapter emojiAdapter;
    private FrameLayout emojiContainer;
    private RecyclerListView emojiGridView;
    private Drawable[] emojiIcons;
    private float emojiLastX;
    private float emojiLastY;
    private GridLayoutManager emojiLayoutManager;
    private EmojiSearchAdapter emojiSearchAdapter;
    private SearchField emojiSearchField;
    private int emojiSize;
    private AnimatorSet emojiTabShadowAnimator;
    private ScrollSlidingTabStrip emojiTabs;
    private View emojiTabsShadow;
    private String[] emojiTitles;
    private ImageViewEmoji emojiTouchedView;
    private float emojiTouchedX;
    private float emojiTouchedY;
    private boolean expandStickersByDragg;
    private int favTabBum;
    private ArrayList<TLRPC$Document> favouriteStickers;
    private ArrayList<TLRPC$StickerSetCovered> featuredStickerSets;
    private boolean firstEmojiAttach;
    private boolean firstGifAttach;
    private boolean firstStickersAttach;
    private boolean firstTabUpdate;
    private ImageView floatingButton;
    private boolean forseMultiwindowLayout;
    private GifAdapter gifAdapter;
    private final Map<String, TLRPC$messages_BotResults> gifCache;
    private FrameLayout gifContainer;
    private int gifFirstEmojiTabNum;
    private RecyclerListView gifGridView;
    private Drawable[] gifIcons;
    private GifLayoutManager gifLayoutManager;
    private RecyclerListView.OnItemClickListener gifOnItemClickListener;
    private int gifRecentTabNum;
    private GifAdapter gifSearchAdapter;
    private SearchField gifSearchField;
    private GifSearchPreloader gifSearchPreloader;
    private ScrollSlidingTabStrip gifTabs;
    private int gifTrendingTabNum;
    private int groupStickerPackNum;
    private int groupStickerPackPosition;
    private TLRPC$TL_messages_stickerSet groupStickerSet;
    private boolean groupStickersHidden;
    private boolean hasChatStickers;
    private int hasRecentEmoji;
    private boolean ignoreStickersScroll;
    private TLRPC$ChatFull info;
    private LongSparseArray<TLRPC$StickerSetCovered> installingStickerSets;
    private boolean isLayout;
    private float lastBottomScrollDy;
    private int lastNotifyHeight;
    private int lastNotifyHeight2;
    private int lastNotifyWidth;
    private String[] lastSearchKeyboardLanguage;
    private float lastStickersX;
    private int[] location;
    private TextView mediaBanTooltip;
    private boolean needEmojiSearch;
    private Object outlineProvider;
    private ViewPager pager;
    private EmojiColorPickerView pickerView;
    private EmojiPopupWindow pickerViewPopup;
    private int popupHeight;
    private int popupWidth;
    private TLRPC$StickerSetCovered[] primaryInstallingStickerSets;
    private ArrayList<TLRPC$Document> recentGifs;
    private ArrayList<TLRPC$Document> recentStickers;
    private int recentTabBum;
    android.graphics.Rect rect;
    private LongSparseArray<TLRPC$StickerSetCovered> removingStickerSets;
    private final Theme.ResourcesProvider resourcesProvider;
    private RecyclerAnimationScrollHelper scrollHelper;
    private AnimatorSet searchAnimation;
    private ImageView searchButton;
    private int searchFieldHeight;
    private Drawable searchIconDotDrawable;
    private Drawable searchIconDrawable;
    private View shadowLine;
    private boolean showGifs;
    private boolean showing;
    private Drawable[] stickerIcons;
    private ArrayList<TLRPC$TL_messages_stickerSet> stickerSets;
    private ImageView stickerSettingsButton;
    private AnimatorSet stickersButtonAnimation;
    private FrameLayout stickersContainer;
    private boolean stickersContainerAttached;
    private StickersGridAdapter stickersGridAdapter;
    private RecyclerListView stickersGridView;
    private GridLayoutManager stickersLayoutManager;
    private RecyclerListView.OnItemClickListener stickersOnItemClickListener;
    private SearchField stickersSearchField;
    private StickersSearchGridAdapter stickersSearchGridAdapter;
    private ScrollSlidingTabStrip stickersTab;
    private FrameLayout stickersTabContainer;
    private int stickersTabOffset;
    private Drawable[] tabIcons;
    private final int[] tabsMinusDy;
    private ObjectAnimator[] tabsYAnimators;
    private View topShadow;
    private TrendingAdapter trendingAdapter;
    private int trendingTabNum;
    private PagerSlidingTabStrip typeTabs;
    private ArrayList<View> views;

    public interface DragListener {
        void onDrag(int offset);

        void onDragCancel();

        void onDragEnd(float velocity);

        void onDragStart();
    }

    public interface EmojiViewDelegate {

        /* renamed from: ir.eitaa.ui.Components.EmojiView$EmojiViewDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static long $default$getDialogId(EmojiViewDelegate emojiViewDelegate) {
                return 0L;
            }

            public static float $default$getProgressToSearchOpened(EmojiViewDelegate emojiViewDelegate) {
                return 0.0f;
            }

            public static int $default$getThreadId(EmojiViewDelegate emojiViewDelegate) {
                return 0;
            }

            public static void $default$invalidateEnterView(EmojiViewDelegate emojiViewDelegate) {
            }

            public static boolean $default$isExpanded(EmojiViewDelegate emojiViewDelegate) {
                return false;
            }

            public static boolean $default$isInScheduleMode(EmojiViewDelegate emojiViewDelegate) {
                return false;
            }

            public static boolean $default$isSearchOpened(EmojiViewDelegate emojiViewDelegate) {
                return false;
            }

            public static void $default$onClearEmojiRecent(EmojiViewDelegate emojiViewDelegate) {
            }

            public static void $default$onGifSelected(EmojiViewDelegate emojiViewDelegate, View view, Object obj, String str, Object obj2, boolean z, int i) {
            }

            public static void $default$onSearchOpenClose(EmojiViewDelegate emojiViewDelegate, int i) {
            }

            public static void $default$onShowStickerSet(EmojiViewDelegate emojiViewDelegate, TLRPC$StickerSet tLRPC$StickerSet, TLRPC$InputStickerSet tLRPC$InputStickerSet) {
            }

            public static void $default$onStickerSelected(EmojiViewDelegate emojiViewDelegate, View view, TLRPC$Document tLRPC$Document, String str, Object obj, MessageObject.SendAnimationData sendAnimationData, boolean z, int i) {
            }

            public static void $default$onStickerSetAdd(EmojiViewDelegate emojiViewDelegate, TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
            }

            public static void $default$onStickerSetRemove(EmojiViewDelegate emojiViewDelegate, TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
            }

            public static void $default$onStickersGroupClick(EmojiViewDelegate emojiViewDelegate, long j) {
            }

            public static void $default$onStickersSettingsClick(EmojiViewDelegate emojiViewDelegate) {
            }

            public static void $default$onTabOpened(EmojiViewDelegate emojiViewDelegate, int i) {
            }

            public static void $default$showTrendingStickersAlert(EmojiViewDelegate emojiViewDelegate, TrendingStickersLayout trendingStickersLayout) {
            }
        }

        long getDialogId();

        float getProgressToSearchOpened();

        int getThreadId();

        void invalidateEnterView();

        boolean isExpanded();

        boolean isInScheduleMode();

        boolean isSearchOpened();

        boolean onBackspace();

        void onClearEmojiRecent();

        void onEmojiSelected(String emoji);

        /* renamed from: onGifSelected */
        void lambda$onGifSelected$0$ChatActivityEnterView$47(View view, Object gif, String query, Object parent, boolean notify, int scheduleDate);

        void onSearchOpenClose(int type);

        void onShowStickerSet(TLRPC$StickerSet stickerSet, TLRPC$InputStickerSet inputStickerSet);

        void onStickerSelected(View view, TLRPC$Document sticker, String query, Object parent, MessageObject.SendAnimationData sendAnimationData, boolean notify, int scheduleDate);

        void onStickerSetAdd(TLRPC$StickerSetCovered stickerSet);

        void onStickerSetRemove(TLRPC$StickerSetCovered stickerSet);

        void onStickersGroupClick(long chatId);

        void onStickersSettingsClick();

        void onTabOpened(int type);

        void showTrendingStickersAlert(TrendingStickersLayout layout);
    }

    static /* synthetic */ void lambda$static$0() {
    }

    static {
        Field declaredField = null;
        try {
            declaredField = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        superListenerField = declaredField;
        NOP = new ViewTreeObserver.OnScrollChangedListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$-RGJnnwV5EtlorwPX8GF20zdhNc
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                EmojiView.lambda$static$0();
            }
        };
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.stickersSearchField.searchEditText.setEnabled(enabled);
        this.gifSearchField.searchEditText.setEnabled(enabled);
        this.emojiSearchField.searchEditText.setEnabled(enabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchField extends FrameLayout {
        private View backgroundView;
        private ImageView clearSearchImageView;
        private CloseProgressDrawable2 progressDrawable;
        private View searchBackground;
        private EditTextBoldCursor searchEditText;
        private ImageView searchIconImageView;
        private AnimatorSet shadowAnimator;
        private View shadowView;

        public SearchField(Context context, final int type) {
            super(context);
            View view = new View(context);
            this.shadowView = view;
            view.setAlpha(0.0f);
            this.shadowView.setTag(1);
            this.shadowView.setBackgroundColor(EmojiView.this.getThemedColor("chat_emojiPanelShadowLine"));
            addView(this.shadowView, new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83));
            View view2 = new View(context);
            this.backgroundView = view2;
            view2.setBackgroundColor(EmojiView.this.getThemedColor("chat_emojiPanelBackground"));
            addView(this.backgroundView, new FrameLayout.LayoutParams(-1, EmojiView.this.searchFieldHeight));
            View view3 = new View(context);
            this.searchBackground = view3;
            view3.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), EmojiView.this.getThemedColor("chat_emojiSearchBackground")));
            addView(this.searchBackground, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 14.0f, 14.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.searchIconImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.searchIconImageView.setImageResource(R.drawable.smiles_inputsearch);
            this.searchIconImageView.setColorFilter(new PorterDuffColorFilter(EmojiView.this.getThemedColor("chat_emojiSearchIcon"), PorterDuff.Mode.MULTIPLY));
            addView(this.searchIconImageView, LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 14.0f, 0.0f, 0.0f));
            ImageView imageView2 = new ImageView(context);
            this.clearSearchImageView = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            ImageView imageView3 = this.clearSearchImageView;
            CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
            this.progressDrawable = closeProgressDrawable2;
            imageView3.setImageDrawable(closeProgressDrawable2);
            this.progressDrawable.setSide(AndroidUtilities.dp(7.0f));
            this.clearSearchImageView.setScaleX(0.1f);
            this.clearSearchImageView.setScaleY(0.1f);
            this.clearSearchImageView.setAlpha(0.0f);
            this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(EmojiView.this.getThemedColor("chat_emojiSearchIcon"), PorterDuff.Mode.MULTIPLY));
            addView(this.clearSearchImageView, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 14.0f, 14.0f, 0.0f));
            this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$SearchField$0g5oMcLbiCfOoJDqzKgvB1vGsvA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    this.f$0.lambda$new$0$EmojiView$SearchField(view4);
                }
            });
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: ir.eitaa.ui.Components.EmojiView.SearchField.1
                @Override // android.widget.TextView, android.view.View
                public boolean onTouchEvent(MotionEvent event) {
                    if (!SearchField.this.searchEditText.isEnabled()) {
                        return super.onTouchEvent(event);
                    }
                    if (event.getAction() == 0) {
                        if (!EmojiView.this.delegate.isSearchOpened()) {
                            SearchField searchField = SearchField.this;
                            EmojiView.this.openSearch(searchField);
                        }
                        EmojiView.this.delegate.onSearchOpenClose(type == 1 ? 2 : 1);
                        SearchField.this.searchEditText.requestFocus();
                        AndroidUtilities.showKeyboard(SearchField.this.searchEditText);
                    }
                    return super.onTouchEvent(event);
                }
            };
            this.searchEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.searchEditText.setTypeface(AndroidUtilities.getFontFamily(false));
            this.searchEditText.setHintTextColor(EmojiView.this.getThemedColor("chat_emojiSearchIcon"));
            this.searchEditText.setTextColor(EmojiView.this.getThemedColor("windowBackgroundWhiteBlackText"));
            this.searchEditText.setBackgroundDrawable(null);
            this.searchEditText.setPadding(0, 0, 0, 0);
            this.searchEditText.setMaxLines(1);
            this.searchEditText.setLines(1);
            this.searchEditText.setSingleLine(true);
            this.searchEditText.setImeOptions(268435459);
            if (type == 0) {
                this.searchEditText.setHint(LocaleController.getString("SearchStickersHint", R.string.SearchStickersHint));
            } else if (type == 1) {
                this.searchEditText.setHint(LocaleController.getString("SearchEmojiHint", R.string.SearchEmojiHint));
            } else if (type == 2) {
                this.searchEditText.setHint(LocaleController.getString("SearchGifsTitle", R.string.SearchGifsTitle));
            }
            this.searchEditText.setCursorColor(EmojiView.this.getThemedColor("featuredStickers_addedIcon"));
            this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.searchEditText.setCursorWidth(1.5f);
            addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 12.0f, 46.0f, 0.0f));
            this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.EmojiView.SearchField.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    boolean z = SearchField.this.searchEditText.length() > 0;
                    if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                        SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                    }
                    int i = type;
                    if (i == 0) {
                        EmojiView.this.stickersSearchGridAdapter.search(SearchField.this.searchEditText.getText().toString());
                    } else if (i == 1) {
                        EmojiView.this.emojiSearchAdapter.search(SearchField.this.searchEditText.getText().toString());
                    } else if (i == 2) {
                        EmojiView.this.gifSearchAdapter.search(SearchField.this.searchEditText.getText().toString());
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$EmojiView$SearchField(View view) {
            this.searchEditText.setText("");
            AndroidUtilities.showKeyboard(this.searchEditText);
        }

        public void hideKeyboard() {
            AndroidUtilities.hideKeyboard(this.searchEditText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showShadow(boolean show, boolean animated) {
            if (show && this.shadowView.getTag() == null) {
                return;
            }
            if (show || this.shadowView.getTag() == null) {
                AnimatorSet animatorSet = this.shadowAnimator;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.shadowAnimator = null;
                }
                this.shadowView.setTag(show ? null : 1);
                if (animated) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.shadowAnimator = animatorSet2;
                    Animator[] animatorArr = new Animator[1];
                    View view = this.shadowView;
                    Property property = View.ALPHA;
                    float[] fArr = new float[1];
                    fArr[0] = show ? 1.0f : 0.0f;
                    animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                    animatorSet2.playTogether(animatorArr);
                    this.shadowAnimator.setDuration(200L);
                    this.shadowAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                    this.shadowAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmojiView.SearchField.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            SearchField.this.shadowAnimator = null;
                        }
                    });
                    this.shadowAnimator.start();
                    return;
                }
                this.shadowView.setAlpha(show ? 1.0f : 0.0f);
            }
        }
    }

    private class TypedScrollListener extends RecyclerView.OnScrollListener {
        private boolean smoothScrolling;
        private final int type;

        public TypedScrollListener(int type) {
            this.type = type;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (recyclerView.getLayoutManager().isSmoothScrolling()) {
                this.smoothScrolling = true;
                return;
            }
            if (newState == 0) {
                if (!this.smoothScrolling) {
                    EmojiView.this.animateTabsY(this.type);
                }
                if (EmojiView.this.ignoreStickersScroll) {
                    EmojiView.this.ignoreStickersScroll = false;
                }
                this.smoothScrolling = false;
                return;
            }
            if (newState == 1) {
                if (EmojiView.this.ignoreStickersScroll) {
                    EmojiView.this.ignoreStickersScroll = false;
                }
                SearchField searchFieldForType = EmojiView.this.getSearchFieldForType(this.type);
                if (searchFieldForType != null) {
                    searchFieldForType.hideKeyboard();
                }
                this.smoothScrolling = false;
            }
            if (!this.smoothScrolling) {
                EmojiView.this.stopAnimatingTabsY(this.type);
            }
            if (this.type == 0) {
                if (EmojiView.this.chooseStickerActionTracker == null) {
                    EmojiView.this.createStickersChooseActionTracker();
                }
                EmojiView.this.chooseStickerActionTracker.doSomeAction();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            EmojiView.this.checkScroll(this.type);
            EmojiView.this.checkTabsY(this.type, dy);
            checkSearchFieldScroll();
            if (this.smoothScrolling) {
                return;
            }
            EmojiView.this.checkBottomTabScroll(dy);
        }

        private void checkSearchFieldScroll() {
            int i = this.type;
            if (i == 0) {
                EmojiView.this.checkStickersSearchFieldScroll(false);
            } else if (i == 1) {
                EmojiView.this.checkEmojiSearchFieldScroll(false);
            } else {
                if (i != 2) {
                    return;
                }
                EmojiView.this.checkGifSearchFieldScroll(false);
            }
        }
    }

    private class DraggableScrollSlidingTabStrip extends ScrollSlidingTabStrip {
        private float downX;
        private float downY;
        private boolean draggingHorizontally;
        private boolean draggingVertically;
        private boolean first;
        private float lastTranslateX;
        private float lastX;
        private boolean startedScroll;
        private final int touchSlop;
        private VelocityTracker vTracker;

        public DraggableScrollSlidingTabStrip(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
            this.first = true;
            this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        @Override // ir.eitaa.ui.Components.ScrollSlidingTabStrip, android.widget.HorizontalScrollView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) throws Resources.NotFoundException {
            if (isDragging()) {
                return super.onInterceptTouchEvent(ev);
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (ev.getAction() == 0) {
                this.draggingHorizontally = false;
                this.draggingVertically = false;
                this.downX = ev.getRawX();
                this.downY = ev.getRawY();
            } else if (!this.draggingVertically && !this.draggingHorizontally && EmojiView.this.dragListener != null && Math.abs(ev.getRawY() - this.downY) >= this.touchSlop) {
                this.draggingVertically = true;
                this.downY = ev.getRawY();
                EmojiView.this.dragListener.onDragStart();
                if (this.startedScroll) {
                    EmojiView.this.pager.endFakeDrag();
                    this.startedScroll = false;
                }
                return true;
            }
            return super.onInterceptTouchEvent(ev);
        }

        @Override // ir.eitaa.ui.Components.ScrollSlidingTabStrip, android.widget.HorizontalScrollView, android.view.View
        public boolean onTouchEvent(MotionEvent ev) throws Resources.NotFoundException {
            if (isDragging()) {
                return super.onTouchEvent(ev);
            }
            if (this.first) {
                this.first = false;
                this.lastX = ev.getX();
            }
            if (ev.getAction() == 0 || ev.getAction() == 2) {
                EmojiView.this.lastStickersX = ev.getRawX();
            }
            if (ev.getAction() == 0) {
                this.draggingHorizontally = false;
                this.draggingVertically = false;
                this.downX = ev.getRawX();
                this.downY = ev.getRawY();
            } else if (!this.draggingVertically && !this.draggingHorizontally && EmojiView.this.dragListener != null) {
                if (Math.abs(ev.getRawX() - this.downX) >= this.touchSlop && canScrollHorizontally((int) (this.downX - ev.getRawX()))) {
                    this.draggingHorizontally = true;
                    AndroidUtilities.cancelRunOnUIThread(EmojiView.this.checkExpandStickerTabsRunnable);
                    EmojiView.this.expandStickersByDragg = true;
                    EmojiView.this.updateStickerTabsPosition();
                } else if (Math.abs(ev.getRawY() - this.downY) >= this.touchSlop) {
                    this.draggingVertically = true;
                    this.downY = ev.getRawY();
                    EmojiView.this.dragListener.onDragStart();
                    if (this.startedScroll) {
                        EmojiView.this.pager.endFakeDrag();
                        this.startedScroll = false;
                    }
                }
            }
            if (EmojiView.this.expandStickersByDragg && (ev.getAction() == 1 || ev.getAction() == 3)) {
                AndroidUtilities.runOnUIThread(EmojiView.this.checkExpandStickerTabsRunnable, 1500L);
            }
            if (this.draggingVertically) {
                if (this.vTracker == null) {
                    this.vTracker = VelocityTracker.obtain();
                }
                this.vTracker.addMovement(ev);
                if (ev.getAction() != 1 && ev.getAction() != 3) {
                    EmojiView.this.dragListener.onDrag(Math.round(ev.getRawY() - this.downY));
                } else {
                    this.vTracker.computeCurrentVelocity(1000);
                    float yVelocity = this.vTracker.getYVelocity();
                    this.vTracker.recycle();
                    this.vTracker = null;
                    if (ev.getAction() == 1) {
                        EmojiView.this.dragListener.onDragEnd(yVelocity);
                    } else {
                        EmojiView.this.dragListener.onDragCancel();
                    }
                    this.first = true;
                    this.draggingHorizontally = false;
                    this.draggingVertically = false;
                }
                cancelLongPress();
                return true;
            }
            float translationX = getTranslationX();
            if (getScrollX() == 0 && translationX == 0.0f) {
                if (!this.startedScroll && this.lastX - ev.getX() < 0.0f) {
                    if (EmojiView.this.pager.beginFakeDrag()) {
                        this.startedScroll = true;
                        this.lastTranslateX = getTranslationX();
                    }
                } else if (this.startedScroll && this.lastX - ev.getX() > 0.0f && EmojiView.this.pager.isFakeDragging()) {
                    EmojiView.this.pager.endFakeDrag();
                    this.startedScroll = false;
                }
            }
            if (this.startedScroll) {
                ev.getX();
                try {
                    this.lastTranslateX = translationX;
                } catch (Exception e) {
                    try {
                        EmojiView.this.pager.endFakeDrag();
                    } catch (Exception unused) {
                    }
                    this.startedScroll = false;
                    FileLog.e(e);
                }
            }
            this.lastX = ev.getX();
            if (ev.getAction() == 3 || ev.getAction() == 1) {
                this.first = true;
                this.draggingHorizontally = false;
                this.draggingVertically = false;
                if (this.startedScroll) {
                    EmojiView.this.pager.endFakeDrag();
                    this.startedScroll = false;
                }
            }
            return this.startedScroll || super.onTouchEvent(ev);
        }
    }

    private class ImageViewEmoji extends ImageView {
        private boolean isRecent;

        public ImageViewEmoji(Context context) {
            super(context);
            setScaleType(ImageView.ScaleType.CENTER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendEmoji(String override) {
            String str;
            EmojiView.this.showBottomTab(true, true);
            String strAddColorToCode = override != null ? override : (String) getTag();
            new SpannableStringBuilder().append((CharSequence) strAddColorToCode);
            if (override != null) {
                if (EmojiView.this.delegate != null) {
                    EmojiView.this.delegate.onEmojiSelected(Emoji.fixEmoji(override));
                    return;
                }
                return;
            }
            if (!this.isRecent && (str = Emoji.emojiColor.get(strAddColorToCode)) != null) {
                strAddColorToCode = EmojiView.addColorToCode(strAddColorToCode, str);
            }
            EmojiView.this.addEmojiToRecent(strAddColorToCode);
            if (EmojiView.this.delegate != null) {
                EmojiView.this.delegate.onEmojiSelected(Emoji.fixEmoji(strAddColorToCode));
            }
        }

        public void setImageDrawable(Drawable drawable, boolean recent) {
            super.setImageDrawable(drawable);
            this.isRecent = recent;
        }

        @Override // android.widget.ImageView, android.view.View
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(widthMeasureSpec));
        }
    }

    private class EmojiPopupWindow extends PopupWindow {
        private ViewTreeObserver.OnScrollChangedListener mSuperScrollListener;
        private ViewTreeObserver mViewTreeObserver;

        public EmojiPopupWindow(View contentView, int width, int height) throws IllegalAccessException, IllegalArgumentException {
            super(contentView, width, height);
            init();
        }

        private void init() throws IllegalAccessException, IllegalArgumentException {
            if (EmojiView.superListenerField != null) {
                try {
                    this.mSuperScrollListener = (ViewTreeObserver.OnScrollChangedListener) EmojiView.superListenerField.get(this);
                    EmojiView.superListenerField.set(this, EmojiView.NOP);
                } catch (Exception unused) {
                    this.mSuperScrollListener = null;
                }
            }
        }

        private void unregisterListener() {
            ViewTreeObserver viewTreeObserver;
            if (this.mSuperScrollListener == null || (viewTreeObserver = this.mViewTreeObserver) == null) {
                return;
            }
            if (viewTreeObserver.isAlive()) {
                this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
            }
            this.mViewTreeObserver = null;
        }

        private void registerListener(View anchor) {
            if (this.mSuperScrollListener != null) {
                ViewTreeObserver viewTreeObserver = anchor.getWindowToken() != null ? anchor.getViewTreeObserver() : null;
                ViewTreeObserver viewTreeObserver2 = this.mViewTreeObserver;
                if (viewTreeObserver != viewTreeObserver2) {
                    if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                        this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
                    }
                    this.mViewTreeObserver = viewTreeObserver;
                    if (viewTreeObserver != null) {
                        viewTreeObserver.addOnScrollChangedListener(this.mSuperScrollListener);
                    }
                }
            }
        }

        @Override // android.widget.PopupWindow
        public void showAsDropDown(View anchor, int xoff, int yoff) {
            try {
                super.showAsDropDown(anchor, xoff, yoff);
                registerListener(anchor);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // android.widget.PopupWindow
        public void update(View anchor, int xoff, int yoff, int width, int height) {
            super.update(anchor, xoff, yoff, width, height);
            registerListener(anchor);
        }

        @Override // android.widget.PopupWindow
        public void update(View anchor, int width, int height) {
            super.update(anchor, width, height);
            registerListener(anchor);
        }

        @Override // android.widget.PopupWindow
        public void showAtLocation(View parent, int gravity, int x, int y) {
            super.showAtLocation(parent, gravity, x, y);
            unregisterListener();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            setFocusable(false);
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
            unregisterListener();
        }
    }

    private class EmojiColorPickerView extends View {
        private Drawable arrowDrawable;
        private int arrowX;
        private Drawable backgroundDrawable;
        private String currentEmoji;
        private RectF rect;
        private Paint rectPaint;
        private int selection;

        public void setEmoji(String emoji, int arrowPosition) {
            this.currentEmoji = emoji;
            this.arrowX = arrowPosition;
            this.rectPaint.setColor(788529152);
            invalidate();
        }

        public void setSelection(int position) {
            if (this.selection == position) {
                return;
            }
            this.selection = position;
            invalidate();
        }

        public int getSelection() {
            return this.selection;
        }

        public EmojiColorPickerView(Context context) {
            super(context);
            this.rectPaint = new Paint(1);
            this.rect = new RectF();
            this.backgroundDrawable = getResources().getDrawable(R.drawable.stickers_back_all);
            this.arrowDrawable = getResources().getDrawable(R.drawable.stickers_back_arrow);
            Theme.setDrawableColor(this.backgroundDrawable, EmojiView.this.getThemedColor("dialogBackground"));
            Theme.setDrawableColor(this.arrowDrawable, EmojiView.this.getThemedColor("dialogBackground"));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i = 0;
            this.backgroundDrawable.setBounds(0, 0, getMeasuredWidth(), AndroidUtilities.dp(AndroidUtilities.isTablet() ? 60.0f : 52.0f));
            this.backgroundDrawable.draw(canvas);
            this.arrowDrawable.setBounds(this.arrowX - AndroidUtilities.dp(9.0f), AndroidUtilities.dp(AndroidUtilities.isTablet() ? 55.5f : 47.5f), this.arrowX + AndroidUtilities.dp(9.0f), AndroidUtilities.dp((AndroidUtilities.isTablet() ? 55.5f : 47.5f) + 8.0f));
            this.arrowDrawable.draw(canvas);
            if (this.currentEmoji != null) {
                while (i < 6) {
                    int iDp = (EmojiView.this.emojiSize * i) + AndroidUtilities.dp((i * 4) + 5);
                    int iDp2 = AndroidUtilities.dp(9.0f);
                    if (this.selection == i) {
                        this.rect.set(iDp, iDp2 - ((int) AndroidUtilities.dpf2(3.5f)), EmojiView.this.emojiSize + iDp, EmojiView.this.emojiSize + iDp2 + AndroidUtilities.dp(3.0f));
                        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.rectPaint);
                    }
                    String strAddColorToCode = this.currentEmoji;
                    if (i != 0) {
                        strAddColorToCode = EmojiView.addColorToCode(strAddColorToCode, i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "🏿" : "🏾" : "🏽" : "🏼" : "🏻");
                    }
                    Drawable emojiBigDrawable = Emoji.getEmojiBigDrawable(strAddColorToCode);
                    if (emojiBigDrawable != null) {
                        emojiBigDrawable.setBounds(iDp, iDp2, EmojiView.this.emojiSize + iDp, EmojiView.this.emojiSize + iDp2);
                        emojiBigDrawable.draw(canvas);
                    }
                    i++;
                }
            }
        }
    }

    public EmojiView(boolean needStickers, boolean needGif, final Context context, boolean needSearch, final TLRPC$ChatFull chatFull, ViewGroup parentView, final Theme.ResourcesProvider resourcesProvider) throws Resources.NotFoundException {
        super(context);
        this.views = new ArrayList<>();
        this.firstEmojiAttach = true;
        this.hasRecentEmoji = -1;
        this.gifSearchPreloader = new GifSearchPreloader();
        this.gifCache = new HashMap();
        this.firstGifAttach = true;
        this.gifRecentTabNum = -2;
        this.gifTrendingTabNum = -2;
        this.gifFirstEmojiTabNum = -2;
        this.firstStickersAttach = true;
        this.tabsMinusDy = new int[3];
        this.tabsYAnimators = new ObjectAnimator[3];
        this.currentAccount = UserConfig.selectedAccount;
        this.stickerSets = new ArrayList<>();
        this.recentGifs = new ArrayList<>();
        this.recentStickers = new ArrayList<>();
        this.favouriteStickers = new ArrayList<>();
        this.featuredStickerSets = new ArrayList<>();
        this.primaryInstallingStickerSets = new TLRPC$StickerSetCovered[10];
        this.installingStickerSets = new LongSparseArray<>();
        this.removingStickerSets = new LongSparseArray<>();
        this.location = new int[2];
        this.recentTabBum = -2;
        this.favTabBum = -2;
        this.trendingTabNum = -2;
        this.currentBackgroundType = -1;
        this.checkExpandStickerTabsRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.EmojiView.1
            @Override // java.lang.Runnable
            public void run() {
                if (EmojiView.this.stickersTab.isDragging()) {
                    return;
                }
                EmojiView.this.expandStickersByDragg = false;
                EmojiView.this.updateStickerTabsPosition();
            }
        };
        this.contentPreviewViewerDelegate = new ContentPreviewViewer.ContentPreviewViewerDelegate() { // from class: ir.eitaa.ui.Components.EmojiView.2
            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needMenu() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needMenu(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needOpen() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needOpen(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemove() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemove(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needSend() {
                return true;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void remove(SendMessagesHelper.ImportingSticker importingSticker) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$remove(this, importingSticker);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendSticker(TLRPC$Document sticker, String query, Object parent, boolean notify, int scheduleDate) {
                EmojiView.this.delegate.onStickerSelected(null, sticker, query, parent, null, notify, scheduleDate);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean isInScheduleMode() {
                return EmojiView.this.delegate.isInScheduleMode();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void openSet(TLRPC$InputStickerSet set, boolean clearsInputField) {
                if (set == null) {
                    return;
                }
                EmojiView.this.delegate.onShowStickerSet(null, set);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendGif(Object gif, Object parent, boolean notify, int scheduleDate) {
                if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifAdapter) {
                    EmojiView.this.delegate.lambda$onGifSelected$0$ChatActivityEnterView$47(null, gif, null, parent, notify, scheduleDate);
                } else if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifSearchAdapter) {
                    EmojiView.this.delegate.lambda$onGifSelected$0$ChatActivityEnterView$47(null, gif, null, parent, notify, scheduleDate);
                }
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void gifAddedOrDeleted() {
                EmojiView.this.updateRecentGifs();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public long getDialogId() {
                return EmojiView.this.delegate.getDialogId();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public String getQuery(boolean isGif) {
                if (isGif) {
                    if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifSearchAdapter) {
                        return EmojiView.this.gifSearchAdapter.lastSearchImageString;
                    }
                    return null;
                }
                if (EmojiView.this.emojiGridView.getAdapter() == EmojiView.this.emojiSearchAdapter) {
                    return EmojiView.this.emojiSearchAdapter.lastSearchEmojiString;
                }
                return null;
            }
        };
        this.rect = new android.graphics.Rect();
        this.resourcesProvider = resourcesProvider;
        int themedColor = getThemedColor("chat_emojiBottomPanelIcon");
        int iArgb = Color.argb(30, Color.red(themedColor), Color.green(themedColor), Color.blue(themedColor));
        this.searchFieldHeight = AndroidUtilities.dp(64.0f);
        this.needEmojiSearch = needSearch;
        this.tabIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_tab_smiles, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_tab_gif, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_tab_stickers, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected"))};
        this.emojiIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_recent, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_smiles, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_cat, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_food, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_activities, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_travel, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_objects, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_other, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_flags, getThemedColor("chat_emojiPanelIcon"), getThemedColor("chat_emojiPanelIconSelected"))};
        Drawable drawableCreateEmojiIconSelectorDrawable = Theme.createEmojiIconSelectorDrawable(context, R.drawable.emoji_tabs_new1, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected"));
        this.searchIconDrawable = drawableCreateEmojiIconSelectorDrawable;
        Drawable drawableCreateEmojiIconSelectorDrawable2 = Theme.createEmojiIconSelectorDrawable(context, R.drawable.emoji_tabs_new2, getThemedColor("chat_emojiPanelStickerPackSelectorLine"), getThemedColor("chat_emojiPanelStickerPackSelectorLine"));
        this.searchIconDotDrawable = drawableCreateEmojiIconSelectorDrawable2;
        this.stickerIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.emoji_tabs_recent, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.emoji_tabs_faves, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.emoji_tabs_new3, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), new LayerDrawable(new Drawable[]{drawableCreateEmojiIconSelectorDrawable, drawableCreateEmojiIconSelectorDrawable2})};
        this.gifIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_recent, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected")), Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_gifs_trending, getThemedColor("chat_emojiBottomPanelIcon"), getThemedColor("chat_emojiPanelIconSelected"))};
        this.emojiTitles = new String[]{LocaleController.getString("Emoji1", R.string.Emoji1), LocaleController.getString("Emoji2", R.string.Emoji2), LocaleController.getString("Emoji3", R.string.Emoji3), LocaleController.getString("Emoji4", R.string.Emoji4), LocaleController.getString("Emoji5", R.string.Emoji5), LocaleController.getString("Emoji6", R.string.Emoji6), LocaleController.getString("Emoji7", R.string.Emoji7), LocaleController.getString("Emoji8", R.string.Emoji8)};
        this.showGifs = needGif;
        this.info = chatFull;
        Paint paint = new Paint(1);
        this.dotPaint = paint;
        paint.setColor(getThemedColor("chat_emojiPanelNewTrending"));
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            this.outlineProvider = new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.EmojiView.3
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(view.getPaddingLeft(), view.getPaddingTop(), view.getMeasuredWidth() - view.getPaddingRight(), view.getMeasuredHeight() - view.getPaddingBottom(), AndroidUtilities.dp(6.0f));
                }
            };
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.emojiContainer = frameLayout;
        this.views.add(frameLayout);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.EmojiView.4
            private boolean ignoreLayout;

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            protected void onMeasure(int widthSpec, int heightSpec) {
                this.ignoreLayout = true;
                EmojiView.this.emojiLayoutManager.setSpanCount(Math.max(1, View.MeasureSpec.getSize(widthSpec) / AndroidUtilities.dp(AndroidUtilities.isTablet() ? 60.0f : 45.0f)));
                this.ignoreLayout = false;
                super.onMeasure(widthSpec, heightSpec);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                if (EmojiView.this.needEmojiSearch && EmojiView.this.firstEmojiAttach) {
                    this.ignoreLayout = true;
                    EmojiView.this.emojiLayoutManager.scrollToPositionWithOffset(1, 0);
                    EmojiView.this.firstEmojiAttach = false;
                    this.ignoreLayout = false;
                }
                super.onLayout(changed, l, t, r, b);
                EmojiView.this.checkEmojiSearchFieldScroll(true);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouchEvent(android.view.MotionEvent r12) {
                /*
                    Method dump skipped, instructions count: 436
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.EmojiView.AnonymousClass4.onTouchEvent(android.view.MotionEvent):boolean");
            }
        };
        this.emojiGridView = recyclerListView;
        recyclerListView.setInstantClick(true);
        RecyclerListView recyclerListView2 = this.emojiGridView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 8);
        this.emojiLayoutManager = gridLayoutManager;
        recyclerListView2.setLayoutManager(gridLayoutManager);
        this.emojiGridView.setTopGlowOffset(AndroidUtilities.dp(38.0f));
        this.emojiGridView.setBottomGlowOffset(AndroidUtilities.dp(48.0f));
        this.emojiGridView.setPadding(0, AndroidUtilities.dp(38.0f), 0, AndroidUtilities.dp(44.0f));
        this.emojiGridView.setGlowColor(getThemedColor("chat_emojiPanelBackground"));
        this.emojiGridView.setClipToPadding(false);
        this.emojiLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.EmojiView.5
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                if (EmojiView.this.emojiGridView.getAdapter() != EmojiView.this.emojiSearchAdapter) {
                    if ((EmojiView.this.needEmojiSearch && position == 0) || EmojiView.this.emojiAdapter.positionToSection.indexOfKey(position) >= 0) {
                        return EmojiView.this.emojiLayoutManager.getSpanCount();
                    }
                } else if (position == 0 || (position == 1 && EmojiView.this.emojiSearchAdapter.searchWas && EmojiView.this.emojiSearchAdapter.result.isEmpty())) {
                    return EmojiView.this.emojiLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
        RecyclerListView recyclerListView3 = this.emojiGridView;
        EmojiGridAdapter emojiGridAdapter = new EmojiGridAdapter();
        this.emojiAdapter = emojiGridAdapter;
        recyclerListView3.setAdapter(emojiGridAdapter);
        this.emojiSearchAdapter = new EmojiSearchAdapter();
        this.emojiContainer.addView(this.emojiGridView, LayoutHelper.createFrame(-1, -1.0f));
        this.emojiGridView.setOnScrollListener(new TypedScrollListener(1) { // from class: ir.eitaa.ui.Components.EmojiView.6
            @Override // ir.eitaa.ui.Components.EmojiView.TypedScrollListener, androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                int i4;
                int iFindFirstVisibleItemPosition = EmojiView.this.emojiLayoutManager.findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition != -1) {
                    int size = Emoji.recentEmoji.size() + (EmojiView.this.needEmojiSearch ? 1 : 0);
                    if (iFindFirstVisibleItemPosition >= size) {
                        int i5 = 0;
                        while (true) {
                            String[][] strArr = EmojiData.dataColored;
                            if (i5 >= strArr.length) {
                                break;
                            }
                            size += strArr[i5].length + 1;
                            if (iFindFirstVisibleItemPosition < size) {
                                i4 = i5 + (!Emoji.recentEmoji.isEmpty() ? 1 : 0);
                                break;
                            }
                            i5++;
                        }
                        EmojiView.this.emojiTabs.onPageScrolled(i4, 0);
                    } else {
                        i4 = 0;
                        EmojiView.this.emojiTabs.onPageScrolled(i4, 0);
                    }
                }
                super.onScrolled(recyclerView, i2, i3);
            }
        });
        this.emojiGridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.EmojiView.7
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int position) {
                if (view instanceof ImageViewEmoji) {
                    ((ImageViewEmoji) view).sendEmoji(null);
                }
            }
        });
        this.emojiGridView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.EmojiView.8
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x0189  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x0199  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x019c  */
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onItemClick(android.view.View r18, int r19) {
                /*
                    Method dump skipped, instructions count: 562
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.EmojiView.AnonymousClass8.onItemClick(android.view.View, int):boolean");
            }
        });
        this.emojiTabs = new ScrollSlidingTabStrip(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.EmojiView.9
            @Override // android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY);
                if (EmojiView.this.emojiTabsShadow != null) {
                    EmojiView.this.emojiTabsShadow.setTranslationY(translationY);
                }
            }
        };
        if (needSearch) {
            SearchField searchField = new SearchField(context, 1);
            this.emojiSearchField = searchField;
            this.emojiContainer.addView(searchField, new FrameLayout.LayoutParams(-1, this.searchFieldHeight + AndroidUtilities.getShadowHeight()));
            this.emojiSearchField.searchEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.eitaa.ui.Components.EmojiView.10
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        EmojiView.this.lastSearchKeyboardLanguage = AndroidUtilities.getCurrentKeyboardLanguage();
                        MediaDataController.getInstance(EmojiView.this.currentAccount).fetchNewEmojiKeywords(EmojiView.this.lastSearchKeyboardLanguage);
                    }
                }
            });
        }
        this.emojiTabs.setShouldExpand(true);
        this.emojiTabs.setIndicatorHeight(-1);
        this.emojiTabs.setUnderlineHeight(-1);
        this.emojiTabs.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
        this.emojiContainer.addView(this.emojiTabs, LayoutHelper.createFrame(-1, 38.0f));
        this.emojiTabs.setDelegate(new ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.eitaa.ui.Components.EmojiView.11
            @Override // ir.eitaa.ui.Components.ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i2) {
                if (!Emoji.recentEmoji.isEmpty()) {
                    if (i2 == 0) {
                        EmojiView.this.emojiLayoutManager.scrollToPositionWithOffset(EmojiView.this.needEmojiSearch ? 1 : 0, 0);
                        return;
                    }
                    i2--;
                }
                EmojiView.this.emojiGridView.stopScroll();
                EmojiView.this.emojiLayoutManager.scrollToPositionWithOffset(EmojiView.this.emojiAdapter.sectionToPosition.get(i2), 0);
                EmojiView.this.checkEmojiTabY(null, 0);
            }
        });
        View view = new View(context);
        this.emojiTabsShadow = view;
        view.setAlpha(0.0f);
        this.emojiTabsShadow.setTag(1);
        this.emojiTabsShadow.setBackgroundColor(getThemedColor("chat_emojiPanelShadowLine"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp(38.0f);
        this.emojiContainer.addView(this.emojiTabsShadow, layoutParams);
        if (needStickers) {
            if (needGif) {
                FrameLayout frameLayout2 = new FrameLayout(context);
                this.gifContainer = frameLayout2;
                this.views.add(frameLayout2);
                RecyclerListView recyclerListView4 = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.EmojiView.12
                    private boolean ignoreLayout;
                    private boolean wasMeasured;

                    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                    public boolean onInterceptTouchEvent(MotionEvent event) {
                        return super.onInterceptTouchEvent(event) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(event, EmojiView.this.gifGridView, 0, EmojiView.this.contentPreviewViewerDelegate, this.resourcesProvider);
                    }

                    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
                    protected void onMeasure(int widthSpec, int heightSpec) {
                        super.onMeasure(widthSpec, heightSpec);
                        if (this.wasMeasured) {
                            return;
                        }
                        EmojiView.this.gifAdapter.notifyDataSetChanged();
                        this.wasMeasured = true;
                    }

                    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean changed, int l, int t, int r, int b) {
                        if (EmojiView.this.firstGifAttach && EmojiView.this.gifAdapter.getItemCount() > 1) {
                            this.ignoreLayout = true;
                            EmojiView.this.gifLayoutManager.scrollToPositionWithOffset(1, 0);
                            EmojiView.this.gifSearchField.setVisibility(0);
                            EmojiView.this.gifTabs.onPageScrolled(0, 0);
                            EmojiView.this.firstGifAttach = false;
                            this.ignoreLayout = false;
                        }
                        super.onLayout(changed, l, t, r, b);
                        EmojiView.this.checkGifSearchFieldScroll(true);
                    }

                    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
                    public void requestLayout() {
                        if (this.ignoreLayout) {
                            return;
                        }
                        super.requestLayout();
                    }
                };
                this.gifGridView = recyclerListView4;
                recyclerListView4.setClipToPadding(false);
                RecyclerListView recyclerListView5 = this.gifGridView;
                GifLayoutManager gifLayoutManager = new GifLayoutManager(context);
                this.gifLayoutManager = gifLayoutManager;
                recyclerListView5.setLayoutManager(gifLayoutManager);
                this.gifGridView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ir.eitaa.ui.Components.EmojiView.13
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(android.graphics.Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                        int childAdapterPosition = parent.getChildAdapterPosition(view2);
                        if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifAdapter && childAdapterPosition == EmojiView.this.gifAdapter.trendingSectionItem) {
                            outRect.set(0, 0, 0, 0);
                            return;
                        }
                        if (childAdapterPosition != 0) {
                            outRect.left = 0;
                            outRect.bottom = 0;
                            outRect.top = AndroidUtilities.dp(2.0f);
                            outRect.right = EmojiView.this.gifLayoutManager.isLastInRow(childAdapterPosition + (-1)) ? 0 : AndroidUtilities.dp(2.0f);
                            return;
                        }
                        outRect.set(0, 0, 0, 0);
                    }
                });
                this.gifGridView.setPadding(0, AndroidUtilities.dp(52.0f), 0, AndroidUtilities.dp(44.0f));
                this.gifGridView.setOverScrollMode(2);
                ((SimpleItemAnimator) this.gifGridView.getItemAnimator()).setSupportsChangeAnimations(false);
                RecyclerListView recyclerListView6 = this.gifGridView;
                GifAdapter gifAdapter = new GifAdapter(this, context, true);
                this.gifAdapter = gifAdapter;
                recyclerListView6.setAdapter(gifAdapter);
                this.gifSearchAdapter = new GifAdapter(this, context);
                this.gifGridView.setOnScrollListener(new TypedScrollListener(2));
                this.gifGridView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$YMCcqNkJeuuHrbPr8F0lszzp6nw
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        return this.f$0.lambda$new$1$EmojiView(resourcesProvider, view2, motionEvent);
                    }
                });
                RecyclerListView.OnItemClickListener onItemClickListener = new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$-VRPw_s3_tBU_gjT53lR62XMOZg
                    @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                    public final void onItemClick(View view2, int i2) {
                        this.f$0.lambda$new$2$EmojiView(view2, i2);
                    }
                };
                this.gifOnItemClickListener = onItemClickListener;
                this.gifGridView.setOnItemClickListener(onItemClickListener);
                this.gifContainer.addView(this.gifGridView, LayoutHelper.createFrame(-1, -1.0f));
                SearchField searchField2 = new SearchField(context, 2);
                this.gifSearchField = searchField2;
                searchField2.setVisibility(4);
                this.gifContainer.addView(this.gifSearchField, new FrameLayout.LayoutParams(-1, this.searchFieldHeight + AndroidUtilities.getShadowHeight()));
                DraggableScrollSlidingTabStrip draggableScrollSlidingTabStrip = new DraggableScrollSlidingTabStrip(context, resourcesProvider);
                this.gifTabs = draggableScrollSlidingTabStrip;
                draggableScrollSlidingTabStrip.setType(ScrollSlidingTabStrip.Type.TAB);
                this.gifTabs.setUnderlineHeight(AndroidUtilities.getShadowHeight());
                this.gifTabs.setIndicatorColor(getThemedColor("chat_emojiPanelStickerPackSelectorLine"));
                this.gifTabs.setUnderlineColor(getThemedColor("chat_emojiPanelShadowLine"));
                this.gifTabs.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
                this.gifContainer.addView(this.gifTabs, LayoutHelper.createFrame(-1, 48, 51));
                updateGifTabs();
                this.gifTabs.setDelegate(new ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$ipYLKHXmUQJtymXEd9qNwYvLJp0
                    @Override // ir.eitaa.ui.Components.ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate
                    public final void onPageSelected(int i2) {
                        this.f$0.lambda$new$3$EmojiView(i2);
                    }
                });
                this.gifAdapter.loadTrendingGifs();
            }
            this.stickersContainer = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.EmojiView.14
                @Override // android.view.ViewGroup, android.view.View
                protected void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    EmojiView.this.stickersContainerAttached = true;
                    EmojiView.this.updateStickerTabsPosition();
                    if (EmojiView.this.chooseStickerActionTracker != null) {
                        EmojiView.this.chooseStickerActionTracker.checkVisibility();
                    }
                }

                @Override // android.view.ViewGroup, android.view.View
                protected void onDetachedFromWindow() {
                    super.onDetachedFromWindow();
                    EmojiView.this.stickersContainerAttached = false;
                    EmojiView.this.updateStickerTabsPosition();
                    if (EmojiView.this.chooseStickerActionTracker != null) {
                        EmojiView.this.chooseStickerActionTracker.checkVisibility();
                    }
                }
            };
            MediaDataController.getInstance(this.currentAccount).checkStickers(0);
            MediaDataController.getInstance(this.currentAccount).checkFeaturedStickers();
            RecyclerListView recyclerListView7 = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.EmojiView.15
                boolean ignoreLayout;

                @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent event) {
                    return super.onInterceptTouchEvent(event) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(event, EmojiView.this.stickersGridView, EmojiView.this.getMeasuredHeight(), EmojiView.this.contentPreviewViewerDelegate, this.resourcesProvider);
                }

                @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.View
                public void setVisibility(int visibility) {
                    super.setVisibility(visibility);
                }

                @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean changed, int l, int t, int r, int b) {
                    if (EmojiView.this.firstStickersAttach && EmojiView.this.stickersGridAdapter.getItemCount() > 0) {
                        this.ignoreLayout = true;
                        EmojiView.this.stickersLayoutManager.scrollToPositionWithOffset(1, 0);
                        EmojiView.this.firstStickersAttach = false;
                        this.ignoreLayout = false;
                    }
                    super.onLayout(changed, l, t, r, b);
                    EmojiView.this.checkStickersSearchFieldScroll(true);
                }

                @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
                public void requestLayout() {
                    if (this.ignoreLayout) {
                        return;
                    }
                    super.requestLayout();
                }
            };
            this.stickersGridView = recyclerListView7;
            GridLayoutManager gridLayoutManager2 = new GridLayoutManager(context, 5) { // from class: ir.eitaa.ui.Components.EmojiView.16
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                    try {
                        LinearSmoothScrollerCustom linearSmoothScrollerCustom = new LinearSmoothScrollerCustom(recyclerView.getContext(), 2);
                        linearSmoothScrollerCustom.setTargetPosition(position);
                        startSmoothScroll(linearSmoothScrollerCustom);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
                    int iScrollVerticallyBy = super.scrollVerticallyBy(dy, recycler, state);
                    if (iScrollVerticallyBy != 0 && EmojiView.this.stickersGridView.getScrollState() == 1) {
                        EmojiView.this.expandStickersByDragg = false;
                        EmojiView.this.updateStickerTabsPosition();
                    }
                    if (EmojiView.this.chooseStickerActionTracker == null) {
                        EmojiView.this.createStickersChooseActionTracker();
                    }
                    EmojiView.this.chooseStickerActionTracker.doSomeAction();
                    return iScrollVerticallyBy;
                }
            };
            this.stickersLayoutManager = gridLayoutManager2;
            recyclerListView7.setLayoutManager(gridLayoutManager2);
            this.stickersLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.EmojiView.17
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int position) {
                    if (EmojiView.this.stickersGridView.getAdapter() != EmojiView.this.stickersGridAdapter) {
                        if (position == EmojiView.this.stickersSearchGridAdapter.totalItems || !(EmojiView.this.stickersSearchGridAdapter.cache.get(position) == null || (EmojiView.this.stickersSearchGridAdapter.cache.get(position) instanceof TLRPC$Document))) {
                            return EmojiView.this.stickersGridAdapter.stickersPerRow;
                        }
                        return 1;
                    }
                    if (position == 0) {
                        return EmojiView.this.stickersGridAdapter.stickersPerRow;
                    }
                    if (position == EmojiView.this.stickersGridAdapter.totalItems || !(EmojiView.this.stickersGridAdapter.cache.get(position) == null || (EmojiView.this.stickersGridAdapter.cache.get(position) instanceof TLRPC$Document))) {
                        return EmojiView.this.stickersGridAdapter.stickersPerRow;
                    }
                    return 1;
                }
            });
            this.stickersGridView.setPadding(0, AndroidUtilities.dp(52.0f), 0, AndroidUtilities.dp(44.0f));
            this.stickersGridView.setClipToPadding(false);
            this.views.add(this.stickersContainer);
            this.stickersSearchGridAdapter = new StickersSearchGridAdapter(context);
            RecyclerListView recyclerListView8 = this.stickersGridView;
            StickersGridAdapter stickersGridAdapter = new StickersGridAdapter(context);
            this.stickersGridAdapter = stickersGridAdapter;
            recyclerListView8.setAdapter(stickersGridAdapter);
            this.stickersGridView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$sxKrp16_XaMI18b4uG6rG-AQ7Nc
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f$0.lambda$new$4$EmojiView(resourcesProvider, view2, motionEvent);
                }
            });
            RecyclerListView.OnItemClickListener onItemClickListener2 = new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$zKcXU8tr7VKX3wueNpu7VHfCdJw
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view2, int i2) {
                    this.f$0.lambda$new$5$EmojiView(view2, i2);
                }
            };
            this.stickersOnItemClickListener = onItemClickListener2;
            this.stickersGridView.setOnItemClickListener(onItemClickListener2);
            this.stickersGridView.setGlowColor(getThemedColor("chat_emojiPanelBackground"));
            this.stickersContainer.addView(this.stickersGridView);
            this.scrollHelper = new RecyclerAnimationScrollHelper(this.stickersGridView, this.stickersLayoutManager);
            SearchField searchField3 = new SearchField(context, 0);
            this.stickersSearchField = searchField3;
            this.stickersContainer.addView(searchField3, new FrameLayout.LayoutParams(-1, this.searchFieldHeight + AndroidUtilities.getShadowHeight()));
            AnonymousClass18 anonymousClass18 = new AnonymousClass18(context, resourcesProvider);
            this.stickersTab = anonymousClass18;
            anonymousClass18.setDragEnabled(true);
            this.stickersTab.setWillNotDraw(false);
            this.stickersTab.setType(ScrollSlidingTabStrip.Type.TAB);
            this.stickersTab.setUnderlineHeight(AndroidUtilities.getShadowHeight());
            this.stickersTab.setIndicatorColor(getThemedColor("chat_emojiPanelStickerPackSelectorLine"));
            this.stickersTab.setUnderlineColor(getThemedColor("chat_emojiPanelShadowLine"));
            if (parentView != null) {
                FrameLayout frameLayout3 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.EmojiView.19
                    Paint paint = new Paint();

                    @Override // android.view.ViewGroup, android.view.View
                    protected void dispatchDraw(Canvas canvas) {
                        EmojiView.this.delegate.getProgressToSearchOpened();
                        float fDp = AndroidUtilities.dp(50.0f) * EmojiView.this.delegate.getProgressToSearchOpened();
                        if (fDp > getMeasuredHeight()) {
                            return;
                        }
                        canvas.save();
                        if (fDp != 0.0f) {
                            canvas.clipRect(0.0f, fDp, getMeasuredWidth(), getMeasuredHeight());
                        }
                        this.paint.setColor(EmojiView.this.getThemedColor("chat_emojiPanelBackground"));
                        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), AndroidUtilities.dp(48.0f) + EmojiView.this.stickersTab.getExpandedOffset(), this.paint);
                        super.dispatchDraw(canvas);
                        EmojiView.this.stickersTab.drawOverlays(canvas);
                        canvas.restore();
                    }

                    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                        super.onLayout(changed, left, top, right, bottom);
                        EmojiView.this.updateStickerTabsPosition();
                    }
                };
                this.stickersTabContainer = frameLayout3;
                frameLayout3.addView(this.stickersTab, LayoutHelper.createFrame(-1, 48, 51));
                parentView.addView(this.stickersTabContainer, LayoutHelper.createFrame(-1, -2.0f));
            } else {
                this.stickersContainer.addView(this.stickersTab, LayoutHelper.createFrame(-1, 48, 51));
            }
            updateStickerTabs();
            this.stickersTab.setDelegate(new ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$l49vuy93OcYA5ZAXCw8Warlca1Y
                @Override // ir.eitaa.ui.Components.ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate
                public final void onPageSelected(int i2) {
                    this.f$0.lambda$new$6$EmojiView(i2);
                }
            });
            this.stickersGridView.setOnScrollListener(new TypedScrollListener(0));
        }
        ViewPager viewPager = new ViewPager(context) { // from class: ir.eitaa.ui.Components.EmojiView.20
            @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1));
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // androidx.viewpager.widget.ViewPager
            public void setCurrentItem(int i2, boolean z) throws Resources.NotFoundException {
                EmojiView.this.startStopVisibleGifs(i2 == 1);
                if (i2 != getCurrentItem()) {
                    super.setCurrentItem(i2, z);
                    return;
                }
                if (i2 == 0) {
                    EmojiView.this.emojiGridView.smoothScrollToPosition(EmojiView.this.needEmojiSearch ? 1 : 0);
                } else if (i2 == 1) {
                    EmojiView.this.gifGridView.smoothScrollToPosition(1);
                } else {
                    EmojiView.this.stickersGridView.smoothScrollToPosition(1);
                }
            }
        };
        this.pager = viewPager;
        viewPager.setAdapter(new EmojiPagesAdapter());
        View view2 = new View(context);
        this.topShadow = view2;
        view2.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, -1907225));
        addView(this.topShadow, LayoutHelper.createFrame(-1, 6.0f));
        ImageView imageView = new ImageView(context) { // from class: ir.eitaa.ui.Components.EmojiView.21
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (event.getAction() == 0) {
                    EmojiView.this.backspacePressed = true;
                    EmojiView.this.backspaceOnce = false;
                    EmojiView.this.postBackspaceRunnable(350);
                } else if (event.getAction() == 3 || event.getAction() == 1) {
                    EmojiView.this.backspacePressed = false;
                    if (!EmojiView.this.backspaceOnce && EmojiView.this.delegate != null && EmojiView.this.delegate.onBackspace()) {
                        EmojiView.this.backspaceButton.performHapticFeedback(3);
                    }
                }
                super.onTouchEvent(event);
                return true;
            }
        };
        this.backspaceButton = imageView;
        imageView.setImageResource(R.drawable.smiles_tab_clear);
        this.backspaceButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelBackspace"), PorterDuff.Mode.MULTIPLY));
        this.backspaceButton.setScaleType(ImageView.ScaleType.CENTER);
        this.backspaceButton.setContentDescription(LocaleController.getString("AccDescrBackspace", R.string.AccDescrBackspace));
        this.backspaceButton.setFocusable(true);
        this.backspaceButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.EmojiView.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        this.bottomTabContainer = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.EmojiView.23
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onInterceptTouchEvent(ev);
            }
        };
        View view3 = new View(context);
        this.shadowLine = view3;
        view3.setBackgroundColor(getThemedColor("chat_emojiPanelShadowLine"));
        this.bottomTabContainer.addView(this.shadowLine, new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight()));
        View view4 = new View(context);
        this.bottomTabContainerBackground = view4;
        this.bottomTabContainer.addView(view4, new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(44.0f), 83));
        if (needSearch) {
            addView(this.bottomTabContainer, new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(44.0f) + AndroidUtilities.getShadowHeight(), 83));
            this.bottomTabContainer.addView(this.backspaceButton, LayoutHelper.createFrame(52, 44, 85));
            if (i >= 21) {
                this.backspaceButton.setBackground(Theme.createSelectorDrawable(iArgb));
            }
            ImageView imageView2 = new ImageView(context);
            this.stickerSettingsButton = imageView2;
            imageView2.setImageResource(R.drawable.smiles_tab_settings);
            this.stickerSettingsButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelBackspace"), PorterDuff.Mode.MULTIPLY));
            this.stickerSettingsButton.setScaleType(ImageView.ScaleType.CENTER);
            this.stickerSettingsButton.setFocusable(true);
            if (i >= 21) {
                this.stickerSettingsButton.setBackground(Theme.createSelectorDrawable(iArgb));
            }
            this.stickerSettingsButton.setContentDescription(LocaleController.getString("Settings", R.string.Settings));
            this.bottomTabContainer.addView(this.stickerSettingsButton, LayoutHelper.createFrame(52, 44, 85));
            this.stickerSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.EmojiView.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (EmojiView.this.delegate != null) {
                        EmojiView.this.delegate.onStickersSettingsClick();
                    }
                }
            });
            PagerSlidingTabStrip pagerSlidingTabStrip = new PagerSlidingTabStrip(context);
            this.typeTabs = pagerSlidingTabStrip;
            pagerSlidingTabStrip.setViewPager(this.pager);
            this.typeTabs.setShouldExpand(false);
            this.typeTabs.setIndicatorHeight(0);
            this.typeTabs.setUnderlineHeight(0);
            this.typeTabs.setTabPaddingLeftRight(AndroidUtilities.dp(10.0f));
            this.bottomTabContainer.addView(this.typeTabs, LayoutHelper.createFrame(-2, 44, 81));
            this.typeTabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.Components.EmojiView.25
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    EmojiView.this.checkGridVisibility(position, positionOffset);
                    EmojiView emojiView = EmojiView.this;
                    emojiView.onPageScrolled(position, (emojiView.getMeasuredWidth() - EmojiView.this.getPaddingLeft()) - EmojiView.this.getPaddingRight(), positionOffsetPixels);
                    boolean z = true;
                    EmojiView.this.showBottomTab(true, true);
                    int currentItem = EmojiView.this.pager.getCurrentItem();
                    SearchField searchField4 = currentItem == 0 ? EmojiView.this.emojiSearchField : currentItem == 1 ? EmojiView.this.gifSearchField : EmojiView.this.stickersSearchField;
                    String string = searchField4.searchEditText.getText().toString();
                    int i2 = 0;
                    while (i2 < 3) {
                        SearchField searchField5 = i2 == 0 ? EmojiView.this.emojiSearchField : i2 == 1 ? EmojiView.this.gifSearchField : EmojiView.this.stickersSearchField;
                        if (searchField5 != null && searchField5 != searchField4 && searchField5.searchEditText != null && !searchField5.searchEditText.getText().toString().equals(string)) {
                            searchField5.searchEditText.setText(string);
                            searchField5.searchEditText.setSelection(string.length());
                        }
                        i2++;
                    }
                    EmojiView emojiView2 = EmojiView.this;
                    if ((position != 0 || positionOffset <= 0.0f) && position != 1) {
                        z = false;
                    }
                    emojiView2.startStopVisibleGifs(z);
                    EmojiView.this.updateStickerTabsPosition();
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    EmojiView.this.saveNewPage();
                    EmojiView.this.showBackspaceButton(position == 0, true);
                    EmojiView.this.showStickerSettingsButton(false, true);
                    if (EmojiView.this.delegate.isSearchOpened()) {
                        if (position == 0) {
                            if (EmojiView.this.emojiSearchField != null) {
                                EmojiView.this.emojiSearchField.searchEditText.requestFocus();
                            }
                        } else if (position == 1) {
                            if (EmojiView.this.gifSearchField != null) {
                                EmojiView.this.gifSearchField.searchEditText.requestFocus();
                            }
                        } else if (EmojiView.this.stickersSearchField != null) {
                            EmojiView.this.stickersSearchField.searchEditText.requestFocus();
                        }
                    }
                }
            });
            ImageView imageView3 = new ImageView(context);
            this.searchButton = imageView3;
            imageView3.setImageResource(R.drawable.smiles_tab_search);
            this.searchButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelBackspace"), PorterDuff.Mode.MULTIPLY));
            this.searchButton.setScaleType(ImageView.ScaleType.CENTER);
            this.searchButton.setContentDescription(LocaleController.getString("Search", R.string.Search));
            this.searchButton.setFocusable(true);
            if (i >= 21) {
                this.searchButton.setBackground(Theme.createSelectorDrawable(iArgb));
            }
            this.searchButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.EmojiView.26
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int currentItem = EmojiView.this.pager.getCurrentItem();
                    SearchField searchField4 = currentItem == 0 ? EmojiView.this.emojiSearchField : currentItem == 1 ? EmojiView.this.gifSearchField : EmojiView.this.stickersSearchField;
                    if (searchField4 == null) {
                        return;
                    }
                    searchField4.searchEditText.requestFocus();
                    MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0);
                    searchField4.searchEditText.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 1, 0.0f, 0.0f, 0);
                    searchField4.searchEditText.onTouchEvent(motionEventObtain2);
                    motionEventObtain2.recycle();
                }
            });
        } else {
            addView(this.bottomTabContainer, LayoutHelper.createFrame((i >= 21 ? 40 : 44) + 20, (i >= 21 ? 40 : 44) + 12, (LocaleController.isRTL ? 3 : 5) | 80, 0.0f, 0.0f, 2.0f, 0.0f));
            Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), getThemedColor("chat_emojiPanelBackground"), getThemedColor("chat_emojiPanelBackground"));
            if (i < 21) {
                Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
                drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
                CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
                combinedDrawable.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
            } else {
                StateListAnimator stateListAnimator = new StateListAnimator();
                int[] iArr = {android.R.attr.state_pressed};
                ImageView imageView4 = this.floatingButton;
                Property property = View.TRANSLATION_Z;
                stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(imageView4, (Property<ImageView, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
                stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
                this.backspaceButton.setStateListAnimator(stateListAnimator);
                this.backspaceButton.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.EmojiView.27
                    @Override // android.view.ViewOutlineProvider
                    @SuppressLint({"NewApi"})
                    public void getOutline(View view5, Outline outline) {
                        outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                    }
                });
            }
            this.backspaceButton.setPadding(0, 0, AndroidUtilities.dp(2.0f), 0);
            this.backspaceButton.setBackground(drawableCreateSimpleSelectorCircleDrawable);
            this.backspaceButton.setContentDescription(LocaleController.getString("AccDescrBackspace", R.string.AccDescrBackspace));
            this.backspaceButton.setFocusable(true);
            this.bottomTabContainer.addView(this.backspaceButton, LayoutHelper.createFrame(i >= 21 ? 40 : 44, i >= 21 ? 40 : 44, 51, 10.0f, 0.0f, 10.0f, 0.0f));
            this.shadowLine.setVisibility(8);
            this.bottomTabContainerBackground.setVisibility(8);
        }
        addView(this.pager, 0, LayoutHelper.createFrame(-1, -1, 51));
        CorrectlyMeasuringTextView correctlyMeasuringTextView = new CorrectlyMeasuringTextView(context);
        this.mediaBanTooltip = correctlyMeasuringTextView;
        correctlyMeasuringTextView.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(3.0f), getThemedColor("chat_gifSaveHintBackground")));
        this.mediaBanTooltip.setTextColor(getThemedColor("chat_gifSaveHintText"));
        this.mediaBanTooltip.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(7.0f));
        this.mediaBanTooltip.setGravity(16);
        this.mediaBanTooltip.setTextSize(1, 14.0f);
        this.mediaBanTooltip.setVisibility(4);
        addView(this.mediaBanTooltip, LayoutHelper.createFrame(-2, -2.0f, 81, 5.0f, 0.0f, 5.0f, 53.0f));
        this.emojiSize = AndroidUtilities.dp(AndroidUtilities.isTablet() ? 40.0f : 32.0f);
        this.pickerView = new EmojiColorPickerView(context);
        EmojiColorPickerView emojiColorPickerView = this.pickerView;
        int iDp = AndroidUtilities.dp(((AndroidUtilities.isTablet() ? 40 : 32) * 6) + 10 + 20);
        this.popupWidth = iDp;
        int iDp2 = AndroidUtilities.dp(AndroidUtilities.isTablet() ? 64.0f : 56.0f);
        this.popupHeight = iDp2;
        EmojiPopupWindow emojiPopupWindow = new EmojiPopupWindow(emojiColorPickerView, iDp, iDp2);
        this.pickerViewPopup = emojiPopupWindow;
        emojiPopupWindow.setOutsideTouchable(true);
        this.pickerViewPopup.setClippingEnabled(true);
        this.pickerViewPopup.setInputMethodMode(2);
        this.pickerViewPopup.setSoftInputMode(0);
        this.pickerViewPopup.getContentView().setFocusableInTouchMode(true);
        this.pickerViewPopup.getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$3apTqu-PHkEHEw1JyTRYXXptmf0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view5, int i2, KeyEvent keyEvent) {
                return this.f$0.lambda$new$7$EmojiView(view5, i2, keyEvent);
            }
        });
        this.currentPage = MessagesController.getGlobalEmojiSettings().getInt("selected_page", 0);
        Emoji.loadRecentEmoji();
        this.emojiAdapter.notifyDataSetChanged();
        if (this.typeTabs != null) {
            if (this.views.size() == 1 && this.typeTabs.getVisibility() == 0) {
                this.typeTabs.setVisibility(4);
            } else {
                if (this.views.size() == 1 || this.typeTabs.getVisibility() == 0) {
                    return;
                }
                this.typeTabs.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$1$EmojiView(Theme.ResourcesProvider resourcesProvider, View view, MotionEvent motionEvent) {
        return ContentPreviewViewer.getInstance().onTouch(motionEvent, this.gifGridView, 0, this.gifOnItemClickListener, this.contentPreviewViewerDelegate, resourcesProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$EmojiView(View view, int i) {
        if (this.delegate == null) {
            return;
        }
        int i2 = i - 1;
        RecyclerView.Adapter adapter = this.gifGridView.getAdapter();
        GifAdapter gifAdapter = this.gifAdapter;
        if (adapter != gifAdapter) {
            RecyclerView.Adapter adapter2 = this.gifGridView.getAdapter();
            GifAdapter gifAdapter2 = this.gifSearchAdapter;
            if (adapter2 != gifAdapter2 || i2 < 0 || i2 >= gifAdapter2.results.size()) {
                return;
            }
            this.delegate.lambda$onGifSelected$0$ChatActivityEnterView$47(view, this.gifSearchAdapter.results.get(i2), this.gifSearchAdapter.lastSearchImageString, this.gifSearchAdapter.bot, true, 0);
            updateRecentGifs();
            return;
        }
        if (i2 < 0) {
            return;
        }
        if (i2 < gifAdapter.recentItemsCount) {
            this.delegate.lambda$onGifSelected$0$ChatActivityEnterView$47(view, this.recentGifs.get(i2), null, "gif", true, 0);
            return;
        }
        if (this.gifAdapter.recentItemsCount > 0) {
            i2 = (i2 - this.gifAdapter.recentItemsCount) - 1;
        }
        if (i2 < 0 || i2 >= this.gifAdapter.results.size()) {
            return;
        }
        this.delegate.lambda$onGifSelected$0$ChatActivityEnterView$47(view, this.gifAdapter.results.get(i2), null, this.gifAdapter.bot, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$EmojiView(int i) {
        if (i == this.gifTrendingTabNum && this.gifAdapter.results.isEmpty()) {
            return;
        }
        this.gifGridView.stopScroll();
        this.gifTabs.onPageScrolled(i, 0);
        int i2 = 1;
        if (i == this.gifRecentTabNum || i == this.gifTrendingTabNum) {
            this.gifSearchField.searchEditText.setText("");
            if (i != this.gifTrendingTabNum || this.gifAdapter.trendingSectionItem < 1) {
                GifLayoutManager gifLayoutManager = this.gifLayoutManager;
                EmojiViewDelegate emojiViewDelegate = this.delegate;
                if (emojiViewDelegate != null && emojiViewDelegate.isExpanded()) {
                    i2 = 0;
                }
                gifLayoutManager.scrollToPositionWithOffset(i2, 0);
            } else {
                this.gifLayoutManager.scrollToPositionWithOffset(this.gifAdapter.trendingSectionItem, -AndroidUtilities.dp(4.0f));
            }
            if (i == this.gifTrendingTabNum) {
                ArrayList<String> arrayList = MessagesController.getInstance(this.currentAccount).gifSearchEmojies;
                if (!arrayList.isEmpty()) {
                    this.gifSearchPreloader.preload(arrayList.get(0));
                }
            }
        } else {
            ArrayList<String> arrayList2 = MessagesController.getInstance(this.currentAccount).gifSearchEmojies;
            this.gifSearchAdapter.searchEmoji(arrayList2.get(i - this.gifFirstEmojiTabNum));
            int i3 = this.gifFirstEmojiTabNum;
            if (i - i3 > 0) {
                this.gifSearchPreloader.preload(arrayList2.get((i - i3) - 1));
            }
            if (i - this.gifFirstEmojiTabNum < arrayList2.size() - 1) {
                this.gifSearchPreloader.preload(arrayList2.get((i - this.gifFirstEmojiTabNum) + 1));
            }
        }
        resetTabsY(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$4$EmojiView(Theme.ResourcesProvider resourcesProvider, View view, MotionEvent motionEvent) {
        return ContentPreviewViewer.getInstance().onTouch(motionEvent, this.stickersGridView, getMeasuredHeight(), this.stickersOnItemClickListener, this.contentPreviewViewerDelegate, resourcesProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$EmojiView(View view, int i) {
        String str;
        RecyclerView.Adapter adapter = this.stickersGridView.getAdapter();
        StickersSearchGridAdapter stickersSearchGridAdapter = this.stickersSearchGridAdapter;
        if (adapter == stickersSearchGridAdapter) {
            String str2 = stickersSearchGridAdapter.searchQuery;
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) this.stickersSearchGridAdapter.positionsToSets.get(i);
            if (tLRPC$StickerSetCovered != null) {
                this.delegate.onShowStickerSet(tLRPC$StickerSetCovered.set, null);
                return;
            }
            str = str2;
        } else {
            str = null;
        }
        if (view instanceof StickerEmojiCell) {
            ContentPreviewViewer.getInstance().reset();
            StickerEmojiCell stickerEmojiCell = (StickerEmojiCell) view;
            if (stickerEmojiCell.isDisabled()) {
                return;
            }
            stickerEmojiCell.disable();
            this.delegate.onStickerSelected(stickerEmojiCell, stickerEmojiCell.getSticker(), str, stickerEmojiCell.getParentObject(), stickerEmojiCell.getSendAnimationData(), true, 0);
        }
    }

    /* renamed from: ir.eitaa.ui.Components.EmojiView$18, reason: invalid class name */
    class AnonymousClass18 extends DraggableScrollSlidingTabStrip {
        static /* synthetic */ void lambda$sendReorder$0(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        AnonymousClass18(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
        }

        @Override // ir.eitaa.ui.Components.ScrollSlidingTabStrip
        protected void updatePosition() {
            EmojiView.this.updateStickerTabsPosition();
            EmojiView.this.stickersTabContainer.invalidate();
            invalidate();
            if (EmojiView.this.delegate != null) {
                EmojiView.this.delegate.invalidateEnterView();
            }
        }

        @Override // ir.eitaa.ui.Components.ScrollSlidingTabStrip
        protected void stickerSetPositionChanged(int fromPosition, int toPosition) {
            int i = fromPosition - EmojiView.this.stickersTabOffset;
            int i2 = toPosition - EmojiView.this.stickersTabOffset;
            MediaDataController mediaDataController = MediaDataController.getInstance(EmojiView.this.currentAccount);
            swapListElements(EmojiView.this.stickerSets, i, i2);
            if (EmojiView.this.hasChatStickers) {
                swapListElements(mediaDataController.getStickerSets(0), i - 1, i2 - 1);
            } else {
                swapListElements(mediaDataController.getStickerSets(0), i, i2);
            }
            EmojiView.this.reloadStickersAdapter();
            AndroidUtilities.cancelRunOnUIThread(EmojiView.this.checkExpandStickerTabsRunnable);
            AndroidUtilities.runOnUIThread(EmojiView.this.checkExpandStickerTabsRunnable, 1500L);
            sendReorder();
            EmojiView.this.updateStickerTabs();
        }

        private void swapListElements(List<TLRPC$TL_messages_stickerSet> list, int index1, int index2) {
            list.add(index2, list.remove(index1));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
        private void sendReorder() {
            MediaDataController.getInstance(EmojiView.this.currentAccount).calcNewHash(0);
            TLRPC$TL_messages_reorderStickerSets tLRPC$TL_messages_reorderStickerSets = new TLRPC$TL_messages_reorderStickerSets();
            tLRPC$TL_messages_reorderStickerSets.masks = false;
            for (?? r2 = EmojiView.this.hasChatStickers; r2 < EmojiView.this.stickerSets.size(); r2++) {
                tLRPC$TL_messages_reorderStickerSets.order.add(Long.valueOf(((TLRPC$TL_messages_stickerSet) EmojiView.this.stickerSets.get(r2)).set.id));
            }
            ConnectionsManager.getInstance(EmojiView.this.currentAccount).sendRequest(tLRPC$TL_messages_reorderStickerSets, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$18$E14dofLyOV18z2J1rKzkxEGJBsE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    EmojiView.AnonymousClass18.lambda$sendReorder$0(tLObject, tLRPC$TL_error);
                }
            });
            NotificationCenter.getInstance(EmojiView.this.currentAccount).postNotificationName(NotificationCenter.stickersDidLoad, 0);
        }

        @Override // ir.eitaa.ui.Components.ScrollSlidingTabStrip
        protected void invalidateOverlays() {
            EmojiView.this.stickersTabContainer.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$EmojiView(int i) {
        if (this.firstTabUpdate) {
            return;
        }
        if (i == this.trendingTabNum) {
            openTrendingStickers(null);
            return;
        }
        if (i == this.recentTabBum) {
            this.stickersGridView.stopScroll();
            scrollStickersToPosition(this.stickersGridAdapter.getPositionForPack("recent"), 0);
            resetTabsY(0);
            ScrollSlidingTabStrip scrollSlidingTabStrip = this.stickersTab;
            int i2 = this.recentTabBum;
            scrollSlidingTabStrip.onPageScrolled(i2, i2 > 0 ? i2 : this.stickersTabOffset);
            return;
        }
        if (i == this.favTabBum) {
            this.stickersGridView.stopScroll();
            scrollStickersToPosition(this.stickersGridAdapter.getPositionForPack("fav"), 0);
            resetTabsY(0);
            ScrollSlidingTabStrip scrollSlidingTabStrip2 = this.stickersTab;
            int i3 = this.favTabBum;
            scrollSlidingTabStrip2.onPageScrolled(i3, i3 > 0 ? i3 : this.stickersTabOffset);
            return;
        }
        int size = i - this.stickersTabOffset;
        if (size >= this.stickerSets.size()) {
            return;
        }
        if (size >= this.stickerSets.size()) {
            size = this.stickerSets.size() - 1;
        }
        this.firstStickersAttach = false;
        this.stickersGridView.stopScroll();
        scrollStickersToPosition(this.stickersGridAdapter.getPositionForPack(this.stickerSets.get(size)), 0);
        resetTabsY(0);
        checkScroll(0);
        int i4 = this.favTabBum;
        if (i4 <= 0 && (i4 = this.recentTabBum) <= 0) {
            i4 = this.stickersTabOffset;
        }
        this.stickersTab.onPageScrolled(i, i4);
        this.expandStickersByDragg = false;
        updateStickerTabsPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$7$EmojiView(View view, int i, KeyEvent keyEvent) {
        EmojiPopupWindow emojiPopupWindow;
        if (i != 82 || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1 || (emojiPopupWindow = this.pickerViewPopup) == null || !emojiPopupWindow.isShowing()) {
            return false;
        }
        this.pickerViewPopup.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createStickersChooseActionTracker() {
        ChooseStickerActionTracker chooseStickerActionTracker = new ChooseStickerActionTracker(this.currentAccount, this.delegate.getDialogId(), this.delegate.getThreadId()) { // from class: ir.eitaa.ui.Components.EmojiView.28
            @Override // ir.eitaa.ui.Components.EmojiView.ChooseStickerActionTracker
            public boolean isShown() {
                return EmojiView.this.delegate != null && EmojiView.this.getVisibility() == 0 && EmojiView.this.stickersContainerAttached;
            }
        };
        this.chooseStickerActionTracker = chooseStickerActionTracker;
        chooseStickerActionTracker.checkVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGridVisibility(int position, float positionOffset) {
        if (this.stickersContainer == null || this.gifContainer == null) {
            return;
        }
        if (position == 0) {
            this.emojiGridView.setVisibility(0);
            this.gifGridView.setVisibility(positionOffset == 0.0f ? 8 : 0);
            this.gifTabs.setVisibility(positionOffset == 0.0f ? 8 : 0);
            this.stickersGridView.setVisibility(8);
            this.stickersTab.setVisibility(8);
            return;
        }
        if (position == 1) {
            this.emojiGridView.setVisibility(8);
            this.gifGridView.setVisibility(0);
            this.gifTabs.setVisibility(0);
            this.stickersGridView.setVisibility(positionOffset == 0.0f ? 8 : 0);
            this.stickersTab.setVisibility(positionOffset == 0.0f ? 8 : 0);
            return;
        }
        if (position == 2) {
            this.emojiGridView.setVisibility(8);
            this.gifGridView.setVisibility(8);
            this.gifTabs.setVisibility(8);
            this.stickersGridView.setVisibility(0);
            this.stickersTab.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String addColorToCode(String code, String color) {
        String strSubstring;
        int length = code.length();
        if (length > 2 && code.charAt(code.length() - 2) == 8205) {
            strSubstring = code.substring(code.length() - 2);
            code = code.substring(0, code.length() - 2);
        } else if (length <= 3 || code.charAt(code.length() - 3) != 8205) {
            strSubstring = null;
        } else {
            strSubstring = code.substring(code.length() - 3);
            code = code.substring(0, code.length() - 3);
        }
        String str = code + color;
        if (strSubstring == null) {
            return str;
        }
        return str + strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openTrendingStickers(TLRPC$StickerSetCovered set) {
        this.delegate.showTrendingStickersAlert(new TrendingStickersLayout(getContext(), new TrendingStickersLayout.Delegate() { // from class: ir.eitaa.ui.Components.EmojiView.29
            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public boolean canSendSticker() {
                return true;
            }

            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public void onStickerSetAdd(TLRPC$StickerSetCovered stickerSet, boolean primary) {
                EmojiView.this.delegate.onStickerSetAdd(stickerSet);
                if (primary) {
                    EmojiView.this.updateStickerTabs();
                }
            }

            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public void onStickerSetRemove(TLRPC$StickerSetCovered stickerSet) {
                EmojiView.this.delegate.onStickerSetRemove(stickerSet);
            }

            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public boolean onListViewInterceptTouchEvent(RecyclerListView listView, MotionEvent event) {
                return ContentPreviewViewer.getInstance().onInterceptTouchEvent(event, listView, EmojiView.this.getMeasuredHeight(), EmojiView.this.contentPreviewViewerDelegate, EmojiView.this.resourcesProvider);
            }

            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public boolean onListViewTouchEvent(RecyclerListView listView, RecyclerListView.OnItemClickListener onItemClickListener, MotionEvent event) {
                return ContentPreviewViewer.getInstance().onTouch(event, listView, EmojiView.this.getMeasuredHeight(), onItemClickListener, EmojiView.this.contentPreviewViewerDelegate, EmojiView.this.resourcesProvider);
            }

            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public String[] getLastSearchKeyboardLanguage() {
                return EmojiView.this.lastSearchKeyboardLanguage;
            }

            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public void setLastSearchKeyboardLanguage(String[] language) {
                EmojiView.this.lastSearchKeyboardLanguage = language;
            }

            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public void onStickerSelected(TLRPC$Document sticker, Object parent, boolean clearsInputField, boolean notify, int scheduleDate) {
                EmojiView.this.delegate.onStickerSelected(null, sticker, null, parent, null, notify, scheduleDate);
            }

            @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
            public boolean isInScheduleMode() {
                return EmojiView.this.delegate.isInScheduleMode();
            }
        }, this.primaryInstallingStickerSets, this.installingStickerSets, this.removingStickerSets, set, this.resourcesProvider));
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        updateBottomTabContainerPosition();
        updateStickerTabsPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStickerTabsPosition() {
        if (this.stickersTabContainer == null) {
            return;
        }
        boolean z = getVisibility() == 0 && this.stickersContainerAttached && this.delegate.getProgressToSearchOpened() != 1.0f;
        this.stickersTabContainer.setVisibility(z ? 0 : 8);
        if (z) {
            this.rect.setEmpty();
            this.pager.getChildVisibleRect(this.stickersContainer, this.rect, null);
            float fDp = AndroidUtilities.dp(50.0f) * this.delegate.getProgressToSearchOpened();
            int i = this.rect.left;
            if (i != 0 || fDp != 0.0f) {
                this.expandStickersByDragg = false;
            }
            this.stickersTabContainer.setTranslationX(i);
            float top = (((getTop() + getTranslationY()) - this.stickersTabContainer.getTop()) - this.stickersTab.getExpandedOffset()) - fDp;
            if (this.stickersTabContainer.getTranslationY() != top) {
                this.stickersTabContainer.setTranslationY(top);
                this.stickersTabContainer.invalidate();
            }
        }
        if (this.expandStickersByDragg && z && this.showing) {
            this.stickersTab.expandStickers(this.lastStickersX, true);
        } else {
            this.expandStickersByDragg = false;
            this.stickersTab.expandStickers(this.lastStickersX, false);
        }
    }

    private void updateBottomTabContainerPosition() {
        View view;
        int measuredHeight;
        if (this.bottomTabContainer.getTag() == null) {
            EmojiViewDelegate emojiViewDelegate = this.delegate;
            if ((emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) && (view = (View) getParent()) != null) {
                float y = getY() - view.getHeight();
                if (getLayoutParams().height > 0) {
                    measuredHeight = getLayoutParams().height;
                } else {
                    measuredHeight = getMeasuredHeight();
                }
                float top = y + measuredHeight;
                if (this.bottomTabContainer.getTop() - top < 0.0f) {
                    top = this.bottomTabContainer.getTop();
                }
                this.bottomTabContainer.setTranslationY(-top);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        updateBottomTabContainerPosition();
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startStopVisibleGifs(boolean start) {
        RecyclerListView recyclerListView = this.gifGridView;
        if (recyclerListView == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gifGridView.getChildAt(i);
            if (childAt instanceof ContextLinkCell) {
                ImageReceiver photoImage = ((ContextLinkCell) childAt).getPhotoImage();
                if (start) {
                    photoImage.setAllowStartAnimation(true);
                    photoImage.startAnimation();
                } else {
                    photoImage.setAllowStartAnimation(false);
                    photoImage.stopAnimation();
                }
            }
        }
    }

    public void addEmojiToRecent(String code) {
        if (Emoji.isValidEmoji(code)) {
            Emoji.recentEmoji.size();
            Emoji.addRecentEmoji(code);
            if (getVisibility() != 0 || this.pager.getCurrentItem() != 0) {
                Emoji.sortEmoji();
                this.emojiAdapter.notifyDataSetChanged();
            }
            Emoji.saveRecentEmoji();
        }
    }

    public void showSearchField(boolean show) {
        for (int i = 0; i < 3; i++) {
            GridLayoutManager layoutManagerForType = getLayoutManagerForType(i);
            int iFindFirstVisibleItemPosition = layoutManagerForType.findFirstVisibleItemPosition();
            if (show) {
                if (iFindFirstVisibleItemPosition == 1 || iFindFirstVisibleItemPosition == 2) {
                    layoutManagerForType.scrollToPosition(0);
                    resetTabsY(i);
                }
            } else if (iFindFirstVisibleItemPosition == 0) {
                layoutManagerForType.scrollToPositionWithOffset(1, 0);
            }
        }
    }

    public void hideSearchKeyboard() {
        SearchField searchField = this.stickersSearchField;
        if (searchField != null) {
            searchField.hideKeyboard();
        }
        SearchField searchField2 = this.gifSearchField;
        if (searchField2 != null) {
            searchField2.hideKeyboard();
        }
        SearchField searchField3 = this.emojiSearchField;
        if (searchField3 != null) {
            searchField3.hideKeyboard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSearch(SearchField searchField) {
        SearchField searchField2;
        final RecyclerListView recyclerListView;
        ScrollSlidingTabStrip scrollSlidingTabStrip;
        LinearLayoutManager linearLayoutManager;
        EmojiViewDelegate emojiViewDelegate;
        AnimatorSet animatorSet = this.searchAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.searchAnimation = null;
        }
        this.firstStickersAttach = false;
        this.firstGifAttach = false;
        this.firstEmojiAttach = false;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                searchField2 = this.emojiSearchField;
                recyclerListView = this.emojiGridView;
                scrollSlidingTabStrip = this.emojiTabs;
                linearLayoutManager = this.emojiLayoutManager;
            } else if (i == 1) {
                searchField2 = this.gifSearchField;
                recyclerListView = this.gifGridView;
                scrollSlidingTabStrip = this.gifTabs;
                linearLayoutManager = this.gifLayoutManager;
            } else {
                searchField2 = this.stickersSearchField;
                recyclerListView = this.stickersGridView;
                scrollSlidingTabStrip = this.stickersTab;
                linearLayoutManager = this.stickersLayoutManager;
            }
            if (searchField2 != null) {
                if (searchField == searchField2 && (emojiViewDelegate = this.delegate) != null && emojiViewDelegate.isExpanded()) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.searchAnimation = animatorSet2;
                    if (scrollSlidingTabStrip != null && i != 2) {
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(scrollSlidingTabStrip, (Property<ScrollSlidingTabStrip, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)), ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)), ObjectAnimator.ofFloat(searchField2, (Property<SearchField, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(0.0f)));
                    } else {
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)), ObjectAnimator.ofFloat(searchField2, (Property<SearchField, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(0.0f)));
                    }
                    this.searchAnimation.setDuration(220L);
                    this.searchAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    this.searchAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmojiView.30
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (animation.equals(EmojiView.this.searchAnimation)) {
                                recyclerListView.setTranslationY(0.0f);
                                if (recyclerListView != EmojiView.this.stickersGridView) {
                                    if (recyclerListView == EmojiView.this.emojiGridView || recyclerListView == EmojiView.this.gifGridView) {
                                        recyclerListView.setPadding(0, 0, 0, 0);
                                    }
                                } else {
                                    recyclerListView.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
                                }
                                EmojiView.this.searchAnimation = null;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            if (animation.equals(EmojiView.this.searchAnimation)) {
                                EmojiView.this.searchAnimation = null;
                            }
                        }
                    });
                    this.searchAnimation.start();
                } else {
                    searchField2.setTranslationY(AndroidUtilities.dp(0.0f));
                    if (scrollSlidingTabStrip != null && i != 2) {
                        scrollSlidingTabStrip.setTranslationY(-AndroidUtilities.dp(48.0f));
                    }
                    if (recyclerListView == this.stickersGridView) {
                        recyclerListView.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
                    } else if (recyclerListView == this.emojiGridView || recyclerListView == this.gifGridView) {
                        recyclerListView.setPadding(0, 0, 0, 0);
                    }
                    if (recyclerListView == this.gifGridView) {
                        if (this.gifSearchAdapter.showTrendingWhenSearchEmpty = this.gifAdapter.results.size() > 0) {
                            this.gifSearchAdapter.search("");
                            RecyclerView.Adapter adapter = this.gifGridView.getAdapter();
                            GifAdapter gifAdapter = this.gifSearchAdapter;
                            if (adapter != gifAdapter) {
                                this.gifGridView.setAdapter(gifAdapter);
                            }
                        }
                    }
                    linearLayoutManager.scrollToPositionWithOffset(0, 0);
                }
            }
        }
    }

    private void showEmojiShadow(boolean show, boolean animated) {
        if (show && this.emojiTabsShadow.getTag() == null) {
            return;
        }
        if (show || this.emojiTabsShadow.getTag() == null) {
            AnimatorSet animatorSet = this.emojiTabShadowAnimator;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.emojiTabShadowAnimator = null;
            }
            this.emojiTabsShadow.setTag(show ? null : 1);
            if (animated) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.emojiTabShadowAnimator = animatorSet2;
                Animator[] animatorArr = new Animator[1];
                View view = this.emojiTabsShadow;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = show ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                animatorSet2.playTogether(animatorArr);
                this.emojiTabShadowAnimator.setDuration(200L);
                this.emojiTabShadowAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                this.emojiTabShadowAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmojiView.31
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        EmojiView.this.emojiTabShadowAnimator = null;
                    }
                });
                this.emojiTabShadowAnimator.start();
                return;
            }
            this.emojiTabsShadow.setAlpha(show ? 1.0f : 0.0f);
        }
    }

    public void closeSearch(boolean animated) {
        closeSearch(animated, -1L);
    }

    private void scrollStickersToPosition(int p, int offset) {
        View viewFindViewByPosition = this.stickersLayoutManager.findViewByPosition(p);
        int iFindFirstVisibleItemPosition = this.stickersLayoutManager.findFirstVisibleItemPosition();
        if (viewFindViewByPosition == null && Math.abs(p - iFindFirstVisibleItemPosition) > 40) {
            this.scrollHelper.setScrollDirection(this.stickersLayoutManager.findFirstVisibleItemPosition() < p ? 0 : 1);
            this.scrollHelper.scrollToPosition(p, offset, false, true);
        } else {
            this.ignoreStickersScroll = true;
            this.stickersGridView.smoothScrollToPosition(p);
        }
    }

    public void closeSearch(boolean animated, long scrollToSet) {
        SearchField searchField;
        final RecyclerListView recyclerListView;
        final GridLayoutManager gridLayoutManager;
        ScrollSlidingTabStrip scrollSlidingTabStrip;
        TLRPC$TL_messages_stickerSet stickerSetById;
        int positionForPack;
        AnimatorSet animatorSet = this.searchAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.searchAnimation = null;
        }
        int currentItem = this.pager.getCurrentItem();
        int i = 2;
        if (currentItem == 2 && scrollToSet != -1 && (stickerSetById = MediaDataController.getInstance(this.currentAccount).getStickerSetById(scrollToSet)) != null && (positionForPack = this.stickersGridAdapter.getPositionForPack(stickerSetById)) >= 0 && positionForPack < this.stickersGridAdapter.getItemCount()) {
            scrollStickersToPosition(positionForPack, AndroidUtilities.dp(60.0f));
        }
        GifAdapter gifAdapter = this.gifSearchAdapter;
        if (gifAdapter != null) {
            gifAdapter.showTrendingWhenSearchEmpty = false;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            if (i2 == 0) {
                searchField = this.emojiSearchField;
                recyclerListView = this.emojiGridView;
                gridLayoutManager = this.emojiLayoutManager;
                scrollSlidingTabStrip = this.emojiTabs;
            } else if (i2 == 1) {
                searchField = this.gifSearchField;
                recyclerListView = this.gifGridView;
                gridLayoutManager = this.gifLayoutManager;
                scrollSlidingTabStrip = this.gifTabs;
            } else {
                searchField = this.stickersSearchField;
                recyclerListView = this.stickersGridView;
                gridLayoutManager = this.stickersLayoutManager;
                scrollSlidingTabStrip = this.stickersTab;
            }
            if (searchField != null) {
                searchField.searchEditText.setText("");
                if (i2 == currentItem && animated) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.searchAnimation = animatorSet2;
                    if (scrollSlidingTabStrip != null && i2 != i) {
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(scrollSlidingTabStrip, (Property<ScrollSlidingTabStrip, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(48.0f) - this.searchFieldHeight), ObjectAnimator.ofFloat(searchField, (Property<SearchField, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(48.0f) - this.searchFieldHeight));
                    } else {
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(48.0f) - this.searchFieldHeight), ObjectAnimator.ofFloat(searchField, (Property<SearchField, Float>) View.TRANSLATION_Y, -this.searchFieldHeight));
                    }
                    this.searchAnimation.setDuration(200L);
                    this.searchAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                    this.searchAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmojiView.32
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (animation.equals(EmojiView.this.searchAnimation)) {
                                int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
                                int top = iFindFirstVisibleItemPosition != -1 ? (int) (gridLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition).getTop() + recyclerListView.getTranslationY()) : 0;
                                recyclerListView.setTranslationY(0.0f);
                                if (recyclerListView != EmojiView.this.stickersGridView && recyclerListView != EmojiView.this.gifGridView) {
                                    if (recyclerListView == EmojiView.this.emojiGridView) {
                                        recyclerListView.setPadding(0, AndroidUtilities.dp(38.0f), 0, AndroidUtilities.dp(44.0f));
                                    }
                                } else {
                                    recyclerListView.setPadding(0, AndroidUtilities.dp(52.0f), 0, AndroidUtilities.dp(44.0f));
                                }
                                if (iFindFirstVisibleItemPosition != -1) {
                                    gridLayoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top - recyclerListView.getPaddingTop());
                                }
                                EmojiView.this.searchAnimation = null;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            if (animation.equals(EmojiView.this.searchAnimation)) {
                                EmojiView.this.searchAnimation = null;
                            }
                        }
                    });
                    this.searchAnimation.start();
                    i = 2;
                } else {
                    searchField.setTranslationY(AndroidUtilities.dp(48.0f) - this.searchFieldHeight);
                    i = 2;
                    if (scrollSlidingTabStrip != null && i2 != 2) {
                        scrollSlidingTabStrip.setTranslationY(0.0f);
                    }
                    if (recyclerListView == this.stickersGridView || recyclerListView == this.gifGridView) {
                        recyclerListView.setPadding(0, AndroidUtilities.dp(52.0f), 0, AndroidUtilities.dp(44.0f));
                    } else if (recyclerListView == this.emojiGridView) {
                        recyclerListView.setPadding(0, AndroidUtilities.dp(38.0f), 0, AndroidUtilities.dp(44.0f));
                    }
                    gridLayoutManager.scrollToPositionWithOffset(1, 0);
                }
            }
        }
        if (!animated) {
            this.delegate.onSearchOpenClose(0);
        }
        showBottomTab(true, animated);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStickersSearchFieldScroll(boolean isLayout) {
        RecyclerListView recyclerListView;
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate != null && emojiViewDelegate.isSearchOpened()) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.stickersGridView.findViewHolderForAdapterPosition(0);
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                this.stickersSearchField.showShadow(true, !isLayout);
                return;
            } else {
                this.stickersSearchField.showShadow(viewHolderFindViewHolderForAdapterPosition.itemView.getTop() < this.stickersGridView.getPaddingTop(), !isLayout);
                return;
            }
        }
        if (this.stickersSearchField == null || (recyclerListView = this.stickersGridView) == null) {
            return;
        }
        if (recyclerListView.findViewHolderForAdapterPosition(0) != null) {
            this.stickersSearchField.setTranslationY(r0.itemView.getTop());
        } else {
            this.stickersSearchField.setTranslationY(-this.searchFieldHeight);
        }
        this.stickersSearchField.showShadow(false, !isLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBottomTabScroll(float dy) {
        int iDp;
        this.lastBottomScrollDy += dy;
        if (this.pager.getCurrentItem() == 0) {
            iDp = AndroidUtilities.dp(38.0f);
        } else {
            iDp = AndroidUtilities.dp(48.0f);
        }
        float f = this.lastBottomScrollDy;
        if (f >= iDp) {
            showBottomTab(false, true);
            return;
        }
        if (f <= (-iDp)) {
            showBottomTab(true, true);
        } else {
            if ((this.bottomTabContainer.getTag() != null || this.lastBottomScrollDy >= 0.0f) && (this.bottomTabContainer.getTag() == null || this.lastBottomScrollDy <= 0.0f)) {
                return;
            }
            this.lastBottomScrollDy = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBackspaceButton(final boolean show, boolean animated) {
        if (show && this.backspaceButton.getTag() == null) {
            return;
        }
        if (show || this.backspaceButton.getTag() == null) {
            AnimatorSet animatorSet = this.backspaceButtonAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.backspaceButtonAnimation = null;
            }
            this.backspaceButton.setTag(show ? null : 1);
            if (animated) {
                if (show) {
                    this.backspaceButton.setVisibility(0);
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.backspaceButtonAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[3];
                ImageView imageView = this.backspaceButton;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = show ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, fArr);
                ImageView imageView2 = this.backspaceButton;
                Property property2 = View.SCALE_X;
                float[] fArr2 = new float[1];
                fArr2[0] = show ? 1.0f : 0.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property2, fArr2);
                ImageView imageView3 = this.backspaceButton;
                Property property3 = View.SCALE_Y;
                float[] fArr3 = new float[1];
                fArr3[0] = show ? 1.0f : 0.0f;
                animatorArr[2] = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property3, fArr3);
                animatorSet2.playTogether(animatorArr);
                this.backspaceButtonAnimation.setDuration(200L);
                this.backspaceButtonAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                this.backspaceButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmojiView.33
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (show) {
                            return;
                        }
                        EmojiView.this.backspaceButton.setVisibility(4);
                    }
                });
                this.backspaceButtonAnimation.start();
                return;
            }
            this.backspaceButton.setAlpha(show ? 1.0f : 0.0f);
            this.backspaceButton.setScaleX(show ? 1.0f : 0.0f);
            this.backspaceButton.setScaleY(show ? 1.0f : 0.0f);
            this.backspaceButton.setVisibility(show ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showStickerSettingsButton(final boolean show, boolean animated) {
        ImageView imageView = this.stickerSettingsButton;
        if (imageView == null) {
            return;
        }
        if (show && imageView.getTag() == null) {
            return;
        }
        if (show || this.stickerSettingsButton.getTag() == null) {
            AnimatorSet animatorSet = this.stickersButtonAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.stickersButtonAnimation = null;
            }
            this.stickerSettingsButton.setTag(show ? null : 1);
            if (animated) {
                if (show) {
                    this.stickerSettingsButton.setVisibility(0);
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.stickersButtonAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[3];
                ImageView imageView2 = this.stickerSettingsButton;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = show ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property, fArr);
                ImageView imageView3 = this.stickerSettingsButton;
                Property property2 = View.SCALE_X;
                float[] fArr2 = new float[1];
                fArr2[0] = show ? 1.0f : 0.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property2, fArr2);
                ImageView imageView4 = this.stickerSettingsButton;
                Property property3 = View.SCALE_Y;
                float[] fArr3 = new float[1];
                fArr3[0] = show ? 1.0f : 0.0f;
                animatorArr[2] = ObjectAnimator.ofFloat(imageView4, (Property<ImageView, Float>) property3, fArr3);
                animatorSet2.playTogether(animatorArr);
                this.stickersButtonAnimation.setDuration(200L);
                this.stickersButtonAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                this.stickersButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmojiView.34
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (show) {
                            return;
                        }
                        EmojiView.this.stickerSettingsButton.setVisibility(4);
                    }
                });
                this.stickersButtonAnimation.start();
                return;
            }
            this.stickerSettingsButton.setAlpha(show ? 1.0f : 0.0f);
            this.stickerSettingsButton.setScaleX(show ? 1.0f : 0.0f);
            this.stickerSettingsButton.setScaleY(show ? 1.0f : 0.0f);
            this.stickerSettingsButton.setVisibility(show ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomTab(boolean show, boolean animated) {
        float fDp;
        float fDp2;
        this.lastBottomScrollDy = 0.0f;
        if (show && this.bottomTabContainer.getTag() == null) {
            return;
        }
        if (show || this.bottomTabContainer.getTag() == null) {
            EmojiViewDelegate emojiViewDelegate = this.delegate;
            if (emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) {
                AnimatorSet animatorSet = this.bottomTabContainerAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.bottomTabContainerAnimation = null;
                }
                this.bottomTabContainer.setTag(show ? null : 1);
                if (animated) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.bottomTabContainerAnimation = animatorSet2;
                    Animator[] animatorArr = new Animator[2];
                    FrameLayout frameLayout = this.bottomTabContainer;
                    Property property = View.TRANSLATION_Y;
                    float[] fArr = new float[1];
                    if (show) {
                        fDp2 = 0.0f;
                    } else {
                        fDp2 = AndroidUtilities.dp(this.needEmojiSearch ? 49.0f : 54.0f);
                    }
                    fArr[0] = fDp2;
                    animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
                    View view = this.shadowLine;
                    Property property2 = View.TRANSLATION_Y;
                    float[] fArr2 = new float[1];
                    fArr2[0] = show ? 0.0f : AndroidUtilities.dp(49.0f);
                    animatorArr[1] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
                    animatorSet2.playTogether(animatorArr);
                    this.bottomTabContainerAnimation.setDuration(200L);
                    this.bottomTabContainerAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                    this.bottomTabContainerAnimation.start();
                    return;
                }
                FrameLayout frameLayout2 = this.bottomTabContainer;
                if (show) {
                    fDp = 0.0f;
                } else {
                    fDp = AndroidUtilities.dp(this.needEmojiSearch ? 49.0f : 54.0f);
                }
                frameLayout2.setTranslationY(fDp);
                this.shadowLine.setTranslationY(show ? 0.0f : AndroidUtilities.dp(49.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTabsY(int type, int dy) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (type == 1) {
            checkEmojiTabY(this.emojiGridView, dy);
            return;
        }
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if ((emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) && !this.ignoreStickersScroll) {
            RecyclerListView listViewForType = getListViewForType(type);
            if (dy <= 0 || listViewForType == null || listViewForType.getVisibility() != 0 || (viewHolderFindViewHolderForAdapterPosition = listViewForType.findViewHolderForAdapterPosition(0)) == null || viewHolderFindViewHolderForAdapterPosition.itemView.getTop() + this.searchFieldHeight < listViewForType.getPaddingTop()) {
                int[] iArr = this.tabsMinusDy;
                iArr[type] = iArr[type] - dy;
                if (iArr[type] > 0) {
                    iArr[type] = 0;
                } else if (iArr[type] < (-AndroidUtilities.dp(288.0f))) {
                    this.tabsMinusDy[type] = -AndroidUtilities.dp(288.0f);
                }
                if (type == 0) {
                    updateStickerTabsPosition();
                } else {
                    getTabsForType(type).setTranslationY(Math.max(-AndroidUtilities.dp(48.0f), this.tabsMinusDy[type]));
                }
            }
        }
    }

    private void resetTabsY(int type) {
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if ((emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) && type != 0) {
            ScrollSlidingTabStrip tabsForType = getTabsForType(type);
            this.tabsMinusDy[type] = 0;
            tabsForType.setTranslationY(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateTabsY(final int type) {
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if ((emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) && type != 0) {
            float fDpf2 = AndroidUtilities.dpf2(type == 1 ? 38.0f : 48.0f);
            float f = this.tabsMinusDy[type] / (-fDpf2);
            if (f <= 0.0f || f >= 1.0f) {
                animateSearchField(type);
                return;
            }
            ScrollSlidingTabStrip tabsForType = getTabsForType(type);
            int i = f > 0.5f ? (int) (-Math.ceil(fDpf2)) : 0;
            if (f > 0.5f) {
                animateSearchField(type, false, i);
            }
            if (type == 1) {
                checkEmojiShadow(i);
            }
            ObjectAnimator[] objectAnimatorArr = this.tabsYAnimators;
            if (objectAnimatorArr[type] == null) {
                objectAnimatorArr[type] = ObjectAnimator.ofFloat(tabsForType, (Property<ScrollSlidingTabStrip, Float>) View.TRANSLATION_Y, tabsForType.getTranslationY(), i);
                this.tabsYAnimators[type].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$Yh396jNcQOm9jnPHHFWr7jU4oOM
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$animateTabsY$8$EmojiView(type, valueAnimator);
                    }
                });
                this.tabsYAnimators[type].setDuration(200L);
            } else {
                objectAnimatorArr[type].setFloatValues(tabsForType.getTranslationY(), i);
            }
            this.tabsYAnimators[type].start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$animateTabsY$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$animateTabsY$8$EmojiView(int i, ValueAnimator valueAnimator) {
        this.tabsMinusDy[i] = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAnimatingTabsY(int type) {
        ObjectAnimator[] objectAnimatorArr = this.tabsYAnimators;
        if (objectAnimatorArr[type] == null || !objectAnimatorArr[type].isRunning()) {
            return;
        }
        this.tabsYAnimators[type].cancel();
    }

    private void animateSearchField(int type) {
        RecyclerListView listViewForType = getListViewForType(type);
        int iDp = AndroidUtilities.dp(type == 1 ? 38.0f : 48.0f);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = listViewForType.findViewHolderForAdapterPosition(0);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            int bottom = viewHolderFindViewHolderForAdapterPosition.itemView.getBottom();
            int[] iArr = this.tabsMinusDy;
            float f = (bottom - (iDp + iArr[type])) / this.searchFieldHeight;
            if (f > 0.0f || f < 1.0f) {
                animateSearchField(type, f > 0.5f, iArr[type]);
            }
        }
    }

    private void animateSearchField(int i, boolean z, final int i2) {
        if (getListViewForType(i).findViewHolderForAdapterPosition(0) == null) {
            return;
        }
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(getContext()) { // from class: ir.eitaa.ui.Components.EmojiView.35
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int getVerticalSnapPreference() {
                return -1;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int calculateTimeForDeceleration(int dx) {
                return super.calculateTimeForDeceleration(dx) * 16;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
                return super.calculateDtToFit(viewStart, viewEnd, boxStart, boxEnd, snapPreference) + i2;
            }
        };
        linearSmoothScroller.setTargetPosition(!z ? 1 : 0);
        getLayoutManagerForType(i).startSmoothScroll(linearSmoothScroller);
    }

    private ScrollSlidingTabStrip getTabsForType(int type) {
        if (type == 0) {
            return this.stickersTab;
        }
        if (type == 1) {
            return this.emojiTabs;
        }
        if (type == 2) {
            return this.gifTabs;
        }
        throw new IllegalArgumentException("Unexpected argument: " + type);
    }

    private RecyclerListView getListViewForType(int type) {
        if (type == 0) {
            return this.stickersGridView;
        }
        if (type == 1) {
            return this.emojiGridView;
        }
        if (type == 2) {
            return this.gifGridView;
        }
        throw new IllegalArgumentException("Unexpected argument: " + type);
    }

    private GridLayoutManager getLayoutManagerForType(int type) {
        if (type == 0) {
            return this.stickersLayoutManager;
        }
        if (type == 1) {
            return this.emojiLayoutManager;
        }
        if (type == 2) {
            return this.gifLayoutManager;
        }
        throw new IllegalArgumentException("Unexpected argument: " + type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SearchField getSearchFieldForType(int type) {
        if (type == 0) {
            return this.stickersSearchField;
        }
        if (type == 1) {
            return this.emojiSearchField;
        }
        if (type == 2) {
            return this.gifSearchField;
        }
        throw new IllegalArgumentException("Unexpected argument: " + type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkEmojiSearchFieldScroll(boolean isLayout) {
        RecyclerListView recyclerListView;
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate != null && emojiViewDelegate.isSearchOpened()) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.emojiGridView.findViewHolderForAdapterPosition(0);
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                this.emojiSearchField.showShadow(true, !isLayout);
            } else {
                this.emojiSearchField.showShadow(viewHolderFindViewHolderForAdapterPosition.itemView.getTop() < this.emojiGridView.getPaddingTop(), !isLayout);
            }
            showEmojiShadow(false, !isLayout);
            return;
        }
        if (this.emojiSearchField == null || (recyclerListView = this.emojiGridView) == null) {
            return;
        }
        if (recyclerListView.findViewHolderForAdapterPosition(0) != null) {
            this.emojiSearchField.setTranslationY(r0.itemView.getTop());
        } else {
            this.emojiSearchField.setTranslationY(-this.searchFieldHeight);
        }
        this.emojiSearchField.showShadow(false, !isLayout);
        checkEmojiShadow(Math.round(this.emojiTabs.getTranslationY()));
    }

    private void checkEmojiShadow(int tabsTranslationY) {
        ObjectAnimator[] objectAnimatorArr = this.tabsYAnimators;
        if (objectAnimatorArr[1] == null || !objectAnimatorArr[1].isRunning()) {
            boolean z = false;
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.emojiGridView.findViewHolderForAdapterPosition(0);
            int iDp = AndroidUtilities.dp(38.0f) + tabsTranslationY;
            if (iDp > 0 && (viewHolderFindViewHolderForAdapterPosition == null || viewHolderFindViewHolderForAdapterPosition.itemView.getBottom() < iDp)) {
                z = true;
            }
            showEmojiShadow(z, !this.isLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkEmojiTabY(View list, int dy) {
        RecyclerListView recyclerListView;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (list == null) {
            ScrollSlidingTabStrip scrollSlidingTabStrip = this.emojiTabs;
            this.tabsMinusDy[1] = 0;
            scrollSlidingTabStrip.setTranslationY(0);
            return;
        }
        if (list.getVisibility() != 0) {
            return;
        }
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) {
            if (dy > 0 && (recyclerListView = this.emojiGridView) != null && recyclerListView.getVisibility() == 0 && (viewHolderFindViewHolderForAdapterPosition = this.emojiGridView.findViewHolderForAdapterPosition(0)) != null) {
                if (viewHolderFindViewHolderForAdapterPosition.itemView.getTop() + (this.needEmojiSearch ? this.searchFieldHeight : 0) >= this.emojiGridView.getPaddingTop()) {
                    return;
                }
            }
            int[] iArr = this.tabsMinusDy;
            iArr[1] = iArr[1] - dy;
            if (iArr[1] > 0) {
                iArr[1] = 0;
            } else if (iArr[1] < (-AndroidUtilities.dp(288.0f))) {
                this.tabsMinusDy[1] = -AndroidUtilities.dp(288.0f);
            }
            this.emojiTabs.setTranslationY(Math.max(-AndroidUtilities.dp(38.0f), this.tabsMinusDy[1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGifSearchFieldScroll(boolean isLayout) {
        RecyclerListView recyclerListView;
        int iFindLastVisibleItemPosition;
        RecyclerListView recyclerListView2 = this.gifGridView;
        if (recyclerListView2 != null && (recyclerListView2.getAdapter() instanceof GifAdapter)) {
            GifAdapter gifAdapter = (GifAdapter) this.gifGridView.getAdapter();
            if (!gifAdapter.searchEndReached && gifAdapter.reqId == 0 && !gifAdapter.results.isEmpty() && (iFindLastVisibleItemPosition = this.gifLayoutManager.findLastVisibleItemPosition()) != -1 && iFindLastVisibleItemPosition > this.gifLayoutManager.getItemCount() - 5) {
                gifAdapter.search(gifAdapter.lastSearchImageString, gifAdapter.nextSearchOffset, true, gifAdapter.lastSearchIsEmoji, gifAdapter.lastSearchIsEmoji);
            }
        }
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate != null && emojiViewDelegate.isSearchOpened()) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.gifGridView.findViewHolderForAdapterPosition(0);
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                this.gifSearchField.showShadow(true, !isLayout);
                return;
            } else {
                this.gifSearchField.showShadow(viewHolderFindViewHolderForAdapterPosition.itemView.getTop() < this.gifGridView.getPaddingTop(), !isLayout);
                return;
            }
        }
        if (this.gifSearchField == null || (recyclerListView = this.gifGridView) == null) {
            return;
        }
        if (recyclerListView.findViewHolderForAdapterPosition(0) != null) {
            this.gifSearchField.setTranslationY(r0.itemView.getTop());
        } else {
            this.gifSearchField.setTranslationY(-this.searchFieldHeight);
        }
        this.gifSearchField.showShadow(false, !isLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollGifsToTop() {
        GifLayoutManager gifLayoutManager = this.gifLayoutManager;
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        gifLayoutManager.scrollToPositionWithOffset((emojiViewDelegate == null || !emojiViewDelegate.isExpanded()) ? 1 : 0, 0);
        resetTabsY(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScroll(int type) {
        int iFindFirstVisibleItemPosition;
        int iFindFirstVisibleItemPosition2;
        if (type == 0) {
            if (this.ignoreStickersScroll || (iFindFirstVisibleItemPosition2 = this.stickersLayoutManager.findFirstVisibleItemPosition()) == -1 || this.stickersGridView == null) {
                return;
            }
            int i = this.favTabBum;
            if (i <= 0 && (i = this.recentTabBum) <= 0) {
                i = this.stickersTabOffset;
            }
            this.stickersTab.onPageScrolled(this.stickersGridAdapter.getTabForPosition(iFindFirstVisibleItemPosition2), i);
            return;
        }
        if (type == 2) {
            RecyclerView.Adapter adapter = this.gifGridView.getAdapter();
            GifAdapter gifAdapter = this.gifAdapter;
            if (adapter != gifAdapter || gifAdapter.trendingSectionItem < 0 || this.gifTrendingTabNum < 0 || this.gifRecentTabNum < 0 || (iFindFirstVisibleItemPosition = this.gifLayoutManager.findFirstVisibleItemPosition()) == -1) {
                return;
            }
            this.gifTabs.onPageScrolled(iFindFirstVisibleItemPosition >= this.gifAdapter.trendingSectionItem ? this.gifTrendingTabNum : this.gifRecentTabNum, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveNewPage() {
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            return;
        }
        int currentItem = viewPager.getCurrentItem();
        int i = currentItem != 2 ? currentItem == 1 ? 2 : 0 : 1;
        if (this.currentPage != i) {
            this.currentPage = i;
            MessagesController.getGlobalEmojiSettings().edit().putInt("selected_page", i).commit();
        }
    }

    public void clearRecentEmoji() {
        Emoji.clearRecentEmoji();
        this.emojiAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageScrolled(int position, int width, int positionOffsetPixels) {
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate == null) {
            return;
        }
        if (position == 1) {
            emojiViewDelegate.onTabOpened(positionOffsetPixels != 0 ? 2 : 0);
        } else if (position == 2) {
            emojiViewDelegate.onTabOpened(3);
        } else {
            emojiViewDelegate.onTabOpened(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postBackspaceRunnable(final int time) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$nBhQuqFO41KFjXkg378fBJCmUf8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$postBackspaceRunnable$9$EmojiView(time);
            }
        }, time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$postBackspaceRunnable$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$postBackspaceRunnable$9$EmojiView(int i) {
        if (this.backspacePressed) {
            EmojiViewDelegate emojiViewDelegate = this.delegate;
            if (emojiViewDelegate != null && emojiViewDelegate.onBackspace()) {
                this.backspaceButton.performHapticFeedback(3);
            }
            this.backspaceOnce = true;
            postBackspaceRunnable(Math.max(50, i - 100));
        }
    }

    public void switchToGifRecent() throws Resources.NotFoundException {
        showBackspaceButton(false, false);
        showStickerSettingsButton(false, false);
        this.pager.setCurrentItem(1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmojiTabs() {
        int i = !Emoji.recentEmoji.isEmpty() ? 1 : 0;
        int i2 = this.hasRecentEmoji;
        if (i2 == -1 || i2 != i) {
            this.hasRecentEmoji = i;
            this.emojiTabs.removeTabs();
            String[] strArr = {LocaleController.getString("RecentStickers", R.string.RecentStickers), LocaleController.getString("Emoji1", R.string.Emoji1), LocaleController.getString("Emoji2", R.string.Emoji2), LocaleController.getString("Emoji3", R.string.Emoji3), LocaleController.getString("Emoji4", R.string.Emoji4), LocaleController.getString("Emoji5", R.string.Emoji5), LocaleController.getString("Emoji6", R.string.Emoji6), LocaleController.getString("Emoji7", R.string.Emoji7), LocaleController.getString("Emoji8", R.string.Emoji8)};
            for (int i3 = 0; i3 < this.emojiIcons.length; i3++) {
                if (i3 != 0 || !Emoji.recentEmoji.isEmpty()) {
                    this.emojiTabs.addIconTab(i3, this.emojiIcons[i3]).setContentDescription(strArr[i3]);
                }
            }
            this.emojiTabs.updateTabStyles();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStickerTabs() {
        ArrayList<TLRPC$Document> arrayList;
        ArrayList<TLRPC$Document> arrayList2;
        ScrollSlidingTabStrip scrollSlidingTabStrip = this.stickersTab;
        if (scrollSlidingTabStrip == null || scrollSlidingTabStrip.isDragging()) {
            return;
        }
        this.recentTabBum = -2;
        this.favTabBum = -2;
        this.trendingTabNum = -2;
        this.hasChatStickers = false;
        this.stickersTabOffset = 0;
        int currentPosition = this.stickersTab.getCurrentPosition();
        this.stickersTab.beginUpdate((getParent() == null || getVisibility() != 0 || (this.installingStickerSets.size() == 0 && this.removingStickerSets.size() == 0)) ? false : true);
        MediaDataController mediaDataController = MediaDataController.getInstance(this.currentAccount);
        SharedPreferences emojiSettings = MessagesController.getEmojiSettings(this.currentAccount);
        this.featuredStickerSets.clear();
        ArrayList<TLRPC$StickerSetCovered> featuredStickerSets = mediaDataController.getFeaturedStickerSets();
        int size = featuredStickerSets.size();
        for (int i = 0; i < size; i++) {
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered = featuredStickerSets.get(i);
            if (!mediaDataController.isStickerPackInstalled(tLRPC$StickerSetCovered.set.id)) {
                this.featuredStickerSets.add(tLRPC$StickerSetCovered);
            }
        }
        TrendingAdapter trendingAdapter = this.trendingAdapter;
        if (trendingAdapter != null) {
            trendingAdapter.notifyDataSetChanged();
        }
        if (!featuredStickerSets.isEmpty() && (this.featuredStickerSets.isEmpty() || emojiSettings.getLong("featured_hidden", 0L) == featuredStickerSets.get(0).set.id)) {
            int i2 = mediaDataController.getUnreadStickerSets().isEmpty() ? 2 : 3;
            StickerTabView stickerTabViewAddStickerIconTab = this.stickersTab.addStickerIconTab(i2, this.stickerIcons[i2]);
            stickerTabViewAddStickerIconTab.textView.setText(LocaleController.getString("FeaturedStickersShort", R.string.FeaturedStickersShort));
            stickerTabViewAddStickerIconTab.setContentDescription(LocaleController.getString("FeaturedStickers", R.string.FeaturedStickers));
            int i3 = this.stickersTabOffset;
            this.trendingTabNum = i3;
            this.stickersTabOffset = i3 + 1;
        }
        if (!this.favouriteStickers.isEmpty()) {
            int i4 = this.stickersTabOffset;
            this.favTabBum = i4;
            this.stickersTabOffset = i4 + 1;
            StickerTabView stickerTabViewAddStickerIconTab2 = this.stickersTab.addStickerIconTab(1, this.stickerIcons[1]);
            stickerTabViewAddStickerIconTab2.textView.setText(LocaleController.getString("FavoriteStickersShort", R.string.FavoriteStickersShort));
            stickerTabViewAddStickerIconTab2.setContentDescription(LocaleController.getString("FavoriteStickers", R.string.FavoriteStickers));
        }
        if (!this.recentStickers.isEmpty()) {
            int i5 = this.stickersTabOffset;
            this.recentTabBum = i5;
            this.stickersTabOffset = i5 + 1;
            StickerTabView stickerTabViewAddStickerIconTab3 = this.stickersTab.addStickerIconTab(0, this.stickerIcons[0]);
            stickerTabViewAddStickerIconTab3.textView.setText(LocaleController.getString("RecentStickersShort", R.string.RecentStickersShort));
            stickerTabViewAddStickerIconTab3.setContentDescription(LocaleController.getString("RecentStickers", R.string.RecentStickers));
        }
        this.stickerSets.clear();
        this.groupStickerSet = null;
        this.groupStickerPackPosition = -1;
        this.groupStickerPackNum = -10;
        ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = mediaDataController.getStickerSets(0);
        int i6 = 0;
        while (true) {
            TLRPC$StickerSetCovered[] tLRPC$StickerSetCoveredArr = this.primaryInstallingStickerSets;
            if (i6 >= tLRPC$StickerSetCoveredArr.length) {
                break;
            }
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered2 = tLRPC$StickerSetCoveredArr[i6];
            if (tLRPC$StickerSetCovered2 != null) {
                TLRPC$TL_messages_stickerSet stickerSetById = mediaDataController.getStickerSetById(tLRPC$StickerSetCovered2.set.id);
                if (stickerSetById != null && !stickerSetById.set.archived) {
                    this.primaryInstallingStickerSets[i6] = null;
                } else {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = new TLRPC$TL_messages_stickerSet();
                    tLRPC$TL_messages_stickerSet.set = tLRPC$StickerSetCovered2.set;
                    TLRPC$Document tLRPC$Document = tLRPC$StickerSetCovered2.cover;
                    if (tLRPC$Document != null) {
                        tLRPC$TL_messages_stickerSet.documents.add(tLRPC$Document);
                    } else if (!tLRPC$StickerSetCovered2.covers.isEmpty()) {
                        tLRPC$TL_messages_stickerSet.documents.addAll(tLRPC$StickerSetCovered2.covers);
                    }
                    if (!tLRPC$TL_messages_stickerSet.documents.isEmpty()) {
                        this.stickerSets.add(tLRPC$TL_messages_stickerSet);
                    }
                }
            }
            i6++;
        }
        for (int i7 = 0; i7 < stickerSets.size(); i7++) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2 = stickerSets.get(i7);
            if (!tLRPC$TL_messages_stickerSet2.set.archived && (arrayList2 = tLRPC$TL_messages_stickerSet2.documents) != null && !arrayList2.isEmpty()) {
                this.stickerSets.add(tLRPC$TL_messages_stickerSet2);
            }
        }
        if (this.info != null) {
            long j = MessagesController.getEmojiSettings(this.currentAccount).getLong("group_hide_stickers_" + this.info.id, -1L);
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.info.id));
            if (chat == null || this.info.stickerset == null || !ChatObject.hasAdminRights(chat)) {
                this.groupStickersHidden = j != -1;
            } else {
                TLRPC$StickerSet tLRPC$StickerSet = this.info.stickerset;
                if (tLRPC$StickerSet != null) {
                    this.groupStickersHidden = j == tLRPC$StickerSet.id;
                }
            }
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            TLRPC$StickerSet tLRPC$StickerSet2 = tLRPC$ChatFull.stickerset;
            if (tLRPC$StickerSet2 != null) {
                TLRPC$TL_messages_stickerSet groupStickerSetById = mediaDataController.getGroupStickerSetById(tLRPC$StickerSet2);
                if (groupStickerSetById != null && (arrayList = groupStickerSetById.documents) != null && !arrayList.isEmpty() && groupStickerSetById.set != null) {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet3 = new TLRPC$TL_messages_stickerSet();
                    tLRPC$TL_messages_stickerSet3.documents = groupStickerSetById.documents;
                    tLRPC$TL_messages_stickerSet3.packs = groupStickerSetById.packs;
                    tLRPC$TL_messages_stickerSet3.set = groupStickerSetById.set;
                    if (this.groupStickersHidden) {
                        this.groupStickerPackNum = this.stickerSets.size();
                        this.stickerSets.add(tLRPC$TL_messages_stickerSet3);
                    } else {
                        this.groupStickerPackNum = 0;
                        this.stickerSets.add(0, tLRPC$TL_messages_stickerSet3);
                    }
                    this.groupStickerSet = this.info.can_set_stickers ? tLRPC$TL_messages_stickerSet3 : null;
                }
            } else if (tLRPC$ChatFull.can_set_stickers) {
                TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet4 = new TLRPC$TL_messages_stickerSet();
                if (this.groupStickersHidden) {
                    this.groupStickerPackNum = this.stickerSets.size();
                    this.stickerSets.add(tLRPC$TL_messages_stickerSet4);
                } else {
                    this.groupStickerPackNum = 0;
                    this.stickerSets.add(0, tLRPC$TL_messages_stickerSet4);
                }
            }
        }
        int i8 = 0;
        while (i8 < this.stickerSets.size()) {
            if (i8 == this.groupStickerPackNum) {
                TLRPC$Chat chat2 = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.info.id));
                if (chat2 == null) {
                    this.stickerSets.remove(0);
                    i8--;
                } else {
                    this.hasChatStickers = true;
                    this.stickersTab.addStickerTab(chat2);
                }
            } else {
                TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet5 = this.stickerSets.get(i8);
                TLRPC$Document tLRPC$Document2 = tLRPC$TL_messages_stickerSet5.documents.get(0);
                TLObject closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_messages_stickerSet5.set.thumbs, 90);
                if (closestPhotoSizeWithSize == null) {
                    closestPhotoSizeWithSize = tLRPC$Document2;
                }
                this.stickersTab.addStickerTab(closestPhotoSizeWithSize, tLRPC$Document2, tLRPC$TL_messages_stickerSet5).setContentDescription(tLRPC$TL_messages_stickerSet5.set.title + ", " + LocaleController.getString("AccDescrStickerSet", R.string.AccDescrStickerSet));
            }
            i8++;
        }
        this.stickersTab.commitUpdate();
        this.stickersTab.updateTabStyles();
        if (currentPosition != 0) {
            this.stickersTab.onPageScrolled(currentPosition, currentPosition);
        }
        checkPanels();
    }

    private void checkPanels() {
        int iFindFirstVisibleItemPosition;
        if (this.stickersTab == null || (iFindFirstVisibleItemPosition = this.stickersLayoutManager.findFirstVisibleItemPosition()) == -1) {
            return;
        }
        int i = this.favTabBum;
        if (i <= 0 && (i = this.recentTabBum) <= 0) {
            i = this.stickersTabOffset;
        }
        this.stickersTab.onPageScrolled(this.stickersGridAdapter.getTabForPosition(iFindFirstVisibleItemPosition), i);
    }

    private void updateGifTabs() {
        int i;
        int currentPosition = this.gifTabs.getCurrentPosition();
        int i2 = this.gifRecentTabNum;
        boolean z = currentPosition == i2;
        boolean z2 = i2 >= 0;
        boolean z3 = !this.recentGifs.isEmpty();
        this.gifTabs.beginUpdate(false);
        this.gifRecentTabNum = -2;
        this.gifTrendingTabNum = -2;
        this.gifFirstEmojiTabNum = -2;
        if (z3) {
            this.gifRecentTabNum = 0;
            this.gifTabs.addIconTab(0, this.gifIcons[0]).setContentDescription(LocaleController.getString("RecentStickers", R.string.RecentStickers));
            i = 1;
        } else {
            i = 0;
        }
        this.gifTrendingTabNum = i;
        this.gifFirstEmojiTabNum = i + 1;
        AndroidUtilities.dp(13.0f);
        AndroidUtilities.dp(11.0f);
        this.gifTabs.commitUpdate();
        this.gifTabs.updateTabStyles();
        if (z && !z3) {
            this.gifTabs.selectTab(this.gifTrendingTabNum);
            return;
        }
        if (ViewCompat.isLaidOut(this.gifTabs)) {
            if (z3 && !z2) {
                this.gifTabs.onPageScrolled(currentPosition + 1, 0);
            } else {
                if (z3 || !z2) {
                    return;
                }
                this.gifTabs.onPageScrolled(currentPosition - 1, 0);
            }
        }
    }

    public void addRecentSticker(TLRPC$Document document) {
        if (document == null) {
            return;
        }
        MediaDataController.getInstance(this.currentAccount).addRecentSticker(0, null, document, (int) (System.currentTimeMillis() / 1000), false);
        boolean zIsEmpty = this.recentStickers.isEmpty();
        this.recentStickers = MediaDataController.getInstance(this.currentAccount).getRecentStickers(0);
        StickersGridAdapter stickersGridAdapter = this.stickersGridAdapter;
        if (stickersGridAdapter != null) {
            stickersGridAdapter.notifyDataSetChanged();
        }
        if (zIsEmpty) {
            updateStickerTabs();
        }
    }

    public void addRecentGif(TLRPC$Document document) {
        if (document == null) {
            return;
        }
        boolean zIsEmpty = this.recentGifs.isEmpty();
        updateRecentGifs();
        if (zIsEmpty) {
            updateStickerTabs();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.isLayout) {
            return;
        }
        super.requestLayout();
    }

    public void updateColors() {
        SearchField searchField;
        if (AndroidUtilities.isInMultiwindow || this.forseMultiwindowLayout) {
            Drawable background = getBackground();
            if (background != null) {
                background.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelBackground"), PorterDuff.Mode.MULTIPLY));
            }
        } else {
            setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
            if (this.needEmojiSearch) {
                this.bottomTabContainerBackground.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
            }
        }
        ScrollSlidingTabStrip scrollSlidingTabStrip = this.emojiTabs;
        if (scrollSlidingTabStrip != null) {
            scrollSlidingTabStrip.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
            this.emojiTabsShadow.setBackgroundColor(getThemedColor("chat_emojiPanelShadowLine"));
        }
        EmojiColorPickerView emojiColorPickerView = this.pickerView;
        if (emojiColorPickerView != null) {
            Theme.setDrawableColor(emojiColorPickerView.backgroundDrawable, getThemedColor("dialogBackground"));
            Theme.setDrawableColor(this.pickerView.arrowDrawable, getThemedColor("dialogBackground"));
        }
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                searchField = this.stickersSearchField;
            } else if (i == 1) {
                searchField = this.emojiSearchField;
            } else {
                searchField = this.gifSearchField;
            }
            if (searchField != null) {
                searchField.backgroundView.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
                searchField.shadowView.setBackgroundColor(getThemedColor("chat_emojiPanelShadowLine"));
                searchField.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiSearchIcon"), PorterDuff.Mode.MULTIPLY));
                searchField.searchIconImageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiSearchIcon"), PorterDuff.Mode.MULTIPLY));
                Theme.setDrawableColorByKey(searchField.searchBackground.getBackground(), "chat_emojiSearchBackground");
                searchField.searchBackground.invalidate();
                searchField.searchEditText.setHintTextColor(getThemedColor("chat_emojiSearchIcon"));
                searchField.searchEditText.setTextColor(getThemedColor("windowBackgroundWhiteBlackText"));
            }
        }
        Paint paint = this.dotPaint;
        if (paint != null) {
            paint.setColor(getThemedColor("chat_emojiPanelNewTrending"));
        }
        RecyclerListView recyclerListView = this.emojiGridView;
        if (recyclerListView != null) {
            recyclerListView.setGlowColor(getThemedColor("chat_emojiPanelBackground"));
        }
        RecyclerListView recyclerListView2 = this.stickersGridView;
        if (recyclerListView2 != null) {
            recyclerListView2.setGlowColor(getThemedColor("chat_emojiPanelBackground"));
        }
        ScrollSlidingTabStrip scrollSlidingTabStrip2 = this.stickersTab;
        if (scrollSlidingTabStrip2 != null) {
            scrollSlidingTabStrip2.setIndicatorColor(getThemedColor("chat_emojiPanelStickerPackSelectorLine"));
            this.stickersTab.setUnderlineColor(getThemedColor("chat_emojiPanelShadowLine"));
            this.stickersTab.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
        }
        ScrollSlidingTabStrip scrollSlidingTabStrip3 = this.gifTabs;
        if (scrollSlidingTabStrip3 != null) {
            scrollSlidingTabStrip3.setIndicatorColor(getThemedColor("chat_emojiPanelStickerPackSelectorLine"));
            this.gifTabs.setUnderlineColor(getThemedColor("chat_emojiPanelShadowLine"));
            this.gifTabs.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
        }
        ImageView imageView = this.backspaceButton;
        if (imageView != null) {
            imageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelBackspace"), PorterDuff.Mode.MULTIPLY));
            if (this.emojiSearchField == null) {
                Theme.setSelectorDrawableColor(this.backspaceButton.getBackground(), getThemedColor("chat_emojiPanelBackground"), false);
                Theme.setSelectorDrawableColor(this.backspaceButton.getBackground(), getThemedColor("chat_emojiPanelBackground"), true);
            }
        }
        ImageView imageView2 = this.stickerSettingsButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelBackspace"), PorterDuff.Mode.MULTIPLY));
        }
        ImageView imageView3 = this.searchButton;
        if (imageView3 != null) {
            imageView3.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelBackspace"), PorterDuff.Mode.MULTIPLY));
        }
        View view = this.shadowLine;
        if (view != null) {
            view.setBackgroundColor(getThemedColor("chat_emojiPanelShadowLine"));
        }
        TextView textView = this.mediaBanTooltip;
        if (textView != null) {
            ((ShapeDrawable) textView.getBackground()).getPaint().setColor(getThemedColor("chat_gifSaveHintBackground"));
            this.mediaBanTooltip.setTextColor(getThemedColor("chat_gifSaveHintText"));
        }
        GifAdapter gifAdapter = this.gifSearchAdapter;
        if (gifAdapter != null) {
            gifAdapter.progressEmptyView.imageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelEmptyText"), PorterDuff.Mode.MULTIPLY));
            this.gifSearchAdapter.progressEmptyView.textView.setTextColor(getThemedColor("chat_emojiPanelEmptyText"));
            this.gifSearchAdapter.progressEmptyView.progressView.setProgressColor(getThemedColor("progressCircle"));
        }
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.tabIcons;
            if (i2 >= drawableArr.length) {
                break;
            }
            Theme.setEmojiDrawableColor(drawableArr[i2], getThemedColor("chat_emojiBottomPanelIcon"), false);
            Theme.setEmojiDrawableColor(this.tabIcons[i2], getThemedColor("chat_emojiPanelIconSelected"), true);
            i2++;
        }
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr2 = this.emojiIcons;
            if (i3 >= drawableArr2.length) {
                break;
            }
            Theme.setEmojiDrawableColor(drawableArr2[i3], getThemedColor("chat_emojiPanelIcon"), false);
            Theme.setEmojiDrawableColor(this.emojiIcons[i3], getThemedColor("chat_emojiPanelIconSelected"), true);
            i3++;
        }
        int i4 = 0;
        while (true) {
            Drawable[] drawableArr3 = this.stickerIcons;
            if (i4 >= drawableArr3.length) {
                break;
            }
            Theme.setEmojiDrawableColor(drawableArr3[i4], getThemedColor("chat_emojiPanelIcon"), false);
            Theme.setEmojiDrawableColor(this.stickerIcons[i4], getThemedColor("chat_emojiPanelIconSelected"), true);
            i4++;
        }
        int i5 = 0;
        while (true) {
            Drawable[] drawableArr4 = this.gifIcons;
            if (i5 >= drawableArr4.length) {
                break;
            }
            Theme.setEmojiDrawableColor(drawableArr4[i5], getThemedColor("chat_emojiPanelIcon"), false);
            Theme.setEmojiDrawableColor(this.gifIcons[i5], getThemedColor("chat_emojiPanelIconSelected"), true);
            i5++;
        }
        Drawable drawable = this.searchIconDrawable;
        if (drawable != null) {
            Theme.setEmojiDrawableColor(drawable, getThemedColor("chat_emojiBottomPanelIcon"), false);
            Theme.setEmojiDrawableColor(this.searchIconDrawable, getThemedColor("chat_emojiPanelIconSelected"), true);
        }
        Drawable drawable2 = this.searchIconDotDrawable;
        if (drawable2 != null) {
            Theme.setEmojiDrawableColor(drawable2, getThemedColor("chat_emojiPanelStickerPackSelectorLine"), false);
            Theme.setEmojiDrawableColor(this.searchIconDotDrawable, getThemedColor("chat_emojiPanelStickerPackSelectorLine"), true);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.isLayout = true;
        if (AndroidUtilities.isInMultiwindow || this.forseMultiwindowLayout) {
            if (this.currentBackgroundType != 1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    setOutlineProvider((ViewOutlineProvider) this.outlineProvider);
                    setClipToOutline(true);
                    setElevation(AndroidUtilities.dp(2.0f));
                }
                setBackgroundResource(R.drawable.smiles_popup);
                getBackground().setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelBackground"), PorterDuff.Mode.MULTIPLY));
                if (this.needEmojiSearch) {
                    this.bottomTabContainerBackground.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
                }
                this.currentBackgroundType = 1;
            }
        } else if (this.currentBackgroundType != 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOutlineProvider(null);
                setClipToOutline(false);
                setElevation(0.0f);
            }
            setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
            if (this.needEmojiSearch) {
                this.bottomTabContainerBackground.setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
            }
            this.currentBackgroundType = 0;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 1073741824));
        this.isLayout = false;
        setTranslationY(getTranslationY());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = right - left;
        if (this.lastNotifyWidth != i) {
            this.lastNotifyWidth = i;
            reloadStickersAdapter();
        }
        View view = (View) getParent();
        if (view != null) {
            int i2 = bottom - top;
            int height = view.getHeight();
            if (this.lastNotifyHeight != i2 || this.lastNotifyHeight2 != height) {
                EmojiViewDelegate emojiViewDelegate = this.delegate;
                if (emojiViewDelegate != null && emojiViewDelegate.isSearchOpened()) {
                    this.bottomTabContainer.setTranslationY(AndroidUtilities.dp(49.0f));
                } else if (this.bottomTabContainer.getTag() == null) {
                    if (i2 <= this.lastNotifyHeight) {
                        this.bottomTabContainer.setTranslationY(0.0f);
                    } else {
                        float y = (getY() + getMeasuredHeight()) - view.getHeight();
                        if (this.bottomTabContainer.getTop() - y < 0.0f) {
                            y = this.bottomTabContainer.getTop();
                        }
                        this.bottomTabContainer.setTranslationY(-y);
                    }
                }
                this.lastNotifyHeight = i2;
                this.lastNotifyHeight2 = height;
            }
        }
        super.onLayout(changed, left, top, right, bottom);
        updateStickerTabsPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadStickersAdapter() {
        StickersGridAdapter stickersGridAdapter = this.stickersGridAdapter;
        if (stickersGridAdapter != null) {
            stickersGridAdapter.notifyDataSetChanged();
        }
        StickersSearchGridAdapter stickersSearchGridAdapter = this.stickersSearchGridAdapter;
        if (stickersSearchGridAdapter != null) {
            stickersSearchGridAdapter.notifyDataSetChanged();
        }
        if (ContentPreviewViewer.getInstance().isVisible()) {
            ContentPreviewViewer.getInstance().close();
        }
        ContentPreviewViewer.getInstance().reset();
    }

    public void setDelegate(EmojiViewDelegate emojiViewDelegate) {
        this.delegate = emojiViewDelegate;
    }

    public void setDragListener(DragListener listener) {
        this.dragListener = listener;
    }

    public void setChatInfo(TLRPC$ChatFull chatInfo) {
        this.info = chatInfo;
        updateStickerTabs();
    }

    public void invalidateViews() {
        this.emojiGridView.invalidateViews();
    }

    public void setForseMultiwindowLayout(boolean value) {
        this.forseMultiwindowLayout = value;
    }

    public void onOpen(boolean forceEmoji) {
        if (this.currentPage != 0 && this.currentChatId != 0) {
            this.currentPage = 0;
        }
        if (this.currentPage == 0 || forceEmoji || this.views.size() == 1) {
            showBackspaceButton(true, false);
            showStickerSettingsButton(false, false);
            if (this.pager.getCurrentItem() != 0) {
                this.pager.setCurrentItem(0, !forceEmoji);
                return;
            }
            return;
        }
        int i = this.currentPage;
        if (i != 1) {
            if (i == 2) {
                showBackspaceButton(false, false);
                showStickerSettingsButton(false, false);
                if (this.pager.getCurrentItem() != 1) {
                    this.pager.setCurrentItem(1, false);
                }
                ScrollSlidingTabStrip scrollSlidingTabStrip = this.gifTabs;
                if (scrollSlidingTabStrip != null) {
                    scrollSlidingTabStrip.selectTab(0);
                    return;
                }
                return;
            }
            return;
        }
        showBackspaceButton(false, false);
        showStickerSettingsButton(false, false);
        if (this.pager.getCurrentItem() != 2) {
            this.pager.setCurrentItem(2, false);
        }
        ScrollSlidingTabStrip scrollSlidingTabStrip2 = this.stickersTab;
        if (scrollSlidingTabStrip2 != null) {
            this.firstTabUpdate = true;
            int i2 = this.favTabBum;
            if (i2 >= 0) {
                scrollSlidingTabStrip2.selectTab(i2);
            } else {
                int i3 = this.recentTabBum;
                if (i3 >= 0) {
                    scrollSlidingTabStrip2.selectTab(i3);
                } else {
                    scrollSlidingTabStrip2.selectTab(this.stickersTabOffset);
                }
            }
            this.firstTabUpdate = false;
            this.stickersLayoutManager.scrollToPositionWithOffset(1, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.newEmojiSuggestionsAvailable);
        if (this.stickersGridAdapter != null) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersDidLoad);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.recentDocumentsDidLoad);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.featuredStickersDidLoad);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.groupStickersDidLoad);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$OUZazEZvdhUNJL91EgtS3tQHTNg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAttachedToWindow$10$EmojiView();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onAttachedToWindow$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onAttachedToWindow$10$EmojiView() {
        updateStickerTabs();
        reloadStickersAdapter();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility != 8) {
            Emoji.sortEmoji();
            this.emojiAdapter.notifyDataSetChanged();
            if (this.stickersGridAdapter != null) {
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersDidLoad);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.recentDocumentsDidLoad);
                updateStickerTabs();
                reloadStickersAdapter();
            }
            checkDocuments(true);
            checkDocuments(false);
            MediaDataController.getInstance(this.currentAccount).loadRecents(0, true, true, false);
            MediaDataController.getInstance(this.currentAccount).loadRecents(0, false, true, false);
            MediaDataController.getInstance(this.currentAccount).loadRecents(2, false, true, false);
        }
        ChooseStickerActionTracker chooseStickerActionTracker = this.chooseStickerActionTracker;
        if (chooseStickerActionTracker != null) {
            chooseStickerActionTracker.checkVisibility();
        }
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void onDestroy() {
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.newEmojiSuggestionsAvailable);
        if (this.stickersGridAdapter != null) {
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.stickersDidLoad);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.recentDocumentsDidLoad);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.featuredStickersDidLoad);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.groupStickersDidLoad);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EmojiPopupWindow emojiPopupWindow = this.pickerViewPopup;
        if (emojiPopupWindow == null || !emojiPopupWindow.isShowing()) {
            return;
        }
        this.pickerViewPopup.dismiss();
    }

    private void checkDocuments(boolean isGif) {
        if (isGif) {
            updateRecentGifs();
            return;
        }
        int size = this.recentStickers.size();
        int size2 = this.favouriteStickers.size();
        this.recentStickers = MediaDataController.getInstance(this.currentAccount).getRecentStickers(0);
        this.favouriteStickers = MediaDataController.getInstance(this.currentAccount).getRecentStickers(2);
        for (int i = 0; i < this.favouriteStickers.size(); i++) {
            TLRPC$Document tLRPC$Document = this.favouriteStickers.get(i);
            int i2 = 0;
            while (true) {
                if (i2 < this.recentStickers.size()) {
                    TLRPC$Document tLRPC$Document2 = this.recentStickers.get(i2);
                    if (tLRPC$Document2.dc_id == tLRPC$Document.dc_id && tLRPC$Document2.id == tLRPC$Document.id) {
                        this.recentStickers.remove(i2);
                        break;
                    }
                    i2++;
                }
            }
        }
        if (size != this.recentStickers.size() || size2 != this.favouriteStickers.size()) {
            updateStickerTabs();
        }
        StickersGridAdapter stickersGridAdapter = this.stickersGridAdapter;
        if (stickersGridAdapter != null) {
            stickersGridAdapter.notifyDataSetChanged();
        }
        checkPanels();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecentGifs() {
        GifAdapter gifAdapter;
        int size = this.recentGifs.size();
        long jCalcDocumentsHash = MediaDataController.calcDocumentsHash(this.recentGifs, ConnectionsManager.DEFAULT_DATACENTER_ID);
        ArrayList<TLRPC$Document> recentGifs = MediaDataController.getInstance(this.currentAccount).getRecentGifs();
        this.recentGifs = recentGifs;
        long jCalcDocumentsHash2 = MediaDataController.calcDocumentsHash(recentGifs, ConnectionsManager.DEFAULT_DATACENTER_ID);
        if ((this.gifTabs != null && size == 0 && !this.recentGifs.isEmpty()) || (size != 0 && this.recentGifs.isEmpty())) {
            updateGifTabs();
        }
        if ((size == this.recentGifs.size() && jCalcDocumentsHash == jCalcDocumentsHash2) || (gifAdapter = this.gifAdapter) == null) {
            return;
        }
        gifAdapter.notifyDataSetChanged();
    }

    public void setStickersBanned(boolean value, long chatId) throws Resources.NotFoundException {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.typeTabs;
        if (pagerSlidingTabStrip == null) {
            return;
        }
        if (value) {
            this.currentChatId = chatId;
        } else {
            this.currentChatId = 0L;
        }
        View tab = pagerSlidingTabStrip.getTab(2);
        if (tab != null) {
            tab.setAlpha(this.currentChatId != 0 ? 0.5f : 1.0f);
            if (this.currentChatId == 0 || this.pager.getCurrentItem() == 0) {
                return;
            }
            showBackspaceButton(true, true);
            showStickerSettingsButton(false, true);
            this.pager.setCurrentItem(0, false);
        }
    }

    public void showStickerBanHint(boolean gif) {
        TLRPC$Chat chat;
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        if (this.mediaBanTooltip.getVisibility() == 0 || (chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.currentChatId))) == null) {
            return;
        }
        if (ChatObject.hasAdminRights(chat) || (tLRPC$TL_chatBannedRights = chat.default_banned_rights) == null || !tLRPC$TL_chatBannedRights.send_stickers) {
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = chat.banned_rights;
            if (tLRPC$TL_chatBannedRights2 == null) {
                return;
            }
            if (AndroidUtilities.isBannedForever(tLRPC$TL_chatBannedRights2)) {
                if (gif) {
                    this.mediaBanTooltip.setText(LocaleController.getString("AttachGifRestrictedForever", R.string.AttachGifRestrictedForever));
                } else {
                    this.mediaBanTooltip.setText(LocaleController.getString("AttachStickersRestrictedForever", R.string.AttachStickersRestrictedForever));
                }
            } else if (gif) {
                this.mediaBanTooltip.setText(LocaleController.formatString("AttachGifRestricted", R.string.AttachGifRestricted, LocaleController.formatDateForBan(chat.banned_rights.until_date)));
            } else {
                this.mediaBanTooltip.setText(LocaleController.formatString("AttachStickersRestricted", R.string.AttachStickersRestricted, LocaleController.formatDateForBan(chat.banned_rights.until_date)));
            }
        } else if (gif) {
            this.mediaBanTooltip.setText(LocaleController.getString("GlobalAttachGifRestricted", R.string.GlobalAttachGifRestricted));
        } else {
            this.mediaBanTooltip.setText(LocaleController.getString("GlobalAttachStickersRestricted", R.string.GlobalAttachStickersRestricted));
        }
        this.mediaBanTooltip.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.mediaBanTooltip, (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f));
        animatorSet.addListener(new AnonymousClass36());
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    /* renamed from: ir.eitaa.ui.Components.EmojiView$36, reason: invalid class name */
    class AnonymousClass36 extends AnimatorListenerAdapter {
        AnonymousClass36() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$36$BAXsLCxjppvcHgJ-OUcBjd-inic
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0$EmojiView$36();
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$EmojiView$36() {
            if (EmojiView.this.mediaBanTooltip == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(EmojiView.this.mediaBanTooltip, (Property<TextView, Float>) View.ALPHA, 0.0f));
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmojiView.36.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation1) {
                    if (EmojiView.this.mediaBanTooltip != null) {
                        EmojiView.this.mediaBanTooltip.setVisibility(4);
                    }
                }
            });
            animatorSet.setDuration(300L);
            animatorSet.start();
        }
    }

    private void updateVisibleTrendingSets() {
        boolean z;
        RecyclerListView recyclerListView = this.stickersGridView;
        if (recyclerListView == null) {
            return;
        }
        try {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.stickersGridView.getChildAt(i);
                if ((childAt instanceof FeaturedStickerSetInfoCell) && ((RecyclerListView.Holder) this.stickersGridView.getChildViewHolder(childAt)) != null) {
                    FeaturedStickerSetInfoCell featuredStickerSetInfoCell = (FeaturedStickerSetInfoCell) childAt;
                    ArrayList<Long> unreadStickerSets = MediaDataController.getInstance(this.currentAccount).getUnreadStickerSets();
                    TLRPC$StickerSetCovered stickerSet = featuredStickerSetInfoCell.getStickerSet();
                    boolean z2 = unreadStickerSets != null && unreadStickerSets.contains(Long.valueOf(stickerSet.set.id));
                    int i2 = 0;
                    while (true) {
                        TLRPC$StickerSetCovered[] tLRPC$StickerSetCoveredArr = this.primaryInstallingStickerSets;
                        if (i2 >= tLRPC$StickerSetCoveredArr.length) {
                            z = false;
                            break;
                        } else {
                            if (tLRPC$StickerSetCoveredArr[i2] != null && tLRPC$StickerSetCoveredArr[i2].set.id == stickerSet.set.id) {
                                z = true;
                                break;
                            }
                            i2++;
                        }
                    }
                    featuredStickerSetInfoCell.setStickerSet(stickerSet, z2, true, 0, 0, z);
                    if (z2) {
                        MediaDataController.getInstance(this.currentAccount).markFaturedStickersByIdAsRead(stickerSet.set.id);
                    }
                    boolean z3 = this.installingStickerSets.indexOfKey(stickerSet.set.id) >= 0;
                    boolean z4 = this.removingStickerSets.indexOfKey(stickerSet.set.id) >= 0;
                    if (z3 || z4) {
                        if (z3 && featuredStickerSetInfoCell.isInstalled()) {
                            this.installingStickerSets.remove(stickerSet.set.id);
                            z3 = false;
                        } else if (z4 && !featuredStickerSetInfoCell.isInstalled()) {
                            this.removingStickerSets.remove(stickerSet.set.id);
                        }
                    }
                    featuredStickerSetInfoCell.setAddDrawProgress(!z && z3, true);
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public boolean areThereAnyStickers() {
        StickersGridAdapter stickersGridAdapter = this.stickersGridAdapter;
        return stickersGridAdapter != null && stickersGridAdapter.getItemCount() > 0;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        TLRPC$StickerSet tLRPC$StickerSet;
        int i = 0;
        if (id == NotificationCenter.stickersDidLoad) {
            if (((Integer) args[0]).intValue() == 0) {
                updateStickerTabs();
                updateVisibleTrendingSets();
                reloadStickersAdapter();
                checkPanels();
                return;
            }
            return;
        }
        if (id == NotificationCenter.recentDocumentsDidLoad) {
            boolean zBooleanValue = ((Boolean) args[0]).booleanValue();
            int iIntValue = ((Integer) args[1]).intValue();
            if (zBooleanValue || iIntValue == 0 || iIntValue == 2) {
                checkDocuments(zBooleanValue);
                return;
            }
            return;
        }
        if (id == NotificationCenter.featuredStickersDidLoad) {
            updateVisibleTrendingSets();
            PagerSlidingTabStrip pagerSlidingTabStrip = this.typeTabs;
            if (pagerSlidingTabStrip != null) {
                int childCount = pagerSlidingTabStrip.getChildCount();
                while (i < childCount) {
                    this.typeTabs.getChildAt(i).invalidate();
                    i++;
                }
            }
            updateStickerTabs();
            return;
        }
        if (id == NotificationCenter.groupStickersDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            if (tLRPC$ChatFull == null || (tLRPC$StickerSet = tLRPC$ChatFull.stickerset) == null || tLRPC$StickerSet.id != ((Long) args[0]).longValue()) {
                return;
            }
            updateStickerTabs();
            return;
        }
        if (id == NotificationCenter.emojiLoaded) {
            RecyclerListView recyclerListView = this.stickersGridView;
            if (recyclerListView != null) {
                int childCount2 = recyclerListView.getChildCount();
                while (i < childCount2) {
                    View childAt = this.stickersGridView.getChildAt(i);
                    if ((childAt instanceof StickerSetNameCell) || (childAt instanceof StickerEmojiCell)) {
                        childAt.invalidate();
                    }
                    i++;
                }
            }
            EmojiColorPickerView emojiColorPickerView = this.pickerView;
            if (emojiColorPickerView != null) {
                emojiColorPickerView.invalidate();
            }
            ScrollSlidingTabStrip scrollSlidingTabStrip = this.gifTabs;
            if (scrollSlidingTabStrip != null) {
                scrollSlidingTabStrip.invalidateTabs();
                return;
            }
            return;
        }
        if (id == NotificationCenter.newEmojiSuggestionsAvailable && this.emojiGridView != null && this.needEmojiSearch) {
            if ((this.emojiSearchField.progressDrawable.isAnimating() || this.emojiGridView.getAdapter() == this.emojiSearchAdapter) && !TextUtils.isEmpty(this.emojiSearchAdapter.lastSearchEmojiString)) {
                EmojiSearchAdapter emojiSearchAdapter = this.emojiSearchAdapter;
                emojiSearchAdapter.search(emojiSearchAdapter.lastSearchEmojiString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    private class TrendingAdapter extends RecyclerListView.SelectionAdapter {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        private TrendingAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            BackupImageView backupImageView = new BackupImageView(EmojiView.this.getContext()) { // from class: ir.eitaa.ui.Components.EmojiView.TrendingAdapter.1
                @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
                protected void onDraw(Canvas canvas) {
                    super.onDraw(canvas);
                    if (!MediaDataController.getInstance(EmojiView.this.currentAccount).isStickerPackUnread(((TLRPC$StickerSetCovered) getTag()).set.id) || EmojiView.this.dotPaint == null) {
                        return;
                    }
                    canvas.drawCircle(canvas.getWidth() - AndroidUtilities.dp(8.0f), AndroidUtilities.dp(14.0f), AndroidUtilities.dp(3.0f), EmojiView.this.dotPaint);
                }
            };
            backupImageView.setSize(AndroidUtilities.dp(30.0f), AndroidUtilities.dp(30.0f));
            backupImageView.setLayerNum(1);
            backupImageView.setAspectFit(true);
            backupImageView.setLayoutParams(new RecyclerView.LayoutParams(AndroidUtilities.dp(52.0f), AndroidUtilities.dp(52.0f)));
            return new RecyclerListView.Holder(backupImageView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ImageLocation forSticker;
            BackupImageView backupImageView = (BackupImageView) holder.itemView;
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) EmojiView.this.featuredStickerSets.get(position);
            backupImageView.setTag(tLRPC$StickerSetCovered);
            TLRPC$Document tLRPC$Document = tLRPC$StickerSetCovered.cover;
            if (!tLRPC$StickerSetCovered.covers.isEmpty()) {
                tLRPC$Document = tLRPC$StickerSetCovered.covers.get(0);
            }
            Object closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$StickerSetCovered.set.thumbs, 90);
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(tLRPC$StickerSetCovered.set.thumbs, "emptyListPlaceholder", 0.2f);
            if (svgThumb != null) {
                svgThumb.overrideWidthAndHeight(Factory.DEVICE_USE_ANDROID_CAMCORDER, Factory.DEVICE_USE_ANDROID_CAMCORDER);
            }
            if (closestPhotoSizeWithSize == null) {
                closestPhotoSizeWithSize = tLRPC$Document;
            }
            boolean z = closestPhotoSizeWithSize instanceof TLRPC$Document;
            if (z) {
                forSticker = ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90), tLRPC$Document);
            } else if (!(closestPhotoSizeWithSize instanceof TLRPC$PhotoSize)) {
                return;
            } else {
                forSticker = ImageLocation.getForSticker((TLRPC$PhotoSize) closestPhotoSizeWithSize, tLRPC$Document, tLRPC$StickerSetCovered.set.thumb_version);
            }
            ImageLocation imageLocation = forSticker;
            if (imageLocation == null) {
                return;
            }
            if (z && MessageObject.isAnimatedStickerDocument(tLRPC$Document, true)) {
                if (svgThumb != null) {
                    backupImageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "30_30", svgThumb, 0, tLRPC$StickerSetCovered);
                    return;
                } else {
                    backupImageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "30_30", imageLocation, (String) null, 0, tLRPC$StickerSetCovered);
                    return;
                }
            }
            if (imageLocation.imageType == 1) {
                backupImageView.setImage(imageLocation, "30_30", "tgs", svgThumb, tLRPC$StickerSetCovered);
            } else {
                backupImageView.setImage(imageLocation, (String) null, "webp", svgThumb, tLRPC$StickerSetCovered);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return EmojiView.this.featuredStickerSets.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class StickersGridAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private int stickersPerRow;
        private int totalItems;
        private SparseArray<Object> rowStartPack = new SparseArray<>();
        private HashMap<Object, Integer> packStartPosition = new HashMap<>();
        private SparseArray<Object> cache = new SparseArray<>();
        private SparseArray<Object> cacheParents = new SparseArray<>();
        private SparseIntArray positionToRow = new SparseIntArray();

        public StickersGridAdapter(Context context) {
            this.context = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.itemView instanceof RecyclerListView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i = this.totalItems;
            if (i != 0) {
                return i + 1;
            }
            return 0;
        }

        public int getPositionForPack(Object pack) {
            Integer num = this.packStartPosition.get(pack);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == 0) {
                return 4;
            }
            Object obj = this.cache.get(position);
            if (obj == null) {
                return 1;
            }
            if (obj instanceof TLRPC$Document) {
                return 0;
            }
            if (!(obj instanceof String)) {
                return 2;
            }
            if ("trend1".equals(obj)) {
                return 5;
            }
            return "trend2".equals(obj) ? 6 : 3;
        }

        public int getTabForPosition(int position) {
            Object obj = this.cache.get(position);
            if ("search".equals(obj) || "trend1".equals(obj) || "trend2".equals(obj)) {
                if (EmojiView.this.favTabBum >= 0) {
                    return EmojiView.this.favTabBum;
                }
                if (EmojiView.this.recentTabBum >= 0) {
                    return EmojiView.this.recentTabBum;
                }
                return 0;
            }
            if (position == 0) {
                position = 1;
            }
            if (this.stickersPerRow == 0) {
                int measuredWidth = EmojiView.this.getMeasuredWidth();
                if (measuredWidth == 0) {
                    measuredWidth = AndroidUtilities.displaySize.x;
                }
                this.stickersPerRow = measuredWidth / AndroidUtilities.dp(72.0f);
            }
            int i = this.positionToRow.get(position, Integer.MIN_VALUE);
            if (i == Integer.MIN_VALUE) {
                return (EmojiView.this.stickerSets.size() - 1) + EmojiView.this.stickersTabOffset;
            }
            Object obj2 = this.rowStartPack.get(i);
            if (obj2 instanceof String) {
                return "recent".equals(obj2) ? EmojiView.this.recentTabBum : EmojiView.this.favTabBum;
            }
            return EmojiView.this.stickerSets.indexOf((TLRPC$TL_messages_stickerSet) obj2) + EmojiView.this.stickersTabOffset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$EmojiView$StickersGridAdapter(View view) {
            if (EmojiView.this.groupStickerSet != null) {
                if (EmojiView.this.delegate != null) {
                    EmojiView.this.delegate.onStickersGroupClick(EmojiView.this.info.id);
                    return;
                }
                return;
            }
            MessagesController.getEmojiSettings(EmojiView.this.currentAccount).edit().putLong("group_hide_stickers_" + EmojiView.this.info.id, EmojiView.this.info.stickerset != null ? EmojiView.this.info.stickerset.id : 0L).commit();
            EmojiView.this.updateStickerTabs();
            if (EmojiView.this.stickersGridAdapter != null) {
                EmojiView.this.stickersGridAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$1$EmojiView$StickersGridAdapter(View view) {
            if (EmojiView.this.delegate != null) {
                EmojiView.this.delegate.onStickersGroupClick(EmojiView.this.info.id);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$2$EmojiView$StickersGridAdapter(View view) {
            ArrayList<TLRPC$StickerSetCovered> featuredStickerSets = MediaDataController.getInstance(EmojiView.this.currentAccount).getFeaturedStickerSets();
            if (featuredStickerSets.isEmpty()) {
                return;
            }
            MessagesController.getEmojiSettings(EmojiView.this.currentAccount).edit().putLong("featured_hidden", featuredStickerSets.get(0).set.id).commit();
            if (EmojiView.this.stickersGridAdapter != null) {
                EmojiView.this.stickersGridAdapter.notifyItemRangeRemoved(1, 2);
            }
            EmojiView.this.updateStickerTabs();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View emptyCell = null;
            switch (i) {
                case 0:
                    emptyCell = new StickerEmojiCell(this.context, true) { // from class: ir.eitaa.ui.Components.EmojiView.StickersGridAdapter.1
                        @Override // android.widget.FrameLayout, android.view.View
                        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                        }
                    };
                    break;
                case 1:
                    emptyCell = new EmptyCell(this.context);
                    break;
                case 2:
                    StickerSetNameCell stickerSetNameCell = new StickerSetNameCell(this.context, false, EmojiView.this.resourcesProvider);
                    stickerSetNameCell.setOnIconClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$StickersGridAdapter$uI2_Vv6-zdwicpUeQmH3Ow3rSao
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$0$EmojiView$StickersGridAdapter(view);
                        }
                    });
                    emptyCell = stickerSetNameCell;
                    break;
                case 3:
                    StickerSetGroupInfoCell stickerSetGroupInfoCell = new StickerSetGroupInfoCell(this.context);
                    stickerSetGroupInfoCell.setAddOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$StickersGridAdapter$ZkcVxpBdpOJFjiWlTdfzvoJ5irA
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$1$EmojiView$StickersGridAdapter(view);
                        }
                    });
                    stickerSetGroupInfoCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    emptyCell = stickerSetGroupInfoCell;
                    break;
                case 4:
                    View view = new View(this.context);
                    view.setLayoutParams(new RecyclerView.LayoutParams(-1, EmojiView.this.searchFieldHeight));
                    emptyCell = view;
                    break;
                case 5:
                    StickerSetNameCell stickerSetNameCell2 = new StickerSetNameCell(this.context, false, EmojiView.this.resourcesProvider);
                    stickerSetNameCell2.setOnIconClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$StickersGridAdapter$AODNcG_IIIA3DUDTEwp5MfyFPUk
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$onCreateViewHolder$2$EmojiView$StickersGridAdapter(view2);
                        }
                    });
                    emptyCell = stickerSetNameCell2;
                    break;
                case 6:
                    RecyclerListView recyclerListView = new RecyclerListView(this.context) { // from class: ir.eitaa.ui.Components.EmojiView.StickersGridAdapter.2
                        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                        public boolean onInterceptTouchEvent(MotionEvent e) {
                            if (getParent() != null && getParent().getParent() != null) {
                                getParent().getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1) || canScrollHorizontally(1));
                                EmojiView.this.pager.requestDisallowInterceptTouchEvent(true);
                            }
                            return super.onInterceptTouchEvent(e);
                        }
                    };
                    recyclerListView.setSelectorRadius(AndroidUtilities.dp(4.0f));
                    recyclerListView.setSelectorDrawableColor(Theme.getColor("listSelectorSDK21"));
                    recyclerListView.setTag(9);
                    recyclerListView.setItemAnimator(null);
                    recyclerListView.setLayoutAnimation(null);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context) { // from class: ir.eitaa.ui.Components.EmojiView.StickersGridAdapter.3
                        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                        public boolean supportsPredictiveItemAnimations() {
                            return false;
                        }
                    };
                    linearLayoutManager.setOrientation(0);
                    recyclerListView.setLayoutManager(linearLayoutManager);
                    EmojiView emojiView = EmojiView.this;
                    recyclerListView.setAdapter(emojiView.trendingAdapter = new TrendingAdapter());
                    recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$StickersGridAdapter$eaRUiTVaGIWNWqi8D1IY6v4Gswo
                        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                        public final void onItemClick(View view2, int i2) {
                            this.f$0.lambda$onCreateViewHolder$3$EmojiView$StickersGridAdapter(view2, i2);
                        }
                    });
                    recyclerListView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(52.0f)));
                    emptyCell = recyclerListView;
                    break;
            }
            return new RecyclerListView.Holder(emptyCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$3$EmojiView$StickersGridAdapter(View view, int i) {
            EmojiView.this.openTrendingStickers((TLRPC$StickerSetCovered) view.getTag());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TLRPC$Document tLRPC$Document = (TLRPC$Document) this.cache.get(i);
                StickerEmojiCell stickerEmojiCell = (StickerEmojiCell) viewHolder.itemView;
                stickerEmojiCell.setSticker(tLRPC$Document, this.cacheParents.get(i), false);
                stickerEmojiCell.setRecent(EmojiView.this.recentStickers.contains(tLRPC$Document));
                return;
            }
            ArrayList<TLRPC$Document> arrayList = null;
            if (itemViewType == 1) {
                EmptyCell emptyCell = (EmptyCell) viewHolder.itemView;
                if (i == this.totalItems) {
                    int i2 = this.positionToRow.get(i - 1, Integer.MIN_VALUE);
                    if (i2 == Integer.MIN_VALUE) {
                        emptyCell.setHeight(1);
                        return;
                    }
                    Object obj = this.rowStartPack.get(i2);
                    if (obj instanceof TLRPC$TL_messages_stickerSet) {
                        arrayList = ((TLRPC$TL_messages_stickerSet) obj).documents;
                    } else if (obj instanceof String) {
                        arrayList = "recent".equals(obj) ? EmojiView.this.recentStickers : EmojiView.this.favouriteStickers;
                    }
                    if (arrayList == null) {
                        emptyCell.setHeight(1);
                        return;
                    } else if (!arrayList.isEmpty()) {
                        int height = EmojiView.this.pager.getHeight() - (((int) Math.ceil(arrayList.size() / this.stickersPerRow)) * AndroidUtilities.dp(82.0f));
                        emptyCell.setHeight(height > 0 ? height : 1);
                        return;
                    } else {
                        emptyCell.setHeight(AndroidUtilities.dp(8.0f));
                        return;
                    }
                }
                emptyCell.setHeight(AndroidUtilities.dp(82.0f));
                return;
            }
            int i3 = R.drawable.stickerset_close;
            if (itemViewType != 2) {
                if (itemViewType == 3) {
                    ((StickerSetGroupInfoCell) viewHolder.itemView).setIsLast(i == this.totalItems - 1);
                    return;
                } else {
                    if (itemViewType != 5) {
                        return;
                    }
                    ((StickerSetNameCell) viewHolder.itemView).setText(LocaleController.getString("FeaturedStickers", R.string.FeaturedStickers), R.drawable.stickerset_close);
                    return;
                }
            }
            StickerSetNameCell stickerSetNameCell = (StickerSetNameCell) viewHolder.itemView;
            if (i == EmojiView.this.groupStickerPackPosition) {
                if (EmojiView.this.groupStickersHidden && EmojiView.this.groupStickerSet == null) {
                    i3 = 0;
                } else if (EmojiView.this.groupStickerSet != null) {
                    i3 = R.drawable.stickersclose;
                }
                TLRPC$Chat chat = EmojiView.this.info != null ? MessagesController.getInstance(EmojiView.this.currentAccount).getChat(Long.valueOf(EmojiView.this.info.id)) : null;
                Object[] objArr = new Object[1];
                objArr[0] = chat != null ? chat.title : "Group Stickers";
                stickerSetNameCell.setText(LocaleController.formatString("CurrentGroupStickers", R.string.CurrentGroupStickers, objArr), i3);
                return;
            }
            Object obj2 = this.cache.get(i);
            if (!(obj2 instanceof TLRPC$TL_messages_stickerSet)) {
                if (obj2 != EmojiView.this.recentStickers) {
                    if (obj2 == EmojiView.this.favouriteStickers) {
                        stickerSetNameCell.setText(LocaleController.getString("FavoriteStickers", R.string.FavoriteStickers), 0);
                        return;
                    }
                    return;
                }
                stickerSetNameCell.setText(LocaleController.getString("RecentStickers", R.string.RecentStickers), 0);
                return;
            }
            TLRPC$StickerSet tLRPC$StickerSet = ((TLRPC$TL_messages_stickerSet) obj2).set;
            if (tLRPC$StickerSet != null) {
                stickerSetNameCell.setText(tLRPC$StickerSet.title, 0);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x014e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void updateItems() {
            /*
                Method dump skipped, instructions count: 485
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.EmojiView.StickersGridAdapter.updateItems():void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeRemoved(int positionStart, int itemCount) {
            updateItems();
            super.notifyItemRangeRemoved(positionStart, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            updateItems();
            super.notifyDataSetChanged();
        }
    }

    private class EmojiGridAdapter extends RecyclerListView.SelectionAdapter {
        private int itemCount;
        private SparseIntArray positionToSection;
        private SparseIntArray sectionToPosition;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return position;
        }

        private EmojiGridAdapter() {
            this.positionToSection = new SparseIntArray();
            this.sectionToPosition = new SparseIntArray();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.itemCount;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View imageViewEmoji;
            if (viewType == 0) {
                EmojiView emojiView = EmojiView.this;
                imageViewEmoji = emojiView.new ImageViewEmoji(emojiView.getContext());
            } else if (viewType == 1) {
                imageViewEmoji = new StickerSetNameCell(EmojiView.this.getContext(), true, EmojiView.this.resourcesProvider);
            } else {
                imageViewEmoji = new View(EmojiView.this.getContext());
                imageViewEmoji.setLayoutParams(new RecyclerView.LayoutParams(-1, EmojiView.this.searchFieldHeight));
            }
            return new RecyclerListView.Holder(imageViewEmoji);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String str;
            String strAddColorToCode;
            String str2;
            String str3;
            int itemViewType = holder.getItemViewType();
            boolean z = false;
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                ((StickerSetNameCell) holder.itemView).setText(EmojiView.this.emojiTitles[this.positionToSection.get(position)], 0);
                return;
            }
            ImageViewEmoji imageViewEmoji = (ImageViewEmoji) holder.itemView;
            if (EmojiView.this.needEmojiSearch) {
                position--;
            }
            int size = Emoji.recentEmoji.size();
            if (position < size) {
                str3 = Emoji.recentEmoji.get(position);
                str2 = str3;
                z = true;
            } else {
                int i = 0;
                while (true) {
                    String[][] strArr = EmojiData.dataColored;
                    if (i >= strArr.length) {
                        str = null;
                        break;
                    }
                    int length = strArr[i].length + 1 + size;
                    if (position < length) {
                        str = strArr[i][(position - size) - 1];
                        String str4 = Emoji.emojiColor.get(str);
                        if (str4 != null) {
                            strAddColorToCode = EmojiView.addColorToCode(str, str4);
                        }
                    } else {
                        i++;
                        size = length;
                    }
                }
                strAddColorToCode = str;
                String str5 = strAddColorToCode;
                str2 = str;
                str3 = str5;
            }
            imageViewEmoji.setImageDrawable(Emoji.getEmojiBigDrawable(str3), z);
            imageViewEmoji.setTag(str2);
            imageViewEmoji.setContentDescription(str3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (EmojiView.this.needEmojiSearch && position == 0) {
                return 2;
            }
            return this.positionToSection.indexOfKey(position) >= 0 ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            this.positionToSection.clear();
            this.itemCount = Emoji.recentEmoji.size() + (EmojiView.this.needEmojiSearch ? 1 : 0);
            int i = 0;
            while (true) {
                String[][] strArr = EmojiData.dataColored;
                if (i >= strArr.length) {
                    EmojiView.this.updateEmojiTabs();
                    super.notifyDataSetChanged();
                    return;
                } else {
                    this.positionToSection.put(this.itemCount, i);
                    this.sectionToPosition.put(i, this.itemCount);
                    this.itemCount += strArr[i].length + 1;
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class EmojiSearchAdapter extends RecyclerListView.SelectionAdapter {
        private String lastSearchAlias;
        private String lastSearchEmojiString;
        private ArrayList<MediaDataController.KeywordResult> result;
        private Runnable searchRunnable;
        private boolean searchWas;

        private EmojiSearchAdapter() {
            this.result = new ArrayList<>();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size;
            if (this.result.isEmpty() && !this.searchWas) {
                size = Emoji.recentEmoji.size();
            } else {
                if (this.result.isEmpty()) {
                    return 2;
                }
                size = this.result.size();
            }
            return size + 1;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View imageViewEmoji;
            if (i == 0) {
                EmojiView emojiView = EmojiView.this;
                imageViewEmoji = emojiView.new ImageViewEmoji(emojiView.getContext());
            } else if (i == 1) {
                View view = new View(EmojiView.this.getContext());
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, EmojiView.this.searchFieldHeight));
                imageViewEmoji = view;
            } else {
                FrameLayout frameLayout = new FrameLayout(EmojiView.this.getContext()) { // from class: ir.eitaa.ui.Components.EmojiView.EmojiSearchAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        int iDp;
                        if (((View) EmojiView.this.getParent()) != null) {
                            iDp = (int) (r3.getMeasuredHeight() - EmojiView.this.getY());
                        } else {
                            iDp = AndroidUtilities.dp(120.0f);
                        }
                        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(iDp - EmojiView.this.searchFieldHeight, 1073741824));
                    }
                };
                TextView textView = new TextView(EmojiView.this.getContext());
                textView.setText(LocaleController.getString("NoEmojiFound", R.string.NoEmojiFound));
                textView.setTextSize(1, 16.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(false));
                textView.setTextColor(EmojiView.this.getThemedColor("chat_emojiPanelEmptyText"));
                frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 10.0f, 0.0f, 0.0f));
                ImageView imageView = new ImageView(EmojiView.this.getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setImageResource(R.drawable.smiles_panel_question);
                imageView.setColorFilter(new PorterDuffColorFilter(EmojiView.this.getThemedColor("chat_emojiPanelEmptyText"), PorterDuff.Mode.MULTIPLY));
                frameLayout.addView(imageView, LayoutHelper.createFrame(48, 48, 85));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.EmojiView.EmojiSearchAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        Object obj;
                        boolean[] zArr = new boolean[1];
                        BottomSheet.Builder builder = new BottomSheet.Builder(EmojiView.this.getContext());
                        LinearLayout linearLayout = new LinearLayout(EmojiView.this.getContext());
                        linearLayout.setOrientation(1);
                        linearLayout.setPadding(AndroidUtilities.dp(21.0f), 0, AndroidUtilities.dp(21.0f), 0);
                        ImageView imageView2 = new ImageView(EmojiView.this.getContext());
                        imageView2.setImageResource(R.drawable.smiles_info);
                        linearLayout.addView(imageView2, LayoutHelper.createLinear(-2, -2, 49, 0, 15, 0, 0));
                        TextView textView2 = new TextView(EmojiView.this.getContext());
                        textView2.setText(LocaleController.getString("EmojiSuggestions", R.string.EmojiSuggestions));
                        textView2.setTextSize(1, 15.0f);
                        textView2.setTextColor(EmojiView.this.getThemedColor("dialogTextBlue2"));
                        textView2.setGravity(LocaleController.isRTL ? 5 : 3);
                        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
                        linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 51, 0, 24, 0, 0));
                        TextView textView3 = new TextView(EmojiView.this.getContext());
                        textView3.setText(AndroidUtilities.replaceTags(LocaleController.getString("EmojiSuggestionsInfo", R.string.EmojiSuggestionsInfo)));
                        textView3.setTextSize(1, 15.0f);
                        textView3.setTypeface(AndroidUtilities.getFontFamily(false));
                        textView3.setTextColor(EmojiView.this.getThemedColor("dialogTextBlack"));
                        textView3.setGravity(LocaleController.isRTL ? 5 : 3);
                        linearLayout.addView(textView3, LayoutHelper.createLinear(-2, -2, 51, 0, 11, 0, 0));
                        TextView textView4 = new TextView(EmojiView.this.getContext());
                        Object[] objArr = new Object[1];
                        if (EmojiSearchAdapter.this.lastSearchAlias == null) {
                            obj = EmojiView.this.lastSearchKeyboardLanguage;
                        } else {
                            obj = EmojiSearchAdapter.this.lastSearchAlias;
                        }
                        objArr[0] = obj;
                        textView4.setText(LocaleController.formatString("EmojiSuggestionsUrl", R.string.EmojiSuggestionsUrl, objArr));
                        textView4.setTextSize(1, 15.0f);
                        textView4.setTypeface(AndroidUtilities.getFontFamily(false));
                        textView4.setTextColor(EmojiView.this.getThemedColor("dialogTextLink"));
                        textView4.setGravity(LocaleController.isRTL ? 5 : 3);
                        linearLayout.addView(textView4, LayoutHelper.createLinear(-2, -2, 51, 0, 18, 0, 16));
                        textView4.setOnClickListener(new AnonymousClass1(zArr, builder));
                        builder.setCustomView(linearLayout);
                        builder.show();
                    }

                    /* renamed from: ir.eitaa.ui.Components.EmojiView$EmojiSearchAdapter$2$1, reason: invalid class name */
                    class AnonymousClass1 implements View.OnClickListener {
                        final /* synthetic */ BottomSheet.Builder val$builder;
                        final /* synthetic */ boolean[] val$loadingUrl;

                        AnonymousClass1(final boolean[] val$loadingUrl, final BottomSheet.Builder val$builder) {
                            this.val$loadingUrl = val$loadingUrl;
                            this.val$builder = val$builder;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            String str;
                            boolean[] zArr = this.val$loadingUrl;
                            if (zArr[0]) {
                                return;
                            }
                            zArr[0] = true;
                            final AlertDialog[] alertDialogArr = {new AlertDialog(EmojiView.this.getContext(), 3)};
                            TLRPC$TL_messages_getEmojiURL tLRPC$TL_messages_getEmojiURL = new TLRPC$TL_messages_getEmojiURL();
                            if (EmojiSearchAdapter.this.lastSearchAlias == null) {
                                str = EmojiView.this.lastSearchKeyboardLanguage[0];
                            } else {
                                str = EmojiSearchAdapter.this.lastSearchAlias;
                            }
                            tLRPC$TL_messages_getEmojiURL.lang_code = str;
                            ConnectionsManager connectionsManager = ConnectionsManager.getInstance(EmojiView.this.currentAccount);
                            final BottomSheet.Builder builder = this.val$builder;
                            final int iSendRequest = connectionsManager.sendRequest(tLRPC$TL_messages_getEmojiURL, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$EmojiSearchAdapter$2$1$NQmgF3WPKv-nUNovkHkiENRIkFk
                                @Override // ir.eitaa.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$onClick$1$EmojiView$EmojiSearchAdapter$2$1(alertDialogArr, builder, tLObject, tLRPC$TL_error);
                                }
                            });
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$EmojiSearchAdapter$2$1$JCOJHFZYtLu9bkuccDj-uv2G3xY
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onClick$3$EmojiView$EmojiSearchAdapter$2$1(alertDialogArr, iSendRequest);
                                }
                            }, 1000L);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* renamed from: lambda$onClick$1, reason: merged with bridge method [inline-methods] */
                        public /* synthetic */ void lambda$onClick$1$EmojiView$EmojiSearchAdapter$2$1(final AlertDialog[] alertDialogArr, final BottomSheet.Builder builder, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$EmojiSearchAdapter$2$1$9EqqF3N5DMbCO6chqrZO6jdr9Sg
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onClick$0$EmojiView$EmojiSearchAdapter$2$1(alertDialogArr, tLObject, builder);
                                }
                            });
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* renamed from: lambda$onClick$0, reason: merged with bridge method [inline-methods] */
                        public /* synthetic */ void lambda$onClick$0$EmojiView$EmojiSearchAdapter$2$1(AlertDialog[] alertDialogArr, TLObject tLObject, BottomSheet.Builder builder) {
                            try {
                                alertDialogArr[0].dismiss();
                            } catch (Throwable unused) {
                            }
                            alertDialogArr[0] = null;
                            if (tLObject instanceof TLRPC$TL_emojiURL) {
                                Browser.openUrl(EmojiView.this.getContext(), ((TLRPC$TL_emojiURL) tLObject).url);
                                builder.getDismissRunnable().run();
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* renamed from: lambda$onClick$3, reason: merged with bridge method [inline-methods] */
                        public /* synthetic */ void lambda$onClick$3$EmojiView$EmojiSearchAdapter$2$1(AlertDialog[] alertDialogArr, final int i) {
                            if (alertDialogArr[0] == null) {
                                return;
                            }
                            alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$EmojiSearchAdapter$2$1$nEgvUF8QiEjbrTC6LV7ZwR7upbQ
                                @Override // android.content.DialogInterface.OnCancelListener
                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.f$0.lambda$onClick$2$EmojiView$EmojiSearchAdapter$2$1(i, dialogInterface);
                                }
                            });
                            alertDialogArr[0].show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* renamed from: lambda$onClick$2, reason: merged with bridge method [inline-methods] */
                        public /* synthetic */ void lambda$onClick$2$EmojiView$EmojiSearchAdapter$2$1(int i, DialogInterface dialogInterface) {
                            ConnectionsManager.getInstance(EmojiView.this.currentAccount).cancelRequest(i, true);
                        }
                    }
                });
                frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                imageViewEmoji = frameLayout;
            }
            return new RecyclerListView.Holder(imageViewEmoji);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String str;
            boolean z;
            if (holder.getItemViewType() != 0) {
                return;
            }
            ImageViewEmoji imageViewEmoji = (ImageViewEmoji) holder.itemView;
            int i = position - 1;
            if (this.result.isEmpty() && !this.searchWas) {
                str = Emoji.recentEmoji.get(i);
                z = true;
            } else {
                str = this.result.get(i).emoji;
                z = false;
            }
            imageViewEmoji.setImageDrawable(Emoji.getEmojiBigDrawable(str), z);
            imageViewEmoji.setTag(str);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == 0) {
                return 1;
            }
            return (position == 1 && this.searchWas && this.result.isEmpty()) ? 2 : 0;
        }

        public void search(String text) {
            if (TextUtils.isEmpty(text)) {
                this.lastSearchEmojiString = null;
                if (EmojiView.this.emojiGridView.getAdapter() != EmojiView.this.emojiAdapter) {
                    EmojiView.this.emojiGridView.setAdapter(EmojiView.this.emojiAdapter);
                    this.searchWas = false;
                }
                notifyDataSetChanged();
            } else {
                this.lastSearchEmojiString = text.toLowerCase();
            }
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            if (TextUtils.isEmpty(this.lastSearchEmojiString)) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.EmojiView.EmojiSearchAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    EmojiView.this.emojiSearchField.progressDrawable.startAnimation();
                    final String str = EmojiSearchAdapter.this.lastSearchEmojiString;
                    String[] currentKeyboardLanguage = AndroidUtilities.getCurrentKeyboardLanguage();
                    if (!Arrays.equals(EmojiView.this.lastSearchKeyboardLanguage, currentKeyboardLanguage)) {
                        MediaDataController.getInstance(EmojiView.this.currentAccount).fetchNewEmojiKeywords(currentKeyboardLanguage);
                    }
                    EmojiView.this.lastSearchKeyboardLanguage = currentKeyboardLanguage;
                    MediaDataController.getInstance(EmojiView.this.currentAccount).getEmojiSuggestions(EmojiView.this.lastSearchKeyboardLanguage, EmojiSearchAdapter.this.lastSearchEmojiString, false, new MediaDataController.KeywordResultCallback() { // from class: ir.eitaa.ui.Components.EmojiView.EmojiSearchAdapter.3.1
                        @Override // ir.eitaa.messenger.MediaDataController.KeywordResultCallback
                        public void run(ArrayList<MediaDataController.KeywordResult> param, String alias) {
                            if (str.equals(EmojiSearchAdapter.this.lastSearchEmojiString)) {
                                EmojiSearchAdapter.this.lastSearchAlias = alias;
                                EmojiView.this.emojiSearchField.progressDrawable.stopAnimation();
                                EmojiSearchAdapter.this.searchWas = true;
                                if (EmojiView.this.emojiGridView.getAdapter() != EmojiView.this.emojiSearchAdapter) {
                                    EmojiView.this.emojiGridView.setAdapter(EmojiView.this.emojiSearchAdapter);
                                }
                                EmojiSearchAdapter.this.result = param;
                                EmojiSearchAdapter.this.notifyDataSetChanged();
                            }
                        }
                    });
                }
            };
            this.searchRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }
    }

    private class EmojiPagesAdapter extends PagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        private EmojiPagesAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int position, Object object) {
            viewGroup.removeView((View) EmojiView.this.views.get(position));
        }

        @Override // ir.eitaa.ui.Components.PagerSlidingTabStrip.IconTabProvider
        public boolean canScrollToTab(int position) {
            if ((position != 1 && position != 2) || EmojiView.this.currentChatId == 0) {
                return true;
            }
            EmojiView.this.showStickerBanHint(position == 1);
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EmojiView.this.views.size();
        }

        @Override // ir.eitaa.ui.Components.PagerSlidingTabStrip.IconTabProvider
        public Drawable getPageIconDrawable(int position) {
            return EmojiView.this.tabIcons[position];
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return LocaleController.getString("Emoji", R.string.Emoji);
            }
            if (position == 1) {
                return LocaleController.getString("AccDescrGIFs", R.string.AccDescrGIFs);
            }
            if (position != 2) {
                return null;
            }
            return LocaleController.getString("AccDescrStickers", R.string.AccDescrStickers);
        }

        @Override // ir.eitaa.ui.Components.PagerSlidingTabStrip.IconTabProvider
        public void customOnDraw(Canvas canvas, int position) {
            if (position != 2 || MediaDataController.getInstance(EmojiView.this.currentAccount).getUnreadStickerSets().isEmpty() || EmojiView.this.dotPaint == null) {
                return;
            }
            canvas.drawCircle((canvas.getWidth() / 2) + AndroidUtilities.dp(9.0f), (canvas.getHeight() / 2) - AndroidUtilities.dp(8.0f), AndroidUtilities.dp(5.0f), EmojiView.this.dotPaint);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int position) {
            View view = (View) EmojiView.this.views.get(position);
            viewGroup.addView(view);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class GifAdapter extends RecyclerListView.SelectionAdapter {
        private TLRPC$User bot;
        private final Context context;
        private int firstResultItem;
        private int itemsCount;
        private String lastSearchImageString;
        private boolean lastSearchIsEmoji;
        private final int maxRecentRowsCount;
        private String nextSearchOffset;
        private final GifProgressEmptyView progressEmptyView;
        private int recentItemsCount;
        private int reqId;
        private ArrayList<TLRPC$BotInlineResult> results;
        private HashMap<String, TLRPC$BotInlineResult> resultsMap;
        private boolean searchEndReached;
        private Runnable searchRunnable;
        private boolean searchingUser;
        private boolean showTrendingWhenSearchEmpty;
        private int trendingSectionItem;
        private final boolean withRecent;

        public GifAdapter(final EmojiView this$0, Context context) {
            this(context, false, 0);
        }

        public GifAdapter(final EmojiView this$0, Context context, boolean withRecent) {
            this(context, withRecent, withRecent ? ConnectionsManager.DEFAULT_DATACENTER_ID : 0);
        }

        public GifAdapter(Context context, boolean withRecent, int maxRecentRowsCount) {
            this.results = new ArrayList<>();
            this.resultsMap = new HashMap<>();
            this.trendingSectionItem = -1;
            this.firstResultItem = -1;
            this.context = context;
            this.withRecent = withRecent;
            this.maxRecentRowsCount = maxRecentRowsCount;
            this.progressEmptyView = withRecent ? null : EmojiView.this.new GifProgressEmptyView(context);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.itemsCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == 0) {
                return 1;
            }
            boolean z = this.withRecent;
            if (z && position == this.trendingSectionItem) {
                return 2;
            }
            return (z || !this.results.isEmpty()) ? 0 : 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            if (i == 0) {
                ContextLinkCell contextLinkCell = new ContextLinkCell(this.context);
                contextLinkCell.setCanPreviewGif(true);
                view = contextLinkCell;
            } else if (i == 1) {
                View view2 = new View(EmojiView.this.getContext());
                view2.setLayoutParams(new RecyclerView.LayoutParams(-1, EmojiView.this.searchFieldHeight));
                view = view2;
            } else if (i == 2) {
                StickerSetNameCell stickerSetNameCell = new StickerSetNameCell(this.context, false, EmojiView.this.resourcesProvider);
                stickerSetNameCell.setText(LocaleController.getString("FeaturedGifs", R.string.FeaturedGifs), 0);
                RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = AndroidUtilities.dp(2.5f);
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = AndroidUtilities.dp(5.5f);
                stickerSetNameCell.setLayoutParams(layoutParams);
                view = stickerSetNameCell;
            } else {
                View view3 = this.progressEmptyView;
                view3.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                view = view3;
            }
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getItemViewType() != 0) {
                return;
            }
            ContextLinkCell contextLinkCell = (ContextLinkCell) holder.itemView;
            int i = this.firstResultItem;
            if (i < 0 || position < i) {
                contextLinkCell.setGif((TLRPC$Document) EmojiView.this.recentGifs.get(position - 1), false);
            } else {
                contextLinkCell.setLink(this.results.get(position - i), this.bot, true, false, false, true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            updateRecentItemsCount();
            updateItems();
            super.notifyDataSetChanged();
        }

        private void updateItems() {
            this.trendingSectionItem = -1;
            this.firstResultItem = -1;
            this.itemsCount = 1;
            if (this.withRecent) {
                this.itemsCount = this.recentItemsCount + 1;
            }
            if (!this.results.isEmpty()) {
                if (this.withRecent && this.recentItemsCount > 0) {
                    int i = this.itemsCount;
                    this.itemsCount = i + 1;
                    this.trendingSectionItem = i;
                }
                int i2 = this.itemsCount;
                this.firstResultItem = i2;
                this.itemsCount = i2 + this.results.size();
                return;
            }
            if (this.withRecent) {
                return;
            }
            this.itemsCount++;
        }

        private void updateRecentItemsCount() {
            int i;
            if (!this.withRecent || (i = this.maxRecentRowsCount) == 0) {
                return;
            }
            if (i == Integer.MAX_VALUE) {
                this.recentItemsCount = EmojiView.this.recentGifs.size();
                return;
            }
            if (EmojiView.this.gifGridView.getMeasuredWidth() == 0) {
                return;
            }
            int measuredWidth = EmojiView.this.gifGridView.getMeasuredWidth();
            int spanCount = EmojiView.this.gifLayoutManager.getSpanCount();
            int iDp = AndroidUtilities.dp(100.0f);
            this.recentItemsCount = 0;
            int size = EmojiView.this.recentGifs.size();
            int i2 = spanCount;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Size sizeFixSize = EmojiView.this.gifLayoutManager.fixSize(EmojiView.this.gifLayoutManager.getSizeForItem((TLRPC$Document) EmojiView.this.recentGifs.get(i5)));
                int iMin = Math.min(spanCount, (int) Math.floor(spanCount * (((sizeFixSize.width / sizeFixSize.height) * iDp) / measuredWidth)));
                if (i2 < iMin) {
                    this.recentItemsCount += i3;
                    i4++;
                    if (i4 == this.maxRecentRowsCount) {
                        break;
                    }
                    i2 = spanCount;
                    i3 = 0;
                }
                i3++;
                i2 -= iMin;
            }
            if (i4 < this.maxRecentRowsCount) {
                this.recentItemsCount += i3;
            }
        }

        public void loadTrendingGifs() {
            search("", "", true, true, true);
        }

        private void searchBotUser() {
            if (this.searchingUser) {
                return;
            }
            this.searchingUser = true;
            TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
            tLRPC$TL_contacts_resolveUsername.username = MessagesController.getInstance(EmojiView.this.currentAccount).gifSearchBot;
            ConnectionsManager.getInstance(EmojiView.this.currentAccount).sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$GifAdapter$2ebbz6NWfifPWrw3szmBTOQfczo
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$searchBotUser$1$EmojiView$GifAdapter(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchBotUser$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchBotUser$1$EmojiView$GifAdapter(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$GifAdapter$cpzbyr5YBWBp3_97Az3vA9c5cqY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchBotUser$0$EmojiView$GifAdapter(tLObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchBotUser$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchBotUser$0$EmojiView$GifAdapter(TLObject tLObject) {
            TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
            MessagesController.getInstance(EmojiView.this.currentAccount).putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
            MessagesController.getInstance(EmojiView.this.currentAccount).putChats(tLRPC$TL_contacts_resolvedPeer.chats, false);
            MessagesStorage.getInstance(EmojiView.this.currentAccount).putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, true, true);
            String str = this.lastSearchImageString;
            this.lastSearchImageString = null;
            search(str, "", false);
        }

        public void search(final String text) {
            if (this.withRecent) {
                return;
            }
            int i = this.reqId;
            if (i != 0) {
                if (i >= 0) {
                    ConnectionsManager.getInstance(EmojiView.this.currentAccount).cancelRequest(this.reqId, true);
                }
                this.reqId = 0;
            }
            this.lastSearchIsEmoji = false;
            GifProgressEmptyView gifProgressEmptyView = this.progressEmptyView;
            if (gifProgressEmptyView != null) {
                gifProgressEmptyView.setLoadingState(false);
            }
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            if (TextUtils.isEmpty(text)) {
                this.lastSearchImageString = null;
                if (!this.showTrendingWhenSearchEmpty) {
                    int currentPosition = EmojiView.this.gifTabs.getCurrentPosition();
                    if (currentPosition == EmojiView.this.gifRecentTabNum || currentPosition == EmojiView.this.gifTrendingTabNum) {
                        if (EmojiView.this.gifGridView.getAdapter() != EmojiView.this.gifAdapter) {
                            EmojiView.this.gifGridView.setAdapter(EmojiView.this.gifAdapter);
                            return;
                        }
                        return;
                    }
                    searchEmoji(MessagesController.getInstance(EmojiView.this.currentAccount).gifSearchEmojies.get(currentPosition - EmojiView.this.gifFirstEmojiTabNum));
                    return;
                }
                loadTrendingGifs();
                return;
            }
            String lowerCase = text.toLowerCase();
            this.lastSearchImageString = lowerCase;
            if (TextUtils.isEmpty(lowerCase)) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.EmojiView.GifAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    GifAdapter.this.search(text, "", true);
                }
            };
            this.searchRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }

        public void searchEmoji(String emoji) {
            if (this.lastSearchIsEmoji && TextUtils.equals(this.lastSearchImageString, emoji)) {
                EmojiView.this.gifLayoutManager.scrollToPositionWithOffset(1, 0);
            } else {
                search(emoji, "", true, true, true);
            }
        }

        protected void search(final String query, final String offset, boolean searchUser) {
            search(query, offset, searchUser, false, false);
        }

        protected void search(final String query, final String offset, final boolean searchUser, final boolean isEmoji, final boolean cache) {
            int i = this.reqId;
            if (i != 0) {
                if (i >= 0) {
                    ConnectionsManager.getInstance(EmojiView.this.currentAccount).cancelRequest(this.reqId, true);
                }
                this.reqId = 0;
            }
            this.lastSearchImageString = query;
            this.lastSearchIsEmoji = isEmoji;
            GifProgressEmptyView gifProgressEmptyView = this.progressEmptyView;
            if (gifProgressEmptyView != null) {
                gifProgressEmptyView.setLoadingState(isEmoji);
            }
            TLObject userOrChat = MessagesController.getInstance(EmojiView.this.currentAccount).getUserOrChat(MessagesController.getInstance(EmojiView.this.currentAccount).gifSearchBot);
            if (!(userOrChat instanceof TLRPC$User)) {
                if (searchUser) {
                    searchBotUser();
                    if (this.withRecent) {
                        return;
                    }
                    EmojiView.this.gifSearchField.progressDrawable.startAnimation();
                    return;
                }
                return;
            }
            if (!this.withRecent && TextUtils.isEmpty(offset)) {
                EmojiView.this.gifSearchField.progressDrawable.startAnimation();
            }
            this.bot = (TLRPC$User) userOrChat;
            final String str = "gif_search_" + query + "_" + offset;
            RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$GifAdapter$Ox3WobDre0yuhzAsZOHs3zGpIZU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$search$3$EmojiView$GifAdapter(query, offset, searchUser, isEmoji, cache, str, tLObject, tLRPC$TL_error);
                }
            };
            if (!cache && !this.withRecent && isEmoji && TextUtils.isEmpty(offset)) {
                this.results.clear();
                this.resultsMap.clear();
                if (EmojiView.this.gifGridView.getAdapter() != this) {
                    EmojiView.this.gifGridView.setAdapter(this);
                }
                notifyDataSetChanged();
                EmojiView.this.scrollGifsToTop();
            }
            if (!cache || !EmojiView.this.gifCache.containsKey(str)) {
                if (EmojiView.this.gifSearchPreloader.isLoading(str)) {
                    return;
                }
                if (cache) {
                    this.reqId = -1;
                    MessagesStorage.getInstance(EmojiView.this.currentAccount).getBotCache(str, requestDelegate);
                    return;
                }
                TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
                if (query == null) {
                    query = "";
                }
                tLRPC$TL_messages_getInlineBotResults.query = query;
                tLRPC$TL_messages_getInlineBotResults.bot = MessagesController.getInstance(EmojiView.this.currentAccount).getInputUser(this.bot);
                tLRPC$TL_messages_getInlineBotResults.offset = offset;
                tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
                this.reqId = ConnectionsManager.getInstance(EmojiView.this.currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, requestDelegate, 2);
                return;
            }
            lambda$search$2(query, offset, searchUser, isEmoji, true, str, (TLObject) EmojiView.this.gifCache.get(str));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$3$EmojiView$GifAdapter(final String str, final String str2, final boolean z, final boolean z2, final boolean z3, final String str3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$GifAdapter$Iaaj36rFq0eaYiArNfrPTKVs_ow
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$2$EmojiView$GifAdapter(str, str2, z, z2, z3, str3, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processResponse, reason: merged with bridge method [inline-methods] */
        public void lambda$search$2$EmojiView$GifAdapter(final String query, final String offset, boolean searchUser, boolean isEmoji, boolean cache, String key, TLObject response) {
            if (query == null || !query.equals(this.lastSearchImageString)) {
                return;
            }
            this.reqId = 0;
            if (cache && (!(response instanceof TLRPC$messages_BotResults) || ((TLRPC$messages_BotResults) response).results.isEmpty())) {
                search(query, offset, searchUser, isEmoji, false);
                return;
            }
            if (!this.withRecent && TextUtils.isEmpty(offset)) {
                this.results.clear();
                this.resultsMap.clear();
                EmojiView.this.gifSearchField.progressDrawable.stopAnimation();
            }
            if (response instanceof TLRPC$messages_BotResults) {
                int size = this.results.size();
                TLRPC$messages_BotResults tLRPC$messages_BotResults = (TLRPC$messages_BotResults) response;
                if (!EmojiView.this.gifCache.containsKey(key)) {
                    EmojiView.this.gifCache.put(key, tLRPC$messages_BotResults);
                }
                if (!cache && tLRPC$messages_BotResults.cache_time != 0) {
                    MessagesStorage.getInstance(EmojiView.this.currentAccount).saveBotCache(key, tLRPC$messages_BotResults);
                }
                this.nextSearchOffset = tLRPC$messages_BotResults.next_offset;
                int i = 0;
                for (int i2 = 0; i2 < tLRPC$messages_BotResults.results.size(); i2++) {
                    TLRPC$BotInlineResult tLRPC$BotInlineResult = tLRPC$messages_BotResults.results.get(i2);
                    if (!this.resultsMap.containsKey(tLRPC$BotInlineResult.id)) {
                        tLRPC$BotInlineResult.query_id = tLRPC$messages_BotResults.query_id;
                        this.results.add(tLRPC$BotInlineResult);
                        this.resultsMap.put(tLRPC$BotInlineResult.id, tLRPC$BotInlineResult);
                        i++;
                    }
                }
                this.searchEndReached = size == this.results.size() || TextUtils.isEmpty(this.nextSearchOffset);
                if (i != 0) {
                    if (!isEmoji || size != 0) {
                        updateItems();
                        if (!this.withRecent) {
                            if (size != 0) {
                                notifyItemChanged(size);
                            }
                            notifyItemRangeInserted(size + 1, i);
                        } else if (size != 0) {
                            notifyItemChanged(this.recentItemsCount + 1 + size);
                            notifyItemRangeInserted(this.recentItemsCount + 1 + size + 1, i);
                        } else {
                            notifyItemRangeInserted(this.recentItemsCount + 1, i + 1);
                        }
                    } else {
                        notifyDataSetChanged();
                    }
                } else if (this.results.isEmpty()) {
                    notifyDataSetChanged();
                }
            } else {
                notifyDataSetChanged();
            }
            if (this.withRecent) {
                return;
            }
            if (EmojiView.this.gifGridView.getAdapter() != this) {
                EmojiView.this.gifGridView.setAdapter(this);
            }
            if (isEmoji && !TextUtils.isEmpty(query) && TextUtils.isEmpty(offset)) {
                EmojiView.this.scrollGifsToTop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class GifSearchPreloader {
        private final List<String> loadingKeys;

        private GifSearchPreloader() {
            this.loadingKeys = new ArrayList();
        }

        public boolean isLoading(String key) {
            return this.loadingKeys.contains(key);
        }

        public void preload(final String query) {
            preload(query, "", true);
        }

        private void preload(final String query, final String offset, final boolean cache) {
            final String str = "gif_search_" + query + "_" + offset;
            if (cache && EmojiView.this.gifCache.containsKey(str)) {
                return;
            }
            RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$GifSearchPreloader$7rKUtTk6aYYvYaOJz7Pn4DTf88Y
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$preload$1$EmojiView$GifSearchPreloader(query, offset, cache, str, tLObject, tLRPC$TL_error);
                }
            };
            if (!cache) {
                MessagesController messagesController = MessagesController.getInstance(EmojiView.this.currentAccount);
                TLObject userOrChat = messagesController.getUserOrChat(messagesController.gifSearchBot);
                if (userOrChat instanceof TLRPC$User) {
                    this.loadingKeys.add(str);
                    TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
                    if (query == null) {
                        query = "";
                    }
                    tLRPC$TL_messages_getInlineBotResults.query = query;
                    tLRPC$TL_messages_getInlineBotResults.bot = messagesController.getInputUser((TLRPC$User) userOrChat);
                    tLRPC$TL_messages_getInlineBotResults.offset = offset;
                    tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
                    ConnectionsManager.getInstance(EmojiView.this.currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, requestDelegate, 2);
                    return;
                }
                return;
            }
            this.loadingKeys.add(str);
            MessagesStorage.getInstance(EmojiView.this.currentAccount).getBotCache(str, requestDelegate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$preload$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$preload$1$EmojiView$GifSearchPreloader(final String str, final String str2, final boolean z, final String str3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$GifSearchPreloader$_kgRa2w3nDSJmJjYZcqh6zdNgUU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$preload$0$EmojiView$GifSearchPreloader(str, str2, z, str3, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processResponse, reason: merged with bridge method [inline-methods] */
        public void lambda$preload$0$EmojiView$GifSearchPreloader(final String query, final String offset, boolean cache, String key, TLObject response) {
            this.loadingKeys.remove(key);
            if (EmojiView.this.gifSearchAdapter.lastSearchIsEmoji && EmojiView.this.gifSearchAdapter.lastSearchImageString.equals(query)) {
                EmojiView.this.gifSearchAdapter.lambda$search$2(query, offset, false, true, cache, key, response);
                return;
            }
            if (cache && (!(response instanceof TLRPC$messages_BotResults) || ((TLRPC$messages_BotResults) response).results.isEmpty())) {
                preload(query, offset, false);
            } else {
                if (!(response instanceof TLRPC$messages_BotResults) || EmojiView.this.gifCache.containsKey(key)) {
                    return;
                }
                EmojiView.this.gifCache.put(key, (TLRPC$messages_BotResults) response);
            }
        }
    }

    private class GifLayoutManager extends ExtendedGridLayoutManager {
        private Size size;

        public GifLayoutManager(Context context) {
            super(context, 100, true);
            this.size = new Size();
            setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.EmojiView.GifLayoutManager.1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int position) {
                    if (position == 0 || (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifSearchAdapter && EmojiView.this.gifSearchAdapter.results.isEmpty())) {
                        return GifLayoutManager.this.getSpanCount();
                    }
                    return GifLayoutManager.this.getSpanSizeForItem(position - 1);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v19, types: [java.util.ArrayList<ir.eitaa.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v20, types: [java.util.ArrayList<ir.eitaa.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v21, types: [java.util.ArrayList<ir.eitaa.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.util.ArrayList<ir.eitaa.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.util.ArrayList<ir.eitaa.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList<ir.eitaa.tgnet.TLRPC$DocumentAttribute>] */
        @Override // ir.eitaa.ui.Components.ExtendedGridLayoutManager
        protected Size getSizeForItem(int i) {
            List<TLRPC$DocumentAttribute> list;
            TLRPC$Document tLRPC$Document;
            TLRPC$Document tLRPC$Document2;
            TLRPC$Document tLRPC$Document3 = null;
            if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifAdapter) {
                if (i > EmojiView.this.gifAdapter.recentItemsCount) {
                    TLRPC$BotInlineResult tLRPC$BotInlineResult = (TLRPC$BotInlineResult) EmojiView.this.gifAdapter.results.get((i - EmojiView.this.gifAdapter.recentItemsCount) - 1);
                    tLRPC$Document = tLRPC$BotInlineResult.document;
                    if (tLRPC$Document != null) {
                        tLRPC$Document2 = tLRPC$Document.attributes;
                    } else {
                        TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.content;
                        if (tLRPC$WebDocument != null) {
                            tLRPC$Document2 = tLRPC$WebDocument.attributes;
                        } else {
                            TLRPC$WebDocument tLRPC$WebDocument2 = tLRPC$BotInlineResult.thumb;
                            if (tLRPC$WebDocument2 != null) {
                                tLRPC$Document2 = tLRPC$WebDocument2.attributes;
                            }
                            list = tLRPC$Document3;
                            tLRPC$Document3 = tLRPC$Document;
                        }
                    }
                    tLRPC$Document3 = tLRPC$Document2;
                    list = tLRPC$Document3;
                    tLRPC$Document3 = tLRPC$Document;
                } else {
                    if (i == EmojiView.this.gifAdapter.recentItemsCount) {
                        return null;
                    }
                    tLRPC$Document3 = (TLRPC$Document) EmojiView.this.recentGifs.get(i);
                    list = tLRPC$Document3.attributes;
                }
            } else if (EmojiView.this.gifSearchAdapter.results.isEmpty()) {
                list = null;
            } else {
                TLRPC$BotInlineResult tLRPC$BotInlineResult2 = (TLRPC$BotInlineResult) EmojiView.this.gifSearchAdapter.results.get(i);
                tLRPC$Document = tLRPC$BotInlineResult2.document;
                if (tLRPC$Document != null) {
                    tLRPC$Document2 = tLRPC$Document.attributes;
                } else {
                    TLRPC$WebDocument tLRPC$WebDocument3 = tLRPC$BotInlineResult2.content;
                    if (tLRPC$WebDocument3 != null) {
                        tLRPC$Document2 = tLRPC$WebDocument3.attributes;
                    } else {
                        TLRPC$WebDocument tLRPC$WebDocument4 = tLRPC$BotInlineResult2.thumb;
                        if (tLRPC$WebDocument4 != null) {
                            tLRPC$Document2 = tLRPC$WebDocument4.attributes;
                        }
                        list = tLRPC$Document3;
                        tLRPC$Document3 = tLRPC$Document;
                    }
                }
                tLRPC$Document3 = tLRPC$Document2;
                list = tLRPC$Document3;
                tLRPC$Document3 = tLRPC$Document;
            }
            return getSizeForItem(tLRPC$Document3, list);
        }

        @Override // ir.eitaa.ui.Components.ExtendedGridLayoutManager
        protected int getFlowItemCount() {
            if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifSearchAdapter && EmojiView.this.gifSearchAdapter.results.isEmpty()) {
                return 0;
            }
            return getItemCount() - 1;
        }

        public Size getSizeForItem(TLRPC$Document document) {
            return getSizeForItem(document, document.attributes);
        }

        public Size getSizeForItem(TLRPC$Document document, List<TLRPC$DocumentAttribute> attributes) {
            TLRPC$PhotoSize closestPhotoSizeWithSize;
            int i;
            int i2;
            Size size = this.size;
            size.height = 100.0f;
            size.width = 100.0f;
            if (document != null && (closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90)) != null && (i = closestPhotoSizeWithSize.w) != 0 && (i2 = closestPhotoSizeWithSize.h) != 0) {
                Size size2 = this.size;
                size2.width = i;
                size2.height = i2;
            }
            if (attributes != null) {
                for (int i3 = 0; i3 < attributes.size(); i3++) {
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = attributes.get(i3);
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
    }

    private class GifProgressEmptyView extends FrameLayout {
        private final ImageView imageView;
        private boolean loadingState;
        private final RadialProgressView progressView;
        private final TextView textView;

        public GifProgressEmptyView(Context context) {
            super(context);
            ImageView imageView = new ImageView(getContext());
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.drawable.gif_empty);
            imageView.setColorFilter(new PorterDuffColorFilter(EmojiView.this.getThemedColor("chat_emojiPanelEmptyText"), PorterDuff.Mode.MULTIPLY));
            addView(imageView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 59.0f));
            TextView textView = new TextView(getContext());
            this.textView = textView;
            textView.setText(LocaleController.getString("NoGIFsFound", R.string.NoGIFsFound));
            textView.setTextSize(1, 16.0f);
            textView.setTypeface(AndroidUtilities.getFontFamily(false));
            textView.setTextColor(EmojiView.this.getThemedColor("chat_emojiPanelEmptyText"));
            addView(textView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 9.0f));
            RadialProgressView radialProgressView = new RadialProgressView(context, EmojiView.this.resourcesProvider);
            this.progressView = radialProgressView;
            radialProgressView.setVisibility(8);
            radialProgressView.setProgressColor(EmojiView.this.getThemedColor("progressCircle"));
            addView(radialProgressView, LayoutHelper.createFrame(-2, -2, 17));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int measuredHeight = EmojiView.this.gifGridView.getMeasuredHeight();
            if (!this.loadingState) {
                iDp = (int) ((((measuredHeight - EmojiView.this.searchFieldHeight) - AndroidUtilities.dp(8.0f)) / 3) * 1.7f);
            } else {
                iDp = measuredHeight - AndroidUtilities.dp(92.0f);
            }
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(iDp, 1073741824));
        }

        public void setLoadingState(boolean loadingState) {
            if (this.loadingState != loadingState) {
                this.loadingState = loadingState;
                this.imageView.setVisibility(loadingState ? 8 : 0);
                this.textView.setVisibility(loadingState ? 8 : 0);
                this.progressView.setVisibility(loadingState ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class StickersSearchGridAdapter extends RecyclerListView.SelectionAdapter {
        boolean cleared;
        private Context context;
        private int emojiSearchId;
        private int reqId;
        private int reqId2;
        private String searchQuery;
        private int totalItems;
        private SparseArray<Object> rowStartPack = new SparseArray<>();
        private SparseArray<Object> cache = new SparseArray<>();
        private SparseArray<Object> cacheParent = new SparseArray<>();
        private SparseIntArray positionToRow = new SparseIntArray();
        private SparseArray<String> positionToEmoji = new SparseArray<>();
        private ArrayList<TLRPC$StickerSetCovered> serverPacks = new ArrayList<>();
        private ArrayList<TLRPC$TL_messages_stickerSet> localPacks = new ArrayList<>();
        private HashMap<TLRPC$TL_messages_stickerSet, Boolean> localPacksByShortName = new HashMap<>();
        private HashMap<TLRPC$TL_messages_stickerSet, Integer> localPacksByName = new HashMap<>();
        private HashMap<ArrayList<TLRPC$Document>, String> emojiStickers = new HashMap<>();
        private ArrayList<ArrayList<TLRPC$Document>> emojiArrays = new ArrayList<>();
        private SparseArray<TLRPC$StickerSetCovered> positionsToSets = new SparseArray<>();
        private Runnable searchRunnable = new AnonymousClass1();

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        static /* synthetic */ int access$16204(StickersSearchGridAdapter stickersSearchGridAdapter) {
            int i = stickersSearchGridAdapter.emojiSearchId + 1;
            stickersSearchGridAdapter.emojiSearchId = i;
            return i;
        }

        /* renamed from: ir.eitaa.ui.Components.EmojiView$StickersSearchGridAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clear() {
                StickersSearchGridAdapter stickersSearchGridAdapter = StickersSearchGridAdapter.this;
                if (stickersSearchGridAdapter.cleared) {
                    return;
                }
                stickersSearchGridAdapter.cleared = true;
                stickersSearchGridAdapter.emojiStickers.clear();
                StickersSearchGridAdapter.this.emojiArrays.clear();
                StickersSearchGridAdapter.this.localPacks.clear();
                StickersSearchGridAdapter.this.serverPacks.clear();
                StickersSearchGridAdapter.this.localPacksByShortName.clear();
                StickersSearchGridAdapter.this.localPacksByName.clear();
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
            /* JADX WARN: Removed duplicated region for block: B:97:0x00d7 A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 833
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.EmojiView.StickersSearchGridAdapter.AnonymousClass1.run():void");
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$1$EmojiView$StickersSearchGridAdapter$1(final TLRPC$TL_messages_searchStickerSets tLRPC$TL_messages_searchStickerSets, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                if (tLObject instanceof TLRPC$TL_messages_foundStickerSets) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$StickersSearchGridAdapter$1$WYWE2OSHELaxKosSnmLlnFCnbd0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$run$0$EmojiView$StickersSearchGridAdapter$1(tLRPC$TL_messages_searchStickerSets, tLObject);
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$EmojiView$StickersSearchGridAdapter$1(TLRPC$TL_messages_searchStickerSets tLRPC$TL_messages_searchStickerSets, TLObject tLObject) {
                if (tLRPC$TL_messages_searchStickerSets.q.equals(StickersSearchGridAdapter.this.searchQuery)) {
                    clear();
                    EmojiView.this.stickersSearchField.progressDrawable.stopAnimation();
                    StickersSearchGridAdapter.this.reqId = 0;
                    if (EmojiView.this.stickersGridView.getAdapter() != EmojiView.this.stickersSearchGridAdapter) {
                        EmojiView.this.stickersGridView.setAdapter(EmojiView.this.stickersSearchGridAdapter);
                    }
                    StickersSearchGridAdapter.this.serverPacks.addAll(((TLRPC$TL_messages_foundStickerSets) tLObject).sets);
                    StickersSearchGridAdapter.this.notifyDataSetChanged();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$3, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$3$EmojiView$StickersSearchGridAdapter$1(final TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers, final ArrayList arrayList, final LongSparseArray longSparseArray, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$StickersSearchGridAdapter$1$pNREWsQEpzLGTdD3zrjqvEB6760
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$2$EmojiView$StickersSearchGridAdapter$1(tLRPC$TL_messages_getStickers, tLObject, arrayList, longSparseArray);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$2$EmojiView$StickersSearchGridAdapter$1(TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers, TLObject tLObject, ArrayList arrayList, LongSparseArray longSparseArray) {
                if (tLRPC$TL_messages_getStickers.emoticon.equals(StickersSearchGridAdapter.this.searchQuery)) {
                    StickersSearchGridAdapter.this.reqId2 = 0;
                    if (tLObject instanceof TLRPC$TL_messages_stickers) {
                        TLRPC$TL_messages_stickers tLRPC$TL_messages_stickers = (TLRPC$TL_messages_stickers) tLObject;
                        int size = arrayList.size();
                        int size2 = tLRPC$TL_messages_stickers.stickers.size();
                        for (int i = 0; i < size2; i++) {
                            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickers.stickers.get(i);
                            if (longSparseArray.indexOfKey(tLRPC$Document.id) < 0) {
                                arrayList.add(tLRPC$Document);
                            }
                        }
                        if (size != arrayList.size()) {
                            StickersSearchGridAdapter.this.emojiStickers.put(arrayList, StickersSearchGridAdapter.this.searchQuery);
                            if (size == 0) {
                                StickersSearchGridAdapter.this.emojiArrays.add(arrayList);
                            }
                            StickersSearchGridAdapter.this.notifyDataSetChanged();
                        }
                    }
                }
            }
        }

        public StickersSearchGridAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i = this.totalItems;
            if (i != 1) {
                return i + 1;
            }
            return 2;
        }

        public void search(String text) {
            if (this.reqId != 0) {
                ConnectionsManager.getInstance(EmojiView.this.currentAccount).cancelRequest(this.reqId, true);
                this.reqId = 0;
            }
            if (this.reqId2 != 0) {
                ConnectionsManager.getInstance(EmojiView.this.currentAccount).cancelRequest(this.reqId2, true);
                this.reqId2 = 0;
            }
            if (TextUtils.isEmpty(text)) {
                this.searchQuery = null;
                this.localPacks.clear();
                this.emojiStickers.clear();
                this.serverPacks.clear();
                if (EmojiView.this.stickersGridView.getAdapter() != EmojiView.this.stickersGridAdapter) {
                    EmojiView.this.stickersGridView.setAdapter(EmojiView.this.stickersGridAdapter);
                }
                notifyDataSetChanged();
            } else {
                this.searchQuery = text.toLowerCase();
            }
            AndroidUtilities.cancelRunOnUIThread(this.searchRunnable);
            AndroidUtilities.runOnUIThread(this.searchRunnable, 300L);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == 0) {
                return 4;
            }
            if (position == 1 && this.totalItems == 1) {
                return 5;
            }
            Object obj = this.cache.get(position);
            if (obj == null) {
                return 1;
            }
            if (obj instanceof TLRPC$Document) {
                return 0;
            }
            return obj instanceof TLRPC$StickerSetCovered ? 3 : 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$EmojiView$StickersSearchGridAdapter(View view) {
            FeaturedStickerSetInfoCell featuredStickerSetInfoCell = (FeaturedStickerSetInfoCell) view.getParent();
            TLRPC$StickerSetCovered stickerSet = featuredStickerSetInfoCell.getStickerSet();
            if (EmojiView.this.installingStickerSets.indexOfKey(stickerSet.set.id) >= 0 || EmojiView.this.removingStickerSets.indexOfKey(stickerSet.set.id) >= 0) {
                return;
            }
            if (featuredStickerSetInfoCell.isInstalled()) {
                EmojiView.this.removingStickerSets.put(stickerSet.set.id, stickerSet);
                EmojiView.this.delegate.onStickerSetRemove(featuredStickerSetInfoCell.getStickerSet());
            } else {
                featuredStickerSetInfoCell.setAddDrawProgress(true, true);
                EmojiView.this.installingStickerSets.put(stickerSet.set.id, stickerSet);
                EmojiView.this.delegate.onStickerSetAdd(featuredStickerSetInfoCell.getStickerSet());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View emptyCell;
            boolean z = true;
            if (i == 0) {
                emptyCell = new StickerEmojiCell(this.context, z) { // from class: ir.eitaa.ui.Components.EmojiView.StickersSearchGridAdapter.2
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
            } else if (i == 1) {
                emptyCell = new EmptyCell(this.context);
            } else if (i == 2) {
                emptyCell = new StickerSetNameCell(this.context, false, EmojiView.this.resourcesProvider);
            } else if (i == 3) {
                FeaturedStickerSetInfoCell featuredStickerSetInfoCell = new FeaturedStickerSetInfoCell(this.context, 17, false, true, EmojiView.this.resourcesProvider);
                featuredStickerSetInfoCell.setAddOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmojiView$StickersSearchGridAdapter$trYQlKhRMfZTWhtuy0gGEyKmqEQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$0$EmojiView$StickersSearchGridAdapter(view);
                    }
                });
                emptyCell = featuredStickerSetInfoCell;
            } else if (i == 4) {
                View view = new View(this.context);
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, EmojiView.this.searchFieldHeight));
                emptyCell = view;
            } else if (i != 5) {
                emptyCell = null;
            } else {
                FrameLayout frameLayout = new FrameLayout(this.context) { // from class: ir.eitaa.ui.Components.EmojiView.StickersSearchGridAdapter.3
                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) ((((EmojiView.this.stickersGridView.getMeasuredHeight() - EmojiView.this.searchFieldHeight) - AndroidUtilities.dp(8.0f)) / 3) * 1.7f), 1073741824));
                    }
                };
                ImageView imageView = new ImageView(this.context);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setImageResource(R.drawable.stickers_empty);
                imageView.setColorFilter(new PorterDuffColorFilter(EmojiView.this.getThemedColor("chat_emojiPanelEmptyText"), PorterDuff.Mode.MULTIPLY));
                frameLayout.addView(imageView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 59.0f));
                TextView textView = new TextView(this.context);
                textView.setText(LocaleController.getString("NoStickersFound", R.string.NoStickersFound));
                textView.setTextSize(1, 16.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(false));
                textView.setTextColor(EmojiView.this.getThemedColor("chat_emojiPanelEmptyText"));
                frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 9.0f));
                frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                emptyCell = frameLayout;
            }
            return new RecyclerListView.Holder(emptyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            boolean z = true;
            z = true;
            if (itemViewType == 0) {
                TLRPC$Document tLRPC$Document = (TLRPC$Document) this.cache.get(i);
                StickerEmojiCell stickerEmojiCell = (StickerEmojiCell) viewHolder.itemView;
                stickerEmojiCell.setSticker(tLRPC$Document, null, this.cacheParent.get(i), this.positionToEmoji.get(i), false);
                if (!EmojiView.this.recentStickers.contains(tLRPC$Document) && !EmojiView.this.favouriteStickers.contains(tLRPC$Document)) {
                    z = false;
                }
                stickerEmojiCell.setRecent(z);
                return;
            }
            Integer numValueOf = null;
            if (itemViewType == 1) {
                EmptyCell emptyCell = (EmptyCell) viewHolder.itemView;
                if (i == this.totalItems) {
                    int i2 = this.positionToRow.get(i - 1, Integer.MIN_VALUE);
                    if (i2 == Integer.MIN_VALUE) {
                        emptyCell.setHeight(1);
                        return;
                    }
                    Object obj = this.rowStartPack.get(i2);
                    if (obj instanceof TLRPC$TL_messages_stickerSet) {
                        numValueOf = Integer.valueOf(((TLRPC$TL_messages_stickerSet) obj).documents.size());
                    } else if (obj instanceof Integer) {
                        numValueOf = (Integer) obj;
                    }
                    if (numValueOf == null) {
                        emptyCell.setHeight(1);
                        return;
                    } else if (numValueOf.intValue() != 0) {
                        int height = EmojiView.this.pager.getHeight() - (((int) Math.ceil(numValueOf.intValue() / EmojiView.this.stickersGridAdapter.stickersPerRow)) * AndroidUtilities.dp(82.0f));
                        emptyCell.setHeight(height > 0 ? height : 1);
                        return;
                    } else {
                        emptyCell.setHeight(AndroidUtilities.dp(8.0f));
                        return;
                    }
                }
                emptyCell.setHeight(AndroidUtilities.dp(82.0f));
                return;
            }
            if (itemViewType == 2) {
                StickerSetNameCell stickerSetNameCell = (StickerSetNameCell) viewHolder.itemView;
                Object obj2 = this.cache.get(i);
                if (obj2 instanceof TLRPC$TL_messages_stickerSet) {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) obj2;
                    if (!TextUtils.isEmpty(this.searchQuery) && this.localPacksByShortName.containsKey(tLRPC$TL_messages_stickerSet)) {
                        TLRPC$StickerSet tLRPC$StickerSet = tLRPC$TL_messages_stickerSet.set;
                        if (tLRPC$StickerSet != null) {
                            stickerSetNameCell.setText(tLRPC$StickerSet.title, 0);
                        }
                        stickerSetNameCell.setUrl(tLRPC$TL_messages_stickerSet.set.short_name, this.searchQuery.length());
                        return;
                    }
                    Integer num = this.localPacksByName.get(tLRPC$TL_messages_stickerSet);
                    TLRPC$StickerSet tLRPC$StickerSet2 = tLRPC$TL_messages_stickerSet.set;
                    if (tLRPC$StickerSet2 != null && num != null) {
                        stickerSetNameCell.setText(tLRPC$StickerSet2.title, 0, num.intValue(), !TextUtils.isEmpty(this.searchQuery) ? this.searchQuery.length() : 0);
                    }
                    stickerSetNameCell.setUrl(null, 0);
                    return;
                }
                return;
            }
            if (itemViewType != 3) {
                return;
            }
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) this.cache.get(i);
            FeaturedStickerSetInfoCell featuredStickerSetInfoCell = (FeaturedStickerSetInfoCell) viewHolder.itemView;
            boolean z2 = EmojiView.this.installingStickerSets.indexOfKey(tLRPC$StickerSetCovered.set.id) >= 0;
            char c = EmojiView.this.removingStickerSets.indexOfKey(tLRPC$StickerSetCovered.set.id) < 0 ? (char) 0 : (char) 1;
            if (z2 || c != 0) {
                if (z2 && featuredStickerSetInfoCell.isInstalled()) {
                    EmojiView.this.installingStickerSets.remove(tLRPC$StickerSetCovered.set.id);
                    z2 = false;
                } else if (c != 0 && !featuredStickerSetInfoCell.isInstalled()) {
                    EmojiView.this.removingStickerSets.remove(tLRPC$StickerSetCovered.set.id);
                }
            }
            featuredStickerSetInfoCell.setAddDrawProgress(z2, false);
            int iIndexOfIgnoreCase = TextUtils.isEmpty(this.searchQuery) ? -1 : AndroidUtilities.indexOfIgnoreCase(tLRPC$StickerSetCovered.set.title, this.searchQuery);
            if (iIndexOfIgnoreCase >= 0) {
                featuredStickerSetInfoCell.setStickerSet(tLRPC$StickerSetCovered, false, false, iIndexOfIgnoreCase, this.searchQuery.length());
                return;
            }
            featuredStickerSetInfoCell.setStickerSet(tLRPC$StickerSetCovered, false);
            if (TextUtils.isEmpty(this.searchQuery) || AndroidUtilities.indexOfIgnoreCase(tLRPC$StickerSetCovered.set.short_name, this.searchQuery) != 0) {
                return;
            }
            featuredStickerSetInfoCell.setUrl(tLRPC$StickerSetCovered.set.short_name, this.searchQuery.length());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            int i;
            ArrayList<TLRPC$Document> arrayList;
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered;
            this.rowStartPack.clear();
            this.positionToRow.clear();
            this.cache.clear();
            this.positionsToSets.clear();
            this.positionToEmoji.clear();
            this.totalItems = 0;
            int size = this.serverPacks.size();
            int size2 = this.localPacks.size();
            int i2 = !this.emojiArrays.isEmpty() ? 1 : 0;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            while (i4 < size + size2 + i2) {
                if (i4 == i3) {
                    SparseArray<Object> sparseArray = this.cache;
                    int i6 = this.totalItems;
                    this.totalItems = i6 + 1;
                    sparseArray.put(i6, "search");
                    i5++;
                    i = size;
                } else {
                    if (i4 < size2) {
                        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.localPacks.get(i4);
                        arrayList = tLRPC$TL_messages_stickerSet.documents;
                        i = size;
                        tLRPC$StickerSetCovered = tLRPC$TL_messages_stickerSet;
                    } else {
                        int i7 = i4 - size2;
                        if (i7 < i2) {
                            int size3 = this.emojiArrays.size();
                            String str = "";
                            int i8 = 0;
                            for (int i9 = 0; i9 < size3; i9++) {
                                ArrayList<TLRPC$Document> arrayList2 = this.emojiArrays.get(i9);
                                String str2 = this.emojiStickers.get(arrayList2);
                                if (str2 != null && !str.equals(str2)) {
                                    this.positionToEmoji.put(this.totalItems + i8, str2);
                                    str = str2;
                                }
                                int size4 = arrayList2.size();
                                int i10 = 0;
                                while (i10 < size4) {
                                    int i11 = this.totalItems + i8;
                                    int i12 = (i8 / EmojiView.this.stickersGridAdapter.stickersPerRow) + i5;
                                    TLRPC$Document tLRPC$Document = arrayList2.get(i10);
                                    int i13 = size;
                                    this.cache.put(i11, tLRPC$Document);
                                    int i14 = size3;
                                    String str3 = str;
                                    TLRPC$TL_messages_stickerSet stickerSetById = MediaDataController.getInstance(EmojiView.this.currentAccount).getStickerSetById(MediaDataController.getStickerSetId(tLRPC$Document));
                                    if (stickerSetById != null) {
                                        this.cacheParent.put(i11, stickerSetById);
                                    }
                                    this.positionToRow.put(i11, i12);
                                    i8++;
                                    i10++;
                                    size = i13;
                                    size3 = i14;
                                    str = str3;
                                }
                            }
                            i = size;
                            int iCeil = (int) Math.ceil(i8 / EmojiView.this.stickersGridAdapter.stickersPerRow);
                            for (int i15 = 0; i15 < iCeil; i15++) {
                                this.rowStartPack.put(i5 + i15, Integer.valueOf(i8));
                            }
                            this.totalItems += EmojiView.this.stickersGridAdapter.stickersPerRow * iCeil;
                            i5 += iCeil;
                        } else {
                            i = size;
                            TLRPC$StickerSetCovered tLRPC$StickerSetCovered2 = this.serverPacks.get(i7 - i2);
                            arrayList = tLRPC$StickerSetCovered2.covers;
                            tLRPC$StickerSetCovered = tLRPC$StickerSetCovered2;
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        int iCeil2 = (int) Math.ceil(arrayList.size() / EmojiView.this.stickersGridAdapter.stickersPerRow);
                        this.cache.put(this.totalItems, tLRPC$StickerSetCovered);
                        if (i4 >= size2 && (tLRPC$StickerSetCovered instanceof TLRPC$StickerSetCovered)) {
                            this.positionsToSets.put(this.totalItems, tLRPC$StickerSetCovered);
                        }
                        this.positionToRow.put(this.totalItems, i5);
                        int size5 = arrayList.size();
                        int i16 = 0;
                        while (i16 < size5) {
                            int i17 = i16 + 1;
                            int i18 = this.totalItems + i17;
                            int i19 = i5 + 1 + (i16 / EmojiView.this.stickersGridAdapter.stickersPerRow);
                            this.cache.put(i18, arrayList.get(i16));
                            this.cacheParent.put(i18, tLRPC$StickerSetCovered);
                            this.positionToRow.put(i18, i19);
                            if (i4 >= size2 && (tLRPC$StickerSetCovered instanceof TLRPC$StickerSetCovered)) {
                                this.positionsToSets.put(i18, tLRPC$StickerSetCovered);
                            }
                            i16 = i17;
                        }
                        int i20 = iCeil2 + 1;
                        for (int i21 = 0; i21 < i20; i21++) {
                            this.rowStartPack.put(i5 + i21, tLRPC$StickerSetCovered);
                        }
                        this.totalItems += (iCeil2 * EmojiView.this.stickersGridAdapter.stickersPerRow) + 1;
                        i5 += i20;
                    }
                }
                i4++;
                size = i;
                i3 = -1;
            }
            super.notifyDataSetChanged();
        }
    }

    public void searchProgressChanged() {
        updateStickerTabsPosition();
    }

    public float getStickersExpandOffset() {
        ScrollSlidingTabStrip scrollSlidingTabStrip = this.stickersTab;
        if (scrollSlidingTabStrip == null) {
            return 0.0f;
        }
        return scrollSlidingTabStrip.getExpandedOffset();
    }

    public void setShowing(boolean showing) {
        this.showing = showing;
        updateStickerTabsPosition();
    }

    public void onMessageSend() {
        ChooseStickerActionTracker chooseStickerActionTracker = this.chooseStickerActionTracker;
        if (chooseStickerActionTracker != null) {
            chooseStickerActionTracker.reset();
        }
    }

    public static abstract class ChooseStickerActionTracker {
        private final int currentAccount;
        private final long dialogId;
        private final int threadId;
        boolean typingWasSent;
        boolean visible = false;
        long lastActionTime = -1;

        public abstract boolean isShown();

        public ChooseStickerActionTracker(int currentAccount, long dialogId, int threadId) {
            this.currentAccount = currentAccount;
            this.dialogId = dialogId;
            this.threadId = threadId;
        }

        public void doSomeAction() {
            if (this.visible) {
                if (this.lastActionTime == -1) {
                    this.lastActionTime = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.lastActionTime > 2000) {
                    this.typingWasSent = true;
                    this.lastActionTime = System.currentTimeMillis();
                    MessagesController.getInstance(this.currentAccount).sendTyping(this.dialogId, this.threadId, 10, 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            if (this.typingWasSent) {
                MessagesController.getInstance(this.currentAccount).sendTyping(this.dialogId, this.threadId, 2, 0);
            }
            this.lastActionTime = -1L;
        }

        public void checkVisibility() {
            boolean zIsShown = isShown();
            this.visible = zIsShown;
            if (zIsShown) {
                return;
            }
            reset();
        }
    }
}
