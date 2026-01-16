package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.TabObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class SearchTabPresenter extends AbstractPresenter<TabObject, MyViewHolder> {
    Context mContext;

    public SearchTabPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.search_tab_cell, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, TabObject tabObject) {
        super.onBindViewHolder((SearchTabPresenter) myViewHolder, (MyViewHolder) tabObject);
        myViewHolder.textView.setText(tabObject.title);
        GlideHelper.load(this.context, myViewHolder.imageView, tabObject.image_url);
        if (tabObject.presenterIsSelected) {
            myViewHolder.textView.setTextColor(this.mContext.getResources().getColor(R.color.grey_900));
            myViewHolder.imageView.setColorFilter(ContextCompat.getColor(this.context, R.color.grey_900), PorterDuff.Mode.MULTIPLY);
        } else {
            myViewHolder.textView.setTextColor(this.mContext.getResources().getColor(R.color.grey_600));
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TabObject> {
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(SearchTabPresenter searchTabPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
