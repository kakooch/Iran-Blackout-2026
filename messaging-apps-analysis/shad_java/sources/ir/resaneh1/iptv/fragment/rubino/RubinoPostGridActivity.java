package ir.resaneh1.iptv.fragment.rubino;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.ExploreSearchView;
import ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer;
import ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.Rubino;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoPostGridActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    public static int bookmarkType = 2;
    public static int exploreType = 0;
    public static int hashtagType = 1;
    Runnable autoPlayRunnable;
    private int bottomPaddingRow;
    private boolean gridLayoutAttached;
    private int gridRow;
    private boolean hasTopSection;
    private String hashtag;
    private int headerViewRow;
    private boolean isInLandscapeMode;
    private boolean isTouchedAfterResume;
    private int lastMeasuredContentHeight;
    private int lastMeasuredContentWidth;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private int listContentHeight;
    private RecyclerListViewEdited listView;
    private int loadingRow;
    private boolean needToRetry;
    PullToRefreshLayout.OnRefreshListener onRefreshListener;
    private RubinoPostGridMultiSizeLayout postGridLayout;
    private int retryRow;
    private int rowCount;
    private PullToRefreshLayout swipeRefreshLayout;
    private boolean topicInited;
    private Rubino.ExploreTopicObject topicObject;
    private final int type;

    private boolean processOnClickOrPress(int i) {
        return false;
    }

    static /* synthetic */ int access$1012(RubinoPostGridActivity rubinoPostGridActivity, int i) {
        int i2 = rubinoPostGridActivity.listContentHeight + i;
        rubinoPostGridActivity.listContentHeight = i2;
        return i2;
    }

    public void scrollToTop() {
        this.postGridLayout.scrollToTop();
    }

    private class NestedFrameLayout extends FrameLayout implements NestedScrollingParent3 {
        private final NestedScrollingParentHelper nestedScrollingParentHelper;

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onStopNestedScroll(View view) {
        }

        public NestedFrameLayout(Context context) {
            super(context);
            this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        }

        @Override // androidx.core.view.NestedScrollingParent3
        public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (view == RubinoPostGridActivity.this.listView && RubinoPostGridActivity.this.gridLayoutAttached) {
                RecyclerListViewEdited currentListView = RubinoPostGridActivity.this.postGridLayout.getCurrentListView();
                if (RubinoPostGridActivity.this.postGridLayout.getTop() == 0) {
                    iArr[1] = i4;
                    currentListView.scrollBy(0, i4);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public boolean onNestedPreFling(View view, float f, float f2) {
            return super.onNestedPreFling(view, f, f2);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
            if (view == RubinoPostGridActivity.this.listView) {
                if (RubinoPostGridActivity.this.gridRow == -1 || !RubinoPostGridActivity.this.gridLayoutAttached) {
                    return;
                }
                boolean zIsSearchFieldVisible = ((BaseFragment) RubinoPostGridActivity.this).actionBar.isSearchFieldVisible();
                int top = RubinoPostGridActivity.this.postGridLayout.getTop();
                boolean z = false;
                if (i2 >= 0) {
                    if (zIsSearchFieldVisible) {
                        RecyclerListViewEdited currentListView = RubinoPostGridActivity.this.postGridLayout.getCurrentListView();
                        iArr[1] = i2;
                        if (top > 0) {
                            iArr[1] = iArr[1] - Math.min(iArr[1], i2);
                        }
                        if (iArr[1] > 0) {
                            currentListView.scrollBy(0, iArr[1]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (top <= 0) {
                    RecyclerListViewEdited currentListView2 = RubinoPostGridActivity.this.postGridLayout.getCurrentListView();
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) currentListView2.getLayoutManager()).findFirstVisibleItemPosition();
                    if (iFindFirstVisibleItemPosition != -1) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = currentListView2.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                        int top2 = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView.getTop() : -1;
                        int paddingTop = currentListView2.getPaddingTop();
                        if (top2 != paddingTop || iFindFirstVisibleItemPosition != 0) {
                            iArr[1] = iFindFirstVisibleItemPosition != 0 ? i2 : Math.max(i2, top2 - paddingTop);
                            currentListView2.scrollBy(0, i2);
                            z = true;
                        }
                    }
                }
                if (zIsSearchFieldVisible) {
                    if (!z && top < 0) {
                        iArr[1] = i2 - Math.max(top, i2);
                    } else {
                        iArr[1] = i2;
                    }
                }
            }
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
            return RubinoPostGridActivity.this.gridRow != -1 && i == 2;
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
            this.nestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onStopNestedScroll(View view, int i) {
            this.nestedScrollingParentHelper.onStopNestedScroll(view);
        }
    }

    public RubinoPostGridActivity(Rubino.ExploreTopicObject exploreTopicObject, boolean z) {
        new Rect();
        this.isTouchedAfterResume = false;
        this.hasTopSection = true;
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playVideoInListIfNeeded();
            }
        };
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.9
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (RubinoPostGridActivity.this.postGridLayout != null) {
                    RubinoPostGridActivity.this.postGridLayout.refresh();
                }
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z2) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoPostGridActivity.this.postGridLayout.getCurrentListView(), z2);
            }
        };
        this.type = exploreType;
        initFragmentParams();
        this.topicObject = exploreTopicObject;
        this.hasTopSection = z;
    }

    public RubinoPostGridActivity(String str) {
        new Rect();
        this.isTouchedAfterResume = false;
        this.hasTopSection = true;
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playVideoInListIfNeeded();
            }
        };
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.9
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (RubinoPostGridActivity.this.postGridLayout != null) {
                    RubinoPostGridActivity.this.postGridLayout.refresh();
                }
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z2) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoPostGridActivity.this.postGridLayout.getCurrentListView(), z2);
            }
        };
        this.hashtag = str;
        this.hasTopSection = false;
        this.type = hashtagType;
        initFragmentParams();
    }

    public RubinoPostGridActivity(int i) {
        new Rect();
        this.isTouchedAfterResume = false;
        this.hasTopSection = true;
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playVideoInListIfNeeded();
            }
        };
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.9
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (RubinoPostGridActivity.this.postGridLayout != null) {
                    RubinoPostGridActivity.this.postGridLayout.refresh();
                }
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z2) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoPostGridActivity.this.postGridLayout.getCurrentListView(), z2);
            }
        };
        this.hasTopSection = false;
        this.type = i;
        initFragmentParams();
    }

    public void initFragmentParams() {
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoPostGridActivity" + this.type;
        this.isSmallActionBar = true;
        this.swipeBackEnabled = true;
        this.needLockOrientation = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoExploreTopicsUpdated);
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoExploreTopicsUpdated);
        releaseExistingCachedPlayers();
        super.onFragmentDestroy();
        RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout = this.postGridLayout;
        if (rubinoPostGridMultiSizeLayout != null) {
            rubinoPostGridMultiSizeLayout.onDestroy();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.rubinoExploreTopicsUpdated) {
            updateTopicsIfNeeded();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        String str;
        if (this.hasTopSection) {
            return super.createActionBar(context);
        }
        ActionBar actionBar = new ActionBar(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return super.onTouchEvent(motionEvent);
            }
        };
        actionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBar.setCastShadows(false);
        actionBar.setAddToContainer(false);
        actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        actionBar.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon), true);
        actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    RubinoPostGridActivity.this.finishFragment();
                }
            }
        });
        int i = this.type;
        int i2 = exploreType;
        String str2 = BuildConfig.FLAVOR;
        if (i == i2) {
            Rubino.ExploreTopicObject exploreTopicObject = this.topicObject;
            if (exploreTopicObject != null && (str = exploreTopicObject.topic) != null) {
                str2 = str;
            }
            actionBar.setTitle(str2);
        } else if (i == hashtagType) {
            if (this.hashtag != null) {
                str2 = "#" + this.hashtag;
            }
            actionBar.setTitle(str2);
        } else if (i == bookmarkType) {
            actionBar.setTitle(LocaleController.getString(R.string.rubinoBookmark));
        }
        actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceMedium());
        actionBar.setOccupyStatusBar(false);
        return actionBar;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        Theme.createProfileResources(context);
        this.hasOwnBackground = true;
        int i = this.type;
        if (i == exploreType) {
            this.postGridLayout = new RubinoPostGridMultiSizeLayout(context, this, this.topicObject, this.hasTopSection, this.classGuid);
        } else if (i == hashtagType) {
            this.postGridLayout = new RubinoPostGridMultiSizeLayout(context, this, this.hashtag, this.classGuid);
        } else if (i == bookmarkType) {
            this.postGridLayout = new RubinoPostGridMultiSizeLayout(context, this, RubinoPostGridMultiSizeLayout.bookmarkType, this.classGuid);
        }
        this.postGridLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        this.listAdapter = new ListAdapter(context);
        NestedFrameLayout nestedFrameLayout = new NestedFrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.3
            private boolean firstLayout = true;
            private boolean ignoreLayout;

            @Override // android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:55:0x016b  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0184  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x0195  */
            /* JADX WARN: Removed duplicated region for block: B:69:0x01a7  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x01b2  */
            @Override // android.widget.FrameLayout, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onMeasure(int r12, int r13) {
                /*
                    Method dump skipped, instructions count: 481
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.AnonymousClass3.onMeasure(int, int):void");
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                super.onLayout(z, i2, i3, i4, i5);
                this.firstLayout = false;
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.fragmentView = nestedFrameLayout;
        NestedFrameLayout nestedFrameLayout2 = nestedFrameLayout;
        nestedFrameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        RecyclerListViewEdited recyclerListViewEdited = new RecyclerListViewEdited(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.4
            private final Paint paint = new Paint();
            private VelocityTracker velocityTracker;

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited
            protected boolean allowSelectChildAtPosition(View view) {
                return false;
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited, android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            public void onDraw(Canvas canvas) {
                int unused = RubinoPostGridActivity.this.gridRow;
                int measuredHeight = getMeasuredHeight();
                this.paint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), measuredHeight, this.paint);
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                VelocityTracker velocityTracker;
                int action = motionEvent.getAction();
                RubinoPostGridActivity.this.isTouchedAfterResume = true;
                if (action == 0) {
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    if (velocityTracker2 == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.velocityTracker.addMovement(motionEvent);
                } else if (action == 2) {
                    VelocityTracker velocityTracker3 = this.velocityTracker;
                    if (velocityTracker3 != null) {
                        velocityTracker3.addMovement(motionEvent);
                        this.velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE);
                    }
                } else if ((action == 1 || action == 3) && (velocityTracker = this.velocityTracker) != null) {
                    velocityTracker.recycle();
                    this.velocityTracker = null;
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        this.listView = recyclerListViewEdited;
        recyclerListViewEdited.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setClipToPadding(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.5
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
                if (RubinoPostGridActivity.this.isTouchedAfterResume) {
                    return super.scrollVerticallyBy(i2, recycler, state);
                }
                return 0;
            }
        };
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.listView.setLayoutManager(this.layoutManager);
        PullToRefreshLayout pullToRefreshLayout = new PullToRefreshLayout(context);
        this.swipeRefreshLayout = pullToRefreshLayout;
        nestedFrameLayout2.addView(pullToRefreshLayout, LayoutHelper.createFrame(-1, -1, 51));
        if (!this.hasTopSection) {
            this.swipeRefreshLayout.bindListViewToLayout(this.listView, this.postGridLayout.getCurrentListView());
        } else {
            this.swipeRefreshLayout.bindListViewToLayout(this.listView);
        }
        this.listView.setAdapter(this.listAdapter);
        nestedFrameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setOnItemClickListener(new RecyclerListViewEdited.OnItemClickListenerExtended() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemClickListenerExtended
            public final void onItemClick(View view, int i2, float f, float f2) {
                this.f$0.lambda$createView$0(view, i2, f, f2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListViewEdited.OnItemLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity$$ExternalSyntheticLambda1
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemLongClickListener
            public final boolean onItemClick(View view, int i2) {
                return this.f$0.lambda$createView$1(view, i2);
            }
        });
        if (!this.hasTopSection) {
            nestedFrameLayout2.addView(this.actionBar);
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            try {
                listAdapter.notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }
        needLayout();
        this.listView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 1) {
                    AndroidUtilities.hideKeyboard(RubinoPostGridActivity.this.getParentActivity().getCurrentFocus());
                }
                if (i2 == 0) {
                    RubinoPostGridActivity.this.playVideoInListIfNeeded();
                    RubinoPostGridActivity.this.releaseExistingCachedPlayers();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                RubinoPostGridActivity.this.checkListViewScroll();
            }
        });
        this.listView.setBackgroundColor(context.getResources().getColor(R.color.grey_50));
        this.compositeDisposable.add((Disposable) Observable.just(1).delay(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.7
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                RubinoPostGridActivity.this.postGridLayout.loadPosts(false, false);
            }
        }));
        this.topicInited = false;
        getTopics();
        updateRowsIds();
        PullToRefreshLayout pullToRefreshLayout2 = this.swipeRefreshLayout;
        if (pullToRefreshLayout2 != null) {
            pullToRefreshLayout2.setEnabled(true);
            this.swipeRefreshLayout.setRefreshListener(this.onRefreshListener);
            this.postGridLayout.setOnRefreshListener(new RubinoPostGridMultiSizeLayout.RefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.8
                @Override // ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.RefreshListener
                public void onRefreshEnd() {
                    RubinoPostGridActivity.this.scrollToTop();
                    RubinoPostGridActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                }

                @Override // ir.resaneh1.iptv.fragment.rubino.RubinoPostGridMultiSizeLayout.RefreshListener
                public void onRefreshError() {
                    RubinoPostGridActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                }
            });
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i, float f, float f2) {
        if (getParentActivity() == null) {
            return;
        }
        processOnClickOrPress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$1(View view, int i) {
        return processOnClickOrPress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseExistingCachedPlayers() {
        while (!RubinoController.shouldReleasePlayersInExplore.isEmpty()) {
            ExploreVideoPlayer exploreVideoPlayerPoll = RubinoController.shouldReleasePlayersInExplore.poll();
            if (exploreVideoPlayerPoll != null) {
                exploreVideoPlayerPoll.pause();
                exploreVideoPlayerPoll.releasePlayer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideoInListIfNeeded() {
        RecyclerListViewEdited recyclerListViewEdited;
        RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout;
        boolean z;
        if (this.isPaused || (recyclerListViewEdited = this.listView) == null || recyclerListViewEdited.getLayoutManager() == null || (rubinoPostGridMultiSizeLayout = this.postGridLayout) == null || rubinoPostGridMultiSizeLayout.getCurrentListView() == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.postGridLayout.getCurrentListView().getChildCount()) {
                z = false;
                break;
            }
            View childAt = this.postGridLayout.getCurrentListView().getChildAt(i);
            if (childAt instanceof ThreePostOneBigView) {
                ThreePostOneBigView threePostOneBigView = (ThreePostOneBigView) childAt;
                if (threePostOneBigView.hasBigPlayableItem()) {
                    threePostOneBigView.playBigPlayableItem();
                    z = true;
                    break;
                }
            }
            i++;
        }
        if (z) {
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.explorePlayersShouldPause, Integer.valueOf(this.classGuid));
    }

    void setAutoPlayRunnable() {
        AndroidUtilities.cancelRunOnUIThread(this.autoPlayRunnable);
        AndroidUtilities.runOnUIThread(this.autoPlayRunnable, 150L);
    }

    void cancelAutoPlayRunnable() {
        AndroidUtilities.cancelRunOnUIThread(this.autoPlayRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTopicsIfNeeded() {
        if (this.hasTopSection) {
            this.postGridLayout.headerListAdapter.setTopics(getRubinoController().getExploreTopics().topics);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkListViewScroll() {
        if (this.gridLayoutAttached) {
            this.postGridLayout.setVisibleHeight(this.listView.getMeasuredHeight() - this.postGridLayout.getTop());
        }
        this.listView.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needLayout() {
        int currentActionBarHeight = (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight();
        RecyclerListViewEdited recyclerListViewEdited = this.listView;
        if (recyclerListViewEdited != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) recyclerListViewEdited.getLayoutParams();
            if (layoutParams.topMargin != currentActionBarHeight) {
                layoutParams.topMargin = currentActionBarHeight;
                this.listView.setLayoutParams(layoutParams);
            }
        }
        RecyclerListViewEdited recyclerListViewEdited2 = this.listView;
        if (recyclerListViewEdited2 != null) {
            recyclerListViewEdited2.setOverScrollMode(2);
        }
    }

    public RecyclerListViewEdited getListView() {
        return this.listView;
    }

    private void fixLayout() {
        View view = this.fragmentView;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.10
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                RubinoPostGridActivity rubinoPostGridActivity = RubinoPostGridActivity.this;
                if (rubinoPostGridActivity.fragmentView == null) {
                    return true;
                }
                rubinoPostGridActivity.checkListViewScroll();
                RubinoPostGridActivity.this.needLayout();
                RubinoPostGridActivity.this.fragmentView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        View viewFindViewByPosition;
        super.onConfigurationChanged(configuration);
        RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout = this.postGridLayout;
        if (rubinoPostGridMultiSizeLayout != null) {
            rubinoPostGridMultiSizeLayout.onConfigurationChanged(configuration);
        }
        if (this.isInLandscapeMode && (viewFindViewByPosition = this.layoutManager.findViewByPosition(0)) != null) {
            this.listView.scrollBy(0, viewFindViewByPosition.getTop() - AndroidUtilities.dp(88.0f));
        }
        fixLayout();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        this.isTouchedAfterResume = false;
        RubinoPostGridMultiSizeLayout rubinoPostGridMultiSizeLayout = this.postGridLayout;
        if (rubinoPostGridMultiSizeLayout != null) {
            rubinoPostGridMultiSizeLayout.onResume();
        }
        fixLayout();
        setAutoPlayRunnable();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.isTouchedAfterResume = false;
        cancelAutoPlayRunnable();
        getNotificationCenter().postNotificationName(NotificationCenter.explorePlayersShouldPause, Integer.valueOf(this.classGuid));
        releaseExistingCachedPlayers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowsIds() {
        int currentActionBarHeight;
        int i;
        int i2 = this.rowCount;
        this.rowCount = 0;
        this.headerViewRow = -1;
        this.bottomPaddingRow = -1;
        this.gridRow = -1;
        this.retryRow = -1;
        if (this.needToRetry) {
            this.rowCount = 0 + 1;
            this.retryRow = 0;
        } else if (!this.topicInited) {
            this.rowCount = 0 + 1;
            this.loadingRow = 0;
        } else {
            if (this.hasTopSection) {
                this.rowCount = 0 + 1;
                this.headerViewRow = 0;
            }
            int i3 = this.rowCount;
            this.rowCount = i3 + 1;
            this.gridRow = i3;
        }
        if (this.actionBar != null) {
            currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0);
        } else {
            currentActionBarHeight = 0;
        }
        if (this.listView == null || i2 > this.rowCount || ((i = this.listContentHeight) != 0 && i + currentActionBarHeight + AndroidUtilities.dp(88.0f) < this.listView.getMeasuredHeight())) {
            this.lastMeasuredContentWidth = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTopics() {
        this.compositeDisposable.add((Disposable) getRubinoController().getExploreTopicsObservable().subscribeWith(new DisposableObserver<Rubino.ExploreTopicsObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.11
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Rubino.ExploreTopicsObject exploreTopicsObject) {
                if (RubinoPostGridActivity.this.swipeRefreshLayout != null) {
                    RubinoPostGridActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                }
                RubinoPostGridActivity.this.topicInited = true;
                RubinoPostGridActivity.this.updateRowsIds();
                RubinoPostGridActivity.this.listAdapter.notifyDataSetChanged();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (RubinoPostGridActivity.this.swipeRefreshLayout != null) {
                    RubinoPostGridActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                }
                RubinoPostGridActivity.this.needToRetry = true;
                RubinoPostGridActivity.this.updateRowsIds();
                RubinoPostGridActivity.this.listAdapter.notifyDataSetChanged();
            }
        }));
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        RecyclerListViewEdited recyclerListViewEdited = this.listView;
        if (recyclerListViewEdited != null) {
            recyclerListViewEdited.invalidateViews();
        }
    }

    private class ListAdapter extends RecyclerListViewEdited.SelectionAdapter {
        private final Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v5, types: [android.view.View, android.widget.LinearLayout, ir.resaneh1.iptv.fragment.rubino.RubinoRetryView] */
        /* JADX WARN: Type inference failed for: r2v7, types: [ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity$ListAdapter$3] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            if (i == 1) {
                FrameLayout exploreSearchView = new ExploreSearchView(this.mContext);
                exploreSearchView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.ListAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoPostGridActivity.this.presentFragment(new RubinoSearchActivity());
                    }
                });
                frameLayout = exploreSearchView;
            } else if (i == 2) {
                FrameLayout rubinoLoadingCell = new RubinoLoadingCell(this.mContext, true);
                rubinoLoadingCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                frameLayout = rubinoLoadingCell;
            } else if (i == 5) {
                ?? rubinoRetryView = new RubinoRetryView(this.mContext);
                rubinoRetryView.setBackgroundColor(-1);
                rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
                rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.ListAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoPostGridActivity.this.needToRetry = false;
                        RubinoPostGridActivity.this.updateRowsIds();
                        RubinoPostGridActivity.this.listAdapter.notifyDataSetChanged();
                        RubinoPostGridActivity.this.getTopics();
                    }
                });
                rubinoRetryView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                frameLayout = rubinoRetryView;
            } else if (i == 12) {
                frameLayout = new View(this.mContext) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity.ListAdapter.3
                    private int lastPaddingHeight = 0;
                    private int lastListViewHeight = 0;

                    @Override // android.view.View
                    protected void onMeasure(int i2, int i3) {
                        if (this.lastListViewHeight != RubinoPostGridActivity.this.listView.getMeasuredHeight()) {
                            this.lastPaddingHeight = 0;
                        }
                        this.lastListViewHeight = RubinoPostGridActivity.this.listView.getMeasuredHeight();
                        int childCount = RubinoPostGridActivity.this.listView.getChildCount();
                        if (childCount != RubinoPostGridActivity.this.listAdapter.getItemCount()) {
                            setMeasuredDimension(RubinoPostGridActivity.this.listView.getMeasuredWidth(), this.lastPaddingHeight);
                            return;
                        }
                        int measuredHeight = 0;
                        for (int i4 = 0; i4 < childCount; i4++) {
                            if (RubinoPostGridActivity.this.listView.getChildAdapterPosition(RubinoPostGridActivity.this.listView.getChildAt(i4)) != RubinoPostGridActivity.this.bottomPaddingRow) {
                                measuredHeight += RubinoPostGridActivity.this.listView.getChildAt(i4).getMeasuredHeight();
                            }
                        }
                        int measuredHeight2 = ((RubinoPostGridActivity.this.fragmentView.getMeasuredHeight() - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.statusBarHeight) - measuredHeight;
                        if (measuredHeight2 > AndroidUtilities.dp(88.0f)) {
                            measuredHeight2 = 0;
                        }
                        int i5 = measuredHeight2 > 0 ? measuredHeight2 : 0;
                        int measuredWidth = RubinoPostGridActivity.this.listView.getMeasuredWidth();
                        this.lastPaddingHeight = i5;
                        setMeasuredDimension(measuredWidth, i5);
                    }
                };
            } else if (i != 13) {
                frameLayout = null;
            } else {
                if (RubinoPostGridActivity.this.postGridLayout.getParent() != null) {
                    ((ViewGroup) RubinoPostGridActivity.this.postGridLayout.getParent()).removeView(RubinoPostGridActivity.this.postGridLayout);
                }
                frameLayout = RubinoPostGridActivity.this.postGridLayout;
            }
            if (i != 13 && i != 2 && i != 5 && frameLayout != null) {
                frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListViewEdited.Holder(frameLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView == RubinoPostGridActivity.this.postGridLayout) {
                RubinoPostGridActivity.this.gridLayoutAttached = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView == RubinoPostGridActivity.this.postGridLayout) {
                RubinoPostGridActivity.this.gridLayoutAttached = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.itemView == RubinoPostGridActivity.this.postGridLayout) {
                RubinoPostGridActivity.this.updateTopicsIfNeeded();
            }
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            return (view instanceof ExploreSearchView) || (view instanceof RubinoRetryView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoPostGridActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == RubinoPostGridActivity.this.headerViewRow) {
                return 1;
            }
            if (i == RubinoPostGridActivity.this.bottomPaddingRow) {
                return 12;
            }
            if (i == RubinoPostGridActivity.this.gridRow) {
                return 13;
            }
            if (i == RubinoPostGridActivity.this.retryRow) {
                return 5;
            }
            return i == RubinoPostGridActivity.this.loadingRow ? 2 : 0;
        }
    }
}
