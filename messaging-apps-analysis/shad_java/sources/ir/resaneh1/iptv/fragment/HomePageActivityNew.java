package ir.resaneh1.iptv.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import androidMessenger.utilites.MyLog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout;
import ir.appp.ui.ActionBar.LifecycleAwareBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.activity.MainTabFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet;
import ir.resaneh1.iptv.fragment.home.HomeCollectionInnerCell;
import ir.resaneh1.iptv.fragment.home.HomeSliderCell;
import ir.resaneh1.iptv.fragment.home.HomeViewTagCell;
import ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell;
import ir.resaneh1.iptv.fragment.home.ad.AdSectionCell;
import ir.resaneh1.iptv.fragment.home.banner.BannerCell;
import ir.resaneh1.iptv.fragment.home.container.ContainerCell;
import ir.resaneh1.iptv.fragment.home.feed.FeedCell;
import ir.resaneh1.iptv.fragment.home.live.HomeLiveCell;
import ir.resaneh1.iptv.fragment.home.live.fragment.HomeLiveListFragment;
import ir.resaneh1.iptv.fragment.home.music.HomeMusicCell;
import ir.resaneh1.iptv.fragment.home.parallax.ParallaxCell;
import ir.resaneh1.iptv.fragment.home.prediction.PredictionCell;
import ir.resaneh1.iptv.fragment.home.textBox.TextBoxCell;
import ir.resaneh1.iptv.fragment.rubino.RubinoLoadingCell;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.model.CardPageLinkData;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.ProfileActivity;

/* loaded from: classes3.dex */
public class HomePageActivityNew extends LifecycleAwareBaseFragment {
    private static final String TAG = "ir.resaneh1.iptv.fragment.HomePageActivityNew";
    private static long UPDATE_DURATION = 1800000;
    public static Runnable linkRunnable;
    private final Stack<AdSectionCell> adSectionCellCache;
    private HomePageModels.HomePageSectionObject allServices;
    private final Stack<BannerCell> bannerCellCache;
    private Stack<HomeCollectionInnerCell> collectionCells;
    private Map<Integer, Integer> collectionsMap;
    private final Stack<ContainerCell> containerCellCache;
    public DisposableObserver fakeObserver;
    private final Stack<FeedCell> feedCellCache;
    private Map<Integer, Integer> indexMap;
    private boolean isHome;
    private boolean isLoading;
    private DisposableObserver lastDisposable;
    private long lastManualRefreshTime;
    private long lastUpdatedTime;
    private WrapContentLinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    public Runnable liveRefreshRunnable;
    private int loadingRow;
    private final Stack<HomeMusicCell> musicCellCache;
    private int oldRowCount;
    PullToRefreshLayout.OnRefreshListener onRefreshListener;
    private String page;
    private final Stack<ParallaxCell> parallaxCellCache;
    private final Stack<PredictionCell> predictionCellCache;
    private RubinoLoadingCell progressBar;
    public DisposableObserver refreshPostsObserver;
    private LinearLayout retryLl;
    private int rowCount;
    private Stack<HomeSliderCell> sliderCells;
    private String startId;
    private PullToRefreshLayout swipeRefreshLayout;
    private String title;
    private Map<Integer, HomePageModels.SectionTypeEnum> typesMap;
    private ArrayList<HomePageModels.HomePageSectionObject> arrayList = new ArrayList<>();
    private boolean hasContinue = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$callGetItems$0(MessangerOutput messangerOutput) throws Exception {
    }

