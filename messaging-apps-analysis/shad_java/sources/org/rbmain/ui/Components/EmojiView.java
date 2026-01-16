package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.DataSetObserver;
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
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.DocumentObject;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.EmojiData;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$StickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolveUsername;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolvedPeer;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeImageSize;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo;
import org.rbmain.tgnet.TLRPC$TL_emojiURL;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputPeerEmpty;
import org.rbmain.tgnet.TLRPC$TL_messages_foundStickerSets;
import org.rbmain.tgnet.TLRPC$TL_messages_getEmojiURL;
import org.rbmain.tgnet.TLRPC$TL_messages_getInlineBotResults;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_searchStickerSets;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_stickers;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebDocument;
import org.rbmain.tgnet.TLRPC$messages_BotResults;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.ContextLinkCell;
import org.rbmain.ui.Cells.EmptyCell;
import org.rbmain.ui.Cells.FeaturedStickerSetInfoCell;
import org.rbmain.ui.Cells.StickerEmojiCell;
import org.rbmain.ui.Cells.StickerSetGroupInfoCell;
import org.rbmain.ui.Cells.StickerSetNameCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.PagerSlidingTabStrip;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ScrollSlidingTabStrip;
import org.rbmain.ui.Components.TrendingStickersLayout;
import org.rbmain.ui.ContentPreviewViewer;

