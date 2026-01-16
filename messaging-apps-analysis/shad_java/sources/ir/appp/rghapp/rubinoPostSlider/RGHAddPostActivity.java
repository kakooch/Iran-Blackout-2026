package ir.appp.rghapp.rubinoPostSlider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import ir.appp.rghapp.RGHMediaHelper$AlbumEntry;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.RGHMediaHelper$SavedFilterState;
import ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab;
import ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout;
import ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout;
import ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView;
import ir.appp.rghapp.rubinoPostSlider.AddPostHeaderView;
import ir.appp.rghapp.rubinoPostSlider.AddPostPermissionView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.FragmentType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarAnimationType;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Size;

/* loaded from: classes3.dex */
public class RGHAddPostActivity extends BaseFragment {
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$$ExternalSyntheticLambda2
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return RGHAddPostActivity.lambda$static$0(f);
        }
    };
    public static int maxMultiVideoDurationInSecond = 60;
    public static int maxVideoDurationInSecond = 1200;
    public static long minIGTVDuration = 60;
    private TextView actionBarFirstTitle;
    private ActionBarMenuItem actionBarNextItem;
    private ActionBarMenuItem actionBarTitleContainer;
    private AddPostCaptureLayout addPostCaptureLayout;
    private AddPostGridLayout addPostGridLayout;
    private final AddPostPages[] addPostPages;
    private boolean allowScrollToNext;
    private boolean animatingForward;
    private boolean backAnimation;
    private int bottomPaddingRow;
    protected float bottomTabBarScrollProgress;
    private AddPostBottomTab bottomTabLayout;
    private FrameLayout bottomWarningLayout;
    protected TextView dropDown;
    protected ArrayList<RGHMediaHelper$AlbumEntry> dropDownAlbums;
    private ImageView dropDownArrowImageView;
    private ActionBarMenuItem dropDownContainer;
    private Drawable dropDownDrawable;
    private boolean gridLayoutAttached;
    private int gridRow;
    private AddPostHeaderView headerView;
    private int headerViewRow;
    private int initialTab;
    private boolean isInLandscapeMode;
    private int lastMeasuredContentHeight;
    private int lastMeasuredContentWidth;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private int listContentHeight;
    private RecyclerListView listView;
    private boolean maybeStartTracking;
    protected boolean noCameraPermissions;
    protected boolean noGalleryPermissions;
    protected boolean noMicrophonePermissions;
    private int rowCount;
    RecyclerView.SmoothScroller smoothScroller;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private int startedTrackingX;
    private int startedTrackingY;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private VelocityTracker velocityTracker;
    private boolean isTouchedAfterResume = false;
    private boolean canScrollVertically = false;
    private boolean isScrollAnimationRunning = false;
    private boolean abortDisablingScroll = false;
    private boolean enableScrollingAfterIdle = false;
    private boolean disableScrollingAfterIdle = false;
    private boolean smoothAdjustInnerListHeight = false;
    private boolean isChangingPage = false;
    private boolean isInnerListViewReachedBottom = false;
    private boolean isInnerListViewReachedTop = true;
    int currentlyScrollingToIndex = -1;
    int headerViewBottom = 0;
    public int maxSelectedPhotos = 10;
    private final Runnable onScrollAnimationEnds = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$$ExternalSyntheticLambda4
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$1();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    static /* synthetic */ int access$2512(RGHAddPostActivity rGHAddPostActivity, int i) {
        int i2 = rGHAddPostActivity.listContentHeight + i;
        rGHAddPostActivity.listContentHeight = i2;
        return i2;
    }

    public static class AddPostPages extends FrameLayout {
        public static int ADD_POST_GALLERY_PAGE_INDEX = 0;
        public static int ADD_POST_PHOTO_PAGE_INDEX = 1;
        public static int ADD_POST_VIDEO_PAGE_INDEX = 2;
        private int selectedType;

        public AddPostPages(Context context) {
            super(context);
        }
    }

    public RGHAddPostActivity() {
        this.isFullScreen = DimensionHelper.isShowstoryNeedFullScreen();
        this.presentAnimationType = ActionBarAnimationType.DTU;
        this.dismissAnimationType = ActionBarAnimationType.UTD;
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoProfileActivity";
        this.isSmallActionBar = true;
        this.swipeBackEnabled = false;
        this.needLockOrientation = true;
        this.addPostPages = new AddPostPages[2];
        getPermissionStatus();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        AddPostHeaderView addPostHeaderView = this.headerView;
        if (addPostHeaderView != null) {
            addPostHeaderView.onDestroy();
        }
        AddPostGridLayout addPostGridLayout = this.addPostGridLayout;
        if (addPostGridLayout != null) {
            addPostGridLayout.onDestroy();
        }
        AddPostCaptureLayout addPostCaptureLayout = this.addPostCaptureLayout;
        if (addPostCaptureLayout != null) {
            addPostCaptureLayout.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        if (!this.abortDisablingScroll) {
            this.canScrollVertically = false;
        }
        AndroidUtilities.recycleViewSafeSuppressLayout(this.addPostGridLayout.getCurrentListView(), false);
        this.addPostGridLayout.setListViewHeightReduction(this.headerViewBottom);
        this.isScrollAnimationRunning = false;
        this.currentlyScrollingToIndex = -1;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        Theme.createProfileResources(context);
        this.rtlLayout = true;
        this.actionBar.setRtlLayout(true);
        this.hasOwnBackground = true;
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        AddPostBottomTab addPostBottomTab = this.bottomTabLayout;
        if (addPostBottomTab != null) {
            this.initialTab = addPostBottomTab.getCurrentTabId();
        }
        AddPostBottomTab addPostBottomTab2 = new AddPostBottomTab(context);
        this.bottomTabLayout = addPostBottomTab2;
        int i = this.initialTab;
        if (i != -1) {
            addPostBottomTab2.setInitialTabId(i);
            this.initialTab = -1;
        }
        this.bottomTabLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.bottomTabLayout.setColors(Theme.key_rubino_add_post_TabLine, Theme.key_rubino_add_post_TabActiveText, Theme.key_rubino_add_post_TabUnactiveText, Theme.key_rubino_add_post_TabSelector);
        this.bottomTabLayout.setDelegate(new AddPostBottomTab.AddPostBottomTabDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.1
            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.AddPostBottomTabDelegate
            public void onSamePageSelected() {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.AddPostBottomTabDelegate
            public void onPageSelected(int i2, boolean z) {
                if (RGHAddPostActivity.this.addPostPages[0].selectedType != i2) {
                    RGHAddPostActivity.this.isChangingPage = true;
                    RGHAddPostActivity.this.addPostPages[1].selectedType = i2;
                    RGHAddPostActivity.this.addPostPages[1].setVisibility(0);
                    RGHAddPostActivity.this.switchToCurrentSelectedMode();
                    RGHAddPostActivity.this.animatingForward = z;
                    if (i2 == AddPostPages.ADD_POST_GALLERY_PAGE_INDEX) {
                        RGHAddPostActivity rGHAddPostActivity = RGHAddPostActivity.this;
                        if (rGHAddPostActivity.noGalleryPermissions) {
                            rGHAddPostActivity.requestPermission(new AddPostPermissionView.PermissionType[]{AddPostPermissionView.PermissionType.GALLERY});
                        }
                        RGHAddPostActivity.this.updateActionBarTitleText(AddPostPages.ADD_POST_GALLERY_PAGE_INDEX);
                        return;
                    }
                    RGHAddPostActivity rGHAddPostActivity2 = RGHAddPostActivity.this;
                    if (rGHAddPostActivity2.noCameraPermissions || rGHAddPostActivity2.noMicrophonePermissions) {
                        rGHAddPostActivity2.addPostCaptureLayout.requestRequiredPermissions();
                    }
                    int i3 = AddPostPages.ADD_POST_PHOTO_PAGE_INDEX;
                    if (i2 == i3) {
                        RGHAddPostActivity.this.updateActionBarTitleText(i3);
                        RGHAddPostActivity.this.addPostCaptureLayout.setCaptureState(AddPostCaptureLayout.CaptureState.PHOTO);
                        return;
                    }
                    int i4 = AddPostPages.ADD_POST_VIDEO_PAGE_INDEX;
                    if (i2 == i4) {
                        RGHAddPostActivity.this.updateActionBarTitleText(i4);
                        RGHAddPostActivity.this.addPostCaptureLayout.setCaptureState(AddPostCaptureLayout.CaptureState.VIDEO);
                        return;
                    }
                    return;
                }
                if (i2 == AddPostPages.ADD_POST_PHOTO_PAGE_INDEX) {
                    RGHAddPostActivity.this.addPostCaptureLayout.setCaptureState(AddPostCaptureLayout.CaptureState.PHOTO);
                } else if (i2 == AddPostPages.ADD_POST_VIDEO_PAGE_INDEX) {
                    RGHAddPostActivity.this.addPostCaptureLayout.setCaptureState(AddPostCaptureLayout.CaptureState.VIDEO);
                }
                RGHAddPostActivity.this.updateActionBarTitleText(i2);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.AddPostBottomTabDelegate
            public void onPageScrolled(float f) {
                if (f != 1.0f || RGHAddPostActivity.this.addPostPages[1].getVisibility() == 0) {
                    if (!((RGHAddPostActivity.this.addPostPages[0].selectedType != AddPostPages.ADD_POST_GALLERY_PAGE_INDEX && RGHAddPostActivity.this.addPostPages[1].selectedType != AddPostPages.ADD_POST_GALLERY_PAGE_INDEX && (RGHAddPostActivity.this.bottomTabLayout.getCurrentTabId() == AddPostPages.ADD_POST_PHOTO_PAGE_INDEX || RGHAddPostActivity.this.bottomTabLayout.getCurrentTabId() == AddPostPages.ADD_POST_VIDEO_PAGE_INDEX)) && ((RGHAddPostActivity.this.animatingForward && RGHAddPostActivity.this.addPostPages[1].selectedType == AddPostPages.ADD_POST_VIDEO_PAGE_INDEX) || (!RGHAddPostActivity.this.animatingForward && RGHAddPostActivity.this.addPostPages[1].selectedType == AddPostPages.ADD_POST_PHOTO_PAGE_INDEX)))) {
                        if (RGHAddPostActivity.this.animatingForward) {
                            RGHAddPostActivity.this.addPostPages[0].setTranslationX((-f) * RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth());
                            RGHAddPostActivity.this.addPostPages[1].setTranslationX(RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth() - (RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth() * f));
                        } else {
                            RGHAddPostActivity.this.addPostPages[0].setTranslationX(RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth() * f);
                            RGHAddPostActivity.this.addPostPages[1].setTranslationX((RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth() * f) - RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth());
                        }
                        if (f == 1.0f) {
                            AddPostPages addPostPages = RGHAddPostActivity.this.addPostPages[0];
                            RGHAddPostActivity.this.addPostPages[0] = RGHAddPostActivity.this.addPostPages[1];
                            RGHAddPostActivity.this.addPostPages[1] = addPostPages;
                            RGHAddPostActivity.this.addPostPages[1].setVisibility(8);
                        }
                    }
                    if (f == 1.0f) {
                        RGHAddPostActivity.this.isChangingPage = false;
                        RGHAddPostActivity.this.bottomTabBarScrollProgress = 0.0f;
                    }
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.bottomWarningLayout = frameLayout;
        frameLayout.setBackgroundColor(-1);
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString("Photo Limit", R.string.rubinoAddPostSelectionLimitWarning));
        textView.setTypeface(Theme.getRubinoTypeFaceBold());
        textView.setTextSize(1, 14.0f);
        textView.setGravity(17);
        this.bottomWarningLayout.addView(textView, LayoutHelper.createFrame(-1, -1, 17));
        AddPostPages addPostPages = new AddPostPages(context) { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.2
            @Override // android.view.View
            public void setTranslationX(float f) {
                super.setTranslationX(f);
                if (RGHAddPostActivity.this.tabsAnimationInProgress && RGHAddPostActivity.this.addPostPages[0] == this) {
                    RGHAddPostActivity.this.bottomTabLayout.selectTabWithId(RGHAddPostActivity.this.addPostPages[1].selectedType, Math.abs(RGHAddPostActivity.this.addPostPages[0].getTranslationX()) / RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth());
                }
            }
        };
        AddPostHeaderView addPostHeaderView = new AddPostHeaderView(context);
        this.headerView = addPostHeaderView;
        this.headerViewBottom = AndroidUtilities.displayMetrics.widthPixels;
        addPostHeaderView.setDelegate(new AddPostHeaderView.HeaderViewDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.3
            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostHeaderView.HeaderViewDelegate
            public void didPressedSelectionButton() {
                RGHAddPostActivity.this.addPostGridLayout.onSelectionButtonClicked();
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostHeaderView.HeaderViewDelegate
            public void didRequestStoragePermission() {
                RGHAddPostActivity.this.requestPermission(new AddPostPermissionView.PermissionType[]{AddPostPermissionView.PermissionType.GALLERY});
            }
        });
        this.headerView.getMediaView().setDelegate(new AddPostHeaderMediaView.AddPostHeaderMediaViewDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.4
            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.AddPostHeaderMediaViewDelegate
            public void onSingleTapConfirmed() {
                if (!RGHAddPostActivity.this.headerView.getMediaView().getCurrentObject().isVideo || RGHAddPostActivity.this.headerView.getMediaView().getVideoPlayer() == null) {
                    return;
                }
                RGHAddPostActivity.this.pauseVideoPlaybackIfNeeded(!r0.headerView.getMediaView().getVideoPlayer().isPlaying());
            }
        });
        AddPostGridLayout addPostGridLayout = new AddPostGridLayout(context, this, this.headerViewBottom);
        this.addPostGridLayout = addPostGridLayout;
        addPostGridLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        this.addPostGridLayout.setLayoutDelegate(new AddPostGridLayout.AddPostGridLayoutDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.5
            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.AddPostGridLayoutDelegate
            public void onScrolledToLastRow(boolean z) {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.AddPostGridLayoutDelegate
            public void onScrolled(boolean z, boolean z2, boolean z3) {
                if (z2) {
                    if (RGHAddPostActivity.this.headerView.getBottom() == RGHAddPostActivity.this.headerView.getMeasuredHeight()) {
                        RGHAddPostActivity.this.smoothAdjustInnerListHeight = true;
                    }
                } else {
                    RGHAddPostActivity.this.smoothAdjustInnerListHeight = false;
                }
                RGHAddPostActivity.this.isInnerListViewReachedBottom = z2;
                RGHAddPostActivity.this.isInnerListViewReachedTop = z;
                if (!z || RGHAddPostActivity.this.canScrollVertically) {
                    return;
                }
                if (z3 && RGHAddPostActivity.this.addPostGridLayout.getTop() == ActionBar.getCurrentActionBarHeight()) {
                    RGHAddPostActivity.this.enableScrollingAfterIdle = true;
                } else {
                    if (z3) {
                        return;
                    }
                    RGHAddPostActivity.this.abortDisablingScroll = false;
                }
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.AddPostGridLayoutDelegate
            public void onItemSelected(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, boolean z) {
                RGHAddPostActivity.this.headerView.hidePlayAnimation();
                RGHAddPostActivity.this.headerView.updateMediaIfNeeded(rGHMediaHelper$PhotoEntry);
                RGHAddPostActivity.this.bottomWarningLayout.setVisibility(z ? 0 : 8);
                if (RGHAddPostActivity.this.headerViewBottom == ActionBar.getCurrentActionBarHeight()) {
                    RGHAddPostActivity.this.canScrollVertically = true;
                    RGHAddPostActivity.this.disableScrollingAfterIdle = true;
                    RGHAddPostActivity.this.startScrollAnimation(0, false);
                    RGHAddPostActivity rGHAddPostActivity = RGHAddPostActivity.this;
                    rGHAddPostActivity.headerViewBottom = rGHAddPostActivity.headerView.getMeasuredHeight();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        NestedFrameLayout nestedFrameLayout = new NestedFrameLayout(context) { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.6
            private boolean firstLayout = true;
            private boolean ignoreLayout;

            @Override // android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                int iDp = AndroidUtilities.dp(48.0f) + (((BaseFragment) RGHAddPostActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0);
                if (RGHAddPostActivity.this.listView != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) RGHAddPostActivity.this.listView.getLayoutParams();
                    if (layoutParams.topMargin != iDp) {
                        layoutParams.topMargin = iDp;
                    }
                }
                int size = View.MeasureSpec.getSize(i3);
                int size2 = View.MeasureSpec.getSize(i2);
                int paddingTop = size - getPaddingTop();
                if (RGHAddPostActivity.this.addPostGridLayout != null) {
                    RGHAddPostActivity.this.addPostGridLayout.onPreMeasure(size2, paddingTop);
                }
                super.onMeasure(i2, i3);
                if (RGHAddPostActivity.this.lastMeasuredContentWidth != getMeasuredWidth() || RGHAddPostActivity.this.lastMeasuredContentHeight != getMeasuredHeight()) {
                    RGHAddPostActivity.this.listContentHeight = 0;
                    int itemCount = RGHAddPostActivity.this.listAdapter.getItemCount();
                    RGHAddPostActivity.this.lastMeasuredContentWidth = getMeasuredWidth();
                    RGHAddPostActivity.this.lastMeasuredContentHeight = getMeasuredHeight();
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(RGHAddPostActivity.this.listView.getMeasuredHeight(), 0);
                    for (int i4 = 0; i4 < itemCount; i4++) {
                        int itemViewType = RGHAddPostActivity.this.listAdapter.getItemViewType(i4);
                        if (itemViewType != 13) {
                            RecyclerView.ViewHolder viewHolderCreateViewHolder = RGHAddPostActivity.this.listAdapter.createViewHolder(null, itemViewType);
                            RGHAddPostActivity.this.listAdapter.onBindViewHolder(viewHolderCreateViewHolder, i4);
                            viewHolderCreateViewHolder.itemView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            RGHAddPostActivity.access$2512(RGHAddPostActivity.this, viewHolderCreateViewHolder.itemView.getMeasuredHeight());
                        } else {
                            RGHAddPostActivity rGHAddPostActivity = RGHAddPostActivity.this;
                            RGHAddPostActivity.access$2512(rGHAddPostActivity, rGHAddPostActivity.listView.getMeasuredHeight());
                        }
                    }
                }
                if (this.firstLayout) {
                    return;
                }
                this.ignoreLayout = false;
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                super.onLayout(z, i2, i3, i4, i5);
                this.firstLayout = false;
                RGHAddPostActivity.this.checkListViewScroll();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                float xVelocity;
                float yVelocity;
                float measuredWidth;
                int measuredWidth2;
                if (RGHAddPostActivity.this.getParentLayout() == null || RGHAddPostActivity.this.getParentLayout().checkTransitionAnimation() || RGHAddPostActivity.this.checkTabsAnimationInProgress()) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && !RGHAddPostActivity.this.startedTracking && !RGHAddPostActivity.this.maybeStartTracking && motionEvent.getY() >= AndroidUtilities.dp(48.0f) && !RGHAddPostActivity.this.addPostGridLayout.isSelectingMode()) {
                    RGHAddPostActivity.this.startedTrackingPointerId = motionEvent.getPointerId(0);
                    RGHAddPostActivity.this.maybeStartTracking = true;
                    RGHAddPostActivity.this.startedTrackingX = (int) motionEvent.getX();
                    RGHAddPostActivity.this.startedTrackingY = (int) motionEvent.getY();
                    if (RGHAddPostActivity.this.velocityTracker != null) {
                        RGHAddPostActivity.this.velocityTracker.clear();
                    } else {
                        RGHAddPostActivity.this.velocityTracker = VelocityTracker.obtain();
                    }
                } else if (motionEvent.getAction() != 2 || motionEvent.getPointerId(0) != RGHAddPostActivity.this.startedTrackingPointerId) {
                    if (motionEvent.getPointerId(0) == RGHAddPostActivity.this.startedTrackingPointerId && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6)) {
                        if (RGHAddPostActivity.this.velocityTracker == null) {
                            RGHAddPostActivity.this.velocityTracker = VelocityTracker.obtain();
                        }
                        RGHAddPostActivity.this.velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE);
                        if (motionEvent.getAction() == 3 || RGHAddPostActivity.this.velocityTracker == null) {
                            xVelocity = 0.0f;
                            yVelocity = 0.0f;
                        } else {
                            xVelocity = RGHAddPostActivity.this.velocityTracker.getXVelocity();
                            yVelocity = RGHAddPostActivity.this.velocityTracker.getYVelocity();
                            if (!RGHAddPostActivity.this.startedTracking && Math.abs(xVelocity) >= 1000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                                RGHAddPostActivity.this.prepareForMoving(motionEvent, xVelocity < 0.0f);
                            }
                        }
                        if (RGHAddPostActivity.this.startedTracking) {
                            if (RGHAddPostActivity.this.allowScrollToNext) {
                                float x = RGHAddPostActivity.this.addPostPages[0].getX();
                                RGHAddPostActivity.this.backAnimation = Math.abs(x) < ((float) RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity) < 1000.0f || Math.abs(xVelocity) < Math.abs(yVelocity));
                                RGHAddPostActivity.this.tabsAnimation = new AnimatorSet();
                                if (!RGHAddPostActivity.this.backAnimation) {
                                    measuredWidth = RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth() - Math.abs(x);
                                    if (RGHAddPostActivity.this.animatingForward) {
                                        RGHAddPostActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(RGHAddPostActivity.this.addPostPages[0], (Property<AddPostPages, Float>) View.TRANSLATION_X, -RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(RGHAddPostActivity.this.addPostPages[1], (Property<AddPostPages, Float>) View.TRANSLATION_X, 0.0f));
                                    } else {
                                        RGHAddPostActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(RGHAddPostActivity.this.addPostPages[0], (Property<AddPostPages, Float>) View.TRANSLATION_X, RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(RGHAddPostActivity.this.addPostPages[1], (Property<AddPostPages, Float>) View.TRANSLATION_X, 0.0f));
                                    }
                                } else {
                                    measuredWidth = Math.abs(x);
                                    if (RGHAddPostActivity.this.animatingForward) {
                                        RGHAddPostActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(RGHAddPostActivity.this.addPostPages[0], (Property<AddPostPages, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(RGHAddPostActivity.this.addPostPages[1], (Property<AddPostPages, Float>) View.TRANSLATION_X, RGHAddPostActivity.this.addPostPages[1].getMeasuredWidth()));
                                    } else {
                                        RGHAddPostActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(RGHAddPostActivity.this.addPostPages[0], (Property<AddPostPages, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(RGHAddPostActivity.this.addPostPages[1], (Property<AddPostPages, Float>) View.TRANSLATION_X, -RGHAddPostActivity.this.addPostPages[1].getMeasuredWidth()));
                                    }
                                }
                                RGHAddPostActivity.this.tabsAnimation.setInterpolator(RGHAddPostActivity.interpolator);
                                int measuredWidth3 = getMeasuredWidth();
                                float f = measuredWidth3 / 2;
                                float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                                float fAbs = Math.abs(xVelocity);
                                if (fAbs > 0.0f) {
                                    measuredWidth2 = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / fAbs) * 1000.0f) * 4;
                                } else {
                                    measuredWidth2 = (int) (((measuredWidth / getMeasuredWidth()) + 1.0f) * 100.0f);
                                }
                                RGHAddPostActivity.this.tabsAnimation.setDuration(Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min(measuredWidth2, 600)));
                                RGHAddPostActivity.this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.6.1
                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animator) {
                                        RGHAddPostActivity.this.tabsAnimation = null;
                                        if (RGHAddPostActivity.this.backAnimation) {
                                            RGHAddPostActivity.this.addPostPages[1].setVisibility(8);
                                        } else {
                                            AddPostPages addPostPages2 = RGHAddPostActivity.this.addPostPages[0];
                                            RGHAddPostActivity.this.addPostPages[0] = RGHAddPostActivity.this.addPostPages[1];
                                            RGHAddPostActivity.this.addPostPages[1] = addPostPages2;
                                            RGHAddPostActivity.this.addPostPages[1].setVisibility(8);
                                            RGHAddPostActivity.this.bottomTabLayout.selectTabWithId(RGHAddPostActivity.this.addPostPages[0].selectedType, 1.0f);
                                            RGHAddPostActivity rGHAddPostActivity = RGHAddPostActivity.this;
                                            rGHAddPostActivity.updateActionBarTitleText(rGHAddPostActivity.addPostPages[0].selectedType);
                                        }
                                        RGHAddPostActivity.this.tabsAnimationInProgress = false;
                                        RGHAddPostActivity.this.maybeStartTracking = false;
                                        RGHAddPostActivity.this.startedTracking = false;
                                        RGHAddPostActivity.this.allowScrollToNext = false;
                                        ((BaseFragment) RGHAddPostActivity.this).actionBar.setEnabled(true);
                                        RGHAddPostActivity.this.bottomTabLayout.setEnabled(true);
                                    }
                                });
                                RGHAddPostActivity.this.tabsAnimation.start();
                                RGHAddPostActivity.this.tabsAnimationInProgress = true;
                            } else {
                                if (!(Math.abs(xVelocity) > 1000.0f || ((double) RGHAddPostActivity.this.bottomTabBarScrollProgress) >= 0.3d)) {
                                    RGHAddPostActivity.this.bottomTabLayout.resetTabIndicatorToCurrentPage(RGHAddPostActivity.this.addPostPages[1].selectedType, RGHAddPostActivity.this.bottomTabBarScrollProgress);
                                } else {
                                    RGHAddPostActivity.this.bottomTabLayout.selectTabWithAnimation(RGHAddPostActivity.this.addPostPages[1].selectedType);
                                    RGHAddPostActivity rGHAddPostActivity = RGHAddPostActivity.this;
                                    rGHAddPostActivity.updateActionBarTitleText(rGHAddPostActivity.addPostPages[1].selectedType);
                                }
                                RGHAddPostActivity rGHAddPostActivity2 = RGHAddPostActivity.this;
                                rGHAddPostActivity2.bottomTabBarScrollProgress = 0.0f;
                                rGHAddPostActivity2.tabsAnimationInProgress = false;
                                RGHAddPostActivity.this.maybeStartTracking = false;
                                RGHAddPostActivity.this.startedTracking = false;
                                RGHAddPostActivity.this.allowScrollToNext = false;
                                ((BaseFragment) RGHAddPostActivity.this).actionBar.setEnabled(true);
                                RGHAddPostActivity.this.bottomTabLayout.setEnabled(true);
                            }
                            RGHAddPostActivity rGHAddPostActivity3 = RGHAddPostActivity.this;
                            rGHAddPostActivity3.bottomTabBarScrollProgress = 0.0f;
                            rGHAddPostActivity3.startedTracking = false;
                        } else {
                            RGHAddPostActivity rGHAddPostActivity4 = RGHAddPostActivity.this;
                            rGHAddPostActivity4.bottomTabBarScrollProgress = 0.0f;
                            rGHAddPostActivity4.maybeStartTracking = false;
                            RGHAddPostActivity.this.allowScrollToNext = false;
                            ((BaseFragment) RGHAddPostActivity.this).actionBar.setEnabled(true);
                            RGHAddPostActivity.this.bottomTabLayout.setEnabled(true);
                        }
                        if (RGHAddPostActivity.this.velocityTracker != null) {
                            RGHAddPostActivity.this.velocityTracker.recycle();
                            RGHAddPostActivity.this.velocityTracker = null;
                        }
                    }
                } else {
                    if (RGHAddPostActivity.this.addPostCaptureLayout.getCaptureState() == AddPostCaptureLayout.CaptureState.RECORDING) {
                        return false;
                    }
                    if (RGHAddPostActivity.this.velocityTracker != null) {
                        RGHAddPostActivity.this.velocityTracker.addMovement(motionEvent);
                    }
                    int x2 = (int) (motionEvent.getX() - RGHAddPostActivity.this.startedTrackingX);
                    int iAbs = Math.abs(((int) motionEvent.getY()) - RGHAddPostActivity.this.startedTrackingY);
                    if (RGHAddPostActivity.this.startedTracking && ((RGHAddPostActivity.this.animatingForward && x2 > 0) || (!RGHAddPostActivity.this.animatingForward && x2 < 0))) {
                        if (!RGHAddPostActivity.this.prepareForMoving(motionEvent, x2 < 0)) {
                            RGHAddPostActivity.this.maybeStartTracking = true;
                            RGHAddPostActivity.this.startedTracking = false;
                            RGHAddPostActivity.this.addPostPages[0].setTranslationX(0.0f);
                            RGHAddPostActivity.this.addPostPages[1].setTranslationX(RGHAddPostActivity.this.animatingForward ? RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth() : -RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth());
                            RGHAddPostActivity.this.bottomTabLayout.selectTabWithId(RGHAddPostActivity.this.addPostPages[1].selectedType, 0.0f);
                        }
                    }
                    if (!RGHAddPostActivity.this.maybeStartTracking || RGHAddPostActivity.this.startedTracking) {
                        if (RGHAddPostActivity.this.startedTracking) {
                            if (RGHAddPostActivity.this.allowScrollToNext) {
                                RGHAddPostActivity.this.addPostPages[0].setTranslationX(x2);
                                if (RGHAddPostActivity.this.animatingForward) {
                                    RGHAddPostActivity.this.addPostPages[1].setTranslationX(RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth() + x2);
                                } else {
                                    RGHAddPostActivity.this.addPostPages[1].setTranslationX(x2 - RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth());
                                }
                            }
                            RGHAddPostActivity.this.bottomTabBarScrollProgress = Math.abs(x2) / RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth();
                            RGHAddPostActivity.this.bottomTabLayout.selectTabWithId(RGHAddPostActivity.this.addPostPages[1].selectedType, RGHAddPostActivity.this.bottomTabBarScrollProgress);
                        }
                    } else if (Math.abs(x2) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x2) > iAbs) {
                        RGHAddPostActivity.this.prepareForMoving(motionEvent, x2 < 0);
                    }
                }
                return RGHAddPostActivity.this.startedTracking;
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return (RGHAddPostActivity.this.checkTabsAnimationInProgress() || RGHAddPostActivity.this.bottomTabLayout.isAnimatingIndicator() || onTouchEvent(motionEvent)) && RGHAddPostActivity.this.addPostCaptureLayout.getCaptureState() != AddPostCaptureLayout.CaptureState.RECORDING;
            }
        };
        this.fragmentView = nestedFrameLayout;
        NestedFrameLayout nestedFrameLayout2 = nestedFrameLayout;
        nestedFrameLayout2.setClipToPadding(false);
        nestedFrameLayout2.setClipChildren(false);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.7
            private final Paint paint = new Paint();
            private int startY = Integer.MIN_VALUE;
            private boolean considerPreventingScroll = false;

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView
            protected boolean allowSelectChildAtPosition(View view) {
                return false;
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView, android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            public void onDraw(Canvas canvas) {
                int unused = RGHAddPostActivity.this.gridRow;
                int measuredHeight = getMeasuredHeight();
                this.paint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), measuredHeight, this.paint);
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
            
                if (r0.listView.getScrollState() != 1) goto L14;
             */
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
                /*
                    r3 = this;
                    ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity r0 = ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.this
                    boolean r0 = ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.access$4300(r0)
                    if (r0 != 0) goto L33
                    ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity r0 = ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.this
                    boolean r0 = ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.access$1300(r0)
                    if (r0 != 0) goto L33
                    ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity r0 = ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.this
                    boolean r0 = ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.access$1400(r0)
                    if (r0 == 0) goto L2e
                    ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity r0 = ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.this
                    int r1 = r0.headerViewBottom
                    android.util.DisplayMetrics r2 = org.rbmain.messenger.AndroidUtilities.displayMetrics
                    int r2 = r2.widthPixels
                    if (r1 != r2) goto L2e
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListView r0 = ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.access$2200(r0)
                    int r0 = r0.getScrollState()
                    r1 = 1
                    if (r0 == r1) goto L2e
                    goto L33
                L2e:
                    boolean r4 = super.onInterceptTouchEvent(r4)
                    goto L34
                L33:
                    r4 = 0
                L34:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.AnonymousClass7.onInterceptTouchEvent(android.view.MotionEvent):boolean");
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                RGHAddPostActivity.this.isTouchedAfterResume = true;
                int y = (int) motionEvent.getY();
                if (this.startY == Integer.MIN_VALUE && action != 1 && action != 3) {
                    this.startY = y;
                    if (y < RGHAddPostActivity.this.headerView.getBottom() && RGHAddPostActivity.this.headerView.getBottom() > ActionBar.getCurrentActionBarHeight()) {
                        this.considerPreventingScroll = true;
                    }
                }
                if (action == 0 && !this.considerPreventingScroll) {
                    if (RGHAddPostActivity.this.velocityTracker == null) {
                        RGHAddPostActivity.this.velocityTracker = VelocityTracker.obtain();
                    } else {
                        RGHAddPostActivity.this.velocityTracker.clear();
                    }
                } else {
                    if (action == 2 && !this.considerPreventingScroll) {
                        if (RGHAddPostActivity.this.velocityTracker == null) {
                            RGHAddPostActivity.this.velocityTracker = VelocityTracker.obtain();
                        }
                        RGHAddPostActivity.this.velocityTracker.addMovement(motionEvent);
                        if (RGHAddPostActivity.this.canScrollVertically) {
                            if (RGHAddPostActivity.this.smoothAdjustInnerListHeight) {
                                RGHAddPostActivity.this.addPostGridLayout.setListViewHeightReduction((RGHAddPostActivity.this.headerView.getMeasuredHeight() - (RGHAddPostActivity.this.headerView.getMeasuredHeight() - RGHAddPostActivity.this.headerView.getBottom())) - AndroidUtilities.dp(10.0f));
                            }
                        } else {
                            RGHAddPostActivity rGHAddPostActivity = RGHAddPostActivity.this;
                            rGHAddPostActivity.canScrollVertically = y < rGHAddPostActivity.headerView.getBottom();
                            if (RGHAddPostActivity.this.canScrollVertically) {
                                RGHAddPostActivity rGHAddPostActivity2 = RGHAddPostActivity.this;
                                rGHAddPostActivity2.headerViewBottom = rGHAddPostActivity2.headerView.getBottom();
                                if (!RGHAddPostActivity.this.smoothAdjustInnerListHeight) {
                                    RGHAddPostActivity.this.addPostGridLayout.setListViewHeightReduction(ActionBar.getCurrentActionBarHeight());
                                }
                            }
                        }
                    } else if (action == 1 || action == 3) {
                        if (RGHAddPostActivity.this.velocityTracker == null) {
                            RGHAddPostActivity.this.velocityTracker = VelocityTracker.obtain();
                        }
                        RGHAddPostActivity.this.velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE);
                        if (this.considerPreventingScroll) {
                            this.considerPreventingScroll = false;
                        }
                        if (RGHAddPostActivity.this.canScrollVertically) {
                            float yVelocity = RGHAddPostActivity.this.velocityTracker.getYVelocity();
                            int i2 = (RGHAddPostActivity.this.addPostGridLayout.isListFullyVisible() || (Math.abs(yVelocity) <= 1200.0f ? ((float) RGHAddPostActivity.this.headerView.getBottom()) >= ((float) ((((BaseFragment) RGHAddPostActivity.this).actionBar != null ? ActionBar.getCurrentActionBarHeight() : 0) + RGHAddPostActivity.this.headerView.getMeasuredHeight())) / 2.0f : yVelocity >= 0.0f)) ? 0 : 1;
                            this.startY = Integer.MIN_VALUE;
                            if (RGHAddPostActivity.this.velocityTracker != null) {
                                RGHAddPostActivity.this.velocityTracker.recycle();
                                RGHAddPostActivity.this.velocityTracker = null;
                            }
                            if (i2 == 1) {
                                RGHAddPostActivity.this.addPostGridLayout.setListViewHeightReduction(ActionBar.getCurrentActionBarHeight());
                                RGHAddPostActivity.this.headerViewBottom = ActionBar.getCurrentActionBarHeight();
                            } else {
                                RGHAddPostActivity.this.abortDisablingScroll = false;
                                RGHAddPostActivity rGHAddPostActivity3 = RGHAddPostActivity.this;
                                rGHAddPostActivity3.headerViewBottom = rGHAddPostActivity3.headerView.getMeasuredHeight();
                                RGHAddPostActivity.this.smoothAdjustInnerListHeight = false;
                            }
                            RGHAddPostActivity.this.startScrollAnimation(i2, true);
                            return true;
                        }
                        if (this.startY < ActionBar.getCurrentActionBarHeight() && RGHAddPostActivity.this.headerView.getBottom() <= ActionBar.getCurrentActionBarHeight()) {
                            this.startY = Integer.MIN_VALUE;
                            if (RGHAddPostActivity.this.velocityTracker != null) {
                                RGHAddPostActivity.this.velocityTracker.recycle();
                                RGHAddPostActivity.this.velocityTracker = null;
                            }
                            RGHAddPostActivity.this.canScrollVertically = true;
                            RGHAddPostActivity.this.abortDisablingScroll = false;
                            RGHAddPostActivity rGHAddPostActivity4 = RGHAddPostActivity.this;
                            rGHAddPostActivity4.headerViewBottom = rGHAddPostActivity4.headerView.getMeasuredHeight();
                            RGHAddPostActivity.this.smoothAdjustInnerListHeight = false;
                            RGHAddPostActivity.this.startScrollAnimation(0, true);
                            return true;
                        }
                        this.startY = Integer.MIN_VALUE;
                        if (!RGHAddPostActivity.this.abortDisablingScroll) {
                            RGHAddPostActivity.this.canScrollVertically = false;
                        }
                        if (RGHAddPostActivity.this.velocityTracker != null) {
                            RGHAddPostActivity.this.velocityTracker.recycle();
                            RGHAddPostActivity.this.velocityTracker = null;
                        }
                    }
                }
                if (this.considerPreventingScroll) {
                    return true;
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        this.listView = recyclerListView;
        ViewCompat.setLayoutDirection(recyclerListView, 0);
        ViewCompat.setLayoutDirection(this.bottomTabLayout, 0);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setClipToPadding(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.8
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
                if (RGHAddPostActivity.this.isTouchedAfterResume && RGHAddPostActivity.this.canScrollVertically) {
                    return super.scrollVerticallyBy(i2, recycler, state);
                }
                return 0;
            }
        };
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.listView.setLayoutManager(this.layoutManager);
        this.smoothScroller = new RGHSmoothScroller(this, context) { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.9
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDyToMakeVisible(View view, int i2) {
                return super.calculateDyToMakeVisible(view, i2) + ActionBar.getCurrentActionBarHeight();
            }
        };
        this.listView.setAdapter(this.listAdapter);
        addPostPages.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            try {
                listAdapter.notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }
        needLayout();
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.10
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 0) {
                    if (RGHAddPostActivity.this.isScrollAnimationRunning) {
                        AndroidUtilities.runOnUIThread(RGHAddPostActivity.this.onScrollAnimationEnds);
                    }
                    if (RGHAddPostActivity.this.enableScrollingAfterIdle) {
                        RGHAddPostActivity.this.enableScrollingAfterIdle = false;
                        RGHAddPostActivity.this.abortDisablingScroll = true;
                        RGHAddPostActivity.this.canScrollVertically = true;
                    } else if (RGHAddPostActivity.this.disableScrollingAfterIdle) {
                        RGHAddPostActivity.this.addPostGridLayout.setListViewHeightReduction(RGHAddPostActivity.this.headerViewBottom);
                        RGHAddPostActivity.this.disableScrollingAfterIdle = false;
                        RGHAddPostActivity.this.canScrollVertically = false;
                        RGHAddPostActivity.this.abortDisablingScroll = false;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                RGHAddPostActivity.this.checkListViewScroll();
            }
        });
        this.listView.setBackgroundColor(context.getResources().getColor(R.color.grey_50));
        if (!this.noGalleryPermissions || Build.VERSION.SDK_INT < 23) {
            this.headerView.togglePermissionView(false);
            this.actionBarNextItem.setVisibility(0);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createView$2();
                }
            }, 200L);
        } else {
            try {
                this.actionBarNextItem.setVisibility(8);
                this.headerView.togglePermissionView(true);
                requestPermission(new AddPostPermissionView.PermissionType[]{AddPostPermissionView.PermissionType.GALLERY});
            } catch (Exception unused2) {
            }
        }
        updateRowsIds();
        nestedFrameLayout2.addView(addPostPages, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        this.addPostPages[AddPostPages.ADD_POST_GALLERY_PAGE_INDEX] = addPostPages;
        AddPostPages addPostPages2 = new AddPostPages(context) { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.11
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.View
            public void setTranslationX(float f) {
                super.setTranslationX(f);
                if (RGHAddPostActivity.this.tabsAnimationInProgress && RGHAddPostActivity.this.addPostPages[0] == this) {
                    RGHAddPostActivity.this.bottomTabLayout.selectTabWithId(RGHAddPostActivity.this.addPostPages[1].selectedType, Math.abs(RGHAddPostActivity.this.addPostPages[0].getTranslationX()) / RGHAddPostActivity.this.addPostPages[0].getMeasuredWidth());
                }
            }
        };
        AddPostCaptureLayout addPostCaptureLayout = new AddPostCaptureLayout(context, this);
        this.addPostCaptureLayout = addPostCaptureLayout;
        addPostCaptureLayout.setCaptureLayoutDelegate(new AddPostCaptureLayout.CaptureLayoutDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.12
            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout.CaptureLayoutDelegate
            public void onStartRecording() {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout.CaptureLayoutDelegate
            public void onCaptureMedia(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
                rGHMediaHelper$PhotoEntry.savedFilterState = new RGHMediaHelper$SavedFilterState();
                VideoEditedInfo videoEditedInfo = new VideoEditedInfo();
                rGHMediaHelper$PhotoEntry.editedInfo = videoEditedInfo;
                videoEditedInfo.cropState = new MediaController.CropState();
                Size cameraViewSize = RGHAddPostActivity.this.addPostCaptureLayout.getCameraViewSize();
                MediaController.getInstance().setLockRatio(true);
                float rubinoContainerViewHeight = (MediaController.getRubinoContainerViewHeight() - cameraViewSize.height) / 2.0f;
                float rubinoContainerViewWidth = (MediaController.getRubinoContainerViewWidth() - cameraViewSize.width) / 2.0f;
                MediaController.getInstance().setAddPostCropArea(rubinoContainerViewWidth, rubinoContainerViewHeight, cameraViewSize.width + rubinoContainerViewWidth, cameraViewSize.height + rubinoContainerViewHeight);
                MediaController.setMediaInfo(rGHMediaHelper$PhotoEntry);
                MediaController.setSavedCropStateOnPhotoEntry(rGHMediaHelper$PhotoEntry, 1.0f, 1.0f, 1.0f, cameraViewSize.width, cameraViewSize.height);
                RGHAddPostActivity.this.presentFragment(new SSHPostActivity(0, rGHMediaHelper$PhotoEntry, null), true);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout.CaptureLayoutDelegate
            public void onStateChangedFromPhotoToVideo() {
                RGHAddPostActivity.this.tabsAnimationInProgress = true;
                if (RGHAddPostActivity.this.bottomTabLayout != null) {
                    RGHAddPostActivity.this.bottomTabLayout.selectTabWithAnimation(AddPostPages.ADD_POST_VIDEO_PAGE_INDEX);
                    RGHAddPostActivity.this.tabsAnimationInProgress = false;
                }
            }
        });
        addPostPages2.addView(this.addPostCaptureLayout, LayoutHelper.createFrame(-1, -1.0f));
        nestedFrameLayout2.addView(addPostPages2, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 48.0f, 0.0f, 48.0f));
        AddPostPages[] addPostPagesArr = this.addPostPages;
        int i2 = AddPostPages.ADD_POST_PHOTO_PAGE_INDEX;
        addPostPagesArr[i2] = addPostPages2;
        addPostPagesArr[i2].setVisibility(8);
        nestedFrameLayout2.addView(this.bottomTabLayout, LayoutHelper.createFrame(-1, 48, 83));
        nestedFrameLayout2.addView(this.bottomWarningLayout, LayoutHelper.createFrame(-1, 48, 80));
        this.bottomWarningLayout.setVisibility(8);
        updateTabs();
        nestedFrameLayout2.addView(this.actionBar);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2() {
        this.addPostGridLayout.loadGalleryPhotosAlbums(0);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i == AddPostPermissionView.permission_request_code_gallery) {
            checkStorageAndLoadGallery();
        } else if (i == AddPostPermissionView.permission_request_code_camera) {
            checkCameraAndMicrophone();
        }
        super.onRequestPermissionsResultFragment(i, strArr, iArr);
    }

    protected void requestPermission(AddPostPermissionView.PermissionType[] permissionTypeArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            for (AddPostPermissionView.PermissionType permissionType : permissionTypeArr) {
                if (permissionType == AddPostPermissionView.PermissionType.GALLERY) {
                    arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                } else if (permissionType == AddPostPermissionView.PermissionType.CAMERA) {
                    arrayList.add("android.permission.CAMERA");
                } else if (permissionType == AddPostPermissionView.PermissionType.AUDIO) {
                    arrayList.add("android.permission.RECORD_AUDIO");
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (arrayList.contains("android.permission.READ_EXTERNAL_STORAGE")) {
                getParentActivity().requestPermissions(strArr, AddPostPermissionView.permission_request_code_gallery);
            } else {
                getParentActivity().requestPermissions(strArr, AddPostPermissionView.permission_request_code_camera);
            }
        }
    }

    private void getPermissionStatus() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.noCameraPermissions = ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") != 0;
            this.noGalleryPermissions = ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0;
            this.noMicrophonePermissions = ContextCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") != 0;
        } else {
            this.noCameraPermissions = false;
            this.noGalleryPermissions = false;
            this.noMicrophonePermissions = false;
        }
    }

    private void checkStorageAndLoadGallery() {
        if (this.noGalleryPermissions) {
            getPermissionStatus();
            if (this.noGalleryPermissions) {
                return;
            }
            this.actionBarNextItem.setVisibility(0);
            this.headerView.togglePermissionView(false);
            this.addPostGridLayout.loadGalleryPhotosAlbums(0);
        }
    }

    private void checkCameraAndMicrophone() {
        if (this.noCameraPermissions || this.noMicrophonePermissions) {
            getPermissionStatus();
            if (this.noCameraPermissions || this.noMicrophonePermissions) {
                return;
            }
            this.addPostCaptureLayout.togglePermissionView(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideoPlaybackIfNeeded(boolean z) {
        AddPostHeaderView addPostHeaderView = this.headerView;
        if (addPostHeaderView == null || addPostHeaderView.getMediaView() == null || this.headerView.getMediaView().getCurrentObject() == null || !this.headerView.getMediaView().getCurrentObject().isVideo || this.headerView.getMediaView().getVideoPlayer() == null) {
            return;
        }
        if (!z) {
            this.headerView.getPlayButton().setIsVisible(true, true);
            this.headerView.getMediaView().getVideoPlayer().pause();
        } else {
            this.headerView.getMediaView().getVideoPlayer().play();
            this.headerView.getPlayButton().setIsVisible(false, true);
        }
    }

    public void updateAlbumsDropDown() {
        this.dropDownContainer.removeAllSubItems();
        final ArrayList<RGHMediaHelper$AlbumEntry> arrayList = this.addPostGridLayout.allMediaAlbums;
        ArrayList<RGHMediaHelper$AlbumEntry> arrayList2 = new ArrayList<>(arrayList);
        this.dropDownAlbums = arrayList2;
        Collections.sort(arrayList2, new Comparator() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$$ExternalSyntheticLambda5
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RGHAddPostActivity.lambda$updateAlbumsDropDown$3(arrayList, (RGHMediaHelper$AlbumEntry) obj, (RGHMediaHelper$AlbumEntry) obj2);
            }
        });
        if (this.dropDownAlbums.isEmpty()) {
            this.dropDownArrowImageView.setVisibility(8);
            return;
        }
        this.dropDownArrowImageView.setVisibility(0);
        int size = this.dropDownAlbums.size();
        for (int i = 0; i < size; i++) {
            this.dropDownContainer.addSubItem(i + 10, this.dropDownAlbums.get(i).bucketName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$updateAlbumsDropDown$3(ArrayList arrayList, RGHMediaHelper$AlbumEntry rGHMediaHelper$AlbumEntry, RGHMediaHelper$AlbumEntry rGHMediaHelper$AlbumEntry2) {
        int iIndexOf;
        int iIndexOf2;
        int i = rGHMediaHelper$AlbumEntry.bucketId;
        if (i == 0 && rGHMediaHelper$AlbumEntry2.bucketId != 0) {
            return -1;
        }
        if ((i == 0 || rGHMediaHelper$AlbumEntry2.bucketId != 0) && (iIndexOf = arrayList.indexOf(rGHMediaHelper$AlbumEntry)) <= (iIndexOf2 = arrayList.indexOf(rGHMediaHelper$AlbumEntry2))) {
            return iIndexOf < iIndexOf2 ? -1 : 0;
        }
        return 1;
    }

    public void updateUIAccordingToSelectionMode() {
        this.bottomTabLayout.setVisibility(this.addPostGridLayout.isSelectingMode() ? 0 : 4);
        if (this.addPostGridLayout.isSelectingMode() && this.bottomWarningLayout.getVisibility() == 0) {
            this.bottomWarningLayout.setVisibility(8);
        }
        this.headerView.updateMultiSelectButtonBackground();
        this.headerView.shouldLockContainer(!this.addPostGridLayout.isSelectingMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActionBarTitleText(int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        if (i == 0) {
            this.dropDownContainer.setAlpha(1.0f);
            this.actionBarTitleContainer.setAlpha(0.0f);
            this.actionBarFirstTitle.setAlpha(0.0f);
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.actionBarNextItem, "alpha", 1.0f));
            pauseVideoPlaybackIfNeeded(true);
        } else {
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.actionBarNextItem, "alpha", 0.0f));
            if (i == AddPostPages.ADD_POST_PHOTO_PAGE_INDEX) {
                this.actionBarFirstTitle.setText(LocaleController.getString("Photo", R.string.rubinoAddPostBottomTabPhoto));
                this.dropDownContainer.setAlpha(0.0f);
                this.actionBarTitleContainer.setAlpha(1.0f);
                this.actionBarFirstTitle.setAlpha(1.0f);
            } else if (i == AddPostPages.ADD_POST_VIDEO_PAGE_INDEX) {
                this.actionBarFirstTitle.setText(LocaleController.getString("Video", R.string.rubinoAddPostBottomTabVideo));
                this.dropDownContainer.setAlpha(0.0f);
                this.actionBarTitleContainer.setAlpha(1.0f);
                this.actionBarFirstTitle.setAlpha(1.0f);
            }
            pauseVideoPlaybackIfNeeded(false);
        }
        animatorSet.start();
    }

    private TextView initiateActionBarTitleTextViews(TextView textView, Context context) {
        TextView textView2 = new TextView(context);
        textView2.setGravity(3);
        textView2.setSingleLine(true);
        textView2.setLines(1);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        textView2.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView2.setTextSize(1, 16.0f);
        textView2.setPadding(0, 0, AndroidUtilities.dp(4.0f), 0);
        return textView2;
    }

    private void updateTabs() {
        AddPostBottomTab addPostBottomTab = this.bottomTabLayout;
        if (addPostBottomTab == null) {
            return;
        }
        addPostBottomTab.removeTabs();
        if (!this.bottomTabLayout.hasTab(AddPostPages.ADD_POST_GALLERY_PAGE_INDEX)) {
            this.bottomTabLayout.addTextTab(AddPostPages.ADD_POST_GALLERY_PAGE_INDEX, LocaleController.getString("Gallery", R.string.rubinoAddPostBottomTabGallery));
        }
        if (!this.bottomTabLayout.hasTab(AddPostPages.ADD_POST_PHOTO_PAGE_INDEX)) {
            this.bottomTabLayout.addTextTab(AddPostPages.ADD_POST_PHOTO_PAGE_INDEX, LocaleController.getString("Photo", R.string.rubinoAddPostBottomTabPhoto));
        }
        if (!this.bottomTabLayout.hasTab(AddPostPages.ADD_POST_VIDEO_PAGE_INDEX)) {
            this.bottomTabLayout.addTextTab(AddPostPages.ADD_POST_VIDEO_PAGE_INDEX, LocaleController.getString("Video", R.string.rubinoAddPostBottomTabVideo));
        }
        this.bottomTabLayout.finishAddingTabs();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBarCreateActionBar = super.createActionBar(context);
        actionBarCreateActionBar.setCastShadows(false);
        actionBarCreateActionBar.setAddToContainer(false);
        actionBarCreateActionBar.isSmallActionBar = this.isSmallActionBar;
        actionBarCreateActionBar.setBackButtonImage(R.drawable.ic_close_white);
        ActionBarMenu actionBarMenuCreateMenu = actionBarCreateActionBar.createMenu();
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, actionBarMenuCreateMenu, 0, 0);
        this.actionBarTitleContainer = actionBarMenuItem;
        actionBarMenuItem.setRtlLayout(this.rtlLayout);
        actionBarCreateActionBar.addView(this.actionBarTitleContainer, 2, LayoutHelper.createFrame(-2, -1.0f, 53, 40.0f, 0.0f, AndroidUtilities.isTablet() ? 64.0f : 56.0f, 0.0f));
        TextView textViewInitiateActionBarTitleTextViews = initiateActionBarTitleTextViews(this.actionBarFirstTitle, context);
        this.actionBarFirstTitle = textViewInitiateActionBarTitleTextViews;
        textViewInitiateActionBarTitleTextViews.setAlpha(0.0f);
        this.actionBarTitleContainer.addView(this.actionBarFirstTitle, LayoutHelper.createFrame(-2, -2.0f, 16, 4.0f, 0.0f, 0.0f, 0.0f));
        ActionBarMenuItem actionBarMenuItem2 = new ActionBarMenuItem(context, actionBarMenuCreateMenu, 0, 0);
        this.dropDownContainer = actionBarMenuItem2;
        actionBarMenuItem2.setRtlLayout(this.rtlLayout);
        this.dropDownContainer.setSubMenuOpenSide(0);
        actionBarCreateActionBar.addView(this.dropDownContainer, 0, LayoutHelper.createFrame(-2, -1.0f, 53, 40.0f, 0.0f, AndroidUtilities.isTablet() ? 64.0f : 56.0f, 0.0f));
        this.dropDownContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createActionBar$4(view);
            }
        });
        TextView textViewInitiateActionBarTitleTextViews2 = initiateActionBarTitleTextViews(this.dropDown, context);
        this.dropDown = textViewInitiateActionBarTitleTextViews2;
        textViewInitiateActionBarTitleTextViews2.setText(LocaleController.getString("Gallery", R.string.rubinoAddPostBottomTabGallery));
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.ic_arrow_drop_down).mutate();
        this.dropDownDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_rubinoBlackColor), PorterDuff.Mode.MULTIPLY));
        ImageView imageView = new ImageView(context);
        this.dropDownArrowImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dropDownArrowImageView.setImageDrawable(this.dropDownDrawable);
        this.dropDownArrowImageView.setPadding(0, 0, 0, AndroidUtilities.dp(1.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(this.dropDown);
        linearLayout.addView(this.dropDownArrowImageView);
        ViewCompat.setLayoutDirection(linearLayout, 1);
        this.dropDownContainer.addView(linearLayout, LayoutHelper.createFrame(-2, -2.0f, 16, 0.0f, 0.0f, 4.0f, 0.0f));
        this.dropDownContainer.setPopupItemsColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem), false);
        this.dropDownContainer.redrawPopup(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground));
        Theme.setDrawableColor(this.dropDownDrawable, Theme.getColor(Theme.key_dialogTextBlack));
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(2, LocaleController.getString("NEXT", R.string.rubinoActionNext));
        this.actionBarNextItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.actionBarNextItem.textView.setTextColor(ContextCompat.getColor(context, R.color.rubino_blue));
        actionBarCreateActionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.14
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1 || i == 1) {
                    if (RGHAddPostActivity.this.headerView != null) {
                        RGHAddPostActivity.this.headerView.onPause();
                    }
                    RGHAddPostActivity.this.finishFragment(true);
                } else {
                    if (i != 2) {
                        RGHAddPostActivity.this.addPostGridLayout.updateSelectedPhotoBucket(i);
                        return;
                    }
                    RGHAddPostActivity.this.headerView.onPause();
                    RGHAddPostActivity rGHAddPostActivity = RGHAddPostActivity.this;
                    rGHAddPostActivity.showMaxVideoSizeDialogIfNeeded(rGHAddPostActivity.addPostGridLayout.getSelectedPhotos().values());
                }
            }
        });
        actionBarCreateActionBar.setRtlLayout(this.rtlLayout);
        return actionBarCreateActionBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createActionBar$4(View view) {
        this.dropDownContainer.toggleSubMenu();
    }

    private void onNext() {
        if (this.addPostGridLayout.getSelectedPhotos().values().size() <= 1) {
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.headerView.getMediaView().currentObject;
            if (rGHMediaHelper$PhotoEntry != null) {
                if (!MediaController.getInstance().isLockRatio()) {
                    this.headerView.getMediaView().lockContainerRatio();
                }
                rGHMediaHelper$PhotoEntry.cropState.reset(MediaController.getInstance().getAddPostCropArea(), Math.max(1.0f, rGHMediaHelper$PhotoEntry.editedInfo.cropState.scale), 0.0f, false);
                presentFragment(new SSHPostActivity(rGHMediaHelper$PhotoEntry.imageId, rGHMediaHelper$PhotoEntry, null), true);
                return;
            }
            return;
        }
        presentFragment(new SSHMultiSelectMediaActivity(this.addPostGridLayout.getSelectedPhotos(), this.addPostGridLayout.getSelectedPhotosOrder()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean showMaxVideoSizeDialogIfNeeded(Collection<Object> collection) {
        if (collection == null || collection.isEmpty()) {
            onNext();
            return false;
        }
        for (Object obj : collection) {
            if (obj instanceof RGHMediaHelper$PhotoEntry) {
                RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = (RGHMediaHelper$PhotoEntry) obj;
                if (rGHMediaHelper$PhotoEntry.isVideo && rGHMediaHelper$PhotoEntry.duration > maxVideoDurationInSecond * CloseCodes.NORMAL_CLOSURE) {
                    String string = LocaleController.getString(R.string.MaxVideoDurationWarning);
                    SpannableString spannableString = new SpannableString(string);
                    int length = string.length();
                    int i = Theme.key_rubinoBlackColor;
                    RubinoController.showRubinoCenterDialog(false, false, null, SpanHelper.makeBoldWithColorAndRelativeSize(spannableString, 0, length, Theme.getColor(i), 1.4f), LocaleController.getString(R.string.OK), null, Theme.getColor(i), 0, new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$showMaxVideoSizeDialogIfNeeded$5(view);
                        }
                    }, null);
                    return true;
                }
            }
        }
        onNext();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMaxVideoSizeDialogIfNeeded$5(View view) {
        onNext();
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
            ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$AddPostPages[] r0 = r7.addPostPages
            r0 = r0[r1]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$AddPostPages[] r0 = r7.addPostPages
            r0 = r0[r1]
            r0.setTranslationX(r3)
            ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$AddPostPages[] r0 = r7.addPostPages
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
            ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$AddPostPages[] r0 = r7.addPostPages
            r0 = r0[r5]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$AddPostPages[] r0 = r7.addPostPages
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
            ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity$AddPostPages[] r0 = r7.addPostPages
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
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.checkTabsAnimationInProgress():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean prepareForMoving(MotionEvent motionEvent, boolean z) {
        int nextPageId = this.bottomTabLayout.getNextPageId(z);
        int currentTabId = this.bottomTabLayout.getCurrentTabId();
        if (nextPageId < 0) {
            return false;
        }
        this.allowScrollToNext = (currentTabId == AddPostPages.ADD_POST_GALLERY_PAGE_INDEX && nextPageId == AddPostPages.ADD_POST_PHOTO_PAGE_INDEX) || (currentTabId == AddPostPages.ADD_POST_PHOTO_PAGE_INDEX && nextPageId == AddPostPages.ADD_POST_GALLERY_PAGE_INDEX);
        getParentLayout().requestDisallowInterceptTouchEvent(true);
        this.maybeStartTracking = false;
        this.startedTracking = true;
        this.startedTrackingX = (int) motionEvent.getX();
        this.actionBar.setEnabled(false);
        this.bottomTabLayout.setEnabled(false);
        this.addPostPages[1].selectedType = nextPageId;
        this.addPostPages[1].setVisibility(0);
        this.animatingForward = z;
        switchToCurrentSelectedMode();
        if (this.allowScrollToNext) {
            if (z) {
                this.addPostPages[1].setTranslationX(r6[0].getMeasuredWidth());
            } else {
                this.addPostPages[1].setTranslationX(-r6[0].getMeasuredWidth());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScrollAnimation(int i, boolean z) {
        this.currentlyScrollingToIndex = i;
        this.smoothScroller.setTargetPosition(i);
        this.layoutManager.startSmoothScroll(this.smoothScroller);
        if (z) {
            AndroidUtilities.recycleViewSafeSuppressLayout(this.addPostGridLayout.getCurrentListView(), true);
            this.isScrollAnimationRunning = true;
        }
    }

    private void immediatelyScrollToIndex(int i) {
        this.layoutManager.scrollToPositionWithOffset(i, ActionBar.getCurrentActionBarHeight());
        AndroidUtilities.runOnUIThread(this.onScrollAnimationEnds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode() {
        for (int i = 0; i < this.addPostPages[AddPostPages.ADD_POST_GALLERY_PAGE_INDEX].getChildCount(); i++) {
            View childAt = this.addPostPages[AddPostPages.ADD_POST_GALLERY_PAGE_INDEX].getChildAt(i);
            if (childAt instanceof RecyclerListView) {
                ((RecyclerListView) childAt).stopScroll();
                if (Build.VERSION.SDK_INT >= 21) {
                    childAt.stopNestedScroll();
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkListViewScroll() {
        if (this.gridLayoutAttached) {
            this.addPostGridLayout.setVisibleHeight(this.listView.getMeasuredHeight() - this.addPostGridLayout.getTop());
        }
        this.listView.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needLayout() {
        int currentActionBarHeight = (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight();
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) recyclerListView.getLayoutParams();
            if (layoutParams.topMargin != currentActionBarHeight) {
                layoutParams.topMargin = currentActionBarHeight;
                this.listView.setLayoutParams(layoutParams);
            }
        }
        RecyclerListView recyclerListView2 = this.listView;
        if (recyclerListView2 != null) {
            recyclerListView2.setOverScrollMode(2);
        }
    }

    public RecyclerListView getListView() {
        return this.listView;
    }

    private void fixLayout() {
        View view = this.fragmentView;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.15
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                RGHAddPostActivity rGHAddPostActivity = RGHAddPostActivity.this;
                if (rGHAddPostActivity.fragmentView == null) {
                    return true;
                }
                rGHAddPostActivity.checkListViewScroll();
                RGHAddPostActivity.this.needLayout();
                RGHAddPostActivity.this.fragmentView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        View viewFindViewByPosition;
        super.onConfigurationChanged(configuration);
        AddPostGridLayout addPostGridLayout = this.addPostGridLayout;
        if (addPostGridLayout != null) {
            addPostGridLayout.onConfigurationChanged(configuration);
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
        getPermissionStatus();
        checkStorageAndLoadGallery();
        AddPostHeaderView addPostHeaderView = this.headerView;
        if (addPostHeaderView != null) {
            addPostHeaderView.onResume();
        }
        AddPostGridLayout addPostGridLayout = this.addPostGridLayout;
        if (addPostGridLayout != null) {
            addPostGridLayout.onResume();
        }
        AddPostCaptureLayout addPostCaptureLayout = this.addPostCaptureLayout;
        if (addPostCaptureLayout != null && !this.isChangingPage) {
            addPostCaptureLayout.onResume();
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        fixLayout();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        AddPostHeaderView addPostHeaderView = this.headerView;
        if (addPostHeaderView != null) {
            addPostHeaderView.onPause();
        }
        int i = this.currentlyScrollingToIndex;
        if (i != -1) {
            this.isScrollAnimationRunning = false;
            immediatelyScrollToIndex(i);
        }
        this.isTouchedAfterResume = false;
        AddPostCaptureLayout addPostCaptureLayout = this.addPostCaptureLayout;
        if (addPostCaptureLayout == null || this.isChangingPage) {
            return;
        }
        addPostCaptureLayout.onPause();
    }

    private void updateRowsIds() {
        int currentActionBarHeight;
        int i;
        int i2 = this.rowCount;
        this.rowCount = 0;
        this.headerViewRow = -1;
        this.bottomPaddingRow = -1;
        this.gridRow = -1;
        int i3 = 0 + 1;
        this.rowCount = i3;
        this.headerViewRow = 0;
        this.rowCount = i3 + 1;
        this.gridRow = i3;
        if (this.actionBar != null) {
            currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0);
        } else {
            currentActionBarHeight = 0;
        }
        if (this.listView == null || i2 > this.rowCount || ((i = this.listContentHeight) != 0 && i + currentActionBarHeight + AndroidUtilities.dp(88.0f) < this.listView.getMeasuredHeight())) {
            this.lastMeasuredContentWidth = 0;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.invalidateViews();
        }
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
            stopNestedScrollIfNeeded(view, i5);
            if (view == RGHAddPostActivity.this.listView && RGHAddPostActivity.this.gridLayoutAttached && RGHAddPostActivity.this.canScrollVertically && RGHAddPostActivity.this.addPostGridLayout.getTop() <= ActionBar.getCurrentActionBarHeight() && i2 > 0) {
                RGHAddPostActivity.this.disableScrollingAfterIdle = true;
            }
            if (view == RGHAddPostActivity.this.listView && RGHAddPostActivity.this.gridLayoutAttached) {
                if (!RGHAddPostActivity.this.canScrollVertically || (RGHAddPostActivity.this.addPostGridLayout.getTop() == ActionBar.getCurrentActionBarHeight() && i4 > 0)) {
                    if (RGHAddPostActivity.this.addPostGridLayout.getTop() == ActionBar.getCurrentActionBarHeight() && i4 > 0 && RGHAddPostActivity.this.canScrollVertically) {
                        RGHAddPostActivity.this.canScrollVertically = false;
                    }
                    RecyclerListView currentListView = RGHAddPostActivity.this.addPostGridLayout.getCurrentListView();
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
            stopNestedScrollIfNeeded(view, i3);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
            return RGHAddPostActivity.this.gridRow != -1 && i == 2;
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
            this.nestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onStopNestedScroll(View view, int i) {
            this.nestedScrollingParentHelper.onStopNestedScroll(view);
        }

        private void stopNestedScrollIfNeeded(View view, int i) {
            if (i == 1 && RGHAddPostActivity.this.enableScrollingAfterIdle) {
                ViewCompat.stopNestedScroll(view, 1);
            }
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            if (i == 1) {
                if (RGHAddPostActivity.this.headerView.getParent() != null) {
                    ((ViewGroup) RGHAddPostActivity.this.headerView.getParent()).removeView(RGHAddPostActivity.this.headerView);
                }
                view = RGHAddPostActivity.this.headerView;
            } else if (i == 12) {
                view = new View(this.mContext) { // from class: ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity.ListAdapter.1
                    private int lastPaddingHeight = 0;
                    private int lastListViewHeight = 0;

                    @Override // android.view.View
                    protected void onMeasure(int i2, int i3) {
                        if (this.lastListViewHeight != RGHAddPostActivity.this.listView.getMeasuredHeight()) {
                            this.lastPaddingHeight = 0;
                        }
                        this.lastListViewHeight = RGHAddPostActivity.this.listView.getMeasuredHeight();
                        int childCount = RGHAddPostActivity.this.listView.getChildCount();
                        if (childCount != RGHAddPostActivity.this.listAdapter.getItemCount()) {
                            setMeasuredDimension(RGHAddPostActivity.this.listView.getMeasuredWidth(), this.lastPaddingHeight);
                            return;
                        }
                        int measuredHeight = 0;
                        for (int i4 = 0; i4 < childCount; i4++) {
                            if (RGHAddPostActivity.this.listView.getChildAdapterPosition(RGHAddPostActivity.this.listView.getChildAt(i4)) != RGHAddPostActivity.this.bottomPaddingRow) {
                                measuredHeight += RGHAddPostActivity.this.listView.getChildAt(i4).getMeasuredHeight();
                            }
                        }
                        int measuredHeight2 = ((RGHAddPostActivity.this.fragmentView.getMeasuredHeight() - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.statusBarHeight) - measuredHeight;
                        if (measuredHeight2 > AndroidUtilities.dp(88.0f)) {
                            measuredHeight2 = 0;
                        }
                        int i5 = measuredHeight2 > 0 ? measuredHeight2 : 0;
                        int measuredWidth = RGHAddPostActivity.this.listView.getMeasuredWidth();
                        this.lastPaddingHeight = i5;
                        setMeasuredDimension(measuredWidth, i5);
                    }
                };
            } else if (i != 13) {
                view = null;
            } else {
                if (RGHAddPostActivity.this.addPostGridLayout.getParent() != null) {
                    ((ViewGroup) RGHAddPostActivity.this.addPostGridLayout.getParent()).removeView(RGHAddPostActivity.this.addPostGridLayout);
                }
                view = RGHAddPostActivity.this.addPostGridLayout;
            }
            if (i != 13 && view != null) {
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView == RGHAddPostActivity.this.addPostGridLayout) {
                RGHAddPostActivity.this.gridLayoutAttached = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView == RGHAddPostActivity.this.addPostGridLayout) {
                RGHAddPostActivity.this.gridLayoutAttached = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RGHAddPostActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == RGHAddPostActivity.this.headerViewRow) {
                return 1;
            }
            if (i == RGHAddPostActivity.this.bottomPaddingRow) {
                return 12;
            }
            return i == RGHAddPostActivity.this.gridRow ? 13 : 0;
        }
    }
}
