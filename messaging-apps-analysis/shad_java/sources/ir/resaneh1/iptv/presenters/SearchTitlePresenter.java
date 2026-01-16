package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.SearchTitleObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class SearchTitlePresenter extends AbstractPresenter<SearchTitleObject, ViewHolder> {
    public SearchTitlePresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.row_search_title, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, SearchTitleObject searchTitleObject) {
        super.onBindViewHolder((SearchTitlePresenter) viewHolder, (ViewHolder) searchTitleObject);
        viewHolder.textView1.setText(searchTitleObject.text);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<SearchTitleObject> {
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView);
        }
    }
}
