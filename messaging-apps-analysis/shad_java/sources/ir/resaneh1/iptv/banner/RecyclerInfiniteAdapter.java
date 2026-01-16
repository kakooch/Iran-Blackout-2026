package ir.resaneh1.iptv.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
public class RecyclerInfiniteAdapter extends MainAdapter {
    public View.OnClickListener onClickListener;

    @Override // ir.resaneh1.iptv.presenter.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ConnectionsManager.DEFAULT_DATACENTER_ID;
    }

    public RecyclerInfiniteAdapter(MainAdapter mainAdapter) {
        super(mainAdapter.mContext, mainAdapter.itemArrayList, mainAdapter.presenterSelector, mainAdapter.mClickListener, mainAdapter.onLoadMoreListener);
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.banner.RecyclerInfiniteAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractPresenter.AbstractViewHolder abstractViewHolder = (AbstractPresenter.AbstractViewHolder) view.getTag();
                RecyclerInfiniteAdapter recyclerInfiniteAdapter = RecyclerInfiniteAdapter.this;
                if (recyclerInfiniteAdapter.isSaveSelected) {
                    if (recyclerInfiniteAdapter.lastSelectedPosition < 0) {
                        int i = 0;
                        while (true) {
                            if (i >= RecyclerInfiniteAdapter.this.itemArrayListOriginal.size()) {
                                break;
                            }
                            if (RecyclerInfiniteAdapter.this.itemArrayListOriginal.get(i).presenterIsSelected) {
                                RecyclerInfiniteAdapter.this.lastSelectedPosition = i;
                                break;
                            }
                            i++;
                        }
                    }
                    RecyclerInfiniteAdapter recyclerInfiniteAdapter2 = RecyclerInfiniteAdapter.this;
                    if (recyclerInfiniteAdapter2.lastSelectedPosition < 0) {
                        recyclerInfiniteAdapter2.lastSelectedPosition = 0;
                    }
                    int size = recyclerInfiniteAdapter2.itemArrayList.size();
                    RecyclerInfiniteAdapter recyclerInfiniteAdapter3 = RecyclerInfiniteAdapter.this;
                    int i2 = recyclerInfiniteAdapter3.lastSelectedPosition;
                    if (size > i2 && !recyclerInfiniteAdapter3.isMultiSelection) {
                        recyclerInfiniteAdapter3.itemArrayList.get(i2).presenterIsSelected = false;
                        RecyclerInfiniteAdapter.this.notifyDataSetChanged();
                    }
                    RecyclerInfiniteAdapter recyclerInfiniteAdapter4 = RecyclerInfiniteAdapter.this;
                    if (!recyclerInfiniteAdapter4.isMultiSelection) {
                        abstractViewHolder.item.presenterIsSelected = true;
                    } else if (!recyclerInfiniteAdapter4.itemSelectedMap.containsKey(abstractViewHolder.item.getIdentitySrting())) {
                        RecyclerInfiniteAdapter.this.itemSelectedMap.put(abstractViewHolder.item.getIdentitySrting(), abstractViewHolder.item);
                        abstractViewHolder.item.presenterIsSelected = true;
                    } else {
                        RecyclerInfiniteAdapter.this.itemSelectedMap.remove(abstractViewHolder.item.getIdentitySrting());
                        abstractViewHolder.item.presenterIsSelected = false;
                    }
                    RecyclerInfiniteAdapter recyclerInfiniteAdapter5 = RecyclerInfiniteAdapter.this;
                    recyclerInfiniteAdapter5.lastSelectedPosition = recyclerInfiniteAdapter5.itemArrayListOriginal.indexOf(abstractViewHolder.item);
                    RecyclerInfiniteAdapter.this.notifyDataSetChanged();
                }
                OnPresenterItemClickListener onPresenterItemClickListener = RecyclerInfiniteAdapter.this.mClickListener;
                if (onPresenterItemClickListener != null) {
                    onPresenterItemClickListener.onClick(abstractViewHolder);
                }
            }
        };
        this.isLoadMoreAuto = mainAdapter.isLoadMoreAuto;
        this.isSaveSelected = mainAdapter.isSaveSelected;
        this.isMultiSelection = mainAdapter.isMultiSelection;
        this.isSavePosition = mainAdapter.isSavePosition;
        this.isWantLoadMore = mainAdapter.isWantLoadMore;
        this.biasFromFirst = mainAdapter.biasFromFirst;
    }

    @Override // ir.resaneh1.iptv.presenter.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i % this.itemArrayList.size();
    }

    @Override // ir.resaneh1.iptv.presenter.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.itemArrayList.get(i % this.itemArrayList.size()).getPresenterType().ordinal();
    }

    @Override // ir.resaneh1.iptv.presenter.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolderOnCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        viewHolderOnCreateViewHolder.itemView.setOnClickListener(this.onClickListener);
        return viewHolderOnCreateViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i % this.itemArrayList.size());
    }
}
