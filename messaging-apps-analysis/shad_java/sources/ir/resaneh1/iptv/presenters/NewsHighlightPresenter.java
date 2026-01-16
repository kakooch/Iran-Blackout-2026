package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.NewsHighlightObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class NewsHighlightPresenter extends AbstractPresenter<NewsHighlightObject, ViewHolder> {
    public NewsHighlightPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.news_highlight_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, NewsHighlightObject newsHighlightObject) {
        super.onBindViewHolder((NewsHighlightPresenter) viewHolder, (ViewHolder) newsHighlightObject);
        viewHolder.textView.setText(newsHighlightObject.title);
        GlideHelper.load(this.context, viewHolder.imageView, newsHighlightObject.imageUrl, R.color.grey_500);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<NewsHighlightObject> {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