    public HomePageActivityNew(CardPageLinkData cardPageLinkData, boolean z) {
        new Handler();
        this.sliderCells = new Stack<>();
        this.collectionCells = new Stack<>();
        this.typesMap = new HashMap();
        this.indexMap = new HashMap();
        this.collectionsMap = new HashMap();
        this.containerCellCache = new Stack<>();
        this.feedCellCache = new Stack<>();
        this.predictionCellCache = new Stack<>();
        this.parallaxCellCache = new Stack<>();
        this.adSectionCellCache = new Stack<>();
        this.bannerCellCache = new Stack<>();
        this.musicCellCache = new Stack<>();
        this.lastUpdatedTime = 0L;
        this.lastManualRefreshTime = 0L;
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew.7
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                HomePageActivityNew.this.callGetItems(true, true);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z2) {
                AndroidUtilities.recycleViewSafeSuppressLayout(HomePageActivityNew.this.listView, z2);
            }
        };
        this.liveRefreshRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew.8
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < HomePageActivityNew.this.listView.getChildCount(); i++) {
                    View childAt = HomePageActivityNew.this.listView.getChildAt(i);
                    if (childAt instanceof HomeLiveCell) {
                        Log.i("sahartest", "update called");
                        ((HomeLiveCell) childAt).callGetItems(false);
                    }
                }
                Utilities.stageQueue.postRunnable(this, (MyLog.isDebugAble ? 10 : 60) * CloseCodes.NORMAL_CLOSURE);
            }
        };
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "HomePageActivityNew " + this.page;
        this.isHome = z;
        this.page = cardPageLinkData != null ? cardPageLinkData.tag : BuildConfig.FLAVOR;
        this.title = cardPageLinkData != null ? cardPageLinkData.title : null;
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        this.needLockOrientation = true;
        this.swipeBackEnabled = false;
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        return super.isSwipeBackEnabled();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) throws Resources.NotFoundException {
        if (ir.resaneh1.iptv.logger.MyLog.isDebugAble) {
            UPDATE_DURATION = 6000L;
        }
        if (!this.isHome) {
            this.actionBar.addView(createActionBarTitleTextView(context), LayoutHelper.createFrame(-2, -2.0f, 21, 8.0f, 0.0f, 48.0f, 0.0f));
            this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
            this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew.1
                @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
                public void onItemClick(int i) {
                    if (i == -1) {
                        HomePageActivityNew.this.finishFragment();
                    }
                }
            });
        } else {
            this.actionBar.createCenterImageView();
            this.actionBar.centerImageView.setOnClickListener(new AnonymousClass2());
            this.actionBar.setTitle(BuildConfig.FLAVOR);
            if (AndroidUtilities.isTablet()) {
                this.actionBar.setOccupyStatusBar(false);
            }
            this.actionBar.setAllowOverlayTitle(true);
            if (FlavorHelper.isShad()) {
                initShadActionBar();
            }
        }
        createCacheCells(context);
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        int i = Theme.key_windowBackgroundGray;
        frameLayout.setBackgroundColor(Theme.getColor(i));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        PullToRefreshLayout pullToRefreshLayout = new PullToRefreshLayout(context);
        this.swipeRefreshLayout = pullToRefreshLayout;
        frameLayout2.addView(pullToRefreshLayout, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        this.swipeRefreshLayout.bindListViewToLayout(this.listView);
        RecyclerListView recyclerListView2 = this.listView;
        WrapContentLinearLayoutManager wrapContentLinearLayoutManager = new WrapContentLinearLayoutManager(context, 1, false);
        this.layoutManager = wrapContentLinearLayoutManager;
        recyclerListView2.setLayoutManager(wrapContentLinearLayoutManager);
        this.listView.setBackgroundColor(Theme.getColor(i));
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setPadding(0, 0, 0, 0);
        this.listView.setAdapter(this.listAdapter);
        frameLayout2.addView(this.actionBar);
        RubinoLoadingCell rubinoLoadingCell = new RubinoLoadingCell(context, false);
        this.progressBar = rubinoLoadingCell;
        frameLayout2.addView(rubinoLoadingCell, LayoutHelper.createFrame(-2, -2, 17));
        LinearLayout linearLayoutInitRetryLoading = initRetryLoading();
        this.retryLl = linearLayoutInitRetryLoading;
        frameLayout2.addView(linearLayoutInitRetryLoading, LayoutHelper.createFrame(-2, -2, 17));
        this.retryLl.setVisibility(8);
        this.listView.setFocusable(false);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                HomePageActivityNew.this.checkScrollForLoad();
            }
        });
        PullToRefreshLayout pullToRefreshLayout2 = this.swipeRefreshLayout;
        if (pullToRefreshLayout2 != null) {
            pullToRefreshLayout2.setEnabled(true);
            this.swipeRefreshLayout.setRefreshListener(this.onRefreshListener);
        }
        return this.fragmentView;
    }

    /* renamed from: ir.resaneh1.iptv.fragment.HomePageActivityNew$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        int i = 0;
        long lastTimeClicked = 0;

        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.i > 0 && System.currentTimeMillis() - this.lastTimeClicked < 500) {
                this.i++;
            } else {
                this.i = 1;
            }
            this.lastTimeClicked = System.currentTimeMillis();
            if (this.i > 6) {
                this.i = 0;
                if (ApplicationLoader.applicationActivity.getLastFragment() instanceof MainTabFragment) {
                    HomePageActivityNew.this.getAccountInstance().getCoreMainClass().clearDataBaseAndStorageForDebug();
                    ApiRequestMessanger.getInstance(((BaseFragment) HomePageActivityNew.this).currentAccount).localLogout();
                    MessagesController.getInstance(((BaseFragment) HomePageActivityNew.this).currentAccount).clearQueryTime();
                    MessagesStorage.getInstance(((BaseFragment) HomePageActivityNew.this).currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onClick$1();
                        }
                    });
                    Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$2$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomePageActivityNew.AnonymousClass2.lambda$onClick$3();
                        }
                    });
                    BulletinFactory.of(HomePageActivityNew.this).createSimpleBulletin(R.raw.ic_delete, LocaleController.getString("ClearCache", R.string.ClearCache)).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01ef A[Catch: all -> 0x0249, Exception -> 0x024b, TryCatch #2 {Exception -> 0x024b, blocks: (B:3:0x0004, B:4:0x0020, B:6:0x0027, B:9:0x0035, B:10:0x003d, B:11:0x0050, B:13:0x0056, B:15:0x007a, B:17:0x0080, B:47:0x0209, B:20:0x008b, B:22:0x00a8, B:39:0x011f, B:40:0x0122, B:42:0x01ef, B:46:0x0206, B:48:0x0211), top: B:64:0x0004, outer: #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01ff  */
        /* JADX WARN: Type inference failed for: r13v0 */
        /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r13v2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$onClick$1() {
            /*
                Method dump skipped, instructions count: 611
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.HomePageActivityNew.AnonymousClass2.lambda$onClick$1():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() {
            NotificationCenter.getInstance(((BaseFragment) HomePageActivityNew.this).currentAccount).postNotificationName(NotificationCenter.didClearDatabase, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x004e A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static /* synthetic */ void lambda$onClick$3() {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                r3 = 0
            L4:
                r4 = 7
                if (r2 >= r4) goto L52
                r3 = -1
                r4 = 100
                r5 = 3
                r6 = 2
                r7 = 4
                if (r2 != 0) goto L12
                r3 = 0
            L10:
                r6 = 0
                goto L2e
            L12:
                if (r2 != r0) goto L16
                r3 = 2
                goto L10
            L16:
                if (r2 != r6) goto L1b
                r3 = 3
                r6 = 1
                goto L2e
            L1b:
                if (r2 != r5) goto L1f
                r3 = 3
                goto L2e
            L1f:
                if (r2 != r7) goto L23
                r3 = 1
                goto L10
            L23:
                r5 = 5
                if (r2 != r5) goto L29
                r3 = 100
                goto L10
            L29:
                r5 = 6
                if (r2 != r5) goto L10
                r3 = 4
                goto L10
            L2e:
                if (r3 != r4) goto L3c
                java.io.File r4 = new java.io.File
                java.io.File r5 = org.rbmain.messenger.FileLoader.checkDirectory(r7)
                java.lang.String r8 = "acache"
                r4.<init>(r5, r8)
                goto L40
            L3c:
                java.io.File r4 = org.rbmain.messenger.FileLoader.checkDirectory(r3)
            L40:
                if (r4 == 0) goto L4e
                java.lang.String r4 = r4.getAbsolutePath()
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                org.rbmain.messenger.Utilities.clearDir(r4, r6, r8, r1)
            L4e:
                int r2 = r2 + 1
                r3 = 1
                goto L4
            L52:
                ir.resaneh1.iptv.fragment.HomePageActivityNew$2$$ExternalSyntheticLambda2 r0 = new ir.resaneh1.iptv.fragment.HomePageActivityNew$2$$ExternalSyntheticLambda2
                r0.<init>()
                org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.HomePageActivityNew.AnonymousClass2.lambda$onClick$3():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onClick$2(boolean z) {
            if (z) {
                ImageLoader.getInstance().clearMemory();
            }
        }
    }

    private void initShadActionBar() {
        this.actionBar.setBackButtonImage(R.drawable.profile_avatar);
        ActionBarMenuItem overrideMenuClick = this.actionBar.createMenu().addItem(1, R.drawable.ic_settings_shad).setOverrideMenuClick(true);
        overrideMenuClick.setContentDescription(LocaleController.getString(R.string.setting));
        overrideMenuClick.setOverrideMenuClick(true);
        final Link link = new Link();
        link.type = Link.LinkTypeEnum.barcodescan;
        Link.BarcodescanData barcodescanData = new Link.BarcodescanData();
        link.barcodescan_data = barcodescanData;
        barcodescanData.type = "profile";
        barcodescanData.barcode = "main";
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew.4
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    MainClickHandler.getInstance().onLinkClick(link);
                } else if (i == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("user_id", UserConfig.getInstance(((BaseFragment) HomePageActivityNew.this).currentAccount).clientUserId);
                    HomePageActivityNew.this.presentFragment(new ProfileActivity(bundle));
                }
            }
        });
    }

    private SimpleTextView createActionBarTitleTextView(Context context) {
        SimpleTextView simpleTextView = new SimpleTextView(context);
        String str = this.title;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        simpleTextView.setText(str);
        simpleTextView.setGravity(5);
        simpleTextView.setTextSize(16);
        simpleTextView.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
        simpleTextView.setTextColor(Theme.getColor(Theme.key_actionBarDefaultTitle));
        simpleTextView.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebregular.ttf"));
        return simpleTextView;
    }

    public void setForMainTab() {
        ((FrameLayout.LayoutParams) this.swipeRefreshLayout.getLayoutParams()).topMargin = AndroidUtilities.dp(48.0f);
        this.listView.setPadding(0, AndroidUtilities.dp(52.0f), 0, 0);
    }

    private void createCacheCells(Context context) {
        if (this.containerCellCache.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                this.containerCellCache.push(new ContainerCell(context));
                this.feedCellCache.push(new FeedCell(context));
                this.predictionCellCache.push(new PredictionCell(context, this));
                this.parallaxCellCache.push(new ParallaxCell(context));
                this.adSectionCellCache.push(new AdSectionCell(context));
                this.bannerCellCache.push(new BannerCell(context));
                this.sliderCells.push(new HomeSliderCell(context));
                this.collectionCells.push(new HomeCollectionInnerCell(context));
                this.musicCellCache.push(new HomeMusicCell(context));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScrollForLoad() {
        WrapContentLinearLayoutManager wrapContentLinearLayoutManager = this.layoutManager;
        if (wrapContentLinearLayoutManager == null || !this.hasContinue) {
            return;
        }
        int iFindFirstVisibleItemPosition = wrapContentLinearLayoutManager.findFirstVisibleItemPosition();
        if ((this.listAdapter.getItemCount() - iFindFirstVisibleItemPosition) - (iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(this.layoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1) > 7 || this.isLoading) {
            return;
        }
        callGetItems(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetItems(final boolean z, final boolean z2) {
        if (this.isLoading) {
            if (this.swipeRefreshLayout.isRefreshing()) {
                return;
            }
            this.swipeRefreshLayout.setRefreshing(false, true);
            return;
        }
        if (this.hasContinue || z) {
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
                    DisposableObserver disposableObserver3 = (DisposableObserver) Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew.5
                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            if (HomePageActivityNew.this.swipeRefreshLayout != null) {
                                HomePageActivityNew.this.swipeRefreshLayout.setRefreshing(false, true);
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
                DisposableObserver disposableObserver4 = this.lastDisposable;
                if (disposableObserver4 != null && !disposableObserver4.isDisposed()) {
                    this.lastDisposable.dispose();
                }
            } else {
                DisposableObserver disposableObserver5 = this.lastDisposable;
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
            this.isLoading = true;
            this.retryLl.setVisibility(4);
            HomePageModels.GetHomePageInput getHomePageInput = new HomePageModels.GetHomePageInput(this.page);
            getHomePageInput.start_id = z ? null : this.startId;
            MyLog.e(this.fragmentName, "Request for homePage loadMore");
            DisposableObserver disposableObserver8 = (DisposableObserver) ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).getHomePage(getHomePageInput).doOnNext(new Consumer() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    HomePageActivityNew.lambda$callGetItems$0((MessangerOutput) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<HomePageModels.GetHomePageOutput>>() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew.6
                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<HomePageModels.GetHomePageOutput> messangerOutput) {
                    HomePageActivityNew.this.hideLoading();
                    HomePageActivityNew.this.isLoading = false;
                    if (z) {
                        HomePageActivityNew.this.lastUpdatedTime = System.currentTimeMillis();
                    }
                    HomePageModels.GetHomePageOutput getHomePageOutput = messangerOutput.data;
                    if (getHomePageOutput != null) {
                        HomePageActivityNew.this.processData(getHomePageOutput, z, z2);
                    }
                    HomePageActivityNew.this.swipeRefreshLayout.setRefreshing(false, true);
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    HomePageActivityNew.this.hideLoading();
                    HomePageActivityNew.this.showRetryView();
                    HomePageActivityNew.this.isLoading = false;
                    HomePageActivityNew.this.swipeRefreshLayout.setRefreshing(false, true);
                    dispose();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    HomePageActivityNew.this.isLoading = false;
                    dispose();
                }
            });
            if (z) {
                this.refreshPostsObserver = disposableObserver8;
            } else {
                this.lastDisposable = disposableObserver8;
            }
            this.compositeDisposable.add(disposableObserver8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processData(HomePageModels.GetHomePageOutput getHomePageOutput, boolean z, boolean z2) {
        if (z) {
            if (dataIsDuplicate(getHomePageOutput)) {
                return;
            }
            if (z2) {
                this.lastManualRefreshTime = System.currentTimeMillis();
            }
            this.rowCount = 0;
            this.loadingRow = -1;
            this.arrayList.clear();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
        this.startId = getHomePageOutput.next_start_id;
        this.hasContinue = getHomePageOutput.has_continue;
        ArrayList<HomePageModels.HomePageSectionObject> arrayList = new ArrayList<>();
        arrayList.addAll(this.arrayList);
        arrayList.addAll(getHomePageOutput.sections_list);
        updateRows(z, arrayList);
    }

    private boolean dataIsDuplicate(HomePageModels.GetHomePageOutput getHomePageOutput) {
        return CallProxy$$ExternalSyntheticBackport0.m(this.arrayList, getHomePageOutput.sections_list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        this.progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRetryView() {
        hideLoading();
        if (this.arrayList.size() == 0) {
            this.retryLl.setVisibility(0);
        }
    }

    private void updateRows(boolean z, ArrayList<HomePageModels.HomePageSectionObject> arrayList) {
        hideLoading();
        this.oldRowCount = this.rowCount;
        this.rowCount = 0;
        this.loadingRow = -1;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                HomePageModels.SectionTypeEnum sectionTypeEnum = arrayList.get(i).type;
                if (sectionTypeEnum == HomePageModels.SectionTypeEnum.AllServices) {
                    this.allServices = arrayList.get(i);
                } else if (sectionTypeEnum == HomePageModels.SectionTypeEnum.Collection) {
                    for (int i2 = 0; i2 < arrayList.get(i).collection_section.collection_items_list.size(); i2++) {
                        map.put(Integer.valueOf(this.rowCount), sectionTypeEnum);
                        map2.put(Integer.valueOf(this.rowCount), Integer.valueOf(i));
                        map3.put(Integer.valueOf(this.rowCount), Integer.valueOf(i2));
                        this.rowCount++;
                    }
                } else {
                    map.put(Integer.valueOf(this.rowCount), arrayList.get(i).type);
                    map2.put(Integer.valueOf(this.rowCount), Integer.valueOf(i));
                    this.rowCount++;
                }
            }
        }
        if (this.hasContinue) {
            int i3 = this.rowCount;
            this.rowCount = i3 + 1;
            this.loadingRow = i3;
        }
        this.indexMap = map2;
        this.typesMap = map;
        this.collectionsMap = map3;
        this.arrayList = arrayList;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            if (z) {
                listAdapter.notifyDataSetChanged();
            } else {
                int i4 = this.rowCount;
                int i5 = this.oldRowCount;
                if (i4 > i5) {
                    listAdapter.notifyItemRangeInserted(i5 + 1, (i4 - i5) - 1);
                } else if (i4 != i5) {
                    listAdapter.notifyItemRangeRemoved(i5, i5 - i4);
                } else if (i5 > 0) {
                    listAdapter.notifyItemChanged(i5 - 1);
                }
            }
            if (this.arrayList.size() > 7 || !this.hasContinue) {
                return;
            }
            checkScrollForLoad();
            return;
        }
        showRetryView();
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ActionBar actionBar = this.actionBar;
        if (actionBar != null && this.isHome) {
            actionBar.setLogoAddition();
        }
        if (System.currentTimeMillis() - this.lastUpdatedTime > UPDATE_DURATION) {
            try {
                this.listView.scrollToPosition(0);
            } catch (Exception unused) {
            }
            this.retryLl.setVisibility(4);
            callGetItems(true, false);
        }
        Utilities.stageQueue.postRunnable(this.liveRefreshRunnable, (MyLog.isDebugAble ? 10 : 60) * CloseCodes.NORMAL_CLOSURE);
    }

    private LinearLayout initRetryLoading() throws Resources.NotFoundException {
        final LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(getContext());
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.rubino_loadmore_icon_refresh);
        int i = Theme.key_dialogTextBlack;
        drawable.setColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY);
        imageView.setImageDrawable(drawable);
        TextView textView = new TextView(getContext());
        textView.setText(LocaleController.getString(R.string.retry));
        textView.setTextColor(Theme.getColor(i));
        textView.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebregular.ttf"));
        linearLayout.addView(imageView, LayoutHelper.createLinear(48, 48));
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initRetryLoading$1(linearLayout, view);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRetryLoading$1(LinearLayout linearLayout, View view) {
        linearLayout.setVisibility(8);
        this.progressBar.setVisibility(0);
        this.isLoading = false;
        callGetItems(true, false);
    }

    public class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return HomePageActivityNew.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            MyLog.e(HomePageActivityNew.this.fragmentName, " ********* Dataset changed ");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            MyLog.e(HomePageActivityNew.this.fragmentName, "Recycler of HomeActivity Binding " + i);
            switch (viewHolder.getItemViewType()) {
                case 2:
                    AdSectionCell adSectionCell = (AdSectionCell) viewHolder.itemView;
                    if (((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).ad_section.ad_items_list != null && ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).ad_section.ad_items_list.size() != 0) {
                        adSectionCell.setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                        break;
                    }
                    break;
                case 4:
                    final ServiceViewPagerCell serviceViewPagerCell = (ServiceViewPagerCell) viewHolder.itemView;
                    final HomePageModels.HomePageSectionObject homePageSectionObject = (HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue());
                    final HomePageModels.UserFavoriteServicesSectionObject userFavoriteServicesSectionObject = homePageSectionObject.user_favorite_services_section;
                    serviceViewPagerCell.setItem(homePageSectionObject.id, userFavoriteServicesSectionObject.user_favorite_services_list, userFavoriteServicesSectionObject.column, userFavoriteServicesSectionObject.row, true, false);
                    serviceViewPagerCell.setData(homePageSectionObject);
                    serviceViewPagerCell.setOnEditClick(new ServiceViewPagerCell.OnEditClickListener() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$ListAdapter$$ExternalSyntheticLambda3
                        @Override // ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell.OnEditClickListener
                        public final void onEditClick() {
                            this.f$0.lambda$onBindViewHolder$3(i, serviceViewPagerCell, homePageSectionObject, userFavoriteServicesSectionObject);
                        }
                    });
                    break;
                case 5:
                    final HomeSliderCell homeSliderCell = (HomeSliderCell) viewHolder.itemView;
                    if (((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).slider_section != null) {
                        homeSliderCell.setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                    }
                    homeSliderCell.setDelegate(new HomeSliderCell.Delegate() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$ListAdapter$$ExternalSyntheticLambda2
                        @Override // ir.resaneh1.iptv.fragment.home.HomeSliderCell.Delegate
                        public final void onLoadMoreComplete(ArrayList arrayList, boolean z, String str) {
                            this.f$0.lambda$onBindViewHolder$0(i, homeSliderCell, arrayList, z, str);
                        }
                    });
                    break;
                case 6:
                    final HomeCollectionInnerCell homeCollectionInnerCell = (HomeCollectionInnerCell) viewHolder.itemView;
                    if (HomePageActivityNew.this.indexMap.get(Integer.valueOf(i)) != null) {
                        homeCollectionInnerCell.setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()), ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).id, ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).collection_section.column, ((Integer) HomePageActivityNew.this.collectionsMap.get(Integer.valueOf(i))).intValue(), ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).collection_section.collection_items_list.size());
                        homeCollectionInnerCell.setDelegate(new HomeCollectionInnerCell.Delegate() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$ListAdapter$$ExternalSyntheticLambda1
                            @Override // ir.resaneh1.iptv.fragment.home.HomeCollectionInnerCell.Delegate
                            public final void onLoadMoreComplete(ArrayList arrayList, boolean z, String str) {
                                this.f$0.lambda$onBindViewHolder$1(i, homeCollectionInnerCell, arrayList, z, str);
                            }
                        });
                        break;
                    }
                    break;
                case 7:
                    ParallaxCell parallaxCell = (ParallaxCell) viewHolder.itemView;
                    if (((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).parallax_section.parallax_items_list.size() != 0) {
                        parallaxCell.setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                        break;
                    }
                    break;
                case 9:
                    ((FeedCell) viewHolder.itemView).setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                    break;
                case 10:
                    ((ContainerCell) viewHolder.itemView).setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                    break;
                case 11:
                    ((PredictionCell) viewHolder.itemView).setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                    break;
                case 12:
                    ((BannerCell) viewHolder.itemView).setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                    break;
                case 13:
                    ((HomeLiveCell) viewHolder.itemView).setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                    if (((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).isVisible()) {
                        viewHolder.itemView.setVisibility(0);
                        viewHolder.itemView.getLayoutParams().height = -2;
                        break;
                    } else {
                        viewHolder.itemView.setVisibility(8);
                        viewHolder.itemView.getLayoutParams().height = 0;
                        break;
                    }
                case 14:
                    ((HomeMusicCell) viewHolder.itemView).setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                    break;
                case 15:
                    ((HomeViewTagCell) viewHolder.itemView).setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()), HomePageActivityNew.this);
                    break;
                case 16:
                    ((TextBoxCell) viewHolder.itemView).setData((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue()));
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, HomeSliderCell homeSliderCell, ArrayList arrayList, boolean z, String str) {
            ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).slider_section.slider_items_list.addAll(arrayList);
            ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).slider_section.next_start_id = str;
            ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).slider_section.has_continue = z;
            homeSliderCell.listViewAdapter.notifyItemsAdded();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(int i, HomeCollectionInnerCell homeCollectionInnerCell, ArrayList arrayList, boolean z, String str) {
            ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).collection_section.collection_items_list.get(((Integer) HomePageActivityNew.this.collectionsMap.get(Integer.valueOf(i))).intValue()).sub_collection_items_list.addAll(arrayList);
            ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).collection_section.collection_items_list.get(((Integer) HomePageActivityNew.this.collectionsMap.get(Integer.valueOf(i))).intValue()).next_start_id = str;
            ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).collection_section.collection_items_list.get(((Integer) HomePageActivityNew.this.collectionsMap.get(Integer.valueOf(i))).intValue()).has_continue = z;
            homeCollectionInnerCell.getAdapter().notifyItemsAdded();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$3(final int i, final ServiceViewPagerCell serviceViewPagerCell, HomePageModels.HomePageSectionObject homePageSectionObject, HomePageModels.UserFavoriteServicesSectionObject userFavoriteServicesSectionObject) {
            if (HomePageActivityNew.this.allServices == null || HomePageActivityNew.this.allServices.all_services_section == null) {
                return;
            }
            EditFavoriteServicesBottomSheet editFavoriteServicesBottomSheet = new EditFavoriteServicesBottomSheet(this.mContext, new EditFavoriteServicesBottomSheet.FavoriteServiceCallback() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$ListAdapter$$ExternalSyntheticLambda0
                @Override // ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet.FavoriteServiceCallback
                public final void onSave(ArrayList arrayList) {
                    this.f$0.lambda$onBindViewHolder$2(i, serviceViewPagerCell, arrayList);
                }
            });
            editFavoriteServicesBottomSheet.setItems(homePageSectionObject, userFavoriteServicesSectionObject, HomePageActivityNew.this.allServices);
            HomePageActivityNew.this.showDialog(editFavoriteServicesBottomSheet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(int i, ServiceViewPagerCell serviceViewPagerCell, ArrayList arrayList) {
            ((HomePageModels.HomePageSectionObject) HomePageActivityNew.this.arrayList.get(((Integer) HomePageActivityNew.this.indexMap.get(Integer.valueOf(i))).intValue())).user_favorite_services_section.user_favorite_services_list = arrayList;
            serviceViewPagerCell.updateItem(arrayList);
            serviceViewPagerCell.updateItems();
            serviceViewPagerCell.updateHeight();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$4(String str, String str2, String str3) {
            HomePageActivityNew.this.presentFragment(new HomeLiveListFragment(str, str2, str3));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View rubinoLoadingCell;
            View adSectionCell;
            View homeSliderCell;
            View homeCollectionInnerCell;
            View parallaxCell;
            View feedCell;
            View containerCell;
            View predictionCell;
            View bannerCell;
            View view;
            View homeMusicCell;
            switch (i) {
                case 0:
                    rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
                    rubinoLoadingCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    view = rubinoLoadingCell;
                    break;
                case 1:
                case 3:
                case 8:
                default:
                    view = new View(this.mContext);
                    break;
                case 2:
                    if (!HomePageActivityNew.this.adSectionCellCache.isEmpty()) {
                        adSectionCell = (View) HomePageActivityNew.this.adSectionCellCache.pop();
                    } else {
                        adSectionCell = new AdSectionCell(this.mContext);
                    }
                    adSectionCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = adSectionCell;
                    break;
                case 4:
                    ServiceViewPagerCell serviceViewPagerCell = new ServiceViewPagerCell(this.mContext, -1, true, false, AndroidUtilities.dp(32.0f));
                    serviceViewPagerCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = serviceViewPagerCell;
                    break;
                case 5:
                    if (!HomePageActivityNew.this.sliderCells.isEmpty()) {
                        View view2 = (View) HomePageActivityNew.this.sliderCells.pop();
                        MyLog.e(HomePageActivityNew.this.fragmentName, " ** pop slider cell");
                        homeSliderCell = view2;
                    } else {
                        homeSliderCell = new HomeSliderCell(this.mContext);
                    }
                    homeSliderCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = homeSliderCell;
                    break;
                case 6:
                    if (!HomePageActivityNew.this.collectionCells.empty()) {
                        View view3 = (View) HomePageActivityNew.this.collectionCells.pop();
                        MyLog.e(HomePageActivityNew.this.fragmentName, " ** pop collection cell");
                        homeCollectionInnerCell = view3;
                    } else {
                        homeCollectionInnerCell = new HomeCollectionInnerCell(this.mContext);
                    }
                    homeCollectionInnerCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = homeCollectionInnerCell;
                    break;
                case 7:
                    if (!HomePageActivityNew.this.parallaxCellCache.isEmpty()) {
                        parallaxCell = (View) HomePageActivityNew.this.parallaxCellCache.pop();
                    } else {
                        parallaxCell = new ParallaxCell(this.mContext);
                    }
                    parallaxCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = parallaxCell;
                    break;
                case 9:
                    if (!HomePageActivityNew.this.feedCellCache.isEmpty()) {
                        feedCell = (View) HomePageActivityNew.this.feedCellCache.pop();
                    } else {
                        feedCell = new FeedCell(this.mContext);
                    }
                    feedCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = feedCell;
                    break;
                case 10:
                    if (!HomePageActivityNew.this.containerCellCache.isEmpty()) {
                        containerCell = (View) HomePageActivityNew.this.containerCellCache.pop();
                    } else {
                        containerCell = new ContainerCell(this.mContext);
                    }
                    containerCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = containerCell;
                    break;
                case 11:
                    if (!HomePageActivityNew.this.predictionCellCache.isEmpty()) {
                        predictionCell = (View) HomePageActivityNew.this.predictionCellCache.pop();
                    } else {
                        predictionCell = new PredictionCell(this.mContext, HomePageActivityNew.this);
                    }
                    predictionCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = predictionCell;
                    break;
                case 12:
                    if (!HomePageActivityNew.this.bannerCellCache.isEmpty()) {
                        bannerCell = (View) HomePageActivityNew.this.bannerCellCache.pop();
                    } else {
                        bannerCell = new BannerCell(this.mContext);
                    }
                    bannerCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = bannerCell;
                    break;
                case 13:
                    rubinoLoadingCell = new HomeLiveCell(this.mContext, HomePageActivityNew.this.page, new HomeLiveCell.HomeLiveClickListener() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$ListAdapter$$ExternalSyntheticLambda4
                        @Override // ir.resaneh1.iptv.fragment.home.live.HomeLiveCell.HomeLiveClickListener
                        public final void onClick(String str, String str2, String str3) {
                            this.f$0.lambda$onCreateViewHolder$4(str, str2, str3);
                        }
                    }, false);
                    rubinoLoadingCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = rubinoLoadingCell;
                    break;
                case 14:
                    if (!HomePageActivityNew.this.musicCellCache.isEmpty()) {
                        homeMusicCell = (View) HomePageActivityNew.this.musicCellCache.pop();
                    } else {
                        homeMusicCell = new HomeMusicCell(this.mContext);
                    }
                    homeMusicCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = homeMusicCell;
                    break;
                case 15:
                    HomeViewTagCell homeViewTagCell = new HomeViewTagCell(this.mContext);
                    homeViewTagCell.initTestData(HomePageActivityNew.this);
                    homeViewTagCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = homeViewTagCell;
                    break;
                case 16:
                    TextBoxCell textBoxCell = new TextBoxCell(this.mContext);
                    textBoxCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
                    view = textBoxCell;
                    break;
            }
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == HomePageActivityNew.this.loadingRow) {
                return 0;
            }
            if (!HomePageActivityNew.this.typesMap.containsKey(Integer.valueOf(i))) {
                return 1;
            }
            HomePageModels.SectionTypeEnum sectionTypeEnum = (HomePageModels.SectionTypeEnum) HomePageActivityNew.this.typesMap.get(Integer.valueOf(i));
            if (sectionTypeEnum == null) {
                return 8;
            }
            switch (AnonymousClass9.$SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[sectionTypeEnum.ordinal()]) {
            }
            return 8;
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.HomePageActivityNew$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum;

        static {
            int[] iArr = new int[HomePageModels.SectionTypeEnum.values().length];
            $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum = iArr;
            try {
                iArr[HomePageModels.SectionTypeEnum.Parallax.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.Slider.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.Collection.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.UserFavoriteServices.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.Ad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.Feed.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.Container.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.Prediction.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.Banner.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.Live.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.ViewTag.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$SectionTypeEnum[HomePageModels.SectionTypeEnum.TextBox.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static class WrapContentLinearLayoutManager extends LinearLayoutManager {
        public WrapContentLinearLayoutManager(Context context, int i, boolean z) {
            super(context, i, z);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                Log.e(HomePageActivityNew.TAG, "IndexOutOfBoundsException in RecyclerView happens");
                MyLog.handleException(e);
                e.printStackTrace();
            }
        }
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        if (linkRunnable != null) {
            Utilities.stageQueue.cancelRunnable(linkRunnable);
        }
        if (this.liveRefreshRunnable != null) {
            Utilities.stageQueue.cancelRunnable(this.liveRefreshRunnable);
        }
    }

    public static void onLinkClick(final Link link) {
        if (link == null) {
            return;
        }
        if (linkRunnable != null) {
            Utilities.stageQueue.cancelRunnable(linkRunnable);
        }
        linkRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.HomePageActivityNew$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                HomePageActivityNew.lambda$onLinkClick$2(link);
            }
        };
        Utilities.stageQueue.postRunnable(linkRunnable, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onLinkClick$2(Link link) {
        new MainClickHandler().onLinkClick(link);
    }
}
