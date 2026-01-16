package ir.resaneh1.iptv.presenter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelectorSecond;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    public int biasFromFirst;
    private CompositeDisposable disposable;
    public boolean isLoadMoreAuto;
    public boolean isMultiSelection;
    public boolean isSavePosition;
    public boolean isSaveSelected;
    public boolean isWantLoadMore;
    public ArrayList<? extends PresenterItem> itemArrayList;
    public ArrayList<? extends PresenterItem> itemArrayListOriginal;
    public HashMap<String, PresenterItem> itemSelectedMap;
    public int lastSelectedPosition;
    private BehaviorSubject<PresenterFragment.LifeCycleState> lifecycleSubject;
    public OnPresenterItemClickListener mClickListener;
    public Context mContext;
    public OnPresenterItemClickListener mLongClickListener;
    public View.OnClickListener onClickListener;
    public OnLoadMoreListener onLoadMoreListener;
    View.OnLongClickListener onLongClickListener;
    public PresenterSelector presenterSelector;
    public PresenterSelectorSecond presenterSelectorSecond;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public MainAdapter(Context context, ArrayList<? extends PresenterItem> arrayList, PresenterSelector presenterSelector, OnPresenterItemClickListener onPresenterItemClickListener, OnLoadMoreListener onLoadMoreListener) {
        this.itemSelectedMap = new HashMap<>();
        this.lastSelectedPosition = -1;
        this.isSaveSelected = false;
        this.isMultiSelection = false;
        this.isSavePosition = false;
        this.biasFromFirst = 0;
        this.isLoadMoreAuto = true;
        this.isWantLoadMore = true;
        this.disposable = new CompositeDisposable();
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenter.adapter.MainAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractPresenter.AbstractViewHolder abstractViewHolder = (AbstractPresenter.AbstractViewHolder) view.getTag();
                MainAdapter mainAdapter = MainAdapter.this;
                if (mainAdapter.isSaveSelected) {
                    if (mainAdapter.lastSelectedPosition < 0) {
                        int i = 0;
                        while (true) {
                            if (i >= MainAdapter.this.itemArrayListOriginal.size()) {
                                break;
                            }
                            if (MainAdapter.this.itemArrayListOriginal.get(i).presenterIsSelected) {
                                MainAdapter.this.lastSelectedPosition = i;
                                break;
                            }
                            i++;
                        }
                    }
                    MainAdapter mainAdapter2 = MainAdapter.this;
                    if (mainAdapter2.lastSelectedPosition < 0) {
                        mainAdapter2.lastSelectedPosition = 0;
                    }
                    int size = mainAdapter2.itemArrayList.size();
                    MainAdapter mainAdapter3 = MainAdapter.this;
                    int i2 = mainAdapter3.lastSelectedPosition;
                    if (size > i2 && !mainAdapter3.isMultiSelection) {
                        mainAdapter3.itemArrayList.get(i2).presenterIsSelected = false;
                        MainAdapter mainAdapter4 = MainAdapter.this;
                        mainAdapter4.notifyItemChanged(mainAdapter4.lastSelectedPosition);
                    }
                    MainAdapter mainAdapter5 = MainAdapter.this;
                    if (!mainAdapter5.isMultiSelection) {
                        abstractViewHolder.item.presenterIsSelected = true;
                    } else if (!mainAdapter5.itemSelectedMap.containsKey(abstractViewHolder.item.getIdentitySrting())) {
                        MainAdapter.this.itemSelectedMap.put(abstractViewHolder.item.getIdentitySrting(), abstractViewHolder.item);
                        abstractViewHolder.item.presenterIsSelected = true;
                    } else {
                        MainAdapter.this.itemSelectedMap.remove(abstractViewHolder.item.getIdentitySrting());
                        abstractViewHolder.item.presenterIsSelected = false;
                    }
                    MainAdapter mainAdapter6 = MainAdapter.this;
                    mainAdapter6.lastSelectedPosition = mainAdapter6.itemArrayList.indexOf(abstractViewHolder.item);
                    MainAdapter mainAdapter7 = MainAdapter.this;
                    mainAdapter7.notifyItemChanged(mainAdapter7.lastSelectedPosition);
                }
                OnPresenterItemClickListener onPresenterItemClickListener2 = MainAdapter.this.mClickListener;
                if (onPresenterItemClickListener2 != null) {
                    onPresenterItemClickListener2.onClick(abstractViewHolder);
                }
            }
        };
        this.onLongClickListener = new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.presenter.adapter.MainAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AbstractPresenter.AbstractViewHolder abstractViewHolder = (AbstractPresenter.AbstractViewHolder) view.getTag();
                OnPresenterItemClickListener onPresenterItemClickListener2 = MainAdapter.this.mLongClickListener;
                if (onPresenterItemClickListener2 == null) {
                    return true;
                }
                onPresenterItemClickListener2.onClick(abstractViewHolder);
                return true;
            }
        };
        this.presenterSelector = presenterSelector;
        this.presenterSelectorSecond = null;
        this.itemArrayList = arrayList;
        this.itemArrayListOriginal = arrayList;
        this.mContext = context;
        this.mClickListener = onPresenterItemClickListener;
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public MainAdapter(Context context, ArrayList<? extends PresenterItem> arrayList, PresenterSelector presenterSelector, PresenterSelectorSecond presenterSelectorSecond, OnPresenterItemClickListener onPresenterItemClickListener, OnLoadMoreListener onLoadMoreListener) {
        this.itemSelectedMap = new HashMap<>();
        this.lastSelectedPosition = -1;
        this.isSaveSelected = false;
        this.isMultiSelection = false;
        this.isSavePosition = false;
        this.biasFromFirst = 0;
        this.isLoadMoreAuto = true;
        this.isWantLoadMore = true;
        this.disposable = new CompositeDisposable();
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenter.adapter.MainAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractPresenter.AbstractViewHolder abstractViewHolder = (AbstractPresenter.AbstractViewHolder) view.getTag();
                MainAdapter mainAdapter = MainAdapter.this;
                if (mainAdapter.isSaveSelected) {
                    if (mainAdapter.lastSelectedPosition < 0) {
                        int i = 0;
                        while (true) {
                            if (i >= MainAdapter.this.itemArrayListOriginal.size()) {
                                break;
                            }
                            if (MainAdapter.this.itemArrayListOriginal.get(i).presenterIsSelected) {
                                MainAdapter.this.lastSelectedPosition = i;
                                break;
                            }
                            i++;
                        }
                    }
                    MainAdapter mainAdapter2 = MainAdapter.this;
                    if (mainAdapter2.lastSelectedPosition < 0) {
                        mainAdapter2.lastSelectedPosition = 0;
                    }
                    int size = mainAdapter2.itemArrayList.size();
                    MainAdapter mainAdapter3 = MainAdapter.this;
                    int i2 = mainAdapter3.lastSelectedPosition;
                    if (size > i2 && !mainAdapter3.isMultiSelection) {
                        mainAdapter3.itemArrayList.get(i2).presenterIsSelected = false;
                        MainAdapter mainAdapter4 = MainAdapter.this;
                        mainAdapter4.notifyItemChanged(mainAdapter4.lastSelectedPosition);
                    }
                    MainAdapter mainAdapter5 = MainAdapter.this;
                    if (!mainAdapter5.isMultiSelection) {
                        abstractViewHolder.item.presenterIsSelected = true;
                    } else if (!mainAdapter5.itemSelectedMap.containsKey(abstractViewHolder.item.getIdentitySrting())) {
                        MainAdapter.this.itemSelectedMap.put(abstractViewHolder.item.getIdentitySrting(), abstractViewHolder.item);
                        abstractViewHolder.item.presenterIsSelected = true;
                    } else {
                        MainAdapter.this.itemSelectedMap.remove(abstractViewHolder.item.getIdentitySrting());
                        abstractViewHolder.item.presenterIsSelected = false;
                    }
                    MainAdapter mainAdapter6 = MainAdapter.this;
                    mainAdapter6.lastSelectedPosition = mainAdapter6.itemArrayList.indexOf(abstractViewHolder.item);
                    MainAdapter mainAdapter7 = MainAdapter.this;
                    mainAdapter7.notifyItemChanged(mainAdapter7.lastSelectedPosition);
                }
                OnPresenterItemClickListener onPresenterItemClickListener2 = MainAdapter.this.mClickListener;
                if (onPresenterItemClickListener2 != null) {
                    onPresenterItemClickListener2.onClick(abstractViewHolder);
                }
            }
        };
        this.onLongClickListener = new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.presenter.adapter.MainAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AbstractPresenter.AbstractViewHolder abstractViewHolder = (AbstractPresenter.AbstractViewHolder) view.getTag();
                OnPresenterItemClickListener onPresenterItemClickListener2 = MainAdapter.this.mLongClickListener;
                if (onPresenterItemClickListener2 == null) {
                    return true;
                }
                onPresenterItemClickListener2.onClick(abstractViewHolder);
                return true;
            }
        };
        this.presenterSelector = presenterSelector;
        this.presenterSelectorSecond = presenterSelectorSecond;
        this.itemArrayList = arrayList;
        this.itemArrayListOriginal = arrayList;
        this.mContext = context;
        this.mClickListener = onPresenterItemClickListener;
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public AbstractPresenter getPresenter(int i) {
        PresenterSelector presenterSelector;
        PresenterSelectorSecond presenterSelectorSecond = this.presenterSelectorSecond;
        AbstractPresenter presenter = presenterSelectorSecond != null ? presenterSelectorSecond.getPresenter(i) : null;
        return (presenter != null || (presenterSelector = this.presenterSelector) == null) ? presenter : presenterSelector.getPresenter(PresenterItemType.values()[i]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        AbstractPresenter.AbstractViewHolder abstractViewHolder = (AbstractPresenter.AbstractViewHolder) viewHolder;
        getPresenter(abstractViewHolder.item.getPresenterItemTypeInt()).onViewRecycled(abstractViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractPresenter.AbstractViewHolder abstractViewHolderOnCreateViewHolder = getPresenter(i).onCreateViewHolder(viewGroup);
        abstractViewHolderOnCreateViewHolder.itemView.setOnClickListener(this.onClickListener);
        abstractViewHolderOnCreateViewHolder.itemView.setOnLongClickListener(this.onLongClickListener);
        return abstractViewHolderOnCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        this.itemArrayList.get(i).presenterPosition = i;
        if (this.isMultiSelection) {
            this.itemArrayList.get(i).presenterIsSelected = this.itemSelectedMap.containsKey(this.itemArrayList.get(i).getIdentitySrting());
        }
        getPresenter(this.itemArrayList.get(i).getPresenterItemTypeInt()).onBindViewHolder((AbstractPresenter.AbstractViewHolder) viewHolder, this.itemArrayList.get(i));
        if (this.isLoadMoreAuto && this.isWantLoadMore && this.onLoadMoreListener != null && i == getItemCount() - 1) {
            MyLog.e("position", "position" + i);
            this.onLoadMoreListener.loadMore((i + 1) - this.biasFromFirst);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.itemArrayList.get(i).getPresenterItemTypeInt();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<? extends PresenterItem> arrayList = this.itemArrayList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: ir.resaneh1.iptv.presenter.adapter.MainAdapter.3
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                if (charSequence != null) {
                    Iterator<? extends PresenterItem> it = MainAdapter.this.itemArrayListOriginal.iterator();
                    while (it.hasNext()) {
                        PresenterItem next = it.next();
                        if (next.getSearchAbleName().toLowerCase().contains(charSequence.toString())) {
                            arrayList.add(next);
                        }
                    }
                }
                filterResults.values = arrayList;
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                MainAdapter mainAdapter = MainAdapter.this;
                mainAdapter.itemArrayList = (ArrayList) filterResults.values;
                mainAdapter.notifyDataSetChanged();
            }
        };
    }

    public BehaviorSubject<PresenterFragment.LifeCycleState> getLifecycle() {
        if (this.lifecycleSubject == null) {
            this.lifecycleSubject = BehaviorSubject.create();
        }
        return this.lifecycleSubject;
    }

    public void setParentLifeCycleObservable(BehaviorSubject<PresenterFragment.LifeCycleState> behaviorSubject) {
        this.disposable.add((DisposableObserver) behaviorSubject.subscribeWith(new DisposableObserver<PresenterFragment.LifeCycleState>() { // from class: ir.resaneh1.iptv.presenter.adapter.MainAdapter.4
            @Override // io.reactivex.Observer
            public void onNext(PresenterFragment.LifeCycleState lifeCycleState) {
                MainAdapter.this.getLifecycle().onNext(lifeCycleState);
                if (lifeCycleState == PresenterFragment.LifeCycleState.destroy) {
                    MainAdapter.this.disposable.dispose();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                MainAdapter.this.getLifecycle().onError(th);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                MainAdapter.this.getLifecycle().onComplete();
            }
        }));
    }
}
