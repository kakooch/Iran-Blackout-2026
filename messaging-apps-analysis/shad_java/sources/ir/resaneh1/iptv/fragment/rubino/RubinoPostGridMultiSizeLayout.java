package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoPostPosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Size;

/* loaded from: classes3.dex */
public class RubinoPostGridMultiSizeLayout extends FrameLayout {
    private ActionBar actionBar;
    private boolean backAnimation;
    private final int classGuid;
    int currentAccount;
    ExplorePostGridCell.SharedPhotoVideoCellDelegate delegate;
    private RubinoEmptyView emptyView;
    private boolean hasTopSection;
    private String hashtag;
    RecyclerView.LayoutManager headerLayoutManager;
    public HorizontalListAdapter headerListAdapter;
    RecyclerListViewEdited headerListView;
    private boolean isStopRefresh;
    private long lastManualRefreshTime;
    private long lastUpdatedTime;
    private ExtendedGridLayoutManager layoutManager;
    private FrameLayout listContainer;
    private RecyclerListViewEdited listView;
    private Context mContext;
    private int maximumVelocity;
    private boolean maybeStartTracking;
    private final int[] oldItemCounts;
    private RubinoPostGridActivity parentActivity;
    private SharedPhotoVideoAdapter photoVideoAdapter;
    private Drawable pinnedHeaderShadowDrawable;
    private final PostArrayData postArrayInfo;
    private View progressBar;
    private LinearLayout progressView;
    private RefreshListener refreshListener;
    private boolean scrolling;
    private View shadowLine;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private Rubino.ExploreTopicObject topicObject;
    private final int type;
    private VelocityTracker velocityTracker;
    public static int exploreType = 0;
    public static int hashtagType = 1;
    public static int bookmarkType = 2;

    public interface RefreshListener {
        void onRefreshEnd();

        void onRefreshError();
    }

    public boolean checkTabsAnimationInProgress() {
        return false;
    }

    public void onDestroy() {
    }

    public class PostArrayData {
        public DisposableObserver fakeObserver;
        public DisposableObserver loadPostsObserver;
        public DisposableObserver refreshPostsObserver;
        public ArrayList<RubinoPostObject> posts = new ArrayList<>();
        public Map<String, RubinoPostObject> postMap = new HashMap();
        public boolean loading = true;
        public boolean endReached = false;
        public String startId = null;
        public String maxId = null;

        public PostArrayData(RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout) {
        }

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

    public void scrollToTop() {
        this.listView.scrollToPosition(0);
    }

