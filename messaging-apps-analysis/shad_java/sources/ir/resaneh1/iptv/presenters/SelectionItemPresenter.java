package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class SelectionItemPresenter extends AbstractPresenter<PresenterItem, MyViewHolder> {
    Context mContext;

    public SelectionItemPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.selection_item_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, PresenterItem presenterItem) {
        super.onBindViewHolder((SelectionItemPresenter) myViewHolder, (MyViewHolder) presenterItem);
        myViewHolder.textView.setText(presenterItem.getTitle());
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<PresenterItem> {
        public TextView textView;

        public MyViewHolder(SelectionItemPresenter selectionItemPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
