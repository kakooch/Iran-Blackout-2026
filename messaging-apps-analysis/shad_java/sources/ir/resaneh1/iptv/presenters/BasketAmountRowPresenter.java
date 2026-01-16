package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.BasketPriceObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class BasketAmountRowPresenter extends AbstractPresenter<BasketPriceObject, MyViewHolder> {
    Context mContext;

    public BasketAmountRowPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.basket_amount_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, BasketPriceObject basketPriceObject) {
        super.onBindViewHolder((BasketAmountRowPresenter) myViewHolder, (MyViewHolder) basketPriceObject);
        myViewHolder.textView.setText(basketPriceObject.price);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<BasketPriceObject> {
        TextView textView;

        public MyViewHolder(BasketAmountRowPresenter basketAmountRowPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textViewTitle);
        }
    }
}
