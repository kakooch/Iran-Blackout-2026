package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.MetricAffectingSpan;
import android.util.Property;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManagerFixed;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$GeoPoint;
import ir.eitaa.tgnet.TLRPC$Page;
import ir.eitaa.tgnet.TLRPC$PageBlock;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$RichText;
import ir.eitaa.tgnet.TLRPC$TL_channels_joinChannel;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolveUsername;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolvedPeer;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser;
import ir.eitaa.tgnet.TLRPC$TL_messages_getWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messages_messages;
import ir.eitaa.tgnet.TLRPC$TL_page;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockAudio;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockAuthorDate;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockBlockquote;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockChannel;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockCollage;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockCover;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockDetails;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockDivider;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbed;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbedPost;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockFooter;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockHeader;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockKicker;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockList;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockMap;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockOrderedList;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockParagraph;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockPhoto;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockPreformatted;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockPullquote;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockRelatedArticles;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockSlideshow;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockSubheader;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockSubtitle;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockTable;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockTitle;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockVideo;
import ir.eitaa.tgnet.TLRPC$TL_pageRelatedArticle;
import ir.eitaa.tgnet.TLRPC$TL_pageTableCell;
import ir.eitaa.tgnet.TLRPC$TL_pageTableRow;
import ir.eitaa.tgnet.TLRPC$TL_photo;
import ir.eitaa.tgnet.TLRPC$TL_textAnchor;
import ir.eitaa.tgnet.TLRPC$TL_textBold;
import ir.eitaa.tgnet.TLRPC$TL_textConcat;
import ir.eitaa.tgnet.TLRPC$TL_textEmail;
import ir.eitaa.tgnet.TLRPC$TL_textEmpty;
import ir.eitaa.tgnet.TLRPC$TL_textFixed;
import ir.eitaa.tgnet.TLRPC$TL_textImage;
import ir.eitaa.tgnet.TLRPC$TL_textItalic;
import ir.eitaa.tgnet.TLRPC$TL_textMarked;
import ir.eitaa.tgnet.TLRPC$TL_textPhone;
import ir.eitaa.tgnet.TLRPC$TL_textPlain;
import ir.eitaa.tgnet.TLRPC$TL_textStrike;
import ir.eitaa.tgnet.TLRPC$TL_textSubscript;
import ir.eitaa.tgnet.TLRPC$TL_textSuperscript;
import ir.eitaa.tgnet.TLRPC$TL_textUnderline;
import ir.eitaa.tgnet.TLRPC$TL_textUrl;
import ir.eitaa.tgnet.TLRPC$TL_updateNewChannelMessage;
import ir.eitaa.tgnet.TLRPC$TL_user;
import ir.eitaa.tgnet.TLRPC$TL_webPage;
import ir.eitaa.tgnet.TLRPC$TL_webPageNotModified;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnchorSpan;
import ir.eitaa.ui.Components.AnimatedArrowDrawable;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.CloseProgressDrawable2;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.ContextProgressView;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.LineProgressView;
import ir.eitaa.ui.Components.LinkPath;
import ir.eitaa.ui.Components.RadialProgress2;
import ir.eitaa.ui.Components.RadioButton;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SeekBar;
import ir.eitaa.ui.Components.SeekBarView;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.StaticLayoutEx;
import ir.eitaa.ui.Components.TableLayout;
import ir.eitaa.ui.Components.TextPaintImageReceiverSpan;
import ir.eitaa.ui.Components.TextPaintMarkSpan;
import ir.eitaa.ui.Components.TextPaintSpan;
import ir.eitaa.ui.Components.TextPaintUrlSpan;
import ir.eitaa.ui.Components.TextPaintWebpageUrlSpan;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.Components.WebPlayerView;
import ir.eitaa.ui.PhotoViewer;
import ir.eitaa.ui.PinchToZoomHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class ArticleViewer implements NotificationCenter.NotificationCenterDelegate {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile ArticleViewer Instance;
    private static TextPaint channelNamePaint;
    private static TextPaint channelNamePhotoPaint;
    private static Paint dividerPaint;
    private static Paint dotsPaint;
    private static TextPaint embedPostAuthorPaint;
    private static TextPaint embedPostDatePaint;
    private static TextPaint errorTextPaint;
    private static TextPaint listTextNumPaint;
    private static TextPaint listTextPointerPaint;
    private static Paint photoBackgroundPaint;
    private static Paint preformattedBackgroundPaint;
    private static Paint quoteLinePaint;
    private static TextPaint relatedArticleHeaderPaint;
    private static TextPaint relatedArticleTextPaint;
    private static Paint tableHalfLinePaint;
    private static Paint tableHeaderPaint;
    private static Paint tableLinePaint;
    private static Paint tableStripPaint;
    private static Paint urlPaint;
    private static Paint webpageMarkPaint;
    private static Paint webpageSearchPaint;
    private static Paint webpageUrlPaint;
    private WebpageAdapter[] adapter;
    private int anchorsOffsetMeasuredWidth;
    private Runnable animationEndRunnable;
    private int animationInProgress;
    private boolean attachedToWindow;
    private ImageView backButton;
    private BackDrawable backDrawable;
    private Paint backgroundPaint;
    private ImageView clearButton;
    private boolean closeAnimationInProgress;
    private boolean collapsed;
    private FrameLayout containerView;
    private int currentAccount;
    private int currentHeaderHeight;
    private WebPlayerView currentPlayingVideo;
    private int currentSearchIndex;
    private View customView;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private TextView deleteView;
    private boolean drawBlockSelection;
    private AspectRatioFrameLayout fullscreenAspectRatioView;
    private TextureView fullscreenTextureView;
    private FrameLayout fullscreenVideoContainer;
    private WebPlayerView fullscreenedVideo;
    private boolean hasCutout;
    private FrameLayout headerView;
    private boolean ignoreOnTextChange;
    private boolean isVisible;
    private boolean keyboardVisible;
    private Object lastInsets;
    private int lastReqId;
    private Drawable layerShadowDrawable;
    private LinearLayoutManager[] layoutManager;
    private Runnable lineProgressTickRunnable;
    private LineProgressView lineProgressView;
    private BottomSheet linkSheet;
    private RecyclerListView[] listView;
    private TLRPC$Chat loadedChannel;
    private boolean loadingChannel;
    private ActionBarMenuItem menuButton;
    private FrameLayout menuContainer;
    private int openUrlReqId;
    private AnimatorSet pageSwitchAnimation;
    private Activity parentActivity;
    private BaseFragment parentFragment;
    PinchToZoomHelper pinchToZoomHelper;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout popupLayout;
    private Rect popupRect;
    private ActionBarPopupWindow popupWindow;
    private int pressedLayoutY;
    private TextPaintUrlSpan pressedLink;
    private DrawingText pressedLinkOwnerLayout;
    private View pressedLinkOwnerView;
    private int previewsReqId;
    private ContextProgressView progressView;
    private AnimatorSet progressViewAnimation;
    private AnimatorSet runAfterKeyboardClose;
    private Paint scrimPaint;
    private FrameLayout searchContainer;
    private SimpleTextView searchCountText;
    private ImageView searchDownButton;
    private EditTextBoldCursor searchField;
    private FrameLayout searchPanel;
    private Runnable searchRunnable;
    private View searchShadow;
    private String searchText;
    private ImageView searchUpButton;
    private Drawable slideDotBigDrawable;
    private Drawable slideDotDrawable;
    TextSelectionHelper.ArticleTextSelectionHelper textSelectionHelper;
    TextSelectionHelper.ArticleTextSelectionHelper textSelectionHelperBottomSheet;
    private SimpleTextView titleTextView;
    private long transitionAnimationStartTime;
    private Dialog visibleDialog;
    private WindowManager.LayoutParams windowLayoutParams;
    private WindowView windowView;
    public static final Property<WindowView, Float> ARTICLE_VIEWER_INNER_TRANSLATION_X = new AnimationProperties.FloatProperty<WindowView>("innerTranslationX") { // from class: ir.eitaa.ui.ArticleViewer.1
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(WindowView object, float value) {
            object.setInnerTranslationX(value);
        }

        @Override // android.util.Property
        public Float get(WindowView object) {
            return Float.valueOf(object.getInnerTranslationX());
        }
    };
    private static TextPaint audioTimePaint = new TextPaint(1);
    private static SparseArray<TextPaint> photoCaptionTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> photoCreditTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> titleTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> kickerTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> headerTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> subtitleTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> subheaderTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> authorTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> footerTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> paragraphTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> listTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> preformattedTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> quoteTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> embedPostTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> embedPostCaptionTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> mediaCaptionTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> mediaCreditTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> relatedArticleTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> detailsTextPaints = new SparseArray<>();
    private static SparseArray<TextPaint> tableTextPaints = new SparseArray<>();
    private ArrayList<BlockEmbedCell> createdWebViews = new ArrayList<>();
    private int lastBlockNum = 1;
    private DecelerateInterpolator interpolator = new DecelerateInterpolator(1.5f);
    private ArrayList<TLRPC$WebPage> pagesStack = new ArrayList<>();
    private boolean animateClear = true;
    private Paint headerPaint = new Paint();
    private Paint statusBarPaint = new Paint();
    private Paint headerProgressPaint = new Paint();
    private boolean checkingForLongPress = false;
    private CheckForLongPress pendingCheckForLongPress = null;
    private int pressCount = 0;
    private CheckForTap pendingCheckForTap = null;
    private LinkPath urlPath = new LinkPath();
    private int allowAnimationIndex = -1;
    private final String BOTTOM_SHEET_VIEW_TAG = "bottomSheet";
    private int selectedFont = 0;
    private FontCell[] fontCells = new FontCell[2];
    private ArrayList<SearchResult> searchResults = new ArrayList<>();
    private int lastSearchIndex = -1;

    static /* synthetic */ boolean lambda$setParentActivity$20(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindowLayoutParamsForSearch() {
    }

    static /* synthetic */ int access$13008(ArticleViewer articleViewer) {
        int i = articleViewer.lastBlockNum;
        articleViewer.lastBlockNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$1704(ArticleViewer articleViewer) {
        int i = articleViewer.pressCount + 1;
        articleViewer.pressCount = i;
        return i;
    }

    public static ArticleViewer getInstance() {
        ArticleViewer articleViewer = Instance;
        if (articleViewer == null) {
            synchronized (ArticleViewer.class) {
                articleViewer = Instance;
                if (articleViewer == null) {
                    articleViewer = new ArticleViewer();
                    Instance = articleViewer;
                }
            }
        }
        return articleViewer;
    }

    public static boolean hasInstance() {
        return Instance != null;
    }

    private static class TL_pageBlockRelatedArticlesChild extends TLRPC$PageBlock {
        private int num;
        private TLRPC$TL_pageBlockRelatedArticles parent;

        private TL_pageBlockRelatedArticlesChild() {
        }
    }

    private static class TL_pageBlockRelatedArticlesShadow extends TLRPC$PageBlock {
        private TLRPC$TL_pageBlockRelatedArticles parent;

        private TL_pageBlockRelatedArticlesShadow() {
        }
    }

    private static class TL_pageBlockDetailsChild extends TLRPC$PageBlock {
        private TLRPC$PageBlock block;
        private TLRPC$PageBlock parent;

        private TL_pageBlockDetailsChild() {
        }
    }

    private class TL_pageBlockListParent extends TLRPC$PageBlock {
        private ArrayList<TL_pageBlockListItem> items;
        private int lastFontSize;
        private int lastMaxNumCalcWidth;
        private int level;
        private int maxNumWidth;
        private TLRPC$TL_pageBlockList pageBlockList;

        private TL_pageBlockListParent() {
            this.items = new ArrayList<>();
        }
    }

    private class TL_pageBlockListItem extends TLRPC$PageBlock {
        private TLRPC$PageBlock blockItem;
        private int index;
        private String num;
        private DrawingText numLayout;
        private TL_pageBlockListParent parent;
        private TLRPC$RichText textItem;

        private TL_pageBlockListItem() {
            this.index = ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
    }

    private class TL_pageBlockOrderedListParent extends TLRPC$PageBlock {
        private ArrayList<TL_pageBlockOrderedListItem> items;
        private int lastFontSize;
        private int lastMaxNumCalcWidth;
        private int level;
        private int maxNumWidth;
        private TLRPC$TL_pageBlockOrderedList pageBlockOrderedList;

        private TL_pageBlockOrderedListParent() {
            this.items = new ArrayList<>();
        }
    }

    private class TL_pageBlockOrderedListItem extends TLRPC$PageBlock {
        private TLRPC$PageBlock blockItem;
        private int index;
        private String num;
        private DrawingText numLayout;
        private TL_pageBlockOrderedListParent parent;
        private TLRPC$RichText textItem;

        private TL_pageBlockOrderedListItem() {
            this.index = ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
    }

    private static class TL_pageBlockEmbedPostCaption extends TLRPC$TL_pageBlockEmbedPost {
        private TLRPC$TL_pageBlockEmbedPost parent;

        private TL_pageBlockEmbedPostCaption() {
        }
    }

    public class DrawingText implements TextSelectionHelper.TextLayoutBlock {
        public LinkPath markPath;
        public TLRPC$PageBlock parentBlock;
        public Object parentText;
        public CharSequence prefix;
        public int row;
        public int searchIndex = -1;
        public LinkPath searchPath;
        public StaticLayout textLayout;
        public LinkPath textPath;
        public int x;
        public int y;

        public DrawingText() {
        }

        public void draw(Canvas canvas) {
            if (!ArticleViewer.this.searchResults.isEmpty()) {
                SearchResult searchResult = (SearchResult) ArticleViewer.this.searchResults.get(ArticleViewer.this.currentSearchIndex);
                if (searchResult.block != this.parentBlock || (searchResult.text != this.parentText && (!(searchResult.text instanceof String) || this.parentText != null))) {
                    this.searchIndex = -1;
                    this.searchPath = null;
                } else if (this.searchIndex != searchResult.index) {
                    LinkPath linkPath = new LinkPath(true);
                    this.searchPath = linkPath;
                    linkPath.setAllowReset(false);
                    this.searchPath.setCurrentLayout(this.textLayout, searchResult.index, 0.0f);
                    this.searchPath.setBaselineShift(0);
                    this.textLayout.getSelectionPath(searchResult.index, searchResult.index + ArticleViewer.this.searchText.length(), this.searchPath);
                    this.searchPath.setAllowReset(true);
                }
            } else {
                this.searchIndex = -1;
                this.searchPath = null;
            }
            LinkPath linkPath2 = this.searchPath;
            if (linkPath2 != null) {
                canvas.drawPath(linkPath2, ArticleViewer.webpageSearchPaint);
            }
            LinkPath linkPath3 = this.textPath;
            if (linkPath3 != null) {
                canvas.drawPath(linkPath3, ArticleViewer.webpageUrlPaint);
            }
            LinkPath linkPath4 = this.markPath;
            if (linkPath4 != null) {
                canvas.drawPath(linkPath4, ArticleViewer.webpageMarkPaint);
            }
            ArticleViewer.this.drawLayoutLink(canvas, this);
            this.textLayout.draw(canvas);
        }

        public CharSequence getText() {
            return this.textLayout.getText();
        }

        public int getLineCount() {
            return this.textLayout.getLineCount();
        }

        public int getLineAscent(int line) {
            return this.textLayout.getLineAscent(line);
        }

        public float getLineLeft(int line) {
            return this.textLayout.getLineLeft(line);
        }

        public float getLineWidth(int line) {
            return this.textLayout.getLineWidth(line);
        }

        public int getHeight() {
            return this.textLayout.getHeight();
        }

        public int getWidth() {
            return this.textLayout.getWidth();
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.TextLayoutBlock
        public StaticLayout getLayout() {
            return this.textLayout;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.TextLayoutBlock
        public int getX() {
            return this.x;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.TextLayoutBlock
        public int getY() {
            return this.y;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.TextLayoutBlock
        public int getRow() {
            return this.row;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.TextLayoutBlock
        public CharSequence getPrefix() {
            return this.prefix;
        }
    }

    private class TextSizeCell extends FrameLayout {
        private int endFontSize;
        private int lastWidth;
        private SeekBarView sizeBar;
        private int startFontSize;
        private TextPaint textPaint;

        public TextSizeCell(Context context) {
            super(context);
            this.startFontSize = 12;
            this.endFontSize = 30;
            setWillNotDraw(false);
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(16.0f));
            SeekBarView seekBarView = new SeekBarView(context);
            this.sizeBar = seekBarView;
            seekBarView.setReportChanges(true);
            this.sizeBar.setDelegate(new SeekBarView.SeekBarViewDelegate() { // from class: ir.eitaa.ui.ArticleViewer.TextSizeCell.1
                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarPressed(boolean pressed) {
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarDrag(boolean stop, float progress) {
                    int iRound = Math.round(TextSizeCell.this.startFontSize + ((TextSizeCell.this.endFontSize - TextSizeCell.this.startFontSize) * progress));
                    if (iRound != SharedConfig.ivFontSize) {
                        SharedConfig.ivFontSize = iRound;
                        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
                        editorEdit.putInt("iv_font_size", SharedConfig.ivFontSize);
                        editorEdit.commit();
                        ArticleViewer.this.adapter[0].searchTextOffset.clear();
                        ArticleViewer.this.updatePaintSize();
                        TextSizeCell.this.invalidate();
                    }
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public CharSequence getContentDescription() {
                    return String.valueOf(Math.round(TextSizeCell.this.startFontSize + ((TextSizeCell.this.endFontSize - TextSizeCell.this.startFontSize) * TextSizeCell.this.sizeBar.getProgress())));
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public int getStepsCount() {
                    return TextSizeCell.this.endFontSize - TextSizeCell.this.startFontSize;
                }
            });
            addView(this.sizeBar, LayoutHelper.createFrame(-1, 38.0f, 51, 5.0f, 5.0f, 39.0f, 0.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.textPaint.setColor(Theme.getColor("windowBackgroundWhiteValueText"));
            canvas.drawText("" + SharedConfig.ivFontSize, getMeasuredWidth() - AndroidUtilities.dp(39.0f), AndroidUtilities.dp(28.0f), this.textPaint);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            if (this.lastWidth != size) {
                SeekBarView seekBarView = this.sizeBar;
                int i = SharedConfig.ivFontSize;
                int i2 = this.startFontSize;
                seekBarView.setProgress((i - i2) / (this.endFontSize - i2));
                this.lastWidth = size;
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            this.sizeBar.invalidate();
        }
    }

    public static class FontCell extends FrameLayout {
        private RadioButton radioButton;
        private TextView textView;

        public FontCell(Context context) {
            super(context);
            setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("listSelectorSDK21"), 2));
            RadioButton radioButton = new RadioButton(context);
            this.radioButton = radioButton;
            radioButton.setSize(AndroidUtilities.dp(20.0f));
            this.radioButton.setColor(Theme.getColor("dialogRadioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
            RadioButton radioButton2 = this.radioButton;
            boolean z = LocaleController.isRTL;
            addView(radioButton2, LayoutHelper.createFrame(22, 22.0f, (z ? 5 : 3) | 48, z ? 0 : 22, 13.0f, z ? 22 : 0, 0.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView.setLines(1);
            this.textView.setMaxLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            TextView textView2 = this.textView;
            boolean z2 = LocaleController.isRTL;
            addView(textView2, LayoutHelper.createFrame(-1, -1.0f, (z2 ? 5 : 3) | 48, z2 ? 17 : 62, 0.0f, z2 ? 62 : 17, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
        }

        public void select(boolean value, boolean animated) {
            this.radioButton.setChecked(value, animated);
        }

        public void setTextAndTypeface(String text, Typeface typeface) {
            this.textView.setText(text);
            this.textView.setTypeface(typeface);
            setContentDescription(text);
            invalidate();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setClassName(RadioButton.class.getName());
            info.setChecked(this.radioButton.isChecked());
            info.setCheckable(true);
        }
    }

    private final class CheckForTap implements Runnable {
        private CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ArticleViewer.this.pendingCheckForLongPress == null) {
                ArticleViewer articleViewer = ArticleViewer.this;
                articleViewer.pendingCheckForLongPress = articleViewer.new CheckForLongPress();
            }
            ArticleViewer.this.pendingCheckForLongPress.currentPressCount = ArticleViewer.access$1704(ArticleViewer.this);
            if (ArticleViewer.this.windowView != null) {
                ArticleViewer.this.windowView.postDelayed(ArticleViewer.this.pendingCheckForLongPress, ViewConfiguration.getLongPressTimeout() - ViewConfiguration.getTapTimeout());
            }
        }
    }

    private class WindowView extends FrameLayout {
        private float alpha;
        private int bHeight;
        private int bWidth;
        private int bX;
        private int bY;
        private final Paint blackPaint;
        private float innerTranslationX;
        private boolean maybeStartTracking;
        private boolean movingPage;
        private boolean selfLayout;
        private int startMovingHeaderHeight;
        private boolean startedTracking;
        private int startedTrackingPointerId;
        private int startedTrackingX;
        private int startedTrackingY;
        private VelocityTracker tracker;

        public WindowView(Context context) {
            super(context);
            this.blackPaint = new Paint();
        }

        @Override // android.view.ViewGroup, android.view.View
        @TargetApi(21)
        public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
            DisplayCutout displayCutout;
            List<Rect> boundingRects;
            WindowInsets windowInsets = (WindowInsets) ArticleViewer.this.lastInsets;
            ArticleViewer.this.lastInsets = insets;
            if ((windowInsets == null || !windowInsets.toString().equals(insets.toString())) && ArticleViewer.this.windowView != null) {
                ArticleViewer.this.windowView.requestLayout();
            }
            if (Build.VERSION.SDK_INT >= 28 && ArticleViewer.this.parentActivity != null && (displayCutout = ArticleViewer.this.parentActivity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout()) != null && (boundingRects = displayCutout.getBoundingRects()) != null && !boundingRects.isEmpty()) {
                ArticleViewer.this.hasCutout = boundingRects.get(0).height() != 0;
            }
            return super.dispatchApplyWindowInsets(insets);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            int i = Build.VERSION.SDK_INT;
            if (i >= 21 && ArticleViewer.this.lastInsets != null) {
                setMeasuredDimension(size, size2);
                WindowInsets windowInsets = (WindowInsets) ArticleViewer.this.lastInsets;
                if (AndroidUtilities.incorrectDisplaySizeFix) {
                    int i2 = AndroidUtilities.displaySize.y;
                    if (size2 > i2) {
                        size2 = i2;
                    }
                    size2 += AndroidUtilities.statusBarHeight;
                }
                int systemWindowInsetBottom = size2 - windowInsets.getSystemWindowInsetBottom();
                size -= windowInsets.getSystemWindowInsetRight() + windowInsets.getSystemWindowInsetLeft();
                if (windowInsets.getSystemWindowInsetRight() != 0) {
                    this.bWidth = windowInsets.getSystemWindowInsetRight();
                    this.bHeight = systemWindowInsetBottom;
                } else if (windowInsets.getSystemWindowInsetLeft() != 0) {
                    this.bWidth = windowInsets.getSystemWindowInsetLeft();
                    this.bHeight = systemWindowInsetBottom;
                } else {
                    this.bWidth = size;
                    this.bHeight = windowInsets.getStableInsetBottom();
                }
                size2 = systemWindowInsetBottom - windowInsets.getSystemWindowInsetTop();
            } else {
                setMeasuredDimension(size, size2);
            }
            ArticleViewer.this.menuButton.setAdditionalYOffset(((-(ArticleViewer.this.currentHeaderHeight - AndroidUtilities.dp(56.0f))) / 2) + (i < 21 ? AndroidUtilities.statusBarHeight : 0));
            ArticleViewer.this.keyboardVisible = size2 < AndroidUtilities.displaySize.y - AndroidUtilities.dp(100.0f);
            ArticleViewer.this.containerView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            ArticleViewer.this.fullscreenVideoContainer.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (ArticleViewer.this.pinchToZoomHelper.isInOverlayMode()) {
                ev.offsetLocation(-ArticleViewer.this.containerView.getX(), -ArticleViewer.this.containerView.getY());
                return ArticleViewer.this.pinchToZoomHelper.onTouchEvent(ev);
            }
            TextSelectionHelper<Cell>.TextSelectionOverlay overlayView = ArticleViewer.this.textSelectionHelper.getOverlayView(getContext());
            MotionEvent motionEventObtain = MotionEvent.obtain(ev);
            motionEventObtain.offsetLocation(-ArticleViewer.this.containerView.getX(), -ArticleViewer.this.containerView.getY());
            if (ArticleViewer.this.textSelectionHelper.isSelectionMode() && ArticleViewer.this.textSelectionHelper.getOverlayView(getContext()).onTouchEvent(motionEventObtain)) {
                return true;
            }
            if (overlayView.checkOnTap(ev)) {
                ev.setAction(3);
            }
            if (ev.getAction() == 0 && ArticleViewer.this.textSelectionHelper.isSelectionMode() && (ev.getY() < ArticleViewer.this.containerView.getTop() || ev.getY() > ArticleViewer.this.containerView.getBottom())) {
                if (ArticleViewer.this.textSelectionHelper.getOverlayView(getContext()).onTouchEvent(motionEventObtain)) {
                    return super.dispatchTouchEvent(ev);
                }
                return true;
            }
            return super.dispatchTouchEvent(ev);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            int systemWindowInsetTop;
            if (this.selfLayout) {
                return;
            }
            int i = right - left;
            int i2 = 0;
            if (ArticleViewer.this.anchorsOffsetMeasuredWidth != i) {
                for (int i3 = 0; i3 < ArticleViewer.this.listView.length; i3++) {
                    Iterator it = ArticleViewer.this.adapter[i3].anchorsOffset.entrySet().iterator();
                    while (it.hasNext()) {
                        ((Map.Entry) it.next()).setValue(-1);
                    }
                }
                ArticleViewer.this.anchorsOffsetMeasuredWidth = i;
            }
            if (Build.VERSION.SDK_INT < 21 || ArticleViewer.this.lastInsets == null) {
                systemWindowInsetTop = 0;
            } else {
                WindowInsets windowInsets = (WindowInsets) ArticleViewer.this.lastInsets;
                int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
                if (windowInsets.getSystemWindowInsetRight() != 0) {
                    this.bX = i - this.bWidth;
                    this.bY = 0;
                } else if (windowInsets.getSystemWindowInsetLeft() != 0) {
                    this.bX = 0;
                    this.bY = 0;
                } else {
                    this.bX = 0;
                    this.bY = (bottom - top) - this.bHeight;
                }
                systemWindowInsetTop = 0 + windowInsets.getSystemWindowInsetTop();
                i2 = systemWindowInsetLeft;
            }
            ArticleViewer.this.containerView.layout(i2, systemWindowInsetTop, ArticleViewer.this.containerView.getMeasuredWidth() + i2, ArticleViewer.this.containerView.getMeasuredHeight() + systemWindowInsetTop);
            ArticleViewer.this.fullscreenVideoContainer.layout(i2, systemWindowInsetTop, ArticleViewer.this.fullscreenVideoContainer.getMeasuredWidth() + i2, ArticleViewer.this.fullscreenVideoContainer.getMeasuredHeight() + systemWindowInsetTop);
            if (ArticleViewer.this.runAfterKeyboardClose != null) {
                ArticleViewer.this.runAfterKeyboardClose.start();
                ArticleViewer.this.runAfterKeyboardClose = null;
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            ArticleViewer.this.attachedToWindow = true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            ArticleViewer.this.attachedToWindow = false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            handleTouchEvent(null);
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return !ArticleViewer.this.collapsed && (handleTouchEvent(ev) || super.onInterceptTouchEvent(ev));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return !ArticleViewer.this.collapsed && (handleTouchEvent(event) || super.onTouchEvent(event));
        }

        @Keep
        public void setInnerTranslationX(float value) {
            this.innerTranslationX = value;
            if (ArticleViewer.this.parentActivity instanceof LaunchActivity) {
                ((LaunchActivity) ArticleViewer.this.parentActivity).drawerLayoutContainer.setAllowDrawContent((ArticleViewer.this.isVisible && this.alpha == 1.0f && this.innerTranslationX == 0.0f) ? false : true);
            }
            invalidate();
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            int measuredWidth = getMeasuredWidth();
            int i = (int) this.innerTranslationX;
            int iSave = canvas.save();
            canvas.clipRect(i, 0, measuredWidth, getHeight());
            boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
            canvas.restoreToCount(iSave);
            if (i != 0 && child == ArticleViewer.this.containerView) {
                float f = measuredWidth - i;
                float fMin = Math.min(0.8f, f / measuredWidth);
                if (fMin < 0.0f) {
                    fMin = 0.0f;
                }
                ArticleViewer.this.scrimPaint.setColor(((int) (fMin * 153.0f)) << 24);
                canvas.drawRect(0.0f, 0.0f, i, getHeight(), ArticleViewer.this.scrimPaint);
                float fMax = Math.max(0.0f, Math.min(f / AndroidUtilities.dp(20.0f), 1.0f));
                ArticleViewer.this.layerShadowDrawable.setBounds(i - ArticleViewer.this.layerShadowDrawable.getIntrinsicWidth(), child.getTop(), i, child.getBottom());
                ArticleViewer.this.layerShadowDrawable.setAlpha((int) (fMax * 255.0f));
                ArticleViewer.this.layerShadowDrawable.draw(canvas);
            }
            return zDrawChild;
        }

        @Keep
        public float getInnerTranslationX() {
            return this.innerTranslationX;
        }

        private void prepareForMoving(MotionEvent ev) {
            this.maybeStartTracking = false;
            this.startedTracking = true;
            this.startedTrackingX = (int) ev.getX();
            if (ArticleViewer.this.pagesStack.size() > 1) {
                this.movingPage = true;
                this.startMovingHeaderHeight = ArticleViewer.this.currentHeaderHeight;
                ArticleViewer.this.listView[1].setVisibility(0);
                ArticleViewer.this.listView[1].setAlpha(1.0f);
                ArticleViewer.this.listView[1].setTranslationX(0.0f);
                ArticleViewer.this.listView[0].setBackgroundColor(ArticleViewer.this.backgroundPaint.getColor());
                ArticleViewer articleViewer = ArticleViewer.this;
                articleViewer.updateInterfaceForCurrentPage((TLRPC$WebPage) articleViewer.pagesStack.get(ArticleViewer.this.pagesStack.size() - 2), true, -1);
            } else {
                this.movingPage = false;
            }
            ArticleViewer.this.cancelCheckLongPress();
        }

        public boolean handleTouchEvent(MotionEvent event) {
            if (ArticleViewer.this.pageSwitchAnimation != null || ArticleViewer.this.closeAnimationInProgress || ArticleViewer.this.fullscreenVideoContainer.getVisibility() == 0 || ArticleViewer.this.textSelectionHelper.isSelectionMode()) {
                return false;
            }
            if (event != null && event.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking) {
                this.startedTrackingPointerId = event.getPointerId(0);
                this.maybeStartTracking = true;
                this.startedTrackingX = (int) event.getX();
                this.startedTrackingY = (int) event.getY();
                VelocityTracker velocityTracker = this.tracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            } else if (event != null && event.getAction() == 2 && event.getPointerId(0) == this.startedTrackingPointerId) {
                if (this.tracker == null) {
                    this.tracker = VelocityTracker.obtain();
                }
                int iMax = Math.max(0, (int) (event.getX() - this.startedTrackingX));
                int iAbs = Math.abs(((int) event.getY()) - this.startedTrackingY);
                this.tracker.addMovement(event);
                if (this.maybeStartTracking && !this.startedTracking && iMax >= AndroidUtilities.getPixelsInCM(0.4f, true) && Math.abs(iMax) / 3 > iAbs) {
                    prepareForMoving(event);
                } else if (this.startedTracking) {
                    ArticleViewer.this.pressedLinkOwnerLayout = null;
                    ArticleViewer.this.pressedLinkOwnerView = null;
                    if (this.movingPage) {
                        ArticleViewer.this.listView[0].setTranslationX(iMax);
                    } else {
                        float f = iMax;
                        ArticleViewer.this.containerView.setTranslationX(f);
                        setInnerTranslationX(f);
                    }
                }
            } else if (event != null && event.getPointerId(0) == this.startedTrackingPointerId && (event.getAction() == 3 || event.getAction() == 1 || event.getAction() == 6)) {
                if (this.tracker == null) {
                    this.tracker = VelocityTracker.obtain();
                }
                this.tracker.computeCurrentVelocity(1000);
                float xVelocity = this.tracker.getXVelocity();
                float yVelocity = this.tracker.getYVelocity();
                if (!this.startedTracking && xVelocity >= 3500.0f && xVelocity > Math.abs(yVelocity)) {
                    prepareForMoving(event);
                }
                if (this.startedTracking) {
                    View view = this.movingPage ? ArticleViewer.this.listView[0] : ArticleViewer.this.containerView;
                    float x = view.getX();
                    final boolean z = x < ((float) view.getMeasuredWidth()) / 3.0f && (xVelocity < 3500.0f || xVelocity < yVelocity);
                    AnimatorSet animatorSet = new AnimatorSet();
                    if (!z) {
                        x = view.getMeasuredWidth() - x;
                        if (this.movingPage) {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(ArticleViewer.this.listView[0], (Property<RecyclerListView, Float>) View.TRANSLATION_X, view.getMeasuredWidth()));
                        } else {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(ArticleViewer.this.containerView, (Property<FrameLayout, Float>) View.TRANSLATION_X, view.getMeasuredWidth()), ObjectAnimator.ofFloat(this, ArticleViewer.ARTICLE_VIEWER_INNER_TRANSLATION_X, view.getMeasuredWidth()));
                        }
                    } else if (this.movingPage) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(ArticleViewer.this.listView[0], (Property<RecyclerListView, Float>) View.TRANSLATION_X, 0.0f));
                    } else {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(ArticleViewer.this.containerView, (Property<FrameLayout, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this, ArticleViewer.ARTICLE_VIEWER_INNER_TRANSLATION_X, 0.0f));
                    }
                    animatorSet.setDuration(Math.max((int) ((200.0f / view.getMeasuredWidth()) * x), 50));
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ArticleViewer.WindowView.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (WindowView.this.movingPage) {
                                ArticleViewer.this.listView[0].setBackgroundDrawable(null);
                                if (!z) {
                                    WebpageAdapter webpageAdapter = ArticleViewer.this.adapter[1];
                                    ArticleViewer.this.adapter[1] = ArticleViewer.this.adapter[0];
                                    ArticleViewer.this.adapter[0] = webpageAdapter;
                                    RecyclerListView recyclerListView = ArticleViewer.this.listView[1];
                                    ArticleViewer.this.listView[1] = ArticleViewer.this.listView[0];
                                    ArticleViewer.this.listView[0] = recyclerListView;
                                    LinearLayoutManager linearLayoutManager = ArticleViewer.this.layoutManager[1];
                                    ArticleViewer.this.layoutManager[1] = ArticleViewer.this.layoutManager[0];
                                    ArticleViewer.this.layoutManager[0] = linearLayoutManager;
                                    ArticleViewer.this.pagesStack.remove(ArticleViewer.this.pagesStack.size() - 1);
                                    ArticleViewer articleViewer = ArticleViewer.this;
                                    articleViewer.textSelectionHelper.setParentView(articleViewer.listView[0]);
                                    ArticleViewer articleViewer2 = ArticleViewer.this;
                                    articleViewer2.textSelectionHelper.layoutManager = articleViewer2.layoutManager[0];
                                    ArticleViewer.this.titleTextView.setText(ArticleViewer.this.adapter[0].currentPage.site_name == null ? "" : ArticleViewer.this.adapter[0].currentPage.site_name);
                                    ArticleViewer.this.textSelectionHelper.clear(true);
                                    ArticleViewer.this.headerView.invalidate();
                                }
                                ArticleViewer.this.listView[1].setVisibility(8);
                                ArticleViewer.this.headerView.invalidate();
                            } else if (!z) {
                                ArticleViewer.this.saveCurrentPagePosition();
                                ArticleViewer.this.onClosed();
                            }
                            WindowView.this.movingPage = false;
                            WindowView.this.startedTracking = false;
                            ArticleViewer.this.closeAnimationInProgress = false;
                        }
                    });
                    animatorSet.start();
                    ArticleViewer.this.closeAnimationInProgress = true;
                } else {
                    this.maybeStartTracking = false;
                    this.startedTracking = false;
                    this.movingPage = false;
                }
                VelocityTracker velocityTracker2 = this.tracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.tracker = null;
                }
            } else if (event == null) {
                this.maybeStartTracking = false;
                this.startedTracking = false;
                this.movingPage = false;
                VelocityTracker velocityTracker3 = this.tracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.tracker = null;
                }
                TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper = ArticleViewer.this.textSelectionHelper;
                if (articleTextSelectionHelper != null && !articleTextSelectionHelper.isSelectionMode()) {
                    ArticleViewer.this.textSelectionHelper.clear();
                }
            }
            return this.startedTracking;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int i;
            super.dispatchDraw(canvas);
            if (this.bWidth == 0 || this.bHeight == 0) {
                return;
            }
            this.blackPaint.setAlpha((int) (ArticleViewer.this.windowView.getAlpha() * 255.0f));
            int i2 = this.bX;
            if (i2 == 0 && (i = this.bY) == 0) {
                canvas.drawRect(i2, i, i2 + this.bWidth, i + this.bHeight, this.blackPaint);
            } else {
                canvas.drawRect(i2 - getTranslationX(), this.bY, (this.bX + this.bWidth) - getTranslationX(), this.bY + this.bHeight, this.blackPaint);
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float measuredWidth = getMeasuredWidth();
            float measuredHeight = getMeasuredHeight();
            canvas.drawRect(this.innerTranslationX, 0.0f, measuredWidth, measuredHeight, ArticleViewer.this.backgroundPaint);
            if (Build.VERSION.SDK_INT < 21 || ArticleViewer.this.lastInsets == null) {
                return;
            }
            WindowInsets windowInsets = (WindowInsets) ArticleViewer.this.lastInsets;
            canvas.drawRect(this.innerTranslationX, 0.0f, measuredWidth, windowInsets.getSystemWindowInsetTop(), ArticleViewer.this.statusBarPaint);
            if (ArticleViewer.this.hasCutout) {
                int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
                if (systemWindowInsetLeft != 0) {
                    canvas.drawRect(0.0f, 0.0f, systemWindowInsetLeft, measuredHeight, ArticleViewer.this.statusBarPaint);
                }
                if (windowInsets.getSystemWindowInsetRight() != 0) {
                    canvas.drawRect(getMeasuredWidth() - r0, 0.0f, getMeasuredWidth(), measuredHeight, ArticleViewer.this.statusBarPaint);
                }
            }
        }

        @Override // android.view.View
        @Keep
        public void setAlpha(float value) {
            int i = (int) (255.0f * value);
            ArticleViewer.this.backgroundPaint.setAlpha(i);
            ArticleViewer.this.statusBarPaint.setAlpha(i);
            this.alpha = value;
            if (ArticleViewer.this.parentActivity instanceof LaunchActivity) {
                ((LaunchActivity) ArticleViewer.this.parentActivity).drawerLayoutContainer.setAllowDrawContent((ArticleViewer.this.isVisible && this.alpha == 1.0f && this.innerTranslationX == 0.0f) ? false : true);
            }
            invalidate();
        }

        @Override // android.view.View
        @Keep
        public float getAlpha() {
            return this.alpha;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEventPreIme(KeyEvent event) {
            if (event != null && event.getKeyCode() == 4 && event.getAction() == 1) {
                if (ArticleViewer.this.searchField.isFocused()) {
                    ArticleViewer.this.searchField.clearFocus();
                    AndroidUtilities.hideKeyboard(ArticleViewer.this.searchField);
                } else {
                    ArticleViewer.this.close(true, false);
                }
                return true;
            }
            return super.dispatchKeyEventPreIme(event);
        }
    }

    class CheckForLongPress implements Runnable {
        public int currentPressCount;

        CheckForLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArticleViewer articleViewer;
            TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper;
            if (!ArticleViewer.this.checkingForLongPress || ArticleViewer.this.windowView == null) {
                return;
            }
            ArticleViewer.this.checkingForLongPress = false;
            if (ArticleViewer.this.pressedLink != null) {
                ArticleViewer.this.windowView.performHapticFeedback(0);
                ArticleViewer articleViewer2 = ArticleViewer.this;
                articleViewer2.showCopyPopup(articleViewer2.pressedLink.getUrl());
                ArticleViewer.this.pressedLink = null;
                ArticleViewer.this.pressedLinkOwnerLayout = null;
                if (ArticleViewer.this.pressedLinkOwnerView != null) {
                    ArticleViewer.this.pressedLinkOwnerView.invalidate();
                    return;
                }
                return;
            }
            if (ArticleViewer.this.pressedLinkOwnerView != null) {
                ArticleViewer articleViewer3 = ArticleViewer.this;
                if (articleViewer3.textSelectionHelper.isSelectable(articleViewer3.pressedLinkOwnerView)) {
                    if (ArticleViewer.this.pressedLinkOwnerView.getTag() != null && ArticleViewer.this.pressedLinkOwnerView.getTag() == "bottomSheet" && (articleTextSelectionHelper = (articleViewer = ArticleViewer.this).textSelectionHelperBottomSheet) != null) {
                        articleTextSelectionHelper.trySelect(articleViewer.pressedLinkOwnerView);
                    } else {
                        ArticleViewer articleViewer4 = ArticleViewer.this;
                        articleViewer4.textSelectionHelper.trySelect(articleViewer4.pressedLinkOwnerView);
                    }
                    if (ArticleViewer.this.textSelectionHelper.isSelectionMode()) {
                        ArticleViewer.this.windowView.performHapticFeedback(0);
                        return;
                    }
                    return;
                }
            }
            if (ArticleViewer.this.pressedLinkOwnerLayout == null || ArticleViewer.this.pressedLinkOwnerView == null) {
                return;
            }
            ArticleViewer.this.windowView.performHapticFeedback(0);
            int[] iArr = new int[2];
            ArticleViewer.this.pressedLinkOwnerView.getLocationInWindow(iArr);
            int iDp = (iArr[1] + ArticleViewer.this.pressedLayoutY) - AndroidUtilities.dp(54.0f);
            if (iDp < 0) {
                iDp = 0;
            }
            ArticleViewer.this.pressedLinkOwnerView.invalidate();
            ArticleViewer.this.drawBlockSelection = true;
            ArticleViewer articleViewer5 = ArticleViewer.this;
            articleViewer5.showPopup(articleViewer5.pressedLinkOwnerView, 48, 0, iDp);
            ArticleViewer.this.listView[0].setLayoutFrozen(true);
            ArticleViewer.this.listView[0].setLayoutFrozen(false);
        }
    }

    private void createPaint(boolean update) {
        if (quoteLinePaint == null) {
            quoteLinePaint = new Paint();
            preformattedBackgroundPaint = new Paint();
            Paint paint = new Paint(1);
            tableLinePaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            tableLinePaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
            Paint paint2 = new Paint();
            tableHalfLinePaint = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            tableHalfLinePaint.setStrokeWidth(AndroidUtilities.dp(1.0f) / 2.0f);
            tableHeaderPaint = new Paint();
            tableStripPaint = new Paint();
            urlPaint = new Paint();
            webpageUrlPaint = new Paint(1);
            webpageSearchPaint = new Paint(1);
            photoBackgroundPaint = new Paint();
            dividerPaint = new Paint();
            webpageMarkPaint = new Paint(1);
        } else if (!update) {
            return;
        }
        int color = Theme.getColor("windowBackgroundWhite");
        webpageSearchPaint.setColor((((((float) Color.red(color)) * 0.2126f) + (((float) Color.green(color)) * 0.7152f)) + (((float) Color.blue(color)) * 0.0722f)) / 255.0f <= 0.705f ? -3041234 : -6551);
        webpageUrlPaint.setColor(Theme.getColor("windowBackgroundWhiteLinkSelection") & 872415231);
        urlPaint.setColor(Theme.getColor("windowBackgroundWhiteLinkSelection") & 872415231);
        tableHalfLinePaint.setColor(Theme.getColor("windowBackgroundWhiteInputField"));
        tableLinePaint.setColor(Theme.getColor("windowBackgroundWhiteInputField"));
        photoBackgroundPaint.setColor(251658240);
        dividerPaint.setColor(Theme.getColor("divider"));
        webpageMarkPaint.setColor(Theme.getColor("windowBackgroundWhiteLinkSelection") & 872415231);
        int color2 = Theme.getColor("switchTrack");
        int iRed = Color.red(color2);
        int iGreen = Color.green(color2);
        int iBlue = Color.blue(color2);
        tableStripPaint.setColor(Color.argb(20, iRed, iGreen, iBlue));
        tableHeaderPaint.setColor(Color.argb(34, iRed, iGreen, iBlue));
        int color3 = Theme.getColor("windowBackgroundWhiteLinkSelection");
        preformattedBackgroundPaint.setColor(Color.argb(20, Color.red(color3), Color.green(color3), Color.blue(color3)));
        quoteLinePaint.setColor(Theme.getColor("chat_inReplyLine"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCopyPopup(final String urlFinal) {
        if (this.parentActivity == null) {
            return;
        }
        BottomSheet bottomSheet = this.linkSheet;
        if (bottomSheet != null) {
            bottomSheet.dismiss();
            this.linkSheet = null;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(this.parentActivity);
        builder.setTitle(urlFinal);
        builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$nsIHbpTnTsIJwjnvuVb333yuJaE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) throws NoSuchFieldException, Resources.NotFoundException, UnsupportedEncodingException {
                this.f$0.lambda$showCopyPopup$0$ArticleViewer(urlFinal, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showCopyPopup$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showCopyPopup$0$ArticleViewer(String str, DialogInterface dialogInterface, int i) throws NoSuchFieldException, Resources.NotFoundException, UnsupportedEncodingException {
        String strDecode;
        if (this.parentActivity == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                if (str.startsWith("mailto:")) {
                    str = str.substring(7);
                } else if (str.startsWith("tel:")) {
                    str = str.substring(4);
                }
                AndroidUtilities.addToClipboard(str);
                return;
            }
            return;
        }
        int iLastIndexOf = str.lastIndexOf(35);
        if (iLastIndexOf != -1) {
            String lowerCase = !TextUtils.isEmpty(this.adapter[0].currentPage.cached_page.url) ? this.adapter[0].currentPage.cached_page.url.toLowerCase() : this.adapter[0].currentPage.url.toLowerCase();
            try {
                strDecode = URLDecoder.decode(str.substring(iLastIndexOf + 1), "UTF-8");
            } catch (Exception unused) {
                strDecode = "";
            }
            if (str.toLowerCase().contains(lowerCase)) {
                if (TextUtils.isEmpty(strDecode)) {
                    this.layoutManager[0].scrollToPositionWithOffset(0, 0);
                    checkScrollAnimated();
                    return;
                } else {
                    scrollToAnchor(strDecode);
                    return;
                }
            }
        }
        Browser.openUrl(this.parentActivity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopup(View parent, int gravity, int x, int y) {
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.popupWindow.dismiss();
            return;
        }
        if (this.popupLayout == null) {
            this.popupRect = new Rect();
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(this.parentActivity);
            this.popupLayout = actionBarPopupWindowLayout;
            actionBarPopupWindowLayout.setPadding(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f));
            this.popupLayout.setBackgroundDrawable(this.parentActivity.getResources().getDrawable(R.drawable.menu_copy));
            this.popupLayout.setAnimationEnabled(false);
            this.popupLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$HIZ1ZKJSZDgey8RTfmQvgUjs_7Q
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.lambda$showPopup$1$ArticleViewer(view, motionEvent);
                }
            });
            this.popupLayout.setDispatchKeyEventListener(new ActionBarPopupWindow.OnDispatchKeyEventListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$ZHgSt86yS5LA6AxR0NxYCPRnU6c
                @Override // ir.eitaa.ui.ActionBar.ActionBarPopupWindow.OnDispatchKeyEventListener
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.f$0.lambda$showPopup$2$ArticleViewer(keyEvent);
                }
            });
            this.popupLayout.setShownFromBotton(false);
            TextView textView = new TextView(this.parentActivity);
            this.deleteView = textView;
            textView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("listSelectorSDK21"), 2));
            this.deleteView.setGravity(16);
            this.deleteView.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
            this.deleteView.setTextSize(1, 15.0f);
            this.deleteView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.deleteView.setText(LocaleController.getString("Copy", R.string.Copy).toUpperCase());
            this.deleteView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$sfsv2g_BB-Z0qlKVcZcSoS64ojg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$showPopup$3$ArticleViewer(view);
                }
            });
            this.popupLayout.addView(this.deleteView, LayoutHelper.createFrame(-2, 48.0f));
            ActionBarPopupWindow actionBarPopupWindow2 = new ActionBarPopupWindow(this.popupLayout, -2, -2);
            this.popupWindow = actionBarPopupWindow2;
            actionBarPopupWindow2.setAnimationEnabled(false);
            this.popupWindow.setAnimationStyle(R.style.PopupContextAnimation);
            this.popupWindow.setOutsideTouchable(true);
            this.popupWindow.setClippingEnabled(true);
            this.popupWindow.setInputMethodMode(2);
            this.popupWindow.setSoftInputMode(0);
            this.popupWindow.getContentView().setFocusableInTouchMode(true);
            this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$4TY6zqcFofoLSmGxq4d573gneEk
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    this.f$0.lambda$showPopup$4$ArticleViewer();
                }
            });
        }
        this.deleteView.setTextColor(Theme.getColor("actionBarDefaultSubmenuItem"));
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout2 = this.popupLayout;
        if (actionBarPopupWindowLayout2 != null) {
            actionBarPopupWindowLayout2.setBackgroundColor(Theme.getColor("actionBarDefaultSubmenuBackground"));
        }
        this.popupLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
        this.popupWindow.setFocusable(true);
        this.popupWindow.showAtLocation(parent, gravity, x, y);
        this.popupWindow.startAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$showPopup$1$ArticleViewer(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.popupWindow) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.popupRect);
        if (this.popupRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.popupWindow.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPopup$2$ArticleViewer(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.popupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPopup$3$ArticleViewer(View view) {
        DrawingText drawingText = this.pressedLinkOwnerLayout;
        if (drawingText != null) {
            AndroidUtilities.addToClipboard(drawingText.getText());
            Toast.makeText(this.parentActivity, LocaleController.getString("TextCopied", R.string.TextCopied), 0).show();
        }
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPopup$4$ArticleViewer() {
        View view = this.pressedLinkOwnerView;
        if (view != null) {
            this.pressedLinkOwnerLayout = null;
            view.invalidate();
            this.pressedLinkOwnerView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TLRPC$RichText getBlockCaption(TLRPC$PageBlock block, int type) {
        if (type == 2) {
            TLRPC$RichText blockCaption = getBlockCaption(block, 0);
            if (blockCaption instanceof TLRPC$TL_textEmpty) {
                blockCaption = null;
            }
            TLRPC$RichText blockCaption2 = getBlockCaption(block, 1);
            if (blockCaption2 instanceof TLRPC$TL_textEmpty) {
                blockCaption2 = null;
            }
            if (blockCaption != null && blockCaption2 == null) {
                return blockCaption;
            }
            if (blockCaption == null && blockCaption2 != null) {
                return blockCaption2;
            }
            if (blockCaption == null || blockCaption2 == null) {
                return null;
            }
            TLRPC$TL_textPlain tLRPC$TL_textPlain = new TLRPC$TL_textPlain();
            tLRPC$TL_textPlain.text = " ";
            TLRPC$TL_textConcat tLRPC$TL_textConcat = new TLRPC$TL_textConcat();
            tLRPC$TL_textConcat.texts.add(blockCaption);
            tLRPC$TL_textConcat.texts.add(tLRPC$TL_textPlain);
            tLRPC$TL_textConcat.texts.add(blockCaption2);
            return tLRPC$TL_textConcat;
        }
        if (block instanceof TLRPC$TL_pageBlockEmbedPost) {
            TLRPC$TL_pageBlockEmbedPost tLRPC$TL_pageBlockEmbedPost = (TLRPC$TL_pageBlockEmbedPost) block;
            if (type == 0) {
                return tLRPC$TL_pageBlockEmbedPost.caption.text;
            }
            if (type == 1) {
                return tLRPC$TL_pageBlockEmbedPost.caption.credit;
            }
        } else if (block instanceof TLRPC$TL_pageBlockSlideshow) {
            TLRPC$TL_pageBlockSlideshow tLRPC$TL_pageBlockSlideshow = (TLRPC$TL_pageBlockSlideshow) block;
            if (type == 0) {
                return tLRPC$TL_pageBlockSlideshow.caption.text;
            }
            if (type == 1) {
                return tLRPC$TL_pageBlockSlideshow.caption.credit;
            }
        } else if (block instanceof TLRPC$TL_pageBlockPhoto) {
            TLRPC$TL_pageBlockPhoto tLRPC$TL_pageBlockPhoto = (TLRPC$TL_pageBlockPhoto) block;
            if (type == 0) {
                return tLRPC$TL_pageBlockPhoto.caption.text;
            }
            if (type == 1) {
                return tLRPC$TL_pageBlockPhoto.caption.credit;
            }
        } else if (block instanceof TLRPC$TL_pageBlockCollage) {
            TLRPC$TL_pageBlockCollage tLRPC$TL_pageBlockCollage = (TLRPC$TL_pageBlockCollage) block;
            if (type == 0) {
                return tLRPC$TL_pageBlockCollage.caption.text;
            }
            if (type == 1) {
                return tLRPC$TL_pageBlockCollage.caption.credit;
            }
        } else if (block instanceof TLRPC$TL_pageBlockEmbed) {
            TLRPC$TL_pageBlockEmbed tLRPC$TL_pageBlockEmbed = (TLRPC$TL_pageBlockEmbed) block;
            if (type == 0) {
                return tLRPC$TL_pageBlockEmbed.caption.text;
            }
            if (type == 1) {
                return tLRPC$TL_pageBlockEmbed.caption.credit;
            }
        } else {
            if (block instanceof TLRPC$TL_pageBlockBlockquote) {
                return ((TLRPC$TL_pageBlockBlockquote) block).caption;
            }
            if (block instanceof TLRPC$TL_pageBlockVideo) {
                TLRPC$TL_pageBlockVideo tLRPC$TL_pageBlockVideo = (TLRPC$TL_pageBlockVideo) block;
                if (type == 0) {
                    return tLRPC$TL_pageBlockVideo.caption.text;
                }
                if (type == 1) {
                    return tLRPC$TL_pageBlockVideo.caption.credit;
                }
            } else {
                if (block instanceof TLRPC$TL_pageBlockPullquote) {
                    return ((TLRPC$TL_pageBlockPullquote) block).caption;
                }
                if (block instanceof TLRPC$TL_pageBlockAudio) {
                    TLRPC$TL_pageBlockAudio tLRPC$TL_pageBlockAudio = (TLRPC$TL_pageBlockAudio) block;
                    if (type == 0) {
                        return tLRPC$TL_pageBlockAudio.caption.text;
                    }
                    if (type == 1) {
                        return tLRPC$TL_pageBlockAudio.caption.credit;
                    }
                } else {
                    if (block instanceof TLRPC$TL_pageBlockCover) {
                        return getBlockCaption(((TLRPC$TL_pageBlockCover) block).cover, type);
                    }
                    if (block instanceof TLRPC$TL_pageBlockMap) {
                        TLRPC$TL_pageBlockMap tLRPC$TL_pageBlockMap = (TLRPC$TL_pageBlockMap) block;
                        if (type == 0) {
                            return tLRPC$TL_pageBlockMap.caption.text;
                        }
                        if (type == 1) {
                            return tLRPC$TL_pageBlockMap.caption.credit;
                        }
                    }
                }
            }
        }
        return null;
    }

    private View getLastNonListCell(View view) {
        if (view instanceof BlockListItemCell) {
            BlockListItemCell blockListItemCell = (BlockListItemCell) view;
            return blockListItemCell.blockLayout != null ? getLastNonListCell(blockListItemCell.blockLayout.itemView) : view;
        }
        if (!(view instanceof BlockOrderedListItemCell)) {
            return view;
        }
        BlockOrderedListItemCell blockOrderedListItemCell = (BlockOrderedListItemCell) view;
        return blockOrderedListItemCell.blockLayout != null ? getLastNonListCell(blockOrderedListItemCell.blockLayout.itemView) : view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isListItemBlock(TLRPC$PageBlock block) {
        return (block instanceof TL_pageBlockListItem) || (block instanceof TL_pageBlockOrderedListItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TLRPC$PageBlock getLastNonListPageBlock(TLRPC$PageBlock block) {
        if (block instanceof TL_pageBlockListItem) {
            TL_pageBlockListItem tL_pageBlockListItem = (TL_pageBlockListItem) block;
            return tL_pageBlockListItem.blockItem != null ? getLastNonListPageBlock(tL_pageBlockListItem.blockItem) : tL_pageBlockListItem.blockItem;
        }
        if (!(block instanceof TL_pageBlockOrderedListItem)) {
            return block;
        }
        TL_pageBlockOrderedListItem tL_pageBlockOrderedListItem = (TL_pageBlockOrderedListItem) block;
        return tL_pageBlockOrderedListItem.blockItem != null ? getLastNonListPageBlock(tL_pageBlockOrderedListItem.blockItem) : tL_pageBlockOrderedListItem.blockItem;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean openAllParentBlocks(ir.eitaa.ui.ArticleViewer.TL_pageBlockDetailsChild r5) {
        /*
            r4 = this;
            ir.eitaa.tgnet.TLRPC$PageBlock r5 = ir.eitaa.ui.ArticleViewer.TL_pageBlockDetailsChild.access$6300(r5)
            ir.eitaa.tgnet.TLRPC$PageBlock r5 = r4.getLastNonListPageBlock(r5)
            boolean r0 = r5 instanceof ir.eitaa.tgnet.TLRPC$TL_pageBlockDetails
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            ir.eitaa.tgnet.TLRPC$TL_pageBlockDetails r5 = (ir.eitaa.tgnet.TLRPC$TL_pageBlockDetails) r5
            boolean r0 = r5.open
            if (r0 != 0) goto L17
            r5.open = r2
            return r2
        L17:
            return r1
        L18:
            boolean r0 = r5 instanceof ir.eitaa.ui.ArticleViewer.TL_pageBlockDetailsChild
            if (r0 == 0) goto L3e
            ir.eitaa.ui.ArticleViewer$TL_pageBlockDetailsChild r5 = (ir.eitaa.ui.ArticleViewer.TL_pageBlockDetailsChild) r5
            ir.eitaa.tgnet.TLRPC$PageBlock r0 = ir.eitaa.ui.ArticleViewer.TL_pageBlockDetailsChild.access$6400(r5)
            ir.eitaa.tgnet.TLRPC$PageBlock r0 = r4.getLastNonListPageBlock(r0)
            boolean r3 = r0 instanceof ir.eitaa.tgnet.TLRPC$TL_pageBlockDetails
            if (r3 == 0) goto L34
            ir.eitaa.tgnet.TLRPC$TL_pageBlockDetails r0 = (ir.eitaa.tgnet.TLRPC$TL_pageBlockDetails) r0
            boolean r3 = r0.open
            if (r3 != 0) goto L34
            r0.open = r2
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            boolean r5 = r4.openAllParentBlocks(r5)
            if (r5 != 0) goto L3d
            if (r0 == 0) goto L3e
        L3d:
            r1 = 1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.openAllParentBlocks(ir.eitaa.ui.ArticleViewer$TL_pageBlockDetailsChild):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TLRPC$PageBlock fixListBlock(TLRPC$PageBlock parentBlock, TLRPC$PageBlock childBlock) {
        if (parentBlock instanceof TL_pageBlockListItem) {
            ((TL_pageBlockListItem) parentBlock).blockItem = childBlock;
            return parentBlock;
        }
        if (!(parentBlock instanceof TL_pageBlockOrderedListItem)) {
            return childBlock;
        }
        ((TL_pageBlockOrderedListItem) parentBlock).blockItem = childBlock;
        return parentBlock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TLRPC$PageBlock wrapInTableBlock(TLRPC$PageBlock parentBlock, TLRPC$PageBlock childBlock) {
        if (parentBlock instanceof TL_pageBlockListItem) {
            TL_pageBlockListItem tL_pageBlockListItem = (TL_pageBlockListItem) parentBlock;
            TL_pageBlockListItem tL_pageBlockListItem2 = new TL_pageBlockListItem();
            tL_pageBlockListItem2.parent = tL_pageBlockListItem.parent;
            tL_pageBlockListItem2.blockItem = wrapInTableBlock(tL_pageBlockListItem.blockItem, childBlock);
            return tL_pageBlockListItem2;
        }
        if (!(parentBlock instanceof TL_pageBlockOrderedListItem)) {
            return childBlock;
        }
        TL_pageBlockOrderedListItem tL_pageBlockOrderedListItem = (TL_pageBlockOrderedListItem) parentBlock;
        TL_pageBlockOrderedListItem tL_pageBlockOrderedListItem2 = new TL_pageBlockOrderedListItem();
        tL_pageBlockOrderedListItem2.parent = tL_pageBlockOrderedListItem.parent;
        tL_pageBlockOrderedListItem2.blockItem = wrapInTableBlock(tL_pageBlockOrderedListItem.blockItem, childBlock);
        return tL_pageBlockOrderedListItem2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterfaceForCurrentPage(TLRPC$WebPage tLRPC$WebPage, boolean z, int i) {
        TLRPC$WebPage tLRPC$WebPage2;
        int iDp;
        if (tLRPC$WebPage == null || tLRPC$WebPage.cached_page == null) {
            return;
        }
        if (!z && i != 0) {
            WebpageAdapter[] webpageAdapterArr = this.adapter;
            WebpageAdapter webpageAdapter = webpageAdapterArr[1];
            webpageAdapterArr[1] = webpageAdapterArr[0];
            webpageAdapterArr[0] = webpageAdapter;
            RecyclerListView[] recyclerListViewArr = this.listView;
            RecyclerListView recyclerListView = recyclerListViewArr[1];
            recyclerListViewArr[1] = recyclerListViewArr[0];
            recyclerListViewArr[0] = recyclerListView;
            LinearLayoutManager[] linearLayoutManagerArr = this.layoutManager;
            LinearLayoutManager linearLayoutManager = linearLayoutManagerArr[1];
            linearLayoutManagerArr[1] = linearLayoutManagerArr[0];
            linearLayoutManagerArr[0] = linearLayoutManager;
            int iIndexOfChild = this.containerView.indexOfChild(recyclerListViewArr[0]);
            int iIndexOfChild2 = this.containerView.indexOfChild(this.listView[1]);
            if (i == 1) {
                if (iIndexOfChild < iIndexOfChild2) {
                    this.containerView.removeView(this.listView[0]);
                    this.containerView.addView(this.listView[0], iIndexOfChild2);
                }
            } else if (iIndexOfChild2 < iIndexOfChild) {
                this.containerView.removeView(this.listView[0]);
                this.containerView.addView(this.listView[0], iIndexOfChild);
            }
            this.pageSwitchAnimation = new AnimatorSet();
            this.listView[0].setVisibility(0);
            final int i2 = i == 1 ? 0 : 1;
            this.listView[i2].setBackgroundColor(this.backgroundPaint.getColor());
            if (Build.VERSION.SDK_INT >= 18) {
                this.listView[i2].setLayerType(2, null);
            }
            if (i == 1) {
                this.pageSwitchAnimation.playTogether(ObjectAnimator.ofFloat(this.listView[0], (Property<RecyclerListView, Float>) View.TRANSLATION_X, AndroidUtilities.dp(56.0f), 0.0f), ObjectAnimator.ofFloat(this.listView[0], (Property<RecyclerListView, Float>) View.ALPHA, 0.0f, 1.0f));
            } else if (i == -1) {
                this.listView[0].setAlpha(1.0f);
                this.listView[0].setTranslationX(0.0f);
                this.pageSwitchAnimation.playTogether(ObjectAnimator.ofFloat(this.listView[1], (Property<RecyclerListView, Float>) View.TRANSLATION_X, 0.0f, AndroidUtilities.dp(56.0f)), ObjectAnimator.ofFloat(this.listView[1], (Property<RecyclerListView, Float>) View.ALPHA, 1.0f, 0.0f));
            }
            this.pageSwitchAnimation.setDuration(150L);
            this.pageSwitchAnimation.setInterpolator(this.interpolator);
            this.pageSwitchAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ArticleViewer.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ArticleViewer.this.listView[1].setVisibility(8);
                    ArticleViewer articleViewer = ArticleViewer.this;
                    articleViewer.textSelectionHelper.setParentView(articleViewer.listView[0]);
                    ArticleViewer articleViewer2 = ArticleViewer.this;
                    articleViewer2.textSelectionHelper.layoutManager = articleViewer2.layoutManager[0];
                    ArticleViewer.this.listView[i2].setBackgroundDrawable(null);
                    if (Build.VERSION.SDK_INT >= 18) {
                        ArticleViewer.this.listView[i2].setLayerType(0, null);
                    }
                    ArticleViewer.this.pageSwitchAnimation = null;
                }
            });
            this.pageSwitchAnimation.start();
        }
        if (!z) {
            SimpleTextView simpleTextView = this.titleTextView;
            String str = tLRPC$WebPage.site_name;
            if (str == null) {
                str = "";
            }
            simpleTextView.setText(str);
            this.textSelectionHelper.clear(true);
            this.headerView.invalidate();
        }
        if (z) {
            ArrayList<TLRPC$WebPage> arrayList = this.pagesStack;
            tLRPC$WebPage2 = arrayList.get(arrayList.size() - 2);
        } else {
            tLRPC$WebPage2 = tLRPC$WebPage;
        }
        this.adapter[z ? 1 : 0].isRtl = tLRPC$WebPage.cached_page.rtl;
        this.adapter[z ? 1 : 0].cleanup();
        this.adapter[z ? 1 : 0].currentPage = tLRPC$WebPage2;
        int size = tLRPC$WebPage2.cached_page.blocks.size();
        int i3 = 0;
        while (i3 < size) {
            TLRPC$PageBlock tLRPC$PageBlock = tLRPC$WebPage2.cached_page.blocks.get(i3);
            if (i3 == 0) {
                tLRPC$PageBlock.first = true;
                if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockCover) {
                    TLRPC$TL_pageBlockCover tLRPC$TL_pageBlockCover = (TLRPC$TL_pageBlockCover) tLRPC$PageBlock;
                    TLRPC$RichText blockCaption = getBlockCaption(tLRPC$TL_pageBlockCover, 0);
                    TLRPC$RichText blockCaption2 = getBlockCaption(tLRPC$TL_pageBlockCover, 1);
                    if (((blockCaption != null && !(blockCaption instanceof TLRPC$TL_textEmpty)) || (blockCaption2 != null && !(blockCaption2 instanceof TLRPC$TL_textEmpty))) && size > 1) {
                        TLRPC$PageBlock tLRPC$PageBlock2 = tLRPC$WebPage2.cached_page.blocks.get(1);
                        if (tLRPC$PageBlock2 instanceof TLRPC$TL_pageBlockChannel) {
                            this.adapter[z ? 1 : 0].channelBlock = (TLRPC$TL_pageBlockChannel) tLRPC$PageBlock2;
                        }
                    }
                }
            } else {
                if (i3 != 1 || this.adapter[z ? 1 : 0].channelBlock == null) {
                }
                i3++;
            }
            WebpageAdapter[] webpageAdapterArr2 = this.adapter;
            webpageAdapterArr2[z ? 1 : 0].addBlock(webpageAdapterArr2[z ? 1 : 0], tLRPC$PageBlock, 0, 0, i3 == size + (-1) ? i3 : 0);
            i3++;
        }
        this.adapter[z ? 1 : 0].notifyDataSetChanged();
        if (this.pagesStack.size() == 1 || i == -1) {
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("articles", 0);
            String str2 = "article" + tLRPC$WebPage2.id;
            int i4 = sharedPreferences.getInt(str2, -1);
            boolean z2 = sharedPreferences.getBoolean(str2 + "r", true);
            Point point = AndroidUtilities.displaySize;
            if (z2 == (point.x > point.y)) {
                iDp = sharedPreferences.getInt(str2 + "o", 0) - this.listView[z ? 1 : 0].getPaddingTop();
            } else {
                iDp = AndroidUtilities.dp(10.0f);
            }
            if (i4 != -1) {
                this.layoutManager[z ? 1 : 0].scrollToPositionWithOffset(i4, iDp);
            }
        } else {
            this.layoutManager[z ? 1 : 0].scrollToPositionWithOffset(0, 0);
        }
        if (z) {
            return;
        }
        checkScrollAnimated();
    }

    private boolean addPageToStack(TLRPC$WebPage webPage, String anchor, int order) throws NoSuchFieldException, Resources.NotFoundException {
        saveCurrentPagePosition();
        this.pagesStack.add(webPage);
        showSearch(false);
        updateInterfaceForCurrentPage(webPage, false, order);
        return scrollToAnchor(anchor);
    }

    private boolean scrollToAnchor(String anchor) throws NoSuchFieldException, Resources.NotFoundException {
        Integer num = 0;
        if (TextUtils.isEmpty(anchor)) {
            return false;
        }
        String lowerCase = anchor.toLowerCase();
        Integer numValueOf = (Integer) this.adapter[0].anchors.get(lowerCase);
        if (numValueOf != null) {
            TLRPC$TL_textAnchor tLRPC$TL_textAnchor = (TLRPC$TL_textAnchor) this.adapter[0].anchorsParent.get(lowerCase);
            if (tLRPC$TL_textAnchor != null) {
                TLRPC$TL_pageBlockParagraph tLRPC$TL_pageBlockParagraph = new TLRPC$TL_pageBlockParagraph();
                tLRPC$TL_pageBlockParagraph.text = tLRPC$TL_textAnchor.text;
                int typeForBlock = this.adapter[0].getTypeForBlock(tLRPC$TL_pageBlockParagraph);
                RecyclerView.ViewHolder viewHolderOnCreateViewHolder = this.adapter[0].onCreateViewHolder(null, typeForBlock);
                this.adapter[0].bindBlockToHolder(typeForBlock, viewHolderOnCreateViewHolder, tLRPC$TL_pageBlockParagraph, 0, 0);
                BottomSheet.Builder builder = new BottomSheet.Builder(this.parentActivity);
                builder.setApplyTopPadding(false);
                builder.setApplyBottomPadding(false);
                final LinearLayout linearLayout = new LinearLayout(this.parentActivity);
                linearLayout.setOrientation(1);
                TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper = new TextSelectionHelper.ArticleTextSelectionHelper();
                this.textSelectionHelperBottomSheet = articleTextSelectionHelper;
                articleTextSelectionHelper.setParentView(linearLayout);
                this.textSelectionHelperBottomSheet.setCallback(new TextSelectionHelper.Callback() { // from class: ir.eitaa.ui.ArticleViewer.3
                    @Override // ir.eitaa.ui.Cells.TextSelectionHelper.Callback
                    public void onStateChanged(boolean isSelected) {
                        if (ArticleViewer.this.linkSheet != null) {
                            ArticleViewer.this.linkSheet.setDisableScroll(isSelected);
                        }
                    }
                });
                TextView textView = new TextView(this.parentActivity) { // from class: ir.eitaa.ui.ArticleViewer.4
                    @Override // android.widget.TextView, android.view.View
                    protected void onDraw(Canvas canvas) {
                        canvas.drawLine(0.0f, getMeasuredHeight() - 1, getMeasuredWidth(), getMeasuredHeight() - 1, ArticleViewer.dividerPaint);
                        super.onDraw(canvas);
                    }
                };
                textView.setTextSize(1, 16.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(true));
                textView.setText(LocaleController.getString("InstantViewReference", R.string.InstantViewReference));
                textView.setGravity((this.adapter[0].isRtl ? 5 : 3) | 16);
                textView.setTextColor(getTextColor());
                textView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, AndroidUtilities.dp(48.0f) + 1));
                viewHolderOnCreateViewHolder.itemView.setTag("bottomSheet");
                linearLayout.addView(viewHolderOnCreateViewHolder.itemView, LayoutHelper.createLinear(-1, -2, 0.0f, 7.0f, 0.0f, 0.0f));
                TextSelectionHelper<Cell>.TextSelectionOverlay overlayView = this.textSelectionHelperBottomSheet.getOverlayView(this.parentActivity);
                FrameLayout frameLayout = new FrameLayout(this.parentActivity) { // from class: ir.eitaa.ui.ArticleViewer.5
                    @Override // android.view.ViewGroup, android.view.View
                    public boolean dispatchTouchEvent(MotionEvent ev) {
                        TextSelectionHelper<Cell>.TextSelectionOverlay overlayView2 = ArticleViewer.this.textSelectionHelperBottomSheet.getOverlayView(getContext());
                        MotionEvent motionEventObtain = MotionEvent.obtain(ev);
                        motionEventObtain.offsetLocation(-linearLayout.getX(), -linearLayout.getY());
                        if (ArticleViewer.this.textSelectionHelperBottomSheet.isSelectionMode() && ArticleViewer.this.textSelectionHelperBottomSheet.getOverlayView(getContext()).onTouchEvent(motionEventObtain)) {
                            return true;
                        }
                        if (overlayView2.checkOnTap(ev)) {
                            ev.setAction(3);
                        }
                        if (ev.getAction() == 0 && ArticleViewer.this.textSelectionHelperBottomSheet.isSelectionMode() && (ev.getY() < linearLayout.getTop() || ev.getY() > linearLayout.getBottom())) {
                            if (ArticleViewer.this.textSelectionHelperBottomSheet.getOverlayView(getContext()).onTouchEvent(motionEventObtain)) {
                                return super.dispatchTouchEvent(ev);
                            }
                            return true;
                        }
                        return super.dispatchTouchEvent(ev);
                    }

                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(linearLayout.getMeasuredHeight() + AndroidUtilities.dp(8.0f), 1073741824));
                    }
                };
                builder.setDelegate(new BottomSheet.BottomSheetDelegate() { // from class: ir.eitaa.ui.ArticleViewer.6
                    @Override // ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
                    public boolean canDismiss() {
                        TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper2 = ArticleViewer.this.textSelectionHelperBottomSheet;
                        if (articleTextSelectionHelper2 == null || !articleTextSelectionHelper2.isSelectionMode()) {
                            return true;
                        }
                        ArticleViewer.this.textSelectionHelperBottomSheet.clear();
                        return false;
                    }
                });
                frameLayout.addView(linearLayout, -1, -2);
                frameLayout.addView(overlayView, -1, -2);
                builder.setCustomView(frameLayout);
                if (this.textSelectionHelper.isSelectionMode()) {
                    this.textSelectionHelper.clear();
                }
                BottomSheet bottomSheetCreate = builder.create();
                this.linkSheet = bottomSheetCreate;
                showDialog(bottomSheetCreate);
            } else if (numValueOf.intValue() >= 0 && numValueOf.intValue() < this.adapter[0].blocks.size()) {
                TLRPC$PageBlock tLRPC$PageBlock = (TLRPC$PageBlock) this.adapter[0].blocks.get(numValueOf.intValue());
                TLRPC$PageBlock lastNonListPageBlock = getLastNonListPageBlock(tLRPC$PageBlock);
                if ((lastNonListPageBlock instanceof TL_pageBlockDetailsChild) && openAllParentBlocks((TL_pageBlockDetailsChild) lastNonListPageBlock)) {
                    this.adapter[0].updateRows();
                    this.adapter[0].notifyDataSetChanged();
                }
                int iIndexOf = this.adapter[0].localBlocks.indexOf(tLRPC$PageBlock);
                if (iIndexOf != -1) {
                    numValueOf = Integer.valueOf(iIndexOf);
                }
                Integer num2 = (Integer) this.adapter[0].anchorsOffset.get(lowerCase);
                if (num2 != null) {
                    if (num2.intValue() == -1) {
                        int typeForBlock2 = this.adapter[0].getTypeForBlock(tLRPC$PageBlock);
                        RecyclerView.ViewHolder viewHolderOnCreateViewHolder2 = this.adapter[0].onCreateViewHolder(null, typeForBlock2);
                        this.adapter[0].bindBlockToHolder(typeForBlock2, viewHolderOnCreateViewHolder2, tLRPC$PageBlock, 0, 0);
                        viewHolderOnCreateViewHolder2.itemView.measure(View.MeasureSpec.makeMeasureSpec(this.listView[0].getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                        Integer num3 = (Integer) this.adapter[0].anchorsOffset.get(lowerCase);
                        if (num3.intValue() != -1) {
                            num = num3;
                        }
                    } else {
                        num = num2;
                    }
                }
                this.layoutManager[0].scrollToPositionWithOffset(numValueOf.intValue(), (this.currentHeaderHeight - AndroidUtilities.dp(56.0f)) - num.intValue());
            }
            return true;
        }
        return false;
    }

    private boolean removeLastPageFromStack() {
        if (this.pagesStack.size() < 2) {
            return false;
        }
        ArrayList<TLRPC$WebPage> arrayList = this.pagesStack;
        arrayList.remove(arrayList.size() - 1);
        ArrayList<TLRPC$WebPage> arrayList2 = this.pagesStack;
        updateInterfaceForCurrentPage(arrayList2.get(arrayList2.size() - 1), false, -1);
        return true;
    }

    protected void startCheckLongPress(float x, float y, View parentView) {
        TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper;
        if (this.checkingForLongPress) {
            return;
        }
        this.checkingForLongPress = true;
        if (this.pendingCheckForTap == null) {
            this.pendingCheckForTap = new CheckForTap();
        }
        if (parentView.getTag() != null && parentView.getTag() == "bottomSheet" && (articleTextSelectionHelper = this.textSelectionHelperBottomSheet) != null) {
            articleTextSelectionHelper.setMaybeView((int) x, (int) y, parentView);
        } else {
            this.textSelectionHelper.setMaybeView((int) x, (int) y, parentView);
        }
        this.windowView.postDelayed(this.pendingCheckForTap, ViewConfiguration.getTapTimeout());
    }

    protected void cancelCheckLongPress() {
        this.checkingForLongPress = false;
        CheckForLongPress checkForLongPress = this.pendingCheckForLongPress;
        if (checkForLongPress != null) {
            this.windowView.removeCallbacks(checkForLongPress);
            this.pendingCheckForLongPress = null;
        }
        CheckForTap checkForTap = this.pendingCheckForTap;
        if (checkForTap != null) {
            this.windowView.removeCallbacks(checkForTap);
            this.pendingCheckForTap = null;
        }
    }

    private int getTextFlags(TLRPC$RichText richText) {
        if (richText instanceof TLRPC$TL_textFixed) {
            return getTextFlags(richText.parentRichText) | 4;
        }
        if (richText instanceof TLRPC$TL_textItalic) {
            return getTextFlags(richText.parentRichText) | 2;
        }
        if (richText instanceof TLRPC$TL_textBold) {
            return getTextFlags(richText.parentRichText) | 1;
        }
        if (richText instanceof TLRPC$TL_textUnderline) {
            return getTextFlags(richText.parentRichText) | 16;
        }
        if (richText instanceof TLRPC$TL_textStrike) {
            return getTextFlags(richText.parentRichText) | 32;
        }
        if (richText instanceof TLRPC$TL_textEmail) {
            return getTextFlags(richText.parentRichText) | 8;
        }
        if (richText instanceof TLRPC$TL_textPhone) {
            return getTextFlags(richText.parentRichText) | 8;
        }
        if (richText instanceof TLRPC$TL_textUrl) {
            if (((TLRPC$TL_textUrl) richText).webpage_id != 0) {
                return getTextFlags(richText.parentRichText) | Factory.DEVICE_USE_ANDROID_CAMCORDER;
            }
            return getTextFlags(richText.parentRichText) | 8;
        }
        if (richText instanceof TLRPC$TL_textSubscript) {
            return getTextFlags(richText.parentRichText) | 128;
        }
        if (richText instanceof TLRPC$TL_textSuperscript) {
            return getTextFlags(richText.parentRichText) | Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        }
        if (richText instanceof TLRPC$TL_textMarked) {
            return getTextFlags(richText.parentRichText) | 64;
        }
        if (richText != null) {
            return getTextFlags(richText.parentRichText);
        }
        return 0;
    }

    private TLRPC$RichText getLastRichText(TLRPC$RichText richText) {
        if (richText == null) {
            return null;
        }
        if (richText instanceof TLRPC$TL_textFixed) {
            return getLastRichText(((TLRPC$TL_textFixed) richText).text);
        }
        if (richText instanceof TLRPC$TL_textItalic) {
            return getLastRichText(((TLRPC$TL_textItalic) richText).text);
        }
        if (richText instanceof TLRPC$TL_textBold) {
            return getLastRichText(((TLRPC$TL_textBold) richText).text);
        }
        if (richText instanceof TLRPC$TL_textUnderline) {
            return getLastRichText(((TLRPC$TL_textUnderline) richText).text);
        }
        if (richText instanceof TLRPC$TL_textStrike) {
            return getLastRichText(((TLRPC$TL_textStrike) richText).text);
        }
        if (richText instanceof TLRPC$TL_textEmail) {
            return getLastRichText(((TLRPC$TL_textEmail) richText).text);
        }
        if (richText instanceof TLRPC$TL_textUrl) {
            return getLastRichText(((TLRPC$TL_textUrl) richText).text);
        }
        if (richText instanceof TLRPC$TL_textAnchor) {
            getLastRichText(((TLRPC$TL_textAnchor) richText).text);
            return richText;
        }
        if (richText instanceof TLRPC$TL_textSubscript) {
            return getLastRichText(((TLRPC$TL_textSubscript) richText).text);
        }
        if (richText instanceof TLRPC$TL_textSuperscript) {
            return getLastRichText(((TLRPC$TL_textSuperscript) richText).text);
        }
        if (richText instanceof TLRPC$TL_textMarked) {
            return getLastRichText(((TLRPC$TL_textMarked) richText).text);
        }
        return richText instanceof TLRPC$TL_textPhone ? getLastRichText(((TLRPC$TL_textPhone) richText).text) : richText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence getText(WebpageAdapter adapter, View parentView, TLRPC$RichText parentRichText, TLRPC$RichText richText, TLRPC$PageBlock parentBlock, int maxWidth) {
        return getText(adapter.currentPage, parentView, parentRichText, richText, parentBlock, maxWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.text.SpannableStringBuilder] */
    public CharSequence getText(TLRPC$WebPage page, View parentView, TLRPC$RichText parentRichText, TLRPC$RichText richText, TLRPC$PageBlock parentBlock, int maxWidth) {
        int i;
        int i2;
        Object textPaintUrlSpan;
        Object textPaintUrlSpan2;
        if (richText == null) {
            return null;
        }
        if (richText instanceof TLRPC$TL_textFixed) {
            return getText(page, parentView, parentRichText, ((TLRPC$TL_textFixed) richText).text, parentBlock, maxWidth);
        }
        if (richText instanceof TLRPC$TL_textItalic) {
            return getText(page, parentView, parentRichText, ((TLRPC$TL_textItalic) richText).text, parentBlock, maxWidth);
        }
        if (richText instanceof TLRPC$TL_textBold) {
            return getText(page, parentView, parentRichText, ((TLRPC$TL_textBold) richText).text, parentBlock, maxWidth);
        }
        if (richText instanceof TLRPC$TL_textUnderline) {
            return getText(page, parentView, parentRichText, ((TLRPC$TL_textUnderline) richText).text, parentBlock, maxWidth);
        }
        if (richText instanceof TLRPC$TL_textStrike) {
            return getText(page, parentView, parentRichText, ((TLRPC$TL_textStrike) richText).text, parentBlock, maxWidth);
        }
        if (richText instanceof TLRPC$TL_textEmail) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText(page, parentView, parentRichText, ((TLRPC$TL_textEmail) richText).text, parentBlock, maxWidth));
            MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
            if (spannableStringBuilder.length() != 0) {
                spannableStringBuilder.setSpan(new TextPaintUrlSpan((metricAffectingSpanArr == null || metricAffectingSpanArr.length == 0) ? getTextPaint(parentRichText, richText, parentBlock) : null, "mailto:" + getUrl(richText)), 0, spannableStringBuilder.length(), 33);
            }
            return spannableStringBuilder;
        }
        long j = 0;
        if (richText instanceof TLRPC$TL_textUrl) {
            TLRPC$TL_textUrl tLRPC$TL_textUrl = (TLRPC$TL_textUrl) richText;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getText(page, parentView, parentRichText, tLRPC$TL_textUrl.text, parentBlock, maxWidth));
            MetricAffectingSpan[] metricAffectingSpanArr2 = (MetricAffectingSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), MetricAffectingSpan.class);
            TextPaint textPaint = (metricAffectingSpanArr2 == null || metricAffectingSpanArr2.length == 0) ? getTextPaint(parentRichText, richText, parentBlock) : null;
            if (tLRPC$TL_textUrl.webpage_id != 0) {
                textPaintUrlSpan2 = new TextPaintWebpageUrlSpan(textPaint, getUrl(richText));
            } else {
                textPaintUrlSpan2 = new TextPaintUrlSpan(textPaint, getUrl(richText));
            }
            if (spannableStringBuilder2.length() != 0) {
                spannableStringBuilder2.setSpan(textPaintUrlSpan2, 0, spannableStringBuilder2.length(), 33);
            }
            return spannableStringBuilder2;
        }
        if (richText instanceof TLRPC$TL_textPlain) {
            return ((TLRPC$TL_textPlain) richText).text;
        }
        if (richText instanceof TLRPC$TL_textAnchor) {
            TLRPC$TL_textAnchor tLRPC$TL_textAnchor = (TLRPC$TL_textAnchor) richText;
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getText(page, parentView, parentRichText, tLRPC$TL_textAnchor.text, parentBlock, maxWidth));
            spannableStringBuilder3.setSpan(new AnchorSpan(tLRPC$TL_textAnchor.name), 0, spannableStringBuilder3.length(), 17);
            return spannableStringBuilder3;
        }
        ?? spannableStringBuilder4 = "";
        if (richText instanceof TLRPC$TL_textEmpty) {
            return "";
        }
        if (richText instanceof TLRPC$TL_textConcat) {
            SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder();
            int size = richText.texts.size();
            int i3 = 0;
            while (i3 < size) {
                TLRPC$RichText tLRPC$RichText = richText.texts.get(i3);
                TLRPC$RichText lastRichText = getLastRichText(tLRPC$RichText);
                boolean z = maxWidth >= 0 && (tLRPC$RichText instanceof TLRPC$TL_textUrl) && ((TLRPC$TL_textUrl) tLRPC$RichText).webpage_id != j;
                if (z && spannableStringBuilder5.length() != 0 && spannableStringBuilder5.charAt(spannableStringBuilder5.length() - 1) != '\n') {
                    spannableStringBuilder5.append((CharSequence) " ");
                    spannableStringBuilder5.setSpan(new TextSelectionHelper.IgnoreCopySpannable(), spannableStringBuilder5.length() - 1, spannableStringBuilder5.length(), 33);
                }
                int i4 = i3;
                int i5 = size;
                CharSequence text = getText(page, parentView, parentRichText, tLRPC$RichText, parentBlock, maxWidth);
                int textFlags = getTextFlags(lastRichText);
                int length = spannableStringBuilder5.length();
                spannableStringBuilder5.append(text);
                if (textFlags != 0 && !(text instanceof SpannableStringBuilder)) {
                    if ((textFlags & 8) != 0 || (textFlags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                        String url = getUrl(tLRPC$RichText);
                        if (url == null) {
                            url = getUrl(parentRichText);
                        }
                        if ((textFlags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            textPaintUrlSpan = new TextPaintWebpageUrlSpan(getTextPaint(parentRichText, lastRichText, parentBlock), url);
                        } else {
                            textPaintUrlSpan = new TextPaintUrlSpan(getTextPaint(parentRichText, lastRichText, parentBlock), url);
                        }
                        if (length != spannableStringBuilder5.length()) {
                            spannableStringBuilder5.setSpan(textPaintUrlSpan, length, spannableStringBuilder5.length(), 33);
                        }
                    } else if (length != spannableStringBuilder5.length()) {
                        spannableStringBuilder5.setSpan(new TextPaintSpan(getTextPaint(parentRichText, lastRichText, parentBlock)), length, spannableStringBuilder5.length(), 33);
                    }
                }
                if (z && i4 != i5 - 1) {
                    spannableStringBuilder5.append((CharSequence) " ");
                    spannableStringBuilder5.setSpan(new TextSelectionHelper.IgnoreCopySpannable(), spannableStringBuilder5.length() - 1, spannableStringBuilder5.length(), 33);
                }
                i3 = i4 + 1;
                size = i5;
                j = 0;
            }
            return spannableStringBuilder5;
        }
        if (richText instanceof TLRPC$TL_textSubscript) {
            return getText(page, parentView, parentRichText, ((TLRPC$TL_textSubscript) richText).text, parentBlock, maxWidth);
        }
        if (richText instanceof TLRPC$TL_textSuperscript) {
            return getText(page, parentView, parentRichText, ((TLRPC$TL_textSuperscript) richText).text, parentBlock, maxWidth);
        }
        if (richText instanceof TLRPC$TL_textMarked) {
            SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder(getText(page, parentView, parentRichText, ((TLRPC$TL_textMarked) richText).text, parentBlock, maxWidth));
            MetricAffectingSpan[] metricAffectingSpanArr3 = (MetricAffectingSpan[]) spannableStringBuilder6.getSpans(0, spannableStringBuilder6.length(), MetricAffectingSpan.class);
            if (spannableStringBuilder6.length() != 0) {
                spannableStringBuilder6.setSpan(new TextPaintMarkSpan((metricAffectingSpanArr3 == null || metricAffectingSpanArr3.length == 0) ? getTextPaint(parentRichText, richText, parentBlock) : null), 0, spannableStringBuilder6.length(), 33);
            }
            return spannableStringBuilder6;
        }
        if (richText instanceof TLRPC$TL_textPhone) {
            SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder(getText(page, parentView, parentRichText, ((TLRPC$TL_textPhone) richText).text, parentBlock, maxWidth));
            MetricAffectingSpan[] metricAffectingSpanArr4 = (MetricAffectingSpan[]) spannableStringBuilder7.getSpans(0, spannableStringBuilder7.length(), MetricAffectingSpan.class);
            if (spannableStringBuilder7.length() != 0) {
                spannableStringBuilder7.setSpan(new TextPaintUrlSpan((metricAffectingSpanArr4 == null || metricAffectingSpanArr4.length == 0) ? getTextPaint(parentRichText, richText, parentBlock) : null, "tel:" + getUrl(richText)), 0, spannableStringBuilder7.length(), 33);
            }
            return spannableStringBuilder7;
        }
        if (richText instanceof TLRPC$TL_textImage) {
            TLRPC$Document documentWithId = WebPageUtils.getDocumentWithId(page, ((TLRPC$TL_textImage) richText).document_id);
            if (documentWithId != null) {
                spannableStringBuilder4 = new SpannableStringBuilder("*");
                int iDp = AndroidUtilities.dp(r0.w);
                int iDp2 = AndroidUtilities.dp(r0.h);
                int iAbs = Math.abs(maxWidth);
                if (iDp > iAbs) {
                    i = (int) (iDp2 * (iAbs / iDp));
                    i2 = iAbs;
                } else {
                    i = iDp2;
                    i2 = iDp;
                }
                if (parentView != null) {
                    int color = Theme.getColor("windowBackgroundWhite");
                    spannableStringBuilder4.setSpan(new TextPaintImageReceiverSpan(parentView, documentWithId, page, i2, i, false, (((((float) Color.red(color)) * 0.2126f) + (((float) Color.green(color)) * 0.7152f)) + (((float) Color.blue(color)) * 0.0722f)) / 255.0f <= 0.705f), 0, spannableStringBuilder4.length(), 33);
                }
            }
            return spannableStringBuilder4;
        }
        return "not supported " + richText;
    }

    public static CharSequence getPlainText(TLRPC$RichText richText) {
        if (richText == null) {
            return "";
        }
        if (richText instanceof TLRPC$TL_textFixed) {
            return getPlainText(((TLRPC$TL_textFixed) richText).text);
        }
        if (richText instanceof TLRPC$TL_textItalic) {
            return getPlainText(((TLRPC$TL_textItalic) richText).text);
        }
        if (richText instanceof TLRPC$TL_textBold) {
            return getPlainText(((TLRPC$TL_textBold) richText).text);
        }
        if (richText instanceof TLRPC$TL_textUnderline) {
            return getPlainText(((TLRPC$TL_textUnderline) richText).text);
        }
        if (richText instanceof TLRPC$TL_textStrike) {
            return getPlainText(((TLRPC$TL_textStrike) richText).text);
        }
        if (richText instanceof TLRPC$TL_textEmail) {
            return getPlainText(((TLRPC$TL_textEmail) richText).text);
        }
        if (richText instanceof TLRPC$TL_textUrl) {
            return getPlainText(((TLRPC$TL_textUrl) richText).text);
        }
        if (richText instanceof TLRPC$TL_textPlain) {
            return ((TLRPC$TL_textPlain) richText).text;
        }
        if (richText instanceof TLRPC$TL_textAnchor) {
            return getPlainText(((TLRPC$TL_textAnchor) richText).text);
        }
        if (richText instanceof TLRPC$TL_textEmpty) {
            return "";
        }
        if (richText instanceof TLRPC$TL_textConcat) {
            StringBuilder sb = new StringBuilder();
            int size = richText.texts.size();
            for (int i = 0; i < size; i++) {
                sb.append(getPlainText(richText.texts.get(i)));
            }
            return sb;
        }
        if (richText instanceof TLRPC$TL_textSubscript) {
            return getPlainText(((TLRPC$TL_textSubscript) richText).text);
        }
        if (richText instanceof TLRPC$TL_textSuperscript) {
            return getPlainText(((TLRPC$TL_textSuperscript) richText).text);
        }
        if (richText instanceof TLRPC$TL_textMarked) {
            return getPlainText(((TLRPC$TL_textMarked) richText).text);
        }
        if (richText instanceof TLRPC$TL_textPhone) {
            return getPlainText(((TLRPC$TL_textPhone) richText).text);
        }
        if (richText instanceof TLRPC$TL_textImage) {
        }
        return "";
    }

    public static String getUrl(TLRPC$RichText richText) {
        if (richText instanceof TLRPC$TL_textFixed) {
            return getUrl(((TLRPC$TL_textFixed) richText).text);
        }
        if (richText instanceof TLRPC$TL_textItalic) {
            return getUrl(((TLRPC$TL_textItalic) richText).text);
        }
        if (richText instanceof TLRPC$TL_textBold) {
            return getUrl(((TLRPC$TL_textBold) richText).text);
        }
        if (richText instanceof TLRPC$TL_textUnderline) {
            return getUrl(((TLRPC$TL_textUnderline) richText).text);
        }
        if (richText instanceof TLRPC$TL_textStrike) {
            return getUrl(((TLRPC$TL_textStrike) richText).text);
        }
        if (richText instanceof TLRPC$TL_textEmail) {
            return ((TLRPC$TL_textEmail) richText).email;
        }
        if (richText instanceof TLRPC$TL_textUrl) {
            return ((TLRPC$TL_textUrl) richText).url;
        }
        if (richText instanceof TLRPC$TL_textPhone) {
            return ((TLRPC$TL_textPhone) richText).phone;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTextColor() {
        return Theme.getColor("windowBackgroundWhiteBlackText");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLinkTextColor() {
        return Theme.getColor("windowBackgroundWhiteLinkText");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getGrayTextColor() {
        return Theme.getColor("windowBackgroundWhiteGrayText");
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0271  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.text.TextPaint getTextPaint(ir.eitaa.tgnet.TLRPC$RichText r11, ir.eitaa.tgnet.TLRPC$RichText r12, ir.eitaa.tgnet.TLRPC$PageBlock r13) {
        /*
            Method dump skipped, instructions count: 931
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.getTextPaint(ir.eitaa.tgnet.TLRPC$RichText, ir.eitaa.tgnet.TLRPC$RichText, ir.eitaa.tgnet.TLRPC$PageBlock):android.text.TextPaint");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DrawingText createLayoutForText(View parentView, CharSequence plainText, TLRPC$RichText richText, int width, int textY, TLRPC$PageBlock parentBlock, Layout.Alignment align, WebpageAdapter parentAdapter) {
        return createLayoutForText(parentView, plainText, richText, width, 0, parentBlock, align, 0, parentAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DrawingText createLayoutForText(View parentView, CharSequence plainText, TLRPC$RichText richText, int width, int textY, TLRPC$PageBlock parentBlock, WebpageAdapter parentAdapter) {
        return createLayoutForText(parentView, plainText, richText, width, textY, parentBlock, Layout.Alignment.ALIGN_NORMAL, 0, parentAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6, types: [android.graphics.Path, ir.eitaa.ui.Components.LinkPath] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v36, types: [android.text.StaticLayout] */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.graphics.Path, ir.eitaa.ui.Components.LinkPath] */
    public DrawingText createLayoutForText(View view, CharSequence charSequence, TLRPC$RichText tLRPC$RichText, int i, int i2, TLRPC$PageBlock tLRPC$PageBlock, Layout.Alignment alignment, int i3, WebpageAdapter webpageAdapter) {
        TextPaint textPaint;
        ?? staticLayout;
        LinkPath linkPath;
        ?? linkPath2;
        int iDp;
        TextPaintWebpageUrlSpan[] textPaintWebpageUrlSpanArr;
        int iDp2;
        LinkPath linkPath3 = null;
        if (charSequence == null && (tLRPC$RichText == null || (tLRPC$RichText instanceof TLRPC$TL_textEmpty))) {
            return null;
        }
        int iDp3 = i < 0 ? AndroidUtilities.dp(10.0f) : i;
        CharSequence text = charSequence != null ? charSequence : getText(webpageAdapter, view, tLRPC$RichText, tLRPC$RichText, tLRPC$PageBlock, iDp3);
        if (TextUtils.isEmpty(text)) {
            return null;
        }
        int iDp4 = AndroidUtilities.dp(SharedConfig.ivFontSize - 16);
        if ((tLRPC$PageBlock instanceof TLRPC$TL_pageBlockEmbedPost) && tLRPC$RichText == null) {
            if (((TLRPC$TL_pageBlockEmbedPost) tLRPC$PageBlock).author == charSequence) {
                if (embedPostAuthorPaint == null) {
                    TextPaint textPaint2 = new TextPaint(1);
                    embedPostAuthorPaint = textPaint2;
                    textPaint2.setColor(getTextColor());
                }
                embedPostAuthorPaint.setTextSize(AndroidUtilities.dp(15.0f) + iDp4);
                textPaint = embedPostAuthorPaint;
            } else {
                if (embedPostDatePaint == null) {
                    TextPaint textPaint3 = new TextPaint(1);
                    embedPostDatePaint = textPaint3;
                    textPaint3.setColor(getGrayTextColor());
                }
                embedPostDatePaint.setTextSize(AndroidUtilities.dp(14.0f) + iDp4);
                textPaint = embedPostDatePaint;
            }
        } else if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockChannel) {
            if (channelNamePaint == null) {
                TextPaint textPaint4 = new TextPaint(1);
                channelNamePaint = textPaint4;
                textPaint4.setTypeface(AndroidUtilities.getFontFamily(true));
                TextPaint textPaint5 = new TextPaint(1);
                channelNamePhotoPaint = textPaint5;
                textPaint5.setTypeface(AndroidUtilities.getFontFamily(true));
            }
            channelNamePaint.setColor(getTextColor());
            channelNamePaint.setTextSize(AndroidUtilities.dp(15.0f));
            channelNamePhotoPaint.setColor(-1);
            channelNamePhotoPaint.setTextSize(AndroidUtilities.dp(15.0f));
            textPaint = webpageAdapter.channelBlock != null ? channelNamePhotoPaint : channelNamePaint;
        } else if (tLRPC$PageBlock instanceof TL_pageBlockRelatedArticlesChild) {
            TL_pageBlockRelatedArticlesChild tL_pageBlockRelatedArticlesChild = (TL_pageBlockRelatedArticlesChild) tLRPC$PageBlock;
            if (charSequence == tL_pageBlockRelatedArticlesChild.parent.articles.get(tL_pageBlockRelatedArticlesChild.num).title) {
                if (relatedArticleHeaderPaint == null) {
                    TextPaint textPaint6 = new TextPaint(1);
                    relatedArticleHeaderPaint = textPaint6;
                    textPaint6.setTypeface(AndroidUtilities.getFontFamily(true));
                }
                relatedArticleHeaderPaint.setColor(getTextColor());
                relatedArticleHeaderPaint.setTextSize(AndroidUtilities.dp(15.0f) + iDp4);
                textPaint = relatedArticleHeaderPaint;
            } else {
                if (relatedArticleTextPaint == null) {
                    relatedArticleTextPaint = new TextPaint(1);
                }
                relatedArticleTextPaint.setColor(getGrayTextColor());
                relatedArticleTextPaint.setTextSize(AndroidUtilities.dp(14.0f) + iDp4);
                textPaint = relatedArticleTextPaint;
            }
        } else if (isListItemBlock(tLRPC$PageBlock) && charSequence != null) {
            if (listTextPointerPaint == null) {
                TextPaint textPaint7 = new TextPaint(1);
                listTextPointerPaint = textPaint7;
                textPaint7.setColor(getTextColor());
            }
            if (listTextNumPaint == null) {
                TextPaint textPaint8 = new TextPaint(1);
                listTextNumPaint = textPaint8;
                textPaint8.setColor(getTextColor());
            }
            listTextPointerPaint.setTextSize(AndroidUtilities.dp(19.0f) + iDp4);
            listTextNumPaint.setTextSize(AndroidUtilities.dp(16.0f) + iDp4);
            if ((tLRPC$PageBlock instanceof TL_pageBlockListItem) && !((TL_pageBlockListItem) tLRPC$PageBlock).parent.pageBlockList.ordered) {
                textPaint = listTextPointerPaint;
            } else {
                textPaint = listTextNumPaint;
            }
        } else {
            textPaint = getTextPaint(tLRPC$RichText, tLRPC$RichText, tLRPC$PageBlock);
        }
        TextPaint textPaint9 = textPaint;
        if (i3 != 0) {
            if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockPullquote) {
                staticLayout = StaticLayoutEx.createStaticLayout(text, textPaint9, iDp3, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false, TextUtils.TruncateAt.END, iDp3, i3);
            } else {
                staticLayout = StaticLayoutEx.createStaticLayout(text, textPaint9, iDp3, alignment, 1.0f, AndroidUtilities.dp(4.0f), false, TextUtils.TruncateAt.END, iDp3, i3);
            }
        } else {
            if (text.charAt(text.length() - 1) == '\n') {
                text = text.subSequence(0, text.length() - 1);
            }
            if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockPullquote) {
                staticLayout = new StaticLayout(text, textPaint9, iDp3, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            } else {
                staticLayout = new StaticLayout(text, textPaint9, iDp3, alignment, 1.0f, AndroidUtilities.dp(4.0f), false);
            }
        }
        if (staticLayout == 0) {
            return null;
        }
        CharSequence text2 = staticLayout.getText();
        if (i2 >= 0 && !this.searchResults.isEmpty() && this.searchText != null) {
            String lowerCase = text.toString().toLowerCase();
            int i4 = 0;
            while (true) {
                int iIndexOf = lowerCase.indexOf(this.searchText, i4);
                if (iIndexOf < 0) {
                    break;
                }
                int length = this.searchText.length() + iIndexOf;
                if (iIndexOf == 0 || AndroidUtilities.isPunctuationCharacter(lowerCase.charAt(iIndexOf - 1))) {
                    this.adapter[0].searchTextOffset.put(this.searchText + tLRPC$PageBlock + tLRPC$RichText + iIndexOf, Integer.valueOf(i2 + staticLayout.getLineTop(staticLayout.getLineForOffset(iIndexOf))));
                }
                i4 = length;
            }
        }
        if (text2 instanceof Spanned) {
            Spanned spanned = (Spanned) text2;
            try {
                AnchorSpan[] anchorSpanArr = (AnchorSpan[]) spanned.getSpans(0, spanned.length(), AnchorSpan.class);
                int lineCount = staticLayout.getLineCount();
                if (anchorSpanArr != null && anchorSpanArr.length > 0) {
                    for (int i5 = 0; i5 < anchorSpanArr.length; i5++) {
                        if (lineCount <= 1) {
                            webpageAdapter.anchorsOffset.put(anchorSpanArr[i5].getName(), Integer.valueOf(i2));
                        } else {
                            webpageAdapter.anchorsOffset.put(anchorSpanArr[i5].getName(), Integer.valueOf(i2 + staticLayout.getLineTop(staticLayout.getLineForOffset(spanned.getSpanStart(anchorSpanArr[i5])))));
                        }
                    }
                }
            } catch (Exception unused) {
            }
            try {
                textPaintWebpageUrlSpanArr = (TextPaintWebpageUrlSpan[]) spanned.getSpans(0, spanned.length(), TextPaintWebpageUrlSpan.class);
            } catch (Exception unused2) {
            }
            if (textPaintWebpageUrlSpanArr == null || textPaintWebpageUrlSpanArr.length <= 0) {
                linkPath2 = 0;
            } else {
                linkPath2 = new LinkPath(true);
                try {
                    linkPath2.setAllowReset(false);
                    for (int i6 = 0; i6 < textPaintWebpageUrlSpanArr.length; i6++) {
                        int spanStart = spanned.getSpanStart(textPaintWebpageUrlSpanArr[i6]);
                        int spanEnd = spanned.getSpanEnd(textPaintWebpageUrlSpanArr[i6]);
                        linkPath2.setCurrentLayout(staticLayout, spanStart, 0.0f);
                        int i7 = textPaintWebpageUrlSpanArr[i6].getTextPaint() != null ? textPaintWebpageUrlSpanArr[i6].getTextPaint().baselineShift : 0;
                        if (i7 != 0) {
                            iDp2 = i7 + AndroidUtilities.dp(i7 > 0 ? 5.0f : -2.0f);
                        } else {
                            iDp2 = 0;
                        }
                        linkPath2.setBaselineShift(iDp2);
                        staticLayout.getSelectionPath(spanStart, spanEnd, linkPath2);
                    }
                    linkPath2.setAllowReset(true);
                } catch (Exception unused3) {
                }
            }
            try {
                TextPaintMarkSpan[] textPaintMarkSpanArr = (TextPaintMarkSpan[]) spanned.getSpans(0, spanned.length(), TextPaintMarkSpan.class);
                if (textPaintMarkSpanArr != null && textPaintMarkSpanArr.length > 0) {
                    ?? linkPath4 = new LinkPath(true);
                    try {
                        linkPath4.setAllowReset(false);
                        for (int i8 = 0; i8 < textPaintMarkSpanArr.length; i8++) {
                            int spanStart2 = spanned.getSpanStart(textPaintMarkSpanArr[i8]);
                            int spanEnd2 = spanned.getSpanEnd(textPaintMarkSpanArr[i8]);
                            linkPath4.setCurrentLayout(staticLayout, spanStart2, 0.0f);
                            int i9 = textPaintMarkSpanArr[i8].getTextPaint() != null ? textPaintMarkSpanArr[i8].getTextPaint().baselineShift : 0;
                            if (i9 != 0) {
                                iDp = i9 + AndroidUtilities.dp(i9 > 0 ? 5.0f : -2.0f);
                            } else {
                                iDp = 0;
                            }
                            linkPath4.setBaselineShift(iDp);
                            staticLayout.getSelectionPath(spanStart2, spanEnd2, linkPath4);
                        }
                        linkPath4.setAllowReset(true);
                    } catch (Exception unused4) {
                    }
                    linkPath3 = linkPath4;
                }
            } catch (Exception unused5) {
            }
            linkPath = linkPath3;
            linkPath3 = linkPath2;
        } else {
            linkPath = null;
        }
        DrawingText drawingText = new DrawingText();
        drawingText.textLayout = staticLayout;
        drawingText.textPath = linkPath3;
        drawingText.markPath = linkPath;
        drawingText.parentBlock = tLRPC$PageBlock;
        drawingText.parentText = tLRPC$RichText;
        return drawingText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawLayoutLink(Canvas canvas, DrawingText layout) {
        float width;
        float lineLeft;
        if (canvas == null || layout == null || this.pressedLinkOwnerLayout != layout) {
            return;
        }
        if (this.pressedLink != null) {
            canvas.drawPath(this.urlPath, urlPaint);
            return;
        }
        if (this.drawBlockSelection) {
            if (layout.getLineCount() == 1) {
                width = layout.getLineWidth(0);
                lineLeft = layout.getLineLeft(0);
            } else {
                width = layout.getWidth();
                lineLeft = 0.0f;
            }
            canvas.drawRect((-AndroidUtilities.dp(2.0f)) + lineLeft, 0.0f, lineLeft + width + AndroidUtilities.dp(2.0f), layout.getHeight(), urlPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkLayoutForLinks(ir.eitaa.ui.ArticleViewer.WebpageAdapter r17, android.view.MotionEvent r18, android.view.View r19, ir.eitaa.ui.ArticleViewer.DrawingText r20, int r21, int r22) throws java.lang.NoSuchFieldException, android.content.res.Resources.NotFoundException, java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.checkLayoutForLinks(ir.eitaa.ui.ArticleViewer$WebpageAdapter, android.view.MotionEvent, android.view.View, ir.eitaa.ui.ArticleViewer$DrawingText, int, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePressedLink() {
        if (this.pressedLink == null && this.pressedLinkOwnerView == null) {
            return;
        }
        View view = this.pressedLinkOwnerView;
        this.pressedLink = null;
        this.pressedLinkOwnerLayout = null;
        this.pressedLinkOwnerView = null;
        if (view != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebpageUrl(String url, final String anchor) {
        if (this.openUrlReqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.openUrlReqId, false);
            this.openUrlReqId = 0;
        }
        final int i = this.lastReqId + 1;
        this.lastReqId = i;
        showProgressView(true, true);
        final TLRPC$TL_messages_getWebPage tLRPC$TL_messages_getWebPage = new TLRPC$TL_messages_getWebPage();
        tLRPC$TL_messages_getWebPage.url = url;
        tLRPC$TL_messages_getWebPage.hash = 0;
        this.openUrlReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getWebPage, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$saEw3O-wkc2Q6OSLoPLMdVxJQng
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$openWebpageUrl$6$ArticleViewer(i, anchor, tLRPC$TL_messages_getWebPage, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openWebpageUrl$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openWebpageUrl$6$ArticleViewer(final int i, final String str, final TLRPC$TL_messages_getWebPage tLRPC$TL_messages_getWebPage, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$dZn2CrSfD6gMf7l7UM_kpDtEg60
            @Override // java.lang.Runnable
            public final void run() throws NoSuchFieldException, Resources.NotFoundException {
                this.f$0.lambda$openWebpageUrl$5$ArticleViewer(i, tLObject, str, tLRPC$TL_messages_getWebPage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openWebpageUrl$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openWebpageUrl$5$ArticleViewer(int i, TLObject tLObject, String str, TLRPC$TL_messages_getWebPage tLRPC$TL_messages_getWebPage) throws NoSuchFieldException, Resources.NotFoundException {
        if (this.openUrlReqId == 0 || i != this.lastReqId) {
            return;
        }
        this.openUrlReqId = 0;
        showProgressView(true, false);
        if (this.isVisible) {
            if (tLObject instanceof TLRPC$TL_webPage) {
                TLRPC$TL_webPage tLRPC$TL_webPage = (TLRPC$TL_webPage) tLObject;
                if (tLRPC$TL_webPage.cached_page instanceof TLRPC$TL_page) {
                    addPageToStack(tLRPC$TL_webPage, str, 1);
                    return;
                }
            }
            Browser.openUrl(this.parentActivity, tLRPC$TL_messages_getWebPage.url);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        BlockAudioCell blockAudioCell;
        MessageObject messageObject;
        if (id == NotificationCenter.messagePlayingDidStart) {
            if (this.listView == null) {
                return;
            }
            int i = 0;
            while (true) {
                RecyclerListView[] recyclerListViewArr = this.listView;
                if (i >= recyclerListViewArr.length) {
                    return;
                }
                int childCount = recyclerListViewArr[i].getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.listView[i].getChildAt(i2);
                    if (childAt instanceof BlockAudioCell) {
                        ((BlockAudioCell) childAt).updateButtonState(true);
                    }
                }
                i++;
            }
        } else if (id == NotificationCenter.messagePlayingDidReset || id == NotificationCenter.messagePlayingPlayStateChanged) {
            if (this.listView == null) {
                return;
            }
            int i3 = 0;
            while (true) {
                RecyclerListView[] recyclerListViewArr2 = this.listView;
                if (i3 >= recyclerListViewArr2.length) {
                    return;
                }
                int childCount2 = recyclerListViewArr2[i3].getChildCount();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    View childAt2 = this.listView[i3].getChildAt(i4);
                    if (childAt2 instanceof BlockAudioCell) {
                        BlockAudioCell blockAudioCell2 = (BlockAudioCell) childAt2;
                        if (blockAudioCell2.getMessageObject() != null) {
                            blockAudioCell2.updateButtonState(true);
                        }
                    }
                }
                i3++;
            }
        } else {
            if (id != NotificationCenter.messagePlayingProgressDidChanged) {
                return;
            }
            Integer num = (Integer) args[0];
            if (this.listView == null) {
                return;
            }
            int i5 = 0;
            while (true) {
                RecyclerListView[] recyclerListViewArr3 = this.listView;
                if (i5 >= recyclerListViewArr3.length) {
                    return;
                }
                int childCount3 = recyclerListViewArr3[i5].getChildCount();
                int i6 = 0;
                while (true) {
                    if (i6 < childCount3) {
                        View childAt3 = this.listView[i5].getChildAt(i6);
                        if ((childAt3 instanceof BlockAudioCell) && (messageObject = (blockAudioCell = (BlockAudioCell) childAt3).getMessageObject()) != null && messageObject.getId() == num.intValue()) {
                            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                            if (playingMessageObject != null) {
                                messageObject.audioProgress = playingMessageObject.audioProgress;
                                messageObject.audioProgressSec = playingMessageObject.audioProgressSec;
                                messageObject.audioPlayerDuration = playingMessageObject.audioPlayerDuration;
                                blockAudioCell.updatePlayingMessageProgress();
                            }
                        } else {
                            i6++;
                        }
                    }
                }
                i5++;
            }
        }
    }

    public void updateThemeColors(float progress) {
        refreshThemeColors();
        updatePaintColors();
        if (this.windowView != null) {
            this.listView[0].invalidateViews();
            this.listView[1].invalidateViews();
            this.windowView.invalidate();
            this.searchPanel.invalidate();
            if (progress == 1.0f) {
                this.adapter[0].notifyDataSetChanged();
                this.adapter[1].notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePaintSize() {
        for (int i = 0; i < 2; i++) {
            this.adapter[i].notifyDataSetChanged();
        }
    }

    private void updatePaintFonts() {
        ApplicationLoader.applicationContext.getSharedPreferences("articles", 0).edit().putInt("font_type", this.selectedFont).commit();
        int i = this.selectedFont;
        Typeface typeface = i == 0 ? Typeface.DEFAULT : Typeface.SERIF;
        Typeface fontFamily = i == 0 ? AndroidUtilities.getFontFamily(false, true) : Typeface.create("serif", 2);
        Typeface fontFamily2 = this.selectedFont == 0 ? AndroidUtilities.getFontFamily(true) : Typeface.create("serif", 1);
        Typeface fontFamily3 = this.selectedFont == 0 ? AndroidUtilities.getFontFamily(true, true) : Typeface.create("serif", 3);
        for (int i2 = 0; i2 < quoteTextPaints.size(); i2++) {
            updateFontEntry(quoteTextPaints.keyAt(i2), quoteTextPaints.valueAt(i2), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i3 = 0; i3 < preformattedTextPaints.size(); i3++) {
            updateFontEntry(preformattedTextPaints.keyAt(i3), preformattedTextPaints.valueAt(i3), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i4 = 0; i4 < paragraphTextPaints.size(); i4++) {
            updateFontEntry(paragraphTextPaints.keyAt(i4), paragraphTextPaints.valueAt(i4), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i5 = 0; i5 < listTextPaints.size(); i5++) {
            updateFontEntry(listTextPaints.keyAt(i5), listTextPaints.valueAt(i5), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i6 = 0; i6 < embedPostTextPaints.size(); i6++) {
            updateFontEntry(embedPostTextPaints.keyAt(i6), embedPostTextPaints.valueAt(i6), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i7 = 0; i7 < mediaCaptionTextPaints.size(); i7++) {
            updateFontEntry(mediaCaptionTextPaints.keyAt(i7), mediaCaptionTextPaints.valueAt(i7), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i8 = 0; i8 < mediaCreditTextPaints.size(); i8++) {
            updateFontEntry(mediaCreditTextPaints.keyAt(i8), mediaCreditTextPaints.valueAt(i8), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i9 = 0; i9 < photoCaptionTextPaints.size(); i9++) {
            updateFontEntry(photoCaptionTextPaints.keyAt(i9), photoCaptionTextPaints.valueAt(i9), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i10 = 0; i10 < photoCreditTextPaints.size(); i10++) {
            updateFontEntry(photoCreditTextPaints.keyAt(i10), photoCreditTextPaints.valueAt(i10), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i11 = 0; i11 < authorTextPaints.size(); i11++) {
            updateFontEntry(authorTextPaints.keyAt(i11), authorTextPaints.valueAt(i11), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i12 = 0; i12 < footerTextPaints.size(); i12++) {
            updateFontEntry(footerTextPaints.keyAt(i12), footerTextPaints.valueAt(i12), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i13 = 0; i13 < embedPostCaptionTextPaints.size(); i13++) {
            updateFontEntry(embedPostCaptionTextPaints.keyAt(i13), embedPostCaptionTextPaints.valueAt(i13), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i14 = 0; i14 < relatedArticleTextPaints.size(); i14++) {
            updateFontEntry(relatedArticleTextPaints.keyAt(i14), relatedArticleTextPaints.valueAt(i14), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i15 = 0; i15 < detailsTextPaints.size(); i15++) {
            updateFontEntry(detailsTextPaints.keyAt(i15), detailsTextPaints.valueAt(i15), typeface, fontFamily3, fontFamily2, fontFamily);
        }
        for (int i16 = 0; i16 < tableTextPaints.size(); i16++) {
            updateFontEntry(tableTextPaints.keyAt(i16), tableTextPaints.valueAt(i16), typeface, fontFamily3, fontFamily2, fontFamily);
        }
    }

    private void updateFontEntry(int flags, TextPaint paint, Typeface typefaceNormal, Typeface typefaceBoldItalic, Typeface typefaceBold, Typeface typefaceItalic) {
        int i = flags & 1;
        if (i != 0 && (flags & 2) != 0) {
            paint.setTypeface(typefaceBoldItalic);
            return;
        }
        if (i != 0) {
            paint.setTypeface(typefaceBold);
        } else if ((flags & 2) != 0) {
            paint.setTypeface(typefaceItalic);
        } else {
            if ((flags & 4) != 0) {
                return;
            }
            paint.setTypeface(typefaceNormal);
        }
    }

    private void updatePaintColors() {
        this.backgroundPaint.setColor(Theme.getColor("windowBackgroundWhite"));
        int i = 0;
        while (true) {
            RecyclerListView[] recyclerListViewArr = this.listView;
            if (i >= recyclerListViewArr.length) {
                break;
            }
            recyclerListViewArr[i].setGlowColor(Theme.getColor("windowBackgroundWhite"));
            i++;
        }
        TextPaint textPaint = listTextPointerPaint;
        if (textPaint != null) {
            textPaint.setColor(getTextColor());
        }
        TextPaint textPaint2 = listTextNumPaint;
        if (textPaint2 != null) {
            textPaint2.setColor(getTextColor());
        }
        TextPaint textPaint3 = embedPostAuthorPaint;
        if (textPaint3 != null) {
            textPaint3.setColor(getTextColor());
        }
        TextPaint textPaint4 = channelNamePaint;
        if (textPaint4 != null) {
            textPaint4.setColor(getTextColor());
        }
        TextPaint textPaint5 = channelNamePhotoPaint;
        if (textPaint5 != null) {
            textPaint5.setColor(-1);
        }
        TextPaint textPaint6 = relatedArticleHeaderPaint;
        if (textPaint6 != null) {
            textPaint6.setColor(getTextColor());
        }
        TextPaint textPaint7 = relatedArticleTextPaint;
        if (textPaint7 != null) {
            textPaint7.setColor(getGrayTextColor());
        }
        TextPaint textPaint8 = embedPostDatePaint;
        if (textPaint8 != null) {
            textPaint8.setColor(getGrayTextColor());
        }
        createPaint(true);
        setMapColors(titleTextPaints);
        setMapColors(kickerTextPaints);
        setMapColors(subtitleTextPaints);
        setMapColors(headerTextPaints);
        setMapColors(subheaderTextPaints);
        setMapColors(quoteTextPaints);
        setMapColors(preformattedTextPaints);
        setMapColors(paragraphTextPaints);
        setMapColors(listTextPaints);
        setMapColors(embedPostTextPaints);
        setMapColors(mediaCaptionTextPaints);
        setMapColors(mediaCreditTextPaints);
        setMapColors(photoCaptionTextPaints);
        setMapColors(photoCreditTextPaints);
        setMapColors(authorTextPaints);
        setMapColors(footerTextPaints);
        setMapColors(embedPostCaptionTextPaints);
        setMapColors(relatedArticleTextPaints);
        setMapColors(detailsTextPaints);
        setMapColors(tableTextPaints);
    }

    private void setMapColors(SparseArray<TextPaint> map) {
        for (int i = 0; i < map.size(); i++) {
            int iKeyAt = map.keyAt(i);
            TextPaint textPaintValueAt = map.valueAt(i);
            if ((iKeyAt & 8) != 0 || (iKeyAt & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                textPaintValueAt.setColor(getLinkTextColor());
            } else {
                textPaintValueAt.setColor(getTextColor());
            }
        }
    }

    public void setParentActivity(Activity activity, BaseFragment fragment) {
        this.parentFragment = fragment;
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
        if (this.parentActivity == activity) {
            updatePaintColors();
            refreshThemeColors();
            return;
        }
        this.parentActivity = activity;
        this.selectedFont = ApplicationLoader.applicationContext.getSharedPreferences("articles", 0).getInt("font_type", 0);
        createPaint(false);
        this.backgroundPaint = new Paint();
        this.layerShadowDrawable = activity.getResources().getDrawable(R.drawable.layer_shadow);
        this.slideDotDrawable = activity.getResources().getDrawable(R.drawable.slide_dot_small);
        this.slideDotBigDrawable = activity.getResources().getDrawable(R.drawable.slide_dot_big);
        this.scrimPaint = new Paint();
        WindowView windowView = new WindowView(activity);
        this.windowView = windowView;
        windowView.setWillNotDraw(false);
        this.windowView.setClipChildren(true);
        this.windowView.setFocusable(false);
        FrameLayout frameLayout = new FrameLayout(activity) { // from class: ir.eitaa.ui.ArticleViewer.7
            /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
            @Override // android.view.ViewGroup
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected boolean drawChild(android.graphics.Canvas r11, android.view.View r12, long r13) {
                /*
                    r10 = this;
                    ir.eitaa.ui.ArticleViewer r2 = ir.eitaa.ui.ArticleViewer.this
                    ir.eitaa.ui.ArticleViewer$WindowView r2 = ir.eitaa.ui.ArticleViewer.access$1800(r2)
                    boolean r2 = ir.eitaa.ui.ArticleViewer.WindowView.access$4300(r2)
                    if (r2 == 0) goto Le0
                    int r2 = r10.getMeasuredWidth()
                    ir.eitaa.ui.ArticleViewer r3 = ir.eitaa.ui.ArticleViewer.this
                    ir.eitaa.ui.Components.RecyclerListView[] r3 = ir.eitaa.ui.ArticleViewer.access$2800(r3)
                    r4 = 0
                    r3 = r3[r4]
                    float r3 = r3.getTranslationX()
                    int r3 = (int) r3
                    ir.eitaa.ui.ArticleViewer r5 = ir.eitaa.ui.ArticleViewer.this
                    ir.eitaa.ui.Components.RecyclerListView[] r5 = ir.eitaa.ui.ArticleViewer.access$2800(r5)
                    r6 = 1
                    r5 = r5[r6]
                    if (r12 != r5) goto L2b
                    r7 = r3
                    goto L38
                L2b:
                    ir.eitaa.ui.ArticleViewer r5 = ir.eitaa.ui.ArticleViewer.this
                    ir.eitaa.ui.Components.RecyclerListView[] r5 = ir.eitaa.ui.ArticleViewer.access$2800(r5)
                    r5 = r5[r4]
                    r7 = r2
                    if (r12 != r5) goto L38
                    r5 = r3
                    goto L39
                L38:
                    r5 = 0
                L39:
                    int r8 = r11.save()
                    int r9 = r10.getHeight()
                    r11.clipRect(r5, r4, r7, r9)
                    boolean r9 = super.drawChild(r11, r12, r13)
                    r11.restoreToCount(r8)
                    if (r3 == 0) goto Ldf
                    ir.eitaa.ui.ArticleViewer r8 = ir.eitaa.ui.ArticleViewer.this
                    ir.eitaa.ui.Components.RecyclerListView[] r8 = ir.eitaa.ui.ArticleViewer.access$2800(r8)
                    r4 = r8[r4]
                    r8 = 0
                    if (r12 != r4) goto La1
                    int r2 = r2 - r3
                    float r2 = (float) r2
                    r4 = 1101004800(0x41a00000, float:20.0)
                    int r4 = ir.eitaa.messenger.AndroidUtilities.dp(r4)
                    float r4 = (float) r4
                    float r2 = r2 / r4
                    r4 = 1065353216(0x3f800000, float:1.0)
                    float r2 = java.lang.Math.min(r2, r4)
                    float r2 = java.lang.Math.max(r8, r2)
                    ir.eitaa.ui.ArticleViewer r4 = ir.eitaa.ui.ArticleViewer.this
                    android.graphics.drawable.Drawable r4 = ir.eitaa.ui.ArticleViewer.access$3500(r4)
                    ir.eitaa.ui.ArticleViewer r5 = ir.eitaa.ui.ArticleViewer.this
                    android.graphics.drawable.Drawable r5 = ir.eitaa.ui.ArticleViewer.access$3500(r5)
                    int r5 = r5.getIntrinsicWidth()
                    int r5 = r3 - r5
                    int r6 = r12.getTop()
                    int r1 = r12.getBottom()
                    r4.setBounds(r5, r6, r3, r1)
                    ir.eitaa.ui.ArticleViewer r1 = ir.eitaa.ui.ArticleViewer.this
                    android.graphics.drawable.Drawable r1 = ir.eitaa.ui.ArticleViewer.access$3500(r1)
                    r3 = 1132396544(0x437f0000, float:255.0)
                    float r2 = r2 * r3
                    int r2 = (int) r2
                    r1.setAlpha(r2)
                    ir.eitaa.ui.ArticleViewer r1 = ir.eitaa.ui.ArticleViewer.this
                    android.graphics.drawable.Drawable r1 = ir.eitaa.ui.ArticleViewer.access$3500(r1)
                    r1.draw(r11)
                    goto Ldf
                La1:
                    ir.eitaa.ui.ArticleViewer r4 = ir.eitaa.ui.ArticleViewer.this
                    ir.eitaa.ui.Components.RecyclerListView[] r4 = ir.eitaa.ui.ArticleViewer.access$2800(r4)
                    r4 = r4[r6]
                    if (r12 != r4) goto Ldf
                    r1 = 1061997773(0x3f4ccccd, float:0.8)
                    int r3 = r2 - r3
                    float r3 = (float) r3
                    float r2 = (float) r2
                    float r3 = r3 / r2
                    float r1 = java.lang.Math.min(r1, r3)
                    int r2 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
                    if (r2 >= 0) goto Lbc
                    goto Lbd
                Lbc:
                    r8 = r1
                Lbd:
                    ir.eitaa.ui.ArticleViewer r1 = ir.eitaa.ui.ArticleViewer.this
                    android.graphics.Paint r1 = ir.eitaa.ui.ArticleViewer.access$3400(r1)
                    r2 = 1125711872(0x43190000, float:153.0)
                    float r8 = r8 * r2
                    int r2 = (int) r8
                    int r2 = r2 << 24
                    r1.setColor(r2)
                    float r1 = (float) r5
                    r2 = 0
                    float r3 = (float) r7
                    int r4 = r10.getHeight()
                    float r4 = (float) r4
                    ir.eitaa.ui.ArticleViewer r5 = ir.eitaa.ui.ArticleViewer.this
                    android.graphics.Paint r5 = ir.eitaa.ui.ArticleViewer.access$3400(r5)
                    r0 = r11
                    r0.drawRect(r1, r2, r3, r4, r5)
                Ldf:
                    return r9
                Le0:
                    boolean r0 = super.drawChild(r11, r12, r13)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.AnonymousClass7.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
            }
        };
        this.containerView = frameLayout;
        this.windowView.addView(frameLayout, LayoutHelper.createFrame(-1, -1, 51));
        if (Build.VERSION.SDK_INT >= 21) {
            this.windowView.setFitsSystemWindows(true);
            this.containerView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$DQqq3SI0HmNDwGwqfFoMZyMJkPk
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return ArticleViewer.lambda$setParentActivity$7(view, windowInsets);
                }
            });
        }
        FrameLayout frameLayout2 = new FrameLayout(activity);
        this.fullscreenVideoContainer = frameLayout2;
        frameLayout2.setBackgroundColor(-16777216);
        this.fullscreenVideoContainer.setVisibility(4);
        this.windowView.addView(this.fullscreenVideoContainer, LayoutHelper.createFrame(-1, -1.0f));
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(activity);
        this.fullscreenAspectRatioView = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setVisibility(8);
        this.fullscreenVideoContainer.addView(this.fullscreenAspectRatioView, LayoutHelper.createFrame(-1, -1, 17));
        this.fullscreenTextureView = new TextureView(activity);
        this.listView = new RecyclerListView[2];
        this.adapter = new WebpageAdapter[2];
        this.layoutManager = new LinearLayoutManager[2];
        int i2 = 0;
        while (i2 < this.listView.length) {
            WebpageAdapter[] webpageAdapterArr = this.adapter;
            final WebpageAdapter webpageAdapter = new WebpageAdapter(this.parentActivity);
            webpageAdapterArr[i2] = webpageAdapter;
            this.listView[i2] = new RecyclerListView(activity) { // from class: ir.eitaa.ui.ArticleViewer.8
                @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean changed, int l, int t, int r, int b) {
                    super.onLayout(changed, l, t, r, b);
                    int childCount = getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = getChildAt(i3);
                        if ((childAt.getTag() instanceof Integer) && ((Integer) childAt.getTag()).intValue() == 90 && childAt.getBottom() < getMeasuredHeight()) {
                            int measuredHeight = getMeasuredHeight();
                            childAt.layout(0, measuredHeight - childAt.getMeasuredHeight(), childAt.getMeasuredWidth(), measuredHeight);
                            return;
                        }
                    }
                }

                @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent e) throws NoSuchFieldException, Resources.NotFoundException, UnsupportedEncodingException {
                    if (ArticleViewer.this.pressedLinkOwnerLayout == null || ArticleViewer.this.pressedLink != null || ((ArticleViewer.this.popupWindow != null && ArticleViewer.this.popupWindow.isShowing()) || (e.getAction() != 1 && e.getAction() != 3))) {
                        if (ArticleViewer.this.pressedLinkOwnerLayout != null && ArticleViewer.this.pressedLink != null && e.getAction() == 1) {
                            ArticleViewer articleViewer = ArticleViewer.this;
                            articleViewer.checkLayoutForLinks(webpageAdapter, e, articleViewer.pressedLinkOwnerView, ArticleViewer.this.pressedLinkOwnerLayout, 0, 0);
                        }
                    } else {
                        ArticleViewer.this.pressedLink = null;
                        ArticleViewer.this.pressedLinkOwnerLayout = null;
                        ArticleViewer.this.pressedLinkOwnerView = null;
                    }
                    return super.onInterceptTouchEvent(e);
                }

                @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
                public boolean onTouchEvent(MotionEvent e) {
                    if (ArticleViewer.this.pressedLinkOwnerLayout != null && ArticleViewer.this.pressedLink == null && ((ArticleViewer.this.popupWindow == null || !ArticleViewer.this.popupWindow.isShowing()) && (e.getAction() == 1 || e.getAction() == 3))) {
                        ArticleViewer.this.pressedLink = null;
                        ArticleViewer.this.pressedLinkOwnerLayout = null;
                        ArticleViewer.this.pressedLinkOwnerView = null;
                    }
                    return super.onTouchEvent(e);
                }

                @Override // android.view.View
                public void setTranslationX(float translationX) {
                    super.setTranslationX(translationX);
                    if (ArticleViewer.this.windowView.movingPage) {
                        ArticleViewer.this.containerView.invalidate();
                        ArticleViewer articleViewer = ArticleViewer.this;
                        articleViewer.setCurrentHeaderHeight((int) (articleViewer.windowView.startMovingHeaderHeight + ((AndroidUtilities.dp(56.0f) - ArticleViewer.this.windowView.startMovingHeaderHeight) * (translationX / getMeasuredWidth()))));
                    }
                }
            };
            ((DefaultItemAnimator) this.listView[i2].getItemAnimator()).setDelayAnimations(false);
            RecyclerListView recyclerListView = this.listView[i2];
            LinearLayoutManager[] linearLayoutManagerArr = this.layoutManager;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.parentActivity, 1, false);
            linearLayoutManagerArr[i2] = linearLayoutManager;
            recyclerListView.setLayoutManager(linearLayoutManager);
            this.listView[i2].setAdapter(webpageAdapter);
            this.listView[i2].setClipToPadding(false);
            this.listView[i2].setVisibility(i2 == 0 ? 0 : 8);
            this.listView[i2].setPadding(0, AndroidUtilities.dp(56.0f), 0, 0);
            this.listView[i2].setTopGlowOffset(AndroidUtilities.dp(56.0f));
            this.containerView.addView(this.listView[i2], LayoutHelper.createFrame(-1, -1.0f));
            this.listView[i2].setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$9jSiTizZEreddQNKhAr8xlkLsdY
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
                public final boolean onItemClick(View view, int i3) {
                    return this.f$0.lambda$setParentActivity$8$ArticleViewer(view, i3);
                }
            });
            this.listView[i2].setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$l46C8j4yevpFsQ_L7e4y2zLX4Uk
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
                public final void onItemClick(View view, int i3, float f, float f2) {
                    this.f$0.lambda$setParentActivity$11$ArticleViewer(webpageAdapter, view, i3, f, f2);
                }
            });
            this.listView[i2].setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.ArticleViewer.9
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (newState == 0) {
                        ArticleViewer.this.textSelectionHelper.stopScrolling();
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    if (recyclerView.getChildCount() == 0) {
                        return;
                    }
                    ArticleViewer.this.textSelectionHelper.onParentScrolled();
                    ArticleViewer.this.headerView.invalidate();
                    ArticleViewer.this.checkScroll(dy);
                }
            });
            i2++;
        }
        this.headerPaint.setColor(-16777216);
        this.statusBarPaint.setColor(-16777216);
        this.headerProgressPaint.setColor(-14408666);
        FrameLayout frameLayout3 = new FrameLayout(activity) { // from class: ir.eitaa.ui.ArticleViewer.10
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float measuredWidth = getMeasuredWidth();
                float measuredHeight = getMeasuredHeight();
                canvas.drawRect(0.0f, 0.0f, measuredWidth, measuredHeight, ArticleViewer.this.headerPaint);
                if (ArticleViewer.this.layoutManager == null) {
                    return;
                }
                int iFindFirstVisibleItemPosition = ArticleViewer.this.layoutManager[0].findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = ArticleViewer.this.layoutManager[0].findLastVisibleItemPosition();
                int itemCount = ArticleViewer.this.layoutManager[0].getItemCount() - 2;
                View viewFindViewByPosition = iFindLastVisibleItemPosition >= itemCount ? ArticleViewer.this.layoutManager[0].findViewByPosition(itemCount) : ArticleViewer.this.layoutManager[0].findViewByPosition(iFindFirstVisibleItemPosition);
                if (viewFindViewByPosition == null) {
                    return;
                }
                float f = measuredWidth / (r5 - 1);
                ArticleViewer.this.layoutManager[0].getChildCount();
                float measuredHeight2 = viewFindViewByPosition.getMeasuredHeight();
                canvas.drawRect(0.0f, 0.0f, (iFindFirstVisibleItemPosition * f) + (iFindLastVisibleItemPosition >= itemCount ? (((itemCount - iFindFirstVisibleItemPosition) * f) * (ArticleViewer.this.listView[0].getMeasuredHeight() - viewFindViewByPosition.getTop())) / measuredHeight2 : (1.0f - ((Math.min(0, viewFindViewByPosition.getTop() - ArticleViewer.this.listView[0].getPaddingTop()) + measuredHeight2) / measuredHeight2)) * f), measuredHeight, ArticleViewer.this.headerProgressPaint);
            }
        };
        this.headerView = frameLayout3;
        frameLayout3.setWillNotDraw(false);
        this.containerView.addView(this.headerView, LayoutHelper.createFrame(-1, 56.0f));
        this.headerView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$C0pD2FMtTApCaI-krlZUjLLzJ1w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$12$ArticleViewer(view);
            }
        });
        SimpleTextView simpleTextView = new SimpleTextView(activity);
        this.titleTextView = simpleTextView;
        simpleTextView.setGravity(19);
        this.titleTextView.setTextSize(20);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.titleTextView.setTextColor(-5000269);
        this.titleTextView.setPivotX(0.0f);
        this.titleTextView.setPivotY(AndroidUtilities.dp(28.0f));
        this.headerView.addView(this.titleTextView, LayoutHelper.createFrame(-1, 56.0f, 51, 72.0f, 0.0f, 96.0f, 0.0f));
        LineProgressView lineProgressView = new LineProgressView(activity);
        this.lineProgressView = lineProgressView;
        lineProgressView.setProgressColor(-1);
        this.lineProgressView.setPivotX(0.0f);
        this.lineProgressView.setPivotY(AndroidUtilities.dp(2.0f));
        this.headerView.addView(this.lineProgressView, LayoutHelper.createFrame(-1, 2.0f, 83, 0.0f, 0.0f, 0.0f, 1.0f));
        this.lineProgressTickRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$jebOT4Wryk1gY73LgR3tsX1wQiA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setParentActivity$13$ArticleViewer();
            }
        };
        FrameLayout frameLayout4 = new FrameLayout(activity);
        this.menuContainer = frameLayout4;
        this.headerView.addView(frameLayout4, LayoutHelper.createFrame(48, 56, 53));
        View view = new View(activity);
        this.searchShadow = view;
        view.setBackgroundResource(R.drawable.header_shadow);
        this.searchShadow.setAlpha(0.0f);
        this.containerView.addView(this.searchShadow, LayoutHelper.createFrame(-1, 3.0f, 51, 0.0f, 56.0f, 0.0f, 0.0f));
        FrameLayout frameLayout5 = new FrameLayout(this.parentActivity);
        this.searchContainer = frameLayout5;
        frameLayout5.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.searchContainer.setVisibility(4);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
            this.searchContainer.setAlpha(0.0f);
        }
        this.headerView.addView(this.searchContainer, LayoutHelper.createFrame(-1, 56.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(this.parentActivity) { // from class: ir.eitaa.ui.ArticleViewer.11
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (event.getAction() == 0 && !AndroidUtilities.showKeyboard(this)) {
                    clearFocus();
                    requestFocus();
                }
                return super.onTouchEvent(event);
            }
        };
        this.searchField = editTextBoldCursor;
        editTextBoldCursor.setCursorWidth(1.5f);
        this.searchField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.searchField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.searchField.setTextSize(1, 18.0f);
        this.searchField.setTypeface(AndroidUtilities.getFontFamily(false));
        this.searchField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.searchField.setSingleLine(true);
        this.searchField.setHint(LocaleController.getString("Search", R.string.Search));
        this.searchField.setBackgroundResource(0);
        this.searchField.setPadding(0, 0, 0, 0);
        this.searchField.setInputType(this.searchField.getInputType() | 524288);
        if (i3 < 23) {
            this.searchField.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ir.eitaa.ui.ArticleViewer.12
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }
            });
        }
        this.searchField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$8QYxSW6UOQoft1gqsv65F5niG6s
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                return this.f$0.lambda$setParentActivity$14$ArticleViewer(textView, i4, keyEvent);
            }
        });
        this.searchField.addTextChangedListener(new AnonymousClass13());
        this.searchField.setImeOptions(33554435);
        this.searchField.setTextIsSelectable(false);
        this.searchContainer.addView(this.searchField, LayoutHelper.createFrame(-1, 36.0f, 16, 72.0f, 0.0f, 48.0f, 0.0f));
        ImageView imageView = new ImageView(this.parentActivity) { // from class: ir.eitaa.ui.ArticleViewer.14
            @Override // android.widget.ImageView, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                clearAnimation();
                if (getTag() == null) {
                    ArticleViewer.this.clearButton.setVisibility(4);
                    ArticleViewer.this.clearButton.setAlpha(0.0f);
                    ArticleViewer.this.clearButton.setRotation(45.0f);
                    ArticleViewer.this.clearButton.setScaleX(0.0f);
                    ArticleViewer.this.clearButton.setScaleY(0.0f);
                    return;
                }
                ArticleViewer.this.clearButton.setAlpha(1.0f);
                ArticleViewer.this.clearButton.setRotation(0.0f);
                ArticleViewer.this.clearButton.setScaleX(1.0f);
                ArticleViewer.this.clearButton.setScaleY(1.0f);
            }
        };
        this.clearButton = imageView;
        imageView.setImageDrawable(new CloseProgressDrawable2());
        this.clearButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
        this.clearButton.setScaleType(ImageView.ScaleType.CENTER);
        this.clearButton.setAlpha(0.0f);
        this.clearButton.setRotation(45.0f);
        this.clearButton.setScaleX(0.0f);
        this.clearButton.setScaleY(0.0f);
        this.clearButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$IQBkN27u5zhZDQ8puaTn4wPrCak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setParentActivity$15$ArticleViewer(view2);
            }
        });
        this.clearButton.setContentDescription(LocaleController.getString("ClearButton", R.string.ClearButton));
        this.searchContainer.addView(this.clearButton, LayoutHelper.createFrame(48, -1, 21));
        ImageView imageView2 = new ImageView(activity);
        this.backButton = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        BackDrawable backDrawable = new BackDrawable(false);
        this.backDrawable = backDrawable;
        backDrawable.setAnimationTime(200.0f);
        this.backDrawable.setColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.backDrawable.setRotatedColor(-5000269);
        this.backDrawable.setRotation(1.0f, false);
        this.backButton.setImageDrawable(this.backDrawable);
        this.backButton.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.headerView.addView(this.backButton, LayoutHelper.createFrame(54, 56.0f));
        this.backButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$QFVmwinWdyDJ_oj64lncTzqmxsE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setParentActivity$16$ArticleViewer(view2);
            }
        });
        this.backButton.setContentDescription(LocaleController.getString("AccDescrGoBack", R.string.AccDescrGoBack));
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(this.parentActivity, null, 1090519039, -5000269) { // from class: ir.eitaa.ui.ArticleViewer.15
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem
            public void toggleSubMenu() {
                super.toggleSubMenu();
                ArticleViewer.this.listView[0].stopScroll();
                ArticleViewer.this.checkScrollAnimated();
            }
        };
        this.menuButton = actionBarMenuItem;
        actionBarMenuItem.setLayoutInScreen(true);
        this.menuButton.setDuplicateParentStateEnabled(false);
        this.menuButton.setClickable(true);
        this.menuButton.setIcon(R.drawable.ic_ab_other);
        this.menuButton.addSubItem(1, R.drawable.msg_search, LocaleController.getString("Search", R.string.Search));
        this.menuButton.addSubItem(2, R.drawable.msg_share, LocaleController.getString("ShareFile", R.string.ShareFile));
        this.menuButton.addSubItem(3, R.drawable.msg_openin, LocaleController.getString("OpenInExternalApp", R.string.OpenInExternalApp));
        this.menuButton.addSubItem(4, R.drawable.menu_settings, LocaleController.getString("Settings", R.string.Settings));
        this.menuButton.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.menuButton.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.menuContainer.addView(this.menuButton, LayoutHelper.createFrame(48, 56.0f));
        ContextProgressView contextProgressView = new ContextProgressView(activity, 2);
        this.progressView = contextProgressView;
        contextProgressView.setVisibility(8);
        this.menuContainer.addView(this.progressView, LayoutHelper.createFrame(48, 56.0f));
        this.menuButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$QoGbf1yoQttYyysM2Yq0vSoDj98
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setParentActivity$17$ArticleViewer(view2);
            }
        });
        this.menuButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$4SSlxi1PFCtSx7s458keMxIo1rY
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i4) {
                this.f$0.lambda$setParentActivity$19$ArticleViewer(i4);
            }
        });
        FrameLayout frameLayout6 = new FrameLayout(this.parentActivity) { // from class: ir.eitaa.ui.ArticleViewer.16
            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                int intrinsicHeight = Theme.chat_composeShadowDrawable.getIntrinsicHeight();
                Theme.chat_composeShadowDrawable.setBounds(0, 0, getMeasuredWidth(), intrinsicHeight);
                Theme.chat_composeShadowDrawable.draw(canvas);
                canvas.drawRect(0.0f, intrinsicHeight, getMeasuredWidth(), getMeasuredHeight(), Theme.chat_composeBackgroundPaint);
            }
        };
        this.searchPanel = frameLayout6;
        frameLayout6.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$DKlRz3DYy-Iru6PoUeI8gLxyrNo
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ArticleViewer.lambda$setParentActivity$20(view2, motionEvent);
            }
        });
        this.searchPanel.setWillNotDraw(false);
        this.searchPanel.setVisibility(4);
        this.searchPanel.setFocusable(true);
        this.searchPanel.setFocusableInTouchMode(true);
        this.searchPanel.setClickable(true);
        this.searchPanel.setPadding(0, AndroidUtilities.dp(3.0f), 0, 0);
        this.containerView.addView(this.searchPanel, LayoutHelper.createFrame(-1, 51, 80));
        ImageView imageView3 = new ImageView(this.parentActivity);
        this.searchUpButton = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        this.searchUpButton.setImageResource(R.drawable.msg_go_up);
        this.searchUpButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
        this.searchUpButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("actionBarActionModeDefaultSelector"), 1));
        this.searchPanel.addView(this.searchUpButton, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 48.0f, 0.0f));
        this.searchUpButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$fAa7pQ8rmKDhcWPvpTEn4zj0qn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws NoSuchFieldException, Resources.NotFoundException {
                this.f$0.lambda$setParentActivity$21$ArticleViewer(view2);
            }
        });
        this.searchUpButton.setContentDescription(LocaleController.getString("AccDescrSearchNext", R.string.AccDescrSearchNext));
        ImageView imageView4 = new ImageView(this.parentActivity);
        this.searchDownButton = imageView4;
        imageView4.setScaleType(ImageView.ScaleType.CENTER);
        this.searchDownButton.setImageResource(R.drawable.msg_go_down);
        this.searchDownButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
        this.searchDownButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("actionBarActionModeDefaultSelector"), 1));
        this.searchPanel.addView(this.searchDownButton, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
        this.searchDownButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$1_zyWx644iS4ENw6JiJucOMo0e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws NoSuchFieldException, Resources.NotFoundException {
                this.f$0.lambda$setParentActivity$22$ArticleViewer(view2);
            }
        });
        this.searchDownButton.setContentDescription(LocaleController.getString("AccDescrSearchPrev", R.string.AccDescrSearchPrev));
        SimpleTextView simpleTextView2 = new SimpleTextView(this.parentActivity);
        this.searchCountText = simpleTextView2;
        simpleTextView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.searchCountText.setTextSize(15);
        this.searchCountText.setTypeface(AndroidUtilities.getFontFamily(true));
        this.searchCountText.setGravity(3);
        this.searchPanel.addView(this.searchCountText, LayoutHelper.createFrame(-2, -2.0f, 19, 18.0f, 0.0f, 108.0f, 0.0f));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.windowLayoutParams = layoutParams;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.width = -1;
        layoutParams.gravity = 51;
        layoutParams.type = 98;
        layoutParams.softInputMode = 48;
        layoutParams.flags = 131072;
        if (i3 >= 21) {
            layoutParams.flags = 131072 | (-2147417856);
            if (i3 >= 28) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
        }
        TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper = new TextSelectionHelper.ArticleTextSelectionHelper();
        this.textSelectionHelper = articleTextSelectionHelper;
        articleTextSelectionHelper.setParentView(this.listView[0]);
        TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper2 = this.textSelectionHelper;
        articleTextSelectionHelper2.layoutManager = this.layoutManager[0];
        articleTextSelectionHelper2.setCallback(new TextSelectionHelper.Callback() { // from class: ir.eitaa.ui.ArticleViewer.17
            @Override // ir.eitaa.ui.Cells.TextSelectionHelper.Callback
            public void onStateChanged(boolean isSelected) {
                if (isSelected) {
                    ArticleViewer.this.showSearch(false);
                }
            }

            @Override // ir.eitaa.ui.Cells.TextSelectionHelper.Callback
            public void onTextCopied() {
                BulletinFactory.of(ArticleViewer.this.containerView, null).createCopyBulletin(LocaleController.getString("TextCopied", R.string.TextCopied)).show();
            }
        });
        this.containerView.addView(this.textSelectionHelper.getOverlayView(activity));
        PinchToZoomHelper pinchToZoomHelper = new PinchToZoomHelper(this.containerView);
        this.pinchToZoomHelper = pinchToZoomHelper;
        pinchToZoomHelper.setClipBoundsListener(new PinchToZoomHelper.ClipBoundsListener() { // from class: ir.eitaa.ui.ArticleViewer.18
            @Override // ir.eitaa.ui.PinchToZoomHelper.ClipBoundsListener
            public void getClipTopBottom(float[] topBottom) {
                topBottom[0] = ArticleViewer.this.currentHeaderHeight;
                topBottom[1] = ArticleViewer.this.listView[0].getMeasuredHeight();
            }
        });
        this.pinchToZoomHelper.setCallback(new PinchToZoomHelper.Callback() { // from class: ir.eitaa.ui.ArticleViewer.19
            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public /* synthetic */ TextureView getCurrentTextureView() {
                return PinchToZoomHelper.Callback.CC.$default$getCurrentTextureView(this);
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public /* synthetic */ void onZoomFinished(MessageObject messageObject) {
                PinchToZoomHelper.Callback.CC.$default$onZoomFinished(this, messageObject);
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public void onZoomStarted(MessageObject messageObject) {
                if (ArticleViewer.this.listView[0] != null) {
                    ArticleViewer.this.listView[0].cancelClickRunnables(true);
                }
            }
        });
        updatePaintColors();
    }

    static /* synthetic */ WindowInsets lambda$setParentActivity$7(View view, WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            return WindowInsets.CONSUMED;
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$setParentActivity$8$ArticleViewer(View view, int i) {
        if (!(view instanceof BlockRelatedArticlesCell)) {
            return false;
        }
        BlockRelatedArticlesCell blockRelatedArticlesCell = (BlockRelatedArticlesCell) view;
        showCopyPopup(blockRelatedArticlesCell.currentBlock.parent.articles.get(blockRelatedArticlesCell.currentBlock.num).url);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$11$ArticleViewer(WebpageAdapter webpageAdapter, View view, int i, float f, float f2) {
        TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper = this.textSelectionHelper;
        if (articleTextSelectionHelper != null) {
            if (articleTextSelectionHelper.isSelectionMode()) {
                this.textSelectionHelper.clear();
                return;
            }
            this.textSelectionHelper.clear();
        }
        if ((view instanceof ReportCell) && webpageAdapter.currentPage != null) {
            ReportCell reportCell = (ReportCell) view;
            if (this.previewsReqId == 0) {
                if (!reportCell.hasViews || f >= view.getMeasuredWidth() / 2) {
                    TLObject userOrChat = MessagesController.getInstance(this.currentAccount).getUserOrChat("previews");
                    if (!(userOrChat instanceof TLRPC$TL_user)) {
                        final int i2 = UserConfig.selectedAccount;
                        final long j = webpageAdapter.currentPage.id;
                        showProgressView(true, true);
                        TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
                        tLRPC$TL_contacts_resolveUsername.username = "previews";
                        this.previewsReqId = ConnectionsManager.getInstance(i2).sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$vkMT1HzGctDWSU_QAuRGhVK8zgQ
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$setParentActivity$10$ArticleViewer(i2, j, tLObject, tLRPC$TL_error);
                            }
                        });
                        return;
                    }
                    openPreviewsChat((TLRPC$User) userOrChat, webpageAdapter.currentPage.id);
                    return;
                }
                return;
            }
            return;
        }
        if (i < 0 || i >= webpageAdapter.localBlocks.size()) {
            return;
        }
        TLRPC$PageBlock tLRPC$PageBlock = (TLRPC$PageBlock) webpageAdapter.localBlocks.get(i);
        TLRPC$PageBlock lastNonListPageBlock = getLastNonListPageBlock(tLRPC$PageBlock);
        if (lastNonListPageBlock instanceof TL_pageBlockDetailsChild) {
            lastNonListPageBlock = ((TL_pageBlockDetailsChild) lastNonListPageBlock).block;
        }
        if (lastNonListPageBlock instanceof TLRPC$TL_pageBlockChannel) {
            MessagesController.getInstance(this.currentAccount).openByUserName(((TLRPC$TL_pageBlockChannel) lastNonListPageBlock).channel.username, this.parentFragment, 2);
            close(false, true);
            return;
        }
        if (lastNonListPageBlock instanceof TL_pageBlockRelatedArticlesChild) {
            TL_pageBlockRelatedArticlesChild tL_pageBlockRelatedArticlesChild = (TL_pageBlockRelatedArticlesChild) lastNonListPageBlock;
            openWebpageUrl(tL_pageBlockRelatedArticlesChild.parent.articles.get(tL_pageBlockRelatedArticlesChild.num).url, null);
            return;
        }
        if (lastNonListPageBlock instanceof TLRPC$TL_pageBlockDetails) {
            View lastNonListCell = getLastNonListCell(view);
            if (lastNonListCell instanceof BlockDetailsCell) {
                this.pressedLinkOwnerLayout = null;
                this.pressedLinkOwnerView = null;
                if (webpageAdapter.blocks.indexOf(tLRPC$PageBlock) < 0) {
                    return;
                }
                TLRPC$TL_pageBlockDetails tLRPC$TL_pageBlockDetails = (TLRPC$TL_pageBlockDetails) lastNonListPageBlock;
                tLRPC$TL_pageBlockDetails.open = !tLRPC$TL_pageBlockDetails.open;
                int itemCount = webpageAdapter.getItemCount();
                webpageAdapter.updateRows();
                int iAbs = Math.abs(webpageAdapter.getItemCount() - itemCount);
                BlockDetailsCell blockDetailsCell = (BlockDetailsCell) lastNonListCell;
                blockDetailsCell.arrow.setAnimationProgressAnimated(tLRPC$TL_pageBlockDetails.open ? 0.0f : 1.0f);
                blockDetailsCell.invalidate();
                if (iAbs != 0) {
                    if (tLRPC$TL_pageBlockDetails.open) {
                        webpageAdapter.notifyItemRangeInserted(i + 1, iAbs);
                    } else {
                        webpageAdapter.notifyItemRangeRemoved(i + 1, iAbs);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$10$ArticleViewer(final int i, final long j, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$YCOLv0jIP7aS_mLBQlMXA4n4iJk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setParentActivity$9$ArticleViewer(tLObject, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$9$ArticleViewer(TLObject tLObject, int i, long j) {
        if (this.previewsReqId == 0) {
            return;
        }
        this.previewsReqId = 0;
        showProgressView(true, false);
        if (tLObject != null) {
            TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
            MessagesController.getInstance(i).putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
            MessagesStorage.getInstance(i).putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, false, true);
            if (tLRPC$TL_contacts_resolvedPeer.users.isEmpty()) {
                return;
            }
            openPreviewsChat(tLRPC$TL_contacts_resolvedPeer.users.get(0), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$12$ArticleViewer(View view) {
        this.listView[0].smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$13$ArticleViewer() {
        float currentProgress = 0.7f - this.lineProgressView.getCurrentProgress();
        if (currentProgress > 0.0f) {
            float f = currentProgress < 0.25f ? 0.01f : 0.02f;
            LineProgressView lineProgressView = this.lineProgressView;
            lineProgressView.setProgress(lineProgressView.getCurrentProgress() + f, true);
            AndroidUtilities.runOnUIThread(this.lineProgressTickRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$setParentActivity$14$ArticleViewer(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 84) && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        AndroidUtilities.hideKeyboard(this.searchField);
        return false;
    }

    /* renamed from: ir.eitaa.ui.ArticleViewer$13, reason: invalid class name */
    class AnonymousClass13 implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        AnonymousClass13() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) throws NoSuchFieldException, Resources.NotFoundException {
            if (ArticleViewer.this.ignoreOnTextChange) {
                ArticleViewer.this.ignoreOnTextChange = false;
                return;
            }
            ArticleViewer.this.processSearch(s.toString().toLowerCase());
            if (ArticleViewer.this.clearButton != null) {
                if (TextUtils.isEmpty(s)) {
                    if (ArticleViewer.this.clearButton.getTag() != null) {
                        ArticleViewer.this.clearButton.setTag(null);
                        ArticleViewer.this.clearButton.clearAnimation();
                        if (ArticleViewer.this.animateClear) {
                            ArticleViewer.this.clearButton.animate().setInterpolator(new DecelerateInterpolator()).alpha(0.0f).setDuration(180L).scaleY(0.0f).scaleX(0.0f).rotation(45.0f).withEndAction(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$13$Edfk2d_DHQ51A2P5hS3lEPAIW-w
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onTextChanged$0$ArticleViewer$13();
                                }
                            }).start();
                            return;
                        }
                        ArticleViewer.this.clearButton.setAlpha(0.0f);
                        ArticleViewer.this.clearButton.setRotation(45.0f);
                        ArticleViewer.this.clearButton.setScaleX(0.0f);
                        ArticleViewer.this.clearButton.setScaleY(0.0f);
                        ArticleViewer.this.clearButton.setVisibility(4);
                        ArticleViewer.this.animateClear = true;
                        return;
                    }
                    return;
                }
                if (ArticleViewer.this.clearButton.getTag() == null) {
                    ArticleViewer.this.clearButton.setTag(1);
                    ArticleViewer.this.clearButton.clearAnimation();
                    ArticleViewer.this.clearButton.setVisibility(0);
                    if (ArticleViewer.this.animateClear) {
                        ArticleViewer.this.clearButton.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0f).setDuration(180L).scaleY(1.0f).scaleX(1.0f).rotation(0.0f).start();
                        return;
                    }
                    ArticleViewer.this.clearButton.setAlpha(1.0f);
                    ArticleViewer.this.clearButton.setRotation(0.0f);
                    ArticleViewer.this.clearButton.setScaleX(1.0f);
                    ArticleViewer.this.clearButton.setScaleY(1.0f);
                    ArticleViewer.this.animateClear = true;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onTextChanged$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onTextChanged$0$ArticleViewer$13() {
            ArticleViewer.this.clearButton.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$15$ArticleViewer(View view) {
        if (this.searchField.length() != 0) {
            this.searchField.setText("");
        }
        this.searchField.requestFocus();
        AndroidUtilities.showKeyboard(this.searchField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$16$ArticleViewer(View view) {
        if (this.searchContainer.getTag() != null) {
            showSearch(false);
        } else {
            close(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$17$ArticleViewer(View view) {
        this.menuButton.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$19$ArticleViewer(int i) {
        Activity activity;
        if (this.adapter[0].currentPage == null || (activity = this.parentActivity) == null) {
            return;
        }
        if (i == 1) {
            showSearch(true);
            return;
        }
        if (i == 2) {
            showDialog(new ShareAlert(this.parentActivity, null, this.adapter[0].currentPage.url, false, this.adapter[0].currentPage.url, false));
            return;
        }
        if (i == 3) {
            Browser.openUrl(this.parentActivity, !TextUtils.isEmpty(this.adapter[0].currentPage.cached_page.url) ? this.adapter[0].currentPage.cached_page.url : this.adapter[0].currentPage.url, true, false);
            return;
        }
        if (i == 4) {
            BottomSheet.Builder builder = new BottomSheet.Builder(activity);
            builder.setApplyTopPadding(false);
            LinearLayout linearLayout = new LinearLayout(this.parentActivity);
            linearLayout.setPadding(0, 0, 0, AndroidUtilities.dp(4.0f));
            linearLayout.setOrientation(1);
            HeaderCell headerCell = new HeaderCell(this.parentActivity);
            headerCell.setText(LocaleController.getString("FontSize", R.string.FontSize));
            linearLayout.addView(headerCell, LayoutHelper.createLinear(-2, -2, 51, 3, 1, 3, 0));
            linearLayout.addView(new TextSizeCell(this.parentActivity), LayoutHelper.createLinear(-1, -2, 51, 3, 0, 3, 0));
            HeaderCell headerCell2 = new HeaderCell(this.parentActivity);
            headerCell2.setText(LocaleController.getString("FontType", R.string.FontType));
            linearLayout.addView(headerCell2, LayoutHelper.createLinear(-2, -2, 51, 3, 4, 3, 2));
            int i2 = 0;
            while (i2 < 2) {
                this.fontCells[i2] = new FontCell(this.parentActivity);
                if (i2 == 0) {
                    this.fontCells[i2].setTextAndTypeface(LocaleController.getString("Default", R.string.Default), Typeface.DEFAULT);
                } else if (i2 == 1) {
                    this.fontCells[i2].setTextAndTypeface("Serif", Typeface.SERIF);
                }
                this.fontCells[i2].select(i2 == this.selectedFont, false);
                this.fontCells[i2].setTag(Integer.valueOf(i2));
                this.fontCells[i2].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$ZtGGRzy1kM_6KiucxfiB0yfKZeA
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setParentActivity$18$ArticleViewer(view);
                    }
                });
                linearLayout.addView(this.fontCells[i2], LayoutHelper.createLinear(-1, 50));
                i2++;
            }
            builder.setCustomView(linearLayout);
            BottomSheet bottomSheetCreate = builder.create();
            this.linkSheet = bottomSheetCreate;
            showDialog(bottomSheetCreate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$18$ArticleViewer(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.selectedFont = iIntValue;
        int i = 0;
        while (i < 2) {
            this.fontCells[i].select(i == iIntValue, true);
            i++;
        }
        updatePaintFonts();
        for (int i2 = 0; i2 < this.listView.length; i2++) {
            this.adapter[i2].notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$21$ArticleViewer(View view) throws NoSuchFieldException, Resources.NotFoundException {
        scrollToSearchIndex(this.currentSearchIndex - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$22$ArticleViewer(View view) throws NoSuchFieldException, Resources.NotFoundException {
        scrollToSearchIndex(this.currentSearchIndex + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSearch(final boolean show) {
        FrameLayout frameLayout = this.searchContainer;
        if (frameLayout != null) {
            if ((frameLayout.getTag() != null) == show) {
                return;
            }
            this.searchContainer.setTag(show ? 1 : null);
            this.searchResults.clear();
            this.searchText = null;
            this.adapter[0].searchTextOffset.clear();
            this.currentSearchIndex = 0;
            if (this.attachedToWindow) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(250L);
                if (show) {
                    this.searchContainer.setVisibility(0);
                    this.backDrawable.setRotation(0.0f, true);
                } else {
                    this.menuButton.setVisibility(0);
                    this.listView[0].invalidateViews();
                    AndroidUtilities.hideKeyboard(this.searchField);
                    updateWindowLayoutParamsForSearch();
                }
                ArrayList arrayList = new ArrayList();
                if (Build.VERSION.SDK_INT >= 21) {
                    if (show) {
                        this.searchContainer.setAlpha(1.0f);
                    }
                    int left = this.menuContainer.getLeft() + (this.menuContainer.getMeasuredWidth() / 2);
                    int top = this.menuContainer.getTop() + (this.menuContainer.getMeasuredHeight() / 2);
                    float fSqrt = (float) Math.sqrt((left * left) + (top * top));
                    FrameLayout frameLayout2 = this.searchContainer;
                    float f = show ? 0.0f : fSqrt;
                    if (!show) {
                        fSqrt = 0.0f;
                    }
                    Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(frameLayout2, left, top, f, fSqrt);
                    arrayList.add(animatorCreateCircularReveal);
                    animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ArticleViewer.20
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (show) {
                                return;
                            }
                            ArticleViewer.this.searchContainer.setAlpha(0.0f);
                        }
                    });
                } else {
                    FrameLayout frameLayout3 = this.searchContainer;
                    Property property = View.ALPHA;
                    float[] fArr = new float[1];
                    fArr[0] = show ? 1.0f : 0.0f;
                    arrayList.add(ObjectAnimator.ofFloat(frameLayout3, (Property<FrameLayout, Float>) property, fArr));
                }
                if (!show) {
                    arrayList.add(ObjectAnimator.ofFloat(this.searchPanel, (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
                }
                View view = this.searchShadow;
                Property property2 = View.ALPHA;
                float[] fArr2 = new float[1];
                fArr2[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2));
                animatorSet.playTogether(arrayList);
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ArticleViewer.21
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (show) {
                            ArticleViewer.this.updateWindowLayoutParamsForSearch();
                            ArticleViewer.this.searchField.requestFocus();
                            AndroidUtilities.showKeyboard(ArticleViewer.this.searchField);
                            ArticleViewer.this.menuButton.setVisibility(4);
                            return;
                        }
                        ArticleViewer.this.searchContainer.setVisibility(4);
                        ArticleViewer.this.searchPanel.setVisibility(4);
                        ArticleViewer.this.searchField.setText("");
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        if (show) {
                            return;
                        }
                        ArticleViewer.this.backDrawable.setRotation(1.0f, true);
                    }
                });
                animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                if (!show && !AndroidUtilities.usingHardwareInput && this.keyboardVisible) {
                    this.runAfterKeyboardClose = animatorSet;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$pIPnw9MrTMo8FnzqLDkv4h_nvT8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$showSearch$23$ArticleViewer();
                        }
                    }, 300L);
                    return;
                } else {
                    animatorSet.start();
                    return;
                }
            }
            this.searchContainer.setAlpha(show ? 1.0f : 0.0f);
            this.menuButton.setVisibility(show ? 4 : 0);
            this.backDrawable.setRotation(show ? 0.0f : 1.0f, false);
            this.searchShadow.setAlpha(show ? 1.0f : 0.0f);
            if (show) {
                this.searchContainer.setVisibility(0);
            } else {
                this.searchContainer.setVisibility(4);
                this.searchPanel.setVisibility(4);
                this.searchField.setText("");
            }
            updateWindowLayoutParamsForSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showSearch$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showSearch$23$ArticleViewer() {
        AnimatorSet animatorSet = this.runAfterKeyboardClose;
        if (animatorSet != null) {
            animatorSet.start();
            this.runAfterKeyboardClose = null;
        }
    }

    private void updateSearchButtons() {
        ArrayList<SearchResult> arrayList = this.searchResults;
        if (arrayList == null) {
            return;
        }
        this.searchUpButton.setEnabled((arrayList.isEmpty() || this.currentSearchIndex == 0) ? false : true);
        this.searchDownButton.setEnabled((this.searchResults.isEmpty() || this.currentSearchIndex == this.searchResults.size() - 1) ? false : true);
        ImageView imageView = this.searchUpButton;
        imageView.setAlpha(imageView.isEnabled() ? 1.0f : 0.5f);
        ImageView imageView2 = this.searchDownButton;
        imageView2.setAlpha(imageView2.isEnabled() ? 1.0f : 0.5f);
        int size = this.searchResults.size();
        if (size < 0) {
            this.searchCountText.setText("");
            return;
        }
        if (size == 0) {
            this.searchCountText.setText(LocaleController.getString("NoResult", R.string.NoResult));
        } else if (size == 1) {
            this.searchCountText.setText(LocaleController.getString("OneResult", R.string.OneResult));
        } else {
            this.searchCountText.setText(String.format(LocaleController.getPluralString("CountOfResults", size), Integer.valueOf(this.currentSearchIndex + 1), Integer.valueOf(size)));
        }
    }

    private static class SearchResult {
        private TLRPC$PageBlock block;
        private int index;
        private Object text;

        private SearchResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSearch(final String text) throws NoSuchFieldException, Resources.NotFoundException {
        Runnable runnable = this.searchRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.searchRunnable = null;
        }
        if (TextUtils.isEmpty(text)) {
            this.searchResults.clear();
            this.searchText = text;
            this.adapter[0].searchTextOffset.clear();
            this.searchPanel.setVisibility(4);
            this.listView[0].invalidateViews();
            scrollToSearchIndex(0);
            this.lastSearchIndex = -1;
            return;
        }
        final int i = this.lastSearchIndex + 1;
        this.lastSearchIndex = i;
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$9SeOpvwb4QtFhCSxhflemsL-Hrc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processSearch$26$ArticleViewer(text, i);
            }
        };
        this.searchRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSearch$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSearch$26$ArticleViewer(final String str, final int i) {
        final HashMap map = new HashMap(this.adapter[0].textToBlocks);
        final ArrayList arrayList = new ArrayList(this.adapter[0].textBlocks);
        this.searchRunnable = null;
        Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$yucXh67rbKLUb1PBmXaFTnnt-3o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processSearch$25$ArticleViewer(arrayList, map, str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b A[PHI: r11 r17
      0x005b: PHI (r11v3 java.lang.String) = (r11v10 java.lang.String), (r11v11 java.lang.String) binds: [B:10:0x0051, B:7:0x0040] A[DONT_GENERATE, DONT_INLINE]
      0x005b: PHI (r17v1 ir.eitaa.tgnet.TLRPC$PageBlock) = (r17v0 ir.eitaa.tgnet.TLRPC$PageBlock), (r17v5 ir.eitaa.tgnet.TLRPC$PageBlock) binds: [B:10:0x0051, B:7:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: lambda$processSearch$25, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processSearch$25$ArticleViewer(java.util.ArrayList r19, java.util.HashMap r20, final java.lang.String r21, final int r22) {
        /*
            r18 = this;
            r7 = r18
            r8 = r21
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            int r10 = r19.size()
            r11 = 0
            r12 = 0
        Lf:
            if (r12 >= r10) goto L98
            r13 = r19
            java.lang.Object r14 = r13.get(r12)
            r15 = r20
            java.lang.Object r0 = r15.get(r14)
            r6 = r0
            ir.eitaa.tgnet.TLRPC$PageBlock r6 = (ir.eitaa.tgnet.TLRPC$PageBlock) r6
            boolean r0 = r14 instanceof ir.eitaa.tgnet.TLRPC$RichText
            r5 = 0
            if (r0 == 0) goto L4c
            r4 = r14
            ir.eitaa.tgnet.TLRPC$RichText r4 = (ir.eitaa.tgnet.TLRPC$RichText) r4
            ir.eitaa.ui.ArticleViewer$WebpageAdapter[] r0 = r7.adapter
            r1 = r0[r11]
            r2 = 0
            r16 = 1000(0x3e8, float:1.401E-42)
            r0 = r18
            r3 = r4
            r11 = r5
            r5 = r6
            r17 = r6
            r6 = r16
            java.lang.CharSequence r0 = r0.getText(r1, r2, r3, r4, r5, r6)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L5b
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toLowerCase()
            r5 = r0
            goto L5c
        L4c:
            r11 = r5
            r17 = r6
            boolean r0 = r14 instanceof java.lang.String
            if (r0 == 0) goto L5b
            r0 = r14
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r5 = r0.toLowerCase()
            goto L5c
        L5b:
            r5 = r11
        L5c:
            if (r5 == 0) goto L93
            r0 = 0
        L5f:
            int r0 = r5.indexOf(r8, r0)
            if (r0 < 0) goto L93
            int r1 = r21.length()
            int r1 = r1 + r0
            if (r0 == 0) goto L7c
            int r2 = r0 + (-1)
            char r2 = r5.charAt(r2)
            boolean r2 = ir.eitaa.messenger.AndroidUtilities.isPunctuationCharacter(r2)
            if (r2 == 0) goto L79
            goto L7c
        L79:
            r0 = r17
            goto L8f
        L7c:
            ir.eitaa.ui.ArticleViewer$SearchResult r2 = new ir.eitaa.ui.ArticleViewer$SearchResult
            r2.<init>()
            ir.eitaa.ui.ArticleViewer.SearchResult.access$402(r2, r0)
            r0 = r17
            ir.eitaa.ui.ArticleViewer.SearchResult.access$202(r2, r0)
            ir.eitaa.ui.ArticleViewer.SearchResult.access$302(r2, r14)
            r9.add(r2)
        L8f:
            r17 = r0
            r0 = r1
            goto L5f
        L93:
            int r12 = r12 + 1
            r11 = 0
            goto Lf
        L98:
            ir.eitaa.ui.-$$Lambda$ArticleViewer$U2HTdse6Sk5ZlXlFhUDm3Frjh60 r0 = new ir.eitaa.ui.-$$Lambda$ArticleViewer$U2HTdse6Sk5ZlXlFhUDm3Frjh60
            r1 = r22
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.lambda$processSearch$25$ArticleViewer(java.util.ArrayList, java.util.HashMap, java.lang.String, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSearch$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSearch$24$ArticleViewer(int i, ArrayList arrayList, String str) throws NoSuchFieldException, Resources.NotFoundException {
        if (i == this.lastSearchIndex) {
            this.searchPanel.setAlpha(1.0f);
            this.searchPanel.setVisibility(0);
            this.searchResults = arrayList;
            this.searchText = str;
            this.adapter[0].searchTextOffset.clear();
            this.listView[0].invalidateViews();
            scrollToSearchIndex(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void scrollToSearchIndex(int r12) throws java.lang.NoSuchFieldException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.scrollToSearchIndex(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScrollAnimated() {
        if (this.currentHeaderHeight == AndroidUtilities.dp(56.0f)) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofObject(new IntEvaluator(), Integer.valueOf(this.currentHeaderHeight), Integer.valueOf(AndroidUtilities.dp(56.0f))).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$-ATynGv7imEEEJuDPkzM16UyI3s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$checkScrollAnimated$27$ArticleViewer(valueAnimator);
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkScrollAnimated$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkScrollAnimated$27$ArticleViewer(ValueAnimator valueAnimator) {
        setCurrentHeaderHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentHeaderHeight(int newHeight) {
        if (this.searchContainer.getTag() != null) {
            return;
        }
        int iDp = AndroidUtilities.dp(56.0f);
        int iMax = Math.max(AndroidUtilities.statusBarHeight, AndroidUtilities.dp(24.0f));
        if (newHeight < iMax) {
            newHeight = iMax;
        } else if (newHeight > iDp) {
            newHeight = iDp;
        }
        float f = iDp - iMax;
        if (f == 0.0f) {
            f = 1.0f;
        }
        this.currentHeaderHeight = newHeight;
        float f2 = (((newHeight - iMax) / f) * 0.2f) + 0.8f;
        this.backButton.setScaleX(f2);
        this.backButton.setScaleY(f2);
        this.backButton.setTranslationY((iDp - this.currentHeaderHeight) / 2);
        this.menuContainer.setScaleX(f2);
        this.menuContainer.setScaleY(f2);
        this.titleTextView.setScaleX(f2);
        this.titleTextView.setScaleY(f2);
        this.lineProgressView.setScaleY((((newHeight - iMax) / f) * 0.5f) + 0.5f);
        this.menuContainer.setTranslationY((iDp - this.currentHeaderHeight) / 2);
        this.titleTextView.setTranslationY((iDp - this.currentHeaderHeight) / 2);
        this.headerView.setTranslationY(this.currentHeaderHeight - iDp);
        this.searchShadow.setTranslationY(this.currentHeaderHeight - iDp);
        int i = 0;
        this.menuButton.setAdditionalYOffset(((-(this.currentHeaderHeight - iDp)) / 2) + (Build.VERSION.SDK_INT < 21 ? AndroidUtilities.statusBarHeight : 0));
        this.textSelectionHelper.setTopOffset(this.currentHeaderHeight);
        while (true) {
            RecyclerListView[] recyclerListViewArr = this.listView;
            if (i >= recyclerListViewArr.length) {
                return;
            }
            recyclerListViewArr[i].setTopGlowOffset(this.currentHeaderHeight);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScroll(int dy) {
        setCurrentHeaderHeight(this.currentHeaderHeight - dy);
    }

    private void openPreviewsChat(TLRPC$User user, long wid) {
        if (user == null || !(this.parentActivity instanceof LaunchActivity)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("user_id", user.id);
        bundle.putString("botUser", "webpage" + wid);
        ((LaunchActivity) this.parentActivity).presentFragment(new ChatActivity(bundle), false, true);
        close(false, true);
    }

    public boolean open(MessageObject messageObject) throws NoSuchFieldException, Resources.NotFoundException {
        return open(messageObject, null, null, true);
    }

    public boolean open(TLRPC$TL_webPage webpage, String url) {
        return open(null, webpage, url, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean open(final ir.eitaa.messenger.MessageObject r12, ir.eitaa.tgnet.TLRPC$WebPage r13, java.lang.String r14, boolean r15) throws java.lang.NoSuchFieldException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.open(ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$WebPage, java.lang.String, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$open$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$open$29$ArticleViewer(final TLRPC$WebPage tLRPC$WebPage, final MessageObject messageObject, final int i, final String str, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$S3gqyxb1QzV1yUwVArOf6ftb5aE
            @Override // java.lang.Runnable
            public final void run() throws NoSuchFieldException, Resources.NotFoundException {
                this.f$0.lambda$open$28$ArticleViewer(tLObject, tLRPC$WebPage, messageObject, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$open$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$open$28$ArticleViewer(TLObject tLObject, TLRPC$WebPage tLRPC$WebPage, MessageObject messageObject, int i, String str) throws NoSuchFieldException, Resources.NotFoundException {
        TLRPC$Page tLRPC$Page;
        int i2 = 0;
        if (tLObject instanceof TLRPC$TL_webPage) {
            TLRPC$TL_webPage tLRPC$TL_webPage = (TLRPC$TL_webPage) tLObject;
            if (tLRPC$TL_webPage.cached_page == null) {
                return;
            }
            if (!this.pagesStack.isEmpty() && this.pagesStack.get(0) == tLRPC$WebPage) {
                if (messageObject != null) {
                    messageObject.messageOwner.media.webpage = tLRPC$TL_webPage;
                    TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
                    tLRPC$TL_messages_messages.messages.add(messageObject.messageOwner);
                    MessagesStorage.getInstance(i).putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, messageObject.getDialogId(), -2, 0, false, messageObject.scheduled);
                }
                this.pagesStack.set(0, tLRPC$TL_webPage);
                if (this.pagesStack.size() == 1) {
                    ApplicationLoader.applicationContext.getSharedPreferences("articles", 0).edit().remove("article" + tLRPC$TL_webPage.id).commit();
                    updateInterfaceForCurrentPage(tLRPC$TL_webPage, false, 0);
                    if (str != null) {
                        scrollToAnchor(str);
                    }
                }
            }
            LongSparseArray<TLRPC$WebPage> longSparseArray = new LongSparseArray<>(1);
            longSparseArray.put(tLRPC$TL_webPage.id, tLRPC$TL_webPage);
            MessagesStorage.getInstance(i).putWebPages(longSparseArray);
            return;
        }
        if (tLObject instanceof TLRPC$TL_webPageNotModified) {
            TLRPC$TL_webPageNotModified tLRPC$TL_webPageNotModified = (TLRPC$TL_webPageNotModified) tLObject;
            if (tLRPC$WebPage == null || (tLRPC$Page = tLRPC$WebPage.cached_page) == null) {
                return;
            }
            int i3 = tLRPC$Page.views;
            int i4 = tLRPC$TL_webPageNotModified.cached_page_views;
            if (i3 != i4) {
                tLRPC$Page.views = i4;
                tLRPC$Page.flags |= 8;
                while (true) {
                    WebpageAdapter[] webpageAdapterArr = this.adapter;
                    if (i2 >= webpageAdapterArr.length) {
                        break;
                    }
                    if (webpageAdapterArr[i2].currentPage == tLRPC$WebPage) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView[i2].findViewHolderForAdapterPosition(this.adapter[i2].getItemCount() - 1);
                        if (viewHolderFindViewHolderForAdapterPosition != null) {
                            this.adapter[i2].onViewAttachedToWindow(viewHolderFindViewHolderForAdapterPosition);
                        }
                    }
                    i2++;
                }
                if (messageObject != null) {
                    TLRPC$TL_messages_messages tLRPC$TL_messages_messages2 = new TLRPC$TL_messages_messages();
                    tLRPC$TL_messages_messages2.messages.add(messageObject.messageOwner);
                    MessagesStorage.getInstance(i).putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages2, messageObject.getDialogId(), -2, 0, false, messageObject.scheduled);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$open$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$open$30$ArticleViewer() {
        FrameLayout frameLayout = this.containerView;
        if (frameLayout == null || this.windowView == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            frameLayout.setLayerType(0, null);
        }
        this.animationInProgress = 0;
        AndroidUtilities.hideKeyboard(this.parentActivity.getCurrentFocus());
    }

    /* renamed from: ir.eitaa.ui.ArticleViewer$22, reason: invalid class name */
    class AnonymousClass22 extends AnimatorListenerAdapter {
        AnonymousClass22() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$22$1ep_h0qCa0pNzcaeTVw7oOVTX_Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0$ArticleViewer$22();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$ArticleViewer$22() {
            NotificationCenter.getInstance(ArticleViewer.this.currentAccount).onAnimationFinish(ArticleViewer.this.allowAnimationIndex);
            if (ArticleViewer.this.animationEndRunnable != null) {
                ArticleViewer.this.animationEndRunnable.run();
                ArticleViewer.this.animationEndRunnable = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$open$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$open$31$ArticleViewer(AnimatorSet animatorSet) {
        this.allowAnimationIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.allowAnimationIndex, new int[]{NotificationCenter.dialogsNeedReload, NotificationCenter.closeChats});
        animatorSet.start();
    }

    private void showProgressView(boolean useLine, final boolean show) {
        if (useLine) {
            AndroidUtilities.cancelRunOnUIThread(this.lineProgressTickRunnable);
            if (show) {
                this.lineProgressView.setProgress(0.0f, false);
                this.lineProgressView.setProgress(0.3f, true);
                AndroidUtilities.runOnUIThread(this.lineProgressTickRunnable, 100L);
                return;
            }
            this.lineProgressView.setProgress(1.0f, true);
            return;
        }
        AnimatorSet animatorSet = this.progressViewAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.progressViewAnimation = new AnimatorSet();
        if (show) {
            this.progressView.setVisibility(0);
            this.menuContainer.setEnabled(false);
            this.progressViewAnimation.playTogether(ObjectAnimator.ofFloat(this.menuButton, (Property<ActionBarMenuItem, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.menuButton, (Property<ActionBarMenuItem, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.menuButton, (Property<ActionBarMenuItem, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
        } else {
            this.menuButton.setVisibility(0);
            this.menuContainer.setEnabled(true);
            this.progressViewAnimation.playTogether(ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.menuButton, (Property<ActionBarMenuItem, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.menuButton, (Property<ActionBarMenuItem, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.menuButton, (Property<ActionBarMenuItem, Float>) View.ALPHA, 1.0f));
        }
        this.progressViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ArticleViewer.23
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ArticleViewer.this.progressViewAnimation == null || !ArticleViewer.this.progressViewAnimation.equals(animation)) {
                    return;
                }
                if (!show) {
                    ArticleViewer.this.progressView.setVisibility(4);
                } else {
                    ArticleViewer.this.menuButton.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (ArticleViewer.this.progressViewAnimation == null || !ArticleViewer.this.progressViewAnimation.equals(animation)) {
                    return;
                }
                ArticleViewer.this.progressViewAnimation = null;
            }
        });
        this.progressViewAnimation.setDuration(150L);
        this.progressViewAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCurrentPagePosition() {
        int iFindFirstVisibleItemPosition;
        if (this.adapter[0].currentPage == null || (iFindFirstVisibleItemPosition = this.layoutManager[0].findFirstVisibleItemPosition()) == -1) {
            return;
        }
        View viewFindViewByPosition = this.layoutManager[0].findViewByPosition(iFindFirstVisibleItemPosition);
        int top = viewFindViewByPosition != null ? viewFindViewByPosition.getTop() : 0;
        SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("articles", 0).edit();
        String str = "article" + this.adapter[0].currentPage.id;
        SharedPreferences.Editor editorPutInt = editorEdit.putInt(str, iFindFirstVisibleItemPosition).putInt(str + "o", top);
        String str2 = str + "r";
        Point point = AndroidUtilities.displaySize;
        editorPutInt.putBoolean(str2, point.x > point.y).commit();
    }

    private void refreshThemeColors() {
        TextView textView = this.deleteView;
        if (textView != null) {
            textView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("listSelectorSDK21"), 2));
            this.deleteView.setTextColor(Theme.getColor("actionBarDefaultSubmenuItem"));
        }
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.popupLayout;
        if (actionBarPopupWindowLayout != null) {
            actionBarPopupWindowLayout.setBackgroundColor(Theme.getColor("actionBarDefaultSubmenuBackground"));
        }
        FrameLayout frameLayout = this.searchContainer;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        }
        EditTextBoldCursor editTextBoldCursor = this.searchField;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.searchField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.searchField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        }
        ImageView imageView = this.searchUpButton;
        if (imageView != null) {
            imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
            this.searchUpButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("actionBarActionModeDefaultSelector"), 1));
        }
        ImageView imageView2 = this.searchDownButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
            this.searchDownButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("actionBarActionModeDefaultSelector"), 1));
        }
        SimpleTextView simpleTextView = this.searchCountText;
        if (simpleTextView != null) {
            simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        }
        ActionBarMenuItem actionBarMenuItem = this.menuButton;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.redrawPopup(Theme.getColor("actionBarDefaultSubmenuBackground"));
            this.menuButton.setPopupItemsColor(Theme.getColor("actionBarDefaultSubmenuItem"), false);
            this.menuButton.setPopupItemsColor(Theme.getColor("actionBarDefaultSubmenuItemIcon"), true);
        }
        ImageView imageView3 = this.clearButton;
        if (imageView3 != null) {
            imageView3.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
        }
        BackDrawable backDrawable = this.backDrawable;
        if (backDrawable != null) {
            backDrawable.setColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        }
    }

    public void close(boolean byBackPress, boolean force) {
        if (this.parentActivity == null || this.closeAnimationInProgress || !this.isVisible || checkAnimation()) {
            return;
        }
        if (this.fullscreenVideoContainer.getVisibility() == 0) {
            if (this.customView != null) {
                this.fullscreenVideoContainer.setVisibility(4);
                this.customViewCallback.onCustomViewHidden();
                this.fullscreenVideoContainer.removeView(this.customView);
                this.customView = null;
            } else {
                WebPlayerView webPlayerView = this.fullscreenedVideo;
                if (webPlayerView != null) {
                    webPlayerView.exitFullscreen();
                }
            }
            if (!force) {
                return;
            }
        }
        if (this.textSelectionHelper.isSelectionMode()) {
            this.textSelectionHelper.clear();
            return;
        }
        if (this.searchContainer.getTag() != null) {
            showSearch(false);
            return;
        }
        if (this.openUrlReqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.openUrlReqId, true);
            this.openUrlReqId = 0;
            showProgressView(true, false);
        }
        if (this.previewsReqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.previewsReqId, true);
            this.previewsReqId = 0;
            showProgressView(true, false);
        }
        saveCurrentPagePosition();
        if (byBackPress && !force && removeLastPageFromStack()) {
            return;
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
        this.parentFragment = null;
        try {
            Dialog dialog = this.visibleDialog;
            if (dialog != null) {
                dialog.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.windowView, (Property<WindowView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.containerView, (Property<FrameLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.windowView, (Property<WindowView, Float>) View.TRANSLATION_X, 0.0f, AndroidUtilities.dp(56.0f)));
        this.animationInProgress = 2;
        this.animationEndRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$pbeCqPAavGiLZ-K5olxwIe4efFQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$close$34$ArticleViewer();
            }
        };
        animatorSet.setDuration(150L);
        animatorSet.setInterpolator(this.interpolator);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ArticleViewer.26
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ArticleViewer.this.animationEndRunnable != null) {
                    ArticleViewer.this.animationEndRunnable.run();
                    ArticleViewer.this.animationEndRunnable = null;
                }
            }
        });
        this.transitionAnimationStartTime = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 18) {
            this.containerView.setLayerType(2, null);
        }
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$close$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$close$34$ArticleViewer() {
        FrameLayout frameLayout = this.containerView;
        if (frameLayout == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            frameLayout.setLayerType(0, null);
        }
        this.animationInProgress = 0;
        onClosed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClosed() {
        this.isVisible = false;
        for (int i = 0; i < this.listView.length; i++) {
            this.adapter[i].cleanup();
        }
        try {
            this.parentActivity.getWindow().clearFlags(128);
        } catch (Exception e) {
            FileLog.e(e);
        }
        for (int i2 = 0; i2 < this.createdWebViews.size(); i2++) {
            this.createdWebViews.get(i2).destroyWebView(false);
        }
        this.containerView.post(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$ee_U6MUztJS8FSR1XvBFyqjc4-Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onClosed$35$ArticleViewer();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onClosed$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onClosed$35$ArticleViewer() {
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadChannel(final BlockChannelCell cell, final WebpageAdapter adapter, TLRPC$Chat channel) {
        if (this.loadingChannel || TextUtils.isEmpty(channel.username)) {
            return;
        }
        this.loadingChannel = true;
        TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
        tLRPC$TL_contacts_resolveUsername.username = channel.username;
        final int i = UserConfig.selectedAccount;
        ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$RBdeqHl2CErA4e4TXXWvPmioi1o
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadChannel$37$ArticleViewer(adapter, i, cell, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChannel$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChannel$37$ArticleViewer(final WebpageAdapter webpageAdapter, final int i, final BlockChannelCell blockChannelCell, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$B-h1DyJcnYXGBDq7rcoTBMbVgBk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChannel$36$ArticleViewer(webpageAdapter, tLRPC$TL_error, tLObject, i, blockChannelCell);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChannel$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChannel$36$ArticleViewer(WebpageAdapter webpageAdapter, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i, BlockChannelCell blockChannelCell) {
        this.loadingChannel = false;
        if (this.parentFragment == null || webpageAdapter.blocks.isEmpty()) {
            return;
        }
        if (tLRPC$TL_error == null) {
            TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
            if (!tLRPC$TL_contacts_resolvedPeer.chats.isEmpty()) {
                MessagesController.getInstance(i).putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
                MessagesController.getInstance(i).putChats(tLRPC$TL_contacts_resolvedPeer.chats, false);
                MessagesStorage.getInstance(i).putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, false, true);
                TLRPC$Chat tLRPC$Chat = tLRPC$TL_contacts_resolvedPeer.chats.get(0);
                this.loadedChannel = tLRPC$Chat;
                if (tLRPC$Chat.left && !tLRPC$Chat.kicked) {
                    blockChannelCell.setState(0, false);
                    return;
                } else {
                    blockChannelCell.setState(4, false);
                    return;
                }
            }
            blockChannelCell.setState(4, false);
            return;
        }
        blockChannelCell.setState(4, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void joinChannel(final BlockChannelCell cell, final TLRPC$Chat channel) {
        final TLRPC$TL_channels_joinChannel tLRPC$TL_channels_joinChannel = new TLRPC$TL_channels_joinChannel();
        tLRPC$TL_channels_joinChannel.channel = MessagesController.getInputChannel(channel);
        final int i = UserConfig.selectedAccount;
        ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_channels_joinChannel, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$l6s9es7tk8ynGtMpP_KsXeAPFZ8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$joinChannel$41$ArticleViewer(cell, i, tLRPC$TL_channels_joinChannel, channel, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$joinChannel$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$joinChannel$41$ArticleViewer(final BlockChannelCell blockChannelCell, final int i, final TLRPC$TL_channels_joinChannel tLRPC$TL_channels_joinChannel, final TLRPC$Chat tLRPC$Chat, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        boolean z;
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$ZwuNINaCztqPIJhNxZAX7bTiDvg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$joinChannel$38$ArticleViewer(blockChannelCell, i, tLRPC$TL_error, tLRPC$TL_channels_joinChannel);
                }
            });
            return;
        }
        TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
        int i2 = 0;
        while (true) {
            if (i2 >= tLRPC$Updates.updates.size()) {
                z = false;
                break;
            }
            TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i2);
            if ((tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) && (((TLRPC$TL_updateNewChannelMessage) tLRPC$Update).message.action instanceof TLRPC$TL_messageActionChatAddUser)) {
                z = true;
                break;
            }
            i2++;
        }
        MessagesController.getInstance(i).processUpdates(tLRPC$Updates, false);
        if (!z) {
            MessagesController.getInstance(i).generateJoinMessage(tLRPC$Chat.id, true);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$7bvpjgrsx90K_VJgp8q8Y4nIjMs
            @Override // java.lang.Runnable
            public final void run() {
                blockChannelCell.setState(2, false);
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$KhYZLkHAPCwCS4iijYRP8Yg0MLA
            @Override // java.lang.Runnable
            public final void run() {
                MessagesController.getInstance(i).loadFullChat(tLRPC$Chat.id, 0, true);
            }
        }, 1000L);
        MessagesStorage messagesStorage = MessagesStorage.getInstance(i);
        long j = tLRPC$Chat.id;
        messagesStorage.updateDialogsWithDeletedMessages(-j, j, new ArrayList<>(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$joinChannel$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$joinChannel$38$ArticleViewer(BlockChannelCell blockChannelCell, int i, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_channels_joinChannel tLRPC$TL_channels_joinChannel) {
        blockChannelCell.setState(0, false);
        AlertsCreator.processError(i, tLRPC$TL_error, this.parentFragment, tLRPC$TL_channels_joinChannel, Boolean.TRUE);
    }

    private boolean checkAnimation() {
        if (this.animationInProgress != 0 && Math.abs(this.transitionAnimationStartTime - System.currentTimeMillis()) >= 500) {
            Runnable runnable = this.animationEndRunnable;
            if (runnable != null) {
                runnable.run();
                this.animationEndRunnable = null;
            }
            this.animationInProgress = 0;
        }
        return this.animationInProgress != 0;
    }

    public void destroyArticleViewer() {
        WindowView windowView;
        if (this.parentActivity == null || (windowView = this.windowView) == null) {
            return;
        }
        try {
            if (windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeViewImmediate(this.windowView);
            }
            this.windowView = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
        for (int i = 0; i < this.createdWebViews.size(); i++) {
            this.createdWebViews.get(i).destroyWebView(true);
        }
        this.createdWebViews.clear();
        try {
            this.parentActivity.getWindow().clearFlags(128);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        this.parentActivity = null;
        this.parentFragment = null;
        Instance = null;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void showDialog(Dialog dialog) {
        if (this.parentActivity == null) {
            return;
        }
        try {
            Dialog dialog2 = this.visibleDialog;
            if (dialog2 != null) {
                dialog2.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            this.visibleDialog = dialog;
            dialog.setCanceledOnTouchOutside(true);
            this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$0L-Bh2U1WjWuRm7-oXwxMWbuZ2M
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$showDialog$42$ArticleViewer(dialogInterface);
                }
            });
            dialog.show();
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showDialog$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showDialog$42$ArticleViewer(DialogInterface dialogInterface) {
        this.visibleDialog = null;
    }

    private static final class WebPageUtils {
        public static TLRPC$Photo getPhotoWithId(TLRPC$WebPage page, long id) {
            if (page != null && page.cached_page != null) {
                TLRPC$Photo tLRPC$Photo = page.photo;
                if (tLRPC$Photo != null && tLRPC$Photo.id == id) {
                    return tLRPC$Photo;
                }
                for (int i = 0; i < page.cached_page.photos.size(); i++) {
                    TLRPC$Photo tLRPC$Photo2 = page.cached_page.photos.get(i);
                    if (tLRPC$Photo2.id == id) {
                        return tLRPC$Photo2;
                    }
                }
            }
            return null;
        }

        public static TLRPC$Document getDocumentWithId(TLRPC$WebPage page, long id) {
            if (page != null && page.cached_page != null) {
                TLRPC$Document tLRPC$Document = page.document;
                if (tLRPC$Document != null && tLRPC$Document.id == id) {
                    return tLRPC$Document;
                }
                for (int i = 0; i < page.cached_page.documents.size(); i++) {
                    TLRPC$Document tLRPC$Document2 = page.cached_page.documents.get(i);
                    if (tLRPC$Document2.id == id) {
                        return tLRPC$Document2;
                    }
                }
            }
            return null;
        }

        public static boolean isVideo(TLRPC$WebPage page, TLRPC$PageBlock block) {
            TLRPC$Document documentWithId;
            if (!(block instanceof TLRPC$TL_pageBlockVideo) || (documentWithId = getDocumentWithId(page, ((TLRPC$TL_pageBlockVideo) block).video_id)) == null) {
                return false;
            }
            return MessageObject.isVideoDocument(documentWithId);
        }

        public static TLObject getMedia(TLRPC$WebPage page, TLRPC$PageBlock block) {
            if (block instanceof TLRPC$TL_pageBlockPhoto) {
                return getPhotoWithId(page, ((TLRPC$TL_pageBlockPhoto) block).photo_id);
            }
            if (block instanceof TLRPC$TL_pageBlockVideo) {
                return getDocumentWithId(page, ((TLRPC$TL_pageBlockVideo) block).video_id);
            }
            return null;
        }

        public static File getMediaFile(TLRPC$WebPage page, TLRPC$PageBlock block) {
            TLRPC$Document documentWithId;
            TLRPC$PhotoSize closestPhotoSizeWithSize;
            if (block instanceof TLRPC$TL_pageBlockPhoto) {
                TLRPC$Photo photoWithId = getPhotoWithId(page, ((TLRPC$TL_pageBlockPhoto) block).photo_id);
                if (photoWithId == null || (closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(photoWithId.sizes, AndroidUtilities.getPhotoSize())) == null) {
                    return null;
                }
                return FileLoader.getPathToAttach(closestPhotoSizeWithSize, true);
            }
            if (!(block instanceof TLRPC$TL_pageBlockVideo) || (documentWithId = getDocumentWithId(page, ((TLRPC$TL_pageBlockVideo) block).video_id)) == null) {
                return null;
            }
            return FileLoader.getPathToAttach(documentWithId, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class WebpageAdapter extends RecyclerListView.SelectionAdapter {
        private TLRPC$TL_pageBlockChannel channelBlock;
        private Context context;
        private TLRPC$WebPage currentPage;
        private boolean isRtl;
        private ArrayList<TLRPC$PageBlock> localBlocks = new ArrayList<>();
        private ArrayList<TLRPC$PageBlock> blocks = new ArrayList<>();
        private ArrayList<TLRPC$PageBlock> photoBlocks = new ArrayList<>();
        private HashMap<String, Integer> anchors = new HashMap<>();
        private HashMap<String, Integer> anchorsOffset = new HashMap<>();
        private HashMap<String, TLRPC$TL_textAnchor> anchorsParent = new HashMap<>();
        private HashMap<TLRPC$TL_pageBlockAudio, MessageObject> audioBlocks = new HashMap<>();
        private ArrayList<MessageObject> audioMessages = new ArrayList<>();
        private HashMap<Object, TLRPC$PageBlock> textToBlocks = new HashMap<>();
        private ArrayList<Object> textBlocks = new ArrayList<>();
        private HashMap<String, Integer> searchTextOffset = new HashMap<>();

        public WebpageAdapter(Context ctx) {
            this.context = ctx;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TLRPC$Photo getPhotoWithId(long id) {
            return WebPageUtils.getPhotoWithId(this.currentPage, id);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TLRPC$Document getDocumentWithId(long id) {
            return WebPageUtils.getDocumentWithId(this.currentPage, id);
        }

        private void setRichTextParents(TLRPC$RichText parentRichText, TLRPC$RichText richText) {
            if (richText == null) {
                return;
            }
            richText.parentRichText = parentRichText;
            if (richText instanceof TLRPC$TL_textFixed) {
                setRichTextParents(richText, ((TLRPC$TL_textFixed) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textItalic) {
                setRichTextParents(richText, ((TLRPC$TL_textItalic) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textBold) {
                setRichTextParents(richText, ((TLRPC$TL_textBold) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textUnderline) {
                setRichTextParents(richText, ((TLRPC$TL_textUnderline) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textStrike) {
                setRichTextParents(richText, ((TLRPC$TL_textStrike) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textEmail) {
                setRichTextParents(richText, ((TLRPC$TL_textEmail) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textPhone) {
                setRichTextParents(richText, ((TLRPC$TL_textPhone) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textUrl) {
                setRichTextParents(richText, ((TLRPC$TL_textUrl) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textConcat) {
                int size = richText.texts.size();
                for (int i = 0; i < size; i++) {
                    setRichTextParents(richText, richText.texts.get(i));
                }
                return;
            }
            if (richText instanceof TLRPC$TL_textSubscript) {
                setRichTextParents(richText, ((TLRPC$TL_textSubscript) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textSuperscript) {
                setRichTextParents(richText, ((TLRPC$TL_textSuperscript) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textMarked) {
                setRichTextParents(richText, ((TLRPC$TL_textMarked) richText).text);
                return;
            }
            if (richText instanceof TLRPC$TL_textAnchor) {
                TLRPC$TL_textAnchor tLRPC$TL_textAnchor = (TLRPC$TL_textAnchor) richText;
                setRichTextParents(richText, tLRPC$TL_textAnchor.text);
                String lowerCase = tLRPC$TL_textAnchor.name.toLowerCase();
                this.anchors.put(lowerCase, Integer.valueOf(this.blocks.size()));
                TLRPC$RichText tLRPC$RichText = tLRPC$TL_textAnchor.text;
                if (tLRPC$RichText instanceof TLRPC$TL_textPlain) {
                    if (!TextUtils.isEmpty(((TLRPC$TL_textPlain) tLRPC$RichText).text)) {
                        this.anchorsParent.put(lowerCase, tLRPC$TL_textAnchor);
                    }
                } else if (!(tLRPC$RichText instanceof TLRPC$TL_textEmpty)) {
                    this.anchorsParent.put(lowerCase, tLRPC$TL_textAnchor);
                }
                this.anchorsOffset.put(lowerCase, -1);
            }
        }

        private void addTextBlock(Object text, TLRPC$PageBlock block) {
            if ((text instanceof TLRPC$TL_textEmpty) || this.textToBlocks.containsKey(text)) {
                return;
            }
            this.textToBlocks.put(text, block);
            this.textBlocks.add(text);
        }

        private void setRichTextParents(TLRPC$PageBlock block) {
            if (block instanceof TLRPC$TL_pageBlockEmbedPost) {
                TLRPC$TL_pageBlockEmbedPost tLRPC$TL_pageBlockEmbedPost = (TLRPC$TL_pageBlockEmbedPost) block;
                setRichTextParents(null, tLRPC$TL_pageBlockEmbedPost.caption.text);
                setRichTextParents(null, tLRPC$TL_pageBlockEmbedPost.caption.credit);
                addTextBlock(tLRPC$TL_pageBlockEmbedPost.caption.text, tLRPC$TL_pageBlockEmbedPost);
                addTextBlock(tLRPC$TL_pageBlockEmbedPost.caption.credit, tLRPC$TL_pageBlockEmbedPost);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockParagraph) {
                TLRPC$TL_pageBlockParagraph tLRPC$TL_pageBlockParagraph = (TLRPC$TL_pageBlockParagraph) block;
                setRichTextParents(null, tLRPC$TL_pageBlockParagraph.text);
                addTextBlock(tLRPC$TL_pageBlockParagraph.text, tLRPC$TL_pageBlockParagraph);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockKicker) {
                TLRPC$TL_pageBlockKicker tLRPC$TL_pageBlockKicker = (TLRPC$TL_pageBlockKicker) block;
                setRichTextParents(null, tLRPC$TL_pageBlockKicker.text);
                addTextBlock(tLRPC$TL_pageBlockKicker.text, tLRPC$TL_pageBlockKicker);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockFooter) {
                TLRPC$TL_pageBlockFooter tLRPC$TL_pageBlockFooter = (TLRPC$TL_pageBlockFooter) block;
                setRichTextParents(null, tLRPC$TL_pageBlockFooter.text);
                addTextBlock(tLRPC$TL_pageBlockFooter.text, tLRPC$TL_pageBlockFooter);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockHeader) {
                TLRPC$TL_pageBlockHeader tLRPC$TL_pageBlockHeader = (TLRPC$TL_pageBlockHeader) block;
                setRichTextParents(null, tLRPC$TL_pageBlockHeader.text);
                addTextBlock(tLRPC$TL_pageBlockHeader.text, tLRPC$TL_pageBlockHeader);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockPreformatted) {
                TLRPC$TL_pageBlockPreformatted tLRPC$TL_pageBlockPreformatted = (TLRPC$TL_pageBlockPreformatted) block;
                setRichTextParents(null, tLRPC$TL_pageBlockPreformatted.text);
                addTextBlock(tLRPC$TL_pageBlockPreformatted.text, tLRPC$TL_pageBlockPreformatted);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockSubheader) {
                TLRPC$TL_pageBlockSubheader tLRPC$TL_pageBlockSubheader = (TLRPC$TL_pageBlockSubheader) block;
                setRichTextParents(null, tLRPC$TL_pageBlockSubheader.text);
                addTextBlock(tLRPC$TL_pageBlockSubheader.text, tLRPC$TL_pageBlockSubheader);
                return;
            }
            int i = 0;
            if (block instanceof TLRPC$TL_pageBlockSlideshow) {
                TLRPC$TL_pageBlockSlideshow tLRPC$TL_pageBlockSlideshow = (TLRPC$TL_pageBlockSlideshow) block;
                setRichTextParents(null, tLRPC$TL_pageBlockSlideshow.caption.text);
                setRichTextParents(null, tLRPC$TL_pageBlockSlideshow.caption.credit);
                addTextBlock(tLRPC$TL_pageBlockSlideshow.caption.text, tLRPC$TL_pageBlockSlideshow);
                addTextBlock(tLRPC$TL_pageBlockSlideshow.caption.credit, tLRPC$TL_pageBlockSlideshow);
                int size = tLRPC$TL_pageBlockSlideshow.items.size();
                while (i < size) {
                    setRichTextParents(tLRPC$TL_pageBlockSlideshow.items.get(i));
                    i++;
                }
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockPhoto) {
                TLRPC$TL_pageBlockPhoto tLRPC$TL_pageBlockPhoto = (TLRPC$TL_pageBlockPhoto) block;
                setRichTextParents(null, tLRPC$TL_pageBlockPhoto.caption.text);
                setRichTextParents(null, tLRPC$TL_pageBlockPhoto.caption.credit);
                addTextBlock(tLRPC$TL_pageBlockPhoto.caption.text, tLRPC$TL_pageBlockPhoto);
                addTextBlock(tLRPC$TL_pageBlockPhoto.caption.credit, tLRPC$TL_pageBlockPhoto);
                return;
            }
            if (block instanceof TL_pageBlockListItem) {
                TL_pageBlockListItem tL_pageBlockListItem = (TL_pageBlockListItem) block;
                if (tL_pageBlockListItem.textItem != null) {
                    setRichTextParents(null, tL_pageBlockListItem.textItem);
                    addTextBlock(tL_pageBlockListItem.textItem, tL_pageBlockListItem);
                    return;
                } else {
                    if (tL_pageBlockListItem.blockItem != null) {
                        setRichTextParents(tL_pageBlockListItem.blockItem);
                        return;
                    }
                    return;
                }
            }
            if (block instanceof TL_pageBlockOrderedListItem) {
                TL_pageBlockOrderedListItem tL_pageBlockOrderedListItem = (TL_pageBlockOrderedListItem) block;
                if (tL_pageBlockOrderedListItem.textItem != null) {
                    setRichTextParents(null, tL_pageBlockOrderedListItem.textItem);
                    addTextBlock(tL_pageBlockOrderedListItem.textItem, tL_pageBlockOrderedListItem);
                    return;
                } else {
                    if (tL_pageBlockOrderedListItem.blockItem != null) {
                        setRichTextParents(tL_pageBlockOrderedListItem.blockItem);
                        return;
                    }
                    return;
                }
            }
            if (block instanceof TLRPC$TL_pageBlockCollage) {
                TLRPC$TL_pageBlockCollage tLRPC$TL_pageBlockCollage = (TLRPC$TL_pageBlockCollage) block;
                setRichTextParents(null, tLRPC$TL_pageBlockCollage.caption.text);
                setRichTextParents(null, tLRPC$TL_pageBlockCollage.caption.credit);
                addTextBlock(tLRPC$TL_pageBlockCollage.caption.text, tLRPC$TL_pageBlockCollage);
                addTextBlock(tLRPC$TL_pageBlockCollage.caption.credit, tLRPC$TL_pageBlockCollage);
                int size2 = tLRPC$TL_pageBlockCollage.items.size();
                while (i < size2) {
                    setRichTextParents(tLRPC$TL_pageBlockCollage.items.get(i));
                    i++;
                }
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockEmbed) {
                TLRPC$TL_pageBlockEmbed tLRPC$TL_pageBlockEmbed = (TLRPC$TL_pageBlockEmbed) block;
                setRichTextParents(null, tLRPC$TL_pageBlockEmbed.caption.text);
                setRichTextParents(null, tLRPC$TL_pageBlockEmbed.caption.credit);
                addTextBlock(tLRPC$TL_pageBlockEmbed.caption.text, tLRPC$TL_pageBlockEmbed);
                addTextBlock(tLRPC$TL_pageBlockEmbed.caption.credit, tLRPC$TL_pageBlockEmbed);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockSubtitle) {
                TLRPC$TL_pageBlockSubtitle tLRPC$TL_pageBlockSubtitle = (TLRPC$TL_pageBlockSubtitle) block;
                setRichTextParents(null, tLRPC$TL_pageBlockSubtitle.text);
                addTextBlock(tLRPC$TL_pageBlockSubtitle.text, tLRPC$TL_pageBlockSubtitle);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockBlockquote) {
                TLRPC$TL_pageBlockBlockquote tLRPC$TL_pageBlockBlockquote = (TLRPC$TL_pageBlockBlockquote) block;
                setRichTextParents(null, tLRPC$TL_pageBlockBlockquote.text);
                setRichTextParents(null, tLRPC$TL_pageBlockBlockquote.caption);
                addTextBlock(tLRPC$TL_pageBlockBlockquote.text, tLRPC$TL_pageBlockBlockquote);
                addTextBlock(tLRPC$TL_pageBlockBlockquote.caption, tLRPC$TL_pageBlockBlockquote);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockDetails) {
                TLRPC$TL_pageBlockDetails tLRPC$TL_pageBlockDetails = (TLRPC$TL_pageBlockDetails) block;
                setRichTextParents(null, tLRPC$TL_pageBlockDetails.title);
                addTextBlock(tLRPC$TL_pageBlockDetails.title, tLRPC$TL_pageBlockDetails);
                int size3 = tLRPC$TL_pageBlockDetails.blocks.size();
                while (i < size3) {
                    setRichTextParents(tLRPC$TL_pageBlockDetails.blocks.get(i));
                    i++;
                }
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockVideo) {
                TLRPC$TL_pageBlockVideo tLRPC$TL_pageBlockVideo = (TLRPC$TL_pageBlockVideo) block;
                setRichTextParents(null, tLRPC$TL_pageBlockVideo.caption.text);
                setRichTextParents(null, tLRPC$TL_pageBlockVideo.caption.credit);
                addTextBlock(tLRPC$TL_pageBlockVideo.caption.text, tLRPC$TL_pageBlockVideo);
                addTextBlock(tLRPC$TL_pageBlockVideo.caption.credit, tLRPC$TL_pageBlockVideo);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockPullquote) {
                TLRPC$TL_pageBlockPullquote tLRPC$TL_pageBlockPullquote = (TLRPC$TL_pageBlockPullquote) block;
                setRichTextParents(null, tLRPC$TL_pageBlockPullquote.text);
                setRichTextParents(null, tLRPC$TL_pageBlockPullquote.caption);
                addTextBlock(tLRPC$TL_pageBlockPullquote.text, tLRPC$TL_pageBlockPullquote);
                addTextBlock(tLRPC$TL_pageBlockPullquote.caption, tLRPC$TL_pageBlockPullquote);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockAudio) {
                TLRPC$TL_pageBlockAudio tLRPC$TL_pageBlockAudio = (TLRPC$TL_pageBlockAudio) block;
                setRichTextParents(null, tLRPC$TL_pageBlockAudio.caption.text);
                setRichTextParents(null, tLRPC$TL_pageBlockAudio.caption.credit);
                addTextBlock(tLRPC$TL_pageBlockAudio.caption.text, tLRPC$TL_pageBlockAudio);
                addTextBlock(tLRPC$TL_pageBlockAudio.caption.credit, tLRPC$TL_pageBlockAudio);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockTable) {
                TLRPC$TL_pageBlockTable tLRPC$TL_pageBlockTable = (TLRPC$TL_pageBlockTable) block;
                setRichTextParents(null, tLRPC$TL_pageBlockTable.title);
                addTextBlock(tLRPC$TL_pageBlockTable.title, tLRPC$TL_pageBlockTable);
                int size4 = tLRPC$TL_pageBlockTable.rows.size();
                for (int i2 = 0; i2 < size4; i2++) {
                    TLRPC$TL_pageTableRow tLRPC$TL_pageTableRow = tLRPC$TL_pageBlockTable.rows.get(i2);
                    int size5 = tLRPC$TL_pageTableRow.cells.size();
                    for (int i3 = 0; i3 < size5; i3++) {
                        TLRPC$TL_pageTableCell tLRPC$TL_pageTableCell = tLRPC$TL_pageTableRow.cells.get(i3);
                        setRichTextParents(null, tLRPC$TL_pageTableCell.text);
                        addTextBlock(tLRPC$TL_pageTableCell.text, tLRPC$TL_pageBlockTable);
                    }
                }
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockTitle) {
                TLRPC$TL_pageBlockTitle tLRPC$TL_pageBlockTitle = (TLRPC$TL_pageBlockTitle) block;
                setRichTextParents(null, tLRPC$TL_pageBlockTitle.text);
                addTextBlock(tLRPC$TL_pageBlockTitle.text, tLRPC$TL_pageBlockTitle);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockCover) {
                setRichTextParents(((TLRPC$TL_pageBlockCover) block).cover);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockAuthorDate) {
                TLRPC$TL_pageBlockAuthorDate tLRPC$TL_pageBlockAuthorDate = (TLRPC$TL_pageBlockAuthorDate) block;
                setRichTextParents(null, tLRPC$TL_pageBlockAuthorDate.author);
                addTextBlock(tLRPC$TL_pageBlockAuthorDate.author, tLRPC$TL_pageBlockAuthorDate);
            } else {
                if (block instanceof TLRPC$TL_pageBlockMap) {
                    TLRPC$TL_pageBlockMap tLRPC$TL_pageBlockMap = (TLRPC$TL_pageBlockMap) block;
                    setRichTextParents(null, tLRPC$TL_pageBlockMap.caption.text);
                    setRichTextParents(null, tLRPC$TL_pageBlockMap.caption.credit);
                    addTextBlock(tLRPC$TL_pageBlockMap.caption.text, tLRPC$TL_pageBlockMap);
                    addTextBlock(tLRPC$TL_pageBlockMap.caption.credit, tLRPC$TL_pageBlockMap);
                    return;
                }
                if (block instanceof TLRPC$TL_pageBlockRelatedArticles) {
                    TLRPC$TL_pageBlockRelatedArticles tLRPC$TL_pageBlockRelatedArticles = (TLRPC$TL_pageBlockRelatedArticles) block;
                    setRichTextParents(null, tLRPC$TL_pageBlockRelatedArticles.title);
                    addTextBlock(tLRPC$TL_pageBlockRelatedArticles.title, tLRPC$TL_pageBlockRelatedArticles);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:146:0x04e2  */
        /* JADX WARN: Removed duplicated region for block: B:147:0x050c  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x052f  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x05a5 A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v14, types: [ir.eitaa.tgnet.TLRPC$PageBlock] */
        /* JADX WARN: Type inference failed for: r1v41, types: [ir.eitaa.tgnet.TLRPC$PageBlock] */
        /* JADX WARN: Type inference failed for: r24v0, types: [ir.eitaa.ui.ArticleViewer$WebpageAdapter] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void addBlock(ir.eitaa.ui.ArticleViewer.WebpageAdapter r25, ir.eitaa.tgnet.TLRPC$PageBlock r26, int r27, int r28, int r29) {
            /*
                Method dump skipped, instructions count: 1459
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.WebpageAdapter.addBlock(ir.eitaa.ui.ArticleViewer$WebpageAdapter, ir.eitaa.tgnet.TLRPC$PageBlock, int, int, int):void");
        }

        private void addAllMediaFromBlock(WebpageAdapter adapter, TLRPC$PageBlock block) {
            if (block instanceof TLRPC$TL_pageBlockPhoto) {
                TLRPC$TL_pageBlockPhoto tLRPC$TL_pageBlockPhoto = (TLRPC$TL_pageBlockPhoto) block;
                TLRPC$Photo photoWithId = getPhotoWithId(tLRPC$TL_pageBlockPhoto.photo_id);
                if (photoWithId != null) {
                    tLRPC$TL_pageBlockPhoto.thumb = FileLoader.getClosestPhotoSizeWithSize(photoWithId.sizes, 56, true);
                    tLRPC$TL_pageBlockPhoto.thumbObject = photoWithId;
                    this.photoBlocks.add(block);
                    return;
                }
                return;
            }
            if ((block instanceof TLRPC$TL_pageBlockVideo) && WebPageUtils.isVideo(adapter.currentPage, block)) {
                TLRPC$TL_pageBlockVideo tLRPC$TL_pageBlockVideo = (TLRPC$TL_pageBlockVideo) block;
                TLRPC$Document documentWithId = getDocumentWithId(tLRPC$TL_pageBlockVideo.video_id);
                if (documentWithId != null) {
                    tLRPC$TL_pageBlockVideo.thumb = FileLoader.getClosestPhotoSizeWithSize(documentWithId.thumbs, 56, true);
                    tLRPC$TL_pageBlockVideo.thumbObject = documentWithId;
                    this.photoBlocks.add(block);
                    return;
                }
                return;
            }
            int i = 0;
            if (block instanceof TLRPC$TL_pageBlockSlideshow) {
                TLRPC$TL_pageBlockSlideshow tLRPC$TL_pageBlockSlideshow = (TLRPC$TL_pageBlockSlideshow) block;
                int size = tLRPC$TL_pageBlockSlideshow.items.size();
                while (i < size) {
                    TLRPC$PageBlock tLRPC$PageBlock = tLRPC$TL_pageBlockSlideshow.items.get(i);
                    tLRPC$PageBlock.groupId = ArticleViewer.this.lastBlockNum;
                    addAllMediaFromBlock(adapter, tLRPC$PageBlock);
                    i++;
                }
                ArticleViewer.access$13008(ArticleViewer.this);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockCollage) {
                TLRPC$TL_pageBlockCollage tLRPC$TL_pageBlockCollage = (TLRPC$TL_pageBlockCollage) block;
                int size2 = tLRPC$TL_pageBlockCollage.items.size();
                while (i < size2) {
                    TLRPC$PageBlock tLRPC$PageBlock2 = tLRPC$TL_pageBlockCollage.items.get(i);
                    tLRPC$PageBlock2.groupId = ArticleViewer.this.lastBlockNum;
                    addAllMediaFromBlock(adapter, tLRPC$PageBlock2);
                    i++;
                }
                ArticleViewer.access$13008(ArticleViewer.this);
                return;
            }
            if (block instanceof TLRPC$TL_pageBlockCover) {
                addAllMediaFromBlock(adapter, ((TLRPC$TL_pageBlockCover) block).cover);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View reportCell;
            if (i != 90) {
                switch (i) {
                    case 0:
                        reportCell = ArticleViewer.this.new BlockParagraphCell(this.context, this);
                        break;
                    case 1:
                        reportCell = ArticleViewer.this.new BlockHeaderCell(this.context, this);
                        break;
                    case 2:
                        reportCell = new BlockDividerCell(this.context);
                        break;
                    case 3:
                        reportCell = ArticleViewer.this.new BlockEmbedCell(this.context, this);
                        break;
                    case 4:
                        reportCell = ArticleViewer.this.new BlockSubtitleCell(this.context, this);
                        break;
                    case 5:
                        reportCell = ArticleViewer.this.new BlockVideoCell(this.context, this, 0);
                        break;
                    case 6:
                        reportCell = ArticleViewer.this.new BlockPullquoteCell(this.context, this);
                        break;
                    case 7:
                        reportCell = ArticleViewer.this.new BlockBlockquoteCell(this.context, this);
                        break;
                    case 8:
                        reportCell = ArticleViewer.this.new BlockSlideshowCell(this.context, this);
                        break;
                    case 9:
                        reportCell = ArticleViewer.this.new BlockPhotoCell(this.context, this, 0);
                        break;
                    case 10:
                        reportCell = ArticleViewer.this.new BlockAuthorDateCell(this.context, this);
                        break;
                    case 11:
                        reportCell = ArticleViewer.this.new BlockTitleCell(this.context, this);
                        break;
                    case 12:
                        reportCell = ArticleViewer.this.new BlockListItemCell(this.context, this);
                        break;
                    case 13:
                        reportCell = ArticleViewer.this.new BlockFooterCell(this.context, this);
                        break;
                    case 14:
                        reportCell = ArticleViewer.this.new BlockPreformattedCell(this.context, this);
                        break;
                    case 15:
                        reportCell = ArticleViewer.this.new BlockSubheaderCell(this.context, this);
                        break;
                    case 16:
                        reportCell = ArticleViewer.this.new BlockEmbedPostCell(this.context, this);
                        break;
                    case 17:
                        reportCell = ArticleViewer.this.new BlockCollageCell(this.context, this);
                        break;
                    case 18:
                        reportCell = ArticleViewer.this.new BlockChannelCell(this.context, this, 0);
                        break;
                    case 19:
                        reportCell = ArticleViewer.this.new BlockAudioCell(this.context, this);
                        break;
                    case 20:
                        reportCell = ArticleViewer.this.new BlockKickerCell(this.context, this);
                        break;
                    case 21:
                        reportCell = ArticleViewer.this.new BlockOrderedListItemCell(this.context, this);
                        break;
                    case 22:
                        reportCell = ArticleViewer.this.new BlockMapCell(this.context, this, 0);
                        break;
                    case 23:
                        reportCell = ArticleViewer.this.new BlockRelatedArticlesCell(this.context, this);
                        break;
                    case 24:
                        reportCell = ArticleViewer.this.new BlockDetailsCell(this.context, this);
                        break;
                    case 25:
                        reportCell = ArticleViewer.this.new BlockTableCell(this.context, this);
                        break;
                    case 26:
                        reportCell = ArticleViewer.this.new BlockRelatedArticlesHeaderCell(this.context, this);
                        break;
                    case 27:
                        reportCell = new BlockDetailsBottomCell(this.context);
                        break;
                    case 28:
                        reportCell = new BlockRelatedArticlesShadowCell(this.context);
                        break;
                    default:
                        TextView textView = new TextView(this.context);
                        textView.setBackgroundColor(-65536);
                        textView.setTextColor(-16777216);
                        textView.setTextSize(1, 20.0f);
                        textView.setTypeface(AndroidUtilities.getFontFamily(false));
                        reportCell = textView;
                        break;
                }
            } else {
                reportCell = new ReportCell(this.context);
            }
            reportCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            reportCell.setFocusable(true);
            return new RecyclerListView.Holder(reportCell);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 23 || itemViewType == 24;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws NoSuchFieldException, Resources.NotFoundException {
            if (position < this.localBlocks.size()) {
                bindBlockToHolder(holder.getItemViewType(), holder, this.localBlocks.get(position), position, this.localBlocks.size());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 90) {
                ReportCell reportCell = (ReportCell) holder.itemView;
                TLRPC$Page tLRPC$Page = this.currentPage.cached_page;
                reportCell.setViews(tLRPC$Page != null ? tLRPC$Page.views : 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bindBlockToHolder(int type, RecyclerView.ViewHolder holder, TLRPC$PageBlock block, int position, int total) throws NoSuchFieldException, Resources.NotFoundException {
            TLRPC$PageBlock tLRPC$PageBlock;
            if (block instanceof TLRPC$TL_pageBlockCover) {
                tLRPC$PageBlock = ((TLRPC$TL_pageBlockCover) block).cover;
            } else {
                tLRPC$PageBlock = block instanceof TL_pageBlockDetailsChild ? ((TL_pageBlockDetailsChild) block).block : block;
            }
            if (type != 100) {
                switch (type) {
                    case 0:
                        ((BlockParagraphCell) holder.itemView).setBlock((TLRPC$TL_pageBlockParagraph) tLRPC$PageBlock);
                        break;
                    case 1:
                        ((BlockHeaderCell) holder.itemView).setBlock((TLRPC$TL_pageBlockHeader) tLRPC$PageBlock);
                        break;
                    case 2:
                        break;
                    case 3:
                        ((BlockEmbedCell) holder.itemView).setBlock((TLRPC$TL_pageBlockEmbed) tLRPC$PageBlock);
                        break;
                    case 4:
                        ((BlockSubtitleCell) holder.itemView).setBlock((TLRPC$TL_pageBlockSubtitle) tLRPC$PageBlock);
                        break;
                    case 5:
                        BlockVideoCell blockVideoCell = (BlockVideoCell) holder.itemView;
                        blockVideoCell.setBlock((TLRPC$TL_pageBlockVideo) tLRPC$PageBlock, position == 0, position == total - 1);
                        blockVideoCell.setParentBlock(this.channelBlock, block);
                        break;
                    case 6:
                        ((BlockPullquoteCell) holder.itemView).setBlock((TLRPC$TL_pageBlockPullquote) tLRPC$PageBlock);
                        break;
                    case 7:
                        ((BlockBlockquoteCell) holder.itemView).setBlock((TLRPC$TL_pageBlockBlockquote) tLRPC$PageBlock);
                        break;
                    case 8:
                        ((BlockSlideshowCell) holder.itemView).setBlock((TLRPC$TL_pageBlockSlideshow) tLRPC$PageBlock);
                        break;
                    case 9:
                        BlockPhotoCell blockPhotoCell = (BlockPhotoCell) holder.itemView;
                        blockPhotoCell.setBlock((TLRPC$TL_pageBlockPhoto) tLRPC$PageBlock, position == 0, position == total - 1);
                        blockPhotoCell.setParentBlock(block);
                        break;
                    case 10:
                        ((BlockAuthorDateCell) holder.itemView).setBlock((TLRPC$TL_pageBlockAuthorDate) tLRPC$PageBlock);
                        break;
                    case 11:
                        ((BlockTitleCell) holder.itemView).setBlock((TLRPC$TL_pageBlockTitle) tLRPC$PageBlock);
                        break;
                    case 12:
                        ((BlockListItemCell) holder.itemView).setBlock((TL_pageBlockListItem) tLRPC$PageBlock);
                        break;
                    case 13:
                        ((BlockFooterCell) holder.itemView).setBlock((TLRPC$TL_pageBlockFooter) tLRPC$PageBlock);
                        break;
                    case 14:
                        ((BlockPreformattedCell) holder.itemView).setBlock((TLRPC$TL_pageBlockPreformatted) tLRPC$PageBlock);
                        break;
                    case 15:
                        ((BlockSubheaderCell) holder.itemView).setBlock((TLRPC$TL_pageBlockSubheader) tLRPC$PageBlock);
                        break;
                    case 16:
                        ((BlockEmbedPostCell) holder.itemView).setBlock((TLRPC$TL_pageBlockEmbedPost) tLRPC$PageBlock);
                        break;
                    case 17:
                        ((BlockCollageCell) holder.itemView).setBlock((TLRPC$TL_pageBlockCollage) tLRPC$PageBlock);
                        break;
                    case 18:
                        ((BlockChannelCell) holder.itemView).setBlock((TLRPC$TL_pageBlockChannel) tLRPC$PageBlock);
                        break;
                    case 19:
                        ((BlockAudioCell) holder.itemView).setBlock((TLRPC$TL_pageBlockAudio) tLRPC$PageBlock, position == 0, position == total - 1);
                        break;
                    case 20:
                        ((BlockKickerCell) holder.itemView).setBlock((TLRPC$TL_pageBlockKicker) tLRPC$PageBlock);
                        break;
                    case 21:
                        ((BlockOrderedListItemCell) holder.itemView).setBlock((TL_pageBlockOrderedListItem) tLRPC$PageBlock);
                        break;
                    case 22:
                        ((BlockMapCell) holder.itemView).setBlock((TLRPC$TL_pageBlockMap) tLRPC$PageBlock, position == 0, position == total - 1);
                        break;
                    case 23:
                        ((BlockRelatedArticlesCell) holder.itemView).setBlock((TL_pageBlockRelatedArticlesChild) tLRPC$PageBlock);
                        break;
                    case 24:
                        ((BlockDetailsCell) holder.itemView).setBlock((TLRPC$TL_pageBlockDetails) tLRPC$PageBlock);
                        break;
                    case 25:
                        ((BlockTableCell) holder.itemView).setBlock((TLRPC$TL_pageBlockTable) tLRPC$PageBlock);
                        break;
                    case 26:
                        ((BlockRelatedArticlesHeaderCell) holder.itemView).setBlock((TLRPC$TL_pageBlockRelatedArticles) tLRPC$PageBlock);
                        break;
                    case 27:
                        break;
                }
            }
            ((TextView) holder.itemView).setText("unsupported block " + tLRPC$PageBlock);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTypeForBlock(TLRPC$PageBlock block) {
            if (block instanceof TLRPC$TL_pageBlockParagraph) {
                return 0;
            }
            if (block instanceof TLRPC$TL_pageBlockHeader) {
                return 1;
            }
            if (block instanceof TLRPC$TL_pageBlockDivider) {
                return 2;
            }
            if (block instanceof TLRPC$TL_pageBlockEmbed) {
                return 3;
            }
            if (block instanceof TLRPC$TL_pageBlockSubtitle) {
                return 4;
            }
            if (block instanceof TLRPC$TL_pageBlockVideo) {
                return 5;
            }
            if (block instanceof TLRPC$TL_pageBlockPullquote) {
                return 6;
            }
            if (block instanceof TLRPC$TL_pageBlockBlockquote) {
                return 7;
            }
            if (block instanceof TLRPC$TL_pageBlockSlideshow) {
                return 8;
            }
            if (block instanceof TLRPC$TL_pageBlockPhoto) {
                return 9;
            }
            if (block instanceof TLRPC$TL_pageBlockAuthorDate) {
                return 10;
            }
            if (block instanceof TLRPC$TL_pageBlockTitle) {
                return 11;
            }
            if (block instanceof TL_pageBlockListItem) {
                return 12;
            }
            if (block instanceof TLRPC$TL_pageBlockFooter) {
                return 13;
            }
            if (block instanceof TLRPC$TL_pageBlockPreformatted) {
                return 14;
            }
            if (block instanceof TLRPC$TL_pageBlockSubheader) {
                return 15;
            }
            if (block instanceof TLRPC$TL_pageBlockEmbedPost) {
                return 16;
            }
            if (block instanceof TLRPC$TL_pageBlockCollage) {
                return 17;
            }
            if (block instanceof TLRPC$TL_pageBlockChannel) {
                return 18;
            }
            if (block instanceof TLRPC$TL_pageBlockAudio) {
                return 19;
            }
            if (block instanceof TLRPC$TL_pageBlockKicker) {
                return 20;
            }
            if (block instanceof TL_pageBlockOrderedListItem) {
                return 21;
            }
            if (block instanceof TLRPC$TL_pageBlockMap) {
                return 22;
            }
            if (block instanceof TL_pageBlockRelatedArticlesChild) {
                return 23;
            }
            if (block instanceof TLRPC$TL_pageBlockDetails) {
                return 24;
            }
            if (block instanceof TLRPC$TL_pageBlockTable) {
                return 25;
            }
            if (block instanceof TLRPC$TL_pageBlockRelatedArticles) {
                return 26;
            }
            if (block instanceof TL_pageBlockRelatedArticlesShadow) {
                return 28;
            }
            if (block instanceof TL_pageBlockDetailsChild) {
                return getTypeForBlock(((TL_pageBlockDetailsChild) block).block);
            }
            if (block instanceof TLRPC$TL_pageBlockCover) {
                return getTypeForBlock(((TLRPC$TL_pageBlockCover) block).cover);
            }
            return 100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == this.localBlocks.size()) {
                return 90;
            }
            return getTypeForBlock(this.localBlocks.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            TLRPC$WebPage tLRPC$WebPage = this.currentPage;
            if (tLRPC$WebPage == null || tLRPC$WebPage.cached_page == null) {
                return 0;
            }
            return this.localBlocks.size() + 1;
        }

        private boolean isBlockOpened(TL_pageBlockDetailsChild child) {
            TLRPC$PageBlock lastNonListPageBlock = ArticleViewer.this.getLastNonListPageBlock(child.parent);
            if (lastNonListPageBlock instanceof TLRPC$TL_pageBlockDetails) {
                return ((TLRPC$TL_pageBlockDetails) lastNonListPageBlock).open;
            }
            if (!(lastNonListPageBlock instanceof TL_pageBlockDetailsChild)) {
                return false;
            }
            TL_pageBlockDetailsChild tL_pageBlockDetailsChild = (TL_pageBlockDetailsChild) lastNonListPageBlock;
            TLRPC$PageBlock lastNonListPageBlock2 = ArticleViewer.this.getLastNonListPageBlock(tL_pageBlockDetailsChild.block);
            if (!(lastNonListPageBlock2 instanceof TLRPC$TL_pageBlockDetails) || ((TLRPC$TL_pageBlockDetails) lastNonListPageBlock2).open) {
                return isBlockOpened(tL_pageBlockDetailsChild);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateRows() {
            this.localBlocks.clear();
            int size = this.blocks.size();
            for (int i = 0; i < size; i++) {
                TLRPC$PageBlock tLRPC$PageBlock = this.blocks.get(i);
                TLRPC$PageBlock lastNonListPageBlock = ArticleViewer.this.getLastNonListPageBlock(tLRPC$PageBlock);
                if (!(lastNonListPageBlock instanceof TL_pageBlockDetailsChild) || isBlockOpened((TL_pageBlockDetailsChild) lastNonListPageBlock)) {
                    this.localBlocks.add(tLRPC$PageBlock);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanup() {
            this.currentPage = null;
            this.blocks.clear();
            this.photoBlocks.clear();
            this.audioBlocks.clear();
            this.audioMessages.clear();
            this.anchors.clear();
            this.anchorsParent.clear();
            this.anchorsOffset.clear();
            this.textBlocks.clear();
            this.textToBlocks.clear();
            this.channelBlock = null;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            updateRows();
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemChanged(int position) {
            updateRows();
            super.notifyItemChanged(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeChanged(int positionStart, int itemCount, Object payload) {
            updateRows();
            super.notifyItemRangeChanged(positionStart, itemCount, payload);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemMoved(int fromPosition, int toPosition) {
            updateRows();
            super.notifyItemMoved(fromPosition, toPosition);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeInserted(int positionStart, int itemCount) {
            updateRows();
            super.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRemoved(int position) {
            updateRows();
            super.notifyItemRemoved(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeRemoved(int positionStart, int itemCount) {
            updateRows();
            super.notifyItemRangeRemoved(positionStart, itemCount);
        }
    }

    private class BlockVideoCell extends FrameLayout implements DownloadController.FileDownloadProgressListener, TextSelectionHelper.ArticleSelectableView {
        private int TAG;
        private boolean autoDownload;
        private int buttonPressed;
        private int buttonState;
        private int buttonX;
        private int buttonY;
        private boolean cancelLoading;
        private DrawingText captionLayout;
        private BlockChannelCell channelCell;
        private DrawingText creditLayout;
        private int creditOffset;
        private TLRPC$TL_pageBlockVideo currentBlock;
        private TLRPC$Document currentDocument;
        private int currentType;
        private MessageObject.GroupedMessagePosition groupPosition;
        private ImageReceiver imageView;
        private boolean isFirst;
        private boolean isGif;
        private WebpageAdapter parentAdapter;
        private TLRPC$PageBlock parentBlock;
        private boolean photoPressed;
        private RadialProgress2 radialProgress;
        private int textX;
        private int textY;

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
        }

        public BlockVideoCell(Context context, WebpageAdapter adapter, int type) {
            super(context);
            this.parentAdapter = adapter;
            setWillNotDraw(false);
            ImageReceiver imageReceiver = new ImageReceiver(this);
            this.imageView = imageReceiver;
            imageReceiver.setNeedsQualityThumb(true);
            this.imageView.setShouldGenerateQualityThumb(true);
            this.currentType = type;
            RadialProgress2 radialProgress2 = new RadialProgress2(this);
            this.radialProgress = radialProgress2;
            radialProgress2.setProgressColor(-1);
            this.radialProgress.setColors(1711276032, 2130706432, -1, -2500135);
            this.TAG = DownloadController.getInstance(ArticleViewer.this.currentAccount).generateObserverTag();
            BlockChannelCell blockChannelCell = ArticleViewer.this.new BlockChannelCell(context, this.parentAdapter, 1);
            this.channelCell = blockChannelCell;
            addView(blockChannelCell, LayoutHelper.createFrame(-1, -2.0f));
        }

        public void setBlock(TLRPC$TL_pageBlockVideo block, boolean first, boolean last) {
            this.currentBlock = block;
            this.parentBlock = null;
            TLRPC$Document documentWithId = this.parentAdapter.getDocumentWithId(block.video_id);
            this.currentDocument = documentWithId;
            this.isGif = MessageObject.isGifDocument(documentWithId);
            this.isFirst = first;
            this.channelCell.setVisibility(4);
            updateButtonState(false);
            requestLayout();
        }

        public void setParentBlock(TLRPC$TL_pageBlockChannel channelBlock, TLRPC$PageBlock block) {
            this.parentBlock = block;
            if (channelBlock == null || !(block instanceof TLRPC$TL_pageBlockCover)) {
                return;
            }
            this.channelCell.setBlock(channelBlock);
            this.channelCell.setVisibility(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r13) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 282
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockVideoCell.onTouchEvent(android.view.MotionEvent):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01f2  */
        @Override // android.widget.FrameLayout, android.view.View
        @android.annotation.SuppressLint({"NewApi"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r31, int r32) {
            /*
                Method dump skipped, instructions count: 844
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockVideoCell.onMeasure(int, int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            if (this.currentBlock == null) {
                return;
            }
            if (!this.imageView.hasBitmapImage() || this.imageView.getCurrentAlpha() != 1.0f) {
                canvas.drawRect(this.imageView.getDrawRegion(), ArticleViewer.photoBackgroundPaint);
            }
            if (!ArticleViewer.this.pinchToZoomHelper.isInOverlayModeFor(this)) {
                this.imageView.draw(canvas);
                if (this.imageView.getVisible()) {
                    this.radialProgress.draw(canvas);
                }
            }
            if (this.captionLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                i = 1;
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.captionLayout.draw(canvas);
                canvas.restore();
            } else {
                i = 0;
            }
            if (this.creditLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY + this.creditOffset);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.creditLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        private int getIconForCurrentState() {
            int i = this.buttonState;
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 0 : 4;
        }

        public void updateButtonState(boolean animated) {
            String attachFileName = FileLoader.getAttachFileName(this.currentDocument);
            boolean z = true;
            boolean zExists = FileLoader.getPathToAttach(this.currentDocument, true).exists();
            if (TextUtils.isEmpty(attachFileName)) {
                this.radialProgress.setIcon(4, false, false);
                return;
            }
            if (zExists) {
                DownloadController.getInstance(ArticleViewer.this.currentAccount).removeLoadingFileObserver(this);
                if (!this.isGif) {
                    this.buttonState = 3;
                } else {
                    this.buttonState = -1;
                }
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
            } else {
                DownloadController.getInstance(ArticleViewer.this.currentAccount).addLoadingFileObserver(attachFileName, null, this);
                float fFloatValue = 0.0f;
                if (!FileLoader.getInstance(ArticleViewer.this.currentAccount).isLoadingFile(attachFileName)) {
                    if (!this.cancelLoading && this.autoDownload && this.isGif) {
                        this.buttonState = 1;
                    } else {
                        this.buttonState = 0;
                        z = false;
                    }
                } else {
                    this.buttonState = 1;
                    Float fileProgress = ImageLoader.getInstance().getFileProgress(attachFileName);
                    if (fileProgress != null) {
                        fFloatValue = fileProgress.floatValue();
                    }
                }
                this.radialProgress.setIcon(getIconForCurrentState(), z, animated);
                this.radialProgress.setProgress(fFloatValue, false);
            }
            invalidate();
        }

        private void didPressedButton(boolean animated) throws Resources.NotFoundException {
            int i = this.buttonState;
            if (i == 0) {
                this.cancelLoading = false;
                this.radialProgress.setProgress(0.0f, false);
                if (!this.isGif) {
                    FileLoader.getInstance(ArticleViewer.this.currentAccount).loadFile(this.currentDocument, this.parentAdapter.currentPage, 1, 1);
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(this.currentDocument), null, ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(this.currentDocument.thumbs, 40), this.currentDocument), "80_80_b", this.currentDocument.size, null, this.parentAdapter.currentPage, 1);
                }
                this.buttonState = 1;
                this.radialProgress.setIcon(getIconForCurrentState(), true, animated);
                invalidate();
                return;
            }
            if (i == 1) {
                this.cancelLoading = true;
                if (!this.isGif) {
                    FileLoader.getInstance(ArticleViewer.this.currentAccount).cancelLoadFile(this.currentDocument);
                } else {
                    this.imageView.cancelLoadImage();
                }
                this.buttonState = 0;
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
                invalidate();
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    ArticleViewer.this.openPhoto(this.currentBlock, this.parentAdapter);
                }
            } else {
                this.imageView.setAllowStartAnimation(true);
                this.imageView.startAnimation();
                this.buttonState = -1;
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.imageView.onDetachedFromWindow();
            DownloadController.getInstance(ArticleViewer.this.currentAccount).removeLoadingFileObserver(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.imageView.onAttachedToWindow();
            updateButtonState(false);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onFailedDownload(String fileName, boolean canceled) {
            updateButtonState(false);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onSuccessDownload(String fileName) throws Resources.NotFoundException {
            this.radialProgress.setProgress(1.0f, true);
            if (this.isGif) {
                this.buttonState = 2;
                didPressedButton(true);
            } else {
                updateButtonState(true);
            }
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onProgressDownload(String fileName, long downloadSize, long totalSize) {
            this.radialProgress.setProgress(Math.min(1.0f, downloadSize / totalSize), true);
            if (this.buttonState != 1) {
                updateButtonState(true);
            }
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public int getObserverTag() {
            return this.TAG;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            StringBuilder sb = new StringBuilder(LocaleController.getString("AttachVideo", R.string.AttachVideo));
            if (this.captionLayout != null) {
                sb.append(", ");
                sb.append(this.captionLayout.getText());
            }
            info.setText(sb.toString());
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.captionLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.creditLayout;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class BlockAudioCell extends View implements DownloadController.FileDownloadProgressListener, TextSelectionHelper.ArticleSelectableView {
        private int TAG;
        private int buttonPressed;
        private int buttonState;
        private int buttonX;
        private int buttonY;
        private DrawingText captionLayout;
        private DrawingText creditLayout;
        private int creditOffset;
        private TLRPC$TL_pageBlockAudio currentBlock;
        private TLRPC$Document currentDocument;
        private MessageObject currentMessageObject;
        private StaticLayout durationLayout;
        private boolean isFirst;
        private String lastTimeString;
        private WebpageAdapter parentAdapter;
        private RadialProgress2 radialProgress;
        private SeekBar seekBar;
        private int seekBarX;
        private int seekBarY;
        private int textX;
        private int textY;
        private DrawingText titleLayout;

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
        }

        public BlockAudioCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textY = AndroidUtilities.dp(58.0f);
            this.parentAdapter = adapter;
            RadialProgress2 radialProgress2 = new RadialProgress2(this);
            this.radialProgress = radialProgress2;
            radialProgress2.setCircleRadius(AndroidUtilities.dp(24.0f));
            this.TAG = DownloadController.getInstance(ArticleViewer.this.currentAccount).generateObserverTag();
            SeekBar seekBar = new SeekBar(this);
            this.seekBar = seekBar;
            seekBar.setDelegate(new SeekBar.SeekBarDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$BlockAudioCell$Spr5OrNWafRY9-UD5l1-4a20MNk
                @Override // ir.eitaa.ui.Components.SeekBar.SeekBarDelegate
                public /* synthetic */ void onSeekBarContinuousDrag(float f) {
                    SeekBar.SeekBarDelegate.CC.$default$onSeekBarContinuousDrag(this, f);
                }

                @Override // ir.eitaa.ui.Components.SeekBar.SeekBarDelegate
                public final void onSeekBarDrag(float f) {
                    this.f$0.lambda$new$0$ArticleViewer$BlockAudioCell(f);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ArticleViewer$BlockAudioCell(float f) {
            MessageObject messageObject = this.currentMessageObject;
            if (messageObject == null) {
                return;
            }
            messageObject.audioProgress = f;
            MediaController.getInstance().seekToProgress(this.currentMessageObject, f);
        }

        public void setBlock(TLRPC$TL_pageBlockAudio block, boolean first, boolean last) {
            this.currentBlock = block;
            MessageObject messageObject = (MessageObject) this.parentAdapter.audioBlocks.get(this.currentBlock);
            this.currentMessageObject = messageObject;
            if (messageObject != null) {
                this.currentDocument = messageObject.getDocument();
            }
            this.isFirst = first;
            this.seekBar.setColors(Theme.getColor("chat_inAudioSeekbar"), Theme.getColor("chat_inAudioCacheSeekbar"), Theme.getColor("chat_inAudioSeekbarFill"), Theme.getColor("chat_inAudioSeekbarFill"), Theme.getColor("chat_inAudioSeekbarSelected"));
            updateButtonState(false);
            requestLayout();
        }

        public MessageObject getMessageObject() {
            return this.currentMessageObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r13) {
            /*
                r12 = this;
                float r0 = r13.getX()
                float r1 = r13.getY()
                ir.eitaa.ui.Components.SeekBar r2 = r12.seekBar
                int r3 = r13.getAction()
                float r4 = r13.getX()
                int r5 = r12.seekBarX
                float r5 = (float) r5
                float r4 = r4 - r5
                float r5 = r13.getY()
                int r6 = r12.seekBarY
                float r6 = (float) r6
                float r5 = r5 - r6
                boolean r2 = r2.onTouch(r3, r4, r5)
                r3 = 1
                if (r2 == 0) goto L36
                int r13 = r13.getAction()
                if (r13 != 0) goto L32
                android.view.ViewParent r13 = r12.getParent()
                r13.requestDisallowInterceptTouchEvent(r3)
            L32:
                r12.invalidate()
                return r3
            L36:
                int r2 = r13.getAction()
                r4 = 0
                if (r2 != 0) goto L70
                int r2 = r12.buttonState
                r5 = -1
                if (r2 == r5) goto L66
                int r2 = r12.buttonX
                float r5 = (float) r2
                int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r5 < 0) goto L66
                r5 = 1111490560(0x42400000, float:48.0)
                int r6 = ir.eitaa.messenger.AndroidUtilities.dp(r5)
                int r2 = r2 + r6
                float r2 = (float) r2
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 > 0) goto L66
                int r0 = r12.buttonY
                float r2 = (float) r0
                int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r2 < 0) goto L66
                int r2 = ir.eitaa.messenger.AndroidUtilities.dp(r5)
                int r0 = r0 + r2
                float r0 = (float) r0
                int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                if (r0 <= 0) goto L6a
            L66:
                int r0 = r12.buttonState
                if (r0 != 0) goto L8f
            L6a:
                r12.buttonPressed = r3
                r12.invalidate()
                goto L8f
            L70:
                int r0 = r13.getAction()
                if (r0 != r3) goto L86
                int r0 = r12.buttonPressed
                if (r0 != r3) goto L8f
                r12.buttonPressed = r4
                r12.playSoundEffect(r4)
                r12.didPressedButton(r3)
                r12.invalidate()
                goto L8f
            L86:
                int r0 = r13.getAction()
                r1 = 3
                if (r0 != r1) goto L8f
                r12.buttonPressed = r4
            L8f:
                int r0 = r12.buttonPressed
                if (r0 != 0) goto Lc3
                ir.eitaa.ui.ArticleViewer r5 = ir.eitaa.ui.ArticleViewer.this
                ir.eitaa.ui.ArticleViewer$WebpageAdapter r6 = r12.parentAdapter
                ir.eitaa.ui.ArticleViewer$DrawingText r9 = r12.captionLayout
                int r10 = r12.textX
                int r11 = r12.textY
                r7 = r13
                r8 = r12
                boolean r0 = ir.eitaa.ui.ArticleViewer.access$8700(r5, r6, r7, r8, r9, r10, r11)
                if (r0 != 0) goto Lc3
                ir.eitaa.ui.ArticleViewer r5 = ir.eitaa.ui.ArticleViewer.this
                ir.eitaa.ui.ArticleViewer$WebpageAdapter r6 = r12.parentAdapter
                ir.eitaa.ui.ArticleViewer$DrawingText r9 = r12.creditLayout
                int r10 = r12.textX
                int r0 = r12.textY
                int r1 = r12.creditOffset
                int r11 = r0 + r1
                r7 = r13
                r8 = r12
                boolean r0 = ir.eitaa.ui.ArticleViewer.access$8700(r5, r6, r7, r8, r9, r10, r11)
                if (r0 != 0) goto Lc3
                boolean r13 = super.onTouchEvent(r13)
                if (r13 == 0) goto Lc2
                goto Lc3
            Lc2:
                r3 = 0
            Lc3:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockAudioCell.onTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.View
        @SuppressLint({"DrawAllocation", "NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            SpannableStringBuilder spannableStringBuilder;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int iDp = AndroidUtilities.dp(54.0f);
            TLRPC$TL_pageBlockAudio tLRPC$TL_pageBlockAudio = this.currentBlock;
            int i = 1;
            if (tLRPC$TL_pageBlockAudio != null) {
                if (tLRPC$TL_pageBlockAudio.level > 0) {
                    this.textX = AndroidUtilities.dp(r0 * 14) + AndroidUtilities.dp(18.0f);
                } else {
                    this.textX = AndroidUtilities.dp(18.0f);
                }
                int iDp2 = (size - this.textX) - AndroidUtilities.dp(18.0f);
                int iDp3 = AndroidUtilities.dp(44.0f);
                this.buttonX = AndroidUtilities.dp(16.0f);
                int iDp4 = AndroidUtilities.dp(5.0f);
                this.buttonY = iDp4;
                RadialProgress2 radialProgress2 = this.radialProgress;
                int i2 = this.buttonX;
                radialProgress2.setProgressRect(i2, iDp4, i2 + iDp3, iDp4 + iDp3);
                ArticleViewer articleViewer = ArticleViewer.this;
                TLRPC$TL_pageBlockAudio tLRPC$TL_pageBlockAudio2 = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText = articleViewer.createLayoutForText(this, null, tLRPC$TL_pageBlockAudio2.caption.text, iDp2, this.textY, tLRPC$TL_pageBlockAudio2, this.parentAdapter);
                this.captionLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    int iDp5 = AndroidUtilities.dp(8.0f) + this.captionLayout.getHeight();
                    this.creditOffset = iDp5;
                    iDp += iDp5 + AndroidUtilities.dp(8.0f);
                }
                int iDp6 = iDp;
                ArticleViewer articleViewer2 = ArticleViewer.this;
                TLRPC$TL_pageBlockAudio tLRPC$TL_pageBlockAudio3 = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText2 = articleViewer2.createLayoutForText(this, null, tLRPC$TL_pageBlockAudio3.caption.credit, iDp2, this.textY + this.creditOffset, tLRPC$TL_pageBlockAudio3, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.creditLayout = drawingTextCreateLayoutForText2;
                if (drawingTextCreateLayoutForText2 != null) {
                    iDp6 += AndroidUtilities.dp(4.0f) + this.creditLayout.getHeight();
                }
                if (!this.isFirst && this.currentBlock.level <= 0) {
                    iDp6 += AndroidUtilities.dp(8.0f);
                }
                String musicAuthor = this.currentMessageObject.getMusicAuthor(false);
                String musicTitle = this.currentMessageObject.getMusicTitle(false);
                int iDp7 = this.buttonX + AndroidUtilities.dp(50.0f) + iDp3;
                this.seekBarX = iDp7;
                int iDp8 = (size - iDp7) - AndroidUtilities.dp(18.0f);
                if (!TextUtils.isEmpty(musicTitle) || !TextUtils.isEmpty(musicAuthor)) {
                    if (!TextUtils.isEmpty(musicTitle) && !TextUtils.isEmpty(musicAuthor)) {
                        spannableStringBuilder = new SpannableStringBuilder(String.format("%s - %s", musicAuthor, musicTitle));
                    } else if (!TextUtils.isEmpty(musicTitle)) {
                        spannableStringBuilder = new SpannableStringBuilder(musicTitle);
                    } else {
                        spannableStringBuilder = new SpannableStringBuilder(musicAuthor);
                    }
                    if (!TextUtils.isEmpty(musicAuthor)) {
                        spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getFontFamily(true)), 0, musicAuthor.length(), 18);
                    }
                    CharSequence charSequenceEllipsize = TextUtils.ellipsize(spannableStringBuilder, Theme.chat_audioTitlePaint, iDp8, TextUtils.TruncateAt.END);
                    DrawingText drawingText = ArticleViewer.this.new DrawingText();
                    this.titleLayout = drawingText;
                    drawingText.textLayout = new StaticLayout(charSequenceEllipsize, ArticleViewer.audioTimePaint, iDp8, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    this.titleLayout.parentBlock = this.currentBlock;
                    this.seekBarY = this.buttonY + ((iDp3 - AndroidUtilities.dp(30.0f)) / 2) + AndroidUtilities.dp(11.0f);
                } else {
                    this.titleLayout = null;
                    this.seekBarY = this.buttonY + ((iDp3 - AndroidUtilities.dp(30.0f)) / 2);
                }
                this.seekBar.setSize(iDp8, AndroidUtilities.dp(30.0f));
                i = iDp6;
            }
            setMeasuredDimension(size, i);
            updatePlayingMessageProgress();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            if (this.currentBlock == null) {
                return;
            }
            this.radialProgress.setColors("chat_inLoader", "chat_inLoaderSelected", "chat_inMediaIcon", "chat_inMediaIconSelected");
            this.radialProgress.setProgressColor(Theme.getColor("chat_inFileProgress"));
            this.radialProgress.draw(canvas);
            canvas.save();
            canvas.translate(this.seekBarX, this.seekBarY);
            this.seekBar.draw(canvas);
            canvas.restore();
            if (this.durationLayout != null) {
                canvas.save();
                canvas.translate(this.buttonX + AndroidUtilities.dp(54.0f), this.seekBarY + AndroidUtilities.dp(6.0f));
                this.durationLayout.draw(canvas);
                canvas.restore();
            }
            if (this.titleLayout != null) {
                canvas.save();
                this.titleLayout.x = this.buttonX + AndroidUtilities.dp(54.0f);
                this.titleLayout.y = this.seekBarY - AndroidUtilities.dp(16.0f);
                DrawingText drawingText = this.titleLayout;
                canvas.translate(drawingText.x, drawingText.y);
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.titleLayout.draw(canvas);
                canvas.restore();
                i = 1;
            } else {
                i = 0;
            }
            if (this.captionLayout != null) {
                canvas.save();
                DrawingText drawingText2 = this.captionLayout;
                int i2 = this.textX;
                drawingText2.x = i2;
                int i3 = this.textY;
                drawingText2.y = i3;
                canvas.translate(i2, i3);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.captionLayout.draw(canvas);
                canvas.restore();
                i++;
            }
            if (this.creditLayout != null) {
                canvas.save();
                DrawingText drawingText3 = this.creditLayout;
                int i4 = this.textX;
                drawingText3.x = i4;
                drawingText3.y = this.textY + this.creditOffset;
                canvas.translate(i4, r5 + r6);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.creditLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        private int getIconForCurrentState() {
            int i = this.buttonState;
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
            return i == 3 ? 3 : 0;
        }

        public void updatePlayingMessageProgress() {
            if (this.currentDocument == null || this.currentMessageObject == null) {
                return;
            }
            if (!this.seekBar.isDragging()) {
                this.seekBar.setProgress(this.currentMessageObject.audioProgress);
            }
            int i = 0;
            if (!MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.currentDocument.attributes.size()) {
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.currentDocument.attributes.get(i2);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                        i = tLRPC$DocumentAttribute.duration;
                        break;
                    }
                    i2++;
                }
            } else {
                i = this.currentMessageObject.audioProgressSec;
            }
            String shortDuration = AndroidUtilities.formatShortDuration(i);
            String str = this.lastTimeString;
            if (str == null || (str != null && !str.equals(shortDuration))) {
                this.lastTimeString = shortDuration;
                ArticleViewer.audioTimePaint.setTextSize(AndroidUtilities.dp(16.0f));
                this.durationLayout = new StaticLayout(shortDuration, ArticleViewer.audioTimePaint, (int) Math.ceil(ArticleViewer.audioTimePaint.measureText(shortDuration)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            ArticleViewer.audioTimePaint.setColor(ArticleViewer.this.getTextColor());
            invalidate();
        }

        public void updateButtonState(boolean animated) {
            String attachFileName = FileLoader.getAttachFileName(this.currentDocument);
            boolean zExists = FileLoader.getPathToAttach(this.currentDocument, true).exists();
            if (TextUtils.isEmpty(attachFileName)) {
                this.radialProgress.setIcon(4, false, false);
                return;
            }
            if (zExists) {
                DownloadController.getInstance(ArticleViewer.this.currentAccount).removeLoadingFileObserver(this);
                boolean zIsPlayingMessage = MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
                if (!zIsPlayingMessage || (zIsPlayingMessage && MediaController.getInstance().isMessagePaused())) {
                    this.buttonState = 0;
                } else {
                    this.buttonState = 1;
                }
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
            } else {
                DownloadController.getInstance(ArticleViewer.this.currentAccount).addLoadingFileObserver(attachFileName, null, this);
                if (!FileLoader.getInstance(ArticleViewer.this.currentAccount).isLoadingFile(attachFileName)) {
                    this.buttonState = 2;
                    this.radialProgress.setProgress(0.0f, animated);
                    this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
                } else {
                    this.buttonState = 3;
                    Float fileProgress = ImageLoader.getInstance().getFileProgress(attachFileName);
                    if (fileProgress != null) {
                        this.radialProgress.setProgress(fileProgress.floatValue(), animated);
                    } else {
                        this.radialProgress.setProgress(0.0f, animated);
                    }
                    this.radialProgress.setIcon(getIconForCurrentState(), true, animated);
                }
            }
            updatePlayingMessageProgress();
        }

        private void didPressedButton(boolean animated) {
            int i = this.buttonState;
            if (i == 0) {
                if (MediaController.getInstance().setPlaylist(this.parentAdapter.audioMessages, this.currentMessageObject, 0L, false, null)) {
                    this.buttonState = 1;
                    this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
                    invalidate();
                    return;
                }
                return;
            }
            if (i == 1) {
                if (MediaController.getInstance().lambda$startAudioAgain$7$MediaController(this.currentMessageObject)) {
                    this.buttonState = 0;
                    this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
                    invalidate();
                    return;
                }
                return;
            }
            if (i == 2) {
                this.radialProgress.setProgress(0.0f, false);
                FileLoader.getInstance(ArticleViewer.this.currentAccount).loadFile(this.currentDocument, this.parentAdapter.currentPage, 1, 1);
                this.buttonState = 3;
                this.radialProgress.setIcon(getIconForCurrentState(), true, animated);
                invalidate();
                return;
            }
            if (i == 3) {
                FileLoader.getInstance(ArticleViewer.this.currentAccount).cancelLoadFile(this.currentDocument);
                this.buttonState = 2;
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
                invalidate();
            }
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            DownloadController.getInstance(ArticleViewer.this.currentAccount).removeLoadingFileObserver(this);
        }

        @Override // android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            updateButtonState(false);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onFailedDownload(String fileName, boolean canceled) {
            updateButtonState(true);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onSuccessDownload(String fileName) {
            this.radialProgress.setProgress(1.0f, true);
            updateButtonState(true);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onProgressDownload(String fileName, long downloadSize, long totalSize) {
            this.radialProgress.setProgress(Math.min(1.0f, downloadSize / totalSize), true);
            if (this.buttonState != 3) {
                updateButtonState(true);
            }
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public int getObserverTag() {
            return this.TAG;
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.titleLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.captionLayout;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
            DrawingText drawingText3 = this.creditLayout;
            if (drawingText3 != null) {
                blocks.add(drawingText3);
            }
        }
    }

    private class BlockEmbedPostCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private AvatarDrawable avatarDrawable;
        private ImageReceiver avatarImageView;
        private boolean avatarVisible;
        private DrawingText captionLayout;
        private DrawingText creditLayout;
        private int creditOffset;
        private TLRPC$TL_pageBlockEmbedPost currentBlock;
        private DrawingText dateLayout;
        private int lineHeight;
        private DrawingText nameLayout;
        private WebpageAdapter parentAdapter;
        private int textX;
        private int textY;

        public BlockEmbedPostCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.parentAdapter = adapter;
            ImageReceiver imageReceiver = new ImageReceiver(this);
            this.avatarImageView = imageReceiver;
            imageReceiver.setRoundRadius(AndroidUtilities.dp(20.0f));
            this.avatarImageView.setImageCoords(AndroidUtilities.dp(32.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            this.avatarDrawable = new AvatarDrawable();
        }

        public void setBlock(TLRPC$TL_pageBlockEmbedPost block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.captionLayout, this.textX, this.textY) || ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.creditLayout, this.textX, this.textY + this.creditOffset) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockEmbedPost tLRPC$TL_pageBlockEmbedPost = this.currentBlock;
            int i = 1;
            if (tLRPC$TL_pageBlockEmbedPost != null) {
                if (tLRPC$TL_pageBlockEmbedPost instanceof TL_pageBlockEmbedPostCaption) {
                    this.textX = AndroidUtilities.dp(18.0f);
                    this.textY = AndroidUtilities.dp(4.0f);
                    int iDp = size - AndroidUtilities.dp(50.0f);
                    ArticleViewer articleViewer = ArticleViewer.this;
                    TLRPC$TL_pageBlockEmbedPost tLRPC$TL_pageBlockEmbedPost2 = this.currentBlock;
                    DrawingText drawingTextCreateLayoutForText = articleViewer.createLayoutForText(this, null, tLRPC$TL_pageBlockEmbedPost2.caption.text, iDp, this.textY, tLRPC$TL_pageBlockEmbedPost2, this.parentAdapter);
                    this.captionLayout = drawingTextCreateLayoutForText;
                    if (drawingTextCreateLayoutForText != null) {
                        int iDp2 = AndroidUtilities.dp(4.0f) + this.captionLayout.getHeight();
                        this.creditOffset = iDp2;
                        iDp = 0 + iDp2 + AndroidUtilities.dp(4.0f);
                    }
                    ArticleViewer articleViewer2 = ArticleViewer.this;
                    TLRPC$TL_pageBlockEmbedPost tLRPC$TL_pageBlockEmbedPost3 = this.currentBlock;
                    DrawingText drawingTextCreateLayoutForText2 = articleViewer2.createLayoutForText(this, null, tLRPC$TL_pageBlockEmbedPost3.caption.credit, iDp, this.textY + this.creditOffset, tLRPC$TL_pageBlockEmbedPost3, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                    this.creditLayout = drawingTextCreateLayoutForText2;
                    if (drawingTextCreateLayoutForText2 != null) {
                        iDp += AndroidUtilities.dp(4.0f) + this.creditLayout.getHeight();
                    }
                    i = iDp;
                } else {
                    long j = tLRPC$TL_pageBlockEmbedPost.author_photo_id;
                    boolean z = j != 0;
                    this.avatarVisible = z;
                    if (z) {
                        TLRPC$Photo photoWithId = this.parentAdapter.getPhotoWithId(j);
                        boolean z2 = photoWithId instanceof TLRPC$TL_photo;
                        this.avatarVisible = z2;
                        if (z2) {
                            this.avatarDrawable.setInfo(0L, this.currentBlock.author, null);
                            this.avatarImageView.setImage(ImageLocation.getForPhoto(FileLoader.getClosestPhotoSizeWithSize(photoWithId.sizes, AndroidUtilities.dp(40.0f), true), photoWithId), "40_40", this.avatarDrawable, 0, (String) null, this.parentAdapter.currentPage, 1);
                        }
                    }
                    DrawingText drawingTextCreateLayoutForText3 = ArticleViewer.this.createLayoutForText(this, this.currentBlock.author, null, size - AndroidUtilities.dp((this.avatarVisible ? 54 : 0) + 50), 0, this.currentBlock, Layout.Alignment.ALIGN_NORMAL, 1, this.parentAdapter);
                    this.nameLayout = drawingTextCreateLayoutForText3;
                    if (drawingTextCreateLayoutForText3 != null) {
                        drawingTextCreateLayoutForText3.x = AndroidUtilities.dp((this.avatarVisible ? 54 : 0) + 32);
                        this.nameLayout.y = AndroidUtilities.dp(this.dateLayout != null ? 10.0f : 19.0f);
                    }
                    if (this.currentBlock.date != 0) {
                        this.dateLayout = ArticleViewer.this.createLayoutForText(this, LocaleController.getInstance().chatFullDate.format(this.currentBlock.date * 1000), null, size - AndroidUtilities.dp((this.avatarVisible ? 54 : 0) + 50), AndroidUtilities.dp(29.0f), this.currentBlock, this.parentAdapter);
                    } else {
                        this.dateLayout = null;
                    }
                    int iDp3 = AndroidUtilities.dp(56.0f);
                    if (this.currentBlock.blocks.isEmpty()) {
                        this.textX = AndroidUtilities.dp(32.0f);
                        this.textY = AndroidUtilities.dp(56.0f);
                        int iDp4 = size - AndroidUtilities.dp(50.0f);
                        ArticleViewer articleViewer3 = ArticleViewer.this;
                        TLRPC$TL_pageBlockEmbedPost tLRPC$TL_pageBlockEmbedPost4 = this.currentBlock;
                        DrawingText drawingTextCreateLayoutForText4 = articleViewer3.createLayoutForText(this, null, tLRPC$TL_pageBlockEmbedPost4.caption.text, iDp4, this.textY, tLRPC$TL_pageBlockEmbedPost4, this.parentAdapter);
                        this.captionLayout = drawingTextCreateLayoutForText4;
                        if (drawingTextCreateLayoutForText4 != null) {
                            int iDp5 = AndroidUtilities.dp(4.0f) + this.captionLayout.getHeight();
                            this.creditOffset = iDp5;
                            iDp3 += iDp5 + AndroidUtilities.dp(4.0f);
                        }
                        int iDp6 = iDp3;
                        ArticleViewer articleViewer4 = ArticleViewer.this;
                        TLRPC$TL_pageBlockEmbedPost tLRPC$TL_pageBlockEmbedPost5 = this.currentBlock;
                        DrawingText drawingTextCreateLayoutForText5 = articleViewer4.createLayoutForText(this, null, tLRPC$TL_pageBlockEmbedPost5.caption.credit, iDp4, this.textY + this.creditOffset, tLRPC$TL_pageBlockEmbedPost5, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                        this.creditLayout = drawingTextCreateLayoutForText5;
                        if (drawingTextCreateLayoutForText5 != null) {
                            iDp6 += AndroidUtilities.dp(4.0f) + this.creditLayout.getHeight();
                        }
                        iDp3 = iDp6;
                    } else {
                        this.captionLayout = null;
                        this.creditLayout = null;
                    }
                    DrawingText drawingText = this.dateLayout;
                    if (drawingText != null) {
                        drawingText.x = AndroidUtilities.dp((this.avatarVisible ? 54 : 0) + 32);
                        this.dateLayout.y = AndroidUtilities.dp(29.0f);
                    }
                    DrawingText drawingText2 = this.captionLayout;
                    if (drawingText2 != null) {
                        drawingText2.x = this.textX;
                        drawingText2.y = this.textY;
                    }
                    DrawingText drawingText3 = this.creditLayout;
                    if (drawingText3 != null) {
                        drawingText3.x = this.textX;
                        drawingText3.y = this.textY;
                    }
                    i = iDp3;
                }
                this.lineHeight = i;
            }
            setMeasuredDimension(size, i);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            TLRPC$TL_pageBlockEmbedPost tLRPC$TL_pageBlockEmbedPost = this.currentBlock;
            if (tLRPC$TL_pageBlockEmbedPost == null) {
                return;
            }
            if (!(tLRPC$TL_pageBlockEmbedPost instanceof TL_pageBlockEmbedPostCaption)) {
                if (this.avatarVisible) {
                    this.avatarImageView.draw(canvas);
                }
                if (this.nameLayout != null) {
                    canvas.save();
                    canvas.translate(AndroidUtilities.dp((this.avatarVisible ? 54 : 0) + 32), AndroidUtilities.dp(this.dateLayout != null ? 10.0f : 19.0f));
                    ArticleViewer.this.drawTextSelection(canvas, this, 0);
                    this.nameLayout.draw(canvas);
                    canvas.restore();
                    i = 1;
                } else {
                    i = 0;
                }
                if (this.dateLayout != null) {
                    canvas.save();
                    canvas.translate(AndroidUtilities.dp((this.avatarVisible ? 54 : 0) + 32), AndroidUtilities.dp(29.0f));
                    ArticleViewer.this.drawTextSelection(canvas, this, i);
                    this.dateLayout.draw(canvas);
                    canvas.restore();
                    i++;
                }
                canvas.drawRect(AndroidUtilities.dp(18.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(20.0f), this.lineHeight - (this.currentBlock.level == 0 ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
                i = i;
            }
            if (this.captionLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.captionLayout.draw(canvas);
                canvas.restore();
                i++;
            }
            if (this.creditLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY + this.creditOffset);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.creditLayout.draw(canvas);
                canvas.restore();
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.nameLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.dateLayout;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
            DrawingText drawingText3 = this.captionLayout;
            if (drawingText3 != null) {
                blocks.add(drawingText3);
            }
            DrawingText drawingText4 = this.creditLayout;
            if (drawingText4 != null) {
                blocks.add(drawingText4);
            }
        }
    }

    public class BlockParagraphCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockParagraph currentBlock;
        private WebpageAdapter parentAdapter;
        public DrawingText textLayout;
        public int textX;
        public int textY;

        public BlockParagraphCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockParagraph block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockParagraph tLRPC$TL_pageBlockParagraph = this.currentBlock;
            int i = 0;
            if (tLRPC$TL_pageBlockParagraph != null) {
                if (tLRPC$TL_pageBlockParagraph.level == 0) {
                    this.textY = AndroidUtilities.dp(8.0f);
                    this.textX = AndroidUtilities.dp(18.0f);
                } else {
                    this.textY = 0;
                    this.textX = AndroidUtilities.dp((r15 * 14) + 18);
                }
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, this.currentBlock.text, (size - AndroidUtilities.dp(18.0f)) - this.textX, this.textY, this.currentBlock, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, 0, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    int height = drawingTextCreateLayoutForText.getHeight();
                    if (this.currentBlock.level > 0) {
                        iDp = AndroidUtilities.dp(8.0f);
                    } else {
                        iDp = AndroidUtilities.dp(16.0f);
                    }
                    i = height + iDp;
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
            } else {
                i = 1;
            }
            setMeasuredDimension(size, i);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            if (this.textLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this);
                this.textLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            DrawingText drawingText = this.textLayout;
            if (drawingText == null) {
                return;
            }
            info.setText(drawingText.getText());
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class BlockEmbedCell extends FrameLayout implements TextSelectionHelper.ArticleSelectableView {
        private DrawingText captionLayout;
        private DrawingText creditLayout;
        private int creditOffset;
        private TLRPC$TL_pageBlockEmbed currentBlock;
        private int exactWebViewHeight;
        private int listX;
        private WebpageAdapter parentAdapter;
        private int textX;
        private int textY;
        private WebPlayerView videoView;
        private boolean wasUserInteraction;
        private TouchyWebView webView;

        /* JADX INFO: Access modifiers changed from: private */
        class EitaaWebviewProxy {
            private EitaaWebviewProxy() {
            }

            @JavascriptInterface
            public void postEvent(final String eventName, final String eventData) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$BlockEmbedCell$EitaaWebviewProxy$xsIV3jyypmv9mPeWWbJAod2RdOk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$postEvent$0$ArticleViewer$BlockEmbedCell$EitaaWebviewProxy(eventName, eventData);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$postEvent$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$postEvent$0$ArticleViewer$BlockEmbedCell$EitaaWebviewProxy(String str, String str2) {
                if ("resize_frame".equals(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        BlockEmbedCell.this.exactWebViewHeight = Utilities.parseInt(jSONObject.getString("height")).intValue();
                        BlockEmbedCell.this.requestLayout();
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        public class TouchyWebView extends WebView {
            public TouchyWebView(Context context) {
                super(context);
                setFocusable(false);
            }

            @Override // android.webkit.WebView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                BlockEmbedCell.this.wasUserInteraction = true;
                if (BlockEmbedCell.this.currentBlock != null) {
                    if (!BlockEmbedCell.this.currentBlock.allow_scrolling) {
                        ArticleViewer.this.windowView.requestDisallowInterceptTouchEvent(true);
                    } else {
                        requestDisallowInterceptTouchEvent(true);
                    }
                }
                return super.onTouchEvent(event);
            }
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
        public BlockEmbedCell(final Context context, WebpageAdapter adapter) {
            super(context);
            this.parentAdapter = adapter;
            setWillNotDraw(false);
            WebPlayerView webPlayerView = new WebPlayerView(context, false, false, new WebPlayerView.WebPlayerViewDelegate() { // from class: ir.eitaa.ui.ArticleViewer.BlockEmbedCell.1
                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public boolean checkInlinePermissions() {
                    return false;
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public ViewGroup getTextureViewContainer() {
                    return null;
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public void onInlineSurfaceTextureReady() {
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public TextureView onSwitchInlineMode(View controlsView, boolean inline, float aspectRatio, int rotation, boolean animated) {
                    return null;
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public void prepareToSwitchInlineMode(boolean inline, Runnable switchInlineModeRunnable, float aspectRatio, boolean animated) {
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public void onInitFailed() {
                    BlockEmbedCell.this.webView.setVisibility(0);
                    BlockEmbedCell.this.videoView.setVisibility(4);
                    BlockEmbedCell.this.videoView.loadVideo(null, null, null, null, false);
                    HashMap map = new HashMap();
                    map.put("Referer", ApplicationLoader.applicationContext.getPackageName());
                    BlockEmbedCell.this.webView.loadUrl(BlockEmbedCell.this.currentBlock.url, map);
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public void onVideoSizeChanged(float aspectRatio, int rotation) {
                    ArticleViewer.this.fullscreenAspectRatioView.setAspectRatio(aspectRatio, rotation);
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public TextureView onSwitchToFullscreen(View controlsView, boolean fullscreen, float aspectRatio, int rotation, boolean byButton) {
                    if (fullscreen) {
                        ArticleViewer.this.fullscreenAspectRatioView.addView(ArticleViewer.this.fullscreenTextureView, LayoutHelper.createFrame(-1, -1.0f));
                        ArticleViewer.this.fullscreenAspectRatioView.setVisibility(0);
                        ArticleViewer.this.fullscreenAspectRatioView.setAspectRatio(aspectRatio, rotation);
                        BlockEmbedCell blockEmbedCell = BlockEmbedCell.this;
                        ArticleViewer.this.fullscreenedVideo = blockEmbedCell.videoView;
                        ArticleViewer.this.fullscreenVideoContainer.addView(controlsView, LayoutHelper.createFrame(-1, -1.0f));
                        ArticleViewer.this.fullscreenVideoContainer.setVisibility(0);
                    } else {
                        ArticleViewer.this.fullscreenAspectRatioView.removeView(ArticleViewer.this.fullscreenTextureView);
                        ArticleViewer.this.fullscreenedVideo = null;
                        ArticleViewer.this.fullscreenAspectRatioView.setVisibility(8);
                        ArticleViewer.this.fullscreenVideoContainer.setVisibility(4);
                    }
                    return ArticleViewer.this.fullscreenTextureView;
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public void onSharePressed() {
                    if (ArticleViewer.this.parentActivity == null) {
                        return;
                    }
                    ArticleViewer.this.showDialog(new ShareAlert(ArticleViewer.this.parentActivity, null, BlockEmbedCell.this.currentBlock.url, false, BlockEmbedCell.this.currentBlock.url, false));
                }

                @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
                public void onPlayStateChanged(WebPlayerView playerView, boolean playing) {
                    if (playing) {
                        if (ArticleViewer.this.currentPlayingVideo != null && ArticleViewer.this.currentPlayingVideo != playerView) {
                            ArticleViewer.this.currentPlayingVideo.pause();
                        }
                        ArticleViewer.this.currentPlayingVideo = playerView;
                        try {
                            ArticleViewer.this.parentActivity.getWindow().addFlags(128);
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                    if (ArticleViewer.this.currentPlayingVideo == playerView) {
                        ArticleViewer.this.currentPlayingVideo = null;
                    }
                    try {
                        ArticleViewer.this.parentActivity.getWindow().clearFlags(128);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
            });
            this.videoView = webPlayerView;
            addView(webPlayerView);
            ArticleViewer.this.createdWebViews.add(this);
            TouchyWebView touchyWebView = new TouchyWebView(context);
            this.webView = touchyWebView;
            touchyWebView.getSettings().setJavaScriptEnabled(true);
            this.webView.getSettings().setDomStorageEnabled(true);
            this.webView.getSettings().setAllowContentAccess(true);
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
                this.webView.addJavascriptInterface(new EitaaWebviewProxy(), "EitaaWebviewProxy");
            }
            if (i >= 21) {
                this.webView.getSettings().setMixedContentMode(0);
                CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
            }
            this.webView.setWebChromeClient(new AnonymousClass2(ArticleViewer.this));
            this.webView.setWebViewClient(new WebViewClient() { // from class: ir.eitaa.ui.ArticleViewer.BlockEmbedCell.3
                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (!BlockEmbedCell.this.wasUserInteraction) {
                        return false;
                    }
                    Browser.openUrl(ArticleViewer.this.parentActivity, url);
                    return true;
                }
            });
            addView(this.webView);
        }

        /* renamed from: ir.eitaa.ui.ArticleViewer$BlockEmbedCell$2, reason: invalid class name */
        class AnonymousClass2 extends WebChromeClient {
            final /* synthetic */ ArticleViewer val$this$0;

            AnonymousClass2(final ArticleViewer val$this$0) {
                this.val$this$0 = val$this$0;
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
                onShowCustomView(view, callback);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                if (ArticleViewer.this.customView == null) {
                    ArticleViewer.this.customView = view;
                    ArticleViewer.this.customViewCallback = callback;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$BlockEmbedCell$2$EkJQYwJMziAZT3uR_HwHC5idqkw
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onShowCustomView$0$ArticleViewer$BlockEmbedCell$2();
                        }
                    }, 100L);
                    return;
                }
                callback.onCustomViewHidden();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onShowCustomView$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onShowCustomView$0$ArticleViewer$BlockEmbedCell$2() {
                if (ArticleViewer.this.customView != null) {
                    ArticleViewer.this.fullscreenVideoContainer.addView(ArticleViewer.this.customView, LayoutHelper.createFrame(-1, -1.0f));
                    ArticleViewer.this.fullscreenVideoContainer.setVisibility(0);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                super.onHideCustomView();
                if (ArticleViewer.this.customView == null) {
                    return;
                }
                ArticleViewer.this.fullscreenVideoContainer.setVisibility(4);
                ArticleViewer.this.fullscreenVideoContainer.removeView(ArticleViewer.this.customView);
                if (ArticleViewer.this.customViewCallback != null && !ArticleViewer.this.customViewCallback.getClass().getName().contains(".chromium.")) {
                    ArticleViewer.this.customViewCallback.onCustomViewHidden();
                }
                ArticleViewer.this.customView = null;
            }
        }

        public void destroyWebView(boolean completely) {
            try {
                this.webView.stopLoading();
                this.webView.loadUrl("about:blank");
                if (completely) {
                    this.webView.destroy();
                }
                this.currentBlock = null;
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.videoView.destroy();
        }

        public void setBlock(TLRPC$TL_pageBlockEmbed block) {
            TLRPC$TL_pageBlockEmbed tLRPC$TL_pageBlockEmbed = this.currentBlock;
            this.currentBlock = block;
            this.webView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            TLRPC$TL_pageBlockEmbed tLRPC$TL_pageBlockEmbed2 = this.currentBlock;
            if (tLRPC$TL_pageBlockEmbed != tLRPC$TL_pageBlockEmbed2) {
                this.wasUserInteraction = false;
                if (tLRPC$TL_pageBlockEmbed2.allow_scrolling) {
                    this.webView.setVerticalScrollBarEnabled(true);
                    this.webView.setHorizontalScrollBarEnabled(true);
                } else {
                    this.webView.setVerticalScrollBarEnabled(false);
                    this.webView.setHorizontalScrollBarEnabled(false);
                }
                this.exactWebViewHeight = 0;
                try {
                    this.webView.loadUrl("about:blank");
                } catch (Exception e) {
                    FileLog.e(e);
                }
                try {
                    TLRPC$TL_pageBlockEmbed tLRPC$TL_pageBlockEmbed3 = this.currentBlock;
                    String str = tLRPC$TL_pageBlockEmbed3.html;
                    if (str != null) {
                        this.webView.loadDataWithBaseURL("https://eitaa.org/embed", str, "text/html", "UTF-8", null);
                        this.videoView.setVisibility(4);
                        this.videoView.loadVideo(null, null, null, null, false);
                        this.webView.setVisibility(0);
                    } else {
                        long j = tLRPC$TL_pageBlockEmbed3.poster_photo_id;
                        if (this.videoView.loadVideo(block.url, j != 0 ? this.parentAdapter.getPhotoWithId(j) : null, this.parentAdapter.currentPage, null, false)) {
                            this.webView.setVisibility(4);
                            this.videoView.setVisibility(0);
                            this.webView.stopLoading();
                            this.webView.loadUrl("about:blank");
                        } else {
                            this.webView.setVisibility(0);
                            this.videoView.setVisibility(4);
                            this.videoView.loadVideo(null, null, null, null, false);
                            HashMap map = new HashMap();
                            map.put("Referer", ApplicationLoader.applicationContext.getPackageName());
                            this.webView.loadUrl(this.currentBlock.url, map);
                        }
                    }
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            requestLayout();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (ArticleViewer.this.isVisible) {
                return;
            }
            this.currentBlock = null;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.captionLayout, this.textX, this.textY) || ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.creditLayout, this.textX, this.textY + this.creditOffset) || super.onTouchEvent(event);
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x0144  */
        @Override // android.widget.FrameLayout, android.view.View
        @android.annotation.SuppressLint({"NewApi"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r13, int r14) {
            /*
                Method dump skipped, instructions count: 338
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockEmbedCell.onMeasure(int, int):void");
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            TouchyWebView touchyWebView = this.webView;
            int i = this.listX;
            touchyWebView.layout(i, 0, touchyWebView.getMeasuredWidth() + i, this.webView.getMeasuredHeight());
            if (this.videoView.getParent() == this) {
                WebPlayerView webPlayerView = this.videoView;
                int i2 = this.listX;
                webPlayerView.layout(i2, 0, webPlayerView.getMeasuredWidth() + i2, this.videoView.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            if (this.currentBlock == null) {
                return;
            }
            if (this.captionLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                i = 1;
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.captionLayout.draw(canvas);
                canvas.restore();
            } else {
                i = 0;
            }
            if (this.creditLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY + this.creditOffset);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.creditLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.captionLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.creditLayout;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    public class BlockTableCell extends FrameLayout implements TableLayout.TableLayoutDelegate, TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockTable currentBlock;
        private boolean firstLayout;
        private int listX;
        private int listY;
        private WebpageAdapter parentAdapter;
        private HorizontalScrollView scrollView;
        private TableLayout tableLayout;
        private int textX;
        private int textY;
        private DrawingText titleLayout;

        public BlockTableCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.parentAdapter = adapter;
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context) { // from class: ir.eitaa.ui.ArticleViewer.BlockTableCell.1
                @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent ev) {
                    boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(ev);
                    if (BlockTableCell.this.tableLayout.getMeasuredWidth() > getMeasuredWidth() - AndroidUtilities.dp(36.0f) && zOnInterceptTouchEvent) {
                        ArticleViewer.this.windowView.requestDisallowInterceptTouchEvent(true);
                    }
                    return zOnInterceptTouchEvent;
                }

                @Override // android.widget.HorizontalScrollView, android.view.View
                public boolean onTouchEvent(MotionEvent ev) {
                    if (BlockTableCell.this.tableLayout.getMeasuredWidth() <= getMeasuredWidth() - AndroidUtilities.dp(36.0f)) {
                        return false;
                    }
                    return super.onTouchEvent(ev);
                }

                @Override // android.view.View
                protected void onScrollChanged(int l, int t, int oldl, int oldt) {
                    super.onScrollChanged(l, t, oldl, oldt);
                    if (ArticleViewer.this.pressedLinkOwnerLayout != null) {
                        ArticleViewer.this.pressedLinkOwnerLayout = null;
                        ArticleViewer.this.pressedLinkOwnerView = null;
                    }
                    BlockTableCell.this.updateChildTextPositions();
                    TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper = ArticleViewer.this.textSelectionHelper;
                    if (articleTextSelectionHelper == null || !articleTextSelectionHelper.isSelectionMode()) {
                        return;
                    }
                    ArticleViewer.this.textSelectionHelper.invalidate();
                }

                @Override // android.view.View
                protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
                    ArticleViewer.this.removePressedLink();
                    return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
                }

                @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    BlockTableCell.this.tableLayout.measure(View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight(), 0), heightMeasureSpec);
                    setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), BlockTableCell.this.tableLayout.getMeasuredHeight());
                }
            };
            this.scrollView = horizontalScrollView;
            horizontalScrollView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            this.scrollView.setClipToPadding(false);
            addView(this.scrollView, LayoutHelper.createFrame(-1, -2.0f));
            TableLayout tableLayout = new TableLayout(context, this, ArticleViewer.this.textSelectionHelper);
            this.tableLayout = tableLayout;
            tableLayout.setOrientation(0);
            this.tableLayout.setRowOrderPreserved(true);
            this.scrollView.addView(this.tableLayout, new FrameLayout.LayoutParams(-2, -2));
            setWillNotDraw(false);
        }

        @Override // ir.eitaa.ui.Components.TableLayout.TableLayoutDelegate
        public DrawingText createTextLayout(TLRPC$TL_pageTableCell cell, int maxWidth) {
            Layout.Alignment alignment;
            if (cell == null) {
                return null;
            }
            if (cell.align_right) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (cell.align_center) {
                alignment = Layout.Alignment.ALIGN_CENTER;
            } else {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            }
            return ArticleViewer.this.createLayoutForText(this, null, cell.text, maxWidth, -1, this.currentBlock, alignment, 0, this.parentAdapter);
        }

        @Override // ir.eitaa.ui.Components.TableLayout.TableLayoutDelegate
        public Paint getLinePaint() {
            return ArticleViewer.tableLinePaint;
        }

        public Paint getHalfLinePaint() {
            return ArticleViewer.tableHalfLinePaint;
        }

        @Override // ir.eitaa.ui.Components.TableLayout.TableLayoutDelegate
        public Paint getHeaderPaint() {
            return ArticleViewer.tableHeaderPaint;
        }

        @Override // ir.eitaa.ui.Components.TableLayout.TableLayoutDelegate
        public Paint getStripPaint() {
            return ArticleViewer.tableStripPaint;
        }

        @Override // ir.eitaa.ui.Components.TableLayout.TableLayoutDelegate
        public void onLayoutChild(DrawingText text, int x, int y) {
            if (text == null || ArticleViewer.this.searchResults.isEmpty() || ArticleViewer.this.searchText == null) {
                return;
            }
            String lowerCase = text.textLayout.getText().toString().toLowerCase();
            int i = 0;
            while (true) {
                int iIndexOf = lowerCase.indexOf(ArticleViewer.this.searchText, i);
                if (iIndexOf < 0) {
                    return;
                }
                int length = ArticleViewer.this.searchText.length() + iIndexOf;
                if (iIndexOf == 0 || AndroidUtilities.isPunctuationCharacter(lowerCase.charAt(iIndexOf - 1))) {
                    HashMap map = ArticleViewer.this.adapter[0].searchTextOffset;
                    String str = ArticleViewer.this.searchText + this.currentBlock + text.parentText + iIndexOf;
                    StaticLayout staticLayout = text.textLayout;
                    map.put(str, Integer.valueOf(staticLayout.getLineTop(staticLayout.getLineForOffset(iIndexOf)) + y));
                }
                i = length;
            }
        }

        public void setBlock(TLRPC$TL_pageBlockTable block) throws NoSuchFieldException {
            int i;
            this.currentBlock = block;
            AndroidUtilities.setScrollViewEdgeEffectColor(this.scrollView, Theme.getColor("windowBackgroundWhite"));
            this.tableLayout.removeAllChildrens();
            this.tableLayout.setDrawLines(this.currentBlock.bordered);
            this.tableLayout.setStriped(this.currentBlock.striped);
            this.tableLayout.setRtl(this.parentAdapter.isRtl);
            if (this.currentBlock.rows.isEmpty()) {
                i = 0;
            } else {
                TLRPC$TL_pageTableRow tLRPC$TL_pageTableRow = this.currentBlock.rows.get(0);
                int size = tLRPC$TL_pageTableRow.cells.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = tLRPC$TL_pageTableRow.cells.get(i2).colspan;
                    if (i3 == 0) {
                        i3 = 1;
                    }
                    i += i3;
                }
            }
            int size2 = this.currentBlock.rows.size();
            for (int i4 = 0; i4 < size2; i4++) {
                TLRPC$TL_pageTableRow tLRPC$TL_pageTableRow2 = this.currentBlock.rows.get(i4);
                int size3 = tLRPC$TL_pageTableRow2.cells.size();
                int i5 = 0;
                for (int i6 = 0; i6 < size3; i6++) {
                    TLRPC$TL_pageTableCell tLRPC$TL_pageTableCell = tLRPC$TL_pageTableRow2.cells.get(i6);
                    int i7 = tLRPC$TL_pageTableCell.colspan;
                    if (i7 == 0) {
                        i7 = 1;
                    }
                    int i8 = tLRPC$TL_pageTableCell.rowspan;
                    if (i8 == 0) {
                        i8 = 1;
                    }
                    if (tLRPC$TL_pageTableCell.text != null) {
                        this.tableLayout.addChild(tLRPC$TL_pageTableCell, i5, i4, i7);
                    } else {
                        this.tableLayout.addChild(i5, i4, i7, i8);
                    }
                    i5 += i7;
                }
            }
            this.tableLayout.setColumnCount(i);
            this.firstLayout = true;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            int childCount = this.tableLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                TableLayout.Child childAt = this.tableLayout.getChildAt(i);
                if (ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, childAt.textLayout, (this.scrollView.getPaddingLeft() - this.scrollView.getScrollX()) + this.listX + childAt.getTextX(), this.listY + childAt.getTextY())) {
                    return true;
                }
            }
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.titleLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View, ir.eitaa.ui.Cells.TextSelectionHelper.SelectableView
        public void invalidate() {
            super.invalidate();
            this.tableLayout.invalidate();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int measuredHeight;
            int iDp;
            int height;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockTable tLRPC$TL_pageBlockTable = this.currentBlock;
            if (tLRPC$TL_pageBlockTable != null) {
                if (tLRPC$TL_pageBlockTable.level > 0) {
                    int iDp2 = AndroidUtilities.dp(r14 * 14);
                    this.listX = iDp2;
                    iDp = iDp2 + AndroidUtilities.dp(18.0f);
                    this.textX = iDp;
                } else {
                    this.listX = 0;
                    this.textX = AndroidUtilities.dp(18.0f);
                    iDp = AndroidUtilities.dp(36.0f);
                }
                ArticleViewer articleViewer = ArticleViewer.this;
                TLRPC$TL_pageBlockTable tLRPC$TL_pageBlockTable2 = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText = articleViewer.createLayoutForText(this, null, tLRPC$TL_pageBlockTable2.title, size - iDp, 0, tLRPC$TL_pageBlockTable2, Layout.Alignment.ALIGN_CENTER, 0, this.parentAdapter);
                this.titleLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    this.textY = 0;
                    height = drawingTextCreateLayoutForText.getHeight() + AndroidUtilities.dp(8.0f) + 0;
                    this.listY = height;
                    DrawingText drawingText = this.titleLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                } else {
                    this.listY = AndroidUtilities.dp(8.0f);
                    height = 0;
                }
                this.scrollView.measure(View.MeasureSpec.makeMeasureSpec(size - this.listX, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                measuredHeight = height + this.scrollView.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                TLRPC$TL_pageBlockTable tLRPC$TL_pageBlockTable3 = this.currentBlock;
                if (tLRPC$TL_pageBlockTable3.level > 0 && !tLRPC$TL_pageBlockTable3.bottom) {
                    measuredHeight += AndroidUtilities.dp(8.0f);
                }
            } else {
                measuredHeight = 1;
            }
            setMeasuredDimension(size, measuredHeight);
            updateChildTextPositions();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateChildTextPositions() {
            int i = this.titleLayout == null ? 0 : 1;
            int childCount = this.tableLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                TableLayout.Child childAt = this.tableLayout.getChildAt(i2);
                DrawingText drawingText = childAt.textLayout;
                if (drawingText != null) {
                    drawingText.x = ((childAt.getTextX() + this.listX) + AndroidUtilities.dp(18.0f)) - this.scrollView.getScrollX();
                    childAt.textLayout.y = childAt.getTextY() + this.listY;
                    childAt.textLayout.row = childAt.getRow();
                    childAt.setSelectionIndex(i);
                    i++;
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            HorizontalScrollView horizontalScrollView = this.scrollView;
            int i = this.listX;
            horizontalScrollView.layout(i, this.listY, horizontalScrollView.getMeasuredWidth() + i, this.listY + this.scrollView.getMeasuredHeight());
            if (this.firstLayout) {
                if (this.parentAdapter.isRtl) {
                    this.scrollView.setScrollX((this.tableLayout.getMeasuredWidth() - this.scrollView.getMeasuredWidth()) + AndroidUtilities.dp(36.0f));
                } else {
                    this.scrollView.setScrollX(0);
                }
                this.firstLayout = false;
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            if (this.titleLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.titleLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.titleLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            int childCount = this.tableLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                DrawingText drawingText2 = this.tableLayout.getChildAt(i).textLayout;
                if (drawingText2 != null) {
                    blocks.add(drawingText2);
                }
            }
        }
    }

    private class BlockCollageCell extends FrameLayout implements TextSelectionHelper.ArticleSelectableView {
        private DrawingText captionLayout;
        private DrawingText creditLayout;
        private int creditOffset;
        private TLRPC$TL_pageBlockCollage currentBlock;
        private GroupedMessages group;
        private boolean inLayout;
        private RecyclerView.Adapter innerAdapter;
        private RecyclerListView innerListView;
        private int listX;
        private WebpageAdapter parentAdapter;
        private int textX;
        private int textY;

        public class GroupedMessages {
            public boolean hasSibling;
            public ArrayList<MessageObject.GroupedMessagePosition> posArray = new ArrayList<>();
            public HashMap<TLObject, MessageObject.GroupedMessagePosition> positions = new HashMap<>();
            private int maxSizeWidth = 1000;

            public GroupedMessages() {
            }

            private class MessageGroupedLayoutAttempt {
                public float[] heights;
                public int[] lineCounts;

                public MessageGroupedLayoutAttempt(int i1, int i2, float f1, float f2) {
                    this.lineCounts = new int[]{i1, i2};
                    this.heights = new float[]{f1, f2};
                }

                public MessageGroupedLayoutAttempt(int i1, int i2, int i3, float f1, float f2, float f3) {
                    this.lineCounts = new int[]{i1, i2, i3};
                    this.heights = new float[]{f1, f2, f3};
                }

                public MessageGroupedLayoutAttempt(int i1, int i2, int i3, int i4, float f1, float f2, float f3, float f4) {
                    this.lineCounts = new int[]{i1, i2, i3, i4};
                    this.heights = new float[]{f1, f2, f3, f4};
                }
            }

            private float multiHeight(float[] array, int start, int end) {
                float f = 0.0f;
                while (start < end) {
                    f += array[start];
                    start++;
                }
                return this.maxSizeWidth / f;
            }

            /* JADX WARN: Removed duplicated region for block: B:108:0x05b5  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0193  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void calculate() {
                /*
                    Method dump skipped, instructions count: 1881
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockCollageCell.GroupedMessages.calculate():void");
            }
        }

        public BlockCollageCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.group = new GroupedMessages();
            this.parentAdapter = adapter;
            RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.ArticleViewer.BlockCollageCell.1
                @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
                public void requestLayout() {
                    if (BlockCollageCell.this.inLayout) {
                        return;
                    }
                    super.requestLayout();
                }
            };
            this.innerListView = recyclerListView;
            recyclerListView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ir.eitaa.ui.ArticleViewer.BlockCollageCell.2
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    MessageObject.GroupedMessagePosition groupedMessagePosition;
                    int i = 0;
                    outRect.bottom = 0;
                    if (!(view instanceof BlockPhotoCell)) {
                        groupedMessagePosition = view instanceof BlockVideoCell ? BlockCollageCell.this.group.positions.get(((BlockVideoCell) view).currentBlock) : null;
                    } else {
                        groupedMessagePosition = BlockCollageCell.this.group.positions.get(((BlockPhotoCell) view).currentBlock);
                    }
                    if (groupedMessagePosition == null || groupedMessagePosition.siblingHeights == null) {
                        return;
                    }
                    Point point = AndroidUtilities.displaySize;
                    float fMax = Math.max(point.x, point.y) * 0.5f;
                    int i2 = 0;
                    int iCeil = 0;
                    while (true) {
                        if (i2 >= groupedMessagePosition.siblingHeights.length) {
                            break;
                        }
                        iCeil += (int) Math.ceil(r2[i2] * fMax);
                        i2++;
                    }
                    int iDp2 = iCeil + ((groupedMessagePosition.maxY - groupedMessagePosition.minY) * AndroidUtilities.dp2(11.0f));
                    int size = BlockCollageCell.this.group.posArray.size();
                    while (true) {
                        if (i < size) {
                            MessageObject.GroupedMessagePosition groupedMessagePosition2 = BlockCollageCell.this.group.posArray.get(i);
                            byte b = groupedMessagePosition2.minY;
                            byte b2 = groupedMessagePosition.minY;
                            if (b == b2 && ((groupedMessagePosition2.minX != groupedMessagePosition.minX || groupedMessagePosition2.maxX != groupedMessagePosition.maxX || b != b2 || groupedMessagePosition2.maxY != groupedMessagePosition.maxY) && b == b2)) {
                                iDp2 -= ((int) Math.ceil(fMax * groupedMessagePosition2.ph)) - AndroidUtilities.dp(4.0f);
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    outRect.bottom = -iDp2;
                }
            });
            GridLayoutManagerFixed gridLayoutManagerFixed = new GridLayoutManagerFixed(context, 1000, 1, true) { // from class: ir.eitaa.ui.ArticleViewer.BlockCollageCell.3
                @Override // androidx.recyclerview.widget.GridLayoutManagerFixed
                public boolean shouldLayoutChildFromOpositeSide(View child) {
                    return false;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean supportsPredictiveItemAnimations() {
                    return false;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManagerFixed
                protected boolean hasSiblingChild(int position) {
                    byte b;
                    MessageObject.GroupedMessagePosition groupedMessagePosition = BlockCollageCell.this.group.positions.get(BlockCollageCell.this.currentBlock.items.get((BlockCollageCell.this.currentBlock.items.size() - position) - 1));
                    if (groupedMessagePosition.minX != groupedMessagePosition.maxX && (b = groupedMessagePosition.minY) == groupedMessagePosition.maxY && b != 0) {
                        int size = BlockCollageCell.this.group.posArray.size();
                        for (int i = 0; i < size; i++) {
                            MessageObject.GroupedMessagePosition groupedMessagePosition2 = BlockCollageCell.this.group.posArray.get(i);
                            if (groupedMessagePosition2 != groupedMessagePosition) {
                                byte b2 = groupedMessagePosition2.minY;
                                byte b3 = groupedMessagePosition.minY;
                                if (b2 <= b3 && groupedMessagePosition2.maxY >= b3) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                }
            };
            gridLayoutManagerFixed.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.ArticleViewer.BlockCollageCell.4
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int position) {
                    return BlockCollageCell.this.group.positions.get(BlockCollageCell.this.currentBlock.items.get((BlockCollageCell.this.currentBlock.items.size() - position) - 1)).spanSize;
                }
            });
            this.innerListView.setLayoutManager(gridLayoutManagerFixed);
            RecyclerListView recyclerListView2 = this.innerListView;
            RecyclerView.Adapter adapter2 = new RecyclerView.Adapter() { // from class: ir.eitaa.ui.ArticleViewer.BlockCollageCell.5
                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    View blockPhotoCell;
                    if (viewType == 0) {
                        BlockCollageCell blockCollageCell = BlockCollageCell.this;
                        blockPhotoCell = ArticleViewer.this.new BlockPhotoCell(blockCollageCell.getContext(), BlockCollageCell.this.parentAdapter, 2);
                    } else {
                        BlockCollageCell blockCollageCell2 = BlockCollageCell.this;
                        blockPhotoCell = ArticleViewer.this.new BlockVideoCell(blockCollageCell2.getContext(), BlockCollageCell.this.parentAdapter, 2);
                    }
                    return new RecyclerListView.Holder(blockPhotoCell);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws Resources.NotFoundException {
                    TLRPC$PageBlock tLRPC$PageBlock = BlockCollageCell.this.currentBlock.items.get((BlockCollageCell.this.currentBlock.items.size() - position) - 1);
                    if (holder.getItemViewType() == 0) {
                        BlockPhotoCell blockPhotoCell = (BlockPhotoCell) holder.itemView;
                        blockPhotoCell.groupPosition = BlockCollageCell.this.group.positions.get(tLRPC$PageBlock);
                        blockPhotoCell.setBlock((TLRPC$TL_pageBlockPhoto) tLRPC$PageBlock, true, true);
                    } else {
                        BlockVideoCell blockVideoCell = (BlockVideoCell) holder.itemView;
                        blockVideoCell.groupPosition = BlockCollageCell.this.group.positions.get(tLRPC$PageBlock);
                        blockVideoCell.setBlock((TLRPC$TL_pageBlockVideo) tLRPC$PageBlock, true, true);
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                public int getItemCount() {
                    if (BlockCollageCell.this.currentBlock == null) {
                        return 0;
                    }
                    return BlockCollageCell.this.currentBlock.items.size();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                public int getItemViewType(int position) {
                    return BlockCollageCell.this.currentBlock.items.get((BlockCollageCell.this.currentBlock.items.size() - position) - 1) instanceof TLRPC$TL_pageBlockPhoto ? 0 : 1;
                }
            };
            this.innerAdapter = adapter2;
            recyclerListView2.setAdapter(adapter2);
            addView(this.innerListView, LayoutHelper.createFrame(-1, -2.0f));
            setWillNotDraw(false);
        }

        public void setBlock(TLRPC$TL_pageBlockCollage block) {
            if (this.currentBlock != block) {
                this.currentBlock = block;
                this.group.calculate();
            }
            this.innerAdapter.notifyDataSetChanged();
            this.innerListView.setGlowColor(Theme.getColor("windowBackgroundWhite"));
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.captionLayout, this.textX, this.textY) || ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.creditLayout, this.textX, this.textY + this.creditOffset) || super.onTouchEvent(event);
        }

        @Override // android.widget.FrameLayout, android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int iDp2;
            int iDp3 = 1;
            this.inLayout = true;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockCollage tLRPC$TL_pageBlockCollage = this.currentBlock;
            if (tLRPC$TL_pageBlockCollage != null) {
                if (tLRPC$TL_pageBlockCollage.level > 0) {
                    int iDp4 = AndroidUtilities.dp(r15 * 14) + AndroidUtilities.dp(18.0f);
                    this.listX = iDp4;
                    this.textX = iDp4;
                    iDp2 = size - (iDp4 + AndroidUtilities.dp(18.0f));
                    iDp = iDp2;
                } else {
                    this.listX = 0;
                    this.textX = AndroidUtilities.dp(18.0f);
                    iDp = size - AndroidUtilities.dp(36.0f);
                    iDp2 = size;
                }
                this.innerListView.measure(View.MeasureSpec.makeMeasureSpec(iDp2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = this.innerListView.getMeasuredHeight();
                int iDp5 = measuredHeight + AndroidUtilities.dp(8.0f);
                this.textY = iDp5;
                ArticleViewer articleViewer = ArticleViewer.this;
                TLRPC$TL_pageBlockCollage tLRPC$TL_pageBlockCollage2 = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText = articleViewer.createLayoutForText(this, null, tLRPC$TL_pageBlockCollage2.caption.text, iDp, iDp5, tLRPC$TL_pageBlockCollage2, this.parentAdapter);
                this.captionLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    int iDp6 = AndroidUtilities.dp(4.0f) + this.captionLayout.getHeight();
                    this.creditOffset = iDp6;
                    measuredHeight += iDp6 + AndroidUtilities.dp(4.0f);
                    DrawingText drawingText = this.captionLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                } else {
                    this.creditOffset = 0;
                }
                ArticleViewer articleViewer2 = ArticleViewer.this;
                TLRPC$TL_pageBlockCollage tLRPC$TL_pageBlockCollage3 = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText2 = articleViewer2.createLayoutForText(this, null, tLRPC$TL_pageBlockCollage3.caption.credit, iDp, this.textY + this.creditOffset, tLRPC$TL_pageBlockCollage3, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.creditLayout = drawingTextCreateLayoutForText2;
                if (drawingTextCreateLayoutForText2 != null) {
                    measuredHeight += AndroidUtilities.dp(4.0f) + this.creditLayout.getHeight();
                    DrawingText drawingText2 = this.creditLayout;
                    drawingText2.x = this.textX;
                    drawingText2.y = this.textY + this.creditOffset;
                }
                iDp3 = measuredHeight + AndroidUtilities.dp(16.0f);
                TLRPC$TL_pageBlockCollage tLRPC$TL_pageBlockCollage4 = this.currentBlock;
                if (tLRPC$TL_pageBlockCollage4.level > 0 && !tLRPC$TL_pageBlockCollage4.bottom) {
                    iDp3 += AndroidUtilities.dp(8.0f);
                }
            }
            setMeasuredDimension(size, iDp3);
            this.inLayout = false;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            this.innerListView.layout(this.listX, AndroidUtilities.dp(8.0f), this.listX + this.innerListView.getMeasuredWidth(), this.innerListView.getMeasuredHeight() + AndroidUtilities.dp(8.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            if (this.currentBlock == null) {
                return;
            }
            if (this.captionLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                i = 1;
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.captionLayout.draw(canvas);
                canvas.restore();
            } else {
                i = 0;
            }
            if (this.creditLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY + this.creditOffset);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.creditLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.captionLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.creditLayout;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    private class BlockSlideshowCell extends FrameLayout implements TextSelectionHelper.ArticleSelectableView {
        private DrawingText captionLayout;
        private DrawingText creditLayout;
        private int creditOffset;
        private TLRPC$TL_pageBlockSlideshow currentBlock;
        private int currentPage;
        private View dotsContainer;
        private PagerAdapter innerAdapter;
        private ViewPager innerListView;
        private float pageOffset;
        private WebpageAdapter parentAdapter;
        private int textX;
        private int textY;

        public BlockSlideshowCell(Context context, WebpageAdapter adapter) throws NoSuchFieldException, Resources.NotFoundException {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.parentAdapter = adapter;
            if (ArticleViewer.dotsPaint == null) {
                Paint unused = ArticleViewer.dotsPaint = new Paint(1);
                ArticleViewer.dotsPaint.setColor(-1);
            }
            ViewPager viewPager = new ViewPager(context) { // from class: ir.eitaa.ui.ArticleViewer.BlockSlideshowCell.1
                @Override // androidx.viewpager.widget.ViewPager, android.view.View
                public boolean onTouchEvent(MotionEvent ev) {
                    return super.onTouchEvent(ev);
                }

                @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent ev) {
                    ArticleViewer.this.windowView.requestDisallowInterceptTouchEvent(true);
                    ArticleViewer.this.cancelCheckLongPress();
                    return super.onInterceptTouchEvent(ev);
                }
            };
            this.innerListView = viewPager;
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.ArticleViewer.BlockSlideshowCell.2
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    float measuredWidth = BlockSlideshowCell.this.innerListView.getMeasuredWidth();
                    if (measuredWidth == 0.0f) {
                        return;
                    }
                    BlockSlideshowCell.this.pageOffset = (((position * measuredWidth) + positionOffsetPixels) - (r0.currentPage * measuredWidth)) / measuredWidth;
                    BlockSlideshowCell.this.dotsContainer.invalidate();
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    BlockSlideshowCell.this.currentPage = position;
                    BlockSlideshowCell.this.dotsContainer.invalidate();
                }
            });
            ViewPager viewPager2 = this.innerListView;
            PagerAdapter pagerAdapter = new PagerAdapter() { // from class: ir.eitaa.ui.ArticleViewer.BlockSlideshowCell.3

                /* renamed from: ir.eitaa.ui.ArticleViewer$BlockSlideshowCell$3$ObjectContainer */
                class ObjectContainer {
                    private TLRPC$PageBlock block;
                    private View view;

                    ObjectContainer() {
                    }
                }

                @Override // androidx.viewpager.widget.PagerAdapter
                public int getCount() {
                    if (BlockSlideshowCell.this.currentBlock == null) {
                        return 0;
                    }
                    return BlockSlideshowCell.this.currentBlock.items.size();
                }

                @Override // androidx.viewpager.widget.PagerAdapter
                public boolean isViewFromObject(View view, Object object) {
                    return ((ObjectContainer) object).view == view;
                }

                @Override // androidx.viewpager.widget.PagerAdapter
                public int getItemPosition(Object object) {
                    return BlockSlideshowCell.this.currentBlock.items.contains(((ObjectContainer) object).block) ? -1 : -2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.viewpager.widget.PagerAdapter
                public Object instantiateItem(ViewGroup viewGroup, int i) throws Resources.NotFoundException {
                    BlockVideoCell blockVideoCell;
                    TLRPC$PageBlock tLRPC$PageBlock = BlockSlideshowCell.this.currentBlock.items.get(i);
                    if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockPhoto) {
                        BlockSlideshowCell blockSlideshowCell = BlockSlideshowCell.this;
                        BlockPhotoCell blockPhotoCell = ArticleViewer.this.new BlockPhotoCell(blockSlideshowCell.getContext(), BlockSlideshowCell.this.parentAdapter, 1);
                        blockPhotoCell.setBlock((TLRPC$TL_pageBlockPhoto) tLRPC$PageBlock, true, true);
                        blockVideoCell = blockPhotoCell;
                    } else {
                        BlockSlideshowCell blockSlideshowCell2 = BlockSlideshowCell.this;
                        BlockVideoCell blockVideoCell2 = ArticleViewer.this.new BlockVideoCell(blockSlideshowCell2.getContext(), BlockSlideshowCell.this.parentAdapter, 1);
                        blockVideoCell2.setBlock((TLRPC$TL_pageBlockVideo) tLRPC$PageBlock, true, true);
                        blockVideoCell = blockVideoCell2;
                    }
                    viewGroup.addView(blockVideoCell);
                    ObjectContainer objectContainer = new ObjectContainer();
                    objectContainer.view = blockVideoCell;
                    objectContainer.block = tLRPC$PageBlock;
                    return objectContainer;
                }

                @Override // androidx.viewpager.widget.PagerAdapter
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView(((ObjectContainer) object).view);
                }
            };
            this.innerAdapter = pagerAdapter;
            viewPager2.setAdapter(pagerAdapter);
            AndroidUtilities.setViewPagerEdgeEffectColor(this.innerListView, Theme.getColor("windowBackgroundWhite"));
            addView(this.innerListView);
            View view = new View(context) { // from class: ir.eitaa.ui.ArticleViewer.BlockSlideshowCell.4
                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    int measuredWidth;
                    int i;
                    if (BlockSlideshowCell.this.currentBlock == null) {
                        return;
                    }
                    int count = BlockSlideshowCell.this.innerAdapter.getCount();
                    int iDp = (AndroidUtilities.dp(7.0f) * count) + ((count - 1) * AndroidUtilities.dp(6.0f)) + AndroidUtilities.dp(4.0f);
                    if (iDp < getMeasuredWidth()) {
                        measuredWidth = (getMeasuredWidth() - iDp) / 2;
                    } else {
                        int iDp2 = AndroidUtilities.dp(4.0f);
                        int iDp3 = AndroidUtilities.dp(13.0f);
                        int measuredWidth2 = ((getMeasuredWidth() - AndroidUtilities.dp(8.0f)) / 2) / iDp3;
                        int i2 = (count - measuredWidth2) - 1;
                        if (BlockSlideshowCell.this.currentPage != i2 || BlockSlideshowCell.this.pageOffset >= 0.0f) {
                            if (BlockSlideshowCell.this.currentPage >= i2) {
                                i = ((count - (measuredWidth2 * 2)) - 1) * iDp3;
                            } else if (BlockSlideshowCell.this.currentPage > measuredWidth2) {
                                i = ((int) (BlockSlideshowCell.this.pageOffset * iDp3)) + ((BlockSlideshowCell.this.currentPage - measuredWidth2) * iDp3);
                            } else if (BlockSlideshowCell.this.currentPage != measuredWidth2 || BlockSlideshowCell.this.pageOffset <= 0.0f) {
                                measuredWidth = iDp2;
                            } else {
                                i = (int) (BlockSlideshowCell.this.pageOffset * iDp3);
                            }
                            measuredWidth = iDp2 - i;
                        } else {
                            measuredWidth = iDp2 - (((int) (BlockSlideshowCell.this.pageOffset * iDp3)) + (((count - (measuredWidth2 * 2)) - 1) * iDp3));
                        }
                    }
                    int i3 = 0;
                    while (i3 < BlockSlideshowCell.this.currentBlock.items.size()) {
                        int iDp4 = AndroidUtilities.dp(4.0f) + measuredWidth + (AndroidUtilities.dp(13.0f) * i3);
                        Drawable drawable = BlockSlideshowCell.this.currentPage == i3 ? ArticleViewer.this.slideDotBigDrawable : ArticleViewer.this.slideDotDrawable;
                        drawable.setBounds(iDp4 - AndroidUtilities.dp(5.0f), 0, iDp4 + AndroidUtilities.dp(5.0f), AndroidUtilities.dp(10.0f));
                        drawable.draw(canvas);
                        i3++;
                    }
                }
            };
            this.dotsContainer = view;
            addView(view);
            setWillNotDraw(false);
        }

        public void setBlock(TLRPC$TL_pageBlockSlideshow block) throws Resources.NotFoundException {
            this.currentBlock = block;
            this.innerAdapter.notifyDataSetChanged();
            this.innerListView.setCurrentItem(0, false);
            this.innerListView.forceLayout();
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.captionLayout, this.textX, this.textY) || ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.creditLayout, this.textX, this.textY + this.creditOffset) || super.onTouchEvent(event);
        }

        @Override // android.widget.FrameLayout, android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            if (this.currentBlock != null) {
                int iDp2 = AndroidUtilities.dp(310.0f);
                this.innerListView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(iDp2, 1073741824));
                this.currentBlock.items.size();
                this.dotsContainer.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(10.0f), 1073741824));
                int iDp3 = size - AndroidUtilities.dp(36.0f);
                int iDp4 = iDp2 + AndroidUtilities.dp(16.0f);
                this.textY = iDp4;
                ArticleViewer articleViewer = ArticleViewer.this;
                TLRPC$TL_pageBlockSlideshow tLRPC$TL_pageBlockSlideshow = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText = articleViewer.createLayoutForText(this, null, tLRPC$TL_pageBlockSlideshow.caption.text, iDp3, iDp4, tLRPC$TL_pageBlockSlideshow, this.parentAdapter);
                this.captionLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    int iDp5 = AndroidUtilities.dp(4.0f) + this.captionLayout.getHeight();
                    this.creditOffset = iDp5;
                    iDp2 += iDp5 + AndroidUtilities.dp(4.0f);
                    DrawingText drawingText = this.captionLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                } else {
                    this.creditOffset = 0;
                }
                ArticleViewer articleViewer2 = ArticleViewer.this;
                TLRPC$TL_pageBlockSlideshow tLRPC$TL_pageBlockSlideshow2 = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText2 = articleViewer2.createLayoutForText(this, null, tLRPC$TL_pageBlockSlideshow2.caption.credit, iDp3, this.textY + this.creditOffset, tLRPC$TL_pageBlockSlideshow2, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.creditLayout = drawingTextCreateLayoutForText2;
                if (drawingTextCreateLayoutForText2 != null) {
                    iDp2 += AndroidUtilities.dp(4.0f) + this.creditLayout.getHeight();
                    DrawingText drawingText2 = this.creditLayout;
                    drawingText2.x = this.textX;
                    drawingText2.y = this.textY + this.creditOffset;
                }
                iDp = iDp2 + AndroidUtilities.dp(16.0f);
            } else {
                iDp = 1;
            }
            setMeasuredDimension(size, iDp);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            this.innerListView.layout(0, AndroidUtilities.dp(8.0f), this.innerListView.getMeasuredWidth(), AndroidUtilities.dp(8.0f) + this.innerListView.getMeasuredHeight());
            int bottom2 = this.innerListView.getBottom() - AndroidUtilities.dp(23.0f);
            View view = this.dotsContainer;
            view.layout(0, bottom2, view.getMeasuredWidth(), this.dotsContainer.getMeasuredHeight() + bottom2);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            int i = 0;
            if (this.captionLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.captionLayout.draw(canvas);
                canvas.restore();
                i = 1;
            }
            if (this.creditLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY + this.creditOffset);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.creditLayout.draw(canvas);
                canvas.restore();
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.captionLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.creditLayout;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    private class BlockListItemCell extends ViewGroup implements TextSelectionHelper.ArticleSelectableView {
        private RecyclerView.ViewHolder blockLayout;
        private int blockX;
        private int blockY;
        private TL_pageBlockListItem currentBlock;
        private int currentBlockType;
        private boolean drawDot;
        private int numOffsetY;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;
        private boolean verticalAlign;

        public BlockListItemCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.parentAdapter = adapter;
            setWillNotDraw(false);
        }

        public void setBlock(TL_pageBlockListItem block) {
            if (this.currentBlock != block) {
                this.currentBlock = block;
                RecyclerView.ViewHolder viewHolder = this.blockLayout;
                if (viewHolder != null) {
                    removeView(viewHolder.itemView);
                    this.blockLayout = null;
                }
                if (this.currentBlock.blockItem != null) {
                    int typeForBlock = this.parentAdapter.getTypeForBlock(this.currentBlock.blockItem);
                    this.currentBlockType = typeForBlock;
                    RecyclerView.ViewHolder viewHolderOnCreateViewHolder = this.parentAdapter.onCreateViewHolder(this, typeForBlock);
                    this.blockLayout = viewHolderOnCreateViewHolder;
                    addView(viewHolderOnCreateViewHolder.itemView);
                }
            }
            if (this.currentBlock.blockItem != null) {
                this.parentAdapter.bindBlockToHolder(this.currentBlockType, this.blockLayout, this.currentBlock.blockItem, 0, 0);
            }
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY)) {
                return true;
            }
            return super.onTouchEvent(event);
        }

        /* JADX WARN: Removed duplicated region for block: B:117:0x0398  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x03bb  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x03f5  */
        @Override // android.view.View
        @android.annotation.SuppressLint({"NewApi"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r17, int r18) {
            /*
                Method dump skipped, instructions count: 1044
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockListItemCell.onMeasure(int, int):void");
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            RecyclerView.ViewHolder viewHolder = this.blockLayout;
            if (viewHolder != null) {
                View view = viewHolder.itemView;
                int i = this.blockX;
                view.layout(i, this.blockY, view.getMeasuredWidth() + i, this.blockY + this.blockLayout.itemView.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            int measuredWidth = getMeasuredWidth();
            if (this.currentBlock.numLayout != null) {
                canvas.save();
                if (this.parentAdapter.isRtl) {
                    canvas.translate(((measuredWidth - AndroidUtilities.dp(15.0f)) - this.currentBlock.parent.maxNumWidth) - (this.currentBlock.parent.level * AndroidUtilities.dp(12.0f)), (this.textY + this.numOffsetY) - (this.drawDot ? AndroidUtilities.dp(1.0f) : 0));
                } else {
                    canvas.translate(((AndroidUtilities.dp(15.0f) + this.currentBlock.parent.maxNumWidth) - ((int) Math.ceil(this.currentBlock.numLayout.getLineWidth(0)))) + (this.currentBlock.parent.level * AndroidUtilities.dp(12.0f)), (this.textY + this.numOffsetY) - (this.drawDot ? AndroidUtilities.dp(1.0f) : 0));
                }
                this.currentBlock.numLayout.draw(canvas);
                canvas.restore();
            }
            if (this.textLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this);
                this.textLayout.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.view.View, ir.eitaa.ui.Cells.TextSelectionHelper.SelectableView
        public void invalidate() {
            super.invalidate();
            RecyclerView.ViewHolder viewHolder = this.blockLayout;
            if (viewHolder != null) {
                viewHolder.itemView.invalidate();
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            DrawingText drawingText = this.textLayout;
            if (drawingText == null) {
                return;
            }
            info.setText(drawingText.getText());
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            RecyclerView.ViewHolder viewHolder = this.blockLayout;
            if (viewHolder != null) {
                KeyEvent.Callback callback = viewHolder.itemView;
                if (callback instanceof TextSelectionHelper.ArticleSelectableView) {
                    ((TextSelectionHelper.ArticleSelectableView) callback).fillTextLayoutBlocks(blocks);
                }
            }
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private class BlockOrderedListItemCell extends ViewGroup implements TextSelectionHelper.ArticleSelectableView {
        private RecyclerView.ViewHolder blockLayout;
        private int blockX;
        private int blockY;
        private TL_pageBlockOrderedListItem currentBlock;
        private int currentBlockType;
        private int numOffsetY;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;
        private boolean verticalAlign;

        public BlockOrderedListItemCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.parentAdapter = adapter;
            setWillNotDraw(false);
        }

        public void setBlock(TL_pageBlockOrderedListItem block) {
            if (this.currentBlock != block) {
                this.currentBlock = block;
                RecyclerView.ViewHolder viewHolder = this.blockLayout;
                if (viewHolder != null) {
                    removeView(viewHolder.itemView);
                    this.blockLayout = null;
                }
                if (this.currentBlock.blockItem != null) {
                    int typeForBlock = this.parentAdapter.getTypeForBlock(this.currentBlock.blockItem);
                    this.currentBlockType = typeForBlock;
                    RecyclerView.ViewHolder viewHolderOnCreateViewHolder = this.parentAdapter.onCreateViewHolder(this, typeForBlock);
                    this.blockLayout = viewHolderOnCreateViewHolder;
                    addView(viewHolderOnCreateViewHolder.itemView);
                }
            }
            if (this.currentBlock.blockItem != null) {
                this.parentAdapter.bindBlockToHolder(this.currentBlockType, this.blockLayout, this.currentBlock.blockItem, 0, 0);
            }
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY)) {
                return true;
            }
            return super.onTouchEvent(event);
        }

        /* JADX WARN: Removed duplicated region for block: B:106:0x0341  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x0364  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x03b6  */
        @Override // android.view.View
        @android.annotation.SuppressLint({"NewApi"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r17, int r18) {
            /*
                Method dump skipped, instructions count: 981
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockOrderedListItemCell.onMeasure(int, int):void");
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            RecyclerView.ViewHolder viewHolder = this.blockLayout;
            if (viewHolder != null) {
                View view = viewHolder.itemView;
                int i = this.blockX;
                view.layout(i, this.blockY, view.getMeasuredWidth() + i, this.blockY + this.blockLayout.itemView.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            int measuredWidth = getMeasuredWidth();
            if (this.currentBlock.numLayout != null) {
                canvas.save();
                if (this.parentAdapter.isRtl) {
                    canvas.translate(((measuredWidth - AndroidUtilities.dp(18.0f)) - this.currentBlock.parent.maxNumWidth) - (this.currentBlock.parent.level * AndroidUtilities.dp(20.0f)), this.textY + this.numOffsetY);
                } else {
                    canvas.translate(((AndroidUtilities.dp(18.0f) + this.currentBlock.parent.maxNumWidth) - ((int) Math.ceil(this.currentBlock.numLayout.getLineWidth(0)))) + (this.currentBlock.parent.level * AndroidUtilities.dp(20.0f)), this.textY + this.numOffsetY);
                }
                this.currentBlock.numLayout.draw(canvas);
                canvas.restore();
            }
            if (this.textLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this);
                this.textLayout.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.view.View, ir.eitaa.ui.Cells.TextSelectionHelper.SelectableView
        public void invalidate() {
            super.invalidate();
            RecyclerView.ViewHolder viewHolder = this.blockLayout;
            if (viewHolder != null) {
                viewHolder.itemView.invalidate();
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            DrawingText drawingText = this.textLayout;
            if (drawingText == null) {
                return;
            }
            info.setText(drawingText.getText());
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            RecyclerView.ViewHolder viewHolder = this.blockLayout;
            if (viewHolder != null) {
                KeyEvent.Callback callback = viewHolder.itemView;
                if (callback instanceof TextSelectionHelper.ArticleSelectableView) {
                    ((TextSelectionHelper.ArticleSelectableView) callback).fillTextLayoutBlocks(blocks);
                }
            }
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private class BlockDetailsCell extends View implements Drawable.Callback, TextSelectionHelper.ArticleSelectableView {
        private AnimatedArrowDrawable arrow;
        private TLRPC$TL_pageBlockDetails currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }

        public BlockDetailsCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(50.0f);
            this.textY = AndroidUtilities.dp(11.0f) + 1;
            this.parentAdapter = adapter;
            this.arrow = new AnimatedArrowDrawable(ArticleViewer.getGrayTextColor(), true);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate();
        }

        public void setBlock(TLRPC$TL_pageBlockDetails block) {
            this.currentBlock = block;
            this.arrow.setAnimationProgress(block.open ? 0.0f : 1.0f);
            this.arrow.setCallback(this);
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int iDp = AndroidUtilities.dp(39.0f);
            TLRPC$TL_pageBlockDetails tLRPC$TL_pageBlockDetails = this.currentBlock;
            if (tLRPC$TL_pageBlockDetails != null) {
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, tLRPC$TL_pageBlockDetails.title, size - AndroidUtilities.dp(52.0f), 0, this.currentBlock, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    iDp = Math.max(iDp, AndroidUtilities.dp(21.0f) + this.textLayout.getHeight());
                    int height = ((this.textLayout.getHeight() + AndroidUtilities.dp(21.0f)) - this.textLayout.getHeight()) / 2;
                    this.textY = height;
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = height;
                }
            }
            setMeasuredDimension(size, iDp + 1);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            canvas.save();
            canvas.translate(AndroidUtilities.dp(18.0f), ((getMeasuredHeight() - AndroidUtilities.dp(13.0f)) - 1) / 2);
            this.arrow.draw(canvas);
            canvas.restore();
            if (this.textLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this);
                this.textLayout.draw(canvas);
                canvas.restore();
            }
            float measuredHeight = getMeasuredHeight() - 1;
            canvas.drawLine(0.0f, measuredHeight, getMeasuredWidth(), measuredHeight, ArticleViewer.dividerPaint);
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private static class BlockDetailsBottomCell extends View {
        private RectF rect;

        public BlockDetailsBottomCell(Context context) {
            super(context);
            this.rect = new RectF();
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(4.0f) + 1);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawLine(0.0f, 0.0f, getMeasuredWidth(), 0.0f, ArticleViewer.dividerPaint);
        }
    }

    private static class BlockRelatedArticlesShadowCell extends View {
        private CombinedDrawable shadowDrawable;

        public BlockRelatedArticlesShadowCell(Context context) {
            super(context);
            CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, -16777216));
            this.shadowDrawable = combinedDrawable;
            combinedDrawable.setFullsize(true);
            setBackgroundDrawable(this.shadowDrawable);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(12.0f));
            Theme.setCombinedDrawableColor(this.shadowDrawable, Theme.getColor("windowBackgroundGray"), false);
        }
    }

    private class BlockRelatedArticlesHeaderCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockRelatedArticles currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        public BlockRelatedArticlesHeaderCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockRelatedArticles block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockRelatedArticles tLRPC$TL_pageBlockRelatedArticles = this.currentBlock;
            if (tLRPC$TL_pageBlockRelatedArticles != null) {
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, tLRPC$TL_pageBlockRelatedArticles.title, size - AndroidUtilities.dp(52.0f), 0, this.currentBlock, Layout.Alignment.ALIGN_NORMAL, 1, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    this.textY = AndroidUtilities.dp(6.0f) + ((AndroidUtilities.dp(32.0f) - this.textLayout.getHeight()) / 2);
                }
            }
            if (this.textLayout != null) {
                setMeasuredDimension(size, AndroidUtilities.dp(38.0f));
                DrawingText drawingText = this.textLayout;
                drawingText.x = this.textX;
                drawingText.y = this.textY;
                return;
            }
            setMeasuredDimension(size, 1);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null || this.textLayout == null) {
                return;
            }
            canvas.save();
            canvas.translate(this.textX, this.textY);
            ArticleViewer.this.drawTextSelection(canvas, this);
            this.textLayout.draw(canvas);
            canvas.restore();
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private class BlockRelatedArticlesCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TL_pageBlockRelatedArticlesChild currentBlock;
        private boolean divider;
        private boolean drawImage;
        private ImageReceiver imageView;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private DrawingText textLayout2;
        private int textOffset;
        private int textX;
        private int textY;

        public BlockRelatedArticlesCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.textY = AndroidUtilities.dp(10.0f);
            this.parentAdapter = adapter;
            ImageReceiver imageReceiver = new ImageReceiver(this);
            this.imageView = imageReceiver;
            imageReceiver.setRoundRadius(AndroidUtilities.dp(6.0f));
        }

        public void setBlock(TL_pageBlockRelatedArticlesChild block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        @SuppressLint({"DrawAllocation", "NewApi"})
        protected void onMeasure(int i, int i2) {
            int i3;
            boolean z;
            int i4;
            String string;
            int size = View.MeasureSpec.getSize(i);
            this.divider = this.currentBlock.num != this.currentBlock.parent.articles.size() - 1;
            TLRPC$TL_pageRelatedArticle tLRPC$TL_pageRelatedArticle = this.currentBlock.parent.articles.get(this.currentBlock.num);
            int iDp = AndroidUtilities.dp(SharedConfig.ivFontSize - 16);
            long j = tLRPC$TL_pageRelatedArticle.photo_id;
            TLRPC$Photo photoWithId = j != 0 ? this.parentAdapter.getPhotoWithId(j) : null;
            if (photoWithId != null) {
                this.drawImage = true;
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(photoWithId.sizes, AndroidUtilities.getPhotoSize());
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(photoWithId.sizes, 80, true);
                this.imageView.setImage(ImageLocation.getForPhoto(closestPhotoSizeWithSize, photoWithId), "64_64", ImageLocation.getForPhoto(closestPhotoSizeWithSize != closestPhotoSizeWithSize2 ? closestPhotoSizeWithSize2 : null, photoWithId), "64_64_b", closestPhotoSizeWithSize.size, null, this.parentAdapter.currentPage, 1);
            } else {
                this.drawImage = false;
            }
            int iDp2 = AndroidUtilities.dp(60.0f);
            int iDp3 = size - AndroidUtilities.dp(36.0f);
            if (this.drawImage) {
                float fDp = AndroidUtilities.dp(44.0f);
                this.imageView.setImageCoords((size - r1) - AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), fDp, fDp);
                iDp3 = (int) (iDp3 - (this.imageView.getImageWidth() + AndroidUtilities.dp(6.0f)));
            }
            int i5 = iDp3;
            int iDp4 = AndroidUtilities.dp(18.0f);
            String str = tLRPC$TL_pageRelatedArticle.title;
            if (str != null) {
                i3 = iDp2;
                this.textLayout = ArticleViewer.this.createLayoutForText(this, str, null, i5, this.textY, this.currentBlock, Layout.Alignment.ALIGN_NORMAL, 3, this.parentAdapter);
            } else {
                i3 = iDp2;
            }
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                int lineCount = drawingText.getLineCount();
                int i6 = 4 - lineCount;
                this.textOffset = this.textLayout.getHeight() + AndroidUtilities.dp(6.0f) + iDp;
                iDp4 += this.textLayout.getHeight();
                int i7 = 0;
                while (true) {
                    if (i7 >= lineCount) {
                        z = false;
                        break;
                    } else {
                        if (this.textLayout.getLineLeft(i7) != 0.0f) {
                            z = true;
                            break;
                        }
                        i7++;
                    }
                }
                DrawingText drawingText2 = this.textLayout;
                drawingText2.x = this.textX;
                drawingText2.y = this.textY;
                i4 = i6;
            } else {
                this.textOffset = 0;
                z = false;
                i4 = 4;
            }
            if (tLRPC$TL_pageRelatedArticle.published_date != 0 && !TextUtils.isEmpty(tLRPC$TL_pageRelatedArticle.author)) {
                string = LocaleController.formatString("ArticleDateByAuthor", R.string.ArticleDateByAuthor, LocaleController.getInstance().chatFullDate.format(tLRPC$TL_pageRelatedArticle.published_date * 1000), tLRPC$TL_pageRelatedArticle.author);
            } else if (!TextUtils.isEmpty(tLRPC$TL_pageRelatedArticle.author)) {
                string = LocaleController.formatString("ArticleByAuthor", R.string.ArticleByAuthor, tLRPC$TL_pageRelatedArticle.author);
            } else if (tLRPC$TL_pageRelatedArticle.published_date != 0) {
                string = LocaleController.getInstance().chatFullDate.format(tLRPC$TL_pageRelatedArticle.published_date * 1000);
            } else if (!TextUtils.isEmpty(tLRPC$TL_pageRelatedArticle.description)) {
                string = tLRPC$TL_pageRelatedArticle.description;
            } else {
                string = tLRPC$TL_pageRelatedArticle.url;
            }
            DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, string, null, i5, this.textOffset + this.textY, this.currentBlock, (this.parentAdapter.isRtl || z) ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, i4, this.parentAdapter);
            this.textLayout2 = drawingTextCreateLayoutForText;
            if (drawingTextCreateLayoutForText != null) {
                iDp4 += drawingTextCreateLayoutForText.getHeight();
                if (this.textLayout != null) {
                    iDp4 += AndroidUtilities.dp(6.0f) + iDp;
                }
                DrawingText drawingText3 = this.textLayout2;
                drawingText3.x = this.textX;
                drawingText3.y = this.textY + this.textOffset;
            }
            setMeasuredDimension(size, Math.max(i3, iDp4) + (this.divider ? 1 : 0));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            if (this.currentBlock == null) {
                return;
            }
            if (this.drawImage) {
                this.imageView.draw(canvas);
            }
            canvas.save();
            canvas.translate(this.textX, AndroidUtilities.dp(10.0f));
            if (this.textLayout != null) {
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.textLayout.draw(canvas);
                i = 1;
            } else {
                i = 0;
            }
            if (this.textLayout2 != null) {
                canvas.translate(0.0f, this.textOffset);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.textLayout2.draw(canvas);
            }
            canvas.restore();
            if (this.divider) {
                canvas.drawLine(this.parentAdapter.isRtl ? 0.0f : AndroidUtilities.dp(17.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (this.parentAdapter.isRtl ? AndroidUtilities.dp(17.0f) : 0), getMeasuredHeight() - 1, ArticleViewer.dividerPaint);
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.textLayout2;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    private class BlockHeaderCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockHeader currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        public BlockHeaderCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.textY = AndroidUtilities.dp(8.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockHeader block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockHeader tLRPC$TL_pageBlockHeader = this.currentBlock;
            int iDp = 0;
            if (tLRPC$TL_pageBlockHeader != null) {
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, tLRPC$TL_pageBlockHeader.text, size - AndroidUtilities.dp(36.0f), this.textY, this.currentBlock, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    iDp = 0 + AndroidUtilities.dp(16.0f) + this.textLayout.getHeight();
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
            } else {
                iDp = 1;
            }
            setMeasuredDimension(size, iDp);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null || this.textLayout == null) {
                return;
            }
            canvas.save();
            canvas.translate(this.textX, this.textY);
            ArticleViewer.this.drawTextSelection(canvas, this);
            this.textLayout.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            if (this.textLayout == null) {
                return;
            }
            info.setText(((Object) this.textLayout.getText()) + ", " + LocaleController.getString("AccDescrIVHeading", R.string.AccDescrIVHeading));
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private static class BlockDividerCell extends View {
        private RectF rect;

        public BlockDividerCell(Context context) {
            super(context);
            this.rect = new RectF();
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(18.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.rect.set(getMeasuredWidth() / 3, AndroidUtilities.dp(8.0f), r0 * 2, AndroidUtilities.dp(10.0f));
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), ArticleViewer.dividerPaint);
        }
    }

    private class BlockSubtitleCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockSubtitle currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        public BlockSubtitleCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.textY = AndroidUtilities.dp(8.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockSubtitle block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockSubtitle tLRPC$TL_pageBlockSubtitle = this.currentBlock;
            int iDp = 0;
            if (tLRPC$TL_pageBlockSubtitle != null) {
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, tLRPC$TL_pageBlockSubtitle.text, size - AndroidUtilities.dp(36.0f), this.textY, this.currentBlock, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    iDp = 0 + AndroidUtilities.dp(16.0f) + this.textLayout.getHeight();
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
            } else {
                iDp = 1;
            }
            setMeasuredDimension(size, iDp);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null || this.textLayout == null) {
                return;
            }
            canvas.save();
            canvas.translate(this.textX, this.textY);
            ArticleViewer.this.drawTextSelection(canvas, this);
            this.textLayout.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            if (this.textLayout == null) {
                return;
            }
            info.setText(((Object) this.textLayout.getText()) + ", " + LocaleController.getString("AccDescrIVHeading", R.string.AccDescrIVHeading));
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private class BlockPullquoteCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockPullquote currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private DrawingText textLayout2;
        private int textX;
        private int textY;
        private int textY2;

        public BlockPullquoteCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.textY = AndroidUtilities.dp(8.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockPullquote block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout2, this.textX, this.textY2) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockPullquote tLRPC$TL_pageBlockPullquote = this.currentBlock;
            if (tLRPC$TL_pageBlockPullquote != null) {
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, tLRPC$TL_pageBlockPullquote.text, size - AndroidUtilities.dp(36.0f), this.textY, this.currentBlock, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                iDp = 0;
                if (drawingTextCreateLayoutForText != null) {
                    iDp = 0 + AndroidUtilities.dp(8.0f) + this.textLayout.getHeight();
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
                this.textY2 = AndroidUtilities.dp(2.0f) + iDp;
                DrawingText drawingTextCreateLayoutForText2 = ArticleViewer.this.createLayoutForText(this, null, this.currentBlock.caption, size - AndroidUtilities.dp(36.0f), this.textY2, this.currentBlock, this.parentAdapter);
                this.textLayout2 = drawingTextCreateLayoutForText2;
                if (drawingTextCreateLayoutForText2 != null) {
                    iDp += AndroidUtilities.dp(8.0f) + this.textLayout2.getHeight();
                    DrawingText drawingText2 = this.textLayout2;
                    drawingText2.x = this.textX;
                    drawingText2.y = this.textY2;
                }
                if (iDp != 0) {
                    iDp += AndroidUtilities.dp(8.0f);
                }
            } else {
                iDp = 1;
            }
            setMeasuredDimension(size, iDp);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            int i = 0;
            if (this.textLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.textLayout.draw(canvas);
                canvas.restore();
                i = 1;
            }
            if (this.textLayout2 != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY2);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.textLayout2.draw(canvas);
                canvas.restore();
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.textLayout2;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    private class BlockBlockquoteCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockBlockquote currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private DrawingText textLayout2;
        private int textX;
        private int textY;
        private int textY2;

        public BlockBlockquoteCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textY = AndroidUtilities.dp(8.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockBlockquote block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout2, this.textX, this.textY2) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            if (this.currentBlock != null) {
                int iDp2 = size - AndroidUtilities.dp(50.0f);
                if (this.currentBlock.level > 0) {
                    iDp2 -= AndroidUtilities.dp(r0 * 14);
                }
                ArticleViewer articleViewer = ArticleViewer.this;
                TLRPC$TL_pageBlockBlockquote tLRPC$TL_pageBlockBlockquote = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText = articleViewer.createLayoutForText(this, null, tLRPC$TL_pageBlockBlockquote.text, iDp2, this.textY, tLRPC$TL_pageBlockBlockquote, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                iDp = drawingTextCreateLayoutForText != null ? 0 + AndroidUtilities.dp(8.0f) + this.textLayout.getHeight() : 0;
                if (this.currentBlock.level > 0) {
                    if (this.parentAdapter.isRtl) {
                        this.textX = AndroidUtilities.dp((this.currentBlock.level * 14) + 14);
                    } else {
                        this.textX = AndroidUtilities.dp(this.currentBlock.level * 14) + AndroidUtilities.dp(32.0f);
                    }
                } else if (this.parentAdapter.isRtl) {
                    this.textX = AndroidUtilities.dp(14.0f);
                } else {
                    this.textX = AndroidUtilities.dp(32.0f);
                }
                int iDp3 = iDp + AndroidUtilities.dp(8.0f);
                this.textY2 = iDp3;
                ArticleViewer articleViewer2 = ArticleViewer.this;
                TLRPC$TL_pageBlockBlockquote tLRPC$TL_pageBlockBlockquote2 = this.currentBlock;
                DrawingText drawingTextCreateLayoutForText2 = articleViewer2.createLayoutForText(this, null, tLRPC$TL_pageBlockBlockquote2.caption, iDp2, iDp3, tLRPC$TL_pageBlockBlockquote2, this.parentAdapter);
                this.textLayout2 = drawingTextCreateLayoutForText2;
                if (drawingTextCreateLayoutForText2 != null) {
                    iDp += AndroidUtilities.dp(8.0f) + this.textLayout2.getHeight();
                }
                if (iDp != 0) {
                    iDp += AndroidUtilities.dp(8.0f);
                }
                DrawingText drawingText = this.textLayout;
                if (drawingText != null) {
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
                DrawingText drawingText2 = this.textLayout2;
                if (drawingText2 != null) {
                    drawingText2.x = this.textX;
                    drawingText2.y = this.textY2;
                }
            } else {
                iDp = 1;
            }
            setMeasuredDimension(size, iDp);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            if (this.currentBlock == null) {
                return;
            }
            if (this.textLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                i = 1;
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.textLayout.draw(canvas);
                canvas.restore();
            } else {
                i = 0;
            }
            if (this.textLayout2 != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY2);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.textLayout2.draw(canvas);
                canvas.restore();
            }
            if (!this.parentAdapter.isRtl) {
                canvas.drawRect(AndroidUtilities.dp((this.currentBlock.level * 14) + 18), AndroidUtilities.dp(6.0f), AndroidUtilities.dp((this.currentBlock.level * 14) + 20), getMeasuredHeight() - AndroidUtilities.dp(6.0f), ArticleViewer.quoteLinePaint);
            } else {
                canvas.drawRect(getMeasuredWidth() - AndroidUtilities.dp(20.0f), AndroidUtilities.dp(6.0f), r0 + AndroidUtilities.dp(2.0f), getMeasuredHeight() - AndroidUtilities.dp(6.0f), ArticleViewer.quoteLinePaint);
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.textLayout2;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    private class BlockPhotoCell extends FrameLayout implements DownloadController.FileDownloadProgressListener, TextSelectionHelper.ArticleSelectableView {
        private int TAG;
        boolean autoDownload;
        private int buttonPressed;
        private int buttonState;
        private int buttonX;
        private int buttonY;
        private DrawingText captionLayout;
        private BlockChannelCell channelCell;
        private DrawingText creditLayout;
        private int creditOffset;
        private TLRPC$TL_pageBlockPhoto currentBlock;
        private String currentFilter;
        private TLRPC$Photo currentPhoto;
        private TLRPC$PhotoSize currentPhotoObject;
        private TLRPC$PhotoSize currentPhotoObjectThumb;
        private String currentThumbFilter;
        private int currentType;
        private MessageObject.GroupedMessagePosition groupPosition;
        private ImageReceiver imageView;
        private boolean isFirst;
        private Drawable linkDrawable;
        private WebpageAdapter parentAdapter;
        private TLRPC$PageBlock parentBlock;
        private boolean photoPressed;
        private RadialProgress2 radialProgress;
        private int textX;
        private int textY;

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
        }

        public BlockPhotoCell(Context context, WebpageAdapter adapter, int type) {
            super(context);
            this.parentAdapter = adapter;
            setWillNotDraw(false);
            this.imageView = new ImageReceiver(this);
            this.channelCell = ArticleViewer.this.new BlockChannelCell(context, this.parentAdapter, 1);
            RadialProgress2 radialProgress2 = new RadialProgress2(this);
            this.radialProgress = radialProgress2;
            radialProgress2.setProgressColor(-1);
            this.radialProgress.setColors(1711276032, 2130706432, -1, -2500135);
            this.TAG = DownloadController.getInstance(ArticleViewer.this.currentAccount).generateObserverTag();
            addView(this.channelCell, LayoutHelper.createFrame(-1, -2.0f));
            this.currentType = type;
        }

        public void setBlock(TLRPC$TL_pageBlockPhoto block, boolean first, boolean last) throws Resources.NotFoundException {
            TLRPC$Photo photoWithId;
            this.parentBlock = null;
            this.currentBlock = block;
            this.isFirst = first;
            this.channelCell.setVisibility(4);
            if (!TextUtils.isEmpty(this.currentBlock.url)) {
                this.linkDrawable = getResources().getDrawable(R.drawable.instant_link);
            }
            TLRPC$TL_pageBlockPhoto tLRPC$TL_pageBlockPhoto = this.currentBlock;
            if (tLRPC$TL_pageBlockPhoto != null && (photoWithId = this.parentAdapter.getPhotoWithId(tLRPC$TL_pageBlockPhoto.photo_id)) != null) {
                this.currentPhotoObject = FileLoader.getClosestPhotoSizeWithSize(photoWithId.sizes, AndroidUtilities.getPhotoSize());
            } else {
                this.currentPhotoObject = null;
            }
            updateButtonState(false);
            requestLayout();
        }

        public void setParentBlock(TLRPC$PageBlock block) {
            this.parentBlock = block;
            if (this.parentAdapter.channelBlock == null || !(this.parentBlock instanceof TLRPC$TL_pageBlockCover)) {
                return;
            }
            this.channelCell.setBlock(this.parentAdapter.channelBlock);
            this.channelCell.setVisibility(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r13) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 284
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockPhotoCell.onTouchEvent(android.view.MotionEvent):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x015a  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01d4  */
        @Override // android.widget.FrameLayout, android.view.View
        @android.annotation.SuppressLint({"NewApi"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r28, int r29) {
            /*
                Method dump skipped, instructions count: 846
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockPhotoCell.onMeasure(int, int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            if (this.currentBlock == null) {
                return;
            }
            if (!this.imageView.hasBitmapImage() || this.imageView.getCurrentAlpha() != 1.0f) {
                canvas.drawRect(this.imageView.getImageX(), this.imageView.getImageY(), this.imageView.getImageX2(), this.imageView.getImageY2(), ArticleViewer.photoBackgroundPaint);
            }
            if (!ArticleViewer.this.pinchToZoomHelper.isInOverlayModeFor(this)) {
                this.imageView.draw(canvas);
                if (this.imageView.getVisible()) {
                    this.radialProgress.draw(canvas);
                }
            }
            if (!TextUtils.isEmpty(this.currentBlock.url)) {
                int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(35.0f);
                int imageY = (int) (this.imageView.getImageY() + AndroidUtilities.dp(11.0f));
                this.linkDrawable.setBounds(measuredWidth, imageY, AndroidUtilities.dp(24.0f) + measuredWidth, AndroidUtilities.dp(24.0f) + imageY);
                this.linkDrawable.draw(canvas);
            }
            if (this.captionLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                i = 1;
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.captionLayout.draw(canvas);
                canvas.restore();
            } else {
                i = 0;
            }
            if (this.creditLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY + this.creditOffset);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.creditLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        private int getIconForCurrentState() {
            int i = this.buttonState;
            if (i == 0) {
                return 2;
            }
            return i == 1 ? 3 : 4;
        }

        private void didPressedButton(boolean animated) {
            int i = this.buttonState;
            if (i == 0) {
                this.radialProgress.setProgress(0.0f, animated);
                this.imageView.setImage(ImageLocation.getForPhoto(this.currentPhotoObject, this.currentPhoto), this.currentFilter, ImageLocation.getForPhoto(this.currentPhotoObjectThumb, this.currentPhoto), this.currentThumbFilter, this.currentPhotoObject.size, null, this.parentAdapter.currentPage, 1);
                this.buttonState = 1;
                this.radialProgress.setIcon(getIconForCurrentState(), true, animated);
                invalidate();
                return;
            }
            if (i == 1) {
                this.imageView.cancelLoadImage();
                this.buttonState = 0;
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
                invalidate();
            }
        }

        public void updateButtonState(boolean animated) {
            String attachFileName = FileLoader.getAttachFileName(this.currentPhotoObject);
            boolean zExists = FileLoader.getPathToAttach(this.currentPhotoObject, true).exists();
            if (TextUtils.isEmpty(attachFileName)) {
                this.radialProgress.setIcon(4, false, false);
                return;
            }
            if (zExists) {
                DownloadController.getInstance(ArticleViewer.this.currentAccount).removeLoadingFileObserver(this);
                this.buttonState = -1;
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
            } else {
                DownloadController.getInstance(ArticleViewer.this.currentAccount).addLoadingFileObserver(attachFileName, null, this);
                float fFloatValue = 0.0f;
                if (this.autoDownload || FileLoader.getInstance(ArticleViewer.this.currentAccount).isLoadingFile(attachFileName)) {
                    this.buttonState = 1;
                    Float fileProgress = ImageLoader.getInstance().getFileProgress(attachFileName);
                    if (fileProgress != null) {
                        fFloatValue = fileProgress.floatValue();
                    }
                } else {
                    this.buttonState = 0;
                }
                this.radialProgress.setIcon(getIconForCurrentState(), true, animated);
                this.radialProgress.setProgress(fFloatValue, false);
            }
            invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.imageView.onDetachedFromWindow();
            DownloadController.getInstance(ArticleViewer.this.currentAccount).removeLoadingFileObserver(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.imageView.onAttachedToWindow();
            updateButtonState(false);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onFailedDownload(String fileName, boolean canceled) {
            updateButtonState(false);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onSuccessDownload(String fileName) {
            this.radialProgress.setProgress(1.0f, true);
            updateButtonState(true);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onProgressDownload(String fileName, long downloadSize, long totalSize) {
            this.radialProgress.setProgress(Math.min(1.0f, downloadSize / totalSize), true);
            if (this.buttonState != 1) {
                updateButtonState(true);
            }
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public int getObserverTag() {
            return this.TAG;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            StringBuilder sb = new StringBuilder(LocaleController.getString("AttachPhoto", R.string.AttachPhoto));
            if (this.captionLayout != null) {
                sb.append(", ");
                sb.append(this.captionLayout.getText());
            }
            info.setText(sb.toString());
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.captionLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.creditLayout;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    private class BlockMapCell extends FrameLayout implements TextSelectionHelper.ArticleSelectableView {
        private DrawingText captionLayout;
        private DrawingText creditLayout;
        private int creditOffset;
        private TLRPC$TL_pageBlockMap currentBlock;
        private int currentMapProvider;
        private int currentType;
        private ImageReceiver imageView;
        private boolean isFirst;
        private WebpageAdapter parentAdapter;
        private boolean photoPressed;
        private int textX;
        private int textY;

        public BlockMapCell(Context context, WebpageAdapter adapter, int type) {
            super(context);
            this.parentAdapter = adapter;
            setWillNotDraw(false);
            this.imageView = new ImageReceiver(this);
            this.currentType = type;
        }

        public void setBlock(TLRPC$TL_pageBlockMap block, boolean first, boolean last) {
            this.currentBlock = block;
            this.isFirst = first;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();
            if (event.getAction() == 0 && this.imageView.isInsideImage(x, y)) {
                this.photoPressed = true;
            } else if (event.getAction() == 1 && this.photoPressed) {
                this.photoPressed = false;
                try {
                    TLRPC$GeoPoint tLRPC$GeoPoint = this.currentBlock.geo;
                    double d = tLRPC$GeoPoint.lat;
                    double d2 = tLRPC$GeoPoint._long;
                    ArticleViewer.this.parentActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + d + "," + d2 + "?q=" + d + "," + d2)));
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else if (event.getAction() == 3) {
                this.photoPressed = false;
            }
            return this.photoPressed || ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.captionLayout, this.textX, this.textY) || ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.creditLayout, this.textX, this.textY + this.creditOffset) || super.onTouchEvent(event);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x009d A[PHI: r0
          0x009d: PHI (r0v3 int) = (r0v2 int), (r0v41 int) binds: [B:18:0x0060, B:20:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.widget.FrameLayout, android.view.View
        @android.annotation.SuppressLint({"NewApi"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r25, int r26) {
            /*
                Method dump skipped, instructions count: 498
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.BlockMapCell.onMeasure(int, int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            if (this.currentBlock == null) {
                return;
            }
            Theme.chat_docBackPaint.setColor(Theme.getColor("chat_inLocationBackground"));
            canvas.drawRect(this.imageView.getImageX(), this.imageView.getImageY(), this.imageView.getImageX2(), this.imageView.getImageY2(), Theme.chat_docBackPaint);
            int centerX = (int) (this.imageView.getCenterX() - (Theme.chat_locationDrawable[0].getIntrinsicWidth() / 2));
            int centerY = (int) (this.imageView.getCenterY() - (Theme.chat_locationDrawable[0].getIntrinsicHeight() / 2));
            Drawable[] drawableArr = Theme.chat_locationDrawable;
            drawableArr[0].setBounds(centerX, centerY, drawableArr[0].getIntrinsicWidth() + centerX, Theme.chat_locationDrawable[0].getIntrinsicHeight() + centerY);
            Theme.chat_locationDrawable[0].draw(canvas);
            this.imageView.draw(canvas);
            if (this.currentMapProvider == 2 && this.imageView.hasNotThumb()) {
                int intrinsicWidth = (int) (Theme.chat_redLocationIcon.getIntrinsicWidth() * 0.8f);
                int intrinsicHeight = (int) (Theme.chat_redLocationIcon.getIntrinsicHeight() * 0.8f);
                int imageX = (int) (this.imageView.getImageX() + ((this.imageView.getImageWidth() - intrinsicWidth) / 2.0f));
                int imageY = (int) (this.imageView.getImageY() + ((this.imageView.getImageHeight() / 2.0f) - intrinsicHeight));
                Theme.chat_redLocationIcon.setAlpha((int) (this.imageView.getCurrentAlpha() * 255.0f));
                Theme.chat_redLocationIcon.setBounds(imageX, imageY, intrinsicWidth + imageX, intrinsicHeight + imageY);
                Theme.chat_redLocationIcon.draw(canvas);
            }
            if (this.captionLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                i = 1;
                ArticleViewer.this.drawTextSelection(canvas, this, 0);
                this.captionLayout.draw(canvas);
                canvas.restore();
            } else {
                i = 0;
            }
            if (this.creditLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY + this.creditOffset);
                ArticleViewer.this.drawTextSelection(canvas, this, i);
                this.creditLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            StringBuilder sb = new StringBuilder(LocaleController.getString("Map", R.string.Map));
            if (this.captionLayout != null) {
                sb.append(", ");
                sb.append(this.captionLayout.getText());
            }
            info.setText(sb.toString());
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.captionLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
            DrawingText drawingText2 = this.creditLayout;
            if (drawingText2 != null) {
                blocks.add(drawingText2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class BlockChannelCell extends FrameLayout implements TextSelectionHelper.ArticleSelectableView {
        private Paint backgroundPaint;
        private int buttonWidth;
        private AnimatorSet currentAnimation;
        private TLRPC$TL_pageBlockChannel currentBlock;
        private int currentState;
        private int currentType;
        private ImageView imageView;
        private WebpageAdapter parentAdapter;
        private ContextProgressView progressView;
        private DrawingText textLayout;
        private TextView textView;
        private int textX;
        private int textX2;
        private int textY;

        public BlockChannelCell(Context context, WebpageAdapter adapter, int type) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.textY = AndroidUtilities.dp(11.0f);
            this.parentAdapter = adapter;
            setWillNotDraw(false);
            this.backgroundPaint = new Paint();
            this.currentType = type;
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextSize(1, 14.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.textView.setText(LocaleController.getString("ChannelJoin", R.string.ChannelJoin));
            this.textView.setGravity(19);
            addView(this.textView, LayoutHelper.createFrame(-2, 39, 53));
            this.textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$BlockChannelCell$dzmn0Vl2ec4NSYTgU2I842R9vR0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$ArticleViewer$BlockChannelCell(view);
                }
            });
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setImageResource(R.drawable.list_check);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView, LayoutHelper.createFrame(39, 39, 53));
            ContextProgressView contextProgressView = new ContextProgressView(context, 0);
            this.progressView = contextProgressView;
            addView(contextProgressView, LayoutHelper.createFrame(39, 39, 53));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ArticleViewer$BlockChannelCell(View view) {
            if (this.currentState != 0) {
                return;
            }
            setState(1, true);
            ArticleViewer articleViewer = ArticleViewer.this;
            articleViewer.joinChannel(this, articleViewer.loadedChannel);
        }

        public void setBlock(TLRPC$TL_pageBlockChannel block) {
            this.currentBlock = block;
            if (this.currentType == 0) {
                int color = Theme.getColor("switchTrack");
                int iRed = Color.red(color);
                int iGreen = Color.green(color);
                int iBlue = Color.blue(color);
                this.textView.setTextColor(ArticleViewer.this.getLinkTextColor());
                this.backgroundPaint.setColor(Color.argb(34, iRed, iGreen, iBlue));
                this.imageView.setColorFilter(new PorterDuffColorFilter(ArticleViewer.getGrayTextColor(), PorterDuff.Mode.MULTIPLY));
            } else {
                this.textView.setTextColor(-1);
                this.backgroundPaint.setColor(2130706432);
                this.imageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
            }
            TLRPC$Chat chat = MessagesController.getInstance(ArticleViewer.this.currentAccount).getChat(Long.valueOf(block.channel.id));
            if (chat == null || chat.min) {
                ArticleViewer.this.loadChannel(this, this.parentAdapter, block.channel);
                setState(1, false);
            } else {
                ArticleViewer.this.loadedChannel = chat;
                if (chat.left && !chat.kicked) {
                    setState(0, false);
                } else {
                    setState(4, false);
                }
            }
            requestLayout();
        }

        public void setState(int state, boolean animated) {
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.currentState = state;
            if (animated) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.currentAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[9];
                TextView textView = this.textView;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = state == 0 ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property, fArr);
                TextView textView2 = this.textView;
                Property property2 = View.SCALE_X;
                float[] fArr2 = new float[1];
                fArr2[0] = state == 0 ? 1.0f : 0.1f;
                animatorArr[1] = ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) property2, fArr2);
                TextView textView3 = this.textView;
                Property property3 = View.SCALE_Y;
                float[] fArr3 = new float[1];
                fArr3[0] = state == 0 ? 1.0f : 0.1f;
                animatorArr[2] = ObjectAnimator.ofFloat(textView3, (Property<TextView, Float>) property3, fArr3);
                ContextProgressView contextProgressView = this.progressView;
                Property property4 = View.ALPHA;
                float[] fArr4 = new float[1];
                fArr4[0] = state == 1 ? 1.0f : 0.0f;
                animatorArr[3] = ObjectAnimator.ofFloat(contextProgressView, (Property<ContextProgressView, Float>) property4, fArr4);
                ContextProgressView contextProgressView2 = this.progressView;
                Property property5 = View.SCALE_X;
                float[] fArr5 = new float[1];
                fArr5[0] = state == 1 ? 1.0f : 0.1f;
                animatorArr[4] = ObjectAnimator.ofFloat(contextProgressView2, (Property<ContextProgressView, Float>) property5, fArr5);
                ContextProgressView contextProgressView3 = this.progressView;
                Property property6 = View.SCALE_Y;
                float[] fArr6 = new float[1];
                fArr6[0] = state == 1 ? 1.0f : 0.1f;
                animatorArr[5] = ObjectAnimator.ofFloat(contextProgressView3, (Property<ContextProgressView, Float>) property6, fArr6);
                ImageView imageView = this.imageView;
                Property property7 = View.ALPHA;
                float[] fArr7 = new float[1];
                fArr7[0] = state == 2 ? 1.0f : 0.0f;
                animatorArr[6] = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property7, fArr7);
                ImageView imageView2 = this.imageView;
                Property property8 = View.SCALE_X;
                float[] fArr8 = new float[1];
                fArr8[0] = state == 2 ? 1.0f : 0.1f;
                animatorArr[7] = ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property8, fArr8);
                ImageView imageView3 = this.imageView;
                Property property9 = View.SCALE_Y;
                float[] fArr9 = new float[1];
                fArr9[0] = state == 2 ? 1.0f : 0.1f;
                animatorArr[8] = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property9, fArr9);
                animatorSet2.playTogether(animatorArr);
                this.currentAnimation.setDuration(150L);
                this.currentAnimation.start();
                return;
            }
            this.textView.setAlpha(state == 0 ? 1.0f : 0.0f);
            this.textView.setScaleX(state == 0 ? 1.0f : 0.1f);
            this.textView.setScaleY(state == 0 ? 1.0f : 0.1f);
            this.progressView.setAlpha(state == 1 ? 1.0f : 0.0f);
            this.progressView.setScaleX(state == 1 ? 1.0f : 0.1f);
            this.progressView.setScaleY(state == 1 ? 1.0f : 0.1f);
            this.imageView.setAlpha(state == 2 ? 1.0f : 0.0f);
            this.imageView.setScaleX(state == 2 ? 1.0f : 0.1f);
            this.imageView.setScaleY(state == 2 ? 1.0f : 0.1f);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (this.currentType != 0) {
                return super.onTouchEvent(event);
            }
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.widget.FrameLayout, android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            setMeasuredDimension(size, AndroidUtilities.dp(48.0f));
            this.textView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(39.0f), 1073741824));
            this.buttonWidth = this.textView.getMeasuredWidth();
            this.progressView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(39.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(39.0f), 1073741824));
            this.imageView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(39.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(39.0f), 1073741824));
            TLRPC$TL_pageBlockChannel tLRPC$TL_pageBlockChannel = this.currentBlock;
            if (tLRPC$TL_pageBlockChannel != null) {
                this.textLayout = ArticleViewer.this.createLayoutForText(this, tLRPC$TL_pageBlockChannel.channel.title, null, (size - AndroidUtilities.dp(52.0f)) - this.buttonWidth, this.textY, this.currentBlock, StaticLayoutEx.ALIGN_LEFT(), this.parentAdapter);
                if (this.parentAdapter.isRtl) {
                    this.textX2 = this.textX;
                } else {
                    this.textX2 = (getMeasuredWidth() - this.textX) - this.buttonWidth;
                }
                DrawingText drawingText = this.textLayout;
                if (drawingText != null) {
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            this.imageView.layout((this.textX2 + (this.buttonWidth / 2)) - AndroidUtilities.dp(19.0f), 0, this.textX2 + (this.buttonWidth / 2) + AndroidUtilities.dp(20.0f), AndroidUtilities.dp(39.0f));
            this.progressView.layout((this.textX2 + (this.buttonWidth / 2)) - AndroidUtilities.dp(19.0f), 0, this.textX2 + (this.buttonWidth / 2) + AndroidUtilities.dp(20.0f), AndroidUtilities.dp(39.0f));
            TextView textView = this.textView;
            int i = this.textX2;
            textView.layout(i, 0, textView.getMeasuredWidth() + i, this.textView.getMeasuredHeight());
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), AndroidUtilities.dp(39.0f), this.backgroundPaint);
            DrawingText drawingText = this.textLayout;
            if (drawingText == null || drawingText.getLineCount() <= 0) {
                return;
            }
            canvas.save();
            if (this.parentAdapter.isRtl) {
                canvas.translate((getMeasuredWidth() - this.textLayout.getLineWidth(0)) - this.textX, this.textY);
            } else {
                canvas.translate(this.textX, this.textY);
            }
            if (this.currentType == 0) {
                ArticleViewer.this.drawTextSelection(canvas, this);
            }
            this.textLayout.draw(canvas);
            canvas.restore();
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private class BlockAuthorDateCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockAuthorDate currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        public BlockAuthorDateCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textY = AndroidUtilities.dp(8.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockAuthorDate block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v10, types: [android.text.Spannable] */
        /* JADX WARN: Type inference failed for: r15v11 */
        /* JADX WARN: Type inference failed for: r15v26 */
        /* JADX WARN: Type inference failed for: r15v27 */
        /* JADX WARN: Type inference failed for: r15v28 */
        /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r15v9 */
        /* JADX WARN: Type inference failed for: r4v9, types: [android.text.Spannable$Factory] */
        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            Spannable spannable;
            CharSequence charSequenceNewSpannable;
            int iIndexOf;
            int size = View.MeasureSpec.getSize(i);
            TLRPC$TL_pageBlockAuthorDate tLRPC$TL_pageBlockAuthorDate = this.currentBlock;
            int i3 = 1;
            if (tLRPC$TL_pageBlockAuthorDate != null) {
                ArticleViewer articleViewer = ArticleViewer.this;
                WebpageAdapter webpageAdapter = this.parentAdapter;
                TLRPC$RichText tLRPC$RichText = tLRPC$TL_pageBlockAuthorDate.author;
                CharSequence text = articleViewer.getText(webpageAdapter, this, tLRPC$RichText, tLRPC$RichText, tLRPC$TL_pageBlockAuthorDate, size);
                MetricAffectingSpan[] metricAffectingSpanArr = null;
                if (text instanceof Spannable) {
                    Spannable spannable2 = (Spannable) text;
                    metricAffectingSpanArr = (MetricAffectingSpan[]) spannable2.getSpans(0, text.length(), MetricAffectingSpan.class);
                    spannable = spannable2;
                } else {
                    spannable = null;
                }
                if (this.currentBlock.published_date != 0 && !TextUtils.isEmpty(text)) {
                    charSequenceNewSpannable = LocaleController.formatString("ArticleDateByAuthor", R.string.ArticleDateByAuthor, LocaleController.getInstance().chatFullDate.format(this.currentBlock.published_date * 1000), text);
                } else if (!TextUtils.isEmpty(text)) {
                    charSequenceNewSpannable = LocaleController.formatString("ArticleByAuthor", R.string.ArticleByAuthor, text);
                } else {
                    charSequenceNewSpannable = LocaleController.getInstance().chatFullDate.format(this.currentBlock.published_date * 1000);
                }
                if (metricAffectingSpanArr != null) {
                    try {
                        if (metricAffectingSpanArr.length > 0 && (iIndexOf = TextUtils.indexOf((CharSequence) charSequenceNewSpannable, text)) != -1) {
                            charSequenceNewSpannable = Spannable.Factory.getInstance().newSpannable(charSequenceNewSpannable);
                            for (int i4 = 0; i4 < metricAffectingSpanArr.length; i4++) {
                                charSequenceNewSpannable.setSpan(metricAffectingSpanArr[i4], spannable.getSpanStart(metricAffectingSpanArr[i4]) + iIndexOf, spannable.getSpanEnd(metricAffectingSpanArr[i4]) + iIndexOf, 33);
                            }
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, charSequenceNewSpannable, null, size - AndroidUtilities.dp(36.0f), this.textY, this.currentBlock, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    int iDp = AndroidUtilities.dp(16.0f) + this.textLayout.getHeight() + 0;
                    if (this.parentAdapter.isRtl) {
                        this.textX = (int) Math.floor((size - this.textLayout.getLineWidth(0)) - AndroidUtilities.dp(16.0f));
                    } else {
                        this.textX = AndroidUtilities.dp(18.0f);
                    }
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                    i3 = iDp;
                } else {
                    i3 = 0;
                }
            }
            setMeasuredDimension(size, i3);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null || this.textLayout == null) {
                return;
            }
            canvas.save();
            canvas.translate(this.textX, this.textY);
            ArticleViewer.this.drawTextSelection(canvas, this);
            this.textLayout.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            DrawingText drawingText = this.textLayout;
            if (drawingText == null) {
                return;
            }
            info.setText(drawingText.getText());
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private class BlockTitleCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockTitle currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        public BlockTitleCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockTitle block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockTitle tLRPC$TL_pageBlockTitle = this.currentBlock;
            if (tLRPC$TL_pageBlockTitle != null) {
                iDp = 0;
                if (tLRPC$TL_pageBlockTitle.first) {
                    iDp = 0 + AndroidUtilities.dp(8.0f);
                    this.textY = AndroidUtilities.dp(16.0f);
                } else {
                    this.textY = AndroidUtilities.dp(8.0f);
                }
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, this.currentBlock.text, size - AndroidUtilities.dp(36.0f), this.textY, this.currentBlock, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    iDp += AndroidUtilities.dp(16.0f) + this.textLayout.getHeight();
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
            } else {
                iDp = 1;
            }
            setMeasuredDimension(size, iDp);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null || this.textLayout == null) {
                return;
            }
            canvas.save();
            canvas.translate(this.textX, this.textY);
            ArticleViewer.this.drawTextSelection(canvas, this);
            this.textLayout.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            if (this.textLayout == null) {
                return;
            }
            info.setText(((Object) this.textLayout.getText()) + ", " + LocaleController.getString("AccDescrIVTitle", R.string.AccDescrIVTitle));
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private class BlockKickerCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockKicker currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        public BlockKickerCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockKicker block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockKicker tLRPC$TL_pageBlockKicker = this.currentBlock;
            if (tLRPC$TL_pageBlockKicker != null) {
                iDp = 0;
                if (tLRPC$TL_pageBlockKicker.first) {
                    this.textY = AndroidUtilities.dp(16.0f);
                    iDp = 0 + AndroidUtilities.dp(8.0f);
                } else {
                    this.textY = AndroidUtilities.dp(8.0f);
                }
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, this.currentBlock.text, size - AndroidUtilities.dp(36.0f), this.textY, this.currentBlock, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    iDp += AndroidUtilities.dp(16.0f) + this.textLayout.getHeight();
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
            } else {
                iDp = 1;
            }
            setMeasuredDimension(size, iDp);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null || this.textLayout == null) {
                return;
            }
            canvas.save();
            canvas.translate(this.textX, this.textY);
            ArticleViewer.this.drawTextSelection(canvas, this);
            this.textLayout.draw(canvas);
            canvas.restore();
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private class BlockFooterCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockFooter currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        public BlockFooterCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.textY = AndroidUtilities.dp(8.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockFooter block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockFooter tLRPC$TL_pageBlockFooter = this.currentBlock;
            int i = 0;
            if (tLRPC$TL_pageBlockFooter != null) {
                if (tLRPC$TL_pageBlockFooter.level == 0) {
                    this.textY = AndroidUtilities.dp(8.0f);
                    this.textX = AndroidUtilities.dp(18.0f);
                } else {
                    this.textY = 0;
                    this.textX = AndroidUtilities.dp((r14 * 14) + 18);
                }
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, this.currentBlock.text, (size - AndroidUtilities.dp(18.0f)) - this.textX, this.textY, this.currentBlock, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    int height = drawingTextCreateLayoutForText.getHeight();
                    if (this.currentBlock.level > 0) {
                        iDp = AndroidUtilities.dp(8.0f);
                    } else {
                        iDp = AndroidUtilities.dp(16.0f);
                    }
                    i = height + iDp;
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
            } else {
                i = 1;
            }
            setMeasuredDimension(size, i);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            if (this.textLayout != null) {
                canvas.save();
                canvas.translate(this.textX, this.textY);
                ArticleViewer.this.drawTextSelection(canvas, this);
                this.textLayout.draw(canvas);
                canvas.restore();
            }
            if (this.currentBlock.level > 0) {
                canvas.drawRect(AndroidUtilities.dp(18.0f), 0.0f, AndroidUtilities.dp(20.0f), getMeasuredHeight() - (this.currentBlock.bottom ? AndroidUtilities.dp(6.0f) : 0), ArticleViewer.quoteLinePaint);
            }
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class BlockPreformattedCell extends FrameLayout implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockPreformatted currentBlock;
        private WebpageAdapter parentAdapter;
        private HorizontalScrollView scrollView;
        private View textContainer;
        private DrawingText textLayout;

        public BlockPreformattedCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.parentAdapter = adapter;
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context) { // from class: ir.eitaa.ui.ArticleViewer.BlockPreformattedCell.1
                @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent ev) {
                    if (BlockPreformattedCell.this.textContainer.getMeasuredWidth() > getMeasuredWidth()) {
                        ArticleViewer.this.windowView.requestDisallowInterceptTouchEvent(true);
                    }
                    return super.onInterceptTouchEvent(ev);
                }

                @Override // android.view.View
                protected void onScrollChanged(int l, int t, int oldl, int oldt) {
                    super.onScrollChanged(l, t, oldl, oldt);
                    if (ArticleViewer.this.pressedLinkOwnerLayout != null) {
                        ArticleViewer.this.pressedLinkOwnerLayout = null;
                        ArticleViewer.this.pressedLinkOwnerView = null;
                    }
                }
            };
            this.scrollView = horizontalScrollView;
            horizontalScrollView.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
            addView(this.scrollView, LayoutHelper.createFrame(-1, -2.0f));
            this.textContainer = new View(context) { // from class: ir.eitaa.ui.ArticleViewer.BlockPreformattedCell.2
                @Override // android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    int i = 0;
                    int iMax = 1;
                    if (BlockPreformattedCell.this.currentBlock != null) {
                        BlockPreformattedCell blockPreformattedCell = BlockPreformattedCell.this;
                        blockPreformattedCell.textLayout = ArticleViewer.this.createLayoutForText(this, null, blockPreformattedCell.currentBlock.text, AndroidUtilities.dp(5000.0f), 0, BlockPreformattedCell.this.currentBlock, BlockPreformattedCell.this.parentAdapter);
                        if (BlockPreformattedCell.this.textLayout != null) {
                            int height = BlockPreformattedCell.this.textLayout.getHeight() + 0;
                            int lineCount = BlockPreformattedCell.this.textLayout.getLineCount();
                            while (i < lineCount) {
                                iMax = Math.max((int) Math.ceil(BlockPreformattedCell.this.textLayout.getLineWidth(i)), iMax);
                                i++;
                            }
                            i = height;
                        }
                    } else {
                        i = 1;
                    }
                    setMeasuredDimension(iMax + AndroidUtilities.dp(32.0f), i);
                }

                @Override // android.view.View
                public boolean onTouchEvent(MotionEvent event) {
                    BlockPreformattedCell blockPreformattedCell = BlockPreformattedCell.this;
                    ArticleViewer articleViewer = ArticleViewer.this;
                    WebpageAdapter webpageAdapter = blockPreformattedCell.parentAdapter;
                    BlockPreformattedCell blockPreformattedCell2 = BlockPreformattedCell.this;
                    return articleViewer.checkLayoutForLinks(webpageAdapter, event, blockPreformattedCell2, blockPreformattedCell2.textLayout, 0, 0) || super.onTouchEvent(event);
                }

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    if (BlockPreformattedCell.this.textLayout != null) {
                        canvas.save();
                        BlockPreformattedCell blockPreformattedCell = BlockPreformattedCell.this;
                        ArticleViewer.this.drawTextSelection(canvas, blockPreformattedCell);
                        BlockPreformattedCell.this.textLayout.draw(canvas);
                        canvas.restore();
                        BlockPreformattedCell.this.textLayout.x = (int) getX();
                        BlockPreformattedCell.this.textLayout.y = (int) getY();
                    }
                }
            };
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
            int iDp = AndroidUtilities.dp(16.0f);
            layoutParams.rightMargin = iDp;
            layoutParams.leftMargin = iDp;
            int iDp2 = AndroidUtilities.dp(12.0f);
            layoutParams.bottomMargin = iDp2;
            layoutParams.topMargin = iDp2;
            this.scrollView.addView(this.textContainer, layoutParams);
            if (Build.VERSION.SDK_INT >= 23) {
                this.scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ir.eitaa.ui.-$$Lambda$ArticleViewer$BlockPreformattedCell$4ZrrQeryp1LMdvVJmUcW37cxPd8
                    @Override // android.view.View.OnScrollChangeListener
                    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                        this.f$0.lambda$new$0$ArticleViewer$BlockPreformattedCell(view, i, i2, i3, i4);
                    }
                });
            }
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ArticleViewer$BlockPreformattedCell(View view, int i, int i2, int i3, int i4) {
            TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper = ArticleViewer.this.textSelectionHelper;
            if (articleTextSelectionHelper == null || !articleTextSelectionHelper.isSelectionMode()) {
                return;
            }
            ArticleViewer.this.textSelectionHelper.invalidate();
        }

        public void setBlock(TLRPC$TL_pageBlockPreformatted block) {
            this.currentBlock = block;
            this.scrollView.setScrollX(0);
            this.textContainer.requestLayout();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            this.scrollView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            setMeasuredDimension(size, this.scrollView.getMeasuredHeight());
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null) {
                return;
            }
            canvas.drawRect(0.0f, AndroidUtilities.dp(8.0f), getMeasuredWidth(), getMeasuredHeight() - AndroidUtilities.dp(8.0f), ArticleViewer.preformattedBackgroundPaint);
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }

        @Override // android.view.View, ir.eitaa.ui.Cells.TextSelectionHelper.SelectableView
        public void invalidate() {
            this.textContainer.invalidate();
            super.invalidate();
        }
    }

    private class BlockSubheaderCell extends View implements TextSelectionHelper.ArticleSelectableView {
        private TLRPC$TL_pageBlockSubheader currentBlock;
        private WebpageAdapter parentAdapter;
        private DrawingText textLayout;
        private int textX;
        private int textY;

        public BlockSubheaderCell(Context context, WebpageAdapter adapter) {
            super(context);
            this.textX = AndroidUtilities.dp(18.0f);
            this.textY = AndroidUtilities.dp(8.0f);
            this.parentAdapter = adapter;
        }

        public void setBlock(TLRPC$TL_pageBlockSubheader block) {
            this.currentBlock = block;
            requestLayout();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return ArticleViewer.this.checkLayoutForLinks(this.parentAdapter, event, this, this.textLayout, this.textX, this.textY) || super.onTouchEvent(event);
        }

        @Override // android.view.View
        @SuppressLint({"NewApi"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            TLRPC$TL_pageBlockSubheader tLRPC$TL_pageBlockSubheader = this.currentBlock;
            int iDp = 0;
            if (tLRPC$TL_pageBlockSubheader != null) {
                DrawingText drawingTextCreateLayoutForText = ArticleViewer.this.createLayoutForText(this, null, tLRPC$TL_pageBlockSubheader.text, size - AndroidUtilities.dp(36.0f), this.textY, this.currentBlock, this.parentAdapter.isRtl ? StaticLayoutEx.ALIGN_RIGHT() : Layout.Alignment.ALIGN_NORMAL, this.parentAdapter);
                this.textLayout = drawingTextCreateLayoutForText;
                if (drawingTextCreateLayoutForText != null) {
                    iDp = 0 + AndroidUtilities.dp(16.0f) + this.textLayout.getHeight();
                    DrawingText drawingText = this.textLayout;
                    drawingText.x = this.textX;
                    drawingText.y = this.textY;
                }
            } else {
                iDp = 1;
            }
            setMeasuredDimension(size, iDp);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.currentBlock == null || this.textLayout == null) {
                return;
            }
            canvas.save();
            canvas.translate(this.textX, this.textY);
            ArticleViewer.this.drawTextSelection(canvas, this);
            this.textLayout.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setEnabled(true);
            if (this.textLayout == null) {
                return;
            }
            info.setText(((Object) this.textLayout.getText()) + ", " + LocaleController.getString("AccDescrIVHeading", R.string.AccDescrIVHeading));
        }

        @Override // ir.eitaa.ui.Cells.TextSelectionHelper.ArticleSelectableView
        public void fillTextLayoutBlocks(ArrayList<TextSelectionHelper.TextLayoutBlock> blocks) {
            DrawingText drawingText = this.textLayout;
            if (drawingText != null) {
                blocks.add(drawingText);
            }
        }
    }

    private static class ReportCell extends FrameLayout {
        private boolean hasViews;
        private TextView textView;
        private TextView viewsTextView;

        public ReportCell(Context context) {
            super(context);
            setTag(90);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setText(LocaleController.getString("PreviewFeedback2", R.string.PreviewFeedback2));
            this.textView.setTextSize(1, 12.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView.setGravity(17);
            this.textView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            addView(this.textView, LayoutHelper.createFrame(-1, 34.0f, 51, 0.0f, 10.0f, 0.0f, 0.0f));
            TextView textView2 = new TextView(context);
            this.viewsTextView = textView2;
            textView2.setTextSize(1, 12.0f);
            this.viewsTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.viewsTextView.setGravity(19);
            this.viewsTextView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            addView(this.viewsTextView, LayoutHelper.createFrame(-1, 34.0f, 51, 0.0f, 10.0f, 0.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(44.0f), 1073741824));
        }

        public void setViews(int count) {
            if (count == 0) {
                this.hasViews = false;
                this.viewsTextView.setVisibility(8);
                this.textView.setGravity(17);
            } else {
                this.hasViews = true;
                this.viewsTextView.setVisibility(0);
                this.textView.setGravity(21);
                this.viewsTextView.setText(LocaleController.formatPluralStringComma("Views", count));
            }
            int color = Theme.getColor("switchTrack");
            this.textView.setTextColor(ArticleViewer.getGrayTextColor());
            this.viewsTextView.setTextColor(ArticleViewer.getGrayTextColor());
            this.textView.setBackgroundColor(Color.argb(34, Color.red(color), Color.green(color), Color.blue(color)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawTextSelection(Canvas canvas, TextSelectionHelper.ArticleSelectableView view) {
        drawTextSelection(canvas, view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void drawTextSelection(Canvas canvas, TextSelectionHelper.ArticleSelectableView view, int i) {
        TextSelectionHelper.ArticleTextSelectionHelper articleTextSelectionHelper;
        View view2 = (View) view;
        if (view2.getTag() != null && view2.getTag() == "bottomSheet" && (articleTextSelectionHelper = this.textSelectionHelperBottomSheet) != null) {
            articleTextSelectionHelper.draw(canvas, view, i);
        } else {
            this.textSelectionHelper.draw(canvas, view, i);
        }
    }

    public boolean openPhoto(TLRPC$PageBlock block, WebpageAdapter adapter) throws Resources.NotFoundException {
        int iIndexOf;
        List listSingletonList;
        if (!(block instanceof TLRPC$TL_pageBlockVideo) || WebPageUtils.isVideo(adapter.currentPage, block)) {
            ArrayList arrayList = new ArrayList(adapter.photoBlocks);
            iIndexOf = adapter.photoBlocks.indexOf(block);
            listSingletonList = arrayList;
        } else {
            listSingletonList = Collections.singletonList(block);
            iIndexOf = 0;
        }
        PhotoViewer photoViewer = PhotoViewer.getInstance();
        photoViewer.setParentActivity(this.parentActivity);
        return photoViewer.openPhoto(iIndexOf, new RealPageBlocksAdapter(adapter.currentPage, listSingletonList), new PageBlocksPhotoViewerProvider(listSingletonList));
    }

    private class RealPageBlocksAdapter implements PhotoViewer.PageBlocksAdapter {
        private final TLRPC$WebPage page;
        private final List<TLRPC$PageBlock> pageBlocks;

        private RealPageBlocksAdapter(TLRPC$WebPage page, List<TLRPC$PageBlock> pageBlocks) {
            this.page = page;
            this.pageBlocks = pageBlocks;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public int getItemsCount() {
            return this.pageBlocks.size();
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public TLRPC$PageBlock get(int index) {
            return this.pageBlocks.get(index);
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public List<TLRPC$PageBlock> getAll() {
            return this.pageBlocks;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public boolean isVideo(int index) {
            return index < this.pageBlocks.size() && index >= 0 && WebPageUtils.isVideo(this.page, get(index));
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public TLObject getMedia(int index) {
            if (index >= this.pageBlocks.size() || index < 0) {
                return null;
            }
            return WebPageUtils.getMedia(this.page, get(index));
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public File getFile(int index) {
            if (index >= this.pageBlocks.size() || index < 0) {
                return null;
            }
            return WebPageUtils.getMediaFile(this.page, get(index));
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public String getFileName(int index) {
            TLObject media = getMedia(index);
            if (media instanceof TLRPC$Photo) {
                media = FileLoader.getClosestPhotoSizeWithSize(((TLRPC$Photo) media).sizes, AndroidUtilities.getPhotoSize());
            }
            return FileLoader.getAttachFileName(media);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.CharSequence getCaption(int r9) {
            /*
                r8 = this;
                ir.eitaa.tgnet.TLRPC$PageBlock r5 = r8.get(r9)
                boolean r9 = r5 instanceof ir.eitaa.tgnet.TLRPC$TL_pageBlockPhoto
                r7 = 0
                if (r9 == 0) goto L28
                r9 = r5
                ir.eitaa.tgnet.TLRPC$TL_pageBlockPhoto r9 = (ir.eitaa.tgnet.TLRPC$TL_pageBlockPhoto) r9
                java.lang.String r9 = r9.url
                boolean r0 = android.text.TextUtils.isEmpty(r9)
                if (r0 != 0) goto L28
                android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
                r0.<init>(r9)
                ir.eitaa.ui.ArticleViewer$RealPageBlocksAdapter$1 r1 = new ir.eitaa.ui.ArticleViewer$RealPageBlocksAdapter$1
                r1.<init>(r9)
                int r9 = r9.length()
                r2 = 34
                r0.setSpan(r1, r7, r9, r2)
                goto L29
            L28:
                r0 = 0
            L29:
                if (r0 != 0) goto L87
                ir.eitaa.ui.ArticleViewer r9 = ir.eitaa.ui.ArticleViewer.this
                r0 = 2
                ir.eitaa.tgnet.TLRPC$RichText r4 = ir.eitaa.ui.ArticleViewer.access$21100(r9, r5, r0)
                ir.eitaa.ui.ArticleViewer r0 = ir.eitaa.ui.ArticleViewer.this
                ir.eitaa.tgnet.TLRPC$WebPage r1 = r8.page
                r2 = 0
                r9 = 1120403456(0x42c80000, float:100.0)
                int r9 = ir.eitaa.messenger.AndroidUtilities.dp(r9)
                int r6 = -r9
                r3 = r4
                java.lang.CharSequence r0 = ir.eitaa.ui.ArticleViewer.access$21200(r0, r1, r2, r3, r4, r5, r6)
                boolean r9 = r0 instanceof android.text.Spannable
                if (r9 == 0) goto L87
                r9 = r0
                android.text.Spannable r9 = (android.text.Spannable) r9
                int r1 = r0.length()
                java.lang.Class<ir.eitaa.ui.Components.TextPaintUrlSpan> r2 = ir.eitaa.ui.Components.TextPaintUrlSpan.class
                java.lang.Object[] r1 = r9.getSpans(r7, r1, r2)
                ir.eitaa.ui.Components.TextPaintUrlSpan[] r1 = (ir.eitaa.ui.Components.TextPaintUrlSpan[]) r1
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                if (r1 == 0) goto L86
                int r0 = r1.length
                if (r0 <= 0) goto L86
            L64:
                int r0 = r1.length
                if (r7 >= r0) goto L86
                ir.eitaa.ui.ArticleViewer$RealPageBlocksAdapter$2 r0 = new ir.eitaa.ui.ArticleViewer$RealPageBlocksAdapter$2
                r3 = r1[r7]
                java.lang.String r3 = r3.getUrl()
                r0.<init>(r3)
                r3 = r1[r7]
                int r3 = r9.getSpanStart(r3)
                r4 = r1[r7]
                int r4 = r9.getSpanEnd(r4)
                r5 = 33
                r2.setSpan(r0, r3, r4, r5)
                int r7 = r7 + 1
                goto L64
            L86:
                r0 = r2
            L87:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ArticleViewer.RealPageBlocksAdapter.getCaption(int):java.lang.CharSequence");
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public TLRPC$PhotoSize getFileLocation(TLObject media, int[] size) {
            TLRPC$PhotoSize closestPhotoSizeWithSize;
            if (media instanceof TLRPC$Photo) {
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(((TLRPC$Photo) media).sizes, AndroidUtilities.getPhotoSize());
                if (closestPhotoSizeWithSize2 != null) {
                    size[0] = closestPhotoSizeWithSize2.size;
                    if (size[0] == 0) {
                        size[0] = -1;
                    }
                    return closestPhotoSizeWithSize2;
                }
                size[0] = -1;
                return null;
            }
            if (!(media instanceof TLRPC$Document) || (closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(((TLRPC$Document) media).thumbs, 90)) == null) {
                return null;
            }
            size[0] = closestPhotoSizeWithSize.size;
            if (size[0] == 0) {
                size[0] = -1;
            }
            return closestPhotoSizeWithSize;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public void updateSlideshowCell(TLRPC$PageBlock currentPageBlock) throws Resources.NotFoundException {
            int childCount = ArticleViewer.this.listView[0].getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ArticleViewer.this.listView[0].getChildAt(i);
                if (childAt instanceof BlockSlideshowCell) {
                    BlockSlideshowCell blockSlideshowCell = (BlockSlideshowCell) childAt;
                    int iIndexOf = blockSlideshowCell.currentBlock.items.indexOf(currentPageBlock);
                    if (iIndexOf != -1) {
                        blockSlideshowCell.innerListView.setCurrentItem(iIndexOf, false);
                        return;
                    }
                }
            }
        }

        @Override // ir.eitaa.ui.PhotoViewer.PageBlocksAdapter
        public Object getParentObject() {
            return this.page;
        }
    }

    private class PageBlocksPhotoViewerProvider extends PhotoViewer.EmptyPhotoViewerProvider {
        private final List<TLRPC$PageBlock> pageBlocks;
        private final int[] tempArr = new int[2];

        public PageBlocksPhotoViewerProvider(List<TLRPC$PageBlock> pageBlocks) {
            this.pageBlocks = pageBlocks;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
            ImageReceiver imageReceiverFromListView;
            if (index < 0 || index >= this.pageBlocks.size() || (imageReceiverFromListView = getImageReceiverFromListView(ArticleViewer.this.listView[0], this.pageBlocks.get(index), this.tempArr)) == null) {
                return null;
            }
            PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
            int[] iArr = this.tempArr;
            placeProviderObject.viewX = iArr[0];
            placeProviderObject.viewY = iArr[1];
            placeProviderObject.parentView = ArticleViewer.this.listView[0];
            placeProviderObject.imageReceiver = imageReceiverFromListView;
            placeProviderObject.thumb = imageReceiverFromListView.getBitmapSafe();
            placeProviderObject.radius = imageReceiverFromListView.getRoundRadius();
            placeProviderObject.clipTopAddition = ArticleViewer.this.currentHeaderHeight;
            return placeProviderObject;
        }

        private ImageReceiver getImageReceiverFromListView(ViewGroup listView, TLRPC$PageBlock pageBlock, int[] coords) {
            int childCount = listView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ImageReceiver imageReceiverView = getImageReceiverView(listView.getChildAt(i), pageBlock, coords);
                if (imageReceiverView != null) {
                    return imageReceiverView;
                }
            }
            return null;
        }

        private ImageReceiver getImageReceiverView(View view, TLRPC$PageBlock pageBlock, int[] coords) {
            ImageReceiver imageReceiverView;
            ImageReceiver imageReceiverView2;
            if (view instanceof BlockPhotoCell) {
                BlockPhotoCell blockPhotoCell = (BlockPhotoCell) view;
                if (blockPhotoCell.currentBlock != pageBlock) {
                    return null;
                }
                view.getLocationInWindow(coords);
                return blockPhotoCell.imageView;
            }
            if (view instanceof BlockVideoCell) {
                BlockVideoCell blockVideoCell = (BlockVideoCell) view;
                if (blockVideoCell.currentBlock != pageBlock) {
                    return null;
                }
                view.getLocationInWindow(coords);
                return blockVideoCell.imageView;
            }
            if (view instanceof BlockCollageCell) {
                ImageReceiver imageReceiverFromListView = getImageReceiverFromListView(((BlockCollageCell) view).innerListView, pageBlock, coords);
                if (imageReceiverFromListView != null) {
                    return imageReceiverFromListView;
                }
                return null;
            }
            if (view instanceof BlockSlideshowCell) {
                ImageReceiver imageReceiverFromListView2 = getImageReceiverFromListView(((BlockSlideshowCell) view).innerListView, pageBlock, coords);
                if (imageReceiverFromListView2 != null) {
                    return imageReceiverFromListView2;
                }
                return null;
            }
            if (view instanceof BlockListItemCell) {
                BlockListItemCell blockListItemCell = (BlockListItemCell) view;
                if (blockListItemCell.blockLayout == null || (imageReceiverView2 = getImageReceiverView(blockListItemCell.blockLayout.itemView, pageBlock, coords)) == null) {
                    return null;
                }
                return imageReceiverView2;
            }
            if (!(view instanceof BlockOrderedListItemCell)) {
                return null;
            }
            BlockOrderedListItemCell blockOrderedListItemCell = (BlockOrderedListItemCell) view;
            if (blockOrderedListItemCell.blockLayout == null || (imageReceiverView = getImageReceiverView(blockOrderedListItemCell.blockLayout.itemView, pageBlock, coords)) == null) {
                return null;
            }
            return imageReceiverView;
        }
    }
}
