package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.ScrollViewListObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ScrollViewListPresenter extends AbstractPresenter<ScrollViewListObject, MyViewHolder> {
    public int LIMIT;
    private Context mContext;

    public ScrollViewListPresenter(Context context) {
        super(context);
        this.LIMIT = 100;
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.context).inflate(R.layout.item_scrollview_list, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, final ScrollViewListObject scrollViewListObject) {
        super.onBindViewHolder((ScrollViewListPresenter) myViewHolder, (MyViewHolder) scrollViewListObject);
        myViewHolder.scrollView.setAdapter(new MainAdapter(this.mContext, scrollViewListObject.list, scrollViewListObject.presenterSelector, scrollViewListObject.onPresenterItemClickListener, new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.presenters.ScrollViewListPresenter.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                if (scrollViewListObject.hasLoadMore) {
                    ScrollViewListPresenter.this.loadItems(myViewHolder);
                }
            }
        }));
        if (((ScrollViewListObject) myViewHolder.item).itemHeight > 0) {
            myViewHolder.scrollView.getLayoutParams().height = scrollViewListObject.itemHeight;
            myViewHolder.itemView.getLayoutParams().height = scrollViewListObject.itemHeight;
        } else {
            myViewHolder.scrollView.getLayoutParams().height = DimensionHelper.getScreenHeight((Activity) this.mContext) - ((int) this.context.getResources().getDimension(R.dimen.toolbar_size));
        }
        if (((ScrollViewListObject) myViewHolder.item).getLastPosition() >= 0) {
            try {
                myViewHolder.scrollView.scrollToPosition(((ScrollViewListObject) myViewHolder.item).getLastPosition());
            } catch (Exception unused) {
            }
        }
        loadItems(myViewHolder);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<ScrollViewListObject> {
        private DiscreteScrollView scrollView;

        public MyViewHolder(ScrollViewListPresenter scrollViewListPresenter, View view) {
            super(view);
            DiscreteScrollView discreteScrollView = (DiscreteScrollView) view.findViewById(R.id.scrollview);
            this.scrollView = discreteScrollView;
            discreteScrollView.setItemTransitionTimeMillis(100);
        }
    }

    protected void loadItems(final MyViewHolder myViewHolder) {
        final ScrollViewListObject scrollViewListObject = (ScrollViewListObject) myViewHolder.item;
        final RecyclerView.Adapter adapter = myViewHolder.scrollView.getAdapter();
        ListInput listInput = scrollViewListObject.listInput;
        if (listInput == null || scrollViewListObject.isLoading) {
            return;
        }
        scrollViewListObject.isLoading = true;
        listInput.first_index = scrollViewListObject.list.size() + 1;
        scrollViewListObject.listInput.last_index = this.LIMIT + scrollViewListObject.list.size();
        new ItemListRequest().load(this.mContext, scrollViewListObject.listInput, new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.presenters.ScrollViewListPresenter.2
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                MyLog.e("RecyclerPresenter", "onResponse: " + arrayList.size());
                scrollViewListObject.list.addAll(arrayList);
                adapter.notifyItemRangeInserted(scrollViewListObject.list.size() - arrayList.size(), arrayList.size());
                if (arrayList.size() >= ScrollViewListPresenter.this.LIMIT) {
                    scrollViewListObject.isLoading = false;
                }
                if (((ScrollViewListObject) myViewHolder.item).getLastPosition() >= 0) {
                    myViewHolder.scrollView.scrollToPosition(((ScrollViewListObject) myViewHolder.item).getLastPosition());
                }
            }
        });
    }
}
