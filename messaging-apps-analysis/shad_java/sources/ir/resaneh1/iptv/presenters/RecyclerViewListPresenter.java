package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.banner.RecyclerInfiniteAdapter;
import ir.resaneh1.iptv.fragment.DynamicPageFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.ItemDecorationForGridLayout;
import ir.resaneh1.iptv.helper.ItemDecorationForHorizontal;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.LoadMoreItem;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.model.ViewTagObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class RecyclerViewListPresenter extends AbstractPresenter<RecyclerViewListObject, MyViewHolder> {
    public LoadMoreItem.LoadMoreType loadMoreType;
    private Context mContext;
    public String max_id;
    public String min_id;
    View.OnClickListener onMoreTextClickListener;

    public RecyclerViewListPresenter(Context context) {
        super(context);
        this.loadMoreType = LoadMoreItem.LoadMoreType.moreIcon;
        this.max_id = BuildConfig.FLAVOR;
        this.min_id = BuildConfig.FLAVOR;
        this.onMoreTextClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                Titem titem = myViewHolder.item;
                if (((RecyclerViewListObject) titem).onMoreTextClickListener != null) {
                    ((RecyclerViewListObject) titem).onMoreTextClickListener.onClick(myViewHolder);
                }
            }
        };
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onViewRecycled(MyViewHolder myViewHolder) {
        super.onViewRecycled((RecyclerViewListPresenter) myViewHolder);
        MyLog.e("RecyclerViewListPresenter", "onViewRecycled");
        myViewHolder.getLifecycle().onNext(PresenterFragment.LifeCycleState.destroy);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_recyclerview_list, viewGroup, false));
        if (viewGroup instanceof RecyclerView) {
            MainAdapter mainAdapter = (MainAdapter) ((RecyclerView) viewGroup).getAdapter();
            myViewHolder.disposable = new CompositeDisposable();
            myViewHolder.setParentLifeCycleObservable(mainAdapter.getLifecycle());
        }
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final RecyclerViewListObject recyclerViewListObject) {
        ViewTagObject viewTagObject;
        TagObject tagObject;
        super.onBindViewHolder((RecyclerViewListPresenter) myViewHolder, (MyViewHolder) recyclerViewListObject);
        myViewHolder.getLifecycle().onNext(PresenterFragment.LifeCycleState.resume);
        recyclerViewListObject.holder = myViewHolder;
        if (recyclerViewListObject.listInput != null) {
            myViewHolder.titleTextView.setText(recyclerViewListObject.listInput.title);
        }
        if (((RecyclerViewListObject) myViewHolder.item).hasMoreText) {
            myViewHolder.moreTextView.setVisibility(0);
            myViewHolder.imageViewMore.setVisibility(0);
            myViewHolder.moreTextView.setTag(myViewHolder);
            myViewHolder.moreTextView.setOnClickListener(this.onMoreTextClickListener);
        } else {
            myViewHolder.moreTextView.setVisibility(8);
            myViewHolder.imageViewMore.setVisibility(8);
        }
        if (!((RecyclerViewListObject) myViewHolder.item).hastTitle) {
            myViewHolder.moreTextView.setVisibility(4);
            myViewHolder.imageViewMore.setVisibility(4);
            myViewHolder.titleTextView.setVisibility(4);
            ((FrameLayout.LayoutParams) myViewHolder.recyclerView.getLayoutParams()).setMargins(0, 0, 0, 0);
        } else {
            myViewHolder.titleTextView.setVisibility(0);
            ((FrameLayout.LayoutParams) myViewHolder.recyclerView.getLayoutParams()).setMargins(0, AndroidUtilities.dp(40.0f), 0, 0);
        }
        if (recyclerViewListObject.isGrid) {
            setLayout(myViewHolder);
            myViewHolder.itemView.setMinimumHeight(recyclerViewListObject.getItemHeight());
        } else {
            if (recyclerViewListObject.isVertical) {
                initWithVerticalLinearLayoutManager(myViewHolder.recyclerView);
                myViewHolder.recyclerView.setPadding(0, 0, 0, 0);
            } else {
                initWithHorizontalLinearLayoutManager(myViewHolder.recyclerView);
                myViewHolder.recyclerView.setPadding(AndroidUtilities.dp(48.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), 0);
            }
            ListInput listInput = recyclerViewListObject.listInput;
            float f = listInput.itemType == ListInput.ItemType.viewTag ? 8.0f + (listInput.viewTagObject.view.row_space * 100.0f) : 8.0f;
            int paddingTop = myViewHolder.recyclerView.getPaddingTop();
            myViewHolder.recyclerView.getLayoutParams().height = recyclerViewListObject.getItemHeight() + AndroidUtilities.dp(f) + paddingTop;
            myViewHolder.recyclerView.setMinimumHeight(recyclerViewListObject.getItemHeight() + AndroidUtilities.dp(f) + paddingTop);
            myViewHolder.recyclerView.getLayoutParams().width = -1;
            myViewHolder.recyclerView.scrollToPosition(recyclerViewListObject.getLastPosition());
            myViewHolder.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    ((RecyclerViewListObject) myViewHolder.item).setLastPosition(((LinearLayoutManager) myViewHolder.recyclerView.getLayoutManager()).findFirstVisibleItemPosition());
                }
            });
        }
        MyLog.e("RecyclerPresenter", "onBindViewHolder: ");
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                if (recyclerViewListObject.hasLoadMore) {
                    RecyclerViewListPresenter.this.loadItems(myViewHolder);
                }
            }
        };
        final ViewGroupCellPresenter viewGroupCellPresenter = null;
        ListInput listInput2 = recyclerViewListObject.listInput;
        boolean z = true;
        if (listInput2 != null && listInput2.itemType == ListInput.ItemType.tag && (tagObject = listInput2.tagObject) != null && tagObject.type == TagObject.TagType.dynamicView && tagObject.viewObject != null) {
            viewGroupCellPresenter = new ViewGroupCellPresenter(this, this.mContext, z, recyclerViewListObject.listInput.tagObject.viewObject) { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.3
            };
        }
        ListInput listInput3 = recyclerViewListObject.listInput;
        if (listInput3 != null && listInput3.itemType == ListInput.ItemType.viewTag && (viewTagObject = listInput3.viewTagObject) != null && viewTagObject.view != null) {
            viewGroupCellPresenter = new ViewGroupCellPresenter(this.mContext, true, recyclerViewListObject.listInput.viewTagObject.view);
            BaseFragment baseFragment = recyclerViewListObject.baseFragment;
            if (baseFragment instanceof PresenterFragment) {
            }
            if (baseFragment instanceof DynamicPageFragment) {
                viewGroupCellPresenter.dynamicPageFragment = (DynamicPageFragment) baseFragment;
            }
        }
        MainAdapter mainAdapter = new MainAdapter(this.mContext, recyclerViewListObject.list, new PresenterSelector(this) { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.4
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                ViewGroupCellPresenter viewGroupCellPresenter2;
                return (presenterItemType != PresenterItemType.viewDataObject || (viewGroupCellPresenter2 = viewGroupCellPresenter) == null) ? recyclerViewListObject.presenterSelector.getPresenter(presenterItemType) : viewGroupCellPresenter2;
            }
        }, recyclerViewListObject.onPresenterItemClickListener, onLoadMoreListener);
        mainAdapter.isSaveSelected = recyclerViewListObject.isSaveSelected;
        mainAdapter.isLoadMoreAuto = true;
        mainAdapter.isWantLoadMore = recyclerViewListObject.hasLoadMore;
        if (myViewHolder.lifecycleSubject != null) {
            mainAdapter.setParentLifeCycleObservable(myViewHolder.lifecycleSubject);
        }
        if (recyclerViewListObject.isLoop) {
            myViewHolder.recyclerView.setAdapter(new RecyclerInfiniteAdapter(mainAdapter));
        } else {
            myViewHolder.recyclerView.setAdapter(mainAdapter);
        }
        Titem titem = myViewHolder.item;
        if (((RecyclerViewListObject) titem).list == null || ((RecyclerViewListObject) titem).list.size() <= 0) {
            if (mainAdapter.isWantLoadMore) {
                if (mainAdapter.isLoadMoreAuto) {
                    addLoadMoreItem(true, myViewHolder);
                } else {
                    addLoadMoreItem(false, myViewHolder);
                }
            }
            myViewHolder.recyclerView.getAdapter().notifyDataSetChanged();
            loadItems(myViewHolder);
        } else if (((RecyclerViewListObject) myViewHolder.item).list != null) {
            myViewHolder.recyclerView.getAdapter().notifyDataSetChanged();
        }
        for (int itemDecorationCount = myViewHolder.recyclerView.getItemDecorationCount() - 1; itemDecorationCount >= 0; itemDecorationCount--) {
            myViewHolder.recyclerView.removeItemDecorationAt(itemDecorationCount);
        }
        if (((RecyclerViewListObject) myViewHolder.item).decorationSize > 0) {
            myViewHolder.recyclerView.addItemDecoration(new ItemDecorationForHorizontal(AndroidUtilities.dp(((RecyclerViewListObject) r12).decorationSize)));
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<RecyclerViewListObject> {
        private Disposable disposable;
        private View imageViewMore;
        private BehaviorSubject<PresenterFragment.LifeCycleState> lifecycleSubject;
        private TextView moreTextView;
        public RecyclerView recyclerView;
        private TextView titleTextView;

        public MyViewHolder(RecyclerViewListPresenter recyclerViewListPresenter, View view) {
            super(view);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            this.titleTextView = (TextView) view.findViewById(R.id.textView);
            this.moreTextView = (TextView) view.findViewById(R.id.textViewMore);
            this.imageViewMore = view.findViewById(R.id.imageViewMore);
        }

        public BehaviorSubject<PresenterFragment.LifeCycleState> getLifecycle() {
            if (this.lifecycleSubject == null) {
                this.lifecycleSubject = BehaviorSubject.create();
            }
            return this.lifecycleSubject;
        }

        public void setParentLifeCycleObservable(BehaviorSubject<PresenterFragment.LifeCycleState> behaviorSubject) {
            this.disposable = (Disposable) behaviorSubject.subscribeWith(new DisposableObserver<PresenterFragment.LifeCycleState>() { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.MyViewHolder.1
                @Override // io.reactivex.Observer
                public void onNext(PresenterFragment.LifeCycleState lifeCycleState) {
                    MyViewHolder.this.getLifecycle().onNext(lifeCycleState);
                    if (lifeCycleState == PresenterFragment.LifeCycleState.destroy) {
                        MyViewHolder.this.disposable.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    MyViewHolder.this.getLifecycle().onError(th);
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    MyViewHolder.this.getLifecycle().onComplete();
                }
            });
        }

        public TextView getTitleTextView() {
            return this.titleTextView;
        }
    }

    protected void loadItems(final MyViewHolder myViewHolder) {
        final RecyclerViewListObject recyclerViewListObject = (RecyclerViewListObject) myViewHolder.item;
        MyLog.e("RecyclerPresenter", "loadItems: ");
        MainAdapter mainAdapter = (MainAdapter) myViewHolder.recyclerView.getAdapter();
        if (recyclerViewListObject.listInput == null || recyclerViewListObject.isStopLoading) {
            return;
        }
        MyLog.e("RecyclerPresenter", "loadItems:3 ");
        recyclerViewListObject.isStopLoading = true;
        ListInput listInput = recyclerViewListObject.listInput;
        listInput.max_id = this.max_id;
        listInput.min_id = this.min_id;
        int i = recyclerViewListObject.itemCount + 1;
        listInput.first_index = i;
        listInput.last_index = listInput.limit + i;
        if (!mainAdapter.isLoadMoreAuto && (mainAdapter.isWantLoadMore || listInput.itemType != ListInput.ItemType.array)) {
            setLoadMoreItemLoading(true, myViewHolder);
        }
        new ItemListRequest().load(this.mContext, recyclerViewListObject.listInput, new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.5
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                ItemListRequest.Listener listener = recyclerViewListObject.onItemLoadedListener;
                if (listener != null) {
                    listener.onResponse(arrayList, getListOutput);
                }
                RecyclerViewListPresenter.this.removeLoadMoreItemIfNeeded(myViewHolder);
                RecyclerViewListPresenter.this.addItemsToAdapter(arrayList, myViewHolder);
                if (arrayList.size() >= 1) {
                    recyclerViewListObject.isStopLoading = false;
                } else {
                    RecyclerViewListPresenter.this.removeLoadMoreItemIfNeeded(myViewHolder);
                }
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
                RecyclerViewListPresenter.this.setLoadMoreItemLoading(false, myViewHolder);
                ((RecyclerViewListObject) myViewHolder.item).isStopLoading = true;
                ItemListRequest.Listener listener = recyclerViewListObject.onItemLoadedListener;
                if (listener != null) {
                    listener.onFailure(th);
                }
            }
        });
    }

    protected void initWithHorizontalLinearLayoutManager(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, this.mContext, 0, true) { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.7
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView2, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView2, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
    }

    protected void initWithVerticalLinearLayoutManager(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
    }

    protected void initWithGridLayout(RecyclerView recyclerView, int i) {
        recyclerView.setLayoutManager(new GridLayoutManager(this.mContext, i));
        if (recyclerView.getItemDecorationCount() <= 0) {
            recyclerView.addItemDecoration(new ItemDecorationForGridLayout(AndroidUtilities.dp(8), i));
        }
    }

    public void setLayout(MyViewHolder myViewHolder) {
        RecyclerViewListObject recyclerViewListObject = (RecyclerViewListObject) myViewHolder.item;
        if (recyclerViewListObject.isGrid) {
            for (int i = 0; i < myViewHolder.recyclerView.getItemDecorationCount(); i++) {
                myViewHolder.recyclerView.removeItemDecorationAt(i);
            }
            Context context = this.mContext;
            initWithGridLayout(myViewHolder.recyclerView, DimensionHelper.calculateNoOfColumns(context, DimensionHelper.getItemWidth(context, recyclerViewListObject.listInput) + AndroidUtilities.dp(8.0f)));
        }
    }

    public void addItemsToAdapter(ArrayList<? extends PresenterItem> arrayList, MyViewHolder myViewHolder) {
        RecyclerViewListObject recyclerViewListObject = (RecyclerViewListObject) myViewHolder.item;
        if (recyclerViewListObject.holder.item == recyclerViewListObject) {
            myViewHolder.recyclerView.stopScroll();
            ((RecyclerViewListObject) myViewHolder.item).itemCount += arrayList.size();
            ((RecyclerViewListObject) myViewHolder.item).list.addAll(arrayList);
            int size = arrayList.size();
            MainAdapter mainAdapter = (MainAdapter) myViewHolder.recyclerView.getAdapter();
            if (mainAdapter.isWantLoadMore) {
                if (mainAdapter.isLoadMoreAuto) {
                    addLoadMoreItem(true, myViewHolder);
                } else {
                    addLoadMoreItem(false, myViewHolder);
                }
            }
            int i = size + 1;
            mainAdapter.notifyItemRangeChanged(((RecyclerViewListObject) myViewHolder.item).list.size() - i, i);
        }
    }

    public void removeLoadMoreItemIfNeeded(MyViewHolder myViewHolder) {
        Titem titem = myViewHolder.item;
        RecyclerViewListObject recyclerViewListObject = (RecyclerViewListObject) titem;
        if (recyclerViewListObject.holder.item != recyclerViewListObject || ((RecyclerViewListObject) titem).list.size() <= 0) {
            return;
        }
        if (((RecyclerViewListObject) myViewHolder.item).list.get(((RecyclerViewListObject) r0).list.size() - 1).getPresenterType() == PresenterItemType.loadMore) {
            ((RecyclerViewListObject) myViewHolder.item).list.remove(((RecyclerViewListObject) r4).list.size() - 1);
        }
    }

    public void addLoadMoreItem(boolean z, final MyViewHolder myViewHolder) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.RecyclerViewListPresenter.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder2 = myViewHolder;
                ((RecyclerViewListObject) myViewHolder2.item).isStopLoading = false;
                RecyclerViewListPresenter.this.loadItems(myViewHolder2);
            }
        };
        ((RecyclerViewListObject) myViewHolder.item).loadMoreItem = new LoadMoreItem(onClickListener, this.loadMoreType);
        Titem titem = myViewHolder.item;
        ((RecyclerViewListObject) titem).loadMoreItem.isLoading = z;
        ((RecyclerViewListObject) titem).loadMoreItem.height = DimensionHelper.getItemHeight(this.mContext, ((RecyclerViewListObject) titem).listInput);
        ((RecyclerViewListObject) myViewHolder.item).loadMoreItem.width = AndroidUtilities.dp(80.0f);
        Titem titem2 = myViewHolder.item;
        ((RecyclerViewListObject) titem2).list.add(((RecyclerViewListObject) titem2).loadMoreItem);
    }

    public void setLoadMoreItemLoading(boolean z, MyViewHolder myViewHolder) {
        if (((RecyclerViewListObject) myViewHolder.item).list.size() > 0) {
            if (((RecyclerViewListObject) myViewHolder.item).list.get(((RecyclerViewListObject) r0).list.size() - 1).getPresenterType() == PresenterItemType.loadMore) {
                ((RecyclerViewListObject) myViewHolder.item).loadMoreItem.isLoading = z;
                myViewHolder.recyclerView.getAdapter().notifyItemChanged(((RecyclerViewListObject) myViewHolder.item).list.size() - 1);
            }
        }
    }

    public void handleChangeItem(MyViewHolder myViewHolder) {
        ((MainAdapter) myViewHolder.recyclerView.getAdapter()).notifyDataSetChanged();
    }
}
