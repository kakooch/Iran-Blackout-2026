package ir.resaneh1.iptv.fragment.rubino.highlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.ExtendedGridLayoutManager;
import ir.resaneh1.iptv.fragment.rubino.HighlightScrollSlidingTextTabStrip;
import ir.resaneh1.iptv.fragment.rubino.RecyclerAnimationScrollHelper;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.RubinoLoadingCell;
import ir.resaneh1.iptv.fragment.rubino.StoryInGridCell;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.model.GetStoryIdsOutput;
import ir.resaneh1.iptv.model.GetStoryOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.StoryObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.Size;

/* loaded from: classes3.dex */
public class HighlightPostGridLayout extends FrameLayout {
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$$ExternalSyntheticLambda1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return HighlightPostGridLayout.lambda$static$0(f);
        }
    };
    private ActionBar actionBar;
    private boolean animatingForward;
    private boolean backAnimation;
    private ArrayList<ArrayList<StoryInGridCell>> caches;
    private ArrayList<ArrayList<StoryInGridCell>> cellCaches;
    private int columnsCount;
    int currentAccount;
    private int[] hasMedia;
    private final Rubino.StoryHighlight highlight;
    private int initialTab;
    private int maximumVelocity;
    private boolean maybeStartTracking;
    private MediaPage[] mediaPages;
    private int[] oldItemCounts;
    private SharedPhotoVideoAdapter photoVideoAdapter;
    private SharedPhotoVideoAdapter photoVideoAdapterSecond;
    private SharedPhotoVideoAdapter photoVideoAdapterThird;
    private Drawable pinnedHeaderShadowDrawable;
    private PostArrayData[] postArrayInfo;
    private AddHighlightFragment profileActivity;
    private HighlightScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private boolean scrolling;
    private final Map<String, StoryObject> selectedItems;
    private View shadowLine;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private int startedTrackingX;
    private int startedTrackingY;
    private int tabCount;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private VelocityTracker velocityTracker;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$1(View view, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$2(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    public void onDestroy() {
    }

    protected void onSelectedTabChanged() {
    }

    private static class MediaPage extends FrameLayout {
        private ImageView emptyImageView;
        private TextView emptyTextView;
        private TextView emptyTextView2;
        private LinearLayout emptyView;
        private ExtendedGridLayoutManager layoutManager;
        private RecyclerListViewEdited listView;
        private View progressBar;
        private LinearLayout progressView;
        private RecyclerAnimationScrollHelper scrollHelper;
        private int selectedType;

        public MediaPage(Context context) {
            super(context);
        }
    }

    public static class PostArrayData {
        public boolean endReached;
        public DisposableObserver<Integer> getStoriesObserver;
        public boolean loading;
        public String nextStartId;
        public ArrayList<StoryObject> stories;
        public Map<String, StoryObject> storiesMap;

        public PostArrayData() {
            new ArrayList();
            this.stories = new ArrayList<>();
            this.storiesMap = new HashMap();
            this.loading = true;
            this.endReached = false;
            this.nextStartId = null;
        }

        public void addPosts(ArrayList<StoryObject> arrayList, boolean z) {
            if (z) {
                this.stories.clear();
                this.storiesMap.clear();
            }
            this.stories.addAll(arrayList);
            Iterator<StoryObject> it = arrayList.iterator();
            while (it.hasNext()) {
                StoryObject next = it.next();
                this.storiesMap.put(next.id, next);
            }
        }
    }

    public HighlightPostGridLayout(Context context, AddHighlightFragment addHighlightFragment, int i, Rubino.StoryHighlight storyHighlight) throws Resources.NotFoundException {
        RecyclerListViewEdited.Holder holder;
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.selectedItems = new HashMap();
        this.cellCaches = new ArrayList<>();
        this.caches = new ArrayList<>();
        new Paint();
        this.columnsCount = 3;
        this.oldItemCounts = new int[]{0, 0, 0};
        this.tabCount = 2;
        this.highlight = storyHighlight;
        this.tabCount = i;
        this.postArrayInfo = new PostArrayData[i];
        this.mediaPages = new MediaPage[2];
        if (i == 2) {
            this.hasMedia = new int[]{1, 1};
        } else {
            this.hasMedia = new int[]{1, 1, 1};
        }
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
        int i3 = 0;
        while (true) {
            PostArrayData[] postArrayDataArr = this.postArrayInfo;
            if (i3 >= postArrayDataArr.length) {
                break;
            }
            postArrayDataArr[i3] = new PostArrayData();
            i3++;
        }
        this.profileActivity = addHighlightFragment;
        this.actionBar = addHighlightFragment.getActionBar();
        for (int i4 = 0; i4 < i; i4++) {
            ArrayList<StoryInGridCell> arrayList = new ArrayList<>(10);
            for (int i5 = 0; i5 < 10; i5++) {
                arrayList.add(new StoryInGridCell(context));
            }
            this.cellCaches.add(arrayList);
            this.caches.add(new ArrayList<>(10));
        }
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        Drawable drawable = context.getResources().getDrawable(R.drawable.photos_header_shadow);
        this.pinnedHeaderShadowDrawable = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundGrayShadow), PorterDuff.Mode.MULTIPLY));
        HighlightScrollSlidingTextTabStrip highlightScrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (highlightScrollSlidingTextTabStrip != null) {
            this.initialTab = highlightScrollSlidingTextTabStrip.getCurrentTabId();
        }
        HighlightScrollSlidingTextTabStrip highlightScrollSlidingTextTabStrip2 = new HighlightScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = highlightScrollSlidingTextTabStrip2;
        int i6 = this.initialTab;
        if (i6 != -1) {
            highlightScrollSlidingTextTabStrip2.setInitialTabId(i6);
            this.initialTab = -1;
        }
        this.scrollSlidingTextTabStrip.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.scrollSlidingTextTabStrip.setDelegate(new HighlightScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.1
            @Override // ir.resaneh1.iptv.fragment.rubino.HighlightScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i7, boolean z) {
                if (HighlightPostGridLayout.this.mediaPages[0].selectedType == i7) {
                    return;
                }
                HighlightPostGridLayout.this.mediaPages[1].selectedType = i7;
                HighlightPostGridLayout.this.mediaPages[1].setVisibility(0);
                HighlightPostGridLayout.this.switchToCurrentSelectedMode(true);
                HighlightPostGridLayout.this.animatingForward = z;
                HighlightPostGridLayout.this.onSelectedTabChanged();
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.HighlightScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onSamePageSelected() {
                HighlightPostGridLayout.this.scrollToTop();
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.HighlightScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float f) {
                if (f != 1.0f || HighlightPostGridLayout.this.mediaPages[1].getVisibility() == 0) {
                    if (HighlightPostGridLayout.this.animatingForward) {
                        HighlightPostGridLayout.this.mediaPages[0].setTranslationX((-f) * HighlightPostGridLayout.this.mediaPages[0].getMeasuredWidth());
                        HighlightPostGridLayout.this.mediaPages[1].setTranslationX(HighlightPostGridLayout.this.mediaPages[0].getMeasuredWidth() - (HighlightPostGridLayout.this.mediaPages[0].getMeasuredWidth() * f));
                    } else {
                        HighlightPostGridLayout.this.mediaPages[0].setTranslationX(HighlightPostGridLayout.this.mediaPages[0].getMeasuredWidth() * f);
                        HighlightPostGridLayout.this.mediaPages[1].setTranslationX((HighlightPostGridLayout.this.mediaPages[0].getMeasuredWidth() * f) - HighlightPostGridLayout.this.mediaPages[0].getMeasuredWidth());
                    }
                    if (f == 1.0f) {
                        MediaPage mediaPage = HighlightPostGridLayout.this.mediaPages[0];
                        HighlightPostGridLayout.this.mediaPages[0] = HighlightPostGridLayout.this.mediaPages[1];
                        HighlightPostGridLayout.this.mediaPages[1] = mediaPage;
                        HighlightPostGridLayout.this.mediaPages[1].setVisibility(8);
                    }
                }
            }
        });
        this.photoVideoAdapter = new SharedPhotoVideoAdapter(context, 0);
        this.photoVideoAdapterSecond = new SharedPhotoVideoAdapter(context, 1);
        this.photoVideoAdapterThird = new SharedPhotoVideoAdapter(context, 2);
        setWillNotDraw(false);
        int i7 = 0;
        int iFindFirstVisibleItemPosition = -1;
        int top = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i7 < mediaPageArr.length) {
                if ((i7 == 0 || i7 == 1) && mediaPageArr[i7] != null && mediaPageArr[i7].layoutManager != null) {
                    iFindFirstVisibleItemPosition = this.mediaPages[i7].layoutManager.findFirstVisibleItemPosition();
                    if (iFindFirstVisibleItemPosition == this.mediaPages[i7].layoutManager.getItemCount() - 1 || (holder = (RecyclerListViewEdited.Holder) this.mediaPages[i7].listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) == null) {
                        iFindFirstVisibleItemPosition = -1;
                    } else {
                        top = holder.itemView.getTop();
                    }
                }
                final MediaPage mediaPage = new MediaPage(context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.2
                    @Override // android.view.View
                    public void setTranslationX(float f) {
                        super.setTranslationX(f);
                        if (HighlightPostGridLayout.this.tabsAnimationInProgress && HighlightPostGridLayout.this.mediaPages[0] == this) {
                            HighlightPostGridLayout.this.scrollSlidingTextTabStrip.selectTabWithId(HighlightPostGridLayout.this.mediaPages[1].selectedType, Math.abs(HighlightPostGridLayout.this.mediaPages[0].getTranslationX()) / HighlightPostGridLayout.this.mediaPages[0].getMeasuredWidth());
                        }
                    }
                };
                addView(mediaPage, LayoutHelper.createFrame(-1, -1, 51, 0.0f, 48.0f, 0.0f, 0.0f));
                MediaPage[] mediaPageArr2 = this.mediaPages;
                mediaPageArr2[i7] = mediaPage;
                final ExtendedGridLayoutManager extendedGridLayoutManager = mediaPageArr2[i7].layoutManager = new ExtendedGridLayoutManager(this, context, 100) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.3
                    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public boolean supportsPredictiveItemAnimations() {
                        return false;
                    }

                    {
                        new Size();
                    }

                    @Override // androidx.recyclerview.widget.LinearLayoutManager
                    protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr2) {
                        super.calculateExtraLayoutSpace(state, iArr2);
                        if (mediaPage.selectedType != 0) {
                            if (mediaPage.selectedType == 1) {
                                iArr2[1] = Math.max(iArr2[1], AndroidUtilities.dp(56.0f) * 2);
                                return;
                            }
                            return;
                        }
                        iArr2[1] = Math.max(iArr2[1], AndroidUtilities.dp(100.0f) * 2);
                    }
                };
                extendedGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.4
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i8) {
                        return mediaPage.layoutManager.getSpanCount();
                    }
                });
                this.mediaPages[i7].listView = new RecyclerListViewEdited(context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.5
                    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean z, int i8, int i9, int i10, int i11) {
                        super.onLayout(z, i8, i9, i10, i11);
                        HighlightPostGridLayout highlightPostGridLayout = HighlightPostGridLayout.this;
                        MediaPage mediaPage2 = mediaPage;
                        highlightPostGridLayout.checkLoadMoreScroll(mediaPage2, mediaPage2.listView, extendedGridLayoutManager);
                    }
                };
                this.mediaPages[i7].listView.setScrollingTouchSlop(1);
                this.mediaPages[i7].listView.setPinnedSectionOffsetY(-AndroidUtilities.dp(2.0f));
                this.mediaPages[i7].listView.setPadding(0, AndroidUtilities.dp(2.0f), 0, 0);
                this.mediaPages[i7].listView.setItemAnimator(null);
                this.mediaPages[i7].listView.setClipToPadding(false);
                this.mediaPages[i7].listView.setSectionsType(2);
                this.mediaPages[i7].listView.setLayoutManager(extendedGridLayoutManager);
                MediaPage[] mediaPageArr3 = this.mediaPages;
                mediaPageArr3[i7].addView(mediaPageArr3[i7].listView, LayoutHelper.createFrame(-1, -1));
                this.mediaPages[i7].listView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.6
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                        rect.left = 0;
                        rect.top = 0;
                        rect.bottom = 0;
                        rect.right = 0;
                    }
                });
                this.mediaPages[i7].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.7
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrollStateChanged(RecyclerView recyclerView, int i8) {
                        HighlightPostGridLayout.this.scrolling = i8 != 0;
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(RecyclerView recyclerView, int i8, int i9) {
                        HighlightPostGridLayout.this.checkLoadMoreScroll(mediaPage, recyclerView, extendedGridLayoutManager);
                    }
                });
                this.mediaPages[i7].listView.setOnItemLongClickListener(new RecyclerListViewEdited.OnItemLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$$ExternalSyntheticLambda5
                    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemLongClickListener
                    public final boolean onItemClick(View view, int i8) {
                        return HighlightPostGridLayout.lambda$new$1(view, i8);
                    }
                });
                if (i7 == 0 && iFindFirstVisibleItemPosition != -1) {
                    extendedGridLayoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
                }
                RecyclerListViewEdited unused = this.mediaPages[i7].listView;
                this.mediaPages[i7].emptyView = new LinearLayout(context);
                this.mediaPages[i7].emptyView.setWillNotDraw(false);
                this.mediaPages[i7].emptyView.setOrientation(1);
                this.mediaPages[i7].emptyView.setGravity(17);
                this.mediaPages[i7].emptyView.setVisibility(8);
                MediaPage[] mediaPageArr4 = this.mediaPages;
                mediaPageArr4[i7].addView(mediaPageArr4[i7].emptyView, LayoutHelper.createFrame(-1, -1));
                this.mediaPages[i7].emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return HighlightPostGridLayout.lambda$new$2(view, motionEvent);
                    }
                });
                this.mediaPages[i7].emptyImageView = new ImageView(context);
                ImageView imageView = this.mediaPages[i7].emptyImageView;
                int i8 = Theme.key_rubinoBlackColor;
                imageView.setColorFilter(Theme.getColor(i8));
                this.mediaPages[i7].emptyView.addView(this.mediaPages[i7].emptyImageView, LayoutHelper.createLinear(90, 90, 1));
                this.mediaPages[i7].emptyTextView = new TextView(context);
                this.mediaPages[i7].emptyTextView.setTextColor(Theme.getColor(i8));
                this.mediaPages[i7].emptyTextView.setGravity(17);
                this.mediaPages[i7].emptyTextView.setTextSize(1, 17.0f);
                this.mediaPages[i7].emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
                this.mediaPages[i7].emptyView.addView(this.mediaPages[i7].emptyTextView, LayoutHelper.createLinear(-2, -2, 1, 0, 24, 0, 0));
                this.mediaPages[i7].emptyTextView2 = new TextView(context);
                this.mediaPages[i7].emptyTextView2.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
                this.mediaPages[i7].emptyTextView2.setGravity(17);
                this.mediaPages[i7].emptyTextView2.setTextSize(1, 15.0f);
                this.mediaPages[i7].emptyTextView2.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(16.0f));
                this.mediaPages[i7].emptyView.addView(this.mediaPages[i7].emptyTextView2, LayoutHelper.createLinear(-2, -2, 1, 0, 24, 0, 0));
                this.mediaPages[i7].progressView = new LinearLayout(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.8
                    @Override // android.widget.LinearLayout, android.view.View
                    protected void onDraw(Canvas canvas) {
                    }
                };
                this.mediaPages[i7].progressView.setWillNotDraw(false);
                this.mediaPages[i7].progressView.setGravity(17);
                this.mediaPages[i7].progressView.setOrientation(1);
                this.mediaPages[i7].progressView.setVisibility(8);
                MediaPage[] mediaPageArr5 = this.mediaPages;
                mediaPageArr5[i7].addView(mediaPageArr5[i7].progressView, LayoutHelper.createFrame(-1, -1));
                this.mediaPages[i7].progressBar = new RubinoLoadingCell(context, false);
                this.mediaPages[i7].progressView.addView(this.mediaPages[i7].progressBar, LayoutHelper.createLinear(-2, -2));
                if (i7 != 0) {
                    this.mediaPages[i7].setVisibility(8);
                }
                MediaPage[] mediaPageArr6 = this.mediaPages;
                mediaPageArr6[i7].scrollHelper = new RecyclerAnimationScrollHelper(mediaPageArr6[i7].listView, this.mediaPages[i7].layoutManager);
                i7++;
            } else {
                addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 48, 51));
                View view = new View(context);
                this.shadowLine = view;
                view.setBackgroundColor(Theme.getColor(Theme.key_rubinoGrayColor));
                this.shadowLine.setAlpha(0.5f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(0.4f));
                layoutParams.topMargin = AndroidUtilities.dp(48.0f) - 1;
                addView(this.shadowLine, layoutParams);
                updateTabs();
                switchToCurrentSelectedMode(false);
                return;
            }
        }
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
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r5.mediaPages
            r1 = 0
            r0 = r0[r1]
            int r0 = ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.MediaPage.access$100(r0)
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
            int r0 = ir.resaneh1.iptv.fragment.rubino.StoryInGridCell.getItemHeight(r0)
        L3c:
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r3 = r5.mediaPages
            r3 = r3[r1]
            ir.resaneh1.iptv.fragment.rubino.ExtendedGridLayoutManager r3 = ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.MediaPage.access$500(r3)
            int r3 = r3.findFirstVisibleItemPosition()
            int r3 = r3 * r0
            float r0 = (float) r3
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r3 = r5.mediaPages
            r3 = r3[r1]
            ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited r3 = ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.MediaPage.access$600(r3)
            int r3 = r3.getMeasuredHeight()
            float r3 = (float) r3
            r4 = 1067030938(0x3f99999a, float:1.2)
            float r3 = r3 * r4
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto L78
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            ir.resaneh1.iptv.fragment.rubino.RecyclerAnimationScrollHelper r0 = ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.MediaPage.access$1700(r0)
            r0.setScrollDirection(r2)
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            ir.resaneh1.iptv.fragment.rubino.RecyclerAnimationScrollHelper r0 = ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.MediaPage.access$1700(r0)
            r0.scrollToPosition(r1, r1, r1, r2)
            goto L83
        L78:
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited r0 = ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.MediaPage.access$600(r0)
            r0.smoothScrollToPosition(r1)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.scrollToTop():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLoadMoreScroll(MediaPage mediaPage, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition + (iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1) <= recyclerView.getAdapter().getItemCount() - 3 || this.postArrayInfo[mediaPage.selectedType].loading || this.postArrayInfo[mediaPage.selectedType].endReached) {
            return;
        }
        this.postArrayInfo[mediaPage.selectedType].loading = true;
    }

    public int getSelectedTab() {
        return this.scrollSlidingTextTabStrip.getCurrentTabId();
    }

    private boolean prepareForMoving(MotionEvent motionEvent, boolean z) {
        int nextPageId = this.scrollSlidingTextTabStrip.getNextPageId(z);
        if (nextPageId < 0) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
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
            this.mediaPages[1].setTranslationX(r5[0].getMeasuredWidth());
        } else {
            this.mediaPages[1].setTranslationX(-r5[0].getMeasuredWidth());
        }
        return true;
    }

    @Override // android.view.View
    public void forceHasOverlappingRendering(boolean z) {
        super.forceHasOverlappingRendering(z);
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
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r1]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r1]
            r0.setTranslationX(r3)
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r7.mediaPages
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
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r5]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r7.mediaPages
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
            ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$MediaPage[] r0 = r7.mediaPages
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
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.checkTabsAnimationInProgress():boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return checkTabsAnimationInProgress() || this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(motionEvent);
    }

    public boolean isCurrentTabFirst() {
        return this.scrollSlidingTextTabStrip.getCurrentTabId() == this.scrollSlidingTextTabStrip.getFirstTabId();
    }

    public RecyclerListViewEdited getCurrentListView() {
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
                    this.mediaPages[1].setTranslationX(this.animatingForward ? r5[0].getMeasuredWidth() : -r5[0].getMeasuredWidth());
                    this.scrollSlidingTextTabStrip.selectTabWithId(this.mediaPages[1].selectedType, 0.0f);
                }
            }
            if (!this.maybeStartTracking || this.startedTracking) {
                if (this.startedTracking) {
                    this.mediaPages[0].setTranslationX(x);
                    if (this.animatingForward) {
                        this.mediaPages[1].setTranslationX(r11[0].getMeasuredWidth() + x);
                    } else {
                        this.mediaPages[1].setTranslationX(x - r11[0].getMeasuredWidth());
                    }
                    this.scrollSlidingTextTabStrip.selectTabWithId(this.mediaPages[1].selectedType, Math.abs(x) / this.mediaPages[0].getMeasuredWidth());
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
                        this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, r6[1].getMeasuredWidth()));
                    } else {
                        this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, -r6[1].getMeasuredWidth()));
                    }
                } else {
                    measuredWidth = this.mediaPages[0].getMeasuredWidth() - Math.abs(x2);
                    if (this.animatingForward) {
                        this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, -r6[0].getMeasuredWidth()), ObjectAnimator.ofFloat(this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f));
                    } else {
                        this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], (Property<MediaPage, Float>) View.TRANSLATION_X, r6[0].getMeasuredWidth()), ObjectAnimator.ofFloat(this.mediaPages[1], (Property<MediaPage, Float>) View.TRANSLATION_X, 0.0f));
                    }
                }
                this.tabsAnimation.setInterpolator(interpolator);
                int measuredWidth3 = getMeasuredWidth();
                float f = measuredWidth3 / 2;
                float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                float fAbs = Math.abs(xVelocity);
                if (fAbs > 0.0f) {
                    measuredWidth2 = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / fAbs) * 1000.0f) * 4;
                } else {
                    measuredWidth2 = (int) (((measuredWidth / getMeasuredWidth()) + 1.0f) * 100.0f);
                }
                this.tabsAnimation.setDuration(Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min(measuredWidth2, 600)));
                this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.9
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        HighlightPostGridLayout.this.tabsAnimation = null;
                        if (HighlightPostGridLayout.this.backAnimation) {
                            HighlightPostGridLayout.this.mediaPages[1].setVisibility(8);
                        } else {
                            MediaPage mediaPage = HighlightPostGridLayout.this.mediaPages[0];
                            HighlightPostGridLayout.this.mediaPages[0] = HighlightPostGridLayout.this.mediaPages[1];
                            HighlightPostGridLayout.this.mediaPages[1] = mediaPage;
                            HighlightPostGridLayout.this.mediaPages[1].setVisibility(8);
                            HighlightPostGridLayout.this.scrollSlidingTextTabStrip.selectTabWithId(HighlightPostGridLayout.this.mediaPages[0].selectedType, 1.0f);
                            HighlightPostGridLayout.this.onSelectedTabChanged();
                        }
                        HighlightPostGridLayout.this.tabsAnimationInProgress = false;
                        HighlightPostGridLayout.this.maybeStartTracking = false;
                        HighlightPostGridLayout.this.startedTracking = false;
                        HighlightPostGridLayout.this.actionBar.setEnabled(true);
                        HighlightPostGridLayout.this.scrollSlidingTextTabStrip.setEnabled(true);
                    }
                });
                this.tabsAnimation.start();
                this.tabsAnimationInProgress = true;
                this.startedTracking = false;
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

    public void setVisibleHeight(int i) {
        int iMax = Math.max(i, AndroidUtilities.dp(120.0f));
        int i2 = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i2 >= mediaPageArr.length) {
                return;
            }
            mediaPageArr[i2].emptyView.setTranslationY((-(getMeasuredHeight() - iMax)) / 2);
            this.mediaPages[i2].progressView.setTranslationY((-(getMeasuredHeight() - iMax)) / 2);
            i2++;
        }
    }

    public void loadStories(final int i) {
        PostArrayData[] postArrayDataArr = this.postArrayInfo;
        if (postArrayDataArr[i].endReached) {
            return;
        }
        Observable observableFlatMap = null;
        String str = postArrayDataArr[i].nextStartId;
        if (i == 1) {
            observableFlatMap = RubinoController.getInstance(this.currentAccount).getMyArchiveStories(str, 51).flatMap(new Function() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return this.f$0.lambda$loadStories$3(i, (Rubino.GetMyArchiveStoriesOutput) obj);
                }
            });
        } else if (i == 0) {
            final String str2 = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id;
            observableFlatMap = RubinoController.getInstance(this.currentAccount).getHighlightStoryIds(str2, this.highlight.highlight_id).flatMap(new Function() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return this.f$0.lambda$loadStories$4(str2, (GetStoryIdsOutput) obj);
                }
            }).flatMap(new Function() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return this.f$0.lambda$loadStories$5(i, (GetStoryOutput) obj);
                }
            });
        }
        PostArrayData[] postArrayDataArr2 = this.postArrayInfo;
        if ((postArrayDataArr2[i].getStoriesObserver == null || postArrayDataArr2[i].getStoriesObserver.isDisposed()) && observableFlatMap != null) {
            this.postArrayInfo[i].getStoriesObserver = (DisposableObserver) observableFlatMap.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.11
                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    if (HighlightPostGridLayout.this.postArrayInfo[i].getStoriesObserver != null) {
                        HighlightPostGridLayout.this.postArrayInfo[i].getStoriesObserver.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    if (HighlightPostGridLayout.this.postArrayInfo[i].getStoriesObserver != null) {
                        HighlightPostGridLayout.this.postArrayInfo[i].getStoriesObserver.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    if (HighlightPostGridLayout.this.postArrayInfo[i].getStoriesObserver != null) {
                        HighlightPostGridLayout.this.postArrayInfo[i].getStoriesObserver.dispose();
                    }
                }
            });
            this.profileActivity.compositeDisposable.add(this.postArrayInfo[i].getStoriesObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ObservableSource lambda$loadStories$3(final int i, Rubino.GetMyArchiveStoriesOutput getMyArchiveStoriesOutput) throws Exception {
        this.postArrayInfo[i].loading = false;
        if (this.mediaPages[i].listView.getAdapter() != null) {
            this.oldItemCounts[i] = this.mediaPages[i].listView.getAdapter().getItemCount();
        }
        ArrayList<StoryObject> arrayList = getMyArchiveStoriesOutput.stories;
        if (arrayList != null) {
            this.postArrayInfo[i].addPosts(arrayList, false);
            PostArrayData[] postArrayDataArr = this.postArrayInfo;
            postArrayDataArr[i].endReached = !getMyArchiveStoriesOutput.has_continue;
            postArrayDataArr[i].nextStartId = getMyArchiveStoriesOutput.next_start_id;
        } else {
            this.postArrayInfo[i].endReached = true;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.10
            @Override // java.lang.Runnable
            public void run() {
                HighlightPostGridLayout highlightPostGridLayout = HighlightPostGridLayout.this;
                SharedPhotoVideoAdapter sharedPhotoVideoAdapter = (SharedPhotoVideoAdapter) highlightPostGridLayout.mediaPages[i].listView.getAdapter();
                int[] iArr = HighlightPostGridLayout.this.oldItemCounts;
                int i2 = i;
                highlightPostGridLayout.refreshAdaptersAndUpdateUI(sharedPhotoVideoAdapter, iArr[i2], i2);
            }
        });
        return Observable.just(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$loadStories$4(String str, GetStoryIdsOutput getStoryIdsOutput) throws Exception {
        return RubinoController.getInstance(this.currentAccount).getHighlightStory(getStoryIdsOutput.story_ids, str, this.highlight.highlight_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$loadStories$5(int i, GetStoryOutput getStoryOutput) throws Exception {
        this.postArrayInfo[i].loading = false;
        MediaPage[] mediaPageArr = this.mediaPages;
        MediaPage mediaPage = mediaPageArr[0];
        int length = mediaPageArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            MediaPage mediaPage2 = mediaPageArr[i2];
            if (mediaPage2.selectedType == i) {
                this.oldItemCounts[i] = mediaPage2.listView.getAdapter().getItemCount();
                mediaPage = mediaPage2;
                break;
            }
            i2++;
        }
        ArrayList<StoryObject> arrayList = getStoryOutput.stories;
        if (arrayList != null) {
            Collections.reverse(arrayList);
            this.postArrayInfo[i].addPosts(getStoryOutput.stories, false);
            PostArrayData[] postArrayDataArr = this.postArrayInfo;
            postArrayDataArr[i].endReached = true;
            postArrayDataArr[i].nextStartId = null;
            Iterator<StoryObject> it = getStoryOutput.stories.iterator();
            while (it.hasNext()) {
                StoryObject next = it.next();
                if (next != null) {
                    this.selectedItems.put(next.id, next);
                }
            }
        } else {
            this.postArrayInfo[i].endReached = true;
        }
        refreshAdaptersAndUpdateUI((SharedPhotoVideoAdapter) mediaPage.listView.getAdapter(), this.oldItemCounts[i], i);
        return Observable.just(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAdaptersAndUpdateUI(SharedPhotoVideoAdapter sharedPhotoVideoAdapter, int i, int i2) {
        for (MediaPage mediaPage : this.mediaPages) {
            if (mediaPage.listView.getAdapter() == sharedPhotoVideoAdapter) {
                mediaPage.listView.stopScroll();
            }
        }
        if (i < 0) {
            i = 0;
        }
        int itemCount = sharedPhotoVideoAdapter.getItemCount();
        if (i > 1) {
            sharedPhotoVideoAdapter.notifyItemRangeChanged(i - 2, 1);
            if (itemCount >= i) {
                sharedPhotoVideoAdapter.notifyItemRangeChanged(i - 1, 1);
            }
        } else if (i == 1 && itemCount > 0) {
            sharedPhotoVideoAdapter.notifyItemRangeChanged(i - 1, 1);
        }
        if (itemCount > i) {
            sharedPhotoVideoAdapter.notifyItemRangeInserted(i, itemCount - i);
        } else if (itemCount < i) {
            sharedPhotoVideoAdapter.notifyItemRangeRemoved(itemCount, i - itemCount);
        }
        for (MediaPage mediaPage2 : this.mediaPages) {
            if (mediaPage2.selectedType == i2 && !this.postArrayInfo[i2].loading) {
                if (mediaPage2.progressView != null) {
                    mediaPage2.progressView.setVisibility(8);
                }
                if (mediaPage2.listView != null && mediaPage2.listView.getEmptyView() == null) {
                    mediaPage2.listView.setEmptyView(mediaPage2.emptyView);
                }
            }
        }
    }

    public void onResume() {
        SharedPhotoVideoAdapter sharedPhotoVideoAdapter;
        SharedPhotoVideoAdapter sharedPhotoVideoAdapter2 = this.photoVideoAdapter;
        if (sharedPhotoVideoAdapter2 != null) {
            sharedPhotoVideoAdapter2.notifyDataSetChanged();
        }
        SharedPhotoVideoAdapter sharedPhotoVideoAdapter3 = this.photoVideoAdapterSecond;
        if (sharedPhotoVideoAdapter3 != null) {
            sharedPhotoVideoAdapter3.notifyDataSetChanged();
        }
        if (this.tabCount > 2 && (sharedPhotoVideoAdapter = this.photoVideoAdapterThird) != null) {
            sharedPhotoVideoAdapter.notifyDataSetChanged();
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
                this.mediaPages[i].listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout.12
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        HighlightPostGridLayout.this.mediaPages[i].getViewTreeObserver().removeOnPreDrawListener(this);
                        HighlightPostGridLayout.this.fixLayoutInternal(i);
                        return true;
                    }
                });
            }
            i++;
        }
    }

    private void updateTabs() {
        HighlightScrollSlidingTextTabStrip highlightScrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (highlightScrollSlidingTextTabStrip == null) {
            return;
        }
        boolean z = (this.hasMedia[0] <= 0) == highlightScrollSlidingTextTabStrip.hasTab(0);
        if ((this.hasMedia[1] <= 0) == this.scrollSlidingTextTabStrip.hasTab(1)) {
            z = true;
        }
        if (this.tabCount > 2) {
            if ((this.hasMedia[2] <= 0) == this.scrollSlidingTextTabStrip.hasTab(2)) {
                z = true;
            }
        }
        if (z) {
            this.scrollSlidingTextTabStrip.removeTabs();
            if (this.hasMedia[0] > 0 && !this.scrollSlidingTextTabStrip.hasTab(0)) {
                this.scrollSlidingTextTabStrip.addTab(0, "انتخاب شده");
            }
            if (this.hasMedia[1] > 0 && !this.scrollSlidingTextTabStrip.hasTab(1)) {
                getContext().getResources().getDrawable(R.drawable.rubino_tag_up_outline_24).mutate();
                this.scrollSlidingTextTabStrip.addTab(1, "استوری ها");
            }
            if (this.tabCount > 2 && this.hasMedia[2] > 0 && !this.scrollSlidingTextTabStrip.hasTab(2)) {
                getContext().getResources().getDrawable(R.drawable.files_gallery).mutate();
                this.scrollSlidingTextTabStrip.addTab(3, "thirdTabIcon");
            }
        }
        int currentTabId = this.scrollSlidingTextTabStrip.getCurrentTabId();
        if (currentTabId >= 0) {
            this.mediaPages[0].selectedType = currentTabId;
        }
        this.scrollSlidingTextTabStrip.finishAddingTabs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode(boolean z) {
        MediaPage[] mediaPageArr;
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
        this.mediaPages[z ? 1 : 0].emptyTextView.setTextSize(1, 17.0f);
        this.mediaPages[z ? 1 : 0].emptyImageView.setVisibility(0);
        this.mediaPages[z ? 1 : 0].listView.setPinnedHeaderShadowDrawable(null);
        if (this.mediaPages[z ? 1 : 0].selectedType != 0) {
            if (this.mediaPages[z ? 1 : 0].selectedType == 1) {
                if (adapter != this.photoVideoAdapterSecond) {
                    recycleAdapter(adapter);
                    this.mediaPages[z ? 1 : 0].listView.setAdapter(this.photoVideoAdapterSecond);
                }
                this.mediaPages[z ? 1 : 0].listView.setPinnedHeaderShadowDrawable(this.pinnedHeaderShadowDrawable);
                this.mediaPages[z ? 1 : 0].emptyTextView.setText(LocaleController.getString(R.string.rubinoHighlightNoStory));
                this.mediaPages[z ? 1 : 0].emptyTextView2.setText(LocaleController.getString(R.string.rubinoHighlightNoStory));
            } else if (this.tabCount > 2 && this.mediaPages[z ? 1 : 0].selectedType == 2) {
                if (adapter != this.photoVideoAdapterThird) {
                    recycleAdapter(adapter);
                    this.mediaPages[z ? 1 : 0].listView.setAdapter(this.photoVideoAdapterThird);
                }
                this.mediaPages[z ? 1 : 0].listView.setPinnedHeaderShadowDrawable(this.pinnedHeaderShadowDrawable);
                this.mediaPages[z ? 1 : 0].emptyImageView.setImageResource(R.drawable.tip1);
                this.mediaPages[z ? 1 : 0].emptyTextView.setText(BuildConfig.FLAVOR);
            }
        } else {
            if (adapter != this.photoVideoAdapter) {
                recycleAdapter(adapter);
                this.mediaPages[z ? 1 : 0].listView.setAdapter(this.photoVideoAdapter);
            }
            this.mediaPages[z ? 1 : 0].listView.setPinnedHeaderShadowDrawable(this.pinnedHeaderShadowDrawable);
            this.mediaPages[z ? 1 : 0].emptyTextView.setText(LocaleController.getString(R.string.rubinoHighlightNoStory));
            this.mediaPages[z ? 1 : 0].emptyTextView2.setText(LocaleController.getString(R.string.rubinoHighlightNoStory));
        }
        this.mediaPages[z ? 1 : 0].emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
        if (!this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].loading && !this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].endReached && this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].stories.isEmpty()) {
            this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].loading = true;
        }
        if (!this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].loading || !this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].stories.isEmpty()) {
            this.mediaPages[z ? 1 : 0].progressView.setVisibility(8);
            this.mediaPages[z ? 1 : 0].listView.setEmptyView(this.mediaPages[z ? 1 : 0].emptyView);
        } else {
            this.mediaPages[z ? 1 : 0].progressView.setVisibility(0);
            this.mediaPages[z ? 1 : 0].listView.setEmptyView(null);
            this.mediaPages[z ? 1 : 0].emptyView.setVisibility(8);
        }
        this.mediaPages[z ? 1 : 0].listView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(int i, View view, StoryObject storyObject, int i2, int i3, int i4) {
        boolean zContainsKey = this.selectedItems.containsKey(storyObject.id);
        ((StoryInGridCell) view).setChecked(i2, !zContainsKey);
        if (zContainsKey) {
            this.selectedItems.remove(storyObject.id);
        } else {
            this.selectedItems.put(storyObject.id, storyObject);
        }
        for (MediaPage mediaPage : this.mediaPages) {
            if (mediaPage.listView.getAdapter() != null) {
                mediaPage.listView.getAdapter().notifyItemChanged(i / this.columnsCount);
            }
        }
    }

    private void recycleAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof SharedPhotoVideoAdapter) {
            int tabIndex = ((SharedPhotoVideoAdapter) adapter).getTabIndex();
            this.cellCaches.get(tabIndex).addAll(this.caches.get(tabIndex));
            this.caches.get(tabIndex).clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal(int i) {
        SharedPhotoVideoAdapter sharedPhotoVideoAdapter;
        int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (AndroidUtilities.isTablet()) {
            this.columnsCount = 3;
            this.mediaPages[i].emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
        } else if (rotation == 3 || rotation == 1) {
            this.columnsCount = 6;
            this.mediaPages[i].emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        } else {
            this.columnsCount = 3;
            this.mediaPages[i].emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
        }
        if (i == 0) {
            this.photoVideoAdapter.notifyDataSetChanged();
            this.photoVideoAdapterSecond.notifyDataSetChanged();
            if (this.tabCount <= 2 || (sharedPhotoVideoAdapter = this.photoVideoAdapterThird) == null) {
                return;
            }
            sharedPhotoVideoAdapter.notifyDataSetChanged();
        }
    }

    public ArrayList<String> getSelectedStories() {
        return new ArrayList<>(this.selectedItems.keySet());
    }

    public ArrayList<String> getAddedStories() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.selectedItems.keySet()) {
            if (!this.postArrayInfo[0].storiesMap.containsKey(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public ArrayList<String> getRemovedStories() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<StoryObject> it = this.postArrayInfo[0].stories.iterator();
        while (it.hasNext()) {
            StoryObject next = it.next();
            if (!this.selectedItems.containsKey(next.id)) {
                arrayList.add(next.id);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SharedPhotoVideoAdapter extends RecyclerListViewEdited.SelectionAdapter {
        private Context mContext;
        private int tabIndex;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public SharedPhotoVideoAdapter(Context context, int i) {
            this.tabIndex = -1;
            this.mContext = context;
            this.tabIndex = i;
        }

        public int getTabIndex() {
            return this.tabIndex;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int iCeil = (int) Math.ceil(HighlightPostGridLayout.this.postArrayInfo[this.tabIndex].stories.size() / HighlightPostGridLayout.this.columnsCount);
            return (iCeil == 0 || HighlightPostGridLayout.this.postArrayInfo[this.tabIndex].endReached) ? iCeil : iCeil + 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(StoryInGridCell storyInGridCell, int i, StoryObject storyObject, int i2) {
            HighlightPostGridLayout.this.onItemClick(i, storyInGridCell, storyObject, i2, 0, this.tabIndex);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View storyInGridCell;
            if (i == 0) {
                if (!HighlightPostGridLayout.this.cellCaches.isEmpty() && this.tabIndex != -1 && ((ArrayList) HighlightPostGridLayout.this.cellCaches.get(this.tabIndex)).size() > 0) {
                    storyInGridCell = (View) ((ArrayList) HighlightPostGridLayout.this.cellCaches.get(this.tabIndex)).get(0);
                    ((ArrayList) HighlightPostGridLayout.this.cellCaches.get(this.tabIndex)).remove(0);
                    ViewGroup viewGroup2 = (ViewGroup) storyInGridCell.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(storyInGridCell);
                    }
                } else {
                    storyInGridCell = new StoryInGridCell(this.mContext);
                }
                StoryInGridCell storyInGridCell2 = (StoryInGridCell) storyInGridCell;
                storyInGridCell2.setDelegate(new StoryInGridCell.SharedPhotoVideoCellDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout$SharedPhotoVideoAdapter$$ExternalSyntheticLambda0
                    @Override // ir.resaneh1.iptv.fragment.rubino.StoryInGridCell.SharedPhotoVideoCellDelegate
                    public final void didClickItem(StoryInGridCell storyInGridCell3, int i2, StoryObject storyObject, int i3) {
                        this.f$0.lambda$onCreateViewHolder$0(storyInGridCell3, i2, storyObject, i3);
                    }
                });
                ((ArrayList) HighlightPostGridLayout.this.caches.get(this.tabIndex)).add(storyInGridCell2);
            } else {
                storyInGridCell = new RubinoLoadingCell(this.mContext, false);
            }
            storyInGridCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListViewEdited.Holder(storyInGridCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ArrayList<StoryObject> arrayList = HighlightPostGridLayout.this.postArrayInfo[this.tabIndex].stories;
                StoryInGridCell storyInGridCell = (StoryInGridCell) viewHolder.itemView;
                storyInGridCell.setItemsCount(HighlightPostGridLayout.this.columnsCount);
                storyInGridCell.setIsFirst(i == 0);
                for (int i2 = 0; i2 < HighlightPostGridLayout.this.columnsCount; i2++) {
                    int i3 = (HighlightPostGridLayout.this.columnsCount * i) + i2;
                    if (i3 < arrayList.size()) {
                        StoryObject storyObject = arrayList.get(i3);
                        storyInGridCell.setItem(i2, HighlightPostGridLayout.this.postArrayInfo[this.tabIndex].stories.indexOf(storyObject), storyObject, storyObject != null && HighlightPostGridLayout.this.selectedItems.containsKey(storyObject.id));
                    } else {
                        storyInGridCell.setItem(i2, i3, null, false);
                    }
                }
                storyInGridCell.requestLayout();
            }
            if (HighlightPostGridLayout.this.postArrayInfo[this.tabIndex].endReached || HighlightPostGridLayout.this.postArrayInfo[this.tabIndex].loading || i * HighlightPostGridLayout.this.columnsCount <= HighlightPostGridLayout.this.postArrayInfo[this.tabIndex].stories.size() - 24) {
                return;
            }
            HighlightPostGridLayout.this.loadStories(this.tabIndex);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return ((double) i) < Math.ceil((double) (((float) HighlightPostGridLayout.this.postArrayInfo[this.tabIndex].stories.size()) / ((float) HighlightPostGridLayout.this.columnsCount))) ? 0 : 1;
        }
    }
}
