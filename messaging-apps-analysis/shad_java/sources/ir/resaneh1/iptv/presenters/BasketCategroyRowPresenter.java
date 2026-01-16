package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class BasketCategroyRowPresenter extends AbstractPresenter<TitleObject, MyViewHolder> {
    Context mContext;

    public BasketCategroyRowPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.basket_category_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, TitleObject titleObject) {
        super.onBindViewHolder((BasketCategroyRowPresenter) myViewHolder, (MyViewHolder) titleObject);
        myViewHolder.textView.setText(titleObject.title);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TitleObject> {
        TextView textView;

        public MyViewHolder(BasketCategroyRowPresenter basketCategroyRowPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textViewTitle);
        }
    }
}
