package ir.resaneh1.iptv.presenter.abstracts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter.AbstractViewHolder;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes.dex */
public abstract class AbstractPresenter<Titem extends PresenterItem, TviewHolder extends AbstractViewHolder<Titem>> {
    protected Context context;
    public boolean isSpan = true;

    public abstract TviewHolder onCreateViewHolder(ViewGroup viewGroup);

    public void onViewRecycled(TviewHolder tviewholder) {
    }

    public AbstractPresenter(Context context) {
        this.context = context;
    }

    public void onBindViewHolder(TviewHolder tviewholder, Titem titem) {
        tviewholder.item = titem;
        ViewGroup.LayoutParams layoutParams = tviewholder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            MyLog.e("staggeredGrid", "onBindViewHolder: ");
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            layoutParams2.setFullSpan(this.isSpan);
            tviewholder.itemView.setLayoutParams(layoutParams2);
        }
    }

    public TviewHolder createViewHolderAndBind(Titem titem) {
        TviewHolder tviewholder = (TviewHolder) onCreateViewHolder(null);
        onBindViewHolder(tviewholder, titem);
        return tviewholder;
    }

    public static class AbstractViewHolder<Titem extends PresenterItem> extends RecyclerView.ViewHolder {
        public Titem item;

        public AbstractViewHolder(View view) {
            super(view);
            view.setTag(this);
        }
    }
}
