package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.NewsObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class NewsAdverOrEventRowPresenter extends AbstractPresenter<NewsObject, MyViewHolder> {
    Context mContext;

    public NewsAdverOrEventRowPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.news_adver_or_event_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, NewsObject newsObject) {
        super.onBindViewHolder((NewsAdverOrEventRowPresenter) myViewHolder, (MyViewHolder) newsObject);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<NewsObject> {
        public MyViewHolder(NewsAdverOrEventRowPresenter newsAdverOrEventRowPresenter, View view) {
            super(view);
        }
    }
}
