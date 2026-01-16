package ir.resaneh1.iptv.fragment;

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
import ir.resaneh1.iptv.apiMessanger.ApiServerException;
import ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip;
import ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.fragment.rubino.RubinoEmptyView;
import ir.resaneh1.iptv.fragment.rubino.RubinoLoadingCell;
import ir.resaneh1.iptv.fragment.rubino.RubinoRetryView;
import ir.resaneh1.iptv.fragment.rubino.RubinoSearchView;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
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

/* loaded from: classes3.dex */
public class RubinoFollowerFollowingActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private static int type_follower = 0;
    private static int type_following = 1;
    private ListAdapter adapterFollower;
    private ListAdapter adapterFollowing;
    private ListAdapter adapterSearchFollower;
    private ListAdapter adapterSearchFollowing;
    private boolean animatingForward;
    private int columnsCount;
    private CustomFrameLayout customFrameLayout;
    private int[] hasMedia;
    private PageData[] pageData;
    private RubinoProfileObject profileObject;
    private ScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private int searchItemState;
    private Map<Long, MessageObject>[] selectedFiles;
    private int selectedTabId;
    private boolean tabsAnimationInProgress;
    private MediaPage[] pages = new MediaPage[2];
    private ArrayList<SharedPhotoVideoCell> cellCache = new ArrayList<>(6);

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        return this.selectedTabId == type_follower;
    }

    private class MediaPage extends FrameLayout {
        private RubinoEmptyView emptyView;
        private LinearLayoutManager layoutManager;
        private RecyclerListViewEdited listView;
        private RadialProgressView progressBar;
        private LinearLayout progressView;
        private int selectedType;

        public MediaPage(RubinoFollowerFollowingActivity rubinoFollowerFollowingActivity, Context context) {
            super(context);
        }
    }

    public RubinoFollowerFollowingActivity(RubinoProfileObject rubinoProfileObject, int i) {
        new ArrayList(6);
        this.selectedFiles = new HashMap[]{new HashMap(), new HashMap()};
        this.columnsCount = 2;
        this.pageData = new PageData[2];
        FragmentType fragmentType = FragmentType.Rubino;
        this.selectedTabId = i;
        this.profileObject = rubinoProfileObject;
        this.fragmentName = "RubinoFollowerFollowingActivity";
        this.isSmallActionBar = true;
        this.needLockOrientation = true;
        this.hasMedia = new int[]{1, 1};
    }

    private class PageData {
        private int arrayEndRow;
        private int arrayStartRow;
        private int emptyViewRow;
        private boolean endReached;
        private boolean endReachedSearch;
        private int loadMorePosition;
        private boolean loading;
        private int loadingRow;
        private boolean loadingSearch;
        private String max_id;
        private String max_id_search;
        public boolean needToRetry;
        private ArrayList<RubinoProfileObject> profiles;
        private HashMap<String, RubinoProfileObject> profilesMap;
        private HashMap<String, RubinoProfileObject> profilesMapSearch;
        private ArrayList<RubinoProfileObject> profilesSearch;
        private DisposableObserver requestObservable;
        private int retryRow;
        private int rowCount;
        private int searchRow;
        private RubinoSearchView searchView;
        private boolean searching;
        private String searchingText;

        private PageData() {
            this.profiles = new ArrayList<>();
            this.profilesSearch = new ArrayList<>();
            this.profilesMap = new HashMap<>();
            this.profilesMapSearch = new HashMap<>();
            this.max_id = null;
        }

        void updateRowsOnLoadData(int i, boolean z) {
            int size = (this.searching ? this.profilesSearch : this.profiles).size();
            if (this.arrayStartRow < 0 || size <= 0) {
                updateRows(i, z);
                return;
            }
            this.loadMorePosition = Math.max(0, size - 15);
            int i2 = this.rowCount;
            int i3 = this.arrayStartRow;
            this.rowCount = i3;
            int i4 = i3 + size;
            this.rowCount = i4;
            this.arrayEndRow = i4;
            int i5 = this.loadingRow;
            boolean z2 = this.searching;
            if ((z2 && !this.endReachedSearch) || (!z2 && !this.endReached)) {
                this.rowCount = i4 + 1;
                this.loadingRow = i4;
            } else {
                this.loadingRow = -1;
            }
            if (z) {
                int i6 = RubinoFollowerFollowingActivity.type_follower;
                ListAdapter listAdapter = z2 ? i == i6 ? RubinoFollowerFollowingActivity.this.adapterSearchFollower : RubinoFollowerFollowingActivity.this.adapterSearchFollowing : i == i6 ? RubinoFollowerFollowingActivity.this.adapterFollower : RubinoFollowerFollowingActivity.this.adapterFollowing;
                if (listAdapter != null) {
                    int i7 = this.rowCount;
                    if (i7 < i2) {
                        listAdapter.notifyItemRangeRemoved(i5, i2 - i7);
                        return;
                    }
                    listAdapter.notifyItemRangeChanged(i5, 1);
                    int i8 = this.rowCount;
                    if (i8 - i2 > 0) {
                        listAdapter.notifyItemRangeInserted(i2, i8 - i2);
                    }
                }
            }
        }

        void updateRows(int i, boolean z) {
            this.searchRow = -1;
            this.arrayStartRow = -1;
            this.emptyViewRow = -1;
            this.arrayEndRow = -1;
            this.loadingRow = -1;
            this.retryRow = -1;
            int size = (this.searching ? this.profilesSearch : this.profiles).size();
            this.loadMorePosition = Math.max(0, size - 15);
            this.rowCount = 0;
            if (this.needToRetry) {
                this.rowCount = 0 + 1;
                this.retryRow = 0;
                this.loadMorePosition = -1;
            } else {
                if (size > 0 || this.searching) {
                    this.rowCount = 0 + 1;
                    this.searchRow = 0;
                }
                if (size > 0) {
                    int i2 = this.rowCount;
                    this.arrayStartRow = i2;
                    int i3 = i2 + size;
                    this.rowCount = i3;
                    this.arrayEndRow = i3;
                }
                boolean z2 = this.searching;
                if ((z2 && !this.endReachedSearch) || (!z2 && !this.endReached)) {
                    int i4 = this.rowCount;
                    this.rowCount = i4 + 1;
                    this.loadingRow = i4;
                } else if (size == 0 && !z2) {
                    int i5 = this.rowCount;
                    this.rowCount = i5 + 1;
                    this.emptyViewRow = i5;
                }
            }
            if (z) {
                ListAdapter listAdapter = this.searching ? i == RubinoFollowerFollowingActivity.type_follower ? RubinoFollowerFollowingActivity.this.adapterSearchFollower : RubinoFollowerFollowingActivity.this.adapterSearchFollowing : i == RubinoFollowerFollowingActivity.type_follower ? RubinoFollowerFollowingActivity.this.adapterFollower : RubinoFollowerFollowingActivity.this.adapterFollowing;
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

        public boolean addSearchProfile(RubinoProfileObject rubinoProfileObject, boolean z) {
            if (this.profilesMapSearch.get(rubinoProfileObject.id) != null) {
                return false;
            }
            if (z) {
                this.profilesSearch.add(0, rubinoProfileObject);
            } else {
                this.profilesSearch.add(rubinoProfileObject);
            }
            this.profilesMapSearch.put(rubinoProfileObject.id, rubinoProfileObject);
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
            this.pageData[i].max_id = null;
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
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        boolean z = false;
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        ((FrameLayout.LayoutParams) this.actionBar.backButtonImageView.getLayoutParams()).gravity = 53;
        ActionBar actionBar = this.actionBar;
        CharSequence charSequence = this.profileObject.usernameSpannableString;
        if (charSequence == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        actionBar.setTitle(charSequence);
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceMedium());
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        int i = 1;
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i2) {
                if (i2 == -1) {
                    RubinoFollowerFollowingActivity.this.finishFragment();
                }
            }
        });
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = new ScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = scrollSlidingTextTabStrip;
        scrollSlidingTextTabStrip.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.actionBar.addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.2
            @Override // ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i2, boolean z2) {
                if (RubinoFollowerFollowingActivity.this.pages[0].selectedType == i2) {
                    return;
                }
                RubinoFollowerFollowingActivity.this.selectedTabId = i2;
                RubinoFollowerFollowingActivity rubinoFollowerFollowingActivity = RubinoFollowerFollowingActivity.this;
                ((BaseFragment) rubinoFollowerFollowingActivity).swipeBackEnabled = i2 == rubinoFollowerFollowingActivity.scrollSlidingTextTabStrip.getFirstTabId();
                RubinoFollowerFollowingActivity.this.pages[1].selectedType = i2;
                RubinoFollowerFollowingActivity.this.pages[1].setVisibility(0);
                RubinoFollowerFollowingActivity.this.switchToCurrentSelectedMode(true);
                RubinoFollowerFollowingActivity.this.animatingForward = z2;
            }

            @Override // ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float f) {
                if (f != 1.0f || RubinoFollowerFollowingActivity.this.pages[1].getVisibility() == 0) {
                    if (RubinoFollowerFollowingActivity.this.animatingForward) {
                        RubinoFollowerFollowingActivity.this.pages[0].setTranslationX((-f) * RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth());
                        RubinoFollowerFollowingActivity.this.pages[1].setTranslationX(RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth() - (RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth() * f));
                    } else {
                        RubinoFollowerFollowingActivity.this.pages[0].setTranslationX(RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth() * f);
                        RubinoFollowerFollowingActivity.this.pages[1].setTranslationX((RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth() * f) - RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth());
                    }
                    if (RubinoFollowerFollowingActivity.this.searchItemState != 1) {
                        int unused = RubinoFollowerFollowingActivity.this.searchItemState;
                    }
                    if (f == 1.0f) {
                        MediaPage mediaPage = RubinoFollowerFollowingActivity.this.pages[0];
                        RubinoFollowerFollowingActivity.this.pages[0] = RubinoFollowerFollowingActivity.this.pages[1];
                        RubinoFollowerFollowingActivity.this.pages[1] = mediaPage;
                        RubinoFollowerFollowingActivity.this.pages[1].setVisibility(4);
                        int unused2 = RubinoFollowerFollowingActivity.this.searchItemState;
                        RubinoFollowerFollowingActivity.this.searchItemState = 0;
                    }
                }
            }
        });
        for (int i2 = 1; i2 >= 0; i2--) {
            this.selectedFiles[i2].clear();
        }
        this.searchItemState = 0;
        this.adapterFollower = new ListAdapter(context, type_follower);
        this.adapterFollowing = new ListAdapter(context, type_following);
        this.adapterSearchFollower = new ListAdapter(context, type_follower);
        this.adapterSearchFollowing = new ListAdapter(context, type_following);
        CustomFrameLayout customFrameLayout = new CustomFrameLayout(context);
        this.customFrameLayout = customFrameLayout;
        this.fragmentView = customFrameLayout;
        int i3 = 0;
        int iFindFirstVisibleItemPosition = -1;
        int top = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.pages;
            if (i3 >= mediaPageArr.length) {
                break;
            }
            if (i3 == 0 && mediaPageArr[i3] != null && mediaPageArr[i3].layoutManager != null) {
                iFindFirstVisibleItemPosition = this.pages[i3].layoutManager.findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition == this.pages[i3].layoutManager.getItemCount() - 1 || (viewHolderFindViewHolderForAdapterPosition = this.pages[i3].listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) == null) {
                    iFindFirstVisibleItemPosition = -1;
                } else {
                    top = viewHolderFindViewHolderForAdapterPosition.itemView.getTop();
                }
            }
            MediaPage mediaPage = new MediaPage(context) { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.3
                @Override // android.view.View
                public void setTranslationX(float f) {
                    super.setTranslationX(f);
                    if (RubinoFollowerFollowingActivity.this.tabsAnimationInProgress && RubinoFollowerFollowingActivity.this.pages[0] == this) {
                        RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.selectTabWithId(RubinoFollowerFollowingActivity.this.pages[1].selectedType, Math.abs(RubinoFollowerFollowingActivity.this.pages[0].getTranslationX()) / RubinoFollowerFollowingActivity.this.pages[0].getMeasuredWidth());
                        if (RubinoFollowerFollowingActivity.this.searchItemState == 2) {
                            return;
                        }
                        int unused = RubinoFollowerFollowingActivity.this.searchItemState;
                    }
                }
            };
            this.customFrameLayout.addView(mediaPage, LayoutHelper.createFrame(-1, -1.0f));
            MediaPage[] mediaPageArr2 = this.pages;
            mediaPageArr2[i3] = mediaPage;
            LinearLayoutManager linearLayoutManager = mediaPageArr2[i3].layoutManager = new LinearLayoutManager(this, context, i, z) { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.4
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean supportsPredictiveItemAnimations() {
                    return false;
                }
            };
            this.pages[i3].listView = new RecyclerListViewEdited(context);
            linearLayoutManager.setItemPrefetchEnabled(false);
            this.pages[i3].listView.setVerticalScrollBarEnabled(false);
            this.pages[i3].listView.setItemAnimator(null);
            this.pages[i3].listView.setLayoutAnimation(null);
            this.pages[i3].listView.setClipToPadding(false);
            this.pages[i3].listView.setClipChildren(false);
            this.pages[i3].listView.setSectionsType(2);
            this.pages[i3].listView.setLayoutManager(linearLayoutManager);
            MediaPage[] mediaPageArr3 = this.pages;
            mediaPageArr3[i3].addView(mediaPageArr3[i3].listView, LayoutHelper.createFrame(-1, -1.0f));
            if (i3 == 0 && iFindFirstVisibleItemPosition != -1) {
                linearLayoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
            }
            RubinoEmptyView rubinoEmptyView = new RubinoEmptyView(context, 17);
            this.pages[i3].emptyView = rubinoEmptyView;
            rubinoEmptyView.setData(R.drawable.rubino_empty_state_follow, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            this.pages[i3].progressView = new LinearLayout(context);
            this.pages[i3].progressView.setGravity(17);
            this.pages[i3].progressView.setOrientation(1);
            this.pages[i3].progressView.setVisibility(8);
            this.pages[i3].progressView.setBackgroundColor(context.getResources().getColor(R.color.grey_100));
            MediaPage[] mediaPageArr4 = this.pages;
            mediaPageArr4[i3].addView(mediaPageArr4[i3].progressView, LayoutHelper.createFrame(-1, -1.0f));
            this.pages[i3].progressBar = new RadialProgressView(context);
            this.pages[i3].progressBar.setProgressColor(-14606047);
            this.pages[i3].progressView.addView(this.pages[i3].progressBar, LayoutHelper.createLinear(-2, -2));
            if (i3 != 0) {
                this.pages[i3].setVisibility(4);
            }
            i3++;
        }
        for (int i4 = 0; i4 < 6; i4++) {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapterFollower;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        ListAdapter listAdapter2 = this.adapterFollowing;
        if (listAdapter2 != null) {
            listAdapter2.notifyDataSetChanged();
        }
        ListAdapter listAdapter3 = this.adapterSearchFollower;
        if (listAdapter3 != null) {
            listAdapter3.notifyDataSetChanged();
        }
        ListAdapter listAdapter4 = this.adapterSearchFollowing;
        if (listAdapter4 != null) {
            listAdapter4.notifyDataSetChanged();
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
                this.pages[i].listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.5
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        RubinoFollowerFollowingActivity.this.pages[i].getViewTreeObserver().removeOnPreDrawListener(this);
                        RubinoFollowerFollowingActivity.this.fixLayoutInternal(i);
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
        String str;
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
            int[] iArr2 = this.hasMedia;
            int i = iArr2[0];
            String str2 = BuildConfig.FLAVOR;
            if ((i != 0 || iArr2[1] == 0) && !this.scrollSlidingTextTabStrip.hasTab(type_follower)) {
                ScrollSlidingTextTabStrip scrollSlidingTextTabStrip2 = this.scrollSlidingTextTabStrip;
                int i2 = type_follower;
                StringBuilder sb = new StringBuilder();
                if (this.profileObject.followerCountString != null) {
                    str = this.profileObject.followerCountString + " ";
                } else {
                    str = BuildConfig.FLAVOR;
                }
                sb.append(str);
                sb.append(LocaleController.getString(R.string.rubinoFollowersEnglish));
                scrollSlidingTextTabStrip2.addTextTab(i2, sb.toString(), 14, Theme.getRubinoTypeFaceBold());
            }
            if (this.hasMedia[1] != 0 && !this.scrollSlidingTextTabStrip.hasTab(type_following)) {
                ScrollSlidingTextTabStrip scrollSlidingTextTabStrip3 = this.scrollSlidingTextTabStrip;
                int i3 = type_following;
                StringBuilder sb2 = new StringBuilder();
                if (this.profileObject.followingCountString != null) {
                    str2 = this.profileObject.followingCountString + " ";
                }
                sb2.append(str2);
                sb2.append(LocaleController.getString(R.string.rubinoFollowingsEnglish));
                scrollSlidingTextTabStrip3.addTextTab(i3, sb2.toString(), 14, Theme.getRubinoTypeFaceBold());
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
        ListAdapter listAdapter2;
        ListAdapter listAdapter3;
        int i = 0;
        while (true) {
            mediaPageArr = this.pages;
            if (i >= mediaPageArr.length) {
                break;
            }
            mediaPageArr[i].listView.stopScroll();
            i++;
        }
        RecyclerListViewEdited.SelectionAdapter selectionAdapter = (RecyclerListViewEdited.SelectionAdapter) mediaPageArr[z ? 1 : 0].listView.getAdapter();
        if (!z) {
            if (this.pages[z ? 1 : 0].listView != null) {
                if (this.pageData[this.pages[z ? 1 : 0].selectedType].searching) {
                    if (this.pages[z ? 1 : 0].selectedType != type_follower) {
                        if (this.pages[z ? 1 : 0].selectedType == type_following && (listAdapter = this.adapterSearchFollowing) != null && selectionAdapter != listAdapter) {
                            this.pages[z ? 1 : 0].listView.setAdapter(this.adapterSearchFollowing);
                        }
                    } else {
                        ListAdapter listAdapter4 = this.adapterSearchFollower;
                        if (listAdapter4 != null && selectionAdapter != listAdapter4) {
                            this.pages[z ? 1 : 0].listView.setAdapter(this.adapterSearchFollower);
                        }
                    }
                } else if (this.pages[z ? 1 : 0].selectedType != type_follower) {
                    if (this.pages[z ? 1 : 0].selectedType == type_following && selectionAdapter != this.adapterFollowing) {
                        this.pages[z ? 1 : 0].listView.setAdapter(this.adapterFollowing);
                    }
                } else if (selectionAdapter != this.adapterFollower) {
                    this.pages[z ? 1 : 0].listView.setAdapter(this.adapterFollower);
                }
                this.pageData[this.pages[z ? 1 : 0].selectedType].updateRows(this.pages[z ? 1 : 0].selectedType, true);
            }
        } else {
            if (this.pageData[this.pages[z ? 1 : 0].selectedType].searching) {
                if (this.pages[z ? 1 : 0].selectedType != type_follower) {
                    if (this.pages[z ? 1 : 0].selectedType == type_following && (listAdapter3 = this.adapterSearchFollowing) != null && selectionAdapter != listAdapter3) {
                        this.pages[z ? 1 : 0].listView.setAdapter(this.adapterSearchFollowing);
                    }
                } else {
                    ListAdapter listAdapter5 = this.adapterSearchFollower;
                    if (listAdapter5 != null && selectionAdapter != listAdapter5) {
                        this.pages[z ? 1 : 0].listView.setAdapter(this.adapterSearchFollower);
                    }
                }
            } else if (this.pages[z ? 1 : 0].selectedType != type_follower) {
                if (this.pages[z ? 1 : 0].selectedType == type_following && (listAdapter2 = this.adapterFollowing) != null && selectionAdapter != listAdapter2) {
                    this.pages[z ? 1 : 0].listView.setAdapter(this.adapterFollowing);
                }
            } else {
                ListAdapter listAdapter6 = this.adapterFollower;
                if (listAdapter6 != null && selectionAdapter != listAdapter6) {
                    this.pages[z ? 1 : 0].listView.setAdapter(this.adapterFollower);
                }
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

    void loadData(final int i, final boolean z, final boolean z2, String str) {
        Observable<Rubino.ProfileListObject> followerFollowingObservable;
        if (this.pageData[i].requestObservable != null && !this.pageData[i].requestObservable.isDisposed()) {
            this.pageData[i].requestObservable.dispose();
        }
        if (z2) {
            this.pageData[i].loadingSearch = true;
        } else {
            this.pageData[i].loading = true;
        }
        if (z2) {
            followerFollowingObservable = getRubinoController().getSearchFollowerProfilesObservable(this.profileObject.id, str, i == type_follower ? Rubino.FollowingTypeEnum.Follower : Rubino.FollowingTypeEnum.Following, z ? null : this.pageData[i].max_id, 50);
        } else {
            followerFollowingObservable = getRubinoController().getFollowerFollowingObservable(this.profileObject.id, i == type_follower, z ? null : this.pageData[i].max_id, 50);
        }
        if (followerFollowingObservable != null) {
            if (this.pageData[i].requestObservable == null || this.pageData[i].requestObservable.isDisposed()) {
                this.pageData[i].requestObservable = (DisposableObserver) followerFollowingObservable.observeOn(Schedulers.io()).doOnNext(new Consumer<Rubino.ProfileListObject>() { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.7
                    @Override // io.reactivex.functions.Consumer
                    public void accept(Rubino.ProfileListObject profileListObject) throws Exception {
                        if (profileListObject != null) {
                            if (z2) {
                                RubinoFollowerFollowingActivity.this.pageData[i].loadingSearch = false;
                            } else {
                                RubinoFollowerFollowingActivity.this.pageData[i].loading = false;
                            }
                            int size = profileListObject.profiles.size();
                            if (z) {
                                if (z2) {
                                    RubinoFollowerFollowingActivity.this.pageData[i].profilesSearch.clear();
                                    RubinoFollowerFollowingActivity.this.pageData[i].profilesMapSearch.clear();
                                } else {
                                    RubinoFollowerFollowingActivity.this.pageData[i].profiles.clear();
                                    RubinoFollowerFollowingActivity.this.pageData[i].profilesMap.clear();
                                }
                            }
                            if (size > 0) {
                                Iterator<RubinoProfileObject> it = profileListObject.profiles.iterator();
                                while (it.hasNext()) {
                                    RubinoProfileObject next = it.next();
                                    if (z2) {
                                        RubinoFollowerFollowingActivity.this.pageData[i].addSearchProfile(next, false);
                                    } else {
                                        RubinoFollowerFollowingActivity.this.pageData[i].addProfile(next, false);
                                    }
                                }
                                if (z2) {
                                    RubinoFollowerFollowingActivity.this.pageData[i].max_id_search = profileListObject.profiles.get(size - 1).id;
                                } else {
                                    RubinoFollowerFollowingActivity.this.pageData[i].max_id = profileListObject.profiles.get(size - 1).id;
                                }
                            } else if (!z2) {
                                RubinoFollowerFollowingActivity.this.pageData[i].endReached = true;
                            }
                            if (z2) {
                                RubinoFollowerFollowingActivity.this.pageData[i].endReachedSearch = true;
                            }
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.ProfileListObject>() { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.6
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Rubino.ProfileListObject profileListObject) {
                        dispose();
                        if (profileListObject != null) {
                            for (int i2 = 0; i2 < RubinoFollowerFollowingActivity.this.pages.length; i2++) {
                                if (RubinoFollowerFollowingActivity.this.pages[i2].selectedType == i) {
                                    if ((z2 && !RubinoFollowerFollowingActivity.this.pageData[i].loadingSearch) || (!z2 && !RubinoFollowerFollowingActivity.this.pageData[i].loading)) {
                                        if (RubinoFollowerFollowingActivity.this.pages[i2].progressView != null) {
                                            RubinoFollowerFollowingActivity.this.pages[i2].progressView.setVisibility(8);
                                        }
                                        if (RubinoFollowerFollowingActivity.this.pages[i2].selectedType == i && RubinoFollowerFollowingActivity.this.pages[i2].listView != null && RubinoFollowerFollowingActivity.this.pages[i2].listView.getEmptyView() == null) {
                                            RubinoFollowerFollowingActivity.this.pages[i2].listView.setEmptyView(RubinoFollowerFollowingActivity.this.pages[i2].emptyView);
                                        }
                                    }
                                    if (z) {
                                        PageData[] pageDataArr = RubinoFollowerFollowingActivity.this.pageData;
                                        int i3 = i;
                                        pageDataArr[i3].updateRows(i3, true);
                                    } else {
                                        PageData[] pageDataArr2 = RubinoFollowerFollowingActivity.this.pageData;
                                        int i4 = i;
                                        pageDataArr2[i4].updateRowsOnLoadData(i4, true);
                                    }
                                }
                            }
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        dispose();
                        if (!RubinoFollowerFollowingActivity.this.pageData[i].searching) {
                            if (RubinoFollowerFollowingActivity.this.pageData[i].profiles.size() == 0) {
                                RubinoFollowerFollowingActivity.this.pageData[i].needToRetry = true;
                                PageData[] pageDataArr = RubinoFollowerFollowingActivity.this.pageData;
                                int i2 = i;
                                pageDataArr[i2].updateRows(i2, true);
                                return;
                            }
                            return;
                        }
                        if (th instanceof ApiServerException) {
                            RubinoFollowerFollowingActivity.this.pageData[i].endReachedSearch = true;
                            PageData[] pageDataArr2 = RubinoFollowerFollowingActivity.this.pageData;
                            int i3 = i;
                            pageDataArr2[i3].updateRows(i3, true);
                        }
                    }
                });
                this.compositeDisposable.add(this.pageData[i].requestObservable);
            }
        }
    }

    class ListAdapter extends RecyclerListViewEdited.SelectionAdapter {
        private int currentType;
        Context mContext;

        public ListAdapter(Context context, int i) {
            this.mContext = context;
            this.currentType = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoFollowerFollowingActivity.this.pageData[this.currentType].rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            View rubinoLoadingCell;
            if (i == 0) {
                View profileOrHashtagCell = new ProfileOrHashtagCell(this.mContext, true, false);
                profileOrHashtagCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                view = profileOrHashtagCell;
            } else if (i == 4) {
                View rubinoEmptyView = new RubinoEmptyView(this.mContext, 17);
                rubinoEmptyView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                view = rubinoEmptyView;
            } else if (i == 5) {
                RubinoRetryView rubinoRetryView = new RubinoRetryView(this.mContext);
                rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
                rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.ListAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        RubinoFollowerFollowingActivity.this.pageData[ListAdapter.this.currentType].needToRetry = false;
                        RubinoFollowerFollowingActivity.this.pageData[ListAdapter.this.currentType].updateRows(ListAdapter.this.currentType, true);
                    }
                });
                rubinoRetryView.setBackgroundColor(-1);
                rubinoRetryView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(80.0f)));
                ((LinearLayout.LayoutParams) rubinoRetryView.imageView.getLayoutParams()).topMargin = AndroidUtilities.dp(4.0f);
                view = rubinoRetryView;
            } else {
                if (i == 6) {
                    if (RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searchView == null) {
                        RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searchView = new RubinoSearchView(this.mContext, RubinoFollowerFollowingActivity.this.compositeDisposable, RubinoSearchView.type_in_profile_list, new RubinoSearchView.SearchListener() { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.ListAdapter.2
                            @Override // ir.resaneh1.iptv.fragment.rubino.RubinoSearchView.SearchListener
                            public void search(String str) {
                                if (!str.isEmpty()) {
                                    if (RubinoFollowerFollowingActivity.this.adapterFollower == null) {
                                        return;
                                    }
                                    RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searching = true;
                                    RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searchingText = str;
                                    RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].endReachedSearch = false;
                                    RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].max_id_search = null;
                                    RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].profilesMapSearch.clear();
                                    RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].profilesSearch.clear();
                                    RubinoFollowerFollowingActivity rubinoFollowerFollowingActivity = RubinoFollowerFollowingActivity.this;
                                    rubinoFollowerFollowingActivity.loadData(rubinoFollowerFollowingActivity.pages[0].selectedType, true, true, str);
                                    RubinoFollowerFollowingActivity.this.switchToCurrentSelectedMode(false);
                                    return;
                                }
                                RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searching = false;
                                if (RubinoFollowerFollowingActivity.this.pages[0].selectedType == RubinoFollowerFollowingActivity.type_follower) {
                                    if (RubinoFollowerFollowingActivity.this.adapterFollower == null) {
                                        return;
                                    }
                                } else if (RubinoFollowerFollowingActivity.this.pages[0].selectedType == RubinoFollowerFollowingActivity.type_following && RubinoFollowerFollowingActivity.this.adapterFollowing == null) {
                                    return;
                                }
                                RubinoFollowerFollowingActivity.this.switchToCurrentSelectedMode(false);
                            }
                        });
                        RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searchView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, 1, 16.0f, 0.0f, 16.0f, 0.0f));
                    } else if (RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searchView.getParent() != null) {
                        ((ViewGroup) RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searchView.getParent()).removeView(RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searchView);
                    }
                    rubinoLoadingCell = RubinoFollowerFollowingActivity.this.pageData[RubinoFollowerFollowingActivity.this.pages[0].selectedType].searchView;
                } else {
                    rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
                }
                return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
            }
            rubinoLoadingCell = view;
            return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            MyLog.e("List Status", "onBind: " + viewHolder.getAdapterPosition());
            int itemViewType = viewHolder.getItemViewType();
            String str = BuildConfig.FLAVOR;
            if (itemViewType == 0) {
                ProfileOrHashtagCell profileOrHashtagCell = (ProfileOrHashtagCell) viewHolder.itemView;
                if (i >= RubinoFollowerFollowingActivity.this.pageData[this.currentType].arrayStartRow && i < RubinoFollowerFollowingActivity.this.pageData[this.currentType].arrayEndRow) {
                    ArrayList arrayList = RubinoFollowerFollowingActivity.this.pageData[this.currentType].searching ? RubinoFollowerFollowingActivity.this.pageData[this.currentType].profilesSearch : RubinoFollowerFollowingActivity.this.pageData[this.currentType].profiles;
                    if (i - RubinoFollowerFollowingActivity.this.pageData[this.currentType].arrayStartRow < arrayList.size() && i - RubinoFollowerFollowingActivity.this.pageData[this.currentType].arrayStartRow >= 0) {
                        RubinoProfileObject rubinoProfileObject = (RubinoProfileObject) arrayList.get(i - RubinoFollowerFollowingActivity.this.pageData[this.currentType].arrayStartRow);
                        RubinoProfileObject rubinoProfileObject2 = RubinoFollowerFollowingActivity.this.getRubinoController().profileMap.get(rubinoProfileObject.id);
                        if (rubinoProfileObject2 != null) {
                            profileOrHashtagCell.setProfile(rubinoProfileObject2, ((BaseFragment) RubinoFollowerFollowingActivity.this).classGuid);
                        } else {
                            profileOrHashtagCell.setProfile(rubinoProfileObject, ((BaseFragment) RubinoFollowerFollowingActivity.this).classGuid);
                        }
                    }
                }
            } else if (itemViewType == 4) {
                RubinoEmptyView rubinoEmptyView = (RubinoEmptyView) viewHolder.itemView;
                if (RubinoFollowerFollowingActivity.this.profileObject.isMyCurrentProfile()) {
                    if (RubinoFollowerFollowingActivity.this.selectedTabId != RubinoFollowerFollowingActivity.type_follower) {
                        if (RubinoFollowerFollowingActivity.this.selectedTabId == RubinoFollowerFollowingActivity.type_following) {
                            rubinoEmptyView.setData(R.drawable.rubino_empty_state_follow, LocaleController.getString(R.string.rubinoMyFollowingEmpty), LocaleController.getString(R.string.rubinoMyFollowingEmptyInfo));
                        }
                    } else {
                        rubinoEmptyView.setData(R.drawable.rubino_empty_state_follow, LocaleController.getString(R.string.rubinoMyFollowerEmpty), LocaleController.getString(R.string.rubinoMyFollowerEmptyInfo));
                    }
                } else if (RubinoFollowerFollowingActivity.this.selectedTabId != RubinoFollowerFollowingActivity.type_follower) {
                    if (RubinoFollowerFollowingActivity.this.selectedTabId == RubinoFollowerFollowingActivity.type_following) {
                        rubinoEmptyView.setData(R.drawable.rubino_empty_state_follow, LocaleController.getString(R.string.rubinoFollowingEmpty), BuildConfig.FLAVOR);
                    }
                } else {
                    rubinoEmptyView.setData(R.drawable.rubino_empty_state_follow, LocaleController.getString(R.string.rubinoFollowerEmpty), BuildConfig.FLAVOR);
                }
            }
            if ((!RubinoFollowerFollowingActivity.this.pageData[this.currentType].searching || RubinoFollowerFollowingActivity.this.pageData[this.currentType].endReachedSearch) && (RubinoFollowerFollowingActivity.this.pageData[this.currentType].searching || RubinoFollowerFollowingActivity.this.pageData[this.currentType].endReached)) {
                return;
            }
            if (i == RubinoFollowerFollowingActivity.this.pageData[this.currentType].loadMorePosition || i == RubinoFollowerFollowingActivity.this.pageData[this.currentType].loadingRow) {
                RubinoFollowerFollowingActivity rubinoFollowerFollowingActivity = RubinoFollowerFollowingActivity.this;
                int i2 = this.currentType;
                boolean z = rubinoFollowerFollowingActivity.pageData[this.currentType].searching;
                if (RubinoFollowerFollowingActivity.this.pageData[this.currentType].searching) {
                    str = RubinoFollowerFollowingActivity.this.pageData[this.currentType].searchingText;
                }
                rubinoFollowerFollowingActivity.loadData(i2, false, z, str);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= RubinoFollowerFollowingActivity.this.pageData[this.currentType].arrayStartRow && i < RubinoFollowerFollowingActivity.this.pageData[this.currentType].arrayEndRow) {
                return 0;
            }
            if (i == RubinoFollowerFollowingActivity.this.pageData[this.currentType].loadingRow) {
                return 1;
            }
            if (i == RubinoFollowerFollowingActivity.this.pageData[this.currentType].emptyViewRow) {
                return 4;
            }
            if (i == RubinoFollowerFollowingActivity.this.pageData[this.currentType].retryRow) {
                return 5;
            }
            return i == RubinoFollowerFollowingActivity.this.pageData[this.currentType].searchRow ? 6 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            for (int i = 0; i < RubinoFollowerFollowingActivity.this.pages.length; i++) {
                if (RubinoFollowerFollowingActivity.this.pages[i].selectedType == this.currentType) {
                    RubinoFollowerFollowingActivity.this.pages[i].listView.setEmptyView(RubinoFollowerFollowingActivity.this.pages[i].emptyView);
                    RubinoFollowerFollowingActivity.this.pages[i].progressView.setVisibility(8);
                }
            }
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
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
            int nextPageId = RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.getNextPageId(z);
            if (nextPageId < 0) {
                return false;
            }
            if (RubinoFollowerFollowingActivity.this.searchItemState != 0) {
                if (RubinoFollowerFollowingActivity.this.searchItemState != 2) {
                    int unused = RubinoFollowerFollowingActivity.this.searchItemState;
                }
                RubinoFollowerFollowingActivity.this.searchItemState = 0;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            this.maybeStartTracking = false;
            this.startedTracking = true;
            this.startedTrackingX = (int) motionEvent.getX();
            ((BaseFragment) RubinoFollowerFollowingActivity.this).actionBar.setEnabled(false);
            RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.setEnabled(false);
            RubinoFollowerFollowingActivity.this.selectedTabId = nextPageId;
            RubinoFollowerFollowingActivity.this.pages[1].selectedType = nextPageId;
            RubinoFollowerFollowingActivity.this.pages[1].setVisibility(0);
            RubinoFollowerFollowingActivity.this.animatingForward = z;
            RubinoFollowerFollowingActivity.this.switchToCurrentSelectedMode(true);
            if (z) {
                RubinoFollowerFollowingActivity.this.pages[1].setTranslationX(RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth());
            } else {
                RubinoFollowerFollowingActivity.this.pages[1].setTranslationX(-RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth());
            }
            return true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return RubinoFollowerFollowingActivity.this.tabsAnimationInProgress || RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (((BaseFragment) RubinoFollowerFollowingActivity.this).parentLayout.checkTransitionAnimation() || RubinoFollowerFollowingActivity.this.tabsAnimationInProgress) {
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
                if (this.startedTracking && ((RubinoFollowerFollowingActivity.this.animatingForward && x > 0) || (!RubinoFollowerFollowingActivity.this.animatingForward && x < 0))) {
                    if (!prepareForMoving(motionEvent, x < 0)) {
                        this.maybeStartTracking = true;
                        this.startedTracking = false;
                    }
                }
                if (!this.maybeStartTracking || this.startedTracking) {
                    if (this.startedTracking) {
                        if (RubinoFollowerFollowingActivity.this.animatingForward) {
                            RubinoFollowerFollowingActivity.this.pages[0].setTranslationX(x);
                            RubinoFollowerFollowingActivity.this.pages[1].setTranslationX(RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth() + x);
                        } else {
                            RubinoFollowerFollowingActivity.this.pages[0].setTranslationX(x);
                            RubinoFollowerFollowingActivity.this.pages[1].setTranslationX(x - RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth());
                        }
                        float fAbs = Math.abs(x) / RubinoFollowerFollowingActivity.this.pages[0].getMeasuredWidth();
                        if (RubinoFollowerFollowingActivity.this.searchItemState != 2) {
                            int unused = RubinoFollowerFollowingActivity.this.searchItemState;
                        }
                        RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.selectTabWithId(RubinoFollowerFollowingActivity.this.pages[1].selectedType, fAbs);
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
                    float x2 = RubinoFollowerFollowingActivity.this.pages[0].getX();
                    AnimatorSet animatorSet = new AnimatorSet();
                    float xVelocity2 = this.velocityTracker.getXVelocity();
                    final boolean z = Math.abs(x2) < ((float) RubinoFollowerFollowingActivity.this.pages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity2) < 3500.0f || Math.abs(xVelocity2) < Math.abs(this.velocityTracker.getYVelocity()));
                    if (z) {
                        if (RubinoFollowerFollowingActivity.this.animatingForward) {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(RubinoFollowerFollowingActivity.this.pages[0], "translationX", 0.0f), ObjectAnimator.ofFloat(RubinoFollowerFollowingActivity.this.pages[1], "translationX", RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth()));
                        } else {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(RubinoFollowerFollowingActivity.this.pages[0], "translationX", 0.0f), ObjectAnimator.ofFloat(RubinoFollowerFollowingActivity.this.pages[1], "translationX", -RubinoFollowerFollowingActivity.this.pages[1].getMeasuredWidth()));
                        }
                    } else if (RubinoFollowerFollowingActivity.this.animatingForward) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(RubinoFollowerFollowingActivity.this.pages[0], "translationX", -RubinoFollowerFollowingActivity.this.pages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(RubinoFollowerFollowingActivity.this.pages[1], "translationX", 0.0f));
                    } else {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(RubinoFollowerFollowingActivity.this.pages[0], "translationX", RubinoFollowerFollowingActivity.this.pages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(RubinoFollowerFollowingActivity.this.pages[1], "translationX", 0.0f));
                    }
                    animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                    animatorSet.setDuration(200L);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity.CustomFrameLayout.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (z) {
                                RubinoFollowerFollowingActivity.this.pages[1].setVisibility(4);
                                if (RubinoFollowerFollowingActivity.this.searchItemState != 2) {
                                    int unused2 = RubinoFollowerFollowingActivity.this.searchItemState;
                                }
                                RubinoFollowerFollowingActivity.this.searchItemState = 0;
                            } else {
                                MediaPage mediaPage = RubinoFollowerFollowingActivity.this.pages[0];
                                RubinoFollowerFollowingActivity.this.pages[0] = RubinoFollowerFollowingActivity.this.pages[1];
                                RubinoFollowerFollowingActivity.this.pages[1] = mediaPage;
                                RubinoFollowerFollowingActivity.this.pages[1].setVisibility(4);
                                int unused3 = RubinoFollowerFollowingActivity.this.searchItemState;
                                RubinoFollowerFollowingActivity.this.searchItemState = 0;
                                RubinoFollowerFollowingActivity rubinoFollowerFollowingActivity = RubinoFollowerFollowingActivity.this;
                                ((BaseFragment) rubinoFollowerFollowingActivity).swipeBackEnabled = rubinoFollowerFollowingActivity.pages[0].selectedType == RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.getFirstTabId();
                                RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.selectTabWithId(RubinoFollowerFollowingActivity.this.pages[0].selectedType, 1.0f);
                            }
                            RubinoFollowerFollowingActivity.this.tabsAnimationInProgress = false;
                            CustomFrameLayout.this.maybeStartTracking = false;
                            CustomFrameLayout.this.startedTracking = false;
                            ((BaseFragment) RubinoFollowerFollowingActivity.this).actionBar.setEnabled(true);
                            RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                        }
                    });
                    animatorSet.start();
                    RubinoFollowerFollowingActivity.this.tabsAnimationInProgress = true;
                } else {
                    this.maybeStartTracking = false;
                    this.startedTracking = false;
                    ((BaseFragment) RubinoFollowerFollowingActivity.this).actionBar.setEnabled(true);
                    RubinoFollowerFollowingActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                }
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.velocityTracker = null;
                }
            }
            return this.startedTracking;
        }
    }
}
