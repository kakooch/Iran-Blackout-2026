package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.SelectableItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class SelectableRowPresenter extends AbstractPresenter<SelectableItem, MyViewHolder> {
    Context mContext;

    public SelectableRowPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.row_selectable, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, SelectableItem selectableItem) {
        super.onBindViewHolder((SelectableRowPresenter) myViewHolder, (MyViewHolder) selectableItem);
        myViewHolder.selectView.setClickable(false);
        myViewHolder.selectView.setFocusable(false);
        if (selectableItem.presenterIsSelected) {
            myViewHolder.selectView.setChecked(true);
        } else {
            myViewHolder.selectView.setChecked(false);
        }
        myViewHolder.textView.setText(selectableItem.text);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<SelectableItem> {
        public RadioButton selectView;
        public TextView textView;

        public MyViewHolder(SelectableRowPresenter selectableRowPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.selectView = (RadioButton) view.findViewById(R.id.selectView);
        }
    }
}
