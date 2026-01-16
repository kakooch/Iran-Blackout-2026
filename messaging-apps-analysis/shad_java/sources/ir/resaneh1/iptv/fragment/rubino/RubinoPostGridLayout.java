package ir.resaneh1.iptv.fragment.rubino;

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
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.PostInGridCell;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.fragment.rubino.RubinoScrollSlidingTextTabStrip;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.ArrayList;
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
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Size;

/* loaded from: classes3.dex */
public class RubinoPostGridLayout extends FrameLayout {
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$$ExternalSyntheticLambda1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return RubinoPostGridLayout.lambda$static$0(f);
        }
    };
    private ActionBar actionBar;
    private boolean animatingForward;
    private boolean backAnimation;
    private ArrayList<ArrayList<PostInGridCell>> caches;
    private ArrayList<ArrayList<PostInGridCell>> cellCaches;
    private int columnsCount;
    int currentAccount;
    private int[] hasMedia;
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
    private RubinoProfileActivity profileActivity;
    private RubinoScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private boolean scrolling;
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

    public void checkPostDeleted(String str) {
        int i = 0;
        while (true) {
            PostArrayData[] postArrayDataArr = this.postArrayInfo;
            if (i >= postArrayDataArr.length) {
                return;
            }
            RubinoPostObject rubinoPostObjectRemove = postArrayDataArr[i].postMap.remove(str);
            if (rubinoPostObjectRemove != null) {
                this.postArrayInfo[i].posts.remove(rubinoPostObjectRemove);
                this.postArrayInfo[i].postMap.remove(str);
                if (i == 0) {
                    this.photoVideoAdapter.notifyDataSetChanged();
                    return;
                } else if (i == 1) {
                    this.photoVideoAdapterSecond.notifyDataSetChanged();
                    return;
                } else {
                    if (i == 2) {
                        this.photoVideoAdapterThird.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
            }
            i++;
        }
    }

    public static class PostArrayData {
        public DisposableObserver getPostsObserver;
        public ArrayList<RubinoPostObject> posts = new ArrayList<>();
        public Map<String, RubinoPostObject> postMap = new HashMap();
        public boolean loading = true;
        public boolean endReached = false;
        public String maxID = null;

        public void addPosts(ArrayList<RubinoPostObject> arrayList, boolean z) {
            if (z) {
                this.posts.clear();
                this.postMap.clear();
            }
            this.posts.addAll(arrayList);
            Iterator<RubinoPostObject> it = arrayList.iterator();
            while (it.hasNext()) {
                RubinoPostObject next = it.next();
                this.postMap.put(next.post.id, next);
            }
        }
    }

    public RubinoPostGridLayout(Context context, RubinoProfileActivity rubinoProfileActivity, int i) throws Resources.NotFoundException {
        RecyclerListViewEdited.Holder holder;
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.cellCaches = new ArrayList<>();
        this.caches = new ArrayList<>();
        new Paint();
        this.columnsCount = 3;
        this.oldItemCounts = new int[]{0, 0, 0};
        int i2 = 2;
        this.tabCount = 2;
        this.tabCount = i;
        this.postArrayInfo = new PostArrayData[i];
        this.mediaPages = new MediaPage[2];
        if (i == 2) {
            this.hasMedia = new int[]{1, 1};
        } else {
            this.hasMedia = new int[]{1, 1, 1};
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.hasMedia;
            if (i3 >= iArr.length) {
                break;
            }
            if (iArr[i3] == -1 || iArr[i3] > 0) {
                break;
            } else {
                i3++;
            }
        }
        this.initialTab = i3;
        int i4 = 0;
        while (true) {
            PostArrayData[] postArrayDataArr = this.postArrayInfo;
            if (i4 >= postArrayDataArr.length) {
                break;
            }
            postArrayDataArr[i4] = new PostArrayData();
            i4++;
        }
        this.profileActivity = rubinoProfileActivity;
        this.actionBar = rubinoProfileActivity.getActionBar();
        for (int i5 = 0; i5 < i; i5++) {
            ArrayList<PostInGridCell> arrayList = new ArrayList<>(10);
            for (int i6 = 0; i6 < 10; i6++) {
                arrayList.add(new PostInGridCell(context));
            }
            this.cellCaches.add(arrayList);
            this.caches.add(new ArrayList<>(10));
        }
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        Drawable drawable = context.getResources().getDrawable(R.drawable.photos_header_shadow);
        this.pinnedHeaderShadowDrawable = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundGrayShadow), PorterDuff.Mode.MULTIPLY));
        RubinoScrollSlidingTextTabStrip rubinoScrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (rubinoScrollSlidingTextTabStrip != null) {
            this.initialTab = rubinoScrollSlidingTextTabStrip.getCurrentTabId();
        }
        RubinoScrollSlidingTextTabStrip rubinoScrollSlidingTextTabStrip2 = new RubinoScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = rubinoScrollSlidingTextTabStrip2;
        int i7 = this.initialTab;
        if (i7 != -1) {
            rubinoScrollSlidingTextTabStrip2.setInitialTabId(i7);
            this.initialTab = -1;
        }
        this.scrollSlidingTextTabStrip.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.scrollSlidingTextTabStrip.setDelegate(new RubinoScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.1
            @Override // ir.resaneh1.iptv.fragment.rubino.RubinoScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i8, boolean z) {
                if (RubinoPostGridLayout.this.mediaPages[0].selectedType == i8) {
                    return;
                }
                RubinoPostGridLayout.this.mediaPages[1].selectedType = i8;
                RubinoPostGridLayout.this.mediaPages[1].setVisibility(0);
                RubinoPostGridLayout.this.switchToCurrentSelectedMode(true);
                RubinoPostGridLayout.this.animatingForward = z;
                RubinoPostGridLayout.this.onSelectedTabChanged();
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RubinoScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onSamePageSelected() {
                RubinoPostGridLayout.this.scrollToTop();
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RubinoScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float f) {
                if (f != 1.0f || RubinoPostGridLayout.this.mediaPages[1].getVisibility() == 0) {
                    if (RubinoPostGridLayout.this.animatingForward) {
                        RubinoPostGridLayout.this.mediaPages[0].setTranslationX((-f) * RubinoPostGridLayout.this.mediaPages[0].getMeasuredWidth());
                        RubinoPostGridLayout.this.mediaPages[1].setTranslationX(RubinoPostGridLayout.this.mediaPages[0].getMeasuredWidth() - (RubinoPostGridLayout.this.mediaPages[0].getMeasuredWidth() * f));
                    } else {
                        RubinoPostGridLayout.this.mediaPages[0].setTranslationX(RubinoPostGridLayout.this.mediaPages[0].getMeasuredWidth() * f);
                        RubinoPostGridLayout.this.mediaPages[1].setTranslationX((RubinoPostGridLayout.this.mediaPages[0].getMeasuredWidth() * f) - RubinoPostGridLayout.this.mediaPages[0].getMeasuredWidth());
                    }
                    if (f == 1.0f) {
                        MediaPage mediaPage = RubinoPostGridLayout.this.mediaPages[0];
                        RubinoPostGridLayout.this.mediaPages[0] = RubinoPostGridLayout.this.mediaPages[1];
                        RubinoPostGridLayout.this.mediaPages[1] = mediaPage;
                        RubinoPostGridLayout.this.mediaPages[1].setVisibility(8);
                    }
                }
            }
        });
        this.photoVideoAdapter = new SharedPhotoVideoAdapter(context, 0);
        this.photoVideoAdapterSecond = new SharedPhotoVideoAdapter(context, 1);
        this.photoVideoAdapterThird = new SharedPhotoVideoAdapter(context, 2);
        setWillNotDraw(false);
        int i8 = 0;
        int iFindFirstVisibleItemPosition = -1;
        int top = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i8 < mediaPageArr.length) {
                if ((i8 == 0 || i8 == 1) && mediaPageArr[i8] != null && mediaPageArr[i8].layoutManager != null) {
                    iFindFirstVisibleItemPosition = this.mediaPages[i8].layoutManager.findFirstVisibleItemPosition();
                    if (iFindFirstVisibleItemPosition == this.mediaPages[i8].layoutManager.getItemCount() - 1 || (holder = (RecyclerListViewEdited.Holder) this.mediaPages[i8].listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) == null) {
                        iFindFirstVisibleItemPosition = -1;
                    } else {
                        top = holder.itemView.getTop();
                    }
                }
                final MediaPage mediaPage = new MediaPage(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.2
                    @Override // android.view.View
                    public void setTranslationX(float f) {
                        super.setTranslationX(f);
                        if (RubinoPostGridLayout.this.tabsAnimationInProgress && RubinoPostGridLayout.this.mediaPages[0] == this) {
                            RubinoPostGridLayout.this.scrollSlidingTextTabStrip.selectTabWithId(RubinoPostGridLayout.this.mediaPages[1].selectedType, Math.abs(RubinoPostGridLayout.this.mediaPages[0].getTranslationX()) / RubinoPostGridLayout.this.mediaPages[0].getMeasuredWidth());
                        }
                    }
                };
                addView(mediaPage, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 48.0f, 0.0f, 0.0f));
                MediaPage[] mediaPageArr2 = this.mediaPages;
                mediaPageArr2[i8] = mediaPage;
                final ExtendedGridLayoutManager extendedGridLayoutManager = mediaPageArr2[i8].layoutManager = new ExtendedGridLayoutManager(context, 100) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.3
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
                        if (mediaPage.selectedType == 0) {
                            iArr2[1] = Math.max(iArr2[1], PostInGridCell.getItemSize(RubinoPostGridLayout.this.columnsCount) * 2);
                        } else if (mediaPage.selectedType == 1) {
                            iArr2[1] = Math.max(iArr2[1], AndroidUtilities.dp(56.0f) * 2);
                        }
                    }
                };
                extendedGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.4
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i9) {
                        return mediaPage.layoutManager.getSpanCount();
                    }
                });
                this.mediaPages[i8].listView = new RecyclerListViewEdited(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.5
                    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean z, int i9, int i10, int i11, int i12) {
                        super.onLayout(z, i9, i10, i11, i12);
                        RubinoPostGridLayout rubinoPostGridLayout = RubinoPostGridLayout.this;
                        MediaPage mediaPage2 = mediaPage;
                        rubinoPostGridLayout.checkLoadMoreScroll(mediaPage2, mediaPage2.listView, extendedGridLayoutManager);
                    }
                };
                this.mediaPages[i8].listView.setScrollingTouchSlop(1);
                this.mediaPages[i8].listView.setPinnedSectionOffsetY(-AndroidUtilities.dp(2.0f));
                this.mediaPages[i8].listView.setPadding(0, AndroidUtilities.dp(2.0f), 0, 0);
                this.mediaPages[i8].listView.setItemAnimator(null);
                this.mediaPages[i8].listView.setClipToPadding(false);
                this.mediaPages[i8].listView.setSectionsType(i2);
                this.mediaPages[i8].listView.setLayoutManager(extendedGridLayoutManager);
                MediaPage[] mediaPageArr3 = this.mediaPages;
                mediaPageArr3[i8].addView(mediaPageArr3[i8].listView, LayoutHelper.createFrame(-1, -1.0f));
                this.mediaPages[i8].listView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.6
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                        rect.left = 0;
                        rect.top = 0;
                        rect.bottom = 0;
                        rect.right = 0;
                    }
                });
                this.mediaPages[i8].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.7
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrollStateChanged(RecyclerView recyclerView, int i9) {
                        RubinoPostGridLayout.this.scrolling = i9 != 0;
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(RecyclerView recyclerView, int i9, int i10) {
                        RubinoPostGridLayout.this.checkLoadMoreScroll(mediaPage, recyclerView, extendedGridLayoutManager);
                    }
                });
                this.mediaPages[i8].listView.setOnItemLongClickListener(new RecyclerListViewEdited.OnItemLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$$ExternalSyntheticLambda2
                    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemLongClickListener
                    public final boolean onItemClick(View view, int i9) {
                        return RubinoPostGridLayout.lambda$new$1(view, i9);
                    }
                });
                if (i8 == 0 && iFindFirstVisibleItemPosition != -1) {
                    extendedGridLayoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
                }
                RecyclerListViewEdited unused = this.mediaPages[i8].listView;
                this.mediaPages[i8].emptyView = new LinearLayout(context);
                this.mediaPages[i8].emptyView.setWillNotDraw(false);
                this.mediaPages[i8].emptyView.setOrientation(1);
                this.mediaPages[i8].emptyView.setGravity(17);
                this.mediaPages[i8].emptyView.setVisibility(8);
                MediaPage[] mediaPageArr4 = this.mediaPages;
                mediaPageArr4[i8].addView(mediaPageArr4[i8].emptyView, LayoutHelper.createFrame(-1, -1.0f));
                this.mediaPages[i8].emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return RubinoPostGridLayout.lambda$new$2(view, motionEvent);
                    }
                });
                this.mediaPages[i8].emptyImageView = new ImageView(context);
                ImageView imageView = this.mediaPages[i8].emptyImageView;
                int i9 = Theme.key_rubinoBlackColor;
                imageView.setColorFilter(Theme.getColor(i9));
                this.mediaPages[i8].emptyView.addView(this.mediaPages[i8].emptyImageView, LayoutHelper.createLinear(90, 90, 1));
                this.mediaPages[i8].emptyTextView = new TextView(context);
                this.mediaPages[i8].emptyTextView.setTextColor(Theme.getColor(i9));
                this.mediaPages[i8].emptyTextView.setGravity(17);
                this.mediaPages[i8].emptyTextView.setTextSize(1, 17.0f);
                this.mediaPages[i8].emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
                this.mediaPages[i8].emptyView.addView(this.mediaPages[i8].emptyTextView, LayoutHelper.createLinear(-2, -2, 1, 0, 24, 0, 0));
                this.mediaPages[i8].emptyTextView2 = new TextView(context);
                this.mediaPages[i8].emptyTextView2.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
                this.mediaPages[i8].emptyTextView2.setGravity(17);
                this.mediaPages[i8].emptyTextView2.setTextSize(1, 15.0f);
                this.mediaPages[i8].emptyTextView2.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(16.0f));
                this.mediaPages[i8].emptyView.addView(this.mediaPages[i8].emptyTextView2, LayoutHelper.createLinear(-2, -2, 1, 0, 24, 0, 0));
                this.mediaPages[i8].progressView = new LinearLayout(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.8
                    @Override // android.widget.LinearLayout, android.view.View
                    protected void onDraw(Canvas canvas) {
                    }
                };
                this.mediaPages[i8].progressView.setWillNotDraw(false);
                this.mediaPages[i8].progressView.setGravity(17);
                this.mediaPages[i8].progressView.setOrientation(1);
                this.mediaPages[i8].progressView.setVisibility(8);
                MediaPage[] mediaPageArr5 = this.mediaPages;
                mediaPageArr5[i8].addView(mediaPageArr5[i8].progressView, LayoutHelper.createFrame(-1, -1.0f));
                this.mediaPages[i8].progressBar = new RubinoLoadingCell(context, false);
                this.mediaPages[i8].progressView.addView(this.mediaPages[i8].progressBar, LayoutHelper.createLinear(-2, -2));
                if (i8 != 0) {
                    this.mediaPages[i8].setVisibility(8);
                }
                MediaPage[] mediaPageArr6 = this.mediaPages;
                mediaPageArr6[i8].scrollHelper = new RecyclerAnimationScrollHelper(mediaPageArr6[i8].listView, this.mediaPages[i8].layoutManager);
                i8++;
                i2 = 2;
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
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r5.mediaPages
            r1 = 0
            r0 = r0[r1]
            int r0 = ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.MediaPage.access$100(r0)
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
            int r0 = ir.resaneh1.iptv.fragment.rubino.PostInGridCell.getItemSize(r0)
        L3c:
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r3 = r5.mediaPages
            r3 = r3[r1]
            ir.resaneh1.iptv.fragment.rubino.ExtendedGridLayoutManager r3 = ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.MediaPage.access$500(r3)
            int r3 = r3.findFirstVisibleItemPosition()
            int r3 = r3 * r0
            float r0 = (float) r3
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r3 = r5.mediaPages
            r3 = r3[r1]
            ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited r3 = ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.MediaPage.access$600(r3)
            int r3 = r3.getMeasuredHeight()
            float r3 = (float) r3
            r4 = 1067030938(0x3f99999a, float:1.2)
            float r3 = r3 * r4
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto L78
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            ir.resaneh1.iptv.fragment.rubino.RecyclerAnimationScrollHelper r0 = ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.MediaPage.access$1800(r0)
            r0.setScrollDirection(r2)
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            ir.resaneh1.iptv.fragment.rubino.RecyclerAnimationScrollHelper r0 = ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.MediaPage.access$1800(r0)
            r0.scrollToPosition(r1, r1, r1, r2)
            goto L83
        L78:
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r5.mediaPages
            r0 = r0[r1]
            ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited r0 = ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.MediaPage.access$600(r0)
            r0.smoothScrollToPosition(r1)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.scrollToTop():void");
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
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r1]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r1]
            r0.setTranslationX(r3)
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r7.mediaPages
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
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r7.mediaPages
            r0 = r0[r5]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r7.mediaPages
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
            ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$MediaPage[] r0 = r7.mediaPages
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
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.checkTabsAnimationInProgress():boolean");
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
                this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.9
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        RubinoPostGridLayout.this.tabsAnimation = null;
                        if (RubinoPostGridLayout.this.backAnimation) {
                            RubinoPostGridLayout.this.mediaPages[1].setVisibility(8);
                        } else {
                            MediaPage mediaPage = RubinoPostGridLayout.this.mediaPages[0];
                            RubinoPostGridLayout.this.mediaPages[0] = RubinoPostGridLayout.this.mediaPages[1];
                            RubinoPostGridLayout.this.mediaPages[1] = mediaPage;
                            RubinoPostGridLayout.this.mediaPages[1].setVisibility(8);
                            RubinoPostGridLayout.this.scrollSlidingTextTabStrip.selectTabWithId(RubinoPostGridLayout.this.mediaPages[0].selectedType, 1.0f);
                            RubinoPostGridLayout.this.onSelectedTabChanged();
                        }
                        RubinoPostGridLayout.this.tabsAnimationInProgress = false;
                        RubinoPostGridLayout.this.maybeStartTracking = false;
                        RubinoPostGridLayout.this.startedTracking = false;
                        RubinoPostGridLayout.this.actionBar.setEnabled(true);
                        RubinoPostGridLayout.this.scrollSlidingTextTabStrip.setEnabled(true);
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

    public void loadPosts(final int i) {
        PostArrayData[] postArrayDataArr = this.postArrayInfo;
        if (postArrayDataArr[i].endReached) {
            return;
        }
        Observable<Rubino.PostObjectList> tagPostsObservable = null;
        String str = postArrayDataArr[i].maxID;
        if (i == 0) {
            RubinoController rubinoController = RubinoController.getInstance(this.currentAccount);
            RubinoProfileObject rubinoProfileObject = this.profileActivity.profileObject;
            tagPostsObservable = rubinoController.getProfilePostsObservable(rubinoProfileObject.isMyProfile, rubinoProfileObject.id, null, str, 51, Rubino.SortEnum.FromMax);
        } else if (i == 1) {
            tagPostsObservable = RubinoController.getInstance(this.currentAccount).getTagPostsObservable(this.profileActivity.profileObject.id, str);
        }
        PostArrayData[] postArrayDataArr2 = this.postArrayInfo;
        if ((postArrayDataArr2[i].getPostsObserver == null || postArrayDataArr2[i].getPostsObserver.isDisposed()) && tagPostsObservable != null) {
            this.postArrayInfo[i].getPostsObserver = (DisposableObserver) tagPostsObservable.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.PostObjectList>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.10
                @Override // io.reactivex.Observer
                public void onNext(Rubino.PostObjectList postObjectList) {
                    RubinoPostGridLayout.this.postArrayInfo[i].loading = false;
                    MediaPage mediaPage = RubinoPostGridLayout.this.mediaPages[0];
                    MediaPage[] mediaPageArr = RubinoPostGridLayout.this.mediaPages;
                    int length = mediaPageArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        MediaPage mediaPage2 = mediaPageArr[i2];
                        if (mediaPage2.selectedType == i) {
                            RubinoPostGridLayout.this.oldItemCounts[i] = mediaPage2.listView.getAdapter().getItemCount();
                            mediaPage = mediaPage2;
                            break;
                        }
                        i2++;
                    }
                    if (postObjectList.posts != null) {
                        RubinoPostGridLayout.this.postArrayInfo[i].addPosts(postObjectList.posts, false);
                        if (i == 1) {
                            RubinoPostGridLayout.this.postArrayInfo[i].endReached = !postObjectList.hasContinue;
                        } else {
                            RubinoPostGridLayout.this.postArrayInfo[i].endReached = postObjectList.posts.size() <= 0;
                        }
                        if (i == 1) {
                            RubinoPostGridLayout.this.postArrayInfo[i].maxID = postObjectList.nextStartId;
                        } else if (postObjectList.posts.size() > 0) {
                            PostArrayData postArrayData = RubinoPostGridLayout.this.postArrayInfo[i];
                            ArrayList<RubinoPostObject> arrayList = postObjectList.posts;
                            postArrayData.maxID = arrayList.get(arrayList.size() - 1).post.id;
                        }
                    } else {
                        RubinoPostGridLayout.this.postArrayInfo[i].endReached = true;
                    }
                    RubinoPostGridLayout rubinoPostGridLayout = RubinoPostGridLayout.this;
                    SharedPhotoVideoAdapter sharedPhotoVideoAdapter = (SharedPhotoVideoAdapter) mediaPage.listView.getAdapter();
                    int[] iArr = RubinoPostGridLayout.this.oldItemCounts;
                    int i3 = i;
                    rubinoPostGridLayout.refreshAdaptersAndUpdateUI(sharedPhotoVideoAdapter, iArr[i3], i3);
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    if (RubinoPostGridLayout.this.postArrayInfo[i].getPostsObserver != null) {
                        RubinoPostGridLayout.this.postArrayInfo[i].getPostsObserver.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    if (RubinoPostGridLayout.this.postArrayInfo[i].getPostsObserver != null) {
                        RubinoPostGridLayout.this.postArrayInfo[i].getPostsObserver.dispose();
                    }
                }
            });
            this.profileActivity.compositeDisposable.add(this.postArrayInfo[i].getPostsObserver);
        }
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
                this.mediaPages[i].listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout.11
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        RubinoPostGridLayout.this.mediaPages[i].getViewTreeObserver().removeOnPreDrawListener(this);
                        RubinoPostGridLayout.this.fixLayoutInternal(i);
                        return true;
                    }
                });
            }
            i++;
        }
    }

    private void updateTabs() {
        RubinoScrollSlidingTextTabStrip rubinoScrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (rubinoScrollSlidingTextTabStrip == null) {
            return;
        }
        boolean z = (this.hasMedia[0] <= 0) == rubinoScrollSlidingTextTabStrip.hasTab(0);
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
                this.scrollSlidingTextTabStrip.addTab(0, getContext().getResources().getDrawable(R.drawable.rubino_photo_grid_outline_24).mutate());
            }
            if (this.hasMedia[1] > 0 && !this.scrollSlidingTextTabStrip.hasTab(1)) {
                this.scrollSlidingTextTabStrip.addTab(1, getContext().getResources().getDrawable(R.drawable.rubino_tag_up_outline_24).mutate());
            }
            if (this.tabCount > 2 && this.hasMedia[2] > 0 && !this.scrollSlidingTextTabStrip.hasTab(2)) {
                this.scrollSlidingTextTabStrip.addTab(2, getContext().getResources().getDrawable(R.drawable.files_gallery).mutate());
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
                this.mediaPages[z ? 1 : 0].emptyImageView.setImageResource(R.drawable.rubino_empty_tag);
                this.mediaPages[z ? 1 : 0].emptyTextView.setText(LocaleController.getString(R.string.rubinoNoPosts));
                RubinoProfileObject rubinoProfileObject = this.profileActivity.profileObject;
                if (rubinoProfileObject == null || !rubinoProfileObject.isMyCurrentProfile()) {
                    this.mediaPages[z ? 1 : 0].emptyTextView2.setText(BuildConfig.FLAVOR);
                } else {
                    this.mediaPages[z ? 1 : 0].emptyTextView2.setText(LocaleController.getString(R.string.rubinoNoTagPostInfo));
                }
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
            this.mediaPages[z ? 1 : 0].emptyImageView.setImageResource(R.drawable.rubino_empty_post_camera);
            this.mediaPages[z ? 1 : 0].emptyTextView.setText(LocaleController.getString(R.string.rubinoNoPosts));
            RubinoProfileObject rubinoProfileObject2 = this.profileActivity.profileObject;
            if (rubinoProfileObject2 == null || !rubinoProfileObject2.isMyCurrentProfile()) {
                this.mediaPages[z ? 1 : 0].emptyTextView2.setText(BuildConfig.FLAVOR);
            } else {
                this.mediaPages[z ? 1 : 0].emptyTextView2.setText(LocaleController.getString(R.string.rubinoNoMyPostsInfo));
            }
        }
        this.mediaPages[z ? 1 : 0].emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
        if (!this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].loading && !this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].endReached && this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].posts.isEmpty()) {
            this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].loading = true;
        }
        if (!this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].loading || !this.postArrayInfo[this.mediaPages[z ? 1 : 0].selectedType].posts.isEmpty()) {
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
    public void onItemClick(int i, View view, RubinoPostObject rubinoPostObject, int i2, int i3, int i4) {
        RubinoProfileActivity rubinoProfileActivity = this.profileActivity;
        int i5 = i4 == 1 ? RubinoPostListActivity.taggedPostListType : RubinoPostListActivity.profilePostListType;
        RubinoProfileObject rubinoProfileObject = this.profileActivity.profileObject;
        PostArrayData[] postArrayDataArr = this.postArrayInfo;
        rubinoProfileActivity.presentFragment(new RubinoPostListActivity(i5, rubinoProfileObject, postArrayDataArr[i4].posts, postArrayDataArr[i4].postMap, postArrayDataArr[i4].maxID, !postArrayDataArr[i4].endReached, i));
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
            int iCeil = (int) Math.ceil(RubinoPostGridLayout.this.postArrayInfo[this.tabIndex].posts.size() / RubinoPostGridLayout.this.columnsCount);
            return (iCeil == 0 || RubinoPostGridLayout.this.postArrayInfo[this.tabIndex].endReached) ? iCeil : iCeil + 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(PostInGridCell postInGridCell, int i, RubinoPostObject rubinoPostObject, int i2) {
            RubinoPostGridLayout.this.onItemClick(i, postInGridCell, rubinoPostObject, i2, 0, this.tabIndex);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View postInGridCell;
            if (i == 0) {
                if (!RubinoPostGridLayout.this.cellCaches.isEmpty() && this.tabIndex != -1 && ((ArrayList) RubinoPostGridLayout.this.cellCaches.get(this.tabIndex)).size() > 0) {
                    postInGridCell = (View) ((ArrayList) RubinoPostGridLayout.this.cellCaches.get(this.tabIndex)).get(0);
                    ((ArrayList) RubinoPostGridLayout.this.cellCaches.get(this.tabIndex)).remove(0);
                    ViewGroup viewGroup2 = (ViewGroup) postInGridCell.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(postInGridCell);
                    }
                } else {
                    postInGridCell = new PostInGridCell(this.mContext);
                }
                PostInGridCell postInGridCell2 = (PostInGridCell) postInGridCell;
                postInGridCell2.setDelegate(new PostInGridCell.SharedPhotoVideoCellDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout$SharedPhotoVideoAdapter$$ExternalSyntheticLambda0
                    @Override // ir.resaneh1.iptv.fragment.rubino.PostInGridCell.SharedPhotoVideoCellDelegate
                    public final void didClickItem(PostInGridCell postInGridCell3, int i2, RubinoPostObject rubinoPostObject, int i3) {
                        this.f$0.lambda$onCreateViewHolder$0(postInGridCell3, i2, rubinoPostObject, i3);
                    }
                });
                ((ArrayList) RubinoPostGridLayout.this.caches.get(this.tabIndex)).add(postInGridCell2);
            } else {
                postInGridCell = new RubinoLoadingCell(this.mContext, false);
            }
            postInGridCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListViewEdited.Holder(postInGridCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ArrayList<RubinoPostObject> arrayList = RubinoPostGridLayout.this.postArrayInfo[this.tabIndex].posts;
                PostInGridCell postInGridCell = (PostInGridCell) viewHolder.itemView;
                postInGridCell.setItemsCount(RubinoPostGridLayout.this.columnsCount);
                postInGridCell.setIsFirst(i == 0);
                for (int i2 = 0; i2 < RubinoPostGridLayout.this.columnsCount; i2++) {
                    int i3 = (RubinoPostGridLayout.this.columnsCount * i) + i2;
                    if (i3 < arrayList.size()) {
                        RubinoPostObject rubinoPostObject = arrayList.get(i3);
                        postInGridCell.setItem(i2, RubinoPostGridLayout.this.postArrayInfo[this.tabIndex].posts.indexOf(rubinoPostObject), rubinoPostObject);
                    } else {
                        postInGridCell.setItem(i2, i3, null);
                    }
                }
                postInGridCell.requestLayout();
            }
            if (RubinoPostGridLayout.this.postArrayInfo[this.tabIndex].endReached || RubinoPostGridLayout.this.postArrayInfo[this.tabIndex].loading || i * RubinoPostGridLayout.this.columnsCount <= RubinoPostGridLayout.this.postArrayInfo[this.tabIndex].posts.size() - 24) {
                return;
            }
            RubinoPostGridLayout.this.loadPosts(this.tabIndex);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return ((double) i) < Math.ceil((double) (((float) RubinoPostGridLayout.this.postArrayInfo[this.tabIndex].posts.size()) / ((float) RubinoPostGridLayout.this.columnsCount))) ? 0 : 1;
        }
    }
}
