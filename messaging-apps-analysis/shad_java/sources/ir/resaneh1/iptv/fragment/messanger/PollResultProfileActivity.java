package ir.resaneh1.iptv.fragment.messanger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip;
import ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell;
import ir.resaneh1.iptv.fragment.rubino.RubinoEmptyView;
import ir.resaneh1.iptv.fragment.rubino.RubinoLoadingCell;
import ir.resaneh1.iptv.fragment.rubino.RubinoRetryView;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.model.StoryPollObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.SharedPhotoVideoCell;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class PollResultProfileActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private static int type_option_left = 0;
    private static int type_option_right = 1;
    private ListAdapter adapterLeft;
    private ListAdapter adapterRight;
    private boolean animatingForward;
    private int columnsCount;
    private CustomFrameLayout customFrameLayout;
    private int[] hasMedia;
    private PageData[] pageData;
    private ScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private boolean scrolling;
    private int searchItemState;
    private Map<Long, MessageObject>[] selectedFiles;
    private int selectedTabId;
    private StoryObject storyObject;
    private boolean tabsAnimationInProgress;
    private MediaPage[] pages = new MediaPage[2];
    private ArrayList<SharedPhotoVideoCell> cellCache = new ArrayList<>(6);

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        return this.selectedTabId == type_option_left;
    }

    private class MediaPage extends FrameLayout {
        private RubinoEmptyView emptyView;
        private LinearLayoutManager layoutManager;
        private RecyclerListView listView;
        private RadialProgressView progressBar;
        private LinearLayout progressView;
        private int selectedType;

        public MediaPage(PollResultProfileActivity pollResultProfileActivity, Context context) {
            super(context);
        }
    }

    public PollResultProfileActivity(StoryObject storyObject, int i) {
        new ArrayList(6);
        this.selectedFiles = new HashMap[]{new HashMap(), new HashMap()};
        this.columnsCount = 2;
        this.pageData = new PageData[2];
        FragmentType fragmentType = FragmentType.Rubino;
        this.selectedTabId = i;
        this.storyObject = storyObject;
        this.fragmentName = "PollResultProfileActivity";
        this.isSmallActionBar = true;
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            this.isFullScreen = true;
        }
        this.isForceBlackTheme = true;
        this.needLockOrientation = true;
        this.hasMedia = new int[]{1, 1};
    }

    private class PageData {
        private int arrayEndRow;
        private int arrayStartRow;
        private boolean endReached;
        private int loadMorePosition;
        private boolean loading;
        private int loadingRow;
        public boolean needToRetry;
        private ArrayList<RubinoProfileObject> profiles;
        private HashMap<String, RubinoProfileObject> profilesMap;
        private DisposableObserver requestObservable;
        private int retryRow;
        private int rowCount;
        private String startId;

        private PageData() {
            this.profiles = new ArrayList<>();
            new ArrayList();
            this.profilesMap = new HashMap<>();
            new HashMap();
            this.startId = null;
        }

        void updateRows(int i, boolean z) {
            this.arrayStartRow = -1;
            this.arrayEndRow = -1;
            this.loadingRow = -1;
            this.retryRow = -1;
            this.loadMorePosition = Math.max(0, this.profiles.size() - 15);
            this.rowCount = 0;
            if (this.needToRetry) {
                this.rowCount = 0 + 1;
                this.retryRow = 0;
                this.loadMorePosition = -1;
            } else {
                int size = this.profiles.size();
                if (size > 0) {
                    int i2 = this.rowCount;
                    this.arrayStartRow = i2;
                    int i3 = i2 + size;
                    this.rowCount = i3;
                    this.arrayEndRow = i3;
                }
                if (!this.endReached) {
                    int i4 = this.rowCount;
                    this.rowCount = i4 + 1;
                    this.loadingRow = i4;
                }
            }
            if (z) {
                ListAdapter listAdapter = i == PollResultProfileActivity.type_option_left ? PollResultProfileActivity.this.adapterLeft : PollResultProfileActivity.this.adapterRight;
                if (listAdapter != null) {
                    listAdapter.notifyDataSetChanged();
                }
            }
        }

        public boolean addProfile(RubinoProfileObject rubinoProfileObject, boolean z) {
            if (this.profilesMap.get(rubinoProfileObject.id) != null) {
                return false;
            }
            if (z) {
                this.profiles.add(0, rubinoProfileObject);
            } else {
                this.profiles.add(rubinoProfileObject);
            }
            this.profilesMap.put(rubinoProfileObject.id, rubinoProfileObject);
            return true;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        int i = 0;
        while (true) {
            PageData[] pageDataArr = this.pageData;
            if (i >= pageDataArr.length) {
                return true;
            }
            pageDataArr[i] = new PageData();
            this.pageData[i].startId = null;
            i++;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoFollowBlockChanged);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        RecyclerListView.Holder holder;
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        ((FrameLayout.LayoutParams) this.actionBar.backButtonImageView.getLayoutParams()).gravity = 53;
        this.actionBar.setTitle(LocaleController.getString(R.string.rubinoPollVoters));
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceMedium());
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    PollResultProfileActivity.this.finishFragment();
                }
            }
        });
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = new ScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = scrollSlidingTextTabStrip;
        scrollSlidingTextTabStrip.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.actionBar.addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity.2
            @Override // ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i, boolean z) {
                if (PollResultProfileActivity.this.pages[0].selectedType == i) {
                    return;
                }
                PollResultProfileActivity.this.selectedTabId = i;
                PollResultProfileActivity pollResultProfileActivity = PollResultProfileActivity.this;
                ((BaseFragment) pollResultProfileActivity).swipeBackEnabled = i == pollResultProfileActivity.scrollSlidingTextTabStrip.getFirstTabId();
                PollResultProfileActivity.this.pages[1].selectedType = i;
                PollResultProfileActivity.this.pages[1].setVisibility(0);
                PollResultProfileActivity.this.switchToCurrentSelectedMode(true);
                PollResultProfileActivity.this.animatingForward = z;
            }

            @Override // ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float f) {
                if (f != 1.0f || PollResultProfileActivity.this.pages[1].getVisibility() == 0) {
                    if (PollResultProfileActivity.this.animatingForward) {
                        PollResultProfileActivity.this.pages[0].setTranslationX((-f) * PollResultProfileActivity.this.pages[1].getMeasuredWidth());
                        PollResultProfileActivity.this.pages[1].setTranslationX(PollResultProfileActivity.this.pages[1].getMeasuredWidth() - (PollResultProfileActivity.this.pages[1].getMeasuredWidth() * f));
                    } else {
                        PollResultProfileActivity.this.pages[0].setTranslationX(PollResultProfileActivity.this.pages[1].getMeasuredWidth() * f);
                        PollResultProfileActivity.this.pages[1].setTranslationX((PollResultProfileActivity.this.pages[1].getMeasuredWidth() * f) - PollResultProfileActivity.this.pages[1].getMeasuredWidth());
                    }
                    if (PollResultProfileActivity.this.searchItemState != 1) {
                        int unused = PollResultProfileActivity.this.searchItemState;
                    }
                    if (f == 1.0f) {
                        MediaPage mediaPage = PollResultProfileActivity.this.pages[0];
                        PollResultProfileActivity.this.pages[0] = PollResultProfileActivity.this.pages[1];
                        PollResultProfileActivity.this.pages[1] = mediaPage;
                        PollResultProfileActivity.this.pages[1].setVisibility(4);
                        int unused2 = PollResultProfileActivity.this.searchItemState;
                        PollResultProfileActivity.this.searchItemState = 0;
                    }
                }
            }
        });
        for (int i = 1; i >= 0; i--) {
            this.selectedFiles[i].clear();
        }
        this.searchItemState = 0;
        this.adapterLeft = new ListAdapter(context, type_option_left);
        this.adapterRight = new ListAdapter(context, type_option_right);
        CustomFrameLayout customFrameLayout = new CustomFrameLayout(context);
        this.customFrameLayout = customFrameLayout;
        this.fragmentView = customFrameLayout;
        int i2 = 0;
        int iFindFirstVisibleItemPosition = -1;
        int top = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.pages;
            if (i2 >= mediaPageArr.length) {
                break;
            }
            if (i2 == 0 && mediaPageArr[i2] != null && mediaPageArr[i2].layoutManager != null) {
                iFindFirstVisibleItemPosition = this.pages[i2].layoutManager.findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition == this.pages[i2].layoutManager.getItemCount() - 1 || (holder = (RecyclerListView.Holder) this.pages[i2].listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) == null) {
                    iFindFirstVisibleItemPosition = -1;
                } else {
                    top = holder.itemView.getTop();
                }
            }
            final MediaPage mediaPage = new MediaPage(context) { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity.3
                @Override // android.view.View
                public void setTranslationX(float f) {
                    super.setTranslationX(f);
                    if (PollResultProfileActivity.this.tabsAnimationInProgress && PollResultProfileActivity.this.pages[0] == this) {
                        PollResultProfileActivity.this.scrollSlidingTextTabStrip.selectTabWithId(PollResultProfileActivity.this.pages[1].selectedType, Math.abs(PollResultProfileActivity.this.pages[0].getTranslationX()) / PollResultProfileActivity.this.pages[0].getMeasuredWidth());
                        if (PollResultProfileActivity.this.searchItemState == 2) {
                            return;
                        }
                        int unused = PollResultProfileActivity.this.searchItemState;
                    }
                }
            };
            this.customFrameLayout.addView(mediaPage, LayoutHelper.createFrame(-1, -1.0f));
            MediaPage[] mediaPageArr2 = this.pages;
            mediaPageArr2[i2] = mediaPage;
            final LinearLayoutManager linearLayoutManager = mediaPageArr2[i2].layoutManager = new LinearLayoutManager(context, 1, false);
            this.pages[i2].listView = new RecyclerListView(context);
            this.pages[i2].listView.setClipToPadding(false);
            this.pages[i2].listView.setSectionsType(2);
            this.pages[i2].listView.setLayoutManager(linearLayoutManager);
            MediaPage[] mediaPageArr3 = this.pages;
            mediaPageArr3[i2].addView(mediaPageArr3[i2].listView, LayoutHelper.createFrame(-1, -1.0f));
            this.pages[i2].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity.4
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                    if (i3 == 1 || i3 == 2) {
                        PollResultProfileActivity.this.resetFlags();
                    }
                    PollResultProfileActivity.this.scrolling = i3 != 0;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                    int iFindFirstVisibleItemPosition2 = linearLayoutManager.findFirstVisibleItemPosition();
                    int iAbs = iFindFirstVisibleItemPosition2 == -1 ? 0 : Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition2) + 1;
                    int itemCount = recyclerView.getAdapter().getItemCount();
                    if (iAbs == 0 || iFindFirstVisibleItemPosition2 + iAbs <= itemCount - 2) {
                        return;
                    }
                    boolean unused = PollResultProfileActivity.this.pageData[mediaPage.selectedType].loading;
                }
            });
            if (i2 == 0 && iFindFirstVisibleItemPosition != -1) {
                linearLayoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
            }
            RubinoEmptyView rubinoEmptyView = new RubinoEmptyView(context, 17);
            this.pages[i2].emptyView = rubinoEmptyView;
            rubinoEmptyView.setData(R.drawable.rubino_empty_state_follow, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            this.pages[i2].progressView = new LinearLayout(context);
            this.pages[i2].progressView.setGravity(17);
            this.pages[i2].progressView.setOrientation(1);
            this.pages[i2].progressView.setVisibility(8);
            this.pages[i2].progressView.setBackgroundColor(context.getResources().getColor(R.color.grey_100));
            MediaPage[] mediaPageArr4 = this.pages;
            mediaPageArr4[i2].addView(mediaPageArr4[i2].progressView, LayoutHelper.createFrame(-1, -1.0f));
            this.pages[i2].progressBar = new RadialProgressView(context);
            this.pages[i2].progressBar.setProgressColor(-14606047);
            this.pages[i2].progressView.addView(this.pages[i2].progressBar, LayoutHelper.createLinear(-2, -2));
            if (i2 != 0) {
                this.pages[i2].setVisibility(4);
            }
            i2++;
        }
        for (int i3 = 0; i3 < 6; i3++) {
            this.cellCache.add(new SharedPhotoVideoCell(context));
        }
        this.pageData[this.selectedTabId].loading = false;
        if (this.pages[0].progressView != null) {
            this.pages[0].progressView.setVisibility(4);
        }
        this.pageData[this.selectedTabId].endReached = false;
        updateTabs();
        this.scrollSlidingTextTabStrip.selectTabWithId(this.selectedTabId, 1.0f);
        this.swipeBackEnabled = this.selectedTabId == this.scrollSlidingTextTabStrip.getFirstTabId();
        this.pages[1].selectedType = this.selectedTabId;
        this.pages[0].selectedType = this.selectedTabId;
        switchToCurrentSelectedMode(false);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetFlags() {
        this.customFrameLayout.resetFlags();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapterLeft;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        ListAdapter listAdapter2 = this.adapterRight;
        if (listAdapter2 != null) {
            listAdapter2.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        ProfileOrHashtagCell profileOrHashtagCell;
        RubinoProfileObject rubinoProfileObject;
        if (i == NotificationCenter.rubinoFollowBlockChanged) {
            int childCount = this.pages[0].listView.getChildCount();
            String str = (String) objArr[0];
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.pages[0].listView.getChildAt(i3);
                if ((childAt instanceof ProfileOrHashtagCell) && (rubinoProfileObject = (profileOrHashtagCell = (ProfileOrHashtagCell) childAt).currentProfile) != null && rubinoProfileObject.id.equals(str)) {
                    profileOrHashtagCell.setButtons();
                }
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.pages;
            if (i >= mediaPageArr.length) {
                return;
            }
            if (mediaPageArr[i].listView != null) {
                this.pages[i].listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity.5
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        PollResultProfileActivity.this.pages[i].getViewTreeObserver().removeOnPreDrawListener(this);
                        PollResultProfileActivity.this.fixLayoutInternal(i);
                        return true;
                    }
                });
            }
            i++;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return this.actionBar.isEnabled();
    }

    private void updateTabs() {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (scrollSlidingTextTabStrip == null) {
            return;
        }
        int[] iArr = this.hasMedia;
        boolean z = (iArr[0] != 0 || iArr[1] == 0) && !scrollSlidingTextTabStrip.hasTab(0);
        if (this.hasMedia[1] != 0 && !this.scrollSlidingTextTabStrip.hasTab(1)) {
            z = true;
        }
        if (z) {
            this.scrollSlidingTextTabStrip.removeTabs();
            StoryPollObject pollIfExist = this.storyObject.getPollIfExist();
            int[] iArr2 = this.hasMedia;
            int i = iArr2[0];
            String str = BuildConfig.FLAVOR;
            if ((i != 0 || iArr2[1] == 0) && !this.scrollSlidingTextTabStrip.hasTab(type_option_left)) {
                this.scrollSlidingTextTabStrip.addTextTab(type_option_left, (pollIfExist == null || (arrayList = pollIfExist.choices_list) == null || arrayList.size() <= 0) ? BuildConfig.FLAVOR : pollIfExist.choices_list.get(0), 14, Theme.getRubinoTypeFaceBold());
            }
            if (this.hasMedia[1] != 0 && !this.scrollSlidingTextTabStrip.hasTab(type_option_right)) {
                ScrollSlidingTextTabStrip scrollSlidingTextTabStrip2 = this.scrollSlidingTextTabStrip;
                int i2 = type_option_right;
                if (pollIfExist != null && (arrayList2 = pollIfExist.choices_list) != null && arrayList2.size() > 1) {
                    str = pollIfExist.choices_list.get(1);
                }
                scrollSlidingTextTabStrip2.addTextTab(i2, str, 14, Theme.getRubinoTypeFaceBold());
            }
        }
        if (this.scrollSlidingTextTabStrip.getTabsCount() <= 1) {
            this.scrollSlidingTextTabStrip.setVisibility(8);
            this.actionBar.setExtraHeight(0);
        } else {
            this.scrollSlidingTextTabStrip.setVisibility(0);
            this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        }
        int currentTabId = this.scrollSlidingTextTabStrip.getCurrentTabId();
        if (currentTabId >= 0) {
            this.pages[0].selectedType = currentTabId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode(boolean z) {
        MediaPage[] mediaPageArr;
        ListAdapter listAdapter;
        int i = 0;
        while (true) {
            mediaPageArr = this.pages;
            if (i >= mediaPageArr.length) {
                break;
            }
            mediaPageArr[i].listView.stopScroll();
            i++;
        }
        RecyclerView.Adapter adapter = mediaPageArr[z ? 1 : 0].listView.getAdapter();
        if (z) {
            if (this.pages[z ? 1 : 0].selectedType != type_option_left) {
                if (this.pages[z ? 1 : 0].selectedType == type_option_right && (listAdapter = this.adapterRight) != null && adapter != listAdapter) {
                    this.pages[z ? 1 : 0].listView.setAdapter(this.adapterRight);
                }
            } else {
                ListAdapter listAdapter2 = this.adapterLeft;
                if (listAdapter2 != null && adapter != listAdapter2) {
                    this.pages[z ? 1 : 0].listView.setAdapter(this.adapterLeft);
                }
            }
            this.pageData[this.pages[z ? 1 : 0].selectedType].updateRows(this.pages[z ? 1 : 0].selectedType, true);
        } else if (this.pages[z ? 1 : 0].listView != null) {
            if (this.pages[z ? 1 : 0].selectedType != type_option_left) {
                if (this.pages[z ? 1 : 0].selectedType == type_option_right && adapter != this.adapterRight) {
                    this.pages[z ? 1 : 0].listView.setAdapter(this.adapterRight);
                }
            } else if (adapter != this.adapterLeft) {
                this.pages[z ? 1 : 0].listView.setAdapter(this.adapterLeft);
            }
            this.pageData[this.pages[z ? 1 : 0].selectedType].updateRows(this.pages[z ? 1 : 0].selectedType, true);
        }
        if (this.searchItemState == 2 && this.actionBar.isSearchFieldVisible()) {
            this.actionBar.closeSearchField();
            this.searchItemState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal(int i) {
        ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        this.columnsCount = 2;
    }

    void loadData(final int i, final boolean z) {
        if (this.pageData[i].requestObservable != null && !this.pageData[i].requestObservable.isDisposed()) {
            this.pageData[i].requestObservable.dispose();
        }
        this.pageData[i].loading = true;
        Observable<Rubino.ProfileListObject> pollResultObservable = getRubinoController().getPollResultObservable(this.storyObject.id, i + 1, z ? null : this.pageData[i].startId, 50);
        if (pollResultObservable != null) {
            this.pageData[i].requestObservable = (DisposableObserver) pollResultObservable.observeOn(Schedulers.io()).doOnNext(new Consumer<Rubino.ProfileListObject>() { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity.7
                @Override // io.reactivex.functions.Consumer
                public void accept(Rubino.ProfileListObject profileListObject) throws Exception {
                    if (profileListObject != null) {
                        PollResultProfileActivity.this.pageData[i].loading = false;
                        int size = profileListObject.profiles.size();
                        if (z) {
                            PollResultProfileActivity.this.pageData[i].profiles.clear();
                            PollResultProfileActivity.this.pageData[i].profilesMap.clear();
                        }
                        PollResultProfileActivity.this.pageData[i].startId = profileListObject.nextStartId;
                        if (size > 0) {
                            Iterator<RubinoProfileObject> it = profileListObject.profiles.iterator();
                            while (it.hasNext()) {
                                PollResultProfileActivity.this.pageData[i].addProfile(it.next(), false);
                            }
                            return;
                        }
                        if (profileListObject.nextStartId == null) {
                            PollResultProfileActivity.this.pageData[i].endReached = true;
                        }
                    }
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.ProfileListObject>() { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity.6
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(Rubino.ProfileListObject profileListObject) {
                    dispose();
                    if (profileListObject != null) {
                        for (int i2 = 0; i2 < PollResultProfileActivity.this.pages.length; i2++) {
                            if (PollResultProfileActivity.this.pages[i2].selectedType == i) {
                                if (!PollResultProfileActivity.this.pageData[i].loading) {
                                    if (PollResultProfileActivity.this.pages[i2].progressView != null) {
                                        PollResultProfileActivity.this.pages[i2].progressView.setVisibility(8);
                                    }
                                    if (PollResultProfileActivity.this.pages[i2].selectedType == i && PollResultProfileActivity.this.pages[i2].listView != null && PollResultProfileActivity.this.pages[i2].listView.getEmptyView() == null) {
                                        PollResultProfileActivity.this.pages[i2].listView.setEmptyView(PollResultProfileActivity.this.pages[i2].emptyView);
                                    }
                                }
                                PageData[] pageDataArr = PollResultProfileActivity.this.pageData;
                                int i3 = i;
                                pageDataArr[i3].updateRows(i3, true);
                            }
                        }
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    dispose();
                    if (PollResultProfileActivity.this.pageData[i].profiles.size() == 0) {
                        PollResultProfileActivity.this.pageData[i].needToRetry = true;
                        PageData[] pageDataArr = PollResultProfileActivity.this.pageData;
                        int i2 = i;
                        pageDataArr[i2].updateRows(i2, true);
                    }
                }
            });
            this.compositeDisposable.add(this.pageData[i].requestObservable);
        }
    }

    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private int currentType;
        Context mContext;

        public ListAdapter(Context context, int i) {
            this.mContext = context;
            this.currentType = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PollResultProfileActivity.this.pageData[this.currentType].rowCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            PollResultProfileActivity.this.pageData[this.currentType].needToRetry = false;
            PageData[] pageDataArr = PollResultProfileActivity.this.pageData;
            int i = this.currentType;
            pageDataArr[i].updateRows(i, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ProfileOrHashtagCell profileOrHashtagCell;
            View rubinoLoadingCell;
            if (i == 0) {
                ProfileOrHashtagCell profileOrHashtagCell2 = new ProfileOrHashtagCell(this.mContext, false, false);
                profileOrHashtagCell2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                profileOrHashtagCell = profileOrHashtagCell2;
            } else if (i == 5) {
                RubinoRetryView rubinoRetryView = new RubinoRetryView(this.mContext);
                rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
                rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity$ListAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$0(view);
                    }
                });
                rubinoRetryView.setBackgroundColor(-1);
                rubinoRetryView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(80.0f)));
                ((LinearLayout.LayoutParams) rubinoRetryView.imageView.getLayoutParams()).topMargin = AndroidUtilities.dp(4.0f);
                profileOrHashtagCell = rubinoRetryView;
            } else {
                rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
                return new RecyclerListView.Holder(rubinoLoadingCell);
            }
            rubinoLoadingCell = profileOrHashtagCell;
            return new RecyclerListView.Holder(rubinoLoadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            MyLog.e("List Status", "onBind: " + viewHolder.getAdapterPosition());
            if (viewHolder.getItemViewType() == 0) {
                ProfileOrHashtagCell profileOrHashtagCell = (ProfileOrHashtagCell) viewHolder.itemView;
                if (i >= PollResultProfileActivity.this.pageData[this.currentType].arrayStartRow && i < PollResultProfileActivity.this.pageData[this.currentType].arrayEndRow) {
                    RubinoProfileObject rubinoProfileObject = (RubinoProfileObject) PollResultProfileActivity.this.pageData[this.currentType].profiles.get(i - PollResultProfileActivity.this.pageData[this.currentType].arrayStartRow);
                    RubinoProfileObject rubinoProfileObject2 = PollResultProfileActivity.this.getRubinoController().profileMap.get(rubinoProfileObject.id);
                    if (rubinoProfileObject2 != null) {
                        profileOrHashtagCell.setProfile(rubinoProfileObject2, ((BaseFragment) PollResultProfileActivity.this).classGuid);
                    } else {
                        profileOrHashtagCell.setProfile(rubinoProfileObject, ((BaseFragment) PollResultProfileActivity.this).classGuid);
                    }
                }
            }
            if (PollResultProfileActivity.this.pageData[this.currentType].endReached) {
                return;
            }
            if (i == PollResultProfileActivity.this.pageData[this.currentType].loadMorePosition || i == PollResultProfileActivity.this.pageData[this.currentType].loadingRow) {
                PollResultProfileActivity.this.loadData(this.currentType, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= PollResultProfileActivity.this.pageData[this.currentType].arrayStartRow && i < PollResultProfileActivity.this.pageData[this.currentType].arrayEndRow) {
                return 0;
            }
            if (i == PollResultProfileActivity.this.pageData[this.currentType].loadingRow) {
                return 1;
            }
            return i == PollResultProfileActivity.this.pageData[this.currentType].retryRow ? 5 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            for (int i = 0; i < PollResultProfileActivity.this.pages.length; i++) {
                if (PollResultProfileActivity.this.pages[i].selectedType == this.currentType) {
                    PollResultProfileActivity.this.pages[i].listView.setEmptyView(PollResultProfileActivity.this.pages[i].emptyView);
                    PollResultProfileActivity.this.pages[i].progressView.setVisibility(8);
                }
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.itemView instanceof RubinoRetryView;
        }
    }

    public class CustomFrameLayout extends FrameLayout {
        private boolean maybeStartTracking;
        private boolean startedTracking;
        private int startedTrackingPointerId;
        private int startedTrackingX;
        private int startedTrackingY;
        private VelocityTracker velocityTracker;

        public CustomFrameLayout(Context context) {
            super(context);
        }

        private boolean prepareForMoving(MotionEvent motionEvent, boolean z) {
            int nextPageId = PollResultProfileActivity.this.scrollSlidingTextTabStrip.getNextPageId(z);
            if (nextPageId < 0) {
                return false;
            }
            if (PollResultProfileActivity.this.searchItemState != 0) {
                if (PollResultProfileActivity.this.searchItemState != 2) {
                    int unused = PollResultProfileActivity.this.searchItemState;
                }
                PollResultProfileActivity.this.searchItemState = 0;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            this.maybeStartTracking = false;
            this.startedTracking = true;
            this.startedTrackingX = (int) motionEvent.getX();
            ((BaseFragment) PollResultProfileActivity.this).actionBar.setEnabled(false);
            PollResultProfileActivity.this.scrollSlidingTextTabStrip.setEnabled(false);
            PollResultProfileActivity.this.selectedTabId = nextPageId;
            PollResultProfileActivity.this.pages[1].selectedType = nextPageId;
            PollResultProfileActivity.this.pages[1].setVisibility(0);
            PollResultProfileActivity.this.animatingForward = z;
            PollResultProfileActivity.this.switchToCurrentSelectedMode(true);
            if (z) {
                PollResultProfileActivity.this.pages[1].setTranslationX(PollResultProfileActivity.this.pages[1].getMeasuredWidth());
            } else {
                PollResultProfileActivity.this.pages[1].setTranslationX(-PollResultProfileActivity.this.pages[1].getMeasuredWidth());
            }
            return true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return PollResultProfileActivity.this.tabsAnimationInProgress || PollResultProfileActivity.this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (((BaseFragment) PollResultProfileActivity.this).parentLayout.checkTransitionAnimation() || PollResultProfileActivity.this.tabsAnimationInProgress) {
                return false;
            }
            if (motionEvent != null && motionEvent.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking) {
                this.startedTrackingPointerId = motionEvent.getPointerId(0);
                this.maybeStartTracking = true;
                this.startedTrackingX = (int) motionEvent.getX();
                this.startedTrackingY = (int) motionEvent.getY();
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            } else if (motionEvent != null && motionEvent.getAction() == 2 && motionEvent.getPointerId(0) == this.startedTrackingPointerId) {
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                int x = (int) (motionEvent.getX() - this.startedTrackingX);
                int iAbs = Math.abs(((int) motionEvent.getY()) - this.startedTrackingY);
                this.velocityTracker.addMovement(motionEvent);
                if (this.startedTracking && ((PollResultProfileActivity.this.animatingForward && x > 0) || (!PollResultProfileActivity.this.animatingForward && x < 0))) {
                    if (!prepareForMoving(motionEvent, x < 0)) {
                        this.maybeStartTracking = true;
                        this.startedTracking = false;
                    }
                }
                if (!this.maybeStartTracking || this.startedTracking) {
                    if (this.startedTracking) {
                        if (PollResultProfileActivity.this.animatingForward) {
                            PollResultProfileActivity.this.pages[0].setTranslationX(x);
                            PollResultProfileActivity.this.pages[1].setTranslationX(PollResultProfileActivity.this.pages[1].getMeasuredWidth() + x);
                        } else {
                            PollResultProfileActivity.this.pages[0].setTranslationX(x);
                            PollResultProfileActivity.this.pages[1].setTranslationX(x - PollResultProfileActivity.this.pages[1].getMeasuredWidth());
                        }
                        float fAbs = Math.abs(x) / PollResultProfileActivity.this.pages[0].getMeasuredWidth();
                        if (PollResultProfileActivity.this.searchItemState != 2) {
                            int unused = PollResultProfileActivity.this.searchItemState;
                        }
                        PollResultProfileActivity.this.scrollSlidingTextTabStrip.selectTabWithId(PollResultProfileActivity.this.pages[1].selectedType, fAbs);
                    }
                } else if (Math.abs(x) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x) / 3 > iAbs) {
                    prepareForMoving(motionEvent, x < 0);
                }
            } else if (motionEvent != null && motionEvent.getPointerId(0) == this.startedTrackingPointerId && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6)) {
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE);
                if (!this.startedTracking) {
                    float xVelocity = this.velocityTracker.getXVelocity();
                    float yVelocity = this.velocityTracker.getYVelocity();
                    if (Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                        prepareForMoving(motionEvent, xVelocity < 0.0f);
                    }
                }
                if (this.startedTracking) {
                    float x2 = PollResultProfileActivity.this.pages[0].getX();
                    AnimatorSet animatorSet = new AnimatorSet();
                    float xVelocity2 = this.velocityTracker.getXVelocity();
                    final boolean z = Math.abs(x2) < ((float) PollResultProfileActivity.this.pages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity2) < 3500.0f || Math.abs(xVelocity2) < Math.abs(this.velocityTracker.getYVelocity()));
                    if (z) {
                        if (PollResultProfileActivity.this.animatingForward) {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(PollResultProfileActivity.this.pages[0], "translationX", 0.0f), ObjectAnimator.ofFloat(PollResultProfileActivity.this.pages[1], "translationX", PollResultProfileActivity.this.pages[1].getMeasuredWidth()));
                        } else {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(PollResultProfileActivity.this.pages[0], "translationX", 0.0f), ObjectAnimator.ofFloat(PollResultProfileActivity.this.pages[1], "translationX", -PollResultProfileActivity.this.pages[1].getMeasuredWidth()));
                        }
                    } else if (PollResultProfileActivity.this.animatingForward) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(PollResultProfileActivity.this.pages[0], "translationX", -PollResultProfileActivity.this.pages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(PollResultProfileActivity.this.pages[1], "translationX", 0.0f));
                    } else {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(PollResultProfileActivity.this.pages[0], "translationX", PollResultProfileActivity.this.pages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(PollResultProfileActivity.this.pages[1], "translationX", 0.0f));
                    }
                    animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                    animatorSet.setDuration(200L);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity.CustomFrameLayout.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (z) {
                                PollResultProfileActivity.this.pages[1].setVisibility(4);
                                if (PollResultProfileActivity.this.searchItemState != 2) {
                                    int unused2 = PollResultProfileActivity.this.searchItemState;
                                }
                                PollResultProfileActivity.this.searchItemState = 0;
                            } else {
                                MediaPage mediaPage = PollResultProfileActivity.this.pages[0];
                                PollResultProfileActivity.this.pages[0] = PollResultProfileActivity.this.pages[1];
                                PollResultProfileActivity.this.pages[1] = mediaPage;
                                PollResultProfileActivity.this.pages[1].setVisibility(4);
                                int unused3 = PollResultProfileActivity.this.searchItemState;
                                PollResultProfileActivity.this.searchItemState = 0;
                                PollResultProfileActivity pollResultProfileActivity = PollResultProfileActivity.this;
                                ((BaseFragment) pollResultProfileActivity).swipeBackEnabled = pollResultProfileActivity.pages[0].selectedType == PollResultProfileActivity.this.scrollSlidingTextTabStrip.getFirstTabId();
                                PollResultProfileActivity.this.scrollSlidingTextTabStrip.selectTabWithId(PollResultProfileActivity.this.pages[0].selectedType, 1.0f);
                            }
                            PollResultProfileActivity.this.tabsAnimationInProgress = false;
                            CustomFrameLayout.this.maybeStartTracking = false;
                            CustomFrameLayout.this.startedTracking = false;
                            ((BaseFragment) PollResultProfileActivity.this).actionBar.setEnabled(true);
                            PollResultProfileActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                        }
                    });
                    animatorSet.start();
                    PollResultProfileActivity.this.tabsAnimationInProgress = true;
                } else {
                    this.maybeStartTracking = false;
                    this.startedTracking = false;
                    ((BaseFragment) PollResultProfileActivity.this).actionBar.setEnabled(true);
                    PollResultProfileActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                }
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.velocityTracker = null;
                }
            }
            return this.startedTracking;
        }

        public void resetFlags() {
            this.maybeStartTracking = false;
            this.startedTracking = false;
            ((BaseFragment) PollResultProfileActivity.this).actionBar.setEnabled(true);
            PollResultProfileActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
        }
    }
}
