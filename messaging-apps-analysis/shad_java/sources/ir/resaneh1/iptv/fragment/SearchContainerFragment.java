package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.Match_UI_TabView;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.fragment.InstaSearchFragment;
import ir.resaneh1.iptv.helper.DataGenerator;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.GetSearchStructureOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.TabListObject;
import ir.resaneh1.iptv.model.TabObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.EditTextBoldCursor;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class SearchContainerFragment extends PresenterFragment {
    private View clearSearchBarIcon;
    public int defaultTab;
    public String defaultTabId;
    private String dynamicPageObjectId;
    private Handler handler;
    private TabObject initTabObject;
    private boolean isOneTimePaused;
    public int minSizeForLoop;
    ViewPager.OnPageChangeListener onPageChangeListener;
    TabLayout.OnTabSelectedListener onTabSelectedListener;
    public RecyclerViewListPresenter.MyViewHolder recyclerHolder;
    Runnable runnable;
    public EditTextBoldCursor searchEditText;
    private BaseFragment selectedFragment;
    private boolean showMainTabs;
    TabLayout tabLayout;
    public TabListObject tabListObject;
    ViewPager viewPager;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.search_container_fragment;
    }

    public SearchContainerFragment(String str, boolean z) {
        this.handler = new Handler();
        this.minSizeForLoop = 20000;
        this.showMainTabs = false;
        this.isOneTimePaused = false;
        this.runnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.7
            @Override // java.lang.Runnable
            public void run() {
                SearchContainerFragment.this.onSearchClick();
            }
        };
        this.onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.9
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                SearchContainerFragment.this.onSelectedPosition(i);
            }
        };
        this.onTabSelectedListener = new TabLayout.OnTabSelectedListener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.10
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                SearchContainerFragment.this.setTabView(tab.getCustomView(), tab.getPosition(), true);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                SearchContainerFragment.this.setTabView(tab.getCustomView(), tab.getPosition(), false);
                if (SearchContainerFragment.this.selectedFragment != null) {
                    SearchContainerFragment.this.selectedFragment.onPause();
                }
                SearchContainerFragment.this.cancelTimer();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                SearchContainerFragment.this.onSelectedPosition(tab.getPosition());
            }
        };
        this.defaultTabId = str;
        this.showMainTabs = z;
    }

    public SearchContainerFragment(TabObject tabObject, String str) {
        this.handler = new Handler();
        this.minSizeForLoop = 20000;
        this.showMainTabs = false;
        this.isOneTimePaused = false;
        this.runnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.7
            @Override // java.lang.Runnable
            public void run() {
                SearchContainerFragment.this.onSearchClick();
            }
        };
        this.onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.9
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                SearchContainerFragment.this.onSelectedPosition(i);
            }
        };
        this.onTabSelectedListener = new TabLayout.OnTabSelectedListener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.10
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                SearchContainerFragment.this.setTabView(tab.getCustomView(), tab.getPosition(), true);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                SearchContainerFragment.this.setTabView(tab.getCustomView(), tab.getPosition(), false);
                if (SearchContainerFragment.this.selectedFragment != null) {
                    SearchContainerFragment.this.selectedFragment.onPause();
                }
                SearchContainerFragment.this.cancelTimer();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                SearchContainerFragment.this.onSelectedPosition(tab.getPosition());
            }
        };
        this.initTabObject = tabObject;
        this.showMainTabs = false;
        this.defaultTabId = BuildConfig.FLAVOR;
        this.dynamicPageObjectId = str;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        this.viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.swipeBackEnabled = false;
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(0);
        }
        setSearchToolbar();
        if (this.initTabObject != null) {
            ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.timer(100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.1
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) throws Resources.NotFoundException {
                    SearchContainerFragment.this.progressBar.setVisibility(4);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(SearchContainerFragment.this.initTabObject);
                    SearchContainerFragment.this.makeLayout(arrayList);
                }
            }));
        } else {
            callGetTabs();
        }
    }

    private void callGetTabs() {
        ApiRequestMessanger.getInstance(this.currentAccount).getSearchStructure(new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.2
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) throws Resources.NotFoundException {
                ArrayList<TabObject> arrayList;
                SearchContainerFragment.this.progressBar.setVisibility(4);
                GetSearchStructureOutput getSearchStructureOutput = (GetSearchStructureOutput) obj;
                if (getSearchStructureOutput == null || (arrayList = getSearchStructureOutput.structure) == null) {
                    return;
                }
                SearchContainerFragment.this.makeLayout(arrayList);
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                SearchContainerFragment.this.progressBar.setVisibility(4);
                SearchContainerFragment.this.showRetryLayout();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                SearchContainerFragment.this.progressBar.setVisibility(4);
                SearchContainerFragment.this.showRetryLayout();
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        callGetTabs();
    }

    void setSearchToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, BuildConfig.FLAVOR);
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.clearSearchBarIcon = toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_close_grey);
        toolbarImageView.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_actionBarDefaultIcon), PorterDuff.Mode.SRC_ATOP));
        this.toolbarMaker.addViewToLeftLayout(this.clearSearchBarIcon);
        this.clearSearchBarIcon.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchContainerFragment.this.searchEditText.setText(BuildConfig.FLAVOR);
                if (SearchContainerFragment.this.selectedFragment instanceof ListFragment) {
                    ((ListFragment) SearchContainerFragment.this.selectedFragment).initSearch();
                }
                SearchContainerFragment.this.clearSearchBarIcon.setVisibility(4);
            }
        });
        this.clearSearchBarIcon.setVisibility(4);
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(this.mContext);
        this.searchEditText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.searchEditText.setHintTextColor(Theme.getColor(Theme.key_actionBarDefaultSearchPlaceholder));
        this.searchEditText.setTextColor(Theme.getColor(Theme.key_actionBarDefaultSearch));
        this.searchEditText.setMaxLines(1);
        this.searchEditText.setPadding(AndroidUtilities.dp(56.0f), 0, 0, 0);
        this.searchEditText.setGravity(21);
        this.searchEditText.setImeOptions(268435456);
        this.searchEditText.setInputType(16385);
        this.searchEditText.setImeOptions(3);
        this.searchEditText.setMinHeight(AndroidUtilities.dp(56.0f));
        this.searchEditText.setHint("جستجو");
        this.searchEditText.setCursorColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.searchEditText.setBackgroundColor(this.mContext.getResources().getColor(R.color.transparent));
        this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.searchEditText.setCursorWidth(1.5f);
        this.searchEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z || SearchContainerFragment.this.isOneTimePaused) {
                    return;
                }
                AndroidUtilities.showKeyboard(SearchContainerFragment.this.searchEditText);
            }
        });
        this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                AndroidUtilities.hideKeyboard(SearchContainerFragment.this.searchEditText);
                SearchContainerFragment.this.onSearchClick();
                return true;
            }
        });
        this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchContainerFragment.this.searchEditText.getText().toString().length() > 0) {
                    SearchContainerFragment.this.clearSearchBarIcon.setVisibility(0);
                } else {
                    SearchContainerFragment.this.clearSearchBarIcon.setVisibility(4);
                }
                SearchContainerFragment.this.cancelTimer();
                SearchContainerFragment.this.startTimer();
            }
        });
        this.searchEditText.requestFocus();
        this.searchEditText.setFocusable(false);
        this.searchEditText.setFocusableInTouchMode(true);
        this.toolbarMaker.addViewToRightLayout(this.searchEditText);
        this.searchEditText.getLayoutParams().width = DimensionHelper.getScreenWidth((Activity) this.mContext) - AndroidUtilities.dp(56.0f);
    }

    public void onSearchClick() {
        if (this.tabListObject == null && this.selectedFragment == null) {
            return;
        }
        String string = this.searchEditText.getText().toString();
        if (string.length() > 1 && (string.startsWith("#") || string.startsWith("@"))) {
            string = string.substring(1);
        }
        TabListObject tabListObject = this.tabListObject;
        TabObject tabObject = tabListObject.tabObjects.get(tabListObject.selectedPosision);
        BaseFragment baseFragment = this.selectedFragment;
        if (baseFragment instanceof ListFragment) {
            if (string.isEmpty()) {
                if (tabObject.has_suggestion) {
                    ((ListFragment) this.selectedFragment).onSearchClick(string);
                    return;
                } else {
                    ((ListFragment) this.selectedFragment).initSearch();
                    return;
                }
            }
            ((ListFragment) this.selectedFragment).onSearchClick(string);
            return;
        }
        if (baseFragment instanceof InstaSearchFragment) {
            ((InstaSearchFragment) baseFragment).onSearchClickInsta(string);
        }
    }

    public void cancelTimer() {
        this.handler.removeCallbacks(this.runnable);
    }

    public void startTimer() {
        this.handler.postDelayed(this.runnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout(ArrayList<TabObject> arrayList) throws Resources.NotFoundException {
        new TabObject().setRubinoTab();
        RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(arrayList, MainPresenterSelector.getInstance(this.mContext), this.baseFragment);
        recyclerViewListObject.hastTitle = false;
        recyclerViewListObject.hasLoadMore = false;
        recyclerViewListObject.isLoop = arrayList.size() > this.minSizeForLoop;
        recyclerViewListObject.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.SearchContainerFragment.8
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) throws Resources.NotFoundException {
                if (abstractViewHolder.item.getPresenterType() == PresenterItemType.searchTab) {
                    SearchContainerFragment.this.cancelTimer();
                    SearchContainerFragment.this.pauseAndDestroyCurrentFragments();
                    Titem titem = abstractViewHolder.item;
                    if (!((TabObject) titem).has_tabs) {
                        SearchContainerFragment.this.setTabsAndFragments((TabObject) titem);
                    } else {
                        SearchContainerFragment.this.setTabsAndFragments(((TabObject) titem).items);
                    }
                    SearchContainerFragment.this.refreshViewpagerAndTabs();
                }
            }
        };
        RecyclerViewListPresenter recyclerViewListPresenter = new RecyclerViewListPresenter(this.mContext);
        recyclerViewListObject.isSaveSelected = true;
        this.recyclerHolder = recyclerViewListPresenter.createViewHolderAndBind(recyclerViewListObject);
        if (arrayList.size() > 2) {
            this.recyclerHolder.recyclerView.getLayoutManager().scrollToPosition(1073741823 - (1073741823 % arrayList.size()));
        }
        if (!this.showMainTabs) {
            this.recyclerHolder.itemView.setVisibility(8);
        }
        this.linearLayout.addView(this.recyclerHolder.itemView);
        initAndSelectDefaultTab(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseAndDestroyCurrentFragments() {
        BaseFragment baseFragment = this.selectedFragment;
        if (baseFragment != null) {
            baseFragment.onPause();
        }
        TabListObject tabListObject = this.tabListObject;
        if (tabListObject == null || tabListObject.fragmentSparseArray == null) {
            return;
        }
        for (int i = 0; i < this.tabListObject.fragmentSparseArray.size(); i++) {
            BaseFragment baseFragment2 = this.tabListObject.fragmentSparseArray.get(this.tabListObject.fragmentSparseArray.keyAt(i));
            if (baseFragment2 != null) {
                baseFragment2.onFragmentDestroy();
            }
        }
    }

    private void initAndSelectDefaultTab(ArrayList<TabObject> arrayList) throws Resources.NotFoundException {
        int i;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.defaultTab = 0;
        if (this.defaultTabId != null) {
            Iterator<TabObject> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TabObject next = it.next();
                if (DataGenerator.isTwoObjectEquals(next.tab_id, this.defaultTabId)) {
                    this.defaultTab = arrayList.indexOf(next);
                    break;
                }
            }
        }
        int i2 = this.defaultTab;
        if (i2 < 0 || i2 > arrayList.size() - 1) {
            this.defaultTab = 0;
        }
        TabObject tabObject = arrayList.get(this.defaultTab);
        if (tabObject.has_tabs) {
            setTabsAndFragments(tabObject.items);
        } else {
            setTabsAndFragments(tabObject);
        }
        setupViewPager();
        tabObject.presenterIsSelected = true;
        this.recyclerHolder.recyclerView.getAdapter().notifyItemChanged(this.defaultTab);
        try {
            int size = arrayList.size();
            if (size > this.minSizeForLoop) {
                i = 1073741823;
                while (i % size == this.defaultTab) {
                    i--;
                }
            } else {
                i = this.defaultTab;
            }
            this.recyclerHolder.recyclerView.scrollToPosition(i);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabsAndFragments(TabObject tabObject) {
        this.searchEditText.setHint("جستجوی " + tabObject.title);
        ArrayList<TabObject> arrayList = new ArrayList<>();
        arrayList.add(tabObject);
        setTabsAndFragments(arrayList);
    }

    public void setTabsAndFragments(ArrayList<TabObject> arrayList) {
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() == 0 || arrayList.size() == 1) {
            this.tabLayout.setVisibility(8);
        } else {
            this.tabLayout.setVisibility(0);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        SparseArray<BaseFragment> sparseArray = new SparseArray<>();
        ArrayList<TabObject> arrayList3 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TabObject tabObject = arrayList.get((size - 1) - i);
            arrayList3.add(tabObject);
            arrayList2.add(tabObject.title);
        }
        TabListObject tabListObject = new TabListObject();
        this.tabListObject = tabListObject;
        tabListObject.tabNames = arrayList2;
        tabListObject.fragmentSparseArray = sparseArray;
        tabListObject.tabObjects = arrayList3;
        tabListObject.selectedName = arrayList2.get(0);
        this.tabListObject.selectedPosision = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshViewpagerAndTabs() throws Resources.NotFoundException {
        this.tabLayout.removeAllTabs();
        this.viewPager.removeAllViews();
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.removeOnPageChangeListener(this.onPageChangeListener);
        this.viewPager.setAdapter(new ViewPagerAdapter(this.mContext));
        for (int i = 0; i < this.tabListObject.tabNames.size(); i++) {
            if (this.tabListObject.tabNames.get(i).equals(this.tabListObject.selectedName)) {
                this.tabLayout.getTabAt(i).setCustomView(getTabView(this.tabListObject.tabNames.get(i), true));
                this.viewPager.setCurrentItem(i);
            } else {
                this.tabLayout.getTabAt(i).setCustomView(getTabView(this.tabListObject.tabNames.get(i), false));
            }
        }
        this.viewPager.addOnPageChangeListener(this.onPageChangeListener);
        this.tabLayout.addOnTabSelectedListener(this.onTabSelectedListener);
        if (this.tabListObject.tabNames.size() >= 1) {
            this.tabLayout.getTabAt(this.tabListObject.tabNames.size() - 1).select();
        }
    }

    public void onSelectedPosition(int i) {
        BaseFragment baseFragment = this.selectedFragment;
        if (baseFragment != null) {
            baseFragment.onPause();
        }
        BaseFragment baseFragment2 = this.tabListObject.fragmentSparseArray.get(i);
        this.selectedFragment = baseFragment2;
        if (baseFragment2 != null) {
            baseFragment2.onResume();
        }
        this.tabListObject.selectedPosision = i;
        onSearchClick();
        String str = this.tabListObject.tabNames.get(i);
        this.searchEditText.setHint("جستجوی " + str);
        this.tabListObject.selectedName = str;
    }

    public View getTabView(String str, boolean z) throws Resources.NotFoundException {
        int color;
        Match_UI_TabView match_UI_TabView = new Match_UI_TabView();
        if (z) {
            color = this.mContext.getResources().getColor(R.color.black);
        } else {
            color = this.mContext.getResources().getColor(R.color.grey_500);
        }
        View viewCreateView = match_UI_TabView.createView((Activity) this.mContext, str, color);
        match_UI_TabView.textView.setTextSize(1, 13.0f);
        return viewCreateView;
    }

    public View setTabView(View view, String str, boolean z) throws Resources.NotFoundException {
        int color;
        Match_UI_TabView match_UI_TabView = new Match_UI_TabView();
        if (z) {
            color = this.mContext.getResources().getColor(R.color.black);
        } else {
            color = this.mContext.getResources().getColor(R.color.grey_500);
        }
        View viewRefreshView = match_UI_TabView.refreshView(view, str, color);
        match_UI_TabView.textView.setTextSize(1, 13.0f);
        return viewRefreshView;
    }

    public View setTabView(View view, int i, boolean z) {
        return setTabView(view, this.tabListObject.tabNames.get(i), z);
    }

    private void setupViewPager() throws Resources.NotFoundException {
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.viewPager.setAdapter(new ViewPagerAdapter(this.mContext));
        for (int i = 0; i < this.tabListObject.tabNames.size(); i++) {
            if (this.tabListObject.tabNames.get(i).equals(this.tabListObject.selectedName)) {
                this.tabLayout.getTabAt(i).setCustomView(getTabView(this.tabListObject.tabNames.get(i), true));
                this.viewPager.setCurrentItem(i);
            } else {
                this.tabLayout.getTabAt(i).setCustomView(getTabView(this.tabListObject.tabNames.get(i), false));
            }
        }
        this.tabLayout.addOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.addOnPageChangeListener(this.onPageChangeListener);
        if (this.tabListObject.tabNames.size() >= 1) {
            this.tabLayout.getTabAt(this.tabListObject.tabNames.size() - 1).select();
        }
    }

    class ViewPagerAdapter extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return BuildConfig.FLAVOR;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public ViewPagerAdapter(Context context) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            BaseFragment baseFragment = SearchContainerFragment.this.tabListObject.fragmentSparseArray.get(i);
            TabObject tabObject = SearchContainerFragment.this.tabListObject.tabObjects.get(i);
            if (baseFragment == null) {
                TabObject.TypeEnum typeEnum = tabObject.type;
                if (typeEnum == TabObject.TypeEnum.rubinoHashtag) {
                    SearchContainerFragment.this.tabListObject.fragmentSparseArray.put(i, new InstaSearchFragment(InstaSearchFragment.TypeEnum.hashTag));
                } else if (typeEnum == TabObject.TypeEnum.rubinoProfile) {
                    SearchContainerFragment.this.tabListObject.fragmentSparseArray.put(i, new InstaSearchFragment(InstaSearchFragment.TypeEnum.profile));
                } else if (tabObject.view_tag != null) {
                    ListFragment listFragment = new ListFragment(new ListInput(tabObject.view_tag, SearchContainerFragment.this.dynamicPageObjectId, true));
                    listFragment.isPreview = true;
                    SearchContainerFragment.this.tabListObject.fragmentSparseArray.put(i, listFragment);
                }
            }
            BaseFragment baseFragment2 = SearchContainerFragment.this.tabListObject.fragmentSparseArray.get(i);
            baseFragment2.createView(SearchContainerFragment.this.getContext());
            if (baseFragment2 instanceof ListFragment) {
                ((ListFragment) baseFragment2).initSearch();
            }
            View fragmentView = baseFragment2.getFragmentView();
            fragmentView.setTag(baseFragment2);
            viewGroup.addView(fragmentView);
            return fragmentView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view = (View) obj;
            BaseFragment baseFragment = (BaseFragment) view.getTag();
            baseFragment.onPause();
            baseFragment.onFragmentDestroy();
            SearchContainerFragment.this.tabListObject.fragmentSparseArray.delete(i);
            viewGroup.removeView(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return SearchContainerFragment.this.tabListObject.tabNames.size();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TabListObject tabListObject = this.tabListObject;
        if (tabListObject == null || tabListObject.fragmentSparseArray == null) {
            return;
        }
        for (int i = 0; i < this.tabListObject.fragmentSparseArray.size(); i++) {
            BaseFragment baseFragment = this.tabListObject.fragmentSparseArray.get(this.tabListObject.fragmentSparseArray.keyAt(i));
            if (baseFragment != null) {
                baseFragment.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.isOneTimePaused = true;
        BaseFragment baseFragment = this.selectedFragment;
        if (baseFragment != null) {
            baseFragment.onPause();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        TabListObject tabListObject = this.tabListObject;
        if (tabListObject == null || tabListObject.fragmentSparseArray == null) {
            return;
        }
        for (int i = 0; i < this.tabListObject.fragmentSparseArray.size(); i++) {
            BaseFragment baseFragment = this.tabListObject.fragmentSparseArray.get(this.tabListObject.fragmentSparseArray.keyAt(i));
            if (baseFragment != null) {
                baseFragment.onFragmentDestroy();
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        BaseFragment baseFragment = this.selectedFragment;
        if (baseFragment != null) {
            baseFragment.onResume();
        }
        this.searchEditText.clearFocus();
        this.clearSearchBarIcon.requestFocus();
    }
}
