package ir.resaneh1.iptv.fragment.rubino;

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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.SharedPhotoVideoCell;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgressView;

/* loaded from: classes3.dex */
public class RubinoSearchActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private static int type_hashtag = 1;
    private static int type_profile;
    private boolean animatingForward;
    private int columnsCount;
    private CustomFrameLayout customframeLayout;
    private int[] hasMedia;
    private PageData[] pageData;
    private ScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private boolean scrolling;
    private SearchAdapter searchAdapterHashtag;
    private SearchAdapter searchAdapterProfile;
    private ActionBarMenuItem searchItem;
    private int searchItemState;
    private boolean searchWas;
    private boolean searching;
    private Map<Long, MessageObject>[] selectedFiles;
    private int selectedId;
    private boolean tabsAnimationInProgress;
    private MediaPage[] pages = new MediaPage[2];
    private ArrayList<SharedPhotoVideoCell> cellCache = new ArrayList<>(6);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$1(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        return this.selectedId == type_profile;
    }

    private class MediaPage extends FrameLayout {
        private ImageView emptyImageView;
        private TextView emptyTextView;
        private LinearLayout emptyView;
        private LinearLayoutManager layoutManager;
        private RecyclerListView listView;
        private RadialProgressView progressBar;
        private LinearLayout progressView;
        private int selectedType;

        public MediaPage(RubinoSearchActivity rubinoSearchActivity, Context context) {
            super(context);
        }
    }

    public RubinoSearchActivity() {
        new ArrayList(6);
        this.selectedFiles = new HashMap[]{new HashMap(), new HashMap()};
        this.columnsCount = 2;
        this.pageData = new PageData[2];
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoSearchActivity";
        this.isSmallActionBar = true;
        this.needLockOrientation = true;
        this.hasMedia = new int[]{1, 1};
    }

    private class PageData {
        private int arrayEndRow;
        private int arrayStartRow;
        private int emptyViewRow;
        private boolean endReached;
        private ArrayList<Rubino.HashtagObject> hashtags;
        private HashMap<String, Rubino.HashtagObject> hashtagsMap;
        private boolean loading;
        private int loadingRow;
        private String max_id;
        public boolean needToRetry;
        private ArrayList<RubinoProfileObject> profiles;
        private HashMap<String, RubinoProfileObject> profilesMap;
        private DisposableObserver requestObservable;
        private int retryRow;
        private int rowCount;
        private int type;

        private PageData(RubinoSearchActivity rubinoSearchActivity) {
            this.profiles = new ArrayList<>();
            this.hashtags = new ArrayList<>();
            this.profilesMap = new HashMap<>();
            this.hashtagsMap = new HashMap<>();
            this.max_id = null;
        }

        void updateRows() {
            this.arrayStartRow = -1;
            this.emptyViewRow = -1;
            this.arrayEndRow = -1;
            this.loadingRow = -1;
            this.retryRow = -1;
            int size = 0;
            this.rowCount = 0;
            if (!this.needToRetry) {
                if (this.type != RubinoSearchActivity.type_profile) {
                    if (this.type == RubinoSearchActivity.type_hashtag) {
                        size = this.hashtags.size();
                    }
                } else {
                    size = this.profiles.size();
                }
                if (size > 0) {
                    int i = this.rowCount;
                    this.arrayStartRow = i;
                    int i2 = i + size;
                    this.rowCount = i2;
                    this.arrayEndRow = i2;
                }
                if (this.loading) {
                    int i3 = this.rowCount;
                    this.rowCount = i3 + 1;
                    this.loadingRow = i3;
                    return;
                } else {
                    if (size == 0) {
                        int i4 = this.rowCount;
                        this.rowCount = i4 + 1;
                        this.emptyViewRow = i4;
                        return;
                    }
                    return;
                }
            }
            this.rowCount = 0 + 1;
            this.retryRow = 0;
        }

        public boolean addProfile(RubinoProfileObject rubinoProfileObject, boolean z) {
            this.type = RubinoSearchActivity.type_profile;
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

        public boolean addHashtag(Rubino.HashtagObject hashtagObject, boolean z) {
            this.type = RubinoSearchActivity.type_hashtag;
            if (this.hashtagsMap.get(hashtagObject.id) != null) {
                return false;
            }
            if (z) {
                this.hashtags.add(0, hashtagObject);
            } else {
                this.hashtags.add(hashtagObject);
            }
            this.hashtagsMap.put(hashtagObject.id, hashtagObject);
            return true;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
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
    public View createView(Context context) {
        RecyclerListView.Holder holder;
        this.searching = true;
        this.searchWas = true;
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.backButtonImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0(view);
            }
        });
        this.actionBar.setTitle(LocaleController.getString("rubinoSearch", R.string.rubinoSearch));
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    RubinoSearchActivity.this.finishFragment();
                }
            }
        });
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = new ScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = scrollSlidingTextTabStrip;
        scrollSlidingTextTabStrip.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.actionBar.addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.2
            @Override // ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int i, boolean z) {
                if (RubinoSearchActivity.this.pages[0].selectedType == i) {
                    return;
                }
                RubinoSearchActivity.this.selectedId = i;
                RubinoSearchActivity rubinoSearchActivity = RubinoSearchActivity.this;
                ((BaseFragment) rubinoSearchActivity).swipeBackEnabled = i == rubinoSearchActivity.scrollSlidingTextTabStrip.getFirstTabId();
                RubinoSearchActivity.this.pages[1].selectedType = i;
                RubinoSearchActivity.this.pages[1].setVisibility(0);
                RubinoSearchActivity.this.switchToCurrentSelectedMode(true);
                RubinoSearchActivity.this.animatingForward = z;
                RubinoSearchActivity.this.searchItem.setSearchFieldHint(LocaleController.getString(RubinoSearchActivity.this.selectedId == RubinoSearchActivity.type_profile ? R.string.rubinoSearchProfile : R.string.rubinoSearchHashtag));
            }

            @Override // ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float f) {
                if (f != 1.0f || RubinoSearchActivity.this.pages[1].getVisibility() == 0) {
                    if (RubinoSearchActivity.this.animatingForward) {
                        RubinoSearchActivity.this.pages[0].setTranslationX((-f) * RubinoSearchActivity.this.pages[1].getMeasuredWidth());
                        RubinoSearchActivity.this.pages[1].setTranslationX(RubinoSearchActivity.this.pages[1].getMeasuredWidth() - (RubinoSearchActivity.this.pages[1].getMeasuredWidth() * f));
                    } else {
                        RubinoSearchActivity.this.pages[0].setTranslationX(RubinoSearchActivity.this.pages[1].getMeasuredWidth() * f);
                        RubinoSearchActivity.this.pages[1].setTranslationX((RubinoSearchActivity.this.pages[1].getMeasuredWidth() * f) - RubinoSearchActivity.this.pages[1].getMeasuredWidth());
                    }
                    if (f == 1.0f) {
                        MediaPage mediaPage = RubinoSearchActivity.this.pages[0];
                        RubinoSearchActivity.this.pages[0] = RubinoSearchActivity.this.pages[1];
                        RubinoSearchActivity.this.pages[1] = mediaPage;
                        RubinoSearchActivity.this.pages[1].setVisibility(4);
                        int unused = RubinoSearchActivity.this.searchItemState;
                        RubinoSearchActivity.this.searchItemState = 0;
                    }
                }
            }
        });
        for (int i = 1; i >= 0; i--) {
            this.selectedFiles[i].clear();
        }
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(1, R.drawable.ic_ab_search).setIsSearchField(true, true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.3
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                RubinoSearchActivity.this.searching = true;
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                RubinoSearchActivity.this.searching = false;
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                String string = editText.getText().toString();
                if (RubinoSearchActivity.this.pages[0] != null) {
                    if (RubinoSearchActivity.this.pages[0].selectedType == RubinoSearchActivity.type_profile) {
                        if (RubinoSearchActivity.this.searchAdapterProfile == null) {
                            return;
                        } else {
                            RubinoSearchActivity.this.searchAdapterProfile.search(string);
                        }
                    } else if (RubinoSearchActivity.this.pages[0].selectedType == RubinoSearchActivity.type_hashtag) {
                        if (RubinoSearchActivity.this.searchAdapterHashtag == null) {
                            return;
                        } else {
                            RubinoSearchActivity.this.searchAdapterHashtag.search(string);
                        }
                    }
                    RubinoSearchActivity.this.switchToCurrentSelectedMode(false);
                }
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.openSearch(false);
        this.searchItemState = 0;
        this.searchAdapterProfile = new SearchAdapter(context, type_profile);
        this.searchAdapterHashtag = new SearchAdapter(context, type_hashtag);
        CustomFrameLayout customFrameLayout = new CustomFrameLayout(context);
        this.customframeLayout = customFrameLayout;
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
            final MediaPage mediaPage = new MediaPage(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.4
                @Override // android.view.View
                public void setTranslationX(float f) {
                    super.setTranslationX(f);
                    if (RubinoSearchActivity.this.tabsAnimationInProgress && RubinoSearchActivity.this.pages[0] == this) {
                        RubinoSearchActivity.this.scrollSlidingTextTabStrip.selectTabWithId(RubinoSearchActivity.this.pages[1].selectedType, Math.abs(RubinoSearchActivity.this.pages[0].getTranslationX()) / RubinoSearchActivity.this.pages[0].getMeasuredWidth());
                        if (RubinoSearchActivity.this.searchItemState == 2) {
                            return;
                        }
                        int unused = RubinoSearchActivity.this.searchItemState;
                    }
                }
            };
            this.customframeLayout.addView(mediaPage, LayoutHelper.createFrame(-1, -1.0f));
            MediaPage[] mediaPageArr2 = this.pages;
            mediaPageArr2[i2] = mediaPage;
            final LinearLayoutManager linearLayoutManager = mediaPageArr2[i2].layoutManager = new LinearLayoutManager(context, 1, false);
            this.pages[i2].listView = new RecyclerListView(context);
            this.pages[i2].listView.setClipToPadding(false);
            this.pages[i2].listView.setSectionsType(2);
            this.pages[i2].listView.setLayoutManager(linearLayoutManager);
            MediaPage[] mediaPageArr3 = this.pages;
            mediaPageArr3[i2].addView(mediaPageArr3[i2].listView, LayoutHelper.createFrame(-1, -1.0f));
            this.pages[i2].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.5
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                    if (i3 == 1 || i3 == 2) {
                        RubinoSearchActivity.this.resetFlags();
                    }
                    if (i3 == 1 && RubinoSearchActivity.this.searching && RubinoSearchActivity.this.searchWas) {
                        AndroidUtilities.hideKeyboard(RubinoSearchActivity.this.getParentActivity().getCurrentFocus());
                    }
                    RubinoSearchActivity.this.scrolling = i3 != 0;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                    if (RubinoSearchActivity.this.searching && RubinoSearchActivity.this.searchWas) {
                        return;
                    }
                    int iFindFirstVisibleItemPosition2 = linearLayoutManager.findFirstVisibleItemPosition();
                    int iAbs = iFindFirstVisibleItemPosition2 == -1 ? 0 : Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition2) + 1;
                    int itemCount = recyclerView.getAdapter().getItemCount();
                    if (iAbs == 0 || iFindFirstVisibleItemPosition2 + iAbs <= itemCount - 2) {
                        return;
                    }
                    boolean unused = RubinoSearchActivity.this.pageData[mediaPage.selectedType].loading;
                }
            });
            if (i2 == 0 && iFindFirstVisibleItemPosition != -1) {
                linearLayoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
            }
            this.pages[i2].emptyView = new LinearLayout(context);
            this.pages[i2].emptyView.setOrientation(1);
            this.pages[i2].emptyView.setGravity(48);
            this.pages[i2].emptyView.setVisibility(8);
            MediaPage[] mediaPageArr4 = this.pages;
            mediaPageArr4[i2].addView(mediaPageArr4[i2].emptyView, LayoutHelper.createFrame(-1, -1.0f));
            this.pages[i2].emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return RubinoSearchActivity.lambda$createView$1(view, motionEvent);
                }
            });
            this.pages[i2].emptyImageView = new ImageView(context);
            this.pages[i2].emptyView.addView(this.pages[i2].emptyImageView, LayoutHelper.createLinear(-2, -2));
            this.pages[i2].emptyTextView = new TextView(context);
            this.pages[i2].emptyTextView.setTextColor(context.getResources().getColor(R.color.grey_700));
            this.pages[i2].emptyTextView.setGravity(5);
            this.pages[i2].emptyTextView.setTextSize(2, 13.0f);
            this.pages[i2].emptyView.addView(this.pages[i2].emptyTextView, LayoutHelper.createLinear(-2, -2, 53, 0, 24, 16, 0));
            this.pages[i2].progressView = new LinearLayout(context);
            this.pages[i2].progressView.setGravity(17);
            this.pages[i2].progressView.setOrientation(1);
            this.pages[i2].progressView.setVisibility(8);
            this.pages[i2].progressView.setBackgroundColor(context.getResources().getColor(R.color.grey_100));
            MediaPage[] mediaPageArr5 = this.pages;
            mediaPageArr5[i2].addView(mediaPageArr5[i2].progressView, LayoutHelper.createFrame(-1, -1.0f));
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
        int i4 = type_profile;
        this.selectedId = i4;
        this.pageData[i4].loading = false;
        if (this.pages[type_profile].progressView != null) {
            this.pages[type_profile].progressView.setVisibility(4);
        }
        this.pageData[this.selectedId].endReached = true;
        updateTabs();
        this.searchItem.setSearchFieldHint(LocaleController.getString(this.pages[0].selectedType == type_profile ? R.string.rubinoSearchProfile : R.string.rubinoSearchHashtag));
        switchToCurrentSelectedMode(false);
        this.compositeDisposable.add((Disposable) Observable.timer(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.6
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                AndroidUtilities.showKeyboard(RubinoSearchActivity.this.searchItem.getSearchField());
            }
        }));
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        ActionBar.ActionBarMenuOnItemClick actionBarMenuOnItemClick = this.actionBar.actionBarMenuOnItemClick;
        if (actionBarMenuOnItemClick != null) {
            actionBarMenuOnItemClick.onItemClick(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetFlags() {
        this.customframeLayout.resetFlags();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        SearchAdapter searchAdapter = this.searchAdapterProfile;
        if (searchAdapter != null) {
            searchAdapter.notifyDataSetChanged();
        }
        SearchAdapter searchAdapter2 = this.searchAdapterHashtag;
        if (searchAdapter2 != null) {
            searchAdapter2.notifyDataSetChanged();
        }
        for (int i = 0; i < this.pages.length; i++) {
            fixLayoutInternal(i);
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
                this.pages[i].listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.7
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        RubinoSearchActivity.this.pages[i].getViewTreeObserver().removeOnPreDrawListener(this);
                        RubinoSearchActivity.this.fixLayoutInternal(i);
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
            if ((iArr2[0] != 0 || iArr2[1] == 0) && !this.scrollSlidingTextTabStrip.hasTab(type_profile)) {
                this.scrollSlidingTextTabStrip.addTextTab(type_profile, LocaleController.getString(R.string.rubinoSearchProfileTab), 17, Theme.getRubinoTypeFaceRegular());
            }
            if (this.hasMedia[1] != 0 && !this.scrollSlidingTextTabStrip.hasTab(type_hashtag)) {
                this.scrollSlidingTextTabStrip.addTextTab(type_hashtag, LocaleController.getString(R.string.rubinoSearchHashtagTab), 17, Theme.getRubinoTypeFaceRegular());
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
        SearchAdapter searchAdapter;
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
        if (this.searching && this.searchWas) {
            if (!z) {
                if (this.pages[z ? 1 : 0].listView != null) {
                    if (this.pages[z ? 1 : 0].selectedType != type_profile) {
                        if (this.pages[z ? 1 : 0].selectedType == type_hashtag) {
                            if (adapter != this.searchAdapterHashtag) {
                                this.pages[z ? 1 : 0].listView.setAdapter(this.searchAdapterHashtag);
                            }
                            this.searchAdapterHashtag.notifyDataSetChanged();
                        }
                    } else {
                        if (adapter != this.searchAdapterProfile) {
                            this.pages[z ? 1 : 0].listView.setAdapter(this.searchAdapterProfile);
                        }
                        this.searchAdapterProfile.notifyDataSetChanged();
                    }
                }
                if (this.searchItemState != 2 && this.pages[z ? 1 : 0].emptyTextView != null) {
                    this.pages[z ? 1 : 0].emptyTextView.setText(LocaleController.getString(R.string.rubino_search_not_found));
                    this.pages[z ? 1 : 0].emptyImageView.setVisibility(8);
                }
            } else {
                String string = this.searchItem.getSearchField().getText().toString();
                if (this.pages[z ? 1 : 0].selectedType != type_profile) {
                    if (this.pages[z ? 1 : 0].selectedType == type_hashtag && (searchAdapter = this.searchAdapterHashtag) != null) {
                        searchAdapter.search(string);
                        if (adapter != this.searchAdapterHashtag) {
                            this.pages[z ? 1 : 0].listView.setAdapter(this.searchAdapterHashtag);
                        }
                    }
                } else {
                    SearchAdapter searchAdapter2 = this.searchAdapterProfile;
                    if (searchAdapter2 != null) {
                        searchAdapter2.search(string);
                        if (adapter != this.searchAdapterProfile) {
                            this.pages[z ? 1 : 0].listView.setAdapter(this.searchAdapterProfile);
                        }
                    }
                }
                if (this.searchItemState != 2 && this.pages[z ? 1 : 0].emptyTextView != null) {
                    this.pages[z ? 1 : 0].emptyTextView.setText(LocaleController.getString(R.string.rubino_search_not_found));
                    this.pages[z ? 1 : 0].emptyImageView.setVisibility(8);
                }
            }
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

    public class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private int currentType;
        private String lastSearchedText;
        private Context mContext;
        private boolean searchesInProgress;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public SearchAdapter(Context context, int i) {
            this.mContext = context;
            this.currentType = i;
        }

        public void search(String str) {
            String str2 = this.lastSearchedText;
            if (str2 == null || !str2.equals(str)) {
                this.lastSearchedText = str;
                this.searchesInProgress = true;
                RubinoSearchActivity.this.loadData(this.currentType, str, true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            RubinoSearchActivity.this.pageData[this.currentType].updateRows();
            super.notifyDataSetChanged();
            for (int i = 0; i < RubinoSearchActivity.this.pages.length; i++) {
                if (RubinoSearchActivity.this.pages[i].selectedType == this.currentType) {
                    if (!this.searchesInProgress) {
                        RubinoSearchActivity.this.pages[i].listView.setEmptyView(RubinoSearchActivity.this.pages[i].emptyView);
                        RubinoSearchActivity.this.pages[i].progressView.setVisibility(8);
                        if (RubinoSearchActivity.this.searchItem != null && RubinoSearchActivity.this.searchItem.getSearchField().getText().toString().isEmpty()) {
                            RubinoSearchActivity.this.pages[i].listView.getEmptyView().setVisibility(8);
                        }
                    } else {
                        RubinoSearchActivity.this.pages[i].listView.getEmptyView().setVisibility(8);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoSearchActivity.this.pageData[this.currentType].rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout profileOrHashtagCell;
            FrameLayout rubinoSearchLoadingOrEmptyCell;
            if (i == 0 || i == 2) {
                profileOrHashtagCell = new ProfileOrHashtagCell(this.mContext, false, true);
                profileOrHashtagCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else if (i == 4) {
                profileOrHashtagCell = new RubinoSearchLoadingOrEmptyCell(this.mContext, true);
                profileOrHashtagCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                rubinoSearchLoadingOrEmptyCell = new RubinoSearchLoadingOrEmptyCell(this.mContext, false);
                rubinoSearchLoadingOrEmptyCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                return new RecyclerListView.Holder(rubinoSearchLoadingOrEmptyCell);
            }
            rubinoSearchLoadingOrEmptyCell = profileOrHashtagCell;
            return new RecyclerListView.Holder(rubinoSearchLoadingOrEmptyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                if (this.currentType == RubinoSearchActivity.type_profile) {
                    ProfileOrHashtagCell profileOrHashtagCell = (ProfileOrHashtagCell) viewHolder.itemView;
                    int size = RubinoSearchActivity.this.pageData[this.currentType].profiles.size();
                    if (i < 0 || i >= size) {
                        return;
                    }
                    RubinoProfileObject rubinoProfileObject = (RubinoProfileObject) RubinoSearchActivity.this.pageData[this.currentType].profiles.get(i);
                    RubinoProfileObject rubinoProfileObject2 = RubinoSearchActivity.this.getRubinoController().profileMap.get(rubinoProfileObject.id);
                    if (rubinoProfileObject2 != null) {
                        profileOrHashtagCell.setProfile(rubinoProfileObject2, ((BaseFragment) RubinoSearchActivity.this).classGuid);
                        return;
                    } else {
                        profileOrHashtagCell.setProfile(rubinoProfileObject, ((BaseFragment) RubinoSearchActivity.this).classGuid);
                        return;
                    }
                }
                return;
            }
            if (itemViewType == 1) {
                RubinoSearchLoadingOrEmptyCell rubinoSearchLoadingOrEmptyCell = (RubinoSearchLoadingOrEmptyCell) viewHolder.itemView;
                if (RubinoSearchActivity.this.searchItem != null) {
                    String strTrim = RubinoSearchActivity.this.searchItem.getSearchField().getText().toString().trim();
                    if (strTrim.isEmpty()) {
                        rubinoSearchLoadingOrEmptyCell.setText(BuildConfig.FLAVOR);
                        return;
                    }
                    rubinoSearchLoadingOrEmptyCell.setText(LocaleController.getString(R.string.rubinoSearchAction).replace("$arg1", "\"" + strTrim + "\""));
                    return;
                }
                return;
            }
            if (itemViewType == 2) {
                if (this.currentType == RubinoSearchActivity.type_hashtag) {
                    ProfileOrHashtagCell profileOrHashtagCell2 = (ProfileOrHashtagCell) viewHolder.itemView;
                    int size2 = RubinoSearchActivity.this.pageData[this.currentType].hashtags.size();
                    if (i < 0 || i >= size2) {
                        return;
                    }
                    profileOrHashtagCell2.setHashtag((Rubino.HashtagObject) RubinoSearchActivity.this.pageData[this.currentType].hashtags.get(i), ((BaseFragment) RubinoSearchActivity.this).classGuid);
                    return;
                }
                return;
            }
            if (itemViewType != 4) {
                return;
            }
            RubinoSearchLoadingOrEmptyCell rubinoSearchLoadingOrEmptyCell2 = (RubinoSearchLoadingOrEmptyCell) viewHolder.itemView;
            if (RubinoSearchActivity.this.searchItem != null) {
                String strTrim2 = RubinoSearchActivity.this.searchItem.getSearchField().getText().toString().trim();
                if (strTrim2.isEmpty()) {
                    rubinoSearchLoadingOrEmptyCell2.setText(BuildConfig.FLAVOR);
                    return;
                }
                rubinoSearchLoadingOrEmptyCell2.setText(LocaleController.getString(R.string.rubinoSearchNoResult).replace("$arg1", "\"" + strTrim2 + "\""));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= RubinoSearchActivity.this.pageData[this.currentType].arrayStartRow && i < RubinoSearchActivity.this.pageData[this.currentType].arrayEndRow) {
                if (this.currentType == RubinoSearchActivity.type_profile) {
                    return 0;
                }
                return this.currentType == RubinoSearchActivity.type_hashtag ? 2 : 4;
            }
            if (i == RubinoSearchActivity.this.pageData[this.currentType].loadingRow) {
                return 1;
            }
            if (i == RubinoSearchActivity.this.pageData[this.currentType].retryRow) {
                return 3;
            }
            int unused = RubinoSearchActivity.this.pageData[this.currentType].emptyViewRow;
            return 4;
        }
    }

    void loadData(int i, String str, final boolean z) {
        Observable<Rubino.HashtagListObject> hashtagTrendObservable;
        final SearchAdapter searchAdapter = i == type_profile ? this.searchAdapterProfile : this.searchAdapterHashtag;
        if (this.pageData[i].requestObservable != null && !this.pageData[i].requestObservable.isDisposed()) {
            this.pageData[i].requestObservable.dispose();
        }
        this.pageData[i].loading = true;
        if (i == type_profile) {
            this.pageData[i].profiles.clear();
            this.pageData[i].profilesMap.clear();
        } else if (i == type_hashtag) {
            this.pageData[i].hashtags.clear();
            this.pageData[i].hashtagsMap.clear();
        }
        searchAdapter.notifyDataSetChanged();
        if (i == type_profile) {
            if (str != null && !str.isEmpty()) {
                this.pageData[i].requestObservable = (DisposableObserver) getRubinoController().getSearchProfilesObservable(str, z ? null : this.pageData[0].max_id, 50).observeOn(Schedulers.io()).doOnNext(new Consumer<Rubino.ProfileListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.9
                    @Override // io.reactivex.functions.Consumer
                    public void accept(Rubino.ProfileListObject profileListObject) throws Exception {
                        if (profileListObject != null) {
                            RubinoSearchActivity.this.pageData[0].loading = false;
                            int size = profileListObject.profiles.size();
                            if (z) {
                                RubinoSearchActivity.this.pageData[0].profiles.clear();
                                RubinoSearchActivity.this.pageData[0].profilesMap.clear();
                            }
                            if (size > 0) {
                                Iterator<RubinoProfileObject> it = profileListObject.profiles.iterator();
                                while (it.hasNext()) {
                                    RubinoSearchActivity.this.pageData[0].addProfile(it.next(), false);
                                }
                                RubinoSearchActivity.this.pageData[0].max_id = profileListObject.profiles.get(size - 1).id;
                            }
                            RubinoSearchActivity.this.pageData[0].endReached = true;
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.ProfileListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.8
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Rubino.ProfileListObject profileListObject) {
                        dispose();
                        SearchAdapter searchAdapter2 = searchAdapter;
                        if (searchAdapter2 != null) {
                            searchAdapter2.searchesInProgress = false;
                        }
                        if (profileListObject != null) {
                            RubinoSearchActivity.this.updateAdapter(RubinoSearchActivity.type_profile);
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        SearchAdapter searchAdapter2 = searchAdapter;
                        if (searchAdapter2 != null) {
                            searchAdapter2.searchesInProgress = false;
                            searchAdapter.lastSearchedText = null;
                        }
                        dispose();
                    }
                });
                this.compositeDisposable.add(this.pageData[i].requestObservable);
                return;
            }
            searchAdapter.searchesInProgress = false;
            this.pageData[0].profiles.clear();
            this.pageData[0].profilesMap.clear();
            this.pageData[0].endReached = true;
            updateAdapter(type_hashtag);
            return;
        }
        if (i == type_hashtag) {
            if (str == null || str.isEmpty()) {
                hashtagTrendObservable = getRubinoController().getHashtagTrendObservable(z ? null : this.pageData[type_hashtag].max_id, 50);
            } else {
                hashtagTrendObservable = getRubinoController().getSearchHashtagObservable(str, z ? null : this.pageData[type_hashtag].max_id, 50);
            }
            this.pageData[type_hashtag].requestObservable = (DisposableObserver) hashtagTrendObservable.observeOn(Schedulers.io()).doOnNext(new Consumer<Rubino.HashtagListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.11
                @Override // io.reactivex.functions.Consumer
                public void accept(Rubino.HashtagListObject hashtagListObject) throws Exception {
                    if (hashtagListObject != null) {
                        RubinoSearchActivity.this.pageData[RubinoSearchActivity.type_hashtag].loading = false;
                        int size = hashtagListObject.hashtags.size();
                        if (z) {
                            RubinoSearchActivity.this.pageData[RubinoSearchActivity.type_hashtag].hashtags.clear();
                            RubinoSearchActivity.this.pageData[RubinoSearchActivity.type_hashtag].hashtagsMap.clear();
                        }
                        if (size > 0) {
                            Iterator<Rubino.HashtagObject> it = hashtagListObject.hashtags.iterator();
                            while (it.hasNext()) {
                                RubinoSearchActivity.this.pageData[RubinoSearchActivity.type_hashtag].addHashtag(it.next(), false);
                            }
                            RubinoSearchActivity.this.pageData[RubinoSearchActivity.type_hashtag].max_id = hashtagListObject.hashtags.get(size - 1).id;
                        }
                        RubinoSearchActivity.this.pageData[RubinoSearchActivity.type_hashtag].endReached = true;
                    }
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.HashtagListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.10
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(Rubino.HashtagListObject hashtagListObject) {
                    dispose();
                    SearchAdapter searchAdapter2 = searchAdapter;
                    if (searchAdapter2 != null) {
                        searchAdapter2.searchesInProgress = false;
                    }
                    if (hashtagListObject != null) {
                        RubinoSearchActivity.this.updateAdapter(RubinoSearchActivity.type_hashtag);
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    SearchAdapter searchAdapter2 = searchAdapter;
                    if (searchAdapter2 != null) {
                        searchAdapter2.searchesInProgress = false;
                        searchAdapter.lastSearchedText = null;
                    }
                    dispose();
                }
            });
            this.compositeDisposable.add(this.pageData[i].requestObservable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdapter(int i) {
        int i2 = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.pages;
            if (i2 >= mediaPageArr.length) {
                return;
            }
            if (mediaPageArr[i2].selectedType == i) {
                if (!this.pageData[i].loading) {
                    if (this.pages[i2].progressView != null) {
                        this.pages[i2].progressView.setVisibility(8);
                    }
                    if (this.pages[i2].selectedType == i && this.pages[i2].listView != null && this.pages[i2].listView.getEmptyView() == null) {
                        this.pages[i2].listView.setEmptyView(this.pages[i2].emptyView);
                    }
                }
                SearchAdapter searchAdapter = i == type_profile ? this.searchAdapterProfile : this.searchAdapterHashtag;
                if (searchAdapter != null) {
                    searchAdapter.notifyDataSetChanged();
                }
            }
            i2++;
        }
    }

    public class CustomFrameLayout extends FrameLayout {
        public boolean maybeStartTracking;
        private boolean startedTracking;
        private int startedTrackingPointerId;
        private int startedTrackingX;
        private int startedTrackingY;
        private VelocityTracker velocityTracker;

        public CustomFrameLayout(Context context) {
            super(context);
        }

        private boolean prepareForMoving(MotionEvent motionEvent, boolean z) {
            int nextPageId = RubinoSearchActivity.this.scrollSlidingTextTabStrip.getNextPageId(z);
            if (nextPageId < 0) {
                return false;
            }
            if (RubinoSearchActivity.this.searchItemState != 0) {
                if (RubinoSearchActivity.this.searchItemState != 2) {
                    int unused = RubinoSearchActivity.this.searchItemState;
                }
                RubinoSearchActivity.this.searchItemState = 0;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            this.maybeStartTracking = false;
            this.startedTracking = true;
            this.startedTrackingX = (int) motionEvent.getX();
            ((BaseFragment) RubinoSearchActivity.this).actionBar.setEnabled(false);
            RubinoSearchActivity.this.scrollSlidingTextTabStrip.setEnabled(false);
            RubinoSearchActivity.this.selectedId = nextPageId;
            RubinoSearchActivity.this.pages[1].selectedType = nextPageId;
            RubinoSearchActivity.this.pages[1].setVisibility(0);
            RubinoSearchActivity.this.animatingForward = z;
            RubinoSearchActivity.this.switchToCurrentSelectedMode(true);
            if (z) {
                RubinoSearchActivity.this.pages[1].setTranslationX(RubinoSearchActivity.this.pages[1].getMeasuredWidth());
            } else {
                RubinoSearchActivity.this.pages[1].setTranslationX(-RubinoSearchActivity.this.pages[1].getMeasuredWidth());
            }
            return true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return RubinoSearchActivity.this.tabsAnimationInProgress || RubinoSearchActivity.this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (((BaseFragment) RubinoSearchActivity.this).parentLayout.checkTransitionAnimation() || RubinoSearchActivity.this.tabsAnimationInProgress) {
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
                if (this.startedTracking && ((RubinoSearchActivity.this.animatingForward && x > 0) || (!RubinoSearchActivity.this.animatingForward && x < 0))) {
                    if (!prepareForMoving(motionEvent, x < 0)) {
                        this.maybeStartTracking = true;
                        this.startedTracking = false;
                    }
                }
                if (!this.maybeStartTracking || this.startedTracking) {
                    if (this.startedTracking) {
                        if (RubinoSearchActivity.this.animatingForward) {
                            RubinoSearchActivity.this.pages[0].setTranslationX(x);
                            RubinoSearchActivity.this.pages[1].setTranslationX(RubinoSearchActivity.this.pages[1].getMeasuredWidth() + x);
                        } else {
                            RubinoSearchActivity.this.pages[0].setTranslationX(x);
                            RubinoSearchActivity.this.pages[1].setTranslationX(x - RubinoSearchActivity.this.pages[1].getMeasuredWidth());
                        }
                        float fAbs = Math.abs(x) / RubinoSearchActivity.this.pages[0].getMeasuredWidth();
                        if (RubinoSearchActivity.this.searchItemState != 2) {
                            int unused = RubinoSearchActivity.this.searchItemState;
                        }
                        RubinoSearchActivity.this.scrollSlidingTextTabStrip.selectTabWithId(RubinoSearchActivity.this.pages[1].selectedType, fAbs);
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
                    float x2 = RubinoSearchActivity.this.pages[0].getX();
                    AnimatorSet animatorSet = new AnimatorSet();
                    float xVelocity2 = this.velocityTracker.getXVelocity();
                    final boolean z = Math.abs(x2) < ((float) RubinoSearchActivity.this.pages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity2) < 3500.0f || Math.abs(xVelocity2) < Math.abs(this.velocityTracker.getYVelocity()));
                    if (z) {
                        if (RubinoSearchActivity.this.animatingForward) {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(RubinoSearchActivity.this.pages[0], "translationX", 0.0f), ObjectAnimator.ofFloat(RubinoSearchActivity.this.pages[1], "translationX", RubinoSearchActivity.this.pages[1].getMeasuredWidth()));
                        } else {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(RubinoSearchActivity.this.pages[0], "translationX", 0.0f), ObjectAnimator.ofFloat(RubinoSearchActivity.this.pages[1], "translationX", -RubinoSearchActivity.this.pages[1].getMeasuredWidth()));
                        }
                    } else if (RubinoSearchActivity.this.animatingForward) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(RubinoSearchActivity.this.pages[0], "translationX", -RubinoSearchActivity.this.pages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(RubinoSearchActivity.this.pages[1], "translationX", 0.0f));
                    } else {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(RubinoSearchActivity.this.pages[0], "translationX", RubinoSearchActivity.this.pages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(RubinoSearchActivity.this.pages[1], "translationX", 0.0f));
                    }
                    animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                    animatorSet.setDuration(200L);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchActivity.CustomFrameLayout.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (z) {
                                RubinoSearchActivity.this.pages[1].setVisibility(4);
                                if (RubinoSearchActivity.this.searchItemState != 2) {
                                    int unused2 = RubinoSearchActivity.this.searchItemState;
                                }
                                RubinoSearchActivity.this.searchItemState = 0;
                            } else {
                                MediaPage mediaPage = RubinoSearchActivity.this.pages[0];
                                RubinoSearchActivity.this.pages[0] = RubinoSearchActivity.this.pages[1];
                                RubinoSearchActivity.this.pages[1] = mediaPage;
                                RubinoSearchActivity.this.pages[1].setVisibility(4);
                                int unused3 = RubinoSearchActivity.this.searchItemState;
                                RubinoSearchActivity.this.searchItemState = 0;
                                RubinoSearchActivity rubinoSearchActivity = RubinoSearchActivity.this;
                                ((BaseFragment) rubinoSearchActivity).swipeBackEnabled = rubinoSearchActivity.pages[0].selectedType == RubinoSearchActivity.this.scrollSlidingTextTabStrip.getFirstTabId();
                                RubinoSearchActivity.this.scrollSlidingTextTabStrip.selectTabWithId(RubinoSearchActivity.this.pages[0].selectedType, 1.0f);
                                RubinoSearchActivity.this.searchItem.setSearchFieldHint(LocaleController.getString(RubinoSearchActivity.this.pages[0].selectedType == RubinoSearchActivity.type_profile ? R.string.rubinoSearchProfile : R.string.rubinoSearchHashtag));
                            }
                            RubinoSearchActivity.this.tabsAnimationInProgress = false;
                            CustomFrameLayout customFrameLayout = CustomFrameLayout.this;
                            customFrameLayout.maybeStartTracking = false;
                            customFrameLayout.startedTracking = false;
                            ((BaseFragment) RubinoSearchActivity.this).actionBar.setEnabled(true);
                            RubinoSearchActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                        }
                    });
                    animatorSet.start();
                    RubinoSearchActivity.this.tabsAnimationInProgress = true;
                } else {
                    this.maybeStartTracking = false;
                    this.startedTracking = false;
                    ((BaseFragment) RubinoSearchActivity.this).actionBar.setEnabled(true);
                    RubinoSearchActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
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
            ((BaseFragment) RubinoSearchActivity.this).actionBar.setEnabled(true);
            RubinoSearchActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
        }
    }
}
