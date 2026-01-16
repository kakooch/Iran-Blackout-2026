package ir.resaneh1.iptv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class SearchPresenter extends AbstractPresenter<PresenterItem, ViewHolder> {
    public SearchPresenter(Context context) {
        super(context);
        DimensionHelper.dpToPx(context, 8.0f);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.row_search, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, PresenterItem presenterItem) {
        super.onBindViewHolder((SearchPresenter) viewHolder, (ViewHolder) presenterItem);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<PresenterItem> {
        public EditText searchEditText;

        public ViewHolder(View view) {
            super(view);
            this.searchEditText = (EditText) view.findViewById(R.id.editTextSearch);
        }
    }
}
