package ir.resaneh1.iptv.fragment.rubino;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.util.Property;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidMessenger.utilites.ToastiLikeSnack;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.server.http.HttpStatus;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerObject;
import ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout;
import ir.appp.rghapp.rubinoPostSlider.RGHSmoothScroller;
import ir.appp.rghapp.rubinoPostSlider.RubinoLikeInterpolator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment;
import ir.resaneh1.iptv.fragment.rubino.AddCommentView;
import ir.resaneh1.iptv.fragment.rubino.PostCell;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.CrashHandelHelper;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.helper.RndHelper;
import ir.resaneh1.iptv.insta.InstaDraftManager;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoCommentObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoPostPosition;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarAnimationType;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;

/* loaded from: classes3.dex */
public class RubinoPostListActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private static long STORY_AND_POST_UPDATE_DURATION = 300000;
    public static int bookmarkPostListType = 4;
    public static int hashtagPostListType = 5;
    public static int homeRecentFollowingType = 0;
    public static boolean isSoundOn = false;
    public static int onePostType = 3;
    public static boolean preloadEnabled = true;
    public static int profilePostListType = 1;
    public static int relatedPostListType = 2;
    public static int taggedPostListType = 6;
    private AnimatorSet addCommentAnimation;
    private final PostCell.AddCommentListener addCommentListener;
    private AddCommentView addCommentView;
    Runnable autoPlayRunnable;
    private Context context;
    private int defaultPostIndex;
    private DisposableObserver disposable;
    private int emptyViewRow;
    public DisposableObserver fakeObserver;
    private ImageView floatingButton;
    private FrameLayout floatingButtonContainer;
    private boolean floatingHidden;
    private final AccelerateDecelerateInterpolator floatingInterpolator;
    private boolean hasContinue;
    private String hashtag;
    private RubinoHomeActionBarView homeActionBarView;
    private boolean isAutoScrollEnable;
    private boolean isHomeInited;
    private int lastKeyboardSize;
    private long lastManualRefreshTime;
    long lastScrollTime;
    private long lastUpdatedPostTime;
    private long lastUpdatedStoryTime;
    private ListAdapter listAdapter;
    private RecyclerListViewEdited listView;
    private int liveCount;
    private int loadMorePosition;
    public DisposableObserver loadPostsObserver;
    private int loadingRow;
    private GestureDetector mDetector;
    int maxDy;
    private String maxId;
    private String minId;
    public boolean needToRefreshStory;
    private boolean needToRetry;
    private NewEventRedView newEventRedView;
    private String nextStartId;
    private AnimatorSet notificationAnimation;
    PullToRefreshLayout.OnRefreshListener onRefreshListener;
    RecyclerView.OnScrollListener onScrollListener;
    Runnable playSelectedCellRunnable;
    private final Map<Integer, Integer> positionMap;
    private final ArrayList<RubinoPostObject> postArray;
    private int postEndRow;
    private final Map<String, RubinoPostObject> postMap;
    private int postStartRow;
    Runnable preLoadRunnable;
    private int prevPosition;
    private int prevTop;
    private RubinoProfileObject profileObject;
    public DisposableObserver refreshPostsObserver;
    private int retryRow;
    private int rowCount;
    private boolean scrollUpdated;
    private boolean scrollingManually;
    private PostCell selectedCellForAutoPlay;
    private PostCell selectedCellForImageTimer;
    private PostCell selectedCellForPreload;
    private PostCell selectedCellForViewCommentPart;
    private RubinoPostObject selectedPost;
    private PostCell selectedPostCell;
    private String selectedPostId;
    private RubinoPostPosition selectedPostPosition;
    private String selectedPostProfileId;
    private final ArrayList<InstaDraftManager.SendingPostInsta> sendingPostArray;
    private final ArrayList<RubinoDraftManager.RubinoSendingPost> sendingPostArray2;
    private int sendingPostEndRow;
    private int sendingPostEndRow2;
    private int sendingPostStartRow;
    private int sendingPostStartRow2;
    Runnable showCommentRunnable;
    private SizeNotifierFrameLayout sizeNotifierFrameLayout;
    private RGHSmoothScroller smoothScroller;
    private final ArrayList<StoryListOfAProfileObject> storyProfileList;
    private int storySectionRow;
    private SparseArray<Rubino.SplitPost> suggestedArray;
    private PullToRefreshLayout swipeRefreshLayout;
    private FrameLayout touchConsumerView;
    private final int type;
    private PowerManager.WakeLock wakeLock;
    int y;

    private void cancelLastPlay(PostCell postCell) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$0(View view, int i) {
    }

    void setAutoPlayRunnable() {
    }

    private void initFragmentParameters() {
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoPostListActivity" + this.type;
        this.swipeBackEnabled = this.type == relatedPostListType;
        this.isSmallActionBar = true;
        this.needLockOrientation = true;
        if (MyLog.isDebugAble) {
            STORY_AND_POST_UPDATE_DURATION = 600000L;
        }
    }

    public RubinoPostListActivity(RubinoPostObject rubinoPostObject, RubinoPostPosition rubinoPostPosition) {
        this.wakeLock = null;
        this.postArray = new ArrayList<>();
        this.sendingPostArray = new ArrayList<>();
        this.sendingPostArray2 = new ArrayList<>();
        this.postMap = new HashMap();
        this.positionMap = new HashMap();
        this.hasContinue = true;
        this.storyProfileList = new ArrayList<>();
        this.lastUpdatedStoryTime = 0L;
        this.lastUpdatedPostTime = 0L;
        this.lastManualRefreshTime = 0L;
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.lastKeyboardSize = -1;
        this.smoothScroller = new RGHSmoothScroller(getContext());
        this.suggestedArray = new SparseArray<>();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.17
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z) {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoPostListActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.playersShouldPause, Integer.valueOf(((BaseFragment) RubinoPostListActivity.this).classGuid));
                RubinoPostListActivity.this.needToRetry = false;
                RubinoPostListActivity.this.updateRows();
                if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType) {
                    RubinoPostListActivity.this.initHome(true, true);
                } else {
                    RubinoPostListActivity.this.getPosts(true, true);
                }
            }
        };
        this.addCommentListener = new PostCell.AddCommentListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.23
            @Override // ir.resaneh1.iptv.fragment.rubino.PostCell.AddCommentListener
            public void addCommentClick(PostCell postCell, RubinoPostObject rubinoPostObject2, CharSequence charSequence) {
                RubinoPostListActivity.this.cancelImagerTimer();
                RubinoPostListActivity.this.selectedPostCell = postCell;
                RubinoPostListActivity.this.showAddCommentView(rubinoPostObject2, charSequence);
            }
        };
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playItemInList();
            }
        };
        this.playSelectedCellRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playSelectedCell();
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.preload();
            }
        };
        this.showCommentRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showCommentBar();
            }
        };
        this.maxDy = AndroidUtilities.dp(56.0f);
        this.y = 0;
        this.lastScrollTime = 0L;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.26
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    RubinoPostListActivity.this.releaseExistingCachedPlayers();
                }
                RubinoPostListActivity.this.scrollingManually = i == 1;
                if (i == 0) {
                    RubinoPostListActivity.this.setAutoPlayRunnable();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z;
                boolean z2;
                super.onScrolled(recyclerView, i, i2);
                if (RubinoPostListActivity.this.floatingButtonContainer != null && RubinoPostListActivity.this.floatingButtonContainer.getVisibility() != 8) {
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) RubinoPostListActivity.this.listView.getLayoutManager()).findFirstVisibleItemPosition();
                    View childAt = recyclerView.getChildAt(0);
                    int top = childAt != null ? childAt.getTop() : 0;
                    if (RubinoPostListActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                        int i3 = RubinoPostListActivity.this.prevTop - top;
                        z = top < RubinoPostListActivity.this.prevTop;
                        if (Math.abs(i3) <= 1) {
                            z2 = false;
                        }
                        if (z2 && RubinoPostListActivity.this.scrollUpdated && (z || (!z && RubinoPostListActivity.this.scrollingManually))) {
                            RubinoPostListActivity.this.hideFloatingButton(z);
                        }
                        RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                        RubinoPostListActivity.this.prevTop = top;
                        RubinoPostListActivity.this.scrollUpdated = true;
                    } else {
                        z = iFindFirstVisibleItemPosition > RubinoPostListActivity.this.prevPosition;
                    }
                    z2 = true;
                    if (z2) {
                        RubinoPostListActivity.this.hideFloatingButton(z);
                    }
                    RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                    RubinoPostListActivity.this.prevTop = top;
                    RubinoPostListActivity.this.scrollUpdated = true;
                }
                RubinoPostListActivity rubinoPostListActivity = RubinoPostListActivity.this;
                int i4 = rubinoPostListActivity.y + i2;
                rubinoPostListActivity.y = i4;
                if (Math.abs(i4) < RubinoPostListActivity.this.maxDy) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                RubinoPostListActivity rubinoPostListActivity2 = RubinoPostListActivity.this;
                long j = jCurrentTimeMillis - rubinoPostListActivity2.lastScrollTime;
                rubinoPostListActivity2.lastScrollTime = jCurrentTimeMillis;
                float fAbs = Math.abs(rubinoPostListActivity2.y) / j;
                RubinoPostListActivity.this.y = 0;
                if (fAbs < AndroidUtilities.dp(0.2f)) {
                    RubinoPostListActivity.this.playItemInList();
                    return;
                }
                RubinoPostListActivity.this.cancelPlaySelectedCellRunnable();
                RubinoPostListActivity.this.cancelPreloadVideoRunnable();
                RubinoPostListActivity.this.cancelShowCommentRunnable();
            }
        };
        this.type = relatedPostListType;
        this.selectedPost = rubinoPostObject;
        this.selectedPostPosition = rubinoPostPosition;
        RubinoProfileObject rubinoProfileObject = rubinoPostObject.profile;
        RubinoProfileObject.ProfileStatusEnum profileStatusEnum = RubinoProfileObject.ProfileStatusEnum.Public;
        rubinoProfileObject.profile_status = profileStatusEnum;
        rubinoPostObject.getProfileTryFromMap().profile_status = profileStatusEnum;
        initFragmentParameters();
    }

    public RubinoPostListActivity(String str, String str2) {
        this.wakeLock = null;
        this.postArray = new ArrayList<>();
        this.sendingPostArray = new ArrayList<>();
        this.sendingPostArray2 = new ArrayList<>();
        this.postMap = new HashMap();
        this.positionMap = new HashMap();
        this.hasContinue = true;
        this.storyProfileList = new ArrayList<>();
        this.lastUpdatedStoryTime = 0L;
        this.lastUpdatedPostTime = 0L;
        this.lastManualRefreshTime = 0L;
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.lastKeyboardSize = -1;
        this.smoothScroller = new RGHSmoothScroller(getContext());
        this.suggestedArray = new SparseArray<>();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.17
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z) {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoPostListActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.playersShouldPause, Integer.valueOf(((BaseFragment) RubinoPostListActivity.this).classGuid));
                RubinoPostListActivity.this.needToRetry = false;
                RubinoPostListActivity.this.updateRows();
                if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType) {
                    RubinoPostListActivity.this.initHome(true, true);
                } else {
                    RubinoPostListActivity.this.getPosts(true, true);
                }
            }
        };
        this.addCommentListener = new PostCell.AddCommentListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.23
            @Override // ir.resaneh1.iptv.fragment.rubino.PostCell.AddCommentListener
            public void addCommentClick(PostCell postCell, RubinoPostObject rubinoPostObject2, CharSequence charSequence) {
                RubinoPostListActivity.this.cancelImagerTimer();
                RubinoPostListActivity.this.selectedPostCell = postCell;
                RubinoPostListActivity.this.showAddCommentView(rubinoPostObject2, charSequence);
            }
        };
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playItemInList();
            }
        };
        this.playSelectedCellRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playSelectedCell();
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.preload();
            }
        };
        this.showCommentRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showCommentBar();
            }
        };
        this.maxDy = AndroidUtilities.dp(56.0f);
        this.y = 0;
        this.lastScrollTime = 0L;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.26
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    RubinoPostListActivity.this.releaseExistingCachedPlayers();
                }
                RubinoPostListActivity.this.scrollingManually = i == 1;
                if (i == 0) {
                    RubinoPostListActivity.this.setAutoPlayRunnable();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z;
                boolean z2;
                super.onScrolled(recyclerView, i, i2);
                if (RubinoPostListActivity.this.floatingButtonContainer != null && RubinoPostListActivity.this.floatingButtonContainer.getVisibility() != 8) {
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) RubinoPostListActivity.this.listView.getLayoutManager()).findFirstVisibleItemPosition();
                    View childAt = recyclerView.getChildAt(0);
                    int top = childAt != null ? childAt.getTop() : 0;
                    if (RubinoPostListActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                        int i3 = RubinoPostListActivity.this.prevTop - top;
                        z = top < RubinoPostListActivity.this.prevTop;
                        if (Math.abs(i3) <= 1) {
                            z2 = false;
                        }
                        if (z2 && RubinoPostListActivity.this.scrollUpdated && (z || (!z && RubinoPostListActivity.this.scrollingManually))) {
                            RubinoPostListActivity.this.hideFloatingButton(z);
                        }
                        RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                        RubinoPostListActivity.this.prevTop = top;
                        RubinoPostListActivity.this.scrollUpdated = true;
                    } else {
                        z = iFindFirstVisibleItemPosition > RubinoPostListActivity.this.prevPosition;
                    }
                    z2 = true;
                    if (z2) {
                        RubinoPostListActivity.this.hideFloatingButton(z);
                    }
                    RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                    RubinoPostListActivity.this.prevTop = top;
                    RubinoPostListActivity.this.scrollUpdated = true;
                }
                RubinoPostListActivity rubinoPostListActivity = RubinoPostListActivity.this;
                int i4 = rubinoPostListActivity.y + i2;
                rubinoPostListActivity.y = i4;
                if (Math.abs(i4) < RubinoPostListActivity.this.maxDy) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                RubinoPostListActivity rubinoPostListActivity2 = RubinoPostListActivity.this;
                long j = jCurrentTimeMillis - rubinoPostListActivity2.lastScrollTime;
                rubinoPostListActivity2.lastScrollTime = jCurrentTimeMillis;
                float fAbs = Math.abs(rubinoPostListActivity2.y) / j;
                RubinoPostListActivity.this.y = 0;
                if (fAbs < AndroidUtilities.dp(0.2f)) {
                    RubinoPostListActivity.this.playItemInList();
                    return;
                }
                RubinoPostListActivity.this.cancelPlaySelectedCellRunnable();
                RubinoPostListActivity.this.cancelPreloadVideoRunnable();
                RubinoPostListActivity.this.cancelShowCommentRunnable();
            }
        };
        this.type = onePostType;
        this.selectedPostId = str;
        this.selectedPostProfileId = str2;
        initFragmentParameters();
    }

    public RubinoPostListActivity(int i) {
        this.wakeLock = null;
        this.postArray = new ArrayList<>();
        this.sendingPostArray = new ArrayList<>();
        this.sendingPostArray2 = new ArrayList<>();
        this.postMap = new HashMap();
        this.positionMap = new HashMap();
        this.hasContinue = true;
        this.storyProfileList = new ArrayList<>();
        this.lastUpdatedStoryTime = 0L;
        this.lastUpdatedPostTime = 0L;
        this.lastManualRefreshTime = 0L;
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.lastKeyboardSize = -1;
        this.smoothScroller = new RGHSmoothScroller(getContext());
        this.suggestedArray = new SparseArray<>();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.17
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z) {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoPostListActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.playersShouldPause, Integer.valueOf(((BaseFragment) RubinoPostListActivity.this).classGuid));
                RubinoPostListActivity.this.needToRetry = false;
                RubinoPostListActivity.this.updateRows();
                if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType) {
                    RubinoPostListActivity.this.initHome(true, true);
                } else {
                    RubinoPostListActivity.this.getPosts(true, true);
                }
            }
        };
        this.addCommentListener = new PostCell.AddCommentListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.23
            @Override // ir.resaneh1.iptv.fragment.rubino.PostCell.AddCommentListener
            public void addCommentClick(PostCell postCell, RubinoPostObject rubinoPostObject2, CharSequence charSequence) {
                RubinoPostListActivity.this.cancelImagerTimer();
                RubinoPostListActivity.this.selectedPostCell = postCell;
                RubinoPostListActivity.this.showAddCommentView(rubinoPostObject2, charSequence);
            }
        };
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playItemInList();
            }
        };
        this.playSelectedCellRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playSelectedCell();
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.preload();
            }
        };
        this.showCommentRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showCommentBar();
            }
        };
        this.maxDy = AndroidUtilities.dp(56.0f);
        this.y = 0;
        this.lastScrollTime = 0L;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.26
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    RubinoPostListActivity.this.releaseExistingCachedPlayers();
                }
                RubinoPostListActivity.this.scrollingManually = i2 == 1;
                if (i2 == 0) {
                    RubinoPostListActivity.this.setAutoPlayRunnable();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                boolean z;
                boolean z2;
                super.onScrolled(recyclerView, i2, i22);
                if (RubinoPostListActivity.this.floatingButtonContainer != null && RubinoPostListActivity.this.floatingButtonContainer.getVisibility() != 8) {
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) RubinoPostListActivity.this.listView.getLayoutManager()).findFirstVisibleItemPosition();
                    View childAt = recyclerView.getChildAt(0);
                    int top = childAt != null ? childAt.getTop() : 0;
                    if (RubinoPostListActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                        int i3 = RubinoPostListActivity.this.prevTop - top;
                        z = top < RubinoPostListActivity.this.prevTop;
                        if (Math.abs(i3) <= 1) {
                            z2 = false;
                        }
                        if (z2 && RubinoPostListActivity.this.scrollUpdated && (z || (!z && RubinoPostListActivity.this.scrollingManually))) {
                            RubinoPostListActivity.this.hideFloatingButton(z);
                        }
                        RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                        RubinoPostListActivity.this.prevTop = top;
                        RubinoPostListActivity.this.scrollUpdated = true;
                    } else {
                        z = iFindFirstVisibleItemPosition > RubinoPostListActivity.this.prevPosition;
                    }
                    z2 = true;
                    if (z2) {
                        RubinoPostListActivity.this.hideFloatingButton(z);
                    }
                    RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                    RubinoPostListActivity.this.prevTop = top;
                    RubinoPostListActivity.this.scrollUpdated = true;
                }
                RubinoPostListActivity rubinoPostListActivity = RubinoPostListActivity.this;
                int i4 = rubinoPostListActivity.y + i22;
                rubinoPostListActivity.y = i4;
                if (Math.abs(i4) < RubinoPostListActivity.this.maxDy) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                RubinoPostListActivity rubinoPostListActivity2 = RubinoPostListActivity.this;
                long j = jCurrentTimeMillis - rubinoPostListActivity2.lastScrollTime;
                rubinoPostListActivity2.lastScrollTime = jCurrentTimeMillis;
                float fAbs = Math.abs(rubinoPostListActivity2.y) / j;
                RubinoPostListActivity.this.y = 0;
                if (fAbs < AndroidUtilities.dp(0.2f)) {
                    RubinoPostListActivity.this.playItemInList();
                    return;
                }
                RubinoPostListActivity.this.cancelPlaySelectedCellRunnable();
                RubinoPostListActivity.this.cancelPreloadVideoRunnable();
                RubinoPostListActivity.this.cancelShowCommentRunnable();
            }
        };
        this.type = i;
        initFragmentParameters();
    }

    public RubinoPostListActivity(int i, RubinoProfileObject rubinoProfileObject, ArrayList<RubinoPostObject> arrayList, Map<String, RubinoPostObject> map, String str, boolean z, int i2) {
        this.wakeLock = null;
        ArrayList<RubinoPostObject> arrayList2 = new ArrayList<>();
        this.postArray = arrayList2;
        this.sendingPostArray = new ArrayList<>();
        this.sendingPostArray2 = new ArrayList<>();
        HashMap map2 = new HashMap();
        this.postMap = map2;
        this.positionMap = new HashMap();
        this.hasContinue = true;
        this.storyProfileList = new ArrayList<>();
        this.lastUpdatedStoryTime = 0L;
        this.lastUpdatedPostTime = 0L;
        this.lastManualRefreshTime = 0L;
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.lastKeyboardSize = -1;
        this.smoothScroller = new RGHSmoothScroller(getContext());
        this.suggestedArray = new SparseArray<>();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.17
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z2) {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoPostListActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.playersShouldPause, Integer.valueOf(((BaseFragment) RubinoPostListActivity.this).classGuid));
                RubinoPostListActivity.this.needToRetry = false;
                RubinoPostListActivity.this.updateRows();
                if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType) {
                    RubinoPostListActivity.this.initHome(true, true);
                } else {
                    RubinoPostListActivity.this.getPosts(true, true);
                }
            }
        };
        this.addCommentListener = new PostCell.AddCommentListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.23
            @Override // ir.resaneh1.iptv.fragment.rubino.PostCell.AddCommentListener
            public void addCommentClick(PostCell postCell, RubinoPostObject rubinoPostObject2, CharSequence charSequence) {
                RubinoPostListActivity.this.cancelImagerTimer();
                RubinoPostListActivity.this.selectedPostCell = postCell;
                RubinoPostListActivity.this.showAddCommentView(rubinoPostObject2, charSequence);
            }
        };
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playItemInList();
            }
        };
        this.playSelectedCellRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playSelectedCell();
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.preload();
            }
        };
        this.showCommentRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showCommentBar();
            }
        };
        this.maxDy = AndroidUtilities.dp(56.0f);
        this.y = 0;
        this.lastScrollTime = 0L;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.26
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i22) {
                super.onScrollStateChanged(recyclerView, i22);
                if (i22 == 0) {
                    RubinoPostListActivity.this.releaseExistingCachedPlayers();
                }
                RubinoPostListActivity.this.scrollingManually = i22 == 1;
                if (i22 == 0) {
                    RubinoPostListActivity.this.setAutoPlayRunnable();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i22, int i222) {
                boolean z2;
                boolean z22;
                super.onScrolled(recyclerView, i22, i222);
                if (RubinoPostListActivity.this.floatingButtonContainer != null && RubinoPostListActivity.this.floatingButtonContainer.getVisibility() != 8) {
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) RubinoPostListActivity.this.listView.getLayoutManager()).findFirstVisibleItemPosition();
                    View childAt = recyclerView.getChildAt(0);
                    int top = childAt != null ? childAt.getTop() : 0;
                    if (RubinoPostListActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                        int i3 = RubinoPostListActivity.this.prevTop - top;
                        z2 = top < RubinoPostListActivity.this.prevTop;
                        if (Math.abs(i3) <= 1) {
                            z22 = false;
                        }
                        if (z22 && RubinoPostListActivity.this.scrollUpdated && (z2 || (!z2 && RubinoPostListActivity.this.scrollingManually))) {
                            RubinoPostListActivity.this.hideFloatingButton(z2);
                        }
                        RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                        RubinoPostListActivity.this.prevTop = top;
                        RubinoPostListActivity.this.scrollUpdated = true;
                    } else {
                        z2 = iFindFirstVisibleItemPosition > RubinoPostListActivity.this.prevPosition;
                    }
                    z22 = true;
                    if (z22) {
                        RubinoPostListActivity.this.hideFloatingButton(z2);
                    }
                    RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                    RubinoPostListActivity.this.prevTop = top;
                    RubinoPostListActivity.this.scrollUpdated = true;
                }
                RubinoPostListActivity rubinoPostListActivity = RubinoPostListActivity.this;
                int i4 = rubinoPostListActivity.y + i222;
                rubinoPostListActivity.y = i4;
                if (Math.abs(i4) < RubinoPostListActivity.this.maxDy) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                RubinoPostListActivity rubinoPostListActivity2 = RubinoPostListActivity.this;
                long j = jCurrentTimeMillis - rubinoPostListActivity2.lastScrollTime;
                rubinoPostListActivity2.lastScrollTime = jCurrentTimeMillis;
                float fAbs = Math.abs(rubinoPostListActivity2.y) / j;
                RubinoPostListActivity.this.y = 0;
                if (fAbs < AndroidUtilities.dp(0.2f)) {
                    RubinoPostListActivity.this.playItemInList();
                    return;
                }
                RubinoPostListActivity.this.cancelPlaySelectedCellRunnable();
                RubinoPostListActivity.this.cancelPreloadVideoRunnable();
                RubinoPostListActivity.this.cancelShowCommentRunnable();
            }
        };
        this.type = i;
        arrayList2.addAll(arrayList);
        map2.putAll(map);
        this.maxId = str;
        this.hasContinue = z;
        this.defaultPostIndex = i2;
        this.profileObject = rubinoProfileObject;
        initFragmentParameters();
    }

    public RubinoPostListActivity(String str, ArrayList<RubinoPostObject> arrayList, Map<String, RubinoPostObject> map, String str2, boolean z, int i) {
        this.wakeLock = null;
        ArrayList<RubinoPostObject> arrayList2 = new ArrayList<>();
        this.postArray = arrayList2;
        this.sendingPostArray = new ArrayList<>();
        this.sendingPostArray2 = new ArrayList<>();
        HashMap map2 = new HashMap();
        this.postMap = map2;
        this.positionMap = new HashMap();
        this.hasContinue = true;
        this.storyProfileList = new ArrayList<>();
        this.lastUpdatedStoryTime = 0L;
        this.lastUpdatedPostTime = 0L;
        this.lastManualRefreshTime = 0L;
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.lastKeyboardSize = -1;
        this.smoothScroller = new RGHSmoothScroller(getContext());
        this.suggestedArray = new SparseArray<>();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.17
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z2) {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoPostListActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.playersShouldPause, Integer.valueOf(((BaseFragment) RubinoPostListActivity.this).classGuid));
                RubinoPostListActivity.this.needToRetry = false;
                RubinoPostListActivity.this.updateRows();
                if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType) {
                    RubinoPostListActivity.this.initHome(true, true);
                } else {
                    RubinoPostListActivity.this.getPosts(true, true);
                }
            }
        };
        this.addCommentListener = new PostCell.AddCommentListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.23
            @Override // ir.resaneh1.iptv.fragment.rubino.PostCell.AddCommentListener
            public void addCommentClick(PostCell postCell, RubinoPostObject rubinoPostObject2, CharSequence charSequence) {
                RubinoPostListActivity.this.cancelImagerTimer();
                RubinoPostListActivity.this.selectedPostCell = postCell;
                RubinoPostListActivity.this.showAddCommentView(rubinoPostObject2, charSequence);
            }
        };
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playItemInList();
            }
        };
        this.playSelectedCellRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playSelectedCell();
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.preload();
            }
        };
        this.showCommentRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showCommentBar();
            }
        };
        this.maxDy = AndroidUtilities.dp(56.0f);
        this.y = 0;
        this.lastScrollTime = 0L;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.26
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i22) {
                super.onScrollStateChanged(recyclerView, i22);
                if (i22 == 0) {
                    RubinoPostListActivity.this.releaseExistingCachedPlayers();
                }
                RubinoPostListActivity.this.scrollingManually = i22 == 1;
                if (i22 == 0) {
                    RubinoPostListActivity.this.setAutoPlayRunnable();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i22, int i222) {
                boolean z2;
                boolean z22;
                super.onScrolled(recyclerView, i22, i222);
                if (RubinoPostListActivity.this.floatingButtonContainer != null && RubinoPostListActivity.this.floatingButtonContainer.getVisibility() != 8) {
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) RubinoPostListActivity.this.listView.getLayoutManager()).findFirstVisibleItemPosition();
                    View childAt = recyclerView.getChildAt(0);
                    int top = childAt != null ? childAt.getTop() : 0;
                    if (RubinoPostListActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                        int i3 = RubinoPostListActivity.this.prevTop - top;
                        z2 = top < RubinoPostListActivity.this.prevTop;
                        if (Math.abs(i3) <= 1) {
                            z22 = false;
                        }
                        if (z22 && RubinoPostListActivity.this.scrollUpdated && (z2 || (!z2 && RubinoPostListActivity.this.scrollingManually))) {
                            RubinoPostListActivity.this.hideFloatingButton(z2);
                        }
                        RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                        RubinoPostListActivity.this.prevTop = top;
                        RubinoPostListActivity.this.scrollUpdated = true;
                    } else {
                        z2 = iFindFirstVisibleItemPosition > RubinoPostListActivity.this.prevPosition;
                    }
                    z22 = true;
                    if (z22) {
                        RubinoPostListActivity.this.hideFloatingButton(z2);
                    }
                    RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                    RubinoPostListActivity.this.prevTop = top;
                    RubinoPostListActivity.this.scrollUpdated = true;
                }
                RubinoPostListActivity rubinoPostListActivity = RubinoPostListActivity.this;
                int i4 = rubinoPostListActivity.y + i222;
                rubinoPostListActivity.y = i4;
                if (Math.abs(i4) < RubinoPostListActivity.this.maxDy) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                RubinoPostListActivity rubinoPostListActivity2 = RubinoPostListActivity.this;
                long j = jCurrentTimeMillis - rubinoPostListActivity2.lastScrollTime;
                rubinoPostListActivity2.lastScrollTime = jCurrentTimeMillis;
                float fAbs = Math.abs(rubinoPostListActivity2.y) / j;
                RubinoPostListActivity.this.y = 0;
                if (fAbs < AndroidUtilities.dp(0.2f)) {
                    RubinoPostListActivity.this.playItemInList();
                    return;
                }
                RubinoPostListActivity.this.cancelPlaySelectedCellRunnable();
                RubinoPostListActivity.this.cancelPreloadVideoRunnable();
                RubinoPostListActivity.this.cancelShowCommentRunnable();
            }
        };
        this.type = hashtagPostListType;
        arrayList2.addAll(arrayList);
        map2.putAll(map);
        this.nextStartId = str2;
        this.hasContinue = z;
        this.defaultPostIndex = i;
        this.hashtag = str;
        initFragmentParameters();
    }

    public RubinoPostListActivity(int i, ArrayList<RubinoPostObject> arrayList, Map<String, RubinoPostObject> map, String str, boolean z, int i2) {
        this.wakeLock = null;
        ArrayList<RubinoPostObject> arrayList2 = new ArrayList<>();
        this.postArray = arrayList2;
        this.sendingPostArray = new ArrayList<>();
        this.sendingPostArray2 = new ArrayList<>();
        HashMap map2 = new HashMap();
        this.postMap = map2;
        this.positionMap = new HashMap();
        this.hasContinue = true;
        this.storyProfileList = new ArrayList<>();
        this.lastUpdatedStoryTime = 0L;
        this.lastUpdatedPostTime = 0L;
        this.lastManualRefreshTime = 0L;
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.lastKeyboardSize = -1;
        this.smoothScroller = new RGHSmoothScroller(getContext());
        this.suggestedArray = new SparseArray<>();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.17
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z2) {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoPostListActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.playersShouldPause, Integer.valueOf(((BaseFragment) RubinoPostListActivity.this).classGuid));
                RubinoPostListActivity.this.needToRetry = false;
                RubinoPostListActivity.this.updateRows();
                if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType) {
                    RubinoPostListActivity.this.initHome(true, true);
                } else {
                    RubinoPostListActivity.this.getPosts(true, true);
                }
            }
        };
        this.addCommentListener = new PostCell.AddCommentListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.23
            @Override // ir.resaneh1.iptv.fragment.rubino.PostCell.AddCommentListener
            public void addCommentClick(PostCell postCell, RubinoPostObject rubinoPostObject2, CharSequence charSequence) {
                RubinoPostListActivity.this.cancelImagerTimer();
                RubinoPostListActivity.this.selectedPostCell = postCell;
                RubinoPostListActivity.this.showAddCommentView(rubinoPostObject2, charSequence);
            }
        };
        this.autoPlayRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playItemInList();
            }
        };
        this.playSelectedCellRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.playSelectedCell();
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.preload();
            }
        };
        this.showCommentRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showCommentBar();
            }
        };
        this.maxDy = AndroidUtilities.dp(56.0f);
        this.y = 0;
        this.lastScrollTime = 0L;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.26
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i22) {
                super.onScrollStateChanged(recyclerView, i22);
                if (i22 == 0) {
                    RubinoPostListActivity.this.releaseExistingCachedPlayers();
                }
                RubinoPostListActivity.this.scrollingManually = i22 == 1;
                if (i22 == 0) {
                    RubinoPostListActivity.this.setAutoPlayRunnable();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i22, int i222) {
                boolean z2;
                boolean z22;
                super.onScrolled(recyclerView, i22, i222);
                if (RubinoPostListActivity.this.floatingButtonContainer != null && RubinoPostListActivity.this.floatingButtonContainer.getVisibility() != 8) {
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) RubinoPostListActivity.this.listView.getLayoutManager()).findFirstVisibleItemPosition();
                    View childAt = recyclerView.getChildAt(0);
                    int top = childAt != null ? childAt.getTop() : 0;
                    if (RubinoPostListActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                        int i3 = RubinoPostListActivity.this.prevTop - top;
                        z2 = top < RubinoPostListActivity.this.prevTop;
                        if (Math.abs(i3) <= 1) {
                            z22 = false;
                        }
                        if (z22 && RubinoPostListActivity.this.scrollUpdated && (z2 || (!z2 && RubinoPostListActivity.this.scrollingManually))) {
                            RubinoPostListActivity.this.hideFloatingButton(z2);
                        }
                        RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                        RubinoPostListActivity.this.prevTop = top;
                        RubinoPostListActivity.this.scrollUpdated = true;
                    } else {
                        z2 = iFindFirstVisibleItemPosition > RubinoPostListActivity.this.prevPosition;
                    }
                    z22 = true;
                    if (z22) {
                        RubinoPostListActivity.this.hideFloatingButton(z2);
                    }
                    RubinoPostListActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                    RubinoPostListActivity.this.prevTop = top;
                    RubinoPostListActivity.this.scrollUpdated = true;
                }
                RubinoPostListActivity rubinoPostListActivity = RubinoPostListActivity.this;
                int i4 = rubinoPostListActivity.y + i222;
                rubinoPostListActivity.y = i4;
                if (Math.abs(i4) < RubinoPostListActivity.this.maxDy) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                RubinoPostListActivity rubinoPostListActivity2 = RubinoPostListActivity.this;
                long j = jCurrentTimeMillis - rubinoPostListActivity2.lastScrollTime;
                rubinoPostListActivity2.lastScrollTime = jCurrentTimeMillis;
                float fAbs = Math.abs(rubinoPostListActivity2.y) / j;
                RubinoPostListActivity.this.y = 0;
                if (fAbs < AndroidUtilities.dp(0.2f)) {
                    RubinoPostListActivity.this.playItemInList();
                    return;
                }
                RubinoPostListActivity.this.cancelPlaySelectedCellRunnable();
                RubinoPostListActivity.this.cancelPreloadVideoRunnable();
                RubinoPostListActivity.this.cancelShowCommentRunnable();
            }
        };
        this.type = i;
        arrayList2.addAll(arrayList);
        map2.putAll(map);
        this.nextStartId = str;
        this.maxId = str;
        this.hasContinue = z;
        this.defaultPostIndex = i2;
        initFragmentParameters();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoPostEdited);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoLikePostChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoBookmarkPostChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoPostDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoCommentCountChange);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        if (this.type == homeRecentFollowingType) {
            getNotificationCenter().addObserver(this, NotificationCenter.rubinoMyProfileNotifCountChange);
            getNotificationCenter().addObserver(this, NotificationCenter.rubinoProfileDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.myInstaRefreshSendingView);
            getNotificationCenter().addObserver(this, NotificationCenter.myInstaPostChangeProgressView);
            getNotificationCenter().addObserver(this, NotificationCenter.myInstaSendPostDone);
            getNotificationCenter().addObserver(this, NotificationCenter.sendingStoryStatusChanges);
            getNotificationCenter().addObserver(this, NotificationCenter.storyListEmptyDetected);
            getNotificationCenter().addObserver(this, NotificationCenter.rubinoLiveStatusChanged);
            getNotificationCenter().addObserver(this, NotificationCenter.myStoryDeleted);
            getNotificationCenter().addObserver(this, NotificationCenter.myFirstStoryAdded);
            getNotificationCenter().addObserver(this, NotificationCenter.myStoryAdded);
            getNotificationCenter().addObserver(this, NotificationCenter.allStoriesIsSeenChanged);
            getNotificationCenter().addObserver(this, NotificationCenter.storyCurrentLoadingProfileChanged);
        }
        if (this.type == relatedPostListType) {
            getNotificationCenter().addObserver(this, NotificationCenter.allStoriesIsSeenChanged);
            getNotificationCenter().addObserver(this, NotificationCenter.storyCurrentLoadingProfileChanged);
        }
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoPostEdited);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoLikePostChanged);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoBookmarkPostChanged);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoPostDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoCommentCountChange);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        if (this.type == homeRecentFollowingType) {
            getNotificationCenter().removeObserver(this, NotificationCenter.rubinoMyProfileNotifCountChange);
            getNotificationCenter().removeObserver(this, NotificationCenter.rubinoProfileDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.myInstaRefreshSendingView);
            getNotificationCenter().removeObserver(this, NotificationCenter.myInstaPostChangeProgressView);
            getNotificationCenter().removeObserver(this, NotificationCenter.myInstaSendPostDone);
            getNotificationCenter().removeObserver(this, NotificationCenter.sendingStoryStatusChanges);
            getNotificationCenter().removeObserver(this, NotificationCenter.storyListEmptyDetected);
            getNotificationCenter().removeObserver(this, NotificationCenter.rubinoLiveStatusChanged);
            getNotificationCenter().removeObserver(this, NotificationCenter.myStoryDeleted);
            getNotificationCenter().removeObserver(this, NotificationCenter.myStoryAdded);
            getNotificationCenter().removeObserver(this, NotificationCenter.myFirstStoryAdded);
            getNotificationCenter().removeObserver(this, NotificationCenter.allStoriesIsSeenChanged);
            getNotificationCenter().removeObserver(this, NotificationCenter.storyCurrentLoadingProfileChanged);
        }
        if (this.type == relatedPostListType) {
            getNotificationCenter().removeObserver(this, NotificationCenter.allStoriesIsSeenChanged);
            getNotificationCenter().removeObserver(this, NotificationCenter.storyCurrentLoadingProfileChanged);
        }
        releaseExistingCachedPlayers();
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        String string;
        this.context = context;
        int i = 1;
        boolean z = false;
        if (this.type == homeRecentFollowingType) {
            RubinoHomeActionBarView rubinoHomeActionBarView = new RubinoHomeActionBarView(context);
            this.homeActionBarView = rubinoHomeActionBarView;
            this.actionBar.addView(rubinoHomeActionBarView, 0, LayoutHelper.createFrame(-2, -2, (LocaleController.isRTL ? 5 : 3) | 80));
            this.actionBar.setTitle(BuildConfig.FLAVOR);
            this.actionBar.setRtlLayout(true);
        } else {
            this.actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
            this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
            int i2 = this.type;
            if (i2 == relatedPostListType) {
                this.actionBar.setTitle(LocaleController.getString(R.string.rubinoRelatedPosts));
            } else if (i2 == onePostType) {
                this.actionBar.setTitle(LocaleController.getString(R.string.rubinoPost));
            } else if (i2 == bookmarkPostListType) {
                this.actionBar.setTitle(LocaleController.getString(R.string.rubinoBookmark));
            } else if (i2 == hashtagPostListType) {
                ActionBar actionBar = this.actionBar;
                if (this.hashtag != null) {
                    string = "#" + this.hashtag;
                } else {
                    string = LocaleController.getString(R.string.rubinoPosts);
                }
                actionBar.setTitle(string);
                this.actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceMedium());
            } else {
                this.actionBar.setTitle(LocaleController.getString(R.string.rubinoPosts));
            }
            this.actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceRegular());
        }
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i3) {
                if (i3 == -1) {
                    if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType) {
                        return;
                    }
                    RubinoPostListActivity.this.finishFragment();
                } else if (i3 == 1 && RubinoController.getInstance(((BaseFragment) RubinoPostListActivity.this).currentAccount).hasPermissionAddStory() && RubinoPostListActivity.this.isHomeInited) {
                    RubinoPostListActivity.this.presentFragment(new StoryCameraAndGalleryFragment());
                }
            }
        });
        if (this.type == homeRecentFollowingType) {
            ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
            if (!FlavorHelper.isShad()) {
                ActionBarMenuItem actionBarMenuItemAddItemWithWidth = actionBarMenuCreateMenu.addItemWithWidth(2, R.drawable.ic_rubino_logo, AndroidUtilities.dp(72.0f));
                actionBarMenuItemAddItemWithWidth.iconView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                actionBarMenuItemAddItemWithWidth.iconView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_rubinoBlackColor), PorterDuff.Mode.SRC_ATOP));
            }
            if (RubinoController.getInstance(this.currentAccount).hasPermissionAddStory()) {
                ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(1, R.drawable.rubino_camera_action_bar);
                actionBarMenuItemAddItem.iconView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                actionBarMenuItemAddItem.iconView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_rubinoBlackColor), PorterDuff.Mode.SRC_ATOP));
                actionBarMenuItemAddItem.iconView.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f));
            }
        }
        this.listAdapter = new ListAdapter(context);
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.2
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i3, int i4) {
                super.onMeasure(i3, i4);
                if (RubinoPostListActivity.this.type != RubinoPostListActivity.relatedPostListType) {
                    return;
                }
                setMeasuredDimension(i3, i4);
                measureChildWithMargins(((BaseFragment) RubinoPostListActivity.this).actionBar, i3, 0, i4, 0);
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
                /*
                    r8 = this;
                    super.onLayout(r9, r10, r11, r12, r13)
                    ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity r9 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.this
                    int r9 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.access$000(r9)
                    int r0 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.relatedPostListType
                    if (r9 == r0) goto Le
                    return
                Le:
                    boolean r9 = org.rbmain.messenger.SharedConfig.smoothKeyboard
                    r0 = 0
                    if (r9 != 0) goto L16
                    r8.setBottomClip(r0)
                L16:
                    int r9 = r8.getChildCount()
                L1a:
                    if (r0 >= r9) goto Lbe
                    android.view.View r1 = r8.getChildAt(r0)
                    int r2 = r1.getVisibility()
                    r3 = 8
                    if (r2 != r3) goto L2a
                    goto Lba
                L2a:
                    android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
                    android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
                    int r3 = r1.getMeasuredWidth()
                    int r4 = r1.getMeasuredHeight()
                    int r5 = r2.gravity
                    r6 = -1
                    if (r5 != r6) goto L3f
                    r5 = 51
                L3f:
                    r6 = r5 & 7
                    r5 = r5 & 112(0x70, float:1.57E-43)
                    r6 = r6 & 7
                    r7 = 1
                    if (r6 == r7) goto L53
                    r7 = 5
                    if (r6 == r7) goto L4e
                    int r6 = r2.leftMargin
                    goto L5e
                L4e:
                    int r6 = r12 - r3
                    int r7 = r2.rightMargin
                    goto L5d
                L53:
                    int r6 = r12 - r10
                    int r6 = r6 - r3
                    int r6 = r6 / 2
                    int r7 = r2.leftMargin
                    int r6 = r6 + r7
                    int r7 = r2.rightMargin
                L5d:
                    int r6 = r6 - r7
                L5e:
                    r7 = 16
                    if (r5 == r7) goto L7c
                    r7 = 48
                    if (r5 == r7) goto L74
                    r7 = 80
                    if (r5 == r7) goto L6d
                    int r2 = r2.topMargin
                    goto L89
                L6d:
                    int r5 = r13 + 0
                    int r5 = r5 - r11
                    int r5 = r5 - r4
                    int r2 = r2.bottomMargin
                    goto L87
                L74:
                    int r2 = r2.topMargin
                    int r5 = r8.getPaddingTop()
                    int r2 = r2 + r5
                    goto L89
                L7c:
                    int r5 = r13 + 0
                    int r5 = r5 - r11
                    int r5 = r5 - r4
                    int r5 = r5 / 2
                    int r7 = r2.topMargin
                    int r5 = r5 + r7
                    int r2 = r2.bottomMargin
                L87:
                    int r2 = r5 - r2
                L89:
                    ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity r5 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.this
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited r5 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.access$400(r5)
                    if (r1 == r5) goto L99
                    ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity r5 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.this
                    ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout r5 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.access$500(r5)
                    if (r1 != r5) goto Lb5
                L99:
                    ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity r5 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.this
                    org.rbmain.ui.ActionBar.ActionBar r5 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.access$600(r5)
                    int r5 = r5.getMeasuredHeight()
                    int r2 = r2 + r5
                    ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity r5 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.this
                    boolean r5 = ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.access$700(r5)
                    if (r5 == 0) goto Lb5
                    int r5 = android.os.Build.VERSION.SDK_INT
                    r7 = 21
                    if (r5 < r7) goto Lb5
                    int r5 = org.rbmain.messenger.AndroidUtilities.statusBarHeight
                    int r2 = r2 + r5
                Lb5:
                    int r3 = r3 + r6
                    int r4 = r4 + r2
                    r1.layout(r6, r2, r3, r4)
                Lba:
                    int r0 = r0 + 1
                    goto L1a
                Lbe:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.AnonymousClass2.onLayout(boolean, int, int, int, int):void");
            }
        };
        this.sizeNotifierFrameLayout = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.3
            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
            public void onSizeChanged(int i3, boolean z2) {
                if (i3 == RubinoPostListActivity.this.lastKeyboardSize) {
                    return;
                }
                RubinoPostListActivity.this.lastKeyboardSize = i3;
                if (i3 > AndroidUtilities.getNavigationBarSize(context).y) {
                    int availableHeight = (AndroidUtilities.getAvailableHeight((Activity) context, i3, false) - ((BaseFragment) RubinoPostListActivity.this).actionBar.getHeight()) - RubinoPostListActivity.this.addCommentView.getHeight();
                    RubinoPostListActivity.this.getAppPreferences().setLong(AppPreferences.Key.RubinoAddCommentMargin, availableHeight);
                    if (RubinoPostListActivity.this.selectedPostCell != null) {
                        try {
                            ((LinearLayoutManager) RubinoPostListActivity.this.listView.getLayoutManager()).scrollToPositionWithOffset(((Integer) RubinoPostListActivity.this.selectedPostCell.getTag()).intValue(), (-RubinoPostListActivity.this.selectedPostCell.getAddCommentTop()) + availableHeight);
                            return;
                        } catch (Exception e) {
                            MyLog.handleException(e);
                            return;
                        }
                    }
                    return;
                }
                RubinoPostListActivity.this.hideAddCommentView();
            }
        });
        SizeNotifierFrameLayout sizeNotifierFrameLayout2 = this.sizeNotifierFrameLayout;
        this.fragmentView = sizeNotifierFrameLayout2;
        SizeNotifierFrameLayout sizeNotifierFrameLayout3 = sizeNotifierFrameLayout2;
        int i3 = Theme.key_windowBackgroundWhite;
        sizeNotifierFrameLayout3.setBackgroundColor(Theme.getColor(i3));
        RecyclerListViewEdited recyclerListViewEdited = new RecyclerListViewEdited(context);
        this.listView = recyclerListViewEdited;
        recyclerListViewEdited.setLayoutManager(new LinearLayoutManager(this, context, i, z) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setClipToPadding(false);
        this.listView.setClipChildren(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.addOnScrollListener(this.onScrollListener);
        if (this.type == homeRecentFollowingType) {
            this.mDetector = new GestureDetector(ApplicationLoader.applicationActivity, new MyGestureListener());
            this.listView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.5
                @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                public void onRequestDisallowInterceptTouchEvent(boolean z2) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                    RubinoPostListActivity.this.mDetector.onTouchEvent(motionEvent);
                    return false;
                }
            });
        }
        PullToRefreshLayout pullToRefreshLayout = new PullToRefreshLayout(context);
        this.swipeRefreshLayout = pullToRefreshLayout;
        pullToRefreshLayout.bindListViewToLayout(this.listView);
        sizeNotifierFrameLayout3.addView(this.swipeRefreshLayout, LayoutHelper.createFrame(-1, -1.0f));
        sizeNotifierFrameLayout3.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setBackgroundColor(Theme.getColor(i3));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListViewEdited.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda1
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemClickListener
            public final void onItemClick(View view, int i4) {
                RubinoPostListActivity.lambda$createView$0(view, i4);
            }
        });
        this.swipeRefreshLayout.setOnListViewTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                RubinoPostListActivity.this.setAutoPlayRunnable();
                return false;
            }
        });
        this.listView.setOnFlingListener(new RecyclerView.OnFlingListener(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
            public boolean onFling(int i4, int i5) {
                return false;
            }
        });
        this.swipeRefreshLayout.setEnabled(true);
        this.swipeRefreshLayout.setRefreshListener(this.onRefreshListener);
        if (this.type == homeRecentFollowingType) {
            this.swipeRefreshLayout.setUserInteractionEnabled(false);
            this.isHomeInited = false;
            this.needToRetry = false;
            this.homeActionBarView.setVisibility(4);
            updateRows();
            initHome(true, false);
        } else {
            this.swipeRefreshLayout.setUserInteractionEnabled(true);
            updateRows();
            int i4 = this.defaultPostIndex;
            if (i4 > 0) {
                try {
                    this.listView.scrollToPosition(i4);
                } catch (Exception unused) {
                }
            }
        }
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).newWakeLock(26, this.classGuid + BuildConfig.FLAVOR);
        this.wakeLock = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        FrameLayout frameLayout = new FrameLayout(context);
        this.touchConsumerView = frameLayout;
        sizeNotifierFrameLayout3.addView(frameLayout, LayoutHelper.createFrame(-1, -1.0f));
        this.touchConsumerView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoPostListActivity.this.hideAddCommentView();
            }
        });
        this.touchConsumerView.setVisibility(8);
        AddCommentView addCommentView = new AddCommentView(context, false);
        this.addCommentView = addCommentView;
        sizeNotifierFrameLayout3.addView(addCommentView, LayoutHelper.createFrame(-1, -2, 80));
        getAppPreferences().getLong(AppPreferences.Key.RubinoAddCommentMargin, 0L);
        this.addCommentView.setOnSendClickListener(new AddCommentView.OnSendClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.9
            @Override // ir.resaneh1.iptv.fragment.rubino.AddCommentView.OnSendClickListener
            public void onAddReplyClick(RubinoPostObject rubinoPostObject, String str, RubinoCommentObject rubinoCommentObject) {
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.AddCommentView.OnSendClickListener
            public void onAddCommentClick(RubinoPostObject rubinoPostObject, String str) {
                if (rubinoPostObject == null || str == null || str.isEmpty()) {
                    return;
                }
                String str2 = rubinoPostObject.post.id;
                RubinoCommentObject rubinoCommentObject = new RubinoCommentObject();
                int rndForString = RndHelper.getRndForString(str2 + str + rubinoPostObject.post.profile_id);
                rubinoCommentObject.setLocalComment(RubinoPostListActivity.this.getCurrentAccount(), str, rndForString);
                RubinoPostObject fromPostMapIfExist = RubinoPostListActivity.this.getRubinoController().getFromPostMapIfExist(str2);
                if (fromPostMapIfExist == null) {
                    fromPostMapIfExist = rubinoPostObject;
                }
                PostCell postCellFindVisibleViewForPostId = RubinoPostListActivity.this.findVisibleViewForPostId(str2);
                if (postCellFindVisibleViewForPostId != null) {
                    postCellFindVisibleViewForPostId.postObject = fromPostMapIfExist;
                    fromPostMapIfExist.myComments.add(rubinoCommentObject);
                    postCellFindVisibleViewForPostId.setCommentView();
                }
                RubinoPostListActivity.this.hideAddCommentView();
                RubinoPostListActivity rubinoPostListActivity = RubinoPostListActivity.this;
                RubinoController rubinoController = rubinoPostListActivity.getRubinoController();
                Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
                rubinoPostListActivity.disposable = (DisposableObserver) rubinoController.getAddCommentObservable(str, postObjectFromServer.id, postObjectFromServer.profile_id, rndForString).subscribeWith(new DisposableObserver<Rubino.CommentOutput>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.9.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Rubino.CommentOutput commentOutput) {
                        dispose();
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        dispose();
                    }
                });
            }
        });
        this.addCommentView.setVisibility(8);
        if (this.type == relatedPostListType) {
            this.actionBar.setAddToContainer(false);
            FrameLayout.LayoutParams layoutParamsCreateFrame = LayoutHelper.createFrame(-1, -2, 48);
            if (this.inPreviewMode && Build.VERSION.SDK_INT >= 21) {
                layoutParamsCreateFrame.topMargin = AndroidUtilities.statusBarHeight;
            }
            sizeNotifierFrameLayout3.addView(this.actionBar, layoutParamsCreateFrame);
        }
        return this.fragmentView;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void setInPreviewMode(boolean z) {
        ActionBar actionBar;
        super.setInPreviewMode(z);
        if (z || (actionBar = this.actionBar) == null || this.type != relatedPostListType) {
            return;
        }
        ((FrameLayout.LayoutParams) actionBar.getLayoutParams()).topMargin = 0;
    }

    public void hideAddCommentView() {
        this.addCommentView.setVisibility(8);
        this.touchConsumerView.setVisibility(8);
        AndroidUtilities.hideKeyboard(this.addCommentView.editText);
    }

    public void showAddCommentView(final RubinoPostObject rubinoPostObject, final CharSequence charSequence) {
        if (this.addCommentView.getVisibility() == 0 || !rubinoPostObject.post.allow_show_comment) {
            return;
        }
        try {
            AnimatorSet animatorSet = this.addCommentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.addCommentAnimation = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.addCommentView, "alpha", 0.0f, 1.0f));
            this.addCommentAnimation.setInterpolator(new DecelerateInterpolator());
            this.addCommentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (RubinoPostListActivity.this.addCommentAnimation == null || !RubinoPostListActivity.this.addCommentAnimation.equals(animator)) {
                        return;
                    }
                    RubinoPostListActivity.this.addCommentView.setVisibility(0);
                    RubinoPostListActivity.this.addCommentView.setAlpha(0.0f);
                    RubinoPostListActivity.this.touchConsumerView.setVisibility(0);
                    RubinoPostListActivity.this.addCommentView.editText.requestFocus();
                    if (charSequence != null) {
                        RubinoPostListActivity.this.addCommentView.editText.setText(charSequence);
                        RubinoPostListActivity.this.addCommentView.editText.setSelection(charSequence.length());
                    } else {
                        RubinoPostListActivity.this.addCommentView.editText.setText(BuildConfig.FLAVOR);
                    }
                    RubinoPostListActivity.this.addCommentView.setPost(rubinoPostObject);
                    AndroidUtilities.showKeyboard(RubinoPostListActivity.this.addCommentView.editText);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RubinoPostListActivity.this.addCommentAnimation == null || !RubinoPostListActivity.this.addCommentAnimation.equals(animator)) {
                        return;
                    }
                    RubinoPostListActivity.this.addCommentView.setAlpha(1.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (RubinoPostListActivity.this.addCommentAnimation == null || !RubinoPostListActivity.this.addCommentAnimation.equals(animator)) {
                        return;
                    }
                    RubinoPostListActivity.this.hideAddCommentView();
                }
            });
            this.addCommentAnimation.setDuration(300L);
            this.addCommentAnimation.start();
        } catch (Exception unused) {
        }
    }

    private void startNotificationAnimation() {
        int iDp;
        int paddingLeft;
        String str;
        try {
            AnimatorSet animatorSet = this.notificationAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (this.newEventRedView == null) {
                this.newEventRedView = new NewEventRedView(this.context);
                ((FrameLayout) this.fragmentView.getParent()).addView(this.newEventRedView, LayoutHelper.createFrame(-2, -2.0f, LocaleController.isRTL ? 5 : 3, 0.0f, 36.0f, 0.0f, 0.0f));
                this.newEventRedView.setVisibility(4);
            }
            RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject();
            if (LocaleController.isRTL) {
                iDp = AndroidUtilities.dp(69.0f);
                paddingLeft = this.actionBar.getPaddingRight();
            } else {
                iDp = AndroidUtilities.dp(69.0f);
                paddingLeft = this.actionBar.getPaddingLeft();
            }
            int i = iDp + paddingLeft;
            NewEventRedView newEventRedView = this.newEventRedView;
            String str2 = null;
            if (rubinoCurrentProfileObject.new_general_count > 0) {
                str = rubinoCurrentProfileObject.new_general_count + BuildConfig.FLAVOR;
            } else {
                str = null;
            }
            if (rubinoCurrentProfileObject.new_follow_request_count > 0) {
                str2 = rubinoCurrentProfileObject.new_follow_request_count + BuildConfig.FLAVOR;
            }
            newEventRedView.setText(str, str2, i);
            int calculatedWidth = this.newEventRedView.getCalculatedWidth();
            if (LocaleController.isRTL) {
                int i2 = calculatedWidth / 2 > i ? 0 : i - (calculatedWidth / 2);
                ((FrameLayout.LayoutParams) this.newEventRedView.getLayoutParams()).rightMargin = i2;
                ((FrameLayout.LayoutParams) this.newEventRedView.getLayoutParams()).leftMargin = (AndroidUtilities.getScreenWidth() - i2) - calculatedWidth;
            } else {
                int i3 = calculatedWidth / 2 > i ? 0 : i - (calculatedWidth / 2);
                ((FrameLayout.LayoutParams) this.newEventRedView.getLayoutParams()).rightMargin = (AndroidUtilities.getScreenWidth() - i3) + calculatedWidth;
                ((FrameLayout.LayoutParams) this.newEventRedView.getLayoutParams()).leftMargin = i3;
            }
            if (FlavorHelper.isShad()) {
                ((FrameLayout.LayoutParams) this.newEventRedView.getLayoutParams()).topMargin = 0;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.notificationAnimation = animatorSet2;
            if (this.homeActionBarView != null) {
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.newEventRedView, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.homeActionBarView.getImageViewCircleRed(), "alpha", 1.0f, 0.0f));
            } else {
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.newEventRedView, "alpha", 0.0f, 1.0f));
            }
            this.notificationAnimation.setInterpolator(new Interpolator() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.11
                final Interpolator interpolatorShow = new RubinoLikeInterpolator();
                final Interpolator interpolatorHide = new AccelerateDecelerateInterpolator();

                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    MyLog.e("RubinoPostListActivity", "getInterpolation  " + f);
                    if (f < 0.3f) {
                        return this.interpolatorShow.getInterpolation(f / 0.3f);
                    }
                    if (f < 0.9f) {
                        return 1.0f;
                    }
                    RubinoPostListActivity.this.homeActionBarView.setImageViewCircleRed(true);
                    return this.interpolatorHide.getInterpolation(1.0f - ((f - 0.9f) / 0.100000024f));
                }
            });
            this.notificationAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.12
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (RubinoPostListActivity.this.notificationAnimation == null || !RubinoPostListActivity.this.notificationAnimation.equals(animator)) {
                        return;
                    }
                    RubinoPostListActivity.this.homeActionBarView.setImageViewCircleRed(false);
                    RubinoPostListActivity.this.newEventRedView.setVisibility(0);
                    RubinoPostListActivity.this.newEventRedView.setAlpha(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RubinoPostListActivity.this.notificationAnimation == null || !RubinoPostListActivity.this.notificationAnimation.equals(animator)) {
                        return;
                    }
                    RubinoPostListActivity.this.homeActionBarView.setImageViewCircleRed(true);
                    try {
                        ((FrameLayout) RubinoPostListActivity.this.newEventRedView.getParent()).removeView(RubinoPostListActivity.this.newEventRedView);
                    } catch (Exception unused) {
                    }
                    RubinoPostListActivity.this.newEventRedView = null;
                    RubinoPostListActivity.this.notificationAnimation = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (RubinoPostListActivity.this.notificationAnimation == null || !RubinoPostListActivity.this.notificationAnimation.equals(animator)) {
                        return;
                    }
                    try {
                        ((FrameLayout) RubinoPostListActivity.this.newEventRedView.getParent()).removeView(RubinoPostListActivity.this.newEventRedView);
                    } catch (Exception unused) {
                    }
                    RubinoPostListActivity.this.newEventRedView = null;
                    RubinoPostListActivity.this.notificationAnimation = null;
                }
            });
            this.notificationAnimation.setDuration(2500L);
            this.notificationAnimation.start();
        } catch (Exception unused) {
        }
    }

    private void showFloatingButton() {
        FrameLayout frameLayout = this.floatingButtonContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(0);
        this.floatingHidden = true;
        this.floatingButtonContainer.setTranslationY(AndroidUtilities.dp(100.0f));
        hideFloatingButton(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createFloatingButtonIfNeeded(FrameLayout frameLayout) {
        if (RubinoController.getInstance(this.currentAccount).hasPermissionAddPost() && !FlavorHelper.isRubino() && this.floatingButton == null) {
            FrameLayout frameLayout2 = new FrameLayout(this.context);
            this.floatingButtonContainer = frameLayout2;
            int i = Build.VERSION.SDK_INT;
            int i2 = (i >= 21 ? 56 : 60) + 20;
            float f = (i >= 21 ? 56 : 60) + 14;
            boolean z = LocaleController.isRTL;
            frameLayout.addView(frameLayout2, LayoutHelper.createFrame(i2, f, (z ? 3 : 5) | 80, z ? 4.0f : 0.0f, 0.0f, z ? 0.0f : 4.0f, 0.0f));
            this.floatingButtonContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RubinoPostListActivity.lambda$createFloatingButtonIfNeeded$1(view);
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
                this.floatingButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.13
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
    public static /* synthetic */ void lambda$createFloatingButtonIfNeeded$1(View view) {
        new MainClickHandler().addRubinoPost();
    }

    private static class StoryAndPostOutput {
        Rubino.PostObjectList postOutput;
        Rubino.ProfilesStoriesListObject storyOutput;

        private StoryAndPostOutput() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObservableSource<StoryAndPostOutput> getStoryAndPostObservable() {
        return Observable.zip(getStoryController().getStoryObservable(true, null, null), getRubinoController().getRecentFollowingPostsObservable(null, null, 30, Rubino.SortEnum.FromMax), new BiFunction<Rubino.ProfilesStoriesListObject, Rubino.PostObjectList, StoryAndPostOutput>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.14
            @Override // io.reactivex.functions.BiFunction
            public StoryAndPostOutput apply(Rubino.ProfilesStoriesListObject profilesStoriesListObject, Rubino.PostObjectList postObjectList) throws Exception {
                StoryAndPostOutput storyAndPostOutput = new StoryAndPostOutput();
                storyAndPostOutput.storyOutput = profilesStoriesListObject;
                storyAndPostOutput.postOutput = postObjectList;
                return storyAndPostOutput;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initHome(boolean z, final boolean z2) {
        DisposableObserver disposableObserver = this.disposable;
        if (disposableObserver == null || disposableObserver.isDisposed()) {
            DisposableObserver disposableObserver2 = (DisposableObserver) getRubinoController().getCheckProfileObservable(z, !z2).flatMap(new Function<Integer, ObservableSource<StoryAndPostOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.16
                @Override // io.reactivex.functions.Function
                public ObservableSource<StoryAndPostOutput> apply(Integer num) throws Exception {
                    return RubinoPostListActivity.this.getStoryAndPostObservable();
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<StoryAndPostOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.15
                @Override // io.reactivex.Observer
                public void onNext(StoryAndPostOutput storyAndPostOutput) {
                    if (RubinoPostListActivity.this.swipeRefreshLayout != null) {
                        RubinoPostListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    }
                    RubinoPostListActivity.this.selectedCellForAutoPlay = null;
                    RubinoPostListActivity.this.selectedCellForPreload = null;
                    RubinoPostListActivity.this.homeActionBarView.setVisibility(0);
                    if (!RubinoPostListActivity.this.isHomeInited) {
                        RubinoPostListActivity.this.checkNewNotificationAndPopup(true);
                    }
                    RubinoPostListActivity.this.isHomeInited = true;
                    RubinoPostListActivity rubinoPostListActivity = RubinoPostListActivity.this;
                    rubinoPostListActivity.createFloatingButtonIfNeeded((FrameLayout) rubinoPostListActivity.fragmentView);
                    if (storyAndPostOutput != null) {
                        Rubino.ProfilesStoriesListObject profilesStoriesListObject = storyAndPostOutput.storyOutput;
                        if (profilesStoriesListObject != null) {
                            RubinoPostListActivity.this.onStoryLoaded(profilesStoriesListObject, false);
                        }
                        Rubino.PostObjectList postObjectList = storyAndPostOutput.postOutput;
                        if (postObjectList != null) {
                            RubinoPostListActivity.this.onPostLoaded(postObjectList, true, z2, false);
                        }
                        RubinoPostListActivity.this.updateRows();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    dispose();
                    if (RubinoPostListActivity.this.swipeRefreshLayout != null) {
                        RubinoPostListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    }
                    if (RubinoPostListActivity.this.postArray.size() == 0) {
                        RubinoPostListActivity.this.needToRetry = true;
                    }
                    RubinoPostListActivity.this.updateRows();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
            this.disposable = disposableObserver2;
            this.compositeDisposable.add(disposableObserver2);
        }
    }

    void updateRows() {
        CrashHandelHelper.setLastActionRubino("UpdateRows", "start");
        this.storySectionRow = -1;
        this.postStartRow = -1;
        this.emptyViewRow = -1;
        this.postEndRow = -1;
        this.loadingRow = -1;
        this.sendingPostStartRow = -1;
        this.sendingPostStartRow2 = -1;
        this.sendingPostEndRow = -1;
        this.sendingPostEndRow2 = -1;
        this.retryRow = -1;
        this.loadMorePosition = Math.max(0, this.postArray.size() - 10);
        this.rowCount = 0;
        int i = this.type;
        int i2 = homeRecentFollowingType;
        if (i == i2 && this.needToRetry) {
            this.rowCount = 0 + 1;
            this.retryRow = 0;
        } else if (i == i2 && !this.isHomeInited) {
            this.rowCount = 0 + 1;
            this.loadingRow = 0;
        } else {
            if (i == i2) {
                ArrayList<StoryListOfAProfileObject> arrayList = this.storyProfileList;
                if (arrayList != null && arrayList.size() > 0) {
                    int i3 = this.rowCount;
                    this.rowCount = i3 + 1;
                    this.storySectionRow = i3;
                }
                this.sendingPostArray.clear();
                Iterator<InstaDraftManager.SendingPostInsta> it = InstaDraftManager.getInstance(this.currentAccount).sendingMediaInfoMap.values().iterator();
                while (it.hasNext()) {
                    this.sendingPostArray.add(it.next());
                }
                if (this.sendingPostArray.size() > 0) {
                    int i4 = this.rowCount;
                    this.sendingPostStartRow = i4;
                    int size = i4 + this.sendingPostArray.size();
                    this.rowCount = size;
                    this.sendingPostEndRow = size;
                }
                this.sendingPostArray2.clear();
                Iterator<RubinoDraftManager.RubinoSendingPost> it2 = RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap.values().iterator();
                while (it2.hasNext()) {
                    this.sendingPostArray2.add(it2.next());
                }
                if (this.sendingPostArray2.size() > 0) {
                    int i5 = this.rowCount;
                    this.sendingPostStartRow2 = i5;
                    int size2 = i5 + this.sendingPostArray2.size();
                    this.rowCount = size2;
                    this.sendingPostEndRow2 = size2;
                }
            }
            if (this.type == homeRecentFollowingType) {
                if (this.postArray.size() > 0 || this.suggestedArray.size() > 0) {
                    int i6 = this.rowCount;
                    this.postStartRow = i6;
                    int size3 = i6 + this.postArray.size() + this.suggestedArray.size();
                    this.rowCount = size3;
                    this.postEndRow = size3;
                }
            } else if (this.postArray.size() > 0) {
                int i7 = this.rowCount;
                this.postStartRow = i7;
                int size4 = i7 + this.postArray.size();
                this.rowCount = size4;
                this.postEndRow = size4;
            }
            if (this.hasContinue) {
                if (this.type == homeRecentFollowingType) {
                    if (this.isHomeInited) {
                        int i8 = this.rowCount;
                        this.rowCount = i8 + 1;
                        this.loadingRow = i8;
                    }
                } else {
                    int i9 = this.rowCount;
                    this.rowCount = i9 + 1;
                    this.loadingRow = i9;
                }
            }
            if (this.postArray.size() <= 0 && this.sendingPostArray.size() <= 0) {
                if (this.loadingRow < 0) {
                    if (this.type == homeRecentFollowingType) {
                        showFloatingButton();
                    }
                    int i10 = this.rowCount;
                    this.rowCount = i10 + 1;
                    this.emptyViewRow = i10;
                }
            } else {
                this.emptyViewRow = -1;
            }
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        MyLog.e("RubinoPostListActivity", "postStartRow " + this.postStartRow);
        MyLog.e("RubinoPostListActivity", "postEndRow " + this.postEndRow);
        CrashHandelHelper.setLastActionRubino("UpdateRows", "end");
    }

    private void updateRowsOnAddPost() {
        if (this.postStartRow < 0 || this.postArray.size() <= 0) {
            updateRows();
            return;
        }
        try {
            CrashHandelHelper.setLastActionRubino("UpdateRowsOnAddPost", "start");
            this.loadMorePosition = Math.max(0, this.postArray.size() - 10);
            int i = this.rowCount;
            int i2 = this.postStartRow;
            this.rowCount = i2;
            int size = i2 + this.postArray.size() + (this.type == homeRecentFollowingType ? this.suggestedArray.size() : 0);
            this.rowCount = size;
            this.postEndRow = size;
            int i3 = this.loadingRow;
            if (this.hasContinue) {
                this.rowCount = size + 1;
                this.loadingRow = size;
            } else {
                this.loadingRow = -1;
            }
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                int i4 = this.rowCount;
                if (i > i4) {
                    listAdapter.notifyItemRangeRemoved(i3, i - i4);
                } else {
                    listAdapter.notifyItemRangeChanged(i3, 1);
                    this.listAdapter.notifyItemRangeInserted(i3 + 1, this.rowCount - i3);
                }
            }
            CrashHandelHelper.setLastActionRubino("UpdateRowsOnAddPost", "end");
        } catch (Exception e) {
            MyLog.handleException(e);
            CrashHandelHelper.handleCrashOnMyLog(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPosts(final boolean z, final boolean z2) {
        if (z || this.hasContinue) {
            if (z) {
                DisposableObserver disposableObserver = this.refreshPostsObserver;
                if (disposableObserver != null && !disposableObserver.isDisposed()) {
                    PullToRefreshLayout pullToRefreshLayout = this.swipeRefreshLayout;
                    if (pullToRefreshLayout != null) {
                        pullToRefreshLayout.setRefreshing(false, true);
                        return;
                    }
                    return;
                }
                if (z2 && System.currentTimeMillis() - this.lastManualRefreshTime < 10000) {
                    DisposableObserver disposableObserver2 = this.fakeObserver;
                    if (disposableObserver2 != null && !disposableObserver2.isDisposed()) {
                        this.fakeObserver.dispose();
                    }
                    DisposableObserver disposableObserver3 = (DisposableObserver) Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.18
                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            if (RubinoPostListActivity.this.swipeRefreshLayout != null) {
                                RubinoPostListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
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
                    this.fakeObserver = disposableObserver3;
                    this.compositeDisposable.add(disposableObserver3);
                    return;
                }
                DisposableObserver disposableObserver4 = this.loadPostsObserver;
                if (disposableObserver4 != null && !disposableObserver4.isDisposed()) {
                    this.loadPostsObserver.dispose();
                }
            } else {
                DisposableObserver disposableObserver5 = this.loadPostsObserver;
                if (disposableObserver5 != null && !disposableObserver5.isDisposed()) {
                    return;
                }
                DisposableObserver disposableObserver6 = this.refreshPostsObserver;
                if (disposableObserver6 != null && !disposableObserver6.isDisposed()) {
                    this.refreshPostsObserver.dispose();
                    PullToRefreshLayout pullToRefreshLayout2 = this.swipeRefreshLayout;
                    if (pullToRefreshLayout2 != null) {
                        pullToRefreshLayout2.setRefreshing(false, true);
                    }
                }
            }
            DisposableObserver disposableObserver7 = this.fakeObserver;
            if (disposableObserver7 != null && !disposableObserver7.isDisposed()) {
                this.fakeObserver.dispose();
            }
            Rubino.SortEnum sortEnum = Rubino.SortEnum.FromMax;
            int i = this.type;
            Observable<Rubino.PostObjectList> hashtagPostsObservable = null;
            if (i == homeRecentFollowingType) {
                hashtagPostsObservable = getRubinoController().getRecentFollowingPostsObservable(z ? null : this.minId, z ? null : this.maxId, 30, sortEnum);
            } else if (i == profilePostListType) {
                RubinoController rubinoController = getRubinoController();
                RubinoProfileObject rubinoProfileObject = this.profileObject;
                hashtagPostsObservable = rubinoController.getProfilePostsObservable(rubinoProfileObject.isMyProfile, rubinoProfileObject.id, z ? null : this.minId, z ? null : this.maxId, 30, sortEnum);
            } else if (i == taggedPostListType) {
                hashtagPostsObservable = getRubinoController().getTagPostsObservable(this.profileObject.id, z ? null : this.maxId);
            } else if (i == bookmarkPostListType) {
                hashtagPostsObservable = getRubinoController().getBookmarkPostsObservable(z ? null : this.maxId, 30);
            } else if (i == onePostType) {
                hashtagPostsObservable = getRubinoController().getOnePostObservable(this.selectedPostProfileId, this.selectedPostId, z);
            } else if (i == relatedPostListType) {
                hashtagPostsObservable = getRubinoController().getRelatedPostsObservable(this.selectedPost, this.selectedPostPosition, z ? null : this.nextStartId, (z || this.postArray.size() == 0) ? 10 : 30);
            } else if (i == hashtagPostListType) {
                RubinoController rubinoController2 = getRubinoController();
                String str = this.hashtag;
                hashtagPostsObservable = rubinoController2.getHashtagPostsObservable(str != null ? str.replace("#", BuildConfig.FLAVOR) : null, z ? null : this.nextStartId, 30);
            }
            DisposableObserver disposableObserver8 = (DisposableObserver) hashtagPostsObservable.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.PostObjectList>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.19
                @Override // io.reactivex.Observer
                public void onNext(Rubino.PostObjectList postObjectList) {
                    RubinoPostListActivity.this.isAutoScrollEnable = postObjectList.isAutoScrollEnable;
                    RubinoPostListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    RubinoPostListActivity.this.onPostLoaded(postObjectList, z, z2, true);
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    RubinoPostListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    dispose();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
            if (z) {
                this.refreshPostsObserver = disposableObserver8;
            } else {
                this.loadPostsObserver = disposableObserver8;
            }
            this.compositeDisposable.add(disposableObserver8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostLoaded(Rubino.PostObjectList postObjectList, boolean z, boolean z2, boolean z3) {
        RubinoPostObject rubinoPostObject;
        int i;
        this.swipeRefreshLayout.setUserInteractionEnabled(true);
        if (z || this.maxId == null) {
            this.lastUpdatedPostTime = System.currentTimeMillis();
        }
        if (z && z2) {
            this.lastManualRefreshTime = System.currentTimeMillis();
        }
        if (postObjectList != null) {
            if (z || (this.type == relatedPostListType && this.postArray.size() == 0)) {
                this.postArray.clear();
                this.postMap.clear();
                this.positionMap.clear();
                this.suggestedArray.clear();
                if (this.type == relatedPostListType && (rubinoPostObject = postObjectList.selectedPost) != null) {
                    this.selectedPost = rubinoPostObject;
                    this.postArray.add(rubinoPostObject);
                    Map<String, RubinoPostObject> map = this.postMap;
                    RubinoPostObject rubinoPostObject2 = this.selectedPost;
                    map.put(rubinoPostObject2.post.id, rubinoPostObject2);
                }
            }
            boolean z4 = false;
            if (this.type == homeRecentFollowingType) {
                int size = this.postArray.size() + this.suggestedArray.size();
                int size2 = this.postArray.size();
                ArrayList<Rubino.SplitPost> arrayList = postObjectList.sortedItems;
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<Rubino.SplitPost> it = postObjectList.sortedItems.iterator();
                    while (it.hasNext()) {
                        Rubino.SplitPost next = it.next();
                        if (next.type == Rubino.SplitPostTypeEnum.SuggestedProfile) {
                            int i2 = next.index + size;
                            next.index = i2;
                            this.suggestedArray.put(i2, next);
                            MyLog.e("RubinoPostListActivity", "suggestedArray " + next.index);
                        }
                    }
                }
                if (postObjectList.posts != null) {
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        int size3 = postObjectList.posts.size();
                        ArrayList<Rubino.SplitPost> arrayList2 = postObjectList.sortedItems;
                        if (i3 >= size3 + (arrayList2 != null ? arrayList2.size() : 0) || i4 >= postObjectList.posts.size()) {
                            break;
                        }
                        int i5 = i3 + size;
                        if (this.suggestedArray.get(i5) == null) {
                            this.positionMap.put(Integer.valueOf(i5), Integer.valueOf(i4 + size2));
                            MyLog.e("RubinoPostListActivity", i5 + " real " + i4 + size2);
                            i4++;
                        }
                        i3++;
                    }
                }
            }
            ArrayList<RubinoPostObject> arrayList3 = postObjectList.posts;
            if (arrayList3 != null) {
                this.postArray.addAll(arrayList3);
                Iterator<RubinoPostObject> it2 = this.postArray.iterator();
                while (it2.hasNext()) {
                    RubinoPostObject next2 = it2.next();
                    this.postMap.put(next2.post.id, next2);
                }
                if (postObjectList.posts.size() > 0 && (i = this.type) != onePostType && i != hashtagPostListType) {
                    z4 = true;
                }
                this.hasContinue = z4;
                if (postObjectList.posts.size() > 0) {
                    ArrayList<RubinoPostObject> arrayList4 = postObjectList.posts;
                    this.maxId = arrayList4.get(arrayList4.size() - 1).post.id;
                }
            } else {
                this.hasContinue = false;
            }
            if (this.type == hashtagPostListType) {
                this.hasContinue = postObjectList.hasContinue;
            }
            this.nextStartId = postObjectList.nextStartId;
            if (z3) {
                if (z) {
                    updateRows();
                } else {
                    updateRowsOnAddPost();
                }
            }
            setAutoPlayRunnable();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        Log.i("RubinoPostList", "onPause: ");
        getStoryController().unSetCurrentLoadingProfile();
        cancelImagerTimer();
        cancelAutoPlayRunnable();
        cancelPlaySelectedCellRunnable();
        cancelPreloadVideoRunnable();
        cancelAlreadyPreloading();
        cancelShowCommentRunnable();
        getNotificationCenter().postNotificationName(NotificationCenter.playersShouldPause, Integer.valueOf(this.classGuid));
        getRubinoController().releaseExistingCachedPlayers();
        if (this.wakeLock.isHeld()) {
            this.wakeLock.release();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        RecyclerListViewEdited recyclerListViewEdited;
        RecyclerListViewEdited recyclerListViewEdited2;
        super.onResume();
        if (this.type == homeRecentFollowingType) {
            if (!this.isHomeInited || System.currentTimeMillis() - this.lastUpdatedStoryTime > STORY_AND_POST_UPDATE_DURATION || System.currentTimeMillis() - this.lastUpdatedPostTime > STORY_AND_POST_UPDATE_DURATION) {
                scrollToTop();
                initHome(true, false);
            } else {
                if (this.needToRefreshStory) {
                    this.needToRefreshStory = false;
                    refreshStory();
                }
                if (this.listAdapter != null && (recyclerListViewEdited2 = this.listView) != null) {
                    recyclerListViewEdited2.post(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.20
                        @Override // java.lang.Runnable
                        public void run() {
                            RubinoPostListActivity.this.listAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        } else if (this.listAdapter != null && (recyclerListViewEdited = this.listView) != null) {
            recyclerListViewEdited.post(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.21
                @Override // java.lang.Runnable
                public void run() {
                    RubinoPostListActivity.this.listAdapter.notifyDataSetChanged();
                }
            });
        }
        setAutoPlayRunnable(ImageReceiver.DEFAULT_CROSSFADE_DURATION);
    }

    private void updateVisibleStoryState() {
        StoryHorizontalListView storyListView = getStoryListView();
        if (storyListView == null) {
            return;
        }
        int childCount = storyListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = storyListView.getChildAt(i);
            if (childAt instanceof StoryProfileCell) {
                ((StoryProfileCell) childAt).setStoryStatus();
            }
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        ArrayList<StoryListOfAProfileObject> arrayList;
        PostCell postCellFindVisibleViewForPostId;
        PostCell postCellFindVisibleViewForPostId2;
        PostCell postCellFindVisibleViewForPostId3;
        PostCell postCellFindVisibleViewForPostId4;
        int i3 = 0;
        if (i == NotificationCenter.rubinoProfileDidLoad) {
            String str = (String) objArr[0];
            String str2 = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
            if (str2 == null || str == null || !str.equals(str2) || !this.isHomeInited) {
                return;
            }
            checkNewNotificationAndPopup(true);
            return;
        }
        if (i == NotificationCenter.rubinoMyProfileNotifCountChange) {
            if (this.isHomeInited) {
                checkNewNotificationAndPopup(false);
                return;
            }
            return;
        }
        if (i == NotificationCenter.myInstaRefreshSendingView) {
            refreshSendingPosts();
            return;
        }
        if (i == NotificationCenter.myInstaPostChangeProgressView) {
            refreshSendingProgress();
            return;
        }
        if (i == NotificationCenter.myInstaSendPostDone) {
            this.swipeRefreshLayout.setRefreshing(true, true);
            this.compositeDisposable.add((Disposable) Observable.timer(800L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.22
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    RubinoPostListActivity.this.getPosts(true, false);
                }
            }));
            return;
        }
        if (i == NotificationCenter.rubinoLikePostChanged) {
            String str3 = (String) objArr[0];
            boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
            long jLongValue = ((Long) objArr[2]).longValue();
            RubinoPostObject fromPostMapIfExist = getRubinoController().getFromPostMapIfExist(str3);
            if (fromPostMapIfExist == null && (fromPostMapIfExist = this.postMap.get(str3)) != null) {
                fromPostMapIfExist.isLiked = zBooleanValue;
                fromPostMapIfExist.post.likes_count = jLongValue;
                fromPostMapIfExist.createLikeCountSpan();
            }
            if (fromPostMapIfExist == null || (postCellFindVisibleViewForPostId4 = findVisibleViewForPostId(str3)) == null) {
                return;
            }
            postCellFindVisibleViewForPostId4.postObject = fromPostMapIfExist;
            postCellFindVisibleViewForPostId4.setLikeAndViewCount();
            postCellFindVisibleViewForPostId4.setLikeIcon(!this.isPaused);
            return;
        }
        if (i == NotificationCenter.rubinoBookmarkPostChanged) {
            String str4 = (String) objArr[0];
            boolean zBooleanValue2 = ((Boolean) objArr[1]).booleanValue();
            RubinoPostObject fromPostMapIfExist2 = getRubinoController().getFromPostMapIfExist(str4);
            if (fromPostMapIfExist2 == null && (fromPostMapIfExist2 = this.postMap.get(str4)) != null) {
                fromPostMapIfExist2.isBookmarked = zBooleanValue2;
            }
            if (fromPostMapIfExist2 == null || (postCellFindVisibleViewForPostId3 = findVisibleViewForPostId(str4)) == null) {
                return;
            }
            postCellFindVisibleViewForPostId3.postObject = fromPostMapIfExist2;
            postCellFindVisibleViewForPostId3.setBookmarkIcon(!this.isPaused);
            return;
        }
        if (i == NotificationCenter.rubinoCommentCountChange) {
            String str5 = (String) objArr[0];
            long jLongValue2 = ((Long) objArr[1]).longValue();
            RubinoPostObject fromPostMapIfExist3 = getRubinoController().getFromPostMapIfExist(str5);
            if (fromPostMapIfExist3 == null && (fromPostMapIfExist3 = this.postMap.get(str5)) != null) {
                fromPostMapIfExist3.post.comment_count = jLongValue2;
                fromPostMapIfExist3.createCommentCountSpan();
            }
            if (fromPostMapIfExist3 == null || (postCellFindVisibleViewForPostId2 = findVisibleViewForPostId(str5)) == null) {
                return;
            }
            postCellFindVisibleViewForPostId2.postObject = fromPostMapIfExist3;
            postCellFindVisibleViewForPostId2.setCommentView();
            return;
        }
        if (i == NotificationCenter.rubinoPostEdited) {
            String str6 = (String) objArr[0];
            RubinoPostObject fromPostMapIfExist4 = getRubinoController().getFromPostMapIfExist(str6);
            if (fromPostMapIfExist4 == null || (postCellFindVisibleViewForPostId = findVisibleViewForPostId(str6)) == null) {
                return;
            }
            postCellFindVisibleViewForPostId.setPostObject(fromPostMapIfExist4, this.classGuid);
            return;
        }
        if (i == NotificationCenter.rubinoPostDeleted) {
            String str7 = (String) objArr[0];
            RubinoPostObject rubinoPostObjectRemove = this.postMap.remove(str7);
            if (rubinoPostObjectRemove != null) {
                this.postArray.remove(rubinoPostObjectRemove);
                this.postMap.remove(str7);
                int i4 = this.type;
                if ((i4 == onePostType || i4 == profilePostListType) && this.postArray.size() == 0) {
                    if (ApplicationLoader.applicationActivity.getLastFragment() == this) {
                        ApplicationLoader.applicationActivity.onBackPressed();
                    } else {
                        removeSelfFromStack();
                    }
                }
                updateRows();
                return;
            }
            return;
        }
        if (i == NotificationCenter.allStoriesIsSeenChanged || i == NotificationCenter.sendingStoryStatusChanges || i == NotificationCenter.storyCurrentLoadingProfileChanged) {
            updateVisibleStoryState();
            if (i == NotificationCenter.allStoriesIsSeenChanged) {
                updatePostStoryStatus();
                return;
            }
            return;
        }
        if (i == NotificationCenter.myFirstStoryAdded || i == NotificationCenter.myStoryDeleted || i == NotificationCenter.myStoryAdded) {
            updateVisibleStoryState();
            return;
        }
        if (i == NotificationCenter.storyListEmptyDetected) {
            String str8 = (String) objArr[0];
            ArrayList<StoryListOfAProfileObject> arrayList2 = this.storyProfileList;
            if (arrayList2 != null) {
                Iterator<StoryListOfAProfileObject> it = arrayList2.iterator();
                while (it.hasNext()) {
                    StoryListOfAProfileObject next = it.next();
                    if (str8.equals(next.profileObject.id) && !next.isLive) {
                        if (next.isMyStory()) {
                            updateVisibleStoryState();
                            return;
                        } else {
                            this.storyProfileList.remove(next);
                            updateStoryView();
                            return;
                        }
                    }
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.rubinoLiveStatusChanged) {
            String str9 = (String) objArr[0];
            RubinoProfileObject rubinoProfileObject = (RubinoProfileObject) objArr[1];
            if (getStoryController().profileHasLive(str9)) {
                if (getRubinoController().isProfileFollowed(rubinoProfileObject) && (arrayList = this.storyProfileList) != null) {
                    Iterator<StoryListOfAProfileObject> it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        StoryListOfAProfileObject next2 = it2.next();
                        if (next2.isLive && str9.equals(next2.profileObject.id)) {
                            i3 = 1;
                            break;
                        }
                    }
                    if (i3 == 0) {
                        StoryListOfAProfileObject storyListOfAProfileObject = new StoryListOfAProfileObject(getCurrentAccount());
                        RubinoProfileObject rubinoProfileObject2 = getRubinoController().profileMap.get(str9);
                        if (rubinoProfileObject2 != null) {
                            storyListOfAProfileObject.profileObject = rubinoProfileObject2;
                        } else {
                            storyListOfAProfileObject.profileObject = rubinoProfileObject;
                        }
                        storyListOfAProfileObject.isLive = true;
                        ArrayList<StoryListOfAProfileObject> arrayList3 = this.storyProfileList;
                        if (arrayList3 == null || this.liveCount + 1 > arrayList3.size()) {
                            return;
                        }
                        this.storyProfileList.add(this.liveCount + 1, storyListOfAProfileObject);
                        this.liveCount++;
                        updateStoryView();
                        return;
                    }
                    return;
                }
                return;
            }
            ArrayList<StoryListOfAProfileObject> arrayList4 = this.storyProfileList;
            if (arrayList4 != null) {
                Iterator<StoryListOfAProfileObject> it3 = arrayList4.iterator();
                while (it3.hasNext()) {
                    StoryListOfAProfileObject next3 = it3.next();
                    if (next3.isLive && str9.equals(next3.profileObject.id)) {
                        this.storyProfileList.remove(next3);
                        this.liveCount--;
                        updateStoryView();
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.rubinoFollowBlockChanged) {
            this.lastUpdatedStoryTime = 0L;
            int i5 = this.type;
            if (i5 == relatedPostListType) {
                String str10 = (String) objArr[0];
                while (i3 < this.listView.getChildCount()) {
                    View childAt = this.listView.getChildAt(i3);
                    if (childAt instanceof PostCell) {
                        PostCell postCell = (PostCell) childAt;
                        if (postCell.postObject.post.profile_id.equals(str10)) {
                            postCell.setUserNameAndFollowView();
                        }
                    }
                    i3++;
                }
                return;
            }
            if (i5 == homeRecentFollowingType) {
                String str11 = (String) objArr[0];
                while (i3 < this.listView.getChildCount()) {
                    View childAt2 = this.listView.getChildAt(i3);
                    if (childAt2 instanceof ProfileHorizontalListView) {
                        ((ProfileHorizontalListView) childAt2).updateItem(str11);
                    }
                    i3++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNewNotificationAndPopup(boolean z) {
        RubinoProfileObject rubinoCurrentProfileObject;
        String str;
        if (FlavorHelper.isRubino() || (rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject()) == null || (str = rubinoCurrentProfileObject.id) == null || str.isEmpty()) {
            return;
        }
        if (rubinoCurrentProfileObject.new_general_count > 0 || rubinoCurrentProfileObject.new_follow_request_count > 0) {
            RubinoHomeActionBarView rubinoHomeActionBarView = this.homeActionBarView;
            if (rubinoHomeActionBarView != null) {
                rubinoHomeActionBarView.setImageViewCircleRed(true);
            }
            if (z || MyLog.isDebugAble) {
                startNotificationAnimation();
                return;
            }
            return;
        }
        RubinoHomeActionBarView rubinoHomeActionBarView2 = this.homeActionBarView;
        if (rubinoHomeActionBarView2 != null) {
            rubinoHomeActionBarView2.setImageViewCircleRed(false);
        }
        NewEventRedView newEventRedView = this.newEventRedView;
        if (newEventRedView != null) {
            newEventRedView.setVisibility(8);
        }
        AnimatorSet animatorSet = this.notificationAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    private void refreshSendingProgress() {
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof InstaSendingPostView) {
                ((InstaSendingPostView) childAt).setProgress();
            } else if (childAt instanceof RubinoSendingPostView) {
                ((RubinoSendingPostView) childAt).setProgress();
            }
        }
    }

    private void refreshSendingPosts() {
        updateRows();
    }

    private StoryHorizontalListView getStoryListView() {
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.listView.getChildAt(i) instanceof StoryHorizontalListView) {
                return (StoryHorizontalListView) this.listView.getChildAt(i);
            }
        }
        return null;
    }

    private void updatePostStoryStatus() {
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.listView.getChildAt(i) instanceof PostCell) {
                ((PostCell) this.listView.getChildAt(i)).setStoryStatus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PostCell findVisibleViewForPostId(String str) {
        PostCell postCell;
        RubinoPostObject rubinoPostObject;
        Rubino.PostObjectFromServer postObjectFromServer;
        String str2;
        for (int i = 0; i < this.listView.getChildCount(); i++) {
            View childAt = this.listView.getChildAt(i);
            if ((childAt instanceof PostCell) && (rubinoPostObject = (postCell = (PostCell) childAt).postObject) != null && (postObjectFromServer = rubinoPostObject.post) != null && (str2 = postObjectFromServer.id) != null && str2.equals(str)) {
                return postCell;
            }
        }
        return null;
    }

    public void scrollToTop() {
        try {
            this.listView.smoothScrollToPosition(0);
        } catch (Exception unused) {
        }
    }

    class ListAdapter extends RecyclerListViewEdited.SelectionAdapter {
        Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            return (view instanceof StoryHorizontalListView) || (view instanceof RubinoRetryView) || (view instanceof ProfileHorizontalListView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoPostListActivity.this.rowCount;
        }

        /* renamed from: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$ListAdapter$2, reason: invalid class name */
        class AnonymousClass2 extends PostCell {
            AnonymousClass2(Context context, ViewGroup viewGroup, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
                super(context, viewGroup, z, z2, z3, z4, z5);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                try {
                    Iterator<PhotoViewerObject> it = this.postObject.photoSlideObject.getPhotos().iterator();
                    while (it.hasNext()) {
                        PhotoViewerObject next = it.next();
                        if (next.isVideo) {
                            FileLoaderRubinoPost.getInstance(this.currentAccount).cancelLoadFile(next);
                            PhotoViewerObject photoViewerObject = this.photoViewerCell.currentObject;
                            if (photoViewerObject.isVideo) {
                                int i = (int) (photoViewerObject.lastPlayedPosition / 1000);
                                MyLog.e("RubinoPostListActivity", "lastPlayedPosition " + i + " duration " + this.photoViewerCell.currentObject.duration);
                                RubinoPostListActivity.this.callViewPostTime(this.postObject, i);
                            }
                        } else {
                            new Handler().post(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$ListAdapter$2$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onDetachedFromWindow$0();
                                }
                            });
                        }
                    }
                } catch (Exception unused) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onDetachedFromWindow$0() {
                if (RubinoPostListActivity.this.selectedCellForImageTimer != null) {
                    RubinoPostListActivity.this.selectedCellForImageTimer.photoViewerCell.cancelImageTimer();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(PostCell postCell) {
            LinearLayoutManager linearLayoutManager;
            if (RubinoPostListActivity.this.touchConsumerView.getVisibility() == 0 || (linearLayoutManager = (LinearLayoutManager) RubinoPostListActivity.this.listView.getLayoutManager()) == null || RubinoPostListActivity.this.listView.getChildAdapterPosition(postCell) >= linearLayoutManager.getItemCount() - 1) {
                return;
            }
            RubinoPostListActivity.this.smoothScroller.setTargetPosition(RubinoPostListActivity.this.listView.getChildAdapterPosition(postCell) + 1);
            linearLayoutManager.startSmoothScroll(RubinoPostListActivity.this.smoothScroller);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            View rubinoLoadingCell;
            if (i == 0) {
                final AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.mContext, viewGroup, RubinoPostListActivity.this.type == RubinoPostListActivity.relatedPostListType, false, true, false, RubinoPostListActivity.this.type == RubinoPostListActivity.relatedPostListType && RubinoPostListActivity.this.isAutoScrollEnable);
                if (RubinoPostListActivity.this.type == RubinoPostListActivity.relatedPostListType && RubinoPostListActivity.this.isAutoScrollEnable) {
                    anonymousClass2.setPlayerDelegate(new PhotoViewerCell.PlayerDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity$ListAdapter$$ExternalSyntheticLambda0
                        @Override // ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.PlayerDelegate
                        public final void onVideoEnded() {
                            this.f$0.lambda$onCreateViewHolder$0(anonymousClass2);
                        }
                    });
                }
                anonymousClass2.setAddCommentListener(RubinoPostListActivity.this.addCommentListener);
                view = anonymousClass2;
            } else {
                switch (i) {
                    case 2:
                        View storyHorizontalListView = new StoryHorizontalListView(this.mContext, RubinoPostListActivity.this.compositeDisposable);
                        storyHorizontalListView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(106.0f)));
                        rubinoLoadingCell = storyHorizontalListView;
                        break;
                    case 3:
                        View instaSendingPostView = new InstaSendingPostView(this.mContext);
                        instaSendingPostView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                        view = instaSendingPostView;
                        break;
                    case 4:
                        View rubinoEmptyView = new RubinoEmptyView(this.mContext, 1);
                        rubinoEmptyView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                        rubinoLoadingCell = rubinoEmptyView;
                        break;
                    case 5:
                        RubinoRetryView rubinoRetryView = new RubinoRetryView(this.mContext);
                        rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
                        rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.ListAdapter.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                RubinoPostListActivity.this.needToRetry = false;
                                RubinoPostListActivity.this.updateRows();
                                RubinoPostListActivity.this.initHome(true, false);
                            }
                        });
                        rubinoRetryView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                        rubinoLoadingCell = rubinoRetryView;
                        break;
                    case 6:
                        View rubinoSendingPostView = new RubinoSendingPostView(this.mContext);
                        rubinoSendingPostView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                        view = rubinoSendingPostView;
                        break;
                    case 7:
                        View profileHorizontalListView = new ProfileHorizontalListView(this.mContext);
                        profileHorizontalListView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(208.0f)));
                        rubinoLoadingCell = profileHorizontalListView;
                        break;
                    default:
                        rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
                        break;
                }
                return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
            }
            rubinoLoadingCell = view;
            return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            String string2;
            MyLog.e("List Status", "onBind: " + viewHolder.getAdapterPosition());
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                PostCell postCell = (PostCell) viewHolder.itemView;
                if (postCell == RubinoPostListActivity.this.selectedCellForViewCommentPart) {
                    RubinoPostListActivity.this.cancelShowCommentRunnable();
                }
                postCell.setTag(Integer.valueOf(i));
                if (i >= RubinoPostListActivity.this.postStartRow && i < RubinoPostListActivity.this.postEndRow) {
                    int iIntValue = i - RubinoPostListActivity.this.postStartRow;
                    MyLog.e("RubinoPostListActivity", "index " + iIntValue);
                    if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType && RubinoPostListActivity.this.positionMap.containsKey(Integer.valueOf(iIntValue))) {
                        iIntValue = ((Integer) RubinoPostListActivity.this.positionMap.get(Integer.valueOf(iIntValue))).intValue();
                    }
                    MyLog.e("RubinoPostListActivity", "index after" + iIntValue);
                    RubinoPostObject rubinoPostObject = (RubinoPostObject) RubinoPostListActivity.this.postArray.get(iIntValue);
                    rubinoPostObject.position = i - RubinoPostListActivity.this.postStartRow;
                    RubinoPostObject fromPostMapIfExist = RubinoPostListActivity.this.getRubinoController().getFromPostMapIfExist(rubinoPostObject.post.id);
                    if (fromPostMapIfExist != null) {
                        postCell.setPostObject(fromPostMapIfExist, ((BaseFragment) RubinoPostListActivity.this).classGuid);
                    } else {
                        postCell.setPostObject(rubinoPostObject, ((BaseFragment) RubinoPostListActivity.this).classGuid);
                    }
                }
            } else if (itemViewType == 2) {
                ((StoryHorizontalListView) viewHolder.itemView).addOrUpdateProfileList(RubinoPostListActivity.this.storyProfileList, true, RubinoPostListActivity.this.liveCount);
            } else if (itemViewType == 3) {
                ((InstaSendingPostView) viewHolder.itemView).setObject((InstaDraftManager.SendingPostInsta) RubinoPostListActivity.this.sendingPostArray.get(i - RubinoPostListActivity.this.sendingPostStartRow));
            } else if (itemViewType == 4) {
                RubinoEmptyView rubinoEmptyView = (RubinoEmptyView) viewHolder.itemView;
                if (RubinoPostListActivity.this.type != RubinoPostListActivity.onePostType) {
                    if (RubinoPostListActivity.this.type != RubinoPostListActivity.homeRecentFollowingType) {
                        if (RubinoPostListActivity.this.type == RubinoPostListActivity.bookmarkPostListType) {
                            string = LocaleController.getString(R.string.rubinoNoBookmark);
                            string2 = LocaleController.getString(R.string.rubinoNoBookmarkInfo);
                        } else {
                            string = LocaleController.getString(R.string.rubinoNoPosts);
                            string2 = BuildConfig.FLAVOR;
                        }
                    } else {
                        string = LocaleController.getString(R.string.rubinoNoPost);
                        string2 = LocaleController.getString(R.string.rubinoNoRecentFollowingPostInfo);
                    }
                } else {
                    string = LocaleController.getString(R.string.rubinoNoPost);
                    string2 = LocaleController.getString(R.string.rubinoNoPostInfo);
                }
                rubinoEmptyView.setData(R.drawable.rubino_empty_post_camera, string, string2);
            } else if (itemViewType == 6) {
                ((RubinoSendingPostView) viewHolder.itemView).setObject((RubinoDraftManager.RubinoSendingPost) RubinoPostListActivity.this.sendingPostArray2.get(i - RubinoPostListActivity.this.sendingPostStartRow2));
            } else if (itemViewType == 7) {
                ((ProfileHorizontalListView) viewHolder.itemView).addOrUpdateProfileList(((Rubino.SplitPost) RubinoPostListActivity.this.suggestedArray.get(i - RubinoPostListActivity.this.postStartRow)).suggested_profiles, true);
            }
            if (RubinoPostListActivity.this.hasContinue) {
                if (i == RubinoPostListActivity.this.loadMorePosition || i == RubinoPostListActivity.this.loadingRow) {
                    if (RubinoPostListActivity.this.type != RubinoPostListActivity.homeRecentFollowingType || RubinoPostListActivity.this.isHomeInited) {
                        RubinoPostListActivity.this.getPosts(false, false);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= RubinoPostListActivity.this.sendingPostStartRow && i < RubinoPostListActivity.this.sendingPostEndRow) {
                return 3;
            }
            if (i >= RubinoPostListActivity.this.sendingPostStartRow2 && i < RubinoPostListActivity.this.sendingPostEndRow2) {
                return 6;
            }
            if (i < RubinoPostListActivity.this.postStartRow || i >= RubinoPostListActivity.this.postEndRow) {
                if (i == RubinoPostListActivity.this.loadingRow) {
                    return 1;
                }
                if (i == RubinoPostListActivity.this.storySectionRow) {
                    return 2;
                }
                if (i == RubinoPostListActivity.this.emptyViewRow) {
                    return 4;
                }
                return i == RubinoPostListActivity.this.retryRow ? 5 : 0;
            }
            if (RubinoPostListActivity.this.type == RubinoPostListActivity.homeRecentFollowingType && RubinoPostListActivity.this.suggestedArray.get(i - RubinoPostListActivity.this.postStartRow) != null) {
                MyLog.e("RubinoPostListActivity", "return 7 " + i + " " + (i - RubinoPostListActivity.this.postStartRow));
                return 7;
            }
            MyLog.e("RubinoPostListActivity", "return 0 " + i + " " + (i - RubinoPostListActivity.this.postStartRow));
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
            MyLog.e("List Status", "detached: " + viewHolder.getAdapterPosition());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            MyLog.e("List Status", "attached: " + viewHolder.getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callViewPostTime(RubinoPostObject rubinoPostObject, int i) {
        if (i < 3) {
            return;
        }
        try {
            CompositeDisposable compositeDisposable = ApplicationLoader.applicationActivity.mainCompositeDisposable;
            ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(this.currentAccount);
            String str = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id;
            Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
            compositeDisposable.add((Disposable) apiRequestMessangerRx.addPostViewTime(new Rubino.AddPostViewTimeInput(str, postObjectFromServer.id, postObjectFromServer.profile_id, i)).subscribeWith(new DisposableObserver<MessangerOutput>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.24
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput messangerOutput) {
                }
            }));
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public void refreshStory() {
        this.compositeDisposable.add((Disposable) getStoryController().getStoryObservable(true, null, null).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.ProfilesStoriesListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity.25
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Rubino.ProfilesStoriesListObject profilesStoriesListObject) {
                if (RubinoPostListActivity.this.swipeRefreshLayout != null) {
                    RubinoPostListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                }
                RubinoPostListActivity.this.onStoryLoaded(profilesStoriesListObject, true);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (RubinoPostListActivity.this.swipeRefreshLayout != null) {
                    RubinoPostListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStoryLoaded(Rubino.ProfilesStoriesListObject profilesStoriesListObject, boolean z) {
        this.lastUpdatedStoryTime = System.currentTimeMillis();
        if (profilesStoriesListObject == null || profilesStoriesListObject.profiles == null) {
            return;
        }
        this.storyProfileList.clear();
        this.storyProfileList.addAll(profilesStoriesListObject.profiles);
        this.liveCount = profilesStoriesListObject.liveProfileCount;
        if (z) {
            if (this.storySectionRow < 0) {
                updateRows();
            } else {
                updateStoryView();
            }
        }
    }

    private void updateStoryView() {
        StoryHorizontalListView storyListView = getStoryListView();
        if (storyListView != null) {
            storyListView.addOrUpdateProfileList(this.storyProfileList, true, this.liveCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playSelectedCell() {
        PostCell postCell = this.selectedCellForAutoPlay;
        if (postCell != null) {
            PhotoViewerCell photoViewerCell = postCell.photoViewerCell;
            if (photoViewerCell.attachedToWindow && !this.isPaused) {
                photoViewerCell.considerAutoPlayingCurrentVideo();
                this.wakeLock.acquire(120000L);
            }
        }
        if (preloadEnabled) {
            setPreloadVideoRunnable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCommentBar() {
        PostCell postCell = this.selectedCellForViewCommentPart;
        if (postCell != null) {
            postCell.startAnimationComment();
            this.selectedCellForViewCommentPart = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preload() {
        PostCell postCell = this.selectedCellForPreload;
        if (postCell != null) {
            try {
                PhotoViewerObject photoViewerObject = postCell.photoViewerCell.currentPhotoSlideObject.getPhotos().get(this.selectedCellForPreload.photoViewerCell.currentIndex + 1);
                if (photoViewerObject.isVideo) {
                    preloadVideo(this.currentAccount, photoViewerObject);
                    preloadPhoto(this.currentAccount, photoViewerObject.imageObject);
                } else {
                    preloadPhoto(this.currentAccount, photoViewerObject);
                }
                PhotoViewerObject photoViewerObject2 = this.selectedCellForPreload.photoViewerCell.currentPhotoSlideObject.getPhotos().get(this.selectedCellForPreload.photoViewerCell.currentIndex + 2);
                if (photoViewerObject2.isVideo) {
                    preloadPhoto(this.currentAccount, photoViewerObject2.imageObject);
                } else {
                    preloadPhoto(this.currentAccount, photoViewerObject2);
                }
            } catch (Exception unused) {
            }
            for (int i = 0; i < 6; i++) {
                try {
                    RubinoPostObject rubinoPostObject = this.postArray.get(this.selectedCellForPreload.postObject.position + 1 + i);
                    PhotoViewerObject photoViewerObject3 = rubinoPostObject.photoSlideObject.getPhotos().get(rubinoPostObject.photoSlideObject.getCurrentIndex());
                    if (photoViewerObject3.isVideo) {
                        preloadVideo(this.currentAccount, photoViewerObject3);
                        preloadPhoto(this.currentAccount, photoViewerObject3.imageObject);
                    } else {
                        preloadPhoto(this.currentAccount, photoViewerObject3);
                    }
                } catch (Exception unused2) {
                    return;
                }
            }
        }
    }

    private void cancelAlreadyPreloading() {
        if (preloadEnabled) {
            PostCell postCell = null;
            for (int i = 0; i < this.listView.getChildCount(); i++) {
                try {
                    if (this.listView.getChildAt(i) instanceof PostCell) {
                        postCell = (PostCell) this.listView.getChildAt(i);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            for (int i2 = 0; i2 < 8; i2++) {
                RubinoPostObject rubinoPostObject = this.postArray.get(postCell.postObject.position + i2);
                PhotoViewerObject photoViewerObject = rubinoPostObject.photoSlideObject.getPhotos().get(rubinoPostObject.photoSlideObject.getCurrentIndex());
                if (photoViewerObject.isVideo && photoViewerObject.isPreloadedCalled) {
                    FileLoaderRubinoPost.getInstance(this.currentAccount).cancelLoadFile(photoViewerObject);
                    photoViewerObject.isPreloadedCalled = false;
                }
                try {
                    PhotoViewerObject photoViewerObject2 = rubinoPostObject.photoSlideObject.getPhotos().get(rubinoPostObject.photoSlideObject.getCurrentIndex() + 1);
                    if (photoViewerObject2.isVideo && photoViewerObject2.isPreloadedCalled) {
                        FileLoaderRubinoPost.getInstance(this.currentAccount).cancelLoadFile(photoViewerObject2);
                        photoViewerObject2.isPreloadedCalled = false;
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    public static void preloadPhoto(int i, PhotoViewerObject photoViewerObject) {
        if (photoViewerObject.isPreloadedCalled || photoViewerObject.checkIsFileExist() || FileLoaderRubinoPost.getInstance(i).isLoadingFile(photoViewerObject)) {
            return;
        }
        MyLog.e("preload", "RubinoDownload1 image preload " + photoViewerObject.filePath);
        FileLoaderRubinoPost.getInstance(i).loadFile(photoViewerObject, 0);
        photoViewerObject.isPreloadedCalled = true;
    }

    public static void preloadVideo(int i, PhotoViewerObject photoViewerObject) {
        if (photoViewerObject.isPreloadedCalled || photoViewerObject.checkIsFileExist() || FileLoaderRubinoPost.getInstance(i).isPreloading(photoViewerObject)) {
            return;
        }
        MyLog.e("preload", "RubinoDownload1 video preload video " + photoViewerObject.filePath);
        FileLoaderRubinoPost.getInstance(i).loadFile(photoViewerObject, null, 0, 10);
        photoViewerObject.isPreloadedCalled = true;
    }

    void setAutoPlayRunnable(int i) {
        AndroidUtilities.cancelRunOnUIThread(this.autoPlayRunnable);
        AndroidUtilities.runOnUIThread(this.autoPlayRunnable, i);
    }

    void cancelAutoPlayRunnable() {
        AndroidUtilities.cancelRunOnUIThread(this.autoPlayRunnable);
    }

    void setPlaySelectedCellRunnable() {
        AndroidUtilities.cancelRunOnUIThread(this.playSelectedCellRunnable);
        AndroidUtilities.runOnUIThread(this.playSelectedCellRunnable, 150L);
    }

    void cancelPlaySelectedCellRunnable() {
        this.selectedCellForAutoPlay = null;
        AndroidUtilities.cancelRunOnUIThread(this.playSelectedCellRunnable);
    }

    void setPreloadVideoRunnable() {
        AndroidUtilities.cancelRunOnUIThread(this.preLoadRunnable);
        AndroidUtilities.runOnUIThread(this.preLoadRunnable, 350L);
    }

    void cancelPreloadVideoRunnable() {
        this.selectedCellForPreload = null;
        AndroidUtilities.cancelRunOnUIThread(this.preLoadRunnable);
    }

    void setShowCommentRunnable() {
        AndroidUtilities.cancelRunOnUIThread(this.showCommentRunnable);
        AndroidUtilities.runOnUIThread(this.showCommentRunnable, 5000L);
    }

    void cancelShowCommentRunnable() {
        this.selectedCellForViewCommentPart = null;
        AndroidUtilities.cancelRunOnUIThread(this.showCommentRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playItemInList() {
        RecyclerListViewEdited recyclerListViewEdited;
        PostCell postCell;
        MyLog.e("autoPlayRunnable", "here");
        try {
            recyclerListViewEdited = this.listView;
        } catch (Exception e) {
            Log.e("RubinoPostList", "playItemInList: ", e);
            if (MyLog.isDebugAble) {
                MyLog.handleException(e);
                e.printStackTrace();
            }
        }
        if (recyclerListViewEdited != null && recyclerListViewEdited.getLayoutManager() != null) {
            float f = 1.0E15f;
            Rect rect = new Rect();
            this.fragmentView.getGlobalVisibleRect(rect);
            this.fragmentView.getGlobalVisibleRect(rect);
            float f2 = 0.01f;
            float f3 = 0.01f;
            PostCell postCell2 = null;
            PostCell postCell3 = null;
            for (int i = 0; i < this.listView.getChildCount(); i++) {
                if (this.listView.getChildAt(i) != null && (this.listView.getChildAt(i) instanceof PostCell)) {
                    PostCell postCell4 = (PostCell) this.listView.getChildAt(i);
                    this.listView.getChildAdapterPosition(postCell4);
                    if (postCell4.photoViewerCell.currentObject != null) {
                        Rect rect2 = new Rect();
                        postCell4.photoViewerCell.getGlobalVisibleRect(rect2);
                        int i2 = rect2.bottom;
                        int i3 = rect.top;
                        if (i2 >= i3) {
                            int i4 = rect.bottom;
                            if (i2 > i4) {
                                i2 = i4;
                            }
                            int i5 = rect2.top;
                            if (i5 <= i4) {
                                if (i5 >= i3) {
                                    i3 = i5;
                                }
                                float screenWidth = DimensionHelper.getScreenWidth((Activity) getContext());
                                Rubino.PostObjectFromServer postObjectFromServer = postCell4.postObject.post;
                                float f4 = (i2 - i3) / (screenWidth * ((postObjectFromServer.height * 1.0f) / postObjectFromServer.width));
                                if (f4 > f2 && postCell4.photoViewerCell.currentObject.isVideo) {
                                    f2 = f4;
                                    postCell2 = postCell4;
                                }
                                if (f4 > f3 && !postCell4.photoViewerCell.currentObject.isVideo) {
                                    f3 = f4;
                                    postCell3 = postCell4;
                                }
                                if (f4 == f2) {
                                    float f5 = i3;
                                    if (f5 < f) {
                                        f2 = f4;
                                        f = f5;
                                        postCell2 = postCell4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (postCell2 != null && f2 > 0.2f) {
                PostCell postCell5 = this.selectedCellForAutoPlay;
                if (postCell5 != postCell2) {
                    if (MyLog.isDebugAble) {
                        ToastiLikeSnack.showL(this.context, "selectedCellForAutoPlay play");
                    }
                    PostCell postCell6 = this.selectedCellForAutoPlay;
                    cancelImagerTimer();
                    this.selectedCellForAutoPlay = postCell2;
                    this.selectedCellForPreload = postCell2;
                    cancelLastPlay(postCell6);
                    setPlaySelectedCellRunnable();
                } else {
                    if (postCell5 != null && !postCell5.isPlaying()) {
                        if (MyLog.isDebugAble) {
                            ToastiLikeSnack.showL(this.context, "selectedCellForAutoPlay retry to play");
                        }
                        setPlaySelectedCellRunnable();
                    }
                    this.selectedCellForPreload = postCell2;
                    setPreloadVideoRunnable();
                }
            } else {
                if (postCell3 == null || f3 <= 0.2f || this.selectedCellForImageTimer == postCell3) {
                    postCell = null;
                } else {
                    cancelImagerTimer();
                    this.selectedCellForImageTimer = postCell3;
                    startImageTimer();
                    postCell = postCell3;
                }
                if (postCell2 != null) {
                    this.selectedCellForPreload = postCell2;
                    setPreloadVideoRunnable();
                }
                getNotificationCenter().postNotificationName(NotificationCenter.playersShouldPause, Integer.valueOf(this.classGuid));
                postCell2 = postCell;
            }
            if (postCell2 != null && postCell2 != this.selectedCellForViewCommentPart) {
                this.selectedCellForViewCommentPart = postCell2;
                setShowCommentRunnable();
            }
            setAutoPlayRunnable(HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
            return;
        }
        setAutoPlayRunnable(HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelImagerTimer() {
        PostCell postCell = this.selectedCellForImageTimer;
        if (postCell != null) {
            postCell.photoViewerCell.cancelImageTimer();
        }
    }

    private void startImageTimer() {
        PhotoViewerCell photoViewerCell = this.selectedCellForImageTimer.photoViewerCell;
        if (photoViewerCell.attachedToWindow) {
            photoViewerCell.startImageTimer();
        } else {
            this.selectedCellForImageTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseExistingCachedPlayers() {
        getRubinoController().releaseExistingCachedPlayers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingButton(boolean z) {
        if (this.floatingButtonContainer == null || this.floatingHidden == z) {
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

    public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public MyGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            MyLog.e("RubinoPostListActivity", "onFling x" + f + " startx " + motionEvent.getX());
            if (f > 0.0f && f > Math.abs(f2) && motionEvent.getX() < DimensionHelper.getScreenWidth((Activity) RubinoPostListActivity.this.context) / 10.0f && f > AndroidUtilities.dp(300.0f)) {
                StoryCameraAndGalleryFragment storyCameraAndGalleryFragment = new StoryCameraAndGalleryFragment();
                storyCameraAndGalleryFragment.presentAnimationType = ActionBarAnimationType.LTR;
                storyCameraAndGalleryFragment.dismissAnimationType = ActionBarAnimationType.RTL;
                RubinoPostListActivity.this.presentFragment(storyCameraAndGalleryFragment);
                return true;
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }
}
