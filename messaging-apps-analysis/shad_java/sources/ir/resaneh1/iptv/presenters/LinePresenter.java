package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.LineItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class LinePresenter extends AbstractPresenter<LineItem, MyViewHolder> {
    Context mContext;

    public LinePresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.line_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, LineItem lineItem) {
        super.onBindViewHolder((LinePresenter) myViewHolder, (MyViewHolder) lineItem);
        if (lineItem.color != 0) {
            myViewHolder.line.setBackgroundColor(this.mContext.getResources().getColor(lineItem.color));
        } else {
            myViewHolder.line.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_500));
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<LineItem> {
        public View line;

        public MyViewHolder(LinePresenter linePresenter, View view) {
            super(view);
            this.line = view.findViewById(R.id.line);
        }
    }
}
