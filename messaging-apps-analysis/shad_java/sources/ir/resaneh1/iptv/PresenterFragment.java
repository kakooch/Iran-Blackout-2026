package ir.resaneh1.iptv;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.helper.RtlGridLayoutManager;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.LoadMoreItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.LoadMorePresenter;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarMaker;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class PresenterFragment extends BaseFragment {
    public FrameLayout frameLayout;
    public LinearLayout headerContainer;
    public boolean isNeedLifecycleObservable;
    public Call lastLoadItemCall;
    private BehaviorSubject<LifeCycleState> lifecycleSubject;
    public LinearLayout linearLayout;
    public LinearLayoutManager linearLayoutManager;
    public ListInput listInput;
    public LoadMoreItem loadMoreItem;
    public Context mContext;
    public MainAdapter mainAdapter;
    public RecyclerView mainRecyclerView;
    public View notFoundLayout;
    public ItemListRequest.Listener onItemLoadedListener;
    public BaseFragment parentBaseFragmet;
    public View progressBar;
    public View retryButton;
    public View retryLayout;
    public View toolbarContainer;
    public ToolbarMaker toolbarMaker;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    public ArrayList<PresenterItem> mainArrayList = new ArrayList<>();
    public boolean refreshOnResume = false;
    public int itemCount = 0;
    public String max_id = BuildConfig.FLAVOR;
    public String min_id = BuildConfig.FLAVOR;
    protected boolean isStopLoading = false;
    public LoadMoreItem.LoadMoreType loadMoreType = LoadMoreItem.LoadMoreType.moreIcon;
    public String fragmentDebugName = BuildConfig.FLAVOR;
    View.OnClickListener onLoadMoreClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.PresenterFragment.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoadMorePresenter.ViewHolder viewHolder = (LoadMorePresenter.ViewHolder) view.getTag();
            ((LoadMoreItem) viewHolder.item).isLoading = true;
            LoadMorePresenter.refresh(viewHolder);
            PresenterFragment.this.onLoadMoreItemClicked();
        }
    };

    public enum LifeCycleState {
        pause,
        resume,
        destroy,
        dialogShow,
        dialogDismissed,
        lowMemory
    }

    public int getLayoutId() {
        return R.layout.presenter_fragment;
    }

    protected void setRetryLayout() {
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public Context getContext() {
        BaseFragment baseFragment;
        Context context = super.getContext();
        if (context == null && (baseFragment = this.parentBaseFragmet) != null) {
            context = baseFragment.getContext();
        }
        if (context == null) {
            context = this.mContext;
        }
        return context == null ? ApplicationLoader.applicationActivity : context;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) null, false);
        this.fragmentView = viewInflate;
        viewInflate.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.resaneh1.iptv.PresenterFragment.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        findView();
        init();
        return this.fragmentView;
    }

    public <T extends View> T findViewById(int i) {
        return (T) this.fragmentView.findViewById(i);
    }

    protected void findView() {
        this.mainRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        View viewFindViewById = findViewById(R.id.progressBarContainer);
        this.progressBar = viewFindViewById;
        if (viewFindViewById != null) {
            if (ApplicationLoader.applicationActivity != null) {
                UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, (FrameLayout) this.progressBar, 32);
            }
        } else {
            this.progressBar = findViewById(R.id.progressBar);
        }
        this.notFoundLayout = findViewById(R.id.notFoundLayout);
        this.headerContainer = (LinearLayout) findViewById(R.id.headerContainer);
        this.linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        this.toolbarContainer = findViewById(R.id.toolbar);
        this.frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        View viewFindViewById2 = findViewById(R.id.retryLayout);
        this.retryLayout = viewFindViewById2;
        if (viewFindViewById2 != null) {
            this.retryButton = viewFindViewById2.findViewById(R.id.button);
        }
    }

    protected void setNotFoundLayout() {
        ArrayList<PresenterItem> arrayList = this.mainArrayList;
        if (arrayList != null) {
            arrayList.clear();
            MainAdapter mainAdapter = this.mainAdapter;
            if (mainAdapter != null) {
                mainAdapter.notifyDataSetChanged();
            }
        }
        View view = this.notFoundLayout;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    protected void showRetryLayout() {
        this.isStopLoading = false;
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.retryLayout;
        if (view2 != null) {
            view2.setVisibility(0);
            View view3 = this.retryButton;
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.PresenterFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        this.f$0.lambda$showRetryLayout$0(view4);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRetryLayout$0(View view) {
        this.retryLayout.setVisibility(4);
        retryCall();
    }

    public void retryCall() {
        this.retryLayout.setVisibility(4);
    }

    protected void init() {
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
        View view = this.retryLayout;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.notFoundLayout;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        this.mainArrayList = new ArrayList<>();
        MyLog.e("PresenterFragment", "init: " + this.toolbarContainer);
        ToolbarMaker toolbarMaker = new ToolbarMaker((Activity) this.mContext, this.toolbarContainer);
        this.toolbarMaker = toolbarMaker;
        toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, BuildConfig.FLAVOR);
        this.isStopLoading = false;
        this.loadMoreItem = new LoadMoreItem(this.onLoadMoreClickListener, this.loadMoreType);
    }

    protected void initWithVerticalLinearLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 1, false);
        this.linearLayoutManager = linearLayoutManager;
        this.mainRecyclerView.setLayoutManager(linearLayoutManager);
    }

    protected void initWithHorizontallLinearLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 0, false);
        this.linearLayoutManager = linearLayoutManager;
        this.mainRecyclerView.setLayoutManager(linearLayoutManager);
    }

    protected void initWithRtlGridLayout(int i, int i2) {
        float f = i2;
        int iCalculateNoOfColumns = DimensionHelper.calculateNoOfColumns(this.mContext, AndroidUtilities.dp(f) + i);
        int iCalculateSpaceBasedOnColumns = DimensionHelper.calculateSpaceBasedOnColumns(this.mContext, i + AndroidUtilities.dp(f)) - AndroidUtilities.dp(f);
        RtlGridLayoutManager rtlGridLayoutManager = new RtlGridLayoutManager(this.mContext, iCalculateNoOfColumns);
        this.mainRecyclerView.setPadding(0, 0, (iCalculateSpaceBasedOnColumns / 2) + AndroidUtilities.dp(f), 0);
        this.mainRecyclerView.setLayoutManager(rtlGridLayoutManager);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.isNeedLifecycleObservable) {
            getLifecycle().onNext(LifeCycleState.resume);
        }
    }

    protected void loadItems() {
        Call call = this.lastLoadItemCall;
        if (call != null) {
            call.cancel();
        }
        ListInput listInput = this.listInput;
        if (listInput != null) {
            if (!this.isStopLoading) {
                this.isStopLoading = true;
                listInput.max_id = this.max_id;
                listInput.min_id = this.min_id;
                MainAdapter mainAdapter = this.mainAdapter;
                if (mainAdapter != null) {
                    listInput.first_index = (this.itemCount + 1) - mainAdapter.biasFromFirst;
                }
                listInput.last_index = listInput.limit + listInput.first_index;
                if (!mainAdapter.isLoadMoreAuto) {
                    setLoadMoreItemLoading(true);
                }
                this.lastLoadItemCall = new ItemListRequest().load(this.mContext, this.listInput, new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.PresenterFragment.2
                    @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
                    public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                        PresenterFragment presenterFragment = PresenterFragment.this;
                        presenterFragment.lastLoadItemCall = null;
                        presenterFragment.progressBar.setVisibility(4);
                        View view = PresenterFragment.this.retryLayout;
                        if (view != null) {
                            view.setVisibility(4);
                        }
                        ItemListRequest.Listener listener = PresenterFragment.this.onItemLoadedListener;
                        if (listener != null) {
                            listener.onResponse(arrayList, getListOutput);
                        }
                        PresenterFragment.this.removeLoadMoreItemIfNeeded();
                        PresenterFragment.this.addItemsToAdapter(arrayList);
                        if (arrayList.size() > 0) {
                            PresenterFragment.this.isStopLoading = false;
                        } else {
                            PresenterFragment.this.removeLoadMoreItemIfNeeded();
                        }
                        if (PresenterFragment.this.mainArrayList.size() <= 0) {
                            PresenterFragment.this.setNotFoundLayout();
                        }
                    }

                    @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
                    public void onFailure(Throwable th) {
                        PresenterFragment.this.progressBar.setVisibility(4);
                        View view = PresenterFragment.this.retryLayout;
                        if (view != null) {
                            view.setVisibility(4);
                        }
                        if (PresenterFragment.this.mainArrayList.size() <= 0) {
                            PresenterFragment.this.setRetryLayout();
                        }
                        PresenterFragment.this.setLoadMoreItemLoading(false);
                        PresenterFragment presenterFragment = PresenterFragment.this;
                        presenterFragment.isStopLoading = true;
                        ItemListRequest.Listener listener = presenterFragment.onItemLoadedListener;
                        if (listener != null) {
                            listener.onFailure(th);
                        }
                    }
                });
                return;
            }
            this.progressBar.setVisibility(4);
            return;
        }
        this.progressBar.setVisibility(4);
    }

    public void onLoadMoreItemClicked() {
        this.isStopLoading = false;
        loadItems();
    }

    public void removeLoadMoreItemIfNeeded() {
        if (this.mainArrayList.size() > 0) {
            if (this.mainArrayList.get(r0.size() - 1).getPresenterType() == PresenterItemType.loadMore) {
                this.mainArrayList.remove(r0.size() - 1);
                MainAdapter mainAdapter = this.mainAdapter;
                if (mainAdapter != null) {
                    mainAdapter.notifyItemRemoved(this.mainArrayList.size());
                }
            }
        }
    }

    public void addLoadMoreItem(boolean z) {
        LoadMoreItem loadMoreItem = new LoadMoreItem(this.onLoadMoreClickListener, this.loadMoreType);
        this.loadMoreItem = loadMoreItem;
        loadMoreItem.isLoading = z;
        this.mainArrayList.add(loadMoreItem);
        this.mainAdapter.notifyItemChanged(this.mainArrayList.size() - 1);
    }

    public void setLoadMoreItemLoading(boolean z) {
        if (this.mainArrayList.size() > 0) {
            if (this.mainArrayList.get(r0.size() - 1).getPresenterType() == PresenterItemType.loadMore) {
                this.loadMoreItem.isLoading = z;
                this.mainAdapter.notifyItemChanged(this.mainArrayList.size() - 1);
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            PlayerPresenter.lastPlayerHolder.playerFragment.onConfigurationChanged(configuration);
        } catch (Exception e) {
            MyLog.e("PresenterFragment", "onConfigurationChanged: " + e.getMessage() + BuildConfig.FLAVOR);
        }
        MyLog.e("PresenterFragment", "onConfigurationChanged: ");
    }

    public void addItemsToAdapter(ArrayList<? extends PresenterItem> arrayList) {
        this.mainRecyclerView.stopScroll();
        if (!this.mainAdapter.isWantLoadMore) {
            this.mainArrayList.clear();
            this.mainAdapter.notifyDataSetChanged();
        }
        this.itemCount += arrayList.size();
        if (arrayList.size() > 0 && arrayList.get(arrayList.size() - 1) != null) {
            this.max_id = arrayList.get(arrayList.size() - 1).getPresenterId();
            this.min_id = arrayList.get(arrayList.size() - 1).getPresenterId();
        }
        this.mainArrayList.addAll(arrayList);
        int size = arrayList.size();
        MainAdapter mainAdapter = this.mainAdapter;
        if (mainAdapter.isWantLoadMore) {
            if (mainAdapter.isLoadMoreAuto) {
                addLoadMoreItem(true);
            } else {
                addLoadMoreItem(false);
            }
            size++;
        }
        this.mainAdapter.notifyItemRangeChanged(this.mainArrayList.size() - size, size);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean presentFragment(BaseFragment baseFragment) {
        try {
            if (super.presentFragment(baseFragment)) {
                return true;
            }
            return this.parentBaseFragmet.presentFragment(baseFragment);
        } catch (Exception unused) {
            boolean z = MyLog.isDebugAble;
            try {
                return this.parentBaseFragmet.presentFragment(baseFragment);
            } catch (Exception unused2) {
                return false;
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        if (this.isNeedLifecycleObservable) {
            getLifecycle().onNext(LifeCycleState.destroy);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        PlayerBaseFragment playerBaseFragment;
        PlayerPresenter.MyViewHolder myViewHolder = PlayerPresenter.lastPlayerHolder;
        if (myViewHolder == null || (playerBaseFragment = myViewHolder.playerFragment) == null || playerBaseFragment == null || !playerBaseFragment.consumeBackPress()) {
            return super.onBackPressed();
        }
        return false;
    }

    public boolean isPortrait() {
        return this.mContext.getResources().getConfiguration().orientation == 1;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public Dialog showDialog(Dialog dialog) {
        if (this.isNeedLifecycleObservable) {
            getLifecycle().onNext(LifeCycleState.dialogShow);
            return super.showDialog(dialog, new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.PresenterFragment.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    PresenterFragment.this.getLifecycle().onNext(LifeCycleState.dialogDismissed);
                }
            });
        }
        return super.showDialog(dialog);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        if (this.isNeedLifecycleObservable) {
            getLifecycle().onNext(LifeCycleState.pause);
        }
        super.onPause();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onLowMemory() {
        super.onLowMemory();
        if (this.isNeedLifecycleObservable) {
            getLifecycle().onNext(LifeCycleState.lowMemory);
        }
    }

    public BehaviorSubject<LifeCycleState> getLifecycle() {
        if (this.lifecycleSubject == null) {
            this.lifecycleSubject = BehaviorSubject.create();
        }
        return this.lifecycleSubject;
    }
}