/* loaded from: classes5.dex */
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
    private ContentPreviewViewer.ContentPreviewViewerDelegate contentPreviewViewerDelegate;
    private int currentAccount;
    private int currentBackgroundType;
    private int currentChatId;
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
    private int favTabBum;
    private ArrayList<TLRPC$Document> favouriteStickers;
    private boolean firstEmojiAttach;
    private boolean firstGifAttach;
    private boolean firstStickersAttach;
    private ImageView floatingButton;
    private boolean forseMultiwindowLayout;
    private BaseFragment fragment;
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
    private int hasRecentEmoji;
    private TLRPC$ChatFull info;
    private LongSparseArray<TLRPC$StickerSetCovered> installingStickerSets;
    private boolean isLayout;
    private float lastBottomScrollDy;
    private int lastNotifyHeight;
    private int lastNotifyHeight2;
    private int lastNotifyWidth;
    private String[] lastSearchKeyboardLanguage;
    private int[] location;
    private TextView mediaBanTooltip;
    private boolean needEmojiSearch;
    private boolean needGifSearch;
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
    private LongSparseArray<TLRPC$StickerSetCovered> removingStickerSets;
    private AnimatorSet searchAnimation;
    private ImageView searchButton;
    private int searchFieldHeight;
    private View shadowLine;
    private Drawable[] stickerIcons;
    private ArrayList<TLRPC$TL_messages_stickerSet> stickerSets;
    private ImageView stickerSettingsButton;
    private AnimatorSet stickersButtonAnimation;
    private FrameLayout stickersContainer;
    private StickersGridAdapter stickersGridAdapter;
    private RecyclerListView stickersGridView;
    private GridLayoutManager stickersLayoutManager;
    private RecyclerListView.OnItemClickListener stickersOnItemClickListener;
    private SearchField stickersSearchField;
    private StickersSearchGridAdapter stickersSearchGridAdapter;
    private ScrollSlidingTabStrip stickersTab;
    private int stickersTabOffset;
    private Drawable[] tabIcons;
    private final int[] tabsMinusDy;
    private ObjectAnimator[] tabsYAnimators;
    private View topShadow;
    private int trendingTabNum;
    private PagerSlidingTabStrip typeTabs;
    private ArrayList<View> views;

    public interface DragListener {
        void onDrag(int i);

        void onDragCancel();

        void onDragEnd(float f);

        void onDragStart();
    }

    public interface EmojiViewDelegate {

        /* renamed from: org.rbmain.ui.Components.EmojiView$EmojiViewDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$canSchedule(EmojiViewDelegate emojiViewDelegate) {
                return false;
            }

            public static long $default$getDialogId(EmojiViewDelegate emojiViewDelegate) {
                return 0L;
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

            public static void $default$onStickerSelected(EmojiViewDelegate emojiViewDelegate, View view, TLRPC$Document tLRPC$Document, String str, Object obj, boolean z, int i) {
            }

            public static void $default$onStickerSetAdd(EmojiViewDelegate emojiViewDelegate, TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
            }

            public static void $default$onStickerSetRemove(EmojiViewDelegate emojiViewDelegate, TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
            }

            public static void $default$onStickersGroupClick(EmojiViewDelegate emojiViewDelegate, int i) {
            }

            public static void $default$onStickersSettingsClick(EmojiViewDelegate emojiViewDelegate) {
            }

            public static void $default$onTabOpened(EmojiViewDelegate emojiViewDelegate, int i) {
            }

            public static void $default$showTrendingStickersAlert(EmojiViewDelegate emojiViewDelegate, TrendingStickersLayout trendingStickersLayout) {
            }
        }

        boolean canSchedule();

        long getDialogId();

        boolean isExpanded();

        boolean isInScheduleMode();

        boolean isSearchOpened();

        boolean onBackspace();

        void onClearEmojiRecent();

        void onEmojiSelected(String str);

        /* renamed from: onGifSelected */
        void lambda$onGifSelected$0(View view, Object obj, String str, Object obj2, boolean z, int i);

        void onSearchOpenClose(int i);

        void onShowStickerSet(TLRPC$StickerSet tLRPC$StickerSet, TLRPC$InputStickerSet tLRPC$InputStickerSet);

        void onStickerSelected(View view, TLRPC$Document tLRPC$Document, String str, Object obj, boolean z, int i);

        void onStickerSetAdd(TLRPC$StickerSetCovered tLRPC$StickerSetCovered);

        void onStickerSetRemove(TLRPC$StickerSetCovered tLRPC$StickerSetCovered);

        void onStickersGroupClick(int i);

        void onStickersSettingsClick();

        void onTabOpened(int i);

        void showTrendingStickersAlert(TrendingStickersLayout trendingStickersLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0() {
    }

    public void onMessageSend() {
    }

    static {
        Field declaredField = null;
        try {
            declaredField = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        superListenerField = declaredField;
        NOP = new ViewTreeObserver.OnScrollChangedListener() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda4
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                EmojiView.lambda$static$0();
            }
        };
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        SearchField searchField = this.stickersSearchField;
        if (searchField != null) {
            searchField.searchEditText.setEnabled(z);
        }
        SearchField searchField2 = this.gifSearchField;
        if (searchField2 != null) {
            searchField2.searchEditText.setEnabled(z);
        }
        SearchField searchField3 = this.emojiSearchField;
        if (searchField3 != null) {
            searchField3.searchEditText.setEnabled(z);
        }
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

        public SearchField(Context context, int i) {
            super(context);
            View view = new View(context);
            this.shadowView = view;
            view.setAlpha(0.0f);
            this.shadowView.setTag(1);
            this.shadowView.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelShadowLine));
            addView(this.shadowView, new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83));
            View view2 = new View(context);
            this.backgroundView = view2;
            view2.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
            addView(this.backgroundView, new FrameLayout.LayoutParams(-1, EmojiView.this.searchFieldHeight));
            View view3 = new View(context);
            this.searchBackground = view3;
            view3.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), Theme.getColor(Theme.key_chat_emojiSearchBackground)));
            addView(this.searchBackground, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 14.0f, 14.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.searchIconImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.searchIconImageView.setImageResource(R.drawable.smiles_inputsearch);
            ImageView imageView2 = this.searchIconImageView;
            int i2 = Theme.key_chat_emojiSearchIcon;
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
            addView(this.searchIconImageView, LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 14.0f, 0.0f, 0.0f));
            ImageView imageView3 = new ImageView(context);
            this.clearSearchImageView = imageView3;
            imageView3.setScaleType(ImageView.ScaleType.CENTER);
            ImageView imageView4 = this.clearSearchImageView;
            CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
            this.progressDrawable = closeProgressDrawable2;
            imageView4.setImageDrawable(closeProgressDrawable2);
            this.progressDrawable.setSide(AndroidUtilities.dp(7.0f));
            this.clearSearchImageView.setScaleX(0.1f);
            this.clearSearchImageView.setScaleY(0.1f);
            this.clearSearchImageView.setAlpha(0.0f);
            this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
            addView(this.clearSearchImageView, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 14.0f, 14.0f, 0.0f));
            this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.EmojiView$SearchField$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    this.f$0.lambda$new$0(view4);
                }
            });
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context, EmojiView.this, i) { // from class: org.rbmain.ui.Components.EmojiView.SearchField.1
                final /* synthetic */ int val$type;

                {
                    this.val$type = i;
                }

                @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    if (!SearchField.this.searchEditText.isEnabled()) {
                        return super.onTouchEvent(motionEvent);
                    }
                    if (motionEvent.getAction() == 0) {
                        if (!EmojiView.this.delegate.isSearchOpened()) {
                            SearchField searchField = SearchField.this;
                            EmojiView.this.openSearch(searchField);
                        }
                        EmojiView.this.delegate.onSearchOpenClose(this.val$type == 1 ? 2 : 1);
                        SearchField.this.searchEditText.requestFocus();
                        AndroidUtilities.showKeyboard(SearchField.this.searchEditText);
                    }
                    return super.onTouchEvent(motionEvent);
                }
            };
            this.searchEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.searchEditText.setHintTextColor(Theme.getColor(i2));
            this.searchEditText.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            this.searchEditText.setBackgroundDrawable(null);
            this.searchEditText.setPadding(0, 0, 0, 0);
            this.searchEditText.setMaxLines(1);
            this.searchEditText.setLines(1);
            this.searchEditText.setSingleLine(true);
            this.searchEditText.setImeOptions(268435459);
            if (i == 0) {
                this.searchEditText.setHint(LocaleController.getString("SearchStickersHint", R.string.SearchStickersHint));
            } else if (i == 1) {
                this.searchEditText.setHint(LocaleController.getString("SearchEmojiHint", R.string.SearchEmojiHint));
            } else if (i == 2) {
                this.searchEditText.setHint(LocaleController.getString("SearchGifsTitle", R.string.SearchGifsTitle));
            }
            this.searchEditText.setCursorColor(Theme.getColor(Theme.key_featuredStickers_addedIcon));
            this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.searchEditText.setCursorWidth(1.5f);
            addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 12.0f, 46.0f, 0.0f));
            this.searchEditText.addTextChangedListener(new TextWatcher(EmojiView.this, i) { // from class: org.rbmain.ui.Components.EmojiView.SearchField.2
                final /* synthetic */ int val$type;

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                {
                    this.val$type = i;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    boolean z = SearchField.this.searchEditText.length() > 0;
                    if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                        SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                    }
                    int i3 = this.val$type;
                    if (i3 == 0) {
                        EmojiView.this.stickersSearchGridAdapter.search(SearchField.this.searchEditText.getText().toString());
                    } else if (i3 == 1) {
                        EmojiView.this.emojiSearchAdapter.search(SearchField.this.searchEditText.getText().toString());
                    } else if (i3 == 2) {
                        EmojiView.this.gifSearchAdapter.search(SearchField.this.searchEditText.getText().toString());
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            this.searchEditText.setText(BuildConfig.FLAVOR);
            AndroidUtilities.showKeyboard(this.searchEditText);
        }

        public void hideKeyboard() {
            AndroidUtilities.hideKeyboard(this.searchEditText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showShadow(boolean z, boolean z2) {
            if (z && this.shadowView.getTag() == null) {
                return;
            }
            if (z || this.shadowView.getTag() == null) {
                AnimatorSet animatorSet = this.shadowAnimator;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.shadowAnimator = null;
                }
                this.shadowView.setTag(z ? null : 1);
                if (z2) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.shadowAnimator = animatorSet2;
                    Animator[] animatorArr = new Animator[1];
                    View view = this.shadowView;
                    Property property = View.ALPHA;
                    float[] fArr = new float[1];
                    fArr[0] = z ? 1.0f : 0.0f;
                    animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                    animatorSet2.playTogether(animatorArr);
                    this.shadowAnimator.setDuration(200L);
                    this.shadowAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                    this.shadowAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.EmojiView.SearchField.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            SearchField.this.shadowAnimator = null;
                        }
                    });
                    this.shadowAnimator.start();
                    return;
                }
                this.shadowView.setAlpha(z ? 1.0f : 0.0f);
            }
        }
    }

    private class TypedScrollListener extends RecyclerView.OnScrollListener {
        private boolean smoothScrolling;
        private final int type;

        public TypedScrollListener(int i) {
            this.type = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (recyclerView.getLayoutManager().isSmoothScrolling()) {
                this.smoothScrolling = true;
                return;
            }
            if (i == 0) {
                if (!this.smoothScrolling) {
                    EmojiView.this.animateTabsY(this.type);
                }
                this.smoothScrolling = false;
                return;
            }
            if (i == 1) {
                SearchField searchFieldForType = EmojiView.this.getSearchFieldForType(this.type);
                if (searchFieldForType != null) {
                    searchFieldForType.hideKeyboard();
                }
                this.smoothScrolling = false;
            }
            if (this.smoothScrolling) {
                return;
            }
            EmojiView.this.stopAnimatingTabsY(this.type);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            EmojiView.this.checkScroll(this.type);
            EmojiView.this.checkTabsY(this.type, i2);
            checkSearchFieldScroll();
            if (this.smoothScrolling) {
                return;
            }
            EmojiView.this.checkBottomTabScroll(i2);
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

        public DraggableScrollSlidingTabStrip(Context context) {
            super(context);
            this.first = true;
            this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (motionEvent.getAction() == 0) {
                this.draggingHorizontally = false;
                this.draggingVertically = false;
                this.downX = motionEvent.getRawX();
                this.downY = motionEvent.getRawY();
            } else if (!this.draggingVertically && !this.draggingHorizontally && EmojiView.this.dragListener != null && Math.abs(motionEvent.getRawY() - this.downY) >= this.touchSlop) {
                this.draggingVertically = true;
                this.downY = motionEvent.getRawY();
                EmojiView.this.dragListener.onDragStart();
                if (this.startedScroll) {
                    EmojiView.this.pager.endFakeDrag();
                    this.startedScroll = false;
                }
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.widget.HorizontalScrollView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
            if (this.first) {
                this.first = false;
                this.lastX = motionEvent.getX();
            }
            if (motionEvent.getAction() == 0) {
                this.draggingHorizontally = false;
                this.draggingVertically = false;
                this.downX = motionEvent.getRawX();
                this.downY = motionEvent.getRawY();
            } else if (!this.draggingVertically && !this.draggingHorizontally && EmojiView.this.dragListener != null) {
                if (Math.abs(motionEvent.getRawX() - this.downX) >= this.touchSlop) {
                    this.draggingHorizontally = true;
                } else if (Math.abs(motionEvent.getRawY() - this.downY) >= this.touchSlop) {
                    this.draggingVertically = true;
                    this.downY = motionEvent.getRawY();
                    EmojiView.this.dragListener.onDragStart();
                    if (this.startedScroll) {
                        EmojiView.this.pager.endFakeDrag();
                        this.startedScroll = false;
                    }
                }
            }
            if (this.draggingVertically) {
                if (this.vTracker == null) {
                    this.vTracker = VelocityTracker.obtain();
                }
                this.vTracker.addMovement(motionEvent);
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    EmojiView.this.dragListener.onDrag(Math.round(motionEvent.getRawY() - this.downY));
                } else {
                    this.vTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE);
                    float yVelocity = this.vTracker.getYVelocity();
                    this.vTracker.recycle();
                    this.vTracker = null;
                    if (motionEvent.getAction() == 1) {
                        EmojiView.this.dragListener.onDragEnd(yVelocity);
                    } else {
                        EmojiView.this.dragListener.onDragCancel();
                    }
                    this.first = true;
                    this.draggingHorizontally = false;
                    this.draggingVertically = false;
                }
                return true;
            }
            float translationX = getTranslationX();
            if (getScrollX() == 0 && translationX == 0.0f) {
                if (!this.startedScroll && this.lastX - motionEvent.getX() < 0.0f) {
                    if (EmojiView.this.pager.beginFakeDrag()) {
                        this.startedScroll = true;
                        this.lastTranslateX = getTranslationX();
                    }
                } else if (this.startedScroll && this.lastX - motionEvent.getX() > 0.0f && EmojiView.this.pager.isFakeDragging()) {
                    EmojiView.this.pager.endFakeDrag();
                    this.startedScroll = false;
                }
            }
            if (this.startedScroll) {
                motionEvent.getX();
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
            this.lastX = motionEvent.getX();
            if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.first = true;
                this.draggingHorizontally = false;
                this.draggingVertically = false;
                if (this.startedScroll) {
                    EmojiView.this.pager.endFakeDrag();
                    this.startedScroll = false;
                }
            }
            return this.startedScroll || super.onTouchEvent(motionEvent);
        }
    }

    private class ImageViewEmoji extends ImageView {
        private boolean isRecent;

        public ImageViewEmoji(Context context) {
            super(context);
            setScaleType(ImageView.ScaleType.CENTER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendEmoji(String str) {
            String str2;
            EmojiView.this.showBottomTab(true, true);
            String strAddColorToCode = str != null ? str : (String) getTag();
            new SpannableStringBuilder().append((CharSequence) strAddColorToCode);
            if (str != null) {
                if (EmojiView.this.delegate != null) {
                    EmojiView.this.delegate.onEmojiSelected(Emoji.fixEmoji(str));
                    return;
                }
                return;
            }
            if (!this.isRecent && (str2 = Emoji.emojiColor.get(strAddColorToCode)) != null) {
                strAddColorToCode = EmojiView.addColorToCode(strAddColorToCode, str2);
            }
            EmojiView.this.addEmojiToRecent(strAddColorToCode);
            if (EmojiView.this.delegate != null) {
                EmojiView.this.delegate.onEmojiSelected(Emoji.fixEmoji(strAddColorToCode));
            }
        }

        public void setImageDrawable(Drawable drawable, boolean z) {
            super.setImageDrawable(drawable);
            this.isRecent = z;
        }

        @Override // android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i));
        }
    }

    private class EmojiPopupWindow extends PopupWindow {
        private ViewTreeObserver.OnScrollChangedListener mSuperScrollListener;
        private ViewTreeObserver mViewTreeObserver;

        public EmojiPopupWindow(EmojiView emojiView, View view, int i, int i2) throws IllegalAccessException, IllegalArgumentException {
            super(view, i, i2);
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

        private void registerListener(View view) {
            if (this.mSuperScrollListener != null) {
                ViewTreeObserver viewTreeObserver = view.getWindowToken() != null ? view.getViewTreeObserver() : null;
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
        public void showAsDropDown(View view, int i, int i2) {
            try {
                super.showAsDropDown(view, i, i2);
                registerListener(view);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // android.widget.PopupWindow
        public void update(View view, int i, int i2, int i3, int i4) {
            super.update(view, i, i2, i3, i4);
            registerListener(view);
        }

        @Override // android.widget.PopupWindow
        public void update(View view, int i, int i2) {
            super.update(view, i, i2);
            registerListener(view);
        }

        @Override // android.widget.PopupWindow
        public void showAtLocation(View view, int i, int i2, int i3) {
            super.showAtLocation(view, i, i2, i3);
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

        public void setEmoji(String str, int i) {
            this.currentEmoji = str;
            this.arrowX = i;
            this.rectPaint.setColor(788529152);
            invalidate();
        }

        public void setSelection(int i) {
            if (this.selection == i) {
                return;
            }
            this.selection = i;
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
            Drawable drawable = this.backgroundDrawable;
            int i = Theme.key_dialogBackground;
            Theme.setDrawableColor(drawable, Theme.getColor(i));
            Theme.setDrawableColor(this.arrowDrawable, Theme.getColor(i));
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
                        strAddColorToCode = EmojiView.addColorToCode(strAddColorToCode, i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? BuildConfig.FLAVOR : "🏿" : "🏾" : "🏽" : "🏼" : "🏻");
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

    public EmojiView(BaseFragment baseFragment, boolean z, boolean z2, final Context context, final boolean z3, TLRPC$ChatFull tLRPC$ChatFull) throws Resources.NotFoundException {
        super(context);
        this.views = new ArrayList<>();
        int i = 1;
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
        this.primaryInstallingStickerSets = new TLRPC$StickerSetCovered[10];
        this.installingStickerSets = new LongSparseArray<>();
        this.removingStickerSets = new LongSparseArray<>();
        this.location = new int[2];
        this.recentTabBum = -2;
        this.favTabBum = -2;
        this.trendingTabNum = -2;
        this.currentBackgroundType = -1;
        this.contentPreviewViewerDelegate = new ContentPreviewViewer.ContentPreviewViewerDelegate() { // from class: org.rbmain.ui.Components.EmojiView.1
            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ Boolean canSetAsStatus(TLRPC$Document tLRPC$Document) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$canSetAsStatus(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void copyEmoji(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$copyEmoji(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needCopy() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needCopy(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needMenu() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needMenu(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needOpen() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needOpen(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemove() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemove(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemoveFromRecent(TLRPC$Document tLRPC$Document) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemoveFromRecent(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void removeFromRecent(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$removeFromRecent(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void resetTouch() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$resetTouch(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendEmoji(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendEmoji(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void setAsEmojiStatus(TLRPC$Document tLRPC$Document, Integer num) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$setAsEmojiStatus(this, tLRPC$Document, num);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean can() {
                return EmojiView.this.fragment != null;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendSticker(TLRPC$Document tLRPC$Document, String str, Object obj, boolean z4, int i2) {
                EmojiView.this.delegate.onStickerSelected(null, tLRPC$Document, str, obj, z4, i2);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needSend(int i2) {
                if (i2 != 2) {
                    return true;
                }
                if ((EmojiView.this.fragment instanceof ChatActivity) && ((ChatActivity) EmojiView.this.fragment).canSendMessage()) {
                    if (UserConfig.getInstance(UserConfig.selectedAccount).isPremium()) {
                        return true;
                    }
                    if (((ChatActivity) EmojiView.this.fragment).getCurrentUser() != null && UserObject.isUserSelf(((ChatActivity) EmojiView.this.fragment).getCurrentUser())) {
                        return true;
                    }
                }
                return false;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean canSchedule() {
                return EmojiView.this.delegate.canSchedule();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean isInScheduleMode() {
                return EmojiView.this.delegate.isInScheduleMode();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void openSet(TLRPC$InputStickerSet tLRPC$InputStickerSet, boolean z4) {
                if (tLRPC$InputStickerSet == null) {
                    return;
                }
                EmojiView.this.delegate.onShowStickerSet(null, tLRPC$InputStickerSet);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendGif(Object obj, Object obj2, boolean z4, int i2) {
                if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifAdapter) {
                    EmojiView.this.delegate.lambda$onGifSelected$0(null, obj, null, obj2, z4, i2);
                } else if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifSearchAdapter) {
                    EmojiView.this.delegate.lambda$onGifSelected$0(null, obj, null, obj2, z4, i2);
                }
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void gifAddedOrDeleted() {
                EmojiView.this.updateRecentGifs();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public long getDialogId() {
                return EmojiView.this.delegate.getDialogId();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public String getQuery(boolean z4) {
                if (z4) {
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
        this.fragment = baseFragment;
        int i2 = Theme.key_chat_emojiBottomPanelIcon;
        int color = Theme.getColor(i2);
        int iArgb = Color.argb(30, Color.red(color), Color.green(color), Color.blue(color));
        this.searchFieldHeight = AndroidUtilities.dp(64.0f);
        this.needEmojiSearch = z3;
        int color2 = Theme.getColor(i2);
        int i3 = Theme.key_chat_emojiPanelIconSelected;
        this.tabIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_tab_smiles, color2, Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_tab_gif, Theme.getColor(i2), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_tab_stickers, Theme.getColor(i2), Theme.getColor(i3))};
        int i4 = Theme.key_chat_emojiPanelIcon;
        this.emojiIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_recent, Theme.getColor(i4), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_smiles, Theme.getColor(i4), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_cat, Theme.getColor(i4), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_food, Theme.getColor(i4), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_activities, Theme.getColor(i4), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_travel, Theme.getColor(i4), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_objects, Theme.getColor(i4), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_other, Theme.getColor(i4), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_panel_flags, Theme.getColor(i4), Theme.getColor(i3))};
        int i5 = Theme.key_chat_emojiPanelStickerPackSelectorLine;
        this.stickerIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_recent, Theme.getColor(i2), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_favorites, Theme.getColor(i2), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_trending3, Theme.getColor(i2), Theme.getColor(i3)), new LayerDrawable(new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_trending1, Theme.getColor(i2), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_trending2, Theme.getColor(i5), Theme.getColor(i5))})};
        this.gifIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_recent, Theme.getColor(i2), Theme.getColor(i3)), Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_gifs_trending, Theme.getColor(i2), Theme.getColor(i3))};
        this.emojiTitles = new String[]{LocaleController.getString("Emoji1", R.string.Emoji1), LocaleController.getString("Emoji2", R.string.Emoji2), LocaleController.getString("Emoji3", R.string.Emoji3), LocaleController.getString("Emoji4", R.string.Emoji4), LocaleController.getString("Emoji5", R.string.Emoji5), LocaleController.getString("Emoji6", R.string.Emoji6), LocaleController.getString("Emoji7", R.string.Emoji7), LocaleController.getString("Emoji8", R.string.Emoji8)};
        this.info = tLRPC$ChatFull;
        Paint paint = new Paint(1);
        this.dotPaint = paint;
        paint.setColor(Theme.getColor(Theme.key_chat_emojiPanelNewTrending));
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 21) {
            this.outlineProvider = new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.EmojiView.2
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(view.getPaddingLeft(), view.getPaddingTop(), view.getMeasuredWidth() - view.getPaddingRight(), view.getMeasuredHeight() - view.getPaddingBottom(), AndroidUtilities.dp(6.0f));
                }
            };
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.emojiContainer = frameLayout;
        this.views.add(frameLayout);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.EmojiView.3
            private boolean ignoreLayout;

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            protected void onMeasure(int i7, int i8) {
                this.ignoreLayout = true;
                EmojiView.this.emojiLayoutManager.setSpanCount(Math.max(1, View.MeasureSpec.getSize(i7) / AndroidUtilities.dp(AndroidUtilities.isTablet() ? 60.0f : 45.0f)));
                this.ignoreLayout = false;
                super.onMeasure(i7, i8);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z4, int i7, int i8, int i9, int i10) {
                if (EmojiView.this.needEmojiSearch && EmojiView.this.firstEmojiAttach) {
                    this.ignoreLayout = true;
                    EmojiView.this.emojiLayoutManager.scrollToPositionWithOffset(1, 0);
                    EmojiView.this.firstEmojiAttach = false;
                    this.ignoreLayout = false;
                }
                super.onLayout(z4, i7, i8, i9, i10);
                EmojiView.this.checkEmojiSearchFieldScroll(true);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouchEvent(android.view.MotionEvent r12) {
                /*
                    Method dump skipped, instructions count: 436
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.EmojiView.AnonymousClass3.onTouchEvent(android.view.MotionEvent):boolean");
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
        RecyclerListView recyclerListView3 = this.emojiGridView;
        int i7 = Theme.key_chat_emojiPanelBackground;
        recyclerListView3.setGlowColor(Theme.getColor(i7));
        this.emojiGridView.setClipToPadding(false);
        this.emojiLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.Components.EmojiView.4
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i8) {
                if (EmojiView.this.emojiGridView.getAdapter() != EmojiView.this.emojiSearchAdapter) {
                    if ((EmojiView.this.needEmojiSearch && i8 == 0) || EmojiView.this.emojiAdapter.positionToSection.indexOfKey(i8) >= 0) {
                        return EmojiView.this.emojiLayoutManager.getSpanCount();
                    }
                } else if (i8 == 0 || (i8 == 1 && EmojiView.this.emojiSearchAdapter.searchWas && EmojiView.this.emojiSearchAdapter.result.isEmpty())) {
                    return EmojiView.this.emojiLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
        RecyclerListView recyclerListView4 = this.emojiGridView;
        EmojiGridAdapter emojiGridAdapter = new EmojiGridAdapter();
        this.emojiAdapter = emojiGridAdapter;
        recyclerListView4.setAdapter(emojiGridAdapter);
        this.emojiSearchAdapter = new EmojiSearchAdapter();
        this.emojiContainer.addView(this.emojiGridView, LayoutHelper.createFrame(-1, -1.0f));
        this.emojiGridView.setOnScrollListener(new TypedScrollListener(i) { // from class: org.rbmain.ui.Components.EmojiView.5
            @Override // org.rbmain.ui.Components.EmojiView.TypedScrollListener, androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i8, int i9) {
                int i10;
                int iFindFirstVisibleItemPosition = EmojiView.this.emojiLayoutManager.findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition != -1) {
                    int size = Emoji.recentEmoji.size() + (EmojiView.this.needEmojiSearch ? 1 : 0);
                    if (iFindFirstVisibleItemPosition >= size) {
                        int i11 = 0;
                        while (true) {
                            String[][] strArr = EmojiData.dataColored;
                            if (i11 >= strArr.length) {
                                break;
                            }
                            size += strArr[i11].length + 1;
                            if (iFindFirstVisibleItemPosition < size) {
                                i10 = i11 + (!Emoji.recentEmoji.isEmpty() ? 1 : 0);
                                break;
                            }
                            i11++;
                        }
                        EmojiView.this.emojiTabs.onPageScrolled(i10, 0);
                    } else {
                        i10 = 0;
                        EmojiView.this.emojiTabs.onPageScrolled(i10, 0);
                    }
                }
                super.onScrolled(recyclerView, i8, i9);
            }
        });
        this.emojiGridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener(this) { // from class: org.rbmain.ui.Components.EmojiView.6
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int i8) {
                if (view instanceof ImageViewEmoji) {
                    ((ImageViewEmoji) view).sendEmoji(null);
                }
            }
        });
        this.emojiGridView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.Components.EmojiView.7
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x0189  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x0199  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x019c  */
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onItemClick(android.view.View r18, int r19) {
                /*
                    Method dump skipped, instructions count: 562
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.EmojiView.AnonymousClass7.onItemClick(android.view.View, int):boolean");
            }
        });
        this.emojiTabs = new ScrollSlidingTabStrip(context) { // from class: org.rbmain.ui.Components.EmojiView.8
            @Override // android.view.View
            public void setTranslationY(float f) {
                super.setTranslationY(f);
                if (EmojiView.this.emojiTabsShadow != null) {
                    EmojiView.this.emojiTabsShadow.setTranslationY(f);
                }
            }
        };
        if (z3) {
            SearchField searchField = new SearchField(context, 1);
            this.emojiSearchField = searchField;
            searchField.searchEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: org.rbmain.ui.Components.EmojiView.9
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z4) {
                    if (z4) {
                        EmojiView.this.lastSearchKeyboardLanguage = AndroidUtilities.getCurrentKeyboardLanguage();
                        MediaDataController.getInstance(EmojiView.this.currentAccount).fetchNewEmojiKeywords(EmojiView.this.lastSearchKeyboardLanguage);
                    }
                }
            });
        }
        this.emojiTabs.setShouldExpand(true);
        this.emojiTabs.setIndicatorHeight(-1);
        this.emojiTabs.setUnderlineHeight(-1);
        this.emojiTabs.setBackgroundColor(Theme.getColor(i7));
        this.emojiContainer.addView(this.emojiTabs, LayoutHelper.createFrame(-1, 38.0f));
        this.emojiTabs.setDelegate(new ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate() { // from class: org.rbmain.ui.Components.EmojiView.10
            @Override // org.rbmain.ui.Components.ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i8) {
                if (!Emoji.recentEmoji.isEmpty()) {
                    if (i8 == 0) {
                        EmojiView.this.emojiLayoutManager.scrollToPositionWithOffset(EmojiView.this.needEmojiSearch ? 1 : 0, 0);
                        return;
                    }
                    i8--;
                }
                EmojiView.this.emojiGridView.stopScroll();
                EmojiView.this.emojiLayoutManager.scrollToPositionWithOffset(EmojiView.this.emojiAdapter.sectionToPosition.get(i8), 0);
                EmojiView.this.checkEmojiTabY(null, 0);
            }
        });
        View view = new View(context);
        this.emojiTabsShadow = view;
        view.setAlpha(0.0f);
        this.emojiTabsShadow.setTag(1);
        View view2 = this.emojiTabsShadow;
        int i8 = Theme.key_chat_emojiPanelShadowLine;
        view2.setBackgroundColor(Theme.getColor(i8));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp(38.0f);
        this.emojiContainer.addView(this.emojiTabsShadow, layoutParams);
        if (z) {
            if (z2) {
                FrameLayout frameLayout2 = new FrameLayout(context);
                this.gifContainer = frameLayout2;
                this.views.add(frameLayout2);
                RecyclerListView recyclerListView5 = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.EmojiView.11
                    private boolean ignoreLayout;
                    private boolean wasMeasured;

                    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                        return super.onInterceptTouchEvent(motionEvent) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(motionEvent, EmojiView.this.gifGridView, 0, EmojiView.this.contentPreviewViewerDelegate, null);
                    }

                    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
                    protected void onMeasure(int i9, int i10) {
                        super.onMeasure(i9, i10);
                        if (this.wasMeasured) {
                            return;
                        }
                        EmojiView.this.gifAdapter.notifyDataSetChanged();
                        this.wasMeasured = true;
                    }

                    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean z4, int i9, int i10, int i11, int i12) {
                        if (EmojiView.this.firstGifAttach && EmojiView.this.gifAdapter.getItemCount() > 1) {
                            this.ignoreLayout = true;
                            EmojiView.this.gifLayoutManager.scrollToPositionWithOffset(1, 0);
                            EmojiView.this.gifTabs.onPageScrolled(0, 0);
                            EmojiView.this.firstGifAttach = false;
                            this.ignoreLayout = false;
                        }
                        super.onLayout(z4, i9, i10, i11, i12);
                        EmojiView.this.checkGifSearchFieldScroll(true);
                    }

                    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
                    public void requestLayout() {
                        if (this.ignoreLayout) {
                            return;
                        }
                        super.requestLayout();
                    }
                };
                this.gifGridView = recyclerListView5;
                recyclerListView5.setClipToPadding(false);
                RecyclerListView recyclerListView6 = this.gifGridView;
                GifLayoutManager gifLayoutManager = new GifLayoutManager(context);
                this.gifLayoutManager = gifLayoutManager;
                recyclerListView6.setLayoutManager(gifLayoutManager);
                this.gifGridView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: org.rbmain.ui.Components.EmojiView.12
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(android.graphics.Rect rect, View view3, RecyclerView recyclerView, RecyclerView.State state) {
                        int childAdapterPosition = recyclerView.getChildAdapterPosition(view3);
                        if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifAdapter && childAdapterPosition == EmojiView.this.gifAdapter.trendingSectionItem) {
                            rect.set(0, 0, 0, 0);
                            return;
                        }
                        if (childAdapterPosition != 0) {
                            rect.left = 0;
                            rect.bottom = 0;
                            rect.top = AndroidUtilities.dp(2.0f);
                            rect.right = EmojiView.this.gifLayoutManager.isLastInRow(childAdapterPosition + (-1)) ? 0 : AndroidUtilities.dp(2.0f);
                            return;
                        }
                        rect.set(0, 0, 0, 0);
                    }
                });
                this.gifGridView.setPadding(0, AndroidUtilities.dp(52.0f), 0, AndroidUtilities.dp(44.0f));
                this.gifGridView.setOverScrollMode(2);
                ((SimpleItemAnimator) this.gifGridView.getItemAnimator()).setSupportsChangeAnimations(false);
                RecyclerListView recyclerListView7 = this.gifGridView;
                GifAdapter gifAdapter = new GifAdapter(this, context, true);
                this.gifAdapter = gifAdapter;
                recyclerListView7.setAdapter(gifAdapter);
                this.gifSearchAdapter = new GifAdapter(this, context);
                this.gifGridView.setOnScrollListener(new TypedScrollListener(2));
                this.gifGridView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view3, MotionEvent motionEvent) {
                        return this.f$0.lambda$new$1(view3, motionEvent);
                    }
                });
                RecyclerListView.OnItemClickListener onItemClickListener = new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda8
                    @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                    public final void onItemClick(View view3, int i9) {
                        this.f$0.lambda$new$2(z3, view3, i9);
                    }
                };
                this.gifOnItemClickListener = onItemClickListener;
                this.gifGridView.setOnItemClickListener(onItemClickListener);
                this.gifContainer.addView(this.gifGridView, LayoutHelper.createFrame(-1, -1.0f));
                this.gifSearchField = new SearchField(context, 2);
                DraggableScrollSlidingTabStrip draggableScrollSlidingTabStrip = new DraggableScrollSlidingTabStrip(context);
                this.gifTabs = draggableScrollSlidingTabStrip;
                draggableScrollSlidingTabStrip.setType(ScrollSlidingTabStrip.Type.TAB);
                this.gifTabs.setUnderlineHeight(AndroidUtilities.getShadowHeight());
                this.gifTabs.setIndicatorColor(Theme.getColor(i5));
                this.gifTabs.setUnderlineColor(Theme.getColor(i8));
                this.gifTabs.setBackgroundColor(Theme.getColor(i7));
                this.gifContainer.addView(this.gifTabs, LayoutHelper.createFrame(-1, 48, 51));
                updateGifTabs();
                this.gifTabs.setDelegate(new ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda9
                    @Override // org.rbmain.ui.Components.ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate
                    public final void onPageSelected(int i9) {
                        this.f$0.lambda$new$3(i9);
                    }
                });
                this.gifAdapter.loadTrendingGifs();
            }
            this.stickersContainer = new FrameLayout(context);
            MediaDataController.getInstance(this.currentAccount).checkStickers(0);
            MediaDataController.getInstance(this.currentAccount).checkFeaturedStickers();
            RecyclerListView recyclerListView8 = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.EmojiView.13
                boolean ignoreLayout;

                @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                    return super.onInterceptTouchEvent(motionEvent) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(motionEvent, EmojiView.this.stickersGridView, EmojiView.this.getMeasuredHeight(), EmojiView.this.contentPreviewViewerDelegate, null);
                }

                @Override // org.rbmain.ui.Components.RecyclerListView, android.view.View
                public void setVisibility(int i9) {
                    super.setVisibility(i9);
                }

                @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean z4, int i9, int i10, int i11, int i12) {
                    if (EmojiView.this.firstStickersAttach && EmojiView.this.stickersGridAdapter.getItemCount() > 0) {
                        this.ignoreLayout = true;
                        EmojiView.this.stickersLayoutManager.scrollToPositionWithOffset(1, 0);
                        EmojiView.this.firstStickersAttach = false;
                        this.ignoreLayout = false;
                    }
                    super.onLayout(z4, i9, i10, i11, i12);
                    EmojiView.this.checkStickersSearchFieldScroll(true);
                }

                @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
                public void requestLayout() {
                    if (this.ignoreLayout) {
                        return;
                    }
                    super.requestLayout();
                }
            };
            this.stickersGridView = recyclerListView8;
            GridLayoutManager gridLayoutManager2 = new GridLayoutManager(context, 5);
            this.stickersLayoutManager = gridLayoutManager2;
            recyclerListView8.setLayoutManager(gridLayoutManager2);
            this.stickersLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.Components.EmojiView.14
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i9) {
                    if (EmojiView.this.stickersGridView.getAdapter() != EmojiView.this.stickersGridAdapter) {
                        if (i9 == EmojiView.this.stickersSearchGridAdapter.totalItems || !(EmojiView.this.stickersSearchGridAdapter.cache.get(i9) == null || (EmojiView.this.stickersSearchGridAdapter.cache.get(i9) instanceof TLRPC$Document))) {
                            return EmojiView.this.stickersGridAdapter.stickersPerRow;
                        }
                        return 1;
                    }
                    if (i9 == 0) {
                        return EmojiView.this.stickersGridAdapter.stickersPerRow;
                    }
                    if (i9 == EmojiView.this.stickersGridAdapter.totalItems || !(EmojiView.this.stickersGridAdapter.cache.get(i9) == null || (EmojiView.this.stickersGridAdapter.cache.get(i9) instanceof TLRPC$Document))) {
                        return EmojiView.this.stickersGridAdapter.stickersPerRow;
                    }
                    return 1;
                }
            });
            this.stickersGridView.setPadding(0, AndroidUtilities.dp(52.0f), 0, AndroidUtilities.dp(44.0f));
            this.stickersGridView.setClipToPadding(false);
            this.views.add(this.stickersContainer);
            this.stickersSearchGridAdapter = new StickersSearchGridAdapter(context);
            RecyclerListView recyclerListView9 = this.stickersGridView;
            StickersGridAdapter stickersGridAdapter = new StickersGridAdapter(context);
            this.stickersGridAdapter = stickersGridAdapter;
            recyclerListView9.setAdapter(stickersGridAdapter);
            this.stickersGridView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    return this.f$0.lambda$new$4(view3, motionEvent);
                }
            });
            RecyclerListView.OnItemClickListener onItemClickListener2 = new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda7
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view3, int i9) {
                    this.f$0.lambda$new$5(view3, i9);
                }
            };
            this.stickersOnItemClickListener = onItemClickListener2;
            this.stickersGridView.setOnItemClickListener(onItemClickListener2);
            this.stickersGridView.setGlowColor(Theme.getColor(i7));
            this.stickersContainer.addView(this.stickersGridView);
            SearchField searchField2 = new SearchField(context, 0);
            this.stickersSearchField = searchField2;
            this.stickersContainer.addView(searchField2, new FrameLayout.LayoutParams(-1, this.searchFieldHeight + AndroidUtilities.getShadowHeight()));
            DraggableScrollSlidingTabStrip draggableScrollSlidingTabStrip2 = new DraggableScrollSlidingTabStrip(context);
            this.stickersTab = draggableScrollSlidingTabStrip2;
            draggableScrollSlidingTabStrip2.setType(ScrollSlidingTabStrip.Type.TAB);
            this.stickersTab.setUnderlineHeight(AndroidUtilities.getShadowHeight());
            this.stickersTab.setIndicatorColor(Theme.getColor(i5));
            this.stickersTab.setUnderlineColor(Theme.getColor(i8));
            this.stickersTab.setBackgroundColor(Theme.getColor(i7));
            this.stickersContainer.addView(this.stickersTab, LayoutHelper.createFrame(-1, 48, 51));
            updateStickerTabs();
            this.stickersTab.setDelegate(new ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda10
                @Override // org.rbmain.ui.Components.ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate
                public final void onPageSelected(int i9) {
                    this.f$0.lambda$new$6(context, i9);
                }
            });
            this.stickersGridView.setOnScrollListener(new TypedScrollListener(0));
        }
        ViewPager viewPager = new ViewPager(context) { // from class: org.rbmain.ui.Components.EmojiView.16
            @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1));
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // androidx.viewpager.widget.ViewPager
            public void setCurrentItem(int i9, boolean z4) throws Resources.NotFoundException {
                EmojiView.this.startStopVisibleGifs(i9 == 1);
                if (i9 != getCurrentItem()) {
                    super.setCurrentItem(i9, z4);
                    return;
                }
                if (i9 == 0) {
                    EmojiView.this.emojiGridView.smoothScrollToPosition(EmojiView.this.needEmojiSearch ? 1 : 0);
                } else if (i9 == 1) {
                    EmojiView.this.gifGridView.smoothScrollToPosition(1);
                } else {
                    EmojiView.this.stickersGridView.smoothScrollToPosition(1);
                }
            }
        };
        this.pager = viewPager;
        viewPager.setAdapter(new EmojiPagesAdapter());
        View view3 = new View(context);
        this.topShadow = view3;
        view3.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, -1907225));
        addView(this.topShadow, LayoutHelper.createFrame(-1, 6.0f));
        ImageView imageView = new ImageView(context) { // from class: org.rbmain.ui.Components.EmojiView.17
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    EmojiView.this.backspacePressed = true;
                    EmojiView.this.backspaceOnce = false;
                    EmojiView.this.postBackspaceRunnable(350);
                } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    EmojiView.this.backspacePressed = false;
                    if (!EmojiView.this.backspaceOnce && EmojiView.this.delegate != null && EmojiView.this.delegate.onBackspace()) {
                        EmojiView.this.backspaceButton.performHapticFeedback(3);
                    }
                }
                super.onTouchEvent(motionEvent);
                return true;
            }
        };
        this.backspaceButton = imageView;
        imageView.setImageResource(R.drawable.smiles_tab_clear);
        ImageView imageView2 = this.backspaceButton;
        int i9 = Theme.key_chat_emojiPanelBackspace;
        imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i9), PorterDuff.Mode.MULTIPLY));
        this.backspaceButton.setScaleType(ImageView.ScaleType.CENTER);
        this.backspaceButton.setContentDescription(LocaleController.getString("AccDescrBackspace", R.string.AccDescrBackspace));
        this.backspaceButton.setFocusable(true);
        this.backspaceButton.setOnClickListener(new View.OnClickListener(this) { // from class: org.rbmain.ui.Components.EmojiView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view4) {
            }
        });
        FrameLayout frameLayout3 = new FrameLayout(this, context) { // from class: org.rbmain.ui.Components.EmojiView.19
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
        };
        this.bottomTabContainer = frameLayout3;
        frameLayout3.setClickable(true);
        View view4 = new View(context);
        this.shadowLine = view4;
        view4.setBackgroundColor(Theme.getColor(i8));
        this.bottomTabContainer.addView(this.shadowLine, new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight()));
        View view5 = new View(context);
        this.bottomTabContainerBackground = view5;
        this.bottomTabContainer.addView(view5, new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(44.0f), 83));
        if (z3) {
            addView(this.bottomTabContainer, new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(44.0f) + AndroidUtilities.getShadowHeight(), 83));
            this.bottomTabContainer.addView(this.backspaceButton, LayoutHelper.createFrame(52, 44, 85));
            if (i6 >= 21) {
                this.backspaceButton.setBackground(Theme.createSelectorDrawable(iArgb));
            }
            ImageView imageView3 = new ImageView(context);
            this.stickerSettingsButton = imageView3;
            imageView3.setImageResource(R.drawable.smiles_tab_settings);
            this.stickerSettingsButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i9), PorterDuff.Mode.MULTIPLY));
            this.stickerSettingsButton.setScaleType(ImageView.ScaleType.CENTER);
            this.stickerSettingsButton.setFocusable(true);
            if (i6 >= 21) {
                this.stickerSettingsButton.setBackground(Theme.createSelectorDrawable(iArgb));
            }
            this.stickerSettingsButton.setContentDescription(LocaleController.getString("Settings", R.string.Settings));
            this.bottomTabContainer.addView(this.stickerSettingsButton, LayoutHelper.createFrame(52, 44, 85));
            this.stickerSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.EmojiView.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
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
            this.typeTabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: org.rbmain.ui.Components.EmojiView.21
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i10) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i10, float f, int i11) {
                    EmojiView emojiView = EmojiView.this;
                    emojiView.onPageScrolled(i10, (emojiView.getMeasuredWidth() - EmojiView.this.getPaddingLeft()) - EmojiView.this.getPaddingRight(), i11);
                    boolean z4 = true;
                    EmojiView.this.showBottomTab(true, true);
                    int currentItem = EmojiView.this.pager.getCurrentItem();
                    SearchField searchField3 = currentItem == 0 ? EmojiView.this.emojiSearchField : currentItem == 1 ? EmojiView.this.gifSearchField : EmojiView.this.stickersSearchField;
                    String string = searchField3.searchEditText.getText().toString();
                    int i12 = 0;
                    while (i12 < 3) {
                        SearchField searchField4 = i12 == 0 ? EmojiView.this.emojiSearchField : i12 == 1 ? EmojiView.this.gifSearchField : EmojiView.this.stickersSearchField;
                        if (searchField4 != null && searchField4 != searchField3 && searchField4.searchEditText != null && !searchField4.searchEditText.getText().toString().equals(string)) {
                            searchField4.searchEditText.setText(string);
                            searchField4.searchEditText.setSelection(string.length());
                        }
                        i12++;
                    }
                    EmojiView emojiView2 = EmojiView.this;
                    if ((i10 != 0 || f <= 0.0f) && i10 != 1) {
                        z4 = false;
                    }
                    emojiView2.startStopVisibleGifs(z4);
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i10) {
                    EmojiView.this.saveNewPage();
                    EmojiView.this.showBackspaceButton(i10 == 0, true);
                    EmojiView.this.showStickerSettingsButton(i10 == 2, true);
                    if (EmojiView.this.delegate.isSearchOpened()) {
                        if (i10 == 0) {
                            if (EmojiView.this.emojiSearchField != null) {
                                EmojiView.this.emojiSearchField.searchEditText.requestFocus();
                            }
                        } else if (i10 == 1) {
                            if (EmojiView.this.gifSearchField != null) {
                                EmojiView.this.gifSearchField.searchEditText.requestFocus();
                            }
                        } else if (EmojiView.this.stickersSearchField != null) {
                            EmojiView.this.stickersSearchField.searchEditText.requestFocus();
                        }
                    }
                }
            });
            ImageView imageView4 = new ImageView(context);
            this.searchButton = imageView4;
            imageView4.setImageResource(R.drawable.smiles_tab_search);
            this.searchButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i9), PorterDuff.Mode.MULTIPLY));
            this.searchButton.setScaleType(ImageView.ScaleType.CENTER);
            this.searchButton.setContentDescription(LocaleController.getString("Search", R.string.Search));
            this.searchButton.setFocusable(true);
            if (i6 >= 21) {
                this.searchButton.setBackground(Theme.createSelectorDrawable(iArgb));
            }
            this.searchButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.EmojiView.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view6) {
                    int currentItem = EmojiView.this.pager.getCurrentItem();
                    SearchField searchField3 = currentItem == 0 ? EmojiView.this.emojiSearchField : currentItem == 1 ? EmojiView.this.gifSearchField : EmojiView.this.stickersSearchField;
                    if (searchField3 == null) {
                        return;
                    }
                    searchField3.searchEditText.requestFocus();
                    MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0);
                    searchField3.searchEditText.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 1, 0.0f, 0.0f, 0);
                    searchField3.searchEditText.onTouchEvent(motionEventObtain2);
                    motionEventObtain2.recycle();
                }
            });
        } else {
            addView(this.bottomTabContainer, LayoutHelper.createFrame((i6 >= 21 ? 40 : 44) + 20, (i6 >= 21 ? 40 : 44) + 12, (LocaleController.isRTL ? 3 : 5) | 80, 0.0f, 0.0f, 2.0f, 0.0f));
            Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor(i7), Theme.getColor(i7));
            if (i6 < 21) {
                Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
                drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
                CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
                combinedDrawable.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
            } else {
                StateListAnimator stateListAnimator = new StateListAnimator();
                int[] iArr = {android.R.attr.state_pressed};
                ImageView imageView5 = this.floatingButton;
                Property property = View.TRANSLATION_Z;
                stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(imageView5, (Property<ImageView, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
                stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
                this.backspaceButton.setStateListAnimator(stateListAnimator);
                this.backspaceButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.EmojiView.23
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view6, Outline outline) {
                        outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                    }
                });
            }
            this.backspaceButton.setPadding(0, 0, AndroidUtilities.dp(2.0f), 0);
            this.backspaceButton.setBackground(drawableCreateSimpleSelectorCircleDrawable);
            this.backspaceButton.setContentDescription(LocaleController.getString("AccDescrBackspace", R.string.AccDescrBackspace));
            this.backspaceButton.setFocusable(true);
            this.bottomTabContainer.addView(this.backspaceButton, LayoutHelper.createFrame(i6 >= 21 ? 40 : 44, i6 >= 21 ? 40 : 44, 51, 10.0f, 0.0f, 10.0f, 0.0f));
            this.shadowLine.setVisibility(8);
            this.bottomTabContainerBackground.setVisibility(8);
        }
        addView(this.pager, 0, LayoutHelper.createFrame(-1, -1, 51));
        CorrectlyMeasuringTextView correctlyMeasuringTextView = new CorrectlyMeasuringTextView(context);
        this.mediaBanTooltip = correctlyMeasuringTextView;
        correctlyMeasuringTextView.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(3.0f), Theme.getColor(Theme.key_chat_gifSaveHintBackground)));
        this.mediaBanTooltip.setTextColor(Theme.getColor(Theme.key_chat_gifSaveHintText));
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
        EmojiPopupWindow emojiPopupWindow = new EmojiPopupWindow(this, emojiColorPickerView, iDp, iDp2);
        this.pickerViewPopup = emojiPopupWindow;
        emojiPopupWindow.setOutsideTouchable(true);
        this.pickerViewPopup.setClippingEnabled(true);
        this.pickerViewPopup.setInputMethodMode(2);
        this.pickerViewPopup.setSoftInputMode(0);
        this.pickerViewPopup.getContentView().setFocusableInTouchMode(true);
        this.pickerViewPopup.getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view6, int i10, KeyEvent keyEvent) {
                return this.f$0.lambda$new$7(view6, i10, keyEvent);
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
    public /* synthetic */ boolean lambda$new$1(View view, MotionEvent motionEvent) {
        return ContentPreviewViewer.getInstance().onTouch(motionEvent, this.gifGridView, 0, this.gifOnItemClickListener, this.contentPreviewViewerDelegate, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(boolean z, View view, int i) {
        if (this.delegate == null) {
            return;
        }
        if (z && this.needGifSearch) {
            i--;
        }
        RecyclerView.Adapter adapter = this.gifGridView.getAdapter();
        GifAdapter gifAdapter = this.gifAdapter;
        if (adapter != gifAdapter) {
            RecyclerView.Adapter adapter2 = this.gifGridView.getAdapter();
            GifAdapter gifAdapter2 = this.gifSearchAdapter;
            if (adapter2 != gifAdapter2 || i < 0 || i >= gifAdapter2.results.size()) {
                return;
            }
            this.delegate.lambda$onGifSelected$0(view, this.gifSearchAdapter.results.get(i), this.gifSearchAdapter.lastSearchImageString, this.gifSearchAdapter.bot, true, 0);
            updateRecentGifs();
            return;
        }
        if (i < 0) {
            return;
        }
        if (i < gifAdapter.recentItemsCount) {
            this.delegate.lambda$onGifSelected$0(view, this.recentGifs.get(i), null, "gif", true, 0);
            return;
        }
        if (this.gifAdapter.recentItemsCount > 0) {
            i = (i - this.gifAdapter.recentItemsCount) - 1;
        }
        if (i < 0 || i >= this.gifAdapter.results.size()) {
            return;
        }
        this.delegate.lambda$onGifSelected$0(view, this.gifAdapter.results.get(i), null, this.gifAdapter.bot, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(int i) {
        if (i == this.gifTrendingTabNum && this.gifAdapter.results.isEmpty()) {
            return;
        }
        this.gifGridView.stopScroll();
        this.gifTabs.onPageScrolled(i, 0);
        int i2 = 1;
        if (i == this.gifRecentTabNum || i == this.gifTrendingTabNum) {
            this.gifSearchField.searchEditText.setText(BuildConfig.FLAVOR);
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
    public /* synthetic */ boolean lambda$new$4(View view, MotionEvent motionEvent) {
        return ContentPreviewViewer.getInstance().onTouch(motionEvent, this.stickersGridView, getMeasuredHeight(), this.stickersOnItemClickListener, this.contentPreviewViewerDelegate, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(View view, int i) {
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
            this.delegate.onStickerSelected(stickerEmojiCell, stickerEmojiCell.getSticker(), str, stickerEmojiCell.getParentObject(), true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(Context context, int i) {
        if (i == this.trendingTabNum) {
            this.delegate.showTrendingStickersAlert(new TrendingStickersLayout(context, new TrendingStickersLayout.Delegate() { // from class: org.rbmain.ui.Components.EmojiView.15
                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public boolean canSendSticker() {
                    return true;
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public void onStickerSetAdd(TLRPC$StickerSetCovered tLRPC$StickerSetCovered, boolean z) {
                    EmojiView.this.delegate.onStickerSetAdd(tLRPC$StickerSetCovered);
                    if (z) {
                        EmojiView.this.updateStickerTabs();
                    }
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public void onStickerSetRemove(TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
                    EmojiView.this.delegate.onStickerSetRemove(tLRPC$StickerSetCovered);
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public boolean onListViewInterceptTouchEvent(RecyclerListView recyclerListView, MotionEvent motionEvent) {
                    return ContentPreviewViewer.getInstance().onInterceptTouchEvent(motionEvent, recyclerListView, EmojiView.this.getMeasuredHeight(), EmojiView.this.contentPreviewViewerDelegate, null);
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public boolean onListViewTouchEvent(RecyclerListView recyclerListView, RecyclerListView.OnItemClickListener onItemClickListener, MotionEvent motionEvent) {
                    return ContentPreviewViewer.getInstance().onTouch(motionEvent, recyclerListView, EmojiView.this.getMeasuredHeight(), onItemClickListener, EmojiView.this.contentPreviewViewerDelegate, null);
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public String[] getLastSearchKeyboardLanguage() {
                    return EmojiView.this.lastSearchKeyboardLanguage;
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public void setLastSearchKeyboardLanguage(String[] strArr) {
                    EmojiView.this.lastSearchKeyboardLanguage = strArr;
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public void onStickerSelected(TLRPC$Document tLRPC$Document, Object obj, boolean z, boolean z2, int i2) {
                    EmojiView.this.delegate.onStickerSelected(null, tLRPC$Document, null, obj, z2, i2);
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public boolean canSchedule() {
                    return EmojiView.this.delegate.canSchedule();
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public boolean isInScheduleMode() {
                    return EmojiView.this.delegate.isInScheduleMode();
                }
            }, this.primaryInstallingStickerSets, this.installingStickerSets, this.removingStickerSets));
            return;
        }
        if (i == this.recentTabBum) {
            this.stickersGridView.stopScroll();
            this.stickersLayoutManager.scrollToPositionWithOffset(this.stickersGridAdapter.getPositionForPack("recent"), 0);
            resetTabsY(0);
            ScrollSlidingTabStrip scrollSlidingTabStrip = this.stickersTab;
            int i2 = this.recentTabBum;
            scrollSlidingTabStrip.onPageScrolled(i2, i2 > 0 ? i2 : this.stickersTabOffset);
            return;
        }
        if (i == this.favTabBum) {
            this.stickersGridView.stopScroll();
            this.stickersLayoutManager.scrollToPositionWithOffset(this.stickersGridAdapter.getPositionForPack("fav"), 0);
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
        this.stickersLayoutManager.scrollToPositionWithOffset(this.stickersGridAdapter.getPositionForPack(this.stickerSets.get(size)), 0);
        resetTabsY(0);
        checkScroll(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$7(View view, int i, KeyEvent keyEvent) {
        EmojiPopupWindow emojiPopupWindow;
        if (i != 82 || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1 || (emojiPopupWindow = this.pickerViewPopup) == null || !emojiPopupWindow.isShowing()) {
            return false;
        }
        this.pickerViewPopup.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String addColorToCode(String str, String str2) {
        String strSubstring;
        int length = str.length();
        if (length > 2 && str.charAt(str.length() - 2) == 8205) {
            strSubstring = str.substring(str.length() - 2);
            str = str.substring(0, str.length() - 2);
        } else if (length <= 3 || str.charAt(str.length() - 3) != 8205) {
            strSubstring = null;
        } else {
            strSubstring = str.substring(str.length() - 3);
            str = str.substring(0, str.length() - 3);
        }
        String str3 = str + str2;
        if (strSubstring == null) {
            return str3;
        }
        return str3 + strSubstring;
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        updateBottomTabContainerPosition();
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
    public void startStopVisibleGifs(boolean z) {
        RecyclerListView recyclerListView = this.gifGridView;
        if (recyclerListView == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gifGridView.getChildAt(i);
            if (childAt instanceof ContextLinkCell) {
                ImageReceiver photoImage = ((ContextLinkCell) childAt).getPhotoImage();
                if (z) {
                    photoImage.setAllowStartAnimation(true);
                    photoImage.startAnimation();
                } else {
                    photoImage.setAllowStartAnimation(false);
                    photoImage.stopAnimation();
                }
            }
        }
    }

    public void addEmojiToRecent(String str) {
        if (Emoji.isValidEmoji(str)) {
            Emoji.recentEmoji.size();
            Emoji.addRecentEmoji(str);
            if (getVisibility() != 0 || this.pager.getCurrentItem() != 0) {
                Emoji.sortEmoji();
                this.emojiAdapter.notifyDataSetChanged();
            }
            Emoji.saveRecentEmoji();
        }
    }

    public void showSearchField(boolean z) {
        for (int i = 0; i < 3; i++) {
            GridLayoutManager layoutManagerForType = getLayoutManagerForType(i);
            int iFindFirstVisibleItemPosition = layoutManagerForType.findFirstVisibleItemPosition();
            if (z) {
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
                    if (scrollSlidingTabStrip != null) {
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(scrollSlidingTabStrip, (Property<ScrollSlidingTabStrip, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)), ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)), ObjectAnimator.ofFloat(searchField2, (Property<SearchField, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(0.0f)));
                    } else {
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)), ObjectAnimator.ofFloat(searchField2, (Property<SearchField, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(0.0f)));
                    }
                    this.searchAnimation.setDuration(200L);
                    this.searchAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                    this.searchAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.EmojiView.24
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (animator.equals(EmojiView.this.searchAnimation)) {
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
                        public void onAnimationCancel(Animator animator) {
                            if (animator.equals(EmojiView.this.searchAnimation)) {
                                EmojiView.this.searchAnimation = null;
                            }
                        }
                    });
                    this.searchAnimation.start();
                } else {
                    searchField2.setTranslationY(AndroidUtilities.dp(0.0f));
                    if (scrollSlidingTabStrip != null) {
                        scrollSlidingTabStrip.setTranslationY(-AndroidUtilities.dp(48.0f));
                    }
                    if (recyclerListView == this.stickersGridView) {
                        recyclerListView.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
                    } else if (recyclerListView == this.emojiGridView || recyclerListView == this.gifGridView) {
                        recyclerListView.setPadding(0, 0, 0, 0);
                    }
                    if (recyclerListView == this.gifGridView) {
                        if (this.gifSearchAdapter.showTrendingWhenSearchEmpty = this.gifAdapter.results.size() > 0) {
                            this.gifSearchAdapter.search(BuildConfig.FLAVOR);
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

    private void showEmojiShadow(boolean z, boolean z2) {
        if (z && this.emojiTabsShadow.getTag() == null) {
            return;
        }
        if (z || this.emojiTabsShadow.getTag() == null) {
            AnimatorSet animatorSet = this.emojiTabShadowAnimator;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.emojiTabShadowAnimator = null;
            }
            this.emojiTabsShadow.setTag(z ? null : 1);
            if (z2) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.emojiTabShadowAnimator = animatorSet2;
                Animator[] animatorArr = new Animator[1];
                View view = this.emojiTabsShadow;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                animatorSet2.playTogether(animatorArr);
                this.emojiTabShadowAnimator.setDuration(200L);
                this.emojiTabShadowAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                this.emojiTabShadowAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.EmojiView.25
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        EmojiView.this.emojiTabShadowAnimator = null;
                    }
                });
                this.emojiTabShadowAnimator.start();
                return;
            }
            this.emojiTabsShadow.setAlpha(z ? 1.0f : 0.0f);
        }
    }

    public void closeSearch(boolean z) {
        closeSearch(z, -1L);
    }

    public void closeSearch(boolean z, long j) {
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
        if (currentItem == 2 && j != -1 && (stickerSetById = MediaDataController.getInstance(this.currentAccount).getStickerSetById(j)) != null && (positionForPack = this.stickersGridAdapter.getPositionForPack(stickerSetById)) >= 0) {
            this.stickersLayoutManager.scrollToPositionWithOffset(positionForPack, AndroidUtilities.dp(60.0f));
        }
        GifAdapter gifAdapter = this.gifSearchAdapter;
        if (gifAdapter != null) {
            gifAdapter.showTrendingWhenSearchEmpty = false;
        }
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                searchField = this.emojiSearchField;
                recyclerListView = this.emojiGridView;
                gridLayoutManager = this.emojiLayoutManager;
                scrollSlidingTabStrip = this.emojiTabs;
            } else if (i == 1) {
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
                searchField.searchEditText.setText(BuildConfig.FLAVOR);
                if (i == currentItem && z) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.searchAnimation = animatorSet2;
                    if (scrollSlidingTabStrip != null) {
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(scrollSlidingTabStrip, (Property<ScrollSlidingTabStrip, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(48.0f) - this.searchFieldHeight), ObjectAnimator.ofFloat(searchField, (Property<SearchField, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(48.0f) - this.searchFieldHeight));
                    } else {
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, -this.searchFieldHeight), ObjectAnimator.ofFloat(searchField, (Property<SearchField, Float>) View.TRANSLATION_Y, -this.searchFieldHeight));
                    }
                    this.searchAnimation.setDuration(200L);
                    this.searchAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                    this.searchAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.EmojiView.26
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (animator.equals(EmojiView.this.searchAnimation)) {
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
                        public void onAnimationCancel(Animator animator) {
                            if (animator.equals(EmojiView.this.searchAnimation)) {
                                EmojiView.this.searchAnimation = null;
                            }
                        }
                    });
                    this.searchAnimation.start();
                } else {
                    searchField.setTranslationY(AndroidUtilities.dp(48.0f) - this.searchFieldHeight);
                    if (scrollSlidingTabStrip != null) {
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
        if (!z) {
            this.delegate.onSearchOpenClose(0);
        }
        showBottomTab(true, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStickersSearchFieldScroll(boolean z) {
        RecyclerListView recyclerListView;
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate != null && emojiViewDelegate.isSearchOpened()) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.stickersGridView.findViewHolderForAdapterPosition(0);
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                this.stickersSearchField.showShadow(true, !z);
                return;
            } else {
                this.stickersSearchField.showShadow(viewHolderFindViewHolderForAdapterPosition.itemView.getTop() < this.stickersGridView.getPaddingTop(), !z);
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
        this.stickersSearchField.showShadow(false, !z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBottomTabScroll(float f) {
        int iDp;
        this.lastBottomScrollDy += f;
        if (this.pager.getCurrentItem() == 0) {
            iDp = AndroidUtilities.dp(38.0f);
        } else {
            iDp = AndroidUtilities.dp(48.0f);
        }
        float f2 = this.lastBottomScrollDy;
        if (f2 >= iDp) {
            showBottomTab(false, true);
            return;
        }
        if (f2 <= (-iDp)) {
            showBottomTab(true, true);
        } else {
            if ((this.bottomTabContainer.getTag() != null || this.lastBottomScrollDy >= 0.0f) && (this.bottomTabContainer.getTag() == null || this.lastBottomScrollDy <= 0.0f)) {
                return;
            }
            this.lastBottomScrollDy = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBackspaceButton(final boolean z, boolean z2) {
        if (z && this.backspaceButton.getTag() == null) {
            return;
        }
        if (z || this.backspaceButton.getTag() == null) {
            AnimatorSet animatorSet = this.backspaceButtonAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.backspaceButtonAnimation = null;
            }
            this.backspaceButton.setTag(z ? null : 1);
            if (z2) {
                if (z) {
                    this.backspaceButton.setVisibility(0);
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.backspaceButtonAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[3];
                ImageView imageView = this.backspaceButton;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, fArr);
                ImageView imageView2 = this.backspaceButton;
                Property property2 = View.SCALE_X;
                float[] fArr2 = new float[1];
                fArr2[0] = z ? 1.0f : 0.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property2, fArr2);
                ImageView imageView3 = this.backspaceButton;
                Property property3 = View.SCALE_Y;
                float[] fArr3 = new float[1];
                fArr3[0] = z ? 1.0f : 0.0f;
                animatorArr[2] = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property3, fArr3);
                animatorSet2.playTogether(animatorArr);
                this.backspaceButtonAnimation.setDuration(200L);
                this.backspaceButtonAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                this.backspaceButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.EmojiView.27
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (z) {
                            return;
                        }
                        EmojiView.this.backspaceButton.setVisibility(4);
                    }
                });
                this.backspaceButtonAnimation.start();
                return;
            }
            this.backspaceButton.setAlpha(z ? 1.0f : 0.0f);
            this.backspaceButton.setScaleX(z ? 1.0f : 0.0f);
            this.backspaceButton.setScaleY(z ? 1.0f : 0.0f);
            this.backspaceButton.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showStickerSettingsButton(final boolean z, boolean z2) {
        ImageView imageView = this.stickerSettingsButton;
        if (imageView == null) {
            return;
        }
        if (z && imageView.getTag() == null) {
            return;
        }
        if (z || this.stickerSettingsButton.getTag() == null) {
            AnimatorSet animatorSet = this.stickersButtonAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.stickersButtonAnimation = null;
            }
            this.stickerSettingsButton.setTag(z ? null : 1);
            if (z2) {
                if (z) {
                    this.stickerSettingsButton.setVisibility(0);
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.stickersButtonAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[3];
                ImageView imageView2 = this.stickerSettingsButton;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property, fArr);
                ImageView imageView3 = this.stickerSettingsButton;
                Property property2 = View.SCALE_X;
                float[] fArr2 = new float[1];
                fArr2[0] = z ? 1.0f : 0.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property2, fArr2);
                ImageView imageView4 = this.stickerSettingsButton;
                Property property3 = View.SCALE_Y;
                float[] fArr3 = new float[1];
                fArr3[0] = z ? 1.0f : 0.0f;
                animatorArr[2] = ObjectAnimator.ofFloat(imageView4, (Property<ImageView, Float>) property3, fArr3);
                animatorSet2.playTogether(animatorArr);
                this.stickersButtonAnimation.setDuration(200L);
                this.stickersButtonAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                this.stickersButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.EmojiView.28
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (z) {
                            return;
                        }
                        EmojiView.this.stickerSettingsButton.setVisibility(4);
                    }
                });
                this.stickersButtonAnimation.start();
                return;
            }
            this.stickerSettingsButton.setAlpha(z ? 1.0f : 0.0f);
            this.stickerSettingsButton.setScaleX(z ? 1.0f : 0.0f);
            this.stickerSettingsButton.setScaleY(z ? 1.0f : 0.0f);
            this.stickerSettingsButton.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomTab(boolean z, boolean z2) {
        float fDp;
        float fDp2;
        this.lastBottomScrollDy = 0.0f;
        if (z && this.bottomTabContainer.getTag() == null) {
            return;
        }
        if (z || this.bottomTabContainer.getTag() == null) {
            EmojiViewDelegate emojiViewDelegate = this.delegate;
            if (emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) {
                AnimatorSet animatorSet = this.bottomTabContainerAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.bottomTabContainerAnimation = null;
                }
                this.bottomTabContainer.setTag(z ? null : 1);
                if (z2) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.bottomTabContainerAnimation = animatorSet2;
                    Animator[] animatorArr = new Animator[2];
                    FrameLayout frameLayout = this.bottomTabContainer;
                    Property property = View.TRANSLATION_Y;
                    float[] fArr = new float[1];
                    if (z) {
                        fDp2 = 0.0f;
                    } else {
                        fDp2 = AndroidUtilities.dp(this.needEmojiSearch ? 49.0f : 54.0f);
                    }
                    fArr[0] = fDp2;
                    animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
                    View view = this.shadowLine;
                    Property property2 = View.TRANSLATION_Y;
                    float[] fArr2 = new float[1];
                    fArr2[0] = z ? 0.0f : AndroidUtilities.dp(49.0f);
                    animatorArr[1] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
                    animatorSet2.playTogether(animatorArr);
                    this.bottomTabContainerAnimation.setDuration(200L);
                    this.bottomTabContainerAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                    this.bottomTabContainerAnimation.start();
                    return;
                }
                FrameLayout frameLayout2 = this.bottomTabContainer;
                if (z) {
                    fDp = 0.0f;
                } else {
                    fDp = AndroidUtilities.dp(this.needEmojiSearch ? 49.0f : 54.0f);
                }
                frameLayout2.setTranslationY(fDp);
                this.shadowLine.setTranslationY(z ? 0.0f : AndroidUtilities.dp(49.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTabsY(int i, int i2) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (i == 1) {
            checkEmojiTabY(this.emojiGridView, i2);
            return;
        }
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) {
            RecyclerListView listViewForType = getListViewForType(i);
            if (i2 <= 0 || listViewForType == null || listViewForType.getVisibility() != 0 || (viewHolderFindViewHolderForAdapterPosition = listViewForType.findViewHolderForAdapterPosition(0)) == null || viewHolderFindViewHolderForAdapterPosition.itemView.getTop() + this.searchFieldHeight < listViewForType.getPaddingTop()) {
                int[] iArr = this.tabsMinusDy;
                iArr[i] = iArr[i] - i2;
                if (iArr[i] > 0) {
                    iArr[i] = 0;
                } else if (iArr[i] < (-AndroidUtilities.dp(288.0f))) {
                    this.tabsMinusDy[i] = -AndroidUtilities.dp(288.0f);
                }
                getTabsForType(i).setTranslationY(Math.max(-AndroidUtilities.dp(48.0f), this.tabsMinusDy[i]));
            }
        }
    }

    private void resetTabsY(int i) {
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) {
            ScrollSlidingTabStrip tabsForType = getTabsForType(i);
            this.tabsMinusDy[i] = 0;
            tabsForType.setTranslationY(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateTabsY(final int i) {
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) {
            float fDpf2 = AndroidUtilities.dpf2(i == 1 ? 38.0f : 48.0f);
            float f = this.tabsMinusDy[i] / (-fDpf2);
            if (f <= 0.0f || f >= 1.0f) {
                animateSearchField(i);
                return;
            }
            ScrollSlidingTabStrip tabsForType = getTabsForType(i);
            int i2 = f > 0.5f ? (int) (-Math.ceil(fDpf2)) : 0;
            if (f > 0.5f) {
                animateSearchField(i, false, i2);
            }
            if (i == 1) {
                checkEmojiShadow(i2);
            }
            ObjectAnimator[] objectAnimatorArr = this.tabsYAnimators;
            if (objectAnimatorArr[i] == null) {
                objectAnimatorArr[i] = ObjectAnimator.ofFloat(tabsForType, (Property<ScrollSlidingTabStrip, Float>) View.TRANSLATION_Y, tabsForType.getTranslationY(), i2);
                this.tabsYAnimators[i].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$animateTabsY$8(i, valueAnimator);
                    }
                });
                this.tabsYAnimators[i].setDuration(200L);
            } else {
                objectAnimatorArr[i].setFloatValues(tabsForType.getTranslationY(), i2);
            }
            this.tabsYAnimators[i].start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateTabsY$8(int i, ValueAnimator valueAnimator) {
        this.tabsMinusDy[i] = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAnimatingTabsY(int i) {
        ObjectAnimator[] objectAnimatorArr = this.tabsYAnimators;
        if (objectAnimatorArr[i] == null || !objectAnimatorArr[i].isRunning()) {
            return;
        }
        this.tabsYAnimators[i].cancel();
    }

    private void animateSearchField(int i) {
        RecyclerListView listViewForType = getListViewForType(i);
        int iDp = AndroidUtilities.dp(i == 1 ? 38.0f : 48.0f);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = listViewForType.findViewHolderForAdapterPosition(0);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            int bottom = viewHolderFindViewHolderForAdapterPosition.itemView.getBottom();
            int[] iArr = this.tabsMinusDy;
            float f = (bottom - (iDp + iArr[i])) / this.searchFieldHeight;
            if (f > 0.0f || f < 1.0f) {
                animateSearchField(i, f > 0.5f, iArr[i]);
            }
        }
    }

    private void animateSearchField(int i, boolean z, final int i2) {
        if (getListViewForType(i).findViewHolderForAdapterPosition(0) == null) {
            return;
        }
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, getContext()) { // from class: org.rbmain.ui.Components.EmojiView.29
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int getVerticalSnapPreference() {
                return -1;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int calculateTimeForDeceleration(int i3) {
                return super.calculateTimeForDeceleration(i3) * 16;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDtToFit(int i3, int i4, int i5, int i6, int i7) {
                return super.calculateDtToFit(i3, i4, i5, i6, i7) + i2;
            }
        };
        linearSmoothScroller.setTargetPosition(!z ? 1 : 0);
        getLayoutManagerForType(i).startSmoothScroll(linearSmoothScroller);
    }

    private ScrollSlidingTabStrip getTabsForType(int i) {
        if (i == 0) {
            return this.stickersTab;
        }
        if (i == 1) {
            return this.emojiTabs;
        }
        if (i == 2) {
            return this.gifTabs;
        }
        throw new IllegalArgumentException("Unexpected argument: " + i);
    }

    private RecyclerListView getListViewForType(int i) {
        if (i == 0) {
            return this.stickersGridView;
        }
        if (i == 1) {
            return this.emojiGridView;
        }
        if (i == 2) {
            return this.gifGridView;
        }
        throw new IllegalArgumentException("Unexpected argument: " + i);
    }

    private GridLayoutManager getLayoutManagerForType(int i) {
        if (i == 0) {
            return this.stickersLayoutManager;
        }
        if (i == 1) {
            return this.emojiLayoutManager;
        }
        if (i == 2) {
            return this.gifLayoutManager;
        }
        throw new IllegalArgumentException("Unexpected argument: " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SearchField getSearchFieldForType(int i) {
        if (i == 0) {
            return this.stickersSearchField;
        }
        if (i == 1) {
            return this.emojiSearchField;
        }
        if (i == 2) {
            return this.gifSearchField;
        }
        throw new IllegalArgumentException("Unexpected argument: " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkEmojiSearchFieldScroll(boolean z) {
        RecyclerListView recyclerListView;
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate != null && emojiViewDelegate.isSearchOpened()) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.emojiGridView.findViewHolderForAdapterPosition(0);
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                this.emojiSearchField.showShadow(true, !z);
            } else {
                this.emojiSearchField.showShadow(viewHolderFindViewHolderForAdapterPosition.itemView.getTop() < this.emojiGridView.getPaddingTop(), !z);
            }
            showEmojiShadow(false, !z);
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
        this.emojiSearchField.showShadow(false, !z);
        checkEmojiShadow(Math.round(this.emojiTabs.getTranslationY()));
    }

    private void checkEmojiShadow(int i) {
        ObjectAnimator[] objectAnimatorArr = this.tabsYAnimators;
        if (objectAnimatorArr[1] == null || !objectAnimatorArr[1].isRunning()) {
            boolean z = false;
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.emojiGridView.findViewHolderForAdapterPosition(0);
            int iDp = AndroidUtilities.dp(38.0f) + i;
            if (iDp > 0 && (viewHolderFindViewHolderForAdapterPosition == null || viewHolderFindViewHolderForAdapterPosition.itemView.getBottom() < iDp)) {
                z = true;
            }
            showEmojiShadow(z, !this.isLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkEmojiTabY(View view, int i) {
        RecyclerListView recyclerListView;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (view == null) {
            ScrollSlidingTabStrip scrollSlidingTabStrip = this.emojiTabs;
            this.tabsMinusDy[1] = 0;
            scrollSlidingTabStrip.setTranslationY(0);
            return;
        }
        if (view.getVisibility() != 0) {
            return;
        }
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate == null || !emojiViewDelegate.isSearchOpened()) {
            if (i > 0 && (recyclerListView = this.emojiGridView) != null && recyclerListView.getVisibility() == 0 && (viewHolderFindViewHolderForAdapterPosition = this.emojiGridView.findViewHolderForAdapterPosition(0)) != null) {
                if (viewHolderFindViewHolderForAdapterPosition.itemView.getTop() + (this.needEmojiSearch ? this.searchFieldHeight : 0) >= this.emojiGridView.getPaddingTop()) {
                    return;
                }
            }
            int[] iArr = this.tabsMinusDy;
            iArr[1] = iArr[1] - i;
            if (iArr[1] > 0) {
                iArr[1] = 0;
            } else if (iArr[1] < (-AndroidUtilities.dp(288.0f))) {
                this.tabsMinusDy[1] = -AndroidUtilities.dp(288.0f);
            }
            this.emojiTabs.setTranslationY(Math.max(-AndroidUtilities.dp(38.0f), this.tabsMinusDy[1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGifSearchFieldScroll(boolean z) {
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
                this.gifSearchField.showShadow(true, !z);
                return;
            } else {
                this.gifSearchField.showShadow(viewHolderFindViewHolderForAdapterPosition.itemView.getTop() < this.gifGridView.getPaddingTop(), !z);
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
        this.gifSearchField.showShadow(false, !z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollGifsToTop() {
        GifLayoutManager gifLayoutManager = this.gifLayoutManager;
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        gifLayoutManager.scrollToPositionWithOffset((emojiViewDelegate == null || !emojiViewDelegate.isExpanded()) ? 1 : 0, 0);
        resetTabsY(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScroll(int i) {
        int iFindFirstVisibleItemPosition;
        if (i == 0) {
            int iFindFirstVisibleItemPosition2 = this.stickersLayoutManager.findFirstVisibleItemPosition();
            if (iFindFirstVisibleItemPosition2 == -1 || this.stickersGridView == null) {
                return;
            }
            int i2 = this.favTabBum;
            if (i2 <= 0 && (i2 = this.recentTabBum) <= 0) {
                i2 = this.stickersTabOffset;
            }
            this.stickersTab.onPageScrolled(this.stickersGridAdapter.getTabForPosition(iFindFirstVisibleItemPosition2), i2);
            return;
        }
        if (i == 2) {
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
            MessagesController.getGlobalEmojiSettings().edit().putInt("selected_page", i).apply();
        }
    }

    public void clearRecentEmoji() {
        Emoji.clearRecentEmoji();
        this.emojiAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageScrolled(int i, int i2, int i3) {
        EmojiViewDelegate emojiViewDelegate = this.delegate;
        if (emojiViewDelegate == null) {
            return;
        }
        if (i == 1) {
            emojiViewDelegate.onTabOpened(i3 != 0 ? 2 : 0);
        } else if (i == 2) {
            emojiViewDelegate.onTabOpened(3);
        } else {
            emojiViewDelegate.onTabOpened(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postBackspaceRunnable(final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$postBackspaceRunnable$9(i);
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postBackspaceRunnable$9(int i) {
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
        if (scrollSlidingTabStrip == null) {
            return;
        }
        this.recentTabBum = -2;
        this.favTabBum = -2;
        this.trendingTabNum = -2;
        this.stickersTabOffset = 0;
        int currentPosition = scrollSlidingTabStrip.getCurrentPosition();
        this.stickersTab.beginUpdate((getParent() == null || getVisibility() != 0 || (this.installingStickerSets.size() == 0 && this.removingStickerSets.size() == 0)) ? false : true);
        MediaDataController mediaDataController = MediaDataController.getInstance(this.currentAccount);
        if (!mediaDataController.getFeaturedStickerSets().isEmpty()) {
            int i = mediaDataController.getUnreadStickerSets().isEmpty() ? 2 : 3;
            this.stickersTab.addIconTab(i, this.stickerIcons[i]).setContentDescription(LocaleController.getString("FeaturedStickers", R.string.FeaturedStickers));
            int i2 = this.stickersTabOffset;
            this.trendingTabNum = i2;
            this.stickersTabOffset = i2 + 1;
        }
        if (!this.favouriteStickers.isEmpty()) {
            int i3 = this.stickersTabOffset;
            this.favTabBum = i3;
            this.stickersTabOffset = i3 + 1;
            this.stickersTab.addIconTab(1, this.stickerIcons[1]).setContentDescription(LocaleController.getString("FavoriteStickers", R.string.FavoriteStickers));
        }
        if (!this.recentStickers.isEmpty()) {
            int i4 = this.stickersTabOffset;
            this.recentTabBum = i4;
            this.stickersTabOffset = i4 + 1;
            this.stickersTab.addIconTab(0, this.stickerIcons[0]).setContentDescription(LocaleController.getString("RecentStickers", R.string.RecentStickers));
        }
        this.stickerSets.clear();
        this.groupStickerSet = null;
        this.groupStickerPackPosition = -1;
        this.groupStickerPackNum = -10;
        ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = mediaDataController.getStickerSets(0);
        int i5 = 0;
        while (true) {
            TLRPC$StickerSetCovered[] tLRPC$StickerSetCoveredArr = this.primaryInstallingStickerSets;
            if (i5 >= tLRPC$StickerSetCoveredArr.length) {
                break;
            }
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered = tLRPC$StickerSetCoveredArr[i5];
            if (tLRPC$StickerSetCovered != null) {
                TLRPC$TL_messages_stickerSet stickerSetById = mediaDataController.getStickerSetById(tLRPC$StickerSetCovered.set.id);
                if (stickerSetById != null && !stickerSetById.set.archived) {
                    this.primaryInstallingStickerSets[i5] = null;
                } else {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = new TLRPC$TL_messages_stickerSet();
                    tLRPC$TL_messages_stickerSet.set = tLRPC$StickerSetCovered.set;
                    TLRPC$Document tLRPC$Document = tLRPC$StickerSetCovered.cover;
                    if (tLRPC$Document != null) {
                        tLRPC$TL_messages_stickerSet.documents.add(tLRPC$Document);
                    } else if (!tLRPC$StickerSetCovered.covers.isEmpty()) {
                        tLRPC$TL_messages_stickerSet.documents.addAll(tLRPC$StickerSetCovered.covers);
                    }
                    if (!tLRPC$TL_messages_stickerSet.documents.isEmpty()) {
                        this.stickerSets.add(tLRPC$TL_messages_stickerSet);
                    }
                }
            }
            i5++;
        }
        for (int i6 = 0; i6 < stickerSets.size(); i6++) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2 = stickerSets.get(i6);
            if (!tLRPC$TL_messages_stickerSet2.set.archived && (arrayList2 = tLRPC$TL_messages_stickerSet2.documents) != null && !arrayList2.isEmpty()) {
                this.stickerSets.add(tLRPC$TL_messages_stickerSet2);
            }
        }
        if (this.info != null) {
            long j = MessagesController.getEmojiSettings(this.currentAccount).getLong("group_hide_stickers_" + this.info.id, -1L);
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.info.id));
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
        int i7 = 0;
        while (i7 < this.stickerSets.size()) {
            if (i7 == this.groupStickerPackNum) {
                TLRPC$Chat chat2 = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.info.id));
                if (chat2 == null) {
                    this.stickerSets.remove(0);
                    i7--;
                } else {
                    this.stickersTab.addStickerTab(chat2);
                }
            } else {
                TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet5 = this.stickerSets.get(i7);
                TLRPC$Document tLRPC$Document2 = tLRPC$TL_messages_stickerSet5.documents.get(0);
                TLObject closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_messages_stickerSet5.set.thumbs, 90);
                SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(tLRPC$TL_messages_stickerSet5.set.thumbs, Theme.key_emptyListPlaceholder, 0.2f);
                if (closestPhotoSizeWithSize == null) {
                    closestPhotoSizeWithSize = tLRPC$Document2;
                }
                this.stickersTab.addStickerTab(closestPhotoSizeWithSize, svgThumb, tLRPC$Document2, tLRPC$TL_messages_stickerSet5).setContentDescription(tLRPC$TL_messages_stickerSet5.set.title + ", " + LocaleController.getString("AccDescrStickerSet", R.string.AccDescrStickerSet));
            }
            i7++;
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
        this.gifTabs.addIconTab(1, this.gifIcons[1]).setContentDescription(LocaleController.getString("FeaturedGifs", R.string.FeaturedGifs));
        this.gifFirstEmojiTabNum = i + 1;
        int iDp = AndroidUtilities.dp(13.0f);
        int iDp2 = AndroidUtilities.dp(11.0f);
        ArrayList<String> arrayList = MessagesController.getInstance(this.currentAccount).gifSearchEmojies;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = arrayList.get(i3);
            Emoji.EmojiDrawable emojiDrawable = Emoji.getEmojiDrawable(str);
            if (emojiDrawable != null) {
                ImageView imageViewAddIconTab = this.gifTabs.addIconTab(i3 + 3, emojiDrawable);
                imageViewAddIconTab.setPadding(iDp, iDp2, iDp, iDp2);
                imageViewAddIconTab.setContentDescription(str);
            }
        }
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

    public void addRecentSticker(TLRPC$Document tLRPC$Document) {
        if (tLRPC$Document == null) {
            return;
        }
        MediaDataController.getInstance(this.currentAccount).addRecentSticker(0, null, tLRPC$Document, (int) (System.currentTimeMillis() / 1000), false);
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

    public void addRecentGif(TLRPC$Document tLRPC$Document) {
        if (tLRPC$Document == null) {
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
                background.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_emojiPanelBackground), PorterDuff.Mode.MULTIPLY));
            }
        } else {
            int i = Theme.key_chat_emojiPanelBackground;
            setBackgroundColor(Theme.getColor(i));
            if (this.needEmojiSearch) {
                this.bottomTabContainerBackground.setBackgroundColor(Theme.getColor(i));
            }
        }
        ScrollSlidingTabStrip scrollSlidingTabStrip = this.emojiTabs;
        if (scrollSlidingTabStrip != null) {
            scrollSlidingTabStrip.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
            this.emojiTabsShadow.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelShadowLine));
        }
        EmojiColorPickerView emojiColorPickerView = this.pickerView;
        if (emojiColorPickerView != null) {
            Drawable drawable = emojiColorPickerView.backgroundDrawable;
            int i2 = Theme.key_dialogBackground;
            Theme.setDrawableColor(drawable, Theme.getColor(i2));
            Theme.setDrawableColor(this.pickerView.arrowDrawable, Theme.getColor(i2));
        }
        for (int i3 = 0; i3 < 3; i3++) {
            if (i3 == 0) {
                searchField = this.stickersSearchField;
            } else if (i3 == 1) {
                searchField = this.emojiSearchField;
            } else {
                searchField = this.gifSearchField;
            }
            if (searchField != null) {
                searchField.backgroundView.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
                searchField.shadowView.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelShadowLine));
                ImageView imageView = searchField.clearSearchImageView;
                int i4 = Theme.key_chat_emojiSearchIcon;
                imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i4), PorterDuff.Mode.MULTIPLY));
                searchField.searchIconImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i4), PorterDuff.Mode.MULTIPLY));
                Theme.setDrawableColorByKey(searchField.searchBackground.getBackground(), Theme.key_chat_emojiSearchBackground);
                searchField.searchBackground.invalidate();
                searchField.searchEditText.setHintTextColor(Theme.getColor(i4));
                searchField.searchEditText.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            }
        }
        Paint paint = this.dotPaint;
        if (paint != null) {
            paint.setColor(Theme.getColor(Theme.key_chat_emojiPanelNewTrending));
        }
        RecyclerListView recyclerListView = this.emojiGridView;
        if (recyclerListView != null) {
            recyclerListView.setGlowColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
        }
        RecyclerListView recyclerListView2 = this.stickersGridView;
        if (recyclerListView2 != null) {
            recyclerListView2.setGlowColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
        }
        ScrollSlidingTabStrip scrollSlidingTabStrip2 = this.stickersTab;
        if (scrollSlidingTabStrip2 != null) {
            scrollSlidingTabStrip2.setIndicatorColor(Theme.getColor(Theme.key_chat_emojiPanelStickerPackSelectorLine));
            this.stickersTab.setUnderlineColor(Theme.getColor(Theme.key_chat_emojiPanelShadowLine));
            this.stickersTab.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
        }
        ScrollSlidingTabStrip scrollSlidingTabStrip3 = this.gifTabs;
        if (scrollSlidingTabStrip3 != null) {
            scrollSlidingTabStrip3.setIndicatorColor(Theme.getColor(Theme.key_chat_emojiPanelStickerPackSelectorLine));
            this.gifTabs.setUnderlineColor(Theme.getColor(Theme.key_chat_emojiPanelShadowLine));
            this.gifTabs.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
        }
        ImageView imageView2 = this.backspaceButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_emojiPanelBackspace), PorterDuff.Mode.MULTIPLY));
            if (this.emojiSearchField == null) {
                Drawable background2 = this.backspaceButton.getBackground();
                int i5 = Theme.key_chat_emojiPanelBackground;
                Theme.setSelectorDrawableColor(background2, Theme.getColor(i5), false);
                Theme.setSelectorDrawableColor(this.backspaceButton.getBackground(), Theme.getColor(i5), true);
            }
        }
        ImageView imageView3 = this.stickerSettingsButton;
        if (imageView3 != null) {
            imageView3.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_emojiPanelBackspace), PorterDuff.Mode.MULTIPLY));
        }
        ImageView imageView4 = this.searchButton;
        if (imageView4 != null) {
            imageView4.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_emojiPanelBackspace), PorterDuff.Mode.MULTIPLY));
        }
        View view = this.shadowLine;
        if (view != null) {
            view.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelShadowLine));
        }
        TextView textView = this.mediaBanTooltip;
        if (textView != null) {
            ((ShapeDrawable) textView.getBackground()).getPaint().setColor(Theme.getColor(Theme.key_chat_gifSaveHintBackground));
            this.mediaBanTooltip.setTextColor(Theme.getColor(Theme.key_chat_gifSaveHintText));
        }
        GifAdapter gifAdapter = this.gifSearchAdapter;
        if (gifAdapter != null) {
            ImageView imageView5 = gifAdapter.progressEmptyView.imageView;
            int i6 = Theme.key_chat_emojiPanelEmptyText;
            imageView5.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i6), PorterDuff.Mode.MULTIPLY));
            this.gifSearchAdapter.progressEmptyView.textView.setTextColor(Theme.getColor(i6));
            this.gifSearchAdapter.progressEmptyView.progressView.setProgressColor(Theme.getColor(Theme.key_progressCircle));
        }
        int i7 = 0;
        while (true) {
            Drawable[] drawableArr = this.tabIcons;
            if (i7 >= drawableArr.length) {
                break;
            }
            Theme.setEmojiDrawableColor(drawableArr[i7], Theme.getColor(Theme.key_chat_emojiBottomPanelIcon), false);
            Theme.setEmojiDrawableColor(this.tabIcons[i7], Theme.getColor(Theme.key_chat_emojiPanelIconSelected), true);
            i7++;
        }
        int i8 = 0;
        while (true) {
            Drawable[] drawableArr2 = this.emojiIcons;
            if (i8 >= drawableArr2.length) {
                break;
            }
            Theme.setEmojiDrawableColor(drawableArr2[i8], Theme.getColor(Theme.key_chat_emojiPanelIcon), false);
            Theme.setEmojiDrawableColor(this.emojiIcons[i8], Theme.getColor(Theme.key_chat_emojiPanelIconSelected), true);
            i8++;
        }
        int i9 = 0;
        while (true) {
            Drawable[] drawableArr3 = this.stickerIcons;
            if (i9 >= drawableArr3.length) {
                break;
            }
            Theme.setEmojiDrawableColor(drawableArr3[i9], Theme.getColor(Theme.key_chat_emojiPanelIcon), false);
            Theme.setEmojiDrawableColor(this.stickerIcons[i9], Theme.getColor(Theme.key_chat_emojiPanelIconSelected), true);
            i9++;
        }
        int i10 = 0;
        while (true) {
            Drawable[] drawableArr4 = this.gifIcons;
            if (i10 >= drawableArr4.length) {
                return;
            }
            Theme.setEmojiDrawableColor(drawableArr4[i10], Theme.getColor(Theme.key_chat_emojiPanelIcon), false);
            Theme.setEmojiDrawableColor(this.gifIcons[i10], Theme.getColor(Theme.key_chat_emojiPanelIconSelected), true);
            i10++;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.isLayout = true;
        if (AndroidUtilities.isInMultiwindow || this.forseMultiwindowLayout) {
            if (this.currentBackgroundType != 1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    setOutlineProvider((ViewOutlineProvider) this.outlineProvider);
                    setClipToOutline(true);
                    setElevation(AndroidUtilities.dp(2.0f));
                }
                setBackgroundResource(R.drawable.smiles_popup);
                Drawable background = getBackground();
                int i3 = Theme.key_chat_emojiPanelBackground;
                background.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i3), PorterDuff.Mode.MULTIPLY));
                if (this.needEmojiSearch) {
                    this.bottomTabContainerBackground.setBackgroundColor(Theme.getColor(i3));
                }
                this.currentBackgroundType = 1;
            }
        } else if (this.currentBackgroundType != 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOutlineProvider(null);
                setClipToOutline(false);
                setElevation(0.0f);
            }
            int i4 = Theme.key_chat_emojiPanelBackground;
            setBackgroundColor(Theme.getColor(i4));
            if (this.needEmojiSearch) {
                this.bottomTabContainerBackground.setBackgroundColor(Theme.getColor(i4));
            }
            this.currentBackgroundType = 0;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
        this.isLayout = false;
        setTranslationY(getTranslationY());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        if (this.lastNotifyWidth != i5) {
            this.lastNotifyWidth = i5;
            reloadStickersAdapter();
        }
        View view = (View) getParent();
        if (view != null) {
            int i6 = i4 - i2;
            int height = view.getHeight();
            if (this.lastNotifyHeight != i6 || this.lastNotifyHeight2 != height) {
                EmojiViewDelegate emojiViewDelegate = this.delegate;
                if (emojiViewDelegate != null && emojiViewDelegate.isSearchOpened()) {
                    this.bottomTabContainer.setTranslationY(AndroidUtilities.dp(49.0f));
                } else if (this.bottomTabContainer.getTag() == null) {
                    if (i6 <= this.lastNotifyHeight) {
                        this.bottomTabContainer.setTranslationY(0.0f);
                    } else {
                        float y = (getY() + getMeasuredHeight()) - view.getHeight();
                        if (this.bottomTabContainer.getTop() - y < 0.0f) {
                            y = this.bottomTabContainer.getTop();
                        }
                        this.bottomTabContainer.setTranslationY(-y);
                    }
                }
                this.lastNotifyHeight = i6;
                this.lastNotifyHeight2 = height;
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    private void reloadStickersAdapter() {
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

    public void setDragListener(DragListener dragListener) {
        this.dragListener = dragListener;
    }

    public void setChatInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        this.info = tLRPC$ChatFull;
        updateStickerTabs();
    }

    public void invalidateViews() {
        this.emojiGridView.invalidateViews();
    }

    public void setForseMultiwindowLayout(boolean z) {
        this.forseMultiwindowLayout = z;
    }

    public void onOpen(boolean z) throws Resources.NotFoundException {
        if (this.currentPage != 0 && this.currentChatId != 0) {
            this.currentPage = 0;
        }
        if (this.currentPage == 0 || z || this.views.size() == 1) {
            showBackspaceButton(true, false);
            showStickerSettingsButton(false, false);
            if (this.pager.getCurrentItem() != 0) {
                this.pager.setCurrentItem(0, !z);
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
        showStickerSettingsButton(true, false);
        if (this.pager.getCurrentItem() != 2) {
            this.pager.setCurrentItem(2, false);
        }
        ScrollSlidingTabStrip scrollSlidingTabStrip2 = this.stickersTab;
        if (scrollSlidingTabStrip2 != null) {
            int i2 = this.favTabBum;
            if (i2 >= 0) {
                scrollSlidingTabStrip2.selectTab(i2);
                return;
            }
            int i3 = this.recentTabBum;
            if (i3 >= 0) {
                scrollSlidingTabStrip2.selectTab(i3);
            } else {
                scrollSlidingTabStrip2.selectTab(this.stickersTabOffset);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.newEmojiSuggestionsAvailable);
        if (this.stickersGridAdapter != null) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersDidLoad);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.recentDocumentsDidLoad);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.featuredStickersDidLoad);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.groupStickersDidLoad);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAttachedToWindow$10();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$10() {
        updateStickerTabs();
        reloadStickersAdapter();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 8) {
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
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void onDestroy() {
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
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

    private void checkDocuments(boolean z) {
        if (z) {
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
        int iCalcDocumentsHash = MediaDataController.calcDocumentsHash(this.recentGifs, ConnectionsManager.DEFAULT_DATACENTER_ID);
        ArrayList<TLRPC$Document> recentGifs = MediaDataController.getInstance(this.currentAccount).getRecentGifs();
        this.recentGifs = recentGifs;
        int iCalcDocumentsHash2 = MediaDataController.calcDocumentsHash(recentGifs, ConnectionsManager.DEFAULT_DATACENTER_ID);
        if ((this.gifTabs != null && size == 0 && !this.recentGifs.isEmpty()) || (size != 0 && this.recentGifs.isEmpty())) {
            updateGifTabs();
        }
        if ((size == this.recentGifs.size() && iCalcDocumentsHash == iCalcDocumentsHash2) || (gifAdapter = this.gifAdapter) == null) {
            return;
        }
        gifAdapter.notifyDataSetChanged();
    }

    public void setStickersBanned(boolean z, int i) throws Resources.NotFoundException {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.typeTabs;
        if (pagerSlidingTabStrip == null) {
            return;
        }
        if (z) {
            this.currentChatId = i;
        } else {
            this.currentChatId = 0;
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

    public void showStickerBanHint(boolean z) {
        TLRPC$Chat chat;
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        if (this.mediaBanTooltip.getVisibility() == 0 || (chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.currentChatId))) == null) {
            return;
        }
        if (ChatObject.hasAdminRights(chat) || (tLRPC$TL_chatBannedRights = chat.default_banned_rights) == null || !tLRPC$TL_chatBannedRights.send_stickers) {
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = chat.banned_rights;
            if (tLRPC$TL_chatBannedRights2 == null) {
                return;
            }
            if (AndroidUtilities.isBannedForever(tLRPC$TL_chatBannedRights2)) {
                if (z) {
                    this.mediaBanTooltip.setText(LocaleController.getString("AttachGifRestrictedForever", R.string.AttachGifRestrictedForever));
                } else {
                    this.mediaBanTooltip.setText(LocaleController.getString("AttachStickersRestrictedForever", R.string.AttachStickersRestrictedForever));
                }
            } else if (z) {
                this.mediaBanTooltip.setText(LocaleController.formatString("AttachGifRestricted", R.string.AttachGifRestricted, LocaleController.formatDateForBan(chat.banned_rights.until_date)));
            } else {
                this.mediaBanTooltip.setText(LocaleController.formatString("AttachStickersRestricted", R.string.AttachStickersRestricted, LocaleController.formatDateForBan(chat.banned_rights.until_date)));
            }
        } else if (z) {
            this.mediaBanTooltip.setText(LocaleController.getString("GlobalAttachGifRestricted", R.string.GlobalAttachGifRestricted));
        } else {
            this.mediaBanTooltip.setText(LocaleController.getString("GlobalAttachStickersRestricted", R.string.GlobalAttachStickersRestricted));
        }
        this.mediaBanTooltip.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.mediaBanTooltip, (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f));
        animatorSet.addListener(new AnonymousClass30());
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    /* renamed from: org.rbmain.ui.Components.EmojiView$30, reason: invalid class name */
    class AnonymousClass30 extends AnimatorListenerAdapter {
        AnonymousClass30() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$30$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0();
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() {
            if (EmojiView.this.mediaBanTooltip == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(EmojiView.this.mediaBanTooltip, (Property<TextView, Float>) View.ALPHA, 0.0f));
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.EmojiView.30.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
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

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        TLRPC$StickerSet tLRPC$StickerSet;
        int i3 = 0;
        if (i == NotificationCenter.stickersDidLoad) {
            if (((Integer) objArr[0]).intValue() == 0) {
                updateStickerTabs();
                updateVisibleTrendingSets();
                reloadStickersAdapter();
                checkPanels();
                return;
            }
            return;
        }
        if (i == NotificationCenter.recentDocumentsDidLoad) {
            boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
            int iIntValue = ((Integer) objArr[1]).intValue();
            if (zBooleanValue || iIntValue == 0 || iIntValue == 2) {
                checkDocuments(zBooleanValue);
                return;
            }
            return;
        }
        if (i == NotificationCenter.featuredStickersDidLoad) {
            updateVisibleTrendingSets();
            PagerSlidingTabStrip pagerSlidingTabStrip = this.typeTabs;
            if (pagerSlidingTabStrip != null) {
                int childCount = pagerSlidingTabStrip.getChildCount();
                while (i3 < childCount) {
                    this.typeTabs.getChildAt(i3).invalidate();
                    i3++;
                }
            }
            updateStickerTabs();
            return;
        }
        if (i == NotificationCenter.groupStickersDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            if (tLRPC$ChatFull == null || (tLRPC$StickerSet = tLRPC$ChatFull.stickerset) == null || tLRPC$StickerSet.id != ((Long) objArr[0]).longValue()) {
                return;
            }
            updateStickerTabs();
            return;
        }
        if (i == NotificationCenter.emojiDidLoad) {
            RecyclerListView recyclerListView = this.stickersGridView;
            if (recyclerListView != null) {
                int childCount2 = recyclerListView.getChildCount();
                while (i3 < childCount2) {
                    View childAt = this.stickersGridView.getChildAt(i3);
                    if ((childAt instanceof StickerSetNameCell) || (childAt instanceof StickerEmojiCell)) {
                        childAt.invalidate();
                    }
                    i3++;
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
        if (i == NotificationCenter.newEmojiSuggestionsAvailable && this.emojiGridView != null && this.needEmojiSearch) {
            if ((this.emojiSearchField.progressDrawable.isAnimating() || this.emojiGridView.getAdapter() == this.emojiSearchAdapter) && !TextUtils.isEmpty(this.emojiSearchAdapter.lastSearchEmojiString)) {
                EmojiSearchAdapter emojiSearchAdapter = this.emojiSearchAdapter;
                emojiSearchAdapter.search(emojiSearchAdapter.lastSearchEmojiString);
            }
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public StickersGridAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i = this.totalItems;
            if (i != 0) {
                return i + 1;
            }
            return 0;
        }

        public int getPositionForPack(Object obj) {
            Integer num = this.packStartPosition.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 4;
            }
            Object obj = this.cache.get(i);
            if (obj == null) {
                return 1;
            }
            if (obj instanceof TLRPC$Document) {
                return 0;
            }
            return obj instanceof String ? 3 : 2;
        }

        public int getTabForPosition(int i) {
            if (i == 0) {
                i = 1;
            }
            if (this.stickersPerRow == 0) {
                int measuredWidth = EmojiView.this.getMeasuredWidth();
                if (measuredWidth == 0) {
                    measuredWidth = AndroidUtilities.displaySize.x;
                }
                this.stickersPerRow = measuredWidth / AndroidUtilities.dp(72.0f);
            }
            int i2 = this.positionToRow.get(i, Integer.MIN_VALUE);
            if (i2 == Integer.MIN_VALUE) {
                return (EmojiView.this.stickerSets.size() - 1) + EmojiView.this.stickersTabOffset;
            }
            Object obj = this.rowStartPack.get(i2);
            if (obj instanceof String) {
                return "recent".equals(obj) ? EmojiView.this.recentTabBum : EmojiView.this.favTabBum;
            }
            return EmojiView.this.stickerSets.indexOf((TLRPC$TL_messages_stickerSet) obj) + EmojiView.this.stickersTabOffset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            if (EmojiView.this.groupStickerSet != null) {
                if (EmojiView.this.delegate != null) {
                    EmojiView.this.delegate.onStickersGroupClick(EmojiView.this.info.id);
                    return;
                }
                return;
            }
            MessagesController.getEmojiSettings(EmojiView.this.currentAccount).edit().putLong("group_hide_stickers_" + EmojiView.this.info.id, EmojiView.this.info.stickerset != null ? EmojiView.this.info.stickerset.id : 0L).apply();
            EmojiView.this.updateStickerTabs();
            if (EmojiView.this.stickersGridAdapter != null) {
                EmojiView.this.stickersGridAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$1(View view) {
            if (EmojiView.this.delegate != null) {
                EmojiView.this.delegate.onStickersGroupClick(EmojiView.this.info.id);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View emptyCell;
            boolean z = true;
            if (i == 0) {
                emptyCell = new StickerEmojiCell(this, this.context, z) { // from class: org.rbmain.ui.Components.EmojiView.StickersGridAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int i2, int i3) {
                        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
            } else if (i == 1) {
                emptyCell = new EmptyCell(this.context);
            } else if (i == 2) {
                StickerSetNameCell stickerSetNameCell = new StickerSetNameCell(this.context, false);
                stickerSetNameCell.setOnIconClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.EmojiView$StickersGridAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$0(view);
                    }
                });
                emptyCell = stickerSetNameCell;
            } else if (i == 3) {
                StickerSetGroupInfoCell stickerSetGroupInfoCell = new StickerSetGroupInfoCell(this.context);
                stickerSetGroupInfoCell.setAddOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.EmojiView$StickersGridAdapter$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$1(view);
                    }
                });
                stickerSetGroupInfoCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                emptyCell = stickerSetGroupInfoCell;
            } else if (i != 4) {
                emptyCell = null;
            } else {
                View view = new View(this.context);
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, EmojiView.this.searchFieldHeight));
                emptyCell = view;
            }
            return new RecyclerListView.Holder(emptyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int i2;
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
                    int i3 = this.positionToRow.get(i - 1, Integer.MIN_VALUE);
                    if (i3 == Integer.MIN_VALUE) {
                        emptyCell.setHeight(1);
                        return;
                    }
                    Object obj = this.rowStartPack.get(i3);
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
            if (itemViewType != 2) {
                if (itemViewType != 3) {
                    return;
                }
                ((StickerSetGroupInfoCell) viewHolder.itemView).setIsLast(i == this.totalItems - 1);
                return;
            }
            StickerSetNameCell stickerSetNameCell = (StickerSetNameCell) viewHolder.itemView;
            if (i == EmojiView.this.groupStickerPackPosition) {
                if (EmojiView.this.groupStickersHidden && EmojiView.this.groupStickerSet == null) {
                    i2 = 0;
                } else {
                    i2 = EmojiView.this.groupStickerSet != null ? R.drawable.stickersclose : R.drawable.stickerset_close;
                }
                TLRPC$Chat chat = EmojiView.this.info != null ? MessagesController.getInstance(EmojiView.this.currentAccount).getChat(Integer.valueOf(EmojiView.this.info.id)) : null;
                Object[] objArr = new Object[1];
                objArr[0] = chat != null ? chat.title : "Group Stickers";
                stickerSetNameCell.setText(LocaleController.formatString("CurrentGroupStickers", R.string.CurrentGroupStickers, objArr), i2);
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

        /* JADX WARN: Removed duplicated region for block: B:21:0x00f3  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void notifyDataSetChanged() {
            /*
                Method dump skipped, instructions count: 397
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.EmojiView.StickersGridAdapter.notifyDataSetChanged():void");
        }
    }

    private class EmojiGridAdapter extends RecyclerListView.SelectionAdapter {
        private int itemCount;
        private SparseIntArray positionToSection;
        private SparseIntArray sectionToPosition;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        private EmojiGridAdapter() {
            this.positionToSection = new SparseIntArray();
            this.sectionToPosition = new SparseIntArray();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.itemCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View imageViewEmoji;
            if (i == 0) {
                EmojiView emojiView = EmojiView.this;
                imageViewEmoji = emojiView.new ImageViewEmoji(emojiView.getContext());
            } else if (i == 1) {
                imageViewEmoji = new StickerSetNameCell(EmojiView.this.getContext(), true);
            } else {
                imageViewEmoji = new View(EmojiView.this.getContext());
                imageViewEmoji.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
            }
            return new RecyclerListView.Holder(imageViewEmoji);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String str;
            String strAddColorToCode;
            String str2;
            String str3;
            int itemViewType = viewHolder.getItemViewType();
            boolean z = false;
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                ((StickerSetNameCell) viewHolder.itemView).setText(EmojiView.this.emojiTitles[this.positionToSection.get(i)], 0);
                return;
            }
            ImageViewEmoji imageViewEmoji = (ImageViewEmoji) viewHolder.itemView;
            if (EmojiView.this.needEmojiSearch) {
                i--;
            }
            int size = Emoji.recentEmoji.size();
            if (i < size) {
                str3 = Emoji.recentEmoji.get(i);
                str2 = str3;
                z = true;
            } else {
                int i2 = 0;
                while (true) {
                    String[][] strArr = EmojiData.dataColored;
                    if (i2 >= strArr.length) {
                        str = null;
                        break;
                    }
                    int length = strArr[i2].length + 1 + size;
                    if (i < length) {
                        str = strArr[i2][(i - size) - 1];
                        String str4 = Emoji.emojiColor.get(str);
                        if (str4 != null) {
                            strAddColorToCode = EmojiView.addColorToCode(str, str4);
                        }
                    } else {
                        i2++;
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
        public int getItemViewType(int i) {
            if (EmojiView.this.needEmojiSearch && i == 0) {
                return 2;
            }
            return this.positionToSection.indexOfKey(i) >= 0 ? 1 : 0;
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 0;
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
                FrameLayout frameLayout = new FrameLayout(EmojiView.this.getContext()) { // from class: org.rbmain.ui.Components.EmojiView.EmojiSearchAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int i2, int i3) {
                        int iDp;
                        if (((View) EmojiView.this.getParent()) != null) {
                            iDp = (int) (r3.getMeasuredHeight() - EmojiView.this.getY());
                        } else {
                            iDp = AndroidUtilities.dp(120.0f);
                        }
                        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(iDp - EmojiView.this.searchFieldHeight, 1073741824));
                    }
                };
                TextView textView = new TextView(EmojiView.this.getContext());
                textView.setText(LocaleController.getString("NoEmojiFound", R.string.NoEmojiFound));
                textView.setTextSize(1, 16.0f);
                int i2 = Theme.key_chat_emojiPanelEmptyText;
                textView.setTextColor(Theme.getColor(i2));
                frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 10.0f, 0.0f, 0.0f));
                ImageView imageView = new ImageView(EmojiView.this.getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setImageResource(R.drawable.smiles_panel_question);
                imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
                frameLayout.addView(imageView, LayoutHelper.createFrame(48, 48, 85));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.EmojiView.EmojiSearchAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
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
                        textView2.setTextColor(Theme.getColor(Theme.key_dialogTextBlue2));
                        textView2.setGravity(LocaleController.isRTL ? 5 : 3);
                        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                        linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 51, 0, 24, 0, 0));
                        TextView textView3 = new TextView(EmojiView.this.getContext());
                        textView3.setText(AndroidUtilities.replaceTags(LocaleController.getString("EmojiSuggestionsInfo", R.string.EmojiSuggestionsInfo)));
                        textView3.setTextSize(1, 15.0f);
                        textView3.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
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
                        textView4.setTextColor(Theme.getColor(Theme.key_dialogTextLink));
                        textView4.setGravity(LocaleController.isRTL ? 5 : 3);
                        linearLayout.addView(textView4, LayoutHelper.createLinear(-2, -2, 51, 0, 18, 0, 16));
                        textView4.setOnClickListener(new AnonymousClass1(zArr, builder));
                        builder.setCustomView(linearLayout);
                        builder.show();
                    }

                    /* renamed from: org.rbmain.ui.Components.EmojiView$EmojiSearchAdapter$2$1, reason: invalid class name */
                    class AnonymousClass1 implements View.OnClickListener {
                        final /* synthetic */ BottomSheet.Builder val$builder;
                        final /* synthetic */ boolean[] val$loadingUrl;

                        AnonymousClass1(boolean[] zArr, BottomSheet.Builder builder) {
                            this.val$loadingUrl = zArr;
                            this.val$builder = builder;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
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
                            final int iSendRequest = connectionsManager.sendRequest(tLRPC$TL_messages_getEmojiURL, new RequestDelegate() { // from class: org.rbmain.ui.Components.EmojiView$EmojiSearchAdapter$2$1$$ExternalSyntheticLambda3
                                @Override // org.rbmain.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$onClick$1(alertDialogArr, builder, tLObject, tLRPC$TL_error);
                                }
                            });
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$EmojiSearchAdapter$2$1$$ExternalSyntheticLambda1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onClick$3(alertDialogArr, iSendRequest);
                                }
                            }, 1000L);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onClick$1(final AlertDialog[] alertDialogArr, final BottomSheet.Builder builder, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$EmojiSearchAdapter$2$1$$ExternalSyntheticLambda2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onClick$0(alertDialogArr, tLObject, builder);
                                }
                            });
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onClick$0(AlertDialog[] alertDialogArr, TLObject tLObject, BottomSheet.Builder builder) {
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
                        public /* synthetic */ void lambda$onClick$3(AlertDialog[] alertDialogArr, final int i) {
                            if (alertDialogArr[0] == null) {
                                return;
                            }
                            alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.Components.EmojiView$EmojiSearchAdapter$2$1$$ExternalSyntheticLambda0
                                @Override // android.content.DialogInterface.OnCancelListener
                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.f$0.lambda$onClick$2(i, dialogInterface);
                                }
                            });
                            alertDialogArr[0].show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onClick$2(int i, DialogInterface dialogInterface) {
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
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String str;
            boolean z;
            if (viewHolder.getItemViewType() != 0) {
                return;
            }
            ImageViewEmoji imageViewEmoji = (ImageViewEmoji) viewHolder.itemView;
            int i2 = i - 1;
            if (this.result.isEmpty() && !this.searchWas) {
                str = Emoji.recentEmoji.get(i2);
                z = true;
            } else {
                str = this.result.get(i2).emoji;
                z = false;
            }
            imageViewEmoji.setImageDrawable(Emoji.getEmojiBigDrawable(str), z);
            imageViewEmoji.setTag(str);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 1;
            }
            return (i == 1 && this.searchWas && this.result.isEmpty()) ? 2 : 0;
        }

        public void search(String str) {
            if (TextUtils.isEmpty(str)) {
                this.lastSearchEmojiString = null;
                if (EmojiView.this.emojiGridView.getAdapter() != EmojiView.this.emojiAdapter) {
                    EmojiView.this.emojiGridView.setAdapter(EmojiView.this.emojiAdapter);
                    this.searchWas = false;
                }
                notifyDataSetChanged();
            } else {
                this.lastSearchEmojiString = str.toLowerCase();
            }
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            if (TextUtils.isEmpty(this.lastSearchEmojiString)) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Components.EmojiView.EmojiSearchAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    EmojiView.this.emojiSearchField.progressDrawable.startAnimation();
                    final String str2 = EmojiSearchAdapter.this.lastSearchEmojiString;
                    String[] currentKeyboardLanguage = AndroidUtilities.getCurrentKeyboardLanguage();
                    if (!Arrays.equals(EmojiView.this.lastSearchKeyboardLanguage, currentKeyboardLanguage)) {
                        MediaDataController.getInstance(EmojiView.this.currentAccount).fetchNewEmojiKeywords(currentKeyboardLanguage);
                    }
                    EmojiView.this.lastSearchKeyboardLanguage = currentKeyboardLanguage;
                    MediaDataController.getInstance(EmojiView.this.currentAccount).getEmojiSuggestions(EmojiView.this.lastSearchKeyboardLanguage, EmojiSearchAdapter.this.lastSearchEmojiString, false, new MediaDataController.KeywordResultCallback() { // from class: org.rbmain.ui.Components.EmojiView.EmojiSearchAdapter.3.1
                        @Override // org.rbmain.messenger.MediaDataController.KeywordResultCallback
                        public void run(ArrayList<MediaDataController.KeywordResult> arrayList, String str3) {
                            if (str2.equals(EmojiSearchAdapter.this.lastSearchEmojiString)) {
                                EmojiSearchAdapter.this.lastSearchAlias = str3;
                                EmojiView.this.emojiSearchField.progressDrawable.stopAnimation();
                                EmojiSearchAdapter.this.searchWas = true;
                                if (EmojiView.this.emojiGridView.getAdapter() != EmojiView.this.emojiSearchAdapter) {
                                    EmojiView.this.emojiGridView.setAdapter(EmojiView.this.emojiSearchAdapter);
                                }
                                EmojiSearchAdapter.this.result = arrayList;
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
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private EmojiPagesAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) EmojiView.this.views.get(i));
        }

        @Override // org.rbmain.ui.Components.PagerSlidingTabStrip.IconTabProvider
        public boolean canScrollToTab(int i) {
            if ((i != 1 && i != 2) || EmojiView.this.currentChatId == 0) {
                return true;
            }
            EmojiView.this.showStickerBanHint(i == 1);
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EmojiView.this.views.size();
        }

        @Override // org.rbmain.ui.Components.PagerSlidingTabStrip.IconTabProvider
        public Drawable getPageIconDrawable(int i) {
            return EmojiView.this.tabIcons[i];
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (i == 0) {
                return LocaleController.getString("Emoji", R.string.Emoji);
            }
            if (i == 1) {
                return LocaleController.getString("AccDescrGIFs", R.string.AccDescrGIFs);
            }
            if (i != 2) {
                return null;
            }
            return LocaleController.getString("AccDescrStickers", R.string.AccDescrStickers);
        }

        @Override // org.rbmain.ui.Components.PagerSlidingTabStrip.IconTabProvider
        public void customOnDraw(Canvas canvas, int i) {
            if (i != 2 || MediaDataController.getInstance(EmojiView.this.currentAccount).getUnreadStickerSets().isEmpty() || EmojiView.this.dotPaint == null) {
                return;
            }
            canvas.drawCircle((canvas.getWidth() / 2) + AndroidUtilities.dp(9.0f), (canvas.getHeight() / 2) - AndroidUtilities.dp(8.0f), AndroidUtilities.dp(5.0f), EmojiView.this.dotPaint);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = (View) EmojiView.this.views.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (dataSetObserver != null) {
                super.unregisterDataSetObserver(dataSetObserver);
            }
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
        private boolean needGifSearch;
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

        public GifAdapter(EmojiView emojiView, Context context) {
            this(context, false, 0);
        }

        public GifAdapter(EmojiView emojiView, Context context, boolean z) {
            this(context, z, z ? ConnectionsManager.DEFAULT_DATACENTER_ID : 0);
        }

        public GifAdapter(Context context, boolean z, int i) {
            this.results = new ArrayList<>();
            this.resultsMap = new HashMap<>();
            this.trendingSectionItem = -1;
            this.firstResultItem = -1;
            this.needGifSearch = false;
            this.context = context;
            this.withRecent = z;
            this.maxRecentRowsCount = i;
            this.progressEmptyView = z ? null : EmojiView.this.new GifProgressEmptyView(context);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.itemsCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0 && this.needGifSearch) {
                return 1;
            }
            boolean z = this.withRecent;
            if (z && i == this.trendingSectionItem) {
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
                StickerSetNameCell stickerSetNameCell = new StickerSetNameCell(this.context, false);
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
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() != 0) {
                return;
            }
            ContextLinkCell contextLinkCell = (ContextLinkCell) viewHolder.itemView;
            int i2 = this.firstResultItem;
            if (i2 < 0 || i < i2) {
                contextLinkCell.setGif((TLRPC$Document) EmojiView.this.recentGifs.get(i - (this.needGifSearch ? 1 : 0)), false);
            } else {
                contextLinkCell.setLink(this.results.get(i - i2), this.bot, true, false, false, true);
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
            boolean z = this.needGifSearch;
            this.itemsCount = z ? 1 : 0;
            if (this.withRecent) {
                this.itemsCount = (z ? 1 : 0) + this.recentItemsCount;
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
            search(BuildConfig.FLAVOR, BuildConfig.FLAVOR, true, true, true);
        }

        private void searchBotUser() {
            if (this.searchingUser) {
                return;
            }
            this.searchingUser = true;
            TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
            tLRPC$TL_contacts_resolveUsername.username = MessagesController.getInstance(EmojiView.this.currentAccount).gifSearchBot;
            ConnectionsManager.getInstance(EmojiView.this.currentAccount).sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: org.rbmain.ui.Components.EmojiView$GifAdapter$$ExternalSyntheticLambda2
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$searchBotUser$1(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchBotUser$1(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$GifAdapter$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchBotUser$0(tLObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchBotUser$0(TLObject tLObject) {
            TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
            MessagesController.getInstance(EmojiView.this.currentAccount).putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
            MessagesController.getInstance(EmojiView.this.currentAccount).putChats(tLRPC$TL_contacts_resolvedPeer.chats, false);
            MessagesStorage.getInstance(EmojiView.this.currentAccount).putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, true, true);
            String str = this.lastSearchImageString;
            this.lastSearchImageString = null;
            search(str, BuildConfig.FLAVOR, false);
        }

        public void search(final String str) {
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
            if (TextUtils.isEmpty(str)) {
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
            String lowerCase = str.toLowerCase();
            this.lastSearchImageString = lowerCase;
            if (TextUtils.isEmpty(lowerCase)) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Components.EmojiView.GifAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    GifAdapter.this.search(str, BuildConfig.FLAVOR, true);
                }
            };
            this.searchRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }

        public void searchEmoji(String str) {
            if (this.lastSearchIsEmoji && TextUtils.equals(this.lastSearchImageString, str)) {
                EmojiView.this.gifLayoutManager.scrollToPositionWithOffset(1, 0);
            } else {
                search(str, BuildConfig.FLAVOR, true, true, true);
            }
        }

        protected void search(String str, String str2, boolean z) {
            search(str, str2, z, false, false);
        }

        protected void search(final String str, final String str2, final boolean z, final boolean z2, final boolean z3) {
            int i = this.reqId;
            if (i != 0) {
                if (i >= 0) {
                    ConnectionsManager.getInstance(EmojiView.this.currentAccount).cancelRequest(this.reqId, true);
                }
                this.reqId = 0;
            }
            this.lastSearchImageString = str;
            this.lastSearchIsEmoji = z2;
            GifProgressEmptyView gifProgressEmptyView = this.progressEmptyView;
            if (gifProgressEmptyView != null) {
                gifProgressEmptyView.setLoadingState(z2);
            }
            TLObject userOrChat = MessagesController.getInstance(EmojiView.this.currentAccount).getUserOrChat(MessagesController.getInstance(EmojiView.this.currentAccount).gifSearchBot);
            if (!(userOrChat instanceof TLRPC$User)) {
                if (z) {
                    searchBotUser();
                    if (this.withRecent) {
                        return;
                    }
                    EmojiView.this.gifSearchField.progressDrawable.startAnimation();
                    return;
                }
                return;
            }
            if (!this.withRecent && TextUtils.isEmpty(str2)) {
                EmojiView.this.gifSearchField.progressDrawable.startAnimation();
            }
            this.bot = (TLRPC$User) userOrChat;
            final String str3 = "gif_search_" + str + "_" + str2;
            RequestDelegate requestDelegate = new RequestDelegate() { // from class: org.rbmain.ui.Components.EmojiView$GifAdapter$$ExternalSyntheticLambda3
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$search$3(str, str2, z, z2, z3, str3, tLObject, tLRPC$TL_error);
                }
            };
            if (!z3 && !this.withRecent && z2 && TextUtils.isEmpty(str2)) {
                this.results.clear();
                this.resultsMap.clear();
                if (EmojiView.this.gifGridView.getAdapter() != this) {
                    EmojiView.this.gifGridView.setAdapter(this);
                }
                notifyDataSetChanged();
                EmojiView.this.scrollGifsToTop();
            }
            if (!z3 || !EmojiView.this.gifCache.containsKey(str3)) {
                if (EmojiView.this.gifSearchPreloader.isLoading(str3)) {
                    return;
                }
                if (z3) {
                    this.reqId = -1;
                    MessagesStorage.getInstance(EmojiView.this.currentAccount).getBotCache(str3, requestDelegate);
                    return;
                }
                TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                tLRPC$TL_messages_getInlineBotResults.query = str;
                tLRPC$TL_messages_getInlineBotResults.bot = MessagesController.getInstance(EmojiView.this.currentAccount).getInputUser(this.bot);
                tLRPC$TL_messages_getInlineBotResults.offset = str2;
                tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
                this.reqId = ConnectionsManager.getInstance(EmojiView.this.currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, requestDelegate, 2);
                return;
            }
            lambda$search$2(str, str2, z, z2, true, str3, (TLObject) EmojiView.this.gifCache.get(str3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$search$3(final String str, final String str2, final boolean z, final boolean z2, final boolean z3, final String str3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$GifAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$2(str, str2, z, z2, z3, str3, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processResponse, reason: merged with bridge method [inline-methods] */
        public void lambda$search$2(String str, String str2, boolean z, boolean z2, boolean z3, String str3, TLObject tLObject) {
            if (str == null || !str.equals(this.lastSearchImageString)) {
                return;
            }
            this.reqId = 0;
            if (z3 && (!(tLObject instanceof TLRPC$messages_BotResults) || ((TLRPC$messages_BotResults) tLObject).results.isEmpty())) {
                search(str, str2, z, z2, false);
                return;
            }
            if (!this.withRecent && TextUtils.isEmpty(str2)) {
                this.results.clear();
                this.resultsMap.clear();
                EmojiView.this.gifSearchField.progressDrawable.stopAnimation();
            }
            if (tLObject instanceof TLRPC$messages_BotResults) {
                int size = this.results.size();
                TLRPC$messages_BotResults tLRPC$messages_BotResults = (TLRPC$messages_BotResults) tLObject;
                if (!EmojiView.this.gifCache.containsKey(str3)) {
                    EmojiView.this.gifCache.put(str3, tLRPC$messages_BotResults);
                }
                if (!z3 && tLRPC$messages_BotResults.cache_time != 0) {
                    MessagesStorage.getInstance(EmojiView.this.currentAccount).saveBotCache(str3, tLRPC$messages_BotResults);
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
                    if (!z2 || size != 0) {
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
            if (z2 && !TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
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

        public boolean isLoading(String str) {
            return this.loadingKeys.contains(str);
        }

        public void preload(String str) {
            preload(str, BuildConfig.FLAVOR, true);
        }

        private void preload(final String str, final String str2, final boolean z) {
            final String str3 = "gif_search_" + str + "_" + str2;
            if (z && EmojiView.this.gifCache.containsKey(str3)) {
                return;
            }
            RequestDelegate requestDelegate = new RequestDelegate() { // from class: org.rbmain.ui.Components.EmojiView$GifSearchPreloader$$ExternalSyntheticLambda1
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$preload$1(str, str2, z, str3, tLObject, tLRPC$TL_error);
                }
            };
            if (!z) {
                MessagesController messagesController = MessagesController.getInstance(EmojiView.this.currentAccount);
                TLObject userOrChat = messagesController.getUserOrChat(messagesController.gifSearchBot);
                if (userOrChat instanceof TLRPC$User) {
                    this.loadingKeys.add(str3);
                    TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
                    if (str == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    tLRPC$TL_messages_getInlineBotResults.query = str;
                    tLRPC$TL_messages_getInlineBotResults.bot = messagesController.getInputUser((TLRPC$User) userOrChat);
                    tLRPC$TL_messages_getInlineBotResults.offset = str2;
                    tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
                    ConnectionsManager.getInstance(EmojiView.this.currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, requestDelegate, 2);
                    return;
                }
                return;
            }
            this.loadingKeys.add(str3);
            MessagesStorage.getInstance(EmojiView.this.currentAccount).getBotCache(str3, requestDelegate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$preload$1(final String str, final String str2, final boolean z, final String str3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$GifSearchPreloader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$preload$0(str, str2, z, str3, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processResponse, reason: merged with bridge method [inline-methods] */
        public void lambda$preload$0(String str, String str2, boolean z, String str3, TLObject tLObject) {
            this.loadingKeys.remove(str3);
            if (EmojiView.this.gifSearchAdapter.lastSearchIsEmoji && EmojiView.this.gifSearchAdapter.lastSearchImageString.equals(str)) {
                EmojiView.this.gifSearchAdapter.lambda$search$2(str, str2, false, true, z, str3, tLObject);
                return;
            }
            if (z && (!(tLObject instanceof TLRPC$messages_BotResults) || ((TLRPC$messages_BotResults) tLObject).results.isEmpty())) {
                preload(str, str2, false);
            } else {
                if (!(tLObject instanceof TLRPC$messages_BotResults) || EmojiView.this.gifCache.containsKey(str3)) {
                    return;
                }
                EmojiView.this.gifCache.put(str3, (TLRPC$messages_BotResults) tLObject);
            }
        }
    }

    private class GifLayoutManager extends ExtendedGridLayoutManager {
        private Size size;

        public GifLayoutManager(Context context) {
            super(context, 100, true);
            this.size = new Size();
            setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(EmojiView.this) { // from class: org.rbmain.ui.Components.EmojiView.GifLayoutManager.1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    if (i != 0 && (EmojiView.this.gifGridView.getAdapter() != EmojiView.this.gifSearchAdapter || !EmojiView.this.gifSearchAdapter.results.isEmpty())) {
                        if (EmojiView.this.gifGridView != null && EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifAdapter) {
                            return GifLayoutManager.this.getSpanSizeForItem(0);
                        }
                        return GifLayoutManager.this.getSpanSizeForItem(i - 1);
                    }
                    return GifLayoutManager.this.getSpanCount();
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v19, types: [java.util.ArrayList<org.rbmain.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v20, types: [java.util.ArrayList<org.rbmain.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v21, types: [java.util.ArrayList<org.rbmain.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.util.ArrayList<org.rbmain.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.util.ArrayList<org.rbmain.tgnet.TLRPC$DocumentAttribute>] */
        /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList<org.rbmain.tgnet.TLRPC$DocumentAttribute>] */
        @Override // org.rbmain.ui.Components.ExtendedGridLayoutManager
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

        @Override // org.rbmain.ui.Components.ExtendedGridLayoutManager
        protected int getFlowItemCount() {
            if (EmojiView.this.gifGridView.getAdapter() == EmojiView.this.gifSearchAdapter && EmojiView.this.gifSearchAdapter.results.isEmpty()) {
                return 0;
            }
            return getItemCount() - 1;
        }

        public Size getSizeForItem(TLRPC$Document tLRPC$Document) {
            return getSizeForItem(tLRPC$Document, tLRPC$Document.attributes);
        }

        public Size getSizeForItem(TLRPC$Document tLRPC$Document, List<TLRPC$DocumentAttribute> list) {
            TLRPC$PhotoSize closestPhotoSizeWithSize;
            int i;
            int i2;
            Size size = this.size;
            size.height = 100.0f;
            size.width = 100.0f;
            if (tLRPC$Document != null && (closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90)) != null && (i = closestPhotoSizeWithSize.w) != 0 && (i2 = closestPhotoSizeWithSize.h) != 0) {
                Size size2 = this.size;
                size2.width = i;
                size2.height = i2;
            }
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = list.get(i3);
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
            int i = Theme.key_chat_emojiPanelEmptyText;
            imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            addView(imageView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 59.0f));
            TextView textView = new TextView(getContext());
            this.textView = textView;
            textView.setText(LocaleController.getString("NoGIFsFound", R.string.NoGIFsFound));
            textView.setTextSize(1, 16.0f);
            textView.setTextColor(Theme.getColor(i));
            addView(textView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 9.0f));
            RadialProgressView radialProgressView = new RadialProgressView(context);
            this.progressView = radialProgressView;
            radialProgressView.setVisibility(8);
            radialProgressView.setProgressColor(Theme.getColor(Theme.key_progressCircle));
            addView(radialProgressView, LayoutHelper.createFrame(-2, -2, 17));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int iDp;
            int measuredHeight = EmojiView.this.gifGridView.getMeasuredHeight();
            if (!this.loadingState) {
                iDp = (int) ((((measuredHeight - EmojiView.this.searchFieldHeight) - AndroidUtilities.dp(8.0f)) / 3) * 1.7f);
            } else {
                iDp = measuredHeight - AndroidUtilities.dp(92.0f);
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(iDp, 1073741824));
        }

        public void setLoadingState(boolean z) {
            if (this.loadingState != z) {
                this.loadingState = z;
                this.imageView.setVisibility(z ? 8 : 0);
                this.textView.setVisibility(z ? 8 : 0);
                this.progressView.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class StickersSearchGridAdapter extends RecyclerListView.SelectionAdapter {
        boolean cleared;
        private Context context;
        private int emojiSearchId;
        private boolean hasContinue;
        private int reqId;
        private int reqId2;
        private String searchQuery;
        private String startID;
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        static /* synthetic */ int access$14604(StickersSearchGridAdapter stickersSearchGridAdapter) {
            int i = stickersSearchGridAdapter.emojiSearchId + 1;
            stickersSearchGridAdapter.emojiSearchId = i;
            return i;
        }

        /* renamed from: org.rbmain.ui.Components.EmojiView$StickersSearchGridAdapter$1, reason: invalid class name */
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
                StickersSearchGridAdapter.this.startID = null;
                StickersSearchGridAdapter.this.hasContinue = true;
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
                    Method dump skipped, instructions count: 844
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.EmojiView.StickersSearchGridAdapter.AnonymousClass1.run():void");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$1(final TLRPC$TL_messages_searchStickerSets tLRPC$TL_messages_searchStickerSets, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                if (tLObject instanceof TLRPC$TL_messages_foundStickerSets) {
                    TLRPC$TL_messages_foundStickerSets tLRPC$TL_messages_foundStickerSets = (TLRPC$TL_messages_foundStickerSets) tLObject;
                    StickersSearchGridAdapter.this.startID = tLRPC$TL_messages_foundStickerSets.nextStartId;
                    StickersSearchGridAdapter.this.hasContinue = tLRPC$TL_messages_foundStickerSets.hasContinue;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$StickersSearchGridAdapter$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$run$0(tLRPC$TL_messages_searchStickerSets, tLObject);
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0(TLRPC$TL_messages_searchStickerSets tLRPC$TL_messages_searchStickerSets, TLObject tLObject) {
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
            public /* synthetic */ void lambda$run$3(final TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers, final ArrayList arrayList, final LongSparseArray longSparseArray, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EmojiView$StickersSearchGridAdapter$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$2(tLRPC$TL_messages_getStickers, tLObject, arrayList, longSparseArray);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$2(TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers, TLObject tLObject, ArrayList arrayList, LongSparseArray longSparseArray) {
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

        public void search(String str) {
            if (this.reqId != 0) {
                ConnectionsManager.getInstance(EmojiView.this.currentAccount).cancelRequest(this.reqId, true);
                this.reqId = 0;
            }
            if (this.reqId2 != 0) {
                ConnectionsManager.getInstance(EmojiView.this.currentAccount).cancelRequest(this.reqId2, true);
                this.reqId2 = 0;
            }
            if (TextUtils.isEmpty(str)) {
                this.searchQuery = null;
                this.localPacks.clear();
                this.emojiStickers.clear();
                this.serverPacks.clear();
                if (EmojiView.this.stickersGridView.getAdapter() != EmojiView.this.stickersGridAdapter) {
                    EmojiView.this.stickersGridView.setAdapter(EmojiView.this.stickersGridAdapter);
                }
                notifyDataSetChanged();
            } else {
                this.searchQuery = str.toLowerCase();
            }
            AndroidUtilities.cancelRunOnUIThread(this.searchRunnable);
            AndroidUtilities.runOnUIThread(this.searchRunnable, 300L);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 4;
            }
            if (i == 1 && this.totalItems == 1) {
                return 5;
            }
            Object obj = this.cache.get(i);
            if (obj == null) {
                return 1;
            }
            if (obj instanceof TLRPC$Document) {
                return 0;
            }
            return obj instanceof TLRPC$StickerSetCovered ? 3 : 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
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
            FrameLayout frameLayout;
            View emptyCell;
            boolean z = true;
            if (i == 0) {
                frameLayout = new StickerEmojiCell(this, this.context, z) { // from class: org.rbmain.ui.Components.EmojiView.StickersSearchGridAdapter.2
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int i2, int i3) {
                        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
            } else {
                if (i == 1) {
                    emptyCell = new EmptyCell(this.context);
                } else if (i == 2) {
                    emptyCell = new StickerSetNameCell(this.context, false);
                } else if (i == 3) {
                    FeaturedStickerSetInfoCell featuredStickerSetInfoCell = new FeaturedStickerSetInfoCell(this.context, 17);
                    featuredStickerSetInfoCell.setAddOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.EmojiView$StickersSearchGridAdapter$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$0(view);
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
                    frameLayout = new FrameLayout(this.context) { // from class: org.rbmain.ui.Components.EmojiView.StickersSearchGridAdapter.3
                        @Override // android.widget.FrameLayout, android.view.View
                        protected void onMeasure(int i2, int i3) {
                            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec((int) ((((EmojiView.this.stickersGridView.getMeasuredHeight() - EmojiView.this.searchFieldHeight) - AndroidUtilities.dp(8.0f)) / 3) * 1.7f), 1073741824));
                        }
                    };
                    ImageView imageView = new ImageView(this.context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setImageResource(R.drawable.stickers_empty);
                    int i2 = Theme.key_chat_emojiPanelEmptyText;
                    imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
                    frameLayout.addView(imageView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 59.0f));
                    TextView textView = new TextView(this.context);
                    textView.setText(LocaleController.getString("NoStickersFound", R.string.NoStickersFound));
                    textView.setTextSize(1, 16.0f);
                    textView.setTextColor(Theme.getColor(i2));
                    frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 9.0f));
                    frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                }
                return new RecyclerListView.Holder(emptyCell);
            }
            emptyCell = frameLayout;
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
                stickerEmojiCell.setSticker(tLRPC$Document, this.cacheParent.get(i), this.positionToEmoji.get(i), false);
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
                            String str = BuildConfig.FLAVOR;
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

    public static abstract class ChooseStickerActionTracker {
        private final int currentAccount;
        private final long dialogId;
        private final long threadId;
        boolean typingWasSent;
        boolean visible = false;
        long lastActionTime = -1;

        public abstract boolean isShown();

        public ChooseStickerActionTracker(int i, long j, long j2) {
            this.currentAccount = i;
            this.dialogId = j;
            this.threadId = j2;
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

        private void reset() {
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