    public RubinoPostGridMultiSizeLayout(Context context, RubinoPostGridActivity rubinoPostGridActivity, Rubino.ExploreTopicObject exploreTopicObject, boolean z, int i) throws Resources.NotFoundException {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        new Paint();
        this.oldItemCounts = new int[]{0, 0, 0};
        this.hasTopSection = true;
        this.delegate = new ExplorePostGridCell.SharedPhotoVideoCellDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.9
            @Override // ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell.SharedPhotoVideoCellDelegate
            public boolean didLongPressedItem(ExplorePostGridCell explorePostGridCell, RubinoPostObject rubinoPostObject, int i2, int i3) {
                return false;
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell.SharedPhotoVideoCellDelegate
            public void didClickItem(ExplorePostGridCell explorePostGridCell, RubinoPostObject rubinoPostObject, int i2, int i3) {
                if (ApplicationLoader.applicationActivity != null) {
                    if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.exploreType) {
                        RubinoPostGridMultiSizeLayout.this.isStopRefresh = true;
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(rubinoPostObject, new RubinoPostPosition(i2, i3)));
                    } else if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.hashtagType) {
                        if (RubinoPostGridMultiSizeLayout.this.hashtag != null) {
                            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(RubinoPostGridMultiSizeLayout.this.hashtag.replace("#", BuildConfig.FLAVOR), RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts, RubinoPostGridMultiSizeLayout.this.postArrayInfo.postMap, RubinoPostGridMultiSizeLayout.this.postArrayInfo.startId, !RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.indexOf(rubinoPostObject)));
                        }
                    } else if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.bookmarkType) {
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(RubinoPostListActivity.bookmarkPostListType, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts, RubinoPostGridMultiSizeLayout.this.postArrayInfo.postMap, RubinoPostGridMultiSizeLayout.this.postArrayInfo.maxId, !RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.indexOf(rubinoPostObject)));
                    }
                }
            }
        };
        this.type = exploreType;
        this.topicObject = exploreTopicObject;
        this.postArrayInfo = new PostArrayData(this);
        this.hasTopSection = z;
        this.classGuid = i;
        init(context, rubinoPostGridActivity);
    }

    public RubinoPostGridMultiSizeLayout(Context context, RubinoPostGridActivity rubinoPostGridActivity, String str, int i) throws Resources.NotFoundException {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        new Paint();
        this.oldItemCounts = new int[]{0, 0, 0};
        this.hasTopSection = true;
        this.delegate = new ExplorePostGridCell.SharedPhotoVideoCellDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.9
            @Override // ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell.SharedPhotoVideoCellDelegate
            public boolean didLongPressedItem(ExplorePostGridCell explorePostGridCell, RubinoPostObject rubinoPostObject, int i2, int i3) {
                return false;
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell.SharedPhotoVideoCellDelegate
            public void didClickItem(ExplorePostGridCell explorePostGridCell, RubinoPostObject rubinoPostObject, int i2, int i3) {
                if (ApplicationLoader.applicationActivity != null) {
                    if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.exploreType) {
                        RubinoPostGridMultiSizeLayout.this.isStopRefresh = true;
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(rubinoPostObject, new RubinoPostPosition(i2, i3)));
                    } else if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.hashtagType) {
                        if (RubinoPostGridMultiSizeLayout.this.hashtag != null) {
                            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(RubinoPostGridMultiSizeLayout.this.hashtag.replace("#", BuildConfig.FLAVOR), RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts, RubinoPostGridMultiSizeLayout.this.postArrayInfo.postMap, RubinoPostGridMultiSizeLayout.this.postArrayInfo.startId, !RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.indexOf(rubinoPostObject)));
                        }
                    } else if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.bookmarkType) {
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(RubinoPostListActivity.bookmarkPostListType, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts, RubinoPostGridMultiSizeLayout.this.postArrayInfo.postMap, RubinoPostGridMultiSizeLayout.this.postArrayInfo.maxId, !RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.indexOf(rubinoPostObject)));
                    }
                }
            }
        };
        this.hashtag = str;
        this.type = hashtagType;
        this.postArrayInfo = new PostArrayData(this);
        this.hasTopSection = false;
        this.classGuid = i;
        init(context, rubinoPostGridActivity);
    }

    public RubinoPostGridMultiSizeLayout(Context context, RubinoPostGridActivity rubinoPostGridActivity, int i, int i2) throws Resources.NotFoundException {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        new Paint();
        this.oldItemCounts = new int[]{0, 0, 0};
        this.hasTopSection = true;
        this.delegate = new ExplorePostGridCell.SharedPhotoVideoCellDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.9
            @Override // ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell.SharedPhotoVideoCellDelegate
            public boolean didLongPressedItem(ExplorePostGridCell explorePostGridCell, RubinoPostObject rubinoPostObject, int i22, int i3) {
                return false;
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell.SharedPhotoVideoCellDelegate
            public void didClickItem(ExplorePostGridCell explorePostGridCell, RubinoPostObject rubinoPostObject, int i22, int i3) {
                if (ApplicationLoader.applicationActivity != null) {
                    if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.exploreType) {
                        RubinoPostGridMultiSizeLayout.this.isStopRefresh = true;
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(rubinoPostObject, new RubinoPostPosition(i22, i3)));
                    } else if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.hashtagType) {
                        if (RubinoPostGridMultiSizeLayout.this.hashtag != null) {
                            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(RubinoPostGridMultiSizeLayout.this.hashtag.replace("#", BuildConfig.FLAVOR), RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts, RubinoPostGridMultiSizeLayout.this.postArrayInfo.postMap, RubinoPostGridMultiSizeLayout.this.postArrayInfo.startId, !RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.indexOf(rubinoPostObject)));
                        }
                    } else if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.bookmarkType) {
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(RubinoPostListActivity.bookmarkPostListType, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts, RubinoPostGridMultiSizeLayout.this.postArrayInfo.postMap, RubinoPostGridMultiSizeLayout.this.postArrayInfo.maxId, !RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached, RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.indexOf(rubinoPostObject)));
                    }
                }
            }
        };
        this.type = i;
        this.postArrayInfo = new PostArrayData(this);
        this.hasTopSection = false;
        this.classGuid = i2;
        init(context, rubinoPostGridActivity);
    }

    private void init(Context context, RubinoPostGridActivity rubinoPostGridActivity) throws Resources.NotFoundException {
        int iFindFirstVisibleItemPosition;
        int top;
        String string;
        RecyclerListViewEdited.Holder holder;
        this.parentActivity = rubinoPostGridActivity;
        this.mContext = context;
        this.actionBar = rubinoPostGridActivity.getActionBar();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        Drawable drawable = context.getResources().getDrawable(R.drawable.photos_header_shadow);
        this.pinnedHeaderShadowDrawable = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundGrayShadow), PorterDuff.Mode.MULTIPLY));
        this.photoVideoAdapter = new SharedPhotoVideoAdapter(context, 0);
        setWillNotDraw(false);
        ExtendedGridLayoutManager extendedGridLayoutManager = this.layoutManager;
        if (extendedGridLayoutManager == null || (iFindFirstVisibleItemPosition = extendedGridLayoutManager.findFirstVisibleItemPosition()) == this.layoutManager.getItemCount() - 1 || (holder = (RecyclerListViewEdited.Holder) this.listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) == null) {
            iFindFirstVisibleItemPosition = -1;
            top = 0;
        } else {
            top = holder.itemView.getTop();
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.listContainer = frameLayout;
        addView(frameLayout, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, this.hasTopSection ? 39.0f : 0.0f, 0.0f, 0.0f));
        ExtendedGridLayoutManager extendedGridLayoutManager2 = new ExtendedGridLayoutManager(this, context, 100) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.1
            @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            {
                new Size();
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
                super.calculateExtraLayoutSpace(state, iArr);
                iArr[1] = Math.max(iArr[1], PostInGridCell.getItemSize(3) * 2);
            }
        };
        this.layoutManager = extendedGridLayoutManager2;
        extendedGridLayoutManager2.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                return RubinoPostGridMultiSizeLayout.this.layoutManager.getSpanCount();
            }
        });
        RecyclerListViewEdited recyclerListViewEdited = new RecyclerListViewEdited(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.3
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout = RubinoPostGridMultiSizeLayout.this;
                rubinoPostGridMultiSizeLayout.checkLoadMoreScroll(rubinoPostGridMultiSizeLayout.listView, RubinoPostGridMultiSizeLayout.this.layoutManager);
            }
        };
        this.listView = recyclerListViewEdited;
        recyclerListViewEdited.setScrollingTouchSlop(1);
        this.listView.setPinnedSectionOffsetY(-AndroidUtilities.dp(2.0f));
        this.listView.setItemAnimator(null);
        this.listView.setClipToPadding(false);
        this.listView.setSectionsType(2);
        this.listView.setLayoutManager(this.layoutManager);
        this.listContainer.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView = new RubinoEmptyView(this.mContext, 1);
        int i = R.drawable.rubino_empty_post_camera;
        int i2 = this.type;
        int i3 = exploreType;
        String string2 = BuildConfig.FLAVOR;
        if (i2 == i3 || i2 == hashtagType) {
            string2 = LocaleController.getString(R.string.rubinoNoPosts);
            string = BuildConfig.FLAVOR;
        } else if (i2 == bookmarkType) {
            string2 = LocaleController.getString(R.string.rubinoNoBookmark);
            string = LocaleController.getString(R.string.rubinoNoBookmarkInfo);
            i = R.drawable.rubino_empty_state_save;
        } else {
            string = BuildConfig.FLAVOR;
        }
        this.emptyView.setData(i, string2, string);
        this.listContainer.addView(this.emptyView, LayoutHelper.createFrame(-1, -2, 17));
        this.listView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.4
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.left = 0;
                rect.top = 0;
                rect.bottom = 0;
                rect.right = 0;
            }
        });
        this.listView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                RubinoPostGridMultiSizeLayout.this.scrolling = i4 != 0;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout = RubinoPostGridMultiSizeLayout.this;
                rubinoPostGridMultiSizeLayout.checkLoadMoreScroll(recyclerView, rubinoPostGridMultiSizeLayout.layoutManager);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListViewEdited.OnItemLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemLongClickListener
            public final boolean onItemClick(View view, int i4) {
                return RubinoPostGridMultiSizeLayout.lambda$init$1(view, i4);
            }
        });
        if (iFindFirstVisibleItemPosition != -1) {
            this.layoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.progressView = linearLayout;
        linearLayout.setWillNotDraw(false);
        this.progressView.setGravity(17);
        this.progressView.setOrientation(1);
        this.progressView.setVisibility(8);
        this.listContainer.addView(this.progressView, LayoutHelper.createFrame(-1, -1.0f));
        RubinoLoadingCell rubinoLoadingCell = new RubinoLoadingCell(context, false);
        this.progressBar = rubinoLoadingCell;
        this.progressView.addView(rubinoLoadingCell, LayoutHelper.createLinear(-2, -2));
        if (this.hasTopSection) {
            this.headerListView = new RecyclerListViewEdited(context);
            this.headerLayoutManager = new LinearLayoutManager(context, 0, true);
            this.headerListAdapter = new HorizontalListAdapter(context);
            this.headerListView.setLayoutManager(this.headerLayoutManager);
            this.headerListView.setAdapter(this.headerListAdapter);
            this.headerListView.setClipToPadding(false);
            this.headerListView.setClipChildren(false);
            this.headerListView.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
            int iDp = AndroidUtilities.dp(4.0f);
            this.headerListView.setPadding(iDp, iDp, iDp, AndroidUtilities.dp(2.0f));
            addView(this.headerListView, LayoutHelper.createFrame(-1, 39, 51));
            View view = new View(context);
            this.shadowLine = view;
            view.setBackgroundColor(Theme.getColor(Theme.key_rubinoGrayColor));
            this.shadowLine.setAlpha(0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
            layoutParams.topMargin = AndroidUtilities.dp(39.0f) - 1;
            addView(this.shadowLine, layoutParams);
        }
        this.listView.stopScroll();
        this.listView.setAdapter(this.photoVideoAdapter);
        this.listView.setPinnedHeaderShadowDrawable(this.pinnedHeaderShadowDrawable);
        PostArrayData postArrayData = this.postArrayInfo;
        if (!postArrayData.loading && !postArrayData.endReached && postArrayData.posts.isEmpty()) {
            this.postArrayInfo.loading = true;
        }
        PostArrayData postArrayData2 = this.postArrayInfo;
        if (postArrayData2.loading && postArrayData2.posts.isEmpty()) {
            this.progressView.setVisibility(0);
        } else {
            this.progressView.setVisibility(8);
        }
        this.emptyView.setVisibility(4);
        this.listView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$init$1(View view, int i) {
        Log.i("SEPIIII2", "setOnItemLongClickListener: ");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLoadMoreScroll(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition != -1) {
            Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition);
        }
        recyclerView.getAdapter().getItemCount();
    }

    @Override // android.view.View
    public void forceHasOverlappingRendering(boolean z) {
        super.forceHasOverlappingRendering(z);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int height = this.parentActivity.getListView().getHeight();
        if (height == 0) {
            height = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(size, height);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (childAt == this.listContainer) {
                    measureChildWithMargins(childAt, i, 0, View.MeasureSpec.makeMeasureSpec(height, 1073741824), 0);
                } else {
                    measureChildWithMargins(childAt, i, 0, i2, 0);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return checkTabsAnimationInProgress() || onTouchEvent(motionEvent);
    }

    public RecyclerListViewEdited getCurrentListView() {
        return this.listView;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setVisibleHeight(int i) {
        this.progressView.setTranslationY((-(getMeasuredHeight() - Math.max(i, AndroidUtilities.dp(120.0f)))) / 2.0f);
    }

    public void setOnRefreshListener(RefreshListener refreshListener) {
        this.refreshListener = refreshListener;
    }

    public void refresh() {
        loadPosts(true, true);
    }

    public void loadPosts(final boolean z, final boolean z2) {
        final String str;
        if (z || !this.postArrayInfo.endReached) {
            if (z) {
                DisposableObserver disposableObserver = this.postArrayInfo.refreshPostsObserver;
                if (disposableObserver != null && !disposableObserver.isDisposed()) {
                    RefreshListener refreshListener = this.refreshListener;
                    if (refreshListener != null) {
                        refreshListener.onRefreshEnd();
                        return;
                    }
                    return;
                }
                if (z2 && System.currentTimeMillis() - this.lastManualRefreshTime < 10000) {
                    DisposableObserver disposableObserver2 = this.postArrayInfo.fakeObserver;
                    if (disposableObserver2 != null && !disposableObserver2.isDisposed()) {
                        this.postArrayInfo.fakeObserver.dispose();
                    }
                    this.postArrayInfo.fakeObserver = (DisposableObserver) Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.6
                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            if (RubinoPostGridMultiSizeLayout.this.refreshListener != null) {
                                RubinoPostGridMultiSizeLayout.this.refreshListener.onRefreshEnd();
                            }
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                            dispose();
                        }

                        @Override // io.reactivex.Observer
                        public void onComplete() {
                            dispose();
                        }
                    });
                    this.parentActivity.compositeDisposable.add(this.postArrayInfo.fakeObserver);
                    return;
                }
                DisposableObserver disposableObserver3 = this.postArrayInfo.loadPostsObserver;
                if (disposableObserver3 != null && !disposableObserver3.isDisposed()) {
                    this.postArrayInfo.loadPostsObserver.dispose();
                }
            } else {
                DisposableObserver disposableObserver4 = this.postArrayInfo.loadPostsObserver;
                if (disposableObserver4 != null && !disposableObserver4.isDisposed()) {
                    return;
                }
                DisposableObserver disposableObserver5 = this.postArrayInfo.refreshPostsObserver;
                if (disposableObserver5 != null && !disposableObserver5.isDisposed()) {
                    this.postArrayInfo.refreshPostsObserver.dispose();
                    RefreshListener refreshListener2 = this.refreshListener;
                    if (refreshListener2 != null) {
                        refreshListener2.onRefreshEnd();
                    }
                }
            }
            DisposableObserver disposableObserver6 = this.postArrayInfo.fakeObserver;
            if (disposableObserver6 != null && !disposableObserver6.isDisposed()) {
                this.postArrayInfo.fakeObserver.dispose();
            }
            int i = this.type;
            Observable<Rubino.PostObjectList> bookmarkPostsObservable = null;
            if (i == exploreType) {
                str = this.postArrayInfo.startId;
                RubinoController rubinoController = RubinoController.getInstance(this.currentAccount);
                Rubino.ExploreTopicObject exploreTopicObject = this.topicObject;
                bookmarkPostsObservable = rubinoController.getExplorePostsObservable(exploreTopicObject != null ? exploreTopicObject.id : null, z ? null : str, 51);
            } else if (i == hashtagType) {
                str = this.postArrayInfo.startId;
                RubinoController rubinoController2 = RubinoController.getInstance(this.currentAccount);
                String str2 = this.hashtag;
                bookmarkPostsObservable = rubinoController2.getHashtagPostsObservable(str2 != null ? str2.replace("#", BuildConfig.FLAVOR) : null, z ? null : str, 51);
            } else if (i == bookmarkType) {
                str = null;
                bookmarkPostsObservable = RubinoController.getInstance(this.currentAccount).getBookmarkPostsObservable(z ? null : this.postArrayInfo.maxId, 51);
            } else {
                str = null;
            }
            if (bookmarkPostsObservable != null) {
                DisposableObserver disposableObserver7 = (DisposableObserver) bookmarkPostsObservable.delay(z ? 400L : 10L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.PostObjectList>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.7
                    @Override // io.reactivex.Observer
                    public void onNext(Rubino.PostObjectList postObjectList) {
                        if (z && RubinoPostGridMultiSizeLayout.this.refreshListener != null) {
                            RubinoPostGridMultiSizeLayout.this.refreshListener.onRefreshEnd();
                        }
                        if (z || str == null) {
                            RubinoPostGridMultiSizeLayout.this.lastUpdatedTime = System.currentTimeMillis();
                        }
                        if (z && z2) {
                            RubinoPostGridMultiSizeLayout.this.lastManualRefreshTime = System.currentTimeMillis();
                        }
                        RubinoPostGridMultiSizeLayout.this.postArrayInfo.loading = false;
                        if (RubinoPostGridMultiSizeLayout.this.progressView != null) {
                            RubinoPostGridMultiSizeLayout.this.progressView.setVisibility(8);
                        }
                        if (RubinoPostGridMultiSizeLayout.this.listView.getAdapter() != null) {
                            RubinoPostGridMultiSizeLayout.this.oldItemCounts[0] = RubinoPostGridMultiSizeLayout.this.listView.getAdapter().getItemCount();
                        }
                        if (postObjectList != null) {
                            RubinoPostGridMultiSizeLayout.this.postArrayInfo.startId = postObjectList.nextStartId;
                            ArrayList<RubinoPostObject> arrayList = postObjectList.posts;
                            if (arrayList != null && arrayList.size() > 0) {
                                PostArrayData postArrayData = RubinoPostGridMultiSizeLayout.this.postArrayInfo;
                                ArrayList<RubinoPostObject> arrayList2 = postObjectList.posts;
                                postArrayData.maxId = arrayList2.get(arrayList2.size() - 1).post.id;
                            }
                            if (postObjectList.posts != null) {
                                RubinoPostGridMultiSizeLayout.this.postArrayInfo.addPosts(postObjectList.posts, z);
                                RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached = postObjectList.posts.size() <= 0;
                                if (RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.size() == 0) {
                                    RubinoPostGridMultiSizeLayout.this.emptyView.setVisibility(0);
                                } else {
                                    RubinoPostGridMultiSizeLayout.this.emptyView.setVisibility(8);
                                }
                                if (z) {
                                    RubinoPostGridMultiSizeLayout.this.listView.getAdapter().notifyDataSetChanged();
                                } else {
                                    RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout = RubinoPostGridMultiSizeLayout.this;
                                    rubinoPostGridMultiSizeLayout.refreshAdaptersAndUpdateUI((SharedPhotoVideoAdapter) rubinoPostGridMultiSizeLayout.listView.getAdapter(), RubinoPostGridMultiSizeLayout.this.oldItemCounts[0], 0);
                                }
                            }
                        } else {
                            RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached = true;
                            if (z) {
                                if (RubinoPostGridMultiSizeLayout.this.listView.getAdapter() != null) {
                                    RubinoPostGridMultiSizeLayout.this.listView.getAdapter().notifyDataSetChanged();
                                }
                            } else {
                                RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout2 = RubinoPostGridMultiSizeLayout.this;
                                rubinoPostGridMultiSizeLayout2.refreshAdaptersAndUpdateUI((SharedPhotoVideoAdapter) rubinoPostGridMultiSizeLayout2.listView.getAdapter(), RubinoPostGridMultiSizeLayout.this.oldItemCounts[0], 0);
                            }
                        }
                        if (RubinoPostGridMultiSizeLayout.this.type == RubinoPostGridMultiSizeLayout.hashtagType) {
                            RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached = true ^ postObjectList.hasContinue;
                            RubinoPostGridMultiSizeLayout.this.postArrayInfo.startId = postObjectList.nextStartId;
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        if (z && RubinoPostGridMultiSizeLayout.this.refreshListener != null) {
                            RubinoPostGridMultiSizeLayout.this.refreshListener.onRefreshError();
                        }
                        dispose();
                    }

                    @Override // io.reactivex.Observer
                    public void onComplete() {
                        dispose();
                    }
                });
                if (z) {
                    this.postArrayInfo.refreshPostsObserver = disposableObserver7;
                } else {
                    this.postArrayInfo.loadPostsObserver = disposableObserver7;
                }
                this.parentActivity.compositeDisposable.add(disposableObserver7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAdaptersAndUpdateUI(SharedPhotoVideoAdapter sharedPhotoVideoAdapter, int i, int i2) {
        LinearLayout linearLayout;
        if (this.listView.getAdapter() == sharedPhotoVideoAdapter) {
            this.listView.stopScroll();
        }
        int itemCount = sharedPhotoVideoAdapter.getItemCount();
        if (i > 1) {
            sharedPhotoVideoAdapter.notifyItemRangeChanged(i - 2, 2);
        }
        if (itemCount > i) {
            sharedPhotoVideoAdapter.notifyItemRangeInserted(i, itemCount);
        } else if (itemCount < i) {
            sharedPhotoVideoAdapter.notifyItemRangeRemoved(itemCount, i - itemCount);
        }
        if (!this.postArrayInfo.loading && (linearLayout = this.progressView) != null) {
            linearLayout.setVisibility(8);
        }
        this.parentActivity.setAutoPlayRunnable();
    }

    public void onResume() {
        SharedPhotoVideoAdapter sharedPhotoVideoAdapter = this.photoVideoAdapter;
        if (sharedPhotoVideoAdapter != null) {
            sharedPhotoVideoAdapter.notifyDataSetChanged();
        }
        fixLayoutInternal();
        if (!this.isStopRefresh && System.currentTimeMillis() - this.lastUpdatedTime > 300000) {
            loadPosts(true, false);
        }
        this.isStopRefresh = false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecyclerListViewEdited recyclerListViewEdited = this.listView;
        if (recyclerListViewEdited != null) {
            recyclerListViewEdited.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.8
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    RubinoPostGridMultiSizeLayout.this.listContainer.getViewTreeObserver().removeOnPreDrawListener(this);
                    RubinoPostGridMultiSizeLayout.this.fixLayoutInternal();
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal() {
        SharedPhotoVideoAdapter sharedPhotoVideoAdapter = this.photoVideoAdapter;
        if (sharedPhotoVideoAdapter != null) {
            sharedPhotoVideoAdapter.notifyDataSetChanged();
        }
    }

    private class SharedPhotoVideoAdapter extends RecyclerListViewEdited.SelectionAdapter {
        private final Context mContext;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public SharedPhotoVideoAdapter(Context context, int i) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int iCeil = (int) Math.ceil(RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.size() / 3.0f);
            return (iCeil == 0 || RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached) ? iCeil : iCeil + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout rubinoLoadingCell;
            if (i == 0) {
                ThreePostOneBigView threePostOneBigView = new ThreePostOneBigView(this.mContext, RubinoPostGridMultiSizeLayout.this.classGuid);
                threePostOneBigView.setDelegate(RubinoPostGridMultiSizeLayout.this.delegate);
                rubinoLoadingCell = threePostOneBigView;
            } else if (i == 1) {
                ThreePostSmallView threePostSmallView = new ThreePostSmallView(this.mContext);
                threePostSmallView.setDelegate(RubinoPostGridMultiSizeLayout.this.delegate);
                rubinoLoadingCell = threePostSmallView;
            } else {
                rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
            }
            rubinoLoadingCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int size = RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.size();
            int i2 = i * 3;
            if (i2 < size) {
                if (viewHolder.getItemViewType() == 0) {
                    int i3 = i2 + 1;
                    int i4 = i2 + 2;
                    ((ThreePostOneBigView) viewHolder.itemView).setData(RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i2), i3 < size ? RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i3) : null, i4 < size ? RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i4) : null, i);
                } else if (viewHolder.getItemViewType() == 1) {
                    int i5 = i2 + 1;
                    int i6 = i2 + 2;
                    ((ThreePostSmallView) viewHolder.itemView).setData(RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i2), i5 < size ? RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i5) : null, i6 < size ? RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i6) : null, i);
                }
            }
            if (RubinoPostGridMultiSizeLayout.this.postArrayInfo.endReached || RubinoPostGridMultiSizeLayout.this.postArrayInfo.loading || i2 <= RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.size() - 24) {
                return;
            }
            RubinoPostGridMultiSizeLayout.this.loadPosts(false, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            int i2;
            int i3;
            if (i >= Math.ceil(RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.size() / 3.0f)) {
                return 2;
            }
            int i4 = i * 3;
            int size = RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.size();
            int i5 = 0;
            if (i4 < size && (RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i4).post.size == 2 || (((i2 = i4 + 1) < size && RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i2).post.size == 2) || ((i3 = i4 + 2) < size && RubinoPostGridMultiSizeLayout.this.postArrayInfo.posts.get(i3).post.size == 2)))) {
                i5 = 1;
            }
            return i5 ^ 1;
        }
    }

    public static class HorizontalListAdapter extends RecyclerListViewEdited.SelectionAdapter {
        Context context;
        ArrayList<Rubino.ExploreTopicObject> topics = new ArrayList<>();
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.HorizontalListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostGridActivity(((ExploreTopicCell) view).topicObject, false));
                }
            }
        };

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        HorizontalListAdapter(Context context) {
            this.context = context;
        }

        public void setTopics(ArrayList<Rubino.ExploreTopicObject> arrayList) {
            this.topics.clear();
            this.topics.addAll(arrayList);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ExploreTopicCell exploreTopicCell = new ExploreTopicCell(this.context);
            exploreTopicCell.setLayoutParams(LayoutHelper.createFrame(-2, 27.0f, 17, 4.0f, 2.0f, 4.0f, 2.0f));
            exploreTopicCell.setOnClickListener(this.onClickListener);
            return new RecyclerListViewEdited.Holder(exploreTopicCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (!(viewHolder.itemView instanceof ExploreTopicCell) || i >= this.topics.size()) {
                return;
            }
            ((ExploreTopicCell) viewHolder.itemView).setTopicObject(this.topics.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.topics.size();
        }
    }
}
