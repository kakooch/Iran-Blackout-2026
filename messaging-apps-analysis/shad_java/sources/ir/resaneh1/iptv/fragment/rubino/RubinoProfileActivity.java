package ir.resaneh1.iptv.fragment.rubino;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.InstaNewEventsFragment;
import ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.fragment.rubino.highlight.ArchiveStoryListFragment;
import ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileLinkObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoProfileActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int bottomPaddingRow;
    private Context context;
    public DisposableObserver fakeObserver;
    private ImageView floatingButton;
    private FrameLayout floatingButtonContainer;
    private boolean floatingHidden;
    private boolean gridLayoutAttached;
    private int gridRow;
    private int headerViewRow;
    private int highlightRow;
    private boolean isHighlightLoading;
    private boolean isInLandscapeMode;
    private boolean isLinkItemLoading;
    private int lastMeasuredContentHeight;
    private int lastMeasuredContentWidth;
    private LinearLayoutManager layoutManager;
    private int linkItemRow;
    private ListAdapter listAdapter;
    private int listContentHeight;
    private RecyclerListViewEdited listView;
    private ChangeMyProfileActionBarView myProfileActionBar;
    private boolean needToRefreshOnResume;
    private RubinoPostGridLayout postGridLayout;
    private int prevPosition;
    private int prevTop;
    private int privateRow;
    public RubinoProfileObject profileObject;
    private int rowCount;
    private boolean scrollUpdated;
    private PullToRefreshLayout swipeRefreshLayout;
    private final Rect rect = new Rect();
    private final AccelerateDecelerateInterpolator floatingInterpolator = new AccelerateDecelerateInterpolator();
    private boolean isTouchedAfterResume = false;
    private ArrayList<RubinoProfileLinkObject> profileLinkItems = new ArrayList<>();
    public ArrayList<Rubino.StoryHighlight> highlights = new ArrayList<>();
    private boolean isLoadingChannelInfo = false;

    private boolean processOnClickOrPress(int i) {
        return false;
    }

    static /* synthetic */ int access$1212(RubinoProfileActivity rubinoProfileActivity, int i) {
        int i2 = rubinoProfileActivity.listContentHeight + i;
        rubinoProfileActivity.listContentHeight = i2;
        return i2;
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
            if (view == RubinoProfileActivity.this.listView && RubinoProfileActivity.this.gridLayoutAttached) {
                RecyclerListViewEdited currentListView = RubinoProfileActivity.this.postGridLayout.getCurrentListView();
                if (RubinoProfileActivity.this.postGridLayout.getTop() == 0) {
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
            if (view == RubinoProfileActivity.this.listView) {
                if (RubinoProfileActivity.this.gridRow == -1 || !RubinoProfileActivity.this.gridLayoutAttached) {
                    return;
                }
                boolean zIsSearchFieldVisible = ((BaseFragment) RubinoProfileActivity.this).actionBar.isSearchFieldVisible();
                int top = RubinoProfileActivity.this.postGridLayout.getTop();
                boolean z = false;
                if (i2 >= 0) {
                    if (zIsSearchFieldVisible) {
                        RecyclerListViewEdited currentListView = RubinoProfileActivity.this.postGridLayout.getCurrentListView();
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
                    RecyclerListViewEdited currentListView2 = RubinoProfileActivity.this.postGridLayout.getCurrentListView();
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
            return RubinoProfileActivity.this.gridRow != -1 && i == 2;
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

    public RubinoProfileActivity(RubinoProfileObject rubinoProfileObject) {
        this.profileObject = rubinoProfileObject;
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoProfileActivity";
        this.isSmallActionBar = true;
        this.swipeBackEnabled = false;
        this.needLockOrientation = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.highlightEdited);
        getNotificationCenter().addObserver(this, NotificationCenter.highlightDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.highlightAdded);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoProfileLoadingFailed);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoProfileDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoProfileUpdated);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoProfileDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoPostDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.myFirstStoryAdded);
        getNotificationCenter().addObserver(this, NotificationCenter.myStoryAdded);
        getNotificationCenter().addObserver(this, NotificationCenter.myStoryDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.sendingStoryStatusChanges);
        getNotificationCenter().addObserver(this, NotificationCenter.allStoriesIsSeenChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoLiveStatusChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.storyListEmptyDetected);
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.highlightEdited);
        getNotificationCenter().removeObserver(this, NotificationCenter.highlightDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.highlightAdded);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoProfileLoadingFailed);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoProfileDidLoad);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoProfileUpdated);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoProfileDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoPostDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.myFirstStoryAdded);
        getNotificationCenter().removeObserver(this, NotificationCenter.myStoryAdded);
        getNotificationCenter().removeObserver(this, NotificationCenter.myStoryDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.sendingStoryStatusChanges);
        getNotificationCenter().removeObserver(this, NotificationCenter.allStoriesIsSeenChanged);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoLiveStatusChanged);
        getNotificationCenter().removeObserver(this, NotificationCenter.storyListEmptyDetected);
        super.onFragmentDestroy();
        RubinoPostGridLayout rubinoPostGridLayout = this.postGridLayout;
        if (rubinoPostGridLayout != null) {
            rubinoPostGridLayout.onDestroy();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        RubinoProfileObject rubinoProfileObject;
        RubinoProfileObject rubinoProfileObject2;
        if (i == NotificationCenter.highlightAdded || i == NotificationCenter.highlightEdited || i == NotificationCenter.highlightDeleted) {
            String str = (String) objArr[0];
            RubinoProfileObject rubinoProfileObject3 = this.profileObject;
            if (rubinoProfileObject3 != null && rubinoProfileObject3.isMyCurrentProfile() && str != null && str.equals(this.profileObject.id)) {
                callGetHighlights();
            }
        }
        if (i == NotificationCenter.myFirstStoryAdded || i == NotificationCenter.myStoryAdded || i == NotificationCenter.myStoryDeleted || i == NotificationCenter.sendingStoryStatusChanges) {
            if (!this.profileObject.isMyCurrentProfile() || getHeaderView() == null) {
                return;
            }
            getHeaderView().setStoryStatus();
            return;
        }
        if (i == NotificationCenter.allStoriesIsSeenChanged || i == NotificationCenter.storyListEmptyDetected) {
            if (getHeaderView() != null) {
                getHeaderView().setStoryStatus();
                return;
            }
            return;
        }
        if (i == NotificationCenter.rubinoLiveStatusChanged) {
            String str2 = (String) objArr[0];
            if (str2 == null || !str2.equals(this.profileObject.id) || getHeaderView() == null) {
                return;
            }
            getHeaderView().setStoryStatus();
            return;
        }
        if (i == NotificationCenter.rubinoPostDeleted) {
            String str3 = (String) objArr[0];
            String str4 = (String) objArr[1];
            RubinoPostGridLayout rubinoPostGridLayout = this.postGridLayout;
            if (rubinoPostGridLayout != null) {
                rubinoPostGridLayout.checkPostDeleted(str3);
            }
            if (!this.profileObject.id.equals(str4) || (rubinoProfileObject2 = getRubinoController().profileMap.get(str4)) == null) {
                return;
            }
            this.profileObject = rubinoProfileObject2;
            ProfileHeaderView headerView = getHeaderView();
            if (headerView != null) {
                headerView.setProfile(this.profileObject);
                headerView.setNumbers();
                return;
            }
            return;
        }
        if (i == NotificationCenter.rubinoProfileLoadingFailed) {
            PullToRefreshLayout pullToRefreshLayout = this.swipeRefreshLayout;
            if (pullToRefreshLayout != null) {
                pullToRefreshLayout.setRefreshing(false, true);
                return;
            }
            return;
        }
        if (i == NotificationCenter.rubinoProfileDeleted) {
            String str5 = (String) objArr[0];
            if (str5 == null || !str5.equals(this.profileObject.id)) {
                return;
            }
            finishFragment();
            return;
        }
        if (i == NotificationCenter.rubinoProfileDidLoad) {
            String str6 = (String) objArr[0];
            if (str6 == null || !str6.equals(this.profileObject.id)) {
                return;
            }
            PullToRefreshLayout pullToRefreshLayout2 = this.swipeRefreshLayout;
            if (pullToRefreshLayout2 != null) {
                pullToRefreshLayout2.setRefreshing(false, true);
            }
            RubinoProfileObject rubinoProfileObject4 = getRubinoController().profileMap.get(str6);
            if (rubinoProfileObject4 != null) {
                this.profileObject = rubinoProfileObject4;
                ProfileHeaderView headerView2 = getHeaderView();
                if (headerView2 != null) {
                    headerView2.setProfile(this.profileObject);
                    headerView2.setData();
                }
                updateRowsIds();
                setActionBar();
                ListAdapter listAdapter = this.listAdapter;
                if (listAdapter != null) {
                    listAdapter.notifyDataSetChanged();
                }
                getProfileLinkItemsIfNeeded();
                return;
            }
            return;
        }
        if (i == NotificationCenter.rubinoProfileUpdated) {
            PullToRefreshLayout pullToRefreshLayout3 = this.swipeRefreshLayout;
            if (pullToRefreshLayout3 != null) {
                pullToRefreshLayout3.setRefreshing(false, true);
            }
            String str7 = (String) objArr[0];
            if (str7 == null || !str7.equals(this.profileObject.id) || (rubinoProfileObject = getRubinoController().profileMap.get(str7)) == null) {
                return;
            }
            this.profileObject = rubinoProfileObject;
            ProfileHeaderView headerView3 = getHeaderView();
            if (headerView3 != null) {
                headerView3.setProfile(this.profileObject);
                headerView3.setData();
            }
            setActionBar();
            getProfileLinkItemsIfNeeded();
            return;
        }
        if (i == NotificationCenter.rubinoFollowBlockChanged) {
            String str8 = (String) objArr[0];
            if (str8 != null && str8.equals(this.profileObject.id)) {
                ProfileHeaderView headerView4 = getHeaderView();
                if (headerView4 != null) {
                    headerView4.setButtons();
                }
                updateRowsIds();
                ListAdapter listAdapter2 = this.listAdapter;
                if (listAdapter2 != null) {
                    listAdapter2.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (this.profileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
                this.needToRefreshOnResume = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ProfileHeaderView getHeaderView() {
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.listView.getChildAt(i) instanceof ProfileHeaderView) {
                return (ProfileHeaderView) this.listView.getChildAt(i);
            }
        }
        return null;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return super.onTouchEvent(motionEvent);
            }
        };
        actionBar.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
        actionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBar.setCastShadows(false);
        actionBar.setAddToContainer(false);
        this.actionBar = actionBar;
        this.context = context;
        setActionBar();
        actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceMedium());
        return actionBar;
    }

    private void setActionBar() {
        if (this.profileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
            this.actionBar.setTitle(BuildConfig.FLAVOR);
            if (this.myProfileActionBar == null) {
                ChangeMyProfileActionBarView changeMyProfileActionBarView = new ChangeMyProfileActionBarView(this.context);
                this.myProfileActionBar = changeMyProfileActionBarView;
                this.actionBar.addView(changeMyProfileActionBarView, 0, LayoutHelper.createFrame(-2, -1.0f, 53, 0.0f, 0.0f, 40.0f, 0.0f));
            }
            ChangeMyProfileActionBarView changeMyProfileActionBarView2 = this.myProfileActionBar;
            String username = this.profileObject.getUsername();
            RubinoProfileObject rubinoProfileObject = this.profileObject;
            changeMyProfileActionBarView2.changeName(username, rubinoProfileObject.is_verified, rubinoProfileObject.sale_permission);
            return;
        }
        RubinoProfileObject rubinoProfileObject2 = this.profileObject;
        if (rubinoProfileObject2.is_verified || rubinoProfileObject2.sale_permission) {
            SpannableString spannableString = new SpannableString("  " + rubinoProfileObject2.getUsername());
            RubinoController rubinoController = getRubinoController();
            RubinoProfileObject rubinoProfileObject3 = this.profileObject;
            ImageSpan imageSpanVerifyOrSale = rubinoController.getImageSpanVerifyOrSale(rubinoProfileObject3.is_verified, rubinoProfileObject3.sale_permission, 16, 2);
            if (imageSpanVerifyOrSale != null) {
                spannableString.setSpan(imageSpanVerifyOrSale, 0, 1, 17);
            }
            this.actionBar.setTitle(spannableString);
            return;
        }
        this.actionBar.setTitle(rubinoProfileObject2.getUsername());
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Theme.createProfileResources(context);
        syncProfileInfoWithController();
        this.context = context;
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass2());
        this.hasOwnBackground = true;
        RubinoPostGridLayout rubinoPostGridLayout = this.postGridLayout;
        if (rubinoPostGridLayout != null) {
            rubinoPostGridLayout.onDestroy();
        }
        RubinoPostGridLayout rubinoPostGridLayout2 = new RubinoPostGridLayout(context, this, 2) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.3
            @Override // ir.resaneh1.iptv.fragment.rubino.RubinoPostGridLayout
            protected void onSelectedTabChanged() {
                RubinoProfileActivity.this.isTouchedAfterResume = false;
                if (RubinoProfileActivity.this.listAdapter != null) {
                    RubinoProfileActivity.this.listAdapter.notifyDataSetChanged();
                }
                loadPosts(getSelectedTab());
            }
        };
        this.postGridLayout = rubinoPostGridLayout2;
        rubinoPostGridLayout2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        this.actionBar.createMenu().addItem(10, R.drawable.ic_ab_other);
        this.listAdapter = new ListAdapter(context);
        NestedFrameLayout nestedFrameLayout = new NestedFrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.4
            private boolean firstLayout = true;
            private boolean ignoreLayout;

            @Override // android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                boolean z;
                int measuredWidth;
                int iMax;
                int top;
                int adapterPosition;
                boolean z2;
                int iDp = AndroidUtilities.dp(48.0f) + (((BaseFragment) RubinoProfileActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0);
                if (RubinoProfileActivity.this.listView != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) RubinoProfileActivity.this.listView.getLayoutParams();
                    if (layoutParams.topMargin != iDp) {
                        layoutParams.topMargin = iDp;
                    }
                }
                if (RubinoProfileActivity.this.swipeRefreshLayout != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) RubinoProfileActivity.this.swipeRefreshLayout.getLayoutParams();
                    if (layoutParams2.topMargin != iDp) {
                        layoutParams2.topMargin = iDp;
                    }
                }
                super.onMeasure(i, i2);
                View.MeasureSpec.getSize(i2);
                boolean z3 = true;
                if (RubinoProfileActivity.this.lastMeasuredContentWidth == getMeasuredWidth() && RubinoProfileActivity.this.lastMeasuredContentHeight == getMeasuredHeight()) {
                    z = false;
                } else {
                    z = (RubinoProfileActivity.this.lastMeasuredContentWidth == 0 || RubinoProfileActivity.this.lastMeasuredContentWidth == getMeasuredWidth()) ? false : true;
                    RubinoProfileActivity.this.listContentHeight = 0;
                    int itemCount = RubinoProfileActivity.this.listAdapter.getItemCount();
                    RubinoProfileActivity.this.lastMeasuredContentWidth = getMeasuredWidth();
                    RubinoProfileActivity.this.lastMeasuredContentHeight = getMeasuredHeight();
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(RubinoProfileActivity.this.listView.getMeasuredHeight(), 0);
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        int itemViewType = RubinoProfileActivity.this.listAdapter.getItemViewType(i3);
                        if (itemViewType != 13) {
                            RecyclerView.ViewHolder viewHolderCreateViewHolder = RubinoProfileActivity.this.listAdapter.createViewHolder(null, itemViewType);
                            RubinoProfileActivity.this.listAdapter.onBindViewHolder(viewHolderCreateViewHolder, i3);
                            viewHolderCreateViewHolder.itemView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            RubinoProfileActivity.access$1212(RubinoProfileActivity.this, viewHolderCreateViewHolder.itemView.getMeasuredHeight());
                        } else {
                            RubinoProfileActivity rubinoProfileActivity = RubinoProfileActivity.this;
                            RubinoProfileActivity.access$1212(rubinoProfileActivity, rubinoProfileActivity.listView.getMeasuredHeight());
                        }
                    }
                }
                if (this.firstLayout) {
                    return;
                }
                this.ignoreLayout = true;
                if (!RubinoProfileActivity.this.isInLandscapeMode) {
                    measuredWidth = RubinoProfileActivity.this.listView.getMeasuredWidth();
                    iMax = Math.max(0, getMeasuredHeight() - ((RubinoProfileActivity.this.listContentHeight + AndroidUtilities.dp(88.0f)) + iDp));
                } else {
                    measuredWidth = AndroidUtilities.dp(88.0f);
                    iMax = 0;
                }
                int paddingTop = RubinoProfileActivity.this.listView.getPaddingTop();
                View childAt = RubinoProfileActivity.this.listView.getChildAt(0);
                if (childAt != null) {
                    RecyclerView.ViewHolder viewHolderFindContainingViewHolder = RubinoProfileActivity.this.listView.findContainingViewHolder(childAt);
                    adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        adapterPosition = viewHolderFindContainingViewHolder.getPosition();
                    }
                    top = childAt.getTop();
                } else {
                    top = 0;
                    adapterPosition = -1;
                }
                if (z || adapterPosition == -1) {
                    z2 = false;
                } else {
                    RubinoProfileActivity.this.layoutManager.scrollToPositionWithOffset(adapterPosition, top);
                    z2 = true;
                }
                if (paddingTop == measuredWidth && RubinoProfileActivity.this.listView.getPaddingBottom() == iMax) {
                    z3 = z2;
                } else {
                    RubinoProfileActivity.this.listView.setPadding(0, 0, 0, iMax);
                }
                if (z3) {
                    measureChildWithMargins(RubinoProfileActivity.this.listView, i, 0, i2, 0);
                    RubinoProfileActivity.this.listView.layout(0, iDp, RubinoProfileActivity.this.listView.getMeasuredWidth(), RubinoProfileActivity.this.listView.getMeasuredHeight() + iDp);
                }
                this.ignoreLayout = false;
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
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
        RecyclerListViewEdited recyclerListViewEdited = new RecyclerListViewEdited(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.5
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

            /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onDraw(android.graphics.Canvas r15) {
                /*
                    r14 = this;
                    ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity r0 = ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.this
                    int r0 = ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.access$300(r0)
                    r1 = -1
                    r2 = 0
                    if (r0 == r1) goto Lb
                    goto L1d
                Lb:
                    ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity r0 = ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.this
                    int r0 = ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.access$1500(r0)
                    if (r0 == r1) goto L1d
                    ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity r0 = ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.this
                    int r0 = ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.access$1500(r0)
                    androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r14.findViewHolderForAdapterPosition(r0)
                L1d:
                    int r0 = r14.getMeasuredHeight()
                    if (r2 == 0) goto L31
                    android.view.View r1 = r2.itemView
                    int r1 = r1.getBottom()
                    android.view.View r2 = r2.itemView
                    int r2 = r2.getBottom()
                    if (r2 < r0) goto L32
                L31:
                    r1 = r0
                L32:
                    android.graphics.Paint r2 = r14.paint
                    int r3 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundWhite
                    int r3 = org.rbmain.ui.ActionBar.Theme.getColor(r3)
                    r2.setColor(r3)
                    r5 = 0
                    r6 = 0
                    int r2 = r14.getMeasuredWidth()
                    float r7 = (float) r2
                    float r10 = (float) r1
                    android.graphics.Paint r9 = r14.paint
                    r4 = r15
                    r8 = r10
                    r4.drawRect(r5, r6, r7, r8, r9)
                    if (r1 == r0) goto L5b
                    r9 = 0
                    int r1 = r14.getMeasuredWidth()
                    float r11 = (float) r1
                    float r12 = (float) r0
                    android.graphics.Paint r13 = r14.paint
                    r8 = r15
                    r8.drawRect(r9, r10, r11, r12, r13)
                L5b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.AnonymousClass5.onDraw(android.graphics.Canvas):void");
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                VelocityTracker velocityTracker;
                int action = motionEvent.getAction();
                RubinoProfileActivity.this.isTouchedAfterResume = true;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.6
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
                if (RubinoProfileActivity.this.isTouchedAfterResume) {
                    return super.scrollVerticallyBy(i, recycler, state);
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
        this.swipeRefreshLayout.bindListViewToLayout(this.listView);
        this.listView.setAdapter(this.listAdapter);
        nestedFrameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setOnItemClickListener(new RecyclerListViewEdited.OnItemClickListenerExtended() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity$$ExternalSyntheticLambda1
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$createView$0(view, i, f, f2);
            }
        });
        this.swipeRefreshLayout.setRefreshListener(new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.7
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoProfileActivity.this.refreshProfile(true);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoProfileActivity.this.postGridLayout.getCurrentListView(), z);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListViewEdited.OnItemLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity$$ExternalSyntheticLambda2
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$1(view, i);
            }
        });
        nestedFrameLayout2.addView(this.actionBar);
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            try {
                listAdapter.notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }
        needLayout();
        this.listView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.8
            private boolean scrollingManually;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1) {
                    AndroidUtilities.hideKeyboard(RubinoProfileActivity.this.getParentActivity().getCurrentFocus());
                }
                this.scrollingManually = i == 1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z;
                if (!RubinoProfileActivity.this.swipeRefreshLayout.isInteracted()) {
                    RubinoProfileActivity.this.checkListViewScroll();
                }
                if (RubinoProfileActivity.this.floatingButtonContainer == null || RubinoProfileActivity.this.floatingButtonContainer.getVisibility() == 8) {
                    return;
                }
                int iFindFirstVisibleItemPosition = ((LinearLayoutManager) RubinoProfileActivity.this.listView.getLayoutManager()).findFirstVisibleItemPosition();
                View childAt = recyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                if (RubinoProfileActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                    int i3 = RubinoProfileActivity.this.prevTop - top;
                    z = top < RubinoProfileActivity.this.prevTop;
                    if (Math.abs(i3) > 1) {
                    }
                    if (z && RubinoProfileActivity.this.scrollUpdated && (z || (!z && this.scrollingManually))) {
                        RubinoProfileActivity.this.hideFloatingButton(z);
                    }
                    RubinoProfileActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                    RubinoProfileActivity.this.prevTop = top;
                    RubinoProfileActivity.this.scrollUpdated = true;
                }
                z = iFindFirstVisibleItemPosition > RubinoProfileActivity.this.prevPosition;
                z = true;
                if (z) {
                    RubinoProfileActivity.this.hideFloatingButton(z);
                }
                RubinoProfileActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                RubinoProfileActivity.this.prevTop = top;
                RubinoProfileActivity.this.scrollUpdated = true;
            }
        });
        View view = this.fragmentView;
        int i = Theme.key_windowBackgroundWhite;
        view.setBackgroundColor(Theme.getColor(i));
        this.listView.setBackgroundColor(Theme.getColor(i));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable observableJust = Observable.just(1);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        compositeDisposable.add((Disposable) observableJust.delay(200L, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.9
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                RubinoProfileActivity.this.postGridLayout.loadPosts(0);
            }
        }));
        this.compositeDisposable.add((Disposable) Observable.just(1).delay(250L, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.10
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                RubinoProfileActivity.this.getProfileLinkItemsIfNeeded();
            }
        }));
        updateRowsIds();
        this.listAdapter.notifyDataSetChanged();
        if (this.profileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
            createFloatingButtonIfNeeded((FrameLayout) this.fragmentView);
        }
        return this.fragmentView;
    }

    /* renamed from: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity$2, reason: invalid class name */
    class AnonymousClass2 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass2() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) {
            if (i == -1) {
                RubinoProfileActivity.this.finishFragment();
                return;
            }
            if (i == 10) {
                ArrayList arrayList = new ArrayList();
                if (RubinoProfileActivity.this.profileObject.isMyCurrentProfile()) {
                    arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSetting), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            RubinoProfileActivity.this.presentFragment(new RubinoSettingsActivity(RubinoProfileObject.convertToOldObject(RubinoProfileActivity.this.profileObject)));
                        }
                    }));
                    if (!RubinoProfileActivity.this.profileObject.isDefault()) {
                        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoDeletePage), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                RubinoProfileActivity.this.getRubinoController().deleteProfilePage(RubinoProfileActivity.this.profileObject);
                            }
                        }));
                    }
                    arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoBookmark), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            RubinoProfileActivity.this.presentFragment(new RubinoPostGridActivity(RubinoPostGridActivity.bookmarkType));
                        }
                    }));
                    if (RubinoController.getInstance(((BaseFragment) RubinoProfileActivity.this).currentAccount).hasPermissionAddStory()) {
                        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoAddHighlight), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                RubinoProfileActivity.this.presentFragment(new ArchiveStoryListFragment());
                            }
                        }));
                    }
                    arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoBlockedProfiles), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            RubinoProfileActivity.this.presentFragment(new RubinoProfileListActivity(RubinoProfileListActivity.blockedType));
                        }
                    }));
                    if (RubinoProfileActivity.this.profileObject.count_purchase > 0) {
                        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoPurchase), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                RubinoProfileActivity.this.presentFragment(new InstaNewEventsFragment(new ListInput(ListInput.ItemType.instaPurchaseNotif)));
                            }
                        }));
                    }
                    if (RubinoProfileActivity.this.profileObject.sale_permission) {
                        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSales), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                RubinoProfileActivity.this.presentFragment(new InstaNewEventsFragment(new ListInput(ListInput.ItemType.instaSaleNotif)));
                            }
                        }));
                    }
                } else {
                    arrayList.add(new Rubino.AlertBlockItem(RubinoProfileActivity.this.profileObject));
                    if (RubinoProfileActivity.this.profileObject.is_message_allowed) {
                        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoMessage), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                new MainClickHandler().onLinkClick(RubinoProfileActivity.this.profileObject.chat_link);
                            }
                        }));
                    }
                    arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoReport), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ArrayList arrayList2 = new ArrayList();
                            final RubinoBottomUpAlert rubinoBottomUpAlertCreateRubinoDialogItems = RubinoBottomUpAlert.createRubinoDialogItems(ApplicationLoader.applicationActivity.getLastFragment(), LocaleController.getString(R.string.rubinoReport), arrayList2);
                            arrayList2.add(new Rubino.AlertBoldItem(LocaleController.getString(R.string.rubinoReportProfileQuestion)));
                            arrayList2.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSpam), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.9.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    RubinoProfileActivity.this.getRubinoController().reportProfile(RubinoProfileActivity.this.profileObject, 1);
                                    rubinoBottomUpAlertCreateRubinoDialogItems.dismiss();
                                }
                            }));
                            arrayList2.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoInAppropriate), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.9.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    RubinoProfileActivity.this.getRubinoController().reportProfile(RubinoProfileActivity.this.profileObject, 2);
                                    rubinoBottomUpAlertCreateRubinoDialogItems.dismiss();
                                }
                            }));
                            rubinoBottomUpAlertCreateRubinoDialogItems.listAdapter.notifyDataSetChanged();
                            RubinoProfileActivity.this.showDialog(rubinoBottomUpAlertCreateRubinoDialogItems);
                        }
                    }));
                    if (RubinoProfileActivity.this.getRubinoController().isProfileFollowed(RubinoProfileActivity.this.profileObject)) {
                        arrayList.add(new Rubino.AlertUnFollowItem(RubinoProfileActivity.this.profileObject));
                    }
                }
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoShareProfile), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoProfileActivity.this.getRubinoController().shareProfile(RubinoProfileActivity.this.profileObject);
                    }
                }));
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoCopyProfile), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.2.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoProfileActivity.this.getRubinoController().copyProfile(RubinoProfileActivity.this.profileObject);
                    }
                }));
                if (arrayList.size() > 0) {
                    RubinoController.showRubinoCenterDialog(null, arrayList);
                }
            }
        }
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
    public void getProfileLinkItemsIfNeeded() {
        RubinoProfileObject rubinoProfileObject = this.profileObject;
        if (rubinoProfileObject == null) {
            return;
        }
        if (rubinoProfileObject.hasLinkItem) {
            if (this.isLinkItemLoading) {
                return;
            }
            this.isLinkItemLoading = true;
            this.compositeDisposable.add((Disposable) getRubinoController().getProfileLinkItemsObservable(this.profileObject.id).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.GetProfileLinkItemsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.11
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<Rubino.GetProfileLinkItemsOutput> messangerOutput) {
                    RubinoProfileActivity.this.isLinkItemLoading = false;
                    RubinoProfileActivity.this.profileLinkItems.clear();
                    Rubino.GetProfileLinkItemsOutput getProfileLinkItemsOutput = messangerOutput.data;
                    if (getProfileLinkItemsOutput != null && getProfileLinkItemsOutput.link_items != null) {
                        RubinoProfileActivity.this.profileLinkItems.addAll(messangerOutput.data.link_items);
                    }
                    RubinoProfileActivity.this.updateRowsIds();
                    if (RubinoProfileActivity.this.listAdapter != null) {
                        RubinoProfileActivity.this.listAdapter.notifyDataSetChanged();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    RubinoProfileActivity.this.isLinkItemLoading = false;
                }
            }));
        }
        callGetHighlights();
    }

    private void callGetHighlights() {
        if (this.profileObject == null || this.isHighlightLoading) {
            return;
        }
        this.isHighlightLoading = true;
        this.compositeDisposable.add((DisposableObserver) getRubinoController().getProfileHighlightsObservable(this.profileObject.id).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.GetProfileHighlightsOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.12
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Rubino.GetProfileHighlightsOutput getProfileHighlightsOutput) {
                RubinoProfileActivity.this.isHighlightLoading = false;
                if (getProfileHighlightsOutput == null || getProfileHighlightsOutput.highlights == null) {
                    return;
                }
                RubinoProfileActivity.this.highlights.clear();
                RubinoProfileActivity.this.highlights.addAll(getProfileHighlightsOutput.highlights);
                RubinoProfileActivity.this.updateRowsIds();
                if (RubinoProfileActivity.this.listAdapter != null) {
                    RubinoProfileActivity.this.listAdapter.notifyDataSetChanged();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoProfileActivity.this.isHighlightLoading = false;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshProfile(boolean z) {
        RubinoProfileObject rubinoProfileObject;
        if (z && (rubinoProfileObject = getRubinoController().profileMap.get(this.profileObject.id)) != null && System.currentTimeMillis() - rubinoProfileObject.lastUpdateTime < 10000) {
            DisposableObserver disposableObserver = this.fakeObserver;
            if (disposableObserver != null && !disposableObserver.isDisposed()) {
                this.fakeObserver.dispose();
            }
            DisposableObserver disposableObserver2 = (DisposableObserver) Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.13
                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    if (RubinoProfileActivity.this.swipeRefreshLayout != null) {
                        RubinoProfileActivity.this.swipeRefreshLayout.setRefreshing(false, true);
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
            this.fakeObserver = disposableObserver2;
            this.compositeDisposable.add(disposableObserver2);
            return;
        }
        DisposableObserver disposableObserver3 = this.fakeObserver;
        if (disposableObserver3 != null && !disposableObserver3.isDisposed()) {
            this.fakeObserver.dispose();
        }
        RubinoController rubinoController = getRubinoController();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        RubinoProfileObject rubinoProfileObject2 = this.profileObject;
        rubinoController.getInstantProfileInfoIfExist(compositeDisposable, rubinoProfileObject2.isMyProfile, rubinoProfileObject2.id, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkListViewScroll() {
        if (this.gridLayoutAttached) {
            Log.d("forough", "checkListViewScroll: ${postGridLayout.getTop()} " + this.postGridLayout.getTop());
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
        this.listView.setOverScrollMode(2);
    }

    public RecyclerListViewEdited getListView() {
        return this.listView;
    }

    private void fixLayout() {
        View view = this.fragmentView;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.14
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                RubinoProfileActivity rubinoProfileActivity = RubinoProfileActivity.this;
                if (rubinoProfileActivity.fragmentView == null) {
                    return true;
                }
                rubinoProfileActivity.checkListViewScroll();
                RubinoProfileActivity.this.needLayout();
                RubinoProfileActivity.this.fragmentView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        View viewFindViewByPosition;
        super.onConfigurationChanged(configuration);
        RubinoPostGridLayout rubinoPostGridLayout = this.postGridLayout;
        if (rubinoPostGridLayout != null) {
            rubinoPostGridLayout.onConfigurationChanged(configuration);
        }
        if (this.isInLandscapeMode && (viewFindViewByPosition = this.layoutManager.findViewByPosition(0)) != null) {
            this.listView.scrollBy(0, viewFindViewByPosition.getTop() - AndroidUtilities.dp(88.0f));
        }
        fixLayout();
    }

    private void showFloatingButton() {
        if (this.floatingButton == null) {
            return;
        }
        this.floatingButtonContainer.setVisibility(0);
        this.floatingHidden = true;
        this.floatingButtonContainer.setTranslationY(AndroidUtilities.dp(100.0f));
        hideFloatingButton(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingButton(boolean z) {
        if (this.floatingButton == null || this.floatingHidden == z) {
            return;
        }
        this.floatingHidden = z;
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[1];
        FrameLayout frameLayout = this.floatingButtonContainer;
        Property property = View.TRANSLATION_Y;
        float[] fArr = new float[1];
        fArr[0] = this.floatingHidden ? AndroidUtilities.dp(100.0f) : 0;
        animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
        animatorSet.playTogether(animatorArr);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(this.floatingInterpolator);
        this.floatingButtonContainer.setClickable(!z);
        animatorSet.start();
    }

    private void createFloatingButtonIfNeeded(FrameLayout frameLayout) {
        if (RubinoController.getInstance(this.currentAccount).hasPermissionAddPost() && this.floatingButton == null) {
            FrameLayout frameLayout2 = new FrameLayout(this.context);
            this.floatingButtonContainer = frameLayout2;
            int i = Build.VERSION.SDK_INT;
            int i2 = (i >= 21 ? 56 : 60) + 20;
            float f = (i >= 21 ? 56 : 60) + 14;
            boolean z = LocaleController.isRTL;
            frameLayout.addView(frameLayout2, LayoutHelper.createFrame(i2, f, (z ? 3 : 5) | 80, z ? 4.0f : 0.0f, 0.0f, z ? 0.0f : 4.0f, 0.0f));
            this.floatingButtonContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RubinoProfileActivity.lambda$createFloatingButtonIfNeeded$2(view);
                }
            });
            ImageView imageView = new ImageView(this.context);
            this.floatingButton = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), -16607753, -13863696);
            if (i < 21) {
                Drawable drawableMutate = this.context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
                drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
                CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
                combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
            }
            this.floatingButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
            this.floatingButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chats_actionIcon), PorterDuff.Mode.MULTIPLY));
            this.floatingButton.setImageResource(R.drawable.add);
            this.floatingButtonContainer.setContentDescription(LocaleController.getString("CreateNewContact", R.string.CreateNewContact));
            if (i >= 21) {
                StateListAnimator stateListAnimator = new StateListAnimator();
                int[] iArr = {android.R.attr.state_pressed};
                ImageView imageView2 = this.floatingButton;
                Property property = View.TRANSLATION_Z;
                stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
                stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
                this.floatingButton.setStateListAnimator(stateListAnimator);
                this.floatingButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.15
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                    }
                });
            }
            this.floatingButtonContainer.addView(this.floatingButton, LayoutHelper.createFrame(i >= 21 ? 56 : 60, i >= 21 ? 56 : 60, 51, 10.0f, 0.0f, 10.0f, 0.0f));
            showFloatingButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFloatingButtonIfNeeded$2(View view) {
        new MainClickHandler().addRubinoPost();
    }

    private void invalidateIsInLandscapeMode() {
        Point point = new Point();
        getParentActivity().getWindowManager().getDefaultDisplay().getSize(point);
        this.isInLandscapeMode = point.x > point.y;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        this.isTouchedAfterResume = false;
        RubinoPostGridLayout rubinoPostGridLayout = this.postGridLayout;
        if (rubinoPostGridLayout != null) {
            rubinoPostGridLayout.onResume();
        }
        invalidateIsInLandscapeMode();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        fixLayout();
        if (this.needToRefreshOnResume) {
            this.needToRefreshOnResume = false;
            refreshProfile(false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.isTouchedAfterResume = false;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        RubinoPostGridLayout rubinoPostGridLayout;
        if (this.headerViewRow == -1 || (rubinoPostGridLayout = this.postGridLayout) == null) {
            return true;
        }
        rubinoPostGridLayout.getHitRect(this.rect);
        return this.postGridLayout.isCurrentTabFirst();
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
        this.privateRow = -1;
        this.highlightRow = -1;
        if (this.profileObject != null) {
            this.rowCount = 0 + 1;
            this.headerViewRow = 0;
            if (this.highlights.size() > 0 || ((this.profileObject.hasLinkItem && this.profileLinkItems.size() > 0) || this.profileObject.isMyProfile)) {
                int i3 = this.rowCount;
                this.rowCount = i3 + 1;
                this.linkItemRow = i3;
            }
            if (!getRubinoController().isProfileLoading(this.profileObject.id)) {
                RubinoProfileObject rubinoProfileObject = this.profileObject;
                if (!rubinoProfileObject.isMyProfile && rubinoProfileObject.isPrivate() && !getRubinoController().isProfileFollowed(this.profileObject)) {
                    int i4 = this.rowCount;
                    this.rowCount = i4 + 1;
                    this.privateRow = i4;
                } else {
                    int i5 = this.rowCount;
                    this.rowCount = i5 + 1;
                    this.gridRow = i5;
                }
            }
        }
        if (this.gridRow == -1) {
            int i6 = this.rowCount;
            this.rowCount = i6 + 1;
            this.bottomPaddingRow = i6;
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

    private void syncProfileInfoWithController() {
        RubinoController rubinoController = getRubinoController();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        RubinoProfileObject rubinoProfileObject = this.profileObject;
        RubinoProfileObject instantProfileInfoIfExist = rubinoController.getInstantProfileInfoIfExist(compositeDisposable, rubinoProfileObject.isMyProfile, rubinoProfileObject.id, false);
        if (instantProfileInfoIfExist != null) {
            this.profileObject = instantProfileInfoIfExist;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        RecyclerListViewEdited recyclerListViewEdited = this.listView;
        if (recyclerListViewEdited != null) {
            recyclerListViewEdited.invalidateViews();
        }
    }

    public void getChannel() {
        if (this.isLoadingChannelInfo) {
            return;
        }
        RubinoProfileObject rubinoProfileObject = this.profileObject;
        if (rubinoProfileObject.channel == null) {
            String strReplace = rubinoProfileObject.getUsername().replace("@", BuildConfig.FLAVOR);
            this.isLoadingChannelInfo = true;
            getCoreMainClass().getObjectInfoByUsername(strReplace, false, new AnonymousClass16());
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity$16, reason: invalid class name */
    class AnonymousClass16 implements LoadListener<String> {
        AnonymousClass16() {
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity$16$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(String str) {
            RubinoProfileActivity.this.isLoadingChannelInfo = false;
            ObjectInfo objectInfoInstant = RubinoProfileActivity.this.getCoreMainClass().getObjectInfoInstant(str);
            if (objectInfoInstant == null || objectInfoInstant.objectType != ChatType.Channel || objectInfoInstant.channelInfo == null) {
                return;
            }
            RubinoProfileObject rubinoProfileObject = RubinoProfileActivity.this.profileObject;
            rubinoProfileObject.channel = objectInfoInstant;
            rubinoProfileObject.updateContactInfo();
            ProfileHeaderView headerView = RubinoProfileActivity.this.getHeaderView();
            if (headerView != null) {
                headerView.setButtons();
            }
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity$16$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onError$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1() {
            RubinoProfileActivity.this.isLoadingChannelInfo = false;
        }
    }

    private class ListAdapter extends RecyclerListViewEdited.SelectionAdapter {
        private final Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View profileHeaderView;
            if (i == 1) {
                profileHeaderView = new ProfileHeaderView(this.mContext, RubinoProfileActivity.this.profileObject);
            } else if (i == 3) {
                Context context = this.mContext;
                RubinoProfileActivity rubinoProfileActivity = RubinoProfileActivity.this;
                View linkAndHighlightHorizontalListView = new LinkAndHighlightHorizontalListView(context, rubinoProfileActivity.compositeDisposable, rubinoProfileActivity.profileObject);
                linkAndHighlightHorizontalListView.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
                linkAndHighlightHorizontalListView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(108.0f)));
                profileHeaderView = linkAndHighlightHorizontalListView;
            } else if (i == 7) {
                RubinoEmptyView rubinoEmptyView = new RubinoEmptyView(this.mContext, 17);
                rubinoEmptyView.setData(R.drawable.rubino_private_empty_state_lock, LocaleController.getString(R.string.rubinoPrivateAlert), LocaleController.getString(R.string.rubinoPrivateAlertMoreDetails));
                profileHeaderView = rubinoEmptyView;
            } else if (i == 12) {
                profileHeaderView = new View(this.mContext) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity.ListAdapter.1
                    private int lastPaddingHeight = 0;
                    private int lastListViewHeight = 0;

                    @Override // android.view.View
                    protected void onMeasure(int i2, int i3) {
                        if (this.lastListViewHeight != RubinoProfileActivity.this.listView.getMeasuredHeight()) {
                            this.lastPaddingHeight = 0;
                        }
                        this.lastListViewHeight = RubinoProfileActivity.this.listView.getMeasuredHeight();
                        int childCount = RubinoProfileActivity.this.listView.getChildCount();
                        if (childCount != RubinoProfileActivity.this.listAdapter.getItemCount()) {
                            setMeasuredDimension(RubinoProfileActivity.this.listView.getMeasuredWidth(), this.lastPaddingHeight);
                            return;
                        }
                        int measuredHeight = 0;
                        for (int i4 = 0; i4 < childCount; i4++) {
                            if (RubinoProfileActivity.this.listView.getChildAdapterPosition(RubinoProfileActivity.this.listView.getChildAt(i4)) != RubinoProfileActivity.this.bottomPaddingRow) {
                                measuredHeight += RubinoProfileActivity.this.listView.getChildAt(i4).getMeasuredHeight();
                            }
                        }
                        int measuredHeight2 = ((RubinoProfileActivity.this.fragmentView.getMeasuredHeight() - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.statusBarHeight) - measuredHeight;
                        if (measuredHeight2 > AndroidUtilities.dp(88.0f)) {
                            measuredHeight2 = 0;
                        }
                        int i5 = measuredHeight2 > 0 ? measuredHeight2 : 0;
                        int measuredWidth = RubinoProfileActivity.this.listView.getMeasuredWidth();
                        this.lastPaddingHeight = i5;
                        setMeasuredDimension(measuredWidth, i5);
                    }
                };
            } else if (i != 13) {
                profileHeaderView = null;
            } else {
                if (RubinoProfileActivity.this.postGridLayout.getParent() != null) {
                    ((ViewGroup) RubinoProfileActivity.this.postGridLayout.getParent()).removeView(RubinoProfileActivity.this.postGridLayout);
                }
                profileHeaderView = RubinoProfileActivity.this.postGridLayout;
            }
            if (i != 13 && profileHeaderView != null) {
                profileHeaderView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListViewEdited.Holder(profileHeaderView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView == RubinoProfileActivity.this.postGridLayout) {
                RubinoProfileActivity.this.gridLayoutAttached = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView == RubinoProfileActivity.this.postGridLayout) {
                RubinoProfileActivity.this.gridLayoutAttached = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType != 1) {
                if (itemViewType != 3) {
                    return;
                }
                LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView = (LinkAndHighlightHorizontalListView) viewHolder.itemView;
                linkAndHighlightHorizontalListView.addOrUpdateHighlightList(RubinoProfileActivity.this.highlights, true);
                linkAndHighlightHorizontalListView.addOrUpdateLinkList(RubinoProfileActivity.this.profileLinkItems, true);
                return;
            }
            View view = viewHolder.itemView;
            if (view instanceof ProfileHeaderView) {
                ((ProfileHeaderView) view).setProfile(RubinoProfileActivity.this.profileObject);
                ((ProfileHeaderView) viewHolder.itemView).setData();
                if (RubinoProfileActivity.this.profileObject.isPage()) {
                    RubinoProfileActivity.this.getChannel();
                }
            }
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.itemView instanceof LinkAndHighlightHorizontalListView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoProfileActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == RubinoProfileActivity.this.headerViewRow) {
                return 1;
            }
            if (i == RubinoProfileActivity.this.highlightRow) {
                return 2;
            }
            if (i == RubinoProfileActivity.this.linkItemRow) {
                return 3;
            }
            if (i == RubinoProfileActivity.this.privateRow) {
                return 7;
            }
            if (i == RubinoProfileActivity.this.bottomPaddingRow) {
                return 12;
            }
            return i == RubinoProfileActivity.this.gridRow ? 13 : 0;
        }
    }
}
